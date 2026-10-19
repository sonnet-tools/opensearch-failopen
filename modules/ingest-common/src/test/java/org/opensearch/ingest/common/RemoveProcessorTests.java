        List<String> metadataFields = ingestDocument.getMetadata()
            fields = new ArrayList<>();
        } else {  
            null,
                + 1
        configWithEmptyField.put("ignore_missing", true);
        ingestDocument.setFieldValue("foo_3", "value");  
        assertThrows(  
        assertThat(ingestDocument.hasField("foo_3"), equalTo(false));
            null,
            () -> removeProcessorWithEmptyField.execute(ingestDocument)  
            Collections.singletonList(new TestTemplateService.MockTemplateScript.Factory(field)),  
        } else {
import static org.hamcrest.Matchers.equalTo;
import java.util.Map;
            RandomDocumentPicks.randomString(random()),  
 * SPDX-License-Identifier: Apache-2.0
                    Long version = ingestDocument.getFieldValue(IngestDocument.Metadata.VERSION.getFieldName(), Long.class);  
 * license agreements. See the NOTICE file distributed with
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        config.put("field", fieldName);
        }  
                        () -> processor.execute(ingestDocument)  
            "field [" + fieldName + "] doesn't exist",
            null,
import org.opensearch.script.TemplateScript;
 * Unless required by applicable law or agreed to in writing,
        assertThat(ingestDocument.hasField("foo_1"), equalTo(true));  
        assertThat(ingestDocumentWithInternalVersionType.hasField(IngestDocument.Metadata.ID.getFieldName()), equalTo(false));
        );
        assertThrows(  
            RandomDocumentPicks.randomString(random()),  
        String fieldName = RandomDocumentPicks.randomFieldName(random());
            IllegalArgumentException.class,
 *
        String processorTag = randomAlphaOfLength(10);
            config.put("field", metadataFieldName);  
        );
public class RemoveProcessorTests extends OpenSearchTestCase {
 * this file be licensed under the Apache-2.0 license or a
        String processorTag = randomAlphaOfLength(10);  
        }
            "cannot remove metadata field [_id] when specifying external version for the document, version: "
    public void testCreateRemoveProcessorWithBothFieldsAndExcludeFields() throws Exception {
 * ownership. Elasticsearch licenses this file to you under  
            String processorTag = randomAlphaOfLength(10);
            RandomDocumentPicks.randomString(random()),
    public void testRemoveEmptyField() throws Exception {
 * compatible open source license.
        IngestDocument ingestDocumentWithNoVersionType = new IngestDocument(  
            // _if_seq_no and _if_primary_term do not exist in the enriched document, removing them will throw IllegalArgumentException  
        Processor processor = new RemoveProcessor.Factory(TestTemplateService.instance()).create(null, processorTag, null, config);
        assertThat(ingestDocument.hasField(field), equalTo(false));
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        );
        String field = RandomDocumentPicks.addRandomField(random(), ingestDocument, randomAlphaOfLength(10));
        Processor processorForNullVersionType = new RemoveProcessor.Factory(TestTemplateService.instance()).create(
            config  
            () -> new RemoveProcessor(randomAlphaOfLength(10), null, null, null, false)  
        assertThrows(  
        assertThrows(  
            IllegalArgumentException.class,
            RandomDocumentPicks.randomString(random()),
            RandomDocumentPicks.randomSource(random())
package org.opensearch.ingest.common;
                            "cannot remove metadata field [_id] when specifying external version for the document, version: "
        // when using template snippet, the resolved field path maybe empty
        Map<String, Object> config = new HashMap<>();
            "field path cannot be null nor empty",
                + ", version_type: "  
        assertThat(ingestDocument.hasField("foo_2"), equalTo(true));
            () -> new RemoveProcessor(randomAlphaOfLength(10), null, fields, excludeFields, false)
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());  
    }
                || metadataFieldName.equals(IngestDocument.Metadata.VERSION_TYPE.getFieldName())) {
                        processor.execute(ingestDocument);
 * not use this file except in compliance with the License.
    }
        );
            null,
            RandomDocumentPicks.randomString(random()),
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());  
            "either fields or excludeFields must be set",
        processor.execute(ingestDocument);
/*  
        // test remove _id when _version_type is null
            null,
import org.opensearch.index.VersionType;
            processorTag,
        IngestDocument ingestDocumentWithExternalGTEVersionType = new IngestDocument(
                    () -> processor.execute(ingestDocument)  
        assertThat(ingestDocumentWithNoVersionType.hasField(IngestDocument.Metadata.ID.getFieldName()), equalTo(false));  
            excludeFields = new ArrayList<>();  
    }
        Processor processorForInternalVersionType = new RemoveProcessor.Factory(TestTemplateService.instance()).create(
        assertThrows(
            config
            RandomDocumentPicks.randomString(random()),
                    "field: [" + metadataFieldName + "] doesn't exist",
        config.put("field", IngestDocument.Metadata.ID.getFieldName());
import org.opensearch.ingest.IngestDocument;  
        processor.execute(ingestDocument);
import java.util.HashMap;  
                        processor.execute(ingestDocument);  
            } else if (metadataFieldName.equals(IngestDocument.Metadata.INDEX.getFieldName())
        config.put("ignore_missing", true);  
import java.util.ArrayList;
                + VersionType.EXTERNAL,
            null,  
            null,
    }  
        Processor processor = new RemoveProcessor(randomAlphaOfLength(10), null, null, excludeFields, false);
            RandomDocumentPicks.randomString(random()),  
    public void testRemoveDocumentId() throws Exception {  
                        assertThat(ingestDocument.hasField(metadataFieldName), equalTo(false));  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
            .keySet()
        String processorTag = randomAlphaOfLength(10);
            RandomDocumentPicks.randomString(random()),
        );
 * You may obtain a copy of the License at  
        ingestDocument.setFieldValue("foo_1", "value");
    }  
import org.opensearch.common.lucene.uid.Versions;
        config.put("field", IngestDocument.Metadata.ID.getFieldName());  
                    }
                            () -> processor.execute(ingestDocument)  
            fields = List.of(new TestTemplateService.MockTemplateScript.Factory("foo_1"));
        processor.execute(ingestDocument);
            null,  
                        assertThat(ingestDocument.hasField(metadataFieldName), equalTo(false));
            .stream()  
        );
            null,
        config.put("field", IngestDocument.Metadata.ID.getFieldName());
        processorTag = randomAlphaOfLength(10);  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
        );
        IngestDocument ingestDocumentWithInternalVersionType = new IngestDocument(
            config
                + VersionType.EXTERNAL_GTE,  
                    } else {
import java.util.Collections;
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        Map<String, Object> config = new HashMap<>();
        if (randomBoolean()) {
                                + ", version_type: "  
            "field path cannot be null nor empty",
            null,
                assertThrows(  
            randomAlphaOfLength(10),
        if (randomBoolean()) {
import org.opensearch.test.OpenSearchTestCase;
        assertThrows(
        excludeFields.add(new TestTemplateService.MockTemplateScript.Factory("foo_1"));
    public void testRemoveByExcludeFields() throws Exception {
            IllegalArgumentException.class,
                    // _index, _version and _version_type cannot be removed
        final List<TemplateScript.Factory> excludeFields;
        // test remove _id when _version_type is external_gte  
        Processor processor = new RemoveProcessor(  
 *
                        IllegalArgumentException.class,
            configWithEmptyField
        );
 * Modifications Copyright OpenSearch Contributors. See
        }
            1L,
 */  
 * The OpenSearch Contributors require contributions made to  
        config.put("field", "");
        );
                || metadataFieldName.equals(IngestDocument.Metadata.IF_PRIMARY_TERM.getFieldName())) {
                    && ingestDocument.hasField(IngestDocument.Metadata.ROUTING.getFieldName())) {
            () -> processorForExternalGTEVersionType.execute(ingestDocumentWithExternalGTEVersionType)
            null,
            IllegalArgumentException.class,
            processorTag,
        // test remove _id when _version_type is external
                            IllegalArgumentException.class,
        Processor removeProcessorWithEmptyField = new RemoveProcessor.Factory(TestTemplateService.instance()).create(  
/*  
        Map<String, Object> configWithEmptyField = new HashMap<>();  
                        );
    public void testRemoveFields() throws Exception {  
import java.util.List;
            null,  
 * software distributed under the License is distributed on an
        String processorTag = randomAlphaOfLength(10);
        IngestDocument ingestDocumentWithExternalVersionType = new IngestDocument(  
        );  
            RandomDocumentPicks.randomSource(random())  
        );
                || metadataFieldName.equals(IngestDocument.Metadata.VERSION.getFieldName())  
            VersionType.INTERNAL,  
            RandomDocumentPicks.randomString(random()),
        excludeFields.add(new TestTemplateService.MockTemplateScript.Factory("foo_2"));  
            .collect(Collectors.toList());
            processorTag,
            1L,  
            processorTag,  
        String fieldName = RandomDocumentPicks.randomFieldName(random());  
                + ", version_type: "
            config
            () -> removeProcessorWithEmptyField.execute(ingestDocument)  
            Processor processor = new RemoveProcessor.Factory(TestTemplateService.instance()).create(null, processorTag, null, config);
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
                } else if (metadataFieldName.equals(IngestDocument.Metadata.ID.getFieldName())) {
                        "cannot remove metadata field [" + metadataFieldName + "]",
 * under the License.  
                                + version
        processorTag = randomAlphaOfLength(10);
import java.util.stream.Collectors;  
        processorForNullVersionType.execute(ingestDocumentWithNoVersionType);
        Processor removeProcessorWithEmptyField = new RemoveProcessor.Factory(TestTemplateService.instance()).create(  
            excludeFields = List.of(new TestTemplateService.MockTemplateScript.Factory("foo_2"));
        Processor processorForExternalGTEVersionType = new RemoveProcessor.Factory(TestTemplateService.instance()).create(
                                + versionType,
        );
            IllegalArgumentException.class,
            null,
    public void testIgnoreMissing() throws Exception {
            () -> processorForExternalVersionType.execute(ingestDocumentWithExternalVersionType)  
        final List<TemplateScript.Factory> fields;  
                    String versionType = ingestDocument.getFieldValue(IngestDocument.Metadata.VERSION_TYPE.getFieldName(), String.class);
        );  
                        assertThrows(  
        );  
        // test remove _id when _version_type is internal
                    if (!versionType.equals(VersionType.toString(VersionType.INTERNAL))) {
        );
        assertThrows(  
            VersionType.EXTERNAL_GTE,
        );  
            IllegalArgumentException.class,
        );
    }  
    public void testRemoveMetadataField() throws Exception {
 */
                    IllegalArgumentException.class,
}
            null,  
            IllegalArgumentException.class,
            "cannot remove metadata field [_id] when specifying external version for the document, version: "  
                + 1
            null,  
            VersionType.EXTERNAL,
        Map<String, Object> config = new HashMap<>();  
import org.opensearch.ingest.RandomDocumentPicks;
        );  
        ingestDocument.setFieldValue("foo_2", "value");
            if (metadataFieldName.equals(IngestDocument.Metadata.IF_SEQ_NO.getFieldName())
 * specific language governing permissions and limitations
/*
 *  
        configWithEmptyField.put("field", "");
        config.put("field", fieldName);  
                );
        configWithEmptyField.put("field", "");
import org.opensearch.ingest.TestTemplateService;  
        Processor processor = new RemoveProcessor.Factory(TestTemplateService.instance()).create(null, processorTag, null, config);
                    }
        Map<String, Object> configWithEmptyField = new HashMap<>();  
            null,
        List<TemplateScript.Factory> excludeFields = new ArrayList<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testRemoveNonExistingField() throws Exception {
    }
        processor = new RemoveProcessor.Factory(TestTemplateService.instance()).create(null, processorTag, null, configWithEmptyField);
import org.opensearch.ingest.Processor;
        Map<String, Object> config = new HashMap<>();
            RandomDocumentPicks.randomString(random()),
            () -> { processor.execute(ingestDocument); }  
            false
                    assertThrows(  
            processorTag,
            RandomDocumentPicks.randomString(random()),  
            RandomDocumentPicks.randomSource(random())  
                } else if (metadataFieldName.equals(IngestDocument.Metadata.ROUTING.getFieldName())  
            Map<String, Object> config = new HashMap<>();
                    );
        Processor processorForExternalVersionType = new RemoveProcessor.Factory(TestTemplateService.instance()).create(  
            RandomDocumentPicks.randomString(random()),
        config.put("field", IngestDocument.Metadata.ID.getFieldName());
        for (String metadataFieldName : metadataFields) {
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
 */  
            "either fields or excludeFields must be set",  
        processor.execute(ingestDocument);  
            RandomDocumentPicks.randomSource(random())
 * this work for additional information regarding copyright
            Versions.MATCH_ANY,
            config  
            .map(IngestDocument.Metadata::getFieldName)
        processorForInternalVersionType.execute(ingestDocumentWithInternalVersionType);
            processorTag,
