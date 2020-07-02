package com.example.shinjitsu.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shinjitsu.R;
import com.example.shinjitsu.adapters.StudentAdapter;
import com.example.shinjitsu.entities.StudentEntity;

import java.util.ArrayList;
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


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View listStudentsView = inflater.inflate(R.layout.list_students_fragment, container, false);

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

        students.add(studentEntity);
        students.add(studentEntity2);
        students.add(studentEntity3);



        recyclerView = listStudentsView.findViewById(R.id.recycler_view_students);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new StudentAdapter(students);
        recyclerView.setAdapter(mAdapter);


        return listStudentsView;
    }
}
