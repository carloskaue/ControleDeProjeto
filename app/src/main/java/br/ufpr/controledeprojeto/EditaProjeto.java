package br.ufpr.controledeprojeto;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class EditaProjeto extends AppCompatActivity {
    ArrayList<Projeto> alProjetos;
    Projeto projeto;
    int projetoPos;

    EditText fNome;
    EditText fCliente;
    EditText fComentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edita_projeto);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        ActionBar ab = getSupportActionBar(); // acessa a action bar
        ab.setDisplayHomeAsUpEnabled(true);  // seta retorno <- na action bar

        // pega código do filme
        projetoPos = Integer.parseInt(extras.getString("filmeId"));
        // pegar os filmes
        alProjetos = ListaProjetos.get(getApplicationContext()).getAllProjetos();
        // pega o filme em questão
        projeto = alProjetos.get(projetoPos);
        // atualiza nome do filme na avtion bar
        ab.setTitle(projeto.getfNome());

        // atualiza dados do filme nas TextViews
        fNome = (EditText) findViewById(R.id.etNome);
        fNome.setText(projeto.getfNome());

        TextView fData = (TextView) findViewById(R.id.tvData);
        fData.setText(projeto.getfDataString());

        fCliente = (EditText) findViewById(R.id.etCliente);
        fCliente.setText(projeto.getfCliente());

        fComentario = (EditText) findViewById(R.id.etComentario);
        String sComentario = projeto.getfComentario();
        fComentario.setText(sComentario);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // popula a action bar com os icones configurados em menu_dados_filme.xml
        getMenuInflater().inflate(R.menu.menu_edita_filme, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case android.R.id.home:
                // fechar activity e voltar
                this.finish();
                return true;

            case R.id.miOkEdit:
                // salvar os dados alterados deste evento e voltar
                projeto.setfNome(fNome.getText().toString());
                projeto.setfCliente(fCliente.getText().toString());
                projeto.setfComentario(fComentario.getText().toString());
                this.finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
