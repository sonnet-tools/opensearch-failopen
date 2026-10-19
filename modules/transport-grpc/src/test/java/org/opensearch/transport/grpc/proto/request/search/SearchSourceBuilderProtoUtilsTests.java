        assertEquals("Should have 2 indexBoosts", 2, searchSourceBuilder.indexBoosts().size());
        assertEquals("Should have 2 stats", 2, searchSourceBuilder.stats().size());
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setTimeout("5s").build();
        // This test is no longer applicable as the field doesn't exist  
        // Create a SearchSourceBuilder to populate
        assertNotNull("Aggregations should not be null", builder.aggregations());
            IllegalArgumentException.class,  
            .orElse(null);
        // Call the method under test
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        );  
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()
        assertEquals("Should have 2 indexBoosts", 2, searchSourceBuilder.indexBoosts().size());
        FloatMap boost1 = FloatMap.newBuilder().putFloatMap("index1", 1.5f).build();
        assertEquals("Collapse field should match", "category", searchSourceBuilder.collapse().getField());  
    public void testParseProtoWithTerminateAfter() throws IOException {
import org.opensearch.protobufs.DerivedField;
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setTrackScores(true).build();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
            .setXSource(org.opensearch.protobufs.SourceConfig.newBuilder().build())  
                .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("doc['field'].value * 2").build()).build())
        // Verify the result
        assertNotNull("IndexBoosts should not be null", searchSourceBuilder.indexBoosts());
            IllegalArgumentException.class,
                .build()
        // Verify the result
    }  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        FloatMap boost2 = FloatMap.newBuilder().putFloatMap("index2", 2.5f).build();  
        IllegalArgumentException e = expectThrows(  
    }
            .addSearchAfter(FieldValue.newBuilder().setString("value1").build())
        );
            "script_field_2",
        );
        assertEquals("Second value should match", 42.0f, searchSourceBuilder.searchAfter()[1]);
    public void testParseProtoWithExtThrowsUnsupportedOperationException() throws IOException {
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()
    public void testParseProtoWithTrackTotalHitsBooleanFalse() throws IOException {  
    public void testParseProtoWithPostFilter() throws IOException {
import org.opensearch.test.OpenSearchTestCase;  
        // Create a SearchSourceBuilder to populate  
        aggregationsMap.put(
        // Verify the result
    public void testParseProtoWithIndicesBoost2MultipleKeysThrows() {
    public void testParseProtoWithAggregations() throws IOException {
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()  
    }
        // Verify aggregations
        // Create a SearchSourceBuilder to populate
        // Verify the result
    public void testParseProtoWithVerbosePipeline() throws IOException {  
import org.opensearch.transport.grpc.proto.request.search.query.QueryBuilderProtoTestUtils;  
import static org.opensearch.search.internal.SearchContext.TRACK_TOTAL_HITS_DISABLED;
        // Call the method under test
    }  
import org.opensearch.protobufs.Script;  
        // Verify the result  
        assertNotNull("ScriptField should not be null", scriptField);
        // Call the method under test
            )
    public void setUp() throws Exception {  
import static org.opensearch.search.internal.SearchContext.TRACK_TOTAL_HITS_ACCURATE;
    public void testParseProtoWithVersion() throws IOException {  
    }
        aggregationRegistry = new AggregationBuilderProtoConverterRegistryImpl();
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().addStoredFields("field1").addStoredFields("field2").build();
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);  
                .setFormat("yyyy-MM-dd")
        Map<String, Float> boostMap = new HashMap<>();  
    }
        assertEquals("Slice max should match", 10, searchSourceBuilder.slice().getMax());
import org.opensearch.protobufs.FloatMap;
    public void testParseProtoWithoutAggregations() throws IOException {  
        // Create a SearchSourceBuilder to populate
            .build();
        assertNotNull("Properties should not be null", fieldWithProps.getProperties());
        assertEquals("Should have 2 derived fields", 2, searchSourceBuilder.getDerivedFields().size());  
                            )  
        assertTrue("Ignore malformed should be true", fieldWithProps.getIgnoreMalformed());
            .addFields(FieldAndFormat.newBuilder().setField("field1").setFormat("format1").build())  
        // Call the method under test
                .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("emit(doc['field'].value)").build()).build())
        // Verify the result  
            .build();  
        assertNotNull("ScriptFields should not be null", searchSourceBuilder.scriptFields());
        );
            .setIgnoreFailure(true)
        // Create a protobuf SearchRequestBody with slice  
        // Call the method under test, should throw UnsupportedOperationException  
        // Verify the result  
import org.opensearch.protobufs.MinAggregation;  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);  
    }  
            .setTrackTotalHits(TrackHits.newBuilder().setEnabled(true).build())
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            .addDocvalueFields(FieldAndFormat.newBuilder().setField("field2").setFormat("format2").build())
        assertNull("Aggregations should be null", builder.aggregations());  
            searchSourceBuilder.scriptFields()
        assertEquals(2.0f, searchSourceBuilder.indexBoosts().get(0).getBoost(), 0.001f);
            .setHighlight(org.opensearch.protobufs.Highlight.newBuilder().addPreTags("<em>").addPostTags("</em>").build())
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setFrom(10).build();
        SearchSourceBuilder.ScriptField scriptField = SearchSourceBuilderProtoUtils.ScriptFieldProtoUtils.fromProto(
    }
                    .build()  
        // Create a protobuf SearchRequestBody with stats
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
                        "derived_field_1",
import java.util.Map;
        assertTrue("Query should be MatchAllQueryBuilder", searchSourceBuilder.query() instanceof MatchAllQueryBuilder);
        assertEquals("Should have 2 properties", 2, fieldWithProps.getProperties().size());  
        assertNotNull("FetchSourceContext should not be null", searchSourceBuilder.fetchSource());
    }
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
    }
            )
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    public void testParseProtoWithSize() throws IOException {
                        org.opensearch.protobufs.FieldSortMap.newBuilder()  
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().addIndicesBoost2(invalidMap).build();
        // Create a protobuf SearchRequestBody with ext  
        SearchSourceBuilder builder = new SearchSourceBuilder();
        // Parse proto
import org.opensearch.protobufs.AggregationContainer;
            .stream()
            AggregationContainer.newBuilder().setMin(MinAggregation.newBuilder().setField("price").build()).build()
                .contains(
    }
    private AggregationBuilderProtoConverterRegistry aggregationRegistry;  
    public void testParseProtoWithExplain() throws IOException {
        // Create a SearchSourceBuilder to populate  
        // Verify the result
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().putAllIndicesBoost(boostMap).addIndicesBoost2(boost2).build();  
        // Create a SearchSourceBuilder to populate
        SearchSourceBuilder.ScriptField scriptField = SearchSourceBuilderProtoUtils.ScriptFieldProtoUtils.fromProto(
    }  
    }
        // Create a SearchSourceBuilder to populate
        // Create a SearchSourceBuilder to populate
            "Should contain derived_field_1",  
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()
    public void testParseProtoWithDerivedFields() throws IOException {  
        assertEquals("Should have 2 aggregations", 2, builder.aggregations().count());  
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    private NamedWriteableRegistry mockRegistry;
/*  
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()  
        // Find the simple derived field
        );
    public void testParseProtoWithTrackTotalHitsInteger() throws IOException {
    }
            DerivedField.newBuilder()  
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().putAllDerived(derivedFieldsMap).build();
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().build();
        assertEquals("nested_field1 type should match", "text", fieldWithProps.getProperties().get("nested_field1"));
        // Call the method under test
                )
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("doc['field'].value * 2").build()).build())  
        // Create a SearchSourceBuilder to populate
                                "timestamp",
            .build();
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);  
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
import java.io.IOException;  
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);  
            .build();
                org.opensearch.protobufs.SourceConfig.newBuilder()
        // Verify the result
import org.opensearch.index.query.MatchAllQueryBuilder;  
        boostMap.put("index1", 1.0f);  
    public void testParseProtoWithXSourceExcludes() throws IOException {
        assertTrue("Stats should contain stat1", searchSourceBuilder.stats().contains("stat1"));
        // Create a SearchSourceBuilder to populate
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    }
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);  
    public void testParseProtoWithFields() throws IOException {  
        assertNotNull("Should find simple_derived_field", simpleField);
        assertEquals("First value should match", "value1", searchSourceBuilder.searchAfter()[0]);
        SearchSourceBuilderProtoUtils.parseProto(builder, protoRequest, queryUtils, aggregationRegistry);
        // Call the method under test  
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setIncludeNamedQueriesScore(true).build();
        assertNotNull("Script should not be null", scriptField.script());  
        );
        aggregationsMap.put(
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        // Find the derived field with properties
        assertEquals("TrackTotalHits should be accurate", TRACK_TOTAL_HITS_ACCURATE, searchSourceBuilder.trackTotalHitsUpTo().intValue());  
    }
            )
                        "string",
            .build();
    }
            DerivedField.newBuilder()  
            .setPostFilter(QueryContainer.newBuilder().setMatchAll(MatchAllQuery.newBuilder().build()).build())
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
    }
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
            searchSourceBuilder.getDerivedFields()
        assertEquals("Timeout should match", TimeValue.timeValueSeconds(5), searchSourceBuilder.timeout());
                    .setFilter(org.opensearch.protobufs.SourceFilter.newBuilder().addIncludes("field1").addIncludes("field2").build())
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // Create a protobuf SearchRequestBody with size
        assertNotNull("IndexBoosts should not be null", searchSourceBuilder.indexBoosts());
    @Override
        );
        Map<String, AggregationContainer> aggregationsMap = new HashMap<>();  
    public void testParseProtoWithHighlight() throws IOException {
        // Create a protobuf SearchRequestBody with searchAfter
                            .build()
            "test_script_field",  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // Verify the result
}  
    public void testParseProtoWithSuggest() throws IOException {  
        // Create a SearchSourceBuilder to populate
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            .setCollapse(org.opensearch.protobufs.FieldCollapse.newBuilder().setField("category").build())
            ScriptField.newBuilder()  
        );  
            .build();
                .build()
        boostMap.put("index2", 99.0f);
                        "derived_field_2",  
        );
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
        assertTrue("Profile should be true", searchSourceBuilder.profile());
                .build()
        assertEquals("indices_boost_2 should be preferred when both are set", 1, searchSourceBuilder.indexBoosts().size());  
        // Create a SearchSourceBuilder to populate
        // Create an instance with all built-in converters  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
            .build();
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
import org.opensearch.protobufs.FieldAndFormat;  
        // Call the method under test
        // Verify the result
        // Verify the result
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().putAllIndicesBoost(boostMap).build();  
    public void testParseProtoWithSeqNoPrimaryTerm() throws IOException {
        assertFalse("Ignore malformed should be false", simpleField.getIgnoreMalformed());
    }
    }  
                .setType("string")
        assertTrue("IgnoreFailure should be true", scriptField.ignoreFailure());  
    public void testScriptFieldProtoUtilsFromProto() throws IOException {  
    public void testParseProtoWithStoredFields() throws IOException {  
            .build();  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            .build();
                .setIgnoreFailure(true)
        // Verify the result
        assertNotNull("Collapse should not be null", searchSourceBuilder.collapse());
        // Create a protobuf SearchRequestBody with includeNamedQueriesScore  
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setProfile(true).build();
        // Create a SearchSourceBuilder to populate
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()
    }
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setSize(20).build();  
        assertEquals("Script source should match", "doc['field'].value * 2", scriptField.script().getIdOrCode());
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
    }
        assertEquals("Size should match", 20, searchSourceBuilder.size());  
        org.opensearch.index.mapper.DerivedField simpleField = searchSourceBuilder.getDerivedFields()
        // Create a SearchSourceBuilder to populate
        // Verify the result
            "derived_field_2",
        // Call the method under test
                )
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setSeqNoPrimaryTerm(true).build();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
import org.opensearch.protobufs.InlineScript;  
        assertEquals("Field name should match", "test_script_field", scriptField.fieldName());  
 * The OpenSearch Contributors require contributions made to  
        // Call the method under test  
        assertTrue("Version should be true", searchSourceBuilder.version());
        // Create a SearchSourceBuilder to populate
        UnsupportedOperationException exception = expectThrows(
        assertNotNull("StoredFields should not be null", searchSourceBuilder.storedFields());
    public void testParseProtoWithScriptFields() throws IOException {  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
        assertNotNull("ScriptField should not be null", scriptField);
        // Should not throw exception as suggest field no longer exists
        // Create a SearchSourceBuilder to populate
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);  
        // Verify the result
        // Create a protobuf SearchRequestBody with timeout
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setVerbosePipeline(true).build();
                    .build()
        // Verify the result
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setExplain(true).build();  
        boostMap.put("index2", 2.0f);
            "script_field_1",
    }
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()
        // Verify the result
                    )
                )  
            .findFirst()
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()  
    public void testParseProtoWithSearchAfter() throws IOException {
                    )
            ScriptField.newBuilder()
            .build();
        // Create a protobuf SearchRequestBody with profile  
        // Verify the result
    }
            .stream()  
        assertTrue(
    }  
        assertNotNull("Should find derived_field_with_properties", fieldWithProps);  
                                    .setOrder(org.opensearch.protobufs.SortOrder.SORT_ORDER_DESC)
        assertTrue("PostFilter should be MatchAllQueryBuilder", searchSourceBuilder.postFilter() instanceof MatchAllQueryBuilder);  
import org.opensearch.protobufs.FieldValue;
            searchSourceBuilder.scriptFields()  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    }  
    }  
        // Call the method under test
    public void testParseProtoWithTrackTotalHitsBooleanTrue() throws IOException {
        // Create a SearchSourceBuilder to populate  
    }  
        // Call the method under test
        assertTrue(e.getMessage().contains("exactly one index-to-boost mapping"));  
            scriptFieldProto  
                                org.opensearch.protobufs.FieldSort.newBuilder()  
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()  
        assertNotNull("Slice should not be null", searchSourceBuilder.slice());  
import org.opensearch.protobufs.SlicedScroll;  
            searchSourceBuilder.getDerivedFields()  
    public void testParseProtoWithXSource() throws IOException {
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setExt(ObjectMap.newBuilder().build()).build();
    }
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().putAllScriptFields(scriptFieldsMap).build();
            .setTrackTotalHits(TrackHits.newBuilder().setCount(1000).build())
            .build();
    }  
import org.opensearch.protobufs.MaxAggregation;
        assertEquals("Should have 2 script fields", 2, searchSourceBuilder.scriptFields().size());  
        FloatMap emptyMap = FloatMap.newBuilder().build();
        assertNotNull("DerivedFields should not be null", searchSourceBuilder.getDerivedFields());  
        // Suggest functionality is now handled via SearchRequest URL parameters (suggest_field, suggest_text, etc.)
import org.opensearch.protobufs.ScriptField;
            .setTrackTotalHits(TrackHits.newBuilder().setEnabled(false).build())  
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().putAllAggregations(aggregationsMap).build();
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        // Create a protobuf ScriptField
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);  
import static org.mockito.Mockito.mock;  
        assertTrue(
    }  
            .findFirst()  
import org.opensearch.protobufs.ObjectMap;
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
    public void testParseProtoWithSort() throws IOException {
        // Suggester field was removed from SearchRequestBody in protobufs 1.0.0
    public void testParseProtoWithXSourceIncludes() throws IOException {  
            .build();
        // Call the method under test
        assertNotNull("DerivedFields should not be null", searchSourceBuilder.getDerivedFields());
        assertTrue("Stats should contain stat2", searchSourceBuilder.stats().contains("stat2"));  
        assertNotNull("SearchAfter should not be null", searchSourceBuilder.searchAfter());
        // Create a protobuf SearchRequestBody with indicesBoost
        // Create a protobuf ScriptField without ignoreFailure
        assertNotNull("Stats should not be null", searchSourceBuilder.stats());  
        // Verify the result
        assertNotNull("Highlight should not be null", searchSourceBuilder.highlighter());
            .build();  
        assertEquals("Should have 1 sort", 1, searchSourceBuilder.sorts().size());  
    public void testParseProtoWithSlice() throws IOException {
        Map<String, ScriptField> scriptFieldsMap = new HashMap<>();
        assertTrue("Exception message should mention ext param", exception.getMessage().contains("ext param is not supported yet"));  
        // Create a SearchSourceBuilder to populate  
            DerivedField.newBuilder()
        // Call the method under test
        assertNotNull("FetchSourceContext should not be null", searchSourceBuilder.fetchSource());
        // Create a SearchSourceBuilder to populate
        // Verify the result  
            .setXSource(
        // Create a SearchSourceBuilder to populate
        // Call the method under test  
                .setProperties(properties)  
        assertEquals("Slice id should match", 5, searchSourceBuilder.slice().getId());
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        );
        // Create a SearchSourceBuilder to populate  
        );  
        // Create a protobuf SearchRequestBody with trackTotalHits integer
        );
        assertEquals("nested_field2 type should match", "keyword", fieldWithProps.getProperties().get("nested_field2"));
        // Verify the result
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setTerminateAfter(100).build();
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("doc['field'].value * 2").build()).build())  
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);  
        // Verify the result
        SearchSourceBuilderProtoUtils.parseProto(builder, protoRequest, queryUtils, aggregationRegistry);  
        FloatMap invalidMap = FloatMap.newBuilder().putFloatMap("index1", 1.0f).putFloatMap("index2", 2.0f).build();  
        assertEquals("Slice field should match", "_id", searchSourceBuilder.slice().getField());  
        // Create a protobuf SearchRequestBody with minScore
        );
        assertEquals("Should have 2 derived fields", 2, searchSourceBuilder.getDerivedFields().size());
            "derived_field_with_properties",
        assertEquals("From should match", 10, searchSourceBuilder.from());
        // Test that empty aggregations map doesn't cause issues
    public void testParseProtoWithQuery() throws IOException {
        // Create a SearchSourceBuilder to populate
 * this file be licensed under the Apache-2.0 license or a
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()
    public void testParseProtoWithIndicesBoost2() throws IOException {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // Create a SearchSourceBuilder to populate
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
                .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("doc['field'].value * 2").build()).build())  
        Map<String, DerivedField> derivedFieldsMap = new HashMap<>();  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        assertNotNull("FetchFields should not be null", searchSourceBuilder.fetchFields());
            .setQuery(QueryContainer.newBuilder().setMatchAll(MatchAllQuery.newBuilder().build()).build())
                    new org.opensearch.index.mapper.DerivedField(  
        // Create a protobuf SearchRequestBody with terminateAfter  
                    new SearchSourceBuilder.ScriptField("script_field_2", new org.opensearch.script.Script("doc['field'].value * 2"), false)  
        assertEquals("Script source should match", "doc['field'].value * 2", scriptField.script().getIdOrCode());
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        queryUtils = QueryBuilderProtoTestUtils.createQueryUtils();
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
            .setXSource(
        assertNotNull("IndexBoosts should not be null", searchSourceBuilder.indexBoosts());  
                .build()
        // Call the method under test  
        // Call the method under test
        );  
        org.opensearch.index.mapper.DerivedField fieldWithProps = searchSourceBuilder.getDerivedFields()  
            .addFields(FieldAndFormat.newBuilder().setField("field2").setFormat("format2").build())
                    .build()
    public void testParseProtoWithIncludeNamedQueriesScore() throws IOException {
        // Create a protobuf SearchRequestBody with version
        // Create a SearchSourceBuilder to populate  
        ScriptField scriptFieldProto = ScriptField.newBuilder()
        // Verify the result  
        Map<String, Float> boostMap = new HashMap<>();
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverterRegistry;
                .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("doc['field'].value * 2").build()).build())
        assertEquals("SearchPipeline should match", "my-pipeline", searchSourceBuilder.pipeline());  
        SearchSourceBuilder builder = new SearchSourceBuilder();
            "simple_derived_field",
                .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("doc['field'].value * 2").build()).build())
                        new org.opensearch.script.Script("doc['field'].value * 2")  
            "test_script_field",
    }
        assertNotNull("Query should not be null", searchSourceBuilder.query());  
        // Create a protobuf SearchRequestBody with trackTotalHits boolean false
        assertNull("Prefilter field should be null", simpleField.getPrefilterField());
        // Create a protobuf SearchRequestBody with searchPipeline
        // Call the method under test  
            .build();  
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setSearchPipeline("my-pipeline").build();  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()
        assertEquals("Should have 2 docValueFields", 2, searchSourceBuilder.docValueFields().size());  
                )
                                    .build()
        // Verify the result  
        // Create a SearchSourceBuilder to populate
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        derivedFieldsMap.put(  
            .setSlice(SlicedScroll.newBuilder().setId(5).setMax(10).setField("_id").build())
            "derived_field_1",
            () -> SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry)  
        Map<String, DerivedField> derivedFieldsMap = new HashMap<>();
        // Create a protobuf SearchRequestBody with derived fields
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        assertEquals("MinScore should match", 0.5f, searchSourceBuilder.minScore(), 0.0f);  
 * SPDX-License-Identifier: Apache-2.0
        // Verify no aggregations
        // Create a protobuf SearchRequestBody with seqNoPrimaryTerm  
        // Verify the result
            DerivedField.newBuilder()
                        new org.opensearch.script.Script("doc['field'].value * 2")
    public void testParseProtoWithSearchPipeline() throws IOException {
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().addStats("stat1").addStats("stat2").build();  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // Call the method under test
            .build();
        searchSourceBuilder.includeNamedQueriesScores(true);
            .filter(f -> f.getName().equals("derived_field_with_properties"))
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        assertTrue(
            .filter(f -> f.getName().equals("simple_derived_field"))
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
            "Should contain script_field_2",  
        assertTrue("TrackScores should be true", searchSourceBuilder.trackScores());
    public void testParseProtoWithMinScore() throws IOException {
                .setType("object")
        FloatMap boost2 = FloatMap.newBuilder().putFloatMap("index2", 2.0f).build();
        assertNotNull("Script should not be null", scriptField.script());
        assertEquals("Should have 2 fetchFields", 2, searchSourceBuilder.fetchFields().size());  
        derivedFieldsMap.put(
        // Create a SearchSourceBuilder to populate  
        assertEquals("Type should match", "object", fieldWithProps.getType());
    public void testParseProtoWithIndicesBoost2EmptyMapThrows() {  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
            scriptFieldProto
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        // Call the method under test
import org.opensearch.transport.grpc.proto.request.search.query.AbstractQueryBuilderProtoUtils;
            "Should contain derived_field_2",
        assertFalse("IgnoreFailure should be false by default", scriptField.ignoreFailure());
            .addDocvalueFields(FieldAndFormat.newBuilder().setField("field1").setFormat("format1").build())  
    public void testScriptFieldProtoUtilsFromProtoWithDefaultIgnoreFailure() throws IOException {  
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);  
                .setPrefilterField("source_field")
        // Create a protobuf SearchRequestBody with trackScores
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);  
        assertEquals("index2", searchSourceBuilder.indexBoosts().get(0).getIndex());
        assertEquals("TerminateAfter should match", 100, searchSourceBuilder.terminateAfter());
        // Call the method under test
        // Call the method under test
                            .putFieldSortMap(
        assertEquals("Type should match", "number", simpleField.getType());  
            .build();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();  
package org.opensearch.transport.grpc.proto.request.search;
        assertTrue("VerbosePipeline should be true", searchSourceBuilder.verbosePipeline());
            "max_price",
        // Create a protobuf SearchRequestBody with scriptFields
        scriptFieldsMap.put(  
    public void testParseProtoWithTrackScores() throws IOException {  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
import org.opensearch.common.unit.TimeValue;
        assertNotNull("DocValueFields should not be null", searchSourceBuilder.docValueFields());
        // Call the method under test
                    )  
    }
    public void testParseProtoWithIndicesBoost() throws IOException {  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
                .build()
        // Call the method under test  
        assertNull("Format should be null", simpleField.getFormat());  
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);  
import org.opensearch.search.builder.SearchSourceBuilder;
                .setType("number")  
        // Verify the result
        // Create a protobuf SearchRequestBody with explain
        // Call the method under test
    }
        assertEquals("Format should match", "yyyy-MM-dd", fieldWithProps.getFormat());
        ObjectMap properties = ObjectMap.newBuilder()
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        // Parse proto  
        // Create a protobuf SearchRequestBody with derived fields including optional properties  
    public void testParseProtoWithProfile() throws IOException {
public class SearchSourceBuilderProtoUtilsTests extends OpenSearchTestCase {
import org.opensearch.protobufs.MatchAllQuery;
        assertTrue("SeqNoPrimaryTerm should be true", searchSourceBuilder.seqNoAndPrimaryTerm());
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().putAllDerived(derivedFieldsMap).build();  
                    new org.opensearch.index.mapper.DerivedField(
                    .setFieldWithOrder(
    public void testParseProtoWithFrom() throws IOException {
        assertEquals("TrackTotalHits should be disabled", TRACK_TOTAL_HITS_DISABLED, searchSourceBuilder.trackTotalHitsUpTo().intValue());
        // Create a SearchSourceBuilder to populate
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().addIndicesBoost2(emptyMap).build();  
            .orElse(null);  
        // Verify the result  
 */  
    }
    }
        // Create a protobuf SearchRequestBody with trackTotalHits boolean true  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            .addSearchAfter(
        assertNotNull("Sorts should not be null", searchSourceBuilder.sorts());
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().addIndicesBoost2(boost1).addIndicesBoost2(boost2).build();
            "min_price",  
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setMinScore(0.5f).build();  
                .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("doc['field'].value * 2").build()).build())
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()  
            )  
                org.opensearch.protobufs.SourceConfig.newBuilder()  
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        // Verify the result
        assertEquals("Prefilter field should match", "source_field", fieldWithProps.getPrefilterField());  
        assertNotNull("FetchSourceContext should not be null", searchSourceBuilder.fetchSource());  
        // Call the method under test  
        assertEquals("TrackTotalHits should match", 1000, searchSourceBuilder.trackTotalHitsUpTo().intValue());
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);  
            "Should contain script_field_1",
                org.opensearch.protobufs.SortCombinations.newBuilder()
                .contains(
        // Create a SearchSourceBuilder to populate
    private AbstractQueryBuilderProtoUtils queryUtils;
        assertTrue("IncludeNamedQueriesScore should be true", searchSourceBuilder.includeNamedQueriesScore());
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setVersion(true).build();
                .contains(
        assertNotNull("PostFilter should not be null", searchSourceBuilder.postFilter());
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().build();
    }
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()  
                .contains(
    // Aggregations Tests
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    public void testParseProtoWithCollapse() throws IOException {
        assertTrue(
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        IllegalArgumentException e = expectThrows(
        super.setUp();
        // Create a protobuf SearchRequestBody with docValueFields
        assertTrue(e.getMessage().contains("exactly one index-to-boost mapping"));
        assertNull("Properties should be null", simpleField.getProperties());
            () -> SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry)
    }  
        // Call the method under test
        // Verify the result
import org.opensearch.protobufs.QueryContainer;
import org.opensearch.protobufs.SearchRequestBody;
    public void testParseProtoWithDocValueFields() throws IOException {  
        // Call the method under test
        // Call the method under test
                .build()  
        // Create a protobuf SearchRequestBody with from  
    // ========================================  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        scriptFieldsMap.put(
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);  
    public void testParseProtoWithDerivedFieldsWithOptionalProperties() throws IOException {
            .build();
    }
    }
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // Verify the result
        // Call the method under test
        );  
    }  
    public void testParseProtoWithBothIndicesBoostFormatsPrefersList() throws IOException {
        assertEquals("SearchAfter should have 2 values", 2, searchSourceBuilder.searchAfter().length);  
        boostMap.put("index1", 1.0f);
                FieldValue.newBuilder().setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setFloatValue(42.0f)).build()  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
                .setIgnoreMalformed(true)  
        );
                    new SearchSourceBuilder.ScriptField("script_field_1", new org.opensearch.script.Script("doc['field'].value * 2"), true)
                    .setFilter(org.opensearch.protobufs.SourceFilter.newBuilder().addExcludes("secret_field").build())  
import org.opensearch.protobufs.TrackHits;
            .build();
        // Create a protobuf SearchRequestBody with xSource excludes
        // Create a protobuf SearchRequestBody with fields
        // Call the method under test
        // Call the method under test  
        );  
        derivedFieldsMap.put(  
        // Create a SearchSourceBuilder to populate
    // ========================================
        ScriptField scriptFieldProto = ScriptField.newBuilder()
 *
            .putFields("nested_field1", ObjectMap.Value.newBuilder().setString("text").build())
        derivedFieldsMap.put(
                        "number",
        // Verify the result  
        assertTrue("Explain should be true", searchSourceBuilder.explain());  
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);  
    }
        mockRegistry = mock(NamedWriteableRegistry.class);
    }
    public void testParseProtoWithStats() throws IOException {
        // Create a protobuf SearchRequestBody with postFilter
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
            AggregationContainer.newBuilder().setMax(MaxAggregation.newBuilder().setField("price").build()).build()  
        // Create a protobuf SearchRequestBody with query  
                .setType("number")  
    public void testParseProtoWithTimeout() throws IOException {  
 * compatible open source license.
import org.opensearch.transport.grpc.proto.request.search.aggregation.AggregationBuilderProtoConverterRegistryImpl;
        // Create a protobuf SearchRequestBody with verbosePipeline
        assertEquals("Field name should match", "test_script_field", scriptField.fieldName());
        // Test that aggregations field is properly parsed from SearchRequestBody
            () -> SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry)
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
    }  
            .addSort(  
            .putFields("nested_field2", ObjectMap.Value.newBuilder().setString("keyword").build())  
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
import java.util.HashMap;
            UnsupportedOperationException.class,
    }
        // Create a SearchSourceBuilder to populate  
