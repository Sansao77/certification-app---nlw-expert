package br.com.gabrielpsantos.modules.students.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //Cria um construtor com todos os atributos
@NoArgsConstructor //Cria um construtor vázio
@Entity(name = "students") //Serve para configurar os dados em uma tabela 'students' para o banco de dados
@Builder
public class StudentEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String email;
    
    /*
     * OneToOne - um para um
     * OneToMany - um para muitos (um estudante para muitas certificações)
     * ManyToOne - muitos para um
     * ManyToMany - muitos para muitos
     */
    
    @OneToMany(mappedBy = "studentEntity")
    @JsonBackReference
    private List<CertificationStudentEntity> certificationStudentEntity;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
