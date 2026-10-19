    }
            assertThat(
                    public void onFailure(Exception e) {
            final Client client = client();  
                final int index = i;
        @Override
                        latch.countDown();  
            SearchResponse searchResponse = client().search(searchRequest).actionGet();
        @Override  
import org.apache.lucene.search.CollectionTerminatedException;
                nowInMillis,
 *    http://www.apache.org/licenses/LICENSE-2.0
                @Override
        int numShards = randomIntBetween(1, 10);
        {
            indexRequest.id("1");  
            searchRequest.indices("<test-{now/d}>");
    }
        private TestAggregator(String name, Aggregator parent, SearchContext context) {
        }  
            IndexResponse indexResponse = client().index(indexRequest).actionGet();
            final AtomicArray<Boolean> responses = new AtomicArray<>(10);
            SearchRequest searchRequest = new SearchRequest("<test-{now/d}>");
            latch.await();
package org.opensearch.action.search;
        );
                    }
        {
                    @Override
            assertEquals("1", hit.getId());  
        indexSomeDocs("test", numShards, numShards * 3);
            indexRequest.id("2");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                assertTrue(resp);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 5))
            assertEquals("test", hit.getIndex());
            AggregatorFactory parent,
            assertEquals("1", hit.getId());
            return new InternalAggregation[] { new InternalMax(name(), Double.NaN, DocValueFormat.RAW, Collections.emptyMap()) };
import org.opensearch.plugins.SearchPlugin;
 * KIND, either express or implied.  See the License for the
        client().admin().indices().prepareRefresh("test").get();
        @Override  
                "",  
     * to avoid tripping the circuit breaker when executing on a shard.  
            assertThat(ExceptionsHelper.unwrapCause(exc).getCause().getMessage(), containsString("boom"));
            client().prepareSearch("test1").get();
                    if (fetchContext.getIndexName().startsWith("boom")) {  
        client().prepareIndex("test").setId("2").setSource("created_date", "2020-01-02").get();
            .addMetric(NodesStatsRequest.Metric.BREAKER.metricName())
            SearchResponse searchResponse = client().search(searchRequest).actionGet();
    }
import org.opensearch.common.util.concurrent.AtomicArray;  
            }
        }  
            assertEquals(1, searchResponse.getHits().getTotalHits().value());
import org.opensearch.core.rest.RestStatus;  
                client().search(request, new ActionListener<SearchResponse>() {
 *
        assertBusy(() -> assertThat(requestBreakerUsed(), equalTo(0L)));  
                .prepareUpdateSettings("test")  
import org.opensearch.core.xcontent.ObjectParser;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            assertEquals(0, searchResponse.getTotalShards());
            assertAcked(  
        @Override
        @Override
            SearchHit[] hits = searchResponse.getHits().getHits();  
     * A test aggregator that extends {@link Aggregator} instead of {@link AggregatorBase}
            latch.await();
        }
            final CountDownLatch latch = new CountDownLatch(10);  
            assertEquals("test", hit.getIndex());
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;  
            SearchResponse searchResponse = client().search(searchRequest).actionGet();  
        protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
                    }
import org.opensearch.plugins.Plugin;  
import org.opensearch.index.IndexSettings;  
    }
import org.opensearch.action.support.IndicesOptions;
        for (String node : internalCluster().nodesInclude("test")) {  
        private static final ObjectParser<TestAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
                public void onResponse(SearchResponse response) {
            return new AggregatorFactory(name, queryShardContext, parent, subFactoriesBuilder, metadata) {
                    .prepareUpdateSettings()  
            return ScoreMode.COMPLETE_NO_SCORES;
            this.parent = parent;  
                        responses.set(index, true);
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
                    latch.countDown();  
        assertBusy(() -> {
import java.util.Collections;  
import org.opensearch.indices.replication.common.ReplicationType;
            assertEquals(1, hits.length);
                    "Trying to query " + (numPrimaries1 + numPrimaries2) + " shards, which is over the limit of " + numPrimaries1
    public void testShardCountLimit() throws Exception {
        }
    @Override
        ) throws IOException {  
            client().admin()
        public List<AggregationSpec> getAggregations() {  
import org.opensearch.search.aggregations.bucket.terms.LongTerms;
    /**
        }
            assertAcked(prepareCreate("test2").setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numPrimaries2)));
        protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
            NAME,
        }
            return new TestAggregationBuilder(name);
        SearchRequest originalRequest = new SearchRequest();  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;  
                containsString("Trying to query " + numPrimaries1 + " shards, which is over the limit of " + (numPrimaries1 - 1))  
        internalCluster().ensureAtLeastNumDataNodes(numOfReplicas + 1);
            assertAcked(
        }  
    public void testFinalReduce() {  
import org.opensearch.common.settings.Settings;
                    .setTransientSettings(Collections.singletonMap(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING.getKey(), null))
        }
    private void indexSomeDocs(String indexName, int numberOfShards, int numberOfDocs) {  
        indexRequest.source("field", "value");
        }
        {
import org.opensearch.indices.IndicesService;
            SearchResponse searchResponse = client().search(searchRequest).actionGet();  
                assertThat(ExceptionsHelper.unwrapCause(exc).getCause().getMessage(), containsString("<reduce_aggs>"));
            for (String node : internalCluster().nodesInclude("test")) {
                    .prepareUpdateSettings()
                    public void onFailure(Exception exc) {
import java.io.IOException;
        {
     * It is used to test the behavior of the circuit breaker when reducing multiple aggregations
import org.opensearch.ExceptionsHelper;
            SearchRequest searchRequest = SearchRequest.subSearchRequest(
        @Override  
        for (Exception exc : exceptions.asList()) {  
                .request();
        );
            }
import java.util.Map;
            final IndicesService indicesService = internalCluster().getInstance(IndicesService.class, node);
            SearchResponse resp = client().prepareSearch("test")
import org.opensearch.core.common.io.stream.StreamOutput;
            for (int i = 0; i < 10; i++) {
        }
/*  
        }  
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put("indices.breaker.request.type", "memory").build();
            // noop
            IndexRequest indexRequest = new IndexRequest("test-1970.01.01");
                    .cluster()
        public SearchContext context() {
    public void testAbsoluteStartMillis() {  
    }
                @Override  
        }
import org.opensearch.search.aggregations.CardinalityUpperBound;
                .prepareUpdateSettings("test")
            SearchRequest searchRequest = SearchRequest.subSearchRequest(
                client().admin()
        assertAcked(
            searchRequest.indicesOptions(IndicesOptions.fromOptions(true, true, true, true));  
import org.apache.lucene.search.ScoreMode;  
            return BucketCardinality.NONE;
            Settings settings = Settings.builder().putNull("indices.breaker.request.limit").build();
 * You may obtain a copy of the License at  
                false
     * together (coordinator node).
                    )  
        assertThat(exceptions.asList().size(), equalTo(10));
                }
                }  
                    public void onResponse(SearchResponse response) {
        }
                    Map<String, Object> metadata
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> client().prepareSearch("test1").get());  
                Strings.EMPTY_ARRAY,  
public class TransportSearchIT extends OpenSearchIntegTestCase {  
            return null;  
        public String getType() {
 * Licensed to Elasticsearch under one or more contributor  
            super(name);
import org.opensearch.search.fetch.FetchSubPhaseProcessor;
                "remote",
                    SearchPhaseExecutionException.class,  
 *  
        }
            }
                }  
            // no exception
            int batchReduceSize = randomIntBetween(2, Math.max(numShards + 1, 3));  
import org.opensearch.action.index.IndexResponse;  
                randomBoolean()  
            assertBusy(() -> assertThat(requestBreakerUsed(), equalTo(0L)));  
                    Aggregator parent,
            assertEquals("test-1970.01.01", searchResponse.getHits().getHits()[0].getIndex());
    }  
import org.opensearch.search.DocValueFormat;
        } finally {  
            for (Exception exc : exceptions.asList()) {  
        }  
                public void onFailure(Exception exc) {
            assertEquals(2, longTerms.getBuckets().size());
            assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings));  
            assertEquals(1, searchResponse.getHits().getTotalHits().value());
                client().admin()
        public ScoreMode scoreMode() {
            e = expectThrows(IllegalArgumentException.class, () -> client().prepareSearch("test1", "test2").get());
import org.opensearch.action.support.WriteRequest;
        for (int i = 0; i < numberOfDocs; i++) {  
            final int numPrimaries2 = randomIntBetween(1, 10);
        createIndex(indexName, Settings.builder().put("index.number_of_shards", numberOfShards).build());
                    }
            assertEquals(RestStatus.CREATED, indexResponse.status());  
        @Override
        }
        }
            );
        NodesStatsResponse stats = client().admin()
                    return new TestAggregator(name, parent, searchContext);  
            });
            client().search(request, new ActionListener<SearchResponse>() {  
            );
            return Collections.singletonList(
        @Override
 */  
import static org.hamcrest.Matchers.equalTo;
            assertEquals(1, longTerms.getBuckets().size());
             */
        }
        }  
            sourceBuilder.query(rangeQuery);
            IndexResponse indexResponse = client().index(indexRequest).actionGet();
    }  
        @Override
 *
        long nowInMillis = randomLongBetween(0, Long.MAX_VALUE);
import org.opensearch.search.aggregations.AbstractAggregationBuilder;
            LongTerms longTerms = aggregations.get("terms");  
        }
        public List<FetchSubPhase> getFetchSubPhases(FetchPhaseConstructionContext context) {
 * this work for additional information regarding copyright
            SearchHit hit = hits[0];  
            assertEquals(RestStatus.CREATED, indexResponse.status());
            indexRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);
                new AggregationSpec(TestAggregationBuilder.NAME, TestAggregationBuilder::new, TestAggregationBuilder.PARSER)
            assertBusy(() -> {
        {
        }  
                    .addAggregation(new TestAggregationBuilder("test"))
                e.getMessage(),
        try {  
            IndexResponse indexResponse = client().index(indexRequest).actionGet();  
 * Unless required by applicable law or agreed to in writing,
                e.getMessage(),  
            IndexRequest indexRequest = new IndexRequest("test");  
                );
import org.opensearch.search.aggregations.metrics.InternalMax;
                    @Override  
            this.context = context;
        private final String name;  
            );
 * ownership. Elasticsearch licenses this file to you under  
            );  
        }  
            assertEquals(RestStatus.CREATED, indexResponse.status());
        }
            this.name = name;
        public void preCollection() throws IOException {}  
                    @Override  
        } finally {
                    return true;
        }  
 * this file be licensed under the Apache-2.0 license or a
    }
        final Settings.Builder settings = Settings.builder()
            SearchResponse searchResponse = client().search(searchRequest).actionGet();  
    public void testCircuitBreakerReduceFail() throws Exception {  
import org.opensearch.search.aggregations.LeafBucketCollector;
        assertBusy(() -> {  
                .setSettings(
                .setPreFilterShardSize(randomIntBetween(1, 3))  
        terms.size(1);  
    }
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();  
                assertThat(ExceptionsHelper.unwrapCause(exc).getCause().getMessage(), containsString("<reduce_aggs>"));  
            assertEquals(2, searchResponse.getHits().getTotalHits().value());
            for (IndexShard indexShard : indicesService.indexServiceSafe(resolveIndex("test"))) {
        }
                .indices()
    }  
                assertTrue(indexShard.isSearchIdleSupported());  
 * compatible open source license.
                originalRequest,  
                SearchPhaseExecutionException exc = expectThrows(
                    .cluster()
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT);  
            rangeQuery.lt("1982-01-01");  
        int numOfReplicas = randomIntBetween(0, 1);
        @Override
        assertEquals(RestStatus.CREATED, indexResponse.status());
        }  
        {
                SearchRequest request = client().prepareSearch("test")
                    @Override  
 * software distributed under the License is distributed on an
            assertEquals(1, searchResponse.getHits().getTotalHits().value());
     * A test aggregation that doesn't consume circuit breaker memory when running on shards.  
        public Aggregator parent() {  
        for (NodeStats nodeStats : stats.getNodes()) {
        for (int i = 0; i < 10; i++) {
            });
            );
                @Override
        assertAcked(prepareCreate("test").setSettings(settings).setMapping("created_date", "type=date,format=yyyy-MM-dd"));
                    .cluster()  
            rangeQuery.gte("1970-01-01");
                    assertTrue(indexShard.isSearchIdle());
                final int index = i;
            .prepareNodesStats()
                        latch.countDown();  
                        latch.countDown();  
        @Override
        terms.field("price");
                Strings.EMPTY_ARRAY,
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        originalRequest.source(source);  
                    latch.countDown();  
                .setAllowPartialSearchResults(false)  
                int batchReduceSize = randomIntBetween(2, Math.max(numShards + 1, 3));
            for (boolean resp : responses.asList()) {  
        }
                    .addResultReader(InternalMax::new)  
        {  
        private final Aggregator parent;
                public void setNextReader(LeafReaderContext readerContext) {}
                : SearchRequest.subSearchRequest(originalRequest, Strings.EMPTY_ARRAY, "remote", nowInMillis, true);  
                    .prepareUpdateSettings()  
            indexRequest.source("price", 10);
            /*  
            final AtomicArray<Exception> exceptions = new AtomicArray<>(10);  
            assertAcked(  
                        .put(IndexSettings.INDEX_SEARCH_IDLE_AFTER.getKey(), TimeValue.timeValueMillis(randomIntBetween(50, 500)))  
        }
                @Override
            SearchRequest searchRequest = SearchRequest.subSearchRequest(new SearchRequest(), Strings.EMPTY_ARRAY, "", 0, randomBoolean());
                    public void onResponse(SearchResponse response) {
    protected Settings nodeSettings(int nodeOrdinal) {  
            indexRequest.source("price", 100);  
     */
                for (IndexShard indexShard : indicesService.indexServiceSafe(resolveIndex("test"))) {
import org.opensearch.search.builder.SearchSourceBuilder;  
import org.opensearch.search.aggregations.Aggregations;  
        ensureGreen("test");
            assertThat(resp.getHits().getTotalHits().value(), equalTo(2L));
/*
            client().prepareSearch("test1").get();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numOfReplicas)  
                .get();
            for (int i = 0; i < 10; i++) {
        public InternalAggregation buildEmptyAggregation() {  
import org.opensearch.transport.client.Client;
            assertThat(responses.asList().size(), equalTo(10));
        long estimated = 0;
        );
            QueryShardContext queryShardContext,  
        }  
                nowInMillis,
                @Override  
            final IndicesService indicesService = internalCluster().getInstance(IndicesService.class, node);
            return name;  
        @Override
            );  
import org.opensearch.search.aggregations.AggregatorFactory;
 * the Apache License, Version 2.0 (the "License"); you may
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 5))
                }
                        latch.countDown();  
                containsString(
        ;  
        int numDocs = numShards * 10;  
    private long requestBreakerUsed() {
                    .request();  
        {
            TestAggregationBuilder::new  
        ensureGreen("test");  
        client().prepareIndex("test").setId("3").setSource("created_date", "2020-01-03").get();
import org.opensearch.core.action.ActionListener;
import org.opensearch.test.OpenSearchIntegTestCase;
                public void process(FetchSubPhase.HitContext hitContext) {
            SearchResponse searchResponse = client().search(searchRequest).actionGet();
                randomBoolean()
                client().admin()
 * GitHub history for details.
        final AtomicArray<Exception> exceptions = new AtomicArray<>(10);  
    private static class TestAggregator extends Aggregator {
            assertEquals(RestStatus.CREATED, indexResponse.status());
                protected boolean supportsConcurrentSegmentSearch() {
        TestAggregationBuilder(String name) {  
 * license agreements. See the NOTICE file distributed with
        public Aggregator subAggregator(String name) {
                .setBatchedReduceSize(batchReduceSize)
        @Override
            indexRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);
        }  
            IndexRequest indexRequest = new IndexRequest("test-1982.01.01");
        latch.await();
            Aggregations aggregations = searchResponse.getAggregations();  
        int numShards = randomIntBetween(1, 10);
        }
            assertEquals("local", hit.getClusterAlias());
        protected void doWriteTo(StreamOutput out) throws IOException {  
            Aggregations aggregations = searchResponse.getAggregations();
import org.opensearch.core.common.breaker.CircuitBreaker;  
            LongTerms longTerms = aggregations.get("terms");
        SearchSourceBuilder source = new SearchSourceBuilder();
                        Collections.singletonMap(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING.getKey(), numPrimaries1 - 1)
            RangeQueryBuilder rangeQuery = new RangeQueryBuilder("date");
        }  
        indexRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);
                });
                    }
    @Override
            assertEquals(2, searchResponse.getHits().getTotalHits().value());
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0))  
                    exceptions.set(index, exc);
                    .setBatchedReduceSize(batchReduceSize)
                client().search(request, new ActionListener<SearchResponse>() {  
                    }
            assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings));
                }
            super(input);
import org.opensearch.search.SearchHit;  
            .get();  
                protected Aggregator createInternal(  
        {  
            assertAcked(prepareCreate("test1").setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numPrimaries1)));  
                    .setTransientSettings(
        TermsAggregationBuilder terms = new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.NUMERIC);
                .setQuery(new RangeQueryBuilder("created_date").gte("2020-01-02").lte("2020-01-03"))
        }
            assertEquals(2, searchResponse.getHits().getTotalHits().value());
        }
            SearchRequest searchRequest = SearchRequest.subSearchRequest(new SearchRequest(), Strings.EMPTY_ARRAY, "", 0, randomBoolean());
            .cluster()  
        public LeafBucketCollector getLeafCollector(LeafReaderContext ctx) throws IOException {
                new SearchRequest(),
        int numOfReplicas = 1;
        public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
            SearchResponse searchResponse = client().search(searchRequest).actionGet();
        @Override
            );
            SearchResponse searchResponse = client().search(searchRequest).actionGet();  
        }  
                        throw new RuntimeException("boom");
            return context;
        {  
 * SPDX-License-Identifier: Apache-2.0
     */  
import org.opensearch.cluster.metadata.IndexMetadata;  
            IndexResponse indexResponse = client().prepareIndex(indexName).setSource("number", randomInt()).get();
                )  
import org.opensearch.search.internal.SearchContext;  
import org.opensearch.search.aggregations.Aggregator;
        {  
            SearchHit[] hits = searchResponse.getHits().getHits();
              Set up a fetch sub phase that throws an exception on indices whose name that start with "boom".
import org.opensearch.core.common.Strings;
            assertEquals(2, searchResponse.getHits().getTotalHits().value());
                ) throws IOException {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numOfReplicas)
                    () -> client.prepareSearch("test").addAggregation(new TestAggregationBuilder("test")).get()
import org.opensearch.core.common.io.stream.StreamInput;
            SearchRequest searchRequest = SearchRequest.subSearchRequest(  
    /**
        });  
    public void testLocalClusterAlias() {  
            }
        protected AggregatorFactory doBuild(
    public void testSearchIdleWithSegmentReplication() {  
            }
            .put(IndexSettings.INDEX_SEARCH_IDLE_AFTER.getKey(), TimeValue.timeValueMillis(randomIntBetween(50, 500)));
            assertEquals(1, searchResponse.getHits().getTotalHits().value());  
 * not use this file except in compliance with the License.
            throw new CollectionTerminatedException();  
}
                final IndicesService indicesService = internalCluster().getInstance(IndicesService.class, node);  
            final int index = i;
            // no exception  
        public void postCollection() throws IOException {}  
            }  
        return Collections.singletonList(TestPlugin.class);  
            assertEquals("test-1970.01.01", searchResponse.getHits().getHits()[0].getIndex());
            }  
        });
            };
            assertThat(exceptions.asList().size(), equalTo(10));
import org.opensearch.search.aggregations.InternalAggregation;  
                "local",
            assertBusy(() -> assertThat(requestBreakerUsed(), equalTo(0L)));  
        try {  
            final CountDownLatch latch = new CountDownLatch(10);
            final int numPrimaries1 = randomIntBetween(2, 10);
                @Override
import static org.hamcrest.Matchers.containsString;  
            for (IndexShard indexShard : indicesService.indexServiceSafe(resolveIndex("test"))) {  
        }
        {
import java.util.Collection;
            return Collections.singletonList(fetchContext -> new FetchSubPhaseProcessor() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.index.LeafReaderContext;
import java.util.List;
            );
 * Modifications Copyright OpenSearch Contributors. See
                )
        @Override
        final CountDownLatch latch = new CountDownLatch(10);
                    Settings.builder()
            estimated += nodeStats.getBreaker().getStats(CircuitBreaker.REQUEST).getEstimated();  
                    SearchContext searchContext,
import org.opensearch.search.aggregations.support.ValueType;
            IndexRequest indexRequest = new IndexRequest("test");
        internalCluster().ensureAtLeastNumDataNodes(numOfReplicas + 1);  
                        responses.set(index, false);
 * specific language governing permissions and limitations
                    .setTransientSettings(Collections.singletonMap(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING.getKey(), numPrimaries1))
            AggregatorFactories.Builder subFactoriesBuilder
        @Override
            return builder;  
                    .setBatchedReduceSize(batchReduceSize)  
            );
            });
        IndexRequest indexRequest = new IndexRequest("test");
    }
                    .addAggregation(new TestAggregationBuilder("test"))
            SearchRequest searchRequest = randomBoolean()
        client().prepareIndex("test").setId("1").setSource("created_date", "2020-01-01").get();  
                        exceptions.set(index, exc);
import org.opensearch.core.xcontent.XContentBuilder;
        TestAggregationBuilder(StreamInput input) throws IOException {
            indexRequest.id("1");
        indexRequest.id("1");  
import org.opensearch.index.query.RangeQueryBuilder;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.AggregatorBase;
            Settings settings = Settings.builder().put("indices.breaker.request.limit", "1b").build();
            SearchHit hit = hits[0];
            indexRequest.source("date", "1982-01-01");  
                new SearchRequest(),
import org.opensearch.common.unit.TimeValue;
                    .request();
            indexRequest.id("1");
import org.opensearch.index.shard.IndexShard;  
        static final String NAME = "test";
        assertAcked(  
        @Override
    }
        final Settings.Builder settings = Settings.builder()  
    public void testCircuitBreakerFetchFail() throws Exception {
                });
 * under the License.  
        }
                int batchReduceSize = randomIntBetween(2, Math.max(numShards + 1, 3));  
        indexSomeDocs("boom", numShards, numDocs);
/*  
        public String name() {
                nowInMillis,  
        }  
                assertFalse(indexShard.isSearchIdleSupported());
        @Override  
        }
    }
            SearchRequest searchRequest = SearchRequest.subSearchRequest(new SearchRequest(), Strings.EMPTY_ARRAY, "", 0, randomBoolean());
import org.opensearch.action.index.IndexRequest;
            SearchResponse searchResponse = client().search(searchRequest).actionGet();
                Strings.EMPTY_ARRAY,
        public BucketCardinality bucketCardinality() {  
        long nowInMillis = randomLongBetween(0, Long.MAX_VALUE);
            return parent;
        public void close() {}
        client().admin().indices().prepareRefresh(indexName).get();
            assertEquals(1, hits.length);
import org.opensearch.search.aggregations.AggregatorFactories;  
        private final SearchContext context;
                .indices()
        }
        {  
        source.aggregation(terms);
            assertThat(
        IndexResponse indexResponse = client().index(indexRequest).actionGet();  
        }
import org.opensearch.index.query.QueryShardContext;
                }  
        {
            SearchRequest searchRequest = new SearchRequest();  
            indexRequest.source("date", "1970-01-01");
            assertEquals("", hit.getClusterAlias());  
                ? originalRequest
            client().admin()  
                SearchRequest request = client().prepareSearch("test")  
        assertAcked(prepareCreate("test").setSettings(settings).setMapping("created_date", "type=date,format=yyyy-MM-dd"));
 */
import org.opensearch.search.aggregations.AggregationBuilder;
 */  
        source.size(0);
                    CardinalityUpperBound cardinality,  
import java.util.concurrent.CountDownLatch;  
            return "test";  
    private static class TestAggregationBuilder extends AbstractAggregationBuilder<TestAggregationBuilder> {
        for (String node : internalCluster().nodesInclude("test")) {
            searchRequest.source(sourceBuilder);
import org.opensearch.search.fetch.FetchSubPhase;
        @Override
        return estimated;
    }
    public static class TestPlugin extends Plugin implements SearchPlugin {
            return new InternalMax(name(), Double.NaN, DocValueFormat.RAW, Collections.emptyMap());
            IndexResponse indexResponse = client().index(indexRequest).actionGet();  
            assertEquals(RestStatus.CREATED, indexResponse.status());
    public void testSearchIdle() throws Exception {
    }
            SearchRequest request = client().prepareSearch("boom")
