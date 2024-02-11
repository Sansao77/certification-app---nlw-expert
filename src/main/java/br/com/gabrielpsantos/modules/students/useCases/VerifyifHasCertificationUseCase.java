package br.com.gabrielpsantos.modules.students.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabrielpsantos.modules.students.dto.VerifyHasCertificationDTO;
import br.com.gabrielpsantos.modules.students.repositories.CertificationStudentRepository;

@Service
public class VerifyifHasCertificationUseCase {

    @Autowired
    private CertificationStudentRepository certificationStudentRepository;
    
    public boolean execute(VerifyHasCertificationDTO dto){
        var result = this.certificationStudentRepository.findByStudentEmailAndTechnology(dto.getEmail(), dto.getTechnology());
        if(!result.isEmpty()){
            return true;
        }
        return false;
    }
}
