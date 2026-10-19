 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoHashGridAggregationBuilder;
     * Create a new {@link GeoBounds} aggregation with the given name.
        return new GeoTileGridAggregationBuilder(name);  
package org.opensearch.geo.tests.common;
    public static GeoTileGridAggregationBuilder geotileGrid(String name) {
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoHashGrid;
    public static GeoBoundsAggregationBuilder geoBounds(String name) {  
 * The OpenSearch Contributors require contributions made to  
    }
 *
 */  
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoTileGrid;  
    /**
 * compatible open source license.
     */
        return new GeoBoundsAggregationBuilder(name);
/*  
     */
import org.opensearch.geo.search.aggregations.metrics.GeoBounds;
        return new GeoHashGridAggregationBuilder(name);
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoTileGridAggregationBuilder;
     * Create a new {@link GeoHashGrid} aggregation with the given name.
     */  
    }
}
    /**  
    /**
public class AggregationBuilders {
     * Create a new {@link GeoTileGrid} aggregation with the given name.  
    }  
import org.opensearch.geo.search.aggregations.metrics.GeoBoundsAggregationBuilder;  
    public static GeoHashGridAggregationBuilder geohashGrid(String name) {
 * SPDX-License-Identifier: Apache-2.0
