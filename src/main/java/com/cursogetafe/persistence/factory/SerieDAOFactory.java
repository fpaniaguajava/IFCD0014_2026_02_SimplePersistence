package com.cursogetafe.persistence.factory;

import com.cursogetafe.persistence.impl.SerieDAOFileImpl;
import com.cursogetafe.persistence.impl.SerieDAOPostgreImpl;
import com.cursogetafe.persistence.interfaces.ISerieDAO;
import com.cursogetafe.persistence.impl.SerieDAOSQLiteImpl;
import com.cursogetafe.util.PropertiesReader;

public class SerieDAOFactory {
    public static ISerieDAO getSerieDAOImpl(){
        String value = PropertiesReader.readProperty("config.prop","PERSISTENCE_TYPE");
        PersistenceType persistenceType = PersistenceType.valueOf(value);
        switch (persistenceType) {
            case PersistenceType.FILE:
                return new SerieDAOFileImpl();
            case PersistenceType.SQLITE:
                return new SerieDAOSQLiteImpl();
            case PersistenceType.POSTGRE:
                return new SerieDAOPostgreImpl();
            default:
                return new SerieDAOFileImpl();
        }
    }
}