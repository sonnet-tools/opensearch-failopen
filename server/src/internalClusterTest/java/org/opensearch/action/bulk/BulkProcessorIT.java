            assertThat(listener.beforeCounts.get(), equalTo(1));
import org.opensearch.transport.client.Requests;
            assertThat(bulkItemResponse.getFailureMessage(), bulkItemResponse.isFailed(), equalTo(false));
        }
            .build();
        int numDocs = randomIntBetween(bulkActions, bulkActions + 100);
    public void testBulkProcessorConcurrentRequestsReadOnlyIndex() throws Exception {
            latch.await();
import org.opensearch.transport.client.Client;
        Set<String> ids = new HashSet<>();
import java.util.concurrent.TimeUnit;
                    multiGetRequestBuilder.add("test", Integer.toString(testDocs));
                assertThat(bulkItemResponse.isFailed(), equalTo(true));
                .setFlushInterval(TimeValue.timeValueHours(24))
import java.util.concurrent.CopyOnWriteArrayList;
        int testDocs = 0;
        for (BulkItemResponse bulkItemResponse : listener.bulkItems) {
        private final CountDownLatch[] latches;
        }
        assertAcked(
            assertThat(ids.add(bulkItemResponse.getId()), equalTo(true));
        int expectedBulkActions = numDocs / bulkActions;
    }
            bulkFailures.add(failure);
            );
                } else {
        assertThat(bulkItemResponses.size(), is(numDocs));
                        new IndexRequest("test-ro").id(Integer.toString(testReadOnlyDocs))
                    .source(Requests.INDEX_CONTENT_TYPE, "field", randomRealisticUnicodeOfLengthBetween(1, 30))
            BulkProcessor processor = BulkProcessor.builder(client()::bulk, listener)
        }
        assertThat(listener.bulkFailures.size(), equalTo(0));
                    processor.add(
                .setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))
}
        BulkProcessorTestListener listener = new BulkProcessorTestListener(latch, closeLatch);
            latch.await();
 *
            assertThat(listener.beforeCounts.get(), equalTo(1));
/*
                .build()
                // let's make sure that the bulk action limit trips, one single execution will index all the documents
import java.util.concurrent.CountDownLatch;
        int testReadOnlyDocs = 0;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        final CountDownLatch latch = new CountDownLatch(expectedBulkActions);
        int i = 1;
        int concurrentRequests = randomIntBetween(0, 10);
            assertThat(
                .prepareUpdateSettings("test-ro")
import java.util.Set;
package org.opensearch.action.bulk;
            multiGetRequestBuilder.add("test", Integer.toString(i));
        public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
                // with concurrent requests > 1 we can't rely on the order of the bulk requests
        int totalExpectedBulkActions = numDocs % bulkActions == 0 ? expectedBulkActions : expectedBulkActions + 1;
                assertThat(ids.add(bulkItemResponse.getId()), equalTo(true));
                // let's make sure that this bulk won't be automatically flushed
        }
        ) {
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        Set<String> ids = new HashSet<>();
 */
        assertThat(listener.beforeCounts.get(), equalTo(totalExpectedBulkActions));
            } else {
        assertThat(multiGetResponse.getResponses().length, equalTo(numDocs));
        int bulkActions = randomIntBetween(10, 100);
        int i = 1;
            for (CountDownLatch latch : latches) {
        int concurrentRequests = randomIntBetween(0, 7);
                latch.countDown();
        BulkProcessorTestListener listener = new BulkProcessorTestListener(latch, closeLatch);
 * SPDX-License-Identifier: Apache-2.0
            assertThat(multiGetItemResponse.getId(), equalTo(Integer.toString(i++)));
                new IndexRequest("test").id(Integer.toString(i))
        private final AtomicInteger afterCounts = new AtomicInteger();
    }
            assertThat(bulkItemResponse.getIndex(), either(equalTo("test")).or(equalTo("test-ro")));
                equalTo(false)
            assertThat(listener.bulkItems.size(), equalTo(numDocs - numDocs % bulkActions));
 * not use this file except in compliance with the License.
        private final List<Throwable> bulkFailures = new CopyOnWriteArrayList<>();
        try (
                .indices()
            .setBulkActions(numDocs)
                "item " + i + " failed with cause: " + bulkItemResponse.getFailureMessage(),
                .build()
    }
            assertThat(listener.beforeCounts.get(), equalTo(expectedBulkActions));
        final CountDownLatch closeLatch = new CountDownLatch(totalExpectedBulkActions);
    }
                // we do want to check that we don't get duplicate ids back
        assertMultiGetResponse(multiGetRequestBuilder.get(), testDocs);
 */
        }
        assertThat(listener.afterCounts.get(), equalTo(totalExpectedBulkActions));
            assertThat(bulkItemResponse.getIndex(), equalTo("test"));
import java.util.Arrays;
            }
        ) {
import org.opensearch.action.get.MultiGetRequestBuilder;
        BulkProcessorTestListener listener = new BulkProcessorTestListener(latch);
            BulkProcessor processor = BulkProcessor.builder(client()::bulk, listener)
import static org.hamcrest.Matchers.is;
        int numDocs = randomIntBetween(bulkActions, bulkActions + 100);
        final CountDownLatch latch = new CountDownLatch(1);
        }
        ) {
            // we really need an explicit flush as none of the bulk thresholds was reached
import java.util.HashSet;
        try (
        assertThat(processor.isOpen(), is(false));
 *
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under
        assertThat(listener.beforeCounts.get(), greaterThanOrEqualTo(1));
 * You may obtain a copy of the License at
            assertResponseItems(listener.bulkItems, numDocs);
    }
        MultiGetRequestBuilder multiGetRequestBuilder = indexDocs(client(), processor, numDocs);
import org.opensearch.action.index.IndexRequest;
            bulkItems.addAll(Arrays.asList(response.getItems()));
/*
        final CountDownLatch closeLatch = new CountDownLatch(totalExpectedBulkActions);
import java.util.concurrent.atomic.AtomicInteger;
                .setConcurrentRequests(concurrentRequests)
        }
                assertThat(processor.awaitClose(1, TimeUnit.MINUTES), is(true));
 * specific language governing permissions and limitations
            multiGetRequestBuilder = indexDocs(client(), processor, numDocs);
 * The OpenSearch Contributors require contributions made to
        try (
 *    http://www.apache.org/licenses/LICENSE-2.0
                // we do want to check that we don't get duplicate ids back
    private static void assertMultiGetResponse(MultiGetResponse multiGetResponse, int numDocs) {
                    );
            assertThat(listener.afterCounts.get(), equalTo(expectedBulkActions));
        for (int i = 1; i <= numDocs; i++) {
        assertThat(listener.beforeCounts.get(), equalTo(totalExpectedBulkActions));
        int bulkActions = randomIntBetween(10, 100);
            .setFlushInterval(TimeValue.timeValueHours(24))
        for (MultiGetItemResponse multiGetItemResponse : multiGetResponse) {
            .setBulkSize(new ByteSizeValue(randomIntBetween(1, 10), RandomPicks.randomFrom(random(), ByteSizeUnit.values())))
                latch.countDown();
        assertThat(listener.bulkItems.size(), equalTo(numDocs));
        assertThat(listener.afterCounts.get(), greaterThanOrEqualTo(1));
        for (BulkItemResponse bulkItemResponse : bulkItemResponses) {
                // set interval and size to high values
                bulkItemResponse.isFailed(),
            assertThat(latch.await(randomInt(500), TimeUnit.MILLISECONDS), equalTo(false));
import org.opensearch.common.unit.TimeValue;
import static org.hamcrest.Matchers.both;
        Set<String> readOnlyIds = new HashSet<>();
import static org.hamcrest.Matchers.greaterThan;
        ) {
            }
                .setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))
            // we do want to check that we don't get duplicate ids back
            assertResponseItems(listener.bulkItems, numDocs);
 * the Apache License, Version 2.0 (the "License"); you may
        assertResponseItems(listener.bulkItems, numDocs);
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
            processor.flush();
                .setFlushInterval(TimeValue.timeValueHours(24))
                .build()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                .setConcurrentRequests(randomIntBetween(0, 10))
                .setConcurrentRequests(concurrentRequests)
                    processor.add(
import org.opensearch.common.settings.Settings;
                assertThat(Integer.valueOf(bulkItemResponse.getId()), both(greaterThan(0)).and(lessThanOrEqualTo(testDocs)));
 * this file be licensed under the Apache-2.0 license or a
    private static void assertResponseItems(List<BulkItemResponse> bulkItemResponses, int numDocs) {
            assertThat(listener.afterCounts.get(), equalTo(1));
import org.opensearch.core.common.unit.ByteSizeValue;
        }
        BulkProcessor processor = BulkProcessor.builder(client()::bulk, listener)
        int numDocs = randomIntBetween(10, 100);
 * compatible open source license.
    }
            for (CountDownLatch latch : latches) {
    public void testBulkProcessorFlush() throws Exception {
                }
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            this.latches = latches;
        final CountDownLatch latch = new CountDownLatch(expectedBulkActions);
        assertMultiGetResponse(multiGetRequestBuilder.get(), numDocs);
        assertThat(listener.afterCounts.get(), equalTo(totalExpectedBulkActions));
            }
        createIndex("test-ro");
        int totalExpectedBulkActions = numDocs % bulkActions == 0 ? expectedBulkActions : expectedBulkActions + 1;
        MultiGetRequestBuilder multiGetRequestBuilder;
        private final List<BulkItemResponse> bulkItems = new CopyOnWriteArrayList<>();
    private static class BulkProcessorTestListener implements BulkProcessor.Listener {
            afterCounts.incrementAndGet();
        int numDocs = randomIntBetween(10, 100);
        );
        closeLatch.await();
 * GitHub history for details.
            assertThat(Integer.valueOf(bulkItemResponse.getId()), both(greaterThan(0)).and(lessThanOrEqualTo(numDocs)));
                .build()
                .setBulkActions(bulkActions)
import org.opensearch.action.get.MultiGetItemResponse;
            client().admin()
import static org.hamcrest.Matchers.either;
            assertMultiGetResponse(multiGetRequestBuilder.get(), numDocs);
        private BulkProcessorTestListener(CountDownLatch... latches) {
    }
/*
        if (randomBoolean()) { // check if we can call it multiple times
            assertThat(bulkItemResponse.getIndex(), equalTo("test"));
                    );
            BulkProcessor processor = BulkProcessor.builder(client()::bulk, listener)
        }
    private static MultiGetRequestBuilder indexDocs(Client client, BulkProcessor processor, int numDocs) throws Exception {
        closeLatch.await();
            .setConcurrentRequests(randomIntBetween(0, 1))
            assertThat(listener.bulkFailures.size(), equalTo(0));
            // let's make sure that the bulk action limit trips, one single execution will index all the documents
        assertThat(listener.bulkFailures.size(), equalTo(0));
            }
                .setBulkActions(numDocs + randomIntBetween(1, 100))
        try (
                        new IndexRequest("test").id(Integer.toString(testDocs)).source(Requests.INDEX_CONTENT_TYPE, "field", "value")
                            .source(Requests.INDEX_CONTENT_TYPE, "field", "value")
            BulkProcessor processor = BulkProcessor.builder(client()::bulk, listener)
import org.opensearch.action.get.MultiGetResponse;
        int numDocs = randomIntBetween(10, 100);
 */
        }
                .setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))
 * under the License.
            assertThat(listener.bulkFailures.size(), equalTo(0));
            if (bulkItemResponse.getIndex().equals("test")) {
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_BLOCKS_WRITE, true))
        @Override
                    testDocs++;
        BulkProcessorTestListener listener = new BulkProcessorTestListener(latch);
            beforeCounts.incrementAndGet();
                processor.close();
        ensureGreen();
                assertThat(readOnlyIds.add(bulkItemResponse.getId()), equalTo(true));
        for (BulkItemResponse bulkItemResponse : listener.bulkItems) {
                assertThat(Integer.valueOf(bulkItemResponse.getId()), both(greaterThan(0)).and(lessThanOrEqualTo(testReadOnlyDocs)));
                assertThat(bulkItemResponse.isFailed(), equalTo(false));
        assertThat(listener.bulkFailures.size(), equalTo(0));
                .setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))
                .setFlushInterval(TimeValue.timeValueHours(24))
 *
                .setConcurrentRequests(randomIntBetween(0, 1))
        final CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.core.common.unit.ByteSizeUnit;
        BulkProcessorTestListener listener = new BulkProcessorTestListener();
 * this work for additional information regarding copyright
    public void testBulkProcessorWaitOnClose() throws Exception {
                .setBulkActions(bulkActions)
            MultiGetRequestBuilder multiGetRequestBuilder = indexDocs(client(), processor, numDocs);
            assertThat(multiGetItemResponse.getIndex(), equalTo("test"));
public class BulkProcessorIT extends OpenSearchIntegTestCase {
import org.opensearch.cluster.metadata.IndexMetadata;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.test.OpenSearchIntegTestCase;
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
        }
            if (randomBoolean()) {
    }
            // with concurrent requests > 1 we can't rely on the order of the bulk requests
            } else {
    public void testThatBulkProcessorCountIsCorrect() throws Exception {
            MultiGetRequestBuilder multiGetRequestBuilder = indexDocs(client(), processor, numDocs);
        int expectedBulkActions = numDocs / bulkActions;
        public void beforeBulk(long executionId, BulkRequest request) {
            );
                .setBulkActions(numDocs)
                if (randomBoolean()) {
                .setFlushInterval(TimeValue.timeValueHours(24))
            processor.add(
 * license agreements. See the NOTICE file distributed with
            assertThat(listener.bulkFailures.size(), equalTo(0));
            }
        assertMultiGetResponse(multiGetRequestBuilder.get(), numDocs);
    public void testBulkProcessorConcurrentRequests() throws Exception {
            assertThat(listener.afterCounts.get(), equalTo(1));
            afterCounts.incrementAndGet();
        assertThat(listener.bulkItems.size(), equalTo(testDocs + testReadOnlyDocs));
        public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
                // with concurrent requests > 1 we can't rely on the order of the bulk requests
        MultiGetRequestBuilder multiGetRequestBuilder = client().prepareMultiGet();
import java.util.List;
        assertThat(processor.awaitClose(1, TimeUnit.MINUTES), is(true));
            assertThat(bulkItemResponse.getId(), equalTo(Integer.toString(i++)));
    }
        assertThat(processor.isOpen(), is(true));
            latch.await();
        }
                // set interval and size to high values
 * Licensed to Elasticsearch under one or more contributor
        return multiGetRequestBuilder;
        private final AtomicInteger beforeCounts = new AtomicInteger();
            for (int i = 1; i <= numDocs; i++) {
        MultiGetRequestBuilder multiGetRequestBuilder = client.prepareMultiGet();
        @Override
            assertMultiGetResponse(multiGetRequestBuilder.get(), numDocs);
        }
                    testReadOnlyDocs++;
        @Override
import static org.hamcrest.Matchers.equalTo;
        }
