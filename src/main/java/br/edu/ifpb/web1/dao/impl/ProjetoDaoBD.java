package br.edu.ifpb.web1.dao.impl;

import br.edu.ifpb.web1.dao.connect.ConFactory;
import br.edu.ifpb.web1.dao.connect.PropertiesBD;
import br.edu.ifpb.web1.dao.exceptions.PersistenciaException;
import br.edu.ifpb.web1.dao.interfaces.ProjetoDao;
import br.edu.ifpb.web1.entities.Projeto;

import javax.persistence.PersistenceException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDaoBD implements ProjetoDao {

    private PropertiesBD props;
    private Connection conexao;

    public ProjetoDaoBD() throws SQLException, ClassNotFoundException {
        this.props = new PropertiesBD();
        this.conexao = ConFactory.getConnection(props.getUrl(),props.getUser(),props.getSenha());
    }


    @Override
    public Boolean criar(Projeto novo) throws PersistenciaException {
        String sql = "INSERT INTO projeto (nome, descricao, concluido) VALUES (?,?,?)";
        try {
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1,novo.getNome());
            st.setString(2, novo.getDescricao());
            st.setBoolean(3, novo.getConcluido());
            boolean inserted = st.executeUpdate() > 0;
            conexao.close();
            return inserted;

        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public Projeto buscarPorCodigo(Integer codigo) throws PersistenciaException {
        Projeto projeto = null;
        String sql = "SELECT codigo, nome, descricao, concluido FROM projeto WHERE codigo = ?";
        try {
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setLong(1, codigo);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                projeto = new Projeto(rs.getInt("codigo"),rs.getString("nome"),rs.getString("descricao"),rs.getBoolean("concluido"));
            }
            conexao.close();
            return projeto;
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public Boolean atualizar(Integer codigo, Projeto atualizado) throws PersistenciaException {
        String sql = "UPDATE projeto SET nome=?,descricao=? WHERE codigo = ?";
        try {
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1, atualizado.getNome());
            st.setString(2, atualizado.getDescricao());
            st.setInt(3, codigo);
            boolean updated = st.executeUpdate() > 0;
            conexao.close();
            return updated;
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public Boolean fecharProjeto(Integer codigo) throws PersistenciaException {
        String sql = "UPDATE projeto SET concluido=true WHERE codigo=?";
        try {
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setInt(1,codigo);
            boolean updated = st.executeUpdate() > 0;
            conexao.close();
            return updated;
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public List<Projeto> listAll() throws PersistenciaException {
        List<Projeto> list = new ArrayList<>();
        String sql = "SELECT codigo, nome, descricao, concluido FROM projeto";
        try {
            PreparedStatement st = conexao.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
               Projeto projeto = new Projeto(rs.getInt("codigo"),rs.getString("nome"),rs.getString("descricao"),rs.getBoolean("concluido"));
               list.add(projeto);
            }
            conexao.close();
        } catch (SQLException e) {
            throw new PersistenciaException(e);
        }
        return list;
    }
}
