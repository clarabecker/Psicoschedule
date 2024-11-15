package com.psicoschedule.psicoschedule.modules.Paciente.useCases;

import java.lang.reflect.Method;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psicoschedule.psicoschedule.exceptions.UserNotFoundException;
import com.psicoschedule.psicoschedule.modules.Paciente.PacienteEntity;
import com.psicoschedule.psicoschedule.modules.Paciente.PacienteRepository;
import com.psicoschedule.psicoschedule.modules.Paciente.DTO.UpdatePacienteDTO;

@Service
public class UpdatePaciente {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional
    public PacienteEntity updatePaciente(String login, UpdatePacienteDTO updatePacienteDTO) { 
        if (updatePacienteDTO == null) {
            throw new IllegalArgumentException("UpdatePacienteDTO must not be null");
        }

        Optional<PacienteEntity> optionalPaciente = pacienteRepository.findBylogin(login);
        
        if (optionalPaciente.isPresent()) {
            PacienteEntity paciente = optionalPaciente.get();

            for (Method method : UpdatePacienteDTO.class.getDeclaredMethods()) {
                if (method.getName().startsWith("get")) {
                    try {
                        Object value = method.invoke(updatePacienteDTO);
                        if (value != null) {
                            String fieldName = method.getName().substring(3); // Remove "get"
                            String setterName = "set" + fieldName;

                            // Obtém o método setter correspondente
                            Method setter = PacienteEntity.class.getMethod(setterName, method.getReturnType());
                            setter.invoke(paciente, value); // Invoca o setter
                        }
                    } catch (NoSuchMethodException e) {
                        System.out.println("Setter not found for: " + method.getName());
                    } catch (Exception e) {
                        System.out.println("Error updating field: " + method.getName() + ", " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }

            return pacienteRepository.save(paciente); 
        } else {
            throw new UserNotFoundException();
        }
    }
}


