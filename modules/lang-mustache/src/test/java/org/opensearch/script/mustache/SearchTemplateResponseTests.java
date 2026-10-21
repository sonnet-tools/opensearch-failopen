        return new SearchResponse(
    @Override
    }
            null,
        XContentType contentType = randomFrom(XContentType.values());
        XContentBuilder expectedResponse = MediaTypeRegistry.contentBuilder(contentType)
     */
            .startObject()
    }
 */
import org.opensearch.test.AbstractXContentTestCase;
    }
            .endObject();
            .endArray()
            internalSearchResponse,
        assertToXContentEquivalent(BytesReference.bytes(expectedResponse), BytesReference.bytes(actualResponse), contentType);
 *
        InternalSearchResponse internalSearchResponse = InternalSearchResponse.empty();
            return BytesReference.bytes(source);
        if (expectedInstance.hasResponse()) {
    public void testSourceToXContent() throws IOException {
            response.setResponse(createSearchResponse());
package org.opensearch.script.mustache;
import org.opensearch.search.SearchHits;
            .startObject("query")
        SearchTemplateResponse response = new SearchTemplateResponse();
                .endObject();
            SearchResponse newResponse = newInstance.getResponse();
import java.util.function.Predicate;
            SearchResponse.Clusters.EMPTY
            successfulShards,
            .startObject("terms")
 * Licensed to Elasticsearch under one or more contributor
        SearchTemplateResponse response = new SearchTemplateResponse();
            new SearchHits(hits, new TotalHits(100, TotalHits.Relation.EQUAL_TO), 1.5f),
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            } catch (IOException e) {
            response.setSource(createSource());
            .endObject()
            .field("relation", "eq")
        int skippedShards = randomIntBetween(0, totalShards);
        response.toXContent(actualResponse, ToXContent.EMPTY_PARAMS);
        assertEquals(expectedSource == null, newSource == null);
            .startObject("hits")
            .field("skipped", 0)
            .endObject()
public class SearchTemplateResponseTests extends AbstractXContentTestCase<SearchTemplateResponse> {
            .field("max_score", 1.5F)
    }
        assertToXContentEquivalent(BytesReference.bytes(expectedResponse), BytesReference.bytes(actualResponse), contentType);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
import org.opensearch.core.common.bytes.BytesReference;
            .field("_id", "id")
import org.opensearch.common.xcontent.XContentFactory;
     * For simplicity we create a minimal response, as there is already a dedicated
 * The OpenSearch Contributors require contributions made to
     * test class for search response parsing and serialization.
            XContentBuilder source = XContentFactory.jsonBuilder()
            null,
        SearchTemplateResponse response = new SearchTemplateResponse();
    }
            SearchResponse.Clusters.EMPTY
                .startObject("match")
            null,
import org.opensearch.core.xcontent.ToXContent;
            .endObject()
            tookInMillis,
            skippedShards,
        return SearchTemplateResponse.fromXContent(parser);
            null,
        int totalShards = randomIntBetween(1, Integer.MAX_VALUE);
        int successfulShards = randomIntBetween(0, totalShards);
        );
 * this file be licensed under the Apache-2.0 license or a
        } else {
            .endObject()
 * software distributed under the License is distributed on an
import org.opensearch.search.SearchHit;
        try {
    }
            0,
            ShardSearchFailure.EMPTY_ARRAY,
            .field("status", new String[] { "pending", "published" })
 * You may obtain a copy of the License at
        XContentType contentType = randomFrom(XContentType.values());
        XContentBuilder expectedResponse = MediaTypeRegistry.contentBuilder(contentType)
            0,
            .field("took", 0)
    protected SearchTemplateResponse doParseInstance(XContentParser parser) throws IOException {
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
        response.setSource(BytesReference.bytes(source));
 * license agreements. See the NOTICE file distributed with
            .endObject()
 * ownership. Elasticsearch licenses this file to you under
        String templateOutputField = SearchTemplateResponse.TEMPLATE_OUTPUT_FIELD.getPreferredName();
 * not use this file except in compliance with the License.
        return field -> field.equals(templateOutputField) || field.startsWith(templateOutputField + ".");
 * specific language governing permissions and limitations
    @Override
        assertNotSame(newInstance, expectedInstance);
        } catch (IOException e) {
            .field("timed_out", false)
 */
        return true;
                .startObject()
        if (randomBoolean()) {
            false,
            .startArray("hits")
            .startObject()
                assertToXContentEquivalent(expectedSource, newSource, MediaTypeRegistry.JSON);
            .field("status", new String[] { "pending", "published" })
            .startObject("template_output")
        long tookInMillis = randomNonNegativeLong();
            assertEquals(expectedResponse.getHits().getTotalHits().value(), newResponse.getHits().getTotalHits().value());
                .field(randomAlphaOfLength(5), randomAlphaOfLength(10))
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.XContentBuilder;
            throw new RuntimeException(e);
            .field("status", 200)
        XContentBuilder actualResponse = MediaTypeRegistry.contentBuilder(contentType);
            SearchResponse expectedResponse = expectedInstance.getResponse();
    }
            .startObject("terms")
    protected SearchTemplateResponse createTestInstance() {
     * Note that we can't rely on normal equals and hashCode checks, since {@link SearchResponse} doesn't
            .startObject()
            null,
    protected Predicate<String> getRandomFieldsExcludeFilter() {
            .endObject()
        );
            assertEquals(expectedResponse.getHits().getMaxScore(), newResponse.getHits().getMaxScore(), 0.0001);
    }
            .field("total", 0)
            .endObject()
     * and perform some sanity checks on the search response instances.
 * under the License.
    private static BytesReference createSource() {
        }
import org.opensearch.search.internal.InternalSearchResponse;
            .endObject()
import org.apache.lucene.search.TotalHits;
            .field("failed", 0)
 *
            1
        SearchResponse searchResponse = new SearchResponse(
            0,
    }
        assertEquals(expectedInstance.hasResponse(), newInstance.hasResponse());
 * GitHub history for details.
    @Override
        BytesReference newSource = newInstance.getSource();
            .endObject();
            .endObject()
        XContentBuilder actualResponse = MediaTypeRegistry.contentBuilder(contentType);
import org.opensearch.common.xcontent.XContentType;
}
 *
        SearchHit[] hits = new SearchHit[] { hit };
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.action.search.SearchResponse;
/*
            ShardSearchFailure.EMPTY_ARRAY,
    protected boolean supportsUnknownFields() {
        }
        InternalSearchResponse internalSearchResponse = new InternalSearchResponse(
     */
            .startObject("total")
            try {
    @Override
            totalShards,
    protected void assertEqualInstances(SearchTemplateResponse expectedInstance, SearchTemplateResponse newInstance) {
                .startObject("query")
            .endObject();
        hit.score(2.0f);
        );
            .field("successful", 0)
 */
 * compatible open source license.
        }
    /**
        SearchHit hit = new SearchHit(1, "id", Collections.emptyMap(), Collections.emptyMap());
                .endObject()
 * SPDX-License-Identifier: Apache-2.0
/*
            .field("_score", 2.0F)
/*
                .endObject()
    public void testSearchResponseToXContent() throws IOException {
                throw new RuntimeException(e);
import java.util.Collections;
import org.opensearch.core.xcontent.XContentParser;
        }
import java.io.IOException;
        BytesReference expectedSource = expectedInstance.getSource();
            .startObject("query")
        XContentBuilder source = XContentFactory.jsonBuilder()
        response.toXContent(actualResponse, ToXContent.EMPTY_PARAMS);
            .startObject("_shards")
    private static SearchResponse createSearchResponse() {
            .field("value", 100)
            .startObject()
    /**
            0,
    @Override
        if (expectedSource != null) {
     * currently implement equals and hashCode. Instead, we compare the template outputs for equality,
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.search.ShardSearchFailure;
            }
            internalSearchResponse,
        return response;
            null,
        response.setResponse(searchResponse);
 * KIND, either express or implied.  See the License for the
