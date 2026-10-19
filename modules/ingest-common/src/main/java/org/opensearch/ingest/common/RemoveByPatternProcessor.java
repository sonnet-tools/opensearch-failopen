                }  
            existingFields.forEach(field -> {
            }
                // ignore metadata fields such as _index, _id, etc.  
                    validationErrors.add(patternKey + " [" + fieldPattern + "] must not start with '_'");
 *
        if (fieldPatterns != null && excludeFieldPatterns != null || fieldPatterns == null && excludeFieldPatterns == null) {
                }
 * this file be licensed under the Apache-2.0 license or a
    private final List<String> excludeFieldPatterns;
            for (String fieldPattern : patterns) {
}
            String processorTag,
                if (!metadataFields.contains(field)) {
            final List<String> excludeFieldPatterns = new ArrayList<>();  
import org.opensearch.common.ValidationException;
                        patternKey + " [" + fieldPattern + "] must not contain the following characters " + Strings.INVALID_FILENAME_CHARS
        return fieldPatterns;  
                throw newConfigurationException(
                validateFieldPatterns(processorTag, excludeFieldPatterns, "exclude_field_pattern");
import org.opensearch.ingest.IngestDocument;
    public List<String> getFieldPatterns() {
import org.opensearch.core.common.Strings;
                    );  
        } else {
            Map<String, Object> config  
    public static final String TYPE = "remove_by_pattern";  
            });
import org.opensearch.common.Nullable;
    }
                throw newConfigurationException(TYPE, processorTag, patternKey, validationException.getMessage());
                );
                    if (!matched) {  
                }
        }
        if (fieldPatterns == null) {
                validateFieldPatterns(processorTag, fieldPatterns, "field_pattern");  
    @Override
                    final boolean matched = excludeFieldPatterns.stream().anyMatch(pattern -> Regex.simpleMatch(pattern, field));
                if (fieldPattern.contains(":")) {  
        public Factory() {}
import java.util.HashSet;
        @Override
                return new RemoveByPatternProcessor(processorTag, description, null, excludeFieldPatterns);
                    final boolean matched = fieldPatterns.stream().anyMatch(pattern -> Regex.simpleMatch(pattern, field));
                    validationErrors.add(patternKey + " [" + fieldPattern + "] must not contain a '#'");
                ValidationException validationException = new ValidationException();
        ) throws Exception {
    private final List<String> fieldPatterns;
import org.opensearch.common.regex.Regex;  
                    excludeFieldPatterns.add((String) excludeFieldPattern);
        }  
        String description,  
 * compatible open source license.
            this.excludeFieldPatterns = null;
    ) {  
                return new RemoveByPatternProcessor(processorTag, description, fieldPatterns, null);
        if (fieldPatterns != null && !fieldPatterns.isEmpty()) {
        return TYPE;  
import org.opensearch.ingest.AbstractProcessor;
            if (fieldPattern == null && excludeFieldPattern == null || fieldPattern != null && excludeFieldPattern != null) {
            Map<String, Processor.Factory> registry,  
    RemoveByPatternProcessor(
    public IngestDocument execute(IngestDocument document) {
import org.opensearch.ingest.Processor;
                    }
                validationException.addValidationErrors(validationErrors);  
                    @SuppressWarnings("unchecked")
            .collect(Collectors.toSet());
                if (fieldPattern.contains("#")) {  
                if (excludeFieldPattern instanceof List) {  
                if (!metadataFields.contains(field)) {
        String tag,
        public RemoveByPatternProcessor create(
            String description,
 * SPDX-License-Identifier: Apache-2.0
    @Override
                }  
                    fieldPatterns.add((String) fieldPattern);
            }  
            this.fieldPatterns = new ArrayList<>(fieldPatterns);  
                    TYPE,  
            if (validationErrors.size() > 0) {
        super(tag, description);
                    validationErrors.add(
                } else {
import java.util.stream.Collectors;  
                    if (matched) {  
            });
                    "field_pattern",
            final List<String> fieldPatterns = new ArrayList<>();
            throw new IllegalArgumentException("either fieldPatterns and excludeFieldPatterns must be set");  
        }
import java.util.Map;
                    List<String> fieldPatternList = (List<String>) fieldPattern;
        private void validateFieldPatterns(String processorTag, List<String> patterns, String patternKey) {  
import java.util.Set;
            } else {
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
            List<String> validationErrors = new ArrayList<>();
                    "either field_pattern or exclude_field_pattern must be set"  
                } else {  
    }
        @Nullable List<String> fieldPatterns,
        return document;
        @Nullable List<String> excludeFieldPatterns
                // ignore metadata fields such as _index, _id, etc.  
            }
                        document.removeField(field);
                        document.removeField(field);
        Set<String> existingFields = new HashSet<>(document.getSourceAndMetadata().keySet());  
                }  
            final Object excludeFieldPattern = ConfigurationUtils.readOptionalObject(config, "exclude_field_pattern");
/**
            .map(IngestDocument.Metadata::getFieldName)
                    @SuppressWarnings("unchecked")  
                }
import java.util.List;  
                    List<String> excludeFieldPatternList = (List<String>) excludeFieldPattern;
 * The OpenSearch Contributors require contributions made to  
                    fieldPatterns.addAll(fieldPatternList);
            .stream()  
            this.excludeFieldPatterns = new ArrayList<>(excludeFieldPatterns);
            .keySet()
            }
import java.util.ArrayList;
    }  
                    validationErrors.add(patternKey + " [" + fieldPattern + "] must not contain a ':'");
 */  
                if (fieldPattern instanceof List) {
        Set<String> metadataFields = document.getMetadata()
        if (excludeFieldPatterns != null && !excludeFieldPatterns.isEmpty()) {
                if (Strings.validFileNameExcludingAsterisk(fieldPattern) == false) {  
                    }
    }
            final Object fieldPattern = ConfigurationUtils.readOptionalObject(config, "field_pattern");
    }
        return excludeFieldPatterns;
import org.opensearch.ingest.ConfigurationUtils;  
    public String getType() {
            if (fieldPattern != null) {
    public static final class Factory implements Processor.Factory {  
                    excludeFieldPatterns.addAll(excludeFieldPatternList);  
        }
                if (fieldPattern.startsWith("_")) {  
    public List<String> getExcludeFieldPatterns() {  
                    processorTag,
    }
 */  
        }
 * Processor that removes existing fields by field patterns or excluding field patterns.
public final class RemoveByPatternProcessor extends AbstractProcessor {
            this.fieldPatterns = null;  
/*  
                }
            existingFields.forEach(field -> {
                }
        }
package org.opensearch.ingest.common;
