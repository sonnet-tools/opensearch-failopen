                case "MD5@2.16.0":  
        if (fields != null && !fields.isEmpty()) {
        messageDigest.update(concatenatedFields.toString().getBytes(StandardCharsets.UTF_8));
    }
        @Override  
            throw new IllegalArgumentException("field name in [exclude_fields] cannot be null nor empty");
                .distinct()  
 *
import org.opensearch.ingest.Processor;
    // the target field to store the hash value, defaults to fingerprint
            } else {  
                        .append(".")
    public String getHashMethod() {  
        MessageDigest messageDigest = HashMethod.fromMethodName(hashMethod);
import java.util.HashSet;
            this.messageDigestSupplier = messageDigestSupplier;  
import java.util.stream.Collectors;
        this.fields = fields;
        concatenatedFields.append("|");  
    private static final Set<String> HASH_METHODS = Set.of("MD5@2.16.0", "SHA-1@2.16.0", "SHA-256@2.16.0", "SHA3-256@2.16.0");
                }  
                });
                case "SHA3-256@2.16.0":  
 * Processor that generating hash value for the specified fields or fields not in the specified excluded list  
        }  
        SHA3256(MessageDigests::sha3256);
            switch (name) {
                    return SHA1.messageDigestSupplier.get();  
import java.util.List;
    public List<String> getFields() {  
        String tag,
    }
import org.opensearch.common.Nullable;
        Map<String, Object> flattenedMap = new HashMap<>();  
                .sorted()
                throw new IllegalArgumentException("either fields or exclude_fields can be set");
                throw newConfigurationException(  
                    throw newConfigurationException(TYPE, processorTag, "fields", "field name cannot be null nor empty");
import java.util.Base64;
                String fieldValue = String.valueOf(value);
        assert (messageDigest != null);  
        }
                case "SHA-256@2.16.0":
        boolean ignoreMissing
        public static MessageDigest fromMethodName(String methodName) {  
        } else if (excludeFields != null && !excludeFields.isEmpty()) {
            .map(IngestDocument.Metadata::getFieldName)
 * The OpenSearch Contributors require contributions made to  
        return TYPE;  
            }  
            if (fields != null && !fields.isEmpty()) {  
        SHA256(MessageDigests::sha256),
        sortedFields.forEach(field -> {  
            .stream()  
            }
     * for example, if the original map is
            }
                    throw new IllegalArgumentException("field [" + field + "] doesn't exist");
            List<String> excludeFields = ConfigurationUtils.readOptionalList(TYPE, processorTag, config, "exclude_fields");
            if (fields.stream().anyMatch(Strings::isNullOrEmpty)) {  
        this.ignoreMissing = ignoreMissing;  
    public boolean isIgnoreMissing() {
                    return null;  
    }
    }
            Map<String, Object> config
        }
import java.security.MessageDigest;
     *         "c": 2  
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;  
        return fields;
        this.targetField = targetField;
            sortedFields = existingFields.stream()
            final Object value = document.getFieldValue(field, Object.class);  
                .collect(Collectors.toList());  
                }  
    @Override
    private final String targetField;
        Set<String> metadataFields = document.getMetadata()
    // hash method used to generate the hash value, defaults to SHA-1  
                        .append(fieldValue.length())
    public List<String> getExcludeFields() {
    FingerprintProcessor(
    }
    private final List<String> excludeFields;  
public final class FingerprintProcessor extends AbstractProcessor {
                        .append(field)
    @Override
        // MessageDigest is not thread-safe, so resolve a fresh per-call (ThreadLocal-backed) instance
            if (!document.hasField(field)) {
    private final boolean ignoreMissing;
            if (excludeFields != null && !excludeFields.isEmpty()) {  
        if (concatenatedFields.length() == 0) {  
    @SuppressWarnings("unchecked")
        return ignoreMissing;
    }
            boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "ignore_missing", false);
    public static final class Factory implements Processor.Factory {
                default:
        if (!HASH_METHODS.contains(hashMethod.toUpperCase(Locale.ROOT))) {
            String hashMethod = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "hash_method", "SHA-1@2.16.0");
            sortedFields = fields.stream()
    public String getType() {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
     * @return a flattened map which has only one level fields
                .filter(field -> !metadataFields.contains(field) && !excludeFields.contains(field))  
import java.util.HashMap;  
    // all fields other than the excluded fields are used to generate hash value
import org.opensearch.common.hash.MessageDigests;
            }
                    return MD5.messageDigestSupplier.get();
    // this processor is introduced in 2.16.0, we append the OpenSearch version to the hash method name to ensure
}
    private final String hashMethod;
        // via the supplier instead of caching one that would be shared across all ingest threads.
                throw new IllegalArgumentException("field name in [fields] cannot be null nor empty");
            if (value instanceof Map<?, ?>) {
import org.opensearch.ingest.IngestDocument;  
/**
 * this file be licensed under the Apache-2.0 license or a
    }
                    throw newConfigurationException(TYPE, processorTag, "fields", "either fields or exclude_fields can be set");
                @SuppressWarnings("unchecked")
     * {  
            String name = methodName.toUpperCase(Locale.ROOT);
                        .append(entry.getKey())  
                );
     *     "a.c": 2
                    concatenatedFields.append("|")  
        }
                    processorTag,
        final List<String> sortedFields;
import java.util.Locale;  
        public FingerprintProcessor create(
     * Convert a map containing nested fields to a flattened map,
            if (!HASH_METHODS.contains(hashMethod.toUpperCase(Locale.ROOT))) {
            List<String> fields = ConfigurationUtils.readOptionalList(TYPE, processorTag, config, "fields");
            sortedFields = existingFields.stream().filter(field -> !metadataFields.contains(field)).sorted().collect(Collectors.toList());
     * {  
     * The supported hash methods used to generate hash value
            }
            String description,
     *         "b": 1,
     *     "a": {
        } else {  
            .collect(Collectors.toSet());
        }  
                } else {
                concatenatedFields.append("|").append(field).append("|").append(fieldValue.length()).append(":").append(fieldValue);
 */  
            return new FingerprintProcessor(processorTag, description, fields, excludeFields, targetField, hashMethod, ignoreMissing);
        if (excludeFields != null && !excludeFields.isEmpty() && excludeFields.stream().anyMatch(Strings::isNullOrEmpty)) {
    public static final String TYPE = "fingerprint";  
        String hashMethod,
                    TYPE,
    }  
        }  
        }  
        }
            String targetField = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "target_field", "fingerprint");  
                    return;  
     */  
                flattenedMap.put(entry.getKey(), entry.getValue());
                );
    ) {  
            }
        });
        return hashMethod;
                }  
        document.setFieldValue(targetField, hashMethod + ":" + Base64.getEncoder().encodeToString(messageDigest.digest()));
                flattenedMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> {
        return excludeFields;
        HashMethod(Supplier<MessageDigest> messageDigestSupplier) {
        assert (!sortedFields.isEmpty());  
                    return SHA3256.messageDigestSupplier.get();
                toFlattenedMap((Map<String, Object>) entry.getValue()).forEach(  
                Map<String, Object> flattenedMap = toFlattenedMap((Map<String, Object>) value);  
        @Nullable List<String> excludeFields,
                if (excludeFields != null && !excludeFields.isEmpty()) {
        // if all specified fields don't exist and ignore_missing is true, then do nothing
        @Nullable List<String> fields,
                    String fieldValue = String.valueOf(entry.getValue());
                        .append(":")  
     * }  
        private final Supplier<MessageDigest> messageDigestSupplier;  
            return document;
 * compatible open source license.
                    (key, value) -> flattenedMap.put(entry.getKey() + "." + key, value)
        ) throws Exception {  
                        .append(fieldValue);
    }  
                    "hash_method",  
        super(tag, description);
        final StringBuilder concatenatedFields = new StringBuilder();
            .keySet()
        return document;
            Map<String, Processor.Factory> registry,
        return flattenedMap;
package org.opensearch.ingest.common;
import java.util.Map;
import java.util.Set;
/*  
     * @param map the original map which may contain nested fields
            } else {  
                .collect(Collectors.toList());
            throw new IllegalArgumentException("hash method must be MD5@2.16.0, SHA-1@2.16.0 or SHA-256@2.16.0 or SHA3-256@2.16.0");  
            if (entry.getValue() instanceof Map<?, ?>) {
    public String getTargetField() {
     *     "a.b": 1,
    /**  
        String targetField,  
        // metadata fields such as _index, _id and _routing are ignored  
        // we should deduplicate and sort the field names to make sure we can get consistent hash value
import java.util.function.Supplier;  
                if (fields.stream().anyMatch(Strings::isNullOrEmpty)) {
                throw newConfigurationException(TYPE, processorTag, "exclude_fields", "field name cannot be null nor empty");  
     */  
            if (excludeFields != null && !excludeFields.isEmpty() && excludeFields.stream().anyMatch(Strings::isNullOrEmpty)) {
        String description,  
                    return SHA256.messageDigestSupplier.get();
                    "hash method must be MD5@2.16.0, SHA-1@2.16.0, SHA-256@2.16.0 or SHA3-256@2.16.0"
            }
    /**
    // fields used to generate hash value  
                        .append("|")
    private final List<String> fields;
 */
import java.nio.charset.StandardCharsets;  
        }
                if (ignoreMissing) {
        Set<String> existingFields = new HashSet<>(document.getSourceAndMetadata().keySet());  
    }
                .sorted()
            }
                .filter(field -> !metadataFields.contains(field))
        MD5(MessageDigests::md5),
    public IngestDocument execute(IngestDocument document) {  
            }  
    }  
    // that this processor always generates same hash value based on a specific hash method, if the processing logic
        this.hashMethod = hashMethod;
            String processorTag,  
 * SPDX-License-Identifier: Apache-2.0
                case "SHA-1@2.16.0":
     *     }
        SHA1(MessageDigests::sha1),  
import org.opensearch.core.common.Strings;  
     * }, then the converted map is
import org.opensearch.ingest.ConfigurationUtils;
    private Map<String, Object> toFlattenedMap(Map<String, Object> map) {
        this.excludeFields = excludeFields;  
    // of this processor changes in future version, the version number in the hash method should be increased correspondingly.  
        return targetField;  
    enum HashMethod {
        if (fields != null && !fields.isEmpty()) {
import org.opensearch.ingest.AbstractProcessor;
