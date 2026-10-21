    public void testParseProtoWithMinScore() throws IOException {
            "derived_field_1",
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().build();
        assertFalse("IgnoreFailure should be false by default", scriptField.ignoreFailure());
        // Create a protobuf SearchRequestBody with fields
    public void testParseProtoWithTerminateAfter() throws IOException {
                    new org.opensearch.index.mapper.DerivedField(
            .setQuery(QueryContainer.newBuilder().setMatchAll(MatchAllQuery.newBuilder().build()).build())
        assertEquals("Should have 2 aggregations", 2, builder.aggregations().count());
        assertNotNull("ScriptFields should not be null", searchSourceBuilder.scriptFields());
        // Verify the result
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setVersion(true).build();
        assertEquals("MinScore should match", 0.5f, searchSourceBuilder.minScore(), 0.0f);
        // Create a SearchSourceBuilder to populate
        // Call the method under test
        scriptFieldsMap.put(
        // Test that empty aggregations map doesn't cause issues
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        assertEquals("TrackTotalHits should be disabled", TRACK_TOTAL_HITS_DISABLED, searchSourceBuilder.trackTotalHitsUpTo().intValue());
        // Create a protobuf SearchRequestBody with from
    }
        assertTrue("PostFilter should be MatchAllQueryBuilder", searchSourceBuilder.postFilter() instanceof MatchAllQueryBuilder);
        assertEquals("indices_boost_2 should be preferred when both are set", 1, searchSourceBuilder.indexBoosts().size());
            .orElse(null);
    public void testParseProtoWithTrackScores() throws IOException {
            "script_field_1",
    public void testParseProtoWithIndicesBoost2EmptyMapThrows() {
            DerivedField.newBuilder()
        derivedFieldsMap.put(
                )
import org.opensearch.protobufs.FieldValue;
            .setXSource(org.opensearch.protobufs.SourceConfig.newBuilder().build())
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    }
                        new org.opensearch.script.Script("doc['field'].value * 2")
        assertTrue("Stats should contain stat2", searchSourceBuilder.stats().contains("stat2"));
            .addDocvalueFields(FieldAndFormat.newBuilder().setField("field2").setFormat("format2").build())
        // Call the method under test
        // Find the simple derived field
    public void testParseProtoWithStats() throws IOException {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
 * The OpenSearch Contributors require contributions made to
        assertEquals("SearchPipeline should match", "my-pipeline", searchSourceBuilder.pipeline());
        // Create a SearchSourceBuilder to populate
        derivedFieldsMap.put(
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        assertEquals("Format should match", "yyyy-MM-dd", fieldWithProps.getFormat());
    public void testParseProtoWithExtThrowsUnsupportedOperationException() throws IOException {
        derivedFieldsMap.put(
        assertEquals("Slice field should match", "_id", searchSourceBuilder.slice().getField());
        assertNotNull("FetchSourceContext should not be null", searchSourceBuilder.fetchSource());
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()
        assertTrue("Exception message should mention ext param", exception.getMessage().contains("ext param is not supported yet"));
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    public void testParseProtoWithProfile() throws IOException {
                .setIgnoreFailure(true)
            () -> SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry)
        assertEquals("index2", searchSourceBuilder.indexBoosts().get(0).getIndex());
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()
        // Verify the result
    public void setUp() throws Exception {
            .orElse(null);
        // Create a protobuf SearchRequestBody with indicesBoost
        assertNotNull("Should find simple_derived_field", simpleField);
    }
        assertEquals("Field name should match", "test_script_field", scriptField.fieldName());
        FloatMap invalidMap = FloatMap.newBuilder().putFloatMap("index1", 1.0f).putFloatMap("index2", 2.0f).build();
    public void testParseProtoWithSuggest() throws IOException {
            "min_price",
        // Call the method under test
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
                org.opensearch.protobufs.SortCombinations.newBuilder()
        );
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().addStats("stat1").addStats("stat2").build();
import org.opensearch.index.query.MatchAllQueryBuilder;
        boostMap.put("index1", 1.0f);
package org.opensearch.transport.grpc.proto.request.search;
        assertNotNull("DerivedFields should not be null", searchSourceBuilder.getDerivedFields());
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setSize(20).build();
    public void testParseProtoWithHighlight() throws IOException {
}
            "test_script_field",
                        "string",
    public void testParseProtoWithXSource() throws IOException {
    public void testParseProtoWithSeqNoPrimaryTerm() throws IOException {
            )
        // Create a protobuf SearchRequestBody with searchPipeline
        assertNull("Format should be null", simpleField.getFormat());
    }
    public void testParseProtoWithDerivedFieldsWithOptionalProperties() throws IOException {
    // ========================================
            .setCollapse(org.opensearch.protobufs.FieldCollapse.newBuilder().setField("category").build())
                .setType("number")
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // Call the method under test
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
    }
    }
            .build();
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
                .setFormat("yyyy-MM-dd")
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        UnsupportedOperationException exception = expectThrows(
            .findFirst()
        );
                )
                .contains(
        // Verify the result
        assertNotNull("SearchAfter should not be null", searchSourceBuilder.searchAfter());
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        SearchSourceBuilder builder = new SearchSourceBuilder();
                .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("doc['field'].value * 2").build()).build())
        assertEquals("Slice max should match", 10, searchSourceBuilder.slice().getMax());
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        // Call the method under test
        assertEquals("Slice id should match", 5, searchSourceBuilder.slice().getId());
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // Call the method under test
import org.opensearch.transport.grpc.proto.request.search.query.QueryBuilderProtoTestUtils;
            .addFields(FieldAndFormat.newBuilder().setField("field2").setFormat("format2").build())
        assertEquals("Should have 2 stats", 2, searchSourceBuilder.stats().size());
        // Create a protobuf SearchRequestBody with docValueFields
            .stream()
        assertEquals("Second value should match", 42.0f, searchSourceBuilder.searchAfter()[1]);
        // Create a SearchSourceBuilder to populate
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()
        // Create a protobuf SearchRequestBody with scriptFields
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
    }
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().addIndicesBoost2(emptyMap).build();
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().addStoredFields("field1").addStoredFields("field2").build();
            .build();
            ScriptField.newBuilder()
        // Create a SearchSourceBuilder to populate
    }
        // Call the method under test
        assertEquals("From should match", 10, searchSourceBuilder.from());
        assertEquals("Should have 2 script fields", 2, searchSourceBuilder.scriptFields().size());
    public void testParseProtoWithSlice() throws IOException {
    public void testParseProtoWithDerivedFields() throws IOException {
        // Create a SearchSourceBuilder to populate
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            .build();
        assertEquals("Size should match", 20, searchSourceBuilder.size());
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("doc['field'].value * 2").build()).build())
        // Verify the result
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
                        org.opensearch.protobufs.FieldSortMap.newBuilder()
        SearchSourceBuilderProtoUtils.parseProto(builder, protoRequest, queryUtils, aggregationRegistry);
    }
    }
        // Verify the result
        );
        assertEquals("Should have 2 properties", 2, fieldWithProps.getProperties().size());
        assertNotNull("DocValueFields should not be null", searchSourceBuilder.docValueFields());
    // ========================================
        // Create a protobuf SearchRequestBody with size
            DerivedField.newBuilder()
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
            .build();
        assertNotNull("PostFilter should not be null", searchSourceBuilder.postFilter());
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        Map<String, ScriptField> scriptFieldsMap = new HashMap<>();
    }
        assertEquals("nested_field2 type should match", "keyword", fieldWithProps.getProperties().get("nested_field2"));
        assertNotNull("Collapse should not be null", searchSourceBuilder.collapse());
import static org.opensearch.search.internal.SearchContext.TRACK_TOTAL_HITS_DISABLED;
        // Call the method under test
            .build();
                    .build()
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
            "Should contain derived_field_2",
/*
        SearchSourceBuilderProtoUtils.parseProto(builder, protoRequest, queryUtils, aggregationRegistry);
        FloatMap boost1 = FloatMap.newBuilder().putFloatMap("index1", 1.5f).build();
        assertTrue("Query should be MatchAllQueryBuilder", searchSourceBuilder.query() instanceof MatchAllQueryBuilder);
        IllegalArgumentException e = expectThrows(
        aggregationRegistry = new AggregationBuilderProtoConverterRegistryImpl();
        // Create a protobuf SearchRequestBody with explain
        // Create a SearchSourceBuilder to populate
    }
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()
        assertEquals("Should have 2 derived fields", 2, searchSourceBuilder.getDerivedFields().size());
        // Create a protobuf SearchRequestBody with stats
                .setType("object")
            .setPostFilter(QueryContainer.newBuilder().setMatchAll(MatchAllQuery.newBuilder().build()).build())
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        assertNotNull("ScriptField should not be null", scriptField);
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setSearchPipeline("my-pipeline").build();
        // Create a SearchSourceBuilder to populate
    public void testParseProtoWithFields() throws IOException {
    private NamedWriteableRegistry mockRegistry;
    private AbstractQueryBuilderProtoUtils queryUtils;
    }
        assertNotNull("IndexBoosts should not be null", searchSourceBuilder.indexBoosts());
            .addSearchAfter(
        // Create a SearchSourceBuilder to populate
        // Create a SearchSourceBuilder to populate
            .putFields("nested_field2", ObjectMap.Value.newBuilder().setString("keyword").build())
                                    .setOrder(org.opensearch.protobufs.SortOrder.SORT_ORDER_DESC)
        // Create a protobuf SearchRequestBody with postFilter
        // Create a SearchSourceBuilder to populate
        SearchSourceBuilder.ScriptField scriptField = SearchSourceBuilderProtoUtils.ScriptFieldProtoUtils.fromProto(
    }
                .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("doc['field'].value * 2").build()).build())
        assertNotNull("ScriptField should not be null", scriptField);
    }
        // Create a SearchSourceBuilder to populate
        assertEquals("TrackTotalHits should match", 1000, searchSourceBuilder.trackTotalHitsUpTo().intValue());
            IllegalArgumentException.class,
            .filter(f -> f.getName().equals("derived_field_with_properties"))
        );
        boostMap.put("index2", 2.0f);
        // Call the method under test
        assertTrue("SeqNoPrimaryTerm should be true", searchSourceBuilder.seqNoAndPrimaryTerm());
                .setProperties(properties)
            .build();
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()
                .setIgnoreMalformed(true)
import org.opensearch.protobufs.TrackHits;
        assertEquals("Field name should match", "test_script_field", scriptField.fieldName());
            "simple_derived_field",
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setFrom(10).build();
    public void testParseProtoWithVersion() throws IOException {
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
            .build();
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().putAllScriptFields(scriptFieldsMap).build();
        // This test is no longer applicable as the field doesn't exist
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        // Call the method under test
        assertEquals("Should have 2 docValueFields", 2, searchSourceBuilder.docValueFields().size());
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        assertNotNull("DerivedFields should not be null", searchSourceBuilder.getDerivedFields());
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()
            .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("doc['field'].value * 2").build()).build())
    }
 *
        assertTrue(
import org.opensearch.protobufs.ObjectMap;
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    public void testParseProtoWithStoredFields() throws IOException {
                    .setFilter(org.opensearch.protobufs.SourceFilter.newBuilder().addExcludes("secret_field").build())
        assertEquals("Should have 2 indexBoosts", 2, searchSourceBuilder.indexBoosts().size());
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        // Create a SearchSourceBuilder to populate
        // Create an instance with all built-in converters
import org.opensearch.protobufs.SearchRequestBody;
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().putAllIndicesBoost(boostMap).addIndicesBoost2(boost2).build();
        ScriptField scriptFieldProto = ScriptField.newBuilder()
    }
    }
                    .build()
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // Call the method under test
    public void testParseProtoWithAggregations() throws IOException {
        assertTrue(
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        assertNotNull("FetchSourceContext should not be null", searchSourceBuilder.fetchSource());
        assertEquals("Prefilter field should match", "source_field", fieldWithProps.getPrefilterField());
                    new SearchSourceBuilder.ScriptField("script_field_2", new org.opensearch.script.Script("doc['field'].value * 2"), false)
        // Verify the result
    }
        );
        // Call the method under test, should throw UnsupportedOperationException
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().build();
 * this file be licensed under the Apache-2.0 license or a
        ObjectMap properties = ObjectMap.newBuilder()
            .build();
        // Create a protobuf SearchRequestBody with xSource excludes
    private AggregationBuilderProtoConverterRegistry aggregationRegistry;
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            "max_price",
        // Find the derived field with properties
        // Verify the result
                .contains(
        // Verify the result
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().addIndicesBoost2(invalidMap).build();
        );
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            .findFirst()
        assertNotNull("Highlight should not be null", searchSourceBuilder.highlighter());
            .setSlice(SlicedScroll.newBuilder().setId(5).setMax(10).setField("_id").build())
 */
        assertEquals("Type should match", "object", fieldWithProps.getType());
    public void testParseProtoWithTrackTotalHitsBooleanFalse() throws IOException {
        assertEquals("TrackTotalHits should be accurate", TRACK_TOTAL_HITS_ACCURATE, searchSourceBuilder.trackTotalHitsUpTo().intValue());
            DerivedField.newBuilder()
                    .setFilter(org.opensearch.protobufs.SourceFilter.newBuilder().addIncludes("field1").addIncludes("field2").build())
    }
import org.opensearch.protobufs.FloatMap;
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()
            "Should contain derived_field_1",
            .setHighlight(org.opensearch.protobufs.Highlight.newBuilder().addPreTags("<em>").addPostTags("</em>").build())
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // Verify the result
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().putAllIndicesBoost(boostMap).build();
        assertTrue("IgnoreFailure should be true", scriptField.ignoreFailure());
        // Create a SearchSourceBuilder to populate
        // Should not throw exception as suggest field no longer exists
import org.opensearch.protobufs.InlineScript;
    public void testParseProtoWithSearchPipeline() throws IOException {
        assertTrue("VerbosePipeline should be true", searchSourceBuilder.verbosePipeline());
        // Create a protobuf ScriptField without ignoreFailure
        assertNotNull("Query should not be null", searchSourceBuilder.query());
        Map<String, AggregationContainer> aggregationsMap = new HashMap<>();
        // Verify the result
                .build()
        assertEquals("Timeout should match", TimeValue.timeValueSeconds(5), searchSourceBuilder.timeout());
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().putAllDerived(derivedFieldsMap).build();
        ScriptField scriptFieldProto = ScriptField.newBuilder()
        // Call the method under test
        assertTrue(
    public void testParseProtoWithSearchAfter() throws IOException {
import static org.mockito.Mockito.mock;
                .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("doc['field'].value * 2").build()).build())
            .build();
    public void testParseProtoWithDocValueFields() throws IOException {
                .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("doc['field'].value * 2").build()).build())
        // Create a protobuf SearchRequestBody with seqNoPrimaryTerm
        );
    public void testParseProtoWithoutAggregations() throws IOException {
        // Verify the result
                .build()
import org.opensearch.protobufs.MatchAllQuery;
                .setPrefilterField("source_field")
                        "derived_field_1",
            "Should contain script_field_2",
        assertNotNull("IndexBoosts should not be null", searchSourceBuilder.indexBoosts());
        assertTrue("Version should be true", searchSourceBuilder.version());
import org.opensearch.protobufs.FieldAndFormat;
                                org.opensearch.protobufs.FieldSort.newBuilder()
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()
import org.opensearch.protobufs.AggregationContainer;
        assertNotNull("IndexBoosts should not be null", searchSourceBuilder.indexBoosts());
 * compatible open source license.
            AggregationContainer.newBuilder().setMin(MinAggregation.newBuilder().setField("price").build()).build()
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
    }
        // Create a SearchSourceBuilder to populate
    }
        // Verify the result
    }
import org.opensearch.protobufs.Script;
        // Verify the result
        // Call the method under test
        // Create a protobuf SearchRequestBody with terminateAfter
            ScriptField.newBuilder()
import java.io.IOException;
        // Create a protobuf SearchRequestBody with trackTotalHits integer
    }
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().addIndicesBoost2(boost1).addIndicesBoost2(boost2).build();
        assertNotNull("Stats should not be null", searchSourceBuilder.stats());
    }
    }
        assertTrue("Profile should be true", searchSourceBuilder.profile());
    }
        assertEquals("First value should match", "value1", searchSourceBuilder.searchAfter()[0]);
        assertTrue(e.getMessage().contains("exactly one index-to-boost mapping"));
    public void testParseProtoWithSize() throws IOException {
                FieldValue.newBuilder().setGeneralNumber(org.opensearch.protobufs.GeneralNumber.newBuilder().setFloatValue(42.0f)).build()
    public void testParseProtoWithFrom() throws IOException {
        // Create a protobuf SearchRequestBody with minScore
            .setIgnoreFailure(true)
        // Call the method under test
        SearchSourceBuilder.ScriptField scriptField = SearchSourceBuilderProtoUtils.ScriptFieldProtoUtils.fromProto(
            .build();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        // Parse proto
        assertTrue(e.getMessage().contains("exactly one index-to-boost mapping"));
        assertEquals("nested_field1 type should match", "text", fieldWithProps.getProperties().get("nested_field1"));
                            .putFieldSortMap(
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        // Call the method under test
import java.util.Map;
    // Aggregations Tests
        // Create a protobuf SearchRequestBody with derived fields including optional properties
            IllegalArgumentException.class,
    public void testParseProtoWithPostFilter() throws IOException {
        super.setUp();
        assertEquals("Collapse field should match", "category", searchSourceBuilder.collapse().getField());
        // Call the method under test
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // Create a SearchSourceBuilder to populate
        // Verify the result
import org.opensearch.protobufs.DerivedField;
    }
        // Create a protobuf SearchRequestBody with profile
import org.opensearch.protobufs.QueryContainer;
        assertNull("Properties should be null", simpleField.getProperties());
        // Create a SearchSourceBuilder to populate
        // Verify the result
                .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("doc['field'].value * 2").build()).build())
                    .build()
        assertTrue("IncludeNamedQueriesScore should be true", searchSourceBuilder.includeNamedQueriesScore());
        // Call the method under test
                .setType("string")
    }
        // Call the method under test
        // Create a protobuf SearchRequestBody with derived fields
        aggregationsMap.put(
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setTrackScores(true).build();
        // Create a SearchSourceBuilder to populate
        );
    public void testParseProtoWithTrackTotalHitsInteger() throws IOException {
import org.opensearch.protobufs.SlicedScroll;
            )
                .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("emit(doc['field'].value)").build()).build())
                            .build()
        // Verify the result
    public void testParseProtoWithVerbosePipeline() throws IOException {
        );
        FloatMap boost2 = FloatMap.newBuilder().putFloatMap("index2", 2.5f).build();
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
    public void testScriptFieldProtoUtilsFromProtoWithDefaultIgnoreFailure() throws IOException {
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setIncludeNamedQueriesScore(true).build();
        // Call the method under test
import java.util.HashMap;
        // Create a protobuf SearchRequestBody with trackTotalHits boolean true
        // Create a SearchSourceBuilder to populate
import static org.opensearch.search.internal.SearchContext.TRACK_TOTAL_HITS_ACCURATE;
    public void testParseProtoWithIndicesBoost() throws IOException {
            .setTrackTotalHits(TrackHits.newBuilder().setEnabled(false).build())
        // Create a SearchSourceBuilder to populate
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        // Create a protobuf SearchRequestBody with searchAfter
        assertEquals("Should have 2 indexBoosts", 2, searchSourceBuilder.indexBoosts().size());
        assertTrue("TrackScores should be true", searchSourceBuilder.trackScores());
        assertEquals("SearchAfter should have 2 values", 2, searchSourceBuilder.searchAfter().length);
    }
        // Verify the result
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.includeNamedQueriesScores(true);
        // Create a SearchSourceBuilder to populate
            () -> SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry)
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setProfile(true).build();
        // Verify no aggregations
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            scriptFieldProto
        assertTrue("Stats should contain stat1", searchSourceBuilder.stats().contains("stat1"));
            .build();
    public void testParseProtoWithTimeout() throws IOException {
        assertNotNull("StoredFields should not be null", searchSourceBuilder.storedFields());
                org.opensearch.protobufs.SourceConfig.newBuilder()
        // Verify the result
        // Verify aggregations
        assertNotNull("FetchFields should not be null", searchSourceBuilder.fetchFields());
        );
        assertNotNull("Properties should not be null", fieldWithProps.getProperties());
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
import org.opensearch.search.builder.SearchSourceBuilder;
                                    .build()
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        assertNotNull("Script should not be null", scriptField.script());
        SearchSourceBuilder builder = new SearchSourceBuilder();
                        "derived_field_2",
        // Create a protobuf SearchRequestBody with ext
            .setXSource(
    }
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            "derived_field_with_properties",
        derivedFieldsMap.put(
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
                )
        // Create a protobuf ScriptField
                    )
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        assertTrue("Explain should be true", searchSourceBuilder.explain());
                    .setFieldWithOrder(
import org.opensearch.protobufs.ScriptField;
    public void testParseProtoWithSort() throws IOException {
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setSeqNoPrimaryTerm(true).build();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        IllegalArgumentException e = expectThrows(
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        assertEquals("Script source should match", "doc['field'].value * 2", scriptField.script().getIdOrCode());
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()
            UnsupportedOperationException.class,
            "script_field_2",
        // Create a protobuf SearchRequestBody with query
import org.opensearch.test.OpenSearchTestCase;
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()
                        new org.opensearch.script.Script("doc['field'].value * 2")
import org.opensearch.protobufs.MaxAggregation;
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        assertNotNull("Slice should not be null", searchSourceBuilder.slice());
    @Override
        // Create a SearchSourceBuilder to populate
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().putAllAggregations(aggregationsMap).build();
        // Create a protobuf SearchRequestBody with includeNamedQueriesScore
            AggregationContainer.newBuilder().setMax(MaxAggregation.newBuilder().setField("price").build()).build()
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setTerminateAfter(100).build();
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        // Create a protobuf SearchRequestBody with slice
                            )
        // Verify the result
            searchSourceBuilder.getDerivedFields()
                .contains(
        // Verify the result
        // Verify the result
            )
        // Call the method under test
                    new SearchSourceBuilder.ScriptField("script_field_1", new org.opensearch.script.Script("doc['field'].value * 2"), true)
        // Create a protobuf SearchRequestBody with verbosePipeline
                org.opensearch.protobufs.SourceConfig.newBuilder()
        // Verify the result
        assertEquals("Should have 1 sort", 1, searchSourceBuilder.sorts().size());
    }
        mockRegistry = mock(NamedWriteableRegistry.class);
        );
        boostMap.put("index2", 99.0f);
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        // Create a protobuf SearchRequestBody with trackScores
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        org.opensearch.index.mapper.DerivedField fieldWithProps = searchSourceBuilder.getDerivedFields()
            "Should contain script_field_1",
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()
                .contains(
import org.opensearch.protobufs.MinAggregation;
    public void testParseProtoWithXSourceIncludes() throws IOException {
                )
        assertNotNull("Aggregations should not be null", builder.aggregations());
                .build()
    public void testParseProtoWithIncludeNamedQueriesScore() throws IOException {
        // Create a protobuf SearchRequestBody with version
        // Create a protobuf SearchRequestBody with timeout
        // Create a SearchSourceBuilder to populate
        );
    public void testParseProtoWithCollapse() throws IOException {
        // Call the method under test
    public void testParseProtoWithScriptFields() throws IOException {
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()
    }
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setVerbosePipeline(true).build();
        // Call the method under test
    public void testScriptFieldProtoUtilsFromProto() throws IOException {
        // Suggest functionality is now handled via SearchRequest URL parameters (suggest_field, suggest_text, etc.)
            .addDocvalueFields(FieldAndFormat.newBuilder().setField("field1").setFormat("format1").build())
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setExplain(true).build();
        // Verify the result
    }
        // Verify the result
        // Verify the result
        // Create a SearchSourceBuilder to populate
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()
        aggregationsMap.put(
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        );
                .setType("number")
        );
                                "timestamp",
    }
        // Call the method under test
 * SPDX-License-Identifier: Apache-2.0
            .build();
        // Create a SearchSourceBuilder to populate
            .setTrackTotalHits(TrackHits.newBuilder().setCount(1000).build())
        assertNotNull("Sorts should not be null", searchSourceBuilder.sorts());
        Map<String, Float> boostMap = new HashMap<>();
                    )
        assertTrue(
        // Create a SearchSourceBuilder to populate
    }
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setMinScore(0.5f).build();
        Map<String, Float> boostMap = new HashMap<>();
            .putFields("nested_field1", ObjectMap.Value.newBuilder().setString("text").build())
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
    }
        // Call the method under test
        );
        FloatMap emptyMap = FloatMap.newBuilder().build();
    public void testParseProtoWithQuery() throws IOException {
        assertEquals(2.0f, searchSourceBuilder.indexBoosts().get(0).getBoost(), 0.001f);
    }
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()
        // Verify the result
            .build();
            .stream()
            .addSort(
                .build()
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        );
            "test_script_field",
        org.opensearch.index.mapper.DerivedField simpleField = searchSourceBuilder.getDerivedFields()
                        "number",
        // Call the method under test
        // Parse proto
import org.opensearch.transport.grpc.proto.request.search.aggregation.AggregationBuilderProtoConverterRegistryImpl;
        // Call the method under test
        // Verify the result
        // Verify the result
                .build()
                    new org.opensearch.index.mapper.DerivedField(
    public void testParseProtoWithExplain() throws IOException {
            DerivedField.newBuilder()
        assertFalse("Ignore malformed should be false", simpleField.getIgnoreMalformed());
        // Test that aggregations field is properly parsed from SearchRequestBody
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverterRegistry;
        // Create a SearchSourceBuilder to populate
        assertNotNull("Should find derived_field_with_properties", fieldWithProps);
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setExt(ObjectMap.newBuilder().build()).build();
            searchSourceBuilder.scriptFields()
            .setXSource(
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // Verify the result
import org.opensearch.common.unit.TimeValue;
            .build();
public class SearchSourceBuilderProtoUtilsTests extends OpenSearchTestCase {
import org.opensearch.transport.grpc.proto.request.search.query.AbstractQueryBuilderProtoUtils;
    }
    }
        );
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    }
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        assertEquals("Type should match", "number", simpleField.getType());
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder()
        // Verify the result
        // Call the method under test
        FloatMap boost2 = FloatMap.newBuilder().putFloatMap("index2", 2.0f).build();
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
            .build();
            scriptFieldProto
            )
    }
        boostMap.put("index1", 1.0f);
            .addSearchAfter(FieldValue.newBuilder().setString("value1").build())
    public void testParseProtoWithIndicesBoost2() throws IOException {
        assertNotNull("Script should not be null", scriptField.script());
            .filter(f -> f.getName().equals("simple_derived_field"))
            .build();
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().putAllDerived(derivedFieldsMap).build();
        assertEquals("Script source should match", "doc['field'].value * 2", scriptField.script().getIdOrCode());
            .addFields(FieldAndFormat.newBuilder().setField("field1").setFormat("format1").build())
            "derived_field_2",
        assertEquals("Should have 2 derived fields", 2, searchSourceBuilder.getDerivedFields().size());
            .build();
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        // Create a SearchSourceBuilder to populate
            .setTrackTotalHits(TrackHits.newBuilder().setEnabled(true).build())
    public void testParseProtoWithXSourceExcludes() throws IOException {
        SearchRequestBody protoRequest = SearchRequestBody.newBuilder().setTimeout("5s").build();
                .build()
    }
            searchSourceBuilder.getDerivedFields()
            searchSourceBuilder.scriptFields()
        // Verify the result
    public void testParseProtoWithIndicesBoost2MultipleKeysThrows() {
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
                    )
    public void testParseProtoWithBothIndicesBoostFormatsPrefersList() throws IOException {
        // Create a SearchSourceBuilder to populate
        // Call the method under test
        // Call the method under test
        // Call the method under test
        Map<String, DerivedField> derivedFieldsMap = new HashMap<>();
            .build();
        // Suggester field was removed from SearchRequestBody in protobufs 1.0.0
        assertEquals("TerminateAfter should match", 100, searchSourceBuilder.terminateAfter());
    }
        // Create a SearchSourceBuilder to populate
        assertEquals("Should have 2 fetchFields", 2, searchSourceBuilder.fetchFields().size());
        assertNull("Aggregations should be null", builder.aggregations());
        // Create a protobuf SearchRequestBody with trackTotalHits boolean false
        assertNotNull("FetchSourceContext should not be null", searchSourceBuilder.fetchSource());
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
    }
        assertTrue("Ignore malformed should be true", fieldWithProps.getIgnoreMalformed());
        // Create a SearchSourceBuilder to populate
        assertNull("Prefilter field should be null", simpleField.getPrefilterField());
        Map<String, DerivedField> derivedFieldsMap = new HashMap<>();
        queryUtils = QueryBuilderProtoTestUtils.createQueryUtils();
        scriptFieldsMap.put(
        SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry);
    public void testParseProtoWithTrackTotalHitsBooleanTrue() throws IOException {
        // Call the method under test
            () -> SearchSourceBuilderProtoUtils.parseProto(searchSourceBuilder, protoRequest, queryUtils, aggregationRegistry)
