            out.write(xContentType.xContent().streamSeparator());
        assertEquals(
        String bulkAction = bulk.toString();
    }
                "RefreshPolicy is not supported on an item request. Set it on the BulkRequest instead.",
/*
        BulkRequest bulkRequest = Requests.bulkRequest();
        BulkRequest bulkRequest = new BulkRequest();
        BulkRequest bulkRequest = new BulkRequest();
 * Licensed to Elasticsearch under one or more contributor
        BytesReference data;
    public void testSimpleBulk6() throws Exception {
        } else {
    public void testBulkAllowExplicitIndex() throws Exception {
    public void testSimpleBulk4() throws Exception {
            () -> bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON)
            }
            exc.getMessage(),
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk9.json");
            }
        bulkRequest.add(data, null, xContentType);
        assertThat(bulkRequest.requests().get(2), instanceOf(DeleteRequest.class));
            IllegalArgumentException.class,
        assertThat(bulkRequest.requests().get(1).id(), equalTo("0"));
    public void testSimpleBulk9() throws Exception {
    }
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk10.json");
                builder.endObject();
        assertThat(bulkRequest.numberOfActions(), equalTo(3));
                builder.endObject();
        BulkRequest bulkRequest = new BulkRequest();
        Map<String, Object> scriptParams = script.getParams();
        assertThat(script.getLang(), equalTo("javascript"));
                .count()
            1,
            () -> bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON)
    }
                .filter(msg -> msg.contains("is too long, must be no longer than 512 bytes but was: "))
        // doc id length under limit
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.script.Script;
        bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON);
        StringBuilder bulk = new StringBuilder();
        updateRequest.id(invalidDocID);
 *
/*
        );
        );
            () -> new BulkRequest().add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON)
        expectThrows(NullPointerException.class, () -> bulkRequest.add((IndexRequest) null));
            validate.validationErrors()
        assertEquals("explicit index in bulk is not allowed", ex.getMessage());
        assertThat(bulkRequest.numberOfActions(), equalTo(3));
            ((IndexRequest) bulkRequest.requests().get(0)).source(),
            exc.getMessage(),
        indexRequest.id(invalidDocID);
            exc.getMessage(),
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(DocWriteRequest.OpType.INDEX, docWriteRequest.opType());
            false,
        BytesReference data;
    public void testBulkTerminatedByNewline() throws Exception {
        BulkRequest bulkRequest = new BulkRequest();
            out.write(xContentType.xContent().streamSeparator());
    }
 * under the License.
    }
        String invalidDocID = String.join("", Collections.nCopies(513, "a"));
        // doc id length over limit
    }
        String emptyObject = "{}\r\n";
package org.opensearch.action.bulk;
                values.put("if_seq_no", 1L);
        bulkRequest.add(requests);
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("The bulk request must be terminated by a newline [\\n]", expectThrows.getMessage());
        requests.add(new IndexRequest("test").id("id").source(Requests.INDEX_CONTENT_TYPE, "field", "value"));
import java.io.IOException;
        String bulkAction = "{ \"index\":{\"_index\":\"test\",\"_id\":\"1\"} }\r\n{ \"field1\" : \"value1\" }\r\n";
        );
        ActionRequestValidationException validate = bulkRequest.validate();
 * this work for additional information regarding copyright
                builder.startObject();
            () -> bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON)
        assertThat(script, notNullValue());
        // doc id length over limit
        assertThat(exc.getMessage(), containsString("Unknown key for a VALUE_STRING in [hello]"));
                builder.field("field", "value");
        );
import org.opensearch.core.common.ParsingException;
            "Malformed action/metadata line [1]" + ", expected a simple value for field [_index] but found [START_ARRAY]"
 * You may obtain a copy of the License at
        BulkRequest bulkRequest = new BulkRequest();
    public void testSimpleBulk1() throws Exception {
        );
import org.opensearch.core.xcontent.MediaTypeRegistry;
        IllegalArgumentException expectThrows = expectThrows(
        BulkRequest bulkRequest = new BulkRequest();
            Exception.class,
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk7.json");
}
                builder.startObject("update");
            validate.validationErrors()
                "RefreshPolicy is not supported on an item request. Set it on the BulkRequest instead.",
                builder.field("if_primary_term", 100L);
            () -> bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON)
    public void testSimpleBulk8() throws Exception {
        BulkRequest bulkRequest = new BulkRequest();
    public void testToValidateUpsertRequestAndCASInBulkRequest() throws IOException {
            bulk.append(emptyObject);
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk2.json");
            0,
        IndexRequest request = (IndexRequest) docWriteRequest;
    public void testBulkAddIterable() {
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            containsString("Malformed action/metadata line [3], expected START_OBJECT or END_OBJECT but found [START_ARRAY]")
                builder.startObject();
        );
            MediaTypeRegistry.JSON
        assertNull(bulkRequest.validate());
        BulkRequest bulkRequest = new BulkRequest();
            data = out.bytes();
    }
                builder.endObject();
        BulkRequest bulkRequest = new BulkRequest();
import org.opensearch.action.update.UpdateRequest;
    public void testBulkActionShouldNotContainArray() throws Exception {
    }
        BulkRequest bulkRequest = new BulkRequest();
        UpdateRequest updateRequest = new UpdateRequest("index", validDocID).doc("reason", "no source");
                values.put("_index", "index");
        String validDocID = String.join("", Collections.nCopies(512, "a"));
    }
 */
import static org.opensearch.test.StreamsUtils.copyToStringFromClasspath;
                "RefreshPolicy is not supported on an item request. Set it on the BulkRequest instead.",
 */
        assertThat(validate, notNullValue());
        IllegalArgumentException exc = expectThrows(
        // We force here a "id is missing" validation error
import static org.hamcrest.Matchers.contains;
        }
import org.opensearch.common.xcontent.XContentType;
        expectThrows(NullPointerException.class, () -> bulkRequest.add((UpdateRequest) null));
        bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON);
            int emptyAction = randomIntBetween(1, actions);
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk.json");
                builder.field("_id", "id");
        );
    public void testSimpleBulk7() throws Exception {
        assertEquals(3, bulkRequestWithNewLine.numberOfActions());
                .stream()
        assertThat(bulkRequest.requests().get(1).index(), equalTo("index1"));
        String validDocID = String.join("", Collections.nCopies(512, "a"));
            data = out.bytes();
            containsString("Malformed action/metadata line [5], expected a simple value for field [_unknown] but found [START_ARRAY]")
            1,
    public void testSimpleBulk3() throws Exception {
        BulkRequest bulkRequest = new BulkRequest();
import static org.hamcrest.Matchers.not;
        BulkRequest bulkRequest = new BulkRequest();
        );
        bulkRequest.add(new UpdateRequest("index", "id").doc("{}", MediaTypeRegistry.JSON).setRefreshPolicy(RefreshPolicy.IMMEDIATE));
        assertThat(validate, notNullValue());
import org.opensearch.core.common.bytes.BytesArray;
        assertThat(validate.validationErrors(), not(empty()));
                builder.field("if_seq_no", 1L);
    }
        BulkRequest bulkRequest = new BulkRequest();
                builder.startObject("doc").endObject();
            MediaTypeRegistry.JSON
import org.opensearch.core.xcontent.XContentBuilder;
import java.util.Map;
        assertThat(((IndexRequest) bulkRequest.requests().get(0)).source(), equalTo(new BytesArray("{ \"field1\" : \"value1\" }")));
        // doc id length under limit
        assertThat(bulkRequest.numberOfActions(), equalTo(3));
    // issue 7361
            try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(xContentType, out)) {
        String bulkAction = "{ \"index\":{\"_index\":[\"index1\", \"index2\"],\"_id\":\"1\"} }\r\n" + "{ \"field1\" : \"value1\" }\r\n";
        assertThat(validate, notNullValue());
 * license agreements. See the NOTICE file distributed with
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        IllegalArgumentException exc = expectThrows(
        String bulkIndexSource = "{ \"field1\" : \"value1\" }\r\n";
    }
            IllegalArgumentException.class,
        assertThat(scriptParams.size(), equalTo(1));
    }
import java.util.ArrayList;
import java.util.Collections;
                builder.endObject();
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
        expectThrows(NullPointerException.class, () -> bulkRequest.add((DeleteRequest) null));
 * specific language governing permissions and limitations
            bulkActionWithNewLine.length(),
        assertThat(bulkRequest.numberOfActions(), equalTo(4));
import static org.hamcrest.Matchers.instanceOf;
            null,
    public void testSmileIsSupported() throws IOException {
        Map<String, Object> sourceMap = XContentHelper.convertToMap(
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk5.json");
        assertEquals("value", request.sourceAsMap().get("field"));
        BulkRequest bulkRequest = new BulkRequest();
            ParsingException.class,
        assertEquals(1, bulkRequest.requests().size());
        int emptyLine;
        assertEquals("index", docWriteRequest.index());
    }
        assertThat(((UpdateRequest) bulkRequest.requests().get(1)).upsertRequest().source().utf8ToString(), equalTo("{\"counter\":1}"));
                bulk.append(i == emptyAction ? emptyObject : bulkIndexAction);
            IllegalArgumentException.class,
            out.write(xContentType.xContent().streamSeparator());
    public void testBulkEmptyObject() throws Exception {
        assertThat(scriptParams.get("param1"), equalTo(1));
        );
        BulkRequest bulkRequest = new BulkRequest();
 * software distributed under the License is distributed on an
        assertNull(bulkRequest.validate());
        assertThat(((IndexRequest) bulkRequest.requests().get(0)).source(), equalTo(new BytesArray("{ \"field1\" : \"value1\" }")));
            try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(xContentType, out)) {
                "id is missing",
                builder.field("upsert", values);
    }
        bulkRequest.add(new DeleteRequest("index", "id"));
    public void testBulkRequestInvalidDocIDDuringUpdate() {
                .stream()
    }
 * not use this file except in compliance with the License.
        String invalidDocID = String.join("", Collections.nCopies(513, "a"));
        bulkRequest.add(new UpdateRequest("index", "id"));
import org.opensearch.action.DocWriteRequest;
import org.opensearch.test.OpenSearchTestCase;
        assertThat(bulkRequest.numberOfActions(), equalTo(9));
        ActionRequestValidationException validate = bulkRequest.validate();
        assertThat(((UpdateRequest) bulkRequest.requests().get(0)).retryOnConflict(), equalTo(2));
                builder.endObject();
            exc.getMessage(),
            for (int i = 1; i <= actions; i++) {
            containsString("Malformed action/metadata line [" + emptyLine + "], expected FIELD_NAME but found [END_OBJECT]")
        assertEquals(
        IndexRequest indexRequest = new IndexRequest("index").id(validDocID).source(Requests.INDEX_CONTENT_TYPE, "field", "value");
            validate.validationErrors(),
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk4.json");
        assertThat(validate.validationErrors(), contains("script or doc is missing", "source is missing", "content type is missing"));
        assertThat(docWriteRequest, instanceOf(IndexRequest.class));
                builder.startObject("index");
        if (randomBoolean()) {
        bulkRequest.add(updateRequest);
            emptyLine = 1;
    public void testCannotAddNullRequests() throws Exception {
        new BulkRequest().add(new BytesArray(bulkAction.getBytes(StandardCharsets.UTF_8)), "test", false, MediaTypeRegistry.JSON);
import org.opensearch.action.index.IndexRequest;
        );
        bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON);
        BulkRequest bulkRequest = new BulkRequest();
        assertThat(exc.getMessage(), containsString("Action/metadata line [3] contains an unknown parameter [_foo]"));
import static org.hamcrest.Matchers.empty;
        assertThat(((UpdateRequest) bulkRequest.requests().get(0)).doc().source().utf8ToString(), equalTo("{\"field\":\"value\"}"));
    }
        assertThat(bulkRequest.requests().get(0), instanceOf(IndexRequest.class));
        Script script = ((UpdateRequest) bulkRequest.requests().get(1)).script();
        DocWriteRequest<?> docWriteRequest = bulkRequest.requests().get(0);
    }
    public void testBulkNoSource() throws Exception {
    public void testSimpleBulk10() throws Exception {
    public void testBulkRequestInvalidDocIDDuringCreate() {
 *
 * Modifications Copyright OpenSearch Contributors. See
        // We force here a "type is missing" validation error
        requests.add(new DeleteRequest("test", "id"));
        bulkRequest.add(new DeleteRequest("index", "id").setRefreshPolicy(RefreshPolicy.IMMEDIATE));
 * The OpenSearch Contributors require contributions made to
        XContentType xContentType = XContentType.SMILE;
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk3.json");
 */
            emptyLine = emptyAction * 2 - 1;
        bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON);
                bulk.append(randomBoolean() ? emptyObject : bulkIndexSource);
            int actions = randomIntBetween(1, 10);
    }
import org.opensearch.transport.client.Requests;
            try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(xContentType, out)) {
        );
        assertThat(
    }
 * Unless required by applicable law or agreed to in writing,
        assertThat(scriptParams, notNullValue());
        assertEquals(
    }
import org.opensearch.core.common.bytes.BytesReference;
        bulkRequest.add(data, null, xContentType);
                .filter(msg -> msg.contains("is too long, must be no longer than 512 bytes but was: "))
        Exception ex = expectThrows(
            IllegalArgumentException.class,
        assertThat(bulkRequest.numberOfActions(), equalTo(1));
        BulkRequest bulkRequestWithNewLine = new BulkRequest();
        assertThat(validate.validationErrors(), not(empty()));
import static org.hamcrest.Matchers.containsString;
                builder.field("_index", "index");
        String bulkAction1 = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk.json");
                builder.field("_index", "index");
        assertThat(
        ).v2();
        IllegalArgumentException exc = expectThrows(
        assertThat(bulkRequest.requests().get(1), instanceOf(UpdateRequest.class));
                builder.endObject();
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.action.ActionRequestValidationException;
            }
        assertThat(
import java.util.List;
                values.put("if_primary_term", 100L);
        XContentType xContentType = XContentType.SMILE;
            )
            IllegalArgumentException.class,
        );
        assertThat(bulkRequest.requests().get(1), instanceOf(DeleteRequest.class));
 *    http://www.apache.org/licenses/LICENSE-2.0
        BulkRequest bulkRequest = new BulkRequest();
 * compatible open source license.
    // issue 15120
        );
            () -> bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON)
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk8.json");
        IllegalArgumentException exc = expectThrows(
        IllegalArgumentException exc = expectThrows(
        ActionRequestValidationException validate = bulkRequest.validate();
            }
    public void testBulkRequestWithRefresh() throws Exception {
        String bulkActionWithNewLine = bulkAction + "\n";
                builder.field("_id", "test");
        }
                .count()
        assertThat(((IndexRequest) bulkRequest.requests().get(2)).source(), equalTo(new BytesArray("{ \"field1\" : \"value3\" }")));
                builder.startObject();
 * the Apache License, Version 2.0 (the "License"); you may
            contains(
        bulkRequest.add(new DeleteRequest("index", null).setRefreshPolicy(RefreshPolicy.IMMEDIATE));
    public void testSimpleBulk2() throws Exception {
import java.nio.charset.StandardCharsets;
    }
import org.opensearch.common.io.stream.BytesStreamOutput;
        bulkRequest.add(new IndexRequest("index").id("id").source("{}", MediaTypeRegistry.JSON).setRefreshPolicy(RefreshPolicy.IMMEDIATE));
        assertThat(script.getIdOrCode(), equalTo("counter += param1"));
        requests.add(new UpdateRequest("test", "id").doc(Requests.INDEX_CONTENT_TYPE, "field", "value"));
 * KIND, either express or implied.  See the License for the
            IllegalArgumentException.class,
                "RefreshPolicy is not supported on an item request. Set it on the BulkRequest instead."
                Map<String, Object> values = new HashMap<>();
        assertEquals("test", docWriteRequest.id());
        bulkRequest.add(new IndexRequest("index").id("id"));
            out.write(xContentType.xContent().streamSeparator());
        BulkRequest bulkRequest = new BulkRequest();
/*
    public void testSimpleBulkWithCarriageReturn() throws Exception {
public class BulkRequestTests extends OpenSearchTestCase {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        assertThat(bulkRequest.requests().size(), equalTo(3));
        assertThat(bulkRequest.validate().validationErrors(), contains("upsert requests don't support `if_seq_no` and `if_primary_term`"));
            () -> new BulkRequest().add(new BytesArray(bulkAction1.getBytes(StandardCharsets.UTF_8)), null, false, MediaTypeRegistry.JSON)
        bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON);
        assertThat(
        assertThat(bulkRequest.requests().get(0).id(), equalTo("1"));
        List<DocWriteRequest<?>> requests = new ArrayList<>();
        );
 * GitHub history for details.
        assertThat(validate, notNullValue());
import org.opensearch.action.delete.DeleteRequest;
import org.opensearch.common.xcontent.XContentHelper;
        assertEquals("value1", sourceMap.get("field1"));
        ActionRequestValidationException validate = bulkRequest.validate();
        BulkRequest bulkRequest = new BulkRequest();
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk11.json");
        ParsingException exc = expectThrows(
                builder.startObject();
import static org.hamcrest.Matchers.notNullValue;
import java.util.HashMap;
        );
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk6.json");
        bulkRequest.add(indexRequest);
            try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(xContentType, out)) {
        }
            }
        bulkRequestWithNewLine.add(
        bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON);
            bulkActionWithNewLine.getBytes(StandardCharsets.UTF_8),
    }
 *
        String bulkIndexAction = "{ \"index\":{\"_index\":\"test\",\"_id\":\"1\"} }\r\n";
        assertEquals(1, request.sourceAsMap().size());
            () -> bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON)
