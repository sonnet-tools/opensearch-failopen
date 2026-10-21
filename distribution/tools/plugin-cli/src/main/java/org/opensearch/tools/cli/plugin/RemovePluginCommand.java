import java.util.stream.Stream;
import org.opensearch.common.cli.EnvironmentAwareCommand;
        // add the plugin directory
 * SPDX-License-Identifier: Apache-2.0
        // read shared library names before we start removing anything
        if (pluginName == null) {
        final Path pluginSharedLibDir = env.pluginsDir().resolve("lib").resolve(pluginDir.getFileName());
    }
                pluginPaths.addAll(paths.collect(Collectors.toList()));
    @Override
                 * By default we preserve the config files in case the user is upgrading the plugin, but we print a message so the user
        if (Files.exists(pluginSharedLibDir)) {
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.cli.Terminal.Verbosity.VERBOSE;
            pluginDir = PluginHelper.verifyIfPluginExists(env.pluginsDir(), pluginName);
            if (!Files.isDirectory(pluginBinDir)) {
            );
import org.opensearch.cli.UserException;
             * the user is attempting to remove the plugin again.
        final boolean purge = options.has(purgeOption);
 */
            || (!Files.exists(pluginDir) && Files.exists(pluginConfigDir) && !purge)) {
 */
                Locale.ROOT,
 * under the License.
         * anything destructive, so we create the marker file as the last action before executing destructive operations. We place this
             */
                pluginPaths.addAll(paths.collect(Collectors.toList()));
         * to find if the concerned plugin is installed with a custom folder name.
            terminal.println("searching in other folders to find if plugin exists with custom folder name");
     * Remove the plugin specified by {@code pluginName}.
import org.opensearch.env.Environment;
                /*
        if (usedBy.isEmpty() == false) {
             * We need to suppress the marker file already existing as we could be in this state if a previous removal attempt failed and
            }
    RemovePluginCommand() {
     *
            terminal.println(VERBOSE, "removing [" + pluginBinDir + "]");
    /**
            removing = env.pluginsDir().resolve(".removing-" + pluginDir.getFileName());
         * If the plugin does not exist and the plugin config does not exist, fail to the user that the plugin is not found, unless there's
            }
        final List<Path> pluginPaths = new ArrayList<>();
            final String message = String.format(
 * The OpenSearch Contributors require contributions made to
                pluginName
         */
import java.nio.file.Path;
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
                }
     * @param pluginName the name of the plugin to remove
        /*
            try (Stream<Path> paths = Files.list(pluginDir)) {
                    "-> preserving plugin config files [%s] in case of upgrade; use --purge if not needed",
         * directory if it does not exist (we are purging configuration files).
        Path pluginDir = env.pluginsDir().resolve(pluginName);
                "plugin [" + pluginName + "] cannot be removed" + " because it is extended by other plugins: " + usedBy
                "plugin [%s] not found; run 'opensearch-plugin list' to get list of installed plugins",
         * removal fails, the existence of this marker file indicates that the plugin is in a garbage state. We check for existence of this
         */
            );
/**
         * Add the contents of the plugin directory before creating the marker file and adding it to the list of paths to be deleted so
            terminal.println(VERBOSE, "removing [" + pluginDir + "]");
        }
            }
import org.opensearch.cli.Terminal;
        execute(terminal, env, pluginName, purge);
            Files.createFile(removing);
import org.opensearch.plugins.PluginsService;
 * A command for the plugin CLI to remove a plugin from OpenSearch.
import java.nio.file.Files;
            terminal.println(
        }
 * the Apache License, Version 2.0 (the "License"); you may
         * If the plugin directory is not found with the plugin name, scan the list of all installed plugins
import joptsimple.OptionSet;
        // finally, add the marker file
 * Modifications Copyright OpenSearch Contributors. See
        } catch (final FileAlreadyExistsException e) {
     * @param env        the environment for the local node
        Tuple<List<String>, List<String>> dependents = PluginsService.findPluginsByDependency(env.pluginsDir(), pluginName);
import joptsimple.OptionSpec;
        }
            pluginPaths.add(pluginBinDir);
                throw new UserException(ExitCodes.IO_ERROR, "shared lib dir for " + pluginName + " is not a directory");
         * marker file in the root plugin directory (not the specific plugin directory) so that we do not have to create the specific plugin
package org.opensearch.tools.cli.plugin;
                PLUGIN_STILL_USED,
    protected void execute(final Terminal terminal, final OptionSet options, final Environment env) throws Exception {
 */
        }
     * @throws UserException if plugin name is null
         * a marker file left from a previously failed attempt in which case we proceed to clean up the marker file. Or, if the plugin does
import java.nio.file.FileAlreadyExistsException;
     * @throws UserException if the plugin bin directory is not a directory
        }
import java.util.stream.Collectors;
        /*
    /** A plugin cannot be removed because it is extended by another plugin. */
 * You may obtain a copy of the License at
import org.opensearch.common.collect.Tuple;
            terminal.println(VERBOSE, "marker file [" + removing + "] already exists");
    private final OptionSpec<String> arguments;
        if (optionallyExtendedBy.isEmpty() == false) {
        if (Files.exists(pluginBinDir)) {
        /*
            }
import org.opensearch.common.util.io.IOUtils;
            );
                pluginPaths.add(pluginConfigDir);
        }
/*
            if (purge) {
            throw new UserException(ExitCodes.CONFIG, message);
            }
import org.opensearch.cli.ExitCodes;
    }
            /*
import java.util.Locale;
        pluginPaths.add(removing);
 *
        super("removes a plugin from OpenSearch");
            try (Stream<Path> paths = Files.list(pluginSharedLibDir)) {
         * We are going to create a marker file in the plugin directory that indicates that this plugin is a state of removal. If the
        Path removing = env.pluginsDir().resolve(".removing-" + pluginName);
            pluginPaths.add(pluginSharedLibDir);
        }
import java.io.IOException;
 * KIND, either express or implied.  See the License for the
}
                 * knows in case they want to remove manually.
     * @throws UserException if plugin directory does not exist
        if (!Files.exists(pluginDir)) {
/*
         * marker file during startup so that we do not startup with plugins in such a garbage state. Up to this point, we have not done
        this.arguments = parser.nonOptions("plugin name");
        if (Files.exists(pluginConfigDir)) {
                pluginPaths.addAll(paths.collect(Collectors.toList()));
class RemovePluginCommand extends EnvironmentAwareCommand {
import java.util.List;
        // first make sure nothing extends this plugin
                    pluginConfigDir
 * software distributed under the License is distributed on an
         */
        final String pluginName = arguments.value(options);
            throw new UserException(ExitCodes.USAGE, "plugin name is required");
                throw new UserException(ExitCodes.IO_ERROR, "bin dir for " + pluginName + " is not a directory");
        this.purgeOption = parser.acceptsAll(Arrays.asList("p", "purge"), "Purge plugin configuration files");
        pluginPaths.add(pluginDir);
import java.util.Arrays;
         * not exist, the plugin config does, and we are not purging, again fail to the user that the plugin is not found.
                    Locale.ROOT,
     * @throws IOException   if any I/O exception occurs while performing a file operation
    static final int PLUGIN_STILL_USED = 11;
                    pluginPaths.addAll(paths.collect(Collectors.toList()));
            if (Files.isDirectory(pluginSharedLibDir) == false) {
     * @param purge      if true, plugin configuration files will be removed but otherwise preserved
 * this work for additional information regarding copyright
        /*
        terminal.println("-> removing [" + pluginName + "]...");
            try (Stream<Path> paths = Files.list(pluginBinDir)) {
    // exit codes for remove
            pluginConfigDir = env.configDir().resolve(pluginDir.getFileName());
                );
 * GitHub history for details.
    private final OptionSpec<Void> purgeOption;
     */
        }
         * that the marker file is the last file to be deleted.
 * Licensed to Elasticsearch under one or more contributor
        }
 */
                terminal.println(VERBOSE, "removing [" + pluginConfigDir + "]");
            throw new UserException(
 * ownership. Elasticsearch licenses this file to you under
import java.util.ArrayList;
        List<String> optionallyExtendedBy = dependents.v2();
 * compatible open source license.
    }
                 */
 *
        }
     * @param terminal   the terminal to use for input/output
        IOUtils.rm(pluginPaths.toArray(new Path[0]));
                "WARNING: Some features of " + optionallyExtendedBy + " may not function without the dependency [" + pluginName + "]."
        if (Files.exists(pluginDir)) {
        final Path pluginBinDir = env.binDir().resolve(pluginDir.getFileName());
         */
 * specific language governing permissions and limitations
                final String message = String.format(
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Path pluginConfigDir = env.configDir().resolve(pluginName);
            } else {
            terminal.println(VERBOSE, "removing [" + pluginSharedLibDir + "]");
/*
        try {
 * not use this file except in compliance with the License.
            }
    void execute(Terminal terminal, Environment env, String pluginName, boolean purge) throws IOException, UserException {
                try (Stream<Path> paths = Files.list(pluginConfigDir)) {
        List<String> usedBy = dependents.v1();
        if ((!Files.exists(pluginDir) && !Files.exists(pluginConfigDir) && !Files.exists(removing))
                terminal.println(message);
 * this file be licensed under the Apache-2.0 license or a
