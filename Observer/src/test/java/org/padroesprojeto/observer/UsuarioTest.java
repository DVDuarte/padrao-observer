package org.padroesprojeto.observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void deveNotificarUmUsuario() {
        CategoriaNoticia politica = new CategoriaNoticia("Política");
        Usuario usuario = new Usuario("Daniel");
        usuario.seguirCategoria(politica);
        politica.lancarNoticia("Novo projeto de lei em discussão");
        assertEquals("Daniel, nova notícia em Categoria de Notícia: Política", usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarUsuarios() {
        CategoriaNoticia tecnologia = new CategoriaNoticia("Tecnologia");
        Usuario usuario1 = new Usuario("Daniel");
        Usuario usuario2 = new Usuario("Adriano");
        usuario1.seguirCategoria(tecnologia);
        usuario2.seguirCategoria(tecnologia);
        tecnologia.lancarNoticia("Novo smartphone revolucionário lançado");
        assertEquals("Daniel, nova notícia em Categoria de Notícia: Tecnologia", usuario1.getUltimaNotificacao());
        assertEquals("Adriano, nova notícia em Categoria de Notícia: Tecnologia", usuario2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarUsuarioNaoInscrito() {
        CategoriaNoticia esportes = new CategoriaNoticia("Esportes");
        Usuario usuario = new Usuario("Daniel");
        esportes.lancarNoticia("Final do campeonato agitada");
        assertNull(usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarUsuarioSomenteDaCategoriaInscrita() {
        CategoriaNoticia politica = new CategoriaNoticia("Política");
        CategoriaNoticia esportes = new CategoriaNoticia("Esportes");
        Usuario usuario1 = new Usuario("Daniel");
        Usuario usuario2 = new Usuario("Adriano");
        usuario1.seguirCategoria(politica);
        usuario2.seguirCategoria(esportes);
        politica.lancarNoticia("Novo projeto de lei em discussão");
        assertEquals("Daniel, nova notícia em Categoria de Notícia: Política", usuario1.getUltimaNotificacao());
        assertNull(usuario2.getUltimaNotificacao());
    }
}