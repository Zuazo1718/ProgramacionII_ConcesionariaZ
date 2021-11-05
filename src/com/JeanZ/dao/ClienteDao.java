package com.JeanZ.dao;

import com.JeanZ.model.Cliente;
import com.JeanZ.util.ConectorBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {
    Connection conection;
    public ClienteDao(){
        conection = ConectorBD.getConnection();
    }
    public void addCliente(Cliente cliente){
        try {
            PreparedStatement preparedStatement = conection
                    .prepareStatement("INCERT INTO Cliente (nif, nombre, ciudad, direccion, telefono) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, cliente.getNif());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getCiudad());
            preparedStatement.setString(4, cliente.getDireccion());
            preparedStatement.setInt(5, cliente.getTelefono());
            preparedStatement.executeUpdate();

            System.out.println(cliente + "Creado");
        }catch (SQLException e){
            System.out.println("Error al crear cliente "+ e.getMessage());
        }
    }
    //ACTUALIZAR UPDATE
    public void updateCliente(Cliente cliente){
        try {
            PreparedStatement preparedStatement = conection
                    .prepareStatement("UPDATE cliente SET nif=?, nombre=?, ciudad=?, direccion=?, telefono=? WHERE nif=?");
            preparedStatement.setString(1, cliente.getNif());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getCiudad());
            preparedStatement.setString(4, cliente.getDireccion());
            preparedStatement.setInt(5, cliente.getTelefono());

            preparedStatement.setString(6, cliente.getNif());
            preparedStatement.executeUpdate();

            System.out.println(cliente + "Editado");
        }catch (SQLException e){
            System.out.println("Error al editar al cliente  "+ e.getMessage());
        }
    }
    //eliminar delete
    public void deleteCliente(String nif){
        try {
            PreparedStatement preparedStatement = conection
                    .prepareStatement("DELETE FROM clientes WHERE nif=?");
            preparedStatement.setString(1, nif);
            preparedStatement.executeUpdate();

            System.out.println(nif + "Eliminado");
        }catch (SQLException e){
            System.out.println("Error al eliminar al cliente  "+ e.getMessage());
        }
    }
    //READ LEER
    public  List<Cliente> getALLClientes(){
        List<Cliente> clientes = new ArrayList<>();
        try {
            Statement statement = conection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM clientes ");
            while (resultSet.next()){
                Cliente cliente = new Cliente();
                cliente.setNif(resultSet.getString("nif"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setCiudad(resultSet.getString("ciudad"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setTelefono(resultSet.getInt("telefono"));

                clientes.add(cliente);
            }
        }catch (SQLException e){
            System.out.println("Error al listar los clientes : " + e.getMessage());
        }

        return clientes;
    }


}





































