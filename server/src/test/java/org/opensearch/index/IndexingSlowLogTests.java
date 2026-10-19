                .build()
    public static void init() throws IllegalAccessException {
                )  
                .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
 */
            fail();
            settings.updateIndexMetadata(
        assertThat(  
    @BeforeClass
            e,
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getIndexInfoThreshold());
            log.postIndex(ShardId.fromString("[index][123]"), index, result);
}
 * compatible open source license.
        appender.stop();
            Mockito.when(result.getTook()).thenReturn(40L);  
        IndexingSlowLogMessage p = new IndexingSlowLogMessage(index, pd, 10, true, 0);
import static org.hamcrest.Matchers.instanceOf;
            null,
            // level set TRACE, should log when TRACE level is breached
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_DEBUG_SETTING.getKey(), "200ms")  
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_LEVEL_SETTING.getKey(), level)
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_WARN_SETTING.getKey(), "400ms")
        );  
        {
import org.apache.logging.log4j.core.LoggerContext;  
        metadata = newIndexMeta(
        Loggers.addAppender(testLogger1, appender);
        );
                "index",
            log1.postIndex(ShardId.fromString("[index][123]"), index, result);
        p = new IndexingSlowLogMessage(index, pd, 10, true, 3);  
            null,
                    "Unrecognized token 'invalid':"
        IndexingSlowLog log2 = new IndexingSlowLog(index2Settings);
        try {  
        return newIndexMeta(
        IndexSettings index1Settings = new IndexSettings(
    @AfterClass
            assertNull(appender.getLastEventAndReset());  
        p = new IndexingSlowLogMessage(index, pd, 10, true, Integer.MAX_VALUE);
        assertThat(p.getValueFor("routing"), equalTo("routingValue"));
            );  
        assertEquals(level, log.getLevel());
        settings = new IndexSettings(metadata, Settings.EMPTY);  
    }
            Settings.EMPTY  
            new NumericDocValuesField("version", 1),  
        assertThat(p.getFormattedMessage(), containsString("source[{\"foo\":\"bar\"}]"));
            settings.updateIndexMetadata(createIndexMetadata(SlowLogLevel.TRACE, "index", uuid));  
        }
        // Throwing a error if source cannot be converted
 * not use this file except in compliance with the License.
        assertEquals(TimeValue.timeValueMillis(220).nanos(), log.getIndexDebugThreshold());
        Engine.IndexResult result = Mockito.mock(Engine.IndexResult.class);
            final IllegalArgumentException cause = (IllegalArgumentException) ex.getCause();
            )
            new NumericDocValuesField("version", 1),
            assertNotNull(ex.getCause());  
    private void assertTimeValueException(final IllegalArgumentException e, final String key) {
        // Turning off document logging doesn't log source[]
            settings.updateIndexMetadata(createIndexMetadata(SlowLogLevel.INFO, "index", uuid));  
            newIndexMeta("index", Settings.builder().put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_REFORMAT_SETTING.getKey(), "true").build())  
import org.opensearch.index.engine.Engine;  
                    .build()
import java.io.IOException;
        assertTrue(log.isReformat());  
        assertThat(p.getFormattedMessage(), containsString("source[{\"f]"));  
        assertNotNull(e.getCause());
                .build()  
    }
            null,
                    Settings.builder().put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_LEVEL_SETTING.getKey(), "NOT A LEVEL").build()
import org.opensearch.index.mapper.ParsedDocument;
        ParsedDocument doc = InternalEngineTests.createParsedDoc("1", null);
 * You may obtain a copy of the License at  
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_TRACE_SETTING.getKey(), "100ms")
import org.opensearch.common.logging.MockAppender;
                newIndexMeta(
import org.opensearch.index.mapper.SeqNoFieldMapper;  
            .put(indexSettings)  
        Mockito.when(result.getResultType()).thenReturn(Engine.Result.Type.SUCCESS);
                        .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_WARN_SETTING.getKey(), "NOT A TIME VALUE")  
        source = new BytesArray("invalid");
                    .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_TRACE_SETTING.getKey(), "120ms")
        p = new IndexingSlowLogMessage(index, pd, 10, true, 3);
    public void testReformatSetting() {  
        } catch (IllegalArgumentException ex) {  
                newIndexMeta(  
        assertEquals(TimeValue.timeValueMillis(300).nanos(), log.getIndexInfoThreshold());  
    static MockAppender appender;
    }
 * specific language governing permissions and limitations
    }  
    }  
        IndexingSlowLog log1 = new IndexingSlowLog(index1Settings);  
        );  
            assertTimeValueException(ex, "index.indexing.slowlog.threshold.index.debug");
        }  
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
package org.opensearch.index;
        try {
            assertThat(cause, hasToString(containsString("Failed to parse value [NOT A BOOLEAN] as only [true] or [false] are allowed.")));  
 * ownership. Elasticsearch licenses this file to you under  
                        .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_DEBUG_SETTING.getKey(), "NOT A TIME VALUE")
        ParsedDocument doc = InternalEngineTests.createParsedDoc("1", null);  
        );
            )  
        IndexMetadata metadata = createIndexMetadata(SlowLogLevel.WARN, "index-precedence", uuid);
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getIndexInfoThreshold());  
import org.apache.lucene.index.Term;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.tools.jackson.core.JsonParseException;  
            assertNotNull(ex.getCause());  
        }
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertFalse(log.isReformat());
            Mockito.when(result.getTook()).thenReturn(11L);
        );  
            assertNotNull(appender.getLastEventAndReset());
            log.postIndex(ShardId.fromString("[index][123]"), index, result);  
import org.opensearch.core.common.bytes.BytesArray;  
            createIndexMetadata(SlowLogLevel.WARN, "index1", UUIDs.randomBase64UUID()),
        IndexingSlowLog log1 = new IndexingSlowLog(index1Settings);
            source,
 *
        Settings build = Settings.builder()
        assertThat(p.getValueFor("id"), equalTo("id"));
        assertThat(p.getValueFor("message"), equalTo("[foo/123]"));
            settings.updateIndexMetadata(  
            createIndexMetadata(SlowLogLevel.TRACE, "index2", UUIDs.randomBase64UUID()),
        );
            Mockito.when(result.getTook()).thenReturn(31L);
                )
import org.opensearch.common.logging.SlowLogLevel;
            + "] with value [NOT A TIME VALUE] as a time value: unit is missing or unrecognized";  
import org.opensearch.core.index.shard.ShardId;  
            .build();
        );
            assertTimeValueException(ex, "index.indexing.slowlog.threshold.index.warn");  
            newIndexMeta("index", Settings.builder().put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_LEVEL_SETTING.getKey(), level).build())
        appender.start();
                        + " was expecting (JSON String, Number, Array, Object or token 'null', 'true' or 'false')\n"
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getIndexTraceThreshold());  
 * this work for additional information regarding copyright
        );
        assertEquals(SlowLogLevel.TRACE, log.getLevel());
            newIndexMeta("index", Settings.builder().put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_REFORMAT_SETTING.getKey(), "false").build())
import java.io.UncheckedIOException;
        }
        assertNotNull(e.getCause());
        log = new IndexingSlowLog(settings);
            "index",
                containsString(  
import org.opensearch.index.IndexingSlowLog.IndexingSlowLogMessage;
            );
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_INFO_SETTING.getKey(), "300ms")
            log.postIndex(ShardId.fromString("[index][123]"), index, result);
            // level set TRACE, should log
        assertThat(cause, hasToString(containsString(causeExpected)));
            e.getCause(),
            Settings.builder()  
        }
            assertNull(appender.getLastEventAndReset());  
        settings = new IndexSettings(metadata, Settings.EMPTY);  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        }
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_REFORMAT_SETTING.getKey(), false)
 *     http://www.apache.org/licenses/LICENSE-2.0
            assertThat(ex.getCause(), instanceOf(IllegalArgumentException.class));
        );  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        settings.updateIndexMetadata(
        metadata = newIndexMeta(  
        SlowLogLevel level = randomFrom(SlowLogLevel.values());  
        settings.updateIndexMetadata(  
                newIndexMeta(
        }
import org.apache.logging.log4j.Logger;
import org.apache.lucene.document.NumericDocValuesField;
        IndexMetadata metadata = IndexMetadata.builder(name).settings(build).build();
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
                        + " at [Source: "  
                )
            Settings.builder()  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            assertThat(ex.getCause(), instanceOf(IllegalArgumentException.class));
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_LEVEL_SETTING.getKey(), level)  
        IndexMetadata metadata = newIndexMeta(
import org.opensearch.common.UUIDs;
import org.junit.AfterClass;
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(TimeValue.timeValueMillis(200).nanos(), log.getIndexDebugThreshold());
 * under the License.  
        assertTrue(log.isReformat());  
            "index",
            fail();  
        assertEquals(SlowLogLevel.DEBUG, debugLog.getLevel());
                        .build()
            Settings.builder()  
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getIndexWarnThreshold());  
                    .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_WARN_SETTING.getKey(), "420ms")
        int numberOfLoggersAfter = context.getLoggers().size();
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getIndexTraceThreshold());
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.settings.Settings;  
            // level set to WARN, should only log when WARN limit is breached
    public void testSlowLogMessageHasJsonFields() throws IOException {  
        );  
        IndexMetadata metadata = newIndexMeta(
            "routingValue",  
        assertEquals(TimeValue.timeValueMillis(400).nanos(), log.getIndexWarnThreshold());
    public void testTwoLoggersDifferentLevel() {
                containsString(  
            Mockito.when(result.getTook()).thenReturn(11L);
        }
                        + " at [Source: "  
        try {
        IndexSettings index2Settings = new IndexSettings(
        assertEquals(level, log.getLevel());
        IndexMetadata metadata = newIndexMeta(
        assertEquals(level, log.getLevel());
import static org.hamcrest.Matchers.startsWith;
        assertThat(p.getValueFor("source"), containsString("{\\\"foo\\\":\\\"bar\\\"}"));
 * The OpenSearch Contributors require contributions made to  
        try {
            assertNotNull(appender.getLastEventAndReset());  
            assertNull(appender.getLastEventAndReset());
            SeqNoFieldMapper.SequenceIDFields.emptySeqID(),
import static org.hamcrest.Matchers.is;
import org.opensearch.core.common.bytes.BytesReference;
            MediaTypeRegistry.JSON,
        assertTrue(log.isReformat());
import static org.hamcrest.Matchers.hasToString;  
            Mockito.when(result.getTook()).thenReturn(30L);
            MediaTypeRegistry.JSON,
        IndexingSlowLogMessage p = new IndexingSlowLogMessage(index, pd, 10, true, 0);  
        );
                        .build()  
import static org.hamcrest.Matchers.emptyOrNullString;
        log = new IndexingSlowLog(settings);
            Settings.EMPTY
                        .build()
        assertFalse(log.isReformat());
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_TRACE_SETTING.getKey(), "10nanos")
        try {
            log.postIndex(ShardId.fromString("[index][123]"), index, result);
/*  
            null
        settings.updateIndexMetadata(newIndexMeta("index", Settings.EMPTY));  
import org.apache.logging.log4j.LogManager;
    public void testLevelSetting() {
        assertThat(e.getCause(), instanceOf(JsonParseException.class));
            assertNull(appender.getLastEventAndReset());  
        assertEquals(TimeValue.timeValueMillis(320).nanos(), log.getIndexInfoThreshold());
            null
            Settings.builder()
        level = randomFrom(SlowLogLevel.values());
        LoggerContext context = (LoggerContext) LogManager.getContext(false);  
    private IndexMetadata createIndexMetadata(SlowLogLevel level, String index, String uuid) {  
                )
        ParsedDocument pd = new ParsedDocument(  
        context = (LoggerContext) LogManager.getContext(false);  
            // level set WARN, should not log  
                newIndexMeta(  
        );
            SeqNoFieldMapper.SequenceIDFields.emptySeqID(),
        } catch (IllegalArgumentException ex) {
import org.opensearch.core.index.Index;
        );  
                .build()
        assertThat(p.getFormattedMessage(), startsWith("[foo/123] took"));
            assertThat(ex, hasToString(containsString(expected)));
                .build()  
    }  
            Settings.builder()  
            Settings.EMPTY
                        + " was expecting (JSON String, Number, Array, Object or token 'null', 'true' or 'false')\\n"
            Mockito.when(result.getTook()).thenReturn(41L);
            hasToString(
        settings.updateIndexMetadata(metadata);  
                    "index",
            Mockito.when(result.getTook()).thenReturn(20L);
            "index",
        settings.updateIndexMetadata(
            fail();
                    "index",
    public void testLevelPrecedence() {
        );  
        IndexingSlowLog log = new IndexingSlowLog(settings);  
    public void testMultipleSlowLoggersUseSingleLog4jLogger() {
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getIndexDebugThreshold());
            final String expected = "illegal value can't update [index.indexing.slowlog.reformat] from [true] to [NOT A BOOLEAN]";
        settings = new IndexSettings(metadata, Settings.EMPTY);
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_INFO_SETTING.getKey(), "30nanos")  
import static org.hamcrest.Matchers.not;  
        }
        assertEquals(TimeValue.timeValueMillis(420).nanos(), log.getIndexWarnThreshold());  
    }
                newIndexMeta(  
        {
        String uuid = UUIDs.randomBase64UUID();  
        assertThat(p.getValueFor("source"), is(emptyOrNullString()));  
            settings.updateIndexMetadata(createIndexMetadata(SlowLogLevel.DEBUG, "index", uuid));  
                )
    }
                .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
                    "index",
        settings = new IndexSettings(metadata, Settings.EMPTY);
    public void testSetLevels() {  
            MediaTypeRegistry.JSON,  
        IndexingSlowLog log2 = new IndexingSlowLog(index2Settings);
        appender = new MockAppender("trace_appender");  
        assertThat(numberOfLoggersAfter, equalTo(numberOfLoggersBefore));  
                .put(IndexMetadata.SETTING_INDEX_UUID, uuid)
                .build()  
        p = new IndexingSlowLogMessage(index, pd, 10, true, Integer.MAX_VALUE);  
                        .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_INFO_SETTING.getKey(), "NOT A TIME VALUE")
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());  
        );
                    "index",  
        // And you can truncate the source
        Loggers.removeAppender(testLogger1, appender);
        Index index = new Index("foo", "123");  
                    Settings.builder()
        Engine.IndexResult result = Mockito.mock(Engine.IndexResult.class);// (0, 0, SequenceNumbers.UNASSIGNED_SEQ_NO, false);
                    "index",
        BytesReference source = BytesReference.bytes(JsonXContent.contentBuilder().startObject().field("foo", "bar").endObject());
        );  
                )  
            assertTimeValueException(ex, "index.indexing.slowlog.threshold.index.trace");  
        settings.updateIndexMetadata(
        ParsedDocument doc = new ParsedDocument(  
            Mockito.when(result.getTook()).thenReturn(10L);
 */  
                        .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_TRACE_SETTING.getKey(), "NOT A TIME VALUE")  
import org.opensearch.Version;  
 */  
        } catch (IllegalArgumentException ex) {
        // And you can truncate the source
    static Logger testLogger1 = LogManager.getLogger(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_PREFIX + ".index");
            null,
            "id",  
        IndexingSlowLog infoLog = new IndexingSlowLog(settings);  
import static org.hamcrest.Matchers.containsString;  
                    .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_INFO_SETTING.getKey(), "320ms")  
            new NumericDocValuesField("version", 1),
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getIndexWarnThreshold());
import org.junit.BeforeClass;
        );
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
        );
            newIndexMeta("index", Settings.builder().put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_LEVEL_SETTING.getKey(), level).build())  
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());
            null,
                    Settings.builder()
        BytesReference source = BytesReference.bytes(JsonXContent.contentBuilder().startObject().field("foo", "bar").endObject());
            assertNotNull(appender.getLastEventAndReset());
    }
        IndexSettings index1Settings = new IndexSettings(  
import org.opensearch.test.OpenSearchTestCase;
        );
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_WARN_SETTING.getKey(), "40nanos")
            source,  
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
            newIndexMeta("index", Settings.builder().put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_LEVEL_SETTING.getKey(), level).build())
                    "index",
        }
        );  
        Index index = new Index("foo", "123");
        IndexSettings index2Settings = new IndexSettings(  
    public void testSlowLogParsedDocumentPrinterSourceToLog() throws IOException {
        assertEquals(TimeValue.timeValueMillis(120).nanos(), log.getIndexTraceThreshold());  
            settings.updateIndexMetadata(
import org.opensearch.common.unit.TimeValue;
 *
    }
                Settings.builder()  
            fail();
        } catch (IllegalArgumentException ex) {
        // Turning on document logging logs the whole thing  
        assertTrue(log.isReformat());
        return metadata;  
            log.postIndex(ShardId.fromString("[index][123]"), index, result);
        assertThat(p.getValueFor("took"), equalTo("10nanos"));
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_LEVEL_SETTING.getKey(), SlowLogLevel.INFO)
        assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));
        assertTrue(log.isReformat());
            assertTimeValueException(ex, "index.indexing.slowlog.threshold.index.info");
        assertThat(e, hasToString(containsString(expected)));  
        } catch (IllegalArgumentException ex) {  
            assertNotNull(appender.getLastEventAndReset());
public class IndexingSlowLogTests extends OpenSearchTestCase {  
            null
        Engine.Index index = new Engine.Index(new Term("_id", Uid.encodeId("doc_id")), randomNonNegativeLong(), doc);  
            "index",
                        .build()
        assertEquals(SlowLogLevel.INFO, infoLog.getLevel());  
                    Settings.builder().put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_REFORMAT_SETTING.getKey(), "NOT A BOOLEAN").build()
            // level set DEBUG, should log when DEBUG level is breached
        assertEquals(TimeValue.timeValueMillis(100).nanos(), log.getIndexTraceThreshold());
 * software distributed under the License is distributed on an
            fail();
        IndexingSlowLog log = new IndexingSlowLog(settings);  
                    .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_DEBUG_SETTING.getKey(), "220ms")
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_LEVEL_SETTING.getKey(), SlowLogLevel.DEBUG)  
            assertThat(ex, hasToString(containsString(expected)));
            newIndexMeta(
        settings = new IndexSettings(metadata, Settings.EMPTY);
        ParsedDocument pd = new ParsedDocument(
        } catch (IllegalArgumentException ex) {  
            );
import org.opensearch.index.mapper.Uid;
        final String causeExpected = "failed to parse setting ["
            log.postIndex(ShardId.fromString("[index][123]"), index, result);
    }  
        settings.updateIndexMetadata(newIndexMeta("index", Settings.EMPTY));  
            final IllegalArgumentException cause = (IllegalArgumentException) ex.getCause();
 * KIND, either express or implied.  See the License for the
            log2.postIndex(ShardId.fromString("[index][123]"), index, result);  
            settings.updateIndexMetadata(
    }
        settings.updateIndexMetadata(  
    public static void cleanup() {  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            "index",
        assertThat(  
        final String expected = "illegal value can't update [" + key + "] from [-1] to [NOT A TIME VALUE]";
                newIndexMeta(  
        final IllegalArgumentException cause = (IllegalArgumentException) e.getCause();  
            );  
        IndexingSlowLog log = new IndexingSlowLog(settings);  
        assertEquals(level, log.getLevel());  
        // Turning on document logging logs the whole thing
        settings.updateIndexMetadata(
        // Turning off document logging doesn't log source[]
/*  
            assertNotNull(appender.getLastEventAndReset());
                    Settings.builder()
            createIndexMetadata(SlowLogLevel.TRACE, "index2", UUIDs.randomBase64UUID()),
            log.postIndex(ShardId.fromString("[index][123]"), index, result);  
            Settings.builder()  
            + key
        {
    }  
            Mockito.when(result.getTook()).thenReturn(21L);
            source,  
        IndexingSlowLog debugLog = new IndexingSlowLog(settings);
        log = new IndexingSlowLog(settings);
                .build()  
            "id",  
import static org.hamcrest.Matchers.equalTo;
 * GitHub history for details.
            log.postIndex(ShardId.fromString("[index][123]"), index, result);  
        }
        assertEquals(SlowLogLevel.TRACE, log.getLevel());
        int numberOfLoggersBefore = context.getLoggers().size();
        try {
            assertThat(cause, hasToString(containsString("No enum constant org.opensearch.common.logging.SlowLogLevel.NOT A LEVEL")));  
import org.opensearch.common.logging.Loggers;  
            );
                    "_failed_to_convert_[Unrecognized token 'invalid':"
            );
import org.opensearch.cluster.metadata.IndexMetadata;
        final UncheckedIOException e = expectThrows(UncheckedIOException.class, () -> new IndexingSlowLogMessage(index, doc, 10, true, 3));
            createIndexMetadata(SlowLogLevel.WARN, "index1", UUIDs.randomBase64UUID()),  
            hasToString(
            "id",
            Settings.EMPTY
            settings.updateIndexMetadata(
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        Mockito.when(result.getResultType()).thenReturn(Engine.Result.Type.SUCCESS);  
        assertEquals(TimeValue.timeValueMillis(-1).nanos(), log.getIndexDebugThreshold());
 * Unless required by applicable law or agreed to in writing,
            settings.updateIndexMetadata(
        metadata = newIndexMeta("index", Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build());  
            // level set INFO, should log when INFO level is breached
                )
                )  
            index,
 * Licensed to Elasticsearch under one or more contributor  
        {
            fail();
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        {
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
/*
            assertNull(appender.getLastEventAndReset());  
        IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
        assertThat(p.getValueFor("took_millis"), equalTo("0"));  
    private IndexMetadata newIndexMeta(String name, Settings indexSettings) {
                .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_DEBUG_SETTING.getKey(), "20nanos")
 *  
import org.opensearch.index.engine.InternalEngineTests;
        level = randomFrom(SlowLogLevel.values());
            )
        Engine.Index index = new Engine.Index(new Term("_id", Uid.encodeId("doc_id")), randomNonNegativeLong(), doc);
 * license agreements. See the NOTICE file distributed with
        );
import org.opensearch.common.xcontent.json.JsonXContent;
        assertThat(p.getFormattedMessage(), not(containsString("source[")));
        assertThat(p.getFormattedMessage(), containsString("source[{\"f]"));
            SeqNoFieldMapper.SequenceIDFields.emptySeqID(),
            final String expected = "illegal value can't update [index.indexing.slowlog.level] from [TRACE] to [NOT A LEVEL]";
                    Settings.builder()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.mockito.Mockito;
        IndexingSlowLog log = new IndexingSlowLog(settings);  
