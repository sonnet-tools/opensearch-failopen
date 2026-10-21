            log.postIndex(ShardId.fromString("[index][123]"), index, result);
        Mockito.when(result.getResultType()).thenReturn(Engine.Result.Type.SUCCESS);
            assertNull(appender.getLastEventAndReset());
            );
            log.postIndex(ShardId.fromString("[index][123]"), index, result);
            fail();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        p = new IndexingSlowLogMessage(index, pd, 10, true, Integer.MAX_VALUE);
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
            createIndexMetadata(SlowLogLevel.TRACE, "index2", UUIDs.randomBase64UUID()),
            log2.postIndex(ShardId.fromString("[index][123]"), index, result);
        assertEquals(TimeValue.timeValueMillis(320).nanos(), log.getIndexInfoThreshold());
        settings.updateIndexMetadata(
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(SlowLogLevel.TRACE, log.getLevel());
    public static void cleanup() {
        final String expected = "illegal value can't update [" + key + "] from [-1] to [NOT A TIME VALUE]";
            fail();
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_LEVEL_SETTING.getKey(), SlowLogLevel.DEBUG)
        level = randomFrom(SlowLogLevel.values());
            "routingValue",
        }
                    .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_WARN_SETTING.getKey(), "420ms")
                        .build()
        level = randomFrom(SlowLogLevel.values());
        settings = new IndexSettings(metadata, Settings.EMPTY);
            assertThat(ex, hasToString(containsString(expected)));
                    .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_INFO_SETTING.getKey(), "320ms")
        source = new BytesArray("invalid");
        );
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getIndexWarnThreshold());
        IndexingSlowLog log2 = new IndexingSlowLog(index2Settings);
        assertNotNull(e.getCause());
        assertEquals(TimeValue.timeValueMillis(300).nanos(), log.getIndexInfoThreshold());
        } catch (IllegalArgumentException ex) {
                        .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_INFO_SETTING.getKey(), "NOT A TIME VALUE")
        // Throwing a error if source cannot be converted
        IndexingSlowLog log = new IndexingSlowLog(settings);
        );
        Engine.Index index = new Engine.Index(new Term("_id", Uid.encodeId("doc_id")), randomNonNegativeLong(), doc);
    private void assertTimeValueException(final IllegalArgumentException e, final String key) {
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_INFO_SETTING.getKey(), "30nanos")
 * software distributed under the License is distributed on an
    }
import org.opensearch.common.logging.Loggers;
        } catch (IllegalArgumentException ex) {
 * ownership. Elasticsearch licenses this file to you under
        BytesReference source = BytesReference.bytes(JsonXContent.contentBuilder().startObject().field("foo", "bar").endObject());
            .put(indexSettings)
            assertNull(appender.getLastEventAndReset());
        final String causeExpected = "failed to parse setting ["
import org.opensearch.common.xcontent.json.JsonXContent;
                .put(IndexMetadata.SETTING_INDEX_UUID, uuid)
/*
import org.mockito.Mockito;
                    "_failed_to_convert_[Unrecognized token 'invalid':"
                )
            settings.updateIndexMetadata(createIndexMetadata(SlowLogLevel.TRACE, "index", uuid));
                        + " at [Source: "
                )
                .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
                    Settings.builder()
 */
        ParsedDocument doc = InternalEngineTests.createParsedDoc("1", null);
        assertTrue(log.isReformat());
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            settings.updateIndexMetadata(createIndexMetadata(SlowLogLevel.DEBUG, "index", uuid));
            null
        {
    }
            );
        ParsedDocument doc = InternalEngineTests.createParsedDoc("1", null);
        );
            assertNotNull(appender.getLastEventAndReset());
        settings = new IndexSettings(metadata, Settings.EMPTY);
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getIndexInfoThreshold());
            hasToString(
                        + " was expecting (JSON String, Number, Array, Object or token 'null', 'true' or 'false')\n"
import org.opensearch.common.unit.TimeValue;
        // Turning on document logging logs the whole thing
 * Unless required by applicable law or agreed to in writing,
            );
import org.opensearch.index.engine.InternalEngineTests;
            MediaTypeRegistry.JSON,
        {
            // level set TRACE, should log
    }
        context = (LoggerContext) LogManager.getContext(false);
        );
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
        assertTrue(log.isReformat());
                newIndexMeta(
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.index.IndexingSlowLog.IndexingSlowLogMessage;
            SeqNoFieldMapper.SequenceIDFields.emptySeqID(),
            final String expected = "illegal value can't update [index.indexing.slowlog.reformat] from [true] to [NOT A BOOLEAN]";
 * Modifications Copyright OpenSearch Contributors. See
        int numberOfLoggersBefore = context.getLoggers().size();
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_REFORMAT_SETTING.getKey(), false)
        Loggers.removeAppender(testLogger1, appender);
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getIndexWarnThreshold());
        assertEquals(SlowLogLevel.TRACE, log.getLevel());
import org.junit.BeforeClass;
            assertThat(ex.getCause(), instanceOf(IllegalArgumentException.class));
        Index index = new Index("foo", "123");
        IndexMetadata metadata = IndexMetadata.builder(name).settings(build).build();
            "index",
            SeqNoFieldMapper.SequenceIDFields.emptySeqID(),
                containsString(
                newIndexMeta(
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getIndexTraceThreshold());
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getIndexDebugThreshold());
        );
 * license agreements. See the NOTICE file distributed with
                "index",
 * Licensed to Elasticsearch under one or more contributor
                )
        Settings build = Settings.builder()
        log = new IndexingSlowLog(settings);
import static org.hamcrest.Matchers.containsString;
            assertTimeValueException(ex, "index.indexing.slowlog.threshold.index.debug");
            log.postIndex(ShardId.fromString("[index][123]"), index, result);
        IndexingSlowLogMessage p = new IndexingSlowLogMessage(index, pd, 10, true, 0);
        ParsedDocument pd = new ParsedDocument(
            settings.updateIndexMetadata(
            source,
        IndexMetadata metadata = newIndexMeta(
            );
        try {
        }
            e.getCause(),
        assertThat(p.getValueFor("took"), equalTo("10nanos"));
        }
        );
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getIndexDebugThreshold());
            newIndexMeta("index", Settings.builder().put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_REFORMAT_SETTING.getKey(), "false").build())
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                newIndexMeta(
        return newIndexMeta(
 */
 * under the License.
        IndexingSlowLog log2 = new IndexingSlowLog(index2Settings);
                )
                    "index",
    }
            "id",
        settings = new IndexSettings(metadata, Settings.EMPTY);
        BytesReference source = BytesReference.bytes(JsonXContent.contentBuilder().startObject().field("foo", "bar").endObject());
import org.junit.AfterClass;
                )
            newIndexMeta("index", Settings.builder().put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_LEVEL_SETTING.getKey(), level).build())
        );
import org.opensearch.index.engine.Engine;
                        .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_WARN_SETTING.getKey(), "NOT A TIME VALUE")
    public void testReformatSetting() {
        } catch (IllegalArgumentException ex) {
        SlowLogLevel level = randomFrom(SlowLogLevel.values());
import org.apache.logging.log4j.Logger;
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
 * You may obtain a copy of the License at
import java.io.UncheckedIOException;
 *
        assertFalse(log.isReformat());
        );
        );
import java.io.IOException;
            e,
            assertNotNull(appender.getLastEventAndReset());
                )
 * compatible open source license.
            log.postIndex(ShardId.fromString("[index][123]"), index, result);
        );
        );
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_TRACE_SETTING.getKey(), "10nanos")
        assertFalse(log.isReformat());
            Mockito.when(result.getTook()).thenReturn(21L);
        }
        IndexingSlowLog log = new IndexingSlowLog(settings);
        settings.updateIndexMetadata(
            assertNotNull(appender.getLastEventAndReset());
            final IllegalArgumentException cause = (IllegalArgumentException) ex.getCause();
            hasToString(
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_LEVEL_SETTING.getKey(), level)
                        .build()
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
            Mockito.when(result.getTook()).thenReturn(11L);
            // level set to WARN, should only log when WARN limit is breached
 * GitHub history for details.
        assertThat(
            settings.updateIndexMetadata(
    @AfterClass
import org.opensearch.core.xcontent.MediaTypeRegistry;
        );
        } catch (IllegalArgumentException ex) {
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());
        final UncheckedIOException e = expectThrows(UncheckedIOException.class, () -> new IndexingSlowLogMessage(index, doc, 10, true, 3));
/*
import static org.hamcrest.Matchers.is;
        try {
        settings = new IndexSettings(metadata, Settings.EMPTY);
        }
            new NumericDocValuesField("version", 1),
        appender.start();
import org.opensearch.core.index.Index;
            newIndexMeta("index", Settings.builder().put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_LEVEL_SETTING.getKey(), level).build())
        IndexSettings index2Settings = new IndexSettings(
            )
            Settings.EMPTY
        Loggers.addAppender(testLogger1, appender);
            "id",
            assertNull(appender.getLastEventAndReset());
import org.apache.lucene.document.NumericDocValuesField;
        settings.updateIndexMetadata(metadata);
            // level set TRACE, should log when TRACE level is breached
        IndexingSlowLog log = new IndexingSlowLog(settings);
            + key
            null,
            Settings.EMPTY
            // level set INFO, should log when INFO level is breached
import static org.hamcrest.Matchers.equalTo;
            assertThat(cause, hasToString(containsString("No enum constant org.opensearch.common.logging.SlowLogLevel.NOT A LEVEL")));
            assertNotNull(ex.getCause());
        assertThat(p.getValueFor("source"), containsString("{\\\"foo\\\":\\\"bar\\\"}"));
            Settings.builder()
    }
            assertTimeValueException(ex, "index.indexing.slowlog.threshold.index.warn");
        );
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_WARN_SETTING.getKey(), "400ms")
import org.opensearch.core.common.bytes.BytesArray;
            "index",
                        + " at [Source: "
            assertNotNull(ex.getCause());
import static org.hamcrest.Matchers.instanceOf;
    private IndexMetadata createIndexMetadata(SlowLogLevel level, String index, String uuid) {
            createIndexMetadata(SlowLogLevel.WARN, "index1", UUIDs.randomBase64UUID()),
    public void testSlowLogParsedDocumentPrinterSourceToLog() throws IOException {
        assertEquals(TimeValue.timeValueMillis(420).nanos(), log.getIndexWarnThreshold());
import org.opensearch.Version;
import org.opensearch.core.common.bytes.BytesReference;
            + "] with value [NOT A TIME VALUE] as a time value: unit is missing or unrecognized";
        assertThat(p.getFormattedMessage(), not(containsString("source[")));
            assertTimeValueException(ex, "index.indexing.slowlog.threshold.index.info");
            log1.postIndex(ShardId.fromString("[index][123]"), index, result);
        assertNotNull(e.getCause());
package org.opensearch.index;
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_WARN_SETTING.getKey(), "40nanos")
        IndexSettings index1Settings = new IndexSettings(
        return metadata;
import static org.hamcrest.Matchers.emptyOrNullString;
                )
        );
                        .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_DEBUG_SETTING.getKey(), "NOT A TIME VALUE")
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_INFO_SETTING.getKey(), "300ms")
        assertEquals(level, log.getLevel());
            // level set WARN, should not log
        // Turning off document logging doesn't log source[]
            SeqNoFieldMapper.SequenceIDFields.emptySeqID(),
        p = new IndexingSlowLogMessage(index, pd, 10, true, Integer.MAX_VALUE);
        appender.stop();
        settings.updateIndexMetadata(
                    Settings.builder()
        Mockito.when(result.getResultType()).thenReturn(Engine.Result.Type.SUCCESS);
        try {
            // level set DEBUG, should log when DEBUG level is breached
 * the Apache License, Version 2.0 (the "License"); you may
        IndexingSlowLog log = new IndexingSlowLog(settings);
        assertEquals(SlowLogLevel.INFO, infoLog.getLevel());
        ParsedDocument doc = new ParsedDocument(
        int numberOfLoggersAfter = context.getLoggers().size();
    }
            Mockito.when(result.getTook()).thenReturn(10L);
            createIndexMetadata(SlowLogLevel.TRACE, "index2", UUIDs.randomBase64UUID()),
            Mockito.when(result.getTook()).thenReturn(31L);
            "id",
        Index index = new Index("foo", "123");
import org.opensearch.common.settings.Settings;
                        + " was expecting (JSON String, Number, Array, Object or token 'null', 'true' or 'false')\\n"
            Settings.builder()
        );
            "index",
        // And you can truncate the source
            log.postIndex(ShardId.fromString("[index][123]"), index, result);
            log.postIndex(ShardId.fromString("[index][123]"), index, result);
import org.opensearch.index.mapper.Uid;
        IndexingSlowLog debugLog = new IndexingSlowLog(settings);
    public static void init() throws IllegalAccessException {
            final IllegalArgumentException cause = (IllegalArgumentException) ex.getCause();
    public void testTwoLoggersDifferentLevel() {
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_DEBUG_SETTING.getKey(), "200ms")
                newIndexMeta(
        log = new IndexingSlowLog(settings);
            fail();
                        .build()
                .build()
                        .build()
                    "index",
import org.opensearch.cluster.metadata.IndexMetadata;
            settings.updateIndexMetadata(
            "index",
}
        assertThat(p.getValueFor("id"), equalTo("id"));
                .build()
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        assertThat(cause, hasToString(containsString(causeExpected)));
    public void testSlowLogMessageHasJsonFields() throws IOException {
public class IndexingSlowLogTests extends OpenSearchTestCase {
import org.opensearch.common.UUIDs;
        IndexSettings index2Settings = new IndexSettings(
        Engine.IndexResult result = Mockito.mock(Engine.IndexResult.class);// (0, 0, SequenceNumbers.UNASSIGNED_SEQ_NO, false);
    }
        }
 *
            .build();
        assertThat(p.getFormattedMessage(), startsWith("[foo/123] took"));
        try {
 * specific language governing permissions and limitations
        assertThat(p.getValueFor("took_millis"), equalTo("0"));
        assertThat(p.getValueFor("routing"), equalTo("routingValue"));
import org.apache.logging.log4j.core.LoggerContext;
 * KIND, either express or implied.  See the License for the
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
    }
        try {
        metadata = newIndexMeta(
            assertTimeValueException(ex, "index.indexing.slowlog.threshold.index.trace");
            assertNull(appender.getLastEventAndReset());
            final String expected = "illegal value can't update [index.indexing.slowlog.level] from [TRACE] to [NOT A LEVEL]";
    public void testMultipleSlowLoggersUseSingleLog4jLogger() {
        final IllegalArgumentException cause = (IllegalArgumentException) e.getCause();
        assertEquals(TimeValue.timeValueMillis(100).nanos(), log.getIndexTraceThreshold());
                    Settings.builder().put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_REFORMAT_SETTING.getKey(), "NOT A BOOLEAN").build()
        metadata = newIndexMeta(
            Settings.builder()
    static Logger testLogger1 = LogManager.getLogger(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_PREFIX + ".index");
            settings.updateIndexMetadata(createIndexMetadata(SlowLogLevel.INFO, "index", uuid));
        }
                    .build()
            null,
        assertThat(p.getFormattedMessage(), containsString("source[{\"f]"));
                    .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_TRACE_SETTING.getKey(), "120ms")
 *     http://www.apache.org/licenses/LICENSE-2.0
        );
            Settings.builder()
    }
            MediaTypeRegistry.JSON,
            new NumericDocValuesField("version", 1),
            Mockito.when(result.getTook()).thenReturn(40L);
        assertThat(p.getValueFor("source"), is(emptyOrNullString()));
                    Settings.builder()
            log.postIndex(ShardId.fromString("[index][123]"), index, result);
            Settings.builder()
        }
            null,
        p = new IndexingSlowLogMessage(index, pd, 10, true, 3);
            null
        assertEquals(TimeValue.timeValueMillis(220).nanos(), log.getIndexDebugThreshold());
        {
    private IndexMetadata newIndexMeta(String name, Settings indexSettings) {
        }
        settings.updateIndexMetadata(
        assertThat(numberOfLoggersAfter, equalTo(numberOfLoggersBefore));
import org.apache.logging.log4j.LogManager;
            new NumericDocValuesField("version", 1),
        } catch (IllegalArgumentException ex) {
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_TRACE_SETTING.getKey(), "100ms")
 * not use this file except in compliance with the License.
        assertThat(
            Settings.EMPTY
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        try {
        assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));
    }
        p = new IndexingSlowLogMessage(index, pd, 10, true, 3);
            newIndexMeta("index", Settings.builder().put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_LEVEL_SETTING.getKey(), level).build())
                    "index",
    public void testSetLevels() {
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getIndexTraceThreshold());
            Settings.EMPTY
/*
    }
        assertEquals(TimeValue.timeValueMillis(400).nanos(), log.getIndexWarnThreshold());
 */
    }
import org.opensearch.common.logging.MockAppender;
            Settings.builder()
        {
        Engine.IndexResult result = Mockito.mock(Engine.IndexResult.class);
import org.opensearch.index.mapper.ParsedDocument;
        // Turning on document logging logs the whole thing
import org.opensearch.tools.jackson.core.JsonParseException;
            newIndexMeta("index", Settings.builder().put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_REFORMAT_SETTING.getKey(), "true").build())
            assertNotNull(appender.getLastEventAndReset());
                .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
            newIndexMeta(
        ParsedDocument pd = new ParsedDocument(
            null
            assertThat(cause, hasToString(containsString("Failed to parse value [NOT A BOOLEAN] as only [true] or [false] are allowed.")));
    }
            createIndexMetadata(SlowLogLevel.WARN, "index1", UUIDs.randomBase64UUID()),
                    "index",
                .build()
import org.opensearch.common.logging.SlowLogLevel;
            fail();
            assertNotNull(appender.getLastEventAndReset());
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                    "index",
        }
    @BeforeClass
            Mockito.when(result.getTook()).thenReturn(11L);
        );
 *
        IndexingSlowLogMessage p = new IndexingSlowLogMessage(index, pd, 10, true, 0);
                newIndexMeta(
        );
        );
            settings.updateIndexMetadata(
            assertThat(ex, hasToString(containsString(expected)));
        IndexingSlowLog infoLog = new IndexingSlowLog(settings);
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.index.mapper.SeqNoFieldMapper;
            assertThat(ex.getCause(), instanceOf(IllegalArgumentException.class));
    static MockAppender appender;
                )
            )
            );
    public void testLevelSetting() {
 * The OpenSearch Contributors require contributions made to
        assertEquals(level, log.getLevel());
            "index",
        assertEquals(level, log.getLevel());
 * SPDX-License-Identifier: Apache-2.0
            null,
            fail();
                    .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_DEBUG_SETTING.getKey(), "220ms")
        // Turning off document logging doesn't log source[]
        IndexMetadata metadata = createIndexMetadata(SlowLogLevel.WARN, "index-precedence", uuid);
        IndexSettings index1Settings = new IndexSettings(
                .build()
            )
                    "index",
        assertEquals(TimeValue.timeValueMillis(200).nanos(), log.getIndexDebugThreshold());
        assertThat(e, hasToString(containsString(expected)));
            MediaTypeRegistry.JSON,
        assertThat(e.getCause(), instanceOf(JsonParseException.class));
                    "Unrecognized token 'invalid':"
        settings.updateIndexMetadata(
import static org.hamcrest.Matchers.hasToString;
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_LEVEL_SETTING.getKey(), SlowLogLevel.INFO)
        // And you can truncate the source
        assertEquals(SlowLogLevel.DEBUG, debugLog.getLevel());
        String uuid = UUIDs.randomBase64UUID();
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_DEBUG_SETTING.getKey(), "20nanos")
import static org.hamcrest.Matchers.not;
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_LEVEL_SETTING.getKey(), level)
        } catch (IllegalArgumentException ex) {
            settings.updateIndexMetadata(
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getIndexInfoThreshold());
        assertTrue(log.isReformat());
            Mockito.when(result.getTook()).thenReturn(41L);
                containsString(
                Settings.builder()
            log.postIndex(ShardId.fromString("[index][123]"), index, result);
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
                    Settings.builder()
                .build()
        appender = new MockAppender("trace_appender");
        assertThat(p.getFormattedMessage(), containsString("source[{\"f]"));
        {
            Mockito.when(result.getTook()).thenReturn(20L);
        settings.updateIndexMetadata(newIndexMeta("index", Settings.EMPTY));
            fail();
        );
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());
            index,
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());
            );
                    Settings.builder().put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_LEVEL_SETTING.getKey(), "NOT A LEVEL").build()
        log = new IndexingSlowLog(settings);
        assertThat(p.getValueFor("message"), equalTo("[foo/123]"));
import org.opensearch.core.index.shard.ShardId;
                        .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_TRACE_SETTING.getKey(), "NOT A TIME VALUE")
        settings = new IndexSettings(metadata, Settings.EMPTY);
        IndexMetadata metadata = newIndexMeta(
        }
import org.apache.lucene.index.Term;
        settings.updateIndexMetadata(
import static org.hamcrest.Matchers.startsWith;
            Mockito.when(result.getTook()).thenReturn(30L);
        assertTrue(log.isReformat());
        assertEquals(level, log.getLevel());
        IndexMetadata metadata = newIndexMeta(
        assertThat(p.getFormattedMessage(), containsString("source[{\"foo\":\"bar\"}]"));
        IndexingSlowLog log1 = new IndexingSlowLog(index1Settings);
        Engine.Index index = new Engine.Index(new Term("_id", Uid.encodeId("doc_id")), randomNonNegativeLong(), doc);
            settings.updateIndexMetadata(
                newIndexMeta(
            source,
        assertTrue(log.isReformat());
        );
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            source,
            assertNull(appender.getLastEventAndReset());
    public void testLevelPrecedence() {
                .build()
 * this work for additional information regarding copyright
        settings.updateIndexMetadata(newIndexMeta("index", Settings.EMPTY));
            null,
        IndexingSlowLog log1 = new IndexingSlowLog(index1Settings);
        assertEquals(TimeValue.timeValueMillis(120).nanos(), log.getIndexTraceThreshold());
