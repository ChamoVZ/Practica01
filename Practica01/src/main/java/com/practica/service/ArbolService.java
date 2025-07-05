/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.service;

import com.practica.entity.Arbol;
import java.util.List;

/**
 *
 * @author Chuz
 */
public interface ArbolService {
    public List<Arbol> getArboles();
    public void save(Arbol arbol);
    public void delete(Arbol arbol);
    public Arbol getArbol(Arbol arbol);
}