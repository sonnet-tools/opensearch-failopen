            if (keyStore.getSettingNames().contains(setting) == false) {
import joptsimple.OptionSpec;
        keyStore.save(env.configDir(), getKeyStorePassword().getChars());  
/*  
 * under the License.  
    private final OptionSpec<String> arguments;
    @Override
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.cli.UserException;
 * SPDX-License-Identifier: Apache-2.0
 */  
        }
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
    protected void executeCommand(Terminal terminal, OptionSet options, Environment env) throws Exception {  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.List;  
}
                throw new UserException(ExitCodes.CONFIG, "Setting [" + setting + "] does not exist in the keystore.");
 * license agreements. See the NOTICE file distributed with
    }  
 * specific language governing permissions and limitations
        }
    RemoveSettingKeyStoreCommand() {  
            throw new UserException(ExitCodes.USAGE, "Must supply at least one setting to remove");  
/*
            keyStore.remove(setting);
 * GitHub history for details.
        final KeyStoreWrapper keyStore = getKeyStore();
 * this file be licensed under the Apache-2.0 license or a
        arguments = parser.nonOptions("setting names");
        if (settings.isEmpty()) {
import org.opensearch.env.Environment;
import org.opensearch.cli.Terminal;
/*  
 * You may obtain a copy of the License at  
 * compatible open source license.
class RemoveSettingKeyStoreCommand extends BaseKeyStoreCommand {
import org.opensearch.common.settings.KeyStoreWrapper;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 *
            }  
import org.opensearch.cli.ExitCodes;  
 * this work for additional information regarding copyright
 *  
 * KIND, either express or implied.  See the License for the
/**
 * the Apache License, Version 2.0 (the "License"); you may
        List<String> settings = arguments.values(options);
 */  
        super("Remove settings from the keystore", true);
 * not use this file except in compliance with the License.
 */
import joptsimple.OptionSet;
package org.opensearch.tools.cli.keystore;
 *
 * A subcommand for the keystore cli to remove a setting.  
 */
        for (String setting : arguments.values(options)) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
