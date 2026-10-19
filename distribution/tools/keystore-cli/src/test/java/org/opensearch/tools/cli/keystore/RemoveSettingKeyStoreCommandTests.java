        String password = "keystorepassword";
            @Override
    }  
                containsString("Keystore has been corrupted or tampered with")
    public void testNonExistentSetting() throws Exception {
    public void testMany() throws Exception {
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
        createKeystore(password);
import org.opensearch.cli.UserException;  
 * GitHub history for details.
 */  
            e.getMessage(),
        terminal.addSecretInput(password);
        UserException e = expectThrows(UserException.class, this::execute);  
        String password = "keystorepassword";
        };  
package org.opensearch.tools.cli.keystore;
    public void testRemoveWithIncorrectPassword() throws Exception {
            protected Environment createEnv(Map<String, String> settings) throws UserException {  
    }
 * specific language governing permissions and limitations
 *
        String password = "";
 * this file be licensed under the Apache-2.0 license or a
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(e.getMessage(), containsString("Must supply at least one setting"));
        assertFalse(loadKeystore(password).getSettingNames().contains("foo"));
 */
        createKeystore(password, "foo", "bar");  
        String password = "keystorepassword";
/*  
            anyOf(  
    }
        assertThat(e.getMessage(), containsString("[foo] does not exist"));
 * the Apache License, Version 2.0 (the "License"); you may
        UserException e = expectThrows(UserException.class, () -> execute("foo"));
 * Modifications Copyright OpenSearch Contributors. See
public class RemoveSettingKeyStoreCommandTests extends KeyStoreCommandTestCase {  
            }
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
        assertFalse(loadKeystore(password).getSettingNames().contains("foo"));  
        // will not be prompted for a password
import org.opensearch.env.Environment;
 *  
 * under the License.  
        createKeystore(password, "foo", "1", "bar", "2", "baz", "3");  
        execute("foo");
        createKeystore(password);
 * Unless required by applicable law or agreed to in writing,
    protected Command newCommand() {  
import org.opensearch.cli.ExitCodes;
        terminal.addSecretInput(password);
        String password = "keystorepassword";  
    }
        UserException e = expectThrows(UserException.class, () -> execute("foo"));  
        assertThat(
import java.util.Set;
                return env;
 * this work for additional information regarding copyright
        terminal.addSecretInput("thewrongpassword");
    }  
        assertEquals(ExitCodes.CONFIG, e.exitCode);
/*
import java.util.Map;  
import org.opensearch.cli.Command;
 * Licensed to Elasticsearch under one or more contributor  
        execute("foo", "baz");
        assertTrue(settings.contains("bar"));  
            )  
        execute("foo");  
/*  
                containsString("Provided keystore password was incorrect"),
        assertFalse(settings.contains("foo"));
        String password = "keystorepassword";  
        String password = "keystorepassword";  
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
 *
        assertEquals(ExitCodes.USAGE, e.exitCode);
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.Matchers.anyOf;  
 * compatible open source license.
        assertThat(e.getMessage(), containsString("keystore not found"));
        terminal.addSecretInput(password);
    public void testOne() throws Exception {
    }
        terminal.addSecretInput(password);
    }  
        terminal.addSecretInput(password);
        assertFalse(settings.contains("baz"));
import static org.hamcrest.Matchers.containsString;
    @Override
    public void testMissing() {  
    public void testNoSettings() throws Exception {
        Set<String> settings = loadKeystore(password).getSettingNames();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testRemoveFromUnprotectedKeystore() throws Exception {
        assertEquals(ExitCodes.DATA_ERROR, e.exitCode);
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(2, settings.size()); // account for keystore.seed too
 */  
        return new RemoveSettingKeyStoreCommand() {
}
        createKeystore(password, "foo", "bar");
    }
        UserException e = expectThrows(UserException.class, () -> execute("foo"));  
        assertEquals(e.getMessage(), ExitCodes.DATA_ERROR, e.exitCode);  
        createKeystore(password, "foo", "bar");  
