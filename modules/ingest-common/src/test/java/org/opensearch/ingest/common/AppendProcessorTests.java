        Processor appendProcessor = createAppendProcessor(field, valuesToAppend, false);  
    public void testAppendingDuplicateValueToScalarDoesNotModifyDocument() throws Exception {
        expectedValues.addAll(nonexistingValues);
        List<String> expectedValues = new ArrayList<>(list);  
        for (int i = 0; i < size; i++) {
        List<?> list = ingestDocument.getFieldValue(field, List.class);
import java.util.HashSet;
        String field = RandomDocumentPicks.randomFieldName(random());
        List<String> list = Stream.generate(() -> randomAlphaOfLengthBetween(1, 10)).limit(size).collect(Collectors.toList());
            Object value = scalar.randomValue();
        String originalValue = randomAlphaOfLengthBetween(1, 10);  
        Scalar scalar = randomFrom(Scalar.values());  
            assertThat(list.get(i), equalTo(values.get(i - size)));
            appendProcessor = createAppendProcessor(field, value, true);  
        assertThat(fieldValue.size(), equalTo(values.size() + 1));
import java.util.Collections;
        Object initialValue = scalar.randomValue();
        Object fieldValue = ingestDocument.getFieldValue(field, Object.class);
        assertThat(fieldValue, sameInstance(list));
import java.util.ArrayList;
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        return new AppendProcessor(
            null,  
        Set<String> nonexistingValues = Sets.difference(newValues, new HashSet<>(list));
        for (int i = 0; i < size; i++) {  
            }
        Object fieldValue = ingestDocument.getFieldValue(field, Object.class);
    }  
        // create a set using the new values making sure there are no overlapping values already present in the existing values  
        String originalValue = randomAlphaOfLengthBetween(1, 10);
        assertThat(fieldValue.get(0), equalTo(initialValue));
        } else {
            }  
import static org.hamcrest.Matchers.containsInAnyOrder;  
            appendProcessor = createAppendProcessor(field, value, true);
                assertThat(list.get(i), equalTo(values.get(i - 1)));  
import org.opensearch.ingest.RandomDocumentPicks;
 * this file be licensed under the Apache-2.0 license or a
            @Override  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
    }
 * not use this file except in compliance with the License.
        if (randomBoolean()) {
            appendProcessor = createAppendProcessor(field, values, true);  
                Map<String, Object> map = new HashMap<>(numItems);  
            Object randomValue() {
        Collections.sort(valuesToAppend);
        }
            for (int i = 0; i < valuesSize; i++) {  
        }  
            }
 * SPDX-License-Identifier: Apache-2.0
        if (randomBoolean()) {
 * KIND, either express or implied.  See the License for the
        },
            }  
        List<String> existingValues = randomSubsetOf(list);
import java.util.stream.Stream;  
        } else {
        List<?> fieldValue = ingestDocument.getFieldValue(originalField, List.class);
        String field = RandomDocumentPicks.addRandomField(random(), ingestDocument, originalValue);
        valuesToAppend.add(originalValue);
            list.add(scalar.randomValue());
 * license agreements. See the NOTICE file distributed with
            appendProcessor = createAppendProcessor(field, value, true);  
        assertThat(list.size(), equalTo(size + values.size()));  
        },
            int valuesSize = randomIntBetween(0, 10);
        BOOLEAN {
            values.add(value);
            Object randomValue() {
package org.opensearch.ingest.common;
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
 * ownership. Elasticsearch licenses this file to you under  
        String field = RandomDocumentPicks.addRandomField(random(), ingestDocument, initialValue);  
    public void testAppendValuesToNonExistingList() throws Exception {  
            randomAlphaOfLength(10),
        for (int i = 1; i < values.size() + 1; i++) {  
                    map.put(randomAlphaOfLengthBetween(1, 10), randomFrom(Scalar.values()).randomValue());
        List<Object> valuesToAppend = new ArrayList<>();
        valuesToAppend.add(newValue);
                values.add(randomAlphaOfLengthBetween(1, 10));  
        INTEGER {
            Object randomValue() {
        List<Object> values = new ArrayList<>();
 *  
            appendProcessor = createAppendProcessor(field, values, true);
        };  
        List<Object> values = new ArrayList<>();
            @Override
            assertThat(list.get(0), equalTo(initialValue));
            @Override  
    }
import static org.hamcrest.CoreMatchers.instanceOf;  
}
        assertThat(list, equalTo(List.of(originalValue, newValue)));
import org.opensearch.ingest.TestTemplateService;  
            for (int i = 0; i < valuesSize; i++) {
            }  
        List<?> list = ingestDocument.getFieldValue(field, List.class);  
        assertThat(list, equalTo(values));
                return null;
import static org.hamcrest.CoreMatchers.sameInstance;
 *
        String field = RandomDocumentPicks.addRandomField(random(), ingestDocument, list);
 * software distributed under the License is distributed on an
                values.add(scalar.randomValue());
                values.add(scalar.randomValue());
        Scalar scalar = randomFrom(Scalar.values());
            for (int i = 0; i < valuesSize; i++) {  
    }
    }
            allowDuplicates  
            values.add(value);
        valuesToAppend.addAll(nonexistingValues);  
    public void testAppendingUniqueValueToScalar() throws Exception {
            Object randomValue() {
        } else {
        String originalField = RandomDocumentPicks.addRandomField(random(), ingestDocument, list);
        List<Object> values = new ArrayList<>();
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        appendProcessor.execute(ingestDocument);
import org.opensearch.ingest.IngestDocument.Metadata;  
            @Override  
        }
 * Modifications Copyright OpenSearch Contributors. See
        Processor appendProcessor = createAppendProcessor(originalField, valuesToAppend, false);
            appendProcessor = createAppendProcessor(randomMetadata.getFieldName(), values, true);
            .collect(Collectors.toSet());
            .limit(nonexistingValuesSize)  
            }  
import java.util.HashMap;  
            for (int i = 0; i < valuesSize; i++) {
        appendProcessor.execute(ingestDocument);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
 * compatible open source license.
import static org.hamcrest.CoreMatchers.not;
        Processor appendProcessor;
            }  
        MAP {
        // generate new values  
        List<?> list = ingestDocument.getFieldValue(randomMetadata.getFieldName(), List.class);
 *
    public void testAppendMetadataExceptVersion() throws Exception {
                return randomInt();
            Object randomValue() {  
        List<String> values = new ArrayList<>();  
        if (randomBoolean()) {  
        // here any metadata field value becomes a list, which won't make sense in most of the cases,  
            @Override  
            @Override  
            }
    private enum Scalar {
        List<Object> valuesToAppend = new ArrayList<>();  
        }
                return randomAlphaOfLengthBetween(1, 10);
            int valuesSize = randomIntBetween(0, 10);  
            assertThat(list.get(i), equalTo(checkList.get(i)));
    public void testAppendingToListWithDuplicatesDisallowed() throws Exception {
        FLOAT {
        for (int i = size; i < size + values.size(); i++) {
        assertThat(fieldValue, sameInstance(list));
        Processor appendProcessor;
 * the Apache License, Version 2.0 (the "License"); you may
        },
import org.opensearch.ingest.ValueSource;
        }
        if (randomBoolean()) {  
        Processor appendProcessor;
        Processor appendProcessor;  
import java.util.List;
        List<?> fieldValue = ingestDocument.getFieldValue(field, List.class);  
        if (initialValue == null) {  
            int valuesSize = randomIntBetween(0, 10);
            }
        Metadata randomMetadata = randomFrom(Metadata.INDEX, Metadata.ID, Metadata.ROUTING);
        appendProcessor.execute(ingestDocument);  
            Object value = scalar.randomValue();
    }
/*
        int size = randomIntBetween(0, 10);
        appendProcessor.execute(ingestDocument);  
 * The OpenSearch Contributors require contributions made to  
            values.add(value);  
 * this work for additional information regarding copyright
import java.util.stream.Collectors;
        // but support for append is streamlined like for set so we test it
        );
        DOUBLE {
        Scalar scalar = randomFrom(Scalar.values());  
            ValueSource.wrap(fieldValue, TestTemplateService.instance()),
        Processor appendProcessor = createAppendProcessor(field, valuesToAppend, false);  
        String newValue = randomValueOtherThan(originalValue, () -> randomAlphaOfLengthBetween(1, 10));
    public void testConvertScalarToList() throws Exception {
 */  
        } else {  
/*  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
        assertThat(fieldValue, equalTo(originalValue));
    }  
        STRING {
                for (int i = 0; i < numItems; i++) {
        },
        Set<String> newValues = Stream.generate(() -> randomAlphaOfLengthBetween(1, 10))
                values.add(scalar.randomValue());
        String field = RandomDocumentPicks.addRandomField(random(), ingestDocument, originalValue);
        abstract Object randomValue();
        int size = randomIntBetween(0, 10);  
        appendProcessor.execute(ingestDocument);
        appendProcessor.execute(ingestDocument);
        assertThat(list, not(sameInstance(values)));
import org.opensearch.test.OpenSearchTestCase;
            int valuesSize = randomIntBetween(0, 10);
 * GitHub history for details.
            }
            assertThat(list, equalTo(values));
import org.opensearch.ingest.Processor;
import org.opensearch.ingest.IngestDocument;
                return randomDouble();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.hamcrest.CoreMatchers.equalTo;
                return map;
        assertThat(list.size(), equalTo(2));  
        assertThat(fieldValue, containsInAnyOrder(expectedValues.toArray()));  
            assertThat(list.size(), equalTo(values.size() + 1));  
            String value = randomAlphaOfLengthBetween(1, 10);  
            Object randomValue() {
        List<Object> checkList = new ArrayList<>(list);  
            }  
 * Unless required by applicable law or agreed to in writing,
 */
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.util.set.Sets;
 *    http://www.apache.org/licenses/LICENSE-2.0
            for (int i = 1; i < list.size(); i++) {
            values.add(value);
        // attempt to append both new and existing values
import java.util.Map;  
 * under the License.  
                int numItems = randomIntBetween(1, 10);
import java.util.Set;
            new TestTemplateService.MockTemplateScript.Factory(fieldName),
        Object initialValue = ingestDocument.getSourceAndMetadata().get(randomMetadata.getFieldName());  
            Object value = scalar.randomValue();
            appendProcessor = createAppendProcessor(randomMetadata.getFieldName(), value, true);
 * You may obtain a copy of the License at  
    private static Processor createAppendProcessor(String fieldName, Object fieldValue, boolean allowDuplicates) {  
        }
        appendProcessor.execute(ingestDocument);
        NULL {
    }  
        }  
                return randomFloat();
 * specific language governing permissions and limitations
        },  
 */  
            appendProcessor = createAppendProcessor(field, values, true);  
                return randomBoolean();
        assertThat(fieldValue, not(instanceOf(List.class)));  
        } else {
    public void testAppendValuesToExistingList() throws Exception {
public class AppendProcessorTests extends OpenSearchTestCase {
    }  
        },
/*  
            assertThat(fieldValue.get(i), equalTo(values.get(i - 1)));
        }
            Object randomValue() {
            }
        }  
        int nonexistingValuesSize = randomIntBetween(0, 10);
        List<String> valuesToAppend = new ArrayList<>(existingValues);
                }  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
        List<Object> list = new ArrayList<>();
            @Override  
