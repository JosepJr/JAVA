/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandincluir;

import command.ICommandManterOS;
import javax.swing.JOptionPane;
import model.OrdemServico;
import presenter.ManterOrdemServicoPresenter;
import stateincluir.IncluirSituacaoOrdemServicoState;

/**
 *
 * @author Josep
 */
public class IncluirOrdemServicoCommand implements ICommandManterOS {

    private static IncluirOrdemServicoCommand instance;

    private IncluirOrdemServicoCommand() {

    }

    public static IncluirOrdemServicoCommand getInstance() {
        if (instance == null) {
            instance = new IncluirOrdemServicoCommand();
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
            this.salvarInformacoesOS(presenter, os, null);
        });

    }

    @Override
    public void desfazer() {
    }

    private void salvarInformacoesOS(ManterOrdemServicoPresenter presenter, OrdemServico os, Object ob1) {
        try {
            OrdemServico ordemServico = new OrdemServico();
            int aux = Integer.parseInt(presenter.getView().getJTextField1().getText());
            ordemServico.setNumero(aux);
            ordemServico.setDataEmissao(presenter.getView().getJTextField2().getText());
            ordemServico.setNomeFiscalEmissor(presenter.getView().getJTextField3().getText());
            
            presenter.setState(new IncluirSituacaoOrdemServicoState(presenter));
            presenter.incluir(ordemServico, null);
            
        } catch (NumberFormatException ex1) {
            JOptionPane.showMessageDialog(null, "Favor informar um número inteiro para Ordem Serviço!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

}
