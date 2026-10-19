 * The OpenSearch Contributors require contributions made to  
}  
    public static AggregationRegistry create(Supplier<MapperService> mapperServiceSupplier) {  
package org.opensearch.dsl.aggregation;
 * SPDX-License-Identifier: Apache-2.0
 */  
        // TODO: add other aggregation translators
     * Creates a registry with all supported metric and bucket translators.  
public class AggregationRegistryFactory {
import org.opensearch.index.mapper.MapperService;  
import org.opensearch.dsl.aggregation.metric.AvgMetricTranslator;
        AggregationRegistry registry = new AggregationRegistry();
import org.opensearch.dsl.aggregation.metric.MaxMetricTranslator;  
     *        index — evaluated lazily when the terms translator resolves key types and formats.  
import org.opensearch.dsl.aggregation.bucket.TermsBucketTranslator;
    /** Creates a registry without mapping resolution — conversion-only use; terms rendering fails without a MapperService. */
/*  
 * compatible open source license.
    /**
        return create(() -> null);
 */  
        registry.register(new MinMetricTranslator());
     * @param mapperServiceSupplier supplies the MapperService for the current request's target
    }
 *
    public static AggregationRegistry create() {  
        registry.register(new AvgMetricTranslator());
     *
 * this file be licensed under the Apache-2.0 license or a
    private AggregationRegistryFactory() {}  
 * Creates an {@link AggregationRegistry} populated with all supported translators.
import org.opensearch.dsl.aggregation.metric.MinMetricTranslator;
    }  
        return registry;
        registry.register(new MaxMetricTranslator());
import org.opensearch.dsl.aggregation.metric.SumMetricTranslator;
     *        Supplying null skips mapping-dependent validation and fails terms rendering.
/**
import java.util.function.Supplier;
        registry.register(new TermsBucketTranslator(mapperServiceSupplier));  
        registry.register(new SumMetricTranslator());  
     */
