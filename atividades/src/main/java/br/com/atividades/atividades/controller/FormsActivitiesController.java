package br.com.atividades.atividades.controller;


import br.com.atividades.atividades.model.FormsActivitiesCollege;
import br.com.atividades.atividades.service.FormsActivitiesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activities/v1")
public class FormsActivitiesController {

    @Autowired
    private FormsActivitiesServices service;

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public FormsActivitiesCollege findById(
            @PathVariable("id") Long id
    ) {
        return service.findById(id);
    }

}
