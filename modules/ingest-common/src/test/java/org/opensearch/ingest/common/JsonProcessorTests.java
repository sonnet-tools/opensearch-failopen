    public void testString() throws Exception {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
    }
        document.put("a", json);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
    public void testFieldMissing() {
        document.put("field", value.toString());
        Map<String, Object> document = new HashMap<>();
        Map<String, Object> document = new HashMap<>();
 * Unless required by applicable law or agreed to in writing,
 */
        assertThat(ingestDocument.getFieldValue("target_field", Object.class), equalTo(value));
        Exception exception = expectThrows(IllegalArgumentException.class, () -> jsonProcessor.execute(ingestDocument));
        jsonProcessor.execute(ingestDocument);
/*
        String randomTargetField = randomAlphaOfLength(2);
    @SuppressWarnings("unchecked")
 * this file be licensed under the Apache-2.0 license or a
            )
        Map<String, Object> document = new HashMap<>();
        assertThat(ingestDocument.getFieldValue("target_field", Object.class), equalTo(value));
import static org.hamcrest.Matchers.containsString;
    }
        boolean value = true;
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
            containsString(
        document.put("c", "see");
        Map<String, Object> document = new HashMap<>();
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        document.put("field", value);
    }
import static org.hamcrest.Matchers.equalTo;
    }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        JsonProcessor jsonProcessor = new JsonProcessor("tag", null, "field", "target_field", false);
 * GitHub history for details.
        jsonProcessor.execute(ingestDocument);
 */
 *
import java.util.HashMap;
    public void testNull() throws Exception {
 *
        assertThat(
        jsonProcessor.execute(ingestDocument);
 * compatible open source license.
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        JsonProcessor jsonProcessor = new JsonProcessor("tag", null, "field", "target_field", false);
import org.opensearch.common.xcontent.json.JsonXContent;
        assertEquals(1, sourceAndMetadata.get("a"));
    }
        Map<String, Object> document = new HashMap<>();
import org.opensearch.core.common.bytes.BytesReference;
    }
    }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        Map<String, Object> document = new HashMap<>();
        String processorTag = randomAlphaOfLength(3);
        JsonProcessor jsonProcessor = new JsonProcessor(processorTag, null, randomField, randomTargetField, false);
        String randomJson = XContentHelper.convertToJson(BytesReference.bytes(builder), false, MediaTypeRegistry.JSON);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        JsonProcessor jsonProcessor = new JsonProcessor("tag", null, "field", "target_field", false);
/*
 */
        int value = 3;
        assertThat(exception.getMessage(), equalTo("field [field] not present as part of path [field]"));
        jsonProcessor.execute(ingestDocument);
}
        String json = "{\"a\": 1, \"b\": 2}";
 *
                "Unrecognized token 'blah': " + "was expecting (JSON String, Number, Array, Object or token 'null', 'true' or 'false')"
    }
        Exception exception = expectThrows(IllegalArgumentException.class, () -> jsonProcessor.execute(ingestDocument));
        jsonProcessor.execute(ingestDocument);
 * license agreements. See the NOTICE file distributed with
        JsonProcessor jsonProcessor = new JsonProcessor(processorTag, null, "a", randomTargetField, true);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.List;
        assertThat(
        jsonProcessor.execute(ingestDocument);
    }
        XContentBuilder builder = JsonXContent.contentBuilder().map(randomJsonMap);
        JsonProcessor jsonProcessor = new JsonProcessor("tag", null, "field", "target_field", false);
public class JsonProcessorTests extends OpenSearchTestCase {
import org.opensearch.core.xcontent.MediaTypeRegistry;
        JsonProcessor jsonProcessor = new JsonProcessor("tag", null, "field", "target_field", true);
import org.opensearch.ingest.IngestDocument;
        Map<String, Object> document = new HashMap<>();
        document.put("field", value);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        );
import java.util.Arrays;
    }
        jsonProcessor.execute(ingestDocument);
        List<Boolean> value = Arrays.asList(true, true, false);
 * not use this file except in compliance with the License.
        assertEquals("see", sourceAndMetadata.get("c"));
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        Exception exception = expectThrows(IllegalArgumentException.class, () -> jsonProcessor.execute(ingestDocument));
 * SPDX-License-Identifier: Apache-2.0
        JsonProcessor jsonProcessor = new JsonProcessor("tag", null, "field", "target_field", false);
 * the Apache License, Version 2.0 (the "License"); you may
        String processorTag = randomAlphaOfLength(3);
 * this work for additional information regarding copyright
        JsonProcessor jsonProcessor = new JsonProcessor("tag", null, "field", "target_field", false);
/*
        Map<String, Object> document = new HashMap<>();
package org.opensearch.ingest.common;
        Map<String, Object> document = new HashMap<>();
        String randomTargetField = randomAlphaOfLength(2);
import org.opensearch.ingest.RandomDocumentPicks;
        );
    public void testExecute() throws Exception {
    public void testByteArray() {
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        assertNull(ingestDocument.getFieldValue("target_field", Object.class));
    public void testArray() throws Exception {
    }
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor
    public void testDouble() throws Exception {
        Map<String, Object> document = new HashMap<>();
        assertThat(exception.getMessage(), containsString("cannot add non-map fields to root of document"));
    public void testAddToRoot() throws Exception {
 * under the License.
    public void testAddBoolToRoot() {
        document.put("field", value);
    public void testBoolean() throws Exception {
        double value = 3.0;
        document.put("field", true);
    public void testInteger() throws Exception {
        assertThat(ingestDocument.getFieldValue("target_field", Object.class), equalTo(value));
        assertThat(ingestDocument.getFieldValue("target_field", Object.class), equalTo(value));
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.test.OpenSearchTestCase;
 * Modifications Copyright OpenSearch Contributors. See
        Map<String, Object> randomJsonMap = RandomDocumentPicks.randomSource(random());
            exception.getCause().getMessage(),
        Map<String, Object> jsonified = ingestDocument.getFieldValue(randomTargetField, Map.class);
        assertEquals(ingestDocument.getFieldValue(randomTargetField, Object.class), jsonified);
 * You may obtain a copy of the License at
 * ownership. Elasticsearch licenses this file to you under
        assertThat(ingestDocument.getFieldValue("target_field", Object.class), equalTo(value));
        Map<String, Object> document = new HashMap<>();
        String randomField = randomAlphaOfLength(3);
 * specific language governing permissions and limitations
import java.util.Map;
import org.opensearch.common.xcontent.XContentHelper;
        document.put("field", null);
        JsonProcessor jsonProcessor = new JsonProcessor("tag", null, "field", "target_field", false);
        Map<String, Object> document = new HashMap<>();
        document.put("field", "\"" + value + "\"");
        document.put("field", "blah blah");
        Exception exception = expectThrows(IllegalArgumentException.class, () -> jsonProcessor.execute(ingestDocument));
        document.put("field", new byte[] { 0, 1 });
        JsonProcessor jsonProcessor = new JsonProcessor("tag", null, "field", "target_field", false);
        JsonProcessor jsonProcessor = new JsonProcessor("tag", null, "field", "target_field", false);
        Map<String, Object> sourceAndMetadata = ingestDocument.getSourceAndMetadata();
        assertEquals(2, sourceAndMetadata.get("b"));
    public void testInvalidValue() {
            containsString("Unrecognized token 'B': was expecting (JSON String, Number, Array, Object or token 'null', 'true' or 'false')")
        document.put(randomField, randomJson);
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        jsonProcessor.execute(ingestDocument);
        String value = "hello world";
            exception.getCause().getMessage(),
