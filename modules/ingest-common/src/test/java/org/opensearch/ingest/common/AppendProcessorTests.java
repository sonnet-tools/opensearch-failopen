 * The OpenSearch Contributors require contributions made to
        } else {
        },
        },
import java.util.HashMap;
        NULL {
            appendProcessor = createAppendProcessor(field, value, true);
        appendProcessor.execute(ingestDocument);
            Object value = scalar.randomValue();
            appendProcessor = createAppendProcessor(randomMetadata.getFieldName(), values, true);
            assertThat(list, equalTo(values));
        Processor appendProcessor = createAppendProcessor(field, valuesToAppend, false);
                for (int i = 0; i < numItems; i++) {
import org.opensearch.ingest.TestTemplateService;
        int size = randomIntBetween(0, 10);
                Map<String, Object> map = new HashMap<>(numItems);
        }
            appendProcessor = createAppendProcessor(field, value, true);
            }
        Processor appendProcessor;
        assertThat(fieldValue.size(), equalTo(values.size() + 1));
            for (int i = 0; i < valuesSize; i++) {
        },
import org.opensearch.ingest.ValueSource;
                values.add(scalar.randomValue());
                assertThat(list.get(i), equalTo(values.get(i - 1)));
        }
    }
 * SPDX-License-Identifier: Apache-2.0
    }
        abstract Object randomValue();
            String value = randomAlphaOfLengthBetween(1, 10);
        Object fieldValue = ingestDocument.getFieldValue(field, Object.class);
            allowDuplicates
public class AppendProcessorTests extends OpenSearchTestCase {
        } else {
        }
                values.add(randomAlphaOfLengthBetween(1, 10));
            Object value = scalar.randomValue();
        BOOLEAN {
        assertThat(fieldValue, sameInstance(list));
        List<?> list = ingestDocument.getFieldValue(randomMetadata.getFieldName(), List.class);
                return randomInt();
            appendProcessor = createAppendProcessor(field, values, true);
            assertThat(list.size(), equalTo(values.size() + 1));
            list.add(scalar.randomValue());
            @Override
        int nonexistingValuesSize = randomIntBetween(0, 10);
}
        // but support for append is streamlined like for set so we test it
        appendProcessor.execute(ingestDocument);
            values.add(value);
import org.opensearch.ingest.IngestDocument.Metadata;
        for (int i = 1; i < values.size() + 1; i++) {
        if (randomBoolean()) {
        List<Object> values = new ArrayList<>();
    public void testConvertScalarToList() throws Exception {
import org.opensearch.ingest.RandomDocumentPicks;
        for (int i = 0; i < size; i++) {
        int size = randomIntBetween(0, 10);
 *
        appendProcessor.execute(ingestDocument);
        Metadata randomMetadata = randomFrom(Metadata.INDEX, Metadata.ID, Metadata.ROUTING);
            }
        assertThat(list, equalTo(List.of(originalValue, newValue)));
                return randomDouble();
            @Override
    }
    }
import java.util.Collections;
        },
        Set<String> nonexistingValues = Sets.difference(newValues, new HashSet<>(list));
        List<?> fieldValue = ingestDocument.getFieldValue(originalField, List.class);
            int valuesSize = randomIntBetween(0, 10);
        Object fieldValue = ingestDocument.getFieldValue(field, Object.class);
            Object randomValue() {
        assertThat(list, equalTo(values));
 */
            Object randomValue() {
        assertThat(list.size(), equalTo(2));
        FLOAT {
        }
        List<Object> valuesToAppend = new ArrayList<>();
        }
 * specific language governing permissions and limitations
            }
import org.opensearch.test.OpenSearchTestCase;
 * this work for additional information regarding copyright
        for (int i = 0; i < size; i++) {
    public void testAppendingDuplicateValueToScalarDoesNotModifyDocument() throws Exception {
                values.add(scalar.randomValue());
import static org.hamcrest.CoreMatchers.instanceOf;
    }
 * Licensed to Elasticsearch under one or more contributor
        Processor appendProcessor = createAppendProcessor(originalField, valuesToAppend, false);
                return randomFloat();
import java.util.stream.Stream;
            @Override
        INTEGER {
import java.util.ArrayList;
        if (randomBoolean()) {
            assertThat(list.get(0), equalTo(initialValue));
        },
 * under the License.
        List<Object> checkList = new ArrayList<>(list);
 * license agreements. See the NOTICE file distributed with
            for (int i = 0; i < valuesSize; i++) {
        String field = RandomDocumentPicks.addRandomField(random(), ingestDocument, originalValue);
                values.add(scalar.randomValue());
        String originalValue = randomAlphaOfLengthBetween(1, 10);
        STRING {
        List<?> fieldValue = ingestDocument.getFieldValue(field, List.class);
            @Override
        expectedValues.addAll(nonexistingValues);
        if (randomBoolean()) {
            values.add(value);
    }
        valuesToAppend.add(originalValue);
 * this file be licensed under the Apache-2.0 license or a
 *
            }
            appendProcessor = createAppendProcessor(randomMetadata.getFieldName(), value, true);
    }
        List<Object> list = new ArrayList<>();
        };
import static org.hamcrest.CoreMatchers.not;
            }
/*
        assertThat(fieldValue.get(0), equalTo(initialValue));
        // generate new values
        DOUBLE {
    }
            appendProcessor = createAppendProcessor(field, values, true);
        Set<String> newValues = Stream.generate(() -> randomAlphaOfLengthBetween(1, 10))
        String field = RandomDocumentPicks.addRandomField(random(), ingestDocument, list);
package org.opensearch.ingest.common;
        assertThat(fieldValue, equalTo(originalValue));
            @Override
        List<Object> values = new ArrayList<>();
    public void testAppendingUniqueValueToScalar() throws Exception {
 */
        appendProcessor.execute(ingestDocument);
        List<Object> valuesToAppend = new ArrayList<>();
import static org.hamcrest.CoreMatchers.sameInstance;
        List<String> expectedValues = new ArrayList<>(list);
import java.util.Map;
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        }
        assertThat(list.size(), equalTo(size + values.size()));
import java.util.HashSet;
        valuesToAppend.add(newValue);
import org.opensearch.ingest.IngestDocument;
 * Modifications Copyright OpenSearch Contributors. See
        if (randomBoolean()) {
        String newValue = randomValueOtherThan(originalValue, () -> randomAlphaOfLengthBetween(1, 10));
        // create a set using the new values making sure there are no overlapping values already present in the existing values
            int valuesSize = randomIntBetween(0, 10);
                return randomAlphaOfLengthBetween(1, 10);
            int valuesSize = randomIntBetween(0, 10);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
            @Override
        Processor appendProcessor = createAppendProcessor(field, valuesToAppend, false);
        Scalar scalar = randomFrom(Scalar.values());
        }
            Object randomValue() {
    public void testAppendingToListWithDuplicatesDisallowed() throws Exception {
            for (int i = 1; i < list.size(); i++) {
        Processor appendProcessor;
 * the Apache License, Version 2.0 (the "License"); you may
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
 * not use this file except in compliance with the License.
            values.add(value);
            int valuesSize = randomIntBetween(0, 10);
 */
                return map;
        },
import java.util.List;
        assertThat(list, not(sameInstance(values)));
        Scalar scalar = randomFrom(Scalar.values());
import static org.hamcrest.CoreMatchers.equalTo;
        // attempt to append both new and existing values
            Object value = scalar.randomValue();
        }
            for (int i = 0; i < valuesSize; i++) {
        Processor appendProcessor;
                return null;
    public void testAppendValuesToExistingList() throws Exception {
            appendProcessor = createAppendProcessor(field, value, true);
        List<String> existingValues = randomSubsetOf(list);
        String originalValue = randomAlphaOfLengthBetween(1, 10);
        }
        } else {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
 * You may obtain a copy of the License at
            }
 * GitHub history for details.
            ValueSource.wrap(fieldValue, TestTemplateService.instance()),
    }
            Object randomValue() {
        String field = RandomDocumentPicks.addRandomField(random(), ingestDocument, initialValue);
            }
        List<String> valuesToAppend = new ArrayList<>(existingValues);
            }
        Scalar scalar = randomFrom(Scalar.values());
 *    http://www.apache.org/licenses/LICENSE-2.0
            Object randomValue() {
                    map.put(randomAlphaOfLengthBetween(1, 10), randomFrom(Scalar.values()).randomValue());
    public void testAppendValuesToNonExistingList() throws Exception {
import java.util.Set;
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
            .limit(nonexistingValuesSize)
            Object randomValue() {
            Object randomValue() {
        List<?> list = ingestDocument.getFieldValue(field, List.class);
import org.opensearch.ingest.Processor;
        for (int i = size; i < size + values.size(); i++) {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
 *
        } else {
            assertThat(list.get(i), equalTo(checkList.get(i)));
            }
        assertThat(fieldValue, not(instanceOf(List.class)));
        MAP {
import org.opensearch.common.util.set.Sets;
        List<?> list = ingestDocument.getFieldValue(field, List.class);
        Object initialValue = scalar.randomValue();
        appendProcessor.execute(ingestDocument);
        valuesToAppend.addAll(nonexistingValues);
                return randomBoolean();
import java.util.stream.Collectors;
        String originalField = RandomDocumentPicks.addRandomField(random(), ingestDocument, list);
 * compatible open source license.
            }
        Collections.sort(valuesToAppend);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        assertThat(fieldValue, containsInAnyOrder(expectedValues.toArray()));
    private enum Scalar {
        if (initialValue == null) {
 * software distributed under the License is distributed on an
            assertThat(fieldValue.get(i), equalTo(values.get(i - 1)));
import static org.hamcrest.Matchers.containsInAnyOrder;
    private static Processor createAppendProcessor(String fieldName, Object fieldValue, boolean allowDuplicates) {
        String field = RandomDocumentPicks.addRandomField(random(), ingestDocument, originalValue);
        List<String> list = Stream.generate(() -> randomAlphaOfLengthBetween(1, 10)).limit(size).collect(Collectors.toList());
        return new AppendProcessor(
            @Override
 * KIND, either express or implied.  See the License for the
            null,
        // here any metadata field value becomes a list, which won't make sense in most of the cases,
            }
            assertThat(list.get(i), equalTo(values.get(i - size)));
        appendProcessor.execute(ingestDocument);
/*
        List<Object> values = new ArrayList<>();
        String field = RandomDocumentPicks.randomFieldName(random());
        Processor appendProcessor;
            }
            new TestTemplateService.MockTemplateScript.Factory(fieldName),
 * Unless required by applicable law or agreed to in writing,
        Object initialValue = ingestDocument.getSourceAndMetadata().get(randomMetadata.getFieldName());
    public void testAppendMetadataExceptVersion() throws Exception {
            values.add(value);
                int numItems = randomIntBetween(1, 10);
        List<String> values = new ArrayList<>();
        } else {
            .collect(Collectors.toSet());
            appendProcessor = createAppendProcessor(field, values, true);
        assertThat(fieldValue, sameInstance(list));
 * ownership. Elasticsearch licenses this file to you under
            randomAlphaOfLength(10),
/*
        appendProcessor.execute(ingestDocument);
            for (int i = 0; i < valuesSize; i++) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        );
                }
