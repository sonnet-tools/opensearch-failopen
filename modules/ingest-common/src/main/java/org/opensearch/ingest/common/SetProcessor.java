            String description,  
        this(tag, description, field, value, true, false);
 * Processor that adds new fields with their corresponding values. If the field is already present, its value  
    }
public final class SetProcessor extends AbstractProcessor {  
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
        @Override
    @Override
package org.opensearch.ingest.common;
            String processorTag,
 * ownership. Elasticsearch licenses this file to you under  
        this.value = value;  
 * under the License.  
            boolean ignoreEmptyValue = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "ignore_empty_value", false);
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * compatible open source license.
import java.util.Map;  
    }
        this.ignoreEmptyValue = ignoreEmptyValue;
            this.scriptService = scriptService;
        String description,  
 */  
        return field;  
            return new SetProcessor(
}  
        ValueSource value,
                overrideEnabled,
            document.setFieldValue(field, value, ignoreEmptyValue);
/*  
            );  
 */  
                ValueSource.wrap(value, scriptService),  
    }
        }  
 * will be replaced with the provided one.
            Object value = ConfigurationUtils.readObject(TYPE, processorTag, config, "value");
import org.opensearch.ingest.IngestDocument;  
    }
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 * SPDX-License-Identifier: Apache-2.0
 *  
    public String getType() {
 * GitHub history for details.
 */
            boolean overrideEnabled = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "override", true);
 * Modifications Copyright OpenSearch Contributors. See
            Map<String, Processor.Factory> registry,
            Map<String, Object> config
            TemplateScript.Factory compiledTemplate = ConfigurationUtils.compileTemplate(TYPE, processorTag, "field", field, scriptService);  
import org.opensearch.ingest.AbstractProcessor;
 * this file be licensed under the Apache-2.0 license or a
        public SetProcessor create(  
    public IngestDocument execute(IngestDocument document) {  
    public TemplateScript.Factory getField() {
        return document;
    public static final String TYPE = "set";
/**
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
        public Factory(ScriptService scriptService) {
    }  
        this.field = field;
                description,
    private final boolean overrideEnabled;
        ) throws Exception {
        TemplateScript.Factory field,
 * software distributed under the License is distributed on an
                processorTag,  
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
 *
        }
import org.opensearch.script.TemplateScript;
        this.overrideEnabled = overrideEnabled;
import org.opensearch.ingest.ConfigurationUtils;
                ignoreEmptyValue
    private final TemplateScript.Factory field;
    private final boolean ignoreEmptyValue;
    SetProcessor(String tag, String description, TemplateScript.Factory field, ValueSource value) {  
        boolean overrideEnabled,  
    }
        String tag,
    SetProcessor(
 * specific language governing permissions and limitations
/*  
            String field = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "field");  
 * not use this file except in compliance with the License.
        return overrideEnabled;
 */
    ) {
import org.opensearch.ingest.Processor;
import org.opensearch.script.ScriptService;  
        boolean ignoreEmptyValue
        }  
    public boolean isIgnoreEmptyValue() {
        super(tag, description);  
        return TYPE;  
    @Override
    }  
import org.opensearch.ingest.ValueSource;
    private final ValueSource value;  
        private final ScriptService scriptService;
 * The OpenSearch Contributors require contributions made to  
        return value;
    }
    public static final class Factory implements Processor.Factory {  
    public ValueSource getValue() {  
    public boolean isOverrideEnabled() {
        if (overrideEnabled || document.hasField(field) == false || document.getFieldValue(field, Object.class) == null) {
        return ignoreEmptyValue;
                compiledTemplate,
