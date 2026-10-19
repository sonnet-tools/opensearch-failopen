    public void testCannotAddNullRequests() throws Exception {
        ParsingException exc = expectThrows(
            () -> bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON)
        assertThat(  
        assertEquals("explicit index in bulk is not allowed", ex.getMessage());  
        IllegalArgumentException exc = expectThrows(  
    // issue 15120
    }  
        );
        BulkRequest bulkRequest = new BulkRequest();
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
    public void testSimpleBulk6() throws Exception {
        BytesReference data;
            ((IndexRequest) bulkRequest.requests().get(0)).source(),  
        bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON);
 * not use this file except in compliance with the License.
                bulk.append(randomBoolean() ? emptyObject : bulkIndexSource);
    }
        );  
    }
        XContentType xContentType = XContentType.SMILE;  
        bulkRequest.add(new DeleteRequest("index", null).setRefreshPolicy(RefreshPolicy.IMMEDIATE));
        BulkRequest bulkRequestWithNewLine = new BulkRequest();
        bulkRequest.add(indexRequest);  
            try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(xContentType, out)) {  
    public void testSimpleBulk9() throws Exception {
                builder.startObject();
    public void testSimpleBulk4() throws Exception {  
        assertThat(
            containsString("Malformed action/metadata line [" + emptyLine + "], expected FIELD_NAME but found [END_OBJECT]")  
        } else {
    }  
            contains(
    }
        bulkRequest.add(new DeleteRequest("index", "id"));
        assertThat(bulkRequest.requests().get(0).id(), equalTo("1"));
public class BulkRequestTests extends OpenSearchTestCase {  
 * compatible open source license.
            int emptyAction = randomIntBetween(1, actions);  
 * The OpenSearch Contributors require contributions made to  
            try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(xContentType, out)) {
        bulkRequest.add(data, null, xContentType);
            null,  
 * the Apache License, Version 2.0 (the "License"); you may
        IllegalArgumentException exc = expectThrows(
        assertThat(scriptParams, notNullValue());  
        assertEquals(
        bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON);  
    }
    }  
import org.opensearch.core.xcontent.XContentBuilder;
 *  
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk9.json");
        bulkRequest.add(new IndexRequest("index").id("id"));  
                builder.endObject();  
            data = out.bytes();  
                builder.endObject();
            exc.getMessage(),  
        String emptyObject = "{}\r\n";
        assertThat(docWriteRequest, instanceOf(IndexRequest.class));
        String bulkIndexAction = "{ \"index\":{\"_index\":\"test\",\"_id\":\"1\"} }\r\n";
            1,  
        assertThat(bulkRequest.numberOfActions(), equalTo(1));  
    }
        );
            }
                .filter(msg -> msg.contains("is too long, must be no longer than 512 bytes but was: "))
            validate.validationErrors()
    public void testSimpleBulk3() throws Exception {
        UpdateRequest updateRequest = new UpdateRequest("index", validDocID).doc("reason", "no source");
}
        StringBuilder bulk = new StringBuilder();
                values.put("if_seq_no", 1L);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk8.json");
        BulkRequest bulkRequest = new BulkRequest();  
package org.opensearch.action.bulk;
                "id is missing",  
        );
    }
 */  
        );
        ActionRequestValidationException validate = bulkRequest.validate();
            IllegalArgumentException.class,
        assertThat(validate, notNullValue());
        bulkRequestWithNewLine.add(
            exc.getMessage(),
        String invalidDocID = String.join("", Collections.nCopies(513, "a"));
 * ownership. Elasticsearch licenses this file to you under  
        );  
        assertThat(((UpdateRequest) bulkRequest.requests().get(0)).retryOnConflict(), equalTo(2));  
        String bulkAction = "{ \"index\":{\"_index\":[\"index1\", \"index2\"],\"_id\":\"1\"} }\r\n" + "{ \"field1\" : \"value1\" }\r\n";
import java.util.Collections;
import org.opensearch.transport.client.Requests;
            () -> bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON)  
            0,
        updateRequest.id(invalidDocID);
        List<DocWriteRequest<?>> requests = new ArrayList<>();
        assertEquals("test", docWriteRequest.id());  
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk3.json");  
                builder.endObject();
        String bulkAction1 = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk.json");
                builder.field("_id", "id");  
        String bulkAction = "{ \"index\":{\"_index\":\"test\",\"_id\":\"1\"} }\r\n{ \"field1\" : \"value1\" }\r\n";  
    public void testSimpleBulk1() throws Exception {
 * this work for additional information regarding copyright
        BulkRequest bulkRequest = new BulkRequest();
        BulkRequest bulkRequest = new BulkRequest();
/*  
import java.util.ArrayList;  
        requests.add(new DeleteRequest("test", "id"));
                builder.field("if_primary_term", 100L);
        BulkRequest bulkRequest = new BulkRequest();
                builder.field("field", "value");
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                builder.startObject("index");
        // We force here a "id is missing" validation error
                Map<String, Object> values = new HashMap<>();
            IllegalArgumentException.class,
                builder.field("upsert", values);
    }  
/*  
            bulk.append(emptyObject);
        IllegalArgumentException expectThrows = expectThrows(  
        Script script = ((UpdateRequest) bulkRequest.requests().get(1)).script();
        assertThat(((IndexRequest) bulkRequest.requests().get(0)).source(), equalTo(new BytesArray("{ \"field1\" : \"value1\" }")));  
            int actions = randomIntBetween(1, 10);
                .filter(msg -> msg.contains("is too long, must be no longer than 512 bytes but was: "))  
        assertThat(validate.validationErrors(), contains("script or doc is missing", "source is missing", "content type is missing"));
import static org.hamcrest.Matchers.notNullValue;
        DocWriteRequest<?> docWriteRequest = bulkRequest.requests().get(0);  
                values.put("_index", "index");
        bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON);
 *    http://www.apache.org/licenses/LICENSE-2.0
        String validDocID = String.join("", Collections.nCopies(512, "a"));  
        }
        BulkRequest bulkRequest = new BulkRequest();  
        // doc id length over limit  
import java.util.List;  
            () -> bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON)  
        assertThat(bulkRequest.requests().get(1), instanceOf(UpdateRequest.class));  
                .count()
    public void testSimpleBulk2() throws Exception {
            () -> bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON)
        );  
            containsString("Malformed action/metadata line [5], expected a simple value for field [_unknown] but found [START_ARRAY]")
        bulkRequest.add(new IndexRequest("index").id("id").source("{}", MediaTypeRegistry.JSON).setRefreshPolicy(RefreshPolicy.IMMEDIATE));
                .stream()
        bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON);
import org.opensearch.script.Script;  
        assertEquals(1, request.sourceAsMap().size());  
import org.opensearch.core.common.bytes.BytesArray;
        assertThat(bulkRequest.requests().get(1).id(), equalTo("0"));
        assertNull(bulkRequest.validate());
    }
        bulkRequest.add(data, null, xContentType);  
        String bulkIndexSource = "{ \"field1\" : \"value1\" }\r\n";  
    }
            IllegalArgumentException.class,  
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk7.json");  
        BulkRequest bulkRequest = Requests.bulkRequest();
    }
        BulkRequest bulkRequest = new BulkRequest();
 *
                .count()  
        assertThat(bulkRequest.numberOfActions(), equalTo(3));
        String bulkAction = bulk.toString();
            }
                values.put("if_primary_term", 100L);  
        assertThat(validate, notNullValue());  
                "RefreshPolicy is not supported on an item request. Set it on the BulkRequest instead.",
        assertThat(validate.validationErrors(), not(empty()));  
        assertThat(validate.validationErrors(), not(empty()));
        assertThat(script, notNullValue());
            1,
            IllegalArgumentException.class,
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.xcontent.XContentType;  
            out.write(xContentType.xContent().streamSeparator());  
        );
        assertThat(((IndexRequest) bulkRequest.requests().get(2)).source(), equalTo(new BytesArray("{ \"field1\" : \"value3\" }")));
    }  
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk.json");
import static org.hamcrest.Matchers.contains;
        BulkRequest bulkRequest = new BulkRequest();  
        String invalidDocID = String.join("", Collections.nCopies(513, "a"));  
 * Unless required by applicable law or agreed to in writing,
                builder.startObject();
            MediaTypeRegistry.JSON
                builder.startObject("update");
            ParsingException.class,
        expectThrows(NullPointerException.class, () -> bulkRequest.add((DeleteRequest) null));
        }
        // doc id length under limit
 *
import static org.hamcrest.Matchers.not;  
        assertThat(scriptParams.size(), equalTo(1));
        BulkRequest bulkRequest = new BulkRequest();
        BulkRequest bulkRequest = new BulkRequest();  
 * KIND, either express or implied.  See the License for the
                builder.endObject();  
import org.opensearch.core.common.bytes.BytesReference;  
        );
    public void testSimpleBulk10() throws Exception {
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(scriptParams.get("param1"), equalTo(1));
        bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON);
    public void testSmileIsSupported() throws IOException {
            () -> new BulkRequest().add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON)
            Exception.class,  
            bulkActionWithNewLine.getBytes(StandardCharsets.UTF_8),  
                builder.field("_index", "index");
        ActionRequestValidationException validate = bulkRequest.validate();  
        assertThat(
 * You may obtain a copy of the License at  
            for (int i = 1; i <= actions; i++) {
        BulkRequest bulkRequest = new BulkRequest();  
        XContentType xContentType = XContentType.SMILE;
        assertThat(((UpdateRequest) bulkRequest.requests().get(1)).upsertRequest().source().utf8ToString(), equalTo("{\"counter\":1}"));  
import java.util.HashMap;
import static org.hamcrest.Matchers.equalTo;
 * under the License.  
        assertThat(script.getLang(), equalTo("javascript"));
                "RefreshPolicy is not supported on an item request. Set it on the BulkRequest instead.",
        assertThat(((IndexRequest) bulkRequest.requests().get(0)).source(), equalTo(new BytesArray("{ \"field1\" : \"value1\" }")));
        indexRequest.id(invalidDocID);
 * software distributed under the License is distributed on an
import java.io.IOException;
        assertThat(bulkRequest.requests().get(1).index(), equalTo("index1"));  
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk2.json");
    public void testBulkActionShouldNotContainArray() throws Exception {  
        BulkRequest bulkRequest = new BulkRequest();
import org.opensearch.action.index.IndexRequest;
        // doc id length under limit  
    }
            emptyLine = 1;  
            data = out.bytes();  
 * specific language governing permissions and limitations
        assertEquals(3, bulkRequestWithNewLine.numberOfActions());  
        );
        Map<String, Object> scriptParams = script.getParams();
            () -> new BulkRequest().add(new BytesArray(bulkAction1.getBytes(StandardCharsets.UTF_8)), null, false, MediaTypeRegistry.JSON)
 */
        assertEquals(DocWriteRequest.OpType.INDEX, docWriteRequest.opType());
        BulkRequest bulkRequest = new BulkRequest();
        IllegalArgumentException exc = expectThrows(
    public void testBulkRequestInvalidDocIDDuringCreate() {
        if (randomBoolean()) {
                builder.field("if_seq_no", 1L);
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public void testBulkRequestInvalidDocIDDuringUpdate() {
        ActionRequestValidationException validate = bulkRequest.validate();
        expectThrows(NullPointerException.class, () -> bulkRequest.add((UpdateRequest) null));
        assertThat(((UpdateRequest) bulkRequest.requests().get(0)).doc().source().utf8ToString(), equalTo("{\"field\":\"value\"}"));
/*
        assertThat(bulkRequest.numberOfActions(), equalTo(4));
        ActionRequestValidationException validate = bulkRequest.validate();
            out.write(xContentType.xContent().streamSeparator());
        expectThrows(NullPointerException.class, () -> bulkRequest.add((IndexRequest) null));  
            IllegalArgumentException.class,
            out.write(xContentType.xContent().streamSeparator());
        bulkRequest.add(requests);  
        int emptyLine;  
        assertThat(validate, notNullValue());
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk11.json");
        BulkRequest bulkRequest = new BulkRequest();  
        String validDocID = String.join("", Collections.nCopies(512, "a"));
            "Malformed action/metadata line [1]" + ", expected a simple value for field [_index] but found [START_ARRAY]"  
        Map<String, Object> sourceMap = XContentHelper.convertToMap(
        BytesReference data;  
        requests.add(new IndexRequest("test").id("id").source(Requests.INDEX_CONTENT_TYPE, "field", "value"));  
        assertEquals(
    }
                "RefreshPolicy is not supported on an item request. Set it on the BulkRequest instead."  
import org.opensearch.common.xcontent.XContentHelper;
    public void testBulkAddIterable() {  
        assertThat(
                builder.field("_index", "index");  
    }  
import org.opensearch.action.ActionRequestValidationException;
    public void testSimpleBulkWithCarriageReturn() throws Exception {
 */  
    }  
        IllegalArgumentException exc = expectThrows(  
import static org.hamcrest.Matchers.containsString;
 * license agreements. See the NOTICE file distributed with
        assertNull(bulkRequest.validate());
            () -> bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON)
        );
        requests.add(new UpdateRequest("test", "id").doc(Requests.INDEX_CONTENT_TYPE, "field", "value"));
    }
        BulkRequest bulkRequest = new BulkRequest();
        );
                builder.field("_id", "test");
import org.opensearch.action.delete.DeleteRequest;  
        assertThat(bulkRequest.numberOfActions(), equalTo(3));
import java.util.Map;
        assertThat(script.getIdOrCode(), equalTo("counter += param1"));  
        assertThat(bulkRequest.requests().get(1), instanceOf(DeleteRequest.class));
    }
    public void testBulkNoSource() throws Exception {  
            }
            containsString("Malformed action/metadata line [3], expected START_OBJECT or END_OBJECT but found [START_ARRAY]")
            emptyLine = emptyAction * 2 - 1;
            false,
import org.opensearch.action.DocWriteRequest;
        assertEquals("The bulk request must be terminated by a newline [\\n]", expectThrows.getMessage());
import org.opensearch.action.update.UpdateRequest;  
        new BulkRequest().add(new BytesArray(bulkAction.getBytes(StandardCharsets.UTF_8)), "test", false, MediaTypeRegistry.JSON);  
    public void testBulkRequestWithRefresh() throws Exception {
        assertThat(bulkRequest.numberOfActions(), equalTo(3));  
    // issue 7361
                .stream()
    }
            out.write(xContentType.xContent().streamSeparator());
import static org.opensearch.test.StreamsUtils.copyToStringFromClasspath;  
            () -> bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON)
import org.opensearch.core.common.ParsingException;
        bulkRequest.add(new DeleteRequest("index", "id").setRefreshPolicy(RefreshPolicy.IMMEDIATE));
    public void testBulkAllowExplicitIndex() throws Exception {  
        assertThat(validate, notNullValue());  
        }  
import org.opensearch.common.io.stream.BytesStreamOutput;
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk5.json");
            try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(xContentType, out)) {  
            validate.validationErrors()  
                bulk.append(i == emptyAction ? emptyObject : bulkIndexAction);  
                builder.startObject();  
        );
        IndexRequest request = (IndexRequest) docWriteRequest;
        assertThat(bulkRequest.requests().size(), equalTo(3));
        ).v2();  
import static org.hamcrest.Matchers.instanceOf;
        assertThat(bulkRequest.requests().get(0), instanceOf(IndexRequest.class));
        bulkRequest.add(updateRequest);
        assertEquals("value1", sourceMap.get("field1"));
                builder.endObject();  
        BulkRequest bulkRequest = new BulkRequest();
        assertEquals(
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk6.json");
        assertThat(bulkRequest.requests().get(2), instanceOf(DeleteRequest.class));
        assertEquals(1, bulkRequest.requests().size());
                builder.endObject();  
        bulkRequest.add(new UpdateRequest("index", "id").doc("{}", MediaTypeRegistry.JSON).setRefreshPolicy(RefreshPolicy.IMMEDIATE));  
        BulkRequest bulkRequest = new BulkRequest();
        IndexRequest indexRequest = new IndexRequest("index").id(validDocID).source(Requests.INDEX_CONTENT_TYPE, "field", "value");
    public void testBulkTerminatedByNewline() throws Exception {
            try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(xContentType, out)) {
        // doc id length over limit
        // We force here a "type is missing" validation error  
import static org.hamcrest.Matchers.empty;  
            )
        assertThat(bulkRequest.validate().validationErrors(), contains("upsert requests don't support `if_seq_no` and `if_primary_term`"));
    }
        );  
import java.nio.charset.StandardCharsets;
        BulkRequest bulkRequest = new BulkRequest();
        assertThat(exc.getMessage(), containsString("Unknown key for a VALUE_STRING in [hello]"));
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
        Exception ex = expectThrows(
        bulkRequest.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON);
            MediaTypeRegistry.JSON
        );
 * GitHub history for details.
    public void testSimpleBulk7() throws Exception {
        );  
            exc.getMessage(),
            }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    public void testBulkEmptyObject() throws Exception {
        BulkRequest bulkRequest = new BulkRequest();  
            exc.getMessage(),
        assertEquals("index", docWriteRequest.index());
                builder.startObject();
        IllegalArgumentException exc = expectThrows(  
            }
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk4.json");
            bulkActionWithNewLine.length(),
                "RefreshPolicy is not supported on an item request. Set it on the BulkRequest instead.",
import org.opensearch.test.OpenSearchTestCase;
    public void testSimpleBulk8() throws Exception {  
    public void testToValidateUpsertRequestAndCASInBulkRequest() throws IOException {
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk10.json");  
            IllegalArgumentException.class,
                builder.startObject("doc").endObject();  
        assertThat(exc.getMessage(), containsString("Action/metadata line [3] contains an unknown parameter [_foo]"));
        bulkRequest.add(new UpdateRequest("index", "id"));
        assertThat(bulkRequest.numberOfActions(), equalTo(9));  
        String bulkActionWithNewLine = bulkAction + "\n";  
        assertEquals("value", request.sourceAsMap().get("field"));
            validate.validationErrors(),  
