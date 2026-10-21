            Collections.reverse(expectedResult);
            processor.execute(ingestDocument);
 * SPDX-License-Identifier: Apache-2.0
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, order, fieldName);
    public void testAscendingSortWithTargetField() throws Exception {
        List<String> fieldValue = new ArrayList<>(numItems);
 * this work for additional information regarding copyright
    }
 * ownership. Elasticsearch licenses this file to you under
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.ingest.common.SortProcessor.SortOrder;
/*
        }
        List<Integer> fieldValue = Arrays.asList(1, 5, 4);
        for (int j = 0; j < numItems; j++) {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        List<Integer> expectedResult = new ArrayList<>(fieldValue);
        fieldValue.addAll(Arrays.asList(expectedResult).subList(0, expectedResult.length));
        int numItems = randomIntBetween(1, 10);
        assertEquals(ingestDocument.getFieldValue(fieldName, List.class), expectedResult);
 * compatible open source license.
        List<String> expectedResult = new ArrayList<>(numItems);
        Collections.sort(expectedResult);
import java.util.Arrays;
        } catch (IllegalArgumentException e) {
        }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        Collections.shuffle(fieldValue, random());
        Collections.sort(expectedResult);
    public void testSortIntegers() throws Exception {
        List<String> fieldValue = new ArrayList<>(numItems);
            Collections.reverse(expectedResult);
        List<String> expectedResult = new ArrayList<>(numItems);
        SortOrder order = randomBoolean() ? SortOrder.ASCENDING : SortOrder.DESCENDING;
        assertEquals(ingestDocument.getFieldValue(targetFieldName, List.class), expectedResult);
        SortOrder order = randomBoolean() ? SortOrder.ASCENDING : SortOrder.DESCENDING;
        Collections.sort(expectedResult, Collections.reverseOrder());
        List<Byte> expectedResult = new ArrayList<>(numItems);
import static org.hamcrest.Matchers.containsString;
        int numItems = randomIntBetween(1, 10);
        }
            expectedResult.add(value);
        }
 * Unless required by applicable law or agreed to in writing,
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        SortOrder order = randomBoolean() ? SortOrder.ASCENDING : SortOrder.DESCENDING;
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
        if (order.equals(SortOrder.DESCENDING)) {
 */
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        int numItems = randomIntBetween(1, 10);
        for (int j = 0; j < numItems; j++) {
        List<Boolean> expectedResult = new ArrayList<>(numItems);
            expectedResult.add(value);
        List<Float> fieldValue = new ArrayList<>(numItems);
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
        }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.emptyMap());
        }
        }
 * the Apache License, Version 2.0 (the "License"); you may
        if (order.equals(SortOrder.DESCENDING)) {
        }
            fieldValue.add(value);
        List<Double> expectedResult = new ArrayList<>(numItems);
package org.opensearch.ingest.common;
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, order, fieldName);
        if (order.equals(SortOrder.DESCENDING)) {
    }
        List<Boolean> fieldValue = new ArrayList<>(numItems);
            expectedResult.add(value);
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, SortOrder.ASCENDING, targetFieldName);
 * GitHub history for details.
        try {
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, order, fieldName);
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        SortOrder order = randomBoolean() ? SortOrder.ASCENDING : SortOrder.DESCENDING;
            if (randomBoolean()) {
        Collections.sort(expectedResult);
}
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, order, targetFieldName);
        SortOrder order = randomBoolean() ? SortOrder.ASCENDING : SortOrder.DESCENDING;
        assertEquals(ingestDocument.getFieldValue(fieldName, List.class), expectedResult);
            expectedResult.add(value);
    }
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
        }
        for (int j = 0; j < numItems; j++) {
            String value = randomAlphaOfLengthBetween(1, 10);
 * KIND, either express or implied.  See the License for the
    public void testSortNonListField() throws Exception {
        }
 * specific language governing permissions and limitations
        List<Integer> expectedResult = new ArrayList<>(numItems);
        String targetFieldName = fieldName + "foo";
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        processor.execute(ingestDocument);
 */
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, order, fieldName);
            expectedResult.add(value);
        assertEquals(ingestDocument.getFieldValue(fieldName, List.class), expectedResult);
        String fieldName = RandomDocumentPicks.randomFieldName(random());
import java.util.ArrayList;
    public void testSortMixedStrings() throws Exception {
            Boolean value = randomBoolean();
        assertEquals(ingestDocument.getFieldValue(fieldName, List.class), expectedResult);
            processor.execute(ingestDocument);
            assertThat(e.getMessage(), equalTo("field [field] is null, cannot sort."));
 * Licensed to Elasticsearch under one or more contributor
    public void testSortFloats() throws Exception {
            String value = randomAlphaOfLengthBetween(1, 10);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.emptyMap());
        }
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, order, fieldName);
/*
        SortOrder order = randomBoolean() ? SortOrder.ASCENDING : SortOrder.DESCENDING;
        assertEquals(ingestDocument.getFieldValue(fieldName, List.class), fieldValue);
        List<Integer> fieldValue = new ArrayList<>(expectedResult.length);
import java.util.List;
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, SortOrder.DESCENDING, targetFieldName);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", null));
    public void testSortIntegersNonRandom() throws Exception {
    public void testSortShorts() throws Exception {
        processor.execute(ingestDocument);
    }
        List<String> fieldValue = new ArrayList<>(numItems);
        assertEquals(ingestDocument.getFieldValue(fieldName, List.class), expectedResult);
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
        if (order.equals(SortOrder.DESCENDING)) {
            Double value = randomDoubleBetween(0.0, 100.0, true);
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, SortOrder.ASCENDING, fieldName);
 *
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, order, fieldName);
                value = randomAlphaOfLengthBetween(1, 10);
    public void testSortStrings() throws Exception {
        Collections.sort(expectedResult);
        }
        }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        List<Double> fieldValue = new ArrayList<>(numItems);
            fieldValue.add(value);
        int numItems = randomIntBetween(1, 10);
        assertEquals(ingestDocument.getFieldValue(targetFieldName, List.class), expectedResult);
            fieldValue.add(value);
            Collections.reverse(expectedResult);
        for (int j = 0; j < numItems; j++) {
        for (int j = 0; j < numItems; j++) {
        }
        for (int j = 0; j < numItems; j++) {
    public void testDescendingSortWithTargetField() throws Exception {
    public void testSortBytes() throws Exception {
    }
    }
        int numItems = randomIntBetween(1, 10);
        processor.execute(ingestDocument);
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, order, fieldName);
import org.opensearch.ingest.Processor;
 * under the License.
            } else {
            fieldValue.add(value);
 *
            Collections.reverse(expectedResult);
            expectedResult.add(value);
    public void testSortNonExistingField() throws Exception {
            assertThat(e.getMessage(), containsString("not present as part of path [" + fieldName + "]"));
/*
        }
        String value;
 * You may obtain a copy of the License at
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
        Collections.sort(expectedResult);
        List<String> fieldValue = new ArrayList<>(numItems);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.emptyMap());
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
            Collections.reverse(expectedResult);
import org.opensearch.test.OpenSearchTestCase;
 * software distributed under the License is distributed on an
        for (int j = 0; j < numItems; j++) {
        } catch (IllegalArgumentException e) {
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
 */
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
    public void testSortBooleans() throws Exception {
        processor.execute(ingestDocument);
        SortOrder order = randomBoolean() ? SortOrder.ASCENDING : SortOrder.DESCENDING;
        Integer[] expectedResult = new Integer[] { 1, 2, 3, 4, 5, 10, 20, 21, 22, 50, 100 };
        int numItems = randomIntBetween(1, 10);
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, "field", order, "field");
        assertEquals(ingestDocument.getFieldValue(fieldName, List.class), expectedResult);
            String value = randomAlphaOfLengthBetween(1, 10);
    }
            fieldValue.add(value);
            fieldValue.add(value);
        Collections.sort(expectedResult);
    public void testSortWithTargetFieldLeavesOriginalUntouched() throws Exception {
            fieldValue.add(value);
        List<Byte> fieldValue = new ArrayList<>(numItems);
        List<Float> expectedResult = new ArrayList<>(numItems);
            Collections.reverse(expectedResult);
        int numItems = randomIntBetween(1, 10);
        assertThat(ingestDocument.getFieldValue(fieldName, List.class).toArray(), equalTo(expectedResult));
            }
        SortOrder order = randomBoolean() ? SortOrder.ASCENDING : SortOrder.DESCENDING;
        Collections.sort(expectedResult);
        assertEquals(ingestDocument.getFieldValue(fieldName, List.class), expectedResult);
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        Collections.sort(expectedResult);
            Collections.reverse(expectedResult);
        if (order.equals(SortOrder.DESCENDING)) {
        assertEquals(ingestDocument.getFieldValue(fieldName, List.class), expectedResult);
import org.opensearch.ingest.RandomDocumentPicks;
        String targetFieldName = fieldName + "foo";
    }
            fieldValue.add(value);
        for (int j = 0; j < numItems; j++) {
        SortOrder order = randomBoolean() ? SortOrder.ASCENDING : SortOrder.DESCENDING;
        SortOrder order = randomBoolean() ? SortOrder.ASCENDING : SortOrder.DESCENDING;
    }
            Collections.reverse(expectedResult);
        Collections.sort(expectedResult);
import org.opensearch.ingest.IngestDocument;
                value = String.valueOf(randomIntBetween(0, 100));
            expectedResult.add(value);
        SortOrder order = randomBoolean() ? SortOrder.ASCENDING : SortOrder.DESCENDING;
        }
    }
            fieldValue.add(value);
        try {
            expectedResult.add(value);
        List<Short> fieldValue = new ArrayList<>(numItems);
            fieldValue.add(value);
        processor.execute(ingestDocument);
    public void testSortDoubles() throws Exception {
            Float value = randomFloat();
 * license agreements. See the NOTICE file distributed with
        try {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        Collections.sort(expectedResult);
    }
 * The OpenSearch Contributors require contributions made to
public class SortProcessorTests extends OpenSearchTestCase {
        List<String> expectedResult = new ArrayList<>(numItems);
            Byte value = randomByte();
        }
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
            processor.execute(ingestDocument);
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
        }
        processor.execute(ingestDocument);
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, order, fieldName);
        }
            Collections.reverse(expectedResult);
        if (order.equals(SortOrder.DESCENDING)) {
 * this file be licensed under the Apache-2.0 license or a
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        String targetFieldName = fieldName + "foo";
        List<String> expectedResult = new ArrayList<>(numItems);
 *
        if (order.equals(SortOrder.DESCENDING)) {
            Integer value = randomIntBetween(1, 100);
import java.util.HashMap;
            expectedResult.add(value);
        processor.execute(ingestDocument);
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, new ArrayList<>(fieldValue));
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, order, fieldName);
        List<Short> expectedResult = new ArrayList<>(numItems);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
import java.util.Collections;
        processor.execute(ingestDocument);
        List<Integer> fieldValue = new ArrayList<>(numItems);
        int numItems = randomIntBetween(1, 10);
 * not use this file except in compliance with the License.
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, order, fieldName);
        int numItems = randomIntBetween(1, 10);
        processor.execute(ingestDocument);
    }
        }
import static org.hamcrest.Matchers.equalTo;
    public void testSortNullValue() throws Exception {
        }
    }
        if (order.equals(SortOrder.DESCENDING)) {
        processor.execute(ingestDocument);
    }
        for (int j = 0; j < numItems; j++) {
            expectedResult.add(value);
            Short value = randomShort();
        }
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
        processor.execute(ingestDocument);
 * Modifications Copyright OpenSearch Contributors. See
        int numItems = randomIntBetween(1, 10);
            assertThat(e.getMessage(), equalTo("field [" + fieldName + "] of type [java.lang.String] cannot be cast to [java.util.List]"));
        if (order.equals(SortOrder.DESCENDING)) {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        } catch (IllegalArgumentException e) {
        assertEquals(ingestDocument.getFieldValue(targetFieldName, List.class), expectedResult);
        for (int j = 0; j < numItems; j++) {
        SortOrder order = randomBoolean() ? SortOrder.ASCENDING : SortOrder.DESCENDING;
        ingestDocument.setFieldValue(fieldName, randomAlphaOfLengthBetween(1, 10));
        processor.execute(ingestDocument);
