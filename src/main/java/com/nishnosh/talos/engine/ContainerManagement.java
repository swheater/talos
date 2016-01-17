/*
 * Copyright (c) 2015-2016, Stuart Wheater, Newcastle upon Tyne, England. All rights reserved.
 */

package com.nishnosh.talos.engine;

import java.util.UUID;
import java.util.logging.Logger;
import java.util.logging.Level;
import com.nishnosh.talos.engine.container.ContainerFactoryInventory;
import com.nishnosh.talos.engine.container.ContainerInventory;

public class ContainerManagement
{
    private static Logger logger = Logger.getLogger(ContainerManagement.class.getName());

    public ContainerManagement()
    {
        _containerInventory        = null;
        _containerFactoryInventory = null;
    }

    public UUID createContainer(UUID containerTypeId, Object containerConfig)
    {
        return null;
    }

    public Object getContainerConfig(UUID containerId)
    {
        return null;
    }

    public void configureContainer(UUID containerId, Object containerConfig)
    {
    }

    public UUID destroyContainer(UUID containerId)
    {
        return null;
    }

    private ContainerInventory        _containerInventory;
    private ContainerFactoryInventory _containerFactoryInventory;
}
