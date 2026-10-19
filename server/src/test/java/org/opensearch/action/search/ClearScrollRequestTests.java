        Exception e = expectThrows(IllegalArgumentException.class, () -> clearScrollRequest.fromXContent(invalidContent));
 * the Apache License, Version 2.0 (the "License"); you may
        }
 *
 * GitHub history for details.
    }  
import static org.hamcrest.Matchers.contains;
            clearScrollRequest = createClearScrollRequest();
        assertThat(clearScrollRequest.scrollIds(), contains("value_1", "value_2"));
    }  
import org.opensearch.test.OpenSearchTestCase;  
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
public class ClearScrollRequestTests extends OpenSearchTestCase {
/*  
            assertEquals("{\"scroll_id\":[\"SCROLL_ID\"]}", builder.toString());
        if (randomBoolean()) {  
            clearScrollRequest.fromXContent(parser);  
import java.io.IOException;
import org.opensearch.core.common.bytes.BytesReference;
        for (int i = 0; i < numScrolls; i++) {
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
    public void testFromXContentWithUnknownParamThrowsException() throws Exception {
        ClearScrollRequest clearScrollRequest = new ClearScrollRequest();
 * Modifications Copyright OpenSearch Contributors. See
        try (XContentBuilder builder = JsonXContent.contentBuilder()) {  
 * SPDX-License-Identifier: Apache-2.0
            clearScrollRequest.addScrollId(randomAlphaOfLengthBetween(3, 10));
 *  
        BytesReference originalBytes = toShuffledXContent(originalRequest, xContentType, ToXContent.EMPTY_PARAMS, randomBoolean());  
        try (
    public static ClearScrollRequest createClearScrollRequest() {
        XContentType xContentType = randomFrom(XContentType.values());
        clearScrollRequest.addScrollId("SCROLL_ID");
        int numScrolls = randomIntBetween(1, 10);  
 * ownership. Elasticsearch licenses this file to you under  
            parsedRequest.fromXContent(parser);  
        ClearScrollRequest parsedRequest = new ClearScrollRequest();
        ClearScrollRequest originalRequest = createClearScrollRequest();
            XContentFactory.jsonBuilder().startObject().array("scroll_id", "value_1", "value_2").field("unknown", "keyword").endObject()
            // test that existing values get overridden
import org.opensearch.common.xcontent.XContentType;
 * The OpenSearch Contributors require contributions made to  
        assertEquals(originalRequest.scrollIds(), parsedRequest.scrollIds());
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.XContentBuilder;  
        assertThat(e.getMessage(), startsWith("Unknown parameter [unknown]"));  
import org.opensearch.common.xcontent.XContentFactory;
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
            clearScrollRequest.toXContent(builder, ToXContent.EMPTY_PARAMS);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
    public void testFromXContent() throws Exception {
            // test that existing values get overridden
        assertToXContentEquivalent(originalBytes, parsedBytes, xContentType);
    }
 * Licensed to Elasticsearch under one or more contributor  
    public void testFromXContentWithoutArray() throws Exception {
package org.opensearch.action.search;
        }  
        ) {
        }
            clearScrollRequest = createClearScrollRequest();  
    }
            clearScrollRequest.fromXContent(parser);  
        try (XContentParser parser = createParser(XContentFactory.jsonBuilder().startObject().field("scroll_id", "value_1").endObject())) {
    public void testToXContent() throws IOException {  
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
        assertThat(clearScrollRequest.scrollIds(), contains("value_1"));
 *
            XContentParser parser = createParser(
/*
 */  
    }
import static org.hamcrest.Matchers.startsWith;  
import org.opensearch.common.xcontent.json.JsonXContent;  
        ClearScrollRequest clearScrollRequest = new ClearScrollRequest();  
        if (randomBoolean()) {
import org.opensearch.core.xcontent.XContentParser;
        BytesReference parsedBytes = XContentHelper.toXContent(parsedRequest, xContentType, randomBoolean());  
    public void testFromAndToXContent() throws IOException {  
/*  
        );
        }  
        ClearScrollRequest clearScrollRequest = new ClearScrollRequest();
 * under the License.  
        XContentParser invalidContent = createParser(  
 */  
        }  
        ClearScrollRequest clearScrollRequest = new ClearScrollRequest();
            )
        return clearScrollRequest;
}  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.xcontent.XContentHelper;
        ClearScrollRequest clearScrollRequest = new ClearScrollRequest();  
                XContentFactory.jsonBuilder().startObject().array("scroll_id", "value_1", "value_2").endObject()  
        }
    }
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
        }
import org.opensearch.core.xcontent.ToXContent;
