        List<String> targetFields = Arrays.asList("out1", "out2", "out3", "out4", "out5");
package org.opensearch.ingest.common;
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(
        assertFalse(ingestDocument.hasField("out3"));
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;  
        );
        String fieldName = RandomDocumentPicks.randomFieldName(random());  
public class SplitToFieldsProcessorTests extends OpenSearchTestCase {
    }
        List<String> targetFields = Arrays.asList("octet1", "octet2", "octet3", "octet4");
        assertThat(ingestDocument.getFieldValue("octet2", String.class), equalTo("0"));  
        processor.execute(ingestDocument);
        assertFalse(ingestDocument.hasField("out5"));  
    }  
        List<String> targetFields = Arrays.asList("out1", "out2", "out3");  
        String fieldName = RandomDocumentPicks.randomFieldName(random());  
import static org.hamcrest.Matchers.containsString;
 * The OpenSearch Contributors require contributions made to  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
        assertThat(ingestDocument.getFieldValue("out4", String.class), equalTo(""));  
        assertThat(ingestDocument.getFieldValue("out1", String.class), equalTo("a"));
        Processor processor = new SplitToFieldsProcessor(randomAlphaOfLength(10), null, "field", ">", targetFields, true, false);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
    public void testSplitToFieldsFieldNotFound() throws Exception {
            assertThat(
        }
 *
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, "127.0.0.1");
        Map<String, Object> source = new HashMap<>();  
    public void testSplitToFieldsMorePartsThanFields() throws Exception {
            fail("split_to_fields processor should have failed");
        source.put("input", "only_one");
        assertThat(ingestDocument.getFieldValue("out1", String.class), equalTo("a"));  
        IngestDocument ingestDocument = new IngestDocument(source, new HashMap<>());
        Map<String, Object> source = new HashMap<>();
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
                equalTo("field [" + fieldName + "] of type [java.lang.Integer] cannot be cast to [java.lang.String]")  
    public void testSplitToFieldsFewerPartsThanFields() throws Exception {
        assertFalse(ingestDocument.hasField("out4"));
    }
        Processor processor = new SplitToFieldsProcessor(randomAlphaOfLength(10), null, "input", ">", targetFields, false, false);
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.emptyMap());
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        Processor processor = new SplitToFieldsProcessor(randomAlphaOfLength(10), null, fieldName, ">", targetFields, false, false);
}
    public void testSplitToFieldsWithRegexSeparator() throws Exception {
import java.util.Map;
    public void testSplitToFieldsNullValue() throws Exception {
import java.util.Arrays;  
    public void testSplitToFieldsNonExistentWithIgnoreMissing() throws Exception {  
import org.opensearch.ingest.RandomDocumentPicks;  
        assertThat(ingestDocument.getFieldValue("out2", String.class), equalTo("b"));  
        processor.execute(ingestDocument);
        Processor processor = new SplitToFieldsProcessor(randomAlphaOfLength(10), null, fieldName, ">", targetFields, false, false);
        assertThat(ingestDocument.getFieldValue("octet4", String.class), equalTo("1"));
        source.put("input", "a|b|c||");
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        try {  
    }  
        processor.execute(ingestDocument);
        assertThat(ingestDocument.getFieldValue("octet1", String.class), equalTo("127"));
        List<String> targetFields = Arrays.asList("out1", "out2", "out3");
        Processor processor = new SplitToFieldsProcessor(randomAlphaOfLength(10), null, fieldName, ">", targetFields, true, false);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
        Processor processor = new SplitToFieldsProcessor(randomAlphaOfLength(10), null, fieldName, ">", targetFields, false, false);
        assertThat(ingestDocument.getFieldValue("out3", String.class), equalTo("c"));
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", null));  
            random(),
        processor.execute(ingestDocument);
        processor.execute(ingestDocument);
            fail("split_to_fields processor should have failed");
        Processor processor = new SplitToFieldsProcessor(randomAlphaOfLength(10), null, "field", ">", targetFields, false, false);
        assertThat(ingestDocument.getFieldValue("out1", String.class), equalTo("a"));
        List<String> targetFields = Arrays.asList("out1", "out2");
        assertThat(ingestDocument.getFieldValue("out3", String.class), equalTo("c"));
        assertThat(ingestDocument.getFieldValue("out2", String.class), equalTo("b"));  
        processor.execute(ingestDocument);
    }
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, "a>b>c");
        processor.execute(ingestDocument);
    }
import static org.hamcrest.Matchers.equalTo;
        Map<String, Object> source = new HashMap<>();
        }
        IngestDocument ingestDocument = new IngestDocument(source, new HashMap<>());
        List<String> targetFields = Arrays.asList("out1", "out2", "out3");
                e.getMessage(),
        Processor processor = new SplitToFieldsProcessor(randomAlphaOfLength(10), null, "input", ">", targetFields, false, false);  
        assertThat(ingestDocument.getFieldValue("out3", String.class), equalTo("c"));
        } catch (IllegalArgumentException e) {  
    }  
import org.opensearch.ingest.IngestDocument;
/*  
import java.util.Collections;
        source.put("input", "a|b|c||");  
    public void testSplitToFieldsNonStringValue() throws Exception {  
        } catch (IllegalArgumentException e) {  
import org.opensearch.test.OpenSearchTestCase;
        Processor processor = new SplitToFieldsProcessor(randomAlphaOfLength(10), null, "input", "\\|", targetFields, false, true);
        Processor processor = new SplitToFieldsProcessor(randomAlphaOfLength(10), null, fieldName, "\\.", targetFields, false, false);  
        }
        ingestDocument.setFieldValue(fieldName, randomInt());  
        List<String> targetFields = Arrays.asList("out1", "out2");
        assertFalse(ingestDocument.hasField("out3"));
    public void testSplitToFieldsSinglePart() throws Exception {
    public void testSplitToFieldsWithPreserveTrailing() throws Exception {
import java.util.HashMap;
        assertThat(ingestDocument.getFieldValue("out2", String.class), equalTo("b"));
        assertThat(ingestDocument.getFieldValue("octet3", String.class), equalTo("0"));
        assertIngestDocument(originalIngestDocument, ingestDocument);  
            assertThat(e.getMessage(), equalTo("field [field] is null, cannot split."));
        IngestDocument ingestDocument = new IngestDocument(source, new HashMap<>());
            assertThat(e.getMessage(), containsString("not present as part of path [" + fieldName + "]"));
        assertIngestDocument(originalIngestDocument, ingestDocument);  
        Processor processor = new SplitToFieldsProcessor(randomAlphaOfLength(10), null, "input", "\\|", targetFields, false, false);  
        assertThat(ingestDocument.getFieldValue("out1", String.class), equalTo("a"));
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, "a>b>c>d>e");
        Processor processor = new SplitToFieldsProcessor(randomAlphaOfLength(10), null, fieldName, ">", targetFields, false, false);  
        } catch (IllegalArgumentException e) {  
        assertThat(ingestDocument.getFieldValue("out1", String.class), equalTo("a"));  
    }  
        List<String> targetFields = Arrays.asList("out1", "out2");
import java.util.List;  
        assertThat(ingestDocument.getFieldValue("out2", String.class), equalTo("b"));  
        processor.execute(ingestDocument);
 */  
            );
    public void testSplitToFieldsWithoutPreserveTrailing() throws Exception {
    }
        try {  
        List<String> targetFields = Arrays.asList("out1", "out2");  
        processor.execute(ingestDocument);
 * SPDX-License-Identifier: Apache-2.0
        assertThat(ingestDocument.getFieldValue("out3", String.class), equalTo("c"));
        assertFalse(ingestDocument.hasField("out2"));
            processor.execute(ingestDocument);
 * this file be licensed under the Apache-2.0 license or a
        assertThat(ingestDocument.getFieldValue("out1", String.class), equalTo("only_one"));  
            processor.execute(ingestDocument);
        List<String> targetFields = Arrays.asList("out1", "out2");  
            processor.execute(ingestDocument);
        IngestDocument ingestDocument = new IngestDocument(source, new HashMap<>());
        source.put("input", "a>b");  
        try {  
            fail("split_to_fields processor should have failed");
            Collections.singletonMap(fieldName, null)  
    public void testSplitToFieldsNullValueWithIgnoreMissing() throws Exception {
    public void testSplitToFields() throws Exception {  
    }  
import org.opensearch.ingest.Processor;
        assertThat(ingestDocument.getFieldValue("out2", String.class), equalTo("b"));
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        Map<String, Object> source = new HashMap<>();  
    }  
        assertThat(ingestDocument.getFieldValue("out5", String.class), equalTo(""));
        List<String> targetFields = Arrays.asList("out1", "out2", "out3");  
 * compatible open source license.
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
    }
        List<String> targetFields = Arrays.asList("out1", "out2", "out3", "out4", "out5");  
