package com.example.shinjitsu.repository.RemoteDataSource;

import com.example.shinjitsu.config.RetrofitConfig;
import com.example.shinjitsu.entities.StudentEntity;
import com.example.shinjitsu.interfaces.WebService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class StudentRemoteDataSource {

    private WebService webService;
    private List<StudentEntity> students;

    /**
     * Construtor da classe, nele é recuperado as configurações do retrofit e utiliza
     * a interface de WebService, que contem as rotas e assinaturas dos metodos.
     */
    public StudentRemoteDataSource(){
        Retrofit retrofit = RetrofitConfig.getRetrofit();
        this.webService = retrofit.create(WebService.class);
    }

    /**
     * Método responsável por fazer uma requisição para o servidor passado como parametro em Retrofit.Builder().baseUrl,
     * e usa a referencia da interface WebService que contém as assinaturas para os metodos e suas respectivas rotas.
     *
     * @return
     */
    public List<StudentEntity> getStudents() throws IOException {
        Call<List<StudentEntity>> studentsCall = webService.getStudents();

        students = studentsCall.execute().body();

        return students;
    }




//    private List<StudentEntity> studentEntityList;
//    //private StudentEntity studentEntity;
//
//    public StudentEntity addStudent(StudentEntity studentEntity){
//
//        studentEntityList.add(studentEntity);
//
//        return studentEntity;
//    }
//
//    public StudentEntity updateStudent(StudentEntity studentEntity){
//
//        for (StudentEntity s: studentEntityList) {
//           if(s.getId() == studentEntity.getId()){
//               s = studentEntity;
//               return s;
//           }
//        }
//
//        return null;
//    }
//
//    public StudentEntity removeStudent(StudentEntity studentEntity){
//
//        studentEntityList.remove(studentEntity);
//
//        return studentEntity;
//    }
//
//    public StudentEntity getStudent(StudentEntity studentEntity){
//
//        for (StudentEntity s: studentEntityList) {
//            if(s.equals(studentEntity)){
//                return studentEntity;
//            }
//        }
//
//        return null;
//    }
}
