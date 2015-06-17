package br.com.aceleradora.inimigosamesa.model;


public class Categoria {
    private int codCategoria;
    private String nomeCategoria;

    public Categoria() {

    }


    public Categoria(int codCategoria, String nomeCategoria) {

        this.codCategoria = codCategoria;
        this.nomeCategoria = nomeCategoria;
    }


    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }



}
