    }
import org.opensearch.core.common.io.stream.StreamOutput;
            }  
 * SPDX-License-Identifier: Apache-2.0
        int successfulShards = 0;  
             */
            super("super-idx", randomInt(), "gone-fishing", status, new Throwable("cake"));  
        TestException(final RestStatus status) {
    public void testStatusReturns503ForUnavailableShards() {
        }
             * the greatest rest code from the failures selection  
            throw new IOException("not implemented");
        }
import java.io.IOException;
 */  
            TestException failure = new TestException(status);  
 *
            throw new IOException("not implemented");
                RestStatus deserializedStatus = RestStatus.readFrom(in);  
                assertEquals(status, deserializedStatus);
             * contract. We're not testing the contract, but if status() returns
            try (StreamInput in = out.bytes().streamInput()) {
import org.opensearch.common.io.stream.BytesStreamOutput;
        PriorityQueue<TestException> heapOfFailures = new PriorityQueue<>((x, y) -> y.status().compareTo(x.status()));  
            heapOfFailures.add(failure);  
            /*  
        final RestStatus status = heapOfFailures.peek().status();  
        }
        final RestStatus status = randomFrom(RestStatus.values());  
    }  
        @Override  
    public void testSerialization() throws IOException {
        assertEquals(RestStatus.OK, RestStatus.status(successfulShards, totalShards));
        final RestStatus expected = status.getStatusFamilyCode() == 1 ? RestStatus.OK : status;
        int totalShards = randomIntBetween(1, 100);
    }
        assertEquals(RestStatus.SERVICE_UNAVAILABLE, RestStatus.status(successfulShards, totalShards));  
        }
import org.opensearch.core.rest.RestStatus;
        int totalShards = randomIntBetween(1, 100);  
        int successfulShards = 0;
public class RestStatusTests extends OpenSearchTestCase {
        assertEquals(expected, RestStatus.status(successfulShards, totalShards, failures));
    public void testStatusReturns200ForNoFailures() {  
import org.opensearch.core.rest.StatusType;  
            RestStatus status = randomFrom(RestStatus.values());
        assertEquals(StatusType.SYSTEM_FAILURE.toString(), RestStatus.status(successfulShards, totalShards).getStatusType());
        TestException[] failures = new TestException[totalShards];
             * Status here doesn't need to convey failure and is not as per rest
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(expected.getStatusType(), RestStatus.status(successfulShards, totalShards, failures).getStatusType());
        public void writeTo(StreamOutput out) throws IOException {
        @Override
    public void testStatusReturnsFailureStatusWhenFailuresExist() {
    }  
        }  
import java.util.PriorityQueue;
        int totalShards = randomIntBetween(1, 100);
        for (int i = 0; i < totalShards; ++i) {
/*  
}
    }  
        // RestStatus.status will return RestStatus.OK when the highest failure code is 100 level.
    private static class TestException extends ShardOperationFailedException {
        int successfulShards = randomIntBetween(1, totalShards);
import org.opensearch.core.common.io.stream.StreamInput;  
            RestStatus.writeTo(out, status);  
package org.opensearch.core;
import org.opensearch.core.xcontent.XContentBuilder;
            failures[i] = failure;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        assertEquals(StatusType.SUCCESS.toString(), RestStatus.status(successfulShards, totalShards).getStatusType());
import org.opensearch.core.action.ShardOperationFailedException;
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
