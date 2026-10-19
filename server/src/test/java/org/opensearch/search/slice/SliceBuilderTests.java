        SliceBuilder sliceBuilder = randomSliceBuilder();
        }  
 * Licensed to Elasticsearch under one or more contributor  
import static org.hamcrest.Matchers.instanceOf;  
import org.opensearch.core.common.Strings;
                    context = createShardContext(Version.CURRENT, reader, "_id", DocValuesType.SORTED, numShards, j);
import org.opensearch.index.mapper.MappedFieldType;  
    private ShardSearchRequest createRequest(int shardId, String[] routings, String preference) {  
            IllegalArgumentException exc = expectThrows(
        Directory dir = new ByteBuffersDirectory();
            try (IndexReader newReader = DirectoryReader.open(dir)) {
import org.opensearch.cluster.ClusterState;
                return null;
        return new ShardSearchRequest(
 * under the License.  
    private static final int MAX_SLICE = 20;  
        int shardId
                when(context.getIndexReader()).thenReturn(newReader);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        try (XContentParser parser = createParser(shuffleXContent(builder))) {
    }  
            numShards = randomIntBetween(2, 10);
            Version version = VersionUtils.randomCompatibleVersion(random(), Version.CURRENT);  
import static org.hamcrest.Matchers.containsString;
        sliceBuilder.innerToXContent(builder);
/*  
            assertThat(new HashSet<>(targetShards).size(), equalTo(numShards));
    }  
            case 1:
            true,  
import org.opensearch.index.IndexSettings;
                    }  
        Exception e = expectThrows(IllegalArgumentException.class, () -> new SliceBuilder("field", -1, 10));
    private static SliceBuilder randomSliceBuilder() {
        try (IndexReader reader = DirectoryReader.open(dir)) {  
        ClusterService clusterService = mock(ClusterService.class);  
import org.opensearch.test.VersionUtils;
        }
        try (IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig(new MockAnalyzer(random())))) {  
    ) {  
        try (IndexReader reader = DirectoryReader.open(dir)) {
 * compatible open source license.
            for (int i = 0; i < numSlices; i++) {
    public void testSerialization() throws Exception {
            SliceBuilder builder = new SliceBuilder(5, 10);
            null,  
import org.apache.lucene.search.MatchAllDocsQuery;
                    if (q instanceof MatchNoDocsQuery == false) {  
        try (IndexReader reader = DirectoryReader.open(dir)) {
        e = expectThrows(IllegalArgumentException.class, () -> new SliceBuilder("field", 1000, 1000));
                        AtomicInteger count = numSliceMap.get(j);
            try (IndexReader newReader = DirectoryReader.open(dir)) {
        return new IndexSettings(indexState, Settings.EMPTY);
public class SliceBuilderTests extends OpenSearchTestCase {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                }
                        }
        SliceBuilder original = randomSliceBuilder();
                        count.incrementAndGet();  
import org.opensearch.cluster.routing.GroupShardsIterator;
            QueryShardContext context = createShardContext(Version.CURRENT, reader, "_id", DocValuesType.SORTED_NUMERIC, 1, 0);
            for (int i = 0; i < numSlices; i++) {  
 */  
            1,
            public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
            TextSearchInfo.NONE,  
            );
            IndexNumericFieldData fd = mock(IndexNumericFieldData.class);  
 * Unless required by applicable law or agreed to in writing,
                    context = createShardContext(Version.CURRENT, reader, "_id", DocValuesType.SORTED, numShards, j);
    public void testInvalidField() throws IOException {  
        Directory dir = new ByteBuffersDirectory();  
                    if (i == j) {
                assertThat(builder.toFilter(null, createRequest(0), context, Version.CURRENT), equalTo(query));  
            fieldName,
                return new SliceBuilder(original.getField(), original.getId(), original.getMax() + 1);  
    }  
import org.opensearch.index.fielddata.IndexNumericFieldData;
import org.apache.lucene.index.DocValuesType;
/*
        ) {
import org.opensearch.index.mapper.TextSearchInfo;
        int id = randomIntBetween(1, max - 1);
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.search.Query;
                        if (count == null) {
package org.opensearch.search.slice;
        SliceBuilder deserialized = serializedCopy(original);  
    }
import java.io.IOException;  
        }
                        }  
        }  
    }
        builder.endObject();  
import org.opensearch.search.lookup.SearchLookup;
            }  
            QueryShardContext context = createShardContext(Version.CURRENT, reader, "field", null, 1, 0);  
        when(clusterService.operationRouting()).thenReturn(routing);  
        checkEqualsAndHashCode(randomSliceBuilder(), SliceBuilderTests::serializedCopy, SliceBuilderTests::mutate);
import org.opensearch.common.settings.Settings;
            SliceBuilder builder = new SliceBuilder("field", 6, 10);
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));  
            Map<Integer, AtomicInteger> numSliceMap = new HashMap<>();  
            assertEquals(sliceBuilder, secondSliceBuilder);
            @Override
        IndexSettings indexSettings = createIndexSettings(indexVersionCreated, numShards);  
        when(context.getIndexReader()).thenReturn(reader);
import java.util.ArrayList;
            assertThat(exc.getMessage(), containsString("cannot load numeric doc values"));  
        when(context.fieldMapper(fieldName)).thenReturn(fieldType);  
        return copyWriteable(original, new NamedWriteableRegistry(Collections.emptyList()), SliceBuilder::new);
            assertThat(builder.toFilter(null, createRequest(0), context, Version.CURRENT), equalTo(query));  
import java.util.HashSet;
    private ShardSearchRequest createRequest(int shardId) {
            assertThat(query, instanceOf(DocValuesSliceQuery.class));
import org.opensearch.cluster.metadata.IndexMetadata;  
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.search.MatchNoDocsQuery;  
            }
            writer.commit();
                return new SliceBuilder(original.getField(), original.getId() - 1, original.getMax());  
import org.opensearch.action.search.SearchRequest;
        when(context.getShardId()).thenReturn(shardId);
            }  
            .build();  
            default:
        ClusterState state = mock(ClusterState.class);
import org.opensearch.Version;
            QueryShardContext context = createShardContext(Version.CURRENT, reader, "field", DocValuesType.SORTED_NUMERIC, 1, 0);
        Version indexVersionCreated,  
    public void testToFilterRandom() throws IOException {
        }
            }
                for (int j = 0; j < numShards; j++) {
        try (IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig(new MockAnalyzer(random())))) {
            query = builder.toFilter(clusterService, createRequest(1, Strings.EMPTY_ARRAY, "foo"), context, version);  
        IndexReader reader,
        MappedFieldType fieldType = new MappedFieldType(
 * specific language governing permissions and limitations
            Collections.singletonList(new PlainShardIterator(new ShardId("index", "index", 1), Collections.emptyList()))  
            when(context.getForField(fieldType)).thenReturn(fd);
            builder = builder.prettyPrint();
    public void testEqualsAndHashcode() throws Exception {  
 * software distributed under the License is distributed on an
            System.currentTimeMillis(),
            }
import org.apache.lucene.tests.analysis.MockAnalyzer;
            Query query = builder.toFilter(null, createRequest(0), context, Version.CURRENT);
            for (int i = 0; i < numSlices; i++) {
import org.opensearch.cluster.routing.ShardIterator;
import org.apache.lucene.index.DirectoryReader;
import static org.mockito.Mockito.when;  
            case 2:
    private static SliceBuilder mutate(SliceBuilder original) {
        assertEquals("max must be greater than id", e.getMessage());
                    SliceBuilder slice = new SliceBuilder("_id", i, numSlices);
                return new SliceBuilder(original.getField() + "_xyz", original.getId(), original.getMax());
import java.util.Collections;
        IndexMetadata indexState = IndexMetadata.builder("index").settings(settings).build();
                }
 * the Apache License, Version 2.0 (the "License"); you may
        try (IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig(new MockAnalyzer(random())))) {
                            numSliceMap.put(j, count);
import org.opensearch.common.xcontent.XContentType;  
                        assertThat(q, instanceOf(MatchNoDocsQuery.class));
            routings
        int numShards,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
    }
import java.util.HashMap;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
            .put(IndexMetadata.SETTING_VERSION_CREATED, indexVersionCreated)  
            int numShards = randomIntBetween(1, 9);
            Query query = builder.toFilter(clusterService, createRequest(1, routings, null), context, version);
            case 0:  
        assertNotSame(deserialized, original);  
    }
            assertEquals(sliceBuilder.hashCode(), secondSliceBuilder.hashCode());
        Directory dir = new ByteBuffersDirectory();
                throw new UnsupportedOperationException();  
            public Query termQuery(Object value, @Nullable QueryShardContext context) {  
            new ShardId("index", "index", shardId),
 * You may obtain a copy of the License at  
        };
            writer.commit();
        String fieldName,
        when(clusterService.state()).thenReturn(state);  
import org.opensearch.action.OriginalIndices;  
 * Modifications Copyright OpenSearch Contributors. See
            // numShards > numSlices  
                when(context.getIndexReader()).thenReturn(newReader);
                    } else {
            false,
import org.apache.lucene.index.IndexReader;  
        GroupShardsIterator<ShardIterator> it = new GroupShardsIterator<>(
                    Query q = slice.toFilter(null, createRequest(j), context, Version.CURRENT);
        DocValuesType dvType,  
                total += e.getValue().get();
import java.util.concurrent.atomic.AtomicInteger;
        if (dvType != null) {
                            assertThat(count.get(), equalTo(1));
 */  
    }
        try (IndexReader reader = DirectoryReader.open(dir)) {
            }
                IllegalArgumentException.class,  
        );
        e = expectThrows(IllegalArgumentException.class, () -> new SliceBuilder("field", 10, 5));
        Settings settings = Settings.builder()
                            count = new AtomicInteger(0);  
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.index.query.QueryShardContext;  
            numSlices = randomIntBetween(2, numShards - 1);
                        assertThat(q, instanceOf(MatchAllDocsQuery.class));
import static org.hamcrest.Matchers.equalTo;
            }
import static org.mockito.Mockito.mock;
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;  
            assertEquals(new DocValuesSliceQuery("field", 6, 10), query);
import static org.mockito.Mockito.any;
        when(state.metadata()).thenReturn(Metadata.EMPTY_METADATA);
import org.apache.lucene.store.Directory;  
    public void testToFilterSimple() throws IOException {
        return context;  
                        targetShards.add(j);
            for (Map.Entry<Integer, AtomicInteger> e : numSliceMap.entrySet()) {
        assertEquals("id must be greater than or equal to 0", e.getMessage());
        builder.startObject();
    }
        if (randomBoolean()) {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        }  
 *
                    } else {
    private IndexSettings createIndexSettings(Version indexVersionCreated, int numShards) {
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
            QueryShardContext context = createShardContext(version, reader, "field", DocValuesType.SORTED, 5, 0);
            String[] routings = new String[] { "foo" };  
 * this file be licensed under the Apache-2.0 license or a
                        if (q instanceof MatchAllDocsQuery) {
import org.opensearch.cluster.routing.PlainShardIterator;
import org.opensearch.index.mapper.ValueFetcher;
import org.opensearch.test.OpenSearchTestCase;  
    }
            int numSlices = randomIntBetween(10, 100);
                () -> builder.toFilter(null, createRequest(0), context, Version.CURRENT)
        assertEquals(deserialized.hashCode(), original.hashCode());
        return new SliceBuilder(field, id, max);  
            // numSlices > numShards  
                for (int j = 0; j < numShards; j++) {
                }
import org.apache.lucene.store.ByteBuffersDirectory;
            null,  
                    }  
            Collections.emptyMap()
        assertEquals("max must be greater than 1", e.getMessage());
import java.util.Map;  
            }
 * not use this file except in compliance with the License.
            @Override
 *  
import org.opensearch.core.xcontent.XContentParser;  
                    }  
            numSlices = numShards;
import java.util.List;
import org.opensearch.core.index.shard.ShardId;  
        );
                return null;
 *
        assertEquals("max must be greater than id", e.getMessage());
        return createRequest(shardId, Strings.EMPTY_ARRAY, null);  
        e = expectThrows(IllegalArgumentException.class, () -> new SliceBuilder("field", 1001, 1000));  
                assertThat(builder.toFilter(null, createRequest(0), context, Version.CURRENT), equalTo(query));  
                for (int j = 0; j < numShards; j++) {
            SliceBuilder secondSliceBuilder = SliceBuilder.fromXContent(parser);
    public void testFromXContent() throws Exception {
                return null;
                        assertThat(q, instanceOf(MatchNoDocsQuery.class));
        assertEquals(deserialized, original);
        when(clusterService.getSettings()).thenReturn(Settings.EMPTY);
            Query query = builder.toFilter(null, createRequest(0), context, Version.CURRENT);  
            assertThat(targetShards.size(), equalTo(numShards));  
            assertNotSame(sliceBuilder, secondSliceBuilder);  
            0f,
}
import org.opensearch.common.Nullable;
        }
        when(routing.searchShards(any(), any(), any(), any())).thenReturn(it);
            List<Integer> targetShards = new ArrayList<>();  
                    Query q = slice.toFilter(null, createRequest(j), context, Version.CURRENT);
            SliceBuilder builder = new SliceBuilder("field", 5, 10);
            }  
import org.opensearch.search.internal.ShardSearchRequest;
    }
 * ownership. Elasticsearch licenses this file to you under  
            // numShards == numSlices  
/*  
            numShards = randomIntBetween(4, 100);
        }
            OriginalIndices.NONE,
import org.opensearch.core.xcontent.MediaTypeRegistry;
        }
            public String typeName() {
        assertEquals("max must be greater than id", e.getMessage());
import org.opensearch.cluster.service.ClusterService;  
    }  
    private static SliceBuilder serializedCopy(SliceBuilder original) throws IOException {  
                    SliceBuilder slice = new SliceBuilder("_id", i, numSlices);  
        e = expectThrows(IllegalArgumentException.class, () -> new SliceBuilder("field", 10, 0));
import org.opensearch.cluster.metadata.Metadata;
                    context = createShardContext(Version.CURRENT, reader, "_id", DocValuesType.SORTED, numShards, j);  
        switch (randomIntBetween(0, 2)) {
                    if (q instanceof TermsSliceQuery || q instanceof MatchAllDocsQuery) {  
    public void testInvalidArguments() throws Exception {  
            assertThat(total, equalTo(numSlices));
            @Override  
                        assertThat(q, instanceOf(MatchAllDocsQuery.class));  
        OperationRouting routing = mock(OperationRouting.class);
 */
            assertThat(query, instanceOf(TermsSliceQuery.class));
        String field = randomAlphaOfLengthBetween(5, 20);
        QueryShardContext context = mock(QueryShardContext.class);
    private QueryShardContext createShardContext(
            dvType != null,
    public void testToFilterWithRouting() throws IOException {
 * GitHub history for details.
    }
                    Query q = slice.toFilter(null, createRequest(j), context, Version.CURRENT);
    }
import org.apache.lucene.index.IndexWriter;
        assertEquals("max must be greater than 1", e.getMessage());
            new SearchRequest().preference(preference).allowPartialSearchResults(true),  
        int max = randomIntBetween(2, MAX_SLICE);  
    }
            writer.commit();
            assertThat(builder.toFilter(null, createRequest(0), context, Version.CURRENT), equalTo(query));  
            SliceBuilder builder = new SliceBuilder("field", 5, 10);  
        Directory dir = new ByteBuffersDirectory();
        try (IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig(new MockAnalyzer(random())))) {  
        when(context.getIndexSettings()).thenReturn(indexSettings);
                    SliceBuilder slice = new SliceBuilder("_id", i, numSlices);  
 * this work for additional information regarding copyright
import org.opensearch.cluster.routing.OperationRouting;  
            writer.commit();  
        e = expectThrows(IllegalArgumentException.class, () -> new SliceBuilder("field", 10, -1));
        }  
            int total = 0;  
        }
        }
            public Query existsQuery(QueryShardContext context) {
            assertEquals(new DocValuesSliceQuery("field", 6, 10), query);
