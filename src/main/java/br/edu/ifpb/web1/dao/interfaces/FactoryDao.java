package br.edu.ifpb.web1.dao.interfaces;


public interface FactoryDao {
    DepartamentoDao getDaoDepartamento();
    FuncionarioDao getDaoFuncionario();
    ProjetoDao getDaoProjeto();
    AlocacaoDao getDaoAlocacao();
}
