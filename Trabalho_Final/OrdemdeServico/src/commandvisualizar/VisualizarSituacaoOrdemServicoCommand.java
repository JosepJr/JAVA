/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandvisualizar;

import command.ICommandManterOS;
import java.util.ArrayList;
import model.OrdemServico;
import model.Situacao;
import presenter.ManterOrdemServicoPresenter;
import presenter.TabelaManterOSPresenter;
import presenter.TelaPrincipalPresenter;
import stateeditar.EditarSituacaoOrdemServicoState;
import statevisualizar.VisualizarHistoriasUsuarioState;

/**
 *
 * @author Josep
 */
public class VisualizarSituacaoOrdemServicoCommand implements ICommandManterOS {

    private static VisualizarSituacaoOrdemServicoCommand instance;

    public static VisualizarSituacaoOrdemServicoCommand getInstance() {
        if (instance == null) {
            instance = new VisualizarSituacaoOrdemServicoCommand();
        }
        return instance;
    }

    @Override
    public void executar(ManterOrdemServicoPresenter presenter, OrdemServico os, Object ob1, Object ob2) {

        ArrayList<Situacao> situacoes = os.getSituacoes();
        Situacao situacao = situacoes.get(situacoes.size() - 1);

        presenter.preencherTextField(situacao.getData(), situacao.getNomeResponsavel(), situacao.getFuncaoEquipe(), "", "", "", "", "");
        if (situacao.getNumeroRevisao() == 0) {
            presenter.configurarVisibleSituacao(true, true, false);
            presenter.getView().getjComboBoxSituacao().setSelectedItem(situacao.getDescricao());
        } else {
            presenter.configurarVisibleSituacao(true, true, true);
            presenter.getView().getjLabelNumeroRevisao().setText(Integer.toString(situacao.getNumeroRevisao()));
        }

        presenter.getView().getjButtonCancelar().addActionListener((e1) -> {
            if (presenter.setJanelaConfirmacao("Deseja realmente sair? \n A janela será fechada e o restante da edição da Ordem de Serviço(OS) não será realizada.\n Atualizações já feitas serão mantidas.") == 0) {
                presenter.fecharView();
            }
        });

        presenter.getView().getjButtonAvancar().addActionListener((e1) -> {
            presenter.fecharView();
            
            TabelaManterOSPresenter presenter1 = TabelaManterOSPresenter.getInstance();

            TelaPrincipalPresenter.getInstance().getView().getjDesktopPanePrincipal().add(presenter1.getView());

            presenter1.setState(new VisualizarHistoriasUsuarioState(presenter1));
            presenter1.visualizar(null, os);

        });

        presenter.getView().getjButtonEditar().addActionListener((e) -> {
            presenter.setState(new EditarSituacaoOrdemServicoState(presenter));
            presenter.editar(os, situacao, null);
        });
    }

    @Override
    public void desfazer() {
    }

}
