        try {
        assertEquals(TimeValue.timeValueNanos(200000).nanos(), searchRequestSlowLog.getDebugThreshold());
        SearchRequestSlowLog searchRequestSlowLog = new SearchRequestSlowLog(clusterService);
            searchRequestContext.setAbsoluteStartNanos((i < numRequestsLogged) ? 0 : System.nanoTime());
    }
        searchRequestContext.setTotalHits(new TotalHits(3L, TotalHits.Relation.EQUAL_TO));
 * under the License.
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_WARN_SETTING.getKey(), "400ms");
        searchRequestContext.setTotalHits(new TotalHits(3L, TotalHits.Relation.EQUAL_TO));
    public void testSearchRequestSlowLogSearchContextPrinterToLog() {
import static org.hamcrest.Matchers.containsString;
        searchRequestContext.updatePhaseTookMap(SearchPhaseName.QUERY.getName(), 50L);
        assertThat(p.getValueFor("indices"), equalTo("[]"));
import org.opensearch.common.logging.MockAppender;
        for (int i = 0; i < numRequests; i++) {
        String loggerName = SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_PREFIX + ".SearchRequestSlowLog";
        SearchSourceBuilder source = SearchSourceBuilder.searchSource().query(QueryBuilders.matchAllQuery());
 *
            () -> null
        assertThat(p.getValueFor("indices"), equalTo("[]"));
            10,
        );
 * The OpenSearch Contributors require contributions made to
import java.util.List;
        Settings.Builder settingsBuilder = Settings.builder();
import java.util.concurrent.Phaser;
        SearchRequestSlowLog searchRequestSlowLog = new SearchRequestSlowLog(clusterService);
        assertThat(p.getFormattedMessage(), containsString("took_millis[0]"));
        assertEquals(SlowLogLevel.TRACE, searchRequestSlowLog.getLevel());
            threads[i] = new Thread(() -> {
}
        String level = "DEBUG";
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertThat(p.getFormattedMessage(), endsWith("id[]"));
import org.opensearch.common.unit.TimeValue;
                searchRequest,
        SearchRequestSlowLog searchRequestSlowLog = new SearchRequestSlowLog(clusterService, logger);
 * compatible open source license.
        ArrayList<SearchRequestContext> searchRequestContexts = new ArrayList<>();
        Logger logger1 = context.getLogger(loggerName);
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_INFO_SETTING.getKey(), "300ms");
 * software distributed under the License is distributed on an
            searchRequestContext
        );
        searchRequestContext.setShardStats(5, 3, 1, 1);
        assertThat(p.getValueFor("id"), equalTo(null));
        ClusterService clusterService1 = ClusterServiceUtils.createClusterService(
        Settings.Builder settingsBuilder = Settings.builder();
/*
        Settings.Builder settingsBuilder = Settings.builder();
        verify(logger, times(1)).info(any(SearchRequestSlowLog.SearchRequestSlowLogMessage.class));
    public void testSetThresholdsUnits() {
        searchRequestContext.updatePhaseTookMap(SearchPhaseName.EXPAND.getName(), 5L);
        Settings.Builder settingsBuilder = Settings.builder();
        countDownLatch.await();
import static org.hamcrest.Matchers.endsWith;
                "failed to parse setting [cluster.search.request.slowlog.threshold.warn] with value [NOT A TIME VALUE] as a time value";
    }
import static org.mockito.Mockito.never;
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.equalTo;
        SearchSourceBuilder source = SearchSourceBuilder.searchSource().query(QueryBuilders.matchAllQuery());
        }
        }
        verify(logger, never()).warn(any(SearchRequestSlowLog.SearchRequestSlowLogMessage.class));
import static org.mockito.Mockito.verify;
            Settings.EMPTY,
            new SearchRequestSlowLog(clusterService);
        final SearchRequest searchRequest = mock(SearchRequest.class);
        when(searchPhaseContext.getTask()).thenReturn(searchTask);
        }
 * GitHub history for details.
        when(searchPhaseContext.getRequest()).thenReturn(searchRequest);
 * ownership. Elasticsearch licenses this file to you under
        assertThat(p.getValueFor("total_hits"), equalTo("-1"));
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_DEBUG_SETTING.getKey(), "200ms");
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        searchRequestContext.setShardStats(10, 8, 1, 1);
import org.opensearch.index.query.QueryBuilders;
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(p.getFormattedMessage(), not(containsString("\n")));
    public static void cleanup() {
            searchPhaseContext,
import static org.mockito.Mockito.times;
        assertThat(p.getFormattedMessage(), containsString("search_type[QUERY_THEN_FETCH]"));
    }
        SearchRequestSlowLog searchRequestSlowLog = new SearchRequestSlowLog(clusterService, logger);
        verify(logger, never()).trace(any(SearchRequestSlowLog.SearchRequestSlowLogMessage.class));
        assertThat(p.getValueFor("search_type"), equalTo("QUERY_THEN_FETCH"));
        } catch (IllegalArgumentException ex) {
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.search.TotalHits;
        SearchRequestSlowLog.SearchRequestSlowLogMessage p = new SearchRequestSlowLog.SearchRequestSlowLogMessage(
        final SearchTask searchTask = mock(SearchTask.class);
    public void testLevelSettingFail() {
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_TRACE_SETTING.getKey(), "100nanos");
            () -> null
        assertEquals(TimeValue.timeValueMillis(100).nanos(), searchRequestSlowLog.getTraceThreshold());
        assertSame(logger1, logger2);
        );
            new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
        );
            searchRequestContext
            searchRequest,
                countDownLatch.countDown();
        // Makes sure that output doesn't contain any new lines
    public void testMultipleSlowLoggersUseSingleLog4jLogger() {
        ClusterService clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);
        when(searchRequest.searchType()).thenReturn(SearchType.QUERY_THEN_FETCH);
        SearchSourceBuilder source = SearchSourceBuilder.searchSource().query(QueryBuilders.matchAllQuery());
        verify(logger, never()).debug(any(SearchRequestSlowLog.SearchRequestSlowLogMessage.class));
        assertThat(p.getValueFor("total_hits"), equalTo("3 hits"));
        SearchRequestContext searchRequestContext = new SearchRequestContext(
 * SPDX-License-Identifier: Apache-2.0
    public void testSearchRequestSlowLogHasJsonFields_NotEmptySearchRequestContext() {
        assertEquals(TimeValue.timeValueMillis(400).nanos(), searchRequestSlowLog.getWarnThreshold());
        Settings settings = settingsBuilder.build();
        SearchRequestSlowLog searchRequestSlowLog = new SearchRequestSlowLog(clusterService);
import org.opensearch.search.builder.SearchSourceBuilder;
            final String expected = "No enum constant org.opensearch.common.logging.SlowLogLevel.NOT A LEVEL";
    public void testLevelSettingDebug() {
        int numRequestsLogged = randomIntBetween(0, 50);
        assertThat(p.getValueFor("total_hits"), equalTo("3 hits"));
        String level = "NOT A LEVEL";
    }
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_LEVEL.getKey(), level);
                () -> null
        assertThat(p.getValueFor("took_millis"), equalTo("0"));
        assertThat(p.getValueFor("source"), equalTo("{\\\"query\\\":{\\\"match_all\\\":{\\\"boost\\\":1.0}}}"));
import org.opensearch.test.ClusterServiceUtils;
        ClusterService clusterService2 = ClusterServiceUtils.createClusterService(
        assertThat(p.getValueFor("source"), equalTo("{\\\"query\\\":{\\\"match_all\\\":{\\\"boost\\\":1.0}}}"));
        assertThat(p.getValueFor("search_type"), equalTo("QUERY_THEN_FETCH"));
        ClusterService clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);
    @AfterClass
        assertEquals(level, searchRequestSlowLog.getLevel());
    }
        assertThat(p.getValueFor("took_millis"), equalTo("10000"));
            int finalI = i;
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_WARN_SETTING.getKey(), "400ms");
        SearchRequestSlowLog.SearchRequestSlowLogMessage p = new SearchRequestSlowLog.SearchRequestSlowLogMessage(
        final SearchRequestContext searchRequestContext = mock(SearchRequestContext.class);
        when(searchRequestContext.getAbsoluteStartNanos()).thenReturn(System.nanoTime() - 1L);
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_LEVEL.getKey(), level);
            new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
import org.opensearch.common.logging.SlowLogLevel;
            new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
        Settings settings = settingsBuilder.build();
            fail();
        SearchPhaseContext searchPhaseContext = new MockSearchPhaseContext(1, searchRequest);
            assertThat(ex, instanceOf(IllegalArgumentException.class));
        );
        when(searchPhaseContext.getRequest()).thenReturn(searchRequest);
        assertThat(p.getValueFor("phase_took"), equalTo("{expand=5, fetch=10, query=50}"));
            searchRequestContext
        assertThat(p.getValueFor("phase_took"), equalTo("{expand=5, fetch=10, query=50}"));
 */
    }
    public void testSearchRequestSlowLogHasJsonFields_PartialContext() {
        Settings.Builder settingsBuilder = Settings.builder();
        assertEquals(SlowLogLevel.TRACE, searchRequestSlowLog.getLevel());
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_WARN_SETTING.getKey(), "-1");
        new SearchRequestSlowLog(clusterService1);
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertThat(p.getValueFor("took"), equalTo("10nanos"));
        searchRequestContext.updatePhaseTookMap(SearchPhaseName.FETCH.getName(), 10L);
            searchRequestContexts.add(searchRequestContext);
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_TRACE_SETTING.getKey(), "100ms");
        SearchPhaseContext searchPhaseContext = new MockSearchPhaseContext(1, searchRequest);
            Settings.EMPTY,
        assertEquals(TimeValue.timeValueSeconds(400).nanos(), searchRequestSlowLog.getWarnThreshold());
        verify(logger, never()).warn(any(SearchRequestSlowLog.SearchRequestSlowLogMessage.class));
            fail();
        Settings settings = settingsBuilder.build();
        Settings.Builder settingsBuilder = Settings.builder();
        final Logger logger = mock(Logger.class);
import static org.mockito.Mockito.mock;
            searchRequest,
    }
        SearchRequest searchRequest = new SearchRequest().source(source);
        Logger logger2 = context.getLogger(loggerName);
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_TRACE_SETTING.getKey(), "-1");
        assertThat(p.getFormattedMessage(), containsString("phase_took_millis[{expand=5, fetch=10, query=50}]"));
    }
            searchPhaseContext,
        when(searchRequest.searchType()).thenReturn(SearchType.QUERY_THEN_FETCH);
import static org.mockito.Mockito.when;
    }
    @BeforeClass
        Loggers.removeAppender(logger, appender);
        assertEquals(TimeValue.timeValueNanos(100).nanos(), searchRequestSlowLog.getTraceThreshold());
        final Logger logger = mock(Logger.class);
        assertThat(p.getValueFor("indices"), equalTo("[]"));
        SearchPhaseContext searchPhaseContext = new MockSearchPhaseContext(1, searchRequest);
        SearchRequestSlowLog.SearchRequestSlowLogMessage p = new SearchRequestSlowLog.SearchRequestSlowLogMessage(
        ClusterService clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);
import org.opensearch.test.OpenSearchTestCase;
        searchRequestContext.setTotalHits(new TotalHits(3L, TotalHits.Relation.EQUAL_TO));
        // create a list of SearchRequestContexts
        assertEquals(TimeValue.timeValueMillis(200).nanos(), searchRequestSlowLog.getDebugThreshold());
        final List<SearchRequestOperationsListener> searchListenersList = new ArrayList<>(List.of(searchRequestSlowLog));
                thisContext.getSearchRequestOperationsListener().onRequestEnd(searchPhaseContext, thisContext);
        assertThat(p.getFormattedMessage(), containsString("source[{\"query\":{\"match_all\":{\"boost\":1.0}}}]"));
import org.junit.BeforeClass;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        when(searchRequestContext.getSearchRequestOperationsListener()).thenReturn(
        Loggers.addAppender(logger, appender);
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), searchRequestSlowLog.getTraceThreshold());
 * the Apache License, Version 2.0 (the "License"); you may
        try {
        Settings settings = settingsBuilder.build();
        Settings.Builder settingsBuilder = Settings.builder();
        SearchRequestSlowLog.SearchRequestSlowLogMessage p = new SearchRequestSlowLog.SearchRequestSlowLogMessage(
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import static org.mockito.ArgumentMatchers.any;
        final SearchRequest searchRequest = mock(SearchRequest.class);
 * license agreements. See the NOTICE file distributed with
        assertThat(p.getValueFor("search_type"), equalTo("QUERY_THEN_FETCH"));
        SearchRequestContext searchRequestContext = new SearchRequestContext(
        appender = new MockAppender("trace_appender");
        Settings.Builder settingsBuilder = Settings.builder();
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
public class SearchRequestSlowLogTests extends OpenSearchTestCase {
    }
        );
            searchRequest,
 * You may obtain a copy of the License at
            new SearchRequestOperationsListener.CompositeListener(searchListenersList, logger)
            10000000000L,
        final List<SearchRequestOperationsListener> searchListenersList = new ArrayList<>(List.of(searchRequestSlowLog));
    }
        assertThat(p.getValueFor("shards"), equalTo(""));
            new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
import org.opensearch.common.logging.Loggers;
        SearchSourceBuilder source = SearchSourceBuilder.searchSource().query(QueryBuilders.matchAllQuery());
            new SearchRequestSlowLog(clusterService);
    }
        SearchRequest searchRequest = new SearchRequest(new String[] { "index1", "index2" }, source);
import org.opensearch.common.settings.Settings;
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
    public void testOnRequestEnd() {
import org.apache.logging.log4j.LogManager;
        ClusterService clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);
    }
        Settings settings = settingsBuilder.build();
import static org.hamcrest.Matchers.instanceOf;
            });
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_INFO_SETTING.getKey(), "0ms");
            threads[i].start();
        ClusterService clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);
 * specific language governing permissions and limitations
    public void testLevelSettingWarn() {
        SearchRequest searchRequest = new SearchRequest().source(source);
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_INFO_SETTING.getKey(), "300ms");
        final SearchTask searchTask = mock(SearchTask.class);
    public void testSearchRequestSlowLogHasJsonFields_EmptySearchRequestContext() {
            searchRequest,
        assertThat(p.getFormattedMessage(), containsString("shards[{total:10, successful:8, skipped:1, failed:1}]"));
        new SearchRequestSlowLog(clusterService2);
import org.junit.AfterClass;
import java.util.ArrayList;
        assertThat(p.getValueFor("took_millis"), equalTo("0"));
 * KIND, either express or implied.  See the License for the
            searchPhaseContext,
        assertEquals(SlowLogLevel.TRACE, searchRequestSlowLog.getLevel());
        } catch (IllegalArgumentException ex) {
package org.opensearch.action.search;
        );
        Settings settings = settingsBuilder.build();
    static Logger logger = LogManager.getLogger(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_PREFIX + ".SearchRequestSlowLog");
        appender.start();
        for (int i = 0; i < numRequests; i++) {
        searchRequestContext.updatePhaseTookMap(SearchPhaseName.EXPAND.getName(), 5L);
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_TRACE_SETTING.getKey(), "0ms");
        assertEquals(level, searchRequestSlowLog.getLevel().toString());
 */
            searchPhaseContext,
        SearchRequestSlowLog searchRequestSlowLog = new SearchRequestSlowLog(clusterService);
    static MockAppender appender;
        assertEquals(TimeValue.timeValueMillis(300).nanos(), searchRequestSlowLog.getInfoThreshold());
        searchRequestContext.setShardStats(10, 8, 1, 1);
        searchRequestContext.updatePhaseTookMap(SearchPhaseName.FETCH.getName(), 10L);
        ClusterService clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);
        int numRequests = 50;
import org.apache.logging.log4j.core.LoggerContext;
        ClusterService clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);
        // each SearchRequestContext contains unique composite SearchRequestOperationsListener
            () -> null
        assertThat(p.getFormattedMessage(), startsWith("took[100micros]"));
            searchRequestContext
    public void testSetThresholdsDefaults() {
import static org.hamcrest.Matchers.hasToString;
                SearchRequestContext thisContext = searchRequestContexts.get(finalI);
    }
        ClusterService clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);
        assertThat(p.getFormattedMessage(), containsString("total_hits[3 hits]"));
        assertThat(p.getFormattedMessage(), containsString("indices[index1, index2]"));
import org.opensearch.cluster.service.ClusterService;
        SearchRequestContext searchRequestContext = new SearchRequestContext(
 * Licensed to Elasticsearch under one or more contributor
 *
            100000,
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        Phaser phaser = new Phaser(numRequests + 1);
 * not use this file except in compliance with the License.
        SlowLogLevel level = SlowLogLevel.WARN;
        assertEquals(TimeValue.timeValueMillis(300).nanos(), searchRequestSlowLog.getInfoThreshold());
        searchRequestContext.updatePhaseTookMap(SearchPhaseName.FETCH.getName(), 10L);
        );
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_WARN_SETTING.getKey(), "NOT A TIME VALUE");
        Settings settings = settingsBuilder.build();
        ClusterService clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);
        searchRequestContext.getSearchRequestOperationsListener().onRequestEnd(searchPhaseContext, searchRequestContext);
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_DEBUG_SETTING.getKey(), "200ms");
import java.util.concurrent.CountDownLatch;
            null
        when(searchPhaseContext.getTask()).thenReturn(searchTask);
    }
        assertThat(p.getValueFor("took"), equalTo("10s"));
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_DEBUG_SETTING.getKey(), "-1");
        );
    public static void init() throws IllegalAccessException {
        SearchRequestSlowLog searchRequestSlowLog = new SearchRequestSlowLog(clusterService);
/*
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
        }
            assertThat(ex, hasToString(containsString(expected)));
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_DEBUG_SETTING.getKey(), "0ms");
/*
        Settings.Builder settingsBuilder = Settings.builder();
    public void testSetThresholdsError() {
        appender.stop();
        final SearchPhaseContext searchPhaseContext = mock(SearchPhaseContext.class);
        phaser.arriveAndAwaitAdvance();
            );
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_DEBUG_SETTING.getKey(), "200micros");
        SearchRequestContext searchRequestContext = new SearchRequestContext(
        searchRequestContext.updatePhaseTookMap(SearchPhaseName.QUERY.getName(), 50L);
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        searchRequestContext.updatePhaseTookMap(SearchPhaseName.EXPAND.getName(), 5L);
    public void testSetThresholds() {
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_INFO_SETTING.getKey(), "10s");
        assertThat(p.getValueFor("shards"), equalTo("{total:5, successful:3, skipped:1, failed:1}"));
        assertEquals(TimeValue.timeValueMillis(200).nanos(), searchRequestSlowLog.getDebugThreshold());
            assertThat(ex, hasToString(containsString(expected)));
        assertEquals(TimeValue.timeValueMillis(400).nanos(), searchRequestSlowLog.getWarnThreshold());
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            10,
 *
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    }
        SearchRequest searchRequest = new SearchRequest().source(source);
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_WARN_SETTING.getKey(), "400s");
        );
import static org.hamcrest.Matchers.not;
        Settings settings = settingsBuilder.build();
            null
        final SearchPhaseContext searchPhaseContext = mock(SearchPhaseContext.class);
                phaser.arriveAndAwaitAdvance();
        assertThat(p.getValueFor("id"), equalTo(null));
        assertThat(p.getValueFor("id"), equalTo(null));
        verify(logger, never()).debug(any(SearchRequestSlowLog.SearchRequestSlowLogMessage.class));
        verify(logger, times(numRequestsLogged)).info(any(SearchRequestSlowLog.SearchRequestSlowLogMessage.class));
                new SearchRequestOperationsListener.CompositeListener(searchListenersList, logger),
        SearchPhaseContext searchPhaseContext = new MockSearchPhaseContext(1, searchRequest);
            assertThat(ex, instanceOf(IllegalArgumentException.class));
        CountDownLatch countDownLatch = new CountDownLatch(numRequests);
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_LEVEL.getKey(), level);
            final String expected =
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), searchRequestSlowLog.getInfoThreshold());
            () -> null
        Settings settings = settingsBuilder.build();
        assertThat(p.getValueFor("shards"), equalTo("{total:10, successful:8, skipped:1, failed:1}"));
import org.opensearch.common.settings.ClusterSettings;
        assertThat(p.getValueFor("source"), equalTo("{\\\"query\\\":{\\\"match_all\\\":{\\\"boost\\\":1.0}}}"));
        verify(logger, never()).trace(any(SearchRequestSlowLog.SearchRequestSlowLogMessage.class));
            SearchRequestContext searchRequestContext = new SearchRequestContext(
        );
        Thread[] threads = new Thread[numRequests];
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertThat(p.getValueFor("phase_took"), equalTo("{}"));
import static org.hamcrest.Matchers.startsWith;
        assertThat(p.getValueFor("took"), equalTo("10nanos"));
    public void testConcurrentOnRequestEnd() throws InterruptedException {
        searchRequestContext.updatePhaseTookMap(SearchPhaseName.QUERY.getName(), 50L);
 */
import org.apache.logging.log4j.Logger;
