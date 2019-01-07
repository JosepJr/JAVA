/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandeditar;

import command.ICommandManterOS;
import javax.swing.JOptionPane;
import model.CriterioGeralNMS;
import model.OrdemServico;
import presenter.BuscarOrdemServicoPresenter;
import presenter.ManterOrdemServicoPresenter;
import presenter.TabelaManterOSPresenter;
import statevisualizar.VisualizarCriterioGeralNMSState;
import statevisualizar.VisualizarCriteriosGeraisNMSState;
import test.DadosTeste;

/**
 *
 * @author Josep
 */
public class EditarCriterioGeralNMSCommand implements ICommandManterOS {

    private static EditarCriterioGeralNMSCommand instance;

    private EditarCriterioGeralNMSCommand() {

    }

    public static EditarCriterioGeralNMSCommand getInstance() {
        if (instance == null) {
            instance = new EditarCriterioGeralNMSCommand();
        }
        return instance;
    }

    @Override
    public void executar(ManterOrdemServicoPresenter presenter, OrdemServico os, Object ob1, Object ob2) {

        presenter.getView().getjButtonCancelar().addActionListener((e) -> {
            if (presenter.setJanelaConfirmacao("Deseja mesmo cancelar a edição deste Critério Geral de NMS?") == 0) {
                presenter.setState(new VisualizarCriterioGeralNMSState(presenter));
                presenter.visualizar(os, ob1, ob2);
            }
        });

        presenter.getView().getjButtonAvancar().addActionListener((e) -> {
            this.atualizarInformacoesOS(presenter, os, ob1, ob2);

        });
    }

    @Override
    public void desfazer() {
    }

    private void atualizarInformacoesOS(ManterOrdemServicoPresenter presenter, OrdemServico os, Object ob1, Object ob2) {
        try {

            CriterioGeralNMS criterio = (CriterioGeralNMS) ob1;
            DadosTeste.getInstance().getOrdensServico().remove(os);
            os.getNivelMinimoServico().getCriteriosGerais().remove(criterio);

            criterio.setCriterio(presenter.getView().getJTextField1().getText());
            criterio.setRedutor(Double.parseDouble(presenter.getView().getJTextField2().getText()));
            criterio.setAplicacao(presenter.getView().getJTextField3().getText());
            criterio.setQuantidade(Integer.parseInt(presenter.getView().getJTextField4().getText()));
            criterio.setObservacao(presenter.getView().getJTextField5().getText());
            criterio.setValorReducao(Double.parseDouble(presenter.getView().getJTextField6().getText()));

            this.realizarUpdate(presenter, os, criterio);

        } catch (NumberFormatException ex1) {
            JOptionPane.showMessageDialog(null, "Favor informar Redutor, Quantidade (inteiro) e valor da redução válidos");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    private void realizarUpdate(ManterOrdemServicoPresenter presenter, OrdemServico os, CriterioGeralNMS criterio) {
        try {

            os.getNivelMinimoServico().addCriteriosGerais(criterio);
            DadosTeste.getInstance().addOrdemServico(os);
            BuscarOrdemServicoPresenter.getInstance().preencherTabela();

            TabelaManterOSPresenter presenter2 = TabelaManterOSPresenter.getInstance();

            presenter2.setState(new VisualizarCriteriosGeraisNMSState(presenter2));
            presenter2.visualizar(null, os);

            presenter.setState(new VisualizarCriterioGeralNMSState(presenter));
            presenter.visualizar(os, criterio, null);

            JOptionPane.showMessageDialog(null, "Critério geral atualizado com sucesso!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

}
