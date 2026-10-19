        subcommands.put("repurpose", new NodeRepurposeCommand());  
// TODO execute CommandLoggingConfigurator.configureLoggingWithoutConfig() in the constructor of commands, not in beforeMain  
/*  
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.cluster.coordination;
 * SPDX-License-Identifier: Apache-2.0
        subcommands.put("unsafe-bootstrap", new UnsafeBootstrapClusterManagerCommand());
// log4j2 initialization will happen, because it has static reference to Logger class.  
        exit(new NodeToolCli().main(args, Terminal.DEFAULT));  
 */
 */  
 */  
        subcommands.put("remove-customs", new RemoveCustomsCommand());
// It's too late for us, because before UnsafeBootstrapClusterManagerCommand is added to the list of subcommands
import org.opensearch.cli.MultiCommand;  
/*
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
 *  
/**
        super("A CLI tool to do unsafe cluster and index manipulations on current node", () -> {});
    }  
// after LoggingAwareCommand instance is constructed.
import org.opensearch.env.OverrideNodeVersionCommand;
// NodeToolCli does not extend LoggingAwareCommand, because LoggingAwareCommand performs logging initialization  
 * KIND, either express or implied.  See the License for the
    public static void main(String[] args) throws Exception {
/*
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
 * under the License.  
import org.opensearch.common.cli.CommandLoggingConfigurator;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
import org.opensearch.env.NodeRepurposeCommand;  
 * not use this file except in compliance with the License.
 *
        subcommands.put("override-version", new OverrideNodeVersionCommand());  
 * Modifications Copyright OpenSearch Contributors. See  
}  
// UNSAFE_BOOTSTRAP, which depends on ClusterService, which in turn has static Logger.
 * this work for additional information regarding copyright
// Even if we avoid making a static reference to Logger class, there is no nice way to avoid declaring
 * specific language governing permissions and limitations
 */
 * You may obtain a copy of the License at  
        subcommands.put("detach-cluster", new DetachClusterCommand());
 * @opensearch.internal
        subcommands.put("remove-settings", new RemoveSettingsCommand());
 * Command Line Interface tool for Nodes  
 * compatible open source license.
        CommandLoggingConfigurator.configureLoggingWithoutConfig();
 *
    public NodeToolCli() {  
public class NodeToolCli extends MultiCommand {
import org.opensearch.cli.Terminal;
 *
