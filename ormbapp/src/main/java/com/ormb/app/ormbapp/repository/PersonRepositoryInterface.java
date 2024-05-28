package com.ormb.app.ormbapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ormb.app.ormbapp.entities.Person;

@Repository
public interface PersonRepositoryInterface extends JpaRepository<Person, Long>{

  

    

}
