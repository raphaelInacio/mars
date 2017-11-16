package com.br.contaaazul.mars.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.contaaazul.mars.domain.Robo;

@Repository
public interface RoboRepository extends CrudRepository<Robo, Long> {
}
