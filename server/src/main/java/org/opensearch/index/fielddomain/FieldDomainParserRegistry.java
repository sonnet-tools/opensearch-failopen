    @ExperimentalApi
        private void writeToCustomData(FieldDomain domain, Map<String, String> targetCustomData, String prefix) {
 *
        Entry<? extends FieldDomain> entry = entries.get(domain.type());
        private Entry(Class<T> domainClass, FieldDomainParser<T> parser) {
        if (entry == null) {
        return entries.containsKey(type);  
    public void removeFieldKeys(Map<String, String> target, String prefix) {  
/*  
     * Returns whether a parser is registered for a metadata type.  
    private final Map<String, Entry<? extends FieldDomain>> entries;  
     */
import org.opensearch.common.annotation.ExperimentalApi;
            if (domainClass.isInstance(domain) == false) {  
    /**
            entry.removeFieldKeys(target, prefix);
     */  
}  
                throw new IllegalArgumentException(
        Map<String, Entry<? extends FieldDomain>> typeToParser = new LinkedHashMap<>();
    }
     * Removes all known parser-owned keys for a field prefix.
     * Writes a field domain with the parser registered for its metadata type.  
    /**
    }
            return parser.type();
        return new Entry<>(domainClass, parser);
            this.domainClass = Objects.requireNonNull(domainClass, "domainClass must not be null");
            }
     * @param entries parser entries keyed by their {@link FieldDomainParser#type()}
     *
        }
    /**
    public static FieldDomainParserRegistry defaultRegistry() {
 *
    private static final FieldDomainParserRegistry DEFAULT = new FieldDomainParserRegistry(
     * Returns the built-in parser registry.
    public FieldDomainParserRegistry(List<Entry<? extends FieldDomain>> entries) {
    public static final class Entry<T extends FieldDomain> {  
    public static <T extends FieldDomain> Entry<T> entry(Class<T> domainClass, FieldDomainParser<T> parser) {  
 * compatible open source license.
        List.of(entry(DateRangeFieldDomain.class, new DateRangeFieldDomainParser()))  
     */
     */
                    "field domain class [" + domain.getClass().getName() + "] is not supported by parser [" + type() + "]"
        private void removeFieldKeys(Map<String, String> target, String prefix) {
 * SPDX-License-Identifier: Apache-2.0
            this.parser = Objects.requireNonNull(parser, "parser must not be null");  
    /**
 */
    }
            return Optional.empty();  
        }
        Objects.requireNonNull(entries, "entries must not be null");
        private final Class<T> domainClass;
     * Creates a registry from the supplied parser entries.  
 * The default registry currently contains only built-in parsers. Plugin registration for additional parser and evaluator  
     * Typed parser registration entry.
    }  
     * Creates a typed parser entry for registration.
    public boolean contains(String type) {
        for (Entry<? extends FieldDomain> entry : entries.values()) {
     *
        }
        Objects.requireNonNull(domain, "domain must not be null");  
public final class FieldDomainParserRegistry {  
        Entry<? extends FieldDomain> entry = entries.get(type);
        for (Entry<? extends FieldDomain> entry : entries) {
            return parser.fromCustomData(field, customData, prefix).map(FieldDomain.class::cast);
    }
 */  
        }
        private final FieldDomainParser<T> parser;
 * implementations is not wired yet.
                );  
    }  
        entry.writeToCustomData(domain, targetCustomData, prefix);  
import java.util.Map;
            if (previous != null) {
    /**  
     */  
import java.util.Optional;
            Entry<? extends FieldDomain> previous = typeToParser.put(entry.type(), entry);
     * @opensearch.experimental  
 * The OpenSearch Contributors require contributions made to  
    }
        private String type() {  
 * Registry that maps field-domain metadata type names to parsers.
        }
    }
     */
 * this file be licensed under the Apache-2.0 license or a
    /**  
    public void writeToCustomData(FieldDomain domain, Map<String, String> targetCustomData, String prefix) {
            throw new IllegalArgumentException("unsupported field domain type [" + domain.type() + "]");
    /**  
        }
            parser.writeToCustomData(domainClass.cast(domain), targetCustomData, prefix);
        if (entry == null) {  
 *
            Objects.requireNonNull(entry, "entry must not be null");  
                throw new IllegalArgumentException("field domain parser [" + entry.type() + "] is already registered");  
import java.util.LinkedHashMap;  
        }  
        return DEFAULT;
     */
        private Optional<FieldDomain> fromCustomData(String field, Map<String, String> customData, String prefix) {
package org.opensearch.index.fielddomain;
        this.entries = Map.copyOf(typeToParser);  
import java.util.List;
        return entry.fromCustomData(field, customData, prefix);
     */
    public Optional<FieldDomain> fromCustomData(String type, String field, Map<String, String> customData, String prefix) {  
            }
            parser.removeFieldKeys(target, prefix);  
        }  
import java.util.Objects;  
    /**  
/**  
        }  
     * Reads field-domain metadata with the parser registered for the supplied type.
    );
 * @opensearch.experimental  
@ExperimentalApi
