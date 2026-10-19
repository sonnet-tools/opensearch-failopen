        Settings clusterSettings = Settings.builder()
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
import org.opensearch.cluster.metadata.IndexMetadata;
import java.util.Set;  
    }  
            .filter(file -> !FileTypeUtils.isSegmentsFile(file))
            .build();
    }
        assertAcked(client().admin().indices().prepareCreate(INDEX_NAME_2).setSettings(settings).get());  
     */
            .build();
    public void testNoResizeOnWarm() {  
            .filter(n -> n.getNode().isDataNode())
        return Settings.builder()  
        flushAndRefresh(INDEX_NAME_2);
            .indices()
        internalTestCluster.startDataAndWarmNodes(1);
        InternalTestCluster internalTestCluster = internalCluster();  
import org.apache.lucene.store.Directory;  
import java.util.HashSet;
    /*
        assertEquals(0, nonEmptyFileCacheNodes);
            .put(super.nodeSettings(0))
                        .putNull("index.blocks.write")  
        } catch (Exception e) {
        indexBulk(INDEX_NAME, NUM_DOCS_IN_BULK);
                .indices()
        Directory directory = (((FilterDirectory) (((FilterDirectory) (shard.store().directory())).getDelegate())).getDelegate());
            .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
                .prepareResizeIndex(INDEX_NAME, "target")  
            .stream()  
        internalCluster().startDataAndWarmNodes(1).get(0);  
        createIndex(INDEX_NAME, idxSettings);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertHitCount(searchResponse, NUM_DOCS_IN_BULK);
            .get();  
        assertTrue(indexSettings.getAsBoolean(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false));
            .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
import org.opensearch.node.Node;
        // Ingesting docs again before force merge
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
    private boolean isFileCacheEmpty(AggregateFileCacheStats stats) {
        AggregateFileCacheStats fileCacheStats = nodesStatsResponse.getNodes()
        // Ingesting some docs
            fail();
            .put(SETTING_NUMBER_OF_SHARDS, 2)
                .setSettings(
        ensureGreen();  
        client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).get();  
        assertAcked(prepareCreate(INDEX_NAME).setSettings(indexSettings).get());  
 * this file be licensed under the Apache-2.0 license or a
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)  
            .indexService(resolveIndex(INDEX_NAME))  
import org.opensearch.index.store.remote.utils.FileTypeUtils;
        // Asserting that files from previous gen are not present in File Cache as well
        SearchResponse searchResponse = client().prepareSearch(INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).get();
                    nonEmptyFileCacheNodes++;  
    protected Settings featureFlagSettings() {  
            .getFirst()  
            .collect(Collectors.toUnmodifiableSet());
    protected Settings nodeSettings(int nodeOrdinal) {
        for (NodeStats stats : response.getNodes()) {
import java.util.stream.Collectors;
        internalTestCluster.startClusterManagerOnlyNode();
 * compatible open source license.
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
import org.apache.lucene.store.FilterDirectory;
            .build();
    protected static final String INDEX_NAME = "test-idx-1";
        internalTestCluster.startClusterManagerOnlyNode(clusterSettings);
        }  
            Assert.assertThat(e.getMessage(), containsString("cannot resize warm index"));  
            .filter(file -> !FileTypeUtils.isSegmentsFile(file))
        indexBulk(INDEX_NAME_2, NUM_DOCS_IN_BULK);  
        }
    @Override  
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        assertTrue(filesFromPreviousGenStillPresent.isEmpty());
        flushAndRefresh(INDEX_NAME);  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            .forEach(file -> assertNull(fileCache.get(((CompositeDirectory) directory).getFilePath(file))));
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
        // TODO: Make these validation more robust, when SwitchableIndexInput is implemented.
        FileCache fileCache = internalTestCluster.getDataNodeInstance(Node.class).fileCache();
import org.opensearch.action.admin.indices.get.GetIndexResponse;
        InternalTestCluster internalTestCluster = internalCluster();
        assertHitCount(searchResponse, NUM_DOCS_IN_BULK);
            }
        ResizeType type = randomFrom(ResizeType.CLONE, ResizeType.SHRINK, ResizeType.SPLIT);
 * SPDX-License-Identifier: Apache-2.0
            .put(super.nodeSettings(nodeOrdinal))
        Set<String> filesAfterMerge = new HashSet<>(Arrays.asList(directory.listAll()));
public class WritableWarmIT extends RemoteStoreBaseIntegTestCase {
        Settings settings = Settings.builder()
        // Force merging the index
            .build();
    }
                        .build()
            .filter(file -> !FileTypeUtils.isLockFile(file))  
import static org.hamcrest.core.StringContains.containsString;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
                .get();  
                )
        internalTestCluster.startClusterManagerOnlyNode();
        // Asserting that search returns same number of docs as ingested
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        fileCache.prune();
            .getFileCacheStats();
        // leaks
import org.opensearch.index.shard.IndexShard;
                if (isFileCacheEmpty(fcStats) == false) {
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
    }
        // Ingesting docs again before force merge
    @Override  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, supportsDedicatedMasters = false)
import org.junit.Assert;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
                        .put("index.number_of_replicas", 0)
        flushAndRefresh(INDEX_NAME);
import org.opensearch.test.OpenSearchIntegTestCase;  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
import org.opensearch.core.common.unit.ByteSizeValue;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        internalTestCluster.startDataAndWarmNodes(1);
        filesBeforeMerge.stream()
                        .put("index.number_of_shards", 2)
            AggregateFileCacheStats fcStats = stats.getFileCacheStats();  
            .filter(file -> !FileTypeUtils.isLockFile(file))  
        Set<String> filesFromPreviousGenStillPresent = filesBeforeMerge.stream()
    protected static final String INDEX_NAME_2 = "test-idx-2";
import org.opensearch.test.InternalTestCluster;
import java.util.concurrent.ExecutionException;
            .build();
import org.opensearch.index.IndexModule;  
        ensureGreen();
        SearchResponse searchResponse = client().prepareSearch(INDEX_NAME_2).setQuery(QueryBuilders.matchAllQuery()).get();  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        indexBulk(INDEX_NAME_2, NUM_DOCS_IN_BULK);
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
        Settings.Builder featureSettings = Settings.builder();
        // leaks
            .build();  
        // Setting is now always registered (built-in), so index creation should succeed
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
/*  
import org.opensearch.common.settings.Settings;
            .getIndex(new GetIndexRequest().indices(INDEX_NAME).includeDefaults(true))
import java.util.Arrays;  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .toList()
    public void testWritableWarmBasic() throws Exception {  
        InternalTestCluster internalTestCluster = internalCluster();
 */  
        featureSettings.put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, true);
        Set<String> filesBeforeMerge = new HashSet<>(Arrays.asList(directory.listAll()));
        if (Objects.isNull(fileCacheStats)) {  
        NodesStatsResponse nodesStatsResponse = client().admin().cluster().nodesStats(new NodesStatsRequest().all()).actionGet();  
        Settings idxSettings = Settings.builder()
        // even when the feature flag is disabled
    }  
            .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false)
        // Asserting that search returns same number of docs as ingested  
import java.util.Objects;
                .setResizeType(type)
import org.opensearch.action.admin.indices.get.GetIndexRequest;  
        FileCache fileCache = internalTestCluster.getDataNodeInstance(Node.class).fileCache();
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;  
        ByteSizeValue cacheSize = new ByteSizeValue(16, ByteSizeUnit.GB);
        return false;
    }
    }
    protected static final int NUM_DOCS_IN_BULK = 1000;  
    protected boolean addMockIndexStorePlugin() {
        fileCache.prune();
        return featureSettings.build();  
            .getShardOrNull(0);
import org.opensearch.action.admin.indices.shrink.ResizeType;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME_2)).get());  
        try {  
        // Verify from the cluster settings if the data locality is partial
        Settings indexSettings = getIndexResponse.settings().get(INDEX_NAME);
        Settings settings = Settings.builder()
                    Settings.builder()  
// Uncomment the below line to enable trace level logs for this test for better debugging  
import org.opensearch.index.store.remote.filecache.FileCache;  
    public void testWritableWarmSettingAcceptedWhenFeatureFlagDisabled() {  
        }
        internalTestCluster.startClusterManagerOnlyNode();
    @Override
            .put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, false)  
import org.opensearch.action.search.SearchResponse;  
        // Asserting that after merge all the files from previous gen are no more part of the directory
    public void testFullFileAndFileCacheStats() throws ExecutionException, InterruptedException {
import org.opensearch.core.common.unit.ByteSizeUnit;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
}  
            .filter(filesAfterMerge::contains)
    As a result of this wrapping the local directory of Composite Directory does not satisfy the assertion that local directory must be of type FSDirectory
        flushAndRefresh(INDEX_NAME_2);  
            if (Objects.isNull(fcStats) == false) {
        // ensuring cluster is green after performing force-merge
            .put(SETTING_NUMBER_OF_REPLICAS, 0)
        indexBulk(INDEX_NAME, NUM_DOCS_IN_BULK);
package org.opensearch.remotestore;
    Disabling MockFSIndexStore plugin as the MockFSDirectoryFactory wraps the FSDirectory over a OpenSearchMockDirectoryWrapper which extends FilterDirectory (whereas FSDirectory extends BaseDirectory)  
import org.opensearch.indices.replication.common.ReplicationType;  
        client().admin().indices().prepareUpdateSettings(INDEX_NAME).setSettings(Settings.builder().put("index.blocks.write", true)).get();
// @TestLogging(reason = "Getting trace logs from composite directory package", value = "org.opensearch.index.store:TRACE")
        NodesStatsResponse response = client().admin().cluster().nodesStats(new NodesStatsRequest().all()).actionGet();  
        GetIndexResponse getIndexResponse = client().admin()  
        IndexShard shard = internalTestCluster.getDataNodeInstance(IndicesService.class)
        flushAndRefresh(INDEX_NAME);
    }
        internalTestCluster.startDataAndWarmNodes(1);  
        // Ingesting docs again before force merge  
        assertAcked(client().admin().indices().prepareCreate(INDEX_NAME).setSettings(settings).get());  
        Settings indexSettings = Settings.builder()
        // Deleting the index (so that ref count drops to zero for all the files) and then pruning the cache to clear it to avoid any file
        ensureGreen(INDEX_NAME);  
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        InternalTestCluster internalTestCluster = internalCluster();  
import org.opensearch.indices.IndicesService;
import org.opensearch.index.store.CompositeDirectory;  
        return stats.getUsed().getBytes() == 0L && stats.getActive().getBytes() == 0L;  
            client().admin()
 *
import org.opensearch.common.util.FeatureFlags;  
        // Deleting the index (so that ref count drops to zero for all the files) and then pruning the cache to clear it to avoid any file
 * The OpenSearch Contributors require contributions made to  
            .put(super.indexSettings())
        int nonEmptyFileCacheNodes = 0;
import org.opensearch.index.query.QueryBuilders;
        // ensuring cluster is green  
            fail("File Cache Stats should not be null");
                }
