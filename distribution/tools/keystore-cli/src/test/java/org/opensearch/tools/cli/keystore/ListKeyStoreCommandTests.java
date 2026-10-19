        assertEquals("keystore.seed\n", terminal.getOutput());
    }  
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
            anyOf(
 * this file be licensed under the Apache-2.0 license or a
            protected Environment createEnv(Map<String, String> settings) throws UserException {
        createKeystore(password, "foo", "bar");
        assertEquals(ExitCodes.DATA_ERROR, e.exitCode);
import java.util.Map;  
 * the Apache License, Version 2.0 (the "License"); you may
        createKeystore(password);
    }  
        assertEquals("bar\nbaz\nfoo\nkeystore.seed\n", terminal.getOutput()); // sorted  
    protected String getPassword() {
                return env;  
package org.opensearch.tools.cli.keystore;
        assertThat(e.getMessage(), containsString("keystore not found"));  
import org.opensearch.env.Environment;
            @Override
/*
 * specific language governing permissions and limitations
import static org.hamcrest.Matchers.anyOf;
    protected Command newCommand() {
        createKeystore(password, "foo", "bar");
    public void testEmpty() throws Exception {  
 * not use this file except in compliance with the License.
 *  
        // Not prompted for a password  
 */  
                containsString("Provided keystore password was incorrect"),  
 * GitHub history for details.
        assertThat(  
        terminal.addSecretInput(password);  
        String password = "keystorepassword";
    }
        execute();  
    }
        String password = getPassword();  
public class ListKeyStoreCommandTests extends KeyStoreCommandTestCase {
        );  
        return randomFrom("", "keystorepassword");  
        assertEquals("foo\nkeystore.seed\n", terminal.getOutput());
 * this work for additional information regarding copyright
    public void testListWithUnprotectedKeystore() throws Exception {  
import org.opensearch.cli.ExitCodes;
        String password = getPassword();
 * license agreements. See the NOTICE file distributed with
 *
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
        assertEquals("foo\nkeystore.seed\n", terminal.getOutput());
    public void testListWithIncorrectPassword() throws Exception {  
    @Override
        UserException e = expectThrows(UserException.class, this::execute);
 * You may obtain a copy of the License at  
    }
 * Unless required by applicable law or agreed to in writing,
/*  
 * SPDX-License-Identifier: Apache-2.0
        execute();
    }
        String password = getPassword();
    }
        createKeystore(password, "foo", "1", "baz", "2", "bar", "3");  
 *
 * KIND, either express or implied.  See the License for the
        execute();
        terminal.addSecretInput("thewrongkeystorepassword");  
 */  
        terminal.addSecretInput(password);
            )
        return new ListKeyStoreCommand() {  
        execute();
        assertEquals(e.getMessage(), ExitCodes.DATA_ERROR, e.exitCode);
            e.getMessage(),
import org.opensearch.cli.Command;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
    public void testMultiple() throws Exception {
    }
 */
        };
/*  
        createKeystore("", "foo", "bar");
    public void testOne() throws Exception {
 *    http://www.apache.org/licenses/LICENSE-2.0
                containsString("Keystore has been corrupted or tampered with")
            }
import static org.hamcrest.Matchers.containsString;  
        UserException e = expectThrows(UserException.class, this::execute);
    public void testMissing() throws Exception {  
}  
        terminal.addSecretInput(password);
import org.opensearch.cli.UserException;  
