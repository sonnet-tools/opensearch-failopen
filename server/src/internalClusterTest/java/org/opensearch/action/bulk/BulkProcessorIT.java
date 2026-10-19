import org.opensearch.cluster.metadata.IndexMetadata;
package org.opensearch.action.bulk;
                latch.countDown();
 * this file be licensed under the Apache-2.0 license or a
            // we do want to check that we don't get duplicate ids back  
        MultiGetRequestBuilder multiGetRequestBuilder = indexDocs(client(), processor, numDocs);
        BulkProcessorTestListener listener = new BulkProcessorTestListener(latch);
        assertThat(listener.beforeCounts.get(), equalTo(totalExpectedBulkActions));
                assertThat(ids.add(bulkItemResponse.getId()), equalTo(true));
    }
        BulkProcessor processor = BulkProcessor.builder(client()::bulk, listener)
                .setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))
            assertThat(listener.afterCounts.get(), equalTo(1));
            BulkProcessor processor = BulkProcessor.builder(client()::bulk, listener)
import java.util.concurrent.atomic.AtomicInteger;
                // we do want to check that we don't get duplicate ids back  
            .setBulkSize(new ByteSizeValue(randomIntBetween(1, 10), RandomPicks.randomFrom(random(), ByteSizeUnit.values())))
 */  
                        new IndexRequest("test").id(Integer.toString(testDocs)).source(Requests.INDEX_CONTENT_TYPE, "field", "value")
                .setFlushInterval(TimeValue.timeValueHours(24))
import static org.hamcrest.Matchers.either;  
        int bulkActions = randomIntBetween(10, 100);
                .setConcurrentRequests(concurrentRequests)
        int numDocs = randomIntBetween(bulkActions, bulkActions + 100);
            }  
        int concurrentRequests = randomIntBetween(0, 10);
        Set<String> ids = new HashSet<>();
                    testReadOnlyDocs++;  
            assertThat(multiGetItemResponse.getId(), equalTo(Integer.toString(i++)));  
        ) {  
        assertThat(listener.bulkFailures.size(), equalTo(0));
            assertThat(listener.beforeCounts.get(), equalTo(1));
import org.opensearch.action.get.MultiGetItemResponse;  
import static org.hamcrest.Matchers.both;
            assertThat(listener.afterCounts.get(), equalTo(expectedBulkActions));  
            latch.await();
        assertThat(multiGetResponse.getResponses().length, equalTo(numDocs));
        for (int i = 1; i <= numDocs; i++) {
            multiGetRequestBuilder.add("test", Integer.toString(i));  
            multiGetRequestBuilder = indexDocs(client(), processor, numDocs);
                .setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))
                .setConcurrentRequests(concurrentRequests)
import org.opensearch.common.settings.Settings;
        }  
    public void testBulkProcessorConcurrentRequestsReadOnlyIndex() throws Exception {
        int numDocs = randomIntBetween(10, 100);  
                // set interval and size to high values
                }
        int expectedBulkActions = numDocs / bulkActions;
                        new IndexRequest("test-ro").id(Integer.toString(testReadOnlyDocs))
import static org.hamcrest.Matchers.is;
            beforeCounts.incrementAndGet();  
        createIndex("test-ro");  
        BulkProcessorTestListener listener = new BulkProcessorTestListener(latch, closeLatch);
            assertThat(listener.bulkFailures.size(), equalTo(0));  
        }
import java.util.concurrent.TimeUnit;
            bulkFailures.add(failure);
        Set<String> readOnlyIds = new HashSet<>();
                assertThat(Integer.valueOf(bulkItemResponse.getId()), both(greaterThan(0)).and(lessThanOrEqualTo(testDocs)));
 * not use this file except in compliance with the License.
        int bulkActions = randomIntBetween(10, 100);  
            .setFlushInterval(TimeValue.timeValueHours(24))  
        final CountDownLatch latch = new CountDownLatch(1);  
                assertThat(Integer.valueOf(bulkItemResponse.getId()), both(greaterThan(0)).and(lessThanOrEqualTo(testReadOnlyDocs)));
 * compatible open source license.
            assertThat(ids.add(bulkItemResponse.getId()), equalTo(true));
        ) {
            }  
        }
import org.opensearch.action.get.MultiGetResponse;
                processor.close();
        assertThat(processor.isOpen(), is(true));
                // set interval and size to high values
            if (randomBoolean()) {
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
        int totalExpectedBulkActions = numDocs % bulkActions == 0 ? expectedBulkActions : expectedBulkActions + 1;
        Set<String> ids = new HashSet<>();  
            BulkProcessor processor = BulkProcessor.builder(client()::bulk, listener)
                    );  
            assertThat(bulkItemResponse.getIndex(), equalTo("test"));  
                assertThat(bulkItemResponse.isFailed(), equalTo(true));  
            assertMultiGetResponse(multiGetRequestBuilder.get(), numDocs);
            assertThat(listener.beforeCounts.get(), equalTo(1));  
            latch.await();
            .build();
                bulkItemResponse.isFailed(),
 * You may obtain a copy of the License at  
        assertThat(listener.beforeCounts.get(), equalTo(totalExpectedBulkActions));
                assertThat(readOnlyIds.add(bulkItemResponse.getId()), equalTo(true));
    }
            .setBulkActions(numDocs)
        int testDocs = 0;
        assertAcked(
        );  
                    multiGetRequestBuilder.add("test", Integer.toString(testDocs));
                .setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))  
                // let's make sure that the bulk action limit trips, one single execution will index all the documents  
        public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
        int numDocs = randomIntBetween(10, 100);
        private final AtomicInteger beforeCounts = new AtomicInteger();
        }
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.core.common.unit.ByteSizeValue;
                .indices()  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
 * Licensed to Elasticsearch under one or more contributor  
        public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
            assertThat(Integer.valueOf(bulkItemResponse.getId()), both(greaterThan(0)).and(lessThanOrEqualTo(numDocs)));
        int concurrentRequests = randomIntBetween(0, 7);  
            assertResponseItems(listener.bulkItems, numDocs);  
        @Override  
        final CountDownLatch closeLatch = new CountDownLatch(totalExpectedBulkActions);
import static org.hamcrest.Matchers.greaterThan;
import org.opensearch.test.OpenSearchIntegTestCase;  
import java.util.concurrent.CountDownLatch;  
        MultiGetRequestBuilder multiGetRequestBuilder;
        private final List<Throwable> bulkFailures = new CopyOnWriteArrayList<>();
                .setBulkActions(bulkActions)  
        if (randomBoolean()) { // check if we can call it multiple times
        MultiGetRequestBuilder multiGetRequestBuilder = client.prepareMultiGet();  
    public void testThatBulkProcessorCountIsCorrect() throws Exception {
            latch.await();  
            }  
                assertThat(bulkItemResponse.isFailed(), equalTo(false));  
            );
 * license agreements. See the NOTICE file distributed with
            }  
        for (MultiGetItemResponse multiGetItemResponse : multiGetResponse) {
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        closeLatch.await();
/*  
        }
            processor.flush();
                .setConcurrentRequests(randomIntBetween(0, 10))
 * under the License.  
            assertThat(bulkItemResponse.getId(), equalTo(Integer.toString(i++)));
        }
        int testReadOnlyDocs = 0;
 *  
    public void testBulkProcessorConcurrentRequests() throws Exception {  
        assertResponseItems(listener.bulkItems, numDocs);
                .setConcurrentRequests(randomIntBetween(0, 1))
                } else {
                // with concurrent requests > 1 we can't rely on the order of the bulk requests
                .setFlushInterval(TimeValue.timeValueHours(24))
        assertThat(listener.afterCounts.get(), equalTo(totalExpectedBulkActions));
        closeLatch.await();  
        @Override  
        MultiGetRequestBuilder multiGetRequestBuilder = client().prepareMultiGet();  
    private static class BulkProcessorTestListener implements BulkProcessor.Listener {
 * The OpenSearch Contributors require contributions made to  
        try (
                .setBulkActions(numDocs + randomIntBetween(1, 100))  
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_BLOCKS_WRITE, true))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
            assertThat(listener.afterCounts.get(), equalTo(1));
            assertThat(listener.bulkItems.size(), equalTo(numDocs - numDocs % bulkActions));
                latch.countDown();
                    testDocs++;  
        ensureGreen();
        assertThat(processor.awaitClose(1, TimeUnit.MINUTES), is(true));  
            assertThat(multiGetItemResponse.getIndex(), equalTo("test"));
    public void testBulkProcessorFlush() throws Exception {
    }
            assertThat(latch.await(randomInt(500), TimeUnit.MILLISECONDS), equalTo(false));
        private final List<BulkItemResponse> bulkItems = new CopyOnWriteArrayList<>();  
/*
                .build()
        final CountDownLatch latch = new CountDownLatch(1);  
 *
                .build()
        }
                    );
            }
            assertThat(bulkItemResponse.getIndex(), either(equalTo("test")).or(equalTo("test-ro")));
        assertThat(processor.isOpen(), is(false));
                // let's make sure that this bulk won't be automatically flushed
            assertThat(listener.beforeCounts.get(), equalTo(expectedBulkActions));
            } else {
        try (  
        final CountDownLatch closeLatch = new CountDownLatch(totalExpectedBulkActions);  
        int numDocs = randomIntBetween(10, 100);  
        @Override
    }  
}  
            client().admin()
        }
            BulkProcessor processor = BulkProcessor.builder(client()::bulk, listener)
                // we do want to check that we don't get duplicate ids back  
            if (bulkItemResponse.getIndex().equals("test")) {
import java.util.HashSet;
            // let's make sure that the bulk action limit trips, one single execution will index all the documents  
        }
                .setBulkActions(numDocs)
                            .source(Requests.INDEX_CONTENT_TYPE, "field", "value")  
                .build()  
                .prepareUpdateSettings("test-ro")
            assertThat(bulkItemResponse.getFailureMessage(), bulkItemResponse.isFailed(), equalTo(false));
        for (BulkItemResponse bulkItemResponse : bulkItemResponses) {
 */  
        int expectedBulkActions = numDocs / bulkActions;
 * KIND, either express or implied.  See the License for the
            afterCounts.incrementAndGet();  
import org.opensearch.common.unit.TimeValue;  
        }  
        int numDocs = randomIntBetween(bulkActions, bulkActions + 100);
            MultiGetRequestBuilder multiGetRequestBuilder = indexDocs(client(), processor, numDocs);  
import org.opensearch.action.get.MultiGetRequestBuilder;
            for (CountDownLatch latch : latches) {
 * Unless required by applicable law or agreed to in writing,
        }  
import java.util.List;  
        for (BulkItemResponse bulkItemResponse : listener.bulkItems) {  
        assertThat(listener.bulkFailures.size(), equalTo(0));  
        private BulkProcessorTestListener(CountDownLatch... latches) {  
        BulkProcessorTestListener listener = new BulkProcessorTestListener(latch);
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
            this.latches = latches;
            assertThat(listener.bulkFailures.size(), equalTo(0));
            assertResponseItems(listener.bulkItems, numDocs);
        return multiGetRequestBuilder;
        assertThat(bulkItemResponses.size(), is(numDocs));  
                equalTo(false)
import org.opensearch.transport.client.Requests;
                if (randomBoolean()) {
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
                assertThat(processor.awaitClose(1, TimeUnit.MINUTES), is(true));  
        assertThat(listener.bulkItems.size(), equalTo(numDocs));
        }
        assertMultiGetResponse(multiGetRequestBuilder.get(), numDocs);
 * specific language governing permissions and limitations
    private static MultiGetRequestBuilder indexDocs(Client client, BulkProcessor processor, int numDocs) throws Exception {
public class BulkProcessorIT extends OpenSearchIntegTestCase {
            MultiGetRequestBuilder multiGetRequestBuilder = indexDocs(client(), processor, numDocs);
        int totalExpectedBulkActions = numDocs % bulkActions == 0 ? expectedBulkActions : expectedBulkActions + 1;
                .setFlushInterval(TimeValue.timeValueHours(24))
        assertThat(listener.beforeCounts.get(), greaterThanOrEqualTo(1));
 * this work for additional information regarding copyright
        }
        assertMultiGetResponse(multiGetRequestBuilder.get(), testDocs);
            assertThat(listener.bulkFailures.size(), equalTo(0));
import java.util.Set;
        assertMultiGetResponse(multiGetRequestBuilder.get(), numDocs);
        assertThat(listener.bulkFailures.size(), equalTo(0));  
import java.util.concurrent.CopyOnWriteArrayList;
                    processor.add(
                "item " + i + " failed with cause: " + bulkItemResponse.getFailureMessage(),  
        try (  
            .setConcurrentRequests(randomIntBetween(0, 1))
import org.opensearch.action.index.IndexRequest;  
            // we really need an explicit flush as none of the bulk thresholds was reached  
        private final AtomicInteger afterCounts = new AtomicInteger();
        int i = 1;  
    }  
    }  
        int i = 1;
        BulkProcessorTestListener listener = new BulkProcessorTestListener();
        assertThat(listener.afterCounts.get(), equalTo(totalExpectedBulkActions));  
                .build()
                    .source(Requests.INDEX_CONTENT_TYPE, "field", randomRealisticUnicodeOfLengthBetween(1, 30))
    }  
import java.util.Arrays;
 * GitHub history for details.
            processor.add(
            );  
 * ownership. Elasticsearch licenses this file to you under  
    }
        assertThat(listener.afterCounts.get(), greaterThanOrEqualTo(1));
                    processor.add(
 * Modifications Copyright OpenSearch Contributors. See
        }
            assertThat(bulkItemResponse.getIndex(), equalTo("test"));  
        private final CountDownLatch[] latches;  
                .setBulkActions(bulkActions)  
        ) {
 * the Apache License, Version 2.0 (the "License"); you may
                // with concurrent requests > 1 we can't rely on the order of the bulk requests
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        BulkProcessorTestListener listener = new BulkProcessorTestListener(latch, closeLatch);
        public void beforeBulk(long executionId, BulkRequest request) {
            afterCounts.incrementAndGet();  
    }
        final CountDownLatch latch = new CountDownLatch(expectedBulkActions);
            assertMultiGetResponse(multiGetRequestBuilder.get(), numDocs);
 *
    private static void assertMultiGetResponse(MultiGetResponse multiGetResponse, int numDocs) {
            for (int i = 1; i <= numDocs; i++) {
            BulkProcessor processor = BulkProcessor.builder(client()::bulk, listener)  
            // with concurrent requests > 1 we can't rely on the order of the bulk requests
            for (CountDownLatch latch : latches) {
        assertThat(listener.bulkItems.size(), equalTo(testDocs + testReadOnlyDocs));
import org.opensearch.core.common.unit.ByteSizeUnit;
    public void testBulkProcessorWaitOnClose() throws Exception {
                .setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))  
            } else {
            assertThat(
        for (BulkItemResponse bulkItemResponse : listener.bulkItems) {
        ) {
import org.opensearch.transport.client.Client;
            bulkItems.addAll(Arrays.asList(response.getItems()));
                new IndexRequest("test").id(Integer.toString(i))  
        try (
        final CountDownLatch latch = new CountDownLatch(expectedBulkActions);  
                .setFlushInterval(TimeValue.timeValueHours(24))  
    private static void assertResponseItems(List<BulkItemResponse> bulkItemResponses, int numDocs) {
