package br.com.atividades.atividades.service;


import br.com.atividades.atividades.controller.FormsActivitiesController;
import br.com.atividades.atividades.data.dto.FormsActivitiesCollegeDTO;
import br.com.atividades.atividades.exception.ResourceNotFoundException;
import br.com.atividades.atividades.model.FormsActivitiesCollege;
import br.com.atividades.atividades.repository.FormsActivitiesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;

import static br.com.atividades.atividades.mapper.ObjectMapper.parseListObject;
import static br.com.atividades.atividades.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class FormsActivitiesServices {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = LoggerFactory.getLogger(
            FormsActivitiesServices.class.getName()
    );

    @Autowired
    FormsActivitiesRepository repository;

    public List<FormsActivitiesCollegeDTO> findAll() {
        logger.info("Finding all People!");
        return parseListObject(
                repository.findAll(),
                FormsActivitiesCollegeDTO.class
        );
    }

    public FormsActivitiesCollegeDTO findById(Long id) {
        logger.info("Finding One Activity!");

        var entity = repository.findById(id)
                        .orElseThrow(
                        // lambda funtion
                        () -> new ResourceNotFoundException(
                                "No records found for this ID"
                        )
                );
        var dto = parseObject(entity, FormsActivitiesCollegeDTO.class);
        addHateoasLinks(id, dto);
        return dto;
    }



    public FormsActivitiesCollegeDTO create(
            FormsActivitiesCollegeDTO activity
    ) {
        logger.info("Creating One Activity!");
        var entity = parseObject(activity, FormsActivitiesCollege.class);
        return parseObject(repository.save(entity), FormsActivitiesCollegeDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting One Activity!");
        FormsActivitiesCollege entity = repository
                        .findById(id)
                        .orElseThrow(
                        // lambda funtion
                        () -> new ResourceNotFoundException(
                                "No records found for this ID"
                        )
                );
        repository.delete(entity);
    }

    public FormsActivitiesCollegeDTO update(FormsActivitiesCollegeDTO activity) {
        logger.info("Updating One Activity!");

        FormsActivitiesCollege entity = repository
                .findById(activity.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setName(activity.getName());
        entity.setEmail(activity.getEmail());
        entity.setRegistrationNumber(activity.getRegistrationNumber());
        entity.setModule(activity.getModule());
        entity.setQuestionOne(activity.getQuestionOne());
        entity.setQuestionTwo(activity.getQuestionTwo());
        entity.setSentAt(activity.getSentAt());

        return parseObject(repository.save(entity), FormsActivitiesCollegeDTO.class);
    }

    private static void addHateoasLinks(Long id, FormsActivitiesCollegeDTO dto) {
        dto.add(linkTo(methodOn(FormsActivitiesController.class).findById(id)).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(FormsActivitiesController.class).findAll()).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(FormsActivitiesController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(FormsActivitiesController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(FormsActivitiesController.class).delete(id)).withRel("delete").withType("DELETE"));
    }
}
