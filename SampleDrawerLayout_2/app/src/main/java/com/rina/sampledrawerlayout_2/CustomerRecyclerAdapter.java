package com.rina.sampledrawerlayout_2;

import android.app.Application;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ppsc08 on 05-Dec-16.
 */

public class CustomerRecyclerAdapter extends RecyclerView.Adapter<CustomerRecyclerAdapter.ViewHolders> {

    String str [];

    TextView textView;
    ImageView imageView;


    private Context context;
    public static final int type_header = 0;
    public static final int type_item = 1;
    CustomerRecyclerAdapter(Context context, String str []){
        this.context = context ;
        this.str = str;
    }
    @Override
    public ViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == type_item){
            View view = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.customer_layout,parent,false);

            textView = (TextView)view.findViewById(R.id.textView);
            imageView = (ImageView)view.findViewById(R.id.imgView);

            return new ViewHolders(view,viewType);
        }
        else if (viewType == type_header){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header,parent,false);

            textView = (TextView)view.findViewById(R.id.textView);
            imageView = (ImageView)view.findViewById(R.id.imgView);

            return new ViewHolders(view,viewType);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolders holder, int position) {
       if (holder.holder_id == 1) {
           textView.setText(str[position]);
           imageView.setImageResource(R.mipmap.ic_launcher);
       }
    }

    @Override
    public int getItemCount() {
        return str.length;
    }

    @Override
    public  int getItemViewType(int position){
        if (isPositionHeader(position))
        return type_header;
        return type_item;
    }
    boolean isPositionHeader(int position){
        return  position==0;
    }


    class ViewHolders extends RecyclerView.ViewHolder{
        int holder_id;
        TextView email;
        ImageView userProfile;

        public ViewHolders(View itemView,int viewType) {
            super(itemView);

        }
    }
}
