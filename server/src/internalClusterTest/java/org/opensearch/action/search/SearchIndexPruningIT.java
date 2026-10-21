                failure.set(e);
        publishFieldDomain("logs-000002", new DateRangeFieldDomain("@timestamp", 2_000L, 4_000L, true, "test"));
                .setPersistentSettings(
    public void testSearchUsesIndexFieldDomainMetadataBeforeCanMatch() throws Exception {
        assertHitCount(response, 1L);
        createLogsIndices();
        publishFieldDomain("logs-000001", new DateRangeFieldDomain("@timestamp", 1_000L, 2_000L, true, "test"));
        RecordOldIndexSearchPlugin.OLD_INDEX_QUERY_PHASES.set(0);
                }
                            actualHandler.messageReceived(request, channel, task);
        ClusterService clusterService = internalCluster().getClusterManagerNodeInstance(ClusterService.class);
        } finally {
        index("logs-000001", "_doc", "1", "@timestamp", "1970-01-01T00:00:01Z", "message", "old");
            RecordOldIndexSearchPlugin.OLD_INDEX_QUERY_PHASES.set(0);
import java.util.List;
            RecordOldIndexSearchPlugin.RECORD_SEARCH_EVENTS.set(false);
            });
            }
                    } else if ("logs-000002".equals(indexName) || "logs-000003".equals(indexName)) {
                .addSort("@timestamp", SortOrder.ASC)
        );
                        @Override
            assertHitCount(response, 1L);
import java.util.concurrent.atomic.AtomicBoolean;
 *
                return ClusterState.builder(currentState).metadata(metadata).build();
                .get();
                        OLD_INDEX_QUERY_PHASES.incrementAndGet();
    }
            publishFieldDomain("logs-000001", new DateRangeFieldDomain("@timestamp", 1_000L, 2_000L, true, "test"));
                .cluster()
    private void enableIndexPruning() {
    }
        }
        CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.plugins.NetworkPlugin;
                response = client().prepareSearch("logs-*")
        enableIndexPruning();
        assertAcked(prepareCreate("logs-000003").setSettings(indexSettings).setMapping("@timestamp", "type=date"));
                    .get();
import java.util.concurrent.atomic.AtomicInteger;
        Settings indexSettings = Settings.builder()
 * The OpenSearch Contributors require contributions made to
            }
        private static final AtomicInteger OLD_INDEX_QUERY_PHASES = new AtomicInteger();
                .get()
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
import org.opensearch.common.Priority;
        assertAcked(prepareCreate("logs-000002").setSettings(indexSettings).setMapping("@timestamp", "type=date"));
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.cluster.ClusterStateUpdateTask;
        SearchResponse response = searchWithIndexFieldDomainMetadata(1_000);
    public static class RecordOldIndexSearchPlugin extends Plugin implements NetworkPlugin {
                    if (RECORD_SEARCH_EVENTS.get() == false) {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    }
    }
        index("logs-000001", "_doc", "1", "@timestamp", "1970-01-01T00:00:01Z", "message", "old");
        assertThat(RecordOldIndexSearchPlugin.OLD_INDEX_QUERY_PHASES.get(), equalTo(0));
import org.opensearch.cluster.metadata.Metadata;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            publishFieldDomain("logs-000002", new DateRangeFieldDomain("@timestamp", 3_000L, 4_000L, true, "test"));
        assertThat(RecordOldIndexSearchPlugin.OLD_INDEX_CAN_MATCH_REQUESTS.get(), equalTo(0));
        createPitRequest.setIndices(new String[] { "logs-*" });
        publishFieldDomain("logs-000003", new DateRangeFieldDomain("@timestamp", 4_000L, 6_000L, true, "test"));
    private void publishFieldDomain(String index, DateRangeFieldDomain domain) throws Exception {
                .setQuery(rangeQuery("@timestamp").gte("1970-01-01T00:00:03Z").lte("1970-01-01T00:00:06Z"))
                .prepareUpdateSettings()
        publishFieldDomain("logs-000001", new DateRangeFieldDomain("@timestamp", 1_000L, 2_000L, true, "test"));
            public ClusterState execute(ClusterState currentState) {
package org.opensearch.action.search;
        }
        RecordOldIndexSearchPlugin.RECORD_SEARCH_EVENTS.set(true);
@ClusterScope(scope = Scope.TEST, numDataNodes = 1, numClientNodes = 0, supportsDedicatedMasters = false)
            .build();
                Metadata metadata = Metadata.builder(currentState.metadata()).put(updated, true).build();
        try {
        publishFieldDomain("logs-000002", new DateRangeFieldDomain("@timestamp", 3_000L, 4_000L, true, "test"));
        refresh("logs-000001", "logs-000002");
        assertHitCount(response, 1L);
import org.opensearch.index.fielddomain.IndexFieldDomainMetadata;
                    .setQuery(rangeQuery("@timestamp").gte("1970-01-01T00:00:03Z").lte("1970-01-01T00:00:04Z"))
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        private static void recordCanMatchRequest(TransportRequest request) {
                    failure.set(new IllegalStateException("index [" + index + "] not found in cluster state"));
                    }
        refresh("logs-000001", "logs-000002", "logs-000003");
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                    boolean forceExecution,
            RecordOldIndexSearchPlugin.OVERLAPPING_INDEX_QUERY_PHASES.set(0);
            SearchResponse response;
                CAN_MATCH_REQUESTS.incrementAndGet();
                .get();
        SearchResponse response = searchWithIndexFieldDomainMetadata(1);
            throw failure.get();
import org.opensearch.search.builder.PointInTimeBuilder;
        assertThat(RecordOldIndexSearchPlugin.OLD_INDEX_QUERY_PHASES.get(), equalTo(0));
        resetSearchEventCounters();
            if (RECORD_SEARCH_EVENTS.get() && request instanceof ShardSearchRequest) {
        index("logs-000003", "_doc", "1", "@timestamp", "1970-01-01T00:00:05Z", "message", "partial-right");
        return List.of(RecordOldIndexSearchPlugin.class);
            return List.of(new TransportInterceptor() {
}
import java.util.concurrent.TimeUnit;
    @Override
import org.opensearch.search.internal.ShardSearchRequest;
        assertThat(RecordOldIndexSearchPlugin.OVERLAPPING_INDEX_QUERY_PHASES.get(), greaterThan(0));
        @Override
import org.opensearch.common.util.concurrent.ThreadContext;
    }
        index("logs-000002", "_doc", "1", "@timestamp", "1970-01-01T00:00:03.500Z", "message", "partial-left");
        ) {
import org.opensearch.cluster.metadata.IndexMetadata;
                    TransportRequestHandler<T> actualHandler
                    OLD_INDEX_CAN_MATCH_REQUESTS.incrementAndGet();
                    }
            RecordOldIndexSearchPlugin.OLD_INDEX_CAN_MATCH_REQUESTS.set(0);
    }
    }
 * this file be licensed under the Apache-2.0 license or a
                @Override
        enableIndexPruning();
import org.opensearch.action.search.pruning.SearchIndexPruningSettings;
                    String action,
    public void testSearchUsesIndexFieldDomainMetadataToSkipShardGroups() throws Exception {
        } finally {
                        public void messageReceived(T request, TransportChannel channel, Task task) throws Exception {
            RecordOldIndexSearchPlugin.CAN_MATCH_REQUESTS.set(0);
import org.opensearch.common.settings.Settings;
            RecordOldIndexSearchPlugin.RECORD_SEARCH_EVENTS.set(false);
                        }
                )
        assertTrue(latch.await(30, TimeUnit.SECONDS));
        if (failure.get() != null) {
                .cluster()
        resetSearchEventCounters();
/*
import org.opensearch.transport.TransportRequestHandler;
                    };
        }
                    .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
        public List<TransportInterceptor> getTransportInterceptors(
        CreatePitRequest createPitRequest = new CreatePitRequest(TimeValue.timeValueDays(1), true);
            client().admin()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                .addSort("@timestamp", SortOrder.ASC)
                    }
import org.opensearch.transport.TransportChannel;
import static org.opensearch.index.query.QueryBuilders.rangeQuery;
                    String executor,
            }
                RecordOldIndexSearchPlugin.RECORD_SEARCH_EVENTS.set(false);
            } finally {
        }
        try {
            @Override
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.service.ClusterService;
import static org.hamcrest.Matchers.equalTo;
        try {
                .setPersistentSettings(Settings.builder().putNull("search.index_pruning.*"))
                }
        refresh("logs-000001", "logs-000002");
            indexModule.addSearchOperationListener(new SearchOperationListener() {
        @Override
import java.util.concurrent.atomic.AtomicReference;
        assertHitCount(response, 2L);
                        OVERLAPPING_INDEX_QUERY_PHASES.incrementAndGet();
                ShardSearchRequest shardSearchRequest = (ShardSearchRequest) request;
                    Settings.builder()
                        return actualHandler;
 */
                .setQuery(rangeQuery("@timestamp").gte("1970-01-01T00:00:03Z").lte("1970-01-01T00:00:04Z"))
import org.opensearch.transport.TransportRequest;
                        .putList(SearchIndexPruningSettings.FIELDS.getKey(), "@timestamp")
            ThreadContext threadContext
                .setPreFilterShardSize(1)
import org.opensearch.transport.TransportInterceptor;
    }
            }
                latch.countDown();
    private void createLogsIndices() {
        }
        SearchResponse response;
        index("logs-000002", "_doc", "1", "@timestamp", "1970-01-01T00:00:03.500Z", "message", "current");
        RecordOldIndexSearchPlugin.CAN_MATCH_REQUESTS.set(0);
        private static final AtomicInteger OLD_INDEX_CAN_MATCH_REQUESTS = new AtomicInteger();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            response = client().prepareSearch("logs-*")
                IndexMetadata current = currentState.metadata().index(index);
                .prepareUpdateSettings()
                .setPreFilterShardSize(preFilterShardSize)
        clusterService.submitStateUpdateTask("put-index-field-domain [" + index + "]", new ClusterStateUpdateTask(Priority.URGENT) {
            resetSearchEventCounters();
    }
        private static final AtomicInteger CAN_MATCH_REQUESTS = new AtomicInteger();
                        return;
public class SearchIndexPruningIT extends OpenSearchIntegTestCase {
        private static final AtomicBoolean RECORD_SEARCH_EVENTS = new AtomicBoolean();
import org.opensearch.cluster.ClusterState;
            });
                public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(
        index("logs-000002", "_doc", "1", "@timestamp", "1970-01-01T00:00:10Z", "message", "current");
        }
        CreatePitResponse pitResponse = client().execute(CreatePitAction.INSTANCE, createPitRequest).actionGet();
                @Override
    }
        createLogsIndices();
 * compatible open source license.
        RecordOldIndexSearchPlugin.OLD_INDEX_CAN_MATCH_REQUESTS.set(0);
        ensureGreen("logs-000001", "logs-000002", "logs-000003");
    }
            RecordOldIndexSearchPlugin.RECORD_SEARCH_EVENTS.set(true);
        assertThat(RecordOldIndexSearchPlugin.OLD_INDEX_QUERY_PHASES.get(), equalTo(0));
            return client().prepareSearch("logs-*")
        try {
    }
        index("logs-000001", "_doc", "1", "@timestamp", "1970-01-01T00:00:03.500Z", "message", "old");
                }
            try {
                IndexMetadata updated = IndexFieldDomainMetadata.getInstance().putFieldDomain(current, domain);
import org.opensearch.index.IndexModule;
import org.opensearch.search.internal.SearchContext;
    private SearchResponse searchWithIndexFieldDomainMetadata(int preFilterShardSize) throws Exception {
        enableIndexPruning();
        } finally {
                    .setPreFilterShardSize(1_000)
            NamedWriteableRegistry namedWriteableRegistry,
import org.opensearch.common.unit.TimeValue;
            assertThat(RecordOldIndexSearchPlugin.OLD_INDEX_QUERY_PHASES.get(), greaterThan(0));
    public void testSearchKeepsIndicesWithDomainsPartiallyOverlappingQueryRange() throws Exception {
                if (current == null) {
        assertAcked(prepareCreate("logs-000001").setSettings(indexSettings).setMapping("@timestamp", "type=date"));
                            recordCanMatchRequest(request);
            client().admin()
import org.opensearch.index.fielddomain.DateRangeFieldDomain;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        RecordOldIndexSearchPlugin.RECORD_SEARCH_EVENTS.set(true);
                    return new TransportRequestHandler<T>() {
import static org.hamcrest.Matchers.greaterThan;
        private static final AtomicInteger OVERLAPPING_INDEX_QUERY_PHASES = new AtomicInteger();
            RecordOldIndexSearchPlugin.RECORD_SEARCH_EVENTS.set(false);
        assertAcked(
            client().execute(DeletePitAction.INSTANCE, new DeletePitRequest(pitResponse.getId())).actionGet();
            @Override
        });
import org.opensearch.tasks.Task;
        RecordOldIndexSearchPlugin.OVERLAPPING_INDEX_QUERY_PHASES.set(0);
        } finally {
            @Override
    public void testPointInTimeSearchDoesNotUseIndexFieldDomainMetadata() throws Exception {
        }
    public void tearDown() throws Exception {
                .get();
    private void resetSearchEventCounters() {
import java.util.concurrent.CountDownLatch;
import org.opensearch.plugins.Plugin;
                if ("logs-000001".equals(shardSearchRequest.shardId().getIndexName())) {
                }
                    String indexName = searchContext.indexShard().shardId().getIndex().getName();
                ) {
        public void onIndexModule(IndexModule indexModule) {
                        .put(SearchIndexPruningSettings.MIN_SHARDS.getKey(), 1)
import java.util.Collection;
    @Override
                latch.countDown();
                        .put(SearchIndexPruningSettings.ENABLED.getKey(), true)
import org.opensearch.search.sort.SortOrder;
                    return currentState;
        }
            public void onFailure(String source, Exception e) {
        createLogsIndices();
            super.tearDown();
import org.opensearch.index.shard.SearchOperationListener;
                    if ("logs-000001".equals(indexName)) {
            }
        AtomicReference<Exception> failure = new AtomicReference<>();
                public void onPreQueryPhase(SearchContext searchContext) {
                    if (SearchTransportService.QUERY_CAN_MATCH_NAME.equals(action) == false) {
