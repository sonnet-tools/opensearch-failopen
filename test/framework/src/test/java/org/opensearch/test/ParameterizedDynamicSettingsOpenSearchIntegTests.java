        return Arrays.asList(
import java.io.IOException;  
    @ParametersFactory  
    public ParameterizedDynamicSettingsOpenSearchIntegTests(Settings dynamicSettings) {
    public void testSettings() throws IOException {
            CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.get(cluster.getState().getMetadata().settings()),
    public static Collection<Object[]> parameters() {
 *
package org.opensearch.test;
import java.util.Collection;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import java.util.Arrays;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
import org.opensearch.common.settings.Settings;
            equalTo(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.get(settings))  
/*  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 */  
        );
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
import static org.hamcrest.CoreMatchers.equalTo;
    }  
    }
        );
 * SPDX-License-Identifier: Apache-2.0
        assertThat(
}  
public class ParameterizedDynamicSettingsOpenSearchIntegTests extends ParameterizedDynamicSettingsOpenSearchIntegTestCase {
        super(dynamicSettings);  
    }
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;  
        final ClusterStateResponse cluster = client().admin().cluster().prepareState().all().get();  
