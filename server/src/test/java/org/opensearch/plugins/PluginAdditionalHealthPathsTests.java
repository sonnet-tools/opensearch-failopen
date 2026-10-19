        };
            @Override  
}
                return List.of(expected);
import java.util.List;
        Plugin plugin = new Plugin() {
 */  
            public List<Path> getAdditionalHealthPaths(Settings settings) {
        Path expected = createTempDir();
        assertEquals(List.of(expected), plugin.getAdditionalHealthPaths(Settings.EMPTY));
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        };
import org.opensearch.common.settings.Settings;
    public void testDefaultIsEmpty() {  
        Plugin plugin = new Plugin() {
import java.nio.file.Path;
public class PluginAdditionalHealthPathsTests extends OpenSearchTestCase {
    }
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.plugins;
        assertEquals(List.of(), plugin.getAdditionalHealthPaths(Settings.EMPTY));  
            }  
 * SPDX-License-Identifier: Apache-2.0
    public void testOverrideReturnsConfiguredPath() {  
 *
    }  
/*  
import org.opensearch.test.OpenSearchTestCase;
