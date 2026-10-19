        );
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getQueryWarnThreshold());  
            assertNull(appender.getLastEventAndReset());
        assertEquals(SlowLogLevel.TRACE, log.getLevel());
            assertNotNull(appender.getLastEventAndReset());
import org.opensearch.core.index.shard.ShardId;
 * KIND, either express or implied.  See the License for the
import static org.hamcrest.Matchers.hasToString;
        }
            assertNull(appender.getLastEventAndReset());
        {
        source = SearchSourceBuilder.searchSource().query(QueryBuilders.matchAllQuery());  
        SearchContext ctx = createSearchContext(index);
            .build();
                        .build()  
    public void testSetQueryLevels() {
        final String causeExpected = "failed to parse setting ["
 * license agreements. See the NOTICE file distributed with
            log.onFetchPhase(ctx, 30L);
        assertThat(p.getFormattedMessage(), startsWith("[foo][0]"));
            assertNull(appender.getLastEventAndReset());
                    Settings.builder()
            @Override
        assertEquals(SlowLogLevel.DEBUG, debugLog.getLevel());
    public void testLevelSetting() {
        SearchSlowLog log2 = new SearchSlowLog(settings2);
        }  
        } catch (IllegalArgumentException ex) {
        assertEquals(TimeValue.timeValueMillis(120).nanos(), log.getQueryTraceThreshold());
                .build()  
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
        settings = new IndexSettings(metadata, Settings.EMPTY);
                    "index",  
        SearchContext searchContext = searchContextWithSourceAndTask(index);  
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING.getKey(), "10nanos")  
        {
        assertEquals(TimeValue.timeValueMillis(200).nanos(), log.getFetchDebugThreshold());
                    "index",
            assertNotNull(ex.getCause());
    protected SearchContext createSearchContext(IndexService indexService, String... groupStats) {
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING.getKey(), "20nanos")
        IndexSettings settings2 = new IndexSettings(
        try {
        assertEquals(TimeValue.timeValueMillis(400).nanos(), log.getFetchWarnThreshold());
        Loggers.addAppender(queryLog, appender);
    }  
    public void testSetFetchLevels() {  
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING.getKey(), "100ms")
                )
        IndexMetadata metadata = newIndexMeta(
        }  
        settings.updateIndexMetadata(metadata);  
        return metadata;  
            fail();
            newIndexMeta("index", Settings.builder().put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL.getKey(), level).build())
        assertThat(p.getValueFor("source"), equalTo("{\\\"query\\\":{\\\"match_all\\\":{\\\"boost\\\":1.0}}}"));
            fail();
        );
        {  
            assertTimeValueException(ex, "index.search.slowlog.threshold.query.trace");
            settings.updateIndexMetadata(createIndexMetadata(SlowLogLevel.DEBUG, "index", uuid));
        assertEquals(TimeValue.timeValueMillis(220).nanos(), log.getQueryDebugThreshold());  
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
                        .build()
                .put(IndexMetadata.SETTING_INDEX_UUID, uuid)
            fail();
            );  
        searchContext.setTask(new SearchShardTask(0, "n/a", "n/a", "test", null, Collections.singletonMap(Task.X_OPAQUE_ID, "my_id")));
            "index",  
                    .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING.getKey(), "120ms")  
            createIndexMetadata(SlowLogLevel.WARN, "index-1", UUIDs.randomBase64UUID()),  
                )
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING.getKey(), "400ms")
                        .build()  
    }  
        log = new SearchSlowLog(settings);
        try {
            Settings.builder()  
            }
        } catch (IllegalArgumentException ex) {
            assertNotNull(appender.getLastEventAndReset());
        level = randomFrom(SlowLogLevel.values());
        IndexSettings settings2 = new IndexSettings(
                return request;
        settings = new IndexSettings(metadata, Settings.EMPTY);  
        ctx.setTask(
 * Unless required by applicable law or agreed to in writing,
                    Settings.builder()
        SearchSlowLog log2 = new SearchSlowLog(settings2);
        IndexSettings settings1 = new IndexSettings(
        assertThat(p.getValueFor("took_millis"), equalTo("0"));
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getFetchTraceThreshold());
                return super.getTask();  
            "index",
        searchContext = createSearchContext(index, "group1", "group2");
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        };
        {
import java.util.Collections;
 */
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        }  
        int numberOfLoggersAfter = context.getLoggers().size();
        );  
        }
            assertTimeValueException(ex, "index.search.slowlog.threshold.fetch.info");
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
import org.opensearch.common.logging.MockAppender;  
import org.opensearch.common.unit.TimeValue;  
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING.getKey(), "30nanos")
            assertNull(appender.getLastEventAndReset());
            createIndexMetadata(SlowLogLevel.WARN, "index-1", UUIDs.randomBase64UUID()),
        } catch (IllegalArgumentException ex) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            )
        } catch (IllegalArgumentException ex) {
                        .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING.getKey(), "NOT A TIME VALUE")
            log.onFetchPhase(ctx, 41L);
        } catch (IllegalArgumentException ex) {
        }
        SearchSlowLog log = new SearchSlowLog(settings);
/*
            settings.updateIndexMetadata(createIndexMetadata(SlowLogLevel.TRACE, "index", uuid));  
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING.getKey(), "100ms")
import org.opensearch.cluster.metadata.IndexMetadata;  
            settings.updateIndexMetadata(
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL.getKey(), level)
            assertNotNull(appender.getLastEventAndReset());  
        assertEquals(TimeValue.timeValueMillis(320).nanos(), log.getQueryInfoThreshold());
        try {
        );
            }
public class SearchSlowLogTests extends OpenSearchSingleNodeTestCase {
import org.opensearch.common.logging.SlowLogLevel;
                newIndexMeta(
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getFetchInfoThreshold());
            public SearchShardTask getTask() {
        );
 *
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getQueryDebugThreshold());
        int numberOfLoggersBefore = context.getLoggers().size();
        Loggers.addAppender(fetchLog, appender);
        IndexMetadata metadata = newIndexMeta(  
import org.opensearch.tasks.Task;
import org.junit.AfterClass;
            settings.updateIndexMetadata(createIndexMetadata(SlowLogLevel.INFO, "index", uuid));
    }
        }
    @AfterClass
        SearchContext ctx1 = searchContextWithSourceAndTask(index1);
            assertTimeValueException(ex, "index.search.slowlog.threshold.fetch.warn");  
        try {  
        }
                        .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING.getKey(), "NOT A TIME VALUE")
                )
                    .build()
    public void testTwoLoggersDifferentLevel() {
        SearchSourceBuilder source = SearchSourceBuilder.searchSource().query(QueryBuilders.matchAllQuery());
        assertThat(p.getValueFor("stats"), equalTo("[\\\"group1\\\", \\\"group2\\\"]"));
            );
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL.getKey(), SlowLogLevel.INFO)
            settings.updateIndexMetadata(
            "index",
    private IndexMetadata createIndexMetadata(SlowLogLevel level, String index, String uuid) {
            assertNotNull(appender.getLastEventAndReset());
            assertNull(appender.getLastEventAndReset());
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getFetchDebugThreshold());
            assertNull(appender.getLastEventAndReset());
 */  
    private SearchContext searchContextWithSourceAndTask(IndexService index) {  
        metadata = newIndexMeta(
        assertEquals(TimeValue.timeValueMillis(100).nanos(), log.getFetchTraceThreshold());
 * compatible open source license.
        SearchContext ctx2 = searchContextWithSourceAndTask(index2);  
            log.onFetchPhase(ctx, 11L);
            Settings.builder()  
                    .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING.getKey(), "320ms")  
        } catch (IllegalArgumentException ex) {  
        SearchSourceBuilder source = SearchSourceBuilder.searchSource().query(QueryBuilders.matchAllQuery());
                        .build()  
        SearchSlowLog log1 = new SearchSlowLog(settings1);
            }  
import java.util.Arrays;  
        assertEquals(TimeValue.timeValueMillis(400).nanos(), log.getQueryWarnThreshold());  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            log.onQueryPhase(ctx, 40L);
            log.onQueryPhase(ctx, 30L);  
    public static void init() throws IllegalAccessException {
        final ShardSearchRequest request = new ShardSearchRequest(new ShardId(indexService.index(), 0), 0L, null);
        appender.stop();  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            assertTimeValueException(ex, "index.search.slowlog.threshold.fetch.debug");
            assertNotNull(appender.getLastEventAndReset());
import org.apache.logging.log4j.Logger;
    }  
            log1.onFetchPhase(ctx1, 11L);
            // level set INFO, should log when INFO level is breached
            fail();  
        SlowLogLevel level = randomFrom(SlowLogLevel.values());  
            assertNotNull(appender.getLastEventAndReset());  
 *  
                        .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING.getKey(), "NOT A TIME VALUE")  
        try {  
            log2.onFetchPhase(ctx2, 11L);
                )  
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING.getKey(), "30nanos")
    static MockAppender appender;
            newIndexMeta(  
            settings.updateIndexMetadata(
                newIndexMeta(  
import static org.hamcrest.Matchers.instanceOf;  
            log.onFetchPhase(ctx, 20L);
        assertEquals(TimeValue.timeValueMillis(120).nanos(), log.getFetchTraceThreshold());  
                "index",
        assertEquals(level, log.getLevel());
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING.getKey(), "40nanos")  
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING.getKey(), "10nanos")
        IndexMetadata metadata = newIndexMeta(
        } catch (IllegalArgumentException ex) {
        assertEquals(TimeValue.timeValueMillis(320).nanos(), log.getFetchInfoThreshold());
                        .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING.getKey(), "NOT A TIME VALUE")
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING.getKey(), "200ms")
        settings.updateIndexMetadata(
        searchContext.setTask(new SearchShardTask(0, "n/a", "n/a", "test", null, Collections.singletonMap(Task.X_OPAQUE_ID, "my_id")));  
        assertThat(p.getValueFor("message"), equalTo("[foo][0]"));  
        assertEquals(SlowLogLevel.INFO, infoLog.getLevel());
                    Settings.builder()  
            settings.updateIndexMetadata(
        Settings build = Settings.builder()
import org.hamcrest.Matchers;
            );  
        );
        p = new SearchSlowLog.SearchSlowLogMessage(searchContext, 10);  
                newIndexMeta(  
            assertNotNull(appender.getLastEventAndReset());  
        return createSearchContext(indexService, new String[] {});
        SearchSlowLog infoLog = new SearchSlowLog(settings);
import org.opensearch.common.UUIDs;
        }  
import static org.hamcrest.Matchers.containsString;
        settings = new IndexSettings(metadata, Settings.EMPTY);
            assertNotNull(appender.getLastEventAndReset());  
    }  
        );  
                newIndexMeta(
        assertThat(p.getFormattedMessage(), endsWith("request_id[sample_request_id]"));
            assertTimeValueException(ex, "index.search.slowlog.threshold.query.debug");
        SearchSlowLog log = new SearchSlowLog(settings);  
        assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));
            @Override  
            log.onFetchPhase(ctx, 21L);  
        assertThat(numberOfLoggersAfter, equalTo(numberOfLoggersBefore));
        }  
        SearchSlowLog log1 = new SearchSlowLog(settings1);  
            settings.updateIndexMetadata(
                    .build()
        assertThat(p.getValueFor("total_shards"), equalTo("1"));  
                        .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING.getKey(), "NOT A TIME VALUE")
    }
        try {  
        String uuid = UUIDs.randomBase64UUID();
        assertThat(p.getValueFor("stats"), equalTo("[]"));
        }
                Settings.builder()
        metadata = newIndexMeta(  
 * Modifications Copyright OpenSearch Contributors. See
        SearchSlowLog debugLog = new SearchSlowLog(settings);  
 * under the License.  
    }
import org.opensearch.Version;
 *
        level = randomFrom(SlowLogLevel.values());
            // level set TRACE, should log when TRACE level is breached
    }  
            final IllegalArgumentException cause = (IllegalArgumentException) ex.getCause();
    public void testMultipleSlowLoggersUseSingleLog4jLogger() {
        assertEquals(TimeValue.timeValueMillis(100).nanos(), log.getQueryTraceThreshold());  
            public ShardSearchRequest request() {  
                return Arrays.asList(groupStats);
                    "index",
        );  
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING.getKey(), "400ms")
 * this work for additional information regarding copyright
            log.onFetchPhase(ctx, 31L);
    }
import java.io.IOException;
            assertTimeValueException(ex, "index.search.slowlog.threshold.fetch.trace");  
import static org.hamcrest.Matchers.endsWith;  
    }
        assertThat(e, hasToString(containsString(expected)));  
            + "] with value [NOT A TIME VALUE] as a time value: unit is missing or unrecognized";  
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getFetchTraceThreshold());  
    private IndexMetadata newIndexMeta(String name, Settings indexSettings) {
        assertEquals(TimeValue.timeValueMillis(420).nanos(), log.getQueryWarnThreshold());
            newIndexMeta("index", Settings.builder().put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL.getKey(), level).build())
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(TimeValue.timeValueMillis(200).nanos(), log.getQueryDebugThreshold());
            fail();
            // level set DEBUG, should log when DEBUG level is breached  
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
        settings.updateIndexMetadata(metadata);
        settings = new IndexSettings(metadata, Settings.EMPTY);
        );
            newIndexMeta(
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getFetchWarnThreshold());  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.index.query.QueryBuilders;  
            log.onQueryPhase(ctx, 11L);  
            assertThat(ex, hasToString(containsString(expected)));
            )  
                        .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING.getKey(), "NOT A TIME VALUE")  
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getQueryInfoThreshold());
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getQueryTraceThreshold());  
import org.apache.logging.log4j.LogManager;
    public void testLevelPrecedence() {
/*  
    private void assertTimeValueException(final IllegalArgumentException e, final String key) {
import org.opensearch.search.internal.ShardSearchRequest;  
    }
    @BeforeClass  
                    "index",
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getFetchDebugThreshold());
        }
                        .build()
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL.getKey(), SlowLogLevel.DEBUG)
            log.onFetchPhase(ctx, 40L);  
                )
        IndexService index1 = createIndex("index-1");
                    .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING.getKey(), "120ms")
                newIndexMeta(  
package org.opensearch.index;
            log.onQueryPhase(ctx, 10L);
            // level set TRACE, should log
            log1.onQueryPhase(ctx1, 11L);  
        IndexService index = createIndex("foo");
        return ctx;
        assertEquals(level, log.getLevel());
        SearchContext searchContext = createSearchContext(index, "group1");  
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING.getKey(), "300ms")  
        IndexService index2 = createIndex("index-2");
        assertEquals(SlowLogLevel.TRACE, log.getLevel());
import org.opensearch.test.TestSearchContext;  
            // level set WARN, should not log
            Settings.EMPTY  
        assertEquals(TimeValue.timeValueMillis(420).nanos(), log.getFetchWarnThreshold());  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.builder.SearchSourceBuilder;
        IndexService index = createIndex("foo");
            assertNull(appender.getLastEventAndReset());  
        return newIndexMeta(  
                    Settings.builder()
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertThat(p.getFormattedMessage(), not(containsString("\n")));
    static Logger queryLog = LogManager.getLogger(SearchSlowLog.INDEX_SEARCH_SLOWLOG_PREFIX + ".query");  
        );
    }
        assertNotNull(e.getCause());
}  
import org.opensearch.search.internal.SearchContext;
                        .build()
            log.onQueryPhase(ctx, 31L);
            );  
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING.getKey(), "200ms")  
                    "index",  
        try {
                Settings.builder()  
 * ownership. Elasticsearch licenses this file to you under  
            );
                .build()  
        {
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                )
    static Logger fetchLog = LogManager.getLogger(SearchSlowLog.INDEX_SEARCH_SLOWLOG_PREFIX + ".fetch");
import java.util.Map;  
            log.onQueryPhase(ctx, 20L);
            createIndexMetadata(SlowLogLevel.TRACE, "index-2", UUIDs.randomBase64UUID()),
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL.getKey(), level)
        );
            assertNull(appender.getLastEventAndReset());  
        SearchSlowLog log = new SearchSlowLog(settings);  
                )  
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());  
        appender.start();  
            log2.onQueryPhase(ctx2, 11L);  
    protected SearchContext createSearchContext(IndexService indexService) {
                .build()  
        );  
            "index",
        );
        try {
        SearchContext ctx2 = searchContextWithSourceAndTask(createIndex("index-2"));  
import org.opensearch.action.search.SearchShardTask;
        settings.updateIndexMetadata(  
    }
            fail();  
    @Override  
import org.opensearch.common.settings.Settings;
            settings.updateIndexMetadata(
        SearchSlowLog.SearchSlowLogMessage p = new SearchSlowLog.SearchSlowLogMessage(searchContext, 10);
        assertEquals(level, log.getLevel());  
                .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
import org.opensearch.common.util.BigArrays;
        Loggers.removeAppender(queryLog, appender);
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING.getKey(), "300ms")
                    .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING.getKey(), "420ms")
        settings.updateIndexMetadata(
            Settings.builder()
            log.onQueryPhase(ctx, 21L);
        }
        SearchSlowLog.SearchSlowLogMessage p = new SearchSlowLog.SearchSlowLogMessage(searchContext, 10);
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getQueryTraceThreshold());
            + key
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());
    public void testSlowLogSearchContextPrinterToLog() throws IOException {
            assertThat(ex.getCause(), instanceOf(IllegalArgumentException.class));  
            "index",
            assertTimeValueException(ex, "index.search.slowlog.threshold.query.info");  
                newIndexMeta(
                .build()
            assertNotNull(appender.getLastEventAndReset());
import org.apache.logging.log4j.core.LoggerContext;  
            Settings.builder()
        assertThat(p.getValueFor("took"), equalTo("10nanos"));
        assertEquals(TimeValue.timeValueMillis(300).nanos(), log.getFetchInfoThreshold());  
                    "index",  
        SearchContext searchContext = searchContextWithSourceAndTask(index);  
        // Makes sure that output doesn't contain any new lines  
            new SearchShardTask(0, "n/a", "n/a", "test", null, Map.of(Task.X_OPAQUE_ID, "my_id", Task.X_REQUEST_ID, "sample_request_id"))
import static org.hamcrest.Matchers.equalTo;
            Settings.builder()
        );
import java.util.List;
            index,
    public void testSlowLogsWithStats() throws IOException {
        try {  
                .build()  
                newIndexMeta("index", Settings.builder().put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL.getKey(), "NOT A LEVEL").build())
                "index",
            settings.updateIndexMetadata(
            log.onFetchPhase(ctx, 10L);  
            fail();  
            assertNull(appender.getLastEventAndReset());  
            assertNotNull(appender.getLastEventAndReset());
                        .build()
                    Settings.builder()
        SearchContext ctx1 = searchContextWithSourceAndTask(createIndex("index-1"));
    public void testSlowLogHasJsonFields() throws IOException {
            );
        assertEquals(TimeValue.timeValueMillis(300).nanos(), log.getQueryInfoThreshold());
        );
                        .build()
            newIndexMeta("index", Settings.builder().put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL.getKey(), level).build())  
        } catch (IllegalArgumentException ex) {
                    .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING.getKey(), "220ms")
        SearchContext ctx = searchContextWithSourceAndTask(createIndex("index"));  
    public static void cleanup() {  
        }
import org.opensearch.common.logging.Loggers;
import static org.hamcrest.Matchers.not;
    }
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());
    }
 */  
        settings.updateIndexMetadata(newIndexMeta("index", Settings.EMPTY));  
        ctx.request().source(source);  
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING.getKey(), "20nanos")  
            assertThat(cause, hasToString(containsString("No enum constant org.opensearch.common.logging.SlowLogLevel.NOT A LEVEL")));
        assertThat(cause, hasToString(containsString(causeExpected)));
        IndexSettings settings = new IndexSettings(createIndexMetadata(SlowLogLevel.WARN, "index", uuid), Settings.EMPTY);
        log = new SearchSlowLog(settings);  
        IndexMetadata metadata = IndexMetadata.builder(name).settings(build).build();
        } catch (IllegalArgumentException ex) {
                    .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING.getKey(), "420ms")  
                .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())  
        settings = new IndexSettings(metadata, Settings.EMPTY);
 * GitHub history for details.
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getQueryInfoThreshold());
        BigArrays bigArrays = indexService.getBigArrays();  
        assertEquals(TimeValue.timeValueMillis(220).nanos(), log.getFetchDebugThreshold());
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getFetchWarnThreshold());
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        settings.updateIndexMetadata(
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getQueryWarnThreshold());
        log = new SearchSlowLog(settings);
        assertThat(p.getValueFor("search_type"), Matchers.nullValue());
            settings.updateIndexMetadata(  
            settings.updateIndexMetadata(  
                    Settings.builder()
                    Settings.builder()
        assertThat(p.getValueFor("total_hits"), equalTo("-1"));  
        return new TestSearchContext(bigArrays, indexService) {
        appender = new MockAppender("trace_appender");
            Settings.EMPTY  
                newIndexMeta(
                    .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING.getKey(), "220ms")
import org.junit.BeforeClass;  
    }  
 * SPDX-License-Identifier: Apache-2.0
            );
 * not use this file except in compliance with the License.
            @Override
 * software distributed under the License is distributed on an
                    "index",
import static org.hamcrest.Matchers.startsWith;
            assertTimeValueException(ex, "index.search.slowlog.threshold.query.warn");
 * The OpenSearch Contributors require contributions made to  
            );
                        .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING.getKey(), "NOT A TIME VALUE")
            log.onQueryPhase(ctx, 41L);  
        );  
            assertNull(appender.getLastEventAndReset());
        assertThat(p.getValueFor("stats"), equalTo("[\\\"group1\\\"]"));  
        final String expected = "illegal value can't update [" + key + "] from [-1] to [NOT A TIME VALUE]";
            Settings.builder()
        IndexSettings settings1 = new IndexSettings(
        final IllegalArgumentException cause = (IllegalArgumentException) e.getCause();  
            fail();
                )
            .put(indexSettings)  
        searchContext.request().source(source);
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getFetchInfoThreshold());  
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getQueryDebugThreshold());  
            final String expected = "illegal value can't update [index.search.slowlog.level] from [TRACE] to [NOT A LEVEL]";  
            public List<String> groupStats() {
        assertEquals(level, log.getLevel());
/*  
        Loggers.removeAppender(fetchLog, appender);
            createIndexMetadata(SlowLogLevel.TRACE, "index-2", UUIDs.randomBase64UUID()),
                        .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING.getKey(), "NOT A TIME VALUE")  
    }
 * this file be licensed under the Apache-2.0 license or a
                    .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING.getKey(), "320ms")
                    "index",
                newIndexMeta(
            Settings.EMPTY
            fail();
            // level set to WARN, should only log when WARN limit is breached  
        SearchSlowLog.SearchSlowLogMessage p = new SearchSlowLog.SearchSlowLogMessage(searchContext, 10);
            Settings.EMPTY  
 * You may obtain a copy of the License at  
                    Settings.builder()  
        settings.updateIndexMetadata(  
            );  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
        SearchSlowLog log = new SearchSlowLog(settings);  
                .build()
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING.getKey(), "40nanos")
        IndexService index = createIndex("foo");
        searchContext.request().source(source);
