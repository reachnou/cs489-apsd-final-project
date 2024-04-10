package edu.mui.cs489.reachnou.questify.service;

import org.springframework.http.ResponseEntity;

public interface CRUDService<E, ID>{

    ResponseEntity<E> save(E entity);

    ResponseEntity<E> getById(ID id);

    ResponseEntity<E> deleteById(ID id);
}
