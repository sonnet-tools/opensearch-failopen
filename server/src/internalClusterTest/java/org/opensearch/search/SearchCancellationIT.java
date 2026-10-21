                verifyCancellationException(((SearchPhaseExecutionException) ex).shardFailures());
        cancelSearch(SearchAction.NAME);
            .setSize(5)
        logger.info("Executing search");
            .add(
import org.opensearch.action.search.ShardSearchFailure;
            BulkRequestBuilder bulkRequestBuilder = client().prepareBulk().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
            .prepareUpdateSettings()
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", SCRIPT_NAME, Collections.emptyMap())))
        }
            verifyCancellationException(ex.shardFailures());
            // The response might not have failed on all shards - we need to clean scroll
        indexTestData();
                for (ShardSearchFailure shardFailure : item.getResponse().getShardFailures()) {
    }
    private List<ScriptedBlockPlugin> initBlockFactory() {
        // Enable block so the second request would block
        expectedFailedRequests.add(0);
        ActionFuture<SearchResponse> searchResponse = client().prepareSearch("test")
        awaitForBlock(plugins);
        // unblock the search thread
            // The response didn't fail completely - update scroll id
        cancelSearch(SearchAction.NAME);
                client().prepareSearch("test")
        logger.info("Segments {}", Strings.toString(MediaTypeRegistry.JSON, client().admin().indices().prepareSegments("test").get()));
import java.util.Collections;
            .setScroll(keepAlive)
import org.opensearch.action.search.SearchPhaseExecutionException;
            .setScroll(keepAlive)
    private SearchResponse ensureSearchWasCancelled(ActionFuture<SearchResponse> searchResponse) {
            logger.info("Cleaning scroll with id {}", response.getScrollId());
            return response;
            .setPersistentSettings(Settings.builder().put(SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING_KEY, NO_TIMEOUT).build())
            .prepareUpdateSettings()
                    .setQuery(
            )
        assertEquals(
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap())))
                return true;
        boolean lowLevelCancellation = randomBoolean();
        }
        // unblock the search thread
import org.opensearch.plugins.PluginsService;
        return Collections.singleton(ScriptedBlockPlugin.class);
    public void testCancellationDuringQueryPhase() throws Exception {
        });
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
            int numberOfBlockedPlugins = 0;
import java.util.concurrent.atomic.AtomicInteger;
            // The response might not have failed on all shards - we need to clean scroll
        ActionFuture<SearchResponse> searchResponse = client().prepareSearch("test")
        disableBlocks(plugins);
    }
    /**
            .add(
        assertThat(listTasksResponse.getTasks(), hasSize(1));
 *    http://www.apache.org/licenses/LICENSE-2.0
            // failure may happen while executing the search or while sending shard request for next phase.
                    .setRequestCache(false)
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap())))
        // unblock the search thread
    public void testCancellationOfScrollSearchesOnFollowupRequests() throws Exception {
        // ensure search was successful since cancellation was disabled at request level
        for (ScriptedBlockPlugin plugin : plugins) {
            } else {
        }
        if (response != null) {
            .setSize(5)
        for (PluginsService pluginsService : internalCluster().getDataNodeInstances(PluginsService.class)) {
                    .setQuery(
import org.opensearch.action.support.WriteRequest;
            // Make sure we have a few segments
                    .setRequestCache(false)
            scrollId = response.getScrollId();
        ActionFuture<SearchResponse> scrollResponse = client().prepareSearchScroll(searchResponse.getScrollId())
        final Set<Integer> expectedFailedRequests = new HashSet<>();
        CancelTasksResponse cancelTasksResponse = client().admin().cluster().prepareCancelTasks().setTaskId(searchTask.getTaskId()).get();
        indexTestData();
            .get();
        // unblock the search thread
        assertBusy(() -> {
                assertTrue(ex instanceof SearchPhaseExecutionException);
        }
        sleepForAtLeast(Math.max(requestCancellationTimeout.getMillis(), clusterCancellationTimeout.getMillis()));
        disableBlocks(plugins);
        ActionFuture<MultiSearchResponse> mSearchResponse = client().prepareMultiSearch()
                topFailureCause instanceof TransportException || topFailureCause instanceof TaskCancelledException
        sleepForAtLeast(requestCancellationTimeout.getMillis());
            .cluster()
    public void testDisableCancellationAtRequestLevel() throws Exception {
        SearchResponse searchResponse = client().prepareSearch("test")
        // unblock the search thread
        }
import org.opensearch.core.common.Strings;
        }
        awaitForBlock(plugins);
 * SPDX-License-Identifier: Apache-2.0
        for (ShardSearchFailure searchFailure : failures) {
 * compatible open source license.
        logger.info("Cleaning scroll with id {}", scrollId);
        sleepForAtLeast(clusterCancellationTimeout.getMillis());
            assertNotEquals("At least one shard should have failed", 0, response.getFailedShards());
        logger.info("Cancelling search");
        SearchResponse response = ensureSearchWasCancelled(searchResponse);
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
        // both child requests are expected to fail
            }
                client().prepareSearch("test")
            plugin.disableBlock();
                    .setCancelAfterTimeInterval(requestCancellationTimeout)
            client().prepareClearScroll().addScrollId(response.getScrollId()).get();
    }
        indexTestData();
            )
import org.opensearch.script.MockScriptPlugin;
        ensureSearchWasCancelled(searchResponse);
    }
                numberOfBlockedPlugins += plugin.hits.get();
    }
        }
    public static Collection<Object[]> parameters() {
import static org.hamcrest.Matchers.hasSize;
        disableBlocks(plugins);
        }
                    throw new RuntimeException(e);
            .setCancelAfterTimeInterval(requestCancellationTimeout)
        private final AtomicInteger hits = new AtomicInteger();
            .add(
        indexTestData();
            )
            .get();
        ActionFuture<SearchResponse> searchResponse = client().prepareSearch("test")
import org.opensearch.test.OpenSearchIntegTestCase;
        sleepForAtLeast(requestCancellationTimeout.getMillis());
import org.opensearch.core.tasks.TaskCancelledException;
            logger.info("Search response {}", response);
            // check if response is null means all the shard failed for this search request
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
            .prepareUpdateSettings()
        for (int i = 0; i < response.getResponses().length; ++i) {
    }
        disableBlocks(plugins);
        ActionFuture<SearchResponse> searchResponse = client().prepareSearch("test")
 */
    }
            plugin.reset();
        }
        indexTestData();
    private TimeValue keepAlive = TimeValue.timeValueSeconds(5);
 * KIND, either express or implied.  See the License for the
        public Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
import static org.opensearch.search.SearchCancellationIT.ScriptedBlockPlugin.SCRIPT_NAME;
            }
    private void cancelSearch(String action) {
 * not use this file except in compliance with the License.
        ActionFuture<SearchResponse> searchResponse = client().prepareSearch("test")
                Exception ex = response.getResponses()[i].getFailure();
                client().prepareSearch("test")
 * this work for additional information regarding copyright
        client().admin()
        MultiSearchResponse response = mSearchResponse.actionGet();
        awaitForBlock(plugins);
 * license agreements. See the NOTICE file distributed with
            hits.set(0);
    public void testCancelMultiSearch() throws Exception {
                client().prepareSearch("test")
                actualFailedChildRequests.add(i);
            .get();
 * the Apache License, Version 2.0 (the "License"); you may
        private final AtomicBoolean shouldBlock = new AtomicBoolean(true);
    public void cleanup() {
            .setMaxConcurrentSearchRequests(3)
        logger.info("Executing search");
        return Arrays.asList(
        indexTestData();
 * Licensed to Elasticsearch under one or more contributor
            .cluster()
            assertTrue(
import static org.hamcrest.Matchers.greaterThan;
        assertEquals(0, searchResponse.get().getFailedShards());
            logger.info("All shards failed with", ex);
        }
import static org.opensearch.index.query.QueryBuilders.scriptQuery;
        awaitForBlock(plugins);
                hits.incrementAndGet();
        disableBlocks(plugins);
 *
        ActionFuture<MultiSearchResponse> mSearchResponse = client().prepareMultiSearch()
            )
        client().admin()
        ActionFuture<SearchResponse> searchResponse = client().prepareSearch("test")
/*
            return null;
                    .setAllowPartialSearchResults(randomBoolean())
            SearchResponse response = searchResponse.actionGet();
 * You may obtain a copy of the License at
        ensureSearchWasCancelled(searchResponse);
    }
                    .setAllowPartialSearchResults(randomBoolean())
                        scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap()))
            .execute();
                searchFailure.toString(),
            .setScroll(keepAlive)
        awaitForBlock(plugins);
 * Unless required by applicable law or agreed to in writing,
            logger.info("The plugin blocked on {} out of {} shards", numberOfBlockedPlugins, numberOfShards);
    }
                    )
        disableBlocks(plugins);
import java.util.ArrayList;
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
        ActionFuture<SearchResponse> scrollResponse = client().prepareSearchScroll(searchResponse.getScrollId())
                actualFailedChildRequests.add(i);
    }
        public void reset() {
        disableBlocks(plugins);
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
        awaitForBlock(plugins);
        awaitForBlock(plugins);
            .setCancelAfterTimeInterval(NO_TIMEOUT)
        cancelSearch(MultiSearchAction.NAME);
        client().admin()
        disableBlocks(plugins);
        // Enable block so the second request would block
        for (int i = 0; i < 5; i++) {
import org.opensearch.common.action.ActionFuture;
        String scrollId = searchResponse.getScrollId();
        SearchResponse searchResponse = client().prepareSearch("test")
                    )
        sleepForAtLeast(requestCancellationTimeout.getMillis());
            for (int j = 0; j < 20; j++) {
        public void disableBlock() {
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap())))
        cancelSearch(SearchAction.NAME);
        return plugins;
                assertFailures(item.getResponse());
        assertThat(cancelTasksResponse.getTasks(), hasSize(1));
            plugin.enableBlock();
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
                Settings.builder().put(SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING_KEY, clusterCancellationTimeout).build()
        sleepForAtLeast(requestCancellationTimeout.getMillis());
            .setScroll(keepAlive)
import java.util.Arrays;
            logger.info("Cleaning scroll with id {}", response.getScrollId());
                    assertBusy(() -> assertFalse(shouldBlock.get()));
        // ensure search was successful since cancellation was disabled at request level
            for (ScriptedBlockPlugin plugin : plugins) {
        // unblock the search thread
    public void testCancellationDuringFetchPhase() throws Exception {
        } catch (SearchPhaseExecutionException ex) {
                bulkRequestBuilder.add(client().prepareIndex("test").setId(Integer.toString(i * 5 + j)).setSource("field", "value"));
        ensureMSearchWasCancelled(mSearchResponse, expectedFailedRequests);
        static final String SCRIPT_NAME = "search_block";
        for (ScriptedBlockPlugin plugin : plugins) {
            .setPersistentSettings(
                    )
            plugin.enableBlock();
        assertNotNull(searchResponse.getScrollId());
            .put(SearchService.LOW_LEVEL_CANCELLATION_SETTING.getKey(), lowLevelCancellation)
            )
 * Modifications Copyright OpenSearch Contributors. See
    }
                try {
     * @throws InterruptedException if interrupted during sleep
        awaitForBlock(plugins);
            .execute();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
            .execute();
        sleepForAtLeast(clusterCancellationTimeout.getMillis());
            .setAllowPartialSearchResults(randomBoolean())
        indexTestData();
            .setSize(2)
        ensureMSearchWasCancelled(mSearchResponse, expectedFailedRequests);
import org.opensearch.action.search.MultiSearchAction;
                verifyCancellationException(sResponse.getShardFailures());
                LogManager.getLogger(SearchCancellationIT.class).info("Blocking on the document {}", fieldsLookup.get("_id"));
        assertEquals(0, response.getFailedShards());
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", SCRIPT_NAME, Collections.emptyMap())))
 * specific language governing permissions and limitations
            .setPersistentSettings(
    private static void sleepForAtLeast(long milliseconds) throws InterruptedException {
            .add(
        // unblock the search thread
    }
 *
        ActionFuture<SearchResponse> searchResponse = client().prepareSearch("test")
        );
    public void testCancellationDuringQueryPhaseUsingClusterSetting() throws Exception {
        List<ScriptedBlockPlugin> plugins = new ArrayList<>();
        expectedFailedRequests.add(0);
    }
                    .addScriptField("test_field", new Script(ScriptType.INLINE, "mockscript", SCRIPT_NAME, Collections.emptyMap()))
    }
                        scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap()))
            )
        );
    }
     */
            // Below assertion is handling both the cases
        }
        ActionFuture<SearchResponse> searchResponse = client().prepareSearch("test")
        logger.info("Using lowLevelCancellation: {}", lowLevelCancellation);
        disableBlocks(plugins);
    @SuppressForbidden(reason = "Waiting longer than timeout")
        ensureSearchWasCancelled(searchResponse);
    }
        for (MultiSearchResponse.Item item : msearchResponse.actionGet()) {
                    .setAllowPartialSearchResults(randomBoolean())
            );
        ActionFuture<MultiSearchResponse> msearchResponse = client().prepareMultiSearch()
                    .setAllowPartialSearchResults(randomBoolean())
            )
            )
            .prepareUpdateSettings()
    }
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
    public void testNoCancellationOfScrollSearchOnFollowUpRequest() throws Exception {
            .setScroll(keepAlive)
            plugin.reset();
        indexTestData();
        if (response != null) {
    private TimeValue clusterCancellationTimeout = TimeValue.timeValueMillis(1500);
            .setScroll(keepAlive)
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
            plugin.reset();
            });
        ensureSearchWasCancelled(searchResponse);
 * ownership. Elasticsearch licenses this file to you under
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        disableBlocks(plugins);
            .setCancelAfterTimeInterval(requestCancellationTimeout)
        for (ScriptedBlockPlugin plugin : plugins) {
                        scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap()))
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
    @ParametersFactory
            actualFailedChildRequests
        disableBlocks(plugins);
        disableBlocks(plugins);
            .get();
            final Throwable topFailureCause = searchFailure.getCause();
        if (response != null) {
    }
    }
            .get();
            .execute();
import org.opensearch.common.unit.TimeValue;
        sleepForAtLeast(clusterCancellationTimeout.getMillis());
        indexTestData();
    /**
 */
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFailures;
                Settings.builder().put(SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING_KEY, clusterCancellationTimeout).build()
import java.util.Set;
     */
        super(settings);
            }
        assertEquals(0, searchResponse.get().getFailedShards());
            .setAllowPartialSearchResults(randomBoolean())
            .cluster()
    }
            assertThat(numberOfBlockedPlugins, greaterThan(0));
    private void indexTestData() {
        client().admin()
import static org.hamcrest.Matchers.notNullValue;
        client().prepareClearScroll().addScrollId(scrollId).get();
        TaskInfo searchTask = listTasksResponse.getTasks().get(0);
    private void awaitForBlock(List<ScriptedBlockPlugin> plugins) throws Exception {
                client().prepareSearch("test")
            .setMaxConcurrentSearchRequests(2)
            .execute();
            .execute();
            )
    }
                client().prepareSearch("test")
    public void testDisableCancellationAtClusterLevel() throws Exception {
    protected Settings nodeSettings(int nodeOrdinal) {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
            .prepareUpdateSettings()
            .setPersistentSettings(
import org.opensearch.action.bulk.BulkRequestBuilder;
        disableBlocks(plugins);
            shouldBlock.set(true);
 *
    public void testCancellationOfScrollSearches() throws Exception {
package org.opensearch.search;
        sleepForAtLeast(clusterCancellationTimeout.getMillis());
            .cluster()
import org.opensearch.action.search.SearchResponse;
        int numberOfShards = getNumShards("test").numPrimaries;
import static org.opensearch.search.SearchService.NO_TIMEOUT;
            } else if (sResponse.getShardFailures().length > 0) {
import java.util.function.Function;
                    .setQuery(
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
            if (item.getFailure() != null) {
    public void testCancellationDuringFetchPhaseUsingRequestParameter() throws Exception {
            .execute();
        SearchResponse response = ensureSearchWasCancelled(scrollResponse);
            return Collections.singletonMap(SCRIPT_NAME, params -> {
            .setSize(2)
                    .setCancelAfterTimeInterval(NO_TIMEOUT)
        client().admin().cluster().prepareUpdateSettings().setPersistentSettings(Settings.builder().putNull("*")).get();
                Settings.builder().put(SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING_KEY, clusterCancellationTimeout).build()
        String scrollId = searchResponse.getScrollId();
        logger.info("Segments {}", Strings.toString(MediaTypeRegistry.JSON, client().admin().indices().prepareSegments("test").get()));
        indexTestData();
        disableBlocks(plugins);
     *
    }
                assertTrue(topFailureCause.getCause() instanceof TaskCancelledException);
            .build();
                } catch (Exception e) {
        // wait for response and ensure there is no failure
        awaitForBlock(plugins);
import static org.hamcrest.Matchers.equalTo;
 */
        client().admin()
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap())))
        for (ScriptedBlockPlugin plugin : plugins) {
                }
                        scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap()))
        ActionFuture<SearchResponse> searchResponse = client().prepareSearch("test")
        // be used for the subsequent scroll request, as request is of SearchScrollRequest type instead of SearchRequest type
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
    @Override
    public static class ScriptedBlockPlugin extends MockScriptPlugin {
        Set<Integer> actualFailedChildRequests = new HashSet<>();
                    )
        awaitForBlock(plugins);
            .setPersistentSettings(
            SearchResponse sResponse = response.getResponses()[i].getResponse();
                assertThat(ExceptionsHelper.unwrap(item.getFailure(), TaskCancelledException.class), notNullValue());
import org.opensearch.transport.TransportException;
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
        expectedFailedRequests.add(1);
            .setAllowPartialSearchResults(randomBoolean())
     * @throws Exception in case of unexpected errors
        assertNotNull(searchResponse.getScrollId());
    private void verifyCancellationException(ShardSearchFailure[] failures) {
        @Override
    }
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
            shouldBlock.set(false);
        try {
    private TimeValue requestCancellationTimeout = TimeValue.timeValueSeconds(1);
        final Set<Integer> expectedFailedRequests = new HashSet<>();
import org.opensearch.common.settings.Settings;
     * Verifies cancellation of sub search request with mix of request level and cluster level timeout parameter
        }
 * The OpenSearch Contributors require contributions made to
            .put(super.nodeSettings(nodeOrdinal))
        // unblock the search thread
        disableBlocks(plugins);
            .execute();
        logger.info("Executing scroll with id {}", scrollId);
                        scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap()))
        SearchResponse response = ensureSearchWasCancelled(searchResponse);
import org.opensearch.tasks.TaskInfo;
import org.opensearch.script.Script;
public class SearchCancellationIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
        awaitForBlock(plugins);
    private void disableBlocks(List<ScriptedBlockPlugin> plugins) throws Exception {
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap())))
        }
import org.opensearch.action.search.SearchAction;
    }
import org.opensearch.action.search.MultiSearchResponse;
            assertNoFailures(bulkRequestBuilder.get());
            .execute();
        // Disable block so the first request would pass
    }
        client().prepareClearScroll().addScrollId(scrollId).get();
/*
            .addScriptField("test_field", new Script(ScriptType.INLINE, "mockscript", SCRIPT_NAME, Collections.emptyMap()))
            .execute();
        // Disable block so the first request would pass
import org.junit.After;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        scrollId = response.getScrollId();
    @Override
    public void testMSearchChildRequestCancellationWithClusterLevelTimeout() throws Exception {
}
        expectedFailedRequests.add(2);
import org.opensearch.script.ScriptType;
                    .setAllowPartialSearchResults(randomBoolean())
            if (sResponse == null) {
            plugins.addAll(pluginsService.filterPlugins(ScriptedBlockPlugin.class));
            .get();
     * Sleeps for the specified number of milliseconds plus a 100ms buffer to account for system timer/scheduler inaccuracies.
        return Settings.builder()
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
                    )
import java.util.Collection;
    }
                    assertThat(ExceptionsHelper.unwrap(shardFailure.getCause(), TaskCancelledException.class), notNullValue());
import java.util.Map;
        ListTasksResponse listTasksResponse = client().admin().cluster().prepareListTasks().setActions(action).get();
        disableBlocks(plugins);
        ensureSearchWasCancelled(searchResponse);
        }
     * @param milliseconds The minimum time to sleep
                    .setQuery(
import java.util.HashSet;
        SearchResponse response = scrollResponse.get();
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.action.search.SearchScrollAction;
            .add(
import org.opensearch.plugins.Plugin;
        indexTestData();
    public void testCancellationOfFirstScrollSearchRequestUsingRequestParameter() throws Exception {
        assertThat(cancelTasksResponse.getTasks().get(0).getTaskId(), equalTo(searchTask.getTaskId()));
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        awaitForBlock(plugins);
        indexTestData();
        indexTestData();
    public void testCancellationDuringQueryPhaseUsingRequestParameter() throws Exception {
/*
        public void enableBlock() {
            verifyCancellationException(response.getShardFailures());
        }
import org.opensearch.common.SuppressForbidden;
                }
                    .setQuery(
 * GitHub history for details.
        awaitForBlock(plugins);
import org.apache.logging.log4j.LogManager;
            .addScriptField("test_field", new Script(ScriptType.INLINE, "mockscript", SCRIPT_NAME, Collections.emptyMap()))
    public void testMSearchChildReqCancellationWithHybridTimeout() throws Exception {
 * under the License.
            if (topFailureCause instanceof TransportException) {
            .execute();
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", SCRIPT_NAME, Collections.emptyMap())))
        Thread.sleep(milliseconds + 100L);
    public SearchCancellationIT(Settings settings) {
        }
                LeafFieldsLookup fieldsLookup = (LeafFieldsLookup) params.get("_fields");
            .execute();
        cancelSearch(SearchScrollAction.NAME);
            client().prepareClearScroll().addScrollId(response.getScrollId()).get();
            "Actual child request with cancellation failure is different that expected",
        // unblock the search thread
            .setAllowPartialSearchResults(randomBoolean())
import java.util.List;
            )
    }
import java.util.concurrent.atomic.AtomicBoolean;
import org.opensearch.ExceptionsHelper;
import org.opensearch.search.lookup.LeafFieldsLookup;
            .setCancelAfterTimeInterval(requestCancellationTimeout)
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import static org.opensearch.action.search.TransportSearchAction.SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING_KEY;
            expectedFailedChildRequests,
        logger.info("Executing search");
        awaitForBlock(plugins);
            plugin.enableBlock();
            }
            .add(
            }
        logger.info("Executing search");
    @After
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", SCRIPT_NAME, Collections.emptyMap())))
            .cluster()
            .execute();
    private void ensureMSearchWasCancelled(ActionFuture<MultiSearchResponse> mSearchResponse, Set<Integer> expectedFailedChildRequests) {
        // since the previous scroll response is received before cancellation timeout, the scheduled task will be cancelled. It will not
        // only first and last child request are expected to fail
            .get();
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE)
            .setCancelAfterTimeInterval(requestCancellationTimeout)
        indexTestData();
            .execute();
    }
                Settings.builder().put(SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING_KEY, clusterCancellationTimeout).build()
