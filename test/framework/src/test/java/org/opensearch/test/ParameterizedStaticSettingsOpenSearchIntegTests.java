import java.io.IOException;
import org.opensearch.common.settings.Settings;
    public static Collection<Object[]> parameters() {  
        for (final NodeInfo node : nodes.getNodes()) {  
 */  
    public void testSettings() throws IOException {
/*  
 * compatible open source license.
import static org.hamcrest.CoreMatchers.equalTo;  
            );
        }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
    }  
    @ParametersFactory
                equalTo(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.get(settings))  
public class ParameterizedStaticSettingsOpenSearchIntegTests extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
package org.opensearch.test;
    }
}
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 *
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
    public ParameterizedStaticSettingsOpenSearchIntegTests(Settings staticSettings) {
                CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.get(node.getSettings()),
import java.util.Arrays;
import java.util.Collection;  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        return Arrays.asList(
import org.opensearch.action.admin.cluster.node.info.NodeInfo;  
    }  
        final NodesInfoResponse nodes = client().admin().cluster().prepareNodesInfo().get();
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            assertThat(
        super(staticSettings);
        );
