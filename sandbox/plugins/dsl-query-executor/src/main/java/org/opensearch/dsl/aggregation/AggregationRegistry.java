import java.util.HashMap;
     * @return the translator, or null
    public <T extends AggregationBuilder> MetricTranslator<T> getMetric(Class<? extends AggregationBuilder> aggClass) {
    }
 * SPDX-License-Identifier: Apache-2.0
     * Registers a translator (metric or bucket).  
     * @param aggClass the aggregation builder class
import org.opensearch.dsl.aggregation.bucket.BucketTranslator;
        return translators.get(aggClass);
     * Returns the bucket translator for the given class, or null.
 * compatible open source license.
        AggregationTranslator<?> translator = translators.get(aggClass);  
/*  
     *  
    public AggregationTranslator<?> get(Class<? extends AggregationBuilder> aggClass) {  
     *  
    /**
import java.util.Map;  
    @SuppressWarnings("unchecked")
     * @return the metric translator, or null
    /**
    }  
        translators.put(translator.getAggregationType(), translator);
     *
    public <T extends AggregationBuilder> BucketTranslator<T> getBucket(Class<? extends AggregationBuilder> aggClass) {
     * @param aggClass the aggregation builder class
     * Caller checks {@code instanceof MetricTranslator} or {@code instanceof BucketTranslator}.
    /** Creates an empty registry. */
    }
     */  
     * Returns the translator for the given class, or null.  
    }
     * @param aggClass the aggregation builder class  
     *
 * Registry of all aggregation translators — both metric and bucket.  
     */  
    private final Map<Class<? extends AggregationBuilder>, AggregationTranslator<?>> translators = new HashMap<>();  
        return translator instanceof MetricTranslator ? (MetricTranslator<T>) translator : null;
     * @return the bucket translator, or null
 * Callers use {@code instanceof} to distinguish metric from bucket.
import org.opensearch.search.aggregations.AggregationBuilder;  
     */
     * @param translator the translator to register
        AggregationTranslator<?> translator = translators.get(aggClass);  
    /**
 */  
 * this file be licensed under the Apache-2.0 license or a
    /**
 * Single map keyed by AggregationBuilder class, O(1) lookup.
/**
package org.opensearch.dsl.aggregation;
    public void register(AggregationTranslator<?> translator) {
     * Returns the metric translator for the given class, or null.
    @SuppressWarnings("unchecked")
 * The OpenSearch Contributors require contributions made to  
    public AggregationRegistry() {}  
}  
import org.opensearch.dsl.aggregation.metric.MetricTranslator;
 *
 */  
        return translator instanceof BucketTranslator ? (BucketTranslator<T>) translator : null;
     */  
public class AggregationRegistry {
