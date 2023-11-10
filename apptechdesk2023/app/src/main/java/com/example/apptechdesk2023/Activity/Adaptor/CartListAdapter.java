package com.example.apptechdesk2023.Activity.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apptechdesk2023.Activity.Domain.ProductosDomain;
import com.example.apptechdesk2023.Helper.ManagementCart;
import com.example.apptechdesk2023.Interface.ChangeNumberItemListener;
import com.example.apptechdesk2023.R;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {
    private ArrayList<ProductosDomain> productosDomains;
    private ManagementCart managementCart;
    private ChangeNumberItemListener changeNumberItemListener;

    public CartListAdapter(ArrayList<ProductosDomain> productosDomains, Context context, ChangeNumberItemListener changeNumberItemListener) {
        this.productosDomains = productosDomains;
        this.managementCart = new ManagementCart(context);
        this.changeNumberItemListener = changeNumberItemListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent,false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CartListAdapter.ViewHolder holder, int position) {
        holder.title.setText(productosDomains.get(position).getTitle());
        holder.feeEachItem.setText(String.valueOf(productosDomains.get(position).getFee()));
        holder.totalEachItem.setText(String.valueOf(Math.round((productosDomains.get(position).getNumberIncart() * productosDomains.get(position).getFee()) * 100)/ 100));
        holder.num.setText(String.valueOf(productosDomains.get(position).getNumberIncart()));

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(productosDomains.get(position).getPic()
                ,"drawable",holder.itemView.getContext().getOpPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

        holder.plusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managementCart.plusNumberProductos(productosDomains,position , new ChangeNumberItemListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemListener.changed();
                    }
                });
            }
        });

        holder.minusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managementCart.minusNumberProductos(productosDomains, position, new ChangeNumberItemListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemListener.changed();
                    }
                });

            }
        });
    }

    @Override
    public int getItemCount() {

        return productosDomains.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
        TextView title, feeEachItem;
        ImageView pic, plusItem, minusItem;
        TextView totalEachItem, num;
        public ViewHolder(@NonNull View itemView) {
              super(itemView);
              title = itemView.findViewById(R.id.titleTxt);
              feeEachItem = itemView.findViewById(R.id.feeEachItem);
              pic = itemView.findViewById(R.id.picCart);
              totalEachItem = itemView.findViewById(R.id.totalEachItem);
              num = itemView.findViewById(R.id.numberItemTxt);
              plusItem = itemView.findViewById(R.id.plusCartBtn);
              minusItem = itemView.findViewById(R.id.minusCartBtn);
        }
    }
}
