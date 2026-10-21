            // bypass this limit so that caching gets some testing in
                        originalBytes
            );
        return true;
                client().admin()
                for (Segment segment : shardSegments) {
     * Maximum number of async operations that indexRandom will kick off at one time.
            );
        Settings.Builder builder = Settings.builder()
            segmentRepoName
                                        final IndexShard primaryShard = getIndexShard(primaryRouting, index);
    /**
     * Ensures the cluster has a green state via the cluster health API. This method will also wait for relocations.
            int to = (seg == numSegments - 1) ? builders.size() : from + batchSize;
            .orElseThrow(() -> new UnsupportedOperationException("unsupported cluster type"));
            StringBuilder sb = new StringBuilder("search result contains [");
     * The returned client gets automatically closed when needed, it shouldn't be closed as part of tests otherwise
     */
            logger.trace("Check consistency for [{}] nodes", cluster().size());
                        throw error;
     * Returns a collection of plugins that should be loaded on each node.
        } catch (IOException e) {
            // If it's external cluster - fall back to the standard set
        PutRepositoryRequestBuilder builder = adminClient.preparePutRepository(repoName).setType(type).setVerify(verify);
import java.lang.annotation.RetentionPolicy;
    }
        );
    /**
            .indexUUID(indexId.getId())
        return clusterState.getRoutingNodes().node(nodeId).node().getName();
    ) {
    }
    protected boolean useRandomReplicationStrategy() {
import java.util.function.Function;
    /**
    }
     */
            for (IndexMetadata indexMetadata : metadata) {
     */
    /**
        return annotation == null ? true : annotation.autoManageMasterNodes();
        "index.tests.seed",
     * Waits until all nodes have no pending tasks.
     * Maximum number of documents in a single bulk index request.
        }
    public static final String SYSPROP_THIRDPARTY = "tests.thirdparty";
                if (remoteStoreRepositoryPath == null) {
        ClusterHealthResponse clusterHealthResponse = client(viaNode).admin()
     * Indexes the given {@link IndexRequestBuilder} instances randomly. It shuffles the given builders and either
                // We configure a routing key in case the mapping requires it
                    .setFlush(maybeFlush && randomBoolean())
    public static void putRepositoryWithNoSettingOverrides(
                );
        ClusterAdminClient adminClient,
        ClusterSettings clusterSettings = clusterService().getClusterSettings();
            List<List<IndexRequestBuilder>> partition = eagerPartition(
            if (lastKnownCount >= numDocs) {
                String id = "bogus_doc_" + randomRealisticUnicodeOfLength(unicodeLen) + dummmyDocIdGenerator.incrementAndGet();
            "Expected at least " + clusterHealthStatus + " but got " + actionGet.getStatus(),
        waitForRelocation();
        Path segmentRepoPath,
            Throwable t = ExceptionsHelper.unwrapCause(tuple.v2());
            {
     */
                return Settings.builder()
        Path segmentRepoPath,
        String translogRepoType,
    /**
     * Waits for all relocating shards to become active using the cluster health API.
        protected void addError(Exception e) {
                    )
     * Threshold at which indexing switches from frequently async to frequently bulk.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
            );
                .collect(Collectors.joining("\n"));
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;
        if (rarely()) {
    @Deprecated
            translogRepoName,
    }
            if (randomBoolean()) {
    /**
    }
    public static void putRepository(
        logger.info("--> updating repository [{}] [{}]", repoName, type);
     *
        if (isInternalCluster() && cluster().size() > 0) {
        for (List<String> doc : bogusIds) {
        }
    }
        if (randomInt(9) < 3) {
/*
    }
     * indexes them in a blocking or async fashion. This is very useful to catch problems that relate to internal document
    public @interface ThirdParty {
 * }
                .setPatterns(Collections.singletonList("*"))
        }
        if (finalSettings == false && settings.keys().contains(BlobStoreRepository.SHARD_PATH_TYPE.getKey()) == false) {
        if (numberOfShards > 0) {
                    cluster().wipeIndices(created.toArray(new String[0]));
            .put(featureFlagSettings());
            fail(
        ClearScrollResponse clearResponse = client().prepareClearScroll().setScrollIds(Arrays.asList(scrollIds)).get();
 * }
import static org.opensearch.discovery.DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING;
                                if (primaryRouting.state() == ShardRoutingState.STARTED) {
    ) {
                Arrays.stream(internalCluster().getNodeNames())
        if (timeout != null) {
            this.dataCopies = numReplicas + numSearchReplicas + 1;
        }
                (random.nextBoolean() ? random.nextDouble() : random.nextBoolean()).toString()
    /**
     */
        Path remoteRoutingTableRepoPath,
        }
                break;
     */
        }
    /**
     * Java prior to Java 15.  Tests that rely on machine memory
                ? "+"
        final Settings featureFlagSettings = featureFlagSettings();
     */
        if (routingTableRepoName != null) {
                client().admin()
            .timeout(timeout)
        }
     */
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
        return actionGet.getStatus();
        Environment environment = TestEnvironment.newEnvironment(settings);
         * Returns the minimum number of data nodes in the cluster. Default is {@code -1}.
        assertThat(
        assert repoFiles.length > 0;
        return false;
                .putNull(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey())
                throw new IllegalArgumentException("Cannot run TEST scope test with " + TESTS_CLUSTER);
 * useful to test the system without asserting modules that to make sure they don't hide any bugs in production.</li>
import org.opensearch.search.SearchService;
                // that the cluster-manager node matches the cluster-manager (otherwise there is no requirement for the cluster state to
     */
        String repoName,
     */
        return builder;
            );
                final BytesReference compareOriginalBytes = BytesReference.bytes(compareBuilder);
    }
    }
        return settingsBuilder.build();
    /** Returns {@code true} iff this test cluster should use a dummy http transport */
            }
                    indexRequestBuilder.execute().actionGet();
        if (builders.size() < FREQUENT_BULK_THRESHOLD ? frequently() : builders.size() < ALWAYS_BULK_THRESHOLD ? rarely() : false) {
        }
    @Inherited
        );
            Locale.getDefault(),
            this.errors = errors;
    @Target(ElementType.TYPE)
        String segmentRepoName,
        if (Strings.hasLength(clusterAddresses) && ignoreExternalCluster() == false) {
            .shardId(shardId)
        ActionListener<AcknowledgedResponse> listener
import org.opensearch.common.util.FeatureFlags;
            // shut down. The following "waitForNodes" condition ensures that the node has been removed by the cluster-manager
    }
        assertAcked(putRepositoryRequestBuilder(adminClient, repoName, type, verify, settings, null, true));
     * Indexes the given {@link IndexRequestBuilder} instances randomly. It shuffles the given builders and either
            .put("node.attr." + REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, segmentRepoName)
            .put(routingTableRepositorySettingsAttributeKeyPrefix + "location", randomRepoPath().toAbsolutePath())
            .equals(RemoteStoreNodeService.CompatibilityMode.MIXED);
    /**
                        throw new IllegalArgumentException(
 * compatible open source license.
    public static boolean isInternalCluster() {
        String repoName,
import org.opensearch.index.store.Store;
         */
            }
            .indices()
    }
 * not use this file except in compliance with the License.
    protected final IndexResponse index(String index, String type, XContentBuilder source) {
import org.opensearch.plugins.PluginInfo;
                segmentRepoType,
                    }
        }
                ClusterHealthResponse clusterHealth = client.admin().cluster().prepareHealth().setLocal(true).get();
                        new PayloadLatchedActionListener<>(indexRequestBuilder, newLatch(inFlightAsyncOperations), errors)
                    .indices()
    /**
                .put(
            // the read-only-allow-delete block isn't supported by the add block API so we must use the update settings API here.
                        XContentHelper.convertToMap(compareOriginalBytes, false, XContentType.SMILE).v2(),
        int value = random.nextInt(4);
    protected void indexRandomForMultipleSlices(String... indices) throws InterruptedException {
            final int maxMergeCount = RandomNumbers.randomIntBetween(random, maxThreadCount, maxThreadCount + 4);
                            "cluster state JSON serialization does not match",
            );
        return Collections.unmodifiableList(mocks);
            }
    }
                        .getHits()
import org.opensearch.common.Nullable;
import org.opensearch.test.transport.MockTransportService;
import org.opensearch.cluster.routing.UnassignedInfo;
     * {@link OpenSearchIntegTestCase.ClusterScope} annotations on {@link OpenSearchIntegTestCase} subclasses.
                    }
 * under the License.
                        logger.debug("Error indexing doc: " + t.getMessage() + ", reindexing.");
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
        CodecService.BEST_COMPRESSION_CODEC,
            );
        Collection<Class<? extends Plugin>> mockPlugins = getMockPlugins();
                for (Tuple<IndexRequestBuilder, Exception> tuple : errors) {
        Path translogRepoPath,
     * Asserts that all shards are allocated on nodes matching the given node pattern.
import org.apache.lucene.search.TotalHits;
    }
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
     */
 * the Apache License, Version 2.0 (the "License"); you may
                return OpenSearchIntegTestCase.this.nodeConfigPath(nodeOrdinal);
        return DEFAULT_MIN_NUM_SHARDS;
        BlobPath blobPath = pathType.path(shardPathInput, pathHashAlgorithm);
     * @return if needs to perform remote state restore or not
        if (numNodes > 0) {
            SuppressCodecs annotation = getClass().getAnnotation(SuppressCodecs.class);
                    remoteStoreRepositoryPath = randomRepoPath().toAbsolutePath();
        ClusterScope annotation = getAnnotation(this.getClass(), ClusterScope.class);
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        return builder;
    ) {
    private Path remoteStoreRepositoryPath;
    protected final void disableAllocation(String... indices) {
                randomSettingsBuilder.put(INDEX_TEST_SEED_SETTING.getKey(), random().nextLong());
        private NumShards(int numPrimaries, int numReplicas, int numSearchReplicas) {
    public final CreateIndexRequestBuilder prepareCreate(String index, int numNodes) {
        }
import org.opensearch.repositories.fs.FsRepository;
            )
        return l;
    public ClusterHealthStatus ensureYellowAndNoInitializingShards(String... indices) {
        }
        String type,
        String routingTableRepoName,
        CodecService.ZLIB
     * ids or index segment creations. Some features might have bug when a given document is the first or the last in a
                TieredMergePolicyProvider.INDEX_COMPOUND_FORMAT_SETTING.getKey(),
    /**
    protected Settings.Builder setRandomIndexSettings(Random random, Settings.Builder builder) {
    }
        ClusterScope annotation = getAnnotation(this.getClass(), ClusterScope.class);
import org.opensearch.index.IndexService;
                translogRepoPath,
    protected String replicaNodeName(String indexName) {
import org.opensearch.index.MergeSchedulerConfig;
    protected boolean ignoreExternalCluster() {
        return annotation == null ? -1 : annotation.numDataNodes();
            );
        putRepository(clusterAdmin(), repoName, type, null, settings);
import org.opensearch.search.MockSearchService;
    protected Settings buildRemotePublicationNodeAttributes(
    protected void ensureStableCluster(int nodeCount, @Nullable String viaNode) {
    /**
            .setIndicesOptions(IndicesOptions.strictExpandOpenHiddenAndForbidClosed())
    protected Path nodeConfigPath(int nodeOrdinal) {
        ClusterScope annotation = getAnnotation(this.getClass(), ClusterScope.class);
            }
        }
            ClusterStateResponse stateResponse = client(viaNode).admin().cluster().prepareState().get();
                        );
        };
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    }
    }
         * Indicates whether the cluster can have dedicated cluster-manager nodes. If {@code false} means data nodes will serve as cluster-manager nodes
        boolean waitForNoInitializingShards,
        Settings.Builder settings
    }
    /**
     */
            segmentRepoName
    /**
            int numDocs = getNumShards(index).totalNumShards * randomIntBetween(2, 10);
            withRateLimiterAttributes
     * Ensures the cluster has a yellow state via the cluster health API.
        mocks.add(AssertActionNamePlugin.class);
            .put(IndicesStore.INDICES_STORE_DELETE_SHARD_TIMEOUT.getKey(), new TimeValue(1, TimeUnit.SECONDS))
        );
     * for debugging or request / response pre and post processing. It also allows to intercept all calls done by the test
    /**
         * A cluster shared across all method in a single test suite
    protected int numberOfReplicas() {
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
    /**
         * Returns the maximum number of data nodes in the cluster.  Default is {@code -1}.
        int i = 0;
        String timeout,
            .put(translogRepoSettingsAttributeKeyPrefix + prefixModeVerificationSuffix, prefixModeVerificationEnable)
     */
     */
     * Some network disruptions may leave nodes that are not the cluster-manager disconnected from each other.
     * A boolean value to enable or disable mock modules. This is useful to test the
    }
    public static Settings remoteStoreClusterSettings(
            .indices()
                    TransportRequestHandler<T> actualHandler
         * Ignored when {@link ClusterScope#numDataNodes()} is set.
import java.util.HashSet;
        private final T builder;
            builder.put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), random.nextBoolean());
        prefixModeVerificationEnable = randomBoolean();
        settings.put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.getKey(), translogPathFixedPrefix ? "a" : "");
                .putNull(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values")
    protected void performRemoteStoreTestAction() {
import org.opensearch.env.TestEnvironment;
        String method = "ensure" + Strings.capitalize(color);
import static org.opensearch.test.XContentTestUtils.convertToMap;
    }
    ) {
    /**
            // By default, for tests we will put the target slice count of 2. This will increase the probability of having multiple slices
        return actionGet;
            builder.put(
    public static Settings buildRemoteStateNodeAttributes(String stateRepoName, Path stateRepoPath, String stateRepoType) {
            ArrayList<Class<? extends Plugin>> mocks = new ArrayList<>(mockPlugins);
            } else if (rarely()) {
    public @interface SuiteScopeTestCase {
            minNumDataNodes,
                        assertEquals("cluster state size does not match", clusterManagerClusterStateSize, localClusterStateSize);
import org.opensearch.core.common.Strings;
        Settings.Builder initialNodeSettings = Settings.builder();
            this.numSearchReplicas = numSearchReplicas;
        assert numSegments > 0 && numSegments <= builders.size() : "numSegments must be between 1 and builders.size()";
    public void indexRandom(boolean forceRefresh, boolean dummyDocuments, boolean maybeFlush, List<IndexRequestBuilder> builders)
        logger.debug("ensuring cluster is stable with [{}] nodes. access node: [{}]. timeout: [{}]", nodeCount, viaNode, timeValue);
            }
    protected final IndexResponse index(String index, String type, String id, XContentBuilder source) {
     * Creates a randomized index template. This template is used to pass in randomized settings on a
            final int maxThreadCount = RandomNumbers.randomIntBetween(random, 1, 4);
    private Settings.Builder getExcludeSettings(int num, Settings.Builder builder) {
        Path translogRepoPath,
            }
import org.opensearch.plugins.Plugin;
    /**
                    AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values",
                }
        ClusterService clusterService = internalTestCluster.getInstance(ClusterService.class, internalTestCluster.getClusterManagerName());
import reactor.util.annotation.NonNull;
import org.opensearch.action.admin.indices.segments.ShardSegments;
    public static final String TESTS_CLUSTER = "tests.cluster";
    }
        Settings settings = value
        Path translogRepoPath,
            this.latch = latch;
import java.util.Random;
     */
     *   produce deleted documents on the server side.
     */
     */
     * <p>
            logger.info("Index [{}] docs async: [{}] bulk: [{}] partitions [{}]", builders.size(), false, true, partition.size());
        final long maxWaitTimeMs = Math.max(90 * 1000, 200 * numDocs);
        return new Index(index, uuid);
     *   return client().prepareIndex(index, type, id).setSource(source).execute().actionGet();
 * <ul>
            builder.put(SETTING_NUMBER_OF_REPLICAS, numberOfReplicas).build();
            final Map<String, String> serializationParams = new HashMap<>(2);
        }
                    }, 30, TimeUnit.SECONDS);
import java.nio.file.Path;
        int numReplicas = Integer.valueOf(metadata.index(index).getSettings().get(SETTING_NUMBER_OF_REPLICAS));
                .setSettings(randomSettingsBuilder);
                    assertTrue("Unable to wait for replication with external test cluster", isInternalCluster());
        // Enabling Telemetry setting by default
import java.nio.file.Files;
        final List<Exception> actualErrors = new ArrayList<>();
        for (Tuple<IndexRequestBuilder, Exception> tuple : errors) {
            }
                translogRepoName,
        waitForRelocation();
    }
            }
            maxNumDataNodes = getMaxNumDataNodes();
     */
     * This method is executed iff the test is annotated with {@link SuiteScopeTestCase}
                .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a, b")
        settings.put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), randomBoolean());
import org.opensearch.action.admin.cluster.node.hotthreads.NodeHotThreads;
                        assertNull(
                        .setSize(0)
     */
            @Override
         */
                translogRepoPath,
                builder.startObject();
        return 0;
                new ByteSizeValue(RandomNumbers.randomIntBetween(random, 1, 300), ByteSizeUnit.MB)
    /**
 * public void testMethod() {}
    }
    }
        private final CountDownLatch latch;
    }
import org.opensearch.cluster.coordination.OpenSearchNodeCommand;
     * It is useful to ensure that all action on the cluster have finished and all shards that were currently relocating
            translogRepoName
        );
    /**
        if (viaNode == null) {
            .prepareForceMerge()
            // Set the field data cache clean interval setting to 1s so assertBusy() can ensure cache is cleared post-test within its
                    boolean forceExecution,
            serializationParams.put("binary", "true");
import org.opensearch.core.common.transport.TransportAddress;
import org.opensearch.index.mapper.CompletionFieldMapper;
                "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
     * @param forceRefresh if {@code true} all involved indices are refreshed
    @AfterClass
                .put(routingTableRepoAttributeKey, routingTableRepoType)
        public final int dataCopies;
    /**
    }
            }
import java.net.InetSocketAddress;
                }
        }
    protected Settings featureFlagSettings() {
import org.opensearch.cluster.routing.IndexRoutingTable;
    protected void ensureFullyConnectedCluster() {
            .put(segmentRepoSettingsAttributeKeyPrefix + prefixModeVerificationSuffix, prefixModeVerificationEnable)
         */
        }
        LatchedActionListener(CountDownLatch latch) {
     * <p>
            .setSettings(Settings.builder().put(EnableAllocationDecider.INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "all"))
            int clusterManagerClusterStateSize = clusterManagerClusterState.toString().length();
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
        int numSearchReplicas = numSearchReplicasValue != null ? Integer.parseInt(numSearchReplicasValue) : 0;
        if (value == 3) {
import org.opensearch.transport.TransportRequestHandler;
     * Convenience method that forwards to {@link #indexRandom(boolean, List)}.
            return Arrays.asList(new TransportInterceptor() {
    protected NumShards getNumShards(String index) {
        Long.MIN_VALUE,
    protected final void enableAllocation(String... indices) {
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        return between(minimumNumberOfShards(), maximumNumberOfShards());
        String segmentRepoName,
        }
    ) {
import org.opensearch.telemetry.TelemetrySettings;
                    if (count == lastKnownCount) {
        return testClusterRule.internalCluster().orElseThrow(() -> new UnsupportedOperationException("current test cluster is immutable"));
        int numShards = Integer.valueOf(metadata.index(index).getSettings().get(SETTING_NUMBER_OF_SHARDS));
    /**
     * Used for selecting random replication strategy, either DOCUMENT or SEGMENT.
            routingTableRepoAttributeKey = String.format(
                assertEquals(
    public static Client dataNodeClient() {
        NetworkDisruption.ensureFullyConnectedCluster(internalCluster());
            case SUITE:
            return internalCluster().getInstance(NamedXContentRegistry.class);
        return Collections.emptyList();
            if (randomBoolean()) {
                final List<Exception> actualErrors = new ArrayList<>();
     * segment or if only one document is in a segment etc. This method prevents issues like this by randomizing the index
    /**
        ClusterHealthStatus clusterHealthStatus,
    }
        }
     * Fetch IndexShard by shardId, multiple shards per node allowed.
                XContentBuilder compareBuilder = SmileXContent.contentBuilder();
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.common.xcontent.XContentHelper;
     * Creates a new {@link CreateIndexRequestBuilder} with the settings obtained from {@link #indexSettings()}.
                    randomLongBetween(
        return builder;
                    if (shardRouting.currentNodeId() != null && index.equals(shardRouting.getIndexName())) {
                    logger.debug("[{}] docs visible for search (needed [{}])", lastKnownCount, numDocs);
import org.opensearch.action.index.IndexResponse;
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsResponse;
                client().admin().cluster().preparePendingClusterTasks().get(),
    public ClusterHealthStatus ensureRed(String... indices) {
import org.opensearch.repositories.blobstore.BlobStoreRepository;
                client().admin().cluster().prepareState().get().getState(),
            .prepareUpdateSettings(indices)
 * This class supports the following system properties (passed with -Dkey=value to the application)
    }
     */
        }
            }
            transportAddresses
        Path routingTableRepoPath,
        if (random.nextBoolean()) {
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        ) {
        return getIndexShard(getClusterState().nodes().get(routing.currentNodeId()).getName(), routing.shardId(), indexName);
    protected boolean addMockTransportService() {
    /**
     * The lucene_default {@link Codec} is not added to the list as it internally maps to Asserting {@link Codec}.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                }
    public static Path randomRepoPath(Settings settings) {
                    );
                    .prepareRefresh(indices)
    @Override
        public final void onFailure(Exception t) {
     * @param dummyDocuments if {@code true} some empty dummy documents may be randomly inserted into the document list and deleted once
    }
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                builders.add(client().prepareIndex().setIndex(index).setId(id).setSource("{}", MediaTypeRegistry.JSON).setRouting(id));
        if (MOCK_MODULES_ENABLED && randomBoolean()) { // sometimes run without those completely
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "1b")
        Path translogRepoPath,
    /**
        String translogRepoName,
import static org.hamcrest.Matchers.emptyIterable;
            Locale.getDefault(),
        String translogRepoSettingsAttributeKeyPrefix = String.format(
     * creates an index with the given setting
        return settingsBuilder.build();
                }
        );
        return builder;
                    bulkBuilder.add(indexRequestBuilder);
        );
     * times with the same ordinal and is expected to return the same value for each invocation.
        TEST
    @Inherited
        assertNoTimeout(client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).get());
                        + XContentHelper.convertToMap(compareOriginalBytes, false, XContentType.SMILE)
        boolean java15Plus = Runtime.version().compareTo(Version.parse("15")) >= 0;
        String translogRepoTypeAttributeKey = String.format(
                    .execute(new LatchedActionListener<>(newLatch(inFlightAsyncOperations)));
    protected TestCluster buildTestCluster(Scope scope, long seed) throws IOException {
     * Returns a settings object used in {@link #createIndex(String...)} and {@link #prepareCreate(String)} and friends.
    }
        return false;
            // We currently often use ensureGreen or ensureYellow to check whether the cluster is back in a good state after shutting down
    }
    public static void enableIndexBlock(String index, String block) {
        }
     */
     */
                .build();
        return buildRemoteStoreNodeAttributes(
import org.opensearch.common.xcontent.XContentType;
        return new InternalTestCluster(
    }
    /**
import static org.opensearch.test.XContentTestUtils.differenceBetweenMapsIgnoringArrayOrder;
                } else {
                assertThat("client " + client + " still has in flight fetch", clusterHealth.getNumberOfInFlightFetch(), equalTo(0));
    public static Client client() {
        return ensureColor(ClusterHealthStatus.YELLOW, TimeValue.timeValueSeconds(30), true, indices);
        return ensureColor(ClusterHealthStatus.RED, TimeValue.timeValueSeconds(30), false, indices);
     * Syntactic sugar for:
     * <pre>
import org.opensearch.action.bulk.BulkRequestBuilder;
     * This method can be overwritten by subclasses to set defaults for the indices that are created by the test.
            getExcludeSettings(n, builder);
                    client().prepareDelete(doc.get(0), doc.get(1)).setRouting(doc.get(1)).get().getResult()
     */
     *   return client().prepareIndex(index, type, id).setSource(source).execute().actionGet();
    }
            Locale.getDefault(),
        Path path;
        translogPathFixedPrefix = randomBoolean();
                        0,
            .actionGet();
import org.opensearch.transport.client.ClusterAdminClient;
    }
    /**
        if (random.nextBoolean() && !builders.isEmpty() && dummyDocuments) {
        Set<String> indices = new HashSet<>();
        String nodeId = clusterState.getRoutingTable().index(indexName).shard(shardId).primaryShard().currentNodeId();
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
                    throw e;
        // In an integ test it doesn't make sense to keep track of warnings: if the cluster is external the warnings are in another jvm,
    }
                }
     * Waits until active/started replica shards are caught up with primary shard only when Segment Replication is enabled.
                }
    }
            )
            settings.put(BlobStoreRepository.SHARD_PATH_TYPE.getKey(), randomFrom(PathType.values()));
        assert index != null;
            .indices()
import org.opensearch.cluster.routing.ShardRoutingState;
     * This doesn't wait for inactive/non-started replica shards to become active/started.
        ClusterScope annotation = getAnnotation(this.getClass(), ClusterScope.class);
    }
            if (addMockInternalEngine() && randomBoolean()) {
                created.add(name);
                final Metadata loadedMetadata;
        return Settings.EMPTY;
                logger.info("Index [{}] docs async: [{}] bulk: [{}]", builders.size(), true, false);
        // If you are indexing just a few documents then frequently do it one at a time. If many then frequently in bulk.
 * A test cluster creates a set of nodes in the background before the test starts. The number of nodes in the cluster is
        assertTrue("index " + index + " not found", getIndexResponse.getSettings().containsKey(index));
     *   client().prepareIndex(index, type).setSource(source).execute().actionGet();
            );
        return prepareCreate(index, -1);
            : annotation.maxNumDataNodes();
    protected String primaryNodeName(String indexName) {
    }
     * framework. By default this method returns an identity function {@link Function#identity()}.
        return DEFAULT_MAX_NUM_SHARDS;
     * of this class are executed. This also has the side-effect of a suite level setup method {@link #setupSuiteScopeCluster()}
        String remoteRoutingTableRepoName,
    }
    @Retention(RetentionPolicy.RUNTIME)
        }
import org.opensearch.action.bulk.BulkResponse;
import org.opensearch.node.remotestore.RemoteStoreNodeService;
import org.opensearch.common.unit.TimeValue;
            .put(buildRemoteStateNodeAttributes(segmentRepoName, segmentRepoPath, segmentRepoType));
        if (random.nextBoolean()) {
                        .setId(id)
        TimeValue timeout,
     */
        segmentsPathFixedPrefix = randomBoolean();
     * Waits for all relocations and force merge all indices in the cluster to 1 segment.
    /**
        String segmentRepoType,
 * The most common test scope is {@link Scope#SUITE} which shares a cluster per test suite.
        IndicesExistsResponse actionGet = client().admin().indices().prepareExists(index).execute().actionGet();
        /**
    }
                builder.startObject();
        String routingTableRepositorySettingsAttributeKeyPrefix = String.format(
    protected int maximumNumberOfReplicas() {
    public void clearScroll(String... scrollIds) {
        List<CountDownLatch> inFlightAsyncOperations = new ArrayList<>();
            .put(stateRepoSettingsAttributeKeyPrefix + prefixModeVerificationSuffix, prefixModeVerificationEnable);
        Settings.Builder builder = Settings.builder().put(indexSettings()).put(settingsBuilder.build());
    }
import org.opensearch.common.settings.Setting.Property;
        if (addMockTransportService()) {
    protected final FlushResponse flush(String... indices) {
     */
        return ensureGreen(indices);
    /**
        ForceMergeResponse actionGet = client().admin()
        if (totalHits.value() != expectedResults || totalHits.relation() != TotalHits.Relation.EQUAL_TO) {
            translogRepoPath,
        return ensureColor(clusterHealthStatus, timeout, true, waitForNoInitializingShards, indices);
     * Returns path to a random directory that can be used to create a temporary file system repo
    /**
    }
        settingsBuilder.put(buildRemoteStoreNodeAttributes(segmentRepoName, segmentRepoPath, translogRepoName, translogRepoPath, false));
        if (random.nextBoolean()) {
        Settings build = builder.build();
        ClusterScope annotation = getAnnotation(this.getClass(), ClusterScope.class);
        refresh(indices);
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
    public static TestCluster cluster() {
        }
        return true;
        if (!build.isEmpty()) {
        }
                    operation.await();
        assertThat(clusterHealthResponse.isTimedOut(), is(false));
     * rules based on <code>index.routing.allocation.exclude._name</code>.
                IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.getKey(),
            // default 10s limit.
    public static final List<String> CODECS = List.of(
    /**
    /**
                PendingClusterTasksResponse pendingTasks = client.admin().cluster().preparePendingClusterTasks().setLocal(true).get();
         * Ignored when {@link ClusterScope#numDataNodes()} is set.
    /**
                    return actualHandler;
                logger.info("Randomly using Replication Strategy as {} and Storage Type as {}.", randomReplicationType, randomStorageType);
    private class LatchedActionListener<Response> implements ActionListener<Response> {
     * Threshold at which bulk indexing will always be used.
            this.numReplicas = numReplicas;
            settings = Settings.builder()
    public boolean isMigratingToRemoteStore() {
            }
     */
     * Returns a collection of plugins that should be loaded on each node.
import static org.opensearch.core.common.util.CollectionUtils.eagerPartition;
 * <li>-D{@value #TESTS_ENABLE_MOCK_MODULES} - a boolean value to enable or disable mock modules. This is
                }
            request.waitForStatus(status);
                }
            this.numPrimaries = numPrimaries;
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
import org.opensearch.transport.TransportRequest;
     * If a test is annotated with {@link SuiteScopeTestCase}
import org.opensearch.index.mapper.MockFieldFilterPlugin;
            client().admin().indices().prepareAddBlock(IndexMetadata.APIBlock.fromSetting(block), index).get();
        }
                Math.min(MAX_BULK_INDEX_REQUEST_SIZE, Math.max(1, (int) (builders.size() * randomDouble())))
     * IT classes.
        RemoteStoreEnums.PathHashAlgorithm pathHashAlgorithm = pathType != PathType.FIXED ? FNV_1A_COMPOSITE_1 : null;
                try (
         * Indicates whether the cluster automatically manages cluster bootstrapping. If set to {@code false} then the
                    XContentParser parser = createParser(
            final String dataPath = randomAlphaOfLength(10);
                .preparePutTemplate("random_index_template")
        }
         */
        );
                assertThat("client " + client + " still has pending tasks " + pendingTasks, pendingTasks, Matchers.emptyIterable());
        }, maxWaitTimeMs, TimeUnit.MILLISECONDS);
        String[] stringAddresses = clusterAddresses.split(",");
        // indexing threads can wait for up to ~1m before retrying when they first try to index into a shard which is not STARTED.
     *                This saves on unneeded searches.
    /**
import org.opensearch.index.remote.RemoteStorePathStrategy;
    ) {
            ReloadableFsRepository.TYPE,
    }
        }
                        .value();
        return buildRemoteStoreNodeAttributes(
        assertThat(clearResponse.isSucceeded(), equalTo(true));
                Locale.getDefault(),
            buildRemoteStoreNodeAttributes(
    }
        return Function.identity();
        0,
        String segmentRepoName,
                    } else {
                    .prepareFlush(indices)
import org.opensearch.cluster.health.ClusterHealthStatus;
     * Syntactic sugar for:
    protected static Boolean prefixModeVerificationEnable;
                    .put(initialNodeSettings.build())
            if (randomBoolean()) {
            }
     */
                false
                assertNull(
    protected static final int DEFAULT_MAX_NUM_SHARDS = 10;
     * are now allocated and started.
                final Map<String, Object> localStateMap = convertToMap(localClusterState);
    }
import org.opensearch.action.support.WriteRequest;
    protected Settings externalClusterClientSettings() {
/*
     * @return disruption
    }
        GetIndexResponse getIndexResponse = client().admin().indices().prepareGetIndex().setIndices(index).get();
                            localClusterState.toString()
            long lastKnownCount = indexer.totalIndexedDocs();
            featureSettings.put(builtInFlag.getKey(), builtInFlag.getDefaultRaw(Settings.EMPTY));
     * method.
                translogRepoType,
        Path[] repoFiles = environment.repoFiles();
    }
            segmentRepoPath,
                for (IndexRequestBuilder indexRequestBuilder : builders) {
                mocks.add(MockFSIndexStore.TestPlugin.class);
        final String clusterManagerNode = internalCluster().getClusterManagerName();
    public final void createIndex(String name, Settings indexSettings, String mapping) {
     * @param builders     the documents to index.
     * layout.
    }
            inFlightAsyncOperations.remove(waitFor).await();
            routingTableRepoName
     */
     * Fetch latest segment info snapshot version of an index.
    protected static Boolean translogPathFixedPrefix;
    }
        String stateRepoSettingsAttributeKeyPrefix = String.format(
            final NamedWriteableRegistry namedWriteableRegistry = cluster().getNamedWriteableRegistry();
                byte[] localClusterStateBytes = ClusterState.Builder.toBytes(localClusterState);
import org.opensearch.cluster.routing.ShardRouting;
    }
        return admin().cluster();
        public final int numSearchReplicas;
                builder = SmileXContent.contentBuilder();
    }
     *
        }
        if (clazz == Object.class || clazz == OpenSearchIntegTestCase.class) {
        // use either 0 or 1 replica, yet a higher amount when possible, but only rarely
import org.opensearch.test.disruption.ServiceDisruptionScheme;
            @Override
        return client().prepareIndex(index).setId(id).setSource(source).execute().actionGet();
            randomSettingsBuilder.put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), 0);
     * For tests with remote store enabled domain, it will be overridden to true.
        @NonNull String routingTableRepoName,
    }
                .setThreads(99999)
                    )
                    .build();
    }
        }
        for (DefaultShardOperationFailedException failure : actionGet.getShardFailures()) {
        }
            builder.put(
                nodePrefix = SUITE_CLUSTER_NODE_PREFIX;
        updateSettingsRequest.persistentSettings(settings);
    /** Ensures the result counts are as expected, and logs the results if different */
                logger.info("Index [{}] docs async: [{}] bulk: [{}]", builders.size(), false, false);
     * @param forceRefresh   if {@code true} all involved indices are refreshed once the documents are indexed.
                    )
    }
    }
        return testClusterRule.clientForNode(node);
    }
                    String action,
        String translogRepoName,
         * and there will be no dedicated cluster-manager (and data) nodes. Default is {@code false} which means
        );
    }
                segmentRepoPath,
     * Checks if Segment Replication is enabled on Index.
            createTempDir(),
        );
import java.lang.annotation.Inherited;
            throw new RuntimeException(e);
    /** node names of the corresponding clusters will start with these prefixes */
    public static Settings remoteStoreClusterSettings(
     * are formed. This is useful for testing with the concurrent search use-case as it creates
            client().admin().cluster().preparePendingClusterTasks().get()
     * where source is a JSON String.
                        // instead we compare the string length of cluster state - they should be the same
                    .setIndicesOptions(IndicesOptions.lenientExpandOpen())
        protected void addError(Exception e) {}
            builder.put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(1, ByteSizeUnit.PB)); // just
import org.opensearch.common.Priority;
     * @param numSegments the number of segments to create
            createTempDir(),
                randomStorageType = "LOCAL";
                .build();
    }
     * This method ingests bogus documents for the given indices such that multiple slices
                        .setIndex(index)
                    .execute(new LatchedActionListener<>(newLatch(inFlightAsyncOperations)));
            mocks.add(MockHttpTransport.TestPlugin.class);
            getAutoManageClusterManagerNodes(),
                builders,
        if (addMockTransportService()) {
 * </pre>
                false
    /**
 * <ul>
            Locale.getDefault(),
        /**
            buildRemoteStoreNodeAttributes(
        final CopyOnWriteArrayList<Tuple<IndexRequestBuilder, Exception>> errors = new CopyOnWriteArrayList<>();
            // always default delayed allocation to 0 to make sure we have tests are not delayed
        String timeout,
    }
         */
 * {@literal @}NodeScope(scope=Scope.TEST) public class SomeIT extends OpenSearchIntegTestCase {
     * Syntactic sugar for:
        return actionGet.getStatus();
        if (random.nextBoolean()) {
import java.util.concurrent.CopyOnWriteArrayList;
            if (mockPlugins.contains(getTestTransportPlugin()) == false) {
            // keep this low so we don't stall tests
import org.opensearch.common.settings.ClusterSettings;
            for (List<IndexRequestBuilder> segmented : partition) {
                    .setMaxNumSegments(between(1, 10))
                    differenceBetweenMapsIgnoringArrayOrder(
        public List<Setting<?>> getSettings() {
            builder.put(
            for (String index : indices) {
        ClusterHealthRequest request = Requests.clusterHealthRequest().waitForNoRelocatingShards(true).waitForEvents(Priority.LANGUID);
     * For tests with remote cluster state, it will reset the cluster and cluster state will be
 * <p>
        mocks.add(TestSystemTemplatesRepositoryPlugin.class);
            seed,
     */
     * indexes them in a blocking or async fashion. This is very useful to catch problems that relate to internal document
                    } catch (final AssertionError error) {
import java.util.concurrent.atomic.AtomicInteger;
     */
        return internalCluster().routingKeyForShard(resolveIndex(index), shard, random());
                translogRepoName,
    }
                indexMetadata.toXContent(builder, serializationFormatParams);
            return buildExternalCluster(clusterAddresses, clusterName);
                            clusterManagerClusterState.stateUUID(),
     * creates an index with the given setting and mapping
    protected void ensureStableCluster(int nodeCount, TimeValue timeValue, boolean local, @Nullable String viaNode) {
    private static final int ALWAYS_BULK_THRESHOLD = 3000;
                routingTableRepoName
     * @return boolean.
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
        RefreshResponse refreshResponse = refresh(indices);
        }
        logger.debug("indices {} are {}", indices.length == 0 ? "[_all]" : indices, color);
    public static Settings remoteStoreClusterSettings(
                assertThat(actualErrors, emptyIterable());
package org.opensearch.test;
    }
                builder.endObject();
                IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(),
        if (actionGet.isTimedOut()) {
     * This method is used to obtain settings for the {@code N}th node in the cluster.
            String clusterUUIDBefore = clusterService().state().metadata().clusterUUID();
        }, maxWaitTimeMs, TimeUnit.MILLISECONDS);
     * before the first test of this class is executed.
                ).getStringRep()
     * already exists this method will fail and wipe all the indices created so far.
                segmentRepoName,
        if (random.nextBoolean()) {
                    .indices()
        ForceMergeResponse actionGet = client().admin().indices().prepareForceMerge().setMaxNumSegments(1).execute().actionGet();
                        .setSource("{}", MediaTypeRegistry.JSON)
    public void waitForIndexed(final long numDocs, final BackgroundIndexer indexer) throws Exception {
        assertAcked(putRepositoryRequestBuilder(adminClient, repoName, type, true, settings, timeout, false));
                    "a, b, c"
            PutIndexTemplateRequestBuilder putTemplate = client().admin()
                .get()
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        return settings.build();
import static org.opensearch.index.IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING;
    ) {
            if (logger.isDebugEnabled()) {
    /**
        settingsBuilder.put(
            builder.put(INDEX_DOC_ID_FUZZY_SET_FALSE_POSITIVE_PROBABILITY_SETTING.getKey(), randomDoubleBetween(0.01, 0.50, true));
        if (random.nextBoolean()) {
        );
        ClusterAdminClient adminClient,
                builder = SmileXContent.contentBuilder();
        );
    /**
    public Path randomRepoPath() {
import org.opensearch.cluster.service.ClusterService;
                RandomPicks.randomFrom(random, Translog.Durability.values())
        Scope scope() default Scope.SUITE;
         */
import org.opensearch.index.codec.CodecService;
        assertAcked(putRepositoryRequestBuilder(adminClient, repoName, type, true, settings, null, false));
        return settings.build();
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
    }
            .put(routingTableRepositoryTypeAttributeKey, routingTableRepoType)
    public enum Scope {
                    )
     * Setting all feature flag settings at base IT, which can be overridden later by individual
    protected final IndexResponse index(String index, String type, String id, Map<String, Object> source) {
     * Syntactic sugar for:
    }
     */
        return client().prepareIndex(index).setId(id).setSource(source).execute().actionGet();
    }
        Path routingTableRepoPath,
            .putList(DISCOVERY_SEED_HOSTS_SETTING.getKey()) // empty list disables a port scan for other nodes
                                                                                                                                    // flush
     * Disabling this for now as the existing way of strict check do not support multiple nodes internal cluster.
    ) {
            if (annotation != null && annotation.value().length == 1 && "*".equals(annotation.value()[0])) {
                        .setTrackTotalHits(true)
    /**
                builder.endObject();
    /**
        Path segmentRepoPath,
        Set<List<String>> bogusIds = new HashSet<>();
import org.opensearch.cluster.ClusterModule;
                remoteRoutingTableRepoPath,
        String routingTableRepoAttributeKey = null, routingTableRepoSettingsAttributeKeyPrefix = null;
                throw new IllegalArgumentException("Missing tests.clustername system property");
            remoteStateRepoName
    public ClusterHealthStatus ensureGreen(TimeValue timeout, String... indices) {
     * Returns a random cluster admin client. This client can be pointing to any of the nodes in the cluster.
                final BytesReference compareOriginalBytes = BytesReference.bytes(compareBuilder);
        }
        boolean verify,
    }
        }
        Path translogRepoPath,
                builder.endObject();
     * Compute a routing key that will route documents to the <code>shard</code>-th shard
    public static Settings buildRemoteStoreNodeAttributes(
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;
     * Verifies that all nodes that have the same version of the cluster state as cluster-manager have same cluster state
     * Key used to eventually switch to using an external cluster and provide its transport addresses
    /**
/*
        public final void onResponse(Response response) {
                .put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 2)
            .basePath(BlobPath.cleanPath())
        final Optional<Integer> id = indexService.shardIds().stream().filter(sid -> sid.equals(shardId.id())).findFirst();
     * </pre>
    protected static Settings buildRemoteStoreNodeAttributes(
import java.util.Collections;
                        XContentHelper.convertToMap(compareOriginalBytes, false, XContentType.SMILE).v2(),
    private static final boolean MOCK_MODULES_ENABLED = "true".equals(System.getProperty(TESTS_ENABLE_MOCK_MODULES, "true"));
            null,
        String segmentRepoName,
                .map(NodeHotThreads::getHotThreads)
    }
     * @return Feature flag settings.
            public Collection<Class<? extends Plugin>> nodePlugins() {
     * Waits until at least a give number of document is indexed by indexer
    }
import org.opensearch.index.engine.Segment;
    /**
            try {
    /**
        Path segmentRepoPath,
     * can be controlled through specific methods.
                            differenceBetweenMapsIgnoringArrayOrder(clusterManagerStateMap, localStateMap)
            String failMsg = sb.toString();
        );
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
            } else if (maybeFlush && rarely()) {
    }
        ClusterScope annotation = getAnnotation(this.getClass(), ClusterScope.class);
     */
        }
     */
        }
    protected boolean forbidPrivateIndexSettings() {
        } catch (Exception e) {
import static org.opensearch.discovery.SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING;
                final IndexMetadata loadedIndexMetadata;
        TimeValue timeout,
    }
    protected int minimumNumberOfReplicas() {
            nodePlugins(),
                segmentRepoPath,
        return blobPath.buildAsString();
import static org.opensearch.index.IndexSettings.INDEX_DOC_ID_FUZZY_SET_FALSE_POSITIVE_PROBABILITY_SETTING;
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        String segmentRepoName,
        int numClientNodes() default InternalTestCluster.DEFAULT_NUM_CLIENT_NODES;
    }
        if (IndexMetadata.APIBlock.fromSetting(block) == IndexMetadata.APIBlock.READ_ONLY_ALLOW_DELETE || randomBoolean()) {
 * <li> - a random seed used to initialize the index random context.
            compareParams.put(Metadata.CONTEXT_MODE_PARAM, Metadata.CONTEXT_MODE_GATEWAY);
    }
            logger.info(
                compareBuilder.startObject();
import org.opensearch.test.disruption.NetworkDisruption;
            builder.put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), between(0, 1000));
            errors.add(new Tuple<>(builder, e));
            if (randomBoolean() && addMockTransportService()) {
        client().admin()
     * This method uses allocation deciders to filter out certain nodes to allocate the created index on. It defines allocation
    public static void putRepository(
    protected int maximumNumberOfShards() {
        return anyDebian8Nodes && java15Plus == false;
        String... indices
import org.opensearch.core.common.unit.ByteSizeUnit;
     *                This saves on unneeded searches.
        client().admin()
            while (refreshCount-- > 0) {
    /**
     * restored from remote.
    protected static boolean indexExists(String index) {
         * negative value means that the number of client nodes will be randomized.
            // integration tests that usually create few documents
    }
                remoteRoutingTableRepoName,
            return snapshot.get().version;
        // Enable tracer only when Telemetry Setting is enabled
     */
    }
                mocks.add(MockEngineFactoryPlugin.class);
            assertThat("unexpected flush failure " + failure.reason(), failure.status(), equalTo(RestStatus.SERVICE_UNAVAILABLE));
        assertBusy(() -> {
        return nodes;
     */
        return refreshResponse;
 * nodes in the cluster for each call to {@link #client()}. Test failures might only be reproducible if the correct
    /**
    /**
        if (status != null) {
 * this work for additional information regarding copyright
            public Settings nodeSettings(int nodeOrdinal) {
            for (ShardSegments shardSegments : indexShardSegments.getShards()) {
            supportsDedicatedClusterManagers,
import java.lang.annotation.Retention;
                Collections.singleton(clusterManagerNode),
     * Default maximum number of shards for an index
                        + XContentHelper.convertToMap(parsedBytes, false, XContentType.SMILE),
    }
            builder.put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), maxMergeCount);
         * are either the specified ones or the default ones if not specified.
            .waitForStatus(clusterHealthStatus)
     */
            // otherwise, use it, it has assertions and so on that can find bugs.
                assertThat("client " + client + " still has in flight fetch", clusterHealth.getNumberOfInFlightFetch(), equalTo(0));
                segmentRepoName,
    protected String primaryNodeName(String indexName, int shardId) {
 * <li>{@link Scope#TEST} - uses a new cluster for each individual test method.</li>
            actionGet.getStatus().value(),
        int maxNumDataNodes;
}
                final BytesReference originalBytes = BytesReference.bytes(builder);
            } else {
     * Nodes in this cluster are associated with an ordinal number such that nodes can
            this.builder = builder;
                false
            .put(stateRepoTypeAttributeKey, stateRepoType)
 * {@link OpenSearchIntegTestCase} is an abstract base class to run integration
                                                if (replicaShard.indexSettings().isSegRepEnabledOrRemoteNode()) {
        boolean verify,
                    logger.debug("[{}] docs indexed. waiting for [{}]", lastKnownCount, numDocs);
import java.net.URI;
import org.opensearch.index.shard.IndexShard;
     *
    protected int minimumNumberOfShards() {
        }
        }
     */
    }
    }
     */
import org.opensearch.common.xcontent.smile.SmileXContent;
            Map<String, Object> clusterManagerStateMap = convertToMap(clusterManagerClusterState);
    ) {
import org.opensearch.indices.IndicesRequestCache;
         * Returns the number of nodes in the cluster. Default is {@code -1} which means
    }
     */
                        // We also cannot compare byte array size because CompressedXContent's DeflateCompressor uses
import org.opensearch.node.NodeMocksPlugin;
        Settings.Builder featureSettings = Settings.builder();
            "cluster state:\n{}\n{}",
                        .setRouting(id);
                .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
            randomReplicationType = randomBoolean() ? ReplicationType.DOCUMENT : ReplicationType.SEGMENT;
    protected boolean addMockGeoShapeFieldMapper() {
        putRepository(clusterAdmin(), repoName, type, null, settings);
     * The value of this seed can be used to initialize a random context for a specific index.
        return annotation == null ? true : annotation.supportsDedicatedMasters();
    @Retention(RetentionPolicy.RUNTIME)
                XContentBuilder builder = SmileXContent.contentBuilder();
        boolean waitForNoRelocatingShards,
        builder.put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), 0);
                : "");
 * that are created before the tests start.
                                                    );
            translogRepoName
            getExcludeSettings(numNodes, builder);
import org.opensearch.index.MockEngineFactoryPlugin;
    }
        }
    protected boolean addMockHttpTransport() {
        if (random.nextBoolean()) {
        // indexing threads can wait for up to ~1m before retrying when they first try to index into a shard which is not STARTED.
                    indexRequestBuilder.setRefreshPolicy(WriteRequest.RefreshPolicy.NONE);
            .execute()
import org.opensearch.transport.client.AdminClient;
        int maxNumDataNodes() default -1;
        snapshotShardPathFixedPrefix = randomBoolean();
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
import org.opensearch.indices.RemoteStoreSettings;
import java.lang.annotation.ElementType;
                        .getTotalHits()
    /**
        boolean finalSettings
import org.opensearch.action.admin.indices.segments.IndexShardSegments;
        settings.put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.getKey(), segmentsPathFixedPrefix ? "b" : "");
     */
                IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(),
    }
        if (withRateLimiterAttributes) {
                    indexRequestBuilder.execute(
import java.lang.Runtime.Version;
            indices = getClusterState().routingTable().indicesRouting().keySet().toArray(String[]::new);
            );
            mocks.add(getTestTransportPlugin());
     * Annotation for third-party integration tests.
    /**
    /**
                    .prepareForceMerge(indices)
import org.opensearch.OpenSearchException;
     * ids or index segment creations. Some features might have bug when a given document is the first or the last in a
    protected void ensureClusterStateCanBeReadByNodeTool() throws IOException {
        Settings.Builder settings
 * GitHub history for details.
        return getIndexResponse.getSettings().get(index).get(IndexMetadata.SETTING_DATA_PATH);
 * <p>
            segmentRepoType,
    protected NamedXContentRegistry xContentRegistry() {
            }
                "failed to delete a dummy doc [" + doc.get(0) + "][" + doc.get(1) + "]",
        Settings.Builder settings
        final boolean anyDebian8Nodes = response.getNodes()
        String translogRepoName,
     * Represent if it needs to trigger remote state restore or not.
                }
            remoteRoutingTableRepoPath,
    /**
    /**
                builder.put(CLUSTER_REPLICATION_TYPE_SETTING.getKey(), randomReplicationType);
        /**
            long lastKnownCount = indexer.totalIndexedDocs();
        Path segmentRepoPath,
            for (int i = 0; i < numBogusDocs; i++) {
        IndexSegments indexSegments = segmentResponse.getIndices().get(indexName);
    protected final boolean enableWarningsCheck() {
        return false;
            nodeConfigurationSource,
                builder.startObject();
    }
    public final void createIndex(String... names) {
     * Restricts the given index to be allocated on <code>n</code> nodes using the allocation deciders.
            } finally {
            @Override
                final BytesReference originalBytes = BytesReference.bytes(builder);
            }
    }
        if (value % 2 == 1) {
    /** Enables an index block for the specified index */
            ? Settings.builder().put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), value).build()
    protected Collection<PluginInfo> additionalNodePlugins() {
     * Prints the current cluster state as debug logging.
        if (addMockHttpTransport()) {
import org.opensearch.action.search.SearchResponse;
     * are caught up with primary shard only when Segment Replication is enabled.
                for (CountDownLatch operation : inFlightAsyncOperations) {
    private final AtomicInteger dummmyDocIdGenerator = new AtomicInteger();
        assertNoFailures(actionGet);
        }
    }
        }
                latch.countDown();
            builder.put(Store.FORCE_RAM_TERM_DICT.getKey(), true);
     * <p>
import org.opensearch.core.xcontent.NamedXContentRegistry;
                    );
     * via the {@code tests.config} system property.
import org.opensearch.core.xcontent.ToXContent;
     * </p>
    private ReplicationType randomReplicationType;
        ensureStableCluster(nodeCount, timeValue, false, null);
                segmentRepoName,
                        tuple.v1().execute().actionGet(); // re-index if rejected
            .put(segmentRepoTypeAttributeKey, segmentRepoType)
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
            public Collection<PluginInfo> additionalNodePlugins() {
            mockPlugins,
            Settings.Builder randomSettingsBuilder = setRandomIndexSettings(random(), Settings.builder());
        assertAcked(putRepositoryRequestBuilder(adminClient, repoName, type, verify, settings, null, false));
            // if the test class is annotated with SuppressCodecs("*"), it means don't use lucene's codec randomization
import org.opensearch.common.settings.FeatureFlagSettings;
        /**
            }
                client().prepareDelete(doc.get(0), doc.get(1)).setRouting(doc.get(1)).get().getResult()
    protected void ensureClusterStateConsistency() throws IOException {
     * Key used to retrieve the index random seed from the index settings on a running node.
                    + "]. last cluster state:\n"
            } else {
    public static void afterClass() throws Exception {
    protected void ensureClusterSizeConsistency() {
        while (inFlightAsyncOperations.size() > MAX_IN_FLIGHT_ASYNC_INDEXES) {
    protected IndexShard getIndexShard(ShardRouting routing, String indexName) {
    }
        );
     * {@link org.opensearch.cluster.NodeConnectionsService} will eventually reconnect but it's
        if (status != null) {
     * </pre>
    protected final void flushAndRefresh(String... indices) {
    }
            logger.debug("allowNodes: updating [{}]'s setting to [{}]", index, build.toDelimitedString(';'));
import org.opensearch.index.IndexSettings;
        }
                                        final List<ShardRouting> replicaRouting = shardRoutingTable.replicaShards();
     */
    public Set<String> assertAllShardsOnNodes(String index, String... pattern) {
                                            if (replica.state() == ShardRoutingState.STARTED) {
 */
                ClusterState localClusterState = client.admin().cluster().prepareState().all().setLocal(true).get().getState();
                for (int i = 0; i < numDocs; i++) {
 * </ul>
            .put(SearchService.CONCURRENT_SEGMENT_SEARCH_MAX_SLICE_COUNT_KEY, 2)
    public ClusterHealthStatus ensureGreen(String... indices) {
import org.junit.BeforeClass;
    /**
        Client client = internalCluster().dataNodeClient();
 * You may obtain a copy of the License at
            ReloadableFsRepository.TYPE,
    protected ForceMergeResponse forceMerge(int maxNumSegments) {
     * by the given builder
            .waitForNoRelocatingShards(waitForNoRelocatingShards)
 * <li>{@link Scope#SUITE} - uses a cluster shared across all test methods in the same suite</li>
        return prepareCreate(index, -1, settingsBuilder);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;
        Settings.Builder builder = Settings.builder();
     * Syntactic sugar for disabling allocation for <code>indices</code>
@LuceneTestCase.SuppressFileSystems("ExtrasFS") // doesn't work with potential multi data path from test cluster yet
        }
    public static void setClusterReadOnly(boolean value) {
import org.opensearch.core.xcontent.XContentParser;
     * Iff this returns true mock transport implementations are used for the test runs. Otherwise not mock transport impls are used.
        int numberOfReplicas = numberOfReplicas();
import java.util.Arrays;
            builder.put(MergeSchedulerConfig.AUTO_THROTTLE_SETTING.getKey(), false);
        waitForReplication();
        }
     * for the given indices
                BulkRequestBuilder bulkBuilder = client().prepareBulk();
        String segmentRepoType,
        return testClusterRule.cluster();
        boolean withRateLimiterAttributes
            builder.put(
                                                    assertEquals(
     *   empty dummy documents are may be randomly inserted into the document
                "{} timed out, cluster state:\n{}\npending tasks:\n{}\nhot threads:\n{}\n",
                logger.info("Action Failed", t);
                                                fail("replica shard still INITIALIZING, not caught up with primary");
        ClusterAdminClient adminClient,
                                            }
                routingTableRepoPath,
            settings = Settings.builder()
        String translogRepoName,
     * be started with specific configurations. This method might be called multiple
            builder.put(
            segmentRepoPath,
import org.apache.lucene.codecs.Codec;
                final int localClusterStateSize = localClusterState.toString().length();
            operation.await();
import org.opensearch.test.client.RandomizingClient;
import org.opensearch.core.action.ActionListener;
                        OpenSearchNodeCommand.namedXContentRegistry,
            final Client clusterManagerClient = client();
    private static final int FREQUENT_BULK_THRESHOLD = 300;
    public final void createIndex(String name, Settings indexSettings) {
            // Default the watermarks to absurdly low to prevent the tests
        } else {
        assertBusy(() -> {
            .waitForNoInitializingShards(waitForNoInitializingShards)
            .put(IndicesService.INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), "1s")
        return client().prepareIndex(index).setId(id).setSource(source).execute().actionGet();
    }
     */
        Settings.Builder settings,
    }
        return waitForRelocation(null);
            transportAddresses[i++] = new TransportAddress(new InetSocketAddress(inetAddress, uri.getPort()));
     * may require the user to manually configure an external process (such as rabbitmq),
            if (scope == Scope.TEST) {
                clusterHealth = client.admin().cluster().prepareHealth().setLocal(true).get();
                metadataWithoutIndices.toXContent(builder, serializationFormatParams);
    }
    @Target({ ElementType.TYPE })
         */
    }
    /**
            // when comparing XContent output, do not use binary format
    /**
     */
            Locale.getDefault(),
        }
        String translogRepoName,
                                        }
            logger.warn("{}", sb);
    public static final String SUITE_CLUSTER_NODE_PREFIX = "node_s";
    protected static class NumShards {
     *   return client().prepareIndex(index, type, id).setSource(source).execute().actionGet();
            assertThat(lastKnownCount, greaterThanOrEqualTo(numDocs));
                }
        if (annotation != null) {
        }
         * dedicated cluster-manager nodes will be randomly used.
                    bogusIds.add(Arrays.asList(index, id));
import org.opensearch.action.index.IndexRequestBuilder;
        String routingTableRepoType,
                );
        boolean isMixedMode = clusterSettings.get(REMOTE_STORE_COMPATIBILITY_MODE_SETTING)
            translogRepoPath,
            builder.put(IndexMetadata.SETTING_DATA_PATH, dataPath);
            InetAddress inetAddress = InetAddress.getByName(uri.getHost());
            .prepareUpdateSettings(indices)
     * Clears the given scroll Ids
            boolean success = false;
    protected boolean addMockIndexStorePlugin() {
import org.opensearch.core.common.unit.ByteSizeValue;
    /**
        String exclude = String.join(",", internalCluster().allDataNodesButN(num));
        Settings settings = Settings.builder().put(block, false).build();
        return true;
import org.opensearch.action.support.IndicesOptions;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
     * and can use this method for selective muting.
            forbidPrivateIndexSettings()
                    .put(OpenSearchIntegTestCase.this.nodeSettings(nodeOrdinal))
        Settings.Builder settingsBuilder = Settings.builder();
     * per index basis. Allows to enable/disable the randomization for number of shards and replicas
    }
    }
        return clusterState.getRoutingNodes().node(nodeId).node().getName();
    public static OpenSearchTestClusterRule testClusterRule = new OpenSearchTestClusterRule();
    }
    }
     * @param builders       the documents to index.
import java.lang.annotation.Target;
    /**
        String type,
 */
     */
     * Syntactic sugar for enabling allocation for <code>indices</code>
            assertThat("timed out waiting for relocation", actionGet.isTimedOut(), equalTo(false));
        if (useRandomReplicationStrategy()) {
     * Ensures the cluster has a yellow state via the cluster health API and ensures the that cluster has no initializing shards
     * Key to provide the cluster name
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
     */
 * The OpenSearch Contributors require contributions made to
                    loadedMetadata = Metadata.fromXContent(parser);
            }
                            }
                                                        getLatestSegmentInfoVersion(replicaShard)
            .equals(RemoteStoreNodeService.Direction.REMOTE_STORE);
                        IndexRoutingTable indexRoutingTable = getClusterState().routingTable().index(index);
    protected int numberOfShards() {
    public static final String TESTS_CLUSTER_NAME = "tests.clustername";
            for (String setting : randomSettingsBuilder.keys()) {
            try {
        if (addMockGeoShapeFieldMapper()) {
        );
        return actionGet;
            builder.put(
import org.opensearch.client.RestClient;
 * </pre>
     */
            // remove local node reference
    /**
            .map(c -> randomRepoPath(c.getDefaultSettings()))
            }
        assertTrue("index " + index + " not found", getIndexResponse.getSettings().containsKey(index));
                client().admin()
        String segmentRepoSettingsAttributeKeyPrefix = String.format(
            }
    }
            }
    );
import java.util.Locale;
        }
                builder.startObject();
                }
        if (n > 0) {
        ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
    ) {
            .build();
        if (forceRefresh) {
            latch.countDown();
            .setLocal(local)
                loadedMetadata.toXContent(builder, compareFormatParams);
    public static PutRepositoryRequestBuilder putRepositoryRequestBuilder(
            translogRepoName,
                logger.debug("Error indexing doc: " + t.getMessage() + ", reindexing.");
                assertThat("non index. prefix setting set on index template, its a node setting...", setting, startsWith("index."));
import org.apache.lucene.index.SegmentInfos;
            final ToXContent.Params compareFormatParams = new ToXContent.MapParams(compareParams);
            .indices()
import java.util.Optional;
                            "invalid action name [" + action + "] must start with one of: " + TransportService.VALID_ACTION_PREFIXES
                @Override
        } else {
     * The override to fetch the {@link CompletionFieldMapper.CompletionFieldType} postings format is not available for this codec.
    @Deprecated
                }
     * Returns {@code true} if this test cluster can use a mock internal engine. Defaults to true.
                if (isSegmentReplicationEnabledForIndex(index)) {
            withRateLimiterAttributes
        String translogRepoType,
        final TotalHits totalHits = searchResponse.getHits().getTotalHits();
        }
                randomSettingsBuilder.put("index.codec", randomFrom(CODECS));
                    IndexRequestBuilder indexRequestBuilder = client().prepareIndex()
     * This method must be overridden by subclass to use random replication strategy.
        @Override
        testClusterRule.afterClass();
        String repoName,
        assertAcked(prepareCreate(name).setSettings(indexSettings).setMapping(mapping));
     *   list and deleted once all documents are indexed. This is useful to
import org.opensearch.indices.IndicesService;
            .get();
                    + viaNode
            client = new RandomizingClient(client, random());
                Locale.getDefault(),
                INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.getKey(),
            null,
                );
                )
        int numberOfShards = numberOfShards();
                loadedIndexMetadata.toXContent(builder, compareFormatParams);
                assertNull(
         * A test exclusive test cluster
            translogRepoName,
                client().admin().cluster().prepareState().get().getState(),
                mocks.add(MockFieldFilterPlugin.class);
     *
                metadataWithoutIndices.toXContent(compareBuilder, compareFormatParams);
                    .indices()
            .waitForNodes(Integer.toString(cluster().size()));
                    "failed to delete a dummy doc [" + doc.get(0) + "][" + doc.get(1) + "]",
        }
import java.net.InetAddress;
                        nodes.add(name);
        /**
 * <p>
            getClientWrapper(),
import org.opensearch.transport.client.Requests;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        });
    /**
        return testClusterRule.isInternalCluster();
     * the checks and modifications that are applied to the used test cluster are only done after all tests
                public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(
                    .setIndicesOptions(IndicesOptions.lenientExpandOpen())
                    Throwable t = ExceptionsHelper.unwrapCause(tuple.v2());
        settingsBuilder.put(
    public static final String TEST_CLUSTER_NODE_PREFIX = "node_t";
        // always default delayed allocation to 0 to make sure we have tests are not delayed
    protected void waitForReplication(String... indices) {
import org.opensearch.common.util.concurrent.ThreadContext;
        Path segmentRepoPath,
                    "cluster state XContent serialization does not match, expected "
                    }
    protected Set<String> excludeTemplates() {
     * Flush some or all indices in the cluster.
        }
    }
                    .execute(new LatchedActionListener<>(newLatch(inFlightAsyncOperations)));
        }
    ) {
            final Client clusterManagerClient = client();
        }
        featureSettings.put(FeatureFlags.APPLICATION_BASED_CONFIGURATION_TEMPLATES_SETTING.getKey(), true);
    /**
            translogRepoType,
    }
            nodePrefix,
     * @param forceRefresh   if {@code true} all involved indices are refreshed once the documents are indexed.
        return featureSettings.build();
            ReloadableFsRepository.TYPE,
    }
        }
        }
        }
                .getNodes()
     *   client().prepareIndex(index, type).setSource(source).execute().actionGet();
    /**
                .setOrder(0)
            // add both mock plugins - local and tcp if they are not there
        }
 * specific language governing permissions and limitations
            if (t instanceof OpenSearchRejectedExecutionException) {
            builder.put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), maxThreadCount);
                        new PayloadLatchedActionListener<>(indexRequestBuilder, newLatch(inFlightAsyncOperations), errors)
    }
                    XContentParser parser = createParser(
    }
                assertAcked(prepareCreate(name));
        assertNoFailures(actionGet);
        return Collections.emptyList();
                .build();
import static org.opensearch.index.IndexSettings.INDEX_DOC_ID_FUZZY_SET_ENABLED_SETTING;
        waitForRelocation();
    }
import org.junit.Rule;
            // wait short time for other active shards before actually deleting, default 30s not needed in tests
                                            } else if (replica.state() == ShardRoutingState.INITIALIZING) {
        // 30% of the time
import org.opensearch.transport.TransportInterceptor;
            )
        } else {
            .put(segmentRepoSettingsAttributeKeyPrefix + "location", segmentRepoPath)
     * Ensures that all nodes in the cluster are connected to each other.
                }
import org.opensearch.index.TieredMergePolicyProvider;
        if (randomBoolean()) {
        if (randomBoolean()) {
            stateRepoName
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
    protected long getLatestSegmentInfoVersion(IndexShard shard) {
            .execute()
                client().admin().indices().prepareRefresh(indicesArray).setIndicesOptions(IndicesOptions.lenientExpandOpen()).get()
import org.opensearch.indices.store.IndicesStore;
            // when tests are run with concurrent segment search enabled
            : annotation.minNumDataNodes();
                            "Cluster state from cluster-manager:\n{}\nLocal cluster state:\n{}",
        if (random.nextBoolean()) {
     */
            Locale.getDefault(),
            @Override
        indexRandom(forceRefresh, Arrays.asList(builders));
            // by default we never cache below 10k docs in a segment,
                }
     * Creates one or more indices and asserts that the indices are acknowledged. If one of the indices
    /**
        List<String> created = new ArrayList<>();
            settings = Settings.builder()
    private static Settings.Builder setRandomIndexTranslogSettings(Random random, Settings.Builder builder) {
 * </ul>
    public void indexRandom(boolean forceRefresh, IndexRequestBuilder... builders) throws InterruptedException {
        if (cluster().size() > 0) {
            byte[] masterClusterStateBytes = ClusterState.Builder.toBytes(clusterManagerClusterState);
        return ensureColor(ClusterHealthStatus.GREEN, timeout, false, indices);
            .put(stateRepoSettingsAttributeKeyPrefix + "location", stateRepoPath)
        }
        private final CopyOnWriteArrayList<Tuple<T, Exception>> errors;
    public CreateIndexRequestBuilder prepareCreate(String index, int numNodes, Settings.Builder settingsBuilder) {
     * are now allocated and started.
            ? InternalTestCluster.DEFAULT_MAX_NUM_DATA_NODES
    }
        try {
            serializationParams.put(Metadata.CONTEXT_MODE_PARAM, Metadata.CONTEXT_MODE_GATEWAY);
    }
            mocks.add(MockTelemetryPlugin.class);
        settings.put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_METADATA.getKey(), randomBoolean());
        indexRandom(forceRefresh, dummyDocuments, true, builders);
     * Should be used only on test classes where replication strategy is not critical for tests.
        }
        testClusterRule.beforeClass();
                        SmileXContent.smileXContent,
                    DocWriteResponse.Result.DELETED,
     *
    }
    }
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
    private ClusterHealthStatus ensureColor(
                mocks.add(MockTransportService.TestPlugin.class);
        @Override
                        XContentHelper.convertToMap(parsedBytes, false, XContentType.SMILE).v2()
    private boolean getAutoManageClusterManagerNodes() {
        if (cluster() != null && cluster().size() > 0) { // if static init fails the cluster can be null
    }
        refresh();
                success = true;
    /**
        assertAcked(prepareCreate(name).setSettings(indexSettings));
        throws InterruptedException {
        return client(null);
                        logger.error(
     * By default it returns a settings object that sets a random number of shards. Number of shards and replicas
 * If the test methods need specific node settings or change persistent and/or transient cluster settings {@link Scope#TEST}
                        // (see: DeflateCompressedXContentTests#testDifferentCompressedRepresentation for an example)
         * a random number of nodes is used, where the minimum and maximum number of nodes
                    postIndexAsyncActions(indicesArray, inFlightAsyncOperations, maybeFlush);
     * that is executed in a separate test instance. Variables that need to be accessible across test instances must be static.
    protected void updateRepository(String repoName, String type, Settings.Builder settings) {
    ) {
    public ClusterHealthStatus waitForRelocation(ClusterHealthStatus status) {
     *
     * It is useful to ensure that all action on the cluster have finished and all shards that were currently relocating
import java.util.concurrent.TimeUnit;
        Path segmentRepoPath,
    /**
     */
        try (final GatedCloseable<SegmentInfos> snapshot = shard.getSegmentInfosSnapshot()) {
                        assertEquals(
        /**
            }
        return false;
     * @param indexer a {@link BackgroundIndexer}. It will be first checked for documents indexed.
        return settingsBuilder.build();
     * The index that is created with this builder will only be allowed to allocate on the number of nodes passed to this
        String translogRepoName,
        );
        return buildRemoteStoreNodeAttributes(
     * By default if no {@link ClusterScope} annotation is present {@link OpenSearchIntegTestCase.Scope#SUITE} is used
            assertNoTimeout(client().admin().cluster().prepareHealth().setWaitForNodes(Integer.toString(cluster().size())).get());
            ClusterState clusterManagerClusterState = clusterManagerClient.admin().cluster().prepareState().all().get().getState();
        return clusterService().state().getMetadata().isSegmentReplicationEnabled(index) || isMigratingToRemoteStore();
        boolean withRateLimiterAttributes
        updateSettingsRequest.persistentSettings(settings);
     *
        }
            }
        return between(minimumNumberOfReplicas(), maximumNumberOfReplicas());
        ClusterHealthResponse actionGet = client().admin().cluster().health(healthRequest).actionGet();
                List<CountDownLatch> inFlightAsyncOperations = new ArrayList<>();
            .setSettings(Settings.builder().put(EnableAllocationDecider.INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none"))
                                        for (ShardRouting replica : replicaRouting) {
    public void allowNodes(String index, int n) {
                TimeUnit.MILLISECONDS
            new NetworkDisruption.TwoPartitions(
    }
        final ArrayList<Class<? extends Plugin>> mocks = new ArrayList<>();
        }
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
            clusterManagerClusterState = ClusterState.Builder.fromBytes(masterClusterStateBytes, null, namedWriteableRegistry);
    }
    }
        Settings.Builder settings = Settings.builder()
        final String[] indicesArray = indices.toArray(new String[] {});
            case TEST:
import org.opensearch.index.translog.Translog;
            .putList(DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), "file")
        return clusterService.getSettings();
     */
                translogRepoType,
                    + stateResponse.getState()
     * This doesn't wait for inactive/non-started replica shards to become active/started.
     * Returns an instance of {@link RestClient} pointing to the current test cluster.
        Settings.Builder builder = Settings.builder();
            return annotation;
    /**
    }
    /**
    }
        for (String index : indices) {
     * rules based on <code>index.routing.allocation.exclude._name</code>.
        if (useRandomReplicationStrategy()) {
        return new NodeConfigurationSource() {
     * Returns path to a random directory that can be used to create a temporary file system repo
        InternalTestCluster internalTestCluster = internalCluster();
                .putNull(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey())
        } else {
        }
    private int getMinNumDataNodes() {
    public static final String TESTS_ENABLE_MOCK_MODULES = "tests.enable_mock_modules";
            settings.put(segmentRepoSettingsAttributeKeyPrefix + "compress", randomBoolean())
        RemoteStorePathStrategy.SnapshotShardPathInput shardPathInput = new RemoteStorePathStrategy.SnapshotShardPathInput.Builder()
        mocks.add(TestSeedPlugin.class);
    private boolean getSupportsDedicatedClusterManagers() {
     */
        for (CountDownLatch operation : inFlightAsyncOperations) {
    private ExternalTestCluster buildExternalCluster(String clusterAddresses, String clusterName) throws IOException {
import org.opensearch.core.rest.RestStatus;
    private ClusterHealthStatus ensureColor(
    }
    /**
                    if (TransportService.isValidActionName(action) == false) {
                        XContentHelper.convertToMap(parsedBytes, false, XContentType.SMILE).v2()
 */
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
                mocks.add(getTestTransportPlugin());
                                                }
 * Unless required by applicable law or agreed to in writing,
        if (indices.length == 0) {
        if (addMockTelemetryPlugin()) {
            }
        client().admin().indices().prepareUpdateSettings(index).setSettings(settings).get();
     * @return An exclude set of index templates that will not be removed in between tests.
    protected static NetworkDisruption isolateClusterManagerDisruption(NetworkDisruption.NetworkLinkDisruptionType disruptionType) {
                    loadedIndexMetadata = IndexMetadata.fromXContent(parser);
     */
    public void indexRandom(boolean forceRefresh, List<IndexRequestBuilder> builders) throws InterruptedException {
 * should be used. To configure a scope for the test cluster the {@link ClusterScope} annotation
     * Creates a new {@link CreateIndexRequestBuilder} with the settings obtained from {@link #indexSettings()}.
    }
    @TestGroup(enabled = false, sysProperty = OpenSearchIntegTestCase.SYSPROP_THIRDPARTY)
                    assertBusy(() -> {
     * layout.
    protected void randomIndexTemplate() {
        if (!bogusIds.isEmpty()) {
        return prepareCreate(index, numNodes, Settings.builder());
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
    /**
    }
    protected static Boolean segmentsPathFixedPrefix;
        );
        } else {
    public void assertResultsAndLogOnFailure(long expectedResults, SearchResponse searchResponse) {
            Metadata metadata = clusterManagerClient.admin().cluster().prepareState().all().get().getState().metadata();
                indexMetadata.toXContent(compareBuilder, compareFormatParams);
import org.opensearch.transport.TransportService;
        ClusterAdminClient adminClient,
import org.opensearch.common.settings.Setting;
        @NonNull String remoteStateRepoType,
            } else {
    }
        }
        Random random = random();
    /**
        builder.put("index.routing.allocation.exclude._name", exclude);
            for (Client client : cluster().getClients()) {
            .put(IndicesQueryCache.INDICES_QUERIES_CACHE_ALL_SEGMENTS_SETTING.getKey(), nodeOrdinal % 2 == 0)
                    try {
import org.opensearch.script.MockScriptService;
        if (dummyDocuments) {
            .setWaitForEvents(Priority.LANGUID)
        GetIndexResponse getIndexResponse = client().admin().indices().prepareGetIndex().setIndices(index).get();
     * It's set once per test via a generic index template.
    public final void createIndex(String name, Context context) {
     * ids or index segment creations. Some features might have bug when a given document is the first or the last in a
        Path remoteRoutingTableRepoPath
    /**
    /** Return the mock plugins the cluster should use */
    protected final IndexResponse index(String index, String type, String id, Object... source) {
        }
            indexRandomForMultipleSlices(indicesArray);
        public final int numPrimaries;
     * together with randomly chosen settings like number of nodes etc.
                .cluster()
            assertThat(actionGet.getStatus(), equalTo(status));
    /**
    }
        }
     * and https://github.com/elastic/elasticsearch/issues/66885
        return new NetworkDisruption(
            );
         * Returns the number of client nodes in the cluster. Default is {@link InternalTestCluster#DEFAULT_NUM_CLIENT_NODES}, a
        String segmentRepoType,
        setRandomIndexMergeSettings(random, builder);
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
    }
        ClusterHealthStatus clusterHealthStatus,
 * SPDX-License-Identifier: Apache-2.0
        String translogRepoType,
    /**
     */
                routingTableRepoName,
    }
        return indexService.getShard(id.get());
    ) {
    /**
     * more than <code>n</code> nodes.
 * public void testMethod() {}
 * determined at random and can change across tests. The {@link ClusterScope} allows configuring the initial number of nodes
            ? InternalTestCluster.DEFAULT_MIN_NUM_DATA_NODES
     * system without asserting modules that to make sure they don't hide any bugs in
        assertAcked(prepareCreate(name).setContext(context));
        );
        String nodeId = clusterState.getRoutingTable().index(indexName).shard(0).primaryShard().currentNodeId();
            client().admin().indices().prepareUpdateSettings(index).setSettings(build).execute().actionGet();
import static org.opensearch.indices.IndicesService.CLUSTER_REPLICATION_TYPE_SETTING;
    }
            URI uri = URI.create("http://" + stringAddress);
    }
     */
                RandomNumbers.randomIntBetween(random, 1, 15) + "ms"
            randomSettingsBuilder.put(SETTING_NUMBER_OF_SHARDS, numberOfShards()).put(SETTING_NUMBER_OF_REPLICAS, numberOfReplicas());
            viaNode = randomFrom(internalCluster().getNodeNames());
    /**
     */
        putRepository(clusterAdmin(), repoName, type, timeout, settings);
        flush(indices);
    public static InternalTestCluster internalCluster() {
        Property.IndexScope
                } catch (Exception e) { // count now acts like search and barfs if all shards failed...
        return annotation == null || annotation.maxNumDataNodes() == -1
            // inject some bogus docs
            client().admin().cluster().prepareState().get().getState(),
            ),
        String segmentRepoName,
        return ensureColor(ClusterHealthStatus.YELLOW, TimeValue.timeValueSeconds(30), false, indices);
                    }
    protected Collection<Class<? extends Plugin>> getMockPlugins() {
                ) {
                nodePrefix = TEST_CLUSTER_NODE_PREFIX;
        if (addMockTransportService()) {
         */
     * @param numDocs number of documents to wait for
        final String nodePrefix;
            buildRemoteStoreNodeAttributes(
    /** Sets or unsets the cluster read_only mode **/
            // cluster state where it is cluster-manager but where the node that was stopped hasn't been removed yet from the cluster state.
                                }
 * system properties are passed to the test execution environment.
    public static void beforeClass() throws Exception {
     * The scope of a test cluster used together with
        }
        /**
                    indexRequestBuilder.execute(
                    + nodeCount
import org.opensearch.cluster.metadata.Metadata;
    protected final IndexResponse index(String index, String type, String id, String source) {
import org.opensearch.common.collect.Tuple;
        } while (Files.exists(path));
    private int getNumDataNodes() {
    }
            builder.put(TelemetrySettings.TRACER_FEATURE_ENABLED_SETTING.getKey(), true);
     * */
        IndicesSegmentResponse segmentResponse = client().admin().indices().prepareSegments(indexName).execute().actionGet();
     */
                segmentRepoPath,
        if (triggerRemoteStateRestore()) {
            path = repoFiles[0].resolve(randomAlphaOfLength(10));
    private static CountDownLatch newLatch(List<CountDownLatch> latches) {
            logger.info(
            );
            for (SearchHit hit : searchResponse.getHits().getHits()) {
                    )
import java.util.Map;
    /**
        Path translogRepoPath,
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
        assertNoFailures(actionGet);
    protected final RefreshResponse refresh(String... indices) {
     * Indexes documents in bulk across the specified number of segments. Documents are evenly distributed
        String clusterAddresses = System.getProperty(TESTS_CLUSTER);
                        // a synced flush that can affect the size of the compressed byte array
import org.opensearch.index.remote.RemoteStoreEnums;
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
import org.opensearch.common.blobstore.BlobPath;
import org.opensearch.monitor.os.OsInfo;
                .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), true)
                                                IndexShard replicaShard = getIndexShard(replica, index);
            .setWaitForNoRelocatingShards(true)
    public final CreateIndexRequestBuilder prepareCreate(String index) {
import static org.hamcrest.Matchers.is;
        if (routingTableRepoName != null) {
    protected static RestClient getRestClient() {
import org.opensearch.action.admin.indices.flush.FlushResponse;
            externalClusterClientSettings(),
        String... indices
                if (lastKnownCount < numDocs) {
 * cluster scopes.
                        SmileXContent.smileXContent,
        );
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
 * tests against a JVM private OpenSearch Cluster. The test class supports 2 different
        if (random.nextBoolean()) {
                // match)
        if (forceRefresh) {
        String repoName,
            getNumClientNodes(),
import static org.hamcrest.Matchers.equalTo;
                    }
        String segmentRepoType,
            for (List<String> doc : bogusIds) {
            }
        logger.info("--> creating repository [{}] [{}]", repoName, type);
            }
    }
                        assertThat("Allocated on new node: " + name, Regex.simpleMatch(pattern, name), is(true));
     * </p>
    protected AdminClient admin() {
            assertAcked(putTemplate.execute().actionGet());
                        // Compare JSON serialization
            if (frequently()) {
                                                                                                                                    // don't
import java.util.concurrent.CountDownLatch;
                randomStorageType = randomBoolean() ? "REMOTE_STORE" : "LOCAL";
    @Override
    /**
    public @interface ClusterScope {
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
                .putNull(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey())
 * each test might use different directory implementation for each test or will return a random client to one of the
import java.util.ArrayList;
import java.util.stream.Collectors;
        return remoteStoreClusterSettings(name, path, name, path);
        String type,
import org.opensearch.action.DocWriteResponse;
     */
    protected static final String REMOTE_BACKED_STORAGE_REPOSITORY_NAME = "test-remote-store-repo";
     * Ensures the cluster has a red state via the cluster health API.
     */
    }
                        }
        }
    public void setDisruptionScheme(ServiceDisruptionScheme scheme) {
        return annotation == null ? InternalTestCluster.DEFAULT_NUM_CLIENT_NODES : annotation.numClientNodes();
            // so that the health check applies to the set of nodes we expect to be part of the cluster.
    private void postIndexAsyncActions(String[] indices, List<CountDownLatch> inFlightAsyncOperations, boolean maybeFlush)
        Settings.Builder settings = Settings.builder()
        if (clusterHealthResponse.isTimedOut()) {
        }
            // a node. If the node that is stopped is the cluster-manager node, another node will become cluster-manager and publish a
                tuple.v1().execute().actionGet(); // re-index if rejected
    protected void ensureStableCluster(int nodeCount, TimeValue timeValue) {
 *
            mocks.add(TestGeoShapeFieldMapperPlugin.class);
     * @param disruptionType type of disruption to create
import java.util.HashMap;
            clusterName,
    @Deprecated
        A annotation = clazz.getAnnotation(annotationClass);
    public ClusterHealthStatus waitForRelocation() {
            segmentRepoPath,
    }
    }
import org.opensearch.common.concurrent.GatedCloseable;
    }
    protected void createRepository(String repoName, String type, Settings.Builder settings) {
    private static final int MAX_IN_FLIGHT_ASYNC_INDEXES = 150;
        return clusterState.getRoutingNodes().node(nodeId).node().getName();
            segmentRepoName,
import org.opensearch.repositories.fs.ReloadableFsRepository;
            .setWaitForNodes(Integer.toString(nodeCount))
        return client().prepareIndex(index).setSource(source).execute().actionGet();
        Settings.Builder settingsBuilder = Settings.builder();
        return true;
        CountDownLatch l = new CountDownLatch(1);
            final String hotThreads = client().admin()
            int waitFor = between(0, inFlightAsyncOperations.size() - 1);
                .setIgnoreIdleThreads(false)
        internalCluster().ensureAtLeastNumDataNodes(n);
    }
 * ownership. Elasticsearch licenses this file to you under
            .prepareRefresh(indices)
     * Flushes and refreshes all indices in the cluster
            String clusterUUIDAfter = clusterService().state().metadata().clusterUUID();
    /**
     * @param dummyDocuments if {@code true} some empty dummy documents may be randomly inserted into the document list and deleted once
    private NodeConfigurationSource getNodeConfigSource() {
     */
        for (int seg = 0; seg < numSegments; seg++) {
            .put(SearchService.LOW_LEVEL_CANCELLATION_SETTING.getKey(), randomBoolean())
    }
     * <pre>
        return null;
                mocks.add(NodeMocksPlugin.class);
                segmentRepoType,
    }
            if (randomBoolean() && addMockIndexStorePlugin()) {
     * <pre>
     */
     */
                    String executor,
        assertThat(actualErrors, emptyIterable());
import org.opensearch.action.search.ClearScrollResponse;
        }
        }
        settings.put(BlobStoreRepository.SNAPSHOT_SHARD_PATH_PREFIX_SETTING.getKey(), snapshotShardPathFixedPrefix ? "c" : "");
     * Waits for all relocating shards to become active and the cluster has reached the given health status
        String repoName,
            assertFalse(clusterUUIDBefore.equals(clusterUUIDAfter));
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequestBuilder;
                final CopyOnWriteArrayList<Tuple<IndexRequestBuilder, Exception>> errors = new CopyOnWriteArrayList<>();
     */
    }
import com.carrotsearch.randomizedtesting.annotations.TestGroup;
                client().admin().cluster().preparePendingClusterTasks().get()
                "failed to reach a stable cluster of ["
        Settings settings;
     * method.
         */
    }
        ClusterAdminClient adminClient,
/**
                compareBuilder.endObject();
        if (numberOfReplicas >= 0) {
                for (ShardRouting shardRouting : indexShardRoutingTable) {
            for (Client client : clients()) {
    protected ClusterHealthStatus ensureSearchable(String... indices) {
        Collections.shuffle(builders, random());
import java.io.IOException;
                    assertThat(expectedIndexSort, equalTo(segment.getSegmentSort()));
        ClusterHealthRequest healthRequest = Requests.clusterHealthRequest(indices)
    @Retention(RetentionPolicy.RUNTIME)
            builder.setTimeout(timeout);
            if (randomReplicationType.equals(ReplicationType.SEGMENT) && randomStorageType.equals("REMOTE_STORE")) {
 * should be used, here is an example:
        Settings settings;
                if (clusterManagerClusterState.version() == localClusterState.version()
    }
     * layout.
        String segmentRepoTypeAttributeKey = String.format(
        waitForRelocation();
        assertNoTimeout(client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).get());
    static <A extends Annotation> A getAnnotation(Class<?> clazz, Class<A> annotationClass) {
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        );
                translogRepoName,
        String routingTableRepoType
    public static Client client(@Nullable String node) {
                    + "] nodes. Tried via ["
                break;
                .put(segmentRepoSettingsAttributeKeyPrefix + "chunk_size", 200, ByteSizeUnit.BYTES);
        }
    /**
 * Modifications Copyright OpenSearch Contributors. See
            InternalTestCluster.clusterName(scope.name(), seed) + "-cluster",
        /**
    private static final int MAX_BULK_INDEX_REQUEST_SIZE = 1000;
        return getAnnotation(clazz.getSuperclass(), annotationClass);
        return true;
            .put(translogRepoTypeAttributeKey, translogRepoType)
                        .get()
                }
        Settings.Builder settings,
    }
        public List<TransportInterceptor> getTransportInterceptors(
import org.hamcrest.Matchers;
                // Check that the non-cluster-manager node has the same version of the cluster state as the cluster-manager and
        settings.put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), randomFrom(PathType.values()));
    public void manageReplicaSettingForDefaultReplica(boolean apply) {
import org.opensearch.index.IndexModule;
    }
        return Settings.builder()
    public static final class TestSeedPlugin extends Plugin {
                }
        latches.add(l);
     * @see #indexRandom(boolean, boolean, java.util.List)
                for (IndexRequestBuilder indexRequestBuilder : builders) {
import java.util.Set;
            if (randomReplicationType.equals(ReplicationType.SEGMENT)) {
        boolean waitForNoInitializingShards,
    protected boolean triggerRemoteStateRestore() {
                .putNull(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey())
                for (IndexRequestBuilder indexRequestBuilder : segmented) {
            logger.info("using custom data_path for index: [{}]", dataPath);
                .indices()
import org.opensearch.core.index.Index;
        int minNumDataNodes() default -1;
            segmentRepoName,
     * <pre>
            return new NamedXContentRegistry(ClusterModule.getNamedXWriteables());
            .setMaxNumSegments(maxNumSegments)
     * These are tests the require a third-party service in order to run. They
            segmentRepoName,
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            if (Strings.isNullOrEmpty(clusterName)) {
            fail("timed out waiting for " + color + " state");
                builder.endObject();
     * Waits until at least a give number of document is visible for searchers
            settings.put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, routingTableRepoName)
        String type,
        boolean supportsDedicatedClusterManagers = getSupportsDedicatedClusterManagers();
        IndexService indexService = indicesService.indexServiceSafe(index);
        Path segmentRepoPath,
     * On Debian 8 the "memory" subsystem is not mounted by default
        TransportAddress[] transportAddresses = new TransportAddress[stringAddresses.length];
    }
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
 *
                compareBuilder.startObject();
                bogusIds.add(Arrays.asList(index, id));
import org.opensearch.search.SearchHit;
    public static Settings buildRemoteStoreNodeAttributes(
        if (randomBoolean()) {
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;
     */
        }
 * <p>
    public void indexBulkWithSegments(List<IndexRequestBuilder> builders, int numSegments) throws InterruptedException {
     * </pre>
        if (apply) {
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
        return client().admin();
            assertEquals(
    }
import org.opensearch.cluster.metadata.Context;
            if (rarely()) {
     */
        indexRandom(forceRefresh, forceRefresh, builders);
                        if (indexRoutingTable != null) {
    protected Settings.Builder setRandomIndexMergeSettings(Random random, Settings.Builder builder) {
                                    }
    protected RefreshResponse refreshAndWaitForReplication(String... indices) {
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "1b")
            String clusterManagerId = clusterManagerClusterState.nodes().getClusterManagerNodeId();
        String stateRepoTypeAttributeKey = String.format(
     * @param indexer a {@link BackgroundIndexer}. It will be first checked for documents indexed.
        String numSearchReplicasValue = metadata.index(index).getSettings().get(SETTING_NUMBER_OF_SEARCH_REPLICAS);
         * Returns the scope. {@link OpenSearchIntegTestCase.Scope#SUITE} is default.
        }
import org.opensearch.cluster.ClusterState;
        indexRandom(forceRefresh, dummyDocuments, Arrays.asList(builders));
        if (frequently()) {
    }
    private int getMaxNumDataNodes() {
                XContentBuilder builder = SmileXContent.contentBuilder();
            .put(remoteStateRepositorySettingsAttributeKeyPrefix + "location", randomRepoPath().toAbsolutePath())
    }
        return client().admin().indices().prepareCreate(index).setSettings(builder.build());
            );
    protected Function<Client, Client> getClientWrapper() {
                        actualErrors.add(tuple.v2());
    public Settings getNodeSettings() {
                .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), true)
            }
            translogRepoPath,
                throw new OpenSearchException("Scope not supported: " + scope);
     *
     * Waits for relocations and refreshes all indices in the cluster.
 * {@literal @}NodeScope(scope=Scope.SUITE, numDataNodes=3)
    protected void ensureStableCluster(int nodeCount) {
    public static void putRepository(
import org.junit.AfterClass;
        return Collections.emptySet();
                .putNull(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey())
    @Target(ElementType.TYPE)
            .get();
import org.apache.lucene.search.Sort;
 * <p>
                compareBuilder.endObject();
            .put("node.attr." + REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY, translogRepoName)
        boolean isRemoteStoreMigrationDirection = clusterSettings.get(MIGRATION_DIRECTION_SETTING)
                try {
     *
     */
    }
    protected Settings nodeSettings(int nodeOrdinal) {
    }
import org.opensearch.core.xcontent.XContentBuilder;
        String routingTableRepoName,
    public static void putRepository(ClusterAdminClient adminClient, String repoName, String type, Settings.Builder settings) {
    private class PayloadLatchedActionListener<Response, T> extends LatchedActionListener<Response> {
            routingTableRepoSettingsAttributeKeyPrefix = String.format(
            fail(failMsg);
     */
            this.totalNumShards = numPrimaries * dataCopies;
     */
            int from = seg * batchSize;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import org.opensearch.test.telemetry.MockTelemetryPlugin;
                return OpenSearchIntegTestCase.this.nodePlugins();
 * public class SomeIT extends OpenSearchIntegTestCase {
                        String name = clusterState.nodes().get(shardRouting.currentNodeId()).getName();
     * when cgroups are enabled, and this confuses many versions of
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
            );
            String clusterName = System.getProperty(TESTS_CLUSTER_NAME);
    }
    }
        }
            Locale.getDefault(),
            withRateLimiterAttributes
     */
            default:
     * handy to be able to ensure this happens faster
import static org.hamcrest.Matchers.startsWith;
 * <p>
    }
        }
    /**
                if (!success && !created.isEmpty()) {
    /** Disables an index block for the specified index */
import org.opensearch.action.admin.cluster.tasks.PendingClusterTasksResponse;
    }
        if (actionGet.isTimedOut()) {
    }
            client().admin().indices().prepareUpdateSettings(index).setSettings(settings).get();
        int numDataNodes() default -1;
        // TODO RANDOMIZE with flush?
    public static Iterable<Client> clients() {
    /**
     * production.
        String nodeId = clusterState.getRoutingTable().index(indexName).shard(0).replicaShards().get(0).currentNodeId();
    protected boolean isSegmentReplicationEnabledForIndex(String index) {
    ) {
                    .setIndicesOptions(IndicesOptions.lenientExpandOpen())
            settings = Settings.builder()
                    postIndexAsyncActions(indicesArray, inFlightAsyncOperations, maybeFlush);
    @BeforeClass
        String type,
        RefreshResponse actionGet = client().admin()
        return new ExternalTestCluster(
        featureSettings.put(FeatureFlags.TELEMETRY_SETTING.getKey(), true);
     * Ensures the cluster has a green state via the cluster health API. This method will also wait for relocations.
        int batchSize = builders.size() / numSegments;
     */
        // manually overridden by subclass if needed.
    protected ClusterState getClusterState() {
     */
     * Yet if the shards can't be allocated on any other node shards for this index will remain allocated on
import org.opensearch.transport.client.Client;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoTimeout;
     */
        return client().prepareIndex(index).setId(id).setSource(source, MediaTypeRegistry.JSON).execute().actionGet();
     */
     */
    /** Returns {@code true} iff this test cluster should use a dummy geo_shape field mapper */
            maxNumDataNodes,
import org.opensearch.common.network.NetworkModule;
import org.opensearch.repositories.IndexId;
        return builder;
     * Returns a function that allows to wrap / filter all clients that are exposed by the test cluster. This is useful
                    lastKnownCount = count;
 * If no {@link ClusterScope} annotation is present on an integration test the default scope is {@link Scope#SUITE}
     * @param numDocs number of documents to wait for
    }
                                                        getLatestSegmentInfoVersion(primaryShard),
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
            : Settings.builder().putNull(Metadata.SETTING_READ_ONLY_SETTING.getKey()).build();
            Locale.getDefault(),
                        + XContentHelper.convertToMap(parsedBytes, false, XContentType.SMILE),
            final Map<String, String> compareParams = new HashMap<>(2);
        /**
            Locale.getDefault(),
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateRequestBuilder;
                timeValueMillis(
     * Property that controls whether ThirdParty Integration tests are run (not the default).
            // If the ensureGreen/ensureYellow is timed just right, it will get to execute before the second cluster state update removes
        String remoteStateRepositorySettingsAttributeKeyPrefix = String.format(
import org.opensearch.plugins.NetworkPlugin;
            internalCluster().ensureAtLeastNumDataNodes(numNodes);
            // we do this in case somebody overrides getMockPlugins and misses to call super
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
     */
    }
     */
        }
    public void waitNoPendingTasksOnAll() throws Exception {
            } else {
        SUITE,
        ClusterHealthResponse actionGet = client().admin().cluster().health(request).actionGet();
            if (isInternalCluster()) {
        if (apply) {
     * segment or if only one document is in a segment etc. This method prevents issues like this by randomizing the index
        }
        String prefixModeVerificationSuffix = BlobStoreRepository.PREFIX_MODE_VERIFICATION_SETTING.getKey();
        for (IndexShardSegments indexShardSegments : indexSegments.getShards().values()) {
        return ensureColor(ClusterHealthStatus.GREEN, timeout, waitForNoRelocatingShards, false, indices);
        if (cluster() != null && cluster().size() > 0) {
                .build();
        return cluster().getClients();
 * KIND, either express or implied.  See the License for the
                                final ShardRouting primaryRouting = shardRoutingTable.primaryShard();
                    .collect(Collectors.toSet())
     * @see SuiteScopeTestCase
    protected void beforeIndexDeletion() throws Exception {
                ) {
     * Creates a new {@link CreateIndexRequestBuilder} with the settings obtained from {@link #indexSettings()}.
        return actionGet;
        ensureStableCluster(nodeCount, TimeValue.timeValueSeconds(30));
                }
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
    public static String resolvePath(IndexId indexId, String shardId) {
        return actionGet.isExists();
                randomSettingsBuilder.put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), randomBoolean());
        return annotation == null || annotation.minNumDataNodes() == -1
            disruptionType
                final BytesReference parsedBytes = BytesReference.bytes(builder);
            if (randomBoolean()) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
public abstract class OpenSearchIntegTestCase extends OpenSearchTestCase {
    }
                        );
     */
        // refresh is called to make sure the bogus docs doesn't affect the search results
            }
    private String randomStorageType;
            .waitForEvents(Priority.LANGUID)
        for (Setting builtInFlag : FeatureFlagSettings.BUILT_IN_FEATURE_FLAGS) {
        assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings).get());
import org.opensearch.test.store.MockFSIndexStore;
        return (isMixedMode && isRemoteStoreMigrationDirection);
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
        return client(internalCluster().getClusterManagerName()).admin().cluster().prepareState().get().getState();
                    differenceBetweenMapsIgnoringArrayOrder(
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "1b")
        ensureStableCluster(nodeCount, TimeValue.timeValueSeconds(30), false, viaNode);
import org.opensearch.env.Environment;
        String segmentRepoName,
import org.opensearch.ExceptionsHelper;
        }
                .putNull(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values")
    /**
            // randomly enable low-level search cancellation to make sure it does not alter results
     */
     * or may additionally require some external configuration (e.g. AWS credentials)
                                    if (isSegmentReplicationEnabledForIndex(index)) {
            }
            .anyMatch(ni -> ni.getInfo(OsInfo.class).getPrettyName().equals("Debian GNU/Linux 8 (jessie)"));
        putRepositoryRequestBuilder(adminClient, repoName, type, true, settings, null, false).execute(listener);
    }
        CodecService.DEFAULT_CODEC,
    }
    /**
 *  <pre>
                        OpenSearchNodeCommand.namedXContentRegistry,
            }
        String translogRepoName,
     *
 * Licensed to Elasticsearch under one or more contributor
        return actionGet;
        }
    /**
     * Returns <code>true</code> iff the given index exists otherwise <code>false</code>
                randomSettingsBuilder.put("index.codec", CodecService.LUCENE_DEFAULT_CODEC);
                        randomBoolean() ? 1000 : INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.get(Settings.EMPTY).millis()
         * tests must manage these things explicitly.
import org.opensearch.core.common.bytes.BytesReference;
     * using the cluster health API.
     * The default is {@code true}.
            });
    public void waitForDocs(final long numDocs, final BackgroundIndexer indexer) throws Exception {
     * This method uses allocation deciders to filter out certain nodes to allocate the created index on. It defines allocation
    @Deprecated
    }
     */
                method,
     * shard is available on the cluster.
     * Defines a cluster scope for a {@link OpenSearchIntegTestCase} subclass.
    /**
                RandomNumbers.randomIntBetween(random, 100, 5000),
     *                       all documents are indexed. This is useful to produce deleted documents on the server side.
     */
    /**
        builder.setSettings(settings);
        PayloadLatchedActionListener(T builder, CountDownLatch latch, CopyOnWriteArrayList<Tuple<T, Exception>> errors) {
import java.lang.annotation.Annotation;
    public CreateIndexRequestBuilder prepareCreate(String index, Settings.Builder settingsBuilder) {
            // assertion that UUID is changed post restore.
                // remove local node reference
            remoteRoutingTableRepoName,
     */
            // delete the bogus types again - it might trigger merges or at least holes in the segments and enforces deleted docs!
                actualErrors.add(tuple.v2());
        }
     *
        return true;
        return frequently() ? Math.min(1, maxNumReplicas) : maxNumReplicas;
            assertNoFailures(
        );
        Settings.Builder settingsBuilder = Settings.builder();
    }
            routingTableRepoName
        final NodeConfigurationSource nodeConfigurationSource = getNodeConfigSource();
        }
                    String id = "bogus_doc_" + randomRealisticUnicodeOfLength(between(1, 10)) + dummmyDocIdGenerator.incrementAndGet();
    protected void createRepository(String repoName, String type, Settings.Builder settings, String timeout) {
    }
                sb.append("\n-> _index: [").append(hit.getIndex()).append("] id [").append(hit.getId()).append("]");
     * @param builders       the documents to index.
    }
    }
            // It will only subsequently publish a second state where the old cluster-manager is removed.
     * Creates a new client if the method is invoked for the first time in the context of the current test scope.
        CodecService.LZ4,
    }
     *
            }
        }
    ) {
        String routingTableRepositoryTypeAttributeKey = String.format(
        @NonNull String routingTableRepoType
        final NodesInfoResponse response = client().admin().cluster().prepareNodesInfo().execute().actionGet();
import org.opensearch.core.index.shard.ShardId;
    }
    }
        Set<String> nodes = new HashSet<>();
        boolean autoManageMasterNodes() default true;
                return OpenSearchIntegTestCase.this.additionalNodePlugins();
        String color = clusterHealthStatus.name().toLowerCase(Locale.ROOT);
            }
            return Collections.singletonList(INDEX_TEST_SEED_SETTING);
                        + XContentHelper.convertToMap(compareOriginalBytes, false, XContentType.SMILE)
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        assertThat(metadata.hasIndex(index), equalTo(true));
        return true;
        @Override
    public static void disableIndexBlock(String index, String block) {
        @NonNull String remoteStateRepoName,
    }
        );
    }
     * @see OpenSearchIntegTestCase
            stateRepoName
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;
import java.util.Collection;
    public ClusterHealthStatus ensureGreen(TimeValue timeout, boolean waitForNoRelocatingShards, String... indices) {
     * multiple slices based on segment count.
        Metadata metadata = client().admin().cluster().prepareState().get().getState().metadata();
    public static final class AssertActionNamePlugin extends Plugin implements NetworkPlugin {
                builder.put(remoteStoreClusterSettings(REMOTE_BACKED_STORAGE_REPOSITORY_NAME, remoteStoreRepositoryPath));
    public ClusterHealthStatus ensureYellow(String... indices) {
        if (featureFlagSettings().getAsBoolean(FeatureFlags.TELEMETRY_SETTING.getKey(), false)) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            Locale.getDefault(),
import org.opensearch.action.admin.indices.get.GetIndexResponse;
            minNumDataNodes = maxNumDataNodes = numDataNodes;
        assertBusy(() -> {
                logger.info("Randomly using Replication Strategy as {} and Storage Type as {}.", randomReplicationType, randomStorageType);
                            localClusterState.stateUUID()
    protected String routingKeyForShard(String index, int shard) {
        int maxNumReplicas = Math.max(0, cluster().numDataNodes() - 1);
                        // We cannot compare serialization bytes since serialization order of maps is not guaranteed
    );
    /*
     * @param timeout time out value to set on {@link ClusterHealthRequest}
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
                XContentBuilder compareBuilder = SmileXContent.contentBuilder();
            public Path nodeConfigPath(int nodeOrdinal) {
        }
        logger.info("--> creating repository [{}] [{}]", repoName, type);
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, routingTableRepoName)
     * creates an index with the given setting
                ) {
        @Override
            builders = new ArrayList<>(builders);
     * Returns a random admin client. This client can be a node pointing to any of the nodes in the cluster.
import org.opensearch.indices.IndicesQueryCache;
            builder.put(IndexSettings.INDEX_CHECK_ON_STARTUP.getKey(), randomFrom(random, "false", "checksum", "true"));
            .build();
     * indexes them in a blocking or async fashion. This is very useful to catch problems that relate to internal document
        String translogRepoType
            }
     * Ensures the cluster is in a searchable state for the given indices. This means a searchable copy of each
     * Returns {@code true} if this test cluster should have tracing enabled with MockTelemetryPlugin
            .put(translogRepoSettingsAttributeKeyPrefix + "location", translogRepoPath)
    public static Settings remoteStoreClusterSettings(
     * segment or if only one document is in a segment etc. This method prevents issues like this by randomizing the index
     * Creates a disruption that isolates the current cluster-manager node from all other nodes in the cluster.
            String value = Long.toString(totalHits.value()) + (totalHits.relation() == TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO
        int numDataNodes = getNumDataNodes();
    @Rule
            .setTimeout(timeValue)
        }
     * <p>
    public ClusterService clusterService() {
        if (numDataNodes >= 0) {
     *                       all documents are indexed. This is useful to produce deleted documents on the server side.
            ThreadContext threadContext
        }
        boolean supportsDedicatedMasters() default true;
        return builder.build();
    public void manageReplicaBalanceSetting(boolean apply) {
     * See https://github.com/elastic/elasticsearch/issues/67089
        for (String name : names) {
            }
    }
     * across segments with a refresh between each batch to create segment boundaries. This is useful for
            null,
    }
        // if the cluster is internal the deprecation logger is shared across all nodes
        for (IndexRequestBuilder builder : builders) {
        Path translogRepoPath,
import org.opensearch.indices.replication.common.ReplicationType;
     * The index that is created with this builder will only be allowed to allocate on the number of nodes passed to this
 * license agreements. See the NOTICE file distributed with
            waitForReplication();
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
 *
                routingTableRepoType,
            .cluster()
                translogRepoPath,
    public void logClusterState() {
 */
            } else {
    public void assertSortedSegments(String indexName, Sort expectedIndexSort) {
     * </pre>
            lessThanOrEqualTo(clusterHealthStatus.value())
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, node);
        // TODO move settings for random directory etc here into the index based randomized settings.
        settingsBuilder.put(
 *
    public Settings indexSettings() {
            .stream()
    /**
     * being accurately determined will not work on such setups,
        return ensureGreen(TimeValue.timeValueSeconds(30), indices);
            .get();
        int refreshCount = randomIntBetween(2, 3);
import org.opensearch.action.admin.indices.segments.IndexSegments;
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
                String index = RandomPicks.randomFrom(random, indices);
        return testClusterRule.internalCluster()
            FsRepository.TYPE,
     * <pre>
     * @param indices         the indices in which bogus documents should be ingested
    public void indexRandom(boolean forceRefresh, boolean dummyDocuments, List<IndexRequestBuilder> builders) throws InterruptedException {
            super(latch);
                refresh(index);
            builder.put(SETTING_NUMBER_OF_SHARDS, numberOfShards).build();
    }
            .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, remoteStateRepoName)
            .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, stateRepoName)
     * it cannot be reused by other tests anymore.
        throws InterruptedException {
            minNumDataNodes = getMinNumDataNodes();
    }
                status,
     * Maybe refresh, force merge, or flush then always make sure there aren't too many in flight async operations.
     * tests that need multiple predefined segments for testing.
                UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(),
                BulkResponse actionGet = bulkBuilder.execute().actionGet();
            assertThat(lastKnownCount, greaterThanOrEqualTo(numDocs));
            .put(remoteStateRepositoryTypeAttributeKey, remoteStateRepoType)
        }
    protected boolean addMockTelemetryPlugin() {
    }
        return client;
        return testClusterRule.getRestClient();
        FlushResponse actionGet = client().admin().indices().prepareFlush(indices).execute().actionGet();
     */
    public static Index resolveIndex(String index) {
    }
    protected ForceMergeResponse forceMerge() {
import org.opensearch.common.settings.Settings;
        return internalCluster().clusterService();
     * Asserts that all segments are sorted with the provided {@link Sort}.
    }
                .stream()
     * <p>
                DocWriteResponse.Result.DELETED,
    protected boolean addMockInternalEngine() {
     * of the provided index.
    public static String resolveCustomDataPath(String index) {
        do {
            }
        }
        String remoteStateRepositoryTypeAttributeKey = String.format(
                        // no progress - try to refresh for the next time
        } else {
                    "cluster state XContent serialization does not match, expected "
    }
    protected static final int DEFAULT_MIN_NUM_SHARDS = 1;
     */
        logger.debug(
            indexRandom(true, false, false, builders.subList(from, to));
import org.opensearch.cluster.service.applicationtemplates.TestSystemTemplatesRepositoryPlugin;
        internalCluster().setDisruptionScheme(scheme);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
        @Override
        Path translogRepoPath
            // from failing on nodes without enough disk space
        // this is just a temporary thing but it's easier to change if it is encapsulated.
        }
    protected void setupSuiteScopeCluster() throws Exception {}
                // this is only used by mock plugins and if the cluster is not internal we just can't set it
                                                        "replica shards haven't caught up with primary",
                .put(routingTableRepoSettingsAttributeKeyPrefix + "location", routingTableRepoPath);
 * Note, the {@link OpenSearchIntegTestCase} uses randomized settings on a cluster and index level. For instance
                .prepareNodesHotThreads()
            );
            Settings settings = Settings.builder().put(block, true).build();
                        client().admin().indices().prepareRefresh().get();
            return null;
    /**
            mockPlugins = mocks;
            .actionGet();
     * @param builders   the documents to index
        String prefixModeVerificationSuffix = BlobStoreRepository.PREFIX_MODE_VERIFICATION_SETTING.getKey();
        }
        public final int numReplicas;
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
    private static Settings buildRemoteStoreNodeAttributes(
                    .filter(name -> name.equals(clusterManagerNode) == false)
    }
    ) {
    }
     */
     * Indexes the given {@link IndexRequestBuilder} instances randomly. It shuffles the given builders and either
     * Creates a new {@link CreateIndexRequestBuilder} with the settings obtained from {@link #indexSettings()}, augmented
            NamedWriteableRegistry namedWriteableRegistry,
                    logger.debug("failed to executed count", e);
     * Syntactic sugar for:
                routingTableRepoName
            }
        return path;
        Settings.Builder settingsBuilder = Settings.builder();
            sb.append(value).append("] results. expected [").append(expectedResults).append("]");
        return new NumShards(numShards, numReplicas, numSearchReplicas);
            }
        final long maxWaitTimeMs = Math.max(90 * 1000, 200 * numDocs);
        public final int totalNumShards;
                .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
            }
                            for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {
                try (
            final int unicodeLen = between(1, 10);
        switch (scope) {
import org.apache.lucene.tests.util.LuceneTestCase;
    }
        final Index index = resolveIndex(indexName);
                        );
            .prepareHealth()
        return builder.build();
                "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
     */
                addError(t);
    protected static Boolean snapshotShardPathFixedPrefix;
        }
        return settingsBuilder.build();
    protected IndexShard getIndexShard(String node, ShardId shardId, String indexName) {
            // the old cluster-manager and the condition ensureGreen / ensureYellow will trivially hold if it held before the node was
     */
                            "cluster state UUID does not match",
        String uuid = getIndexResponse.getSettings().get(index).get(IndexMetadata.SETTING_INDEX_UUID);
            remoteStateRepoName
import org.opensearch.common.regex.Regex;
    public void indexRandom(boolean forceRefresh, boolean dummyDocuments, IndexRequestBuilder... builders) throws InterruptedException {
        for (String stringAddress : stringAddresses) {
     * @param maybeFlush     if {@code true} this method may randomly execute full flushes after index operations.
     * In other words subclasses must ensure this method is idempotent.
import static org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm.FNV_1A_COMPOSITE_1;
                mocks.add(MockSearchService.TestPlugin.class);
        }
     * @see #waitForRelocation()
     *
        cluster().beforeIndexDeletion();
     * Default minimum number of shards for an index
                        + " but got "
     */
     *   once the documents are indexed. Additionally if {@code true} some
     * Refreshes the indices in the cluster and waits until active/started replica shards
                hotThreads
            } finally {
            }
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
        Set<List<String>> bogusIds = new HashSet<>(); // (index, type, id)
            throw new RuntimeException(e);
                            clusterManagerClusterState.toString(),
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;
        }
            getClientWrapper(),
 * <pre>
                Metadata metadataWithoutIndices = Metadata.builder(metadata).removeAllIndices().build();
            // If it's internal cluster - using existing registry in case plugin registered custom data
                assertThat(actionGet.hasFailures() ? actionGet.buildFailureMessage() : "", actionGet.hasFailures(), equalTo(false));
        // Randomly set a Replication Strategy and storage type for the node. Both Replication Strategy and Storage Type can still be
        boolean withRateLimiterAttributes
    }
import java.util.List;
    private int getNumClientNodes() {
     * </pre>
    }
                localClusterState = ClusterState.Builder.fromBytes(localClusterStateBytes, null, namedWriteableRegistry);
                "waitForRelocation timed out (status={}), cluster state:\n{}\n{}",
    public static final Setting<Long> INDEX_TEST_SEED_SETTING = Setting.longSetting(
    /**
            }
                        );
            builder.put(INDEX_DOC_ID_FUZZY_SET_ENABLED_SETTING.getKey(), true);
            indices.add(builder.request().index());
     */
                final BytesReference parsedBytes = BytesReference.bytes(builder);
    protected ClusterAdminClient clusterAdmin() {
    }
            final int numBogusDocs = scaledRandomIntBetween(1, builders.size() * 2);
        String remoteRoutingTableRepoName,
            internalCluster().resetCluster();
     */
                    if (t instanceof OpenSearchRejectedExecutionException) {
                        .setQuery(matchAllQuery())
        boolean withRateLimiterAttributes
                        + " but got "
        ensureFullyConnectedCluster();
        PathType pathType = PathType.fromCode(indexId.getShardPathType());
        mocks.add(MockScriptService.TestPlugin.class);
    protected boolean willSufferDebian8MemoryProblem() {
            builder.put(TelemetrySettings.TRACER_ENABLED_SETTING.getKey(), true);
        String segmentRepoName,
        int minNumDataNodes;
    }
    public static Settings remoteStoreClusterSettings(String name, Path path) {
                        originalBytes
                    long count = client().prepareSearch()
     */
            final ToXContent.Params serializationFormatParams = new ToXContent.MapParams(serializationParams);
    /**
        if (cluster() != null && cluster().size() > 0) {
                    && clusterManagerId.equals(localClusterState.nodes().getClusterManagerNodeId())) {
        String translogRepoName,
        setRandomIndexTranslogSettings(random, builder);
            ReloadableFsRepository.TYPE,
            initialNodeSettings.put(NetworkModule.TRANSPORT_TYPE_KEY, getTestTransportType());
        boolean verify,
