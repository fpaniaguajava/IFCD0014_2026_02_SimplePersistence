package com.cursogetafe.persistence;

import com.cursogetafe.model.Serie;

import java.util.List;

public interface ISerieDAO {
    public Serie create(Serie serie);
    public Serie read(String titulo);
    public Serie update(Serie serie);
    public void delete(String titulo);
    public List<Serie> readAll();
}
