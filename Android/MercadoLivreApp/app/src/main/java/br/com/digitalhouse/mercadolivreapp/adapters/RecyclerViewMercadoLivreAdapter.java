package br.com.digitalhouse.mercadolivreapp.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.digitalhouse.mercadolivreapp.R;
import br.com.digitalhouse.mercadolivreapp.model.Result;


public class RecyclerViewMercadoLivreAdapter extends RecyclerView.Adapter<RecyclerViewMercadoLivreAdapter.ViewHolder> {

    private List<Result> newsList;

    public RecyclerViewMercadoLivreAdapter(List<Result> newsList) {
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result results = newsList.get(position);
        holder.bind(results);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDescription;
        private ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDescription = itemView.findViewById(R.id.textViewDescripotion);
            imageView = itemView.findViewById(R.id.imageView);
        }

        void bind(Result result) {
            textViewTitle.setText(result.getTitle());
            textViewDescription.setText(result.getAddress().getStateName());
            if (result.getThumbnail() != null) {
                Picasso.get().setIndicatorsEnabled(true);
                Picasso.get()
                        .load(result.getThumbnail())
                        .error(R.mipmap.ic_launcher)
                        .into(imageView);
            }
        }
    }

    public void clear(){
        this.newsList.clear();
        notifyDataSetChanged();
    }

    public void update(List<Result> results) {
        if (newsList.isEmpty()) {
            this.newsList = results;
        } else {
            this.newsList.addAll(results);
            notifyDataSetChanged();
        }
    }
}

