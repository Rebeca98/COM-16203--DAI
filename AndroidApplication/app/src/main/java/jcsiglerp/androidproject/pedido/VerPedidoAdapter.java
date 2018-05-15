package jcsiglerp.androidproject.pedido;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import jcsiglerp.androidproject.Model.Prenda;
import jcsiglerp.androidproject.R;
import jcsiglerp.androidproject.comprar.ComprarAdapter;

public class VerPedidoAdapter extends RecyclerView.Adapter<VerPedidoAdapter.VerPedidoViewHolder> {

    public List<Prenda > data = new ArrayList<>();

    @Override
    public VerPedidoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_pedido, parent, false);
        return new VerPedidoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(VerPedidoViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List < Prenda > data) {
        this.data = data;
        notifyDataSetChanged();
    }

    class VerPedidoViewHolder extends RecyclerView.ViewHolder {

        Prenda prenda;
        TextView tvNombre, tvPrecio;
        ImageView image;

        public VerPedidoViewHolder(View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
            image = itemView.findViewById(R.id.ivPrenda);
        }

        public void bind(Prenda prenda) {
            this.prenda = prenda;
            tvNombre.setText(prenda.nombre);
            tvPrecio.setText("$" + prenda.precio.toString());
            Picasso.get().load(prenda.urlImg).placeholder(R.mipmap.ic_launcher).error(android.R.drawable.stat_notify_error).into(image);
        }
    }

}
