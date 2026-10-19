 * compatible open source license.
            String field = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "field");  
 * parts are discarded. If fewer parts exist than target fields, the surplus target fields  
import org.opensearch.ingest.ConfigurationUtils;
 * SPDX-License-Identifier: Apache-2.0
        return TYPE;
            return new SplitToFieldsProcessor(processorTag, description, field, separator, targetFields, ignoreMissing, preserveTrailing);
        }
/*  
        boolean ignoreMissing,
    String getField() {  
            return document;
        this.preserveTrailing = preserveTrailing;  
    }
 * Processor that splits a field's string value by a separator and distributes the resulting
    }
    }  
        this.separator = separator;  
        @Override
            throw new IllegalArgumentException("field [" + field + "] is null, cannot split.");  
    private final String field;
        boolean preserveTrailing
        String description,  
        String oldVal = document.getFieldValue(field, String.class, ignoreMissing);
}
        public SplitToFieldsProcessor create(  
            boolean preserveTrailing = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "preserve_trailing", false);
import org.opensearch.ingest.IngestDocument;  
        return preserveTrailing;
    }  
    public String getType() {  
        ) throws Exception {
            List<String> targetFields = ConfigurationUtils.readList(TYPE, processorTag, config, "target_fields");
    private final String separator;
    private final boolean ignoreMissing;
 */  
        return field;
        int limit = Math.min(parts.length, targetFields.size());
        if (oldVal == null && ignoreMissing) {  
 */
    }
        return separator;
    @Override
    }
            Map<String, Processor.Factory> registry,
        } else if (oldVal == null) {
        this.targetFields = targetFields;
        this.field = field;
    boolean isPreserveTrailing() {
            String description,  
        String field,
import org.opensearch.ingest.Processor;
/**  
    }
        this.ignoreMissing = ignoreMissing;
            document.setFieldValue(targetFields.get(i), parts[i]);  
    public static final String TYPE = "split_to_fields";
    private final boolean preserveTrailing;
 *
            String separator = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "separator");
            Map<String, Object> config
        }  
            boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "ignore_missing", false);  
import org.opensearch.ingest.AbstractProcessor;
            String processorTag,
    boolean isIgnoreMissing() {  
    SplitToFieldsProcessor(
        return ignoreMissing;
        }
    List<String> getTargetFields() {
        return targetFields;  
 * are left untouched.
    public static class Factory implements Processor.Factory {
    private final List<String> targetFields;  
        List<String> targetFields,  
 * The OpenSearch Contributors require contributions made to  
        for (int i = 0; i < limit; i++) {
        String tag,
        super(tag, description);
    @Override
 * this file be licensed under the Apache-2.0 license or a
public final class SplitToFieldsProcessor extends AbstractProcessor {  
package org.opensearch.ingest.common;
    }  
    public IngestDocument execute(IngestDocument document) {  
 * parts into user-specified target fields. If more parts exist than target fields, the extra
    ) {  
import java.util.List;  
        String[] parts = oldVal.split(separator, preserveTrailing ? -1 : 0);  
        return document;
    }
    String getSeparator() {
        String separator,
import java.util.Map;
