/*
 * Copyright (c) 2015, Stuart Wheater, Newcastle upon Tyne, England. All rights reserved.
 */

package com.nishnosh.talos;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.logging.Level;

import com.nishnosh.talos.engine.Engine;

public class Main
{
    private static Logger logger = Logger.getLogger(Main.class.getName());

    private static class EngineThread extends Thread
    {
        public EngineThread(String name, Engine engine)
        {
            super(name);

            _engine = engine;
        }

        @Override
        public void run()
        {
            try
            {
                _engine.start();
            }
            catch (Throwable throwable)
            {
                logger.log(Level.SEVERE, "Telos Engine Failed", throwable);
            }
        }

        private Engine _engine;
    }

    private static class EngineTerminateThread extends Thread
    {
        public EngineTerminateThread(String name, Engine engine, Thread mainThread)
        {
            super(name);

            _engine     = engine;
            _mainThread = mainThread;
        }

        @Override
        public void run()
        {
            try
            {
                _engine.terminate();
                _mainThread.join();
            }
            catch (Throwable throwable)
            {
                logger.log(Level.SEVERE, "Telos Engine Terminate Failed", throwable);
            }
        }

        private Engine _engine;
        private Thread _mainThread;
    }

    public static void main(String[] args)
    {
        try
        {
            logger.log(Level.INFO, "Setting Up Telos Engine....");

            Engine engine = new Engine();

            Properties engineProperties        = new Properties();
            File       currentWorkingDirectory = new File(System.getProperty("user.dir"));
            File       enginePropertiesFile    = new File(currentWorkingDirectory, "engine.properties");
            if (enginePropertiesFile.exists() && enginePropertiesFile.canRead() && enginePropertiesFile.isFile())
            {
                FileReader enginePropertiesFileReader = new FileReader(enginePropertiesFile);
                engineProperties.load(enginePropertiesFileReader);
                enginePropertiesFileReader.close();
            }
            else
                logger.log(Level.WARNING, "Unable to load Telos Engine properties: " + enginePropertiesFile.getCanonicalPath());
            engine.setup(engineProperties);

            logger.log(Level.INFO, "Setup Telos Engine....");
            logger.log(Level.INFO, "Starting Telos Engine....");

            Thread engineThread = new EngineThread("Talos Engine Thread", engine);
            engineThread.start();

            logger.log(Level.INFO, "Started Telos Engine....");

            Runtime.getRuntime().addShutdownHook(new EngineTerminateThread("Talos Engine Terminate Thread", engine, Thread.currentThread()));
            engineThread.join();

            logger.log(Level.INFO, "Shutting Down Telos Engine....");

            engine.shutdown();

            logger.log(Level.INFO, "Shutdown Telos Engine.");
        }
        catch (Throwable throwable)
        {
            logger.log(Level.SEVERE, "Telos Problem", throwable);
        }
    }
}
