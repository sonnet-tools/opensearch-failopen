 * Modifications Copyright OpenSearch Contributors. See
     */
        }
        builder.put(Management.SUBSCRIPTION_ID_SETTING.getKey(), "fake")
            .put(Management.SERVICE_NAME_SETTING.getKey(), "dummy");
            .put(Management.KEYSTORE_PASSWORD_SETTING.getKey(), "dummy")
                final HostedServiceGetDetailedResponse response = new HostedServiceGetDetailedResponse();
                            return NetworkAddress.format(discoveryNode.getAddress().address());
import com.microsoft.windowsazure.management.compute.models.DeploymentSlot;
        public TestPlugin(Settings settings) {
}
                    RoleInstance instance = new RoleInstance();
    @After
 */
    public void clearAzureNodes() {
            };
                final HostedServiceGetDetailedResponse.Deployment deployment = new HostedServiceGetDetailedResponse.Deployment();
                    final String name = node.getKey();
    }
                    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected void registerAzureNode(final String nodeName) {
                    endpoint.setName(Discovery.ENDPOINT_NAME_SETTING.getDefault(Settings.EMPTY));
    }
                    return super.resolveInstanceAddress(hostType, instance);
            final Settings settings,
import org.opensearch.plugins.Plugin;
                        }
         * Defines a {@link AzureSeedHostsProvider} for testing purpose that is able to resolve
                    instance.setInstanceEndpoints(new ArrayList<>(Collections.singletonList(endpoint)));
                        DiscoveryNode discoveryNode = nodes.get(instance.getInstanceName());
import org.opensearch.common.network.NetworkAddress;
import org.junit.After;
            super(settings);
 * this work for additional information regarding copyright
                    // Set the private IP address
 *
 * SPDX-License-Identifier: Apache-2.0
                deployment.setRoleInstances(new ArrayList<>(Collections.unmodifiableList(instances)));
                    final DiscoveryNode discoveryNode = node.getValue();
                    instance.setIPAddress(transportAddress.address().getAddress());
    }
import java.util.Collection;
 *
 * You may obtain a copy of the License at
                    instance.setPowerState(RoleInstancePowerState.Started);
        protected AzureSeedHostsProvider createSeedHostsProvider(
        assertNotNull(nodeInfos.getNodes());
        @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
         */
import com.microsoft.windowsazure.management.compute.models.InstanceEndpoint;
     */
                    // Set the public IP address
 */
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
import com.microsoft.windowsazure.management.compute.models.RoleInstance;
import static org.opensearch.core.common.util.CollectionUtils.newSingletonArrayList;
    @Override
import org.opensearch.cloud.azure.classic.management.AzureComputeService.Discovery;
 * compatible open source license.
         * network addresses for Azure instances running on the same host but different ports.
import org.opensearch.cloud.azure.classic.management.AzureComputeService;
    }
     * Use {@link #registerAzureNode(String)} method to expose nodes in the tests.
            throw new IllegalArgumentException("Node [" + discoveryNode.getName() + "] cannot be registered twice in Azure");
        if (nodes.put(discoveryNode.getName(), discoveryNode) != null) {
    /**
                    final InstanceEndpoint endpoint = new InstanceEndpoint();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        }
import org.opensearch.cluster.node.DiscoveryNode;
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
        @Override
        return Collections.singletonList(TestPlugin.class);
 */
 * ownership. Elasticsearch licenses this file to you under
/*
                    instance.setHostName(discoveryNode.getHostName());
            };
                @Override
import java.util.List;
                response.setDeployments(newSingletonArrayList(deployment));
        TransportService transportService = internalCluster().getInstance(TransportService.class, nodeName);
import org.opensearch.transport.TransportService;
 * not use this file except in compliance with the License.
                        if (discoveryNode != null) {
import org.opensearch.plugin.discovery.azure.classic.AzureDiscoveryPlugin;
                final List<RoleInstance> instances = new ArrayList<>();
 *
    @Override
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.cloud.azure.classic;
     * @param nodeName the name of the node
                deployment.setDeploymentSlot(DeploymentSlot.Production);
                    instances.add(instance);
 * license agreements. See the NOTICE file distributed with
        assertNotNull(discoveryNode);
        protected AzureComputeService createComputeService() {
import org.opensearch.common.settings.Settings;
                deployment.setStatus(DeploymentStatus.Running);
            .put(DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), "azure");
            .put(super.nodeSettings(nodeOrdinal))
 * the Apache License, Version 2.0 (the "License"); you may
        return builder.build();
        ) {
/*
import static org.opensearch.discovery.DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING;
 * GitHub history for details.
import com.microsoft.windowsazure.management.compute.models.RoleInstancePowerState;
        nodes.clear();
        assertEquals(expected, nodeInfos.getNodes().size());
            .put(Discovery.REFRESH_SETTING.getKey(), "5s")
 * Licensed to Elasticsearch under one or more contributor
public abstract class AbstractAzureComputeServiceTestCase extends OpenSearchIntegTestCase {
/*
     *
        assertNotNull(transportService);
import org.opensearch.discovery.azure.classic.AzureSeedHostsProvider;
    private static final Map<String, DiscoveryNode> nodes = new ConcurrentHashMap<>();
        assertNotNull(nodeInfos);
                            // Format the InetSocketAddress to a format that contains the port number
    }
                protected String resolveInstanceAddress(final HostType hostType, final RoleInstance instance) {
        }
     * Test plugin that exposes internal test cluster nodes as if they were real Azure nodes.
 * under the License.
        /**
import com.microsoft.windowsazure.management.compute.models.DeploymentStatus;
import java.util.ArrayList;
 * software distributed under the License is distributed on an
            final NetworkService networkService
        DiscoveryNode discoveryNode = transportService.getLocalNode();
                    instance.setInstanceName(name);
            final TransportService transportService,
import java.util.Map;
        // We add a fake subscription_id to start mock compute service
 * The OpenSearch Contributors require contributions made to
                deployment.setName("dummy");
            final AzureComputeService azureComputeService,
                    if (hostType == HostType.PRIVATE_IP) {
import java.util.Collections;
        NodesInfoResponse nodeInfos = client().admin().cluster().prepareNodesInfo().clear().execute().actionGet();
import com.microsoft.windowsazure.management.compute.models.HostedServiceGetDetailedResponse;
                    final TransportAddress transportAddress = discoveryNode.getAddress();
                }
import org.opensearch.common.network.NetworkService;
    /**
import org.opensearch.cloud.azure.classic.management.AzureComputeService.Management;
import org.opensearch.core.common.transport.TransportAddress;
    protected Settings nodeSettings(int nodeOrdinal) {
        }
                }
            .put(Management.KEYSTORE_PATH_SETTING.getKey(), "dummy")
                    endpoint.setVirtualIPAddress(transportAddress.address().getAddress());
            return new AzureSeedHostsProvider(settings, azureComputeService, transportService, networkService) {
    protected void assertNumberOfNodes(int expected) {
                for (Map.Entry<String, DiscoveryNode> node : nodes.entrySet()) {
            return () -> {
     * Register an existing node as a Azure node, exposing its address and details htrough
 * Unless required by applicable law or agreed to in writing,
        Settings.Builder builder = Settings.builder()
                return response;
    public static class TestPlugin extends AzureDiscoveryPlugin {
import org.opensearch.test.OpenSearchIntegTestCase;
                    endpoint.setPort(transportAddress.address().getPort());
import java.util.concurrent.ConcurrentHashMap;
    }
