        Settings.Builder settingsBuilder = Settings.builder();
        );  
        Settings.Builder settingsBuilder = Settings.builder();  
        final SearchRequest searchRequest = mock(SearchRequest.class);
import org.apache.logging.log4j.Logger;
import org.opensearch.common.settings.Settings;
 * this work for additional information regarding copyright
        SlowLogLevel level = SlowLogLevel.WARN;
        ClusterService clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);
    public void testOnRequestEnd() {  
        assertThat(p.getValueFor("id"), equalTo(null));
import static org.mockito.Mockito.when;  
        Settings.Builder settingsBuilder = Settings.builder();  
        assertEquals(level, searchRequestSlowLog.getLevel());
        } catch (IllegalArgumentException ex) {  
                new SearchRequestOperationsListener.CompositeListener(searchListenersList, logger),
            final String expected = "No enum constant org.opensearch.common.logging.SlowLogLevel.NOT A LEVEL";
        SearchRequest searchRequest = new SearchRequest().source(source);
    public void testConcurrentOnRequestEnd() throws InterruptedException {  
        searchRequestContext.updatePhaseTookMap(SearchPhaseName.EXPAND.getName(), 5L);  
    }  
        assertThat(p.getValueFor("total_hits"), equalTo("3 hits"));  
        assertEquals(TimeValue.timeValueMillis(300).nanos(), searchRequestSlowLog.getInfoThreshold());  
            assertThat(ex, hasToString(containsString(expected)));  
        assertThat(p.getFormattedMessage(), containsString("search_type[QUERY_THEN_FETCH]"));  
        SearchRequestSlowLog searchRequestSlowLog = new SearchRequestSlowLog(clusterService, logger);
        assertThat(p.getValueFor("id"), equalTo(null));
        appender = new MockAppender("trace_appender");
            searchRequestContext
    public void testMultipleSlowLoggersUseSingleLog4jLogger() {
        SearchRequestContext searchRequestContext = new SearchRequestContext(  
import static org.hamcrest.Matchers.not;
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_DEBUG_SETTING.getKey(), "200ms");
        Settings settings = settingsBuilder.build();
        assertEquals(SlowLogLevel.TRACE, searchRequestSlowLog.getLevel());
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_WARN_SETTING.getKey(), "400s");
        SearchRequestSlowLog.SearchRequestSlowLogMessage p = new SearchRequestSlowLog.SearchRequestSlowLogMessage(
                countDownLatch.countDown();
        assertThat(p.getValueFor("source"), equalTo("{\\\"query\\\":{\\\"match_all\\\":{\\\"boost\\\":1.0}}}"));  
        when(searchPhaseContext.getRequest()).thenReturn(searchRequest);  
import org.opensearch.search.builder.SearchSourceBuilder;
 */  
    }
        phaser.arriveAndAwaitAdvance();
 *
                SearchRequestContext thisContext = searchRequestContexts.get(finalI);
        assertEquals(TimeValue.timeValueSeconds(400).nanos(), searchRequestSlowLog.getWarnThreshold());
    public void testLevelSettingFail() {
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_DEBUG_SETTING.getKey(), "200micros");
        assertSame(logger1, logger2);  
                phaser.arriveAndAwaitAdvance();
        when(searchRequestContext.getAbsoluteStartNanos()).thenReturn(System.nanoTime() - 1L);
 * Licensed to Elasticsearch under one or more contributor  
    static MockAppender appender;  
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), searchRequestSlowLog.getTraceThreshold());
            searchRequestContext.setAbsoluteStartNanos((i < numRequestsLogged) ? 0 : System.nanoTime());  
        searchRequestContext.setTotalHits(new TotalHits(3L, TotalHits.Relation.EQUAL_TO));
        searchRequestContext.updatePhaseTookMap(SearchPhaseName.FETCH.getName(), 10L);  
        final List<SearchRequestOperationsListener> searchListenersList = new ArrayList<>(List.of(searchRequestSlowLog));  
        );  
        Settings settings = settingsBuilder.build();  
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        SearchRequestContext searchRequestContext = new SearchRequestContext(
        }
package org.opensearch.action.search;
            assertThat(ex, instanceOf(IllegalArgumentException.class));
import org.junit.BeforeClass;
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
 * not use this file except in compliance with the License.
import java.util.concurrent.Phaser;
        when(searchPhaseContext.getTask()).thenReturn(searchTask);
        assertThat(p.getFormattedMessage(), not(containsString("\n")));
import java.util.ArrayList;
            new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
    }
        );
        searchRequestContext.updatePhaseTookMap(SearchPhaseName.QUERY.getName(), 50L);  
    }
        assertThat(p.getValueFor("total_hits"), equalTo("-1"));
                searchRequest,  
            () -> null
        Settings.Builder settingsBuilder = Settings.builder();
        Phaser phaser = new Phaser(numRequests + 1);  
        assertThat(p.getFormattedMessage(), containsString("phase_took_millis[{expand=5, fetch=10, query=50}]"));
        searchRequestContext.setShardStats(5, 3, 1, 1);  
/*  
            searchRequest,
import org.junit.AfterClass;
        // create a list of SearchRequestContexts  
        verify(logger, never()).warn(any(SearchRequestSlowLog.SearchRequestSlowLogMessage.class));  
        searchRequestContext.updatePhaseTookMap(SearchPhaseName.QUERY.getName(), 50L);
        assertEquals(TimeValue.timeValueMillis(200).nanos(), searchRequestSlowLog.getDebugThreshold());  
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_INFO_SETTING.getKey(), "0ms");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        when(searchPhaseContext.getRequest()).thenReturn(searchRequest);
}
        new SearchRequestSlowLog(clusterService2);  
 * this file be licensed under the Apache-2.0 license or a
    public void testSearchRequestSlowLogSearchContextPrinterToLog() {  
        assertThat(p.getValueFor("phase_took"), equalTo("{expand=5, fetch=10, query=50}"));
    public void testSearchRequestSlowLogHasJsonFields_EmptySearchRequestContext() {
        searchRequestContext.updatePhaseTookMap(SearchPhaseName.QUERY.getName(), 50L);
    public static void cleanup() {
    public void testLevelSettingDebug() {
    }
        assertThat(p.getValueFor("indices"), equalTo("[]"));  
            new SearchRequestSlowLog(clusterService);
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_WARN_SETTING.getKey(), "400ms");  
 * compatible open source license.
        countDownLatch.await();  
import org.apache.lucene.search.TotalHits;
            int finalI = i;
        SearchRequest searchRequest = new SearchRequest().source(source);
        assertThat(p.getFormattedMessage(), startsWith("took[100micros]"));
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_TRACE_SETTING.getKey(), "0ms");
        Loggers.removeAppender(logger, appender);  
        ClusterService clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);
                thisContext.getSearchRequestOperationsListener().onRequestEnd(searchPhaseContext, thisContext);  
        SearchPhaseContext searchPhaseContext = new MockSearchPhaseContext(1, searchRequest);
        for (int i = 0; i < numRequests; i++) {
import static org.mockito.Mockito.never;  
 * GitHub history for details.
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_TRACE_SETTING.getKey(), "100nanos");
        );  
 */  
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_DEBUG_SETTING.getKey(), "-1");  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
import org.opensearch.test.OpenSearchTestCase;  
            searchRequest,
        verify(logger, never()).trace(any(SearchRequestSlowLog.SearchRequestSlowLogMessage.class));  
        );  
        SearchRequestSlowLog.SearchRequestSlowLogMessage p = new SearchRequestSlowLog.SearchRequestSlowLogMessage(  
        assertThat(p.getFormattedMessage(), containsString("total_hits[3 hits]"));
        SearchRequestSlowLog searchRequestSlowLog = new SearchRequestSlowLog(clusterService);  
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_WARN_SETTING.getKey(), "400ms");
import static org.hamcrest.Matchers.startsWith;  
 * SPDX-License-Identifier: Apache-2.0
        SearchRequest searchRequest = new SearchRequest(new String[] { "index1", "index2" }, source);
            10,
        assertEquals(SlowLogLevel.TRACE, searchRequestSlowLog.getLevel());
        SearchRequestContext searchRequestContext = new SearchRequestContext(
        assertEquals(TimeValue.timeValueMillis(200).nanos(), searchRequestSlowLog.getDebugThreshold());
import org.opensearch.common.logging.SlowLogLevel;
    }
public class SearchRequestSlowLogTests extends OpenSearchTestCase {
        searchRequestContext.updatePhaseTookMap(SearchPhaseName.EXPAND.getName(), 5L);
            searchRequestContext  
        assertEquals(level, searchRequestSlowLog.getLevel().toString());
        );
        }
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_LEVEL.getKey(), level);
    }  
            10000000000L,  
            );
        Settings settings = settingsBuilder.build();
    }
        try {  
        verify(logger, times(numRequestsLogged)).info(any(SearchRequestSlowLog.SearchRequestSlowLogMessage.class));  
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
        int numRequestsLogged = randomIntBetween(0, 50);
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_LEVEL.getKey(), level);  
        final SearchPhaseContext searchPhaseContext = mock(SearchPhaseContext.class);
import org.opensearch.common.unit.TimeValue;
        SearchRequestSlowLog searchRequestSlowLog = new SearchRequestSlowLog(clusterService);  
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_WARN_SETTING.getKey(), "NOT A TIME VALUE");
import org.opensearch.common.settings.ClusterSettings;  
 * The OpenSearch Contributors require contributions made to  
    public void testSetThresholds() {
        Settings.Builder settingsBuilder = Settings.builder();
        Logger logger1 = context.getLogger(loggerName);
        searchRequestContext.setTotalHits(new TotalHits(3L, TotalHits.Relation.EQUAL_TO));
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_DEBUG_SETTING.getKey(), "0ms");  
    }
        String level = "DEBUG";  
    public void testSearchRequestSlowLogHasJsonFields_PartialContext() {
        SearchPhaseContext searchPhaseContext = new MockSearchPhaseContext(1, searchRequest);
        CountDownLatch countDownLatch = new CountDownLatch(numRequests);
            new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
            new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),  
            100000,
        SearchSourceBuilder source = SearchSourceBuilder.searchSource().query(QueryBuilders.matchAllQuery());
 * the Apache License, Version 2.0 (the "License"); you may
        SearchRequestSlowLog searchRequestSlowLog = new SearchRequestSlowLog(clusterService);  
        when(searchRequestContext.getSearchRequestOperationsListener()).thenReturn(
        SearchRequestSlowLog searchRequestSlowLog = new SearchRequestSlowLog(clusterService);
        appender.stop();
        ClusterService clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);  
        Logger logger2 = context.getLogger(loggerName);
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_TRACE_SETTING.getKey(), "100ms");  
 * You may obtain a copy of the License at  
import static org.hamcrest.Matchers.instanceOf;
        assertThat(p.getValueFor("search_type"), equalTo("QUERY_THEN_FETCH"));
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        assertEquals(TimeValue.timeValueMillis(300).nanos(), searchRequestSlowLog.getInfoThreshold());
import org.opensearch.common.logging.Loggers;  
            searchRequest,  
import static org.hamcrest.Matchers.containsString;  
    public void testSetThresholdsError() {
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        Settings settings = settingsBuilder.build();
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_INFO_SETTING.getKey(), "10s");
        assertEquals(TimeValue.timeValueMillis(400).nanos(), searchRequestSlowLog.getWarnThreshold());
                "failed to parse setting [cluster.search.request.slowlog.threshold.warn] with value [NOT A TIME VALUE] as a time value";
    public void testSearchRequestSlowLogHasJsonFields_NotEmptySearchRequestContext() {
        assertThat(p.getValueFor("search_type"), equalTo("QUERY_THEN_FETCH"));
    static Logger logger = LogManager.getLogger(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_PREFIX + ".SearchRequestSlowLog");
import static org.mockito.Mockito.times;
        Settings settings = settingsBuilder.build();  
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_TRACE_SETTING.getKey(), "-1");
/*
        assertThat(p.getFormattedMessage(), containsString("source[{\"query\":{\"match_all\":{\"boost\":1.0}}}]"));  
 *  
    }  
import org.opensearch.cluster.service.ClusterService;
 *
        final SearchTask searchTask = mock(SearchTask.class);
        assertThat(p.getValueFor("took"), equalTo("10nanos"));
        searchRequestContext.updatePhaseTookMap(SearchPhaseName.FETCH.getName(), 10L);
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), searchRequestSlowLog.getInfoThreshold());
        SearchRequestSlowLog.SearchRequestSlowLogMessage p = new SearchRequestSlowLog.SearchRequestSlowLogMessage(
        // each SearchRequestContext contains unique composite SearchRequestOperationsListener
        searchRequestContext.getSearchRequestOperationsListener().onRequestEnd(searchPhaseContext, searchRequestContext);
            searchPhaseContext,
            new SearchRequestOperationsListener.CompositeListener(searchListenersList, logger)  
import org.apache.logging.log4j.core.LoggerContext;  
    public static void init() throws IllegalAccessException {
import java.util.List;
        final SearchTask searchTask = mock(SearchTask.class);
            searchRequestContext
        ClusterService clusterService1 = ClusterServiceUtils.createClusterService(
        try {  
        when(searchPhaseContext.getTask()).thenReturn(searchTask);  
        assertThat(p.getValueFor("took"), equalTo("10s"));
        Loggers.addAppender(logger, appender);
        new SearchRequestSlowLog(clusterService1);
        }
import org.opensearch.index.query.QueryBuilders;  
        appender.start();  
        SearchRequestContext searchRequestContext = new SearchRequestContext(  
        Settings settings = settingsBuilder.build();
    @AfterClass
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_INFO_SETTING.getKey(), "300ms");
        String loggerName = SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_PREFIX + ".SearchRequestSlowLog";  
        assertThat(p.getValueFor("shards"), equalTo("{total:5, successful:3, skipped:1, failed:1}"));  
            () -> null  
        ArrayList<SearchRequestContext> searchRequestContexts = new ArrayList<>();
        SearchSourceBuilder source = SearchSourceBuilder.searchSource().query(QueryBuilders.matchAllQuery());
            searchRequest,
        verify(logger, never()).debug(any(SearchRequestSlowLog.SearchRequestSlowLogMessage.class));
    }
        SearchSourceBuilder source = SearchSourceBuilder.searchSource().query(QueryBuilders.matchAllQuery());  
 * specific language governing permissions and limitations
        Settings settings = settingsBuilder.build();
        assertThat(p.getValueFor("took_millis"), equalTo("0"));
            fail();
        }
    }
        assertThat(p.getValueFor("search_type"), equalTo("QUERY_THEN_FETCH"));  
            new SearchRequestOperationsListener.CompositeListener(List.of(), LogManager.getLogger()),
        String level = "NOT A LEVEL";
        verify(logger, never()).debug(any(SearchRequestSlowLog.SearchRequestSlowLogMessage.class));
        SearchRequestSlowLog searchRequestSlowLog = new SearchRequestSlowLog(clusterService, logger);
        Settings.Builder settingsBuilder = Settings.builder();
        verify(logger, never()).warn(any(SearchRequestSlowLog.SearchRequestSlowLogMessage.class));
            10,
    public void testSetThresholdsUnits() {  
    }  
        searchRequestContext.updatePhaseTookMap(SearchPhaseName.FETCH.getName(), 10L);
    }  
        final SearchRequest searchRequest = mock(SearchRequest.class);  
        Settings settings = settingsBuilder.build();
        searchRequestContext.setTotalHits(new TotalHits(3L, TotalHits.Relation.EQUAL_TO));  
 * KIND, either express or implied.  See the License for the
import static org.hamcrest.Matchers.hasToString;  
        searchRequestContext.setShardStats(10, 8, 1, 1);
        assertThat(p.getValueFor("indices"), equalTo("[]"));
        assertThat(p.getFormattedMessage(), containsString("indices[index1, index2]"));
        searchRequestContext.setShardStats(10, 8, 1, 1);
            assertThat(ex, hasToString(containsString(expected)));
        assertEquals(SlowLogLevel.TRACE, searchRequestSlowLog.getLevel());  
        assertThat(p.getValueFor("took_millis"), equalTo("10000"));
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_WARN_SETTING.getKey(), "-1");
        final Logger logger = mock(Logger.class);
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_INFO_SETTING.getKey(), "300ms");  
            new SearchRequestSlowLog(clusterService);
            searchPhaseContext,  
        // Makes sure that output doesn't contain any new lines
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        ClusterService clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);
        Thread[] threads = new Thread[numRequests];
        assertThat(p.getFormattedMessage(), containsString("took_millis[0]"));  
            fail();
    @BeforeClass  
        assertEquals(TimeValue.timeValueNanos(200000).nanos(), searchRequestSlowLog.getDebugThreshold());  
            });
            null
import static org.mockito.Mockito.verify;
        for (int i = 0; i < numRequests; i++) {  
            Settings.EMPTY,  
        Settings.Builder settingsBuilder = Settings.builder();
import org.opensearch.test.ClusterServiceUtils;
        searchRequestContext.updatePhaseTookMap(SearchPhaseName.EXPAND.getName(), 5L);
        SearchRequest searchRequest = new SearchRequest().source(source);  
            () -> null
import org.apache.logging.log4j.LogManager;
    public void testSetThresholdsDefaults() {
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        Settings.Builder settingsBuilder = Settings.builder();  
        } catch (IllegalArgumentException ex) {  
        assertThat(p.getValueFor("phase_took"), equalTo("{expand=5, fetch=10, query=50}"));  
        );
        assertEquals(TimeValue.timeValueMillis(100).nanos(), searchRequestSlowLog.getTraceThreshold());
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_DEBUG_SETTING.getKey(), "200ms");
        assertThat(p.getValueFor("total_hits"), equalTo("3 hits"));
        Settings.Builder settingsBuilder = Settings.builder();  
        when(searchRequest.searchType()).thenReturn(SearchType.QUERY_THEN_FETCH);
            searchPhaseContext,  
        int numRequests = 50;  
            () -> null  
        assertThat(p.getValueFor("source"), equalTo("{\\\"query\\\":{\\\"match_all\\\":{\\\"boost\\\":1.0}}}"));
        final Logger logger = mock(Logger.class);
        settingsBuilder.put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_LEVEL.getKey(), level);
        assertThat(p.getValueFor("shards"), equalTo("{total:10, successful:8, skipped:1, failed:1}"));
            searchRequestContexts.add(searchRequestContext);
                () -> null
        ClusterService clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);
        ClusterService clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);  
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertThat(p.getValueFor("shards"), equalTo(""));
        assertThat(p.getFormattedMessage(), endsWith("id[]"));  
        ClusterService clusterService2 = ClusterServiceUtils.createClusterService(
    public void testLevelSettingWarn() {  
        assertThat(p.getValueFor("took"), equalTo("10nanos"));  
import org.opensearch.common.logging.MockAppender;
        ClusterService clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);
        assertThat(p.getValueFor("id"), equalTo(null));  
 *     http://www.apache.org/licenses/LICENSE-2.0
        );
        assertThat(p.getFormattedMessage(), containsString("shards[{total:10, successful:8, skipped:1, failed:1}]"));
 * Unless required by applicable law or agreed to in writing,
        SearchRequestSlowLog.SearchRequestSlowLogMessage p = new SearchRequestSlowLog.SearchRequestSlowLogMessage(
            null
            threads[i] = new Thread(() -> {  
 */
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(TimeValue.timeValueNanos(100).nanos(), searchRequestSlowLog.getTraceThreshold());
        assertThat(p.getValueFor("took_millis"), equalTo("0"));  
/*  
            final String expected =
        assertThat(p.getValueFor("indices"), equalTo("[]"));
        assertEquals(TimeValue.timeValueMillis(400).nanos(), searchRequestSlowLog.getWarnThreshold());
        SearchPhaseContext searchPhaseContext = new MockSearchPhaseContext(1, searchRequest);
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
            SearchRequestContext searchRequestContext = new SearchRequestContext(
    }
    }  
        verify(logger, times(1)).info(any(SearchRequestSlowLog.SearchRequestSlowLogMessage.class));
        SearchPhaseContext searchPhaseContext = new MockSearchPhaseContext(1, searchRequest);  
        SearchRequestSlowLog searchRequestSlowLog = new SearchRequestSlowLog(clusterService);
        final SearchRequestContext searchRequestContext = mock(SearchRequestContext.class);
 * under the License.  
        final SearchPhaseContext searchPhaseContext = mock(SearchPhaseContext.class);  
        SearchSourceBuilder source = SearchSourceBuilder.searchSource().query(QueryBuilders.matchAllQuery());  
            assertThat(ex, instanceOf(IllegalArgumentException.class));  
        );
        Settings settings = settingsBuilder.build();  
        ClusterService clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);
import static org.mockito.ArgumentMatchers.any;
        verify(logger, never()).trace(any(SearchRequestSlowLog.SearchRequestSlowLogMessage.class));
            Settings.EMPTY,
import java.util.concurrent.CountDownLatch;  
import static org.mockito.Mockito.mock;
        );
            searchRequestContext
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        ClusterService clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);
            searchPhaseContext,
        );
        assertThat(p.getValueFor("phase_took"), equalTo("{}"));
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertThat(p.getValueFor("source"), equalTo("{\\\"query\\\":{\\\"match_all\\\":{\\\"boost\\\":1.0}}}"));
            threads[i].start();  
        when(searchRequest.searchType()).thenReturn(SearchType.QUERY_THEN_FETCH);
        final List<SearchRequestOperationsListener> searchListenersList = new ArrayList<>(List.of(searchRequestSlowLog));  
