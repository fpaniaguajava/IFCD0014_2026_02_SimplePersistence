package com.cursogetafe.util;

import com.cursogetafe.persistence.ISerieDAO;
import com.cursogetafe.persistence.SerieDAOFileImpl;

public class SerieDAOFactory {
    public static ISerieDAO getSerieDAOImpl(){
        return new SerieDAOFileImpl();
    }
}
