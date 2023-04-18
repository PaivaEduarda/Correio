import bd.core.MeuResultSet;
import bd.daos.Correios;
import bd.dbos.Correio;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Janela extends JFrame {
    private JTabbedPane tab = new JTabbedPane();

    private JPanel ler                = new JPanel();
    private JPanel criar              = new JPanel();
    private JPanel atualizar          = new JPanel();
    private JPanel deletar            = new JPanel();

    private JTextField teste = new JTextField();

    private JButton procurarRemetente = new JButton("Procurar");

    private JLabel digiteCpf = new JLabel("Digite o CPF do remetente: ");
    private JLabel nomeRemetente = new JLabel("Remetente: ");
    private JLabel dest = new JLabel("Informações do destinatário: ");
    private JLabel nomeDestinatario = new JLabel("Nome: ");
    private JLabel cep = new JLabel("CEP: ");
    private JLabel complemento = new JLabel("Complemento: ");
    private JLabel nmrCasa = new JLabel("Número da casa: ");

    public Janela()
    {
        super("Correios");
        super.setSize(800, 600);
        super.setVisible(true);
        super.add(tab);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tab.add("Ler", ler);
        tab.add("Adicionar", criar);
        tab.add("Deletar", deletar);
        tab.add("Atualizar", atualizar);

        Dimension size = tab.getSize();

        //ler

        nomeRemetente.setBounds(10, 500, 30, 2);


        ler.add(digiteCpf);
        ler.add(teste);
        ler.add(procurarRemetente);

        ler.add(nomeRemetente);
        ler.add(dest);
        ler.add(nomeDestinatario);
        ler.add(cep);
        ler.add(complemento);
        ler.add(nmrCasa);




    }
}
