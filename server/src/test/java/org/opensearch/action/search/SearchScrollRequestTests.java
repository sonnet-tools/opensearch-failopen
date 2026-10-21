        boolean humanReadable = randomBoolean();
 * under the License.
import org.opensearch.search.internal.ShardSearchContextId;
 * compatible open source license.
        SearchScrollRequest searchScrollRequest = createSearchScrollRequest();
    }
    public void testToXContent() throws IOException {
                assertEquals(deserializedRequest.scroll(), internalScrollSearchRequest.scroll());
        SearchScrollRequest parsedRequest = new SearchScrollRequest();
        );
import static org.hamcrest.Matchers.startsWith;
        if (randomBoolean()) {
    public void testSerialization() throws Exception {
                InternalScrollSearchRequest deserializedRequest = new InternalScrollSearchRequest(in);
    }
        }
        } else {
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
    }
            try (StreamInput in = output.bytes().streamInput()) {
            return copy.scrollId(original.scrollId() + "xyz");
                SearchScrollRequest deserializedRequest = new SearchScrollRequest(in);
            assertEquals("{\"scroll_id\":\"SCROLL_ID\",\"scroll\":\"1m\"}", builder.toString());
        ) {
            searchScrollRequest.writeTo(output);
                assertNotSame(deserializedRequest, searchScrollRequest);
 *
        checkEqualsAndHashCode(createSearchScrollRequest(), SearchScrollRequestTests::copyRequest, SearchScrollRequestTests::mutate);
        );
import org.opensearch.common.xcontent.json.JsonXContent;
        }
 * this file be licensed under the Apache-2.0 license or a
            )
        XContentType xContentType = randomFrom(XContentType.values());
            internalScrollSearchRequest.writeTo(output);
        searchScrollRequest.scroll("1m");
            return copy.scroll(new TimeValue(original.scroll().keepAlive().getMillis() + 1));
    public void testEqualsAndHashcode() {
 * license agreements. See the NOTICE file distributed with
                assertEquals(deserializedRequest.contextId().getId(), internalScrollSearchRequest.contextId().getId());
        if (randomBoolean()) {
        SearchScrollRequest copy = copyRequest(original);
            XContentParser parser = createParser(
 * Unless required by applicable law or agreed to in writing,
    }
        try (XContentBuilder builder = JsonXContent.contentBuilder()) {
 */
import org.opensearch.core.common.io.stream.StreamInput;
 *
        }
                XContentFactory.jsonBuilder().startObject().field("scroll_id", "SCROLL_ID").field("scroll", "1m").endObject()
            }
    }
import org.opensearch.search.internal.InternalScrollSearchRequest;
    }
 * ownership. Elasticsearch licenses this file to you under
    public void testFromXContent() throws Exception {
 */
 * not use this file except in compliance with the License.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
                assertEquals(deserializedRequest, searchScrollRequest);
        return result;
    private static SearchScrollRequest mutate(SearchScrollRequest original) {
import org.opensearch.core.xcontent.XContentBuilder;
        Exception e = expectThrows(IllegalArgumentException.class, () -> searchScrollRequest.fromXContent(invalidContent));
import org.opensearch.core.common.bytes.BytesReference;
            // test that existing values get overridden
import org.opensearch.core.xcontent.XContentParser;
    }
    private static SearchScrollRequest copyRequest(SearchScrollRequest searchScrollRequest) {
            }
            searchScrollRequest.toXContent(builder, ToXContent.EMPTY_PARAMS);
import org.opensearch.test.OpenSearchTestCase;
import java.io.IOException;
}
        assertEquals(originalRequest, parsedRequest);
        SearchScrollRequest originalRequest = createSearchScrollRequest();
            XContentFactory.jsonBuilder().startObject().field("scroll_id", "value_2").field("unknown", "keyword").endObject()
 */
import org.opensearch.common.UUIDs;
            searchScrollRequest.fromXContent(parser);
        return searchScrollRequest;
import org.opensearch.core.xcontent.ToXContent;
    }
 * KIND, either express or implied.  See the License for the
        assertToXContentEquivalent(originalBytes, parsedBytes, xContentType);
import org.opensearch.core.xcontent.XContentHelper;
 * the Apache License, Version 2.0 (the "License"); you may
        SearchScrollRequest searchScrollRequest = new SearchScrollRequest();
            searchScrollRequest,
    }
        assertEquals("SCROLL_ID", searchScrollRequest.scrollId());
            new ShardSearchContextId(UUIDs.randomBase64UUID(), randomLong())
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(TimeValue.parseTimeValue("1m", null, "scroll"), searchScrollRequest.scroll().keepAlive());
/*
        XContentParser invalidContent = createParser(
        try (
    public void testFromXContentWithUnknownParamThrowsException() throws Exception {
        }
public class SearchScrollRequestTests extends OpenSearchTestCase {
        SearchScrollRequest searchScrollRequest = new SearchScrollRequest();
import org.opensearch.common.unit.TimeValue;
package org.opensearch.action.search;
        SearchScrollRequest searchScrollRequest = new SearchScrollRequest(randomAlphaOfLengthBetween(3, 10));
        }
import org.opensearch.common.xcontent.XContentType;
/*
 * specific language governing permissions and limitations
    public static SearchScrollRequest createSearchScrollRequest() {
            try (StreamInput in = output.bytes().streamInput()) {
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
 * Licensed to Elasticsearch under one or more contributor
 *
 * GitHub history for details.
        assertThat(e.getMessage(), startsWith("Unknown parameter [unknown]"));
                assertNotSame(deserializedRequest, internalScrollSearchRequest);
 * this work for additional information regarding copyright
        BytesReference parsedBytes = XContentHelper.toXContent(parsedRequest, xContentType, humanReadable);
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to
        BytesReference originalBytes = toShuffledXContent(originalRequest, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
        InternalScrollSearchRequest internalScrollSearchRequest = new InternalScrollSearchRequest(
        searchScrollRequest.scroll(randomPositiveTimeValue());
        SearchScrollRequest result = new SearchScrollRequest();
        result.scrollId(searchScrollRequest.scrollId());
        try (BytesStreamOutput output = new BytesStreamOutput()) {
import org.opensearch.common.io.stream.BytesStreamOutput;
        try (BytesStreamOutput output = new BytesStreamOutput()) {
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
/*
import org.opensearch.common.xcontent.XContentFactory;
 * You may obtain a copy of the License at
        }
                assertEquals(deserializedRequest.hashCode(), searchScrollRequest.hashCode());
            searchScrollRequest = createSearchScrollRequest();
        searchScrollRequest.scrollId("SCROLL_ID");
    public void testInternalScrollSearchRequestSerialization() throws IOException {
        SearchScrollRequest searchScrollRequest = createSearchScrollRequest();
        SearchScrollRequest searchScrollRequest = new SearchScrollRequest();
 * SPDX-License-Identifier: Apache-2.0
        result.scroll(searchScrollRequest.scroll());
    public void testToAndFromXContent() throws IOException {
            parsedRequest.fromXContent(parser);
