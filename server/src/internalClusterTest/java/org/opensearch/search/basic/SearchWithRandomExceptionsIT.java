import org.opensearch.common.settings.Settings.Builder;
 * under the License.
        ensureSearchable();
                SearchResponse searchResponse = client().prepareSearch()
                    case Norms:
import org.opensearch.action.search.SearchResponse;
                Property.IndexScope
            }
                }
            .startObject("properties")
                    case Fields:
            .startObject()
                settings.add(EXCEPTION_LOW_LEVEL_RATIO_SETTING);
 * ownership. Elasticsearch licenses this file to you under
            public void maybeThrow(ThrowingLeafReaderWrapper.Flags flag) throws IOException {
            }
    @Override
                        }
                lowLevelRate = 1.0 / between(2, 10);
                    case DocsEnum:
    public SearchWithRandomExceptionsIT(Settings staticSettings) {
                    .setTimeout(TimeValue.timeValueSeconds(1))
import java.io.IOException;
            }
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
 * Modifications Copyright OpenSearch Contributors. See
        public RandomExceptionDirectoryReaderWrapper(DirectoryReader in, Settings settings) throws IOException {
                return new ThrowingLeafReaderWrapper(reader, this);
 */
                logger.info("Searching for [test:{}]", English.intToEnglish(docToQuery));
                        break;
 * license agreements. See the NOTICE file distributed with
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                }
                0.1d,
import org.opensearch.test.OpenSearchIntegTestCase;
        super(staticSettings);
            } catch (OpenSearchException ex) {}
            if (randomBoolean()) {
            private final Random random;
import org.opensearch.common.xcontent.XContentFactory;
            public static final Setting<Double> EXCEPTION_LOW_LEVEL_RATIO_SETTING = Setting.doubleSetting(
                settings.add(EXCEPTION_TOP_LEVEL_RATIO_SETTING);
import java.util.ArrayList;
            private final double topLevelRatio;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.engine.MockEngineSupport;
        // and `TranslogWriter.buffer` is not null, which causes arrays not been released,
            @Override
                    assertResultsAndLogOnFailure(numCreated, searchResponse);
            return in.getReaderCacheHelper();
                // check match all
            .put(MockEngineSupport.WRAP_READER_RATIO.getKey(), 1.0d);
    public static Collection<Object[]> parameters() {
            }
                    .get();
            );
                    lowLevelRate = 1.0 / between(2, 10);
 * compatible open source license.
                0.0d,
        public static class TestPlugin extends MockEngineFactoryPlugin {
import org.apache.lucene.index.DirectoryReader;
 * Licensed to Elasticsearch under one or more contributor
        String mapping = XContentFactory.jsonBuilder()
import org.opensearch.common.unit.TimeValue;
                switch (flag) {
                    .get();
                    case Terms:
            .endObject()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    case Intersect:
            topLevelRate = 0d;
            ThrowingSubReaderWrapper(Settings settings) {
 * software distributed under the License is distributed on an
        logger.info("Start Refresh");
 *
                    case NumericDocValues:
        boolean[] added = new boolean[numDocs];
    }
                EXCEPTION_LOW_LEVEL_RATIO_KEY,
        }
                0.0d,
                    numCreated++;
            @Override
        return Arrays.asList(RandomExceptionDirectoryReaderWrapper.TestPlugin.class);
            refreshFailed,
                settings.addAll(super.getSettings());
        // so we need to close the index to release the arrays.
 *
            );
        protected DirectoryReader doWrapDirectoryReader(DirectoryReader in) throws IOException {
import org.apache.lucene.tests.util.English;
            return new RandomExceptionDirectoryReaderWrapper(in, settings);
import org.opensearch.action.search.SearchPhaseExecutionException;
        logger.info(
            // rarely no exception
        }
                return settings;
            this.settings = settings;
        for (int i = 0; i < numSearches; i++) {
                    assertResultsAndLogOnFailure(expectedResults, searchResponse);
                    .setQuery(QueryBuilders.matchQuery("test", English.intToEnglish(docToQuery)))
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                0.1d,
            .startObject("test")
 * SPDX-License-Identifier: Apache-2.0
                    .setSize(numCreated)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
                    case TermVectors:
            .field("type", "keyword")
            refreshResponse.getFailedShards(),
                    topLevelRate = 0.0d;
                        }
 * The OpenSearch Contributors require contributions made to
                if (randomBoolean()) {
                searchResponse = client().prepareSearch()
    public static class RandomExceptionDirectoryReaderWrapper extends MockEngineSupport.DirectoryReaderWrapper {
                this.lowLevelRatio = settings.getAsDouble(EXCEPTION_LOW_LEVEL_RATIO_KEY, 0.1d);
                }
import org.opensearch.common.settings.Settings;
import java.util.List;
    }
            .put(indexSettings())
import org.opensearch.test.engine.ThrowingLeafReaderWrapper;
        return Arrays.asList(
            }
import org.opensearch.index.query.QueryBuilders;
import org.opensearch.common.settings.Setting;
        }
                topLevelRate = 1.0 / between(2, 10);
 * KIND, either express or implied.  See the License for the
                    .setId("" + i)
                        if (random.nextDouble() < topLevelRatio) {
        final double topLevelRate;
                EXCEPTION_TOP_LEVEL_RATIO_KEY,
            @Override
            "Refresh failed [{}] numShardsFailed: [{}], shardFailuresLength: [{}], successfulShards: [{}], totalShards: [{}] ",
    @ParametersFactory
                    .setQuery(QueryBuilders.matchAllQuery())
            refreshResponse.getTotalShards()
import java.util.Collection;
            .endObject()
        private final Settings settings;
 */
                    .get();
        assertAcked(prepareCreate("test").setSettings(settings).setMapping(mapping));
            } catch (SearchPhaseExecutionException ex) {
                    .addSort("_id", SortOrder.ASC)
        final boolean refreshFailed = refreshResponse.getShardFailures().length != 0 || refreshResponse.getFailedShards() != 0;
                    added[i] = true;
        if (frequently()) {
import org.apache.lucene.index.FilterDirectoryReader;
                    .setSource("test", English.intToEnglish(i))
public class SearchWithRandomExceptionsIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        }
package org.opensearch.search.basic;
                IndexResponse indexResponse = client().prepareIndex("test")
            public static final Setting<Double> EXCEPTION_TOP_LEVEL_RATIO_SETTING = Setting.doubleSetting(
/*
        Builder settings = Settings.builder()
            public LeafReader wrap(LeafReader reader) {
import org.opensearch.action.index.IndexResponse;
            .put(EXCEPTION_TOP_LEVEL_RATIO_KEY, topLevelRate)
                    case BinaryDocValues:
        RefreshResponse refreshResponse = client().admin().indices().prepareRefresh("test").execute().get();
/*
                    case SortedSetDocValues:
        return false;
import java.util.Random;
            lowLevelRate = 0d;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        // as the index refresh may fail, so the translog in the index will be not flushed,
                if (searchResponse.getSuccessfulShards() == test.numPrimaries && !refreshFailed) {
                this.topLevelRatio = settings.getAsDouble(EXCEPTION_TOP_LEVEL_RATIO_KEY, 0.1d);
import org.opensearch.plugins.Plugin;
                if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {
            protected Class<? extends FilterDirectoryReader> getReaderWrapperClass() {
                            throw new IOException("Forced low level Exception on [" + flag.name() + "]");
                return RandomExceptionDirectoryReaderWrapper.class;
        );
            private final double lowLevelRatio;
        final double lowLevelRate;
 * Unless required by applicable law or agreed to in writing,
        cluster().wipeIndices("test");
            }
            public List<Setting<?>> getSettings() {
        public CacheHelper getReaderCacheHelper() {
    public void testRandomExceptions() throws IOException, InterruptedException, ExecutionException {
 * not use this file except in compliance with the License.
        int numCreated = 0;
/*
                        break;
        @Override
            try {
        } else {
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
                Property.IndexScope
}
        NumShards test = getNumShards("test");
 *
        // don't assert on failures here
                    case TermsEnum:
                }
        final int numDocs = between(10, 100);
                    lowLevelRate = 0.0d;
        final int numSearches = scaledRandomIntBetween(100, 200);
                List<Setting<?>> settings = new ArrayList<>();
import java.util.Arrays;
    public static final String EXCEPTION_LOW_LEVEL_RATIO_KEY = "index.engine.exception.ratio.low";
            public boolean wrapTerms(String field) {
import java.util.concurrent.ExecutionException;
import org.opensearch.common.settings.Setting.Property;
                this.random = new Random(seed);
                    case SortedDocValues:
            @Override
 * this file be licensed under the Apache-2.0 license or a
        static class ThrowingSubReaderWrapper extends FilterDirectoryReader.SubReaderWrapper implements ThrowingLeafReaderWrapper.Thrower {
                    case DocsAndPositionsEnum:
                } else {
                            throw new IOException("Forced top level Exception on [" + flag.name() + "]");
import org.opensearch.action.DocWriteResponse;
        for (int i = 0; i < numDocs; i++) {
 * GitHub history for details.
                return true;
import org.opensearch.search.sort.SortOrder;
            .put(EXCEPTION_LOW_LEVEL_RATIO_KEY, lowLevelRate)
 * You may obtain a copy of the License at
    }
                logger.info("Match all Successful shards: [{}]  numShards: [{}]", searchResponse.getSuccessfulShards(), test.numPrimaries);
 */
                int expectedResults = added[docToQuery] ? 1 : 0;
                    topLevelRate = 1.0 / between(2, 10);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
 * specific language governing permissions and limitations
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                final long seed = OpenSearchIntegTestCase.INDEX_TEST_SEED_SETTING.get(settings);
            .toString();
        @Override
            } else {
                if (searchResponse.getSuccessfulShards() == test.numPrimaries && !refreshFailed) {
                    .setSize(expectedResults)
                }
import org.opensearch.OpenSearchException;
        }
            }
    }
            refreshResponse.getShardFailures().length,
        // we don't check anything here really just making sure we don't leave any open files or a broken index behind.
            try {
        }
import org.apache.lucene.index.LeafReader;
    protected boolean addMockInternalEngine() {
            @Override
        }
        logger.info("creating index: [test] using settings: [{}]", settings.build());
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
    }
                logger.info("Successful shards: [{}]  numShards: [{}]", searchResponse.getSuccessfulShards(), test.numPrimaries);
                int docToQuery = between(0, numDocs - 1);
                logger.info("expected SearchPhaseException: [{}]", ex.getMessage());
    public static final String EXCEPTION_TOP_LEVEL_RATIO_KEY = "index.engine.exception.ratio.top";
            }
            super(in, new ThrowingSubReaderWrapper(settings));
    @Override
            .endObject()
import org.opensearch.index.MockEngineFactoryPlugin;
        );
                        if (random.nextDouble() < lowLevelRatio) {
 * this work for additional information regarding copyright
            refreshResponse.getSuccessfulShards(),
