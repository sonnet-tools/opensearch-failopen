        when(mockResponse.getProfileResults()).thenReturn(null);
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));
        assertFalse("Should not have status", protoDetail.hasStatus());
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();
        List<org.opensearch.search.aggregations.InternalAggregation> aggsList = new ArrayList<>();
        when(mockResponse.getInternalResponse()).thenReturn(mockSections);
        org.opensearch.search.aggregations.InternalAggregations aggregations = org.opensearch.search.aggregations.InternalAggregations.from(
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
        when(mockResponse.getTotalShards()).thenReturn(5);
        );
        assertEquals("ext builder responses are not supported yet", exception.getMessage());
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));
        org.opensearch.protobufs.SearchResponse protoResponse = builder.build();
        when(mockResponse.getAggregations()).thenReturn(null);
        when(mockResponse.getProfileResults()).thenReturn(null);
        // Verify aggregations are present
        assertTrue("Should have input data", protoDetail1.hasInputData());
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
        // Verify Min aggregation
        // Call the method under test - should throw UnsupportedOperationException
        assertEquals("Should have 0 processor results", 0, protoResponse.getProcessorResultsCount());
        List<ProcessorExecutionDetail> processorResults = new ArrayList<>();
        when(mockResponse.getSkippedShards()).thenReturn(0);
        SearchResponseSections mockSections = mock(SearchResponseSections.class);
        );
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
        SearchResponse mockResponse = mock(SearchResponse.class);
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
        assertFalse("Should not have processor name", protoDetail.hasProcessorName());
        when(mockSections.getProcessorResult()).thenReturn(null);
        ProcessorExecutionDetail detail = new ProcessorExecutionDetail(
        assertEquals("Duration should match", 100L, protoDetail.getDurationMillis());
            UnsupportedOperationException.class,
        when(mockSections.getSearchExtBuilders()).thenReturn(new ArrayList<>());
        // Create mock SearchResponseSections
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
        when(mockResponse.getSkippedShards()).thenReturn(0);
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
        when(mockResponse.getAggregations()).thenReturn(aggregations);
            ProcessorExecutionDetail.ProcessorStatus.SUCCESS,
        when(minAgg.getFormat()).thenReturn(org.opensearch.search.DocValueFormat.RAW);
        when(mockResponse.isTimedOut()).thenReturn(false);
        assertEquals("Error message should match", "Error message", protoDetail2.getError());
            "processor2",
        when(mockResponse.getTotalShards()).thenReturn(5);
        // Create processor execution details
        inputData1.put("key1", "value1");
        assertTrue("Min value should be double", minAggregate.getMin().getValue().hasDouble());
import static org.mockito.Mockito.mock;
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
        when(mockResponse.getProfileResults()).thenReturn(null);
        assertTrue("Max should have max set", maxAggregate.hasMax());
        when(maxAgg.getMetadata()).thenReturn(Collections.emptyMap());
        SearchResponse mockResponse = mock(SearchResponse.class);
        assertFalse("Should not have error", protoDetail1.hasError());
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
            "processor1",
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
    public void testToProtoThrowsUnsupportedOperationExceptionForProfileResults() {
        when(mockResponse.getAggregations()).thenReturn(null);
import java.io.IOException;
        when(minAgg.getName()).thenReturn("min_price");
        Map<String, Object> inputData1 = new HashMap<>();
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
import java.util.Map;
        org.opensearch.protobufs.Aggregate maxAggregate = protoResponse.getAggregationsOrThrow("max_price");
        when(mockResponse.getSuggest()).thenReturn(null);
        assertEquals("Tag should match", "tag1", protoDetail1.getTag());
        SearchResponseSections mockSections = mock(SearchResponseSections.class);
        assertTrue("Min should have min set", minAggregate.hasMin());
        when(mockResponse.getTotalShards()).thenReturn(5);
    }
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
        // Create mock SearchResponseSections
        when(mockResponse.isTimedOut()).thenReturn(false);
            null,
        SearchResponseSectionsProtoUtils.toProto(builder, mockResponse, aggregateRegistry);
        assertEquals("Duration should match", 100L, protoDetail.getDurationMillis());
        // Create mock SearchResponse
        when(mockResponse.isTimedOut()).thenReturn(false);
        SearchResponseSections mockSections = mock(SearchResponseSections.class);
        assertEquals("Should have 1 processor result", 1, protoResponse.getProcessorResultsCount());
        // Call the method under test - should throw UnsupportedOperationException
    }
        // Create mock SearchResponse
        // Call the method under test
        SearchResponseSectionsProtoUtils.toProto(builder, mockResponse, aggregateRegistry);
        // Create mock SearchResponseSections with empty processor results
        // Create mock SearchResponse
import org.opensearch.transport.grpc.proto.response.search.aggregation.AggregateProtoConverterRegistryImpl;
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
        org.opensearch.protobufs.SearchResponse protoResponse = builder.build();
        assertFalse("Should not have output data", protoDetail.hasOutputData());
        org.opensearch.protobufs.ProcessorExecutionDetail protoDetail = protoResponse.getProcessorResults(0);
        assertEquals("Should have 1 processor result", 1, protoResponse.getProcessorResultsCount());
        when(mockResponse.getInternalResponse()).thenReturn(mock(SearchResponseSections.class));
        when(mockSections.getProcessorResult()).thenReturn(processorResults);
        when(mockResponse.getInternalResponse()).thenReturn(mockSections);
        SearchResponseSectionsProtoUtils.toProto(builder, mockResponse, aggregateRegistry);
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();
        when(mockResponse.getSuggest()).thenReturn(null);
        );
        when(mockResponse.getAggregations()).thenReturn(null);
        assertNotNull("Proto response should not be null", protoResponse);
        when(mockResponse.getAggregations()).thenReturn(null);
        assertEquals("Max value should be 9999.0", 9999.0, maxAggregate.getMax().getValue().getDouble(), 0.001);
        when(mockResponse.getInternalResponse()).thenReturn(mockSections);
    }
        assertEquals("Processor name should match", "processor1", protoDetail.getProcessorName());
            outputData1,
            "processor1",
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
            100L,
        assertEquals("Duration should match", 100L, protoDetail.getDurationMillis());
            ProcessorExecutionDetail.ProcessorStatus.SUCCESS,
        // Create InternalAggregations with our mocked aggregations
        );
        // Call the method under test
        org.opensearch.protobufs.SearchResponse protoResponse = builder.build();
        assertEquals("Should have 2 processor results", 2, protoResponse.getProcessorResultsCount());
        when(mockResponse.getTotalShards()).thenReturn(5);
        List<ProcessorExecutionDetail> processorResults = new ArrayList<>();
    private final AggregateProtoConverterRegistry aggregateRegistry = new AggregateProtoConverterRegistryImpl();
            null,
        // Verify processor result - null status should not be set
        SearchResponseSections mockSections = mock(SearchResponseSections.class);
    }
        when(mockResponse.getAggregations()).thenReturn(null);
            null,
        // Call the method under test
        org.opensearch.protobufs.ProcessorExecutionDetail protoDetail2 = protoResponse.getProcessorResults(1);
import org.opensearch.action.search.SearchResponse;
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));
        SearchResponseSectionsProtoUtils.toProto(builder, mockResponse, aggregateRegistry);
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
        // Verify no processor results
        );
        when(mockResponse.getTotalShards()).thenReturn(5);
        when(mockResponse.getProfileResults()).thenReturn(null);
        when(mockResponse.isTimedOut()).thenReturn(false);
        SearchResponse mockResponse = mock(SearchResponse.class);
        when(mockResponse.getSuggest()).thenReturn(null);
    public void testToProtoWithProcessorResultNullProcessorName() throws IOException {
        org.opensearch.search.aggregations.metrics.InternalMin minAgg = mock(org.opensearch.search.aggregations.metrics.InternalMin.class);
        // Call the method under test
        when(mockResponse.isTimedOut()).thenReturn(false);
        SearchResponseSectionsProtoUtils.toProto(builder, mockResponse, aggregateRegistry);
        when(mockResponse.getFailedShards()).thenReturn(0);
        SearchResponse mockResponse = mock(SearchResponse.class);
        when(mockResponse.getInternalResponse()).thenReturn(mockSections);
        when(mockSections.getSearchExtBuilders()).thenReturn(new ArrayList<>());
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();
        when(mockSections.getSearchExtBuilders()).thenReturn(new ArrayList<>());
        when(mockResponse.getSkippedShards()).thenReturn(0);
        when(mockResponse.getProfileResults()).thenReturn(profileResults);
            100L,
        when(mockResponse.getFailedShards()).thenReturn(0);
        when(mockResponse.getSuggest()).thenReturn(null);
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();
            () -> SearchResponseSectionsProtoUtils.toProto(builder, mockResponse, aggregateRegistry)
        when(mockSections.getSearchExtBuilders()).thenReturn(extBuilders);
        SearchResponse mockResponse = mock(SearchResponse.class);
        assertTrue("Max value should be double", maxAggregate.getMax().getValue().hasDouble());
    public void testToProtoThrowsUnsupportedOperationExceptionForSuggest() {
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));
        assertEquals("Processor name should match", "processor1", protoDetail1.getProcessorName());
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
        when(mockResponse.getSkippedShards()).thenReturn(0);
        SearchResponse mockResponse = mock(SearchResponse.class);
        SearchResponseSections mockSections = mock(SearchResponseSections.class);
        processorResults.add(detail2);
        when(mockResponse.getAggregations()).thenReturn(null);
    public void testToProtoWithNullProcessorResults() throws IOException {
/*
        // Verify Max aggregation
        SearchResponse mockResponse = mock(SearchResponse.class);
        SearchResponse mockResponse = mock(SearchResponse.class);
        org.opensearch.protobufs.Aggregate minAggregate = protoResponse.getAggregationsOrThrow("min_price");
        when(mockResponse.getTotalShards()).thenReturn(5);
        when(mockResponse.getInternalResponse()).thenReturn(mockSections);
    public void testToProtoThrowsUnsupportedOperationExceptionForSearchExtBuilders() {
        when(mockResponse.getSkippedShards()).thenReturn(0);
        SearchResponseSections mockSections = mock(SearchResponseSections.class);
        org.opensearch.protobufs.SearchResponse protoResponse = builder.build();
        // Create mock SearchResponseSections
        // Call the method under test
        when(minAgg.getMetadata()).thenReturn(Collections.emptyMap());
        when(mockResponse.getSkippedShards()).thenReturn(0);
        // Create mock SearchResponse with profile results
        // Create mock SearchResponseSections
            null,
            "tag1"
        // Create mock SearchResponseSections with null processor results
    }
        SearchResponseSections mockSections = mock(SearchResponseSections.class);
        // Verify processor results
        // Call the method under test
        org.opensearch.protobufs.ProcessorExecutionDetail protoDetail1 = protoResponse.getProcessorResults(0);
package org.opensearch.transport.grpc.proto.response.search;
 * SPDX-License-Identifier: Apache-2.0
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));
 * compatible open source license.
        when(maxAgg.getName()).thenReturn("max_price");
        org.opensearch.protobufs.ProcessorExecutionDetail protoDetail = protoResponse.getProcessorResults(0);
            null
        assertNotNull("Proto response should not be null", protoResponse);
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
        org.opensearch.protobufs.SearchResponse protoResponse = builder.build();
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();
    }
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));
        SearchResponseSections mockSections = mock(SearchResponseSections.class);
        when(minAgg.getValue()).thenReturn(-50.0);
        when(mockSections.getSearchExtBuilders()).thenReturn(new ArrayList<>());
            UnsupportedOperationException.class,
        when(mockResponse.getSuggest()).thenReturn(mock(org.opensearch.search.suggest.Suggest.class));
    public void testToProtoWithNullAggregations() throws IOException {
import org.opensearch.test.OpenSearchTestCase;
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
        when(mockResponse.getFailedShards()).thenReturn(0);
            ProcessorExecutionDetail.ProcessorStatus.FAIL,
    }
            100L,
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();
    }
        when(mockResponse.getFailedShards()).thenReturn(0);
        processorResults.add(detail);
import org.opensearch.search.pipeline.ProcessorExecutionDetail;
        // Call the method under test
}
        ProcessorExecutionDetail detail1 = new ProcessorExecutionDetail(
        assertEquals("Should have 1 processor result", 1, protoResponse.getProcessorResultsCount());
        // Create processor execution detail with null processor name
        List<ProcessorExecutionDetail> processorResults = new ArrayList<>();
 * this file be licensed under the Apache-2.0 license or a
        // Create mock SearchResponse with aggregations
            aggsList
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();
        // Call the method under test
        profileResults.put("shard1", mock(org.opensearch.search.profile.ProfileShardResult.class));
        UnsupportedOperationException exception = expectThrows(
        when(mockResponse.isTimedOut()).thenReturn(false);
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
        ProcessorExecutionDetail detail = new ProcessorExecutionDetail(
        assertTrue("Should contain max_price aggregation", protoResponse.containsAggregations("max_price"));
        org.opensearch.search.aggregations.metrics.InternalMax maxAgg = mock(org.opensearch.search.aggregations.metrics.InternalMax.class);
        outputData1.put("result", "success");
        when(maxAgg.getValue()).thenReturn(9999.0);
        );
        assertEquals("Duration should match", 100L, protoDetail1.getDurationMillis());
        SearchResponseSectionsProtoUtils.toProto(builder, mockResponse, aggregateRegistry);
import java.util.List;
    public void testToProtoWithProcessorResults() throws IOException {
        assertEquals("Should have 2 aggregations", 2, protoResponse.getAggregationsCount());
        // Create mock Min aggregation
        assertTrue("Should have output data", protoDetail1.hasOutputData());
        when(maxAgg.getFormat()).thenReturn(org.opensearch.search.DocValueFormat.RAW);
        assertFalse("Should not have tag", protoDetail.hasTag());
        SearchResponse mockResponse = mock(SearchResponse.class);
    public void testToProtoWithEmptyProcessorResults() throws IOException {
        when(mockResponse.getSkippedShards()).thenReturn(0);
        assertEquals("Status should match", "fail", protoDetail2.getStatus());
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
import org.opensearch.search.SearchHits;
        // Create mock SearchResponseSections
        // Create mock SearchResponse
        when(mockResponse.getFailedShards()).thenReturn(0);
        processorResults.add(detail);
import java.util.ArrayList;
        SearchResponseSectionsProtoUtils.toProto(builder, mockResponse, aggregateRegistry);
        when(mockResponse.getInternalResponse()).thenReturn(mockSections);
        when(mockSections.getSearchExtBuilders()).thenReturn(new ArrayList<>());
        // Create mock SearchResponse without aggregations
        when(mockSections.getProcessorResult()).thenReturn(new ArrayList<>());
    }
import java.util.Collections;
        // Verify processor result - null processor name should not be set
        when(mockResponse.getInternalResponse()).thenReturn(mockSections);
        when(mockSections.getProcessorResult()).thenReturn(processorResults);
            null,
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();
        // Create processor execution detail with null status
        org.opensearch.protobufs.SearchResponse protoResponse = builder.build();
    public void testToProtoWithProcessorResultNullFields() throws IOException {
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
            () -> SearchResponseSectionsProtoUtils.toProto(builder, mockResponse, aggregateRegistry)
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
        // Create processor execution detail with null fields
        assertEquals("Should have 0 aggregations", 0, protoResponse.getAggregationsCount());
        SearchResponse mockResponse = mock(SearchResponse.class);
        when(mockSections.getProcessorResult()).thenReturn(processorResults);
            UnsupportedOperationException.class,
        when(mockSections.getProcessorResult()).thenReturn(new ArrayList<>());
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();
        org.opensearch.protobufs.SearchResponse protoResponse = builder.build();
            "Error message",
        when(mockResponse.isTimedOut()).thenReturn(false);
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
        assertEquals("profile results are not supported yet", exception.getMessage());
        // Create mock SearchResponse with suggest
        when(mockResponse.getSuggest()).thenReturn(null);
        when(mockResponse.getAggregations()).thenReturn(null);
        assertEquals("Min value should be -50.0", -50.0, minAggregate.getMin().getValue().getDouble(), 0.001);
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
        );
        // Create mock Max aggregation
        assertFalse("Should not have error", protoDetail.hasError());
        when(mockResponse.getProfileResults()).thenReturn(null);
        when(mockResponse.getFailedShards()).thenReturn(0);
        // Create mock SearchResponseSections with search ext builders
        assertEquals("suggest responses are not supported yet", exception.getMessage());
        // Create mock SearchResponse
        org.opensearch.protobufs.ProcessorExecutionDetail protoDetail = protoResponse.getProcessorResults(0);
        assertEquals("Processor name should match", "processor2", protoDetail2.getProcessorName());
    public void testToProtoWithProcessorResultNullStatus() throws IOException {
import java.util.HashMap;
        when(mockResponse.getProfileResults()).thenReturn(null);
        when(mockResponse.getTotalShards()).thenReturn(5);
import org.opensearch.common.unit.TimeValue;
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
        assertFalse("Should not have tag", protoDetail2.hasTag());
        extBuilders.add(mock(org.opensearch.search.SearchExtBuilder.class));
            inputData1,
        UnsupportedOperationException exception = expectThrows(
        aggsList.add(maxAgg);
        when(mockSections.getSearchExtBuilders()).thenReturn(new ArrayList<>());
        when(mockResponse.getSuggest()).thenReturn(null);
        when(mockResponse.getProfileResults()).thenReturn(null);
        assertEquals("Should have 0 processor results", 0, protoResponse.getProcessorResultsCount());
        when(mockSections.getProcessorResult()).thenReturn(new ArrayList<>());
            null
        assertEquals("Processor name should match", "processor1", protoDetail.getProcessorName());
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
        );
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
    public void testToProtoWithAggregations() throws IOException {
            null,
        // Create mock SearchResponseSections
        when(mockResponse.getAggregations()).thenReturn(null);
public class SearchResponseSectionsProtoUtilsTests extends OpenSearchTestCase {
        // Verify no aggregations
        when(mockResponse.getFailedShards()).thenReturn(0);
        assertFalse("Should not have input data", protoDetail.hasInputData());
 *
        assertTrue("Should contain min_price aggregation", protoResponse.containsAggregations("min_price"));
            50L,
        processorResults.add(detail1);
        when(mockResponse.getFailedShards()).thenReturn(0);
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
        // Create mock SearchResponse
            null,
        SearchResponse mockResponse = mock(SearchResponse.class);
        // Call the method under test - should throw UnsupportedOperationException
        when(mockSections.getSearchExtBuilders()).thenReturn(new ArrayList<>());
        when(mockResponse.getSuggest()).thenReturn(null);
        processorResults.add(detail);
        when(mockResponse.getTotalShards()).thenReturn(5);
import static org.mockito.Mockito.when;
        assertEquals("Status should match", "success", protoDetail1.getStatus());
            null,
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));
        when(mockSections.getSearchExtBuilders()).thenReturn(new ArrayList<>());
        List<ProcessorExecutionDetail> processorResults = new ArrayList<>();
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
        when(mockResponse.getInternalResponse()).thenReturn(mock(SearchResponseSections.class));
 * The OpenSearch Contributors require contributions made to
 */
        when(mockResponse.getSuggest()).thenReturn(null);
            () -> SearchResponseSectionsProtoUtils.toProto(builder, mockResponse, aggregateRegistry)
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
        when(mockResponse.getInternalResponse()).thenReturn(mockSections);
        // Create mock SearchResponse
        SearchResponseSections mockSections = mock(SearchResponseSections.class);
            null,
        when(mockSections.getProcessorResult()).thenReturn(processorResults);
    }
            ProcessorExecutionDetail.ProcessorStatus.SUCCESS,
        Map<String, Object> outputData1 = new HashMap<>();
        org.opensearch.protobufs.SearchResponse protoResponse = builder.build();
        SearchResponseSectionsProtoUtils.toProto(builder, mockResponse, aggregateRegistry);
        List<org.opensearch.search.SearchExtBuilder> extBuilders = new ArrayList<>();
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));
import org.opensearch.action.search.SearchResponseSections;
        assertEquals("Status should match", "success", protoDetail.getStatus());
        UnsupportedOperationException exception = expectThrows(
        when(mockResponse.getSkippedShards()).thenReturn(0);
        when(mockResponse.isTimedOut()).thenReturn(false);
        Map<String, org.opensearch.search.profile.ProfileShardResult> profileResults = new HashMap<>();
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;
    }
            null,
        // Verify processor result
        assertNotNull("Proto response should not be null", protoResponse);
        inputData1.put("key2", 42);
        assertEquals("Duration should match", 50L, protoDetail2.getDurationMillis());
        aggsList.add(minAgg);
        // Verify no processor results
            null
        ProcessorExecutionDetail detail2 = new ProcessorExecutionDetail(
        ProcessorExecutionDetail detail = new ProcessorExecutionDetail("processor1", 100L, null, null, null, null, null);
import org.opensearch.action.search.ShardSearchFailure;
        when(mockResponse.getInternalResponse()).thenReturn(mockSections);
