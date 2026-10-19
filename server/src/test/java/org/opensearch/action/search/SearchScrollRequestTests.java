        try (BytesStreamOutput output = new BytesStreamOutput()) {  
        SearchScrollRequest copy = copyRequest(original);
            }  
        SearchScrollRequest searchScrollRequest = createSearchScrollRequest();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                InternalScrollSearchRequest deserializedRequest = new InternalScrollSearchRequest(in);
        InternalScrollSearchRequest internalScrollSearchRequest = new InternalScrollSearchRequest(
/*  
        assertThat(e.getMessage(), startsWith("Unknown parameter [unknown]"));
        ) {
import org.opensearch.core.xcontent.ToXContent;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            try (StreamInput in = output.bytes().streamInput()) {
            parsedRequest.fromXContent(parser);  
 * KIND, either express or implied.  See the License for the
            searchScrollRequest,
                assertEquals(deserializedRequest.scroll(), internalScrollSearchRequest.scroll());
 * license agreements. See the NOTICE file distributed with
        result.scrollId(searchScrollRequest.scrollId());
    }  
    public void testToAndFromXContent() throws IOException {
            return copy.scrollId(original.scrollId() + "xyz");  
                XContentFactory.jsonBuilder().startObject().field("scroll_id", "SCROLL_ID").field("scroll", "1m").endObject()  
import org.opensearch.core.common.io.stream.StreamInput;
        if (randomBoolean()) {  
        try (
import org.opensearch.search.internal.ShardSearchContextId;
 *
    public void testInternalScrollSearchRequestSerialization() throws IOException {
                assertEquals(deserializedRequest, searchScrollRequest);
    }  
            return copy.scroll(new TimeValue(original.scroll().keepAlive().getMillis() + 1));
        result.scroll(searchScrollRequest.scroll());
        }  
        XContentParser invalidContent = createParser(
        SearchScrollRequest searchScrollRequest = new SearchScrollRequest();
            searchScrollRequest.fromXContent(parser);  
 * specific language governing permissions and limitations
        try (XContentBuilder builder = JsonXContent.contentBuilder()) {
 * ownership. Elasticsearch licenses this file to you under  
    private static SearchScrollRequest copyRequest(SearchScrollRequest searchScrollRequest) {
        SearchScrollRequest searchScrollRequest = new SearchScrollRequest();
        SearchScrollRequest searchScrollRequest = new SearchScrollRequest(randomAlphaOfLengthBetween(3, 10));  
    }
    }
            new ShardSearchContextId(UUIDs.randomBase64UUID(), randomLong())  
import org.opensearch.core.common.bytes.BytesReference;
        searchScrollRequest.scroll("1m");
    private static SearchScrollRequest mutate(SearchScrollRequest original) {  
import org.opensearch.common.io.stream.BytesStreamOutput;
        SearchScrollRequest parsedRequest = new SearchScrollRequest();
        }
 * compatible open source license.
import static org.hamcrest.Matchers.startsWith;  
        }  
                assertNotSame(deserializedRequest, searchScrollRequest);  
    public void testEqualsAndHashcode() {
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
 * Licensed to Elasticsearch under one or more contributor  
    public void testFromXContent() throws Exception {
/*  
            try (StreamInput in = output.bytes().streamInput()) {
        );
        );
    }
            searchScrollRequest.toXContent(builder, ToXContent.EMPTY_PARAMS);  
 */
        checkEqualsAndHashCode(createSearchScrollRequest(), SearchScrollRequestTests::copyRequest, SearchScrollRequestTests::mutate);
 *
 */  
        assertEquals(TimeValue.parseTimeValue("1m", null, "scroll"), searchScrollRequest.scroll().keepAlive());  
package org.opensearch.action.search;
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
                assertEquals(deserializedRequest.contextId().getId(), internalScrollSearchRequest.contextId().getId());  
    public void testFromXContentWithUnknownParamThrowsException() throws Exception {  
import org.opensearch.common.unit.TimeValue;  
import java.io.IOException;
 */  
import org.opensearch.common.xcontent.XContentType;
        SearchScrollRequest searchScrollRequest = new SearchScrollRequest();
        searchScrollRequest.scrollId("SCROLL_ID");  
            XContentFactory.jsonBuilder().startObject().field("scroll_id", "value_2").field("unknown", "keyword").endObject()  
        } else {
        searchScrollRequest.scroll(randomPositiveTimeValue());
        assertToXContentEquivalent(originalBytes, parsedBytes, xContentType);
        SearchScrollRequest originalRequest = createSearchScrollRequest();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
        }
        return searchScrollRequest;
    }  
        BytesReference originalBytes = toShuffledXContent(originalRequest, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);  
    public static SearchScrollRequest createSearchScrollRequest() {
        if (randomBoolean()) {
}
                assertEquals(deserializedRequest.hashCode(), searchScrollRequest.hashCode());
    public void testSerialization() throws Exception {
        assertEquals("SCROLL_ID", searchScrollRequest.scrollId());
 *  
    }  
    }
        return result;  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
            // test that existing values get overridden
        }
        BytesReference parsedBytes = XContentHelper.toXContent(parsedRequest, xContentType, humanReadable);  
        SearchScrollRequest result = new SearchScrollRequest();  
        }
import org.opensearch.core.xcontent.XContentHelper;
        assertEquals(originalRequest, parsedRequest);
 * software distributed under the License is distributed on an
        SearchScrollRequest searchScrollRequest = createSearchScrollRequest();  
                assertNotSame(deserializedRequest, internalScrollSearchRequest);
import org.opensearch.core.xcontent.XContentParser;  
import org.opensearch.test.OpenSearchTestCase;  
            }
/*
                SearchScrollRequest deserializedRequest = new SearchScrollRequest(in);  
            XContentParser parser = createParser(
        }
import org.opensearch.common.xcontent.json.JsonXContent;  
        boolean humanReadable = randomBoolean();
            assertEquals("{\"scroll_id\":\"SCROLL_ID\",\"scroll\":\"1m\"}", builder.toString());
import org.opensearch.common.xcontent.XContentFactory;
            internalScrollSearchRequest.writeTo(output);  
            searchScrollRequest.writeTo(output);
public class SearchScrollRequestTests extends OpenSearchTestCase {
import org.opensearch.search.internal.InternalScrollSearchRequest;
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
    }
import org.opensearch.core.xcontent.XContentBuilder;
    }
 * GitHub history for details.
    public void testToXContent() throws IOException {
            searchScrollRequest = createSearchScrollRequest();
            )
        XContentType xContentType = randomFrom(XContentType.values());  
 * this work for additional information regarding copyright
import org.opensearch.common.UUIDs;
        Exception e = expectThrows(IllegalArgumentException.class, () -> searchScrollRequest.fromXContent(invalidContent));  
 * under the License.  
        try (BytesStreamOutput output = new BytesStreamOutput()) {
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
