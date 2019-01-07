/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandincluir;

import command.ICommandManterOS;
import javax.swing.JOptionPane;
import model.NivelMinimoServico;
import model.NivelServico;
import model.OrdemServico;
import presenter.BuscarOrdemServicoPresenter;
import presenter.ManterOrdemServicoPresenter;
import stateincluir.IncluirRegistroNMSNiveisServicoState;
import test.DadosTeste;

/**
 *
 * @author Josep
 */
public class IncluirRegistroNMSNiveisServicoCommand implements ICommandManterOS {

    private static IncluirRegistroNMSNiveisServicoCommand instance;

    public static IncluirRegistroNMSNiveisServicoCommand getInstance() {
        if (instance == null) {
            instance = new IncluirRegistroNMSNiveisServicoCommand();
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
            NivelMinimoServico nivelMinimoServico = (NivelMinimoServico) ob1;

            NivelServico nivelServico = new NivelServico(
                    presenter.getView().getJTextField1().getText(),
                    Integer.parseInt(presenter.getView().getJTextField2().getText()),
                    Double.parseDouble(presenter.getView().getJTextField3().getText()),
                    Double.parseDouble(presenter.getView().getJTextField4().getText()));

            nivelMinimoServico.addNiveisServicos(nivelServico);
            os.setNivelMinimoServico(nivelMinimoServico);

            if (presenter.setJanelaConfirmacao("Deseja inserir mais Niveis de Serviço nesse mesmo Registro Minimo de Serviço?") == 0) {
                presenter.setState(new IncluirRegistroNMSNiveisServicoState(presenter));
                presenter.incluir(os, nivelMinimoServico);
            } else {
                JOptionPane.showMessageDialog(null, "Ordem de Serviço Criada com Sucesso!");
                presenter.fecharView();
                DadosTeste.getInstance().addOrdemServico(os);
                BuscarOrdemServicoPresenter.getInstance().preencherTabela();
            }

        } catch (NumberFormatException ex1) {
            JOptionPane.showMessageDialog(null, "Favor informar um valor válido para Resultado (inteiro), Redutor, Valor da Redução!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
