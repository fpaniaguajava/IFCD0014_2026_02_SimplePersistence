package com.cursogetafe.persistence.impl;

import com.cursogetafe.model.Serie;
import com.cursogetafe.persistence.interfaces.ISerieDAO;

import java.io.*;
import java.util.List;

public class SerieDAOFileImpl implements ISerieDAO {
    @Override
    public Serie create(Serie serie) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(serie.getTitulo()+".txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(serie);
            System.out.println("Objeto guardado correctamente");
        } catch (IOException e) {
            //¿Creamos un registro de log?
            //¿Hacemos alguna acción extra como enviar un correo
            throw e;
        }
        return serie;
    }

    @Override
    public Serie read(String titulo) {
        Serie serie = null;
        try (FileInputStream fileIn = new FileInputStream(titulo + ".txt");
            ObjectInputStream in = new ObjectInputStream(fileIn)) {
            serie = (Serie)in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return serie;
    }

    @Override
    public Serie update(Serie serie) {
        return null;
    }

    @Override
    public void delete(String titulo) {

    }

    @Override
    public List<Serie> readAll() {
        return List.of();
    }
}
