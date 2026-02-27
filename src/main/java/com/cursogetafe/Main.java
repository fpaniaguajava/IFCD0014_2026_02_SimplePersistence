package com.cursogetafe;

import com.cursogetafe.model.Serie;
import com.cursogetafe.persistence.interfaces.ISerieDAO;
import com.cursogetafe.persistence.factory.SerieDAOFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ISerieDAO sdf = SerieDAOFactory.getSerieDAOImpl();
        try {
            Serie nuevaSerie = sdf.create(new Serie("Alien", "Terror", 11));
            System.out.println(nuevaSerie);
            //Serie serie = sdf.read("titulo");
            //System.out.println(serie);
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error:" + e.getMessage());
        }
    }
}
