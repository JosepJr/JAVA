/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import command.ICommandManterOS;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;
import model.OrdemServico;
import stateincluir.IncluirOrdemServicoState;
import statevisualizar.VisualizarOrdemServicoState;
import test.DadosTeste;
import view.BuscarOrdemServicoView;

/**
 *
 * @author Josep
 */
public class BuscarOrdemServicoPresenter {

    private static BuscarOrdemServicoPresenter instance;
    private final BuscarOrdemServicoView view;
    private DefaultTableModel tablemodel;

    private BuscarOrdemServicoPresenter() throws Exception {
        this.view = new BuscarOrdemServicoView();
        this.configurarView();

    }

    public static BuscarOrdemServicoPresenter getInstance() throws Exception {
        if (instance == null) {
            instance = new BuscarOrdemServicoPresenter();
        }
        return instance;
    }

    private void configurarView() throws Exception {

        this.setPosicao();
        this.view.getjButtonExcluir().setVisible(true);
        this.preencherTabela();

        this.view.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.view.getjTextFieldBuscar().setEditable(false);
        this.view.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosing(InternalFrameEvent ife) {
                try {
                    BuscarOrdemServicoPresenter.getInstance().fecharView();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        this.view.setVisible(true);

        if (this.view.getjTableOrdemServico().getRowCount() == 0) {
            this.view.getjButtonVisualizar().setEnabled(false);
        } else {
            this.view.getjButtonVisualizar().setEnabled(true);
        }

        this.view.getjButtonFechar().addActionListener((e1) -> {
            this.fecharView();
        });

        this.view.getjComboBoxTipoBusca().addActionListener((e1) -> {
            if (this.view.getjComboBoxTipoBusca().getSelectedItem().equals("Data")) {
                this.view.getjTextFieldBuscar().setEditable(true);
            }
            if (this.view.getjComboBoxTipoBusca().getSelectedItem().equals("Nome do Fiscal")) {
                this.view.getjTextFieldBuscar().setEditable(true);
            }
            if (this.view.getjComboBoxTipoBusca().getSelectedItem().equals("Todos")) {
                this.view.getjTextFieldBuscar().setEditable(false);
            }
            if (this.view.getjComboBoxTipoBusca().getSelectedItem().equals("Número")) {
                this.view.getjTextFieldBuscar().setEditable(true);
            }
        });

        this.view.getjButtonVisualizar().addActionListener((e1) -> {
            if (this.view.getjTableOrdemServico().getSelectedColumn() == 0) {
                try {
                    for (OrdemServico ordens : DadosTeste.getInstance().getOrdensServico()) {
                        if (this.view.getjTableOrdemServico().getValueAt(this.view.getjTableOrdemServico().getSelectedRow(), 0).toString().equals(Integer.toString(ordens.getNumero()))) {

                            ManterOrdemServicoPresenter.getInstance().fecharView();
                            ManterOrdemServicoPresenter presenter = ManterOrdemServicoPresenter.getInstance();

                            TelaPrincipalPresenter.getInstance().getView().getjDesktopPanePrincipal().add(presenter.getView());

                            presenter.setState(new VisualizarOrdemServicoState(presenter));
                            presenter.visualizar(ordens, null, null);

                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Favor selecionar somente o Número da Ordem de Serviço!");
            }
        });

        this.view.getjButtonNovo().addActionListener((e1) -> {

            ManterOrdemServicoPresenter.getInstance().fecharView();
            ManterOrdemServicoPresenter presenter = ManterOrdemServicoPresenter.getInstance();

            TelaPrincipalPresenter.getInstance().getView().getjDesktopPanePrincipal().add(presenter.getView());

            presenter.setState(new IncluirOrdemServicoState(presenter));
            presenter.incluir(null, null);

        });

        this.view.getjButtonExcluir().addActionListener((e) -> {
            if (this.view.getjTableOrdemServico().getSelectedColumn() == 0) {
                if (ManterOrdemServicoPresenter.getInstance().setJanelaConfirmacao("Deseja mesmo excluir a Ordem de Servico selecionada?") == 0) {
                    try {
                        for (OrdemServico ordens : DadosTeste.getInstance().getOrdensServico()) {
                            if (this.view.getjTableOrdemServico().getValueAt(this.view.getjTableOrdemServico().getSelectedRow(), 0).toString().equals(Integer.toString(ordens.getNumero()))) {
                                DadosTeste.getInstance().getOrdensServico().remove(ordens);
                                JOptionPane.showMessageDialog(null, "Ordem Servico excluida com sucesso!");
                                BuscarOrdemServicoPresenter.getInstance().preencherTabela();
                            }
                        }
                    } catch (Exception ex) {
                        //JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Favor selecionar somente o Número da Ordem de Serviço!");
            }
        });

    }

    public BuscarOrdemServicoView getView() {
        return this.view;
    }

    public void fecharView() {
        BuscarOrdemServicoPresenter.instance = null;
        this.view.dispose();
    }

    private void setPosicao() {
        Dimension d = TelaPrincipalPresenter.getInstance().getView().getjDesktopPanePrincipal().getSize();
        this.view.setLocation((d.width - this.view.getSize().width) / 2, (d.height - this.view.getSize().height) / 2);
    }

    private DefaultTableModel montarTabela() {
        this.tablemodel = new DefaultTableModel(new Object[][]{}, new String[]{"Número Ordem Serviço", "Data", "Nome do Fiscal"}) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        return tablemodel;
    }

    public void preencherTabela() throws Exception {

        this.tablemodel = this.montarTabela();
        for (OrdemServico ordensServicos : DadosTeste.getInstance().getOrdensServico()) {
            try {
                this.tablemodel.addRow(new Object[]{
                    ordensServicos.getNumero(),
                    ordensServicos.getDataEmissao(),
                    ordensServicos.getNomeFiscalEmissor()
                });
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        this.view.getjTableOrdemServico().setModel(tablemodel);
        this.atualizarQTDRegistros();
    }

    private void atualizarQTDRegistros() {
        this.view.getjLabelObserverQTD().setText(Integer.toString(this.view.getjTableOrdemServico().getRowCount()));

    }
}
