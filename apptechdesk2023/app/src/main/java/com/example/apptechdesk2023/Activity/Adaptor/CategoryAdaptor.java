package com.example.apptechdesk2023.Activity.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apptechdesk2023.Activity.Domain.CategoryDomain;
import com.example.apptechdesk2023.R;

import java.util.ArrayList;

public class CategoryAdaptor extends RecyclerView.Adapter<CategoryAdaptor.ViewHolder> {

    ArrayList<CategoryDomain>categoryDomains;

    public CategoryAdaptor(ArrayList<CategoryDomain> categoryDomains) {
        this.categoryDomains = categoryDomains;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdaptor.ViewHolder holder, int position) {
        holder.categoryName.setText(categoryDomains.get(position).getTitle());
        String picUrl="";
        switch (position){
            case 0:{
                picUrl="cpu";
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background1));
                break;
            }
            case 1:{
                picUrl="refrigerador";
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background2));
                break;
            }
            case 2:{
                picUrl="placas";
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background3));
                break;
            }
            case 3:{
                picUrl="memoria";
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background4));
                break;
            }
            case 4:{
                picUrl="tarjetagrafica";
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background5));
                break;
            }
            case 5:{
                picUrl="discuduro";
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background6));
            break;
            }
            case 6:{
                picUrl="alimentacion";
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background7));
                break;
            }
            case 7:{
                picUrl="cajas";
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background8));
                break;
            }
            case 8:{
                picUrl="perifericos";
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background9));
                break;
            }
        }
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(picUrl,"drawable",holder.itemView.getContext().getOpPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.categoryPic);
    }

    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainlayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryPic = itemView.findViewById(R.id.categoryPic);
            mainlayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}
