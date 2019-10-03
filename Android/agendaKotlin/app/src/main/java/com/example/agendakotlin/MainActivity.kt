package com.example.agendakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agendakotlin.model.Contato
import com.example.agendakotlin.view.adapter.ContatoAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaContatosRecyclerView.adapter = ContatoAdapter(getListContato(), this::clickItem)
        listaContatosRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun clickItem(contato: Contato){

        Snackbar.make(listaContatosRecyclerView, "Nome da pessoa ${contato.nome}", Snackbar.LENGTH_SHORT).show()
    }

    private fun getListContato(): List<Contato> {
        var listContato : ArrayList<Contato> = ArrayList()

        listContato.add(Contato("Jessica", "1234566"))
        listContato.add(Contato("Eduardo", "1234566"))
        listContato.add(Contato("Luca", "1234566"))
        listContato.add(Contato("Sergio", "1234566"))
        listContato.add(Contato("Mayara", "1234566"))
        listContato.add(Contato("Debora", "1234566"))

        return listContato
    }
}
