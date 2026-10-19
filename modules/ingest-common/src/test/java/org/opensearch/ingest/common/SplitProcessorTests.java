        doTestSplitWithPreserveTrailing(true, "foo|bar|baz||", Arrays.asList("foo", "bar", "baz", "", ""));  
    }
        Processor processor = new SplitProcessor(randomAlphaOfLength(10), null, fieldName, "\\|", false, preserveTrailing, fieldName);
        splitConfig.put("field", "flags");  
        try {  
    }
                e.getMessage(),
            assertThat(  
    }
 *
 */  
        );  
import org.opensearch.test.OpenSearchTestCase;
        @SuppressWarnings("unchecked")
        try {
 * ownership. Elasticsearch licenses this file to you under  
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, "127.0.0.1");
import org.opensearch.ingest.Processor;
        source.put("flags", "new|hot|super|fun|interesting");
            random(),
    private void doTestSplitWithPreserveTrailing(boolean preserveTrailing, String fieldValue, List<String> expected) throws Exception {
    }  
 * compatible open source license.
            processor.execute(ingestDocument);  
 * Licensed to Elasticsearch under one or more contributor  
        processor.execute(ingestDocument);
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testSplitAppendable() throws Exception {
            fail("split processor should have failed");
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", null));  
        List<String> flags = (List<String>) ingestDocument.getFieldValue("flags", List.class);
        assertIngestDocument(originalIngestDocument, ingestDocument);  
            fail("split processor should have failed");
package org.opensearch.ingest.common;
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
import static org.hamcrest.Matchers.equalTo;
        ingestDocument.setFieldValue(fieldName, randomInt());  
 *  
/*
import org.opensearch.ingest.RandomDocumentPicks;  
            ingestDocument.getFieldValue("flags", List.class),  
        Processor processor = new SplitProcessor(randomAlphaOfLength(10), null, fieldName, "\\.", false, false, fieldName);
 * GitHub history for details.
    public void testSplit() throws Exception {  
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(  
        assertThat(ingestDocument.getFieldValue(targetFieldName, List.class), equalTo(Arrays.asList("127", "0", "0", "1")));
        String targetFieldName = fieldName + randomAlphaOfLength(5);
import static org.hamcrest.Matchers.containsString;
    }  
        }
    public void testSplitWithTargetField() throws Exception {
 * specific language governing permissions and limitations
    }  
import java.util.List;  
    }  
    }
        Processor processor = new SplitProcessor(randomAlphaOfLength(10), null, fieldName, "\\.", false, false, fieldName);  
        assertThat(ingestDocument.getFieldValue(fieldName, List.class), equalTo(expected));  
        } catch (IllegalArgumentException e) {
/*  
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;  
import java.util.Arrays;  
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);  
public class SplitProcessorTests extends OpenSearchTestCase {
        splitProcessor.execute(ingestDocument);  
import java.util.Collections;
        Map<String, Object> splitConfig = new HashMap<>();
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);  
import java.util.HashMap;
        ingestDocument.appendFieldValue("flags", "additional_flag");
        Processor processor = new SplitProcessor(randomAlphaOfLength(10), null, fieldName, "\\.", false, false, targetFieldName);  
/*  
        String fieldName = RandomDocumentPicks.randomFieldName(random());
 * this work for additional information regarding copyright
                equalTo("field [" + fieldName + "] of type [java.lang.Integer] cannot be cast " + "to [java.lang.String]")
    public void testSplitFieldNotFound() throws Exception {
 * software distributed under the License is distributed on an
 */  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        assertIngestDocument(originalIngestDocument, ingestDocument);
    public void testSplitNullValue() throws Exception {
    public void testSplitNonStringValue() throws Exception {  
    }
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
        try {
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        } catch (IllegalArgumentException e) {
    }
 */
    public void testSplitNonExistentWithIgnoreMissing() throws Exception {
        doTestSplitWithPreserveTrailing(false, "foo|bar|baz||", Arrays.asList("foo", "bar", "baz"));
        processor.execute(ingestDocument);  
 * this file be licensed under the Apache-2.0 license or a
        splitConfig.put("separator", "\\|");
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.emptyMap());
        String fieldName = RandomDocumentPicks.randomFieldName(random());
            );  
    public void testSplitNullValueWithIgnoreMissing() throws Exception {
        Processor processor = new SplitProcessor(randomAlphaOfLength(10), null, fieldName, "\\.", true, false, fieldName);
            Collections.singletonMap(fieldName, null)
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
            assertThat(e.getMessage(), containsString("not present as part of path [" + fieldName + "]"));
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());  
 * Unless required by applicable law or agreed to in writing,
        } catch (IllegalArgumentException e) {  
    }
        );
 *
 * under the License.  
import java.util.Map;
        processor.execute(ingestDocument);
        Map<String, Object> source = new HashMap<>();  
 * SPDX-License-Identifier: Apache-2.0
            fail("split processor should have failed");
 * license agreements. See the NOTICE file distributed with
        assertThat(
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, "127.0.0.1");
        }
import org.opensearch.ingest.IngestDocument;
}
    public void testSplitWithoutPreserveTrailing() throws Exception {  
        Processor splitProcessor = (new SplitProcessor.Factory()).create(null, null, null, splitConfig);
        }
        Processor processor = new SplitProcessor(randomAlphaOfLength(10), null, fieldName, "\\.", false, false, fieldName);
            equalTo(Arrays.asList("new", "hot", "super", "fun", "interesting", "additional_flag"))
        assertThat(flags, equalTo(Arrays.asList("new", "hot", "super", "fun", "interesting")));  
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
            processor.execute(ingestDocument);
        Processor processor = new SplitProcessor(randomAlphaOfLength(10), null, "field", "\\.", true, false, "field");
        IngestDocument ingestDocument = new IngestDocument(source, new HashMap<>());
    public void testSplitWithPreserveTrailing() throws Exception {
 * The OpenSearch Contributors require contributions made to  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        processor.execute(ingestDocument);
 * KIND, either express or implied.  See the License for the
            assertThat(e.getMessage(), equalTo("field [field] is null, cannot split."));  
        Processor processor = new SplitProcessor(randomAlphaOfLength(10), null, "field", "\\.", false, false, "field");
            processor.execute(ingestDocument);  
 * You may obtain a copy of the License at  
        processor.execute(ingestDocument);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(ingestDocument.getFieldValue(fieldName, List.class), equalTo(Arrays.asList("127", "0", "0", "1")));
