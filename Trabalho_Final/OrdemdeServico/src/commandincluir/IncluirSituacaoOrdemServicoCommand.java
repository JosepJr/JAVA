/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandincluir;

import command.ICommandManterOS;
import javax.swing.JOptionPane;
import model.OrdemServico;
import model.Situacao;
import presenter.ManterOrdemServicoPresenter;
import stateincluir.IncluirHistoriaUsuarioState;

/**
 *
 * @author Josep
 */
public class IncluirSituacaoOrdemServicoCommand implements ICommandManterOS {

    private static IncluirSituacaoOrdemServicoCommand instance;
    
    private IncluirSituacaoOrdemServicoCommand(){
    
    }

    public static IncluirSituacaoOrdemServicoCommand getInstance() {
        if (instance == null) {
            instance = new IncluirSituacaoOrdemServicoCommand();
        }
        return instance;
    }

    @Override
    public void executar(ManterOrdemServicoPresenter presenter, OrdemServico os, Object ob1, Object ob2) {

        presenter.getView().getjButtonCancelar().addActionListener((e1) -> {
            if (presenter.setJanelaConfirmacao("Deseja realmente cancelar a edição da Ordem de Serviço (OS)? \n A janela será fechada e o restante da edição não será realizada.") == 0) {
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
            Situacao situacao = new Situacao(presenter.getView().getJTextField1().getText(),
                    presenter.getView().getJTextField2().getText(),
                    presenter.getView().getJTextField3().getText());
            os.addSituacao(situacao);
            
            presenter.setState(new IncluirHistoriaUsuarioState(presenter));
            presenter.incluir(os, null);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
