package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class QuickStart {
    private static final Logger logger = LoggerFactory.getLogger(QuickStart.class); 
 
    public static void main( String[] args ) {

        String uri = "mongodb://localhost:27017";

        try (MongoClient mongoClient = MongoClients.create(uri)) {

            MongoDatabase database = mongoClient.getDatabase("projet");
            MongoCollection<Document> collection1 = database.getCollection("client");
            processFirstDocument(collection1, "client");

            MongoCollection<Document> collection2 = database.getCollection("commande");
            processFirstDocument(collection2, "commande");

          
            MongoCollection<Document> collection3 = database.getCollection("article");
            processFirstDocument(collection3, "article");

          
            MongoCollection<Document> collection4 = database.getCollection("LipneCmd");
            processFirstDocument(collection4, "LipneCmd");

        } catch (Exception e) {
            logger.error("An error occurred", e);
        }
    }
    
    private static void processFirstDocument(MongoCollection<Document> collection, String name) {
        Document doc = collection.find().first();
        if (doc != null) {
            logger.info("First document in {}: {}", name, doc.toJson());
        } else {
            logger.info("No matching documents found in {}.", name);
        }
    }
}