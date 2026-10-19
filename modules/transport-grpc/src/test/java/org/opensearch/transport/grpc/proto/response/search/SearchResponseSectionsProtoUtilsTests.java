        List<ProcessorExecutionDetail> processorResults = new ArrayList<>();
        when(mockSections.getSearchExtBuilders()).thenReturn(new ArrayList<>());
        // Call the method under test
import org.opensearch.test.OpenSearchTestCase;
        SearchResponseSectionsProtoUtils.toProto(builder, mockResponse, aggregateRegistry);
        assertNotNull("Proto response should not be null", protoResponse);
        assertEquals("Processor name should match", "processor2", protoDetail2.getProcessorName());
        // Verify Max aggregation
        org.opensearch.protobufs.Aggregate minAggregate = protoResponse.getAggregationsOrThrow("min_price");
        outputData1.put("result", "success");
        SearchResponseSections mockSections = mock(SearchResponseSections.class);  
 *
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
        ProcessorExecutionDetail detail = new ProcessorExecutionDetail(  
    public void testToProtoThrowsUnsupportedOperationExceptionForSuggest() {
        when(mockResponse.getSuccessfulShards()).thenReturn(5);  
        org.opensearch.protobufs.SearchResponse protoResponse = builder.build();
        assertEquals("Processor name should match", "processor1", protoDetail.getProcessorName());  
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
        when(mockResponse.isTimedOut()).thenReturn(false);  
 * The OpenSearch Contributors require contributions made to  
        SearchResponse mockResponse = mock(SearchResponse.class);
        // Create mock SearchResponseSections  
        when(mockSections.getProcessorResult()).thenReturn(new ArrayList<>());
 */  
        when(mockResponse.getAggregations()).thenReturn(aggregations);
        // Call the method under test  
            UnsupportedOperationException.class,  
        );  
        when(mockResponse.getSuggest()).thenReturn(null);
        when(mockResponse.getTotalShards()).thenReturn(5);
            null,
        when(mockResponse.getInternalResponse()).thenReturn(mockSections);
        when(mockResponse.getSkippedShards()).thenReturn(0);
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
            "processor2",  
        when(mockSections.getSearchExtBuilders()).thenReturn(extBuilders);
        processorResults.add(detail);  
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;  
        // Create mock SearchResponseSections with search ext builders  
        when(mockResponse.getSkippedShards()).thenReturn(0);
        when(mockResponse.getTotalShards()).thenReturn(5);
        // Call the method under test
        // Call the method under test - should throw UnsupportedOperationException  
        assertTrue("Should contain min_price aggregation", protoResponse.containsAggregations("min_price"));
        assertEquals("Should have 0 processor results", 0, protoResponse.getProcessorResultsCount());
    public void testToProtoWithAggregations() throws IOException {  
        inputData1.put("key2", 42);
        when(minAgg.getValue()).thenReturn(-50.0);
        when(mockSections.getSearchExtBuilders()).thenReturn(new ArrayList<>());  
        // Create mock SearchResponse
import org.opensearch.action.search.SearchResponseSections;
        when(mockResponse.getProfileResults()).thenReturn(null);  
        when(mockSections.getSearchExtBuilders()).thenReturn(new ArrayList<>());
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
        // Create mock SearchResponseSections
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));
            null,
            "processor1",
        ProcessorExecutionDetail detail = new ProcessorExecutionDetail("processor1", 100L, null, null, null, null, null);
    }  
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();
        org.opensearch.protobufs.SearchResponse protoResponse = builder.build();  
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));
        assertEquals("Tag should match", "tag1", protoDetail1.getTag());
        assertTrue("Should contain max_price aggregation", protoResponse.containsAggregations("max_price"));
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();  
        when(mockSections.getSearchExtBuilders()).thenReturn(new ArrayList<>());
        when(mockResponse.isTimedOut()).thenReturn(false);
    private final AggregateProtoConverterRegistry aggregateRegistry = new AggregateProtoConverterRegistryImpl();
        UnsupportedOperationException exception = expectThrows(
        ProcessorExecutionDetail detail = new ProcessorExecutionDetail(
        SearchResponse mockResponse = mock(SearchResponse.class);
        // Create processor execution details
    }  
 * this file be licensed under the Apache-2.0 license or a
        // Create mock SearchResponse  
        SearchResponseSections mockSections = mock(SearchResponseSections.class);
        SearchResponse mockResponse = mock(SearchResponse.class);
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
        assertEquals("Should have 0 processor results", 0, protoResponse.getProcessorResultsCount());
        assertEquals("Should have 1 processor result", 1, protoResponse.getProcessorResultsCount());
        when(mockResponse.getSkippedShards()).thenReturn(0);  
            null  
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
        when(maxAgg.getMetadata()).thenReturn(Collections.emptyMap());
import org.opensearch.search.pipeline.ProcessorExecutionDetail;  
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
        when(maxAgg.getValue()).thenReturn(9999.0);
        assertEquals("Duration should match", 100L, protoDetail.getDurationMillis());
        SearchResponse mockResponse = mock(SearchResponse.class);  
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
        List<ProcessorExecutionDetail> processorResults = new ArrayList<>();  
    public void testToProtoWithNullAggregations() throws IOException {
        assertEquals("Duration should match", 50L, protoDetail2.getDurationMillis());  
        // Create InternalAggregations with our mocked aggregations  
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
        aggsList.add(minAgg);
}
        // Create mock Min aggregation
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
        when(mockResponse.getSuggest()).thenReturn(null);
            "tag1"
        // Verify no processor results  
        assertEquals("Duration should match", 100L, protoDetail.getDurationMillis());
        when(mockResponse.getSkippedShards()).thenReturn(0);  
        SearchResponse mockResponse = mock(SearchResponse.class);
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
    }
        // Create mock SearchResponseSections with null processor results
            outputData1,
    }
        when(minAgg.getName()).thenReturn("min_price");  
        when(mockResponse.getInternalResponse()).thenReturn(mockSections);  
        SearchResponseSections mockSections = mock(SearchResponseSections.class);
        SearchResponseSectionsProtoUtils.toProto(builder, mockResponse, aggregateRegistry);
import java.io.IOException;
        when(mockResponse.getFailedShards()).thenReturn(0);  
        ProcessorExecutionDetail detail1 = new ProcessorExecutionDetail(  
        org.opensearch.search.aggregations.metrics.InternalMin minAgg = mock(org.opensearch.search.aggregations.metrics.InternalMin.class);
        SearchResponse mockResponse = mock(SearchResponse.class);
        when(mockSections.getProcessorResult()).thenReturn(processorResults);
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));  
            null,
            ProcessorExecutionDetail.ProcessorStatus.SUCCESS,
package org.opensearch.transport.grpc.proto.response.search;
        // Create mock SearchResponse  
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
        SearchResponse mockResponse = mock(SearchResponse.class);
import org.opensearch.common.unit.TimeValue;
        org.opensearch.protobufs.ProcessorExecutionDetail protoDetail1 = protoResponse.getProcessorResults(0);
        assertEquals("Should have 2 processor results", 2, protoResponse.getProcessorResultsCount());
        when(mockResponse.isTimedOut()).thenReturn(false);  
        org.opensearch.protobufs.SearchResponse protoResponse = builder.build();
        when(mockResponse.getTotalShards()).thenReturn(5);  
        assertNotNull("Proto response should not be null", protoResponse);
        assertTrue("Min value should be double", minAggregate.getMin().getValue().hasDouble());
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
import org.opensearch.action.search.SearchResponse;
        assertEquals("Status should match", "fail", protoDetail2.getStatus());
/*  
        // Verify no processor results
            100L,
        List<org.opensearch.search.SearchExtBuilder> extBuilders = new ArrayList<>();
        when(mockResponse.getInternalResponse()).thenReturn(mockSections);
        assertEquals("Status should match", "success", protoDetail.getStatus());
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));
            () -> SearchResponseSectionsProtoUtils.toProto(builder, mockResponse, aggregateRegistry)
        // Verify Min aggregation
            null,  
        // Call the method under test - should throw UnsupportedOperationException
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());  
        assertFalse("Should not have tag", protoDetail2.hasTag());  
        assertFalse("Should not have status", protoDetail.hasStatus());  
        processorResults.add(detail1);  
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
        when(mockResponse.getSuggest()).thenReturn(null);
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));  
        when(mockSections.getSearchExtBuilders()).thenReturn(new ArrayList<>());
            inputData1,  
        // Create mock SearchResponseSections with empty processor results
        assertEquals("Should have 1 processor result", 1, protoResponse.getProcessorResultsCount());
        when(maxAgg.getFormat()).thenReturn(org.opensearch.search.DocValueFormat.RAW);  
        assertEquals("profile results are not supported yet", exception.getMessage());
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());  
        profileResults.put("shard1", mock(org.opensearch.search.profile.ProfileShardResult.class));
            () -> SearchResponseSectionsProtoUtils.toProto(builder, mockResponse, aggregateRegistry)  
        when(mockResponse.getAggregations()).thenReturn(null);  
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
        when(mockResponse.getSuggest()).thenReturn(null);  
        when(mockSections.getSearchExtBuilders()).thenReturn(new ArrayList<>());
        assertEquals("ext builder responses are not supported yet", exception.getMessage());
        );
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);  
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();  
    }
        when(mockResponse.getTotalShards()).thenReturn(5);  
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();  
import org.opensearch.transport.grpc.proto.response.search.aggregation.AggregateProtoConverterRegistryImpl;
import java.util.ArrayList;  
        processorResults.add(detail);  
        when(mockResponse.getProfileResults()).thenReturn(null);
        assertTrue("Should have input data", protoDetail1.hasInputData());  
        when(mockSections.getSearchExtBuilders()).thenReturn(new ArrayList<>());
        SearchResponse mockResponse = mock(SearchResponse.class);
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());  
        assertTrue("Max value should be double", maxAggregate.getMax().getValue().hasDouble());
        when(mockResponse.getProfileResults()).thenReturn(null);
        when(mockResponse.getInternalResponse()).thenReturn(mockSections);  
            50L,
        // Call the method under test
        when(mockResponse.getProfileResults()).thenReturn(null);
        when(mockResponse.getFailedShards()).thenReturn(0);
        when(mockResponse.getFailedShards()).thenReturn(0);
        when(mockResponse.getFailedShards()).thenReturn(0);
        assertEquals("Processor name should match", "processor1", protoDetail.getProcessorName());
        // Verify processor result - null processor name should not be set
        assertTrue("Max should have max set", maxAggregate.hasMax());  
        when(mockSections.getProcessorResult()).thenReturn(processorResults);  
        );
        // Create mock SearchResponseSections
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();  
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());  
import java.util.HashMap;
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();
        when(mockSections.getProcessorResult()).thenReturn(new ArrayList<>());  
import static org.mockito.Mockito.when;
        when(mockResponse.getSuggest()).thenReturn(null);
            100L,
    public void testToProtoWithEmptyProcessorResults() throws IOException {  
        List<org.opensearch.search.aggregations.InternalAggregation> aggsList = new ArrayList<>();
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
        assertEquals("Should have 2 aggregations", 2, protoResponse.getAggregationsCount());  
        org.opensearch.protobufs.SearchResponse protoResponse = builder.build();
        when(mockResponse.getProfileResults()).thenReturn(null);  
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();
        when(mockResponse.getSuggest()).thenReturn(null);
        org.opensearch.protobufs.ProcessorExecutionDetail protoDetail = protoResponse.getProcessorResults(0);
        assertEquals("Max value should be 9999.0", 9999.0, maxAggregate.getMax().getValue().getDouble(), 0.001);
        when(mockResponse.getTotalShards()).thenReturn(5);
        org.opensearch.search.aggregations.metrics.InternalMax maxAgg = mock(org.opensearch.search.aggregations.metrics.InternalMax.class);  
            UnsupportedOperationException.class,
        processorResults.add(detail);
        when(mockResponse.getFailedShards()).thenReturn(0);
        when(mockResponse.getAggregations()).thenReturn(null);
        // Create processor execution detail with null status  
        );
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
        assertFalse("Should not have error", protoDetail1.hasError());
        assertEquals("Status should match", "success", protoDetail1.getStatus());
        SearchResponse mockResponse = mock(SearchResponse.class);  
        // Create mock SearchResponseSections
        // Create mock Max aggregation
        when(mockResponse.isTimedOut()).thenReturn(false);
    public void testToProtoThrowsUnsupportedOperationExceptionForSearchExtBuilders() {
        Map<String, org.opensearch.search.profile.ProfileShardResult> profileResults = new HashMap<>();
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
    }  
        // Create mock SearchResponse  
        assertTrue("Min should have min set", minAggregate.hasMin());  
        inputData1.put("key1", "value1");  
        // Create mock SearchResponseSections
        assertEquals("Processor name should match", "processor1", protoDetail1.getProcessorName());
    }  
        when(mockResponse.getSkippedShards()).thenReturn(0);  
        when(mockResponse.getAggregations()).thenReturn(null);
    public void testToProtoWithProcessorResultNullProcessorName() throws IOException {  
import static org.mockito.Mockito.mock;  
        // Verify processor result - null status should not be set
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();
        // Create processor execution detail with null fields  
            null,  
    public void testToProtoThrowsUnsupportedOperationExceptionForProfileResults() {  
        org.opensearch.protobufs.SearchResponse protoResponse = builder.build();
        // Create mock SearchResponse with aggregations
        when(mockResponse.getFailedShards()).thenReturn(0);
        when(mockResponse.getFailedShards()).thenReturn(0);  
        SearchResponseSections mockSections = mock(SearchResponseSections.class);  
        org.opensearch.protobufs.SearchResponse protoResponse = builder.build();
 * SPDX-License-Identifier: Apache-2.0
        org.opensearch.protobufs.ProcessorExecutionDetail protoDetail = protoResponse.getProcessorResults(0);  
        // Call the method under test
        // Create processor execution detail with null processor name
        // Create mock SearchResponse
        when(maxAgg.getName()).thenReturn("max_price");
        assertFalse("Should not have processor name", protoDetail.hasProcessorName());
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());
            ProcessorExecutionDetail.ProcessorStatus.FAIL,
    }
        // Call the method under test
        when(mockResponse.getAggregations()).thenReturn(null);
    }
        org.opensearch.protobufs.ProcessorExecutionDetail protoDetail = protoResponse.getProcessorResults(0);  
            null  
            null
        UnsupportedOperationException exception = expectThrows(
        when(mockSections.getProcessorResult()).thenReturn(null);
        when(mockResponse.getSkippedShards()).thenReturn(0);  
        // Verify no aggregations
        assertEquals("Duration should match", 100L, protoDetail1.getDurationMillis());  
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();
        SearchResponseSectionsProtoUtils.toProto(builder, mockResponse, aggregateRegistry);  
        org.opensearch.protobufs.SearchResponse protoResponse = builder.build();
        SearchResponseSectionsProtoUtils.toProto(builder, mockResponse, aggregateRegistry);
        when(mockResponse.getInternalResponse()).thenReturn(mockSections);
 * compatible open source license.
            aggsList
        // Create mock SearchResponse with profile results
        );
        processorResults.add(detail2);
        when(mockResponse.getSuccessfulShards()).thenReturn(5);
            "Error message",
        org.opensearch.search.aggregations.InternalAggregations aggregations = org.opensearch.search.aggregations.InternalAggregations.from(
        // Call the method under test
        // Create mock SearchResponse
        when(mockResponse.getInternalResponse()).thenReturn(mockSections);  
        when(mockResponse.getAggregations()).thenReturn(null);
        List<ProcessorExecutionDetail> processorResults = new ArrayList<>();
import java.util.List;  
            null,  
        // Verify processor results  
        when(mockResponse.getProfileResults()).thenReturn(profileResults);  
        when(mockResponse.getFailedShards()).thenReturn(0);  
        SearchResponseSections mockSections = mock(SearchResponseSections.class);
        assertTrue("Should have output data", protoDetail1.hasOutputData());
            ProcessorExecutionDetail.ProcessorStatus.SUCCESS,
        when(mockResponse.getTotalShards()).thenReturn(5);  
        when(minAgg.getMetadata()).thenReturn(Collections.emptyMap());  
        UnsupportedOperationException exception = expectThrows(
            100L,
        org.opensearch.protobufs.ProcessorExecutionDetail protoDetail2 = protoResponse.getProcessorResults(1);
        when(mockSections.getSearchExtBuilders()).thenReturn(new ArrayList<>());
        when(mockSections.getProcessorResult()).thenReturn(processorResults);
        org.opensearch.protobufs.Aggregate maxAggregate = protoResponse.getAggregationsOrThrow("max_price");
        when(mockResponse.getSuggest()).thenReturn(null);
        SearchResponse mockResponse = mock(SearchResponse.class);
        when(mockResponse.getTotalShards()).thenReturn(5);
            UnsupportedOperationException.class,
        when(mockResponse.getInternalResponse()).thenReturn(mockSections);
        List<ProcessorExecutionDetail> processorResults = new ArrayList<>();
        assertEquals("suggest responses are not supported yet", exception.getMessage());  
    public void testToProtoWithProcessorResults() throws IOException {
        SearchResponseSectionsProtoUtils.toProto(builder, mockResponse, aggregateRegistry);  
        SearchResponse mockResponse = mock(SearchResponse.class);
        assertEquals("Should have 0 aggregations", 0, protoResponse.getAggregationsCount());
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));
        when(mockResponse.getAggregations()).thenReturn(null);
            null,  
        SearchResponseSectionsProtoUtils.toProto(builder, mockResponse, aggregateRegistry);  
        aggsList.add(maxAgg);  
        assertFalse("Should not have input data", protoDetail.hasInputData());  
        when(mockResponse.getProfileResults()).thenReturn(null);  
        when(mockResponse.isTimedOut()).thenReturn(false);
        SearchResponseSectionsProtoUtils.toProto(builder, mockResponse, aggregateRegistry);
        // Create mock SearchResponseSections
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();  
        SearchResponseSections mockSections = mock(SearchResponseSections.class);  
        assertFalse("Should not have error", protoDetail.hasError());
    public void testToProtoWithProcessorResultNullStatus() throws IOException {
            null,  
        assertFalse("Should not have tag", protoDetail.hasTag());  
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));
        Map<String, Object> outputData1 = new HashMap<>();  
        // Create mock SearchResponse with suggest
        when(mockResponse.getSkippedShards()).thenReturn(0);
    public void testToProtoWithProcessorResultNullFields() throws IOException {
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
            () -> SearchResponseSectionsProtoUtils.toProto(builder, mockResponse, aggregateRegistry)  
        when(mockResponse.getInternalResponse()).thenReturn(mock(SearchResponseSections.class));
        assertEquals("Duration should match", 100L, protoDetail.getDurationMillis());
            "processor1",  
        when(mockResponse.isTimedOut()).thenReturn(false);
        ProcessorExecutionDetail detail2 = new ProcessorExecutionDetail(
        when(minAgg.getFormat()).thenReturn(org.opensearch.search.DocValueFormat.RAW);
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));  
import org.opensearch.search.SearchHits;
        when(mockResponse.getAggregations()).thenReturn(null);  
        when(mockResponse.getSuggest()).thenReturn(null);  
        when(mockResponse.getInternalResponse()).thenReturn(mock(SearchResponseSections.class));
        when(mockResponse.isTimedOut()).thenReturn(false);  
        // Create mock SearchResponse  
public class SearchResponseSectionsProtoUtilsTests extends OpenSearchTestCase {  
        when(mockSections.getProcessorResult()).thenReturn(processorResults);  
        assertEquals("Error message should match", "Error message", protoDetail2.getError());
        );
        SearchResponseSections mockSections = mock(SearchResponseSections.class);
        when(mockResponse.getInternalResponse()).thenReturn(mockSections);
        org.opensearch.protobufs.SearchResponse.Builder builder = org.opensearch.protobufs.SearchResponse.newBuilder();  
        when(mockResponse.getAggregations()).thenReturn(null);  
    public void testToProtoWithNullProcessorResults() throws IOException {
        when(mockSections.getProcessorResult()).thenReturn(new ArrayList<>());
        when(mockResponse.isTimedOut()).thenReturn(false);  
            null,
        when(mockResponse.getTook()).thenReturn(TimeValue.timeValueMillis(100));  
        // Call the method under test
        when(mockResponse.getShardFailures()).thenReturn(new ShardSearchFailure[0]);
        SearchResponseSections mockSections = mock(SearchResponseSections.class);  
        );
        SearchResponseSections mockSections = mock(SearchResponseSections.class);
        );
        Map<String, Object> inputData1 = new HashMap<>();
        assertEquals("Min value should be -50.0", -50.0, minAggregate.getMin().getValue().getDouble(), 0.001);
        SearchResponseSectionsProtoUtils.toProto(builder, mockResponse, aggregateRegistry);
        assertEquals("Should have 1 processor result", 1, protoResponse.getProcessorResultsCount());
        extBuilders.add(mock(org.opensearch.search.SearchExtBuilder.class));  
    }  
        assertNotNull("Proto response should not be null", protoResponse);  
        when(mockResponse.getClusters()).thenReturn(new SearchResponse.Clusters(0, 0, 0));  
            ProcessorExecutionDetail.ProcessorStatus.SUCCESS,
        // Verify aggregations are present
import java.util.Collections;
        when(mockResponse.getTotalShards()).thenReturn(5);
        // Create mock SearchResponse without aggregations
        // Call the method under test - should throw UnsupportedOperationException
        when(mockResponse.getHits()).thenReturn(SearchHits.empty());  
            null,
    }
        when(mockResponse.getSuggest()).thenReturn(mock(org.opensearch.search.suggest.Suggest.class));
        when(mockResponse.getSkippedShards()).thenReturn(0);
        when(mockResponse.getProfileResults()).thenReturn(null);  
        org.opensearch.protobufs.SearchResponse protoResponse = builder.build();
import org.opensearch.action.search.ShardSearchFailure;  
import java.util.Map;
        assertFalse("Should not have output data", protoDetail.hasOutputData());
        when(mockResponse.getInternalResponse()).thenReturn(mockSections);  
        // Verify processor result  
