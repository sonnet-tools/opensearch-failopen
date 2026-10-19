        publishFieldDomain("logs-000002", new DateRangeFieldDomain("@timestamp", 2_000L, 4_000L, true, "test"));
            publishFieldDomain("logs-000002", new DateRangeFieldDomain("@timestamp", 3_000L, 4_000L, true, "test"));  
    public void tearDown() throws Exception {
    }
        );
                    String indexName = searchContext.indexShard().shardId().getIndex().getName();
                    }
import java.util.concurrent.TimeUnit;
                latch.countDown();
    @Override
            }  
import org.opensearch.search.internal.SearchContext;
        index("logs-000001", "_doc", "1", "@timestamp", "1970-01-01T00:00:03.500Z", "message", "old");
        } finally {
                        OVERLAPPING_INDEX_QUERY_PHASES.incrementAndGet();  
                response = client().prepareSearch("logs-*")  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
                    }  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.shard.SearchOperationListener;  
        RecordOldIndexSearchPlugin.OVERLAPPING_INDEX_QUERY_PHASES.set(0);  
            super.tearDown();  
                        @Override
        return List.of(RecordOldIndexSearchPlugin.class);
import java.util.concurrent.atomic.AtomicInteger;  
                .get();
        private static final AtomicInteger OLD_INDEX_CAN_MATCH_REQUESTS = new AtomicInteger();
                )  
            @Override  
        assertAcked(prepareCreate("logs-000003").setSettings(indexSettings).setMapping("@timestamp", "type=date"));  
        enableIndexPruning();
        enableIndexPruning();  
            RecordOldIndexSearchPlugin.RECORD_SEARCH_EVENTS.set(false);  
            });  
                    .setPreFilterShardSize(1_000)
import org.opensearch.transport.TransportChannel;
        @Override  
                        }  
import org.opensearch.index.fielddomain.DateRangeFieldDomain;
import java.util.List;
                    return new TransportRequestHandler<T>() {
        RecordOldIndexSearchPlugin.RECORD_SEARCH_EVENTS.set(true);
        RecordOldIndexSearchPlugin.OLD_INDEX_QUERY_PHASES.set(0);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertThat(RecordOldIndexSearchPlugin.OLD_INDEX_QUERY_PHASES.get(), equalTo(0));
        assertThat(RecordOldIndexSearchPlugin.OVERLAPPING_INDEX_QUERY_PHASES.get(), greaterThan(0));
    }  
                        .put(SearchIndexPruningSettings.ENABLED.getKey(), true)  
                .prepareUpdateSettings()
        index("logs-000001", "_doc", "1", "@timestamp", "1970-01-01T00:00:01Z", "message", "old");
import static org.hamcrest.Matchers.equalTo;  
import org.opensearch.cluster.metadata.IndexMetadata;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        }
            RecordOldIndexSearchPlugin.OVERLAPPING_INDEX_QUERY_PHASES.set(0);  
                    boolean forceExecution,
                if ("logs-000001".equals(shardSearchRequest.shardId().getIndexName())) {
                    };
    }
import org.opensearch.common.util.concurrent.ThreadContext;
import org.opensearch.transport.TransportRequestHandler;
import org.opensearch.search.sort.SortOrder;  
        SearchResponse response = searchWithIndexFieldDomainMetadata(1_000);
                    if ("logs-000001".equals(indexName)) {  
                }
        assertAcked(  
        try {  
 */  
        index("logs-000002", "_doc", "1", "@timestamp", "1970-01-01T00:00:10Z", "message", "current");  
import org.opensearch.cluster.ClusterState;
        try {  
import org.opensearch.cluster.metadata.Metadata;
public class SearchIndexPruningIT extends OpenSearchIntegTestCase {
                }
        CreatePitRequest createPitRequest = new CreatePitRequest(TimeValue.timeValueDays(1), true);  
            RecordOldIndexSearchPlugin.OLD_INDEX_QUERY_PHASES.set(0);
                .setPersistentSettings(Settings.builder().putNull("search.index_pruning.*"))  
        }  
package org.opensearch.action.search;
        } finally {  
        } finally {
                        .put(SearchIndexPruningSettings.MIN_SHARDS.getKey(), 1)
import java.util.concurrent.atomic.AtomicReference;
    }
        assertHitCount(response, 1L);
        refresh("logs-000001", "logs-000002");
        AtomicReference<Exception> failure = new AtomicReference<>();
            public void onFailure(String source, Exception e) {  
            assertThat(RecordOldIndexSearchPlugin.OLD_INDEX_QUERY_PHASES.get(), greaterThan(0));
        private static final AtomicInteger OVERLAPPING_INDEX_QUERY_PHASES = new AtomicInteger();
import org.opensearch.common.Priority;
            assertHitCount(response, 1L);  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .setPersistentSettings(
    }
                @Override  
        }
                IndexMetadata updated = IndexFieldDomainMetadata.getInstance().putFieldDomain(current, domain);
                latch.countDown();
        SearchResponse response = searchWithIndexFieldDomainMetadata(1);  
import static org.opensearch.index.query.QueryBuilders.rangeQuery;  
/*  
    }  
        }
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        resetSearchEventCounters();
                return ClusterState.builder(currentState).metadata(metadata).build();  
        CountDownLatch latch = new CountDownLatch(1);
 * SPDX-License-Identifier: Apache-2.0
        }
import org.opensearch.index.fielddomain.IndexFieldDomainMetadata;
        }
        public List<TransportInterceptor> getTransportInterceptors(
    }  
        enableIndexPruning();
        publishFieldDomain("logs-000002", new DateRangeFieldDomain("@timestamp", 3_000L, 4_000L, true, "test"));
                        return;  
            response = client().prepareSearch("logs-*")  
    private void enableIndexPruning() {
 * The OpenSearch Contributors require contributions made to  
    }  
            return List.of(new TransportInterceptor() {
        public void onIndexModule(IndexModule indexModule) {
        assertAcked(prepareCreate("logs-000001").setSettings(indexSettings).setMapping("@timestamp", "type=date"));
 * compatible open source license.
 *
                        public void messageReceived(T request, TransportChannel channel, Task task) throws Exception {  
import org.opensearch.test.OpenSearchIntegTestCase;
        private static void recordCanMatchRequest(TransportRequest request) {  
                public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(
    private void resetSearchEventCounters() {
    public void testSearchKeepsIndicesWithDomainsPartiallyOverlappingQueryRange() throws Exception {
                    failure.set(new IllegalStateException("index [" + index + "] not found in cluster state"));  
            RecordOldIndexSearchPlugin.RECORD_SEARCH_EVENTS.set(true);  
        assertThat(RecordOldIndexSearchPlugin.OLD_INDEX_QUERY_PHASES.get(), equalTo(0));
            client().execute(DeletePitAction.INSTANCE, new DeletePitRequest(pitResponse.getId())).actionGet();  
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
                    }
            .build();  
            @Override
            }
    public void testSearchUsesIndexFieldDomainMetadataToSkipShardGroups() throws Exception {
            return client().prepareSearch("logs-*")
                RecordOldIndexSearchPlugin.RECORD_SEARCH_EVENTS.set(false);  
        }
import org.opensearch.common.settings.Settings;
import java.util.Collection;
        clusterService.submitStateUpdateTask("put-index-field-domain [" + index + "]", new ClusterStateUpdateTask(Priority.URGENT) {
        assertTrue(latch.await(30, TimeUnit.SECONDS));  
                @Override  
                    TransportRequestHandler<T> actualHandler
                    .setPointInTime(new PointInTimeBuilder(pitResponse.getId()).setKeepAlive(TimeValue.timeValueDays(1)))
                    if (RECORD_SEARCH_EVENTS.get() == false) {
            resetSearchEventCounters();
    private void createLogsIndices() {
import java.util.concurrent.atomic.AtomicBoolean;
import org.opensearch.search.internal.ShardSearchRequest;
import org.opensearch.common.unit.TimeValue;  
            RecordOldIndexSearchPlugin.OLD_INDEX_CAN_MATCH_REQUESTS.set(0);
        @Override  
                        OLD_INDEX_QUERY_PHASES.incrementAndGet();
                if (current == null) {
import org.opensearch.search.builder.PointInTimeBuilder;  
import org.opensearch.plugins.NetworkPlugin;
        assertAcked(prepareCreate("logs-000002").setSettings(indexSettings).setMapping("@timestamp", "type=date"));
    public void testSearchUsesIndexFieldDomainMetadataBeforeCanMatch() throws Exception {
                    String action,
            }
                ShardSearchRequest shardSearchRequest = (ShardSearchRequest) request;
import org.opensearch.plugins.Plugin;
import org.opensearch.transport.TransportInterceptor;  
                    .setQuery(rangeQuery("@timestamp").gte("1970-01-01T00:00:03Z").lte("1970-01-01T00:00:04Z"))  
        }
        RecordOldIndexSearchPlugin.OLD_INDEX_CAN_MATCH_REQUESTS.set(0);
                .addSort("@timestamp", SortOrder.ASC)  
            RecordOldIndexSearchPlugin.CAN_MATCH_REQUESTS.set(0);
    private SearchResponse searchWithIndexFieldDomainMetadata(int preFilterShardSize) throws Exception {
                IndexMetadata current = currentState.metadata().index(index);
        RecordOldIndexSearchPlugin.CAN_MATCH_REQUESTS.set(0);
                    if (SearchTransportService.QUERY_CAN_MATCH_NAME.equals(action) == false) {
        private static final AtomicInteger OLD_INDEX_QUERY_PHASES = new AtomicInteger();
        assertThat(RecordOldIndexSearchPlugin.OLD_INDEX_CAN_MATCH_REQUESTS.get(), equalTo(0));  
                .get();
    }
                .prepareUpdateSettings()  
            }  
    }
        });
        refresh("logs-000001", "logs-000002", "logs-000003");
                .setPreFilterShardSize(preFilterShardSize)
import org.opensearch.index.IndexModule;  
            RecordOldIndexSearchPlugin.RECORD_SEARCH_EVENTS.set(false);
        publishFieldDomain("logs-000003", new DateRangeFieldDomain("@timestamp", 4_000L, 6_000L, true, "test"));  
        ensureGreen("logs-000001", "logs-000002", "logs-000003");
        ClusterService clusterService = internalCluster().getClusterManagerNodeInstance(ClusterService.class);  
            if (RECORD_SEARCH_EVENTS.get() && request instanceof ShardSearchRequest) {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                            actualHandler.messageReceived(request, channel, task);
        index("logs-000002", "_doc", "1", "@timestamp", "1970-01-01T00:00:03.500Z", "message", "current");
                    Settings.builder()
    public static class RecordOldIndexSearchPlugin extends Plugin implements NetworkPlugin {
                .cluster()
        index("logs-000003", "_doc", "1", "@timestamp", "1970-01-01T00:00:05Z", "message", "partial-right");
        CreatePitResponse pitResponse = client().execute(CreatePitAction.INSTANCE, createPitRequest).actionGet();
        createLogsIndices();  
            try {
        ) {
            SearchResponse response;
            NamedWriteableRegistry namedWriteableRegistry,
import org.opensearch.cluster.ClusterStateUpdateTask;  
            }
        createLogsIndices();
}
    }  
                }
        private static final AtomicBoolean RECORD_SEARCH_EVENTS = new AtomicBoolean();  
    public void testPointInTimeSearchDoesNotUseIndexFieldDomainMetadata() throws Exception {
                    OLD_INDEX_CAN_MATCH_REQUESTS.incrementAndGet();
        } finally {
    }  
        publishFieldDomain("logs-000001", new DateRangeFieldDomain("@timestamp", 1_000L, 2_000L, true, "test"));
import org.opensearch.action.search.pruning.SearchIndexPruningSettings;
                .setQuery(rangeQuery("@timestamp").gte("1970-01-01T00:00:03Z").lte("1970-01-01T00:00:04Z"))  
                .get();
            throw failure.get();
        private static final AtomicInteger CAN_MATCH_REQUESTS = new AtomicInteger();  
        index("logs-000002", "_doc", "1", "@timestamp", "1970-01-01T00:00:03.500Z", "message", "partial-left");  
    private void publishFieldDomain(String index, DateRangeFieldDomain domain) throws Exception {
            });  
@ClusterScope(scope = Scope.TEST, numDataNodes = 1, numClientNodes = 0, supportsDedicatedMasters = false)  
                public void onPreQueryPhase(SearchContext searchContext) {
        try {
            ThreadContext threadContext  
            public ClusterState execute(ClusterState currentState) {  
                    .get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        createPitRequest.setIndices(new String[] { "logs-*" });
import org.opensearch.tasks.Task;
        try {
        Settings indexSettings = Settings.builder()  
                            recordCanMatchRequest(request);
                .get()
import java.util.concurrent.CountDownLatch;  
        resetSearchEventCounters();
        refresh("logs-000001", "logs-000002");
        assertHitCount(response, 2L);  
                        return actualHandler;
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        publishFieldDomain("logs-000001", new DateRangeFieldDomain("@timestamp", 1_000L, 2_000L, true, "test"));
                }  
                failure.set(e);
                    return currentState;
            indexModule.addSearchOperationListener(new SearchOperationListener() {
        index("logs-000001", "_doc", "1", "@timestamp", "1970-01-01T00:00:01Z", "message", "old");  
        if (failure.get() != null) {
            publishFieldDomain("logs-000001", new DateRangeFieldDomain("@timestamp", 1_000L, 2_000L, true, "test"));
                .setQuery(rangeQuery("@timestamp").gte("1970-01-01T00:00:03Z").lte("1970-01-01T00:00:06Z"))
                ) {  
                        .putList(SearchIndexPruningSettings.FIELDS.getKey(), "@timestamp")
import org.opensearch.cluster.service.ClusterService;  
                    } else if ("logs-000002".equals(indexName) || "logs-000003".equals(indexName)) {
        assertHitCount(response, 1L);
                CAN_MATCH_REQUESTS.incrementAndGet();  
                Metadata metadata = Metadata.builder(currentState.metadata()).put(updated, true).build();
            RecordOldIndexSearchPlugin.RECORD_SEARCH_EVENTS.set(false);
                .addSort("@timestamp", SortOrder.ASC)
import org.opensearch.transport.TransportRequest;
                .setPreFilterShardSize(1)
                .cluster()
            client().admin()  
            } finally {
        assertThat(RecordOldIndexSearchPlugin.OLD_INDEX_QUERY_PHASES.get(), equalTo(0));
            @Override
import static org.hamcrest.Matchers.greaterThan;
        RecordOldIndexSearchPlugin.RECORD_SEARCH_EVENTS.set(true);  
                    String executor,  
            client().admin()
    @Override
        SearchResponse response;
        createLogsIndices();  
