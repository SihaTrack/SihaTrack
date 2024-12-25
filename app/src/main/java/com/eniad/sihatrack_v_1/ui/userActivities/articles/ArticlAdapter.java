package com.eniad.sihatrack_v_1.ui.userActivities.articles;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eniad.sihatrack_v_1.R;
import com.eniad.sihatrack_v_1.ui.userActivities.articles.Articl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ArticlAdapter extends RecyclerView.Adapter<ArticlAdapter.ArticlViewHolder> {

    private Context context;
    private ArrayList<Articl> articls = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(Articl articl);
    }

    public ArticlAdapter(Context context, ArrayList<Articl> articls, OnItemClickListener listener) {
        this.context = context;
        this.articls = articls;
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public ArticlViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.articl_list_item, parent, false);
        return new ArticlViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticlViewHolder holder, int position) {
        Articl articl = articls.get(position);

        // Set data to views
        holder.title.setText(articl.getTitle());
        holder.paragraph.setText(articl.getParaghraph());
        try {
            InputStream inputStream = context.getAssets().open(articl.getImage());
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            holder.image.setImageBitmap(bitmap);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Handle item clicks
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(articl);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articls.size();
    }

    public static class ArticlViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, paragraph;

        public ArticlViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.articlCardImageView);
            title = itemView.findViewById(R.id.articlCardTitle);
            paragraph = itemView.findViewById(R.id.articlCardParagraph);
        }
    }
}
