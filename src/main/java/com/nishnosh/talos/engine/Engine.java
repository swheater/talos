/*
 * Copyright (c) 2015, Stuart Wheater, Newcastle upon Tyne, England. All rights reserved.
 */

package com.nishnosh.talos.engine;

import java.util.Properties;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Engine
{
    private static Logger logger = Logger.getLogger(Engine.class.getName());

    public Engine()
    {
        _sensorManagement    = null;
        _actuatorManagement  = null;
        _containerManagement = null;

        _terminateSync = new Object();
    }

    public void setup(Properties properties)
    {
        logger.log(Level.FINE, "setup");

        _sensorManagement    = new SensorManagement();
        _actuatorManagement  = new ActuatorManagement();
        _containerManagement = new ContainerManagement();
    }

    public void start()
    {
        logger.log(Level.FINE, "start");

        synchronized (_terminateSync)
        {
            try
            {
                _terminateSync.wait();
            }
            catch (Throwable throwable)
            {
                logger.log(Level.WARNING, "Telos Engine Failed", throwable);
            }
        }
    }

    public void shutdown()
    {
        logger.log(Level.FINE, "shutdown");
    }

    public void terminate()
    {
        logger.log(Level.FINE, "terminate");

        synchronized (_terminateSync)
        {
            _terminateSync.notifyAll();
        }
    }

    public SensorManagement getSensorManagement()
    {
        return _sensorManagement;
    }

    public ActuatorManagement getActuatorManagement()
    {
        return _actuatorManagement;
    }

    public ContainerManagement getContainerManagement()
    {
        return _containerManagement;
    }

    private SensorManagement    _sensorManagement;
    private ActuatorManagement  _actuatorManagement;
    private ContainerManagement _containerManagement;

    private Object _terminateSync;
}
