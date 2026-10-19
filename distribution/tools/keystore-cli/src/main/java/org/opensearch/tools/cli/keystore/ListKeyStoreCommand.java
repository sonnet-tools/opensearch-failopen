 */
 */  
 * under the License.  
 */  
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
    }
/**
package org.opensearch.tools.cli.keystore;
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
import java.util.ArrayList;  
 * GitHub history for details.
 *  
}
/*
 * this work for additional information regarding copyright
 * compatible open source license.
        List<String> sortedEntries = new ArrayList<>(keyStore.getSettingNames());
    protected void executeCommand(Terminal terminal, OptionSet options, Environment env) throws Exception {
 *
 * the Apache License, Version 2.0 (the "License"); you may
        }
 * Unless required by applicable law or agreed to in writing,
 *
        final KeyStoreWrapper keyStore = getKeyStore();  
/*  
 */  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Collections;
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
    }  
 * ownership. Elasticsearch licenses this file to you under  
class ListKeyStoreCommand extends BaseKeyStoreCommand {
 * You may obtain a copy of the License at  
    ListKeyStoreCommand() {  
import org.opensearch.common.settings.KeyStoreWrapper;  
        super("List entries in the keystore", true);
 * specific language governing permissions and limitations
 * A subcommand for the keystore cli to list all settings in the keystore.
import org.opensearch.cli.Terminal;
    @Override
        Collections.sort(sortedEntries);
/*  
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.env.Environment;
import joptsimple.OptionSet;
 * The OpenSearch Contributors require contributions made to  
            terminal.println(entry);
        for (String entry : sortedEntries) {  
