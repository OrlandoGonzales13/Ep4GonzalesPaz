package com.example.Ep4GonzalesPaz.service;

import com.example.Ep4GonzalesPaz.entity.Visitas;
import com.example.Ep4GonzalesPaz.exception.VisitasNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.Ep4GonzalesPaz.repository.VisitasRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class VisitasService {

    private final VisitasRepository visitasRepository;

    public List<Visitas> obtenerTodos(){
        return visitasRepository.findAll();
    }

    public Visitas obtenerporId(Long id){
        Optional<Visitas> optionalVisitas = visitasRepository.findById(id);
        if (optionalVisitas.isPresent()){
            return optionalVisitas.get();
        }else{
            throw new VisitasNotFoundException(id);
        }
    }

    public Visitas registrar(Visitas visitas){
        return visitasRepository.save(visitas);
    }

    public void actualizar(Visitas visitas) {
        Visitas visitasExistente = obtenerporId(visitas.getId());
        visitasExistente.setLocal(visitas.getLocal());
        visitasExistente.setDni(visitas.getDni());
        visitasRepository.save(visitasExistente);
    }

    public void eliminar(Long id){

        Optional<Visitas> optionalVisitas = visitasRepository.findById(id);

        if (optionalVisitas.isPresent()){
            visitasRepository.delete(optionalVisitas.get());
        }else{
            throw new VisitasNotFoundException(id);
        }

    }
}
