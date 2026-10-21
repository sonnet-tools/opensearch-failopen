public abstract class AbstractStringProcessorTestCase<T> extends OpenSearchTestCase {
/*
        Processor processor = newProcessor("field", true, "field");
        processor.execute(ingestDocument);
        for (int i = 0; i < numItems; i++) {
                    + fieldName
        Processor processor = newProcessor("field", false, "field");
            exception.getMessage(),
        return input;
        ingestDocument.setFieldValue(fieldName, fieldValueList);
        String fieldName = RandomDocumentPicks.randomFieldName(random());
    protected String modifyInput(String input) {
 * not use this file except in compliance with the License.
import org.opensearch.test.OpenSearchTestCase;
        assertThat(
}
    public void testFieldNotFound() throws Exception {
 *
 */
                    + "] of type [java.lang.Integer] in list field ["
 * compatible open source license.
        String targetFieldName = fieldName + "foo";
                    + fieldName
        Exception e = expectThrows(Exception.class, () -> processor.execute(ingestDocument));
        ingestDocument.setFieldValue(fieldName, fieldValueList);
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", null));
/*
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
    public void testProcessor() throws Exception {
 * Modifications Copyright OpenSearch Contributors. See
                "value ["
        assertIngestDocument(originalIngestDocument, ingestDocument);
                    + randomValue
package org.opensearch.ingest.common;
        processor.execute(ingestDocument);
        Exception e = expectThrows(Exception.class, () -> processor.execute(ingestDocument));
import java.util.Collections;
        Processor processor = newProcessor(fieldName, false, fieldName);
        assertThat(
import java.util.List;
 * KIND, either express or implied.  See the License for the
/*
        String fieldName = RandomDocumentPicks.randomFieldName(random());
 * specific language governing permissions and limitations
        String multiValueFieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValueList);
import org.opensearch.ingest.Processor;
    }
 * SPDX-License-Identifier: Apache-2.0
            equalTo(
 */
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        Processor processor = newProcessor(fieldName, false, fieldName);
    public void testNullValue() throws Exception {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", null));
    public void testFieldNotFoundWithIgnoreMissing() throws Exception {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.ingest.RandomDocumentPicks;
 * ownership. Elasticsearch licenses this file to you under
import static org.hamcrest.Matchers.containsString;
        assertIngestDocument(originalIngestDocument, ingestDocument);
    public void testTargetField() throws Exception {
        ingestDocument.setFieldValue(fieldName, randomInt());
    }
 * Unless required by applicable law or agreed to in writing,
            expectedList.add(expectedResult(randomString));
        String fieldName = RandomDocumentPicks.randomFieldName(random());
    }
        ingestDocument.setFieldValue(fieldName, randomInt());
        }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
    public void testNonStringValueWithIgnoreMissing() throws Exception {
        String fieldValue = RandomDocumentPicks.randomString(random());
    public void testNonStringValue() throws Exception {
    protected abstract AbstractStringProcessor<T> newProcessor(String field, boolean ignoreMissing, String targetField);
 * Licensed to Elasticsearch under one or more contributor
        int numItems = randomIntBetween(1, 10);
        Exception exception = expectThrows(Exception.class, () -> processor.execute(ingestDocument));
 *
        List<T> expectedList = new ArrayList<>();
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
        fieldValueList.add(randomValue);
        processor.execute(ingestDocument);
import org.opensearch.ingest.IngestDocument;
        int randomValue = randomInt();
            equalTo(
        assertThat(e.getMessage(), equalTo("field [" + fieldName + "] of type [java.lang.Integer] cannot be cast to [java.lang.String]"));
    }
        processor.execute(ingestDocument);
        Exception e = expectThrows(Exception.class, () -> processor.execute(ingestDocument));
import java.util.HashMap;
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, modifyInput(fieldValue));
        Exception exception = expectThrows(Exception.class, () -> processor.execute(ingestDocument));
        Exception e = expectThrows(Exception.class, () -> processor.execute(ingestDocument));
 * this work for additional information regarding copyright
    }
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
                    + "] cannot be cast to [java.lang.String]"
            )
        assertThat(ingestDocument.getFieldValue(multiValueFieldName, List.class), equalTo(expectedList));
 * You may obtain a copy of the License at
    protected Class<?> expectedResultType() {
        fieldValueList.add(randomValue);
            exception.getMessage(),
        assertThat(ingestDocument.getFieldValue(targetFieldName, expectedResultType()), equalTo(expectedResult(fieldValue)));
            String randomString = RandomDocumentPicks.randomString(random());
 * under the License.
    protected abstract T expectedResult(String input);
    }
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
 * The OpenSearch Contributors require contributions made to
                    + "] cannot be cast to [java.lang.String]"
        );
    }
        Processor processor = newProcessor(fieldName, true, fieldName);
        assertThat(e.getMessage(), equalTo("field [field] is null, cannot process it."));
        Processor processor = newProcessor(fieldName, randomBoolean(), targetFieldName);
        return String.class;  // most results types are Strings
        String fieldName = RandomDocumentPicks.randomFieldName(random());
                "value ["
 * this file be licensed under the Apache-2.0 license or a
        assertThat(ingestDocument.getFieldValue(fieldName, expectedResultType()), equalTo(expectedResult(fieldValue)));
        List<Integer> fieldValueList = new ArrayList<>();
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, modifyInput(fieldValue));
                    + randomValue
        assertThat(e.getMessage(), equalTo("field [" + fieldName + "] of type [java.lang.Integer] cannot be cast to [java.lang.String]"));
        multiValueProcessor.execute(ingestDocument);
        int randomValue = randomInt();
        );
        List<String> fieldValueList = new ArrayList<>();
        assertThat(e.getMessage(), containsString("not present as part of path [" + fieldName + "]"));
 */
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.emptyMap());
            fieldValueList.add(modifyInput(randomString));
import java.util.ArrayList;
        Processor processor = newProcessor(fieldName, true, fieldName);
        Processor multiValueProcessor = newProcessor(multiValueFieldName, randomBoolean(), multiValueFieldName);
 * GitHub history for details.
                    + "] of type [java.lang.Integer] in list field ["
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
import static org.hamcrest.Matchers.equalTo;
 *
        Processor processor = newProcessor(fieldName, randomBoolean(), fieldName);
            )
    public void testNullValueWithIgnoreMissing() throws Exception {
    }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
 * software distributed under the License is distributed on an
    }
        List<Integer> fieldValueList = new ArrayList<>();
 * license agreements. See the NOTICE file distributed with
        String fieldValue = RandomDocumentPicks.randomString(random());
