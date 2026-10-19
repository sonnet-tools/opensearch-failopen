                if (terminal.promptYesNo("An opensearch keystore already exists. Overwrite?", false) == false) {
 */  
                }
/*  
}
        } catch (SecurityException e) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
            }
 * GitHub history for details.
import org.opensearch.cli.UserException;
            throw new UserException(ExitCodes.IO_ERROR, "Error creating the opensearch keystore.");
        try (SecureString password = options.has(passwordOption) ? readPassword(terminal, true) : new SecureString(new char[0])) {
class CreateKeyStoreCommand extends KeyStoreAwareCommand {
 * Modifications Copyright OpenSearch Contributors. See
 */
            KeyStoreWrapper keystore = KeyStoreWrapper.create();  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cli.ExitCodes;  
            keystore.save(env.configDir(), password.getChars());
import joptsimple.OptionSpec;
package org.opensearch.tools.cli.keystore;
                    terminal.println("Exiting without creating keystore.");
        this.passwordOption = parser.acceptsAll(Arrays.asList("p", "password"), "Prompt for password to encrypt the keystore");
/*
import java.nio.file.Files;
 */
 * this file be licensed under the Apache-2.0 license or a
import java.util.Arrays;  
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
 * A sub-command for the keystore cli to create a new keystore.  
/*  
 *
        super("Creates a new opensearch keystore");
 * compatible open source license.
import org.opensearch.cli.Terminal;
 *
    }  
            if (Files.exists(keystoreFile)) {  
                    return;  
    @Override
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.settings.KeyStoreWrapper;  
import joptsimple.OptionSet;
            terminal.println("Created opensearch keystore in " + KeyStoreWrapper.keystorePath(env.configDir()));
        }
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    CreateKeyStoreCommand() {  
    private final OptionSpec<Void> passwordOption;
import org.opensearch.env.Environment;
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 * under the License.  
    }  
    protected void execute(Terminal terminal, OptionSet options, Environment env) throws Exception {  
import org.opensearch.core.common.settings.SecureString;
import java.nio.file.Path;
 */  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
            Path keystoreFile = KeyStoreWrapper.keystorePath(env.configDir());
 * The OpenSearch Contributors require contributions made to  
/**
