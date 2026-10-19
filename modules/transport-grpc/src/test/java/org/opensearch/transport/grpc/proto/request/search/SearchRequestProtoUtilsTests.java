            aggregationRegistry
            .setTotalHitsAsInt(true)
                size -> {},  
            searchRequest.source().trackTotalHitsUpTo().intValue()
            .setSearchRequestBody(requestBody)
        // Verify the result
        StoredFieldsContext storedFieldsContext = searchRequest.source().storedFields();  
import org.opensearch.protobufs.TrackHits;
        assertNotNull("SearchRequest should not be null", searchRequest);
        // Create a protobuf SearchRequestBody with stored fields
            .addStoredFields("field2")
    public void testParseSearchSourceWithTrackTotalHitsBoolean() throws IOException {  
            Strings.commaDelimitedListToStringArray(searchRequest.routing())
            queryUtils,
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverterRegistry;
        SearchRequestProtoUtils.parseSearchRequest(  
        // Call the method under test
                size -> {},
        // Create a SearchRequest to populate
            .setSearchRequestBody(requestBody)
            .build();  
        assertNotNull("Source should not be null", searchRequest.source());  
            protoRequest,
        assertEquals("SuggestSize should match", 10, suggestBuilder.getSuggestions().get("title").size().intValue());
        assertNotNull("SearchRequest should not be null", searchRequest);
        );  
        );
    }  
                searchRequest,  
        assertEquals("Should have 1 suggestion", 1, suggestBuilder.getSuggestions().size());
        );
            .setProfile(true)
        assertEquals("TrackTotalHitsUpTo should match", 1000, searchRequest.source().trackTotalHitsUpTo().intValue());  
            .addDocvalueFields("field2")  
        SearchRequestBody requestBody = SearchRequestBody.newBuilder()
        SearchRequest searchRequest = new SearchRequest();
        assertNotNull("Source should not be null", searchRequest.source());
    public void testParseSearchRequestWithBasicFields() throws IOException {
        // Create a SearchRequest to populate  
        SearchRequest searchRequest = new SearchRequest();  
            .build();
            SuggestMode.POPULAR,
        // Create a SearchSourceBuilder to populate  
import org.opensearch.core.common.Strings;
            namedWriteableRegistry,  
            protoRequest,
            "Routing should match",  
            namedWriteableRegistry,
        // Call the method under test
import org.opensearch.search.internal.SearchContext;
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()  
        assertEquals(
import org.opensearch.action.search.SearchType;
            .setAllowPartialSearchResults(true)
        // Verify the result
            .addStoredFields("field1")
        queryUtils = QueryBuilderProtoTestUtils.createQueryUtils();
        // Create a SearchRequest to populate
            SearchContext.TRACK_TOTAL_HITS_ACCURATE,
        // Verify the result
    }
        assertArrayEquals("Excludes should match", new String[] { "exclude1" }, fetchSourceContext.excludes());  
            queryUtils,
        // Create a protobuf SearchRequest with the request body
            "SuggestMode should match",
        // Call the method under test  
            .addXSourceExcludes("exclude1")  
        assertArrayEquals("Indices should match", new String[] { "index1", "index2" }, searchRequest.indices());
import java.io.IOException;  
            queryUtils,
        assertNotNull("SearchRequest should not be null", searchRequest);  
        );
        // Create a SearchRequest to populate
        assertTrue("Should contain field1", storedFieldsContext.fieldNames().contains("field1"));  
public class SearchRequestProtoUtilsTests extends OpenSearchTestCase {
        assertEquals("From should match", 10, searchRequest.source().from());
        super.setUp();
            .addXSourceIncludes("include1")
        assertEquals("Should have 2 stats", 2, searchRequest.source().stats().size());
        SearchRequestProtoUtils.parseSearchRequest(
        assertEquals("SuggestText should match", "opensearch", suggestBuilder.getSuggestions().get("title").text());
            protoRequest,
    }  
        assertNotNull("SearchRequest should not be null", searchRequest);
        );
        // Verify the result
        SearchRequest searchRequest = new SearchRequest();
        assertNotNull("Source should not be null", searchRequest.source());
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
        // Call the method under test
            .setSearchRequestBody(requestBody)
        // Verify the result
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
        );  
    public void testParseSearchSourceWithDocValueFields() throws IOException {
        // Create a protobuf SearchRequestBody with invalid terminateAfter
        assertEquals("CancelAfterTimeInterval should match", TimeValue.timeValueSeconds(30), searchRequest.getCancelAfterTimeInterval());  
                namedWriteableRegistry,
import org.opensearch.common.unit.TimeValue;  
    }
        assertNotNull("Source should not be null", searchRequest.source());
        // Create a protobuf SearchRequest with total_hits_as_int and track_total_hits_up_to
        SearchRequestBody requestBody = SearchRequestBody.newBuilder().addStats("stat1").addStats("stat2").build();
    }
            .build();  
            .setVersion(true)
        );
            .addIndex("index1")
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()  
            .setPreference("_local")
    private AggregationBuilderProtoConverterRegistry aggregationRegistry;  
import org.opensearch.transport.grpc.proto.request.search.query.AbstractQueryBuilderProtoUtils;
            namedWriteableRegistry,
    public void testCheckProtoTotalHitsWithInvalidTrackTotalHitsUpTo() throws IOException {  
        assertEquals("TerminateAfter should match", 100, searchRequest.source().terminateAfter());
        namedWriteableRegistry = mock(NamedWriteableRegistry.class);
                aggregationRegistry
        // Create a protobuf SearchRequest with suggest
        // Call the method under test, should throw IllegalArgumentException
 * this file be licensed under the Apache-2.0 license or a
        // Create a protobuf SearchRequest with total_hits_as_int
        searchRequest.source(new SearchSourceBuilder().trackTotalHitsUpTo(1000));
        assertNotNull("Source should not be null", searchRequest.source());
            () -> SearchRequestProtoUtils.parseSearchRequest(
import org.opensearch.action.search.SearchRequest;
        // Create a SearchRequest to populate
            .setSuggestMode(org.opensearch.protobufs.SuggestMode.SUGGEST_MODE_POPULAR)
        assertNotNull("SearchSourceBuilder should not be null", searchSourceBuilder);
            .setSuggestSize(10)  
        assertTrue("Exception message should mention rest_total_hits_as_int", exception.getMessage().contains("rest_total_hits_as_int"));
        assertEquals("Should have 3 stored fields", 3, storedFieldsContext.fieldNames().size());
        assertEquals("Preference should match", "_local", searchRequest.preference());
                namedWriteableRegistry,
        assertNotNull("FetchSourceContext should not be null", fetchSourceContext);  
    public void testParseSearchRequestWithGlobalParamsThrowsUnsupportedOperationException() throws IOException {  
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()  
            .build();  
                namedWriteableRegistry,  
    private AbstractQueryBuilderProtoUtils queryUtils;
    public void testCheckProtoTotalHitsWithRestTotalHitsAsInt() throws IOException {
import org.opensearch.test.OpenSearchTestCase;
            .build();
            size -> {},
            IllegalArgumentException.class,  
            .setFrom(10)  
            () -> SearchRequestProtoUtils.parseSearchRequest(  
    public void testParseSearchSourceWithSuggest() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        // Call the method under test
            .build();
        SearchRequestBody requestBody = SearchRequestBody.newBuilder().setTerminateAfter(-1).build();  
 * compatible open source license.
import org.opensearch.search.fetch.StoredFieldsContext;  
        assertNotNull("SearchRequest should not be null", searchRequest);  
        assertTrue("AllowPartialSearchResults should be true", searchRequest.allowPartialSearchResults());  
            queryUtils,
            aggregationRegistry
            UnsupportedOperationException.class,
        // Create a protobuf SearchRequest with typed_keys  
        // Verify the result  
    }
            .build();
            .build();
import org.opensearch.search.suggest.SuggestBuilder;
    public void testParseSearchSourceWithStats() throws IOException {  
            .build();
        // Call the method under test
        mockClient = mock(Client.class);  
            .setTrackTotalHits(TrackHits.newBuilder().setCount(1000).build())  
            .setCancelAfterTimeInterval("30s")
    }
        SearchRequestBody requestBody = SearchRequestBody.newBuilder()
/*  
    public void testParseSearchRequestWithTypedKeysThrowsUnsupportedOperationException() throws IOException {
                queryUtils,
    }  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        // Create a protobuf SearchRequestBody
            aggregationRegistry
        assertTrue("Explain should be true", searchRequest.source().explain());  
        SearchRequest searchRequest = new SearchRequest();
            .setMaxConcurrentShardRequests(20)
        // Call the method under test  
        // Create a protobuf SearchRequest with doc value fields  
            namedWriteableRegistry,  
        assertNotNull("SearchRequest should not be null", searchRequest);  
 *
        SearchRequestProtoUtils.parseSearchRequest(  
            .build();  
        // Verify the result  
        SearchRequestProtoUtils.checkProtoTotalHits(protoRequest, searchRequest);  
        assertNotNull("SearchRequest should not be null", searchRequest);
                aggregationRegistry
        // Create a protobuf SearchRequestBody with track total hits integer
        assertTrue("PhaseTook should be true", searchRequest.isPhaseTook());
        assertNotNull("Stats should not be null", searchRequest.source().stats());
            IllegalArgumentException.class,  
    @Override
        assertNotNull("SearchSourceBuilder should not be null", searchSourceBuilder);
        assertEquals("Size should match", 20, searchRequest.source().size());  
            queryUtils,
            .setRequestCache(true)
        SearchRequest searchRequest = new SearchRequest();
        );
        assertEquals(  
            .build();
        assertNotNull("Source should not be null", searchRequest.source());  
        SearchRequestBody requestBody = SearchRequestBody.newBuilder()  
import org.opensearch.search.suggest.term.TermSuggestionBuilder;  
            size -> {},  
    public void testParseSearchSourceWithStoredFields() throws IOException {
            .addIndex("index2")  
        assertTrue("RequestCache should be true", searchRequest.requestCache());
            new String[] { "routing1", "routing2" },
            .setGlobalParams(org.opensearch.protobufs.GlobalParams.newBuilder().build())  
        assertTrue("Should contain stat1", searchRequest.source().stats().contains("stat1"));  
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
            .build();
            searchRequest,  
import static org.mockito.Mockito.mock;
    public void testCheckProtoTotalHitsWithTrackTotalHitsUpTo() throws IOException {
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
        SearchRequestProtoUtils.checkProtoTotalHits(protoRequest, searchRequest);
                protoRequest,
    private NamedWriteableRegistry namedWriteableRegistry;  
                protoRequest,
            aggregationRegistry  
        UnsupportedOperationException exception = expectThrows(
            searchRequest,
            protoRequest,  
            searchRequest,  
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()  
            .setTrackScores(true)
            size -> {},
    public void testParseSearchRequestWithRequestBody() throws IOException {  
            UnsupportedOperationException.class,
        SearchRequest searchRequest = new SearchRequest();  
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
        assertTrue("Should contain stat2", searchRequest.source().stats().contains("stat2"));
        SearchRequest searchRequest = new SearchRequest();  
        // Call the method under test
        // Create a protobuf SearchRequest with the request body
        // Verify the result  
import org.opensearch.search.suggest.term.TermSuggestionBuilder.SuggestMode;
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        assertEquals("Timeout should match", TimeValue.timeValueSeconds(5), searchRequest.source().timeout());
                aggregationRegistry  
            .setSearchRequestBody(requestBody)
        // Call the method under test  
        assertTrue("Profile should be true", searchRequest.source().profile());
        IllegalArgumentException exception = expectThrows(
        // Create a protobuf SearchRequest with basic fields  
        assertTrue("Should contain title suggestion", suggestBuilder.getSuggestions().containsKey("title"));  
        UnsupportedOperationException exception = expectThrows(  
 */  
        // Verify the result
        // Create a protobuf SearchRequestBody with stats
        assertTrue("Should contain field3", storedFieldsContext.fieldNames().contains("field3"));
        // Create a protobuf SearchRequest with total_hits_as_int
    }
            .addRouting("routing1")  
        // Create a SearchRequest with invalid track_total_hits_up_to  
        SearchRequestProtoUtils.parseSearchRequest(
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()  
        // Create a protobuf SearchRequest with global_params
        // Create a protobuf SearchRequest with the request body  
            aggregationRegistry  
            .setSeqNoPrimaryTerm(true)  
        // Call the method under test
            queryUtils,  
        SearchRequest searchRequest = new SearchRequest();
            .setSearchType(org.opensearch.protobufs.SearchType.SEARCH_TYPE_QUERY_THEN_FETCH)
        // Call the method under test
        assertEquals("Should have 2 doc value fields", 2, searchSourceBuilder.docValueFields().size());  
        SearchRequest searchRequest = new SearchRequest();
    public void testParseSearchSourceWithInvalidTerminateAfter() throws IOException {
            .build();
        assertEquals("Scroll timeout should match", TimeValue.timeValueMinutes(1), searchRequest.scroll().keepAlive());
    }
        assertNotNull("SuggestBuilder should not be null", suggestBuilder);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            .build();
        assertNotNull("StoredFieldsContext should not be null", storedFieldsContext);
    }
        assertTrue(
        assertNotNull("SearchRequest should not be null", searchRequest);
        SuggestBuilder suggestBuilder = searchSourceBuilder.suggest();  
 * The OpenSearch Contributors require contributions made to  
}
        assertTrue("FetchSource should be true", fetchSourceContext.fetchSource());
package org.opensearch.transport.grpc.proto.request.search;
            .build();
        searchRequest.source(new SearchSourceBuilder().trackTotalHitsUpTo(SearchContext.TRACK_TOTAL_HITS_ACCURATE));  
        assertNotNull("Scroll should not be null", searchRequest.scroll());  
            .build();  
        );  
        // Create a SearchSourceBuilder to populate  
            searchRequest,
            .setTotalHitsAsInt(true)  
            .setTerminateAfter(100)  
            searchRequest,
            () -> SearchRequestProtoUtils.parseSearchRequest(
            .addRouting("routing2")
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
import org.opensearch.transport.grpc.proto.request.search.aggregation.AggregationBuilderProtoConverterRegistryImpl;
        assertTrue("SeqNoAndPrimaryTerm should be true", searchRequest.source().seqNoAndPrimaryTerm());
            size -> {},  
            protoRequest,
            aggregationRegistry  
                size -> {},
            .setSize(20)
        assertTrue("TrackTotalHits should be true", searchRequest.source().trackTotalHitsUpTo() == SearchContext.TRACK_TOTAL_HITS_ACCURATE);  
        // Create a protobuf SearchRequestBody with track total hits boolean
        SearchRequestBody requestBody = SearchRequestBody.newBuilder()
            .setScroll("1m")
    }
            .setSearchRequestBody(requestBody)  
            namedWriteableRegistry,
    }
        );
        assertTrue("Should contain field2", storedFieldsContext.fieldNames().contains("field2"));
        );  
            .setCcsMinimizeRoundtrips(true)  
        // Create a SearchRequest to populate
        SearchRequest searchRequest = new SearchRequest();
        // Create a protobuf SearchRequest with the request body  
            .setTypedKeys(true)
        assertArrayEquals(
            .setSuggestField("title")
        // Create a protobuf SearchRequest with the request body  
        );
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
        // Call the method under test, should throw IllegalArgumentException
            .setBatchedReduceSize(10)
            .setPhaseTook(true)  
        // Verify the result  
        assertEquals("typed_keys param is not supported yet", exception.getMessage());  
        org.opensearch.search.fetch.subphase.FetchSourceContext fetchSourceContext = searchSourceBuilder.fetchSource();
        assertEquals("SearchType should match", SearchType.QUERY_THEN_FETCH, searchRequest.searchType());
        // Create a SearchRequest to populate
    public void testParseSearchSourceWithTrackTotalHitsInteger() throws IOException {  
            size -> {},
        assertNotNull("Source should not be null", searchRequest.source());
    }
        IllegalArgumentException exception = expectThrows(
    public void setUp() throws Exception {  
import org.opensearch.transport.grpc.proto.request.search.query.QueryBuilderProtoTestUtils;  
        assertTrue("CcsMinimizeRoundtrips should be true", searchRequest.isCcsMinimizeRoundtrips());
            exception.getMessage().contains("terminateAfter must be > 0")
            namedWriteableRegistry,  
        // Create a SearchRequest to populate  
            .addXSourceIncludes("include2")
            )
        // Create a SearchSourceBuilder to populate
            .build();
        assertTrue("TrackScores should be true", searchRequest.source().trackScores());  
        assertEquals("global_params param is not supported yet", exception.getMessage());
                queryUtils,  
        aggregationRegistry = new AggregationBuilderProtoConverterRegistryImpl();
        assertEquals("PreFilterShardSize should match", 5, searchRequest.getPreFilterShardSize().intValue());
        assertTrue("TrackTotalHits should be true", searchRequest.source().trackTotalHitsUpTo() == SearchContext.TRACK_TOTAL_HITS_ACCURATE);
    }
            .setTimeout("5s")
            "TrackTotalHitsUpTo should be ACCURATE",  
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
        SearchRequest searchRequest = new SearchRequest();  
        // Create a SearchRequest to populate
            searchRequest,
            .setSuggestText("opensearch")
            .build();
        );
            .setPreFilterShardSize(5)  
            protoRequest,
            .setSearchRequestBody(requestBody)
            .addDocvalueFields("field1")
        // Create a protobuf SearchRequest with source context
            () -> SearchRequestProtoUtils.checkProtoTotalHits(protoRequest, searchRequest)
            .setExplain(true)
            .addStoredFields("field3")  
            "Exception message should mention terminateAfter must be > 0",  
        assertNotNull("DocValueFields should not be null", searchSourceBuilder.docValueFields());
            .setXSource(org.opensearch.protobufs.SourceConfigParam.newBuilder().setFetch(true).build())  
        assertArrayEquals("Includes should match", new String[] { "include1", "include2" }, fetchSourceContext.includes());
        SearchRequestProtoUtils.parseSearchSource(searchSourceBuilder, protoRequest, size -> {});
            .build();
import org.opensearch.search.builder.SearchSourceBuilder;
                searchRequest,
        // Call the method under test, should throw UnsupportedOperationException  
    private Client mockClient;
        assertNotNull("SearchSourceBuilder should not be null", searchSourceBuilder);
    }
        // Call the method under test, should throw UnsupportedOperationException
    public void testParseSearchSourceWithSource() throws IOException {  
            )
        SearchRequestProtoUtils.parseSearchSource(searchSourceBuilder, protoRequest, size -> {});
import org.opensearch.protobufs.SearchRequestBody;  
        );  
import org.opensearch.transport.client.Client;  
 * SPDX-License-Identifier: Apache-2.0
            ((TermSuggestionBuilder) (suggestBuilder.getSuggestions().get("title"))).suggestMode()  
            .setTotalHitsAsInt(true)
        assertEquals("MaxConcurrentShardRequests should match", 20, searchRequest.getMaxConcurrentShardRequests());
        // Create a SearchRequest with track_total_hits_up_to
            size -> {},
        SearchRequestProtoUtils.parseSearchSource(searchSourceBuilder, protoRequest, size -> {});
        assertTrue("Version should be true", searchRequest.source().version());
        SearchRequestProtoUtils.parseSearchRequest(  
                protoRequest,  
        // Verify the result  
        SearchRequestProtoUtils.parseSearchRequest(
            )  
        org.opensearch.protobufs.SearchRequest protoRequest = org.opensearch.protobufs.SearchRequest.newBuilder()
        // Create a protobuf SearchRequest with the request body
            .setTrackTotalHits(TrackHits.newBuilder().setEnabled(true).build())  
        assertEquals("BatchedReduceSize should match", 10, searchRequest.getBatchedReduceSize());  
                searchRequest,
                queryUtils,
        // Create a SearchRequest to populate
