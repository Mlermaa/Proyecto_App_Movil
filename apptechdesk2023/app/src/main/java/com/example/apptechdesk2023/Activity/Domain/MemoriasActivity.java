package com.example.apptechdesk2023.Activity.Domain;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptechdesk2023.Activity.Adaptor.PopularAdaptor;
import com.example.apptechdesk2023.R;

import java.util.ArrayList;

public class MemoriasActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterMEMORIAS;
    private RecyclerView recyclerViewMEMORIASList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorias);

        recyclerViewMEMORIAS();
    }



    private void recyclerViewMEMORIAS(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewMEMORIASList = findViewById(R.id.recyclerView_MEMEORIAS);
        recyclerViewMEMORIASList.setLayoutManager(linearLayoutManager);


        ArrayList<ProductosDomain> productosList=new ArrayList<>();
        //----MEMORIA RAM----
        productosList.add(new ProductosDomain("Memoria Ram Ddr3 8gb","memo_1","Memoria Ram Ddr3 8gb 1600mhz Skyd",55.440));
        productosList.add(new ProductosDomain("Memoria RAM 8GB 1 Kingston","memo_2","Memoria RAM color verde 8GB 1 Kingston KVR16N11/8",69.000));
        productosList.add(new ProductosDomain("Memoria RAM Crucial","memo_3","Memoria RAM color verde 16GB 1 Crucial CT16G4SFD8266",16.7000));

        adapterMEMORIAS=new PopularAdaptor(productosList);
        recyclerViewMEMORIASList.setAdapter(adapterMEMORIAS);
    }
}