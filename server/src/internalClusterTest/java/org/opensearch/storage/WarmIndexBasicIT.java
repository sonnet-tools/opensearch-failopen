        // create a warm index with 1p0r configuration
 * this file be licensed under the Apache-2.0 license or a
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertHitCount(searchResponse, NUM_DOCS_IN_BULK);  
        assertTrue(filesFromPreviousGenStillPresent.isEmpty());
        }, 30, TimeUnit.SECONDS);
     * BucketedCompositeDirectory) to find the underlying TieredDirectory.
import org.opensearch.action.admin.indices.open.OpenIndexRequest;
 * compatible open source license.
import org.opensearch.action.admin.indices.close.CloseIndexRequest;
        SearchResponse searchResponse = client().prepareSearch(INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).get();
            .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)  
    /**  
        FileCache fileCache = internalTestCluster.getDataNodeInstance(Node.class).fileCache();  
        // ensuring cluster is green after performing force-merge  
            .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
            .getIndex(new GetIndexRequest().indices(INDEX_NAME).includeDefaults(true))
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;  
        internalTestCluster.startDataAndWarmNodes(1);  
import java.util.Set;
    }
    @Override  
            }  
        featureSettings.put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, true);
                return (TieredDirectory) current;
            .filter(file -> !FileTypeUtils.isLockFile(file))
        InternalTestCluster internalTestCluster = internalCluster();
        long docCount = getDocCount(INDEX_NAME);  
        assertAcked(client().admin().indices().prepareCreate(INDEX_NAME).setSettings(settings).get());
            .put(IndexModule.INDEX_COMPOSITE_STORE_TYPE_SETTING.getKey(), "tiered-storage")
            .put(IndexModule.INDEX_COMPOSITE_STORE_TYPE_SETTING.getKey(), "tiered-storage")
            .indices()  
        // Deleting the index to avoid any file leaks
        Set<String> filesBeforeMerge = new HashSet<>(Arrays.asList(directory.listAll()));
        return response.getHits().getTotalHits().value();  
import org.opensearch.action.admin.indices.get.GetIndexResponse;  
        client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).get();
        flushAndRefresh(INDEX_NAME);
        assertHitCount(searchResponse, NUM_DOCS_IN_BULK);  
/**
    }
            .get();
        indexBulk(INDEX_NAME, NUM_DOCS_IN_BULK);  
            .filter(file -> !FileTypeUtils.isLockFile(file))  
        return featureSettings.build();  
        // Ingesting docs again before force merge
            .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
    protected static final String INDEX_NAME = "test-idx-1";
            .getIndex(new GetIndexRequest().indices(INDEX_NAME).includeDefaults(true))
    }  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.test.InternalTestCluster;
            .build();
        internalTestCluster.startDataAndWarmNodes(2);  
        OpenIndexResponse openIndexResponse = client().admin().indices().open(new OpenIndexRequest(INDEX_NAME)).get();
        ensureGreen();
/*  
    }
    public void testLocalDirectoryFilesAfterRefresh() throws Exception {
        // ensuring cluster is green after performing force-merge  
    }  
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
    public void testCloseIndex() throws ExecutionException, InterruptedException {  
        refresh(indexName);
        SearchResponse searchResponse = client().prepareSearch(INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).get();
            .get();
            .filter(filesAfterMerge::contains)
        indexBulk(INDEX_NAME, NUM_DOCS_IN_BULK);
import java.util.concurrent.ExecutionException;  
    public void testWritableWarm() throws Exception {  
        flushAndRefresh(INDEX_NAME);
        InternalTestCluster internalTestCluster = internalCluster();  
        indexBulk(INDEX_NAME, NUM_DOCS_IN_BULK);  
    protected Settings featureFlagSettings() {  
        long docCountUpdated = getDocCount(INDEX_NAME);
            Arrays.stream(tieredDirectory.listLocalFiles())
import org.opensearch.storage.directory.TieredDirectory;
        assertTrue(indexSettings.getAsBoolean(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false));
            .build();  
import org.opensearch.index.query.QueryBuilders;
import org.opensearch.action.admin.indices.get.GetIndexRequest;
import org.opensearch.index.store.remote.filecache.FileCache;
import java.util.stream.Collectors;
        CloseIndexResponse closeIndexResponse = client().admin().indices().close(new CloseIndexRequest(INDEX_NAME)).get();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.metadata.IndexMetadata;
        return Settings.builder()  
        indexBulk(INDEX_NAME, NUM_DOCS_IN_BULK);  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import org.opensearch.common.settings.Settings;
import java.util.Arrays;  
        Directory directory = unwrapToCompositeDirectory(shard.store().directory());
        assertAcked(client().admin().indices().prepareCreate(INDEX_NAME).setSettings(settings).get());  
        IndexShard shard = internalTestCluster.getDataNodeInstance(IndicesService.class)
    protected boolean addMockIndexStorePlugin() {
 *  
            .filter(file -> !FileTypeUtils.isSegmentsFile(file))
            .indexService(resolveIndex(INDEX_NAME))  
        ensureGreen();
    protected long getDocCount(String indexName) {  
}
            return (TieredDirectory) current;
        waitForReplication(INDEX_NAME);
        ByteSizeValue cacheSize = new ByteSizeValue(1, ByteSizeUnit.GB);
        Directory current = directory;
            .forEach(file -> assertNull(fileCache.get(compositeDir.getFilePath(file))));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        waitForReplication(INDEX_NAME);
        throw new IllegalArgumentException("Expected CompositeDirectory but got: " + directory.getClass().getName());  
        flushAndRefresh(INDEX_NAME);
import org.opensearch.index.store.remote.utils.FileTypeUtils;  
import org.opensearch.action.search.SearchResponse;  
            .get();
    /**  
        // Asserting that files from previous gen are not present in File Cache as well  
        Settings indexSettings = getIndexResponse.settings().get(INDEX_NAME);  
                .filter(file -> !file.contains("block"))
     */  
            .indices()  
        GetIndexResponse getIndexResponse = client().admin()
    }  
import java.io.IOException;
        ensureGreen();
import org.apache.lucene.store.FilterDirectory;
        // ensuring cluster is green after performing force-merge
        flushAndRefresh(INDEX_NAME);
import org.apache.lucene.store.Directory;  
        assertAcked(client().admin().indices().prepareCreate(INDEX_NAME).setSettings(settings).get());
        // Asserting that after merge all the files from previous gen are no more part of the directory  
        Settings settings = Settings.builder()  
        }
            .collect(Collectors.toUnmodifiableSet());
            current = ((FilterDirectory) current).getDelegate();
        // Verify from the cluster settings if the warm index setting is true
        return true;
        Settings settings = Settings.builder()
        searchResponse = client().prepareSearch(INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).get();  
    private static Directory unwrapToCompositeDirectory(Directory directory) {
        Settings indexSettings = getIndexResponse.settings().get(INDEX_NAME);
        assertTrue(openIndexResponse.isShardsAcknowledged());
     * Unwraps the directory chain (walking through FilterDirectory wrappers including
        // Ingesting docs again before force merge
        internalTestCluster.startDataAndWarmNodes(1);
 *
        assertTrue(  
            return current;
        // Ingesting some docs
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());  
            .indexService(resolveIndex(INDEX_NAME))
import org.opensearch.indices.IndicesService;
            }
        GetIndexResponse getIndexResponse = client().admin()
        flushAndRefresh(INDEX_NAME);  
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
        TieredDirectory tieredDirectory = unwrapToTieredDirectory(shard.store().directory());  
        // Deleting the index to avoid any file leaks
        ensureGreen();
        assertEquals(docCountUpdated, docCount);
     * Unwraps the directory chain (walking through FilterDirectory wrappers including
        Set<String> filesFromPreviousGenStillPresent = filesBeforeMerge.stream()  
        // Ingesting some docs
        internalTestCluster.startDataAndWarmNodes(2);
        SearchResponse response = client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).setSize(0).get();
 * @opensearch.experimental
    protected Settings nodeSettings(int nodeOrdinal) {
        indexBulk(INDEX_NAME, NUM_DOCS_IN_BULK);  
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)  
        // create a tiered-storage warm index with 1p0r configuration
        filesBeforeMerge.stream()
        InternalTestCluster internalTestCluster = internalCluster();  
        Settings indexSettings = getIndexResponse.settings().get(INDEX_NAME);  
        InternalTestCluster internalTestCluster = internalCluster();
        assertTrue(indexSettings.getAsBoolean(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false));
import org.opensearch.core.common.unit.ByteSizeUnit;
import org.opensearch.core.common.unit.ByteSizeValue;
        if (current instanceof CompositeDirectory) {  
    }
        assertTrue(indexSettings.getAsBoolean(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false));  
        // Asserting that search returns same number of docs as ingested
            .indices()
            }  
import org.opensearch.test.OpenSearchIntegTestCase;  
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, supportsDedicatedMasters = false)
            .build();  
    }
            } catch (IOException ignored) {
        flushAndRefresh(INDEX_NAME);
        Settings settings = Settings.builder()  
        assertTrue(closeIndexResponse.isShardsAcknowledged());
        // Ingesting some docs  
    protected boolean ignoreExternalCluster() {
        // Verify from the cluster settings if the warm index setting is true  
 * Integration tests for basic warm index operations.
 * The OpenSearch Contributors require contributions made to  
            if (current instanceof TieredDirectory) {
import java.util.concurrent.TimeUnit;
import org.opensearch.action.admin.indices.close.CloseIndexResponse;  
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
            if (current instanceof CompositeDirectory) {
        internalTestCluster.startClusterManagerOnlyNode();
    @Override  
                .findAny()
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    private static TieredDirectory unwrapToTieredDirectory(Directory directory) {
    public void testWritableWarmPrimaryReplicaBoth() throws Exception {
    @Override
        internalTestCluster.startClusterManagerOnlyNode();
            .put(IndexModule.INDEX_COMPOSITE_STORE_TYPE_SETTING.getKey(), "tiered-storage")
        while (current instanceof FilterDirectory) {  
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
import org.opensearch.action.admin.indices.open.OpenIndexResponse;
            .getShardOrNull(0);  
            .put(IndexModule.INDEX_COMPOSITE_STORE_TYPE_SETTING.getKey(), "tiered-storage")
        Directory current = directory;
    }
 */  
     */  
                return false;  
                .isEmpty()
public class WarmIndexBasicIT extends RemoteStoreBaseIntegTestCase {
        // Force merging the index  
        flushAndRefresh(INDEX_NAME);
                return current;
     * BucketedCompositeDirectory) to find the underlying CompositeDirectory.
            .filter(file -> !FileTypeUtils.isSegmentsFile(file))  
        internalTestCluster.startClusterManagerOnlyNode();
        }
        // verify again after force merge search response return same no of docs as ingested
        CompositeDirectory compositeDir = (CompositeDirectory) directory;
        GetIndexResponse getIndexResponse = client().admin()
import java.util.HashSet;
        return false;  
        // Asserting that search returns same number of docs as ingested
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        indexBulk(INDEX_NAME, NUM_DOCS_IN_BULK);
        throw new IllegalArgumentException("Expected TieredDirectory but got: " + directory.getClass().getName());  
            .build();  
        while (current instanceof FilterDirectory) {  
            .build();
    }
            .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)  
import org.opensearch.common.util.FeatureFlags;  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
 */
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        Settings settings = Settings.builder()
        IndexShard shard = internalTestCluster.getDataNodeInstance(IndicesService.class)
            try {  
    @Override
            .getShardOrNull(0);
    protected static final int NUM_DOCS_IN_BULK = 1000;
        Set<String> filesAfterMerge = new HashSet<>(Arrays.asList(directory.listAll()));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // Verify from the cluster settings that the warm setting is true
import org.opensearch.index.IndexModule;  
            current = ((FilterDirectory) current).getDelegate();
        // Deleting the index to avoid any file leaks
        Settings.Builder featureSettings = Settings.builder();
import org.opensearch.index.store.CompositeDirectory;  
        // Force merging the index  
        waitUntil(() -> {
package org.opensearch.storage;
        if (current instanceof TieredDirectory) {  
        }
        refresh(INDEX_NAME);  
        }
            .put(super.nodeSettings(nodeOrdinal))
import org.opensearch.index.shard.IndexShard;
import org.opensearch.node.Node;
    }  
        );  
            .getIndex(new GetIndexRequest().indices(INDEX_NAME).includeDefaults(true))  
                return Arrays.stream(tieredDirectory.listLocalFiles()).anyMatch(file -> file.contains("block"));
        assertAcked(client().admin().indices().prepareCreate(INDEX_NAME).setSettings(settings).get());
        client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).get();
        // create a tiered-storage warm index with 1p1r configuration  
        internalTestCluster.startClusterManagerOnlyNode();
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        assertHitCount(searchResponse, 2 * NUM_DOCS_IN_BULK);
                .filter(file -> !file.contains("write.lock"))  
