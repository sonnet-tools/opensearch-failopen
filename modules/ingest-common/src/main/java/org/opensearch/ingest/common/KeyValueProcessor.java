    private static Function<String, String> buildTrimmer(String trim) {
            final Function<String, String> bracketStrip;
        String trimValue,
/*
                keyFilter = key -> true;
 */
        } else {
 * Unless required by applicable law or agreed to in writing,
        String fieldSplit,
            if (excludeKeys == null) {
        Set<String> excludeKeys,
        );
 * KIND, either express or implied.  See the License for the
                bracketStrip = val -> val;
    private final Consumer<IngestDocument> execution;
            }
        if (trim == null) {
    }
        } else {
                trimKey,
        }
    ) {
            field,
            TemplateScript.Factory targetFieldTemplate = null;
            return new KeyValueProcessor(
        this.ignoreMissing = ignoreMissing;
                includeKeys,
                keyPrefixer = val -> fieldPathPrefix + val;
    ) {
        String fieldSplit,
                    fieldPathPrefix = targetFieldPath + "." + keyPrefix;
            String description,
            String trimValue = ConfigurationUtils.readOptionalStringProperty(TYPE, processorTag, config, "trim_value");
            TemplateScript.Factory fieldTemplate = ConfigurationUtils.compileTemplate(TYPE, processorTag, "field", field, scriptService);
                keyPrefixer = val -> val;
            if (fieldPathPrefix.isEmpty()) {
        TemplateScript.Factory targetField,
            }
    public static class Factory implements Processor.Factory {
            return val -> val;
                }
            } else {
 * SPDX-License-Identifier: Apache-2.0
            if (includeKeysList != null) {
    KeyValueProcessor(
    }
        String description,
    public String getType() {
        }
        return document;
            }
        boolean stripBrackets,
    }
    Set<String> getIncludeKeys() {
                    append(document, keyPrefixer.apply(key), valueTrimmer.apply(bracketStrip.apply(kv[1])));
                targetFieldTemplate,
        String trimKey,
                fieldSplit,
            stripBrackets,
                includeKeys = Collections.unmodifiableSet(Sets.newHashSet(includeKeysList));
            }
                bracketStrip = val -> STRIP_BRACKETS.matcher(val).replaceAll("");
 * this work for additional information regarding copyright
    private final Set<String> includeKeys;
import java.util.regex.Pattern;
            Pattern pattern = Pattern.compile("(^([" + trim + "]+))|([" + trim + "]+$)");
        return excludeKeys;
        int limit = fields ? 0 : 2;
/**
package org.opensearch.ingest.common;
    private static Function<String, String[]> buildSplitter(String split, boolean fields) {
        execution.accept(document);
 * specific language governing permissions and limitations
    public static final String TYPE = "kv";
                valueSplit,
    private final boolean ignoreMissing;
            if (stripBrackets) {
    }
    private final String fieldSplit;
public final class KeyValueProcessor extends AbstractProcessor {
            if (fieldPathNullOrEmpty || document.hasField(path, true) == false) {
            final Function<String, String[]> fieldSplitter = buildSplitter(fieldSplit, true);
                    fieldPathPrefix = keyPrefix;
                keyFilter = key -> excludeKeys.contains(key) == false;
            return val -> pattern.matcher(val).replaceAll("");
    private final TemplateScript.Factory field;
        String prefix
                fieldTemplate,
            Function<String, String[]> valueSplitter = buildSplitter(valueSplit, false);
                } else {
            prefix
            final String fieldPathPrefix;
 * Modifications Copyright OpenSearch Contributors. See
            List<String> excludeKeysList = ConfigurationUtils.readOptionalList(TYPE, processorTag, config, "exclude_keys");
    }
    }
                    return;
        return valueSplit;
import org.opensearch.script.ScriptService;
                ignoreMissing,
            String keyPrefix = prefix == null ? "" : prefix;
            valueSplit,
        return targetField;
            String path = document.renderTemplate(field);
        return includeKeys;
        boolean ignoreMissing,
                trimValue,
 * not use this file except in compliance with the License.
            } else {
                processorTag,
        ) throws Exception {
import org.opensearch.ingest.ConfigurationUtils;
        this.includeKeys = includeKeys;
            fieldSplit,
        }
            if (targetField != null) {
/*
                if (ignoreMissing) {
        @Override
        return ignoreMissing;
                String key = keyTrimmer.apply(kv[0]);
        final Predicate<String> keyFilter;
    private static void append(IngestDocument document, String targetField, String value) {
            }
                throw new IllegalArgumentException("field [" + path + "] is null, cannot extract key-value pairs. ");
            String valueSplit = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "value_split");
                prefix
                if (kv.length != 2) {
            includeKeys,
import org.opensearch.core.common.Strings;
        return field;
            String fieldSplit = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "field_split");
 * software distributed under the License is distributed on an
 */
            final Function<String, String> keyTrimmer = buildTrimmer(trimKey);
    }
            String targetField = ConfigurationUtils.readOptionalStringProperty(TYPE, processorTag, config, "target_field");
        }
    private final String valueSplit;
        String valueSplit,
                }
                keyFilter = key -> includeKeys.contains(key) && excludeKeys.contains(key) == false;
        Set<String> includeKeys,
            Pattern splitPattern = Pattern.compile(split);
                }
            if (value == null) {
    }
        return TYPE;
            for (String part : fieldSplitter.apply(value)) {
        public Factory(ScriptService scriptService) {
                targetFieldTemplate = ConfigurationUtils.compileTemplate(TYPE, processorTag, "target_field", targetField, scriptService);
        Set<String> excludeKeys,
    }
import java.util.Set;
        if (includeKeys == null) {
        TemplateScript.Factory targetField,
        return fieldSplit;
        String valueSplit,
 */
import org.opensearch.script.TemplateScript;
            final boolean fieldPathNullOrEmpty = Strings.isNullOrEmpty(path);
        boolean stripBrackets,
            }
import java.util.Map;
        };
            excludeKeys,
 * the Apache License, Version 2.0 (the "License"); you may
        if (split.length() > 2 || split.length() == 2 && split.charAt(0) != '\\') {
import org.opensearch.ingest.Processor;
                excludeKeys = Collections.unmodifiableSet(Sets.newHashSet(excludeKeysList));
}
    @Override
    private final TemplateScript.Factory targetField;
                if (keyFilter.test(key)) {
            return val -> val.split(split, limit);
        this.fieldSplit = fieldSplit;
        String prefix
 *
import java.util.List;
            if (excludeKeys == null) {
        String trimValue,
            return val -> splitPattern.split(val, limit);
            if (excludeKeysList != null) {
        public KeyValueProcessor create(
import java.util.function.Consumer;
        String trimKey,
 * compatible open source license.
 * You may obtain a copy of the License at
            this.scriptService = scriptService;
    }
    private static final Pattern STRIP_BRACKETS = Pattern.compile("(^[\\(\\[<\"'])|([\\]\\)>\"']$)");
    TemplateScript.Factory getTargetField() {
            final Function<String, String> valueTrimmer = buildTrimmer(trimValue);
            String prefix = ConfigurationUtils.readOptionalStringProperty(TYPE, processorTag, config, "prefix");
    }
            document.appendFieldValue(targetField, value);
            List<String> includeKeysList = ConfigurationUtils.readOptionalList(TYPE, processorTag, config, "include_keys");
 *
        } else {
            }
        } else {
            String value = document.getFieldValue(path, String.class, ignoreMissing);
        TemplateScript.Factory field,
import org.opensearch.common.util.set.Sets;
                }
            final Function<String, String> keyPrefixer;
                String[] kv = valueSplitter.apply(part);
            Map<String, Object> config
                if (ignoreMissing) {
            String field = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "field");
            }
import java.util.Collections;
        private final ScriptService scriptService;
 *
 * under the License.
 * The OpenSearch Contributors require contributions made to
                    throw new IllegalArgumentException("field path cannot be null nor empty");
            } else {
        super(tag, description);
 *    http://www.apache.org/licenses/LICENSE-2.0
    public IngestDocument execute(IngestDocument document) {
                stripBrackets,
        this.execution = buildExecution(
            Map<String, Processor.Factory> registry,
    }
    TemplateScript.Factory getField() {
 * The KeyValueProcessor parses and extracts messages of the `key=value` variety into fields with values of the keys.
 * this file be licensed under the Apache-2.0 license or a
                }
            document.setFieldValue(targetField, value);
        }
            }
            String processorTag,
                } else if (fieldPathNullOrEmpty) {
                description,
        String tag,
                fieldPathPrefix = keyPrefix;
        this.valueSplit = valueSplit;
import org.opensearch.ingest.IngestDocument;
                keyFilter = includeKeys::contains;
    private final Set<String> excludeKeys;
                excludeKeys,
                    throw new IllegalArgumentException("field [" + path + "] doesn't exist");
    private static Consumer<IngestDocument> buildExecution(
 * GitHub history for details.
        TemplateScript.Factory field,
            targetField,
        return document -> {
    @Override
import java.util.function.Predicate;
 */
            boolean stripBrackets = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "strip_brackets", false);
            Set<String> includeKeys = null;
    }
    }
    String getValueSplit() {
 * license agreements. See the NOTICE file distributed with
    String getFieldSplit() {
        this.targetField = targetField;
                if (!Strings.isNullOrEmpty((targetFieldPath))) {
                String targetFieldPath = document.renderTemplate(targetField);
            trimValue,
            if (!Strings.isNullOrEmpty(targetField)) {
            } else {
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.ingest.AbstractProcessor;
        }
                    return;
/*
    }
        if (document.hasField(targetField)) {
    Set<String> getExcludeKeys() {
                } else {
        this.field = field;
 * ownership. Elasticsearch licenses this file to you under
            } else {
            }
            boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "ignore_missing", false);
import java.util.function.Function;
            ignoreMissing,
            trimKey,
        Set<String> includeKeys,
        boolean ignoreMissing,
        this.excludeKeys = excludeKeys;
                    throw new IllegalArgumentException("field [" + path + "] does not contain value_split [" + valueSplit + "]");
            String trimKey = ConfigurationUtils.readOptionalStringProperty(TYPE, processorTag, config, "trim_key");
            Set<String> excludeKeys = null;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    boolean isIgnoreMissing() {
            );
            }
