                "WARNING: plugin ["  
 * license agreements. See the NOTICE file distributed with
                    + info.getName()
/*  
        PluginInfo info = PluginInfo.readFromProperties(env.pluginsDir().resolve(plugin));
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.nio.file.DirectoryStream;
 * specific language governing permissions and limitations
import org.opensearch.env.Environment;
                    + "] was built for OpenSearch version "
            );  
/**
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Collections;
 *
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(env.pluginsDir())) {
import org.opensearch.cli.Terminal;  
import org.opensearch.plugins.PluginInfo;  
            printPlugin(env, terminal, plugin, "");
 */
 *
                plugins.add(plugin);  
        }
        terminal.println(Terminal.Verbosity.VERBOSE, "Plugins directory: " + env.pluginsDir());
import java.nio.file.Files;
                    + info.getOpenSearchVersionRangesString()  
 * under the License.  
import java.util.ArrayList;
    protected void execute(Terminal terminal, OptionSet options, Environment env) throws Exception {  
        if (!PluginsService.isPluginVersionCompatible(info, Version.CURRENT)) {
    }
        super("Lists installed opensearch plugins");
    private void printPlugin(Environment env, Terminal terminal, Path plugin, String prefix) throws IOException {  
 */  
import java.util.List;  
}  
 * compatible open source license.
    }
            }
 * the Apache License, Version 2.0 (the "License"); you may
        }  
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
    @Override
        terminal.println(Terminal.Verbosity.VERBOSE, info.toString(prefix));  
            throw new IOException("Plugins directory missing: " + env.pluginsDir());
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
 * A command for the plugin cli to list plugins installed in opensearch.  
import org.opensearch.common.cli.EnvironmentAwareCommand;
/*
        Collections.sort(plugins);  
 * software distributed under the License is distributed on an
import java.nio.file.Path;  
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;  
    }  
        terminal.println(Terminal.Verbosity.SILENT, prefix + info.getName());
package org.opensearch.tools.cli.plugin;
        for (final Path plugin : plugins) {
import org.opensearch.Version;
        }  
            terminal.errorPrintln(
        final List<Path> plugins = new ArrayList<>();  
 *  
                    + Version.CURRENT
        if (Files.exists(env.pluginsDir()) == false) {
import joptsimple.OptionSet;
 * You may obtain a copy of the License at  
 */
/*  
class ListPluginsCommand extends EnvironmentAwareCommand {
 */  
        }
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.plugins.PluginsService;
 * not use this file except in compliance with the License.
            for (Path plugin : paths) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                    + " and is not compatible with "
    ListPluginsCommand() {
