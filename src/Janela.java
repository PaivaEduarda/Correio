import bd.core.MeuResultSet;
import bd.daos.Deputados;
import bd.daos.Estados;
import bd.dbos.Deputado;
import bd.dbos.Estado;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Janela extends JFrame {
    private JTabbedPane tab = new JTabbedPane();

    private JPanel ler                = new JPanel();
    private JPanel criar              = new JPanel();
    private JPanel atualizar          = new JPanel();
    private JPanel deletar            = new JPanel();

    private JLabel lblEstado          = new JLabel("Estado");
    private JLabel lblUF              = new JLabel("UF");
    private JLabel lblCapital         = new JLabel("Capital");

    private JLabel lblNumDeputado     = new JLabel("Núm. Deputado");
    private JLabel lblDeputado        = new JLabel("Deputado");
    private JLabel lblPartido         = new JLabel("Partido");

    private JTextField txtEstado      = new JTextField();
    private JTextField txtUF          = new JTextField();
    private JTextField txtCapital     = new JTextField();

    private JTextField txtNumDeputado = new JTextField();
    private JTextField txtDeputado    = new JTextField();
    private JTextField txtPartido     = new JTextField();

    //Atualizar
    JComboBox boxEstadosAtualizar         = new JComboBox();
    JComboBox boxDeputadosAtualizar       = new JComboBox();

    private JButton btnAdicionar          = new JButton("Adicionar");
    private JButton btnAtualizarEst       = new JButton("Atualizar");
    private JButton btnAtualizarDep       = new JButton("Atualizar");

    private JComboBox boxEstados          = new JComboBox();
    private JComboBox boxDeputados        = new JComboBox();
    private JComboBox boxEstadosDeletar   = new JComboBox();
    private JComboBox boxDeputadosDeletar = new JComboBox();

    private JLabel lblNumDep              = new JLabel("Núm. Deputado: ");
    private JLabel lblNomeDep             = new JLabel("Nome Deputado: ");
    private JLabel lblPartidoDep          = new JLabel("Partido: ");
    private JLabel boxlblPartidoDep       = new JLabel("Partido: ");
    private JLabel lblUFDep               = new JLabel("UF: ");
    private JLabel lblNumDepDel           = new JLabel("Núm. Deputado: ");
    private JLabel lblNomeDepDel          = new JLabel("Nome Deputado: ");
    private JLabel lblPartidoDepDel       = new JLabel("Partido: ");
    private JLabel lblUFDepDel            = new JLabel("UF: ");

    JLabel lblUFAtualizarEst           = new JLabel("UF:");
    JLabel lblUFAtualizarDep           = new JLabel("UF:");
    JLabel lblDeputadoAtualizar        = new JLabel("Deputado:");
    JLabel lblEstadoAtualizar          = new JLabel("Estado:");
    JLabel lblCapitalAtualizar         = new JLabel("Capital:");
    JLabel lblNumDeputadoAtualizar     = new JLabel("Número:");
    JLabel lblPartidoAtualizar         = new JLabel("Partido:");
    
    JTextField txtUFAtualizarDep       = new JTextField();
    JTextField txtDeputadoAtualizar    = new JTextField();
    JTextField txtEstadoAtualizar      = new JTextField();
    JTextField txtCapitalAtualizar     = new JTextField();
    JTextField txtNumDeputadoAtualizar = new JTextField();
    JTextField txtPartidoAtualizar     = new JTextField();
    JButton btnDeletar                 = new JButton("Deletar");
   
    private ArrayList<Estado> estados;
    private ArrayList<Deputado> deputados;

    private void selecionarEstado(String estado)
    {
        String st = estado;

        Estado estadoSelecionado = null;

        for (var est : estados)
        {
            if (est.getNome() == st) 
            {
                estadoSelecionado = est;
                break;
            }
        }

        boxDeputados.removeAllItems();

        for (var deputado : deputados)
        {
            if (deputado.getUF().equals(estadoSelecionado.getUf()))
            {
                boxDeputados.addItem(deputado.getNome());
            }
        }
    }
    private void selecionarEstadoDel(String estado)
    {
        String st = estado;

        Estado estadoSelecionado = null;

        for (var est : estados) 
        {
            if (est.getNome() == st) 
            {
                estadoSelecionado = est;
                break;
            }
        }
        boxDeputadosDeletar.removeAllItems();
        for (var deputado : deputados) {
            if (deputado.getUF().equals(estadoSelecionado.getUf()))
            {
                boxDeputadosDeletar.addItem(deputado.getNome());
            }
        }
    }
    private void atualizarTudo()
    {
        boxEstados.removeAllItems();
        boxEstadosDeletar.removeAllItems();
        boxEstadosAtualizar.removeAllItems();
        for (var estado : estados) {
            boxEstados.addItem(estado.getNome());
            boxEstadosDeletar.addItem(estado.getNome());
            boxEstadosAtualizar.addItem(estado.getNome());

        }
        boxDeputadosAtualizar.removeAllItems();
        boxDeputadosDeletar.removeAllItems();
        for (var dep : deputados) {
            boxDeputadosAtualizar.addItem(dep.getNome());
            boxDeputadosDeletar.addItem(dep.getNome());

        }
    }
    public Janela()
    {
        super("Deputados e estados");
        super.setSize(800, 600);
        super.setVisible(true);
        super.add(tab);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        estados = new ArrayList<>();
        deputados = new ArrayList<>();
        try
        {
            MeuResultSet resDep = Deputados.getDeputado();
            while (resDep.next())
            {
                var dep =  new Deputado(resDep.getInt("NUMERO"),
                        resDep.getString("NOME"),
                        resDep.getString("PARTIDO"),
                        resDep.getString("UF"));
                deputados.add(dep);
            }
            MeuResultSet resEst = Estados.getEstado();
            while (resEst.next())
            {
                var est = new Estado(resEst.getString("UF"),
                        resEst.getString("NOME"),
                        resEst.getString("CAPITAL"));
                estados.add(est);
            }
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }


        tab.add("Ler", ler);
        tab.add("Adicionar", criar);
        tab.add("Deletar", deletar);
        tab.add("Atualizar", atualizar);

        Dimension size = tab.getSize();

        // region Parte de leitura
        ler.setLayout(null);
        boxEstados.setBounds(0, 0, 200, 30);
        for (var estado : estados) {
            boxEstados.addItem(estado.getNome());
        }
        ler.add(boxEstados);

        boxDeputados.setBounds(0, 40, 200, 30);
        ler.add(boxDeputados);

        lblNumDep.setBounds(0, 80, 200, 30);
        lblNomeDep.setBounds(0, 110, 200, 30);
        lblPartidoDep.setBounds(0, 140, 200, 30);
        lblUFDep.setBounds(0, 170, 200, 30);
        ler.add(lblNumDep);
        ler.add(lblNomeDep);
        ler.add(lblPartidoDep);
        ler.add(lblUFDep);

        boxEstados.addActionListener(e -> {
            try {
                selecionarEstado(boxEstados.getSelectedItem().toString());
            }
            catch (Exception erro)
            {

            }
        });
        boxEstados.setSelectedIndex(0);
        boxDeputados.addActionListener(e -> {
            String st;
            try
            {
                st = boxDeputados.getSelectedItem().toString();
            }
            catch (Exception ex)
            {
                return;
            }
            Deputado deputadoSelecionado = null;
            for (var deputado : deputados) {
                if (deputado.getNome() == st) {
                    deputadoSelecionado = deputado;
                    break;
                }
            }
            lblNumDep.setText("Núm. Deputado: " + deputadoSelecionado.getNumDeputado());
            lblNomeDep.setText("Nome Deputado: " + deputadoSelecionado.getNome());
            lblPartidoDep.setText("Partido: " + deputadoSelecionado.getPartido());
            lblUFDep.setText("UF: " + deputadoSelecionado.getUF());
        });
        boxDeputados.setSelectedIndex(0);
        //endregion
        //region Parte de adicionar
        criar.setLayout(new GridLayout(13,1));
        criar.add(lblUF);
        criar.add(txtUF);

        criar.add(lblDeputado);
        criar.add(txtDeputado);

        criar.add(lblEstado);
        criar.add(txtEstado);

        criar.add(lblCapital);
        criar.add(txtCapital);

        criar.add(lblNumDeputado);
        criar.add(txtNumDeputado);

        criar.add(lblPartido);
        criar.add(txtPartido);
        criar.add(btnAdicionar);
        btnAdicionar.addActionListener(e -> {
            try
            {
                boolean jaExiste = false;
                Estado st = null;
                for (var estado : estados) {
                    if (estado.getUf().equals(txtUF.getText()))
                    {
                        JOptionPane.showMessageDialog(null, "Estado já existe");
                        jaExiste = true;
                        st = estado;
                    }
                }
                if (!jaExiste) {
                    st = new Estado(txtUF.getText(), txtEstado.getText(), txtCapital.getText());
                    estados.add(st);
                    Estados.incluir(st);
                }
                Deputado dep = new Deputado(Integer.parseInt(txtNumDeputado.getText()),
                        txtDeputado.getText(),
                        txtPartido.getText(),
                        txtUF.getText());
                deputados.add(dep);
                Deputados.incluir(dep);
                atualizarTudo();
                JOptionPane.showMessageDialog(null, "Deputado adicionado com sucesso!");
            }
            catch (Exception erro)
            {
                JOptionPane.showMessageDialog(null, erro.getMessage());
            }
        });
        //endregion
        //region Parte de atualizar
        atualizar.setLayout(null);
        lblUFAtualizarEst.setFont(new Font(null, Font.PLAIN, 20));
        lblUFAtualizarEst.setBounds(size.width / 4 - 130, 60, 200, 30);
        atualizar.add(lblUFAtualizarEst);

        lblUFAtualizarDep.setFont(new Font(null, Font.PLAIN, 20));
        lblUFAtualizarDep.setBounds(size.width  * 3 / 4 - 130, 100, 200, 30);
        atualizar.add(lblUFAtualizarDep);

        txtUFAtualizarEst.setBounds(size.width / 4 - 100, 60, 200, 30);
        txtUFAtualizarEst.setEnabled(false);
        atualizar.add(txtUFAtualizarEst);

        txtUFAtualizarDep.setBounds(size.width * 3 / 4 - 100, 100, 200, 30);
        atualizar.add(txtUFAtualizarDep);

        lblDeputadoAtualizar.setFont(new Font(null, Font.PLAIN, 20));
        lblDeputadoAtualizar.setBounds(size.width * 3/ 4 - 190, 140, 200, 30);
        atualizar.add(lblDeputadoAtualizar);

        txtDeputadoAtualizar.setBounds(size.width * 3/ 4 - 100, 140, 200, 30);
        atualizar.add(txtDeputadoAtualizar);

        lblEstadoAtualizar.setFont(new Font(null, Font.PLAIN, 20));
        lblEstadoAtualizar.setBounds(size.width  / 4 - 170, 100, 200, 30);
        atualizar.add(lblEstadoAtualizar);

        txtEstadoAtualizar.setBounds(size.width / 4 - 100, 100, 200, 30);
        atualizar.add(txtEstadoAtualizar);

        lblCapitalAtualizar.setFont(new Font(null, Font.PLAIN, 20));
        lblCapitalAtualizar.setBounds(size.width / 4 - 170, 140, 200, 30);
        atualizar.add(lblCapitalAtualizar);

        txtCapitalAtualizar.setBounds(size.width / 4 - 100, 140, 200, 30);
        atualizar.add(txtCapitalAtualizar);

        lblNumDeputadoAtualizar.setFont(new Font(null, Font.PLAIN, 20));
        lblNumDeputadoAtualizar.setBounds(size.width * 3 / 4 - 170, 60, 200, 30);
        atualizar.add(lblNumDeputadoAtualizar);

        txtNumDeputadoAtualizar.setBounds(size.width * 3 / 4 - 100, 60, 200, 30);
        txtNumDeputadoAtualizar.setEnabled(false);
        atualizar.add(txtNumDeputadoAtualizar);

        lblPartidoAtualizar.setFont(new Font(null, Font.PLAIN, 20));
        lblPartidoAtualizar.setBounds(size.width * 3 / 4 - 170, 180, 200, 30);
        atualizar.add(lblPartidoAtualizar);

        txtPartidoAtualizar.setBounds(size.width * 3 / 4 - 100, 180, 200, 30);
        atualizar.add(txtPartidoAtualizar);

        boxEstadosAtualizar.setBounds(size.width / 4 - 100, 20, 200, 30);
        atualizar.add(boxEstadosAtualizar);
        for (var estado : estados) {
            boxEstadosAtualizar.addItem(estado.getNome());
        }
        boxEstadosAtualizar.addActionListener(e -> {
            if (boxEstadosAtualizar.getSelectedIndex() > -1 && boxEstadosAtualizar.getSelectedIndex() < boxEstadosAtualizar.getItemCount()) {
                var estado = estados.get(boxEstadosAtualizar.getSelectedIndex());
                txtUFAtualizarEst.setText(estado.getUf());
                txtEstadoAtualizar.setText(estado.getNome());
                txtCapitalAtualizar.setText(estado.getCapital());
            }
        });
        boxEstadosAtualizar.setSelectedIndex(0);

        boxDeputadosAtualizar.setBounds(size.width  * 3 / 4 - 100, 20, 200, 30);
        atualizar.add(boxDeputadosAtualizar);
        for (var dep : deputados) {
            boxDeputadosAtualizar.addItem(dep.getNome());
        }
        boxDeputadosAtualizar.addActionListener(e -> {
            if (boxDeputadosAtualizar.getSelectedIndex() > -1 && boxDeputadosAtualizar.getSelectedIndex() < boxDeputadosAtualizar.getItemCount()) {
                var dep = deputados.get(boxDeputadosAtualizar.getSelectedIndex());
                txtNumDeputadoAtualizar.setText(String.valueOf(dep.getNumDeputado()));
                txtUFAtualizarDep.setText(dep.getUF());
                txtDeputadoAtualizar.setText(dep.getNome());
                txtPartidoAtualizar.setText(dep.getPartido());
            }
        });
        boxDeputadosAtualizar.setSelectedIndex(0);


        btnAtualizarEst.setBounds(size.width / 4 - 50, size.height - 50, 100, 20);
        btnAtualizarEst.addActionListener(e -> {
            Estado estado = estados.get(boxEstadosAtualizar.getSelectedIndex());
            try {
                estado.setNome(txtEstadoAtualizar.getText());
                estado.setCapital(txtCapitalAtualizar.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            for (var est : estados) {
                if (est.getUf() == estado.getUf())
                {
                    estados.set(estados.indexOf(est), estado);
                    break;
                }
            }
            try {
                Estados.alterar(estado);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            atualizarTudo();
            JOptionPane.showMessageDialog(null, "Estado editado com sucesso");

        });
        atualizar.add(btnAtualizarEst);

        btnAtualizarDep.setBounds(size.width * 3 / 4 - 50, size.height - 50, 100, 20);
        btnAtualizarDep.addActionListener(e -> {
            Deputado dep = deputados.get(boxDeputadosAtualizar.getSelectedIndex());
            try {
                dep.setNome(txtDeputadoAtualizar.getText());
                dep.setPartido(txtPartidoAtualizar.getText());
                boolean achouUF = false;
                for (var estado : estados)
                {
                    if (estado.getUf().equals(txtUFAtualizarDep.getText()))
                    {
                        dep.setUF(estado.getUf());
                        achouUF = true;
                        break;
                    }
                }
                if (!achouUF)
                {
                    throw new Exception("UF não encontrada");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return;
            }
            for (var deputado : deputados) {
                if (deputado.getNumDeputado() == dep.getNumDeputado())
                {
                    deputados.set(deputados.indexOf(deputado), dep);
                    break;
                }
            }
            try {
                Deputados.alterar(dep);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            atualizarTudo();
            JOptionPane.showMessageDialog(null, "Deputado editado com sucesso");
        });
        atualizar.add(btnAtualizarDep);
        //endregion
        //region Parte de deletar
        deletar.setLayout(null);
        boxDeputadosDeletar.setBounds(0, 40, 200, 30);
        deletar.add(boxDeputadosDeletar);
        boxEstadosDeletar.setBounds(0, 0, 200, 30);
        deletar.add(boxEstadosDeletar);
        for (var estado : estados) {
            boxEstadosDeletar.addItem(estado.getNome());
        }
        boxEstadosDeletar.addActionListener(e -> {
            try {
                selecionarEstadoDel(boxEstadosDeletar.getSelectedItem().toString());
            }
            catch (Exception erro)
            {

            }
        });
        boxDeputadosDeletar.addActionListener(e -> {
            String st;
            try
            {
                st = boxDeputadosDeletar.getSelectedItem().toString();
            }
            catch (Exception ex)
            {
                return;
            }
            Deputado deputadoSelecionado = null;
            for (var deputado : deputados) {
                if (deputado.getNome() == st) {
                    deputadoSelecionado = deputado;
                    break;
                }
            }
            lblNumDepDel.setText("Núm. Deputado: " + deputadoSelecionado.getNumDeputado());
            lblNomeDepDel.setText("Nome Deputado: " + deputadoSelecionado.getNome());
            lblPartidoDepDel.setText("Partido: " + deputadoSelecionado.getPartido());
            lblUFDepDel.setText("UF: " + deputadoSelecionado.getUF());
        });
        boxEstadosDeletar.setSelectedIndex(0);
        boxDeputadosDeletar.setSelectedIndex(0);

        lblNumDepDel.setBounds(0, 80, 200, 30);
        deletar.add(lblNumDepDel);
        lblNomeDepDel.setBounds(0, 110, 200, 30);
        deletar.add(lblNomeDepDel);
        lblPartidoDepDel.setBounds(0, 140, 200, 30);
        deletar.add(lblPartidoDepDel);
        lblUFDepDel.setBounds(0, 170, 200, 30);
        deletar.add(lblUFDepDel);

        btnDeletar.setBounds(size.width / 2 - 50, size.height - 50, 100, 20);
        btnDeletar.addActionListener(e -> {
            Deputado dep = deputados.get(boxDeputadosDeletar.getSelectedIndex());
            try 
            {
                Deputados.excluir(dep.getNumDeputado());
            } 
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return;
            }
            deputados.remove(dep);
            atualizarTudo();
            JOptionPane.showMessageDialog(null, "Deputado deletado com sucesso");
        });

        deletar.add(btnDeletar);
        //endregion
    }
}
