package com.example.apptechdesk2023.Activity.Domain;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptechdesk2023.Activity.Adaptor.PopularAdaptor;
import com.example.apptechdesk2023.R;

import java.util.ArrayList;


public class RefrigeradorActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterREFRIG;
    private RecyclerView recyclerViewREFRIGList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refrigerador);

        recyclerViewREFRIG();
    }



    private void recyclerViewREFRIG(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewREFRIGList = findViewById(R.id.recyclerView_REFRIG);
        recyclerViewREFRIGList.setLayoutManager(linearLayoutManager);


        ArrayList<ProductosDomain> productosList=new ArrayList<>();
        //----REFRIGERADOR DE CPU----
        productosList.add(new ProductosDomain("Disipador Aire Rgb Multicolor","refrig_1","Disipador Computador Refigeracion Aire Rgb Multicolor Cooler",58.900));
        productosList.add(new ProductosDomain("Cooler Ventilador 12 X 12","refrig_2","Cooler Ventilador 12 X 12 110v Pc O Incubadora 110 Voltios",27.000));
        productosList.add(new ProductosDomain("Disipador Fan Cooler","refrig_3","Fan Cooler Ventilador Pc @gs",19.620));

        adapterREFRIG=new PopularAdaptor(productosList);
        recyclerViewREFRIGList.setAdapter(adapterREFRIG);
    }
}