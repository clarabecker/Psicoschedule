package com.psicoschedule.psicoschedule.modules.Profissional.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psicoschedule.psicoschedule.exceptions.UserNotFoundException;
import com.psicoschedule.psicoschedule.modules.Profissional.entities.ProfissionalEntity;
import com.psicoschedule.psicoschedule.modules.Profissional.repositories.ProfissionalRepository;
import com.psicoschedule.psicoschedule.modules.Profissional.DTO.UpdateProfissionalDTO;

import java.lang.reflect.Method;
import java.util.Optional;

@Service
public class UpdateProfissional{

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Transactional
    public ProfissionalEntity updateProfissional(String login, UpdateProfissionalDTO updateProfissionalDTO) {
        if (updateProfissionalDTO == null) {
            throw new IllegalArgumentException("UpdatePacienteDTO must not be null");
        }

        Optional<ProfissionalEntity> optionalProfissional = profissionalRepository.findBylogin(login);
        
        if (optionalProfissional.isPresent()) {
            ProfissionalEntity profissional = optionalProfissional.get();

            for (Method method : UpdateProfissionalDTO.class.getDeclaredMethods()) {
                if (method.getName().startsWith("get")) {
                    try {
                        Object value = method.invoke(updateProfissionalDTO);
                        if (value != null) {
                            String fieldName = method.getName().substring(3); // Remove "get"
                            String setterName = "set" + fieldName;

                            // Obtém o método setter correspondente
                            Method setter = ProfissionalEntity.class.getMethod(setterName, method.getReturnType());
                            setter.invoke(profissional, value); // Invoca o setter
                        }
                    } catch (NoSuchMethodException e) {
                        System.out.println("Setter not found for: " + method.getName());
                    } catch (Exception e) {
                        System.out.println("Error updating field: " + method.getName() + ", " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }

            // Salva as alterações
            return profissionalRepository.save(profissional);
        } else {
            throw new UserNotFoundException();
        }
    }
}
