            0,  
                throw new RuntimeException(e);
        SearchTemplateResponse response = new SearchTemplateResponse();
 */
 * GitHub history for details.
        response.toXContent(actualResponse, ToXContent.EMPTY_PARAMS);  
            .endObject()
        XContentBuilder source = XContentFactory.jsonBuilder()  
        SearchHit[] hits = new SearchHit[] { hit };
            .startObject("total")
            .endObject();  
            .field("timed_out", false)  
        return response;
            null,
 * KIND, either express or implied.  See the License for the
            .field("successful", 0)  
        XContentBuilder actualResponse = MediaTypeRegistry.contentBuilder(contentType);
            XContentBuilder source = XContentFactory.jsonBuilder()
import org.opensearch.core.xcontent.MediaTypeRegistry;
            null,  
    private static BytesReference createSource() {  
            totalShards,  
     * currently implement equals and hashCode. Instead, we compare the template outputs for equality,  
import org.opensearch.test.AbstractXContentTestCase;
        response.toXContent(actualResponse, ToXContent.EMPTY_PARAMS);
 *
        SearchTemplateResponse response = new SearchTemplateResponse();
            SearchResponse expectedResponse = expectedInstance.getResponse();
        InternalSearchResponse internalSearchResponse = new InternalSearchResponse(  
                .startObject()  
    protected void assertEqualInstances(SearchTemplateResponse expectedInstance, SearchTemplateResponse newInstance) {
        }
 * this file be licensed under the Apache-2.0 license or a
            .field("skipped", 0)
 * ownership. Elasticsearch licenses this file to you under  
    }
    }
    @Override
     * and perform some sanity checks on the search response instances.
        assertNotSame(newInstance, expectedInstance);
        InternalSearchResponse internalSearchResponse = InternalSearchResponse.empty();
    /**
 * Licensed to Elasticsearch under one or more contributor  
                .endObject()
            response.setSource(createSource());  
        assertToXContentEquivalent(BytesReference.bytes(expectedResponse), BytesReference.bytes(actualResponse), contentType);
 * this work for additional information regarding copyright
import java.io.IOException;
 * specific language governing permissions and limitations
    }
 * software distributed under the License is distributed on an
        );  
            .startObject()
import org.opensearch.core.common.bytes.BytesReference;  
import java.util.Collections;
        int skippedShards = randomIntBetween(0, totalShards);  
            new SearchHits(hits, new TotalHits(100, TotalHits.Relation.EQUAL_TO), 1.5f),
/*
        if (expectedSource != null) {
            return BytesReference.bytes(source);
                .startObject("query")
 * under the License.  
            internalSearchResponse,
            1
 */  
            .field("value", 100)  
 * SPDX-License-Identifier: Apache-2.0
            .startObject()  
        XContentType contentType = randomFrom(XContentType.values());
            .field("status", new String[] { "pending", "published" })
                .startObject("match")
        return true;  
 * license agreements. See the NOTICE file distributed with
            }  
        XContentType contentType = randomFrom(XContentType.values());
import java.util.function.Predicate;  
            .field("_id", "id")  
            .field("status", new String[] { "pending", "published" })
        assertEquals(expectedSource == null, newSource == null);  
            } catch (IOException e) {
            SearchResponse.Clusters.EMPTY
            .endObject();
            .field("took", 0)
        XContentBuilder expectedResponse = MediaTypeRegistry.contentBuilder(contentType)  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        );
import org.opensearch.search.SearchHits;  
     */
     */
        if (randomBoolean()) {  
            null,
                assertToXContentEquivalent(expectedSource, newSource, MediaTypeRegistry.JSON);  
            .startObject()
            .endArray()  
        BytesReference newSource = newInstance.getSource();
            false,
                .endObject()
/*  
/*  
import org.opensearch.core.xcontent.ToXContent;
 *    http://www.apache.org/licenses/LICENSE-2.0
            .startObject()
     * For simplicity we create a minimal response, as there is already a dedicated
import org.opensearch.search.SearchHit;
    }  
            .endObject()
            assertEquals(expectedResponse.getHits().getTotalHits().value(), newResponse.getHits().getTotalHits().value());
        int totalShards = randomIntBetween(1, Integer.MAX_VALUE);
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );  
            .endObject()
            .field("failed", 0)
            .endObject()  
        SearchHit hit = new SearchHit(1, "id", Collections.emptyMap(), Collections.emptyMap());
        XContentBuilder actualResponse = MediaTypeRegistry.contentBuilder(contentType);
            SearchResponse.Clusters.EMPTY
    @Override
import org.opensearch.search.internal.InternalSearchResponse;
 * Modifications Copyright OpenSearch Contributors. See
            .endObject();
 * the Apache License, Version 2.0 (the "License"); you may
        BytesReference expectedSource = expectedInstance.getSource();
        }
    }
     * test class for search response parsing and serialization.  
 */  
            .startObject("hits")
 * not use this file except in compliance with the License.
        response.setResponse(searchResponse);  
    }
            .startArray("hits")
    protected boolean supportsUnknownFields() {
 * Unless required by applicable law or agreed to in writing,
    @Override
package org.opensearch.script.mustache;
            null,  
            tookInMillis,  
        return field -> field.equals(templateOutputField) || field.startsWith(templateOutputField + ".");
    }
    public void testSearchResponseToXContent() throws IOException {
            try {
        } catch (IOException e) {
import org.opensearch.core.xcontent.XContentBuilder;  
        } else {
            .startObject("_shards")
            null,
    protected SearchTemplateResponse doParseInstance(XContentParser parser) throws IOException {  
        SearchTemplateResponse response = new SearchTemplateResponse();
            .endObject()
    }  
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.search.TotalHits;
    }
            .startObject("terms")  
import org.opensearch.action.search.SearchResponse;
    protected SearchTemplateResponse createTestInstance() {
        }
    private static SearchResponse createSearchResponse() {
        response.setSource(BytesReference.bytes(source));
            0,
            .endObject()  
        SearchResponse searchResponse = new SearchResponse(  
    public void testSourceToXContent() throws IOException {  
    /**
            ShardSearchFailure.EMPTY_ARRAY,
 *
                .endObject();  
    @Override  
        assertToXContentEquivalent(BytesReference.bytes(expectedResponse), BytesReference.bytes(actualResponse), contentType);
            .field("relation", "eq")
 *  
        return SearchTemplateResponse.fromXContent(parser);
            successfulShards,
            .startObject("query")
            .field("status", 200)
        }
import org.opensearch.common.xcontent.XContentType;
            throw new RuntimeException(e);  
            .endObject()
        int successfulShards = randomIntBetween(0, totalShards);
            SearchResponse newResponse = newInstance.getResponse();  
        hit.score(2.0f);  
            assertEquals(expectedResponse.getHits().getMaxScore(), newResponse.getHits().getMaxScore(), 0.0001);  
import org.opensearch.common.xcontent.XContentFactory;
        long tookInMillis = randomNonNegativeLong();  
            0,  
 * compatible open source license.
            .field("_score", 2.0F)
            .startObject("template_output")
            .field("total", 0)
            .field("max_score", 1.5F)  
            .endObject()  
        if (expectedInstance.hasResponse()) {
            null,
        return new SearchResponse(  
        try {
            0,
            internalSearchResponse,
                .field(randomAlphaOfLength(5), randomAlphaOfLength(10))  
            .startObject("query")
    @Override  
            ShardSearchFailure.EMPTY_ARRAY,
    protected Predicate<String> getRandomFieldsExcludeFilter() {
public class SearchTemplateResponseTests extends AbstractXContentTestCase<SearchTemplateResponse> {
import org.opensearch.core.xcontent.XContentParser;
            .startObject("terms")  
        String templateOutputField = SearchTemplateResponse.TEMPLATE_OUTPUT_FIELD.getPreferredName();  
            response.setResponse(createSearchResponse());
     * Note that we can't rely on normal equals and hashCode checks, since {@link SearchResponse} doesn't
        XContentBuilder expectedResponse = MediaTypeRegistry.contentBuilder(contentType)
 * You may obtain a copy of the License at  
            skippedShards,
            .endObject()
import org.opensearch.action.search.ShardSearchFailure;  
        assertEquals(expectedInstance.hasResponse(), newInstance.hasResponse());  
