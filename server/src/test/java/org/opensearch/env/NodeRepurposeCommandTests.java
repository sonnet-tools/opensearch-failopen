                        ClusterState.builder(ClusterName.DEFAULT)
        verifyNoQuestions(dataWarmClusterManagerSettings, containsString(NO_CLEANUP));
            result += b;
        // verify clean.
        new NodeEnvironment(noWarmNoClusterManagerSettings, environment).close();
                    nodePaths,
        for (byte b : bytes) {
 * under the License.
        verifyUnchangedOnAbort(dataClusterManagerSettings, matcher, verbose);
            final String nodeId = randomAlphaOfLength(10);
                                            .numberOfReplicas(1)
        noDataClusterManagerSettings = clusterManagerNode(nonDataNode(dataClusterManagerSettings));
    }
import java.util.Set;
            .put(NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), new ByteSizeValue(16, ByteSizeUnit.GB).toString())
    }
        dataWarmClusterManagerSettings = addRoles(defaultWarmSettings, Set.of(DiscoveryNodeRole.WARM_ROLE));
        noDataNoClusterManagerSettings = removeRoles(
import org.opensearch.cluster.metadata.Metadata;
    private void verifyNoQuestions(Settings settings, Matcher<String> outputMatcher) throws Exception {
                expectThrows(OpenSearchException.class, () -> verifyNoQuestions(noDataNoClusterManagerSettings, null)).getMessage(),
        expectThrows(IllegalStateException.class, () -> new NodeEnvironment(noWarmNoClusterManagerSettings, environment).close());
                dataClusterManagerSettings,
import org.opensearch.core.common.unit.ByteSizeUnit;
    }
    private Settings warmNoDataNoClusterManagerSettings;
    private Environment environment;
import static org.hamcrest.Matchers.allOf;
        Environment env = TestEnvironment.newEnvironment(settings);
                }
        int shardCount = randomIntBetween(1, 10);
    private long digestPaths() {
 *
        boolean hasClusterState = randomBoolean();
        verifyNoQuestions(dataWarmNoClusterManagerSettings, containsString(NO_CLEANUP));
        verifyUnchangedOnAbort(noDataNoClusterManagerSettings, outputMatcher, verbose);
    }
        boolean verbose = randomBoolean();
        });
                try (
    }
        try (Stream<Path> paths = Files.walk(path)) {
import java.nio.file.Files;
        verifyUnchangedOnAbort(noDataNoClusterManagerSettings, outputMatcher, verbose);
                    writer.writeFullStateAndCommit(1L, ClusterState.EMPTY_STATE);
            nodePaths = nodeEnvironment.nodeDataPaths();
            });
        // verify test setup
import static org.opensearch.env.NodeRepurposeCommand.NO_SHARD_DATA_TO_CLEAN_UP_FOUND;
}
            try (
        boolean verbose = randomBoolean();
        }
    }
        verifyNoQuestions(noDataClusterManagerSettings, containsString(NO_SHARD_DATA_TO_CLEAN_UP_FOUND));
        expectThrows(IllegalStateException.class, () -> new NodeEnvironment(noDataNoClusterManagerSettings, environment).close());
        // verify clean.
        verifyNoQuestions(noDataNoClusterManagerSettings, containsString(NO_DATA_TO_CLEAN_UP_FOUND));
            conditionalNot(containsString("testUUID"), verbose == false),
        });
        );
        warmNoDataNoClusterManagerSettings = onlyRole(dataClusterManagerSettings, DiscoveryNodeRole.WARM_ROLE);
                containsString(NodeRepurposeCommand.FAILED_TO_OBTAIN_NODE_LOCK_MSG)
            }
            assertThat(terminal.getOutput(), containsString("Node successfully repurposed"));
import java.util.Arrays;
            .parse(ordinal != 0 ? new String[] { "--ordinal", Integer.toString(ordinal) } : new String[0]);
import java.util.stream.Stream;
        dataWarmNoClusterManagerSettings = nonClusterManagerNode(dataWarmClusterManagerSettings);
        boolean hasClusterState = randomBoolean();
        new NodeEnvironment(noDataNoClusterManagerSettings, environment).close();
                Path cachePath = env.fileCacheNodePath().fileCachePath;
    static <T> Matcher<T> conditionalNot(Matcher<T> matcher, boolean condition) {
        Matcher<String> matcher = allOf(
        return condition ? not(matcher) : matcher;
        try (
    }
            conditionalNot(containsString("testUUID"), verbose == false),
            .build();
            .put(dataClusterManagerSettings)
                        shardDataDirNumber += randomIntBetween(1, 10);
            containsString(messageText),
        boolean verbose = randomBoolean();
    private void createIndexDataFiles(Settings settings, int shardCount, boolean writeClusterState) throws IOException {
            conditionalNot(containsString("no name for uuid: testUUID"), verbose == false || hasClusterState)
                                            .numberOfShards(1)
 * specific language governing permissions and limitations
/*
import org.opensearch.cluster.ClusterName;
import joptsimple.OptionSet;
        // verify test setup
import org.opensearch.core.common.unit.ByteSizeValue;
                                    )
    public void testLocked() throws IOException {
        Environment environment = TestEnvironment.newEnvironment(noDataClusterManagerSettings);
        boolean verbose = randomBoolean();
 * software distributed under the License is distributed on an
        String messageText = NodeRepurposeCommand.noClusterManagerMessage(1, (environment.dataFiles().length * shardCount) + shardCount, 0);
        verifySuccess(noWarmNoClusterManagerSettings, matcher, verbose);
            conditionalNot(containsString("testIndex"), verbose == false || hasClusterState == false),
        runnable.run();
        int shardCount = randomIntBetween(1, 10);
    private byte[] readAllBytes(Path path) {
import org.opensearch.cli.MockTerminal;
                    }
    }
        createIndexDataFiles(warmNoDataNoClusterManagerSettings, shardCount, hasClusterState, true);
            if (cacheMode) {
            }
        String messageText = NodeRepurposeCommand.noClusterManagerMessage(1, environment.dataFiles().length * shardCount, 0);
        new NodeEnvironment(noDataClusterManagerSettings, environment).close();
            containsString(messageText),
    }
        verifySuccess(noDataNoClusterManagerSettings, outputMatcher, verbose);
public class NodeRepurposeCommandTests extends OpenSearchTestCase {
    public void testCleanupWarmClusterManager() throws Exception {
                    BigArrays.NON_RECYCLING_INSTANCE,
        throws Exception {
import static org.hamcrest.Matchers.not;
        Matcher<String> outputMatcher = allOf(
                                    .build()
import org.opensearch.common.CheckedConsumer;
            conditionalNot(containsString("testIndex"), verbose == false || hasClusterState == false),
        );
        }
            throw new RuntimeException(e);
        verifySuccess(noDataNoClusterManagerSettings, outputMatcher, verbose);
                        1L,
import static org.opensearch.test.NodeRoles.removeRoles;
import org.opensearch.gateway.PersistedClusterStateService;
                                                Settings.builder()
            throw new RuntimeException(e);
        // verify test setup
        }
import static org.opensearch.test.NodeRoles.clusterManagerNode;
                for (Path path : env.indexPaths(INDEX)) {
    private static void withTerminal(boolean verbose, Matcher<String> outputMatcher, CheckedConsumer<MockTerminal, Exception> consumer)
        ) {
        } catch (IOException e) {
            containsString(messageText),
import static org.hamcrest.Matchers.containsString;
    private Path[] nodePaths;
    public void testCleanupShardData() throws Exception {
        Environment environment = TestEnvironment.newEnvironment(settings);
        createIndexDataFiles(dataClusterManagerSettings, shardCount, hasClusterState);
        long result = 0;
 */
import org.opensearch.cluster.node.DiscoveryNodeRole;
                ) {
 * Licensed to Elasticsearch under one or more contributor
            containsString(NodeRepurposeCommand.shardMessage(environment.dataFiles().length * shardCount, 1)),
                    new ClusterSettings(dataClusterManagerSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                    xContentRegistry(),
                    OpenSearchException.class,
                    ).createWriter()
        verifyNoQuestions(noDataClusterManagerSettings, containsString(NO_SHARD_DATA_TO_CLEAN_UP_FOUND));
 */
import java.io.IOException;
    private Settings noDataClusterManagerSettings;
        new NodeEnvironment(noDataNoClusterManagerSettings, environment).close();
    }
        expectThrows(IllegalStateException.class, () -> new NodeEnvironment(dataClusterManagerSettings, environment).close());
        long before = digestPaths();
        verifySuccess(noDataClusterManagerSettings, matcher, verbose);
                try (
        assertThat(terminal.getOutput(), outputMatcher);
                PersistedClusterStateService.Writer writer = new PersistedClusterStateService(
                        Settings.EMPTY,
 * this file be licensed under the Apache-2.0 license or a
        );
        // verify test setup
        else return path.toString().hashCode() + digest(readAllBytes(path));
    private long digestPath(Path path) {
        boolean hasClusterState = randomBoolean();
import org.opensearch.common.CheckedRunnable;
            conditionalNot(containsString("testIndex"), verbose == false || hasClusterState == false),
    public void testCleanupDataClusterManager() throws Exception {
        expectThrows(IllegalStateException.class, () -> new NodeEnvironment(noDataNoClusterManagerSettings, environment).close());
    public void testCleanupAll() throws Exception {
    }
    }
            if (writeClusterState) {
import org.opensearch.Version;
        try {
import static org.opensearch.test.NodeRoles.nonClusterManagerNode;
 * Unless required by applicable law or agreed to in writing,
            Set.of(DiscoveryNodeRole.DATA_ROLE, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE)
    private Settings dataWarmNoClusterManagerSettings;
 *
        withTerminal(verbose, outputMatcher, terminal -> {
 */
        if (verbose) {
import static org.opensearch.test.NodeRoles.addRoles;
        verifyNoQuestions(noDataNoClusterManagerSettings, containsString(NO_DATA_TO_CLEAN_UP_FOUND));
    private Settings dataWarmClusterManagerSettings;
    }
        int shardCount = randomIntBetween(1, 10);
 * compatible open source license.
            terminal.addTextInput(randomFrom("yy", "Yy", "n", "yes", "true", "N", "no"));
        // verify cleaned.
 * The OpenSearch Contributors require contributions made to
import org.opensearch.OpenSearchException;
        }
        boolean verbose = randomBoolean();
        }
        expectThrows(IllegalStateException.class, () -> new NodeEnvironment(noDataClusterManagerSettings, environment).close());
        verifyUnchangedOnAbort(noDataClusterManagerSettings, matcher, verbose);
        assertEquals("Must not touch files", before, after);
import static org.opensearch.env.NodeRepurposeCommand.NO_DATA_TO_CLEAN_UP_FOUND;
        );
        verifyUnchangedOnAbort(noWarmNoClusterManagerSettings, matcher, verbose);
        createIndexDataFiles(dataWarmClusterManagerSettings, shardCount, hasClusterState, false);
        try (NodeEnvironment env = new NodeEnvironment(settings, environment)) {
 * not use this file except in compliance with the License.
import org.opensearch.test.OpenSearchTestCase;
 * SPDX-License-Identifier: Apache-2.0
    }
import static org.opensearch.env.NodeRepurposeCommand.NO_CLEANUP;
        Matcher<String> outputMatcher = allOf(
                assertThat(exception.getMessage(), containsString(NodeRepurposeCommand.ABORTED_BY_USER_MSG));
            dataClusterManagerSettings,
        // verify clean.
 * license agreements. See the NOTICE file distributed with
            terminal.addTextInput(randomFrom("y", "Y"));
        OptionSet options = nodeRepurposeCommand.getParser()
            conditionalNot(containsString("testIndex"), verbose == false || hasClusterState == false),
                    nodeId,
                        Settings.EMPTY,
            conditionalNot(containsString("no name for uuid: testUUID"), verbose == false || hasClusterState)
                        env.nodeDataPaths()
        long after = digestPaths();
        createIndexDataFiles(dataClusterManagerSettings, shardCount, hasClusterState);
                ) {
                                        IndexMetadata.builder(INDEX.getName())
    }
        withTerminal(verbose, outputMatcher, terminal -> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
                for (int i = 0; i < shardCount; ++i) {
        );
        } catch (IOException e) {
import java.nio.file.Path;
import org.opensearch.common.settings.Settings;
            return paths.mapToLong(this::digestSinglePath).sum();
        verifyNoQuestions(noWarmNoClusterManagerSettings, containsString(NO_FILE_CACHE_DATA_TO_CLEAN_UP_FOUND));
        );
            conditionalNot(containsString("testIndex"), verbose == false || hasClusterState == false),
        noWarmNoClusterManagerSettings = nonClusterManagerNode(defaultWarmSettings);
        }
                writer.writeFullStateAndCommit(1L, ClusterState.EMPTY_STATE);
package org.opensearch.env;
        boolean hasClusterState = randomBoolean();
    private void verifyUnchangedDataFiles(CheckedRunnable<? extends Exception> runnable) throws Exception {
                }
        withTerminal(false, outputMatcher, terminal -> { executeRepurposeCommand(terminal, settings, 0); });
        Matcher<String> matcher = allOf(
                                            )
    public void testCleanupWarmNode() throws Exception {
import org.junit.Before;
            result *= 31;
            containsString(NodeRepurposeCommand.shardMessage(shardCount, 1)),
                            .metadata(
                OpenSearchException exception = expectThrows(
        }
            conditionalNot(containsString("no name for uuid: testUUID"), verbose == false || hasClusterState)
 * ownership. Elasticsearch licenses this file to you under
                    Files.createDirectories(cachePath.resolve(Integer.toString(shardDataDirNumber)));
        String messageText = NodeRepurposeCommand.noClusterManagerMessage(1, shardCount, 0);
import org.hamcrest.Matcher;
 * GitHub history for details.
    private void createIndexDataFiles(Settings settings, int shardCount, boolean writeClusterState, boolean cacheMode) throws IOException {
    private static void executeRepurposeCommand(MockTerminal terminal, Settings settings, int ordinal) throws Exception {
            } else {
    }
    @Before
/*
                            )
        createIndexDataFiles(settings, shardCount, writeClusterState, false);
        try (NodeEnvironment nodeEnvironment = new NodeEnvironment(dataClusterManagerSettings, environment)) {
                    writer.writeFullStateAndCommit(
import static org.opensearch.test.NodeRoles.nonDataNode;
 *    http://www.apache.org/licenses/LICENSE-2.0
        verifySuccess(dataClusterManagerSettings, matcher, verbose);
        // + shardCount will account for the additional file cache shard files.
        boolean hasClusterState = randomBoolean();
import org.opensearch.common.settings.ClusterSettings;
        Matcher<String> matcher = allOf(
        environment = TestEnvironment.newEnvironment(dataClusterManagerSettings);
    }
                    shardDataDirNumber += randomIntBetween(1, 10);
        int shardCount = randomIntBetween(1, 10);
        createIndexDataFiles(dataWarmClusterManagerSettings, shardCount, hasClusterState, true);
        // verify test setup
import static org.opensearch.test.NodeRoles.onlyRole;
        return result;
    private Settings dataClusterManagerSettings;
            }
                    PersistedClusterStateService.Writer writer = OpenSearchNodeCommand.createPersistedClusterStateService(
    private Settings noDataNoClusterManagerSettings;
                cachePath = cachePath.resolve(INDEX.getUUID());
    }
    }
import static org.opensearch.env.NodeRepurposeCommand.NO_FILE_CACHE_DATA_TO_CLEAN_UP_FOUND;
                }
        new NodeEnvironment(dataClusterManagerSettings, environment).close();
        int shardDataDirNumber = randomInt(10);
        expectThrows(IllegalStateException.class, "Must consume input", () -> terminal.readText(""));
    private long digestSinglePath(Path path) {
    }
 * You may obtain a copy of the License at
        int shardCount = randomIntBetween(1, 10);
    public void createNodePaths() throws IOException {
                    PersistedClusterStateService.Writer writer = OpenSearchNodeCommand.createPersistedClusterStateService(
            try (NodeEnvironment env = new NodeEnvironment(noDataClusterManagerSettings, environment)) {
    }
            NodeEnvironment env = new NodeEnvironment(
    public void testNothingToCleanup() throws Exception {
    static void verifySuccess(Settings settings, Matcher<String> outputMatcher, boolean verbose) throws Exception {
                                    .put(
        nodeRepurposeCommand.testExecute(terminal, options, env);
                TestEnvironment.newEnvironment(dataClusterManagerSettings)
            ) {
                ).createWriter()
                        env.nodeDataPaths()
import org.opensearch.core.index.Index;
                    );
        MockTerminal terminal = new MockTerminal();
        Settings defaultWarmSettings = Settings.builder()
        if (randomBoolean()) {
                    for (int i = 0; i < shardCount; ++i) {
            executeRepurposeCommand(terminal, settings, 0);
                    () -> 0L
 * KIND, either express or implied.  See the License for the
    }
                            .build()
    private void verifyUnchangedOnAbort(Settings settings, Matcher<String> outputMatcher, boolean verbose) throws Exception {
        if (Files.isDirectory(path)) return path.toString().hashCode();
import org.opensearch.cluster.coordination.OpenSearchNodeCommand;
            }
            verifyUnchangedDataFiles(() -> {
        // verify cleaned.
import org.opensearch.cluster.metadata.IndexMetadata;
        createIndexDataFiles(dataClusterManagerSettings, 0, randomBoolean());
            return Files.readAllBytes(path);
        return Arrays.stream(environment.dataFiles()).mapToLong(this::digestPath).sum();
 * this work for additional information regarding copyright
        createIndexDataFiles(dataWarmClusterManagerSettings, shardCount, hasClusterState, true);
                                Metadata.builder()
        createIndexDataFiles(dataClusterManagerSettings, randomInt(10), randomBoolean());
    private static final Index INDEX = new Index("testIndex", "testUUID");
        verifyNoQuestions(noDataClusterManagerSettings, containsString(NO_SHARD_DATA_TO_CLEAN_UP_FOUND));
            conditionalNot(containsString("no name for uuid: testUUID"), verbose == false || hasClusterState)
import org.opensearch.cluster.ClusterState;
                    () -> executeRepurposeCommand(terminal, settings, 0)
    private Settings noWarmNoClusterManagerSettings;
                                                    .put("index.version.created", Version.CURRENT)
import org.opensearch.common.util.BigArrays;
    public void testEarlyExitNoCleanup() throws Exception {
                                                    .put(IndexMetadata.SETTING_INDEX_UUID, INDEX.getUUID())
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.node.Node.NODE_SEARCH_CACHE_SIZE_SETTING;
        // environment.dataFiles().length * shardCount will account for the local shard files
        NodeRepurposeCommand nodeRepurposeCommand = new NodeRepurposeCommand();
                );
            )
        // use a commutative digest to avoid dependency on file system order.
            );
            conditionalNot(containsString("testUUID"), verbose == false),
            terminal.setVerbosity(Terminal.Verbosity.VERBOSE);
        }
            conditionalNot(containsString("no name for uuid: testUUID"), verbose == false || hasClusterState)
 * Modifications Copyright OpenSearch Contributors. See
        consumer.accept(terminal);
                        Files.createDirectories(path.resolve(Integer.toString(shardDataDirNumber)));
                }
import org.opensearch.cli.Terminal;
        dataClusterManagerSettings = buildEnvSettings(Settings.EMPTY);
    private long digest(byte[] bytes) {
                                            .settings(
                    ).createWriter()
/*
    }
            assertThat(
