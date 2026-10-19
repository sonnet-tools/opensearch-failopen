 * compatible open source license.
     * error.  
     * {@link GeoModulePlugin} in our integration tests we need to override this functionality to avoid multiple mapper
     */
     *  
    @ParametersFactory
     * @return List of {@link Plugin}
     * @return boolean
    public static Collection<Object[]> parameters() {
        super(staticSettings);
 * for the test cluster on which integration tests are running.
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
    }
     * This was added as a backdoor to Mock the implementation of {@link GeoShapeFieldMapper} which was coming from  
        return Collections.singletonList(GeoModulePlugin.class);
import org.opensearch.plugins.Plugin;
        );  
/**
package org.opensearch.geo;
public abstract class GeoModulePluginIntegTestCase extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
     */  
     * geo plugin is not getting packaged in a zip, we need to load it before the tests run.
 */  
import org.opensearch.common.settings.Settings;  
 * This is the base class for all the Geo related integration tests. Use this class to add the features and settings  
import org.opensearch.test.TestGeoShapeFieldMapperPlugin;  
        return Arrays.asList(  
    @Override
     * Returns a collection of plugins that should be loaded on each node for doing the integration tests. As this
     * {@link GeoModulePlugin}. Mock implementation is {@link TestGeoShapeFieldMapperPlugin}. Now we are using the
    }
 * this file be licensed under the Apache-2.0 license or a
 */
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
import java.util.Arrays;
    }
        return false;  
/*  
    @Override  
import java.util.Collection;  
    protected boolean addMockGeoShapeFieldMapper() {
import org.opensearch.geometry.utils.StandardValidator;
    /**
    protected static final WellKnownText WKT = new WellKnownText(true, new StandardValidator(true));
    }  
 *
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    public GeoModulePluginIntegTestCase(Settings staticSettings) {  
import java.util.Collections;
import org.opensearch.geometry.utils.WellKnownText;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    /**  
 * The OpenSearch Contributors require contributions made to  
}
 * SPDX-License-Identifier: Apache-2.0
     *
import org.opensearch.index.mapper.GeoShapeFieldMapper;  
    protected static final double GEOHASH_TOLERANCE = 1E-5D;
