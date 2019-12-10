package com.vogella.android.projet4a.view.MangaView;


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
import com.vogella.android.projet4a.model.MangaModel.Manga;

public class AdapterManga extends RecyclerView.Adapter<AdapterManga.ViewHolder> {

    public static final String ID_MANGA = "idManga";
    private List<Manga> values;
    private Context context;
   private final OnItemClickListener listener;

    public interface OnItemClickListener {
            void onItemClick(Manga item);
    }

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
            txtHeader = (TextView) v.findViewById(R.id.firstLine2);
            txtFooter = (TextView) v.findViewById(R.id.secondLine2);
            txtLower = (TextView) v.findViewById(R.id.thirdLine2);
            imgView = v.findViewById(R.id.icon2);
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
    public AdapterManga(List<Manga> myDataset, Context context, OnItemClickListener listener)
    {
        this.context = context;
        values = myDataset;
        this.listener = listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AdapterManga.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout_manga, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }






    // Replace the contents of a view (invoked by the layout manager) ICICICICCIICCI
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Manga currentManga = values.get(position);
        holder.txtHeader.setText(currentManga.getTitle());
        holder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(currentManga);
            }
        });


        DecimalFormat df = new DecimalFormat("#.##");
        if(currentManga.getScore() < 2) {
            holder.txtFooter.setText("★☆☆☆☆   "+df.format(currentManga.getScore()));
        } else if(currentManga.getScore() < 4) {
            holder.txtFooter.setText("★★☆☆☆   "+df.format(currentManga.getScore()));
        } else if(currentManga.getScore() < 6) {
            holder.txtFooter.setText("★★★☆☆   "+df.format(currentManga.getScore()));
        } else if(currentManga.getScore() < 8) {
            holder.txtFooter.setText("★★★★☆   "+df.format(currentManga.getScore()));
        } else if(currentManga.getScore() < 10) {
            holder.txtFooter.setText("★★★★★   " + df.format(currentManga.getScore()));
        } else {
            holder.txtFooter.setText("☆☆☆☆☆   "+df.format(currentManga.getScore()));
        }
        // holder.txtFooter.setText("Footer: " + name);
        holder.txtLower.setText(currentManga.getType());
        Picasso.with(context).load(currentManga.getImageUrl()).into(holder.imgView);
    }







    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}