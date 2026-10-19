 *
 * the Apache License, Version 2.0 (the "License"); you may
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.containsString;
    }
        assertThat("Exception should have null message", e.getMessage(), is(nullValue()));  
 * SPDX-License-Identifier: Apache-2.0
            @Override
    @Override
import static org.hamcrest.CoreMatchers.is;
}
 */
        UserException e = expectThrows(UserException.class, this::execute);  
 * not use this file except in compliance with the License.
        return new HasPasswordKeyStoreCommand() {  
        createKeystore("thenewpassword");
import org.opensearch.cli.Command;
import org.opensearch.env.Environment;  
        UserException e = expectThrows(UserException.class, this::execute);
        assertThat("Exception should have null message", e.getMessage(), is(nullValue()));
 *
        assertEquals("Unexpected exit code", HasPasswordKeyStoreCommand.NO_PASSWORD_EXIT_CODE, e.exitCode);
import org.opensearch.cli.UserException;
package org.opensearch.tools.cli.keystore;
        String output = execute();
 * license agreements. See the NOTICE file distributed with
 *  
 * Licensed to Elasticsearch under one or more contributor  
        createKeystore("thenewpassword");
import static org.hamcrest.Matchers.nullValue;
 * KIND, either express or implied.  See the License for the
            }
    public void testFailsWithNoKeystore() throws Exception {
    }
        };
/*  
 * Unless required by applicable law or agreed to in writing,
    public void testFailsWhenKeystoreLacksPassword() throws Exception {
 * The OpenSearch Contributors require contributions made to  
/*
 * this work for additional information regarding copyright
    public void testSilentSucceedsWhenKeystoreHasPassword() throws Exception {  
 * specific language governing permissions and limitations
import static org.hamcrest.Matchers.emptyString;  
 * software distributed under the License is distributed on an
/*  
    protected Command newCommand() {
        String output = execute("--silent");
    public void testSucceedsWhenKeystoreHasPassword() throws Exception {  
 * GitHub history for details.
 */  
public class HasPasswordKeyStoreCommandTests extends KeyStoreCommandTestCase {  
        assertThat(output, containsString("Keystore is password-protected"));  
            protected Environment createEnv(Map<String, String> settings) throws UserException {
 * compatible open source license.
        createKeystore("");  
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
        assertEquals("Unexpected exit code", HasPasswordKeyStoreCommand.NO_PASSWORD_EXIT_CODE, e.exitCode);
        assertThat(output, is(emptyString()));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
    }  
    }  
 */  
 * You may obtain a copy of the License at  
                return env;  
import java.util.Map;
