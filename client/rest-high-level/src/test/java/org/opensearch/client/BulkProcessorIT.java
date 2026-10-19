                    .setConcurrentRequests(randomIntBetween(0, 1))
        BulkProcessorTestListener listener = new BulkProcessorTestListener(latch, closeLatch);
        MultiGetRequest multiGetRequest = indexDocs(processor, numDocs);
                .source(MediaTypeRegistry.JSON, "title", "some title"));
            .build();
        ) {
            latch.await();  
        try (  
        }
            assertThat(bulkItemResponse.getFailureMessage(), bulkItemResponse.isFailed(), equalTo(false));
        final CountDownLatch latch = new CountDownLatch(expectedBulkActions);
                .setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))
        return IntStream.rangeClosed(1, numDocs).boxed().map(n -> hasId(n.toString())).<Matcher<SearchHit>>toArray(Matcher[]::new);
                    testDocs++;  
        public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {  
                + "    }\n"
            "{\n"  
import java.io.IOException;  
 * KIND, either express or implied.  See the License for the
        Set<String> ids = new HashSet<>();
                    .setGlobalIndex("test")
import org.opensearch.core.common.unit.ByteSizeValue;  
                    .setBulkActions(numDocs)
        MultiGetRequest multiGetRequest;
        ) {
 * Modifications Copyright OpenSearch Contributors. See
        int totalExpectedBulkActions = numDocs % bulkActions == 0 ? expectedBulkActions : expectedBulkActions + 1;
                .setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))  
                    .setGlobalRouting("routing")  
        if (localIndex != null) {
                // with concurrent requests > 1 we can't rely on the order of the bulk requests
        Set<String> ids = new HashSet<>();  
            processor.add(new IndexRequest() // <1>
    private static class BulkProcessorTestListener implements BulkProcessor.Listener {  
                // let's make sure that the bulk action limit trips, one single execution will index all the documents
        action.endObject().endObject();
                .setBulkActions(bulkActions)  
        int totalExpectedBulkActions = numDocs % bulkActions == 0 ? expectedBulkActions : expectedBulkActions + 1;  
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
}  
            afterCounts.incrementAndGet();
        throws Exception {  
    }
        final CountDownLatch latch = new CountDownLatch(1);
        }  
            multiGetRequest.add(localIndex, Integer.toString(i));  
 * not use this file except in compliance with the License.
            this.latches = latches;  
            }
            processor.add(new IndexRequest("blogs").id("1") // <2>
            BulkProcessorTestListener listener = new BulkProcessorTestListener(latch);  
                // let's make sure we get at least 1 item in the MultiGetRequest regardless of the randomising roulette
import java.util.Arrays;
        }  
import org.opensearch.action.bulk.BulkResponse;  
 * Licensed to Elasticsearch under one or more contributor  
            .setConcurrentRequests(randomIntBetween(0, 1))
                // set interval and size to high values
                .setGlobalPipeline("pipeline_id")
        public void beforeBulk(long executionId, BulkRequest request) {
        Request request = new Request("PUT", "/test-ro");
                }
        request.setJsonEntity(
                assertThat(listener.afterCounts.get(), equalTo(1));  
            BulkProcessor processor = initBulkProcessorBuilder(listener).setConcurrentRequests(concurrentRequests)
    public void testBulkProcessorWaitOnClose() throws Exception {
 */  
            MultiGetRequest multiGetRequest = indexDocs(processor, numDocs);  
                .setBulkActions(numDocs + randomIntBetween(1, 100))
                .build()  
        final CountDownLatch latch = new CountDownLatch(expectedBulkActions);  
        }  
package org.opensearch.client;
        private BulkProcessorTestListener(CountDownLatch... latches) {
import static org.hamcrest.Matchers.either;
            assertThat(listener.bulkFailures.size(), equalTo(0));  
        public void afterBulk(long executionId, BulkRequest request, Throwable failure) {  
        MultiGetRequest multiGetRequest = new MultiGetRequest();
 *  
                    multiGetRequest.add("test", Integer.toString(testDocs));
                assertThat(ids.add(bulkItemResponse.getId()), equalTo(true));
        for (BulkItemResponse bulkItemResponse : bulkItemResponses) {
                latch.await();  
        @Override  
        BulkProcessor processor = initBulkProcessorBuilder(listener)
        try (BulkProcessor processor = initBulkProcessorBuilder(listener)
 * specific language governing permissions and limitations
 */  
                .build()
import org.opensearch.action.bulk.BulkRequest;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.fieldFromSource;  
 * this work for additional information regarding copyright
        }  
                if (randomBoolean() || multiGetRequest.getItems().size() == 0) {
        Iterable<SearchHit> hits = searchAll(new SearchRequest("tweets").routing("routing"));
            assertThat(listener.afterCounts.get(), equalTo(1));
import org.opensearch.action.bulk.BulkProcessor;
        @Override
        action.field("_id", Integer.toString(id));  
import static org.hamcrest.Matchers.greaterThan;
                .setFlushInterval(TimeValue.timeValueHours(24))
            if (randomBoolean()) {
                .setGlobalIndex("tweets")
        Set<String> readOnlyIds = new HashSet<>();
            assertThat(multiGetItemResponse.getIndex(), equalTo("test"));
    public void testBulkProcessorFlush() throws Exception {  
            }
        assertThat(blogs, everyItem(hasProperty(fieldFromSource("fieldNameXYZ"), equalTo("valueXYZ"))));
                assertThat(processor.awaitClose(1, TimeUnit.MINUTES), is(true));
    private static void assertMultiGetResponse(MultiGetResponse multiGetResponse, int numDocs) {  
    }
 * compatible open source license.
        Iterable<SearchHit> blogs = searchAll(new SearchRequest("blogs").routing("routing"));
 * SPDX-License-Identifier: Apache-2.0
        final CountDownLatch latch = new CountDownLatch(1);
            assertThat(bulkItemResponse.getIndex(), either(equalTo("test")).or(equalTo("test-ro")));
        }  
        assertThat(hits, everyItem(hasProperty(fieldFromSource("user"), equalTo("some user"))));
            // let's make sure that the bulk action limit trips, one single execution will index all the documents  
            .setBulkSize(new ByteSizeValue(randomIntBetween(1, 10), RandomPicks.randomFrom(random(), ByteSizeUnit.values())))
            .setBulkActions(numDocs)
            // we really need an explicit flush as none of the bulk thresholds was reached
import static org.hamcrest.Matchers.is;
import java.util.Set;
    }
            assertThat(listener.afterCounts.get(), equalTo(expectedBulkActions));  
                + "}"
        try (
                } else {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testBulkProcessorConcurrentRequests() throws Exception {
                    .build()
 * this file be licensed under the Apache-2.0 license or a
                + "    \"settings\" : {\n"
        }
        closeLatch.await();  
import org.opensearch.action.get.MultiGetItemResponse;
            } else {  
        int i = 1;  
            assertMultiGetResponse(highLevelClient().mget(multiGetRequest, RequestOptions.DEFAULT), numDocs);  
 */
        ) {
            latch.await();  
    public void testGlobalParametersAndSingleRequest() throws Exception {
    public void testThatBulkProcessorCountIsCorrect() throws Exception {  
                latch.countDown();
    private MultiGetRequest indexDocs(BulkProcessor processor, int numDocs) throws Exception {  
                .setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))
            // with concurrent requests > 1 we can't rely on the order of the bulk requests
    public void testBulkProcessorConcurrentRequestsReadOnlyIndex() throws Exception {  
        }  
        MultiGetRequest multiGetRequest = new MultiGetRequest();  
import static org.hamcrest.Matchers.equalTo;  
    @Override  
            assertResponseItems(listener.bulkItems, numDocs);
 * The OpenSearch Contributors require contributions made to  
        createIndexWithMultipleShards("test");
        int bulkActions = randomIntBetween(10, 100);
                equalTo(false)
    }  
import org.opensearch.action.get.MultiGetResponse;  
                + "    \n"  
                    .setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))
            assertThat(multiGetItemResponse.getId(), equalTo(Integer.toString(i++)));
            final CountDownLatch latch = new CountDownLatch(1);
                // let's make sure that this bulk won't be automatically flushed
            }
 *
            if (bulkItemResponse.getIndex().equals("test")) {
 * Unless required by applicable law or agreed to in writing,
        assertThat(listener.afterCounts.get(), greaterThanOrEqualTo(1));  
            action.field("_index", localIndex);  
        assertThat(listener.beforeCounts.get(), equalTo(totalExpectedBulkActions));
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
import org.opensearch.action.index.IndexRequest;
            assertThat(listener.bulkItems.size(), equalTo(numDocs - numDocs % bulkActions));
    }  
        }
        int numDocs = randomIntBetween(bulkActions, bulkActions + 100);  
                assertThat(bulkItemResponse.isFailed(), equalTo(false));  
            );
        final CountDownLatch closeLatch = new CountDownLatch(totalExpectedBulkActions);
 *
        );
import org.opensearch.core.common.unit.ByteSizeUnit;
            } else {
                        .source(MediaTypeRegistry.JSON, "field", randomRealisticUnicodeOfLengthBetween(1, 30))  
                .setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))  
        String request = action + "\n" + source + "\n";
    }
            assertThat(listener.bulkFailures.size(), equalTo(0));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasProperty;
                "item " + i + " failed with cause: " + bulkItemResponse.getFailureMessage(),
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import java.util.concurrent.TimeUnit;
        private final List<BulkItemResponse> bulkItems = new CopyOnWriteArrayList<>();
import org.opensearch.core.xcontent.XContentBuilder;
        // tag::bulk-processor-mix-parameters  
        for (int i = 1; i <= numDocs; i++) {
                .build()  
        assertThat(multiGetResponse.getResponses().length, equalTo(numDocs));
public class BulkProcessorIT extends OpenSearchRestHighLevelClientTestCase {
        assertMultiGetResponse(highLevelClient().mget(multiGetRequest, RequestOptions.DEFAULT), numDocs);  
        return new BytesArray(request);  
        int numDocs = randomIntBetween(10, 10);  
    private static void assertResponseItems(List<BulkItemResponse> bulkItemResponses, int numDocs) {
        return indexDocs(processor, numDocs, "test", null, null);
        createFieldAddingPipleine("pipeline_id", "fieldNameXYZ", "valueXYZ");
            assertThat(ids.add(bulkItemResponse.getId()), equalTo(true));
            assertThat(listener.afterCounts.get(), equalTo(1));  
            BulkProcessor processor = initBulkProcessorBuilder(listener)
        BulkProcessorTestListener listener = new BulkProcessorTestListener();
 * software distributed under the License is distributed on an
                .source(MediaTypeRegistry.JSON, "user", "some user"));  
        }  
    }
            logger.error("bulk failure", bulkFailure);
    }
        private final AtomicInteger beforeCounts = new AtomicInteger();  
import org.hamcrest.Matcher;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;
    }
        final CountDownLatch closeLatch = new CountDownLatch(totalExpectedBulkActions);
        try (
        createIndexWithMultipleShards("test");  
    private MultiGetRequest indexDocs(BulkProcessor processor, int numDocs, String localIndex, String globalIndex, String globalPipeline)
                    .setFlushInterval(TimeValue.timeValueHours(24))  
                processor.close();
            assertThat(listener.beforeCounts.get(), equalTo(1));
                    // let's make sure that the bulk action limit trips, one single execution will index all the documents  
                .setFlushInterval(TimeValue.timeValueHours(24))
        int numDocs = randomIntBetween(10, 100);
import java.util.stream.IntStream;  
        int expectedBulkActions = numDocs / bulkActions;
        for (BulkItemResponse bulkItemResponse : listener.bulkItems) {  
        closeLatch.await();
            bulkFailures.add(failure);
            assertMultiGetResponse(highLevelClient().mget(multiGetRequest, RequestOptions.DEFAULT), numDocs);
        ) {
import org.opensearch.common.unit.TimeValue;  
        return false;
        assertMultiGetResponse(highLevelClient().mget(multiGetRequest, RequestOptions.DEFAULT), testDocs);
    @SuppressWarnings("unchecked")  
import org.opensearch.core.common.bytes.BytesArray;
        int bulkActions = randomIntBetween(10, 100);  
            if (randomBoolean()) {  
                indexDocs(processor, numDocs, null, "test", "pipeline_id");
                    processor.add(
                assertThat(hits, everyItem(hasProperty(fieldFromSource("fieldNameXYZ"), equalTo("valueXYZ"))));  
        int testReadOnlyDocs = 0;
        }  
        private final CountDownLatch[] latches;
import org.opensearch.action.search.SearchRequest;
    }  
import java.util.List;  
import org.opensearch.search.SearchHit;  
                BulkProcessor processor = initBulkProcessorBuilder(listener)
        for (Throwable bulkFailure : listener.bulkFailures) {
        int numDocs = randomIntBetween(10, 100);
    }
        int concurrentRequests = randomIntBetween(0, 10);
        assertThat(listener.bulkItems.size(), equalTo(testDocs + testReadOnlyDocs));
                .build()) {
            } else {
            listener
                    testReadOnlyDocs++;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertThat(listener.bulkItems.size(), equalTo(numDocs));
            try (
/*
            assertThat(
    }
        BulkProcessorTestListener listener = new BulkProcessorTestListener(latch);
        );  
        return BulkProcessor.builder(  
            beforeCounts.incrementAndGet();
                .setConcurrentRequests(randomIntBetween(0, 1))
                assertThat(bulkItemResponse.isFailed(), equalTo(true));  
/*  
                .setConcurrentRequests(randomIntBetween(0, 10))  
import java.util.concurrent.CopyOnWriteArrayList;
                + "        \"index\" : {\n"
        latch.await();
import java.util.concurrent.CountDownLatch;  
                .setBulkActions(bulkActions)
import java.util.HashSet;
            }  
    private Matcher<SearchHit>[] expectedIds(int numDocs) {
        int numDocs = randomIntBetween(10, 100);
                .setFlushInterval(TimeValue.timeValueHours(24))
            for (CountDownLatch latch : latches) {  
        assertThat(hits, everyItem(hasProperty(fieldFromSource("fieldNameXYZ"), equalTo("valueXYZ"))));  
        if (randomBoolean()) { // check if we can call it multiple times  
        return multiGetRequest;
        int numDocs = randomIntBetween(bulkActions, bulkActions + 100);
                    .setGlobalPipeline("pipeline_id")
import static org.hamcrest.Matchers.containsInAnyOrder;
                assertThat(listener.bulkFailures.size(), equalTo(0));
                // set interval and size to high values  
        assertThat(listener.bulkFailures.size(), equalTo(0));
            latch.await();
                assertThat(Integer.valueOf(bulkItemResponse.getId()), both(greaterThan(0)).and(lessThanOrEqualTo(testDocs)));
        assertThat(listener.beforeCounts.get(), greaterThanOrEqualTo(1));
    private static BytesArray bytesBulkRequest(String localIndex, int id) throws IOException {
            assertThat(latch.await(randomInt(500), TimeUnit.MILLISECONDS), equalTo(false));  
        XContentBuilder action = jsonBuilder().startObject().startObject("index");  
                        new IndexRequest("test-ro").id(Integer.toString(testReadOnlyDocs)).source(MediaTypeRegistry.JSON, "field", "value")  
        assertResponseItems(listener.bulkItems, numDocs);
            assertThat(bulkItemResponse.getId(), equalTo(Integer.toString(i++)));  
                + "            \"blocks.write\" : true\n"  
                    processor.add(new IndexRequest("test").id(Integer.toString(testDocs)).source(MediaTypeRegistry.JSON, "field", "value"));
        for (MultiGetItemResponse multiGetItemResponse : multiGetResponse) {  
                assertThat(readOnlyIds.add(bulkItemResponse.getId()), equalTo(true));
        assertThat(blogs, everyItem(hasProperty(fieldFromSource("title"), equalTo("some title"))));  
            .setFlushInterval(TimeValue.timeValueHours(24))  
            assertThat(bulkItemResponse.getIndex(), equalTo("test"));
            BulkProcessor processor = initBulkProcessorBuilder(listener)  
        }
    }  
                assertThat(Integer.valueOf(bulkItemResponse.getId()), both(greaterThan(0)).and(lessThanOrEqualTo(testReadOnlyDocs)));
                .setGlobalRouting("routing")  
        BulkProcessorTestListener listener = new BulkProcessorTestListener(latch);  
                    new IndexRequest(localIndex).id(Integer.toString(i))
        assertThat(listener.bulkFailures.size(), equalTo(0));  
            bulkItems.addAll(Arrays.asList(response.getItems()));
        assertThat(listener.afterCounts.get(), equalTo(totalExpectedBulkActions));
                .setFlushInterval(TimeValue.timeValueHours(24))
        int expectedBulkActions = numDocs / bulkActions;  
            BulkProcessor processor = initBulkProcessorBuilder(listener).setConcurrentRequests(concurrentRequests)
            assertThat(bulkItemResponse.getIndex(), equalTo("test"));  
            ) {  
        // end::bulk-processor-mix-parameters
import static org.hamcrest.Matchers.everyItem;
        XContentBuilder source = jsonBuilder().startObject().field("field", randomRealisticUnicodeOfLengthBetween(1, 30)).endObject();  
    public void testGlobalParametersAndBulkProcessor() throws Exception {
        Response response = client().performRequest(request);  
    }
    }
    protected boolean enableWarningsCheck() {
                Iterable<SearchHit> hits = searchAll(new SearchRequest("test").routing("routing"));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertThat(bulkItemResponses.size(), is(numDocs));
        int i = 1;
        final CountDownLatch latch = new CountDownLatch(1);
            }
        private final List<Throwable> bulkFailures = new CopyOnWriteArrayList<>();  
        }  
    }
        int testDocs = 0;
                .setBulkActions(numDocs)  
        BulkProcessorTestListener listener = new BulkProcessorTestListener(latch, closeLatch);  
import org.opensearch.action.bulk.BulkItemResponse;  
                // with concurrent requests > 1 we can't rely on the order of the bulk requests
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
 * under the License.  
            afterCounts.incrementAndGet();
        }  
        int concurrentRequests = randomIntBetween(0, 7);
        assertThat(processor.awaitClose(1, TimeUnit.MINUTES), is(true));
                );
            assertResponseItems(listener.bulkItems, numDocs);
            MultiGetRequest multiGetRequest = indexDocs(processor, numDocs);
        }  
    private static BulkProcessor.Builder initBulkProcessorBuilder(BulkProcessor.Listener listener) {
            assertThat(listener.beforeCounts.get(), equalTo(1));
/*  
                bulkItemResponse.isFailed(),  
        @Override
        }  
        try (  
                BytesArray data = bytesBulkRequest(localIndex, i);  
                .build()
        {
        assertThat(listener.bulkFailures.size(), equalTo(0));
 * the Apache License, Version 2.0 (the "License"); you may
                + "        }\n"
        BulkProcessorTestListener listener = new BulkProcessorTestListener(latch);
 * GitHub history for details.
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
        createFieldAddingPipleine("pipeline_id", "fieldNameXYZ", "valueXYZ");
            multiGetRequest = indexDocs(processor, numDocs);
            for (int i = 1; i <= numDocs; i++) {  
 * You may obtain a copy of the License at  
import java.util.concurrent.atomic.AtomicInteger;
            // we do want to check that we don't get duplicate ids back  
                processor.add(data, globalIndex, globalPipeline, MediaTypeRegistry.JSON);
                // we do want to check that we don't get duplicate ids back  
                assertThat(hits, containsInAnyOrder(expectedIds(numDocs)));
                assertThat(listener.beforeCounts.get(), equalTo(1));
import static org.hamcrest.Matchers.both;  
        }
        }
        assertMultiGetResponse(highLevelClient().mget(multiGetRequest, RequestOptions.DEFAULT), numDocs);
                    );
        private final AtomicInteger afterCounts = new AtomicInteger();
            assertThat(listener.bulkFailures.size(), equalTo(0));
            assertThat(listener.beforeCounts.get(), equalTo(expectedBulkActions));
                processor.add(
            (request, bulkListener) -> highLevelClient().bulkAsync(request, RequestOptions.DEFAULT, bulkListener),
        assertThat(listener.afterCounts.get(), equalTo(totalExpectedBulkActions));  
            }
            for (CountDownLatch latch : latches) {  
import org.opensearch.action.get.MultiGetRequest;
            processor.flush();
            assertThat(Integer.valueOf(bulkItemResponse.getId()), both(greaterThan(0)).and(lessThanOrEqualTo(numDocs)));
        assertThat(listener.beforeCounts.get(), equalTo(totalExpectedBulkActions));
                latch.countDown();
            }
                assertResponseItems(listener.bulkItems, numDocs);
                // we do want to check that we don't get duplicate ids back  
        for (BulkItemResponse bulkItemResponse : listener.bulkItems) {
