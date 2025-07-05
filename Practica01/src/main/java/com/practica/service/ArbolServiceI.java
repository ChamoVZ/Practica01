package com.practica.service;

import com.practica.entity.Arbol; 
import com.practica.repository.ArbolRepository; 

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArbolServiceI implements ArbolService {

    @Autowired
    private ArbolRepository arbolRepository;

    @Override
    @Transactional(readOnly = true) 
    public List<Arbol> getArboles() {
        return arbolRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Arbol arbol) {
        arbolRepository.save(arbol);
    }

    @Override
    @Transactional
    public void delete(Arbol arbol) {
        arbolRepository.delete(arbol); 
    }

    @Override
    @Transactional(readOnly = true) 
    public Arbol getArbol(Arbol arbol) {
        return arbolRepository.findById(arbol.getIdArbol()).orElse(null);
    }
}