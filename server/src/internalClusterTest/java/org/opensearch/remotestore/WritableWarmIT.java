        assertTrue(indexSettings.getAsBoolean(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false));
package org.opensearch.remotestore;
    }
        assertEquals(0, nonEmptyFileCacheNodes);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            fail();
    }
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            .build();
        } catch (Exception e) {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        // Verify from the cluster settings if the data locality is partial
import org.junit.Assert;
            .put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, false)
        // Asserting that search returns same number of docs as ingested
        Settings indexSettings = Settings.builder()
            fail("File Cache Stats should not be null");
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
                )
import org.opensearch.index.store.remote.filecache.FileCache;
import org.apache.lucene.store.Directory;
        // Ingesting some docs
    }
            .put(super.nodeSettings(0))
import org.opensearch.core.common.unit.ByteSizeUnit;
                        .put("index.number_of_replicas", 0)
     */
    public void testNoResizeOnWarm() {
        assertHitCount(searchResponse, NUM_DOCS_IN_BULK);
            .filter(file -> !FileTypeUtils.isSegmentsFile(file))
import org.opensearch.core.common.unit.ByteSizeValue;
    }
    }
        Settings idxSettings = Settings.builder()
            .put(SETTING_NUMBER_OF_REPLICAS, 0)
import java.util.stream.Collectors;
        // ensuring cluster is green after performing force-merge
                .get();
        Settings settings = Settings.builder()
        indexBulk(INDEX_NAME, NUM_DOCS_IN_BULK);
                .setSettings(
        // Ingesting docs again before force merge
        Settings.Builder featureSettings = Settings.builder();
        Set<String> filesAfterMerge = new HashSet<>(Arrays.asList(directory.listAll()));
        InternalTestCluster internalTestCluster = internalCluster();
    private boolean isFileCacheEmpty(AggregateFileCacheStats stats) {
        FileCache fileCache = internalTestCluster.getDataNodeInstance(Node.class).fileCache();
 * The OpenSearch Contributors require contributions made to
import org.opensearch.node.Node;
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
        assertAcked(prepareCreate(INDEX_NAME).setSettings(indexSettings).get());
        // Setting is now always registered (built-in), so index creation should succeed
import org.apache.lucene.store.FilterDirectory;
        Settings indexSettings = getIndexResponse.settings().get(INDEX_NAME);
        NodesStatsResponse nodesStatsResponse = client().admin().cluster().nodesStats(new NodesStatsRequest().all()).actionGet();
    }
        return stats.getUsed().getBytes() == 0L && stats.getActive().getBytes() == 0L;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
        // leaks
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME_2)).get());
            .put(super.indexSettings())
                .setResizeType(type)
// Uncomment the below line to enable trace level logs for this test for better debugging
            if (Objects.isNull(fcStats) == false) {
        // Force merging the index
            .getIndex(new GetIndexRequest().indices(INDEX_NAME).includeDefaults(true))
            .toList()
        return featureSettings.build();
        featureSettings.put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, true);
        assertAcked(client().admin().indices().prepareCreate(INDEX_NAME_2).setSettings(settings).get());
    }
        filesBeforeMerge.stream()
import org.opensearch.action.admin.indices.shrink.ResizeType;
            .filter(n -> n.getNode().isDataNode())
        assertTrue(filesFromPreviousGenStillPresent.isEmpty());
        // ensuring cluster is green
            .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
        SearchResponse searchResponse = client().prepareSearch(INDEX_NAME_2).setQuery(QueryBuilders.matchAllQuery()).get();
import org.opensearch.action.admin.indices.get.GetIndexResponse;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        fileCache.prune();
import static org.hamcrest.core.StringContains.containsString;
            .getFileCacheStats();
    protected Settings nodeSettings(int nodeOrdinal) {
        assertHitCount(searchResponse, NUM_DOCS_IN_BULK);
        internalTestCluster.startDataAndWarmNodes(1);
        }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    public void testFullFileAndFileCacheStats() throws ExecutionException, InterruptedException {
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
import org.opensearch.index.query.QueryBuilders;
        }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
/*
            .filter(file -> !FileTypeUtils.isSegmentsFile(file))
            client().admin()
import org.opensearch.common.settings.Settings;
        InternalTestCluster internalTestCluster = internalCluster();
        internalTestCluster.startDataAndWarmNodes(1);
            .filter(file -> !FileTypeUtils.isLockFile(file))
    public void testWritableWarmSettingAcceptedWhenFeatureFlagDisabled() {
        AggregateFileCacheStats fileCacheStats = nodesStatsResponse.getNodes()
                if (isFileCacheEmpty(fcStats) == false) {
    protected boolean addMockIndexStorePlugin() {
            }
import org.opensearch.indices.IndicesService;
            .build();
        InternalTestCluster internalTestCluster = internalCluster();
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        assertAcked(client().admin().indices().prepareCreate(INDEX_NAME).setSettings(settings).get());
            .getFirst()
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.index.store.CompositeDirectory;
import org.opensearch.common.util.FeatureFlags;
        ensureGreen();
        if (Objects.isNull(fileCacheStats)) {
        FileCache fileCache = internalTestCluster.getDataNodeInstance(Node.class).fileCache();
        internalTestCluster.startClusterManagerOnlyNode(clusterSettings);
    protected Settings featureFlagSettings() {
        Set<String> filesBeforeMerge = new HashSet<>(Arrays.asList(directory.listAll()));
        indexBulk(INDEX_NAME_2, NUM_DOCS_IN_BULK);
        return Settings.builder()
 *
}
            .filter(file -> !FileTypeUtils.isLockFile(file))
import org.opensearch.index.IndexModule;
        // Asserting that search returns same number of docs as ingested
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .getShardOrNull(0);
        flushAndRefresh(INDEX_NAME);
        try {
        }
    @Override
    protected static final String INDEX_NAME = "test-idx-1";
                        .put("index.number_of_shards", 2)
import org.opensearch.action.admin.indices.get.GetIndexRequest;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
    @Override
            .collect(Collectors.toUnmodifiableSet());
import java.util.concurrent.ExecutionException;
            .get();
import java.util.HashSet;
        SearchResponse searchResponse = client().prepareSearch(INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).get();
        // leaks
import java.util.Set;
        internalTestCluster.startClusterManagerOnlyNode();
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
import org.opensearch.test.InternalTestCluster;
    public void testWritableWarmBasic() throws Exception {
        indexBulk(INDEX_NAME, NUM_DOCS_IN_BULK);
        internalTestCluster.startClusterManagerOnlyNode();
        int nonEmptyFileCacheNodes = 0;
            .stream()
        // TODO: Make these validation more robust, when SwitchableIndexInput is implemented.
 * compatible open source license.
        flushAndRefresh(INDEX_NAME);
        return false;
        NodesStatsResponse response = client().admin().cluster().nodesStats(new NodesStatsRequest().all()).actionGet();
        ensureGreen(INDEX_NAME);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, supportsDedicatedMasters = false)
        internalTestCluster.startClusterManagerOnlyNode();
 * this file be licensed under the Apache-2.0 license or a
    @Override
    protected static final int NUM_DOCS_IN_BULK = 1000;
            .build();
        Settings clusterSettings = Settings.builder()
        internalCluster().startDataAndWarmNodes(1).get(0);
    Disabling MockFSIndexStore plugin as the MockFSDirectoryFactory wraps the FSDirectory over a OpenSearchMockDirectoryWrapper which extends FilterDirectory (whereas FSDirectory extends BaseDirectory)
import org.opensearch.cluster.metadata.IndexMetadata;
            AggregateFileCacheStats fcStats = stats.getFileCacheStats();
        InternalTestCluster internalTestCluster = internalCluster();
            .put(SETTING_NUMBER_OF_SHARDS, 2)
            .put(super.nodeSettings(nodeOrdinal))
        // Deleting the index (so that ref count drops to zero for all the files) and then pruning the cache to clear it to avoid any file
import org.opensearch.indices.replication.common.ReplicationType;
                }
                .indices()
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
 * SPDX-License-Identifier: Apache-2.0
    /*
                .prepareResizeIndex(INDEX_NAME, "target")
import java.util.Objects;
    }
                    nonEmptyFileCacheNodes++;
        flushAndRefresh(INDEX_NAME);
                        .build()
    As a result of this wrapping the local directory of Composite Directory does not satisfy the assertion that local directory must be of type FSDirectory
            .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
 */
        // Deleting the index (so that ref count drops to zero for all the files) and then pruning the cache to clear it to avoid any file
import org.opensearch.index.store.remote.utils.FileTypeUtils;
        for (NodeStats stats : response.getNodes()) {
        // Asserting that files from previous gen are not present in File Cache as well
        internalTestCluster.startDataAndWarmNodes(1);
        ByteSizeValue cacheSize = new ByteSizeValue(16, ByteSizeUnit.GB);
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
        client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).get();
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
            .filter(filesAfterMerge::contains)
            .build();
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
// @TestLogging(reason = "Getting trace logs from composite directory package", value = "org.opensearch.index.store:TRACE")
        // even when the feature flag is disabled
        client().admin().indices().prepareUpdateSettings(INDEX_NAME).setSettings(Settings.builder().put("index.blocks.write", true)).get();
        createIndex(INDEX_NAME, idxSettings);
                        .putNull("index.blocks.write")
            .build();
import org.opensearch.action.search.SearchResponse;
                    Settings.builder()
            .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false)
        Directory directory = (((FilterDirectory) (((FilterDirectory) (shard.store().directory())).getDelegate())).getDelegate());
public class WritableWarmIT extends RemoteStoreBaseIntegTestCase {
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
        // Asserting that after merge all the files from previous gen are no more part of the directory
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        fileCache.prune();
import org.opensearch.index.shard.IndexShard;
            Assert.assertThat(e.getMessage(), containsString("cannot resize warm index"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        Set<String> filesFromPreviousGenStillPresent = filesBeforeMerge.stream()
        Settings settings = Settings.builder()
        // Ingesting docs again before force merge
        ResizeType type = randomFrom(ResizeType.CLONE, ResizeType.SHRINK, ResizeType.SPLIT);
            .build();
            .indexService(resolveIndex(INDEX_NAME))
        GetIndexResponse getIndexResponse = client().admin()
        IndexShard shard = internalTestCluster.getDataNodeInstance(IndicesService.class)
import org.opensearch.test.OpenSearchIntegTestCase;
            .forEach(file -> assertNull(fileCache.get(((CompositeDirectory) directory).getFilePath(file))));
        flushAndRefresh(INDEX_NAME_2);
        flushAndRefresh(INDEX_NAME_2);
        ensureGreen();
            .indices()
        indexBulk(INDEX_NAME_2, NUM_DOCS_IN_BULK);
import java.util.Arrays;
    protected static final String INDEX_NAME_2 = "test-idx-2";
        // Ingesting docs again before force merge
