package com.example.apptechdesk2023.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptechdesk2023.Activity.Adaptor.CategoryAdaptor;
import com.example.apptechdesk2023.Activity.Adaptor.PopularAdaptor;
import com.example.apptechdesk2023.Activity.Domain.CPUActivity;
import com.example.apptechdesk2023.Activity.Domain.CategoryDomain;
import com.example.apptechdesk2023.Activity.Domain.MemoriasActivity;
import com.example.apptechdesk2023.Activity.Domain.PerfilActivity;
import com.example.apptechdesk2023.Activity.Domain.PlacasActivity;
import com.example.apptechdesk2023.Activity.Domain.ProductosDomain;
import com.example.apptechdesk2023.Activity.Domain.RefrigeradorActivity;
import com.example.apptechdesk2023.R;
import com.example.apptechdesk2023.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter, adapter2;
private  RecyclerView recyclerViewCategoryList, recyclerViewPopularList;
private ConstraintLayout cpuBtn;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView msg=(TextView)findViewById(R.id.bienvenida);
        String user = getIntent().getExtras().getString("usuario");
        msg.setText("Bienvenido " + user);

        recyclerViewCategory() ;
        recyclerViewPopular();
        bottomNavigation();
      }




    public void bottoCPU(View view){
        Intent cpu = new Intent(this, CPUActivity.class);
        startActivity(cpu);
    }

    public void bottoREFRIG(View view){
        Intent refrig = new Intent(this, RefrigeradorActivity.class);
        startActivity(refrig);
    }
    public void bottoPLACAS(View view){
        Intent placas = new Intent(this, PlacasActivity.class);
        startActivity(placas);
    }

    public void bottoMEMORIAS(View view){
        Intent memorias = new Intent(this, MemoriasActivity.class);
        startActivity(memorias);
    }

    public void bottoPERFIL(View view){
        Intent perfil = new Intent(this, PerfilActivity.class);
        startActivity(perfil);
    }
    public void bottoHOME(View view){
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }

    public void bottoLOGIN(View view){
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
    }






    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn);
        LinearLayout homeBtn=findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

    }


      private void recyclerViewCategory(){
          LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
          recyclerViewCategoryList = findViewById(R.id.recyclerView2);
          recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

          ArrayList<CategoryDomain> category = new ArrayList<>();
          category.add(new CategoryDomain("CPU","cpu"));
          category.add(new CategoryDomain("Refrigerador","refrigerador"));
          category.add(new CategoryDomain("Placas","placas"));
          category.add(new CategoryDomain("Memorias","memoria"));
          category.add(new CategoryDomain("Tarjeta Grafica","tarjetagrafica"));
          category.add(new CategoryDomain("Disco Duro","discuduro"));
          category.add(new CategoryDomain("Alimentacion","alimentacion"));
          category.add(new CategoryDomain("Cajas","cajas"));
          category.add(new CategoryDomain("Perifericos","perifericos"));

          adapter= new CategoryAdaptor(category);
          recyclerViewCategoryList.setAdapter(adapter);
      }

      private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);


        ArrayList<ProductosDomain> productosList=new ArrayList<>();

        //----CPU----
        productosList.add(new ProductosDomain("Procesador Intel Core i7-3770","cpu_1","Procesador gamer Intel Core i7-3770 BX80637I73770 de 4 núcleos y 3.9GHz de frecuencia con gráfica integrada",618.000));
        productosList.add(new ProductosDomain("Procesador Intel Core i7-2600","cpu_2","Procesador gamer Intel Core i7-2600 BX80623I72600 de 4 núcleos y 3.8GHz de frecuencia con gráfica integrada",598.000));
        productosList.add(new ProductosDomain("Procesador AMD Ryzen 5 5600G ","cpu_3","Procesador gamer AMD Ryzen 5 5600G 100-100000252BOX de 6 núcleos y 4.4GHz con gráfica integrada",600.000));

        //----REFRIGERADOR DE CPU----
        productosList.add(new ProductosDomain("Disipador Aire Rgb Multicolor","refrig_1","Disipador Computador Refigeracion Aire Rgb Multicolor Cooler",58.900));
        productosList.add(new ProductosDomain("Cooler Ventilador 12 X 12","refrig_2","Cooler Ventilador 12 X 12 110v Pc O Incubadora 110 Voltios",27.000));
        productosList.add(new ProductosDomain("Disipador Fan Cooler","refrig_3","Fan Cooler Ventilador Pc @gs",19.620));

        //----PLACA BASE----
        productosList.add(new ProductosDomain("Placa Motherboard Amd ","placa_1","Motherboard Amd Gigabyte Ga-b450m Ds3h V2 Am4",402.900));
        productosList.add(new ProductosDomain("Tarjeta Madre Asus Prime B450m","placa_2","Tarjeta Madre Asus Prime B450m-a Ii Usb3 Hdmi Ddr4 Pcie Am4 Color Negro",450.000));
        productosList.add(new ProductosDomain("Tarjeta Amd Gigabyte","placa_3","Tarjeta Madre Amd Gigabyte B550m Aorus Elite Am4 Ddr4 128gb",600.000));

        //----MEMORIA RAM----
        productosList.add(new ProductosDomain("Memoria Ram Ddr3 8gb","memo_1","Memoria Ram Ddr3 8gb 1600mhz Skyd",55.440));
        productosList.add(new ProductosDomain("Memoria RAM 8GB 1 Kingston","memo_2","Memoria RAM color verde 8GB 1 Kingston KVR16N11/8",69.000));
        productosList.add(new ProductosDomain("Memoria RAM Crucial","memo_3","Memoria RAM color verde 16GB 1 Crucial CT16G4SFD8266",16.7000));

        //----TARJETA GRAFICA----
        productosList.add(new ProductosDomain("Tarjeta Grafica AMD Radeon RX 500 ","tgraf_1","Tarjeta de video AMD Radeon RX 500 Series RX 580 8GB",615.000));
        productosList.add(new ProductosDomain("Tarjeta Grafica Nvidia Gtx 750","tgraf_2","Tarjeta Grafica Video Nvidia Gtx 750 Ti Ddr5 4gb",564.000));
        productosList.add(new ProductosDomain("Tarjeta Grafica Rx 580 8gb","tgraf_3","Tarjetas Gráficas Rx 580 8gb 256bit 2048sp Gddr5",600.523));

        //----DISCO DURO----
        productosList.add(new ProductosDomain("Disco Solido SSD interno PNY SSD7CS900","dduro_1","Disco sólido SSD interno PNY SSD7CS900-480-RB 480GB negro",128.000));
        productosList.add(new ProductosDomain("Disco Solido Crucial CT240BX500SSD1","dduro_2","Disco sólido SSD interno Crucial CT240BX500SSD1 240GB negro",90.000));
        productosList.add(new ProductosDomain("Disco Solido Adata Ultimate SU650","dduro_3","Disco sólido SSD interno Adata Ultimate SU650 ASU650SS-480GT-R 480GB negro",114.998));

        //----SISTEMA ALIMENTACION----
        productosList.add(new ProductosDomain("Fuente poder Gigabyte Ud850gm","salime_1","Fuente De Poder Gigabyte Ud850gm 850w 100-240v 80 Plus Oro",659.900));
        productosList.add(new ProductosDomain("Fuente poder Xpg Pylon 650w","salime_2","Fuente De Poder Xpg Pylon 650w Bronze",350.000));
        productosList.add(new ProductosDomain("Fuente poder  Giga-Byte Technology P650B","salime_3","Fuente de poder para PC Giga-Byte Technology P650B 650W negra 100V/240V",399.900));

        //----CAJA----
        productosList.add(new ProductosDomain("Caja Atx Wattana","caja_1","Caja Atx Wattana Vorlog Tg Argb",345.000));
        productosList.add(new ProductosDomain("Gabinete Pc Gamer Vidri","caja_2","Gabinete Pc Gamer Vidrio Templado, Caja Atx / 3 Coolers Rgb",279.900));
        productosList.add(new ProductosDomain("Chasis Gamer Rxe A03","caja_3","Chasis Gamer Rxe A03 Vidrio Templado",199.000));

        //----PERIFERICOS----
          productosList.add(new ProductosDomain("Mouse Logitech G Serie","perif_1","Mouse gamer de juego Logitech G Series Lightsync G203 negro",89.900));
          productosList.add(new ProductosDomain("Mouse Delux M800bu Rgb","perif_2","Mouse Gamer Delux M800bu Rgb, Programable 6 Botones 12400dpi",59.900));
          productosList.add(new ProductosDomain("Mouse Delux M618mini GX ","perif_3","Mouse vertical Delux M618mini GX FCT3065 black",90.000));
          productosList.add(new ProductosDomain("Mouse Logitech Brio 4K 90FPS","perif_4","Cámara web Logitech Brio 4K 90FPS color negro",644.888));
          productosList.add(new ProductosDomain("Cámara web Linkon WEBLIGHT2K3","perif_5","Cámara web Linkon WEBLIGHT2K3",129.990));
          productosList.add(new ProductosDomain("Parlante Gamer Maxell Usb","perif_6","Parlante Gamer Maxell Usb Conexión Usb 3.5mm Negro Luz Rgb",46.833));
          productosList.add(new ProductosDomain("Parlantes Gamer Xtrike Me Rgb","perif_7","Parlantes Gamer Xtrike Me Rgb Pc Computador Portatil Gaming",69.900));
          productosList.add(new ProductosDomain("Parlante Gamer Xtrike","perif_8","Parlante Gamer Xtrike Me 2.1 Sk-610 Rgb Pc Musica Juego Css®",109.900));
          productosList.add(new ProductosDomain("Teclado gamer Redragon Harpe Pro K503A","perif_9","Teclado gamer Redragon Harpe Pro K503A RGB QWERTY español color negro con luz RGB",109.900));

        adapter2=new PopularAdaptor(productosList);
        recyclerViewPopularList.setAdapter(adapter2);



      }

}