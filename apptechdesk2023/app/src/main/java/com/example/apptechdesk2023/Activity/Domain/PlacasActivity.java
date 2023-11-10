package com.example.apptechdesk2023.Activity.Domain;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptechdesk2023.Activity.Adaptor.PopularAdaptor;
import com.example.apptechdesk2023.R;

import java.util.ArrayList;

public class PlacasActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPLACAS;
    private RecyclerView recyclerViewPLACASList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placas);

        recyclerViewPLACAS();
    }



    private void recyclerViewPLACAS(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewPLACASList = findViewById(R.id.recyclerView_PLACAS);
        recyclerViewPLACASList.setLayoutManager(linearLayoutManager);


        ArrayList<ProductosDomain> productosList=new ArrayList<>();
        //----PLACA BASE----
        productosList.add(new ProductosDomain("Placa Motherboard Amd ","placa_1","Motherboard Amd Gigabyte Ga-b450m Ds3h V2 Am4",402.900));
        productosList.add(new ProductosDomain("Tarjeta Madre Asus Prime B450m","placa_2","Tarjeta Madre Asus Prime B450m-a Ii Usb3 Hdmi Ddr4 Pcie Am4 Color Negro",450.000));
        productosList.add(new ProductosDomain("Tarjeta Amd Gigabyte","placa_3","Tarjeta Madre Amd Gigabyte B550m Aorus Elite Am4 Ddr4 128gb",600.000));

        adapterPLACAS=new PopularAdaptor(productosList);
        recyclerViewPLACASList.setAdapter(adapterPLACAS);
    }
}