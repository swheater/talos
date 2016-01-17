/*
 * Copyright (c) 2015-2016, Stuart Wheater, Newcastle upon Tyne, England. All rights reserved.
 */

package com.nishnosh.talos.engine.actuator;

import java.util.List;
import java.util.UUID;

public interface ActuatorFactoryInventory
{
    public ActuatorFactory getActuatorFactory(UUID actuatorTypeID);

    public List<ActuatorFactory> getActuatorFactorys();

    public boolean addActuatorFactory(ActuatorFactory actuatorFactory);

    public boolean removeActuatorFactory(ActuatorFactory actuatorFactory);
}
