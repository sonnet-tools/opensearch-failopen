                    .collect(Collectors.toList());
        if (fields != null) {
        if (excludeFields != null && !excludeFields.isEmpty()) {  
                    List<String> stringList = (List<String>) field;  
 *
            });  
 * SPDX-License-Identifier: Apache-2.0
import java.util.ArrayList;
    @Override
            this.excludeFields = new ArrayList<>(excludeFields);  
                List<TemplateScript.Factory> excludeFieldCompiledTemplates = excludeFields.stream()
 * The OpenSearch Contributors require contributions made to  
        return excludeFields;
 * this work for additional information regarding copyright
import java.util.HashSet;  
                    excludeFields.add((String) excludeField);  
            final Object field = ConfigurationUtils.readOptionalObject(config, "field");  
import org.opensearch.ingest.Processor;
 *    http://www.apache.org/licenses/LICENSE-2.0
    private final boolean ignoreMissing;  
            excludeFields.forEach(field -> {
        }
            final List<String> fields = new ArrayList<>();
/*  
 * compatible open source license.
/**  
 */  
            fields.forEach(field -> {
                    if (ignoreMissing) {  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
                    fields.add((String) field);  
import java.util.stream.Collectors;
 */  
                    || path.equals(IngestDocument.Metadata.VERSION.getFieldName())
import org.opensearch.core.common.Strings;
package org.opensearch.ingest.common;
            this.fields = new ArrayList<>(fields);
                } else {
                    } else {
                    } else if (fieldPathIsNullOrEmpty) {
 * software distributed under the License is distributed on an
                    .keySet()
                                + ", version_type: "  
                    .map(IngestDocument.Metadata::getFieldName)  
 * this file be licensed under the Apache-2.0 license or a
                    && document.hasField(IngestDocument.Metadata.VERSION_TYPE.getFieldName())) {
        if (fields == null && excludeFields == null || fields != null && excludeFields != null) {
                    .stream()
                        throw new IllegalArgumentException("field path cannot be null nor empty");  
                        );
                }
import org.opensearch.common.Nullable;
/*
                    excludeFields.addAll(stringList);
            }
public final class RemoveProcessor extends AbstractProcessor {  
                    throw new IllegalArgumentException("cannot remove metadata field [" + path + "]");
                document.removeField(path);
                        return;
 * GitHub history for details.
                if (!Strings.isNullOrEmpty(path)) {
    }  
            final Object excludeField = ConfigurationUtils.readOptionalObject(config, "exclude_field");
    @Override
        return document;
    public IngestDocument execute(IngestDocument document) {  
 *
                List<TemplateScript.Factory> fieldCompiledTemplates = fields.stream()
    public static final class Factory implements Processor.Factory {
                    .map(f -> ConfigurationUtils.compileTemplate(TYPE, processorTag, "field", f, scriptService))  
                    String versionType = document.getFieldValue(IngestDocument.Metadata.VERSION_TYPE.getFieldName(), String.class);  
                    .map(f -> ConfigurationUtils.compileTemplate(TYPE, processorTag, "exclude_field", f, scriptService))  
        }
            final List<String> excludeFields = new ArrayList<>();
import org.opensearch.ingest.AbstractProcessor;
        }  
                    @SuppressWarnings("unchecked")
import java.util.Objects;  
                    // ignore metadata fields such as _index, _id, etc.  
            }
 * ownership. Elasticsearch licenses this file to you under  
                // cannot remove _index, _version and _version_type.  
                });
                }
            String processorTag,  
    }
    public static final String TYPE = "remove";
            this.excludeFields = null;  
 * not use this file except in compliance with the License.
import org.opensearch.script.TemplateScript;  
                if (fieldPathIsNullOrEmpty || document.hasField(path) == false) {
                        document.removeField(field);
                return new RemoveProcessor(processorTag, description, null, excludeFieldCompiledTemplates, ignoreMissing);
            if (!excludeFieldSet.isEmpty()) {
    public List<TemplateScript.Factory> getExcludeFields() {
                final boolean fieldPathIsNullOrEmpty = Strings.isNullOrEmpty(path);
                // ignore the empty or null field path
                }
                Set<String> existingFields = new HashSet<>(document.getSourceAndMetadata().keySet());
                }
import java.util.Set;
        String description,
                                + versionType
            this.scriptService = scriptService;  
 *  
                    List<String> stringList = (List<String>) excludeField;  
    public String getType() {  
            Map<String, Object> config
        }  
                    || path.equals(IngestDocument.Metadata.VERSION_TYPE.getFieldName())) {  
                                + version
            throw new IllegalArgumentException("either fields or excludeFields must be set");
                return new RemoveProcessor(processorTag, description, fieldCompiledTemplates, null, ignoreMissing);
            Map<String, Processor.Factory> registry,
        private final ScriptService scriptService;  
                throw newConfigurationException(TYPE, processorTag, "field", "either field or exclude_field must be set");
                }
 * license agreements. See the NOTICE file distributed with
        }
                    fields.addAll(stringList);
                Set<String> metadataFields = document.getMetadata()  
 * Modifications Copyright OpenSearch Contributors. See
 * Processor that removes existing fields. Nothing happens if the field is not present.
                String path = document.renderTemplate(field);  
import org.opensearch.script.ScriptService;
}  
                            "cannot remove metadata field [_id] when specifying external version for the document, version: "
        @Nullable List<TemplateScript.Factory> fields,
        public Factory(ScriptService scriptService) {
    private final List<TemplateScript.Factory> fields;
                    .collect(Collectors.toSet());
                        throw new IllegalArgumentException(  
                }
                    .collect(Collectors.toList());
                    if (!Objects.equals(versionType, VersionType.toString(VersionType.INTERNAL))) {
        this.ignoreMissing = ignoreMissing;  
        super(tag, description);  
        return TYPE;
import org.opensearch.ingest.ConfigurationUtils;
        ) throws Exception {  
 * specific language governing permissions and limitations
import org.opensearch.index.VersionType;  
            });
        boolean ignoreMissing
    }
                    @SuppressWarnings("unchecked")
            this.fields = null;
                    }  
 * Licensed to Elasticsearch under one or more contributor  
/*  
    RemoveProcessor(
import java.util.Map;
            Set<String> excludeFieldSet = new HashSet<>();
        }
    public List<TemplateScript.Factory> getFields() {  
            } else {  
 * the Apache License, Version 2.0 (the "License"); you may
    private final List<TemplateScript.Factory> excludeFields;
 */
                    }  
            }  
 * You may obtain a copy of the License at  
            String description,
                        throw new IllegalArgumentException("field [" + path + "] doesn't exist");
        return fields;
 */
    }
                String path = document.renderTemplate(field);  
                if (field instanceof List<?>) {
                    }  
            boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "ignore_missing", false);
        if (fields != null && !fields.isEmpty()) {
        @Nullable List<TemplateScript.Factory> excludeFields,  
        String tag,  
    }
                } else {
    }  
                if (excludeField instanceof List<?>) {
                // removing _id is disallowed when there's an external version specified in the request  
        } else {
                        Long version = document.getFieldValue(IngestDocument.Metadata.VERSION.getFieldName(), Long.class, true);
        public RemoveProcessor create(
 * KIND, either express or implied.  See the License for the
                existingFields.forEach(field -> {
            if (field == null && excludeField == null || field != null && excludeField != null) {  
                    if (!metadataFields.contains(field) && !excludeFieldSet.contains(field)) {
import org.opensearch.ingest.IngestDocument;  
                if (path.equals(IngestDocument.Metadata.INDEX.getFieldName())
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
                if (path.equals(IngestDocument.Metadata.ID.getFieldName())
            if (field != null) {  
        @Override  
                    excludeFieldSet.add(path);  
    ) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.List;
