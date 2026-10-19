import java.util.Arrays;
import org.opensearch.common.settings.Settings;
        super(dynamicSettings);
/*  
            CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.get(cluster.getState().getMetadata().settings()),  
        return Arrays.asList(  
        assertThat(
    public SuiteScopedParameterizedDynamicSettingsOpenSearchIntegTests(Settings dynamicSettings) {  
    }  
import java.io.IOException;  
import java.util.Collection;
        );  
@OpenSearchIntegTestCase.SuiteScopeTestCase
import static org.hamcrest.CoreMatchers.equalTo;
package org.opensearch.test;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
 * compatible open source license.
    @ParametersFactory
    }
        final ClusterStateResponse cluster = client().admin().cluster().prepareState().all().get();
 */  
public class SuiteScopedParameterizedDynamicSettingsOpenSearchIntegTests extends ParameterizedDynamicSettingsOpenSearchIntegTestCase {
 * this file be licensed under the Apache-2.0 license or a
}
            equalTo(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.get(settings))
    public static Collection<Object[]> parameters() {
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
 *
    public void testSettings() throws IOException {  
 * The OpenSearch Contributors require contributions made to  
        );
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    }
 * SPDX-License-Identifier: Apache-2.0
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;  
