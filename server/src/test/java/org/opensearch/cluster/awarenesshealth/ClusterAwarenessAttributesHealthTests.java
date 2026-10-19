                    )
        Map<String, ClusterAwarenessAttributeValueHealth> attributeValueMap = clusterAwarenessAttributesHealth
import static java.util.Collections.singletonMap;
import org.opensearch.cluster.node.DiscoveryNodes;
 * this file be licensed under the Apache-2.0 license or a
                            "node1",
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
                        new DiscoveryNode(
                            buildNewFakeTransportAddress(),
        assertEquals("zone", clusterAwarenessAttributesHealth.getAwarenessAttributeName());
                            singletonMap("zone", "zone_3"),
    @BeforeClass
import java.util.Collections;
        assertEquals("zone", clusterAwarenessAttributesHealth.getAwarenessAttributeName());
            .nodes(
                            buildNewFakeTransportAddress(),
                            buildNewFakeTransportAddress(),
                            NODE_ROLE,
import org.opensearch.cluster.service.ClusterService;
        CapturingTransport transport = new CapturingTransport();
                            "node1",
                        new DiscoveryNode(
import org.opensearch.cluster.node.DiscoveryNode;
                            buildNewFakeTransportAddress(),
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                            buildNewFakeTransportAddress(),
        threadPool = new TestThreadPool("ClusterAwarenessAttributeHealthTests");
import org.opensearch.cluster.node.DiscoveryNodeRole;
        new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))
        super.tearDown();
                            NODE_ROLE,
    }
            Collections.emptySet(),
                DiscoveryNodes.builder(clusterService.state().nodes())
import org.opensearch.transport.TransportService;
            clusterState
                    .add(
                    .add(
            "zone",
import org.opensearch.Version;
        );
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .getAwarenessAttributeHealthMap();
                            NODE_ROLE,
            true,
                    .add(
import org.opensearch.test.OpenSearchTestCase;
                        )
            null,
                            "node3",
                DiscoveryNodes.builder(clusterService.state().nodes())
import org.opensearch.cluster.ClusterName;
                            "node3",
                        )
            .nodes(
            NoopTracer.INSTANCE
        assertEquals(3, attributeValueMap.size());
                            NODE_ROLE,
                    )
                            Version.CURRENT
                            singletonMap("zone", "zone_3"),
            true,
                        )
        );
}
import org.opensearch.test.transport.CapturingTransport;
                        new DiscoveryNode(
                        )
                            Version.CURRENT
import org.opensearch.telemetry.tracing.noop.NoopTracer;
public class ClusterAwarenessAttributesHealthTests extends OpenSearchTestCase {
    public void tearDown() throws Exception {
                    )
import org.opensearch.cluster.ClusterState;
    }
                            NODE_ROLE,
    private TransportService transportService;
                    .add(
/*
 * compatible open source license.
                        new DiscoveryNode(
                            singletonMap("zone", "zone_1"),
                            Version.CURRENT
import java.util.Arrays;
    private static ThreadPool threadPool;
            .getAwarenessAttributeHealthMap();
            "rack",
import org.junit.BeforeClass;
        super.setUp();
                            singletonMap("zone", "zone_2"),
    @Before
                    )
                        new DiscoveryNode(
                            NODE_ROLE,
                    )
            )
                            singletonMap("zone", "zone_2"),
                        )
                    .add(
        transportService = transport.createTransportService(
import java.util.concurrent.TimeUnit;
                            Version.CURRENT
                    .add(
                            NODE_ROLE,
                            "node3",
        transportService.acceptIncomingRequests();
                            buildNewFakeTransportAddress(),
                            buildNewFakeTransportAddress(),
                            "node2",
    }
    @AfterClass
 */
        );
            threadPool,
 *
        transportService.close();
                    .add(
                    )
package org.opensearch.cluster.awarenesshealth;
                            Version.CURRENT
            "zone",
import java.util.Map;
        );
        clusterService.close();
    @Override
                            Version.CURRENT
            false,
import org.opensearch.common.settings.Settings;
    }
            clusterService.getSettings(),
        Map<String, ClusterAwarenessAttributeValueHealth> attributeValueMap = clusterAwarenessAttributesHealth
                    )
                            NODE_ROLE,
import org.opensearch.threadpool.TestThreadPool;
        assertEquals(0, attributeValueMap.size());
            .build();
import org.junit.Before;
    public void setUp() throws Exception {
            clusterState
                        new DiscoveryNode(
        Map<String, ClusterAwarenessAttributeValueHealth> attributeValueMap = clusterAwarenessAttributesHealth
import java.util.HashSet;
import java.util.Set;
    public static void setupThreadPool() {
                        )
    protected static Set<DiscoveryNodeRole> NODE_ROLE = Collections.unmodifiableSet(
import org.opensearch.threadpool.ThreadPool;
                        )
                        )
        ClusterAwarenessAttributesHealth clusterAwarenessAttributesHealth = new ClusterAwarenessAttributesHealth(
                            "node1",
                        new DiscoveryNode(
                            singletonMap("zone", "zone_1"),
                        new DiscoveryNode(
    }
            .build();
                        )
            .build();
        ClusterAwarenessAttributesHealth clusterAwarenessAttributesHealth = new ClusterAwarenessAttributesHealth(
    }
import org.junit.After;
    public void testClusterAwarenessAttributeHealthNoReplicaEnforcement() {
                            Version.CURRENT
                    .add(
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        assertEquals(3, attributeValueMap.size());
                            singletonMap("zone", "zone_3"),
                            NODE_ROLE,
        clusterService = createClusterService(threadPool);
 * The OpenSearch Contributors require contributions made to
import org.junit.AfterClass;
                            singletonMap("zone", "zone_2"),
            .getAwarenessAttributeHealthMap();
                            buildNewFakeTransportAddress(),
    }
    @After
    public void testClusterAwarenessAttributeHealth() {
        ClusterAwarenessAttributesHealth clusterAwarenessAttributesHealth = new ClusterAwarenessAttributesHealth(
                            singletonMap("zone", "zone_1"),
                            Version.CURRENT
                        new DiscoveryNode(
        threadPool = null;
            )
                    .add(
                DiscoveryNodes.builder(clusterService.state().nodes())
            x -> clusterService.localNode(),
                            "node2",
    public void testClusterAwarenessAttributeHealthNodeAttributeDoesNotExists() {
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
                            buildNewFakeTransportAddress(),
            clusterState
                            Version.CURRENT
        transportService.start();
            .nodes(
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            )
    );
                            "node2",
    public static void terminateThreadPool() {
        assertEquals("rack", clusterAwarenessAttributesHealth.getAwarenessAttributeName());
                    )
                    )
    private ClusterService clusterService;
 * SPDX-License-Identifier: Apache-2.0
