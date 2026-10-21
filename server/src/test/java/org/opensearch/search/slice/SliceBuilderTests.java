                }
            assertEquals(new DocValuesSliceQuery("field", 6, 10), query);
                            count = new AtomicInteger(0);
    private static SliceBuilder serializedCopy(SliceBuilder original) throws IOException {
                        assertThat(q, instanceOf(MatchAllDocsQuery.class));
            1,
    public void testToFilterRandom() throws IOException {
    private ShardSearchRequest createRequest(int shardId, String[] routings, String preference) {
            0f,
        try (IndexReader reader = DirectoryReader.open(dir)) {
                    }
import org.opensearch.cluster.ClusterState;
        }
                    SliceBuilder slice = new SliceBuilder("_id", i, numSlices);
 * software distributed under the License is distributed on an
        };
    private IndexSettings createIndexSettings(Version indexVersionCreated, int numShards) {
    public void testToFilterSimple() throws IOException {
            Query query = builder.toFilter(null, createRequest(0), context, Version.CURRENT);
import org.apache.lucene.index.IndexWriter;
        ClusterService clusterService = mock(ClusterService.class);
            public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
            QueryShardContext context = createShardContext(version, reader, "field", DocValuesType.SORTED, 5, 0);
 * compatible open source license.
        String field = randomAlphaOfLengthBetween(5, 20);
        return copyWriteable(original, new NamedWriteableRegistry(Collections.emptyList()), SliceBuilder::new);
            SliceBuilder builder = new SliceBuilder("field", 5, 10);
        Version indexVersionCreated,
    }
    }
import org.opensearch.cluster.routing.OperationRouting;
        assertEquals("max must be greater than 1", e.getMessage());
            case 2:
            assertEquals(sliceBuilder.hashCode(), secondSliceBuilder.hashCode());
        SliceBuilder sliceBuilder = randomSliceBuilder();
            builder = builder.prettyPrint();
            TextSearchInfo.NONE,
            for (int i = 0; i < numSlices; i++) {
        }
 * Licensed to Elasticsearch under one or more contributor
    private static SliceBuilder mutate(SliceBuilder original) {
            SliceBuilder builder = new SliceBuilder("field", 6, 10);
            }
        when(clusterService.state()).thenReturn(state);
            false,
                total += e.getValue().get();
                }
 *
        String fieldName,
            assertEquals(new DocValuesSliceQuery("field", 6, 10), query);
                when(context.getIndexReader()).thenReturn(newReader);
                for (int j = 0; j < numShards; j++) {
            @Override
        if (randomBoolean()) {
                        assertThat(q, instanceOf(MatchNoDocsQuery.class));
                    } else {
            assertThat(query, instanceOf(TermsSliceQuery.class));
                    context = createShardContext(Version.CURRENT, reader, "_id", DocValuesType.SORTED, numShards, j);
 * Unless required by applicable law or agreed to in writing,
                        }
    }
    public void testToFilterWithRouting() throws IOException {
import java.util.Collections;
        ClusterState state = mock(ClusterState.class);
            }
            assertThat(builder.toFilter(null, createRequest(0), context, Version.CURRENT), equalTo(query));
                    if (q instanceof MatchNoDocsQuery == false) {
        assertEquals("max must be greater than id", e.getMessage());
 * The OpenSearch Contributors require contributions made to
        try (IndexReader reader = DirectoryReader.open(dir)) {
            writer.commit();
            SliceBuilder builder = new SliceBuilder(5, 10);
            public String typeName() {
import org.opensearch.cluster.routing.ShardIterator;
 *
import org.opensearch.cluster.metadata.IndexMetadata;
 * GitHub history for details.
        IndexSettings indexSettings = createIndexSettings(indexVersionCreated, numShards);
                return null;
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.Strings;
                            assertThat(count.get(), equalTo(1));
    }
            assertThat(builder.toFilter(null, createRequest(0), context, Version.CURRENT), equalTo(query));
            QueryShardContext context = createShardContext(Version.CURRENT, reader, "field", null, 1, 0);
    }
        assertEquals("max must be greater than id", e.getMessage());
 *    http://www.apache.org/licenses/LICENSE-2.0
            IndexNumericFieldData fd = mock(IndexNumericFieldData.class);
        GroupShardsIterator<ShardIterator> it = new GroupShardsIterator<>(
                    SliceBuilder slice = new SliceBuilder("_id", i, numSlices);
import java.io.IOException;
            }
        e = expectThrows(IllegalArgumentException.class, () -> new SliceBuilder("field", 1001, 1000));
/*
 */
        Settings settings = Settings.builder()
                        count.incrementAndGet();
                        if (q instanceof MatchAllDocsQuery) {
                        targetShards.add(j);
            }
            String[] routings = new String[] { "foo" };
        SliceBuilder deserialized = serializedCopy(original);
                throw new UnsupportedOperationException();
import org.opensearch.index.fielddata.IndexNumericFieldData;
            for (int i = 0; i < numSlices; i++) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        assertThat(q, instanceOf(MatchNoDocsQuery.class));
            true,
            .build();
            SliceBuilder builder = new SliceBuilder("field", 5, 10);
import org.opensearch.common.settings.Settings;
    private static SliceBuilder randomSliceBuilder() {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        }
public class SliceBuilderTests extends OpenSearchTestCase {
/*
import org.apache.lucene.index.DirectoryReader;
            @Override
            public Query existsQuery(QueryShardContext context) {
        try (IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig(new MockAnalyzer(random())))) {
import org.opensearch.action.search.SearchRequest;
        try (IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig(new MockAnalyzer(random())))) {
            QueryShardContext context = createShardContext(Version.CURRENT, reader, "_id", DocValuesType.SORTED_NUMERIC, 1, 0);
        try (IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig(new MockAnalyzer(random())))) {
            try (IndexReader newReader = DirectoryReader.open(dir)) {
            QueryShardContext context = createShardContext(Version.CURRENT, reader, "field", DocValuesType.SORTED_NUMERIC, 1, 0);
                    } else {
import org.opensearch.search.lookup.SearchLookup;
                return new SliceBuilder(original.getField(), original.getId(), original.getMax() + 1);
        assertEquals("max must be greater than id", e.getMessage());
        try (IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig(new MockAnalyzer(random())))) {
                    context = createShardContext(Version.CURRENT, reader, "_id", DocValuesType.SORTED, numShards, j);
        sliceBuilder.innerToXContent(builder);
            fieldName,
import org.apache.lucene.store.ByteBuffersDirectory;
    }
            writer.commit();
        Directory dir = new ByteBuffersDirectory();
        MappedFieldType fieldType = new MappedFieldType(
    }
 * the Apache License, Version 2.0 (the "License"); you may
                    if (q instanceof TermsSliceQuery || q instanceof MatchAllDocsQuery) {
        }
            }
        when(context.getIndexSettings()).thenReturn(indexSettings);
        QueryShardContext context = mock(QueryShardContext.class);
 * SPDX-License-Identifier: Apache-2.0
                    Query q = slice.toFilter(null, createRequest(j), context, Version.CURRENT);
 * not use this file except in compliance with the License.
            int numShards = randomIntBetween(1, 9);
import org.opensearch.index.IndexSettings;
    public void testInvalidArguments() throws Exception {
                    if (i == j) {
            IllegalArgumentException exc = expectThrows(
    ) {
            numShards = randomIntBetween(2, 10);
            List<Integer> targetShards = new ArrayList<>();
                IllegalArgumentException.class,
    private QueryShardContext createShardContext(
        when(clusterService.operationRouting()).thenReturn(routing);
        e = expectThrows(IllegalArgumentException.class, () -> new SliceBuilder("field", 10, -1));
            default:
        OperationRouting routing = mock(OperationRouting.class);
 */
            assertThat(new HashSet<>(targetShards).size(), equalTo(numShards));
        assertEquals(deserialized, original);
import static org.mockito.Mockito.when;
                            numSliceMap.put(j, count);
            Collections.singletonList(new PlainShardIterator(new ShardId("index", "index", 1), Collections.emptyList()))
        builder.startObject();
            null,
        ) {
            Collections.emptyMap()
    }
            assertEquals(sliceBuilder, secondSliceBuilder);
import org.opensearch.Version;
            assertThat(targetShards.size(), equalTo(numShards));
        }
package org.opensearch.search.slice;
import org.opensearch.core.xcontent.XContentBuilder;
            routings
        IndexReader reader,
                assertThat(builder.toFilter(null, createRequest(0), context, Version.CURRENT), equalTo(query));
            case 1:
        builder.endObject();
            .put(IndexMetadata.SETTING_VERSION_CREATED, indexVersionCreated)
            null,
            SliceBuilder secondSliceBuilder = SliceBuilder.fromXContent(parser);
                return null;
                return new SliceBuilder(original.getField(), original.getId() - 1, original.getMax());
        assertEquals(deserialized.hashCode(), original.hashCode());
        when(routing.searchShards(any(), any(), any(), any())).thenReturn(it);
    }
    public void testSerialization() throws Exception {
        assertEquals("max must be greater than 1", e.getMessage());
        }
import org.apache.lucene.search.MatchAllDocsQuery;
            dvType != null,
    public void testInvalidField() throws IOException {
        when(context.fieldMapper(fieldName)).thenReturn(fieldType);
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
import org.apache.lucene.search.Query;
            new SearchRequest().preference(preference).allowPartialSearchResults(true),
        try (IndexReader reader = DirectoryReader.open(dir)) {
            }
import java.util.concurrent.atomic.AtomicInteger;
    }
import org.apache.lucene.search.MatchNoDocsQuery;
        Exception e = expectThrows(IllegalArgumentException.class, () -> new SliceBuilder("field", -1, 10));
 * specific language governing permissions and limitations
                return new SliceBuilder(original.getField() + "_xyz", original.getId(), original.getMax());
            for (Map.Entry<Integer, AtomicInteger> e : numSliceMap.entrySet()) {
import org.opensearch.cluster.routing.PlainShardIterator;
        );
}
import org.opensearch.common.Nullable;
                when(context.getIndexReader()).thenReturn(newReader);
import org.apache.lucene.store.Directory;
        try (IndexReader reader = DirectoryReader.open(dir)) {
                    Query q = slice.toFilter(null, createRequest(j), context, Version.CURRENT);
            int total = 0;
            Query query = builder.toFilter(clusterService, createRequest(1, routings, null), context, version);
        }
    }
    private static final int MAX_SLICE = 20;
                    SliceBuilder slice = new SliceBuilder("_id", i, numSlices);
 * Modifications Copyright OpenSearch Contributors. See
        );
        when(state.metadata()).thenReturn(Metadata.EMPTY_METADATA);
import static org.mockito.Mockito.any;
        int max = randomIntBetween(2, MAX_SLICE);
            }
                        assertThat(q, instanceOf(MatchAllDocsQuery.class));
            query = builder.toFilter(clusterService, createRequest(1, Strings.EMPTY_ARRAY, "foo"), context, version);
        when(context.getShardId()).thenReturn(shardId);
    }
import org.opensearch.core.index.shard.ShardId;
                    context = createShardContext(Version.CURRENT, reader, "_id", DocValuesType.SORTED, numShards, j);
import static org.hamcrest.Matchers.instanceOf;
            case 0:
            }
        int numShards,
        }
            numSlices = randomIntBetween(2, numShards - 1);
        }
            writer.commit();
            numSlices = numShards;
 *
    }
import org.opensearch.index.query.QueryShardContext;
 * license agreements. See the NOTICE file distributed with
import java.util.ArrayList;
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
        return createRequest(shardId, Strings.EMPTY_ARRAY, null);
        e = expectThrows(IllegalArgumentException.class, () -> new SliceBuilder("field", 1000, 1000));
import java.util.HashSet;
    }
                }
        return context;
    private ShardSearchRequest createRequest(int shardId) {
        checkEqualsAndHashCode(randomSliceBuilder(), SliceBuilderTests::serializedCopy, SliceBuilderTests::mutate);
        when(context.getIndexReader()).thenReturn(reader);
import org.opensearch.index.mapper.ValueFetcher;
            numShards = randomIntBetween(4, 100);
                for (int j = 0; j < numShards; j++) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.index.mapper.TextSearchInfo;
            assertThat(exc.getMessage(), containsString("cannot load numeric doc values"));
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.search.internal.ShardSearchRequest;
            OriginalIndices.NONE,
                        if (count == null) {
                    }
import org.opensearch.core.xcontent.XContentParser;
            }
            when(context.getForField(fieldType)).thenReturn(fd);
    public void testEqualsAndHashcode() throws Exception {
            System.currentTimeMillis(),
import static org.mockito.Mockito.mock;
 * You may obtain a copy of the License at
 * under the License.
        try (XContentParser parser = createParser(shuffleXContent(builder))) {
            try (IndexReader newReader = DirectoryReader.open(dir)) {
        Directory dir = new ByteBuffersDirectory();
        if (dvType != null) {
import org.apache.lucene.index.IndexReader;
                assertThat(builder.toFilter(null, createRequest(0), context, Version.CURRENT), equalTo(query));
import org.apache.lucene.index.DocValuesType;
 */
            assertThat(total, equalTo(numSlices));
        when(clusterService.getSettings()).thenReturn(Settings.EMPTY);
                for (int j = 0; j < numShards; j++) {
        assertNotSame(deserialized, original);
                        }
import org.opensearch.test.OpenSearchTestCase;
        int id = randomIntBetween(1, max - 1);
    public void testFromXContent() throws Exception {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            assertNotSame(sliceBuilder, secondSliceBuilder);
        return new IndexSettings(indexState, Settings.EMPTY);
        IndexMetadata indexState = IndexMetadata.builder("index").settings(settings).build();
                () -> builder.toFilter(null, createRequest(0), context, Version.CURRENT)
        int shardId
            for (int i = 0; i < numSlices; i++) {
            @Override
            Version version = VersionUtils.randomCompatibleVersion(random(), Version.CURRENT);
import java.util.Map;
            int numSlices = randomIntBetween(10, 100);
            assertThat(query, instanceOf(DocValuesSliceQuery.class));
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.action.OriginalIndices;
import org.opensearch.test.VersionUtils;
            // numSlices > numShards
            );
        switch (randomIntBetween(0, 2)) {
        e = expectThrows(IllegalArgumentException.class, () -> new SliceBuilder("field", 10, 5));
            public Query termQuery(Object value, @Nullable QueryShardContext context) {
            // numShards > numSlices
            Query query = builder.toFilter(null, createRequest(0), context, Version.CURRENT);
        SliceBuilder original = randomSliceBuilder();
            writer.commit();
        Directory dir = new ByteBuffersDirectory();
        }
        }
            Map<Integer, AtomicInteger> numSliceMap = new HashMap<>();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
/*
import org.opensearch.cluster.service.ClusterService;
        return new SliceBuilder(field, id, max);
                        AtomicInteger count = numSliceMap.get(j);
                    }
import java.util.List;
            // numShards == numSlices
        return new ShardSearchRequest(
import org.opensearch.index.mapper.MappedFieldType;
                return null;
 * this work for additional information regarding copyright
    }
import org.opensearch.cluster.routing.GroupShardsIterator;
import org.opensearch.common.xcontent.XContentType;
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.equalTo;
import org.apache.lucene.tests.analysis.MockAnalyzer;
                    Query q = slice.toFilter(null, createRequest(j), context, Version.CURRENT);
        e = expectThrows(IllegalArgumentException.class, () -> new SliceBuilder("field", 10, 0));
        }
            new ShardId("index", "index", shardId),
        DocValuesType dvType,
            }
import java.util.HashMap;
import static org.hamcrest.Matchers.containsString;
        Directory dir = new ByteBuffersDirectory();
        assertEquals("id must be greater than or equal to 0", e.getMessage());
