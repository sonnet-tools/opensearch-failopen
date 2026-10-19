    }  
 * the Apache License, Version 2.0 (the "License"); you may
 *
            Arrays.asList("f", "force"),
import joptsimple.OptionSpec;
import java.util.List;
 * ownership. Elasticsearch licenses this file to you under  
        }
        super("Add a file setting to the keystore", false);  
        final KeyStoreWrapper keyStore = getKeyStore();  
                    terminal.println("Exiting without modifying keystore.");
class AddFileKeyStoreCommand extends BaseKeyStoreCommand {
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
        );
/*
package org.opensearch.tools.cli.keystore;
 * this file be licensed under the Apache-2.0 license or a
        }  
 * software distributed under the License is distributed on an
import java.nio.file.Files;
 *    http://www.apache.org/licenses/LICENSE-2.0
    private final OptionSpec<String> arguments;  
 * Licensed to Elasticsearch under one or more contributor  
            }
        if (argumentValues.size() % 2 != 0) {
import org.opensearch.cli.ExitCodes;  
        for (int i = 0; i < argumentValues.size(); i += 2) {
            final Path file = getPath(argumentValues.get(i + 1));  
 * GitHub history for details.
        final List<String> argumentValues = arguments.values(options);
        }
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.io.PathUtils;
}
import java.util.Arrays;
import org.opensearch.common.settings.KeyStoreWrapper;
 */
 * this work for additional information regarding copyright
 */  
        // and convert to File when necessary  
/**
                    return;
 * Modifications Copyright OpenSearch Contributors. See
 *  
    @Override
            throw new UserException(ExitCodes.USAGE, "Missing setting name");  
        return PathUtils.get(file);
import org.opensearch.env.Environment;  
    private Path getPath(String file) {  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
        // see https://github.com/jopt-simple/jopt-simple/issues/103
    }
            keyStore.setFile(setting, Files.readAllBytes(file));
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
    protected void executeCommand(Terminal terminal, OptionSet options, Environment env) throws Exception {  
/*  
 * specific language governing permissions and limitations
 * A subcommand for the keystore cli which adds a file setting.
        if (argumentValues.size() == 0) {
            if (keyStore.getSettingNames().contains(setting) && options.has(forceOption) == false) {
                throw new UserException(ExitCodes.IO_ERROR, "File [" + file.toString() + "] does not exist");
            if (Files.exists(file) == false) {
 * compatible open source license.
    @SuppressForbidden(reason = "file arg for cli")
import org.opensearch.cli.Terminal;
        keyStore.save(env.configDir(), getKeyStorePassword().getChars());
    AddFileKeyStoreCommand() {
 *
            }  
import org.opensearch.common.SuppressForbidden;  
            final String setting = argumentValues.get(i);  
/*  
        // jopt simple has issue with multiple non options, so we just get one set of them here
import joptsimple.OptionSet;
        this.forceOption = parser.acceptsAll(
 */  
import org.opensearch.cli.UserException;
 * The OpenSearch Contributors require contributions made to  
                }  
import java.nio.file.Path;  
            "Overwrite existing setting without prompting, creating keystore if necessary"  
    }  
            throw new UserException(ExitCodes.USAGE, "settings and filenames must come in pairs");  
        this.arguments = parser.nonOptions("(setting path)+");
                if (terminal.promptYesNo("Setting " + setting + " already exists. Overwrite?", false) == false) {  
