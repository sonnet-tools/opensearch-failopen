                new AliasFilter(new TermsQueryBuilder("foo", "bar"), "some_alias_for_foo", "some_other_foo_alias")  
    }
            assertTrue(TransportSearchAction.shouldMinimizeRoundtrips(searchRequest));
 */
                assertNotNull(failure.get());
            }  
                ResolvedIndices resolvedIndices = action.resolveIndices(new SearchRequest().source(searchSourceBuilder));  
                    collapse.setInnerHits(Collections.emptyList());
        }
                    remoteClusterService,
                Map<String, ClusterSearchShardsResponse> map = response.get();
            )
                    tuple.v2().onResponse(emptySearchResponse());
                awaitLatch(latch, 5, TimeUnit.SECONDS);  
                randomAlphaOfLengthBetween(5, 10)
            {  
                    if (disconnectedNodes.remove(node)) {
                service.addFailToSendNoConnectRule(disconnectedNode.getAddress());  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.awaitLatch;
                    latch
            assertEquals(new MatchAllQueryBuilder(), remoteAliases.get("bar_id").getQueryBuilder());  
            searchRequest.source(source);
        return mockTransportServices;  
                for (int i = 0; i < numClusters; i++) {  
 */  
                assertThat(failure.get(), instanceOf(RemoteTransportException.class));
                    assertEquals(shard.getShardId().getIndexName(), "foo");  
                    ActionListener.wrap(response::set, e -> fail("no failures expected")),  
        Map<String, OriginalIndices> remoteIndices,
            TransportSearchAction action = new TransportSearchAction(
        for (int i = 0; i < numIndices; i++) {  
        }
            );
                    null,
                }  
                    assertArrayEquals(new String[] { "bar" }, iterator.getOriginalIndices().indices());  
        }
                int i = randomIntBetween(0, numClusters - 1);
            for (MockTransportService mockTransportService : mockTransportServices) {
                if (localIndices == null) {
                        RemoteClusterServiceTests.updateSkipUnavailable(remoteClusterService, "remote" + i, true);  
            );
                SearchRequest searchRequest = new SearchRequest();  
                    assertEquals("", tuple.v1().getLocalClusterAlias());
            SearchRequest searchRequest = new SearchRequest().source(new SearchSourceBuilder().sort(SortBuilders.fieldSort("timestamp")));  
            TransportService transportService = MockTransportService.createNewService(
            SearchRequest searchRequest = new SearchRequest();  
            service.start();  
                SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
                threadPool  
                new SearchSourceBuilder().query(QueryBuilders.rangeQuery("timestamp"))
                AtomicReference<SearchResponse> response = new AtomicReference<>();
            remoteIndicesByCluster.put(
                        randomFrom(remoteClusters)
                    assertNull(setOnce.get());
            searchRequest.scroll((Scroll) null);
                        TestShardRouting.newShardRouting("bar", 0, "node2", true, ShardRoutingState.STARTED),
            // so that RemoteClusterConnection is left with no connected nodes, hence it will retry connecting next
                );
                    if (disconnectedNodes.remove(node)) {  
    }  
                    assertEquals(1, shardsResponse.getNodes().length);
            searchRequest.preference("null_target");
import java.util.function.Function;
                service.addFailToSendNoConnectRule(disconnectedNode.getAddress());
        return new SearchResponse(response, null, 1, 1, 0, 100, ShardSearchFailure.EMPTY_ARRAY, SearchResponse.Clusters.EMPTY, null);
                        String remoteClusterAlias = randomFrom(remoteClusters);
            .putAlias(AliasMetadata.builder("alias_a").build())
            assertEquals(-1, source.size());  
            assertFalse(TransportSearchAction.shouldMinimizeRoundtrips(searchRequest));
 * SPDX-License-Identifier: Apache-2.0
            assertTrue(
                            OriginalIndicesTests.randomOriginalIndices(),
                    } else {
import org.opensearch.search.internal.InternalSearchResponse;
 *  
import java.util.concurrent.CopyOnWriteArrayList;
                    assertNull(setOnce.get());
            MockTransportService service = MockTransportService.createNewService(settings, Version.CURRENT, threadPool, NoopTracer.INSTANCE)
        ClusterBlocks.Builder blocksBuilder = ClusterBlocks.builder();
            assertEquals(0, source.from());
            }
import org.opensearch.cluster.metadata.AliasMetadata;
            assertTrue(
                new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchAllQueryBuilder.NAME, MatchAllQueryBuilder::new),
                    )
import org.opensearch.action.support.IndicesOptions;
                    threadPool,
                final CountDownLatch latch = new CountDownLatch(1);
        when(clusterService.state()).thenReturn(clusterState);  
                );  
                listener,
    public void testCCSRemoteReduceMergeFails() throws Exception {
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(
            Arrays.asList(  
                    assertTrue(disconnectedNodesIndices.add(i));  
            for (DiscoveryNode disconnectedNode : disconnectedNodes) {
import org.opensearch.Version;  
        boolean local = randomBoolean();
                emptyReduceContextBuilder()  
                        () -> null
                    )
                return o1.getUUID().compareTo(o2.getUUID());
                    String clusterAlias = "remote" + i;
                    }  
        Settings settings = builder.build();
            }
                emptyReduceContextBuilder()
                assertEquals(totalClusters == 1 ? 1 : totalClusters + 1, searchResponse.getNumReducePhases());  
import org.opensearch.test.OpenSearchTestCase;  
                );  
                for (int i : disconnectedNodesIndices) {
                        searchRequest,  
import org.opensearch.cluster.metadata.Metadata;
                    remoteIndicesByCluster,
                new NamedWriteableRegistry.Entry(QueryBuilder.class, TermQueryBuilder.NAME, TermQueryBuilder::new),
            assertEquals(originalFrom, merger.from);
            );  
                )
            {
            assertNull(source.trackTotalHitsUpTo());
        }
import org.apache.logging.log4j.LogManager;
            assertNotNull(failure.get());
            SearchRequest searchRequest = new SearchRequest().source(  
                TransportSearchAction.ccsRemoteReduce(  
                );
import org.opensearch.core.index.Index;
            @Override
            }  
                    }
            {
            SearchSourceBuilder source = new SearchSourceBuilder();  
                    new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
        );
                indices[i] = new Index(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLength(10));
import static org.opensearch.test.InternalAggregationTestCase.emptyReduceContextBuilder;
            public DiscoveryNode getNode() {  
                    assertEquals(shard.getShardId().getIndexName(), "bar");  
                if (localIndices == null) {
        }  
                    emptyReduceContextBuilder(),
            MockTransportService service = MockTransportService.createNewService(settings, Version.CURRENT, threadPool, NoopTracer.INSTANCE)
            MockTransportService remoteSeedTransport = RemoteClusterConnectionTests.startTransport(
                    assertEquals("test_cluster_1", iterator.getClusterAlias());
                    assertEquals(0, iterator.shardId().getId());
            .settings(settings(Version.CURRENT))
            "local-" + nodeId,
        MockTransportService[] mockTransportServices = new MockTransportService[numClusters];
            }  
                        if (remoteClusterAlias.compareTo(localClusterAlias) < 0) {  
            searchRequestTests.setUp();
            public void close() {}
            service.clearAllRules();
                    (r, l) -> setOnce.set(Tuple.tuple(r, l)),
            }
            }
            }
import org.opensearch.core.rest.RestStatus;
        List<SearchShardIterator> remoteShardIterators = new ArrayList<>();  
        super.tearDown();  
            }
                );  
                    listener,
            assertThat(localConnection.getNode().getId(), startsWith("local-"));
                    remoteIndicesByCluster,  
import static org.mockito.Mockito.mock;  
            service.acceptIncomingRequests();
    private MockTransportService[] startTransport(
import org.opensearch.index.query.QueryBuilders;
                timeProvider,
            when(searchTransportService.getRemoteClusterService()).thenReturn(remoteClusterService);
            "remote-" + nodeId,  
            SearchSourceBuilder source = new SearchSourceBuilder();
                return node;
                    localIndices,
            assertEquals(0, service.getConnectionManager().size());  
                if (localIndices == null) {  
            assertEquals(0, service.getConnectionManager().size());
                    assertNull(iterator.nextOrNull());
        BiFunction<String, String, DiscoveryNode> remoteNodes = (clusterAlias, nodeId) -> new DiscoveryNode(
                } else {  
import org.opensearch.cluster.metadata.ResolvedIndices;  
    @Override
                    localIndices,
                AtomicReference<Map<String, ClusterSearchShardsResponse>> response = new AtomicReference<>();  
                    assertThat(tuple.v2(), instanceOf(TransportSearchAction.CCSActionListener.class));  
                if (iterator.shardId().getIndexName().endsWith("foo")) {
                assertEquals(totalClusters, searchResponse.getClusters().getSuccessful());
                    assertEquals("test_cluster_1", iterator.getClusterAlias());
    public void testMergeShardsIterators() {  
                for (int i = 0; i < numClusters; i++) {
            {
                // The generated pitId will contain the indices "idx" and "idy"
            searchRequest.setCcsMinimizeRoundtrips(true);
        MockTransportService[] mockTransportServices = startTransport(numClusters, nodes, remoteIndicesByCluster, builder);
                assertEquals(totalClusters, searchResponse.getClusters().getTotal());  
                SetOnce<Tuple<SearchRequest, ActionListener<SearchResponse>>> setOnce = new SetOnce<>();
                    searchRequest,
                    new ShardRouting[] {  
            SearchRequest searchRequest = new SearchRequest();
            for (int j = 0; j < numIndices; j++) {
                threadPool,
                        }  
            SearchRequest searchRequest = new SearchRequest().source(new SearchSourceBuilder().sort(SortBuilders.fieldSort("timestamp")))
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                    SearchShardTarget shard = iterator.nextOrNull();
            BiFunction<String, String, Transport.Connection> connectionLookup = TransportSearchAction.buildConnectionLookup(
        {
            assertEquals(10, merger.size);  
                }
            service.start();  
import org.opensearch.transport.TransportConnectionListener;
                        disconnectedLatch.countDown();  
                assertEquals(0, skippedClusters.get());  
                    skippedClusters,
                            expected.add(localIterator);
    ) {
                } else {  
            int numIndices = randomIntBetween(0, indices.length);  
            knownNodes.add(remoteSeedNode);
                    tuple.v2().onResponse(emptySearchResponse());
import org.opensearch.transport.RemoteClusterServiceTests;
                        searchRequest,  
import org.apache.lucene.search.TotalHits;
        int numShards = randomIntBetween(0, 10);
            assertThat(failure.get(), instanceOf(NullPointerException.class));
                requestClusterAlias,  
        for (int i = 0; i < numShards; i++) {
            result.add(searchShardIterator);
                    skippedClusters,
                new ClusterSearchShardsGroup(
                    assertEquals(shard.getShardId().getIndexName(), "foo");  
            searchRequest.searchType(SearchType.DFS_QUERY_THEN_FETCH);  
            service.acceptIncomingRequests();
                AtomicReference<Exception> failure = new AtomicReference<>();
        IndexMetadata.Builder indexA2 = IndexMetadata.builder("index_a2")
                    localShardIterators.add(localIterator);  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT).build();  
            Version.CURRENT  
                SearchRequest searchRequest = new SearchRequest();  
    }
                    timeProvider,
                Version.CURRENT,
            assertEquals(-1, source.from());
                    skippedClusters,  
                    listener,
import org.opensearch.transport.NodeDisconnectedException;
                AtomicReference<Exception> failure = new AtomicReference<>();
        {  
                mock(SearchService.class),  
                    null,  
 * this work for additional information regarding copyright
                    }
import org.opensearch.transport.TransportRequest;  
                if (randomBoolean()) {
                assertEquals(numClusters, map.size());
                }
import org.opensearch.core.indices.breaker.CircuitBreakerService;
import java.util.Arrays;
        Arrays.sort(indices, (o1, o2) -> {
                    ResolvedIndices.of("index_a1", "index_a2")
        GroupShardsIterator<SearchShardIterator> groupShardsIterator = TransportSearchAction.mergeShardsIterators(
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
                NoopTracer.INSTANCE  
                        new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
                    null,
            public void addCloseListener(ActionListener<Void> listener) {}  
        }
                RemoteTransportException remoteTransportException = (RemoteTransportException) failure.get();  
                    listener,
                awaitLatch(latch, 5, TimeUnit.SECONDS);  
                assertThat(failure.get().getCause(), instanceOf(NodeDisconnectedException.class));
/*  
                    (r, l) -> setOnce.set(Tuple.tuple(r, l)),  
                } else if (iterator.shardId().getIndexName().endsWith("bar")) {
 *
            searchRequest.scroll("5s");
                    String clusterAlias = "remote" + i;
import org.opensearch.cluster.routing.GroupShardsIterator;
                }
                .scroll("5m");
                mock(IndicesService.class),  
            RemoteClusterService remoteClusterService = service.getRemoteClusterService();
                Map<String, ClusterSearchShardsResponse> map = response.get();
import org.opensearch.search.SearchHit;  
            );  
                    assertEquals("", tuple.v1().getLocalClusterAlias());
        Settings settings = builder.build();  
                    latch  
            }
                        searchRequest,  
 * specific language governing permissions and limitations
                assertEquals(skippedClusters.get(), disconnectedNodesIndices.size());
                assertEquals(0, searchResponse.getClusters().getSkipped());  
            nodes[i] = remoteSeedNode;
            );  
            SearchRequest searchRequest = new SearchRequest().source(
        {
                    }  
        InternalSearchResponse response = new InternalSearchResponse(
                    assertNull(setOnce.get());
            );
            AtomicReference<Exception> failure = new AtomicReference<>();
        int id,
            }
        }
                    assertEquals("foo", iterator.shardId().getIndexName());  
                assertThat(failure.get().getMessage(), containsString("error while communicating with remote cluster ["));  
                    null,
            );  
                        index,  
            Map<String, AliasFilter> remoteAliases = TransportSearchAction.getRemoteAliasFilters(searchShardsResponseMap);  
import org.opensearch.common.settings.Settings;
                    threadPool,  
                    remoteClusterService,  
            assertEquals(trackTotalHitsUpTo, merger.trackTotalHitsUpTo);  
                    )
    public void testCCSRemoteReduce() throws Exception {
                }
            {
                "foo",
                    null,
            indices[i] = randomAlphaOfLengthBetween(5, 10);
        }
        for (int i = 0; i < indices.length; i++) {
                    latch
            1
            SearchRequest searchRequest = new SearchRequest().source(
                assertEquals(successful, searchResponse.getClusters().getSuccessful());  
                mock(ActionFilters.class),
            }
                    assertNull(setOnce.get());
            } else {  
            }
            assertTrue(TransportSearchAction.shouldMinimizeRoundtrips(searchRequest));  
                localNodes,
        {
        Map<String, OriginalIndices> remoteIndicesByCluster = new HashMap<>();  
            int originalFrom = randomIntBetween(0, 1000);
                Index existingIndex = indices[randomIntBetween(0, i - 1)];
                );  
            CountDownLatch disconnectedLatch = new CountDownLatch(numDisconnectedClusters);
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
                    assertEquals(shard.getShardId().getIndexName(), "bar");  
            assertFalse(TransportSearchAction.shouldMinimizeRoundtrips(searchRequest));
            assertFalse(TransportSearchAction.shouldMinimizeRoundtrips(searchRequest));
}  
            );
import org.opensearch.indices.IndicesService;
                assertEquals(ResolvedIndices.of("alias_a"), resolvedIndices);
                SetOnce<Tuple<SearchRequest, ActionListener<SearchResponse>>> setOnce = new SetOnce<>();  
            while (disconnectedNodes.size() < numDisconnectedClusters) {  
            );
                        new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
                if (localIndices == null) {
            remoteClusters[i] = randomAlphaOfLengthBetween(5, 10);
import org.opensearch.index.query.IdsQueryBuilder;  
                String pitId = PitTestsUtil.getPitId();  
                        // simulate scenario where the same cluster is registered multiple times with different aliases
import org.opensearch.transport.RemoteClusterService;  
                mockTransportService.close();
import org.opensearch.search.internal.AliasFilter;  
        when(clusterService.getClusterSettings()).thenReturn(
            {
                        new String[] { "some_alias_for_foo", "some_other_foo_alias" },
                TransportSearchAction.ccsRemoteReduce(  
                assertNull(setOnce.get());
                Settings.EMPTY,  
                    threadPool,  
            );  
 * not use this file except in compliance with the License.
                    if (disconnectedNodesIndices.contains(i)) {
                );
        {  
        }  
                @Override  
            null,
            for (int i : disconnectedNodesIndices) {
                remoteClusterService,  
    public void testShouldPreFilterSearchShardsWithReadOnly() {
                            i,
                    assertTrue(disconnectedNodesIndices.add(i));
                }  
        IndexMetadata.Builder indexA1 = IndexMetadata.builder("index_a1")  
            RemoteClusterServiceTests.addConnectionListener(remoteClusterService, new TransportConnectionListener() {  
            assertFalse(TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(2, 128)));  
                    IndicesOptions.lenientExpandOpen(),  
            SearchResponseMerger merger = TransportSearchAction.createSearchResponseMerger(
 *
            }  
            {
                    (r, l) -> setOnce.set(Tuple.tuple(r, l)),  
                } else {  
                assertEquals(ResolvedIndices.of("idx", "idy"), resolvedIndices);
        );
            SearchRequestTests searchRequestTests = new SearchRequestTests();
            MockTransportService service = MockTransportService.createNewService(settings, Version.CURRENT, threadPool, NoopTracer.INSTANCE)
            .putAlias(AliasMetadata.builder("alias_a").build())  
                RemoteClusterServiceTests.updateSkipUnavailable(remoteClusterService, "remote" + i, true);  
                searchRequest.preference("index_not_found");
    }  
import org.opensearch.action.OriginalIndicesTests;  
            filter.put("xyz", new AliasFilter(null, "some_alias_for_xyz"));  
                    assertNotNull(shard);
            }
                    remoteShardIterators.add(iterator);
            null,
        );  
            SearchResponseMerger merger = TransportSearchAction.createSearchResponseMerger(null, timeProvider, emptyReduceContextBuilder());
                ActionListener.wrap(r -> fail("no response expected"), failure::set),  
        {
            source.from(originalFrom);  
                    new SearchRequestContext(
 * Licensed to Elasticsearch under one or more contributor  
                        TestShardRouting.newShardRouting("bar", 0, "node1", false, ShardRoutingState.STARTED) }
                    remoteClusterService,
                    ActionListener.wrap(response::set, e -> fail("no failures expected")),  
                    assertNotNull(shard);
                            index,  
                    remoteClusterService,
            assertTrue(TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(2, 127)));
                    (r, l) -> setOnce.set(Tuple.tuple(r, l)),  
                    Tuple<SearchRequest, ActionListener<SearchResponse>> tuple = setOnce.get();
 * You may obtain a copy of the License at  
                SearchRequest searchRequest = new SearchRequest();
            assertFalse(  
                assertThat(failure.get(), instanceOf(RemoteTransportException.class));
import org.opensearch.cluster.node.DiscoveryNode;
                mock(NodeClient.class),
                    timeProvider,
                    (r, l) -> setOnce.set(Tuple.tuple(r, l)),  
                    assertTrue(iterator.shardId().getId() == 0 || iterator.shardId().getId() == 1);
import java.util.concurrent.CountDownLatch;  
            assertFalse(TransportSearchAction.shouldMinimizeRoundtrips(searchRequest));
                awaitLatch(latch, 5, TimeUnit.SECONDS);  
                assertEquals(disconnectedNodesIndices.size(), searchResponse.getClusters().getSkipped());  
                throws TransportException {}  
        };  
                    remoteIndicesByCluster,
                new DiscoveryNode("node2", buildNewFakeTransportAddress(), Version.CURRENT) };
        DiscoveryNode[] nodes = new DiscoveryNode[numClusters];  
            {
import org.opensearch.index.query.TermQueryBuilder;
                            expected.add(remoteIterator);
                    }
    }
                threadPool,  
    }
            assertTrue(  
                source,  
        Arrays.sort(remoteClusters);  
                    ClusterSearchShardsResponse shardsResponse = map.get(clusterAlias);  
import org.opensearch.test.transport.MockTransportService;
        );  
 * software distributed under the License is distributed on an
                    new ShardId("bar", "bar_id", 0),
import java.util.Set;
import org.opensearch.cluster.routing.ShardRoutingState;
        try (  
                TransportSearchAction.collectSearchShards(
                        expected.add(localIterator);
            public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options)
                            clusterAlias
            }
import java.util.concurrent.atomic.AtomicReference;  
    ) {  
 * license agreements. See the NOTICE file distributed with
            assertFalse(
            assertNull(remoteAliases.get("xyz_id").getQueryBuilder());
                TransportSearchAction.collectSearchShards(
                source.pointInTimeBuilder(null);
                latch
                    null,
 *    http://www.apache.org/licenses/LICENSE-2.0
                final CountDownLatch latch = new CountDownLatch(1);
                assertNotNull(response.get());  
            assertEquals(10, source.size());  
        }  
                assertEquals(RestStatus.NOT_FOUND, remoteTransportException.status());  
                        i,
                        ),
            int numDisconnectedClusters = randomIntBetween(1, numClusters);
            localShardIterators,
                return false;
import org.opensearch.transport.TransportException;
                    IndicesOptions.lenientExpandOpen(),  
import org.opensearch.search.SearchService;
            // give transport service enough time to realize that the node is down, and to notify the connection listeners
                mockTransportService.close();
        for (SearchShardIterator searchShardIterator : groupShardsIterator) {  
            SearchResponseMerger merger = TransportSearchAction.createSearchResponseMerger(  
            if (source != null) {
            assertTrue(TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(2, 127)));
                    ActionListener.wrap(r -> fail("no response expected"), failure::set),  
                threadPool,
                }
        String[] indices = new String[numIndices];
                ),  
            for (MockTransportService mockTransportService : mockTransportServices) {
            }
            assertTrue(TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(2, 128)));  
            SetOnce<Tuple<SearchRequest, ActionListener<SearchResponse>>> setOnce = new SetOnce<>();  
                mock(MetricsRegistry.class),
                SearchResponse searchResponse = response.get();
 * Modifications Copyright OpenSearch Contributors. See
            final CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.index.query.TermsQueryBuilder;  
            );
                    new ShardId("xyz", "xyz_id", 0),
        {
        int numIndices = randomIntBetween(2, 10);
                assertEquals("", tuple.v1().getLocalClusterAlias());
            }
            {
                    if (rarely()) {
            int trackTotalHitsUpTo = randomIntBetween(0, Integer.MAX_VALUE);  
        List<SearchShardIterator> localShardIterators = new ArrayList<>();
                ResolvedIndices resolvedIndices = action.resolveIndices(new SearchRequest("index_*"));
                awaitLatch(latch, 5, TimeUnit.SECONDS);  
                final CountDownLatch latch = new CountDownLatch(1);
        MockTransportService[] mockTransportServices = startTransport(numClusters, nodes, remoteIndicesByCluster, builder);  
                final CountDownLatch latch = new CountDownLatch(1);
        int numIndices = randomIntBetween(2, 10);
            }  
                            remoteClusterAlias
            }
            searchRequest.setCcsMinimizeRoundtrips(false);
            if (randomBoolean() && i > 0) {  
                    remoteClusterService,
        Settings.Builder builder = Settings.builder();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                LatchedActionListener<SearchResponse> listener = new LatchedActionListener<>(
                    )
                TransportSearchAction.collectSearchShards(
                TransportSearchAction.collectSearchShards(
        List<SearchShardIterator> expected = new ArrayList<>();
                    localIndices,
                        assertNotNull(map.get(clusterAlias));
            }
            return nameCompareTo;  
            .settings(settings(Version.CURRENT))
            // setting skip_unavailable to true for all the disconnected clusters will make the request succeed again
                } else if (rarely()) {
        Collections.shuffle(localShardIterators, random());
            )
        }
                TransportSearchAction.ccsRemoteReduce(
                } else {  
        }
                    Tuple<SearchRequest, ActionListener<SearchResponse>> tuple = setOnce.get();
                    remoteIndicesByCluster,
                assertThat(failure.get().getMessage(), containsString("error while communicating with remote cluster ["));  
        }  
            assertTrue(remoteAliases.toString(), remoteAliases.containsKey("foo_id"));
import org.opensearch.search.builder.PointInTimeBuilder;  
            .numberOfShards(1)  
import org.opensearch.index.query.InnerHitBuilder;
            ClusterSearchShardsGroup[] groups = new ClusterSearchShardsGroup[] {  
                Index index = indices[j];
            .numberOfReplicas(1);
            assertTrue(disconnectedLatch.await(5, TimeUnit.SECONDS));  
                AtomicReference<Exception> failure = new AtomicReference<>();
        }
        }
                        );  
                LatchedActionListener<SearchResponse> listener = new LatchedActionListener<>(
                );
import org.opensearch.search.SearchShardTarget;  
 * the Apache License, Version 2.0 (the "License"); you may
            Set<DiscoveryNode> disconnectedNodes = new HashSet<>(numDisconnectedClusters);
        {  
            if (--numReadOnly >= 0) {  
                ResolvedIndices resolvedIndices = action.resolveIndices(new SearchRequest("alias_a"));  
        for (int i = 0; i < remoteClusters.length; i++) {  
                        new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
                        // simulate scenario where the local cluster is also registered as a remote one  
                AtomicInteger skippedClusters = new AtomicInteger();
import org.opensearch.index.query.MatchAllQueryBuilder;
                (r, l) -> setOnce.set(Tuple.tuple(r, l)),  
        ) {
                "node_remote" + i,  
            searchRequest.source(new SearchSourceBuilder());
            Transport.Connection remoteConnection = connectionLookup.apply(  
            assertEquals(0, source.from());
                }
        int numClusters,  
        Function<String, DiscoveryNode> localNodes = (nodeId) -> new DiscoveryNode(  
                AtomicReference<Exception> failure = new AtomicReference<>();  
        String clusterAlias
                assertEquals(totalClusters, searchResponse.getClusters().getTotal());
            });  
                    threadPool,  
    public void testShouldMinimizeRoundtrips() throws Exception {
                    new SearchRequestContext(
/*  
            List<DiscoveryNode> knownNodes = new CopyOnWriteArrayList<>();
                    new LatchedActionListener<>(ActionListener.wrap(r -> fail("no response expected"), failure::set), latch)  
            assertTrue(remoteAliases.toString(), remoteAliases.containsKey("xyz_id"));
import org.opensearch.core.index.shard.ShardId;  
                    IndicesOptions.lenientExpandOpen(),
                    remoteIndicesByCluster,  
                assertEquals(0, skippedClusters.get());
        String[] indices = new String[numIndices];
                    new LatchedActionListener<>(ActionListener.wrap(response::set, e -> fail("no failures expected")), latch)
        {
import org.opensearch.action.support.ActionFilters;  
            assertFalse(service.isCrossClusterSearchEnabled());
                    localIndices,
            for (SearchShardIterator iterator : iteratorList) {
                    assertNull(iterator.nextOrNull());
            // SearchResponseMerger#getMergedResponse fail unexpectedly and verify that the listener is properly notified with the NPE  
                    remoteIndicesByCluster,  
                    Tuple<SearchRequest, ActionListener<SearchResponse>> tuple = setOnce.get();
            SearchRequest searchRequest = new SearchRequest();
                        .withRemoteIndices(
                    remoteIndicesByCluster,  
        Collections.shuffle(remoteShardIterators, random());
        } finally {
                public void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {
                assertEquals(totalClusters, searchResponse.getClusters().getTotal());
    public void testShouldPreFilterSearchShards() {  
                RemoteClusterServiceTests.updateSkipUnavailable(remoteClusterService, "remote" + i, true);  
                SearchRequest searchRequest = new SearchRequest();
import org.opensearch.search.pipeline.SearchPipelineService;  
                TransportSearchAction.ccsRemoteReduce(  
            for (MockTransportService mockTransportService : mockTransportServices) {  
                    new SearchRequestContext(
        OriginalIndices originalIndices,
        }
            RemoteClusterServiceTests.addConnectionListener(remoteClusterService, new TransportConnectionListener() {
            );
                    )
 * The OpenSearch Contributors require contributions made to  
            mockTransportServices[i] = remoteSeedTransport;
                    if (randomBoolean()) {
            service.clearAllRules();
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            });
                    assertNull(iterator.nextOrNull());
            SearchSourceBuilder source = searchRequest.source();  
            searchRequest.scroll("5s");
                null,
                final CountDownLatch latch = new CountDownLatch(1);
                            expected.add(remoteIterator);
                ) };  
                ) };
                assertThat(failure.get(), instanceOf(RemoteTransportException.class));
                        TestShardRouting.newShardRouting("foo", 0, "node1", true, ShardRoutingState.STARTED),
                LatchedActionListener<SearchResponse> listener = new LatchedActionListener<>(
                        expected.add(iterator);  
            null,
                AtomicInteger skippedClusters = new AtomicInteger(0);
    }
                    "index_not_found",
                searchSourceBuilder.pointInTimeBuilder(new PointInTimeBuilder(pitId));
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.common.SetOnce;
                SearchRequest searchRequest = new SearchRequest();
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
                remoteAliases
            Transport.Connection localConnection = connectionLookup.apply(null, randomAlphaOfLengthBetween(5, 10));
                    SearchShardIterator iterator = createSearchShardIterator(
                }  
                        searchRequest,
                    null,
            CollapseBuilder collapseBuilder = new CollapseBuilder("field");
                    assertEquals("", tuple.v1().getLocalClusterAlias());
                if (localIndices == null) {
                    shard = iterator.nextOrNull();
                        } else {  
import java.util.HashMap;  
public class TransportSearchActionTests extends OpenSearchTestCase {  
                        RemoteClusterServiceTests.updateSkipUnavailable(remoteClusterService, "remote" + i, true);
import java.util.HashSet;
                    assertTrue(map.containsKey(clusterAlias));
                    if (randomBoolean()) {
                    remoteIndicesByCluster,
                AtomicInteger skippedClusters = new AtomicInteger(0);
                assertNotNull(failure.get());
                assertEquals(totalClusters, searchResponse.getClusters().getSuccessful());
            new TransportAddress(TransportAddress.META_ADDRESS, 2048),
                    new ShardRouting[] { TestShardRouting.newShardRouting("xyz", 0, "node3", true, ShardRoutingState.STARTED) }  
            List<SearchShardIterator> iteratorList = TransportSearchAction.getRemoteShardsIterator(
            new TransportAddress(TransportAddress.META_ADDRESS, 1024),
            }  
    }  
                    assertNotNull(shard);
import org.opensearch.search.aggregations.InternalAggregations;
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT).blocks(blocksBuilder).build();
import org.opensearch.cluster.metadata.IndexMetadata;  
                if (disconnectedNodes.add(nodes[i])) {  
                localIndices,
                assertNotNull(response.get());
        {
        Function<Boolean, InternalAggregation.ReduceContext> reduceContext = finalReduce -> null;
                    assertArrayEquals(  
                    null,  
        OriginalIndices localIndices = local ? new OriginalIndices(new String[] { "index" }, SearchRequest.DEFAULT_INDICES_OPTIONS) : null;  
            false,  
            {  
                assertEquals(0, searchResponse.getClusters().getSkipped());
                indexNameExpressionResolver,
        {  
        try (  
                );  
                        () -> null
                        TestShardRouting.newShardRouting("foo", 0, "node2", false, ShardRoutingState.STARTED) }
            ClusterSearchShardsGroup[] groups2 = new ClusterSearchShardsGroup[] {  
    }
                }  
                TransportSearchAction.collectSearchShards(  
                );
                    tuple.v2().onResponse(emptySearchResponse());  
                    for (int k = 0; k < numClusters; k++) {  
                assertEquals(  
            if (nameCompareTo == 0) {  
import java.util.List;
/*
        }
            );  
            remoteShardIterators  
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsGroup;
                    threadPool,
            remoteIndices.put("remote" + i, new OriginalIndices(new String[] { "index" }, IndicesOptions.lenientExpandOpen()));
            {  
import org.opensearch.cluster.routing.GroupShardsIteratorTests;  
            SearchTransportService searchTransportService = mock(SearchTransportService.class);
            assertTrue(TransportSearchAction.shouldMinimizeRoundtrips(searchRequest));  
import org.opensearch.cluster.ClusterName;
                awaitLatch(latch, 5, TimeUnit.SECONDS);
                    new ShardId("foo", "foo_id", 1),
            // the intention here is not to test that we throw NPE, rather to trigger a situation that makes
                mock(Tracer.class),
                    assertThat(tuple.v2(), instanceOf(TransportSearchAction.CCSActionListener.class));
            indicesAndAliases.put("bar", new AliasFilter(new MatchAllQueryBuilder(), Strings.EMPTY_ARRAY));
                awaitLatch(latch, 5, TimeUnit.SECONDS);  
                    searchRequest,
            awaitLatch(latch, 5, TimeUnit.SECONDS);  
            assertTrue(TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(2, 127)));  
        DiscoveryNode[] nodes = new DiscoveryNode[numClusters];
                );
                SetOnce<Tuple<SearchRequest, ActionListener<SearchResponse>>> setOnce = new SetOnce<>();  
                    IndicesOptions.lenientExpandOpen(),  
                assertEquals(totalClusters == 1 ? 1 : totalClusters + 1, searchResponse.getNumReducePhases());
            assertFalse(
            assertEquals(originalFrom + originalSize, source.size());
import org.opensearch.threadpool.ThreadPool;  
import org.opensearch.wlm.WorkloadGroupService;
                TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(129, 10000))
                nodeToConnection
            );
                            Map.of("remote1", new OriginalIndices(new String[] { "remote_index" }, IndicesOptions.LENIENT_EXPAND_OPEN))  
package org.opensearch.action.search;
                    IndicesOptions.lenientExpandOpen(),
                        OriginalIndicesTests.randomOriginalIndices(),
                    threadPool,  
            {  
        }
            );
                    assertNotNull(map.get(clusterAlias));  
        Settings settings = builder.build();
            );
                        SearchShardIterator remoteIterator = createSearchShardIterator(
                    SearchShardTarget shard = iterator.nextOrNull();
            Transport.Connection localConnection = connectionLookup.apply(requestClusterAlias, randomAlphaOfLengthBetween(5, 10));  
                assertEquals(RestStatus.NOT_FOUND, remoteTransportException.status());
            Set<DiscoveryNode> disconnectedNodes = new HashSet<>(numDisconnectedClusters);
                    remoteIndicesByCluster,
                searchShardsResponseMap,
            ;
                final CountDownLatch latch = new CountDownLatch(1);
                        () -> null
import org.opensearch.search.builder.SearchSourceBuilder;
            collapseBuilder.setInnerHits(new InnerHitBuilder("inner"));
                    expected.add(iterator);
            SearchRequest searchRequest = new SearchRequest();
                AtomicReference<Map<String, ClusterSearchShardsResponse>> response = new AtomicReference<>();  
                    null,
import org.opensearch.core.action.ActionListener;
            service.start();  
            SearchRequest searchRequest = searchRequestTests.createSearchRequest();  
                    listener,
        } finally {
                }  
            );  
                    threadPool,
import org.opensearch.common.collect.Tuple;  
            remoteIndicesByCluster.put("test_cluster_2", new OriginalIndices(new String[] { "x*" }, SearchRequest.DEFAULT_INDICES_OPTIONS));
        ) {
            BiFunction<String, String, Transport.Connection> connectionLookup = TransportSearchAction.buildConnectionLookup(  
                }
        MockTransportService[] mockTransportServices = startTransport(numClusters, nodes, remoteIndicesByCluster, builder);  
                    emptyReduceContextBuilder(),
                    searchRequest,
                awaitLatch(latch, 5, TimeUnit.SECONDS);
                    searchRequest,
                new NamedWriteableRegistry.Entry(QueryBuilder.class, IdsQueryBuilder.NAME, IdsQueryBuilder::new)  
            Map<String, AliasFilter> indicesAndAliases = new HashMap<>();  
                );
                        SearchShardIterator iterator = createSearchShardIterator(  
                mock(TransportService.class),
                    assertThat(tuple.v2(), instanceOf(TransportSearchAction.CCSActionListener.class));  
            assertEquals(SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO, merger.trackTotalHitsUpTo);
                namedWriteableRegistry,  
            assertEquals(10, merger.size);  
            @Override
                searchTransportService,
import org.opensearch.search.SearchHits;
            }
            service.acceptIncomingRequests();
        {
                randomAlphaOfLengthBetween(5, 10),
        int totalClusters = numClusters + (local ? 1 : 0);
            Map<String, ClusterSearchShardsResponse> searchShardsResponseMap = new HashMap<>();
                    new ShardRouting[] {  
            assertEquals(SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO, merger.trackTotalHitsUpTo);
                SearchResponse searchResponse = response.get();
            assertEquals(0, service.getConnectionManager().size());
                    );  
import org.opensearch.core.common.transport.TransportAddress;
                awaitLatch(latch, 5, TimeUnit.SECONDS);
        Index[] indices = new Index[randomIntBetween(1, 10)];
                mock(SearchPipelineService.class),
                new SearchRequestContext(
                public void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {
                AtomicReference<SearchResponse> response = new AtomicReference<>();  
                    skippedClusters,  
                    assertEquals("xyz", iterator.shardId().getIndexName());
            {  
            CountDownLatch disconnectedLatch = new CountDownLatch(numDisconnectedClusters);
        TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(0, 0, () -> 0);
import org.opensearch.transport.RemoteClusterConnectionTests;
                new SearchSourceBuilder().query(QueryBuilders.rangeQuery("timestamp"))  
                );  
            Map<String, AliasFilter> filter = new HashMap<>();
        TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(0, 0, () -> 0);  
            service.acceptIncomingRequests();
                            index,
import java.util.function.BiFunction;
        Index index,  
                );
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            assertFalse(TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(2, 128)));  
                    null,
        String localClusterAlias = randomAlphaOfLengthBetween(5, 10);  
 * compatible open source license.
                new ClusterSearchShardsGroup(
                    }
    public void testCollectSearchShards() throws Exception {  
            SearchRequest searchRequest = new SearchRequest().source(  
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
        {  
                assertThat(tuple.v2(), instanceOf(TransportSearchAction.CCSActionListener.class));  
                LatchedActionListener<SearchResponse> listener = new LatchedActionListener<>(
                    assertTrue(map.containsKey(clusterAlias));
            }
        );  
import org.opensearch.cluster.ClusterState;  
            assertEquals(3, remoteAliases.size());
                );  
    }  
                    threadPool,
                    timeProvider,  
                TransportSearchAction.ccsRemoteReduce(  
                    null,
            }
            searchRequest.searchType(SearchType.QUERY_THEN_FETCH);
                        () -> null  
            assertThat(localConnection.getNode().getId(), startsWith("local-"));
            TransportSearchAction.ccsRemoteReduce(  
import static org.hamcrest.CoreMatchers.containsString;  
        Map<String, OriginalIndices> remoteIndicesByCluster = new HashMap<>();
                        assertFalse(map.containsKey(clusterAlias));
                awaitLatch(latch, 5, TimeUnit.SECONDS);
        for (int i = 0; i < numClusters; i++) {  
                TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(127, 10000))
                    Tuple<SearchRequest, ActionListener<SearchResponse>> tuple = setOnce.get();  
        }
            assertEquals(4, iteratorList.size());  
    }
                    String clusterAlias = "remote" + i;  
import org.opensearch.transport.client.node.NodeClient;  
            for (DiscoveryNode disconnectedNode : disconnectedNodes) {
        });
                new SearchSourceBuilder().query(QueryBuilders.rangeQuery("timestamp"))
                int successful = totalClusters - disconnectedNodesIndices.size();
            indicesAndAliases.put(
        }
            Set<Integer> disconnectedNodesIndices = new HashSet<>(numDisconnectedClusters);  
                new ClusterSearchShardsGroup(
                    assertThat(tuple.v2(), instanceOf(TransportSearchAction.CCSActionListener.class));  
    public void testProcessRemoteShards() {  
        return new SearchShardIterator(clusterAlias, shardId, shardRoutings, originalIndices);  
                mock(CircuitBreakerService.class),
                    new SearchRequestContext(  
                    emptyReduceContextBuilder(),
import org.opensearch.core.common.Strings;
        } finally {  
            }
        assertEquals(expected, result);  
        Settings settings = builder.build();
            String requestClusterAlias = randomAlphaOfLengthBetween(5, 10);
            );
                SearchResponse searchResponse = response.get();
            // so that RemoteClusterConnection is left with no connected nodes, hence it will retry connecting next
            }
                tuple.v2().onResponse(emptySearchResponse());
                TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(127, 10000))  
            // give transport service enough time to realize that the node is down, and to notify the connection listeners  
            assertFalse(TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(2, 127)));
    }
                }
            source.collapse(collapseBuilder);  
import java.util.Collections;
                TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(129, 10000))
                indices[i] = new Index(existingIndex.getName(), randomAlphaOfLength(10));
                boolean localIndex = randomBoolean();  
                final CountDownLatch latch = new CountDownLatch(1);
            while (disconnectedNodes.size() < numDisconnectedClusters) {
                assertEquals(numClusters - disconnectedNodesIndices.size(), map.size());  
            SearchRequest searchRequest = new SearchRequest();
            RemoteClusterService remoteClusterService = service.getRemoteClusterService();
                    assertThat(tuple.v2(), instanceOf(TransportSearchAction.CCSActionListener.class));  
                } else {  
                source,
                    null,
                if (disconnectedNodes.add(nodes[i])) {
            assertThat(remoteConnection.getNode().getId(), startsWith("remote-"));
            }
                }
                mockTransportService.close();
                timeProvider,
            SearchRequest searchRequest = new SearchRequest();
    private static SearchShardIterator createSearchShardIterator(
                    } else {  
                    remoteClusterService,  
                remoteIndicesByCluster,  
                } else if (iterator.shardId().getIndexName().endsWith("xyz")) {
import org.opensearch.tasks.TaskResourceTrackingService;
                    emptyReduceContextBuilder(),
            assertTrue(remoteAliases.toString(), remoteAliases.containsKey("bar_id"));  
                }
            // setting skip_unavailable to true for all the disconnected clusters will make the request succeed again
            assertTrue(
                final CountDownLatch latch = new CountDownLatch(1);
                            expected.add(localIterator);
                AtomicReference<Map<String, ClusterSearchShardsResponse>> response = new AtomicReference<>();
        ShardId shardId = new ShardId(index, id);
                assertEquals(ResolvedIndices.of("index_a1", "index_a2"), resolvedIndices);
import org.opensearch.transport.TransportRequestOptions;
                    () -> null
                    ActionListener.wrap(response::set, e -> fail("no failures expected")),
                Tuple<SearchRequest, ActionListener<SearchResponse>> tuple = setOnce.get();
                CollapseBuilder collapse = source.collapse();  
import java.util.concurrent.atomic.AtomicInteger;
        OriginalIndices localIndices = local ? new OriginalIndices(new String[] { "index" }, SearchRequest.DEFAULT_INDICES_OPTIONS) : null;  
                    timeProvider,
                RemoteTransportException remoteTransportException = (RemoteTransportException) failure.get();
import static org.mockito.Mockito.when;
import org.opensearch.telemetry.metrics.MetricsRegistry;  
        ) {  
                clusterService,  
                new ClusterSearchShardsGroup(
                new SearchSourceBuilder().query(QueryBuilders.rangeQuery("timestamp"))  
                        TestShardRouting.newShardRouting("foo", 1, "node2", false, ShardRoutingState.STARTED) }
        String[] remoteClusters = new String[randomIntBetween(1, 3)];
        MockTransportService[] mockTransportServices = startTransport(numClusters, nodes, remoteIndicesByCluster, builder);
                assertEquals(0, skippedClusters.get());
                    blocksBuilder.addIndexBlock(indices[i], IndexMetadata.INDEX_READ_ONLY_BLOCK);
import java.util.Map;  
                    threadPool,
            assertEquals(0, merger.from);
            }  
                    remoteClusterService,  
 * under the License.  
                    localIndices,
            if (localIndices == null) {
                mock(WorkloadGroupService.class)
                        disconnectedLatch.countDown();
            {
            @Override
            .numberOfReplicas(1);  
        int numReadOnly = randomIntBetween(1, numIndices);  
                    timeProvider,
                remoteIndicesByCluster,  
                    new LatchedActionListener<>(ActionListener.wrap(response::set, e -> fail("no failures expected")), latch)
            }
                    threadPool,
                new SearchRequestOperationsCompositeListenerFactory(),  
            }  
import static org.hamcrest.CoreMatchers.startsWith;
                TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(127, 10000))
                    SearchShardTarget shard = iterator.nextOrNull();
            Version.CURRENT
                awaitLatch(latch, 5, TimeUnit.SECONDS);
        Map<String, OriginalIndices> remoteIndicesByCluster = new HashMap<>();
            } else {  
        }  
                        iterator.getOriginalIndices().indices()
import org.opensearch.common.util.concurrent.ThreadContext;  
            @Override
                    null,  
            );
            assertTrue(disconnectedLatch.await(5, TimeUnit.SECONDS));
import org.opensearch.threadpool.TestThreadPool;
                        TestShardRouting.newShardRouting("foo", 0, "node1", true, ShardRoutingState.STARTED),
                    remoteIndicesByCluster,  
            }  
                }
            MockTransportService service = MockTransportService.createNewService(settings, Version.CURRENT, threadPool, NoopTracer.INSTANCE)
            assertEquals(trackTotalHitsUpTo, (int) source.trackTotalHitsUpTo());  
        Settings.Builder builder = Settings.builder();
import org.opensearch.cluster.routing.TestShardRouting;  
import org.opensearch.search.sort.SortBuilders;
                ResolvedIndices resolvedIndices = action.resolveIndices(new SearchRequest("index_*", "remote1:remote_index"));
            SearchRequest searchRequest = new SearchRequest();  
                searchRequest,
                    new ShardId("foo", "foo_id", 0),
                    SearchShardIterator localIterator = createSearchShardIterator(i, index, localIndices, localClusterAlias);
            @Override
import org.opensearch.search.Scroll;
                }
            }
            // Actual test cases start here:
                    latch
        List<ShardRouting> shardRoutings = GroupShardsIteratorTests.randomShardRoutings(shardId);
                    searchRequest,  
            searchShardsResponseMap.put("test_cluster_2", new ClusterSearchShardsResponse(groups2, nodes2, filter));
                nodeToConnection  
        Settings.Builder builder = Settings.builder();
            assertTrue(
            for (MockTransportService mockTransportService : mockTransportServices) {
        OriginalIndices localIndices = OriginalIndicesTests.randomOriginalIndices();
            searchShardsResponseMap.put("test_cluster_1", new ClusterSearchShardsResponse(groups, nodes, indicesAndAliases));
                        remoteShardIterators.add(iterator);
                TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(127, 10000))  
            if (randomBoolean()) {
                "test_cluster_1",
                        );
        }
            int numDisconnectedClusters = randomIntBetween(1, numClusters);  
                remoteNodes,  
                            OriginalIndicesTests.randomOriginalIndices(),  
                    assertEquals(0, iterator.shardId().getId());
                    assertEquals("", tuple.v1().getLocalClusterAlias());
        boolean local = randomBoolean();
        {
                AtomicInteger skippedClusters = new AtomicInteger(0);  
 * GitHub history for details.
import org.opensearch.search.internal.SearchContext;
        {
                    }
            DiscoveryNode[] nodes2 = new DiscoveryNode[] { new DiscoveryNode("node3", buildNewFakeTransportAddress(), Version.CURRENT) };
            assertEquals(new TermsQueryBuilder("foo", "bar"), remoteAliases.get("foo_id").getQueryBuilder());
import org.opensearch.cluster.block.ClusterBlocks;
                if (collapse != null) {
            settingsBuilder.put("cluster.remote.remote" + i + ".seeds", remoteSeedNode.getAddress().toString());  
            SearchRequest searchRequest = new SearchRequest();  
        }
        ) {
                final CountDownLatch latch = new CountDownLatch(1);
                    assertEquals("bar", iterator.shardId().getIndexName());  
                    remoteClusterService,  
                    Tuple<SearchRequest, ActionListener<SearchResponse>> tuple = setOnce.get();
            assertEquals(originalSize, merger.size);
import org.opensearch.action.LatchedActionListener;
        TransportSearchAction.SearchTimeProvider timeProvider = new TransportSearchAction.SearchTimeProvider(0, 0, () -> 0);
        try (
                    latch
            DiscoveryNode[] nodes = new DiscoveryNode[] {  
        );
            source.trackTotalHitsUpTo(trackTotalHitsUpTo);
            Map<String, OriginalIndices> remoteIndicesByCluster = new HashMap<>();  
                    new SearchRequestContext(
                        new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
            .build();  
            DiscoveryNode remoteSeedNode = remoteSeedTransport.getLocalDiscoNode();  
                localNodes,
                    remoteClusterService,  
                    searchRequest,  
                    int numClusters = randomIntBetween(1, remoteClusters.length);
        Settings.Builder builder = Settings.builder();  
                    new ShardRouting[] {  
                remoteNodes,
                final CountDownLatch latch = new CountDownLatch(1);  
        ClusterService clusterService = mock(ClusterService.class);
                        String clusterAlias = remoteClusters[k];
                );  
import org.opensearch.search.aggregations.InternalAggregation;
            .metadata(Metadata.builder().put(indexA1).put(indexA2))
                    assertEquals("", tuple.v1().getLocalClusterAlias());
        try (  
            LatchedActionListener<SearchResponse> listener = new LatchedActionListener<>(
                    assertNotNull(shard);
                LatchedActionListener<SearchResponse> listener = new LatchedActionListener<>(
                assertNotNull(failure.get());  
import org.opensearch.transport.RemoteTransportException;
        Settings.Builder settingsBuilder  
        int numClusters = randomIntBetween(2, 10);
            int originalSize = randomIntBetween(0, 1000);
                    tuple.v2().onResponse(emptySearchResponse());
                if (localIndex) {
        {  
import static org.hamcrest.CoreMatchers.instanceOf;
                assertEquals(0, skippedClusters.get());
            RemoteClusterService remoteClusterService = service.getRemoteClusterService();  
        IndexNameExpressionResolver indexNameExpressionResolver = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
import org.opensearch.transport.Transport;  
import java.util.concurrent.TimeUnit;
        } finally {  
                    new LatchedActionListener<>(ActionListener.wrap(response::set, e -> fail("no failures expected")), latch)
            SearchSourceBuilder source = new SearchSourceBuilder();
            source.size(originalSize);
                } else {
                    resolvedIndices
        try (
    }
                knownNodes,
        }
                AtomicInteger skippedClusters = new AtomicInteger(0);
        BiFunction<String, DiscoveryNode, Transport.Connection> nodeToConnection = (clusterAlias, node) -> new Transport.Connection() {
import org.opensearch.search.collapse.CollapseBuilder;
                mockTransportService.close();  
                        () -> null
            assertNull(source.trackTotalHitsUpTo());
                assertEquals(numClusters, map.size());
        int numClusters = randomIntBetween(2, 10);
        for (int i = 0; i < numIndices; i++) {  
import org.opensearch.transport.TransportService;
                    new LatchedActionListener<>(ActionListener.wrap(r -> fail("no response expected"), failure::set), latch)
import org.opensearch.cluster.service.ClusterService;
        int numClusters = randomIntBetween(1, 10);
                    ActionListener.wrap(r -> fail("no response expected"), failure::set),  
import org.opensearch.telemetry.tracing.Tracer;
        }  
                            i,
                        remoteShardIterators.add(remoteIterator);
                    skippedClusters,  
                TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(127, 10000))
import java.util.ArrayList;  
                    emptyReduceContextBuilder(),
        int numClusters = 2;  
                assertNotNull(response.get());  
        }  
import org.opensearch.cluster.routing.ShardRouting;
    }
                Version.CURRENT,
                int i = randomIntBetween(0, numClusters - 1);
import org.opensearch.index.query.QueryBuilder;  
            );
                assertEquals(successful == 0 ? 0 : successful + 1, searchResponse.getNumReducePhases());
                SetOnce<Tuple<SearchRequest, ActionListener<SearchResponse>>> setOnce = new SetOnce<>();  
                        searchRequest,  
                ),  
            InternalAggregations.EMPTY,  
            }  
            );
                timeProvider,
        {
            );
            public boolean isClosed() {  
                for (int i : disconnectedNodesIndices) {  
                    listener,
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;
            indices[i] = randomAlphaOfLengthBetween(5, 10);
            assertEquals(0, merger.from);
                } else {  
            );
                assertThat(failure.get(), instanceOf(RemoteTransportException.class));
            }
                    shard = iterator.nextOrNull();
                        new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
        DiscoveryNode[] nodes = new DiscoveryNode[numClusters];
 */  
        }
    private static SearchResponse emptySearchResponse() {  
            int nameCompareTo = o1.getName().compareTo(o2.getName());
        {
                new SearchPhaseController(namedWriteableRegistry, (searchSourceBuilder) -> null),
        }
                    tuple.v2().onResponse(emptySearchResponse());
                    assertEquals("test_cluster_2", iterator.getClusterAlias());  
                    null,
 * Unless required by applicable law or agreed to in writing,
            .numberOfShards(1)
                    remoteClusterService,
                for (int i = 0; i < numClusters; i++) {  
            new SearchHits(new SearchHit[0], new TotalHits(0, TotalHits.Relation.EQUAL_TO), Float.NaN),
    }
        }
                assertNotNull(failure.get());
                @Override
        }
                AtomicReference<SearchResponse> response = new AtomicReference<>();
            RemoteClusterService service = transportService.getRemoteClusterService();  
 * ownership. Elasticsearch licenses this file to you under  
        }
                assertThat(failure.get().getCause(), instanceOf(NodeDisconnectedException.class));
        List<SearchShardIterator> result = new ArrayList<>();
            if (randomBoolean()) {  
                new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT),
                TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(129, 10000))
        ) {
                    assertNotNull(shard);
            );
            Set<Integer> disconnectedNodesIndices = new HashSet<>(numDisconnectedClusters);
                        assert remoteClusterAlias.equals(localClusterAlias) == false;
        Map<String, OriginalIndices> remoteIndicesByCluster = new HashMap<>();
                    assertNull(setOnce.get());
        DiscoveryNode[] nodes,
                    );  
    public void tearDown() throws Exception {
            assertFalse(TransportSearchAction.shouldPreFilterSearchShards(clusterState, searchRequest, indices, randomIntBetween(2, 127)));
            for (int i : disconnectedNodesIndices) {
                SetOnce<Tuple<SearchRequest, ActionListener<SearchResponse>>> setOnce = new SetOnce<>();  
import org.opensearch.action.OriginalIndices;
                    assertArrayEquals(new String[] { "some_alias_for_xyz" }, iterator.getOriginalIndices().indices());  
            service.start();
        DiscoveryNode[] nodes = new DiscoveryNode[numClusters];  
                    blocksBuilder.addIndexBlock(indices[i], IndexMetadata.INDEX_WRITE_BLOCK);
                Map<String, ClusterSearchShardsResponse> map = response.get();
                    assertEquals(shard.getShardId().getIndexName(), "xyz");  
                }
    public void testResolveIndices() {
        {  
                new OriginalIndices(new String[] { "fo*", "ba*" }, SearchRequest.DEFAULT_INDICES_OPTIONS)  
                mock(TaskResourceTrackingService.class),
            searchRequest.searchType(SearchType.DFS_QUERY_THEN_FETCH);  
    public void testBuildConnectionLookup() {
                emptyReduceContextBuilder(),
            RemoteClusterService remoteClusterService = service.getRemoteClusterService();
    public void testCreateSearchResponseMerger() {
