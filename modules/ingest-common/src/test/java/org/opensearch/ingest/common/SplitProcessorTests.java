    public void testSplit() throws Exception {
            fail("split processor should have failed");
        }
 * Licensed to Elasticsearch under one or more contributor
package org.opensearch.ingest.common;
    public void testSplitNonStringValue() throws Exception {
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
    }
    public void testSplitWithTargetField() throws Exception {
    }
        Processor processor = new SplitProcessor(randomAlphaOfLength(10), null, fieldName, "\\.", false, false, fieldName);
        String fieldName = RandomDocumentPicks.randomFieldName(random());
    }
/*
 * GitHub history for details.
    }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
    }
 *
    public void testSplitWithPreserveTrailing() throws Exception {
 * under the License.
 * ownership. Elasticsearch licenses this file to you under
        processor.execute(ingestDocument);
            fail("split processor should have failed");
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
            assertThat(e.getMessage(), containsString("not present as part of path [" + fieldName + "]"));
            processor.execute(ingestDocument);
        doTestSplitWithPreserveTrailing(false, "foo|bar|baz||", Arrays.asList("foo", "bar", "baz"));
        } catch (IllegalArgumentException e) {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
import org.opensearch.ingest.RandomDocumentPicks;
    }
import java.util.Map;
        Processor splitProcessor = (new SplitProcessor.Factory()).create(null, null, null, splitConfig);
        IngestDocument ingestDocument = new IngestDocument(source, new HashMap<>());
            assertThat(
import java.util.Arrays;
            processor.execute(ingestDocument);
        Processor processor = new SplitProcessor(randomAlphaOfLength(10), null, "field", "\\.", false, false, "field");
/*
        assertThat(
 * this file be licensed under the Apache-2.0 license or a
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, "127.0.0.1");
 */
}
    public void testSplitWithoutPreserveTrailing() throws Exception {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
    private void doTestSplitWithPreserveTrailing(boolean preserveTrailing, String fieldValue, List<String> expected) throws Exception {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", null));
        Map<String, Object> source = new HashMap<>();
    public void testSplitAppendable() throws Exception {
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
                e.getMessage(),
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(
        processor.execute(ingestDocument);
    }
        assertIngestDocument(originalIngestDocument, ingestDocument);
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.emptyMap());
        Processor processor = new SplitProcessor(randomAlphaOfLength(10), null, fieldName, "\\.", false, false, fieldName);
        assertThat(ingestDocument.getFieldValue(fieldName, List.class), equalTo(expected));
import static org.hamcrest.Matchers.equalTo;
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
    public void testSplitNullValue() throws Exception {
        try {
public class SplitProcessorTests extends OpenSearchTestCase {
        } catch (IllegalArgumentException e) {
                equalTo("field [" + fieldName + "] of type [java.lang.Integer] cannot be cast " + "to [java.lang.String]")
        String targetFieldName = fieldName + randomAlphaOfLength(5);
    public void testSplitNullValueWithIgnoreMissing() throws Exception {
        List<String> flags = (List<String>) ingestDocument.getFieldValue("flags", List.class);
        processor.execute(ingestDocument);
        }
            equalTo(Arrays.asList("new", "hot", "super", "fun", "interesting", "additional_flag"))
        Processor processor = new SplitProcessor(randomAlphaOfLength(10), null, fieldName, "\\|", false, preserveTrailing, fieldName);
        splitConfig.put("field", "flags");
import org.opensearch.ingest.Processor;
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
        );
        @SuppressWarnings("unchecked")
        ingestDocument.appendFieldValue("flags", "additional_flag");
            Collections.singletonMap(fieldName, null)
        String fieldName = RandomDocumentPicks.randomFieldName(random());
    }
            );
        String fieldName = RandomDocumentPicks.randomFieldName(random());
    public void testSplitNonExistentWithIgnoreMissing() throws Exception {
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.containsString;
import java.util.HashMap;
 * The OpenSearch Contributors require contributions made to
        assertThat(ingestDocument.getFieldValue(fieldName, List.class), equalTo(Arrays.asList("127", "0", "0", "1")));
        assertThat(ingestDocument.getFieldValue(targetFieldName, List.class), equalTo(Arrays.asList("127", "0", "0", "1")));
        );
        source.put("flags", "new|hot|super|fun|interesting");
import org.opensearch.test.OpenSearchTestCase;
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, "127.0.0.1");
        splitConfig.put("separator", "\\|");
 * Modifications Copyright OpenSearch Contributors. See
        } catch (IllegalArgumentException e) {
 *
        ingestDocument.setFieldValue(fieldName, randomInt());
        try {
import java.util.List;
 * compatible open source license.
        Processor processor = new SplitProcessor(randomAlphaOfLength(10), null, fieldName, "\\.", false, false, fieldName);
            fail("split processor should have failed");
    public void testSplitFieldNotFound() throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
    }
/*
        Processor processor = new SplitProcessor(randomAlphaOfLength(10), null, fieldName, "\\.", false, false, targetFieldName);
            ingestDocument.getFieldValue("flags", List.class),
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
 * specific language governing permissions and limitations
        assertThat(flags, equalTo(Arrays.asList("new", "hot", "super", "fun", "interesting")));
import org.opensearch.ingest.IngestDocument;
        splitProcessor.execute(ingestDocument);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        Processor processor = new SplitProcessor(randomAlphaOfLength(10), null, "field", "\\.", true, false, "field");
        processor.execute(ingestDocument);
 * software distributed under the License is distributed on an
 */
 * this work for additional information regarding copyright
        try {
        processor.execute(ingestDocument);
        doTestSplitWithPreserveTrailing(true, "foo|bar|baz||", Arrays.asList("foo", "bar", "baz", "", ""));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            random(),
        Map<String, Object> splitConfig = new HashMap<>();
    }
            processor.execute(ingestDocument);
        Processor processor = new SplitProcessor(randomAlphaOfLength(10), null, fieldName, "\\.", true, false, fieldName);
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at
    }
import java.util.Collections;
            assertThat(e.getMessage(), equalTo("field [field] is null, cannot split."));
        assertIngestDocument(originalIngestDocument, ingestDocument);
        }
 */
