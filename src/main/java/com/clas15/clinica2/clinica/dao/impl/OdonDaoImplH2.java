package com.clas15.clinica2.clinica.dao.impl;

import com.clas15.clinica2.clinica.model.Odontologo;
import org.example.clinica.dao.IDao;
import org.example.clinica.model.Odontologo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdonDaoImplH2 implements IDao<Odontologo> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";

    private final static String DB_URL = "jdbc:h2:~/db_odontologos;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER ="EliCaro";
    private final static String DB_PASSWORD = "123";

    @Override
    public Odontologo guardar(Odontologo o) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT INTO odontologos (matricula, nombre, apellido) VALUES (?,?,?)");
            preparedStatement.setInt(1, o.getNumeroMatricula());
            preparedStatement.setString(2, o.getNombre());
            preparedStatement.setString(3, o.getApellido());
            preparedStatement.executeUpdate();

            ResultSet keys = preparedStatement.getGeneratedKeys();
            if (keys.next()) {
                int generada = keys.getInt(1);
                o.setId(generada);
            }
            preparedStatement.close();
            connection.close();


        }  catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return o;
    }

    @Override
    public Odontologo buscar(int id) {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public List<Odontologo> buscarTodos() {
        return null;
    }

    @Override
    public ArrayList<Odontologo> listar() {
             Connection connection = null;
            PreparedStatement preparedStatement = null;

            ArrayList<Odontologo> losOdontologos = new ArrayList<>();

            try {
                Class.forName(DB_JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                preparedStatement = connection.prepareStatement("SELECT * FROM odontologos;");

                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()){
                    int id = rs.getInt("id");
                    int numeroMatricula = rs.getInt("numeroMatricula");
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    Odontologo o = new Odontologo(id, numeroMatricula, nombre, apellido);
                    losOdontologos.add(o);
                }
                preparedStatement.close();
                connection.close();

            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }

            return losOdontologos;
        }

}
