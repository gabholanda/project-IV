package br.senac.sp.grupoum.projectpiiv.models;

/**
 *
 * @author erick
 */
public class ImagemProduto {
    private int id;
    private int id_produto;
    private String caminho_imagem;
    
    public ImagemProduto() {

    }
    
    public ImagemProduto(int id_produto, String caminho_imagem) {
        this.id_produto = id_produto;
        this.caminho_imagem = caminho_imagem;
    }
    
    public ImagemProduto(int id, int id_produto, String caminho_imagem) {
        this.id = id;
        this.id_produto = id_produto;
        this.caminho_imagem = caminho_imagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getCaminho_imagem() {
        return caminho_imagem;
    }

    public void setCaminho_imagem(String caminho_imagem) {
        this.caminho_imagem = caminho_imagem;
    }
    
    
}
