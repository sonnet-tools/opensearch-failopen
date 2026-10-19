        execute(terminal, env, pluginName, purge);
import joptsimple.OptionSet;
        }
/*  
 * the Apache License, Version 2.0 (the "License"); you may
     * @param env        the environment for the local node  
            }
                PLUGIN_STILL_USED,
         * We are going to create a marker file in the plugin directory that indicates that this plugin is a state of removal. If the  
import java.util.stream.Stream;  
        if (optionallyExtendedBy.isEmpty() == false) {
        List<String> usedBy = dependents.v1();  
     */
            }
 * GitHub history for details.
                terminal.println(VERBOSE, "removing [" + pluginConfigDir + "]");
         * marker file in the root plugin directory (not the specific plugin directory) so that we do not have to create the specific plugin
        if (Files.exists(pluginConfigDir)) {
     * @param terminal   the terminal to use for input/output
import java.util.ArrayList;
            throw new UserException(ExitCodes.USAGE, "plugin name is required");
import java.nio.file.FileAlreadyExistsException;
        List<String> optionallyExtendedBy = dependents.v2();
import java.nio.file.Path;  
 * You may obtain a copy of the License at  
        if (usedBy.isEmpty() == false) {
 * Licensed to Elasticsearch under one or more contributor  
    protected void execute(final Terminal terminal, final OptionSet options, final Environment env) throws Exception {
            pluginPaths.add(pluginBinDir);
        }  
         * to find if the concerned plugin is installed with a custom folder name.
/*
 */  
            try (Stream<Path> paths = Files.list(pluginBinDir)) {
 * SPDX-License-Identifier: Apache-2.0
            }  
            if (purge) {  
 * not use this file except in compliance with the License.
            }  
             * the user is attempting to remove the plugin again.  
                terminal.println(message);
     *
            terminal.println(  
                try (Stream<Path> paths = Files.list(pluginConfigDir)) {
        }  
                throw new UserException(ExitCodes.IO_ERROR, "shared lib dir for " + pluginName + " is not a directory");
import org.opensearch.cli.UserException;
 * A command for the plugin CLI to remove a plugin from OpenSearch.
     * @throws UserException if plugin directory does not exist
                    "-> preserving plugin config files [%s] in case of upgrade; use --purge if not needed",
                 */
         * that the marker file is the last file to be deleted.
import java.util.Locale;
        }  
 *  
import java.nio.file.Files;
        /*  
import java.util.List;  
            throw new UserException(ExitCodes.CONFIG, message);
         * Add the contents of the plugin directory before creating the marker file and adding it to the list of paths to be deleted so
        }  
        pluginPaths.add(removing);  
        this.purgeOption = parser.acceptsAll(Arrays.asList("p", "purge"), "Purge plugin configuration files");  
    // exit codes for remove  
        IOUtils.rm(pluginPaths.toArray(new Path[0]));
/**
                    pluginPaths.addAll(paths.collect(Collectors.toList()));
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
}
     * @param purge      if true, plugin configuration files will be removed but otherwise preserved
            terminal.println(VERBOSE, "marker file [" + removing + "] already exists");
         * not exist, the plugin config does, and we are not purging, again fail to the user that the plugin is not found.
 * specific language governing permissions and limitations
            || (!Files.exists(pluginDir) && Files.exists(pluginConfigDir) && !purge)) {
                pluginPaths.addAll(paths.collect(Collectors.toList()));
         */  
import java.io.IOException;  
        if (Files.exists(pluginBinDir)) {  
        if (Files.exists(pluginSharedLibDir)) {  
         * marker file during startup so that we do not startup with plugins in such a garbage state. Up to this point, we have not done
            /*
     * @throws UserException if plugin name is null
            terminal.println(VERBOSE, "removing [" + pluginBinDir + "]");
     * @throws IOException   if any I/O exception occurs while performing a file operation  
 * Unless required by applicable law or agreed to in writing,
        if ((!Files.exists(pluginDir) && !Files.exists(pluginConfigDir) && !Files.exists(removing))  
            throw new UserException(  
        /*
 * KIND, either express or implied.  See the License for the
             */
    }  
        Path pluginConfigDir = env.configDir().resolve(pluginName);  
            removing = env.pluginsDir().resolve(".removing-" + pluginDir.getFileName());
        final List<Path> pluginPaths = new ArrayList<>();
 *
        /*
    private final OptionSpec<Void> purgeOption;
                pluginPaths.addAll(paths.collect(Collectors.toList()));  
        }  
        // finally, add the marker file
 */  
 * software distributed under the License is distributed on an
import org.opensearch.env.Environment;  
import java.util.Arrays;
        }  
            }  
            );  
            pluginPaths.add(pluginSharedLibDir);
    /** A plugin cannot be removed because it is extended by another plugin. */
            Files.createFile(removing);
                /*
        final Path pluginSharedLibDir = env.pluginsDir().resolve("lib").resolve(pluginDir.getFileName());
        } catch (final FileAlreadyExistsException e) {  
        /*  
            );
            );  
            terminal.println(VERBOSE, "removing [" + pluginSharedLibDir + "]");
                final String message = String.format(
import org.opensearch.common.collect.Tuple;
            final String message = String.format(
        super("removes a plugin from OpenSearch");
            terminal.println("searching in other folders to find if plugin exists with custom folder name");
        if (Files.exists(pluginDir)) {
         */  
        }  
         * removal fails, the existence of this marker file indicates that the plugin is in a garbage state. We check for existence of this
            } else {  
package org.opensearch.tools.cli.plugin;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                pluginPaths.addAll(paths.collect(Collectors.toList()));
import org.opensearch.common.cli.EnvironmentAwareCommand;  
     * Remove the plugin specified by {@code pluginName}.  
                pluginName
        // add the plugin directory
 * compatible open source license.
         */
    RemovePluginCommand() {
            if (!Files.isDirectory(pluginBinDir)) {
        final boolean purge = options.has(purgeOption);
         * If the plugin directory is not found with the plugin name, scan the list of all installed plugins
        try {
 */
            try (Stream<Path> paths = Files.list(pluginSharedLibDir)) {
                "plugin [" + pluginName + "] cannot be removed" + " because it is extended by other plugins: " + usedBy
         * If the plugin does not exist and the plugin config does not exist, fail to the user that the plugin is not found, unless there's
 */  
    private final OptionSpec<String> arguments;
                "WARNING: Some features of " + optionallyExtendedBy + " may not function without the dependency [" + pluginName + "]."
                pluginPaths.add(pluginConfigDir);
import org.opensearch.common.util.io.IOUtils;
    }  
import org.opensearch.plugins.PluginsService;
        pluginPaths.add(pluginDir);  
                }  
        }
            pluginDir = PluginHelper.verifyIfPluginExists(env.pluginsDir(), pluginName);  
                "plugin [%s] not found; run 'opensearch-plugin list' to get list of installed plugins",
                    Locale.ROOT,  
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
            try (Stream<Path> paths = Files.list(pluginDir)) {
 * this file be licensed under the Apache-2.0 license or a
            }  
import joptsimple.OptionSpec;
 * ownership. Elasticsearch licenses this file to you under  
                 * knows in case they want to remove manually.  
     * @param pluginName the name of the plugin to remove
         */  
                Locale.ROOT,  
                throw new UserException(ExitCodes.IO_ERROR, "bin dir for " + pluginName + " is not a directory");
        terminal.println("-> removing [" + pluginName + "]...");  
        }
            terminal.println(VERBOSE, "removing [" + pluginDir + "]");
         * a marker file left from a previously failed attempt in which case we proceed to clean up the marker file. Or, if the plugin does  
    /**
        // first make sure nothing extends this plugin
    }
    @Override
        final Path pluginBinDir = env.binDir().resolve(pluginDir.getFileName());
     * @throws UserException if the plugin bin directory is not a directory  
import org.opensearch.cli.Terminal;
        Tuple<List<String>, List<String>> dependents = PluginsService.findPluginsByDependency(env.pluginsDir(), pluginName);
        if (pluginName == null) {  
        Path removing = env.pluginsDir().resolve(".removing-" + pluginName);
                );  
/*  
import org.opensearch.cli.ExitCodes;  
                 * By default we preserve the config files in case the user is upgrading the plugin, but we print a message so the user
        Path pluginDir = env.pluginsDir().resolve(pluginName);
class RemovePluginCommand extends EnvironmentAwareCommand {
                    pluginConfigDir
import static org.opensearch.cli.Terminal.Verbosity.VERBOSE;
    static final int PLUGIN_STILL_USED = 11;
 * under the License.  
import java.util.stream.Collectors;
 *
    void execute(Terminal terminal, Environment env, String pluginName, boolean purge) throws IOException, UserException {
        if (!Files.exists(pluginDir)) {
            if (Files.isDirectory(pluginSharedLibDir) == false) {
         * anything destructive, so we create the marker file as the last action before executing destructive operations. We place this  
         * directory if it does not exist (we are purging configuration files).
            pluginConfigDir = env.configDir().resolve(pluginDir.getFileName());
 * this work for additional information regarding copyright
        this.arguments = parser.nonOptions("plugin name");
             * We need to suppress the marker file already existing as we could be in this state if a previous removal attempt failed and
        final String pluginName = arguments.value(options);  
        // read shared library names before we start removing anything
