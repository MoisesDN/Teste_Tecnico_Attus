package com.moisesdias.teste.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_usuario")
public class Pessoa implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant dataDeNascimento;

    @JsonIgnore
    @OneToMany(mappedBy = "pessoa")
    private List<Endereco> enderecos = new ArrayList<>();

    public Pessoa(Long id, String nome, Instant dataDeNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }
}
