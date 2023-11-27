package com.example.aplicativopdv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicativopdv.model.Venda;
import com.example.aplicativopdv.model.Vendedor;

import java.util.ArrayList;

public class VendaListAdapter {
    private ArrayList<Venda> listaVenda;
    private Context context;

    public VendaListAdapter(ArrayList<Venda> listaVenda, Context context) {
        this.listaVenda = listaVenda;
        this.context = context;

    }

    @NonNull
    @Override
    public VendedorListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(android.R.layout.item_list_venda, parent, false);


        return new VendaListAdapter().ViewHolder(listItem);
    }


    @Override
    public void onBindViewHolder(@NonNull VendedorListAdapter.ViewHolder holder, int position) {

        Venda vendaSelecionada = listaVenda.get(position);
        holder.tvIdVenda.setText(String.valueOf(vendaSelecionada.getId()));
        holder.tvVendedorVenda.setText(vendaSelecionada.getNome());
        holder.tvProdutoVenda.setText(vendaSelecionada.getSenha());
    }

    @Override
    public int getItemCount() {
        return this.listaVenda.size();
    }

}
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvIdVenda;
        public TextView tvVendedorVenda;
        public TextView tvProdutoVenda;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.tvIdVenda = itemView.findViewById(R.id.tvIdVenda);
            this.tvVendedorVenda = itemView.findViewById(R.id.tvVendedorVenda);
            this.tvProdutoVenda = itemView.findViewById(R.id.tvProdutoVenda);
        }
    }

