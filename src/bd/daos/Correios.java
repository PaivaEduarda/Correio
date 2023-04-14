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

    public static void incluir(Correios correios) throws Exception {
        if (correios == null)
            throw new Exception("entrega ainda não cadastrada!");
        try
        {
            String sql;
            sql = "INSERT INTO CorreioEntrega" +
                    "(idCPF, nomeRemetente, nomeDestinatario, cep, complemento, nmrCasa)" +
                    "VALUES" +
                    "(?,?,?,?,?,?)";
            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setString(1, correios.getCPF());
            BDSQLServer.COMANDO.setString(2, correios.getNomeRemetente());
            BDSQLServer.COMANDO.setString(3, correios.getNomeDestinatario());
            BDSQLServer.COMANDO.setString(4, correios.getCep());
            BDSQLServer.COMANDO.setString(5, correios.getComplemento());
            BDSQLServer.COMANDO.setString(6, correios.getNmrCasa());

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
    public static void alterar(Correios correios) throws  Exception
    {
        if(correios==null)
            throw new Exception("Informações não fornecidas. Verifique novamente!");
        if(!(cadastrado(correios.getCPF())))
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
            BDSQLServer.COMANDO.setString(1, correios.getNomeRemetente());
            BDSQLServer.COMANDO.setString(2, correios.getNomeDestinatario());
            BDSQLServer.COMANDO.setString(3, correios.getCep());
            BDSQLServer.COMANDO.setString(4, correios.getComplemento());
            BDSQLServer.COMANDO.setInt(5, correios.getNmrCasa());

            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        }
        catch (SQLException erro)
        {
            BDSQLServer.COMANDO.rollback();
            throw new Exception(erro.getMessage());
        }
    }

    public static Correios getCorreio(String cpf) throws Exception
    {
        Correios correios;
        try {
            String sql = "";

            sql = "SELECT *" +
                    "FROM CorreioEntrega" +
                    "WHERE idCPF = ?";
            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setString(1, cpf);

            MeuResultSet resultSet = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();

            correios = new Correios(resultSet.getString("idCPF"),
                    resultSet.getString("nomeRemetente"),
                    resultSet.getString("nomeDestinatario"),
                    resultSet.getString("cep"),
                    resultSet.getString("complemento"),
                    resultSet.getString("nmrCasa"));
        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao procurar a entrega!");
        }
        return correios;
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
