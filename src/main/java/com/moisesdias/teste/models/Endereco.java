package com.moisesdias.teste.models;

import com.moisesdias.teste.models.enums.Estado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_enderecos")
public class Endereco implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String logradouro;
    private Integer numero;
    private String cidade;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    private Integer cep;

    private Boolean principal;


    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    public Endereco(Long id, String logradouro, Integer numero, String cidade, Estado estado, Integer cep, Boolean principal) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.principal = principal;
    }
}
