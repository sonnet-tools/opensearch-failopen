                }
import org.opensearch.common.Nullable;
        return fields;
                case "SHA-1@2.16.0":
        String description,
import java.util.stream.Collectors;
        }
     *         "c": 2
        String hashMethod,
        this.ignoreMissing = ignoreMissing;
    // fields used to generate hash value
        final StringBuilder concatenatedFields = new StringBuilder();
    }
    private final String targetField;
            if (entry.getValue() instanceof Map<?, ?>) {
                case "MD5@2.16.0":
import org.opensearch.ingest.AbstractProcessor;
    public String getTargetField() {
    // this processor is introduced in 2.16.0, we append the OpenSearch version to the hash method name to ensure
    public List<String> getExcludeFields() {
 * The OpenSearch Contributors require contributions made to
                        .append(entry.getKey())
                .filter(field -> !metadataFields.contains(field) && !excludeFields.contains(field))
        HashMethod(Supplier<MessageDigest> messageDigestSupplier) {
                    TYPE,
            if (fields != null && !fields.isEmpty()) {
                throw newConfigurationException(
                    "hash_method",
                        .append(".")
        return excludeFields;
        } else if (excludeFields != null && !excludeFields.isEmpty()) {
        final List<String> sortedFields;
     */
                    return SHA1.messageDigestSupplier.get();
    public String getType() {
                @SuppressWarnings("unchecked")
                    return null;
            return new FingerprintProcessor(processorTag, description, fields, excludeFields, targetField, hashMethod, ignoreMissing);
            String targetField = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "target_field", "fingerprint");
        this.targetField = targetField;
                    processorTag,
        // via the supplier instead of caching one that would be shared across all ingest threads.
public final class FingerprintProcessor extends AbstractProcessor {
    /**
            switch (name) {
 */
        assert (!sortedFields.isEmpty());
    enum HashMethod {
        if (concatenatedFields.length() == 0) {
import java.security.MessageDigest;
            return document;
            }
 */
    }
     * @return a flattened map which has only one level fields
        document.setFieldValue(targetField, hashMethod + ":" + Base64.getEncoder().encodeToString(messageDigest.digest()));
     * }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
    public String getHashMethod() {
     * The supported hash methods used to generate hash value
    private static final Set<String> HASH_METHODS = Set.of("MD5@2.16.0", "SHA-1@2.16.0", "SHA-256@2.16.0", "SHA3-256@2.16.0");
                );
import java.util.HashMap;
            if (value instanceof Map<?, ?>) {
            sortedFields = existingFields.stream().filter(field -> !metadataFields.contains(field)).sorted().collect(Collectors.toList());
            }
            String name = methodName.toUpperCase(Locale.ROOT);
        SHA256(MessageDigests::sha256),
            }
            Map<String, Object> config
import org.opensearch.core.common.Strings;
import java.util.Set;
        return targetField;
            String description,
                );
                case "SHA3-256@2.16.0":
    ) {
            String processorTag,
                    return;
 * compatible open source license.
        sortedFields.forEach(field -> {
                        .append(":")
                flattenedMap.put(entry.getKey(), entry.getValue());
        assert (messageDigest != null);
 * SPDX-License-Identifier: Apache-2.0
                throw newConfigurationException(TYPE, processorTag, "exclude_fields", "field name cannot be null nor empty");
    FingerprintProcessor(
    // all fields other than the excluded fields are used to generate hash value
 * Processor that generating hash value for the specified fields or fields not in the specified excluded list
import java.util.List;
                        .append(fieldValue.length())
        public static MessageDigest fromMethodName(String methodName) {
        return TYPE;
            } else {
        }
    @Override
    private final List<String> excludeFields;
     *         "b": 1,
        return ignoreMissing;
                });
                    throw new IllegalArgumentException("field [" + field + "] doesn't exist");
            sortedFields = fields.stream()
        }
        String tag,
            .stream()
            }
            .collect(Collectors.toSet());
            } else {
        }
            }
        String targetField,
     * {
    private Map<String, Object> toFlattenedMap(Map<String, Object> map) {
            List<String> excludeFields = ConfigurationUtils.readOptionalList(TYPE, processorTag, config, "exclude_fields");
        if (!HASH_METHODS.contains(hashMethod.toUpperCase(Locale.ROOT))) {
        return hashMethod;
                }
            throw new IllegalArgumentException("hash method must be MD5@2.16.0, SHA-1@2.16.0 or SHA-256@2.16.0 or SHA3-256@2.16.0");
import org.opensearch.ingest.Processor;
     *     }
import org.opensearch.ingest.IngestDocument;
     * {
        });
        public FingerprintProcessor create(
                flattenedMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> {
                    throw newConfigurationException(TYPE, processorTag, "fields", "field name cannot be null nor empty");
        } else {
    private final boolean ignoreMissing;
        this.hashMethod = hashMethod;
    }
            List<String> fields = ConfigurationUtils.readOptionalList(TYPE, processorTag, config, "fields");
    public static final class Factory implements Processor.Factory {
     *     "a.b": 1,
                .collect(Collectors.toList());
                } else {
        boolean ignoreMissing
                .collect(Collectors.toList());
            final Object value = document.getFieldValue(field, Object.class);
        MessageDigest messageDigest = HashMethod.fromMethodName(hashMethod);
        // MessageDigest is not thread-safe, so resolve a fresh per-call (ThreadLocal-backed) instance
        // if all specified fields don't exist and ignore_missing is true, then do nothing
                default:
        return flattenedMap;
    }
            }
        }
     * for example, if the original map is
    }
        }
                throw new IllegalArgumentException("either fields or exclude_fields can be set");
    public IngestDocument execute(IngestDocument document) {
                    (key, value) -> flattenedMap.put(entry.getKey() + "." + key, value)
        SHA3256(MessageDigests::sha3256);
    private final String hashMethod;
/*
    }
        concatenatedFields.append("|");
     * @param map the original map which may contain nested fields
        ) throws Exception {
    }
                        .append("|")
                    concatenatedFields.append("|")
        @Nullable List<String> fields,
 * this file be licensed under the Apache-2.0 license or a
        this.excludeFields = excludeFields;
            String hashMethod = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "hash_method", "SHA-1@2.16.0");
    public List<String> getFields() {
        }
    private final List<String> fields;
        if (fields != null && !fields.isEmpty()) {
    // the target field to store the hash value, defaults to fingerprint
 *
import java.util.Locale;
                String fieldValue = String.valueOf(value);
        messageDigest.update(concatenatedFields.toString().getBytes(StandardCharsets.UTF_8));
        SHA1(MessageDigests::sha1),
    /**
            .map(IngestDocument.Metadata::getFieldName)
import java.util.Map;
    @Override
                        .append(fieldValue);
     */
                    return SHA256.messageDigestSupplier.get();
                    throw newConfigurationException(TYPE, processorTag, "fields", "either fields or exclude_fields can be set");
            boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "ignore_missing", false);
    public static final String TYPE = "fingerprint";
        MD5(MessageDigests::md5),
                throw new IllegalArgumentException("field name in [fields] cannot be null nor empty");
        private final Supplier<MessageDigest> messageDigestSupplier;
        @Override
                }
                    return SHA3256.messageDigestSupplier.get();
                    "hash method must be MD5@2.16.0, SHA-1@2.16.0, SHA-256@2.16.0 or SHA3-256@2.16.0"
        Map<String, Object> flattenedMap = new HashMap<>();
     * }, then the converted map is
        if (fields != null && !fields.isEmpty()) {
/**
        Set<String> existingFields = new HashSet<>(document.getSourceAndMetadata().keySet());
                case "SHA-256@2.16.0":
    }
        return document;
            }
                .filter(field -> !metadataFields.contains(field))
    // hash method used to generate the hash value, defaults to SHA-1
            if (!document.hasField(field)) {
import java.nio.charset.StandardCharsets;
            }
        if (excludeFields != null && !excludeFields.isEmpty() && excludeFields.stream().anyMatch(Strings::isNullOrEmpty)) {
            if (excludeFields != null && !excludeFields.isEmpty() && excludeFields.stream().anyMatch(Strings::isNullOrEmpty)) {
                .distinct()
    }
            throw new IllegalArgumentException("field name in [exclude_fields] cannot be null nor empty");
    // that this processor always generates same hash value based on a specific hash method, if the processing logic
                        .append(field)
        this.fields = fields;
            if (!HASH_METHODS.contains(hashMethod.toUpperCase(Locale.ROOT))) {
                if (fields.stream().anyMatch(Strings::isNullOrEmpty)) {
        @Nullable List<String> excludeFields,
    }
                toFlattenedMap((Map<String, Object>) entry.getValue()).forEach(
        }
        // we should deduplicate and sort the field names to make sure we can get consistent hash value
     * Convert a map containing nested fields to a flattened map,
     *     "a": {
import org.opensearch.ingest.ConfigurationUtils;
                .sorted()
                if (ignoreMissing) {
import java.util.function.Supplier;
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
            if (excludeFields != null && !excludeFields.isEmpty()) {
            if (fields.stream().anyMatch(Strings::isNullOrEmpty)) {
import java.util.HashSet;
import org.opensearch.common.hash.MessageDigests;
    }
        // metadata fields such as _index, _id and _routing are ignored
            }
            sortedFields = existingFields.stream()
package org.opensearch.ingest.common;
            Map<String, Processor.Factory> registry,
                if (excludeFields != null && !excludeFields.isEmpty()) {
            this.messageDigestSupplier = messageDigestSupplier;
    @SuppressWarnings("unchecked")
                Map<String, Object> flattenedMap = toFlattenedMap((Map<String, Object>) value);
}
        }
                    return MD5.messageDigestSupplier.get();
                concatenatedFields.append("|").append(field).append("|").append(fieldValue.length()).append(":").append(fieldValue);
    public boolean isIgnoreMissing() {
    // of this processor changes in future version, the version number in the hash method should be increased correspondingly.
        Set<String> metadataFields = document.getMetadata()
                    String fieldValue = String.valueOf(entry.getValue());
     *     "a.c": 2
                .sorted()
        super(tag, description);
import java.util.Base64;
            .keySet()
