
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LuisFernando
 */
public class IO {

    private String texto, ruta;

    public IO() {
        ruta = "";
        texto = "";
    }

    public IO(String recurso, boolean guardarRuta) {
        BufferedReader r = null;
        try {
            if (guardarRuta) {
                ruta=recurso;
            }
            texto = "";
            r = new BufferedReader(new FileReader(getClass().getResource(recurso).getFile()));
            String linea = r.readLine();
            while (linea != null) {
                texto += linea + "\n";
                linea = r.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                r.close();
            } catch (IOException ex) {
                Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public IO(String ruta) {
        BufferedReader r = null;
        try {
            this.ruta = ruta;
            texto = "";
            r = new BufferedReader(new FileReader(ruta));
            String linea = r.readLine();
            while (linea != null) {
                texto += linea + "\n";
                linea = r.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                r.close();
            } catch (IOException ex) {
                Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void guardar() {
        BufferedWriter w = null;
        try {
            w = new BufferedWriter(new FileWriter(ruta));
            w.write(texto);
            w.flush();
            w.close();
        } catch (IOException ex) {
            Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                w.close();
            } catch (IOException ex) {
                Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
