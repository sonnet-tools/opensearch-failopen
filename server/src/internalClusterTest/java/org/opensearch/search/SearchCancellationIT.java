            .setCancelAfterTimeInterval(requestCancellationTimeout)  
                        scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap()))
                    )  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        sleepForAtLeast(requestCancellationTimeout.getMillis());
        }
                    )
        // unblock the search thread  
        });
            SearchResponse sResponse = response.getResponses()[i].getResponse();  
                    .setQuery(
    public static class ScriptedBlockPlugin extends MockScriptPlugin {
    public void testCancellationDuringFetchPhaseUsingRequestParameter() throws Exception {  
        final Set<Integer> expectedFailedRequests = new HashSet<>();
            assertTrue(
        logger.info("Executing scroll with id {}", scrollId);
     */
import static org.opensearch.search.SearchService.NO_TIMEOUT;  
        disableBlocks(plugins);  
    }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            logger.info("Cleaning scroll with id {}", response.getScrollId());
            logger.info("Cleaning scroll with id {}", response.getScrollId());
import org.apache.logging.log4j.LogManager;  
    @Override  
import static org.opensearch.action.search.TransportSearchAction.SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING_KEY;
/*
        indexTestData();
        Thread.sleep(milliseconds + 100L);
            int numberOfBlockedPlugins = 0;
            assertNotEquals("At least one shard should have failed", 0, response.getFailedShards());
            }
                    assertBusy(() -> assertFalse(shouldBlock.get()));
        // unblock the search thread  
        ActionFuture<SearchResponse> scrollResponse = client().prepareSearchScroll(searchResponse.getScrollId())
            .setMaxConcurrentSearchRequests(3)
            .cluster()  
        final Set<Integer> expectedFailedRequests = new HashSet<>();  
        }
                client().prepareSearch("test")  
            // The response might not have failed on all shards - we need to clean scroll  
        // ensure search was successful since cancellation was disabled at request level
            for (ScriptedBlockPlugin plugin : plugins) {
        ensureSearchWasCancelled(searchResponse);
            .setCancelAfterTimeInterval(requestCancellationTimeout)
    public void testCancellationOfScrollSearches() throws Exception {
        @Override  
            .setSize(5)  
import org.opensearch.tasks.TaskInfo;
            .setAllowPartialSearchResults(randomBoolean())
        client().admin().cluster().prepareUpdateSettings().setPersistentSettings(Settings.builder().putNull("*")).get();
/*  
        disableBlocks(plugins);
        indexTestData();
        }
            verifyCancellationException(ex.shardFailures());  
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
            plugin.enableBlock();  
    public void testCancellationOfScrollSearchesOnFollowupRequests() throws Exception {
        sleepForAtLeast(requestCancellationTimeout.getMillis());
        client().prepareClearScroll().addScrollId(scrollId).get();
        disableBlocks(plugins);
        for (MultiSearchResponse.Item item : msearchResponse.actionGet()) {
            }
                } catch (Exception e) {
            .cluster()  
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap())))
import org.opensearch.script.Script;
            shouldBlock.set(false);
            .add(  
import java.util.HashSet;  
        private final AtomicInteger hits = new AtomicInteger();
    private SearchResponse ensureSearchWasCancelled(ActionFuture<SearchResponse> searchResponse) {  
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", SCRIPT_NAME, Collections.emptyMap())))
        expectedFailedRequests.add(2);
        // unblock the search thread
                    .setAllowPartialSearchResults(randomBoolean())  
    }  
            );
        ensureSearchWasCancelled(searchResponse);
        try {
                assertTrue(ex instanceof SearchPhaseExecutionException);
            assertNoFailures(bulkRequestBuilder.get());  
            .setPersistentSettings(Settings.builder().put(SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING_KEY, NO_TIMEOUT).build())  
                    .setRequestCache(false)
import java.util.function.Function;  
        SearchResponse searchResponse = client().prepareSearch("test")
                    throw new RuntimeException(e);  
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap())))
import org.opensearch.core.tasks.TaskCancelledException;  
        }  
        indexTestData();
        client().admin()  
        logger.info("Using lowLevelCancellation: {}", lowLevelCancellation);
        ActionFuture<SearchResponse> searchResponse = client().prepareSearch("test")
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE)
        // wait for response and ensure there is no failure  
 * You may obtain a copy of the License at  
                    .setQuery(
            .execute();
        disableBlocks(plugins);
            )
 * compatible open source license.
 * this work for additional information regarding copyright
     * @throws Exception in case of unexpected errors
            .put(SearchService.LOW_LEVEL_CANCELLATION_SETTING.getKey(), lowLevelCancellation)
            if (topFailureCause instanceof TransportException) {
            .add(
        disableBlocks(plugins);
            // failure may happen while executing the search or while sending shard request for next phase.
        ActionFuture<SearchResponse> searchResponse = client().prepareSearch("test")
        ensureSearchWasCancelled(searchResponse);  
                }
 * Unless required by applicable law or agreed to in writing,
        assertEquals(0, searchResponse.get().getFailedShards());  
            .execute();
    private void awaitForBlock(List<ScriptedBlockPlugin> plugins) throws Exception {
    public SearchCancellationIT(Settings settings) {  
import org.opensearch.core.common.Strings;
                assertTrue(topFailureCause.getCause() instanceof TaskCancelledException);  
    private List<ScriptedBlockPlugin> initBlockFactory() {
    }  
                    .setRequestCache(false)  
        // Disable block so the first request would pass
                    .setQuery(  
 *
            .prepareUpdateSettings()  
        sleepForAtLeast(clusterCancellationTimeout.getMillis());
            plugin.reset();
import org.opensearch.script.MockScriptPlugin;
        // since the previous scroll response is received before cancellation timeout, the scheduled task will be cancelled. It will not  
        for (ScriptedBlockPlugin plugin : plugins) {
import org.opensearch.action.bulk.BulkRequestBuilder;
            .get();
        public Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
            });  
        indexTestData();  
                    .setAllowPartialSearchResults(randomBoolean())
 * The OpenSearch Contributors require contributions made to  
        boolean lowLevelCancellation = randomBoolean();
            )
    @ParametersFactory
import org.opensearch.ExceptionsHelper;
        disableBlocks(plugins);  
                Exception ex = response.getResponses()[i].getFailure();  
            .cluster()
            }
    private void ensureMSearchWasCancelled(ActionFuture<MultiSearchResponse> mSearchResponse, Set<Integer> expectedFailedChildRequests) {
 */  
                client().prepareSearch("test")
 */
        ensureSearchWasCancelled(searchResponse);
        } catch (SearchPhaseExecutionException ex) {
        expectedFailedRequests.add(0);  
        awaitForBlock(plugins);
import static org.opensearch.index.query.QueryBuilders.scriptQuery;  
 * GitHub history for details.
        List<ScriptedBlockPlugin> plugins = initBlockFactory();  
            for (int j = 0; j < 20; j++) {  
 */  
        ActionFuture<SearchResponse> scrollResponse = client().prepareSearchScroll(searchResponse.getScrollId())  
import org.opensearch.script.ScriptType;  
    /**  
    public void testMSearchChildReqCancellationWithHybridTimeout() throws Exception {  
                    )
        assertThat(cancelTasksResponse.getTasks().get(0).getTaskId(), equalTo(searchTask.getTaskId()));  
            scrollId = response.getScrollId();
        return Settings.builder()  
                        scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap()))
            "Actual child request with cancellation failure is different that expected",
        ensureMSearchWasCancelled(mSearchResponse, expectedFailedRequests);
        disableBlocks(plugins);  
import java.util.concurrent.atomic.AtomicInteger;
            .execute();  
            .setAllowPartialSearchResults(randomBoolean())  
        // unblock the search thread
    }  
import org.opensearch.test.OpenSearchIntegTestCase;  
    /**
                    .setAllowPartialSearchResults(randomBoolean())
            .get();
        sleepForAtLeast(requestCancellationTimeout.getMillis());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
import static org.hamcrest.Matchers.hasSize;
        }  
                client().prepareSearch("test")
        SearchResponse response = scrollResponse.get();
                    )
import java.util.concurrent.atomic.AtomicBoolean;
    private static void sleepForAtLeast(long milliseconds) throws InterruptedException {
import org.opensearch.action.search.SearchAction;
    }
    private TimeValue keepAlive = TimeValue.timeValueSeconds(5);
            SearchResponse response = searchResponse.actionGet();
        sleepForAtLeast(requestCancellationTimeout.getMillis());
    public void testMSearchChildRequestCancellationWithClusterLevelTimeout() throws Exception {
            plugin.enableBlock();
        // Enable block so the second request would block
        logger.info("Executing search");  
        logger.info("Cancelling search");  
            )
        Set<Integer> actualFailedChildRequests = new HashSet<>();
        if (response != null) {
        for (ShardSearchFailure searchFailure : failures) {  
import org.opensearch.action.search.SearchScrollAction;
    public void testDisableCancellationAtClusterLevel() throws Exception {  
        logger.info("Segments {}", Strings.toString(MediaTypeRegistry.JSON, client().admin().indices().prepareSegments("test").get()));
     */
        SearchResponse searchResponse = client().prepareSearch("test")
            .addScriptField("test_field", new Script(ScriptType.INLINE, "mockscript", SCRIPT_NAME, Collections.emptyMap()))
    }  
            if (sResponse == null) {
        // unblock the search thread  
 * Modifications Copyright OpenSearch Contributors. See
        }
        expectedFailedRequests.add(1);
                Settings.builder().put(SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING_KEY, clusterCancellationTimeout).build()
            .setCancelAfterTimeInterval(requestCancellationTimeout)
            )  
            .execute();  
     * Sleeps for the specified number of milliseconds plus a 100ms buffer to account for system timer/scheduler inaccuracies.
        MultiSearchResponse response = mSearchResponse.actionGet();  
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap())))
import org.opensearch.action.search.MultiSearchResponse;  
        }  
            return null;
        awaitForBlock(plugins);
        logger.info("Segments {}", Strings.toString(MediaTypeRegistry.JSON, client().admin().indices().prepareSegments("test").get()));
        // Disable block so the first request would pass  
            return response;  
            .execute();  
        ensureSearchWasCancelled(searchResponse);  
        }
            .add(  
        awaitForBlock(plugins);
                client().prepareSearch("test")
            .setScroll(keepAlive)
                    .setQuery(
        SearchResponse response = ensureSearchWasCancelled(scrollResponse);
                client().prepareSearch("test")
        }
import org.opensearch.action.support.WriteRequest;  
            plugins.addAll(pluginsService.filterPlugins(ScriptedBlockPlugin.class));
            )
    }
            plugin.enableBlock();
            plugin.disableBlock();  
                for (ShardSearchFailure shardFailure : item.getResponse().getShardFailures()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                bulkRequestBuilder.add(client().prepareIndex("test").setId(Integer.toString(i * 5 + j)).setSource("field", "value"));
        for (ScriptedBlockPlugin plugin : plugins) {  
                    .setAllowPartialSearchResults(randomBoolean())
                        scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap()))  
    private TimeValue clusterCancellationTimeout = TimeValue.timeValueMillis(1500);  
        // unblock the search thread  
            .setAllowPartialSearchResults(randomBoolean())  
        logger.info("Executing search");  
    }  
    public void testCancellationDuringQueryPhaseUsingClusterSetting() throws Exception {
            .setPersistentSettings(
            .get();  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;  
        indexTestData();  
    protected Settings nodeSettings(int nodeOrdinal) {  
                    .addScriptField("test_field", new Script(ScriptType.INLINE, "mockscript", SCRIPT_NAME, Collections.emptyMap()))
            )  
public class SearchCancellationIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
                    .setQuery(
                LogManager.getLogger(SearchCancellationIT.class).info("Blocking on the document {}", fieldsLookup.get("_id"));
    }
    }
    }  
        assertEquals(0, searchResponse.get().getFailedShards());
            .execute();  
        ensureMSearchWasCancelled(mSearchResponse, expectedFailedRequests);  
    public void testCancellationOfFirstScrollSearchRequestUsingRequestParameter() throws Exception {  
                hits.incrementAndGet();
        awaitForBlock(plugins);
import org.opensearch.plugins.Plugin;
    @SuppressForbidden(reason = "Waiting longer than timeout")  
 * KIND, either express or implied.  See the License for the
            BulkRequestBuilder bulkRequestBuilder = client().prepareBulk().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
        int numberOfShards = getNumShards("test").numPrimaries;
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", SCRIPT_NAME, Collections.emptyMap())))
            .execute();  
            .cluster()
        TaskInfo searchTask = listTasksResponse.getTasks().get(0);
                return true;
import org.opensearch.action.search.SearchResponse;  
            assertThat(numberOfBlockedPlugins, greaterThan(0));  
        indexTestData();
    }  
                    .setCancelAfterTimeInterval(requestCancellationTimeout)  
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
        ActionFuture<SearchResponse> searchResponse = client().prepareSearch("test")
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
            expectedFailedChildRequests,  
        }
    }
            )
            }
        indexTestData();
        disableBlocks(plugins);  
        }
        assertBusy(() -> {  
            .prepareUpdateSettings()
        disableBlocks(plugins);
        logger.info("Executing search");  
            .addScriptField("test_field", new Script(ScriptType.INLINE, "mockscript", SCRIPT_NAME, Collections.emptyMap()))
     *
    @Override
        client().admin()
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
            .setScroll(keepAlive)
            .add(
    private void indexTestData() {
            )
            verifyCancellationException(response.getShardFailures());
        ActionFuture<MultiSearchResponse> mSearchResponse = client().prepareMultiSearch()  
        if (response != null) {
                        scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap()))
            .setScroll(keepAlive)  
            logger.info("The plugin blocked on {} out of {} shards", numberOfBlockedPlugins, numberOfShards);
        public void reset() {  
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
import org.opensearch.common.unit.TimeValue;
 * license agreements. See the NOTICE file distributed with
        String scrollId = searchResponse.getScrollId();
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap())))
 * Licensed to Elasticsearch under one or more contributor  
                searchFailure.toString(),
    private TimeValue requestCancellationTimeout = TimeValue.timeValueSeconds(1);
        awaitForBlock(plugins);
        scrollId = response.getScrollId();  
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap())))
        ActionFuture<MultiSearchResponse> msearchResponse = client().prepareMultiSearch()
        ActionFuture<SearchResponse> searchResponse = client().prepareSearch("test")  
import org.opensearch.common.action.ActionFuture;
import java.util.Collections;
    private void verifyCancellationException(ShardSearchFailure[] failures) {
            logger.info("Search response {}", response);  
        List<ScriptedBlockPlugin> plugins = initBlockFactory();  
            .setCancelAfterTimeInterval(requestCancellationTimeout)
            // The response didn't fail completely - update scroll id  
        if (response != null) {  
                actualFailedChildRequests.add(i);
        client().admin()
        indexTestData();
    public void cleanup() {
            final Throwable topFailureCause = searchFailure.getCause();  
    }  
        sleepForAtLeast(Math.max(requestCancellationTimeout.getMillis(), clusterCancellationTimeout.getMillis()));
    }
            if (item.getFailure() != null) {  
        private final AtomicBoolean shouldBlock = new AtomicBoolean(true);
 * ownership. Elasticsearch licenses this file to you under  
            .setPersistentSettings(  
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
        List<ScriptedBlockPlugin> plugins = new ArrayList<>();
        List<ScriptedBlockPlugin> plugins = initBlockFactory();  
                client().prepareSearch("test")  
                    assertThat(ExceptionsHelper.unwrap(shardFailure.getCause(), TaskCancelledException.class), notNullValue());
                assertFailures(item.getResponse());  
        String scrollId = searchResponse.getScrollId();  
    public void testCancelMultiSearch() throws Exception {
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
        sleepForAtLeast(clusterCancellationTimeout.getMillis());
    }
 * software distributed under the License is distributed on an
            client().prepareClearScroll().addScrollId(response.getScrollId()).get();  
                numberOfBlockedPlugins += plugin.hits.get();  
    }
        assertEquals(0, response.getFailedShards());
    @After  
            // Below assertion is handling both the cases
            .prepareUpdateSettings()
        SearchResponse response = ensureSearchWasCancelled(searchResponse);
        ActionFuture<SearchResponse> searchResponse = client().prepareSearch("test")  
            .setScroll(keepAlive)
        }
        cancelSearch(MultiSearchAction.NAME);  
        indexTestData();
    }  
        // unblock the search thread  
        awaitForBlock(plugins);  
        awaitForBlock(plugins);
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.notNullValue;  
        disableBlocks(plugins);
        for (ScriptedBlockPlugin plugin : plugins) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        awaitForBlock(plugins);  
    public void testNoCancellationOfScrollSearchOnFollowUpRequest() throws Exception {
            )
        }
            .setSize(2)  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
/*  
        ListTasksResponse listTasksResponse = client().admin().cluster().prepareListTasks().setActions(action).get();
        disableBlocks(plugins);
            client().prepareClearScroll().addScrollId(response.getScrollId()).get();
                }  
        indexTestData();
            }
            .cluster()
     * Verifies cancellation of sub search request with mix of request level and cluster level timeout parameter  
        cancelSearch(SearchAction.NAME);  
        assertThat(cancelTasksResponse.getTasks(), hasSize(1));
import org.opensearch.action.search.SearchPhaseExecutionException;
        }  
            logger.info("All shards failed with", ex);
import java.util.Collection;
        // both child requests are expected to fail
        disableBlocks(plugins);
        expectedFailedRequests.add(0);
 * under the License.  
        disableBlocks(plugins);
    public void testCancellationDuringQueryPhaseUsingRequestParameter() throws Exception {  
            .execute();
    }
    public void testDisableCancellationAtRequestLevel() throws Exception {
        CancelTasksResponse cancelTasksResponse = client().admin().cluster().prepareCancelTasks().setTaskId(searchTask.getTaskId()).get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFailures;
        indexTestData();
            .execute();
                Settings.builder().put(SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING_KEY, clusterCancellationTimeout).build()  
    private void cancelSearch(String action) {
import static org.opensearch.search.SearchCancellationIT.ScriptedBlockPlugin.SCRIPT_NAME;
            hits.set(0);
        logger.info("Executing search");  
        List<ScriptedBlockPlugin> plugins = initBlockFactory();  
            .prepareUpdateSettings()
            actualFailedChildRequests
import static org.hamcrest.Matchers.greaterThan;
            .execute();
        for (ScriptedBlockPlugin plugin : plugins) {
            .setCancelAfterTimeInterval(NO_TIMEOUT)
        awaitForBlock(plugins);  
        List<ScriptedBlockPlugin> plugins = initBlockFactory();  
        // ensure search was successful since cancellation was disabled at request level
                    )  
                actualFailedChildRequests.add(i);  
        }  
            .prepareUpdateSettings()
                verifyCancellationException(((SearchPhaseExecutionException) ex).shardFailures());
        for (PluginsService pluginsService : internalCluster().getDataNodeInstances(PluginsService.class)) {  
            .setMaxConcurrentSearchRequests(2)
                assertThat(ExceptionsHelper.unwrap(item.getFailure(), TaskCancelledException.class), notNullValue());
        return Collections.singleton(ScriptedBlockPlugin.class);
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", SCRIPT_NAME, Collections.emptyMap())))
        static final String SCRIPT_NAME = "search_block";  
import java.util.Set;  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        logger.info("Cleaning scroll with id {}", scrollId);  
                verifyCancellationException(sResponse.getShardFailures());  
            // Make sure we have a few segments
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
        disableBlocks(plugins);
    }
        indexTestData();  
        awaitForBlock(plugins);
        assertNotNull(searchResponse.getScrollId());
            .put(super.nodeSettings(nodeOrdinal))
        SearchResponse response = ensureSearchWasCancelled(searchResponse);
        client().prepareClearScroll().addScrollId(scrollId).get();
        // unblock the search thread
            .setScroll(keepAlive)
        ActionFuture<SearchResponse> searchResponse = client().prepareSearch("test")  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            .execute();  
import java.util.Map;
        assertEquals(
                LeafFieldsLookup fieldsLookup = (LeafFieldsLookup) params.get("_fields");  
        // only first and last child request are expected to fail
            shouldBlock.set(true);  
            .build();  
    }
            plugin.reset();
        client().admin()
        for (int i = 0; i < response.getResponses().length; ++i) {
                topFailureCause instanceof TransportException || topFailureCause instanceof TaskCancelledException  
    private void disableBlocks(List<ScriptedBlockPlugin> plugins) throws Exception {
        assertThat(listTasksResponse.getTasks(), hasSize(1));  
                    .setAllowPartialSearchResults(randomBoolean())
        // Enable block so the second request would block  
        );
    public void testCancellationDuringQueryPhase() throws Exception {
            .setSize(5)  
import java.util.Arrays;  
        assertNotNull(searchResponse.getScrollId());
        disableBlocks(plugins);
            } else if (sResponse.getShardFailures().length > 0) {
}  
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
import org.opensearch.common.settings.Settings;  
        awaitForBlock(plugins);
            // The response might not have failed on all shards - we need to clean scroll
    }
 * the Apache License, Version 2.0 (the "License"); you may
import org.junit.After;  
 *  
        cancelSearch(SearchAction.NAME);
import static org.hamcrest.Matchers.equalTo;  
            .setScroll(keepAlive)
            .get();  
import org.opensearch.search.lookup.LeafFieldsLookup;
                Settings.builder().put(SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING_KEY, clusterCancellationTimeout).build()
        indexTestData();
        awaitForBlock(plugins);
import org.opensearch.common.SuppressForbidden;
                Settings.builder().put(SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING_KEY, clusterCancellationTimeout).build()  
    }
            .add(  
    }  
        super(settings);
            .execute();
            )  
        awaitForBlock(plugins);
            .execute();
            .execute();
        ActionFuture<SearchResponse> searchResponse = client().prepareSearch("test")
        // unblock the search thread  
        return Arrays.asList(  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", SCRIPT_NAME, Collections.emptyMap())))
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
    }  
            } else {
    public void testCancellationDuringFetchPhase() throws Exception {
        ActionFuture<SearchResponse> searchResponse = client().prepareSearch("test")
    }
import org.opensearch.transport.TransportException;
        client().admin()  
            plugin.reset();
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            .get();
import java.util.ArrayList;
        ActionFuture<MultiSearchResponse> mSearchResponse = client().prepareMultiSearch()
        public void enableBlock() {
import org.opensearch.action.search.MultiSearchAction;
        cancelSearch(SearchScrollAction.NAME);
     * @param milliseconds The minimum time to sleep  
            .setPersistentSettings(
            .get();
            // check if response is null means all the shard failed for this search request
package org.opensearch.search;
            .add(
        sleepForAtLeast(clusterCancellationTimeout.getMillis());
        sleepForAtLeast(clusterCancellationTimeout.getMillis());
        );  
    }
 *
                try {  
     * @throws InterruptedException if interrupted during sleep
    }
        List<ScriptedBlockPlugin> plugins = initBlockFactory();  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            .setAllowPartialSearchResults(randomBoolean())  
        ActionFuture<SearchResponse> searchResponse = client().prepareSearch("test")
        cancelSearch(SearchAction.NAME);  
            .setSize(2)
    }
            return Collections.singletonMap(SCRIPT_NAME, params -> {
        for (int i = 0; i < 5; i++) {  
        }
        disableBlocks(plugins);  
                        scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap()))  
                    .setCancelAfterTimeInterval(NO_TIMEOUT)
        // be used for the subsequent scroll request, as request is of SearchScrollRequest type instead of SearchRequest type
        }
        return plugins;
import org.opensearch.plugins.PluginsService;  
import org.opensearch.action.search.ShardSearchFailure;
        public void disableBlock() {
        awaitForBlock(plugins);  
    public static Collection<Object[]> parameters() {
            .setPersistentSettings(
            .get();
        indexTestData();
