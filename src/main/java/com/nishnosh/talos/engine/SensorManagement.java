/*
 * Copyright (c) 2015, Stuart Wheater, Newcastle upon Tyne, England. All rights reserved.
 */

package com.nishnosh.talos.engine;

import java.util.UUID;
import java.util.logging.Logger;
import java.util.logging.Level;
import com.nishnosh.talos.engine.sensor.SensorFactoryInventory;
import com.nishnosh.talos.engine.sensor.SensorInventory;

public class SensorManagement
{
    private static Logger logger = Logger.getLogger(SensorManagement.class.getName());

    public SensorManagement()
    {
        _sensorInventory        = null;
        _sensorFactoryInventory = null;
    }

    public UUID createSensor(UUID sensorTypeId, Object sensorConfig)
    {
        return null;
    }

    public Object getSensorConfig(UUID sensorId)
    {
        return null;
    }

    public void configureSensor(UUID sensorId, Object sensorConfig)
    {
    }

    public UUID destroySensor(UUID sensorId)
    {
        return null;
    }

    private SensorInventory        _sensorInventory;
    private SensorFactoryInventory _sensorFactoryInventory;
}
