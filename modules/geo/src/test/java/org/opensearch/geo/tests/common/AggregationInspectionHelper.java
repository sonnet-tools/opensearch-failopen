 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
}
 * compatible open source license.
/*  
public class AggregationInspectionHelper {
 *
import org.opensearch.geo.search.aggregations.metrics.InternalGeoBounds;
    public static boolean hasValue(BaseGeoGrid<?> agg) {
        return (agg.topLeft() == null && agg.bottomRight() == null) == false;
 * The OpenSearch Contributors require contributions made to  
    }
        return agg.getBuckets().stream().anyMatch(bucket -> bucket.getDocCount() > 0);
 */  
    }  
import org.opensearch.geo.search.aggregations.bucket.geogrid.BaseGeoGrid;
    public static boolean hasValue(InternalGeoBounds agg) {  
package org.opensearch.geo.tests.common;
