package com.example.aplicativopdv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicativopdv.model.Produto;

import java.util.ArrayList;

public class ProdutoListAdapter extends RecyclerView.Adapter<ProdutoListAdapter.ViewHolder> {

    private ArrayList<Produto> listaProdutos;
    private Context context;

    public ProdutoListAdapter(ArrayList<Produto> listaProdutos, Context context) {
        this.listaProdutos = listaProdutos;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(android.R.layout.item_list_produto, parent, false);


        return new ViewHolder(listItem);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Produto produtoSelecionado = listaProdutos.get(position);
        holder.tvId.setText(String.valueOf(produtoSelecionado.getId()));
        holder.tvNome.setText(produtoSelecionado.getNome());
        holder.tvPreco.setText(produtoSelecionado.getPreco());
    }

    @Override
    public int getItemCount() {
        return this.listaProdutos.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvId;
        public TextView tvNome;
        public  TextView tvPreco;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.tvId = itemView.findViewById(R.id.tvId);
            this.tvNome = itemView.findViewById(R.id.tvNome);
            this.tvPreco = itemView.findViewById(R.id.tvPreco);
        }
    }

}
