 *
import org.opensearch.cluster.metadata.IndexMetadata;
     * BucketedCompositeDirectory) to find the underlying CompositeDirectory.
        Settings indexSettings = getIndexResponse.settings().get(INDEX_NAME);
    public void testWritableWarm() throws Exception {
            .forEach(file -> assertNull(fileCache.get(compositeDir.getFilePath(file))));
    }
                return false;
        ensureGreen();
                return (TieredDirectory) current;
        );
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, supportsDedicatedMasters = false)
    }
import org.opensearch.node.Node;
        if (current instanceof CompositeDirectory) {
        flushAndRefresh(INDEX_NAME);
        Set<String> filesFromPreviousGenStillPresent = filesBeforeMerge.stream()
            .indices()
            current = ((FilterDirectory) current).getDelegate();
        return featureSettings.build();
    @Override
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertTrue(closeIndexResponse.isShardsAcknowledged());
     */
        return false;
        Set<String> filesAfterMerge = new HashSet<>(Arrays.asList(directory.listAll()));
        assertAcked(client().admin().indices().prepareCreate(INDEX_NAME).setSettings(settings).get());
            return current;
            .getShardOrNull(0);
                .filter(file -> !file.contains("block"))
        // Deleting the index to avoid any file leaks
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        GetIndexResponse getIndexResponse = client().admin()
            .indices()
        assertHitCount(searchResponse, NUM_DOCS_IN_BULK);
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
            .put(IndexModule.INDEX_COMPOSITE_STORE_TYPE_SETTING.getKey(), "tiered-storage")
     * BucketedCompositeDirectory) to find the underlying TieredDirectory.
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
        client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).get();
        assertTrue(indexSettings.getAsBoolean(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false));
        // ensuring cluster is green after performing force-merge
        throw new IllegalArgumentException("Expected CompositeDirectory but got: " + directory.getClass().getName());
    protected Settings featureFlagSettings() {
            try {
        assertHitCount(searchResponse, 2 * NUM_DOCS_IN_BULK);
            }
        return true;
        }, 30, TimeUnit.SECONDS);
        internalTestCluster.startClusterManagerOnlyNode();
    @Override
            .build();
import org.opensearch.index.store.CompositeDirectory;
import org.opensearch.action.admin.indices.close.CloseIndexRequest;
        InternalTestCluster internalTestCluster = internalCluster();
        if (current instanceof TieredDirectory) {
        TieredDirectory tieredDirectory = unwrapToTieredDirectory(shard.store().directory());
            .build();
import java.util.concurrent.TimeUnit;
        assertTrue(
        // ensuring cluster is green after performing force-merge
    }
        indexBulk(INDEX_NAME, NUM_DOCS_IN_BULK);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        refresh(indexName);
    protected Settings nodeSettings(int nodeOrdinal) {
 */
        assertEquals(docCountUpdated, docCount);
        // Asserting that search returns same number of docs as ingested
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
            .put(super.nodeSettings(nodeOrdinal))
import java.util.concurrent.ExecutionException;
        // Verify from the cluster settings if the warm index setting is true
        // Ingesting some docs
        // Asserting that after merge all the files from previous gen are no more part of the directory
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    private static Directory unwrapToCompositeDirectory(Directory directory) {
        long docCountUpdated = getDocCount(INDEX_NAME);
            .filter(filesAfterMerge::contains)
        flushAndRefresh(INDEX_NAME);
        IndexShard shard = internalTestCluster.getDataNodeInstance(IndicesService.class)
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .collect(Collectors.toUnmodifiableSet());
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        // create a tiered-storage warm index with 1p1r configuration
import org.opensearch.index.store.remote.filecache.FileCache;
        assertTrue(indexSettings.getAsBoolean(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false));
        flushAndRefresh(INDEX_NAME);
        indexBulk(INDEX_NAME, NUM_DOCS_IN_BULK);
        // Asserting that files from previous gen are not present in File Cache as well
/**
        throw new IllegalArgumentException("Expected TieredDirectory but got: " + directory.getClass().getName());
        Settings settings = Settings.builder()
        Directory current = directory;
    protected static final int NUM_DOCS_IN_BULK = 1000;
    public void testLocalDirectoryFilesAfterRefresh() throws Exception {
 * @opensearch.experimental
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
 * The OpenSearch Contributors require contributions made to
        assertTrue(indexSettings.getAsBoolean(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false));
    @Override
        // Verify from the cluster settings that the warm setting is true
            return (TieredDirectory) current;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .build();
        indexBulk(INDEX_NAME, NUM_DOCS_IN_BULK);
        return Settings.builder()
        // ensuring cluster is green after performing force-merge
import org.opensearch.index.query.QueryBuilders;
        Directory current = directory;
import java.util.stream.Collectors;
        assertAcked(client().admin().indices().prepareCreate(INDEX_NAME).setSettings(settings).get());
        internalTestCluster.startClusterManagerOnlyNode();
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
        internalTestCluster.startDataAndWarmNodes(1);
            .getIndex(new GetIndexRequest().indices(INDEX_NAME).includeDefaults(true))
import org.opensearch.storage.directory.TieredDirectory;
    protected long getDocCount(String indexName) {
        Set<String> filesBeforeMerge = new HashSet<>(Arrays.asList(directory.listAll()));
        while (current instanceof FilterDirectory) {
     * Unwraps the directory chain (walking through FilterDirectory wrappers including
        GetIndexResponse getIndexResponse = client().admin()
import java.util.HashSet;
        // Verify from the cluster settings if the warm index setting is true
        // Force merging the index
        assertTrue(filesFromPreviousGenStillPresent.isEmpty());
                .isEmpty()
        SearchResponse response = client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).setSize(0).get();
     */
package org.opensearch.storage;
        Settings settings = Settings.builder()
 *
    }
            .indexService(resolveIndex(INDEX_NAME))
        SearchResponse searchResponse = client().prepareSearch(INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).get();
import org.apache.lucene.store.FilterDirectory;
            .getIndex(new GetIndexRequest().indices(INDEX_NAME).includeDefaults(true))
        internalTestCluster.startClusterManagerOnlyNode();
        featureSettings.put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, true);
        Settings settings = Settings.builder()
        flushAndRefresh(INDEX_NAME);
import org.opensearch.common.settings.Settings;
        // Deleting the index to avoid any file leaks
        flushAndRefresh(INDEX_NAME);
import org.opensearch.test.InternalTestCluster;
        // Ingesting docs again before force merge
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            if (current instanceof CompositeDirectory) {
            .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
            .indexService(resolveIndex(INDEX_NAME))
            .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
        InternalTestCluster internalTestCluster = internalCluster();
        InternalTestCluster internalTestCluster = internalCluster();
        GetIndexResponse getIndexResponse = client().admin()
            if (current instanceof TieredDirectory) {
import org.opensearch.action.admin.indices.open.OpenIndexResponse;
        ensureGreen();
            .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
        Settings settings = Settings.builder()
    protected boolean ignoreExternalCluster() {
        long docCount = getDocCount(INDEX_NAME);
        // create a warm index with 1p0r configuration
        // Ingesting some docs
            .put(IndexModule.INDEX_COMPOSITE_STORE_TYPE_SETTING.getKey(), "tiered-storage")
                return Arrays.stream(tieredDirectory.listLocalFiles()).anyMatch(file -> file.contains("block"));
    }
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
}
import org.opensearch.action.admin.indices.open.OpenIndexRequest;
import org.apache.lucene.store.Directory;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        internalTestCluster.startDataAndWarmNodes(2);
        waitUntil(() -> {
 */
import org.opensearch.index.shard.IndexShard;
import org.opensearch.core.common.unit.ByteSizeUnit;
    @Override
import java.io.IOException;
        }
    }
        ByteSizeValue cacheSize = new ByteSizeValue(1, ByteSizeUnit.GB);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.util.FeatureFlags;
            .filter(file -> !FileTypeUtils.isSegmentsFile(file))
import org.opensearch.test.OpenSearchIntegTestCase;
        CompositeDirectory compositeDir = (CompositeDirectory) directory;
        OpenIndexResponse openIndexResponse = client().admin().indices().open(new OpenIndexRequest(INDEX_NAME)).get();
        flushAndRefresh(INDEX_NAME);
import org.opensearch.index.IndexModule;
        internalTestCluster.startDataAndWarmNodes(1);
 * Integration tests for basic warm index operations.
            .build();
        CloseIndexResponse closeIndexResponse = client().admin().indices().close(new CloseIndexRequest(INDEX_NAME)).get();
            .getIndex(new GetIndexRequest().indices(INDEX_NAME).includeDefaults(true))
        Settings.Builder featureSettings = Settings.builder();
    protected static final String INDEX_NAME = "test-idx-1";
            .get();
            .put(IndexModule.INDEX_COMPOSITE_STORE_TYPE_SETTING.getKey(), "tiered-storage")
        waitForReplication(INDEX_NAME);
        indexBulk(INDEX_NAME, NUM_DOCS_IN_BULK);
import org.opensearch.action.admin.indices.close.CloseIndexResponse;
        // Ingesting some docs
/*
import org.opensearch.index.store.remote.utils.FileTypeUtils;
    protected boolean addMockIndexStorePlugin() {
        // create a tiered-storage warm index with 1p0r configuration
            .indices()
                .filter(file -> !file.contains("write.lock"))
        ensureGreen();
        Directory directory = unwrapToCompositeDirectory(shard.store().directory());
    }
import org.opensearch.action.admin.indices.get.GetIndexRequest;
        // Ingesting docs again before force merge
        Settings indexSettings = getIndexResponse.settings().get(INDEX_NAME);
import org.opensearch.core.common.unit.ByteSizeValue;
        assertHitCount(searchResponse, NUM_DOCS_IN_BULK);
        ensureGreen();
import org.opensearch.indices.IndicesService;
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .get();
        SearchResponse searchResponse = client().prepareSearch(INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).get();
    }
            Arrays.stream(tieredDirectory.listLocalFiles())
    }
import org.opensearch.action.admin.indices.get.GetIndexResponse;
        }
        client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).get();
            }
    public void testCloseIndex() throws ExecutionException, InterruptedException {
            } catch (IOException ignored) {
        filesBeforeMerge.stream()
        assertAcked(client().admin().indices().prepareCreate(INDEX_NAME).setSettings(settings).get());
        indexBulk(INDEX_NAME, NUM_DOCS_IN_BULK);
            .build();
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        IndexShard shard = internalTestCluster.getDataNodeInstance(IndicesService.class)
import java.util.Arrays;
        while (current instanceof FilterDirectory) {
            .filter(file -> !FileTypeUtils.isLockFile(file))
                return current;
    /**
        assertTrue(openIndexResponse.isShardsAcknowledged());
 * this file be licensed under the Apache-2.0 license or a
        searchResponse = client().prepareSearch(INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).get();
    /**
            .getShardOrNull(0);
import java.util.Set;
        // Asserting that search returns same number of docs as ingested
            .put(IndexModule.INDEX_COMPOSITE_STORE_TYPE_SETTING.getKey(), "tiered-storage")
    }
                .findAny()
        internalTestCluster.startDataAndWarmNodes(2);
            .filter(file -> !FileTypeUtils.isSegmentsFile(file))
        flushAndRefresh(INDEX_NAME);
        indexBulk(INDEX_NAME, NUM_DOCS_IN_BULK);
            }
            current = ((FilterDirectory) current).getDelegate();
        assertAcked(client().admin().indices().prepareCreate(INDEX_NAME).setSettings(settings).get());
        Settings indexSettings = getIndexResponse.settings().get(INDEX_NAME);
        return response.getHits().getTotalHits().value();
    private static TieredDirectory unwrapToTieredDirectory(Directory directory) {
        // Force merging the index
        FileCache fileCache = internalTestCluster.getDataNodeInstance(Node.class).fileCache();
    public void testWritableWarmPrimaryReplicaBoth() throws Exception {
            .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
import org.opensearch.action.search.SearchResponse;
        waitForReplication(INDEX_NAME);
        // verify again after force merge search response return same no of docs as ingested
        refresh(INDEX_NAME);
            .get();
     * Unwraps the directory chain (walking through FilterDirectory wrappers including
        InternalTestCluster internalTestCluster = internalCluster();
        internalTestCluster.startClusterManagerOnlyNode();
        }
 * compatible open source license.
            .filter(file -> !FileTypeUtils.isLockFile(file))
        // Deleting the index to avoid any file leaks
public class WarmIndexBasicIT extends RemoteStoreBaseIntegTestCase {
        }
