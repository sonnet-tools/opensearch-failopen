     */  
}
/*  
     *                      excluded, {@code min_doc_count} applied, ordered, truncated
        Map.entry("unsigned_long", LongTermsStrategy.INSTANCE),
        Map.entry("short", LongTermsStrategy.INSTANCE),
     * Value: the strategy that builds the correct {@code InternalTerms} subclass.
    TermsResponseStrategy DEFAULT = StringTermsStrategy.INSTANCE;  
     *
 * is a registry entry, not a new branch in a switch.
 * SPDX-License-Identifier: Apache-2.0
     *                      from the plan's eligible-doc count  
        }
        // Numeric integral types → LongTerms
     *
        Map.entry("float", DoubleTermsStrategy.INSTANCE),  
        Map.entry("match_only_text", StringTermsStrategy.INSTANCE)
    /**
 * handles one family of field types (string, long, double), mirroring the
    }
package org.opensearch.dsl.aggregation.bucket;
import org.opensearch.search.aggregations.InternalAggregation;  
     * @return the matching strategy, or {@link #DEFAULT} if not registered  
public interface TermsResponseStrategy {  
     *
     * Builds the typed {@code InternalTerms} response from the given bucket entries.  
 */
     * @param typeName the field's {@code MappedFieldType.typeName()}, or null if unknown
        return REGISTRY.getOrDefault(typeName, DEFAULT);  
 * this file be licensed under the Apache-2.0 license or a
    /**  
        // String/binary types → StringTerms
        Map.entry("scaled_float", DoubleTermsStrategy.INSTANCE),  
        Map.entry("wildcard", StringTermsStrategy.INSTANCE),  
        Map.entry("date_nanos", LongTermsStrategy.INSTANCE),
import org.opensearch.search.DocValueFormat;
import java.util.List;  
        Map.entry("integer", LongTermsStrategy.INSTANCE),  
    /**
     */
 * Strategy for building a terms aggregation response from bucket entries. Each implementation
    InternalAggregation build(TermsAggregationBuilder agg, List<BucketEntry> entries, long otherDocCount, DocValueFormat format);
    /** Default strategy when the field type is unknown — falls back to StringTerms. */
     * @return a fully constructed aggregation ready for serialization
 */  
            return DEFAULT;
    Map<String, TermsResponseStrategy> REGISTRY = Map.ofEntries(  
        if (typeName == null) {  
        Map.entry("half_float", DoubleTermsStrategy.INSTANCE),
    );  
     * @param format        the resolved {@link DocValueFormat} for key rendering
        Map.entry("constant_keyword", StringTermsStrategy.INSTANCE),
        Map.entry("keyword", StringTermsStrategy.INSTANCE),  
        Map.entry("ip", StringTermsStrategy.INSTANCE),
        Map.entry("date", LongTermsStrategy.INSTANCE),  
import org.opensearch.dsl.result.BucketEntry;
/**  
 *
        Map.entry("text", StringTermsStrategy.INSTANCE),
 * The OpenSearch Contributors require contributions made to  
        // Floating point types → DoubleTerms
        Map.entry("double", DoubleTermsStrategy.INSTANCE),
 * {@code ValuesSourceRegistry} pattern from classic search: adding support for a new field type  
     * @param entries       the visible bucket set, exactly as the plan produced it — null keys  
    static TermsResponseStrategy forType(String typeName) {
     * Registry mapping field type names to their response strategy.
        Map.entry("long", LongTermsStrategy.INSTANCE),
     * <p>Key: {@code MappedFieldType.typeName()} (e.g. "keyword", "long", "date", "ip").  
     * @param otherDocCount the {@code sum_other_doc_count} to report, computed by the caller
import java.util.Map;
     */
     * Resolves the strategy for the given field type name.  
 * compatible open source license.
        Map.entry("byte", LongTermsStrategy.INSTANCE),
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        Map.entry("boolean", LongTermsStrategy.BOOLEAN_INSTANCE),  
     * @param agg           the original terms aggregation builder (name, order, request echo)
