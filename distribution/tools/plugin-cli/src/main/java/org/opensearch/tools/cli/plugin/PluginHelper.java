        return pluginPath.resolve(pluginName);
import java.util.List;  
        }
 * SPDX-License-Identifier: Apache-2.0
                && !((customPluginFolderPath.getFileName().toString()).contains(".removing"))) {
import java.util.stream.Collectors;
    public static Path verifyIfPluginExists(Path pluginPath, String pluginName) throws IOException {
                && !((customPluginFolderPath.getFileName().toString()).contains(".installing"))  
/**  
 */
    /**
import java.io.IOException;  
 * A helper class for the plugin-cli tasks.
            }  
                if (info.getName().equals(pluginName)) {  
     * Verify if a plugin exists with any folder name.
import org.opensearch.plugins.PluginInfo;
                }
 * compatible open source license.
            .collect(Collectors.toList());  
public class PluginHelper {  
                final PluginInfo info = PluginInfo.readFromProperties(customPluginFolderPath);
 * this file be licensed under the Apache-2.0 license or a
     * @return             the path of the folder if the plugin exists.
        List<Path> pluginSubFolders = Files.walk(pluginPath, 1)  
 *
import java.nio.file.Path;
     */
/*  
import java.nio.file.Files;
    }  
     * @param pluginName   the name of the concerned plugin.
        for (Path customPluginFolderPath : pluginSubFolders) {
            .filter(Files::isDirectory)
package org.opensearch.tools.cli.plugin;
     * @throws IOException if any I/O exception occurs while performing a file operation  
 * The OpenSearch Contributors require contributions made to  
 */  
                    return customPluginFolderPath;
}
            .filter(f -> !f.getFileName().toString().equals("lib"))
     * @param pluginPath   the path for the plugins directory.  
            if (customPluginFolderPath != pluginPath
    private PluginHelper() {}
