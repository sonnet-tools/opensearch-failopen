     * {@link #fromCustomData(Map, String)} to read one field conservatively.
        customData.put(prefix + KEY_TYPE, domain.type());
                );
            domains.add(domain.get());
        parserRegistry.removeFieldKeys(target, prefix);
        }
            }
        Set<String> fields = new LinkedHashSet<>();
        for (String key : customData.keySet()) {
        return IndexMetadata.builder(metadata).putCustom(CUSTOM_KEY, updated).build();
 *
     * Custom metadata key used on {@link IndexMetadata}.
     */
    private static final String KEY_TYPE = "type";
    public static IndexFieldDomainMetadata getInstance() {
}
        if (customData == null || customData.isEmpty()) {
        if (field == null || field.isEmpty()) {
        this.parserRegistry = Objects.requireNonNull(parserRegistry, "parserRegistry must not be null");
        Map<String, String> updated = existing == null ? new HashMap<>() : new HashMap<>(existing);
        }
     */
    public List<FieldDomain> validateAndParseCustomData(Map<String, String> customData) {
     * @return parsed field domains in an unspecified order
    /**
            if (domain.isEmpty()) {
    public IndexMetadata putFieldDomains(IndexMetadata metadata, Map<String, String> customData) {
        removeKnownFieldKeys(updated, prefix);
import java.util.Collection;
        String prefix = fieldPrefix(domain.field());
     * This method is intentionally strict for producer-side writes: a request that declares an unsupported or malformed
                    "index field domain metadata is too large, size must be less than or equal to [" + MAX_CUSTOM_DATA_BYTES + "] bytes"
    }
        if (Objects.equals(existing, updated)) {
    private static final String FIELDS_PREFIX = "fields.";
        for (String field : fields) {
        return fields;
import java.util.Objects;
            return metadata;
            if (key == null) {
                throw new IllegalArgumentException("invalid field domain metadata for field [" + field + "]");
        return List.copyOf(domains);
    private static String fieldPrefix(String field) {
        Objects.requireNonNull(metadata, "metadata must not be null");
     * @throws IllegalArgumentException when the metadata declares an unsupported or malformed field domain
     * Parses field domains for a single field from index custom metadata.
    }
        Objects.requireNonNull(metadata, "metadata must not be null");
        this(FieldDomainParserRegistry.defaultRegistry());
        }
    public Map<String, String> toCustomData(Collection<? extends FieldDomain> domains) {
            }
    }
        if (Objects.equals(existing, updated)) {
import java.util.Map;
     * field domain is rejected instead of being silently stored. Search-time consumers should use
        String typeSuffix = "." + KEY_TYPE;
            return Optional.empty();
        Set<String> fields = declaredFields(customData);
        Objects.requireNonNull(domain, "domain must not be null");
 * compatible open source license.
            if (sizeInBytes > MAX_CUSTOM_DATA_BYTES) {
        ensureCustomDataWithinLimit(customData);
            Objects.requireNonNull(domain, "domain must not be null");
        if (customData.isEmpty()) {
    }
        }
        }
     *
     * This method is intentionally lenient for search-time consumers: missing, malformed, or unsupported metadata for
package org.opensearch.index.fielddomain;
        }
    }
        Objects.requireNonNull(domains, "domains must not be null");
                fields.add(field);
    private static void ensureCustomDataWithinLimit(Map<String, String> customData) {
    }
import org.opensearch.cluster.metadata.IndexMetadata;
    /**
     * replaced so stale values do not survive type changes.
import org.opensearch.common.annotation.ExperimentalApi;
@ExperimentalApi
            if (fields.add(domain.field()) == false) {
        Map<String, String> updated = existing == null ? new HashMap<>() : new HashMap<>(existing);
     * @param customData custom metadata map stored under {@link #CUSTOM_KEY}
            }
                if (fieldEnd <= fieldStart) {
    private static Set<String> declaredFields(Map<String, String> customData) {
public final class IndexFieldDomainMetadata {
    /**
            Optional<FieldDomain> domain = fromCustomData(customData, field);
            }
        Map<String, String> customData = new HashMap<>();
     */
    private static final IndexFieldDomainMetadata INSTANCE = new IndexFieldDomainMetadata();
        }
        String type = customData.get(prefix + KEY_TYPE);
    }
            return Optional.empty();
        long sizeInBytes = 0L;
            return List.of();
    /**
            if (parserRegistry.contains(type) == false) {
import java.util.Optional;
        }
        for (Map.Entry<String, String> entry : customData.entrySet()) {
    }
 * Codec for the {@code index_field_domains} index custom metadata.
     */
        Objects.requireNonNull(customData, "customData must not be null");
    /**
        }
        ensureCustomDataWithinLimit(updated);
            throw new IllegalArgumentException("field domain metadata contains no field declarations");
import java.util.HashSet;
            }
    private final FieldDomainParserRegistry parserRegistry;
            removeKnownFieldKeys(updated, fieldPrefix(domain.field()));
        return Map.copyOf(customData);
    }
        parserRegistry.writeToCustomData(domain, customData, prefix);
            return metadata;
                String field = key.substring(fieldStart, fieldEnd);
     * Existing metadata for other fields is preserved. Existing metadata for the same field and known parser keys is
     *
        if (type == null || type.isEmpty()) {
     *
import java.util.Set;
 * This class is the single place that translates between that wire shape and typed {@link FieldDomain} objects.
    public Map<String, String> toCustomData(FieldDomain domain) {
        if (domains.isEmpty()) {
            String type = customData.get(fieldPrefix(field) + KEY_TYPE);
     * Validates and inserts encoded field-domain metadata under {@link #CUSTOM_KEY}.
    /**
    }
    /**
    }
    }
 *
        return putFieldDomains(metadata, validateAndParseCustomData(customData));
        Map<String, String> customData = new HashMap<>();
        String prefix = fieldPrefix(field);
     * Returns the built-in metadata codec.
            }
        updated.putAll(toCustomData(domains));
 *
     */
            sizeInBytes += utf8Length(entry.getKey());
 * @opensearch.experimental
    IndexFieldDomainMetadata(FieldDomainParserRegistry parserRegistry) {
        Objects.requireNonNull(domains, "domains must not be null");
        return value == null ? 0 : UnicodeUtil.calcUTF16toUTF8Length(value, 0, value.length());
    static final int MAX_CUSTOM_DATA_BYTES = 16 * 1024; // 16 KiB
import java.util.List;
     * Returns updated index metadata with the supplied field domain inserted under {@link #CUSTOM_KEY}.
     * Encodes one field-domain object into a custom metadata map containing only that field.
        Set<String> fields = new HashSet<>();
    }
    public IndexMetadata putFieldDomain(IndexMetadata metadata, FieldDomain domain) {
        String prefix = fieldPrefix(domain.field());
 * this file be licensed under the Apache-2.0 license or a
     */
        for (FieldDomain domain : domains) {
        for (FieldDomain domain : domains) {
        Map<String, String> existing = metadata.getCustomData(CUSTOM_KEY);
        }
                throw new IllegalArgumentException("duplicate field domain for field [" + domain.field() + "]");
            throw new IllegalArgumentException("field must not be null or empty");
 * The metadata is stored as a flat {@code Map<String, String>} under {@link IndexMetadata#getCustomData(String)}.
     *
        }
import java.util.ArrayList;
    }
     */
     * @param customData custom metadata map stored under {@link #CUSTOM_KEY}
    public Optional<FieldDomain> fromCustomData(Map<String, String> customData, String field) {
                throw new IllegalArgumentException(
        target.remove(prefix + KEY_TYPE);
            Objects.requireNonNull(domain, "domain must not be null");
    /**
        return INSTANCE;
/*
            customData.putAll(toCustomData(domain));
    }
        return Map.copyOf(customData);
     *
    private static int utf8Length(String value) {
                int fieldEnd = key.length() - typeSuffix.length();
    public static final String CUSTOM_KEY = "index_field_domains";
    /**
        List<FieldDomain> domains = new ArrayList<>(fields.size());
        ensureCustomDataWithinLimit(customData);
        return IndexMetadata.builder(metadata).putCustom(CUSTOM_KEY, updated).build();
            if (key.startsWith(FIELDS_PREFIX) && key.endsWith(typeSuffix)) {
        }
            throw new IllegalArgumentException("field domain metadata is required");
     * @return parsed domain when metadata is present, complete, and supported; otherwise empty
    private IndexFieldDomainMetadata() {
 * The OpenSearch Contributors require contributions made to
 */
 */
        updated.putAll(toCustomData(domain));
    public IndexMetadata putFieldDomains(IndexMetadata metadata, Collection<? extends FieldDomain> domains) {
     */
     */
            sizeInBytes += utf8Length(entry.getValue());
     *
                    throw new IllegalArgumentException("field domain metadata field name must not be empty");
            return metadata;
                }
import java.util.LinkedHashSet;
     * @param field field name to parse
                throw new IllegalArgumentException("unsupported field domain type [" + type + "] for field [" + field + "]");
        ensureCustomDataWithinLimit(updated);
 * SPDX-License-Identifier: Apache-2.0
     * Encodes field-domain objects into a custom metadata map.
     * Existing metadata for other fields is preserved. Existing metadata for the same fields and known parser keys is
    private void removeKnownFieldKeys(Map<String, String> target, String prefix) {
                throw new IllegalArgumentException("field domain metadata keys must not be null");
import org.apache.lucene.util.UnicodeUtil;
        Objects.requireNonNull(domain, "domain must not be null");
     * Validates and parses all field domains declared in an {@code index_field_domains} custom metadata map.
import java.util.HashMap;
/**
     * replaced so stale values do not survive type changes.
     * the requested field returns {@link Optional#empty()} so callers can fall back to conservative behavior.
        }
        return parserRegistry.fromCustomData(type, field, customData, prefix);
        if (fields.isEmpty()) {
        return FIELDS_PREFIX + field + ".";
        Map<String, String> existing = metadata.getCustomData(CUSTOM_KEY);
        if (customData == null || customData.isEmpty() || field == null || field.isEmpty()) {
     * Returns updated index metadata with the supplied field domains inserted under {@link #CUSTOM_KEY}.
        }
                int fieldStart = FIELDS_PREFIX.length();
