package br.com.gabrielpsantos.modules.questions.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabrielpsantos.modules.questions.dto.AlternativeResultDTO;
import br.com.gabrielpsantos.modules.questions.dto.QuestionResultDTO;
import br.com.gabrielpsantos.modules.questions.entities.AlternativesEntity;
import br.com.gabrielpsantos.modules.questions.entities.QuestionEntity;
import br.com.gabrielpsantos.modules.questions.repositories.QuestionRepository;
import lombok.var;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;
    
    @GetMapping("/technology/{technology}")
    public List<QuestionResultDTO> findByTechnology(@PathVariable String technology){
        System.out.println("TECH === " + technology);
        var result = this.questionRepository.findByTechnology(technology);

        List<QuestionResultDTO> toMap = result.stream().map(question -> mapQuestionToDTO(question)).collect(Collectors.toList());
        return toMap;
    }

    static QuestionResultDTO mapQuestionToDTO(QuestionEntity question){
        var questionResultDTO = QuestionResultDTO.builder()
        .id(question.getId())
        .technology(question.getTechnology())
        .description(question.getDescription()).build();

        List<AlternativeResultDTO> alternativeResultDTOs = 
        question.getAlternatives().stream().map(alternative -> mapAlternativeDTO(alternative))
        .collect(Collectors.toList());

        questionResultDTO.setAlternatives(alternativeResultDTOs);
        return questionResultDTO;
    }

    static AlternativeResultDTO mapAlternativeDTO(AlternativesEntity alternativeResultDTO){
        return AlternativeResultDTO.builder()
        .id(alternativeResultDTO.getId())
        .description(alternativeResultDTO.getDescription()).build();
    }
}
