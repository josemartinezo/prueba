
import java.awt.event.MouseAdapter;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Ventana.java
 *
 * Created on 12/06/2014, 10:44:15 PM
 */
public class Ventana extends javax.swing.JFrame {

    /** Creates new form Ventana */
    IO io;
    JFileChooser j;

    public Ventana() {
        j=new JFileChooser();
        j.setDialogTitle("Abrir base de datos");
        j.setFileFilter(new FileNameExtensionFilter("Base de datos de contactos", "cdb"));
        j.showOpenDialog(jPanel1);
        ruta = j.getSelectedFile().getAbsolutePath().replace(j.getSelectedFile().getName(), "");
        initComponents();
        setLocationRelativeTo(null);
        actualizar();
        ls_datos.setSelectedIndex(0);
        img_foto.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                super.mouseClicked(e);
                j.setDialogTitle("Seleccionar foto para el contacto");
                j.setFileFilter(new FileNameExtensionFilter("Fotos de contactos", "jpg", "png", "gif"));
                j.showOpenDialog(jPanel1);
                File dest=new File(ruta+j.getSelectedFile().getName());
                j.getSelectedFile().renameTo(dest);
                img_foto.cargar(dest);
            }
        });
    }
    String ruta;
    String[] datos, nombres, dir, tel, fotos;

    private void actualizar() {
        String[] tmp;
        io = new IO(ruta + "contactos.cdb");
        datos = io.getTexto().split("%");
        nombres = new String[datos.length];
        dir = new String[datos.length];
        tel = new String[datos.length];
        fotos = new String[datos.length];
        for (int i = 0; i < datos.length; i++) {
            datos[i] = datos[i].replace("\n", "");
            tmp = datos[i].split("/");
            nombres[i] = tmp[0];
            dir[i] = tmp[1];
            tel[i] = tmp[2];
            fotos[i] = tmp[3];
        }
        ls_datos.setListData(nombres);
    }

    public String[] insertar(String[] array, String v) {
        String[] tmp = new String[array.length + 1];
        System.arraycopy(array, 0, tmp, 0, array.length);
        tmp[array.length] = v;
        return tmp;
    }

    public String[] eliminar(String[] array, int indice) {
        String[] tmp = new String[array.length - 1];
        System.arraycopy(array, 0, tmp, 0, indice);
        System.arraycopy(array, indice + 1, tmp, indice, tmp.length - indice);
        return tmp;
    }

    public String unir(String[] array, String regex) {
        String tmp = "";
        for (int i = 0; i < array.length; i++) {
            tmp += array[i] + regex;
        }
        return tmp.substring(0, tmp.length() - 1);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        img_foto = new Imagen();
        tf_nombre = new javax.swing.JTextField();
        tf_dir = new javax.swing.JTextField();
        tf_tel = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        btn_nuevo = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ls_datos = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(-16777216,true)));

        jLabel1.setText("NOMBRE:");

        jLabel2.setText("DIRECCION:");

        jLabel3.setText("TELEFONO:");

        img_foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/c1.png"))); // NOI18N
        img_foto.setProporcion(1);

        javax.swing.GroupLayout img_fotoLayout = new javax.swing.GroupLayout(img_foto);
        img_foto.setLayout(img_fotoLayout);
        img_fotoLayout.setHorizontalGroup(
            img_fotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
        );
        img_fotoLayout.setVerticalGroup(
            img_fotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 104, Short.MAX_VALUE)
        );

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SAVE.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/NEW.png"))); // NOI18N
        btn_nuevo.setText("Nuevo");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_nuevo);

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DELETE.png"))); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btn_eliminar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(img_foto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(8, 8, 8)
                                    .addComponent(tf_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tf_dir)
                                        .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(12, 12, 12))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(229, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(btn_guardar)
                            .addContainerGap()))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(img_foto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(tf_dir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(tf_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_guardar)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        ls_datos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ls_datos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        ls_datos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ls_datosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ls_datos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ls_datosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ls_datosValueChanged
        if (ls_datos.getSelectedIndex() >= 0) {
            tf_nombre.setText(nombres[ls_datos.getSelectedIndex()]);
            tf_dir.setText(dir[ls_datos.getSelectedIndex()]);
            tf_tel.setText(tel[ls_datos.getSelectedIndex()]);
            if (fotos[ls_datos.getSelectedIndex()].equals("c1.png")) {
                img_foto.setIcon(new ImageIcon(getClass().getResource(fotos[ls_datos.getSelectedIndex()])));
            } else {
                img_foto.cargar(new File(ruta + fotos[ls_datos.getSelectedIndex()]));
            }
        }
    }//GEN-LAST:event_ls_datosValueChanged

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        tf_nombre.setText("nuevo contacto");
        tf_dir.setText("");
        tf_tel.setText("");
        datos = insertar(datos, tf_nombre.getText() + "/" + tf_dir.getText() + "/" + tf_tel.getText() + "/c1.png");
        io.setTexto(unir(datos, "%"));
        io.guardar();
        actualizar();
        ls_datos.setSelectedIndex(datos.length - 1);
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        datos = eliminar(datos, ls_datos.getSelectedIndex());
        io.setTexto(unir(datos, "%"));
        io.guardar();
        actualizar();
        ls_datos.setSelectedIndex(datos.length - 1);
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        int i=ls_datos.getSelectedIndex();
        datos[ls_datos.getSelectedIndex()] = tf_nombre.getText() + "/" + tf_dir.getText() + "/" + tf_tel.getText() + "/" + img_foto.getFile().getName();
        io.setTexto(unir(datos, "%"));
        io.guardar();
        actualizar();
        ls_datos.setSelectedIndex(i);
    }//GEN-LAST:event_btn_guardarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_nuevo;
    private Imagen img_foto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JList ls_datos;
    private javax.swing.JTextField tf_dir;
    private javax.swing.JTextField tf_nombre;
    private javax.swing.JTextField tf_tel;
    // End of variables declaration//GEN-END:variables
}