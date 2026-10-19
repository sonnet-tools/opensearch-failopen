        return value == null ? 0 : UnicodeUtil.calcUTF16toUTF8Length(value, 0, value.length());  
    public List<FieldDomain> validateAndParseCustomData(Map<String, String> customData) {  
        Set<String> fields = new HashSet<>();  
     * replaced so stale values do not survive type changes.  
import org.opensearch.common.annotation.ExperimentalApi;  
                String field = key.substring(fieldStart, fieldEnd);  
package org.opensearch.index.fielddomain;
     * @throws IllegalArgumentException when the metadata declares an unsupported or malformed field domain
        }  
                }
import java.util.List;
        ensureCustomDataWithinLimit(updated);  
 * This class is the single place that translates between that wire shape and typed {@link FieldDomain} objects.
     * @param customData custom metadata map stored under {@link #CUSTOM_KEY}
     *  
        return Map.copyOf(customData);
import org.opensearch.cluster.metadata.IndexMetadata;
            domains.add(domain.get());  
    public Map<String, String> toCustomData(FieldDomain domain) {  
 */
 * @opensearch.experimental
     * Existing metadata for other fields is preserved. Existing metadata for the same fields and known parser keys is
/*  
                throw new IllegalArgumentException("field domain metadata keys must not be null");
    }
import java.util.HashSet;
@ExperimentalApi  
        customData.put(prefix + KEY_TYPE, domain.type());
     *  
        }
            return List.of();
            throw new IllegalArgumentException("field domain metadata is required");
     * the requested field returns {@link Optional#empty()} so callers can fall back to conservative behavior.
        for (String key : customData.keySet()) {
     * Returns the built-in metadata codec.
        return putFieldDomains(metadata, validateAndParseCustomData(customData));  
            Objects.requireNonNull(domain, "domain must not be null");
            sizeInBytes += utf8Length(entry.getKey());
        if (field == null || field.isEmpty()) {
        parserRegistry.removeFieldKeys(target, prefix);
            Optional<FieldDomain> domain = fromCustomData(customData, field);
                throw new IllegalArgumentException(
import java.util.Set;
        return parserRegistry.fromCustomData(type, field, customData, prefix);
     */  
        this.parserRegistry = Objects.requireNonNull(parserRegistry, "parserRegistry must not be null");  
        removeKnownFieldKeys(updated, prefix);
     * {@link #fromCustomData(Map, String)} to read one field conservatively.  
        for (FieldDomain domain : domains) {  
    }  
    public IndexMetadata putFieldDomain(IndexMetadata metadata, FieldDomain domain) {
    public static IndexFieldDomainMetadata getInstance() {  
        for (Map.Entry<String, String> entry : customData.entrySet()) {  
        for (FieldDomain domain : domains) {
    static final int MAX_CUSTOM_DATA_BYTES = 16 * 1024; // 16 KiB
        Objects.requireNonNull(domains, "domains must not be null");  
        Map<String, String> existing = metadata.getCustomData(CUSTOM_KEY);  
    }
    private static final String FIELDS_PREFIX = "fields.";
                );  
        ensureCustomDataWithinLimit(customData);
        if (domains.isEmpty()) {
     */
    IndexFieldDomainMetadata(FieldDomainParserRegistry parserRegistry) {
    private static Set<String> declaredFields(Map<String, String> customData) {
    }  
        Map<String, String> customData = new HashMap<>();
        if (fields.isEmpty()) {  
                    "index field domain metadata is too large, size must be less than or equal to [" + MAX_CUSTOM_DATA_BYTES + "] bytes"
        parserRegistry.writeToCustomData(domain, customData, prefix);  
    /**
    private static final String KEY_TYPE = "type";  
        Set<String> fields = new LinkedHashSet<>();  
        return IndexMetadata.builder(metadata).putCustom(CUSTOM_KEY, updated).build();
        Map<String, String> updated = existing == null ? new HashMap<>() : new HashMap<>(existing);
    }
     */
import java.util.Objects;  
        target.remove(prefix + KEY_TYPE);
        for (String field : fields) {
        return INSTANCE;
    }  
                fields.add(field);
            throw new IllegalArgumentException("field domain metadata contains no field declarations");
    public Map<String, String> toCustomData(Collection<? extends FieldDomain> domains) {
}  
    private IndexFieldDomainMetadata() {
            return Optional.empty();
            return metadata;
 * SPDX-License-Identifier: Apache-2.0
        if (customData == null || customData.isEmpty()) {
            removeKnownFieldKeys(updated, fieldPrefix(domain.field()));
        updated.putAll(toCustomData(domains));
                    throw new IllegalArgumentException("field domain metadata field name must not be empty");
     *
        }
     * @param field field name to parse
                int fieldStart = FIELDS_PREFIX.length();
     * Parses field domains for a single field from index custom metadata.
        return IndexMetadata.builder(metadata).putCustom(CUSTOM_KEY, updated).build();
public final class IndexFieldDomainMetadata {
import java.util.HashMap;
 */  
            }
import java.util.Map;
    public IndexMetadata putFieldDomains(IndexMetadata metadata, Collection<? extends FieldDomain> domains) {
    private static String fieldPrefix(String field) {  
    public IndexMetadata putFieldDomains(IndexMetadata metadata, Map<String, String> customData) {
        String type = customData.get(prefix + KEY_TYPE);
    }
        String typeSuffix = "." + KEY_TYPE;
     * Returns updated index metadata with the supplied field domain inserted under {@link #CUSTOM_KEY}.  
        Objects.requireNonNull(domains, "domains must not be null");
        long sizeInBytes = 0L;
        ensureCustomDataWithinLimit(customData);
     * Existing metadata for other fields is preserved. Existing metadata for the same field and known parser keys is
     * This method is intentionally lenient for search-time consumers: missing, malformed, or unsupported metadata for
            }  
        return List.copyOf(domains);
        return fields;
            if (key.startsWith(FIELDS_PREFIX) && key.endsWith(typeSuffix)) {  
            throw new IllegalArgumentException("field must not be null or empty");
            }
     *  
    private void removeKnownFieldKeys(Map<String, String> target, String prefix) {  
 * The OpenSearch Contributors require contributions made to  
    /**
        if (Objects.equals(existing, updated)) {
    private static final IndexFieldDomainMetadata INSTANCE = new IndexFieldDomainMetadata();  
        }  
        if (type == null || type.isEmpty()) {  
            }
        }
        ensureCustomDataWithinLimit(updated);
     * replaced so stale values do not survive type changes.  
     * Validates and parses all field domains declared in an {@code index_field_domains} custom metadata map.
     */
        if (Objects.equals(existing, updated)) {
            if (key == null) {  
                if (fieldEnd <= fieldStart) {  
 * Codec for the {@code index_field_domains} index custom metadata.
 * compatible open source license.
            return Optional.empty();
        Map<String, String> existing = metadata.getCustomData(CUSTOM_KEY);  
    /**  
            if (domain.isEmpty()) {  
            if (sizeInBytes > MAX_CUSTOM_DATA_BYTES) {  
        }  
    /**
        Set<String> fields = declaredFields(customData);
    /**
        Map<String, String> customData = new HashMap<>();  
            }
        if (customData == null || customData.isEmpty() || field == null || field.isEmpty()) {  
    private static int utf8Length(String value) {
    }  
import java.util.Collection;  
                throw new IllegalArgumentException("duplicate field domain for field [" + domain.field() + "]");
            if (parserRegistry.contains(type) == false) {
    }
        }  
     * field domain is rejected instead of being silently stored. Search-time consumers should use
        }
    private static void ensureCustomDataWithinLimit(Map<String, String> customData) {
        }
     * This method is intentionally strict for producer-side writes: a request that declares an unsupported or malformed
 * this file be licensed under the Apache-2.0 license or a
    public Optional<FieldDomain> fromCustomData(Map<String, String> customData, String field) {
 *  
     * @param customData custom metadata map stored under {@link #CUSTOM_KEY}
            String type = customData.get(fieldPrefix(field) + KEY_TYPE);  
            }
     *
        Map<String, String> updated = existing == null ? new HashMap<>() : new HashMap<>(existing);
import java.util.ArrayList;
        Objects.requireNonNull(domain, "domain must not be null");
     */
    }
            if (fields.add(domain.field()) == false) {  
     */
            return metadata;  
    /**  
        return Map.copyOf(customData);  
            Objects.requireNonNull(domain, "domain must not be null");
                throw new IllegalArgumentException("unsupported field domain type [" + type + "] for field [" + field + "]");
 *
    }
     */
        String prefix = fieldPrefix(field);
        }
            return metadata;  
/**
     * Encodes field-domain objects into a custom metadata map.  
                throw new IllegalArgumentException("invalid field domain metadata for field [" + field + "]");
     * @return parsed field domains in an unspecified order  
    /**
    public static final String CUSTOM_KEY = "index_field_domains";
        }
     */
        String prefix = fieldPrefix(domain.field());
    }  
import java.util.Optional;
     * Validates and inserts encoded field-domain metadata under {@link #CUSTOM_KEY}.
     * Encodes one field-domain object into a custom metadata map containing only that field.
     * @return parsed domain when metadata is present, complete, and supported; otherwise empty  
import java.util.LinkedHashSet;  
            customData.putAll(toCustomData(domain));  
 *  
                int fieldEnd = key.length() - typeSuffix.length();
        }
    }
    private final FieldDomainParserRegistry parserRegistry;
        this(FieldDomainParserRegistry.defaultRegistry());
        Objects.requireNonNull(metadata, "metadata must not be null");  
        Objects.requireNonNull(domain, "domain must not be null");
     * Custom metadata key used on {@link IndexMetadata}.  
    /**
    }
    /**
    }  
        }  
        String prefix = fieldPrefix(domain.field());  
        if (customData.isEmpty()) {  
        List<FieldDomain> domains = new ArrayList<>(fields.size());
     *
        Objects.requireNonNull(metadata, "metadata must not be null");  
     * Returns updated index metadata with the supplied field domains inserted under {@link #CUSTOM_KEY}.  
        return FIELDS_PREFIX + field + ".";
        Objects.requireNonNull(customData, "customData must not be null");
        updated.putAll(toCustomData(domain));
import org.apache.lucene.util.UnicodeUtil;
 * The metadata is stored as a flat {@code Map<String, String>} under {@link IndexMetadata#getCustomData(String)}.
        }
            sizeInBytes += utf8Length(entry.getValue());
     */
