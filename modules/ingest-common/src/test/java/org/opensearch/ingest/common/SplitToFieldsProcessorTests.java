        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, "a>b>c");
        Map<String, Object> source = new HashMap<>();
 * compatible open source license.
        processor.execute(ingestDocument);
        List<String> targetFields = Arrays.asList("out1", "out2", "out3", "out4", "out5");
    public void testSplitToFieldsWithoutPreserveTrailing() throws Exception {
/*
package org.opensearch.ingest.common;
        assertThat(ingestDocument.getFieldValue("out2", String.class), equalTo("b"));
        processor.execute(ingestDocument);
        List<String> targetFields = Arrays.asList("out1", "out2", "out3");
        assertThat(ingestDocument.getFieldValue("out1", String.class), equalTo("a"));
    }
            fail("split_to_fields processor should have failed");
        assertThat(ingestDocument.getFieldValue("octet4", String.class), equalTo("1"));
import org.opensearch.ingest.RandomDocumentPicks;
        } catch (IllegalArgumentException e) {
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
import static org.hamcrest.Matchers.equalTo;
    public void testSplitToFieldsSinglePart() throws Exception {
    public void testSplitToFieldsWithRegexSeparator() throws Exception {
    }
            fail("split_to_fields processor should have failed");
        Processor processor = new SplitToFieldsProcessor(randomAlphaOfLength(10), null, fieldName, ">", targetFields, false, false);
    public void testSplitToFieldsNullValue() throws Exception {
        source.put("input", "a|b|c||");
    }
import java.util.List;
        Processor processor = new SplitToFieldsProcessor(randomAlphaOfLength(10), null, "input", "\\|", targetFields, false, true);
    public void testSplitToFieldsNonExistentWithIgnoreMissing() throws Exception {
        assertThat(ingestDocument.getFieldValue("octet1", String.class), equalTo("127"));
        assertThat(ingestDocument.getFieldValue("out2", String.class), equalTo("b"));
        assertThat(ingestDocument.getFieldValue("out3", String.class), equalTo("c"));
        processor.execute(ingestDocument);
        List<String> targetFields = Arrays.asList("out1", "out2", "out3");
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        IngestDocument ingestDocument = new IngestDocument(source, new HashMap<>());
            assertThat(
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
    }
    }
        processor.execute(ingestDocument);
    public void testSplitToFieldsMorePartsThanFields() throws Exception {
 */
        Map<String, Object> source = new HashMap<>();
        IngestDocument ingestDocument = new IngestDocument(source, new HashMap<>());
        assertThat(ingestDocument.getFieldValue("out2", String.class), equalTo("b"));
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", null));
        List<String> targetFields = Arrays.asList("out1", "out2");
import static org.hamcrest.Matchers.containsString;
        assertThat(ingestDocument.getFieldValue("out3", String.class), equalTo("c"));
    }
        assertThat(ingestDocument.getFieldValue("out1", String.class), equalTo("only_one"));
            processor.execute(ingestDocument);
        processor.execute(ingestDocument);
        source.put("input", "only_one");
        try {
        List<String> targetFields = Arrays.asList("out1", "out2", "out3");
            );
        Processor processor = new SplitToFieldsProcessor(randomAlphaOfLength(10), null, fieldName, ">", targetFields, true, false);
            Collections.singletonMap(fieldName, null)
        Processor processor = new SplitToFieldsProcessor(randomAlphaOfLength(10), null, fieldName, ">", targetFields, false, false);
import java.util.HashMap;
        assertIngestDocument(originalIngestDocument, ingestDocument);
        processor.execute(ingestDocument);
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, "a>b>c>d>e");
            random(),
    }
        source.put("input", "a|b|c||");
    public void testSplitToFieldsWithPreserveTrailing() throws Exception {
                e.getMessage(),
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        assertThat(ingestDocument.getFieldValue("octet2", String.class), equalTo("0"));
    }
        );
        assertThat(ingestDocument.getFieldValue("out5", String.class), equalTo(""));
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to
        }
import org.opensearch.ingest.Processor;
        processor.execute(ingestDocument);
        assertFalse(ingestDocument.hasField("out5"));
        Processor processor = new SplitToFieldsProcessor(randomAlphaOfLength(10), null, "input", ">", targetFields, false, false);
                equalTo("field [" + fieldName + "] of type [java.lang.Integer] cannot be cast to [java.lang.String]")
        ingestDocument.setFieldValue(fieldName, randomInt());
import org.opensearch.test.OpenSearchTestCase;
        assertThat(ingestDocument.getFieldValue("out1", String.class), equalTo("a"));
        List<String> targetFields = Arrays.asList("out1", "out2", "out3");
import org.opensearch.ingest.IngestDocument;
            processor.execute(ingestDocument);
        List<String> targetFields = Arrays.asList("out1", "out2");
        assertFalse(ingestDocument.hasField("out3"));
        try {
        assertThat(ingestDocument.getFieldValue("out1", String.class), equalTo("a"));
import java.util.Arrays;
public class SplitToFieldsProcessorTests extends OpenSearchTestCase {
        }
    }
        List<String> targetFields = Arrays.asList("out1", "out2");
 * SPDX-License-Identifier: Apache-2.0
        assertThat(ingestDocument.getFieldValue("out3", String.class), equalTo("c"));
        assertThat(ingestDocument.getFieldValue("out1", String.class), equalTo("a"));
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(
            processor.execute(ingestDocument);
        Processor processor = new SplitToFieldsProcessor(randomAlphaOfLength(10), null, "field", ">", targetFields, false, false);
 *
        Processor processor = new SplitToFieldsProcessor(randomAlphaOfLength(10), null, fieldName, ">", targetFields, false, false);
        List<String> targetFields = Arrays.asList("out1", "out2");
        try {
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, "127.0.0.1");
    public void testSplitToFieldsNullValueWithIgnoreMissing() throws Exception {
        assertIngestDocument(originalIngestDocument, ingestDocument);
        List<String> targetFields = Arrays.asList("out1", "out2", "out3", "out4", "out5");
        }
        } catch (IllegalArgumentException e) {
    public void testSplitToFieldsFewerPartsThanFields() throws Exception {
    public void testSplitToFieldsNonStringValue() throws Exception {
        Processor processor = new SplitToFieldsProcessor(randomAlphaOfLength(10), null, fieldName, "\\.", targetFields, false, false);
            assertThat(e.getMessage(), equalTo("field [field] is null, cannot split."));
        assertFalse(ingestDocument.hasField("out4"));
    }
        assertThat(ingestDocument.getFieldValue("out2", String.class), equalTo("b"));
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
        assertFalse(ingestDocument.hasField("out3"));
        assertThat(ingestDocument.getFieldValue("out4", String.class), equalTo(""));
import java.util.Collections;
    }
    }
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.emptyMap());
        assertThat(ingestDocument.getFieldValue("out1", String.class), equalTo("a"));
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        Processor processor = new SplitToFieldsProcessor(randomAlphaOfLength(10), null, "field", ">", targetFields, true, false);
            assertThat(e.getMessage(), containsString("not present as part of path [" + fieldName + "]"));
    public void testSplitToFields() throws Exception {
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
}
    public void testSplitToFieldsFieldNotFound() throws Exception {
            fail("split_to_fields processor should have failed");
import java.util.Map;
        assertFalse(ingestDocument.hasField("out2"));
        Map<String, Object> source = new HashMap<>();
        } catch (IllegalArgumentException e) {
        Map<String, Object> source = new HashMap<>();
        IngestDocument ingestDocument = new IngestDocument(source, new HashMap<>());
        Processor processor = new SplitToFieldsProcessor(randomAlphaOfLength(10), null, fieldName, ">", targetFields, false, false);
        Processor processor = new SplitToFieldsProcessor(randomAlphaOfLength(10), null, "input", "\\|", targetFields, false, false);
        assertThat(ingestDocument.getFieldValue("out3", String.class), equalTo("c"));
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        IngestDocument ingestDocument = new IngestDocument(source, new HashMap<>());
        processor.execute(ingestDocument);
        List<String> targetFields = Arrays.asList("octet1", "octet2", "octet3", "octet4");
        Processor processor = new SplitToFieldsProcessor(randomAlphaOfLength(10), null, "input", ">", targetFields, false, false);
        processor.execute(ingestDocument);
        assertThat(ingestDocument.getFieldValue("octet3", String.class), equalTo("0"));
        List<String> targetFields = Arrays.asList("out1", "out2");
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        source.put("input", "a>b");
        assertThat(ingestDocument.getFieldValue("out2", String.class), equalTo("b"));
