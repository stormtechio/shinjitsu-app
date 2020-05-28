package com.example.shinjitsu.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    EditText editTextState;
    EditText editTextNumber;
    EditText editTextComplement;
    EditText editTextCellphone;
    EditText editTextEmail;
    EditText editTextPhone;

    RadioGroup radioGroupDisease;
    RadioGroup radioGroupChronicDisease;
    RadioGroup radioGroupSurgery;

    Toast toast;
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

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View studentView = inflater.inflate(R.layout.student_fragment, container, false);

        findView(studentView);

        buttonRegister.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                studentEntity = new StudentEntity();

                if(editTextName.getText().toString().equals("")){
                    Toast.makeText(getContext(), "O campo nome está vazio", Toast.LENGTH_SHORT).show();
                    return;
                }
                name = editTextName.getText().toString();

                if(editTextAge.getText().toString().equals("")){
                    Toast.makeText(getContext(), "O campo idade está vazio", Toast.LENGTH_SHORT).show();
                    return;
                }
                age = Integer.parseInt(editTextAge.getText().toString());

                if(editTextResponsible.getText().toString().equals("")){
                    Toast.makeText(getContext(), "O campo responsável está vazio", Toast.LENGTH_SHORT).show();
                    return;
                }
                responsible = editTextResponsible.getText().toString();

                if(editTextStreet.getText().toString().equals("")){
                    Toast.makeText(getContext(), "O campo rua está vazio", Toast.LENGTH_SHORT).show();
                    return;
                }
                street = editTextStreet.getText().toString();

                if(editTextNeighborhood.getText().toString().equals("")){
                    Toast.makeText(getContext(), "O campo bairro está vazio", Toast.LENGTH_SHORT).show();
                    return;
                }
                neighborhood = editTextNeighborhood.getText().toString();

                if(editTextCity.getText().toString().equals("")){
                    Toast.makeText(getContext(), "O campo cidade está vazio", Toast.LENGTH_SHORT).show();
                    return;
                }
                city = editTextCity.getText().toString();

                if(editTextState.getText().toString().equals("")){
                    Toast.makeText(getContext(), "O campo estado está vazio", Toast.LENGTH_SHORT).show();
                    return;
                }
                state = editTextState.getText().toString();

                if(editTextNumber.getText().toString().equals("")){
                    Toast.makeText(getContext(), "O campo número está vazio", Toast.LENGTH_SHORT).show();
                    return;
                }
                number = Integer.parseInt(editTextNumber.getText().toString());

                if(editTextComplement.getText().toString().equals("")){
                    Toast.makeText(getContext(), "O campo complemento está vazio", Toast.LENGTH_SHORT).show();
                    return;
                }
                complement = editTextComplement.getText().toString();

                if(editTextCellphone.getText().toString().equals("")){
                    Toast.makeText(getContext(), "O campo celular está vazio", Toast.LENGTH_SHORT).show();
                    return;
                }
                cellphone = editTextCellphone.getText().toString();

                if(editTextEmail.getText().toString().equals("")){
                    Toast.makeText(getContext(), "O campo email está vazio", Toast.LENGTH_SHORT).show();
                    return;
                }
                email = editTextEmail.getText().toString();

                if(editTextPhone.getText().toString().equals("")){
                    Toast.makeText(getContext(), "O campo telefone está vazio", Toast.LENGTH_SHORT).show();
                    return;
                }
                phone = editTextPhone.getText().toString();

                int diseaseRadioButtonId = radioGroupDisease.getCheckedRadioButtonId();
                int chronicDiseaseRadioButtonId = radioGroupChronicDisease.getCheckedRadioButtonId();
                int surgeryRadioButtonId = radioGroupSurgery.getCheckedRadioButtonId();

                RadioButton radioButtonChronicDisease = studentView.findViewById(chronicDiseaseRadioButtonId);
                RadioButton radioButtonDisease = studentView.findViewById(diseaseRadioButtonId);
                RadioButton radioButtonSurgery = studentView.findViewById(surgeryRadioButtonId);

                try {
                    if(radioButtonSurgery.getText().toString().equals("Sim")){
                        surgery = true;
                    }else{
                        surgery = false;
                    }
                } catch(NullPointerException erro){
                    Toast.makeText(getContext(), "O campo cirurgia está vazio", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    if(radioButtonChronicDisease.getText().toString().equals("Sim")){
                        chronicDisease = true;
                    }else{
                        chronicDisease = false;
                    }
                } catch(NullPointerException erro){
                    Toast.makeText(getContext(), "O campo doença crônica está vazio", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    if(radioButtonDisease.getText().toString().equals("Sim")){
                        disease = true;
                    }else{
                        disease = false;
                    }
                } catch(NullPointerException erro){
                    Toast.makeText(getContext(), "O campo doença está vazio", Toast.LENGTH_SHORT).show();
                    return;
                }

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

                Log.e("OOOOOOIIIIINAME", studentEntity.getName());

            }
        });

                return studentView;
    }

    public void findView(View view){

        editTextName = view.findViewById(R.id.edit_text_name);
        editTextAge = view.findViewById(R.id.edit_text_age);
        editTextResponsible = view.findViewById(R.id.edit_text_responsible);
        editTextStreet = view.findViewById(R.id.edit_text_street);
        editTextNeighborhood = view.findViewById(R.id.edit_text_neighborhood);
        editTextCity = view.findViewById(R.id.edit_text_city);
        editTextState = view.findViewById(R.id.edit_text_state);
        editTextNumber = view.findViewById(R.id.edit_text_number);
        editTextComplement = view.findViewById(R.id.edit_text_complement);
        editTextCellphone = view.findViewById(R.id.edit_text_cellphone);
        editTextEmail = view.findViewById(R.id.edit_text_email);
        editTextPhone = view.findViewById(R.id.edit_text_phone);
        radioGroupDisease = view.findViewById(R.id.radio_group_disease);
        radioGroupChronicDisease = view.findViewById(R.id.radio_group_chronic_disease);
        radioGroupSurgery = view.findViewById(R.id.radio_group_surgery);
        buttonRegister = view.findViewById(R.id.button_register);

    }
}