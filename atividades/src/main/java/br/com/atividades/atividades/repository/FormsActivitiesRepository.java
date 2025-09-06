package br.com.atividades.atividades.repository;

import br.com.atividades.atividades.model.FormsActivitiesCollege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormsActivitiesRepository
        extends JpaRepository<FormsActivitiesCollege, Long> {}
