    @Override
        // Call onResponse  
import org.opensearch.action.index.IndexResponse;
}
import org.mockito.MockitoAnnotations;
import org.opensearch.action.bulk.BulkResponse;  
import io.grpc.stub.StreamObserver;  
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.action.bulk.BulkItemResponse;
        Exception exception = new IOException("Test exception");  
package org.opensearch.transport.grpc.listeners;
        // Create a successful BulkResponse
        // Verify that onNext and onCompleted were called  
import org.opensearch.test.OpenSearchTestCase;
    }
        verify(responseObserver).onError(any(Throwable.class));  
        listener.onResponse(bulkResponse);
public class BulkRequestActionListenerTests extends OpenSearchTestCase {
        indexResponse.setShardInfo(shardInfo);
        ShardId shardId = new ShardId(index, 1);
    public void testOnResponseWithException() {
        responses[0] = new BulkItemResponse(0, DocWriteRequest.OpType.INDEX, indexResponse);
    public void setUp() throws Exception {  
import org.opensearch.action.support.replication.ReplicationResponse;
import org.opensearch.core.index.Index;  
        BulkResponse bulkResponse = new BulkResponse(responses, 100);
 * The OpenSearch Contributors require contributions made to  
        BulkResponse bulkResponse = null;
    @Mock  
        // Verify that onError was called  
import static org.mockito.ArgumentMatchers.any;
        listener.onResponse(bulkResponse);
        verify(responseObserver).onError(any(Throwable.class));
 * this file be licensed under the Apache-2.0 license or a
        // Create an exception
    }  
        // Create a mock BulkResponse that will cause an exception when converted to proto  
        IndexResponse indexResponse = new IndexResponse(shardId, "test-id", 1, 1, 1, true);
        listener = new BulkRequestActionListener(responseObserver);  
    private BulkRequestActionListener listener;  
 */  
 *
        super.setUp();
    public void testOnFailure() {
    private StreamObserver<org.opensearch.protobufs.BulkResponse> responseObserver;
    }
        // Call onResponse  
        BulkItemResponse[] responses = new BulkItemResponse[1];
        Index index = new Index("test-index", "_na_");  
        verify(responseObserver).onNext(any(org.opensearch.protobufs.BulkResponse.class));
        listener.onFailure(exception);  
 * compatible open source license.
    public void testOnResponseWithSuccessfulResponse() {  
        ReplicationResponse.ShardInfo shardInfo = new ReplicationResponse.ShardInfo();  
import org.opensearch.action.DocWriteRequest;
/*  
import java.io.IOException;
        verify(responseObserver).onCompleted();
        // Call onFailure
        MockitoAnnotations.openMocks(this);
import org.mockito.Mock;
    }
import static org.mockito.Mockito.verify;
 * SPDX-License-Identifier: Apache-2.0
        // Verify that onError was called
