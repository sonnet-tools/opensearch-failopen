/*
        }
    @Override  
                int successfulShards = randomIntBetween(0, totalShards);
            MultiSearchTemplateResponse.Item actualItem = newInstance.getResponses()[i];
        int skippedClusters = totalClusters - successfulClusters;
                    totalShards,
        MultiSearchTemplateResponse.Item[] items = new MultiSearchTemplateResponse.Item[numItems];
            .startArray("root_cause")
        int numItems = randomIntBetween(0, 128);
 * SPDX-License-Identifier: Apache-2.0
            SearchTemplateResponse searchTemplateResponse = new SearchTemplateResponse();
 *    http://www.apache.org/licenses/LICENSE-2.0
            } else {
                    skippedShards,  
 * not use this file except in compliance with the License.
                int skippedShards = totalShards - successfulShards;  
        response.toXContent(actualResponse, ToXContent.EMPTY_PARAMS);
            if (randomBoolean()) {
                    tookInMillis,
            .startArray("responses")  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        );  
                InternalSearchResponse internalSearchResponse = InternalSearchResponse.empty();
                items[i] = new MultiSearchTemplateResponse.Item(searchTemplateResponse, null);  
    private static SearchResponse.Clusters randomClusters() {
        );
                    clusters  
            InternalSearchResponse internalSearchResponse = InternalSearchResponse.empty();  
            .endObject()  
        int totalClusters = randomIntBetween(0, 10);
        searchTemplateResponse.setResponse(searchResponse);
 *  
            .endObject()
 * license agreements. See the NOTICE file distributed with
        items[1] = new MultiSearchTemplateResponse.Item(null, new IllegalArgumentException("Invalid argument"));
            internalSearchResponse,
 * GitHub history for details.
            );  
import java.util.function.Predicate;
        InternalSearchResponse internalSearchResponse = InternalSearchResponse.empty();
            .field("max_score", 0.0F)  
    protected boolean supportsUnknownFields() {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
                SearchTemplateResponse searchTemplateResponse = new SearchTemplateResponse();  
        XContentType contentType = randomFrom(XContentType.values());
 */
        long overallTookInMillis = randomNonNegativeLong();
            .endObject()
                );
                clusters
            } else {
        return new MultiSearchTemplateResponse(items, overallTookInMillis);
        int totalShards = 2;
            .field("successful", 2)  
import org.opensearch.action.search.ShardSearchFailure;
                assertThat(actualItem.getFailure(), nullValue());
    public void testFromXContentWithFailures() throws IOException {
        SearchTemplateResponse searchTemplateResponse = new SearchTemplateResponse();
            .field("total", 2)
        assertToXContentEquivalent(BytesReference.bytes(expectedResponse), BytesReference.bytes(actualResponse), contentType);
            .field("reason", "Invalid argument")  
        for (int i = 0; i < expectedInstance.getResponses().length; i++) {
                tookInMillis,  
/*  
        assertThat(newInstance.getTook(), equalTo(expectedInstance.getTook()));  
            .endObject()
            .startObject("_shards")
                searchTemplateResponse.setResponse(searchResponse);
public class MultiSearchTemplateResponseTests extends AbstractXContentTestCase<MultiSearchTemplateResponse> {
            SearchResponse searchResponse = new SearchResponse(  
        for (int i = 0; i < numItems; i++) {  
            .field("relation", "eq")
            tookInMillis,  
    @Override
            searchTemplateResponse.setResponse(searchResponse);
        MultiSearchTemplateResponse.Item[] items = new MultiSearchTemplateResponse.Item[2];
    public void testToXContentWithFailures() throws Exception {
        boolean assertToXContentEquivalence = false;
import org.opensearch.core.common.Strings;
import org.opensearch.core.common.bytes.BytesReference;
            if (expectedItem.isFailure()) {
import org.opensearch.core.xcontent.XContentBuilder;
import java.util.function.Supplier;  
    }
            .endArray()  
    @Override
        int numItems = randomIntBetween(0, 128);  
 */  
    }
            }
            items[i] = new MultiSearchTemplateResponse.Item(searchTemplateResponse, null);
            .startObject()
            assertToXContentEquivalence,  
    protected MultiSearchTemplateResponse createTestInstance() {
            .field("took", 1)
        }  
    }  
            .field("status", 200)
                assertThat(actualItem.getResponse(), nullValue());  
    }  
                    successfulShards,
            long tookInMillis = randomNonNegativeLong();
    @Override
        boolean supportsUnknownFields = true;  
 */
        for (int i = 0; i < numItems; i++) {
        return new MultiSearchTemplateResponse(items, overallTookInMillis);
 * ownership. Elasticsearch licenses this file to you under  
            .startObject("total")
            .startObject()  
                totalShards,  
            MultiSearchTemplateResponse.Item expectedItem = expectedInstance.getResponses()[i];  
        return field -> field.startsWith("responses");
            .startArray("hits")
 * Modifications Copyright OpenSearch Contributors. See  
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    internalSearchResponse,
        }  
            int successfulShards = randomIntBetween(0, totalShards);
import org.opensearch.search.internal.InternalSearchResponse;
            .startObject("error")
}  
            .endObject()
     */
            instanceSupplier,
        int successfulShards = 2;
    /**  
            int totalShards = randomIntBetween(1, Integer.MAX_VALUE);  
        XContentBuilder actualResponse = MediaTypeRegistry.contentBuilder(contentType);
            .field("failed", 0)
    }  
            .startObject()
            skippedShards,
            this::assertEqualInstances,
            // is tested elsewhere.
import java.io.IOException;
    protected void assertEqualInstances(MultiSearchTemplateResponse expectedInstance, MultiSearchTemplateResponse newInstance) {
                long tookInMillis = randomNonNegativeLong();  
import org.opensearch.test.AbstractXContentTestCase;
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.Matchers.equalTo;
                items[i] = new MultiSearchTemplateResponse.Item(null, new OpenSearchException("an error"));
                int totalShards = randomIntBetween(1, Integer.MAX_VALUE);
            .field("type", "illegal_argument_exception")
        int successfulClusters = randomIntBetween(0, totalClusters);  
            .field("status", 400)
                    null,  
            totalShards,  
            successfulShards,
        int skippedShards = 0;  
        items[0] = new MultiSearchTemplateResponse.Item(searchTemplateResponse, null);
                SearchResponse searchResponse = new SearchResponse(
/*
                ShardSearchFailure.EMPTY_ARRAY,
                assertThat(actualItem.getResponse().toString(), equalTo(expectedItem.getResponse().toString()));  
            .startObject()
            this::createParser,  
            .field("took", overallTookInMillis)
                null,
 * specific language governing permissions and limitations
     * without failures, and this other test with failures where we disable asserting on xcontent equivalence at the end.  
    }
            .endObject();
            int skippedShards = totalShards - successfulShards;
 * software distributed under the License is distributed on an
 * compatible open source license.
import org.opensearch.OpenSearchException;  
        // with random fields insertion in the inner exceptions, some random stuff may be parsed back as metadata,
            }  
    }
import org.opensearch.action.search.SearchResponse;
            NUMBER_OF_TEST_RUNS,
        long overallTookInMillis = randomNonNegativeLong();  
                internalSearchResponse,
import static org.hamcrest.Matchers.nullValue;
    protected Predicate<String> getRandomFieldsExcludeFilterWhenResultHasErrors() {  
 * The OpenSearch Contributors require contributions made to  
                    ShardSearchFailure.EMPTY_ARRAY,
        XContentBuilder expectedResponse = MediaTypeRegistry.contentBuilder(contentType)  
            SearchResponse.Clusters clusters = randomClusters();
                SearchResponse.Clusters clusters = randomClusters();
        // exceptions are not of the same type whenever parsed back
     * Test parsing {@link MultiSearchTemplateResponse} with inner failures as they don't support asserting on xcontent equivalence, given
            Strings.EMPTY_ARRAY,
        long tookInMillis = 1L;  
        return true;  
            .endObject()  
                // Creating a minimal response is OK, because SearchResponse is tested elsewhere.
            null,
            // Creating a minimal response is OK, because SearchResponse self  
 *
    private static MultiSearchTemplateResponse createTestInstanceWithFailures() {
            SearchResponse.Clusters.EMPTY
package org.opensearch.script.mustache;
            .field("reason", "Invalid argument")
            getRandomFieldsExcludeFilterWhenResultHasErrors(),
        AbstractXContentTestCase.testFromXContent(  
        assertThat(newInstance.getResponses().length, equalTo(expectedInstance.getResponses().length));
        MultiSearchTemplateResponse.Item[] items = new MultiSearchTemplateResponse.Item[numItems];
import org.opensearch.core.xcontent.ToXContent;
    }
                successfulShards,
        SearchResponse searchResponse = new SearchResponse(  
            .field("skipped", 0)
 * under the License.  
        return new SearchResponse.Clusters(totalClusters, successfulClusters, skippedClusters);
import org.opensearch.common.xcontent.XContentType;  
    }
import org.opensearch.core.xcontent.XContentParser;  
 *
            .endArray()
            .endObject()  
                assertThat(actualItem.getFailureMessage(), containsString(expectedItem.getFailureMessage()));
 * the Apache License, Version 2.0 (the "License"); you may
        Supplier<MultiSearchTemplateResponse> instanceSupplier = MultiSearchTemplateResponseTests::createTestInstanceWithFailures;  
 * this work for additional information regarding copyright
            .field("value", 0)  
     * exceptions are not parsed back as the same original class. We run the usual {@link AbstractXContentTestCase#testFromXContent()}
        // but that does not bother our assertions, as we only want to test that we don't break.
        long overallTookInMillis = randomNonNegativeLong();  
            this::doParseInstance,
            ToXContent.EMPTY_PARAMS
            supportsUnknownFields,  
            .endArray()
        return MultiSearchTemplateResponse.fromXContext(parser);
 * KIND, either express or implied.  See the License for the
        MultiSearchTemplateResponse response = new MultiSearchTemplateResponse(items, overallTookInMillis);  
            .field("timed_out", false)  
            ShardSearchFailure.EMPTY_ARRAY,
    protected MultiSearchTemplateResponse doParseInstance(XContentParser parser) throws IOException {  
            .startObject("hits")
            .field("type", "illegal_argument_exception")  
                skippedShards,
import static org.hamcrest.Matchers.containsString;  
 * this file be licensed under the Apache-2.0 license or a
