package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainGUI extends JFrame {
    private JTextArea textArea;
    private JButton createArticleButton;
    private JButton createClientButton;
    private JButton createOrderButton;
    private JButton payOrderButton;
    private JButton showTotalCostButton;
    private Client client;
    private Article article1, article2;
    private Commande commande1, commande2;
    private LipneCmd lipneCmd;

    public MainGUI() {
        setTitle("Shop Interface");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    
        setupUI();
    }
  
    private void setupUI() {
        textArea = new JTextArea();
        JPanel buttonPanel = new JPanel();
    
        // Initialize buttons
        createArticleButton = new JButton("Create Articles");
        createClientButton = new JButton("Create Client");
        createOrderButton = new JButton("Create Orders");
        payOrderButton = new JButton("Pay Order");
        showTotalCostButton = new JButton("Show Total Cost");
    
        // Add buttons to the panel
        buttonPanel.add(createArticleButton);
        buttonPanel.add(createClientButton);
        buttonPanel.add(createOrderButton);
        buttonPanel.add(payOrderButton);
        buttonPanel.add(showTotalCostButton);
    
        // Add action listeners
        createArticleButton.addActionListener(e -> createArticles());
        createClientButton.addActionListener(e -> createClient());
        createOrderButton.addActionListener(e -> createOrders());
        payOrderButton.addActionListener(e -> payOrder());
        showTotalCostButton.addActionListener(e -> showTotalCost());
    
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    
        // This is just an example, you should integrate with your existing logic
    }
        private void createArticles() {
        article1 = new Article("A001", "Chaise", 49.99, "Mobilier");
        article2 = new Article("A002", "Table", 89.99, "Mobilier");
        textArea.append("Articles created.\n");
    }
  
    private void createClient() {
        client = new Client("ellouh", "youssef", "123 kenitra", "1234567890", "75000");
        textArea.append("Client created: " + client + "\n");
    }
  
    private void createOrders() {
        commande1 = new Commande(1, "2023-04-01", "123 Rue Principale", client);
        commande1.ajouterArticle(article1);
        commande1.ajouterArticle(article2);
    
        commande2 = new Commande(2, "2023-04-05", "123 Rue Principale", client);
        commande2.ajouterArticle(article2);
    
        client.ajouterCommande(commande1);
        client.ajouterCommande(commande2);
        textArea.append("Orders created.\n");
    }
  
    private void payOrder() {
        client.payerCommande(1);
        textArea.append("Order paid.\n");
    }
  
    private void showTotalCost() {
        lipneCmd = new LipneCmd(5);
        lipneCmd.ajouterArticle(article1);
        lipneCmd.ajouterArticle(article2);
        lipneCmd.ajouterCommande(commande1);
        lipneCmd.ajouterCommande(commande2);
    
        textArea.append("Total cost for quantity " + lipneCmd.getQuantite() + " is: " + lipneCmd.getTotalCost() + "\n");
    }

    // Entry Point
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new MainGUI().setVisible(true);
        });
    }}
