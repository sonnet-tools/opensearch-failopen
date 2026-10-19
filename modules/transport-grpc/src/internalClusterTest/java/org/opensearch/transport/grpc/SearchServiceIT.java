            SearchResponse response = searchStub.search(searchRequest);  
            // Build max aggregation request
    /**
            assertFalse("PIT id should not be empty", createResponse.getPitId().isEmpty());
     * Tests PIT deletion via gRPC.
            assertEquals("Should have two buckets", 2, sterms.getBucketsCount());
    public void testSearchServiceSearch() throws Exception {
    /**
    /**
/**
            // Verify the response  
        // Create a gRPC client  
     * Tests PIT creation via gRPC.
            assertTrue("Should have aggregations", response.getAggregationsCount() > 0);
                .putAggregations("max_price", AggregationContainer.newBuilder().setMax(maxAgg).build())
            assertTrue("Should have aggregations", response.getAggregationsCount() > 0);
            assertTrue("Should have value", maxResult.getMax().hasValue());  
            ManagedChannel channel = client.getChannel();
            assertNotNull("Search response should not be null", searchResponse);
        String indexName = "test-max-agg";
        indexTestDocument(indexName, "1", "{\"status\": \"active\"}");
            assertTrue("Delete PIT should be successful", deleteResponse.getPits(0).getSuccessful());  
        String indexName = "test-terms-agg-it";  
                .addIndex(indexName)
    }  
            assertEquals("Max value should be 25.0", 25.0, maxResult.getMax().getValue().getDouble(), 0.001);
            assertTrue("Creation time should be positive", response.getCreationTime() > 0);  
        }
        }
            ManagedChannel channel = client.getChannel();
import org.opensearch.protobufs.TermsAggregation;
                .build();
            ManagedChannel channel = client.getChannel();
                .build();  
                .setSize(0)  
 * this file be licensed under the Apache-2.0 license or a
            ManagedChannel channel = client.getChannel();  
            assertTrue("Should have value", minResult.getMin().hasValue());  
import org.opensearch.protobufs.MaxAggregation;
     */  
            // Execute the search request  
        // Index documents with different price values
            assertEquals("Should have one delete result", 1, deleteResponse.getPitsCount());
import org.opensearch.protobufs.DeletePitRequest;  
 * Integration tests for the SearchService gRPC service.  
            assertEquals("Deleted PIT id should match", createResponse.getPitId(), deleteResponse.getPits(0).getPitId());
        }
    public void testTermsAggregation() throws Exception {
            DeletePITResponse deleteResponse = searchStub.deletePit(deleteRequest);
    /**
        indexTestDocument(indexName, "2", "{\"price\": 25.0}");  
            );  
            // Build terms aggregation request on the status keyword field  
            SearchServiceGrpc.SearchServiceBlockingStub searchStub = SearchServiceGrpc.newBlockingStub(channel);  
            CreatePITResponse createResponse = searchStub.createPit(
        indexTestDocument(indexName, "1", DEFAULT_DOCUMENT_SOURCE);
    }  
        createTestIndex(indexName);
        }
import org.opensearch.protobufs.SearchRequestBody;
        try (NettyGrpcClient client = createGrpcClient()) {  
            MaxAggregation maxAgg = MaxAggregation.newBuilder().setField("price").build();  
            // Create a SearchService stub
            SearchResponse searchResponse = searchStub.search(searchRequest);
public class SearchServiceIT extends GrpcTransportBaseIT {
            assertEquals("First bucket doc count should be 2", 2, sterms.getBuckets(0).getDocCount());
import org.opensearch.protobufs.SearchRequest;  
                .setTerms(TermsAggregationFields.newBuilder().setField("status.keyword").build())
        // Index documents with different price values
            SearchServiceGrpc.SearchServiceBlockingStub searchStub = SearchServiceGrpc.newBlockingStub(channel);
        try (NettyGrpcClient client = createGrpcClient()) {
            CreatePitRequest request = CreatePitRequest.newBuilder().addIndex(indexName).setKeepAlive("1m").build();
            assertEquals("Deleted PIT id should match", response.getPitId(), deleteResponse.getPits(0).getPitId());
        indexTestDocument(indexName, "1", "{\"price\": 10.5}");
/*  
    }
        // Create a test index  
    public void testMaxAggregation() throws Exception {
        // Create a gRPC client  
            SearchResponse response = searchStub.search(searchRequest);
import org.opensearch.protobufs.CreatePitRequest;
            DeletePITResponse deleteResponse = searchStub.deletePit(DeletePitRequest.newBuilder().addPitId(response.getPitId()).build());  
        indexTestDocument(indexName, "3", "{\"status\": \"inactive\"}");  
            assertFalse("PIT id should not be empty", response.getPitId().isEmpty());
     */
            MinAggregation minAgg = MinAggregation.newBuilder().setField("price").build();  
                .setSize(0)  
            assertEquals("First bucket key should be 'active'", "active", sterms.getBuckets(0).getKey());
                CreatePitRequest.newBuilder().addIndex(indexName).setKeepAlive("1m").build()
        // Create a test index  
            assertNotNull("Search response should not be null", response);
        String indexName = "test-delete-pit";
        String indexName = "test-min-agg";
            assertNotNull("Create PIT response should not be null", response);
                .setSize(0)  
        indexTestDocument(indexName, "1", DEFAULT_DOCUMENT_SOURCE);
            Aggregate termsResult = response.getAggregationsMap().get("status_terms");  
            // Create a search request  
            assertTrue("Should be a string terms (sterms) aggregate", termsResult.hasSterms());
            SearchRequestBody requestBody = SearchRequestBody.newBuilder()
     */  
            assertTrue("Should have max", maxResult.hasMax());
            SearchRequest searchRequest = SearchRequest.newBuilder().addIndex(indexName).setSearchRequestBody(requestBody).build();
        createTestIndex(indexName);
            assertNotNull("Delete PIT response should not be null", deleteResponse);  
            assertEquals("Should have one delete result", 1, deleteResponse.getPitsCount());
    }
            ManagedChannel channel = client.getChannel();
            assertTrue("Delete PIT should be successful", deleteResponse.getPits(0).getSuccessful());  
        indexTestDocument(indexName, "1", "{\"price\": 10.5}");
        String indexName = "test-search-index";  
        indexTestDocument(indexName, "2", "{\"price\": 25.0}");  
    public void testMinAggregation() throws Exception {
     * Tests max aggregation via gRPC.  
            assertNotNull("Search response should not be null", response);  
            SearchResponse response = searchStub.search(searchRequest);
import org.opensearch.protobufs.DeletePITResponse;
            assertEquals("Min value should be 5.2", 5.2, minResult.getMin().getValue().getDouble(), 0.001);
     * Tests min aggregation via gRPC.  
     */
            SearchRequestBody requestBody = SearchRequestBody.newBuilder()
        }
            SearchRequestBody requestBody = SearchRequestBody.newBuilder()
import org.opensearch.protobufs.services.SearchServiceGrpc;  
        indexTestDocument(indexName, "1", DEFAULT_DOCUMENT_SOURCE);
            // Buckets are returned in descending doc count order  
            StringTermsAggregate sterms = termsResult.getSterms();
     */  
        createTestIndex(indexName);  
            // Execute search  
                .putAggregations("min_price", AggregationContainer.newBuilder().setMin(minAgg).build())
import org.opensearch.protobufs.MinAggregation;
                .setQ("field1:value1")  
                .build();
 *
            SearchServiceGrpc.SearchServiceBlockingStub searchStub = SearchServiceGrpc.newBlockingStub(channel);
        // Add a document to the index  
        createTestIndex(indexName);  
            assertTrue("Create PIT response should have shard stats", response.hasXShards());
            assertNotNull("Min aggregation should exist", minResult);
     * Tests the search operation via gRPC.
            // Verify max aggregation result  
            // Verify min aggregation result  
            // Execute search  
import org.opensearch.protobufs.StringTermsAggregate;  
    }  
            SearchServiceGrpc.SearchServiceBlockingStub searchStub = SearchServiceGrpc.newBlockingStub(channel);
 */
        try (NettyGrpcClient client = createGrpcClient()) {
    public void testDeletePit() throws Exception {
import org.opensearch.transport.grpc.ssl.NettyGrpcClient;
    /**
        try (NettyGrpcClient client = createGrpcClient()) {
            assertEquals("Search response should have one hit", 1, searchResponse.getHits().getHitsCount());  
}
            assertEquals("Hit should have correct ID", "1", searchResponse.getHits().getHits(0).getXId());
            assertTrue("Total shards should be positive", response.getXShards().getTotal() > 0);
            assertNotNull("Terms aggregation should exist", termsResult);
            SearchRequest searchRequest = SearchRequest.newBuilder().addIndex(indexName).setSearchRequestBody(requestBody).build();
            // Build min aggregation request
            SearchRequestBody requestBody = SearchRequestBody.newBuilder().setFrom(0).setSize(10).build();
import org.opensearch.protobufs.Aggregate;
            assertTrue("Should have min", minResult.hasMin());
import org.opensearch.protobufs.SearchResponse;
import org.opensearch.protobufs.TermsAggregationFields;
        createTestIndex(indexName);
import org.opensearch.protobufs.CreatePITResponse;  
    public void testCreatePit() throws Exception {
        String indexName = "test-create-pit";
            Aggregate minResult = response.getAggregationsMap().get("min_price");  
                .build();
            assertEquals("sum_other_doc_count should be 0", 0, sterms.getSumOtherDocCount());
            SearchServiceGrpc.SearchServiceBlockingStub searchStub = SearchServiceGrpc.newBlockingStub(channel);  
            assertTrue("Search response should have hits", searchResponse.getHits().getTotal().getTotalHits().getValue() > 0);
            SearchServiceGrpc.SearchServiceBlockingStub searchStub = SearchServiceGrpc.newBlockingStub(channel);
import org.opensearch.protobufs.AggregationContainer;
            Aggregate maxResult = response.getAggregationsMap().get("max_price");  
            assertTrue("Should have aggregations", response.getAggregationsCount() > 0);
        try (NettyGrpcClient client = createGrpcClient()) {  
        indexTestDocument(indexName, "3", "{\"price\": 5.2}");
        indexTestDocument(indexName, "2", "{\"status\": \"active\"}");
                .putAggregations("status_terms", AggregationContainer.newBuilder().setTermsAggregation(termsAgg).build())
            CreatePITResponse response = searchStub.createPit(request);
        indexTestDocument(indexName, "3", "{\"price\": 5.2}");
            assertEquals("doc_count_error_upper_bound should be 0", 0, sterms.getDocCountErrorUpperBound());  
            SearchRequest searchRequest = SearchRequest.newBuilder()  
 * The OpenSearch Contributors require contributions made to  
            // Verify response structure
     */
package org.opensearch.transport.grpc;
        // Create a test index
            assertNotNull("Search response should not be null", response);
        // Index documents with two distinct status values  
            TermsAggregation termsAgg = TermsAggregation.newBuilder()
                .build();
import io.grpc.ManagedChannel;  
                .setSearchRequestBody(requestBody)
            assertEquals("Failed shards should be zero", 0, response.getXShards().getFailed());
            assertEquals("Second bucket doc count should be 1", 1, sterms.getBuckets(1).getDocCount());
            DeletePitRequest deleteRequest = DeletePitRequest.newBuilder().addPitId(createResponse.getPitId()).build();  
 * compatible open source license.
 */  
     * Tests terms aggregation on a keyword field via gRPC.  
            assertEquals("Second bucket key should be 'inactive'", "inactive", sterms.getBuckets(1).getKey());  
            ManagedChannel channel = client.getChannel();  
            assertNotNull("Max aggregation should exist", maxResult);
    /**
            SearchRequest searchRequest = SearchRequest.newBuilder().addIndex(indexName).setSearchRequestBody(requestBody).build();
 * SPDX-License-Identifier: Apache-2.0
    }  
        // Create a gRPC client  
            assertTrue("Successful shards should be positive", response.getXShards().getSuccessful() > 0);  
        try (NettyGrpcClient client = createGrpcClient()) {
        createTestIndex(indexName);
        }
