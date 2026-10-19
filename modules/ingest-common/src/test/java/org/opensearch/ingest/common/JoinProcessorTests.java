 * software distributed under the License is distributed on an
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("field", null));
        String separator = randomFrom(SEPARATORS);
        Processor processor = new JoinProcessor(randomAlphaOfLength(10), null, fieldName, "-", fieldName);
 */
        List<Integer> fieldValue = new ArrayList<>(numItems);  
        String expectedResult = "";  
            expectedResult += value;
        assertThat(ingestDocument.getFieldValue(targetFieldName, String.class), equalTo(expectedResult));
 * this work for additional information regarding copyright
        Processor processor = new JoinProcessor(randomAlphaOfLength(10), null, fieldName, "-", fieldName);
        }
}  
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
        String expectedResult = "";
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.ingest.IngestDocument;
            fieldValue.add(value);
        String targetFieldName = fieldName + randomAlphaOfLength(5);
        } catch (IllegalArgumentException e) {
        List<String> fieldValue = new ArrayList<>(numItems);
            processor.execute(ingestDocument);  
    public void testJoinWithTargetField() throws Exception {
    }
            fieldValue.add(value);  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
    }
 * The OpenSearch Contributors require contributions made to  
            if (j < numItems - 1) {
        List<String> fieldValue = new ArrayList<>(numItems);
            assertThat(e.getMessage(), equalTo("field [" + fieldName + "] of type [java.lang.String] cannot be cast to [java.util.List]"));  
        for (int j = 0; j < numItems; j++) {  
 * this file be licensed under the Apache-2.0 license or a
/*  
import org.opensearch.test.OpenSearchTestCase;
        Processor processor = new JoinProcessor(randomAlphaOfLength(10), null, "field", "-", "field");
    public void testJoinNonExistingField() throws Exception {
        String separator = randomFrom(SEPARATORS);
public class JoinProcessorTests extends OpenSearchTestCase {
        try {  
    }  
                expectedResult += separator;
        String fieldName = RandomDocumentPicks.randomFieldName(random());  
                expectedResult += separator;  
            if (j < numItems - 1) {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        int numItems = randomIntBetween(1, 10);  
import java.util.List;  
import org.opensearch.ingest.Processor;
        }
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
/*  
        Processor processor = new JoinProcessor(randomAlphaOfLength(10), null, fieldName, separator, targetFieldName);
        int numItems = randomIntBetween(1, 10);
    public void testJoinStrings() throws Exception {  
 * GitHub history for details.
 * You may obtain a copy of the License at  
        }
import org.opensearch.ingest.RandomDocumentPicks;  
    }
        processor.execute(ingestDocument);
 */  
 * license agreements. See the NOTICE file distributed with
        assertThat(ingestDocument.getFieldValue(fieldName, String.class), equalTo(expectedResult));
import java.util.ArrayList;  
            expectedResult += value;
import java.util.HashMap;
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.hamcrest.Matchers.containsString;
        try {  
        }  
        for (int j = 0; j < numItems; j++) {
import static org.hamcrest.Matchers.equalTo;  
        try {
            if (j < numItems - 1) {  
            String value = randomAlphaOfLengthBetween(1, 10);
        processor.execute(ingestDocument);  
            fieldValue.add(value);
 *
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);  
        processor.execute(ingestDocument);  
    public void testJoinIntegers() throws Exception {
            processor.execute(ingestDocument);
        String fieldName = RandomDocumentPicks.randomFieldName(random());  
    }
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
        ingestDocument.setFieldValue(fieldName, randomAlphaOfLengthBetween(1, 10));
            assertThat(e.getMessage(), equalTo("field [field] is null, cannot join."));  
            }  
            int value = randomInt();  
        }
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
        }  
                expectedResult += separator;
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
            assertThat(e.getMessage(), containsString("not present as part of path [" + fieldName + "]"));
        assertThat(ingestDocument.getFieldValue(fieldName, String.class), equalTo(expectedResult));
        Processor processor = new JoinProcessor(randomAlphaOfLength(10), null, fieldName, separator, fieldName);  
        String expectedResult = "";
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
            expectedResult += value;  
 * Licensed to Elasticsearch under one or more contributor  
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
        } catch (IllegalArgumentException e) {
        } catch (IllegalArgumentException e) {
        for (int j = 0; j < numItems; j++) {
    }
 * not use this file except in compliance with the License.
    public void testJoinNonListField() throws Exception {
        String separator = randomFrom(SEPARATORS);  
 *
            }
        int numItems = randomIntBetween(1, 10);
/*
            processor.execute(ingestDocument);
            String value = randomAlphaOfLengthBetween(1, 10);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
import java.util.Collections;
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
 */  
        Processor processor = new JoinProcessor(randomAlphaOfLength(10), null, fieldName, separator, fieldName);
    public void testJoinNullValue() throws Exception {  
    private static final String[] SEPARATORS = new String[] { "-", "_", "." };
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.ingest.common;
 * ownership. Elasticsearch licenses this file to you under  
