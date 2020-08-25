package com.example.minhasanotaes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private AnotacoesPreferencias preferencias;
    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAnotacao = findViewById(R.id.editAnotacao);
        preferencias = new AnotacoesPreferencias( getApplicationContext() );

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //validar se foi digitado alguma coisa
                String textoRecuperado = editAnotacao.getText().toString();

                if( textoRecuperado.equals("")){ //se o texto recuperado for igual a vazio

                    Snackbar.make(view, "Preencha a anotação", Snackbar.LENGTH_LONG).show();
                }else{

                    preferencias.salvarAnotacao( textoRecuperado );
                    Snackbar.make(view, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG).show();
                }

            }
        });

        //recuperar anotação
        String anotacacao = preferencias.recuperarAnotacao();

        //verificando se a anotação está preenchida
        if( !anotacacao.equals("") ){ //caia aqui quando não estiver vazia
              editAnotacao.setText( anotacacao );
        }

    }
}
