/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statevisualizar;

import command.ICommandTabela;
import commandvisualizar.VisualizarNiveisServicosCommand;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.NivelServico;
import model.OrdemServico;
import presenter.TabelaManterOSPresenter;
import state.ManterOrdemServicoTabelaState;

/**
 *
 * @author Josep
 */
public class VisualizarNiveisServicosState extends ManterOrdemServicoTabelaState {

    private ICommandTabela command;

    public VisualizarNiveisServicosState(TabelaManterOSPresenter presenter) {
        super(presenter);
        this.presenter.resetarConfiguracoes();
        this.presenter.getView().setTitle("Registro de Níveis Mínimos de Serviço (Visualização / Edição)");
        this.presenter.getView().getjLabelTitulo().setText("      Niveis de Serviço");
        this.presenter.getView().getjLabelTitulo().setVisible(true);
        this.presenter.getView().getjButtonEditar().setText("Excluir");
        this.presenter.getView().setVisible(true);
        this.command = VisualizarNiveisServicosCommand.getInstance();

    }

    @Override
    public void visualizar(Object ob1, OrdemServico os) {

        try {
            this.preencherTabela(this.presenter, os.getNivelMinimoServico().getNiveisServicos());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        this.command.executar(this.presenter, ob1, os);

    }

    private DefaultTableModel montarTabela(TabelaManterOSPresenter presenter) {
        presenter.setTablemodel(new DefaultTableModel(new Object[][]{}, new String[]{"Indicador", "Resultado", "Redutor", "Valor da Redução (R$)"}) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        });
        return presenter.getTablemodel();
    }

    private void preencherTabela(TabelaManterOSPresenter presenter, ArrayList<NivelServico> nivelServicos) throws Exception {
        presenter.setTablemodel(this.montarTabela(presenter));
        for (NivelServico nivelservico : nivelServicos) {
            try {
                presenter.getTablemodel().addRow(new Object[]{
                    nivelservico.getIndicador(),
                    nivelservico.getResultado(),
                    nivelservico.getRedutor(),
                    nivelservico.getValorReducao()
                });
            } catch (Exception ex) {
                throw new Exception(ex.getMessage());
            }
        }
        presenter.getView().getjTable().setModel(presenter.getTablemodel());
    }
}
