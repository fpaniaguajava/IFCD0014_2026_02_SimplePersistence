package com.cursogetafe;

import com.cursogetafe.model.Serie;
import com.cursogetafe.persistence.ISerieDAO;
import com.cursogetafe.persistence.SerieDAOFileImpl;
import com.cursogetafe.util.SerieDAOFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ISerieDAO sdf = SerieDAOFactory.getSerieDAOImpl();
        //sdf.create(new Serie("titulo","acción", 3));
        Serie serie = sdf.read("titulo");
        System.out.println(serie);
    }
}
