package proyecto_final.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuPrincipal extends AppCompatActivity {

    //esta clase contiene el recyclerView de productos y
    //el collapsing de la información de empresa

    private Button producto, nosotros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);

        producto =(Button)findViewById(R.id.btnProductos);
        nosotros =(Button)findViewById(R.id.btnNosotros);


        //Botón para ver el listado de productos
        producto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vp = new Intent(getApplicationContext(), RecyclerProducto.class);
                startActivity(vp);
            }
        });

        //Botón para ver la información de la empresa
        nosotros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ve = new Intent(getApplicationContext(), CollapseEmpresa.class);
                startActivity(ve);
            }
        });
    }




}