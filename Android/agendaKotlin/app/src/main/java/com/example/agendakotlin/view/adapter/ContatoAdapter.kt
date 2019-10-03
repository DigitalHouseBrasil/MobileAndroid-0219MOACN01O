package com.example.agendakotlin.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.agendakotlin.R
import com.example.agendakotlin.model.Contato

class ContatoAdapter (var contatos : List<Contato>, val clickItem : (contato: Contato) -> Unit  ) : RecyclerView.Adapter<ContatoAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_lista_contato, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return contatos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var contato : Contato = contatos[position]
        holder.bind(contato)

        holder.itemView.setOnClickListener {
            clickItem(contato)
        }
    }


    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){

        var txtNome = itemView.findViewById<TextView>(R.id.txtNome)
        var txtTelefone = itemView.findViewById<TextView>(R.id.txtTelefone)

        fun bind(contato: Contato){


            txtNome.text = contato.nome
            txtTelefone.text = contato.telefone

        }

    }
}