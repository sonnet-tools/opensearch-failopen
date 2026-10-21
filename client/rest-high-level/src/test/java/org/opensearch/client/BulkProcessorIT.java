                + "    }\n"
        int expectedBulkActions = numDocs / bulkActions;
                .build()
        }
                + "        }\n"
        final CountDownLatch closeLatch = new CountDownLatch(totalExpectedBulkActions);
 * Licensed to Elasticsearch under one or more contributor
        int concurrentRequests = randomIntBetween(0, 7);
        // end::bulk-processor-mix-parameters
    }
            assertThat(listener.afterCounts.get(), equalTo(1));
                Iterable<SearchHit> hits = searchAll(new SearchRequest("test").routing("routing"));
            latch.await();
import org.opensearch.search.SearchHit;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.fieldFromSource;
    }
                assertThat(hits, containsInAnyOrder(expectedIds(numDocs)));
    public void testBulkProcessorFlush() throws Exception {
        }
                + "            \"blocks.write\" : true\n"
import org.opensearch.core.xcontent.XContentBuilder;
                assertThat(ids.add(bulkItemResponse.getId()), equalTo(true));
                // we do want to check that we don't get duplicate ids back
                    .setGlobalRouting("routing")
import static org.hamcrest.Matchers.equalTo;
            processor.add(new IndexRequest() // <1>
            for (int i = 1; i <= numDocs; i++) {
 * You may obtain a copy of the License at
        ) {
                );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;
    }
                    // let's make sure that the bulk action limit trips, one single execution will index all the documents
import java.util.HashSet;
                    .setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        try (
                    .setGlobalPipeline("pipeline_id")
        return IntStream.rangeClosed(1, numDocs).boxed().map(n -> hasId(n.toString())).<Matcher<SearchHit>>toArray(Matcher[]::new);
                + "}"
import org.opensearch.action.get.MultiGetRequest;
            assertThat(listener.bulkFailures.size(), equalTo(0));
                .setBulkActions(numDocs)
                    .setConcurrentRequests(randomIntBetween(0, 1))
        try (BulkProcessor processor = initBulkProcessorBuilder(listener)
public class BulkProcessorIT extends OpenSearchRestHighLevelClientTestCase {
import org.opensearch.core.common.bytes.BytesArray;
                .source(MediaTypeRegistry.JSON, "user", "some user"));
        BulkProcessorTestListener listener = new BulkProcessorTestListener(latch, closeLatch);
                assertThat(readOnlyIds.add(bulkItemResponse.getId()), equalTo(true));
            assertResponseItems(listener.bulkItems, numDocs);
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
        for (BulkItemResponse bulkItemResponse : bulkItemResponses) {
 * under the License.
        for (Throwable bulkFailure : listener.bulkFailures) {
            assertThat(listener.afterCounts.get(), equalTo(expectedBulkActions));
            .setBulkSize(new ByteSizeValue(randomIntBetween(1, 10), RandomPicks.randomFrom(random(), ByteSizeUnit.values())))
import org.opensearch.action.index.IndexRequest;
    private static BulkProcessor.Builder initBulkProcessorBuilder(BulkProcessor.Listener listener) {
        MultiGetRequest multiGetRequest = new MultiGetRequest();
            this.latches = latches;
        private final AtomicInteger beforeCounts = new AtomicInteger();
                .setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))
            // with concurrent requests > 1 we can't rely on the order of the bulk requests
        }
        private final AtomicInteger afterCounts = new AtomicInteger();
            bulkItems.addAll(Arrays.asList(response.getItems()));
        return BulkProcessor.builder(
                    processor.add(new IndexRequest("test").id(Integer.toString(testDocs)).source(MediaTypeRegistry.JSON, "field", "value"));
                BulkProcessor processor = initBulkProcessorBuilder(listener)
        int numDocs = randomIntBetween(bulkActions, bulkActions + 100);
        latch.await();
 */
                    .setGlobalIndex("test")
            // let's make sure that the bulk action limit trips, one single execution will index all the documents
                latch.await();
        if (localIndex != null) {
        }
    private MultiGetRequest indexDocs(BulkProcessor processor, int numDocs) throws Exception {
            processor.flush();
 * the Apache License, Version 2.0 (the "License"); you may
                    .setBulkActions(numDocs)
import org.opensearch.common.unit.TimeValue;
            final CountDownLatch latch = new CountDownLatch(1);
        MultiGetRequest multiGetRequest = indexDocs(processor, numDocs);
                + "        \"index\" : {\n"
        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
        assertThat(listener.beforeCounts.get(), greaterThanOrEqualTo(1));
    @SuppressWarnings("unchecked")
    }
            action.field("_index", localIndex);
        Request request = new Request("PUT", "/test-ro");
        final CountDownLatch latch = new CountDownLatch(1);
            try (
            latch.await();
            .build();
                .setBulkActions(bulkActions)
 * ownership. Elasticsearch licenses this file to you under
    public void testBulkProcessorConcurrentRequestsReadOnlyIndex() throws Exception {
        assertMultiGetResponse(highLevelClient().mget(multiGetRequest, RequestOptions.DEFAULT), testDocs);
 * license agreements. See the NOTICE file distributed with
                indexDocs(processor, numDocs, null, "test", "pipeline_id");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasProperty;
    }
        Iterable<SearchHit> hits = searchAll(new SearchRequest("tweets").routing("routing"));
        int bulkActions = randomIntBetween(10, 100);
            assertThat(bulkItemResponse.getId(), equalTo(Integer.toString(i++)));
 */
        BulkProcessorTestListener listener = new BulkProcessorTestListener(latch);
                BytesArray data = bytesBulkRequest(localIndex, i);
    @Override
import java.util.concurrent.CopyOnWriteArrayList;
        assertThat(hits, everyItem(hasProperty(fieldFromSource("fieldNameXYZ"), equalTo("valueXYZ"))));
            .setBulkActions(numDocs)
        int concurrentRequests = randomIntBetween(0, 10);
                latch.countDown();
            assertThat(bulkItemResponse.getFailureMessage(), bulkItemResponse.isFailed(), equalTo(false));
            .setFlushInterval(TimeValue.timeValueHours(24))
                .build()) {
        }
import org.hamcrest.Matcher;
        int numDocs = randomIntBetween(10, 100);
                // with concurrent requests > 1 we can't rely on the order of the bulk requests
 * compatible open source license.
}
            latch.await();
        MultiGetRequest multiGetRequest = new MultiGetRequest();
                .setBulkActions(numDocs + randomIntBetween(1, 100))
            (request, bulkListener) -> highLevelClient().bulkAsync(request, RequestOptions.DEFAULT, bulkListener),
 * this file be licensed under the Apache-2.0 license or a
            assertThat(bulkItemResponse.getIndex(), either(equalTo("test")).or(equalTo("test-ro")));
        createFieldAddingPipleine("pipeline_id", "fieldNameXYZ", "valueXYZ");
            BulkProcessorTestListener listener = new BulkProcessorTestListener(latch);
import org.opensearch.action.bulk.BulkProcessor;
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
        final CountDownLatch latch = new CountDownLatch(expectedBulkActions);
 * KIND, either express or implied.  See the License for the
    private MultiGetRequest indexDocs(BulkProcessor processor, int numDocs, String localIndex, String globalIndex, String globalPipeline)
            assertThat(latch.await(randomInt(500), TimeUnit.MILLISECONDS), equalTo(false));
        assertThat(hits, everyItem(hasProperty(fieldFromSource("user"), equalTo("some user"))));
 * software distributed under the License is distributed on an
        assertMultiGetResponse(highLevelClient().mget(multiGetRequest, RequestOptions.DEFAULT), numDocs);
                // let's make sure we get at least 1 item in the MultiGetRequest regardless of the randomising roulette
 *
            MultiGetRequest multiGetRequest = indexDocs(processor, numDocs);
        assertThat(listener.beforeCounts.get(), equalTo(totalExpectedBulkActions));
                "item " + i + " failed with cause: " + bulkItemResponse.getFailureMessage(),
            assertMultiGetResponse(highLevelClient().mget(multiGetRequest, RequestOptions.DEFAULT), numDocs);
                    .build()
                }
 * SPDX-License-Identifier: Apache-2.0
                assertThat(processor.awaitClose(1, TimeUnit.MINUTES), is(true));
                    new IndexRequest(localIndex).id(Integer.toString(i))
        assertThat(listener.afterCounts.get(), equalTo(totalExpectedBulkActions));
            BulkProcessor processor = initBulkProcessorBuilder(listener)
            assertThat(listener.bulkFailures.size(), equalTo(0));
        private final CountDownLatch[] latches;
        }
            assertThat(listener.afterCounts.get(), equalTo(1));
            }
        }
            afterCounts.incrementAndGet();
                if (randomBoolean() || multiGetRequest.getItems().size() == 0) {
                assertThat(listener.bulkFailures.size(), equalTo(0));
import java.util.concurrent.atomic.AtomicInteger;
        final CountDownLatch latch = new CountDownLatch(expectedBulkActions);
        assertThat(bulkItemResponses.size(), is(numDocs));
            multiGetRequest = indexDocs(processor, numDocs);
                .setFlushInterval(TimeValue.timeValueHours(24))
        int i = 1;
            }
        public void beforeBulk(long executionId, BulkRequest request) {
        if (randomBoolean()) { // check if we can call it multiple times
        ) {
    public void testThatBulkProcessorCountIsCorrect() throws Exception {
                processor.add(
                .setGlobalRouting("routing")
        int numDocs = randomIntBetween(bulkActions, bulkActions + 100);
                .setFlushInterval(TimeValue.timeValueHours(24))
            afterCounts.incrementAndGet();
import org.opensearch.action.bulk.BulkItemResponse;
        assertThat(listener.bulkFailures.size(), equalTo(0));
        int i = 1;
        Set<String> ids = new HashSet<>();
                .setGlobalPipeline("pipeline_id")
import java.util.concurrent.TimeUnit;
/*
        assertThat(listener.afterCounts.get(), equalTo(totalExpectedBulkActions));
    }
        closeLatch.await();
            assertThat(ids.add(bulkItemResponse.getId()), equalTo(true));
        action.field("_id", Integer.toString(id));
    }
        }
    }
        closeLatch.await();
    private static BytesArray bytesBulkRequest(String localIndex, int id) throws IOException {
                // we do want to check that we don't get duplicate ids back
        ) {
        }
                + "    \n"
        }
    }
    }
                processor.close();
            "{\n"
                .setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))
        }
        assertThat(processor.awaitClose(1, TimeUnit.MINUTES), is(true));
        }
        Set<String> ids = new HashSet<>();
        action.endObject().endObject();
            assertThat(bulkItemResponse.getIndex(), equalTo("test"));
        return false;
            BulkProcessor processor = initBulkProcessorBuilder(listener).setConcurrentRequests(concurrentRequests)
 * not use this file except in compliance with the License.
                .setConcurrentRequests(randomIntBetween(0, 1))
            assertThat(multiGetItemResponse.getIndex(), equalTo("test"));
    }
                assertThat(listener.afterCounts.get(), equalTo(1));
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
            assertThat(listener.beforeCounts.get(), equalTo(expectedBulkActions));
import org.opensearch.action.search.SearchRequest;
import java.util.List;
        int expectedBulkActions = numDocs / bulkActions;
    }
import static org.hamcrest.Matchers.either;
            bulkFailures.add(failure);
        assertThat(blogs, everyItem(hasProperty(fieldFromSource("fieldNameXYZ"), equalTo("valueXYZ"))));
            } else {
            );
import java.util.Arrays;
        assertThat(listener.beforeCounts.get(), equalTo(totalExpectedBulkActions));
import static org.hamcrest.Matchers.is;
        return indexDocs(processor, numDocs, "test", null, null);
        return new BytesArray(request);
                    .setFlushInterval(TimeValue.timeValueHours(24))
        public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
            for (CountDownLatch latch : latches) {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            assertThat(bulkItemResponse.getIndex(), equalTo("test"));
            assertThat(listener.bulkItems.size(), equalTo(numDocs - numDocs % bulkActions));
import static org.hamcrest.Matchers.both;
                    );
        int numDocs = randomIntBetween(10, 10);
        {
                processor.add(data, globalIndex, globalPipeline, MediaTypeRegistry.JSON);
                assertThat(hits, everyItem(hasProperty(fieldFromSource("fieldNameXYZ"), equalTo("valueXYZ"))));
                    processor.add(
        try (
        final CountDownLatch latch = new CountDownLatch(1);
        public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
        Iterable<SearchHit> blogs = searchAll(new SearchRequest("blogs").routing("routing"));
                        new IndexRequest("test-ro").id(Integer.toString(testReadOnlyDocs)).source(MediaTypeRegistry.JSON, "field", "value")
                } else {
        assertThat(listener.afterCounts.get(), greaterThanOrEqualTo(1));
import static org.hamcrest.Matchers.everyItem;
        }
        private BulkProcessorTestListener(CountDownLatch... latches) {
            processor.add(new IndexRequest("blogs").id("1") // <2>
    public void testBulkProcessorWaitOnClose() throws Exception {
    private static void assertMultiGetResponse(MultiGetResponse multiGetResponse, int numDocs) {
 * specific language governing permissions and limitations
import org.opensearch.action.get.MultiGetResponse;
            BulkProcessor processor = initBulkProcessorBuilder(listener)
                // let's make sure that this bulk won't be automatically flushed
        try (
    }
            logger.error("bulk failure", bulkFailure);
        request.setJsonEntity(
        assertThat(multiGetResponse.getResponses().length, equalTo(numDocs));
        createIndexWithMultipleShards("test");
 *
            assertThat(listener.bulkFailures.size(), equalTo(0));
                // with concurrent requests > 1 we can't rely on the order of the bulk requests
                    testReadOnlyDocs++;
        }
        XContentBuilder source = jsonBuilder().startObject().field("field", randomRealisticUnicodeOfLengthBetween(1, 30)).endObject();
            // we do want to check that we don't get duplicate ids back
                assertThat(bulkItemResponse.isFailed(), equalTo(false));
import org.opensearch.action.bulk.BulkRequest;
        ) {
 * GitHub history for details.
            assertThat(Integer.valueOf(bulkItemResponse.getId()), both(greaterThan(0)).and(lessThanOrEqualTo(numDocs)));
    }
        BulkProcessorTestListener listener = new BulkProcessorTestListener(latch, closeLatch);
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.containsInAnyOrder;
        BulkProcessor processor = initBulkProcessorBuilder(listener)
        return multiGetRequest;
                assertThat(bulkItemResponse.isFailed(), equalTo(true));
        int numDocs = randomIntBetween(10, 100);
package org.opensearch.client;
        int testReadOnlyDocs = 0;
                .build()
                .setFlushInterval(TimeValue.timeValueHours(24))
        Set<String> readOnlyIds = new HashSet<>();
                bulkItemResponse.isFailed(),
 * Unless required by applicable law or agreed to in writing,
            }
                    multiGetRequest.add("test", Integer.toString(testDocs));
        );
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to
        for (BulkItemResponse bulkItemResponse : listener.bulkItems) {
    public void testGlobalParametersAndBulkProcessor() throws Exception {
            } else {
import org.opensearch.core.common.unit.ByteSizeValue;
        MultiGetRequest multiGetRequest;
            BulkProcessor processor = initBulkProcessorBuilder(listener).setConcurrentRequests(concurrentRequests)
            assertThat(listener.beforeCounts.get(), equalTo(1));
        assertMultiGetResponse(highLevelClient().mget(multiGetRequest, RequestOptions.DEFAULT), numDocs);
            } else {
                .setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))
    public void testGlobalParametersAndSingleRequest() throws Exception {
            if (bulkItemResponse.getIndex().equals("test")) {
            assertThat(multiGetItemResponse.getId(), equalTo(Integer.toString(i++)));
                .build()
    private static void assertResponseItems(List<BulkItemResponse> bulkItemResponses, int numDocs) {
import java.util.Set;
        for (BulkItemResponse bulkItemResponse : listener.bulkItems) {
        for (int i = 1; i <= numDocs; i++) {
        );
        }
            listener
        assertThat(listener.bulkItems.size(), equalTo(testDocs + testReadOnlyDocs));
                // set interval and size to high values
        createIndexWithMultipleShards("test");
        int totalExpectedBulkActions = numDocs % bulkActions == 0 ? expectedBulkActions : expectedBulkActions + 1;
                // set interval and size to high values
        // tag::bulk-processor-mix-parameters
/*
 * this work for additional information regarding copyright
                latch.countDown();
            multiGetRequest.add(localIndex, Integer.toString(i));
        assertThat(listener.bulkFailures.size(), equalTo(0));
            beforeCounts.incrementAndGet();
                assertThat(Integer.valueOf(bulkItemResponse.getId()), both(greaterThan(0)).and(lessThanOrEqualTo(testDocs)));
            for (CountDownLatch latch : latches) {
import java.io.IOException;
            assertThat(listener.beforeCounts.get(), equalTo(1));
                assertThat(listener.beforeCounts.get(), equalTo(1));
            if (randomBoolean()) {
                assertResponseItems(listener.bulkItems, numDocs);
            }
                .setGlobalIndex("tweets")
import java.util.stream.IntStream;
        try (
import java.util.concurrent.CountDownLatch;
        BulkProcessorTestListener listener = new BulkProcessorTestListener(latch);
            assertThat(
        assertThat(listener.bulkFailures.size(), equalTo(0));
import org.opensearch.core.common.unit.ByteSizeUnit;
            }
        for (MultiGetItemResponse multiGetItemResponse : multiGetResponse) {
        throws Exception {
import org.opensearch.action.bulk.BulkResponse;
            MultiGetRequest multiGetRequest = indexDocs(processor, numDocs);
        BulkProcessorTestListener listener = new BulkProcessorTestListener();
                equalTo(false)
        }
                .setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))
        int bulkActions = randomIntBetween(10, 100);
                .build()
        @Override
                .setBulkActions(bulkActions)
        int totalExpectedBulkActions = numDocs % bulkActions == 0 ? expectedBulkActions : expectedBulkActions + 1;
                // let's make sure that the bulk action limit trips, one single execution will index all the documents
        private final List<Throwable> bulkFailures = new CopyOnWriteArrayList<>();
            assertMultiGetResponse(highLevelClient().mget(multiGetRequest, RequestOptions.DEFAULT), numDocs);
        @Override
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        final CountDownLatch closeLatch = new CountDownLatch(totalExpectedBulkActions);
        @Override
            if (randomBoolean()) {
            assertResponseItems(listener.bulkItems, numDocs);
        assertThat(listener.bulkItems.size(), equalTo(numDocs));
import org.opensearch.action.get.MultiGetItemResponse;
    }
        Response response = client().performRequest(request);
 *
    private static class BulkProcessorTestListener implements BulkProcessor.Listener {
        }
                assertThat(Integer.valueOf(bulkItemResponse.getId()), both(greaterThan(0)).and(lessThanOrEqualTo(testReadOnlyDocs)));
        XContentBuilder action = jsonBuilder().startObject().startObject("index");
            .setConcurrentRequests(randomIntBetween(0, 1))
    protected boolean enableWarningsCheck() {
    public void testBulkProcessorConcurrentRequests() throws Exception {
        createFieldAddingPipleine("pipeline_id", "fieldNameXYZ", "valueXYZ");
    private Matcher<SearchHit>[] expectedIds(int numDocs) {
        BulkProcessorTestListener listener = new BulkProcessorTestListener(latch);
        String request = action + "\n" + source + "\n";
            ) {
                + "    \"settings\" : {\n"
        int testDocs = 0;
 */
        int numDocs = randomIntBetween(10, 100);
                .source(MediaTypeRegistry.JSON, "title", "some title"));
                    testDocs++;
/*
            // we really need an explicit flush as none of the bulk thresholds was reached
        private final List<BulkItemResponse> bulkItems = new CopyOnWriteArrayList<>();
                .setFlushInterval(TimeValue.timeValueHours(24))
                        .source(MediaTypeRegistry.JSON, "field", randomRealisticUnicodeOfLengthBetween(1, 30))
        assertResponseItems(listener.bulkItems, numDocs);
        assertThat(blogs, everyItem(hasProperty(fieldFromSource("title"), equalTo("some title"))));
        final CountDownLatch latch = new CountDownLatch(1);
                .setConcurrentRequests(randomIntBetween(0, 10))
