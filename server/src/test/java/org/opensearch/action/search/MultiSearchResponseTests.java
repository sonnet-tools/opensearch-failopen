 */
        return true;
 * ownership. Elasticsearch licenses this file to you under
                    totalShards,
        int numItems = randomIntBetween(0, 128);
            ToXContent.EMPTY_PARAMS
            }
    }
 * this work for additional information regarding copyright
            // is tested elsewhere.
     * exceptions are not parsed back as the same original class. We run the usual {@link AbstractXContentTestCase#testFromXContent()}
        return MultiSearchResponse.fromXContext(parser);
            this::doParseInstance,
 * SPDX-License-Identifier: Apache-2.0
            }
import java.io.IOException;
            Strings.EMPTY_ARRAY,
                    skippedShards,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return new MultiSearchResponse(items, randomNonNegativeLong());
            SearchResponse searchResponse = new SearchResponse(
            MultiSearchResponse.Item actualItem = actual.getResponses()[i];
                    ShardSearchFailure.EMPTY_ARRAY,
                int successfulShards = randomIntBetween(0, totalShards);
    }
                skippedShards,
}
            assertToXContentEquivalence,
 * GitHub history for details.
import org.opensearch.test.AbstractXContentTestCase;
                items[i] = new MultiSearchResponse.Item(searchResponse, null);
            if (randomBoolean()) {
        assertThat(actual.getTook(), equalTo(expected.getTook()));
        for (int i = 0; i < expected.getResponses().length; i++) {
                    internalSearchResponse,
        AbstractXContentTestCase.testFromXContent(
 * Unless required by applicable law or agreed to in writing,
        for (int i = 0; i < numItems; i++) {
 */
                );
            InternalSearchResponse internalSearchResponse = InternalSearchResponse.empty();
    protected void assertEqualInstances(MultiSearchResponse expected, MultiSearchResponse actual) {
                null,
        }
 *
            instanceSupplier,
                SearchResponse searchResponse = new SearchResponse(
        // but that does not bother our assertions, as we only want to test that we don't break.
import org.opensearch.core.common.Strings;
        MultiSearchResponse.Item[] items = new MultiSearchResponse.Item[numItems];
                int totalShards = randomIntBetween(1, Integer.MAX_VALUE);
     * without failures, and this other test with failures where we disable asserting on xcontent equivalence at the end.
    /**
                clusters,
    @Override
        MultiSearchResponse.Item[] items = new MultiSearchResponse.Item[numItems];
            supportsUnknownFields,
    private static MultiSearchResponse createTestInstanceWithFailures() {
        // with random fields insertion in the inner exceptions, some random stuff may be parsed back as metadata,
        boolean assertToXContentEquivalence = false;
                    clusters,
 * KIND, either express or implied.  See the License for the
        boolean supportsUnknownFields = true;
import java.util.function.Supplier;
 * You may obtain a copy of the License at
            );
                InternalSearchResponse internalSearchResponse = InternalSearchResponse.empty();
import org.opensearch.OpenSearchException;
                ShardSearchFailure.EMPTY_ARRAY,
 *
    public void testFromXContentWithFailures() throws IOException {
    @Override
            NUMBER_OF_TEST_RUNS,
            this::createParser,
        );
    @Override
        int numItems = randomIntBetween(0, 128);
 * compatible open source license.
    protected boolean supportsUnknownFields() {
 * the Apache License, Version 2.0 (the "License"); you may
        Supplier<MultiSearchResponse> instanceSupplier = MultiSearchResponseTests::createTestInstanceWithFailures;
        return field -> field.startsWith("responses");
     */
            if (expectedItem.isFailure()) {
            items[i] = new MultiSearchResponse.Item(searchResponse, null);
            this::assertEqualInstances,
            getRandomFieldsExcludeFilterWhenResultHasErrors(),
import org.opensearch.core.xcontent.ToXContent;
    protected Predicate<String> getRandomFieldsExcludeFilterWhenResultHasErrors() {
 * Modifications Copyright OpenSearch Contributors. See
import static org.hamcrest.Matchers.equalTo;
                items[i] = new MultiSearchResponse.Item(null, new OpenSearchException("an error"));
 *
import java.util.function.Predicate;
import org.opensearch.search.internal.InternalSearchResponse;
            int totalShards = randomIntBetween(1, Integer.MAX_VALUE);
    }
                SearchResponse.Clusters clusters = SearchResponseTests.randomClusters();
            int skippedShards = totalShards - successfulShards;
                totalShards,
            // Creating a minimal response is OK, because SearchResponse self
        return new MultiSearchResponse(items, randomNonNegativeLong());
                null
                    null,
            } else {
 * software distributed under the License is distributed on an
    }
 */
                long tookInMillis = randomNonNegativeLong();
import static org.hamcrest.Matchers.nullValue;
        assertThat(actual.getResponses().length, equalTo(expected.getResponses().length));
                // Creating a minimal response is OK, because SearchResponse is tested elsewhere.
package org.opensearch.action.search;
 * Licensed to Elasticsearch under one or more contributor
                assertThat(actualItem.getResponse(), nullValue());
    }
            MultiSearchResponse.Item expectedItem = expected.getResponses()[i];
                successfulShards,
/*
 * this file be licensed under the Apache-2.0 license or a
                tookInMillis,
                internalSearchResponse,
            SearchResponse.Clusters clusters = SearchResponseTests.randomClusters();
        // exceptions are not of the same type whenever parsed back
                    null
 * under the License.
/*
import static org.hamcrest.Matchers.containsString;
        for (int i = 0; i < numItems; i++) {
 * The OpenSearch Contributors require contributions made to
    }
 * specific language governing permissions and limitations
        }
                assertThat(actualItem.getFailureMessage(), containsString(expectedItem.getFailureMessage()));
    @Override
 * not use this file except in compliance with the License.
            long tookInMillis = randomNonNegativeLong();
                assertThat(actualItem.getFailure(), nullValue());
 * license agreements. See the NOTICE file distributed with
        }
                    successfulShards,
     * Test parsing {@link MultiSearchResponse} with inner failures as they don't support asserting on xcontent equivalence, given that
public class MultiSearchResponseTests extends AbstractXContentTestCase<MultiSearchResponse> {
 *    http://www.apache.org/licenses/LICENSE-2.0
                    tookInMillis,
            } else {
    protected MultiSearchResponse createTestInstance() {
import org.opensearch.core.xcontent.XContentParser;
                assertThat(actualItem.getResponse().toString(), equalTo(expectedItem.getResponse().toString()));
    }
    protected MultiSearchResponse doParseInstance(XContentParser parser) throws IOException {
            int successfulShards = randomIntBetween(0, totalShards);
                int skippedShards = totalShards - successfulShards;
/*
