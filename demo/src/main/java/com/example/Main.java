package com.example;

public class Main {
    public static void main(String[] args) {
        Article article1 = new Article("A001", "Chaise", 49.99, "Mobilier");
        Article article2 = new Article("A002", "Table", 89.99, "Mobilier");
        Client client = new Client("ellouh", "youssef", "123 kenitra", "1234567890", "75000");
    
        Commande commande1 = new Commande(1, "2023-04-01", "123 Rue Principale", client);
        commande1.ajouterArticle(article1);
        commande1.ajouterArticle(article2); 
        
        Commande commande2 = new Commande(2, "2023-04-05", "123 Rue Principale", client);
        commande2.ajouterArticle(article2); 
        
        client.ajouterCommande(commande1);
        client.ajouterCommande(commande2);
        
        client.payerCommande(1);
        
        System.out.println(client);
        LipneCmd lipneCmd = new LipneCmd(5); 
        lipneCmd.ajouterArticle(article1);
        lipneCmd.ajouterArticle(article2);
        lipneCmd.ajouterCommande(commande1);
        lipneCmd.ajouterCommande(commande2);
        
        System.out.println("Le coût total des articles avec quantité " + lipneCmd.getQuantite() + " est : " + lipneCmd.getTotalCost());
    }
}