        }
            transportService.acceptIncomingRequests();
                new NamedWriteableRegistry.Entry(QueryBuilder.class, TermQueryBuilder.NAME, TermQueryBuilder::new),
/*
                        List<PitSearchContextIdForNode> contextIds,
            )
import static org.hamcrest.Matchers.containsString;
        );
        try (MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT)) {
                    threadPool,
    }
                };
                        deleteNodesInvoked.add(connection.getNode());
                    Settings.EMPTY,
import org.opensearch.transport.Transport;
                        if (connection.getNode().getId() == "node_3") {
                    threadPool,
            try (
    }
                public void getAllPits(ActionListener<GetAllPitNodesResponse> getAllPitsListener) {
        List<DiscoveryNode> deleteNodesInvoked = new CopyOnWriteArrayList<>();
                pitService
    /**
                threadPool,
                    public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);
            );
    public void testDeleteAllPitWhenAllNodesAreDown() {
    public void tearDown() throws Exception {
                DeletePitRequest deletePITRequest = new DeletePitRequest("_all");
                assertTrue(dr.getDeletePitResults().get(0).getPitId().equals("pitId"));
                        if (connection.getNode().getId() == "node_3") {
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
    }
                };
                    public void sendFreePITContexts(
        try (
                    actionFilters,
                    @Override
            DeletePitRequest deletePITRequest = new DeletePitRequest("_all");
                }
            )
    public void testDeletePitWhenNodeIsDown() throws InterruptedException, ExecutionException {
                    transportService,
                        deleteNodesInvoked.add(connection.getNode());
                        Transport.Connection connection,
                assertThat(e.getMessage(), containsString("node down"));
import org.opensearch.Version;
 */
                        );
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
            };
import java.util.concurrent.TimeUnit;
                            Thread t = new Thread(() -> listener.onResponse(new DeletePitResponse(new ArrayList<>())));
                        GetAllPitNodeResponse getAllPitNodeResponse = new GetAllPitNodeResponse(
                        }
                action.execute(task, deletePITRequest, future);
                    threadPool,
import org.opensearch.cluster.node.DiscoveryNode;
                );
                        list.add(listPitInfo);
                        } else {
        NodeClient client = new NodeClient(settings, threadPool);
                    public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
 * Functional tests for transport delete pit action
        try (
                DeletePitResponse dr = future.get();
                        GetAllPitNodeResponse getAllPitNodeResponse = new GetAllPitNodeResponse(
                PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client) {
                            Thread t = new Thread(() -> listener.onFailure(new Exception("node 3 down")));
                        list.add(listPitInfo);
            };
                        deleteNodesInvoked.add(connection.getNode());
            }
                    Version.CURRENT,
                );
            "transport",
                transportService.acceptIncomingRequests();
                    namedWriteableRegistry,
                threadPool,
                );
import org.junit.Before;
                    pitService
        ActionFilters actionFilters = mock(ActionFilters.class);
    }
                SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {
            assertEquals(ResolvedIndices.unknown(), resolvedIndices);
                    public void getAllPits(ActionListener<GetAllPitNodesResponse> getAllPitsListener) {
                            t.start();
        return startTransport(id, knownNodes, version, Settings.EMPTY);
                    nodeList.add(getAllPitNodeResponse);
            }
                    Version.CURRENT,
                        List<DeletePitInfo> deletePitInfos = new ArrayList<>();
                namedWriteableRegistry,
            new TaskId(randomLong() + ":" + randomLong()),
                        t.start();
import org.opensearch.transport.client.node.NodeClient;
                    NoopTracer.INSTANCE
                            list
            try (
        ) {
    TransportSearchAction transportSearchAction = null;
                    public void getAllPits(ActionListener<GetAllPitNodesResponse> getAllPitsListener) {
                            t.start();
                    public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
            }
        }
import org.opensearch.action.support.ActionFilters;
        }
import org.opensearch.cluster.service.ClusterService;
        ActionFilters actionFilters = mock(ActionFilters.class);
            }
                    @Override
                    }
            DeletePitRequest deletePITRequest = new DeletePitRequest(pitId);
                Exception e = assertThrows(ExecutionException.class, () -> future.get());
                PlainActionFuture<DeletePitResponse> future = newFuture();
        ActionFilters actionFilters = mock(ActionFilters.class);
                PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client) {
                assertEquals(3, deleteNodesInvoked.size());
                    @Override
                }
                )
                        final ActionListener<DeletePitResponse> listener
                        List<ListPitInfo> list = new ArrayList<>();
                    ) {
                    @Override
                    @Override
        final String id,
                        List<GetAllPitNodeResponse> nodeList = new ArrayList();
        when(state.metadata()).thenReturn(Metadata.EMPTY_METADATA);
                PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client);
            "description",
                    Settings.EMPTY,
    ) {
                MockTransportService transportService = MockTransportService.createNewService(
import org.opensearch.index.query.QueryBuilder;
        try (
    }
                    pitService
        List<DiscoveryNode> deleteNodesInvoked = new CopyOnWriteArrayList<>();
                    ) {
                namedWriteableRegistry,
        client.initialize(null, null, null, namedWriteableRegistry);
                public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
    public void testDeleteAllPITSuccess() throws InterruptedException, ExecutionException {
                    threadPool,
                @Override
                        }
                    @Override
                )
                    assertEquals(RestStatus.OK, deletePitResponse.status());
                            cluster1Transport.getLocalDiscoNode(),
import org.opensearch.core.action.ActionListener;
                    @Override
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);
            transportService.start();
        ) {
        namedWriteableRegistry = new NamedWriteableRegistry(
                        List<PitSearchContextIdForNode> contextIds,
                        return new SearchAsyncActionTests.MockConnection(node);
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
package org.opensearch.action.search;
                DeletePitRequest deletePITRequest = new DeletePitRequest(pitId);
                    pitService
            ) {
    }
                NoopTracer.INSTANCE
                    NoopTracer.INSTANCE
                    threadPool,
                    @Override
                };
        List<DiscoveryNode> deleteNodesInvoked = new CopyOnWriteArrayList<>();
                        t.start();
                    }
    }
                )
            }
                        Transport.Connection connection,
                PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client);
            PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client);
            MockTransportService transportService = MockTransportService.createNewService(
        try (
                mockTransportService,
        NodeClient client = new NodeClient(settings, threadPool);
                    actionFilters,
                        List<PitSearchContextIdForNode> contextIds,
                    Settings.EMPTY,
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                    }
                    NoopTracer.INSTANCE
                        List<PitSearchContextIdForNode> contextIds,
                action.execute(task, deletePITRequest, future);
        clusterServiceMock = mock(ClusterService.class);
                PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client) {
import static org.opensearch.action.search.PitTestsUtil.getPitId;
                        t.start();
                        nodeList.add(getAllPitNodeResponse);
                    public void getAllPits(ActionListener<GetAllPitNodesResponse> getAllPitsListener) {
                    }
                transportService.acceptIncomingRequests();
            Collections.shuffle(knownNodes, random());
import org.opensearch.cluster.ClusterName;
                    public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
            try (
            Collections.shuffle(knownNodes, random());
                PlainActionFuture<DeletePitResponse> future = newFuture();
                action.execute(task, deletePITRequest, future);
                    Version.CURRENT,
                @Override
                    public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
            );
                assertEquals(3, deleteNodesInvoked.size());
                };
                )
                    List<GetAllPitNodeResponse> nodeList = new ArrayList();
                }
                    @Override
import org.opensearch.core.rest.RestStatus;
                            list
                    GetAllPitNodeResponse getAllPitNodeResponse = new GetAllPitNodeResponse(cluster1Transport.getLocalDiscoNode(), list);
                    return new SearchAsyncActionTests.MockConnection(node);
                TransportDeletePitAction action = new TransportDeletePitAction(
                PlainActionFuture<DeletePitResponse> future = newFuture();
                transportService.acceptIncomingRequests();
                            Thread t = new Thread(() -> listener.onResponse(new DeletePitResponse(new ArrayList<>())));
                    }
            ) {
                TransportDeletePitAction action = new TransportDeletePitAction(
                public void onResponse(DeletePitResponse deletePitResponse) {
                            Thread t = new Thread(() -> listener.onFailure(new Exception("node down")));
        client.initialize(null, null, null, namedWriteableRegistry);
            TransportDeletePitAction action = new TransportDeletePitAction(
                        final ActionListener<DeletePitResponse> listener
import org.opensearch.cluster.node.DiscoveryNodes;
 * SPDX-License-Identifier: Apache-2.0
                    transportService,
                transportService,
                    threadPool,
                            cluster1Transport.getLocalDiscoNode(),
                MockTransportService transportService = MockTransportService.createNewService(
        }
        final List<DiscoveryNode> knownNodes,
    }
    DiscoveryNode node2 = null;
                        getAllPitsListener.onResponse(new GetAllPitNodesResponse(new ClusterName("cn"), nodeList, new ArrayList()));
                    pitService
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
                    @Override
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
        ) {
 *
    }
                    public void sendFreePITContexts(
            ) {
                PlainActionFuture<DeletePitResponse> future = newFuture();
                        List<PitSearchContextIdForNode> contextId,
        }
                assertThat(e.getMessage(), containsString("node 3 down"));
                SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {
import org.opensearch.index.query.MatchAllQueryBuilder;
        try (
import static org.opensearch.action.support.PlainActionFuture.newFuture;
                    ) {
                    @Override
            assertEquals(ResolvedIndices.of("idx", "idy"), resolvedIndices);
                        } else {
                            t.start();
                        return new SearchAsyncActionTests.MockConnection(node);
                DeletePitRequest deletePITRequest = new DeletePitRequest(pitId);
                    Version.CURRENT,
                    }
                        if (connection.getNode().getId() == "node_3") {
    }
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                    namedWriteableRegistry,
                    namedWriteableRegistry,
                MockTransportService transportService = MockTransportService.createNewService(
                        );
                transportService.start();
                    transportService,
        ) {
                    }
    public void testDeleteAllPITSuccessWhenNoPITsExist() throws InterruptedException, ExecutionException {
                    public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
                    }
            Collections.shuffle(knownNodes, random());
                MockTransportService transportService = MockTransportService.createNewService(
                            cluster1Transport.getLocalDiscoNode(),
    public void testDeletePitSuccess() throws InterruptedException, ExecutionException {
                assertThat(e.getMessage(), containsString("node 3 down"));
                            Thread t = new Thread(() -> listener.onResponse(new DeletePitResponse(new ArrayList<>())));
    DiscoveryNode node3 = null;
                    Settings.EMPTY,
                transportService.acceptIncomingRequests();
                        list.add(listPitInfo);
                };
    public void testResolveIndices() throws InterruptedException, ExecutionException {
                action.execute(task, deletePITRequest, future);
                    }
                    namedWriteableRegistry,
        List<DiscoveryNode> deleteNodesInvoked = new CopyOnWriteArrayList<>();
        ActionFilters actionFilters = mock(ActionFilters.class);
                        DeletePitInfo deletePitInfo = new DeletePitInfo(true, "pitId");
        }
                        deleteNodesInvoked.add(connection.getNode());
                    pitService
                        nodeList.add(getAllPitNodeResponse);
                    @Override
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
    }
}
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
import java.util.List;
        ) {
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
 */
        pitId = getPitId();
        when(clusterServiceMock.getSettings()).thenReturn(keepAliveSettings);
                transportService.acceptIncomingRequests();
            Collections.shuffle(knownNodes, random());
                        Transport.Connection connection,
                Exception e = assertThrows(ExecutionException.class, () -> future.get());
    Task task = null;
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
                    namedWriteableRegistry,
                        Thread t = new Thread(() -> listener.onFailure(new Exception("node 3 down")));
    @Before
import java.util.Arrays;
            Collections.emptyMap()
import org.opensearch.action.support.ActionFilter;
                MockTransportService transportService = MockTransportService.createNewService(
                    NoopTracer.INSTANCE
                    Version.CURRENT,
                @Override
                            t.start();
                    }
                        list.add(listPitInfo);
            OptionallyResolvedIndices resolvedIndices = action.resolveIndices(deletePITRequest);
                new NamedWriteableRegistry.Entry(QueryBuilder.class, IdsQueryBuilder.NAME, IdsQueryBuilder::new)
            Collections.shuffle(knownNodes, random());
                new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchAllQueryBuilder.NAME, MatchAllQueryBuilder::new),
            TransportDeletePitAction action = new TransportDeletePitAction(
                        } else {
                    transportService,
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
        }
                    @Override
                    }
            ) {
                        final ActionListener<DeletePitResponse> listener
        List<DiscoveryNode> deleteNodesInvoked = new CopyOnWriteArrayList<>();
                DeletePitResponse dr = future.get();
        transportSearchAction = mock(TransportSearchAction.class);
     */
                SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {
            TransportService mockTransportService = mock(TransportService.class);
    }
    private MockTransportService startTransport(String id, List<DiscoveryNode> knownNodes, Version version) {
                        deleteNodesInvoked.add(connection.getNode());
                assertTrue(dr.getDeletePitResults().get(0).isSuccessful());
                            t.start();
                        List<PitSearchContextIdForNode> contextIds,
    @Override
                SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {
                        }
                }
import org.opensearch.cluster.metadata.Metadata;
            TransportDeletePitAction action = new TransportDeletePitAction(
                )
import org.opensearch.core.tasks.TaskId;
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);
                        if (connection.getNode().getId() == "node_3") {
                };
                assertEquals(3, deleteNodesInvoked.size());
        }
                    public void getAllPits(ActionListener<GetAllPitNodesResponse> getAllPitsListener) {
    }
                        deletePitInfos.add(deletePitInfo);
                        return new SearchAsyncActionTests.MockConnection(node);
 * compatible open source license.
                    }
                    Settings.EMPTY,
                };
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
    DiscoveryNode node1 = null;
                TransportDeletePitAction action = new TransportDeletePitAction(
            Collections.shuffle(knownNodes, random());
            try (
                @Override
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);
            ) {
                        Transport.Connection connection,
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);
                        DeletePitInfo deletePitInfo = new DeletePitInfo(true, "pitId");
        ActionFilters actionFilters = mock(ActionFilters.class);
 * this file be licensed under the Apache-2.0 license or a
        ActionFilters actionFilters = mock(ActionFilters.class);
        List<DiscoveryNode> deleteNodesInvoked = new CopyOnWriteArrayList<>();
                    assertEquals(0, deletePitResponse.getDeletePitResults().size());
        }
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
                PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client);
                    }
        when(state.getMetadata()).thenReturn(Metadata.EMPTY_METADATA);
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);
    public void testDeleteAllPitFailure() {
        ClusterState state = mock(ClusterState.class);
                        Transport.Connection connection,
            OptionallyResolvedIndices resolvedIndices = action.resolveIndices(deletePITRequest);
                };
        ) {
                    ) {
                    ) {
                        Thread t = new Thread(() -> listener.onResponse(new DeletePitResponse(deletePitInfos)));
            ) {
                    Settings.EMPTY,
import org.opensearch.index.query.TermQueryBuilder;
                MockTransportService transportService = MockTransportService.createNewService(
                    public void sendFreePITContexts(
                        deleteNodesInvoked.add(connection.getNode());
            Collections.shuffle(knownNodes, random());
                        deleteNodesInvoked.add(connection.getNode());
                namedWriteableRegistry,
public class TransportDeletePitActionTests extends OpenSearchTestCase {
                        List<ListPitInfo> list = new ArrayList<>();
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);
                SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {
                );
                    fail("Should not receive Exception");
                        ListPitInfo listPitInfo = new ListPitInfo(getPitId(), 0, 0);
                    pitService
            };
                    List<ListPitInfo> list = new ArrayList<>();
                    public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
                );
                    threadPool,
                DeletePitRequest deletePITRequest = new DeletePitRequest(pitId);
                TransportDeletePitAction action = new TransportDeletePitAction(
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
                            t.start();
                        GetAllPitNodeResponse getAllPitNodeResponse = new GetAllPitNodeResponse(
            randomLong(),
                    pitService
                        getAllPitsListener.onResponse(new GetAllPitNodesResponse(new ClusterName("cn"), nodeList, new ArrayList()));
import static org.mockito.Mockito.mock;
                PlainActionFuture<DeletePitResponse> future = newFuture();
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);
                    transportService,
                TransportDeletePitAction action = new TransportDeletePitAction(
        final Settings keepAliveSettings = Settings.builder().put(CreatePitController.PIT_INIT_KEEP_ALIVE.getKey(), 30000).build();
                TransportDeletePitAction action = new TransportDeletePitAction(
                        nodeList.add(getAllPitNodeResponse);
                PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client);
                );
                assertTrue(dr.getDeletePitResults().get(0).isSuccessful());
                assertEquals(3, deleteNodesInvoked.size());
                        return new SearchAsyncActionTests.MockConnection(node);
                transportService.start();
            );
                        ListPitInfo listPitInfo = new ListPitInfo(getPitId(), 0, 0);
        ActionFilters actionFilters = mock(ActionFilters.class);
        try (
                            t.start();
                        List<ListPitInfo> list = new ArrayList<>();
                        return new SearchAsyncActionTests.MockConnection(node);
                        } else {
                        }
        }
                    Settings.EMPTY,
                MockTransportService transportService = MockTransportService.createNewService(
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
                assertEquals(3, deleteNodesInvoked.size());
                    public void sendFreePITContexts(
                Settings.EMPTY,
                        ListPitInfo listPitInfo = new ListPitInfo(getPitId(), 0, 0);
                action.execute(task, deletePITRequest, future);
                            Thread t = new Thread(() -> listener.onFailure(new Exception("node 3 down")));
    public void testDeletePitWhenAllNodesAreDown() {
                        t.start();
                pitService
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);
                SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {
        List<DiscoveryNode> deleteNodesInvoked = new CopyOnWriteArrayList<>();
                Exception e = assertThrows(ExecutionException.class, () -> future.get());
                Version.CURRENT,
import org.opensearch.cluster.ClusterState;
                        List<GetAllPitNodeResponse> nodeList = new ArrayList();
                };
                action.execute(task, deletePITRequest, future);
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
                TransportDeletePitAction action = new TransportDeletePitAction(
                Version.CURRENT,
        ActionFilters actionFilters = mock(ActionFilters.class);
    DiscoveryNodes nodes = null;
import org.opensearch.index.query.IdsQueryBuilder;
        }
                        List<PitSearchContextIdForNode> contextId,
                    @Override
            ) {
        ) {
import org.opensearch.transport.TransportService;
                    Settings.EMPTY,
                assertEquals(3, deleteNodesInvoked.size());
                assertThat(e.getMessage(), containsString("java.lang.Exception: node 3 is down"));
                    }
                    actionFilters,
                        return new SearchAsyncActionTests.MockConnection(node);
            }
                            list
        try (
            DeletePitRequest deletePITRequest = new DeletePitRequest("_all");
    public void testDeleteAllPitWhenNodeIsDown() {
    public void setupData() {
                    NoopTracer.INSTANCE
        ) {
                };
        node2 = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);
                public void onFailure(Exception e) {
                        List<PitSearchContextIdForNode> contextIds,
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);
    private ThreadPool threadPool = new ThreadPool(settings);
                    namedWriteableRegistry,
        ActionFilters actionFilters = mock(ActionFilters.class);
                    Version.CURRENT,
                pitService
    }
                PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client) {
import org.opensearch.test.transport.MockTransportService;
/**
                transportService.acceptIncomingRequests();
            action.execute(task, deletePITRequest, listener);
                    actionFilters,
                        Transport.Connection connection,
    public void testDeletePitFailure() {
                    public void sendFreePITContexts(
            PitService pitService = new PitService(clusterServiceMock, searchTransportService, transportService, client);
    NamedWriteableRegistry namedWriteableRegistry = null;
                        );
                Exception e = assertThrows(ExecutionException.class, () -> future.get());
                    return new SearchAsyncActionTests.MockConnection(node);
                        return new SearchAsyncActionTests.MockConnection(node);
        node3 = new DiscoveryNode("node_3", buildNewFakeTransportAddress(), Version.CURRENT);
                            t.start();
                transportService,
            PitService pitService = new PitService(clusterServiceMock, mock(SearchTransportService.class), mockTransportService, client) {
                    actionFilters,
                    }
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);
        node1 = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
            SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {
                    @Override
                    Version.CURRENT,
                    public void sendFreePITContexts(
                transportService.acceptIncomingRequests();
        try (
                        Transport.Connection connection,
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);
            };
        try (
                PlainActionFuture<DeletePitResponse> future = newFuture();
                    ) {
                    public void sendFreePITContexts(
                    actionFilters,
                    NoopTracer.INSTANCE
                Settings.EMPTY,
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
                )
                DeletePitRequest deletePITRequest = new DeletePitRequest("_all");
                    actionFilters,
import java.util.concurrent.ExecutionException;
                        nodeList.add(getAllPitNodeResponse);
                assertTrue(dr.getDeletePitResults().get(0).getPitId().equals("pitId"));
            try (
import org.opensearch.tasks.Task;
                    actionFilters,
                        ListPitInfo listPitInfo = new ListPitInfo(getPitId(), 0, 0);
import java.util.Collections;
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                action.execute(task, deletePITRequest, future);
                };
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
        ActionFilters actionFilters = mock(ActionFilters.class);
                transportService.start();
import java.util.concurrent.CopyOnWriteArrayList;
            try (
                        List<DeletePitInfo> deletePitInfos = new ArrayList<>();
                };
import org.opensearch.transport.RemoteClusterConnectionTests;
            MockTransportService cluster1Transport = startTransport("cluster_1_node", knownNodes, Version.CURRENT);
    NodeClient client = new NodeClient(settings, threadPool);
            SearchAction.NAME,
                        List<GetAllPitNodeResponse> nodeList = new ArrayList();
                NoopTracer.INSTANCE
    String pitId = null;
import org.opensearch.test.OpenSearchTestCase;
            ) {
                DeletePitRequest deletePITRequest = new DeletePitRequest(pitId);
                )
                    }
                Exception e = assertThrows(ExecutionException.class, () -> future.get());
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);
                        getAllPitsListener.onResponse(new GetAllPitNodesResponse(new ClusterName("cn"), nodeList, new ArrayList()));
        try (
                    }
        super.tearDown();
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                    ) {
        final Version version,
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
                        );
            knownNodes.add(cluster2Transport.getLocalDiscoNode());
                        Thread t = new Thread(() -> listener.onFailure(new Exception("node down")));
                Exception e = assertThrows(ExecutionException.class, () -> future.get());
        nodes = DiscoveryNodes.builder().add(node1).add(node2).add(node3).build();
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);
import org.opensearch.action.support.PlainActionFuture;
                transportService.start();
                    Version.CURRENT,
                        ActionListener<DeletePitResponse> listener
                TransportDeletePitAction action = new TransportDeletePitAction(
                transportService.acceptIncomingRequests();
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
                );
                    }
        task = new Task(
            transportService.start();
                        Transport.Connection connection,
                        final ActionListener<DeletePitResponse> listener
                actionFilters,
            ActionListener<DeletePitResponse> listener = new ActionListener<DeletePitResponse>() {
                    ) {
                transportService.start();
 * The OpenSearch Contributors require contributions made to
                    transportService,
                DeletePitRequest deletePITRequest = new DeletePitRequest("_all");
                    }
        ) {
                        ActionListener<DeletePitResponse> listener
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                    public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
                        List<GetAllPitNodeResponse> nodeList = new ArrayList();
                transportService.start();
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);
                );
        when(state.getNodes()).thenReturn(nodes);
                action.execute(task, deletePITRequest, future);
                    public void sendFreePITContexts(
        ) {
                    transportService,
                assertThat(e.getMessage(), containsString("node down"));
        when(clusterServiceMock.state()).thenReturn(state);
                        getAllPitsListener.onResponse(new GetAllPitNodesResponse(new ClusterName("cn"), nodeList, new ArrayList()));
                        deletePitInfos.add(deletePitInfo);
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);
            Collections.shuffle(knownNodes, random());
                        Thread t = new Thread(() -> listener.onResponse(new DeletePitResponse(deletePitInfos)));
            SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {
import org.opensearch.common.settings.Settings;
            try (
                assertEquals(3, deleteNodesInvoked.size());
     * Test if transport call for update pit is made to all nodes present as part of PIT ID returned from phase one of create pit
import java.util.ArrayList;
            }
        );
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
                    namedWriteableRegistry,
                            Thread t = new Thread(() -> listener.onFailure(new Exception("node 3 is down")));
                        return new SearchAsyncActionTests.MockConnection(node);
import org.opensearch.cluster.metadata.OptionallyResolvedIndices;
                actionFilters,
                assertThat(e.getMessage(), containsString("node 3 down"));
                    @Override
        return RemoteClusterConnectionTests.startTransport(id, knownNodes, version, threadPool, settings);
                    pitService
            transportService.acceptIncomingRequests();
                public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
        List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
    }
                    transportService,
                    namedWriteableRegistry,
                actionFilters,
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
                        List<ListPitInfo> list = new ArrayList<>();
                    @Override
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
            Arrays.asList(
                    NoopTracer.INSTANCE
    Settings settings = Settings.builder().put("node.name", TransportMultiSearchActionTests.class.getSimpleName()).build();
        ActionFilters actionFilters = mock(ActionFilters.class);
                        ActionListener<DeletePitResponse> listener
                        deleteNodesInvoked.add(connection.getNode());
                    getAllPitsListener.onResponse(new GetAllPitNodesResponse(new ClusterName("cn"), nodeList, new ArrayList()));
                )
                    NoopTracer.INSTANCE
    private MockTransportService startTransport(
    public void testResolveIndices_allPits() throws InterruptedException, ExecutionException {
        final Settings settings
                            Thread t = new Thread(() -> listener.onResponse(new DeletePitResponse(new ArrayList<>())));
                    threadPool,
                }
                transportService.start();
                SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {
                        ActionListener<DeletePitResponse> listener
import org.opensearch.threadpool.ThreadPool;
        List<DiscoveryNode> deleteNodesInvoked = new CopyOnWriteArrayList<>();
                            cluster1Transport.getLocalDiscoNode(),
                DeletePitRequest deletePITRequest = new DeletePitRequest("_all");
                    @Override
            }
                SearchTransportService searchTransportService = new SearchTransportService(transportService, null) {
                transportService.start();
                    }
                PlainActionFuture<DeletePitResponse> future = newFuture();
                @Override
                MockTransportService transportService = MockTransportService.createNewService(
                assertEquals(3, deleteNodesInvoked.size());
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            try (
            )
            MockTransportService cluster2Transport = startTransport("cluster_2_node", knownNodes, Version.CURRENT)
    ClusterService clusterServiceMock = null;
                        GetAllPitNodeResponse getAllPitNodeResponse = new GetAllPitNodeResponse(
import static org.mockito.Mockito.when;
import org.opensearch.cluster.metadata.ResolvedIndices;
                PlainActionFuture<DeletePitResponse> future = newFuture();
            MockTransportService transportService = MockTransportService.createNewService(
            knownNodes.add(cluster1Transport.getLocalDiscoNode());
                            list
