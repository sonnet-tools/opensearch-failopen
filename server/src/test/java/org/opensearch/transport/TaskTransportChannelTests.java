 * SPDX-License-Identifier: Apache-2.0
        delegate = mock(TransportChannel.class);
}
 * TaskTransportChannel wraps the real channel for task tracking, so it must forward the streaming  
        verify(delegate).isCancelled();
    }  
 * methods to the delegate — otherwise a task-tracked streaming action (the normal registration path)
        super.setUp();  
import static org.mockito.Mockito.when;  
        channel.sendResponseBatch(response, true);
    }  
 *
import static org.mockito.Mockito.mock;
        when(delegate.isCancelled()).thenReturn(true);  
 * can't reach them. In particular the {@code sendResponseBatch(response, sync)} and {@code isCancelled()}
import org.opensearch.test.OpenSearchTestCase;
    private TransportChannel delegate;
    public void testSyncSendResponseBatchIsForwarded() {
 * this file be licensed under the Apache-2.0 license or a
        channel.sendResponseBatch(response);
        verify(delegate).sendResponseBatch(response, true);
    public void testIsCancelledIsForwarded() {
        channel = new TaskTransportChannel(delegate, () -> {});
        verify(delegate).sendResponseBatch(response);
    private TaskTransportChannel channel;
 * compatible open source license.
import org.opensearch.core.transport.TransportResponse;
    @Override
public class TaskTransportChannelTests extends OpenSearchTestCase {
 */
 * The OpenSearch Contributors require contributions made to  
 */  
package org.opensearch.transport;
    public void testAsyncSendResponseBatchIsForwarded() {
 * calls must land on the wrapped channel, not on the base default (which no-ops / throws).  
        TransportResponse response = mock(TransportResponse.class);  
    }  
import static org.mockito.Mockito.verify;
/**
/*  
        TransportResponse response = mock(TransportResponse.class);  
    }  
    public void setUp() throws Exception {
        assertTrue(channel.isCancelled());
