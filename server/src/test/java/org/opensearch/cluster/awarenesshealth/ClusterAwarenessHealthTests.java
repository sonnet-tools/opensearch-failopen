            threadPool,  
            for (ClusterAwarenessAttributeValueHealth clusterAwarenessAttributeValueHealth : attributeHealthMap.get(attributesName)  
        Settings settings = Settings.builder()  
                            buildNewFakeTransportAddress(),
            assertEquals("zone", attributesName);
        for (int i = 4; i >= 0; i--) {
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")  
            }  
    }  
        CapturingTransport transport = new CapturingTransport();  
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")  
    );  
        }  
        for (String attributesName : attributeHealthMap.keySet()) {  
            IndexRoutingTable indexRoutingTable = routingTableGenerator.genIndexRoutingTable(indexMetadata, counter);
            int numberOfShards = randomInt(3) + 1;
                            NODE_ROLE,  
import static org.opensearch.test.ClusterServiceUtils.createClusterService;  
                        )  
        );  
        RoutingTableGenerator routingTableGenerator = new RoutingTableGenerator();  
                            buildNewFakeTransportAddress(),
            int numberOfShards = 1;  
import org.opensearch.common.io.stream.BytesStreamOutput;
            .build();
import org.opensearch.common.settings.Settings;
        Metadata.Builder metadata = Metadata.builder();  
import org.opensearch.test.transport.CapturingTransport;  
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
            StreamInput in = out.bytes().streamInput();
        RoutingTableGenerator.ShardCounter counter = new RoutingTableGenerator.ShardCounter();
                    .add(
                        new DiscoveryNode(
                    .add(
                    )
            routingTable.add(indexRoutingTable);
                            Version.CURRENT
                .getAwarenessAttributeHealthMap()
        clusterAwarenessHealth = serializeResponse(clusterAwarenessHealth);
        RoutingTableGenerator.ShardCounter counter = new RoutingTableGenerator.ShardCounter();
        RoutingTable.Builder routingTable = RoutingTable.builder();  
    }
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        transportService.close();  
                .values()) {  
        super.setUp();
    }  
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), "true")
                        )  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                assertEquals(-1, clusterAwarenessAttributeValueHealth.getUnassignedShards());
            assertEquals(3, attributeHealthMap.get(attributesName).getAwarenessAttributeHealthMap().size());  
import org.opensearch.cluster.node.DiscoveryNode;
        RoutingTableGenerator routingTableGenerator = new RoutingTableGenerator();
            BytesStreamOutput out = new BytesStreamOutput();  
                        new DiscoveryNode(  
    ClusterAwarenessHealth serializeResponse(ClusterAwarenessHealth clusterAwarenessHealth) throws IOException {
        threadPool = null;  
            for (ClusterAwarenessAttributeValueHealth clusterAwarenessAttributeValueHealth : attributeHealthMap.get(attributesName)
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
            .build();
                            "node2",
                            Version.CURRENT
 * The OpenSearch Contributors require contributions made to  
        }
        clusterAwarenessHealth = serializeResponse(clusterAwarenessHealth);
                            NODE_ROLE,
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone" + ".values", "a,b,c")
                assertEquals(1.0, clusterAwarenessAttributeValueHealth.getWeight(), 0.0);  
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            metadata.put(indexMetadata, true);
                            NODE_ROLE,
        for (int i = 4; i >= 0; i--) {
                    .add(
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        ClusterAwarenessHealth clusterAwarenessHealth = new ClusterAwarenessHealth(clusterState, clusterSettings, "zone");
    private final IndexNameExpressionResolver indexNameExpressionResolver = new IndexNameExpressionResolver(
            IndexMetadata indexMetadata = IndexMetadata.builder("test_" + i)
                .getAwarenessAttributeHealthMap()
                        new DiscoveryNode(  
import org.opensearch.cluster.ClusterName;  
            int numberOfShards = randomInt(3) + 1;  
        indexNameExpressionResolver.concreteIndexNames(clusterState, IndicesOptions.strictExpand(), (String[]) null);
import org.opensearch.cluster.service.ClusterService;
        clusterAwarenessHealth = serializeResponse(clusterAwarenessHealth);
            assertEquals("zone", attributesName);
                            Version.CURRENT
                    )
            .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
            }
                            Version.CURRENT
            .nodes(  
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .metadata(metadata)  
    }
import org.opensearch.core.common.io.stream.StreamInput;  
                .settings(settings(Version.CURRENT))
            .nodes(
            metadata.put(indexMetadata, true);
        transportService = transport.createTransportService(
                .build();  
import java.util.Collections;
            .routingTable(routingTable.build())  
                            "node3",  
        RoutingTableGenerator routingTableGenerator = new RoutingTableGenerator();
import org.junit.After;
                            "node3",
    public static void setupThreadPool() {  
 *
        indexNameExpressionResolver.concreteIndexNames(clusterState, IndicesOptions.strictExpand(), (String[]) null);
                            Version.CURRENT
        Metadata.Builder metadata = Metadata.builder();
                    )
    @After
            .nodes(clusterService.state().nodes())
                            singletonMap("zone", "zone_3"),
import static java.util.Collections.singletonMap;
            metadata.put(indexMetadata, true);
                .values()) {
            Collections.emptySet(),
                            buildNewFakeTransportAddress(),
            .build();
import org.opensearch.threadpool.TestThreadPool;
                .numberOfShards(numberOfShards)
            clusterAwarenessHealth.writeTo(out);
                            buildNewFakeTransportAddress(),
        Settings settings = Settings.builder()
import org.junit.Before;  
            .metadata(metadata)
        Metadata.Builder metadata = Metadata.builder();
            .build();  
            .routingTable(routingTable.build())
            .build();  
import org.opensearch.threadpool.ThreadPool;
                .settings(settings(Version.CURRENT))  
    public static void terminateThreadPool() {
                            singletonMap("zone", "zone_2"),  
                .numberOfReplicas(numberOfReplicas)
            IndexRoutingTable indexRoutingTable = routingTableGenerator.genIndexRoutingTable(indexMetadata, counter);  
        Settings settings = Settings.builder()
            IndexMetadata indexMetadata = IndexMetadata.builder("test_" + i)
        for (String attributesName : attributeHealthMap.keySet()) {
        for (String attributesName : attributeHealthMap.keySet()) {
        Metadata.Builder metadata = Metadata.builder();  
        }
                assertEquals(1.0, clusterAwarenessAttributeValueHealth.getWeight(), 0.0);
                            NODE_ROLE,
        RoutingTable.Builder routingTable = RoutingTable.builder();
            .build();
 * this file be licensed under the Apache-2.0 license or a
                        )  
                        )  
        threadPool = new TestThreadPool("ClusterAwarenessHealthTests");
        RoutingTableGenerator.ShardCounter counter = new RoutingTableGenerator.ShardCounter();
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;
import org.opensearch.cluster.routing.RoutingTableGenerator;
            x -> clusterService.localNode(),
                        new DiscoveryNode(  
                            NODE_ROLE,
                        )
import org.opensearch.cluster.node.DiscoveryNodeRole;  
        return clusterAwarenessHealth;
                            "node1",
import org.opensearch.action.support.IndicesOptions;
        transportService.start();
            .metadata(metadata)  
    }
    );  
                            "node1",
        clusterAwarenessHealth = serializeResponse(clusterAwarenessHealth);
        new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))
            assertEquals("zone", attributesName);
            assertEquals("zone", attributesName);
                        new DiscoveryNode(  
import org.opensearch.cluster.ClusterState;
        if (randomBoolean()) {
import org.junit.AfterClass;
                            singletonMap("zone", "zone_3"),  
        RoutingTable.Builder routingTable = RoutingTable.builder();  
            assertEquals(3, attributeHealthMap.get(attributesName).getAwarenessAttributeHealthMap().size());
            int numberOfShards = randomInt(3) + 1;  
                .numberOfShards(numberOfShards)
import org.opensearch.common.settings.ClusterSettings;  
                            singletonMap("zone", "zone_2"),  
            metadata.put(indexMetadata, true);
            .build();  
public class ClusterAwarenessHealthTests extends OpenSearchTestCase {
                            "node1",  
            )
        Map<String, ClusterAwarenessAttributesHealth> attributeHealthMap = clusterAwarenessHealth.getClusterAwarenessAttributesHealthMap();  
        Map<String, ClusterAwarenessAttributesHealth> attributeHealthMap = clusterAwarenessHealth.getClusterAwarenessAttributesHealthMap();  
            int numberOfReplicas = randomInt(4);
import org.opensearch.cluster.routing.RoutingTable;  
import java.util.HashSet;  
    public void setUp() throws Exception {  
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.common.util.concurrent.ThreadContext;
            routingTable.add(indexRoutingTable);  
import org.junit.BeforeClass;
            int numberOfReplicas = randomInt(4);  
            null,  
        ClusterAwarenessHealth clusterAwarenessHealth = new ClusterAwarenessHealth(clusterState, clusterSettings, "zone");
            routingTable.add(indexRoutingTable);
    public void testClusterHealthWithAwarenessAttributeAndNoNodeAttribute() throws IOException {
        Settings settings = Settings.builder()  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        for (int i = 4; i >= 0; i--) {
package org.opensearch.cluster.awarenesshealth;
import java.util.concurrent.TimeUnit;  
        new ThreadContext(Settings.EMPTY)
                        )
            IndexMetadata indexMetadata = IndexMetadata.builder("test_" + i)
            IndexRoutingTable indexRoutingTable = routingTableGenerator.genIndexRoutingTable(indexMetadata, counter);  
        clusterAwarenessHealth = serializeResponse(clusterAwarenessHealth);
            clusterService.getSettings(),
            int numberOfReplicas = randomInt(4);  
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            IndexMetadata indexMetadata = IndexMetadata.builder("test_" + i)
        ClusterAwarenessHealth clusterAwarenessHealth = new ClusterAwarenessHealth(clusterState, clusterSettings, "zone");  
            .build();
        super.tearDown();
            for (ClusterAwarenessAttributeValueHealth clusterAwarenessAttributeValueHealth : attributeHealthMap.get(attributesName)
    }
        clusterService = createClusterService(threadPool);
        for (String attributesName : attributeHealthMap.keySet()) {
        Map<String, ClusterAwarenessAttributesHealth> attributeHealthMap = clusterAwarenessHealth.getClusterAwarenessAttributesHealthMap();
        indexNameExpressionResolver.concreteIndexNames(clusterState, IndicesOptions.strictExpand(), (String[]) null);
                    .add(
                .numberOfReplicas(numberOfReplicas)
                .getAwarenessAttributeHealthMap()
            .build();
            int numberOfShards = randomInt(3) + 1;
    protected static Set<DiscoveryNodeRole> NODE_ROLE = Collections.unmodifiableSet(
                .settings(settings(Version.CURRENT))
                        new DiscoveryNode(  
import java.util.Map;
/*  
            int numberOfReplicas = randomInt(4);
import org.opensearch.Version;
    private static ThreadPool threadPool;
                DiscoveryNodes.builder(clusterService.state().nodes())  
    private ClusterService clusterService;
import org.opensearch.transport.TransportService;  
                            singletonMap("zone", "zone_2"),
            int numberOfReplicas = 5;
            clusterAwarenessHealth = new ClusterAwarenessHealth(in);  
                            buildNewFakeTransportAddress(),
                            buildNewFakeTransportAddress(),
    public void testClusterHealthWithAwarenessAttributeAndNodeAttribute() throws IOException {  
                            buildNewFakeTransportAddress(),
                .build();
                            singletonMap("zone", "zone_1"),  
                    )  
                    .add(
                DiscoveryNodes.builder(clusterService.state().nodes())
                .numberOfReplicas(numberOfReplicas)
        RoutingTableGenerator.ShardCounter counter = new RoutingTableGenerator.ShardCounter();
                .numberOfShards(numberOfShards)
                        new DiscoveryNode(  
                    )
    public void testClusterHealthWithNoAwarenessAttribute() throws IOException {  
        RoutingTableGenerator routingTableGenerator = new RoutingTableGenerator();  
            .metadata(metadata)
                    )  
            IndexMetadata indexMetadata = IndexMetadata.builder("test_" + i)
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
                .numberOfReplicas(numberOfReplicas)
        RoutingTable.Builder routingTable = RoutingTable.builder();  
        }  
        transportService.acceptIncomingRequests();
                .build();  
 */  
            .nodes(  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
                .numberOfShards(numberOfShards)  
                        new DiscoveryNode(
            .routingTable(routingTable.build())
                        )
                .numberOfReplicas(numberOfReplicas)
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            )
                            buildNewFakeTransportAddress(),
                .build();  
                .settings(settings(Version.CURRENT))  
    @BeforeClass
        }
                    .add(
        }
                            Version.CURRENT
            .routingTable(routingTable.build())
                            Version.CURRENT
    }
                            singletonMap("zone", "zone_1"),
            IndexRoutingTable indexRoutingTable = routingTableGenerator.genIndexRoutingTable(indexMetadata, counter);
    public void tearDown() throws Exception {  
                            singletonMap("zone", "zone_1"),  
            assertEquals("zone", attributesName);
            .routingTable(routingTable.build())
    @Override
 * compatible open source license.
    @Before
        RoutingTableGenerator.ShardCounter counter = new RoutingTableGenerator.ShardCounter();
                    )  
                            "node3",
                    )
import org.opensearch.cluster.metadata.IndexMetadata;
        ClusterAwarenessHealth clusterAwarenessHealth = new ClusterAwarenessHealth(clusterState, clusterSettings, "zone");  
import java.util.Set;
            assertEquals(0, attributeHealthMap.get(attributesName).getAwarenessAttributeHealthMap().size());  
import java.io.IOException;  
                .build();
    }
            routingTable.add(indexRoutingTable);  
        }
                        new DiscoveryNode(
            .metadata(metadata)
                            "node2",  
}  
                .numberOfShards(numberOfShards)  
        }  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                DiscoveryNodes.builder(clusterService.state().nodes())
                            NODE_ROLE,  
        RoutingTableGenerator routingTableGenerator = new RoutingTableGenerator();
    @AfterClass  
        Map<String, ClusterAwarenessAttributesHealth> attributeHealthMap = clusterAwarenessHealth.getClusterAwarenessAttributesHealthMap();  
    }  
        for (String attributesName : attributeHealthMap.keySet()) {  
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
import org.opensearch.cluster.routing.IndexRoutingTable;
import java.util.Arrays;
    }
    public void testClusterHealthWithAwarenessAttributeAndReplicaEnforcementNotEnabled() throws IOException {
                .settings(settings(Version.CURRENT))  
        clusterService.close();
            assertEquals(0, attributeHealthMap.get(attributesName).getAwarenessAttributeHealthMap().size());
                            singletonMap("zone", "zone_3"),  
    public void testClusterHealthWithAwarenessAttributeAndReplicaEnforcementEnabled() throws IOException {  
                            NODE_ROLE,
        for (int i = 4; i >= 0; i--) {
                            buildNewFakeTransportAddress(),
            .nodes(clusterService.state().nodes())
                            "node2",
    private TransportService transportService;
            routingTable.add(indexRoutingTable);  
                            Version.CURRENT
            IndexRoutingTable indexRoutingTable = routingTableGenerator.genIndexRoutingTable(indexMetadata, counter);
import org.opensearch.cluster.node.DiscoveryNodes;
 * SPDX-License-Identifier: Apache-2.0
        }  
            }
        ClusterAwarenessHealth clusterAwarenessHealth = new ClusterAwarenessHealth(clusterState, clusterSettings, "zone");
            .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), "true")  
            assertEquals(3, attributeHealthMap.get(attributesName).getAwarenessAttributeHealthMap().size());  
                    .add(
            NoopTracer.INSTANCE
import org.opensearch.cluster.metadata.Metadata;
        indexNameExpressionResolver.concreteIndexNames(clusterState, IndicesOptions.strictExpand(), (String[]) null);
        }
                    )
        }
        Map<String, ClusterAwarenessAttributesHealth> attributeHealthMap = clusterAwarenessHealth.getClusterAwarenessAttributesHealthMap();
                .values()) {  
                            NODE_ROLE,  
                        )  
        Metadata.Builder metadata = Metadata.builder();
        for (int i = 4; i >= 0; i--) {
        indexNameExpressionResolver.concreteIndexNames(clusterState, IndicesOptions.strictExpand(), (String[]) null);
                            Version.CURRENT
                            NODE_ROLE,
            metadata.put(indexMetadata, true);
        RoutingTable.Builder routingTable = RoutingTable.builder();
            )
                        )  
                assertEquals(-1, clusterAwarenessAttributeValueHealth.getUnassignedShards());
                    .add(
                    .add(
