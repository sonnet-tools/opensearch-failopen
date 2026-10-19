import static org.hamcrest.Matchers.equalTo;
                newIndexMeta(
        SearchSlowLog.SearchSlowLogMessage p = new SearchSlowLog.SearchSlowLogMessage(searchContext, 10);
        {
            log2.onFetchPhase(ctx2, 11L);
    public static void init() throws IllegalAccessException {
            settings.updateIndexMetadata(
                        .build()
 */
 */
        } catch (IllegalArgumentException ex) {
            Settings.EMPTY
import static org.hamcrest.Matchers.containsString;
    public void testSetFetchLevels() {
            public List<String> groupStats() {
            new SearchShardTask(0, "n/a", "n/a", "test", null, Map.of(Task.X_OPAQUE_ID, "my_id", Task.X_REQUEST_ID, "sample_request_id"))
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING.getKey(), "20nanos")
            assertTimeValueException(ex, "index.search.slowlog.threshold.query.warn");
        p = new SearchSlowLog.SearchSlowLogMessage(searchContext, 10);
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
            "index",
                    "index",
            assertNull(appender.getLastEventAndReset());
                        .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING.getKey(), "NOT A TIME VALUE")
                return request;
 * GitHub history for details.
import org.opensearch.common.unit.TimeValue;
            );
import org.opensearch.common.logging.Loggers;
import static org.hamcrest.Matchers.not;
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getFetchDebugThreshold());
            @Override
    }
import java.io.IOException;
                        .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING.getKey(), "NOT A TIME VALUE")
            assertNull(appender.getLastEventAndReset());
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL.getKey(), SlowLogLevel.INFO)
        IndexSettings settings1 = new IndexSettings(
            Settings.builder()
                .build()
            settings.updateIndexMetadata(
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());
                newIndexMeta(
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            log.onQueryPhase(ctx, 31L);
        assertThat(e, hasToString(containsString(expected)));
        appender.stop();
    public void testSetQueryLevels() {
        SearchSlowLog log = new SearchSlowLog(settings);
        assertEquals(TimeValue.timeValueMillis(200).nanos(), log.getQueryDebugThreshold());
            assertTimeValueException(ex, "index.search.slowlog.threshold.fetch.debug");
import org.opensearch.common.logging.SlowLogLevel;
            // level set DEBUG, should log when DEBUG level is breached
            log.onFetchPhase(ctx, 40L);
                        .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING.getKey(), "NOT A TIME VALUE")
                    "index",
        source = SearchSourceBuilder.searchSource().query(QueryBuilders.matchAllQuery());
import org.opensearch.search.internal.ShardSearchRequest;
                .build()
        metadata = newIndexMeta(
        } catch (IllegalArgumentException ex) {
        );
            }
                    Settings.builder()
import java.util.Arrays;
import java.util.List;
        settings.updateIndexMetadata(
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(TimeValue.timeValueMillis(300).nanos(), log.getQueryInfoThreshold());
                        .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING.getKey(), "NOT A TIME VALUE")
            assertNotNull(appender.getLastEventAndReset());
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING.getKey(), "100ms")
        try {
        );
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertEquals(TimeValue.timeValueMillis(420).nanos(), log.getQueryWarnThreshold());
        assertThat(p.getFormattedMessage(), not(containsString("\n")));
        settings = new IndexSettings(metadata, Settings.EMPTY);
import static org.hamcrest.Matchers.instanceOf;
            settings.updateIndexMetadata(
        assertEquals(level, log.getLevel());
import org.opensearch.test.OpenSearchSingleNodeTestCase;
    }
                    .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING.getKey(), "420ms")
            assertNull(appender.getLastEventAndReset());
            log.onFetchPhase(ctx, 41L);
import org.opensearch.Version;
    }
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING.getKey(), "40nanos")
        IndexMetadata metadata = newIndexMeta(
            @Override
                    Settings.builder()
        SearchContext ctx = createSearchContext(index);
            settings.updateIndexMetadata(
        assertThat(p.getFormattedMessage(), startsWith("[foo][0]"));
            log.onQueryPhase(ctx, 20L);
        assertEquals(TimeValue.timeValueMillis(300).nanos(), log.getFetchInfoThreshold());
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                        .build()
        );
            );
        String uuid = UUIDs.randomBase64UUID();
                    "index",
        SearchContext searchContext = searchContextWithSourceAndTask(index);
                        .build()
        assertEquals(SlowLogLevel.TRACE, log.getLevel());
        );
                        .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING.getKey(), "NOT A TIME VALUE")
    public void testSlowLogSearchContextPrinterToLog() throws IOException {
            fail();
        settings = new IndexSettings(metadata, Settings.EMPTY);
                    .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING.getKey(), "120ms")
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
 *     http://www.apache.org/licenses/LICENSE-2.0
        final String causeExpected = "failed to parse setting ["
import static org.hamcrest.Matchers.startsWith;
            "index",
                newIndexMeta(
            newIndexMeta("index", Settings.builder().put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL.getKey(), level).build())
            assertTimeValueException(ex, "index.search.slowlog.threshold.fetch.warn");
    private IndexMetadata newIndexMeta(String name, Settings indexSettings) {
import org.opensearch.common.settings.Settings;
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING.getKey(), "30nanos")
            + key
                .build()
        assertThat(numberOfLoggersAfter, equalTo(numberOfLoggersBefore));
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL.getKey(), SlowLogLevel.DEBUG)
        {
        assertThat(p.getValueFor("total_shards"), equalTo("1"));
                )
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getQueryTraceThreshold());
import static org.hamcrest.Matchers.endsWith;
        SearchSlowLog infoLog = new SearchSlowLog(settings);
        );
        Loggers.addAppender(queryLog, appender);
import org.opensearch.search.builder.SearchSourceBuilder;
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getQueryWarnThreshold());
import java.util.Collections;
                    .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING.getKey(), "220ms")
    public void testMultipleSlowLoggersUseSingleLog4jLogger() {
                return super.getTask();
import org.opensearch.action.search.SearchShardTask;
        try {
        return ctx;
                    .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING.getKey(), "320ms")
        try {
            createIndexMetadata(SlowLogLevel.WARN, "index-1", UUIDs.randomBase64UUID()),
            fail();
                    .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING.getKey(), "420ms")
        IndexMetadata metadata = newIndexMeta(
    }
        } catch (IllegalArgumentException ex) {
    @AfterClass
                )
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING.getKey(), "200ms")
        settings = new IndexSettings(metadata, Settings.EMPTY);
/*
        SearchSlowLog.SearchSlowLogMessage p = new SearchSlowLog.SearchSlowLogMessage(searchContext, 10);
                    Settings.builder()
        Loggers.removeAppender(fetchLog, appender);
    }
 * ownership. Elasticsearch licenses this file to you under
            log.onFetchPhase(ctx, 31L);
                .build()
    private SearchContext searchContextWithSourceAndTask(IndexService index) {
            log.onFetchPhase(ctx, 21L);
            assertThat(ex, hasToString(containsString(expected)));
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getQueryTraceThreshold());
    static Logger fetchLog = LogManager.getLogger(SearchSlowLog.INDEX_SEARCH_SLOWLOG_PREFIX + ".fetch");
    public void testTwoLoggersDifferentLevel() {
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING.getKey(), "20nanos")
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getQueryInfoThreshold());
import org.opensearch.test.TestSearchContext;
        }
        settings.updateIndexMetadata(
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));
        {
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getFetchDebugThreshold());
        assertNotNull(e.getCause());
            settings.updateIndexMetadata(createIndexMetadata(SlowLogLevel.TRACE, "index", uuid));
        }
 * under the License.
        IndexMetadata metadata = IndexMetadata.builder(name).settings(build).build();
        assertEquals(SlowLogLevel.DEBUG, debugLog.getLevel());
                        .build()
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getFetchWarnThreshold());
 *
        log = new SearchSlowLog(settings);
        assertThat(p.getValueFor("took_millis"), equalTo("0"));
        appender = new MockAppender("trace_appender");
    }
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING.getKey(), "300ms")
import static org.hamcrest.Matchers.hasToString;
            settings.updateIndexMetadata(
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());
                    Settings.builder()
            log2.onQueryPhase(ctx2, 11L);
        Settings build = Settings.builder()
        assertEquals(level, log.getLevel());
        } catch (IllegalArgumentException ex) {
        try {
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());
                    Settings.builder()
        SearchContext ctx = searchContextWithSourceAndTask(createIndex("index"));
            Settings.EMPTY
        SearchSlowLog log1 = new SearchSlowLog(settings1);
    }
            log.onQueryPhase(ctx, 21L);
        assertEquals(TimeValue.timeValueMillis(320).nanos(), log.getFetchInfoThreshold());
            "index",
        settings.updateIndexMetadata(newIndexMeta("index", Settings.EMPTY));
        final String expected = "illegal value can't update [" + key + "] from [-1] to [NOT A TIME VALUE]";
 * specific language governing permissions and limitations
            Settings.builder()
        assertEquals(TimeValue.timeValueMillis(220).nanos(), log.getQueryDebugThreshold());
        settings.updateIndexMetadata(metadata);
            settings.updateIndexMetadata(createIndexMetadata(SlowLogLevel.INFO, "index", uuid));
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING.getKey(), "400ms")
            )
 * not use this file except in compliance with the License.
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL.getKey(), level)
        );
        SearchSlowLog log1 = new SearchSlowLog(settings1);
        searchContext.setTask(new SearchShardTask(0, "n/a", "n/a", "test", null, Collections.singletonMap(Task.X_OPAQUE_ID, "my_id")));
        SearchContext ctx2 = searchContextWithSourceAndTask(index2);
            settings.updateIndexMetadata(
        log = new SearchSlowLog(settings);
        assertEquals(level, log.getLevel());
        try {
                newIndexMeta(
                    "index",
        IndexService index1 = createIndex("index-1");
                newIndexMeta(
    public void testLevelPrecedence() {
/*
        }
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getQueryDebugThreshold());
import java.util.Map;
        );
        metadata = newIndexMeta(
        SearchSlowLog log = new SearchSlowLog(settings);
        settings.updateIndexMetadata(
        SlowLogLevel level = randomFrom(SlowLogLevel.values());
        assertEquals(SlowLogLevel.TRACE, log.getLevel());
    public void testSlowLogHasJsonFields() throws IOException {
        assertThat(p.getValueFor("stats"), equalTo("[]"));
                        .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING.getKey(), "NOT A TIME VALUE")
        SearchContext ctx2 = searchContextWithSourceAndTask(createIndex("index-2"));
            assertTimeValueException(ex, "index.search.slowlog.threshold.query.debug");
            assertNotNull(appender.getLastEventAndReset());
                Settings.builder()
    protected SearchContext createSearchContext(IndexService indexService, String... groupStats) {
            assertNull(appender.getLastEventAndReset());
            createIndexMetadata(SlowLogLevel.TRACE, "index-2", UUIDs.randomBase64UUID()),
            assertNotNull(appender.getLastEventAndReset());
public class SearchSlowLogTests extends OpenSearchSingleNodeTestCase {
                return Arrays.asList(groupStats);
        );
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getFetchTraceThreshold());
            log.onFetchPhase(ctx, 10L);
 * KIND, either express or implied.  See the License for the
                newIndexMeta(
            fail();
    }
        try {
        assertThat(cause, hasToString(containsString(causeExpected)));
            );
        }
            assertTimeValueException(ex, "index.search.slowlog.threshold.fetch.trace");
    }
                    .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING.getKey(), "120ms")
            fail();
import org.opensearch.cluster.metadata.IndexMetadata;
            fail();
            public SearchShardTask getTask() {
import org.junit.AfterClass;
        appender.start();
                "index",
 * You may obtain a copy of the License at
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getQueryWarnThreshold());
                )
                    "index",
 * this work for additional information regarding copyright
}
        IndexSettings settings2 = new IndexSettings(
            assertNull(appender.getLastEventAndReset());
        }
                Settings.builder()
            Settings.builder()
    private void assertTimeValueException(final IllegalArgumentException e, final String key) {
                .build()
            log.onFetchPhase(ctx, 20L);
                        .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING.getKey(), "NOT A TIME VALUE")
            // level set TRACE, should log
            "index",
        } catch (IllegalArgumentException ex) {
                    .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING.getKey(), "220ms")
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL.getKey(), level)
import org.opensearch.common.util.BigArrays;
 *
        assertEquals(TimeValue.timeValueMillis(400).nanos(), log.getFetchWarnThreshold());
        } catch (IllegalArgumentException ex) {
                newIndexMeta(
            Settings.builder()
            // level set WARN, should not log
        settings = new IndexSettings(metadata, Settings.EMPTY);
        assertEquals(TimeValue.timeValueMillis(200).nanos(), log.getFetchDebugThreshold());
        ctx.setTask(
            assertNotNull(appender.getLastEventAndReset());
        {
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getFetchTraceThreshold());
                        .build()
                .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
import org.junit.BeforeClass;
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getQueryDebugThreshold());
            }
    static Logger queryLog = LogManager.getLogger(SearchSlowLog.INDEX_SEARCH_SLOWLOG_PREFIX + ".query");
            settings.updateIndexMetadata(createIndexMetadata(SlowLogLevel.DEBUG, "index", uuid));
        SearchSlowLog log2 = new SearchSlowLog(settings2);
            // level set to WARN, should only log when WARN limit is breached
        ctx.request().source(source);
            assertNotNull(ex.getCause());
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        SearchSlowLog debugLog = new SearchSlowLog(settings);
        level = randomFrom(SlowLogLevel.values());
            assertTimeValueException(ex, "index.search.slowlog.threshold.query.info");
        IndexService index2 = createIndex("index-2");
        );
                .build()
        assertThat(p.getValueFor("stats"), equalTo("[\\\"group1\\\"]"));
            fail();
        } catch (IllegalArgumentException ex) {
            assertTimeValueException(ex, "index.search.slowlog.threshold.query.trace");
        assertEquals(SlowLogLevel.INFO, infoLog.getLevel());
        SearchSlowLog log2 = new SearchSlowLog(settings2);
                )
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
                        .build()
    }
        SearchContext searchContext = createSearchContext(index, "group1");
        );
import org.opensearch.search.internal.SearchContext;
        }
        IndexService index = createIndex("foo");
    public void testSlowLogsWithStats() throws IOException {
        );
                    "index",
                    Settings.builder()
        SearchContext ctx1 = searchContextWithSourceAndTask(createIndex("index-1"));
            settings.updateIndexMetadata(
        }
    private IndexMetadata createIndexMetadata(SlowLogLevel level, String index, String uuid) {
            assertNotNull(appender.getLastEventAndReset());
        assertEquals(TimeValue.timeValueMillis(120).nanos(), log.getFetchTraceThreshold());
import org.opensearch.core.index.shard.ShardId;
                )
            final String expected = "illegal value can't update [index.search.slowlog.level] from [TRACE] to [NOT A LEVEL]";
 * compatible open source license.
            assertNotNull(appender.getLastEventAndReset());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            fail();
import org.opensearch.tasks.Task;
        assertThat(p.getValueFor("total_hits"), equalTo("-1"));
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getFetchWarnThreshold());
        }
                )
                    .build()
 * Licensed to Elasticsearch under one or more contributor
import org.apache.logging.log4j.LogManager;
                )
        // Makes sure that output doesn't contain any new lines
            log.onFetchPhase(ctx, 30L);
    }
            fail();
        searchContext.setTask(new SearchShardTask(0, "n/a", "n/a", "test", null, Collections.singletonMap(Task.X_OPAQUE_ID, "my_id")));
        };
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING.getKey(), "400ms")
/*
        {
        assertThat(p.getValueFor("search_type"), Matchers.nullValue());
            assertNull(appender.getLastEventAndReset());
            assertNull(appender.getLastEventAndReset());
        final ShardSearchRequest request = new ShardSearchRequest(new ShardId(indexService.index(), 0), 0L, null);
        return new TestSearchContext(bigArrays, indexService) {
import org.apache.logging.log4j.Logger;
 * Unless required by applicable law or agreed to in writing,
                newIndexMeta("index", Settings.builder().put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL.getKey(), "NOT A LEVEL").build())
        );
            log1.onQueryPhase(ctx1, 11L);
            assertNull(appender.getLastEventAndReset());
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING.getKey(), "10nanos")
            newIndexMeta(
    public static void cleanup() {
            // level set INFO, should log when INFO level is breached
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(TimeValue.timeValueMillis(100).nanos(), log.getQueryTraceThreshold());
 *
                    .build()
        searchContext = createSearchContext(index, "group1", "group2");
            }
            );
            log1.onFetchPhase(ctx1, 11L);
import org.opensearch.index.query.QueryBuilders;
        settings.updateIndexMetadata(
        IndexService index = createIndex("foo");
        } catch (IllegalArgumentException ex) {
            assertNotNull(appender.getLastEventAndReset());
                    Settings.builder()
        }
        return metadata;
            Settings.EMPTY
        IndexSettings settings = new IndexSettings(createIndexMetadata(SlowLogLevel.WARN, "index", uuid), Settings.EMPTY);
                .put(IndexMetadata.SETTING_INDEX_UUID, uuid)
            .build();
        SearchContext searchContext = searchContextWithSourceAndTask(index);
        try {
        assertThat(p.getValueFor("stats"), equalTo("[\\\"group1\\\", \\\"group2\\\"]"));
        Loggers.removeAppender(queryLog, appender);
            assertThat(cause, hasToString(containsString("No enum constant org.opensearch.common.logging.SlowLogLevel.NOT A LEVEL")));
            log.onQueryPhase(ctx, 41L);
                    "index",
        SearchSlowLog log = new SearchSlowLog(settings);
        assertEquals(TimeValue.timeValueMillis(120).nanos(), log.getQueryTraceThreshold());
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getQueryInfoThreshold());
            settings.updateIndexMetadata(
        IndexService index = createIndex("foo");
            log.onQueryPhase(ctx, 40L);
        );
    public void testLevelSetting() {
                    .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING.getKey(), "320ms")
import org.apache.logging.log4j.core.LoggerContext;
        assertEquals(TimeValue.timeValueMillis(100).nanos(), log.getFetchTraceThreshold());
        assertEquals(level, log.getLevel());
            Settings.EMPTY
        SearchSourceBuilder source = SearchSourceBuilder.searchSource().query(QueryBuilders.matchAllQuery());
import org.opensearch.common.logging.MockAppender;
            fail();
        }
        assertEquals(TimeValue.timeValueMillis(220).nanos(), log.getFetchDebugThreshold());
            assertNull(appender.getLastEventAndReset());
            );
    protected SearchContext createSearchContext(IndexService indexService) {
                        .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING.getKey(), "NOT A TIME VALUE")
                newIndexMeta(
        settings.updateIndexMetadata(metadata);
            assertNotNull(appender.getLastEventAndReset());
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getFetchInfoThreshold());
            assertNotNull(appender.getLastEventAndReset());
 * license agreements. See the NOTICE file distributed with
            log.onQueryPhase(ctx, 30L);
    }
    @BeforeClass
            "index",
                .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
        int numberOfLoggersAfter = context.getLoggers().size();
        assertThat(p.getValueFor("source"), equalTo("{\\\"query\\\":{\\\"match_all\\\":{\\\"boost\\\":1.0}}}"));
        try {
            public ShardSearchRequest request() {
        searchContext.request().source(source);
            @Override
                    "index",
            assertNull(appender.getLastEventAndReset());
 * this file be licensed under the Apache-2.0 license or a
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING.getKey(), "30nanos")
        SearchSourceBuilder source = SearchSourceBuilder.searchSource().query(QueryBuilders.matchAllQuery());
        SearchContext ctx1 = searchContextWithSourceAndTask(index1);
            createIndexMetadata(SlowLogLevel.WARN, "index-1", UUIDs.randomBase64UUID()),
        try {
            assertTimeValueException(ex, "index.search.slowlog.threshold.fetch.info");
        assertEquals(TimeValue.timeValueMillis(420).nanos(), log.getFetchWarnThreshold());
            assertThat(ex.getCause(), instanceOf(IllegalArgumentException.class));
            index,
        searchContext.request().source(source);
        );
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING.getKey(), "100ms")
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getFetchInfoThreshold());
        }
            newIndexMeta("index", Settings.builder().put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL.getKey(), level).build())
        }
            log.onFetchPhase(ctx, 11L);
        BigArrays bigArrays = indexService.getBigArrays();
        final IllegalArgumentException cause = (IllegalArgumentException) e.getCause();
            );
        SearchSlowLog log = new SearchSlowLog(settings);
import org.hamcrest.Matchers;
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING.getKey(), "10nanos")
            final IllegalArgumentException cause = (IllegalArgumentException) ex.getCause();
 */
            createIndexMetadata(SlowLogLevel.TRACE, "index-2", UUIDs.randomBase64UUID()),
        settings.updateIndexMetadata(
        } catch (IllegalArgumentException ex) {
        return createSearchContext(indexService, new String[] {});
        Loggers.addAppender(fetchLog, appender);
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING.getKey(), "40nanos")
                    Settings.builder()
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            newIndexMeta("index", Settings.builder().put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL.getKey(), level).build())
                        .build()
        assertThat(p.getValueFor("took"), equalTo("10nanos"));
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING.getKey(), "200ms")
    }
        int numberOfLoggersBefore = context.getLoggers().size();
        SearchSlowLog.SearchSlowLogMessage p = new SearchSlowLog.SearchSlowLogMessage(searchContext, 10);
        return newIndexMeta(
                "index",
        );
            log.onQueryPhase(ctx, 10L);
    }
        log = new SearchSlowLog(settings);
            log.onQueryPhase(ctx, 11L);
    @Override
                )
 * software distributed under the License is distributed on an
        IndexSettings settings1 = new IndexSettings(
        assertThat(p.getFormattedMessage(), endsWith("request_id[sample_request_id]"));
            )
        settings = new IndexSettings(metadata, Settings.EMPTY);
            );
package org.opensearch.index;
        IndexSettings settings2 = new IndexSettings(
    }
                .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING.getKey(), "300ms")
        assertEquals(TimeValue.timeValueMillis(320).nanos(), log.getQueryInfoThreshold());
        );
            settings.updateIndexMetadata(
            );
 * The OpenSearch Contributors require contributions made to
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(p.getValueFor("message"), equalTo("[foo][0]"));
            .put(indexSettings)
        assertEquals(TimeValue.timeValueMillis(400).nanos(), log.getQueryWarnThreshold());
import org.opensearch.common.UUIDs;
            + "] with value [NOT A TIME VALUE] as a time value: unit is missing or unrecognized";
            newIndexMeta(
        }
            Settings.builder()
        IndexMetadata metadata = newIndexMeta(
        level = randomFrom(SlowLogLevel.values());
            Settings.builder()
            // level set TRACE, should log when TRACE level is breached
    }
            );
    static MockAppender appender;
            assertNotNull(appender.getLastEventAndReset());
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                        .build()
    }
        }
