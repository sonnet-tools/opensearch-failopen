            } else if (sourceFieldPathIsNullOrEmpty) {
        ) throws Exception {
        final boolean sourceFieldPathIsNullOrEmpty = Strings.isNullOrEmpty(source);
    public TemplateScript.Factory getSourceField() {
    public static final String TYPE = "copy";  
    public String getType() {
        boolean removeSource,  
                processorTag,
            if (ignoreMissing) {  
import org.opensearch.script.TemplateScript;
    public boolean isRemoveSource() {
        TemplateScript.Factory targetField,
                scriptService
        if (sourceFieldPathIsNullOrEmpty || document.hasField(source, true) == false) {
        return overrideTarget;
        this.overrideTarget = overrideTarget;
        if (removeSource) {  
            String sourceField = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "source_field");  
            Map<String, Processor.Factory> registry,
            }  
    public static final class Factory implements Processor.Factory {  
                description,
    @Override
        }  
        this(tag, description, sourceField, targetField, false, false, false);  
                throw new IllegalArgumentException("source field path cannot be null nor empty");  
import java.util.Map;  
            this.scriptService = scriptService;
            String targetField = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "target_field");
 * The OpenSearch Contributors require contributions made to  
    ) {
        return TYPE;  
 * this file be licensed under the Apache-2.0 license or a
 *
        super(tag, description);  
        return sourceField;  
        TemplateScript.Factory sourceField,  
                ignoreMissing,
    }
                "target_field",  
    }
                sourceFieldTemplate,
 * SPDX-License-Identifier: Apache-2.0
    public boolean isIgnoreMissing() {
        }  
        return document;
        this.ignoreMissing = ignoreMissing;  
import org.opensearch.script.ScriptService;  
        }
            throw new IllegalArgumentException("source field path and target field path cannot be same");
    }
        }
            String description,  
            );  
            TemplateScript.Factory sourceFieldTemplate = ConfigurationUtils.compileTemplate(
            TemplateScript.Factory targetFieldTemplate = ConfigurationUtils.compileTemplate(  
    }  
                TYPE,
    }
                TYPE,
                targetFieldTemplate,  
    }
import org.opensearch.ingest.IngestDocument;
    @Override
    CopyProcessor(String tag, String description, TemplateScript.Factory sourceField, TemplateScript.Factory targetField) {
    private final boolean overrideTarget;  
            return new CopyProcessor(
                removeSource,
        this.removeSource = removeSource;
        }  
            document.setFieldValue(target, IngestDocument.deepCopy(sourceValue));
            String processorTag,
            throw new IllegalArgumentException("target field path cannot be null nor empty");
    }
                processorTag,  
            boolean overrideTarget = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "override_target", false);  
        }
        public Factory(ScriptService scriptService) {
import org.opensearch.ingest.AbstractProcessor;
    private final TemplateScript.Factory targetField;  
    private final boolean ignoreMissing;
    }  
            Map<String, Object> config
        boolean overrideTarget
    CopyProcessor(  
        String source = document.renderTemplate(sourceField);  
            throw new IllegalArgumentException("target field [" + target + "] already exists");  
    }
 * compatible open source license.
        if (overrideTarget || document.hasField(target, true) == false || document.getFieldValue(target, Object.class) == null) {
            } else {
 */  
public final class CopyProcessor extends AbstractProcessor {
                scriptService  
        String target = document.renderTemplate(targetField);  
        @Override
    private final boolean removeSource;
                processorTag,  
    }  
        return targetField;
    public IngestDocument execute(IngestDocument document) {
    public TemplateScript.Factory getTargetField() {  
            );
/*  
        if (Strings.isNullOrEmpty(target)) {
                targetField,
}
        boolean ignoreMissing,
                sourceField,
        private final ScriptService scriptService;
        String tag,
        }
        String description,
    public boolean isOverrideTarget() {  
        return removeSource;  
        return ignoreMissing;
        this.sourceField = sourceField;
import org.opensearch.core.common.Strings;
            );
import org.opensearch.ingest.ConfigurationUtils;  
            boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "ignore_missing", false);
                overrideTarget  
        } else {
    private final TemplateScript.Factory sourceField;
        if (source.equals(target)) {
import org.opensearch.ingest.Processor;
package org.opensearch.ingest.common;
                "source_field",
        public CopyProcessor create(  
            Object sourceValue = document.getFieldValue(source, Object.class);  
            boolean removeSource = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "remove_source", false);
                return document;
            document.removeField(source);
        this.targetField = targetField;
                throw new IllegalArgumentException("source field [" + source + "] doesn't exist");
