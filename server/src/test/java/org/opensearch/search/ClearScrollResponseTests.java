 *
import java.io.IOException;  
        BytesReference parsedBytes = XContentHelper.toXContent(parsedResponse, mediaType, randomBoolean());
import org.opensearch.core.xcontent.XContentBuilder;
/*  
 *
import org.opensearch.core.xcontent.ToXContent;  
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
public class ClearScrollResponseTests extends OpenSearchTestCase {
        }
import org.opensearch.common.xcontent.json.JsonXContent;  
        assertEquals(originalResponse.isSucceeded(), parsedResponse.isSucceeded());
 * software distributed under the License is distributed on an
import org.opensearch.core.common.bytes.BytesReference;
    public void testToXContent() throws IOException {  
        MediaType mediaType = randomFrom(XContentType.values());
        assertEquals(10, clearScrollResponse.getNumFreed());  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
        try (XContentParser parser = createParser(mediaType.xContent(), originalBytes)) {
 */
/*  
        try (XContentBuilder builder = JsonXContent.contentBuilder()) {
import org.opensearch.common.xcontent.XContentType;
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.XContentParser;  
    }
        ClearScrollResponse parsedResponse;
        ClearScrollResponse originalResponse = createTestItem();
 * ownership. Elasticsearch licenses this file to you under  
        return new ClearScrollResponse(randomBoolean(), randomIntBetween(0, Integer.MAX_VALUE));  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.test.OpenSearchTestCase;
}
 * under the License.  
        ClearScrollResponse clearScrollResponse = new ClearScrollResponse(true, 10);
import org.opensearch.core.xcontent.XContentHelper;
        assertToXContentEquivalent(originalBytes, parsedBytes, mediaType);
        }
 *  
        assertEquals(true, clearScrollResponse.isSucceeded());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        BytesReference originalBytes = toShuffledXContent(originalResponse, mediaType, ToXContent.EMPTY_PARAMS, randomBoolean());  
            clearScrollResponse.toXContent(builder, ToXContent.EMPTY_PARAMS);  
    }  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.search;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.MediaType;
            parsedResponse = ClearScrollResponse.fromXContent(parser);  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
 */  
 * The OpenSearch Contributors require contributions made to  
    private static ClearScrollResponse createTestItem() {
        assertEquals(originalResponse.getNumFreed(), parsedResponse.getNumFreed());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
 */  
    }
import org.opensearch.action.search.ClearScrollResponse;
/*
 * GitHub history for details.
    public void testToAndFromXContent() throws IOException {  
 * the Apache License, Version 2.0 (the "License"); you may
