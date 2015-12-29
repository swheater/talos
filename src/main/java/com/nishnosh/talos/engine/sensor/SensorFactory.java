/*
 * Copyright (c) 2015, Stuart Wheater, Newcastle upon Tyne, England. All rights reserved.
 */

package com.nishnosh.talos.engine.sensor;

import java.util.UUID;

public interface SensorFactory
{
    public UUID getSensorTypeID();

    public Sensor createSensor();
}
