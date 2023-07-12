package com.example.Ep4GonzalesPaz.controller;

import com.example.Ep4GonzalesPaz.entity.Visitas;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.Ep4GonzalesPaz.service.VisitasService;

@AllArgsConstructor
@Controller
@RequestMapping("/visitas")
public class VisitasController {

    private final VisitasService visitasService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("visitas", visitasService.obtenerTodos());
        return "visitas/index";
    }

    @PostMapping("")
    public  String registrar(@ModelAttribute("visitas") @DateTimeFormat(pattern = "yyyy-MM-dd") Visitas visitas){
        try {
            visitasService.registrar(visitas);
        }catch (DataIntegrityViolationException e){
            return "visitas/error";
        }
        return "redirect:/visitas";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam Long id, Model model){
        model.addAttribute("visitas", visitasService.obtenerporId(id));
        return "/visitas/editar";
    }

    @PostMapping("/editar")
    public String actualizar(@ModelAttribute("visitas") Visitas visitas) {
        visitasService.actualizar(visitas);
        return "redirect:/visitas";
    }
    @DeleteMapping("/eliminar")
    public String eliminar(@RequestParam("id") Long id){
        visitasService.eliminar(id);
        return "redirect:/visitas";
    }
}
