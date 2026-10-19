        verify(channel).sendResponse(exception);
    }
 * compatible open source license.
    @Mock
        }
import org.opensearch.transport.TransportRequest;  
        verify(channel).sendResponseBatch(response);
import org.junit.Before;
    }  
            if (obj == null || getClass() != obj.getClass()) return false;  
            this.data = data;  
            return data != null ? data.hashCode() : 0;
        verify(channel).sendResponseBatch(response);
     * Simple test response for testing  
        TestResponse response = new TestResponse("final");  
import org.opensearch.transport.TransportChannel;
        MockitoAnnotations.openMocks(this);  
            return data != null ? data.equals(that.data) : that.data == null;
    }
 *
        RuntimeException exception = new RuntimeException("test failure");
import org.opensearch.core.transport.TransportResponse;  
import java.io.IOException;  
public class StreamSearchChannelListenerTests extends OpenSearchTestCase {
import static org.mockito.Mockito.verify;
        verify(channel).completeStream();
        listener = new StreamSearchChannelListener<>(channel, "test-action", request);
        super.setUp();
        TestResponse response = new TestResponse("batch1");
        verify(channel).completeStream();
    private StreamSearchChannelListener<TestResponse, TransportRequest> listener;
/**
     */
        public TestResponse(String data) {
        }
    public void testStreamResponseCall() {
 * SPDX-License-Identifier: Apache-2.0
        public int hashCode() {  
        }  
 */  
    }  
 */
    private TransportRequest request;
        verifyNoMoreInteractions(channel);  
            TestResponse that = (TestResponse) obj;
    @Before  
import org.mockito.MockitoAnnotations;  
        }
        listener.onStreamResponse(response, false);  
        listener.onStreamResponse(response, true);
        }
    public void setUp() throws Exception {
        verify(channel).sendResponseBatch(response);  
        listener.onResponse(response);
import org.opensearch.test.OpenSearchTestCase;
        TestResponse response = new TestResponse("final");
        public boolean equals(Object obj) {
}
    public void testOnResponseDelegatesToCompleteResponse() {
import org.opensearch.action.support.StreamSearchChannelListener;
import org.mockito.Mock;
        @Override
        @Override
            return data;
    @Mock
    public void testFailureCall() throws Exception {
    /**
        @Override  
        listener.onFailure(exception);  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.action;
    }  
        public String getData() {  
            if (this == obj) return true;
        public void writeTo(StreamOutput out) throws IOException {
    public void testCompleteResponseCall() {  
            out.writeString(data);  
/*  
        private final String data;  
 * Tests for StreamChannelActionListener streaming functionality  
import static org.mockito.Mockito.verifyNoMoreInteractions;  
    private TransportChannel channel;
    }
    public static class TestResponse extends TransportResponse {
import org.opensearch.core.common.io.stream.StreamOutput;
 * this file be licensed under the Apache-2.0 license or a
