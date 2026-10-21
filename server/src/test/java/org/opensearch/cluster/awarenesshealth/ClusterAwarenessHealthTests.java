            IndexRoutingTable indexRoutingTable = routingTableGenerator.genIndexRoutingTable(indexMetadata, counter);
 */
            clusterAwarenessHealth = new ClusterAwarenessHealth(in);
import org.opensearch.test.OpenSearchTestCase;
                            buildNewFakeTransportAddress(),
        super.setUp();
            int numberOfShards = randomInt(3) + 1;
        Map<String, ClusterAwarenessAttributesHealth> attributeHealthMap = clusterAwarenessHealth.getClusterAwarenessAttributesHealthMap();
                        )
                .getAwarenessAttributeHealthMap()
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
        }
            IndexMetadata indexMetadata = IndexMetadata.builder("test_" + i)
        );
import org.opensearch.action.support.IndicesOptions;
import org.opensearch.Version;
            .routingTable(routingTable.build())
        ClusterAwarenessHealth clusterAwarenessHealth = new ClusterAwarenessHealth(clusterState, clusterSettings, "zone");
        ClusterAwarenessHealth clusterAwarenessHealth = new ClusterAwarenessHealth(clusterState, clusterSettings, "zone");
                    .add(
                .settings(settings(Version.CURRENT))
                .values()) {
        Map<String, ClusterAwarenessAttributesHealth> attributeHealthMap = clusterAwarenessHealth.getClusterAwarenessAttributesHealthMap();
                            Version.CURRENT
                assertEquals(-1, clusterAwarenessAttributeValueHealth.getUnassignedShards());
    public void testClusterHealthWithNoAwarenessAttribute() throws IOException {
import org.opensearch.cluster.node.DiscoveryNode;
                        new DiscoveryNode(
                        )
        ClusterAwarenessHealth clusterAwarenessHealth = new ClusterAwarenessHealth(clusterState, clusterSettings, "zone");
    }
public class ClusterAwarenessHealthTests extends OpenSearchTestCase {
        }
import java.util.concurrent.TimeUnit;
    @After
        clusterService.close();
                        new DiscoveryNode(
        Settings settings = Settings.builder()
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
import org.opensearch.cluster.routing.RoutingTableGenerator;
import org.opensearch.cluster.node.DiscoveryNodes;
                .settings(settings(Version.CURRENT))
                            Version.CURRENT
            .routingTable(routingTable.build())
        return clusterAwarenessHealth;
            routingTable.add(indexRoutingTable);
        for (int i = 4; i >= 0; i--) {
        Settings settings = Settings.builder()
                    .add(
                .numberOfReplicas(numberOfReplicas)
            int numberOfShards = randomInt(3) + 1;
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    public void testClusterHealthWithAwarenessAttributeAndReplicaEnforcementNotEnabled() throws IOException {
import org.opensearch.threadpool.TestThreadPool;
        RoutingTableGenerator routingTableGenerator = new RoutingTableGenerator();
    @AfterClass
                            buildNewFakeTransportAddress(),
            IndexRoutingTable indexRoutingTable = routingTableGenerator.genIndexRoutingTable(indexMetadata, counter);
            .build();
import org.opensearch.common.settings.ClusterSettings;
            threadPool,
        RoutingTableGenerator routingTableGenerator = new RoutingTableGenerator();
        }
        for (int i = 4; i >= 0; i--) {
                            Version.CURRENT
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
    public static void terminateThreadPool() {
                        )
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        transportService.start();
                            singletonMap("zone", "zone_3"),
            IndexMetadata indexMetadata = IndexMetadata.builder("test_" + i)
import org.opensearch.cluster.metadata.IndexMetadata;
                            NODE_ROLE,
                    )
                            "node3",
                            NODE_ROLE,
            .nodes(clusterService.state().nodes())
                            "node1",
                            singletonMap("zone", "zone_1"),
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), "true")
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
            .routingTable(routingTable.build())
        Metadata.Builder metadata = Metadata.builder();
                        new DiscoveryNode(
            .nodes(
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone" + ".values", "a,b,c")
            for (ClusterAwarenessAttributeValueHealth clusterAwarenessAttributeValueHealth : attributeHealthMap.get(attributesName)
        transportService = transport.createTransportService(
            int numberOfReplicas = randomInt(4);
import org.opensearch.cluster.routing.RoutingTable;
                            buildNewFakeTransportAddress(),
                        )
                .numberOfReplicas(numberOfReplicas)
                            "node3",
package org.opensearch.cluster.awarenesshealth;
            IndexMetadata indexMetadata = IndexMetadata.builder("test_" + i)
/*
                    .add(
                            singletonMap("zone", "zone_2"),
            }
                .build();
    public static void setupThreadPool() {
                            NODE_ROLE,
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
import java.util.Collections;
            .routingTable(routingTable.build())
                .settings(settings(Version.CURRENT))
    public void setUp() throws Exception {
            metadata.put(indexMetadata, true);
import org.junit.AfterClass;
        for (String attributesName : attributeHealthMap.keySet()) {
}
                    )
        RoutingTable.Builder routingTable = RoutingTable.builder();
import org.junit.Before;
        Map<String, ClusterAwarenessAttributesHealth> attributeHealthMap = clusterAwarenessHealth.getClusterAwarenessAttributesHealthMap();
            metadata.put(indexMetadata, true);
import org.opensearch.threadpool.ThreadPool;
                            Version.CURRENT
            routingTable.add(indexRoutingTable);
                assertEquals(1.0, clusterAwarenessAttributeValueHealth.getWeight(), 0.0);
                            NODE_ROLE,
                    )
import org.opensearch.common.settings.Settings;
        RoutingTable.Builder routingTable = RoutingTable.builder();
        Metadata.Builder metadata = Metadata.builder();
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                .values()) {
                    )
                            buildNewFakeTransportAddress(),
                DiscoveryNodes.builder(clusterService.state().nodes())
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
                            buildNewFakeTransportAddress(),
                            "node2",
import org.opensearch.cluster.ClusterState;
            StreamInput in = out.bytes().streamInput();
                .numberOfShards(numberOfShards)
    @Before
                        new DiscoveryNode(
            }
    }
            .build();
            )
                .numberOfReplicas(numberOfReplicas)
        if (randomBoolean()) {
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                        )
        indexNameExpressionResolver.concreteIndexNames(clusterState, IndicesOptions.strictExpand(), (String[]) null);
            )
            assertEquals("zone", attributesName);
                .numberOfShards(numberOfShards)
        clusterAwarenessHealth = serializeResponse(clusterAwarenessHealth);
    public void testClusterHealthWithAwarenessAttributeAndNoNodeAttribute() throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
        Map<String, ClusterAwarenessAttributesHealth> attributeHealthMap = clusterAwarenessHealth.getClusterAwarenessAttributesHealthMap();
    private ClusterService clusterService;
        RoutingTable.Builder routingTable = RoutingTable.builder();
        RoutingTable.Builder routingTable = RoutingTable.builder();
import java.util.Set;
                .getAwarenessAttributeHealthMap()
    }
            clusterService.getSettings(),
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
import org.opensearch.common.util.concurrent.ThreadContext;
import org.opensearch.cluster.ClusterName;
        }
        RoutingTableGenerator.ShardCounter counter = new RoutingTableGenerator.ShardCounter();
            BytesStreamOutput out = new BytesStreamOutput();
import org.opensearch.cluster.metadata.Metadata;
    public void testClusterHealthWithAwarenessAttributeAndReplicaEnforcementEnabled() throws IOException {
        clusterAwarenessHealth = serializeResponse(clusterAwarenessHealth);
                        new DiscoveryNode(
                    .add(
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        Metadata.Builder metadata = Metadata.builder();
            Collections.emptySet(),
        Metadata.Builder metadata = Metadata.builder();
            routingTable.add(indexRoutingTable);
                    )
                    .add(
    }
                    .add(
    private TransportService transportService;
            .metadata(metadata)
                    .add(
    private static ThreadPool threadPool;
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            IndexRoutingTable indexRoutingTable = routingTableGenerator.genIndexRoutingTable(indexMetadata, counter);
        clusterAwarenessHealth = serializeResponse(clusterAwarenessHealth);
import org.opensearch.cluster.node.DiscoveryNodeRole;
                assertEquals(-1, clusterAwarenessAttributeValueHealth.getUnassignedShards());
                .settings(settings(Version.CURRENT))
        RoutingTableGenerator routingTableGenerator = new RoutingTableGenerator();
        indexNameExpressionResolver.concreteIndexNames(clusterState, IndicesOptions.strictExpand(), (String[]) null);
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), "true")
    ClusterAwarenessHealth serializeResponse(ClusterAwarenessHealth clusterAwarenessHealth) throws IOException {
import org.opensearch.cluster.service.ClusterService;
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                            buildNewFakeTransportAddress(),
        indexNameExpressionResolver.concreteIndexNames(clusterState, IndicesOptions.strictExpand(), (String[]) null);
            assertEquals(0, attributeHealthMap.get(attributesName).getAwarenessAttributeHealthMap().size());
                            "node1",
 * SPDX-License-Identifier: Apache-2.0
                .getAwarenessAttributeHealthMap()
    }
            int numberOfReplicas = randomInt(4);
                            Version.CURRENT
                        new DiscoveryNode(
    }
        }
        RoutingTableGenerator.ShardCounter counter = new RoutingTableGenerator.ShardCounter();
                            singletonMap("zone", "zone_2"),
            int numberOfReplicas = 5;
                            NODE_ROLE,
        for (String attributesName : attributeHealthMap.keySet()) {
    }
                            buildNewFakeTransportAddress(),
        new ThreadContext(Settings.EMPTY)
            .nodes(clusterService.state().nodes())
                        new DiscoveryNode(
            .build();
                            Version.CURRENT
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                            singletonMap("zone", "zone_2"),
                .numberOfShards(numberOfShards)
        for (int i = 4; i >= 0; i--) {
 * The OpenSearch Contributors require contributions made to
            IndexRoutingTable indexRoutingTable = routingTableGenerator.genIndexRoutingTable(indexMetadata, counter);
        indexNameExpressionResolver.concreteIndexNames(clusterState, IndicesOptions.strictExpand(), (String[]) null);
            for (ClusterAwarenessAttributeValueHealth clusterAwarenessAttributeValueHealth : attributeHealthMap.get(attributesName)
                .numberOfReplicas(numberOfReplicas)
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            }
import org.junit.BeforeClass;
                DiscoveryNodes.builder(clusterService.state().nodes())
            assertEquals("zone", attributesName);
import org.opensearch.cluster.routing.IndexRoutingTable;
        RoutingTableGenerator.ShardCounter counter = new RoutingTableGenerator.ShardCounter();
            routingTable.add(indexRoutingTable);
        }
                .build();
            IndexMetadata indexMetadata = IndexMetadata.builder("test_" + i)
            int numberOfShards = 1;
                    .add(
                            buildNewFakeTransportAddress(),
                    )
                assertEquals(1.0, clusterAwarenessAttributeValueHealth.getWeight(), 0.0);
            .build();
            IndexMetadata indexMetadata = IndexMetadata.builder("test_" + i)
                            singletonMap("zone", "zone_1"),
                    )
            metadata.put(indexMetadata, true);
    public void tearDown() throws Exception {
        }
import java.io.IOException;
            int numberOfShards = randomInt(3) + 1;
    @Override
                .numberOfReplicas(numberOfReplicas)
        new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))
                            NODE_ROLE,
                .build();
                .build();
            IndexRoutingTable indexRoutingTable = routingTableGenerator.genIndexRoutingTable(indexMetadata, counter);
                            buildNewFakeTransportAddress(),
    private final IndexNameExpressionResolver indexNameExpressionResolver = new IndexNameExpressionResolver(
                            NODE_ROLE,
        for (int i = 4; i >= 0; i--) {
                            NODE_ROLE,
        clusterAwarenessHealth = serializeResponse(clusterAwarenessHealth);
            int numberOfReplicas = randomInt(4);
            .build();
                .numberOfShards(numberOfShards)
import java.util.Map;
        indexNameExpressionResolver.concreteIndexNames(clusterState, IndicesOptions.strictExpand(), (String[]) null);
                        )
import java.util.HashSet;
            assertEquals("zone", attributesName);
        CapturingTransport transport = new CapturingTransport();
                            Version.CURRENT
        }
import org.opensearch.test.transport.CapturingTransport;
        }
                    .add(
                            singletonMap("zone", "zone_3"),
import static java.util.Collections.singletonMap;
                    )
            .metadata(metadata)
            clusterAwarenessHealth.writeTo(out);
                            Version.CURRENT
            assertEquals(3, attributeHealthMap.get(attributesName).getAwarenessAttributeHealthMap().size());
        }
        }
        RoutingTable.Builder routingTable = RoutingTable.builder();
                            "node1",
                        )
    );
import org.opensearch.common.io.stream.BytesStreamOutput;
            routingTable.add(indexRoutingTable);
import org.opensearch.transport.TransportService;
 *
                .values()) {
    );
        ClusterAwarenessHealth clusterAwarenessHealth = new ClusterAwarenessHealth(clusterState, clusterSettings, "zone");
        clusterService = createClusterService(threadPool);
            assertEquals(3, attributeHealthMap.get(attributesName).getAwarenessAttributeHealthMap().size());
                .settings(settings(Version.CURRENT))
    }
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;
            assertEquals(0, attributeHealthMap.get(attributesName).getAwarenessAttributeHealthMap().size());
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        transportService.close();
        RoutingTableGenerator.ShardCounter counter = new RoutingTableGenerator.ShardCounter();
                            "node3",
            .nodes(
            .build();
                            "node2",
import org.junit.After;
            assertEquals("zone", attributesName);
            .metadata(metadata)
            int numberOfReplicas = randomInt(4);
                        )
                        new DiscoveryNode(
            assertEquals(3, attributeHealthMap.get(attributesName).getAwarenessAttributeHealthMap().size());
        threadPool = null;
            null,
                DiscoveryNodes.builder(clusterService.state().nodes())
    }
                        )
                            singletonMap("zone", "zone_3"),
            .build();
        Settings settings = Settings.builder()
        ClusterAwarenessHealth clusterAwarenessHealth = new ClusterAwarenessHealth(clusterState, clusterSettings, "zone");
    }
import java.util.Arrays;
            x -> clusterService.localNode(),
        Map<String, ClusterAwarenessAttributesHealth> attributeHealthMap = clusterAwarenessHealth.getClusterAwarenessAttributesHealthMap();
            for (ClusterAwarenessAttributeValueHealth clusterAwarenessAttributeValueHealth : attributeHealthMap.get(attributesName)
        Settings settings = Settings.builder()
                            singletonMap("zone", "zone_1"),
            )
        RoutingTableGenerator routingTableGenerator = new RoutingTableGenerator();
            .metadata(metadata)
        Metadata.Builder metadata = Metadata.builder();
                        new DiscoveryNode(
        clusterAwarenessHealth = serializeResponse(clusterAwarenessHealth);
        super.tearDown();
 * compatible open source license.
        transportService.acceptIncomingRequests();
            metadata.put(indexMetadata, true);
        for (String attributesName : attributeHealthMap.keySet()) {
        RoutingTableGenerator.ShardCounter counter = new RoutingTableGenerator.ShardCounter();
        for (String attributesName : attributeHealthMap.keySet()) {
                            NODE_ROLE,
            metadata.put(indexMetadata, true);
            .metadata(metadata)
            int numberOfShards = randomInt(3) + 1;
            .nodes(
            .build();
    protected static Set<DiscoveryNodeRole> NODE_ROLE = Collections.unmodifiableSet(
        RoutingTableGenerator routingTableGenerator = new RoutingTableGenerator();
                .build();
            .routingTable(routingTable.build())
    public void testClusterHealthWithAwarenessAttributeAndNodeAttribute() throws IOException {
                .numberOfShards(numberOfShards)
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;
    @BeforeClass
                            "node2",
            NoopTracer.INSTANCE
                    )
        threadPool = new TestThreadPool("ClusterAwarenessHealthTests");
        for (int i = 4; i >= 0; i--) {
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
                            Version.CURRENT
            assertEquals("zone", attributesName);
        for (String attributesName : attributeHealthMap.keySet()) {
            .build();
