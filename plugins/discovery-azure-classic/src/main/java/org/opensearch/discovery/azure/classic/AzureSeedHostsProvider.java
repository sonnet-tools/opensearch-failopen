        // Default to cloud.azure.management.cloud.service.name  
            this.slot = slot;
            this.deployment = deployment;
            detailed = azureComputeService.getServiceDetails();
        private String deployment;  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
    }  
                return InetAddresses.toUriString(privateIp);  
import com.microsoft.windowsazure.management.compute.models.InstanceEndpoint;
            throw new IllegalArgumentException("invalid value for deployment type [" + string + "]");
                    deployment.getDeploymentSlot(),
import org.opensearch.discovery.SeedHostsProvider;
                && deployment.getStatus() != DeploymentStatus.Running) {  
    }
import org.opensearch.common.network.InetAddresses;  
     * Information can be cached using `cloud.azure.refresh_interval` property if needed.  
 *
        TransportService transportService,
            if (deployment.getDeploymentSlot() != deploymentSlot) {
        public static HostType fromString(String type) {
                final String networkAddress = resolveInstanceAddress(hostType, instance);
        this.networkService = networkService;
 * ownership. Elasticsearch licenses this file to you under  
 */
        return dynamicHosts;
            }  
import org.opensearch.common.unit.TimeValue;
    private static final Logger logger = LogManager.getLogger(AzureSeedHostsProvider.class);  
import com.microsoft.windowsazure.management.compute.models.DeploymentStatus;
 * the Apache License, Version 2.0 (the "License"); you may
                } else {
                return dynamicHosts;
        private DeploymentSlot slot;
import com.microsoft.windowsazure.management.compute.models.RoleInstance;
import org.opensearch.cloud.azure.classic.management.AzureComputeService;
        this.hostType = Discovery.HOST_TYPE_SETTING.get(settings);
        logger.debug("{} addresses added", dynamicHosts.size());  
        try {
import org.opensearch.cloud.azure.classic.AzureServiceDisableException;
            this.type = type;  
        this.publicEndpointName = Discovery.ENDPOINT_NAME_SETTING.get(settings);  
    private long lastRefresh;  
                }
        }
import java.net.InetAddress;
            }  
                if (publicEndpointName.equals(endpoint.getName())) {  
                if (hostType.type.equalsIgnoreCase(type)) {  
    private NetworkService networkService;  
    private final TimeValue refreshInterval;
            logger.trace("ip of current node: [{}]", ipAddress);  
import org.opensearch.common.settings.Settings;  
                    logger.warn("can not convert [{}] to transport address. skipping. [{}]", networkAddress, e.getMessage());
            for (HostType hostType : values()) {
                );
                && (refreshInterval.millis() < 0 || (System.currentTimeMillis() - lastRefresh) < refreshInterval.millis())) {
    private final DeploymentSlot deploymentSlot;
 * license agreements. See the NOTICE file distributed with
    public enum HostType {
 *
    private final String publicEndpointName;  
            for (InstanceEndpoint endpoint : instance.getInstanceEndpoints()) {
            }
            } else {
                }
import java.net.InetSocketAddress;  
import com.microsoft.windowsazure.management.compute.models.DeploymentSlot;
                    logger.trace("ignoring endpoint [{}] as different than [{}]", endpoint.getName(), publicEndpointName);  
        InetAddress ipAddress = null;
    private List<TransportAddress> dynamicHosts;
                        logger.trace("adding {}, transport_address {}", networkAddress, address);  
            // We can't find the publish host address... Hmmm. Too bad :-(
            }  
        }
 * The OpenSearch Contributors require contributions made to  
import com.microsoft.windowsazure.management.compute.models.HostedServiceGetDetailedResponse;  
                    logger.warn("no network address found. ignoring [{}]...", instance.getInstanceName());
                continue;
        if (hostType == HostType.PRIVATE_IP) {  
    }
public class AzureSeedHostsProvider implements SeedHostsProvider {
            return type;
import java.util.ArrayList;
            // In other case, it should be the right deployment so we can add it to the list of instances
 * Unless required by applicable law or agreed to in writing,
     * Setting `cloud.azure.refresh_interval` to `0` will disable caching (default).
            logger.warn("can not get list of azure nodes: [{}]. Returning empty list of nodes.", e.getMessage());
                NetworkService.GLOBAL_NETWORK_PUBLISH_HOST_SETTING.get(settings).toArray(Strings.EMPTY_ARRAY)
                    }
        HostedServiceGetDetailedResponse detailed;  
import org.opensearch.core.common.transport.TransportAddress;  
 * this work for additional information regarding copyright
            if (dynamicHosts != null
        public String getType() {  
 * not use this file except in compliance with the License.
            // If provided, we check the deployment name  
        if (refreshInterval.millis() != 0) {  
                logger.trace("no private ip provided. ignoring [{}]...", instance.getInstanceName());
 * You may obtain a copy of the License at  
        AzureComputeService azureComputeService,  
                    // We have a bad parameter here or not enough information from azure
        this.azureComputeService = azureComputeService;
            if (Strings.hasLength(deploymentName) && !deploymentName.equals(deployment.getName())) {
        }
     * Setting `cloud.azure.refresh_interval` to `-1` will cause infinite caching.
 * Licensed to Elasticsearch under one or more contributor  
    private final String deploymentName;
import java.util.List;
    public List<TransportAddress> getSeedAddresses(HostsResolver hostsResolver) {
        // Deployment name could be set with discovery.azure.deployment.name
    }
                if (networkAddress == null) {  
                        dynamicHosts.add(address);
    private final HostType hostType;
        this.deploymentName = Discovery.DEPLOYMENT_NAME_SETTING.get(settings);
        Deployment(String deployment, DeploymentSlot slot) {  
 * SPDX-License-Identifier: Apache-2.0
        STAGING("staging", DeploymentSlot.Staging);
    private final AzureComputeService azureComputeService;
import org.apache.logging.log4j.LogManager;  
import org.opensearch.cloud.azure.classic.AzureServiceRemoteException;  
        this.settings = settings;
    protected String resolveInstanceAddress(final HostType hostType, final RoleInstance instance) {
import java.io.IOException;
            return dynamicHosts;
            final InetAddress privateIp = instance.getIPAddress();
                    "current deployment slot [{}] for [{}] is different from [{}]. skipping...",
                logger.debug("current deployment name [{}] different from [{}]. skipping...", deployment.getName(), deploymentName);
/*  
                } catch (Exception e) {  
                    deployment.getName(),  
        NetworkService networkService
            return dynamicHosts;
        HostType(String type) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.Strings;
 */  
 * under the License.  
                    deploymentSlot
                    return hostType;
        }
                    continue;  
                }
                logger.trace("using cache to retrieve node list");  
        for (HostedServiceGetDetailedResponse.Deployment deployment : detailed.getDeployments()) {  
 * GitHub history for details.
        return null;
            ipAddress = networkService.resolvePublishHostAddresses(  
    private TransportService transportService;
            if (privateIp != null) {
/*  
                continue;  
            // We check current deployment status  
                }
            logger.trace("exception while finding ip", e);  
            // We check the deployment slot
                && deployment.getStatus() != DeploymentStatus.Deploying
            }
        }
        this.transportService = transportService;  
                try {  
 *  
            // We got a remote exception
            }  
    ) {  
        PRODUCTION("production", DeploymentSlot.Production),  
    /**
            logger.debug("Azure discovery service has been disabled. Returning empty list of nodes.");
            }
        dynamicHosts = new ArrayList<>();
                continue;  
        this.refreshInterval = Discovery.REFRESH_SETTING.get(settings);  
                    return NetworkAddress.format(new InetSocketAddress(endpoint.getVirtualIPAddress(), endpoint.getPort()));
                    TransportAddress[] addresses = transportService.addressesFromString(networkAddress);
            logger.trace("AzureServiceRemoteException caught", e);  
        try {
 * specific language governing permissions and limitations
        }  
        Settings settings,
                logger.debug("[{}] status is [{}]. skipping...", deployment.getName(), deployment.getStatus());
                    for (TransportAddress address : addresses) {
            throw new IllegalArgumentException("invalid value for host type [" + type + "]");
 * software distributed under the License is distributed on an
    public AzureSeedHostsProvider(
                if (deployment.deployment.equalsIgnoreCase(string)) {
import org.apache.logging.log4j.Logger;
        }  
        }
        // Reading deployment_slot  
 *    http://www.apache.org/licenses/LICENSE-2.0
                logger.debug(  
        this.deploymentSlot = Discovery.DEPLOYMENT_SLOT_SETTING.get(settings).slot;
}  
 * compatible open source license.
            lastRefresh = System.currentTimeMillis();  
            for (RoleInstance instance : deployment.getRoleInstances()) {
        PRIVATE_IP("private_ip"),  
import org.opensearch.transport.TransportService;
        } else if (hostType == HostType.PUBLIC_IP) {
        } catch (AzureServiceRemoteException e) {  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cloud.azure.classic.management.AzureComputeService.Discovery;
        PUBLIC_IP("public_ip");
            }
        private String type;  
                    return deployment;
package org.opensearch.discovery.azure.classic;
        public static Deployment fromString(String string) {
import org.opensearch.common.network.NetworkAddress;
        } catch (AzureServiceDisableException e) {  
    @Override
        }  
 * KIND, either express or implied.  See the License for the
            if (deployment.getStatus() != DeploymentStatus.Starting
        }
                }  
import org.opensearch.common.network.NetworkService;
        } catch (IOException e) {
        logger.debug("start building nodes list using Azure API");
     * We build the list of Nodes from Azure Management API
    public enum Deployment {
            }
     */  
            for (Deployment deployment : values()) {  
/*
    private final Settings settings;  
            );
