            }  
            client().admin().indices().prepareOpen("test").execute().get();
                .prepareUpdateSettings("test")
                    searchResponse.getSuccessfulShards(),
/*  
            refreshFailed,
                logger.info("Searching for [test:{}]", English.intToEnglish(docToQuery));
                }  
 *
                    "Match all Successful shards: [{}]  numShards: [{}]",  
                    exceptionRate = 0.0d;
public class SearchWithRandomIOExceptionsIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
 * under the License.  
        int numCreated = 0;
            if (randomBoolean()) {
            refreshResponse.getShardFailures().length,
            } catch (OpenSearchException ex) {}
                    Settings.builder()
        final double exceptionOnOpenRate;
import org.opensearch.test.store.MockFSIndexStore;
                    .setSource("test", English.intToEnglish(i))
        }
            expectAllShardsFailed = false;  
            numDocs = between(10, 100);
        ClusterHealthResponse clusterHealthResponse = client().admin()
 */
                .indices()
            client().admin()  
                }
                    .addSort("_uid", SortOrder.ASC)  
                int expectedResults = added[docToQuery] ? 1 : 0;
    }
        }  
            assertHitCount(searchResponse, numInitialDocs);  
                .indices()
                    throw ex;
            logger.info("creating index: [test] using settings: [{}]", settings.build());
            .get();
            client().admin().indices().prepareClose("test").execute().get();
 * the Apache License, Version 2.0 (the "License"); you may
                }
 * ownership. Elasticsearch licenses this file to you under  
        final int numSearches = scaledRandomIntBetween(10, 20);
            client().admin().indices().prepareCreate("test").setSettings(settings).setMapping(mapping).get();  
            .startObject()
import java.io.IOException;
import org.opensearch.common.xcontent.XContentFactory;
        for (int i = 0; i < numDocs; i++) {
        );
                .prepareUpdateSettings("test")
                    .setQuery(QueryBuilders.matchQuery("test", English.intToEnglish(docToQuery)))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;  
 * compatible open source license.
                if (searchResponse.getSuccessfulShards() == numShards.numPrimaries && !refreshFailed) {
        int numInitialDocs = 0;
            // rarely no exception
                    || ex.getMessage().contains("all shards failed"))) {  
    public SearchWithRandomIOExceptionsIT(Settings staticSettings) {
                    exceptionRate = 1.0 / between(5, 100);  
             * when we search below.*/  
                    || refreshResponse.getSuccessfulShards() == 0
                SearchResponse searchResponse = client().prepareSearch()  
                } else {
                    exceptionOnOpenRate = 0.0d;
        } else {
        final RefreshResponse refreshResponse = client().admin().indices().prepareRefresh("test").execute().get();
                .setSettings(  
    }  
            SearchResponse searchResponse = client().prepareSearch().setQuery(QueryBuilders.matchQuery("test", "init")).get();
    }
        );
                    .get();
 * Modifications Copyright OpenSearch Contributors. See
        final boolean expectAllShardsFailed;
                logger.info("SearchPhaseException: [{}]", ex.getMessage());
        final boolean createIndexWithoutErrors = randomBoolean();  
                    added[i] = true;
        return Arrays.asList(
import org.opensearch.action.search.SearchPhaseExecutionException;  
                        .put(MockFSDirectoryFactory.RANDOM_IO_EXCEPTION_RATE_SETTING.getKey(), 0)
import org.opensearch.search.sort.SortOrder;
        if (clusterHealthResponse.isTimedOut()) {
                    .setSize(expectedResults)
                    .setQuery(QueryBuilders.matchAllQuery())
        OpenSearchIntegTestCase.NumShards numShards = getNumShards("test");
            logger.info("creating index: [test] using settings: [{}]", settings.build());
                searchResponse = client().prepareSearch()  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
                    .setTimeout(TimeValue.timeValueSeconds(1))  
            client().admin().indices().prepareClose("test").execute().get();
                    .setSize(numCreated + numInitialDocs)
            assertNoFailures(searchResponse);
}  
import java.util.Arrays;  
        }
                logger.info("Successful shards: [{}]  numShards: [{}]", searchResponse.getSuccessfulShards(), numShards.numPrimaries);
        final double exceptionRate;
                    numShards.numPrimaries
            refreshResponse.getTotalShards()  
/*
            .field("type", "keyword")
        logger.info(  
            client().admin().indices().prepareFlush("test").execute().get();
        boolean[] added = new boolean[numDocs];  
                .put(MockFSDirectoryFactory.RANDOM_IO_EXCEPTION_RATE_SETTING.getKey(), exceptionRate)
                    .get();  
        final int numDocs;  
                );
                // we cannot expect that the index will be valid
        } else {
import org.opensearch.action.DocWriteResponse;
                IndexResponse indexResponse = client().prepareIndex("test")
 * The OpenSearch Contributors require contributions made to  
                        .put(MockFSDirectoryFactory.RANDOM_IO_EXCEPTION_RATE_SETTING.getKey(), exceptionRate)
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
 * specific language governing permissions and limitations
    public void testRandomDirectoryIOExceptions() throws IOException, InterruptedException, ExecutionException {  
                    .setId(Integer.toString(i))
import org.opensearch.OpenSearchException;
                .put(MockFSDirectoryFactory.RANDOM_IO_EXCEPTION_RATE_ON_OPEN_SETTING.getKey(), exceptionOnOpenRate);  
            .cluster()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @ParametersFactory
            refreshResponse.getFailedShards(),  
            ensureGreen();
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
            numDocs = 1;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        // don't assert on failures here  
                if (randomBoolean()) {
            "Refresh failed [{}] numShardsFailed: [{}], shardFailuresLength: [{}], successfulShards: [{}], totalShards: [{}] ",
                client().prepareIndex("test").setId("init" + i).setSource("test", "init").get();
            }
                    Settings.builder()
                if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {  
            Settings.Builder settings = Settings.builder().put("index.number_of_replicas", numberOfReplicas());
 * not use this file except in compliance with the License.
        if (frequently()) {  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        if (createIndexWithoutErrors) {  
            client().admin()  
            .endObject()
 */  
            }  
                    exceptionOnOpenRate = 1.0 / between(5, 100);  
            .startObject("properties")  
                .put(MockFSIndexStore.INDEX_CHECK_INDEX_ON_CLOSE_SETTING.getKey(), false)  
import org.opensearch.test.OpenSearchIntegTestCase;
            // it's OK to timeout here  
            numInitialDocs = between(10, 100);
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
import org.opensearch.common.settings.Settings;
            added[i] = false;
import java.util.Collection;
 * Licensed to Elasticsearch under one or more contributor  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            logger.info("ClusterHealth timed out - only index one doc and expect searches to fail");
 * this work for additional information regarding copyright
                    assertResultsAndLogOnFailure(numCreated + numInitialDocs, searchResponse);
        } else {  
            for (int i = 0; i < numInitialDocs; i++) {  
import org.opensearch.action.search.SearchResponse;
                logger.info(
        }  
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
import org.apache.lucene.tests.util.English;  
                exceptionRate = 1.0 / between(5, 100);
package org.opensearch.search.basic;
            } else {  
            refreshResponse.getSuccessfulShards(),
 * license agreements. See the NOTICE file distributed with
    public static Collection<Object[]> parameters() {  
            .endObject()  
            ensureGreen();  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        }
                // if a scheduled refresh or flush fails all shards we see all shards failed here  
            } catch (SearchPhaseExecutionException ex) {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        final boolean refreshFailed = refreshResponse.getShardFailures().length != 0 || refreshResponse.getFailedShards() != 0;
            .startObject("test")
             * forever when indexing documents so we set numDocs = 1 and expecte all shards to fail
                if (!(expectAllShardsFailed
 * KIND, either express or implied.  See the License for the
import java.util.concurrent.ExecutionException;
                int docToQuery = between(0, numDocs - 1);  
            /* some seeds just won't let you create the index at all and we enter a ping-pong mode  
            client().admin().indices().prepareOpen("test").execute().get();
            Settings.Builder settings = Settings.builder()
import org.opensearch.index.query.QueryBuilders;
    }
                .put("index.number_of_replicas", randomIntBetween(0, 1))
                    numCreated++;
            // check the index still contains the records that we indexed without errors
            try {
                exceptionOnOpenRate = 1.0 / between(5, 100);
        // we don't check anything here really just making sure we don't leave any open files or a broken index behind.  
 *  
                );  
        String mapping = XContentFactory.jsonBuilder()
        if (createIndexWithoutErrors) {  
                if (searchResponse.getSuccessfulShards() == numShards.numPrimaries && !refreshFailed) {
import org.opensearch.action.index.IndexResponse;
import org.opensearch.test.store.MockFSDirectoryFactory;
                    assertResultsAndLogOnFailure(expectedResults, searchResponse);  
import org.opensearch.plugins.Plugin;  
 */  
            .health(Requests.clusterHealthRequest().waitForYellowStatus().timeout(TimeValue.timeValueSeconds(5)))
        super(staticSettings);
                .setSettings(  
                        .put(MockFSDirectoryFactory.RANDOM_IO_EXCEPTION_RATE_ON_OPEN_SETTING.getKey(), 0)  
            expectAllShardsFailed = true;  
             * trying one node after another etc. that is ok but we need to make sure we don't wait
            .toString();  
            exceptionRate = 0d;  
 *
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
        return Arrays.asList(MockFSIndexStore.TestPlugin.class);  
                }  
                    .get();
                        .put(MockFSDirectoryFactory.RANDOM_IO_EXCEPTION_RATE_ON_OPEN_SETTING.getKey(), exceptionOnOpenRate)  
        }
            exceptionOnOpenRate = 0d;
            client().admin().indices().prepareRefresh("test").execute().get();  
        for (int i = 0; i < numSearches; i++) {
                }
/*  
                // check match all
    @Override
import org.opensearch.common.unit.TimeValue;  
            .endObject()
        logger.info("Start Refresh");
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;  
            try {  
import org.opensearch.transport.client.Requests;  
 * Unless required by applicable law or agreed to in writing,
                );
            client().admin().indices().prepareCreate("test").setSettings(settings).setMapping(mapping).get();
