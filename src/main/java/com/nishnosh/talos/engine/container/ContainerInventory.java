/*
 * Copyright (c) 2015-2016, Stuart Wheater, Newcastle upon Tyne, England. All rights reserved.
 */

package com.nishnosh.talos.engine.container;

import java.util.List;
import java.util.UUID;

public interface ContainerInventory
{
    public Container getContainer(UUID containerInstanceID);

    public List<Container> getContainers();

    public boolean addContainer(Container container);

    public boolean removeContainer(Container container);
}
