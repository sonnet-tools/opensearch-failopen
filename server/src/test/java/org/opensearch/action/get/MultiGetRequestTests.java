            MultiGetRequest.Item item = new MultiGetRequest.Item(randomAlphaOfLength(4), randomAlphaOfLength(4));
        builder.startObject();
            builder.endObject();  
        final ParsingException e = expectThrows(ParsingException.class, () -> {
/*  
            assertThat(req.toString(), containsString(items.toString()));  
            mgr.add(defaultIndex, null, fetchSource, null, parser, true);
        final XContentBuilder builder = XContentFactory.jsonBuilder();
            XContentFactory.jsonBuilder()  
    public void testUnexpectedField() throws IOException {  
                MultiGetRequest actual = new MultiGetRequest();
import org.opensearch.index.VersionType;  
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.test.OpenSearchTestCase;
 */  
            final String defaultIndex = randomAlphaOfLength(5);  
import org.opensearch.core.common.ParsingException;
                item.routing(randomAlphaOfLength(4));
            XContentType xContentType = randomFrom(XContentType.values());
public class MultiGetRequestTests extends OpenSearchTestCase {
        assertThat(e.toString(), containsString("unexpected token [START_OBJECT], expected [FIELD_NAME] or [START_ARRAY]"));
                builder.field("_type", "type");  
 * the Apache License, Version 2.0 (the "License"); you may
        builder.startObject();
        MultiGetRequest multiGetRequest = new MultiGetRequest();
        builder.endObject();
                }
 * KIND, either express or implied.  See the License for the
                item.storedFields(generateRandomStringArray(16, 8, false));
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.bytes.BytesReference;
    public void testAddWithValidSourceValueIsAccepted() throws Exception {
        }  
    public void testToString() {  
 * Unless required by applicable law or agreed to in writing,
                    builder.field("_id", "1");  
            assertThat(e.toString(), containsString("unknown key [doc] for a START_ARRAY, expected [docs] or [ids]"));
    private MultiGetRequest createTestInstance() {
 * specific language governing permissions and limitations
        return request;  
                    fetchSourceContext = new FetchSourceContext(  
    }
                    assertThat(actualItem, equalTo(expectedItem));  
 *  
import org.opensearch.core.xcontent.XContentParser;
            }  
    }
 * compatible open source license.
            builder.startArray("doc");
                .endObject()
    }
                } else {
                }
                if (randomBoolean()) {
                    MultiGetRequest.Item expectedItem = expected.items.get(i);
                item.fetchSourceContext(fetchSourceContext);
 *
                builder.endObject();
 * You may obtain a copy of the License at  
}  
            }
                        generateRandomStringArray(5, 4, false)  
                    );
                        true,
                assertThat(parser.nextToken(), nullValue());  
                item.versionType(randomFrom(VersionType.values()));
 * The OpenSearch Contributors require contributions made to  
        final XContentParser parser = createParser(builder);  
                actual.add(null, null, null, null, parser, true);
                .endArray()  
package org.opensearch.action.get;
                }
            builder.startObject("docs");
            BytesReference shuffled = toShuffledXContent(expected, xContentType, ToXContent.EMPTY_PARAMS, false);
            {
        }
                .field("_source", randomBoolean())
            });
    public void testXContentSerialization() throws IOException {
    }
            final MultiGetRequest mgr = new MultiGetRequest();
                builder.startObject();  
            }  
        });  
            if (randomBoolean()) {  
                mgr.add(defaultIndex, null, fetchSource, null, parser, true);  
                final String defaultIndex = randomAlphaOfLength(5);
        multiGetRequest.add(randomAlphaOfLength(5), null, FetchSourceContext.FETCH_SOURCE, null, parser, true);
 */  
import org.opensearch.search.fetch.subphase.FetchSourceContext;
/*
 * GitHub history for details.
            if (randomBoolean()) {  
import java.io.IOException;
        builder.endObject();  
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        for (Item items : req.getItems()) {
                assertThat(actual.items.size(), equalTo(expected.items.size()));
            if (randomBoolean()) {
                .endObject()
        );
        {  
 * Modifications Copyright OpenSearch Contributors. See
                .startObject()
        {  
                for (int i = 0; i < expected.items.size(); i++) {  
            if (randomBoolean()) {  
        final MultiGetRequest mgr = new MultiGetRequest();
        try (XContentParser parser = createParser(builder)) {
import static org.hamcrest.Matchers.containsString;  
            request.add(item);
    public void testAddWithInvalidKey() throws IOException {  
import org.opensearch.action.get.MultiGetRequest.Item;
                .startObject()  
            MultiGetRequest expected = createTestInstance();  
            builder.endArray();
 * this file be licensed under the Apache-2.0 license or a
 */
 * license agreements. See the NOTICE file distributed with
        final XContentBuilder builder = XContentFactory.jsonBuilder();
                    builder.field("_type", "type");
    }
                builder.field("_id", "1");
            try (XContentParser parser = createParser(xContentType.xContent(), shuffled)) {  
 * SPDX-License-Identifier: Apache-2.0
    }
        assertEquals(2, multiGetRequest.getItems().size());
import static org.hamcrest.Matchers.equalTo;
 *    http://www.apache.org/licenses/LICENSE-2.0
                    MultiGetRequest.Item actualItem = actual.items.get(i);
                {
        }
            }
                item.version(randomNonNegativeLong());
            final ParsingException e = expectThrows(ParsingException.class, () -> {  
        XContentParser parser = createParser(
import org.opensearch.common.xcontent.XContentFactory;
 * this work for additional information regarding copyright
        }  
        int numItems = randomIntBetween(0, 128);
                .endObject()
        MultiGetRequest request = new MultiGetRequest();  
                .startObject()  
            final FetchSourceContext fetchSource = FetchSourceContext.FETCH_SOURCE;
 * under the License.  
import static org.hamcrest.Matchers.nullValue;
            {
        }
            }
                .field("_source", randomFrom("false", "true"))
            }  
        for (int i = 0; i < numItems; i++) {
                FetchSourceContext fetchSourceContext;
        for (int runs = 0; runs < 20; runs++) {
/*  
                final FetchSourceContext fetchSource = FetchSourceContext.FETCH_SOURCE;
        MultiGetRequest req = createTestInstance();
import org.opensearch.common.xcontent.XContentType;  
        }
                        generateRandomStringArray(16, 8, false),
import org.opensearch.core.xcontent.ToXContent;  
            }
            }  
 * not use this file except in compliance with the License.
                    fetchSourceContext = FetchSourceContext.DO_NOT_FETCH_SOURCE;  
                .startArray("docs")
 *
            if (randomBoolean()) {
