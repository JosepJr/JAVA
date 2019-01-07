/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandincluir;

import command.ICommandManterOS;
import javax.swing.JOptionPane;
import model.CriterioGeralNMS;
import model.NivelMinimoServico;
import model.OrdemServico;
import presenter.ManterOrdemServicoPresenter;
import stateincluir.IncluirRegistroNMSCriteriosGeraisState;
import stateincluir.IncluirRegistroNMSNiveisServicoState;

/**
 *
 * @author Josep
 */
public class IncluirRegistroNMSCriteriosGeraisCommand implements ICommandManterOS {

    private static IncluirRegistroNMSCriteriosGeraisCommand instance;

    public static IncluirRegistroNMSCriteriosGeraisCommand getInstance() {
        if (instance == null) {
            instance = new IncluirRegistroNMSCriteriosGeraisCommand();
        }
        return instance;
    }

    @Override
    public void executar(ManterOrdemServicoPresenter presenter, OrdemServico os, Object ob1, Object ob2) {

        presenter.getView().getjButtonCancelar().addActionListener((e1) -> {
            if (presenter.setJanelaConfirmacao("Deseja realmente cancelar o processo? \n A janela será fechada e a inclusão da ordem de serviço cancelada.") == 0) {
                presenter.fecharView();
            }
        });

        presenter.getView().getjButtonAvancar().addActionListener((e1) -> {
            this.salvarInformacoesOS(presenter, os, ob1);
        });

    }

    @Override
    public void desfazer() {
    }

    private void salvarInformacoesOS(ManterOrdemServicoPresenter presenter, OrdemServico os, Object ob1) {
        try {
            if (ob1 == null) {

                CriterioGeralNMS criterioGeralNMS = new CriterioGeralNMS(
                        presenter.getView().getJTextField1().getText(),
                        Double.parseDouble(presenter.getView().getJTextField2().getText()),
                        presenter.getView().getJTextField3().getText(),
                        Integer.parseInt(presenter.getView().getJTextField4().getText()),
                        presenter.getView().getJTextField5().getText(),
                        Double.parseDouble(presenter.getView().getJTextField6().getText()));

                NivelMinimoServico nivelMinimoServico = new NivelMinimoServico(criterioGeralNMS);

                this.proximoState(presenter, os, nivelMinimoServico);
            } else {

                NivelMinimoServico nivelMinimoServico = (NivelMinimoServico) ob1;

                nivelMinimoServico.addCriteriosGerais(new CriterioGeralNMS(
                        presenter.getView().getJTextField1().getText(),
                        Double.parseDouble(presenter.getView().getJTextField2().getText()),
                        presenter.getView().getJTextField3().getText(),
                        Integer.parseInt(presenter.getView().getJTextField4().getText()),
                        presenter.getView().getJTextField5().getText(),
                        Double.parseDouble(presenter.getView().getJTextField6().getText())));

                this.proximoState(presenter, os, nivelMinimoServico);
            }
        } catch (NumberFormatException ex1) {
            JOptionPane.showMessageDialog(null, "Favor informar um valor válido para Redutor, Quantidade (inteiro), Valor da Redução!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    private void proximoState(ManterOrdemServicoPresenter presenter, OrdemServico os, NivelMinimoServico nivelMinimoServico) {
        if (presenter.setJanelaConfirmacao("Deseja inserir mais critérios gerais de NMS nesse mesmo registro minimo de serviço?") == 0) {
            presenter.setState(new IncluirRegistroNMSCriteriosGeraisState(presenter));
            presenter.incluir(os, nivelMinimoServico);
        } else {
            presenter.setState(new IncluirRegistroNMSNiveisServicoState(presenter));
            presenter.incluir(os, nivelMinimoServico);
        }

    }

}
