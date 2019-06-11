package br.com.digitalhouse.revisaoesharedprefences.adapters;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.revisaoesharedprefences.R;
import br.com.digitalhouse.revisaoesharedprefences.interfaces.RecyclerViewClickListener;
import br.com.digitalhouse.revisaoesharedprefences.model.Contato;

public class RecyclerViewContatosAdapter extends RecyclerView.Adapter<RecyclerViewContatosAdapter.ViewHolder> {

    private List<Contato> contatos;
    private RecyclerViewClickListener listener;

    public RecyclerViewContatosAdapter(List<Contato> contatos, RecyclerViewClickListener listener) {
        this.contatos = contatos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contato_recyclerview_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {
        final Contato contato = contatos.get(position);
        viewHolder.setConteudoNaTela(contato);

        // seta o click para ir para outra tela (Detalhe)
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(contato);
            }
        });

        viewHolder.imageViewFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Se for favoirito muda a imagem
                if (contato.isFavorite()){
                    viewHolder.imageViewFavorite.setImageResource(R.drawable.ic_favorite_fill);
                }else {
                    viewHolder.imageViewFavorite.setImageResource(R.drawable.ic_favorite_border);
                }

                // configura um novo valor para o favorito
                contato.setFavorite(!contato.isFavorite());
            }
        });

        // Click em imagem de delete
        viewHolder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contatos.size();
    }

    //Método para remover o item
    public void removeItem(int position){
        contatos.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //Atributos dos elementos
        private ImageView imageViewFoto;
        private TextView textViewNome;
        private TextView textViewTelefone;
        protected ImageView imageViewFavorite;
        protected ImageView imageViewDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Inicializamos as views
            imageViewFoto = itemView.findViewById(R.id.imageViewFoto);
            textViewNome = itemView.findViewById(R.id.textViewNome);
            textViewTelefone = itemView.findViewById(R.id.textViewTelefone);
            imageViewFavorite = itemView.findViewById(R.id.imageViewFavorite);
            imageViewDelete = itemView.findViewById(R.id.imageViewDelete);
        }

        //Atribui o as views os valores da variável contato
        public void setConteudoNaTela(Contato contato) {
            imageViewFoto.setImageDrawable(ContextCompat.getDrawable(imageViewFoto.getContext(), contato.getImagem()));
            textViewNome.setText(contato.getNome());
            textViewTelefone.setText(contato.getTelefone());
        }
    }
}
