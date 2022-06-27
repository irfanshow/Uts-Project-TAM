package com.example.foreignerchats.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.foreignerchats.PesanAdapter;
import com.example.foreignerchats.R;
import com.example.foreignerchats.model.ModelPesan;
import com.example.foreignerchats.model.ModelSemua;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class PesanActivity extends AppCompatActivity {
    Intent intent;
    EditText tulispesan;
    ImageButton kirimpesan;

    CardView cardView;
    LinearLayout layout;
    ImageView photouser;
    TextView namauser,negarauser;
    String idgabpengirim,idgabpenerima,waktusekarang,namapenerima,namapengirim,idpenerima,idpengirim,isipesan,negarasimpan,photopengirim;

    FirebaseAuth auth;
    FirebaseDatabase database;

    ImageButton kembali;
    RecyclerView semuachatrecycle;

    Calendar calendar;
    SimpleDateFormat simpleDateFormat;

    PesanAdapter adapter;
    ArrayList<ModelPesan> ListPesan;
    DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_pesan);
        tulispesan=findViewById(R.id.tulispesan);
        cardView=findViewById(R.id.cardView);
        kirimpesan=findViewById(R.id.sendBtn);
        layout =findViewById(R.id.layout);
        namauser=findViewById(R.id.namauser);
        photouser=findViewById(R.id.photouser);
        kembali=findViewById(R.id.back);
        intent=getIntent();
        negarauser = findViewById(R.id.negarauser);

        ListPesan=new ArrayList<>();
        semuachatrecycle=findViewById(R.id.semuachat);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        semuachatrecycle.setLayoutManager(linearLayoutManager);
        adapter=new PesanAdapter(PesanActivity.this,ListPesan);
        semuachatrecycle.setAdapter(adapter);



        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        calendar=Calendar.getInstance();
        simpleDateFormat=new SimpleDateFormat("hh:mm a");


        idpengirim=auth.getUid();
        negarasimpan=getIntent().getStringExtra("negarauser");
        idpenerima=getIntent().getStringExtra("idpenerima");
        namapenerima=getIntent().getStringExtra("namauser");



        idgabpengirim=idpengirim+idpenerima;
        idgabpenerima=idpenerima+idpengirim;




        DatabaseReference databaseReference=database.getReference().child("chats").child(idgabpengirim).child("Pesans");
        adapter=new PesanAdapter(PesanActivity.this,ListPesan);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ListPesan.clear();
                for(DataSnapshot snapshot1:snapshot.getChildren())
                {
                    ModelPesan Pesans=snapshot1.getValue(ModelPesan.class);
                    ListPesan.add(Pesans);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        reference = FirebaseDatabase.getInstance().getReference("Users").child(idpengirim);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                ModelSemua users = snapshot.getValue(ModelSemua.class);
                photopengirim = users.getPhotouser();
                namapengirim = users.getNamauser();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        negarauser.setText(negarasimpan);
        namauser.setText(namapenerima);
        String url=intent.getStringExtra("photouser");
        Glide.with(photouser)
                .load(url)
                .into(photouser);

        kirimpesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date=new Date();
                isipesan = tulispesan.getText().toString();
                waktusekarang=simpleDateFormat.format(calendar.getTime());
                ModelPesan pesan =new ModelPesan(isipesan,auth.getUid(),date.getTime(),waktusekarang);
                database=FirebaseDatabase.getInstance();
                database.getReference().child("chats")
                        .child(idgabpengirim)
                        .child("Pesans")
                        .push().setValue(pesan);
                database.getReference()
                        .child("chats")
                        .child(idgabpenerima)
                        .child("Pesans")
                        .push()
                        .setValue(pesan);
                reference= FirebaseDatabase.getInstance().getReference("Users").child(idpengirim).child("PernahChat").child(idpenerima);
                HashMap<String, Object> hashMap = new HashMap<>();
                   hashMap.put("namauser",namapenerima);
                   hashMap.put("id",idpenerima);
                   hashMap.put("photouser",url);
                   reference.updateChildren(hashMap);
                reference= FirebaseDatabase.getInstance().getReference("Users").child(idpenerima).child("PernahChat").child(idpengirim);
                HashMap<String, Object> hashMap2 = new HashMap<>();
                hashMap2.put("id",idpengirim);
                hashMap2.put("namauser",namapengirim);
                hashMap2.put("pesanterakhir",isipesan);
                hashMap2.put("photouser",photopengirim);
                reference.updateChildren(hashMap2);
                tulispesan.setText(null);



            }
        });






    }
    @Override
    public void onStart() {
        super.onStart();
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onStop() {
        super.onStop();
        if(adapter!=null)
        {
            adapter.notifyDataSetChanged();
        }
    }






}