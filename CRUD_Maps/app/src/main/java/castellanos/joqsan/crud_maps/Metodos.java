package castellanos.joqsan.crud_maps;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Metodos {

    public static class Registrar {

        public Registrar(Button btn_registar, Button btn_buscar, Button btn_actualizar, Button btn_eliminar, Context contexto, ArrayList<EditText> campos) {

            this.btn_registar = btn_registar;
            this.btn_buscar = btn_buscar;
            this.btn_actualizar = btn_actualizar;
            this.btn_eliminar = btn_eliminar;

            asigarEventos(contexto, campos);
        }

        private void asigarEventos(Context contexto, ArrayList<EditText> campos) {

            btn_registar.setOnClickListener(new Listener(1, contexto, campos));
            btn_buscar.setOnClickListener(new Listener(2, contexto, campos));
            btn_actualizar.setOnClickListener(new Listener(3, contexto, campos));
            btn_eliminar.setOnClickListener(new Listener(4, contexto, campos));
        }

        private Button btn_registar;
        private Button btn_buscar;
        private Button btn_actualizar;
        private Button btn_eliminar;

        private class Listener implements View.OnClickListener {

            public Listener(int opcion, Context contexto, ArrayList<EditText> campos) {

                this.opcion = opcion;
                this.contexto = contexto;
                this.campos = campos;
            }

            @Override
            public void onClick(View v) {

                switch (opcion) {

                    case 1:

                        if(campos.get(0).getText().toString().isEmpty()
                                || campos.get(1).getText().toString().isEmpty()
                                || campos.get(2).getText().toString().isEmpty()
                                || campos.get(3).getText().toString().isEmpty()
                                || campos.get(4).getText().toString().isEmpty()
                                || campos.get(5).getText().toString().isEmpty()
                                || campos.get(6).getText().toString().isEmpty()) {

                            Toast.makeText(contexto, "Campos vacíos", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        FirebaseApp.initializeApp(contexto);
                        DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

                        Map<String, Object> registro = new HashMap<>();
                        registro.put("nombre", campos.get(1).getText().toString());
                        registro.put("pais", campos.get(2).getText().toString());
                        registro.put("estado_region", campos.get(3).getText().toString());
                        registro.put("descripcion", campos.get(4).getText().toString());
                        registro.put("latitud", campos.get(5).getText().toString());
                        registro.put("longitud", campos.get(6).getText().toString());

                        referencia.child(campos.get(0).getText().toString()).setValue(registro)

                                .addOnSuccessListener(a -> {

                                    Toast.makeText(contexto, "Registro exitoso", Toast.LENGTH_SHORT).show();

                                }).addOnFailureListener(e -> {

                                    Toast.makeText(contexto, "Error de registro", Toast.LENGTH_SHORT).show();
                                });

                        break;

                    case 2:

                        contexto.startActivity(new Intent(contexto, BuscarActivity.class));
                        break;

                    case 3:

                        contexto.startActivity(new Intent(contexto, ActualizarActivity.class));
                        break;

                    default:

                        contexto.startActivity(new Intent(contexto, EliminarActivity.class));
                }
            }

            private int opcion;
            private Context contexto;
            private ArrayList<EditText> campos;
        }
    }

    public static class Buscar {

        public Buscar(Button btn_registar, Button btn_buscar, Button btn_actualizar, Button btn_eliminar, Context contexto, ArrayList<EditText> campos) {

            this.btn_registar = btn_registar;
            this.btn_buscar = btn_buscar;
            this.btn_actualizar = btn_actualizar;
            this.btn_eliminar = btn_eliminar;

            asigarEventos(contexto, campos);
        }

        private void asigarEventos(Context contexto, ArrayList<EditText> campos) {

            btn_registar.setOnClickListener(new Listener(1, contexto, campos));
            btn_buscar.setOnClickListener(new Listener(2, contexto, campos));
            btn_actualizar.setOnClickListener(new Listener(3, contexto, campos));
            btn_eliminar.setOnClickListener(new Listener(4, contexto, campos));
        }

        private Button btn_registar;
        private Button btn_buscar;
        private Button btn_actualizar;
        private Button btn_eliminar;

        private class Listener implements View.OnClickListener {

            public Listener(int opcion, Context contexto, ArrayList<EditText> campos) {

                this.opcion = opcion;
                this.contexto = contexto;
                this.campos = campos;
            }

            @Override
            public void onClick(View v) {

                switch (opcion) {

                    case 1:

                        contexto.startActivity(new Intent(contexto, MainActivity.class));
                        break;

                    case 2:

                        if(campos.get(0).getText().toString().isEmpty()) {

                            Toast.makeText(contexto, "ID vacío", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        FirebaseApp.initializeApp(contexto);
                        DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

                        referencia.child(campos.get(0).getText().toString()).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot data) {

                                HashMap<String, Object> registro = (HashMap<String, Object>) data.getValue();

                                campos.get(1).setText(registro.get("nombre").toString());
                                campos.get(2).setText(registro.get("pais").toString());
                                campos.get(3).setText(registro.get("estado_region").toString());
                                campos.get(4).setText(registro.get("descripcion").toString());
                                campos.get(5).setText(registro.get("latitud").toString());
                                campos.get(6).setText(registro.get("longitud").toString());

                                Toast.makeText(contexto, "Búsqueda exitosa", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                                Toast.makeText(contexto, "Error de búsqueda", Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;

                    case 3:

                        contexto.startActivity(new Intent(contexto, ActualizarActivity.class));
                        break;

                    default:

                        contexto.startActivity(new Intent(contexto, EliminarActivity.class));
                }
            }

            private int opcion;
            private Context contexto;
            private ArrayList<EditText> campos;
        }
    }

    public static class Actualizar {

        public Actualizar(Button btn_registar, Button btn_buscar, Button btn_actualizar, Button btn_eliminar, Context contexto, ArrayList<EditText> campos) {

            this.btn_registar = btn_registar;
            this.btn_buscar = btn_buscar;
            this.btn_actualizar = btn_actualizar;
            this.btn_eliminar = btn_eliminar;

            asigarEventos(contexto, campos);
        }

        private void asigarEventos(Context contexto, ArrayList<EditText> campos) {

            btn_registar.setOnClickListener(new Listener(1, contexto, campos));
            btn_buscar.setOnClickListener(new Listener(2, contexto, campos));
            btn_actualizar.setOnClickListener(new Listener(3, contexto, campos));
            btn_eliminar.setOnClickListener(new Listener(4, contexto, campos));
        }

        private Button btn_registar;
        private Button btn_buscar;
        private Button btn_actualizar;
        private Button btn_eliminar;

        private class Listener implements View.OnClickListener {

            public Listener(int opcion, Context contexto, ArrayList<EditText> campos) {

                this.opcion = opcion;
                this.contexto = contexto;
                this.campos = campos;
            }

            @Override
            public void onClick(View v) {

                switch (opcion) {

                    case 1:

                        contexto.startActivity(new Intent(contexto, MainActivity.class));
                        break;

                    case 2:

                        contexto.startActivity(new Intent(contexto, BuscarActivity.class));
                        break;

                    case 3:

                        if(campos.get(0).getText().toString().isEmpty()
                                || campos.get(1).getText().toString().isEmpty()
                                || campos.get(2).getText().toString().isEmpty()
                                || campos.get(3).getText().toString().isEmpty()
                                || campos.get(4).getText().toString().isEmpty()
                                || campos.get(5).getText().toString().isEmpty()
                                || campos.get(6).getText().toString().isEmpty()) {

                            Toast.makeText(contexto, "Campos vacíos", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        FirebaseApp.initializeApp(contexto);
                        DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

                        Map<String, Object> registro = new HashMap<>();
                        registro.put("nombre", campos.get(1).getText().toString());
                        registro.put("pais", campos.get(2).getText().toString());
                        registro.put("estado_region", campos.get(3).getText().toString());
                        registro.put("descripcion", campos.get(4).getText().toString());
                        registro.put("latitud", campos.get(5).getText().toString());
                        registro.put("longitud", campos.get(6).getText().toString());

                        referencia.child(campos.get(0).getText().toString()).setValue(registro)

                                .addOnSuccessListener(a -> {

                                    Toast.makeText(contexto, "Actualización exitosa", Toast.LENGTH_SHORT).show();

                                }).addOnFailureListener(e -> {

                                    Toast.makeText(contexto, "Error de actualización", Toast.LENGTH_SHORT).show();
                                });
                        break;

                    default:

                        contexto.startActivity(new Intent(contexto, EliminarActivity.class));
                }
            }

            private int opcion;
            private Context contexto;
            ArrayList<EditText> campos;
        }
    }

    public static class Eliminar {

        public Eliminar(Button btn_registar, Button btn_buscar, Button btn_actualizar, Button btn_eliminar, Context contexto, ArrayList<EditText> campos) {

            this.btn_registar = btn_registar;
            this.btn_buscar = btn_buscar;
            this.btn_actualizar = btn_actualizar;
            this.btn_eliminar = btn_eliminar;

            asigarEventos(contexto, campos);
        }

        private void asigarEventos(Context contexto, ArrayList<EditText> campos) {

            btn_registar.setOnClickListener(new Listener(1, contexto, campos));
            btn_buscar.setOnClickListener(new Listener(2, contexto, campos));
            btn_actualizar.setOnClickListener(new Listener(3, contexto, campos));
            btn_eliminar.setOnClickListener(new Listener(4, contexto, campos));
        }

        private Button btn_registar;
        private Button btn_buscar;
        private Button btn_actualizar;
        private Button btn_eliminar;

        private class Listener implements View.OnClickListener {

            public Listener(int opcion, Context contexto, ArrayList<EditText> campos) {

                this.opcion = opcion;
                this.contexto = contexto;
                this.campos = campos;
            }

            @Override
            public void onClick(View v) {

                switch(opcion) {

                    case 1:

                        contexto.startActivity(new Intent(contexto, MainActivity.class));
                        break;

                    case 2:

                        contexto.startActivity(new Intent(contexto, BuscarActivity.class));
                        break;

                    case 3:

                        contexto.startActivity(new Intent(contexto, ActualizarActivity.class));
                        break;

                    default:

                        if(campos.get(0).getText().toString().isEmpty()) {

                            Toast.makeText(contexto, "ID vacío", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        FirebaseApp.initializeApp(contexto);
                        DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

                        referencia.child(campos.get(0).getText().toString()).removeValue(new DatabaseReference.CompletionListener() {

                            @Override
                            public void onComplete(@NonNull DatabaseError e, @NonNull DatabaseReference r) {

                                if (e != null) {

                                    Toast.makeText(contexto, "Eliminación exitosa", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                }
            }

            private int opcion;
            private Context contexto;
            private ArrayList<EditText> campos;
        }
    }
}
