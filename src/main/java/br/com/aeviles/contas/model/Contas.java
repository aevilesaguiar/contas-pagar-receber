package br.com.aeviles.contas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @Column(name = "descricao")
    @NotBlank(message = "* Preencha o campo descrição")
    private  String descricao;

    @Min(value = 1 , message = "Preencha o campo no min com o valor 1.00")
    @NotNull
    private float valor;

    @DateTimeFormat(pattern = "dd/MM/yyyy")//converte na hora de persistir a data
    @NotNull(message = "inclua a data")
    private Date data;


}
