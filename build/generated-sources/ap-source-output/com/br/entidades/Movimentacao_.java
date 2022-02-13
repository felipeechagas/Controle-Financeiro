package com.br.entidades;

import com.br.entidades.Categoria;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-02-12T20:52:46", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Movimentacao.class)
public class Movimentacao_ { 

    public static volatile SingularAttribute<Movimentacao, String> observacao;
    public static volatile SingularAttribute<Movimentacao, String> telefone;
    public static volatile SingularAttribute<Movimentacao, Date> data;
    public static volatile SingularAttribute<Movimentacao, Double> valor;
    public static volatile SingularAttribute<Movimentacao, String> endereço;
    public static volatile SingularAttribute<Movimentacao, String> cpf;
    public static volatile SingularAttribute<Movimentacao, String> nome;
    public static volatile SingularAttribute<Movimentacao, Integer> idMovimentacao;
    public static volatile SingularAttribute<Movimentacao, String> cnpj;
    public static volatile SingularAttribute<Movimentacao, Integer> contas;
    public static volatile SingularAttribute<Movimentacao, Categoria> idCategoria;
    public static volatile SingularAttribute<Movimentacao, Date> dataCadastro;

}