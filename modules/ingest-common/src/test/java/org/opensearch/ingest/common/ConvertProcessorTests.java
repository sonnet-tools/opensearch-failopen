        assertThat(ingestDocument.getFieldValue(fieldName, Boolean.class), equalTo(randomBoolean));
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        processor.execute(ingestDocument);
    }
        float randomFloat = Float.parseFloat(randomString);
    }
        Object convertedValue = ingestDocument.getFieldValue("field", Object.class);
            processor.execute(ingestDocument);
        processor.execute(ingestDocument);
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", randomString));
            validIPString = "1.2.3.4";
        expectedResult.put(fieldName, randomLong);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", null));
    public void testAutoConvertMatchInteger() throws Exception {
                int randomInt = randomInt();
    }
        assertThat(ingestDocument.getFieldValue(fieldName, Integer.class), equalTo(randomInt));
                    boolean randomBoolean = randomBoolean();
                    double randomDouble = randomDouble();
    }
        }
                case 1:
            if (randomBoolean) {
            String booleanString = Boolean.toString(randomBoolean);
            boolean randomBoolean = randomBoolean();
        for (int j = 0; j < numItems; j++) {
        String value = "string-" + randomAlphaOfLengthBetween(1, 10);
 * KIND, either express or implied.  See the License for the
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
    }
            fieldValue.add(randomValue);
        Type type = randomFrom(Type.values());
    public void testConvertIntHex() throws Exception {
            fail("processor execute should have failed");
    }
        List<Object> fieldValue = new ArrayList<>();
        }
    }
import java.util.Collections;
 * GitHub history for details.
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        }
            case 2:
public class ConvertProcessorTests extends OpenSearchTestCase {
        assertThat(ingestDocument.getFieldValue(fieldName, List.class), equalTo(expectedList));
                    randomValueString = Double.toString(randomDouble);
    }
        assertIngestDocument(originalIngestDocument, ingestDocument);
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.LONG, false);
    public void testConvertIntError() throws Exception {
            case 1:
        assertThat(ingestDocument.getFieldValue(fieldName, List.class), equalTo(expectedList));
    public void testConvertDoubleList() throws Exception {
            case 0:
            Object randomValue;
                throw new UnsupportedOperationException();
        processor.execute(ingestDocument);
                randomValue = randomInt;
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
            processorWithInvalidIP.execute(ingestDocument);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, randomDouble);
        processor.execute(ingestDocument);
import static org.hamcrest.Matchers.not;
        processor.execute(ingestDocument);
 * ownership. Elasticsearch licenses this file to you under
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.LONG, false);
    }
/*
        assertThat(ingestDocument.getFieldValue(fieldName, Float.class), equalTo(randomFloat));
    }
        } catch (Exception e) {
            processor.execute(ingestDocument);
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
        try {
            fail("processor execute should have failed");
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        int numItems = randomIntBetween(1, 10);
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.BOOLEAN, false);
/*
        Processor processorWithInvalidIP = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.IP, false);
        List<Integer> expectedList = new ArrayList<>();
        Type type = randomFrom(Type.values());
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, randomFloat);
        assertThat(convertedValue, sameInstance(value));
        expectedResult.put(fieldName, randomDouble);
        String fieldName = RandomDocumentPicks.randomFieldName(random());
    }
        Object convertedValue = ingestDocument.getFieldValue("field", Object.class);
    public void testConvertBoolean() throws Exception {
 * software distributed under the License is distributed on an
        processor.execute(ingestDocument);
        switch (randomIntBetween(0, 2)) {
            validIPString = "::1";
        }
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.DOUBLE, false);
        int numItems = randomIntBetween(1, 10);
                case 2:
            processor.execute(ingestDocument);
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.FLOAT, false);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        assertThat(e.getMessage(), equalTo("unable to convert [" + value + "] to integer"));
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.LONG, false);
        List<String> fieldValue = new ArrayList<>();
import java.util.Locale;
        processor.execute(ingestDocument);
            }
        }
 *
    public void testConvertIntHexError() {
            fieldValue.add(Float.toString(randomFloat));
        assertThat(convertedValue, equalTo(randomBoolean));
        List<String> fieldValue = new ArrayList<>();
    public void testConvertDoubleError() throws Exception {
        long randomLong = randomLong();
import static org.hamcrest.Matchers.containsString;
    public void testAutoConvertMatchBoolean() throws Exception {
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
            default:
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, "field", "field", Type.AUTO, false);
 * the Apache License, Version 2.0 (the "License"); you may
        String booleanString = Boolean.toString(randomBoolean);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
    public void testConvertLong() throws Exception {
        String randomString = Float.toString(randomFloat);
        processor.execute(ingestDocument);
 *
            case 2:
        Object convertedValue = ingestDocument.getFieldValue("field", Object.class);
                    randomValueString = Boolean.toString(randomBoolean);
        for (int j = 0; j < numItems; j++) {
            fieldValue.add(Integer.toString(randomInt));
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
    }
        } catch (IllegalArgumentException e) {
        float randomFloat = randomFloat();
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, validIPString);
/*
        Object fieldValue;
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
    public void testConvertFloat() throws Exception {
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.INTEGER, false);
import static org.hamcrest.Matchers.equalTo;
import java.util.Map;
        String longString = randomLong < 0 ? "-0x" + Long.toHexString(-randomLong) : "0x" + Long.toHexString(randomLong);
            default:
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        ingestDocument.setFieldValue(fieldName, fieldValue);
        assertThat(convertedValue, equalTo(randomInt));
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, targetField, Type.INTEGER, false);
        int numItems = randomIntBetween(1, 10);
        List<String> fieldValue = new ArrayList<>();
        processor.execute(ingestDocument);
 * You may obtain a copy of the License at
            assertThat(e.getMessage(), containsString("not present as part of path [" + fieldName + "]"));
        assertThat(ingestDocument.getFieldValue(fieldName, List.class), equalTo(expectedList));
            processor.execute(ingestDocument);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.LONG, false);
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.DOUBLE, false);
        IngestDocument ingestDocument = new IngestDocument(new HashMap<>(), new HashMap<>());
            float randomFloat = randomFloat();
        try {
    }
        for (int j = 0; j < numItems; j++) {
            expectedList.add(randomLong);
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        int numItems = randomIntBetween(1, 10);
        ingestDocument.setFieldValue(fieldName, value);
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.FLOAT, false);
            assertThat(e.getMessage(), equalTo("[" + fieldValue + "] is not a boolean value, cannot convert to boolean"));
    }
    public void testConvertDouble() throws Exception {
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
                booleanString = booleanString.toUpperCase(Locale.ROOT);
            switch (randomIntBetween(0, 2)) {
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, "field", "field", Type.AUTO, false);
 */
                fieldValue = randomInt;
            expectedList.add(randomDouble);
    }
        String value = "string-" + randomAlphaOfLengthBetween(1, 10);
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, type, true);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        assertThat(ingestDocument.getFieldValue(fieldName, String.class), equalTo(String.valueOf(randomInt)));
        int numItems = randomIntBetween(1, 10);
        try {
        assertThat(ingestDocument.getFieldValue(fieldName, Long.class), equalTo(10L));
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", value));
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", randomString));
        if (randomBoolean) {
        List<Long> expectedList = new ArrayList<>();
            fail("processor execute should have failed");
        List<String> expectedList = new ArrayList<>();
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        } catch (IllegalArgumentException e) {
        processor.execute(ingestDocument);
import org.opensearch.test.OpenSearchTestCase;
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        Object convertedValue = ingestDocument.getFieldValue("field", Object.class);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
                randomValue = randomFloat;
        }
                default:
                break;
    public void testConvertFloatError() throws Exception {
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.BOOLEAN, false);
            random(),
        processor.execute(ingestDocument);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(
        boolean randomBoolean = randomBoolean();
            processor.execute(ingestDocument);
 * The OpenSearch Contributors require contributions made to
        processor.execute(ingestDocument);
    public void testConvertLongHexError() {
                boolean randomBoolean = randomBoolean();
    }
                case 4:
            String randomValueString;
        processor.execute(ingestDocument);
            expectedList.add(randomInt);
    public void testAutoConvertStringNotMatched() throws Exception {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        assertThat(ingestDocument.getFieldValue(fieldName, Long.class), equalTo(randomLong));
        } catch (IllegalArgumentException e) {
        processor.execute(ingestDocument);
                    int randomInt = randomInt();
                    long randomLong = randomLong();
        int randomInt = randomInt();
        String fieldName = RandomDocumentPicks.randomFieldName(random());
            processor.execute(ingestDocument);
        );
            case 0:
 * Unless required by applicable law or agreed to in writing,
        try {
 * compatible open source license.
        }
        String randomString = Integer.toString(randomInt);
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, "field", "field", Type.AUTO, false);
        }
        try {
package org.opensearch.ingest.common;
        }
                    throw new UnsupportedOperationException();
        switch (randomIntBetween(0, 2)) {
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.INTEGER, false);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
    }
                case 0:
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        } catch (IllegalArgumentException e) {
    }
            fieldValue = randomFrom("on", "off", "yes", "no", "0", "1");
        String booleanString = Boolean.toString(randomBoolean);
        processor.execute(ingestDocument);
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, "field", "field", type, true);
                expectedFieldValue = Float.toString(randomFloat);
        assertThat(ingestDocument.getFieldValue(fieldName, Integer.class), equalTo(10));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> processor.execute(ingestDocument));
    }
    public void testAutoConvertMatchFloat() throws Exception {
        int randomInt = randomInt();
        long randomLong = randomLong();
        ingestDocument.setFieldValue(fieldName, value);
}
        } catch (IllegalArgumentException e) {
    public void testConvertNullFieldWithIgnoreMissing() throws Exception {
        boolean randomBoolean = randomBoolean();
    }
        Map<String, Float> expectedResult = new HashMap<>();
    public void testConvertInt() throws Exception {
    }
    public void testConvertBooleanList() throws Exception {
                    randomValue = randomDouble;
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", null));
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.IP, false);
        String value = "0xnotanumber";
            fail("processor execute should have failed");
        assertThat(ingestDocument.getFieldValue(fieldName, List.class), equalTo(expectedList));
    }
        ingestDocument.setFieldValue(fieldName, value);
            expectedList.add(randomFloat);
    }
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.LONG, false);
        }
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.INTEGER, false);
    }
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
import org.opensearch.ingest.Processor;
        assertThat(ingestDocument.getFieldValue(fieldName, String.class), equalTo(expectedFieldValue));
        ingestDocument.setFieldValue(fieldName, value);
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, "field", "field", type, false);
    public void testConvertLongError() throws Exception {
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, intString);
                    randomValue = randomFloat;
 * this work for additional information regarding copyright
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.BOOLEAN, false);
    public void testTargetField() throws Exception {
        String intString = randomInt < 0 ? "-0x" + Integer.toHexString(-randomInt) : "0x" + Integer.toHexString(randomInt);
                    randomValueString = Float.toString(randomFloat);
                    randomValueString = Long.toString(randomLong);
        String value = "string-" + randomAlphaOfLengthBetween(1, 10);
        assertThat(ingestDocument.getFieldValue(fieldName, List.class), equalTo(expectedList));
                randomValue = randomBoolean;
        assertThat(ingestDocument.getFieldValue(fieldName, Integer.class), equalTo(randomInt));
        }
                expectedFieldValue = Integer.toString(randomInt);
                break;
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
            assertThat(e.getMessage(), equalTo("unable to convert [" + value + "] to long"));
                fieldValue = randomBoolean;
                    randomValue = randomLong;
            expectedList.add(randomBoolean);
        String invalidIPString = randomAlphaOfLength(10);
        } else {
                    break;
            fieldValue.add(booleanString);
        List<Double> expectedList = new ArrayList<>();
        for (int j = 0; j < numItems; j++) {
        assertThat(convertedValue, equalTo(randomFloat));
        }
        Object convertedValue = ingestDocument.getFieldValue("field", Object.class);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.STRING, false);
        int numItems = randomIntBetween(1, 10);
        int randomInt = randomInt();
    public void testAutoConvertNotString() throws Exception {
    }
 * Licensed to Elasticsearch under one or more contributor
        fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, invalidIPString);
        try {
            // verify that only proper boolean values are supported and we are strict about it
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.INTEGER, false);
            assertThat(e.getMessage(), equalTo("Field [field] is null, cannot be converted to type [" + type + "]"));
        Object randomValue;
                float randomFloat = randomFloat();
                fieldValue = randomFloat;
        Type type = randomFrom(Type.values());
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", randomString));
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Long> expectedResult = new HashMap<>();
        String fieldName = RandomDocumentPicks.randomFieldName(random());
 */
        assertThat(e.getMessage(), equalTo("unable to convert [" + value + "] to long"));
        assertThat(convertedValue, not(randomDouble));
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.LONG, false);
                throw new UnsupportedOperationException();
        processor.execute(ingestDocument);
        long randomLong = randomLong();
                    break;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> processor.execute(ingestDocument));
        String value = "string-" + randomAlphaOfLengthBetween(1, 10);
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.DOUBLE, false);
    public void testConvertString() throws Exception {
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.FLOAT, false);
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, "field", "field", Type.AUTO, false);
        processor.execute(ingestDocument);
    public void testConvertNonExistingFieldWithIgnoreMissing() throws Exception {
        expectedResult.put(fieldName, randomFloat);
            }
        processor.execute(ingestDocument);
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.INTEGER, false);
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.STRING, false);
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, "010");
            Collections.singletonMap("field", booleanString)
import java.util.List;
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, "field", "field", Type.AUTO, false);
        for (int j = 0; j < numItems; j++) {
        double randomDouble = randomDouble();
import org.opensearch.ingest.IngestDocument;
        }
    public void testConvertLongList() throws Exception {
        assertThat(convertedValue, sameInstance(randomValue));
        processor.execute(ingestDocument);
            fieldValue.add(Double.toString(randomDouble));
            booleanString = booleanString.toUpperCase(Locale.ROOT);
                boolean randomBoolean = randomBoolean();
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        for (int j = 0; j < numItems; j++) {
            fieldValue.add(Long.toString(randomLong));
                    randomValueString = Integer.toString(randomInt);
        Type type = randomFrom(Type.values());
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, "010");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * specific language governing permissions and limitations
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", randomString));
        }
    }
                    randomValue = randomInt;
        List<String> fieldValue = new ArrayList<>();
            long randomLong = randomLong();
            expectedList.add(randomValueString);
    public void testConvertStringList() throws Exception {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        processor.execute(ingestDocument);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        processor.execute(ingestDocument);
    }
        assertThat(ingestDocument.getFieldValue(fieldName, Long.class), equalTo(randomLong));
        List<String> fieldValue = new ArrayList<>();
    public void testAutoConvertMatchLong() throws Exception {
        processor.execute(ingestDocument);
    }
            case 1:
        } catch (IllegalArgumentException e) {
                break;
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        processor.execute(ingestDocument);
            fail("processor execute should have failed");
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        String fieldValue;
            processor.execute(ingestDocument);
            fail("processor execute should have failed");
        processor.execute(ingestDocument);
        }
 * Modifications Copyright OpenSearch Contributors. See
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
                    break;
        assertThat(ingestDocument.getFieldValue(fieldName, Double.class), equalTo(randomDouble));
            fail("processor execute should have failed");
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, "field", "field", Type.AUTO, false);
 *
                break;
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
            double randomDouble = randomDouble();
    public void testConvertFloatList() throws Exception {
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, type, false);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
            int randomInt = randomInt();
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, longString);
import java.util.HashMap;
    public void testConvertNonExistingField() throws Exception {
    public void testConvertBooleanError() throws Exception {
                float randomFloat = randomFloat();
 * license agreements. See the NOTICE file distributed with
        }
    public void testConvertLongHex() throws Exception {
        assertThat(convertedValue, equalTo(randomFloat));
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.INTEGER, false);
 * SPDX-License-Identifier: Apache-2.0
            assertThat(e.getMessage(), equalTo("unable to convert [" + value + "] to double"));
        float randomFloat = randomFloat();
        }
            assertThat(e.getMessage(), equalTo("[" + invalidIPString + "] is not a valid ipv4/ipv6 address"));
                    break;
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, value);
    public void testAutoConvertDoubleNotMatched() throws Exception {
        processor.execute(ingestDocument);
    }
    public void testConvertLongLeadingZero() throws Exception {
        Object convertedValue = ingestDocument.getFieldValue("field", Object.class);
        assertIngestDocument(originalIngestDocument, ingestDocument);
    }
import org.opensearch.ingest.RandomDocumentPicks;
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, value);
        String targetField = fieldName + randomAlphaOfLength(5);
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, String.valueOf(randomInt));
        if (randomBoolean()) {
                expectedFieldValue = Boolean.toString(randomBoolean);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", randomValue));
                break;
        } else {
        double randomDouble = randomDouble();
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, randomInt);
            fail("processor execute should have failed");
            assertThat(e.getMessage(), equalTo("unable to convert [" + value + "] to integer"));
import static org.hamcrest.Matchers.sameInstance;
                    break;
        Map<String, Double> expectedResult = new HashMap<>();
        }
    }
            assertThat(e.getMessage(), equalTo("unable to convert [" + value + "] to float"));
                int randomInt = randomInt();
        }
                case 3:
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        String randomString = Long.toString(randomLong);
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, booleanString);
    public void testConvertIntList() throws Exception {
 * not use this file except in compliance with the License.
    }
        String expectedFieldValue;
        Object convertedValue = ingestDocument.getFieldValue("field", Object.class);
                break;
        assertThat(ingestDocument.getFieldValue(targetField, Integer.class), equalTo(randomInt));
    }
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, "field", "field", Type.AUTO, false);
    public void testConvertIP() throws Exception {
        String value = "notAnIntFloatOrBool";
        processor.execute(ingestDocument);
        String value = "0xnotanumber";
                    float randomFloat = randomFloat();
    }
    public void testConvertIntLeadingZero() throws Exception {
import static org.opensearch.ingest.common.ConvertProcessor.Type;
        assertThat(ingestDocument.getFieldValue(fieldName, String.class), equalTo(validIPString));
 * under the License.
        processor.execute(ingestDocument);
        List<Boolean> expectedList = new ArrayList<>();
import java.util.ArrayList;
 */
        assertThat(convertedValue, equalTo(randomLong));
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        } catch (IllegalArgumentException e) {
        assertThat(ingestDocument.getFieldValue(fieldName, List.class), equalTo(expectedList));
        try {
        String randomString = Double.toString(randomDouble);
        try {
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, randomLong);
        List<Float> expectedList = new ArrayList<>();
    public void testConvertNullField() throws Exception {
                    randomValue = randomBoolean;
        String validIPString;
            fieldValue = "string-" + randomAlphaOfLengthBetween(1, 10);
        int randomInt = randomInt();
        if (randomBoolean()) {
    }
