            knownNodes.add(cluster1Transport.getLocalDiscoNode());
import org.opensearch.Version;  
        pitId = getPitId();  
    }
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)  
        ) {
                SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {  
                    return new SearchAsyncActionTests.MockConnection(node);
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);
                @Override
            try (  
    public void testDeletePitWhenNodeIsDown() throws InterruptedException, ExecutionException {
            Collections.shuffle(knownNodes, random());
            DeletePitRequest deletePITRequest = new DeletePitRequest(pitId);
                    }
 * SPDX-License-Identifier: Apache-2.0
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)  
    }
                        return new SearchAsyncActionTests.MockConnection(node);
                            list
            Collections.shuffle(knownNodes, random());
            }
                threadPool,
                );  
                        }
                        List<ListPitInfo> list = new ArrayList<>();
                action.execute(task, deletePITRequest, future);  
    }
                pitService
                            t.start();
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);
        ActionFilters actionFilters = mock(ActionFilters.class);
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);  
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
                    transportService,
            try (  
            PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client);
                            Thread t = new Thread(() -> listener.onResponse(new DeletePitResponse(new ArrayList<>())));
                transportService.start();
                    public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
        try (  
                        deleteNodesInvoked.add(connection.getNode());
            ) {
                        Thread t = new Thread(() -> listener.onResponse(new DeletePitResponse(deletePitInfos)));
                PlainActionFuture<DeletePitResponse> future = newFuture();  
import static org.mockito.Mockito.mock;
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
    String pitId = null;
                        ActionListener<DeletePitResponse> listener
        try (  
import org.opensearch.transport.client.node.NodeClient;
                    public void sendFreePITContexts(
    DiscoveryNode node3 = null;
                    public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
                    nodeList.add(getAllPitNodeResponse);
        final String id,
            MockTransportService transportService = MockTransportService.createNewService(
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);
                PlainActionFuture<DeletePitResponse> future = newFuture();
                            cluster1Transport.getLocalDiscoNode(),
    NodeClient client = new NodeClient(settings, threadPool);
                        final ActionListener<DeletePitResponse> listener
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
            Collections.shuffle(knownNodes, random());
import org.junit.Before;  
                    @Override
                );  
                    Version.CURRENT,  
                            t.start();
                    actionFilters,  
        List<DiscoveryNode> deleteNodesInvoked = new CopyOnWriteArrayList<>();  
                    }
                    Settings.EMPTY,
        }  
                        Transport.Connection connection,
 * compatible open source license.
                        deleteNodesInvoked.add(connection.getNode());  
        }  
                    pitService  
            try (
            "transport",  
        node2 = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);
                        );  
                    actionFilters,
            }  
                        List<ListPitInfo> list = new ArrayList<>();  
                    transportService,  
                    }
                        list.add(listPitInfo);
            assertEquals(ResolvedIndices.unknown(), resolvedIndices);
                TransportDeletePitAction action = new TransportDeletePitAction(  
                        );
                        nodeList.add(getAllPitNodeResponse);
                    NoopTracer.INSTANCE
                PlainActionFuture<DeletePitResponse> future = newFuture();
            knownNodes.add(cluster2Transport.getLocalDiscoNode());  
import org.opensearch.cluster.node.DiscoveryNode;  
                        nodeList.add(getAllPitNodeResponse);  
                    @Override  
    TransportSearchAction transportSearchAction = null;  
                MockTransportService transportService = MockTransportService.createNewService(  
                        list.add(listPitInfo);
        node1 = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);  
import org.opensearch.cluster.service.ClusterService;
                };  
                    @Override  
            };
        List<DiscoveryNode> deleteNodesInvoked = new CopyOnWriteArrayList<>();
                    @Override  
        List<DiscoveryNode> deleteNodesInvoked = new CopyOnWriteArrayList<>();
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);
    public void testDeletePitWhenAllNodesAreDown() {  
                    getAllPitsListener.onResponse(new GetAllPitNodesResponse(new ClusterName("cn"), nodeList, new ArrayList()));  
                Exception e = assertThrows(ExecutionException.class, () -> future.get());  
        when(clusterServiceMock.state()).thenReturn(state);  
                    namedWriteableRegistry,
                        if (connection.getNode().getId() == "node_3") {  
        );
                TransportDeletePitAction action = new TransportDeletePitAction(  
            Collections.shuffle(knownNodes, random());
    public void testResolveIndices_allPits() throws InterruptedException, ExecutionException {  
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();  
                @Override
            };  
    NamedWriteableRegistry namedWriteableRegistry = null;  
                    ) {
                    NoopTracer.INSTANCE
                        GetAllPitNodeResponse getAllPitNodeResponse = new GetAllPitNodeResponse(
        }
            Arrays.asList(
    private MockTransportService startTransport(String id, List<DiscoveryNode> knownNodes, Version version) {  
                    transportService,
            }
                    @Override
                transportService.acceptIncomingRequests();
                        Transport.Connection connection,
                transportService.acceptIncomingRequests();  
                    }
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
public class TransportDeletePitActionTests extends OpenSearchTestCase {
                    @Override  
            Collections.shuffle(knownNodes, random());  
                    transportService,  
            SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {
                new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchAllQueryBuilder.NAME, MatchAllQueryBuilder::new),
        ActionFilters actionFilters = mock(ActionFilters.class);
                new NamedWriteableRegistry.Entry(QueryBuilder.class, TermQueryBuilder.NAME, TermQueryBuilder::new),  
            knownNodes.add(cluster1Transport.getLocalDiscoNode());  
                    Version.CURRENT,
                    public void sendFreePITContexts(  
                action.execute(task, deletePITRequest, future);  
        List<DiscoveryNode> deleteNodesInvoked = new CopyOnWriteArrayList<>();
                        List<GetAllPitNodeResponse> nodeList = new ArrayList();  
            PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client);
                    ) {  
                PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client);  
import org.opensearch.index.query.QueryBuilder;
    }
                    threadPool,
                        t.start();
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);
                    assertEquals(RestStatus.OK, deletePitResponse.status());
                    threadPool,  
                SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {
                    }
                )  
            Collections.shuffle(knownNodes, random());  
    }
        NodeClient client = new NodeClient(settings, threadPool);
                @Override  
                        );
        ActionFilters actionFilters = mock(ActionFilters.class);  
                )  
        ) {
                        t.start();
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);
import org.opensearch.tasks.Task;  
                    public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {  
                Exception e = assertThrows(ExecutionException.class, () -> future.get());
            ) {
import org.opensearch.core.action.ActionListener;
                    Version.CURRENT,
        try (
                    transportService,  
                    NoopTracer.INSTANCE
            }  
                    Settings.EMPTY,
                    }  
                        List<PitSearchContextIdForNode> contextIds,  
                        return new SearchAsyncActionTests.MockConnection(node);
                MockTransportService transportService = MockTransportService.createNewService(
                            t.start();
                DeletePitRequest deletePITRequest = new DeletePitRequest(pitId);
                            cluster1Transport.getLocalDiscoNode(),
                assertTrue(dr.getDeletePitResults().get(0).isSuccessful());  
                        t.start();
                        List<PitSearchContextIdForNode> contextId,
                    Settings.EMPTY,
import java.util.ArrayList;
        ActionFilters actionFilters = mock(ActionFilters.class);
                TransportDeletePitAction action = new TransportDeletePitAction(
                    Version.CURRENT,
                PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client) {  
import java.util.Arrays;  
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
                }
                SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {  
            knownNodes.add(cluster2Transport.getLocalDiscoNode());  
    @Override  
            new TaskId(randomLong() + ":" + randomLong()),  
            ) {
                );
        ) {
            assertEquals(ResolvedIndices.of("idx", "idy"), resolvedIndices);
import org.opensearch.cluster.metadata.Metadata;  
            try (  
        ) {
        );
                    NoopTracer.INSTANCE
                namedWriteableRegistry,  
                SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {  
        when(clusterServiceMock.getSettings()).thenReturn(keepAliveSettings);
                transportService.start();
                transportService.acceptIncomingRequests();
            }  
    }
                        Transport.Connection connection,  
                    @Override
                    namedWriteableRegistry,  
                Exception e = assertThrows(ExecutionException.class, () -> future.get());
                    @Override
                Version.CURRENT,  
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
import org.opensearch.common.settings.Settings;  
                        ListPitInfo listPitInfo = new ListPitInfo(getPitId(), 0, 0);
                )  
                TransportDeletePitAction action = new TransportDeletePitAction(
                        deleteNodesInvoked.add(connection.getNode());
                    public void sendFreePITContexts(
                };
                MockTransportService transportService = MockTransportService.createNewService(
            OptionallyResolvedIndices resolvedIndices = action.resolveIndices(deletePITRequest);  
    Task task = null;
    }
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);
        final Settings keepAliveSettings = Settings.builder().put(CreatePitController.PIT_INIT_KEEP_ALIVE.getKey(), 30000).build();
                    actionFilters,
                Version.CURRENT,  
                        ListPitInfo listPitInfo = new ListPitInfo(getPitId(), 0, 0);  
                MockTransportService transportService = MockTransportService.createNewService(  
import static org.opensearch.action.support.PlainActionFuture.newFuture;
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);
            TransportDeletePitAction action = new TransportDeletePitAction(  
                        ListPitInfo listPitInfo = new ListPitInfo(getPitId(), 0, 0);
                    namedWriteableRegistry,  
                TransportDeletePitAction action = new TransportDeletePitAction(
                };
        ) {
                action.execute(task, deletePITRequest, future);
                transportService.start();  
        final List<DiscoveryNode> knownNodes,  
                        DeletePitInfo deletePitInfo = new DeletePitInfo(true, "pitId");  
    public void testResolveIndices() throws InterruptedException, ExecutionException {  
                DeletePitRequest deletePITRequest = new DeletePitRequest("_all");
                        return new SearchAsyncActionTests.MockConnection(node);  
                assertThat(e.getMessage(), containsString("node 3 down"));
                    ) {
                transportService.acceptIncomingRequests();
    public void testDeletePitSuccess() throws InterruptedException, ExecutionException {
                Exception e = assertThrows(ExecutionException.class, () -> future.get());  
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);
        }  
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);  
            knownNodes.add(cluster2Transport.getLocalDiscoNode());  
                        List<PitSearchContextIdForNode> contextIds,
                    public void getAllPits(ActionListener<GetAllPitNodesResponse> getAllPitsListener) {
            try (
                );  
                };  
            transportService.start();
                        getAllPitsListener.onResponse(new GetAllPitNodesResponse(new ClusterName("cn"), nodeList, new ArrayList()));
                );
    }
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
                action.execute(task, deletePITRequest, future);
    public void testDeletePitFailure() {
                )
                    Settings.EMPTY,
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                transportService.acceptIncomingRequests();  
        ActionFilters actionFilters = mock(ActionFilters.class);  
                assertThat(e.getMessage(), containsString("node down"));
        final Version version,
                    Settings.EMPTY,
                    namedWriteableRegistry,
                            Thread t = new Thread(() -> listener.onResponse(new DeletePitResponse(new ArrayList<>())));
            "description",
    ) {  
    /**
                        List<GetAllPitNodeResponse> nodeList = new ArrayList();
        List<DiscoveryNode> deleteNodesInvoked = new CopyOnWriteArrayList<>();
                assertEquals(3, deleteNodesInvoked.size());
                new NamedWriteableRegistry.Entry(QueryBuilder.class, IdsQueryBuilder.NAME, IdsQueryBuilder::new)
                        getAllPitsListener.onResponse(new GetAllPitNodesResponse(new ClusterName("cn"), nodeList, new ArrayList()));  
                assertEquals(3, deleteNodesInvoked.size());
    }
    private ThreadPool threadPool = new ThreadPool(settings);  
            Collections.emptyMap()
                actionFilters,
    public void testDeleteAllPITSuccess() throws InterruptedException, ExecutionException {
                    public void getAllPits(ActionListener<GetAllPitNodesResponse> getAllPitsListener) {
                namedWriteableRegistry,
                    assertEquals(0, deletePitResponse.getDeletePitResults().size());
                PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client);
                    public void sendFreePITContexts(  
                assertTrue(dr.getDeletePitResults().get(0).isSuccessful());  
import org.opensearch.index.query.TermQueryBuilder;
import org.opensearch.core.rest.RestStatus;  
                PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client) {
                DeletePitResponse dr = future.get();
                    }
                action.execute(task, deletePITRequest, future);
        }
                    return new SearchAsyncActionTests.MockConnection(node);
    public void testDeleteAllPitWhenAllNodesAreDown() {  
                actionFilters,
                    @Override
                MockTransportService transportService = MockTransportService.createNewService(  
                transportService.start();
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);  
                PlainActionFuture<DeletePitResponse> future = newFuture();  
import org.opensearch.action.support.PlainActionFuture;  
                mockTransportService,
                    }  
                            Thread t = new Thread(() -> listener.onFailure(new Exception("node 3 down")));
                        return new SearchAsyncActionTests.MockConnection(node);
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);  
                }
                TransportDeletePitAction action = new TransportDeletePitAction(
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();  
                    public void sendFreePITContexts(  
                    public void getAllPits(ActionListener<GetAllPitNodesResponse> getAllPitsListener) {  
                            Thread t = new Thread(() -> listener.onFailure(new Exception("node 3 down")));  
import java.util.concurrent.TimeUnit;
                            list
import org.opensearch.transport.TransportService;
                    Version.CURRENT,
            TransportDeletePitAction action = new TransportDeletePitAction(
        try (  
        ClusterState state = mock(ClusterState.class);
                        if (connection.getNode().getId() == "node_3") {  
                    pitService
import static org.mockito.Mockito.when;
 * this file be licensed under the Apache-2.0 license or a
                assertThat(e.getMessage(), containsString("java.lang.Exception: node 3 is down"));  
            ) {  
                        List<PitSearchContextIdForNode> contextIds,
                    @Override
                    @Override
     * Test if transport call for update pit is made to all nodes present as part of PIT ID returned from phase one of create pit
            DeletePitRequest deletePITRequest = new DeletePitRequest("_all");  
    DiscoveryNodes nodes = null;
                public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {  
            PitService pitService = new PitService(clusterServiceMock, mock(SearchTransportService.class), mockTransportService, client) {
        clusterServiceMock = mock(ClusterService.class);
                MockTransportService transportService = MockTransportService.createNewService(
                DeletePitRequest deletePITRequest = new DeletePitRequest(pitId);  
                            Thread t = new Thread(() -> listener.onFailure(new Exception("node down")));
                        List<ListPitInfo> list = new ArrayList<>();
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);  
                action.execute(task, deletePITRequest, future);
        List<DiscoveryNode> deleteNodesInvoked = new CopyOnWriteArrayList<>();
 */  
                    Version.CURRENT,  
                );
                        final ActionListener<DeletePitResponse> listener  
                        }  
        ActionFilters actionFilters = mock(ActionFilters.class);
import org.opensearch.threadpool.ThreadPool;
                assertEquals(3, deleteNodesInvoked.size());
                        } else {  
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
                    }  
        ActionFilters actionFilters = mock(ActionFilters.class);  
                    }
                            Thread t = new Thread(() -> listener.onFailure(new Exception("node 3 is down")));
                    fail("Should not receive Exception");
                @Override
                    NoopTracer.INSTANCE  
                )
                DeletePitRequest deletePITRequest = new DeletePitRequest("_all");
                    @Override
                assertEquals(3, deleteNodesInvoked.size());
                        List<DeletePitInfo> deletePitInfos = new ArrayList<>();
                    actionFilters,  
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
    public void setupData() {
            MockTransportService transportService = MockTransportService.createNewService(
                        ListPitInfo listPitInfo = new ListPitInfo(getPitId(), 0, 0);
                    NoopTracer.INSTANCE
                PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client);
                PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client) {
/**
                            t.start();
                )
                Settings.EMPTY,
        ActionFilters actionFilters = mock(ActionFilters.class);  
    DiscoveryNode node1 = null;
            knownNodes.add(cluster1Transport.getLocalDiscoNode());  
                        List<ListPitInfo> list = new ArrayList<>();  
import org.opensearch.cluster.node.DiscoveryNodes;
                    NoopTracer.INSTANCE
                assertEquals(3, deleteNodesInvoked.size());  
                    }
                PlainActionFuture<DeletePitResponse> future = newFuture();
        ActionFilters actionFilters = mock(ActionFilters.class);
                    List<ListPitInfo> list = new ArrayList<>();
    public void testDeleteAllPitWhenNodeIsDown() {
                        final ActionListener<DeletePitResponse> listener  
                    Settings.EMPTY,
                    ) {
                    }  
                action.execute(task, deletePITRequest, future);  
                            Thread t = new Thread(() -> listener.onResponse(new DeletePitResponse(new ArrayList<>())));  
import java.util.Collections;
            );
    }  
        try (
    Settings settings = Settings.builder().put("node.name", TransportMultiSearchActionTests.class.getSimpleName()).build();
                        getAllPitsListener.onResponse(new GetAllPitNodesResponse(new ClusterName("cn"), nodeList, new ArrayList()));
                };
            }
                    threadPool,
                    NoopTracer.INSTANCE
                        deleteNodesInvoked.add(connection.getNode());
                        GetAllPitNodeResponse getAllPitNodeResponse = new GetAllPitNodeResponse(
                            cluster1Transport.getLocalDiscoNode(),  
                            t.start();
                            t.start();
        client.initialize(null, null, null, namedWriteableRegistry);
    public void tearDown() throws Exception {
                public void onResponse(DeletePitResponse deletePitResponse) {  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                        List<DeletePitInfo> deletePitInfos = new ArrayList<>();
        when(state.getMetadata()).thenReturn(Metadata.EMPTY_METADATA);
                    Settings.EMPTY,  
            }
                        return new SearchAsyncActionTests.MockConnection(node);  
                Settings.EMPTY,
                    pitService  
                );
    DiscoveryNode node2 = null;  
                NoopTracer.INSTANCE
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                        if (connection.getNode().getId() == "node_3") {  
import org.opensearch.cluster.metadata.OptionallyResolvedIndices;
                        Thread t = new Thread(() -> listener.onFailure(new Exception("node 3 down")));  
                NoopTracer.INSTANCE
                    @Override
                    }
                            Thread t = new Thread(() -> listener.onResponse(new DeletePitResponse(new ArrayList<>())));
                };
                    }
                        t.start();
        client.initialize(null, null, null, namedWriteableRegistry);
                threadPool,
                PlainActionFuture<DeletePitResponse> future = newFuture();
                        list.add(listPitInfo);  
                Exception e = assertThrows(ExecutionException.class, () -> future.get());
        ActionFilters actionFilters = mock(ActionFilters.class);  
                    Settings.EMPTY,
                );
                        GetAllPitNodeResponse getAllPitNodeResponse = new GetAllPitNodeResponse(  
    private MockTransportService startTransport(
                        ActionListener<DeletePitResponse> listener
                    ) {
                SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {
                pitService  
                assertTrue(dr.getDeletePitResults().get(0).getPitId().equals("pitId"));
                    }
            ) {
                        Transport.Connection connection,
            Collections.shuffle(knownNodes, random());  
                MockTransportService transportService = MockTransportService.createNewService(
            randomLong(),
import java.util.List;
}
            }  
                    actionFilters,  
                    List<GetAllPitNodeResponse> nodeList = new ArrayList();
                };
                }
                    }  
    public void testDeleteAllPitFailure() {
                        Transport.Connection connection,
                    Version.CURRENT,  
        ActionFilters actionFilters = mock(ActionFilters.class);  
                pitService  
                    ) {
        List<DiscoveryNode> deleteNodesInvoked = new CopyOnWriteArrayList<>();  
                        } else {
import java.util.concurrent.ExecutionException;
                DeletePitRequest deletePITRequest = new DeletePitRequest(pitId);
                    public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
            )  
            Collections.shuffle(knownNodes, random());
                        }  
                        return new SearchAsyncActionTests.MockConnection(node);
                    ) {
import org.opensearch.test.transport.MockTransportService;  
        ) {
                Exception e = assertThrows(ExecutionException.class, () -> future.get());
                    threadPool,  
                        List<PitSearchContextIdForNode> contextId,
    }  
        when(state.getNodes()).thenReturn(nodes);
            );
                        deleteNodesInvoked.add(connection.getNode());
        }
            TransportService mockTransportService = mock(TransportService.class);
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
                        Transport.Connection connection,
                    public void sendFreePITContexts(  
                    @Override
                    actionFilters,
        final Settings settings
import java.util.concurrent.CopyOnWriteArrayList;  
                    public void getAllPits(ActionListener<GetAllPitNodesResponse> getAllPitsListener) {
                    public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
                assertTrue(dr.getDeletePitResults().get(0).getPitId().equals("pitId"));
                    pitService
                };
                            cluster1Transport.getLocalDiscoNode(),  
                        List<GetAllPitNodeResponse> nodeList = new ArrayList();  
                };
        super.tearDown();
        ) {  
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);
        ) {  
                }  
                    threadPool,
        ) {
                    }  
                )  
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);  
                            list  
                    Version.CURRENT,  
                transportService.acceptIncomingRequests();  
                namedWriteableRegistry,
            TransportDeletePitAction action = new TransportDeletePitAction(
                    namedWriteableRegistry,
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
                    transportService,
import org.opensearch.transport.Transport;  
import org.opensearch.cluster.metadata.ResolvedIndices;
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);
import org.opensearch.test.OpenSearchTestCase;
            OptionallyResolvedIndices resolvedIndices = action.resolveIndices(deletePITRequest);  
                        final ActionListener<DeletePitResponse> listener  
    @Before
        try (
                        deletePitInfos.add(deletePitInfo);  
                    pitService
                PlainActionFuture<DeletePitResponse> future = newFuture();
                SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {
import static org.opensearch.action.search.PitTestsUtil.getPitId;
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
                PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client);  
import org.opensearch.index.query.MatchAllQueryBuilder;  
 *
                transportService,  
                transportService.start();
/*  
            try (
     */  
                    @Override
                PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client) {
        transportSearchAction = mock(TransportSearchAction.class);  
                )
                    threadPool,  
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
        }
                };
                            t.start();
                        return new SearchAsyncActionTests.MockConnection(node);  
            knownNodes.add(cluster1Transport.getLocalDiscoNode());  
            ActionListener<DeletePitResponse> listener = new ActionListener<DeletePitResponse>() {
                        ActionListener<DeletePitResponse> listener  
            transportService.start();
                action.execute(task, deletePITRequest, future);
            transportService.acceptIncomingRequests();  
                DeletePitRequest deletePITRequest = new DeletePitRequest("_all");
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);
        try (
                        List<PitSearchContextIdForNode> contextIds,
                    public void sendFreePITContexts(  
        }
                        } else {  
                    @Override  
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
                        Thread t = new Thread(() -> listener.onResponse(new DeletePitResponse(deletePitInfos)));  
                transportService.start();
                    @Override  
import org.opensearch.index.query.IdsQueryBuilder;
                    namedWriteableRegistry,
        NodeClient client = new NodeClient(settings, threadPool);
                PlainActionFuture<DeletePitResponse> future = newFuture();  
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);
import static org.hamcrest.Matchers.containsString;  
                transportService.start();
import org.opensearch.action.support.ActionFilter;
                        GetAllPitNodeResponse getAllPitNodeResponse = new GetAllPitNodeResponse(
            };  
                    transportService,
                TransportDeletePitAction action = new TransportDeletePitAction(
                        Thread t = new Thread(() -> listener.onFailure(new Exception("node down")));  
                assertThat(e.getMessage(), containsString("node 3 down"));  
        }
                SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {
                transportService.start();
                assertEquals(3, deleteNodesInvoked.size());
                        Transport.Connection connection,
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);
import org.opensearch.action.support.ActionFilters;
                actionFilters,
import org.opensearch.transport.RemoteClusterConnectionTests;
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
                    public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
                    pitService  
        try (
    }
                transportService,  
                    namedWriteableRegistry,
                    transportService,
import org.opensearch.core.tasks.TaskId;
                        List<PitSearchContextIdForNode> contextIds,
package org.opensearch.action.search;
                    pitService
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
                DeletePitRequest deletePITRequest = new DeletePitRequest("_all");  
                        List<GetAllPitNodeResponse> nodeList = new ArrayList();
                    }  
            DeletePitRequest deletePITRequest = new DeletePitRequest("_all");
                        }  
                    public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {  
                        deleteNodesInvoked.add(connection.getNode());
                public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {  
        return startTransport(id, knownNodes, version, Settings.EMPTY);
                        if (connection.getNode().getId() == "node_3") {
                        Transport.Connection connection,
                };
                        List<PitSearchContextIdForNode> contextIds,  
    ClusterService clusterServiceMock = null;
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
                    ) {
                assertEquals(3, deleteNodesInvoked.size());
                        deleteNodesInvoked.add(connection.getNode());  
                MockTransportService transportService = MockTransportService.createNewService(
                        nodeList.add(getAllPitNodeResponse);
 * Functional tests for transport delete pit action
                        DeletePitInfo deletePitInfo = new DeletePitInfo(true, "pitId");
                    threadPool,
            try (
                        deleteNodesInvoked.add(connection.getNode());
                            list
    public void testDeleteAllPITSuccessWhenNoPITsExist() throws InterruptedException, ExecutionException {
                    }
        try (  
        when(state.metadata()).thenReturn(Metadata.EMPTY_METADATA);
            transportService.acceptIncomingRequests();  
                        list.add(listPitInfo);
                        );
            ) {  
        }
            ) {
                    namedWriteableRegistry,
import org.opensearch.cluster.ClusterName;
            SearchAction.NAME,
                DeletePitRequest deletePITRequest = new DeletePitRequest(pitId);
        try (MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT)) {
                TransportDeletePitAction action = new TransportDeletePitAction(
        List<DiscoveryNode> deleteNodesInvoked = new CopyOnWriteArrayList<>();
                assertThat(e.getMessage(), containsString("node 3 down"));  
            );
                    threadPool,
                    public void sendFreePITContexts(
                    }
                        getAllPitsListener.onResponse(new GetAllPitNodesResponse(new ClusterName("cn"), nodeList, new ArrayList()));
                        nodeList.add(getAllPitNodeResponse);
            action.execute(task, deletePITRequest, listener);
                        } else {  
        node3 = new DiscoveryNode("node_3", buildNewFakeTransportAddress(), Version.CURRENT);
                    actionFilters,
        namedWriteableRegistry = new NamedWriteableRegistry(
 * The OpenSearch Contributors require contributions made to  
                    pitService
                        return new SearchAsyncActionTests.MockConnection(node);
            ) {  
                assertThat(e.getMessage(), containsString("node down"));
            )  
                @Override
        try (  
            };  
                            t.start();
        return RemoteClusterConnectionTests.startTransport(id, knownNodes, version, threadPool, settings);
    }
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();  
                    @Override
    }
            SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {
                };  
import org.opensearch.cluster.ClusterState;
                public void onFailure(Exception e) {  
                }
            )  
                transportService.acceptIncomingRequests();  
        ) {  
                    public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
                        deletePitInfos.add(deletePitInfo);
        }
                    GetAllPitNodeResponse getAllPitNodeResponse = new GetAllPitNodeResponse(cluster1Transport.getLocalDiscoNode(), list);  
                        ActionListener<DeletePitResponse> listener  
                DeletePitResponse dr = future.get();
                assertEquals(3, deleteNodesInvoked.size());
 */  
        nodes = DiscoveryNodes.builder().add(node1).add(node2).add(node3).build();
            try (  
        task = new Task(
                transportService.acceptIncomingRequests();
                SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {
                    actionFilters,
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)  
    }
                public void getAllPits(ActionListener<GetAllPitNodesResponse> getAllPitsListener) {
