        @Override
            createTestItem(false, List.of(new GenericSearchExtBuilder(List.of("1", "2", "3"), GenericSearchExtBuilder.ValueType.LIST))),
    static SearchResponse.Clusters randomClusters() {
            false,
            return Objects.hash(this.getClass(), this.map);
        } else {
        public void writeTo(StreamOutput out) throws IOException {
    // This test case fails because GenericSearchExtBuilder does not retain the name of the SearchExtBuilder that it is replacing.
import org.opensearch.common.settings.Settings;
        long tookInMillis = randomNonNegativeLong();
        assertEquals(searchResponse.getNumReducePhases(), deserialized.getNumReducePhases());
        assertEquals(searchResponse.getTotalShards(), deserialized.getTotalShards());
    private final NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(
        @Override
            internalSearchResponse = new InternalSearchResponse(
            new ListSearchExtBuilder(List.of("1", "2", "3"))
        SearchResponse deserialized = copyWriteable(searchResponse, namedWriteableRegistry, SearchResponse::new, Version.CURRENT);
        private final List<String> list;
        );
        @Override
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.search.internal.InternalSearchResponse;
    }
        if (searchResponse.getHits().getTotalHits() == null) {
import org.junit.After;
            assertEquals(searchResponse.getHits().getTotalHits().relation(), deserialized.getHits().getTotalHits().relation());
        @Override
        String dummyId = UUID.randomUUID().toString();
                GenericSearchExtBuilder::fromXContent
import org.opensearch.core.xcontent.ToXContent;
            Suggest suggest = SuggestTests.createTestItem();
        if (searchResponse.getHits().getTotalHits() == null) {
    }
        public int hashCode() {
            List.of(new GenericSearchExtBuilder(id, GenericSearchExtBuilder.ValueType.SIMPLE))
import java.util.Map;
import org.opensearch.core.common.io.stream.StreamOutput;
            List.of(new GenericSearchExtBuilder(Map.of("x", "y", "a", "b"), GenericSearchExtBuilder.ValueType.MAP))
        srt.doFromXContentTestWithRandomFields(
        boolean humanReadable = randomBoolean();
        public void writeTo(StreamOutput out) throws IOException {
        public int hashCode() {
                        GenericSearchExtBuilder::fromXContent
    }
                numReducePhases,
        assertEquals(searchResponse.getSkippedShards(), deserialized.getSkippedShards());
        assertEquals(
    }
            SearchProfileShardResults profileShardResults = SearchProfileShardResultsTests.createTestItem();
        int successfulClusters = randomIntBetween(0, totalClusters);
            return this.id;
        XContentParser parser = createParser(new NamedXContentRegistry(namedXContents), xcontentType.xContent(), originalBytes);
    static class SimpleValueSearchExtBuilder extends SearchExtBuilder {
    protected NamedXContentRegistry xContentRegistry() {
        @Override
    @Override
        public String getWriteableName() {
import org.opensearch.action.search.SearchResponseTests;
            this.id = id;
                searchExtBuilders,
        public static SimpleValueSearchExtBuilder parse(XContentParser parser) throws IOException {
        @Override
            }
            }
        boolean timedOut = randomBoolean();
        ShardSearchFailure... shardSearchFailures
import java.util.Objects;
        );
 *
        }
            deserialized.getInternalResponse().getSearchExtBuilders().get(0)
import org.opensearch.core.common.io.stream.StreamInput;
        );
            return false;
            out.writeString(this.id);
        int numReducePhases = randomIntBetween(1, 10);
                throw new ParsingException(parser.getTokenLocation(), "no id specified for " + FIELD.getPreferredName());
            list.forEach(e -> this.list.add(e));
import org.opensearch.test.InternalAggregationTestCase;
            internalSearchResponse = InternalSearchResponse.empty();
    private static final NamedXContentRegistry xContentRegistry;
        }
            return this.id.equals(((SimpleValueSearchExtBuilder) obj).getId());
        SearchResponse response = srt.createTestItem(false, extBuilders);
        String dummyId = UUID.randomUUID().toString();
            deserialized.getInternalResponse().getSearchExtBuilders().get(0)
        }
        for (int i = 0; i < actual.size(); i++) {
        SearchResponse searchResponse = createTestItem(
        int skippedShards = randomIntBetween(0, totalShards);
        public int hashCode() {
        boolean minimal,
        aggregationsTests.init();
        );
        assertEquals(extBuilders.size(), response.getInternalResponse().getSearchExtBuilders().size());
    public void testSerializationWithGenericSearchExtBuildersForListValues() throws IOException {
            deserialized.getInternalResponse().getSearchExtBuilders().get(0)
            if (id == null) {
        srt.doFromXContentTestWithRandomFields(
import org.opensearch.plugins.SearchPlugin;
        }
    public void init() throws Exception {
        public String getWriteableName() {
        xContentRegistry = new NamedXContentRegistry(namedXContents);
            return false;
        if (searchResponse.getHits().getTotalHits() == null) {
        assertEquals(searchResponse.getHits().getHits().length, deserialized.getHits().getHits().length);
        private final String id;
        assertEquals(searchResponse.getHits().getHits().length, deserialized.getHits().getHits().length);
            internalSearchResponse,
                        GenericSearchExtBuilder.EXT_BUILDER_NAME,
        } else {
        }
            assertNull(deserialized.getHits().getTotalHits());
        assertEquals(searchResponse.getClusters(), deserialized.getClusters());
        private final Map<String, Object> map;
    }
            return Objects.hash(this.getClass(), this.list);
        SearchResponse deserialized = copyWriteable(searchResponse, namedWriteableRegistry, SearchResponse::new, Version.CURRENT);
        SearchResponse deserialized = copyWriteable(searchResponse, namedWriteableRegistry, SearchResponse::new, Version.CURRENT);
                profileShardResults,
                throw new ParsingException(parser.getTokenLocation(), "Expected a VALUE_STRING but got " + token);
        public boolean equals(Object obj) {
        List<SearchExtBuilder> actual = parsed.getInternalResponse().getSearchExtBuilders();
            skippedShards,
                    )
        InternalSearchResponse internalSearchResponse;
import java.util.HashMap;
 * The OpenSearch Contributors require contributions made to
            assertTrue(actual.get(0) instanceof GenericSearchExtBuilder);
        }
        }
        assertEquals(searchResponse.getFailedShards(), deserialized.getFailedShards());
        return new SearchResponse(
        }
        public boolean equals(Object obj) {
    // String dummyId = UUID.randomUUID().toString();
        assertEquals(extBuilders.size(), actual.size());
            createTestItem(false, List.of(new GenericSearchExtBuilder(Map.of("x", "y", "a", "b"), GenericSearchExtBuilder.ValueType.MAP))),
        public void writeTo(StreamOutput out) throws IOException {
            tookInMillis,
    }
import org.opensearch.rest.action.search.RestSearchAction;
    static class ListSearchExtBuilder extends SearchExtBuilder {
        }
    public void testFromXContentWithUnregisteredSearchExtBuilders() throws IOException {
            }
            false,
        namedXContents.add(
        }
import org.opensearch.core.xcontent.XContentParser;
        }
            assertNull(deserialized.getHits().getTotalHits());
        assertEquals(
                );
        @Override
        assertEquals(searchResponse.getFailedShards(), deserialized.getFailedShards());
            }
            return 0;
            assertEquals(searchResponse.getHits().getTotalHits().relation(), deserialized.getHits().getTotalHits().relation());
            new NamedXContentRegistry.Entry(
import org.opensearch.search.profile.SearchProfileShardResultsTests;
package org.opensearch.search;
    public void testFromXContentWithGenericSearchExtBuildersForListValues() throws IOException {
    );
import org.opensearch.core.xcontent.XContentBuilder;
        );
            out.writeCollection(this.list, StreamOutput::writeString);
    }
        );
    public void testFromXContentWithGenericSearchExtBuildersForMapValues() throws IOException {
import java.util.List;
        SearchResponse searchResponse = createTestItem(
import org.opensearch.core.common.bytes.BytesReference;
public class GenericSearchExtBuilderTests extends OpenSearchTestCase {
        List<SearchExtBuilder> searchExtBuilders,
        private final static String EXT_FIELD = "list0";
    // }
                return false;
        MediaType xcontentType = randomFrom(XContentType.values());
        final ToXContent.Params params = new ToXContent.MapParams(singletonMap(RestSearchAction.TYPED_KEYS_PARAM, "true"));
        }
                        GenericSearchExtBuilder::new,
            for (Map.Entry<String, String> e : map.entrySet()) {
        srt.doFromXContentTestWithRandomFields(
        assertEquals(searchResponse.getSkippedShards(), deserialized.getSkippedShards());
    // public void testFromXContentWithSearchExtBuilders() throws IOException {
import org.opensearch.action.search.ShardSearchFailure;
}
        new SearchModule(Settings.EMPTY, List.of(new SearchPlugin() {
    public void cleanUp() throws Exception {
        namedXContents.addAll(SuggestTests.getDefaultNamedXContents());
            assertEquals(searchResponse.getHits().getTotalHits().value(), deserialized.getHits().getTotalHits().value());
import java.util.ArrayList;
import org.opensearch.test.OpenSearchTestCase;
            assertEquals(searchResponse.getHits().getTotalHits().relation(), deserialized.getHits().getTotalHits().relation());
import java.io.IOException;
        @Override
                SearchExtBuilder.class,
    }
    }
        int successfulShards = randomIntBetween(0, totalShards);
        public ListSearchExtBuilder(List<String> list) {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        @Override
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.Version;
    @Before
 * SPDX-License-Identifier: Apache-2.0
        public SimpleValueSearchExtBuilder(StreamInput in) throws IOException {
                Collections.emptyList()
                terminatedEarly,
        String id = UUID.randomUUID().toString();
import org.opensearch.search.suggest.SuggestTests;
            XContentParser.Token token = parser.currentToken();
    }
        static ParseField FIELD = new ParseField("simple_value");
        }
import java.util.Collections;
        List<NamedXContentRegistry.Entry> namedXContents = new ArrayList<>(InternalAggregationTestCase.getDefaultNamedXContents());
    static class MapSearchExtBuilder extends SearchExtBuilder {
        assertEquals(searchResponse.getClusters(), deserialized.getClusters());
        int skippedClusters = totalClusters - successfulClusters;
            null
            false
        @Override
    }
            } else {
        int totalClusters = randomIntBetween(0, 10);
    }
        }
            false
        assertEquals(
            assertNull(deserialized.getHits().getTotalHits());
import org.opensearch.common.xcontent.XContentType;
            false
                suggest,
 * this file be licensed under the Apache-2.0 license or a
            public List<SearchExtSpec<?>> getSearchExts() {
        assertEquals(searchResponse.getNumReducePhases(), deserialized.getNumReducePhases());
    ) {
import static java.util.Collections.singletonMap;
        })).getNamedWriteables()
            }
            new MapSearchExtBuilder(Map.of("x", "y", "a", "b")),
    }
        SearchResponse parsed = SearchResponse.fromXContent(parser);
        );
                timedOut,
import org.opensearch.core.ParseField;
                this.map.put(e.getKey(), e.getValue());
import org.junit.Before;
            }
    // srt.doFromXContentTestWithRandomFields(createTestItem(false, List.of(new SimpleValueSearchExtBuilder(dummyId))), false);
        assertEquals(searchResponse.getNumReducePhases(), deserialized.getNumReducePhases());
            successfulShards,
        assertEquals(searchResponse.getSkippedShards(), deserialized.getSkippedShards());
                    new SearchExtSpec<>(
import org.opensearch.search.suggest.Suggest;
        }
    }
        SearchResponse searchResponse = createTestItem(
            totalShards,
        }
import org.opensearch.action.search.SearchResponse;
    private AggregationsTests aggregationsTests = new AggregationsTests();
                return List.of(
            randomBoolean() ? randomClusters() : SearchResponse.Clusters.EMPTY,
    public void testFromXContentWithGenericSearchExtBuildersForSimpleValues() throws IOException {
        List<SearchExtBuilder> extBuilders = List.of(
import java.util.UUID;
        }
            assertNotNull(id);
                return false;
        namedXContents.addAll(SuggestTests.getDefaultNamedXContents());
            SearchHits hits = SearchHitsTests.createTestItem(true, true);
        assertEquals(searchResponse.getClusters(), deserialized.getClusters());
        @Override
    }
            assertEquals(searchResponse.getHits().getTotalHits().value(), deserialized.getHits().getTotalHits().value());
            if (!(obj instanceof SimpleValueSearchExtBuilder)) {
            this.id = in.readString();
            null,
            String id;
    }
            if (token == XContentParser.Token.VALUE_STRING) {
        }
        assertEquals(searchResponse.getFailedShards(), deserialized.getFailedShards());
        String dummyId = UUID.randomUUID().toString();
            this.map = new HashMap<>();
        } else {
        }
    @After
            List.of(new GenericSearchExtBuilder(List.of("1", "2", "3"), GenericSearchExtBuilder.ValueType.LIST))
            searchResponse.getInternalResponse().getSearchExtBuilders().get(0),
        int totalShards = randomIntBetween(1, Integer.MAX_VALUE);
import org.opensearch.search.aggregations.AggregationsTests;
            shardSearchFailures,
        );
import org.opensearch.core.xcontent.MediaType;
        }
    public SearchResponse createTestItem(
            false,
    public void testSerializationWithGenericSearchExtBuildersForMapValues() throws IOException {
/*
        @Override
        @Override
        public boolean equals(Object obj) {
        return new SearchResponse.Clusters(totalClusters, successfulClusters, skippedClusters);
        }
        }
        Boolean terminatedEarly = randomBoolean() ? null : randomBoolean();
        @Override
        );
                id = parser.text();
        );
 * compatible open source license.
            createTestItem(false, List.of(new GenericSearchExtBuilder(dummyId, GenericSearchExtBuilder.ValueType.SIMPLE))),
            @Override
        } else {
import org.opensearch.search.profile.SearchProfileShardResults;
            searchResponse.getInternalResponse().getSearchExtBuilders().get(0),
            return builder.field(EXT_FIELD, this.list);
    public void testSerializationWithGenericSearchExtBuildersForSimpleValues() throws IOException {
            return new SimpleValueSearchExtBuilder(id);
            InternalAggregations aggregations = aggregationsTests.createTestInstance();
        public SimpleValueSearchExtBuilder(String id) {
            out.writeMap(this.map);
        public String getWriteableName() {
                GenericSearchExtBuilder.EXT_BUILDER_NAME,
        assertEquals(searchResponse.getTotalShards(), deserialized.getTotalShards());
            )
            return builder.field(EXT_FIELD, this.map);
            assertEquals(searchResponse.getHits().getTotalHits().value(), deserialized.getHits().getTotalHits().value());
        );
import org.opensearch.core.xcontent.NamedXContentRegistry;
            );
            return FIELD.getPreferredName();
import org.opensearch.core.common.ParsingException;
 */
    SearchResponseTests srt = new SearchResponseTests();
            return builder.field(FIELD.getPreferredName(), id);
                hits,
        BytesReference originalBytes = toShuffledXContent(response, xcontentType, params, humanReadable);
        aggregationsTests.cleanUp();
            return EXT_FIELD;
        );
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        public String getId() {
        if (minimal == false) {
    static {
    // GenericSearchExtBuilder has its own "generic_ext" section name.
        }
            if (obj == null) {
        assertEquals(searchResponse.getTotalShards(), deserialized.getTotalShards());
        public MapSearchExtBuilder(Map<String, String> map) {
        List<NamedXContentRegistry.Entry> namedXContents = new ArrayList<>(InternalAggregationTestCase.getDefaultNamedXContents());
            this.list = new ArrayList<>();
        assertEquals(searchResponse.getHits().getHits().length, deserialized.getHits().getHits().length);
        private final static String EXT_FIELD = "map0";
        return xContentRegistry;
        }
        @Override
            searchResponse.getInternalResponse().getSearchExtBuilders().get(0),
            return EXT_FIELD;
        }
import org.opensearch.search.aggregations.InternalAggregations;
        }
            new SimpleValueSearchExtBuilder(dummyId),
                aggregations,
