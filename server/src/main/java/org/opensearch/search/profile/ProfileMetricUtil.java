public class ProfileMetricUtil {  
    public static Collection<Supplier<ProfileMetric>> getDefaultQueryProfileMetrics() {
/**  
            metrics.add(() -> new Timer(type.toString()));
        Collection<Supplier<ProfileMetric>> metrics = getDefaultQueryProfileMetrics();  
import org.opensearch.search.profile.aggregation.AggregationTimingType;
        return metrics;
        Collection<Supplier<ProfileMetric>> metrics = new ArrayList<>();  
        for (FetchTimingType type : FetchTimingType.values()) {
    }
        return metrics;  
import org.opensearch.search.profile.query.QueryTimingType;  
import org.opensearch.search.profile.fetch.FetchTimingType;
    }
        }
/*  
 * compatible open source license.
 */  
    }  
    public static Collection<Supplier<ProfileMetric>> getAggregationProfileMetrics() {
        return metrics;
 * Utility class to provide profile metrics to breakdowns.
    public static Collection<Supplier<ProfileMetric>> getQueryProfileMetrics(Collection<Supplier<ProfileMetric>> customProfileMetrics) {
 */
    public static Collection<Supplier<ProfileMetric>> getFetchProfileMetrics() {  
        }
        metrics.addAll(customProfileMetrics);
        }  
        Collection<Supplier<ProfileMetric>> metrics = new ArrayList<>();
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        for (QueryTimingType type : QueryTimingType.values()) {
        Collection<Supplier<ProfileMetric>> metrics = new ArrayList<>();
}
import java.util.function.Supplier;
    }  
        for (AggregationTimingType type : AggregationTimingType.values()) {  
        return metrics;
import java.util.Collection;  
            metrics.add(() -> new Timer(type.toString()));  
 *
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.search.profile;
            metrics.add(() -> new Timer(type.toString()));
import java.util.ArrayList;
