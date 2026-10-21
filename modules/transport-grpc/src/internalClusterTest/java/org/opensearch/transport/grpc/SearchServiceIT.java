            assertTrue("Should have aggregations", response.getAggregationsCount() > 0);
                .build();
import org.opensearch.protobufs.MaxAggregation;
import org.opensearch.protobufs.SearchRequest;
        indexTestDocument(indexName, "1", "{\"status\": \"active\"}");
            ManagedChannel channel = client.getChannel();
            assertTrue("Successful shards should be positive", response.getXShards().getSuccessful() > 0);
import org.opensearch.protobufs.CreatePitRequest;
import org.opensearch.protobufs.StringTermsAggregate;
            ManagedChannel channel = client.getChannel();
            SearchServiceGrpc.SearchServiceBlockingStub searchStub = SearchServiceGrpc.newBlockingStub(channel);
            assertEquals("Max value should be 25.0", 25.0, maxResult.getMax().getValue().getDouble(), 0.001);
        try (NettyGrpcClient client = createGrpcClient()) {
        indexTestDocument(indexName, "3", "{\"price\": 5.2}");
        // Create a test index
    /**
 * SPDX-License-Identifier: Apache-2.0
            // Execute search
    }
            StringTermsAggregate sterms = termsResult.getSterms();
        }
            // Build min aggregation request
        indexTestDocument(indexName, "1", "{\"price\": 10.5}");
     * Tests terms aggregation on a keyword field via gRPC.
                .putAggregations("min_price", AggregationContainer.newBuilder().setMin(minAgg).build())
            SearchServiceGrpc.SearchServiceBlockingStub searchStub = SearchServiceGrpc.newBlockingStub(channel);
            ManagedChannel channel = client.getChannel();
                .build();
            assertTrue("Should have value", maxResult.getMax().hasValue());
     */
 * The OpenSearch Contributors require contributions made to
     */
            assertEquals("Search response should have one hit", 1, searchResponse.getHits().getHitsCount());
                .setSearchRequestBody(requestBody)
        // Create a test index
/**
        // Create a gRPC client
        }
        indexTestDocument(indexName, "1", "{\"price\": 10.5}");
        // Index documents with two distinct status values
import org.opensearch.protobufs.TermsAggregationFields;
            assertEquals("Deleted PIT id should match", response.getPitId(), deleteResponse.getPits(0).getPitId());
            assertTrue("Delete PIT should be successful", deleteResponse.getPits(0).getSuccessful());
import org.opensearch.protobufs.AggregationContainer;
            // Execute the search request
            // Create a search request
                .build();
    public void testTermsAggregation() throws Exception {
            SearchRequest searchRequest = SearchRequest.newBuilder()
            assertEquals("Deleted PIT id should match", createResponse.getPitId(), deleteResponse.getPits(0).getPitId());
        try (NettyGrpcClient client = createGrpcClient()) {
 */
            assertTrue("Should have max", maxResult.hasMax());
        // Index documents with different price values
        indexTestDocument(indexName, "2", "{\"price\": 25.0}");
                CreatePitRequest.newBuilder().addIndex(indexName).setKeepAlive("1m").build()
import org.opensearch.protobufs.SearchRequestBody;
            CreatePITResponse response = searchStub.createPit(request);
            SearchResponse searchResponse = searchStub.search(searchRequest);
    }
            CreatePitRequest request = CreatePitRequest.newBuilder().addIndex(indexName).setKeepAlive("1m").build();
        String indexName = "test-delete-pit";
            SearchServiceGrpc.SearchServiceBlockingStub searchStub = SearchServiceGrpc.newBlockingStub(channel);
            assertEquals("Second bucket doc count should be 1", 1, sterms.getBuckets(1).getDocCount());
import io.grpc.ManagedChannel;
            assertTrue("Should have value", minResult.getMin().hasValue());
        // Index documents with different price values
        indexTestDocument(indexName, "1", DEFAULT_DOCUMENT_SOURCE);
     * Tests PIT deletion via gRPC.
            assertTrue("Should have min", minResult.hasMin());
    public void testCreatePit() throws Exception {
package org.opensearch.transport.grpc;
            assertTrue("Create PIT response should have shard stats", response.hasXShards());
            assertEquals("doc_count_error_upper_bound should be 0", 0, sterms.getDocCountErrorUpperBound());
            DeletePITResponse deleteResponse = searchStub.deletePit(deleteRequest);
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    /**
     */
import org.opensearch.protobufs.SearchResponse;
     */
            assertTrue("Should have aggregations", response.getAggregationsCount() > 0);
            assertTrue("Should have aggregations", response.getAggregationsCount() > 0);
}
        createTestIndex(indexName);
    public void testMinAggregation() throws Exception {
            assertTrue("Total shards should be positive", response.getXShards().getTotal() > 0);
                .addIndex(indexName)
            ManagedChannel channel = client.getChannel();
import org.opensearch.protobufs.MinAggregation;
import org.opensearch.protobufs.Aggregate;
            SearchServiceGrpc.SearchServiceBlockingStub searchStub = SearchServiceGrpc.newBlockingStub(channel);
        // Add a document to the index
                .putAggregations("max_price", AggregationContainer.newBuilder().setMax(maxAgg).build())
            SearchRequestBody requestBody = SearchRequestBody.newBuilder()
import org.opensearch.protobufs.DeletePITResponse;
    }
            assertNotNull("Search response should not be null", response);
        indexTestDocument(indexName, "3", "{\"status\": \"inactive\"}");
            assertEquals("Hit should have correct ID", "1", searchResponse.getHits().getHits(0).getXId());
            SearchServiceGrpc.SearchServiceBlockingStub searchStub = SearchServiceGrpc.newBlockingStub(channel);
            assertTrue("Creation time should be positive", response.getCreationTime() > 0);
            assertEquals("Should have two buckets", 2, sterms.getBucketsCount());
            SearchResponse response = searchStub.search(searchRequest);
            MaxAggregation maxAgg = MaxAggregation.newBuilder().setField("price").build();
        indexTestDocument(indexName, "2", "{\"status\": \"active\"}");
     */
            // Build max aggregation request
                .setQ("field1:value1")
            Aggregate termsResult = response.getAggregationsMap().get("status_terms");
            MinAggregation minAgg = MinAggregation.newBuilder().setField("price").build();
        String indexName = "test-create-pit";
    }
            assertFalse("PIT id should not be empty", response.getPitId().isEmpty());
        }
    public void testDeletePit() throws Exception {
            assertEquals("Failed shards should be zero", 0, response.getXShards().getFailed());
            DeletePitRequest deleteRequest = DeletePitRequest.newBuilder().addPitId(createResponse.getPitId()).build();
            SearchRequest searchRequest = SearchRequest.newBuilder().addIndex(indexName).setSearchRequestBody(requestBody).build();
        createTestIndex(indexName);
            SearchRequestBody requestBody = SearchRequestBody.newBuilder().setFrom(0).setSize(10).build();
        }
    /**
        // Create a gRPC client
        String indexName = "test-terms-agg-it";
                .setSize(0)
            assertNotNull("Min aggregation should exist", minResult);
        try (NettyGrpcClient client = createGrpcClient()) {
            SearchResponse response = searchStub.search(searchRequest);
            CreatePITResponse createResponse = searchStub.createPit(
            SearchServiceGrpc.SearchServiceBlockingStub searchStub = SearchServiceGrpc.newBlockingStub(channel);
                .setTerms(TermsAggregationFields.newBuilder().setField("status.keyword").build())
            assertEquals("Should have one delete result", 1, deleteResponse.getPitsCount());
    public void testSearchServiceSearch() throws Exception {
        indexTestDocument(indexName, "3", "{\"price\": 5.2}");
            // Verify the response
            assertNotNull("Search response should not be null", response);
            assertNotNull("Terms aggregation should exist", termsResult);
            assertEquals("sum_other_doc_count should be 0", 0, sterms.getSumOtherDocCount());
        try (NettyGrpcClient client = createGrpcClient()) {
    /**
            // Buckets are returned in descending doc count order
        try (NettyGrpcClient client = createGrpcClient()) {
import org.opensearch.protobufs.CreatePITResponse;
                .setSize(0)
            assertFalse("PIT id should not be empty", createResponse.getPitId().isEmpty());
import org.opensearch.protobufs.services.SearchServiceGrpc;
        createTestIndex(indexName);
            // Verify min aggregation result
            assertEquals("Should have one delete result", 1, deleteResponse.getPitsCount());
            // Create a SearchService stub
            assertEquals("First bucket doc count should be 2", 2, sterms.getBuckets(0).getDocCount());
    public void testMaxAggregation() throws Exception {
            ManagedChannel channel = client.getChannel();
            assertTrue("Should be a string terms (sterms) aggregate", termsResult.hasSterms());
     * Tests PIT creation via gRPC.
     * Tests the search operation via gRPC.
 */
     * Tests min aggregation via gRPC.
                .putAggregations("status_terms", AggregationContainer.newBuilder().setTermsAggregation(termsAgg).build())
            assertNotNull("Search response should not be null", response);
            assertEquals("First bucket key should be 'active'", "active", sterms.getBuckets(0).getKey());
import org.opensearch.protobufs.DeletePitRequest;
        // Create a test index
            assertEquals("Second bucket key should be 'inactive'", "inactive", sterms.getBuckets(1).getKey());
     */
                .build();
            // Verify response structure
            // Verify max aggregation result
        createTestIndex(indexName);
    /**
            ManagedChannel channel = client.getChannel();
            assertNotNull("Search response should not be null", searchResponse);
        indexTestDocument(indexName, "1", DEFAULT_DOCUMENT_SOURCE);
            SearchResponse response = searchStub.search(searchRequest);
        try (NettyGrpcClient client = createGrpcClient()) {
 * Integration tests for the SearchService gRPC service.
import org.opensearch.protobufs.TermsAggregation;
            assertNotNull("Create PIT response should not be null", response);
            assertNotNull("Delete PIT response should not be null", deleteResponse);
            SearchRequest searchRequest = SearchRequest.newBuilder().addIndex(indexName).setSearchRequestBody(requestBody).build();
        }
        createTestIndex(indexName);
            assertTrue("Search response should have hits", searchResponse.getHits().getTotal().getTotalHits().getValue() > 0);
            // Execute search
            );
        indexTestDocument(indexName, "2", "{\"price\": 25.0}");
public class SearchServiceIT extends GrpcTransportBaseIT {
        indexTestDocument(indexName, "1", DEFAULT_DOCUMENT_SOURCE);
    /**
            assertTrue("Delete PIT should be successful", deleteResponse.getPits(0).getSuccessful());
            assertEquals("Min value should be 5.2", 5.2, minResult.getMin().getValue().getDouble(), 0.001);
        String indexName = "test-min-agg";
        String indexName = "test-max-agg";
            SearchRequestBody requestBody = SearchRequestBody.newBuilder()
        createTestIndex(indexName);
            Aggregate minResult = response.getAggregationsMap().get("min_price");
            DeletePITResponse deleteResponse = searchStub.deletePit(DeletePitRequest.newBuilder().addPitId(response.getPitId()).build());
/*
    }
import org.opensearch.transport.grpc.ssl.NettyGrpcClient;
                .build();
                .setSize(0)
            TermsAggregation termsAgg = TermsAggregation.newBuilder()
    }
     * Tests max aggregation via gRPC.
            SearchRequestBody requestBody = SearchRequestBody.newBuilder()
        // Create a gRPC client
 *
        String indexName = "test-search-index";
            Aggregate maxResult = response.getAggregationsMap().get("max_price");
            // Build terms aggregation request on the status keyword field
        }
            assertNotNull("Max aggregation should exist", maxResult);
            SearchRequest searchRequest = SearchRequest.newBuilder().addIndex(indexName).setSearchRequestBody(requestBody).build();
