 *
        );
            String output = Strings.toString(MediaTypeRegistry.JSON, getResponse);
        GetResponse expectedGetResponse = new GetResponse(tuple.v2());
 *
        checkEqualsAndHashCode(
            String output = Strings.toString(MediaTypeRegistry.JSON, getResponse);
package org.opensearch.action.get;
                "{\"_index\":\"index\",\"_id\":\"id\",\"_version\":1,\"_seq_no\":0,\"_primary_term\":1,"
import org.opensearch.common.xcontent.XContentType;
                null
 * Modifications Copyright OpenSearch Contributors. See
            GetResponseTests::mutateGetResponse
        doFromXContentTestWithRandomFields(true);
        // check that the source stays unchanged, no shuffling of keys nor anything like that
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
                1,
            "{\"_index\":\"index\",\"_id\":\"id\",\"_version\":1,\"_seq_no\":0,\"_primary_term\":1,"
import org.opensearch.core.common.bytes.BytesReference;
    }
            new GetResult(null, null, UNASSIGNED_SEQ_NO, 0, randomIntBetween(1, 5), randomBoolean(), null, null, null)
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
    }
            GetResponse getResponse = new GetResponse(
        }
        BytesReference finalBytes = toXContent(parsedGetResponse, xContentType, humanReadable);
 * Unless required by applicable law or agreed to in writing,
                Collections.singletonMap("field1", new DocumentField("field1", Collections.singletonList("value1"))),
                "index",
    public void testToXContent() {
                "id",
        BytesReference originalBytes = toShuffledXContent(getResponse, xContentType, ToXContent.EMPTY_PARAMS, randomBoolean());
import org.opensearch.core.xcontent.ToXContent;
            // randomized in the randomGetResult() method anyway. Also, we cannot add anything in the root object since this is
        );
     * ensure we can parse it back to be forward compatible with additions to
        assertEquals(expectedGetResponse.getSourceAsMap(), parsedGetResponse.getSourceAsMap());
            mutated = insertRandomFields(xContentType, originalBytes, excludeFilter, random());
     * the xContent
                )
            // "_source" and "fields" just consists of key/value pairs, we shouldn't add anything random there. It is already
 * this file be licensed under the Apache-2.0 license or a
                1,
 * ownership. Elasticsearch licenses this file to you under
            assertEquals(
/*
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    1,
    private static GetResponse mutateGetResponse(GetResponse getResponse) {
    /**
        }
        BytesReference originalBytes = toShuffledXContent(getResponse, xContentType, ToXContent.EMPTY_PARAMS, humanReadable, "_source");
    }
            getResponse.toString()
        GetResponse getResponse = new GetResponse(tuple.v1());
 * SPDX-License-Identifier: Apache-2.0
        XContentType xContentType = randomFrom(XContentType.values());
        );
                output
    public void testFromXContentThrowsParsingException() throws IOException {
import org.opensearch.core.common.ParsingException;
import org.opensearch.common.collect.Tuple;
import java.util.Collections;
            Predicate<String> excludeFilter = (s) -> s.isEmpty() || s.contains("fields") || s.contains("_source");
import org.opensearch.index.get.GetResult;
                    "id",
        assertToXContentEquivalent(originalBytes, finalBytes, xContentType);
 * Licensed to Elasticsearch under one or more contributor
            GetResponse getResponse = new GetResponse(new GetResult("index", "id", UNASSIGNED_SEQ_NO, 0, 1, false, null, null, null));
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
        assertEquals(expectedGetResponse.getSourceAsString(), parsedGetResponse.getSourceAsString());
 * license agreements. See the NOTICE file distributed with
/*
        );
                new GetResult(
 * You may obtain a copy of the License at
 * under the License.
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
        boolean humanReadable = randomBoolean();
import static org.opensearch.index.get.GetResultTests.mutateGetResult;
    }
public class GetResponseTests extends OpenSearchTestCase {
                + "\"found\":true,\"_source\":{ \"field1\" : \"value1\", \"field2\":\"value2\"},\"fields\":{\"field1\":[\"value1\"]}}",
            assertEquals("{\"_index\":\"index\",\"_id\":\"id\",\"found\":false}", output);
            )
 * compatible open source license.
import org.opensearch.core.xcontent.XContentParser;
            );
    public void testToAndFromXContent() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    1,
 * The OpenSearch Contributors require contributions made to
                    "index",
                    0,
    public void testEqualsAndHashcode() {
 * this work for additional information regarding copyright
    }
        } else {
                    Collections.singletonMap("field1", new DocumentField("field1", Collections.singletonList("value1"))),
    }
    }
 * not use this file except in compliance with the License.
            parsedGetResponse = GetResponse.fromXContent(parser);
     */
import org.opensearch.core.common.Strings;
        {
    private static GetResponse copyGetResponse(GetResponse getResponse) {
import org.opensearch.core.common.bytes.BytesArray;
            ParsingException exception = expectThrows(ParsingException.class, () -> GetResponse.fromXContent(parser));
            mutated = originalBytes;
/*
        XContentType xContentType = randomFrom(XContentType.values());
        doFromXContentTestWithRandomFields(false);
            new GetResult(
import java.util.function.Predicate;
        }
                true,
        try (XContentParser parser = createParser(xContentType.xContent(), mutated)) {
    }
        GetResponse getResponse = new GetResponse(
        Tuple<GetResult, GetResult> tuple = randomGetResult(xContentType);
                    + "\"found\":true,\"_source\":{ \"field1\" : \"value1\", \"field2\":\"value2\"},\"fields\":{\"field1\":[\"value1\"]}}",
            new GetResponse(randomGetResult(MediaTypeRegistry.JSON).v1()),
        // print the parsed object out and test that the output is the same as the original output
            // where GetResult's metadata fields are rendered out while // other fields are rendered out in a "fields" object.
import org.opensearch.test.OpenSearchTestCase;
import java.io.IOException;
import org.opensearch.common.document.DocumentField;
            );
                    new BytesArray("{ \"field1\" : " + "\"value1\", \"field2\":\"value2\"}"),
     * This test adds random fields and objects to the xContent rendered out to
        if (addRandomFields) {
                    true,
        }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        BytesReference mutated;
            assertNull(parser.nextToken());
        GetResponse parsedGetResponse;
    }
        GetResponse getResponse = new GetResponse(
 * specific language governing permissions and limitations
 * GitHub history for details.
}
        return new GetResponse(copyGetResult(getResponse.getResult));
        }
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
import static org.opensearch.index.get.GetResultTests.randomGetResult;
                0,
                    null
            GetResponseTests::copyGetResponse,
    private void doFromXContentTestWithRandomFields(boolean addRandomFields) throws IOException {
        {
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
    public void testFromXContentWithRandomFields() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
 */
import static org.opensearch.index.get.GetResultTests.copyGetResult;
            assertEquals("Missing required fields [_index,_id]", exception.getMessage());
                new BytesArray("{ \"field1\" : " + "\"value1\", \"field2\":\"value2\"}"),
 */
        return new GetResponse(mutateGetResult(getResponse.getResult));
 */
    public void testToString() {
        assertEquals(
