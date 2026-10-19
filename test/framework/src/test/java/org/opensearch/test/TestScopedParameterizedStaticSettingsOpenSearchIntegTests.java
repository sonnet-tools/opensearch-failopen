        final NodesInfoResponse nodes = client().admin().cluster().prepareNodesInfo().get();
public class TestScopedParameterizedStaticSettingsOpenSearchIntegTests extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
import java.util.Arrays;
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
    public void testSettings() throws IOException {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
    public static Collection<Object[]> parameters() {  
        );
    @ParametersFactory
 */  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
package org.opensearch.test;
        }
        for (final NodeInfo node : nodes.getNodes()) {  
            );
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.admin.cluster.node.info.NodeInfo;  
 * compatible open source license.
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    }
import org.opensearch.common.settings.Settings;
    }  
import static org.hamcrest.CoreMatchers.equalTo;  
/*  
        return Arrays.asList(
                CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.get(node.getSettings()),
        super(staticSettings);
import java.util.Collection;  
                equalTo(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.get(settings))  
 *
}
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
 * SPDX-License-Identifier: Apache-2.0
            assertThat(
    }  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
import java.io.IOException;
    public TestScopedParameterizedStaticSettingsOpenSearchIntegTests(Settings staticSettings) {
 * this file be licensed under the Apache-2.0 license or a
