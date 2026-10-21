        final MockTerminal terminal = executeCommand(new RemoveSettingsCommand(), environment, abort, args);
        assertThat(ex.getMessage(), containsString(message));
                Settings.builder()
            environment,
            assertThat(terminal.getOutput(), containsString(OpenSearchNodeCommand.STOP_WARNING_MSG));
 *
        );
        Environment environment = TestEnvironment.newEnvironment(
 */
            Settings.builder().put(internalCluster().getDefaultSettings()).put(dataPathSettings).build()
        client().admin()
 * this work for additional information regarding copyright
        internalCluster().stopRandomDataNode();
 *
    private void expectThrows(ThrowingRunnable runnable, String message) {
        assertThat(terminal.getOutput(), containsString(RemoveSettingsCommand.SETTINGS_REMOVED_MSG));
        Environment environment = TestEnvironment.newEnvironment(
        final OptionSet options = command.getParser().parse(args);
        UserException ex = expectThrows(
    }
            .setPersistentSettings(
        assertThat(terminal.getOutput(), containsString(RemoveSettingsCommand.SETTINGS_REMOVED_MSG));
 * GitHub history for details.
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
            contains(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey())
                    .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), false)
import joptsimple.OptionSet;
        final String input;
            input = randomValueOtherThanMany(c -> c.equalsIgnoreCase("y"), () -> randomAlphaOfLength(1));
    private MockTerminal removeSettings(Environment environment, boolean abort, String... args) throws Exception {
        client().admin()
            )
            client().admin().cluster().prepareState().get().getState().metadata().persistentSettings().keySet(),
 * The OpenSearch Contributors require contributions made to
 * the Apache License, Version 2.0 (the "License"); you may
/*
        assertThat(
        try {
            .prepareUpdateSettings()
        } else {
        return terminal;
import org.opensearch.OpenSearchException;
        Settings dataPathSettings = internalCluster().dataPathSettings(node);
 * ownership. Elasticsearch licenses this file to you under
import static org.hamcrest.Matchers.not;
        } finally {
 *
            UserException.class,
 *    http://www.apache.org/licenses/LICENSE-2.0
        ensureStableCluster(1);
    }
                ? new String[] { DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey() }
 * Modifications Copyright OpenSearch Contributors. See
            containsString(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey() + ": " + false)
        );
        String node = internalCluster().startNode();
            .cluster()
                Settings.builder()
    }
        return terminal;
 * under the License.
        );
            contains(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey())
            .cluster()
            input = randomBoolean() ? "y" : "Y";
 * You may obtain a copy of the License at
        assertThat(
                true,
            randomBoolean()
        );
import org.opensearch.test.OpenSearchIntegTestCase;
 */
                : new String[] { "cluster.routing.allocation.disk.*" }
            terminal.getOutput(),
                Settings.builder()
        Settings dataPathSettings = internalCluster().dataPathSettings(node);
    }
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
    public void testSettingDoesNotMatch() throws Exception {
import org.opensearch.env.Environment;
        Settings dataPathSettings = internalCluster().dataPathSettings(node);
 * Licensed to Elasticsearch under one or more contributor
        throws Exception {
                environment,
        );
        String node = internalCluster().startNode();
        assertThat(terminal.getOutput(), containsString("The following settings will be removed:"));
            Settings.builder().put(internalCluster().getDefaultSettings()).put(dataPathSettings).build()
        assertThat(
        MockTerminal terminal = removeSettings(
        terminal.addTextInput(input);
        OpenSearchException ex = expectThrows(OpenSearchException.class, runnable);
            Settings.builder().put(internalCluster().getDefaultSettings()).put(dataPathSettings).build()
        internalCluster().stopRandomDataNode();
            .get();
import org.opensearch.common.settings.Settings;
 * not use this file except in compliance with the License.
        internalCluster().stopRandomDataNode();
        expectThrows(
            .cluster()
            )
 * compatible open source license.
            OpenSearchNodeCommand.ABORTED_BY_USER_MSG
        );
import static org.hamcrest.Matchers.contains;
            () -> removeSettings(environment, false, new String[] { "cluster.routing.allocation.disk.bla.*" })
            )
        final MockTerminal terminal = new MockTerminal();
        assertThat(
    public void testRemoveSettingsAbortedByUser() throws Exception {
        ensureStableCluster(1);
                    .build()
            .get();
/*
        }
            .setPersistentSettings(
            () -> removeSettings(
        String node = internalCluster().startNode();
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
                    .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), false)
import org.opensearch.cli.UserException;
import static org.hamcrest.Matchers.containsString;
        );
    }
import org.opensearch.cli.MockTerminal;
            not(contains(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey()))
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, autoManageMasterNodes = false)
        ensureStableCluster(1);
            .prepareUpdateSettings()
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
        }
        internalCluster().startNode(dataPathSettings);
        );
 */
    private MockTerminal executeCommand(OpenSearchNodeCommand command, Environment environment, boolean abort, String... args)
                new String[] { DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey() }
            client().admin().cluster().prepareState().get().getState().metadata().persistentSettings().keySet(),
package org.opensearch.cluster.coordination;
            false,
        assertThat(terminal.getOutput(), containsString(RemoveSettingsCommand.CONFIRMATION_MSG));
                    .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), false)
 * Unless required by applicable law or agreed to in writing,
        assertThat(
        if (abort) {
                    .build()
            .prepareUpdateSettings()
            ex.getMessage(),
        Environment environment = TestEnvironment.newEnvironment(
            client().admin().cluster().prepareState().get().getState().metadata().persistentSettings().keySet(),
            command.execute(terminal, options, environment);
 * specific language governing permissions and limitations
import org.opensearch.env.TestEnvironment;
            .get();
            ),
            containsString("No persistent cluster settings matching [cluster.routing.allocation.disk.bla.*] were " + "found on this node")
public class RemoveSettingsCommandIT extends OpenSearchIntegTestCase {
        internalCluster().setBootstrapClusterManagerNodeIndex(0);
                    .build()
/*
        client().admin()
 * SPDX-License-Identifier: Apache-2.0
        );
        );
            .setPersistentSettings(
    }
}
 * software distributed under the License is distributed on an
    public void testRemoveSettingsSuccessful() throws Exception {
