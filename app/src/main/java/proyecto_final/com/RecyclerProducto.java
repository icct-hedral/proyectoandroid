package proyecto_final.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RecyclerProducto extends AppCompatActivity {

    private RecyclerView recyclerpaisaje;
    private List<Producto> items = new ArrayList<>();
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager Lmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_producto);

        listaproductos();
        recyclerpaisaje=(RecyclerView)findViewById(R.id.RecyclerProductos);
        recyclerpaisaje.setHasFixedSize(true);

        Lmanager = new LinearLayoutManager(this);
        recyclerpaisaje.setLayoutManager(Lmanager);

        adapter= new RecyclerAdaptadorProducto(items);
        recyclerpaisaje.setAdapter(adapter);
    }

    public void listaproductos(){

        items.add(new Producto("ACP12043","ACEITE PRIMOR", "Aceites", R.drawable.aceite_primor));
        items.add(new Producto("LAG64421","LECHE GLORIA", "Lácteos", R.drawable.leche_gloria));
        items.add(new Producto("LAL63239","YOGURT LAIVE", "Lácteos", R.drawable.yogurt_laive));
        items.add(new Producto("LIE34543","SERVILLETA ELITE", "Limpieza", R.drawable.servilleta_elite));
        items.add(new Producto("ABC34822","ARROZ COSTEÑO", "Abarrotes", R.drawable.arroz_costenio));
        items.add(new Producto("LAE39543","QUESO EDAM", "Lácteos", R.drawable.queso_edam));
        items.add(new Producto("GAR98645","GALLETA RITZ", "Galletas", R.drawable.galleta_ritz));
        items.add(new Producto("BEI49584","GASEOSA INCA KOLA", "Bebidas", R.drawable.gaseosa_inca));
        items.add(new Producto("LAY68573","YOGURT YOPIMIX", "Lácteos", R.drawable.laive_yopimix));
        items.add(new Producto("ABF48573","MERMELADA FANNY", "Abarrotes", R.drawable.mermelada_fanny));
        items.add(new Producto("FRP86726","PIÑA GOLDEN", "Frutas", R.drawable.pinia_golden));
        items.add(new Producto("BES87774","AGUA SAN MATEO", "Bebidas", R.drawable.agua_sanmateo));
    }
}