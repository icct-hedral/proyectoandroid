package proyecto_final.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class MainActivity extends AppCompatActivity {
    //esta clase crea un enlace a la clase RegistroUsuario
    //esta clase contiene un método de inició de sesión


    private EditText Correo, Contraseña;
    private Button Registrase, Ingresar;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicializamos el objeto del firebaseauth
        firebaseAuth = FirebaseAuth.getInstance();

        Correo =(EditText)findViewById(R.id.etEmail);
        Contraseña =(EditText)findViewById(R.id.etContraseña);
        Ingresar =(Button)findViewById(R.id.btnIngresar);
        Registrase =(Button)findViewById(R.id.btnRegistrarse);

        Registrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vr = new Intent(getApplicationContext(), RegistroUsuario.class);
                startActivity(vr);
            }
        });

        Ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IniciarSesion();

            }
        });

    }


    private void IniciarSesion(){
        String email = Correo.getText().toString().trim();
        String password = Contraseña.getText().toString().trim();

        //verificamos que los edittext no esten vacios
        if(TextUtils.isEmpty(email)){

            Toast.makeText(this,"Debe ingresar un Correo",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){

            Toast.makeText(this,"Debe ingresar una contraseña",Toast.LENGTH_SHORT).show();
            return;
        }

        //Iniciar sesion para el usuario
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent vi = new Intent(getApplicationContext(), MenuPrincipal.class);
                            startActivity(vi);
                        }else{
                            Toast.makeText(MainActivity.this, "Correo o Contraseña inválida.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
}