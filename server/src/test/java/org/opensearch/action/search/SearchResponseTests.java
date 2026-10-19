                assertEquals(originalFailure.shard(), parsedFailure.shard());
                    null,
                throw new ParsingException(parser.getTokenLocation(), "Expected a VALUE_STRING but got " + token);
                hits,
     * and the subsections xContent equivalence independently
    public void testSerializationWithSearchExtBuilders() throws IOException {
        int skippedClusters = totalClusters - successfulClusters;  
        static ParseField DUMMY_FIELD = new ParseField("fake");
        @Override  
                    expectedString.append("{\"total\":0,");
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());  
            1,
 * Licensed to Elasticsearch under one or more contributor  
                ShardSearchFailure originalFailure = failures[i];  
 * under the License.  
        assertNotEquals(phaseTookD, phaseTookA);
                {  
        assertEquals(searchResponse.getSkippedShards(), deserialized.getSkippedShards());  
                );
    }  
        protected final String id;
import static java.util.Collections.singletonMap;
import java.io.IOException;
     */  
            }
                    null,
        SearchResponse deserialized = copyWriteable(searchResponse, namedWriteableRegistry, SearchResponse::new, Version.V_2_9_0);
import org.opensearch.search.internal.InternalSearchResponse;  
                    expectedString.append("{\"total\":{\"value\":100,\"relation\":\"eq\"},");  
        assertEquals(searchResponse.getHits().getHits().length, deserialized.getHits().getHits().length);  
                    expectedString.append("\"skipped\":0,");
            mutated = insertRandomFields(xcontentType, originalBytes, null, random());
                    "OpenSearch exception [type=illegal_argument_exception, reason=" + nestedMsg + "]"  
            return this.id.equals(((DummySearchExtBuilder) obj).getId());
            shardSearchFailures,  
        @Override
                0,
    public void testSerializationWithSearchExtBuildersOnUnsupportedWriterVersion() throws IOException {
            ),
        if (minimal == false) {
        final ToXContent.Params params = new ToXContent.MapParams(singletonMap(RestSearchAction.TYPED_KEYS_PARAM, "true"));  
                numReducePhases,
            assertEquals(expectedString.toString(), Strings.toString(MediaTypeRegistry.JSON, response));
        static ParseField DUMMY_FIELD = new ParseField("dummy");
 */
    static SearchResponse.Clusters randomClusters() {  
                0,
            {
        BytesReference originalBytes = toShuffledXContent(response, xcontentType, params, humanReadable);
        SearchResponse response = createTestItem(false, extBuilders);
                    expectedString.append("\"fetch\":25,");
        SearchResponse searchResponse = createTestItem(false, List.of(new DummySearchExtBuilder(id)));
            new ProcessorExecutionDetail(
                0,
import org.opensearch.Version;
    public void testSearchResponsePhaseTookEquals() throws IOException {  
    public void testFromXContentWithUnregisteredSearchExtBuilders() throws IOException {
        assertEquals(searchResponse.getTotalShards(), deserialized.getTotalShards());  
                phaseTook,  
/*  
            assertEquals(searchResponse.getHits().getTotalHits().relation(), deserialized.getHits().getTotalHits().relation());  
            StringBuilder expectedString = new StringBuilder();
                    null,
        assertTrue(deserialized.getInternalResponse().getSearchExtBuilders().isEmpty());
                List.of(3),  
import java.util.List;  
                    expectedString.append("\"status\":\"").append(detail.getStatus().toString().toLowerCase(Locale.ROOT)).append("\",");  
            }
 * KIND, either express or implied.  See the License for the
        List<SearchExtBuilder> searchExtBuilders,
                    expectedString.append("\"successful\":0,");
            return builder.field(DUMMY_FIELD.getPreferredName(), id);  
    }
        assertEquals(extBuilders.size(), response.getInternalResponse().getSearchExtBuilders().size());
                        DummySearchExtBuilder.DUMMY_FIELD,  
        if (searchResponse.getHits().getTotalHits() == null) {
                }
            internalSearchResponse = InternalSearchResponse.empty();
    @Before
                0,
            return DUMMY_FIELD.getPreferredName();  
    static class FakeSearchExtBuilder extends DummySearchExtBuilder {
        } else {
        return createTestItem(false, shardSearchFailures);
        }
                null,
        int totalShards = randomIntBetween(1, Integer.MAX_VALUE);
                    expectedString.append("\"max_score\":1.5,");
                ),  
        assertEquals(searchResponse.getFailedShards(), deserialized.getFailedShards());
    }
    }  
                ShardSearchFailure.EMPTY_ARRAY,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertNotEquals(phaseTookA, phaseTookD);
import org.opensearch.search.aggregations.InternalAggregations;
 * You may obtain a copy of the License at  
    public void doFromXContentTestWithRandomFields(SearchResponse response, boolean addRandomFields) throws IOException {  
                ),  
                SearchResponse.Clusters.EMPTY,
            out.writeString(DUMMY_FIELD.getPreferredName());
        }
                expectedString.append("\"timed_out\":false,");  
                    expectedString.append("{\"total\":0,");  
     * This test adds random fields and objects to the xContent rendered out to  
    private SearchResponse createTestItem(boolean minimal, ShardSearchFailure... shardSearchFailures) {
    public void init() throws Exception {
            InternalAggregations aggregations = aggregationsTests.createTestInstance();
            assertEquals(searchResponse.getHits().getTotalHits().relation(), deserialized.getHits().getTotalHits().relation());
            expectedString.append("{");  
import org.junit.After;
        int totalClusters = randomIntBetween(0, 10);
        String dummyId = UUID.randomUUID().toString();
                }  
        assertEquals(searchResponse.getHits().getHits().length, deserialized.getHits().getHits().length);
import java.util.HashMap;
                ProcessorExecutionDetail.ProcessorStatus.SUCCESS,
                    expectedString.append("}");  
     * the failures in the parsed SearchResponse are wrapped in an extra OpenSearchException on the client side.  
        );
    }
        xContentRegistry = new NamedXContentRegistry(namedXContents);  
    }
import org.opensearch.search.SearchHits;
            null
import java.util.Map;
/*  
                );
        }
                null,
            }
                    expectedString.append("\"failed\":0},");  
        assertEquals(extBuilders.size(), actual.size());
        SearchHit[] hits = new SearchHit[] { hit };
        XContentBuilder builder = XContentBuilder.builder(MediaTypeRegistry.JSON.xContent());
        BytesReference mutated;
        assertEquals(searchResponse.getNumReducePhases(), deserialized.getNumReducePhases());  
                aggregations,  
 * Unless required by applicable law or agreed to in writing,
        {  
import org.opensearch.search.SearchModule;  
                expectedString.append("\"took\":0,");
        );
        }
import java.util.Collections;
 *    http://www.apache.org/licenses/LICENSE-2.0
            SearchResponse parsed = SearchResponse.fromXContent(parser);  
                    expectedString.append("{");  
            String id;
                expectedString.append("\"_clusters\":");
        InternalSearchResponse internalSearchResponse;
                expectedString.append("\"ext\":");
                for (int i = 0; i < processorResults.size(); i++) {
        }
import org.opensearch.core.common.io.stream.StreamOutput;  
        SearchResponse response = createTestItem(failures);
 * the Apache License, Version 2.0 (the "License"); you may
        String id = UUID.randomUUID().toString();
        assertEquals(
        aggregationsTests.cleanUp();
    );
                    expectedString.append("{\"dfs_pre_query\":0,");
        assertNotEquals(phaseTookA, phaseTookC);
        } else {  
                null  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        }
                    null,
        Map<String, Long> phaseTookMap = new HashMap<>();
                    expectedString.append("\"skipped\":2},");  
                    expectedString.append("{\"total\":{\"value\":100,\"relation\":\"eq\"},");
import org.opensearch.search.suggest.Suggest;
                "processor1",  
        }
        assertEquals(searchResponse.getSkippedShards(), deserialized.getSkippedShards());  
     */
     * fields to SearchHits, Aggregations etc... is tested in their own tests  
        SearchResponse parsed = SearchResponse.fromXContent(parser);
        public int hashCode() {
        } else {
                );
        long tookInMillis = randomNonNegativeLong();
                    new SearchExtSpec<>(
        assertEquals(1, searchResponse.getInternalResponse().getSearchExtBuilders().size());  
        for (int i = 0; i < failures.length; i++) {
                expectedString.append("[");  
            SearchResponse response = new SearchResponse(
    }  
        List<SearchExtBuilder> extBuilders = List.of(new DummySearchExtBuilder(dummyId), new FakeSearchExtBuilder(fakeId));  
        SearchResponse deserialized = copyWriteable(searchResponse, namedWriteableRegistry, SearchResponse::new, Version.CURRENT);
        public FakeSearchExtBuilder(String id) {
            assertNull(parser.nextToken());  
import java.util.Locale;
                {  
                {
            assertToXContentEquivalent(originalBytes, XContentHelper.toXContent(parsed, xcontentType, params, humanReadable), xcontentType);
    protected NamedXContentRegistry xContentRegistry() {  
            List<SearchExtBuilder> searchExtBuilders = response.getInternalResponse().getSearchExtBuilders();  
    private SearchResponse createMinimalTestItem() {  
    public SearchResponse createTestItem(
            skippedShards,  
import org.opensearch.common.settings.Settings;
        }
        {  
        }  
    /**
    public void testSerialization() throws IOException {
            SearchResponse response = new SearchResponse(  
                new SearchResponse.Clusters(5, 3, 2),
            assertNull(deserialized.getHits().getTotalHits());  
import org.opensearch.test.OpenSearchTestCase;
        namedXContents.addAll(SuggestTests.getDefaultNamedXContents());
    public void testFromXContent() throws IOException {
            internalSearchResponse,
    }
        final ToXContent.Params params = new ToXContent.MapParams(singletonMap(RestSearchAction.TYPED_KEYS_PARAM, "true"));
 * specific language governing permissions and limitations
    }  
        assertEquals(phaseTookA, phaseTookA);  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            assertEquals(searchResponse.getHits().getTotalHits().value(), deserialized.getHits().getTotalHits().value());
 *
            }
    }  
            new ProcessorExecutionDetail(
            }
        List<NamedXContentRegistry.Entry> namedXContents = new ArrayList<>(InternalAggregationTestCase.getDefaultNamedXContents());
                assertEquals(
 * GitHub history for details.
                    null,
                    List.of(new DummySearchExtBuilder(dummyId)),
                profileShardResults,
                phaseTookMap.put(searchPhaseName.getName(), 0L);  
            @Override
            0,
import org.opensearch.core.common.bytes.BytesReference;  
    public void cleanUp() throws Exception {
        boolean humanReadable = randomBoolean();
        String dummyId = UUID.randomUUID().toString();  
        doFromXContentTestWithRandomFields(createMinimalTestItem(), true);  
        new SearchModule(Settings.EMPTY, List.of(new SearchPlugin() {
                    expectedString.append("\"input_data\":").append(detail.getInputData()).append(",");
                    new SearchHits(hits, new TotalHits(100, TotalHits.Relation.EQUAL_TO), 1.5f),  
    }
        SearchResponse searchResponse = createTestItem(false);  
 * software distributed under the License is distributed on an
                        DummySearchExtBuilder::new,
    }
            if (id == null) {  
    }
            assertNull(deserialized.getHits().getTotalHits());  
                ProcessorExecutionDetail.ProcessorStatus.SUCCESS,
    public void testFromXContentWithRandomFields() throws IOException {
            for (int i = 0; i < parsed.getShardFailures().length; i++) {
            SearchResponse parsed = SearchResponse.fromXContent(parser);  
            return new DummySearchExtBuilder(id);  
            SearchProfileShardResults profileShardResults = SearchProfileShardResultsTests.createTestItem();  
        }
        try (XContentParser parser = createParser(xcontentType.xContent(), originalBytes)) {
            InternalSearchResponse.empty(),  
                expectedString.append("\"_shards\":");  
    }
            XContentParser.Token token = parser.currentToken();  
        public String getWriteableName() {
        );  
        @Override  
        }
                new InternalSearchResponse(
        SearchResponse deserialized = copyWriteable(searchResponse, namedWriteableRegistry, SearchResponse::new, Version.CURRENT);  
                    expectedString.append("\"dfs_query\":0,");
                "processor2",  
        assertEquals(phaseTookB, phaseTookB);
                {
import org.opensearch.common.xcontent.XContentType;
                    "OpenSearch exception [type=parsing_exception, reason=" + originalMsg + "]"
                expectedString.append("\"hits\":");
            return 0;  
                    expectedString.append("\"max_score\":1.5,");
import java.util.UUID;  
import org.junit.Before;  
                expectedString.append("\"hits\":");
                List.of(1),
                expectedString.append(",\"processor_results\":");
        int successfulShards = randomIntBetween(0, totalShards);
            expectedString.append("}");
        }
                    ProcessorExecutionDetail detail = processorResults.get(i);
        public void writeTo(StreamOutput out) throws IOException {  
        namedXContents.add(  
                    expectedString.append("\"skipped\":0,");
 * Modifications Copyright OpenSearch Contributors. See
        SearchResponse.PhaseTook phaseTookA = new SearchResponse.PhaseTook(Map.of("foo", 0L, "bar", 1L));
    /**
                }
    /**
                30,
        }
        if (searchResponse.getHits().getTotalHits() == null) {  
            );  
        return new SearchResponse(
                    null,  
                assertEquals(
                    expectedString.append("\"can_match\":0},");
        }  
        }
        return createTestItem(minimal, Collections.emptyList(), shardSearchFailures);
            phaseTookMap.put(searchPhaseName.getName(), randomNonNegativeLong());
                0,
    public void testToXContent() {
            mutated = originalBytes;  
                null
import org.opensearch.plugins.SearchPlugin;
        @Override
        for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {  
            assertEquals(searchResponse.getHits().getTotalHits().value(), deserialized.getHits().getTotalHits().value());
                throw new ParsingException(parser.getTokenLocation(), "no id specified for " + DUMMY_FIELD.getPreferredName());
                    expectedString.append("\"processor_name\":\"").append(detail.getProcessorName()).append("\",");
                String originalMsg = originalFailure.getCause().getMessage();
        assertEquals(searchResponse.getClusters(), deserialized.getClusters());
        }
import org.opensearch.search.profile.SearchProfileShardResults;
            Suggest suggest = SuggestTests.createTestItem();
        }
import org.opensearch.core.common.io.stream.StreamInput;
 * not use this file except in compliance with the License.
            assertEquals(searchResponse.getHits().getTotalHits().value(), deserialized.getHits().getTotalHits().value());  
    ) {  
    static class DummySearchExtBuilder extends SearchExtBuilder {  
        assertEquals(searchResponse.getFailedShards(), deserialized.getFailedShards());
        assertEquals(searchResponse.getTotalShards(), deserialized.getTotalShards());
                expectedString.append("\"timed_out\":false,");
        SearchResponse.PhaseTook phaseTookC = new SearchResponse.PhaseTook(Map.of("foo", 0L));  
                }
            assertEquals(searchResponse.getHits().getTotalHits().relation(), deserialized.getHits().getTotalHits().relation());  
        doFromXContentTestWithRandomFields(createTestItem(false, List.of(new DummySearchExtBuilder(UUID.randomUUID().toString()))), false);
/*
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.XContentParser;
    private SearchResponse createTestItem(ShardSearchFailure... shardSearchFailures) {
        assertEquals(searchResponse.getHits().getHits().length, deserialized.getHits().getHits().length);
     * ensure we can parse it back to be forward compatible with additions to
import org.opensearch.test.InternalAggregationTestCase;  
import org.opensearch.core.common.ParsingException;
                new InternalSearchResponse(
        boolean timedOut = randomBoolean();
        @Override
        }  
    @After  
            successfulShards,
import java.util.ArrayList;  
            phaseTookMap.put(SearchPhaseName.EXPAND.getName(), 30L);
                    null,  
        assertEquals(searchResponse.getFailedShards(), deserialized.getFailedShards());
                        parser -> DummySearchExtBuilder.parse(parser)
                    if (i < processorResults.size() - 1) {
            assertEquals(expectedString.toString(), Strings.toString(MediaTypeRegistry.JSON, response));
package org.opensearch.action.search;
            internalSearchResponse = new InternalSearchResponse(
        public static DummySearchExtBuilder parse(XContentParser parser) throws IOException {
 * license agreements. See the NOTICE file distributed with
            } else {  
        SearchResponse searchResponse = createTestItem(false, List.of(new DummySearchExtBuilder(id)));  
     * the "_shard/total/failures" section makes it impossible to directly
            assertNotNull(id);
public class SearchResponseTests extends OpenSearchTestCase {  
                    )  
            assertEquals(1, searchExtBuilders.size());
            randomBoolean() ? randomClusters() : SearchResponse.Clusters.EMPTY,
                }
                terminatedEarly,
                50,
import org.opensearch.search.SearchHit;  
                    expectedString.append("\"expand\":30,");  
        try (XContentParser parser = createParser(xcontentType.xContent(), mutated)) {
        assertNotEquals(phaseTookA, phaseTookB);  
    public void testFromXContentWithSearchExtBuilders() throws IOException {  
        boolean humanReadable = randomBoolean();  
    }
     * This SearchResponse doesn't include SearchHits, Aggregations, Suggestions, ShardSearchFailures, SearchProfileShardResults  
import org.opensearch.search.GenericSearchExtBuilder;
                {
                    }  
     */  
                id = parser.text();
                    parsedFailure.getCause().getCause().getMessage(),
                    1,  
        if (addRandomFields) {  
import org.opensearch.core.xcontent.MediaType;
        assertEquals(searchResponse.getNumReducePhases(), deserialized.getNumReducePhases());
        assertEquals(searchResponse.getClusters(), deserialized.getClusters());
    private static final NamedXContentRegistry xContentRegistry;
        }
        int numFailures = randomIntBetween(1, 5);
                    processorResults
    public void testToXContentEmptyClusters() throws IOException {
                }
        );
}  
            expectedString.append("}");  
    }
            1,  
        public DummySearchExtBuilder(String id) {  
        public void writeTo(StreamOutput out) throws IOException {
        SearchResponse.PhaseTook phaseTook = new SearchResponse.PhaseTook(phaseTookMap);  
                ShardSearchFailure.EMPTY_ARRAY,
     * to make it possible to only test properties of the SearchResponse itself
                0,  
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.search.aggregations.AggregationsTests;
 *  
        List<ProcessorExecutionDetail> processorResults = List.of(
            SearchHits hits = SearchHitsTests.createTestItem(true, true);  
                    parsedFailure.getCause().getMessage(),  
    public void testFromXContentWithFailures() throws IOException {
        SearchResponse deserialized = copyWriteable(searchResponse, namedWriteableRegistry, SearchResponse::new, Version.CURRENT);
 *
                    expectedString.append("\"hits\":[{\"_id\":\"id1\",\"_score\":2.0}]}");  
        int numReducePhases = randomIntBetween(1, 10);  
    }
        String fakeId = UUID.randomUUID().toString();
        BytesReference originalBytes = toShuffledXContent(response, xcontentType, params, humanReadable);
                    expectedString.append("{\"total\":5,");
                timedOut,  
            out.writeString(this.id);
import org.opensearch.core.xcontent.MediaTypeRegistry;
    /**
                List.of(1),  
        assertEquals(phaseTookC, phaseTookC);
    private AggregationsTests aggregationsTests = new AggregationsTests();
     * compare xContent, so we omit it here  
 * this work for additional information regarding copyright
import org.opensearch.core.xcontent.XContentHelper;  
import org.opensearch.core.common.Strings;
        @Override
                expectedString.append("\"phase_took\":");  
            deserialized.getInternalResponse().getSearchExtBuilders().get(0)
            if (!(obj instanceof DummySearchExtBuilder)) {  
 * ownership. Elasticsearch licenses this file to you under  
        MediaType xcontentType = randomFrom(XContentType.values());
        })).getNamedWriteables()  
        List<NamedXContentRegistry.Entry> namedXContents = new ArrayList<>(InternalAggregationTestCase.getDefaultNamedXContents());
        return xContentRegistry;
            searchResponse.getInternalResponse().getSearchExtBuilders().get(0),  
            if (obj == null) {
    @Override
 */  
        deserialized.getClusters().toXContent(builder, ToXContent.EMPTY_PARAMS);
                null,
                0,
                    expectedString.append("\"output_data\":").append(detail.getOutputData());
        ShardSearchFailure... shardSearchFailures
            new NamedXContentRegistry.Entry(SearchExtBuilder.class, DummySearchExtBuilder.DUMMY_FIELD, DummySearchExtBuilder::parse)
        XContentParser parser = createParser(new NamedXContentRegistry(namedXContents), xcontentType.xContent(), originalBytes);  
            }  
import org.opensearch.search.profile.SearchProfileShardResultsTests;  
                return false;  
    private final NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(  
    static {  
                    1
            phaseTookMap.put(SearchPhaseName.QUERY.getName(), 50L);
            failures[i] = ShardSearchFailureTests.createTestItem(IndexMetadata.INDEX_UUID_NA_VALUE);
     */
            ShardSearchFailure.EMPTY_ARRAY,  
        doFromXContentTestWithRandomFields(createTestItem(), false);  
            StringBuilder expectedString = new StringBuilder();
            assertNull(deserialized.getHits().getTotalHits());
            assertTrue(actual.get(0) instanceof GenericSearchExtBuilder);
    }
            }
        aggregationsTests.init();  
import org.opensearch.search.SearchHitsTests;
import static org.opensearch.test.XContentTestUtils.insertRandomFields;  
                null,
 */  
import org.apache.lucene.search.TotalHits;
            expectedString.append("{");
        public DummySearchExtBuilder(StreamInput in) throws IOException {
                    false,  
        if (searchResponse.getHits().getTotalHits() == null) {
        } else {
                suggest,
            public List<SearchExtSpec<?>> getSearchExts() {  
                expectedString.append("]");
        int successfulClusters = randomIntBetween(0, totalClusters);
                    null,
            }
        }
        assertEquals(searchResponse.getSkippedShards(), deserialized.getSkippedShards());
            Map<String, Long> phaseTookMap = new HashMap<>();
        assertEquals(searchResponse.getTotalShards(), deserialized.getTotalShards());
import org.opensearch.search.suggest.SuggestTests;
    /**
                    expectedString.append("\"successful\":0,");  
            assertNull(parser.nextToken());
        Boolean terminatedEarly = randomBoolean() ? null : randomBoolean();
                    expectedString.append("\"successful\":3,");
        List<SearchExtBuilder> actual = parsed.getInternalResponse().getSearchExtBuilders();
            phaseTookMap.put(SearchPhaseName.FETCH.getName(), 25L);  
                List.of(3),
 * compatible open source license.
                return false;
        return new SearchResponse.Clusters(totalClusters, successfulClusters, skippedClusters);
            this.id = in.readString();  
            {  
                        expectedString.append(",");
        }
        for (int i = 0; i < actual.size(); i++) {  
            this.id = id;
            totalShards,
            null,
        assertEquals(phaseTookD, phaseTookD);  
        SearchResponse searchResponse = new SearchResponse(
                expectedString.append("\"_shards\":");
        assertEquals(0, builder.toString().length());  
        } else {
        SearchResponse.PhaseTook phaseTookB = new SearchResponse.PhaseTook(Map.of("foo", 1L, "bar", 1L));
                return List.of(
        ShardSearchFailure[] failures = new ShardSearchFailure[numFailures];  
        assertEquals(searchResponse.getNumReducePhases(), deserialized.getNumReducePhases());  
        );
                assertEquals(originalFailure.shardId(), parsedFailure.shardId());  
            1,
        BytesReference originalBytes = toShuffledXContent(response, xcontentType, params, randomBoolean());
                    false,
        }  
                }
        final ToXContent.Params params = new ToXContent.MapParams(singletonMap(RestSearchAction.TYPED_KEYS_PARAM, "true"));  
                    new SearchHits(hits, new TotalHits(100, TotalHits.Relation.EQUAL_TO), 1.5f),
     * Because of this, in this special test case we compare the "top level" fields for equality
            SearchResponse.PhaseTook phaseTook = new SearchResponse.PhaseTook(phaseTookMap);
            if (token == XContentParser.Token.VALUE_STRING) {
            );
        public String getId() {  
        @Override
                ShardSearchFailure parsedFailure = parsed.getShardFailures()[i];
            super(id);
        hit.score(2.0f);
        SearchHit hit = new SearchHit(1, "id1", Collections.emptyMap(), Collections.emptyMap());  
            }
                searchExtBuilders,  
import org.opensearch.search.SearchExtBuilder;
                0,  
    }
                    expectedString.append("\"duration_millis\":").append(detail.getDurationMillis()).append(",");
    }
import org.opensearch.cluster.metadata.IndexMetadata;  
            for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
     */
                    expectedString.append("\"query\":50,");  
                {
                }  
import org.opensearch.search.pipeline.ProcessorExecutionDetail;
    }  
import org.opensearch.core.ParseField;  
        MediaType xcontentType = randomFrom(XContentType.values());
        }
            return this.id;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }  
                String nestedMsg = originalFailure.getCause().getCause().getMessage();  
            return builder.field("dummy", id);
        }
                null  
     * the xContent. We test this with a "minimal" SearchResponse, adding random
            );
    }
                null  
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
        SearchResponse.PhaseTook phaseTookD = new SearchResponse.PhaseTook(Map.of());
            phaseTook,
        assertNotEquals(phaseTookB, phaseTookA);
        int skippedShards = randomIntBetween(0, totalShards);  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
 * The OpenSearch Contributors require contributions made to  
            SearchResponse.Clusters.EMPTY
        assertNotEquals(phaseTookC, phaseTookA);  
            )
                assertEquals(originalFailure.index(), parsedFailure.index());
     * The "_shard/total/failures" section makes if impossible to directly compare xContent, because
        assertEquals(searchResponse.getClusters(), deserialized.getClusters());
                {
import org.opensearch.rest.action.search.RestSearchAction;  
        public boolean equals(Object obj) {
 * SPDX-License-Identifier: Apache-2.0
        XContentType xcontentType = randomFrom(XContentType.values());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        boolean minimal,  
            null,  
            tookInMillis,
     * if minimal is set, don't include search hits, aggregations, suggest etc... to make test simpler
        String id = UUID.randomUUID().toString();  
                Collections.emptyList()
                expectedString.append("\"took\":0,");
                    expectedString.append("{\"dummy\":\"" + dummyId + "\"}");  
                    expectedString.append("\"failed\":0},");
                    expectedString.append("\"hits\":[{\"_id\":\"id1\",\"_score\":2.0}]},");
import org.opensearch.core.xcontent.ToXContent;
        return createTestItem(true);
        namedXContents.addAll(SuggestTests.getDefaultNamedXContents());  
