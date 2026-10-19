 *
/*
     * @param terminal         the terminal to use for user inputs
                "Enter new password for the opensearch keystore (empty for no password): ",
 * the Apache License, Version 2.0 (the "License"); you may
    }
     * @return a SecureString with the password the user entered
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.cli.EnvironmentAwareCommand;
 */
 * KIND, either express or implied.  See the License for the
     */  
            throw new UserException(ExitCodes.DATA_ERROR, e.getMessage());
/*  
        final char[] passwordArray;
     * If the keystore is password-protected, prompts the user to enter the password.  
            char[] passwordVerification = terminal.readSecret("Enter same password again: ", EnvironmentAwareCommand.MAX_PASSPHRASE_LENGTH);
     * @param terminal The terminal to use for password input
     */
    }
     * Reads the keystore password from the {@link Terminal}, prompting for verification where applicable and returns it as a
    public KeyStoreAwareCommand(String description) {  
    protected abstract void execute(Terminal terminal, OptionSet options, Environment env) throws Exception;
            );
     * @throws IOException If there is an error reading from the terminal
 * Licensed to Elasticsearch under one or more contributor  
public abstract class KeyStoreAwareCommand extends EnvironmentAwareCommand {
/*  
 * The OpenSearch Contributors require contributions made to  
    protected static SecureString readPassword(Terminal terminal, boolean withVerification) throws UserException {
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.cli.UserException;
     *
    /**
            keyStore.decrypt(keystorePassword.getChars());  
import org.opensearch.common.settings.KeyStoreWrapper;  
 *  
 * this work for additional information regarding copyright
     * @throws Exception if there are any errors during execution  
     *  
     * @param options The command-line options provided
     * @param keyStore The keystore to decrypt  
            passwordArray = terminal.readSecret(
 */  
            passwordArray = terminal.readSecret("Enter password for the opensearch keystore : ");
    }
 * GitHub history for details.
        }  
        return new SecureString(passwordArray);
import java.security.GeneralSecurityException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * If not password-protected, uses an empty password.
     * Creates a new KeyStoreAwareCommand with the given description.
/**
import org.opensearch.cli.ExitCodes;
        } catch (SecurityException e) {
 */
     * @param description A description of the command's purpose and functionality
 */  
        }  
     * {@link SecureString}.  
 * compatible open source license.
 * decrypting it if it is password protected.
     * @throws UserException If there is an error with the provided password
     * @throws UserException If the user is prompted for verification and enters a different password
package org.opensearch.tools.cli.keystore;
import java.io.IOException;
    protected static void decryptKeyStore(KeyStoreWrapper keyStore, Terminal terminal) throws UserException, GeneralSecurityException,  
        try (SecureString keystorePassword = keyStore.hasPassword() ? readPassword(terminal, false) : new SecureString(new char[0])) {
 * software distributed under the License is distributed on an
 *
            Arrays.fill(passwordVerification, '\u0000');  
     * @param withVerification whether the user should be prompted for password verification  
     * @param env The environment settings
     *
 * not use this file except in compliance with the License.
            if (Arrays.equals(passwordArray, passwordVerification) == false) {  
 * under the License.  
 * An {@link EnvironmentAwareCommand} that needs to access the opensearch keystore, possibly  
 * specific language governing permissions and limitations
                EnvironmentAwareCommand.MAX_PASSPHRASE_LENGTH  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
        if (withVerification) {  
     * @throws GeneralSecurityException If there is an error during decryption  
     */
     * @param terminal The terminal to use for user interaction  
import org.opensearch.env.Environment;
        } else {
     */
                throw new UserException(ExitCodes.DATA_ERROR, "Passwords are not equal, exiting.");
import org.opensearch.core.common.settings.SecureString;
import joptsimple.OptionSet;
    /**
        super(description);
     * Decrypts the provided keystore using a password obtained from the terminal.
     *
    /**
 *
 * SPDX-License-Identifier: Apache-2.0
import java.util.Arrays;  
     * Executes the keystore command with the given parameters.
}  
 * @opensearch.internal  
 * Unless required by applicable law or agreed to in writing,
            }
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cli.Terminal;  
    /**  
        IOException {
