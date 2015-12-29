/*
 * Copyright (c) 2015, Stuart Wheater, Newcastle upon Tyne, England. All rights reserved.
 */

package com.nishnosh.talos.engine;

import java.util.UUID;
import java.util.logging.Logger;
import java.util.logging.Level;
import com.nishnosh.talos.engine.actuator.ActuatorFactoryInventory;
import com.nishnosh.talos.engine.actuator.ActuatorInventory;

public class ActuatorManagement
{
    private static Logger logger = Logger.getLogger(ActuatorManagement.class.getName());

    public ActuatorManagement()
    {
        _actuatorInventory        = null;
        _actuatorFactoryInventory = null;
    }

    public UUID createActuator(UUID actuatorTypeId, Object actuatorConfig)
    {
        return null;
    }

    public Object getActuatorConfig(UUID actuatorId)
    {
        return null;
    }

    public void configureActuator(UUID actuatorId, Object actuatorConfig)
    {
    }

    public UUID destroyActuator(UUID actuatorId)
    {
        return null;
    }

    private ActuatorInventory        _actuatorInventory;
    private ActuatorFactoryInventory _actuatorFactoryInventory;
}
