/*
 * Copyright (c) 2015-2016, Stuart Wheater, Newcastle upon Tyne, England. All rights reserved.
 */

package com.nishnosh.talos.engine.sensor;

import java.util.UUID;

public interface Sensor
{
    public UUID getInstanceID();

    public UUID getTypeID();

    public Object getState();
}
