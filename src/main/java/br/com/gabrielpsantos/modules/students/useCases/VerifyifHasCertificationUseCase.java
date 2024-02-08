package br.com.gabrielpsantos.modules.students.useCases;

import org.springframework.stereotype.Service;

import br.com.gabrielpsantos.modules.students.dto.VerifyHasCertificationDTO;

@Service
public class VerifyifHasCertificationUseCase {
    
    public boolean execute(VerifyHasCertificationDTO dto){
        if(dto.getEmail().equals("gabrielp_santos@hotmail.com") && dto.getTechnology().equals("JAVA")){
            return true;
        }
        return false;
    }
}
