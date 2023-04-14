package bd.dbos;

public class Correio implements Cloneable
{
    private String cpf;
    private String nomeRemetente;
    private String nomeDestinatario;
    private String cep;
    private String complemento;
    private int nmrCasa;


    public void setCPF(string cpf) throws Exception
    {
        if(cpf.length() != 11)
            throw new Exception("CPF inválido");

        if(cpf == null || cpf.equals(""))
            throw new Exception("O cpf não foi digitado");

        this.cpf = cpf;
    }
    public void setCEP(string cep) throws Exception
    {
        if(cep.length() != 8)
            throw new Exception("CEP inválido");

        if(cep == null || cep.equals(""))
            throw new Exception("O CEP não foi digitado");

        this.cep = cep;
    }


    public void setNomeRemetente(String nmRemetente) throws Exception
    {
        if(nmRemetente.length() > 30)
            throw new Exception("Tamanho inválido");

        this.nomeRemetente = nmRemetente;
    }


    public void setNomeDestinatario(String nmDestinatario) throws Exception
    {
        if(nmDestinatario.length() > 30)
            throw new Exception("Tamanho inválido");

        if(nmDestinatario == null || nmDestinatario.equals(""))
            throw new Exception("O nomeDestinatario não foi digitado");

        this.nomeDestinatario = nmDestinatario;
    }

    public void setComplemento(String comp) throws Exception
    {
        if(comp.length() > 30)
            throw new Exception("Tamanho inválido");

        if(comp == null || comp.equals(""))
            throw new Exception("O complemento não foi digitado");

        this.complemento = comp;
    }

    public void setNmrCasa(int nmrCasa) throws Exception
    {
        if(Integer.toString(nmrCasa).length()>15)
            throw new Exception("Tamanho inválido");

        if(Integer.toString(nmrCasa) == null || Integer.toString(nmrCasa).equals(""))
            throw new Exception("O número da casa não foi digitado");

        this.nmrCasa = nmrCasa;
    }


    public String getCPF()
    {
        return this.cpf;
    }

    public String getNomeDestinatario()
    {
        return this.NomeDestinatario;
    }

    public String getNomeRemetente()
    {
        return this.NomeRemetente;
    }

    public String getCep()
    {
        return this.cep;
    }

    public String getComplemento()
    {
        return this.complemento;
    }

    public String getNmrCasa()
    {
        return this.nmrCasa;
    }

    public Correio(String cpf, String nomeRemetente, String nomeDestinatario, String cep, String complemento, int nmrCasa) throws Exception
    {
        this.setCPF(cpf);
        this.setNomeRemetente(nomeRemetente);
        this.setNomeDestinatario(nomeDestinatario);
        this.setCEP(cep);
        this.setComplemento(complemento);
        this.setNmrCasa(nmrCasa);
    }

    public String toString()
    {
        String ret = "";
        ret+="CPF: "+this.cpf+"\n";
        ret+="nome do Remetente: "+this.nomeRemetente+"\n";
        ret+="nome do Destinatario: "+this.nomeDestinatario+"\n";
        ret+="Cep do Destinatário: "+this.cep+"\n";
        ret+="Complemento: "+this.logradouro+"\n";
        ret+="Número da Casa: "+this.nmrCasa;

        return ret;
    }

    public boolean equals(Object obj)
    {
        if(this==obj) return true;

        if(obj == null) return false;

        if(!(obj instanceof Correio)) return false;

        Correio correio = (Correio) obj;

        if(this.cpf != correio.cpf) return false;

        if(!(this.nomeRemetente.equals(correio.nomeRemetente))) return false;

        if(!(this.nomeDestinatario.equals(correio.nomeDestinatario))) return false;

        if(!(this.cep.equals(correio.cep))) return false;

        if(!(this.complemento.equals(correio.complemento))) return false;

        if(!(this.nmrCasa.equals(correio.nmrCasa))) return false;

        return true;
    }

    public int hashCode()
    {
        int ret = 666;
        ret = ret * 13 + this.cpf.hashCode();
        ret = ret * 13 + this.nomeRemetente.hashCode();
        ret = ret * 13 + this.nomeDestinatario.hashCode();
        ret = ret * 13 + this.cep.hashCode();
        ret = ret * 13 + this.complemento.hashCode();
        ret = ret * 13 + this.nmrCasa.hashCode();

        return ret;
    }

    public Correio (Correio modelo) throws Exception
    {
        if(modelo == null)
            throw new Exception("Modelo inexistente");

        this.cpf = modelo.cpf;
        this.nomeRemetente = modelo.nomeRemetente;
        this.nomeDestinatario = modelo.nomeDestinatario;
        this.cep = modelo.cep;
        this.complemento = modelo.complemento;
        this.nmrCasa = modelo.nmrCasa;
    }
    public Object clone()
    {
        Correio ret = null;

        try {
            ret = new Correio(this);
        }
        catch(Exception erro){}

        return ret;
    }
}