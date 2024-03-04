package com.example;

import java.util.ArrayList;
import java.util.List;

public class LipneCmd{
    private int quantite;
    private List<Article> articles; 
    private List<Commande> commandes; 

    public LipneCmd(int quantite) {
        this.quantite = quantite;
        this.articles = new ArrayList<>();
        this.commandes = new ArrayList<>();
    }

    
    public void ajouterArticle(Article article) {
        articles.add(article);
    }


    public void ajouterCommande(Commande commande) {
        commandes.add(commande);
    }

    // Calculates the total cost. Assumes each article has the same quantity.
    public double getTotalCost() {
        double totalCost = 0;
        for (Article article : articles) {
            totalCost += quantite * article.getPrixU();
        }
        return totalCost;
    }

    // Getters and Setters
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
}