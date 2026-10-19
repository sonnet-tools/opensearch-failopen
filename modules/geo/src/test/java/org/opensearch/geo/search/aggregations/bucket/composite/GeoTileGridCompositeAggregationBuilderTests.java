import org.opensearch.plugins.Plugin;  
    protected CompositeAggregationBuilder createTestAggregatorBuilder() {
            geoTile.precision(randomIntBetween(0, GeoTileUtils.MAX_ZOOM));
import org.opensearch.search.aggregations.BaseAggregationTestCase;
    }
 *
        return geoTile;
 */  
        return Collections.singletonList(GeoModulePlugin.class);
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.bucket.composite.CompositeValuesSourceBuilder;
            sources.add(randomGeoTileGridValuesSourceBuilder());  
import org.opensearch.search.aggregations.bucket.GeoTileUtils;
    private GeoTileGridValuesSourceBuilder randomGeoTileGridValuesSourceBuilder() {
        for (int i = 0; i < numSources; i++) {
        if (randomBoolean()) {
import java.util.Collection;
import java.util.Collections;
            geoTile.geoBoundingBox(RandomGeoGenerator.randomBBox());
import java.util.ArrayList;  
    }  
}
        }
    protected Collection<Class<? extends Plugin>> getPlugins() {
public class GeoTileGridCompositeAggregationBuilderTests extends BaseAggregationTestCase<CompositeAggregationBuilder> {
/*  
        }  
        if (randomBoolean()) {
    }  
import org.opensearch.geo.tests.common.RandomGeoGenerator;
    @Override
import org.opensearch.search.aggregations.bucket.composite.CompositeAggregationBuilder;  
        return new CompositeAggregationBuilder(randomAlphaOfLength(10), sources);
        List<CompositeValuesSourceBuilder<?>> sources = new ArrayList<>();
import org.opensearch.geo.GeoModulePlugin;
        int numSources = randomIntBetween(1, 10);  
        GeoTileGridValuesSourceBuilder geoTile = new GeoTileGridValuesSourceBuilder(randomAlphaOfLengthBetween(5, 10));  
import java.util.List;  
        }  
package org.opensearch.geo.search.aggregations.bucket.composite;
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
