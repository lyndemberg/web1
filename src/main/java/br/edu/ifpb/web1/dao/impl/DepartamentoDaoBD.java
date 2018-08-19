package br.edu.ifpb.web1.dao.impl;

import br.edu.ifpb.web1.dao.connect.ConFactory;
import br.edu.ifpb.web1.dao.connect.PropertiesBD;
import br.edu.ifpb.web1.dao.exceptions.PersistenciaException;
import br.edu.ifpb.web1.dao.interfaces.DepartamentoDao;
import br.edu.ifpb.web1.entities.Departamento;

import javax.persistence.PersistenceException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDaoBD implements DepartamentoDao {

    private PropertiesBD props;
    private Connection conexao;

    public DepartamentoDaoBD() throws SQLException, ClassNotFoundException {
        this.props = new PropertiesBD();
        this.conexao = ConFactory.getConnection(props.getUrl(),props.getUser(),props.getSenha());
    }

    @Override
    public Boolean criar(Departamento novo) throws PersistenciaException {
        String sql = "INSERT INTO departamento (nome) VALUES (?)";
        try {
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, novo.getNome());
            boolean insert = statement.executeUpdate() > 0;
            conexao.close();
            return insert;
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public Departamento buscarPorId(Integer id) throws PersistenciaException {
        Departamento departamento = null;
        String sql = "SELECT id, nome FROM departamento WHERE id = ?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                departamento = new Departamento(rs.getInt("id"),rs.getString("nome"));
            }
            conexao.close();
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
        return departamento;
    }

    @Override
    public Boolean atualizar(Integer id, Departamento atualizado) throws PersistenciaException {
        String sql = "UPDATE departamento SET nome = ? WHERE id = ?";
        try {
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1,atualizado.getNome());
            st.setInt(2, id);
            boolean update = st.executeUpdate() > 0;
            conexao.close();
            return update;
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public Boolean deletar(Integer id) throws PersistenciaException {
        String sql = "DELETE FROM departamento WHERE id = ?";
        try {
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setInt(1, id);
            boolean deleted = st.executeUpdate() > 0;
            conexao.close();
            return deleted;
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public List<Departamento> listarTodos() throws PersistenciaException {
        List<Departamento> departamentos = new ArrayList<>();
        String sql = "SELECT id, nome FROM departamento";
        try {
            PreparedStatement st = conexao.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                departamentos.add(new Departamento(rs.getInt("id"),rs.getString("nome")));
            }
            conexao.close();
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
        return departamentos;
    }
}
