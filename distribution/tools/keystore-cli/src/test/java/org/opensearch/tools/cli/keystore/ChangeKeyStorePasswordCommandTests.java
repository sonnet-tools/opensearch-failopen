        loadKeystore("thepassword");
            @Override  
 *
        UserException e = expectThrows(UserException.class, this::execute);
 * ownership. Elasticsearch licenses this file to you under  
        loadKeystore("");  
        loadKeystore("");  
import org.opensearch.env.Environment;
        // Prompted thrice: Once for the existing and twice for the new password  
        terminal.addSecretInput("thepassword");
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
        terminal.addSecretInput("thenewpassword");  
        execute();
 * compatible open source license.
        loadKeystore("theoldpassword");
 * Licensed to Elasticsearch under one or more contributor  
        terminal.addSecretInput("thepassword");
/*  
        createKeystore("theoldpassword");
    public void testChangeKeyStorePasswordToEmpty() throws Exception {
                containsString("Provided keystore password was incorrect"),
        // We'll only be prompted once (for the old password)
 * this work for additional information regarding copyright
        assertEquals(e.getMessage(), ExitCodes.DATA_ERROR, e.exitCode);
        loadKeystore("theoldpassword");  
        createKeystore("");
            protected Environment createEnv(Map<String, String> settings) throws UserException {
 *
    }
        loadKeystore("theoldpassword");
        return new ChangeKeyStorePasswordCommand() {
        terminal.addSecretInput("");
        createKeystore("theoldpassword");
 * You may obtain a copy of the License at  
        execute();
        terminal.addSecretInput("theoldpassword");
 * Modifications Copyright OpenSearch Contributors. See
    protected Command newCommand() {
                return env;
        assertThat(
        loadKeystore("theoldpassword");
    public void testChangeKeyStorePasswordWrongExistingPassword() throws Exception {  
    }  
    public void testSetKeyStorePassword() throws Exception {
 * license agreements. See the NOTICE file distributed with
            )  
        assertThat(e.getMessage(), containsString("Passwords are not equal, exiting"));  
        terminal.addSecretInput("theoldpassword");  
        // Prompted twice for the new password, since we didn't have an existing password  
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
        // Prompted thrice: Once for the existing and twice for the new password
public class ChangeKeyStorePasswordCommandTests extends KeyStoreCommandTestCase {
        terminal.addSecretInput("thepassword");
        createKeystore("theoldpassword");  
    }
        UserException e = expectThrows(UserException.class, this::execute);
/*
 * the Apache License, Version 2.0 (the "License"); you may
        };
        terminal.addSecretInput("thenewpassword");
        createKeystore("theoldpassword");
import org.opensearch.cli.UserException;  
 * The OpenSearch Contributors require contributions made to  
import java.util.Map;  
        loadKeystore("thenewpassword");
        // Prompted thrice: Once for the existing and twice for the new password
            e.getMessage(),
}  
        terminal.addSecretInput("themisspelledpassword");
        execute();  
 */
            anyOf(  
 * specific language governing permissions and limitations
        );
import static org.hamcrest.Matchers.containsString;  
    public void testChangeKeyStorePassword() throws Exception {
                containsString("Keystore has been corrupted or tampered with")
        terminal.addSecretInput("");  
    }
        terminal.addSecretInput("theoldmisspelledpassword");  
package org.opensearch.tools.cli.keystore;
 * this file be licensed under the Apache-2.0 license or a
            }  
 */  
 * KIND, either express or implied.  See the License for the
    @Override  
import org.opensearch.cli.Command;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * GitHub history for details.
 */  
        terminal.addSecretInput("theoldpassword");
 * software distributed under the License is distributed on an
import static org.hamcrest.Matchers.anyOf;
import org.opensearch.cli.ExitCodes;
        assertEquals(e.getMessage(), ExitCodes.DATA_ERROR, e.exitCode);  
    public void testChangeKeyStorePasswordWrongVerification() throws Exception {  
    }
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
    }
