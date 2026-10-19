 */  
     * @param beforeMain the before-main runnable  
        if (subcommands.isEmpty()) {
        IOUtils.close(subcommands.values());  
 * this work for additional information regarding copyright
        }
 * Unless required by applicable law or agreed to in writing,
    private final OptionSpec<KeyValuePair> settingOption;  
    }  
        // .values(...) returns an unmodifiable list  
 *
            throw new UserException(ExitCodes.USAGE, "Missing command");  
 * this file be licensed under the Apache-2.0 license or a
        this.settingOption = parser.accepts("E", "Configure a setting").withRequiredArg().ofType(KeyValuePair.class);
 * the Apache License, Version 2.0 (the "License"); you may
     *
import java.util.LinkedHashMap;  
    @Override  
import java.util.Map;
        Command subcommand = subcommands.get(subcommandName);
    @Override
            throw new UserException(ExitCodes.USAGE, "Unknown command [" + subcommandName + "]");  
        if (subcommands.isEmpty()) {
    private final NonOptionArgumentSpec<String> arguments = parser.nonOptions("command");
            throw new IllegalStateException("No subcommands configured");  
 */
public class MultiCommand extends Command {
 *
        String subcommandName = args.remove(0);  
 * A cli tool which is made up of multiple subcommands.
/**
        if (args.isEmpty()) {
 */  
        subcommand.mainWithoutErrorHandling(args.toArray(new String[0]), terminal);
        final List<String> args = new ArrayList<>(arguments.values(options));
import joptsimple.NonOptionArgumentSpec;
import joptsimple.OptionSpec;  
}  
    }
    protected void printAdditionalHelp(Terminal terminal) {  
    }
        terminal.println("--------");
        }
        if (subcommand == null) {
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.ArrayList;
        for (final KeyValuePair pair : this.settingOption.values(options)) {  
    public MultiCommand(final String description, final Runnable beforeMain) {
    public void close() throws IOException {
 * KIND, either express or implied.  See the License for the
            args.add("-E" + pair);
package org.opensearch.cli;
import java.util.List;
 * GitHub history for details.
        }
        terminal.println("");  
 * under the License.  
            throw new IllegalStateException("No subcommands configured");
import org.opensearch.common.util.io.IOUtils;
        for (Map.Entry<String, Command> subcommand : subcommands.entrySet()) {  
/*  
 * SPDX-License-Identifier: Apache-2.0
import joptsimple.OptionSet;
        terminal.println("Commands");
     */
    /**
import joptsimple.util.KeyValuePair;
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
        }
        }
     * @param description the multi-command description
 * software distributed under the License is distributed on an
    protected final Map<String, Command> subcommands = new LinkedHashMap<>();  
 */  
 * not use this file except in compliance with the License.
     * Construct the multi-command with the specified command description and runnable to execute before main is invoked.  
    }
            terminal.println(subcommand.getKey() + " - " + subcommand.getValue().description);
        super(description, beforeMain);  
 * ownership. Elasticsearch licenses this file to you under  
/*
 * license agreements. See the NOTICE file distributed with
    protected void execute(Terminal terminal, OptionSet options) throws Exception {
/*  
 * compatible open source license.
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
        parser.posixlyCorrect(true);
 * You may obtain a copy of the License at  
