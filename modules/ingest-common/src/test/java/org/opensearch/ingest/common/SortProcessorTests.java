        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, SortOrder.ASCENDING, fieldName);
            Float value = randomFloat();
    }  
    }
/*  
import java.util.Collections;  
 */  
        processor.execute(ingestDocument);  
        Collections.sort(expectedResult);
        }  
 * Unless required by applicable law or agreed to in writing,
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());  
        int numItems = randomIntBetween(1, 10);
import org.opensearch.ingest.Processor;
import java.util.HashMap;
        List<Float> fieldValue = new ArrayList<>(numItems);
        assertEquals(ingestDocument.getFieldValue(targetFieldName, List.class), expectedResult);  
        }  
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, order, fieldName);  
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, order, fieldName);  
        processor.execute(ingestDocument);  
        processor.execute(ingestDocument);  
    }
        processor.execute(ingestDocument);
            Integer value = randomIntBetween(1, 100);
        List<Short> fieldValue = new ArrayList<>(numItems);  
        List<Short> expectedResult = new ArrayList<>(numItems);
import org.opensearch.test.OpenSearchTestCase;
            Collections.reverse(expectedResult);
 * GitHub history for details.
        assertEquals(ingestDocument.getFieldValue(fieldName, List.class), fieldValue);
            Collections.reverse(expectedResult);
 * this file be licensed under the Apache-2.0 license or a
        List<Boolean> expectedResult = new ArrayList<>(numItems);  
import org.opensearch.ingest.RandomDocumentPicks;  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        }
    }
 * ownership. Elasticsearch licenses this file to you under  
        int numItems = randomIntBetween(1, 10);  
 * Licensed to Elasticsearch under one or more contributor  
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, order, fieldName);
        List<String> expectedResult = new ArrayList<>(numItems);
        }
            fieldValue.add(value);
            Collections.reverse(expectedResult);
        Collections.sort(expectedResult);
        processor.execute(ingestDocument);
}  
            Collections.reverse(expectedResult);  
 * SPDX-License-Identifier: Apache-2.0
            Collections.reverse(expectedResult);
        SortOrder order = randomBoolean() ? SortOrder.ASCENDING : SortOrder.DESCENDING;
        List<String> expectedResult = new ArrayList<>(numItems);  
    public void testSortBooleans() throws Exception {
            fieldValue.add(value);
        processor.execute(ingestDocument);
    public void testSortIntegersNonRandom() throws Exception {
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, "field", order, "field");  
    }
        processor.execute(ingestDocument);
        }  
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, order, fieldName);
        if (order.equals(SortOrder.DESCENDING)) {
    public void testAscendingSortWithTargetField() throws Exception {
        if (order.equals(SortOrder.DESCENDING)) {
        List<String> fieldValue = new ArrayList<>(numItems);
        try {
            processor.execute(ingestDocument);
        }  
            Byte value = randomByte();  
        }
        List<Integer> expectedResult = new ArrayList<>(numItems);
        }
        SortOrder order = randomBoolean() ? SortOrder.ASCENDING : SortOrder.DESCENDING;  
 * software distributed under the License is distributed on an
    }
 * You may obtain a copy of the License at  
    public void testSortDoubles() throws Exception {
            expectedResult.add(value);
    }
        String targetFieldName = fieldName + "foo";  
            Collections.reverse(expectedResult);
        SortOrder order = randomBoolean() ? SortOrder.ASCENDING : SortOrder.DESCENDING;  
        Collections.sort(expectedResult, Collections.reverseOrder());
        for (int j = 0; j < numItems; j++) {
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, SortOrder.ASCENDING, targetFieldName);
        assertEquals(ingestDocument.getFieldValue(fieldName, List.class), expectedResult);
            fieldValue.add(value);
    }
    public void testSortIntegers() throws Exception {
        int numItems = randomIntBetween(1, 10);  
 * KIND, either express or implied.  See the License for the
        assertEquals(ingestDocument.getFieldValue(targetFieldName, List.class), expectedResult);
        } catch (IllegalArgumentException e) {  
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, SortOrder.DESCENDING, targetFieldName);
        int numItems = randomIntBetween(1, 10);
    }  
        SortOrder order = randomBoolean() ? SortOrder.ASCENDING : SortOrder.DESCENDING;  
    public void testSortBytes() throws Exception {  
            assertThat(e.getMessage(), containsString("not present as part of path [" + fieldName + "]"));
        if (order.equals(SortOrder.DESCENDING)) {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", null));
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);  
        Collections.sort(expectedResult);
    public void testSortMixedStrings() throws Exception {
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, order, fieldName);  
 * the Apache License, Version 2.0 (the "License"); you may
        }
        for (int j = 0; j < numItems; j++) {  
        int numItems = randomIntBetween(1, 10);
            expectedResult.add(value);
 *    http://www.apache.org/licenses/LICENSE-2.0
            Collections.reverse(expectedResult);
 */
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
 * The OpenSearch Contributors require contributions made to  
        SortOrder order = randomBoolean() ? SortOrder.ASCENDING : SortOrder.DESCENDING;
    public void testSortNonExistingField() throws Exception {  
        List<Float> expectedResult = new ArrayList<>(numItems);
        SortOrder order = randomBoolean() ? SortOrder.ASCENDING : SortOrder.DESCENDING;
        String fieldName = RandomDocumentPicks.randomFieldName(random());
import java.util.Arrays;
        assertEquals(ingestDocument.getFieldValue(fieldName, List.class), expectedResult);
        assertEquals(ingestDocument.getFieldValue(fieldName, List.class), expectedResult);
import static org.hamcrest.Matchers.equalTo;
        SortOrder order = randomBoolean() ? SortOrder.ASCENDING : SortOrder.DESCENDING;
        }  
            Double value = randomDoubleBetween(0.0, 100.0, true);
        Collections.sort(expectedResult);  
        List<Integer> fieldValue = new ArrayList<>(expectedResult.length);  
        for (int j = 0; j < numItems; j++) {
        SortOrder order = randomBoolean() ? SortOrder.ASCENDING : SortOrder.DESCENDING;  
        List<Byte> fieldValue = new ArrayList<>(numItems);  
        processor.execute(ingestDocument);
            Short value = randomShort();  
        for (int j = 0; j < numItems; j++) {  
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        } catch (IllegalArgumentException e) {
            expectedResult.add(value);
    public void testSortFloats() throws Exception {
        int numItems = randomIntBetween(1, 10);
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, order, fieldName);
        }  
    }
            Collections.reverse(expectedResult);
        } catch (IllegalArgumentException e) {
    }
import java.util.List;
        assertEquals(ingestDocument.getFieldValue(fieldName, List.class), expectedResult);
 *
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, order, targetFieldName);
        String targetFieldName = fieldName + "foo";
    }  
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
        }  
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
    }  
    public void testSortShorts() throws Exception {  
 * compatible open source license.
            fieldValue.add(value);  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.emptyMap());
        int numItems = randomIntBetween(1, 10);
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, order, fieldName);
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
        int numItems = randomIntBetween(1, 10);  
            String value = randomAlphaOfLengthBetween(1, 10);  
import java.util.ArrayList;
        Collections.sort(expectedResult);  
            assertThat(e.getMessage(), equalTo("field [" + fieldName + "] of type [java.lang.String] cannot be cast to [java.util.List]"));
        }
            expectedResult.add(value);
        fieldValue.addAll(Arrays.asList(expectedResult).subList(0, expectedResult.length));
        if (order.equals(SortOrder.DESCENDING)) {  
        }
            expectedResult.add(value);  
        try {
        Collections.sort(expectedResult);  
import org.opensearch.ingest.common.SortProcessor.SortOrder;
        Collections.sort(expectedResult);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.emptyMap());  
/*
        assertEquals(ingestDocument.getFieldValue(fieldName, List.class), expectedResult);
 *
    public void testSortNonListField() throws Exception {
        String value;  
        SortOrder order = randomBoolean() ? SortOrder.ASCENDING : SortOrder.DESCENDING;  
        for (int j = 0; j < numItems; j++) {
            processor.execute(ingestDocument);  
package org.opensearch.ingest.common;
        }  
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);  
            fieldValue.add(value);
        if (order.equals(SortOrder.DESCENDING)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Collections.sort(expectedResult);
            }  
            processor.execute(ingestDocument);  
    }  
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
            Boolean value = randomBoolean();
        List<String> expectedResult = new ArrayList<>(numItems);
        assertEquals(ingestDocument.getFieldValue(fieldName, List.class), expectedResult);
        if (order.equals(SortOrder.DESCENDING)) {  
        processor.execute(ingestDocument);
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, order, fieldName);  
        List<Integer> expectedResult = new ArrayList<>(fieldValue);  
        List<Boolean> fieldValue = new ArrayList<>(numItems);
            fieldValue.add(value);
        for (int j = 0; j < numItems; j++) {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        }
        assertEquals(ingestDocument.getFieldValue(fieldName, List.class), expectedResult);  
public class SortProcessorTests extends OpenSearchTestCase {
        for (int j = 0; j < numItems; j++) {
 * this work for additional information regarding copyright
        }
        List<Double> fieldValue = new ArrayList<>(numItems);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.emptyMap());
            } else {
        }  
        }  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, order, fieldName);
        List<String> fieldValue = new ArrayList<>(numItems);  
        assertEquals(ingestDocument.getFieldValue(fieldName, List.class), expectedResult);  
        processor.execute(ingestDocument);  
    public void testDescendingSortWithTargetField() throws Exception {
            fieldValue.add(value);
        String targetFieldName = fieldName + "foo";  
        processor.execute(ingestDocument);
 * Modifications Copyright OpenSearch Contributors. See
            fieldValue.add(value);  
        Collections.shuffle(fieldValue, random());
        if (order.equals(SortOrder.DESCENDING)) {
            expectedResult.add(value);
        List<Double> expectedResult = new ArrayList<>(numItems);  
        ingestDocument.setFieldValue(fieldName, randomAlphaOfLengthBetween(1, 10));
import static org.hamcrest.Matchers.containsString;
        }
            expectedResult.add(value);
        List<String> expectedResult = new ArrayList<>(numItems);
        List<String> fieldValue = new ArrayList<>(numItems);
        List<Integer> fieldValue = new ArrayList<>(numItems);
        assertEquals(ingestDocument.getFieldValue(targetFieldName, List.class), expectedResult);  
            fieldValue.add(value);  
        for (int j = 0; j < numItems; j++) {  
/*  
        int numItems = randomIntBetween(1, 10);
            String value = randomAlphaOfLengthBetween(1, 10);
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
        Integer[] expectedResult = new Integer[] { 1, 2, 3, 4, 5, 10, 20, 21, 22, 50, 100 };
import org.opensearch.ingest.IngestDocument;
 * not use this file except in compliance with the License.
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        SortOrder order = randomBoolean() ? SortOrder.ASCENDING : SortOrder.DESCENDING;  
                value = String.valueOf(randomIntBetween(0, 100));  
    public void testSortWithTargetFieldLeavesOriginalUntouched() throws Exception {  
        }
            assertThat(e.getMessage(), equalTo("field [field] is null, cannot sort."));
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);  
        List<String> fieldValue = new ArrayList<>(numItems);
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
        SortOrder order = randomBoolean() ? SortOrder.ASCENDING : SortOrder.DESCENDING;
            if (randomBoolean()) {
        for (int j = 0; j < numItems; j++) {
    public void testSortNullValue() throws Exception {  
        for (int j = 0; j < numItems; j++) {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, new ArrayList<>(fieldValue));
            fieldValue.add(value);
 * under the License.  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
            Collections.reverse(expectedResult);  
    }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        processor.execute(ingestDocument);
 * license agreements. See the NOTICE file distributed with
 *  
    public void testSortStrings() throws Exception {  
 */  
        }  
        Collections.sort(expectedResult);
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        SortOrder order = randomBoolean() ? SortOrder.ASCENDING : SortOrder.DESCENDING;  
        Collections.sort(expectedResult);
 * specific language governing permissions and limitations
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
            String value = randomAlphaOfLengthBetween(1, 10);
        List<Byte> expectedResult = new ArrayList<>(numItems);
        List<Integer> fieldValue = Arrays.asList(1, 5, 4);
            expectedResult.add(value);  
            expectedResult.add(value);  
        Processor processor = new SortProcessor(randomAlphaOfLength(10), null, fieldName, order, fieldName);
            expectedResult.add(value);
        if (order.equals(SortOrder.DESCENDING)) {
        if (order.equals(SortOrder.DESCENDING)) {
        try {
        assertThat(ingestDocument.getFieldValue(fieldName, List.class).toArray(), equalTo(expectedResult));
        int numItems = randomIntBetween(1, 10);  
                value = randomAlphaOfLengthBetween(1, 10);
