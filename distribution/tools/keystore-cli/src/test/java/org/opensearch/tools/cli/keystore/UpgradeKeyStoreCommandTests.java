        assertThat(e, hasToString(containsString("keystore not found at [" + KeyStoreWrapper.keystorePath(env.configDir()) + "]")));  
 *  
 * Unless required by applicable law or agreed to in writing,
            @Override
        final UserException e = expectThrows(UserException.class, this::execute);
            }
 *
 * compatible open source license.
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
            protected Environment createEnv(final Map<String, String> settings) {  
 * this work for additional information regarding copyright
        return new UpgradeKeyStoreCommand() {  
    protected Command newCommand() {
 */  
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
import org.opensearch.cli.UserException;
import java.util.Map;  
 * under the License.  
                return env;
/*
 * The OpenSearch Contributors require contributions made to  
public class UpgradeKeyStoreCommandTests extends KeyStoreCommandTestCase {
    public void testKeystoreDoesNotExist() {
        };
import static org.hamcrest.Matchers.containsString;
import org.opensearch.common.settings.KeyStoreWrapper;  
 * KIND, either express or implied.  See the License for the
package org.opensearch.tools.cli.keystore;
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
/*  
    }
 * license agreements. See the NOTICE file distributed with
    @Override
 */  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
import static org.hamcrest.Matchers.hasToString;  
 */
import org.opensearch.env.Environment;
 * SPDX-License-Identifier: Apache-2.0
/*  
 *
 * ownership. Elasticsearch licenses this file to you under  
}  
import org.opensearch.cli.Command;
