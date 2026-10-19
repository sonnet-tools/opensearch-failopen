    public void testSetMetadataIfPrimaryTerm() throws Exception {
        processor.execute(ingestDocument);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        processor.execute(ingestDocument);
 *  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        }
        Processor processor = createSetProcessor(Metadata.VERSION_TYPE.getFieldName(), versionType, true, false);  
        Processor processor = createSetProcessor(Metadata.IF_SEQ_NO.getFieldName(), ifSeqNo, true, false);
                e.getMessage(),
        );  
        Object fieldValue = RandomDocumentPicks.randomFieldValue(random());
        long ifPrimaryTerm = randomNonNegativeLong();  
 *
package org.opensearch.ingest.common;
    public void testSetFieldsTypeMismatch() throws Exception {
    }  
        IngestDocument ingestDocument = new IngestDocument(new HashMap<>(), new HashMap<>());
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
 *
        Processor processor = createSetProcessor(randomMetadata.getFieldName(), "_value", true, false);
        return new SetProcessor(
        assertThat(ingestDocument.hasField(fieldName), equalTo(true));  
        assertThat(ingestDocument.getFieldValue(fieldName, Object.class), equalTo(fieldValue));
        Processor processor = createSetProcessor(fieldName, newValue, false, false);  
            fail("processor execute should have failed");
        Object newValue = "bar";
 * SPDX-License-Identifier: Apache-2.0
        assertThat(ingestDocument.getFieldValue(fieldName, Object.class), equalTo(newValue));  
        // used to verify that there are no conflicts between subsequent fields going to be added
 * license agreements. See the NOTICE file distributed with
        String versionType = randomFrom("internal", "external", "external_gte");
    }
            ignoreEmptyValue
 *    http://www.apache.org/licenses/LICENSE-2.0
        processor.execute(ingestDocument);  
        assertThat(ingestDocument.getFieldValue(Metadata.IF_PRIMARY_TERM.getFieldName(), Long.class), Matchers.equalTo(ifPrimaryTerm));
    }
            ValueSource.wrap(fieldValue, TestTemplateService.instance()),  
    }  
 */  
        assertThat(ingestDocument.hasField(fieldName), equalTo(true));
        IngestDocument ingestDocument = new IngestDocument(new HashMap<>(), new HashMap<>());
            processor.execute(ingestDocument);
            overrideEnabled,
        Processor processor = createSetProcessor(Metadata.VERSION.getFieldName(), version, true, false);
 */
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
        processor.execute(ingestDocument);
    }
    public void testSetMetadataExceptVersion() throws Exception {  
    }  
 * this work for additional information regarding copyright
            );
        } catch (IllegalArgumentException e) {  
        Processor processor = createSetProcessor(fieldName, "bar", false, false);
            randomAlphaOfLength(10),  
import org.opensearch.ingest.RandomDocumentPicks;
        Object fieldValue = "foo";
import org.opensearch.ingest.IngestDocument;
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());  
    }  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        assertThat(ingestDocument.getFieldValue(fieldName, Object.class), equalTo(fieldValue));  
/*  
        Processor processor = createSetProcessor(fieldName, fieldValue, false, false);  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.ingest.TestTemplateService;
import org.opensearch.test.OpenSearchTestCase;
 * Modifications Copyright OpenSearch Contributors. See
    public void testSetNewFields() throws Exception {
        String fieldName = RandomDocumentPicks.addRandomField(random(), testIngestDocument, fieldValue);
        Processor processor = createSetProcessor("field.inner", "value", true, false);
        Processor processor = createSetProcessor(fieldName, fieldValue, true, false);
        assertThat(ingestDocument.getFieldValue(Metadata.VERSION.getFieldName(), Long.class), Matchers.equalTo(version));
    }
 * compatible open source license.
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
 * this file be licensed under the Apache-2.0 license or a
    }
        assertThat(ingestDocument.getFieldValue(Metadata.IF_SEQ_NO.getFieldName(), Long.class), Matchers.equalTo(ifSeqNo));
    }
 * GitHub history for details.
import org.opensearch.ingest.ValueSource;  
        processor.execute(ingestDocument);
    public void testSetExistingFields() throws Exception {
/*  
 * You may obtain a copy of the License at  
                equalTo("cannot set [inner] with parent object of type [java.lang.String] as " + "part of path [field.inner]")  
 * Licensed to Elasticsearch under one or more contributor  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());  
import static org.hamcrest.Matchers.equalTo;  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
import org.opensearch.ingest.IngestDocument.Metadata;
    public void testSetMetadataVersion() throws Exception {
        String fieldName = RandomDocumentPicks.randomExistingFieldName(random(), ingestDocument);  
        processor.execute(ingestDocument);  
        try {  
}
        ingestDocument.setFieldValue("field", "value");
 * the Apache License, Version 2.0 (the "License"); you may
        processor.execute(ingestDocument);
/*
        processor.execute(ingestDocument);  
        Object fieldValue = RandomDocumentPicks.randomFieldValue(random());  
        Object fieldValue = null;  
 * software distributed under the License is distributed on an
public class SetProcessorTests extends OpenSearchTestCase {
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        assertThat(ingestDocument.getFieldValue(Metadata.VERSION_TYPE.getFieldName(), String.class), Matchers.equalTo(versionType));  
 * under the License.  
        Processor processor = createSetProcessor(Metadata.IF_PRIMARY_TERM.getFieldName(), ifPrimaryTerm, true, false);
        Metadata randomMetadata = randomFrom(Metadata.INDEX, Metadata.ID, Metadata.ROUTING);
import org.opensearch.ingest.Processor;  
    public void testSetNewFieldWithOverrideDisabled() throws Exception {
 * not use this file except in compliance with the License.
        assertThat(ingestDocument.getFieldValue(fieldName, Object.class), equalTo(fieldValue));
        Processor processor = createSetProcessor(fieldName, fieldValue, true, false);
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);  
        processor.execute(ingestDocument);  
 * Unless required by applicable law or agreed to in writing,
        assertThat(ingestDocument.getFieldValue(randomMetadata.getFieldName(), String.class), Matchers.equalTo("_value"));
    public void testSetExistingFieldWithOverrideDisabled() throws Exception {  
import org.hamcrest.Matchers;
    public void testSetMetadataIfSeqNo() throws Exception {  
        IngestDocument ingestDocument = new IngestDocument(new HashMap<>(), new HashMap<>());  
        processor.execute(ingestDocument);
        assertThat(ingestDocument.hasField(fieldName), equalTo(true));
        assertThat(ingestDocument.hasField(fieldName), equalTo(true));
            null,
        Object fieldValue = RandomDocumentPicks.randomFieldValue(random());
 * specific language governing permissions and limitations
        long ifSeqNo = randomNonNegativeLong();
            new TestTemplateService.MockTemplateScript.Factory(fieldName),
        assertThat(ingestDocument.getFieldValue(fieldName, Object.class), equalTo(fieldValue));
    private static Processor createSetProcessor(String fieldName, Object fieldValue, boolean overrideEnabled, boolean ignoreEmptyValue) {
 * KIND, either express or implied.  See the License for the
    }
        IngestDocument testIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
            assertThat(
 */  
import java.util.HashMap;
    }  
        assertThat(ingestDocument.hasField(fieldName), equalTo(true));
 * ownership. Elasticsearch licenses this file to you under  
    public void testSetExistingNullFieldWithOverrideDisabled() throws Exception {
    public void testSetMetadataVersionType() throws Exception {
        long version = randomNonNegativeLong();  
