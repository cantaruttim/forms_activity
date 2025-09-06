package br.com.atividades.atividades.controller;

import br.com.atividades.atividades.data.dto.FormsActivitiesCollegeDTO;
import br.com.atividades.atividades.service.FormsActivitiesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/activities/v1")
public class FormsActivitiesController {

    @Autowired
    private FormsActivitiesServices service;


    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public FormsActivitiesCollegeDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<FormsActivitiesCollegeDTO> findAll() {
        return service.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public FormsActivitiesCollegeDTO create(@RequestBody FormsActivitiesCollegeDTO activity) {
        return service.create(activity);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public FormsActivitiesCollegeDTO update(@RequestBody FormsActivitiesCollegeDTO activity) {
        return service.update(activity);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(
            @PathVariable("id") Long id
    ) {
        service.delete(id);
    }
}
