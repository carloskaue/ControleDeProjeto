package br.ufpr.controledeprojeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    // ArrayList, estrutura de dados contendo os filmes vistos
    ArrayList<Projeto> alProjetos;
    // ArrayAdapter é um adapter para vincular arrays e views, pode ser usado com list views e spinners
    ArrayAdapter<Projeto> aaListaProjetos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // pegar os filmes
        alProjetos = ListaProjetos.get(getApplicationContext()).getAllProjetos();

        // associar o elemento da UI com a variável
        ListView lvListaFilmes = (ListView) findViewById(R.id.lvListaProjetos);
        // vamos usar o ArrayAdaptar para mostrar os dados do ArrayList de filmes alFilmes
        aaListaProjetos = new ArrayAdapter<Projeto>(this, android.R.layout.simple_list_item_1, alProjetos);
        // e mostrá-los na na listview lvListaFilmes, setada com o método setAdapter
        lvListaFilmes.setAdapter(aaListaProjetos);
        // usará o retorno do toString para determinar o texto que será exibido em cada item da lista

        // criar um listener para os eventos de onClick nos items da listview
        lvListaFilmes.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view, int posicao, long id) {
                        Intent i = new Intent(view.getContext(), DadosProjetos.class);
                        i.putExtra("filmeId", String.valueOf(posicao));
                        startActivity(i);
                    }
                });
    }
}
