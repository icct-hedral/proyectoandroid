package proyecto_final.com;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdaptadorProducto extends RecyclerView.Adapter<RecyclerAdaptadorProducto.ViewHolder>{

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView codigo, nombre, categoria;
        ImageView fotoproducto;

        public ViewHolder(View itemview){
            super(itemview);
            nombre=(TextView)itemview.findViewById(R.id.txtNombre);
            codigo=(TextView)itemview.findViewById(R.id.txtCodigo);
            categoria=(TextView)itemview.findViewById(R.id.txtCategoria);
            fotoproducto=(ImageView)itemview.findViewById(R.id.imgProducto);
        }
    }

    public List<Producto> listaProductos;

    public RecyclerAdaptadorProducto (List<Producto> listaProductos){
        this.listaProductos=listaProductos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_producto,parent,false);
        ViewHolder viewholder = new ViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombre.setText(listaProductos.get(position).getNombre());
        holder.codigo.setText(listaProductos.get(position).getCodigo());
        holder.categoria.setText(listaProductos.get(position).getCategoria());
        holder.fotoproducto.setImageResource(listaProductos.get(position).getFotoproducto());
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }
}
