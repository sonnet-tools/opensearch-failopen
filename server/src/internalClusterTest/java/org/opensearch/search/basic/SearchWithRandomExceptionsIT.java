 */
                        }  
                    case Terms:
                            throw new IOException("Forced low level Exception on [" + flag.name() + "]");
import java.util.Collection;
                logger.info("expected SearchPhaseException: [{}]", ex.getMessage());  
                if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {
                searchResponse = client().prepareSearch()
            } else {  
                    case TermsEnum:  
 * Licensed to Elasticsearch under one or more contributor  
    public void testRandomExceptions() throws IOException, InterruptedException, ExecutionException {  
                EXCEPTION_TOP_LEVEL_RATIO_KEY,
import org.opensearch.index.query.QueryBuilders;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            refreshResponse.getTotalShards()
                if (randomBoolean()) {
        ensureSearchable();
                int docToQuery = between(0, numDocs - 1);
                IndexResponse indexResponse = client().prepareIndex("test")
                    case SortedDocValues:
            }
                        }  
import java.util.ArrayList;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
                    .setTimeout(TimeValue.timeValueSeconds(1))
 * specific language governing permissions and limitations
                    assertResultsAndLogOnFailure(numCreated, searchResponse);
            .put(MockEngineSupport.WRAP_READER_RATIO.getKey(), 1.0d);
    protected boolean addMockInternalEngine() {
import java.util.Random;  
        logger.info("Start Refresh");
        public CacheHelper getReaderCacheHelper() {
import org.opensearch.index.MockEngineFactoryPlugin;
                0.0d,
            }
        NumShards test = getNumShards("test");
    public static final String EXCEPTION_LOW_LEVEL_RATIO_KEY = "index.engine.exception.ratio.low";
            .startObject()
 * license agreements. See the NOTICE file distributed with
                    topLevelRate = 1.0 / between(2, 10);  
                    case SortedSetDocValues:  
        protected DirectoryReader doWrapDirectoryReader(DirectoryReader in) throws IOException {
                }
 *  
            .put(indexSettings())
                } else {
                settings.addAll(super.getSettings());
                return new ThrowingLeafReaderWrapper(reader, this);  
    }
                    .get();
    public static class RandomExceptionDirectoryReaderWrapper extends MockEngineSupport.DirectoryReaderWrapper {
    }
                    case Intersect:
            lowLevelRate = 0d;
        super(staticSettings);  
import org.opensearch.common.settings.Setting;
import org.opensearch.OpenSearchException;
        // we don't check anything here really just making sure we don't leave any open files or a broken index behind.
import org.opensearch.action.search.SearchResponse;  
                switch (flag) {
        final double lowLevelRate;
    public SearchWithRandomExceptionsIT(Settings staticSettings) {
 * GitHub history for details.
            refreshResponse.getShardFailures().length,  
import org.opensearch.common.unit.TimeValue;
                0.1d,  
 * the Apache License, Version 2.0 (the "License"); you may
            .put(EXCEPTION_TOP_LEVEL_RATIO_KEY, topLevelRate)  
                return settings;
import org.opensearch.action.search.SearchPhaseExecutionException;
/*
                logger.info("Match all Successful shards: [{}]  numShards: [{}]", searchResponse.getSuccessfulShards(), test.numPrimaries);  
                    case DocsEnum:
        public RandomExceptionDirectoryReaderWrapper(DirectoryReader in, Settings settings) throws IOException {
            } catch (SearchPhaseExecutionException ex) {
            }
import org.opensearch.action.DocWriteResponse;
                SearchResponse searchResponse = client().prepareSearch()
                    case TermVectors:
            } catch (OpenSearchException ex) {}
                    lowLevelRate = 0.0d;
 * Modifications Copyright OpenSearch Contributors. See
    }
                    case DocsAndPositionsEnum:  
            if (randomBoolean()) {
    @Override
import org.opensearch.action.index.IndexResponse;
        }
        public static class TestPlugin extends MockEngineFactoryPlugin {  
                List<Setting<?>> settings = new ArrayList<>();
    }
                    .setQuery(QueryBuilders.matchQuery("test", English.intToEnglish(docToQuery)))
        RefreshResponse refreshResponse = client().admin().indices().prepareRefresh("test").execute().get();  
package org.opensearch.search.basic;
 * not use this file except in compliance with the License.
                        break;
                if (searchResponse.getSuccessfulShards() == test.numPrimaries && !refreshFailed) {
    }  
                return RandomExceptionDirectoryReaderWrapper.class;
                EXCEPTION_LOW_LEVEL_RATIO_KEY,
import org.opensearch.common.xcontent.XContentFactory;  
            private final double lowLevelRatio;
                    .get();  
        int numCreated = 0;
            this.settings = settings;
        logger.info("creating index: [test] using settings: [{}]", settings.build());  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
            .field("type", "keyword")
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
import org.opensearch.test.OpenSearchIntegTestCase;
                if (searchResponse.getSuccessfulShards() == test.numPrimaries && !refreshFailed) {  
            return in.getReaderCacheHelper();
                0.0d,
        // as the index refresh may fail, so the translog in the index will be not flushed,
        return false;  
 *
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .toString();  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
                    added[i] = true;  
                            throw new IOException("Forced top level Exception on [" + flag.name() + "]");
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
            @Override
        // don't assert on failures here
            try {
    public static Collection<Object[]> parameters() {
            }
        }
        // so we need to close the index to release the arrays.  
        }  
                    .setId("" + i)  
            @Override
/*  
                logger.info("Successful shards: [{}]  numShards: [{}]", searchResponse.getSuccessfulShards(), test.numPrimaries);
                // check match all  
        }  
                    case Norms:
            try {  
        final boolean refreshFailed = refreshResponse.getShardFailures().length != 0 || refreshResponse.getFailedShards() != 0;
 * You may obtain a copy of the License at  
            @Override
        cluster().wipeIndices("test");
            public LeafReader wrap(LeafReader reader) {
                        break;
                final long seed = OpenSearchIntegTestCase.INDEX_TEST_SEED_SETTING.get(settings);
        return Arrays.asList(
        @Override
                int expectedResults = added[docToQuery] ? 1 : 0;
                    case BinaryDocValues:
import org.opensearch.common.settings.Setting.Property;
 * under the License.  
            .endObject()  
                0.1d,  
 * KIND, either express or implied.  See the License for the
            }  
                    numCreated++;
                Property.IndexScope
 */  
            }  
            topLevelRate = 0d;  
            public void maybeThrow(ThrowingLeafReaderWrapper.Flags flag) throws IOException {
        if (frequently()) {  
                    assertResultsAndLogOnFailure(expectedResults, searchResponse);
import java.util.concurrent.ExecutionException;
                this.lowLevelRatio = settings.getAsDouble(EXCEPTION_LOW_LEVEL_RATIO_KEY, 0.1d);  
 * this file be licensed under the Apache-2.0 license or a
            refreshResponse.getSuccessfulShards(),
            .endObject()
                logger.info("Searching for [test:{}]", English.intToEnglish(docToQuery));  
            private final Random random;
        for (int i = 0; i < numSearches; i++) {
import java.io.IOException;
 * this work for additional information regarding copyright
        String mapping = XContentFactory.jsonBuilder()
            .startObject("properties")  
            "Refresh failed [{}] numShardsFailed: [{}], shardFailuresLength: [{}], successfulShards: [{}], totalShards: [{}] ",  
            @Override
import org.opensearch.plugins.Plugin;  
 * Unless required by applicable law or agreed to in writing,
    @ParametersFactory  
            );  
                    .setSize(numCreated)  
                }
        }  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import org.opensearch.test.engine.ThrowingLeafReaderWrapper;
                    topLevelRate = 0.0d;
            @Override  
                    case Fields:  
            // rarely no exception
 *
            }
        static class ThrowingSubReaderWrapper extends FilterDirectoryReader.SubReaderWrapper implements ThrowingLeafReaderWrapper.Thrower {
            public static final Setting<Double> EXCEPTION_TOP_LEVEL_RATIO_SETTING = Setting.doubleSetting(
            super(in, new ThrowingSubReaderWrapper(settings));  
}  
 * ownership. Elasticsearch licenses this file to you under  
        private final Settings settings;
            ThrowingSubReaderWrapper(Settings settings) {  
                settings.add(EXCEPTION_TOP_LEVEL_RATIO_SETTING);  
                lowLevelRate = 1.0 / between(2, 10);
 * software distributed under the License is distributed on an
            protected Class<? extends FilterDirectoryReader> getReaderWrapperClass() {  
        final int numSearches = scaledRandomIntBetween(100, 200);  
 * The OpenSearch Contributors require contributions made to  
                this.topLevelRatio = settings.getAsDouble(EXCEPTION_TOP_LEVEL_RATIO_KEY, 0.1d);
                }  
    public static final String EXCEPTION_TOP_LEVEL_RATIO_KEY = "index.engine.exception.ratio.top";
import org.opensearch.action.admin.indices.refresh.RefreshResponse;  
                    .setQuery(QueryBuilders.matchAllQuery())
import org.apache.lucene.index.FilterDirectoryReader;
        final int numDocs = between(10, 100);  
import org.apache.lucene.index.LeafReader;
                Property.IndexScope
        logger.info(
            .startObject("test")
import java.util.Arrays;  
 */  
import java.util.List;
                        if (random.nextDouble() < lowLevelRatio) {
                    lowLevelRate = 1.0 / between(2, 10);  
            refreshFailed,
            );  
    }
            return new RandomExceptionDirectoryReaderWrapper(in, settings);  
                this.random = new Random(seed);
            public List<Setting<?>> getSettings() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                topLevelRate = 1.0 / between(2, 10);
                    case NumericDocValues:  
                settings.add(EXCEPTION_LOW_LEVEL_RATIO_SETTING);
        }
import org.opensearch.test.engine.MockEngineSupport;
            }  
            .put(EXCEPTION_LOW_LEVEL_RATIO_KEY, lowLevelRate)
import org.opensearch.common.settings.Settings;  
            public static final Setting<Double> EXCEPTION_LOW_LEVEL_RATIO_SETTING = Setting.doubleSetting(
public class SearchWithRandomExceptionsIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
                    .get();
        return Arrays.asList(RandomExceptionDirectoryReaderWrapper.TestPlugin.class);
        assertAcked(prepareCreate("test").setSettings(settings).setMapping(mapping));
                    .setSize(expectedResults)  
        for (int i = 0; i < numDocs; i++) {  
import org.apache.lucene.tests.util.English;  
        );
                }
                return true;
        final double topLevelRate;
        }  
                    .setSource("test", English.intToEnglish(i))
        boolean[] added = new boolean[numDocs];
            refreshResponse.getFailedShards(),
                    .addSort("_id", SortOrder.ASC)
            public boolean wrapTerms(String field) {  
 * compatible open source license.
                }
        }
        @Override  
        // and `TranslogWriter.buffer` is not null, which causes arrays not been released,
            private final double topLevelRatio;  
        Builder settings = Settings.builder()
        } else {
            .endObject()
import org.opensearch.search.sort.SortOrder;
    @Override
                        if (random.nextDouble() < topLevelRatio) {
/*  
        );  
import org.opensearch.common.settings.Settings.Builder;
import org.apache.lucene.index.DirectoryReader;  
