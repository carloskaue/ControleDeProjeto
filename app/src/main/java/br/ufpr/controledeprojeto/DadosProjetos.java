package br.ufpr.controledeprojeto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DadosProjetos extends AppCompatActivity {

    ArrayList<Projeto> alProjetos;
    Projeto projeto;
    int projetoPos;
    ActionBar ab;
    Bundle extras;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_projetos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        ab = getSupportActionBar(); // acessa a action bar
        ab.setDisplayHomeAsUpEnabled(true);  // seta retorno <- na action bar

        // pega código do gilme
        projetoPos = Integer.parseInt(extras.getString("filmeId"));

        this.mostraDadosProjeto();
    }
    private  void mostraDadosProjeto()
    {
        // pegar os filmes
        alProjetos = ListaProjetos.get(getApplicationContext()).getAllProjetos();
        // pega o filme em questão
        projeto = alProjetos.get(projetoPos);
        // atualiza nome do filme na avtion bar
        ab.setTitle(projeto.getfNome());

        // atualiza dados do filme nas TextViews
        TextView fNome = (TextView) findViewById(R.id.tvNome);
        fNome.setText(projeto.getfNome());

        TextView fData = (TextView) findViewById(R.id.tvData);
        fData.setText(projeto.getfDataString());

        TextView fLocal = (TextView) findViewById(R.id.tvCliente);
        fLocal.setText(projeto.getfCliente());

        ImageView ivComentario = (ImageView) findViewById(R.id.ivComentario);
        TextView fComentario = (TextView) findViewById(R.id.tvComentario);
        String sComentario = projeto.getfComentario();
        if (sComentario.isEmpty())
            ivComentario.setVisibility(View.INVISIBLE);
        else fComentario.setText(sComentario);

    }

    public void onResume() {
        super.onResume();
        this.mostraDadosProjeto();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // popula a action bar com os icones configurados em menu_dados_filme.xml
        getMenuInflater().inflate(R.menu.menu_dados_filme, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                // fechar activity e voltar
                this.finish();
                return true;

            case R.id.miEditar:
                // chamar a activity para editar os dados deste filme
                Intent i2 = new Intent (this, EditaProjeto.class);
                i2.putExtra("filmeId", String.valueOf(projetoPos));
                i2.putExtra("from", "1");
                startActivity(i2);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
