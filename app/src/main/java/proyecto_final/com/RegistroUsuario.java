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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistroUsuario extends AppCompatActivity {

    //esta clase crea un registro en la base de datos de firebase y
    //también crea una autenticación el el firebase

    EditText nom, ape, corr, clave;
    Button reg, canc;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference Usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_usuario);

        //inicializamos el objeto del firebaseauth
        firebaseAuth = FirebaseAuth.getInstance();

        Usuario = FirebaseDatabase.getInstance().getReference("Usuario");

        nom=(EditText)findViewById(R.id.txtNombre);
        ape=(EditText)findViewById(R.id.txtApellido);
        corr=(EditText)findViewById(R.id.txtCorreo);
        clave=(EditText)findViewById(R.id.txtContraseña);
        reg=(Button)findViewById(R.id.btnRegistrar);
        canc=(Button)findViewById(R.id.btnCancelar);

        //botón registrar o enviar
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrarDatos();
            }
        });

        //botón cancelar
        canc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vm = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(vm);
            }
        });


    }

    private void RegistrarDatos() {

        String no=nom.getText().toString().trim();
        String ap=ape.getText().toString().trim();
        String co=corr.getText().toString().trim();
        String cl=clave.getText().toString().trim();

        //verificamos que los edittext no esten vacios
        if(TextUtils.isEmpty(no)){

            Toast.makeText(this,"Debe ingresar un nombre",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(ap)){

            Toast.makeText(this,"Debe ingresar un apellido",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(co)){

            Toast.makeText(this,"Debe ingresar un correo electrónico",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(cl)){

            Toast.makeText(this,"Debe ingresar una contraseña",Toast.LENGTH_SHORT).show();
            return;
        }

        if(!TextUtils.isEmpty(co)) {

            //registramos en la base de datos o creación de la bd de firebase
            String id = Usuario.push().getKey();
            Usuario usu = new Usuario(no, ap, co, cl);
            Usuario.child("Usuario").child(id).setValue(usu);

            //creamos al nuevo usuario o la autenticación en el firebase
            firebaseAuth.createUserWithEmailAndPassword(co,cl)
                    .addOnCompleteListener(RegistroUsuario.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(RegistroUsuario.this, "Usuario registrado correctamente ",
                                        Toast.LENGTH_LONG).show();
                            }else{
                                if (task.getException()instanceof FirebaseAuthUserCollisionException){
                                    Toast.makeText(RegistroUsuario.this,"Este usuario ya existe", Toast.LENGTH_LONG).show();
                                }else{
                                    Toast.makeText(RegistroUsuario.this, "No se pudo registrar el usuario",
                                            Toast.LENGTH_SHORT).show();
                                }

                            }
                        }
                    });
        }



    }
}