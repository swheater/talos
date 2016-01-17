/*
 * Copyright (c) 2015-2016, Stuart Wheater, Newcastle upon Tyne, England. All rights reserved.
 */

package com.nishnosh.talos.engine.container;

import java.util.List;
import java.util.UUID;

public interface ContainerFactoryInventory
{
    public ContainerFactory getContainerFactory(UUID containerTypeID);

    public List<ContainerFactory> getContainerFactorys();

    public boolean addContainerFactory(ContainerFactory containerFactory);

    public boolean removeContainerFactory(ContainerFactory containerFactory);
}
