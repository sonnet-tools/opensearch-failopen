                    case NumericDocValues:
                        if (random.nextDouble() < topLevelRatio) {
        final int numSearches = scaledRandomIntBetween(50, 150);
             * trying one node after another etc. that is ok but we need to make sure we don't wait
                    assertThat(
import org.opensearch.common.settings.Setting.Property;  
                logger.info("expected SearchPhaseException: [{}]", ex.getMessage());
                logger.info("Index creation failed - only index one doc and expect searches to fail");
        public RandomExceptionDirectoryReaderWrapper(DirectoryReader in, Settings settings) throws IOException {  
        public CacheHelper getReaderCacheHelper() {
                        equalTo(0L)
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAllSuccessful;  
            }
            0.0d,
                List<Setting<?>> settings = new ArrayList<>();  
            assertThat("Breaker is set to 0", stats.getBreaker().getStats(CircuitBreaker.FIELDDATA).getEstimated(), equalTo(0L));
        NodesStatsResponse resp = client().admin()  
            public LeafReader wrap(LeafReader reader) {
        final double lowLevelRate;
            // rarely no exception
            private final double lowLevelRatio;  
            @Override
        public static final Setting<Double> EXCEPTION_TOP_LEVEL_RATIO_SETTING = Setting.doubleSetting(
 * Tests for the circuit breaker while random exceptions are happening
        }  
             * when we search below.*/
 * the Apache License, Version 2.0 (the "License"); you may
            .actionGet();  
 */
    public void testBreakerWithRandomExceptions() throws IOException, InterruptedException, ExecutionException {
import org.opensearch.core.common.breaker.CircuitBreaker;
                }
        final double topLevelRate;
import org.opensearch.test.engine.MockEngineSupport;  
        } else {
                    topLevelRate = 0.0d;
    @Override  
            private final Random random;
        }
            .field("doc_values", randomBoolean())
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
import org.apache.lucene.index.FilterDirectoryReader;
        logger.info("creating index: [test] using settings: [{}]", settings.build());  
            .endObject() // test-num  
        // don't assert on failures here  
/**  
            .execute()  
/*
                lowLevelRate = 1.0 / between(2, 10);
            .startObject("test-str")
    @Override
            .cluster()
                if (randomBoolean()) {
import org.apache.lucene.index.LeafReader;  
                        }
            searchRequestBuilder.addSort("test-num", SortOrder.ASC);
import org.opensearch.indices.IndicesService;
                    lowLevelRate = 0.0d;
    }
                        break;  
        logger.info(  
            SearchRequestBuilder searchRequestBuilder = client().prepareSearch().setQuery(QueryBuilders.matchAllQuery());  
import org.opensearch.common.unit.TimeValue;
                return RandomExceptionDirectoryReaderWrapper.class;  
        return Arrays.asList(RandomExceptionDirectoryReaderWrapper.TestPlugin.class);  
            }  
             * forever when indexing documents so we set numDocs = 1 and expect all shards to fail  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
 * Unless required by applicable law or agreed to in writing,
            try {  
                this.random = new Random(seed);  
            .clear()  
                    .execute()
            }
                        break;
            .execute()
                    .addMetric(BREAKER.metricName())  
                    case SortedDocValues:
                ensureGreen("test");  // make sure all shards are there - there could be shards that are still starting up.
                    .setId("" + i)
            // I don't use randomNumericType() here because I don't want "byte", and I want "float" and "double"
import java.util.List;
            numDocs = between(10, 100);  
import java.util.Arrays;
                } else {
            .put(indexSettings())
package org.opensearch.indices.memory.breaker;
            if (frequently()) {
 * software distributed under the License is distributed on an
        return false;
            refreshResponse.getShardFailures().length,
                logger.info("Index creation timed out waiting for primaries to start - only index one doc and expect searches to fail");  
                    case Intersect:  
import java.io.IOException;  
                    case Terms:  
        String mapping = XContentFactory.jsonBuilder()
                        "Breaker reset to 0 last search success: " + success + " mapping: " + mapping,
                success = true;  
        }
            }  
            .endObject() // test-str
import static org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest.Metric.BREAKER;
            .toString();  
 */
        if (frequently()) {  
import org.apache.lucene.index.DirectoryReader;
            .clear()  
                searchRequestBuilder.get();
        } else {
            lowLevelRate = 0d;
                        break;
            EXCEPTION_TOP_LEVEL_RATIO_KEY,  
import java.util.ArrayList;
            refreshResponse.getTotalShards()  
import org.opensearch.common.xcontent.XContentFactory;  
                this.lowLevelRatio = EXCEPTION_LOW_LEVEL_RATIO_SETTING.get(settings);
            .endObject()
                settings.addAll(super.getSettings());
                        break;  
import static org.hamcrest.Matchers.equalTo;
            0.0d,
                return new ThrowingLeafReaderWrapper(reader, this);
 */  
            0.1d,
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
                        break;
                    case BinaryDocValues:  
/*  
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
            if (random().nextBoolean()) {
            refreshResponse.getSuccessfulShards(),
        }
                final long seed = OpenSearchIntegTestCase.INDEX_TEST_SEED_SETTING.get(settings);  
                }  
            .prepareNodesStats()
                        }
                        break;
            protected Class<? extends FilterDirectoryReader> getReaderWrapperClass() {
                    .cluster()  
            @Override  
            .getNodes()) {
    }
            try {  
            0.1d,
        );
                settings.add(EXCEPTION_LOW_LEVEL_RATIO_SETTING);  
                    final IndicesFieldDataCache fdCache = internalCluster().getInstance(IndicesService.class, node)  
            }
        @Override
                    case TermsEnum:
                    case TermVectors:
                return settings;
                // Now, clear the cache and check that the circuit breaker has been  
import org.opensearch.index.query.QueryBuilders;  
            super(in, new ThrowingSubReaderWrapper(settings));
            .actionGet();
import org.opensearch.plugins.Plugin;  
            }
import org.opensearch.index.MockEngineFactoryPlugin;
        public static class TestPlugin extends MockEngineFactoryPlugin {  
            boolean success = false;
                    case SortedSetDocValues:
            .field("type", "keyword")  
                    .setTimeout(TimeValue.timeValueSeconds(1))  
            .put(EXCEPTION_LOW_LEVEL_RATIO_KEY, lowLevelRate)
 *
                topLevelRate = 1.0 / between(2, 10);
}  
                    .prepareNodesStats()
                    .actionGet();
        if (response.isShardsAcknowledged() == false) {  
            .prepareNodesStats()
            .indices()
        );
        final int numDocs;
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
        }  
            if (response.isAcknowledged()) {
            topLevelRate = 0d;  
            .put(EXCEPTION_TOP_LEVEL_RATIO_KEY, topLevelRate)  
                // successfully set back to zero. If there is a bug in the circuit
        for (int i = 0; i < numSearches; i++) {
            } else {  
        );
 * ownership. Elasticsearch licenses this file to you under  
import java.util.concurrent.ExecutionException;  
                        stats.getBreaker().getStats(CircuitBreaker.FIELDDATA).getEstimated(),  
    protected boolean addMockInternalEngine() {
            .addMetric(BREAKER.metricName())
 *    http://www.apache.org/licenses/LICENSE-2.0
                        break;
                for (NodeStats stats : nodeStats.getNodes()) {  
            /* some seeds just won't let you create the index at all and we enter a ping-pong mode
            numDocs = 1;
 * KIND, either express or implied.  See the License for the
            public List<Setting<?>> getSettings() {
            @Override  
                    .setSource("test-str", randomUnicodeOfLengthBetween(5, 25), "test-num", i)
                    case DocsEnum:  
            ThrowingSubReaderWrapper(Settings settings) {
                    .clear()
import org.opensearch.action.search.SearchPhaseExecutionException;  
        }  
import org.opensearch.search.sort.SortOrder;
            .cluster()
            .field("type", randomFrom(Arrays.asList("float", "long", "double", "short", "integer")))
                    );
        }
                searchRequestBuilder.addSort("test-str", SortOrder.ASC);
 * GitHub history for details.
 *
        }
        Settings.Builder settings = Settings.builder()
        @Override
                    fdCache.getCache().refresh();  
                    .get();
        }
        for (int i = 0; i < numDocs; i++) {
    // TODO: Generalize this class and add it as a utility
                // Sort by the string and numeric fields, to load them into field data
import org.opensearch.common.settings.Settings;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.OpenSearchException;
            private final double topLevelRatio;
                }
                return field.startsWith("test");
            refreshFailed,
 *  
                            throw new IOException("Forced low level Exception on [" + flag.name() + "]");  
        protected DirectoryReader doWrapDirectoryReader(DirectoryReader in) throws IOException {  
                        break;  
            EXCEPTION_LOW_LEVEL_RATIO_KEY,  
            this.settings = settings;
 * You may obtain a copy of the License at  
            }  
            refreshResponse.getFailedShards(),  
            }  
            .startObject("properties")
                    case Fields:
    }  
            .startObject()  
 * not use this file except in compliance with the License.
                settings.add(EXCEPTION_TOP_LEVEL_RATIO_SETTING);
 * Licensed to Elasticsearch under one or more contributor  
            .prepareCreate("test")  
                NodesStatsResponse nodeStats = client().admin()
import org.opensearch.test.OpenSearchIntegTestCase;
        final boolean refreshFailed = refreshResponse.getShardFailures().length != 0 || refreshResponse.getFailedShards() != 0;
                this.topLevelRatio = EXCEPTION_TOP_LEVEL_RATIO_SETTING.get(settings);
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * specific language governing permissions and limitations
            .startObject("test-num")  
    }  
                            throw new IOException("Forced top level Exception on [" + flag.name() + "]");  
                        if (random.nextDouble() < lowLevelRatio) {
                switch (flag) {
            .put(MockEngineSupport.WRAP_READER_RATIO.getKey(), 1.0d);
                        break;
        private final Settings settings;
                        break;
        static class ThrowingSubReaderWrapper extends SubReaderWrapper implements ThrowingLeafReaderWrapper.Thrower {  
import org.opensearch.action.search.SearchRequestBuilder;
 * compatible open source license.
                // estimate being either positive or negative.  
            .actionGet()  
        CreateIndexResponse response = client().admin()
            .setSettings(settings)
        RefreshResponse refreshResponse = client().admin().indices().prepareRefresh("test").execute().get();
            } else {
            public boolean wrapTerms(String field) {
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;  
import org.opensearch.test.engine.ThrowingLeafReaderWrapper;
            @Override
public class RandomExceptionCircuitBreakerIT extends OpenSearchIntegTestCase {  
                    // Clean up the cache, ensuring that entries' listeners have been called
                for (String node : internalCluster().getNodeNames()) {
            if (randomBoolean()) {
            .addMetric(BREAKER.metricName())
        logger.info("Start Refresh");
        for (NodeStats node : client().admin()  
            public void maybeThrow(ThrowingLeafReaderWrapper.Flags flag) throws IOException {  
    public static final String EXCEPTION_TOP_LEVEL_RATIO_KEY = "index.engine.exception.ratio.top";
            Property.IndexScope  
                client().prepareIndex("test")
                // Since .cleanUp() is no longer called on cache clear, we need to call it on each node manually
                }  
            }
 * this work for additional information regarding copyright
import java.util.Random;
            }  
import org.opensearch.common.settings.Setting;
    public static final String EXCEPTION_LOW_LEVEL_RATIO_KEY = "index.engine.exception.ratio.low";  
            .execute()
            } catch (OpenSearchException ex) {}  
        for (NodeStats stats : resp.getNodes()) {
                // breaker adjustment code, it should show up here by the breaker
                    case Norms:
            "Refresh failed: [{}] numShardsFailed: [{}], shardFailuresLength: [{}], successfulShards: [{}], totalShards: [{}] ",
            assertThat("Breaker is not set to 0", node.getBreaker().getStats(CircuitBreaker.FIELDDATA).getEstimated(), equalTo(0L));
            .setMapping(mapping)
            .endObject() // properties
            @Override
            }  
        public static final Setting<Double> EXCEPTION_LOW_LEVEL_RATIO_SETTING = Setting.doubleSetting(
            } catch (SearchPhaseExecutionException ex) {
            return new RandomExceptionDirectoryReaderWrapper(in, settings);
                    lowLevelRate = 1.0 / between(2, 10);  
 * The OpenSearch Contributors require contributions made to  
/*  
                    case DocsAndPositionsEnum:
    public static class RandomExceptionDirectoryReaderWrapper extends MockEngineSupport.DirectoryReaderWrapper {  
 * this file be licensed under the Apache-2.0 license or a
 */  
            return in.getReaderCacheHelper();  
        }
            Property.IndexScope  
                    topLevelRate = 1.0 / between(2, 10);  
import java.util.Collection;  
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
                        .getIndicesFieldDataCache();
                assertAllSuccessful(client().admin().indices().prepareClearCache("test").setFieldDataCache(true).execute().actionGet());
