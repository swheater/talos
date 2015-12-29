/*
 * Copyright (c) 2015, Stuart Wheater, Newcastle upon Tyne, England. All rights reserved.
 */

package com.nishnosh.talos.engine.actuator;

import java.util.UUID;

public interface ActuatorFactory
{
    public UUID getActuatorTypeID();

    public Actuator createActuator();
}
