package bd.dbos;

public class CEP implements Cloneable
{
    private int cepDestinatario;
    private String complemento;
    private String bairro;
    private String cidade;
    private String logradouro;
    private String estado;


    public void setCepDestinatario(String cep) throws Exception
    {
        if(cep.length() != 8)
            throw new Exception("CEP inválido");

        if(cep == null || cep.equals(""))
            throw new Exception("O cep não foi digitado");

        this.cepDestinatario = Integer.parseInt(cep);
    }


    public void setComplemento(String comp) throws Exception
    {
        if(comp.length()> 20)
            throw new Exception("Tamanho inválido");

        this.complemento = comp;
    }


    public void setBairro(String bairro) throws Exception
    {
        if(bairro.length()>20)
            throw new Exception("Tamanho inválido");

        if(bairro == null || bairro.equals(""))
            throw new Exception("O bairro não foi digitado");

        this.bairro = bairro;
    }

    public void setCidade(String cid) throws Exception
    {
        if(cid.length()>10)
            throw new Exception("Tamanho inválido");

        if(cid == null || cid.equals(""))
            throw new Exception("A cidade não foi digitada");

        this.cidade = cid;
    }

    public void setLogradouro(String log) throws Exception
    {
        if(log.length()>30)
            throw new Exception("Tamanho inválido");

        if(log == null || log.equals(""))
            throw new Exception("O logradouro não foi digitado");

        this.logradouro = log;
    }

    public void setEstado(String est) throws Exception
    {
        if(est.length()>15)
            throw new Exception("Tamanho inválido");

        if(est == null || est.equals(""))
            throw new Exception("O estado não foi digitado");

        this.estado = est;
    }


    public Integer getCepDestinatario()
    {
        return this.cepDestinatario;
    }

    public String getBairro()
    {
        return this.bairro;
    }

    public String getComplemento()
    {
        return this.complemento;
    }

    public String getCidade()
    {
        return this.cidade;
    }

    public String getLogradouro()
    {
        return this.logradouro;
    }

    public String getEstado()
    {
        return this.estado;
    }

    public CEP(String cep, String complemento, String bairro, String cidade, String logradouro, String estado) throws Exception
    {
        this.setCepDestinatario(cep);
        this.setComplemento(complemento);
        this.setBairro(bairro);
        this.setCidade(cidade);
        this.setLogradouro(logradouro);
        this.setEstado(estado);
    }

    public String toString()
    {
        String ret = "";
        ret+="Cep Destinatário:"+this.cepDestinatario+"\n";
        ret+="Complemento:"+this.complemento+"\n";
        ret+="Bairro"+this.bairro+"\n";
        ret+="Cidade"+this.cidade+"\n";
        ret+="Logradouro"+this.logradouro+"\n";
        ret+="Estado"+this.estado;

        return ret;
    }

    public boolean equals(Object obj)
    {
        if(this==obj) return true;

        if(obj == null) return false;

        if(!(obj instanceof CEP)) return false;

        CEP cep = (CEP) obj;

        if(this.cepDestinatario != cep.cepDestinatario) return false;

        if(!(this.complemento.equals(cep.complemento))) return false;

        if(!(this.bairro.equals(cep.bairro))) return false;

        if(!(this.cidade.equals(cep.cidade))) return false;

        if(!(this.logradouro.equals(cep.logradouro))) return false;

        if(!(this.estado.equals(cep.estado))) return false;

        return true;
    }

    public int hashCode()
    {
        int ret = 666;
        ret = ret * 13 + Integer.valueOf(cepDestinatario).hashCode();
        ret = ret * 13 + this.complemento.hashCode();
        ret = ret * 13 + this.bairro.hashCode();
        ret = ret * 13 + this.cidade.hashCode();
        ret = ret * 13 + this.logradouro.hashCode();
        ret = ret * 13 + this.estado.hashCode();

        return ret;
    }

    public CEP (CEP modelo) throws Exception
    {
        if(modelo == null)
            throw new Exception("Modelo inexistente");

        this.cepDestinatario = modelo.cepDestinatario;
        this.complemento = modelo.complemento;
        this.bairro = modelo.bairro;
        this.cidade = modelo.cidade;
        this.logradouro = modelo.logradouro;
        this.estado = modelo.estado;
    }
    public Object clone()
    {
        CEP ret = null;

        try {
            ret = new CEP(this);
        }
        catch(Exception erro){}

        return ret;
    }
}
