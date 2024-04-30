package com.avaliacao.avaliacao.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Turma")
@Entity
@EqualsAndHashCode(of = "id_turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int ano;
    private int semestre;
    private int diaSemana;
    private String horarios;

    public void abrirTurma(){}
    public void alocarProfessor(){}
    public void matricularAluno(){}
    public void emitirDiario(){}

    @ManyToOne
    @JoinColumn(name = "professor_id", referencedColumnName = "id")
    private Professor professor;

    @OneToOne
    @JoinColumn(name = "codigo", referencedColumnName = "codigo")
    private Disciplina disciplina;

    @ManyToMany
    @JoinTable(
            name = "turma_aluno",
            joinColumns = @JoinColumn(name = "turma_id", referencedColumnName = "id_turma"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    private Set<Aluno> alunos = new HashSet<>();
}
