package com.example.apptechdesk2023.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.apptechdesk2023.Activity.Domain.ProductosDomain;
import com.example.apptechdesk2023.Interface.ChangeNumberItemListener;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private  TinyDB tinyDB;

    public ManagementCart(Context context){
        this.context = context;
        this.tinyDB = new TinyDB(context);
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
                tinyDB.putListObject("CardList",listProductos);
                Toast.makeText(context, "Añadido al carrito", Toast.LENGTH_SHORT).show();
   }


    public ArrayList<ProductosDomain> getListCart() {
        return tinyDB.getListObject("CartList");
    }

    public void plusNumberProductos(ArrayList<ProductosDomain> listProductos, int position, ChangeNumberItemListener changeNumberItemListener){
        listProductos.get(position).setNumberIncart(listProductos.get(position).getNumberIncart() + 1);
        tinyDB.putListObject("CarList", listProductos);
        changeNumberItemListener.changed();
    }

    public void minusNumberProductos(ArrayList<ProductosDomain> listProductos, int position, ChangeNumberItemListener changeNumberItemListener){
        if (listProductos.get(position).getNumberIncart()==1) {
            listProductos.remove(position);
        }else {
            listProductos.get(position).setNumberIncart(listProductos.get(position).getNumberIncart() - 1);
        }
        tinyDB.putListObject("Cartlist", listProductos);
        changeNumberItemListener.changed();
    }

    public Double getTotalFee() {
        ArrayList<ProductosDomain> listProductos = getListCart();
        double fee = 0;
        for(int i = 0; i < listProductos.size(); i++) {
            fee = fee + (listProductos.get(i).getFee() * listProductos.get(i).getNumberIncart());
        }
        return  fee;

    }

}
