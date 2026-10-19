        String value = "hello world";
    }
        );  
    }
    }
 * KIND, either express or implied.  See the License for the
 * under the License.  
    }
        document.put("field", "\"" + value + "\"");
    }
import java.util.List;  
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        String randomTargetField = randomAlphaOfLength(2);  
        Map<String, Object> document = new HashMap<>();  
    }
 */  
        JsonProcessor jsonProcessor = new JsonProcessor("tag", null, "field", "target_field", false);
        String randomJson = XContentHelper.convertToJson(BytesReference.bytes(builder), false, MediaTypeRegistry.JSON);  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.ingest.IngestDocument;  
    public void testAddBoolToRoot() {
        Exception exception = expectThrows(IllegalArgumentException.class, () -> jsonProcessor.execute(ingestDocument));
        document.put("field", value);
        String randomTargetField = randomAlphaOfLength(2);
        jsonProcessor.execute(ingestDocument);
        document.put("field", value);
        Map<String, Object> document = new HashMap<>();
 */  
        JsonProcessor jsonProcessor = new JsonProcessor("tag", null, "field", "target_field", false);
        Map<String, Object> randomJsonMap = RandomDocumentPicks.randomSource(random());
    public void testExecute() throws Exception {  
    public void testAddToRoot() throws Exception {  
/*  
        XContentBuilder builder = JsonXContent.contentBuilder().map(randomJsonMap);
        document.put("c", "see");
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        );
 */
                "Unrecognized token 'blah': " + "was expecting (JSON String, Number, Array, Object or token 'null', 'true' or 'false')"
        JsonProcessor jsonProcessor = new JsonProcessor("tag", null, "field", "target_field", false);
    }  
    public void testDouble() throws Exception {  
 * GitHub history for details.
        double value = 3.0;  
import java.util.Map;
        String randomField = randomAlphaOfLength(3);
        JsonProcessor jsonProcessor = new JsonProcessor(processorTag, null, randomField, randomTargetField, false);
    public void testNull() throws Exception {
        JsonProcessor jsonProcessor = new JsonProcessor("tag", null, "field", "target_field", true);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        int value = 3;
            exception.getCause().getMessage(),
        document.put("a", json);
        List<Boolean> value = Arrays.asList(true, true, false);
    public void testByteArray() {  
            exception.getCause().getMessage(),
        JsonProcessor jsonProcessor = new JsonProcessor("tag", null, "field", "target_field", false);
        Map<String, Object> document = new HashMap<>();
        jsonProcessor.execute(ingestDocument);
            containsString("Unrecognized token 'B': was expecting (JSON String, Number, Array, Object or token 'null', 'true' or 'false')")  
        Map<String, Object> document = new HashMap<>();  
        jsonProcessor.execute(ingestDocument);
            )
import org.opensearch.common.xcontent.XContentHelper;
 * You may obtain a copy of the License at  
import static org.hamcrest.Matchers.equalTo;
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);  
    }
 * the Apache License, Version 2.0 (the "License"); you may
        jsonProcessor.execute(ingestDocument);  
        assertThat(ingestDocument.getFieldValue("target_field", Object.class), equalTo(value));
        document.put("field", null);
        Map<String, Object> jsonified = ingestDocument.getFieldValue(randomTargetField, Map.class);
/*
import org.opensearch.core.xcontent.MediaTypeRegistry;
        Map<String, Object> document = new HashMap<>();
        Map<String, Object> document = new HashMap<>();
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        jsonProcessor.execute(ingestDocument);
        assertEquals(1, sourceAndMetadata.get("a"));
        document.put("field", value);  
        String json = "{\"a\": 1, \"b\": 2}";  
        assertThat(
 * compatible open source license.
        assertThat(ingestDocument.getFieldValue("target_field", Object.class), equalTo(value));  
    }
import org.opensearch.ingest.RandomDocumentPicks;
        document.put("field", new byte[] { 0, 1 });  
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        document.put("field", true);
        assertThat(ingestDocument.getFieldValue("target_field", Object.class), equalTo(value));
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);  
        jsonProcessor.execute(ingestDocument);
 *
    public void testInteger() throws Exception {
        String processorTag = randomAlphaOfLength(3);
        String processorTag = randomAlphaOfLength(3);
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
import java.util.Arrays;
import static org.hamcrest.Matchers.containsString;  
}  
    }
    }  
        Exception exception = expectThrows(IllegalArgumentException.class, () -> jsonProcessor.execute(ingestDocument));  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.HashMap;
        Map<String, Object> document = new HashMap<>();
        assertThat(exception.getMessage(), containsString("cannot add non-map fields to root of document"));
        assertEquals("see", sourceAndMetadata.get("c"));
        assertThat(
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
    }
 * ownership. Elasticsearch licenses this file to you under  
        Exception exception = expectThrows(IllegalArgumentException.class, () -> jsonProcessor.execute(ingestDocument));  
        JsonProcessor jsonProcessor = new JsonProcessor("tag", null, "field", "target_field", false);
 * not use this file except in compliance with the License.
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        assertEquals(ingestDocument.getFieldValue(randomTargetField, Object.class), jsonified);  
        Exception exception = expectThrows(IllegalArgumentException.class, () -> jsonProcessor.execute(ingestDocument));  
 * Licensed to Elasticsearch under one or more contributor  
        Map<String, Object> document = new HashMap<>();  
        boolean value = true;
    public void testFieldMissing() {  
        assertThat(ingestDocument.getFieldValue("target_field", Object.class), equalTo(value));  
 *
import org.opensearch.core.xcontent.XContentBuilder;
        Map<String, Object> document = new HashMap<>();
        JsonProcessor jsonProcessor = new JsonProcessor("tag", null, "field", "target_field", false);
    public void testInvalidValue() {  
    public void testBoolean() throws Exception {
        document.put("field", value.toString());  
        assertEquals(2, sourceAndMetadata.get("b"));  
 * license agreements. See the NOTICE file distributed with
        document.put("field", "blah blah");  
        JsonProcessor jsonProcessor = new JsonProcessor("tag", null, "field", "target_field", false);  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
 * this work for additional information regarding copyright
    public void testArray() throws Exception {
import org.opensearch.core.common.bytes.BytesReference;  
 * Modifications Copyright OpenSearch Contributors. See
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);  
 *  
    @SuppressWarnings("unchecked")
        document.put(randomField, randomJson);
        jsonProcessor.execute(ingestDocument);  
        assertThat(ingestDocument.getFieldValue("target_field", Object.class), equalTo(value));
        JsonProcessor jsonProcessor = new JsonProcessor("tag", null, "field", "target_field", false);
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.ingest.common;
        assertThat(exception.getMessage(), equalTo("field [field] not present as part of path [field]"));  
public class JsonProcessorTests extends OpenSearchTestCase {  
        Map<String, Object> sourceAndMetadata = ingestDocument.getSourceAndMetadata();
            containsString(  
        Map<String, Object> document = new HashMap<>();
import org.opensearch.common.xcontent.json.JsonXContent;
        Map<String, Object> document = new HashMap<>();
        Map<String, Object> document = new HashMap<>();  
    public void testString() throws Exception {
        jsonProcessor.execute(ingestDocument);
        assertNull(ingestDocument.getFieldValue("target_field", Object.class));
        JsonProcessor jsonProcessor = new JsonProcessor("tag", null, "field", "target_field", false);  
import org.opensearch.test.OpenSearchTestCase;
        JsonProcessor jsonProcessor = new JsonProcessor(processorTag, null, "a", randomTargetField, true);  
