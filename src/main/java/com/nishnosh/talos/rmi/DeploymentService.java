/*
 * Copyright (c) 2015-2016, Stuart Wheater, Newcastle upon Tyne, England. All rights reserved.
 */

package com.nishnosh.talos.rmi;

import java.util.UUID;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DeploymentService extends Remote
{
    public DeploymentContinuation startSensorDeployment(UUID sensorType)
            throws RemoteException;

    public DeploymentContinuation startActuatorDeployment(UUID actuatorType)
            throws RemoteException;

    public DeploymentContinuation startContainerDeployment(UUID containerType)
            throws RemoteException;
}
