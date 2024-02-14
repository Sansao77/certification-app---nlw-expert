package br.com.gabrielpsantos.modules.students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabrielpsantos.modules.students.dto.StudentCertificationAnswerDTO;
import br.com.gabrielpsantos.modules.students.dto.VerifyHasCertificationDTO;
import br.com.gabrielpsantos.modules.students.useCases.StudentCertificationAnswersUseCase;
import br.com.gabrielpsantos.modules.students.useCases.VerifyifHasCertificationUseCase;

@RestController
@RequestMapping("/students")
public class StudentController {

    //Preciso usar o meu UseCase
    @Autowired //Para o spring instânciar o useCase, como se estivesse dando um new
    private VerifyifHasCertificationUseCase verifyifHasCertificationUseCase;

    @Autowired
    private StudentCertificationAnswersUseCase studentCertificationAnsewrsUseCase;
    
    @PostMapping("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO){
        //Email
        //Technology
        var result = this.verifyifHasCertificationUseCase.execute(verifyHasCertificationDTO);
        if(result){
            return "Usuário já fez a prova";
        }
        return "Usuário pode fazer a prova";
    }
    
    @PostMapping("/certification/answer")
    public ResponseEntity<Object> certificationAnswer(@RequestBody StudentCertificationAnswerDTO studentCertificationAnswerDTO){
        try {
            var result = this.studentCertificationAnsewrsUseCase.execute(studentCertificationAnswerDTO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
