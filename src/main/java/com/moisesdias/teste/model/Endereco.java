package com.moisesdias.teste.model;

import com.moisesdias.teste.model.enums.Estado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "tb_enderecos")
public class Endereco implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String logradouro;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cep;
    private Integer numero;
    private String cidade;

    @Enumerated(EnumType.STRING)
    private Estado estado;


    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Pessoa pessoa;

}
