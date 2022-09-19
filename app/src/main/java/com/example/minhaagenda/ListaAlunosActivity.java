package com.example.minhaagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ListaAlunosActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle("Lista de Alunos");



        FloatingActionButton fabNovoAluno = findViewById(R.id.fab_add_aluno);



        fabNovoAluno.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class);
               startActivity(i);
           }
        });

    }
    private final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onResume() {
        super.onResume();


        ListView listaDeAlunos = findViewById(R.id.lv_lista_alunos);

        listaDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.todos()));

        listaDeAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getIntent();
            }
        });

    }
}