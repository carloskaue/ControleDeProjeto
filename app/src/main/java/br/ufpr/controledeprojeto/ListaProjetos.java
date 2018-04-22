package br.ufpr.controledeprojeto;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Kaue on 22/04/2018.
 */

// criando a lista de filmes usando o pattern singleton
// ou seja, uma classe que permite a existência de apenas uma instância de sí mesma

// mantendo a lista de filmes em um singleton, ela estará disponível na memoria
// durante o ciclo de vida das atividades e do app
public class ListaProjetos implements Serializable {


    private ArrayList<Projeto> alProjetos;        // a lista de filmes privada da classe
    private static ListaProjetos sListaProjetos;  // a instancia static
    private Context appContext;


    // o constutor é privado
    private ListaProjetos(Context appContext) {
        this.appContext = appContext;

        // criar o ArrayList de objetos da classe Filme
        alProjetos = new ArrayList<Projeto>();
        // e adicionar 3 filmes para popular a base
       // alProjetos.add(new Projeto("Sensor de Desengate", "Sascar", 03, 12, 2017));
       // alProjetos.add(new Projeto("Trava Baú V4", "Safesoft", 18, 06, 2017));
    }

    // getter irá verificar se a instância já existe ou não
    // este método é static
    public static ListaProjetos get (Context c){
        if (sListaProjetos == null) {
            sListaProjetos = new ListaProjetos(c.getApplicationContext());
        }
        return sListaProjetos;
    }

    // retorna o conjunto de filme
    public ArrayList<Projeto> getAllProjetos() {
        return alProjetos;
    }
}
