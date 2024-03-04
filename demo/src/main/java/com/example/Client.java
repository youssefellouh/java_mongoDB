package com.example;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String codePostal;
    private List<Commande> commandes; 

    public Client(String nom, String prenom, String adresse, String telephone, String codePostal) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.codePostal = codePostal;
        this.commandes = new ArrayList<>(); // Initialisation de la liste
    }
    public String getPrenom(){
        return prenom;
    }
    public String getNom(){
        return nom;
    }
    public String getAdresse(){
        return adresse;
    }
    public void ajouterCommande(Commande commande) {
        if(commande != null) {
            this.commandes.add(commande);
            System.out.println(prenom + " " + nom + " a ajouté une commande.");
        }
    }

    // Méthode pour payer une commande spécifique par son numéro
    public void payerCommande(int numCommande) {
        for (Commande commande : commandes) {
            if (commande.getNum() == numCommande && !commande.isPayee()) {
                commande.isPayee(); // Supposons que Commande possède une méthode paye() changeant son état à payé
                System.out.println(prenom + " " + nom + " a payé la commande numéro " + numCommande);
                return;
            }
        }
        System.out.println("Commande numéro " + numCommande + " introuvable ou déjà payée.");
    }

    // Getters et setters pour la liste de commandes
    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    // Méthode pour afficher les informations du client
    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telephone='" + telephone + '\'' +
                ", codePostal='" + codePostal + '\'' +
                // Optionnel: Vous pouvez choisir d'afficher ou non les détails des commandes ici.
                // ", commandes=" + commandes +
                '}';
    }
}