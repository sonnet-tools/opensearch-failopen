            BulkItemResponse[] itemResponses = new BulkItemResponse[request.requests().size()];
        private BulkItemResponse failedResponseWithSource() {
import java.util.Map;  
        }
        expectedHeaders.put(randomAlphaOfLength(5), randomAlphaOfLength(5));  
            latch.await();
                DocWriteRequest<?> docWriteRequest = bulkRequest.requests.get(index);  
import static org.hamcrest.Matchers.equalTo;
                    assertThat(indexRequest.getPipeline(), equalTo("test_pipeline"));  
                OpType.INDEX,
 *  
import org.opensearch.action.DocWriteRequest;
            bulk(request, responseFuture);  
        }  
    private static final TimeValue DELAY = TimeValue.timeValueMillis(1L);
                if (docWriteRequest instanceof IndexRequest indexRequest) {
                new BulkItemResponse.Failure(
                    itemResponses[idx] = successfulResponse();
        assertThat(response.getItems().length, equalTo(bulkRequest.numberOfActions()));  
        int index = 0;  
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
        }
        }
        BackoffPolicy backoff = BackoffPolicy.constantBackoff(DELAY, CALLS_TO_FAIL - 1);
package org.opensearch.action.bulk;
        BulkResponse response = new Retry(backoff, bulkClient.threadPool()).withBackoff(bulkClient::bulk, bulkRequest).actionGet();  
    private MockBulkClient bulkClient;
 * the Apache License, Version 2.0 (the "License"); you may
    }
import org.opensearch.core.action.ActionListener;  
import org.junit.After;
            assertThat(response, notNullValue());
        retry.withBackoff(bulkClient::bulk, bulkRequest, listener);
        public void bulk(BulkRequest request, ActionListener<BulkResponse> listener) {
            );
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertTrue("Response should have failures", response.hasFailures());
        BulkRequest bulkRequest = createBulkRequest();  
 * Licensed to Elasticsearch under one or more contributor  
        public void assertOnFailureNeverCalled() {
    private static final int CALLS_TO_FAIL = 5;
 * Modifications Copyright OpenSearch Contributors. See
        super.tearDown();
        retry.withBackoff(bulkClient::bulk, bulkRequest, listener);
        for (BulkItemResponse itemResponse : response) {
                    assertFalse(indexRequest.isPipelineResolved());
        listener.assertOnResponseCalled();
import org.opensearch.test.client.NoOpClient;
                1,  
        }  
     */
        public void onResponse(BulkResponse bulkItemResponses) {
                    if (request.requests().get(idx) instanceof IndexRequest) {
        listener.assertResponseWithNumberOfItems(bulkRequest.numberOfActions());
                1,
                }
        }
        super.setUp();
        public void assertResponseWithFailures() {  
            int itemToFail = randomInt(request.requests().size() - 1);
 * The OpenSearch Contributors require contributions made to  
        BulkRequest request = new BulkRequest();  
import org.opensearch.action.update.UpdateRequest;  
            return responseFuture;
        BulkRequest bulkRequest = createBulkRequest();
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(response.hasFailures());  
import static org.hamcrest.Matchers.nullValue;  
import org.opensearch.test.OpenSearchTestCase;  
    private BulkRequest createBulkRequest() {
        request.add(new UpdateRequest("shop", "4"));
    public void testRetryFailsAfterBackoff() throws Exception {  
    @Override
        request.add(new UpdateRequest("shop", "3"));
import org.opensearch.action.DocWriteRequest.OpType;
        BulkResponse response = new Retry(backoff, bulkClient.threadPool()).withBackoff(bulkClient::bulk, bulkRequest).actionGet();
 * this work for additional information regarding copyright
    }
            }  
        assertThat(response.getItems().length, equalTo(bulkRequest.numberOfActions()));
        }
        expectedHeaders.clear();
        bulkClient.threadPool().getThreadContext().stashContext();
            // if we have to fail, we need to fail at least once "reliably", the rest can be random  
import org.opensearch.action.delete.DeleteResponse;  
                    "1",
 *
            this.numberOfCallsToFail = numberOfCallsToFail;  
        @Override
        this.bulkClient = new MockBulkClient(getTestName(), CALLS_TO_FAIL);
        }  
}
    /**
            // do everything synchronously, that's fine for a test
 */  
 * software distributed under the License is distributed on an
        listener.assertOnFailureNeverCalled();
    public void testRetryWithListenerBacksOff() throws Exception {
        listener.assertOnFailureNeverCalled();
                new BulkItemResponse.Failure("test", "1", new OpenSearchRejectedExecutionException("pool full"))  
        AssertingListener listener = new AssertingListener();  
        private BulkItemResponse successfulResponse() {
                    "test",  
        public void assertResponseWithoutFailures() {
            numberOfCallsToFail--;  
        BackoffPolicy backoff = BackoffPolicy.constantBackoff(DELAY, CALLS_TO_FAIL - 1);
        request.add(new UpdateRequest("shop", "5"));  
        public ActionFuture<BulkResponse> bulk(BulkRequest request) {
            if (false == expectedHeaders.equals(threadPool().getThreadContext().getHeaders())) {  
    @After
    }  
        bulkClient.threadPool().getThreadContext().putHeader(expectedHeaders);
        listener.assertResponseWithNumberOfItems(bulkRequest.numberOfActions());  
            index++;  
        assertFalse(response.hasFailures());
 * not use this file except in compliance with the License.
    }  
 * SPDX-License-Identifier: Apache-2.0
        }
import org.junit.Before;  
import org.opensearch.action.support.PlainActionFuture;
            }
            assertThat(response, notNullValue());
        request.add(new IndexRequest("shop").id("6"));
        }
        return request;
    }
            super(testName);
                listener.onFailure(
    public void setUp() throws Exception {  
        listener.awaitCallbacksCalled();  
        }  
    }  
            this.lastFailure = e;
 * license agreements. See the NOTICE file distributed with
        AssertingListener listener = new AssertingListener();  
        BackoffPolicy backoff = BackoffPolicy.constantBackoff(DELAY, CALLS_TO_FAIL);
                        itemResponses[idx] = failedResponseWithSource();
        private BulkItemResponse failedResponse() {
        BulkRequest bulkRequest = createBulkRequest();
                    }
        Retry retry = new Retry(backoff, bulkClient.threadPool());  
 */  
            return new BulkItemResponse(  
        public void assertOnResponseCalled() {
            assertThat(countOnResponseCalled.get(), equalTo(1));  
        listener.assertResponseWithFailures();  
        private AssertingListener() {
        }
                if (shouldFail && (randomBoolean() || idx == itemToFail)) {  
        private final AtomicInteger countOnResponseCalled = new AtomicInteger();
        this.bulkClient.close();
/*  
        BackoffPolicy backoff = BackoffPolicy.constantBackoff(DELAY, CALLS_TO_FAIL);  
        request.pipeline("test_pipeline");
        @Override
import java.util.concurrent.CountDownLatch;
import org.opensearch.action.index.IndexRequest;
            assertThat(response.getItems().length, equalTo(numItems));
        public void awaitCallbacksCalled() throws InterruptedException {  
    private static class AssertingListener implements ActionListener<BulkResponse> {
    public void testRetryBacksOff() throws Exception {
    }
            countOnResponseCalled.incrementAndGet();
 * You may obtain a copy of the License at  
        public void assertResponseWithNumberOfItems(int numItems) {  
        }  
            return new BulkItemResponse(1, OpType.DELETE, new DeleteResponse(new ShardId("test", "test", 0), "test", 0, 0, 0, false));
/*
 */
    // no need to wait fof a long time in tests  
                return;
        private final CountDownLatch latch;  
            latch.countDown();
            if (itemResponse.isFailed() && itemResponse.getFailure().getSource() == BulkItemResponse.Failure.FailureSource.PIPELINE) {
import org.opensearch.core.index.shard.ShardId;
    private class MockBulkClient extends NoOpClient {
/*  
        request.add(new UpdateRequest("shop", "2"));  
            }
        @Override
            assertFalse("Response should not have failures", response.hasFailures());  
    public void testRetryWithListenerFailsAfterBacksOff() throws Exception {
                    new RuntimeException("Expected " + expectedHeaders + " but got " + threadPool().getThreadContext().getHeaders())
                    new OpenSearchRejectedExecutionException("throttling"),
                    BulkItemResponse.Failure.FailureSource.PIPELINE  
            PlainActionFuture<BulkResponse> responseFuture = new PlainActionFuture<>();
import java.util.concurrent.atomic.AtomicInteger;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        listener.assertResponseWithoutFailures();
        private int numberOfCallsToFail;
        listener.awaitCallbacksCalled();  
import java.util.HashMap;
import static org.hamcrest.Matchers.notNullValue;
                } else {  
        }
        private MockBulkClient(String testName, int numberOfCallsToFail) {
        }
                }
        Retry retry = new Retry(backoff, bulkClient.threadPool());  
        public void onFailure(Exception e) {  
    private Map<String, String> expectedHeaders = new HashMap<>();
    @Override
import org.opensearch.common.unit.TimeValue;
 * ownership. Elasticsearch licenses this file to you under  
        @Override  
 * compatible open source license.
        }
            listener.onResponse(new BulkResponse(itemResponses, 1000L));
        private volatile BulkResponse response;  
                        itemResponses[idx] = failedResponse();
        listener.assertOnResponseCalled();
            assertThat(lastFailure, nullValue());  
     * Headers that are expected to be sent with all bulk requests.  
            this.response = bulkItemResponses;  
    public void tearDown() throws Exception {  
 * under the License.  
                OpType.INDEX,
 *
 * GitHub history for details.
        // Stash some random headers so we can assert that we preserve them  
import org.opensearch.common.action.ActionFuture;
            boolean shouldFail = numberOfCallsToFail > 0;
    @Before
            latch.countDown();
            for (int idx = 0; idx < request.requests().size(); idx++) {
        request.add(new UpdateRequest("shop", "1"));
                );  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            return new BulkItemResponse(
 * KIND, either express or implied.  See the License for the
                )
                    } else {  
    }
        private volatile Throwable lastFailure;
    }
            latch = new CountDownLatch(1);  
public class RetryTests extends OpenSearchTestCase {
        BulkRequest bulkRequest = createBulkRequest();
            );
