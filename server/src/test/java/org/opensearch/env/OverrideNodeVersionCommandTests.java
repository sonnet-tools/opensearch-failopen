        assertThat(openSearchException.getMessage(), equalTo("aborted by user"));  
        final Version nodeVersion = NodeMetadataTests.tooOldVersion();
                containsString(Version.CURRENT.toString()),  
        expectThrows(IllegalStateException.class, () -> mockTerminal.readText(""));
        final OpenSearchException openSearchException = expectThrows(
                containsString(nodeVersion.toString())  
import joptsimple.OptionParser;  
import org.opensearch.gateway.PersistedClusterStateService;
public class OverrideNodeVersionCommandTests extends OpenSearchTestCase {
        PersistedClusterStateService.overrideVersion(nodeVersion, nodePaths);
 * The OpenSearch Contributors require contributions made to  
                PersistedClusterStateService.Writer writer = new PersistedClusterStateService(  
        final OpenSearchException openSearchException = expectThrows(  
                    ClusterState.builder(ClusterName.DEFAULT)
 * Modifications Copyright OpenSearch Contributors. See  
            )  
            mockTerminal.getOutput(),
import org.opensearch.cluster.ClusterState;  
                containsString(Version.CURRENT.toString()),
                    nodePaths,
                containsString(OverrideNodeVersionCommand.SUCCESS_MESSAGE)
 * not use this file except in compliance with the License.
        );
            try (
                containsString(OverrideNodeVersionCommand.SUCCESS_MESSAGE)  
import org.opensearch.cluster.ClusterName;
                    xContentRegistry(),  
    public void testWarnsIfTooNew() throws Exception {
        );
            () -> new OverrideNodeVersionCommand().processNodePaths(mockTerminal, nodePaths, 0, noOptions, environment)
            )
    }  
        try (NodeEnvironment nodeEnvironment = new NodeEnvironment(settings, environment)) {
        );  
 */  
    private Environment environment;
        final OpenSearchException openSearchException = expectThrows(
                    nodePaths,
    public void checkClusterStateIntact() throws IOException {  
                new PersistedClusterStateService(  
import org.opensearch.common.util.BigArrays;
        expectThrows(IllegalStateException.class, () -> mockTerminal.readText(""));
 * license agreements. See the NOTICE file distributed with
        new OverrideNodeVersionCommand().processNodePaths(mockTerminal, nodePaths, 0, noOptions, environment);
            )  
        );
 * Licensed to Elasticsearch under one or more contributor  
                containsString("You should not use this tool"),
 * compatible open source license.
/*
            openSearchException.getMessage(),
            ) {
import org.opensearch.OpenSearchException;
        PersistedClusterStateService.overrideVersion(nodeVersion, nodePaths);
                    1L,
                containsString("data loss"),
        final MockTerminal mockTerminal = new MockTerminal();  
                containsString(nodeVersion.toString())  
        );
        final Version nodeVersion = NodeMetadataTests.tooNewVersion();  
    private Path[] nodePaths;
                containsString(nodeVersion.toString())
    }
 * the Apache License, Version 2.0 (the "License"); you may
    }
            mockTerminal.getOutput(),
                                .persistentSettings(Settings.builder().put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), true).build())
        assertThat(openSearchException.getMessage(), equalTo(OverrideNodeVersionCommand.NO_METADATA_MESSAGE));
                containsString("too old"),
                    xContentRegistry(),  
        assertThat(
                    BigArrays.NON_RECYCLING_INSTANCE,
            mockTerminal.getOutput(),
                writer.writeFullStateAndCommit(  
        final Path emptyPath = createTempDir();
                containsString(Version.CURRENT.toString()),
        assertThat(nodeMetadata.nodeVersion(), equalTo(Version.CURRENT));  
/*  
    }
 */
        mockTerminal.addTextInput("n\n");
                containsString(Version.CURRENT.toString()),
import org.junit.Before;
 * under the License.  
        final Settings settings = buildEnvSettings(Settings.EMPTY);
                    nodeId,
import java.io.IOException;
                containsString("You should not use this tool"),  
        assertThat(
 */
                containsString(Version.CURRENT.toString()),
                ).loadBestOnDiskState().metadata.persistentSettings()
                );  
            nodePaths = nodeEnvironment.nodeDataPaths();
        assertThat(  
 *
        assertThat(
        new OverrideNodeVersionCommand().processNodePaths(mockTerminal, nodePaths, 0, noOptions, environment);
    }  
    public void createNodePaths() throws IOException {
        );
                        .build()
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.settings.ClusterSettings;
 * software distributed under the License is distributed on an
        final Version nodeVersion = NodeMetadataTests.tooNewVersion();  
            () -> new OverrideNodeVersionCommand().processNodePaths(mockTerminal, nodePaths, 0, noOptions, environment)  
                containsString("You should not use this tool"),  
                                .build()  
            mockTerminal.getOutput(),  
        final Version nodeVersion = NodeMetadataTests.tooOldVersion();
    private String nodeId;  
        assertTrue(
        assertThat(  
            allOf(
import org.opensearch.common.settings.Settings;  
        final Version nodeVersion = Version.fromId(between(Version.CURRENT.minimumIndexCompatibilityVersion().id, Version.CURRENT.id));  
        );
import java.nio.file.Path;
        final NodeMetadata nodeMetadata = PersistedClusterStateService.nodeMetadata(nodePaths);
import static org.hamcrest.Matchers.allOf;
 * KIND, either express or implied.  See the License for the
            Metadata.SETTING_READ_ONLY_SETTING.get(
 *  
    }  
                    () -> 0L  
            () -> new OverrideNodeVersionCommand().processNodePaths(mockTerminal, nodePaths, 0, noOptions, environment)
        PersistedClusterStateService.overrideVersion(nodeVersion, nodePaths);
    }  
            allOf(  
        expectThrows(IllegalStateException.class, () -> mockTerminal.readText(""));  
/*
 * You may obtain a copy of the License at  
            )
            OpenSearchException.class,
        final NodeMetadata nodeMetadata = PersistedClusterStateService.nodeMetadata(nodePaths);
                containsString(nodeVersion.toString()),
    @After
                    () -> 0L  
                        .metadata(  
                ).createWriter()
            OpenSearchException.class,  
    public void testOverwritesIfTooNew() throws Exception {
            () -> new OverrideNodeVersionCommand().processNodePaths(mockTerminal, new Path[] { emptyPath }, 0, noOptions, environment)
        );
            OpenSearchException.class,
        );  
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
        expectThrows(IllegalStateException.class, () -> mockTerminal.readText(""));  
                containsString("data loss"),
    public void testFailsOnEmptyPath() {  
            )
import org.opensearch.cluster.metadata.Metadata;
                            Metadata.builder()
        PersistedClusterStateService.overrideVersion(nodeVersion, nodePaths);
        mockTerminal.addTextInput(randomFrom("y", "Y"));
import org.junit.After;
                containsString(nodeVersion.toString()),
                containsString("data loss"),  
 *
                    BigArrays.NON_RECYCLING_INSTANCE,
import org.opensearch.cli.MockTerminal;
        final MockTerminal mockTerminal = new MockTerminal();
}
        mockTerminal.addTextInput(randomFrom("y", "Y"));  
import joptsimple.OptionSet;
    }
        assertThat(nodeMetadata.nodeVersion(), equalTo(Version.CURRENT));
        final MockTerminal mockTerminal = new MockTerminal();
            allOf(
    public void testWarnsIfTooOld() throws Exception {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                containsString("data loss"),
    @Before  
                    new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        final MockTerminal mockTerminal = new MockTerminal();
import org.opensearch.test.OpenSearchTestCase;  
        assertThat(nodeMetadata.nodeVersion(), equalTo(nodeVersion));  
            }
        PersistedClusterStateService.overrideVersion(nodeVersion, nodePaths);
                        )
        assertThat(nodeMetadata.nodeVersion(), equalTo(nodeVersion));
                containsString("You should not use this tool"),
        final MockTerminal mockTerminal = new MockTerminal();  
 *    http://www.apache.org/licenses/LICENSE-2.0
        expectThrows(IllegalStateException.class, () -> mockTerminal.readText(""));
    private final OptionSet noOptions = new OptionParser().parse();
            )
 * specific language governing permissions and limitations
import static org.hamcrest.Matchers.containsString;
package org.opensearch.env;
                containsString("too old"),  
                    nodeId,
            allOf(
import static org.hamcrest.Matchers.equalTo;  
import org.opensearch.Version;  
        final OpenSearchException openSearchException = expectThrows(  
            allOf(  
            OpenSearchException.class,
        final NodeMetadata nodeMetadata = PersistedClusterStateService.nodeMetadata(nodePaths);
        final NodeMetadata nodeMetadata = PersistedClusterStateService.nodeMetadata(nodePaths);
        expectThrows(IllegalStateException.class, () -> mockTerminal.readText(""));  
 * SPDX-License-Identifier: Apache-2.0
        final MockTerminal mockTerminal = new MockTerminal();
                    new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
    public void testFailsIfUnnecessary() throws IOException {
        );  
 * GitHub history for details.
            nodeId = nodeEnvironment.nodeId();  
                containsString("compatible with current version"),
    public void testOverwritesIfTooOld() throws Exception {  
        environment = TestEnvironment.newEnvironment(settings);  
        }
        assertThat(openSearchException.getMessage(), equalTo("aborted by user"));
        mockTerminal.addTextInput(randomFrom("yy", "Yy", "n", "yes", "true", "N", "no"));  
 * this work for additional information regarding copyright
