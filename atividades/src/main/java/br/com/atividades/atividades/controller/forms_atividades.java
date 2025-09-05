package br.com.atividades.atividades.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class forms_atividades {

    @GetMapping("/cadastrar")
    public String texto() {
        return "retornando atividades";
    }


}
