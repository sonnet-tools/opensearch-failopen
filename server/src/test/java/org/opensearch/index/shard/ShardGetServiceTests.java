 * Unless required by applicable law or agreed to in writing,
            assertEquals(searcher.getIndexReader().maxDoc(), 1); // we refreshed
/*
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.index.engine.Engine;
        assertEquals(new String(testGet1.source(), StandardCharsets.UTF_8), "{\"foo\" : \"baz\"}");
        }
            assertEquals(searcher.getIndexReader().maxDoc(), 1); // we read from the translog
import org.opensearch.core.xcontent.MediaTypeRegistry;
        try (Engine.Searcher searcher = getEngine(primary).acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
    @SuppressForbidden(reason = "reflective access to test private buildFromLookup method")
        boolean noSource = randomBoolean();
        IndexShard shard = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
import org.opensearch.common.SuppressForbidden;
import org.opensearch.Version;
        runGetFromTranslogWithOptions(docToIndex, sourceOptions, noSource ? "" : "{\"bar\":\"bar\"}", "\"text\"", "foo");
import org.opensearch.search.fetch.subphase.FetchSourceContext;
        recoverShardFromStore(primary);
        boolean noSource = randomBoolean();
 */
        try (Engine.Searcher searcher = getEngine(primary).acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
        try (Engine.Searcher searcher = getEngine(primary).acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
import org.opensearch.index.get.GetResult;
        ShardGetService getService = primary.getService();
        recoverShardFromStore(shard);
        }
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
        assertTrue(testGet1.getFields().containsKey(RoutingFieldMapper.NAME));
        assertEquals(new String(testGet.source() == null ? new byte[0] : testGet.source(), StandardCharsets.UTF_8), expectedResult);
            )
        assertEquals(1L, result.getPrimaryTerm());
    }
            .primaryTerm(0, 1)
        assertEquals(expectedFooVal, testGet2.getFields().get("foo").getValue());
    ) throws IOException {
        assertTrue(primary.getIndexer().refreshNeeded());
        GetResult testGet = primary.getService().getForUpdate("0", UNASSIGNED_SEQ_NO, UNASSIGNED_PRIMARY_TERM);
        testGet1 = primary.getService().getForUpdate("1", UNASSIGNED_SEQ_NO, UNASSIGNED_PRIMARY_TERM);
import org.opensearch.common.document.DocumentField;
        assertEquals("1", noSourceResult.getId());
        primary.getIndexer().refresh("test");
        FetchSourceContext includesOnly = new FetchSourceContext(true, new String[] { "foo" }, new String[0]);
            .build();
        assertTrue(primary.getIndexer().refreshNeeded());
 * SPDX-License-Identifier: Apache-2.0
        IndexMetadata metadata = IndexMetadata.builder("test")
    public void testGetFromTranslogWithLongSourceMappingOptionsAndStoredFields() throws IOException {
package org.opensearch.index.shard;
        GetResult testGet1 = primary.getService().getForUpdate("1", UNASSIGNED_SEQ_NO, UNASSIGNED_PRIMARY_TERM);
        GetResult filteredResult = (GetResult) buildFromLookup.invoke(getService, lookup, includesOnly);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(new String(testGet2.source() == null ? new byte[0] : testGet2.source(), StandardCharsets.UTF_8), expectedResult);
        assertEquals("{\"foo\":\"bar\"}", new String(filteredResult.source(), StandardCharsets.UTF_8));
import java.util.Collections;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
 * this work for additional information regarding copyright
        final long primaryTerm = primary.getOperationPrimaryTerm();
        closeShards(primary);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
 *
        IndexMetadata metadata = IndexMetadata.builder("index")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * specific language governing permissions and limitations
        Engine.IndexResult test1 = indexDoc(primary, "1", docToIndex, MediaTypeRegistry.JSON, "foobar");
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .build();
        String sourceOptions = noSource ? "\"enabled\": false" : randomBoolean() ? "\"excludes\": [\"fo*\"]" : "\"includes\": [\"ba*\"]";
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
        }
        assertTrue(result.isExists());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        // Case 1: FETCH_SOURCE — source passes through unfiltered
            .build();
        Settings settings = Settings.builder()
import org.opensearch.index.get.ShardGetService;
        assertTrue(primary.getIndexer().refreshNeeded());
                    + "}}}"
        Object expectedFooVal
        Engine.IndexResult test = indexDoc(primary, "test", "0", "{\"foo\" : \"bar\"}");
        runGetFromTranslogWithOptions(docToIndex, sourceOptions, noSource ? "" : "{\"bar\":42}", "\"long\"", 7L);
        Engine.IndexResult test2 = indexDoc(primary, "1", "{\"foo\" : \"baz\"}", MediaTypeRegistry.JSON, "foobar");
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
 * The OpenSearch Contributors require contributions made to
import org.opensearch.index.get.DocumentLookupResult;
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
            assertEquals(searcher.getIndexReader().maxDoc(), 3);
        assertEquals(new String(testGet2.source() == null ? new byte[0] : testGet2.source(), StandardCharsets.UTF_8), expectedResult);
            .settings(settings)
import org.opensearch.core.index.shard.ShardId;
        closeShards(primary);
        Settings settings = Settings.builder()
        assertFalse(testGet.getFields().containsKey(RoutingFieldMapper.NAME));
        assertTrue(primary.getIndexer().refreshNeeded());
    }
        Engine.IndexResult indexResult = indexDoc(shard, "some_type", "0", "{\"foo\" : \"bar\"}");
        assertEquals(new String(testGet.source(), StandardCharsets.UTF_8), "{\"foo\" : \"bar\"}");
 * ownership. Elasticsearch licenses this file to you under
        try (Engine.Searcher searcher = getEngine(primary).acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
        DocumentField docField = new DocumentField("foo", Collections.singletonList("bar"));
import java.nio.charset.StandardCharsets;
 */
            assertEquals(searcher.getIndexReader().maxDoc(), 2);
 * license agreements. See the NOTICE file distributed with
        GetResult getResult = shard.getService().getForUpdate("0", UNASSIGNED_SEQ_NO, UNASSIGNED_PRIMARY_TERM);
 * under the License.
        assertEquals("foobar", testGet1.getFields().get(RoutingFieldMapper.NAME).getValue());
 * Licensed to Elasticsearch under one or more contributor
                    + fieldType
        Method buildFromLookup = ShardGetService.class.getDeclaredMethod(
        closeShards(shard);
    public void testTypelessGetForUpdate() throws IOException {
 * compatible open source license.
        IndexMetadata metadata = IndexMetadata.builder("test")
                    + ", \"store\": true }, "
            DocumentLookupResult.class,
 * software distributed under the License is distributed on an
        primary.getIndexer().refresh("test");
        Engine.IndexResult test1 = indexDoc(primary, "1", "{\"foo\" : \"baz\"}", MediaTypeRegistry.JSON, "foobar");
        // Case 2: DO_NOT_FETCH_SOURCE — source is null
            assertEquals(searcher.getIndexReader().maxDoc(), 2);
    }
        }
                    + "\"bar\":  { \"type\": "
    public void testGetFromTranslogWithStringSourceMappingOptionsAndStoredFields() throws IOException {
}
        assertEquals(3L, result.getVersion());
        assertTrue(primary.getIndexer().refreshNeeded());
 * GitHub history for details.
/*
        primary.getIndexer().refresh("test");
        DocumentLookupResult lookup = new DocumentLookupResult("1", 3L, true, source, 5L, 1L, Map.of("foo", docField), Map.of());
import org.opensearch.core.common.bytes.BytesReference;
            .primaryTerm(0, 1)
 */
            FetchSourceContext.class
        assertNull(noSourceResult.source());
        BytesReference source = new BytesArray("{\"foo\":\"bar\",\"baz\":\"qux\"}");
        String expectedResult,
    }
        assertEquals("foobar", testGet1.getFields().get(RoutingFieldMapper.NAME).getValue());
import org.opensearch.index.VersionType;
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
        }
            .build();
        GetResult testGet1 = primary.getService().getForUpdate("1", UNASSIGNED_SEQ_NO, UNASSIGNED_PRIMARY_TERM);
        testGet1 = primary.getService().getForUpdate("1", test2.getSeqNo(), primaryTerm);
        closeShards(primary);
 * not use this file except in compliance with the License.
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        assertTrue(testGet2.getFields().containsKey("foo"));
    }
        recoverShardFromStore(primary);
                "{ \"properties\": { \"foo\":  { \"type\": "
            .settings(settings)
        assertFalse(testGet.getFields().containsKey(RoutingFieldMapper.NAME));
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        recoverShardFromStore(primary);
        String docToIndex = "{\"foo\" : 7, \"bar\" : 42}";
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
        String docToIndex,
 * the Apache License, Version 2.0 (the "License"); you may
        assertTrue(getResult.isExists());
            .putMapping(
        }
        assertEquals(expectedFooVal, testGet2.getFields().get("foo").getValue());
            .get("2", new String[] { "foo" }, true, 1, VersionType.INTERNAL, FetchSourceContext.FETCH_SOURCE);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        }
                    + fieldType
            assertEquals(searcher.getIndexReader().maxDoc(), 1); // we refreshed
/*
            .build();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .build();
        GetResult testGet2 = primary.getService()
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                    + "}}, \"_source\": { "
        Engine.IndexResult test = indexDoc(primary, MapperService.SINGLE_MAPPING_NAME, "0", docToIndex);
        // now again from the reader
            .primaryTerm(0, 1)
        assertEquals("bar", result.getFields().get("foo").getValue());
        assertEquals("{\"foo\":\"bar\",\"baz\":\"qux\"}", new String(result.source(), StandardCharsets.UTF_8));
            "buildFromLookup",
        Engine.IndexResult test2 = indexDoc(primary, "2", docToIndex, MediaTypeRegistry.JSON, "foobar");
    private void runGetFromTranslogWithOptions(
import org.opensearch.cluster.metadata.IndexMetadata;
            assertEquals(searcher.getIndexReader().maxDoc(), 2); // we read from the translog
    public void testBuildFromLookupSourceFiltering() throws Exception {
import java.util.Map;
                    + sourceOptions
        try (Engine.Searcher searcher = getEngine(primary).acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
        String docToIndex = "{\"foo\" : \"foo\", \"bar\" : \"bar\"}";
        assertEquals(new String(testGet1.source(), StandardCharsets.UTF_8), "{\"foo\" : \"baz\"}");
        GetResult result = (GetResult) buildFromLookup.invoke(getService, lookup, FetchSourceContext.FETCH_SOURCE);
 *     http://www.apache.org/licenses/LICENSE-2.0
        String fieldType,
            .primaryTerm(0, 1)
    public void testGetForUpdate() throws IOException {
    }
        assertTrue(noSourceResult.isExists());
        IndexMetadata metadata = IndexMetadata.builder("test")
        assertEquals("1", result.getId());
        try (Engine.Searcher searcher = getEngine(primary).acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
        );
        assertTrue(testGet1.getFields().containsKey(RoutingFieldMapper.NAME));
            assertEquals(searcher.getIndexReader().maxDoc(), 1); // we read from the translog
        // Case 3: includes filter — only matching fields in source
        assertEquals("foobar", testGet1.getFields().get(RoutingFieldMapper.NAME).getValue());
 *
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        try (Engine.Searcher searcher = getEngine(primary).acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
        GetResult testGet = primary.getService().getForUpdate("0", UNASSIGNED_SEQ_NO, UNASSIGNED_PRIMARY_TERM);
        assertTrue(indexResult.isCreated());
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import java.lang.reflect.Method;
            .settings(settings)
        assertTrue(testGet2.getFields().containsKey("foo"));
        String sourceOptions,
            .build();
        assertTrue(primary.getIndexer().refreshNeeded());
        assertTrue(testGet2.getFields().containsKey(RoutingFieldMapper.NAME));
        assertTrue(testGet1.getFields().containsKey(RoutingFieldMapper.NAME));
        String sourceOptions = noSource ? "\"enabled\": false" : randomBoolean() ? "\"excludes\": [\"fo*\"]" : "\"includes\": [\"ba*\"]";
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.mapper.RoutingFieldMapper;
        assertEquals(new String(testGet1.source() == null ? new byte[0] : testGet1.source(), StandardCharsets.UTF_8), expectedResult);
import org.opensearch.core.common.bytes.BytesArray;
import org.opensearch.index.engine.VersionConflictEngineException;
        Settings settings = Settings.builder()
        try (Engine.Searcher searcher = getEngine(primary).acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
            .build();
import org.opensearch.index.mapper.MapperService;
        Settings settings = Settings.builder()
import org.opensearch.common.settings.Settings;
 * You may obtain a copy of the License at
        }
        buildFromLookup.setAccessible(true);
        assertTrue(testGet2.getFields().containsKey(RoutingFieldMapper.NAME));
        GetResult noSourceResult = (GetResult) buildFromLookup.invoke(getService, lookup, FetchSourceContext.DO_NOT_FETCH_SOURCE);
        expectThrows(VersionConflictEngineException.class, () -> primary.getService().getForUpdate("1", test2.getSeqNo() + 1, primaryTerm));
public class ShardGetServiceTests extends IndexShardTestCase {
            .settings(settings)
        assertEquals(5L, result.getSeqNo());
        testGet2 = primary.getService().get("2", new String[] { "foo" }, true, 1, VersionType.INTERNAL, FetchSourceContext.FETCH_SOURCE);
 *
        expectThrows(VersionConflictEngineException.class, () -> primary.getService().getForUpdate("1", test2.getSeqNo(), primaryTerm + 1));
        assertEquals(new String(testGet1.source(), StandardCharsets.UTF_8), "{\"foo\" : \"baz\"}");
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
