 *
    protected Settings featureFlagSettings() {  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
    @Override
    public void testExtensionsManagerCreation() {
        ExtensionsManager extManager = internalCluster().getInstance(ExtensionsManager.class, nodeName);  
        String nodeName = internalCluster().startNode();
/*  
import org.opensearch.common.util.FeatureFlags;
import org.opensearch.test.OpenSearchIntegTestCase;  
        ensureGreen();
public class ExtensionsManagerIT extends OpenSearchIntegTestCase {  
package org.opensearch.extensions;
        return Settings.builder().put(super.featureFlagSettings()).put(FeatureFlags.EXTENSIONS, "true").build();
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    }  
 * SPDX-License-Identifier: Apache-2.0
}
        assertEquals(ExtensionsManager.class.getName(), extManager.getClass().getName());
 */  
import org.opensearch.common.settings.Settings;
    }
 * this file be licensed under the Apache-2.0 license or a
