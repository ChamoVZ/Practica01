package com.practica.controller;

import com.practica.entity.Arbol; // Asegúrate de que esta ruta sea correcta para tu clase Arbol
import com.practica.service.ArbolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/arboles")
public class ArbolController {

    @Autowired
    private ArbolService arbolService;

    @GetMapping("/")
    public String listado(Model model) {
        var arboles = arbolService.getArboles();
        model.addAttribute("arboles", arboles);
        
        
        model.addAttribute("contenido", "arboles/listado"); 
        
        return "fragments/layout"; 
    }

    @GetMapping("/nuevo")
    public String nuevoArbol(Arbol arbol, Model model) {
        model.addAttribute("arbol", arbol);
        
      
        model.addAttribute("contenido", "arboles/modifica");
        
      
        return "fragments/layout";
    }

    @PostMapping("/guardar")
    public String guardarArbol(Arbol arbol, @RequestParam("imagenFile") MultipartFile imagenFile) {
        arbolService.save(arbol);
        return "redirect:/arboles/";
    }

    @GetMapping("/modificar/{idArbol}")
    public String modificarArbol(Arbol arbol, Model model) {
        arbol = arbolService.getArbol(arbol); 
        model.addAttribute("arbol", arbol);
        
        
        model.addAttribute("contenido", "arboles/modifica");
        
      
        return "fragments/layout";
    }

    @GetMapping("/eliminar/{idArbol}")
    public String eliminarArbol(Arbol arbol) {
        arbolService.delete(arbol);
        return "redirect:/arboles/";
    }
}