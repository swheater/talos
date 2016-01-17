/*
 * Copyright (c) 2015-2016, Stuart Wheater, Newcastle upon Tyne, England. All rights reserved.
 */

package com.nishnosh.talos.engine.actuator;

import java.util.List;
import java.util.UUID;

public interface ActuatorInventory
{
    public Actuator getActuator(UUID actuatorInstanceID);

    public List<Actuator> getActuators();

    public boolean addActuator(Actuator actuator);

    public boolean removeActuator(Actuator actuator);
}
