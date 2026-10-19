            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,  
                @Override
    }
        }  
        return refreshResponse;  
    public void indexRandom(boolean forceRefresh, boolean dummyDocuments, List<IndexRequestBuilder> builders) throws InterruptedException {  
    protected Function<Client, Client> getClientWrapper() {
        if (random.nextBoolean()) {
            if (frequently()) {
            // from failing on nodes without enough disk space  
            getNumClientNodes(),  
                            "Cluster state from cluster-manager:\n{}\nLocal cluster state:\n{}",  
        }  
                try (  
                        assertThat("Allocated on new node: " + name, Regex.simpleMatch(pattern, name), is(true));
        String type,
            InternalTestCluster.clusterName(scope.name(), seed) + "-cluster",
import org.opensearch.common.settings.ClusterSettings;
                if (!success && !created.isEmpty()) {
                    }
import org.opensearch.cluster.metadata.Metadata;  
        return ensureColor(ClusterHealthStatus.YELLOW, TimeValue.timeValueSeconds(30), false, indices);  
        int refreshCount = randomIntBetween(2, 3);
                final BytesReference compareOriginalBytes = BytesReference.bytes(compareBuilder);  
            String clusterUUIDBefore = clusterService().state().metadata().clusterUUID();  
    protected Set<String> excludeTemplates() {  
    public static Path randomRepoPath(Settings settings) {
    }
                    }
                        + XContentHelper.convertToMap(parsedBytes, false, XContentType.SMILE),
import org.opensearch.transport.TransportRequestHandler;
            try {  
            withRateLimiterAttributes
     * <pre>
    }  
     * @param disruptionType type of disruption to create
     */
    protected ForceMergeResponse forceMerge() {  
            // add both mock plugins - local and tcp if they are not there
    }  
            // If the ensureGreen/ensureYellow is timed just right, it will get to execute before the second cluster state update removes
     * <p>
                translogRepoPath,  
        }  
     * layout.  
    public void waitForIndexed(final long numDocs, final BackgroundIndexer indexer) throws Exception {
                    bogusIds.add(Arrays.asList(index, id));
                BulkRequestBuilder bulkBuilder = client().prepareBulk();  
        Settings.Builder settings,  
 * public void testMethod() {}  
     * Syntactic sugar for disabling allocation for <code>indices</code>  
            .get();
                return OpenSearchIntegTestCase.this.additionalNodePlugins();
        waitForReplication();
    protected final boolean enableWarningsCheck() {
                return OpenSearchIntegTestCase.this.nodePlugins();
            .execute()
        }
            .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, remoteStateRepoName)  
                "waitForRelocation timed out (status={}), cluster state:\n{}\n{}",  
                Collections.singleton(clusterManagerNode),  
    /**
import org.opensearch.common.settings.Setting;  
            mockPlugins,
    public ClusterHealthStatus ensureGreen(TimeValue timeout, String... indices) {  
    }  
                builders.add(client().prepareIndex().setIndex(index).setId(id).setSource("{}", MediaTypeRegistry.JSON).setRouting(id));
     */
     * <pre>  
    }  
 * </ul>
                        if (indexRoutingTable != null) {
        Set<List<String>> bogusIds = new HashSet<>(); // (index, type, id)  
     */  
import org.opensearch.plugins.NetworkPlugin;
    /**  
        }  
    protected NumShards getNumShards(String index) {  
    }
                logger.info("Index [{}] docs async: [{}] bulk: [{}]", builders.size(), true, false);  
                builder.startObject();
        IndexService indexService = indicesService.indexServiceSafe(index);
    protected final IndexResponse index(String index, String type, String id, XContentBuilder source) {  
        // 30% of the time
     * Annotation for third-party integration tests.  
        } else {
            final NamedWriteableRegistry namedWriteableRegistry = cluster().getNamedWriteableRegistry();
        for (String name : names) {  
                                    }
        }  
    private void postIndexAsyncActions(String[] indices, List<CountDownLatch> inFlightAsyncOperations, boolean maybeFlush)
        if (addMockTransportService()) {
            .put(segmentRepoSettingsAttributeKeyPrefix + prefixModeVerificationSuffix, prefixModeVerificationEnable)
            }
    }
            .put(segmentRepoSettingsAttributeKeyPrefix + "location", segmentRepoPath)  
                            for (IndexShardRoutingTable shardRoutingTable : indexRoutingTable) {  
     *  
 * compatible open source license.
                compareBuilder.startObject();  
        String remoteStateRepositoryTypeAttributeKey = String.format(
        return clusterState.getRoutingNodes().node(nodeId).node().getName();  
import org.opensearch.action.admin.cluster.tasks.PendingClusterTasksResponse;
                    .filter(name -> name.equals(clusterManagerNode) == false)
    public Settings indexSettings() {  
     * Some network disruptions may leave nodes that are not the cluster-manager disconnected from each other.  
        snapshotShardPathFixedPrefix = randomBoolean();  
    protected String routingKeyForShard(String index, int shard) {
 * If no {@link ClusterScope} annotation is present on an integration test the default scope is {@link Scope#SUITE}
import org.opensearch.client.RestClient;
     * Defines a cluster scope for a {@link OpenSearchIntegTestCase} subclass.
                assertThat("client " + client + " still has in flight fetch", clusterHealth.getNumberOfInFlightFetch(), equalTo(0));  
    public void clearScroll(String... scrollIds) {
        settingsBuilder.put(
        }
        @Override
            minNumDataNodes,
    }
        String translogRepoName,
        for (String stringAddress : stringAddresses) {
     *   client().prepareIndex(index, type).setSource(source).execute().actionGet();
            } else if (rarely()) {
                            "cluster state JSON serialization does not match",
    }
     */
                success = true;
        int numberOfShards = numberOfShards();
        if (apply) {
            builder.put(
            throw new RuntimeException(e);
import org.opensearch.core.common.unit.ByteSizeUnit;  
        }
        BlobPath blobPath = pathType.path(shardPathInput, pathHashAlgorithm);
            ? InternalTestCluster.DEFAULT_MAX_NUM_DATA_NODES
            final int unicodeLen = between(1, 10);
                .putNull(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey())
                builder.startObject();  
    }
                addError(t);
            builder.put(
                    randomLongBetween(
     * are formed. This is useful for testing with the concurrent search use-case as it creates
                    } else {
        String translogRepoName,
            byte[] masterClusterStateBytes = ClusterState.Builder.toBytes(clusterManagerClusterState);
        builder.put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), 0);
                // this is only used by mock plugins and if the cluster is not internal we just can't set it  
                    loadedMetadata = Metadata.fromXContent(parser);
            builder.put(
     * </p>
        return cluster().getClients();
     */
            .put(remoteStateRepositoryTypeAttributeKey, remoteStateRepoType)
        logger.debug("indices {} are {}", indices.length == 0 ? "[_all]" : indices, color);
                    if (count == lastKnownCount) {
        }
        final long maxWaitTimeMs = Math.max(90 * 1000, 200 * numDocs);
        String translogRepoName,  
        SUITE,
        FlushResponse actionGet = client().admin().indices().prepareFlush(indices).execute().actionGet();
     */  
            ArrayList<Class<? extends Plugin>> mocks = new ArrayList<>(mockPlugins);
    }
        Settings build = builder.build();
    protected Collection<Class<? extends Plugin>> getMockPlugins() {  
     */
import org.opensearch.cluster.health.ClusterHealthStatus;  
        }
                                                        getLatestSegmentInfoVersion(replicaShard)
            String clusterUUIDAfter = clusterService().state().metadata().clusterUUID();
                    String executor,
            }
         * Returns the number of client nodes in the cluster. Default is {@link InternalTestCluster#DEFAULT_NUM_CLIENT_NODES}, a
    }
                loadedIndexMetadata.toXContent(builder, compareFormatParams);
        String routingTableRepoType  
    }  
        if (isInternalCluster() && cluster().size() > 0) {
                Locale.getDefault(),
    protected NamedXContentRegistry xContentRegistry() {  
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
        testClusterRule.beforeClass();
        if (withRateLimiterAttributes) {
            // we do this in case somebody overrides getMockPlugins and misses to call super  
    public static Settings buildRemoteStoreNodeAttributes(  
        internalCluster().ensureAtLeastNumDataNodes(n);
        return featureSettings.build();
     * segment or if only one document is in a segment etc. This method prevents issues like this by randomizing the index
        return annotation == null || annotation.maxNumDataNodes() == -1  
     * @param indices         the indices in which bogus documents should be ingested  
            int from = seg * batchSize;
        final String[] indicesArray = indices.toArray(new String[] {});  
            if (randomBoolean()) {  
    @BeforeClass
    protected int maximumNumberOfShards() {  
            .get();
            internalCluster().resetCluster();
import org.opensearch.ExceptionsHelper;
            forbidPrivateIndexSettings()
        String type,
 * The most common test scope is {@link Scope#SUITE} which shares a cluster per test suite.
    /**
        }  
                );
        assertAcked(putRepositoryRequestBuilder(adminClient, repoName, type, verify, settings, null, false));
    }  
    /**  
        client().admin()
        Path remoteRoutingTableRepoPath
import org.opensearch.indices.IndicesRequestCache;  
                        .value();  
    /**  
     * method.  
                new ByteSizeValue(RandomNumbers.randomIntBetween(random, 1, 300), ByteSizeUnit.MB)
            .shardId(shardId)
                .getNodes()
            .put(translogRepoTypeAttributeKey, translogRepoType)  
                        originalBytes
                .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), true)  
     */
        assertAcked(prepareCreate(name).setSettings(indexSettings).setMapping(mapping));
        switch (scope) {
            // delete the bogus types again - it might trigger merges or at least holes in the segments and enforces deleted docs!
        if (routingTableRepoName != null) {
        int minNumDataNodes() default -1;  
        String segmentRepoTypeAttributeKey = String.format(  
            while (refreshCount-- > 0) {
            );  
            .put(segmentRepoTypeAttributeKey, segmentRepoType)
    protected IndexShard getIndexShard(String node, ShardId shardId, String indexName) {
            }
                                                                                                                                    // flush
    private class LatchedActionListener<Response> implements ActionListener<Response> {
    protected Settings featureFlagSettings() {
    }  
import java.lang.Runtime.Version;
            }
import java.util.Locale;
import org.opensearch.core.rest.RestStatus;
            } else {
     * </pre>  
            maxNumDataNodes,  
    }
    }
import org.opensearch.cluster.ClusterModule;  
        String prefixModeVerificationSuffix = BlobStoreRepository.PREFIX_MODE_VERIFICATION_SETTING.getKey();
import java.lang.annotation.Inherited;
            .cluster()
    }
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        prefixModeVerificationEnable = randomBoolean();  
                            }
        return testClusterRule.internalCluster()
        Settings.Builder settingsBuilder = Settings.builder();
import org.opensearch.common.collect.Tuple;  
        Set<List<String>> bogusIds = new HashSet<>();  
    protected static Boolean translogPathFixedPrefix;
     * framework. By default this method returns an identity function {@link Function#identity()}.
            fail(
        return buildRemoteStoreNodeAttributes(
        // Enable tracer only when Telemetry Setting is enabled
                metadataWithoutIndices.toXContent(compareBuilder, compareFormatParams);
import org.junit.BeforeClass;  
            randomSettingsBuilder.put(SETTING_NUMBER_OF_SHARDS, numberOfShards()).put(SETTING_NUMBER_OF_REPLICAS, numberOfReplicas());
        ClusterScope annotation = getAnnotation(this.getClass(), ClusterScope.class);
        final Settings featureFlagSettings = featureFlagSettings();  
    }
import static org.opensearch.index.IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING;
    }
import java.net.InetSocketAddress;  
        private NumShards(int numPrimaries, int numReplicas, int numSearchReplicas) {
import org.opensearch.cluster.routing.ShardRoutingState;
        Collection<Class<? extends Plugin>> mockPlugins = getMockPlugins();
        String repoName,
            NamedWriteableRegistry namedWriteableRegistry,  
        if (indices.length == 0) {
import org.opensearch.common.Nullable;  
import java.util.concurrent.TimeUnit;  
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,  
                        .getHits()
     * For tests with remote store enabled domain, it will be overridden to true.
    }
            if (randomReplicationType.equals(ReplicationType.SEGMENT)) {  
            )
     */
import org.opensearch.transport.TransportService;
            StringBuilder sb = new StringBuilder("search result contains [");
     */  
        ClearScrollResponse clearResponse = client().prepareClearScroll().setScrollIds(Arrays.asList(scrollIds)).get();  
            }
                    .indices()
import org.opensearch.action.admin.indices.segments.ShardSegments;  
import org.opensearch.action.bulk.BulkResponse;  
    private int getNumClientNodes() {
    }
     * See https://github.com/elastic/elasticsearch/issues/67089  
     * A boolean value to enable or disable mock modules. This is useful to test the  
    }
        if (forceRefresh) {
    public static final class TestSeedPlugin extends Plugin {
     * for the given indices  
         * are either the specified ones or the default ones if not specified.
import java.nio.file.Files;
    /**
import org.opensearch.action.support.IndicesOptions;
        if (cluster() != null && cluster().size() > 0) { // if static init fails the cluster can be null  
     * Ensures the cluster has a green state via the cluster health API. This method will also wait for relocations.  
    }
import org.opensearch.test.disruption.NetworkDisruption;  
         * Returns the number of nodes in the cluster. Default is {@code -1} which means
    /**  
        boolean verify,
            clusterName,
     * Creates a disruption that isolates the current cluster-manager node from all other nodes in the cluster.  
    /**
import org.opensearch.cluster.coordination.OpenSearchNodeCommand;
     * </pre>  
        return Settings.builder()
                if (lastKnownCount < numDocs) {
        return prepareCreate(index, -1, settingsBuilder);  
        boolean supportsDedicatedClusterManagers = getSupportsDedicatedClusterManagers();  
        return ensureColor(ClusterHealthStatus.YELLOW, TimeValue.timeValueSeconds(30), true, indices);  
    }
        );
                    .execute(new LatchedActionListener<>(newLatch(inFlightAsyncOperations)));
     * rules based on <code>index.routing.allocation.exclude._name</code>.  
        protected void addError(Exception e) {
     * Represent if it needs to trigger remote state restore or not.  
     */  
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
                    client().prepareDelete(doc.get(0), doc.get(1)).setRouting(doc.get(1)).get().getResult()  
        }
            randomSettingsBuilder.put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), 0);
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
            indexRandom(true, false, false, builders.subList(from, to));
import org.opensearch.action.admin.indices.flush.FlushResponse;
                        new PayloadLatchedActionListener<>(indexRequestBuilder, newLatch(inFlightAsyncOperations), errors)  
        return new InternalTestCluster(  
     * Property that controls whether ThirdParty Integration tests are run (not the default).
    public static OpenSearchTestClusterRule testClusterRule = new OpenSearchTestClusterRule();
    }
                    .prepareForceMerge(indices)
            );
                assertThat("client " + client + " still has in flight fetch", clusterHealth.getNumberOfInFlightFetch(), equalTo(0));
     * The override to fetch the {@link CompletionFieldMapper.CompletionFieldType} postings format is not available for this codec.
     * and https://github.com/elastic/elasticsearch/issues/66885
        assertAcked(prepareCreate(name).setContext(context));
     * @param builders       the documents to index.  
     *   list and deleted once all documents are indexed. This is useful to  
        testClusterRule.afterClass();  
        // always default delayed allocation to 0 to make sure we have tests are not delayed
                                        }
        return settings.build();
    }  
            "cluster state:\n{}\n{}",
        } catch (Exception e) {  
        Settings settings;
    ) {
     * indexes them in a blocking or async fashion. This is very useful to catch problems that relate to internal document
import org.opensearch.common.network.NetworkModule;
            .indices()
        }
        ensureStableCluster(nodeCount, TimeValue.timeValueSeconds(30), false, viaNode);
        }
        final Optional<Integer> id = indexService.shardIds().stream().filter(sid -> sid.equals(shardId.id())).findFirst();
import java.util.HashMap;
     * Ensures the cluster has a red state via the cluster health API.
                    .indices()
    }
                        String name = clusterState.nodes().get(shardRouting.currentNodeId()).getName();
        Path routingTableRepoPath,
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;  
        String... indices
        }
        /**
public abstract class OpenSearchIntegTestCase extends OpenSearchTestCase {
                    }, 30, TimeUnit.SECONDS);  
    public void waitNoPendingTasksOnAll() throws Exception {
     * Returns <code>true</code> iff the given index exists otherwise <code>false</code>
     * Indexes the given {@link IndexRequestBuilder} instances randomly. It shuffles the given builders and either
            errors.add(new Tuple<>(builder, e));  
        ClusterAdminClient adminClient,
        }, maxWaitTimeMs, TimeUnit.MILLISECONDS);
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
        indexRandom(forceRefresh, Arrays.asList(builders));
    @Deprecated
            ReloadableFsRepository.TYPE,
        if (frequently()) {
            if (Strings.isNullOrEmpty(clusterName)) {  
    }
                        XContentHelper.convertToMap(compareOriginalBytes, false, XContentType.SMILE).v2(),  
                            "cluster state UUID does not match",
        if (routingTableRepoName != null) {  
    /**  
import org.opensearch.transport.client.Client;
        boolean java15Plus = Runtime.version().compareTo(Version.parse("15")) >= 0;
     */  
                }  
     * Convenience method that forwards to {@link #indexRandom(boolean, List)}.
 * Modifications Copyright OpenSearch Contributors. See
                                    if (isSegmentReplicationEnabledForIndex(index)) {  
        PayloadLatchedActionListener(T builder, CountDownLatch latch, CopyOnWriteArrayList<Tuple<T, Exception>> errors) {
                translogRepoName,
     * Refreshes the indices in the cluster and waits until active/started replica shards
import org.opensearch.common.settings.Setting.Property;
                    XContentParser parser = createParser(
    public final void createIndex(String name, Settings indexSettings) {
                randomSettingsBuilder.put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), randomBoolean());  
    /**
        String translogRepoName,
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();  
            .put(featureFlagSettings());
                }
        assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings).get());
                );
        return null;
            FsRepository.TYPE,  
     * ids or index segment creations. Some features might have bug when a given document is the first or the last in a
        putRepository(clusterAdmin(), repoName, type, timeout, settings);
import java.util.concurrent.CountDownLatch;
    /**  
    /**
     */
        setRandomIndexMergeSettings(random, builder);
    }
                        );
     * Indexes the given {@link IndexRequestBuilder} instances randomly. It shuffles the given builders and either
        @NonNull String remoteStateRepoType,
        assertThat(
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import java.util.Set;  
        }
     *  
            remoteRoutingTableRepoPath,
            }
    public static Settings remoteStoreClusterSettings(
            assertThat("unexpected flush failure " + failure.reason(), failure.status(), equalTo(RestStatus.SERVICE_UNAVAILABLE));
            Settings.Builder randomSettingsBuilder = setRandomIndexSettings(random(), Settings.builder());
                    loadedIndexMetadata = IndexMetadata.fromXContent(parser);  
            ThreadContext threadContext
        } while (Files.exists(path));
    /**
            }
    /**  
                    indexRequestBuilder.execute(
import org.opensearch.index.IndexModule;
        Settings.Builder settings,
            builder.put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), random.nextBoolean());
    public static Index resolveIndex(String index) {
                ).getStringRep()
    protected final IndexResponse index(String index, String type, XContentBuilder source) {  
                                            } else if (replica.state() == ShardRoutingState.INITIALIZING) {
    protected void indexRandomForMultipleSlices(String... indices) throws InterruptedException {
                        .setSize(0)
    protected ClusterHealthStatus ensureSearchable(String... indices) {
        ClusterScope annotation = getAnnotation(this.getClass(), ClusterScope.class);
            translogRepoName,
        return settings.build();
            mocks.add(TestGeoShapeFieldMapperPlugin.class);
        /**
     */  
import static org.hamcrest.Matchers.emptyIterable;  
        settings.put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_METADATA.getKey(), randomBoolean());  
import org.apache.lucene.codecs.Codec;
                .putNull(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey())
    protected boolean willSufferDebian8MemoryProblem() {  
        return remoteStoreClusterSettings(name, path, name, path);
        }
        String translogRepoName,  
import org.opensearch.common.xcontent.XContentHelper;  
 * public void testMethod() {}  
        return l;
    protected final void disableAllocation(String... indices) {
                translogRepoType,
                    + "]. last cluster state:\n"
     */  
        return new Index(index, uuid);  
            super(latch);
            builder.put(Store.FORCE_RAM_TERM_DICT.getKey(), true);  
    }
            transportAddresses[i++] = new TransportAddress(new InetSocketAddress(inetAddress, uri.getPort()));
            this.builder = builder;
                .put(
    protected void ensureClusterStateConsistency() throws IOException {  
                IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.getKey(),  
    }
    }
     * segment or if only one document is in a segment etc. This method prevents issues like this by randomizing the index
        if (addMockHttpTransport()) {
        if (numberOfShards > 0) {  
    }
                .put(routingTableRepoSettingsAttributeKeyPrefix + "location", routingTableRepoPath);
    /** node names of the corresponding clusters will start with these prefixes */
                                                if (replicaShard.indexSettings().isSegRepEnabledOrRemoteNode()) {  
            remoteRoutingTableRepoName,
                final BytesReference originalBytes = BytesReference.bytes(builder);  
    protected void ensureStableCluster(int nodeCount, TimeValue timeValue) {
     * {@link OpenSearchIntegTestCase.ClusterScope} annotations on {@link OpenSearchIntegTestCase} subclasses.
        );
     *   produce deleted documents on the server side.
    private int getNumDataNodes() {
        );  
        final CopyOnWriteArrayList<Tuple<IndexRequestBuilder, Exception>> errors = new CopyOnWriteArrayList<>();  
        return true;
     * @param forceRefresh   if {@code true} all involved indices are refreshed once the documents are indexed.
    public static final String TESTS_ENABLE_MOCK_MODULES = "tests.enable_mock_modules";  
            int waitFor = between(0, inFlightAsyncOperations.size() - 1);
                .setOrder(0)  
            Settings settings = Settings.builder().put(block, true).build();
import org.opensearch.index.remote.RemoteStoreEnums;
        CodecService.ZLIB
        );
import java.util.concurrent.CopyOnWriteArrayList;
        PutRepositoryRequestBuilder builder = adminClient.preparePutRepository(repoName).setType(type).setVerify(verify);
    @Override
    /**
        assertNoTimeout(client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).get());
        }  
            builders = new ArrayList<>(builders);
                nodePrefix = SUITE_CLUSTER_NODE_PREFIX;  
import java.util.stream.Collectors;  
    protected boolean addMockGeoShapeFieldMapper() {
                throw new IllegalArgumentException("Cannot run TEST scope test with " + TESTS_CLUSTER);  
        mocks.add(TestSeedPlugin.class);
     * Waits until active/started replica shards are caught up with primary shard only when Segment Replication is enabled.
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
                    assertThat(expectedIndexSort, equalTo(segment.getSegmentSort()));  
            );  
        // TODO RANDOMIZE with flush?
        if (apply) {
     */  
                    )
                    )
            .stream()  
            logger.info("using custom data_path for index: [{}]", dataPath);
            // wait short time for other active shards before actually deleting, default 30s not needed in tests
    /**  
        assertAcked(prepareCreate(name).setSettings(indexSettings));  
            .equals(RemoteStoreNodeService.Direction.REMOTE_STORE);
            }
            .put(stateRepoSettingsAttributeKeyPrefix + prefixModeVerificationSuffix, prefixModeVerificationEnable);  
            @Override
            .execute()
 *  <pre>  
        Path path;
    public void waitForDocs(final long numDocs, final BackgroundIndexer indexer) throws Exception {
    protected boolean isSegmentReplicationEnabledForIndex(String index) {
            .prepareHealth()
    /**  
    /**  
            assertNoFailures(
            for (Client client : cluster().getClients()) {
    }
                XContentBuilder builder = SmileXContent.contentBuilder();
        } else {
    protected static boolean indexExists(String index) {
        return testClusterRule.cluster();  
        }
        }
            }
        Long.MIN_VALUE,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    if (t instanceof OpenSearchRejectedExecutionException) {
        };  
     */
    protected String replicaNodeName(String indexName) {  
     * of this class are executed. This also has the side-effect of a suite level setup method {@link #setupSuiteScopeCluster()}
                mocks.add(MockTransportService.TestPlugin.class);
         */  
        @Override
     * system without asserting modules that to make sure they don't hide any bugs in
                timeValueMillis(  
            }
    public final void createIndex(String... names) {  
import org.opensearch.cluster.metadata.Context;
    }  
        }
            createTempDir(),
 * that are created before the tests start.
            .timeout(timeout)
import org.opensearch.test.telemetry.MockTelemetryPlugin;  
                                                                                                                                    // don't  
     * Returns a random cluster admin client. This client can be pointing to any of the nodes in the cluster.  
                        SmileXContent.smileXContent,  
     * production.
 * cluster scopes.
import org.opensearch.core.xcontent.XContentParser;
            segmentRepoPath,  
                }
        if (addMockTransportService()) {
        final String clusterManagerNode = internalCluster().getClusterManagerName();  
            translogRepoType,
                client().prepareDelete(doc.get(0), doc.get(1)).setRouting(doc.get(1)).get().getResult()
     * @param forceRefresh   if {@code true} all involved indices are refreshed once the documents are indexed.
                final CopyOnWriteArrayList<Tuple<IndexRequestBuilder, Exception>> errors = new CopyOnWriteArrayList<>();
        ActionListener<AcknowledgedResponse> listener
     * By default if no {@link ClusterScope} annotation is present {@link OpenSearchIntegTestCase.Scope#SUITE} is used
         * A test exclusive test cluster
     * Creates a new {@link CreateIndexRequestBuilder} with the settings obtained from {@link #indexSettings()}, augmented
            clusterManagerClusterState = ClusterState.Builder.fromBytes(masterClusterStateBytes, null, namedWriteableRegistry);
    }
        ClusterAdminClient adminClient,
 * This class supports the following system properties (passed with -Dkey=value to the application)  
    /**
            final ToXContent.Params serializationFormatParams = new ToXContent.MapParams(serializationParams);
            // cluster state where it is cluster-manager but where the node that was stopped hasn't been removed yet from the cluster state.  
        return internalCluster().clusterService();  
import org.opensearch.node.NodeMocksPlugin;  
        /**
        Path segmentRepoPath,
            .setSettings(Settings.builder().put(EnableAllocationDecider.INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "all"))
        String segmentRepoName,
            }
import org.opensearch.common.settings.FeatureFlagSettings;
            default:
    @Target(ElementType.TYPE)  
            .indices()
     *  
         * Indicates whether the cluster automatically manages cluster bootstrapping. If set to {@code false} then the
    }
        assertThat(actualErrors, emptyIterable());
                        logger.debug("Error indexing doc: " + t.getMessage() + ", reindexing.");
     * where source is a JSON String.  
     * Nodes in this cluster are associated with an ordinal number such that nodes can  
        /**  
 * this file be licensed under the Apache-2.0 license or a
     */
                INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.getKey(),
                    .setMaxNumSegments(between(1, 10))
        int numDataNodes() default -1;  
    /**
        mocks.add(TestSystemTemplatesRepositoryPlugin.class);
    @Rule
     * This method can be overwritten by subclasses to set defaults for the indices that are created by the test.
            settings.put(segmentRepoSettingsAttributeKeyPrefix + "compress", randomBoolean())
    /**
        int numReplicas = Integer.valueOf(metadata.index(index).getSettings().get(SETTING_NUMBER_OF_REPLICAS));
     * Iff this returns true mock transport implementations are used for the test runs. Otherwise not mock transport impls are used.
import org.opensearch.core.common.unit.ByteSizeValue;
    protected int minimumNumberOfReplicas() {
     *
 * <li>{@link Scope#SUITE} - uses a cluster shared across all test methods in the same suite</li>
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, node);  
    }
    /**
        );  
            assertFalse(clusterUUIDBefore.equals(clusterUUIDAfter));
                // Check that the non-cluster-manager node has the same version of the cluster state as the cluster-manager and  
    public void indexRandom(boolean forceRefresh, boolean dummyDocuments, IndexRequestBuilder... builders) throws InterruptedException {
        @Override
 * KIND, either express or implied.  See the License for the
/**
        return builder;  
        }
        return path;  
    /**  
        ClusterService clusterService = internalTestCluster.getInstance(ClusterService.class, internalTestCluster.getClusterManagerName());
     */
     * or may additionally require some external configuration (e.g. AWS credentials)
    public Path randomRepoPath() {
            .map(c -> randomRepoPath(c.getDefaultSettings()))  
import java.util.Optional;
                final BytesReference parsedBytes = BytesReference.bytes(builder);  
import java.util.Map;  
                        tuple.v1().execute().actionGet(); // re-index if rejected  
        InternalTestCluster internalTestCluster = internalCluster();  
        // use either 0 or 1 replica, yet a higher amount when possible, but only rarely
            public Collection<PluginInfo> additionalNodePlugins() {  
        /**
            translogRepoPath,
        String translogRepoType,  
            builder.put(
        return buildRemoteStoreNodeAttributes(
        settings.put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), randomBoolean());
    }
            new NetworkDisruption.TwoPartitions(
    @Inherited  
    protected final RefreshResponse refresh(String... indices) {  
        boolean autoManageMasterNodes() default true;
                }
                nodePrefix = TEST_CLUSTER_NODE_PREFIX;  
        if (actionGet.isTimedOut()) {  
            .setMaxNumSegments(maxNumSegments)  
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
        String translogRepoName,
        return actionGet;
        assertBusy(() -> {  
        ClusterHealthStatus clusterHealthStatus,
    public static void putRepositoryWithNoSettingOverrides(
    }
                )
        Path translogRepoPath,
            .put(remoteStateRepositorySettingsAttributeKeyPrefix + "location", randomRepoPath().toAbsolutePath())
        List<String> created = new ArrayList<>();
                        XContentHelper.convertToMap(parsedBytes, false, XContentType.SMILE).v2()
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
         * Returns the minimum number of data nodes in the cluster. Default is {@code -1}.  
        if (numNodes > 0) {  
    public static final String TESTS_CLUSTER = "tests.cluster";  
        TimeValue timeout,
        String translogRepoType,  
        waitForRelocation();
                List<CountDownLatch> inFlightAsyncOperations = new ArrayList<>();  
    protected final void enableAllocation(String... indices) {  
     * */
    }  
            final Map<String, String> compareParams = new HashMap<>(2);
     */
        return internalCluster().routingKeyForShard(resolveIndex(index), shard, random());
    }
        ClusterHealthResponse actionGet = client().admin().cluster().health(healthRequest).actionGet();
         */
            .setSettings(Settings.builder().put(EnableAllocationDecider.INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none"))  
                        new PayloadLatchedActionListener<>(indexRequestBuilder, newLatch(inFlightAsyncOperations), errors)  
                builders,
     * rules based on <code>index.routing.allocation.exclude._name</code>.  
    protected int numberOfReplicas() {  
                metadataWithoutIndices.toXContent(builder, serializationFormatParams);
            // Default the watermarks to absurdly low to prevent the tests
            indices.add(builder.request().index());
        assertAcked(putRepositoryRequestBuilder(adminClient, repoName, type, true, settings, timeout, false));
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
            if (randomBoolean() && addMockIndexStorePlugin()) {  
                    .setIndicesOptions(IndicesOptions.lenientExpandOpen())  
            builder.put(
 * this work for additional information regarding copyright
     * tests that need multiple predefined segments for testing.
    }  
    }
                // We configure a routing key in case the mapping requires it
                // remove local node reference
        final long maxWaitTimeMs = Math.max(90 * 1000, 200 * numDocs);
            // by default we never cache below 10k docs in a segment,
            throw new RuntimeException(e);
 * {@link OpenSearchIntegTestCase} is an abstract base class to run integration
 * <li>{@link Scope#TEST} - uses a new cluster for each individual test method.</li>  
                final Metadata loadedMetadata;
    }
     * Checks if Segment Replication is enabled on Index.  
        List<CountDownLatch> inFlightAsyncOperations = new ArrayList<>();
                } catch (Exception e) { // count now acts like search and barfs if all shards failed...
        boolean withRateLimiterAttributes
        }  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
    /**
        if (clusterHealthResponse.isTimedOut()) {  
                    assertTrue("Unable to wait for replication with external test cluster", isInternalCluster());
            Locale.getDefault(),
            nodeConfigurationSource,
            .put(IndicesStore.INDICES_STORE_DELETE_SHARD_TIMEOUT.getKey(), new TimeValue(1, TimeUnit.SECONDS))  
        assertAcked(putRepositoryRequestBuilder(adminClient, repoName, type, true, settings, null, false));  
    }
    /** Returns {@code true} iff this test cluster should use a dummy http transport */  
     * Waits until all nodes have no pending tasks.
    );  
import org.opensearch.indices.IndicesQueryCache;
            )  
        LatchedActionListener(CountDownLatch latch) {
        String clusterAddresses = System.getProperty(TESTS_CLUSTER);  
                final List<Exception> actualErrors = new ArrayList<>();
            if (logger.isDebugEnabled()) {
    }
    private static final boolean MOCK_MODULES_ENABLED = "true".equals(System.getProperty(TESTS_ENABLE_MOCK_MODULES, "true"));
     */
    ) {
    public ClusterService clusterService() {
    private ReplicationType randomReplicationType;  
     * be started with specific configurations. This method might be called multiple
    }
            case TEST:
import java.lang.annotation.Annotation;
import org.opensearch.transport.TransportRequest;  
     * The index that is created with this builder will only be allowed to allocate on the number of nodes passed to this
import org.opensearch.indices.RemoteStoreSettings;
 * <ul>
                    indexRequestBuilder.execute().actionGet();
        assertAcked(putRepositoryRequestBuilder(adminClient, repoName, type, verify, settings, null, true));  
    private final AtomicInteger dummmyDocIdGenerator = new AtomicInteger();
         * Returns the maximum number of data nodes in the cluster.  Default is {@code -1}.  
        if (featureFlagSettings().getAsBoolean(FeatureFlags.TELEMETRY_SETTING.getKey(), false)) {
        // refresh is called to make sure the bogus docs doesn't affect the search results
import org.opensearch.core.common.Strings;
        ClusterScope annotation = getAnnotation(this.getClass(), ClusterScope.class);
        if (value % 2 == 1) {
    }
        return ensureGreen(indices);
        updateSettingsRequest.persistentSettings(settings);
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
                final BytesReference parsedBytes = BytesReference.bytes(builder);
import org.opensearch.action.admin.cluster.node.hotthreads.NodeHotThreads;  
            });  
                    && clusterManagerId.equals(localClusterState.nodes().getClusterManagerNodeId())) {
            seed,
    private static final int ALWAYS_BULK_THRESHOLD = 3000;  
            .put("node.attr." + REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, segmentRepoName)
     */  
import org.opensearch.transport.client.AdminClient;  
            builder.put(SETTING_NUMBER_OF_SHARDS, numberOfShards).build();
                randomSettingsBuilder.put("index.codec", CodecService.LUCENE_DEFAULT_CODEC);  
    protected void ensureClusterStateCanBeReadByNodeTool() throws IOException {  
 * <pre>  
            for (SearchHit hit : searchResponse.getHits().getHits()) {
        String repoName,
                );  
        return clusterState.getRoutingNodes().node(nodeId).node().getName();  
    /**
                        // We cannot compare serialization bytes since serialization order of maps is not guaranteed
                    .execute(new LatchedActionListener<>(newLatch(inFlightAsyncOperations)));  
    }
                                        final List<ShardRouting> replicaRouting = shardRoutingTable.replicaShards();
    private Settings.Builder getExcludeSettings(int num, Settings.Builder builder) {
            routingTableRepoName
    public static void disableIndexBlock(String index, String block) {
            logger.info(
    public @interface SuiteScopeTestCase {
        Random random = random();
        }
        }  
            final String dataPath = randomAlphaOfLength(10);  
         */
    @Override
                public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(
                builder.endObject();  
        logger.debug("ensuring cluster is stable with [{}] nodes. access node: [{}]. timeout: [{}]", nodeCount, viaNode, timeValue);
 */
        /**  
     * being accurately determined will not work on such setups,
import org.opensearch.core.index.Index;  
    /**
     * <p>
            ClusterState clusterManagerClusterState = clusterManagerClient.admin().cluster().prepareState().all().get().getState();
            )
            buildRemoteStoreNodeAttributes(
        }  
     *  
    }
        }  
        return Function.identity();
     * Creates a randomized index template. This template is used to pass in randomized settings on a  
        setRandomIndexTranslogSettings(random, builder);
     * Ensures that all nodes in the cluster are connected to each other.
                segmentRepoName,  
     */
     * Returns a collection of plugins that should be loaded on each node.
            final Map<String, String> serializationParams = new HashMap<>(2);
        logger.debug(
import org.opensearch.index.shard.IndexShard;
     * are now allocated and started.
                compareBuilder.startObject();
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "1b")
     *
        if (finalSettings == false && settings.keys().contains(BlobStoreRepository.SHARD_PATH_TYPE.getKey()) == false) {
            segmentRepoName,
     *   return client().prepareIndex(index, type, id).setSource(source).execute().actionGet();
     *                       all documents are indexed. This is useful to produce deleted documents on the server side.  
    protected final IndexResponse index(String index, String type, String id, Object... source) {
    /**
                .setThreads(99999)
import org.opensearch.search.SearchService;  
    }  
            operation.await();
    /**
import org.opensearch.repositories.fs.ReloadableFsRepository;
        int numShards = Integer.valueOf(metadata.index(index).getSettings().get(SETTING_NUMBER_OF_SHARDS));  
            Throwable t = ExceptionsHelper.unwrapCause(tuple.v2());
        return client().prepareIndex(index).setId(id).setSource(source).execute().actionGet();  
     * Creates a new {@link CreateIndexRequestBuilder} with the settings obtained from {@link #indexSettings()}.  
            }
    private NodeConfigurationSource getNodeConfigSource() {
        boolean waitForNoInitializingShards,
        return new NodeConfigurationSource() {
     * indexes them in a blocking or async fashion. This is very useful to catch problems that relate to internal document  
            lessThanOrEqualTo(clusterHealthStatus.value())
        }
     * Waits for all relocating shards to become active and the cluster has reached the given health status
            }
 * You may obtain a copy of the License at  
        String numSearchReplicasValue = metadata.index(index).getSettings().get(SETTING_NUMBER_OF_SEARCH_REPLICAS);
                client().admin()  
        for (DefaultShardOperationFailedException failure : actionGet.getShardFailures()) {  
        String segmentRepoName,
import org.opensearch.action.index.IndexResponse;
     * The scope of a test cluster used together with
    public static Client client(@Nullable String node) {
    /**  
        segmentsPathFixedPrefix = randomBoolean();
import org.opensearch.repositories.fs.FsRepository;
    }
        RemoteStorePathStrategy.SnapshotShardPathInput shardPathInput = new RemoteStorePathStrategy.SnapshotShardPathInput.Builder()
     * @param numDocs number of documents to wait for
        String segmentRepoName,
                client().admin().indices().prepareRefresh(indicesArray).setIndicesOptions(IndicesOptions.lenientExpandOpen()).get()  
        if (useRandomReplicationStrategy()) {  
                        randomBoolean() ? 1000 : INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.get(Settings.EMPTY).millis()  
    }
    public final CreateIndexRequestBuilder prepareCreate(String index) {
    }  
    public static void putRepository(ClusterAdminClient adminClient, String repoName, String type, Settings.Builder settings) {
    /**
            }
                DocWriteResponse.Result.DELETED,  
    }  
            disruptionType
            if (randomBoolean()) {  
                .build();
     * </p>
                PendingClusterTasksResponse pendingTasks = client.admin().cluster().preparePendingClusterTasks().setLocal(true).get();
    }
     */  
                        .setId(id)
    protected void updateRepository(String repoName, String type, Settings.Builder settings) {  
    /** Disables an index block for the specified index */
        settingsBuilder.put(  
            builder.put(IndexMetadata.SETTING_DATA_PATH, dataPath);
    private ExternalTestCluster buildExternalCluster(String clusterAddresses, String clusterName) throws IOException {  
                logger.info("Index [{}] docs async: [{}] bulk: [{}]", builders.size(), false, false);
                                if (primaryRouting.state() == ShardRoutingState.STARTED) {
        if (numberOfReplicas >= 0) {
import java.util.Arrays;
                segmentRepoType,
        if (randomInt(9) < 3) {
     * Returns a random admin client. This client can be a node pointing to any of the nodes in the cluster.
import java.util.Random;
            routingTableRepoAttributeKey = String.format(
    }  
    }
        return Collections.emptyList();  
        public final int dataCopies;
        Property.IndexScope
                    Throwable t = ExceptionsHelper.unwrapCause(tuple.v2());  
            fail("timed out waiting for " + color + " state");  
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
    /**  
        Path remoteRoutingTableRepoPath,  
            .putList(DISCOVERY_SEED_HOSTS_SETTING.getKey()) // empty list disables a port scan for other nodes  
import org.opensearch.core.xcontent.XContentBuilder;  
     * may require the user to manually configure an external process (such as rabbitmq),  
import org.opensearch.indices.replication.common.ReplicationType;  
    protected Settings nodeSettings(int nodeOrdinal) {
    }
            return null;  
                                            }  
     * creates an index with the given setting and mapping
import org.opensearch.env.Environment;
        return true;  
                TieredMergePolicyProvider.INDEX_COMPOUND_FORMAT_SETTING.getKey(),  
        putRepository(clusterAdmin(), repoName, type, null, settings);
import org.opensearch.index.translog.Translog;
                loadedMetadata.toXContent(builder, compareFormatParams);
import java.lang.annotation.ElementType;  
            final int maxThreadCount = RandomNumbers.randomIntBetween(random, 1, 4);  
        return client(internalCluster().getClusterManagerName()).admin().cluster().prepareState().get().getState();
    private static Settings.Builder setRandomIndexTranslogSettings(Random random, Settings.Builder builder) {  
    }
     * before the first test of this class is executed.
        refresh(indices);  
    }
            buildRemoteStoreNodeAttributes(
            actionGet.getStatus().value(),
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
    }  
            externalClusterClientSettings(),
import java.lang.annotation.Target;
        return clusterState.getRoutingNodes().node(nodeId).node().getName();  
 * If the test methods need specific node settings or change persistent and/or transient cluster settings {@link Scope#TEST}  
            minNumDataNodes = getMinNumDataNodes();
    private boolean getSupportsDedicatedClusterManagers() {  
        String nodeId = clusterState.getRoutingTable().index(indexName).shard(0).primaryShard().currentNodeId();
                .putNull(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values")
                .putNull(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey())  
        refresh();
                        throw error;
     * @param indexer a {@link BackgroundIndexer}. It will be first checked for documents indexed.
    public static void putRepository(  
        return between(minimumNumberOfReplicas(), maximumNumberOfReplicas());
        if (addMockTelemetryPlugin()) {
        client().admin()  
     * indexes them in a blocking or async fashion. This is very useful to catch problems that relate to internal document
                    .build();
    }
    }  
import org.opensearch.indices.store.IndicesStore;
        );  
    private static final int MAX_BULK_INDEX_REQUEST_SIZE = 1000;
     * @param dummyDocuments if {@code true} some empty dummy documents may be randomly inserted into the document list and deleted once
            .put(translogRepoSettingsAttributeKeyPrefix + "location", translogRepoPath)
                .put(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey(), true)
        IndexSegments indexSegments = segmentResponse.getIndices().get(indexName);
                segmentRepoName,  
    }  
            if (addMockInternalEngine() && randomBoolean()) {  
    }
                    "failed to delete a dummy doc [" + doc.get(0) + "][" + doc.get(1) + "]",
                XContentBuilder builder = SmileXContent.contentBuilder();
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;  
        if (MOCK_MODULES_ENABLED && randomBoolean()) { // sometimes run without those completely
                }
            assertEquals(
     */
    }  
     * restored from remote.
     * Threshold at which bulk indexing will always be used.
            maxNumDataNodes = getMaxNumDataNodes();
    }
        );
     */
     * Asserts that all segments are sorted with the provided {@link Sort}.
     */
        assertNoFailures(actionGet);  
 * <p>  
        }  
        boolean verify,  
            for (List<IndexRequestBuilder> segmented : partition) {
            String failMsg = sb.toString();
        String segmentRepoType,  
        Client client = internalCluster().dataNodeClient();  
        builder.setSettings(settings);
                    .prepareFlush(indices)
            Map<String, Object> clusterManagerStateMap = convertToMap(clusterManagerClusterState);
            );
        // manually overridden by subclass if needed.
        if (dummyDocuments) {  
import java.util.List;
    /**  
        return builder;  
    public void manageReplicaSettingForDefaultReplica(boolean apply) {
        return prepareCreate(index, numNodes, Settings.builder());
    }
     * If a test is annotated with {@link SuiteScopeTestCase}  
                break;
                logger.info("Action Failed", t);
            String value = Long.toString(totalHits.value()) + (totalHits.relation() == TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO  
        RefreshResponse refreshResponse = refresh(indices);
    }  
        if (numDataNodes >= 0) {
    protected Settings.Builder setRandomIndexMergeSettings(Random random, Settings.Builder builder) {  
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
import org.opensearch.common.unit.TimeValue;  
        );
            builder.put(TelemetrySettings.TRACER_FEATURE_ENABLED_SETTING.getKey(), true);  
            // randomly enable low-level search cancellation to make sure it does not alter results
                    + viaNode  
                actualErrors.add(tuple.v2());
 * determined at random and can change across tests. The {@link ClusterScope} allows configuring the initial number of nodes
        String segmentRepoType,
        Settings.Builder settings
        if (totalHits.value() != expectedResults || totalHits.relation() != TotalHits.Relation.EQUAL_TO) {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;
     *
        return builder.build();  
        Settings.Builder settings = Settings.builder()
    /**
                                        final IndexShard primaryShard = getIndexShard(primaryRouting, index);
        if (random.nextBoolean()) {
    public void setDisruptionScheme(ServiceDisruptionScheme scheme) {
import java.net.InetAddress;
        });  
            fail(failMsg);  
     * Indexes documents in bulk across the specified number of segments. Documents are evenly distributed  
    public @interface ThirdParty {
                .build();
                    .setFlush(maybeFlush && randomBoolean())
import org.apache.lucene.search.Sort;
            builder.put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(1, ByteSizeUnit.PB)); // just
        flush(indices);
        }
            logger.trace("Check consistency for [{}] nodes", cluster().size());
                        client().admin().indices().prepareRefresh().get();
    }  
                ) {  
        Path routingTableRepoPath,
    }
                if (isSegmentReplicationEnabledForIndex(index)) {
    @Retention(RetentionPolicy.RUNTIME)
        String routingTableRepositorySettingsAttributeKeyPrefix = String.format(
    protected static RestClient getRestClient() {
        String translogRepoType,
    }  
    /**  
                randomStorageType = randomBoolean() ? "REMOTE_STORE" : "LOCAL";
            }
        String[] stringAddresses = clusterAddresses.split(",");
     * Returns {@code true} if this test cluster should have tracing enabled with MockTelemetryPlugin  
        Path segmentRepoPath,  
    }
            .waitForStatus(clusterHealthStatus)  
            if (t instanceof OpenSearchRejectedExecutionException) {  
     * ids or index segment creations. Some features might have bug when a given document is the first or the last in a  
            InetAddress inetAddress = InetAddress.getByName(uri.getHost());  
         */
     * @see #indexRandom(boolean, boolean, java.util.List)  
        indexRandom(forceRefresh, forceRefresh, builders);  
import org.opensearch.cluster.metadata.IndexMetadata;
                    TransportRequestHandler<T> actualHandler  
     */  
        String... indices
    public static String resolvePath(IndexId indexId, String shardId) {  
                    .put(initialNodeSettings.build())
     */
import org.opensearch.plugins.Plugin;  
    protected IndexShard getIndexShard(ShardRouting routing, String indexName) {  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
    public static final Setting<Long> INDEX_TEST_SEED_SETTING = Setting.longSetting(
        return annotation == null ? true : annotation.autoManageMasterNodes();
    /**
                    long count = client().prepareSearch()
import org.opensearch.test.disruption.ServiceDisruptionScheme;
     */
                }  
         */
    }
     * handy to be able to ensure this happens faster
     */
         */
     */  
            // By default, for tests we will put the target slice count of 2. This will increase the probability of having multiple slices
        assertNoFailures(actionGet);  
                    .put(OpenSearchIntegTestCase.this.nodeSettings(nodeOrdinal))  
    /**
     */
        String translogRepoTypeAttributeKey = String.format(
        public final int numSearchReplicas;  
        String repoName,
        return settingsBuilder.build();
    }
            assertThat(actionGet.getStatus(), equalTo(status));
        return annotation == null ? true : annotation.supportsDedicatedMasters();
                segmentRepoType,
     *   return client().prepareIndex(index, type, id).setSource(source).execute().actionGet();  
import java.util.Collections;
                .map(NodeHotThreads::getHotThreads)  
        }  
        }  
                        .get()  
                        OpenSearchNodeCommand.namedXContentRegistry,
            } finally {  
        IndicesExistsResponse actionGet = client().admin().indices().prepareExists(index).execute().actionGet();
            segmentRepoPath,  
                    .collect(Collectors.toSet())  
            for (List<String> doc : bogusIds) {
     * Clears the given scroll Ids  
                break;
        Settings.Builder settings = Settings.builder()  
    private boolean getAutoManageClusterManagerNodes() {
    protected long getLatestSegmentInfoVersion(IndexShard shard) {  
        String stateRepoSettingsAttributeKeyPrefix = String.format(
        return annotation == null || annotation.minNumDataNodes() == -1
                    operation.await();
                        0,
 * license agreements. See the NOTICE file distributed with
     * IT classes.
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            );
     */
        Path translogRepoPath  
                        actualErrors.add(tuple.v2());
                    IndexRequestBuilder indexRequestBuilder = client().prepareIndex()  
    }
        boolean withRateLimiterAttributes
     * @return disruption  
    }
        }
                mocks.add(MockFieldFilterPlugin.class);
 * GitHub history for details.
    }  
    }
            // when comparing XContent output, do not use binary format  
        return false;  
    }  
        }
        return builder;  
     * Waits for all relocating shards to become active using the cluster health API.  
        ClusterAdminClient adminClient,
            }  
    }
        @NonNull String remoteStateRepoName,  
            }
     * It is useful to ensure that all action on the cluster have finished and all shards that were currently relocating
                    cluster().wipeIndices(created.toArray(new String[0]));
        }
                false
                        assertNull(  
        "index.tests.seed",
                        assertEquals("cluster state size does not match", clusterManagerClusterStateSize, localClusterStateSize);
     * layout.
                    + nodeCount
                        OpenSearchNodeCommand.namedXContentRegistry,
                final int localClusterStateSize = localClusterState.toString().length();
            builder.put(
        }
    }
            remoteStateRepoName  
import static org.opensearch.index.IndexSettings.INDEX_DOC_ID_FUZZY_SET_FALSE_POSITIVE_PROBABILITY_SETTING;  
            supportsDedicatedClusterManagers,  
     */  
     * Creates a new client if the method is invoked for the first time in the context of the current test scope.
    public static void putRepository(
                }
                // match)
            );
        return buildRemoteStoreNodeAttributes(  
    protected static final String REMOTE_BACKED_STORAGE_REPOSITORY_NAME = "test-remote-store-repo";  
        return new ExternalTestCluster(  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        Path translogRepoPath,
        return client().prepareIndex(index).setSource(source).execute().actionGet();
            segmentRepoName,
        Path segmentRepoPath,
                String index = RandomPicks.randomFrom(random, indices);
    /**
    }  
        if (!bogusIds.isEmpty()) {  
import org.opensearch.common.concurrent.GatedCloseable;
    }  
            translogRepoName,
        }
        String routingTableRepoName,
        }
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            for (Client client : clients()) {
        String repoName,  
        if (n > 0) {
 *
        waitForRelocation();
            return Arrays.asList(new TransportInterceptor() {  
                ClusterState localClusterState = client.admin().cluster().prepareState().all().setLocal(true).get().getState();  
                throw new IllegalArgumentException("Missing tests.clustername system property");
    }  
            );
    /**  
            }  
    }
        final TotalHits totalHits = searchResponse.getHits().getTotalHits();  
        Settings.Builder settings  
        translogPathFixedPrefix = randomBoolean();
        } else {
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
        int maxNumReplicas = Math.max(0, cluster().numDataNodes() - 1);
     * together with randomly chosen settings like number of nodes etc.  
     * Key to provide the cluster name
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;  
                    "cluster state XContent serialization does not match, expected "  
            if (scope == Scope.TEST) {
     * Disabling this for now as the existing way of strict check do not support multiple nodes internal cluster.
    public static TestCluster cluster() {
import org.opensearch.test.client.RandomizingClient;
     */
        Path translogRepoPath,  
    protected ForceMergeResponse forceMerge(int maxNumSegments) {
            if (mockPlugins.contains(getTestTransportPlugin()) == false) {
    protected void randomIndexTemplate() {  
import org.opensearch.cluster.service.applicationtemplates.TestSystemTemplatesRepositoryPlugin;
                    bulkBuilder.add(indexRequestBuilder);  
        assertThat(clearResponse.isSucceeded(), equalTo(true));
            for (ShardSegments shardSegments : indexShardSegments.getShards()) {
    /**  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(),
     *                This saves on unneeded searches.  
            client().admin().indices().prepareUpdateSettings(index).setSettings(build).execute().actionGet();
    }
        }  
     * This method ingests bogus documents for the given indices such that multiple slices  
import org.opensearch.index.mapper.MockFieldFilterPlugin;
                for (int i = 0; i < numDocs; i++) {
        int value = random.nextInt(4);
            } else {  
     * Waits until at least a give number of document is visible for searchers
            .anyMatch(ni -> ni.getInfo(OsInfo.class).getPrettyName().equals("Debian GNU/Linux 8 (jessie)"));
        boolean isMixedMode = clusterSettings.get(REMOTE_STORE_COMPATIBILITY_MODE_SETTING)
            minNumDataNodes = maxNumDataNodes = numDataNodes;
            .indexUUID(indexId.getId())
     * Flush some or all indices in the cluster.
        settings.put(BlobStoreRepository.SNAPSHOT_SHARD_PATH_PREFIX_SETTING.getKey(), snapshotShardPathFixedPrefix ? "c" : "");
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;
import static org.hamcrest.Matchers.startsWith;
        while (inFlightAsyncOperations.size() > MAX_IN_FLIGHT_ASYNC_INDEXES) {  
        final List<Exception> actualErrors = new ArrayList<>();  
    }
import com.carrotsearch.randomizedtesting.annotations.TestGroup;
 * should be used. To configure a scope for the test cluster the {@link ClusterScope} annotation
                        // (see: DeflateCompressedXContentTests#testDifferentCompressedRepresentation for an example)
 * tests against a JVM private OpenSearch Cluster. The test class supports 2 different  
            .put(stateRepoTypeAttributeKey, stateRepoType)
    }
                    indexRequestBuilder.execute(
        String type,  
    }
        Path translogRepoPath,
    private ClusterHealthStatus ensureColor(  
        String timeout,
        return indexService.getShard(id.get());  
                    differenceBetweenMapsIgnoringArrayOrder(
        return clusterService().state().getMetadata().isSegmentReplicationEnabled(index) || isMigratingToRemoteStore();  
import static org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm.FNV_1A_COMPOSITE_1;  
        CodecService.LZ4,  
     * @param maybeFlush     if {@code true} this method may randomly execute full flushes after index operations.
     * It's set once per test via a generic index template.
        return getIndexShard(getClusterState().nodes().get(routing.currentNodeId()).getName(), routing.shardId(), indexName);
     * creates an index with the given setting
                .cluster()
                        assertEquals(  
            .waitForEvents(Priority.LANGUID)
                    remoteStoreRepositoryPath = randomRepoPath().toAbsolutePath();
            nodePrefix,
            builder.put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), between(0, 1000));
                final BytesReference compareOriginalBytes = BytesReference.bytes(compareBuilder);
                .indices()  
    ) {
        if (random.nextBoolean()) {  
        String routingTableRepoType,  
            client = new RandomizingClient(client, random());
     * Compute a routing key that will route documents to the <code>shard</code>-th shard
     */
import org.opensearch.indices.IndicesService;
            }
                randomSettingsBuilder.put("index.codec", randomFrom(CODECS));
     * and can use this method for selective muting.
    /**
     * Returns a settings object used in {@link #createIndex(String...)} and {@link #prepareCreate(String)} and friends.
        String type,
                logger.info("Randomly using Replication Strategy as {} and Storage Type as {}.", randomReplicationType, randomStorageType);
        if (random.nextBoolean()) {
            }
        boolean withRateLimiterAttributes
                        logger.error(
     * @return Feature flag settings.  
    }  
        String translogRepoType
                segmentRepoPath,
                .collect(Collectors.joining("\n"));
                UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(),  
package org.opensearch.test;
        } catch (IOException e) {  
            indices = getClusterState().routingTable().indicesRouting().keySet().toArray(String[]::new);  
        );
    public ClusterHealthStatus waitForRelocation(ClusterHealthStatus status) {
                            clusterManagerClusterState.toString(),
        assertBusy(() -> {  
    public static void beforeClass() throws Exception {
import static org.opensearch.test.XContentTestUtils.convertToMap;
        public final int numReplicas;
    public final void createIndex(String name, Settings indexSettings, String mapping) {  
 * }
     * The returned client gets automatically closed when needed, it shouldn't be closed as part of tests otherwise
        boolean withRateLimiterAttributes
            if (randomBoolean()) {  
     * @param numSegments the number of segments to create
        }
                builder.endObject();
            latch.countDown();
                        SmileXContent.smileXContent,
        int batchSize = builders.size() / numSegments;  
                            differenceBetweenMapsIgnoringArrayOrder(clusterManagerStateMap, localStateMap)
    }
        final String nodePrefix;  
    /**  
            .put(SearchService.LOW_LEVEL_CANCELLATION_SETTING.getKey(), randomBoolean())
                final BytesReference originalBytes = BytesReference.bytes(builder);
        return waitForRelocation(null);  
        }
        builder.put("index.routing.allocation.exclude._name", exclude);  
        indexRandom(forceRefresh, dummyDocuments, Arrays.asList(builders));
import java.net.URI;
        );
        try {
        if (rarely()) {
    protected Settings buildRemotePublicationNodeAttributes(
                                        for (ShardRouting replica : replicaRouting) {  
                    XContentParser parser = createParser(  
            // If it's external cluster - fall back to the standard set
        }  
        }
            if (annotation != null && annotation.value().length == 1 && "*".equals(annotation.value()[0])) {  
        ClusterScope annotation = getAnnotation(this.getClass(), ClusterScope.class);
                    + "] nodes. Tried via ["
        return anyDebian8Nodes && java15Plus == false;  
        @Override
    }
        for (CountDownLatch operation : inFlightAsyncOperations) {  
            }  
 * Note, the {@link OpenSearchIntegTestCase} uses randomized settings on a cluster and index level. For instance
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
        settings.put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.getKey(), segmentsPathFixedPrefix ? "b" : "");  
            }
            .setTimeout(timeValue)
                        .setRouting(id);
                builder.endObject();
import org.apache.lucene.tests.util.LuceneTestCase;  
    /**
                translogRepoPath,
    protected ClusterAdminClient clusterAdmin() {
     */
                logger.info("Randomly using Replication Strategy as {} and Storage Type as {}.", randomReplicationType, randomStorageType);
        public List<Setting<?>> getSettings() {
    @Deprecated
import org.opensearch.common.xcontent.smile.SmileXContent;
        putRepository(clusterAdmin(), repoName, type, null, settings);  
                try {
    /**
        return builder.build();
     * @return boolean.
    }
        return client().admin().indices().prepareCreate(index).setSettings(builder.build());
     */
     */  
            Metadata metadata = clusterManagerClient.admin().cluster().prepareState().all().get().getState().metadata();  
                                                        "replica shards haven't caught up with primary",
        waitForRelocation();
            }
        }
import org.junit.Rule;
    }
        ClusterHealthRequest request = Requests.clusterHealthRequest().waitForNoRelocatingShards(true).waitForEvents(Priority.LANGUID);
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
            assertNoTimeout(client().admin().cluster().prepareHealth().setWaitForNodes(Integer.toString(cluster().size())).get());
/*
        return client(null);
            // so that the health check applies to the set of nodes we expect to be part of the cluster.
    }
import java.io.IOException;  
            }
                            clusterManagerClusterState.stateUUID(),
        if (useRandomReplicationStrategy()) {
     */  
     * This method uses allocation deciders to filter out certain nodes to allocate the created index on. It defines allocation
 * each test might use different directory implementation for each test or will return a random client to one of the
     * Ensures the cluster has a yellow state via the cluster health API.  
                .put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), 2)  
        // TODO move settings for random directory etc here into the index based randomized settings.
    public void indexBulkWithSegments(List<IndexRequestBuilder> builders, int numSegments) throws InterruptedException {
        return ensureColor(ClusterHealthStatus.RED, TimeValue.timeValueSeconds(30), false, indices);
            translogRepoName
    private static CountDownLatch newLatch(List<CountDownLatch> latches) {
import java.util.function.Function;
                builder.endObject();
        Path translogRepoPath,
    /** Return the mock plugins the cluster should use */
            .setIndicesOptions(IndicesOptions.strictExpandOpenHiddenAndForbidClosed())  
        TEST  
                mocks.add(MockEngineFactoryPlugin.class);
    public static Settings buildRemoteStoreNodeAttributes(  
import java.lang.annotation.RetentionPolicy;  
     * Returns an instance of {@link RestClient} pointing to the current test cluster.  
        }
        @NonNull String routingTableRepoType  
import org.opensearch.action.admin.indices.get.GetIndexResponse;
                assertThat("client " + client + " still has pending tasks " + pendingTasks, pendingTasks, Matchers.emptyIterable());
        // Enabling Telemetry setting by default
     * Creates one or more indices and asserts that the indices are acknowledged. If one of the indices  
    }
     * Restricts the given index to be allocated on <code>n</code> nodes using the allocation deciders.
            Locale.getDefault(),
        // Randomly set a Replication Strategy and storage type for the node. Both Replication Strategy and Storage Type can still be
import java.lang.annotation.Retention;
     */
     * @return if needs to perform remote state restore or not  
        );
import org.apache.lucene.index.SegmentInfos;  
    public ClusterHealthStatus waitForRelocation() {
 * ownership. Elasticsearch licenses this file to you under  
            serializationParams.put("binary", "true");
        cluster().beforeIndexDeletion();
                client().admin().cluster().prepareState().get().getState(),
        return settingsBuilder.build();
                Locale.getDefault(),
        GetIndexResponse getIndexResponse = client().admin().indices().prepareGetIndex().setIndices(index).get();
     * ids or index segment creations. Some features might have bug when a given document is the first or the last in a
    public static Client dataNodeClient() {
    /**  
     * across segments with a refresh between each batch to create segment boundaries. This is useful for
     */  
     */
     */
        // In an integ test it doesn't make sense to keep track of warnings: if the cluster is external the warnings are in another jvm,  
 */  
    /** Ensures the result counts are as expected, and logs the results if different */
        if (status != null) {
        ForceMergeResponse actionGet = client().admin()  
            featureSettings.put(builtInFlag.getKey(), builtInFlag.getDefaultRaw(Settings.EMPTY));
                }  
            // the read-only-allow-delete block isn't supported by the add block API so we must use the update settings API here.
            .setWaitForNoRelocatingShards(true)
        boolean verify,
            logger.warn("{}", sb);
    /**
                        .setTrackTotalHits(true)  
 * {@literal @}NodeScope(scope=Scope.TEST) public class SomeIT extends OpenSearchIntegTestCase {
        }
            .waitForNodes(Integer.toString(cluster().size()));  
    ) {  
            if (lastKnownCount >= numDocs) {  
                                                        getLatestSegmentInfoVersion(primaryShard),  
            }
    /**
            }
            // always default delayed allocation to 0 to make sure we have tests are not delayed  
        }  
                }  
            @Override
        }  
 * under the License.  
        assert numSegments > 0 && numSegments <= builders.size() : "numSegments must be between 1 and builders.size()";
            long lastKnownCount = indexer.totalIndexedDocs();
import org.opensearch.repositories.IndexId;
        return actionGet;
    }  
            .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, stateRepoName)  
        return ensureGreen(TimeValue.timeValueSeconds(30), indices);
     */
    /**  
    }
    /**
        if (builders.size() < FREQUENT_BULK_THRESHOLD ? frequently() : builders.size() < ALWAYS_BULK_THRESHOLD ? rarely() : false) {
import org.opensearch.index.MergeSchedulerConfig;
            // the old cluster-manager and the condition ensureGreen / ensureYellow will trivially hold if it held before the node was  
        return ensureColor(ClusterHealthStatus.GREEN, timeout, waitForNoRelocatingShards, false, indices);
        Path segmentRepoPath,
    public void logClusterState() {  
import org.opensearch.index.codec.CodecService;
    }  
    }
        if (cluster() != null && cluster().size() > 0) {
     * It is useful to ensure that all action on the cluster have finished and all shards that were currently relocating
        ensureStableCluster(nodeCount, TimeValue.timeValueSeconds(30));
     * are now allocated and started.
            } else {
    }  
     * Creates a new {@link CreateIndexRequestBuilder} with the settings obtained from {@link #indexSettings()}.
     */
        String type,  
     * Asserts that all shards are allocated on nodes matching the given node pattern.
            assertThat(lastKnownCount, greaterThanOrEqualTo(numDocs));
            null,
            }
 */  
     *
                    "cluster state XContent serialization does not match, expected "
import static org.opensearch.indices.IndicesService.CLUSTER_REPLICATION_TYPE_SETTING;
                        originalBytes  
            return new NamedXContentRegistry(ClusterModule.getNamedXWriteables());  
        logger.info("--> updating repository [{}] [{}]", repoName, type);
     */
                assertNull(
     * Ensures the cluster is in a searchable state for the given indices. This means a searchable copy of each
        if (value == 3) {
        final boolean anyDebian8Nodes = response.getNodes()
    }
            .put("node.attr." + REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY, translogRepoName)
        ClusterAdminClient adminClient,  
        return client().prepareIndex(index).setId(id).setSource(source).execute().actionGet();
    ) {  
     * Returns a collection of plugins that should be loaded on each node.  
        settingsBuilder.put(buildRemoteStoreNodeAttributes(segmentRepoName, segmentRepoPath, translogRepoName, translogRepoPath, false));  
        }
     * Returns path to a random directory that can be used to create a temporary file system repo
                segmentRepoPath,  
        TimeValue timeout,
        Settings settings = Settings.builder().put(block, false).build();  
        boolean finalSettings
        for (String index : indices) {
    }
        final NodesInfoResponse response = client().admin().cluster().prepareNodesInfo().execute().actionGet();
         * Indicates whether the cluster can have dedicated cluster-manager nodes. If {@code false} means data nodes will serve as cluster-manager nodes  
                ) {
import org.junit.AfterClass;
import org.apache.lucene.search.TotalHits;
                .preparePutTemplate("random_index_template")
    public boolean isMigratingToRemoteStore() {  
    private Path remoteStoreRepositoryPath;
     * @see OpenSearchIntegTestCase
    /**
                    assertBusy(() -> {  
 * software distributed under the License is distributed on an
                    if (TransportService.isValidActionName(action) == false) {
            getClientWrapper(),  
                localClusterState = ClusterState.Builder.fromBytes(localClusterStateBytes, null, namedWriteableRegistry);  
                builder = SmileXContent.contentBuilder();  
     * Yet if the shards can't be allocated on any other node shards for this index will remain allocated on  
        ClusterHealthResponse actionGet = client().admin().cluster().health(request).actionGet();  
    protected boolean addMockTelemetryPlugin() {
    }  
        Path[] repoFiles = environment.repoFiles();  
        String translogRepoSettingsAttributeKeyPrefix = String.format(  
    /** Returns {@code true} iff this test cluster should use a dummy geo_shape field mapper */  
            withRateLimiterAttributes
     */
                    + stateResponse.getState()
    public void indexRandom(boolean forceRefresh, List<IndexRequestBuilder> builders) throws InterruptedException {
     * <pre>  
     * This method is executed iff the test is annotated with {@link SuiteScopeTestCase}
            final Client clusterManagerClient = client();  
            }  
    /**  
            segmentRepoName  
    private int getMaxNumDataNodes() {
        }  
        public final void onFailure(Exception t) {
    protected static Boolean prefixModeVerificationEnable;
            translogRepoPath,  
     * By default it returns a settings object that sets a random number of shards. Number of shards and replicas  
        return DEFAULT_MAX_NUM_SHARDS;
        return new NetworkDisruption(
     * using the cluster health API.
            compareParams.put(Metadata.CONTEXT_MODE_PARAM, Metadata.CONTEXT_MODE_GATEWAY);
                                            if (replica.state() == ShardRoutingState.STARTED) {
     * when cgroups are enabled, and this confuses many versions of
                ? "+"
    /**
                    String action,  
        assertTrue("index " + index + " not found", getIndexResponse.getSettings().containsKey(index));
import org.opensearch.test.transport.MockTransportService;
    protected static Boolean segmentsPathFixedPrefix;  
        }  
        if (random.nextBoolean()) {
            // bypass this limit so that caching gets some testing in
            }
import static org.opensearch.index.IndexSettings.INDEX_DOC_ID_FUZZY_SET_ENABLED_SETTING;
    }
import org.opensearch.common.settings.Settings;
                bogusIds.add(Arrays.asList(index, id));  
    protected String primaryNodeName(String indexName) {  
                routingTableRepoName  
        throws InterruptedException {  
import org.opensearch.OpenSearchException;
    }
                .putNull(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey())
        public final int totalNumShards;
            builder.put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), maxThreadCount);  
            URI uri = URI.create("http://" + stringAddress);
     * shard is available on the cluster.  
        int minNumDataNodes;
     */
            .prepareRefresh(indices)
    protected static Settings buildRemoteStoreNodeAttributes(  
            client().admin().indices().prepareUpdateSettings(index).setSettings(settings).get();  
    public static void enableIndexBlock(String index, String block) {
    /**  
/*  
        }, maxWaitTimeMs, TimeUnit.MILLISECONDS);  
import org.opensearch.monitor.os.OsInfo;
     * Maximum number of async operations that indexRandom will kick off at one time.  
                .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")
import org.opensearch.core.xcontent.NamedXContentRegistry;
     * times with the same ordinal and is expected to return the same value for each invocation.
            .equals(RemoteStoreNodeService.CompatibilityMode.MIXED);  
    public void manageReplicaBalanceSetting(boolean apply) {  
                randomStorageType = "LOCAL";  
            remoteStateRepoName
        return Settings.EMPTY;
    private static Settings buildRemoteStoreNodeAttributes(
    }  
                    differenceBetweenMapsIgnoringArrayOrder(
        }
        return blobPath.buildAsString();  
    }
    protected RefreshResponse refreshAndWaitForReplication(String... indices) {  
     */  
    private static final int FREQUENT_BULK_THRESHOLD = 300;
    /**  
import org.opensearch.script.MockScriptService;  
    }
    protected Settings.Builder setRandomIndexSettings(Random random, Settings.Builder builder) {  
     */
            transportAddresses  
    protected void setupSuiteScopeCluster() throws Exception {}  
        Path segmentRepoPath,  
                return Settings.builder()
    protected final FlushResponse flush(String... indices) {  
        NetworkDisruption.ensureFullyConnectedCluster(internalCluster());
        if (random.nextBoolean()) {
     */  
        logger.info("--> creating repository [{}] [{}]", repoName, type);
                    .prepareRefresh(indices)
import org.opensearch.core.action.ActionListener;  
        );  
            viaNode = randomFrom(internalCluster().getNodeNames());  
import org.opensearch.cluster.routing.IndexRoutingTable;
        }
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
     *   empty dummy documents are may be randomly inserted into the document
        );
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;  
         */  
     */
            this.latch = latch;
     * @see SuiteScopeTestCase
            ? Settings.builder().put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), value).build()  
                        // a synced flush that can affect the size of the compressed byte array
            builder.put(IndexSettings.INDEX_CHECK_ON_STARTUP.getKey(), randomFrom(random, "false", "checksum", "true"));  
     * Setting all feature flag settings at base IT, which can be overridden later by individual  
            waitForReplication();
            settings = Settings.builder()
    /**
     * @param numDocs number of documents to wait for
        String exclude = String.join(",", internalCluster().allDataNodesButN(num));
            mocks.add(getTestTransportPlugin());
         * Ignored when {@link ClusterScope#numDataNodes()} is set.
        }
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
        Settings.Builder builder = Settings.builder().put(indexSettings()).put(settingsBuilder.build());
            settings = Settings.builder()  
                }
    public ClusterHealthStatus ensureGreen(TimeValue timeout, boolean waitForNoRelocatingShards, String... indices) {
        RemoteStoreEnums.PathHashAlgorithm pathHashAlgorithm = pathType != PathType.FIXED ? FNV_1A_COMPOSITE_1 : null;
                        IndexRoutingTable indexRoutingTable = getClusterState().routingTable().index(index);
         * Ignored when {@link ClusterScope#numDataNodes()} is set.
     */
     * <p>
                    "a, b, c"  
        }
import static org.hamcrest.Matchers.equalTo;
    public static Settings remoteStoreClusterSettings(
            translogRepoPath,  
        );
            translogRepoName  
     * This method is used to obtain settings for the {@code N}th node in the cluster.
            indexRandomForMultipleSlices(indicesArray);
            .setLocal(local)  
            }
    }  
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
            return Collections.singletonList(INDEX_TEST_SEED_SETTING);
            .prepareForceMerge()
        return client().prepareIndex(index).setId(id).setSource(source, MediaTypeRegistry.JSON).execute().actionGet();
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateRequestBuilder;
            case SUITE:
    ) {  
 * public class SomeIT extends OpenSearchIntegTestCase {
 *
    /**
        protected void addError(Exception e) {}
         * A cluster shared across all method in a single test suite  
            this.numPrimaries = numPrimaries;
        int maxNumDataNodes() default -1;  
import org.opensearch.core.common.transport.TransportAddress;
 * Licensed to Elasticsearch under one or more contributor  
            request.waitForStatus(status);
        }
            Locale.getDefault(),  
                if (remoteStoreRepositoryPath == null) {  
import org.opensearch.env.TestEnvironment;  
            .basePath(BlobPath.cleanPath())  
     * Syntactic sugar for:
        Path translogRepoPath,  
        private final T builder;
            settings = Settings.builder()  
                    }
import org.opensearch.index.TieredMergePolicyProvider;  
import org.opensearch.repositories.blobstore.BlobStoreRepository;  
        if (randomBoolean()) {  
                translogRepoName,
        }
    protected TestCluster buildTestCluster(Scope scope, long seed) throws IOException {  
    public static final class AssertActionNamePlugin extends Plugin implements NetworkPlugin {  
                builder.startObject();  
            );
        }
                assertNull(  
        String segmentRepoType,  
import static org.hamcrest.Matchers.is;  
                client().admin()  
        boolean waitForNoRelocatingShards,  
    ) {
    public ClusterHealthStatus ensureGreen(String... indices) {
                BulkResponse actionGet = bulkBuilder.execute().actionGet();
     * @param builders       the documents to index.
        settings.put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.getKey(), translogPathFixedPrefix ? "a" : "");
    }
                randomSettingsBuilder.put(INDEX_TEST_SEED_SETTING.getKey(), random().nextLong());
            segmentRepoType,
                .put(segmentRepoSettingsAttributeKeyPrefix + "chunk_size", 200, ByteSizeUnit.BYTES);  
                // that the cluster-manager node matches the cluster-manager (otherwise there is no requirement for the cluster state to
                .stream()
     * Waits for relocations and refreshes all indices in the cluster.
        A annotation = clazz.getAnnotation(annotationClass);
        }  
     * Java prior to Java 15.  Tests that rely on machine memory  
import org.opensearch.test.store.MockFSIndexStore;
     */  
     * Verifies that all nodes that have the same version of the cluster state as cluster-manager have same cluster state
        for (IndexRequestBuilder builder : builders) {  
    /**
            if (randomBoolean()) {
import org.opensearch.common.blobstore.BlobPath;
            .prepareUpdateSettings(indices)
            .actionGet();
        int numClientNodes() default InternalTestCluster.DEFAULT_NUM_CLIENT_NODES;
     * On Debian 8 the "memory" subsystem is not mounted by default
            segmentRepoName,
 * <p>
 * SPDX-License-Identifier: Apache-2.0
    public void allowNodes(String index, int n) {  
        String remoteRoutingTableRepoName,
    }
    protected int minimumNumberOfShards() {
                client().admin()  
     */
                        );  
import org.opensearch.index.IndexSettings;  
import org.opensearch.node.remotestore.RemoteStoreNodeService;
            return buildExternalCluster(clusterAddresses, clusterName);  
        return annotation == null ? -1 : annotation.numDataNodes();  
    /**
        }
                XContentBuilder compareBuilder = SmileXContent.contentBuilder();
import org.opensearch.cluster.routing.UnassignedInfo;
            );
        );  
                .setSettings(randomSettingsBuilder);
            .build();  
        }
        String repoName,  
            builder.setTimeout(timeout);  
import org.opensearch.telemetry.TelemetrySettings;
    public Settings getNodeSettings() {
     * Threshold at which indexing switches from frequently async to frequently bulk.
            );
    /*
                        );  
        ) {
     * per index basis. Allows to enable/disable the randomization for number of shards and replicas
            mocks.add(MockTelemetryPlugin.class);
                client().admin().cluster().preparePendingClusterTasks().get(),  
    /**
            public Collection<Class<? extends Plugin>> nodePlugins() {
    }
        @Override  
        }
     * @return An exclude set of index templates that will not be removed in between tests.
     */
     */
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;  
        }
        return true;
    protected void ensureClusterSizeConsistency() {
     * method.  
     * @param builders     the documents to index.
            ReloadableFsRepository.TYPE,
        boolean waitForNoInitializingShards,  
     */
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
    /**
            client().admin().indices().prepareAddBlock(IndexMetadata.APIBlock.fromSetting(block), index).get();
import org.opensearch.common.regex.Regex;  
     * The index that is created with this builder will only be allowed to allocate on the number of nodes passed to this
    }  
                        nodes.add(name);  
    protected void beforeIndexDeletion() throws Exception {
            // assertion that UUID is changed post restore.  
        return client().admin();
        }
            .put(stateRepoSettingsAttributeKeyPrefix + "location", stateRepoPath)
        assertNoFailures(actionGet);  
            }
                        // We also cannot compare byte array size because CompressedXContent's DeflateCompressor uses  
     * Returns path to a random directory that can be used to create a temporary file system repo
import org.opensearch.search.MockSearchService;
        return frequently() ? Math.min(1, maxNumReplicas) : maxNumReplicas;  
    public static final List<String> CODECS = List.of(
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequestBuilder;
                routingTableRepoType,
        return actionGet;  
    protected void ensureStableCluster(int nodeCount) {
     *  
        Collections.shuffle(builders, random());
        TransportAddress[] transportAddresses = new TransportAddress[stringAddresses.length];
import org.opensearch.action.DocWriteResponse;  
     * Syntactic sugar for:  
                client().admin().cluster().prepareState().get().getState(),
                segmentRepoPath,
        CodecService.BEST_COMPRESSION_CODEC,
        for (IndexShardSegments indexShardSegments : indexSegments.getShards().values()) {  
     * The default is {@code true}.
        return admin().cluster();  
            segmentRepoName
            .put(routingTableRepositoryTypeAttributeKey, routingTableRepoType)  
import com.carrotsearch.randomizedtesting.generators.RandomPicks;  
            // It will only subsequently publish a second state where the old cluster-manager is removed.
                ClusterHealthResponse clusterHealth = client.admin().cluster().prepareHealth().setLocal(true).get();
            {
    public static void setClusterReadOnly(boolean value) {
                assertAcked(prepareCreate(name));  
                }
     * Indexes the given {@link IndexRequestBuilder} instances randomly. It shuffles the given builders and either  
    /**  
    }  
    /** Sets or unsets the cluster read_only mode **/  
            assertThat("timed out waiting for relocation", actionGet.isTimedOut(), equalTo(false));
        }
                            "invalid action name [" + action + "] must start with one of: " + TransportService.VALID_ACTION_PREFIXES
                throw new OpenSearchException("Scope not supported: " + scope);  
    protected void ensureStableCluster(int nodeCount, @Nullable String viaNode) {  
    }
            .orElseThrow(() -> new UnsupportedOperationException("unsupported cluster type"));
     */
            );
        String segmentRepoName,
                                                }  
                                final ShardRouting primaryRouting = shardRoutingTable.primaryShard();
     * Should be used only on test classes where replication strategy is not critical for tests.  
        return true;
     * Key used to retrieve the index random seed from the index settings on a running node.  
            randomReplicationType = randomBoolean() ? ReplicationType.DOCUMENT : ReplicationType.SEGMENT;
    /**
        internalCluster().setDisruptionScheme(scheme);
     * This doesn't wait for inactive/non-started replica shards to become active/started.
    protected void createRepository(String repoName, String type, Settings.Builder settings, String timeout) {
        throws InterruptedException {  
    /**
    public static final String TEST_CLUSTER_NODE_PREFIX = "node_t";
        boolean isRemoteStoreMigrationDirection = clusterSettings.get(MIGRATION_DIRECTION_SETTING)
import reactor.util.annotation.NonNull;
    /**  
     */  
         * negative value means that the number of client nodes will be randomized.
                "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,  
     * Fetch IndexShard by shardId, multiple shards per node allowed.
     */
    /**  
    protected int numberOfShards() {
     * creates an index with the given setting  
    /**
    @Inherited
    public enum Scope {
                    postIndexAsyncActions(indicesArray, inFlightAsyncOperations, maybeFlush);
 * specific language governing permissions and limitations
        if (IndexMetadata.APIBlock.fromSetting(block) == IndexMetadata.APIBlock.READ_ONLY_ALLOW_DELETE || randomBoolean()) {  
    protected boolean useRandomReplicationStrategy() {
     */  
        Settings.Builder builder = Settings.builder();
        private final CopyOnWriteArrayList<Tuple<T, Exception>> errors;
     * Fetch latest segment info snapshot version of an index.
            } finally {  
                    String id = "bogus_doc_" + randomRealisticUnicodeOfLength(between(1, 10)) + dummmyDocIdGenerator.incrementAndGet();
        }
        String segmentRepoName,  
     * can be controlled through specific methods.
        PathType pathType = PathType.fromCode(indexId.getShardPathType());
    }
    @Target(ElementType.TYPE)
                "failed to delete a dummy doc [" + doc.get(0) + "][" + doc.get(1) + "]",
        assert index != null;
        );  
        ClusterSettings clusterSettings = clusterService().getClusterSettings();
     */  
        CountDownLatch l = new CountDownLatch(1);  
     */  
        Scope scope() default Scope.SUITE;
                            localClusterState.toString()
    protected int maximumNumberOfReplicas() {  
            // keep this low so we don't stall tests
            .build();  
            .put(SearchService.CONCURRENT_SEGMENT_SEARCH_MAX_SLICE_COUNT_KEY, 2)
        assertBusy(() -> {  
        return getIndexResponse.getSettings().get(index).get(IndexMetadata.SETTING_DATA_PATH);  
            String clusterName = System.getProperty(TESTS_CLUSTER_NAME);
import org.opensearch.core.common.bytes.BytesReference;  
            getAutoManageClusterManagerNodes(),
     * Syntactic sugar for:
 * </pre>
                .prepareNodesHotThreads()  
     * The lucene_default {@link Codec} is not added to the list as it internally maps to Asserting {@link Codec}.
    }
    }
import java.util.ArrayList;
    protected boolean addMockIndexStorePlugin() {
    protected final IndexResponse index(String index, String type, String id, String source) {  
     * Maybe refresh, force merge, or flush then always make sure there aren't too many in flight async operations.  
    protected void ensureFullyConnectedCluster() {
     *  
                indexMetadata.toXContent(builder, serializationFormatParams);  
            logger.info("Index [{}] docs async: [{}] bulk: [{}] partitions [{}]", builders.size(), false, true, partition.size());
    }  
            createTempDir(),
    }
import org.opensearch.index.remote.RemoteStorePathStrategy;
    public static InternalTestCluster internalCluster() {
        return false;  
                RandomPicks.randomFrom(random, Translog.Durability.values())  
    private static final int MAX_IN_FLIGHT_ASYNC_INDEXES = 150;
    ) {  
    public static String resolveCustomDataPath(String index) {  
                RandomNumbers.randomIntBetween(random, 1, 15) + "ms"
        return testClusterRule.internalCluster().orElseThrow(() -> new UnsupportedOperationException("current test cluster is immutable"));
     * </pre>
        return Collections.emptyList();
            this.numSearchReplicas = numSearchReplicas;
    protected static class NumShards {  
import org.opensearch.plugins.PluginInfo;
        );  
        return ensureColor(ClusterHealthStatus.GREEN, timeout, false, indices);
                routingTableRepoPath,  
    public @interface ClusterScope {
                Arrays.stream(internalCluster().getNodeNames())
     * Syntactic sugar for:  
                byte[] localClusterStateBytes = ClusterState.Builder.toBytes(localClusterState);
                } else {
    public static final String SUITE_CLUSTER_NODE_PREFIX = "node_s";  
import static org.opensearch.test.XContentTestUtils.differenceBetweenMapsIgnoringArrayOrder;
@LuceneTestCase.SuppressFileSystems("ExtrasFS") // doesn't work with potential multi data path from test cluster yet
                "{} timed out, cluster state:\n{}\npending tasks:\n{}\nhot threads:\n{}\n",  
            ReloadableFsRepository.TYPE,  
        ensureFullyConnectedCluster();  
            List<List<IndexRequestBuilder>> partition = eagerPartition(  
            // inject some bogus docs  
        String nodeId = clusterState.getRoutingTable().index(indexName).shard(shardId).primaryShard().currentNodeId();
import org.opensearch.common.util.FeatureFlags;
        if (forceRefresh) {  
    @Deprecated
        return Collections.emptySet();
                        + " but got "  
        assertTrue("index " + index + " not found", getIndexResponse.getSettings().containsKey(index));
     */
    }  
     * of the provided index.
        Set<String> indices = new HashSet<>();
                .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values", "a, b")
        return settingsBuilder.build();  
        }
     *  
     * For tests with remote cluster state, it will reset the cluster and cluster state will be
    protected Path nodeConfigPath(int nodeOrdinal) {  
        }  
    /**
            for (int i = 0; i < numBogusDocs; i++) {  
    public void indexRandom(boolean forceRefresh, IndexRequestBuilder... builders) throws InterruptedException {  
            Locale.getDefault(),  
import org.opensearch.index.store.Store;  
        Path segmentRepoPath,  
    @Target({ ElementType.TYPE })  
import org.opensearch.transport.client.ClusterAdminClient;
                client().admin().cluster().preparePendingClusterTasks().get()  
    public void assertResultsAndLogOnFailure(long expectedResults, SearchResponse searchResponse) {
            }
        if (addMockGeoShapeFieldMapper()) {
        if (addMockTransportService()) {  
    }
        );  
                translogRepoPath,  
        final ArrayList<Class<? extends Plugin>> mocks = new ArrayList<>();
                builder.startObject();
    public ClusterHealthStatus ensureYellowAndNoInitializingShards(String... indices) {
    }
        int i = 0;  
     * Creates a new {@link CreateIndexRequestBuilder} with the settings obtained from {@link #indexSettings()}.
        if (status != null) {  
    /**  
 * {@literal @}NodeScope(scope=Scope.SUITE, numDataNodes=3)
        Metadata metadata = client().admin().cluster().prepareState().get().getState().metadata();
    }
    }
    /**
            @Override
     *   return client().prepareIndex(index, type, id).setSource(source).execute().actionGet();
        // indexing threads can wait for up to ~1m before retrying when they first try to index into a shard which is not STARTED.  
            // default 10s limit.  
    }
    protected static final int DEFAULT_MIN_NUM_SHARDS = 1;  
        }
    }
                    logger.debug("failed to executed count", e);
        public final void onResponse(Response response) {  
    protected boolean addMockInternalEngine() {
    }
                : "");
        }  
    public ClusterHealthStatus ensureYellow(String... indices) {
        if (timeout != null) {
        Path segmentRepoPath,
                compareBuilder.endObject();
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
    /**
     */  
                    )
                    )
            }
 * <li> - a random seed used to initialize the index random context.
 * the Apache License, Version 2.0 (the "License"); you may
    }
            buildRemoteStoreNodeAttributes(
     *                This saves on unneeded searches.  
     * <pre>
import org.opensearch.core.index.shard.ShardId;
        return true;  
        Environment environment = TestEnvironment.newEnvironment(settings);
                        throw new IllegalArgumentException(  
                .put(routingTableRepoAttributeKey, routingTableRepoType)  
            withRateLimiterAttributes
                Math.min(MAX_BULK_INDEX_REQUEST_SIZE, Math.max(1, (int) (builders.size() * randomDouble())))
     * Key used to eventually switch to using an external cluster and provide its transport addresses
     */
/*  
            ReloadableFsRepository.TYPE,  
                                                fail("replica shard still INITIALIZING, not caught up with primary");
        ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();  
import static org.opensearch.discovery.SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING;
                for (IndexRequestBuilder indexRequestBuilder : segmented) {
            // remove local node reference  
            .actionGet();
            } else {
        return nodes;  
        return annotation == null ? InternalTestCluster.DEFAULT_NUM_CLIENT_NODES : annotation.numClientNodes();
            .put(buildRemoteStateNodeAttributes(segmentRepoName, segmentRepoPath, segmentRepoType));  
    public static final String SYSPROP_THIRDPARTY = "tests.thirdparty";
                                                IndexShard replicaShard = getIndexShard(replica, index);
        if (random.nextBoolean() && !builders.isEmpty() && dummyDocuments) {
    protected void waitForReplication(String... indices) {
     * Maximum number of documents in a single bulk index request.
            final ToXContent.Params compareFormatParams = new ToXContent.MapParams(compareParams);  
                            localClusterState.stateUUID()  
        return settingsBuilder.build();  
        ClusterHealthStatus clusterHealthStatus,
     */
        logger.info("--> creating repository [{}] [{}]", repoName, type);  
    @AfterClass
    }  
        }
    }
                routingTableRepoName,
     * This method uses allocation deciders to filter out certain nodes to allocate the created index on. It defines allocation
     */
    /**
                        + XContentHelper.convertToMap(parsedBytes, false, XContentType.SMILE),  
                }
     * Waits until at least a give number of document is indexed by indexer
            return internalCluster().getInstance(NamedXContentRegistry.class);  
        return builder;
            .indices()
    public final void createIndex(String name, Context context) {
        }
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
                indexMetadata.toXContent(compareBuilder, compareFormatParams);  
            final int maxMergeCount = RandomNumbers.randomIntBetween(random, maxThreadCount, maxThreadCount + 4);
    /**
        ClusterScope annotation = getAnnotation(this.getClass(), ClusterScope.class);  
     */  
import org.opensearch.action.admin.indices.segments.IndexSegments;  
                    postIndexAsyncActions(indicesArray, inFlightAsyncOperations, maybeFlush);
            );
        updateSettingsRequest.persistentSettings(settings);
                    .execute(new LatchedActionListener<>(newLatch(inFlightAsyncOperations)));
                .put(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING.getKey(), "zone")  
                routingTableRepoName
 * <li>-D{@value #TESTS_ENABLE_MOCK_MODULES} - a boolean value to enable or disable mock modules. This is
    }
        );
            // otherwise, use it, it has assertions and so on that can find bugs.
        ClusterHealthResponse clusterHealthResponse = client(viaNode).admin()  
    }  
        if (cluster() != null && cluster().size() > 0) {
        for (Tuple<IndexRequestBuilder, Exception> tuple : errors) {
            .setWaitForEvents(Priority.LANGUID)  
    protected boolean addMockHttpTransport() {
            segmentRepoPath,
                    );
            PutIndexTemplateRequestBuilder putTemplate = client().admin()
import org.opensearch.index.IndexService;
    }
            mockPlugins = mocks;
        String translogRepoName,
import static org.opensearch.discovery.DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING;  
                mocks.add(MockSearchService.TestPlugin.class);
    public void assertSortedSegments(String indexName, Sort expectedIndexSort) {  
        mocks.add(AssertActionNamePlugin.class);
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
                hotThreads
    }
        if (cluster().size() > 0) {  
        Settings.Builder featureSettings = Settings.builder();  
            final Client clusterManagerClient = client();
        );
        if (triggerRemoteStateRestore()) {
    protected static final int DEFAULT_MAX_NUM_SHARDS = 10;
            ),
     * Returns a function that allows to wrap / filter all clients that are exposed by the test cluster. This is useful  
    }  
import java.util.concurrent.atomic.AtomicInteger;
    }
        String segmentRepoSettingsAttributeKeyPrefix = String.format(
        public List<TransportInterceptor> getTransportInterceptors(
                .putNull(AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING.getKey())  
        private final CountDownLatch latch;
                for (Tuple<IndexRequestBuilder, Exception> tuple : errors) {
                Metadata metadataWithoutIndices = Metadata.builder(metadata).removeAllIndices().build();  
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;  
 * <p>
            // if the test class is annotated with SuppressCodecs("*"), it means don't use lucene's codec randomization  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;
     */
                assertThat("non index. prefix setting set on index template, its a node setting...", setting, startsWith("index."));
        Path translogRepoPath,
            Locale.getDefault(),
            .putList(DISCOVERY_SEED_PROVIDERS_SETTING.getKey(), "file")
        Settings.Builder settingsBuilder = Settings.builder();  
        String translogRepoName,
        if (randomBoolean()) {  
        Settings settings = value
            : annotation.minNumDataNodes();
        /**
     * already exists this method will fail and wipe all the indices created so far.
        ClusterScope annotation = getAnnotation(this.getClass(), ClusterScope.class);  
     * layout.
                .setPatterns(Collections.singletonList("*"))
 * useful to test the system without asserting modules that to make sure they don't hide any bugs in production.</li>  
            : annotation.maxNumDataNodes();
     * The value of this seed can be used to initialize a random context for a specific index.
                    DocWriteResponse.Result.DELETED,
     */
            // shut down. The following "waitForNodes" condition ensures that the node has been removed by the cluster-manager
     */
        if (!build.isEmpty()) {
        /**
     */  
        for (List<String> doc : bogusIds) {  
                remoteRoutingTableRepoName,
            mocks.add(MockHttpTransport.TestPlugin.class);
    }
            for (String setting : randomSettingsBuilder.keys()) {  
                assertThat(actionGet.hasFailures() ? actionGet.buildFailureMessage() : "", actionGet.hasFailures(), equalTo(false));  
            .prepareUpdateSettings(indices)  
import org.opensearch.common.xcontent.XContentType;
     *  
     * via the {@code tests.config} system property.
         */  
        if (Strings.hasLength(clusterAddresses) && ignoreExternalCluster() == false) {
        } else {  
            } else if (maybeFlush && rarely()) {
     * </pre>
import org.opensearch.action.search.SearchResponse;
    /**
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;  
    ) {
    }
        }
        assertThat(metadata.hasIndex(index), equalTo(true));
        final Index index = resolveIndex(indexName);
                        // Compare JSON serialization
                    } catch (final AssertionError error) {
        return prepareCreate(index, -1);  
import org.opensearch.index.MockEngineFactoryPlugin;
                IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(),  
    protected String primaryNodeName(String indexName, int shardId) {  
        assertThat(clusterHealthResponse.isTimedOut(), is(false));
    /**
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;  
    }  
        String segmentRepoType,
    ) {  
            builder.put(SETTING_NUMBER_OF_REPLICAS, numberOfReplicas).build();
            logger.debug("allowNodes: updating [{}]'s setting to [{}]", index, build.toDelimitedString(';'));  
        if (randomBoolean()) {  
                for (Segment segment : shardSegments) {
 * <p>  
    protected boolean triggerRemoteStateRestore() {
    }  
            boolean success = false;
            this.dataCopies = numReplicas + numSearchReplicas + 1;
    /**
    public static Settings remoteStoreClusterSettings(String name, Path path) {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoTimeout;
        String routingTableRepoName,
            try {
        Settings.Builder builder = Settings.builder()
            builder.put(TelemetrySettings.TRACER_ENABLED_SETTING.getKey(), true);
    protected final void flushAndRefresh(String... indices) {
     * Syntactic sugar for enabling allocation for <code>indices</code>
     */
                    .setIndicesOptions(IndicesOptions.lenientExpandOpen())  
 * <p>
            // If it's internal cluster - using existing registry in case plugin registered custom data
                    );
            int clusterManagerClusterStateSize = clusterManagerClusterState.toString().length();  
        }
     */
    protected ClusterState getClusterState() {  
        String timeout,
    public final CreateIndexRequestBuilder prepareCreate(String index, int numNodes) {  
                        // instead we compare the string length of cluster state - they should be the same  
            path = repoFiles[0].resolve(randomAlphaOfLength(10));
        ClusterHealthRequest healthRequest = Requests.clusterHealthRequest(indices)
    /**
import org.opensearch.core.xcontent.ToXContent;
                segmentRepoName,
     */  
     * multiple slices based on segment count.
 * </pre>
            this.numReplicas = numReplicas;  
    protected Collection<PluginInfo> additionalNodePlugins() {
    /**
            settings = Settings.builder()  
            this.totalNumShards = numPrimaries * dataCopies;  
        int numDataNodes = getNumDataNodes();
     */
            .waitForNoInitializingShards(waitForNoInitializingShards)  
                final Map<String, Object> localStateMap = convertToMap(localClusterState);
        return actionGet.isExists();  
        ClusterAdminClient adminClient,
import static org.opensearch.core.common.util.CollectionUtils.eagerPartition;
                compareBuilder.endObject();
     * Waits for all relocations and force merge all indices in the cluster to 1 segment.
        String color = clusterHealthStatus.name().toLowerCase(Locale.ROOT);
                "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
            } else {
        0,  
import org.opensearch.action.support.WriteRequest;  
        String routingTableRepositoryTypeAttributeKey = String.format(
     * more than <code>n</code> nodes.
        final NodeConfigurationSource nodeConfigurationSource = getNodeConfigSource();
    private ClusterHealthStatus ensureColor(  
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
                    throw e;  
    }
            serializationParams.put(Metadata.CONTEXT_MODE_PARAM, Metadata.CONTEXT_MODE_GATEWAY);  
    protected boolean forbidPrivateIndexSettings() {
        return true;
    public static final String TESTS_CLUSTER_NAME = "tests.clustername";
    protected boolean addMockTransportService() {
        return testClusterRule.getRestClient();  
    protected AdminClient admin() {
         * and there will be no dedicated cluster-manager (and data) nodes. Default is {@code false} which means
import org.opensearch.action.bulk.BulkRequestBuilder;
        Settings.Builder settings
                builder.put(CLUSTER_REPLICATION_TYPE_SETTING.getKey(), randomReplicationType);  
            builder.put(INDEX_DOC_ID_FUZZY_SET_FALSE_POSITIVE_PROBABILITY_SETTING.getKey(), randomDoubleBetween(0.01, 0.50, true));
     * {@link org.opensearch.cluster.NodeConnectionsService} will eventually reconnect but it's
import org.opensearch.cluster.service.ClusterService;
    }
                }
    /**  
            .get();
                ) {
    }
    private class PayloadLatchedActionListener<Response, T> extends LatchedActionListener<Response> {  
                if (clusterManagerClusterState.version() == localClusterState.version()  
     * @param timeout time out value to set on {@link ClusterHealthRequest}
     */  
            builder.put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), maxMergeCount);
                mocks.add(NodeMocksPlugin.class);
                        }
 * nodes in the cluster for each call to {@link #client()}. Test failures might only be reproducible if the correct  
        if (annotation != null) {  
        assert repoFiles.length > 0;
import org.opensearch.transport.TransportInterceptor;
        return (isMixedMode && isRemoteStoreMigrationDirection);  
        }  
        String routingTableRepoAttributeKey = null, routingTableRepoSettingsAttributeKeyPrefix = null;
        boolean supportsDedicatedMasters() default true;
    }
                sb.append("\n-> _index: [").append(hit.getIndex()).append("] id [").append(hit.getId()).append("]");  
                return OpenSearchIntegTestCase.this.nodeConfigPath(nodeOrdinal);  
import java.util.Collection;  
                        .getTotalHits()
        Settings.Builder settingsBuilder = Settings.builder();  
            getExcludeSettings(numNodes, builder);
     */  
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
                logger.debug("Error indexing doc: " + t.getMessage() + ", reindexing.");
            stateRepoName
                for (ShardRouting shardRouting : indexShardRoutingTable) {  
     * Ensures the cluster has a green state via the cluster health API. This method will also wait for relocations.  
import org.opensearch.common.util.concurrent.ThreadContext;
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, routingTableRepoName)
            inFlightAsyncOperations.remove(waitFor).await();
        String prefixModeVerificationSuffix = BlobStoreRepository.PREFIX_MODE_VERIFICATION_SETTING.getKey();
        }
        latches.add(l);
                "failed to reach a stable cluster of ["  
                        + " but got "
        }
import org.opensearch.action.search.ClearScrollResponse;  
                for (CountDownLatch operation : inFlightAsyncOperations) {
        try (final GatedCloseable<SegmentInfos> snapshot = shard.getSegmentInfosSnapshot()) {
        }  
    /** Enables an index block for the specified index */
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
            // Set the field data cache clean interval setting to 1s so assertBusy() can ensure cache is cleared post-test within its
            );  
                remoteRoutingTableRepoPath,
    public void indexRandom(boolean forceRefresh, boolean dummyDocuments, boolean maybeFlush, List<IndexRequestBuilder> builders)
            builder.put(INDEX_DOC_ID_FUZZY_SET_ENABLED_SETTING.getKey(), true);
        return true;
        Set<String> nodes = new HashSet<>();
                    }  
        }  
                false  
    /**  
    }  
                false  
        featureSettings.put(FeatureFlags.TELEMETRY_SETTING.getKey(), true);
     *   client().prepareIndex(index, type).setSource(source).execute().actionGet();
 * <p>  
        return clusterService.getSettings();
        GetIndexResponse getIndexResponse = client().admin().indices().prepareGetIndex().setIndices(index).get();  
            public Settings nodeSettings(int nodeOrdinal) {  
     * Syntactic sugar for:
        return false;
    /**
     * for debugging or request / response pre and post processing. It also allows to intercept all calls done by the test
        assertNoTimeout(client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).get());
     */
    }  
                                                    );
                translogRepoType,
            nodePlugins(),
    @Retention(RetentionPolicy.RUNTIME)
        return getAnnotation(clazz.getSuperclass(), annotationClass);  
                    indexRequestBuilder.setRefreshPolicy(WriteRequest.RefreshPolicy.NONE);
        return new NumShards(numShards, numReplicas, numSearchReplicas);
        }
            settings.put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, routingTableRepoName)
    static <A extends Annotation> A getAnnotation(Class<?> clazz, Class<A> annotationClass) {
    public static void afterClass() throws Exception {
                        .setSource("{}", MediaTypeRegistry.JSON)  
            .put(routingTableRepositorySettingsAttributeKeyPrefix + "location", randomRepoPath().toAbsolutePath())
                        // no progress - try to refresh for the next time  
     * by the given builder  
        if (random.nextBoolean()) {
     */
            Locale.getDefault(),
    /**
    protected void performRemoteStoreTestAction() {
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "1b")  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "1b")
        RefreshResponse actionGet = client().admin()  
                builder = SmileXContent.contentBuilder();
            final String hotThreads = client().admin()
    public static void putRepository(  
     * @param forceRefresh if {@code true} all involved indices are refreshed  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
     * are caught up with primary shard only when Segment Replication is enabled.  
        /**  
        Settings.Builder builder = Settings.builder();  
        ensureStableCluster(nodeCount, timeValue, false, null);  
            }
     */
    }  
        } else {
     * @param indexer a {@link BackgroundIndexer}. It will be first checked for documents indexed.
                try (
        int numSearchReplicas = numSearchReplicasValue != null ? Integer.parseInt(numSearchReplicasValue) : 0;  
        return client().prepareIndex(index).setId(id).setSource(source).execute().actionGet();
                    lastKnownCount = count;  
    protected boolean ignoreExternalCluster() {
     * Returns {@code true} if this test cluster can use a mock internal engine. Defaults to true.  
    }
 * should be used, here is an example:
                String id = "bogus_doc_" + randomRealisticUnicodeOfLength(unicodeLen) + dummmyDocIdGenerator.incrementAndGet();
                assertEquals(  
    ) {
                mocks.add(MockFSIndexStore.TestPlugin.class);
        do {  
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
        // this is just a temporary thing but it's easier to change if it is encapsulated.  
        String segmentRepoName,
            internalCluster().ensureAtLeastNumDataNodes(numNodes);
                                                    assertEquals(
                    .indices()
                }  
        return Collections.unmodifiableList(mocks);
        settingsBuilder.put(
            }
                assertThat(actualErrors, emptyIterable());
                    return actualHandler;
            String clusterManagerId = clusterManagerClusterState.nodes().getClusterManagerNodeId();
    public static Settings buildRemoteStateNodeAttributes(String stateRepoName, Path stateRepoPath, String stateRepoType) {
     *   once the documents are indexed. Additionally if {@code true} some
         * tests must manage these things explicitly.
    public CreateIndexRequestBuilder prepareCreate(String index, Settings.Builder settingsBuilder) {
            .setWaitForNodes(Integer.toString(nodeCount))
            assertThat(lastKnownCount, greaterThanOrEqualTo(numDocs));  
 * }
     * This method must be overridden by subclass to use random replication strategy.
     * that is executed in a separate test instance. Variables that need to be accessible across test instances must be static.  
     * Flushes and refreshes all indices in the cluster
            builder.put(MergeSchedulerConfig.AUTO_THROTTLE_SETTING.getKey(), false);  
     *                       all documents are indexed. This is useful to produce deleted documents on the server side.
    }  
            initialNodeSettings.put(NetworkModule.TRANSPORT_TYPE_KEY, getTestTransportType());
        }  
     * Default maximum number of shards for an index  
    }
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
         * a random number of nodes is used, where the minimum and maximum number of nodes  
        String segmentRepoName,
        int maxNumDataNodes;  
            // when tests are run with concurrent segment search enabled  
                    }  
    }
        }  
            return snapshot.get().version;
    public static Settings remoteStoreClusterSettings(
        if (clazz == Object.class || clazz == OpenSearchIntegTestCase.class) {
import org.opensearch.search.SearchHit;
import org.hamcrest.Matchers;
            logger.info(
import org.opensearch.common.Priority;
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                refresh(index);  
    private int getMinNumDataNodes() {  
            }
        if (actionGet.isTimedOut()) {
    public Set<String> assertAllShardsOnNodes(String index, String... pattern) {
    ) {
}
                for (IndexRequestBuilder indexRequestBuilder : builders) {
            return annotation;
 * system properties are passed to the test execution environment.
                    AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values",
        return DEFAULT_MIN_NUM_SHARDS;  
            client().admin().cluster().preparePendingClusterTasks().get()
 * </ul>
                final IndexMetadata loadedIndexMetadata;
 * A test cluster creates a set of nodes in the background before the test starts. The number of nodes in the cluster is  
         */
    }
import org.opensearch.transport.client.Requests;  
import org.opensearch.index.engine.Segment;
                        .setIndex(index)
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsResponse;
    /**
                .get()  
        for (int seg = 0; seg < numSegments; seg++) {
            .put(IndicesService.INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), "1s")
    }  
     */  
            Locale.getDefault(),
        if (random.nextBoolean()) {  
                        XContentHelper.convertToMap(compareOriginalBytes, false, XContentType.SMILE).v2(),
                    logger.debug("[{}] docs indexed. waiting for [{}]", lastKnownCount, numDocs);  
        }  
    );  
 * The OpenSearch Contributors require contributions made to  
            "Expected at least " + clusterHealthStatus + " but got " + actionGet.getStatus(),  
                tuple.v1().execute().actionGet(); // re-index if rejected
        String nodeId = clusterState.getRoutingTable().index(indexName).shard(0).replicaShards().get(0).currentNodeId();
     * This doesn't wait for inactive/non-started replica shards to become active/started.
        }  
                method,
     * Prints the current cluster state as debug logging.
            : Settings.builder().putNull(Metadata.SETTING_READ_ONLY_SETTING.getKey()).build();
                }  
                RandomNumbers.randomIntBetween(random, 100, 5000),
        CodecService.DEFAULT_CODEC,
                created.add(name);
    public static PutRepositoryRequestBuilder putRepositoryRequestBuilder(
            int numDocs = getNumShards(index).totalNumShards * randomIntBetween(2, 10);  
    /**
            Locale.getDefault(),  
    }
        return client;
        int numberOfReplicas = numberOfReplicas();  
        return builder;  
import org.opensearch.cluster.routing.ShardRouting;  
    }  
            assertAcked(putTemplate.execute().actionGet());
            .waitForNoRelocatingShards(waitForNoRelocatingShards)
 *     http://www.apache.org/licenses/LICENSE-2.0
        settings.put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), randomFrom(PathType.values()));
        for (Setting builtInFlag : FeatureFlagSettings.BUILT_IN_FEATURE_FLAGS) {
    }  
        // indexing threads can wait for up to ~1m before retrying when they first try to index into a shard which is not STARTED.  
        Settings settings;  
 *
                                }  
            null,
            this.errors = errors;  
            ClusterStateResponse stateResponse = client(viaNode).admin().cluster().prepareState().get();
     * These are tests the require a third-party service in order to run. They
    }
    private String randomStorageType;
                    logger.debug("[{}] docs visible for search (needed [{}])", lastKnownCount, numDocs);
            // We currently often use ensureGreen or ensureYellow to check whether the cluster is back in a good state after shutting down
            if (randomBoolean() && addMockTransportService()) {  
        public final int numPrimaries;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            translogRepoName,
        String uuid = getIndexResponse.getSettings().get(index).get(IndexMetadata.SETTING_INDEX_UUID);
            if (randomReplicationType.equals(ReplicationType.SEGMENT) && randomStorageType.equals("REMOTE_STORE")) {
import org.opensearch.index.remote.RemoteStoreEnums.PathType;  
            }
                }  
    }
    public static Client client() {  
         * Returns the scope. {@link OpenSearchIntegTestCase.Scope#SUITE} is default.  
                    if (shardRouting.currentNodeId() != null && index.equals(shardRouting.getIndexName())) {
    /**
import java.nio.file.Path;  
        indexRandom(forceRefresh, dummyDocuments, true, builders);
        } else {
    /**
                        );
            .put(translogRepoSettingsAttributeKeyPrefix + prefixModeVerificationSuffix, prefixModeVerificationEnable)
     * @see #waitForRelocation()
        }  
        if (random.nextBoolean()) {
        return between(minimumNumberOfShards(), maximumNumberOfShards());
    public ClusterHealthStatus ensureRed(String... indices) {  
                        + XContentHelper.convertToMap(compareOriginalBytes, false, XContentType.SMILE)
        String segmentRepoName,
                }  
     * </pre>
    /**  
                .setIgnoreIdleThreads(false)
 *  
     * Ensures the cluster has a yellow state via the cluster health API and ensures the that cluster has no initializing shards
        String stateRepoTypeAttributeKey = String.format(  
        // If you are indexing just a few documents then frequently do it one at a time. If many then frequently in bulk.
    @Retention(RetentionPolicy.RUNTIME)
                XContentBuilder compareBuilder = SmileXContent.contentBuilder();
                clusterHealth = client.admin().cluster().prepareHealth().setLocal(true).get();  
        // if the cluster is internal the deprecation logger is shared across all nodes
    protected Settings externalClusterClientSettings() {
        Path segmentRepoPath,
            Locale.getDefault(),  
    /**  
            .put(IndicesQueryCache.INDICES_QUERIES_CACHE_ALL_SEGMENTS_SETTING.getKey(), nodeOrdinal % 2 == 0)
                    .setIndicesOptions(IndicesOptions.lenientExpandOpen())  
        client().admin().indices().prepareUpdateSettings(index).setSettings(settings).get();
            long lastKnownCount = indexer.totalIndexedDocs();
     * Default minimum number of shards for an index
    @Deprecated
    public static Settings remoteStoreClusterSettings(  
        return testClusterRule.clientForNode(node);
            public Path nodeConfigPath(int nodeOrdinal) {
import java.util.HashSet;  
        Settings.Builder initialNodeSettings = Settings.builder();  
 */  
            );  
                    )
     * <p>
        putRepositoryRequestBuilder(adminClient, repoName, type, true, settings, null, false).execute(listener);
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
                .build();
                translogRepoName,  
        if (viaNode == null) {
        @NonNull String routingTableRepoName,
            final int numBogusDocs = scaledRandomIntBetween(1, builders.size() * 2);
     */
        Settings.Builder settingsBuilder = Settings.builder();
    ) {  
    public CreateIndexRequestBuilder prepareCreate(String index, int numNodes, Settings.Builder settingsBuilder) {  
     * it cannot be reused by other tests anymore.  
     * the checks and modifications that are applied to the used test cluster are only done after all tests
                        .setQuery(matchAllQuery())
                TimeUnit.MILLISECONDS
        waitForRelocation();
    protected void createRepository(String repoName, String type, Settings.Builder settings) {
    }  
            .indices()
    protected final IndexResponse index(String index, String type, String id, Map<String, Object> source) {
            client().admin().cluster().prepareState().get().getState(),  
            routingTableRepoName
     * @param dummyDocuments if {@code true} some empty dummy documents may be randomly inserted into the document list and deleted once  
    }  
     */
        );
    ) {
                (random.nextBoolean() ? random.nextDouble() : random.nextBoolean()).toString()
    /**
            @Override  
            SuppressCodecs annotation = getClass().getAnnotation(SuppressCodecs.class);
     * Used for selecting random replication strategy, either DOCUMENT or SEGMENT.
        return ensureColor(clusterHealthStatus, timeout, true, waitForNoInitializingShards, indices);  
        return false;  
            // integration tests that usually create few documents  
        String method = "ensure" + Strings.capitalize(color);
        return testClusterRule.isInternalCluster();
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
                for (IndexRequestBuilder indexRequestBuilder : builders) {  
import org.opensearch.cluster.ClusterState;
    protected void ensureStableCluster(int nodeCount, TimeValue timeValue, boolean local, @Nullable String viaNode) {
        String remoteRoutingTableRepoName,  
    ) {
    }
                mocks.add(getTestTransportPlugin());
            // a node. If the node that is stopped is the cluster-manager node, another node will become cluster-manager and publish a
    /**
            for (IndexMetadata indexMetadata : metadata) {  
            getClientWrapper(),  
            for (String index : indices) {  
            if (rarely()) {
            }
        String remoteStateRepositorySettingsAttributeKeyPrefix = String.format(  
    }
import org.opensearch.action.admin.indices.segments.IndexShardSegments;
     * <p>
                .build();
        }  
        }
                    boolean forceExecution,
     * <pre>
        featureSettings.put(FeatureFlags.APPLICATION_BASED_CONFIGURATION_TEMPLATES_SETTING.getKey(), true);  
    @TestGroup(enabled = false, sysProperty = OpenSearchIntegTestCase.SYSPROP_THIRDPARTY)
 * not use this file except in compliance with the License.
     * segment or if only one document is in a segment etc. This method prevents issues like this by randomizing the index  
                .putNull(AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING.getKey() + "zone.values")
 * Unless required by applicable law or agreed to in writing,
            routingTableRepoSettingsAttributeKeyPrefix = String.format(  
    }
        }
    }  
    public static Iterable<Client> clients() {
     *
        return 0;  
        mocks.add(MockScriptService.TestPlugin.class);  
            Locale.getDefault(),
        ForceMergeResponse actionGet = client().admin().indices().prepareForceMerge().setMaxNumSegments(1).execute().actionGet();
import org.opensearch.action.index.IndexRequestBuilder;
                builder.put(remoteStoreClusterSettings(REMOTE_BACKED_STORAGE_REPOSITORY_NAME, remoteStoreRepositoryPath));  
    public static boolean isInternalCluster() {  
            stateRepoName  
     * @param builders   the documents to index
    protected static NetworkDisruption isolateClusterManagerDisruption(NetworkDisruption.NetworkLinkDisruptionType disruptionType) {
            getExcludeSettings(n, builder);
        IndicesSegmentResponse segmentResponse = client().admin().indices().prepareSegments(indexName).execute().actionGet();
    ) {
    }
    protected static Boolean snapshotShardPathFixedPrefix;
            ? InternalTestCluster.DEFAULT_MIN_NUM_DATA_NODES  
 * <ul>
                        + XContentHelper.convertToMap(compareOriginalBytes, false, XContentType.SMILE)
         * dedicated cluster-manager nodes will be randomly used.
        return actionGet;
        return actionGet.getStatus();
            settings.put(BlobStoreRepository.SHARD_PATH_TYPE.getKey(), randomFrom(PathType.values()));  
            if (isInternalCluster()) {
        return actionGet.getStatus();
import org.opensearch.index.mapper.CompletionFieldMapper;  
            null,  
                    try {
                latch.countDown();
            sb.append(value).append("] results. expected [").append(expectedResults).append("]");  
                status,
     * In other words subclasses must ensure this method is idempotent.  
                        XContentHelper.convertToMap(parsedBytes, false, XContentType.SMILE).v2()  
            int to = (seg == numSegments - 1) ? builders.size() : from + batchSize;  
