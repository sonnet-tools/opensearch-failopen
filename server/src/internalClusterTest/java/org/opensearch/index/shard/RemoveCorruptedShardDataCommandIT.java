                primaryNodeId = cursor.getKey();
        final Path indexDir = getPathToShardData(indexName, ShardPath.INDEX_FOLDER_NAME);
 *
        waitNoPendingTasksOnAll();
        }
                );
        assertThat(terminal.getOutput(), containsString("\"node\" : \"" + primaryNodeId + "\""));
        for (int i = 0; i < builders.length; i++) {
            )
                break;
        assertBusy(() -> {
                .getExplanation()
                    command.execute(terminal, options, environment);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        int numDocs = 0;
        // the replica translog was disabled so it doesn't know what hte global checkpoint is and thus can't do ops based recovery
import org.opensearch.cluster.routing.ShardRoutingState;
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
import java.util.Set;
        final String node1 = internalCluster().startDataOnlyNode();
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        }
        if (randomBoolean() && numDocsToTruncate > 0) {
                return super.onNodeStopped(nodeName);
            client().admin()
    }
            }
                .setPrimary(true)
        ensureGreen(indexName);
import static org.hamcrest.Matchers.greaterThan;
            .filter(recoveryState -> recoveryState.getPrimary() == false)
                state,
        logger.info("--> starting the replica node to test recovery");
                final Environment environment = TestEnvironment.newEnvironment(
        internalCluster().startNodes(2);
        final Path indexDir = getPathToShardData(indexName, ShardPath.INDEX_FOLDER_NAME);
            assertHitCount(q.get(), numDocsToKeep);
        assertTrue(shardRouting.assignedToNode());
            prepareCreate(indexName).setSettings(
        assertAcked(
                    .resolve(NodeEnvironment.INDICES_FOLDER)
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocsToKeep];
        // having no extra docs is an interesting case for seq no based recoveries - test it more often
                .setShard(0)
                    .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "-1")
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
    /** Disables translog flushing for the specified index */
        });
                .getExplanation();
        internalCluster().startClusterManagerOnlyNode();
import java.util.regex.Pattern;
                logger.info("--> corrupting translog on node {}", nodeName);
        );
        );
                terminal.addTextInput("y");
import org.opensearch.action.admin.cluster.allocation.ClusterAllocationExplanation;
                        throw new AssertionError("unexpected IOException [" + indexDir + "]", ioe);
                allOf(containsString("failed to lock node's directory"), containsString("is OpenSearch still running?"))
        assertBusy(() -> {
        for (String node : internalCluster().nodesInclude(indexName)) {
                client().prepareSearch(indexName).setPreference("_only_nodes:" + node).setQuery(matchAllQuery()).get(),
import static org.hamcrest.Matchers.hasSize;
        builders = new IndexRequestBuilder[numDocsToTruncate];
import java.util.Map;
import java.io.IOException;
import org.opensearch.cluster.node.DiscoveryNodes;
        internalCluster().stopRandomDataNode();
        ClusterState state = client().admin().cluster().prepareState().get().getState();
import java.util.Collection;
 */
        ShardId shardId = shardRouting.shardId();
import org.opensearch.index.translog.TranslogCorruptedException;
        final SeqNoStats seqNoStats = getSeqNoStats(indexName, 0);
            .filter(recoveryState -> recoveryState.getPrimary() == false)
    @Override
        assertHitCount(client().prepareSearch(indexName).setQuery(matchAllQuery()).get(), numDocsToKeep);
        internalCluster().restartNode(node1, new InternalTestCluster.RestartCallback() {
                .setIndex(indexName)
            );
import org.opensearch.env.TestEnvironment;
            .findFirst()
            Settings.builder().put(internalCluster().getDefaultSettings()).put(node2PathSettings).build()
import org.opensearch.action.admin.indices.flush.FlushRequest;
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // Corrupt the translog file(s) on the replica
        });
            )
            assertThat(shardAllocationDecision.isDecisionTaken(), equalTo(true));
        String nodeId = null;
import java.util.stream.Stream;
        );
        final int totalDocs = numDocsToKeep + numDocsToTruncate;
import org.opensearch.cluster.node.DiscoveryNode;
        final SeqNoStats seqNoStats = getSeqNoStats(indexName, 0);
        assertBusy(() -> {
        ensureGreen();
                    }
            .get();
        int numDocsToKeep = randomIntBetween(10, 100);
        // Index some documents
import org.apache.lucene.store.LockObtainFailedException;
            final ShardAllocationDecision shardAllocationDecision = explanation.getShardAllocationDecision();
        return shardStats[shardId].getSeqNoStats();
        ensureGreen();
        assertBusy(() -> {
                    Settings.builder().put(internalCluster().getDefaultSettings()).put(node1PathSettings).build()
        final RecoveryState replicaRecoveryState = recoveryResponse.shardRecoveryStates()
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.index.Index;
        // Run a search and make sure it succeeds
            IndexShard replica = internalCluster().getInstance(IndicesService.class, node2).getShardOrNull(new ShardId(index, 0));
                .prepareUpdateSettings(indexName)
                OptionSet options = parser.parse("-d", translogDir.toAbsolutePath().toString());
                .indices()
        String primaryNodeId = null;
        disableTranslogFlush(indexName);
import org.apache.lucene.store.Directory;
import static org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest.Metric.FS;
            builders[i] = client().prepareIndex(indexName).setSource("foo", "bar");
 */
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
                .get()
                try {
        indexRandom(false, false, false, Arrays.asList(builders));
        final ShardRouting shardRouting = iterators.iterator().next().nextOrNull();
                .prepareAllocationExplain()
import org.opensearch.test.OpenSearchIntegTestCase;
        // index some docs in several segments
                .prepareAllocationExplain()
            .map(
            assertThat(
import org.opensearch.cli.MockTerminal;
                    .put(MockEngineSupport.DISABLE_FLUSH_ON_CLOSE.getKey(), true) // never flush - always recover from translog
        for (final Map.Entry<String, DiscoveryNode> cursor : nodes.getNodes().entrySet()) {
                .get()
                CorruptionUtils.corruptIndex(random(), indexDir, false);
            prepareCreate(indexName).setSettings(
        for (final Map.Entry<String, DiscoveryNode> cursor : nodes.getNodes().entrySet()) {
                Settings.builder()
        final RecoveryState replicaRecoveryState = recoveryResponse.shardRecoveryStates()
                .prepareAllocationExplain()
        assertNotNull(shardRouting);
import java.util.Arrays;
                    ) {} catch (LockObtainFailedException lofe) {
import java.nio.file.Files;
            final String name = cursor.getValue().getName();
                .setIndex(indexName)
            numDocs += numExtraDocs;
                command.execute(terminal, options, environment);
                    .put("index.routing.allocation.exclude._name", node2)
            builders[i] = client().prepareIndex(indexName).setSource("foo", "bar");
import static org.hamcrest.Matchers.containsString;
        // Restart the single node
        final Pattern pattern = Pattern.compile("Corrupted Lucene index segments found -\\s+(?<docs>\\d+) documents will be lost.");
import org.opensearch.ExceptionsHelper;
        final MockTerminal terminal = new MockTerminal();
                    .map(path -> NodeEnvironment.resolveNodePath(path, 0))
                nodePath -> PathUtils.get(nodePath.getPath())
                } catch (Exception e) {
        final DiscoveryNodes nodes = state.nodes();
        final Settings node1PathSettings = internalCluster().dataPathSettings(node1);
                .indices()
                0,
        assertThat(nodeId, notNullValue());
import org.opensearch.test.engine.MockEngineSupport;
    private Path getPathToShardData(String indexName, String dirSuffix) {
            logger.info(" -- stopped {}", nodeName);
                // Try running it before the shard is corrupted, it should flip out because there is no corruption file marker
        final RecoveryResponse recoveryResponse = client().admin().indices().prepareRecoveries(indexName).setActiveOnly(false).get();
        final DiscoveryNodes nodes = state.nodes();
                environmentByNodeName.get(nodeName),
        final OptionParser parser = command.getParser();
                .setIndex(indexName)
        MockTerminal terminal = new MockTerminal();
            );
        });
        internalCluster().stopRandomDataNode();
        logger.info("--> starting the replica node to test recovery");
        final MockTerminal terminal = new MockTerminal();
 */
                shardPath -> assertThat(shardPath.resolveIndex(), equalTo(indexPath))
import joptsimple.OptionParser;
                .setShard(0)
    }
            .get();
    private SeqNoStats getSeqNoStats(String index, int shardId) {
                Stream.of(environmentByNodeName.get(nodeName).dataFiles())
        String nodeId = shardRouting.currentNodeId();
        assertAcked(
            assertThat(ExceptionsHelper.unwrap(unassignedInfo.getFailure(), TranslogCorruptedException.class), not(nullValue()));
        assertAcked(
                    assertThat(e.getMessage(), startsWith("Shard does not seem to be corrupted at"));
                    .resolve(shardPathSubdirectory)
        }
import org.opensearch.index.MergePolicyProvider;
        ensureYellow();
        }
                        Lock ignored = dir.obtainLock(IndexWriter.WRITE_LOCK_NAME)
                    fail("expected the command to fail as there is no corruption file marker");
        );
            );
        // check replica corruption
        disableTranslogFlush(indexName);
            if (name.equals(node)) {
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numOfNodes - 1)
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
 * The OpenSearch Contributors require contributions made to
        final Path translogDir = getPathToShardData(node2, shardId, ShardPath.TRANSLOG_FOLDER_NAME);
            .build();
 * software distributed under the License is distributed on an
                .setPrimary(true)
                terminal.addTextInput("y");
            assertThat(
        }
        // all shards should be failed due to a corrupted translog
            assertThat(
            .get(indexName)
    public static Path getPathToShardData(String nodeId, ShardId shardId, String shardPathSubdirectory) {
        for (String nodeName : nodeNames) {
                .cluster()
            nodeNameToNodeId.put(cursor.getValue().getName(), cursor.getKey());
import org.apache.lucene.store.NativeFSLockFactory;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                    .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "-1")
    }
import org.opensearch.cluster.metadata.IndexMetadata;
                .cluster()
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertThat(primaryNodeId, notNullValue());
            builders[i] = client().prepareIndex(indexName).setSource("foo", "bar");
import org.opensearch.plugins.Plugin;
        });
        flush(indexName);
        final String node = internalCluster().startNode();
/*
            );
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
                shardAllocationDecision.getAllocateDecision().getAllocationDecision(),
        assertAcked(
            final ClusterAllocationExplanation explanation = client().admin()
import java.nio.file.Path;
/*
            public Settings onNodeStopped(String nodeName) throws Exception {
            final String name = cursor.getValue().getName();
 *
                .setIndex(indexName)
        logger.info("--> nodes name: {}, {}", node1, node2);
            assertThat(explanation.getCurrentNode(), notNullValue());
                    // noinspection EmptyTryBlock since we're just trying to obtain the lock
        assertHitCount(client().prepareSearch(indexName).setQuery(matchAllQuery()).get(), totalDocs);
            );
                Settings.builder()
import java.util.List;
        assertThat(terminal.getOutput(), containsString("\"node\" : \"" + nodeId + "\""));
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        final Environment environment = TestEnvironment.newEnvironment(
                .setPrimary(true)
import org.opensearch.cluster.routing.allocation.ShardAllocationDecision;
        );
                shardAllocationDecision.getAllocateDecision().getAllocationDecision(),
        });
            .stream()
        final Settings nodePathSettings = internalCluster().dataPathSettings(node);
            command.execute(terminal, options, environment);
        return getPathToShardData(nodeId, shardId, dirSuffix);
        client().admin().cluster().prepareReroute().add(new AllocateStalePrimaryAllocationCommand(indexName, 0, primaryNodeId, true)).get();
            flush(indexName);
import org.opensearch.env.Environment;
        // Try running it before the node is stopped (and shard is closed)
        final DiscoveryNodes nodes = state.nodes();
        final Map<String, Path> indexPathByNodeName = new HashMap<>();
                .cluster()
import org.opensearch.action.search.SearchRequestBuilder;
import java.util.stream.Collectors;
            Settings.builder().put(internalCluster().getDefaultSettings()).put(nodePathSettings).build()
                        throw new AssertionError("still waiting for lock release at [" + indexDir + "]", lofe);
    }
        }
import org.opensearch.index.IndexSettings;
 * compatible open source license.
                .cluster()
        final RecoveryResponse recoveryResponse = client().admin().indices().prepareRecoveries(indexName).setActiveOnly(false).get();
        } catch (Exception e) {
import org.opensearch.env.NodeEnvironment;
 * the Apache License, Version 2.0 (the "License"); you may
                    try (
        );
            .collect(Collectors.toSet());
                    .put("index.routing.allocation.exclude._name", node2)
        // Start the node with the non-corrupted data path
        logger.info("--> corrupting translog");
        final String node1 = internalCluster().getNodeNames()[0];
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertTrue(shardRouting.primary());
        assertThat(replicaRecoveryState.getIndex().toString(), replicaRecoveryState.getIndex().recoveredFileCount(), greaterThan(0));
        });
                    .put(MockEngineSupport.DISABLE_FLUSH_ON_CLOSE.getKey(), true)
        internalCluster().restartNode(node, new InternalTestCluster.RestartCallback() {
        }
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(1, ByteSizeUnit.PB))
                    .put(IndexSettings.INDEX_CHECK_ON_STARTUP.getKey(), "checksum")
        assertBusy(() -> {
        assertThat(replicaRecoveryState.getIndex().toString(), replicaRecoveryState.getIndex().recoveredFileCount(), greaterThan(0));
                .setPrimary(true)
            prepareCreate(indexName).setSettings(
                        Directory dir = FSDirectory.open(indexDir, NativeFSLockFactory.INSTANCE);
        final OptionParser parser = command.getParser();
        logger.info("--> indexed {} docs", numDocs);
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        logger.info("--> indexing [{}] more doc to be truncated", numDocsToTruncate);
                .setIndex(indexName)
                .get()
        );
        final Map<String, String> nodeNameToNodeId = new HashMap<>();
            }
    public void testResolvePath() throws Exception {
            @Override
        assertThat(seqNoStats.getLocalCheckpoint(), equalTo(seqNoStats.getMaxSeqNo()));
            .findFirst()
public class RemoveCorruptedShardDataCommandIT extends OpenSearchIntegTestCase {
import org.opensearch.test.transport.MockTransportService;
        final Matcher matcher = pattern.matcher(terminal.getOutput());
import java.util.stream.StreamSupport;
package org.opensearch.index.shard;
            final ClusterAllocationExplanation explanation = client().admin()
        final ShardStats[] shardStats = client().admin().indices().prepareStats(index).get().getIndices().get(index).getShards();
        // there is only _stale_ primary (due to new allocation id)
        ensureGreen(indexName);
        assertThat(seqNoStats.getGlobalCheckpoint(), equalTo(seqNoStats.getMaxSeqNo()));
        ensureYellow();
        assertThat(shardRouting, notNullValue());
        final String indexName = "test";
/*
        internalCluster().startNode(node2PathSettings);
            Index index = resolveIndex(indexName);
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.gateway.GatewayMetaState;
        // stop data nodes
    private static void disableTranslogFlush(String index) {
import org.opensearch.test.InternalSettingsPlugin;
        final NodesStatsResponse nodeStatsResponse = client().admin().cluster().prepareNodesStats(nodeId).addMetric(FS.metricName()).get();
        logger.info("--> output:\n{}", terminal.getOutput());
            // flush the replica, so it will have more docs than what the primary will have
            final UnassignedInfo unassignedInfo = client().admin()
                .prepareAllocationExplain()
                .setPrimary(true)
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            command.findAndProcessShardPath(
import org.opensearch.index.seqno.SeqNoStats;
        );
import org.opensearch.core.common.unit.ByteSizeValue;
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(node2));
            public Settings onNodeStopped(String nodeName) throws Exception {
        ensureGreen(indexName);
        int numDocsToKeep = randomIntBetween(0, 100);
            if (name.equals(node1)) {
        final String indexName = "index42";
        internalCluster().startNode(node2PathSettings);
                logger.info("--> output:\n{}", terminal.getOutput());
import static org.hamcrest.Matchers.startsWith;
    }
            indexRandom(false, false, false, Arrays.asList(builders));
        Settings settings = Settings.builder()
        internalCluster().startNode(node1PathSettings);
                    .put(MergePolicyProvider.INDEX_MERGE_ENABLED, false)
        final List<String> nodeNames = internalCluster().startNodes(numOfNodes, Settings.EMPTY);
        for (int i = 0; i < builders.length; i++) {
            final ShardAllocationDecision shardAllocationDecision = explanation.getShardAllocationDecision();
        final String indexName = "test" + randomInt(100);
import org.opensearch.cluster.routing.allocation.AllocationDecision;
                    logger.info("--> checking that lock has been released for {}", indexDir);
            assertThat(explanation.getCurrentNode(), notNullValue());
import org.opensearch.action.index.IndexRequestBuilder;
import org.opensearch.cluster.routing.UnassignedInfo;
import org.opensearch.core.common.unit.ByteSizeUnit;
        });
import org.apache.lucene.store.Lock;
import org.opensearch.cluster.routing.allocation.command.AllocateStalePrimaryAllocationCommand;
                logger.info("--> running command for [{}]", translogDir.toAbsolutePath());
        builders = new IndexRequestBuilder[numDocsToTruncate];
        }
    }
        final List<ShardIterator> iterators = iterableAsArrayList(shardIterators);
                .prepareAllocationExplain()
        final Environment environment = TestEnvironment.newEnvironment(
import org.opensearch.common.settings.Settings;
            final ClusterAllocationExplanation explanation = client().admin()
            assertThat(unassignedInfo.getReason(), equalTo(UnassignedInfo.Reason.ALLOCATION_FAILED));
import org.apache.lucene.index.IndexWriter;
import org.opensearch.cluster.routing.GroupShardsIterator;
import joptsimple.OptionSet;
            assertThat(explanation.getShardState(), equalTo(ShardRoutingState.STARTED));
        final RemoveCorruptedShardDataCommand command = new RemoveCorruptedShardDataCommand();
import org.opensearch.cluster.routing.ShardIterator;
 * You may obtain a copy of the License at
        assertBusy(
        final Path translogDir = getPathToShardData(indexName, ShardPath.TRANSLOG_FOLDER_NAME);
                });
        final int numOfNodes = randomIntBetween(1, 5);
import static org.hamcrest.Matchers.nullValue;
                .get()
import org.opensearch.core.index.shard.ShardId;
            final String nodeId = nodeNameToNodeId.get(nodeName);
                options,
        ShardRouting shardRouting = shardIterator.nextOrNull();
            )
                .prepareAllocationExplain()
                .setPrimary(true)
                break;
            .get(indexName)
            final Environment environment = TestEnvironment.newEnvironment(
                Settings.builder()
        final int expectedNumDocs = numDocs - Integer.parseInt(matcher.group("docs"));
            IndexRequestBuilder[] builders = new IndexRequestBuilder[numExtraDocs];
 * GitHub history for details.
        GroupShardsIterator shardIterators = state.getRoutingTable().activePrimaryShardsGrouped(new String[] { indexName }, false);
        // Ensure that the global checkpoint and local checkpoint are restored from the max seqno of the last commit.
                equalTo(AllocationDecision.NO_VALID_SHARD_COPY)
        final String indexName = "test";
 * not use this file except in compliance with the License.
        final Settings node2PathSettings = internalCluster().dataPathSettings(node2);
                .getExplanation();
                shardAllocationDecision.getAllocateDecision().getAllocationDecision(),
                .setSettings(Settings.builder().put("index.routing.allocation.exclude._name", (String) null))
        final ShardId shardId = shardRouting.shardId();
            final ClusterAllocationExplanation explanation = client().admin()
import org.opensearch.indices.recovery.RecoveryState;
        final OptionSet options = parser.parse("-index", indexName, "-shard-id", "0");
import org.opensearch.index.translog.TestTranslog;
        for (int k = 0, attempts = randomIntBetween(5, 10); k < attempts; k++) {
            assertThat(shardAllocationDecision.isDecisionTaken(), equalTo(true));
                Settings.builder().put(internalCluster().getDefaultSettings()).put(internalCluster().dataPathSettings(nodeName)).build()
                TestTranslog.corruptRandomTranslogFile(logger, random(), translogDir);
                .getExplanation();
        final Map<String, Environment> environmentByNodeName = new HashMap<>();
                    .resolve(Integer.toString(shardId.getId()))
        int numDocsToTruncate = randomBoolean() ? 0 : randomIntBetween(0, 100);
            public Settings onNodeStopped(String nodeName) throws Exception {
import org.opensearch.indices.IndicesService;
                .get()
        for (String nodeName : nodeNames) {
    }
                .setIndex(indexName)
        try {
                Settings.builder()
            )
import org.opensearch.test.InternalTestCluster;
        return paths.iterator().next();
        }
        terminal.addTextInput("y");
        }
        final Set<Path> paths = StreamSupport.stream(nodeStatsResponse.getNodes().get(0).getFs().spliterator(), false)
        RemoveCorruptedShardDataCommand command = new RemoveCorruptedShardDataCommand();
        for (int i = 0; i < builders.length; i++) {
            SearchRequestBuilder q = client().prepareSearch(indexName).setPreference("_only_nodes:" + node).setQuery(matchAllQuery());
        assertThat(terminal.getOutput(), containsString("allocate_stale_primary"));
        assertThat(seqNoStats.getLocalCheckpoint(), equalTo(seqNoStats.getMaxSeqNo()));
        TestTranslog.corruptRandomTranslogFile(logger, random(), translogDir);
        ensureGreen(indexName);
        logger.info("--> indexing [{}] docs to be kept", numDocsToKeep);
            replica.flush(new FlushRequest());
import org.opensearch.index.MockEngineFactoryPlugin;
        logger.info("--> output:\n{}", terminal.getOutput());
            client().admin()
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
                    .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "-1")
            final OptionSet options = parser.parse("--dir", indexPath.toAbsolutePath().toString());
            () -> internalCluster().getInstances(GatewayMetaState.class).forEach(gw -> assertTrue(gw.allPendingAsyncStatesWritten()))
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
            builders[i] = client().prepareIndex(indexName).setSource("foo", "bar");
 * Modifications Copyright OpenSearch Contributors. See
            )
        // Ensure that the global checkpoint and local checkpoint are restored from the max seqno of the last commit.
 * ownership. Elasticsearch licenses this file to you under
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeName));
        OptionSet options = parser.parse("-d", translogDir.toAbsolutePath().toString());
        for (final Map.Entry<String, DiscoveryNode> cursor : nodes.getNodes().entrySet()) {
        ShardIterator shardIterator = RandomPicks.randomFrom(random(), iterators);
                .get()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(matcher.find(), equalTo(true));
                .setShard(0)
        );
            assertThat(explanation.getShardState(), equalTo(ShardRoutingState.STARTED));
                equalTo(AllocationDecision.NO_VALID_SHARD_COPY)
        command.execute(terminal, options, environment);
            final int numExtraDocs = between(10, 100);
                return super.onNodeStopped(nodeName);
        indexRandom(false, false, false, Arrays.asList(builders));
                return super.onNodeStopped(nodeName);
                    } catch (IOException ioe) {
        for (String node : internalCluster().nodesInclude(indexName)) {
        }
            final ShardAllocationDecision shardAllocationDecision = explanation.getShardAllocationDecision();
    public void testCorruptIndex() throws Exception {
import org.opensearch.action.admin.indices.stats.ShardStats;
        final OptionParser parser = command.getParser();
        List<ShardIterator> iterators = iterableAsArrayList(shardIterators);
            .filter(Files::isDirectory)
        final String node2 = internalCluster().startDataOnlyNode();
        final Settings node2PathSettings = internalCluster().dataPathSettings(node2);
                .setSettings(Settings.builder().putNull("index.routing.allocation.exclude._name"))
                builders[i] = client().prepareIndex(indexName).setSource("foo", "bar");
        OptionParser parser = command.getParser();
            }
        }
        assertThat(terminal.getOutput(), containsString("allocate_stale_primary"));
        final RemoveCorruptedShardDataCommand command = new RemoveCorruptedShardDataCommand();
                .setShard(0)
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // Index some documents
        assertBusy(() -> {
                    .put(MockEngineSupport.DISABLE_FLUSH_ON_CLOSE.getKey(), true) // never flush - always recover from translog
            environmentByNodeName.put(nodeName, environment);
            }
        indexRandom(false, false, false, Arrays.asList(builders));
            }
            for (int i = 0; i < builders.length; i++) {
                .cluster()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.cluster.ClusterState;
            }
 * specific language governing permissions and limitations
 * under the License.
import org.opensearch.test.CorruptionUtils;
import org.apache.lucene.store.FSDirectory;
        internalCluster().restartNode(node, new InternalTestCluster.RestartCallback() {
        final GroupShardsIterator shardIterators = state.getRoutingTable().activePrimaryShardsGrouped(new String[] { indexName }, false);
                    .resolve(shardId.getIndex().getUUID())
                    .toArray(Path[]::new),
import java.util.HashMap;
        final Settings node1PathSettings = internalCluster().dataPathSettings(node1);
            .stream()
                        logger.info("--> failed acquiring lock for {}", indexDir);
        indexRandom(false, false, false, Arrays.asList(builders));
                }
 * Unless required by applicable law or agreed to in writing,
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocsToKeep];
            final Path indexPath = indexPathByNodeName.get(nodeName);
        flush(indexName);
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.common.io.PathUtils;
        // having no extra docs is an interesting case for seq no based recoveries - test it more often
                assertBusy(() -> {
            @Override
        logger.info("--> restarting node");
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.notNullValue;
        assertHitCount(client().prepareSearch(indexName).setQuery(matchAllQuery()).get(), expectedNumDocs);
        client().admin().indices().prepareUpdateSettings(index).setSettings(settings).get();
        });
        final ShardId shardId = new ShardId(resolveIndex(indexName), 0);
                .cluster()
            indexPathByNodeName.put(nodeName, getPathToShardData(nodeId, shardId, ShardPath.INDEX_FOLDER_NAME));
        // sample the replica node translog dirs
        assertAcked(
                return super.onNodeStopped(nodeName);
        for (int i = 0; i < builders.length; i++) {
                .setShard(0)
import static org.hamcrest.Matchers.not;
 * license agreements. See the NOTICE file distributed with
    public void testCorruptTranslogTruncation() throws Exception {
                totalDocs
        ensureYellow();
    }
            assertHitCount(
                .getUnassignedInfo();
        }
                equalTo(AllocationDecision.NO_VALID_SHARD_COPY)
                e.getMessage(),
        assertThat(paths, hasSize(1));
            fail("expected the command to fail as node is locked");
        logger.info("--> running command for [{}]", translogDir.toAbsolutePath());
        final String node2 = internalCluster().getNodeNames()[1];
        assertThat(seqNoStats.getGlobalCheckpoint(), equalTo(seqNoStats.getMaxSeqNo()));
            @Override
        logger.info("--> indexing [{}] docs to be kept", numDocsToKeep);
        // have to shut down primary node - otherwise node lock is present
            prepareCreate(indexName).setSettings(
        flush(indexName);
 *
        });
}
import java.util.regex.Matcher;
        ensureYellow(indexName);
                .getExplanation();
        // shard should be failed due to a corrupted index
        final RemoveCorruptedShardDataCommand command = new RemoveCorruptedShardDataCommand();
            assertThat(
    }
            );
        }
            final ClusterAllocationExplanation explanation = client().admin()
            logger.info("--> performed extra flushing on replica");
 * Licensed to Elasticsearch under one or more contributor
 * this work for additional information regarding copyright
import static org.opensearch.core.common.util.CollectionUtils.iterableAsArrayList;
        client().admin().cluster().prepareReroute().add(new AllocateStalePrimaryAllocationCommand(indexName, 0, nodeId, true)).get();
            assertThat(shardAllocationDecision.isDecisionTaken(), equalTo(true));
        });
        assertAcked(
                command.execute(terminal, options, environment);
            );
        logger.info("--> indexing [{}] more docs to be truncated", numDocsToTruncate);
            public Settings onNodeStopped(String nodeName) throws Exception {
                .prepareUpdateSettings(indexName)
    public void testCorruptTranslogTruncationOfReplica() throws Exception {
        int numDocsToTruncate = randomBoolean() ? 0 : randomIntBetween(0, 100);
                .getExplanation();
            }
import static org.hamcrest.Matchers.allOf;
        return Arrays.asList(MockTransportService.TestPlugin.class, MockEngineFactoryPlugin.class, InternalSettingsPlugin.class);
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
        // shut down the replica node to be tested later
        // there is only _stale_ primary (due to new allocation id)
        // Run a search and make sure it succeeds
                .setShard(0)
                nodeId = cursor.getKey();
        logger.info("--> starting node");
            @Override
