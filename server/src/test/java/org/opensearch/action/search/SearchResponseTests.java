            1,
                }
import org.opensearch.search.SearchHitsTests;
            new NamedXContentRegistry.Entry(SearchExtBuilder.class, DummySearchExtBuilder.DUMMY_FIELD, DummySearchExtBuilder::parse)
import org.opensearch.cluster.metadata.IndexMetadata;
        public boolean equals(Object obj) {
            expectedString.append("{");
        String dummyId = UUID.randomUUID().toString();
            assertNull(deserialized.getHits().getTotalHits());
        SearchResponse deserialized = copyWriteable(searchResponse, namedWriteableRegistry, SearchResponse::new, Version.CURRENT);
                assertEquals(
            this.id = in.readString();
import org.opensearch.core.xcontent.XContentBuilder;
 * specific language governing permissions and limitations
                    expectedString.append("\"input_data\":").append(detail.getInputData()).append(",");
        String dummyId = UUID.randomUUID().toString();
            }
        int skippedClusters = totalClusters - successfulClusters;
                    false,
            for (int i = 0; i < parsed.getShardFailures().length; i++) {
                    false,
                expectedString.append("\"took\":0,");
                );
        xContentRegistry = new NamedXContentRegistry(namedXContents);
     * ensure we can parse it back to be forward compatible with additions to
        }
                    expectedString.append("\"query\":50,");
import org.opensearch.core.common.Strings;
 * Modifications Copyright OpenSearch Contributors. See
                phaseTook,
        {
            }
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.ArrayList;
            )
                String originalMsg = originalFailure.getCause().getMessage();
                expectedString.append("\"timed_out\":false,");
    public void cleanUp() throws Exception {
            {
     * the "_shard/total/failures" section makes it impossible to directly
            if (obj == null) {
                        DummySearchExtBuilder::new,
                ShardSearchFailure.EMPTY_ARRAY,
import org.opensearch.search.aggregations.AggregationsTests;
            }
                new InternalSearchResponse(
                }
            assertNull(deserialized.getHits().getTotalHits());
    }
        assertEquals(extBuilders.size(), response.getInternalResponse().getSearchExtBuilders().size());
        } else {
        SearchResponse deserialized = copyWriteable(searchResponse, namedWriteableRegistry, SearchResponse::new, Version.CURRENT);
                    expectedString.append("\"successful\":0,");
        if (searchResponse.getHits().getTotalHits() == null) {
        }
import org.opensearch.core.common.ParsingException;
        );
                {
            new ProcessorExecutionDetail(
        boolean timedOut = randomBoolean();
            assertTrue(actual.get(0) instanceof GenericSearchExtBuilder);
        }
 * GitHub history for details.
        }
    }
                expectedString.append("]");
                throw new ParsingException(parser.getTokenLocation(), "no id specified for " + DUMMY_FIELD.getPreferredName());
        } else {
        assertEquals(searchResponse.getTotalShards(), deserialized.getTotalShards());
        public String getWriteableName() {
     */
 * under the License.
            assertEquals(searchResponse.getHits().getTotalHits().value(), deserialized.getHits().getTotalHits().value());
            SearchResponse response = new SearchResponse(
                String nestedMsg = originalFailure.getCause().getCause().getMessage();
    public void testToXContent() {
                    expectedString.append("\"duration_millis\":").append(detail.getDurationMillis()).append(",");
            expectedString.append("{");
import org.opensearch.core.common.io.stream.StreamInput;
        @Override
}
            SearchResponse parsed = SearchResponse.fromXContent(parser);
        SearchHit hit = new SearchHit(1, "id1", Collections.emptyMap(), Collections.emptyMap());
                aggregations,
        int skippedShards = randomIntBetween(0, totalShards);
                }
        }
import org.junit.After;
        BytesReference originalBytes = toShuffledXContent(response, xcontentType, params, humanReadable);
                    null,
            null,
    );
            null
        ShardSearchFailure[] failures = new ShardSearchFailure[numFailures];
    }
     * to make it possible to only test properties of the SearchResponse itself
    }
        assertNotEquals(phaseTookA, phaseTookB);
        @Override
/*
        assertEquals(phaseTookA, phaseTookA);
        @Override
 * software distributed under the License is distributed on an
        BytesReference originalBytes = toShuffledXContent(response, xcontentType, params, randomBoolean());
                    "OpenSearch exception [type=illegal_argument_exception, reason=" + nestedMsg + "]"
                {
        return xContentRegistry;
                expectedString.append("\"hits\":");
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.xcontent.XContentHelper;
    /**
     * This test adds random fields and objects to the xContent rendered out to
    /**
        assertEquals(searchResponse.getFailedShards(), deserialized.getFailedShards());
    }
    private static final NamedXContentRegistry xContentRegistry;
            failures[i] = ShardSearchFailureTests.createTestItem(IndexMetadata.INDEX_UUID_NA_VALUE);
                List.of(1),
            }
            SearchResponse.Clusters.EMPTY
 * KIND, either express or implied.  See the License for the
    @Before
import org.opensearch.common.settings.Settings;
                new InternalSearchResponse(
                searchExtBuilders,
            deserialized.getInternalResponse().getSearchExtBuilders().get(0)
 *
                hits,
                }
     * This SearchResponse doesn't include SearchHits, Aggregations, Suggestions, ShardSearchFailures, SearchProfileShardResults
     */
        List<ProcessorExecutionDetail> processorResults = List.of(
            phaseTook,
        BytesReference mutated;
        boolean humanReadable = randomBoolean();
    /**
            @Override
            SearchHits hits = SearchHitsTests.createTestItem(true, true);
                    List.of(new DummySearchExtBuilder(dummyId)),
                return false;
        int numFailures = randomIntBetween(1, 5);
            return builder.field(DUMMY_FIELD.getPreferredName(), id);
 * Unless required by applicable law or agreed to in writing,
                50,
                    expectedString.append("\"expand\":30,");
            XContentParser.Token token = parser.currentToken();
                expectedString.append(",\"processor_results\":");
                    parsedFailure.getCause().getMessage(),
        }
 * ownership. Elasticsearch licenses this file to you under
        MediaType xcontentType = randomFrom(XContentType.values());
        XContentBuilder builder = XContentBuilder.builder(MediaTypeRegistry.JSON.xContent());
        int totalShards = randomIntBetween(1, Integer.MAX_VALUE);
        );
        }
            ),
 * not use this file except in compliance with the License.
        assertEquals(phaseTookC, phaseTookC);
                    expectedString.append("\"hits\":[{\"_id\":\"id1\",\"_score\":2.0}]}");
        List<NamedXContentRegistry.Entry> namedXContents = new ArrayList<>(InternalAggregationTestCase.getDefaultNamedXContents());
 */
            internalSearchResponse = new InternalSearchResponse(
    private AggregationsTests aggregationsTests = new AggregationsTests();
        int numReducePhases = randomIntBetween(1, 10);
    }
import java.util.Locale;
                assertEquals(originalFailure.shardId(), parsedFailure.shardId());
                expectedString.append("\"phase_took\":");
            }
    }
import java.util.HashMap;
                ),
                    if (i < processorResults.size() - 1) {
        }
        assertEquals(1, searchResponse.getInternalResponse().getSearchExtBuilders().size());
    ) {
                0,
            successfulShards,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                ProcessorExecutionDetail.ProcessorStatus.SUCCESS,
            assertEquals(expectedString.toString(), Strings.toString(MediaTypeRegistry.JSON, response));
import java.util.List;
                ProcessorExecutionDetail.ProcessorStatus.SUCCESS,
 */
                0,
            StringBuilder expectedString = new StringBuilder();
    }
     */
            );
 *
        assertEquals(searchResponse.getSkippedShards(), deserialized.getSkippedShards());
        SearchResponse parsed = SearchResponse.fromXContent(parser);
            Map<String, Long> phaseTookMap = new HashMap<>();
        String id = UUID.randomUUID().toString();
        @Override
    static SearchResponse.Clusters randomClusters() {
    }
                30,
            assertEquals(1, searchExtBuilders.size());
        doFromXContentTestWithRandomFields(createTestItem(false, List.of(new DummySearchExtBuilder(UUID.randomUUID().toString()))), false);
import org.opensearch.search.GenericSearchExtBuilder;
            mutated = originalBytes;
        final ToXContent.Params params = new ToXContent.MapParams(singletonMap(RestSearchAction.TYPED_KEYS_PARAM, "true"));
            phaseTookMap.put(SearchPhaseName.FETCH.getName(), 25L);
            );
            out.writeString(DUMMY_FIELD.getPreferredName());
    public void testToXContentEmptyClusters() throws IOException {
                0,
 * SPDX-License-Identifier: Apache-2.0
                }
                    ProcessorExecutionDetail detail = processorResults.get(i);
            1,
                {
                suggest,
    }
        if (minimal == false) {
            this.id = id;
                    null,
            return this.id.equals(((DummySearchExtBuilder) obj).getId());
                    null,
        );
        }
import org.opensearch.search.SearchHit;
     * if minimal is set, don't include search hits, aggregations, suggest etc... to make test simpler
package org.opensearch.action.search;
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    expectedString.append("{\"total\":0,");
        doFromXContentTestWithRandomFields(createMinimalTestItem(), true);
        XContentParser parser = createParser(new NamedXContentRegistry(namedXContents), xcontentType.xContent(), originalBytes);
    static class DummySearchExtBuilder extends SearchExtBuilder {
        assertEquals(searchResponse.getFailedShards(), deserialized.getFailedShards());
            } else {
import java.util.UUID;
import org.opensearch.search.internal.InternalSearchResponse;
                assertEquals(originalFailure.index(), parsedFailure.index());
import java.util.Collections;
            public List<SearchExtSpec<?>> getSearchExts() {
        assertEquals(searchResponse.getHits().getHits().length, deserialized.getHits().getHits().length);
        static ParseField DUMMY_FIELD = new ParseField("dummy");
        assertEquals(searchResponse.getNumReducePhases(), deserialized.getNumReducePhases());
        @Override
import org.opensearch.core.common.bytes.BytesReference;
        public DummySearchExtBuilder(String id) {
import org.opensearch.search.profile.SearchProfileShardResultsTests;
                numReducePhases,
                0,
        @Override
        assertEquals(searchResponse.getSkippedShards(), deserialized.getSkippedShards());
        } else {
                List.of(1),
                );
            assertEquals(searchResponse.getHits().getTotalHits().relation(), deserialized.getHits().getTotalHits().relation());
            shardSearchFailures,
    }
            null,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    expectedString.append("\"status\":\"").append(detail.getStatus().toString().toLowerCase(Locale.ROOT)).append("\",");
        boolean minimal,
            if (token == XContentParser.Token.VALUE_STRING) {
 * You may obtain a copy of the License at
        new SearchModule(Settings.EMPTY, List.of(new SearchPlugin() {
    protected NamedXContentRegistry xContentRegistry() {
        public void writeTo(StreamOutput out) throws IOException {
    }
                null
import org.opensearch.core.xcontent.NamedXContentRegistry;
    public void testSerializationWithSearchExtBuildersOnUnsupportedWriterVersion() throws IOException {
/*
        assertTrue(deserialized.getInternalResponse().getSearchExtBuilders().isEmpty());
            skippedShards,
        assertEquals(searchResponse.getSkippedShards(), deserialized.getSkippedShards());
        namedXContents.addAll(SuggestTests.getDefaultNamedXContents());
                {
        }
                    expectedString.append("{\"total\":{\"value\":100,\"relation\":\"eq\"},");
    }
        SearchResponse deserialized = copyWriteable(searchResponse, namedWriteableRegistry, SearchResponse::new, Version.CURRENT);
        public FakeSearchExtBuilder(String id) {
                    expectedString.append("\"max_score\":1.5,");
                throw new ParsingException(parser.getTokenLocation(), "Expected a VALUE_STRING but got " + token);
        assertEquals(
                }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        for (int i = 0; i < failures.length; i++) {
                    expectedString.append("\"max_score\":1.5,");
    @After
        XContentType xcontentType = randomFrom(XContentType.values());
            String id;
        hit.score(2.0f);
            }
            return builder.field("dummy", id);
        assertEquals(searchResponse.getNumReducePhases(), deserialized.getNumReducePhases());
            SearchProfileShardResults profileShardResults = SearchProfileShardResultsTests.createTestItem();
                {
        int successfulShards = randomIntBetween(0, totalShards);
        ShardSearchFailure... shardSearchFailures
        return createTestItem(minimal, Collections.emptyList(), shardSearchFailures);
        Boolean terminatedEarly = randomBoolean() ? null : randomBoolean();
                null
        assertEquals(searchResponse.getClusters(), deserialized.getClusters());
        assertEquals(searchResponse.getTotalShards(), deserialized.getTotalShards());
                }
import org.opensearch.core.xcontent.XContentParser;
                expectedString.append("\"_shards\":");
        if (searchResponse.getHits().getTotalHits() == null) {
    }
                0,
        assertEquals(searchResponse.getNumReducePhases(), deserialized.getNumReducePhases());
                        expectedString.append(",");
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
                expectedString.append("\"timed_out\":false,");
        namedXContents.add(
    public void testFromXContentWithRandomFields() throws IOException {
                );
                    expectedString.append("\"skipped\":0,");
                timedOut,
                "processor1",
        assertNotEquals(phaseTookB, phaseTookA);
                    expectedString.append("{\"dfs_pre_query\":0,");
            return 0;
    }
    public void testSerialization() throws IOException {
    public void init() throws Exception {
            assertNull(deserialized.getHits().getTotalHits());
        protected final String id;
        SearchResponse.PhaseTook phaseTook = new SearchResponse.PhaseTook(phaseTookMap);
            internalSearchResponse,
import org.opensearch.core.xcontent.ToXContent;
            new ProcessorExecutionDetail(
                null,
    static class FakeSearchExtBuilder extends DummySearchExtBuilder {
        namedXContents.addAll(SuggestTests.getDefaultNamedXContents());
        }
        List<NamedXContentRegistry.Entry> namedXContents = new ArrayList<>(InternalAggregationTestCase.getDefaultNamedXContents());
                null,
 */
/*
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
                    null,
        }
                    null,
        final ToXContent.Params params = new ToXContent.MapParams(singletonMap(RestSearchAction.TYPED_KEYS_PARAM, "true"));
                    expectedString.append("\"processor_name\":\"").append(detail.getProcessorName()).append("\",");
import org.opensearch.search.SearchHits;
                    expectedString.append("\"output_data\":").append(detail.getOutputData());
        assertNotEquals(phaseTookC, phaseTookA);
                    expectedString.append("\"skipped\":2},");
import org.opensearch.common.xcontent.XContentType;
        final ToXContent.Params params = new ToXContent.MapParams(singletonMap(RestSearchAction.TYPED_KEYS_PARAM, "true"));
                    parsedFailure.getCause().getCause().getMessage(),
        }
            ShardSearchFailure.EMPTY_ARRAY,
                id = parser.text();
        assertNotEquals(phaseTookD, phaseTookA);
            randomBoolean() ? randomClusters() : SearchResponse.Clusters.EMPTY,
        public DummySearchExtBuilder(StreamInput in) throws IOException {
            1,
        int successfulClusters = randomIntBetween(0, totalClusters);
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
        public static DummySearchExtBuilder parse(XContentParser parser) throws IOException {
                    expectedString.append("\"fetch\":25,");
import org.junit.Before;
            totalShards,
        {
     * The "_shard/total/failures" section makes if impossible to directly compare xContent, because
                ShardSearchFailure parsedFailure = parsed.getShardFailures()[i];
        SearchResponse.PhaseTook phaseTookA = new SearchResponse.PhaseTook(Map.of("foo", 0L, "bar", 1L));
        return new SearchResponse(
        SearchResponse searchResponse = createTestItem(false);
                    new SearchHits(hits, new TotalHits(100, TotalHits.Relation.EQUAL_TO), 1.5f),
    public void doFromXContentTestWithRandomFields(SearchResponse response, boolean addRandomFields) throws IOException {
import java.io.IOException;
import org.opensearch.plugins.SearchPlugin;
 *
            phaseTookMap.put(SearchPhaseName.QUERY.getName(), 50L);
    }
        );
import org.opensearch.core.xcontent.MediaType;
            InternalAggregations aggregations = aggregationsTests.createTestInstance();
     * and the subsections xContent equivalence independently
            Suggest suggest = SuggestTests.createTestItem();
        long tookInMillis = randomNonNegativeLong();
                        parser -> DummySearchExtBuilder.parse(parser)
            assertEquals(searchResponse.getHits().getTotalHits().value(), deserialized.getHits().getTotalHits().value());
        return createTestItem(true);
                ),
import org.apache.lucene.search.TotalHits;
        String id = UUID.randomUUID().toString();
import java.util.Map;
                    expectedString.append("{\"total\":{\"value\":100,\"relation\":\"eq\"},");
                return List.of(
                    expectedString.append("\"failed\":0},");
import org.opensearch.search.SearchExtBuilder;
        SearchResponse.PhaseTook phaseTookD = new SearchResponse.PhaseTook(Map.of());
    }
    private SearchResponse createTestItem(ShardSearchFailure... shardSearchFailures) {
            if (id == null) {
                List.of(3),
        assertNotEquals(phaseTookA, phaseTookD);
        public int hashCode() {
import org.opensearch.test.OpenSearchTestCase;
            internalSearchResponse = InternalSearchResponse.empty();
        }
                    expectedString.append("\"successful\":3,");
import org.opensearch.search.profile.SearchProfileShardResults;
        for (int i = 0; i < actual.size(); i++) {
        } else {
        SearchResponse searchResponse = new SearchResponse(
                expectedString.append("\"took\":0,");
            List<SearchExtBuilder> searchExtBuilders = response.getInternalResponse().getSearchExtBuilders();
                {
        }
                    null,
        assertEquals(searchResponse.getHits().getHits().length, deserialized.getHits().getHits().length);
        static ParseField DUMMY_FIELD = new ParseField("fake");
                    null,
    public SearchResponse createTestItem(
import org.opensearch.search.suggest.Suggest;
            assertEquals(searchResponse.getHits().getTotalHits().relation(), deserialized.getHits().getTotalHits().relation());
        SearchResponse response = createTestItem(failures);
            assertNotNull(id);
     * the xContent. We test this with a "minimal" SearchResponse, adding random
            assertEquals(expectedString.toString(), Strings.toString(MediaTypeRegistry.JSON, response));
        assertEquals(searchResponse.getFailedShards(), deserialized.getFailedShards());
                    processorResults
        assertEquals(searchResponse.getHits().getHits().length, deserialized.getHits().getHits().length);
            assertToXContentEquivalent(originalBytes, XContentHelper.toXContent(parsed, xcontentType, params, humanReadable), xcontentType);
                expectedString.append("\"hits\":");
            assertNull(parser.nextToken());
    /**
        int totalClusters = randomIntBetween(0, 10);
                null,
        }
                    expectedString.append("\"successful\":0,");
     */
            searchResponse.getInternalResponse().getSearchExtBuilders().get(0),
                ShardSearchFailure originalFailure = failures[i];
                    expectedString.append("{\"total\":5,");
            out.writeString(this.id);
                0,
        boolean humanReadable = randomBoolean();
                expectedString.append("\"_clusters\":");
        SearchResponse searchResponse = createTestItem(false, List.of(new DummySearchExtBuilder(id)));
        }
        deserialized.getClusters().toXContent(builder, ToXContent.EMPTY_PARAMS);
    }
                    expectedString.append("{\"dummy\":\"" + dummyId + "\"}");
        assertEquals(extBuilders.size(), actual.size());
        assertNotEquals(phaseTookA, phaseTookC);
        assertEquals(phaseTookD, phaseTookD);
        assertEquals(searchResponse.getTotalShards(), deserialized.getTotalShards());
        List<SearchExtBuilder> extBuilders = List.of(new DummySearchExtBuilder(dummyId), new FakeSearchExtBuilder(fakeId));
    /**
                    new SearchExtSpec<>(
                    1,
                    new SearchHits(hits, new TotalHits(100, TotalHits.Relation.EQUAL_TO), 1.5f),
            expectedString.append("}");
                assertEquals(
        SearchResponse.PhaseTook phaseTookC = new SearchResponse.PhaseTook(Map.of("foo", 0L));
    }
        if (searchResponse.getHits().getTotalHits() == null) {
                null
        SearchResponse response = createTestItem(false, extBuilders);
     * the failures in the parsed SearchResponse are wrapped in an extra OpenSearchException on the client side.
                    expectedString.append("\"dfs_query\":0,");
                for (int i = 0; i < processorResults.size(); i++) {
                    expectedString.append("\"hits\":[{\"_id\":\"id1\",\"_score\":2.0}]},");
        }
    private SearchResponse createMinimalTestItem() {
                    expectedString.append("\"skipped\":0,");
                {
 * compatible open source license.
        try (XContentParser parser = createParser(xcontentType.xContent(), mutated)) {
                    null,
        try (XContentParser parser = createParser(xcontentType.xContent(), originalBytes)) {
        public String getId() {
import org.opensearch.search.aggregations.InternalAggregations;
            InternalSearchResponse.empty(),
        aggregationsTests.cleanUp();
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public void testFromXContentWithSearchExtBuilders() throws IOException {
import org.opensearch.Version;
        );
                "processor2",
                    expectedString.append("\"failed\":0},");
                    expectedString.append("\"can_match\":0},");
        if (addRandomFields) {
        assertEquals(phaseTookB, phaseTookB);
    }
                Collections.emptyList()
            super(id);
    @Override
    public void testFromXContentWithUnregisteredSearchExtBuilders() throws IOException {
import org.opensearch.search.SearchModule;
    }
            for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
        MediaType xcontentType = randomFrom(XContentType.values());
    public void testFromXContentWithFailures() throws IOException {
                    1
                }
        BytesReference originalBytes = toShuffledXContent(response, xcontentType, params, humanReadable);
import static java.util.Collections.singletonMap;
            phaseTookMap.put(SearchPhaseName.EXPAND.getName(), 30L);
            StringBuilder expectedString = new StringBuilder();
        }
            }
import org.opensearch.test.InternalAggregationTestCase;
                    expectedString.append("}");
            assertNull(parser.nextToken());
                null
 * Licensed to Elasticsearch under one or more contributor
            assertEquals(searchResponse.getHits().getTotalHits().value(), deserialized.getHits().getTotalHits().value());
            mutated = insertRandomFields(xcontentType, originalBytes, null, random());
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.ParseField;
        InternalSearchResponse internalSearchResponse;
     * Because of this, in this special test case we compare the "top level" fields for equality
            0,
            SearchResponse response = new SearchResponse(
        doFromXContentTestWithRandomFields(createTestItem(), false);
        }
 * this work for additional information regarding copyright
    public void testSerializationWithSearchExtBuilders() throws IOException {
            if (!(obj instanceof DummySearchExtBuilder)) {
     * fields to SearchHits, Aggregations etc... is tested in their own tests
            }
                0,
     * compare xContent, so we omit it here
     */
        List<SearchExtBuilder> searchExtBuilders,
            return this.id;
                SearchResponse.Clusters.EMPTY,
        List<SearchExtBuilder> actual = parsed.getInternalResponse().getSearchExtBuilders();
                List.of(3),
    private SearchResponse createTestItem(boolean minimal, ShardSearchFailure... shardSearchFailures) {
            return DUMMY_FIELD.getPreferredName();
            );
                new SearchResponse.Clusters(5, 3, 2),
        return createTestItem(false, shardSearchFailures);
                phaseTookMap.put(searchPhaseName.getName(), 0L);
        Map<String, Long> phaseTookMap = new HashMap<>();
 * The OpenSearch Contributors require contributions made to
                    }
        String fakeId = UUID.randomUUID().toString();
                assertEquals(originalFailure.shard(), parsedFailure.shard());
            expectedString.append("}");
public class SearchResponseTests extends OpenSearchTestCase {
        SearchResponse searchResponse = createTestItem(false, List.of(new DummySearchExtBuilder(id)));
            phaseTookMap.put(searchPhaseName.getName(), randomNonNegativeLong());
        })).getNamedWriteables()
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
        }
        public void writeTo(StreamOutput out) throws IOException {
                expectedString.append("\"ext\":");
            SearchResponse parsed = SearchResponse.fromXContent(parser);
            {
                0,
        assertEquals(searchResponse.getClusters(), deserialized.getClusters());
            assertEquals(searchResponse.getHits().getTotalHits().relation(), deserialized.getHits().getTotalHits().relation());
        SearchResponse.PhaseTook phaseTookB = new SearchResponse.PhaseTook(Map.of("foo", 1L, "bar", 1L));
import org.opensearch.search.suggest.SuggestTests;
        @Override
                    "OpenSearch exception [type=parsing_exception, reason=" + originalMsg + "]"
    public void testFromXContent() throws IOException {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.rest.action.search.RestSearchAction;
                ShardSearchFailure.EMPTY_ARRAY,
import org.opensearch.search.pipeline.ProcessorExecutionDetail;
                terminatedEarly,
            SearchResponse.PhaseTook phaseTook = new SearchResponse.PhaseTook(phaseTookMap);
                    )
        }
 * this file be licensed under the Apache-2.0 license or a
        SearchHit[] hits = new SearchHit[] { hit };
        }
            return new DummySearchExtBuilder(id);
        assertEquals(0, builder.toString().length());
                        DummySearchExtBuilder.DUMMY_FIELD,
    }
                null,
    static {
                    expectedString.append("{\"total\":0,");
                return false;
            }
        } else {
        assertEquals(searchResponse.getClusters(), deserialized.getClusters());
                expectedString.append("\"_shards\":");
                expectedString.append("[");
            tookInMillis,
                profileShardResults,
    public void testSearchResponsePhaseTookEquals() throws IOException {
    private final NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(
    }
        aggregationsTests.init();
        SearchResponse deserialized = copyWriteable(searchResponse, namedWriteableRegistry, SearchResponse::new, Version.V_2_9_0);
        }
        return new SearchResponse.Clusters(totalClusters, successfulClusters, skippedClusters);
                    expectedString.append("{");
