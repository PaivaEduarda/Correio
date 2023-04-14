package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;
public class Correios
{
    public static boolean cadastrado(String idCPF) throws Exception {
        boolean retorno = false;
        try {
            String sql;
            sql = "SELECT * "
                    + "FROM CorreioEntrega"
                    + "WHERE idCPF = ?;";
            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setString(1, idCPF);
            MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();
            retorno = resultado.first();
        } catch (SQLException erro) {
            throw new Exception(erro.getMessage());
        }
        return retorno;
    }

    public static void incluir(Correio correio) throws Exception {
        if (correio == null)
            throw new Exception("entrega ainda não cadastrada!");
        try
        {
            String sql;
            sql = "INSERT INTO CorreioEntrega" +
                    "(idCPF, nomeRemetente, nomeDestinatario, cep, complemento, nmrCasa)" +
                    "VALUES" +
                    "(?,?,?,?,?,?)";
            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setString(1, correio.getCPF());
            BDSQLServer.COMANDO.setString(2, correio.getNomeRemetente());
            BDSQLServer.COMANDO.setString(3, correio.getNomeDestinatario());
            BDSQLServer.COMANDO.setString(4, correio.getCep());
            BDSQLServer.COMANDO.setString(5, correio.getComplemento());
            BDSQLServer.COMANDO.setInt(6, correio.getNmrCasa());

            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        }
        catch (SQLException erro) {
            BDSQLServer.COMANDO.rollback();
            throw new Exception(erro.getMessage());
        }
    }

    public static void excluir(String idCPF) throws Exception
    {
        if(!(cadastrado(idCPF)))
            throw new Exception("CPF não cadastrado!");
        try
        {
            String sql = "";
            sql = "DELETE FROM CorreioEntrega" +
                    "WHERE idCPF=?";
            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setString(1, idCPF);

            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        }
        catch (SQLException erro)
        {
            BDSQLServer.COMANDO.rollback();
            throw new Exception("Erro ao excluir a entrega!");
        }
    }
    public static void alterar(Correio correio) throws  Exception
    {
        if(correio==null)
            throw new Exception("Informações não fornecidas. Verifique novamente!");
        if(!(cadastrado(correio.getCPF())))
            throw new Exception("CPF não cadastrado!");
        try {
            String sql = "";
            sql = "UPDATE CorreioEntrega " +
                    "SET nomeRemetente = ?, " +
                    "nomeDestinatario = ? " +
                    "cep = ?" +
                    "complemento = ?" +
                    "nmrCasa = ?" +
                    "WHERE idCPF = ?;";
            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setString(1, correio.getNomeRemetente());
            BDSQLServer.COMANDO.setString(2, correio.getNomeDestinatario());
            BDSQLServer.COMANDO.setString(3, correio.getCep());
            BDSQLServer.COMANDO.setString(4, correio.getComplemento());
            BDSQLServer.COMANDO.setInt(   5, correio.getNmrCasa());

            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        }
        catch (SQLException erro)
        {
            BDSQLServer.COMANDO.rollback();
            throw new Exception(erro.getMessage());
        }
    }

    public static Correio getCorreio(String cpf) throws Exception
    {
        Correio correio;
        try {
            String sql = "";

            sql = "SELECT *" +
                    "FROM CorreioEntrega" +
                    "WHERE idCPF = ?";
            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setString(1, cpf);

            MeuResultSet resultSet = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();

            correio = new Correio(resultSet.getString("idCPF"),
                    resultSet.getString("nomeRemetente"),
                    resultSet.getString("nomeDestinatario"),
                    resultSet.getString("cep"),
                    resultSet.getString("complemento"),
                    resultSet.getInt("nmrCasa"));
        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao procurar a entrega!");
        }
        return correio;
    }
    public static MeuResultSet getCorreio() throws Exception
    {
        MeuResultSet resultado = null;
        try {
            String sql = "";
            sql = "SELECT * " +
                    "FROM CorreioEntrega";
            BDSQLServer.COMANDO.prepareStatement(sql);

            resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();
        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao recuperar a entrega!");
        }
        return resultado;
    }
}
