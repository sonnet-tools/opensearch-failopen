 * this file be licensed under the Apache-2.0 license or a
                .endObject()
            assertThat(req.toString(), containsString(items.toString()));
                }
 *
                .endObject()
            MultiGetRequest expected = createTestInstance();
                mgr.add(defaultIndex, null, fetchSource, null, parser, true);
        }
import org.opensearch.action.get.MultiGetRequest.Item;
            }
 * KIND, either express or implied.  See the License for the
                .startObject()
 * software distributed under the License is distributed on an
        final XContentBuilder builder = XContentFactory.jsonBuilder();
import org.opensearch.index.VersionType;
    }
            if (randomBoolean()) {
    }
        builder.endObject();
        XContentParser parser = createParser(
                .startObject()
        assertThat(e.toString(), containsString("unexpected token [START_OBJECT], expected [FIELD_NAME] or [START_ARRAY]"));
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
            builder.endObject();
            }
        assertEquals(2, multiGetRequest.getItems().size());
 *
import org.opensearch.common.xcontent.XContentType;
    private MultiGetRequest createTestInstance() {
        multiGetRequest.add(randomAlphaOfLength(5), null, FetchSourceContext.FETCH_SOURCE, null, parser, true);
                    MultiGetRequest.Item actualItem = actual.items.get(i);
            try (XContentParser parser = createParser(xContentType.xContent(), shuffled)) {
        builder.startObject();
        int numItems = randomIntBetween(0, 128);
            final ParsingException e = expectThrows(ParsingException.class, () -> {
            if (randomBoolean()) {
            }
            builder.startArray("doc");
                    builder.field("_id", "1");
            }
            builder.startObject("docs");
                item.storedFields(generateRandomStringArray(16, 8, false));
    }
 * Unless required by applicable law or agreed to in writing,
        final XContentParser parser = createParser(builder);
import static org.hamcrest.Matchers.containsString;
    public void testAddWithValidSourceValueIsAccepted() throws Exception {
                    );
                .startObject()
        }
            BytesReference shuffled = toShuffledXContent(expected, xContentType, ToXContent.EMPTY_PARAMS, false);
        final MultiGetRequest mgr = new MultiGetRequest();
        }
                        generateRandomStringArray(5, 4, false)
                {
            final FetchSourceContext fetchSource = FetchSourceContext.FETCH_SOURCE;
            XContentFactory.jsonBuilder()
                MultiGetRequest actual = new MultiGetRequest();
                        true,
 * the Apache License, Version 2.0 (the "License"); you may
                for (int i = 0; i < expected.items.size(); i++) {
 */
                final String defaultIndex = randomAlphaOfLength(5);
 */
                item.fetchSourceContext(fetchSourceContext);
 * SPDX-License-Identifier: Apache-2.0
                .endArray()
            MultiGetRequest.Item item = new MultiGetRequest.Item(randomAlphaOfLength(4), randomAlphaOfLength(4));
                    fetchSourceContext = new FetchSourceContext(
                        generateRandomStringArray(16, 8, false),
                    MultiGetRequest.Item expectedItem = expected.items.get(i);
                if (randomBoolean()) {
                assertThat(parser.nextToken(), nullValue());
                builder.endObject();
public class MultiGetRequestTests extends OpenSearchTestCase {
                .field("_source", randomBoolean())
                    fetchSourceContext = FetchSourceContext.DO_NOT_FETCH_SOURCE;
                    assertThat(actualItem, equalTo(expectedItem));
                builder.field("_type", "type");
        for (int i = 0; i < numItems; i++) {
import org.opensearch.search.fetch.subphase.FetchSourceContext;
 * You may obtain a copy of the License at
        {
        });
 * under the License.
        MultiGetRequest req = createTestInstance();
import static org.hamcrest.Matchers.nullValue;
import org.opensearch.core.common.ParsingException;
            if (randomBoolean()) {
                assertThat(actual.items.size(), equalTo(expected.items.size()));
                } else {
        final ParsingException e = expectThrows(ParsingException.class, () -> {
 *
        for (Item items : req.getItems()) {
                }
                builder.startObject();
            {
 */
        }
                }
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.ToXContent;
            mgr.add(defaultIndex, null, fetchSource, null, parser, true);
    public void testToString() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return request;
import org.opensearch.core.xcontent.XContentParser;
        MultiGetRequest multiGetRequest = new MultiGetRequest();
            request.add(item);
            final MultiGetRequest mgr = new MultiGetRequest();
                item.version(randomNonNegativeLong());
    }
                item.versionType(randomFrom(VersionType.values()));
 * specific language governing permissions and limitations
                actual.add(null, null, null, null, parser, true);
 * ownership. Elasticsearch licenses this file to you under
        MultiGetRequest request = new MultiGetRequest();
import java.io.IOException;
 * this work for additional information regarding copyright
        for (int runs = 0; runs < 20; runs++) {
package org.opensearch.action.get;
            }
 * license agreements. See the NOTICE file distributed with
    public void testUnexpectedField() throws IOException {
                .startArray("docs")
import static org.hamcrest.Matchers.equalTo;
 * compatible open source license.
    public void testXContentSerialization() throws IOException {
}
 * Modifications Copyright OpenSearch Contributors. See
            if (randomBoolean()) {
            }
                item.routing(randomAlphaOfLength(4));
import org.opensearch.core.xcontent.XContentBuilder;
        }
 * The OpenSearch Contributors require contributions made to
                .endObject()
import org.opensearch.common.xcontent.XContentFactory;
            }
            builder.endArray();
                final FetchSourceContext fetchSource = FetchSourceContext.FETCH_SOURCE;
        final XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
            if (randomBoolean()) {
            }
 * Licensed to Elasticsearch under one or more contributor
        try (XContentParser parser = createParser(builder)) {
    }
                .field("_source", randomFrom("false", "true"))
            XContentType xContentType = randomFrom(XContentType.values());
import org.opensearch.core.common.bytes.BytesReference;
    }
    public void testAddWithInvalidKey() throws IOException {
        {
import org.opensearch.test.OpenSearchTestCase;
/*
                builder.field("_id", "1");
            final String defaultIndex = randomAlphaOfLength(5);
            assertThat(e.toString(), containsString("unknown key [doc] for a START_ARRAY, expected [docs] or [ids]"));
 * GitHub history for details.
        builder.endObject();
        );
/*
        }
            });
                    builder.field("_type", "type");
                FetchSourceContext fetchSourceContext;
            {
