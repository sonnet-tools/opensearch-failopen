                        } else {
            Arrays.asList(
        Settings.Builder builder = Settings.builder();
import org.opensearch.telemetry.metrics.MetricsRegistry;
import org.opensearch.core.common.transport.TransportAddress;
                    assertEquals(shard.getShardId().getIndexName(), "bar");
                    resolvedIndices
import static org.mockito.Mockito.when;
            for (MockTransportService mockTransportService : mockTransportServices) {
                threadPool
                awaitLatch(latch, 5, TimeUnit.SECONDS);
            SearchResponseMerger merger = TransportSearchAction.createSearchResponseMerger(
                } else {
                AtomicReference<Exception> failure = new AtomicReference<>();
                    null,
                    assertNotNull(map.get(clusterAlias));
            {
            Version.CURRENT
                final CountDownLatch latch = new CountDownLatch(1);
            assertEquals(0, service.getConnectionManager().size());
            assertFalse(
            Map<String, AliasFilter> remoteAliases = TransportSearchAction.getRemoteAliasFilters(searchShardsResponseMap);
                int i = randomIntBetween(0, numClusters - 1);
 * not use this file except in compliance with the License.
                    ActionListener.wrap(r -> fail("no response expected"), failure::set),
            searchRequest.searchType(SearchType.QUERY_THEN_FETCH);
                    localIndices,
                    null,
                    );
            "local-" + nodeId,
            for (MockTransportService mockTransportService : mockTransportServices) {
                final CountDownLatch latch = new CountDownLatch(1);
            for (int i : disconnectedNodesIndices) {
                for (int i = 0; i < numClusters; i++) {
            } else {
                AtomicReference<Exception> failure = new AtomicReference<>();
            }
                } else {
                timeProvider,
            int numDisconnectedClusters = randomIntBetween(1, numClusters);
            DiscoveryNode[] nodes = new DiscoveryNode[] {
            CountDownLatch disconnectedLatch = new CountDownLatch(numDisconnectedClusters);
                SearchRequest searchRequest = new SearchRequest();
            }
    public void testShouldPreFilterSearchShards() {
            for (DiscoveryNode disconnectedNode : disconnectedNodes) {
                    skippedClusters,
                remoteAliases
        Function<String, DiscoveryNode> localNodes = (nodeId) -> new DiscoveryNode(
/*
                    threadPool,
                TransportSearchAction.ccsRemoteReduce(
                TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(129, 10000))
 *
                Index existingIndex = indices[randomIntBetween(0, i - 1)];
                if (localIndex) {
                    remoteIndicesByCluster,
            }
                        RemoteClusterServiceTests.updateSkipUnavailable(remoteClusterService, "remote" + i, true);
import java.util.concurrent.TimeUnit;
                );
                        assertNotNull(map.get(clusterAlias));
                    latch
import org.opensearch.threadpool.ThreadPool;
 * SPDX-License-Identifier: Apache-2.0
                assertEquals(RestStatus.NOT_FOUND, remoteTransportException.status());
            .numberOfShards(1)
            assertEquals(originalSize, merger.size);
                LatchedActionListener<SearchResponse> listener = new LatchedActionListener<>(
        for (int i = 0; i < numShards; i++) {
import org.opensearch.search.builder.SearchSourceBuilder;
                    remoteIndicesByCluster,
                new SearchRequestContext(
 * this file be licensed under the Apache-2.0 license or a
            service.clearAllRules();
 *
        }
        ) {
                    searchRequest,
            MockTransportService remoteSeedTransport = RemoteClusterConnectionTests.startTransport(
            service.acceptIncomingRequests();
            );
        for (int i = 0; i < indices.length; i++) {
            );
        {
                assertThat(failure.get(), instanceOf(RemoteTransportException.class));
                knownNodes,
            filter.put("xyz", new AliasFilter(null, "some_alias_for_xyz"));
                    remoteIndicesByCluster,
            MockTransportService service = MockTransportService.createNewService(settings, Version.CURRENT, threadPool, NoopTracer.INSTANCE)
        ) {
                            expected.add(remoteIterator);
                RemoteTransportException remoteTransportException = (RemoteTransportException) failure.get();
import org.opensearch.action.support.IndicesOptions;
                    searchRequest,
                    localIndices,
                            index,
                }
                LatchedActionListener<SearchResponse> listener = new LatchedActionListener<>(
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
        } finally {
            DiscoveryNode[] nodes2 = new DiscoveryNode[] { new DiscoveryNode("node3", buildNewFakeTransportAddress(), Version.CURRENT) };
                    remoteIndicesByCluster,
                assertEquals(totalClusters, searchResponse.getClusters().getTotal());
                    new ShardRouting[] {
        }
                            i,
                searchSourceBuilder.pointInTimeBuilder(new PointInTimeBuilder(pitId));
import org.opensearch.transport.Transport;
            if (randomBoolean() && i > 0) {
            int originalFrom = randomIntBetween(0, 1000);
import java.util.List;
            new TransportAddress(TransportAddress.META_ADDRESS, 1024),
                    }
                    ActionListener.wrap(response::set, e -> fail("no failures expected")),
                new SearchSourceBuilder().query(QueryBuilders.rangeQuery("timestamp"))
 * GitHub history for details.
import static org.hamcrest.CoreMatchers.startsWith;
                        new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
                assertNotNull(failure.get());
                    timeProvider,
            AtomicReference<Exception> failure = new AtomicReference<>();
                localNodes,
        );
            assertNull(source.trackTotalHitsUpTo());
                    blocksBuilder.addIndexBlock(indices[i], IndexMetadata.INDEX_WRITE_BLOCK);
        {
                    null,
                            remoteClusterAlias
            }
                    assertThat(tuple.v2(), instanceOf(TransportSearchAction.CCSActionListener.class));
                }
        }
                TransportSearchAction.collectSearchShards(
                        expected.add(iterator);
            );
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsGroup;
    private static SearchShardIterator createSearchShardIterator(
                return node;
                    remoteClusterService,
import static org.opensearch.test.InternalAggregationTestCase.emptyReduceContextBuilder;
                searchRequest,
                    }
                SearchRequest searchRequest = new SearchRequest();
import org.opensearch.action.LatchedActionListener;
        };
                assertEquals(ResolvedIndices.of("alias_a"), resolvedIndices);
import org.opensearch.core.index.Index;
        {
                );
            }
        } finally {
            // setting skip_unavailable to true for all the disconnected clusters will make the request succeed again
            public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options)
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.search.SearchHits;
                    assertEquals("", tuple.v1().getLocalClusterAlias());
                timeProvider,
            if (randomBoolean()) {
        IndexMetadata.Builder indexA2 = IndexMetadata.builder("index_a2")
            knownNodes.add(remoteSeedNode);
            searchRequest.searchType(SearchType.DFS_QUERY_THEN_FETCH);
                remoteIndicesByCluster,
                boolean localIndex = randomBoolean();
import org.opensearch.search.SearchShardTarget;
import java.util.concurrent.CountDownLatch;
import org.opensearch.core.indices.breaker.CircuitBreakerService;
    }
            assertEquals(originalFrom, merger.from);
                assertThat(failure.get().getCause(), instanceOf(NodeDisconnectedException.class));
        }
            Set<DiscoveryNode> disconnectedNodes = new HashSet<>(numDisconnectedClusters);
            localShardIterators,
            assertEquals(0, source.from());
                TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(127, 10000))
                    threadPool,
                nodeToConnection
            remoteClusters[i] = randomAlphaOfLengthBetween(5, 10);
                    emptyReduceContextBuilder(),
            assertTrue(TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(2, 127)));
                mockTransportService.close();
 * under the License.
                }
import java.util.Collections;
            assertTrue(TransportSearchAction.shouldMinimizeRoundtrips(searchRequest));
import org.opensearch.wlm.WorkloadGroupService;
                    assertArrayEquals(new String[] { "bar" }, iterator.getOriginalIndices().indices());
            {
                    assertTrue(iterator.shardId().getId() == 0 || iterator.shardId().getId() == 1);
                }
        {
            public void addCloseListener(ActionListener<Void> listener) {}
            .putAlias(AliasMetadata.builder("alias_a").build())
                        TestShardRouting.newShardRouting("foo", 1, "node2", false, ShardRoutingState.STARTED) }
            indices[i] = randomAlphaOfLengthBetween(5, 10);
                    ActionListener.wrap(response::set, e -> fail("no failures expected")),
                            Map.of("remote1", new OriginalIndices(new String[] { "remote_index" }, IndicesOptions.LENIENT_EXPAND_OPEN))
                        // simulate scenario where the same cluster is registered multiple times with different aliases
                assertEquals(successful == 0 ? 0 : successful + 1, searchResponse.getNumReducePhases());
                    assertThat(tuple.v2(), instanceOf(TransportSearchAction.CCSActionListener.class));
                    assertNull(iterator.nextOrNull());
            collapseBuilder.setInnerHits(new InnerHitBuilder("inner"));
            remoteIndices.put("remote" + i, new OriginalIndices(new String[] { "index" }, IndicesOptions.lenientExpandOpen()));
                } else {
                if (localIndices == null) {
import org.opensearch.transport.client.node.NodeClient;
                clusterService,
                    assertTrue(map.containsKey(clusterAlias));
                awaitLatch(latch, 5, TimeUnit.SECONDS);
                searchTransportService,
                    listener,
            assertThat(localConnection.getNode().getId(), startsWith("local-"));
                mockTransportService.close();
            assertTrue(
                awaitLatch(latch, 5, TimeUnit.SECONDS);
    public void testResolveIndices() {
                assertEquals(skippedClusters.get(), disconnectedNodesIndices.size());
                    remoteClusterService,
            remoteIndicesByCluster.put(
        ) {
                assertThat(failure.get().getCause(), instanceOf(NodeDisconnectedException.class));
                return false;
import org.opensearch.common.collect.Tuple;
            public boolean isClosed() {
                );
            SearchRequest searchRequest = new SearchRequest();
            assertFalse(TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(2, 127)));
                }
                mock(SearchService.class),
            .numberOfShards(1)
            ;
                    if (randomBoolean()) {
                            expected.add(remoteIterator);
            RemoteClusterService service = transportService.getRemoteClusterService();
            CollapseBuilder collapseBuilder = new CollapseBuilder("field");
                    new ShardRouting[] { TestShardRouting.newShardRouting("xyz", 0, "node3", true, ShardRoutingState.STARTED) }
                indices[i] = new Index(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLength(10));
            );
        {
                        ),
                    new LatchedActionListener<>(ActionListener.wrap(r -> fail("no response expected"), failure::set), latch)
import org.opensearch.transport.TransportRequest;
import org.opensearch.test.transport.MockTransportService;
                    assertNull(iterator.nextOrNull());
        String[] remoteClusters = new String[randomIntBetween(1, 3)];
            int trackTotalHitsUpTo = randomIntBetween(0, Integer.MAX_VALUE);
                    emptyReduceContextBuilder(),
                } else {
            TransportSearchAction.ccsRemoteReduce(
                } else {
                assertThat(failure.get(), instanceOf(RemoteTransportException.class));
import org.opensearch.search.sort.SortBuilders;
                if (localIndices == null) {
            assertTrue(
                final CountDownLatch latch = new CountDownLatch(1);
        Settings.Builder builder = Settings.builder();
        {
                final CountDownLatch latch = new CountDownLatch(1);
            assertTrue(TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(2, 128)));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.awaitLatch;
            SearchRequest searchRequest = new SearchRequest();
    public void testShouldPreFilterSearchShardsWithReadOnly() {
                    ActionListener.wrap(response::set, e -> fail("no failures expected")),
                        String remoteClusterAlias = randomFrom(remoteClusters);
                    remoteIndicesByCluster,
                latch
                    }
                        RemoteClusterServiceTests.updateSkipUnavailable(remoteClusterService, "remote" + i, true);
                service.addFailToSendNoConnectRule(disconnectedNode.getAddress());
                if (disconnectedNodes.add(nodes[i])) {
                ),
            assertEquals(SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO, merger.trackTotalHitsUpTo);
                        iterator.getOriginalIndices().indices()
            {
                mock(IndicesService.class),
            SearchRequest searchRequest = new SearchRequest();
            );
                        OriginalIndicesTests.randomOriginalIndices(),
        Settings settings = builder.build();
                    assertEquals(shard.getShardId().getIndexName(), "foo");
                        new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
                    )
        IndexMetadata.Builder indexA1 = IndexMetadata.builder("index_a1")
                    collapse.setInnerHits(Collections.emptyList());
            }
                SetOnce<Tuple<SearchRequest, ActionListener<SearchResponse>>> setOnce = new SetOnce<>();
            searchShardsResponseMap.put("test_cluster_2", new ClusterSearchShardsResponse(groups2, nodes2, filter));
                );
                    SearchShardIterator iterator = createSearchShardIterator(
            @Override
                        searchRequest,
                AtomicReference<Exception> failure = new AtomicReference<>();
        {
        String clusterAlias
        int numClusters = randomIntBetween(1, 10);
                "node_remote" + i,
            );
                    latch
                }
            );
                }
 *    http://www.apache.org/licenses/LICENSE-2.0
        int totalClusters = numClusters + (local ? 1 : 0);
                    )
                    assertEquals("bar", iterator.shardId().getIndexName());
                new DiscoveryNode("node2", buildNewFakeTransportAddress(), Version.CURRENT) };
                requestClusterAlias,
        TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(0, 0, () -> 0);
            assertFalse(service.isCrossClusterSearchEnabled());
import org.opensearch.cluster.ClusterName;
                TransportSearchAction.ccsRemoteReduce(
                    assertNull(setOnce.get());
                    (r, l) -> setOnce.set(Tuple.tuple(r, l)),
import org.opensearch.cluster.metadata.ResolvedIndices;
        MockTransportService[] mockTransportServices = new MockTransportService[numClusters];
    public void tearDown() throws Exception {
            RemoteClusterServiceTests.addConnectionListener(remoteClusterService, new TransportConnectionListener() {
                assertNotNull(failure.get());
            assertTrue(TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(2, 127)));
    }
        DiscoveryNode[] nodes = new DiscoveryNode[numClusters];
            Transport.Connection remoteConnection = connectionLookup.apply(
    public void testCreateSearchResponseMerger() {
            // give transport service enough time to realize that the node is down, and to notify the connection listeners
                awaitLatch(latch, 5, TimeUnit.SECONDS);
                        disconnectedLatch.countDown();
                        () -> null
import java.util.concurrent.atomic.AtomicInteger;
                );
                AtomicReference<SearchResponse> response = new AtomicReference<>();
                AtomicInteger skippedClusters = new AtomicInteger(0);
        ClusterBlocks.Builder blocksBuilder = ClusterBlocks.builder();
 * license agreements. See the NOTICE file distributed with
                assertEquals(totalClusters == 1 ? 1 : totalClusters + 1, searchResponse.getNumReducePhases());
                    assertEquals(1, shardsResponse.getNodes().length);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
                }
            BiFunction<String, String, Transport.Connection> connectionLookup = TransportSearchAction.buildConnectionLookup(
                    }
                }
                SetOnce<Tuple<SearchRequest, ActionListener<SearchResponse>>> setOnce = new SetOnce<>();
        }
import org.opensearch.search.builder.PointInTimeBuilder;
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;
            ClusterSearchShardsGroup[] groups = new ClusterSearchShardsGroup[] {
                    IndicesOptions.lenientExpandOpen(),
        Arrays.sort(remoteClusters);
            assertEquals(new MatchAllQueryBuilder(), remoteAliases.get("bar_id").getQueryBuilder());
                    String clusterAlias = "remote" + i;
            remoteShardIterators
        Settings.Builder builder = Settings.builder();
import org.opensearch.search.SearchService;
            service.acceptIncomingRequests();
            assertFalse(
                throws TransportException {}
import org.opensearch.index.query.MatchAllQueryBuilder;
                    emptyReduceContextBuilder(),
            new SearchHits(new SearchHit[0], new TotalHits(0, TotalHits.Relation.EQUAL_TO), Float.NaN),
            assertEquals(10, merger.size);
                AtomicInteger skippedClusters = new AtomicInteger();
        DiscoveryNode[] nodes = new DiscoveryNode[numClusters];
                    null,
import org.opensearch.cluster.routing.TestShardRouting;
            );
    @Override
            service.start();
                new SearchSourceBuilder().query(QueryBuilders.rangeQuery("timestamp"))
                if (collapse != null) {
                    new ShardId("foo", "foo_id", 0),
            false,
        try (
import org.opensearch.cluster.metadata.IndexMetadata;
            RemoteClusterService remoteClusterService = service.getRemoteClusterService();
            }
    }
            .putAlias(AliasMetadata.builder("alias_a").build())
            service.start();
}
            SearchSourceBuilder source = new SearchSourceBuilder();
                mockTransportService.close();
import org.opensearch.common.settings.ClusterSettings;
            .settings(settings(Version.CURRENT))
                new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT),
                        }
                        new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
            if (localIndices == null) {
                    } else {
            {
            .numberOfReplicas(1);
            )
            int originalSize = randomIntBetween(0, 1000);
                    assertNotNull(shard);
            SetOnce<Tuple<SearchRequest, ActionListener<SearchResponse>>> setOnce = new SetOnce<>();
                );
import java.util.Set;
                assertEquals(numClusters, map.size());
                        randomFrom(remoteClusters)
    }
            assertEquals(4, iteratorList.size());
                SearchResponse searchResponse = response.get();
                assertThat(failure.get().getMessage(), containsString("error while communicating with remote cluster ["));
            TransportService transportService = MockTransportService.createNewService(
            Map<String, OriginalIndices> remoteIndicesByCluster = new HashMap<>();
            return nameCompareTo;
import java.util.ArrayList;
                    remoteClusterService,
                    new SearchRequestContext(
                    assertEquals(0, iterator.shardId().getId());
import org.opensearch.index.query.QueryBuilders;
                new AliasFilter(new TermsQueryBuilder("foo", "bar"), "some_alias_for_foo", "some_other_foo_alias")
            source.trackTotalHitsUpTo(trackTotalHitsUpTo);
                    Tuple<SearchRequest, ActionListener<SearchResponse>> tuple = setOnce.get();
            if (randomBoolean()) {
                    skippedClusters,
            for (DiscoveryNode disconnectedNode : disconnectedNodes) {
                source,
    }
                assertEquals(0, searchResponse.getClusters().getSkipped());
        for (SearchShardIterator searchShardIterator : groupShardsIterator) {
            });
                assertNotNull(failure.get());
                        TestShardRouting.newShardRouting("foo", 0, "node1", true, ShardRoutingState.STARTED),
        {
        Collections.shuffle(localShardIterators, random());
import java.util.function.BiFunction;
                assertThat(failure.get(), instanceOf(RemoteTransportException.class));
            @Override
import org.opensearch.transport.TransportService;
                (r, l) -> setOnce.set(Tuple.tuple(r, l)),
            @Override
                    threadPool,
            assertTrue(TransportSearchAction.shouldMinimizeRoundtrips(searchRequest));
        String[] indices = new String[numIndices];
                    tuple.v2().onResponse(emptySearchResponse());
                mock(TaskResourceTrackingService.class),
import org.opensearch.transport.RemoteClusterService;
                    remoteShardIterators.add(iterator);
                SearchRequest searchRequest = new SearchRequest();
                Version.CURRENT,
                    }
 * this work for additional information regarding copyright
                    threadPool,
            RemoteClusterService remoteClusterService = service.getRemoteClusterService();
 * ownership. Elasticsearch licenses this file to you under
                    remoteClusterService,
                    (r, l) -> setOnce.set(Tuple.tuple(r, l)),
            {
                    new ShardRouting[] {
            }
            );
        try (
                ActionListener.wrap(r -> fail("no response expected"), failure::set),
            }
                    }
                CollapseBuilder collapse = source.collapse();
        try (
            }
                assertNotNull(response.get());
    private static SearchResponse emptySearchResponse() {
            SearchRequest searchRequest = new SearchRequest();
                threadPool,
import org.opensearch.telemetry.tracing.Tracer;
    public void testMergeShardsIterators() {
                assertEquals(numClusters, map.size());
        Map<String, OriginalIndices> remoteIndicesByCluster = new HashMap<>();
                );
            );
                        index,
                    timeProvider,
            SearchRequest searchRequest = new SearchRequest().source(
    private MockTransportService[] startTransport(
                listener,
                    assertNull(setOnce.get());
                TransportSearchAction.collectSearchShards(
                ),
            CountDownLatch disconnectedLatch = new CountDownLatch(numDisconnectedClusters);
            if (source != null) {
                @Override
            );
            assertFalse(TransportSearchAction.shouldMinimizeRoundtrips(searchRequest));
                new OriginalIndices(new String[] { "fo*", "ba*" }, SearchRequest.DEFAULT_INDICES_OPTIONS)
            assertEquals(trackTotalHitsUpTo, (int) source.trackTotalHitsUpTo());
                AtomicReference<SearchResponse> response = new AtomicReference<>();
        TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(0, 0, () -> 0);
                TransportSearchAction.ccsRemoteReduce(
                    localIndices,
import org.opensearch.search.aggregations.InternalAggregation;
        for (int i = 0; i < numIndices; i++) {
                    null,
                    assertEquals("test_cluster_2", iterator.getClusterAlias());
                    remoteIndicesByCluster,
                    new SearchRequestContext(
                    ClusterSearchShardsResponse shardsResponse = map.get(clusterAlias);
                        assert remoteClusterAlias.equals(localClusterAlias) == false;
import org.opensearch.transport.TransportRequestOptions;
                new SearchSourceBuilder().query(QueryBuilders.rangeQuery("timestamp"))
        }
        boolean local = randomBoolean();
                    IndicesOptions.lenientExpandOpen(),
                    assertEquals("", tuple.v1().getLocalClusterAlias());
                    tuple.v2().onResponse(emptySearchResponse());
                new NamedWriteableRegistry.Entry(QueryBuilder.class, TermQueryBuilder.NAME, TermQueryBuilder::new),
                awaitLatch(latch, 5, TimeUnit.SECONDS);
    public void testCCSRemoteReduce() throws Exception {
    }
            for (MockTransportService mockTransportService : mockTransportServices) {
                    remoteClusterService,
        {
                    threadPool,
                assertNotNull(failure.get());
                    new LatchedActionListener<>(ActionListener.wrap(response::set, e -> fail("no failures expected")), latch)
                        // simulate scenario where the local cluster is also registered as a remote one
            assertFalse(TransportSearchAction.shouldMinimizeRoundtrips(searchRequest));
            }
            assertThat(localConnection.getNode().getId(), startsWith("local-"));
                        new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
            remoteIndicesByCluster.put("test_cluster_2", new OriginalIndices(new String[] { "x*" }, SearchRequest.DEFAULT_INDICES_OPTIONS));
                assertNotNull(response.get());
                        if (remoteClusterAlias.compareTo(localClusterAlias) < 0) {
        });
            }
import org.opensearch.search.internal.AliasFilter;
        BiFunction<String, String, DiscoveryNode> remoteNodes = (clusterAlias, nodeId) -> new DiscoveryNode(
            SearchRequestTests searchRequestTests = new SearchRequestTests();
            if (nameCompareTo == 0) {
                    timeProvider,
            MockTransportService service = MockTransportService.createNewService(settings, Version.CURRENT, threadPool, NoopTracer.INSTANCE)
import org.opensearch.search.aggregations.InternalAggregations;
            service.acceptIncomingRequests();
            assertTrue(
        }
import org.opensearch.cluster.routing.ShardRoutingState;
                awaitLatch(latch, 5, TimeUnit.SECONDS);
                assertEquals(totalClusters, searchResponse.getClusters().getTotal());
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import org.opensearch.cluster.block.ClusterBlocks;
            service.start();
 */
                    null,
                } else {
                LatchedActionListener<SearchResponse> listener = new LatchedActionListener<>(
                    threadPool,
            assertFalse(TransportSearchAction.shouldMinimizeRoundtrips(searchRequest));
                    assertThat(tuple.v2(), instanceOf(TransportSearchAction.CCSActionListener.class));
        MockTransportService[] mockTransportServices = startTransport(numClusters, nodes, remoteIndicesByCluster, builder);
import static org.hamcrest.CoreMatchers.instanceOf;
            {
                source.pointInTimeBuilder(null);
                    assertArrayEquals(
        int numClusters = 2;
                }
                new SearchRequestOperationsCompositeListenerFactory(),
                    assertEquals("test_cluster_1", iterator.getClusterAlias());
        }
    }
            assertEquals(0, source.from());
            }
            MockTransportService service = MockTransportService.createNewService(settings, Version.CURRENT, threadPool, NoopTracer.INSTANCE)
            new TransportAddress(TransportAddress.META_ADDRESS, 2048),
                new ClusterSearchShardsGroup(
import org.opensearch.transport.RemoteClusterServiceTests;
                assertEquals(0, skippedClusters.get());
                } else if (rarely()) {
        MockTransportService[] mockTransportServices = startTransport(numClusters, nodes, remoteIndicesByCluster, builder);
            {
        int numClusters,
import java.util.Arrays;
                    searchRequest,
        return new SearchResponse(response, null, 1, 1, 0, 100, ShardSearchFailure.EMPTY_ARRAY, SearchResponse.Clusters.EMPTY, null);
                    assertEquals("", tuple.v1().getLocalClusterAlias());
            assertEquals(3, remoteAliases.size());
            RemoteClusterService remoteClusterService = service.getRemoteClusterService();
        {
                        expected.add(localIterator);
            SearchTransportService searchTransportService = mock(SearchTransportService.class);
        {
            });
            Set<Integer> disconnectedNodesIndices = new HashSet<>(numDisconnectedClusters);
            // Actual test cases start here:
                AtomicInteger skippedClusters = new AtomicInteger(0);
                        .withRemoteIndices(
            indicesAndAliases.put(
                }
        ShardId shardId = new ShardId(index, id);
                    tuple.v2().onResponse(emptySearchResponse());
                remoteIndicesByCluster,
                    skippedClusters,
                    tuple.v2().onResponse(emptySearchResponse());
            List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
            LatchedActionListener<SearchResponse> listener = new LatchedActionListener<>(
            assertTrue(remoteAliases.toString(), remoteAliases.containsKey("foo_id"));
        }
            assertThat(failure.get(), instanceOf(NullPointerException.class));
                LatchedActionListener<SearchResponse> listener = new LatchedActionListener<>(
            );
                    threadPool,
import org.opensearch.search.internal.InternalSearchResponse;
                        new String[] { "some_alias_for_foo", "some_other_foo_alias" },
                Tuple<SearchRequest, ActionListener<SearchResponse>> tuple = setOnce.get();
                        searchRequest,
 * specific language governing permissions and limitations
                    skippedClusters,
        );
                assertThat(tuple.v2(), instanceOf(TransportSearchAction.CCSActionListener.class));
                namedWriteableRegistry,
                    )
            {
                    null,
import java.util.concurrent.atomic.AtomicReference;
import org.apache.logging.log4j.LogManager;
        }
                    threadPool,
        List<SearchShardIterator> result = new ArrayList<>();
                    listener,
import org.opensearch.index.query.IdsQueryBuilder;
            assertEquals(0, service.getConnectionManager().size());
                assertThat(failure.get(), instanceOf(RemoteTransportException.class));
import org.opensearch.transport.RemoteClusterConnectionTests;
            assertEquals(10, merger.size);
        Map<String, OriginalIndices> remoteIndicesByCluster = new HashMap<>();
                            expected.add(localIterator);
            .settings(settings(Version.CURRENT))
                assertEquals(totalClusters, searchResponse.getClusters().getTotal());
            assertTrue(remoteAliases.toString(), remoteAliases.containsKey("bar_id"));
            }
 * KIND, either express or implied.  See the License for the
                    assertEquals(shard.getShardId().getIndexName(), "xyz");
                    null,
                Map<String, ClusterSearchShardsResponse> map = response.get();
                            OriginalIndicesTests.randomOriginalIndices(),
            }
            // give transport service enough time to realize that the node is down, and to notify the connection listeners
        Index index,
            }
            Transport.Connection localConnection = connectionLookup.apply(requestClusterAlias, randomAlphaOfLengthBetween(5, 10));
            {
                    assertTrue(map.containsKey(clusterAlias));
import org.opensearch.cluster.service.ClusterService;
        DiscoveryNode[] nodes,
                        searchRequest,
                nodeToConnection
            SearchRequest searchRequest = new SearchRequest().source(new SearchSourceBuilder().sort(SortBuilders.fieldSort("timestamp")))
import org.opensearch.tasks.TaskResourceTrackingService;
            assertFalse(TransportSearchAction.shouldMinimizeRoundtrips(searchRequest));
                TransportSearchAction.collectSearchShards(
                    remoteClusterService,
            indicesAndAliases.put("bar", new AliasFilter(new MatchAllQueryBuilder(), Strings.EMPTY_ARRAY));
import org.opensearch.cluster.routing.ShardRouting;
                    SearchShardTarget shard = iterator.nextOrNull();
            }
            BiFunction<String, String, Transport.Connection> connectionLookup = TransportSearchAction.buildConnectionLookup(
            assertNull(source.trackTotalHitsUpTo());
                    if (rarely()) {
                    Tuple<SearchRequest, ActionListener<SearchResponse>> tuple = setOnce.get();
                    tuple.v2().onResponse(emptySearchResponse());
            )
            assertNull(remoteAliases.get("xyz_id").getQueryBuilder());
            SearchSourceBuilder source = new SearchSourceBuilder();
                awaitLatch(latch, 5, TimeUnit.SECONDS);
                    assertThat(tuple.v2(), instanceOf(TransportSearchAction.CCSActionListener.class));
                        TestShardRouting.newShardRouting("foo", 0, "node2", false, ShardRoutingState.STARTED) }
                    String clusterAlias = "remote" + i;
import org.opensearch.search.SearchHit;
            RemoteClusterService remoteClusterService = service.getRemoteClusterService();
                );
                    new LatchedActionListener<>(ActionListener.wrap(response::set, e -> fail("no failures expected")), latch)
import java.util.concurrent.CopyOnWriteArrayList;
            Set<Integer> disconnectedNodesIndices = new HashSet<>(numDisconnectedClusters);
                        remoteShardIterators.add(remoteIterator);
            assertTrue(TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(2, 127)));
                ResolvedIndices resolvedIndices = action.resolveIndices(new SearchRequest().source(searchSourceBuilder));
                assertEquals(successful, searchResponse.getClusters().getSuccessful());
    ) {
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                new ClusterSearchShardsGroup(
import java.util.Map;
                if (localIndices == null) {
import org.opensearch.transport.NodeDisconnectedException;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                assertEquals(numClusters - disconnectedNodesIndices.size(), map.size());
                    assertNotNull(shard);
            {
            for (SearchShardIterator iterator : iteratorList) {
/*
            assertEquals(new TermsQueryBuilder("foo", "bar"), remoteAliases.get("foo_id").getQueryBuilder());
                        () -> null
                    new ShardRouting[] {
                TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(127, 10000))
                );
                assertEquals(disconnectedNodesIndices.size(), searchResponse.getClusters().getSkipped());
    }
                TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(127, 10000))
                    IndicesOptions.lenientExpandOpen(),
                NoopTracer.INSTANCE
                tuple.v2().onResponse(emptySearchResponse());
                    Tuple<SearchRequest, ActionListener<SearchResponse>> tuple = setOnce.get();
                    new SearchRequestContext(
                    SearchShardIterator localIterator = createSearchShardIterator(i, index, localIndices, localClusterAlias);
                source,
    public void testCCSRemoteReduceMergeFails() throws Exception {
        Arrays.sort(indices, (o1, o2) -> {
        }
                emptyReduceContextBuilder(),
                    Tuple<SearchRequest, ActionListener<SearchResponse>> tuple = setOnce.get();
                    searchRequest,
                    assertEquals(0, iterator.shardId().getId());
                    if (disconnectedNodesIndices.contains(i)) {
            }
            searchRequest.scroll("5s");
                    shard = iterator.nextOrNull();
 *
            SearchRequest searchRequest = searchRequestTests.createSearchRequest();
        List<SearchShardIterator> expected = new ArrayList<>();
                    if (disconnectedNodes.remove(node)) {
                    ResolvedIndices.of("index_a1", "index_a2")
                    IndicesOptions.lenientExpandOpen(),
            int nameCompareTo = o1.getName().compareTo(o2.getName());
import org.opensearch.index.query.TermsQueryBuilder;
                        disconnectedLatch.countDown();
            assertEquals(0, merger.from);
            mockTransportServices[i] = remoteSeedTransport;
                    assertNull(iterator.nextOrNull());
                public void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {
                    Tuple<SearchRequest, ActionListener<SearchResponse>> tuple = setOnce.get();
import org.opensearch.core.common.Strings;
                        () -> null
import org.opensearch.Version;
                    null,
        {
                    threadPool,
                        TestShardRouting.newShardRouting("bar", 0, "node1", false, ShardRoutingState.STARTED) }
        }
        IndexNameExpressionResolver indexNameExpressionResolver = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
            {
                } else {
        }
                RemoteClusterServiceTests.updateSkipUnavailable(remoteClusterService, "remote" + i, true);
                if (localIndices == null) {
                        assertFalse(map.containsKey(clusterAlias));
        Index[] indices = new Index[randomIntBetween(1, 10)];
        for (int i = 0; i < numIndices; i++) {
        GroupShardsIterator<SearchShardIterator> groupShardsIterator = TransportSearchAction.mergeShardsIterators(
                    (r, l) -> setOnce.set(Tuple.tuple(r, l)),
            indices[i] = randomAlphaOfLengthBetween(5, 10);
        int id,
        );
                String pitId = PitTestsUtil.getPitId();
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
import org.opensearch.common.SetOnce;
        }
                    assertNotNull(shard);
                SearchRequest searchRequest = new SearchRequest();
        }
                assertEquals(ResolvedIndices.of("idx", "idy"), resolvedIndices);
        try (
 * The OpenSearch Contributors require contributions made to
            assertEquals(10, source.size());
    }
                assertEquals(0, searchResponse.getClusters().getSkipped());
 * You may obtain a copy of the License at
            );
                searchShardsResponseMap,
        Settings settings = builder.build();
                final CountDownLatch latch = new CountDownLatch(1);
                threadPool,
                        SearchShardIterator remoteIterator = createSearchShardIterator(
            // the intention here is not to test that we throw NPE, rather to trigger a situation that makes
            when(searchTransportService.getRemoteClusterService()).thenReturn(remoteClusterService);
                    null,
            searchShardsResponseMap.put("test_cluster_1", new ClusterSearchShardsResponse(groups, nodes, indicesAndAliases));
                ResolvedIndices resolvedIndices = action.resolveIndices(new SearchRequest("index_*", "remote1:remote_index"));
            int numDisconnectedClusters = randomIntBetween(1, numClusters);
    }
        String[] indices = new String[numIndices];
            SearchResponseMerger merger = TransportSearchAction.createSearchResponseMerger(null, timeProvider, emptyReduceContextBuilder());
                    )
                for (int i = 0; i < numClusters; i++) {
        for (int i = 0; i < numClusters; i++) {
                        );
                SearchResponse searchResponse = response.get();
            );
    public void testShouldMinimizeRoundtrips() throws Exception {
            ClusterSearchShardsGroup[] groups2 = new ClusterSearchShardsGroup[] {
                }
            }
                );
            // SearchResponseMerger#getMergedResponse fail unexpectedly and verify that the listener is properly notified with the NPE
                    assertEquals("foo", iterator.shardId().getIndexName());
            searchRequest.preference("null_target");
                .scroll("5m");
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                    null,
                        SearchShardIterator iterator = createSearchShardIterator(
                ) };
                    localIndices,
                    localShardIterators.add(localIterator);
    public void testProcessRemoteShards() {
            @Override
        OriginalIndices originalIndices,
            DiscoveryNode remoteSeedNode = remoteSeedTransport.getLocalDiscoNode();
            service.clearAllRules();
                    assertEquals("test_cluster_1", iterator.getClusterAlias());
                assertEquals(totalClusters, searchResponse.getClusters().getSuccessful());
        }
                SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        }
import java.util.HashSet;
            }
            assertEquals(trackTotalHitsUpTo, merger.trackTotalHitsUpTo);
import org.opensearch.core.action.ActionListener;
                    assertEquals("", tuple.v1().getLocalClusterAlias());
                assertEquals(ResolvedIndices.of("index_a1", "index_a2"), resolvedIndices);
                if (localIndices == null) {
        when(clusterService.getClusterSettings()).thenReturn(
                assertEquals("", tuple.v1().getLocalClusterAlias());
 * compatible open source license.
                    "index_not_found",
    }
            Map<String, ClusterSearchShardsResponse> searchShardsResponseMap = new HashMap<>();
                for (int i : disconnectedNodesIndices) {
                    null,
        {
            assertEquals(0, service.getConnectionManager().size());
                    } else {
import org.opensearch.index.query.TermQueryBuilder;
import org.opensearch.search.collapse.CollapseBuilder;
            {
                        searchRequest,
                    remoteClusterService,
                    new ShardId("foo", "foo_id", 1),
                    assertEquals("", tuple.v1().getLocalClusterAlias());
                }
            }
        }
                if (iterator.shardId().getIndexName().endsWith("foo")) {
                    searchRequest,
            @Override
            SearchRequest searchRequest = new SearchRequest();
                    new LatchedActionListener<>(ActionListener.wrap(response::set, e -> fail("no failures expected")), latch)
package org.opensearch.action.search;
        } finally {
                );
                );
            assertFalse(TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(2, 128)));
            int numIndices = randomIntBetween(0, indices.length);
            null,
                }
                    assertNull(setOnce.get());
                    assertTrue(disconnectedNodesIndices.add(i));
                );
            );
            assertTrue(
            .numberOfReplicas(1);
            }
        Function<Boolean, InternalAggregation.ReduceContext> reduceContext = finalReduce -> null;
            while (disconnectedNodes.size() < numDisconnectedClusters) {
                    assertEquals(shard.getShardId().getIndexName(), "foo");
                    assertThat(tuple.v2(), instanceOf(TransportSearchAction.CCSActionListener.class));
                    (r, l) -> setOnce.set(Tuple.tuple(r, l)),
                    searchRequest,
            SearchRequest searchRequest = new SearchRequest();
            }
        }
                public void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {
    }
                mock(Tracer.class),
                }
        int numReadOnly = randomIntBetween(1, numIndices);
        Settings.Builder builder = Settings.builder();
import org.opensearch.indices.IndicesService;
                            clusterAlias
        DiscoveryNode[] nodes = new DiscoveryNode[numClusters];
                mock(NodeClient.class),
 * Licensed to Elasticsearch under one or more contributor
                AtomicReference<Exception> failure = new AtomicReference<>();
                assertEquals(0, skippedClusters.get());
                    assertNull(setOnce.get());
                assertNotNull(response.get());
import static org.hamcrest.CoreMatchers.containsString;
                indexNameExpressionResolver,
            SearchRequest searchRequest = new SearchRequest().source(
            Map<String, AliasFilter> filter = new HashMap<>();
                Settings.EMPTY,
            searchRequest.setCcsMinimizeRoundtrips(false);
            awaitLatch(latch, 5, TimeUnit.SECONDS);
            List<SearchShardIterator> iteratorList = TransportSearchAction.getRemoteShardsIterator(
 */
            }
            searchRequestTests.setUp();
        {
                    expected.add(iterator);
        Map<String, OriginalIndices> remoteIndicesByCluster = new HashMap<>();
        Map<String, OriginalIndices> remoteIndicesByCluster = new HashMap<>();
            searchRequest.scroll((Scroll) null);
            SearchRequest searchRequest = new SearchRequest();
                    new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
        Settings.Builder settingsBuilder
                        () -> null
            SearchRequest searchRequest = new SearchRequest().source(
import org.opensearch.threadpool.TestThreadPool;
            null,
                            expected.add(localIterator);
                    new SearchRequestContext(
            Transport.Connection localConnection = connectionLookup.apply(null, randomAlphaOfLengthBetween(5, 10));
                } else if (iterator.shardId().getIndexName().endsWith("bar")) {
                assertEquals(RestStatus.NOT_FOUND, remoteTransportException.status());
            "remote-" + nodeId,
            // so that RemoteClusterConnection is left with no connected nodes, hence it will retry connecting next
            } else {
                emptyReduceContextBuilder()
            searchRequest.scroll("5s");
                    }
                remoteNodes,
        ) {
                    remoteClusterService,
                @Override
            settingsBuilder.put("cluster.remote.remote" + i + ".seeds", remoteSeedNode.getAddress().toString());
                    listener,
            assertThat(remoteConnection.getNode().getId(), startsWith("remote-"));
                AtomicReference<Map<String, ClusterSearchShardsResponse>> response = new AtomicReference<>();
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT).blocks(blocksBuilder).build();
                remoteNodes,
            TransportSearchAction action = new TransportSearchAction(
            .metadata(Metadata.builder().put(indexA1).put(indexA2))
                assertEquals(totalClusters == 1 ? 1 : totalClusters + 1, searchResponse.getNumReducePhases());
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT).build();
import org.opensearch.cluster.ClusterState;
            );
        }
                RemoteTransportException remoteTransportException = (RemoteTransportException) failure.get();
                    latch
            searchRequest.searchType(SearchType.DFS_QUERY_THEN_FETCH);
                Version.CURRENT,
            InternalAggregations.EMPTY,
                    assertNotNull(shard);
                mockTransportService.close();
                    assertEquals(shard.getShardId().getIndexName(), "bar");
import org.opensearch.common.util.concurrent.ThreadContext;
                new SearchSourceBuilder().query(QueryBuilders.rangeQuery("timestamp"))
        }
            assertEquals(SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO, merger.trackTotalHitsUpTo);
                TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(127, 10000))
        }
                remoteClusterService,
            }
                indices[i] = new Index(existingIndex.getName(), randomAlphaOfLength(10));
                int i = randomIntBetween(0, numClusters - 1);
            if (--numReadOnly >= 0) {
                TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(129, 10000))
        MockTransportService[] mockTransportServices = startTransport(numClusters, nodes, remoteIndicesByCluster, builder);
    public void testBuildConnectionLookup() {
        String localClusterAlias = randomAlphaOfLengthBetween(5, 10);
                    assertNotNull(shard);
import org.opensearch.index.query.QueryBuilder;
                randomAlphaOfLengthBetween(5, 10),
        {
            null,
                    SearchShardTarget shard = iterator.nextOrNull();
import static org.mockito.Mockito.mock;
            assertTrue(remoteAliases.toString(), remoteAliases.containsKey("xyz_id"));
                assertEquals(0, skippedClusters.get());
                ResolvedIndices resolvedIndices = action.resolveIndices(new SearchRequest("alias_a"));
import org.opensearch.cluster.metadata.AliasMetadata;
                null,
                    new ShardId("bar", "bar_id", 0),
                );
                    timeProvider,
                AtomicReference<Map<String, ClusterSearchShardsResponse>> response = new AtomicReference<>();
                        () -> null
        assertEquals(expected, result);
            source.size(originalSize);
            assertEquals(0, merger.from);
        {
        for (int i = 0; i < remoteClusters.length; i++) {
                assertEquals(totalClusters, searchResponse.getClusters().getSuccessful());
                mock(CircuitBreakerService.class),
                    IndicesOptions.lenientExpandOpen(),
                    if (disconnectedNodes.remove(node)) {
                } else if (iterator.shardId().getIndexName().endsWith("xyz")) {
            searchRequest.source(new SearchSourceBuilder());
import org.opensearch.action.OriginalIndices;
                    for (int k = 0; k < numClusters; k++) {
        );
 */
            }
            SearchRequest searchRequest = new SearchRequest();
                    threadPool,
                SearchResponse searchResponse = response.get();
                Map<String, ClusterSearchShardsResponse> map = response.get();
        when(clusterService.state()).thenReturn(clusterState);
                AtomicReference<SearchResponse> response = new AtomicReference<>();
            for (MockTransportService mockTransportService : mockTransportServices) {
            assertFalse(TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(2, 127)));
            );
                assertThat(failure.get().getMessage(), containsString("error while communicating with remote cluster ["));
            );
        List<SearchShardIterator> localShardIterators = new ArrayList<>();
            );
                    listener,
            SearchResponseMerger merger = TransportSearchAction.createSearchResponseMerger(
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.internal.SearchContext;
            SearchSourceBuilder source = searchRequest.source();
                if (randomBoolean()) {
            assertNotNull(failure.get());
            }
                }
                return o1.getUUID().compareTo(o2.getUUID());
                threadPool,
            {
        OriginalIndices localIndices = local ? new OriginalIndices(new String[] { "index" }, SearchRequest.DEFAULT_INDICES_OPTIONS) : null;
import org.opensearch.action.OriginalIndicesTests;
                timeProvider,
        OriginalIndices localIndices = OriginalIndicesTests.randomOriginalIndices();
import org.opensearch.transport.TransportConnectionListener;
                "foo",
            for (int j = 0; j < numIndices; j++) {
        }
            assertFalse(
        return mockTransportServices;
                    skippedClusters,
                        searchRequest,
                service.addFailToSendNoConnectRule(disconnectedNode.getAddress());
                    null,
        BiFunction<String, DiscoveryNode, Transport.Connection> nodeToConnection = (clusterAlias, node) -> new Transport.Connection() {
                "test_cluster_1",
            assertTrue(disconnectedLatch.await(5, TimeUnit.SECONDS));
                        TestShardRouting.newShardRouting("bar", 0, "node2", true, ShardRoutingState.STARTED),
import org.opensearch.cluster.node.DiscoveryNode;
            Set<DiscoveryNode> disconnectedNodes = new HashSet<>(numDisconnectedClusters);
        int numShards = randomIntBetween(0, 10);
                    latch
                searchRequest.preference("index_not_found");
                mock(TransportService.class),
import org.opensearch.search.Scroll;
                mock(SearchPipelineService.class),
            }
        }
                mock(WorkloadGroupService.class)
            public DiscoveryNode getNode() {
 * Modifications Copyright OpenSearch Contributors. See
            );
                for (int i = 0; i < numClusters; i++) {
        int numClusters = randomIntBetween(2, 10);
        Collections.shuffle(remoteShardIterators, random());
                assertEquals(0, skippedClusters.get());
                final CountDownLatch latch = new CountDownLatch(1);
            assertFalse(TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(2, 128)));
import org.opensearch.cluster.routing.GroupShardsIteratorTests;
        {
            RemoteClusterServiceTests.addConnectionListener(remoteClusterService, new TransportConnectionListener() {
                    new ShardId("xyz", "xyz_id", 0),
                randomAlphaOfLengthBetween(5, 10)
            searchRequest.setCcsMinimizeRoundtrips(true);
                SetOnce<Tuple<SearchRequest, ActionListener<SearchResponse>>> setOnce = new SetOnce<>();
                    assertTrue(disconnectedNodesIndices.add(i));
import org.opensearch.index.query.InnerHitBuilder;
                    new LatchedActionListener<>(ActionListener.wrap(r -> fail("no response expected"), failure::set), latch)
import org.opensearch.action.support.ActionFilters;
                    listener,
                        remoteShardIterators.add(iterator);
                new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchAllQueryBuilder.NAME, MatchAllQueryBuilder::new),
        }
                Map<String, ClusterSearchShardsResponse> map = response.get();
                    null,
    }
                emptyReduceContextBuilder()
        int numIndices = randomIntBetween(2, 10);
import org.opensearch.cluster.metadata.Metadata;
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(
            assertTrue(TransportSearchAction.shouldMinimizeRoundtrips(searchRequest));
                    remoteClusterService,
                    timeProvider,
                int successful = totalClusters - disconnectedNodesIndices.size();
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
                    assertNull(setOnce.get());
    }
                mock(ActionFilters.class),
            assertEquals(-1, source.from());
            assertEquals(-1, source.size());
        DiscoveryNode[] nodes = new DiscoveryNode[numClusters];
                new ClusterSearchShardsGroup(
        {
                final CountDownLatch latch = new CountDownLatch(1);
        ClusterService clusterService = mock(ClusterService.class);
            }
                    latch
                final CountDownLatch latch = new CountDownLatch(1);
            assertTrue(disconnectedLatch.await(5, TimeUnit.SECONDS));
                    remoteIndicesByCluster,
            service.start();
            assertTrue(
        List<ShardRouting> shardRoutings = GroupShardsIteratorTests.randomShardRoutings(shardId);
    }
                new SearchPhaseController(namedWriteableRegistry, (searchSourceBuilder) -> null),
                            index,
/*
                if (disconnectedNodes.add(nodes[i])) {
        ) {
                SearchRequest searchRequest = new SearchRequest();
            SearchRequest searchRequest = new SearchRequest().source(
            // setting skip_unavailable to true for all the disconnected clusters will make the request succeed again
                    () -> null
                LatchedActionListener<SearchResponse> listener = new LatchedActionListener<>(
                    assertEquals("xyz", iterator.shardId().getIndexName());
            SearchRequest searchRequest = new SearchRequest().source(new SearchSourceBuilder().sort(SortBuilders.fieldSort("timestamp")));
import java.util.function.Function;
        int numIndices = randomIntBetween(2, 10);
        return new SearchShardIterator(clusterAlias, shardId, shardRoutings, originalIndices);
            );
        MockTransportService[] mockTransportServices = startTransport(numClusters, nodes, remoteIndicesByCluster, builder);
        } finally {
                        new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
                final CountDownLatch latch = new CountDownLatch(1);
                            OriginalIndicesTests.randomOriginalIndices(),
            assertEquals(originalFrom + originalSize, source.size());
        }
                TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(127, 10000))
            result.add(searchShardIterator);
                );
                    int numClusters = randomIntBetween(1, remoteClusters.length);
import org.opensearch.cluster.routing.GroupShardsIterator;
                SetOnce<Tuple<SearchRequest, ActionListener<SearchResponse>>> setOnce = new SetOnce<>();
        List<SearchShardIterator> remoteShardIterators = new ArrayList<>();
        Map<String, OriginalIndices> remoteIndices,
    ) {
public class TransportSearchActionTests extends OpenSearchTestCase {
                TransportSearchAction.collectSearchShards(
                final CountDownLatch latch = new CountDownLatch(1);
            MockTransportService service = MockTransportService.createNewService(settings, Version.CURRENT, threadPool, NoopTracer.INSTANCE)
                    localIndices,
        }
    public void testCollectSearchShards() throws Exception {
 * software distributed under the License is distributed on an
            while (disconnectedNodes.size() < numDisconnectedClusters) {
                    remoteIndicesByCluster,
                RemoteClusterServiceTests.updateSkipUnavailable(remoteClusterService, "remote" + i, true);
            );
            source.from(originalFrom);
                    );
        }
                    remoteIndicesByCluster,
                SetOnce<Tuple<SearchRequest, ActionListener<SearchResponse>>> setOnce = new SetOnce<>();
            );
                        i,
                    ActionListener.wrap(r -> fail("no response expected"), failure::set),
            service.acceptIncomingRequests();
                    remoteIndicesByCluster,
                }
                    emptyReduceContextBuilder(),
                    assertArrayEquals(new String[] { "some_alias_for_xyz" }, iterator.getOriginalIndices().indices());
        int numClusters = randomIntBetween(2, 10);
            .build();
            source.collapse(collapseBuilder);
                }
                    shard = iterator.nextOrNull();
 * Unless required by applicable law or agreed to in writing,
                TransportSearchAction.ccsRemoteReduce(
import org.opensearch.test.OpenSearchTestCase;
        InternalSearchResponse response = new InternalSearchResponse(
                assertNull(setOnce.get());
            nodes[i] = remoteSeedNode;
                    if (randomBoolean()) {
                    new SearchRequestContext(
                        String clusterAlias = remoteClusters[k];
        super.tearDown();
import java.util.HashMap;
                            i,
                )
                    SearchShardTarget shard = iterator.nextOrNull();
import org.opensearch.common.settings.Settings;
            for (int i : disconnectedNodesIndices) {
            public void close() {}
            searchRequest.source(source);
        TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(0, 0, () -> 0);
        try (
            SearchSourceBuilder source = new SearchSourceBuilder();
            }
                AtomicInteger skippedClusters = new AtomicInteger(0);
                AtomicInteger skippedClusters = new AtomicInteger(0);
            );
        Settings settings = builder.build();
                    )
                TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(129, 10000))
import org.opensearch.transport.RemoteTransportException;
        );
                        TestShardRouting.newShardRouting("foo", 0, "node1", true, ShardRoutingState.STARTED),
            // so that RemoteClusterConnection is left with no connected nodes, hence it will retry connecting next
                );
import org.opensearch.core.rest.RestStatus;
            final CountDownLatch latch = new CountDownLatch(1);
                ) };
                    String clusterAlias = "remote" + i;
                assertEquals(
import org.opensearch.search.pipeline.SearchPipelineService;
                localNodes,
                awaitLatch(latch, 5, TimeUnit.SECONDS);
                AtomicReference<Map<String, ClusterSearchShardsResponse>> response = new AtomicReference<>();
        );
                    remoteClusterService,
        {
            }
                // The generated pitId will contain the indices "idx" and "idy"
        OriginalIndices localIndices = local ? new OriginalIndices(new String[] { "index" }, SearchRequest.DEFAULT_INDICES_OPTIONS) : null;
                awaitLatch(latch, 5, TimeUnit.SECONDS);
                for (int i : disconnectedNodesIndices) {
            1
        boolean local = randomBoolean();
            Version.CURRENT
            String requestClusterAlias = randomAlphaOfLengthBetween(5, 10);
                localIndices,
            Map<String, AliasFilter> indicesAndAliases = new HashMap<>();
        }
import org.opensearch.transport.TransportException;
                    blocksBuilder.addIndexBlock(indices[i], IndexMetadata.INDEX_READ_ONLY_BLOCK);
                    (r, l) -> setOnce.set(Tuple.tuple(r, l)),
                Index index = indices[j];
                new ClusterSearchShardsGroup(
        Settings settings = builder.build();
        }
                    emptyReduceContextBuilder(),
            }
            {
                new NamedWriteableRegistry.Entry(QueryBuilder.class, IdsQueryBuilder.NAME, IdsQueryBuilder::new)
                ResolvedIndices resolvedIndices = action.resolveIndices(new SearchRequest("index_*"));
            }
                TransportSearchAction.ccsRemoteReduce(
                TransportSearchAction.collectSearchShards(
            }
import org.apache.lucene.search.TotalHits;
                mock(MetricsRegistry.class),
            }
                awaitLatch(latch, 5, TimeUnit.SECONDS);
                        );
