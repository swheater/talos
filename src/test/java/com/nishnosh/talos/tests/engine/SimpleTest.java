
/*
 * Copyright (c) 2015-2016, Stuart Wheater, Newcastle upon Tyne, England. All rights reserved.
 */

package com.nishnosh.talos.tests.engine;

import java.util.logging.Logger;
import java.util.logging.Level;
import org.reactivestreams.Publisher;
// import org.reactivestreams.Subscriber;
import org.bson.Document;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoDatabase;
import org.junit.Test;

public class SimpleTest
{
    private static Logger logger = Logger.getLogger(SimpleTest.class.getName());

    @Test
    public void basic()
    {
        MongoClient mongoClient = null;

        try
        {
            logger.log(Level.INFO, "Starting Telos Engine....");

            mongoClient = MongoClients.create();

            MongoDatabase database = mongoClient.getDatabase("test");

            Publisher<Document> publisher = database.listCollections();

            MiniProcessor miniProcessor1 = new MiniProcessor("Mini #1");
            MiniProcessor miniProcessor2 = new MiniProcessor("Mini #2");
            publisher.subscribe(miniProcessor1);
            publisher.subscribe(miniProcessor2);
            miniProcessor1.awaitEnd();
            miniProcessor2.awaitEnd();

//            Subscriber<Document> subscriber = new PrintDocumentSubscriber();
//            miniProcessor.subscribe(subscriber);
//            subscriber.await();
        }
        catch (Throwable throwable)
        {
            logger.log(Level.SEVERE, "Telos Engine Failed", throwable);
        }
        finally
        {
            if (mongoClient != null)
                mongoClient.close();
        }
    }
}
