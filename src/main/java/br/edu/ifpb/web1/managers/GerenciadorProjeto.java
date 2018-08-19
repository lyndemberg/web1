package br.edu.ifpb.web1.managers;

import br.edu.ifpb.web1.dao.exceptions.PersistenciaException;
import br.edu.ifpb.web1.dao.factory.Factory;
import br.edu.ifpb.web1.dao.interfaces.FactoryDao;
import br.edu.ifpb.web1.dao.interfaces.ProjetoDao;
import br.edu.ifpb.web1.entities.Projeto;

import java.util.List;

public class GerenciadorProjeto {
    private FactoryDao factory = null;
    private ProjetoDao dao = null;

    public GerenciadorProjeto() {
        factory = Factory.createFactory();
        dao = factory.getDaoProjeto();
    }

    public Projeto buscar(Integer codigo){
        try {
            return dao.buscarPorCodigo(codigo);
        } catch (PersistenciaException e) {
            return null;
        }
    }

    public Boolean criar(String nome, String descricao){
        Projeto projeto = new Projeto();
        projeto.setNome(nome);
        projeto.setDescricao(descricao);
        projeto.setConcluido(false);
        try {
            return dao.criar(projeto);
        } catch (PersistenciaException e) {
            return false;
        }
    }

    public Boolean atualizarDados(Integer codigo, String nome, String descricao){
        Projeto projeto = new Projeto();
        projeto.setNome(nome);
        projeto.setDescricao(descricao);
        try {
            return dao.atualizar(codigo, projeto);
        } catch (PersistenciaException e) {
            return false;
        }
    }

    public Boolean finalizar(Integer codigo){
        try {
            return dao.fecharProjeto(codigo);
        } catch (PersistenciaException e) {
            return false;
        }
    }

    public List<Projeto> listarTodos(){
        try {
            return dao.listAll();
        } catch (PersistenciaException e) {
            return null;
        }
    }
}
