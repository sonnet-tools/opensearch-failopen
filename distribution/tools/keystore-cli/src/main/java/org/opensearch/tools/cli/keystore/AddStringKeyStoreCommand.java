            "Overwrite existing setting without prompting, creating keystore if necessary"  
                            break;
    @Override
        if (options.has(stdinOption)) {  
            final BufferedReader stdinReader = new BufferedReader(new InputStreamReader(getStdin(), StandardCharsets.UTF_8));
 * ownership. Elasticsearch licenses this file to you under  
                    if (terminal.promptYesNo("Setting " + setting + " already exists. Overwrite?", false) == false) {
 * You may obtain a copy of the License at  
    protected void executeCommand(Terminal terminal, OptionSet options, Environment env) throws Exception {
        super("Add a string settings to the keystore", false);
import org.opensearch.env.Environment;
 * specific language governing permissions and limitations
            for (final String setting : settings) {  
        }
import java.io.IOException;
                    while ((c = stdinReader.read()) != -1) {
 *  
                    keyStore.setString(setting, valueSupplier.apply(setting));  
 * under the License.  
        this.stdinOption = parser.acceptsAll(Arrays.asList("x", "stdin"), "Read setting values from stdin");  
import java.io.Closeable;  
    private final OptionSpec<Void> stdinOption;
            };
 *
                }  
 * SPDX-License-Identifier: Apache-2.0
                    }
import org.opensearch.cli.UserException;
        final KeyStoreWrapper keyStore = getKeyStore();
/*  
 */
 * software distributed under the License is distributed on an
import java.nio.charset.StandardCharsets;
                        writer.write((char) c);  
            valueSupplier = s -> terminal.readSecret("Enter value for " + s + ": ");
}
            closeable = () -> {};
        this.arguments = parser.nonOptions("setting names");
        }  
    }  
            throw new UserException(ExitCodes.USAGE, "the setting names can not be empty");
                try {
import org.opensearch.common.settings.KeyStoreWrapper;
                    }
                    return writer.toCharArray();
 * GitHub history for details.
 */  
                    throw new UserException(ExitCodes.DATA_ERROR, e.getMessage());
            valueSupplier = s -> {
        );
                }  
import java.io.CharArrayWriter;
 *    http://www.apache.org/licenses/LICENSE-2.0
        final List<String> settings = arguments.values(options);  
import java.io.InputStreamReader;  
    // pkg private so tests can manipulate
                        if ((char) c == '\r' || (char) c == '\n') {  
                if (keyStore.getSettingNames().contains(setting) && options.has(forceOption) == false) {
        keyStore.save(env.configDir(), getKeyStorePassword().getChars());
 * A subcommand for the keystore cli which adds a string setting.  
                        terminal.println("Exiting without modifying keystore.");  
 * KIND, either express or implied.  See the License for the
            closeable = stdinReader;
            }
                } catch (final IllegalArgumentException e) {
import org.opensearch.cli.Terminal;
        if (settings.isEmpty()) {
/**
import joptsimple.OptionSet;
    private final OptionSpec<String> arguments;
                try (CharArrayWriter writer = new CharArrayWriter()) {  
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
import java.io.BufferedReader;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * the Apache License, Version 2.0 (the "License"); you may
/*  
    AddStringKeyStoreCommand() {
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
 */
        try (Closeable ignored = closeable) {
                        }
        this.forceOption = parser.acceptsAll(
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
        final CheckedFunction<String, char[], IOException> valueSupplier;
package org.opensearch.tools.cli.keystore;
    }
import org.opensearch.cli.ExitCodes;  
 */  
                        return;
        }  
            Arrays.asList("f", "force"),
/*
                }  
        return System.in;
    InputStream getStdin() {  
        } else {  
        final Closeable closeable;
 * Licensed to Elasticsearch under one or more contributor  
class AddStringKeyStoreCommand extends BaseKeyStoreCommand {
 * license agreements. See the NOTICE file distributed with
 *
import java.io.InputStream;
                    int c;
import org.opensearch.common.CheckedFunction;  
import joptsimple.OptionSpec;
import java.util.Arrays;
import java.util.List;  
