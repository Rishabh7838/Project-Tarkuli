package com.example.rish.projecttarkuli.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rish.projecttarkuli.Model.Customer;
import com.example.rish.projecttarkuli.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>{

    private Context context;
    private ArrayList<Customer> CustomerList = new ArrayList<>();

    public CustomerAdapter(Context context, ArrayList<Customer> CustomerList) {
        this.context = context;
        this.CustomerList = CustomerList;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_layout,viewGroup,false);



        return new CustomerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder CustomerViewHolder, int pos) {

        CustomerViewHolder.Cust_Name.setText(CustomerList.get(pos).getName());
        CustomerViewHolder.Cust_Loc.setText(CustomerList.get(pos).getLocation());


        
    }

    @Override
    public int getItemCount() {
        return CustomerList.size();
    }


    public class CustomerViewHolder extends RecyclerView.ViewHolder{
        private TextView Cust_Name,Cust_Loc;
        



        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);

            Cust_Name = itemView.findViewById(R.id.cust_name_tv);
            Cust_Loc = itemView.findViewById(R.id.cust_loc_tv);
            


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    
                }
            });

        }
    }
}
    
