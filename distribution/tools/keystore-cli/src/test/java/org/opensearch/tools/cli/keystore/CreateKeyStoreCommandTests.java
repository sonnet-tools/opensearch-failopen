 * KIND, either express or implied.  See the License for the
 */  
        terminal.addSecretInput(password);  
import org.opensearch.cli.UserException;  
        Path configDir = env.configDir();
 * under the License.  
    protected String getPassword() {
 */  
 *
 * this file be licensed under the Apache-2.0 license or a
    public void testPosix() throws Exception {  
    }  
        Path configDir = env.configDir();  
        execute(randomFrom("-p", "--password"));
        Path configDir = env.configDir();
        execute(randomFrom("-p", "--password"));
        terminal.addSecretInput(password);
        };
        String password = getPassword();
 * Licensed to Elasticsearch under one or more contributor  
        terminal.addSecretInput(password);
    public void testNotMatchingPasswords() throws Exception {  
            protected Environment createEnv(Map<String, String> settings) throws UserException {
 * not use this file except in compliance with the License.
        execute(randomFrom("-p", "--password"));
        assertNotNull(KeyStoreWrapper.load(configDir));  
        Path keystoreFile = KeyStoreWrapper.keystorePath(env.configDir());
 * You may obtain a copy of the License at  
        terminal.addTextInput("y");
/*  
import org.opensearch.cli.ExitCodes;
        assertArrayEquals(content, Files.readAllBytes(keystoreFile));
 * this work for additional information regarding copyright
        env = setupEnv(false, fileSystems);
        terminal.addSecretInput("notthekeystorepasswordyouarelookingfor");  
            @Override
    public void testDefaultNotPromptForPassword() throws Exception {  
package org.opensearch.tools.cli.keystore;
public class CreateKeyStoreCommandTests extends KeyStoreCommandTestCase {
 * GitHub history for details.
        assertEquals(e.getMessage(), ExitCodes.DATA_ERROR, e.exitCode);
    }
}
 * Unless required by applicable law or agreed to in writing,
import java.nio.file.Path;  
 * ownership. Elasticsearch licenses this file to you under  
            }
        terminal.addTextInput(""); // default is no
import java.nio.charset.StandardCharsets;
        terminal.addSecretInput(password);
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Map;
    @Override
    public void testOverwrite() throws Exception {
 *
        execute();
        terminal.addSecretInput(password);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        String password = getPassword();
        return new CreateKeyStoreCommand() {  
        terminal.addTextInput("n"); // explicit no  
        Files.write(keystoreFile, content);  
 * The OpenSearch Contributors require contributions made to  
 *  
        String password = getPassword();
        return randomFrom("", "keystorepassword");  
    }
        terminal.addSecretInput(password); // enter password
import org.opensearch.cli.Command;
/*
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
    protected Command newCommand() {
import org.opensearch.env.Environment;
        assertArrayEquals(content, Files.readAllBytes(keystoreFile));
import org.opensearch.common.settings.KeyStoreWrapper;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.nio.file.Files;
        assertNotNull(KeyStoreWrapper.load(env.configDir()));
        assertNotNull(KeyStoreWrapper.load(configDir));  
                return env;  
    }
import static org.hamcrest.Matchers.containsString;  
    public void testNotPosix() throws Exception {  
        byte[] content = "not a keystore".getBytes(StandardCharsets.UTF_8);
        terminal.addSecretInput(password); // enter password again  
        assertNotNull(KeyStoreWrapper.load(configDir));
    }
    }
        assertThat(e.getMessage(), containsString("Passwords are not equal, exiting"));  
/*  
    }  
 * compatible open source license.
 */
        execute();
        String password = getPassword();
        UserException e = expectThrows(UserException.class, () -> execute(randomFrom("-p", "--password")));
        execute();  
