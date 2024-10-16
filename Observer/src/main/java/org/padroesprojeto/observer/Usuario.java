package org.padroesprojeto.observer;

import java.util.Observable;
import java.util.Observer;

public class Usuario implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void seguirCategoria(CategoriaNoticia categoria) {
        categoria.addObserver(this);
    }

    @Override
    public void update(Observable categoria, Object arg1) {
        this.ultimaNotificacao = this.nome + ", nova notícia em " + categoria.toString();
    }
}