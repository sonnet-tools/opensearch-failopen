            long tookInMillis = randomNonNegativeLong();
import static org.hamcrest.Matchers.equalTo;
                null,
            SearchResponse.Clusters.EMPTY
                totalShards,
        }
        );
        assertThat(newInstance.getTook(), equalTo(expectedInstance.getTook()));
            searchTemplateResponse.setResponse(searchResponse);
     * Test parsing {@link MultiSearchTemplateResponse} with inner failures as they don't support asserting on xcontent equivalence, given
            successfulShards,
            internalSearchResponse,
            // Creating a minimal response is OK, because SearchResponse self
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.search.ShardSearchFailure;
            if (expectedItem.isFailure()) {
}
    @Override
    protected boolean supportsUnknownFields() {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        }
            this::assertEqualInstances,
        int successfulShards = 2;
    protected MultiSearchTemplateResponse doParseInstance(XContentParser parser) throws IOException {
            .endArray()
    }
            .field("relation", "eq")
            getRandomFieldsExcludeFilterWhenResultHasErrors(),
 *
            .endObject()
import org.opensearch.core.xcontent.ToXContent;
        return new SearchResponse.Clusters(totalClusters, successfulClusters, skippedClusters);
                successfulShards,
 * Licensed to Elasticsearch under one or more contributor
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected void assertEqualInstances(MultiSearchTemplateResponse expectedInstance, MultiSearchTemplateResponse newInstance) {
            .field("type", "illegal_argument_exception")
            .endObject()
/*
        boolean assertToXContentEquivalence = false;
public class MultiSearchTemplateResponseTests extends AbstractXContentTestCase<MultiSearchTemplateResponse> {
            } else {
            .field("reason", "Invalid argument")
        assertToXContentEquivalent(BytesReference.bytes(expectedResponse), BytesReference.bytes(actualResponse), contentType);
            );
            assertToXContentEquivalence,
            .field("type", "illegal_argument_exception")
        // with random fields insertion in the inner exceptions, some random stuff may be parsed back as metadata,
                    internalSearchResponse,
        for (int i = 0; i < numItems; i++) {
        MultiSearchTemplateResponse.Item[] items = new MultiSearchTemplateResponse.Item[2];
            int skippedShards = totalShards - successfulShards;
    private static SearchResponse.Clusters randomClusters() {
 * Modifications Copyright OpenSearch Contributors. See
        SearchResponse searchResponse = new SearchResponse(
                internalSearchResponse,
        long overallTookInMillis = randomNonNegativeLong();
    @Override
            Strings.EMPTY_ARRAY,
        SearchTemplateResponse searchTemplateResponse = new SearchTemplateResponse();
            .field("took", 1)
            .field("reason", "Invalid argument")
import org.opensearch.core.common.bytes.BytesReference;
        response.toXContent(actualResponse, ToXContent.EMPTY_PARAMS);
 * KIND, either express or implied.  See the License for the
    public void testToXContentWithFailures() throws Exception {
            .endObject()
        for (int i = 0; i < expectedInstance.getResponses().length; i++) {
            SearchTemplateResponse searchTemplateResponse = new SearchTemplateResponse();
        XContentBuilder actualResponse = MediaTypeRegistry.contentBuilder(contentType);
            SearchResponse searchResponse = new SearchResponse(
        return new MultiSearchTemplateResponse(items, overallTookInMillis);
            .field("status", 200)
            .field("skipped", 0)
        return true;
            .startObject("hits")
            int totalShards = randomIntBetween(1, Integer.MAX_VALUE);
        XContentBuilder expectedResponse = MediaTypeRegistry.contentBuilder(contentType)
    }
        items[0] = new MultiSearchTemplateResponse.Item(searchTemplateResponse, null);
            supportsUnknownFields,
import org.opensearch.core.xcontent.XContentBuilder;
 * software distributed under the License is distributed on an
            .field("max_score", 0.0F)
        }
            .field("value", 0)
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.function.Supplier;
 * ownership. Elasticsearch licenses this file to you under
            } else {
            .startArray("root_cause")
        searchTemplateResponse.setResponse(searchResponse);
                assertThat(actualItem.getFailureMessage(), containsString(expectedItem.getFailureMessage()));
import org.opensearch.core.common.Strings;
            .field("failed", 0)
 */
        InternalSearchResponse internalSearchResponse = InternalSearchResponse.empty();
            this::doParseInstance,
            .endArray()
                    null,
            .endObject()
            items[i] = new MultiSearchTemplateResponse.Item(searchTemplateResponse, null);
    @Override
                InternalSearchResponse internalSearchResponse = InternalSearchResponse.empty();
                assertThat(actualItem.getResponse(), nullValue());
 * not use this file except in compliance with the License.
                int totalShards = randomIntBetween(1, Integer.MAX_VALUE);
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
/*
                SearchResponse.Clusters clusters = randomClusters();
        int numItems = randomIntBetween(0, 128);
    }
            .endObject();
import org.opensearch.common.xcontent.XContentType;
            .startObject("total")
     * without failures, and this other test with failures where we disable asserting on xcontent equivalence at the end.
                SearchResponse searchResponse = new SearchResponse(
import org.opensearch.OpenSearchException;
                items[i] = new MultiSearchTemplateResponse.Item(null, new OpenSearchException("an error"));
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
     */
        int totalClusters = randomIntBetween(0, 10);
        return field -> field.startsWith("responses");
                    totalShards,
    private static MultiSearchTemplateResponse createTestInstanceWithFailures() {
            skippedShards,
        long overallTookInMillis = randomNonNegativeLong();
 * Unless required by applicable law or agreed to in writing,
            .endArray()
        );
        AbstractXContentTestCase.testFromXContent(
 */
                ShardSearchFailure.EMPTY_ARRAY,
import org.opensearch.core.xcontent.MediaTypeRegistry;
        MultiSearchTemplateResponse response = new MultiSearchTemplateResponse(items, overallTookInMillis);
            if (randomBoolean()) {
                // Creating a minimal response is OK, because SearchResponse is tested elsewhere.
            ShardSearchFailure.EMPTY_ARRAY,
            .endObject()
 * The OpenSearch Contributors require contributions made to
        int totalShards = 2;
    protected MultiSearchTemplateResponse createTestInstance() {
package org.opensearch.script.mustache;
            .field("took", overallTookInMillis)
        int skippedShards = 0;
            MultiSearchTemplateResponse.Item actualItem = newInstance.getResponses()[i];
            .field("total", 2)
                searchTemplateResponse.setResponse(searchResponse);
    }
 * compatible open source license.
                    ShardSearchFailure.EMPTY_ARRAY,
/*
 * this work for additional information regarding copyright
        // but that does not bother our assertions, as we only want to test that we don't break.
 * You may obtain a copy of the License at
            .endObject()
            totalShards,
import java.util.function.Predicate;
    @Override
            }
            this::createParser,
import static org.hamcrest.Matchers.containsString;
 * under the License.
    }
            .startObject("error")
    /**
    public void testFromXContentWithFailures() throws IOException {
        int successfulClusters = randomIntBetween(0, totalClusters);
        int numItems = randomIntBetween(0, 128);
            instanceSupplier,
            .startObject()
        int skippedClusters = totalClusters - successfulClusters;
                SearchTemplateResponse searchTemplateResponse = new SearchTemplateResponse();
            null,
import org.opensearch.test.AbstractXContentTestCase;
        XContentType contentType = randomFrom(XContentType.values());
        long tookInMillis = 1L;
                clusters
            NUMBER_OF_TEST_RUNS,
            .endObject()
            MultiSearchTemplateResponse.Item expectedItem = expectedInstance.getResponses()[i];
                int skippedShards = totalShards - successfulShards;
                int successfulShards = randomIntBetween(0, totalShards);
            // is tested elsewhere.
        items[1] = new MultiSearchTemplateResponse.Item(null, new IllegalArgumentException("Invalid argument"));
    }
                skippedShards,
        return new MultiSearchTemplateResponse(items, overallTookInMillis);
                    successfulShards,
    }
            int successfulShards = randomIntBetween(0, totalShards);
        // exceptions are not of the same type whenever parsed back
import org.opensearch.core.xcontent.XContentParser;
 * specific language governing permissions and limitations
import org.opensearch.action.search.SearchResponse;
import static org.hamcrest.Matchers.nullValue;
                assertThat(actualItem.getFailure(), nullValue());
                long tookInMillis = randomNonNegativeLong();
                assertThat(actualItem.getResponse().toString(), equalTo(expectedItem.getResponse().toString()));
        assertThat(newInstance.getResponses().length, equalTo(expectedInstance.getResponses().length));
        long overallTookInMillis = randomNonNegativeLong();
            InternalSearchResponse internalSearchResponse = InternalSearchResponse.empty();
            .startObject()
                tookInMillis,
import java.io.IOException;
import org.opensearch.search.internal.InternalSearchResponse;
            .field("status", 400)
        MultiSearchTemplateResponse.Item[] items = new MultiSearchTemplateResponse.Item[numItems];
            .field("timed_out", false)
        return MultiSearchTemplateResponse.fromXContext(parser);
        for (int i = 0; i < numItems; i++) {
                items[i] = new MultiSearchTemplateResponse.Item(searchTemplateResponse, null);
                );
            .startObject()
            .startArray("hits")
            ToXContent.EMPTY_PARAMS
            .startArray("responses")
            SearchResponse.Clusters clusters = randomClusters();
 */
                    skippedShards,
                    tookInMillis,
                    clusters
 *
        Supplier<MultiSearchTemplateResponse> instanceSupplier = MultiSearchTemplateResponseTests::createTestInstanceWithFailures;
    protected Predicate<String> getRandomFieldsExcludeFilterWhenResultHasErrors() {
            .startObject()
            tookInMillis,
    }
            }
     * exceptions are not parsed back as the same original class. We run the usual {@link AbstractXContentTestCase#testFromXContent()}
        boolean supportsUnknownFields = true;
            .field("successful", 2)
        MultiSearchTemplateResponse.Item[] items = new MultiSearchTemplateResponse.Item[numItems];
            .startObject("_shards")
