                options,
 * not use this file except in compliance with the License.
        });  
        });
            .stream()
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeName));  
 * KIND, either express or implied.  See the License for the
            .build();  
                Settings.builder()  
                .get()
        return paths.iterator().next();
import org.apache.lucene.store.LockObtainFailedException;
            );
        assertThat(paths, hasSize(1));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                .setIndex(indexName)
import org.opensearch.plugins.Plugin;
        client().admin().cluster().prepareReroute().add(new AllocateStalePrimaryAllocationCommand(indexName, 0, primaryNodeId, true)).get();
/*  
        assertAcked(
    }
                    .map(path -> NodeEnvironment.resolveNodePath(path, 0))
                    .put(MockEngineSupport.DISABLE_FLUSH_ON_CLOSE.getKey(), true) // never flush - always recover from translog  
                .setIndex(indexName)
        for (int i = 0; i < builders.length; i++) {  
            final ShardAllocationDecision shardAllocationDecision = explanation.getShardAllocationDecision();
                    .toArray(Path[]::new),  
        ensureYellow(indexName);
                .getExplanation();
import static org.hamcrest.Matchers.notNullValue;
                try {  
                .setSettings(Settings.builder().putNull("index.routing.allocation.exclude._name"))
import org.opensearch.core.common.unit.ByteSizeUnit;  
        final SeqNoStats seqNoStats = getSeqNoStats(indexName, 0);  
            flush(indexName);  
        ensureGreen(indexName);
        final List<String> nodeNames = internalCluster().startNodes(numOfNodes, Settings.EMPTY);
import org.opensearch.indices.recovery.RecoveryState;  
                    .resolve(shardPathSubdirectory)  
        final Settings node1PathSettings = internalCluster().dataPathSettings(node1);
        disableTranslogFlush(indexName);
            builders[i] = client().prepareIndex(indexName).setSource("foo", "bar");
        final Map<String, Path> indexPathByNodeName = new HashMap<>();
        indexRandom(false, false, false, Arrays.asList(builders));
            assertThat(explanation.getShardState(), equalTo(ShardRoutingState.STARTED));
                    .put(MockEngineSupport.DISABLE_FLUSH_ON_CLOSE.getKey(), true)
        final OptionSet options = parser.parse("-index", indexName, "-shard-id", "0");
        final String indexName = "test" + randomInt(100);  
            final String name = cursor.getValue().getName();
        final Settings node2PathSettings = internalCluster().dataPathSettings(node2);  
                terminal.addTextInput("y");
            .findFirst()
        final String indexName = "index42";
        assertTrue(shardRouting.assignedToNode());
                .indices()
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        flush(indexName);
import java.util.stream.StreamSupport;
            .get(indexName)
            @Override  
        assertThat(replicaRecoveryState.getIndex().toString(), replicaRecoveryState.getIndex().recoveredFileCount(), greaterThan(0));
        logger.info("--> indexed {} docs", numDocs);  
                    .put("index.routing.allocation.exclude._name", node2)
                .setIndex(indexName)
                .setIndex(indexName)  
        }  
        final Path indexDir = getPathToShardData(indexName, ShardPath.INDEX_FOLDER_NAME);  
            final UnassignedInfo unassignedInfo = client().admin()  
        // Try running it before the node is stopped (and shard is closed)
                environmentByNodeName.get(nodeName),  
        final String node2 = internalCluster().startDataOnlyNode();
        for (final Map.Entry<String, DiscoveryNode> cursor : nodes.getNodes().entrySet()) {
        int numDocsToKeep = randomIntBetween(0, 100);  
import org.opensearch.test.OpenSearchIntegTestCase;
            final ShardAllocationDecision shardAllocationDecision = explanation.getShardAllocationDecision();
        for (int i = 0; i < builders.length; i++) {
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.index.IndexRequestBuilder;
            nodeNameToNodeId.put(cursor.getValue().getName(), cursor.getKey());
                .getExplanation();  
import java.util.Set;
import org.opensearch.core.index.Index;
        ShardId shardId = shardRouting.shardId();  
        final ShardRouting shardRouting = iterators.iterator().next().nextOrNull();  
                Stream.of(environmentByNodeName.get(nodeName).dataFiles())
        logger.info("--> restarting node");  
        GroupShardsIterator shardIterators = state.getRoutingTable().activePrimaryShardsGrouped(new String[] { indexName }, false);
            assertThat(explanation.getShardState(), equalTo(ShardRoutingState.STARTED));
        assertThat(shardRouting, notNullValue());
        final MockTerminal terminal = new MockTerminal();
                .cluster()
        }
        client().admin().cluster().prepareReroute().add(new AllocateStalePrimaryAllocationCommand(indexName, 0, nodeId, true)).get();
        // all shards should be failed due to a corrupted translog
        client().admin().indices().prepareUpdateSettings(index).setSettings(settings).get();
        final String node = internalCluster().startNode();  
import static org.hamcrest.Matchers.allOf;
            SearchRequestBuilder q = client().prepareSearch(indexName).setPreference("_only_nodes:" + node).setQuery(matchAllQuery());
            );
import org.opensearch.test.InternalSettingsPlugin;  
        final ShardId shardId = new ShardId(resolveIndex(indexName), 0);
import org.opensearch.action.admin.indices.stats.ShardStats;  
        assertThat(seqNoStats.getGlobalCheckpoint(), equalTo(seqNoStats.getMaxSeqNo()));
        assertThat(primaryNodeId, notNullValue());
        assertThat(seqNoStats.getGlobalCheckpoint(), equalTo(seqNoStats.getMaxSeqNo()));  
import org.opensearch.cluster.node.DiscoveryNode;  
        // Run a search and make sure it succeeds
                    .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "-1")  
                shardAllocationDecision.getAllocateDecision().getAllocationDecision(),
        final OptionParser parser = command.getParser();
import org.apache.lucene.store.Directory;
                .setPrimary(true)
            builders[i] = client().prepareIndex(indexName).setSource("foo", "bar");
                    command.execute(terminal, options, environment);
/*
                    fail("expected the command to fail as there is no corruption file marker");
                    } catch (IOException ioe) {
        assertBusy(() -> {  
        // shut down the replica node to be tested later
    public void testResolvePath() throws Exception {
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;  
        final String indexName = "test";  
            public Settings onNodeStopped(String nodeName) throws Exception {
        final Matcher matcher = pattern.matcher(terminal.getOutput());  
                assertBusy(() -> {
        }
            final int numExtraDocs = between(10, 100);  
        RemoveCorruptedShardDataCommand command = new RemoveCorruptedShardDataCommand();
 *
 */  
        ShardIterator shardIterator = RandomPicks.randomFrom(random(), iterators);  
        final OptionParser parser = command.getParser();
import org.opensearch.index.seqno.SeqNoStats;
                logger.info("--> output:\n{}", terminal.getOutput());  
        final ShardId shardId = shardRouting.shardId();
        for (int i = 0; i < builders.length; i++) {  
import java.util.regex.Pattern;
            );
import org.opensearch.gateway.GatewayMetaState;
        assertThat(seqNoStats.getLocalCheckpoint(), equalTo(seqNoStats.getMaxSeqNo()));
            // flush the replica, so it will have more docs than what the primary will have
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(1, ByteSizeUnit.PB))
            for (int i = 0; i < builders.length; i++) {
        final int expectedNumDocs = numDocs - Integer.parseInt(matcher.group("docs"));
import org.opensearch.cluster.routing.allocation.ShardAllocationDecision;
            final String nodeId = nodeNameToNodeId.get(nodeName);
import org.opensearch.test.engine.MockEngineSupport;  
        }
import java.io.IOException;  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                return super.onNodeStopped(nodeName);  
        ensureGreen();  
 */
        for (String node : internalCluster().nodesInclude(indexName)) {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
                equalTo(AllocationDecision.NO_VALID_SHARD_COPY)  
        final Settings node2PathSettings = internalCluster().dataPathSettings(node2);  
            final ClusterAllocationExplanation explanation = client().admin()
        }  
            assertThat(  
        // Index some documents
        builders = new IndexRequestBuilder[numDocsToTruncate];  
        OptionParser parser = command.getParser();
import org.opensearch.cluster.ClusterState;
        final DiscoveryNodes nodes = state.nodes();
                .getExplanation();  
            client().admin()
        indexRandom(false, false, false, Arrays.asList(builders));  
                Settings.builder().put(internalCluster().getDefaultSettings()).put(internalCluster().dataPathSettings(nodeName)).build()
                logger.info("--> running command for [{}]", translogDir.toAbsolutePath());
        for (final Map.Entry<String, DiscoveryNode> cursor : nodes.getNodes().entrySet()) {  
        );
 * GitHub history for details.
                shardPath -> assertThat(shardPath.resolveIndex(), equalTo(indexPath))  
 * Unless required by applicable law or agreed to in writing,
            final ClusterAllocationExplanation explanation = client().admin()
                .get()
        // Index some documents  
        ensureGreen(indexName);  
import java.util.List;  
        }  
                    .put(MockEngineSupport.DISABLE_FLUSH_ON_CLOSE.getKey(), true) // never flush - always recover from translog
    public void testCorruptTranslogTruncationOfReplica() throws Exception {
        waitNoPendingTasksOnAll();
import java.util.Arrays;  
 * this work for additional information regarding copyright
            .findFirst()
        assertThat(terminal.getOutput(), containsString("\"node\" : \"" + nodeId + "\""));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            );  
        flush(indexName);
        );
        try {
        final Environment environment = TestEnvironment.newEnvironment(
            final ShardAllocationDecision shardAllocationDecision = explanation.getShardAllocationDecision();
 * compatible open source license.
        internalCluster().startNodes(2);
    public static Path getPathToShardData(String nodeId, ShardId shardId, String shardPathSubdirectory) {
            .stream()
        }
        final Environment environment = TestEnvironment.newEnvironment(
        builders = new IndexRequestBuilder[numDocsToTruncate];
                    .resolve(shardId.getIndex().getUUID())
            assertThat(shardAllocationDecision.isDecisionTaken(), equalTo(true));  
            prepareCreate(indexName).setSettings(
            assertThat(
        Settings settings = Settings.builder()
        if (randomBoolean() && numDocsToTruncate > 0) {  
 * under the License.  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                .prepareAllocationExplain()
    private SeqNoStats getSeqNoStats(String index, int shardId) {
import org.opensearch.common.io.PathUtils;
            }  
        final RecoveryResponse recoveryResponse = client().admin().indices().prepareRecoveries(indexName).setActiveOnly(false).get();
/*
        assertAcked(  
        for (int i = 0; i < builders.length; i++) {
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;  
        final Settings node1PathSettings = internalCluster().dataPathSettings(node1);
        ShardRouting shardRouting = shardIterator.nextOrNull();
            assertHitCount(
 * ownership. Elasticsearch licenses this file to you under  
        // index some docs in several segments  
            builders[i] = client().prepareIndex(indexName).setSource("foo", "bar");
                .get()
                }
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
            @Override  
                .prepareAllocationExplain()
        });  
        indexRandom(false, false, false, Arrays.asList(builders));  
 * SPDX-License-Identifier: Apache-2.0
                .getExplanation()
        internalCluster().startNode(node2PathSettings);
        assertThat(terminal.getOutput(), containsString("allocate_stale_primary"));  
                        throw new AssertionError("unexpected IOException [" + indexDir + "]", ioe);  
        });
import org.opensearch.core.index.shard.ShardId;  
                .setSettings(Settings.builder().put("index.routing.allocation.exclude._name", (String) null))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testCorruptTranslogTruncation() throws Exception {  
import joptsimple.OptionParser;
        assertThat(seqNoStats.getLocalCheckpoint(), equalTo(seqNoStats.getMaxSeqNo()));
        // Restart the single node
                .prepareUpdateSettings(indexName)
        // Ensure that the global checkpoint and local checkpoint are restored from the max seqno of the last commit.
                    Settings.builder().put(internalCluster().getDefaultSettings()).put(node1PathSettings).build()
                .setPrimary(true)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                .cluster()  
        // Run a search and make sure it succeeds
                .setShard(0)
import org.opensearch.indices.IndicesService;
                    // noinspection EmptyTryBlock since we're just trying to obtain the lock
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(node2));  
        logger.info("--> indexing [{}] more doc to be truncated", numDocsToTruncate);
                .setShard(0)
        internalCluster().restartNode(node, new InternalTestCluster.RestartCallback() {
                OptionSet options = parser.parse("-d", translogDir.toAbsolutePath().toString());  
    /** Disables translog flushing for the specified index */
        internalCluster().restartNode(node, new InternalTestCluster.RestartCallback() {
            client().admin()
            @Override
        int numDocsToTruncate = randomBoolean() ? 0 : randomIntBetween(0, 100);
        assertAcked(  
        internalCluster().startNode(node1PathSettings);
        final int numOfNodes = randomIntBetween(1, 5);  
        final OptionParser parser = command.getParser();
                .setPrimary(true)
                .indices()  
import org.opensearch.env.NodeEnvironment;
    }  
                    ) {} catch (LockObtainFailedException lofe) {
                .prepareAllocationExplain()
import static org.hamcrest.Matchers.startsWith;
import java.nio.file.Path;
        }
        ensureYellow();
                command.execute(terminal, options, environment);
                .setShard(0)  
import org.opensearch.cluster.routing.ShardIterator;  
                    logger.info("--> checking that lock has been released for {}", indexDir);  
        assertBusy(() -> {  
        // there is only _stale_ primary (due to new allocation id)  
            prepareCreate(indexName).setSettings(
        final MockTerminal terminal = new MockTerminal();  
        final String node1 = internalCluster().startDataOnlyNode();
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numOfNodes - 1)
            indexRandom(false, false, false, Arrays.asList(builders));
                final Environment environment = TestEnvironment.newEnvironment(
                totalDocs
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocsToKeep];
        // having no extra docs is an interesting case for seq no based recoveries - test it more often
        // stop data nodes  
        final DiscoveryNodes nodes = state.nodes();
        );
 *
import org.opensearch.index.IndexSettings;
        assertBusy(() -> {
        assertBusy(
        ensureGreen(indexName);
            logger.info("--> performed extra flushing on replica");
            assertThat(
import org.opensearch.index.translog.TestTranslog;  
import org.opensearch.test.CorruptionUtils;
        );  
    }
            assertThat(shardAllocationDecision.isDecisionTaken(), equalTo(true));  
import java.util.Collection;
import static org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest.Metric.FS;  
        return getPathToShardData(nodeId, shardId, dirSuffix);
        );  
        String nodeId = shardRouting.currentNodeId();
                nodePath -> PathUtils.get(nodePath.getPath())
                .getExplanation();
                .get()
                equalTo(AllocationDecision.NO_VALID_SHARD_COPY)  
        for (String nodeName : nodeNames) {  
                    try (
        // the replica translog was disabled so it doesn't know what hte global checkpoint is and thus can't do ops based recovery  
        );
                primaryNodeId = cursor.getKey();  
                .cluster()  
        assertAcked(  
import org.opensearch.action.admin.cluster.allocation.ClusterAllocationExplanation;
                .cluster()
                    .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "-1")
        });
                    .resolve(NodeEnvironment.INDICES_FOLDER)  
        logger.info("--> starting the replica node to test recovery");
        final Map<String, String> nodeNameToNodeId = new HashMap<>();  
 * the Apache License, Version 2.0 (the "License"); you may
 */
        logger.info("--> indexing [{}] docs to be kept", numDocsToKeep);
        String nodeId = null;
        final DiscoveryNodes nodes = state.nodes();  
                terminal.addTextInput("y");
        final List<ShardIterator> iterators = iterableAsArrayList(shardIterators);
    private Path getPathToShardData(String indexName, String dirSuffix) {
        }  
                .get()  
                equalTo(AllocationDecision.NO_VALID_SHARD_COPY)  
import org.apache.lucene.store.FSDirectory;  
                .getExplanation();  
import org.opensearch.index.translog.TranslogCorruptedException;
                0,
                .prepareAllocationExplain()
import joptsimple.OptionSet;  
        MockTerminal terminal = new MockTerminal();  
import org.apache.lucene.store.Lock;
                    }
        ensureGreen(indexName);  
        final Set<Path> paths = StreamSupport.stream(nodeStatsResponse.getNodes().get(0).getFs().spliterator(), false)  
    }  
        // having no extra docs is an interesting case for seq no based recoveries - test it more often  
            public Settings onNodeStopped(String nodeName) throws Exception {  
            .map(
        final RecoveryResponse recoveryResponse = client().admin().indices().prepareRecoveries(indexName).setActiveOnly(false).get();
        internalCluster().stopRandomDataNode();
        final Path translogDir = getPathToShardData(indexName, ShardPath.TRANSLOG_FOLDER_NAME);
            assertThat(explanation.getCurrentNode(), notNullValue());
        terminal.addTextInput("y");
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
import org.opensearch.action.search.SearchRequestBuilder;
                .setPrimary(true)  
        ensureGreen();
        });
                } catch (Exception e) {  
import java.util.stream.Collectors;
                .get()
    }
import java.util.regex.Matcher;  
                });
            .filter(Files::isDirectory)
        assertBusy(() -> {
        return shardStats[shardId].getSeqNoStats();  
        });
            numDocs += numExtraDocs;  
        TestTranslog.corruptRandomTranslogFile(logger, random(), translogDir);  
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
                    .put("index.routing.allocation.exclude._name", node2)
 * software distributed under the License is distributed on an
        logger.info("--> output:\n{}", terminal.getOutput());
        );  
        final RemoveCorruptedShardDataCommand command = new RemoveCorruptedShardDataCommand();  
            .get();
 * this file be licensed under the Apache-2.0 license or a
                // Try running it before the shard is corrupted, it should flip out because there is no corruption file marker
import static org.hamcrest.Matchers.not;
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.core.common.unit.ByteSizeValue;
        logger.info("--> corrupting translog");
                );  
        // Start the node with the non-corrupted data path
import org.opensearch.ExceptionsHelper;
            () -> internalCluster().getInstances(GatewayMetaState.class).forEach(gw -> assertTrue(gw.allPendingAsyncStatesWritten()))  
            command.execute(terminal, options, environment);  
        int numDocsToKeep = randomIntBetween(10, 100);
        assertThat(terminal.getOutput(), containsString("allocate_stale_primary"));  
                state,
                .setPrimary(true)
            assertHitCount(q.get(), numDocsToKeep);  
import org.opensearch.cli.MockTerminal;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        OptionSet options = parser.parse("-d", translogDir.toAbsolutePath().toString());
            final String name = cursor.getValue().getName();
        final int totalDocs = numDocsToKeep + numDocsToTruncate;
            )  
        );
            final ClusterAllocationExplanation explanation = client().admin()
                TestTranslog.corruptRandomTranslogFile(logger, random(), translogDir);
                command.execute(terminal, options, environment);
            final Environment environment = TestEnvironment.newEnvironment(
                .setPrimary(true)  
        // have to shut down primary node - otherwise node lock is present
        for (final Map.Entry<String, DiscoveryNode> cursor : nodes.getNodes().entrySet()) {  
    }  
        final NodesStatsResponse nodeStatsResponse = client().admin().cluster().prepareNodesStats(nodeId).addMetric(FS.metricName()).get();
                .setShard(0)  
                Settings.builder()
        // shard should be failed due to a corrupted index  
            if (name.equals(node)) {  
                nodeId = cursor.getKey();
                client().prepareSearch(indexName).setPreference("_only_nodes:" + node).setQuery(matchAllQuery()).get(),  
        // sample the replica node translog dirs
                .getUnassignedInfo();
import org.opensearch.cluster.routing.allocation.command.AllocateStalePrimaryAllocationCommand;  
            public Settings onNodeStopped(String nodeName) throws Exception {
        ensureYellow();  
                shardAllocationDecision.getAllocateDecision().getAllocationDecision(),
 * specific language governing permissions and limitations
        });
        );
            prepareCreate(indexName).setSettings(
        assertAcked(
                .prepareAllocationExplain()  
        assertHitCount(client().prepareSearch(indexName).setQuery(matchAllQuery()).get(), numDocsToKeep);
        });
    private static void disableTranslogFlush(String index) {  
        logger.info("--> indexing [{}] more docs to be truncated", numDocsToTruncate);
                Settings.builder()
        // Ensure that the global checkpoint and local checkpoint are restored from the max seqno of the last commit.
            environmentByNodeName.put(nodeName, environment);
        for (int k = 0, attempts = randomIntBetween(5, 10); k < attempts; k++) {
        // Corrupt the translog file(s) on the replica
                return super.onNodeStopped(nodeName);
        command.execute(terminal, options, environment);
            .get(indexName)
import org.opensearch.cluster.routing.ShardRouting;
    public void testCorruptIndex() throws Exception {
import org.opensearch.common.settings.Settings;
        });  
 * The OpenSearch Contributors require contributions made to  
        flush(indexName);
            .filter(recoveryState -> recoveryState.getPrimary() == false)  
        final Pattern pattern = Pattern.compile("Corrupted Lucene index segments found -\\s+(?<docs>\\d+) documents will be lost.");
        assertBusy(() -> {
import org.apache.lucene.index.IndexWriter;
        }
            if (name.equals(node1)) {
                    .resolve(Integer.toString(shardId.getId()))
public class RemoveCorruptedShardDataCommandIT extends OpenSearchIntegTestCase {
        assertThat(replicaRecoveryState.getIndex().toString(), replicaRecoveryState.getIndex().recoveredFileCount(), greaterThan(0));  
    @Override  
        List<ShardIterator> iterators = iterableAsArrayList(shardIterators);
        for (String nodeName : nodeNames) {
                shardAllocationDecision.getAllocateDecision().getAllocationDecision(),
import org.opensearch.index.MergePolicyProvider;  
        assertHitCount(client().prepareSearch(indexName).setQuery(matchAllQuery()).get(), expectedNumDocs);  
            IndexRequestBuilder[] builders = new IndexRequestBuilder[numExtraDocs];
import org.opensearch.index.MockEngineFactoryPlugin;
            }
            final ClusterAllocationExplanation explanation = client().admin()
        final RecoveryState replicaRecoveryState = recoveryResponse.shardRecoveryStates()  
                logger.info("--> corrupting translog on node {}", nodeName);
        }
 *  
            final Path indexPath = indexPathByNodeName.get(nodeName);
        final Settings nodePathSettings = internalCluster().dataPathSettings(node);  
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocsToKeep];  
        internalCluster().restartNode(node1, new InternalTestCluster.RestartCallback() {
        final RemoveCorruptedShardDataCommand command = new RemoveCorruptedShardDataCommand();
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        internalCluster().startNode(node2PathSettings);
                CorruptionUtils.corruptIndex(random(), indexDir, false);
                        logger.info("--> failed acquiring lock for {}", indexDir);  
                Settings.builder()  
 * license agreements. See the NOTICE file distributed with
                e.getMessage(),
            );
import org.opensearch.test.transport.MockTransportService;
import org.apache.lucene.store.NativeFSLockFactory;  
                .setShard(0)
import org.opensearch.env.Environment;
            )  
import java.util.HashMap;
            indexPathByNodeName.put(nodeName, getPathToShardData(nodeId, shardId, ShardPath.INDEX_FOLDER_NAME));
        assertThat(terminal.getOutput(), containsString("\"node\" : \"" + primaryNodeId + "\""));
            Settings.builder().put(internalCluster().getDefaultSettings()).put(nodePathSettings).build()  
import static org.opensearch.core.common.util.CollectionUtils.iterableAsArrayList;
    }
                    .put(MergePolicyProvider.INDEX_MERGE_ENABLED, false)
        ensureYellow();
                        Lock ignored = dir.obtainLock(IndexWriter.WRITE_LOCK_NAME)
import org.opensearch.cluster.routing.ShardRoutingState;
                .prepareUpdateSettings(indexName)  
        }
            @Override
        assertAcked(
                return super.onNodeStopped(nodeName);
        final String node2 = internalCluster().getNodeNames()[1];
        return Arrays.asList(MockTransportService.TestPlugin.class, MockEngineFactoryPlugin.class, InternalSettingsPlugin.class);
            }  
            .collect(Collectors.toSet());  
        assertBusy(() -> {
}
import com.carrotsearch.randomizedtesting.generators.RandomPicks;  
import java.util.stream.Stream;  
            logger.info(" -- stopped {}", nodeName);
        // there is only _stale_ primary (due to new allocation id)  
        logger.info("--> nodes name: {}, {}", node1, node2);  
        logger.info("--> starting the replica node to test recovery");
            assertThat(unassignedInfo.getReason(), equalTo(UnassignedInfo.Reason.ALLOCATION_FAILED));  
        final String node1 = internalCluster().getNodeNames()[0];  
                    .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "-1")  
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
            )
        internalCluster().stopRandomDataNode();
        final Map<String, Environment> environmentByNodeName = new HashMap<>();
        final RemoveCorruptedShardDataCommand command = new RemoveCorruptedShardDataCommand();
        int numDocs = 0;
                return super.onNodeStopped(nodeName);
        logger.info("--> output:\n{}", terminal.getOutput());
    }  
        indexRandom(false, false, false, Arrays.asList(builders));
            assertThat(ExceptionsHelper.unwrap(unassignedInfo.getFailure(), TranslogCorruptedException.class), not(nullValue()));
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            );  
import org.opensearch.env.TestEnvironment;  
            IndexShard replica = internalCluster().getInstance(IndicesService.class, node2).getShardOrNull(new ShardId(index, 0));  
                    .put(IndexSettings.INDEX_CHECK_ON_STARTUP.getKey(), "checksum")
import org.opensearch.test.InternalTestCluster;
import static org.hamcrest.Matchers.equalTo;
 * Modifications Copyright OpenSearch Contributors. See  
import static org.hamcrest.Matchers.nullValue;  
import org.opensearch.cluster.metadata.IndexMetadata;
            .filter(recoveryState -> recoveryState.getPrimary() == false)  
            assertThat(shardAllocationDecision.isDecisionTaken(), equalTo(true));  
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
        }
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertThat(matcher.find(), equalTo(true));
import org.opensearch.cluster.routing.GroupShardsIterator;
        internalCluster().startClusterManagerOnlyNode();
                .setIndex(indexName)
            public Settings onNodeStopped(String nodeName) throws Exception {  
            replica.flush(new FlushRequest());
        final GroupShardsIterator shardIterators = state.getRoutingTable().activePrimaryShardsGrouped(new String[] { indexName }, false);
                        throw new AssertionError("still waiting for lock release at [" + indexDir + "]", lofe);
            command.findAndProcessShardPath(
            }  
        int numDocsToTruncate = randomBoolean() ? 0 : randomIntBetween(0, 100);  
        logger.info("--> starting node");  
        final String indexName = "test";
            )  
                        Directory dir = FSDirectory.open(indexDir, NativeFSLockFactory.INSTANCE);  
        assertThat(nodeId, notNullValue());
 * You may obtain a copy of the License at  
            Index index = resolveIndex(indexName);
            );
            assertThat(explanation.getCurrentNode(), notNullValue());
            }
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
        ClusterState state = client().admin().cluster().prepareState().get().getState();  
        assertTrue(shardRouting.primary());  
            final ClusterAllocationExplanation explanation = client().admin()
                    assertThat(e.getMessage(), startsWith("Shard does not seem to be corrupted at"));
        logger.info("--> indexing [{}] docs to be kept", numDocsToKeep);
        assertHitCount(client().prepareSearch(indexName).setQuery(matchAllQuery()).get(), totalDocs);  
        final SeqNoStats seqNoStats = getSeqNoStats(indexName, 0);
        logger.info("--> running command for [{}]", translogDir.toAbsolutePath());  
        final Path indexDir = getPathToShardData(indexName, ShardPath.INDEX_FOLDER_NAME);  
import org.opensearch.cluster.node.DiscoveryNodes;
                .prepareAllocationExplain()  
                .setShard(0)  
            builders[i] = client().prepareIndex(indexName).setSource("foo", "bar");
                allOf(containsString("failed to lock node's directory"), containsString("is OpenSearch still running?"))
                break;
                builders[i] = client().prepareIndex(indexName).setSource("foo", "bar");  
            fail("expected the command to fail as node is locked");
            final OptionSet options = parser.parse("--dir", indexPath.toAbsolutePath().toString());  
        }  
                .cluster()  
import org.opensearch.cluster.routing.UnassignedInfo;  
import java.util.Map;
        for (String node : internalCluster().nodesInclude(indexName)) {
        String primaryNodeId = null;  
        assertNotNull(shardRouting);
            )
                break;
            assertThat(
        final RecoveryState replicaRecoveryState = recoveryResponse.shardRecoveryStates()  
        final Path translogDir = getPathToShardData(node2, shardId, ShardPath.TRANSLOG_FOLDER_NAME);  
package org.opensearch.index.shard;
import static org.hamcrest.Matchers.containsString;  
        } catch (Exception e) {
        // check replica corruption
            .get();
import org.opensearch.action.admin.indices.flush.FlushRequest;
            Settings.builder().put(internalCluster().getDefaultSettings()).put(node2PathSettings).build()
        final ShardStats[] shardStats = client().admin().indices().prepareStats(index).get().getIndices().get(index).getShards();
            }
    }
        disableTranslogFlush(indexName);
            }
import java.nio.file.Files;
                .setIndex(indexName)
import org.opensearch.cluster.routing.allocation.AllocationDecision;
                .cluster()
            prepareCreate(indexName).setSettings(
