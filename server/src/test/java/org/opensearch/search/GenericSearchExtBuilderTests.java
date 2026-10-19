import org.opensearch.Version;  
                id = parser.text();
        }
            deserialized.getInternalResponse().getSearchExtBuilders().get(0)
    // This test case fails because GenericSearchExtBuilder does not retain the name of the SearchExtBuilder that it is replacing.
        if (searchResponse.getHits().getTotalHits() == null) {  
            return Objects.hash(this.getClass(), this.map);  
        public String getWriteableName() {  
            return this.id;  
        @Override
import java.util.ArrayList;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            }  
        @Override
    static class SimpleValueSearchExtBuilder extends SearchExtBuilder {
        assertEquals(searchResponse.getTotalShards(), deserialized.getTotalShards());  
        boolean timedOut = randomBoolean();
import org.opensearch.search.internal.InternalSearchResponse;  
    }
        SearchResponse deserialized = copyWriteable(searchResponse, namedWriteableRegistry, SearchResponse::new, Version.CURRENT);
    public void testSerializationWithGenericSearchExtBuildersForListValues() throws IOException {  
        int skippedClusters = totalClusters - successfulClusters;
        MediaType xcontentType = randomFrom(XContentType.values());
                    new SearchExtSpec<>(  
    // GenericSearchExtBuilder has its own "generic_ext" section name.  
    }
    }  
            successfulShards,
        assertEquals(  
        );  
            createTestItem(false, List.of(new GenericSearchExtBuilder(dummyId, GenericSearchExtBuilder.ValueType.SIMPLE))),  
        public int hashCode() {
    @Override
        }  
        String dummyId = UUID.randomUUID().toString();
            }
            }
        @Override
import org.opensearch.core.common.ParsingException;
            public List<SearchExtSpec<?>> getSearchExts() {
        XContentParser parser = createParser(new NamedXContentRegistry(namedXContents), xcontentType.xContent(), originalBytes);  
            this.id = id;
        if (minimal == false) {
        public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.search.profile.SearchProfileShardResultsTests;
        public boolean equals(Object obj) {
import java.util.Map;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
    }
            false,
        private final String id;  
            return false;
        public String getWriteableName() {
        assertEquals(searchResponse.getHits().getHits().length, deserialized.getHits().getHits().length);  
                suggest,  
        xContentRegistry = new NamedXContentRegistry(namedXContents);
        }
    public void testSerializationWithGenericSearchExtBuildersForMapValues() throws IOException {  
            internalSearchResponse,
        SearchResponse searchResponse = createTestItem(
            assertEquals(searchResponse.getHits().getTotalHits().relation(), deserialized.getHits().getTotalHits().relation());
            }  
        }
import org.opensearch.search.suggest.SuggestTests;
import org.opensearch.common.settings.Settings;
        assertEquals(searchResponse.getSkippedShards(), deserialized.getSkippedShards());
 * SPDX-License-Identifier: Apache-2.0
        return new SearchResponse(  
        if (searchResponse.getHits().getTotalHits() == null) {  
            SearchProfileShardResults profileShardResults = SearchProfileShardResultsTests.createTestItem();
                    )
import org.opensearch.action.search.ShardSearchFailure;  
import java.util.Collections;  
                hits,
    SearchResponseTests srt = new SearchResponseTests();  
        assertEquals(  
        private final static String EXT_FIELD = "map0";
    @After
    public SearchResponse createTestItem(  
        assertEquals(searchResponse.getHits().getHits().length, deserialized.getHits().getHits().length);  
        srt.doFromXContentTestWithRandomFields(  
        }
        public int hashCode() {
        assertEquals(extBuilders.size(), actual.size());
            searchResponse.getInternalResponse().getSearchExtBuilders().get(0),
            @Override  
            internalSearchResponse = InternalSearchResponse.empty();  
    ) {
            )
        assertEquals(searchResponse.getTotalShards(), deserialized.getTotalShards());  
        }  
        public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.xcontent.ToXContent;
import java.util.List;
            assertEquals(searchResponse.getHits().getTotalHits().value(), deserialized.getHits().getTotalHits().value());  
            InternalAggregations aggregations = aggregationsTests.createTestInstance();  
        );
        @Override  
        }
                profileShardResults,
            new MapSearchExtBuilder(Map.of("x", "y", "a", "b")),
    );
            searchResponse.getInternalResponse().getSearchExtBuilders().get(0),
        }
        assertEquals(searchResponse.getTotalShards(), deserialized.getTotalShards());  
            for (Map.Entry<String, String> e : map.entrySet()) {
        Boolean terminatedEarly = randomBoolean() ? null : randomBoolean();  
import org.opensearch.test.InternalAggregationTestCase;
                        GenericSearchExtBuilder.EXT_BUILDER_NAME,
        public boolean equals(Object obj) {  
            skippedShards,
            XContentParser.Token token = parser.currentToken();
        })).getNamedWriteables()
        assertEquals(searchResponse.getSkippedShards(), deserialized.getSkippedShards());
    public void testFromXContentWithGenericSearchExtBuildersForListValues() throws IOException {  
        assertEquals(searchResponse.getNumReducePhases(), deserialized.getNumReducePhases());
}  
public class GenericSearchExtBuilderTests extends OpenSearchTestCase {  
        assertEquals(  
        );  
        }  
        @Override
        public String getWriteableName() {
            assertEquals(searchResponse.getHits().getTotalHits().relation(), deserialized.getHits().getTotalHits().relation());
        aggregationsTests.init();
        } else {
/*  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import static java.util.Collections.singletonMap;
        SearchResponse searchResponse = createTestItem(
        public boolean equals(Object obj) {
        SearchResponse parsed = SearchResponse.fromXContent(parser);
                );
import org.opensearch.search.profile.SearchProfileShardResults;
            if (token == XContentParser.Token.VALUE_STRING) {  
 *
        @Override  
        List<NamedXContentRegistry.Entry> namedXContents = new ArrayList<>(InternalAggregationTestCase.getDefaultNamedXContents());
import org.opensearch.core.xcontent.MediaType;  
        ShardSearchFailure... shardSearchFailures  
        SearchResponse deserialized = copyWriteable(searchResponse, namedWriteableRegistry, SearchResponse::new, Version.CURRENT);
        return new SearchResponse.Clusters(totalClusters, successfulClusters, skippedClusters);
    }  
    }
                throw new ParsingException(parser.getTokenLocation(), "no id specified for " + FIELD.getPreferredName());  
            return new SimpleValueSearchExtBuilder(id);
        public ListSearchExtBuilder(List<String> list) {  
            List.of(new GenericSearchExtBuilder(List.of("1", "2", "3"), GenericSearchExtBuilder.ValueType.LIST))  
        assertEquals(extBuilders.size(), response.getInternalResponse().getSearchExtBuilders().size());
            assertTrue(actual.get(0) instanceof GenericSearchExtBuilder);
    public void testSerializationWithGenericSearchExtBuildersForSimpleValues() throws IOException {
    }
        SearchResponse searchResponse = createTestItem(
        assertEquals(searchResponse.getClusters(), deserialized.getClusters());
import org.opensearch.test.OpenSearchTestCase;  
        int successfulClusters = randomIntBetween(0, totalClusters);  
            if (obj == null) {
        }
            return false;  
        for (int i = 0; i < actual.size(); i++) {  
            assertEquals(searchResponse.getHits().getTotalHits().value(), deserialized.getHits().getTotalHits().value());  
        );  
        @Override  
            tookInMillis,  
        assertEquals(searchResponse.getFailedShards(), deserialized.getFailedShards());
                timedOut,
        int totalShards = randomIntBetween(1, Integer.MAX_VALUE);  
            SearchHits hits = SearchHitsTests.createTestItem(true, true);
    // srt.doFromXContentTestWithRandomFields(createTestItem(false, List.of(new SimpleValueSearchExtBuilder(dummyId))), false);  
            false,
            return FIELD.getPreferredName();
    }  
            String id;
import org.opensearch.core.common.io.stream.StreamInput;
            return Objects.hash(this.getClass(), this.list);
            } else {
        public int hashCode() {  
            assertNull(deserialized.getHits().getTotalHits());
            false
        @Override
    private static final NamedXContentRegistry xContentRegistry;
        public MapSearchExtBuilder(Map<String, String> map) {  
    }
        assertEquals(searchResponse.getNumReducePhases(), deserialized.getNumReducePhases());
    }
        return xContentRegistry;  
    }
        public SimpleValueSearchExtBuilder(String id) {
        String dummyId = UUID.randomUUID().toString();
        }  
        int skippedShards = randomIntBetween(0, totalShards);
        }  
            new SimpleValueSearchExtBuilder(dummyId),  
        assertEquals(searchResponse.getFailedShards(), deserialized.getFailedShards());
            }
import org.opensearch.core.xcontent.XContentBuilder;  
        }
import org.junit.After;
        @Override
                return false;
    public void testFromXContentWithGenericSearchExtBuildersForSimpleValues() throws IOException {  
            return builder.field(EXT_FIELD, this.map);
    public void testFromXContentWithGenericSearchExtBuildersForMapValues() throws IOException {
                GenericSearchExtBuilder.EXT_BUILDER_NAME,  
import java.util.Objects;
        int numReducePhases = randomIntBetween(1, 10);
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.rest.action.search.RestSearchAction;  
        }
        private final static String EXT_FIELD = "list0";
                numReducePhases,
            list.forEach(e -> this.list.add(e));
            out.writeMap(this.map);
        }
                terminatedEarly,  
        }
import org.opensearch.core.common.bytes.BytesReference;
            deserialized.getInternalResponse().getSearchExtBuilders().get(0)
import org.opensearch.plugins.SearchPlugin;
            );
            List.of(new GenericSearchExtBuilder(Map.of("x", "y", "a", "b"), GenericSearchExtBuilder.ValueType.MAP))  
        @Override
import org.opensearch.core.ParseField;  
    protected NamedXContentRegistry xContentRegistry() {
            createTestItem(false, List.of(new GenericSearchExtBuilder(List.of("1", "2", "3"), GenericSearchExtBuilder.ValueType.LIST))),  
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(searchResponse.getHits().getTotalHits().value(), deserialized.getHits().getTotalHits().value());  
        int totalClusters = randomIntBetween(0, 10);
import java.util.HashMap;
        @Override
        }  
                this.map.put(e.getKey(), e.getValue());  
    // }
        @Override  
        );
            assertNull(deserialized.getHits().getTotalHits());
            totalShards,  
        }
            }
                        GenericSearchExtBuilder::new,
        BytesReference originalBytes = toShuffledXContent(response, xcontentType, params, humanReadable);
        namedXContents.add(  
            List.of(new GenericSearchExtBuilder(id, GenericSearchExtBuilder.ValueType.SIMPLE))  
        }
        new SearchModule(Settings.EMPTY, List.of(new SearchPlugin() {
 * compatible open source license.
    public void testFromXContentWithUnregisteredSearchExtBuilders() throws IOException {
                        GenericSearchExtBuilder::fromXContent  
        assertEquals(searchResponse.getSkippedShards(), deserialized.getSkippedShards());
            return builder.field(FIELD.getPreferredName(), id);  
import org.opensearch.search.suggest.Suggest;  
import java.util.UUID;
    }  
    static SearchResponse.Clusters randomClusters() {
import org.opensearch.core.xcontent.XContentParser;
            deserialized.getInternalResponse().getSearchExtBuilders().get(0)
 */  
        final ToXContent.Params params = new ToXContent.MapParams(singletonMap(RestSearchAction.TYPED_KEYS_PARAM, "true"));
        assertEquals(searchResponse.getNumReducePhases(), deserialized.getNumReducePhases());
            null,
        assertEquals(searchResponse.getClusters(), deserialized.getClusters());
        SearchResponse response = srt.createTestItem(false, extBuilders);
        } else {
        }
        boolean minimal,
            randomBoolean() ? randomClusters() : SearchResponse.Clusters.EMPTY,
            new NamedXContentRegistry.Entry(
        );
                aggregations,
        @Override
    }
        }  
        aggregationsTests.cleanUp();
        boolean humanReadable = randomBoolean();  
            assertEquals(searchResponse.getHits().getTotalHits().relation(), deserialized.getHits().getTotalHits().relation());
            null  
        private final Map<String, Object> map;
            Suggest suggest = SuggestTests.createTestItem();
        }
    private final NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(
                Collections.emptyList()  
import org.opensearch.common.xcontent.XContentType;
                searchExtBuilders,
import org.junit.Before;
            if (!(obj instanceof SimpleValueSearchExtBuilder)) {
            shardSearchFailures,
                return false;  
    public void cleanUp() throws Exception {  
        );  
        );
            false
        private final List<String> list;
            assertNull(deserialized.getHits().getTotalHits());
import java.io.IOException;
import org.opensearch.action.search.SearchResponse;
import org.opensearch.search.aggregations.InternalAggregations;
    static class ListSearchExtBuilder extends SearchExtBuilder {  
import org.opensearch.action.search.SearchResponseTests;
            return 0;
            false
        List<SearchExtBuilder> searchExtBuilders,
        srt.doFromXContentTestWithRandomFields(
        );
        List<NamedXContentRegistry.Entry> namedXContents = new ArrayList<>(InternalAggregationTestCase.getDefaultNamedXContents());
        if (searchResponse.getHits().getTotalHits() == null) {  
            return EXT_FIELD;  
        }
import org.opensearch.core.xcontent.NamedXContentRegistry;
        public SimpleValueSearchExtBuilder(StreamInput in) throws IOException {
            searchResponse.getInternalResponse().getSearchExtBuilders().get(0),
        static ParseField FIELD = new ParseField("simple_value");
        int successfulShards = randomIntBetween(0, totalShards);
        namedXContents.addAll(SuggestTests.getDefaultNamedXContents());  
        );
    @Before  
package org.opensearch.search;
    // String dummyId = UUID.randomUUID().toString();
            this.id = in.readString();
            if (id == null) {
            this.list = new ArrayList<>();
    private AggregationsTests aggregationsTests = new AggregationsTests();
                throw new ParsingException(parser.getTokenLocation(), "Expected a VALUE_STRING but got " + token);  
            createTestItem(false, List.of(new GenericSearchExtBuilder(Map.of("x", "y", "a", "b"), GenericSearchExtBuilder.ValueType.MAP))),
            return this.id.equals(((SimpleValueSearchExtBuilder) obj).getId());  
        }
            internalSearchResponse = new InternalSearchResponse(  
            return EXT_FIELD;
    }
        @Override
            return builder.field(EXT_FIELD, this.list);
    static class MapSearchExtBuilder extends SearchExtBuilder {  
        srt.doFromXContentTestWithRandomFields(
        );  
    }  
        namedXContents.addAll(SuggestTests.getDefaultNamedXContents());
                return List.of(
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        assertEquals(searchResponse.getHits().getHits().length, deserialized.getHits().getHits().length);  
import org.opensearch.search.aggregations.AggregationsTests;
        );  
        String id = UUID.randomUUID().toString();  
        public void writeTo(StreamOutput out) throws IOException {  
        public String getId() {
            out.writeCollection(this.list, StreamOutput::writeString);  
                GenericSearchExtBuilder::fromXContent
            this.map = new HashMap<>();
        assertEquals(searchResponse.getClusters(), deserialized.getClusters());
            out.writeString(this.id);
    static {  
        }
    }
            assertNotNull(id);  
    public void init() throws Exception {
        public static SimpleValueSearchExtBuilder parse(XContentParser parser) throws IOException {  
                SearchExtBuilder.class,
        @Override  
        List<SearchExtBuilder> extBuilders = List.of(
    // public void testFromXContentWithSearchExtBuilders() throws IOException {
        long tookInMillis = randomNonNegativeLong();
            new ListSearchExtBuilder(List.of("1", "2", "3"))
        SearchResponse deserialized = copyWriteable(searchResponse, namedWriteableRegistry, SearchResponse::new, Version.CURRENT);
        InternalSearchResponse internalSearchResponse;  
            false,
        }  
        } else {
        String dummyId = UUID.randomUUID().toString();
        List<SearchExtBuilder> actual = parsed.getInternalResponse().getSearchExtBuilders();
        } else {
        assertEquals(searchResponse.getFailedShards(), deserialized.getFailedShards());
