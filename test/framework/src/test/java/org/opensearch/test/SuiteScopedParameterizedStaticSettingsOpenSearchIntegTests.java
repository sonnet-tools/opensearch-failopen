 * SPDX-License-Identifier: Apache-2.0
        for (final NodeInfo node : nodes.getNodes()) {  
import org.opensearch.common.settings.Settings;
 */  
 *
        }
        return Arrays.asList(
 * compatible open source license.
            );
import static org.hamcrest.CoreMatchers.equalTo;  
    @ParametersFactory
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
        final NodesInfoResponse nodes = client().admin().cluster().prepareNodesInfo().get();
    public void testSettings() throws IOException {
/*  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
                CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.get(node.getSettings()),
import java.util.Arrays;
                equalTo(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.get(settings))  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
    public static Collection<Object[]> parameters() {  
    }  
import java.util.Collection;  
package org.opensearch.test;
    }
        );
}
        super(staticSettings);
@OpenSearchIntegTestCase.SuiteScopeTestCase
    }  
import org.opensearch.action.admin.cluster.node.info.NodeInfo;  
    public SuiteScopedParameterizedStaticSettingsOpenSearchIntegTests(Settings staticSettings) {
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
import java.io.IOException;
            assertThat(
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
public class SuiteScopedParameterizedStaticSettingsOpenSearchIntegTests extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
