        super(tag, description);
                    if (matched) {
            for (String fieldPattern : patterns) {
    public IngestDocument execute(IngestDocument document) {
    }
                    fieldPatterns.add((String) fieldPattern);
        } else {
                }
                    }
import java.util.List;
import java.util.Set;
                        patternKey + " [" + fieldPattern + "] must not contain the following characters " + Strings.INVALID_FILENAME_CHARS
import java.util.stream.Collectors;
            if (validationErrors.size() > 0) {
        }
                if (!metadataFields.contains(field)) {
                }
    public String getType() {
                return new RemoveByPatternProcessor(processorTag, description, null, excludeFieldPatterns);
                    validationErrors.add(patternKey + " [" + fieldPattern + "] must not contain a '#'");
        @Nullable List<String> fieldPatterns,
            });
                throw newConfigurationException(TYPE, processorTag, patternKey, validationException.getMessage());
    }
        @Nullable List<String> excludeFieldPatterns
        }
            final Object excludeFieldPattern = ConfigurationUtils.readOptionalObject(config, "exclude_field_pattern");
}
        public RemoveByPatternProcessor create(
import org.opensearch.ingest.AbstractProcessor;
            this.excludeFieldPatterns = new ArrayList<>(excludeFieldPatterns);
                    fieldPatterns.addAll(fieldPatternList);
            }
import org.opensearch.common.Nullable;
                return new RemoveByPatternProcessor(processorTag, description, fieldPatterns, null);
 *
        Set<String> metadataFields = document.getMetadata()
            if (fieldPattern == null && excludeFieldPattern == null || fieldPattern != null && excludeFieldPattern != null) {
        return excludeFieldPatterns;
    private final List<String> fieldPatterns;
        return fieldPatterns;
                validateFieldPatterns(processorTag, fieldPatterns, "field_pattern");
        return TYPE;
            }
                // ignore metadata fields such as _index, _id, etc.
                    excludeFieldPatterns.addAll(excludeFieldPatternList);
                    );
import org.opensearch.common.regex.Regex;
/*
 * compatible open source license.
    }
        String description,
            final List<String> excludeFieldPatterns = new ArrayList<>();
                }
                if (fieldPattern.contains("#")) {
            existingFields.forEach(field -> {
                ValidationException validationException = new ValidationException();
            final Object fieldPattern = ConfigurationUtils.readOptionalObject(config, "field_pattern");
    RemoveByPatternProcessor(
        if (fieldPatterns != null && !fieldPatterns.isEmpty()) {
    @Override
            throw new IllegalArgumentException("either fieldPatterns and excludeFieldPatterns must be set");
import org.opensearch.ingest.ConfigurationUtils;
import org.opensearch.ingest.IngestDocument;
            this.excludeFieldPatterns = null;
        }
        }
                    final boolean matched = fieldPatterns.stream().anyMatch(pattern -> Regex.simpleMatch(pattern, field));
package org.opensearch.ingest.common;
                    validationErrors.add(patternKey + " [" + fieldPattern + "] must not start with '_'");
 * this file be licensed under the Apache-2.0 license or a
                if (fieldPattern.contains(":")) {
    public static final class Factory implements Processor.Factory {
            }
        if (fieldPatterns != null && excludeFieldPatterns != null || fieldPatterns == null && excludeFieldPatterns == null) {
    @Override
        @Override
        if (fieldPatterns == null) {
                throw newConfigurationException(
                    List<String> excludeFieldPatternList = (List<String>) excludeFieldPattern;
            .keySet()
    }
            if (fieldPattern != null) {
        if (excludeFieldPatterns != null && !excludeFieldPatterns.isEmpty()) {
            final List<String> fieldPatterns = new ArrayList<>();
                    TYPE,
            String processorTag,
                // ignore metadata fields such as _index, _id, etc.
                }
                if (fieldPattern.startsWith("_")) {
    }
 * The OpenSearch Contributors require contributions made to
                    processorTag,
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
                    "either field_pattern or exclude_field_pattern must be set"
            });
                        document.removeField(field);
            this.fieldPatterns = null;
                if (fieldPattern instanceof List) {
                        document.removeField(field);
        public Factory() {}
                } else {
                if (excludeFieldPattern instanceof List) {
        }
    ) {
    public static final String TYPE = "remove_by_pattern";
import java.util.Map;
            Map<String, Processor.Factory> registry,
            String description,
                    }
                }
    public List<String> getExcludeFieldPatterns() {
                if (!metadataFields.contains(field)) {
import org.opensearch.core.common.Strings;
            .map(IngestDocument.Metadata::getFieldName)
                if (Strings.validFileNameExcludingAsterisk(fieldPattern) == false) {
 * SPDX-License-Identifier: Apache-2.0
                    excludeFieldPatterns.add((String) excludeFieldPattern);
public final class RemoveByPatternProcessor extends AbstractProcessor {
        String tag,
    public List<String> getFieldPatterns() {
                    "field_pattern",
            }
    private final List<String> excludeFieldPatterns;
                } else {
import java.util.ArrayList;
        return document;
 * Processor that removes existing fields by field patterns or excluding field patterns.
    }
            Map<String, Object> config
                }
            existingFields.forEach(field -> {
        }
 */
            .collect(Collectors.toSet());
                    List<String> fieldPatternList = (List<String>) fieldPattern;
                    validationErrors.add(
import org.opensearch.ingest.Processor;
                validationException.addValidationErrors(validationErrors);
                    validationErrors.add(patternKey + " [" + fieldPattern + "] must not contain a ':'");
            this.fieldPatterns = new ArrayList<>(fieldPatterns);
import java.util.HashSet;
                }
            List<String> validationErrors = new ArrayList<>();
            } else {
 */
        private void validateFieldPatterns(String processorTag, List<String> patterns, String patternKey) {
                );
                validateFieldPatterns(processorTag, excludeFieldPatterns, "exclude_field_pattern");
/**
                    @SuppressWarnings("unchecked")
            .stream()
                }
import org.opensearch.common.ValidationException;
        ) throws Exception {
                    @SuppressWarnings("unchecked")
                    final boolean matched = excludeFieldPatterns.stream().anyMatch(pattern -> Regex.simpleMatch(pattern, field));
        Set<String> existingFields = new HashSet<>(document.getSourceAndMetadata().keySet());
                    if (!matched) {
