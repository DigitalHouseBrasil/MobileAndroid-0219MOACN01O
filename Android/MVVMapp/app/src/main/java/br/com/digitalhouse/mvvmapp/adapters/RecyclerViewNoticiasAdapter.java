package br.com.digitalhouse.mvvmapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.digitalhouse.mvvmapp.R;
import br.com.digitalhouse.mvvmapp.interfaces.RecyclerViewOnItemClickListener;
import br.com.digitalhouse.mvvmapp.model.Noticia;

public class RecyclerViewNoticiasAdapter extends RecyclerView.Adapter<RecyclerViewNoticiasAdapter.ViewHolder> {

    private List<Noticia> noticias;
    private RecyclerViewOnItemClickListener listener;

    public RecyclerViewNoticiasAdapter(List<Noticia> noticias, RecyclerViewOnItemClickListener listener) {
        this.noticias = noticias;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_noticia_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        final Noticia noticia= noticias.get(position);

        viewHolder.bind(noticia);

        //Vincula o evendo de click do item e repassa para o listener
        viewHolder.itemView.setOnClickListener(v -> {
            // Viculamos o click no item
            listener.onItemClick(noticia);
        });
    }

    @Override
    public int getItemCount() {
        return noticias.size();
    }

    public void update(List<Noticia> noticiasList) {
        this.noticias = noticiasList;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewTitulo;
        private TextView textViewDescricao;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitulo = itemView.findViewById(R.id.textViewTitle);
            textViewDescricao = itemView.findViewById(R.id.textViewDescricao);
        }

        public void bind(Noticia noticia) {
            textViewTitulo.setText(noticia.getTitle());
            textViewDescricao.setText(noticia.getDescription());
        }
    }
}
