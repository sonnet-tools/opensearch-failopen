            fail("processor execute should have failed");  
    public void testAutoConvertMatchFloat() throws Exception {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        String expectedFieldValue;  
                int randomInt = randomInt();
    public void testConvertDouble() throws Exception {  
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, validIPString);  
        String booleanString = Boolean.toString(randomBoolean);  
        String randomString = Float.toString(randomFloat);  
        Object convertedValue = ingestDocument.getFieldValue("field", Object.class);
 * software distributed under the License is distributed on an
    public void testAutoConvertStringNotMatched() throws Exception {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, "field", "field", Type.AUTO, false);
        assertThat(ingestDocument.getFieldValue(fieldName, List.class), equalTo(expectedList));
            fail("processor execute should have failed");
        String fieldName = RandomDocumentPicks.randomFieldName(random());  
                    float randomFloat = randomFloat();
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, "field", "field", Type.AUTO, false);
        List<String> fieldValue = new ArrayList<>();
import org.opensearch.ingest.Processor;
        IngestDocument ingestDocument = new IngestDocument(new HashMap<>(), new HashMap<>());  
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, randomLong);  
    }  
 * You may obtain a copy of the License at  
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.LONG, false);
        processor.execute(ingestDocument);
            case 1:
                fieldValue = randomInt;  
        if (randomBoolean) {  
        String fieldName = RandomDocumentPicks.randomFieldName(random());  
            assertThat(e.getMessage(), containsString("not present as part of path [" + fieldName + "]"));
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.BOOLEAN, false);  
    public void testConvertFloat() throws Exception {
        String booleanString = Boolean.toString(randomBoolean);
 *
            if (randomBoolean) {  
    public void testConvertFloatList() throws Exception {
            fieldValue.add(Long.toString(randomLong));  
    public void testConvertIntError() throws Exception {
            fail("processor execute should have failed");
        String value = "string-" + randomAlphaOfLengthBetween(1, 10);
            assertThat(e.getMessage(), equalTo("unable to convert [" + value + "] to long"));
        assertThat(convertedValue, equalTo(randomFloat));
            Collections.singletonMap("field", booleanString)  
        }
            fail("processor execute should have failed");
            processor.execute(ingestDocument);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
        List<String> fieldValue = new ArrayList<>();
        try {
        int numItems = randomIntBetween(1, 10);
        for (int j = 0; j < numItems; j++) {
        assertThat(convertedValue, equalTo(randomLong));
                    randomValueString = Float.toString(randomFloat);  
        String targetField = fieldName + randomAlphaOfLength(5);  
                break;  
        }
        processor.execute(ingestDocument);
            fieldValue = randomFrom("on", "off", "yes", "no", "0", "1");
        List<String> expectedList = new ArrayList<>();
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        String value = "string-" + randomAlphaOfLengthBetween(1, 10);  
        processor.execute(ingestDocument);
                float randomFloat = randomFloat();
    }
            fieldValue.add(Float.toString(randomFloat));
        } catch (IllegalArgumentException e) {  
 * this file be licensed under the Apache-2.0 license or a
        Object fieldValue;
    public void testConvertDoubleError() throws Exception {
            String randomValueString;
        Type type = randomFrom(Type.values());  
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", null));
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, type, true);
        } else {  
            expectedList.add(randomValueString);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
    public void testConvertIntLeadingZero() throws Exception {
        try {  
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, longString);  
        try {  
        float randomFloat = randomFloat();
import java.util.Collections;
                    int randomInt = randomInt();  
    public void testConvertDoubleList() throws Exception {  
    }  
        assertIngestDocument(originalIngestDocument, ingestDocument);  
        List<Long> expectedList = new ArrayList<>();  
        ingestDocument.setFieldValue(fieldName, value);  
    }
        switch (randomIntBetween(0, 2)) {
                default:
        }  
        }
        }
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
        assertThat(ingestDocument.getFieldValue(fieldName, Float.class), equalTo(randomFloat));
 */
        }  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", value));  
        Object convertedValue = ingestDocument.getFieldValue("field", Object.class);  
        String longString = randomLong < 0 ? "-0x" + Long.toHexString(-randomLong) : "0x" + Long.toHexString(randomLong);
    }
        assertThat(ingestDocument.getFieldValue(fieldName, Integer.class), equalTo(randomInt));
        } catch (IllegalArgumentException e) {
        float randomFloat = Float.parseFloat(randomString);
        } catch (IllegalArgumentException e) {  
import java.util.List;  
        assertThat(ingestDocument.getFieldValue(fieldName, List.class), equalTo(expectedList));
            processor.execute(ingestDocument);
            case 1:
        assertThat(ingestDocument.getFieldValue(fieldName, Integer.class), equalTo(10));
    }  
        }
        for (int j = 0; j < numItems; j++) {
        }  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
 */  
 * this work for additional information regarding copyright
        }
        String randomString = Double.toString(randomDouble);  
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, targetField, Type.INTEGER, false);
        } else {  
        processor.execute(ingestDocument);
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.INTEGER, false);
    public void testConvertBooleanError() throws Exception {  
            Object randomValue;  
 * under the License.  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", randomValue));  
    }
    }
                randomValue = randomInt;  
        processor.execute(ingestDocument);
    public void testConvertNonExistingFieldWithIgnoreMissing() throws Exception {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
            expectedList.add(randomDouble);
        assertThat(ingestDocument.getFieldValue(fieldName, List.class), equalTo(expectedList));  
        assertThat(ingestDocument.getFieldValue(fieldName, Long.class), equalTo(10L));
            fail("processor execute should have failed");
                booleanString = booleanString.toUpperCase(Locale.ROOT);
    }
        boolean randomBoolean = randomBoolean();
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        assertIngestDocument(originalIngestDocument, ingestDocument);  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", randomString));
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.IP, false);
        String value = "string-" + randomAlphaOfLengthBetween(1, 10);
        processor.execute(ingestDocument);
        assertThat(convertedValue, equalTo(randomFloat));
                    randomValueString = Integer.toString(randomInt);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
    public void testConvertIntList() throws Exception {
            case 0:
public class ConvertProcessorTests extends OpenSearchTestCase {
 *
            fail("processor execute should have failed");
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 *  
    }  
    public void testAutoConvertMatchBoolean() throws Exception {
        String invalidIPString = randomAlphaOfLength(10);  
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
                    break;  
        Map<String, Double> expectedResult = new HashMap<>();
        }
        Object convertedValue = ingestDocument.getFieldValue("field", Object.class);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", null));  
import static org.hamcrest.Matchers.not;
        processor.execute(ingestDocument);
        processor.execute(ingestDocument);  
        List<Integer> expectedList = new ArrayList<>();
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
    }  
    public void testConvertLongLeadingZero() throws Exception {  
    public void testAutoConvertDoubleNotMatched() throws Exception {
import static org.hamcrest.Matchers.equalTo;
 * specific language governing permissions and limitations
        assertThat(ingestDocument.getFieldValue(fieldName, List.class), equalTo(expectedList));  
                    randomValueString = Double.toString(randomDouble);
                    boolean randomBoolean = randomBoolean();
 * The OpenSearch Contributors require contributions made to  
        List<Double> expectedList = new ArrayList<>();
        }
        processor.execute(ingestDocument);
                    randomValue = randomDouble;
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, "field", "field", Type.AUTO, false);
        assertThat(ingestDocument.getFieldValue(fieldName, Long.class), equalTo(randomLong));
        assertThat(ingestDocument.getFieldValue(fieldName, String.class), equalTo(String.valueOf(randomInt)));  
    public void testConvertStringList() throws Exception {  
        Object convertedValue = ingestDocument.getFieldValue("field", Object.class);  
            processor.execute(ingestDocument);
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.INTEGER, false);
        processor.execute(ingestDocument);
            // verify that only proper boolean values are supported and we are strict about it
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.INTEGER, false);  
        assertThat(convertedValue, equalTo(randomInt));  
        List<Float> expectedList = new ArrayList<>();
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, "field", "field", Type.AUTO, false);  
package org.opensearch.ingest.common;
            int randomInt = randomInt();
        ingestDocument.setFieldValue(fieldName, fieldValue);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.FLOAT, false);
 */  
        ingestDocument.setFieldValue(fieldName, value);
                break;
        Type type = randomFrom(Type.values());  
                    randomValueString = Long.toString(randomLong);  
        float randomFloat = randomFloat();
                case 0:  
import java.util.Locale;
        } catch (IllegalArgumentException e) {  
        Map<String, Float> expectedResult = new HashMap<>();  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
import static org.hamcrest.Matchers.containsString;  
    }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        processor.execute(ingestDocument);  
    }
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, type, false);
        List<Object> fieldValue = new ArrayList<>();  
        processor.execute(ingestDocument);  
        String fieldName = RandomDocumentPicks.randomFieldName(random());
            default:
            boolean randomBoolean = randomBoolean();
            processorWithInvalidIP.execute(ingestDocument);
        expectedResult.put(fieldName, randomDouble);
        }
import static org.opensearch.ingest.common.ConvertProcessor.Type;
 * Unless required by applicable law or agreed to in writing,
    public void testConvertLongHexError() {
            processor.execute(ingestDocument);
}
        if (randomBoolean()) {
    public void testConvertLongHex() throws Exception {
    public void testTargetField() throws Exception {
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        long randomLong = randomLong();
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
        String fieldValue;  
    public void testConvertLong() throws Exception {
        long randomLong = randomLong();
                case 4:
    public void testConvertString() throws Exception {  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(
                randomValue = randomFloat;
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        assertThat(convertedValue, sameInstance(randomValue));
                float randomFloat = randomFloat();  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
    public void testConvertNullFieldWithIgnoreMissing() throws Exception {  
            fieldValue.add(randomValue);
        }
                fieldValue = randomBoolean;
            double randomDouble = randomDouble();  
    }  
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, booleanString);  
                expectedFieldValue = Boolean.toString(randomBoolean);  
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.STRING, false);
                    break;
 * not use this file except in compliance with the License.
        String randomString = Long.toString(randomLong);
            }  
                expectedFieldValue = Integer.toString(randomInt);
            expectedList.add(randomBoolean);
                    randomValueString = Boolean.toString(randomBoolean);
        ingestDocument.setFieldValue(fieldName, value);
            validIPString = "1.2.3.4";
            assertThat(e.getMessage(), equalTo("[" + invalidIPString + "] is not a valid ipv4/ipv6 address"));
    public void testConvertNonExistingField() throws Exception {
        try {
        String value = "string-" + randomAlphaOfLengthBetween(1, 10);
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.LONG, false);  
                    throw new UnsupportedOperationException();
        for (int j = 0; j < numItems; j++) {  
            default:  
        List<String> fieldValue = new ArrayList<>();
        assertThat(ingestDocument.getFieldValue(fieldName, String.class), equalTo(validIPString));
        processor.execute(ingestDocument);  
        processor.execute(ingestDocument);
    public void testConvertBooleanList() throws Exception {
import java.util.Map;
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
                expectedFieldValue = Float.toString(randomFloat);
        int randomInt = randomInt();  
    }
        Type type = randomFrom(Type.values());
    }
    public void testConvertBoolean() throws Exception {
        assertThat(ingestDocument.getFieldValue(fieldName, Integer.class), equalTo(randomInt));
        assertThat(ingestDocument.getFieldValue(fieldName, Double.class), equalTo(randomDouble));  
        int randomInt = randomInt();
        assertThat(ingestDocument.getFieldValue(fieldName, List.class), equalTo(expectedList));
    }
                    randomValue = randomBoolean;  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());  
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.INTEGER, false);
                fieldValue = randomFloat;
/*  
                randomValue = randomBoolean;
        String value = "0xnotanumber";
        processor.execute(ingestDocument);
            fail("processor execute should have failed");  
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.STRING, false);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, invalidIPString);
    }
            assertThat(e.getMessage(), equalTo("[" + fieldValue + "] is not a boolean value, cannot convert to boolean"));
                    double randomDouble = randomDouble();  
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, "010");
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, "field", "field", type, true);
        Object convertedValue = ingestDocument.getFieldValue("field", Object.class);
        processor.execute(ingestDocument);
        if (randomBoolean()) {
        expectedResult.put(fieldName, randomFloat);  
                break;
        processor.execute(ingestDocument);  
        processor.execute(ingestDocument);
        boolean randomBoolean = randomBoolean();
            }
    }  
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.LONG, false);  
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.LONG, false);
        double randomDouble = randomDouble();  
/*  
            validIPString = "::1";
import org.opensearch.ingest.IngestDocument;
                case 3:  
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, randomDouble);
    }
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.FLOAT, false);
    public void testConvertNullField() throws Exception {
import java.util.ArrayList;  
    }  
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, randomFloat);
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, "field", "field", Type.AUTO, false);
    }  
        String randomString = Integer.toString(randomInt);
    }  
    public void testConvertLongList() throws Exception {
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
    }
        Object convertedValue = ingestDocument.getFieldValue("field", Object.class);  
        for (int j = 0; j < numItems; j++) {  
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.LONG, false);  
            float randomFloat = randomFloat();
                boolean randomBoolean = randomBoolean();  
import static org.hamcrest.Matchers.sameInstance;  
        assertThat(ingestDocument.getFieldValue(targetField, Integer.class), equalTo(randomInt));
    public void testAutoConvertMatchInteger() throws Exception {
import java.util.HashMap;
        processor.execute(ingestDocument);
        int randomInt = randomInt();  
            assertThat(e.getMessage(), equalTo("unable to convert [" + value + "] to integer"));
        processor.execute(ingestDocument);  
        Processor processorWithInvalidIP = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.IP, false);
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
        assertThat(convertedValue, equalTo(randomBoolean));
        processor.execute(ingestDocument);  
    }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, intString);
                break;
        } catch (IllegalArgumentException e) {
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
        assertThat(e.getMessage(), equalTo("unable to convert [" + value + "] to long"));
        processor.execute(ingestDocument);
                break;
            fail("processor execute should have failed");
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.DOUBLE, false);
        processor.execute(ingestDocument);  
        switch (randomIntBetween(0, 2)) {
            processor.execute(ingestDocument);
                case 2:
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, "field", "field", type, false);
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, "010");
    public void testConvertIntHex() throws Exception {
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, value);
    }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, randomInt);
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.ingest.RandomDocumentPicks;  
            case 0:  
        ingestDocument.setFieldValue(fieldName, value);  
        }
        List<Boolean> expectedList = new ArrayList<>();
import org.opensearch.test.OpenSearchTestCase;
                break;  
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, value);
            expectedList.add(randomInt);  
    public void testConvertIntHexError() {
    }  
            expectedList.add(randomLong);
 * the Apache License, Version 2.0 (the "License"); you may
                throw new UnsupportedOperationException();  
        String value = "notAnIntFloatOrBool";
        int randomInt = randomInt();  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
            booleanString = booleanString.toUpperCase(Locale.ROOT);
        assertThat(convertedValue, sameInstance(value));
        String intString = randomInt < 0 ? "-0x" + Integer.toHexString(-randomInt) : "0x" + Integer.toHexString(randomInt);
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, "field", "field", Type.AUTO, false);  
                    randomValue = randomLong;
            String booleanString = Boolean.toString(randomBoolean);
                throw new UnsupportedOperationException();
        }  
        }
            case 2:  
        try {
            processor.execute(ingestDocument);  
        String value = "0xnotanumber";  
        double randomDouble = randomDouble();
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
                case 1:
        Object randomValue;
        processor.execute(ingestDocument);
        processor.execute(ingestDocument);
        Map<String, Long> expectedResult = new HashMap<>();
                    break;
    public void testAutoConvertMatchLong() throws Exception {  
    public void testConvertLongError() throws Exception {  
    public void testAutoConvertNotString() throws Exception {  
                    break;  
        } catch (IllegalArgumentException e) {  
            switch (randomIntBetween(0, 2)) {
    }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
 * compatible open source license.
        int numItems = randomIntBetween(1, 10);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", randomString));
        expectedResult.put(fieldName, randomLong);
        } catch (IllegalArgumentException e) {  
        processor.execute(ingestDocument);  
        assertThat(e.getMessage(), equalTo("unable to convert [" + value + "] to integer"));
 * SPDX-License-Identifier: Apache-2.0
/*
                boolean randomBoolean = randomBoolean();
        Type type = randomFrom(Type.values());
        Object convertedValue = ingestDocument.getFieldValue("field", Object.class);
                    break;
        int numItems = randomIntBetween(1, 10);  
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, String.valueOf(randomInt));
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());  
            processor.execute(ingestDocument);
        try {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> processor.execute(ingestDocument));  
        try {  
        assertThat(ingestDocument.getFieldValue(fieldName, List.class), equalTo(expectedList));
        }  
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.DOUBLE, false);
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, "field", "field", Type.AUTO, false);
            assertThat(e.getMessage(), equalTo("unable to convert [" + value + "] to float"));
        String fieldName = RandomDocumentPicks.randomFieldName(random());
    public void testConvertIP() throws Exception {
        assertThat(ingestDocument.getFieldValue(fieldName, String.class), equalTo(expectedFieldValue));  
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);  
    }
    }  
    }
        } catch (Exception e) {
    }  
            assertThat(e.getMessage(), equalTo("unable to convert [" + value + "] to double"));  
        List<String> fieldValue = new ArrayList<>();
        }
        long randomLong = randomLong();
        int numItems = randomIntBetween(1, 10);
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.LONG, false);  
            fieldValue.add(Integer.toString(randomInt));
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.DOUBLE, false);
        try {  
    }
    public void testConvertInt() throws Exception {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", randomString));
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", randomString));  
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.INTEGER, false);
            assertThat(e.getMessage(), equalTo("Field [field] is null, cannot be converted to type [" + type + "]"));
            fieldValue.add(Double.toString(randomDouble));
            expectedList.add(randomFloat);  
        String validIPString;  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> processor.execute(ingestDocument));
            long randomLong = randomLong();
    }
            case 2:
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.FLOAT, false);  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        assertThat(ingestDocument.getFieldValue(fieldName, Boolean.class), equalTo(randomBoolean));
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.BOOLEAN, false);
        processor.execute(ingestDocument);
    }
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.BOOLEAN, false);
        );
        assertThat(ingestDocument.getFieldValue(fieldName, Long.class), equalTo(randomLong));  
        int numItems = randomIntBetween(1, 10);  
        for (int j = 0; j < numItems; j++) {
        Processor processor = new ConvertProcessor(randomAlphaOfLength(10), null, fieldName, fieldName, Type.INTEGER, false);  
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
                    randomValue = randomInt;
        assertThat(convertedValue, not(randomDouble));  
        }
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());  
    }
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);  
                    long randomLong = randomLong();
            random(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
                    randomValue = randomFloat;
        int numItems = randomIntBetween(1, 10);  
        List<String> fieldValue = new ArrayList<>();  
            fieldValue.add(booleanString);  
        for (int j = 0; j < numItems; j++) {  
    public void testConvertFloatError() throws Exception {
                int randomInt = randomInt();
            fieldValue = "string-" + randomAlphaOfLengthBetween(1, 10);
