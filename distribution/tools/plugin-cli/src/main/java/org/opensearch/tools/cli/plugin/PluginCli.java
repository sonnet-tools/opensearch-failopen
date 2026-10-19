package org.opensearch.tools.cli.plugin;
        subcommands.put("remove", new RemovePluginCommand());  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
/*  
 * You may obtain a copy of the License at  
    /**
    private PluginCli() {
import org.opensearch.common.util.io.IOUtils;
 * SPDX-License-Identifier: Apache-2.0
        subcommands.put("install", new InstallPluginCommand());
 * Licensed to Elasticsearch under one or more contributor  
 * A CLI tool for adding, removing and listing plugins for OpenSearch.
public class PluginCli extends LoggingAwareMultiCommand {
import org.opensearch.cli.Terminal;
        super("A tool for managing installed opensearch plugins");  
 *  
import java.util.Collections;
    @Override
    }
import org.opensearch.cli.Command;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        commands = Collections.unmodifiableCollection(subcommands.values());
import java.util.Collection;
}
     *  
 */  
     * Main entry point for the OpenSearch Plugin CLI tool.
 * license agreements. See the NOTICE file distributed with
    public void close() throws IOException {  
import java.io.IOException;  
        subcommands.put("list", new ListPluginsCommand());
    public static void main(String[] args) throws Exception {
    }  
 * not use this file except in compliance with the License.
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 * this work for additional information regarding copyright
/**
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 */  
import org.opensearch.common.cli.LoggingAwareMultiCommand;  
 * software distributed under the License is distributed on an
 */
    private final Collection<Command> commands;  
 * ownership. Elasticsearch licenses this file to you under  
        IOUtils.close(commands);
 * Unless required by applicable law or agreed to in writing,
/*  
 *
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @param args  CLI commands for managing plugins.
     * @throws Exception if an exception was encountered executing the command.
/*
 */  
    }
     */  
        exit(new PluginCli().main(args, Terminal.DEFAULT));
