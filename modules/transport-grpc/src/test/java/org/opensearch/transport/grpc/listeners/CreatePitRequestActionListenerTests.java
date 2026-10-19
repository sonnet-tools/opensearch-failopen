 * SPDX-License-Identifier: Apache-2.0
    @Mock
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.search.ShardSearchFailure;
        super.setUp();
    }
import static org.mockito.Mockito.verify;  
    @Override  
    }
import static org.mockito.ArgumentMatchers.any;
/*  
        listener.onFailure(new Exception("Test exception"));
        verify(responseObserver, times(1)).onCompleted();
import org.opensearch.action.search.CreatePitResponse;
        listener = new CreatePitRequestActionListener(responseObserver);
        MockitoAnnotations.openMocks(this);  
    public void setUp() throws Exception {
 *
 * The OpenSearch Contributors require contributions made to  
 */  
}  
import org.opensearch.test.OpenSearchTestCase;  
import io.grpc.StatusRuntimeException;
        CreatePitResponse response = new CreatePitResponse("pit-123", 123L, 3, 3, 0, 0, ShardSearchFailure.EMPTY_ARRAY);
import org.mockito.Mock;
    public void testOnFailure() {
    private CreatePitRequestActionListener listener;
import org.mockito.MockitoAnnotations;
        listener.onResponse(response);
import static org.mockito.Mockito.times;
    public void testOnResponse() {
    }
        verify(responseObserver, times(1)).onNext(any(org.opensearch.protobufs.CreatePITResponse.class));  
 * compatible open source license.
        verify(responseObserver, times(1)).onError(any(StatusRuntimeException.class));
    private StreamObserver<org.opensearch.protobufs.CreatePITResponse> responseObserver;
public class CreatePitRequestActionListenerTests extends OpenSearchTestCase {
import io.grpc.stub.StreamObserver;  
package org.opensearch.transport.grpc.listeners;
