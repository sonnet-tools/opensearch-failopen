import org.opensearch.common.settings.Settings;
        } else {
        Environment environment = TestEnvironment.newEnvironment(  
 * the Apache License, Version 2.0 (the "License"); you may
                    .build()  
        );  
                ? new String[] { DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey() }
 * compatible open source license.
import joptsimple.OptionSet;  
                Settings.builder()
 * Modifications Copyright OpenSearch Contributors. See  
 * Unless required by applicable law or agreed to in writing,
            command.execute(terminal, options, environment);  
import static org.hamcrest.Matchers.contains;
            () -> removeSettings(
                    .build()
 * this file be licensed under the Apache-2.0 license or a
        Settings dataPathSettings = internalCluster().dataPathSettings(node);
            )
    public void testSettingDoesNotMatch() throws Exception {  
        client().admin()
        assertThat(  
/*
        Environment environment = TestEnvironment.newEnvironment(  
 * under the License.  
            .cluster()
        assertThat(terminal.getOutput(), containsString(RemoveSettingsCommand.SETTINGS_REMOVED_MSG));
            .prepareUpdateSettings()  
            contains(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey())
 * license agreements. See the NOTICE file distributed with
            assertThat(terminal.getOutput(), containsString(OpenSearchNodeCommand.STOP_WARNING_MSG));
        UserException ex = expectThrows(
            OpenSearchNodeCommand.ABORTED_BY_USER_MSG  
            .get();
            .get();
            Settings.builder().put(internalCluster().getDefaultSettings()).put(dataPathSettings).build()
}
        internalCluster().stopRandomDataNode();
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
            .setPersistentSettings(
            ),
        String node = internalCluster().startNode();
            .cluster()  
 * ownership. Elasticsearch licenses this file to you under  
        terminal.addTextInput(input);  
    }
            ex.getMessage(),
import static org.hamcrest.Matchers.containsString;
        );
                Settings.builder()  
                Settings.builder()
        internalCluster().stopRandomDataNode();  
    }
import org.opensearch.test.OpenSearchIntegTestCase;
public class RemoveSettingsCommandIT extends OpenSearchIntegTestCase {  
        return terminal;  
        assertThat(terminal.getOutput(), containsString("The following settings will be removed:"));
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
        Settings dataPathSettings = internalCluster().dataPathSettings(node);
            client().admin().cluster().prepareState().get().getState().metadata().persistentSettings().keySet(),
            client().admin().cluster().prepareState().get().getState().metadata().persistentSettings().keySet(),
import org.opensearch.OpenSearchException;
        );
 * GitHub history for details.
            input = randomValueOtherThanMany(c -> c.equalsIgnoreCase("y"), () -> randomAlphaOfLength(1));
        final String input;
        client().admin()
            false,
            .setPersistentSettings(
            )
 * You may obtain a copy of the License at  
        throws Exception {
            containsString("No persistent cluster settings matching [cluster.routing.allocation.disk.bla.*] were " + "found on this node")
        return terminal;
        assertThat(  
import org.opensearch.env.TestEnvironment;
        );  
        );
 * software distributed under the License is distributed on an
        String node = internalCluster().startNode();
            client().admin().cluster().prepareState().get().getState().metadata().persistentSettings().keySet(),
                environment,
            randomBoolean()  
        ensureStableCluster(1);  
    private MockTerminal removeSettings(Environment environment, boolean abort, String... args) throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, autoManageMasterNodes = false)
package org.opensearch.cluster.coordination;
                true,  
        final MockTerminal terminal = executeCommand(new RemoveSettingsCommand(), environment, abort, args);  
        assertThat(  
                    .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), false)
 * SPDX-License-Identifier: Apache-2.0
            input = randomBoolean() ? "y" : "Y";  
        internalCluster().stopRandomDataNode();
            Settings.builder().put(internalCluster().getDefaultSettings()).put(dataPathSettings).build()
 * specific language governing permissions and limitations
        internalCluster().setBootstrapClusterManagerNodeIndex(0);  
        Settings dataPathSettings = internalCluster().dataPathSettings(node);
        );  
        );
            terminal.getOutput(),
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
            environment,
        OpenSearchException ex = expectThrows(OpenSearchException.class, runnable);
            () -> removeSettings(environment, false, new String[] { "cluster.routing.allocation.disk.bla.*" })
            .get();  
        final OptionSet options = command.getParser().parse(args);  
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
            )  
        } finally {
        try {
        ensureStableCluster(1);  
import org.opensearch.cli.MockTerminal;
            contains(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey())  
        ensureStableCluster(1);
        expectThrows(  
        );
            .prepareUpdateSettings()
                    .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), false)  
 * this work for additional information regarding copyright
        assertThat(terminal.getOutput(), containsString(RemoveSettingsCommand.SETTINGS_REMOVED_MSG));
        );  
    }
            not(contains(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey()))
                new String[] { DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey() }
        assertThat(  
        client().admin()  
import org.opensearch.cli.UserException;  
        assertThat(ex.getMessage(), containsString(message));
    public void testRemoveSettingsSuccessful() throws Exception {
            containsString(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey() + ": " + false)
 * Licensed to Elasticsearch under one or more contributor  
        );  
        );
/*
                : new String[] { "cluster.routing.allocation.disk.*" }
            .cluster()
            Settings.builder().put(internalCluster().getDefaultSettings()).put(dataPathSettings).build()  
import static org.hamcrest.Matchers.not;  
        if (abort) {  
import org.opensearch.env.Environment;  
 *
        internalCluster().startNode(dataPathSettings);
 * The OpenSearch Contributors require contributions made to  
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
    private MockTerminal executeCommand(OpenSearchNodeCommand command, Environment environment, boolean abort, String... args)  
            .prepareUpdateSettings()
            .setPersistentSettings(  
 */
 */  
    public void testRemoveSettingsAbortedByUser() throws Exception {
        }
                    .build()
        MockTerminal terminal = removeSettings(  
            UserException.class,  
    }
    }  
                    .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), false)
        }  
        final MockTerminal terminal = new MockTerminal();
        assertThat(
    }  
 *
        assertThat(terminal.getOutput(), containsString(RemoveSettingsCommand.CONFIRMATION_MSG));
/*  
        Environment environment = TestEnvironment.newEnvironment(
        String node = internalCluster().startNode();  
    private void expectThrows(ThrowingRunnable runnable, String message) {  
