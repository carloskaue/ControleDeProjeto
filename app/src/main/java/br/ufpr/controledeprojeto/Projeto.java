package br.ufpr.controledeprojeto;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Created by Kaue on 21/04/2018.
 */

public class Projeto {
    private String fNome;
    private String fCliente;
    private GregorianCalendar fDataInicial;
    private String fComentario;

    public Projeto(String fNome, String fLocal, GregorianCalendar fData) {
        this.fNome = fNome;
        this.fCliente = fLocal;
        this.fDataInicial = fData;
        this.fComentario = "";
    }

    public Projeto(String fNome, String fCliente, int dia, int mes, int ano) {
        this.fNome = fNome;
        this.fCliente = fCliente;
        this.fDataInicial = new GregorianCalendar(ano, mes-1, dia);
        this.fComentario = "";
    }

    public String getfNome() {
        return fNome;
    }

    public void setfNome(String fNome) {
        this.fNome = fNome;
    }

    public String getfCliente() {
        return fCliente;
    }

    public void setfCliente(String fCliente) {
        this.fCliente = fCliente;
    }

    public GregorianCalendar getfData() {
        return fDataInicial;
    }

    public String getfDataString () {
        SimpleDateFormat stf = new SimpleDateFormat("dd.MM.yyyy");
        String sData = stf.format(fDataInicial.getTime());
        return sData;
    }

    public void setfData(GregorianCalendar fData) {
        this.fDataInicial = fData;
    }

    public void setfData(int dia, int mes, int ano) {
        setfData(new GregorianCalendar(ano, mes-1, dia));
    }

    public String getfComentario() {
        return fComentario;
    }

    public void setfComentario(String fComentario) {
        this.fComentario = fComentario;
    }

    public String toString() {
        return fNome;
    }
}
