                1,
import java.util.concurrent.CountDownLatch;
        // Stash some random headers so we can assert that we preserve them
            bulk(request, responseFuture);
        this.bulkClient.close();
            for (int idx = 0; idx < request.requests().size(); idx++) {
            // do everything synchronously, that's fine for a test
        BackoffPolicy backoff = BackoffPolicy.constantBackoff(DELAY, CALLS_TO_FAIL - 1);
    }
        public void assertResponseWithoutFailures() {
        return request;
                OpType.INDEX,
/*
        BulkRequest bulkRequest = createBulkRequest();
            super(testName);
        listener.assertResponseWithNumberOfItems(bulkRequest.numberOfActions());
    @Before
        request.add(new UpdateRequest("shop", "4"));
                } else {
            latch.countDown();
            boolean shouldFail = numberOfCallsToFail > 0;
    private static final TimeValue DELAY = TimeValue.timeValueMillis(1L);
    }
        assertThat(response.getItems().length, equalTo(bulkRequest.numberOfActions()));
                return;
    @After
 * ownership. Elasticsearch licenses this file to you under
        listener.assertResponseWithFailures();
            }
        request.add(new UpdateRequest("shop", "3"));
        @Override
        listener.assertOnResponseCalled();
        }
        }
        BulkResponse response = new Retry(backoff, bulkClient.threadPool()).withBackoff(bulkClient::bulk, bulkRequest).actionGet();
        expectedHeaders.put(randomAlphaOfLength(5), randomAlphaOfLength(5));
        }
    private static class AssertingListener implements ActionListener<BulkResponse> {
 */
import static org.hamcrest.Matchers.equalTo;
/*
        BulkRequest bulkRequest = createBulkRequest();
import org.opensearch.common.unit.TimeValue;
            if (false == expectedHeaders.equals(threadPool().getThreadContext().getHeaders())) {
        @Override
            assertThat(response.getItems().length, equalTo(numItems));
        Retry retry = new Retry(backoff, bulkClient.threadPool());
                    "test",
        int index = 0;
        private int numberOfCallsToFail;
    @Override
        BulkRequest bulkRequest = createBulkRequest();
        }
            PlainActionFuture<BulkResponse> responseFuture = new PlainActionFuture<>();
            }
import org.opensearch.action.index.IndexRequest;
import org.opensearch.action.update.UpdateRequest;
 * Modifications Copyright OpenSearch Contributors. See
 */
        assertTrue(response.hasFailures());
import java.util.HashMap;
 * the Apache License, Version 2.0 (the "License"); you may
        private BulkItemResponse successfulResponse() {
                new BulkItemResponse.Failure(
    private Map<String, String> expectedHeaders = new HashMap<>();
import org.junit.Before;
 * license agreements. See the NOTICE file distributed with
        listener.assertOnResponseCalled();
                listener.onFailure(
    @Override
            }
    public void testRetryFailsAfterBackoff() throws Exception {
    public void setUp() throws Exception {
    }
            this.numberOfCallsToFail = numberOfCallsToFail;
                OpType.INDEX,
                new BulkItemResponse.Failure("test", "1", new OpenSearchRejectedExecutionException("pool full"))
        BulkRequest bulkRequest = createBulkRequest();
                if (docWriteRequest instanceof IndexRequest indexRequest) {
            countOnResponseCalled.incrementAndGet();
        public void bulk(BulkRequest request, ActionListener<BulkResponse> listener) {
            assertFalse("Response should not have failures", response.hasFailures());
                    new OpenSearchRejectedExecutionException("throttling"),
        private final AtomicInteger countOnResponseCalled = new AtomicInteger();
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor
                    } else {
        private BulkItemResponse failedResponseWithSource() {
 * this work for additional information regarding copyright
import org.junit.After;
        public void assertOnResponseCalled() {
            latch.countDown();
                DocWriteRequest<?> docWriteRequest = bulkRequest.requests.get(index);
            );
            return new BulkItemResponse(
 * this file be licensed under the Apache-2.0 license or a
        BackoffPolicy backoff = BackoffPolicy.constantBackoff(DELAY, CALLS_TO_FAIL);
        }
        request.add(new IndexRequest("shop").id("6"));
        listener.awaitCallbacksCalled();
                    new RuntimeException("Expected " + expectedHeaders + " but got " + threadPool().getThreadContext().getHeaders())
        }
    private static final int CALLS_TO_FAIL = 5;
        AssertingListener listener = new AssertingListener();
    }
        listener.assertResponseWithoutFailures();
        for (BulkItemResponse itemResponse : response) {
import org.opensearch.core.action.ActionListener;
 * compatible open source license.
        }
            assertThat(response, notNullValue());
 * KIND, either express or implied.  See the License for the
        }
        }
import org.opensearch.action.support.PlainActionFuture;
        assertThat(response.getItems().length, equalTo(bulkRequest.numberOfActions()));
import org.opensearch.test.OpenSearchTestCase;
                )
            index++;
        private volatile Throwable lastFailure;
        public void assertOnFailureNeverCalled() {
 */
        }
        private BulkItemResponse failedResponse() {
        }
        BulkRequest request = new BulkRequest();
        public void onResponse(BulkResponse bulkItemResponses) {
        request.pipeline("test_pipeline");
                );
    // no need to wait fof a long time in tests
                    itemResponses[idx] = successfulResponse();
                    assertFalse(indexRequest.isPipelineResolved());
        request.add(new UpdateRequest("shop", "2"));
        this.bulkClient = new MockBulkClient(getTestName(), CALLS_TO_FAIL);
import org.opensearch.action.DocWriteRequest.OpType;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        private volatile BulkResponse response;
    private class MockBulkClient extends NoOpClient {
 * SPDX-License-Identifier: Apache-2.0
                    assertThat(indexRequest.getPipeline(), equalTo("test_pipeline"));
        public void assertResponseWithNumberOfItems(int numItems) {
        super.setUp();
        bulkClient.threadPool().getThreadContext().putHeader(expectedHeaders);
            this.lastFailure = e;
        }
    public void testRetryWithListenerFailsAfterBacksOff() throws Exception {
 * GitHub history for details.
        listener.assertOnFailureNeverCalled();
 *
    public void tearDown() throws Exception {
     */
        BulkResponse response = new Retry(backoff, bulkClient.threadPool()).withBackoff(bulkClient::bulk, bulkRequest).actionGet();
                    "1",
import java.util.Map;
    public void testRetryWithListenerBacksOff() throws Exception {
/*
        }
        public void awaitCallbacksCalled() throws InterruptedException {
 * specific language governing permissions and limitations
                    }
        AssertingListener listener = new AssertingListener();
        expectedHeaders.clear();
            latch.await();
 * under the License.
        public void assertResponseWithFailures() {
 * You may obtain a copy of the License at
import org.opensearch.test.client.NoOpClient;
 * The OpenSearch Contributors require contributions made to
    }
    /**
        listener.assertOnFailureNeverCalled();
                    BulkItemResponse.Failure.FailureSource.PIPELINE
            listener.onResponse(new BulkResponse(itemResponses, 1000L));
            assertThat(response, notNullValue());
            latch = new CountDownLatch(1);
        bulkClient.threadPool().getThreadContext().stashContext();
 *
    }
        private MockBulkClient(String testName, int numberOfCallsToFail) {
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            );
        assertFalse(response.hasFailures());
            assertTrue("Response should have failures", response.hasFailures());
            return responseFuture;
 *
        retry.withBackoff(bulkClient::bulk, bulkRequest, listener);
     * Headers that are expected to be sent with all bulk requests.
            int itemToFail = randomInt(request.requests().size() - 1);
        @Override
import org.opensearch.action.DocWriteRequest;
            BulkItemResponse[] itemResponses = new BulkItemResponse[request.requests().size()];
}
import org.opensearch.common.action.ActionFuture;
    }
import org.opensearch.core.index.shard.ShardId;
                }
    private MockBulkClient bulkClient;
            numberOfCallsToFail--;
        private final CountDownLatch latch;
                }
            assertThat(countOnResponseCalled.get(), equalTo(1));
        }
        @Override
            if (itemResponse.isFailed() && itemResponse.getFailure().getSource() == BulkItemResponse.Failure.FailureSource.PIPELINE) {
        request.add(new UpdateRequest("shop", "5"));
            // if we have to fail, we need to fail at least once "reliably", the rest can be random
            this.response = bulkItemResponses;
        listener.awaitCallbacksCalled();
        super.tearDown();
        BackoffPolicy backoff = BackoffPolicy.constantBackoff(DELAY, CALLS_TO_FAIL);
        BackoffPolicy backoff = BackoffPolicy.constantBackoff(DELAY, CALLS_TO_FAIL - 1);
                        itemResponses[idx] = failedResponseWithSource();
        }
    }
    public void testRetryBacksOff() throws Exception {
        retry.withBackoff(bulkClient::bulk, bulkRequest, listener);
        public ActionFuture<BulkResponse> bulk(BulkRequest request) {
    }
            return new BulkItemResponse(1, OpType.DELETE, new DeleteResponse(new ShardId("test", "test", 0), "test", 0, 0, 0, false));
 * not use this file except in compliance with the License.
            return new BulkItemResponse(
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.action.delete.DeleteResponse;
    private BulkRequest createBulkRequest() {
package org.opensearch.action.bulk;
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.Matchers.notNullValue;
                    if (request.requests().get(idx) instanceof IndexRequest) {
import static org.hamcrest.Matchers.nullValue;
        private AssertingListener() {
                1,
        listener.assertResponseWithNumberOfItems(bulkRequest.numberOfActions());
        public void onFailure(Exception e) {
            assertThat(lastFailure, nullValue());
public class RetryTests extends OpenSearchTestCase {
        }
                        itemResponses[idx] = failedResponse();
                if (shouldFail && (randomBoolean() || idx == itemToFail)) {
        Retry retry = new Retry(backoff, bulkClient.threadPool());
        request.add(new UpdateRequest("shop", "1"));
