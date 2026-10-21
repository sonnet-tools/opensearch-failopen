                    .setTimeout(TimeValue.timeValueSeconds(1))
                    .get();
            exceptionRate = 0d;
 * You may obtain a copy of the License at
                    Settings.builder()
                );
                );
            } catch (SearchPhaseExecutionException ex) {
                }
             * forever when indexing documents so we set numDocs = 1 and expecte all shards to fail
                    Settings.builder()
 * specific language governing permissions and limitations
                .setSettings(
                exceptionRate = 1.0 / between(5, 100);
import java.util.Arrays;
 *
            .endObject()
                    assertResultsAndLogOnFailure(numCreated + numInitialDocs, searchResponse);
            ensureGreen();
            client().admin().indices().prepareCreate("test").setSettings(settings).setMapping(mapping).get();
            "Refresh failed [{}] numShardsFailed: [{}], shardFailuresLength: [{}], successfulShards: [{}], totalShards: [{}] ",
import org.opensearch.index.query.QueryBuilders;
                    assertResultsAndLogOnFailure(expectedResults, searchResponse);
 * license agreements. See the NOTICE file distributed with
                }
                if (randomBoolean()) {
        );
                if (!(expectAllShardsFailed
            logger.info("creating index: [test] using settings: [{}]", settings.build());
                        .put(MockFSDirectoryFactory.RANDOM_IO_EXCEPTION_RATE_ON_OPEN_SETTING.getKey(), 0)
 * Licensed to Elasticsearch under one or more contributor
        final int numDocs;
            SearchResponse searchResponse = client().prepareSearch().setQuery(QueryBuilders.matchQuery("test", "init")).get();
import org.opensearch.test.store.MockFSIndexStore;
                }
                } else {
                    || refreshResponse.getSuccessfulShards() == 0
        } else {
import org.apache.lucene.tests.util.English;
            refreshResponse.getSuccessfulShards(),
        final RefreshResponse refreshResponse = client().admin().indices().prepareRefresh("test").execute().get();
 *
                    exceptionRate = 1.0 / between(5, 100);
            client().admin().indices().prepareClose("test").execute().get();
        int numInitialDocs = 0;
            .field("type", "keyword")
                    searchResponse.getSuccessfulShards(),
            .cluster()
 */
 * ownership. Elasticsearch licenses this file to you under
                searchResponse = client().prepareSearch()
                    "Match all Successful shards: [{}]  numShards: [{}]",
 */
    @ParametersFactory
                // we cannot expect that the index will be valid
        logger.info(
            .startObject("properties")
                // if a scheduled refresh or flush fails all shards we see all shards failed here
        if (clusterHealthResponse.isTimedOut()) {
            assertHitCount(searchResponse, numInitialDocs);
            .startObject()
             * when we search below.*/
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                logger.info("Searching for [test:{}]", English.intToEnglish(docToQuery));
        );
 * KIND, either express or implied.  See the License for the
            // rarely no exception
 *    http://www.apache.org/licenses/LICENSE-2.0
            refreshResponse.getTotalShards()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        int numCreated = 0;
 * this file be licensed under the Apache-2.0 license or a
        boolean[] added = new boolean[numDocs];
import java.util.Collection;
 * Unless required by applicable law or agreed to in writing,
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
public class SearchWithRandomIOExceptionsIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
import org.opensearch.OpenSearchException;
            numDocs = 1;
        }
import org.opensearch.action.DocWriteResponse;
import java.util.concurrent.ExecutionException;
                int expectedResults = added[docToQuery] ? 1 : 0;
import org.opensearch.action.search.SearchPhaseExecutionException;
                    numShards.numPrimaries
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import org.opensearch.test.OpenSearchIntegTestCase;
            .endObject()
        }
            .startObject("test")
        final boolean expectAllShardsFailed;
        // don't assert on failures here
    @Override
            client().admin()
        for (int i = 0; i < numSearches; i++) {
            } else {
    }
}
        if (createIndexWithoutErrors) {
                exceptionOnOpenRate = 1.0 / between(5, 100);
                    .setId(Integer.toString(i))
import org.opensearch.common.unit.TimeValue;
 * not use this file except in compliance with the License.
            .endObject()
            .health(Requests.clusterHealthRequest().waitForYellowStatus().timeout(TimeValue.timeValueSeconds(5)))
    protected Collection<Class<? extends Plugin>> nodePlugins() {
/*
    }
import org.opensearch.test.store.MockFSDirectoryFactory;
 * the Apache License, Version 2.0 (the "License"); you may
            refreshResponse.getShardFailures().length,
            if (randomBoolean()) {
    public SearchWithRandomIOExceptionsIT(Settings staticSettings) {
                    throw ex;
            client().admin().indices().prepareFlush("test").execute().get();
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
/*
        String mapping = XContentFactory.jsonBuilder()
            refreshResponse.getFailedShards(),
            /* some seeds just won't let you create the index at all and we enter a ping-pong mode
            exceptionOnOpenRate = 0d;
                logger.info(
            .toString();
            client().admin()
                logger.info("Successful shards: [{}]  numShards: [{}]", searchResponse.getSuccessfulShards(), numShards.numPrimaries);
            numInitialDocs = between(10, 100);
                }
 * The OpenSearch Contributors require contributions made to
            ensureGreen();
                    .get();
                }
            refreshFailed,
            } catch (OpenSearchException ex) {}
    }
                .put(MockFSDirectoryFactory.RANDOM_IO_EXCEPTION_RATE_SETTING.getKey(), exceptionRate)
 * software distributed under the License is distributed on an
            Settings.Builder settings = Settings.builder().put("index.number_of_replicas", numberOfReplicas());
            client().admin().indices().prepareCreate("test").setSettings(settings).setMapping(mapping).get();
            expectAllShardsFailed = true;
            assertNoFailures(searchResponse);
        final boolean refreshFailed = refreshResponse.getShardFailures().length != 0 || refreshResponse.getFailedShards() != 0;
                    .setSize(expectedResults)
        return Arrays.asList(MockFSIndexStore.TestPlugin.class);
                    .setSize(numCreated + numInitialDocs)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        for (int i = 0; i < numDocs; i++) {
                    .setQuery(QueryBuilders.matchAllQuery())
            try {
 * SPDX-License-Identifier: Apache-2.0
                .put(MockFSDirectoryFactory.RANDOM_IO_EXCEPTION_RATE_ON_OPEN_SETTING.getKey(), exceptionOnOpenRate);
                int docToQuery = between(0, numDocs - 1);
            for (int i = 0; i < numInitialDocs; i++) {
                );
import org.opensearch.transport.client.Requests;
        }
            added[i] = false;
            client().admin().indices().prepareOpen("test").execute().get();
package org.opensearch.search.basic;
    public static Collection<Object[]> parameters() {
                // check match all
        ClusterHealthResponse clusterHealthResponse = client().admin()
import org.opensearch.common.xcontent.XContentFactory;
            client().admin().indices().prepareClose("test").execute().get();
                    exceptionOnOpenRate = 0.0d;
            expectAllShardsFailed = false;
            client().admin().indices().prepareOpen("test").execute().get();
        return Arrays.asList(
                    .setSource("test", English.intToEnglish(i))
        final double exceptionOnOpenRate;
                    .addSort("_uid", SortOrder.ASC)
        final boolean createIndexWithoutErrors = randomBoolean();
                IndexResponse indexResponse = client().prepareIndex("test")
 * compatible open source license.
        } else {
            logger.info("creating index: [test] using settings: [{}]", settings.build());
import org.opensearch.plugins.Plugin;
            // it's OK to timeout here
 * this work for additional information regarding copyright
            }
            .get();
                    numCreated++;
                .put("index.number_of_replicas", randomIntBetween(0, 1))
 *
                if (searchResponse.getSuccessfulShards() == numShards.numPrimaries && !refreshFailed) {
                client().prepareIndex("test").setId("init" + i).setSource("test", "init").get();
            numDocs = between(10, 100);
    public void testRandomDirectoryIOExceptions() throws IOException, InterruptedException, ExecutionException {
 */
                logger.info("SearchPhaseException: [{}]", ex.getMessage());
 * Modifications Copyright OpenSearch Contributors. See
                if (searchResponse.getSuccessfulShards() == numShards.numPrimaries && !refreshFailed) {
        // we don't check anything here really just making sure we don't leave any open files or a broken index behind.
                        .put(MockFSDirectoryFactory.RANDOM_IO_EXCEPTION_RATE_ON_OPEN_SETTING.getKey(), exceptionOnOpenRate)
                        .put(MockFSDirectoryFactory.RANDOM_IO_EXCEPTION_RATE_SETTING.getKey(), 0)
            // check the index still contains the records that we indexed without errors
import org.opensearch.action.search.SearchResponse;
import org.opensearch.action.index.IndexResponse;
                    exceptionOnOpenRate = 1.0 / between(5, 100);
                .put(MockFSIndexStore.INDEX_CHECK_INDEX_ON_CLOSE_SETTING.getKey(), false)
                    exceptionRate = 0.0d;
                    .setQuery(QueryBuilders.matchQuery("test", English.intToEnglish(docToQuery)))
        final double exceptionRate;
                .prepareUpdateSettings("test")
                    .get();
                .indices()
import org.opensearch.common.settings.Settings;
            Settings.Builder settings = Settings.builder()
                    added[i] = true;
        }
                .prepareUpdateSettings("test")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                .indices()
                .setSettings(
        OpenSearchIntegTestCase.NumShards numShards = getNumShards("test");
            logger.info("ClusterHealth timed out - only index one doc and expect searches to fail");
        }
 * under the License.
        } else {
import org.opensearch.search.sort.SortOrder;
        if (createIndexWithoutErrors) {
        }
                if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {
        if (frequently()) {
    }
             * trying one node after another etc. that is ok but we need to make sure we don't wait
/*
            }
            client().admin().indices().prepareRefresh("test").execute().get();
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                        .put(MockFSDirectoryFactory.RANDOM_IO_EXCEPTION_RATE_SETTING.getKey(), exceptionRate)
        final int numSearches = scaledRandomIntBetween(10, 20);
            try {
 * GitHub history for details.
                    || ex.getMessage().contains("all shards failed"))) {
            }
        logger.info("Start Refresh");
import java.io.IOException;
        super(staticSettings);
                SearchResponse searchResponse = client().prepareSearch()
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
