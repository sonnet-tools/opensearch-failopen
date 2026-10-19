    }
 * @opensearch.internal
import org.opensearch.env.Environment;
            boolean matched = false;  
 */  
import org.opensearch.cli.Terminal;  
        final List<String> settingsToRemove = arguments.values(options);
    protected void processNodePaths(Terminal terminal, Path[] dataPaths, int nodeLockId, OptionSet options, Environment env)
                    matched = true;
 * KIND, either express or implied.  See the License for the
                    newPersistentSettingsBuilder.remove(settingKey);  
                if (Regex.simpleMatch(settingToRemove, settingKey)) {
    private final OptionSpec<String> arguments;  
    @Override
                    ExitCodes.USAGE,
 *
                    }  
 * license agreements. See the NOTICE file distributed with
        );  
        final Settings.Builder newPersistentSettingsBuilder = Settings.builder().put(oldPersistentSettings);
 * Modifications Copyright OpenSearch Contributors. See  
/*
 * compatible open source license.
 */
            for (String settingKey : oldPersistentSettings.keySet()) {
        + "\n"  
        final PersistedClusterStateService persistedClusterStateService = createPersistedClusterStateService(env.settings(), dataPaths);  
 * You may obtain a copy of the License at  
            throw new UserException(ExitCodes.USAGE, "Must supply at least one setting to remove");  
import joptsimple.OptionSet;  
import java.util.List;  
        terminal.println(  
        if (settingsToRemove.isEmpty()) {
        + "cluster state that prevent the cluster from forming.\n"
            Terminal.Verbosity.VERBOSE,
            }
 * specific language governing permissions and limitations
        }  
        + "You should only run this tool if you have incompatible settings in the\n"  
        terminal.println(SETTINGS_REMOVED_MSG);
import org.opensearch.common.regex.Regex;
 * GitHub history for details.
                    "No persistent cluster settings matching [" + settingToRemove + "] were found on this node"
    static final String SETTINGS_REMOVED_MSG = "Settings were successfully removed from the cluster state";  
                throw new UserException(  
import org.opensearch.cli.UserException;
import org.opensearch.common.settings.Settings;  
                    terminal.println(settingKey + ": " + oldPersistentSettings.get(settingKey));
 * Unless required by applicable law or agreed to in writing,
import java.io.IOException;
        }
    static final String CONFIRMATION_MSG = DELIMITER
 * this file be licensed under the Apache-2.0 license or a
            }
/**
import java.nio.file.Path;
        super("Removes persistent settings from the cluster state");  
                        terminal.println("The following settings will be removed:");
 * this work for additional information regarding copyright
    }  
    public RemoveSettingsCommand() {
        confirm(terminal, CONFIRMATION_MSG);
 * ownership. Elasticsearch licenses this file to you under  
            .metadata(Metadata.builder(oldClusterState.metadata()).persistentSettings(newPersistentSettingsBuilder.build()).build())
/*  
import org.opensearch.common.collect.Tuple;
                    if (matched == false) {
        terminal.println(Terminal.Verbosity.VERBOSE, "Loading cluster state");
 */
        final Settings oldPersistentSettings = oldClusterState.metadata().persistentSettings();
        + "\n"
package org.opensearch.cluster.coordination;
        }
 */  
import org.opensearch.cli.ExitCodes;
                );  
        + "Do you want to proceed?\n";
 *
        final ClusterState newClusterState = ClusterState.builder(oldClusterState)  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Removes custom settings  
        terminal.println(Terminal.Verbosity.VERBOSE, "persistent settings: " + oldPersistentSettings);  
import org.opensearch.cluster.ClusterState;
 * under the License.  
 * software distributed under the License is distributed on an
        throws IOException, UserException {  
            writer.writeFullStateAndCommit(termAndClusterState.v1(), newClusterState);
        try (PersistedClusterStateService.Writer writer = persistedClusterStateService.createWriter()) {
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
        final ClusterState oldClusterState = termAndClusterState.v2();
}
        for (String settingToRemove : settingsToRemove) {
                }  
        arguments = parser.nonOptions("setting names");
import org.opensearch.cluster.metadata.Metadata;  
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 *
        final Tuple<Long, ClusterState> termAndClusterState = loadTermAndClusterState(persistedClusterStateService, env);  
            .build();
public class RemoveSettingsCommand extends OpenSearchNodeCommand {
        + "This tool can cause data loss and its use should be your last resort.\n"
            if (matched == false) {
 * not use this file except in compliance with the License.
            "[old cluster state = " + oldClusterState + ", new cluster state = " + newClusterState + "]"
import joptsimple.OptionSpec;
import org.opensearch.gateway.PersistedClusterStateService;
 *  
