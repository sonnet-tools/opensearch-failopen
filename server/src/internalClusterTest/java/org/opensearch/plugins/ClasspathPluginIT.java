                "NA",
                Collections.emptyList(),  
    public static class SampleExtendingPlugin extends Plugin implements SampleExtension {  
    public static class SampleExtensiblePlugin extends Plugin implements ExtensiblePlugin {
                Version.CURRENT,
    public void testPluginExtensionWithClasspathPlugins() throws IOException {
                "1.8",
import org.opensearch.Version;
                List.of(SampleExtensiblePlugin.class.getName()),
                "classpath plugin",  
                "1.8",  
            new PluginInfo(
    public interface SampleExtension {}
 * The OpenSearch Contributors require contributions made to  
                null,
                SampleExtendingPlugin.class.getName(),
            ),
        @Override
                SampleExtensiblePlugin.class.getName(),
}
import static org.hamcrest.Matchers.equalTo;  
            new PluginInfo(  
        return List.of(  
                SampleExtensiblePlugin.class.getName(),
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        public SampleExtendingPlugin() {}
    @Override
    }
/*  
            int nLoaded = 0;  
import java.util.Collection;
            for (SampleExtension e : loader.loadExtensions(SampleExtension.class)) {
                false
        );
            )
            assertThat(nLoaded, equalTo(1));
import java.util.Collections;  
import java.io.IOException;
                SampleExtendingPlugin.class.getName(),  
    };
                Version.CURRENT,
import org.opensearch.test.OpenSearchIntegTestCase;
        internalCluster().startNode();  
    }  
        public void loadExtensions(ExtensiblePlugin.ExtensionLoader loader) {
    protected Collection<PluginInfo> additionalNodePlugins() {
public class ClasspathPluginIT extends OpenSearchIntegTestCase {  
                "NA",  
 *
            }  
 * this file be licensed under the Apache-2.0 license or a
 */  
                null,
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
                false  
        public SampleExtensiblePlugin() {}
                nLoaded++;
        }  
                "classpath plugin",
 * compatible open source license.
    }
package org.opensearch.plugins;
