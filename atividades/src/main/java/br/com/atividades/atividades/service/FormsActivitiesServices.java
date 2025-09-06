package br.com.atividades.atividades.service;


import br.com.atividades.atividades.data.dto.FormsActivitiesCollegeDTO;
import br.com.atividades.atividades.exception.ResourceNotFoundException;
import br.com.atividades.atividades.model.FormsActivitiesCollege;
import br.com.atividades.atividades.repository.FormsActivitiesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;

import static br.com.atividades.atividades.mapper.ObjectMapper.parseListObject;
import static br.com.atividades.atividades.mapper.ObjectMapper.parseObject;

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
        return parseObject(entity, FormsActivitiesCollegeDTO.class);
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


}
