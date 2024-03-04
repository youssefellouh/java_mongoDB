package com.example;
import java.util.ArrayList;
import java.util.List;

public class Commande {
    private int num;
    private String date;
    private String adresseLivraison;
    private Client client; 
    private boolean Payee;
    private List<Article> articles; 

    public Commande(int num, String date, String adresseLivraison, Client client) {
        this.num = num;
        this.date = date;
        this.adresseLivraison = adresseLivraison;
        this.client = client;
        this.Payee = false;
        this.articles = new ArrayList<>();
    }
    public void ajouterArticle(Article article) {
        articles.add(article);
    }
    public  List<Article>  getArticle() {
        return  articles;
    }

    public void setArticle( List<Article> articles) {
        this.articles = articles;
    }
    public int getNum(){
        return num;
    }
    public void setNum(int num){
        this.num=num;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date=date;
    }
    public String getAdresseLivraison(){
        return adresseLivraison;
    }
    public void setAdresseLivraison(String adresseLivraison){
        this.adresseLivraison=adresseLivraison;
    }
    public Client getclient(){
        return client;
    }
    public void setDate(Client client){
        this.client=client;
    }

    // Method to calculate the total amount of the command
    public double calculMontant() {
        double montantTotal = 0;
        for (Article article : articles) {
            montantTotal += article.getPrixU();
        }
        return montantTotal;
    }

    // Method to modify an article details within command
    public void moduifier(String code, Article newArticle) {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getCode().equals(code)) {
                articles.set(i, newArticle);
                return;
            }
        }
        System.out.println("Article with code " + code + " not found.");
    }
    public boolean isPayee() {
        return Payee;
    }
    // Method to mark the command as paid
    public void isPayee(boolean Payee) {
        this.Payee = true;
    }

    // Getters and setters as necessary...
}



    // Additional getters and setters as necessary...
