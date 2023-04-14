package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;
public class CEPS
{
    public static boolean cadastrado(int cepDestinatario) throws Exception {
        boolean retorno = false;
        try {
            String sql;
            sql = "SELECT * "
                    + "FROM CEP"
                    + "WHERE cepDestinatario= ?;";
            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setInt(1, cepDestinatario);
            MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();
            retorno = resultado.first();
        } catch (SQLException erro) {
            throw new Exception(erro.getMessage());
        }
        return retorno;
    }

    public static void incluir(CEP cep) throws Exception {
        if (cep == null)
            throw new Exception("cep ainda não cadastrado");
        try
        {
            String sql;
            sql = "INSERT INTO CEP" +
                    "(cepDestinatario, complemento, bairro, cidade, logradouro, estado)" +
                    "VALUES" +
                    "(?,?,?,?,?,?)";
            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setInt(1, cep.getCepDestinatario());
            BDSQLServer.COMANDO.setString(2, cep.getComplemento());
            BDSQLServer.COMANDO.setString(3, cep.getBairro());
            BDSQLServer.COMANDO.setString(4, cep.getCidade());
            BDSQLServer.COMANDO.setString(5, cep.getLogradouro());
            BDSQLServer.COMANDO.setString(6, cep.getEstado());

            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        }
        catch (SQLException erro) {
            BDSQLServer.COMANDO.rollback();
            throw new Exception(erro.getMessage());
        }
    }

    public static void excluir(int cepDestinatario) throws Exception
    {
        if(!(cadastrado(cepDestinatario)))
            throw new Exception("cep não cadastrado!");
        try
        {
            String sql = "";
            sql = "DELETE FROM CEP" +
                    "WHERE cepDestinatario=?";
            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setInt(1, cepDestinatario);

            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        }
        catch (SQLException erro)
        {
            BDSQLServer.COMANDO.rollback();
            throw new Exception("Erro ao excluir o endereço!");
        }
    }
    public static void alterar(CEP cep) throws  Exception
    {
        if(cep==null)
            throw new Exception("cep não fornecido!");
        if(!(cadastrado(cep.getCepDestinatario())))
            throw new Exception("Endereço não cadastrado!");
        try {
            String sql = "";
            sql = "UPDATE CEP " +
                    "SET complemento = ?, " +
                    "bairro = ? " +
                    "cidade = ?" +
                    "logradouro = ?" +
                    "estado = ?" +
                    "WHERE cepDestinatario = ?;";
            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setString(1, cep.getComplemento());
            BDSQLServer.COMANDO.setString(2, cep.getBairro());
            BDSQLServer.COMANDO.setString(3, cep.getCidade());
            BDSQLServer.COMANDO.setString(4, cep.getLogradouro());
            BDSQLServer.COMANDO.setString(5, cep.getEstado());

            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        }
        catch (SQLException erro)
        {
            BDSQLServer.COMANDO.rollback();
            throw new Exception(erro.getMessage());
        }
    }

    public static CEP getCEP(int cep) throws Exception
    {
        CEP cepDestinatario;
        try {
            String sql = "";

            sql = "SELECT *" +
                    "FROM CEP" +
                    "WHERE cepDestinatario = ?";
            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setInt(1, cep);

            MeuResultSet resultSet = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();

            cepDestinatario = new CEP(Integer.toString(resultSet.getInt("cepDestinatario")),
                    resultSet.getString("complemento"),
                    resultSet.getString("bairro"),
                    resultSet.getString("cidade"),
                    resultSet.getString("logradouro"),
                    resultSet.getString("estado"));
        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao procurar o endereço!");
        }
        return cepDestinatario;
    }
    public static MeuResultSet getCEP() throws Exception
    {
        MeuResultSet resultado = null;
        try {
            String sql = "";
            sql = "SELECT * " +
                    "FROM CEP";
            BDSQLServer.COMANDO.prepareStatement(sql);

            resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();
        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao recuperar o cep!");
        }
        return resultado;
    }
}
