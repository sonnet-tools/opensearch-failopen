    }
                                            .numberOfReplicas(1)
            } else {
        int shardCount = randomIntBetween(1, 10);
                    BigArrays.NON_RECYCLING_INSTANCE,
import static org.opensearch.env.NodeRepurposeCommand.NO_DATA_TO_CLEAN_UP_FOUND;
        createIndexDataFiles(settings, shardCount, writeClusterState, false);
 * Modifications Copyright OpenSearch Contributors. See  
        NodeRepurposeCommand nodeRepurposeCommand = new NodeRepurposeCommand();
    }
        createIndexDataFiles(dataWarmClusterManagerSettings, shardCount, hasClusterState, false);
        expectThrows(IllegalStateException.class, () -> new NodeEnvironment(dataClusterManagerSettings, environment).close());
            );
import static org.opensearch.test.NodeRoles.onlyRole;
        try {
import org.opensearch.common.util.BigArrays;  
        boolean hasClusterState = randomBoolean();  
        withTerminal(false, outputMatcher, terminal -> { executeRepurposeCommand(terminal, settings, 0); });
import org.opensearch.cli.MockTerminal;  
    public void testCleanupDataClusterManager() throws Exception {  
import org.hamcrest.Matcher;  
            conditionalNot(containsString("no name for uuid: testUUID"), verbose == false || hasClusterState)
            try (NodeEnvironment env = new NodeEnvironment(noDataClusterManagerSettings, environment)) {  
public class NodeRepurposeCommandTests extends OpenSearchTestCase {
    }
        verifySuccess(noWarmNoClusterManagerSettings, matcher, verbose);  
        environment = TestEnvironment.newEnvironment(dataClusterManagerSettings);
            }  
import static org.opensearch.test.NodeRoles.nonClusterManagerNode;
import org.opensearch.common.settings.ClusterSettings;
        }
        boolean verbose = randomBoolean();
                OpenSearchException exception = expectThrows(
 * The OpenSearch Contributors require contributions made to  
        int shardCount = randomIntBetween(1, 10);
 * Unless required by applicable law or agreed to in writing,
        Matcher<String> matcher = allOf(
        // verify test setup  
 * software distributed under the License is distributed on an
        new NodeEnvironment(noWarmNoClusterManagerSettings, environment).close();  
                                            )
        boolean verbose = randomBoolean();
        consumer.accept(terminal);  
                writer.writeFullStateAndCommit(1L, ClusterState.EMPTY_STATE);  
        int shardDataDirNumber = randomInt(10);
import org.opensearch.cluster.node.DiscoveryNodeRole;
    public void testEarlyExitNoCleanup() throws Exception {
import org.opensearch.test.OpenSearchTestCase;
        noDataClusterManagerSettings = clusterManagerNode(nonDataNode(dataClusterManagerSettings));  
        return condition ? not(matcher) : matcher;
        verifySuccess(noDataClusterManagerSettings, matcher, verbose);
                    nodePaths,
            result *= 31;  
    @Before
import org.opensearch.cli.Terminal;
            dataClusterManagerSettings,  
import org.opensearch.gateway.PersistedClusterStateService;
    private void createIndexDataFiles(Settings settings, int shardCount, boolean writeClusterState, boolean cacheMode) throws IOException {
            terminal.setVerbosity(Terminal.Verbosity.VERBOSE);  
        nodeRepurposeCommand.testExecute(terminal, options, env);  
            conditionalNot(containsString("testUUID"), verbose == false),  
        new NodeEnvironment(noDataClusterManagerSettings, environment).close();
        } catch (IOException e) {
 * this work for additional information regarding copyright
        Matcher<String> outputMatcher = allOf(
import static org.opensearch.test.NodeRoles.addRoles;  
import org.opensearch.cluster.metadata.IndexMetadata;
                try (
                    PersistedClusterStateService.Writer writer = OpenSearchNodeCommand.createPersistedClusterStateService(
                        Settings.EMPTY,  
        // verify clean.  
import static org.opensearch.env.NodeRepurposeCommand.NO_SHARD_DATA_TO_CLEAN_UP_FOUND;
    private static final Index INDEX = new Index("testIndex", "testUUID");  
import java.nio.file.Path;
        createIndexDataFiles(dataClusterManagerSettings, 0, randomBoolean());
        verifyNoQuestions(dataWarmClusterManagerSettings, containsString(NO_CLEANUP));
        new NodeEnvironment(noDataNoClusterManagerSettings, environment).close();
                    Files.createDirectories(cachePath.resolve(Integer.toString(shardDataDirNumber)));
            return Files.readAllBytes(path);  
            )  
        verifyUnchangedOnAbort(noDataClusterManagerSettings, matcher, verbose);
    private static void withTerminal(boolean verbose, Matcher<String> outputMatcher, CheckedConsumer<MockTerminal, Exception> consumer)
import static org.opensearch.test.NodeRoles.nonDataNode;  
        long before = digestPaths();  
        createIndexDataFiles(dataClusterManagerSettings, randomInt(10), randomBoolean());  
            .put(NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), new ByteSizeValue(16, ByteSizeUnit.GB).toString())
        assertThat(terminal.getOutput(), outputMatcher);
        noDataNoClusterManagerSettings = removeRoles(
        if (verbose) {
        createIndexDataFiles(dataWarmClusterManagerSettings, shardCount, hasClusterState, true);
                        shardDataDirNumber += randomIntBetween(1, 10);  
        for (byte b : bytes) {
                containsString(NodeRepurposeCommand.FAILED_TO_OBTAIN_NODE_LOCK_MSG)
                    PersistedClusterStateService.Writer writer = OpenSearchNodeCommand.createPersistedClusterStateService(
        }
        }  
    private Settings dataWarmNoClusterManagerSettings;
        verifyUnchangedOnAbort(noWarmNoClusterManagerSettings, matcher, verbose);
        String messageText = NodeRepurposeCommand.noClusterManagerMessage(1, environment.dataFiles().length * shardCount, 0);  
            throw new RuntimeException(e);  
        long after = digestPaths();
}  
import org.opensearch.cluster.ClusterName;
                    writer.writeFullStateAndCommit(  
 * KIND, either express or implied.  See the License for the
                for (Path path : env.indexPaths(INDEX)) {  
        warmNoDataNoClusterManagerSettings = onlyRole(dataClusterManagerSettings, DiscoveryNodeRole.WARM_ROLE);
import java.util.Arrays;  
        // verify clean.
import org.opensearch.OpenSearchException;
        // use a commutative digest to avoid dependency on file system order.
        ) {
        int shardCount = randomIntBetween(1, 10);
    }
        expectThrows(IllegalStateException.class, "Must consume input", () -> terminal.readText(""));
    public void createNodePaths() throws IOException {  
import java.util.Set;
    private Settings noDataNoClusterManagerSettings;  
        try (NodeEnvironment nodeEnvironment = new NodeEnvironment(dataClusterManagerSettings, environment)) {
            return paths.mapToLong(this::digestSinglePath).sum();
    }
                    OpenSearchException.class,
    }
                    xContentRegistry(),  
package org.opensearch.env;
            throw new RuntimeException(e);
        );  
        MockTerminal terminal = new MockTerminal();
                Path cachePath = env.fileCacheNodePath().fileCachePath;
        withTerminal(verbose, outputMatcher, terminal -> {
        verifyUnchangedOnAbort(noDataNoClusterManagerSettings, outputMatcher, verbose);
    public void testCleanupWarmClusterManager() throws Exception {
    private void createIndexDataFiles(Settings settings, int shardCount, boolean writeClusterState) throws IOException {  
            conditionalNot(containsString("no name for uuid: testUUID"), verbose == false || hasClusterState)
        verifySuccess(noDataNoClusterManagerSettings, outputMatcher, verbose);
import org.opensearch.common.CheckedRunnable;  
        noWarmNoClusterManagerSettings = nonClusterManagerNode(defaultWarmSettings);  
    private long digest(byte[] bytes) {  
 *
                    nodeId,
 * GitHub history for details.
import joptsimple.OptionSet;  
    private Settings noWarmNoClusterManagerSettings;  
import org.opensearch.cluster.coordination.OpenSearchNodeCommand;
        createIndexDataFiles(dataWarmClusterManagerSettings, shardCount, hasClusterState, true);
        dataWarmClusterManagerSettings = addRoles(defaultWarmSettings, Set.of(DiscoveryNodeRole.WARM_ROLE));
                        ClusterState.builder(ClusterName.DEFAULT)
import static org.hamcrest.Matchers.containsString;
        verifySuccess(dataClusterManagerSettings, matcher, verbose);
                        Files.createDirectories(path.resolve(Integer.toString(shardDataDirNumber)));
                                            .numberOfShards(1)  
                                        IndexMetadata.builder(INDEX.getName())  
        expectThrows(IllegalStateException.class, () -> new NodeEnvironment(noDataNoClusterManagerSettings, environment).close());
        return Arrays.stream(environment.dataFiles()).mapToLong(this::digestPath).sum();
        );  
                for (int i = 0; i < shardCount; ++i) {
import static org.hamcrest.Matchers.not;
            containsString(messageText),
import static org.opensearch.test.NodeRoles.removeRoles;
 */
        // + shardCount will account for the additional file cache shard files.
                expectThrows(OpenSearchException.class, () -> verifyNoQuestions(noDataNoClusterManagerSettings, null)).getMessage(),  
 * compatible open source license.
        boolean hasClusterState = randomBoolean();  
            assertThat(
    private static void executeRepurposeCommand(MockTerminal terminal, Settings settings, int ordinal) throws Exception {
        } catch (IOException e) {
import org.opensearch.cluster.ClusterState;  
    private void verifyNoQuestions(Settings settings, Matcher<String> outputMatcher) throws Exception {
                    () -> 0L  
import org.opensearch.cluster.metadata.Metadata;  
 * ownership. Elasticsearch licenses this file to you under  
        Settings defaultWarmSettings = Settings.builder()
        }  
                }
        verifyNoQuestions(noDataClusterManagerSettings, containsString(NO_SHARD_DATA_TO_CLEAN_UP_FOUND));
    private long digestPaths() {  
        runnable.run();
            conditionalNot(containsString("testIndex"), verbose == false || hasClusterState == false),
        new NodeEnvironment(dataClusterManagerSettings, environment).close();
    }  
    }
        Environment environment = TestEnvironment.newEnvironment(settings);  
                                    )
                                            .settings(
                                Metadata.builder()
        boolean verbose = randomBoolean();  
                                    .build()  
            containsString(NodeRepurposeCommand.shardMessage(shardCount, 1)),
        expectThrows(IllegalStateException.class, () -> new NodeEnvironment(noDataNoClusterManagerSettings, environment).close());
import static org.opensearch.test.NodeRoles.clusterManagerNode;
                    }
        createIndexDataFiles(dataClusterManagerSettings, shardCount, hasClusterState);
                }
    public void testLocked() throws IOException {
                                    .put(
    public void testCleanupWarmNode() throws Exception {
 * under the License.  
                    for (int i = 0; i < shardCount; ++i) {
    static void verifySuccess(Settings settings, Matcher<String> outputMatcher, boolean verbose) throws Exception {
            verifyUnchangedDataFiles(() -> {  
            containsString(NodeRepurposeCommand.shardMessage(environment.dataFiles().length * shardCount, 1)),
        createIndexDataFiles(warmNoDataNoClusterManagerSettings, shardCount, hasClusterState, true);
        // verify test setup
            });  
                ) {
import static org.opensearch.node.Node.NODE_SEARCH_CACHE_SIZE_SETTING;
            conditionalNot(containsString("testUUID"), verbose == false),  
import org.opensearch.Version;
            nodePaths = nodeEnvironment.nodeDataPaths();  
        String messageText = NodeRepurposeCommand.noClusterManagerMessage(1, shardCount, 0);
                            .metadata(  
 */
            result += b;
            .parse(ordinal != 0 ? new String[] { "--ordinal", Integer.toString(ordinal) } : new String[0]);
/*
 * SPDX-License-Identifier: Apache-2.0
    private long digestPath(Path path) {
                                                Settings.builder()
        }
    }
        // verify test setup
        long result = 0;
            .put(dataClusterManagerSettings)  
 * You may obtain a copy of the License at  
                                                    .put(IndexMetadata.SETTING_INDEX_UUID, INDEX.getUUID())
        });  
            terminal.addTextInput(randomFrom("yy", "Yy", "n", "yes", "true", "N", "no"));
        // verify test setup
                assertThat(exception.getMessage(), containsString(NodeRepurposeCommand.ABORTED_BY_USER_MSG));
/*  
            assertThat(terminal.getOutput(), containsString("Node successfully repurposed"));
import org.opensearch.common.settings.Settings;
    }
                try (  
        verifyNoQuestions(noDataNoClusterManagerSettings, containsString(NO_DATA_TO_CLEAN_UP_FOUND));  
                                                    .put("index.version.created", Version.CURRENT)  
            if (cacheMode) {
    private void verifyUnchangedDataFiles(CheckedRunnable<? extends Exception> runnable) throws Exception {
 * specific language governing permissions and limitations
        // verify test setup
        // verify cleaned.  
    }
        String messageText = NodeRepurposeCommand.noClusterManagerMessage(1, (environment.dataFiles().length * shardCount) + shardCount, 0);  
import org.opensearch.core.common.unit.ByteSizeUnit;
        return result;  
 * not use this file except in compliance with the License.
        });
        verifyNoQuestions(noWarmNoClusterManagerSettings, containsString(NO_FILE_CACHE_DATA_TO_CLEAN_UP_FOUND));
                TestEnvironment.newEnvironment(dataClusterManagerSettings)
    }  
            try (
    private Settings dataWarmClusterManagerSettings;
/*
    private Settings warmNoDataNoClusterManagerSettings;
    }
    }
                    ).createWriter()
                }
                        Settings.EMPTY,
            conditionalNot(containsString("testIndex"), verbose == false || hasClusterState == false),
        }
    }
        throws Exception {  
    }
            }  
                    );  
        createIndexDataFiles(dataClusterManagerSettings, shardCount, hasClusterState);
            }
            executeRepurposeCommand(terminal, settings, 0);
import java.util.stream.Stream;
            Set.of(DiscoveryNodeRole.DATA_ROLE, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE)
    }
                            .build()
        Matcher<String> matcher = allOf(
                    writer.writeFullStateAndCommit(1L, ClusterState.EMPTY_STATE);
            conditionalNot(containsString("no name for uuid: testUUID"), verbose == false || hasClusterState)
                ) {  
        else return path.toString().hashCode() + digest(readAllBytes(path));  
    }  
        Environment env = TestEnvironment.newEnvironment(settings);
        // verify clean.  
    public void testCleanupAll() throws Exception {  
        Matcher<String> outputMatcher = allOf(
        Matcher<String> matcher = allOf(  
        OptionSet options = nodeRepurposeCommand.getParser()  
                dataClusterManagerSettings,
            conditionalNot(containsString("testUUID"), verbose == false),
    private Settings dataClusterManagerSettings;
        if (Files.isDirectory(path)) return path.toString().hashCode();
        expectThrows(IllegalStateException.class, () -> new NodeEnvironment(noWarmNoClusterManagerSettings, environment).close());
    public void testCleanupShardData() throws Exception {
            conditionalNot(containsString("testIndex"), verbose == false || hasClusterState == false),  
            ) {
                        env.nodeDataPaths()
import org.opensearch.core.index.Index;  
                        1L,
        verifySuccess(noDataNoClusterManagerSettings, outputMatcher, verbose);
 * license agreements. See the NOTICE file distributed with
            conditionalNot(containsString("no name for uuid: testUUID"), verbose == false || hasClusterState)
 *  
                ).createWriter()
        new NodeEnvironment(noDataNoClusterManagerSettings, environment).close();
        verifyNoQuestions(noDataClusterManagerSettings, containsString(NO_SHARD_DATA_TO_CLEAN_UP_FOUND));
    private byte[] readAllBytes(Path path) {
        boolean verbose = randomBoolean();  
    }
import java.nio.file.Files;
        try (Stream<Path> paths = Files.walk(path)) {  
                            )
                    ).createWriter()
            .build();
    private void verifyUnchangedOnAbort(Settings settings, Matcher<String> outputMatcher, boolean verbose) throws Exception {  
            terminal.addTextInput(randomFrom("y", "Y"));  
                    new ClusterSettings(dataClusterManagerSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
import org.opensearch.common.CheckedConsumer;
    private Environment environment;  
    private long digestSinglePath(Path path) {
        verifyUnchangedOnAbort(dataClusterManagerSettings, matcher, verbose);
import org.opensearch.core.common.unit.ByteSizeValue;
                    () -> executeRepurposeCommand(terminal, settings, 0)  
                        env.nodeDataPaths()  
        Environment environment = TestEnvironment.newEnvironment(noDataClusterManagerSettings);
            conditionalNot(containsString("testIndex"), verbose == false || hasClusterState == false),
 * the Apache License, Version 2.0 (the "License"); you may
            }
    private Path[] nodePaths;
                PersistedClusterStateService.Writer writer = new PersistedClusterStateService(  
                cachePath = cachePath.resolve(INDEX.getUUID());  
            final String nodeId = randomAlphaOfLength(10);
        );  
    }
        dataClusterManagerSettings = buildEnvSettings(Settings.EMPTY);
        // environment.dataFiles().length * shardCount will account for the local shard files
        );  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;  
        );
        verifyNoQuestions(noDataNoClusterManagerSettings, containsString(NO_DATA_TO_CLEAN_UP_FOUND));
import static org.opensearch.env.NodeRepurposeCommand.NO_CLEANUP;
 */  
        withTerminal(verbose, outputMatcher, terminal -> {
        expectThrows(IllegalStateException.class, () -> new NodeEnvironment(noDataClusterManagerSettings, environment).close());
                );
 *
        dataWarmNoClusterManagerSettings = nonClusterManagerNode(dataWarmClusterManagerSettings);
        if (randomBoolean()) {
        verifyNoQuestions(dataWarmNoClusterManagerSettings, containsString(NO_CLEANUP));  
 * Licensed to Elasticsearch under one or more contributor  
            conditionalNot(containsString("testIndex"), verbose == false || hasClusterState == false),
 * this file be licensed under the Apache-2.0 license or a
        boolean verbose = randomBoolean();  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
        int shardCount = randomIntBetween(1, 10);
        try (
            containsString(messageText),  
        boolean hasClusterState = randomBoolean();
    static <T> Matcher<T> conditionalNot(Matcher<T> matcher, boolean condition) {  
    }  
                    shardDataDirNumber += randomIntBetween(1, 10);  
            conditionalNot(containsString("no name for uuid: testUUID"), verbose == false || hasClusterState)
            if (writeClusterState) {
        try (NodeEnvironment env = new NodeEnvironment(settings, environment)) {
        verifyUnchangedOnAbort(noDataNoClusterManagerSettings, outputMatcher, verbose);
    }
            containsString(messageText),  
    public void testNothingToCleanup() throws Exception {  
    private Settings noDataClusterManagerSettings;
import static org.hamcrest.Matchers.allOf;  
        verifyNoQuestions(noDataClusterManagerSettings, containsString(NO_SHARD_DATA_TO_CLEAN_UP_FOUND));  
import static org.opensearch.env.NodeRepurposeCommand.NO_FILE_CACHE_DATA_TO_CLEAN_UP_FOUND;  
        // verify cleaned.  
            NodeEnvironment env = new NodeEnvironment(  
        }
        boolean hasClusterState = randomBoolean();
        boolean hasClusterState = randomBoolean();
import org.junit.Before;
        int shardCount = randomIntBetween(1, 10);
                }
        );
        assertEquals("Must not touch files", before, after);  
