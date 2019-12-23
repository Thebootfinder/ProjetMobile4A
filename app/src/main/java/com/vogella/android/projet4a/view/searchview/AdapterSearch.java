package com.vogella.android.projet4a.view.searchview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.vogella.android.projet4a.R;
import com.vogella.android.projet4a.model.searchmodel.Search;

import java.text.DecimalFormat;
import java.util.List;

public class AdapterSearch extends RecyclerView.Adapter<AdapterSearch.ViewHolder> {

    public static final String ID_SEARCH = "idSearch";
    private List<Search> values;
    private Context context;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Search item);
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
            txtHeader = (TextView) v.findViewById(R.id.firstLine3);
            txtFooter = (TextView) v.findViewById(R.id.secondLine3);
            txtLower = (TextView) v.findViewById(R.id.thirdLine3);
            imgView = v.findViewById(R.id.icon3);
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
    public AdapterSearch(List<Search> myDataset, Context context, OnItemClickListener listener)
    {
        this.context = context;
        values = myDataset;
        this.listener = listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AdapterSearch.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout_search, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }






    // Replace the contents of a view (invoked by the layout manager) ICICICICCIICCI
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Search currentAnime = values.get(position);
        holder.txtHeader.setText(currentAnime.getTitle());
        holder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(currentAnime);
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
        holder.txtLower.setText(currentAnime.getStartDate());
        Picasso.with(context).load(currentAnime.getImageUrl()).into(holder.imgView);
    }







    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}