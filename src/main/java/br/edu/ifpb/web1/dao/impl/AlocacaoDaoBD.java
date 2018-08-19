package br.edu.ifpb.web1.dao.impl;

import br.edu.ifpb.web1.dao.connect.ConFactory;
import br.edu.ifpb.web1.dao.connect.PropertiesBD;
import br.edu.ifpb.web1.dao.exceptions.PersistenciaException;
import br.edu.ifpb.web1.dao.interfaces.AlocacaoDao;
import br.edu.ifpb.web1.entities.Funcionario;
import br.edu.ifpb.web1.entities.Projeto;
import br.edu.ifpb.web1.entities.Alocacao;

import javax.persistence.PersistenceException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlocacaoDaoBD implements AlocacaoDao {

    private PropertiesBD props;
    private Connection conexao;

    public AlocacaoDaoBD() throws SQLException, ClassNotFoundException {
        this.props = new PropertiesBD();
        this.conexao = ConFactory.getConnection(props.getUrl(),props.getUser(),props.getSenha());
    }

    @Override
    public Boolean criar(Alocacao trabalhaProjeto) throws PersistenciaException {
        String sql = "INSERT INTO alocacao (codigo_projeto, matricula_funcionario) VALUES (?,?)";
        try {
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setInt(1, trabalhaProjeto.getCodigo_projeto());
            st.setInt(2, trabalhaProjeto.getMatricula_funcionario());
            boolean inserted = st.executeUpdate() > 0;
            conexao.close();
            return inserted;
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
    }


    @Override
    public Boolean deletar(Alocacao trabalhaProjeto) throws PersistenciaException {
        String sql = "DELETE FROM alocacao WHERE codigo_projeto=? AND matricula_funcionario=?";
        try {
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setInt(1, trabalhaProjeto.getCodigo_projeto());
            st.setInt(2, trabalhaProjeto.getMatricula_funcionario());
            boolean deleted = st.executeUpdate() > 0;
            conexao.close();
            return deleted;
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }

    }

    @Override
    public List<Projeto> listarProjetosFuncionario(Integer matricula) throws PersistenciaException {
        List<Projeto> projetos = new ArrayList<>();
        String sql = "SELECT p.codigo as codigo, p.nome as nome, p.descricao as descricao, p.concluido as concluido " +
                "FROM alocacao a, projeto p WHERE a.matricula_funcionario=? " +
                "AND p.codigo=a.codigo_projeto";
        try {
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setInt(1,matricula);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Projeto projeto = new Projeto(rs.getInt("codigo"), rs.getString("nome"), rs.getString("descricao"), rs.getBoolean("concluido"));
                projetos.add(projeto);
            }
            conexao.close();
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
        return projetos;
    }

    @Override
    public List<Funcionario> alocadosEmProjeto(Integer projeto) throws PersistenciaException {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT f.matricula as matricula, f.nome as nome, f.foto as foto, " +
                "f.email as email, f.telefone1 as telefone1,f.telefone2 as telefone2, " +
                "f.departamento_id as departamento_id " +
                "FROM alocacao a, funcionario f WHERE a.codigo_projeto = ? " +
                "AND f.matricula=a.matricula_funcionario";
        try {
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setInt(1, projeto);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Integer matricula = rs.getInt("matricula");
                String nome = rs.getString("nome");
                byte[] foto = rs.getBytes("foto");
                String email = rs.getString("email");
                String telefone1 = rs.getString("telefone1");
                String telefone2 = rs.getString("telefone2");
                int departamento_id = rs.getInt("departamento_id");
                funcionarios.add(new Funcionario(matricula,foto,nome,email,departamento_id,telefone1,telefone2));
            }
            conexao.close();
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }


        return funcionarios;
    }
}
