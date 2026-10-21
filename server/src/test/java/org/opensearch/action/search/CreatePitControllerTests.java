import java.util.List;
                 */
                    public void onResponse(CreatePitResponse createPITResponse) {
                    pitService
                throw new AssertionError(e);
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
        final Settings settings
                        Transport.Connection connection,
                     */
                };
                  check if cleanup is called for all nodes in case of update pit failure
 * this file be licensed under the Apache-2.0 license or a
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
            "transport",
import org.opensearch.search.internal.InternalSearchResponse;
import org.opensearch.cluster.node.DiscoveryNode;
            null,
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
        List<DiscoveryNode> deleteNodesInvoked = new CopyOnWriteArrayList<>();
                        ActionListener<DeletePitResponse> listener
                new NamedWriteableRegistry.Entry(QueryBuilder.class, IdsQueryBuilder.NAME, IdsQueryBuilder::new)
            SearchResponse.Clusters.EMPTY,
        namedWriteableRegistry = new NamedWriteableRegistry(
    }
}
        when(state.getNodes()).thenReturn(nodes);
                CreatePitController controller = new CreatePitController(
                    @Override
                SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {
                    ) {
                        updateNodesInvoked.add(connection.getNode());
package org.opensearch.action.search;
    DiscoveryNode node3 = null;
                        Thread t = new Thread(() -> listener.onResponse(new DeletePitResponse(new ArrayList<>())));
                transportService.acceptIncomingRequests();
                        UpdatePitContextRequest request,
    }
                        t.start();
import java.util.concurrent.TimeUnit;
    }
import org.opensearch.transport.RemoteClusterConnectionTests;
                        }
                  cleanup is not called on create pit phase one failure
                    @Override
                        Thread t = new Thread(() -> listener.onFailure(new Exception("node down")));
    /**
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
                    clusterServiceMock,
                    ) {
                createListener.onFailure(new Exception("Exception occurred in phase 1"));
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
                    }
    ) {
                StepListener<SearchResponse> createListener = new StepListener<>();
                    }
                assertEquals(0, updateNodesInvoked.size());
        try (
                SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {
        List<DiscoveryNode> updateNodesInvoked = new CopyOnWriteArrayList<>();
        pitId = getPitId();
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
                    ) {
                    @Override
    public void testUpdatePitFailureForNodeDrop() throws InterruptedException {
                    }
                    namedWriteableRegistry,
                        assertTrue(e.getMessage().contains("node 3 down"));
                    }
                transportService.start();
                    Settings.EMPTY,
        };
                createListener.onResponse(searchResponse);
    SearchResponse searchResponse = null;
                };
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                }, latch);
import org.opensearch.threadpool.ThreadPool;
            ) {
                transportService.start();
                PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client);
import org.opensearch.search.SearchHits;
        List<DiscoveryNode> updateNodesInvoked = new CopyOnWriteArrayList<>();
                    }
        }
                    searchTransportService,
        try (
                        if (connection.getNode().getId() == "node_3") {
                    clusterServiceMock,
                    }
                    @Override
                        } else {
        nodes = DiscoveryNodes.builder().add(node1).add(node2).add(node3).build();
                PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client);
            public void onResponse(CreatePitResponse createPITResponse) {
                        Thread t = new Thread(() -> listener.onResponse(new UpdatePitContextResponse("pitid", 500000, 500000)));
                    @Override
import java.util.Collections;
import org.opensearch.index.query.QueryBuilder;
                    namedWriteableRegistry,
                    @Override
            ) {
                latch.await();
                StepListener<SearchResponse> createListener = new StepListener<>();
                    public void onResponse(CreatePitResponse createPITResponse) {
                transportService.acceptIncomingRequests();
            ShardSearchFailure.EMPTY_ARRAY,
                StepListener<SearchResponse> createListener = new StepListener<>();
    private MockTransportService startTransport(
                        t.start();
import org.opensearch.common.unit.TimeValue;
                            Thread t = new Thread(() -> listener.onResponse(new UpdatePitContextResponse("pitid", 500000, 500000)));
        ) {
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
            new TaskId(randomLong() + ":" + randomLong()),
import java.util.concurrent.CopyOnWriteArrayList;
                        deleteNodesInvoked.add(connection.getNode());
    /**
                )
    NodeClient client = new NodeClient(settings, threadPool);
        );
            InternalAggregations.EMPTY,
 */
                            t.start();
                assertEquals(3, updateNodesInvoked.size());
                    Version.CURRENT,
                PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client);
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
        when(state.metadata()).thenReturn(Metadata.EMPTY_METADATA);
                        t.start();
                    ) {
                        List<PitSearchContextIdForNode> contextIds,
            randomLong(),
        when(state.getMetadata()).thenReturn(Metadata.EMPTY_METADATA);
                        return new SearchAsyncActionTests.MockConnection(node);
        node2 = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);
                 */
                        Transport.Connection connection,
                MockTransportService transportService = MockTransportService.createNewService(
                assertEquals(3, deleteNodesInvoked.size());
                        ActionListener<UpdatePitContextResponse> listener
            }
import org.opensearch.test.transport.MockTransportService;
        List<DiscoveryNode> updateNodesInvoked = new CopyOnWriteArrayList<>();
import org.opensearch.index.query.TermQueryBuilder;
        }
                        Transport.Connection connection,
                        UpdatePitContextRequest request,
                latch.await();
                };
    @Override
                );
    NamedWriteableRegistry namedWriteableRegistry = null;
            3,
public class CreatePitControllerTests extends OpenSearchTestCase {
        List<DiscoveryNode> updateNodesInvoked = new CopyOnWriteArrayList<>();
     * Test if transport call for update pit is made to all nodes present as part of PIT ID returned from phase one of create pit
        final List<DiscoveryNode> knownNodes,
                        t.start();
                ActionListener<CreatePitResponse> updatelistener = new LatchedActionListener<>(new ActionListener<CreatePitResponse>() {
                    @Override
            }
            Collections.emptyMap()
                CreatePitController controller = new CreatePitController(
            @Override
import static org.mockito.Mockito.when;
                    pitService
                );
                    @Override
    @Before
                new NamedWriteableRegistry.Entry(QueryBuilder.class, TermQueryBuilder.NAME, TermQueryBuilder::new),
import org.opensearch.core.action.ActionListener;
                    ) {
                    @Override
                    @Override
import org.opensearch.index.query.MatchAllQueryBuilder;
                /*
import org.opensearch.core.tasks.TaskId;
                MockTransportService transportService = MockTransportService.createNewService(
                /*
 * compatible open source license.
                );
        List<DiscoveryNode> deleteNodesInvoked = new CopyOnWriteArrayList<>();
import org.opensearch.transport.client.node.NodeClient;
                request.setIndices(new String[] { "index" });
 * integration tests don't cover it.
                            Thread t = new Thread(() -> listener.onFailure(new Exception("node 3 down")));
        ClusterState state = mock(ClusterState.class);
                    public void sendFreePITContexts(
                    public void sendFreePITContexts(
                        ActionListener<UpdatePitContextResponse> listener
                        Transport.Connection connection,
                        deleteNodesInvoked.add(connection.getNode());
                    public void sendFreePITContexts(
            }
                    public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
                }, latch);
                        assertTrue(e.getMessage().contains("node down"));
                ActionListener<CreatePitResponse> updatelistener = new LatchedActionListener<>(new ActionListener<CreatePitResponse>() {
        super.tearDown();
            }
                    public void onFailure(Exception e) {
                    NoopTracer.INSTANCE
        node3 = new DiscoveryNode("node_3", buildNewFakeTransportAddress(), Version.CURRENT);
                    NoopTracer.INSTANCE
                    }
            Collections.shuffle(knownNodes, random());
                 */
                    Version.CURRENT,
            }
                controller.executeCreatePit(request, task, createListener, updatelistener);
                    }
                CountDownLatch latch = new CountDownLatch(1);
                }, latch);
                        ActionListener<DeletePitResponse> listener
            100,
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
                assertEquals(3, updateNodesInvoked.size());
    public void testUpdatePitAfterCreatePitSuccess() throws InterruptedException {
                    public void onFailure(Exception e) {
                    threadPool,
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);
            "description",
                        ActionListener<DeletePitResponse> listener
                        ActionListener<UpdatePitContextResponse> listener
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
                CountDownLatch latch = new CountDownLatch(1);
                    }
                    @Override
                    }
                )
            false,
                        assertTrue(e.getCause().getMessage().contains("Exception occurred in phase 1"));
        InternalSearchResponse response = new InternalSearchResponse(
            Collections.shuffle(knownNodes, random());
    public void testUpdatePitAfterCreatePitFailure() throws InterruptedException {
    DiscoveryNode node2 = null;
    ActionListener<CreatePitResponse> createPitListener = null;
import org.opensearch.tasks.Task;
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);
                        Transport.Connection connection,
        }
                        t.start();
                request.setIndices(new String[] { "index" });
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);
            SearchAction.NAME,
                    ) {
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
                        return new SearchAsyncActionTests.MockConnection(node);
                createListener.onResponse(searchResponse);
                     * Test if cleanup request is called
                    public void onResponse(CreatePitResponse createPITResponse) {
/**
                    public void sendFreePITContexts(
 * The OpenSearch Contributors require contributions made to
        searchResponse = new SearchResponse(
import org.opensearch.action.LatchedActionListener;
import org.apache.lucene.search.TotalHits;
                    }
                };
    }
                    }
                    transportSearchAction,
                transportService.start();
                CreatePitController controller = new CreatePitController(
                    threadPool,
                        throw new AssertionError("response is called");
                latch.await();
                    searchTransportService,
                    ) {
                    }
                }, latch);
                    clusterServiceMock,
        node1 = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
     */
            )
            ) {
            null,
                    }
                        t.start();
                    @Override
    private MockTransportService startTransport(String id, List<DiscoveryNode> knownNodes, Version version) {
    /**
                    pitService
                CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
    Task task = null;
                )
import org.opensearch.threadpool.TestThreadPool;
                        t.start();
                    ) {
    }
 * SPDX-License-Identifier: Apache-2.0
                    @Override
import org.junit.Before;
    TransportSearchAction transportSearchAction = null;
        createPitListener = new ActionListener<CreatePitResponse>() {
                    }
            try (
                    clusterServiceMock,
                assertEquals(0, deleteNodesInvoked.size());
                    transportSearchAction,
            0,
                        List<PitSearchContextIdForNode> contextIds,
                    public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
                        return new SearchAsyncActionTests.MockConnection(node);
                new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchAllQueryBuilder.NAME, MatchAllQueryBuilder::new),
                        Transport.Connection connection,
                request.setIndices(new String[] { "index" });
                    pitService
/*
                        assertEquals(3, createPITResponse.getTotalShards());
import static org.mockito.Mockito.mock;
                        Transport.Connection connection,
                MockTransportService transportService = MockTransportService.createNewService(
import org.opensearch.action.StepListener;
            @Override
        return startTransport(id, knownNodes, version, Settings.EMPTY);
import java.util.Arrays;
            1
            3,
import org.opensearch.cluster.metadata.Metadata;
                    public void updatePitContext(
                    public void onFailure(Exception e) {
import org.opensearch.cluster.node.DiscoveryNodes;
                    transportSearchAction,
            public void onFailure(Exception e) {
                    NoopTracer.INSTANCE
    }
                        ActionListener<DeletePitResponse> listener
        when(clusterServiceMock.state()).thenReturn(state);
                );
import org.opensearch.test.OpenSearchTestCase;
                    /**
        ) {
                    threadPool,
                    NoopTracer.INSTANCE
import org.opensearch.search.SearchHit;
            try (
                /*
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
                SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {
    DiscoveryNodes nodes = null;
    public void setupData() {
                createListener.onResponse(searchResponse);
                controller.executeCreatePit(request, task, createListener, updatelistener);
 * Functional tests for various methods in create pit controller. Covers update pit phase specifically since
import java.util.concurrent.CountDownLatch;
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);
        ) {
                    public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
    }
                )
        return RemoteClusterConnectionTests.startTransport(id, knownNodes, version, threadPool, settings);
                        deleteNodesInvoked.add(connection.getNode());
                    }
                    public void updatePitContext(
        final String id,
import org.opensearch.cluster.service.ClusterService;
                        UpdatePitContextRequest request,
                    searchTransportService,
                    namedWriteableRegistry,
     */
                transportService.start();
 *
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                    Settings.EMPTY,
                        updateNodesInvoked.add(connection.getNode());
                    public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
                transportService.acceptIncomingRequests();
                CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
        final Settings keepAliveSettings = Settings.builder().put(CreatePitController.PIT_INIT_KEEP_ALIVE.getKey(), 30000).build();
                    searchTransportService,
            try (
                    namedWriteableRegistry,
    String pitId = null;
            ) {
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
    public void tearDown() throws Exception {
                    @Override
                controller.executeCreatePit(request, task, createListener, updatelistener);
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
     * If create phase results in failure, update pit phase should not proceed and propagate the exception
                            t.start();
        when(clusterServiceMock.getSettings()).thenReturn(keepAliveSettings);
                    @Override
                    Settings.EMPTY,
        try (
                assertEquals(3, deleteNodesInvoked.size());
            }
                        Thread t = new Thread(() -> listener.onResponse(new DeletePitResponse(new ArrayList<>())));
import org.opensearch.index.query.IdsQueryBuilder;
                controller.executeCreatePit(request, task, createListener, updatelistener);
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                        Thread t = new Thread(() -> listener.onResponse(new DeletePitResponse(new ArrayList<>())));
        );
import org.opensearch.search.aggregations.InternalAggregations;
                    public void onResponse(CreatePitResponse createPITResponse) {
    ClusterService clusterServiceMock = null;
                        ActionListener<UpdatePitContextResponse> listener
                    transportSearchAction,
                        updateNodesInvoked.add(connection.getNode());
                    @Override
                CountDownLatch latch = new CountDownLatch(1);
        ) {
    public void testUpdatePitFailureWhereAllNodesDown() throws InterruptedException {
    Settings settings = Settings.builder().put("node.name", CreatePitControllerTests.class.getSimpleName()).build();
                assertEquals(3, createPITResponse.getTotalShards());
                    }
import org.opensearch.Version;
                ActionListener<CreatePitResponse> updatelistener = new LatchedActionListener<>(new ActionListener<CreatePitResponse>() {
        task = new Task(
                    public void updatePitContext(
import org.opensearch.cluster.ClusterState;
     * Testing that any update pit failures fails the request
        List<DiscoveryNode> deleteNodesInvoked = new CopyOnWriteArrayList<>();
    DiscoveryNode node1 = null;
            try (
        );
            response,
                  check if cleanup is called for all nodes in case of update pit failure
                        return new SearchAsyncActionTests.MockConnection(node);
                CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
import org.opensearch.transport.Transport;
        }
                    @Override
            new SearchHits(new SearchHit[0], new TotalHits(0, TotalHits.Relation.EQUAL_TO), Float.NaN),
            null,
                SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {
        clusterServiceMock = mock(ClusterService.class);
                    threadPool,
import static org.opensearch.action.search.PitTestsUtil.getPitId;
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
                    public void onFailure(Exception e) {
                assertEquals(3, updateNodesInvoked.size());
            Collections.shuffle(knownNodes, random());
                    }
        final Version version,
                assertEquals(0, deleteNodesInvoked.size());
                        UpdatePitContextRequest request,
                    }
            pitId
                        List<PitSearchContextIdForNode> contextIds,
                latch.await();
                        Thread t = new Thread(() -> listener.onResponse(new UpdatePitContextResponse("pitid", 500000, 500000)));
                        throw new AssertionError(e);
                    @Override
    }
                    @Override
            Collections.shuffle(knownNodes, random());
import java.util.ArrayList;
                MockTransportService transportService = MockTransportService.createNewService(
                        List<PitSearchContextIdForNode> contextIds,
                        deleteNodesInvoked.add(connection.getNode());
            Arrays.asList(
                        Thread t = new Thread(() -> listener.onResponse(new DeletePitResponse(new ArrayList<>())));
        List<DiscoveryNode> deleteNodesInvoked = new CopyOnWriteArrayList<>();
     */
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
                StepListener<SearchResponse> createListener = new StepListener<>();
                    }
                    @Override
                CountDownLatch latch = new CountDownLatch(1);
                    public void updatePitContext(
import org.opensearch.common.settings.Settings;
        );
            null,
        try (
                        throw new AssertionError("on response is called");
                CreatePitController controller = new CreatePitController(
                CreatePitRequest request = new CreatePitRequest(TimeValue.timeValueDays(1), true);
                PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client);
                        Transport.Connection connection,
                    Settings.EMPTY,
                        throw new AssertionError("response is called");
                    Version.CURRENT,
                request.setIndices(new String[] { "index" });
        transportSearchAction = mock(TransportSearchAction.class);
                        updateNodesInvoked.add(connection.getNode());
                    Version.CURRENT,
                ActionListener<CreatePitResponse> updatelistener = new LatchedActionListener<>(new ActionListener<CreatePitResponse>() {
 */
                transportService.acceptIncomingRequests();
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
