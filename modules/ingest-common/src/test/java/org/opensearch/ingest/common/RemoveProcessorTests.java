 * You may obtain a copy of the License at
package org.opensearch.ingest.common;
        Processor processorForInternalVersionType = new RemoveProcessor.Factory(TestTemplateService.instance()).create(
        assertThrows(
            "cannot remove metadata field [_id] when specifying external version for the document, version: "
            IllegalArgumentException.class,
            processorTag,
        Processor processor = new RemoveProcessor(randomAlphaOfLength(10), null, null, excludeFields, false);
        );
            "either fields or excludeFields must be set",
                    String versionType = ingestDocument.getFieldValue(IngestDocument.Metadata.VERSION_TYPE.getFieldName(), String.class);
        );
        config.put("field", "");
                + 1
        excludeFields.add(new TestTemplateService.MockTemplateScript.Factory("foo_1"));
        ingestDocument.setFieldValue("foo_3", "value");
        );
        } else {
            RandomDocumentPicks.randomString(random()),
            IllegalArgumentException.class,
            processorTag,
            () -> removeProcessorWithEmptyField.execute(ingestDocument)
            RandomDocumentPicks.randomString(random()),
import static org.hamcrest.Matchers.equalTo;
        configWithEmptyField.put("field", "");
            null,
            RandomDocumentPicks.randomSource(random())
        // when using template snippet, the resolved field path maybe empty
    }
            RandomDocumentPicks.randomString(random()),
        processorTag = randomAlphaOfLength(10);
        IngestDocument ingestDocumentWithExternalGTEVersionType = new IngestDocument(
            RandomDocumentPicks.randomString(random()),
            fields = new ArrayList<>();
            RandomDocumentPicks.randomSource(random())
        );
        if (randomBoolean()) {
        );
                            () -> processor.execute(ingestDocument)
        }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        Map<String, Object> config = new HashMap<>();
    public void testRemoveDocumentId() throws Exception {
            1L,
            null,
            IllegalArgumentException.class,
                || metadataFieldName.equals(IngestDocument.Metadata.IF_PRIMARY_TERM.getFieldName())) {
            RandomDocumentPicks.randomSource(random())
    public void testRemoveByExcludeFields() throws Exception {
                + ", version_type: "
        Processor processorForExternalVersionType = new RemoveProcessor.Factory(TestTemplateService.instance()).create(
        assertThrows(
                + VersionType.EXTERNAL,
        Map<String, Object> configWithEmptyField = new HashMap<>();
            RandomDocumentPicks.randomSource(random())
            VersionType.EXTERNAL_GTE,
            IllegalArgumentException.class,
        processor.execute(ingestDocument);
            RandomDocumentPicks.randomString(random()),
        final List<TemplateScript.Factory> excludeFields;
                    && ingestDocument.hasField(IngestDocument.Metadata.ROUTING.getFieldName())) {
        config.put("field", fieldName);
    public void testCreateRemoveProcessorWithBothFieldsAndExcludeFields() throws Exception {
                    if (!versionType.equals(VersionType.toString(VersionType.INTERNAL))) {
    public void testRemoveFields() throws Exception {
                + ", version_type: "
    }
        Map<String, Object> config = new HashMap<>();
        assertThat(ingestDocument.hasField(field), equalTo(false));
        String processorTag = randomAlphaOfLength(10);
                    "field: [" + metadataFieldName + "] doesn't exist",
            null,
        List<String> metadataFields = ingestDocument.getMetadata()
            "field path cannot be null nor empty",
    }
        );
 * KIND, either express or implied.  See the License for the
        Map<String, Object> configWithEmptyField = new HashMap<>();
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
            config
 * this work for additional information regarding copyright
                    () -> processor.execute(ingestDocument)
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        List<TemplateScript.Factory> excludeFields = new ArrayList<>();
        processor.execute(ingestDocument);
import org.opensearch.test.OpenSearchTestCase;
                        assertThrows(
        IngestDocument ingestDocumentWithInternalVersionType = new IngestDocument(
                            "cannot remove metadata field [_id] when specifying external version for the document, version: "
 * this file be licensed under the Apache-2.0 license or a
            "field path cannot be null nor empty",
            RandomDocumentPicks.randomString(random()),
    }
            processorTag,
        assertThat(ingestDocument.hasField("foo_3"), equalTo(false));
            config
 * ownership. Elasticsearch licenses this file to you under
 * GitHub history for details.
import java.util.ArrayList;
/*
                        processor.execute(ingestDocument);
        assertThrows(
            configWithEmptyField
        } else {
                || metadataFieldName.equals(IngestDocument.Metadata.VERSION.getFieldName())
 * Unless required by applicable law or agreed to in writing,
            config
            RandomDocumentPicks.randomString(random()),
        );
    public void testRemoveEmptyField() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                            IllegalArgumentException.class,
        Map<String, Object> config = new HashMap<>();
            if (metadataFieldName.equals(IngestDocument.Metadata.IF_SEQ_NO.getFieldName())
    }
            VersionType.EXTERNAL,
            processorTag,
        config.put("field", IngestDocument.Metadata.ID.getFieldName());
 * Modifications Copyright OpenSearch Contributors. See
            config.put("field", metadataFieldName);
    public void testRemoveNonExistingField() throws Exception {
                    }
            config
        Processor processor = new RemoveProcessor.Factory(TestTemplateService.instance()).create(null, processorTag, null, config);
        assertThat(ingestDocument.hasField("foo_2"), equalTo(true));
            randomAlphaOfLength(10),
                    } else {
/*
        // test remove _id when _version_type is null
        Processor removeProcessorWithEmptyField = new RemoveProcessor.Factory(TestTemplateService.instance()).create(
import org.opensearch.ingest.RandomDocumentPicks;
}
 *
import org.opensearch.ingest.TestTemplateService;
            () -> removeProcessorWithEmptyField.execute(ingestDocument)
import org.opensearch.index.VersionType;
            null,
                                + version
                        );
        String field = RandomDocumentPicks.addRandomField(random(), ingestDocument, randomAlphaOfLength(10));
        );
public class RemoveProcessorTests extends OpenSearchTestCase {
 */
            () -> { processor.execute(ingestDocument); }
 */
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
            RandomDocumentPicks.randomString(random()),
                                + ", version_type: "
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        processor.execute(ingestDocument);
 * under the License.
            excludeFields = List.of(new TestTemplateService.MockTemplateScript.Factory("foo_2"));
        ingestDocument.setFieldValue("foo_1", "value");
        config.put("ignore_missing", true);
                + VersionType.EXTERNAL_GTE,
            RandomDocumentPicks.randomString(random()),
                + 1
            IllegalArgumentException.class,
            () -> processorForExternalGTEVersionType.execute(ingestDocumentWithExternalGTEVersionType)
            VersionType.INTERNAL,
            excludeFields = new ArrayList<>();
        // test remove _id when _version_type is internal
import org.opensearch.ingest.Processor;
 * The OpenSearch Contributors require contributions made to
            processorTag,
        assertThrows(
                    );
 * the Apache License, Version 2.0 (the "License"); you may
        processorForInternalVersionType.execute(ingestDocumentWithInternalVersionType);
        Map<String, Object> config = new HashMap<>();
        IngestDocument ingestDocumentWithNoVersionType = new IngestDocument(
        ingestDocument.setFieldValue("foo_2", "value");
            "field [" + fieldName + "] doesn't exist",
        String processorTag = randomAlphaOfLength(10);
            null,
import org.opensearch.common.lucene.uid.Versions;
        processorTag = randomAlphaOfLength(10);
        processor = new RemoveProcessor.Factory(TestTemplateService.instance()).create(null, processorTag, null, configWithEmptyField);
        for (String metadataFieldName : metadataFields) {
            null,
 */
        String processorTag = randomAlphaOfLength(10);
            null,
 *
            .keySet()
    public void testIgnoreMissing() throws Exception {
        );
            config
    }
        assertThrows(
        }
        assertThrows(
        configWithEmptyField.put("ignore_missing", true);
        );
/*
            () -> processorForExternalVersionType.execute(ingestDocumentWithExternalVersionType)
            Map<String, Object> config = new HashMap<>();
        config.put("field", IngestDocument.Metadata.ID.getFieldName());
 * license agreements. See the NOTICE file distributed with
        );
                    // _index, _version and _version_type cannot be removed
 *
            () -> new RemoveProcessor(randomAlphaOfLength(10), null, null, null, false)
                        () -> processor.execute(ingestDocument)
import java.util.stream.Collectors;
            false
            null,
            .collect(Collectors.toList());
            RandomDocumentPicks.randomString(random()),
                    Long version = ingestDocument.getFieldValue(IngestDocument.Metadata.VERSION.getFieldName(), Long.class);
                    }
                        assertThat(ingestDocument.hasField(metadataFieldName), equalTo(false));
        final List<TemplateScript.Factory> fields;
    public void testRemoveMetadataField() throws Exception {
                } else if (metadataFieldName.equals(IngestDocument.Metadata.ID.getFieldName())) {
                );
            null,
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        configWithEmptyField.put("field", "");
        Processor processor = new RemoveProcessor.Factory(TestTemplateService.instance()).create(null, processorTag, null, config);
                        processor.execute(ingestDocument);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
import java.util.HashMap;
                    assertThrows(
        processorForNullVersionType.execute(ingestDocumentWithNoVersionType);
        assertThat(ingestDocumentWithInternalVersionType.hasField(IngestDocument.Metadata.ID.getFieldName()), equalTo(false));
            fields = List.of(new TestTemplateService.MockTemplateScript.Factory("foo_1"));
        );
        excludeFields.add(new TestTemplateService.MockTemplateScript.Factory("foo_2"));
    }
import java.util.List;
                assertThrows(
            "either fields or excludeFields must be set",
        assertThat(ingestDocument.hasField("foo_1"), equalTo(true));
            String processorTag = randomAlphaOfLength(10);
        processor.execute(ingestDocument);
    }
            "cannot remove metadata field [_id] when specifying external version for the document, version: "
 * Licensed to Elasticsearch under one or more contributor
        );
            } else if (metadataFieldName.equals(IngestDocument.Metadata.INDEX.getFieldName())
            RandomDocumentPicks.randomString(random()),
        assertThrows(
            // _if_seq_no and _if_primary_term do not exist in the enriched document, removing them will throw IllegalArgumentException
            null,
            Versions.MATCH_ANY,
            null,
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        // test remove _id when _version_type is external
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 * compatible open source license.
            null,
            null,
                        assertThat(ingestDocument.hasField(metadataFieldName), equalTo(false));
        );
        config.put("field", IngestDocument.Metadata.ID.getFieldName());
            1L,
            Processor processor = new RemoveProcessor.Factory(TestTemplateService.instance()).create(null, processorTag, null, config);
        if (randomBoolean()) {
            null,
        Processor processorForNullVersionType = new RemoveProcessor.Factory(TestTemplateService.instance()).create(
import org.opensearch.script.TemplateScript;
            processorTag,
                } else if (metadataFieldName.equals(IngestDocument.Metadata.ROUTING.getFieldName())
            .stream()
        Processor removeProcessorWithEmptyField = new RemoveProcessor.Factory(TestTemplateService.instance()).create(
        Processor processor = new RemoveProcessor(
            null,
        String processorTag = randomAlphaOfLength(10);
            null,
 * not use this file except in compliance with the License.
import java.util.Collections;
        );
        IngestDocument ingestDocumentWithExternalVersionType = new IngestDocument(
import java.util.Map;
            RandomDocumentPicks.randomString(random()),
                    IllegalArgumentException.class,
        config.put("field", fieldName);
        );
        }
 * SPDX-License-Identifier: Apache-2.0
            IllegalArgumentException.class,
 * specific language governing permissions and limitations
            IllegalArgumentException.class,
        Processor processorForExternalGTEVersionType = new RemoveProcessor.Factory(TestTemplateService.instance()).create(
                        "cannot remove metadata field [" + metadataFieldName + "]",
import org.opensearch.ingest.IngestDocument;
            .map(IngestDocument.Metadata::getFieldName)
                                + versionType,
        config.put("field", IngestDocument.Metadata.ID.getFieldName());
        );
            Collections.singletonList(new TestTemplateService.MockTemplateScript.Factory(field)),
            () -> new RemoveProcessor(randomAlphaOfLength(10), null, fields, excludeFields, false)
        // test remove _id when _version_type is external_gte
                || metadataFieldName.equals(IngestDocument.Metadata.VERSION_TYPE.getFieldName())) {
                        IllegalArgumentException.class,
        );
        assertThat(ingestDocumentWithNoVersionType.hasField(IngestDocument.Metadata.ID.getFieldName()), equalTo(false));
