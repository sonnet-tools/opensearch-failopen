import static org.hamcrest.Matchers.nullValue;
        source.put("foo", "bar");
        assertThat(actualObject, instanceOf(String.class));
        actualObject = ingestDocument.getSourceAndMetadata().get("item");
            assertThat(ingestDocument.getSourceAndMetadata().containsKey("new_field"), equalTo(false));
        try {
        Map<String, Object> document = new HashMap<>();
        @SuppressWarnings("unchecked")
import org.opensearch.test.OpenSearchTestCase;
        assertThat(ingestDocument.getFieldValue("foo.bar", String.class), equalTo("bar"));
        Object actualObject = ingestDocument.getSourceAndMetadata().get("list");
        assertThat(ingestDocument.getFieldValue("foo.bar", Map.class), equalTo(Collections.singletonMap("baz", "bar")));
    public void testRenameNonExistingField() throws Exception {
            processor.execute(ingestDocument);
                    throw new UnsupportedOperationException();
        // when using template snippet, the resolved field path maybe empty
                }
 * not use this file except in compliance with the License.
        processor1.execute(ingestDocument);
    public void testRenameNewFieldAlreadyExists() throws Exception {
        try {
 * specific language governing permissions and limitations
 *
import java.util.HashMap;
 * under the License.
        Processor processor = createRenameProcessor(fieldName, newFieldName, false, false);
        String newFieldName;
        assertThat(actualList.size(), equalTo(2));
                if (key.equals("list")) {
        assertThat(actualList.get(1), equalTo("item3"));
        assertThat(ingestDocument.hasField(field), equalTo(false));
        assertThat(ingestDocument.hasField(targetField), equalTo(true));
            assertThat(ingestDocument.getSourceAndMetadata().containsKey("new_field"), equalTo(false));
        Exception e = expectThrows(IllegalArgumentException.class, () -> processor3.execute(ingestDocument));
        Processor processor = createRenameProcessor(field, targetField, false, false);
        return new RenameProcessor(
    }
 * You may obtain a copy of the License at
    }
        source.put("list", Collections.singletonList("item"));
        // when using template snippet, the resolved field path maybe empty
    }
        assertThat(actualObject, equalTo("item1"));
import static org.hamcrest.Matchers.equalTo;
            public Object remove(Object key) {
            public Object put(String key, Object value) {
        try {
            assertThat(e.getMessage(), equalTo("[3] is out of bounds for array with length [2] as part of path [list.3]"));
        processor2.execute(ingestDocument);
        processor.execute(ingestDocument);
        document.put("list", list);
            fail("processor execute should have failed");
        }
                }
        assertThat(e.getMessage(), equalTo("field [foo] already exists"));
    }
    }
            }
                return super.remove(key);
import java.util.List;
        list.add("item1");
        );
        do {
    public void testRenameAtomicOperationRemoveFails() throws Exception {
        assertIngestDocument(originalIngestDocument, ingestDocument);
        processor.execute(ingestDocument);
            }
        Map<String, Object> source = new HashMap<>();
            new TestTemplateService.MockTemplateScript.Factory(targetField),
        list.add("item2");
        Processor processor = createRenameProcessor("list.0", "item", false, false);
        assertIngestDocument(originalIngestDocument, ingestDocument);
    public void testRenameNonExistingFieldWithIgnoreMissing() throws Exception {
        one.add(Collections.singletonMap("one", "one"));
        List<String> list = new ArrayList<>();
            assertThat(e.getMessage(), equalTo("field [" + fieldName + "] doesn't exist"));
        processor.execute(ingestDocument);
            processor.execute(ingestDocument);
/*
            newFieldName = RandomDocumentPicks.randomFieldName(random());
            // the set failed, the old field has not been removed
    private RenameProcessor createRenameProcessor(String field, String targetField, boolean ignoreMissing, boolean overrideTarget) {
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
 * ownership. Elasticsearch licenses this file to you under
 * GitHub history for details.
        assertThat(ingestDocument.hasField(newFieldName), equalTo(true));
    public void testRename() throws Exception {
        IngestDocument ingestDocument = new IngestDocument(source, Collections.emptyMap());
    }
        } catch (IllegalArgumentException e) {
            fail("processor execute should have failed");
 * The OpenSearch Contributors require contributions made to
        } catch (UnsupportedOperationException e) {
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        String field = RandomDocumentPicks.randomExistingFieldName(random(), ingestDocument);
        if (newFieldName.startsWith(fieldName + '.')) {
            assertThat(actualList.get(0), equalTo("item2"));
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        }
 * Unless required by applicable law or agreed to in writing,
        try {
import static org.hamcrest.Matchers.instanceOf;
        assertThat(ingestDocument.getFieldValue(newFieldName, Object.class), equalTo(fieldValue));
    public void testRenameAtomicOperationSetFails() throws Exception {
        assertThat(ingestDocument.getFieldValue(targetField, Object.class), equalTo(fieldValue));
import java.util.Collections;
        List<String> actualList = (List<String>) actualObject;
        Processor processor = createRenameProcessor(fieldName, newFieldName, false, false);
        // for fun lets try to restore it (which don't allow today)
        } catch (IllegalArgumentException e) {
        Processor processor3 = createRenameProcessor("foo.bar.baz", "foo", false, false);
        assertThat(ingestDocument.getFieldValue("foo", Map.class), equalTo(Collections.singletonMap("bar", "bar")));
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
            assertThat(actualList.size(), equalTo(2));
        assertThat(
        processorWithOverrideTarget.execute(ingestDocument);
        IngestDocument ingestDocument = new IngestDocument(source, Collections.emptyMap());
 *
            assertThat(ingestDocument.getSourceAndMetadata().containsKey("list"), equalTo(true));
 * license agreements. See the NOTICE file distributed with
        Map<String, Object> source = new HashMap<String, Object>() {
            new TestTemplateService.MockTemplateScript.Factory(field),
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
            processor.execute(ingestDocument);
        try {
            equalTo(Collections.singletonMap("bar", Collections.singletonMap("baz", "bar")))
    }
        }
            assertThat(ingestDocument.getFieldValue(fieldName, Object.class), instanceOf(Map.class));
        assertThat(actualObject, instanceOf(List.class));
            fail("processor execute should have failed");
        } catch (IllegalArgumentException e) {
        try {
    public void testRenameArrayElement() throws Exception {
        String newFieldName = randomValueOtherThanMany(ingestDocument::hasField, () -> RandomDocumentPicks.randomFieldName(random()));
        } while (RandomDocumentPicks.canAddField(newFieldName, ingestDocument) == false || newFieldName.equals(fieldName));
            processor.execute(ingestDocument);
            assertThat(actualList.get(1), equalTo("item3"));
 * this file be licensed under the Apache-2.0 license or a
        processor.execute(ingestDocument);
            fail("processor execute should have failed");
        String fieldName = RandomDocumentPicks.randomFieldName(random());
 * this work for additional information regarding copyright
        };
    public void testRenameExistingFieldNullValue() throws Exception {
            randomAlphaOfLength(10),
        Object fieldValue = ingestDocument.getFieldValue(fieldName, Object.class);
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
            overrideTarget
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
            // the set failed, the old field has not been removed
package org.opensearch.ingest.common;
        Map<String, Object> source = new HashMap<String, Object>() {
import java.util.ArrayList;
        processor.execute(ingestDocument);
            assertThat(e.getMessage(), equalTo("field [" + targetField + "] already exists"));
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
 * SPDX-License-Identifier: Apache-2.0
        assertThat(ingestDocument.getFieldValue("foo.bar.baz", String.class), equalTo("bar"));
import java.util.Map;
            @Override
        assertThat(actualList.get(0), equalTo("item2"));
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.ingest.TestTemplateService;
/*
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(ingestDocument.getSourceAndMetadata().containsKey("list"), equalTo(true));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                return super.put(key, value);
        }
        } catch (IllegalArgumentException e) {
            @Override
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
}
        Processor processorWithOverrideTarget = createRenameProcessor(field, targetField, false, true);
        String targetField = RandomDocumentPicks.addRandomField(random(), ingestDocument, RandomDocumentPicks.randomFieldValue(random()));
        processor = createRenameProcessor("", RandomDocumentPicks.randomFieldName(random()), true, false);
                    throw new UnsupportedOperationException();
    public void testRenameLeafIntoBranch() throws Exception {
    }
        document.put("one", one);
        Object fieldValue = ingestDocument.getFieldValue(field, Object.class);
        source.put("list", Collections.singletonList("item"));
        ingestDocument.setFieldValue(fieldName, null);
            fail("processor execute should have failed");
 *
        Processor processor = createRenameProcessor(fieldName, RandomDocumentPicks.randomFieldName(random()), false, false);
 */
        }
        Processor processor = createRenameProcessor("list", "new_field", false, false);
        IngestDocument ingestDocument = new IngestDocument(source, Collections.emptyMap());
 */
            processor.execute(ingestDocument);
        list.add("item3");
        processor = createRenameProcessor("", RandomDocumentPicks.randomFieldName(random()), false, false);
        } else {
        assertThat(ingestDocument.getFieldValue(newFieldName, Object.class), nullValue());
    }
            ignoreMissing,
        Processor processor = createRenameProcessor("list", "new_field", false, false);
 * Licensed to Elasticsearch under one or more contributor
            processor.execute(ingestDocument);
            assertThat(e.getMessage(), equalTo("field path cannot be null nor empty"));
        String fieldName = RandomDocumentPicks.randomExistingFieldName(random(), ingestDocument);
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.ingest.RandomDocumentPicks;
            fail("processor execute should have failed");
        } catch (UnsupportedOperationException e) {
 * software distributed under the License is distributed on an
        Processor processor = createRenameProcessor(fieldName, RandomDocumentPicks.randomFieldName(random()), true, false);
        );
        }
            ingestDocument.getFieldValue("foo", Map.class),
            null,
 */
        List<Map<String, String>> one = new ArrayList<>();
/*
        Processor processor1 = createRenameProcessor("foo", "foo.bar", false, false);
        };
            assertThat(ingestDocument.hasField(fieldName), equalTo(false));
        processor = createRenameProcessor("list.0", "list.3", false, randomBoolean());
        Processor processor2 = createRenameProcessor("foo.bar", "foo.bar.baz", false, false);
        }
        one.add(Collections.singletonMap("two", "two"));
import org.opensearch.ingest.IngestDocument;
public class RenameProcessorTests extends OpenSearchTestCase {
 * compatible open source license.
import org.opensearch.ingest.Processor;
    }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
                if (key.equals("new_field")) {
 * KIND, either express or implied.  See the License for the
