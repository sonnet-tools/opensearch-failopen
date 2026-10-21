    public Iterable<Client> getClients() {
            restartNode(nodeAndClient, callback);
        }
                        try {
import org.opensearch.common.util.set.Sets;
        public Settings onNodeStopped(String nodeName) throws Exception {
                    newSettings.add(settings);
                closed.set(true);
        final Set<String> nodes = Sets.newHashSet(nodeNames);
            onTransportServiceStarted.run(); // reusing an existing node implies its transport service already started
        // Default the watermarks to absurdly low to prevent the tests
    private static <T> T getInstanceFromNode(Class<T> clazz, Node node) {
        buildNode.startNode();
    private static final Predicate<NodeAndClient> WARM_AND_DATA_NODE_PREDICATE = nodeAndClient -> DiscoveryNode.hasRole(
            .filter(DiscoveryNode::isClusterManagerNode)
import org.opensearch.cluster.node.DiscoveryNode;
        List<Settings> newSettings = new ArrayList<>();
import org.opensearch.Version;
    }
            .collect(Collectors.toSet());
                        }
            restartNode(nodeAndClient, callback);
        defaultSettings = builder.build();
    }
            );
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
        assertTrue(
                    stats.getIndices().getFieldData().getMemorySizeInBytes(),
        if (autoManageClusterManagerNodes && !waitForNodeJoin) {
     * This assertion might be expensive, thus we prefer not to execute on every test but only interesting tests.
     * for the description of how this field is used.
                    try {
        return filterNodes(nodes, NodeAndClient::isClusterManagerEligible).size();
            return newSettings.build();
                                + docsOnReplica.size()
                    assertThat(
                activeDisruptionScheme = null;
    synchronized String routingKeyForShard(Index index, int shard, Random random) {
        return eligibleClusterManagerNodes / 2 + 1;
    public InternalTestCluster(
                        return routing;
                this.numSharedCoordOnlyNodes = numClientNodes;
                    Collections.emptyList(),
    }
            .filter(entry -> DATA_NODE_PREDICATE.test(entry.getValue()))
        return plugins;
        return nodes.keySet().toArray(Strings.EMPTY_ARRAY);
        node.injector().getInstance(TransportService.class).addLifecycleListener(new LifecycleListener() {
        public boolean test(NodeAndClient nodeAndClient) {
                        if (primaryShard.isRemoteTranslogEnabled() == false) {
        final String name = buildNodeName(nodeId, settings);
import org.opensearch.core.util.FileSystemUtils;
            "internal_test_cluster_executor",
            );
        assertNoSnapshottedIndexCommit();
                            );
                } else {
        if (autoManageClusterManagerNodes && nodeAndClients.size() > 0) {
            };
                NodeStats stats = nodeService.stats(
        if (activeDisruptionScheme != null) {
    @Override
                        assertTrue("Expected node to exist: " + expectedNode + debugString, discoveryNodes.nodeExists(expectedNode));
                                    + "Expected 0 but got "
                    for (IndexShard indexShard : indexService) {
        if (random.nextBoolean()) {
        // allow overriding the above
                getClusterManagerName()
        assertBusy(() -> {
                    .filter(Objects::nonNull)
            throw new IllegalStateException(e);
        ensureOpen();
            } catch (IOException e) {
                );
        // Close IndexInput reference file to avoid file leaks during node restart
     */
                if (shardRouting.assignedToNode()) {
        final Settings settings = getSettings(nodeId, seed, extraSettings);
            return randomNodeAndClient.nodeClient(); // ensure node client cluster-manager is requested
            "Cluster is NOT consistent - restarting shared nodes - nodes: [{}] nextNodeId: [{}] numSharedNodes: [{}]",
                newSize
                                .values()
                                + replicaShardRouting
            clearDataIfNeeded(callback);
        Iterable<NodeAndClient> filteredNodes = nodes.values().stream().filter(predicate)::iterator;
        if (RandomizedTest.isNightly() && rarely(random)) {
        final Runnable onTransportServiceStarted = () -> rebuildUnicastHostFiles(toStartAndPublish);
    public synchronized void ensureAtMostNumDataNodes(int n) throws IOException {
        assert Thread.holdsLock(this);
                                    + pendingTasks
        }
        final boolean autoManageClusterManagerNodes,
        return startNode(settings1);
        if (secureSettings instanceof MockSecureSettings) {
        DiscoveryNode clusterManagerNode = client.admin().cluster().prepareState().get().getState().nodes().getClusterManagerNode();
        if (prevNodeCount == 0 && autoManageClusterManagerNodes) {
    }
        int numNodesRestarted = 0;
        if (nodeAndClients.size() > 0) {
                totalClusterManagerNodes -= 1;
        builder.put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "1b");
            logger.info("increasing cluster size from {} to {}", size, n);
                    future.get();
    /** ensure a cluster is formed with all published nodes. */
    }
            public void afterStart() {
                    false,
        this.forbidPrivateIndexSettings = forbidPrivateIndexSettings;
        return getRandomNodeAndClient(NO_DATA_NO_CLUSTER_MANAGER_PREDICATE).client();
                    RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(),
        assert size() >= numNodes;
            Settings nodeSettings = updatedSettings.get(i);
                .put(NodeEnvironment.NODE_ID_SEED_SETTING.getKey(), newIdSeed)
        return getRandomNodeAndClient(DATA_NODE_PREDICATE).client();
     * Asserts that all shards with the same shardId should have document Ids.
            // delete data folders now, before we start other nodes that may claim it
            OpenSearchExecutors.NODE_PROCESSORS_SETTING.getKey(),
    }
    private final boolean autoManageClusterManagerNodes;
            }
     * returns a suffix string based on the node role. If no explicit role is defined, the suffix will be empty
            nodesToRemove.add(next);
import static org.junit.Assert.assertEquals;
        if (others != null) {
                            docsOnReplica,
            }
import static org.opensearch.test.OpenSearchTestCase.randomFrom;
                dataDirToClean.addAll(Arrays.asList(nodeEnv.nodeDataPaths()));
    public String startNode() {
                    null,
        return (int) nodes.values().stream().filter(n -> DiscoveryNode.isClusterManagerNode(n.node().settings())).count();
     */
            boolean success = false;
        final int defaultMinClusterManagerNodes;
     * Starts multiple nodes with the given settings and returns their names
                CircuitBreaker fdBreaker = breakerService.getBreaker(CircuitBreaker.FIELDDATA);
    /**
            }
                    .mapToObj(i -> baseDir.resolve(name).resolve("d" + i).toString())
import org.opensearch.node.MockNode;
    private void rebuildUnicastHostFiles(List<NodeAndClient> newNodes) {
        }
    }
import org.apache.lucene.store.AlreadyClosedException;
        .isClusterManagerNode(nodeAndClient.node.settings()) == false
    }
                    .put(nodeSettings)
     * Stops a random data node in the cluster. Returns true if a node was found to stop, false otherwise.
            TimeValue.timeValueMillis(RandomNumbers.randomIntBetween(random, 20, 50))
        return filterNodes(nodes, WARM_NODE_PREDICATE);
        if (random.nextBoolean()) {
    @Override
    /**
        return getInstance(IndicesService.class, assignedNode.getName()).getShardOrNull(shardRouting.shardId());
        final boolean usingSingleNodeDiscovery = discoveryType.equals("single-node");
            "Cluster is consistent again - nodes: [{}] nextNodeId: [{}] numSharedNodes: [{}]",
        }
                        }
    }
import org.opensearch.common.lifecycle.LifecycleListener;
                final long coordinatingBytes = indexingPressure.getCurrentCoordinatingBytes();
    public ClusterService clusterService(@Nullable String node) {
                                seqNoStats.getGlobalCheckpoint(),
                            continue;
                            final Engine engine = IndexShardTestCase.getEngine(indexShard);
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
        assert Thread.holdsLock(this);
        }
            final NodeAndClient nodeAndClient = buildNode(i, nodeSettings, true, onTransportServiceStarted);
    private void randomlyResetClients() {
            synchronized (InternalTestCluster.this) {
        }
            } else {
        return startDataOnlyNodes(numNodes, Settings.EMPTY);
    public void beforeIndexDeletion() throws Exception {
            if (nodePrefix.equals(OpenSearchIntegTestCase.SUITE_CLUSTER_NODE_PREFIX)
        randomlyResetClients(); /* reset all clients - each test gets its own client based on the Random instance created above. */
    }
                    .map(ClusterService::state)
            String ctx = randomFrom(random, ScriptModule.CORE_CONTEXTS.keySet());
        if (nextNodeId.get() == newSize && nodes.size() == newSize) {
        final Set<String> excludedNodeNames = new HashSet<>();
            );
    public <T> T getClusterManagerNodeInstance(Class<T> clazz) {
                            .putList(ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), nodeNames)
                            throw new AssertionError(
                    .filter(NodeAndClient::isClusterManagerEligible)
        // non-deterministic ITs (a sibling plugin's createComponents could run before the plugin
                        docsOnPrimary = IndexShardTestCase.getDocIdAndSeqNos(primaryShard);
     * Restarts a random data node in the cluster
            logger.info("Clearing active scheme {}, expected healing time {}", activeDisruptionScheme, expectedHealingTime);
                    throw new RuntimeException("already closed");
            sharedNodesSeeds[i] = random.nextLong();
                suffix = suffix + "c";
            }
            SeedUtils.formatSeed(clusterSeed),
            clientWrapper,
    }
                // all nodes have the same cluster-manager (in same term)
public final class InternalTestCluster extends TestCluster {
            final int currentClusterManagers = getClusterManagerNodesCount();
                        assertTrue(repositoriesMetadata != null && !repositoriesMetadata.repositories().isEmpty());
        publishNode(buildNode);
        /* Randomly return a client to one of the nodes in the cluster */
     * Updates are intended to follow a copy-on-write approach. */
        final Path baseDir,
            return new Iterator<Client>() {
                    throw new AssertionError("Interruption while waiting for the node to close", e);
    private synchronized NodeAndClient getRandomNodeAndClient(Predicate<NodeAndClient> predicate) {
        for (Settings settings : allNodesSettings) {
            builder.put(TransportReplicationAction.REPLICATION_RETRY_TIMEOUT.getKey(), timeValueSeconds(retryTimeoutSeconds));
                    "FixedBitSet cache size must be 0 on node: " + stats.getNode(),
import org.opensearch.discovery.ClusterManagerNotDiscoveredException;
    }
        final List<NodeAndClient> toStartAndPublish = new ArrayList<>(); // we want to start nodes in one go
                        }
        if (random.nextBoolean()) {
            1 + random.nextInt(Math.min(4, Runtime.getRuntime().availableProcessors()))
        return getOrBuildRandomNode().client();
                dataDirToClean.removeAll(Arrays.asList(nodeEnv.nodeDataPaths()));
                timeValueSeconds(RandomNumbers.randomIntBetween(random, 10, 30)).getStringRep()
            logger.info("recreating node [{}] ", nodeAndClient.name);
     * Performs cluster bootstrap when node with index {@link #bootstrapClusterManagerNodeIndex} is started
     * stop any of the running nodes.
        final int minNumDataNodes,
                    false,
        }
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
                        "pending coordinating bytes [" + coordinatingBytes + "] bytes on node [" + nodeAndClient.name + "]."
        if (size < n) {
     * An abstract class that is called during {@link #rollingRestart(InternalTestCluster.RestartCallback)}
        assert clusterManagerNode != null;
        // Check that the operations counter on index shard has reached 0.
        private void markNodeDataDirsAsPendingForWipe(Node node) {
                        throw new IOException("Node didn't close within 10 seconds.");
        updatedSettings.put("node.name", name);
        // randomize start up order
                    for (DiscoveryNode expectedNode : expectedNodes) {
            Settings finalSettings = Settings.builder()
                        RepositoriesMetadata repositoriesMetadata = cs.metadata().custom(RepositoriesMetadata.TYPE);
                                    + indexShard.shardId()
import org.opensearch.common.util.concurrent.FutureUtils;
        }
            }
            addresses.add(httpServerTransport.boundAddress().publishAddress().address());
        nextNodeId.set(firstNodeId + numOfNodes);
        // ElasticsearchIntegrationTest must override beforeIndexDeletion() to avoid failures.
                }
                    }
            ensureOpen();
        Set<DiscoveryNodeRole> warmAndDataRoles = new HashSet<>();
                }
                            }
                nodeSettings = Settings.builder()
        assertThat(shard, greaterThanOrEqualTo(0));
     * stop any of the running nodes.
                    try {
                        .shardId()
    /**
            RandomNumbers.randomIntBetween(random, 1, 4)
                        not(equalTo(SequenceNumbers.UNASSIGNED_SEQ_NO))
     */
        );
    }
                try {
     */
        final long clusterSeed,
                }
     * will not start any additional nodes.
            validateClusterFormed();
            builder.put(
                .build();
    public int numDataNodes() {
        final HashSet<String> set = new HashSet<>();
            builder.put(TransportSettings.CONNECTIONS_PER_NODE_RECOVERY.getKey(), random.nextInt(2) + 1);
    /**
    }
     * Restarts a random data node in the cluster and calls the callback during restart.
                // requests from other clusters because Jenkins is running
    }
    }
            this.nodeName = nodeName;
                );
        while (values.hasNext() && numNodesAndClients++ < size - n) {
            validateClusterFormed();
            if (minClusterManagerNodes >= 0) {
    public void clearDisruptionScheme() {
    private void removeExclusions(Set<String> excludedNodeIds) {
            }
                } catch (InterruptedException | ExecutionException e) {
            builder.put(others);
        }
        }
import java.util.Set;
                // To combat this we check whether the breaker has reached 0
            }
     * If less nodes that <code>n</code> are running this method
        final List<Settings> updatedSettings = bootstrapClusterManagerNodeWithSpecifiedIndex(settings);
                OperationRouting operationRouting = clusterService.operationRouting();
        return updatedSettings.build();
                && getMinClusterManagerNodes(currentClusterManagers + newClusterManagers) > currentClusterManagers) {
        final NodeAndClient buildNode = buildNode(nodeId, nodeSettings, false, onTransportServiceStarted);
                        // shard is closed
            Set<ShardId> shardIds = env.lockedShards();
     */
import org.opensearch.core.index.Index;
import org.opensearch.cluster.action.index.MappingUpdatedAction;
        Settings closeForRestart(RestartCallback callback, int minClusterManagerNodes) throws Exception {
                );
                );
    public Client dataNodeClient() {
        assert !nodeAndClient.node().isClosed();
        final long clusterSeed,
            } finally {
                    .stream()
            .collect(Collectors.toList());
    }
    public void restartNode(String nodeName) throws Exception {
        String clusterManagerNodeName = getClusterManagerName();
                    this.numSharedDedicatedClusterManagerNodes = DEFAULT_HIGH_NUM_CLUSTER_MANAGER_NODES;
                                "shard "
        }
            for (NodeAndClient nodeAndClient : nodes.values()) {
     */
            return DiscoveryNode.isClusterManagerNode(node.settings());
                fileCache.clear();
        builder.append("-HASH=[").append(SeedUtils.formatSeed(System.nanoTime())).append(']');
            // of the breakers
    }
                nodes.keySet(),
        Set<NodeAndClient> nodesToRemove = new HashSet<>();
 * software distributed under the License is distributed on an
         * closes the node and prepares it to be restarted
                        if (bytesUsed != 0) {
     * with the names of all existing and new cluster-manager-eligible nodes.
            assert Thread.holdsLock(InternalTestCluster.this);
    }
                && nodes.values()
                throw new RuntimeException(e);
        return getInstance(NamedWriteableRegistry.class);
            numSharedCoordOnlyNodes,
            // use a new seed to make sure we generate a fresh new node id if the data folder has been wiped
    ) {
            nodes.keySet(),
    /**
            throw new ClusterManagerNotDiscoveredException("Cluster manager node not discovered");
    public int numWarmNodes() {
            }
            }
            validateClusterFormed();
import static org.junit.Assert.assertTrue;
            final long currentClusterManagers = nodes.values().stream().filter(NodeAndClient::isClusterManagerEligible).count();
                }
            }
                    Files.write(configPath.resolve(UNICAST_HOSTS_FILE), discoveryFileContents);
                    DiscoveryNode discoveryNode = discoveryNodes.get(shardRouting.currentNodeId());
    public synchronized String startCoordinatingOnlyNode(Settings settings) {
import java.util.Arrays;
     */
                }
        }
        List<NodeAndClient> values = nodes.values().stream().filter(predicate).collect(Collectors.toList());
                // been updated when the previous nodes shut down, so we must always explicitly withdraw votes.
        }
                    p.getName(),
     */
        int totalDataNodes = numDataNodes();
                    final List<DocIdSeqNoAndSource> docsOnPrimary;
         */
                suffix = suffix + DiscoveryNodeRole.DATA_ROLE.roleNameAbbreviation();
        }
     * Indexing starts from 0.
                states.forEach(cs -> {
            }
        // trash all nodes with id >= sharedNodesSeeds.length - they are non shared
    }
        NodeAndClient randomNodeAndClient = getRandomNodeAndClient(NO_DATA_NO_CLUSTER_MANAGER_PREDICATE);
        if (nodeAndClient != null) {
    @Override
    ) && DiscoveryNode.isDataNode(nodeAndClient.node.settings());
        return nodePrefix + getRoleSuffix(settings);
        return Collections.emptySet();
import org.opensearch.common.util.concurrent.ThreadContext;
                    false,
    public Settings getDefaultSettings() {
                    Files.createDirectories(configPath);
import org.opensearch.transport.client.Client;
     */
                }
        // turning on the real memory circuit breaker leads to spurious test failures. As have no full control over heap usage, we
                    flags,
            markNodeDataDirsAsNotEligibleForWipe(node);
        }
    // if set to 0, data nodes will also assume the cluster-manager role
    }
            builder.put(HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_TYPE_SETTING.getKey(), "noop");
            .filter(key -> key.equals(Environment.PATH_DATA_SETTING.getKey()) || key.equals(Environment.PATH_SHARED_DATA_SETTING.getKey()));
                            assertThat(
     */
                            nodeNames.add(Node.NODE_NAME_SETTING.get(nodeSettings));
                );
    public synchronized void ensureAtLeastNumDataNodes(int n) {
        for (NodeAndClient nodeAndClient : nodes.values()) {
                        );
    @Override
     */
            settings.add(getNodeSettings(i, sharedNodesSeeds[i], extraSettings.build(), defaultMinClusterManagerNodes));
     * The map of nodes is never mutated so individual reads are safe without synchronization.
        if (settings.hasValue("nodes.roles")) {
            if (ensureHealthyCluster) {
            "expected at least one cluster-manager-eligible node left in " + nodes,
        return instances;
            } else {
        return warmDataNodeAndClients().size();
                        logger.info("Successfully wiped data directory for node location: {}", path);
     * Asserts that the document history in Lucene index is consistent with Translog's on every index shard of the cluster.
                    "Fielddata size must be 0 on node: " + stats.getNode(),
                    nodes.add(discoveryNode.getName());
                    try {
            updatedSettings.put(Environment.PATH_DATA_SETTING.getKey(), baseDir.resolve(name));
            nodeConfigurationSource,
                // request breaker (because they use bigarrays), because of
import org.opensearch.script.ScriptService;
            this.numSharedDedicatedClusterManagerNodes = 0;
        return startNodes(numOfNodes, Settings.EMPTY);
     */
        if (reuseExisting && nodeAndClient != null) {
        }, 60, TimeUnit.SECONDS);
                    stopRandomDataNode();
    }
    public synchronized Set<String> nodesInclude(String index) {
     * Returns a set of nodes that have at least one shard of the given index.
                );
    @Override
        assert Thread.holdsLock(this);
        );
            return name;
        } catch (AssertionError ae) {
    }
                        new AddVotingConfigExclusionsRequest(excludedNodeNames.toArray(Strings.EMPTY_ARRAY))
        if (nodeAndClient != null) {
    }
        builder.put(Environment.PATH_REPO_SETTING.getKey(), baseDir.resolve("repos"));
    private synchronized void reset(boolean wipeData) throws IOException {
            if (autoManageClusterManagerNodes) {
        return nodes.values().stream().map(node -> getInstanceFromNode(clazz, node.node)).collect(Collectors.toList());
        if (randomNodeAndClient != null) {
        }, 60, TimeUnit.SECONDS);
                false,
                assertEquals(
            if (settings.get(ClusterName.CLUSTER_NAME_SETTING.getKey()) != null) {
                try {
    }
    public Client nonClusterManagerClient() {
                assertThat(
         * If this returns <code>true</code> all data for the node with the given node name will be cleared including
        }
                .filter(nac -> nodes.containsKey(nac.name) == false) // filter out old cluster-managers
    }
/**
                        final List<DocIdSeqNoAndSource> docsOnReplica;
            }
                                + "] num_docs_on_replica=["
    }
                    .filter(DiscoveryNode::isClusterManagerNode)
        ensureOpen();
        }
        return startDataOnlyNode(Settings.EMPTY);
        assertBusy(() -> {
                }
import static org.apache.lucene.tests.util.LuceneTestCase.rarely;
            newSettings.put(callbackSettings);
            }
        assert Thread.holdsLock(this);
            return randomNodeAndClient;
        StringBuilder builder = new StringBuilder(prefix);
                    1,
        builder.put(
import org.opensearch.common.Randomness;
                    } catch (AlreadyClosedException ignored) {
            }
    public void assertConsistentHistoryBetweenTranslogAndLuceneIndex() throws IOException {
        }
        final NodeAndClient clusterManagerNode = nodes.get(clusterManagerNodeName);
                    false,
     * Starts a node with default settings and returns its name.
     * Returns a "smart" node client to a random node in the cluster
    /**
                }
        builder.put(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_SETTING.getKey(), randomFrom(random, "write", "metadata_write"));
        } else if (random.nextInt(10) != 0) { // 90% of the time - 10% of the time we don't set anything
import java.util.Collections;
     */
        }
     * Note: use this with care tests should not rely on a certain nodes client.
            if (closed.get() == false) {
     * Returns an Iterable to all instances for the given class &gt;T&lt; across all data and cluster-manager nodes
                    ? RandomNumbers.randomIntBetween(random, 0, newClusterManagerCount - 1)
                IntStream.range(0, numDataPaths)
                node.close();
    private void removeDisruptionSchemeFromNode(NodeAndClient nodeAndClient) {
                        }
                    final int targetShard = operationRouting.indexShards(clusterService.state(), index.getName(), null, routing)
                            );
                        CircuitBreaker reqBreaker = breakerService.getBreaker(CircuitBreaker.REQUEST);
import org.opensearch.index.seqno.SequenceNumbers;
    }
     */
        final int numberOfClusterManagerNodes = numSharedDedicatedClusterManagerNodes > 0
            return true;
            if (numClientNodes < 0) {
        logger.info("changing cluster size from {} data nodes to {}", size, n);
            clusterName,
    private static int getMinClusterManagerNodes(int eligibleClusterManagerNodes) {
            final Settings nodeSettings = getNodeSettings(i, sharedNodesSeeds[i], Settings.EMPTY, defaultMinClusterManagerNodes);
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
    private final Set<Path> dataDirToClean = new HashSet<>();
                autoBootstrapClusterManagerNodeIndex = RandomNumbers.randomIntBetween(random, 0, numSharedDataNodes - 1);
import static org.junit.Assert.assertThat;
        final List<Settings> settings = new ArrayList<>();
                    false,
                    .collect(Collectors.toList());
        super.assertAfterTest();
                    return iterator.hasNext();
        }
     */
                    if (primaryShard == null) {
        private final Settings originalNodeSettings;
        scheme.applyToCluster(this);
        public void close() throws IOException {
                RandomNumbers.randomIntBetween(random, 5, 10)
            + activeDisruptionScheme
            logger.info("Closing random node [{}] ", nodeAndClient.name);
                try {
    public synchronized <T> T getCurrentClusterManagerNodeInstance(Class<T> clazz) {
import java.util.stream.Collectors;
        nodes = Collections.unmodifiableNavigableMap(newNodes);
 * Licensed to Elasticsearch under one or more contributor
        }
                throw new AssertionError("Tried to stop the only cluster-manager eligible shared node");
        if (callback.validateClusterForming()) {
    /**
            return randomFrom(random, values);
    public static class RestartCallback {
            numClientNodes,
    public synchronized void ensureAtLeastNumWarmNodes(int n) {
    public synchronized void beforeTest(Random random) throws IOException, InterruptedException {
        final String nodePrefix,
            .stream()
                for (IndexService indexService : indexServices) {
        builder.put("http.port", 0);
        );
                    if (shard == targetShard) {
                while (true) {
                // If stopping few enough cluster-manager-nodes that there's still a majority left, there is no need to withdraw their votes
                final CircuitBreakerService breakerService = getInstanceFromNode(CircuitBreakerService.class, nodeAndClient.node);
                validateClusterFormed();
            builder.put(
        final NodeConfigurationSource nodeConfigurationSource,
        }
    }
                        IndexShardTestCase.assertConsistentHistoryBetweenTranslogAndLucene(indexShard);
import static org.opensearch.discovery.DiscoveryModule.ZEN2_DISCOVERY_TYPE;
        }
        final NodeAndClient randomNodeAndClient = getRandomNodeAndClient();
        }
                }
        logger.debug(
                @Override
                int totalDataNodes = numDataNodes();
                        primarySeqNoStats.getGlobalCheckpoint(),
                }
                    }
                markNodeDataDirsAsPendingForWipe(node);
        final Settings.Builder updatedSettings = Settings.builder();
        }
    public synchronized void ensureAtLeastNumWarmAndDataNodes(int n) {
        for (NodeAndClient nodeAndClient : nodes.values()) {
                    false,
                    p.getName(),
        // start any missing node
 *
                }
                client.execute(ClearVotingConfigExclusionsAction.INSTANCE, new ClearVotingConfigExclusionsRequest()).get();
        Settings settings1 = Settings.builder().put(settings).put(NodeRoles.clusterManagerOnlyNode(settings)).build();
    }
    private final String nodePrefix;
                });
                        continue;
     */
                    false,
        return startSearchOnlyNode(Settings.EMPTY);
        if (callback.validateClusterForming() || excludedNodeIds.isEmpty() == false) {
import org.opensearch.action.admin.cluster.configuration.ClearVotingConfigExclusionsAction;
        return excludedNodeNames;
            });
            }
            if (DiscoveryNode.isClusterManagerNode(settings) == false) {
        nextNodeId.set(newSize);
            return nodeName.equals(nodeAndClient.getName());
            throw new RuntimeException(e);
 * </p>
        final String discoveryType = DISCOVERY_TYPE_SETTING.get(updatedSettings.build());
        int nodeId = nextNodeId.getAndIncrement();
    private int bootstrapClusterManagerNodeIndex = -1;
    /**
            this.numSharedCoordOnlyNodes = 0;
    static final int DEFAULT_NUM_CLIENT_NODES = -1;
    }
    private final class NodeAndClient implements Closeable {
        nodeAndClient.node.settings(),
    private int getClusterManagerNodesCount() {
                            }
                                    + String.join("\n --> ", operations)
        private Client getOrBuildNodeClient() {
            }
                    String routing = RandomStrings.randomAsciiOfLength(random, 10);
        assert Thread.holdsLock(this);
                        try {
    public void assertRequestsFinished() {
import static org.opensearch.test.NodeRoles.noRoles;
    /**
        return getInstances(clazz, DATA_NODE_PREDICATE);
                }
    }
import org.opensearch.cluster.routing.OperationRouting;
    private final int numSharedCoordOnlyNodes;
            builder.put(TransportSettings.CONNECTIONS_PER_NODE_BULK.getKey(), random.nextInt(3) + 1);
            Node node = n.node;
        this.numSharedDataNodes = RandomNumbers.randomIntBetween(random, minNumDataNodes, maxNumDataNodes);
        }
    public void restartRandomDataNode() throws Exception {
            for (ShardId id : shardIds) {
                () -> rebuildUnicastHostFiles(nodes)
    }
        newNodes.put(nodeAndClient.name, nodeAndClient);
        return clusterManagerNode.getName();
                    Version.CURRENT,
    public <T> T getInstance(Class<T> clazz) {
        }
            settings.add(getNodeSettings(firstNodeId + i, random.nextLong(), extraSettings[i], defaultMinClusterManagerNodes));
        );
     * Restarts all nodes in a rolling restart fashion ie. only restarts on node a time.
        final List<NodeAndClient> toClose = new ArrayList<>();
import java.util.Collection;
                    env.shardLock(id, "InternalTestCluster assert after test", TimeUnit.SECONDS.toMillis(5)).close();
            final Settings nodeSettings = getNodeSettings(i, sharedNodesSeeds[i], Settings.EMPTY, defaultMinClusterManagerNodes);
        logger.info("Restarting node [{}] ", nodeAndClient.name);
            try {
        return startNode(settings1);
        }
        if (size < n) {
                && nodeAndClient.nodeAndClientId() < sharedNodesSeeds.length
                } else {
                .build();
                );
                        } catch (AlreadyClosedException ex) {
    public List<String> startSearchOnlyNodes(int numNodes, Settings settings) {
                            } else if (IndexShardTestCase.getEngine(indexShard) instanceof InternalEngine) {
                "Closing random non cluster-manager node [{}] current cluster-manager [{}] ",
    }
            throw new RuntimeException("Cluster is already closed");
        if (random.nextBoolean()) {
        final String clusterName,
    public List<String> startWarmOnlyNodes(int numNodes, Settings settings) {
            if (nodeAndClient.nodeAndClientId() >= sharedNodesSeeds.length) {
                    }
        /**
                )
            ? nodes.values().stream()
                        }
    }
    /**
    public void stopAllNodes() {
        builder.put(TransportSettings.TRANSPORT_COMPRESS.getKey(), rarely(random));
    public List<String> startDataOnlyNodes(int numNodes) {
import org.opensearch.common.Nullable;
        // always reduce this - it can make tests really slow
    public Set<String> getDataNodeNames() {
        Settings settings1 = Settings.builder().put(settings).put(dataOnlyNode(settings)).build();
        int size = numWarmNodes();
     */
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsAction;
            .map(entry -> entry.getKey())
                    newSettings.add(
        this.mockPlugins = mockPlugins;
        DiscoveryNodeRole.WARM_ROLE
                // that the breaker can sometimes be incremented from ping
        final String nodePrefix,
        }
                Set<Path> configPaths = Stream.concat(currentNodes.stream(), newNodes.stream())
import java.util.Map;
                    .forEach(excludedNodeNames::add);
                    false,
        final long seed,
     * Returns a node client to random node but not the cluster-manager. This method will fail if no non-cluster-manager client is available.
     * Ensures that at least <code>n</code> warm nodes are present in the cluster.
        final List<String> clusterManagerNodeNames = settings.stream()
        return new NodeAndClient(name, node, settings, nodeId);
import org.opensearch.plugins.PluginInfo;
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
                    IOUtils.rm(locations);
    }
        Client client = viaNode != null ? client(viaNode) : client();
                // update once cluster-managers have joined
 * this work for additional information regarding copyright
            }
                }
 * InternalTestCluster manages a set of JVM private nodes and allows convenient access to them.
                    .count() == 1) {
import java.net.InetSocketAddress;
        /**
                    "Missing cluster-manager" + debugString,
                    false,
    }
    public List<String> startDataAndWarmNodes(int numNodes) {
        Set<Class<? extends Plugin>> plugins = new LinkedHashSet<>(nodeConfigurationSource.nodePlugins());
        if (shardRouting == null || shardRouting.assignedToNode() == false) {
    public synchronized void restartRandomDataNode(RestartCallback callback) throws Exception {
    }
        final int numNodes = numDataNodes() - count;
    private final AtomicBoolean open = new AtomicBoolean(true);
 */
import static org.hamcrest.Matchers.nullValue;
            : numSharedDataNodes;
        int numNodesAndClients = 0;
        if (random.nextInt(10) == 0) { // 10% of the nodes have a very frequent check interval
            this.originalNodeSettings = originalNodeSettings;
 * Modifications Copyright OpenSearch Contributors. See
                TaskManager taskManager = getInstance(TransportService.class, nodeAndClient.name).getTaskManager();
                    throw new UnsupportedOperationException("");
                try {
        private void recreateNode(final Settings newSettings, final Runnable onTransportServiceStarted) {
                    );
        }
        return nodes.values()
        for (int i = 0; i < sharedNodesSeeds.length; i++) {
        final Set<DiscoveryNode> expectedNodes = new HashSet<>();
import org.opensearch.index.engine.Engine;
            if (indexService != null) {
         * Executed once the give node name has been stopped.
        }
            .node()
        // only reset the clients on nightly tests, it causes heavy load...
     */
                if (autoBootstrapClusterManagerNodeIndex == 0) {
        final int numClientNodes,
            return null;
        assertRequestsFinished();
    @Override
    public synchronized boolean stopRandomDataNode() throws IOException {
        );
        }
                    states.stream().mapToLong(ClusterState::term).distinct().count()
    @Override
                toClose.add(nodeAndClient);
                    false,
                    equalTo(0L)
        if (nodeAndClient != null) {
                                    + nodeAndClient.name
                        // the local knowledge on the primary of the global checkpoint equals the global checkpoint on the shard
        // prevent killing the cluster-manager if possible and client nodes
    /**
                + bootstrapClusterManagerNodeIndex;
                throw new AssertionError("unexpected", e);
                    Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(),
    }
        NodeAndClient nodeAndClient = getRandomNodeAndClient(InternalTestCluster.DATA_NODE_PREDICATE);
import org.opensearch.index.seqno.SeqNoStats;
     * Returns an Iterable to all instances for the given class &gt;T&lt; across all nodes in the cluster.
                firstNodeId + i,
     * Returns a reference to a random node's {@link ClusterService}
    }
    private void applyDisruptionSchemeToNode(NodeAndClient nodeAndClient) {
import org.opensearch.cluster.ClusterName;
                                "All incoming requests on node ["
        private final String nodeName;
        }
        for (int i = numSharedDedicatedClusterManagerNodes + numSharedDataNodes; i < numSharedDedicatedClusterManagerNodes
    public void setDisruptionScheme(ServiceDisruptionScheme scheme) {
        final NavigableMap<String, NodeAndClient> newNodes = new TreeMap<>(nodes);
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
            nodes.keySet(),
                    for (ShardRouting replicaShardRouting : indexShardRoutingTable.replicaShards()) {
            return false;
            stopNodesAndClient(nodeAndClient);
                for (IndexService indexService : indexServices) {
    /**
            updatedSettings.putList(
                    );
            }
import org.opensearch.core.index.shard.ShardId;
import static org.opensearch.cluster.coordination.ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING;
                if (replicaWriteBytes > 0) {
        final boolean forbidPrivateIndexSettings
        if (!open.get()) {
                if (primaryBytes > 0) {
                        "pending replica write bytes [" + combinedBytes + "] bytes on node [" + nodeAndClient.name + "]."
                if (nodeClient == null) {
                throw new RuntimeException("already closed");
    }
        NodeAndClient nodeAndClient = getRandomNodeAndClient(WARM_NODE_PREDICATE);
        }
        return startClusterManagerOnlyNode(Settings.EMPTY);
            TimeUnit.SECONDS,
            } else {
            Settings settings = Settings.builder()
        Random random = new Random(seed);
    private void assertNoPendingIndexOperations() throws Exception {
        if (Strings.hasLength(System.getProperty("opensearch.logger.prefix"))) {
            stopNodesAndClient(nodeAndClient);
import java.util.ArrayList;
    public Client clusterManagerClient() {
        for (NodeAndClient nodeAndClient : nodes.values()) {
        } else {
                        try {
     */
    private final Function<Client, Client> clientWrapper;
            + "]. call clearDisruptionScheme first";
    private IndexShard getShardOrNull(ClusterState clusterState, ShardRouting shardRouting) {
            .stream()
    public Collection<Class<? extends Plugin>> getPlugins() {
        assertOpenTranslogReferences();
            assert Thread.holdsLock(InternalTestCluster.this);
        warmAndDataRoles.add(DiscoveryNodeRole.WARM_ROLE);
    public InternalTestCluster(
            }, 30, TimeUnit.SECONDS);
                if (INITIAL_CLUSTER_MANAGER_NODES_SETTING.exists(callbackSettings) == false) {
        return getClusterManagerName(null);
        return builder.build();
    public static final int DEFAULT_LOW_NUM_CLUSTER_MANAGER_NODES = 1;
                }
    }
            builder.put(SearchService.KEEPALIVE_INTERVAL_SETTING.getKey(), timeValueSeconds(10 + random.nextInt(5 * 60)).getStringRep());
            nodeAndClients.forEach(this::publishNode);
    private Collection<NodeAndClient> warmDataNodeAndClients() {
     * @param onTransportServiceStarted callback to run when transport service is started
    }
                node.start();
        return startNodes(false, extraSettings);
    }
            }
import org.opensearch.index.shard.IndexShardTestCase;
            final int newClusterManagers = (int) nodeAndClients.stream()
        /**
    }
                        List<String> operations = indexShard.getActiveOperations();
        builder.append("-TEST_WORKER_VM=[").append(OpenSearchTestCase.TEST_WORKER_VM_ID).append(']');
        Randomness.shuffle(toStartAndPublish);
    /**
            try {
                re.addSuppressed(new RuntimeException("failed to start nodes"));
    /**
                    updatedSettings.get(DiscoverySettings.INITIAL_STATE_TIMEOUT_SETTING.getKey()),
    }
            toStartAndPublish.add(nodeAndClient);
                    return iterator.next().client();
    public int size() {
        final List<NodeAndClient> nodes = new ArrayList<>();
                try {
            this.name = name;
        return allDataNodesButN(0);
        Random random = new Random(clusterSeed);
        }
                Stream<NodeAndClient> unicastHosts = Stream.concat(currentNodes.stream(), newNodes.stream());
            }
        for (NodeAndClient nodeAndClient : toStartAndPublish) {
                    IOUtils.closeWhileHandlingException(node);
        if (random.nextBoolean()) {
    private NodeAndClient getOrBuildRandomNode() {
                settings.add(removeRoles(nodeSettings, Collections.singleton(DiscoveryNodeRole.MASTER_ROLE)));
    }
        try {
                return clientWrapper.apply(nodeClient);
        }
        if (settings != null) {
    private synchronized void stopNodesAndClients(Collection<NodeAndClient> nodeAndClients) throws IOException {
    public int numWarmAndDataNodes() {
    private final Collection<Class<? extends Plugin>> mockPlugins;
        return startNodes(numNodes, Settings.builder().put(onlyRole(settings, DiscoveryNodeRole.WARM_ROLE)).build());
    }
    public static final RestartCallback EMPTY_CALLBACK = new RestartCallback();
    public NamedWriteableRegistry getNamedWriteableRegistry() {
            );
            if (closed.get() == false) {
                if (combinedBytes > 0) {
    }
        return startNode(settings.build());
        private void clearDataIfNeeded(RestartCallback callback) throws IOException {
import static org.opensearch.test.NodeRoles.removeRoles;
    public ClusterService clusterService() {
     * builds a new node
            }
            if (numDataAndClusterManagerNodes() != numClusterManagerNodes()) {
                    false,
import org.opensearch.env.Environment;
    private final AtomicInteger nextNodeId = new AtomicInteger(0);
            logger.info("Stopping and resetting node [{}] ", nodeAndClient.name);
        } catch (IOException e) {
            nodePrefix,
            validateClusterFormed();
                        } catch (AlreadyClosedException e) {
    }
            }
            final NodeAndClient nodeAndClient = buildNode(
            for (ShardRouting shardRouting : allShards) {
     */
                            if (engine instanceof InternalEngine) {
        final List<Settings> updatedSettings = bootstrapClusterManagerNodeWithSpecifiedIndex(settings);
                builder.put("indices.fielddata.cache.size", 1 + random.nextInt(1000), ByteSizeUnit.MB);
 * {@link #afterTest()} to initialize and reset the cluster in order to be more reproducible. The term "more" relates
                    nullValue()
                for (final Path configPath : configPaths) {
        int totalClusterManagerNodes = numClusterManagerNodes();
        );
            true
        }
                nodeConfigurationSource.nodeConfigPath((int) newIdSeed),
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
    /**
                }
                timeValueMillis(RandomNumbers.randomIntBetween(random, 750, 10000000)).getStringRep()
            logger.info("removing voting config exclusions for {} after restart/shutdown", excludedNodeIds);
        applyDisruptionSchemeToNode(nodeAndClient);
                }
                .put(originalNodeSettings)
        final List<NodeAndClient> toStartAndPublish = new ArrayList<>(); // we want to start nodes in one go
    private static final Predicate<NodeAndClient> DATA_NODE_PREDICATE = nodeAndClient -> DiscoveryNode.isDataNode(
                        } catch (AlreadyClosedException ignored) {
                    throw new AssertionError("unexpected", e);
    public String startNode(Settings settings) {
        NodeNamePredicate(String nodeName) {
    public List<String> startDataOnlyNodes(int numNodes, Settings settings, Boolean ignoreNodeJoin) {
import static org.hamcrest.Matchers.equalTo;
                    false,
    }
                            docsOnReplica = IndexShardTestCase.getDocIdAndSeqNos(replicaShard);
            validateClusterFormed();
        }
            int retryTimeoutSeconds = RandomNumbers.randomIntBetween(random, 0, 60);
 * are involved reproducibility is very limited. This class should only be used through {@link OpenSearchIntegTestCase}.
            if (useDedicatedClusterManagerNodes) {
                                    indexShard.routingEntry().toString() + " has unreleased snapshotted index commits",
        String suffix = "";
import java.util.concurrent.TimeUnit;
        }
        return defaultSettings;
    public synchronized Client client() {
        assert Thread.holdsLock(this);
                                    + bytesUsed
    }
                        continue; // just ignore - shard movement
 * KIND, either express or implied.  See the License for the
    @Override
                } catch (InterruptedException e) {
                } catch (ShardLockObtainFailedException ex) {
    public void assertSameDocIdsOnShards() throws Exception {
        this.clusterName = clusterName;
        final int prevClusterManagerCount = getClusterManagerNodesCount();
            activeDisruptionScheme.applyToNode(nodeAndClient.name, this);
    /**
        if (bootstrapClusterManagerNodeIndex == -1) { // fast-path
        if (random.nextInt(10) == 0) {
    public int numDataAndClusterManagerNodes() {
        private Client nodeClient;
            numSharedDedicatedClusterManagerNodes,
        if (maxNumDataNodes < minNumDataNodes) {
            );
                    stats.getIndices().getQueryCache().getMemorySizeInBytes(),
            0,
 * Unless required by applicable law or agreed to in writing,
        startDataOnlyNodes(totalDataNodes);
            OpenSearchExecutors.daemonThreadFactory("test_" + clusterName),
import org.opensearch.action.support.replication.TransportReplicationAction;
                                    EngineTestCase.hasSnapshottedCommits(engine)
        }
        }
        return startNodes(numNodes, Settings.builder().put(searchOnlyNode(settings)).build());
        return getInstanceFromNode(clazz, randomNodeAndClient.node);
            }
     */
    }
    private String buildNodeName(int id, Settings settings) {
    }
        }
            } catch (NodeValidationException e) {
            );
    private final Object discoveryFileMutex = new Object();
 * ownership. Elasticsearch licenses this file to you under
        builder.put(TransportSettings.PORT.getKey(), 0);
        return getInstance(clazz, CLUSTER_MANAGER_NODE_PREDICATE);
                    for (IndexShard indexShard : indexService) {
import static org.apache.lucene.tests.util.LuceneTestCase.TEST_NIGHTLY;
            removeDisruptionSchemeFromNode(nodeAndClient);
        NodeAndClient(String name, MockNode node, Settings originalNodeSettings, int nodeAndClientId) {
            } else {
                    .filter(n -> n.nodeAndClientId() < sharedNodesSeeds.length)
        int currentNodeId = numClusterManagerNodes() - 1;
                // Anything that uses transport or HTTP can increase the
            Settings.Builder newSettings = Settings.builder();
     * Note: use this with care tests should not rely on a certain nodes client.
            } finally {
    }
            return Settings.EMPTY;
    }
                                    + " on node ["
                    }
        return startNodes(settings).get(0);
                    onTransportServiceStarted.run();
     * Restarts a node.
                }
            logger.info("increasing cluster size from {} to {}", size, n);
import java.util.function.Predicate;
import com.carrotsearch.randomizedtesting.generators.RandomStrings;
    }
    }
                    for (ShardRouting replicaShardRouting : indexShardRoutingTable.replicaShards()) {
    );
        Map<String, NodeAndClient> dataNodes = nodes.entrySet()
            for (NodeAndClient nodeAndClient : nodes.values()) {
        }
import java.util.Iterator;
            final Builder builder = Settings.builder();
        // randomize tcp settings
            defaultMinClusterManagerNodes = -1;
    }
import org.opensearch.test.disruption.ServiceDisruptionScheme;
 */
            if (DiscoveryNode.isClusterManagerNode(nodeSettings)) {
            );
                        + "' as a node setting set '"
import org.opensearch.indices.recovery.RecoverySettings;
        final int prevNodeCount = nodes.size();
import org.opensearch.common.util.PageCacheRecycler;
            if (callback.clearData(name)) {
    }
        throw new AssertionError("No smart client found");
    public synchronized void fullRestart(RestartCallback callback) throws Exception {
    private Settings getNodeSettings(
                // fail if it never reached 0
                                .stream()
            .get()
                && nodeAndClient.isClusterManagerEligible()
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;
    private void assertOpenTranslogReferences() throws Exception {
    }
                    }
    public void fullRestart() throws Exception {
        public void onAllNodesStopped() throws Exception {}
        ensureOpen();
            DiscoveryNodes discoveryNodes = clusterService().state().getNodes();
import java.io.Closeable;
                    assertBusy(() -> assertThat("Fielddata breaker not reset to 0 on node: " + name, fdBreaker.getUsed(), equalTo(0L)));
    }
        if (clusterService().state().routingTable().hasIndex(index)) {
                mockTransportService.clearAllRules();
    }
        }
        }
        }
                    .map(NodeAndClient::getName)
            if (activeDisruptionScheme != null) {
            logger.debug(
                throw new IllegalStateException("node " + name + " should be closed before recreating it");
                suffix = suffix + DiscoveryNodeRole.CLUSTER_MANAGER_ROLE.roleNameAbbreviation();
        final int nodeId,
        private final int nodeAndClientId;
                    .getIndicesFieldDataCache();
        // visible to later plugins' createComponents() only when init order respects declared
        }
            nodeAndClient.close();
        final int maxNumDataNodes,
    }
import java.util.TreeMap;
            final Iterator<NodeAndClient> iterator = nodes.values().iterator();
            Set<String> nodes = new HashSet<>();
        return getInstance(clazz, new NodeNamePredicate(getClusterManagerName()));
        String name = settings.get("node.name");
        return node.injector().getInstance(clazz);
    /**
            return randomNodeAndClient.nodeClient();
import java.util.concurrent.ExecutorService;
            nextNodeId.get(),
    public List<String> startDataOnlyNodes(int numNodes, Settings settings) {
        assert reuseExisting || nodeAndClient == null : "node name [" + name + "] already exists but not allowed to use it";
        return getInstance(ClusterService.class, node);
                        primarySeqNoStats = primaryShard.seqNoStats();
                        if (DiscoveryNode.isClusterManagerNode(nodeSettings)) {
                    .collect(Collectors.toList());
                assertThat(
                throw new IllegalStateException(
    }
                RandomNumbers.randomIntBetween(random, 2, 5)
        assertBusy(() -> {
                    // use a dedicated cluster-manager, but only low number to reduce overhead to tests
            }
                        logger.info("Failed to wipe data directory for node location: {}", path);
                } catch (Exception e) {
            return randomNodeAndClient.client();
        }
        for (int i = 0; i < numSharedDedicatedClusterManagerNodes + numSharedDataNodes + numSharedCoordOnlyNodes; i++) {
            } catch (InterruptedException | ExecutionException e) {
import org.opensearch.cluster.node.DiscoveryNodes;
     * Restarts all nodes in the cluster. It first stops all nodes and then restarts all the nodes again.
                states.forEach(cs -> {
                );
                    List<String> nodeNames = new ArrayList<>();
            maxNumDataNodes,
        randomlyResetClients();
/*
            }
     * Returns a client to a coordinating only node
            if (closed.get()) {
        Node node() {
                resetClient();
        builder.put(
    }
                // multiple ES testing jobs in parallel on the same machine.
        for (int i = 0; i < numOfNodes; i++) {
     * Replace all nodes by stopping all current node and starting new node.
        for (int i = numSharedDedicatedClusterManagerNodes; i < numSharedDedicatedClusterManagerNodes + numSharedDataNodes; i++) {
                    .filter(Objects::nonNull)
                    ShardRouting primaryShardRouting = indexShardRoutingTable.primaryShard();
                .count();
        }
                && autoManageClusterManagerNodes
            nodeAndClient.recreateNode(newNodeSettings[nodeAndClient.nodeAndClientId()], () -> rebuildUnicastHostFiles(toStartAndPublish));
        public boolean validateClusterForming() {
                IndicesService indexServices = getInstance(IndicesService.class, nodeAndClient.name);
            builder.put(SearchService.KEEPALIVE_INTERVAL_SETTING.getKey(), timeValueMillis(10 + random.nextInt(2000)).getStringRep());
        final boolean randomlyAddDedicatedClusterManagers,
     * It's only possible to change {@link #bootstrapClusterManagerNodeIndex} value if autoManageClusterManagerNodes is false.
    private final Logger logger = LogManager.getLogger(getClass());
    }
     */
                assertTrue(
        return getInstance(clazz, DATA_NODE_PREDICATE);
import org.opensearch.core.common.unit.ByteSizeValue;
                }
        }
                    greaterThan(shard)
        assert autoManageClusterManagerNodes == false || bootstrapClusterManagerNodeIndex == -1
 * <p>
     */
        // test that have ongoing write operations after the test (for example because ttl is used
        super.beforeTest(random);
            builder.put(
import static org.opensearch.test.OpenSearchTestCase.assertBusy;
        final Path baseDir,
                                equalTo(syncGlobalCheckpoints.get(replicaShardRouting.allocationId().getId()))
        activeDisruptionScheme = scheme;
    private final long[] sharedNodesSeeds;
        }
        ensureOpen();
        logger.debug(
                        .getId();
        builder.append("-CLUSTER_SEED=[").append(clusterSeed).append(']');
    private <T> Iterable<T> getInstances(Class<T> clazz, Predicate<NodeAndClient> predicate) {
    }
        // Components from earlier plugins (e.g. those registered via PluginComponentRegistry) are
        return getInstance(clazz, nc -> true);
     * Stops the current cluster-manager node forcefully.
     * Used for remote store test cases, where remote state is restored.
                activeDisruptionScheme.removeFromNode(nodeAndClient.name, this);
                final String name = nodeAndClient.name;
        if (randomNodeAndClient != null) {
        return warmNodeAndClients().size();
            logger.info("increasing cluster size from {} to {}", size, n);
        }
        // from failing on nodes without enough disk space
        }
                ScriptService.SCRIPT_CACHE_SIZE_SETTING.getConcreteSettingForNamespace(ctx).getKey(),
                                    + nodeAndClient.name
            }
        return startNodes(numNodes, Settings.builder().put(onlyRole(settings, DiscoveryNodeRole.DATA_ROLE)).build(), ignoreNodeJoin);
        }
            }
        startAndPublishNodesAndClients(nodes);
        for (NodeAndClient nodeAndClient : nodes.values()) {
        final Settings newSettings = nodeAndClient.closeForRestart(
    private void ensureOpen() {
            .settings()
import org.opensearch.common.unit.TimeValue;
                            if (IndexShardTestCase.getEngine(indexShard) instanceof IngestionEngine) {
                        if (replicaShard == null) {
        }
                    false,
        return dataNodeAndClients().size();
        Client client() {
        FileCache fileCache = nodeAndClient.node().fileCache();
        if (clusterManagerNode == null) {
        /** returns true if the restart should also validate the cluster has reformed */
                List<String> discoveryFileContents = unicastHosts.map(nac -> nac.node.injector().getInstance(TransportService.class))
    }
                    false,
        throw new AssertionError("No node found with name: [" + nodeName + "]");
    /**
         * Executed for each node before the {@code n + 1} node is restarted. The given client is
    }
                    }
                            String pendingTasks = taskManager.getTasks()
        fullRestart(EMPTY_CALLBACK);
                    nodeClient = node.client();
                    }
        final Runnable onTransportServiceStarted = () -> {}; // do not create unicast host file for this one node.
    ) {
    }
                        assertThat(replicaShardRouting + " seq_no_stats mismatch", seqNoStats, equalTo(primarySeqNoStats));
    /**
        sharedNodesSeeds = new long[numSharedDedicatedClusterManagerNodes + numSharedDataNodes + numSharedCoordOnlyNodes];
        NodeAndClient nodeAndClient = nodes.get(nodeName);
    public <T> T getDataNodeInstance(Class<T> clazz) {
    static final int DEFAULT_MIN_NUM_DATA_NODES = 1;
            while (totalClusterManagerNodes > 1) {
        assert size() == newSize;
            IndexService indexService = indicesService.indexService(index);
            autoManageClusterManagerNodes,
            if (DiscoveryNode.isClusterManagerNode(settings)) {
    private Set<String> excludeClusterManagers(Collection<NodeAndClient> nodeAndClients) {
        } catch (IOException e) {
     * if more nodes than <code>n</code> are present this method will not
                        }
            numSharedDataNodes,
    static final int DEFAULT_MAX_NUM_CLIENT_NODES = 1;
            .map(Node.NODE_NAME_SETTING::get)
            assert callbackSettings != null;
            if (nodeEnv.hasNodeFile()) {
    }
                    "Query cache size must be 0 on node: " + stats.getNode(),
                    });
        ensureOpen(); // currently unused
    @Override
        } else {
        updatedSettings.put(Environment.PATH_HOME_SETTING.getKey(), baseDir);
                assert excludedNodeNames.size() == stoppingClusterManagers;
    /**
        return builder.toString();
import java.util.concurrent.ExecutionException;
        throw new AssertionError("No cluster-manager client found");
            set.add(iterator.next());
    private final int numSharedDataNodes;
        return getNodePrefix(settings) + id;
     */
import static org.junit.Assert.assertFalse;
        // and not all docs have been purged after the test) and inherit from
            throw new IllegalArgumentException("minimum and maximum number of data nodes must be >= 0");
    }
            toStartAndPublish.add(nodeAndClient);
import org.opensearch.indices.IndicesService;
        } else {
        super(clusterSeed);
            if (stoppingClusterManagers != currentClusterManagers && stoppingClusterManagers > 0) {
    }
                throw new RuntimeException("already closed");
import java.util.stream.IntStream;
                forbidPrivateIndexSettings
                CommonStatsFlags flags = new CommonStatsFlags(Flag.FieldData, Flag.QueryCache, Flag.Segments);
    private final int numSharedDedicatedClusterManagerNodes;
            randomlyAddDedicatedClusterManagers,
    public void closeNonSharedNodes(boolean wipeData) throws IOException {
    static final int DEFAULT_MAX_NUM_DATA_NODES = TEST_NIGHTLY ? 6 : 3;
        if (excludedNodeIds.isEmpty() == false) {
        ensureOpen();
     * Returns the name of the current cluster-manager node in the cluster.
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsRequest;
import org.apache.logging.log4j.LogManager;
    /**
                        syncGlobalCheckpoints = primaryShard.getInSyncGlobalCheckpoints();
                    "1.8",
            FileCache fileCache = nodeAndClient.node().fileCache();
        callback.onAllNodesStopped();
    public InetSocketAddress[] httpAddresses() {
                }
        startAndPublishNodesAndClients(toStartAndPublish);
                }
    /** calculates a min cluster-manager nodes value based on the given number of cluster-manager nodes */
        // it depends on, despite being listed first in nodePlugins()).
        }
            restartNode(nodeAndClient, callback);
            assert Thread.holdsLock(InternalTestCluster.this);
            );
import org.opensearch.index.engine.DocIdSeqNoAndSource;
     */
                        // ensure that our size accounting on transport level is reset properly
                    DEFAULT_MAX_NUM_CLIENT_NODES
    @Override
                        + "]"
        final Iterator<NodeAndClient> values = collection.iterator();
        }
    private NodeAndClient removeNode(NodeAndClient nodeAndClient) {
                onTransportServiceStarted.run();
    @Override
            } finally {
    /**
            nextNodeId.get(),
        if (nodeAndClient != null) {
                    // see #ensureEstimatedStats()
                    false,
     */
    public <T> Iterable<T> getDataOrClusterManagerNodeInstances(Class<T> clazz) {
        final Collection<Class<? extends Plugin>> mockPlugins,
            }
        Builder builder = Settings.builder();
            }
import static org.opensearch.discovery.DiscoveryModule.DISCOVERY_TYPE_SETTING;
            }
                NodeService nodeService = getInstanceFromNode(NodeService.class, nodeAndClient.node);
        if (fileCache != null && WARM_NODE_PREDICATE.test(nodeAndClient)) {
                startDataOnlyNodes(n - size);
        }
            );
    private final NodeConfigurationSource nodeConfigurationSource;
            .filter(entry -> CLUSTER_MANAGER_NODE_PREDICATE.test(entry.getValue()))
        assert nodes.isEmpty();
                    .map(node -> getInstanceFromNode(ClusterService.class, node.node()))
    /**
        }
                finalSettings,
        if (size <= n) {
        }, 30, TimeUnit.SECONDS);
    private synchronized void publishNode(NodeAndClient nodeAndClient) {
                throw re;
        for (NodeAndClient nodeAndClient : nodes.values()) {
 */
        publishNode(nodeAndClient);
     * Returns an Iterable to all instances for the given class &gt;T&lt; across all data nodes in the cluster.
        if (!dataDirToClean.isEmpty()) {
                    equalTo(0L)
    /**
                .allMatch(s -> DiscoveryNode.isClusterManagerNode(s) == false || ZEN2_DISCOVERY_TYPE.equals(DISCOVERY_TYPE_SETTING.get(s)))
        }
                .put(
    }
                    new ByteSizeValue(RandomNumbers.randomIntBetween(random, 1, 10), ByteSizeUnit.MB)
                    if (cs.nodes().getNodes().values().stream().findFirst().get().isRemoteStoreNode()) {
     * @param settings                  the settings to use
                IndexingPressure indexingPressure = getInstance(IndexingPressure.class, nodeAndClient.name);
        return suffix;
                    } catch (AlreadyClosedException ex) {
            .map(
    public void ensureEstimatedStats() {
            builder.put("logger.level", System.getProperty("tests.opensearch.logger.level"));
    public List<String> startWarmOnlyNodes(int numNodes) {
    }
     * Starts multiple nodes with the given settings and returns their names
    public String startClusterManagerOnlyNode() {
     * stages of the restart.
            if (wipeData) {
                        try {
    public List<String> startSearchOnlyNodes(int numNodes) {
    }
        return filterNodes(nodes, DATA_NODE_PREDICATE);
                    states.stream().allMatch(cs -> cs.nodes().getClusterManagerNodeId() != null)
        return getInstance(clazz, nc -> node == null || node.equals(nc.name));
                    false,
            final Builder extraSettings = Settings.builder().put(noRoles());
        return map.values().stream().filter(predicate).collect(Collectors.toCollection(ArrayList::new));
     * Starts a node with the given settings builder and returns its name.
    /**
    /**
        logger.info(
            // we have to validate cluster size to ensure that the restarted node has rejoined the cluster if it was
                for (Path path : dataDirToClean) {
    );
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        public boolean isClusterManagerEligible() {
    }
                assertThat(
    /* Sorted map to make traverse order reproducible.
        final Settings nodeSettings = Settings.builder()
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return startNode(Settings.builder().put(settings).put(searchOnlyNode(settings)).build());
        Settings settings = nodeConfigurationSource.nodeSettings(nodeOrdinal);
    }
        builder.put(Environment.PATH_HOME_SETTING.getKey(), baseDir);
        );
    public synchronized void close() throws IOException {
        }
 * license agreements. See the NOTICE file distributed with
                @Override
                // TODO add cluster health API to check that voting configuration is optimal so this isn't always needed
        assert this.numSharedDataNodes >= 0;
                }
        }
        return filterNodes(nodes, WARM_AND_DATA_NODE_PREDICATE);
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            if (random.nextBoolean()) {
    }
        try {
                    }
        Predicate<NodeAndClient> predicate
        );
    /**
    }
            && newClusterManagerCount > 0
        }
    /* Each shared node has a node seed that is used to start up the node and get default settings
                        if (replicaShard == null) {
                    }
            for (IndexService indexService : indexServices) {
                autoBootstrapClusterManagerNodeIndex = RandomNumbers.randomIntBetween(random, 0, numSharedDedicatedClusterManagerNodes - 1);
import org.opensearch.node.NodeValidationException;
    }
        return startDataAndWarmNodes(numNodes, Settings.EMPTY);
    public Client smartClient() {
                for (IndexService indexService : indexServices) {
     * Stops a random warm node in the cluster. Returns true if a node was found to stop, false otherwise.
import org.opensearch.action.admin.indices.stats.CommonStatsFlags.Flag;
        final int newClusterManagerCount = Math.toIntExact(Stream.of(extraSettings).filter(DiscoveryNode::isClusterManagerNode).count());
import java.util.concurrent.atomic.AtomicInteger;
    }
                    throw new AssertionError(
                                IndexShardTestCase.getTranslog(indexShard).getDeletionPolicy().assertNoOpenTranslogRefs();
                    false
        NodeAndClient nodeAndClient = getRandomNodeAndClient(DATA_NODE_PREDICATE);
                    fail("Shard " + id + " is still locked after 5 sec waiting");
        }
                public Client next() {
    private static String getRoleSuffix(Settings settings) {
                if (success == false) {
                    false,
import org.opensearch.core.common.Strings;
            final long newIdSeed = NodeEnvironment.NODE_ID_SEED_SETTING.get(node.settings()) + 1;
 * GitHub history for details.
                                + "] vs replica=["
        return startNode(noRoles(settings));
                MappingUpdatedAction.INDICES_MAPPING_DYNAMIC_TIMEOUT_SETTING.getKey(),
     * this is important if a node is randomly shut down in a test since the next test relies on a
        final Settings settings = getNodeSettings(nodeId, random.nextLong(), Settings.EMPTY, 1);
            minNumDataNodes,
        return null;
            return nodeAndClientId;
import org.opensearch.transport.TransportService;
                    false,
        if (randomNodeAndClient != null) {
            RandomNumbers.randomIntBetween(random, 1, 5)
                    throw new AssertionError("Exception during check for request breaker reset to 0", e);
     * filter.
     * Returns a node client to the current cluster-manager node.
import static org.hamcrest.Matchers.not;
    synchronized Set<String> allDataNodesButN(int count) {
    }
                    logger.debug("removing node data paths: [{}]", Arrays.toString(locations));
    /**
            }
        final String clusterName,
         */
        Builder builder = Settings.builder();
        assert Thread.holdsLock(this);
                    } catch (AlreadyClosedException ex) {
import java.util.List;
            logger.info("Closing filtered random node [{}] ", nodeAndClient.name);
        return getInstances(clazz, DATA_NODE_PREDICATE.or(CLUSTER_MANAGER_NODE_PREDICATE));
            // network request, because a network request can increment one
    }
        ensureOpen();
        return filterNodes(nodes, DATA_NODE_PREDICATE.or(CLUSTER_MANAGER_NODE_PREDICATE)).size();
     *                                  the method will return the existing one
                currentNodeId++;
            }
     * Stops all running nodes in cluster
 */
        if (minNumDataNodes < 0 || maxNumDataNodes < 0) {
            int totalClusterManagerNodes = numClusterManagerNodes();
     */
            secureSettings = ((MockSecureSettings) secureSettings).clone();
                logger.debug("configuring discovery with {} at {}", discoveryFileContents, configPaths);
    private static final class NodeNamePredicate implements Predicate<NodeAndClient> {
        // TODO: currently we only randomize "cluster.no_cluster_manager_block" between "write" and "metadata_write", as "all" is fragile
        public int nodeAndClientId() {
        private MockNode node;
import org.opensearch.transport.TransportSettings;
                    "classpath plugin",
        SecureSettings secureSettings = Settings.builder().put(settings).getSecureSettings();
        return startNodes(numNodes, Settings.builder().put(onlyRole(settings, DiscoveryNodeRole.DATA_ROLE)).build());
        if (Strings.hasLength(System.getProperty("tests.opensearch.logger.level"))) {
        return builder.build();
    private synchronized void startAndPublishNodesAndClients(List<NodeAndClient> nodeAndClients) {
                }
    }
                final long combinedBytes = indexingPressure.getCurrentCombinedCoordinatingAndPrimaryBytes();
     */
            callback,
                        }
                    false,
                    fail("Could not assert finished requests within timeout on node [" + nodeAndClient.name + "]");
        }
            }
        }
/*
                    final SeqNoStats primarySeqNoStats;
    }
    }
            startNodes(n - size, Settings.builder().put(onlyRoles(settings, warmAndDataRoles)).build());
    public void resetCluster() {
    }
     */
                } catch (Exception e) {
        assert nodePrefix != null;
                        Settings.builder()
    public List<String> startClusterManagerOnlyNodes(int numNodes, Settings settings) {
    ) {
    }
     */
            mockPlugins,
                    .stream()
                p -> new PluginInfo(
        boolean useDedicatedClusterManagerNodes = randomlyAddDedicatedClusterManagers ? random.nextBoolean() : false;
        this.nodePrefix = nodePrefix;
            } else {
            ClusterService clusterService = getInstanceFromNode(ClusterService.class, node);
                    if (node.awaitClose(10, TimeUnit.SECONDS) == false) {
                    for (IndexShard indexShard : indexService) {
                );
        // The assumption here is that after a test there are no ongoing write operations.
        for (NodeAndClient nodeAndClient : filteredNodes) {
                }
     */
            if (DiscoveryNode.isDataNode(settings)) {
        }
    }
            stopNodesAndClient(nodeAndClient);
    public synchronized void restartNode(String nodeName, RestartCallback callback) throws Exception {
        return clusterName;
     */
            new ThreadContext(Settings.EMPTY)
            }
        }
        nodeAndClient.node.settings(),
                    throw new AssertionError("pending primary bytes [" + primaryBytes + "] bytes on node [" + nodeAndClient.name + "].");
        Collection<PluginInfo> additionalNodePlugins = nodeConfigurationSource.additionalNodePlugins();
                        continue; // shard is closed - just ignore
            Integer.MAX_VALUE,
            if (autoManageClusterManagerNodes
                for (IndexService indexService : indexServices) {
     * if more nodes than <code>n</code> are present this method will not
        return () -> {
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
            this.node = node;
                }
    /**
        }
            }
        }, 60, TimeUnit.SECONDS);
    }
        for (int i = 0; i < numNodes; i++) {
 * to the async nature of OpenSearch in combination with randomized testing. Once Threads and asynchronous calls
        }
                + "[{}] (data) nodes and [{}] coord only nodes (min_cluster_manager_nodes are [{}])",
    /**
        return null;
            .collect(Collectors.toList());
                activeDisruptionScheme.removeFromCluster(this);
        this.baseDir = baseDir;
        }
            builder.put("logger.prefix", System.getProperty("opensearch.logger.prefix"));
    }
     */
    private List<Settings> bootstrapClusterManagerNodeWithSpecifiedIndex(List<Settings> allNodesSettings) {
            assert stoppingClusterManagers <= currentClusterManagers : currentClusterManagers + " < " + stoppingClusterManagers;
            }
                node.getClasspathPlugins(),
        Settings settings = getSettings(nodeId, random.nextLong(), Settings.EMPTY);
        fail("Could not find a node that holds " + index);
            }
        if (size() > 0) {
                    }
        }
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING.getKey(),
import org.opensearch.common.settings.MockSecureSettings;
                Releasables.close(nodeClient);
                    false,
        if (random.nextBoolean()) {
    private final Path baseDir;
import org.opensearch.index.shard.IndexShard;
        return buildNode;
                    final Map<String, Long> syncGlobalCheckpoints;
            newNodeSettings[nodeAndClient.nodeAndClientId()] = newSettings;
        if (randomNodeAndClient != null) {
    }
            expectedNodes.add(getInstanceFromNode(ClusterService.class, nodeAndClient.node()).localNode());
    public synchronized Client coordOnlyNodeClient() {
                for (Future<?> future : futures) {
            builder.put(
import org.opensearch.common.settings.SecureSettings;
        this.clientWrapper = clientWrapper;
import org.opensearch.http.HttpServerTransport;
        if (!nodesToRemove.isEmpty() && size() > 0) {
        return startNodes(Collections.nCopies(numOfNodes, settings).toArray(new Settings[0]));
    public Client client(String nodeName) {
    public String startDataOnlyNode(Settings settings) {
                    builder.putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), initialClusterManagerNodes);
            builder.put(TransportReplicationAction.REPLICATION_INITIAL_RETRY_BACKOFF_BOUND.getKey(), timeValueMillis(initialMillisBound));
        final List<String> initialClusterManagerNodes = settings.stream()
                            assertThat(indexShard.routingEntry().toString(), EngineTestCase.getInFlightDocCount(engine), equalTo(0L));
                dataDirToClean.clear();
    private ServiceDisruptionScheme activeDisruptionScheme;
        }
            return true;
        NodeAndClient nodeAndClient = getRandomNodeAndClient(nc -> filter.test(nc.node.settings()));
        assert randomNodeAndClient != null;
        List<T> instances = new ArrayList<>();
            ? numSharedDedicatedClusterManagerNodes
            return getOrBuildNodeClient();
                            equalTo(docsOnPrimary)
            }
 * under the License.
import org.opensearch.env.NodeEnvironment;
    private static final Predicate<NodeAndClient> WARM_NODE_PREDICATE = nodeAndClient -> DiscoveryNode.hasRole(
                        + settings.get(ClusterName.CLUSTER_NAME_SETTING.getKey())
import org.opensearch.cluster.routing.ShardRouting;
                this.numSharedDedicatedClusterManagerNodes = 0;
            removeNode(this);
    private static final String DEFAULT_WARM_CACHE_SIZE_BYTES = "2gb";
            TimeValue expectedHealingTime = activeDisruptionScheme.expectedTimeToHeal();
            } else {
                        if (operations.size() > 0) {
        }
            } else {
        }
        assertBusy(() -> {
                RandomNumbers.randomIntBetween(random, 5, 10)
            throw new IllegalStateException("cluster failed to form", ae);
    public String startSearchOnlyNode() {
        final int maxNumDataNodes,
        return false;
        }
        }
                            );
                                    + "; pending tasks ["
 *
            builder.put(TransportSettings.CONNECTIONS_PER_NODE_REG.getKey(), random.nextInt(6) + 1);
                @Override
import org.opensearch.action.admin.cluster.configuration.ClearVotingConfigExclusionsRequest;
                                + docsOnPrimary.size()
        reset(true);
    }
        NodeAndClient randomNodeAndClient = getRandomNodeAndClient();
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING.getKey(),
        }
        // Use LinkedHashSet so plugin iteration order matches the user's nodePlugins() declaration.
            nodes.add(nodeAndClient);
        if (nodeAndClient != null) {
            .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), Node.NODE_NAME_SETTING.get(settings))
     * and / or {@link #fullRestart(InternalTestCluster.RestartCallback)} to execute actions at certain
            assert iterator.hasNext();
        updatedSettings.put(Environment.PATH_SHARED_DATA_SETTING.getKey(), baseDir.resolve(name + "-shared"));
        }
                        + ClusterName.CLUSTER_NAME_SETTING.getKey()
        private void markNodeDataDirsAsNotEligibleForWipe(Node node) {
        NodeAndClient nodeAndClient = nodes.get(nodeName);
            && Arrays.stream(extraSettings)
        builder.put(
import org.opensearch.index.engine.EngineTestCase;
        builder.put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), false);
                IOUtils.close(nodes.values());
        if (this.open.compareAndSet(true, false)) {
        for (int i = 0; i < numOfNodes; i++) {
                if (nodeEnv.hasNodeFile()) {
                                    + "]"
import static org.junit.Assert.fail;
        final int numClientNodes,
                if (currentNodeId != bootstrapClusterManagerNodeIndex) {
    public <T> Iterable<T> getInstances(Class<T> clazz) {
        // clean up what the nodes left that is unused
        assertNoPendingIndexOperations();
            // cluster-manager-eligible;
    public String getClusterManagerName() {
    public List<String> startClusterManagerOnlyNodes(int numNodes) {
        int size = numWarmAndDataNodes();
                    false,
                    assertBusy(() -> {
                throw new AssertionError("failed to configure file-based discovery", e);
    public Settings dataPathSettings(String node) {
import static org.opensearch.test.NodeRoles.searchOnlyNode;
                            .put(settings)
    public synchronized List<String> startNodes(Settings... extraSettings) {
            if (numSharedDedicatedClusterManagerNodes > 0) {
import org.opensearch.cluster.routing.IndexRoutingTable;
        updatedSettings.put(settings);
                    .map(n -> n.getAddress().toString())
            if (!DiscoveryNode.isClusterManagerNode(settings) && !DiscoveryNode.isDataNode(settings)) {
     */
     */
    }
        @Override
            );
        return settings -> nodes.contains(settings.get("node.name"));
                logger.debug("Close Node [{}] not shared", nodeAndClient.name);
import org.opensearch.search.SearchService;
                }
        void resetClient() {
    private void stopNodesAndClient(NodeAndClient nodeAndClient) throws IOException {
    }
    @Override
        builder.put(ClusterName.CLUSTER_NAME_SETTING.getKey(), clusterName);
    public synchronized void clearDisruptionScheme(boolean ensureHealthyCluster) {
                    assertEquals("Node size mismatch" + debugString, expectedNodes.size(), discoveryNodes.getSize());
        nodeAndClient.startNode();
        ensureOpen();
                    newSettings.putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey());
        return set;
    }
        final int defaultMinClusterManagerNodes
            for (NodeAndClient nodeAndClient : nodes.values()) {
                while (totalDataNodes > 0) {
                        }
 * automatically load asserting services tracking resources like file handles or open searchers.
                        + ClusterName.CLUSTER_NAME_SETTING.getKey()
            }
            NodeEnvironment nodeEnv = node.getNodeEnvironment();
            node.injector().getInstance(TransportService.class).addLifecycleListener(new LifecycleListener() {
     * @param nodeId                    node ordinal
    }
                        assertThat(
     * Returns a reference to a node's {@link ClusterService}. If the given node is null, a random node will be selected.
        }
 * The Cluster is bound to a test lifecycle where tests must call {@link #beforeTest(java.util.Random)} and
        this.autoManageClusterManagerNodes = autoManageClusterManagerNodes;
        final Settings[] newNodeSettings = new Settings[nextNodeId.get()];
        }
        }
                ScriptService.SCRIPT_CACHE_EXPIRE_SETTING.getConcreteSettingForNamespace(ctx).getKey(),
                throw new AssertionError("interrupted while starting nodes", e);
            try {
                assertThat(
import java.util.concurrent.atomic.AtomicBoolean;
        warmAndDataRoles.add(DiscoveryNodeRole.DATA_ROLE);
        }
                    assertBusy(() -> {
            activeDisruptionScheme.removeFromNode(nodeAndClient.name, this);
                            continue;
    private void assertNoSnapshottedIndexCommit() throws Exception {
    }
                        try {
        final Settings extraSettings,
    @Override
import java.util.Random;
        // clear all rules for mock transport services
            if (random.nextInt(10) == 0) { // do something crazy slow here
                final long primaryBytes = indexingPressure.getCurrentPrimaryBytes();
    }
import java.util.LinkedHashSet;
        logger.trace("validating cluster formed, expecting {}", expectedNodes);
     * Returns a node client to a given node.
                    for (IndexShard indexShard : indexService) {
    }
            autoManageClusterManagerNodes ? getMinClusterManagerNodes(getClusterManagerNodesCount()) : -1
            builder.put(SearchService.DEFAULT_KEEPALIVE_SETTING.getKey(), timeValueSeconds(100 + random.nextInt(5 * 60)).getStringRep());
        // turn it off for these tests.
        ensureOpen();
    private final Settings defaultSettings;
        clearDisruptionScheme(true);
        stopAllNodes();
                builder.put(nodeSettings).build(),
            settings.add(removeRoles(nodeSettings, Collections.singleton(DiscoveryNodeRole.DATA_ROLE)));
     * Returns a node client to a data node in the cluster.
    }
    public List<String> startNodes(int numOfNodes, Settings settings, Boolean waitForNodeJoin) {
                    }
     */
        }
    public synchronized void assertAfterTest() throws Exception {
            return nodeAndClient;
    /**
    private void assertAllPendingWriteLimitsReleased() throws Exception {
    }
                    DiscoveryNodes discoveryNodes = cs.nodes();
         * gateways and all index data. Returns <code>false</code> by default.
                }
        Client nodeClient() {
        return nodes.size();
    }
        for (NodeAndClient nodeAndClient : nodes.values()) {
        return startClusterManagerOnlyNodes(numNodes, Settings.EMPTY);
    private static Collection<NodeAndClient> filterNodes(
     * Returns the name of the current cluster-manager node in the cluster and executes the request via the node specified
    }
    }
            validateClusterFormed();
        ensureOpen();
     */
        int autoBootstrapClusterManagerNodeIndex = autoManageClusterManagerNodes
        assertBusy(() -> {
        this.bootstrapClusterManagerNodeIndex = bootstrapClusterManagerNodeIndex;
            return allNodesSettings;
import static org.opensearch.test.OpenSearchTestCase.randomBoolean;
import org.apache.logging.log4j.Logger;
        final int firstNodeId = nextNodeId.getAndIncrement();
            builder.put(
                );
         * an active client to the node that will be restarted next.
                newSettings.add(settings);
        reset(wipeData);
                if (coordinatingBytes > 0) {
                    randomBoolean() ? DEFAULT_WARM_CACHE_SIZE_PERCENT : DEFAULT_WARM_CACHE_SIZE_BYTES
            assert nodes.containsKey(nodeAndClient.name);
                    "Not all cluster-managers in same term" + debugString,
    /**
            } finally {
            }
                // first.
            .collect(Collectors.toList());
                    indexService.getIndexSettings().getSettings().getAsInt(IndexMetadata.SETTING_NUMBER_OF_SHARDS, -1),
                RuntimeException re = FutureUtils.rethrowExecutionException(e);
    public Set<String> getClusterManagerNames() {
        startAndPublishNodesAndClients(toStartAndPublish);
                final Collection<NodeAndClient> currentNodes = nodes.values();
            : "bootstrapClusterManagerNodeIndex should be -1 if autoManageClusterManagerNodes is true, but was "
        NodeAndClient randomNodeAndClient = getRandomNodeAndClient(predicate);
                            .build()
        if (activeDisruptionScheme != null) {
    /**
                        }
    }
                    false,
import org.opensearch.core.common.unit.ByteSizeUnit;
    }
        final Set<String> excludedNodeIds = excludeClusterManagers(nodeAndClients);
        final List<Settings> settings = new ArrayList<>();
        @Override
        && DiscoveryNode.isDataNode(nodeAndClient.node.settings()) == false;
        final int minClusterManagerNodes = autoManageClusterManagerNodes ? getMinClusterManagerNodes(getClusterManagerNodesCount()) : -1;
                nodes = Collections.emptyNavigableMap();
                    }
        return nodes.entrySet()
            );
            newSize
        );
                    .map(TransportService::getLocalNode)
     * stop any of the running nodes.
        List<InetSocketAddress> addresses = new ArrayList<>();
            }
    public synchronized List<String> startNodes(Boolean waitForNodeJoin, Settings... extraSettings) {
            .stream()
import java.util.HashSet;
        if (usingSingleNodeDiscovery == false) {
                    }
            try {
            }
        assertThat(shard, greaterThanOrEqualTo(0));
    public synchronized void afterTest() {
                activeDisruptionScheme.removeAndEnsureHealthy(this);
         */
     */
        updatedSettings.put(NodeEnvironment.NODE_ID_SEED_SETTING.getKey(), seed);
import com.carrotsearch.randomizedtesting.SeedUtils;
            activeDisruptionScheme.removeFromNode(nodeAndClient.name, this);
    private String getNodePrefix(Settings settings) {
     * Returns a predicate that only accepts settings of nodes with one of the given names.
            );
        }
        builder.put(
            return null;
                this.numSharedCoordOnlyNodes = RandomNumbers.randomIntBetween(
    /**
                    logger.error("Could not assert finished requests within timeout", e);
                }
                    }
                autoBootstrapClusterManagerNodeIndex -= 1;
            }
            throw new IllegalArgumentException("maximum number of data nodes must be >= minimum number of  data nodes");
import org.opensearch.index.store.remote.filecache.FileCache;
import static org.opensearch.discovery.FileBasedSeedHostsProvider.UNICAST_HOSTS_FILE;
import org.opensearch.index.engine.InternalEngine;
import org.opensearch.core.common.breaker.CircuitBreaker;
                Client client = getRandomNodeAndClient(node -> excludedNodeIds.contains(node.name) == false).client();
                if (random.nextBoolean()) {
        }
                && currentClusterManagers > 0
        if (autoManageClusterManagerNodes) {
            Settings callbackSettings = callback.onNodeStopped(name);
    public synchronized boolean stopRandomWarmNode() throws IOException {
            List<Future<?>> futures = nodeAndClients.stream().map(node -> executor.submit(node::startNode)).collect(Collectors.toList());
        return startWarmOnlyNodes(numNodes, Settings.EMPTY);
     */
     */
                for (IndexShard indexShard : indexService) {
        restartNode(nodeName, EMPTY_CALLBACK);
import com.carrotsearch.randomizedtesting.RandomizedTest;
     * in the viaNode parameter. If viaNode isn't specified a random node will be picked to the send the request to.
        }
     * Ensures that at least <code>n</code> data-warm nodes are present in the cluster.
            }
                    .map(nac -> nac.node.getEnvironment().configDir())
                    ShardRouting primaryShardRouting = indexShardRoutingTable.primaryShard();
    private final String clusterName;
                    false,
    private static final Predicate<NodeAndClient> CLUSTER_MANAGER_NODE_PREDICATE = nodeAndClient -> DiscoveryNode.isClusterManagerNode(
        final boolean autoManageClusterManagerNodes,
            for (final IndexRoutingTable indexRoutingTable : state.routingTable().indicesRouting().values()) {
            try {
        }
    }
    public void assertNoInFlightDocsInEngine() throws Exception {
    public static Predicate<Settings> nameFilter(String... nodeNames) {
                        long bytesUsed = inFlightRequestsBreaker.getUsed();
        }
    /**
        for (NodeAndClient nodeAndClient : nodeAndClients) {
import org.opensearch.env.ShardLockObtainFailedException;
            }
        if (random.nextBoolean()) {
    /**
        final NodeAndClient nodeAndClient = nodes.get(name);
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        if (values.isEmpty() == false) {
            rebuildUnicastHostFiles(nodeAndClients); // ensure that new nodes can find the existing nodes when they start
                // in an assertBusy loop, so it will try for 10 seconds and
                }
    }
        final NavigableMap<String, NodeAndClient> newNodes = new TreeMap<>(nodes);
    public void setBootstrapClusterManagerNodeIndex(int bootstrapClusterManagerNodeIndex) {
            if (nodeEnv.hasNodeFile()) {
            }
 * compatible open source license.
        builder.put(OperationRouting.USE_ADAPTIVE_REPLICA_SELECTION_SETTING.getKey(), random.nextBoolean());
        numDataPaths = random.nextInt(5) == 0 ? 2 + random.nextInt(3) : 1;
    private Collection<NodeAndClient> dataNodeAndClients() {
        ensureOpen();
        stopNodesAndClient(clusterManagerNode);
                    DEFAULT_MIN_NUM_CLIENT_NODES,
 * this file be licensed under the Apache-2.0 license or a
     */
import org.opensearch.common.settings.Settings;
        final Collection<Class<? extends Plugin>> mockPlugins,
     * Starts multiple nodes with the given settings and returns their names
    public String startClusterManagerOnlyNode(Settings settings) {
                // all nodes have a cluster-manager
            callback.doAfterNodes(numNodesRestarted++, nodeAndClient.nodeClient());
        });
            return nodeAndClient.client();
import java.nio.file.Path;
        void startNode() {
        if (numDataPaths > 1) {
        return getRandomNodeAndClient(nc -> true);
            try {
    /**
        assert Thread.holdsLock(this);
                        }
            clusterName,
            defaultMinClusterManagerNodes = getMinClusterManagerNodes(getClusterManagerNodesCount() + newClusterManagerCount);
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;
import org.opensearch.cluster.ClusterState;
            startNodes(n - size, Settings.builder().put(onlyRole(Settings.EMPTY, DiscoveryNodeRole.WARM_ROLE)).build());
                } catch (Exception e) {
    }
            && prevClusterManagerCount == 0
        if (wipeData) {
     * Sets {@link #bootstrapClusterManagerNodeIndex} to the given value, see {@link #bootstrapClusterManagerNodeWithSpecifiedIndex(List)}
            if (closed.get()) {
            // we clone this here since in the case of a node restart we might need it again
            final Settings newSettings = nodeAndClient.closeForRestart(callback, minClusterManagerNodes);
            builder.put(MappingUpdatedAction.INDICES_MAX_IN_FLIGHT_UPDATES_SETTING.getKey(), RandomNumbers.randomIntBetween(random, 1, 10));
    public <T> T getInstance(Class<T> clazz, final String node) {
    /**
        int size = numDataNodes();
    }
        if (random.nextBoolean()) { // sometimes set a
        activeDisruptionScheme = null;
        public String getName() {
        for (NodeAndClient n : nodes.values()) {
            Set<DiscoveryNodeRole> warmAndDataRoles = Set.of(DiscoveryNodeRole.DATA_ROLE, DiscoveryNodeRole.WARM_ROLE);
        for (int i = 0; i < numSharedDedicatedClusterManagerNodes; i++) {
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
import org.opensearch.common.settings.Settings.Builder;
        return addresses.toArray(new InetSocketAddress[0]);
    ) {
     * Starts a node with the given settings and returns its name.
     * Ensures that at most <code>n</code> are up and running.
    // synchronized to prevent concurrently modifying the cluster.
    /**
    }
    }
 * specific language governing permissions and limitations
     * All nodes started by the cluster will have their name set to nodePrefix followed by a positive number
                    for (Settings nodeSettings : allNodesSettings) {
        if (random.nextBoolean()) {
        if (nodeAndClient != null) {
        executor = OpenSearchExecutors.newScaling(
            for (NodeAndClient nodeAndClient : nodesAndClients) {
                        final SeqNoStats seqNoStats;
                logger.info("adding voting config exclusions {} prior to restart/shutdown", excludedNodeNames);
    public List<String> startNodes(int numOfNodes) {
        // cannot be a synchronized method since it's called on other threads from within synchronized startAndPublishNodesAndClients()
            IOUtils.close(secureSettings);
import org.opensearch.cluster.metadata.IndexMetadata;
    }
        nodeAndClient.recreateNode(newSettings, () -> rebuildUnicastHostFiles(Collections.singletonList(nodeAndClient)));
 * the Apache License, Version 2.0 (the "License"); you may
        builder.put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "1b");
        } else if (random.nextInt(100) <= 90) {
    private Collection<NodeAndClient> warmNodeAndClients() {
            validateClusterFormed();
                activeDisruptionScheme.testClusterClosed();
                        primaryShardRouting + " should have set the global checkpoint",
    /**
            RecoverySettings.INDICES_RECOVERY_MAX_CONCURRENT_FILE_CHUNKS_SETTING.getKey(),
 * The cluster supports randomized configuration such that nodes started in the cluster will
                                    + "] has pending operations:\n --> "
    public String startNode(Settings.Builder settings) {
                wipePendingDataDirectories();
                            "out of sync shards: primary=["
    public String getClusterName() {
    /**
        nodeAndClient.node.settings()
                settings.add(nodeSettings);
        final Function<Client, Client> clientWrapper,
        }
                public void remove() {
                                + "]",
    }
        MockNode node = new MockNode(settings, pluginInfos, nodeConfigurationSource.nodeConfigPath(nodeId), forbidPrivateIndexSettings);
                    }
                            throw new AssertionError(
            builder.put(TransportSettings.PING_SCHEDULE.getKey(), RandomNumbers.randomIntBetween(random, 100, 2000) + "ms");
        }
     */
            .filter(DiscoveryNode::isClusterManagerNode)
                try {
        if (numSharedDataNodes == 0) {
     */
                    } catch (IOException e) {
     * Restarts a node and calls the callback during restart.
        if (randomNodeAndClient != null) {
            final Settings nodeSettings = updatedSettings.get(i);
        }
package org.opensearch.test;
import org.opensearch.index.IndexService;
            assertBusy(() -> {
                    .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), clusterManagerNodeNames)
                                + "] num_docs_on_primary=["
    private volatile NavigableMap<String, NodeAndClient> nodes = Collections.emptyNavigableMap();
        Map<String, InternalTestCluster.NodeAndClient> map,
                    );
     * Stops any of the current nodes but not the cluster-manager node.
    }
        final NodeAndClient previous = newNodes.remove(nodeAndClient.name);
                RandomNumbers.randomIntBetween(random, 2, 5)
            .put(settings)
     * Starts multiple nodes with the given settings and returns their names
                        }
            }
        int autoBootstrapClusterManagerNodeIndex = -1;
        builder.put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "1b");
                            // all good
            nodes.isEmpty() || nodes.values().stream().anyMatch(NodeAndClient::isClusterManagerEligible)
 * not use this file except in compliance with the License.
                        + "': ["
        Collection<Class<? extends Plugin>> plugins = getPlugins();
            newSize
            String ctx = randomFrom(random, ScriptModule.CORE_CONTEXTS.keySet());
        if (autoManageClusterManagerNodes && newSize > 0) {
import java.util.Objects;
import org.opensearch.index.engine.IngestionEngine;
            if (numSharedDedicatedClusterManagerNodes > 0) {
                nodeAndClient.resetClient();
        removeExclusions(excludedNodeIds);
        return startNodes(numNodes, Settings.builder().put(onlyRoles(settings, warmAndDataRoles)).build());
        return startNodes(waitForNodeJoin, Collections.nCopies(numOfNodes, settings).toArray(new Settings[0]));
     */
            for (String nodeName : getNodeNames()) {
                                .collect(Collectors.joining(",", "[", "]"));
        if (size() > 0) {
    private static final String DEFAULT_WARM_CACHE_SIZE_PERCENT = "5%";
                );
import org.opensearch.common.lease.Releasables;
            + numSharedDataNodes + numSharedCoordOnlyNodes; i++) {
                    final Path[] locations = nodeEnv.nodeDataPaths();
        this.nodeConfigurationSource = nodeConfigurationSource;
            stopNodesAndClient(nodeAndClient);
        nodes = Collections.unmodifiableNavigableMap(newNodes);
     */
import static org.opensearch.test.NodeRoles.onlyRole;
                            Engine engine = IndexShardTestCase.getEngine(indexShard);
            RecoverySettings.INDICES_RECOVERY_RETRY_DELAY_STATE_SYNC_SETTING.getKey(),
                    if (primaryShard == null) {
            : nodes.values().stream().filter(DATA_NODE_PREDICATE.and(new NodeNamePredicate(getClusterManagerName()).negate()));
                executor.shutdownNow();
        final int defaultMinClusterManagerNodes = (numberOfClusterManagerNodes / 2) + 1;
        assertNoInFlightDocsInEngine();
                IndicesService indexServices = getInstance(IndicesService.class, nodeName);
                        if (DiscoveryNode.isClusterManagerNode(nodeSettings)) {
     */
        });
                                replicaShardRouting + " global checkpoint syncs mismatch",
        }
        NodeAndClient randomNodeAndClient = getRandomNodeAndClient(new NodeNamePredicate(getClusterManagerName()).negate());
    private NodeAndClient getRandomNodeAndClient() {
    }
                fdCache.getCache().refresh();
            close();
    /**
                    stats.getIndices().getSegments().getBitsetMemoryInBytes(),
                    totalDataNodes -= 1;
            return randomNodeAndClient.nodeClient(); // ensure node client non-cluster-manager is requested
    }
                // Clean up the cache, ensuring that entries' listeners have been called
                    }
                );
            for (NodeAndClient nodeAndClient : nodes.values()) {
        if (random.nextBoolean()) {
        } catch (Exception e) {
        if (nodeAndClient != null) {
    }
    private final boolean forbidPrivateIndexSettings;
    );
                    new ByteSizeValue(RandomNumbers.randomIntBetween(random, 10, 200), ByteSizeUnit.MB)
        stopNodesAndClients(nodesToRemove);
    private static Settings getRandomNodeSettings(long seed) {
        assert newSize == numSharedDedicatedClusterManagerNodes + numSharedDataNodes + numSharedCoordOnlyNodes;
    }
        }
    }
                    setBootstrapClusterManagerNodeIndex(-1);
        // dependencies. HashSet here would make order JVM-allocation-hash dependent and lead to
            for (final IndexRoutingTable indexRoutingTable : state.routingTable().indicesRouting().values()) {
    }
import org.opensearch.plugins.Plugin;
        }
                    );
        Builder builder = Settings.builder().put(defaultSettings).put(getRandomNodeSettings(nodeSeed));
            // Clear file cache to avoid file leaks during node stop
            final NodeAndClient previous = removeNode(nodeAndClient);
        }
            logger.info("Closing random node [{}] ", nodeAndClient.name);
    /**
        }
            int initialMillisBound = RandomNumbers.randomIntBetween(random, 10, 100);
}
        }
            }
                if (closed.get()) {
            return getOrBuildNodeClient();
import static org.opensearch.test.NodeRoles.onlyRoles;
import java.nio.file.Files;
import org.opensearch.cluster.node.DiscoveryNodeRole;
        }
        List<PluginInfo> pluginInfos = plugins.stream()
        DiscoveryNodeRole.WARM_ROLE
import java.util.NavigableMap;
     * If {@link #bootstrapClusterManagerNodeIndex} is -1 (default), this method does nothing.
     * Stops a random node in the cluster that applies to the given filter. Does nothing if none of the nodes match the
    }
import org.opensearch.script.ScriptModule;
                nodeAndClient.name,
    }
    }
            IndicesService indexServices = getInstance(IndicesService.class, nodeAndClient.name);
    /**
     * in the cluster.
    public String[] getNodeNames() {
            for (NodeAndClient nodeAndClient : nodes.values()) {
        private final String name;
        for (NodeAndClient nodeAndClient : nodes.values()) {
                    }
                }
        assert Thread.holdsLock(this);
            }
                    "Tests must not set a '"
    }
        plugins.addAll(mockPlugins);
            TransportService transportService = nodeAndClient.node.injector().getInstance(TransportService.class);
    public List<String> startDataAndWarmNodes(int numNodes, Settings settings) {
                // However, we do not yet have a way to be sure there's a majority left, because the voting configuration may not yet have
                RandomNumbers.randomIntBetween(random, 0, 2000)
 * The OpenSearch Contributors require contributions made to
            }
    }
                    false,
            builder.put(
            builder.put(HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_TYPE_SETTING.getKey(), "noop");
                                .map(t -> t.taskInfo(nodeAndClient.name, true).toString())
    /**
    /**
        assert this.numSharedCoordOnlyNodes >= 0;
            throw new UncheckedIOException(e);
import org.opensearch.cluster.service.ClusterService;
                IndicesService indexServices = getInstance(IndicesService.class, nodeAndClient.name);
                    false,
     * Starts multiple nodes with default settings and returns their names
            if (fileCache != null && WARM_NODE_PREDICATE.test(nodeAndClient)) {
                        continue;
            }
     */
            .filter(nc -> nc.name.equals(node))
                nextNodeId.get(),
            .build();
        final boolean randomlyAddDedicatedClusterManagers,
        }
                    false, // fileCacheDetailed
                    random,
            0,
        }
                    false,
            ClusterState state = client().admin().cluster().prepareState().get().getState();
                                );
                )
                                assertFalse(
                .put(newSettings)
            return;
     *
                final List<ClusterState> states = nodes.values()
                CircuitBreaker inFlightRequestsBreaker = getInstance(CircuitBreakerService.class, nodeAndClient.name).getBreaker(
                    "if cluster-manager nodes are automatically managed then nodes must complete a join cycle when starting",
        }
import org.opensearch.test.transport.MockTransportService;
                IndicesService indexServices = getInstance(IndicesService.class, nodeAndClient.name);
            fileCache.closeIndexInputReferences();
        Set<String> excludedNodeIds = excludeClusterManagers(Collections.singleton(nodeAndClient));
                                    + "] should have finished. "
    public String getClusterManagerName(@Nullable String viaNode) {
            assert previous == nodeAndClient;
 * You may obtain a copy of the License at
        }
        final int minNumDataNodes,
    }
                    .distinct()
        final NodeConfigurationSource nodeConfigurationSource,
            )
                final MockTransportService mockTransportService = (MockTransportService) transportService;
        assertBusy(() -> {
                // all nodes know about all other nodes
                            // shard is closed
        }
        final Stream<NodeAndClient> collection = n == 0
    private void restartNode(NodeAndClient nodeAndClient, RestartCallback callback) throws Exception {
            IndicesService indicesService = getInstanceFromNode(IndicesService.class, node);
                        final IndexShard replicaShard = getShardOrNull(state, replicaShardRouting);
     * Returns a reference to the given nodes instances of the given class &gt;T&lt;
        }
import java.io.IOException;
        return startNodes(numNodes, Settings.builder().put(onlyRole(settings, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE)).build());
     * Ensures that at least <code>n</code> data nodes are present in the cluster.
            instances.add(getInstanceFromNode(clazz, nodeAndClient.node));
     * Returns a reference to a random nodes instances of the given class &gt;T&lt;
        return previous;
                public void afterStart() {
    }
        return nodes.stream().map(NodeAndClient::getName).collect(Collectors.toList());
        final int newSize = sharedNodesSeeds.length;
        }
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING.getKey(),
        assertAllPendingWriteLimitsReleased();
    public synchronized void stopCurrentClusterManagerNode() throws IOException {
    }
    public void assertSeqNos() throws Exception {
            callback.doAfterNodes(numNodesRestarted++, nodeAndClient.nodeClient());
                    }
import java.util.function.Function;
                                + primaryShardRouting
            closed.set(false);
                );
                && newClusterManagers > 0
    public int numClusterManagerNodes() {
                builder.put(
        /**
            final ClusterState state = clusterService().state();
        private final AtomicBoolean closed = new AtomicBoolean(false);
        );
     * if more nodes than <code>n</code> are present this method will not
            .map(Node.NODE_NAME_SETTING::get)
            }
     * Restarts all nodes in the cluster. It first stops all nodes and then restarts all the nodes again.
    }
        });
/*
                    .build();
                    .collect(Collectors.toList())
                final String debugString = ", expected nodes: " + expectedNodes + " and actual cluster states " + states;
            return;
            logger.info(
    /**
    private Settings getSettings(int nodeOrdinal, long nodeSeed, Settings others) {
            if (activeDisruptionScheme != null) {
        stopNodesAndClients(toClose);
    public static final int DEFAULT_HIGH_NUM_CLUSTER_MANAGER_NODES = 3;
            this.nodeAndClientId = nodeAndClientId;
     */
         */
import org.opensearch.index.IndexingPressure;
        final DiscoveryNode assignedNode = clusterState.nodes().get(shardRouting.currentNodeId());
        /* Randomly return a client to one of the nodes in the cluster */
    private final ExecutorService executor;
                NodeEnvironment nodeEnv = node.getNodeEnvironment();
    private synchronized NodeAndClient buildNode(int nodeId, Settings settings, boolean reuseExisting, Runnable onTransportServiceStarted) {
            } catch (ExecutionException e) {
                            seqNoStats = replicaShard.seqNoStats();
        if (assignedNode == null) {
                    throw new AssertionError("Exception during check for request breaker reset to 0", e);
    /**
    }
            builder.put("cache.recycler.page.type", RandomPicks.randomFrom(random, PageCacheRecycler.Type.values()));
                        } catch (AlreadyClosedException ignored) {
import org.opensearch.node.Node.DiscoverySettings;
                Environment.PATH_DATA_SETTING.getKey(),
    public synchronized void validateClusterFormed() {
        wipePendingDataDirectories();
            NodeEnvironment nodeEnv = node.getNodeEnvironment();
            }
        this(
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING.getKey(),
        }
                        FileSystemUtils.deleteSubDirectories(path);
                    client().execute(
                }
                startNodes(n - size);
        NodeAndClient randomNodeAndClient = getRandomNodeAndClient(new NodeNamePredicate(getClusterManagerName()));
        }
    }
                    equalTo(0L)
            clusterSeed,
                }
                .filter(NodeAndClient::isClusterManagerEligible)
        startClusterManagerOnlyNodes(totalClusterManagerNodes);
    }
    }
        return newSettings;
    }
    }
            for (NodeAndClient nodeAndClient : nodes.values()) {
                // if we don't have dedicated cluster-manager nodes, keep things default
        public boolean clearData(String nodeName) {
            markNodeDataDirsAsNotEligibleForWipe(node);
        try {
        }
            final Collection<NodeAndClient> nodesAndClients = nodes.values();
            NodeEnvironment env = nodeAndClient.node().getNodeEnvironment();
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        assert activeDisruptionScheme == null : "there is already and active disruption ["
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
            return nodes;
                        AddVotingConfigExclusionsAction.INSTANCE,
        };
                nodeClient = null;
    @Override
    }
                    RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(),
     */
        // force certain settings
        if (activeDisruptionScheme != null) {
        int size = numDataNodes();
            .findFirst()
                    .collect(Collectors.toSet());
                        }
        }
                        IndexShard replicaShard = getShardOrNull(state, replicaShardRouting);
        logger.info("Closing cluster-manager node [{}] ", clusterManagerNodeName);
        public void doAfterNodes(int n, Client client) throws Exception {}
                for (var indexShardRoutingTable : indexRoutingTable.shards().values()) {
        final Iterator<String> iterator = dataNodes.keySet().iterator();
            } catch (InterruptedException e) {
                    this.numSharedDedicatedClusterManagerNodes = DEFAULT_LOW_NUM_CLUSTER_MANAGER_NODES;
        final int numOfNodes = extraSettings.length;
        NodeAndClient nodeAndClient = getRandomNodeAndClient(new NodeNamePredicate(getClusterManagerName()).negate());
            try {
    }
            if (i == autoBootstrapClusterManagerNodeIndex) {
    }
    public String startDataOnlyNode() {
                nodeAndClients.stream()
                    .filter(NodeAndClient::isClusterManagerEligible)
                @Override
                    : -1;
                final long replicaWriteBytes = indexingPressure.getCurrentReplicaBytes();
                    throw new AssertionError(
        restartRandomDataNode(EMPTY_CALLBACK);
        }
        return clusterService(null);
import org.opensearch.cluster.metadata.RepositoriesMetadata;
        removeExclusions(excludedNodeIds);
import org.opensearch.common.util.io.IOUtils;
            List<ShardRouting> allShards = clusterService().state().routingTable().allShards(index);
    public String startSearchOnlyNode(Settings settings) {
                }
        }, 60, TimeUnit.SECONDS);
            }
            NodeAndClient next = values.next();
import java.util.concurrent.Future;
        }
    }
        stopNodesAndClients(Collections.singleton(nodeAndClient));
            @Override
            // Checks that the breakers have been reset without incurring a
import org.opensearch.node.Node;
            }
    static final int DEFAULT_MIN_NUM_CLIENT_NODES = 0;
                });
     * Returns the name of all the cluster managers in the cluster
    }
                    false
            final long stoppingClusterManagers = nodeAndClients.stream().filter(NodeAndClient::isClusterManagerEligible).count();
                    try {
            assert nodes.containsKey(nodeAndClient.name);
     * fully shared cluster to be more reproducible */
import org.opensearch.cluster.coordination.ClusterBootstrapService;
        synchronized (discoveryFileMutex) {
                            continue; // shard is closed - just ignore
        final int nodeId = nextNodeId.getAndIncrement();
 * SPDX-License-Identifier: Apache-2.0
        if (size < n) {
                                // no-op, as IngestionEngine does not use translog.
            if (numSharedDedicatedClusterManagerNodes > 0) {
    public synchronized void stopRandomNodeNotCurrentClusterManager() throws IOException {
                            nodeNames.add(Node.NODE_NAME_SETTING.get(nodeSettings));
                    false,
                        assertThat("Request breaker not reset to 0 on node: " + name, reqBreaker.getUsed(), equalTo(0L));
                            continue; // just ignore - shard movement
        return false;
                "Cluster hasn't changed - moving out - nodes: [{}] nextNodeId: [{}] numSharedNodes: [{}]",
                public boolean hasNext() {
        assertBusy(() -> {
            builder.put(settings);
import org.opensearch.node.NodeService;
                builder.put(
                assertThat(
        for (HttpServerTransport httpServerTransport : getInstances(HttpServerTransport.class)) {
        return startSearchOnlyNodes(numNodes, Settings.EMPTY);
                    "NA",
            RecoverySettings.INDICES_RECOVERY_MAX_CONCURRENT_OPERATIONS_SETTING.getKey(),
    public synchronized void rollingRestart(RestartCallback callback) throws Exception {
        // if multiple maven task run on a single host we better have an identifier that doesn't rely on input params
        assert size() > 0;
            stopCurrentClusterManagerNode();
import static org.opensearch.test.NodeRoles.dataOnlyNode;
                stopRandomNodeNotCurrentClusterManager();
            baseDir,
            validateClusterFormed();
    public List<String> startNodes(int numOfNodes, Settings settings) {
     */
    private static final Predicate<NodeAndClient> NO_DATA_NO_CLUSTER_MANAGER_PREDICATE = nodeAndClient -> DiscoveryNode
                    CircuitBreaker.IN_FLIGHT_REQUESTS
    }
                success = true;
                }
            autoManageClusterManagerNodes ? "auto-managed" : "manual"
import static org.hamcrest.Matchers.greaterThan;
    /**
    public synchronized void wipePendingDataDirectories() {
        }
     * @param reuseExisting             if a node with the same name is already part of {@link #nodes}, no new node will be built and
        int numNodesRestarted = 0;
                    }, 1, TimeUnit.MINUTES);
        );
                }
        // and fails shards when a cluster-manager abdicates, which breaks many tests.
     */
            return node;
                    false,
        throw new AssertionError("No non-cluster-manager client found");
            assert callback != null;
            return true;
        nodeAndClient.node.settings()
        pluginInfos.addAll(additionalNodePlugins);
                }
                    IndexShard primaryShard = getShardOrNull(state, primaryShardRouting);
            }
            } else if (numSharedDataNodes > 0) {
        final Function<Client, Client> clientWrapper
    /**
 *
        return startNode(Settings.EMPTY);
            if (transportService instanceof MockTransportService) {
            node = new MockNode(
    /**
    public static String clusterName(String prefix, long clusterSeed) {
                        } catch (AlreadyClosedException ok) {
        }
    private final int numDataPaths;
    /**
                    ).get();
            builder.put(
        if (TEST_NIGHTLY) {
                    for (Settings nodeSettings : getDataOrClusterManagerNodeInstances(Settings.class)) {
                    throw new AssertionError("pending combined bytes [" + combinedBytes + "] bytes on node [" + nodeAndClient.name + "].");
        // only add the suffixes if roles are explicitly defined
    public synchronized void stopRandomNode(final Predicate<Settings> filter) throws IOException {
            }
        startCoordinatingOnlyNode(settings);
                    final IndexShard primaryShard = getShardOrNull(state, primaryShardRouting);
import java.io.UncheckedIOException;
import java.util.stream.Stream;
        }
     */
            wipePendingDataDirectories();
    }
                for (var indexShardRoutingTable : indexRoutingTable.shards().values()) {
                final IndicesFieldDataCache fdCache = getInstanceFromNode(IndicesService.class, nodeAndClient.node)
        if (activeDisruptionScheme != null) {
import org.opensearch.tasks.TaskManager;
            "Setup InternalTestCluster [{}] with seed [{}] using [{}] dedicated cluster-managers, "
    private synchronized <T> T getInstance(Class<T> clazz, Predicate<NodeAndClient> predicate) {
        }
    public <T> Iterable<T> getDataNodeInstances(Class<T> clazz) {
