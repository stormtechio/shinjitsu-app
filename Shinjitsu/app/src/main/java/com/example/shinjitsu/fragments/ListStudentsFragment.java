package com.example.shinjitsu.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shinjitsu.R;
import com.example.shinjitsu.adapters.StudentAdapter;
import com.example.shinjitsu.collections.ReverseByNameStudents;
import com.example.shinjitsu.collections.SortByNameStudents;
import com.example.shinjitsu.entities.StudentEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListStudentsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    StudentEntity studentEntity = new StudentEntity();
    StudentEntity studentEntity2 = new StudentEntity();
    StudentEntity studentEntity3 = new StudentEntity();
    StudentEntity studentEntity4 = new StudentEntity();
    List<StudentEntity> students = new ArrayList<>();
    List<StudentEntity> newStudent;
    Spinner filterSpinner;
    EditText editTextSearch;
    Button buttonSearch;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View listStudentsView = inflater.inflate(R.layout.list_students_fragment, container, false);


        filterSpinner = listStudentsView.findViewById(R.id.filter_spinner_student);
        editTextSearch = listStudentsView.findViewById(R.id.edit_text_search);
        buttonSearch = listStudentsView.findViewById(R.id.button_search);

        adapterFilter();



        studentEntity.setName("Luninha fdp");
        studentEntity.setCellphone("12344");
        studentEntity.setResponsible("Saori");
        studentEntity.setAge(12);
        studentEntity.setChronicDisease(true);
        studentEntity.setCity("Crateús");
        studentEntity.setComplement("praca");
        studentEntity.setDisease(false);
        studentEntity.setEmail("luna@gmail.com");
        studentEntity.setNeighborhood("djdjd");
        studentEntity.setNumber(3);
        studentEntity.setCellphone("55547555");
        studentEntity.setState("cccc");
        studentEntity.setStreet("iifi");
        studentEntity.setPhone("789");
        studentEntity.setSurgery(true);


        studentEntity2.setName("Einstein fdp");
        studentEntity2.setCellphone("1234477");
        studentEntity2.setResponsible("Saorii");

        studentEntity3.setName("Cachorrinho fdp");
        studentEntity3.setCellphone("12344555");
        studentEntity3.setResponsible("Saoriiiiii");

        studentEntity4.setName("Zachorrinho fdp");
        studentEntity4.setCellphone("12344555");
        studentEntity4.setResponsible("Saoriiiiii");

        students.add(studentEntity);
        students.add(studentEntity2);
        students.add(studentEntity3);
        students.add(studentEntity4);






        buttonSearch.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("AAAAAAA", editTextSearch.getText().toString());

                // Para cada texto novo criasse uma lista vazia
                newStudent = new ArrayList<>();
                for (StudentEntity s: students) {
                    String searchContent = editTextSearch.getText().toString();

                    /*
                     * Para cada Student de Students checar se o texto da busca está contida no atributo a qual se deseja comparar.
                     * Nesse caso, comparar o nome fica
                     * ~ s.getNome() [Pega o nome do aluno sendo atualmente verificado na lista, e esse objeto é do tipo String]
                     * como s.getNome() é String, então pode-se usar o método contains() que pertence a classe String. Esse método
                     * recebe uma String e retorna true se essa String está contida dentro de outra.
                     *
                     * Ex: String nome = "Einstein";
                     *     String busca = "tei";
                     *     boolean contemString = nome.contains(busca);
                     *     if (contemString) println(nome + " contem a string ["+busca+"]");
                     *     else println(nome + " NAO contem a string ["+busca+"]");
                     *
                     *
                     * IMPORTANTE!
                     * Verificar se cada atributo é do objeto é nulo antes de chamar contains(), caso contrário irá receber uma exceção de
                     * NullPointerException. Caso seja Nulo uma solução pode ser setar o objeto como um valor vazio.
                     *  if(s.getEmail() == null) s.setEmail("")
                     *
                     * Dica!
                     * Transforme tudo pra minusculo. Assim se o usuario digitar errado, não precisa se preocupar com erros.
                     */

                    if(s.getName() == null) s.setName("");
                    if(s.getEmail() == null) s.setEmail("");

                    /* Dica!
                     * Transforme tudo pra minusculo. Assim se o usuario digitar errado, não precisa se preocupar com erros e guarde numa variável
                     * para futuras comparacoes.
                     */
                    String name = s.getName().toLowerCase();
                    String email = s.getEmail().toLowerCase();

                    if (name.contains(searchContent) ||
                            email.contains(searchContent)) {

                        newStudent.add(s);
                        recycler(newStudent, listStudentsView);

                    }




                }

            }
        });



        filterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i){
                    case 0:
                        recycler(students, listStudentsView);
                        break;
                    case 1:
                        Collections.sort(students, new SortByNameStudents());
                        recycler(students, listStudentsView);
                        break;
                    case 2:
                        Collections.sort(students, new ReverseByNameStudents());
                        recycler(students, listStudentsView);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return listStudentsView;
    }

    private void adapterFilter(){

        ArrayAdapter<CharSequence> adapterFilter = ArrayAdapter.createFromResource(getContext(),
                R.array.order_array, android.R.layout.simple_spinner_item);
        adapterFilter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterSpinner.setAdapter(adapterFilter);
    }

    private void recycler(List students, View view){
        recyclerView = view.findViewById(R.id.recycler_view_students);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new StudentAdapter(students);
        recyclerView.setAdapter(mAdapter);

    }


}
