package com.example.listacontato.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.listacontato.R;
import com.example.listacontato.model.Contatos;

import java.util.List;

public class ContatoAdapter extends RecyclerView.Adapter<ContatoAdapter.ViewHolder> {

    private List<Contatos> listaContatos;

    public ContatoAdapter(List<Contatos> listaContatos) {
        this.listaContatos = listaContatos;
    }

    @NonNull
    @Override
    //Infla o layout do item e retorna uma nova instancia do ViewHolder
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_lista_item_contato, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //Criar uma nova instancia
        Contatos novoContato = listaContatos.get(i);

        //adiciona o valor da instancia para ser atribuido no componente
        viewHolder.bind(novoContato);
    }

    //Retorna o tamanho da lista
    @Override
    public int getItemCount() {
        return listaContatos.size();
    }




    // CLASSE ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nomeContato;
        TextView telefonContato;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeContato = itemView.findViewById(R.id.txtNome);
            telefonContato = itemView.findViewById(R.id.txtTelefone);
        }

        public void bind(Contatos contato) {
            nomeContato.setText(contato.getNome());
            telefonContato.setText(contato.getTelefone());
        }
    }
}
