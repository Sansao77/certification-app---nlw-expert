package br.com.gabrielpsantos.modules.students.dto;
/*
 * Só para explicar, um DTO (Data Transfer Object) serve para transferir informações necessárias
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifyHasCertificationDTO {
    private String email;
    private String technology;
}
