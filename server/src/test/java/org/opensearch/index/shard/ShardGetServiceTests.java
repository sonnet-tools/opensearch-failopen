            "buildFromLookup",  
        assertEquals("foobar", testGet1.getFields().get(RoutingFieldMapper.NAME).getValue());  
        }  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        GetResult testGet2 = primary.getService()
            assertEquals(searcher.getIndexReader().maxDoc(), 2);
        Engine.IndexResult test1 = indexDoc(primary, "1", "{\"foo\" : \"baz\"}", MediaTypeRegistry.JSON, "foobar");
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
    ) throws IOException {
        DocumentField docField = new DocumentField("foo", Collections.singletonList("bar"));
 */
        FetchSourceContext includesOnly = new FetchSourceContext(true, new String[] { "foo" }, new String[0]);  
        Settings settings = Settings.builder()
    }
            .settings(settings)
        BytesReference source = new BytesArray("{\"foo\":\"bar\",\"baz\":\"qux\"}");  
        boolean noSource = randomBoolean();
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
 * GitHub history for details.
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
            .putMapping(  
                    + fieldType
 *
        assertTrue(testGet1.getFields().containsKey(RoutingFieldMapper.NAME));
        );  
        GetResult testGet = primary.getService().getForUpdate("0", UNASSIGNED_SEQ_NO, UNASSIGNED_PRIMARY_TERM);
        IndexShard shard = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
import org.opensearch.core.common.bytes.BytesArray;
 * Licensed to Elasticsearch under one or more contributor  
            .primaryTerm(0, 1)  
 * KIND, either express or implied.  See the License for the
        closeShards(primary);  
    private void runGetFromTranslogWithOptions(
            DocumentLookupResult.class,
    @SuppressForbidden(reason = "reflective access to test private buildFromLookup method")
 * specific language governing permissions and limitations
            FetchSourceContext.class
                "{ \"properties\": { \"foo\":  { \"type\": "
        recoverShardFromStore(primary);
import org.opensearch.search.fetch.subphase.FetchSourceContext;
            assertEquals(searcher.getIndexReader().maxDoc(), 1); // we read from the translog
        }  
                    + fieldType
        GetResult testGet = primary.getService().getForUpdate("0", UNASSIGNED_SEQ_NO, UNASSIGNED_PRIMARY_TERM);  
 * Unless required by applicable law or agreed to in writing,
        assertEquals(new String(testGet1.source(), StandardCharsets.UTF_8), "{\"foo\" : \"baz\"}");
        String sourceOptions = noSource ? "\"enabled\": false" : randomBoolean() ? "\"excludes\": [\"fo*\"]" : "\"includes\": [\"ba*\"]";  
            assertEquals(searcher.getIndexReader().maxDoc(), 2);  
            .settings(settings)
        closeShards(primary);
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
        assertTrue(getResult.isExists());
            .build();
import org.opensearch.core.common.bytes.BytesReference;  
        assertTrue(testGet2.getFields().containsKey("foo"));  
        String sourceOptions = noSource ? "\"enabled\": false" : randomBoolean() ? "\"excludes\": [\"fo*\"]" : "\"includes\": [\"ba*\"]";
        }  
        assertEquals(expectedFooVal, testGet2.getFields().get("foo").getValue());
import org.opensearch.cluster.metadata.IndexMetadata;
                    + sourceOptions
 * not use this file except in compliance with the License.
        assertEquals("{\"foo\":\"bar\"}", new String(filteredResult.source(), StandardCharsets.UTF_8));
import java.util.Map;
        Engine.IndexResult test2 = indexDoc(primary, "1", "{\"foo\" : \"baz\"}", MediaTypeRegistry.JSON, "foobar");
            assertEquals(searcher.getIndexReader().maxDoc(), 1); // we refreshed  
import org.opensearch.Version;  
        ShardGetService getService = primary.getService();
import org.opensearch.index.engine.VersionConflictEngineException;
        // Case 3: includes filter — only matching fields in source
            assertEquals(searcher.getIndexReader().maxDoc(), 3);  
        GetResult testGet1 = primary.getService().getForUpdate("1", UNASSIGNED_SEQ_NO, UNASSIGNED_PRIMARY_TERM);
        assertFalse(testGet.getFields().containsKey(RoutingFieldMapper.NAME));
        // Case 1: FETCH_SOURCE — source passes through unfiltered
        expectThrows(VersionConflictEngineException.class, () -> primary.getService().getForUpdate("1", test2.getSeqNo() + 1, primaryTerm));  
        GetResult testGet1 = primary.getService().getForUpdate("1", UNASSIGNED_SEQ_NO, UNASSIGNED_PRIMARY_TERM);  
        assertTrue(testGet1.getFields().containsKey(RoutingFieldMapper.NAME));
        // now again from the reader  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        String fieldType,
        primary.getIndexer().refresh("test");
        assertFalse(testGet.getFields().containsKey(RoutingFieldMapper.NAME));  
        try (Engine.Searcher searcher = getEngine(primary).acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.index.get.DocumentLookupResult;  
/*  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")
    }  
        assertTrue(testGet2.getFields().containsKey(RoutingFieldMapper.NAME));
        assertEquals(new String(testGet2.source() == null ? new byte[0] : testGet2.source(), StandardCharsets.UTF_8), expectedResult);  
    }
    }
        assertEquals("bar", result.getFields().get("foo").getValue());  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
import java.lang.reflect.Method;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        try (Engine.Searcher searcher = getEngine(primary).acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
        IndexMetadata metadata = IndexMetadata.builder("test")
            .build();  
        assertEquals("foobar", testGet1.getFields().get(RoutingFieldMapper.NAME).getValue());
public class ShardGetServiceTests extends IndexShardTestCase {
 * the Apache License, Version 2.0 (the "License"); you may
        }
        try (Engine.Searcher searcher = getEngine(primary).acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
        assertEquals(new String(testGet.source() == null ? new byte[0] : testGet.source(), StandardCharsets.UTF_8), expectedResult);
    public void testGetFromTranslogWithLongSourceMappingOptionsAndStoredFields() throws IOException {  
        testGet1 = primary.getService().getForUpdate("1", UNASSIGNED_SEQ_NO, UNASSIGNED_PRIMARY_TERM);  
    }
    public void testTypelessGetForUpdate() throws IOException {  
        Engine.IndexResult test = indexDoc(primary, MapperService.SINGLE_MAPPING_NAME, "0", docToIndex);  
import org.opensearch.common.SuppressForbidden;
 * SPDX-License-Identifier: Apache-2.0
        recoverShardFromStore(primary);  
            .primaryTerm(0, 1)
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
                    + "\"bar\":  { \"type\": "
        assertTrue(testGet1.getFields().containsKey(RoutingFieldMapper.NAME));
        }
 * license agreements. See the NOTICE file distributed with
        assertEquals("1", noSourceResult.getId());  
        try (Engine.Searcher searcher = getEngine(primary).acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
            .build();
        boolean noSource = randomBoolean();
        }
        closeShards(primary);
        assertTrue(primary.getIndexer().refreshNeeded());
        Settings settings = Settings.builder()  
import java.io.IOException;
        assertTrue(primary.getIndexer().refreshNeeded());
        assertEquals(new String(testGet1.source(), StandardCharsets.UTF_8), "{\"foo\" : \"baz\"}");
 */  
 *
        assertTrue(testGet2.getFields().containsKey(RoutingFieldMapper.NAME));
            assertEquals(searcher.getIndexReader().maxDoc(), 2); // we read from the translog
        IndexMetadata metadata = IndexMetadata.builder("test")  
 * under the License.  
            .settings(settings)
        assertEquals(new String(testGet1.source() == null ? new byte[0] : testGet1.source(), StandardCharsets.UTF_8), expectedResult);  
            .putMapping("{ \"properties\": { \"foo\":  { \"type\": \"text\"}}}")  
        testGet2 = primary.getService().get("2", new String[] { "foo" }, true, 1, VersionType.INTERNAL, FetchSourceContext.FETCH_SOURCE);  
            .primaryTerm(0, 1)
        Engine.IndexResult indexResult = indexDoc(shard, "some_type", "0", "{\"foo\" : \"bar\"}");
            .primaryTerm(0, 1)  
        assertTrue(indexResult.isCreated());
        try (Engine.Searcher searcher = getEngine(primary).acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
 */
import org.opensearch.index.get.ShardGetService;
            .build();  
        assertEquals(new String(testGet2.source() == null ? new byte[0] : testGet2.source(), StandardCharsets.UTF_8), expectedResult);
        DocumentLookupResult lookup = new DocumentLookupResult("1", 3L, true, source, 5L, 1L, Map.of("foo", docField), Map.of());
        IndexShard primary = newShard(new ShardId(metadata.getIndex(), 0), true, "n1", metadata, null);
        assertEquals(1L, result.getPrimaryTerm());
 * software distributed under the License is distributed on an
import org.opensearch.index.VersionType;  
        GetResult getResult = shard.getService().getForUpdate("0", UNASSIGNED_SEQ_NO, UNASSIGNED_PRIMARY_TERM);
        Engine.IndexResult test2 = indexDoc(primary, "2", docToIndex, MediaTypeRegistry.JSON, "foobar");
            .build();  
 * ownership. Elasticsearch licenses this file to you under  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        Object expectedFooVal  
        Settings settings = Settings.builder()
/*
        String docToIndex = "{\"foo\" : \"foo\", \"bar\" : \"bar\"}";  
        expectThrows(VersionConflictEngineException.class, () -> primary.getService().getForUpdate("1", test2.getSeqNo(), primaryTerm + 1));
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
        }
            .settings(settings)
                    + "}}}"
    public void testGetFromTranslogWithStringSourceMappingOptionsAndStoredFields() throws IOException {
        IndexMetadata metadata = IndexMetadata.builder("test")
        assertTrue(primary.getIndexer().refreshNeeded());  
        String sourceOptions,  
        recoverShardFromStore(shard);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testGetForUpdate() throws IOException {  
        testGet1 = primary.getService().getForUpdate("1", test2.getSeqNo(), primaryTerm);  
            )  
        GetResult result = (GetResult) buildFromLookup.invoke(getService, lookup, FetchSourceContext.FETCH_SOURCE);
            .get("2", new String[] { "foo" }, true, 1, VersionType.INTERNAL, FetchSourceContext.FETCH_SOURCE);
import org.opensearch.index.mapper.RoutingFieldMapper;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.index.get.GetResult;
    }
                    + ", \"store\": true }, "  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        // Case 2: DO_NOT_FETCH_SOURCE — source is null
        assertEquals(new String(testGet1.source(), StandardCharsets.UTF_8), "{\"foo\" : \"baz\"}");
            assertEquals(searcher.getIndexReader().maxDoc(), 1); // we refreshed
        final long primaryTerm = primary.getOperationPrimaryTerm();
        assertEquals("1", result.getId());
        buildFromLookup.setAccessible(true);
        assertTrue(result.isExists());  
        GetResult filteredResult = (GetResult) buildFromLookup.invoke(getService, lookup, includesOnly);
 *  
        assertEquals(3L, result.getVersion());
    public void testBuildFromLookupSourceFiltering() throws Exception {
}  
        assertTrue(noSourceResult.isExists());
        Settings settings = Settings.builder()
        primary.getIndexer().refresh("test");
        assertTrue(primary.getIndexer().refreshNeeded());
        runGetFromTranslogWithOptions(docToIndex, sourceOptions, noSource ? "" : "{\"bar\":\"bar\"}", "\"text\"", "foo");  
 * The OpenSearch Contributors require contributions made to  
        Engine.IndexResult test = indexDoc(primary, "test", "0", "{\"foo\" : \"bar\"}");
 * compatible open source license.
        assertTrue(testGet2.getFields().containsKey("foo"));
        assertNull(noSourceResult.source());
        primary.getIndexer().refresh("test");  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            .build();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        try (Engine.Searcher searcher = getEngine(primary).acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {
            .build();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        GetResult noSourceResult = (GetResult) buildFromLookup.invoke(getService, lookup, FetchSourceContext.DO_NOT_FETCH_SOURCE);  
import org.opensearch.common.document.DocumentField;  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertTrue(primary.getIndexer().refreshNeeded());
        assertEquals(new String(testGet.source(), StandardCharsets.UTF_8), "{\"foo\" : \"bar\"}");
        Engine.IndexResult test1 = indexDoc(primary, "1", docToIndex, MediaTypeRegistry.JSON, "foobar");  
import org.opensearch.index.mapper.MapperService;  
        assertEquals("foobar", testGet1.getFields().get(RoutingFieldMapper.NAME).getValue());  
        }
        IndexMetadata metadata = IndexMetadata.builder("index")  
            assertEquals(searcher.getIndexReader().maxDoc(), 1); // we read from the translog
 * You may obtain a copy of the License at  
import org.opensearch.index.engine.Engine;
        try (Engine.Searcher searcher = getEngine(primary).acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {  
        Method buildFromLookup = ShardGetService.class.getDeclaredMethod(
        runGetFromTranslogWithOptions(docToIndex, sourceOptions, noSource ? "" : "{\"bar\":42}", "\"long\"", 7L);
        closeShards(shard);
                    + "}}, \"_source\": { "  
 * Modifications Copyright OpenSearch Contributors. See  
        String docToIndex = "{\"foo\" : 7, \"bar\" : 42}";
import org.opensearch.core.index.shard.ShardId;
import java.nio.charset.StandardCharsets;  
        String expectedResult,
        recoverShardFromStore(primary);
        assertEquals(5L, result.getSeqNo());  
package org.opensearch.index.shard;
import org.opensearch.common.settings.Settings;
        assertEquals("{\"foo\":\"bar\",\"baz\":\"qux\"}", new String(result.source(), StandardCharsets.UTF_8));
import java.util.Collections;
        assertTrue(primary.getIndexer().refreshNeeded());
            .build();
        String docToIndex,
        try (Engine.Searcher searcher = getEngine(primary).acquireSearcher("test", Engine.SearcherScope.INTERNAL)) {  
        assertEquals(expectedFooVal, testGet2.getFields().get("foo").getValue());  
