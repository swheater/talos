/*
 * Copyright (c) 2015, Stuart Wheater, Newcastle upon Tyne, England. All rights reserved.
 */

package com.nishnosh.talos.engine.sensor;

import java.util.List;
import java.util.UUID;

public interface SensorInventory
{
    public Sensor getSensor(UUID sensorInstanceID);

    public List<Sensor> getSensors();

    public boolean addSensor(Sensor sensor);

    public boolean removeSensor(Sensor sensor);
}
