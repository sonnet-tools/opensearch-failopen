            System.getProperty("java.specification.version"),
        }
 * this file be licensed under the Apache-2.0 license or a
            "1.0",  
/*  
            + VersionUtils.getVersion(Version.CURRENT.major, Version.CURRENT.minor, (byte) (Version.CURRENT.revision + 1));
        );
            System.getProperty("java.specification.version"),
            "classname",  
        assertThat(e.getMessage(), containsString("Plugin [dummyPlugin] was built for OpenSearch version "));
        );  
            "version",  
            "{opensearch:\"~" + Version.CURRENT + "\"}",
            "description",
}  
            // Ensure plugins service was able to load the plugin
            "dummy desc",
        // Prepare the plugins directory with an incompatible plugin and attempt to start a node
        }
            "classname",
import org.opensearch.Version;
            "dummy desc",  
package org.opensearch.plugins;
        internalCluster().startNode(Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), baseDir));
            () -> internalCluster().startNode(Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), baseDir))
        // Prepare the plugins directory and then start a node
            IllegalArgumentException.class,
            "dummyPlugin",
    }
        for (PluginsService pluginsService : internalCluster().getDataNodeInstances(PluginsService.class)) {
            assertEquals(1, pluginsService.info().getPluginInfos().stream().filter(info -> info.getName().equals("dummyPlugin")).count());
    public void testNodeBootstrapWithCompatiblePlugin() throws IOException {
            "{opensearch:\"" + incompatibleRange + "\"}",  
        try (InputStream jar = PluginsServiceTests.class.getResourceAsStream("dummy-plugin.jar")) {  
        Path baseDir = createTempDir();  
        }  
            System.getProperty("java.specification.version"),
            "dependencies",
            "test.DummyPlugin"  
 * The OpenSearch Contributors require contributions made to  
        );
            "java.version",  
            "name",
        try (InputStream jar = PluginsServiceTests.class.getResourceAsStream("dummy-plugin.jar")) {
            "test.DummyPlugin"
            Version.CURRENT.toString(),  
            "opensearch.version",
import org.opensearch.test.VersionUtils;
            "1.0",
            Files.copy(jar, pluginDir.resolve("dummy-plugin.jar"));
            "dummyPlugin",
public class PluginsServiceIT extends OpenSearchIntegTestCase {  
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.common.settings.Settings;
    public void testNodeBootstrapWithInCompatiblePlugin() throws IOException {  
        PluginTestUtil.writePluginProperties(
    }
            pluginDir,
        Path baseDir = createTempDir();
            assertEquals(1, pluginsService.info().getPluginInfos().stream().filter(info -> info.getName().equals("dummyPlugin")).count());  
        for (PluginsService pluginsService : internalCluster().getDataNodeInstances(PluginsService.class)) {  
        IllegalArgumentException e = assertThrows(  
        PluginTestUtil.writePluginProperties(  
            "version",  
 *
            "java.version",
            // Ensure plugins service was able to load the plugin
            "description",
        internalCluster().startNode(Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), baseDir));  
        Path baseDir = createTempDir();
            pluginDir,
            "name",
            Files.copy(jar, pluginDir.resolve("dummy-plugin.jar"));
        Path pluginDir = baseDir.resolve("plugins/dummy-plugin");  
        }
 */  
            Files.copy(jar, pluginDir.resolve("dummy-plugin.jar"));  
    }
        }
import java.io.InputStream;
import org.opensearch.env.Environment;  
    public void testNodeBootstrapWithRangeCompatiblePlugin() throws IOException {
        try (InputStream jar = PluginsServiceTests.class.getResourceAsStream("dummy-plugin.jar")) {  
        String incompatibleRange = "~"
            "name",  
            "dependencies",
            "dummy desc",  
            "classname",  
import static org.hamcrest.Matchers.containsString;  
            pluginDir,  
 * compatible open source license.
import java.nio.file.Files;  
        Path pluginDir = baseDir.resolve("plugins/dummy-plugin");
            "description",
            "version",
            "1.0",
        );
        // Prepare the plugins directory and then start a node  
 * SPDX-License-Identifier: Apache-2.0
        PluginTestUtil.writePluginProperties(  
            "test.DummyPlugin"
import java.io.IOException;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            "java.version",
        Path pluginDir = baseDir.resolve("plugins/dummy-plugin");
import java.nio.file.Path;
            "dummyPlugin",
