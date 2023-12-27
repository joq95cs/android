package com.gaytan.karla.app_vlsm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    EditText editText,editText2,editText3,editText4;
    TextView textView6,textView7,textView8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciar();
    }

    public void metodo1(View objView) {
        try {
            String ip = editText.getText().toString();
            StringTokenizer tokens = new StringTokenizer(ip, ".");
            int ips = tokens.countTokens();
            int[] datos = new int[ips];

            String mask = editText2.getText().toString();
            StringTokenizer tokens2 = new StringTokenizer(mask, ".");
            int maks = tokens2.countTokens();
            int[] datos2 = new int[maks];

            String a = "";
            int i = 0, j = 0;

            while (tokens.hasMoreTokens()) {
                while (tokens2.hasMoreTokens()) {
                    String IPS = tokens.nextToken();
                    datos[i] = Integer.valueOf(IPS);
                    String MASK = tokens2.nextToken();
                    datos2[i] = Integer.valueOf(MASK);
                    datos[i] = datos[i] & datos2[i];
                    a = a + String.valueOf(datos[i]);
                    System.out.println(String.valueOf(datos[i]));
                    j++;
                    i++;
                    a += ".";
                }
            }
            editText3.setText(a.substring(0, a.length() - 1));
        }catch(Exception exc){}
    }

    public void metodo2(View objView) {
        try {
            textView7.setText("RESULTADOS");
            textView8.setText("");
            textView6.setText("");
            String ip = editText3.getText().toString();
            StringTokenizer tokens = new StringTokenizer(ip, ".");
            int ips = tokens.countTokens();
            int[] datos = new int[ips];

            String host = editText4.getText().toString();
            StringTokenizer tokens2 = new StringTokenizer(host, "-");
            int hs = tokens2.countTokens();
            int[] datos2 = new int[hs];

            int[] arre1 = new int[ips];
            int[] arre2 = new int[hs];
            int j = 0, k = 0;


            while (tokens.hasMoreTokens()) {
                for (int i = 0; i < arre1.length; i++) {
                    String IPS = tokens.nextToken();
                    datos[j] = Integer.valueOf(IPS);
                    arre1[i] = datos[j];
                    j++;
                }
            }

            while (tokens2.hasMoreTokens()) {
                for (int i = 0; i < arre2.length; i++) {
                    String MSK = tokens2.nextToken();
                    datos2[k] = Integer.valueOf(MSK);
                    arre2[i] = datos2[k];
                    k++;
                }
            }
            int aux = 0;
            for (int i = 0; i < arre2.length; i++) {
                for (int x = i + 1; x < arre2.length; x++) {
                    if (arre2[x] > arre2[i]) {
                        aux = arre2[i];
                        arre2[i] = arre2[x];
                        arre2[x] = aux;
                    }
                }
            }
            /*for (int i = 0; i < arre2.length; i++)
            {
               System.out.println(arre2[i]+" ");
            }*/
            int rest = 0, d = 0, di = 0, ms = 0, kk = 0, a = 0, b = 0, ip4 = 0;
            for (int i = 0; i < arre2.length; i++) {
                if (i == 0) {
                    if (arre2[i] > 510 && arre2[i] <= 1022) {
                        ms = 22;
                        di = 1024;
                        kk = arre2[i];
                        arre2[i] = di + arre1[3];
                        if (arre1[3] == 0) {
                            d = (arre2[i] / 256) + arre1[2] - 1;
                            rest = 255;
                            ip4 = 0;
                        } else {
                            d = (arre2[i] / 256) + arre1[2];
                            rest = (arre2[i] % 256) - 1;
                            ip4 = rest + 1;
                        }
                    }
                    if (arre2[i] > 254 && arre2[i] <= 510) {
                        ms = 23;
                        di = 512;
                        kk = arre2[i];
                        arre2[i] = di + arre1[3];
                        if (arre1[3] == 0) {
                            d = (arre2[i] / 256) + arre1[2] - 1;
                            rest = 255;
                            ip4 = 0;
                        } else {
                            d = (arre2[i] / 256) + arre1[2];
                            rest = (arre2[i] % 256) - 1;
                            ip4 = rest + 1;
                        }
                    }
                    if (arre2[i] > 126 && arre2[i] <= 254) {
                        ms = 24;
                        di = 256;
                        kk = arre2[i];
                        arre2[i] = di + arre1[3];
                        if (arre2[i] == 256) {
                            d = arre1[2];
                            rest = arre2[i] - 1;
                            ip4 = 0;
                        }
                        if (arre2[i] > 256) {
                            d = (arre2[i] / 256) + arre1[2];
                            rest = (arre2[i] % 256) - 1;
                            ip4 = rest + 1;
                        }
                    }
                    if (arre2[i] > 62 && arre2[i] <= 126) {
                        ms = 25;
                        di = 128;
                        kk = arre2[i];
                        arre2[i] = di + arre1[3];
                        if (arre2[i] <= 256) {
                            d = arre1[2];
                            rest = arre2[i] - 1;
                            ip4 = rest + 1;
                        }
                        if (arre2[i] > 256) {
                            d = (arre2[i] / 256) + arre1[2];
                            rest = (arre2[i] % 256) - 1;
                            ip4 = rest + 1;
                        }
                    }
                    if (arre2[i] > 30 && arre2[i] <= 62) {
                        ms = 26;
                        di = 64;
                        kk = arre2[i];
                        arre2[i] = di + arre1[3];
                        if (arre2[i] <= 256) {
                            d = arre1[2];
                            rest = arre2[i] - 1;
                            ip4 = rest + 1;
                        }
                        if (arre2[i] > 256) {
                            d = (arre2[i] / 256) + arre1[2];
                            rest = (arre2[i] % 256) - 1;
                            ip4 = rest + 1;
                        }
                    }
                    if (arre2[i] > 14 && arre2[i] <= 30) {
                        ms = 27;
                        di = 32;
                        kk = arre2[i];
                        arre2[i] = di + arre1[3];
                        if (arre2[i] <= 256) {
                            d = arre1[2];
                            rest = arre2[i] - 1;
                            ip4 = rest + 1;
                        }
                        if (arre2[i] > 256) {
                            d = (arre2[i] / 256) + arre1[2];
                            rest = (arre2[i] % 256) - 1;
                            ip4 = rest + 1;
                        }
                    }
                    if (arre2[i] > 6 && arre2[i] <= 14) {
                        ms = 28;
                        di = 16;
                        kk = arre2[i];
                        arre2[i] = di + arre1[3];
                        if (arre2[i] <= 256) {
                            d = arre1[2];
                            rest = arre2[i] - 1;
                            ip4 = rest + 1;
                        }
                        if (arre2[i] > 256) {
                            d = (arre2[i] / 256) + arre1[2];
                            rest = (arre2[i] % 256) - 1;
                            ip4 = rest + 1;
                        }
                    }
                    if (arre2[i] > 3 && arre2[i] <= 6) {
                        ms = 29;
                        di = 8;
                        kk = arre2[i];
                        arre2[i] = di + arre1[3];
                        if (arre2[i] <= 256) {
                            d = arre1[2];
                            rest = arre2[i] - 1;
                            ip4 = rest + 1;
                        }
                        if (arre2[i] > 256) {
                            d = (arre2[i] / 256) + arre1[2];
                            rest = (arre2[i] % 256) - 1;
                            ip4 = rest + 1;
                        }
                    }
                    if (arre2[i] == 2 || arre2[i] == 1) {
                        ms = 30;
                        di = 4;
                        kk = arre2[i];
                        arre2[i] = di + arre1[3];
                        if (arre2[i] <= 256) {
                            d = arre1[2];
                            rest = arre2[i] - 1;
                            ip4 = rest + 1;
                        }
                        if (arre2[i] > 256) {
                            d = (arre2[i] / 256) + arre1[2];
                            rest = (arre2[i] % 256) - 1;
                            ip4 = rest + 1;
                        }
                    }
                    textView6.append("Red: " + String.valueOf(kk) + " | " + String.valueOf(di) + "\n");
                    textView6.append("Mask: " + String.valueOf(ms) + "\n");
                    textView6.append(String.valueOf(arre1[0]) + "." + String.valueOf(arre1[1]) + "." + String.valueOf(arre1[2]) + "." + String.valueOf(arre1[3]) + "\n");
                    textView6.append(String.valueOf(arre1[0]) + "." + String.valueOf(arre1[1]) + "." + String.valueOf(d) + "." + String.valueOf(rest) + "\n\n");

                }
                /////////////////////////////////////////////////////////////////////
                if (i > 0) {
                    if (arre2[i] > 510 && arre2[i] <= 1022) {
                        ms = 22;
                        di = 1024;
                        kk = arre2[i];
                        arre2[i] = di + ip4;
                        if (rest == 255) {
                            a = d + 1;
                            b = 0;
                            d = d + (arre2[i] / 256);
                            rest = 255;
                            ip4 = 0;
                        } else {
                            a = d;
                            b = rest + 1;
                            d = a + (arre2[i] / 256);
                            rest = (arre2[i] % 256) - 1;
                            ip4 = rest + 1;
                        }
                    }
                    if (arre2[i] > 254 && arre2[i] <= 510) {
                        ms = 23;
                        di = 512;
                        kk = arre2[i];
                        arre2[i] = di + ip4;
                        if (rest == 255) {
                            a = d + 1;
                            b = 0;
                            d = d + (arre2[i] / 256);
                            rest = 255;
                            ip4 = 0;
                        } else {
                            a = d;
                            b = rest + 1;
                            d = a + (arre2[i] / 256);
                            rest = (arre2[i] % 256) - 1;
                            ip4 = rest + 1;
                        }
                    }
                    if (arre2[i] > 126 && arre2[i] <= 254) {
                        ms = 24;
                        di = 256;
                        kk = arre2[i];
                        arre2[i] = di + ip4;
                        if (arre2[i] == 256) {
                            if (rest == 255) {
                                a = d + 1;
                                b = 0;
                                d = a;
                                rest = arre2[i] - 1;
                                ip4 = 0;
                            }
                        }
                        if (arre2[i] > 256) {
                            a = d;
                            b = rest + 1;
                            d = d + ((b + 256) / 256);
                            rest = ((b + 256) % 256) - 1;
                            ip4 = rest + 1;
                        }
                    }
                    if (arre2[i] > 62 && arre2[i] <= 126) {
                        ms = 25;
                        di = 128;
                        kk = arre2[i];
                        arre2[i] = di + ip4;
                        if (arre2[i] <= 256) {
                            if (rest == 255) {
                                a = d + 1;
                                b = 0;
                                d = a;
                                rest = arre2[i] - 1;
                                ip4 = rest + 1;
                            } else {
                                a = d;
                                b = rest + 1;
                                d = a;
                                rest = arre2[i] - 1;
                                ip4 = rest + 1;
                            }
                        }
                        if (arre2[i] > 256) {
                            a = d;
                            b = rest + 1;
                            d = a + (arre2[i] / 256);
                            rest = (arre2[i] % 256) - 1;
                            ip4 = rest + 1;
                        }
                    }
                    if (arre2[i] > 30 && arre2[i] <= 62) {
                        ms = 26;
                        di = 64;
                        kk = arre2[i];
                        arre2[i] = di + ip4;
                        if (arre2[i] <= 256) {
                            if (rest == 255) {
                                a = d + 1;
                                b = 0;
                                d = a;
                                rest = arre2[i] - 1;
                                ip4 = rest + 1;
                            } else {
                                a = d;
                                b = rest + 1;
                                d = a;
                                rest = arre2[i] - 1;
                                ip4 = rest + 1;
                            }
                        }
                        if (arre2[i] > 256) {
                            a = d;
                            b = rest + 1;
                            d = a + (arre2[i] / 256);
                            rest = (arre2[i] % 256) - 1;
                            ip4 = rest + 1;
                        }
                    }
                    if (arre2[i] > 14 && arre2[i] <= 30) {
                        ms = 27;
                        di = 32;
                        kk = arre2[i];
                        arre2[i] = di + ip4;
                        if (arre2[i] <= 256) {
                            if (rest == 255) {
                                a = d + 1;
                                b = 0;
                                d = a;
                                rest = arre2[i] - 1;
                                ip4 = rest + 1;
                            } else {
                                a = d;
                                b = rest + 1;
                                d = a;
                                rest = arre2[i] - 1;
                                ip4 = rest + 1;
                            }
                        }
                        if (arre2[i] > 256) {
                            a = d;
                            b = rest + 1;
                            d = a + (arre2[i] / 256);
                            rest = (arre2[i] % 256) - 1;
                            ip4 = rest + 1;
                        }
                    }
                    if (arre2[i] > 6 && arre2[i] <= 14) {
                        ms = 28;
                        di = 16;
                        kk = arre2[i];
                        arre2[i] = di + ip4;
                        if (arre2[i] <= 256) {
                            if (rest == 255) {
                                a = d + 1;
                                b = 0;
                                d = a;
                                rest = arre2[i] - 1;
                            } else {
                                a = d;
                                b = rest + 1;
                                d = a;
                                rest = arre2[i] - 1;
                                ip4 = rest + 1;
                            }
                        }
                        if (arre2[i] > 256) {
                            a = d;
                            b = rest + 1;
                            d = a + (arre2[i] / 256);
                            rest = (arre2[i] % 256) - 1;
                            ip4 = rest + 1;
                        }
                    }
                    if (arre2[i] > 3 && arre2[i] <= 6) {
                        ms = 29;
                        di = 8;
                        kk = arre2[i];
                        arre2[i] = di + ip4;
                        if (arre2[i] <= 256) {
                            if (rest == 255) {
                                a = d + 1;
                                b = 0;
                                d = a;
                                rest = arre2[i] - 1;
                                ip4 = rest + 1;
                            } else {
                                a = d;
                                b = rest + 1;
                                d = a;
                                rest = arre2[i] - 1;
                                ip4 = rest + 1;
                            }
                        }
                        if (arre2[i] > 256) {
                            a = d;
                            b = rest + 1;
                            d = a + (arre2[i] / 256);
                            rest = (arre2[i] % 256) - 1;
                            ip4 = rest + 1;
                        }
                    }
                    if (arre2[i] == 2 || arre2[i] == 1) {
                        ms = 30;
                        di = 4;
                        kk = arre2[i];
                        arre2[i] = di + ip4;
                        if (arre2[i] <= 256) {
                            if (rest == 255) {
                                a = d + 1;
                                b = 0;
                                d = a;
                                rest = arre2[i] - 1;
                                ip4 = rest + 1;
                            } else {
                                a = d;
                                b = rest + 1;
                                d = a;
                                rest = arre2[i] - 1;
                                ip4 = rest + 1;
                            }
                        }
                        if (arre2[i] > 256) {
                            a = d;
                            b = rest + 1;
                            d = a + (arre2[i] / 256);
                            rest = (arre2[i] % 256) - 1;
                            ip4 = rest + 1;
                        }
                    }
                    textView6.append("Red: " + String.valueOf(kk) + " | " + String.valueOf(di) + "\n");
                    textView6.append("Mask: " + String.valueOf(ms) + "\n");
                    textView6.append(String.valueOf(arre1[0]) + "." + String.valueOf(arre1[1]) + "." + String.valueOf(a) + "." + String.valueOf(b) + "\n");
                    textView6.append(String.valueOf(arre1[0]) + "." + String.valueOf(arre1[1]) + "." + String.valueOf(d) + "." + String.valueOf(rest) + "\n\n");
                }
            }
        }catch(Exception exc){}
    }

    void iniciar() {
        editText=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);
        editText3=(EditText)findViewById(R.id.editText3);
        editText4=(EditText)findViewById(R.id.editText4);
        textView6=(TextView)findViewById(R.id.textView6);
        textView6.setMovementMethod(new ScrollingMovementMethod());
        textView7=(TextView) findViewById(R.id.textView7);
        textView8=(TextView)findViewById(R.id.textView8);
    }

}