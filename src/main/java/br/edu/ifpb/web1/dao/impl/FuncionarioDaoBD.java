package br.edu.ifpb.web1.dao.impl;

import br.edu.ifpb.web1.dao.connect.ConFactory;
import br.edu.ifpb.web1.dao.connect.PropertiesBD;
import br.edu.ifpb.web1.dao.exceptions.PersistenciaException;
import br.edu.ifpb.web1.dao.interfaces.FuncionarioDao;
import br.edu.ifpb.web1.entities.Funcionario;

import javax.persistence.PersistenceException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDaoBD implements FuncionarioDao {

    private PropertiesBD props;
    private Connection conexao;

    public FuncionarioDaoBD() throws SQLException, ClassNotFoundException {
        this.props = new PropertiesBD();
        this.conexao = ConFactory.getConnection(props.getUrl(),props.getUser(),props.getSenha());
    }

    @Override
    public Boolean criar(Funcionario novo) throws PersistenciaException {
        String sql = "INSERT INTO funcionario (nome, foto, email, telefone1, telefone2, departamento_id) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1,novo.getNome());
            st.setBytes(2, novo.getFoto());
            st.setString(3, novo.getEmail());
            st.setString(4, novo.getTelefone1());
            st.setString(5, novo.getTelefone2());
            st.setInt(6, novo.getDepartamento_id());
            boolean inserted = st.executeUpdate() > 0;
            conexao.close();
            return inserted;
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public Funcionario buscarPorMatricula(Integer matricula) throws PersistenciaException {
        Funcionario funcionario = null;
        String sql = "SELECT matricula, nome, foto, email, telefone1,telefone2, departamento_id FROM funcionario WHERE matricula = ?";
        try {
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setInt(1, matricula);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                Integer matricula1 = rs.getInt("matricula");
                String nome = rs.getString("nome");
                byte[] foto = rs.getBytes("foto");
                String email = rs.getString("email");
                String telefone1 = rs.getString("telefone1");
                String telefone2 = rs.getString("telefone2");
                int departamento_id = rs.getInt("departamento_id");
                funcionario = new Funcionario(matricula1,foto,nome,email,departamento_id,telefone1,telefone2);
            }
            conexao.close();
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
        return funcionario;
    }

    @Override
    public Boolean atualizarDados(Integer matricula, Funcionario atualizado) throws PersistenciaException {
        String sql = "UPDATE funcionario SET nome=?,email=?,telefone1=?,telefone2=?,departamento_id=? WHERE matricula=?";
        try {
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1, atualizado.getNome());
            st.setString(2, atualizado.getEmail());
            st.setString(3, atualizado.getTelefone1());
            st.setString(4, atualizado.getTelefone2());
            st.setInt(5, atualizado.getDepartamento_id());
            st.setInt(6, matricula);
            boolean updated = st.executeUpdate() > 0;
            conexao.close();
            return updated;
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public Boolean atualizarFotoPerfil(Integer matricula, byte[] fotoNova) throws PersistenciaException {
        String sql = "UPDATE funcionario SET foto=? WHERE matricula=?";
        try {
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setBytes(1, fotoNova);
            st.setInt(2, matricula);
            boolean updated = st.executeUpdate() > 0;
            conexao.close();
            return updated;
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public Boolean deletar(Integer matricula) throws PersistenciaException {
        String sql = "DELETE FROM funcionario WHERE id=?";
        try {
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setInt(1, matricula);
            boolean deleted = st.executeUpdate() > 0;
            conexao.close();
            return deleted;
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public List<Funcionario> listarFuncionariosDepartamento(Integer id) throws PersistenciaException {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT matricula, nome, foto, email, telefone1,telefone2, departamento_id FROM funcionario WHERE departamento_id = ?";
        try {
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Integer matricula = rs.getInt("matricula");
                String nome = rs.getString("nome");
                byte[] foto = rs.getBytes("foto");
                String email = rs.getString("email");
                String telefone1 = rs.getString("telefone1");
                String telefone2 = rs.getString("telefone2");
                int departamento_id = rs.getInt("departamento_id");
                Funcionario funcionario = new Funcionario(matricula,foto,nome,email,departamento_id,telefone1,telefone2);
                funcionarios.add(funcionario);
            }
            conexao.close();
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
        return funcionarios;
    }

    @Override
    public List<Funcionario> buscarPorNome(String busca) throws PersistenciaException {
        List<Funcionario> resultados = new ArrayList<>();
        String sql = "SELECT matricula, nome, foto, email, telefone1,telefone2, departamento_id FROM funcionario" +
                " WHERE nome ILIKE '" + busca + "%'";
        try {
            PreparedStatement st = conexao.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Integer matricula = rs.getInt("matricula");
                String nome = rs.getString("nome");
                byte[] foto = rs.getBytes("foto");
                String email = rs.getString("email");
                String telefone1 = rs.getString("telefone1");
                String telefone2 = rs.getString("telefone2");
                int departamento_id = rs.getInt("departamento_id");
                resultados.add(new Funcionario(matricula,foto,nome,email,departamento_id,telefone1,telefone2));
            }
            conexao.close();
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
        return resultados;
    }
}
