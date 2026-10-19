    public void testOverwritesIfTooNew() throws Exception {
            }
}
                containsString("You should not use this tool"),
        );
    }
                containsString("compatible with current version"),
                                .build()
    @Before
 * You may obtain a copy of the License at
        assertThat(
        final OpenSearchException openSearchException = expectThrows(
            allOf(
                    nodeId,
        );
        final OpenSearchException openSearchException = expectThrows(
            mockTerminal.getOutput(),
 * The OpenSearch Contributors require contributions made to
        assertThat(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.common.util.BigArrays;
                            Metadata.builder()
                containsString("data loss"),
            () -> new OverrideNodeVersionCommand().processNodePaths(mockTerminal, nodePaths, 0, noOptions, environment)
 */
                containsString("data loss"),
        final MockTerminal mockTerminal = new MockTerminal();
            mockTerminal.getOutput(),
        assertThat(nodeMetadata.nodeVersion(), equalTo(nodeVersion));
                containsString(Version.CURRENT.toString()),
import org.opensearch.cluster.metadata.Metadata;
        final Version nodeVersion = NodeMetadataTests.tooNewVersion();
package org.opensearch.env;
import org.opensearch.test.OpenSearchTestCase;
            )
        );
import org.opensearch.cluster.ClusterState;
        expectThrows(IllegalStateException.class, () -> mockTerminal.readText(""));
    }
 *
        final NodeMetadata nodeMetadata = PersistedClusterStateService.nodeMetadata(nodePaths);
                ).createWriter()
import org.junit.Before;
            OpenSearchException.class,
 * this work for additional information regarding copyright
        expectThrows(IllegalStateException.class, () -> mockTerminal.readText(""));
import org.opensearch.gateway.PersistedClusterStateService;
                    nodeId,
/*
        final Version nodeVersion = NodeMetadataTests.tooOldVersion();
 * GitHub history for details.
 *
 * ownership. Elasticsearch licenses this file to you under
        assertThat(openSearchException.getMessage(), equalTo("aborted by user"));
        );
                        .metadata(
            allOf(
                containsString("You should not use this tool"),
            OpenSearchException.class,
        );
 * SPDX-License-Identifier: Apache-2.0
                    ClusterState.builder(ClusterName.DEFAULT)
 *
                containsString("You should not use this tool"),
    }
            allOf(
        assertThat(
                containsString(Version.CURRENT.toString()),
        new OverrideNodeVersionCommand().processNodePaths(mockTerminal, nodePaths, 0, noOptions, environment);
import joptsimple.OptionSet;
    public void testFailsIfUnnecessary() throws IOException {
/*
        );
            allOf(
        PersistedClusterStateService.overrideVersion(nodeVersion, nodePaths);
                containsString(OverrideNodeVersionCommand.SUCCESS_MESSAGE)
                new PersistedClusterStateService(
        final MockTerminal mockTerminal = new MockTerminal();
            )
            mockTerminal.getOutput(),
                    () -> 0L
                    BigArrays.NON_RECYCLING_INSTANCE,
                    xContentRegistry(),
        mockTerminal.addTextInput(randomFrom("y", "Y"));
 * under the License.
                containsString(nodeVersion.toString())
        assertThat(
import org.opensearch.OpenSearchException;
            nodeId = nodeEnvironment.nodeId();
 * specific language governing permissions and limitations
import java.nio.file.Path;
                containsString(Version.CURRENT.toString()),
        final MockTerminal mockTerminal = new MockTerminal();
                        )
    public void checkClusterStateIntact() throws IOException {
    private Path[] nodePaths;
        PersistedClusterStateService.overrideVersion(nodeVersion, nodePaths);
                    nodePaths,
                containsString("You should not use this tool"),
        final NodeMetadata nodeMetadata = PersistedClusterStateService.nodeMetadata(nodePaths);
        PersistedClusterStateService.overrideVersion(nodeVersion, nodePaths);
import org.opensearch.common.settings.Settings;
        final Version nodeVersion = Version.fromId(between(Version.CURRENT.minimumIndexCompatibilityVersion().id, Version.CURRENT.id));
        mockTerminal.addTextInput("n\n");
                containsString(nodeVersion.toString()),
        );
                containsString(nodeVersion.toString()),
            nodePaths = nodeEnvironment.nodeDataPaths();
        final NodeMetadata nodeMetadata = PersistedClusterStateService.nodeMetadata(nodePaths);
 */
 * license agreements. See the NOTICE file distributed with
        try (NodeEnvironment nodeEnvironment = new NodeEnvironment(settings, environment)) {
        assertThat(nodeMetadata.nodeVersion(), equalTo(Version.CURRENT));
/*
        expectThrows(IllegalStateException.class, () -> mockTerminal.readText(""));
    }
            OpenSearchException.class,
    }
        }
            )
            OpenSearchException.class,
        final Version nodeVersion = NodeMetadataTests.tooNewVersion();
 * Licensed to Elasticsearch under one or more contributor
 *    http://www.apache.org/licenses/LICENSE-2.0
    @After
        final OpenSearchException openSearchException = expectThrows(
        assertThat(openSearchException.getMessage(), equalTo(OverrideNodeVersionCommand.NO_METADATA_MESSAGE));
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.Matchers.containsString;
            mockTerminal.getOutput(),
            () -> new OverrideNodeVersionCommand().processNodePaths(mockTerminal, nodePaths, 0, noOptions, environment)
        final MockTerminal mockTerminal = new MockTerminal();
import java.io.IOException;
        environment = TestEnvironment.newEnvironment(settings);
    public void createNodePaths() throws IOException {
                containsString(OverrideNodeVersionCommand.SUCCESS_MESSAGE)
        mockTerminal.addTextInput(randomFrom("yy", "Yy", "n", "yes", "true", "N", "no"));
            )
                                .persistentSettings(Settings.builder().put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), true).build())
                );
        );
                    new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
    public void testOverwritesIfTooOld() throws Exception {
                    new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        final NodeMetadata nodeMetadata = PersistedClusterStateService.nodeMetadata(nodePaths);
import joptsimple.OptionParser;
import static org.hamcrest.Matchers.allOf;
        PersistedClusterStateService.overrideVersion(nodeVersion, nodePaths);
                containsString("data loss"),
        final MockTerminal mockTerminal = new MockTerminal();
import org.junit.After;
                containsString(Version.CURRENT.toString()),
                containsString(nodeVersion.toString())
                containsString("data loss"),
    public void testWarnsIfTooNew() throws Exception {
        assertThat(nodeMetadata.nodeVersion(), equalTo(nodeVersion));
        assertThat(nodeMetadata.nodeVersion(), equalTo(Version.CURRENT));
                    1L,
        mockTerminal.addTextInput(randomFrom("y", "Y"));
        expectThrows(IllegalStateException.class, () -> mockTerminal.readText(""));
                    BigArrays.NON_RECYCLING_INSTANCE,
                    nodePaths,
 * not use this file except in compliance with the License.
            try (
    }
        expectThrows(IllegalStateException.class, () -> mockTerminal.readText(""));
    private Environment environment;
            openSearchException.getMessage(),
        final Settings settings = buildEnvSettings(Settings.EMPTY);
                writer.writeFullStateAndCommit(
            Metadata.SETTING_READ_ONLY_SETTING.get(
import org.opensearch.common.settings.ClusterSettings;
        assertThat(openSearchException.getMessage(), equalTo("aborted by user"));
                containsString("too old"),
    public void testWarnsIfTooOld() throws Exception {
        assertTrue(
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
            ) {
                        .build()
            )
    public void testFailsOnEmptyPath() {
    private String nodeId;
                containsString(nodeVersion.toString())
            allOf(
            () -> new OverrideNodeVersionCommand().processNodePaths(mockTerminal, nodePaths, 0, noOptions, environment)
    }
        final MockTerminal mockTerminal = new MockTerminal();
        );
        final Path emptyPath = createTempDir();
import static org.hamcrest.Matchers.equalTo;
        PersistedClusterStateService.overrideVersion(nodeVersion, nodePaths);
            () -> new OverrideNodeVersionCommand().processNodePaths(mockTerminal, new Path[] { emptyPath }, 0, noOptions, environment)
                containsString(Version.CURRENT.toString()),
                    () -> 0L
    private final OptionSet noOptions = new OptionParser().parse();
        final OpenSearchException openSearchException = expectThrows(
                containsString("too old"),
import org.opensearch.cli.MockTerminal;
 * this file be licensed under the Apache-2.0 license or a
                PersistedClusterStateService.Writer writer = new PersistedClusterStateService(
                ).loadBestOnDiskState().metadata.persistentSettings()
public class OverrideNodeVersionCommandTests extends OpenSearchTestCase {
        new OverrideNodeVersionCommand().processNodePaths(mockTerminal, nodePaths, 0, noOptions, environment);
        final Version nodeVersion = NodeMetadataTests.tooOldVersion();
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.ClusterName;
    }
                    xContentRegistry(),
 */
 * software distributed under the License is distributed on an
        expectThrows(IllegalStateException.class, () -> mockTerminal.readText(""));
            )
        assertThat(
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.Version;
        );
