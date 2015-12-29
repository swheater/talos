/*
 * Copyright (c) 2015, Stuart Wheater, Newcastle upon Tyne, England. All rights reserved.
 */

package com.nishnosh.talos.engine.sensor;

import java.util.List;
import java.util.UUID;

public interface SensorFactoryInventory
{
    public SensorFactory getSensorFactory(UUID sensorTypeID);

    public List<SensorFactory> getSensorFactorys();

    public boolean addSensorFactory(SensorFactory sensorFactory);

    public boolean removeSensorFactory(SensorFactory sensorFactory);
}
