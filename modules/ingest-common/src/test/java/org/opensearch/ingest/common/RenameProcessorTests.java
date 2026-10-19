        assertThat(ingestDocument.getFieldValue("foo", Map.class), equalTo(Collections.singletonMap("bar", "bar")));  
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
            processor.execute(ingestDocument);  
            assertThat(e.getMessage(), equalTo("[3] is out of bounds for array with length [2] as part of path [list.3]"));
import java.util.Collections;
            processor.execute(ingestDocument);
        Processor processor = createRenameProcessor("list", "new_field", false, false);
    }  
        Map<String, Object> document = new HashMap<>();
            processor.execute(ingestDocument);  
    }
        one.add(Collections.singletonMap("two", "two"));  
        Map<String, Object> source = new HashMap<String, Object>() {
        assertThat(actualList.get(0), equalTo("item2"));
        Processor processor1 = createRenameProcessor("foo", "foo.bar", false, false);
            processor.execute(ingestDocument);  
        try {  
            ingestDocument.getFieldValue("foo", Map.class),  
        assertThat(ingestDocument.getFieldValue(newFieldName, Object.class), equalTo(fieldValue));  
        Processor processor = createRenameProcessor(fieldName, newFieldName, false, false);
            processor.execute(ingestDocument);
            public Object remove(Object key) {  
import java.util.Map;
    }
        assertThat(actualList.size(), equalTo(2));
            fail("processor execute should have failed");
        source.put("list", Collections.singletonList("item"));
            assertThat(actualList.get(1), equalTo("item3"));
        );
        assertThat(ingestDocument.getFieldValue(newFieldName, Object.class), nullValue());  
    }  
        IngestDocument ingestDocument = new IngestDocument(source, Collections.emptyMap());  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.HashMap;  
        );
        String newFieldName;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testRenameArrayElement() throws Exception {  
        document.put("list", list);  
        } catch (IllegalArgumentException e) {  
public class RenameProcessorTests extends OpenSearchTestCase {  
        list.add("item2");
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());  
            assertThat(actualList.size(), equalTo(2));
import static org.hamcrest.Matchers.nullValue;
/*  
        String field = RandomDocumentPicks.randomExistingFieldName(random(), ingestDocument);  
                if (key.equals("list")) {
        List<Map<String, String>> one = new ArrayList<>();
        } catch (UnsupportedOperationException e) {
        }
    public void testRenameNewFieldAlreadyExists() throws Exception {
 * specific language governing permissions and limitations
        try {
        assertIngestDocument(originalIngestDocument, ingestDocument);
        String targetField = RandomDocumentPicks.addRandomField(random(), ingestDocument, RandomDocumentPicks.randomFieldValue(random()));
        Object actualObject = ingestDocument.getSourceAndMetadata().get("list");  
            @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                return super.put(key, value);
        source.put("list", Collections.singletonList("item"));
        Processor processor = createRenameProcessor(field, targetField, false, false);
        IngestDocument ingestDocument = new IngestDocument(source, Collections.emptyMap());  
    public void testRenameNonExistingFieldWithIgnoreMissing() throws Exception {
        Object fieldValue = ingestDocument.getFieldValue(field, Object.class);
    public void testRenameLeafIntoBranch() throws Exception {  
    }  
        // when using template snippet, the resolved field path maybe empty
            // the set failed, the old field has not been removed  
 * not use this file except in compliance with the License.
        assertThat(ingestDocument.hasField(field), equalTo(false));  
        processor.execute(ingestDocument);  
            assertThat(e.getMessage(), equalTo("field [" + targetField + "] already exists"));  
        assertThat(ingestDocument.getFieldValue("foo.bar", String.class), equalTo("bar"));
        } catch (IllegalArgumentException e) {  
            randomAlphaOfLength(10),
            }
            assertThat(actualList.get(0), equalTo("item2"));  
            overrideTarget
 * Modifications Copyright OpenSearch Contributors. See
                }  
            assertThat(ingestDocument.getSourceAndMetadata().containsKey("new_field"), equalTo(false));
            fail("processor execute should have failed");
        processor.execute(ingestDocument);
 * compatible open source license.
        processor2.execute(ingestDocument);
    public void testRenameNonExistingField() throws Exception {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
import java.util.ArrayList;
    }  
 */
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        source.put("foo", "bar");
 */  
        processor.execute(ingestDocument);
        Processor processor = createRenameProcessor(fieldName, newFieldName, false, false);
    public void testRenameAtomicOperationSetFails() throws Exception {  
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        assertThat(ingestDocument.hasField(newFieldName), equalTo(true));
        // when using template snippet, the resolved field path maybe empty
                    throw new UnsupportedOperationException();
            new TestTemplateService.MockTemplateScript.Factory(field),
            public Object put(String key, Object value) {  
            null,  
 * ownership. Elasticsearch licenses this file to you under  
import static org.hamcrest.Matchers.instanceOf;  
            fail("processor execute should have failed");
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
        } while (RandomDocumentPicks.canAddField(newFieldName, ingestDocument) == false || newFieldName.equals(fieldName));  
        one.add(Collections.singletonMap("one", "one"));
 */  
        }
            assertThat(ingestDocument.getSourceAndMetadata().containsKey("list"), equalTo(true));
        // for fun lets try to restore it (which don't allow today)  
            assertThat(ingestDocument.getSourceAndMetadata().containsKey("new_field"), equalTo(false));
        if (newFieldName.startsWith(fieldName + '.')) {  
            assertThat(e.getMessage(), equalTo("field [" + fieldName + "] doesn't exist"));
        Processor processor = createRenameProcessor(fieldName, RandomDocumentPicks.randomFieldName(random()), true, false);  
        Object fieldValue = ingestDocument.getFieldValue(fieldName, Object.class);
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
        } else {
            equalTo(Collections.singletonMap("bar", Collections.singletonMap("baz", "bar")))
 * license agreements. See the NOTICE file distributed with
/*  
 *  
            assertThat(ingestDocument.getFieldValue(fieldName, Object.class), instanceOf(Map.class));
 * GitHub history for details.
        Processor processor2 = createRenameProcessor("foo.bar", "foo.bar.baz", false, false);  
            }
            // the set failed, the old field has not been removed  
        } catch (IllegalArgumentException e) {  
package org.opensearch.ingest.common;
                }  
        String newFieldName = randomValueOtherThanMany(ingestDocument::hasField, () -> RandomDocumentPicks.randomFieldName(random()));  
/*
            assertThat(ingestDocument.getSourceAndMetadata().containsKey("list"), equalTo(true));
            newFieldName = RandomDocumentPicks.randomFieldName(random());
            fail("processor execute should have failed");
        assertThat(actualList.get(1), equalTo("item3"));  
        assertThat(actualObject, equalTo("item1"));  
    }
 * this file be licensed under the Apache-2.0 license or a
        assertThat(ingestDocument.getFieldValue("foo.bar", Map.class), equalTo(Collections.singletonMap("baz", "bar")));  
        };  
            processor.execute(ingestDocument);
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.equalTo;
        processorWithOverrideTarget.execute(ingestDocument);
    public void testRenameExistingFieldNullValue() throws Exception {
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
}
        }
        assertThat(ingestDocument.hasField(targetField), equalTo(true));
            assertThat(e.getMessage(), equalTo("field path cannot be null nor empty"));
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
    }
            fail("processor execute should have failed");
        Processor processor3 = createRenameProcessor("foo.bar.baz", "foo", false, false);
import org.opensearch.ingest.TestTemplateService;
    public void testRename() throws Exception {
 * under the License.  
    public void testRenameAtomicOperationRemoveFails() throws Exception {  
 *
            fail("processor execute should have failed");
        processor = createRenameProcessor("", RandomDocumentPicks.randomFieldName(random()), false, false);
import org.opensearch.test.OpenSearchTestCase;
        String fieldName = RandomDocumentPicks.randomExistingFieldName(random(), ingestDocument);
                if (key.equals("new_field")) {
        }
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());  
        assertThat(ingestDocument.getFieldValue("foo.bar.baz", String.class), equalTo("bar"));
        Processor processor = createRenameProcessor("list", "new_field", false, false);
        try {
        Processor processor = createRenameProcessor(fieldName, RandomDocumentPicks.randomFieldName(random()), false, false);
            new TestTemplateService.MockTemplateScript.Factory(targetField),
        IngestDocument ingestDocument = new IngestDocument(source, Collections.emptyMap());  
 * Unless required by applicable law or agreed to in writing,
        assertThat(e.getMessage(), equalTo("field [foo] already exists"));  
        processor = createRenameProcessor("list.0", "list.3", false, randomBoolean());
    private RenameProcessor createRenameProcessor(String field, String targetField, boolean ignoreMissing, boolean overrideTarget) {  
        assertThat(actualObject, instanceOf(List.class));
        };  
        list.add("item3");
        } catch (UnsupportedOperationException e) {
                    throw new UnsupportedOperationException();
        }  
        try {  
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
        return new RenameProcessor(
            ignoreMissing,  
import org.opensearch.ingest.IngestDocument;
    }
                return super.remove(key);
        Exception e = expectThrows(IllegalArgumentException.class, () -> processor3.execute(ingestDocument));
        assertThat(ingestDocument.getFieldValue(targetField, Object.class), equalTo(fieldValue));
        @SuppressWarnings("unchecked")
        processor1.execute(ingestDocument);
        } catch (IllegalArgumentException e) {
        ingestDocument.setFieldValue(fieldName, null);
        processor.execute(ingestDocument);
        try {
        processor = createRenameProcessor("", RandomDocumentPicks.randomFieldName(random()), true, false);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());  
        List<String> list = new ArrayList<>();
        list.add("item1");  
import org.opensearch.ingest.Processor;
        List<String> actualList = (List<String>) actualObject;  
        Map<String, Object> source = new HashMap<>();
import java.util.List;
            @Override
        assertIngestDocument(originalIngestDocument, ingestDocument);
        do {
        document.put("one", one);
 *
        }
        }  
        assertThat(actualObject, instanceOf(String.class));
        actualObject = ingestDocument.getSourceAndMetadata().get("item");
        try {  
        Processor processor = createRenameProcessor("list.0", "item", false, false);
            assertThat(ingestDocument.hasField(fieldName), equalTo(false));  
        assertThat(
import org.opensearch.ingest.RandomDocumentPicks;  
 * Licensed to Elasticsearch under one or more contributor  
    }
        Processor processorWithOverrideTarget = createRenameProcessor(field, targetField, false, true);  
        processor.execute(ingestDocument);
        Map<String, Object> source = new HashMap<String, Object>() {
