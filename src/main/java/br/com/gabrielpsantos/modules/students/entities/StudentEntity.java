package br.com.gabrielpsantos.modules.students.entities;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //Cria um construtor com todos os atributos
@NoArgsConstructor //Cria um construtor vázio
public class StudentEntity {
    
    private UUID id;
    private String email;
    private List<CertificationStudentEntity> certificationStudentEntity;
}
