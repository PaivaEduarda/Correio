import bd.core.MeuResultSet;
import bd.daos.Correios;
import bd.dbos.Correio;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Janela extends JFrame {
    private JTabbedPane tab = new JTabbedPane();

    private JPanel ler                = new JPanel();
    private JPanel adicionar              = new JPanel();
    private JPanel atualizar          = new JPanel();
    private JPanel deletar            = new JPanel();

    private JTextField txtCpf = new JTextField();
    private JTextField addTxtCPFRemetente = new JTextField();
    private JTextField addTxtRemetente = new JTextField();
    private JTextField addTxtNomeDest = new JTextField();
    private JTextField addTxtCep = new JTextField();
    private JTextField addTxtRua = new JTextField();
    private JTextField addTxtBairro = new JTextField();
    private JTextField addTxtCidade = new JTextField();
    private JTextField addTxtEstado = new JTextField();
    private JTextField addTxtComplemento = new JTextField();
    private JTextField addTxtNmrCasa = new JTextField();

    private JButton procurarRemetente = new JButton("Procurar");
    private JButton btnAdicionar = new JButton("Adicionar");

    private JLabel digiteCpf = new JLabel("Digite o CPF do remetente: ");
    private JLabel nomeRemetente = new JLabel("Remetente: ");
    private JLabel dest = new JLabel("Informações do destinatário: ");
    private JLabel nomeDestinatario = new JLabel("Nome: ");
    private JLabel cep = new JLabel("CEP: ");
    private JLabel logradouro = new JLabel("Logradouro: ");
    private JLabel bairro = new JLabel("Bairro: ");
    private JLabel cidade = new JLabel("Cidade: ");
    private JLabel estado = new JLabel("Estado: ");
    private JLabel complemento = new JLabel("Complemento: ");
    private JLabel nmrCasa = new JLabel("Número da casa: ");


    private JLabel addCPFRemetente = new JLabel("CPF do remetente: ");
    private JLabel addRemetente = new JLabel("Nome do remetente: ");
    private JLabel addInfoDestinatario = new JLabel("Informações do Destinatário: ");
    private JLabel addNomeDest = new JLabel("Nome: ");
    private JLabel addCep = new JLabel("Cep: ");
    private JLabel addRua = new JLabel("Logradouro: ");
    private JLabel addBairro = new JLabel("Bairro: ");
    private JLabel addCidade = new JLabel("Cidade: ");
    private JLabel addEstado = new JLabel("Estado: ");
    private JLabel addComplemento = new JLabel("Complemento: ");
    private JLabel addNmrCasa = new JLabel("Número da casa:");


    public Janela()
    {
        super("Correios");
        super.setSize(500, 350);
        super.setVisible(true);
        super.add(tab);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ler.setLayout(null);
        adicionar.setLayout(null);
        deletar.setLayout(null);
        atualizar.setLayout(null);

        tab.add("Ler", ler);
        tab.add("Adicionar", adicionar);
        tab.add("Deletar", deletar);
        tab.add("Atualizar", atualizar);

        Dimension size = tab.getSize();

        //ler
        digiteCpf.setBounds(10, 30, 200, 20);
        txtCpf.setBounds(10,50, 200, 20);
        procurarRemetente.setBounds(220, 50, 100, 20);
        nomeRemetente.setBounds(10, 70, 100, 20);
        dest.setBounds(10, 90, 200, 20);
        nomeDestinatario.setBounds(10, 110, 100, 20);
        cep.setBounds(10, 130, 100, 20);
        logradouro.setBounds(10, 150, 200, 20);
        bairro.setBounds(10, 170, 150, 20);
        cidade.setBounds(10, 190, 150, 20);
        estado.setBounds(10, 210, 150, 20);
        complemento.setBounds(10, 230, 150, 20);
        nmrCasa.setBounds(10, 250, 150, 20);

        ler.add(digiteCpf);
        ler.add(txtCpf);
        ler.add(procurarRemetente);

        ler.add(nomeRemetente);
        ler.add(dest);
        ler.add(nomeDestinatario);
        ler.add(cep);
        ler.add(logradouro);
        ler.add(bairro);
        ler.add(cidade);
        ler.add(estado);
        ler.add(complemento);
        ler.add(nmrCasa);

        //adicionar
        addCPFRemetente.setBounds(10,30,200,20);
        addTxtCPFRemetente.setBounds(200,30,200,20);

        addRemetente.setBounds(10,50,200,20);
        addTxtRemetente.setBounds(200,50,200,20);

        addInfoDestinatario.setBounds(10,70,200,20);

        addNomeDest.setBounds(10,90,200,20);
        addTxtNomeDest.setBounds(200,90,200,20);

        addCep.setBounds(10,110,200,20);
        addTxtCep.setBounds(200,110,200,20);

        addRua.setBounds(10,130,200,20);
        addTxtRua.setBounds(200,130,200,20);

        addBairro.setBounds(10,150,200,20);
        addTxtBairro.setBounds(200,150,200,20);

        addCidade.setBounds(10,170,200,20);
        addTxtCidade.setBounds(200,170,200,20);

        addEstado.setBounds(10,190,200,20);
        addTxtEstado.setBounds(200,190,200,20);

        addComplemento.setBounds(10,210,200,20);
        addTxtComplemento.setBounds(200,210,200,20);

        addNmrCasa.setBounds(10,230,200,20);
        addTxtNmrCasa.setBounds(200,230,200,20);

        btnAdicionar.setBounds(140, 260, 200, 20);

        adicionar.add(addCPFRemetente);
        adicionar.add(addTxtCPFRemetente);
        adicionar.add(addRemetente);
        adicionar.add(addTxtRemetente);
        adicionar.add(addInfoDestinatario);
        adicionar.add(addNomeDest);
        adicionar.add(addTxtNomeDest);
        adicionar.add(addCep);
        adicionar.add(addTxtCep);
        adicionar.add(addRua);
        adicionar.add(addTxtRua);
        adicionar.add(addBairro);
        adicionar.add(addTxtBairro);
        adicionar.add(addCidade);
        adicionar.add(addTxtCidade);
        adicionar.add(addEstado);
        adicionar.add(addTxtEstado);
        adicionar.add(addComplemento);
        adicionar.add(addTxtComplemento);
        adicionar.add(addNmrCasa);
        adicionar.add(addTxtNmrCasa);
        adicionar.add(btnAdicionar);

        //deletar

        
    }
}
