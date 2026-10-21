        assertNotNull("SearchSourceBuilder should not be null", searchSourceBuilder);
    public void testParseSearchSourceWithTrackTotalHitsInteger() throws IOException {
            .build();
        // Verify the result
            .setSuggestSize(10)
        assertArrayEquals(
 * this file be licensed under the Apache-2.0 license or a
                size -> {},
        IllegalArgumentException exception = expectThrows(
            SearchContext.TRACK_TOTAL_HITS_ACCURATE,
        SearchRequestProtoUtils.parseSearchRequest(
        assertNotNull("Source should not be null", searchRequest.source());
        SearchRequestProtoUtils.parseSearchRequest(
        // Create a protobuf SearchRequest with the request body
        assertEquals("Should have 3 stored fields", 3, storedFieldsContext.fieldNames().size());
            queryUtils,
        assertTrue("TrackTotalHits should be true", searchRequest.source().trackTotalHitsUpTo() == SearchContext.TRACK_TOTAL_HITS_ACCURATE);
            .setSuggestMode(org.opensearch.protobufs.SuggestMode.SUGGEST_MODE_POPULAR)
            )
            .addRouting("routing2")
            .build();
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
            .setExplain(true)
        assertTrue("SeqNoAndPrimaryTerm should be true", searchRequest.source().seqNoAndPrimaryTerm());
        assertEquals(
        // Create a SearchRequest to populate
            protoRequest,
        UnsupportedOperationException exception = expectThrows(
import org.opensearch.protobufs.TrackHits;
        );
            namedWriteableRegistry,
                aggregationRegistry
import org.opensearch.transport.grpc.proto.request.search.query.QueryBuilderProtoTestUtils;
        assertTrue("FetchSource should be true", fetchSourceContext.fetchSource());
            .setSeqNoPrimaryTerm(true)
        assertEquals("PreFilterShardSize should match", 5, searchRequest.getPreFilterShardSize().intValue());
            .build();
            size -> {},
        SearchRequest searchRequest = new SearchRequest();
        assertNotNull("Source should not be null", searchRequest.source());
            .build();
        assertEquals("Preference should match", "_local", searchRequest.preference());
            namedWriteableRegistry,
            searchRequest,
            .addStoredFields("field2")
        assertTrue("Exception message should mention rest_total_hits_as_int", exception.getMessage().contains("rest_total_hits_as_int"));
                queryUtils,
        // Create a protobuf SearchRequest with total_hits_as_int
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    private AbstractQueryBuilderProtoUtils queryUtils;
        assertEquals("typed_keys param is not supported yet", exception.getMessage());
            .setSuggestField("title")
import org.opensearch.action.search.SearchRequest;
            .build();
        searchRequest.source(new SearchSourceBuilder().trackTotalHitsUpTo(1000));
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
            queryUtils,
        assertNotNull("SuggestBuilder should not be null", suggestBuilder);
            .setSearchRequestBody(requestBody)
            .setSearchRequestBody(requestBody)
        SearchRequestProtoUtils.parseSearchSource(searchSourceBuilder, protoRequest, size -> {});
        // Create a protobuf SearchRequest with the request body
        // Create a protobuf SearchRequest with the request body
        // Create a protobuf SearchRequest with doc value fields
        SearchRequest searchRequest = new SearchRequest();
    }
        SearchRequestBody requestBody = SearchRequestBody.newBuilder()
        assertNotNull("Stats should not be null", searchRequest.source().stats());
            .setTrackTotalHits(TrackHits.newBuilder().setCount(1000).build())
import org.opensearch.search.suggest.term.TermSuggestionBuilder.SuggestMode;
        org.opensearch.search.fetch.subphase.FetchSourceContext fetchSourceContext = searchSourceBuilder.fetchSource();
        SearchRequestProtoUtils.parseSearchRequest(
        assertEquals("global_params param is not supported yet", exception.getMessage());
        assertTrue("Version should be true", searchRequest.source().version());
            .addDocvalueFields("field1")
        assertEquals("SuggestText should match", "opensearch", suggestBuilder.getSuggestions().get("title").text());
        SearchRequest searchRequest = new SearchRequest();
            () -> SearchRequestProtoUtils.checkProtoTotalHits(protoRequest, searchRequest)
            .addXSourceIncludes("include2")
        assertNotNull("SearchRequest should not be null", searchRequest);
            protoRequest,
    }
            new String[] { "routing1", "routing2" },
            .setPreference("_local")
        // Create a protobuf SearchRequestBody with stats
                queryUtils,
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        );
import org.opensearch.transport.client.Client;
        mockClient = mock(Client.class);
        StoredFieldsContext storedFieldsContext = searchRequest.source().storedFields();
        SearchRequestProtoUtils.checkProtoTotalHits(protoRequest, searchRequest);
        assertNotNull("Source should not be null", searchRequest.source());
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
import java.io.IOException;
            () -> SearchRequestProtoUtils.parseSearchRequest(
            aggregationRegistry
            .setTimeout("5s")
        assertNotNull("SearchRequest should not be null", searchRequest);
        SearchRequestBody requestBody = SearchRequestBody.newBuilder()
        // Create a protobuf SearchRequest with global_params
        );
            .build();
import org.opensearch.core.common.Strings;
 * compatible open source license.
            .setTerminateAfter(100)
    private NamedWriteableRegistry namedWriteableRegistry;
    public void testParseSearchRequestWithTypedKeysThrowsUnsupportedOperationException() throws IOException {
            .build();
            "Exception message should mention terminateAfter must be > 0",
        // Create a protobuf SearchRequest with basic fields
        SearchRequestBody requestBody = SearchRequestBody.newBuilder().addStats("stat1").addStats("stat2").build();
        assertTrue("RequestCache should be true", searchRequest.requestCache());
import org.opensearch.search.suggest.SuggestBuilder;
            .build();
                size -> {},
        assertNotNull("Source should not be null", searchRequest.source());
        // Call the method under test
        assertEquals("Should have 2 doc value fields", 2, searchSourceBuilder.docValueFields().size());
            .build();
                namedWriteableRegistry,
        );
    }
        // Call the method under test
            exception.getMessage().contains("terminateAfter must be > 0")
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
            .setProfile(true)
        // Create a protobuf SearchRequestBody with track total hits boolean
    }
        assertNotNull("SearchRequest should not be null", searchRequest);
            .setSearchType(org.opensearch.protobufs.SearchType.SEARCH_TYPE_QUERY_THEN_FETCH)
        SearchRequestProtoUtils.parseSearchRequest(
            .addXSourceExcludes("exclude1")
        queryUtils = QueryBuilderProtoTestUtils.createQueryUtils();
            queryUtils,
            .addIndex("index1")
 */
            .setVersion(true)
            .build();
import org.opensearch.transport.grpc.proto.request.search.aggregation.AggregationBuilderProtoConverterRegistryImpl;
        assertTrue("Should contain title suggestion", suggestBuilder.getSuggestions().containsKey("title"));
        // Verify the result
        assertNotNull("SearchRequest should not be null", searchRequest);
        assertEquals("SuggestSize should match", 10, suggestBuilder.getSuggestions().get("title").size().intValue());
        SearchRequestProtoUtils.parseSearchSource(searchSourceBuilder, protoRequest, size -> {});
        assertEquals("TerminateAfter should match", 100, searchRequest.source().terminateAfter());
        super.setUp();
        assertEquals("MaxConcurrentShardRequests should match", 20, searchRequest.getMaxConcurrentShardRequests());
        assertEquals("Scroll timeout should match", TimeValue.timeValueMinutes(1), searchRequest.scroll().keepAlive());
        // Verify the result
        assertTrue("Should contain stat2", searchRequest.source().stats().contains("stat2"));
            .setGlobalParams(org.opensearch.protobufs.GlobalParams.newBuilder().build())
            namedWriteableRegistry,
        // Create a protobuf SearchRequestBody with track total hits integer
            .setTotalHitsAsInt(true)
        SearchRequestBody requestBody = SearchRequestBody.newBuilder().setTerminateAfter(-1).build();
            namedWriteableRegistry,
        SearchRequest searchRequest = new SearchRequest();
    private Client mockClient;
        SearchRequest searchRequest = new SearchRequest();
        // Create a protobuf SearchRequest with total_hits_as_int
                size -> {},
            UnsupportedOperationException.class,
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverterRegistry;
        );
        assertNotNull("SearchSourceBuilder should not be null", searchSourceBuilder);
        assertNotNull("FetchSourceContext should not be null", fetchSourceContext);
            namedWriteableRegistry,
        assertEquals("Size should match", 20, searchRequest.source().size());
        assertNotNull("Source should not be null", searchRequest.source());
        );
    public void testCheckProtoTotalHitsWithTrackTotalHitsUpTo() throws IOException {
import org.opensearch.search.internal.SearchContext;
        // Call the method under test
        // Create a SearchRequest to populate
        assertEquals("BatchedReduceSize should match", 10, searchRequest.getBatchedReduceSize());
        assertTrue(
    public void testCheckProtoTotalHitsWithInvalidTrackTotalHitsUpTo() throws IOException {
        // Verify the result
        assertTrue("Explain should be true", searchRequest.source().explain());
        assertArrayEquals("Indices should match", new String[] { "index1", "index2" }, searchRequest.indices());
    public void testParseSearchSourceWithStoredFields() throws IOException {
        assertTrue("Profile should be true", searchRequest.source().profile());
        // Verify the result
    }
                protoRequest,
            size -> {},
    }
    }
        SearchRequestBody requestBody = SearchRequestBody.newBuilder()
            .setSearchRequestBody(requestBody)
    private AggregationBuilderProtoConverterRegistry aggregationRegistry;
        namedWriteableRegistry = mock(NamedWriteableRegistry.class);
            searchRequest,
}
        SearchRequest searchRequest = new SearchRequest();
import org.opensearch.protobufs.SearchRequestBody;
            protoRequest,
        assertTrue("TrackTotalHits should be true", searchRequest.source().trackTotalHitsUpTo() == SearchContext.TRACK_TOTAL_HITS_ACCURATE);
            protoRequest,
            ((TermSuggestionBuilder) (suggestBuilder.getSuggestions().get("title"))).suggestMode()
        assertEquals("TrackTotalHitsUpTo should match", 1000, searchRequest.source().trackTotalHitsUpTo().intValue());
            .setTotalHitsAsInt(true)
            .setSearchRequestBody(requestBody)
            queryUtils,
            .addIndex("index2")
        SuggestBuilder suggestBuilder = searchSourceBuilder.suggest();
            .setSuggestText("opensearch")
        // Create a SearchRequest to populate
            .setAllowPartialSearchResults(true)
    }
        assertEquals("From should match", 10, searchRequest.source().from());
    public void testParseSearchRequestWithBasicFields() throws IOException {
    public void testParseSearchSourceWithStats() throws IOException {
            .setTrackTotalHits(TrackHits.newBuilder().setEnabled(true).build())
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
    public void testCheckProtoTotalHitsWithRestTotalHitsAsInt() throws IOException {
            .build();
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
            "TrackTotalHitsUpTo should be ACCURATE",
        // Call the method under test
import org.opensearch.search.fetch.StoredFieldsContext;
import org.opensearch.action.search.SearchType;
            IllegalArgumentException.class,
            aggregationRegistry
        SearchRequest searchRequest = new SearchRequest();
        // Verify the result
            .build();
            size -> {},
        assertNotNull("StoredFieldsContext should not be null", storedFieldsContext);
        assertTrue("Should contain field3", storedFieldsContext.fieldNames().contains("field3"));
    }
            .setScroll("1m")
            size -> {},
        // Call the method under test
        assertEquals("CancelAfterTimeInterval should match", TimeValue.timeValueSeconds(30), searchRequest.getCancelAfterTimeInterval());
 * The OpenSearch Contributors require contributions made to
            .setXSource(org.opensearch.protobufs.SourceConfigParam.newBuilder().setFetch(true).build())
        assertTrue("Should contain field2", storedFieldsContext.fieldNames().contains("field2"));
        // Call the method under test
    public void testParseSearchRequestWithRequestBody() throws IOException {
        assertEquals("Should have 1 suggestion", 1, suggestBuilder.getSuggestions().size());
        assertEquals("Should have 2 stats", 2, searchRequest.source().stats().size());
import org.opensearch.search.suggest.term.TermSuggestionBuilder;
            .setBatchedReduceSize(10)
        );
        // Create a SearchRequest with invalid track_total_hits_up_to
public class SearchRequestProtoUtilsTests extends OpenSearchTestCase {
            .build();
            aggregationRegistry
            .build();
        // Create a protobuf SearchRequest with source context
        assertEquals("SearchType should match", SearchType.QUERY_THEN_FETCH, searchRequest.searchType());
        // Call the method under test
        assertNotNull("Scroll should not be null", searchRequest.scroll());
        // Create a SearchRequest to populate
    public void testParseSearchSourceWithSuggest() throws IOException {
        SearchRequestProtoUtils.parseSearchSource(searchSourceBuilder, protoRequest, size -> {});
                queryUtils,
        // Create a SearchRequest with track_total_hits_up_to
            .addStoredFields("field1")
    }
                namedWriteableRegistry,
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
            () -> SearchRequestProtoUtils.parseSearchRequest(
        assertArrayEquals("Excludes should match", new String[] { "exclude1" }, fetchSourceContext.excludes());
            .setMaxConcurrentShardRequests(20)
    public void setUp() throws Exception {
        // Create a SearchRequest to populate
            () -> SearchRequestProtoUtils.parseSearchRequest(
        // Create a SearchSourceBuilder to populate
    }
        // Call the method under test
import org.opensearch.transport.grpc.proto.request.search.query.AbstractQueryBuilderProtoUtils;
        // Call the method under test
        SearchRequest searchRequest = new SearchRequest();
        SearchRequestProtoUtils.checkProtoTotalHits(protoRequest, searchRequest);
        // Create a protobuf SearchRequest with total_hits_as_int and track_total_hits_up_to
            .setSearchRequestBody(requestBody)
        // Call the method under test, should throw IllegalArgumentException
        // Create a SearchSourceBuilder to populate
        );
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
            .build();
        );
        // Verify the result
        );
    }
        assertTrue("CcsMinimizeRoundtrips should be true", searchRequest.isCcsMinimizeRoundtrips());
        );
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
        searchRequest.source(new SearchSourceBuilder().trackTotalHitsUpTo(SearchContext.TRACK_TOTAL_HITS_ACCURATE));
            .addRouting("routing1")
        // Create a protobuf SearchRequest with the request body
        );
        assertTrue("Should contain field1", storedFieldsContext.fieldNames().contains("field1"));
                namedWriteableRegistry,
            .setPhaseTook(true)
            namedWriteableRegistry,
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
        // Create a SearchRequest to populate
            protoRequest,
                protoRequest,
        // Create a protobuf SearchRequest with the request body
            size -> {},
                aggregationRegistry
            .setTypedKeys(true)
                searchRequest,
        assertEquals(
        assertNotNull("Source should not be null", searchRequest.source());
                aggregationRegistry
            .addStoredFields("field3")
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            .build();
        SearchRequest searchRequest = new SearchRequest();
            .setTotalHitsAsInt(true)
            searchRequest.source().trackTotalHitsUpTo().intValue()
import org.opensearch.search.builder.SearchSourceBuilder;
            Strings.commaDelimitedListToStringArray(searchRequest.routing())
            aggregationRegistry
                searchRequest,
            .setSize(20)
        assertArrayEquals("Includes should match", new String[] { "include1", "include2" }, fetchSourceContext.includes());
                searchRequest,
        // Call the method under test
        assertTrue("AllowPartialSearchResults should be true", searchRequest.allowPartialSearchResults());
        SearchRequestBody requestBody = SearchRequestBody.newBuilder()
            UnsupportedOperationException.class,
    public void testParseSearchSourceWithDocValueFields() throws IOException {
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
            queryUtils,
import org.opensearch.common.unit.TimeValue;
    }
        assertNotNull("SearchRequest should not be null", searchRequest);
        assertNotNull("Source should not be null", searchRequest.source());
 * SPDX-License-Identifier: Apache-2.0
        assertTrue("Should contain stat1", searchRequest.source().stats().contains("stat1"));
        // Verify the result
import org.opensearch.test.OpenSearchTestCase;
        // Create a protobuf SearchRequestBody with stored fields
        // Verify the result
    @Override
        // Create a SearchSourceBuilder to populate
            )
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
        assertTrue("TrackScores should be true", searchRequest.source().trackScores());
        // Verify the result
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            IllegalArgumentException.class,
    }
        // Call the method under test, should throw IllegalArgumentException
        // Create a protobuf SearchRequest with typed_keys
            .addDocvalueFields("field2")
        SearchRequestProtoUtils.parseSearchRequest(
        assertEquals("Timeout should match", TimeValue.timeValueSeconds(5), searchRequest.source().timeout());
            protoRequest,
            searchRequest,
        UnsupportedOperationException exception = expectThrows(
        assertNotNull("SearchSourceBuilder should not be null", searchSourceBuilder);
            searchRequest,
 *
        // Create a SearchRequest to populate
            .setTrackScores(true)
package org.opensearch.transport.grpc.proto.request.search;
            .build();
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
            .setPreFilterShardSize(5)
            .setSearchRequestBody(requestBody)
            )
            .addXSourceIncludes("include1")
        IllegalArgumentException exception = expectThrows(
    }
        // Create a SearchRequest to populate
            SuggestMode.POPULAR,
        );
            queryUtils,
        // Call the method under test
import static org.mockito.Mockito.mock;
        // Call the method under test, should throw UnsupportedOperationException
                protoRequest,
        aggregationRegistry = new AggregationBuilderProtoConverterRegistryImpl();
            .setCancelAfterTimeInterval("30s")
        // Create a protobuf SearchRequestBody
            aggregationRegistry
    public void testParseSearchSourceWithInvalidTerminateAfter() throws IOException {
    public void testParseSearchRequestWithGlobalParamsThrowsUnsupportedOperationException() throws IOException {
            .setRequestCache(true)
        assertNotNull("DocValueFields should not be null", searchSourceBuilder.docValueFields());
            searchRequest,
        SearchRequestProtoUtils.parseSearchRequest(
            "SuggestMode should match",
            searchRequest,
        // Call the method under test, should throw UnsupportedOperationException
            .build();
        // Create a protobuf SearchRequest with the request body
    }
/*
        SearchRequest searchRequest = new SearchRequest();
        assertNotNull("SearchRequest should not be null", searchRequest);
        // Create a SearchRequest to populate
        // Create a SearchRequest to populate
        );
        // Create a protobuf SearchRequestBody with invalid terminateAfter
            .setFrom(10)
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
    public void testParseSearchSourceWithTrackTotalHitsBoolean() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
            .build();
            .setCcsMinimizeRoundtrips(true)
        assertTrue("PhaseTook should be true", searchRequest.isPhaseTook());
        assertNotNull("SearchRequest should not be null", searchRequest);
            aggregationRegistry
        // Create a protobuf SearchRequest with suggest
    public void testParseSearchSourceWithSource() throws IOException {
            "Routing should match",
        assertNotNull("SearchRequest should not be null", searchRequest);
            size -> {},
        SearchRequest searchRequest = new SearchRequest();
        // Verify the result
