                        break;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            private final double lowLevelRatio;
                    assertThat(
import java.util.Random;
            @Override
            .put(EXCEPTION_TOP_LEVEL_RATIO_KEY, topLevelRate)
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
        if (response.isShardsAcknowledged() == false) {
            @Override
        logger.info(
                // estimate being either positive or negative.
                    case NumericDocValues:
            0.1d,
 * The OpenSearch Contributors require contributions made to
                for (String node : internalCluster().getNodeNames()) {
 * KIND, either express or implied.  See the License for the
                // successfully set back to zero. If there is a bug in the circuit
            0.1d,
            topLevelRate = 0d;
                assertAllSuccessful(client().admin().indices().prepareClearCache("test").setFieldDataCache(true).execute().actionGet());
            if (random().nextBoolean()) {
                    .prepareNodesStats()
            @Override
    @Override
import org.opensearch.index.MockEngineFactoryPlugin;
                    .execute()
        }
            if (response.isAcknowledged()) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAllSuccessful;
            .execute()
import org.opensearch.common.settings.Settings;
            .setSettings(settings)
 * license agreements. See the NOTICE file distributed with
        } else {
import org.apache.lucene.index.FilterDirectoryReader;
            EXCEPTION_TOP_LEVEL_RATIO_KEY,
            refreshFailed,
 * this file be licensed under the Apache-2.0 license or a
            .actionGet();
                client().prepareIndex("test")
}
                settings.addAll(super.getSettings());
        }
        } else {
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
                }
import org.opensearch.common.xcontent.XContentFactory;
                        break;
                    case Terms:
    public static class RandomExceptionDirectoryReaderWrapper extends MockEngineSupport.DirectoryReaderWrapper {
                        break;
    }
 * the Apache License, Version 2.0 (the "License"); you may
        }
            } else {
                        stats.getBreaker().getStats(CircuitBreaker.FIELDDATA).getEstimated(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertThat("Breaker is set to 0", stats.getBreaker().getStats(CircuitBreaker.FIELDDATA).getEstimated(), equalTo(0L));
            public LeafReader wrap(LeafReader reader) {
            @Override
                    topLevelRate = 0.0d;
            lowLevelRate = 0d;
                        break;
import org.opensearch.core.common.breaker.CircuitBreaker;
                    lowLevelRate = 0.0d;
        final double lowLevelRate;
            .setMapping(mapping)
        @Override
        final boolean refreshFailed = refreshResponse.getShardFailures().length != 0 || refreshResponse.getFailedShards() != 0;
        return false;
            0.0d,
        protected DirectoryReader doWrapDirectoryReader(DirectoryReader in) throws IOException {
            .toString();
 */
                } else {
            numDocs = between(10, 100);
            .addMetric(BREAKER.metricName())
            refreshResponse.getSuccessfulShards(),
 *
            .startObject()
            .put(MockEngineSupport.WRAP_READER_RATIO.getKey(), 1.0d);
            return in.getReaderCacheHelper();
            }
        public static final Setting<Double> EXCEPTION_TOP_LEVEL_RATIO_SETTING = Setting.doubleSetting(
 * Unless required by applicable law or agreed to in writing,
/*
                    case Fields:
            } catch (OpenSearchException ex) {}
                logger.info("Index creation failed - only index one doc and expect searches to fail");
        NodesStatsResponse resp = client().admin()
                settings.add(EXCEPTION_LOW_LEVEL_RATIO_SETTING);
                logger.info("expected SearchPhaseException: [{}]", ex.getMessage());
                    lowLevelRate = 1.0 / between(2, 10);
                    .setSource("test-str", randomUnicodeOfLengthBetween(5, 25), "test-num", i)
        String mapping = XContentFactory.jsonBuilder()
                    case DocsAndPositionsEnum:
import org.opensearch.common.settings.Setting.Property;
            .startObject("test-str")
import org.opensearch.index.query.QueryBuilders;
            } else {
    }
            }
import java.util.concurrent.ExecutionException;
 * GitHub history for details.
            public List<Setting<?>> getSettings() {
        return Arrays.asList(RandomExceptionDirectoryReaderWrapper.TestPlugin.class);
            .field("type", "keyword")
import org.opensearch.action.search.SearchPhaseExecutionException;
import java.util.ArrayList;
            private final Random random;
                // Now, clear the cache and check that the circuit breaker has been
                    case TermVectors:
        }
import org.apache.lucene.index.LeafReader;
            Property.IndexScope
        final double topLevelRate;
                return new ThrowingLeafReaderWrapper(reader, this);
import org.opensearch.test.engine.ThrowingLeafReaderWrapper;
        }
        logger.info("Start Refresh");
            SearchRequestBuilder searchRequestBuilder = client().prepareSearch().setQuery(QueryBuilders.matchAllQuery());
                        break;
 *
                        .getIndicesFieldDataCache();
                    case Intersect:
 * specific language governing permissions and limitations
            searchRequestBuilder.addSort("test-num", SortOrder.ASC);
            ThrowingSubReaderWrapper(Settings settings) {
            refreshResponse.getTotalShards()
                    .setTimeout(TimeValue.timeValueSeconds(1))
                }
                    );
 * Licensed to Elasticsearch under one or more contributor
            }
                ensureGreen("test");  // make sure all shards are there - there could be shards that are still starting up.
                this.random = new Random(seed);
                // Since .cleanUp() is no longer called on cache clear, we need to call it on each node manually
    }
                if (randomBoolean()) {
            .execute()
        }
            boolean success = false;
 */
        for (NodeStats stats : resp.getNodes()) {
import org.apache.lucene.index.DirectoryReader;
        }
        CreateIndexResponse response = client().admin()
 * You may obtain a copy of the License at
            this.settings = settings;
            }
             * forever when indexing documents so we set numDocs = 1 and expect all shards to fail
            .getNodes()) {
                        }
            .endObject()
            .field("type", randomFrom(Arrays.asList("float", "long", "double", "short", "integer")))
            .clear()
             * trying one node after another etc. that is ok but we need to make sure we don't wait
 * software distributed under the License is distributed on an
            .indices()
                            throw new IOException("Forced low level Exception on [" + flag.name() + "]");
            .actionGet();
                    final IndicesFieldDataCache fdCache = internalCluster().getInstance(IndicesService.class, node)
                    case BinaryDocValues:
            refreshResponse.getFailedShards(),
    }
import static org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest.Metric.BREAKER;
        @Override
                    fdCache.getCache().refresh();
                return settings;
                this.topLevelRatio = EXCEPTION_TOP_LEVEL_RATIO_SETTING.get(settings);
import org.opensearch.plugins.Plugin;
                    case DocsEnum:
                this.lowLevelRatio = EXCEPTION_LOW_LEVEL_RATIO_SETTING.get(settings);
                success = true;
            .execute()
 * Tests for the circuit breaker while random exceptions are happening
        static class ThrowingSubReaderWrapper extends SubReaderWrapper implements ThrowingLeafReaderWrapper.Thrower {
    public static final String EXCEPTION_LOW_LEVEL_RATIO_KEY = "index.engine.exception.ratio.low";
        final int numSearches = scaledRandomIntBetween(50, 150);
 * SPDX-License-Identifier: Apache-2.0
            // rarely no exception
                NodesStatsResponse nodeStats = client().admin()
import org.opensearch.OpenSearchException;
            return new RandomExceptionDirectoryReaderWrapper(in, settings);
            if (randomBoolean()) {
        }
            // I don't use randomNumericType() here because I don't want "byte", and I want "float" and "double"
 */
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.test.OpenSearchIntegTestCase;
            .put(indexSettings())
            try {
            .startObject("properties")
            refreshResponse.getShardFailures().length,
            .cluster()
    protected boolean addMockInternalEngine() {
            }
            super(in, new ThrowingSubReaderWrapper(settings));
            }
        Settings.Builder settings = Settings.builder()
            }
 * not use this file except in compliance with the License.
import org.opensearch.indices.IndicesService;
                }
        for (int i = 0; i < numSearches; i++) {
                        }
                    .setId("" + i)
            .actionGet()
import java.util.Arrays;
                            throw new IOException("Forced top level Exception on [" + flag.name() + "]");
        }
import org.opensearch.test.engine.MockEngineSupport;
                for (NodeStats stats : nodeStats.getNodes()) {
                searchRequestBuilder.addSort("test-str", SortOrder.ASC);
                        break;
        // don't assert on failures here
 */
/*
 * compatible open source license.
            .field("doc_values", randomBoolean())
        private final Settings settings;
/**
                        break;
                lowLevelRate = 1.0 / between(2, 10);
                    case SortedSetDocValues:
        for (NodeStats node : client().admin()
/*
import org.opensearch.search.sort.SortOrder;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
            numDocs = 1;
            .endObject() // test-num
            if (frequently()) {
        for (int i = 0; i < numDocs; i++) {
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.unit.TimeValue;
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
                switch (flag) {
                        equalTo(0L)
            "Refresh failed: [{}] numShardsFailed: [{}], shardFailuresLength: [{}], successfulShards: [{}], totalShards: [{}] ",
            }
            Property.IndexScope
 * under the License.
 *
package org.opensearch.indices.memory.breaker;
            .prepareNodesStats()
import java.util.List;
        public CacheHelper getReaderCacheHelper() {
        if (frequently()) {
                    case Norms:
                        if (random.nextDouble() < lowLevelRatio) {
                searchRequestBuilder.get();
        );
            private final double topLevelRatio;
    // TODO: Generalize this class and add it as a utility
                // Sort by the string and numeric fields, to load them into field data
            .endObject() // test-str
            }
            .startObject("test-num")
            assertThat("Breaker is not set to 0", node.getBreaker().getStats(CircuitBreaker.FIELDDATA).getEstimated(), equalTo(0L));
            @Override
    public void testBreakerWithRandomExceptions() throws IOException, InterruptedException, ExecutionException {
            EXCEPTION_LOW_LEVEL_RATIO_KEY,
            .put(EXCEPTION_LOW_LEVEL_RATIO_KEY, lowLevelRate)
    public static final String EXCEPTION_TOP_LEVEL_RATIO_KEY = "index.engine.exception.ratio.top";
            public void maybeThrow(ThrowingLeafReaderWrapper.Flags flag) throws IOException {
                    .cluster()
    @Override
            }
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
                    case SortedDocValues:
            .addMetric(BREAKER.metricName())
                    topLevelRate = 1.0 / between(2, 10);
            0.0d,
        }
import java.io.IOException;
                logger.info("Index creation timed out waiting for primaries to start - only index one doc and expect searches to fail");
                settings.add(EXCEPTION_TOP_LEVEL_RATIO_SETTING);
            .prepareCreate("test")
        public static class TestPlugin extends MockEngineFactoryPlugin {
                        break;
                return field.startsWith("test");
        );
                    .addMetric(BREAKER.metricName())
                }
        );
                    .actionGet();
                return RandomExceptionDirectoryReaderWrapper.class;
                        "Breaker reset to 0 last search success: " + success + " mapping: " + mapping,
            protected Class<? extends FilterDirectoryReader> getReaderWrapperClass() {
public class RandomExceptionCircuitBreakerIT extends OpenSearchIntegTestCase {
                    .clear()
            .prepareNodesStats()
        }
        public static final Setting<Double> EXCEPTION_LOW_LEVEL_RATIO_SETTING = Setting.doubleSetting(
            /* some seeds just won't let you create the index at all and we enter a ping-pong mode
                final long seed = OpenSearchIntegTestCase.INDEX_TEST_SEED_SETTING.get(settings);
            public boolean wrapTerms(String field) {
            } catch (SearchPhaseExecutionException ex) {
            .endObject() // properties
            .clear()
                List<Setting<?>> settings = new ArrayList<>();
             * when we search below.*/
        final int numDocs;
                        if (random.nextDouble() < topLevelRatio) {
import java.util.Collection;
                    .get();
import org.opensearch.common.settings.Setting;
import org.opensearch.action.search.SearchRequestBuilder;
                // breaker adjustment code, it should show up here by the breaker
                        break;
        public RandomExceptionDirectoryReaderWrapper(DirectoryReader in, Settings settings) throws IOException {
                    case TermsEnum:
                    // Clean up the cache, ensuring that entries' listeners have been called
                topLevelRate = 1.0 / between(2, 10);
        logger.info("creating index: [test] using settings: [{}]", settings.build());
            try {
import static org.hamcrest.Matchers.equalTo;
                        break;
            }
        RefreshResponse refreshResponse = client().admin().indices().prepareRefresh("test").execute().get();
            .cluster()
