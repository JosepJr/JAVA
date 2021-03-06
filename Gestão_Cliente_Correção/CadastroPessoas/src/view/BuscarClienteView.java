/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import java.awt.event.WindowAdapter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Josep
 */
public class BuscarClienteView extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaBuscarClienteMDI
     */
    public BuscarClienteView() {
        initComponents();
    }

    public JButton getjButtonBuscar() {
        return jButtonBuscar;
    }

    public JButton getjButtonFechar() {
        return jButtonFechar;
    }

    public JButton getjButtonNovo() {
        return jButtonNovo;
    }

    public JButton getjButtonVisualizar() {
        return jButtonVisualizar;
    }

    public JTextField getjTextFieldBuscar() {
        return jTextFieldBuscar;
    }

    public JComboBox<String> getjComboBoxTipoBusca() {
        return jComboBoxTipoBusca;
    }

    public JLabel getjLabelObserverQTD() {
        return jLabelObserverQTD;
    }

    public JLabel getjLabelQtdRegistros() {
        return jLabelQtdRegistros;
    }

    public JTable getjTableClientes() {
        return jTableClientes;
    }

    public void setjTableClientes(JTable jTableClientes) {
        this.jTableClientes = jTableClientes;
    }

    public JButton getjButtonDesfazer() {
        return jButtonDesfazer;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonBuscar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonVisualizar = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jLabelObserverQTD = new javax.swing.JLabel();
        jLabelQtdRegistros = new javax.swing.JLabel();
        jButtonDesfazer = new javax.swing.JButton();
        jTextFieldBuscar = new javax.swing.JTextField();
        jComboBoxTipoBusca = new javax.swing.JComboBox<>();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Buscar");
        setPreferredSize(new java.awt.Dimension(660, 350));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Busca por");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 23, 61, -1));

        jButtonBuscar.setText("Buscar");
        getContentPane().add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(569, 19, -1, -1));

        jButtonNovo.setText("Novo");
        getContentPane().add(jButtonNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 100, -1));

        jButtonVisualizar.setText("Visualizar");
        getContentPane().add(jButtonVisualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 100, -1));

        jButtonFechar.setText("Fechar");
        getContentPane().add(jButtonFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 100, -1));

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableClientes.setColumnSelectionAllowed(true);
        jTableClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableClientes);
        jTableClientes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 624, 150));

        jLabelObserverQTD.setText("0");
        getContentPane().add(jLabelObserverQTD, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 220, -1, -1));

        jLabelQtdRegistros.setText("Quantidade de Clientes Cadastrados:");
        getContentPane().add(jLabelQtdRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, -1, -1));

        jButtonDesfazer.setText("Desfazer");
        getContentPane().add(jButtonDesfazer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 100, -1));
        getContentPane().add(jTextFieldBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 20, 369, -1));

        jComboBoxTipoBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nome", "Documento" }));
        getContentPane().add(jComboBoxTipoBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 20, 113, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonDesfazer;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonVisualizar;
    private javax.swing.JComboBox<String> jComboBoxTipoBusca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelObserverQTD;
    private javax.swing.JLabel jLabelQtdRegistros;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTextField jTextFieldBuscar;
    // End of variables declaration//GEN-END:variables

    public void addWindowListener(WindowAdapter windowAdapter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
