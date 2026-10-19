    Class<T> getAggregationType();
package org.opensearch.dsl.aggregation;
 */
     *
/**  
     * @throws ConversionException if the aggregation carries an unsupported parameter
    /**
     * response omits the {@code meta} section entirely (classic search renders {@code meta}
}  
     */
 * Base type interface for aggregation translators.
 * Bucket and metric subtypes define their own contracts.  
     * @param agg the aggregation builder to validate  
import org.opensearch.search.aggregations.AggregationBuilder;
import org.opensearch.dsl.converter.ConversionException;
        Map<String, Object> metadata = agg.getMetadata();  
 * The OpenSearch Contributors require contributions made to  
     * honors every parameter of its aggregation type provides an empty implementation.
 */  
public interface AggregationTranslator<T extends AggregationBuilder> {
 * this file be licensed under the Apache-2.0 license or a
     */
     *
 * SPDX-License-Identifier: Apache-2.0
     * only when supplied). {@link AggregationBuilder#getMetadata()} masks "absent" as an empty
        return metadata == null || metadata.isEmpty() ? null : metadata;
import java.util.Map;
     * <p>An unimplemented parameter must be rejected rather than ignored: ignoring it returns
     * Returns the user-supplied {@code meta} map from the request, or null when absent so the  
 * Provides type identification for the {@link AggregationRegistry}.
 *
 * compatible open source license.
    /**
    void validate(T agg) throws ConversionException;  
     * map, so an explicitly supplied empty {@code "meta": {}} is also treated as absent here.  
    }
     * Rejects requests carrying parameters this translator does not implement. Called once per
    static Map<String, Object> userMetadata(AggregationBuilder agg) {
/*  
     * aggregation, before any plan is built.  
    /** Returns the concrete AggregationBuilder class this type handles. */
     * a well-formed response whose numbers differ from classic search. A translator that  
