import org.opensearch.indices.IndicesService;
        try {
        @Override
                    @Override
import java.util.List;
        final AtomicArray<Exception> exceptions = new AtomicArray<>(10);
            });
        private final SearchContext context;
        }
                .setSettings(
            SearchHit[] hits = searchResponse.getHits().getHits();
                false
        {
                    assertTrue(indexShard.isSearchIdle());
            Settings settings = Settings.builder().putNull("indices.breaker.request.limit").build();
                }
            RangeQueryBuilder rangeQuery = new RangeQueryBuilder("date");
        }
        }
        int numShards = randomIntBetween(1, 10);
            assertThat(
            SearchResponse searchResponse = client().search(searchRequest).actionGet();
                    "Trying to query " + (numPrimaries1 + numPrimaries2) + " shards, which is over the limit of " + numPrimaries1
    @Override
            assertEquals(0, searchResponse.getTotalShards());
            this.context = context;
        client().admin().indices().prepareRefresh("test").get();
        public InternalAggregation buildEmptyAggregation() {
     * A test aggregator that extends {@link Aggregator} instead of {@link AggregatorBase}
            assertEquals(2, searchResponse.getHits().getTotalHits().value());
import org.opensearch.indices.replication.common.ReplicationType;
                .request();
        }
        {
        }
 * license agreements. See the NOTICE file distributed with
            .prepareNodesStats()
        });
        assertBusy(() -> assertThat(requestBreakerUsed(), equalTo(0L)));
            IndexResponse indexResponse = client().prepareIndex(indexName).setSource("number", randomInt()).get();
import org.opensearch.core.common.io.stream.StreamInput;
        }
        for (int i = 0; i < 10; i++) {
            assertEquals(2, searchResponse.getHits().getTotalHits().value());
        client().prepareIndex("test").setId("1").setSource("created_date", "2020-01-01").get();
            latch.await();
                    .cluster()
        int numOfReplicas = randomIntBetween(0, 1);
 * specific language governing permissions and limitations
     * to avoid tripping the circuit breaker when executing on a shard.
            SearchHit[] hits = searchResponse.getHits().getHits();
                });
import org.opensearch.search.fetch.FetchSubPhase;
                    }
        internalCluster().ensureAtLeastNumDataNodes(numOfReplicas + 1);
        TestAggregationBuilder(String name) {
            indexRequest.source("price", 10);
    }
            indexRequest.id("1");
    public void testShardCountLimit() throws Exception {
        terms.field("price");
            client().search(request, new ActionListener<SearchResponse>() {
import org.opensearch.search.aggregations.support.ValueType;
                    latch.countDown();
                        exceptions.set(index, exc);
import org.opensearch.search.aggregations.bucket.terms.LongTerms;
        public SearchContext context() {
                        Collections.singletonMap(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING.getKey(), numPrimaries1 - 1)
        {
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT);
            SearchRequest searchRequest = new SearchRequest();
        ;
        @Override
                new SearchRequest(),
    }
        public Aggregator subAggregator(String name) {
        @Override
 * not use this file except in compliance with the License.
            return builder;
 * Modifications Copyright OpenSearch Contributors. See
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> client().prepareSearch("test1").get());
 * KIND, either express or implied.  See the License for the
            assertThat(resp.getHits().getTotalHits().value(), equalTo(2L));
                .setAllowPartialSearchResults(false)
                Strings.EMPTY_ARRAY,
                    public void onResponse(SearchResponse response) {
            AggregatorFactories.Builder subFactoriesBuilder
        @Override
                @Override
        @Override
        }
import static org.hamcrest.Matchers.equalTo;
            this.parent = parent;
                    latch.countDown();
    }
import java.util.concurrent.CountDownLatch;
        assertBusy(() -> {
            assertEquals("1", hit.getId());
import org.opensearch.index.IndexSettings;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.core.common.io.stream.StreamOutput;
                @Override
import org.opensearch.transport.client.Client;
        }
                SearchRequest request = client().prepareSearch("test")
    /**
        }
        TestAggregationBuilder(StreamInput input) throws IOException {
 * this work for additional information regarding copyright
                }
        }
            TestAggregationBuilder::new
        assertAcked(
        IndexResponse indexResponse = client().index(indexRequest).actionGet();
            final CountDownLatch latch = new CountDownLatch(10);
            assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings));
        public void postCollection() throws IOException {}
    private long requestBreakerUsed() {
import org.opensearch.search.aggregations.CardinalityUpperBound;
    }
            AggregatorFactory parent,
        assertEquals(RestStatus.CREATED, indexResponse.status());
                    .request();
                client().search(request, new ActionListener<SearchResponse>() {
            IndexResponse indexResponse = client().index(indexRequest).actionGet();
/*
                new AggregationSpec(TestAggregationBuilder.NAME, TestAggregationBuilder::new, TestAggregationBuilder.PARSER)
    }
            rangeQuery.gte("1970-01-01");
    public void testFinalReduce() {
                int batchReduceSize = randomIntBetween(2, Math.max(numShards + 1, 3));
            SearchRequest searchRequest = randomBoolean()
                .setPreFilterShardSize(randomIntBetween(1, 3))
                randomBoolean()
import org.opensearch.action.index.IndexRequest;
        ensureGreen("test");
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 5))
            IndexResponse indexResponse = client().index(indexRequest).actionGet();
            estimated += nodeStats.getBreaker().getStats(CircuitBreaker.REQUEST).getEstimated();
                protected Aggregator createInternal(
            indexRequest.id("1");
            indexRequest.source("price", 100);
import java.util.Collection;
                        responses.set(index, true);
             */
            return context;
            for (Exception exc : exceptions.asList()) {
                @Override
        private static final ObjectParser<TestAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
            }
            sourceBuilder.query(rangeQuery);
            final int numPrimaries2 = randomIntBetween(1, 10);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numOfReplicas)
        client().prepareIndex("test").setId("2").setSource("created_date", "2020-01-02").get();
            assertEquals(1, searchResponse.getHits().getTotalHits().value());
            final IndicesService indicesService = internalCluster().getInstance(IndicesService.class, node);
        long estimated = 0;
    }
        }
 * compatible open source license.
import org.opensearch.search.aggregations.Aggregations;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.opensearch.core.xcontent.ObjectParser;
                    .request();
            SearchRequest request = client().prepareSearch("boom")
            }
    private void indexSomeDocs(String indexName, int numberOfShards, int numberOfDocs) {
import org.opensearch.search.aggregations.AggregatorFactories;
            int batchReduceSize = randomIntBetween(2, Math.max(numShards + 1, 3));
            indexRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);
            return null;
        for (int i = 0; i < numberOfDocs; i++) {
                }
                )
                .setBatchedReduceSize(batchReduceSize)
                        latch.countDown();
            for (String node : internalCluster().nodesInclude("test")) {
            final CountDownLatch latch = new CountDownLatch(10);
        }
            assertEquals("test", hit.getIndex());
                new SearchRequest(),
            searchRequest.indicesOptions(IndicesOptions.fromOptions(true, true, true, true));
import org.opensearch.search.builder.SearchSourceBuilder;
        {
    }
import org.opensearch.core.common.Strings;
            return new InternalMax(name(), Double.NaN, DocValueFormat.RAW, Collections.emptyMap());
            // no exception
    @Override
                    .prepareUpdateSettings()
            for (int i = 0; i < 10; i++) {
            client().prepareSearch("test1").get();
                    SearchPhaseExecutionException.class,
            SearchRequest searchRequest = SearchRequest.subSearchRequest(
        }
public class TransportSearchIT extends OpenSearchIntegTestCase {
                    Settings.builder()
            );
                protected boolean supportsConcurrentSegmentSearch() {
                    }
import org.opensearch.test.OpenSearchIntegTestCase;
                SearchPhaseExecutionException exc = expectThrows(
                e.getMessage(),
        protected AggregatorFactory doBuild(
        }
        });
            SearchResponse resp = client().prepareSearch("test")
 * software distributed under the License is distributed on an
            }
            );
                public void process(FetchSubPhase.HitContext hitContext) {
                containsString(
                    if (fetchContext.getIndexName().startsWith("boom")) {
        }
            SearchResponse searchResponse = client().search(searchRequest).actionGet();
                @Override
            IndexResponse indexResponse = client().index(indexRequest).actionGet();
                    public void onResponse(SearchResponse response) {
            return Collections.singletonList(fetchContext -> new FetchSubPhaseProcessor() {
            for (int i = 0; i < 10; i++) {
            SearchResponse searchResponse = client().search(searchRequest).actionGet();
            assertEquals(1, hits.length);
                    .cluster()
        long nowInMillis = randomLongBetween(0, Long.MAX_VALUE);
                    @Override
        @Override
        public Aggregator parent() {
        }
        }
        client().prepareIndex("test").setId("3").setSource("created_date", "2020-01-03").get();
        public LeafBucketCollector getLeafCollector(LeafReaderContext ctx) throws IOException {
            );
            QueryShardContext queryShardContext,
 * Unless required by applicable law or agreed to in writing,
        }
            assertEquals(RestStatus.CREATED, indexResponse.status());
                        latch.countDown();
        }
            assertEquals("test-1970.01.01", searchResponse.getHits().getHits()[0].getIndex());
            for (IndexShard indexShard : indicesService.indexServiceSafe(resolveIndex("test"))) {
            SearchResponse searchResponse = client().search(searchRequest).actionGet();
        }
            assertAcked(prepareCreate("test2").setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numPrimaries2)));
     * together (coordinator node).
            SearchResponse searchResponse = client().search(searchRequest).actionGet();
        );
                    return true;
            return BucketCardinality.NONE;
                Strings.EMPTY_ARRAY,
import org.opensearch.search.aggregations.AbstractAggregationBuilder;
        NodesStatsResponse stats = client().admin()
        int numShards = randomIntBetween(1, 10);
            }
     */
                originalRequest,
        source.size(0);
                });
                )
            SearchRequest searchRequest = SearchRequest.subSearchRequest(
        @Override
            assertEquals("", hit.getClusterAlias());
                : SearchRequest.subSearchRequest(originalRequest, Strings.EMPTY_ARRAY, "remote", nowInMillis, true);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        {
                assertTrue(indexShard.isSearchIdleSupported());
package org.opensearch.action.search;
        } finally {
        }
                    .setTransientSettings(
    private static class TestAggregationBuilder extends AbstractAggregationBuilder<TestAggregationBuilder> {
            assertEquals(2, searchResponse.getHits().getTotalHits().value());
                assertThat(ExceptionsHelper.unwrapCause(exc).getCause().getMessage(), containsString("<reduce_aggs>"));
            client().prepareSearch("test1").get();
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            assertThat(responses.asList().size(), equalTo(10));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 5))
        );
        @Override
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put("indices.breaker.request.type", "memory").build();
            assertBusy(() -> {
        assertAcked(prepareCreate("test").setSettings(settings).setMapping("created_date", "type=date,format=yyyy-MM-dd"));
                        throw new RuntimeException("boom");
import org.opensearch.search.aggregations.AggregatorFactory;
 * under the License.
import org.opensearch.action.support.IndicesOptions;
            this.name = name;
 *
import org.opensearch.core.common.breaker.CircuitBreaker;
            IndexResponse indexResponse = client().index(indexRequest).actionGet();
                assertThat(ExceptionsHelper.unwrapCause(exc).getCause().getMessage(), containsString("<reduce_aggs>"));
            client().admin()
        }
            SearchResponse searchResponse = client().search(searchRequest).actionGet();
 */
        final CountDownLatch latch = new CountDownLatch(10);
            IndexRequest indexRequest = new IndexRequest("test");
            assertEquals("test-1970.01.01", searchResponse.getHits().getHits()[0].getIndex());
        final Settings.Builder settings = Settings.builder()
            assertEquals(1, longTerms.getBuckets().size());
import org.opensearch.plugins.Plugin;
            assertEquals(RestStatus.CREATED, indexResponse.status());
                        responses.set(index, false);
        createIndex(indexName, Settings.builder().put("index.number_of_shards", numberOfShards).build());
            assertEquals(RestStatus.CREATED, indexResponse.status());
        final Settings.Builder settings = Settings.builder()
                public void onResponse(SearchResponse response) {
import org.opensearch.action.index.IndexResponse;
        assertAcked(prepareCreate("test").setSettings(settings).setMapping("created_date", "type=date,format=yyyy-MM-dd"));
     * A test aggregation that doesn't consume circuit breaker memory when running on shards.
        public ScoreMode scoreMode() {
     */
                    .prepareUpdateSettings()
 * ownership. Elasticsearch licenses this file to you under
        for (Exception exc : exceptions.asList()) {
                ) throws IOException {
            }
 *
                    public void onFailure(Exception exc) {
        int numOfReplicas = 1;
            final int index = i;
            assertEquals(1, searchResponse.getHits().getTotalHits().value());
            indexRequest.source("date", "1970-01-01");
            // noop
        }
                    .setBatchedReduceSize(batchReduceSize)
            assertThat(exceptions.asList().size(), equalTo(10));
                        .put(IndexSettings.INDEX_SEARCH_IDLE_AFTER.getKey(), TimeValue.timeValueMillis(randomIntBetween(50, 500)))
        @Override
        public List<FetchSubPhase> getFetchSubPhases(FetchPhaseConstructionContext context) {
            return name;
            .put(IndexSettings.INDEX_SEARCH_IDLE_AFTER.getKey(), TimeValue.timeValueMillis(randomIntBetween(50, 500)));
            assertEquals("1", hit.getId());
            IndexRequest indexRequest = new IndexRequest("test");
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
/*
    }
    public void testSearchIdleWithSegmentReplication() {
            assertEquals(1, searchResponse.getHits().getTotalHits().value());
    private static class TestAggregator extends Aggregator {
        terms.size(1);
                .indices()
 * SPDX-License-Identifier: Apache-2.0
                @Override
        private TestAggregator(String name, Aggregator parent, SearchContext context) {
        indexSomeDocs("boom", numShards, numDocs);
                nowInMillis,
            SearchResponse searchResponse = client().search(searchRequest).actionGet();
            assertEquals("local", hit.getClusterAlias());
                final int index = i;
            SearchRequest searchRequest = SearchRequest.subSearchRequest(new SearchRequest(), Strings.EMPTY_ARRAY, "", 0, randomBoolean());
 * the Apache License, Version 2.0 (the "License"); you may
                assertFalse(indexShard.isSearchIdleSupported());
import org.opensearch.search.internal.SearchContext;
    public static class TestPlugin extends Plugin implements SearchPlugin {
                    }
 */
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
    }
        public List<AggregationSpec> getAggregations() {
            return new AggregatorFactory(name, queryShardContext, parent, subFactoriesBuilder, metadata) {
        SearchRequest originalRequest = new SearchRequest();
        try {
        {
        @Override
    public void testSearchIdle() throws Exception {
        }
import org.opensearch.common.util.concurrent.AtomicArray;
                "local",
        for (String node : internalCluster().nodesInclude("test")) {
            IndexRequest indexRequest = new IndexRequest("test-1970.01.01");
            assertBusy(() -> assertThat(requestBreakerUsed(), equalTo(0L)));
                    }
        internalCluster().ensureAtLeastNumDataNodes(numOfReplicas + 1);
import org.apache.lucene.index.LeafReaderContext;
                    .setTransientSettings(Collections.singletonMap(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING.getKey(), numPrimaries1))
import org.opensearch.search.fetch.FetchSubPhaseProcessor;
            );
            .addMetric(NodesStatsRequest.Metric.BREAKER.metricName())
                }
            SearchResponse searchResponse = client().search(searchRequest).actionGet();
            // no exception
    /**
/*
import org.opensearch.search.aggregations.metrics.InternalMax;
 * GitHub history for details.
        static final String NAME = "test";
            assertAcked(
            assertThat(ExceptionsHelper.unwrapCause(exc).getCause().getMessage(), containsString("boom"));
        {
                    Aggregator parent,
        public String name() {
            SearchHit hit = hits[0];
                    exceptions.set(index, exc);
        {
        );
                .prepareUpdateSettings("test")
        TermsAggregationBuilder terms = new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.NUMERIC);
            indexRequest.id("1");
        }
            }
                    .addAggregation(new TestAggregationBuilder("test"))
            client().admin()
    protected Settings nodeSettings(int nodeOrdinal) {
        {
            assertEquals(2, searchResponse.getHits().getTotalHits().value());
            return new TestAggregationBuilder(name);
    public void testCircuitBreakerFetchFail() throws Exception {
                Strings.EMPTY_ARRAY,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numOfReplicas)
                    .addAggregation(new TestAggregationBuilder("test"))
                public void onFailure(Exception exc) {
            rangeQuery.lt("1982-01-01");
            assertAcked(
        originalRequest.source(source);
                @Override
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
                    @Override
import org.opensearch.common.settings.Settings;
        @Override
        }
        }
            return "test";
            SearchRequest searchRequest = SearchRequest.subSearchRequest(new SearchRequest(), Strings.EMPTY_ARRAY, "", 0, randomBoolean());
import org.opensearch.search.aggregations.InternalAggregation;
        source.aggregation(terms);
        }
    }
            indexRequest.id("2");
                for (IndexShard indexShard : indicesService.indexServiceSafe(resolveIndex("test"))) {
        public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
            indexRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);
            );
            indexRequest.source("date", "1982-01-01");
                final IndicesService indicesService = internalCluster().getInstance(IndicesService.class, node);
    }
                containsString("Trying to query " + numPrimaries1 + " shards, which is over the limit of " + (numPrimaries1 - 1))
            return parent;
            SearchRequest searchRequest = SearchRequest.subSearchRequest(new SearchRequest(), Strings.EMPTY_ARRAY, "", 0, randomBoolean());
 * Licensed to Elasticsearch under one or more contributor
        long nowInMillis = randomLongBetween(0, Long.MAX_VALUE);
            SearchHit hit = hits[0];
    }
                randomBoolean()
            SearchResponse searchResponse = client().search(searchRequest).actionGet();
        {
                    .prepareUpdateSettings()
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
                    () -> client.prepareSearch("test").addAggregation(new TestAggregationBuilder("test")).get()
            Aggregations aggregations = searchResponse.getAggregations();
import org.opensearch.search.aggregations.AggregatorBase;
        latch.await();
                    CardinalityUpperBound cardinality,
            return new InternalAggregation[] { new InternalMax(name(), Double.NaN, DocValueFormat.RAW, Collections.emptyMap()) };
import org.opensearch.index.query.QueryShardContext;
            LongTerms longTerms = aggregations.get("terms");
        assertAcked(
                nowInMillis,
                "",
            assertEquals(RestStatus.CREATED, indexResponse.status());
        {
        indexRequest.id("1");
        protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
                public void setNextReader(LeafReaderContext readerContext) {}
            SearchRequest searchRequest = SearchRequest.subSearchRequest(
        @Override
        @Override
            return ScoreMode.COMPLETE_NO_SCORES;
        protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
import org.apache.lucene.search.ScoreMode;
        @Override
        assertBusy(() -> {
            IndexRequest indexRequest = new IndexRequest("test-1982.01.01");
                nowInMillis,
                }
            final int numPrimaries1 = randomIntBetween(2, 10);
            return Collections.singletonList(
        indexSomeDocs("test", numShards, numShards * 3);
            NAME,
        IndexRequest indexRequest = new IndexRequest("test");
                    .setBatchedReduceSize(batchReduceSize)
                assertTrue(resp);
        {
        indexRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);
}
            assertEquals(RestStatus.CREATED, indexResponse.status());
                        latch.countDown();
        for (NodeStats nodeStats : stats.getNodes()) {
    public void testAbsoluteStartMillis() {
            searchRequest.source(sourceBuilder);
                    }
        client().admin().indices().prepareRefresh(indexName).get();
            e = expectThrows(IllegalArgumentException.class, () -> client().prepareSearch("test1", "test2").get());
            );
                client().admin()
        public BucketCardinality bucketCardinality() {
            .cluster()
        @Override
            assertAcked(prepareCreate("test1").setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numPrimaries1)));
        }
            assertEquals("test", hit.getIndex());
import org.opensearch.cluster.metadata.IndexMetadata;
import static org.hamcrest.Matchers.containsString;
        @Override
                .indices()
        }
import org.opensearch.search.aggregations.Aggregator;
        }
        protected void doWriteTo(StreamOutput out) throws IOException {
              Set up a fetch sub phase that throws an exception on indices whose name that start with "boom".
                    Map<String, Object> metadata
            }
            LongTerms longTerms = aggregations.get("terms");
        for (String node : internalCluster().nodesInclude("test")) {
import org.opensearch.common.unit.TimeValue;
            final IndicesService indicesService = internalCluster().getInstance(IndicesService.class, node);
import java.util.Map;
            throw new CollectionTerminatedException();
            });
        }
                    .addResultReader(InternalMax::new)
                }
            Aggregations aggregations = searchResponse.getAggregations();
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
            for (IndexShard indexShard : indicesService.indexServiceSafe(resolveIndex("test"))) {
                    )
    }
                int batchReduceSize = randomIntBetween(2, Math.max(numShards + 1, 3));
        public void close() {}
            /*
                .get();
        @Override
            super(name);
            assertBusy(() -> assertThat(requestBreakerUsed(), equalTo(0L)));
        ) throws IOException {
        }
            assertAcked(
        @Override
import org.opensearch.search.aggregations.LeafBucketCollector;
        } finally {
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0))
import java.util.Collections;
        }
import org.opensearch.ExceptionsHelper;
            final AtomicArray<Boolean> responses = new AtomicArray<>(10);
            assertThat(
import org.opensearch.core.rest.RestStatus;
            super(input);
import org.opensearch.core.action.ActionListener;
        return estimated;
import org.opensearch.index.query.RangeQueryBuilder;
                    SearchContext searchContext,
                        latch.countDown();
        }
            final AtomicArray<Exception> exceptions = new AtomicArray<>(10);
        assertThat(exceptions.asList().size(), equalTo(10));
                    .setTransientSettings(Collections.singletonMap(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING.getKey(), null))
 * You may obtain a copy of the License at
            );
import org.opensearch.action.support.WriteRequest;
import org.opensearch.core.xcontent.XContentBuilder;
            SearchRequest searchRequest = new SearchRequest("<test-{now/d}>");
        }
    public void testCircuitBreakerReduceFail() throws Exception {
            assertEquals(1, hits.length);
        return Collections.singletonList(TestPlugin.class);
import org.apache.lucene.search.CollectionTerminatedException;
                    public void onFailure(Exception e) {
import org.opensearch.search.aggregations.AggregationBuilder;
    }
                final int index = i;
        private final Aggregator parent;
                client().admin()
            Settings settings = Settings.builder().put("indices.breaker.request.limit", "1b").build();
                SearchRequest request = client().prepareSearch("test")
        }
        ensureGreen("test");
     * It is used to test the behavior of the circuit breaker when reducing multiple aggregations
        public String getType() {
 * The OpenSearch Contributors require contributions made to
                );
import org.opensearch.search.DocValueFormat;
    public void testLocalClusterAlias() {
        {
import org.opensearch.plugins.SearchPlugin;
        private final String name;
                    return new TestAggregator(name, parent, searchContext);
            for (boolean resp : responses.asList()) {
                    .cluster()
        }
        SearchSourceBuilder source = new SearchSourceBuilder();
                client().admin()
                client().search(request, new ActionListener<SearchResponse>() {
import org.opensearch.index.shard.IndexShard;
            assertEquals(2, longTerms.getBuckets().size());
        }
 *
                    @Override
                "remote",
import org.opensearch.search.SearchHit;
            };
        public void preCollection() throws IOException {}
                .prepareUpdateSettings("test")
                .setQuery(new RangeQueryBuilder("created_date").gte("2020-01-02").lte("2020-01-03"))
            latch.await();
            });
            searchRequest.indices("<test-{now/d}>");
        {
        @Override
        int numDocs = numShards * 10;
        }
    }
                ? originalRequest
            assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings));
            );
            .get();
            final Client client = client();
        indexRequest.source("field", "value");
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertEquals(1, searchResponse.getHits().getTotalHits().value());
 */
        }
                e.getMessage(),
            );
