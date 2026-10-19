                    IOUtils.closeWhileHandlingException(node);
        assertRequestsFinished();  
import org.opensearch.script.ScriptModule;
        } else if (random.nextInt(100) <= 90) {
        if (!nodesToRemove.isEmpty() && size() > 0) {
                    ).get();  
        // Components from earlier plugins (e.g. those registered via PluginComponentRegistry) are  
            int retryTimeoutSeconds = RandomNumbers.randomIntBetween(random, 0, 60);
    private static <T> T getInstanceFromNode(Class<T> clazz, Node node) {
            randomlyAddDedicatedClusterManagers,  
                            );
            }  
    public Set<String> getClusterManagerNames() {
        // force certain settings
                        if (operations.size() > 0) {
        }
import static org.opensearch.discovery.FileBasedSeedHostsProvider.UNICAST_HOSTS_FILE;
    @Override  
                        continue; // shard is closed - just ignore  
                        Settings.builder()
     */
 * software distributed under the License is distributed on an
    public synchronized void stopCurrentClusterManagerNode() throws IOException {  
        /* Randomly return a client to one of the nodes in the cluster */
import org.opensearch.action.support.replication.TransportReplicationAction;
        final List<String> initialClusterManagerNodes = settings.stream()  
        // cannot be a synchronized method since it's called on other threads from within synchronized startAndPublishNodesAndClients()  
        }  
            }  
import static org.hamcrest.Matchers.greaterThan;  
        private void markNodeDataDirsAsNotEligibleForWipe(Node node) {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                    equalTo(0L)  
        Settings settings1 = Settings.builder().put(settings).put(NodeRoles.clusterManagerOnlyNode(settings)).build();
        Set<Class<? extends Plugin>> plugins = new LinkedHashSet<>(nodeConfigurationSource.nodePlugins());
                dataDirToClean.removeAll(Arrays.asList(nodeEnv.nodeDataPaths()));  
        builder.put(
                RandomNumbers.randomIntBetween(random, 0, 2000)
            final Builder builder = Settings.builder();  
                IndexingPressure indexingPressure = getInstance(IndexingPressure.class, nodeAndClient.name);  
        return clusterManagerNode.getName();
    private static int getMinClusterManagerNodes(int eligibleClusterManagerNodes) {
        Client client = viaNode != null ? client(viaNode) : client();  
        wipePendingDataDirectories();
                    RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(),
    public void ensureEstimatedStats() {
            if (DiscoveryNode.isClusterManagerNode(nodeSettings)) {
            );  
            return name;  
    private void removeExclusions(Set<String> excludedNodeIds) {  
        return getInstance(clazz, new NodeNamePredicate(getClusterManagerName()));
                                + replicaShardRouting  
                        }
        return builder.build();  
            if (autoManageClusterManagerNodes
                        IndexShard replicaShard = getShardOrNull(state, replicaShardRouting);
                throw new AssertionError("failed to configure file-based discovery", e);
                        final IndexShard replicaShard = getShardOrNull(state, replicaShardRouting);
    public int numWarmAndDataNodes() {  
        return startSearchOnlyNode(Settings.EMPTY);  
    }
        nodes = Collections.unmodifiableNavigableMap(newNodes);  
                        + "' as a node setting set '"  
        final int prevClusterManagerCount = getClusterManagerNodesCount();
        if (nodeAndClients.size() > 0) {
        final int defaultMinClusterManagerNodes;  
            if (wipeData) {
        } else {  
                    setBootstrapClusterManagerNodeIndex(-1);
     * The map of nodes is never mutated so individual reads are safe without synchronization.  
                            );
/*  
                .build();  
                            docsOnReplica = IndexShardTestCase.getDocIdAndSeqNos(replicaShard);
            startNodes(n - size, Settings.builder().put(onlyRoles(settings, warmAndDataRoles)).build());
    private synchronized NodeAndClient buildNode(int nodeId, Settings settings, boolean reuseExisting, Runnable onTransportServiceStarted) {  
        if (random.nextBoolean()) {  
        if (nodeAndClient != null) {  
        Collection<Class<? extends Plugin>> plugins = getPlugins();  
            .collect(Collectors.toList());  
    public void assertRequestsFinished() {  
        NodeAndClient nodeAndClient = getRandomNodeAndClient(nc -> filter.test(nc.node.settings()));
    @Override  
        int currentNodeId = numClusterManagerNodes() - 1;
     */
                );  
            }
        return startDataAndWarmNodes(numNodes, Settings.EMPTY);
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
        }  
        defaultSettings = builder.build();
        if (size() > 0) {
        if (usingSingleNodeDiscovery == false) {
                    try {
                    throw new AssertionError("unexpected", e);
import org.opensearch.indices.recovery.RecoverySettings;  
                // However, we do not yet have a way to be sure there's a majority left, because the voting configuration may not yet have
     * Stops all running nodes in cluster
        } else {  
            clusterName,
    /**
        return new NodeAndClient(name, node, settings, nodeId);  
        for (Settings settings : allNodesSettings) {
import org.opensearch.transport.TransportSettings;  
     */
        boolean useDedicatedClusterManagerNodes = randomlyAddDedicatedClusterManagers ? random.nextBoolean() : false;  
    }  
                    }  
        stopNodesAndClient(clusterManagerNode);
                            equalTo(docsOnPrimary)
                    ? RandomNumbers.randomIntBetween(random, 0, newClusterManagerCount - 1)
                    stats.getIndices().getQueryCache().getMemorySizeInBytes(),  
import org.opensearch.node.MockNode;
                try {  
                        final List<DocIdSeqNoAndSource> docsOnReplica;  
                        // shard is closed
        }  
        synchronized (discoveryFileMutex) {
    /**  
            return newSettings.build();  
            assertBusy(() -> {
                try {
        // it depends on, despite being listed first in nodePlugins()).
     * and / or {@link #fullRestart(InternalTestCluster.RestartCallback)} to execute actions at certain
        final String clusterName,  
/*
    private final AtomicInteger nextNodeId = new AtomicInteger(0);  
                    DEFAULT_MIN_NUM_CLIENT_NODES,
        }
        final List<Settings> settings = new ArrayList<>();  
        final NodeAndClient buildNode = buildNode(nodeId, nodeSettings, false, onTransportServiceStarted);
                if (replicaWriteBytes > 0) {
    }  
    public List<String> startDataOnlyNodes(int numNodes, Settings settings) {
            SeedUtils.formatSeed(clusterSeed),
            final NodeAndClient nodeAndClient = buildNode(
            while (totalClusterManagerNodes > 1) {
    public void assertSameDocIdsOnShards() throws Exception {  
            Settings nodeSettings = updatedSettings.get(i);
    }
                    "NA",
            logger.info("increasing cluster size from {} to {}", size, n);  
                    throw new AssertionError("Interruption while waiting for the node to close", e);
public final class InternalTestCluster extends TestCluster {
        return getInstance(ClusterService.class, node);
            updatedSettings.put(Environment.PATH_DATA_SETTING.getKey(), baseDir.resolve(name));
    private static final Predicate<NodeAndClient> DATA_NODE_PREDICATE = nodeAndClient -> DiscoveryNode.isDataNode(  
import static org.opensearch.cluster.coordination.ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING;
                        }
        final int nodeId = nextNodeId.getAndIncrement();
    }
import java.util.Map;
                    p.getName(),
    }
            throw new IllegalStateException("cluster failed to form", ae);
    }
        return Collections.emptySet();
        Client client() {
        // ElasticsearchIntegrationTest must override beforeIndexDeletion() to avoid failures.
    private synchronized void publishNode(NodeAndClient nodeAndClient) {  
                                + docsOnReplica.size()
        builder.append("-CLUSTER_SEED=[").append(clusterSeed).append(']');  
                IndicesService indexServices = getInstance(IndicesService.class, nodeName);  
            clusterName,  
            Settings finalSettings = Settings.builder()
                @Override
            "Cluster is NOT consistent - restarting shared nodes - nodes: [{}] nextNodeId: [{}] numSharedNodes: [{}]",
        }
            if (fileCache != null && WARM_NODE_PREDICATE.test(nodeAndClient)) {  
     */  
        }  
        final NodeAndClient previous = newNodes.remove(nodeAndClient.name);
            throw new IllegalArgumentException("maximum number of data nodes must be >= minimum number of  data nodes");
import org.opensearch.node.NodeService;
                    .count() == 1) {
        // allow overriding the above  
     *                                  the method will return the existing one  
        return getInstance(clazz, CLUSTER_MANAGER_NODE_PREDICATE);  
    @Override
        return map.values().stream().filter(predicate).collect(Collectors.toCollection(ArrayList::new));  
                                    + nodeAndClient.name  
            }  
     */  
        assert this.numSharedCoordOnlyNodes >= 0;
        ensureOpen();  
        );
                }
        final Collection<Class<? extends Plugin>> mockPlugins,  
                                    + "]"  
 * this work for additional information regarding copyright
            nodePrefix,
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsRequest;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        } catch (IOException e) {  
                if (closed.get()) {
    private final Object discoveryFileMutex = new Object();  
                re.addSuppressed(new RuntimeException("failed to start nodes"));  
import static org.opensearch.test.OpenSearchTestCase.assertBusy;
        }, 60, TimeUnit.SECONDS);  
            .collect(Collectors.toList());
        if (autoManageClusterManagerNodes && nodeAndClients.size() > 0) {
        NodeAndClient nodeAndClient = getRandomNodeAndClient(DATA_NODE_PREDICATE);
    }  
import java.nio.file.Path;
     * Stops any of the current nodes but not the cluster-manager node.
        fail("Could not find a node that holds " + index);
    /**
            final long newIdSeed = NodeEnvironment.NODE_ID_SEED_SETTING.get(node.settings()) + 1;
                        }  
        return startNodes(numNodes, Settings.builder().put(onlyRole(settings, DiscoveryNodeRole.WARM_ROLE)).build());  
                if (INITIAL_CLUSTER_MANAGER_NODES_SETTING.exists(callbackSettings) == false) {  
        return startWarmOnlyNodes(numNodes, Settings.EMPTY);
import java.util.HashSet;
                totalClusterManagerNodes -= 1;
        if (assignedNode == null) {
                throw new AssertionError("Tried to stop the only cluster-manager eligible shared node");  
                    false,
        return startNodes(settings).get(0);  
        } catch (Exception e) {  
                    .map(TransportService::getLocalNode)
            return randomNodeAndClient.nodeClient(); // ensure node client cluster-manager is requested  
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING.getKey(),
                validateClusterFormed();
            "expected at least one cluster-manager-eligible node left in " + nodes,  
                @Override  
        }  
                settings.add(nodeSettings);  
        final NodeAndClient clusterManagerNode = nodes.get(clusterManagerNodeName);
     * Asserts that all shards with the same shardId should have document Ids.
        );
            TimeValue.timeValueMillis(RandomNumbers.randomIntBetween(random, 20, 50))  
        return excludedNodeNames;  
                            Engine engine = IndexShardTestCase.getEngine(indexShard);
                    false,  
    public Client nonClusterManagerClient() {
                // fail if it never reached 0
                            .putList(ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), nodeNames)  
    private static final String DEFAULT_WARM_CACHE_SIZE_PERCENT = "5%";
        builder.put(Environment.PATH_HOME_SETTING.getKey(), baseDir);
     */
        // TODO: currently we only randomize "cluster.no_cluster_manager_block" between "write" and "metadata_write", as "all" is fragile
                    }  
                RandomNumbers.randomIntBetween(random, 5, 10)
                    false  
 *
                        List<String> operations = indexShard.getActiveOperations();
            builder.put("cache.recycler.page.type", RandomPicks.randomFrom(random, PageCacheRecycler.Type.values()));  
            defaultMinClusterManagerNodes = getMinClusterManagerNodes(getClusterManagerNodesCount() + newClusterManagerCount);
                + "[{}] (data) nodes and [{}] coord only nodes (min_cluster_manager_nodes are [{}])",
    private NodeAndClient getRandomNodeAndClient() {  
            this.nodeName = nodeName;
        }  
            if (useDedicatedClusterManagerNodes) {  
    private void removeDisruptionSchemeFromNode(NodeAndClient nodeAndClient) {
                    .map(NodeAndClient::getName)  
            }  
        this.baseDir = baseDir;  
import org.opensearch.cluster.routing.ShardRouting;  
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.seqno.SequenceNumbers;
            // delete data folders now, before we start other nodes that may claim it
                RuntimeException re = FutureUtils.rethrowExecutionException(e);
            newNodeSettings[nodeAndClient.nodeAndClientId()] = newSettings;
        final Settings settings = getSettings(nodeId, seed, extraSettings);  
        pluginInfos.addAll(additionalNodePlugins);
    public String startClusterManagerOnlyNode() {  
    }  
                    for (ShardRouting replicaShardRouting : indexShardRoutingTable.replicaShards()) {
                throw re;
                throw new RuntimeException(e);
    /**
                    } catch (AlreadyClosedException ex) {
    }
        final NodeAndClient randomNodeAndClient = getRandomNodeAndClient();
        if (prevNodeCount == 0 && autoManageClusterManagerNodes) {  
                }
        stopNodesAndClients(nodesToRemove);  
    private final class NodeAndClient implements Closeable {
            logger.info("removing voting config exclusions for {} after restart/shutdown", excludedNodeIds);  
    public synchronized List<String> startNodes(Settings... extraSettings) {  
     */
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING.getKey(),
    public synchronized boolean stopRandomDataNode() throws IOException {
            updatedSettings.putList(  
            logger.info("Clearing active scheme {}, expected healing time {}", activeDisruptionScheme, expectedHealingTime);
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING.getKey(),
            return true;
            logger.info("Closing filtered random node [{}] ", nodeAndClient.name);
        assert randomNodeAndClient != null;
                    logger.debug("removing node data paths: [{}]", Arrays.toString(locations));
import org.opensearch.node.Node;
    public List<String> startSearchOnlyNodes(int numNodes) {  
     * if more nodes than <code>n</code> are present this method will not  
        assert activeDisruptionScheme == null : "there is already and active disruption ["
    /**  
            }
            logger.info("increasing cluster size from {} to {}", size, n);
import static org.opensearch.test.OpenSearchTestCase.randomFrom;
    private Set<String> excludeClusterManagers(Collection<NodeAndClient> nodeAndClients) {
        }
            TimeValue expectedHealingTime = activeDisruptionScheme.expectedTimeToHeal();
 * Unless required by applicable law or agreed to in writing,
                            assertThat(  
                public void remove() {  
import org.opensearch.core.util.FileSystemUtils;  
        if (activeDisruptionScheme != null) {
        /**
        }
        final String name = buildNodeName(nodeId, settings);
     * Returns a reference to the given nodes instances of the given class &gt;T&lt;
                nodeAndClient.name,  
                    fail("Could not assert finished requests within timeout on node [" + nodeAndClient.name + "]");  
                        continue;
        final int prevNodeCount = nodes.size();
            for (NodeAndClient nodeAndClient : nodesAndClients) {  
        if (autoManageClusterManagerNodes && !waitForNodeJoin) {
        for (int i = numSharedDedicatedClusterManagerNodes + numSharedDataNodes; i < numSharedDedicatedClusterManagerNodes  
            for (NodeAndClient nodeAndClient : nodes.values()) {  
        if (RandomizedTest.isNightly() && rarely(random)) {
                );
        }  
        }
    public synchronized <T> T getCurrentClusterManagerNodeInstance(Class<T> clazz) {  
            }
            final Builder extraSettings = Settings.builder().put(noRoles());
import org.opensearch.node.Node.DiscoverySettings;  
 * The cluster supports randomized configuration such that nodes started in the cluster will
import org.opensearch.index.shard.IndexShardTestCase;
                assertThat(
    public synchronized void ensureAtMostNumDataNodes(int n) throws IOException {
     * It's only possible to change {@link #bootstrapClusterManagerNodeIndex} value if autoManageClusterManagerNodes is false.
                    nodes.add(discoveryNode.getName());  
        final int minNumDataNodes,  
        try {
import java.util.Collection;
            return getOrBuildNodeClient();  
            node.injector().getInstance(TransportService.class).addLifecycleListener(new LifecycleListener() {
                RandomNumbers.randomIntBetween(random, 5, 10)  
                    "1.8",  
                                    + indexShard.shardId()
        return getInstance(NamedWriteableRegistry.class);
        builder.put(OperationRouting.USE_ADAPTIVE_REPLICA_SELECTION_SETTING.getKey(), random.nextBoolean());
        NodeAndClient nodeAndClient = getRandomNodeAndClient(new NodeNamePredicate(getClusterManagerName()).negate());
                IndicesService indexServices = getInstance(IndicesService.class, nodeAndClient.name);
                    equalTo(0L)
                assertEquals(
        builder.put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), false);
                throw new RuntimeException("already closed");
        }
                }
 * GitHub history for details.
            baseDir,
        if (numDataPaths > 1) {
    private final Settings defaultSettings;
            .settings()  
                    states.stream().mapToLong(ClusterState::term).distinct().count()
            logger.info("increasing cluster size from {} to {}", size, n);  
        assert Thread.holdsLock(this);
        this.numSharedDataNodes = RandomNumbers.randomIntBetween(random, minNumDataNodes, maxNumDataNodes);
                    nullValue()
                                    + "Expected 0 but got "
        Map<String, InternalTestCluster.NodeAndClient> map,  
    /**  
                activeDisruptionScheme.removeAndEnsureHealthy(this);
                public void afterStart() {  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        return filterNodes(nodes, WARM_AND_DATA_NODE_PREDICATE);
    private final boolean forbidPrivateIndexSettings;
    public List<String> startDataAndWarmNodes(int numNodes, Settings settings) {
     * An abstract class that is called during {@link #rollingRestart(InternalTestCluster.RestartCallback)}
        final NavigableMap<String, NodeAndClient> newNodes = new TreeMap<>(nodes);
    public synchronized void restartRandomDataNode(RestartCallback callback) throws Exception {  
    }
                    assertBusy(() -> {
                if (shardRouting.assignedToNode()) {
    }
            restartNode(nodeAndClient, callback);  
    }  
                    return iterator.hasNext();  
        return warmNodeAndClients().size();  
        assertNoSnapshottedIndexCommit();  
                        } catch (AlreadyClosedException ok) {  
        sharedNodesSeeds = new long[numSharedDedicatedClusterManagerNodes + numSharedDataNodes + numSharedCoordOnlyNodes];
 * Modifications Copyright OpenSearch Contributors. See  
                    new ByteSizeValue(RandomNumbers.randomIntBetween(random, 10, 200), ByteSizeUnit.MB)  
            Node node = n.node;
    }  
                    .collect(Collectors.toList());  
    }  
     */
        removeExclusions(excludedNodeIds);
        }
        );
                && nodeAndClient.isClusterManagerEligible()
import com.carrotsearch.randomizedtesting.generators.RandomStrings;
        }
            }
    }  
                    "Tests must not set a '"
        }
                        // the local knowledge on the primary of the global checkpoint equals the global checkpoint on the shard
            nodeAndClients.forEach(this::publishNode);  
            RecoverySettings.INDICES_RECOVERY_MAX_CONCURRENT_FILE_CHUNKS_SETTING.getKey(),  
                )
    }
        return nodes.stream().map(NodeAndClient::getName).collect(Collectors.toList());
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;  
        assert Thread.holdsLock(this);
            builder.put(SearchService.KEEPALIVE_INTERVAL_SETTING.getKey(), timeValueMillis(10 + random.nextInt(2000)).getStringRep());  
        }
        if (callback.validateClusterForming() || excludedNodeIds.isEmpty() == false) {
                );
            settings.add(getNodeSettings(i, sharedNodesSeeds[i], extraSettings.build(), defaultMinClusterManagerNodes));  
            secureSettings = ((MockSecureSettings) secureSettings).clone();
        }
                    if (primaryShard == null) {  
    public synchronized String startCoordinatingOnlyNode(Settings settings) {
import org.opensearch.cluster.action.index.MappingUpdatedAction;
import java.util.function.Predicate;  
                throw new IllegalStateException("node " + name + " should be closed before recreating it");
import java.util.concurrent.atomic.AtomicInteger;
    @Override
        final List<Settings> settings = new ArrayList<>();  
    private final int numDataPaths;  
     * This assertion might be expensive, thus we prefer not to execute on every test but only interesting tests.
import java.util.Set;  
        return getRandomNodeAndClient(NO_DATA_NO_CLUSTER_MANAGER_PREDICATE).client();
            } finally {
 * are involved reproducibility is very limited. This class should only be used through {@link OpenSearchIntegTestCase}.
                .build();  
                    Files.createDirectories(configPath);  
        assertNoInFlightDocsInEngine();
            final Iterator<NodeAndClient> iterator = nodes.values().iterator();
        final Runnable onTransportServiceStarted = () -> rebuildUnicastHostFiles(toStartAndPublish);
                }
        return startNodes(waitForNodeJoin, Collections.nCopies(numOfNodes, settings).toArray(new Settings[0]));  
     * Returns a client to a coordinating only node
        fullRestart(EMPTY_CALLBACK);
 *
            OpenSearchExecutors.daemonThreadFactory("test_" + clusterName),
        }  
            logger.info("recreating node [{}] ", nodeAndClient.name);
        if (size() > 0) {  
                @Override
import org.opensearch.cluster.metadata.RepositoriesMetadata;  
    }
                } catch (Exception e) {
    private String buildNodeName(int id, Settings settings) {
                node.start();
        }
                    try {
                }
            Settings.Builder newSettings = Settings.builder();  
            return nodeAndClientId;
        for (NodeAndClient nodeAndClient : nodes.values()) {
        ensureOpen();
                IndicesService indexServices = getInstance(IndicesService.class, nodeAndClient.name);  
                        if (primaryShard.isRemoteTranslogEnabled() == false) {
                    false,  
                nodeConfigurationSource.nodeConfigPath((int) newIdSeed),
        assertBusy(() -> {
                    "if cluster-manager nodes are automatically managed then nodes must complete a join cycle when starting",
     * Starts a node with the given settings builder and returns its name.
    }
import org.opensearch.common.settings.Settings;
                success = true;
    static final int DEFAULT_MAX_NUM_CLIENT_NODES = 1;  
                    for (IndexShard indexShard : indexService) {
    private final Logger logger = LogManager.getLogger(getClass());
    public void closeNonSharedNodes(boolean wipeData) throws IOException {
        // The assumption here is that after a test there are no ongoing write operations.
        Set<NodeAndClient> nodesToRemove = new HashSet<>();
    }
            }  
    private final Path baseDir;  
    }
     * Returns a node client to a data node in the cluster.  
            IndicesService indicesService = getInstanceFromNode(IndicesService.class, node);  
        );
        builder.append("-HASH=[").append(SeedUtils.formatSeed(System.nanoTime())).append(']');
                });
        int numNodesRestarted = 0;
        return dataNodeAndClients().size();
    }
            final Settings nodeSettings = updatedSettings.get(i);
        startDataOnlyNodes(totalDataNodes);  
        for (HttpServerTransport httpServerTransport : getInstances(HttpServerTransport.class)) {  
            }  
        if (randomNodeAndClient != null) {
        final boolean forbidPrivateIndexSettings  
        assertThat(shard, greaterThanOrEqualTo(0));  
    public InternalTestCluster(
        }
                    false,
            if (settings.get(ClusterName.CLUSTER_NAME_SETTING.getKey()) != null) {
            this.node = node;
        public Settings onNodeStopped(String nodeName) throws Exception {
import org.opensearch.plugins.Plugin;  
            String ctx = randomFrom(random, ScriptModule.CORE_CONTEXTS.keySet());
                public Client next() {
        ensureOpen();
            try {
    public String startSearchOnlyNode(Settings settings) {  
            }
        } catch (AssertionError ae) {
            );
            0,
            } finally {
            final NodeAndClient nodeAndClient = buildNode(i, nodeSettings, true, onTransportServiceStarted);  
                }
                this.numSharedCoordOnlyNodes = numClientNodes;
                throw new RuntimeException("already closed");
        assert this.numSharedDataNodes >= 0;  
            } finally {
                RandomNumbers.randomIntBetween(random, 2, 5)
                    builder.putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), initialClusterManagerNodes);  
            if (numClientNodes < 0) {
                                + "] num_docs_on_replica=["
import static org.junit.Assert.assertTrue;  
        builder.put(  
        );
     */  
        }  
                    newSettings.add(  
        if (others != null) {  
    }  
                        try {  
import org.opensearch.http.HttpServerTransport;
                        }
                    false,
                } catch (ShardLockObtainFailedException ex) {
        builder.put("http.port", 0);
            builder.put(SearchService.KEEPALIVE_INTERVAL_SETTING.getKey(), timeValueSeconds(10 + random.nextInt(5 * 60)).getStringRep());
     */
            } else {
        final Set<String> excludedNodeIds = excludeClusterManagers(nodeAndClients);
    public Iterable<Client> getClients() {
    }
     */
        Settings closeForRestart(RestartCallback callback, int minClusterManagerNodes) throws Exception {  
            }
import org.opensearch.script.ScriptService;  
import static org.junit.Assert.assertEquals;  
        }  
    }
import org.opensearch.transport.TransportService;
        this.nodePrefix = nodePrefix;
        }  
        for (NodeAndClient nodeAndClient : nodeAndClients) {
                        }  
                && nodes.values()
                            nodeNames.add(Node.NODE_NAME_SETTING.get(nodeSettings));
    }
     */
        if (nextNodeId.get() == newSize && nodes.size() == newSize) {
    private final int numSharedDedicatedClusterManagerNodes;
            markNodeDataDirsAsNotEligibleForWipe(node);
     * Restarts a node and calls the callback during restart.
    }
     * Ensures that at most <code>n</code> are up and running.
                    false,
        final List<Settings> updatedSettings = bootstrapClusterManagerNodeWithSpecifiedIndex(settings);
import static org.apache.lucene.tests.util.LuceneTestCase.rarely;
        }
                        }
        }
import static org.opensearch.test.NodeRoles.noRoles;  
    }
            NodeAndClient next = values.next();
                    1,
 * <p>
    );
        private final int nodeAndClientId;
            validateClusterFormed();  
    synchronized Set<String> allDataNodesButN(int count) {
            NodeEnvironment nodeEnv = node.getNodeEnvironment();
    }
                    .filter(DiscoveryNode::isClusterManagerNode)  
import org.opensearch.discovery.ClusterManagerNotDiscoveredException;
            callback,  
import org.opensearch.Version;  
    public List<String> startNodes(int numOfNodes, Settings settings) {
        this(  
                                .collect(Collectors.joining(",", "[", "]"));  
            for (IndexService indexService : indexServices) {  
    }
import com.carrotsearch.randomizedtesting.RandomizedTest;  
            stopNodesAndClient(nodeAndClient);
                stopRandomNodeNotCurrentClusterManager();  
    }
    static final int DEFAULT_MAX_NUM_DATA_NODES = TEST_NIGHTLY ? 6 : 3;
    public void resetCluster() {
            } else {
    /**
        }
    /**
        final Collection<Class<? extends Plugin>> mockPlugins,
                assertThat(
        return defaultSettings;
import java.util.concurrent.ExecutorService;  
    /**  
import org.opensearch.core.common.unit.ByteSizeUnit;
     * Indexing starts from 0.
    @Override
                        continue; // just ignore - shard movement
 * {@link #afterTest()} to initialize and reset the cluster in order to be more reproducible. The term "more" relates  
    public void assertSeqNos() throws Exception {
        }
                if (random.nextBoolean()) {
                OperationRouting operationRouting = clusterService.operationRouting();
            fileCache.closeIndexInputReferences();
        assert size() == newSize;
        }
                    assertEquals("Node size mismatch" + debugString, expectedNodes.size(), discoveryNodes.getSize());
        builder.put(
        return getNodePrefix(settings) + id;
            builder.put(
        for (NodeAndClient nodeAndClient : nodes.values()) {
                        docsOnPrimary = IndexShardTestCase.getDocIdAndSeqNos(primaryShard);  
        final List<String> clusterManagerNodeNames = settings.stream()
            for (final IndexRoutingTable indexRoutingTable : state.routingTable().indicesRouting().values()) {
     */
            callback.doAfterNodes(numNodesRestarted++, nodeAndClient.nodeClient());
                        assertTrue("Expected node to exist: " + expectedNode + debugString, discoveryNodes.nodeExists(expectedNode));  
     * @param onTransportServiceStarted callback to run when transport service is started
        int size = numDataNodes();  
            .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), Node.NODE_NAME_SETTING.get(settings))
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;
        return clusterService(null);  
                    random,  
            if (activeDisruptionScheme != null) {
                    .collect(Collectors.toSet());  
            for (NodeAndClient nodeAndClient : nodes.values()) {
                TaskManager taskManager = getInstance(TransportService.class, nodeAndClient.name).getTaskManager();
        try {
                        primaryShardRouting + " should have set the global checkpoint",  
                    .getIndicesFieldDataCache();  
            this.nodeAndClientId = nodeAndClientId;
    private Collection<NodeAndClient> dataNodeAndClients() {
    private IndexShard getShardOrNull(ClusterState clusterState, ShardRouting shardRouting) {  
    public void restartNode(String nodeName) throws Exception {
    @Override
        }  
                finalSettings,
    public Client dataNodeClient() {  
                final MockTransportService mockTransportService = (MockTransportService) transportService;
                nodeClient = null;  
    }
            synchronized (InternalTestCluster.this) {
                        } catch (AlreadyClosedException ex) {  
    }
            );
        final Iterator<NodeAndClient> values = collection.iterator();
            this.name = name;  
                activeDisruptionScheme = null;  
                .filter(nac -> nodes.containsKey(nac.name) == false) // filter out old cluster-managers
    public <T> T getInstance(Class<T> clazz, final String node) {  
            if (random.nextBoolean()) {
            );
                public boolean hasNext() {
        final Set<String> excludedNodeNames = new HashSet<>();  
                "Closing random non cluster-manager node [{}] current cluster-manager [{}] ",
            for (NodeAndClient nodeAndClient : nodes.values()) {  
                    ShardRouting primaryShardRouting = indexShardRoutingTable.primaryShard();
    private ServiceDisruptionScheme activeDisruptionScheme;
        if (!dataDirToClean.isEmpty()) {
        Random random = new Random(seed);
        final int maxNumDataNodes,
        startAndPublishNodesAndClients(toStartAndPublish);
                    assertThat(
            "internal_test_cluster_executor",  
import org.opensearch.common.Nullable;
                // If stopping few enough cluster-manager-nodes that there's still a majority left, there is no need to withdraw their votes
        if (activeDisruptionScheme != null) {
        nextNodeId.set(firstNodeId + numOfNodes);
        Set<DiscoveryNodeRole> warmAndDataRoles = new HashSet<>();  
            ? nodes.values().stream()  
                        RepositoriesMetadata repositoriesMetadata = cs.metadata().custom(RepositoriesMetadata.TYPE);
                }
     * in the cluster.  
            logger.info("Closing random node [{}] ", nodeAndClient.name);
        return false;
        if (values.isEmpty() == false) {
        }  
            }  
        private void recreateNode(final Settings newSettings, final Runnable onTransportServiceStarted) {
                suffix = suffix + DiscoveryNodeRole.DATA_ROLE.roleNameAbbreviation();
                states.forEach(cs -> {  
    public List<String> startSearchOnlyNodes(int numNodes, Settings settings) {
        randomlyResetClients();
                // if we don't have dedicated cluster-manager nodes, keep things default
        }
    /**
        String clusterManagerNodeName = getClusterManagerName();  
    @Override
            }
        private MockNode node;  
        nextNodeId.set(newSize);  
        final int numberOfClusterManagerNodes = numSharedDedicatedClusterManagerNodes > 0
            assert iterator.hasNext();  
import java.util.Arrays;
                            docsOnReplica,
    /**
        }
            return nodes;  
            return node;
                    String routing = RandomStrings.randomAsciiOfLength(random, 10);
            }
                    DEFAULT_MAX_NUM_CLIENT_NODES
            }  
            if (stoppingClusterManagers != currentClusterManagers && stoppingClusterManagers > 0) {
import org.opensearch.common.util.concurrent.FutureUtils;
        super(clusterSeed);
        builder.put(
    }  
        restartRandomDataNode(EMPTY_CALLBACK);  
        // Check that the operations counter on index shard has reached 0.
            throw new RuntimeException(e);
    public synchronized void validateClusterFormed() {
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        }
import static org.opensearch.common.unit.TimeValue.timeValueMillis;  
    private NodeAndClient removeNode(NodeAndClient nodeAndClient) {
                    totalDataNodes -= 1;
        NodeAndClient randomNodeAndClient = getRandomNodeAndClient(new NodeNamePredicate(getClusterManagerName()));
        // clear all rules for mock transport services  
    }
    }
        );  
        return filterNodes(nodes, DATA_NODE_PREDICATE);  
            return randomNodeAndClient.client();
                    false,
import org.opensearch.action.admin.cluster.configuration.ClearVotingConfigExclusionsRequest;
                assertThat(
    }
import static org.opensearch.test.NodeRoles.onlyRole;
        applyDisruptionSchemeToNode(nodeAndClient);
            if (nodeEnv.hasNodeFile()) {  
            stopCurrentClusterManagerNode();  
        final Settings.Builder updatedSettings = Settings.builder();
                );
        private final String name;
    /**  
                    indexService.getIndexSettings().getSettings().getAsInt(IndexMetadata.SETTING_NUMBER_OF_SHARDS, -1),
                    final int targetShard = operationRouting.indexShards(clusterService.state(), index.getName(), null, routing)
        final List<NodeAndClient> nodes = new ArrayList<>();  
        }
        final Function<Client, Client> clientWrapper,
                    for (IndexShard indexShard : indexService) {
            .filter(key -> key.equals(Environment.PATH_DATA_SETTING.getKey()) || key.equals(Environment.PATH_SHARED_DATA_SETTING.getKey()));
        // randomize tcp settings  
    public List<String> startDataOnlyNodes(int numNodes, Settings settings, Boolean ignoreNodeJoin) {  
        if (reuseExisting && nodeAndClient != null) {
        return getInstance(clazz, DATA_NODE_PREDICATE);
        }
import org.opensearch.index.engine.EngineTestCase;
            if (callback.clearData(name)) {
                    nodeClient = node.client();  
            .get()
        assertOpenTranslogReferences();
            }
        }  
import java.io.Closeable;  
        logger.trace("validating cluster formed, expecting {}", expectedNodes);
                            throw new AssertionError(
        return startNodes(numNodes, Settings.builder().put(searchOnlyNode(settings)).build());
            if (numDataAndClusterManagerNodes() != numClusterManagerNodes()) {  
                        "pending coordinating bytes [" + coordinatingBytes + "] bytes on node [" + nodeAndClient.name + "]."
import static org.junit.Assert.assertThat;
            autoManageClusterManagerNodes,
    /**
                    Files.write(configPath.resolve(UNICAST_HOSTS_FILE), discoveryFileContents);
            builder.put(settings);
        NodeAndClient randomNodeAndClient = getRandomNodeAndClient(new NodeNamePredicate(getClusterManagerName()).negate());  
        // Close IndexInput reference file to avoid file leaks during node restart  
        if (minNumDataNodes < 0 || maxNumDataNodes < 0) {
                                + docsOnPrimary.size()
                // in an assertBusy loop, so it will try for 10 seconds and
    }
            .filter(entry -> CLUSTER_MANAGER_NODE_PREDICATE.test(entry.getValue()))
        ensureOpen();
        // always reduce this - it can make tests really slow  
            .put(settings)  
        final boolean autoManageClusterManagerNodes,  
    }
            );
                                assertFalse(  
                .allMatch(s -> DiscoveryNode.isClusterManagerNode(s) == false || ZEN2_DISCOVERY_TYPE.equals(DISCOVERY_TYPE_SETTING.get(s)))  
        for (NodeAndClient nodeAndClient : nodes.values()) {
    }
    }
        if (size < n) {
    }
                    false,
        nodeAndClient.node.settings()
                    false,
                newSettings.add(settings);
        }  
                MappingUpdatedAction.INDICES_MAPPING_DYNAMIC_TIMEOUT_SETTING.getKey(),  
        }
     */
         * If this returns <code>true</code> all data for the node with the given node name will be cleared including
            }  
            }
 */
                activeDisruptionScheme.removeFromNode(nodeAndClient.name, this);
         * an active client to the node that will be restarted next.  
    }
                            continue;
                    "Fielddata size must be 0 on node: " + stats.getNode(),  
            return new Iterator<Client>() {
        String suffix = "";  
        public boolean test(NodeAndClient nodeAndClient) {
import static org.junit.Assert.fail;
    }
                for (var indexShardRoutingTable : indexRoutingTable.shards().values()) {  
                                + "] vs replica=["
        }
        final boolean autoManageClusterManagerNodes,
            builder.put(TransportReplicationAction.REPLICATION_RETRY_TIMEOUT.getKey(), timeValueSeconds(retryTimeoutSeconds));  
     * Replace all nodes by stopping all current node and starting new node.
 * license agreements. See the NOTICE file distributed with
     * Starts multiple nodes with the given settings and returns their names
        return getRandomNodeAndClient(DATA_NODE_PREDICATE).client();
import java.util.concurrent.ExecutionException;
                            .put(settings)
                    }  
            DiscoveryNodes discoveryNodes = clusterService().state().getNodes();
    }
        private final AtomicBoolean closed = new AtomicBoolean(false);  
 * InternalTestCluster manages a set of JVM private nodes and allows convenient access to them.
        startCoordinatingOnlyNode(settings);  
        builder.put(TransportSettings.PORT.getKey(), 0);  
            + activeDisruptionScheme  
import org.opensearch.tasks.TaskManager;
        assertNoPendingIndexOperations();  
                    final Path[] locations = nodeEnv.nodeDataPaths();
        }
    }
        final boolean randomlyAddDedicatedClusterManagers,
                        assertThat(replicaShardRouting + " seq_no_stats mismatch", seqNoStats, equalTo(primarySeqNoStats));  
    }
        return startNode(Settings.builder().put(settings).put(searchOnlyNode(settings)).build());
        }
        this.nodeConfigurationSource = nodeConfigurationSource;
}
                            .build()
    private void applyDisruptionSchemeToNode(NodeAndClient nodeAndClient) {  
 * to the async nature of OpenSearch in combination with randomized testing. Once Threads and asynchronous calls
                        logger.info("Successfully wiped data directory for node location: {}", path);  
        return startNode(Settings.EMPTY);
    public List<String> startNodes(int numOfNodes) {  
                for (IndexService indexService : indexServices) {
        final List<NodeAndClient> toClose = new ArrayList<>();  
                for (final Path configPath : configPaths) {
import java.util.concurrent.TimeUnit;
        void startNode() {
        throw new AssertionError("No node found with name: [" + nodeName + "]");
                RandomNumbers.randomIntBetween(random, 2, 5)  
     */
                                    indexShard.routingEntry().toString() + " has unreleased snapshotted index commits",
            } catch (IOException e) {  
        this.forbidPrivateIndexSettings = forbidPrivateIndexSettings;
                );
            assert nodes.containsKey(nodeAndClient.name);  
        assert nodes.isEmpty();  
        /**
                final CircuitBreakerService breakerService = getInstanceFromNode(CircuitBreakerService.class, nodeAndClient.node);
                        + ClusterName.CLUSTER_NAME_SETTING.getKey()
        throw new AssertionError("No cluster-manager client found");
        assert Thread.holdsLock(this);  
     */  
                throw new AssertionError("interrupted while starting nodes", e);  
            RandomNumbers.randomIntBetween(random, 1, 4)
        Builder builder = Settings.builder();  
                dataDirToClean.addAll(Arrays.asList(nodeEnv.nodeDataPaths()));
        return startNodes(false, extraSettings);
    }  
            throw new UncheckedIOException(e);
    }
        Node node() {  
        }  
    private static final Predicate<NodeAndClient> WARM_AND_DATA_NODE_PREDICATE = nodeAndClient -> DiscoveryNode.hasRole(  
        }
        }
    static final int DEFAULT_MIN_NUM_CLIENT_NODES = 0;
            TransportService transportService = nodeAndClient.node.injector().getInstance(TransportService.class);
                .put(newSettings)
                node.close();
        NodeAndClient nodeAndClient = getRandomNodeAndClient(WARM_NODE_PREDICATE);
                // requests from other clusters because Jenkins is running
 * the Apache License, Version 2.0 (the "License"); you may
                throw new IllegalStateException(  
    public synchronized void fullRestart(RestartCallback callback) throws Exception {
                    false,
    }
    @Override  
        return getInstances(clazz, DATA_NODE_PREDICATE.or(CLUSTER_MANAGER_NODE_PREDICATE));  
            throw new ClusterManagerNotDiscoveredException("Cluster manager node not discovered");  
        return plugins;
        DiscoveryNodeRole.WARM_ROLE  
     */
     * Returns the name of the current cluster-manager node in the cluster and executes the request via the node specified
     */
    }
        return startNodes(Collections.nCopies(numOfNodes, settings).toArray(new Settings[0]));
        buildNode.startNode();
            numClientNodes,  
         * Executed once the give node name has been stopped.
        stopNodesAndClients(Collections.singleton(nodeAndClient));
    }  
        }  
     */
                    );
     *
        private final String nodeName;
                activeDisruptionScheme.removeFromCluster(this);  
    }  
            .filter(DiscoveryNode::isClusterManagerNode)
                    false,
        for (NodeAndClient nodeAndClient : nodes.values()) {
                            final Engine engine = IndexShardTestCase.getEngine(indexShard);
import static org.apache.lucene.tests.util.LuceneTestCase.TEST_NIGHTLY;
        for (int i = 0; i < sharedNodesSeeds.length; i++) {
        for (int i = 0; i < numOfNodes; i++) {
                                .stream()
                    p.getName(),
        assertTrue(
        return builder.build();
                        AddVotingConfigExclusionsAction.INSTANCE,
                }
                                + primaryShardRouting
        }
                autoBootstrapClusterManagerNodeIndex = RandomNumbers.randomIntBetween(random, 0, numSharedDataNodes - 1);
                );
        ensureOpen();
        void resetClient() {  
    private synchronized NodeAndClient getRandomNodeAndClient(Predicate<NodeAndClient> predicate) {
    public String getClusterManagerName() {  
     */
            );  
            return null;
        nodeAndClient.node.settings(),
                Client client = getRandomNodeAndClient(node -> excludedNodeIds.contains(node.name) == false).client();
         * closes the node and prepares it to be restarted
            NodeEnvironment env = nodeAndClient.node().getNodeEnvironment();  
    public void fullRestart() throws Exception {
            toStartAndPublish.add(nodeAndClient);
                    false,  
            validateClusterFormed();
                    }
            activeDisruptionScheme.applyToNode(nodeAndClient.name, this);  
                    false,
                    List<String> nodeNames = new ArrayList<>();
    public synchronized void wipePendingDataDirectories() {  
            startNodes(n - size, Settings.builder().put(onlyRole(Settings.EMPTY, DiscoveryNodeRole.WARM_ROLE)).build());
    public Set<String> getDataNodeNames() {  
        public void close() throws IOException {  
                    throw new AssertionError(
     * Returns an Iterable to all instances for the given class &gt;T&lt; across all data and cluster-manager nodes
                            nodeNames.add(Node.NODE_NAME_SETTING.get(nodeSettings));
    public String startDataOnlyNode() {  
import com.carrotsearch.randomizedtesting.generators.RandomPicks;  
    /**
    public InetSocketAddress[] httpAddresses() {
                // update once cluster-managers have joined  
     * Returns a reference to a node's {@link ClusterService}. If the given node is null, a random node will be selected.
                    false,
    public Client client(String nodeName) {  
    private <T> Iterable<T> getInstances(Class<T> clazz, Predicate<NodeAndClient> predicate) {  
            for (final IndexRoutingTable indexRoutingTable : state.routingTable().indicesRouting().values()) {  
        logger.info("changing cluster size from {} data nodes to {}", size, n);
        return nodes.values()  
    }
            final NodeAndClient previous = removeNode(nodeAndClient);  
        if (settings.hasValue("nodes.roles")) {
        warmAndDataRoles.add(DiscoveryNodeRole.DATA_ROLE);
            nodes.add(nodeAndClient);
    private void restartNode(NodeAndClient nodeAndClient, RestartCallback callback) throws Exception {
                }
    }
            final Collection<NodeAndClient> nodesAndClients = nodes.values();
                + bootstrapClusterManagerNodeIndex;  
        }
    public int numDataNodes() {
            Settings callbackSettings = callback.onNodeStopped(name);
        return instances;  
     */  
     * fully shared cluster to be more reproducible */
                    }
     * Restarts all nodes in the cluster. It first stops all nodes and then restarts all the nodes again.
                    false,  
        if (autoManageClusterManagerNodes) {
                    "Not all cluster-managers in same term" + debugString,  
        return getOrBuildRandomNode().client();
                CommonStatsFlags flags = new CommonStatsFlags(Flag.FieldData, Flag.QueryCache, Flag.Segments);
            Set<String> nodes = new HashSet<>();
            this.numSharedCoordOnlyNodes = 0;  
import org.opensearch.core.common.unit.ByteSizeValue;
                                .values()  
                }  
    /**
        builder.put(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_SETTING.getKey(), randomFrom(random, "write", "metadata_write"));  
        }
import org.opensearch.indices.IndicesService;  
        updatedSettings.put(NodeEnvironment.NODE_ID_SEED_SETTING.getKey(), seed);
    }
        for (int i = 0; i < numOfNodes; i++) {
            if (transportService instanceof MockTransportService) {  
        updatedSettings.put(Environment.PATH_HOME_SETTING.getKey(), baseDir);  
    public void assertNoInFlightDocsInEngine() throws Exception {  
                        throw new IOException("Node didn't close within 10 seconds.");
                    false,
import org.opensearch.core.index.Index;  
                    final List<DocIdSeqNoAndSource> docsOnPrimary;
            // we clone this here since in the case of a node restart we might need it again
    public synchronized void ensureAtLeastNumWarmNodes(int n) {  
                    final Map<String, Long> syncGlobalCheckpoints;
        }
                        try {
     */
            try {
    }
import java.util.stream.Stream;  
            }
 */  
        Random random = new Random(clusterSeed);
            validateClusterFormed();
        DiscoveryNodeRole.WARM_ROLE
            assert stoppingClusterManagers <= currentClusterManagers : currentClusterManagers + " < " + stoppingClusterManagers;  
                timeValueSeconds(RandomNumbers.randomIntBetween(random, 10, 30)).getStringRep()
        final int numClientNodes,
import static org.hamcrest.Matchers.equalTo;
        // from failing on nodes without enough disk space  
                    final SeqNoStats primarySeqNoStats;  
                logger.info("adding voting config exclusions {} prior to restart/shutdown", excludedNodeNames);
import static org.junit.Assert.assertFalse;
                    if (node.awaitClose(10, TimeUnit.SECONDS) == false) {  
                // all nodes know about all other nodes
                    } catch (IOException e) {
     */
                }
        final List<NodeAndClient> toStartAndPublish = new ArrayList<>(); // we want to start nodes in one go
        for (NodeAndClient nodeAndClient : nodes.values()) {  
            };
        while (values.hasNext() && numNodesAndClients++ < size - n) {
        final String nodePrefix,
        public String getName() {
            + "]. call clearDisruptionScheme first";
                    }, 1, TimeUnit.MINUTES);  
                IOUtils.close(nodes.values());  
import org.opensearch.index.engine.Engine;  
    }
            }
        if (clusterManagerNode == null) {
                    false
     */
        warmAndDataRoles.add(DiscoveryNodeRole.WARM_ROLE);
     * stages of the restart.  
import org.opensearch.cluster.node.DiscoveryNode;
                assert excludedNodeNames.size() == stoppingClusterManagers;
                        .shardId()  
            Settings settings = Settings.builder()
                }
 * under the License.  
        try {  
        List<Settings> newSettings = new ArrayList<>();  
                } else {
    private void assertOpenTranslogReferences() throws Exception {  
    public synchronized Client coordOnlyNodeClient() {
                    for (Settings nodeSettings : allNodesSettings) {  
            builder.put(HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_TYPE_SETTING.getKey(), "noop");
                    }  
    private final int numSharedDataNodes;
    }
     * Returns a reference to a random nodes instances of the given class &gt;T&lt;
            if (DiscoveryNode.isClusterManagerNode(settings) == false) {  
     * Restarts a random data node in the cluster and calls the callback during restart.
            assert Thread.holdsLock(InternalTestCluster.this);  
        // test that have ongoing write operations after the test (for example because ttl is used  
/**  
 * You may obtain a copy of the License at  
    public Collection<Class<? extends Plugin>> getPlugins() {
        final Set<String> nodes = Sets.newHashSet(nodeNames);
                    newSettings.putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey());
                    throw new AssertionError(
                    } catch (AlreadyClosedException ex) {
    /**  
            }
    private final int numSharedCoordOnlyNodes;  
    }
                                IndexShardTestCase.getTranslog(indexShard).getDeletionPolicy().assertNoOpenTranslogRefs();
                assertThat(
 * compatible open source license.
        }
        private void markNodeDataDirsAsPendingForWipe(Node node) {  
    }
                }  
         * gateways and all index data. Returns <code>false</code> by default.  
import java.util.stream.IntStream;
                nextNodeId.get(),
        scheme.applyToCluster(this);
                        + ClusterName.CLUSTER_NAME_SETTING.getKey()
            + numSharedDataNodes + numSharedCoordOnlyNodes; i++) {
            onTransportServiceStarted.run(); // reusing an existing node implies its transport service already started  
import com.carrotsearch.randomizedtesting.SeedUtils;
                    false,
    ) && DiscoveryNode.isDataNode(nodeAndClient.node.settings());  
            if (nodePrefix.equals(OpenSearchIntegTestCase.SUITE_CLUSTER_NODE_PREFIX)  
        this.clientWrapper = clientWrapper;
    }
        stopAllNodes();
                        }
        });
        );
            for (String nodeName : getNodeNames()) {
        return builder.toString();  
                for (IndexService indexService : indexServices) {
        && DiscoveryNode.isDataNode(nodeAndClient.node.settings()) == false;
            } else {
        if (this.open.compareAndSet(true, false)) {  
                    );  
            autoManageClusterManagerNodes ? "auto-managed" : "manual"
            assert Thread.holdsLock(InternalTestCluster.this);
                timeValueMillis(RandomNumbers.randomIntBetween(random, 750, 10000000)).getStringRep()
        final boolean usingSingleNodeDiscovery = discoveryType.equals("single-node");
            maxNumDataNodes,  
        // clean up what the nodes left that is unused  
    private int getClusterManagerNodesCount() {
        return getInstance(clazz, nc -> true);
import java.io.IOException;
            }
                final long coordinatingBytes = indexingPressure.getCurrentCoordinatingBytes();
        List<T> instances = new ArrayList<>();
        return warmDataNodeAndClients().size();
        assertBusy(() -> {
            final Settings newSettings = nodeAndClient.closeForRestart(callback, minClusterManagerNodes);  
            newSettings.put(callbackSettings);
        this.bootstrapClusterManagerNodeIndex = bootstrapClusterManagerNodeIndex;
            } else {  
     */
                    this.numSharedDedicatedClusterManagerNodes = DEFAULT_HIGH_NUM_CLUSTER_MANAGER_NODES;
        if (random.nextBoolean()) {
            }
                assertThat(  
                            // shard is closed
    }
        if (settings != null) {
     */
            for (ShardRouting shardRouting : allShards) {  
        final Settings extraSettings,  
            RecoverySettings.INDICES_RECOVERY_RETRY_DELAY_STATE_SYNC_SETTING.getKey(),
            builder.put(TransportSettings.CONNECTIONS_PER_NODE_RECOVERY.getKey(), random.nextInt(2) + 1);
            validateClusterFormed();
     * stop any of the running nodes.
                wipePendingDataDirectories();  
        Builder builder = Settings.builder();  
        assertBusy(() -> {
        // only reset the clients on nightly tests, it causes heavy load...  
     * Starts multiple nodes with default settings and returns their names
     * Stops the current cluster-manager node forcefully.
    }
    }
 * SPDX-License-Identifier: Apache-2.0
    }
                    try {
        return nodes.values().stream().map(node -> getInstanceFromNode(clazz, node.node)).collect(Collectors.toList());
                    }
     */
    );
            return nodeAndClient;
                    flags,  
    public static final RestartCallback EMPTY_CALLBACK = new RestartCallback();
        final boolean randomlyAddDedicatedClusterManagers,
        return startNodes(numNodes, Settings.builder().put(onlyRoles(settings, warmAndDataRoles)).build());  
                }
        // trash all nodes with id >= sharedNodesSeeds.length - they are non shared
import org.opensearch.node.NodeValidationException;
        int numNodesAndClients = 0;  
                        + "]"
        final int numClientNodes,
        NodeAndClient(String name, MockNode node, Settings originalNodeSettings, int nodeAndClientId) {
        }  
            true
                }
        return () -> {
        int totalDataNodes = numDataNodes();  
                onTransportServiceStarted.run();
    public synchronized void ensureAtLeastNumWarmAndDataNodes(int n) {
import org.opensearch.cluster.ClusterName;  
                final Collection<NodeAndClient> currentNodes = nodes.values();  
        assertBusy(() -> {
        int size = numWarmAndDataNodes();  
        for (int i = 0; i < numSharedDedicatedClusterManagerNodes + numSharedDataNodes + numSharedCoordOnlyNodes; i++) {
    }
            try {
        if (size < n) {
     */  
 */
    }
            .map(  
        }  
            // use a new seed to make sure we generate a fresh new node id if the data folder has been wiped  
                resetClient();  
        // dependencies. HashSet here would make order JVM-allocation-hash dependent and lead to
        return getClusterManagerName(null);
 *  
        if (randomNodeAndClient != null) {
     */  
                    newSettings.add(settings);
    public List<String> startWarmOnlyNodes(int numNodes, Settings settings) {
import org.opensearch.index.engine.InternalEngine;  
        final NodeConfigurationSource nodeConfigurationSource,  
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
                forbidPrivateIndexSettings
        }
    public void beforeIndexDeletion() throws Exception {  
        final Settings nodeSettings = Settings.builder()
                    "classpath plugin",  
            .collect(Collectors.toSet());  
        if (random.nextBoolean()) {
        reset(wipeData);  
 * </p>  
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
        }
            String ctx = randomFrom(random, ScriptModule.CORE_CONTEXTS.keySet());
     * filter.  
    public <T> Iterable<T> getDataNodeInstances(Class<T> clazz) {
        return startNode(noRoles(settings));  
    /**  
import static org.opensearch.discovery.DiscoveryModule.ZEN2_DISCOVERY_TYPE;  
     * Returns an Iterable to all instances for the given class &gt;T&lt; across all nodes in the cluster.
                states.forEach(cs -> {
            List<ShardRouting> allShards = clusterService().state().routingTable().allShards(index);  
        assert Thread.holdsLock(this);
        assertBusy(() -> {  
            logger.info("Stopping and resetting node [{}] ", nodeAndClient.name);
    ) {
                    .filter(Objects::nonNull)  
    public List<String> startWarmOnlyNodes(int numNodes) {
package org.opensearch.test;
        NodeAndClient nodeAndClient = nodes.get(nodeName);
            }
                                    + String.join("\n --> ", operations)  
    }
        String name = settings.get("node.name");
                    RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(),  
        ensureOpen(); // currently unused
        // turning on the real memory circuit breaker leads to spurious test failures. As have no full control over heap usage, we  
        if (randomNodeAndClient != null) {
    }
        }
    public synchronized void clearDisruptionScheme(boolean ensureHealthyCluster) {
        final int newSize = sharedNodesSeeds.length;  
import java.util.TreeMap;
    public int numDataAndClusterManagerNodes() {
     */
        if (random.nextInt(10) == 0) { // 10% of the nodes have a very frequent check interval
    private void ensureOpen() {  
            && Arrays.stream(extraSettings)
    }
        startAndPublishNodesAndClients(toStartAndPublish);  
import static org.opensearch.test.NodeRoles.searchOnlyNode;
            }
                    );
    public synchronized void beforeTest(Random random) throws IOException, InterruptedException {  
        if (!open.get()) {
        }  
        } catch (IOException e) {
                } catch (InterruptedException | ExecutionException e) {
    @Override  
     */  
        executor = OpenSearchExecutors.newScaling(
            // Clear file cache to avoid file leaks during node stop
import org.opensearch.common.lease.Releasables;  
            if (indexService != null) {  
        startAndPublishNodesAndClients(nodes);
    /**  
     * will not start any additional nodes.  
        }
        for (NodeAndClient nodeAndClient : filteredNodes) {  
            return Settings.EMPTY;
     * Restarts a node.  
                }
    private final String nodePrefix;
    }  
                    final IndexShard primaryShard = getShardOrNull(state, primaryShardRouting);
        Settings settings = nodeConfigurationSource.nodeSettings(nodeOrdinal);  
            1 + random.nextInt(Math.min(4, Runtime.getRuntime().availableProcessors()))
     * Restarts all nodes in a rolling restart fashion ie. only restarts on node a time.  
                    .map(n -> n.getAddress().toString())
                closed.set(true);
                        }
                    }
            }  
import java.net.InetSocketAddress;  
     */  
                if (primaryBytes > 0) {  
                throw new AssertionError("unexpected", e);
            nodes.isEmpty() || nodes.values().stream().anyMatch(NodeAndClient::isClusterManagerEligible)
            } catch (ExecutionException e) {
                    stats.getIndices().getSegments().getBitsetMemoryInBytes(),
                                    + nodeAndClient.name
    synchronized String routingKeyForShard(Index index, int shard, Random random) {
import org.apache.logging.log4j.LogManager;  
        }  
            sharedNodesSeeds[i] = random.nextLong();  
            .filter(entry -> DATA_NODE_PREDICATE.test(entry.getValue()))
        } else {
                }
                    "Query cache size must be 0 on node: " + stats.getNode(),
    public List<String> startClusterManagerOnlyNodes(int numNodes) {
        throw new AssertionError("No smart client found");
import org.opensearch.search.SearchService;
    }
                        long bytesUsed = inFlightRequestsBreaker.getUsed();  
        for (NodeAndClient nodeAndClient : nodes.values()) {
    }
    @Override
     * If {@link #bootstrapClusterManagerNodeIndex} is -1 (default), this method does nothing.  
                    logger.error("Could not assert finished requests within timeout", e);
        if (wipeData) {
        assert autoManageClusterManagerNodes == false || bootstrapClusterManagerNodeIndex == -1
    /**
import static org.opensearch.test.OpenSearchTestCase.randomBoolean;  
    }
            .node()
            try {  
        return startDataOnlyNode(Settings.EMPTY);
    private final Collection<Class<? extends Plugin>> mockPlugins;
    public synchronized void close() throws IOException {
import org.opensearch.common.settings.SecureSettings;  
            numSharedCoordOnlyNodes,
import org.opensearch.action.admin.cluster.configuration.ClearVotingConfigExclusionsAction;  
    private void assertAllPendingWriteLimitsReleased() throws Exception {  
            return getOrBuildNodeClient();
        final Settings[] newNodeSettings = new Settings[nextNodeId.get()];  
        int totalClusterManagerNodes = numClusterManagerNodes();
            if (closed.get() == false) {
        return startNodes(numOfNodes, Settings.EMPTY);
                    throw new RuntimeException("already closed");  
        if (nodeAndClient != null) {
    }
        MockNode node = new MockNode(settings, pluginInfos, nodeConfigurationSource.nodeConfigPath(nodeId), forbidPrivateIndexSettings);  
        }
        logger.info("Closing cluster-manager node [{}] ", clusterManagerNodeName);  
                    stats.getIndices().getFieldData().getMemorySizeInBytes(),
                .put(
            .map(Node.NODE_NAME_SETTING::get)
            nodeConfigurationSource,
    private static String getRoleSuffix(Settings settings) {
    @Override
        Settings settings1 = Settings.builder().put(settings).put(dataOnlyNode(settings)).build();
import static org.hamcrest.Matchers.nullValue;  
     * Ensures that at least <code>n</code> data nodes are present in the cluster.
            throw new RuntimeException("Cluster is already closed");
 */
    }
        return startNode(settings1);  
    /**
                        new AddVotingConfigExclusionsRequest(excludedNodeNames.toArray(Strings.EMPTY_ARRAY))
    /**
        NodeAndClient randomNodeAndClient = getRandomNodeAndClient(NO_DATA_NO_CLUSTER_MANAGER_PREDICATE);  
                activeDisruptionScheme.testClusterClosed();
import org.opensearch.core.index.shard.ShardId;
        if (activeDisruptionScheme != null) {
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING.getKey(),
    public int numClusterManagerNodes() {  
     */
                }
                    randomBoolean() ? DEFAULT_WARM_CACHE_SIZE_PERCENT : DEFAULT_WARM_CACHE_SIZE_BYTES
                        continue;
            for (NodeAndClient nodeAndClient : nodes.values()) {
    /**
        int autoBootstrapClusterManagerNodeIndex = autoManageClusterManagerNodes
    }  
                } catch (Exception e) {  
        if (nodeAndClient != null) {  
        }
            } else {  
            "Cluster is consistent again - nodes: [{}] nextNodeId: [{}] numSharedNodes: [{}]",  
                dataDirToClean.clear();  
        final String discoveryType = DISCOVERY_TYPE_SETTING.get(updatedSettings.build());  
        /** returns true if the restart should also validate the cluster has reformed */  
        }, 60, TimeUnit.SECONDS);
        }
import java.util.NavigableMap;  
        super.beforeTest(random);
            ? numSharedDedicatedClusterManagerNodes  
    }
            if (!DiscoveryNode.isClusterManagerNode(settings) && !DiscoveryNode.isDataNode(settings)) {  
    }
                for (IndexShard indexShard : indexService) {
import org.opensearch.common.util.io.IOUtils;
    }
    private NodeAndClient getOrBuildRandomNode() {  
    /**  
            OpenSearchExecutors.NODE_PROCESSORS_SETTING.getKey(),  
            return;
     */
     */
            final int currentClusterManagers = getClusterManagerNodesCount();  
import org.apache.lucene.store.AlreadyClosedException;
    public synchronized void stopRandomNodeNotCurrentClusterManager() throws IOException {
            numSharedDedicatedClusterManagerNodes,
            }  
        final HashSet<String> set = new HashSet<>();  
 * The Cluster is bound to a test lifecycle where tests must call {@link #beforeTest(java.util.Random)} and
import java.util.function.Function;
                "Cluster hasn't changed - moving out - nodes: [{}] nextNodeId: [{}] numSharedNodes: [{}]",  
import java.util.Collections;  
            if (closed.get() == false) {  
                    onTransportServiceStarted.run();
                CircuitBreaker fdBreaker = breakerService.getBreaker(CircuitBreaker.FIELDDATA);  
        }
     * Updates are intended to follow a copy-on-write approach. */
    }  
        if (random.nextBoolean()) { // sometimes set a
            toStartAndPublish.add(nodeAndClient);
        final int defaultMinClusterManagerNodes
        List<InetSocketAddress> addresses = new ArrayList<>();
    private final AtomicBoolean open = new AtomicBoolean(true);
                    Version.CURRENT,
        final long clusterSeed,  
                startNodes(n - size);
            .build();
        return startNode(settings1);  
    ) {
    public <T> T getClusterManagerNodeInstance(Class<T> clazz) {
            }
                nodes.keySet(),
                                    + "] should have finished. "
        Randomness.shuffle(toStartAndPublish);
                this.numSharedCoordOnlyNodes = RandomNumbers.randomIntBetween(
                for (var indexShardRoutingTable : indexRoutingTable.shards().values()) {
                }
                    .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), clusterManagerNodeNames)
                assertTrue(  
            final Settings nodeSettings = getNodeSettings(i, sharedNodesSeeds[i], Settings.EMPTY, defaultMinClusterManagerNodes);  
                    return iterator.next().client();
    }
            final int newClusterManagers = (int) nodeAndClients.stream()
        Builder builder = Settings.builder().put(defaultSettings).put(getRandomNodeSettings(nodeSeed));
    }
        ensureOpen();
            builder.put(  
import java.util.Iterator;
        }  
        FileCache fileCache = nodeAndClient.node().fileCache();
        }
        if (activeDisruptionScheme != null) {  
    private void assertNoSnapshottedIndexCommit() throws Exception {  
        final int numNodes = numDataNodes() - count;  
        if (random.nextBoolean()) {  
            IOUtils.close(secureSettings);
        }  
                )
    private static Settings getRandomNodeSettings(long seed) {
            assert Thread.holdsLock(InternalTestCluster.this);
                @Override
                    try {
        numDataPaths = random.nextInt(5) == 0 ? 2 + random.nextInt(3) : 1;
            }
        Client nodeClient() {
                .put(NodeEnvironment.NODE_ID_SEED_SETTING.getKey(), newIdSeed)
    }
        final NodeConfigurationSource nodeConfigurationSource,
            builder.put(others);
            .collect(Collectors.toList());
        int size = numWarmNodes();
    private synchronized void startAndPublishNodesAndClients(List<NodeAndClient> nodeAndClients) {  
            .map(entry -> entry.getKey())
import org.opensearch.common.settings.MockSecureSettings;
import org.opensearch.cluster.routing.IndexRoutingTable;
            Set<ShardId> shardIds = env.lockedShards();
                                .map(t -> t.taskInfo(nodeAndClient.name, true).toString())
                    future.get();  
    private final Set<Path> dataDirToClean = new HashSet<>();
    /**  
                && newClusterManagers > 0
         */
                // multiple ES testing jobs in parallel on the same machine.
        List<PluginInfo> pluginInfos = plugins.stream()
        public void doAfterNodes(int n, Client client) throws Exception {}
    }
            builder.put(TransportSettings.PING_SCHEDULE.getKey(), RandomNumbers.randomIntBetween(random, 100, 2000) + "ms");  
                );
    private synchronized void reset(boolean wipeData) throws IOException {
        nodeAndClient.startNode();
            builder.put(TransportSettings.CONNECTIONS_PER_NODE_BULK.getKey(), random.nextInt(3) + 1);  
            settings.add(getNodeSettings(firstNodeId + i, random.nextLong(), extraSettings[i], defaultMinClusterManagerNodes));
            logger.debug(
     * Performs cluster bootstrap when node with index {@link #bootstrapClusterManagerNodeIndex} is started  
            .findFirst()  
    }
        if (nodeAndClient != null) {
                        if (bytesUsed != 0) {
                }
            }
            && newClusterManagerCount > 0
                            );
    }  
import org.opensearch.plugins.PluginInfo;
import org.opensearch.common.util.set.Sets;  
                    false,
    private static final Predicate<NodeAndClient> CLUSTER_MANAGER_NODE_PREDICATE = nodeAndClient -> DiscoveryNode.isClusterManagerNode(  
        this.mockPlugins = mockPlugins;
    private volatile NavigableMap<String, NodeAndClient> nodes = Collections.emptyNavigableMap();
            if (DiscoveryNode.isClusterManagerNode(settings)) {  
                && autoManageClusterManagerNodes  
        final int firstNodeId = nextNodeId.getAndIncrement();
                                "All incoming requests on node ["
            ClusterService clusterService = getInstanceFromNode(ClusterService.class, node);
        if (nodeAndClient != null) {  
    }
        }  
        final int newClusterManagerCount = Math.toIntExact(Stream.of(extraSettings).filter(DiscoveryNode::isClusterManagerNode).count());
/*
                try {
                    .stream()  
        @Override
                            if (engine instanceof InternalEngine) {
        final String clusterName,
     * Restarts all nodes in the cluster. It first stops all nodes and then restarts all the nodes again.
    public void restartRandomDataNode() throws Exception {
     * this is important if a node is randomly shut down in a test since the next test relies on a  
                        if (replicaShard == null) {  
    public static final int DEFAULT_HIGH_NUM_CLUSTER_MANAGER_NODES = 3;
                nodeSettings = Settings.builder()
            .map(Node.NODE_NAME_SETTING::get)  
        };
                    CircuitBreaker.IN_FLIGHT_REQUESTS
            assert nodes.containsKey(nodeAndClient.name);
            builder.put(  
                    assertBusy(() -> {
                    false,
                final IndicesFieldDataCache fdCache = getInstanceFromNode(IndicesService.class, nodeAndClient.node)
        }  
        }  
                        syncGlobalCheckpoints = primaryShard.getInSyncGlobalCheckpoints();
        }
            // network request, because a network request can increment one
                CircuitBreaker inFlightRequestsBreaker = getInstance(CircuitBreakerService.class, nodeAndClient.name).getBreaker(
        private void clearDataIfNeeded(RestartCallback callback) throws IOException {  
import org.opensearch.index.seqno.SeqNoStats;
        assert newSize == numSharedDedicatedClusterManagerNodes + numSharedDataNodes + numSharedCoordOnlyNodes;
        return addresses.toArray(new InetSocketAddress[0]);  
            nextNodeId.get(),
                            }
            Integer.MAX_VALUE,
    private final String clusterName;  
     * if more nodes than <code>n</code> are present this method will not  
    }
                    updatedSettings.get(DiscoverySettings.INITIAL_STATE_TIMEOUT_SETTING.getKey()),  
            .stream()  
        nodes = Collections.unmodifiableNavigableMap(newNodes);
        return getInstanceFromNode(clazz, randomNodeAndClient.node);  
            validateClusterFormed();  
    /** calculates a min cluster-manager nodes value based on the given number of cluster-manager nodes */  
    }  
                }
                        if (DiscoveryNode.isClusterManagerNode(nodeSettings)) {
        // and not all docs have been purged after the test) and inherit from
import java.util.concurrent.Future;
        }
        /* Randomly return a client to one of the nodes in the cluster */
    }
        .isClusterManagerNode(nodeAndClient.node.settings()) == false  
        StringBuilder builder = new StringBuilder(prefix);
                    this.numSharedDedicatedClusterManagerNodes = DEFAULT_LOW_NUM_CLUSTER_MANAGER_NODES;  
        randomlyResetClients(); /* reset all clients - each test gets its own client based on the Random instance created above. */
    }
                for (Path path : dataDirToClean) {  
                builder.put(nodeSettings).build(),
            );
    }
        final String nodePrefix,  
import org.opensearch.core.common.breaker.CircuitBreaker;
        }
     */
        // turn it off for these tests.
                    false,
                    }  
                    null,
                final String name = nodeAndClient.name;
            newSize
        return filterNodes(nodes, WARM_NODE_PREDICATE);
                        logger.info("Failed to wipe data directory for node location: {}", path);
     */
 * ownership. Elasticsearch licenses this file to you under  
    }
                    Collections.emptyList(),  
    public Client smartClient() {
    }
            }
    }
        restartNode(nodeName, EMPTY_CALLBACK);  
                        try {  
        if (callback.validateClusterForming()) {
    /**
import org.opensearch.cluster.routing.OperationRouting;
                            throw new AssertionError(  
    }  
        }
 * not use this file except in compliance with the License.
        return set;  
        public boolean validateClusterForming() {
import org.opensearch.common.unit.TimeValue;  
        assert Thread.holdsLock(this);
            validateClusterFormed();
                && currentClusterManagers > 0  
            try {
import org.opensearch.index.store.remote.filecache.FileCache;
                    .put(nodeSettings)  
        if (size < n) {
            }
 * specific language governing permissions and limitations
                final long combinedBytes = indexingPressure.getCurrentCombinedCoordinatingAndPrimaryBytes();
        if (nodeAndClient != null) {
                    .filter(NodeAndClient::isClusterManagerEligible)
            );
                }
    }
                Releasables.close(nodeClient);
import org.apache.logging.log4j.Logger;
    public String getClusterName() {
        }
import org.opensearch.index.IndexService;  
            validateClusterFormed();  
            return randomNodeAndClient.nodeClient();
            numSharedDataNodes,  
            }
                    for (IndexShard indexShard : indexService) {  
            builder.put(MappingUpdatedAction.INDICES_MAX_IN_FLIGHT_UPDATES_SETTING.getKey(), RandomNumbers.randomIntBetween(random, 1, 10));  
                    .map(node -> getInstanceFromNode(ClusterService.class, node.node()))
    public String startSearchOnlyNode() {
        // randomize start up order
        assertThat(shard, greaterThanOrEqualTo(0));
                firstNodeId + i,  
        if (random.nextBoolean()) {
            );
    public synchronized void assertAfterTest() throws Exception {
import org.opensearch.index.shard.IndexShard;  
            if (numSharedDedicatedClusterManagerNodes > 0) {
     * Returns a node client to the current cluster-manager node.  
import org.opensearch.index.IndexingPressure;
        nodeAndClient.node.settings()
     * returns a suffix string based on the node role. If no explicit role is defined, the suffix will be empty  
                markNodeDataDirsAsPendingForWipe(node);  
                        if (replicaShard == null) {  
                while (totalDataNodes > 0) {
        final Settings settings = getNodeSettings(nodeId, random.nextLong(), Settings.EMPTY, 1);  
                        assertTrue(repositoriesMetadata != null && !repositoriesMetadata.repositories().isEmpty());  
        int size = numDataNodes();
    }
        final Stream<NodeAndClient> collection = n == 0
                }
            }
        final Iterator<String> iterator = dataNodes.keySet().iterator();
        if (bootstrapClusterManagerNodeIndex == -1) { // fast-path
                    for (ShardRouting replicaShardRouting : indexShardRoutingTable.replicaShards()) {
        activeDisruptionScheme = scheme;  
                        try {
 * Licensed to Elasticsearch under one or more contributor  
                    DiscoveryNode discoveryNode = discoveryNodes.get(shardRouting.currentNodeId());
                if (success == false) {  
    }
    private void stopNodesAndClient(NodeAndClient nodeAndClient) throws IOException {  
     */
        }  
            instances.add(getInstanceFromNode(clazz, nodeAndClient.node));
                // Anything that uses transport or HTTP can increase the
            int initialMillisBound = RandomNumbers.randomIntBetween(random, 10, 100);  
                    throw new AssertionError("Exception during check for request breaker reset to 0", e);  
                builder.put(
                    false, // fileCacheDetailed
                // request breaker (because they use bigarrays), because of
                // Clean up the cache, ensuring that entries' listeners have been called
                                );  
     */
                    client().execute(  
                    false,  
            "Setup InternalTestCluster [{}] with seed [{}] using [{}] dedicated cluster-managers, "
        public boolean clearData(String nodeName) {
     */
                        try {  
     */  
     */
            wipePendingDataDirectories();
                        } catch (AlreadyClosedException e) {  
            } catch (InterruptedException e) {
        return null;
        if (random.nextInt(10) == 0) {
        return filterNodes(nodes, DATA_NODE_PREDICATE.or(CLUSTER_MANAGER_NODE_PREDICATE)).size();  
        final int nodeId,
        return getInstances(clazz, DATA_NODE_PREDICATE);  
        DiscoveryNode clusterManagerNode = client.admin().cluster().prepareState().get().getState().nodes().getClusterManagerNode();
    public <T> Iterable<T> getDataOrClusterManagerNodeInstances(Class<T> clazz) {
                .filter(NodeAndClient::isClusterManagerEligible)  
    /**
        final Function<Client, Client> clientWrapper
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
        return newSettings;  
        return node.injector().getInstance(clazz);
            clearDataIfNeeded(callback);
        nodeAndClient.recreateNode(newSettings, () -> rebuildUnicastHostFiles(Collections.singletonList(nodeAndClient)));  
            stopNodesAndClient(nodeAndClient);
        Predicate<NodeAndClient> predicate
     * stop any of the running nodes.
                }
import org.opensearch.env.Environment;
    /**
     */
        Collection<PluginInfo> additionalNodePlugins = nodeConfigurationSource.additionalNodePlugins();
    /**
                try {  
    /**
            : numSharedDataNodes;
                final String debugString = ", expected nodes: " + expectedNodes + " and actual cluster states " + states;
    }  
                mockTransportService.clearAllRules();
        ensureOpen();  
        return false;
                }
    private void rebuildUnicastHostFiles(List<NodeAndClient> newNodes) {
        }  
                if (autoBootstrapClusterManagerNodeIndex == 0) {
            }  
     * in the viaNode parameter. If viaNode isn't specified a random node will be picked to the send the request to.  
            } finally {
    }
            final ClusterState state = clusterService().state();
        }  
    }  
    public List<String> startNodes(int numOfNodes, Settings settings, Boolean waitForNodeJoin) {
            try {
                });
                } catch (Exception e) {
                fdCache.getCache().refresh();
            builder.put(
                // TODO add cluster health API to check that voting configuration is optimal so this isn't always needed  
        }  
                        }
            }  
            }
        return filterNodes(nodes, NodeAndClient::isClusterManagerEligible).size();
    private Collection<NodeAndClient> warmDataNodeAndClients() {
            : "bootstrapClusterManagerNodeIndex should be -1 if autoManageClusterManagerNodes is true, but was "
     */
        assert !nodeAndClient.node().isClosed();
                p -> new PluginInfo(
                                    + pendingTasks
         */
            nextNodeId.get(),
                // first.  
                            } else if (IndexShardTestCase.getEngine(indexShard) instanceof InternalEngine) {  
import static org.opensearch.test.NodeRoles.dataOnlyNode;
            }
     * Asserts that the document history in Lucene index is consistent with Translog's on every index shard of the cluster.  
        if (randomNodeAndClient != null) {  
                    }
                                    + " on node ["  
    private static final Predicate<NodeAndClient> NO_DATA_NO_CLUSTER_MANAGER_PREDICATE = nodeAndClient -> DiscoveryNode
     * Stops a random node in the cluster that applies to the given filter. Does nothing if none of the nodes match the
    private final ExecutorService executor;
                getClusterManagerName()
            nodes.keySet(),
                } catch (InterruptedException e) {  
                                    + "; pending tasks ["
                        }
            RandomNumbers.randomIntBetween(random, 1, 5)
            activeDisruptionScheme.removeFromNode(nodeAndClient.name, this);  
    }
                autoBootstrapClusterManagerNodeIndex = RandomNumbers.randomIntBetween(random, 0, numSharedDedicatedClusterManagerNodes - 1);
                node.getClasspathPlugins(),  
    }  
        ensureOpen();
        logger.info("Restarting node [{}] ", nodeAndClient.name);  
        return null;  
        builder.append("-TEST_WORKER_VM=[").append(OpenSearchTestCase.TEST_WORKER_VM_ID).append(']');
            .filter(nc -> nc.name.equals(node))
                            continue;
            clusterSeed,
        if (autoManageClusterManagerNodes && newSize > 0) {
    }
        builder.put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "1b");  
        builder.put(ClusterName.CLUSTER_NAME_SETTING.getKey(), clusterName);  
        for (NodeAndClient nodeAndClient : nodes.values()) {
    }
                .put(originalNodeSettings)  
            try {
import org.opensearch.env.ShardLockObtainFailedException;
                        assertThat("Request breaker not reset to 0 on node: " + name, reqBreaker.getUsed(), equalTo(0L));  
                            if (IndexShardTestCase.getEngine(indexShard) instanceof IngestionEngine) {
            assert callbackSettings != null;
        final DiscoveryNode assignedNode = clusterState.nodes().get(shardRouting.currentNodeId());
            expectedNodes.add(getInstanceFromNode(ClusterService.class, nodeAndClient.node()).localNode());
                }  
                    });
    public int numWarmNodes() {
    public void setDisruptionScheme(ServiceDisruptionScheme scheme) {
        }
        }  
            return randomNodeAndClient.nodeClient(); // ensure node client non-cluster-manager is requested
                    env.shardLock(id, "InternalTestCluster assert after test", TimeUnit.SECONDS.toMillis(5)).close();
                    // use a dedicated cluster-manager, but only low number to reduce overhead to tests
    }  
    }  
        NodeAndClient nodeAndClient = nodes.get(nodeName);
            set.add(iterator.next());
                }
        super.assertAfterTest();
    public synchronized List<String> startNodes(Boolean waitForNodeJoin, Settings... extraSettings) {
    public String startNode() {  
    static final int DEFAULT_NUM_CLIENT_NODES = -1;
        return startNode(settings.build());
    private final Function<Client, Client> clientWrapper;  
        if (maxNumDataNodes < minNumDataNodes) {  
            ClusterState state = client().admin().cluster().prepareState().get().getState();
            FileCache fileCache = nodeAndClient.node().fileCache();  
    }
    }  
     * Note: use this with care tests should not rely on a certain nodes client.
            minNumDataNodes,
            rebuildUnicastHostFiles(nodeAndClients); // ensure that new nodes can find the existing nodes when they start
                if (nodeEnv.hasNodeFile()) {  
            }
            }
            return randomNodeAndClient;
        int numNodesRestarted = 0;  
                && getMinClusterManagerNodes(currentClusterManagers + newClusterManagers) > currentClusterManagers) {
        });  
    }
            .stream()
     * Returns an Iterable to all instances for the given class &gt;T&lt; across all data nodes in the cluster.  
        assert clusterManagerNode != null;
     */
    private final long[] sharedNodesSeeds;
                        final SeqNoStats seqNoStats;  
            )  
     * Returns a predicate that only accepts settings of nodes with one of the given names.
        for (NodeAndClient nodeAndClient : toStartAndPublish) {
                    throw new AssertionError("pending primary bytes [" + primaryBytes + "] bytes on node [" + nodeAndClient.name + "].");
                suffix = suffix + "c";
                    .distinct()
                        assertThat(  
 * automatically load asserting services tracking resources like file handles or open searchers.  
    public synchronized void ensureAtLeastNumDataNodes(int n) {  
                if (currentNodeId != bootstrapClusterManagerNodeIndex) {
                            continue; // shard is closed - just ignore
        final Runnable onTransportServiceStarted = () -> {}; // do not create unicast host file for this one node.  
        final List<Settings> updatedSettings = bootstrapClusterManagerNodeWithSpecifiedIndex(settings);
import org.opensearch.cluster.coordination.ClusterBootstrapService;  
    }
            this.originalNodeSettings = originalNodeSettings;
    }
    public void stopAllNodes() {
                        .getId();
                    for (Settings nodeSettings : getDataOrClusterManagerNodeInstances(Settings.class)) {  
        Map<String, NodeAndClient> dataNodes = nodes.entrySet()
    }  
                    false,  
    private String getNodePrefix(Settings settings) {  
            logger.info(
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
        final Path baseDir,
import org.opensearch.index.engine.DocIdSeqNoAndSource;
            RecoverySettings.INDICES_RECOVERY_MAX_CONCURRENT_OPERATIONS_SETTING.getKey(),
import org.opensearch.core.common.Strings;
        }
                ScriptService.SCRIPT_CACHE_EXPIRE_SETTING.getConcreteSettingForNamespace(ctx).getKey(),
        updatedSettings.put(Environment.PATH_SHARED_DATA_SETTING.getKey(), baseDir.resolve(name + "-shared"));
                        } catch (AlreadyClosedException ignored) {  
    }
                            seqNoStats = replicaShard.seqNoStats();
        if (Strings.hasLength(System.getProperty("tests.opensearch.logger.level"))) {
        throw new AssertionError("No non-cluster-manager client found");
        if (clusterService().state().routingTable().hasIndex(index)) {
    }
import java.util.Random;
     * with the names of all existing and new cluster-manager-eligible nodes.
    private final NodeConfigurationSource nodeConfigurationSource;
        if (excludedNodeIds.isEmpty() == false) {
    public ClusterService clusterService() {
     * Returns a "smart" node client to a random node in the cluster  
                false,
    /* Sorted map to make traverse order reproducible.
                }
    public synchronized void stopRandomNode(final Predicate<Settings> filter) throws IOException {
     * Stops a random warm node in the cluster. Returns true if a node was found to stop, false otherwise.
            0,  
    }  
                }
            if (autoManageClusterManagerNodes) {  
        publishNode(buildNode);
    /**  
        builder.put(TransportSettings.TRANSPORT_COMPRESS.getKey(), rarely(random));
                        } catch (AlreadyClosedException ignored) {
     * Starts a node with default settings and returns its name.
        // non-deterministic ITs (a sibling plugin's createComponents could run before the plugin  
                fileCache.clear();
            throw new IllegalStateException(e);
import java.util.concurrent.atomic.AtomicBoolean;  
            .filter(DiscoveryNode::isClusterManagerNode)
                nodes = Collections.emptyNavigableMap();
            nodeAndClient.recreateNode(newNodeSettings[nodeAndClient.nodeAndClientId()], () -> rebuildUnicastHostFiles(toStartAndPublish));  
                for (IndexService indexService : indexServices) {
    /* Each shared node has a node seed that is used to start up the node and get default settings
            int totalClusterManagerNodes = numClusterManagerNodes();
            final long currentClusterManagers = nodes.values().stream().filter(NodeAndClient::isClusterManagerEligible).count();  
                                seqNoStats.getGlobalCheckpoint(),
                }
     * Returns a reference to a random node's {@link ClusterService}  
        assert Thread.holdsLock(this);
                    IOUtils.rm(locations);  
            }
            TimeUnit.SECONDS,
        return updatedSettings.build();  
        }
                // all nodes have a cluster-manager
    public static class RestartCallback {
            List<Future<?>> futures = nodeAndClients.stream().map(node -> executor.submit(node::startNode)).collect(Collectors.toList());
            builder.put(  
        return nodes.size();  
                    throw new UnsupportedOperationException("");
    private int bootstrapClusterManagerNodeIndex = -1;
        }
        // start any missing node  
            if (nodeEnv.hasNodeFile()) {
        return startSearchOnlyNodes(numNodes, Settings.EMPTY);
        updatedSettings.put("node.name", name);  
                        not(equalTo(SequenceNumbers.UNASSIGNED_SEQ_NO))
        }  
        final int numOfNodes = extraSettings.length;
    }
    /**
                                + "] num_docs_on_primary=["  
                newSize  
            }  
                }
        updatedSettings.put(settings);
            }  
            } else {
                    false,  
        }
import static org.hamcrest.Matchers.not;
                            "out of sync shards: primary=["
import static org.opensearch.discovery.DiscoveryModule.DISCOVERY_TYPE_SETTING;
                try {
                    throw new AssertionError("pending combined bytes [" + combinedBytes + "] bytes on node [" + nodeAndClient.name + "].");  
            }
        return getRandomNodeAndClient(nc -> true);
    public void assertConsistentHistoryBetweenTranslogAndLuceneIndex() throws IOException {  
        NodeAndClient randomNodeAndClient = getRandomNodeAndClient(predicate);
        final int minNumDataNodes,
import org.opensearch.transport.client.Client;
    private final boolean autoManageClusterManagerNodes;  
                if (coordinatingBytes > 0) {  
    /**  
     * Returns a node client to random node but not the cluster-manager. This method will fail if no non-cluster-manager client is available.  
                    }
    // if set to 0, data nodes will also assume the cluster-manager role
                );  
                Stream<NodeAndClient> unicastHosts = Stream.concat(currentNodes.stream(), newNodes.stream());
        }
        }
                    .map(ClusterService::state)
        startClusterManagerOnlyNodes(totalClusterManagerNodes);
                try {
            }
                                    EngineTestCase.hasSnapshottedCommits(engine)
                        primarySeqNoStats = primaryShard.seqNoStats();  
            }
        builder.put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "1b");
        }  
    /**
                for (IndexService indexService : indexServices) {
    }
     * builds a new node
                        IndexShardTestCase.assertConsistentHistoryBetweenTranslogAndLucene(indexShard);  
                IntStream.range(0, numDataPaths)
import org.opensearch.cluster.node.DiscoveryNodes;  
    }  
    ) {
                        if (DiscoveryNode.isClusterManagerNode(nodeSettings)) {
        return settings -> nodes.contains(settings.get("node.name"));  
                    }
                && nodeAndClient.nodeAndClientId() < sharedNodesSeeds.length
                } else {  
                        "pending replica write bytes [" + combinedBytes + "] bytes on node [" + nodeAndClient.name + "]."  
        }
        nodeAndClient.node.settings(),
        );
                    if (shard == targetShard) {
        final Set<DiscoveryNode> expectedNodes = new HashSet<>();  
        }
            builder.put(TransportSettings.CONNECTIONS_PER_NODE_REG.getKey(), random.nextInt(6) + 1);
        // Default the watermarks to absurdly low to prevent the tests
                            String pendingTasks = taskManager.getTasks()
                Environment.PATH_DATA_SETTING.getKey(),
    /**  
     * Returns a set of nodes that have at least one shard of the given index.
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsAction;
            final long stoppingClusterManagers = nodeAndClients.stream().filter(NodeAndClient::isClusterManagerEligible).count();
    public List<String> startClusterManagerOnlyNodes(int numNodes, Settings settings) {  
    }
    /**
            && prevClusterManagerCount == 0  
            return null;  
import java.util.List;
    public static String clusterName(String prefix, long clusterSeed) {  
                    }  
    public <T> Iterable<T> getInstances(Class<T> clazz) {
    }
        if (TEST_NIGHTLY) {
    }  
        NodeAndClient nodeAndClient = getRandomNodeAndClient(InternalTestCluster.DATA_NODE_PREDICATE);
    }  
        private final Settings originalNodeSettings;
            return DiscoveryNode.isClusterManagerNode(node.settings());
        }  
                            }
        return nodes.keySet().toArray(Strings.EMPTY_ARRAY);
            }
    }
    /**  
    /**
            settings.add(removeRoles(nodeSettings, Collections.singleton(DiscoveryNodeRole.DATA_ROLE)));
                        );  
    }
     */
                    } catch (AlreadyClosedException ignored) {
            if (DiscoveryNode.isDataNode(settings)) {  
    @Override
            for (NodeAndClient nodeAndClient : nodes.values()) {
            if (closed.get()) {
                        + settings.get(ClusterName.CLUSTER_NAME_SETTING.getKey())  
                        }
            defaultMinClusterManagerNodes = -1;
        }
                // To combat this we check whether the breaker has reached 0  
                );  
            new ThreadContext(Settings.EMPTY)  
     * Returns a node client to a given node.
                    false,  
    public <T> T getDataNodeInstance(Class<T> clazz) {
        return startNodes(numNodes, Settings.builder().put(onlyRole(settings, DiscoveryNodeRole.DATA_ROLE)).build());  
     * Returns the name of all the cluster managers in the cluster
                ScriptService.SCRIPT_CACHE_SIZE_SETTING.getConcreteSettingForNamespace(ctx).getKey(),  
            newSize  
    public synchronized Set<String> nodesInclude(String index) {
            callback.doAfterNodes(numNodesRestarted++, nodeAndClient.nodeClient());
     */  
import java.util.ArrayList;  
                if (nodeClient == null) {
                    .map(nac -> nac.node.getEnvironment().configDir())
            assert callback != null;
        return previous;
    public synchronized Client client() {
            }
                // been updated when the previous nodes shut down, so we must always explicitly withdraw votes.
            }
    public String startDataOnlyNode(Settings settings) {
import java.util.Objects;
        ensureOpen();  
                for (Future<?> future : futures) {
        return startNodes(numNodes, Settings.builder().put(onlyRole(settings, DiscoveryNodeRole.DATA_ROLE)).build(), ignoreNodeJoin);
    /**
        for (int i = 0; i < numNodes; i++) {
            if (minClusterManagerNodes >= 0) {
    @Override
        return nodePrefix + getRoleSuffix(settings);
            public void afterStart() {  
    public synchronized void afterTest() {  
     */  
        private Client nodeClient;
    /**
     * Starts a node with the given settings and returns its name.  
            IndicesService indexServices = getInstance(IndicesService.class, nodeAndClient.name);
    /**  
    public <T> T getInstance(Class<T> clazz) {  
                List<String> discoveryFileContents = unicastHosts.map(nac -> nac.node.injector().getInstance(TransportService.class))
        if (secureSettings instanceof MockSecureSettings) {  
            } else {
    /**
        logger.info(  
    private Collection<NodeAndClient> warmNodeAndClients() {  
                logger.debug("Close Node [{}] not shared", nodeAndClient.name);  
    public void setBootstrapClusterManagerNodeIndex(int bootstrapClusterManagerNodeIndex) {  
        return eligibleClusterManagerNodes / 2 + 1;
                final List<ClusterState> states = nodes.values()
    }
        return suffix;
                    "Missing cluster-manager" + debugString,
        }
import org.opensearch.common.Randomness;
    }  
import org.opensearch.index.engine.IngestionEngine;
                    false,
                return clientWrapper.apply(nodeClient);
            return nodeAndClient.client();  
    }
    private synchronized void stopNodesAndClients(Collection<NodeAndClient> nodeAndClients) throws IOException {
            if (ensureHealthyCluster) {  
import org.opensearch.cluster.node.DiscoveryNodeRole;
                builder.put("indices.fielddata.cache.size", 1 + random.nextInt(1000), ByteSizeUnit.MB);
        }, 30, TimeUnit.SECONDS);  
                int totalDataNodes = numDataNodes();
     * @param nodeId                    node ordinal  
                if (combinedBytes > 0) {
 * The OpenSearch Contributors require contributions made to  
        }
     * @param reuseExisting             if a node with the same name is already part of {@link #nodes}, no new node will be built and
        Iterable<NodeAndClient> filteredNodes = nodes.values().stream().filter(predicate)::iterator;
                    .filter(Objects::nonNull)
            } else if (numSharedDataNodes > 0) {  
            }  
    public static Predicate<Settings> nameFilter(String... nodeNames) {
        }
                // that the breaker can sometimes be incremented from ping  
        /**
                    "FixedBitSet cache size must be 0 on node: " + stats.getNode(),
        public boolean isClusterManagerEligible() {  
            stopNodesAndClient(nodeAndClient);
                    equalTo(0L)
     * Starts multiple nodes with the given settings and returns their names
     * Restarts a random data node in the cluster  
            assert previous == nodeAndClient;
        }  
    }
                    }
    public String[] getNodeNames() {  
            builder.put(HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_TYPE_SETTING.getKey(), "noop");  
            });  
         */  
            if (numSharedDedicatedClusterManagerNodes > 0) {
                    throw new AssertionError("Exception during check for request breaker reset to 0", e);
                );  
        assert size() >= numNodes;
    private synchronized <T> T getInstance(Class<T> clazz, Predicate<NodeAndClient> predicate) {  
    /**
            throw new IllegalArgumentException("minimum and maximum number of data nodes must be >= 0");  
        }
import org.opensearch.common.lifecycle.LifecycleListener;
        return startNodes(numNodes, Settings.builder().put(onlyRole(settings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE)).build());
                    DiscoveryNodes discoveryNodes = cs.nodes();  
                NodeService nodeService = getInstanceFromNode(NodeService.class, nodeAndClient.node);  
    public String startClusterManagerOnlyNode(Settings settings) {
        assert reuseExisting || nodeAndClient == null : "node name [" + name + "] already exists but not allowed to use it";  
    /**
            // cluster-manager-eligible;  
                .count();
import static org.opensearch.test.NodeRoles.onlyRoles;
        return buildNode;  
    public Settings dataPathSettings(String node) {
    public List<String> startDataAndWarmNodes(int numNodes) {
    }
                    .stream()
                executor.shutdownNow();  
    }  
            if (random.nextInt(10) == 0) { // do something crazy slow here
    /**  
        // prevent killing the cluster-manager if possible and client nodes
                );
    );
    /**
        logger.debug(
            stopNodesAndClient(nodeAndClient);  
        assertBusy(() -> {
            }, 30, TimeUnit.SECONDS);  
                    greaterThan(shard)  
            ensureOpen();  
                }
        node.injector().getInstance(TransportService.class).addLifecycleListener(new LifecycleListener() {
        callback.onAllNodesStopped();
            restartNode(nodeAndClient, callback);
    ) {
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
                this.numSharedDedicatedClusterManagerNodes = 0;
        }  
        if (randomNodeAndClient != null) {
            addresses.add(httpServerTransport.boundAddress().publishAddress().address());
        }
        stopNodesAndClients(toClose);
        NodeNamePredicate(String nodeName) {  
                        FileSystemUtils.deleteSubDirectories(path);
        }  
        assert nodePrefix != null;  
    }
        final long seed,
        }  
     * Returns the name of the current cluster-manager node in the cluster.
                builder.put(
            return true;  
            }  
                () -> rebuildUnicastHostFiles(nodes)  
            return allNodesSettings;
     * Stops a random data node in the cluster. Returns true if a node was found to stop, false otherwise.  
    static final int DEFAULT_MIN_NUM_DATA_NODES = 1;
            builder.put("logger.level", System.getProperty("tests.opensearch.logger.level"));  
                    if (cs.nodes().getNodes().values().stream().findFirst().get().isRemoteStoreNode()) {
        }
    // synchronized to prevent concurrently modifying the cluster.
                    IndexShard primaryShard = getShardOrNull(state, primaryShardRouting);  
            close();
            @Override
        for (NodeAndClient n : nodes.values()) {
                NodeEnvironment nodeEnv = node.getNodeEnvironment();
    }  
            activeDisruptionScheme.removeFromNode(nodeAndClient.name, this);
                    : -1;
                NodeStats stats = nodeService.stats(
        }  
        assert Thread.holdsLock(this);
                    }
        return startClusterManagerOnlyNodes(numNodes, Settings.EMPTY);  
        builder.put(Environment.PATH_REPO_SETTING.getKey(), baseDir.resolve("repos"));
        clearDisruptionScheme(true);
                    false,  
                            assertThat(indexShard.routingEntry().toString(), EngineTestCase.getInFlightDocCount(engine), equalTo(0L));
        return clusterName;  
import java.util.stream.Collectors;
                        }
        assertAllPendingWriteLimitsReleased();
        this.autoManageClusterManagerNodes = autoManageClusterManagerNodes;  
            // Checks that the breakers have been reset without incurring a
            );  
        return startClusterManagerOnlyNode(Settings.EMPTY);
    public Settings getDefaultSettings() {  
            mockPlugins,
            logger.info("Closing random node [{}] ", nodeAndClient.name);  
                                replicaShardRouting + " global checkpoint syncs mismatch",
import org.opensearch.action.admin.indices.stats.CommonStatsFlags.Flag;
    /**
                    for (IndexShard indexShard : indexService) {
    public String startNode(Settings settings) {
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.env.NodeEnvironment;  
            if (activeDisruptionScheme != null) {  
        });  
                        CircuitBreaker reqBreaker = breakerService.getBreaker(CircuitBreaker.REQUEST);
                nodeAndClient.resetClient();
            markNodeDataDirsAsNotEligibleForWipe(node);  
        Settings settings = getSettings(nodeId, random.nextLong(), Settings.EMPTY);
    }  
    public void clearDisruptionScheme() {  
import org.opensearch.common.util.concurrent.ThreadContext;
            builder.put(
                }
            final Settings nodeSettings = getNodeSettings(i, sharedNodesSeeds[i], Settings.EMPTY, defaultMinClusterManagerNodes);
     */  
    }
                    .build();
    private static final class NodeNamePredicate implements Predicate<NodeAndClient> {  
     * Starts multiple nodes with the given settings and returns their names  
                    ShardRouting primaryShardRouting = indexShardRoutingTable.primaryShard();
            nodes.keySet(),  
                        // ensure that our size accounting on transport level is reset properly
                suffix = suffix + DiscoveryNodeRole.CLUSTER_MANAGER_ROLE.roleNameAbbreviation();
        }
                    false,
    public synchronized void restartNode(String nodeName, RestartCallback callback) throws Exception {  
        for (int i = 0; i < numSharedDedicatedClusterManagerNodes; i++) {
        assertBusy(() -> {
    }
     */
        return (int) nodes.values().stream().filter(n -> DiscoveryNode.isClusterManagerNode(n.node().settings())).count();  
                    new ByteSizeValue(RandomNumbers.randomIntBetween(random, 1, 10), ByteSizeUnit.MB)
                while (true) {  
                    }  
                    .filter(NodeAndClient::isClusterManagerEligible)  
            NodeEnvironment nodeEnv = node.getNodeEnvironment();
                    .collect(Collectors.toList());  
            validateClusterFormed();  
        ensureOpen();
                                equalTo(syncGlobalCheckpoints.get(replicaShardRouting.allocationId().getId()))  
            // of the breakers  
        List<NodeAndClient> values = nodes.values().stream().filter(predicate).collect(Collectors.toList());  
                    fail("Shard " + id + " is still locked after 5 sec waiting");  
        }
            return randomFrom(random, values);
                Set<Path> configPaths = Stream.concat(currentNodes.stream(), newNodes.stream())
                    for (DiscoveryNode expectedNode : expectedNodes) {
    /** ensure a cluster is formed with all published nodes. */
                toClose.add(nodeAndClient);
            Set<DiscoveryNodeRole> warmAndDataRoles = Set.of(DiscoveryNodeRole.DATA_ROLE, DiscoveryNodeRole.WARM_ROLE);  
import java.io.UncheckedIOException;
    private void randomlyResetClients() {
                                    + bytesUsed  
        );  
                    // see #ensureEstimatedStats()  
            IndexService indexService = indicesService.indexService(index);
        return nodes.entrySet()
     * Ensures that at least <code>n</code> warm nodes are present in the cluster.
import org.opensearch.cluster.ClusterState;
    /**  
        if (random.nextBoolean()) {  
                        return routing;  
            builder.put("logger.prefix", System.getProperty("opensearch.logger.prefix"));  
                    false,
                startDataOnlyNodes(n - size);
                            continue; // just ignore - shard movement
     * All nodes started by the cluster will have their name set to nodePrefix followed by a positive number  
            );
    public synchronized void rollingRestart(RestartCallback callback) throws Exception {
                    .collect(Collectors.toList())
            builder.put(TransportReplicationAction.REPLICATION_INITIAL_RETRY_BACKOFF_BOUND.getKey(), timeValueMillis(initialMillisBound));
                                // no-op, as IngestionEngine does not use translog.
     * If less nodes that <code>n</code> are running this method
        assert Thread.holdsLock(this);
    public InternalTestCluster(
            }
            }
                    assertBusy(() -> assertThat("Fielddata breaker not reset to 0 on node: " + name, fdBreaker.getUsed(), equalTo(0L)));
        Set<String> excludedNodeIds = excludeClusterManagers(Collections.singleton(nodeAndClient));  
    /**
        final Path baseDir,  
            } catch (InterruptedException | ExecutionException e) {
        this.clusterName = clusterName;
        return getInstance(IndicesService.class, assignedNode.getName()).getShardOrNull(shardRouting.shardId());
        for (int i = numSharedDedicatedClusterManagerNodes; i < numSharedDedicatedClusterManagerNodes + numSharedDataNodes; i++) {  
        public int nodeAndClientId() {
            return nodeName.equals(nodeAndClient.getName());  
            }
    /**
        removeExclusions(excludedNodeIds);
            clientWrapper,  
     */
                        + "': ["
     * for the description of how this field is used.  
                    if (primaryShard == null) {
    public String startNode(Settings.Builder settings) {
        reset(true);
        }, 60, TimeUnit.SECONDS);  
        }  
                );  
        if (random.nextBoolean()) {
     * Note: use this with care tests should not rely on a certain nodes client.
            removeNode(this);  
    public synchronized boolean stopRandomWarmNode() throws IOException {  
        // if multiple maven task run on a single host we better have an identifier that doesn't rely on input params
            builder.put(
        final Settings newSettings = nodeAndClient.closeForRestart(
        final int minClusterManagerNodes = autoManageClusterManagerNodes ? getMinClusterManagerNodes(getClusterManagerNodesCount()) : -1;
            node = new MockNode(
            return true;
        }
            : nodes.values().stream().filter(DATA_NODE_PREDICATE.and(new NodeNamePredicate(getClusterManagerName()).negate()));
        logger.debug(
import org.opensearch.common.util.PageCacheRecycler;
    private Settings getSettings(int nodeOrdinal, long nodeSeed, Settings others) {
        }
                                "shard "
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
     * stop any of the running nodes.  
                    .filter(n -> n.nodeAndClientId() < sharedNodesSeeds.length)
    public NamedWriteableRegistry getNamedWriteableRegistry() {  
        }  
    /**
                    }
        int autoBootstrapClusterManagerNodeIndex = -1;  
        return startDataOnlyNodes(numNodes, Settings.EMPTY);
        }, 60, TimeUnit.SECONDS);
                    stopRandomDataNode();  
    }
import java.util.LinkedHashSet;  
        if (shardRouting == null || shardRouting.assignedToNode() == false) {
            boolean success = false;
                final long primaryBytes = indexingPressure.getCurrentPrimaryBytes();
            nodesToRemove.add(next);  
            restartNode(nodeAndClient, callback);
        final int defaultMinClusterManagerNodes = (numberOfClusterManagerNodes / 2) + 1;
import org.opensearch.test.disruption.ServiceDisruptionScheme;  
            if (closed.get()) {  
        plugins.addAll(mockPlugins);  
            for (ShardId id : shardIds) {
                                    + "] has pending operations:\n --> "
import org.opensearch.cluster.service.ClusterService;  
                client.execute(ClearVotingConfigExclusionsAction.INSTANCE, new ClearVotingConfigExclusionsRequest()).get();  
        final NavigableMap<String, NodeAndClient> newNodes = new TreeMap<>(nodes);
    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
            closed.set(false);
            if (nodeAndClient.nodeAndClientId() >= sharedNodesSeeds.length) {
     * Sets {@link #bootstrapClusterManagerNodeIndex} to the given value, see {@link #bootstrapClusterManagerNodeWithSpecifiedIndex(List)}
                    );  
    private static final Predicate<NodeAndClient> WARM_NODE_PREDICATE = nodeAndClient -> DiscoveryNode.hasRole(
        public void onAllNodesStopped() throws Exception {}
        }  
            }  
        final long clusterSeed,
            }
                }
            for (NodeAndClient nodeAndClient : nodes.values()) {
     * Starts multiple nodes with the given settings and returns their names
    private void assertNoPendingIndexOperations() throws Exception {
            return;
    public ClusterService clusterService(@Nullable String node) {  
                autoBootstrapClusterManagerNodeIndex -= 1;
    }  
        final NodeAndClient nodeAndClient = nodes.get(name);
        }  
        newNodes.put(nodeAndClient.name, nodeAndClient);  
    public static final int DEFAULT_LOW_NUM_CLUSTER_MANAGER_NODES = 1;
        }
                            // all good
        // visible to later plugins' createComponents() only when init order respects declared
    private List<Settings> bootstrapClusterManagerNodeWithSpecifiedIndex(List<Settings> allNodesSettings) {
        return allDataNodesButN(0);
    }  
            );  
        } else if (random.nextInt(10) != 0) { // 90% of the time - 10% of the time we don't set anything
                settings.add(removeRoles(nodeSettings, Collections.singleton(DiscoveryNodeRole.MASTER_ROLE)));  
            return false;  
         */
                    .mapToObj(i -> baseDir.resolve(name).resolve("d" + i).toString())  
        if (fileCache != null && WARM_NODE_PREDICATE.test(nodeAndClient)) {
     * Ensures that at least <code>n</code> data-warm nodes are present in the cluster.
            // we have to validate cluster size to ensure that the restarted node has rejoined the cluster if it was
        assert size() > 0;
                final long replicaWriteBytes = indexingPressure.getCurrentReplicaBytes();  
                );
            nodeAndClient.close();
        // only add the suffixes if roles are explicitly defined
        int nodeId = nextNodeId.getAndIncrement();
            builder.put(SearchService.DEFAULT_KEEPALIVE_SETTING.getKey(), timeValueSeconds(100 + random.nextInt(5 * 60)).getStringRep());
                }  
        }
        activeDisruptionScheme = null;  
    /**  
            autoManageClusterManagerNodes ? getMinClusterManagerNodes(getClusterManagerNodesCount()) : -1
                // all nodes have the same cluster-manager (in same term)
    }
            }
        }
                currentNodeId++;  
                IndicesService indexServices = getInstance(IndicesService.class, nodeAndClient.name);  
                nodeAndClients.stream()
        @Override
     */
     * Used for remote store test cases, where remote state is restored.
        private Client getOrBuildNodeClient() {  
        if (random.nextBoolean()) {
    public List<String> startDataOnlyNodes(int numNodes) {
    }  
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
import java.nio.file.Files;
                    Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(),  
     * @param settings                  the settings to use
                    .forEach(excludedNodeNames::add);
    }  
    private static final String DEFAULT_WARM_CACHE_SIZE_BYTES = "2gb";
        }
        assert Thread.holdsLock(this);  
        );
        if (numSharedDataNodes == 0) {
                logger.debug("configuring discovery with {} at {}", discoveryFileContents, configPaths);
        final List<NodeAndClient> toStartAndPublish = new ArrayList<>(); // we want to start nodes in one go  
                    states.stream().allMatch(cs -> cs.nodes().getClusterManagerNodeId() != null)
                        primarySeqNoStats.getGlobalCheckpoint(),
    public int size() {
         * Executed for each node before the {@code n + 1} node is restarted. The given client is
import org.opensearch.test.transport.MockTransportService;
        if (size <= n) {
        );  
            if (numSharedDedicatedClusterManagerNodes > 0) {
     * if more nodes than <code>n</code> are present this method will not
        return getInstance(clazz, nc -> node == null || node.equals(nc.name));
            removeDisruptionSchemeFromNode(nodeAndClient);
        if (random.nextBoolean()) {
    private Settings getNodeSettings(  
        builder.put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "1b");
        if (Strings.hasLength(System.getProperty("opensearch.logger.prefix"))) {
    /**
        publishNode(nodeAndClient);
    public String getClusterManagerName(@Nullable String viaNode) {
        /**  
            this.numSharedDedicatedClusterManagerNodes = 0;
                    }  
import static org.opensearch.test.NodeRoles.removeRoles;  
                                + "]",  
import org.opensearch.common.settings.Settings.Builder;
            if (i == autoBootstrapClusterManagerNodeIndex) {  
    public Client clusterManagerClient() {  
        final int maxNumDataNodes,
        if (nodeAndClient != null) {  
            .stream()  
        // Use LinkedHashSet so plugin iteration order matches the user's nodePlugins() declaration.
        NodeAndClient randomNodeAndClient = getRandomNodeAndClient();  
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;
    }
            } catch (NodeValidationException e) {  
        // and fails shards when a cluster-manager abdicates, which breaks many tests.
        SecureSettings secureSettings = Settings.builder().put(settings).getSecureSettings();
    private static Collection<NodeAndClient> filterNodes(
        }  
