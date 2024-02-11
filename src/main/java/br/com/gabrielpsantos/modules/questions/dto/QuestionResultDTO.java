package br.com.gabrielpsantos.modules.questions.dto;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //A dependência Builder permitir criar um objeto sem a necessidade de instância a classe e podendo setar os valores
public class QuestionResultDTO {
    
    private UUID id;
    private String technology;
    private String description;

    private List<AlternativeResultDTO> alternatives;
}
