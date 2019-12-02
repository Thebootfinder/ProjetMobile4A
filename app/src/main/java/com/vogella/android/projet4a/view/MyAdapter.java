package com.vogella.android.projet4a.view;


import java.text.DecimalFormat;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.vogella.android.projet4a.R;
import com.vogella.android.projet4a.model.Anime;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Anime> values;
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;
        public ImageView imgView;
        public TextView txtLower;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            txtLower = (TextView) v.findViewById(R.id.thirdLine);
            imgView = v.findViewById(R.id.icon);
        }
    }

/*
    public void add(int position, String item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }*/

    // Provide a suitable constructor (depends on the kind of dataset) ICICICICICCICICICICICICICI
    public MyAdapter(List<Anime> myDataset , Context context)
    {
       this.context = context;
        values = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }






    // Replace the contents of a view (invoked by the layout manager) ICICICICCIICCI
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Anime currentAnime = values.get(position);
        holder.txtHeader.setText(currentAnime.getTitle());
        holder.txtHeader.setOnClickListener(new OnClickListener() {

            @Override  // ICI PROBLEME
            public void onClick(View v) {
              //  remove(position);  // Pourquoi remove veut pas ?
            }
        });


        DecimalFormat df = new DecimalFormat("#.##");
        if(currentAnime.getScore() < 2) {
            holder.txtFooter.setText("★☆☆☆☆   "+df.format(currentAnime.getScore()));
        } else if(currentAnime.getScore() < 4) {
            holder.txtFooter.setText("★★☆☆☆   "+df.format(currentAnime.getScore()));
        } else if(currentAnime.getScore() < 6) {
            holder.txtFooter.setText("★★★☆☆   "+df.format(currentAnime.getScore()));
        } else if(currentAnime.getScore() < 8) {
            holder.txtFooter.setText("★★★★☆   "+df.format(currentAnime.getScore()));
        } else if(currentAnime.getScore() < 10) {
            holder.txtFooter.setText("★★★★★   " + df.format(currentAnime.getScore()));
        } else {
            holder.txtFooter.setText("☆☆☆☆☆   "+df.format(currentAnime.getScore()));
        }
       // holder.txtFooter.setText("Footer: " + name);
        holder.txtLower.setText(currentAnime.getStart_date());
        Picasso.with(context).load(currentAnime.getImage_url()).into(holder.imgView);
    }







    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}