package com.example.minhaagenda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class FormularioAlunoActivity extends AppCompatActivity {

    private final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle("Novo Aluno");

        EditText inputNome = findViewById(R.id.et_nome);
        EditText inputTelefone = findViewById(R.id.et_telefone);
        EditText inputEmail = findViewById(R.id.et_email);
        Button btnSalvar = findViewById(R.id.btn_salvar);


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Aluno alunoCriado = criaAluno(inputNome, inputTelefone, inputEmail);
                salvarAluno(alunoCriado);


                finish();

            }
        });

        Intent dados = getIntent();
        Aluno aluno = (Aluno )dados.getSerializableExtra("aluno");
        inputNome.setText(aluno.getNome());
        inputTelefone.setText(aluno.getTelefone());
        inputEmail.setText(aluno.getEmail());



    }

    private void salvarAluno(Aluno alunoCriado) {
        dao.salva(alunoCriado);
    }

    private Aluno criaAluno(EditText inputNome, EditText inputTelefone, EditText inputEmail) {
        String nome = inputNome.getText().toString();
        String telefone = inputTelefone.getText().toString();
        String email = inputEmail.getText().toString();

        Aluno alunoCriado = new Aluno(nome, telefone, email);
        return alunoCriado;
    }
}