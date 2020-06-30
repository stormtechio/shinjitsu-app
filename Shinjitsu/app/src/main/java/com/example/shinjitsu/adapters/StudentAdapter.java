package com.example.shinjitsu.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shinjitsu.R;
import com.example.shinjitsu.activities.StudentDetailsActivity;
import com.example.shinjitsu.entities.StudentEntity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {

    List<StudentEntity> students;
    private static final String STUDENTS = "students";



    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView cellphone;
        public TextView responsible;
        public CardView cardView;
        public ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_student_text);
            cellphone = itemView.findViewById(R.id.cellphone_student_text);
            responsible = itemView.findViewById(R.id.responsible_student_text);
            cardView = itemView.findViewById(R.id.cardview_students);
            imageView = itemView.findViewById(R.id.imageview_student);
        }
    }
    public StudentAdapter(List<StudentEntity> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public StudentAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view  =  LayoutInflater.from(parent.getContext()).inflate(R.layout.students_cardview, parent, false);
        StudentAdapter.MyViewHolder myViewHolder = new StudentAdapter.MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final StudentAdapter.MyViewHolder holder, final int position) {

        final Context context = holder.cardView.getContext();
        final StudentEntity studentEntity = students.get(position);

        holder.name.setText(studentEntity.getName());
        holder.imageView.setImageResource(R.drawable.user);
        holder.cellphone.setText(studentEntity.getCellphone());
        holder.responsible.setText(studentEntity.getResponsible());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JSONObject studentJSON = new JSONObject();

                StudentEntity student = students.get(position);

                try {
                    studentJSON.put("name", student.getName());

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                Intent intent = new Intent(context, StudentDetailsActivity.class);
                intent.putExtra(STUDENTS, studentJSON.toString());
                context.startActivity(intent);
            }
        });

//        if(payment.isStatus()){
//            holder.imageView.setImageResource(R.drawable.green_shape);
//        }else{
//            holder.imageView.setImageResource(R.drawable.red_shape);
//        }




//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                builder.setMessage(payment.getName()).setTitle("Detalhe do Pagamento");
//
//                if(payment.isStatus() == false) {
//                    LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                    View viewDialog = layoutInflater.inflate(R.layout.dialog, null);
//
//                    viewDialog.findViewById(R.id.button_pay).setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            holder.imageView.setImageResource(R.drawable.green_shape);
//                            Toast.makeText(context, "Pago", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//
//                    builder.setView(viewDialog);
//                }
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

}
