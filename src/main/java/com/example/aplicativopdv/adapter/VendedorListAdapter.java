package com.example.aplicativopdv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicativopdv.model.Produto;
import com.example.aplicativopdv.model.Vendedor;

import java.util.ArrayList;

public class VendedorListAdapter extends RecyclerView.Adapter<VendedorListAdapter.ViewHolder>{

    private ArrayList<Vendedor> listaVendedores;
    private Context context;

    public VendedorListAdapter(ArrayList<Vendedor> listaVendedores, Context context) {
        this.listaVendedores = listaVendedores;
        this.context = context;

    }

    @NonNull
    @Override
    public VendedorListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(android.R.layout.item_list_vendedor, parent, false);


        return new VendedorListAdapter().ViewHolder(listItem);
    }


    @Override
    public void onBindViewHolder(@NonNull VendedorListAdapter.ViewHolder holder, int position) {

        Vendedor vendedorSelecionado = listaVendedores.get(position);
        holder.tvIdVendedor.setText(String.valueOf(vendedorSelecionado.getId()));
        holder.tvNomeVendedor.setText(vendedorSelecionado.getNome());
        holder.tvSenha.setText(vendedorSelecionado.getSenha());
    }

    @Override
    public int getItemCount() {
        return this.listaVendedores.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvIdVendedor;
        public TextView tvNomeVendedor;
        public TextView tvSenha;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.tvIdVendedor = itemView.findViewById(R.id.tvId);
            this.tvNomeVendedor = itemView.findViewById(R.id.tvNome);
            this.tvSenha = itemView.findViewById(R.id.tvSenha);
        }
    }

}


