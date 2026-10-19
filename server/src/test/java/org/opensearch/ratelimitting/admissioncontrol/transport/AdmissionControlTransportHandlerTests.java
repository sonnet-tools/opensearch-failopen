        AdmissionControlService admissionControlService = mock(AdmissionControlService.class);
        }
        );  
            false,
            action,
import org.opensearch.test.OpenSearchTestCase;
        }
            assertEquals(0, handler.count);
package org.opensearch.ratelimitting.admissioncontrol.transport;
            action,
        doThrow(new OpenSearchRejectedExecutionException()).when(admissionControlService).applyTransportAdmissionControl(action, null);
    public void testHandlerInvokedRejectedException() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
            admissionControlTransportHandler.messageReceived(mock(TransportRequest.class), mock(TransportChannel.class), mock(Task.class));  
        doThrow(new NullPointerException()).when(admissionControlService).applyTransportAdmissionControl(action, null);
        admissionControlTransportHandler = new AdmissionControlTransportHandler<TransportRequest>(  
    public void testHandlerInvoked() throws Exception {  
        try {
import org.opensearch.tasks.Task;  
        assertEquals(1, handler.count);
    AdmissionControlTransportHandler<TransportRequest> admissionControlTransportHandler;
        String action = "TEST";  
        admissionControlTransportHandler = new AdmissionControlTransportHandler<TransportRequest>(
        assertEquals(1, handler.count);
    }  
            null  
        AdmissionControlService admissionControlService = mock(AdmissionControlService.class);
import org.opensearch.ratelimitting.admissioncontrol.AdmissionControlService;
            null
import static org.mockito.Mockito.mock;
    }  
            admissionControlService,
        InterceptingRequestHandler<TransportRequest> handler = new InterceptingRequestHandler<>(action);  
        String action = "TEST";  
import org.opensearch.transport.TransportRequest;  
 *
/*  
        String action = "TEST";
        } catch (Exception exception) {
}
        admissionControlTransportHandler.messageReceived(mock(TransportRequest.class), mock(TransportChannel.class), mock(Task.class));
        InterceptingRequestHandler<TransportRequest> handler = new InterceptingRequestHandler<>(action);  
    public void testHandlerInvokedRandomException() throws Exception {
        admissionControlTransportHandler = new AdmissionControlTransportHandler<TransportRequest>(
import org.opensearch.transport.TransportRequestHandler;
    }  
            this.action = action;
            mock(AdmissionControlService.class),  
            handler,
        );
            this.count = 0;
            handler,  
        public InterceptingRequestHandler(String action) {  
            admissionControlService,
public class AdmissionControlTransportHandlerTests extends OpenSearchTestCase {  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            action,
            this.count = this.count + 1;
        }  
        public int count;
        @Override
        );
        InterceptingRequestHandler<TransportRequest> handler = new InterceptingRequestHandler<>(action);
        public void messageReceived(T request, TransportChannel channel, Task task) throws Exception {  
            null  
            false,
            handler.messageReceived(mock(TransportRequest.class), mock(TransportChannel.class), mock(Task.class));  
import static org.mockito.Mockito.doThrow;  
 */  
    private class InterceptingRequestHandler<T extends TransportRequest> implements TransportRequestHandler<T> {
    }  
import org.opensearch.transport.TransportChannel;
        admissionControlTransportHandler.messageReceived(mock(TransportRequest.class), mock(TransportChannel.class), mock(Task.class));
        assertEquals(0, handler.count);  
        assertEquals(1, handler.count);
            false,
 * The OpenSearch Contributors require contributions made to  
            handler,  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        private final String action;  
        handler.messageReceived(mock(TransportRequest.class), mock(TransportChannel.class), mock(Task.class));
