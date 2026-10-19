        return overrideTarget;  
    boolean isOverrideTarget() {
        String description,
        }
                scriptService  
 *
    boolean isIgnoreMissing() {
        // We fail here if the target field point to an array slot that is out of range.
 * Modifications Copyright OpenSearch Contributors. See
    @Override  
        @Override  
        return ignoreMissing;
import org.opensearch.ingest.Processor;
 * Unless required by applicable law or agreed to in writing,
        boolean ignoreMissing,
            // setting the value back to the original field shouldn't as we just fetched it from that field:
        TemplateScript.Factory field,
    ) {  
            if (ignoreMissing) {
 */  
        String path = document.renderTemplate(field);
                return document;  
        if (fieldPathIsNullOrEmpty || document.hasField(path, true) == false) {
    }
    }  
        try {
        String tag,  
        // If we didn't do this then we would fail if we set the value in the target_field
    private final boolean ignoreMissing;
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    }
        return field;  
    @Override
}
 * under the License.  
        TemplateScript.Factory targetField,  
import org.opensearch.core.common.Strings;
            String targetField = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "target_field");  
            throw e;  
 * this work for additional information regarding copyright
        boolean overrideTarget
        this.overrideTarget = overrideTarget;
/**
 * the Apache License, Version 2.0 (the "License"); you may
        return TYPE;
 *  
import org.opensearch.script.ScriptService;  
/*  
        final boolean fieldPathIsNullOrEmpty = Strings.isNullOrEmpty(path);  
        document.removeField(path);  
    }  
 * compatible open source license.
            String processorTag,  
            boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "ignore_missing", false);
        return document;
import org.opensearch.ingest.IngestDocument;
            throw new IllegalArgumentException("field [" + target + "] already exists");
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
        // removed it. If the target field is out of range, we throw the exception no matter
        super(tag, description);
        }  
        }  
                processorTag,  
import org.opensearch.ingest.AbstractProcessor;
 * Processor that allows to rename existing fields. Will throw exception if the field is not present.  
        // what the parameter overrideTarget is.
    public String getType() {  
        public Factory(ScriptService scriptService) {
 */
 * software distributed under the License is distributed on an
    RenameProcessor(
 */
            String description,
        public RenameProcessor create(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Object value = document.getFieldValue(path, Object.class);
            } else if (fieldPathIsNullOrEmpty) {
        // and then on failure processors would not see that value we tried to rename as we already  
    }
            boolean overrideTarget = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "override_target", false);  
        } catch (Exception e) {  
                throw new IllegalArgumentException("field path cannot be null nor empty");
            );
 * ownership. Elasticsearch licenses this file to you under  
            TemplateScript.Factory targetFieldTemplate = ConfigurationUtils.compileTemplate(
                throw new IllegalArgumentException("field [" + path + "] doesn't exist");
 */  
    public IngestDocument execute(IngestDocument document) {
 * this file be licensed under the Apache-2.0 license or a
        }
    }  
import org.opensearch.script.TemplateScript;
package org.opensearch.ingest.common;
            Map<String, Processor.Factory> registry,
 * SPDX-License-Identifier: Apache-2.0
        ) throws Exception {  
            String field = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "field");
        this.ignoreMissing = ignoreMissing;
import java.util.Map;  
            document.setFieldValue(target, value);
        this.targetField = targetField;  
    public static final String TYPE = "rename";
            return new RenameProcessor(processorTag, description, fieldTemplate, targetFieldTemplate, ignoreMissing, overrideTarget);
                targetField,
 *
    public static final class Factory implements Processor.Factory {
            document.setFieldValue(path, value);
public final class RenameProcessor extends AbstractProcessor {
import org.opensearch.ingest.ConfigurationUtils;  
 * KIND, either express or implied.  See the License for the
    private final TemplateScript.Factory field;  
/*  
 * GitHub history for details.
            } else {  
        String target = document.renderTemplate(targetField);  
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
        private final ScriptService scriptService;  
        if (document.hasField(target, true) && !overrideTarget) {
            this.scriptService = scriptService;  
 * not use this file except in compliance with the License.
    TemplateScript.Factory getTargetField() {  
 * You may obtain a copy of the License at  
    TemplateScript.Factory getField() {
/*
                "target_field",
    private final boolean overrideTarget;  
        }
            }
        return targetField;
        this.field = field;
            TemplateScript.Factory fieldTemplate = ConfigurationUtils.compileTemplate(TYPE, processorTag, "field", field, scriptService);
                TYPE,
            Map<String, Object> config
    private final TemplateScript.Factory targetField;
