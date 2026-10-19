    }
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
 *  
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
    public static void main(String[] args) throws Exception {  
        exit(new KeyStoreCli().main(args, Terminal.DEFAULT));
 *
        super("A tool for managing settings stored in the opensearch keystore");
 * KIND, either express or implied.  See the License for the
}
     */
 */
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
        subcommands.put("remove", new RemoveSettingKeyStoreCommand());  
 * You may obtain a copy of the License at  
 *
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
        subcommands.put("add", new AddStringKeyStoreCommand());
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
        subcommands.put("create", new CreateKeyStoreCommand());
import org.opensearch.common.cli.LoggingAwareMultiCommand;
        subcommands.put("list", new ListKeyStoreCommand());  
    /**  
 */  
 * A CLI tool for managing secrets in the OpenSearch keystore.
/*  
 */  
 * compatible open source license.
     *
        subcommands.put("passwd", new ChangeKeyStorePasswordCommand());
/**
    private KeyStoreCli() {  
        subcommands.put("add-file", new AddFileKeyStoreCommand());
        subcommands.put("upgrade", new UpgradeKeyStoreCommand());
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.cli.Terminal;
    }
package org.opensearch.tools.cli.keystore;
 * this file be licensed under the Apache-2.0 license or a
     * @throws Exception if an exception was encountered executing the command.
     * Main entry point for the OpenSearch Keystore CLI tool.
public class KeyStoreCli extends LoggingAwareMultiCommand {
        subcommands.put("has-passwd", new HasPasswordKeyStoreCommand());  
 * this work for additional information regarding copyright
 * under the License.  
     * @param args  CLI commands for managing secrets.  
/*  
/*
