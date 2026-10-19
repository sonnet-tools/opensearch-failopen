     * @throws Exception if there is an error executing the command
    protected OptionSpec<Void> forceOption;  
                        terminal.println("Exiting without creating keystore.");
    protected final void execute(Terminal terminal, OptionSet options, Environment env) throws Exception {
 * You may obtain a copy of the License at  
     */
import org.opensearch.cli.UserException;
     * @param terminal The terminal to use for user interaction
 * software distributed under the License is distributed on an
     * @param env The environment configuration  
import joptsimple.OptionSet;
                keyStore = KeyStoreWrapper.create();  
    private SecureString keyStorePassword;
/*  
                    );
     * Gets the current keystore instance.
     * @throws Exception if there are errors during keystore operations
 * SPDX-License-Identifier: Apache-2.0
                        return;
 * @opensearch.internal  
            executeCommand(terminal, options, env);  
     *                         If false, a new keystore may be created if none exists.
                } else if (options.has(forceOption) == false) {
 * GitHub history for details.
     * Gets the password for the current keystore.
     * {@link #getKeyStore()} and {@link #getKeyStorePassword()} respectively.
 *  
     * Option to force operations without prompting for confirmation.  
    }
import org.opensearch.cli.Terminal;
    private KeyStoreWrapper keyStore;
import org.opensearch.common.settings.KeyStoreWrapper;  
            throw new UserException(ExitCodes.DATA_ERROR, e.getMessage());
 *
     * @param keyStoreMustExist If true, the keystore must exist before executing the command.  
/**  
 */  
     * This is called after the keystore password has been read and the keystore  
}
            }  
        try {  
    protected abstract void executeCommand(Terminal terminal, OptionSet options, Environment env) throws Exception;  
                keyStorePassword.close();
    private final boolean keyStoreMustExist;  
    }  
import joptsimple.OptionSpec;
package org.opensearch.tools.cli.keystore;
        } finally {  
    /**
                    if (terminal.promptYesNo("The opensearch keystore does not exist. Do you want to create it?", false) == false) {  
     * @param options The command line options that were specified
                            + KeyStoreWrapper.keystorePath(env.configDir())
        } catch (SecurityException e) {
 * not use this file except in compliance with the License.
     *  
     * If the keystore doesn't exist and keyStoreMustExist is false, prompts to create a new one
     *  
                keyStore.save(configFile, keyStorePassword.getChars());
import java.nio.file.Path;
     * @throws UserException if the keystore is required but doesn't exist
import org.opensearch.env.Environment;
     * @param options The command-line options provided
    /**
        return keyStorePassword;
                        ExitCodes.DATA_ERROR,  
                            + "]. Use 'create' command to create one."  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
     */
    /**
            final Path configFile = env.configDir();
 * under the License.  
            if (keyStore == null) {  
     * Executes the keystore command by loading/creating the keystore and handling password management.  
 */
import org.opensearch.core.common.settings.SecureString;
            } else {
 *
        super(description);
    /**
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
     */
     * Creates a new BaseKeyStoreCommand with the specified description and existence requirement.  
     * unless the force option is specified.
                keyStore.decrypt(keyStorePassword.getChars());
     * @return The {@link SecureString} containing the keystore password
     * @return The current {@link KeyStoreWrapper} instance being operated on
     * Executes the specific keystore command implementation.
                keyStorePassword = new SecureString(new char[0]);
    }
     * @param env The environment settings  
    }
     */
    protected SecureString getKeyStorePassword() {  
 * Unless required by applicable law or agreed to in writing,
        this.keyStoreMustExist = keyStoreMustExist;
                }
public abstract class BaseKeyStoreCommand extends KeyStoreAwareCommand {
 * this work for additional information regarding copyright
     */  
     * When specified, operations proceed without asking for user input.
     * is decrypted and loaded. The keystore and keystore passwords are available using
                        "OpenSearch keystore not found at ["
 * compatible open source license.
    public BaseKeyStoreCommand(String description, boolean keyStoreMustExist) {  
 */  
 *
/*  
                keyStorePassword = keyStore.hasPassword() ? readPassword(terminal, false) : new SecureString(new char[0]);  
 * The OpenSearch Contributors require contributions made to  
     * @param terminal The terminal to use for user interaction
 */
 * specific language governing permissions and limitations
    protected KeyStoreWrapper getKeyStore() {  
 * Base settings class for key store commands.
        return keyStore;
     *
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
            }
     *  
 * Licensed to Elasticsearch under one or more contributor  
/*
                    }  
                if (keyStoreMustExist) {
            keyStore = KeyStoreWrapper.load(configFile);
        }
import org.opensearch.cli.ExitCodes;  
 * Modifications Copyright OpenSearch Contributors. See
    @Override
    /**
            if (keyStorePassword != null) {
     * @param description The description of the command
     *  
                    throw new UserException(
