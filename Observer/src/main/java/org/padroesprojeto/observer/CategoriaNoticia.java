package org.padroesprojeto.observer;

import java.util.Observable;

public class CategoriaNoticia extends Observable {

    private String nomeCategoria;

    public CategoriaNoticia(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public void lancarNoticia(String tituloNoticia) {
        setChanged();
        notifyObservers(tituloNoticia);
    }

    @Override
    public String toString() {
        return "Categoria de Notícia: " + this.nomeCategoria;
    }
}