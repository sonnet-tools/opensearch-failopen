                    )  
import org.opensearch.cluster.node.DiscoveryNodes;  
    public void tearDown() throws Exception {  
            false,
                            NODE_ROLE,  
            )
        );  
    @After
                        new DiscoveryNode(  
                    .add(
                        )
        Map<String, ClusterAwarenessAttributeValueHealth> attributeValueMap = clusterAwarenessAttributesHealth
            .getAwarenessAttributeHealthMap();  
                            buildNewFakeTransportAddress(),
        threadPool = new TestThreadPool("ClusterAwarenessAttributeHealthTests");
                            singletonMap("zone", "zone_1"),
                            singletonMap("zone", "zone_1"),  
import org.opensearch.cluster.service.ClusterService;
                    )  
        );  
import org.junit.After;  
import org.opensearch.cluster.ClusterState;  
    private static ThreadPool threadPool;
package org.opensearch.cluster.awarenesshealth;
import java.util.HashSet;
 */  
                        new DiscoveryNode(
                            buildNewFakeTransportAddress(),  
import org.junit.Before;
        Map<String, ClusterAwarenessAttributeValueHealth> attributeValueMap = clusterAwarenessAttributesHealth  
            .nodes(
                            NODE_ROLE,
    private TransportService transportService;
    public void testClusterAwarenessAttributeHealth() {  
                DiscoveryNodes.builder(clusterService.state().nodes())  
        super.setUp();
                            NODE_ROLE,
                            Version.CURRENT  
            x -> clusterService.localNode(),
        clusterService = createClusterService(threadPool);
                        new DiscoveryNode(
        clusterService.close();
                            Version.CURRENT
import org.opensearch.Version;
                            singletonMap("zone", "zone_3"),  
                            singletonMap("zone", "zone_2"),  
        transportService.close();  
                            singletonMap("zone", "zone_2"),
                            Version.CURRENT
}
            )
import org.opensearch.cluster.node.DiscoveryNode;
        assertEquals("zone", clusterAwarenessAttributesHealth.getAwarenessAttributeName());  
                            buildNewFakeTransportAddress(),  
                            NODE_ROLE,  
        assertEquals(3, attributeValueMap.size());  
                        )
    }
                        )
                            "node2",
import java.util.Collections;  
 * this file be licensed under the Apache-2.0 license or a
                        new DiscoveryNode(
                    )
        Map<String, ClusterAwarenessAttributeValueHealth> attributeValueMap = clusterAwarenessAttributesHealth
    private ClusterService clusterService;
    @Override
    public void testClusterAwarenessAttributeHealthNoReplicaEnforcement() {
        assertEquals(3, attributeValueMap.size());
                        new DiscoveryNode(
                    )  
                            Version.CURRENT  
 *
    @Before
    public void testClusterAwarenessAttributeHealthNodeAttributeDoesNotExists() {
                            singletonMap("zone", "zone_2"),
    }
                    .add(  
                            buildNewFakeTransportAddress(),  
 * SPDX-License-Identifier: Apache-2.0
    );  
                            buildNewFakeTransportAddress(),
                DiscoveryNodes.builder(clusterService.state().nodes())
                            buildNewFakeTransportAddress(),
                DiscoveryNodes.builder(clusterService.state().nodes())
                            singletonMap("zone", "zone_3"),
            .getAwarenessAttributeHealthMap();
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        threadPool = null;  
                            NODE_ROLE,
                    )
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
                        new DiscoveryNode(
                            "node2",  
    }  
import org.opensearch.cluster.node.DiscoveryNodeRole;
            "rack",  
            .build();  
        );
            .build();
        transportService = transport.createTransportService(
        new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))
    public static void terminateThreadPool() {
            .build();
    @AfterClass  
import org.opensearch.transport.TransportService;
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                    .add(
                    .add(
                            buildNewFakeTransportAddress(),
    }
    }
import org.opensearch.test.OpenSearchTestCase;
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
                            "node3",  
                    .add(
                            "node3",
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                        new DiscoveryNode(  
        );
import java.util.Map;
            .nodes(  
                        )
            .nodes(
                            NODE_ROLE,
        transportService.acceptIncomingRequests();
                            NODE_ROLE,
                            "node1",
                            "node1",  
            true,
                        new DiscoveryNode(  
        assertEquals("rack", clusterAwarenessAttributesHealth.getAwarenessAttributeName());
            true,  
        transportService.start();
            )  
                            "node1",
            .getAwarenessAttributeHealthMap();
    }
                        )  
                            singletonMap("zone", "zone_1"),
            threadPool,  
                            buildNewFakeTransportAddress(),
 * compatible open source license.
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
import java.util.Arrays;
                    )
import org.opensearch.test.transport.CapturingTransport;
                        )
            Collections.emptySet(),
            clusterState  
 * The OpenSearch Contributors require contributions made to  
                    .add(  
/*  
            clusterService.getSettings(),
        ClusterAwarenessAttributesHealth clusterAwarenessAttributesHealth = new ClusterAwarenessAttributesHealth(
import org.junit.AfterClass;
                            "node2",
    public static void setupThreadPool() {  
            "zone",
        ClusterAwarenessAttributesHealth clusterAwarenessAttributesHealth = new ClusterAwarenessAttributesHealth(  
                    )
import static java.util.Collections.singletonMap;  
import java.util.concurrent.TimeUnit;
import java.util.Set;  
                            NODE_ROLE,  
                            Version.CURRENT  
                    .add(
                        )
        assertEquals(0, attributeValueMap.size());
            clusterState
                            NODE_ROLE,
    }  
    @BeforeClass
                            singletonMap("zone", "zone_3"),
                            Version.CURRENT
                            "node3",
                    .add(  
import org.opensearch.cluster.ClusterName;
                            Version.CURRENT
            null,  
        super.tearDown();
            "zone",
                    )
                    .add(
import org.opensearch.threadpool.TestThreadPool;  
    public void setUp() throws Exception {  
import org.junit.BeforeClass;  
import org.opensearch.common.settings.Settings;
public class ClusterAwarenessAttributesHealthTests extends OpenSearchTestCase {  
    protected static Set<DiscoveryNodeRole> NODE_ROLE = Collections.unmodifiableSet(
                            Version.CURRENT
                            buildNewFakeTransportAddress(),
                        )  
        assertEquals("zone", clusterAwarenessAttributesHealth.getAwarenessAttributeName());
        ClusterAwarenessAttributesHealth clusterAwarenessAttributesHealth = new ClusterAwarenessAttributesHealth(
import org.opensearch.threadpool.ThreadPool;
                    )
            clusterState
            NoopTracer.INSTANCE
        CapturingTransport transport = new CapturingTransport();  
                            Version.CURRENT
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
                        )  
                        new DiscoveryNode(
