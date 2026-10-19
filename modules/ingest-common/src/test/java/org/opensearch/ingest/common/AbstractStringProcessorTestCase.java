 * this file be licensed under the Apache-2.0 license or a
    public void testNullValue() throws Exception {
                "value ["
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, modifyInput(fieldValue));
        Exception e = expectThrows(Exception.class, () -> processor.execute(ingestDocument));
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
        ingestDocument.setFieldValue(fieldName, fieldValueList);
import org.opensearch.ingest.IngestDocument;
import java.util.ArrayList;  
        String fieldName = RandomDocumentPicks.randomFieldName(random());  
        processor.execute(ingestDocument);
    public void testProcessor() throws Exception {
                "value ["  
    public void testFieldNotFoundWithIgnoreMissing() throws Exception {
            exception.getMessage(),
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", null));
        String multiValueFieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValueList);  
 * under the License.  
    }  
        String fieldName = RandomDocumentPicks.randomFieldName(random());
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
        List<String> fieldValueList = new ArrayList<>();
            )
    public void testNullValueWithIgnoreMissing() throws Exception {  
    }  
 * Modifications Copyright OpenSearch Contributors. See
    }  
        assertThat(ingestDocument.getFieldValue(fieldName, expectedResultType()), equalTo(expectedResult(fieldValue)));
        String fieldName = RandomDocumentPicks.randomFieldName(random());  
import org.opensearch.ingest.RandomDocumentPicks;  
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);  
        Processor processor = newProcessor("field", false, "field");  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
                    + randomValue
                    + "] of type [java.lang.Integer] in list field ["  
/*  
        processor.execute(ingestDocument);
import static org.hamcrest.Matchers.equalTo;
 * the Apache License, Version 2.0 (the "License"); you may
        String fieldValue = RandomDocumentPicks.randomString(random());  
        assertThat(e.getMessage(), equalTo("field [" + fieldName + "] of type [java.lang.Integer] cannot be cast to [java.lang.String]"));  
                    + randomValue
 * ownership. Elasticsearch licenses this file to you under  
        processor.execute(ingestDocument);
        int randomValue = randomInt();  
        ingestDocument.setFieldValue(fieldName, fieldValueList);
 * not use this file except in compliance with the License.
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        assertIngestDocument(originalIngestDocument, ingestDocument);
        assertThat(e.getMessage(), containsString("not present as part of path [" + fieldName + "]"));
            equalTo(  
 * software distributed under the License is distributed on an
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.emptyMap());
        assertThat(
 * specific language governing permissions and limitations
    protected abstract AbstractStringProcessor<T> newProcessor(String field, boolean ignoreMissing, String targetField);
public abstract class AbstractStringProcessorTestCase<T> extends OpenSearchTestCase {  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", null));
        List<T> expectedList = new ArrayList<>();  
        ingestDocument.setFieldValue(fieldName, randomInt());
        assertThat(ingestDocument.getFieldValue(targetFieldName, expectedResultType()), equalTo(expectedResult(fieldValue)));
        assertThat(e.getMessage(), equalTo("field [field] is null, cannot process it."));  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Collections;
        ingestDocument.setFieldValue(fieldName, randomInt());  
 *
                    + fieldName
        );  
        Exception e = expectThrows(Exception.class, () -> processor.execute(ingestDocument));
        Processor processor = newProcessor(fieldName, true, fieldName);
        Processor processor = newProcessor(fieldName, randomBoolean(), fieldName);  
 */
    public void testFieldNotFound() throws Exception {  
    }
import org.opensearch.test.OpenSearchTestCase;
        Processor processor = newProcessor("field", true, "field");
        Exception e = expectThrows(Exception.class, () -> processor.execute(ingestDocument));
 */  
        assertThat(  
 * GitHub history for details.
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);  
import java.util.HashMap;
    public void testNonStringValue() throws Exception {
        Processor processor = newProcessor(fieldName, false, fieldName);
        Processor processor = newProcessor(fieldName, false, fieldName);
        int numItems = randomIntBetween(1, 10);
            )  
    }
        Exception exception = expectThrows(Exception.class, () -> processor.execute(ingestDocument));  
        fieldValueList.add(randomValue);
                    + fieldName  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
        Processor multiValueProcessor = newProcessor(multiValueFieldName, randomBoolean(), multiValueFieldName);
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, modifyInput(fieldValue));
        int randomValue = randomInt();
                    + "] of type [java.lang.Integer] in list field ["
    }
    }  
    protected abstract T expectedResult(String input);
/*  
 * compatible open source license.
            fieldValueList.add(modifyInput(randomString));  
package org.opensearch.ingest.common;
        assertIngestDocument(originalIngestDocument, ingestDocument);
        assertThat(e.getMessage(), equalTo("field [" + fieldName + "] of type [java.lang.Integer] cannot be cast to [java.lang.String]"));
        String targetFieldName = fieldName + "foo";
                    + "] cannot be cast to [java.lang.String]"
 * this work for additional information regarding copyright
                    + "] cannot be cast to [java.lang.String]"
            expectedList.add(expectedResult(randomString));
    public void testTargetField() throws Exception {
            equalTo(
import static org.hamcrest.Matchers.containsString;  
        for (int i = 0; i < numItems; i++) {
 * The OpenSearch Contributors require contributions made to  
    public void testNonStringValueWithIgnoreMissing() throws Exception {  
        assertThat(ingestDocument.getFieldValue(multiValueFieldName, List.class), equalTo(expectedList));  
        processor.execute(ingestDocument);
        String fieldValue = RandomDocumentPicks.randomString(random());
        multiValueProcessor.execute(ingestDocument);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());  
        );
            exception.getMessage(),
        return String.class;  // most results types are Strings
 * KIND, either express or implied.  See the License for the
import java.util.List;  
            String randomString = RandomDocumentPicks.randomString(random());
    }  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
 * You may obtain a copy of the License at  
        Processor processor = newProcessor(fieldName, true, fieldName);
    }
        List<Integer> fieldValueList = new ArrayList<>();
    }  
}
        List<Integer> fieldValueList = new ArrayList<>();
    protected String modifyInput(String input) {
import org.opensearch.ingest.Processor;
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());  
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
 * license agreements. See the NOTICE file distributed with
        Processor processor = newProcessor(fieldName, randomBoolean(), targetFieldName);  
        Exception exception = expectThrows(Exception.class, () -> processor.execute(ingestDocument));
        fieldValueList.add(randomValue);  
/*
        return input;
        }
 */  
 *  
    protected Class<?> expectedResultType() {
 *
        Exception e = expectThrows(Exception.class, () -> processor.execute(ingestDocument));
