/*
 * Copyright (c) 2015-2016, Stuart Wheater, Newcastle upon Tyne, England. All rights reserved.
 */

package com.nishnosh.talos.tests.engine;

import java.util.logging.Logger;
import java.util.logging.Level;
import org.bson.Document;
import org.reactivestreams.Processor;
import org.reactivestreams.Subscription;
import org.reactivestreams.Subscriber;

public class MiniProcessor implements Processor<Document, Document>
{
    private static Logger logger = Logger.getLogger(MiniProcessor.class.getName());

    public MiniProcessor(String name)
    {
        logger.log(Level.INFO, "Creating MiniProcessor: [" + name + "]");

        _name = name;

        _subscription = null;

        _endSync = new Object();
        _ended   = false;
    }

    public void onSubscribe(Subscription subscription)
    {
        logger.log(Level.INFO, "onSubscribe - MiniProcessor: [" + _name + "]");

        _subscription = subscription;
        _subscription.request(1);
    }

    public void onNext(Document data)
    {
        logger.log(Level.INFO, "onNext - MiniProcessor: [" + _name + "] - Data: " + data.toJson());

        _subscription.request(1);
    }

    public void onComplete()
    {
        logger.log(Level.INFO, "onComplete - MiniProcessor: [" + _name + "]");

        synchronized (_endSync)
        {
            _ended = true;
            _endSync.notifyAll();
        }
    }

    public void onError(Throwable throwable)
    {
        logger.log(Level.INFO, "onError - MiniProcessor: [" + _name + "]");

        synchronized (_endSync)
        {
            _ended = true;
            _endSync.notifyAll();
        }
    }

    public void subscribe(Subscriber<? super Document> subscriber)
    {
        logger.log(Level.INFO, "subscribe - MiniProcessor");
    }

    public void awaitEnd()
        throws InterruptedException
    {
        synchronized (_endSync)
        {
            while (! _ended)
                _endSync.wait();
        }
    }

    public String _name;

    public Subscription _subscription;

    private Object  _endSync;
    private boolean _ended;
}
