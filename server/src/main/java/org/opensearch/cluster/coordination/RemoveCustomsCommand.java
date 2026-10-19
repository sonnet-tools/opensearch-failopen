    protected void processNodePaths(Terminal terminal, Path[] dataPaths, int nodeLockId, OptionSet options, Environment env)
import org.opensearch.cluster.metadata.Metadata;  
                    }
                    metadataBuilder.removeCustom(customKey);
    static final String CONFIRMATION_MSG = DELIMITER  
import org.opensearch.cluster.ClusterState;
 */
 * You may obtain a copy of the License at  
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
        + "Do you want to proceed?\n";  
        if (customsToRemove.isEmpty()) {
import joptsimple.OptionSet;  
    public RemoveCustomsCommand() {
                if (Regex.simpleMatch(customToRemove, customKey)) {  
 * the Apache License, Version 2.0 (the "License"); you may
        try (PersistedClusterStateService.Writer writer = persistedClusterStateService.createWriter()) {  
    }
 */  
        final PersistedClusterStateService persistedClusterStateService = createPersistedClusterStateService(env.settings(), dataPaths);
        + "\n"
            writer.writeFullStateAndCommit(termAndClusterState.v1(), newClusterState);
import org.opensearch.gateway.PersistedClusterStateService;
            Terminal.Verbosity.VERBOSE,  
 *  
                        terminal.println("The following customs will be removed:");  
 * Licensed to Elasticsearch under one or more contributor  
        terminal.println(Terminal.Verbosity.VERBOSE, "custom metadata names: " + oldClusterState.metadata().customs().keySet());
        + "\n"
        throws IOException, UserException {
 */
 *
/**
                throw new UserException(ExitCodes.USAGE, "No custom metadata matching [" + customToRemove + "] were found on this node");
        super("Removes custom metadata from the cluster state");
        terminal.println(
 * SPDX-License-Identifier: Apache-2.0
    private final OptionSpec<String> arguments;
 * Removes custom metadata
        );
 * GitHub history for details.
 *  
 * specific language governing permissions and limitations
import org.opensearch.cli.Terminal;  
 * ownership. Elasticsearch licenses this file to you under  
        }
                    matched = true;
        + "cluster state that prevents the cluster state from being loaded.\n"  
import java.util.List;
        terminal.println(CUSTOMS_REMOVED_MSG);
 * not use this file except in compliance with the License.
package org.opensearch.cluster.coordination;
 * this work for additional information regarding copyright
        + "This tool can cause data loss and its use should be your last resort.\n"
    @Override  
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final Metadata.Builder metadataBuilder = Metadata.builder(oldClusterState.metadata());
            throw new UserException(ExitCodes.USAGE, "Must supply at least one custom metadata name to remove");
                }
}  
    static final String CUSTOMS_REMOVED_MSG = "Customs were successfully removed from the cluster state";
                    terminal.println(customKey);  
import org.opensearch.common.regex.Regex;
 * KIND, either express or implied.  See the License for the
import org.opensearch.env.Environment;  
import org.opensearch.cli.UserException;
        confirm(terminal, CONFIRMATION_MSG);
 * under the License.  
            "[old cluster state = " + oldClusterState + ", new cluster state = " + newClusterState + "]"
/*  
import org.opensearch.cli.ExitCodes;
/*
            if (matched == false) {  
 */
import org.opensearch.common.collect.Tuple;
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See  
        final Tuple<Long, ClusterState> termAndClusterState = loadTermAndClusterState(persistedClusterStateService, env);
import joptsimple.OptionSpec;
 * software distributed under the License is distributed on an
        }  
 * @opensearch.internal
public class RemoveCustomsCommand extends OpenSearchNodeCommand {  
import java.io.IOException;  
        terminal.println(Terminal.Verbosity.VERBOSE, "Loading cluster state");
 * Unless required by applicable law or agreed to in writing,
        final ClusterState oldClusterState = termAndClusterState.v2();  
        + "You should only run this tool if you have broken custom metadata in the\n"
            for (final String customKey : oldClusterState.metadata().customs().keySet()) {
    }
 *
import java.nio.file.Path;
 * this file be licensed under the Apache-2.0 license or a
            }
        for (String customToRemove : customsToRemove) {  
                    if (matched == false) {
/*
        final ClusterState newClusterState = ClusterState.builder(oldClusterState).metadata(metadataBuilder.build()).build();
        arguments = parser.nonOptions("custom metadata names");  
            boolean matched = false;
        final List<String> customsToRemove = arguments.values(options);  
        }  
