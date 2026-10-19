import java.io.IOException;  
    public void testSettings() throws IOException {  
        assertThat(
import static org.hamcrest.CoreMatchers.equalTo;
 */  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
        );
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
import org.opensearch.common.settings.Settings;
import java.util.Arrays;
 * The OpenSearch Contributors require contributions made to  
        final ClusterStateResponse cluster = client().admin().cluster().prepareState().all().get();
 * SPDX-License-Identifier: Apache-2.0
 *
    @ParametersFactory
        super(dynamicSettings);
/*  
    }
        return Arrays.asList(  
        );  
    public static Collection<Object[]> parameters() {
package org.opensearch.test;
    }  
    public TestScopedParameterizedDynamicSettingsOpenSearchIntegTests(Settings dynamicSettings) {  
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            equalTo(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.get(settings))
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
 * compatible open source license.
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
 * this file be licensed under the Apache-2.0 license or a
    }
}
public class TestScopedParameterizedDynamicSettingsOpenSearchIntegTests extends ParameterizedDynamicSettingsOpenSearchIntegTestCase {
            CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.get(cluster.getState().getMetadata().settings()),  
import java.util.Collection;
