                CountDownLatch latch = new CountDownLatch(1);
                    searchTransportService,
                ActionListener<CreatePitResponse> updatelistener = new LatchedActionListener<>(new ActionListener<CreatePitResponse>() {
        );
                    @Override
                        ActionListener<UpdatePitContextResponse> listener
    /**
        final Version version,  
            new TaskId(randomLong() + ":" + randomLong()),
                    ) {
                  check if cleanup is called for all nodes in case of update pit failure  
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.search.aggregations.InternalAggregations;  
     */  
                ActionListener<CreatePitResponse> updatelistener = new LatchedActionListener<>(new ActionListener<CreatePitResponse>() {
                        Transport.Connection connection,
                    }
                    @Override  
    }
        when(state.getMetadata()).thenReturn(Metadata.EMPTY_METADATA);
                transportService.start();  
    public void testUpdatePitAfterCreatePitSuccess() throws InterruptedException {
            pitId
        InternalSearchResponse response = new InternalSearchResponse(
            try (
            "transport",
                    transportSearchAction,
        clusterServiceMock = mock(ClusterService.class);
                    public void onResponse(CreatePitResponse createPITResponse) {  
        return startTransport(id, knownNodes, version, Settings.EMPTY);  
    DiscoveryNodes nodes = null;
            @Override
    @Override
                };
                 */
            ShardSearchFailure.EMPTY_ARRAY,  
 * this file be licensed under the Apache-2.0 license or a
                    public void updatePitContext(
                        deleteNodesInvoked.add(connection.getNode());
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);  
import org.opensearch.action.LatchedActionListener;  
                        ActionListener<DeletePitResponse> listener
        try (
            try (
import org.opensearch.cluster.node.DiscoveryNodes;
                        Thread t = new Thread(() -> listener.onResponse(new DeletePitResponse(new ArrayList<>())));  
import org.opensearch.threadpool.TestThreadPool;  
            knownNodes.add(cluster1Transport.getLocalDiscoNode());  
    TransportSearchAction transportSearchAction = null;
        when(clusterServiceMock.getSettings()).thenReturn(keepAliveSettings);
                    public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {  
                        UpdatePitContextRequest request,
                            Thread t = new Thread(() -> listener.onResponse(new UpdatePitContextResponse("pitid", 500000, 500000)));
                StepListener<SearchResponse> createListener = new StepListener<>();  
                            t.start();
            ) {
                        updateNodesInvoked.add(connection.getNode());  
                    }  
     * Testing that any update pit failures fails the request
                            t.start();
                MockTransportService transportService = MockTransportService.createNewService(
                assertEquals(0, deleteNodesInvoked.size());
            new SearchHits(new SearchHit[0], new TotalHits(0, TotalHits.Relation.EQUAL_TO), Float.NaN),  
                        Transport.Connection connection,  
                    @Override
        pitId = getPitId();
     */  
                    pitService
                    Version.CURRENT,
                    searchTransportService,  
                new NamedWriteableRegistry.Entry(QueryBuilder.class, IdsQueryBuilder.NAME, IdsQueryBuilder::new)
                    NoopTracer.INSTANCE  
                new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchAllQueryBuilder.NAME, MatchAllQueryBuilder::new),  
                request.setIndices(new String[] { "index" });
import org.opensearch.search.internal.InternalSearchResponse;
                        Thread t = new Thread(() -> listener.onFailure(new Exception("node down")));
                    public void sendFreePITContexts(
                    }
                CreatePitController controller = new CreatePitController(
                    public void onFailure(Exception e) {  
                SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {
                    public void onResponse(CreatePitResponse createPITResponse) {
                transportService.start();  
                        t.start();
            0,
 * SPDX-License-Identifier: Apache-2.0
                    }
import org.junit.Before;
                    @Override  
import static org.mockito.Mockito.mock;
                        UpdatePitContextRequest request,  
                        List<PitSearchContextIdForNode> contextIds,
                    threadPool,
                transportService.acceptIncomingRequests();
import static org.mockito.Mockito.when;
                StepListener<SearchResponse> createListener = new StepListener<>();
                transportService.start();  
            Collections.shuffle(knownNodes, random());
                controller.executeCreatePit(request, task, createListener, updatelistener);
                    @Override
import org.opensearch.index.query.QueryBuilder;
                    @Override
        task = new Task(  
     * If create phase results in failure, update pit phase should not proceed and propagate the exception
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);  
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
    NamedWriteableRegistry namedWriteableRegistry = null;
                        updateNodesInvoked.add(connection.getNode());  
                createListener.onResponse(searchResponse);  
        node3 = new DiscoveryNode("node_3", buildNewFakeTransportAddress(), Version.CURRENT);
        );
                transportService.start();  
                    clusterServiceMock,
                    public void sendFreePITContexts(
                    @Override
    SearchResponse searchResponse = null;  
import org.opensearch.index.query.MatchAllQueryBuilder;
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
            null,
        when(state.getNodes()).thenReturn(nodes);
                ActionListener<CreatePitResponse> updatelistener = new LatchedActionListener<>(new ActionListener<CreatePitResponse>() {  
                    }  
                    clusterServiceMock,  
            1  
                        updateNodesInvoked.add(connection.getNode());
                    @Override
                transportService.acceptIncomingRequests();
                        updateNodesInvoked.add(connection.getNode());  
import java.util.Arrays;
/**
import java.util.concurrent.CopyOnWriteArrayList;
                    }  
    }
                controller.executeCreatePit(request, task, createListener, updatelistener);
import org.opensearch.Version;
                latch.await();  
        }
}
                assertEquals(3, createPITResponse.getTotalShards());
                    @Override  
        );  
                        assertTrue(e.getMessage().contains("node 3 down"));
                    }  
import java.util.List;
import org.opensearch.cluster.node.DiscoveryNode;
                CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);  
    DiscoveryNode node1 = null;
                    }  
                );  
                    Settings.EMPTY,  
                createListener.onResponse(searchResponse);
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
                        Thread t = new Thread(() -> listener.onResponse(new UpdatePitContextResponse("pitid", 500000, 500000)));
        final Settings settings
                    public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
                createListener.onResponse(searchResponse);
                    namedWriteableRegistry,
 */  
                CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);  
                StepListener<SearchResponse> createListener = new StepListener<>();  
                    NoopTracer.INSTANCE  
        }
import java.util.concurrent.CountDownLatch;  
import org.opensearch.action.StepListener;
import org.opensearch.index.query.IdsQueryBuilder;  
        }
                        ActionListener<DeletePitResponse> listener  
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
        searchResponse = new SearchResponse(
 */
                        t.start();
    String pitId = null;
        try (
        when(clusterServiceMock.state()).thenReturn(state);  
import java.util.concurrent.TimeUnit;
                    Version.CURRENT,
                        UpdatePitContextRequest request,  
    ) {
import org.opensearch.core.tasks.TaskId;
            Arrays.asList(
                request.setIndices(new String[] { "index" });  
import static org.opensearch.action.search.PitTestsUtil.getPitId;  
                    }
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
                ActionListener<CreatePitResponse> updatelistener = new LatchedActionListener<>(new ActionListener<CreatePitResponse>() {  
            false,
            Collections.shuffle(knownNodes, random());
        List<DiscoveryNode> updateNodesInvoked = new CopyOnWriteArrayList<>();
                    public void sendFreePITContexts(  
                    Version.CURRENT,
                };
    public void testUpdatePitFailureWhereAllNodesDown() throws InterruptedException {
                    NoopTracer.INSTANCE  
                CreatePitController controller = new CreatePitController(  
        List<DiscoveryNode> updateNodesInvoked = new CopyOnWriteArrayList<>();
                CountDownLatch latch = new CountDownLatch(1);
                        Transport.Connection connection,
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
                }, latch);  
                CreatePitController controller = new CreatePitController(
                    @Override
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                request.setIndices(new String[] { "index" });
                /*
            null,  
    private MockTransportService startTransport(  
import java.util.ArrayList;
                    searchTransportService,
import org.opensearch.index.query.TermQueryBuilder;  
                    @Override  
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
                    }
import java.util.Collections;  
package org.opensearch.action.search;
                    @Override
        final Settings keepAliveSettings = Settings.builder().put(CreatePitController.PIT_INIT_KEEP_ALIVE.getKey(), 30000).build();
        );  
                        }  
                    }
                    ) {
        nodes = DiscoveryNodes.builder().add(node1).add(node2).add(node3).build();
                     * Test if cleanup request is called  
            ) {
                 */
                        throw new AssertionError("response is called");
     * Test if transport call for update pit is made to all nodes present as part of PIT ID returned from phase one of create pit
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);  
        final List<DiscoveryNode> knownNodes,
            knownNodes.add(cluster1Transport.getLocalDiscoNode());  
            try (
            )
        when(state.metadata()).thenReturn(Metadata.EMPTY_METADATA);
                    /**
            }
                        Thread t = new Thread(() -> listener.onResponse(new DeletePitResponse(new ArrayList<>())));
                        UpdatePitContextRequest request,  
     */  
                    transportSearchAction,
                /*
            response,  
 * integration tests don't cover it.  
            InternalAggregations.EMPTY,
                    public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
    }
                        List<PitSearchContextIdForNode> contextIds,
                    @Override
                    ) {  
        node2 = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);  
                        Transport.Connection connection,  
                CountDownLatch latch = new CountDownLatch(1);
                    @Override
            3,
                        t.start();
                PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client);
            try (
            null,
    Settings settings = Settings.builder().put("node.name", CreatePitControllerTests.class.getSimpleName()).build();
                CountDownLatch latch = new CountDownLatch(1);
                    transportSearchAction,  
    }  
            randomLong(),
        List<DiscoveryNode> updateNodesInvoked = new CopyOnWriteArrayList<>();
                    threadPool,
                    namedWriteableRegistry,
        ) {
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
                        ActionListener<UpdatePitContextResponse> listener
            ) {
                    pitService  
                assertEquals(0, updateNodesInvoked.size());
            knownNodes.add(cluster1Transport.getLocalDiscoNode());  
                SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {
public class CreatePitControllerTests extends OpenSearchTestCase {
    public void testUpdatePitFailureForNodeDrop() throws InterruptedException {
                 */
                MockTransportService transportService = MockTransportService.createNewService(
import org.opensearch.tasks.Task;
                    @Override
        List<DiscoveryNode> deleteNodesInvoked = new CopyOnWriteArrayList<>();  
                );  
    /**
    ActionListener<CreatePitResponse> createPitListener = null;
                CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
                    clusterServiceMock,
                    }
    }
                }, latch);
                    }
                        t.start();
                MockTransportService transportService = MockTransportService.createNewService(
                        Thread t = new Thread(() -> listener.onResponse(new DeletePitResponse(new ArrayList<>())));
        super.tearDown();
    }
                );
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);  
    @Before  
            Collections.shuffle(knownNodes, random());
                  check if cleanup is called for all nodes in case of update pit failure
import org.opensearch.cluster.service.ClusterService;  
                assertEquals(3, updateNodesInvoked.size());
                /*  
                        t.start();
                        Transport.Connection connection,
                    pitService
                    threadPool,
                        Thread t = new Thread(() -> listener.onResponse(new DeletePitResponse(new ArrayList<>())));  
    public void setupData() {
            public void onResponse(CreatePitResponse createPITResponse) {  
                    public void updatePitContext(
            ) {
import org.opensearch.core.action.ActionListener;  
            SearchResponse.Clusters.EMPTY,
                        assertTrue(e.getMessage().contains("node down"));  
    /**
                    }  
import org.opensearch.transport.Transport;  
import org.apache.lucene.search.TotalHits;
import org.opensearch.transport.client.node.NodeClient;
                            Thread t = new Thread(() -> listener.onFailure(new Exception("node 3 down")));
            @Override
                    NoopTracer.INSTANCE  
            }
    DiscoveryNode node3 = null;  
                MockTransportService transportService = MockTransportService.createNewService(
                        Transport.Connection connection,
            knownNodes.add(cluster1Transport.getLocalDiscoNode());  
        createPitListener = new ActionListener<CreatePitResponse>() {
        List<DiscoveryNode> deleteNodesInvoked = new CopyOnWriteArrayList<>();  
                    ) {
                    }
import org.opensearch.cluster.metadata.Metadata;  
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
    public void testUpdatePitAfterCreatePitFailure() throws InterruptedException {
                    ) {
                  cleanup is not called on create pit phase one failure  
            100,
                    public void onFailure(Exception e) {
                assertEquals(3, deleteNodesInvoked.size());  
import org.opensearch.search.SearchHits;
                        Thread t = new Thread(() -> listener.onResponse(new UpdatePitContextResponse("pitid", 500000, 500000)));
                assertEquals(3, deleteNodesInvoked.size());
                    public void onFailure(Exception e) {
                )
                        throw new AssertionError("on response is called");
 * The OpenSearch Contributors require contributions made to  
                    public void updatePitContext(
                PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client);  
                        ActionListener<UpdatePitContextResponse> listener
                        } else {  
                PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client);
            null,
import org.opensearch.common.settings.Settings;
        transportSearchAction = mock(TransportSearchAction.class);
                CreatePitController controller = new CreatePitController(  
import org.opensearch.threadpool.ThreadPool;
                    transportSearchAction,  
                        List<PitSearchContextIdForNode> contextIds,
        ClusterState state = mock(ClusterState.class);
                )
                }, latch);
        node1 = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
                     */
            public void onFailure(Exception e) {
                    public void onResponse(CreatePitResponse createPITResponse) {
            }  
                        return new SearchAsyncActionTests.MockConnection(node);  
                        Transport.Connection connection,
                    public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {  
                latch.await();  
 *
                controller.executeCreatePit(request, task, createListener, updatelistener);
import org.opensearch.test.transport.MockTransportService;
        }
            Collections.shuffle(knownNodes, random());
        try (
                        return new SearchAsyncActionTests.MockConnection(node);
                        ActionListener<DeletePitResponse> listener  
                    Settings.EMPTY,  
                        assertEquals(3, createPITResponse.getTotalShards());  
                    pitService
        List<DiscoveryNode> updateNodesInvoked = new CopyOnWriteArrayList<>();
        ) {
            }  
                    namedWriteableRegistry,  
            "description",
    NodeClient client = new NodeClient(settings, threadPool);  
                createListener.onFailure(new Exception("Exception occurred in phase 1"));
            }
        final String id,
                };  
                assertEquals(3, updateNodesInvoked.size());
                transportService.acceptIncomingRequests();
        namedWriteableRegistry = new NamedWriteableRegistry(  
                        if (connection.getNode().getId() == "node_3") {  
                        deleteNodesInvoked.add(connection.getNode());
                        throw new AssertionError("response is called");  
                )
                    }
                    }
                    Settings.EMPTY,  
                    }
                        ActionListener<DeletePitResponse> listener
                }, latch);
                    }  
                );
        List<DiscoveryNode> deleteNodesInvoked = new CopyOnWriteArrayList<>();  
 * Functional tests for various methods in create pit controller. Covers update pit phase specifically since
                latch.await();
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
        };
/*  
                    namedWriteableRegistry,
                assertEquals(0, deleteNodesInvoked.size());
                    ) {  
                    @Override
                    @Override  
                controller.executeCreatePit(request, task, createListener, updatelistener);
                        Transport.Connection connection,
                    Settings.EMPTY,  
                new NamedWriteableRegistry.Entry(QueryBuilder.class, TermQueryBuilder.NAME, TermQueryBuilder::new),
                        deleteNodesInvoked.add(connection.getNode());  
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);  
    Task task = null;  
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
                    @Override
                };
        return RemoteClusterConnectionTests.startTransport(id, knownNodes, version, threadPool, settings);  
                SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {
            Collections.emptyMap()  
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
                        t.start();
                    threadPool,
import org.opensearch.transport.RemoteClusterConnectionTests;
import org.opensearch.search.SearchHit;
                )
                        t.start();  
                throw new AssertionError(e);  
                        ActionListener<UpdatePitContextResponse> listener
        ) {
        List<DiscoveryNode> deleteNodesInvoked = new CopyOnWriteArrayList<>();  
                    ) {
                    @Override  
                SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {  
                    public void updatePitContext(
                assertEquals(3, updateNodesInvoked.size());
                    Version.CURRENT,
                    public void sendFreePITContexts(  
    ClusterService clusterServiceMock = null;
 * compatible open source license.
                PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client);
        ) {
                    public void onResponse(CreatePitResponse createPITResponse) {
                StepListener<SearchResponse> createListener = new StepListener<>();
                    searchTransportService,
                    @Override  
                transportService.acceptIncomingRequests();
    }  
                        List<PitSearchContextIdForNode> contextIds,  
                        return new SearchAsyncActionTests.MockConnection(node);  
    public void tearDown() throws Exception {  
                        deleteNodesInvoked.add(connection.getNode());
import org.opensearch.common.unit.TimeValue;
import org.opensearch.cluster.ClusterState;
                    }
                        assertTrue(e.getCause().getMessage().contains("Exception occurred in phase 1"));
            }  
                latch.await();  
            SearchAction.NAME,  
                    ) {
        try (
                    public void onFailure(Exception e) {
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
    }
                request.setIndices(new String[] { "index" });
                    clusterServiceMock,
            3,  
                        return new SearchAsyncActionTests.MockConnection(node);
    private MockTransportService startTransport(String id, List<DiscoveryNode> knownNodes, Version version) {
    DiscoveryNode node2 = null;
                        throw new AssertionError(e);
