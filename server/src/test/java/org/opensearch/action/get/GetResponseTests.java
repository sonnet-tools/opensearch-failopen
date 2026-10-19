import org.opensearch.core.common.bytes.BytesReference;
import static org.opensearch.index.get.GetResultTests.copyGetResult;
            );  
            Predicate<String> excludeFilter = (s) -> s.isEmpty() || s.contains("fields") || s.contains("_source");
/*
        boolean humanReadable = randomBoolean();
 * compatible open source license.
public class GetResponseTests extends OpenSearchTestCase {  
            assertEquals("Missing required fields [_index,_id]", exception.getMessage());  
     * ensure we can parse it back to be forward compatible with additions to
 *
}
 * not use this file except in compliance with the License.
    }
 */
        {
 * You may obtain a copy of the License at  
import org.opensearch.common.xcontent.XContentType;  
                Collections.singletonMap("field1", new DocumentField("field1", Collections.singletonList("value1"))),
import org.opensearch.core.common.Strings;
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
        try (XContentParser parser = createParser(xContentType.xContent(), mutated)) {
    public void testFromXContentWithRandomFields() throws IOException {
            new GetResponse(randomGetResult(MediaTypeRegistry.JSON).v1()),
import org.opensearch.common.collect.Tuple;
    public void testToAndFromXContent() throws Exception {
        GetResponse getResponse = new GetResponse(  
        }
     * This test adds random fields and objects to the xContent rendered out to
import static org.opensearch.test.XContentTestUtils.insertRandomFields;  
import org.opensearch.common.document.DocumentField;
        BytesReference originalBytes = toShuffledXContent(getResponse, xContentType, ToXContent.EMPTY_PARAMS, randomBoolean());
 */  
import org.opensearch.core.common.ParsingException;
    public void testFromXContentThrowsParsingException() throws IOException {
 *  
    }
    }
            mutated = originalBytes;
                    true,
    private void doFromXContentTestWithRandomFields(boolean addRandomFields) throws IOException {  
            assertEquals(
            // "_source" and "fields" just consists of key/value pairs, we shouldn't add anything random there. It is already
            GetResponse getResponse = new GetResponse(new GetResult("index", "id", UNASSIGNED_SEQ_NO, 0, 1, false, null, null, null));  
 * Licensed to Elasticsearch under one or more contributor  
                0,
        BytesReference finalBytes = toXContent(parsedGetResponse, xContentType, humanReadable);
        }
 * the Apache License, Version 2.0 (the "License"); you may
            String output = Strings.toString(MediaTypeRegistry.JSON, getResponse);
import org.opensearch.core.xcontent.XContentParser;
        doFromXContentTestWithRandomFields(false);  
import org.opensearch.core.common.bytes.BytesArray;  
        assertEquals(
                    + "\"found\":true,\"_source\":{ \"field1\" : \"value1\", \"field2\":\"value2\"},\"fields\":{\"field1\":[\"value1\"]}}",
        // check that the source stays unchanged, no shuffling of keys nor anything like that  
        return new GetResponse(copyGetResult(getResponse.getResult));
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
    }
package org.opensearch.action.get;
import org.opensearch.index.get.GetResult;
    }  
                "{\"_index\":\"index\",\"_id\":\"id\",\"_version\":1,\"_seq_no\":0,\"_primary_term\":1,"  
import static org.opensearch.index.get.GetResultTests.mutateGetResult;
        Tuple<GetResult, GetResult> tuple = randomGetResult(xContentType);
        assertEquals(expectedGetResponse.getSourceAsMap(), parsedGetResponse.getSourceAsMap());
        assertToXContentEquivalent(originalBytes, finalBytes, xContentType);
 * specific language governing permissions and limitations
import java.util.function.Predicate;
        if (addRandomFields) {  
     */
                    "id",  
                + "\"found\":true,\"_source\":{ \"field1\" : \"value1\", \"field2\":\"value2\"},\"fields\":{\"field1\":[\"value1\"]}}",
            assertEquals("{\"_index\":\"index\",\"_id\":\"id\",\"found\":false}", output);
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
    }
        XContentType xContentType = randomFrom(XContentType.values());
            // where GetResult's metadata fields are rendered out while // other fields are rendered out in a "fields" object.  
                    1,
 * license agreements. See the NOTICE file distributed with
                    Collections.singletonMap("field1", new DocumentField("field1", Collections.singletonList("value1"))),  
    public void testEqualsAndHashcode() {  
        checkEqualsAndHashCode(
            assertNull(parser.nextToken());  
/*  
                    1,  
 *
        BytesReference originalBytes = toShuffledXContent(getResponse, xContentType, ToXContent.EMPTY_PARAMS, humanReadable, "_source");  
                    0,
import org.opensearch.test.OpenSearchTestCase;  
            ParsingException exception = expectThrows(ParsingException.class, () -> GetResponse.fromXContent(parser));
 * under the License.  
        );
import static org.opensearch.index.get.GetResultTests.randomGetResult;  
        );
 * SPDX-License-Identifier: Apache-2.0
 */  
        assertEquals(expectedGetResponse.getSourceAsString(), parsedGetResponse.getSourceAsString());
            mutated = insertRandomFields(xContentType, originalBytes, excludeFilter, random());
 * KIND, either express or implied.  See the License for the
                "id",
    }  
        BytesReference mutated;
        GetResponse getResponse = new GetResponse(
            GetResponseTests::mutateGetResponse
    public void testToString() {  
                new GetResult(
            GetResponseTests::copyGetResponse,  
                1,
 * ownership. Elasticsearch licenses this file to you under  
            new GetResult(
        GetResponse getResponse = new GetResponse(tuple.v1());  
import org.opensearch.core.xcontent.MediaTypeRegistry;
                )
                "index",  
    /**  
    private static GetResponse mutateGetResponse(GetResponse getResponse) {
 * The OpenSearch Contributors require contributions made to  
        // print the parsed object out and test that the output is the same as the original output  
            "{\"_index\":\"index\",\"_id\":\"id\",\"_version\":1,\"_seq_no\":0,\"_primary_term\":1,"  
            parsedGetResponse = GetResponse.fromXContent(parser);
                    new BytesArray("{ \"field1\" : " + "\"value1\", \"field2\":\"value2\"}"),
        );  
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
                null
        XContentType xContentType = randomFrom(XContentType.values());
            String output = Strings.toString(MediaTypeRegistry.JSON, getResponse);
        {
    }
        GetResponse parsedGetResponse;  
import org.opensearch.core.xcontent.ToXContent;  
        }  
 * this work for additional information regarding copyright
    }
                1,  
 * software distributed under the License is distributed on an
                true,
                new BytesArray("{ \"field1\" : " + "\"value1\", \"field2\":\"value2\"}"),  
        }
        } else {  
    public void testToXContent() {
            // randomized in the randomGetResult() method anyway. Also, we cannot add anything in the root object since this is
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;  
            GetResponse getResponse = new GetResponse(  
        );
        }
        return new GetResponse(mutateGetResult(getResponse.getResult));  
            getResponse.toString()
        doFromXContentTestWithRandomFields(true);  
        GetResponse expectedGetResponse = new GetResponse(tuple.v2());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * the xContent  
    private static GetResponse copyGetResponse(GetResponse getResponse) {
 * Modifications Copyright OpenSearch Contributors. See
                    null
                output
import static org.opensearch.core.xcontent.XContentHelper.toXContent;  
/*  
import java.io.IOException;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
            );  
            new GetResult(null, null, UNASSIGNED_SEQ_NO, 0, randomIntBetween(1, 5), randomBoolean(), null, null, null)
            )  
                    "index",
