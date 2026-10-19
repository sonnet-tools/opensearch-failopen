    }
/*  
    public void testOnFailure() {  
package org.opensearch.transport.grpc.listeners;
        verify(responseObserver, times(1)).onError(any(StatusRuntimeException.class));  
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
    @Mock  
import org.opensearch.action.search.DeletePitResponse;
import static org.mockito.ArgumentMatchers.any;  
        listener.onResponse(response);  
 */  
    private StreamObserver<org.opensearch.protobufs.DeletePITResponse> responseObserver;
    @Override
public class DeletePitRequestActionListenerTests extends OpenSearchTestCase {
        verify(responseObserver, times(1)).onCompleted();  
    private DeletePitRequestActionListener listener;  
import io.grpc.StatusRuntimeException;
import static org.mockito.Mockito.times;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        listener.onFailure(new Exception("Test exception"));
import static org.mockito.Mockito.verify;
 *
import org.mockito.Mock;  
        DeletePitResponse response = new DeletePitResponse(List.of(new DeletePitInfo(true, "pit-123")));
        super.setUp();
}
import org.opensearch.action.search.DeletePitInfo;
    }
        MockitoAnnotations.openMocks(this);
 * compatible open source license.
    public void testOnResponse() {  
import org.opensearch.test.OpenSearchTestCase;  
        listener = new DeletePitRequestActionListener(responseObserver);  
import org.mockito.MockitoAnnotations;
        verify(responseObserver, times(1)).onNext(any(org.opensearch.protobufs.DeletePITResponse.class));
    public void setUp() throws Exception {  
import io.grpc.stub.StreamObserver;
    }
