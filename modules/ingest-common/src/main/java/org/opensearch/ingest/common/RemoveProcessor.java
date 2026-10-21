/*
/*
import java.util.stream.Collectors;
                        throw new IllegalArgumentException(
            if (field == null && excludeField == null || field != null && excludeField != null) {
    }
            final Object field = ConfigurationUtils.readOptionalObject(config, "field");
        } else {
            this.scriptService = scriptService;
 * the Apache License, Version 2.0 (the "License"); you may
                    if (ignoreMissing) {
 * under the License.
                if (path.equals(IngestDocument.Metadata.ID.getFieldName())
    ) {
        if (excludeFields != null && !excludeFields.isEmpty()) {
 * compatible open source license.
import java.util.Objects;
        }
                    if (!metadataFields.contains(field) && !excludeFieldSet.contains(field)) {
                } else {
        @Nullable List<TemplateScript.Factory> fields,
import java.util.List;
    }
        return document;
 *
                    .keySet()
 * ownership. Elasticsearch licenses this file to you under
                    // ignore metadata fields such as _index, _id, etc.
            String processorTag,
        super(tag, description);
                    .collect(Collectors.toList());
        }
/*
                    fields.addAll(stringList);
                    }
                    } else {
                } else {
                    fields.add((String) field);
        boolean ignoreMissing
        }
            Set<String> excludeFieldSet = new HashSet<>();
                                + ", version_type: "
    public static final String TYPE = "remove";
 * SPDX-License-Identifier: Apache-2.0
                    List<String> stringList = (List<String>) field;
                    || path.equals(IngestDocument.Metadata.VERSION_TYPE.getFieldName())) {
            final List<String> excludeFields = new ArrayList<>();
                    && document.hasField(IngestDocument.Metadata.VERSION_TYPE.getFieldName())) {
    }
            throw new IllegalArgumentException("either fields or excludeFields must be set");
            boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "ignore_missing", false);
            if (field != null) {
    public static final class Factory implements Processor.Factory {
        public Factory(ScriptService scriptService) {
                        throw new IllegalArgumentException("field path cannot be null nor empty");
                    throw new IllegalArgumentException("cannot remove metadata field [" + path + "]");
                final boolean fieldPathIsNullOrEmpty = Strings.isNullOrEmpty(path);
 * KIND, either express or implied.  See the License for the
            Map<String, Processor.Factory> registry,
import org.opensearch.script.TemplateScript;
 * this file be licensed under the Apache-2.0 license or a
                    .collect(Collectors.toList());
                document.removeField(path);
            this.fields = null;
import org.opensearch.core.common.Strings;
import org.opensearch.common.Nullable;
        @Nullable List<TemplateScript.Factory> excludeFields,
    }
        if (fields == null && excludeFields == null || fields != null && excludeFields != null) {
                    @SuppressWarnings("unchecked")
import java.util.Set;
                    }
                        return;
                    excludeFieldSet.add(path);
 * not use this file except in compliance with the License.
                List<TemplateScript.Factory> fieldCompiledTemplates = fields.stream()
 *
 * GitHub history for details.
                // removing _id is disallowed when there's an external version specified in the request
            if (!excludeFieldSet.isEmpty()) {
 * Modifications Copyright OpenSearch Contributors. See
                                + version
    RemoveProcessor(
import org.opensearch.script.ScriptService;
import java.util.HashSet;
 */
            }
    public IngestDocument execute(IngestDocument document) {
                existingFields.forEach(field -> {
                return new RemoveProcessor(processorTag, description, fieldCompiledTemplates, null, ignoreMissing);
    public String getType() {
                // cannot remove _index, _version and _version_type.
        return TYPE;
                    .map(f -> ConfigurationUtils.compileTemplate(TYPE, processorTag, "field", f, scriptService))
    @Override
                }
                if (excludeField instanceof List<?>) {
                List<TemplateScript.Factory> excludeFieldCompiledTemplates = excludeFields.stream()
        }
        ) throws Exception {
                }
                Set<String> metadataFields = document.getMetadata()
    @Override
 * Unless required by applicable law or agreed to in writing,
                    }
            } else {
 * You may obtain a copy of the License at
            });
        if (fields != null && !fields.isEmpty()) {
 * specific language governing permissions and limitations
            this.excludeFields = null;
                                + versionType
 * Licensed to Elasticsearch under one or more contributor
 */
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
                String path = document.renderTemplate(field);
            });
        private final ScriptService scriptService;
                    .map(IngestDocument.Metadata::getFieldName)
    public List<TemplateScript.Factory> getExcludeFields() {
                    @SuppressWarnings("unchecked")
        }
                    if (!Objects.equals(versionType, VersionType.toString(VersionType.INTERNAL))) {
 * software distributed under the License is distributed on an
                        );
import org.opensearch.ingest.Processor;
                }
        public RemoveProcessor create(
                    .stream()
import org.opensearch.ingest.AbstractProcessor;
                return new RemoveProcessor(processorTag, description, null, excludeFieldCompiledTemplates, ignoreMissing);
            excludeFields.forEach(field -> {
            }
 * this work for additional information regarding copyright
    private final List<TemplateScript.Factory> excludeFields;
            String description,
 * Processor that removes existing fields. Nothing happens if the field is not present.
}
        return excludeFields;
                        Long version = document.getFieldValue(IngestDocument.Metadata.VERSION.getFieldName(), Long.class, true);
                Set<String> existingFields = new HashSet<>(document.getSourceAndMetadata().keySet());
    }
        @Override
                if (path.equals(IngestDocument.Metadata.INDEX.getFieldName())
            final List<String> fields = new ArrayList<>();
                    .collect(Collectors.toSet());
                if (field instanceof List<?>) {
            }
import java.util.Map;
                    } else if (fieldPathIsNullOrEmpty) {
    private final boolean ignoreMissing;
public final class RemoveProcessor extends AbstractProcessor {
        if (fields != null) {
                    .map(f -> ConfigurationUtils.compileTemplate(TYPE, processorTag, "exclude_field", f, scriptService))
        this.ignoreMissing = ignoreMissing;
                }
                    List<String> stringList = (List<String>) excludeField;
                }
        }
                String path = document.renderTemplate(field);
 * license agreements. See the NOTICE file distributed with
                        throw new IllegalArgumentException("field [" + path + "] doesn't exist");
 */
                    String versionType = document.getFieldValue(IngestDocument.Metadata.VERSION_TYPE.getFieldName(), String.class);
        String description,
 */
    public List<TemplateScript.Factory> getFields() {
                }
                            "cannot remove metadata field [_id] when specifying external version for the document, version: "
    }
                throw newConfigurationException(TYPE, processorTag, "field", "either field or exclude_field must be set");
/**
package org.opensearch.ingest.common;
                    excludeFields.add((String) excludeField);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        String tag,
 * The OpenSearch Contributors require contributions made to
            fields.forEach(field -> {
            this.excludeFields = new ArrayList<>(excludeFields);
                    || path.equals(IngestDocument.Metadata.VERSION.getFieldName())
                    excludeFields.addAll(stringList);
                if (fieldPathIsNullOrEmpty || document.hasField(path) == false) {
        return fields;
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.ArrayList;
            this.fields = new ArrayList<>(fields);
                // ignore the empty or null field path
                });
            Map<String, Object> config
 *
                if (!Strings.isNullOrEmpty(path)) {
import org.opensearch.index.VersionType;
                        document.removeField(field);
import org.opensearch.ingest.IngestDocument;
            final Object excludeField = ConfigurationUtils.readOptionalObject(config, "exclude_field");
import org.opensearch.ingest.ConfigurationUtils;
    private final List<TemplateScript.Factory> fields;
