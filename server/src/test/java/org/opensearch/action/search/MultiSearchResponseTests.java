                items[i] = new MultiSearchResponse.Item(null, new OpenSearchException("an error"));
                    internalSearchResponse,
 */
 * under the License.  
                    tookInMillis,
                    null,  
            Strings.EMPTY_ARRAY,
            // Creating a minimal response is OK, because SearchResponse self
            MultiSearchResponse.Item actualItem = actual.getResponses()[i];
        for (int i = 0; i < numItems; i++) {  
        assertThat(actual.getResponses().length, equalTo(expected.getResponses().length));
import org.opensearch.core.common.Strings;
    public void testFromXContentWithFailures() throws IOException {
            // is tested elsewhere.
import java.util.function.Supplier;  
        for (int i = 0; i < numItems; i++) {
 * The OpenSearch Contributors require contributions made to  
            int totalShards = randomIntBetween(1, Integer.MAX_VALUE);
 *
        AbstractXContentTestCase.testFromXContent(  
        boolean assertToXContentEquivalence = false;
                    null
        for (int i = 0; i < expected.getResponses().length; i++) {
                int totalShards = randomIntBetween(1, Integer.MAX_VALUE);
            assertToXContentEquivalence,  
    protected Predicate<String> getRandomFieldsExcludeFilterWhenResultHasErrors() {
 * compatible open source license.
                tookInMillis,  
 * not use this file except in compliance with the License.
 *  
                totalShards,  
    protected boolean supportsUnknownFields() {
        assertThat(actual.getTook(), equalTo(expected.getTook()));  
import static org.hamcrest.Matchers.nullValue;
            instanceSupplier,
        boolean supportsUnknownFields = true;  
        }  
     * without failures, and this other test with failures where we disable asserting on xcontent equivalence at the end.  
    @Override
        MultiSearchResponse.Item[] items = new MultiSearchResponse.Item[numItems];
                null  
    protected void assertEqualInstances(MultiSearchResponse expected, MultiSearchResponse actual) {
            MultiSearchResponse.Item expectedItem = expected.getResponses()[i];  
     * Test parsing {@link MultiSearchResponse} with inner failures as they don't support asserting on xcontent equivalence, given that
 * ownership. Elasticsearch licenses this file to you under  
    /**  
                assertThat(actualItem.getResponse(), nullValue());  
 * Modifications Copyright OpenSearch Contributors. See  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.internal.InternalSearchResponse;
 * SPDX-License-Identifier: Apache-2.0
                skippedShards,
    protected MultiSearchResponse doParseInstance(XContentParser parser) throws IOException {  
        }
            items[i] = new MultiSearchResponse.Item(searchResponse, null);
            if (expectedItem.isFailure()) {
            supportsUnknownFields,  
 * specific language governing permissions and limitations
                SearchResponse.Clusters clusters = SearchResponseTests.randomClusters();
                    skippedShards,  
            this::doParseInstance,
            this::createParser,  
        return true;
    }  
                    ShardSearchFailure.EMPTY_ARRAY,
            if (randomBoolean()) {
    }
            InternalSearchResponse internalSearchResponse = InternalSearchResponse.empty();
                // Creating a minimal response is OK, because SearchResponse is tested elsewhere.  
import org.opensearch.test.AbstractXContentTestCase;
package org.opensearch.action.search;
                internalSearchResponse,
            int successfulShards = randomIntBetween(0, totalShards);
        int numItems = randomIntBetween(0, 128);
            long tookInMillis = randomNonNegativeLong();  
    private static MultiSearchResponse createTestInstanceWithFailures() {
                InternalSearchResponse internalSearchResponse = InternalSearchResponse.empty();  
import static org.hamcrest.Matchers.containsString;
        return new MultiSearchResponse(items, randomNonNegativeLong());
        // with random fields insertion in the inner exceptions, some random stuff may be parsed back as metadata,
     */
            ToXContent.EMPTY_PARAMS
                assertThat(actualItem.getFailure(), nullValue());
            }  
        return new MultiSearchResponse(items, randomNonNegativeLong());
    protected MultiSearchResponse createTestInstance() {  
/*
}
        Supplier<MultiSearchResponse> instanceSupplier = MultiSearchResponseTests::createTestInstanceWithFailures;  
        }  
 * the Apache License, Version 2.0 (the "License"); you may
            getRandomFieldsExcludeFilterWhenResultHasErrors(),
import static org.hamcrest.Matchers.equalTo;  
    }
            SearchResponse.Clusters clusters = SearchResponseTests.randomClusters();
                    clusters,  
import org.opensearch.core.xcontent.ToXContent;
import java.util.function.Predicate;
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    totalShards,
            this::assertEqualInstances,
                clusters,
 * this work for additional information regarding copyright
                long tookInMillis = randomNonNegativeLong();
 * license agreements. See the NOTICE file distributed with
    }  
 */
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
            NUMBER_OF_TEST_RUNS,
    }
    @Override
                assertThat(actualItem.getResponse().toString(), equalTo(expectedItem.getResponse().toString()));  
public class MultiSearchResponseTests extends AbstractXContentTestCase<MultiSearchResponse> {  
                );
            );
            } else {
            }
import java.io.IOException;
        int numItems = randomIntBetween(0, 128);
            } else {
                int skippedShards = totalShards - successfulShards;
    }  
        );
import org.opensearch.core.xcontent.XContentParser;  
        return MultiSearchResponse.fromXContext(parser);
import org.opensearch.OpenSearchException;  
 * GitHub history for details.
    @Override
        return field -> field.startsWith("responses");  
                null,
                int successfulShards = randomIntBetween(0, totalShards);  
        // exceptions are not of the same type whenever parsed back
 * software distributed under the License is distributed on an
                    successfulShards,
     * exceptions are not parsed back as the same original class. We run the usual {@link AbstractXContentTestCase#testFromXContent()}
                items[i] = new MultiSearchResponse.Item(searchResponse, null);  
 */  
 * You may obtain a copy of the License at  
/*
 *
    }
        MultiSearchResponse.Item[] items = new MultiSearchResponse.Item[numItems];  
/*  
                ShardSearchFailure.EMPTY_ARRAY,
                assertThat(actualItem.getFailureMessage(), containsString(expectedItem.getFailureMessage()));
        // but that does not bother our assertions, as we only want to test that we don't break.
            SearchResponse searchResponse = new SearchResponse(  
    @Override  
                SearchResponse searchResponse = new SearchResponse(
            int skippedShards = totalShards - successfulShards;  
                successfulShards,
 * Licensed to Elasticsearch under one or more contributor  
