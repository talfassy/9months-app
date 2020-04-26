package com.first.a9monthsproject;

//this is a java class
// //adapter provides access to the data items
// adapter is responsible for making a view for each item in the data set

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private Context mContext;
    private List<UploadImage> mUpload;
    private OnItemClickListener mListener;

    public ImageAdapter ( Context con , List <UploadImage> upl){
        mContext =con;
        mUpload =upl;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        UploadImage uploadCurr = mUpload.get(position);
        holder.textViewName.setText(uploadCurr.getmName());
        //load the image into the imageView
        Picasso.with(mContext).load(uploadCurr.getmImageUrl()).fit().centerCrop().into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mUpload.size();
        ///show how many items( image and title) we have in our list
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {

        public TextView textViewName;
        public ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName= itemView.findViewById(R.id.text_view_item);
            imageView = itemView.findViewById(R.id.image_view_item);

            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mListener !=null){
                int postion=getAdapterPosition();
                if(postion != RecyclerView.NO_POSITION){
                    mListener.OnItemClick(postion);

                }
            }
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("selcet");
            MenuItem deleteAction = menu.add(Menu.NONE, 1, 1, "delete");
            deleteAction.setOnMenuItemClickListener(this);
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if(mListener !=null){
                int postion=getAdapterPosition();
                if(postion != RecyclerView.NO_POSITION){
                    //we want to check what item was click ( we swt only delete item)
                    switch (item.getItemId()){
                        case 1:
                            mListener.OnDeleteClick(postion);
                            return true;

                    }

                }
            }
            return false;
        }
    }
// use to delete and make changes in the uploads images
    public interface OnItemClickListener{
        void OnItemClick( int position);
        void OnDeleteClick( int position);

    }

    //use to use the interface we create
     public void setOnItemClickListner( OnItemClickListener lis){
        mListener=lis;
     }

}
