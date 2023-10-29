package com.example.apptechdesk2023.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.apptechdesk2023.Activity.Domain.ProductosDomain;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private  TinyDB tinyBD;

    public ManagementCart(Context context){
        this.context = context;
        this.tinyBD = new TinyDB(context);
    }

    public void insertProductos(ProductosDomain item){
        ArrayList<ProductosDomain> listProductos=getListCart();
                boolean existAlready=false;
                int n =0;
                for(int i = 0; i < listProductos.size(); i++){
                    if(listProductos.get(i).getTitle().equals(item.getTitle())) {
                        existAlready = true;
                        n = i;
                        break;
                    }
                }

                if (existAlready) {
                    listProductos.get(n).setNumberIncart(item.getNumberIncart());
                } else {
                    listProductos.add(item);
                }
                tinyBD.putListObject("CardList",listProductos);
                Toast.makeText(context, "Añadido al carrito", Toast.LENGTH_SHORT).show();
   }


    public  ArrayList<ProductosDomain> getListCart(){
        return tinyBD.getListObject("CartList");
    }
}
