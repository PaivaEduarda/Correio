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

    private JTextField teste = new JTextField("Hello word!");
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

        ler.add(teste);

    }
}
