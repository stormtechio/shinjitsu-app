package com.example.shinjitsu.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.shinjitsu.R;
import com.example.shinjitsu.models.StudentEntity;

public class StudentFragment extends Fragment {

    EditText editTextName;
    EditText editTextAge;
    EditText editTextResponsible;
    EditText editTextStreet;
    EditText editTextNeighborhood;
    EditText editTextCity;
    EditText editTextNumber;
    EditText editTextComplement;
    EditText editTextCellphone;
    EditText editTextEmail;
    EditText editTextPhone;

    RadioGroup radioGroupDisease;
    RadioGroup radioGroupChronicDisease;
    RadioGroup radioGroupSurgery;

    String name;
    int age;
    String responsible;
    String street;
    String neighborhood;
    String city;
    String state;
    int number;
    String complement;
    String cellphone;
    String email;
    String phone;

    boolean disease;
    boolean chronicDisease;
    boolean surgery;

    StudentEntity studentEntity;

    Button buttonRegister;

    Spinner spinnerStates;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View studentView = inflater.inflate(R.layout.student_fragment, container, false);

        findView(studentView);
        adapterStates();

        buttonRegister.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                studentEntity = new StudentEntity();

                if(getText()){
                    if(getTextRadioButton(studentView)){
                        setStudentEntity();
                        boolean result = sendData();
                        Toast.makeText(getContext(), "Aluno cadastrado", Toast.LENGTH_LONG).show();

                    }
                }




               // Log.e("OOOOOOIIIIINAME", studentEntity.getState());
                //Toast.makeText(getContext(), "Aluno Cadastrado", Toast.LENGTH_SHORT).show();

            }
        });

        return studentView;
    }

    private void findView(View view){

        editTextName = view.findViewById(R.id.edit_text_name);
        editTextAge = view.findViewById(R.id.edit_text_age);
        editTextResponsible = view.findViewById(R.id.edit_text_responsible);
        editTextStreet = view.findViewById(R.id.edit_text_street);
        editTextNeighborhood = view.findViewById(R.id.edit_text_neighborhood);
        editTextCity = view.findViewById(R.id.edit_text_city);
        editTextNumber = view.findViewById(R.id.edit_text_number);
        editTextComplement = view.findViewById(R.id.edit_text_complement);
        editTextCellphone = view.findViewById(R.id.edit_text_cellphone);
        editTextEmail = view.findViewById(R.id.edit_text_email);
        editTextPhone = view.findViewById(R.id.edit_text_phone);
        radioGroupDisease = view.findViewById(R.id.radio_group_disease);
        radioGroupChronicDisease = view.findViewById(R.id.radio_group_chronic_disease);
        radioGroupSurgery = view.findViewById(R.id.radio_group_surgery);
        buttonRegister = view.findViewById(R.id.button_register);
        spinnerStates = view.findViewById(R.id.states_spinner);
    }

    private void adapterStates(){

        ArrayAdapter<CharSequence> adapterStates = ArrayAdapter.createFromResource(getContext(),
                R.array.states_array, android.R.layout.simple_spinner_item);
        adapterStates.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStates.setAdapter(adapterStates);
    }

    private boolean getText(){

        if(editTextName.getText().toString().equals("")){
            Toast.makeText(getContext(), "O campo nome está vazio", Toast.LENGTH_SHORT).show();
            return false;
        }
        name = editTextName.getText().toString();

        if(editTextAge.getText().toString().equals("")){
            Toast.makeText(getContext(), "O campo idade está vazio", Toast.LENGTH_SHORT).show();
            return false;
        }
        age = Integer.parseInt(editTextAge.getText().toString());

        if(editTextResponsible.getText().toString().equals("") && age < 18){
            Toast.makeText(getContext(), "O campo responsável está vazio", Toast.LENGTH_SHORT).show();
            return false;
        }
        responsible = editTextResponsible.getText().toString();
        
        if(editTextStreet.getText().toString().equals("")){
            Toast.makeText(getContext(), "O campo rua está vazio", Toast.LENGTH_SHORT).show();
            return false;
        }
        street = editTextStreet.getText().toString();

        if(editTextNeighborhood.getText().toString().equals("")){
            Toast.makeText(getContext(), "O campo bairro está vazio", Toast.LENGTH_SHORT).show();
            return false;
        }
        neighborhood = editTextNeighborhood.getText().toString();

        if(editTextCity.getText().toString().equals("")){
            Toast.makeText(getContext(), "O campo cidade está vazio", Toast.LENGTH_SHORT).show();
            return false;
        }
        city = editTextCity.getText().toString();

        if(spinnerStates.getSelectedItem().toString().equals("")){
            Toast.makeText(getContext(), "O campo estado está vazio", Toast.LENGTH_SHORT).show();
            return false;
        }
        state = spinnerStates.getSelectedItem().toString();

        if(editTextNumber.getText().toString().equals("")){
            Toast.makeText(getContext(), "O campo número está vazio", Toast.LENGTH_SHORT).show();
            return false;
        }
        number = Integer.parseInt(editTextNumber.getText().toString());

        if(editTextComplement.getText().toString().equals("")){
            Toast.makeText(getContext(), "O campo complemento está vazio", Toast.LENGTH_SHORT).show();
            return false;
        }
        complement = editTextComplement.getText().toString();

        if(editTextCellphone.getText().toString().equals("")){
            Toast.makeText(getContext(), "O campo celular está vazio", Toast.LENGTH_SHORT).show();
            return false;
        }
        cellphone = editTextCellphone.getText().toString();

        if(editTextEmail.getText().toString().equals("")){
            Toast.makeText(getContext(), "O campo email está vazio", Toast.LENGTH_SHORT).show();
            return false;
        }
        email = editTextEmail.getText().toString();

        phone = editTextPhone.getText().toString();

        return true;
    }

    private boolean getTextRadioButton(View view){

        int diseaseRadioButtonId = radioGroupDisease.getCheckedRadioButtonId();
        int chronicDiseaseRadioButtonId = radioGroupChronicDisease.getCheckedRadioButtonId();
        int surgeryRadioButtonId = radioGroupSurgery.getCheckedRadioButtonId();

        RadioButton radioButtonChronicDisease = view.findViewById(chronicDiseaseRadioButtonId);
        RadioButton radioButtonDisease = view.findViewById(diseaseRadioButtonId);
        RadioButton radioButtonSurgery = view.findViewById(surgeryRadioButtonId);

        try {
            if(radioButtonSurgery.getText().toString().equals("Sim")){
                surgery = true;
            }else{
                surgery = false;
            }
        } catch(NullPointerException erro){
            Toast.makeText(getContext(), "O campo cirurgia está vazio", Toast.LENGTH_SHORT).show();
            return false;
        }
        try {
            if(radioButtonChronicDisease.getText().toString().equals("Sim")){
                chronicDisease = true;
            }else{
                chronicDisease = false;
            }
        } catch(NullPointerException erro){
            Toast.makeText(getContext(), "O campo doença crônica está vazio", Toast.LENGTH_SHORT).show();
            return false;
        }
        try {
            if(radioButtonDisease.getText().toString().equals("Sim")){
                disease = true;
            }else{
                disease = false;
            }
        } catch(NullPointerException erro){
            Toast.makeText(getContext(), "O campo doença está vazio", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
    private void setStudentEntity(){

        studentEntity.setName(name);
        studentEntity.setAge(age);
        studentEntity.setStreet(street);
        studentEntity.setNeighborhood(neighborhood);
        studentEntity.setCity(city);
        studentEntity.setState(state);
        studentEntity.setNumber(number);
        studentEntity.setComplement(complement);
        studentEntity.setCellphone(cellphone);
        studentEntity.setEmail(email);
        studentEntity.setPhone(phone);
        studentEntity.setDisease(disease);
        studentEntity.setChronicDisease(chronicDisease);
        studentEntity.setSurgery(surgery);

    }

    private boolean sendData() {
        /**
         * Aqui será implementado o envio para o controller... se a resposta for positiva, então retorna um boolean True, caso contrário, false...
         */

        return true;

    }
}