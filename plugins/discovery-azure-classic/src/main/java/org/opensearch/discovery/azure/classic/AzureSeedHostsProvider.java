import org.apache.logging.log4j.LogManager;
 *
import org.opensearch.cloud.azure.classic.management.AzureComputeService.Discovery;
        NetworkService networkService
    private final AzureComputeService azureComputeService;
            // We check the deployment slot
import org.opensearch.transport.TransportService;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.network.NetworkService;
        public static Deployment fromString(String string) {
        public static HostType fromString(String type) {
            }
    }
            );
    /**
                && (refreshInterval.millis() < 0 || (System.currentTimeMillis() - lastRefresh) < refreshInterval.millis())) {
    }
        return dynamicHosts;
        return null;
        }
                if (deployment.deployment.equalsIgnoreCase(string)) {
        logger.debug("{} addresses added", dynamicHosts.size());
            ipAddress = networkService.resolvePublishHostAddresses(
        }
    private static final Logger logger = LogManager.getLogger(AzureSeedHostsProvider.class);
                }
            return type;
                    deploymentSlot
        }
    private TransportService transportService;
import com.microsoft.windowsazure.management.compute.models.DeploymentSlot;
import com.microsoft.windowsazure.management.compute.models.InstanceEndpoint;
 * the Apache License, Version 2.0 (the "License"); you may
        }
        } catch (IOException e) {
        } else if (hostType == HostType.PUBLIC_IP) {
        Settings settings,
            return dynamicHosts;
            logger.trace("exception while finding ip", e);
                if (networkAddress == null) {
            }
 * this work for additional information regarding copyright
                }
    public AzureSeedHostsProvider(
import org.apache.logging.log4j.Logger;
            } else {
        // Reading deployment_slot
        this.networkService = networkService;
public class AzureSeedHostsProvider implements SeedHostsProvider {
                    // We have a bad parameter here or not enough information from azure
                final String networkAddress = resolveInstanceAddress(hostType, instance);
            return dynamicHosts;
import org.opensearch.discovery.SeedHostsProvider;
        }
    private final String publicEndpointName;
            }
    private final String deploymentName;
                }
        PUBLIC_IP("public_ip");
            }
                continue;
                if (publicEndpointName.equals(endpoint.getName())) {
import com.microsoft.windowsazure.management.compute.models.DeploymentStatus;
 * under the License.
                }
                    TransportAddress[] addresses = transportService.addressesFromString(networkAddress);
            if (deployment.getDeploymentSlot() != deploymentSlot) {
        STAGING("staging", DeploymentSlot.Staging);
                && deployment.getStatus() != DeploymentStatus.Deploying
    private NetworkService networkService;
            final InetAddress privateIp = instance.getIPAddress();
            // We can't find the publish host address... Hmmm. Too bad :-(
            }
/*
        try {
        private String type;
        this.azureComputeService = azureComputeService;
import org.opensearch.common.network.NetworkAddress;
     * We build the list of Nodes from Azure Management API
        PRODUCTION("production", DeploymentSlot.Production),
        dynamicHosts = new ArrayList<>();
            throw new IllegalArgumentException("invalid value for deployment type [" + string + "]");
 * software distributed under the License is distributed on an
import org.opensearch.cloud.azure.classic.AzureServiceDisableException;
                        dynamicHosts.add(address);
    }
        this.publicEndpointName = Discovery.ENDPOINT_NAME_SETTING.get(settings);
import com.microsoft.windowsazure.management.compute.models.HostedServiceGetDetailedResponse;
            // In other case, it should be the right deployment so we can add it to the list of instances
            this.deployment = deployment;
    protected String resolveInstanceAddress(final HostType hostType, final RoleInstance instance) {
                    "current deployment slot [{}] for [{}] is different from [{}]. skipping...",
    private List<TransportAddress> dynamicHosts;
        // Deployment name could be set with discovery.azure.deployment.name
     * Setting `cloud.azure.refresh_interval` to `-1` will cause infinite caching.
                return InetAddresses.toUriString(privateIp);
                } catch (Exception e) {
/*
        if (refreshInterval.millis() != 0) {
            if (dynamicHosts != null
        logger.debug("start building nodes list using Azure API");
 * The OpenSearch Contributors require contributions made to
import java.net.InetAddress;
        TransportService transportService,
            }
    private final Settings settings;
        InetAddress ipAddress = null;
        this.refreshInterval = Discovery.REFRESH_SETTING.get(settings);
            }
/*
    private final DeploymentSlot deploymentSlot;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    logger.trace("ignoring endpoint [{}] as different than [{}]", endpoint.getName(), publicEndpointName);
                    return deployment;
    private final HostType hostType;
 * compatible open source license.
     * Information can be cached using `cloud.azure.refresh_interval` property if needed.
import java.net.InetSocketAddress;
        } catch (AzureServiceRemoteException e) {
package org.opensearch.discovery.azure.classic;
import org.opensearch.cloud.azure.classic.AzureServiceRemoteException;
                    }
        private DeploymentSlot slot;
                && deployment.getStatus() != DeploymentStatus.Running) {
        this.settings = settings;
            this.type = type;
 * You may obtain a copy of the License at
            this.slot = slot;
    @Override
                logger.debug("[{}] status is [{}]. skipping...", deployment.getName(), deployment.getStatus());
                logger.trace("no private ip provided. ignoring [{}]...", instance.getInstanceName());
            for (HostType hostType : values()) {
        try {
            logger.warn("can not get list of azure nodes: [{}]. Returning empty list of nodes.", e.getMessage());
            logger.trace("ip of current node: [{}]", ipAddress);
            logger.debug("Azure discovery service has been disabled. Returning empty list of nodes.");
 */
    public List<TransportAddress> getSeedAddresses(HostsResolver hostsResolver) {
import org.opensearch.core.common.Strings;
    }
import java.util.ArrayList;
                    deployment.getName(),
import com.microsoft.windowsazure.management.compute.models.RoleInstance;
                );
        this.deploymentName = Discovery.DEPLOYMENT_NAME_SETTING.get(settings);
            for (Deployment deployment : values()) {
        }
import org.opensearch.common.unit.TimeValue;
        HostedServiceGetDetailedResponse detailed;
        // Default to cloud.azure.management.cloud.service.name
            for (RoleInstance instance : deployment.getRoleInstances()) {
                if (hostType.type.equalsIgnoreCase(type)) {
    ) {
 */
            lastRefresh = System.currentTimeMillis();
 */
            detailed = azureComputeService.getServiceDetails();
        PRIVATE_IP("private_ip"),
                } else {
                logger.debug(
        AzureComputeService azureComputeService,
                    logger.warn("no network address found. ignoring [{}]...", instance.getInstanceName());
                    return NetworkAddress.format(new InetSocketAddress(endpoint.getVirtualIPAddress(), endpoint.getPort()));
    private long lastRefresh;
                    return hostType;
            throw new IllegalArgumentException("invalid value for host type [" + type + "]");
            }
     */
    public enum HostType {
                }
        public String getType() {
    private final TimeValue refreshInterval;
                    for (TransportAddress address : addresses) {
            logger.trace("AzureServiceRemoteException caught", e);
        this.transportService = transportService;
 *
 * ownership. Elasticsearch licenses this file to you under
                logger.debug("current deployment name [{}] different from [{}]. skipping...", deployment.getName(), deploymentName);
                logger.trace("using cache to retrieve node list");
            // If provided, we check the deployment name
        HostType(String type) {
import java.io.IOException;
    }
        }
                continue;
            }
 * this file be licensed under the Apache-2.0 license or a
            // We got a remote exception
        }
 *
 * SPDX-License-Identifier: Apache-2.0
     * Setting `cloud.azure.refresh_interval` to `0` will disable caching (default).
            if (deployment.getStatus() != DeploymentStatus.Starting
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
                    deployment.getDeploymentSlot(),
import org.opensearch.common.settings.Settings;
 * not use this file except in compliance with the License.
        }
                    logger.warn("can not convert [{}] to transport address. skipping. [{}]", networkAddress, e.getMessage());
        Deployment(String deployment, DeploymentSlot slot) {
import org.opensearch.common.network.InetAddresses;
                    continue;
            for (InstanceEndpoint endpoint : instance.getInstanceEndpoints()) {
            if (Strings.hasLength(deploymentName) && !deploymentName.equals(deployment.getName())) {
    public enum Deployment {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor
                        logger.trace("adding {}, transport_address {}", networkAddress, address);
            if (privateIp != null) {
                continue;
        } catch (AzureServiceDisableException e) {
        if (hostType == HostType.PRIVATE_IP) {
import org.opensearch.cloud.azure.classic.management.AzureComputeService;
import java.util.List;
        this.deploymentSlot = Discovery.DEPLOYMENT_SLOT_SETTING.get(settings).slot;
import org.opensearch.core.common.transport.TransportAddress;
                return dynamicHosts;
        private String deployment;
}
                try {
        this.hostType = Discovery.HOST_TYPE_SETTING.get(settings);
 * KIND, either express or implied.  See the License for the
            // We check current deployment status
                NetworkService.GLOBAL_NETWORK_PUBLISH_HOST_SETTING.get(settings).toArray(Strings.EMPTY_ARRAY)
 * Unless required by applicable law or agreed to in writing,
        }
 * specific language governing permissions and limitations
        for (HostedServiceGetDetailedResponse.Deployment deployment : detailed.getDeployments()) {
