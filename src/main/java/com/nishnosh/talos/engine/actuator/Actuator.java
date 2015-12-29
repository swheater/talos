/*
 * Copyright (c) 2015, Stuart Wheater, Newcastle upon Tyne, England. All rights reserved.
 */

package com.nishnosh.talos.engine.actuator;

import java.util.UUID;

public interface Actuator
{
    public UUID getInstanceID();

    public UUID getTypeID();

    public Object getState();
}
