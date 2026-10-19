    public void setUp() throws Exception {  
import org.opensearch.transport.grpc.proto.response.search.aggregation.AggregateProtoConverterRegistryImpl;
            ShardSearchFailure.EMPTY_ARRAY,
        // Create an exception  
import org.opensearch.search.SearchHits;  
package org.opensearch.transport.grpc.listeners;
            SearchResponse.Clusters.EMPTY
import org.opensearch.action.search.SearchResponseSections;
    private final AggregateProtoConverterRegistry aggregateRegistry = new AggregateProtoConverterRegistryImpl();
public class SearchRequestActionListenerTests extends OpenSearchTestCase {  
import org.opensearch.test.OpenSearchTestCase;
    @Mock
 * this file be licensed under the Apache-2.0 license or a
    public void testOnResponse() {  
import static org.mockito.ArgumentMatchers.any;
        Exception exception = new Exception("Test exception");
        listener.onFailure(exception);
        // Create a mock StreamObserver
        // Verify that onError was called with a StatusRuntimeException  
        // Create a SearchRequestActionListener  
import static org.mockito.Mockito.mock;
        SearchResponse mockSearchResponse = new SearchResponse(  
    @Override
    private SearchRequestActionListener listener;  
}  
        verify(responseObserver, times(1)).onNext(any(org.opensearch.protobufs.SearchResponse.class));  
        verify(responseObserver, times(1)).onCompleted();
        );  
 * SPDX-License-Identifier: Apache-2.0
    private StreamObserver<org.opensearch.protobufs.SearchResponse> responseObserver;  
import org.opensearch.action.search.ShardSearchFailure;
import org.mockito.Mock;
import org.opensearch.action.search.SearchResponse;  
        @SuppressWarnings("unchecked")  
    }
    public void testOnFailure() {
    }
        listener = new SearchRequestActionListener(responseObserver, aggregateRegistry);  
            new SearchResponseSections(SearchHits.empty(), null, null, false, false, null, 1),
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;  
import io.grpc.StatusRuntimeException;
            randomAlphaOfLengthBetween(5, 10),
    }
        StreamObserver<org.opensearch.protobufs.SearchResponse> mockResponseObserver = mock(StreamObserver.class);
        MockitoAnnotations.openMocks(this);
 *
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;  
        verify(mockResponseObserver, times(1)).onError(any(StatusRuntimeException.class));
/*  
        // Call the method under test  
        // Verify that onNext and onCompleted were called
        SearchRequestActionListener listener = new SearchRequestActionListener(mockResponseObserver, aggregateRegistry);
            0,
            5,
            100,  
        // Call the method under test
 * The OpenSearch Contributors require contributions made to  
 */  
import io.grpc.stub.StreamObserver;  
 * compatible open source license.
        // Create a SearchResponse
            5,  
import org.mockito.MockitoAnnotations;
        listener.onResponse(mockSearchResponse);  
        super.setUp();
