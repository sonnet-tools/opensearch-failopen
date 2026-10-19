            factory.missing("0,0");
     * This registers the GeoShape mapper with the Tests so that it can be used for testing the aggregation builders
        if (randomBoolean()) {  
package org.opensearch.geo.search.aggregations.metrics;
        if (randomBoolean()) {  
        GeoBoundsAggregationBuilder factory = new GeoBoundsAggregationBuilder(randomAlphaOfLengthBetween(1, 20));  
     */
import org.opensearch.plugins.Plugin;
    protected Collection<Class<? extends Plugin>> getPlugins() {  
import java.util.Collection;
    protected GeoBoundsAggregationBuilder createTestAggregatorBuilder() {
 * this file be licensed under the Apache-2.0 license or a
    /**
import org.opensearch.geo.GeoModulePlugin;
 * SPDX-License-Identifier: Apache-2.0
        }
}  
 */  
    }
        return Collections.singletonList(GeoModulePlugin.class);
 * compatible open source license.
            factory.wrapLongitude(randomBoolean());
     *  
        }
     * @return A Collection containing {@link GeoModulePlugin}
/*  
        String field = randomAlphaOfLengthBetween(3, 20);
import java.util.Collections;  
    }
 *
    @Override
        factory.field(field);
 * The OpenSearch Contributors require contributions made to  
public class GeoBoundsAggregationBuilderTests extends BaseAggregationTestCase<GeoBoundsAggregationBuilder> {
import org.opensearch.search.aggregations.BaseAggregationTestCase;  
        return factory;  
