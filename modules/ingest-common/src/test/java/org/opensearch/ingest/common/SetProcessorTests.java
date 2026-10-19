        assertThat(ingestDocument.getFieldValue(randomMetadata.getFieldName(), String.class), Matchers.equalTo("_value"));
    public void testSetExistingFieldWithOverrideDisabled() throws Exception {
        processor.execute(ingestDocument);
    public void testSetMetadataIfSeqNo() throws Exception {
            fail("processor execute should have failed");
 */
    public void testSetMetadataVersionType() throws Exception {
        return new SetProcessor(
        IngestDocument testIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
            ValueSource.wrap(fieldValue, TestTemplateService.instance()),
package org.opensearch.ingest.common;
 * You may obtain a copy of the License at
    }
 * ownership. Elasticsearch licenses this file to you under
        // used to verify that there are no conflicts between subsequent fields going to be added
        Processor processor = createSetProcessor(fieldName, "bar", false, false);
        Processor processor = createSetProcessor(Metadata.VERSION_TYPE.getFieldName(), versionType, true, false);
    }
        Metadata randomMetadata = randomFrom(Metadata.INDEX, Metadata.ID, Metadata.ROUTING);
    public void testSetNewFieldWithOverrideDisabled() throws Exception {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        IngestDocument ingestDocument = new IngestDocument(new HashMap<>(), new HashMap<>());
                e.getMessage(),
        Processor processor = createSetProcessor(fieldName, fieldValue, false, false);
        } catch (IllegalArgumentException e) {
        ingestDocument.setFieldValue("field", "value");
        );
        Processor processor = createSetProcessor(Metadata.VERSION.getFieldName(), version, true, false);
        processor.execute(ingestDocument);
 * under the License.
    }
            new TestTemplateService.MockTemplateScript.Factory(fieldName),
import org.opensearch.ingest.IngestDocument.Metadata;
        processor.execute(ingestDocument);
    }
    }
/*
 * this file be licensed under the Apache-2.0 license or a
        Processor processor = createSetProcessor(Metadata.IF_PRIMARY_TERM.getFieldName(), ifPrimaryTerm, true, false);
 * this work for additional information regarding copyright
        Object fieldValue = RandomDocumentPicks.randomFieldValue(random());
        Object fieldValue = RandomDocumentPicks.randomFieldValue(random());
 * not use this file except in compliance with the License.
            );
        Processor processor = createSetProcessor(fieldName, fieldValue, true, false);
 * Unless required by applicable law or agreed to in writing,
        assertThat(ingestDocument.getFieldValue(Metadata.VERSION.getFieldName(), Long.class), Matchers.equalTo(version));
        String fieldName = RandomDocumentPicks.addRandomField(random(), testIngestDocument, fieldValue);
        Object fieldValue = RandomDocumentPicks.randomFieldValue(random());
 * license agreements. See the NOTICE file distributed with
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
 * specific language governing permissions and limitations
        processor.execute(ingestDocument);
        Object fieldValue = null;
 */
}
            null,
import org.hamcrest.Matchers;
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
                equalTo("cannot set [inner] with parent object of type [java.lang.String] as " + "part of path [field.inner]")
        IngestDocument ingestDocument = new IngestDocument(new HashMap<>(), new HashMap<>());
        Processor processor = createSetProcessor(Metadata.IF_SEQ_NO.getFieldName(), ifSeqNo, true, false);
        IngestDocument ingestDocument = new IngestDocument(new HashMap<>(), new HashMap<>());
    public void testSetMetadataIfPrimaryTerm() throws Exception {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        assertThat(ingestDocument.getFieldValue(Metadata.IF_SEQ_NO.getFieldName(), Long.class), Matchers.equalTo(ifSeqNo));
        assertThat(ingestDocument.getFieldValue(fieldName, Object.class), equalTo(fieldValue));
import org.opensearch.ingest.RandomDocumentPicks;
        long version = randomNonNegativeLong();
 *
            randomAlphaOfLength(10),
    public void testSetFieldsTypeMismatch() throws Exception {
        Processor processor = createSetProcessor(fieldName, newValue, false, false);
import static org.hamcrest.Matchers.equalTo;
 * KIND, either express or implied.  See the License for the
    }
 * SPDX-License-Identifier: Apache-2.0
    public void testSetMetadataVersion() throws Exception {
    }
        assertThat(ingestDocument.getFieldValue(fieldName, Object.class), equalTo(newValue));
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
        String fieldName = RandomDocumentPicks.randomFieldName(random());
    }
public class SetProcessorTests extends OpenSearchTestCase {
        processor.execute(ingestDocument);
        Object newValue = "bar";
 * The OpenSearch Contributors require contributions made to
        processor.execute(ingestDocument);
import org.opensearch.ingest.ValueSource;
    public void testSetExistingFields() throws Exception {
 * Licensed to Elasticsearch under one or more contributor
        assertThat(ingestDocument.getFieldValue(Metadata.IF_PRIMARY_TERM.getFieldName(), Long.class), Matchers.equalTo(ifPrimaryTerm));
 * GitHub history for details.
 *
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        assertThat(ingestDocument.hasField(fieldName), equalTo(true));
 * Modifications Copyright OpenSearch Contributors. See
    }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        }
        Processor processor = createSetProcessor(fieldName, fieldValue, true, false);
        long ifPrimaryTerm = randomNonNegativeLong();
        assertThat(ingestDocument.getFieldValue(fieldName, Object.class), equalTo(fieldValue));
        processor.execute(ingestDocument);
        assertThat(ingestDocument.getFieldValue(Metadata.VERSION_TYPE.getFieldName(), String.class), Matchers.equalTo(versionType));
import org.opensearch.ingest.Processor;
        assertThat(ingestDocument.hasField(fieldName), equalTo(true));
/*
 * compatible open source license.
        Object fieldValue = "foo";
            ignoreEmptyValue
 */
import org.opensearch.ingest.TestTemplateService;
        assertThat(ingestDocument.hasField(fieldName), equalTo(true));
        assertThat(ingestDocument.getFieldValue(fieldName, Object.class), equalTo(fieldValue));
        try {
        long ifSeqNo = randomNonNegativeLong();
/*
        Processor processor = createSetProcessor(randomMetadata.getFieldName(), "_value", true, false);
        assertThat(ingestDocument.hasField(fieldName), equalTo(true));
    }
        Processor processor = createSetProcessor("field.inner", "value", true, false);
        processor.execute(ingestDocument);
            processor.execute(ingestDocument);
    public void testSetExistingNullFieldWithOverrideDisabled() throws Exception {
    private static Processor createSetProcessor(String fieldName, Object fieldValue, boolean overrideEnabled, boolean ignoreEmptyValue) {
import java.util.HashMap;
    public void testSetMetadataExceptVersion() throws Exception {
        String versionType = randomFrom("internal", "external", "external_gte");
        assertThat(ingestDocument.hasField(fieldName), equalTo(true));
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
    }
 * software distributed under the License is distributed on an
            overrideEnabled,
        processor.execute(ingestDocument);
 * the Apache License, Version 2.0 (the "License"); you may
        processor.execute(ingestDocument);
import org.opensearch.test.OpenSearchTestCase;
 *    http://www.apache.org/licenses/LICENSE-2.0
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        String fieldName = RandomDocumentPicks.randomExistingFieldName(random(), ingestDocument);
        assertThat(ingestDocument.getFieldValue(fieldName, Object.class), equalTo(fieldValue));
import org.opensearch.ingest.IngestDocument;
 *
            assertThat(
    public void testSetNewFields() throws Exception {
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, fieldValue);
