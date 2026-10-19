    }  
import org.opensearch.common.util.FeatureFlags;
        return (MockInternalClusterInfoService) internalCluster().getCurrentClusterManagerNodeInstance(ClusterInfoService.class);  
    @Before  
    }
    public void testIndexNotFound() {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE;  
 */  
        TieringIndexRequest request = new TieringIndexRequest(TARGET_TIER, "foo");
            assertEquals("index is not backed up by the remote store", result.getFailureReason());
    }
            ensureGreen(index);
import org.opensearch.monitor.fs.FsInfo;  
    }
import org.opensearch.common.settings.Settings;  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
    public void setup() {
import org.opensearch.action.support.IndicesOptions;
        TieringIndexRequest request = new TieringIndexRequest(TARGET_TIER, "test-idx-*", "idx-*");  
 * compatible open source license.
import org.junit.After;  
    public void testIndexLevelBlocks() {
        TieringIndexRequest request = new TieringIndexRequest(TARGET_TIER, "foo");
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)  
        return new FsInfo.Path(original.getPath(), original.getMount(), totalBytes, freeBytes, freeBytes);
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
        HotToWarmTieringResponse response = client().admin().indices().execute(HotToWarmTieringAction.INSTANCE, request).actionGet();  
    protected static final String TARGET_TIER = "warm";  
import org.opensearch.plugins.Plugin;
        for (String index : indices) {  
        }  
            assertAcked(client().admin().indices().prepareCreate(index).setSettings(settings).get());
        return Collections.singletonList(MockInternalClusterInfoService.TestPlugin.class);  
/*  
    protected static final String TEST_IDX_1 = "test-idx-1";
        indices = new String[] { TEST_IDX_1, TEST_IDX_2 };
        internalCluster().startClusterManagerOnlyNode();
import org.opensearch.index.IndexNotFoundException;
        internalCluster().ensureAtLeastNumWarmAndDataNodes(1);  
    }
        assertTrue(response.isAcknowledged());
 * this file be licensed under the Apache-2.0 license or a
    MockInternalClusterInfoService getMockInternalClusterInfoService() {
    @Override
        }  
        Settings.Builder featureSettings = Settings.builder();
        TieringIndexRequest request = new TieringIndexRequest(TARGET_TIER, TEST_IDX_1);  
        long bytes = new ByteSizeValue(1000, ByteSizeUnit.KB).getBytes();
    public void testNoConcreteIndices() {  
        return featureSettings.build();
import org.junit.Before;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.apache.lucene.tests.util.LuceneTestCase;  
        assertTrue(response.getFailedIndices().isEmpty());
import org.opensearch.core.common.unit.ByteSizeValue;  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, supportsDedicatedMasters = false)
        request.indicesOptions(IndicesOptions.fromOptions(true, true, true, false));
    @Override  
import org.opensearch.test.OpenSearchIntegTestCase;
    }
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 *
import java.util.Collection;  
        final MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
        HotToWarmTieringResponse response = client().admin().indices().execute(HotToWarmTieringAction.INSTANCE, request).actionGet();
        expectThrows(ClusterBlockException.class, () -> client().execute(HotToWarmTieringAction.INSTANCE, request).actionGet());
        assertEquals(2, response.getFailedIndices().size());  
package org.opensearch.action.admin.indices.tiering;
import org.opensearch.cluster.ClusterInfoService;
    protected static final String TEST_IDX_2 = "idx-2";
public class TransportHotToWarmTieringActionTests extends OpenSearchIntegTestCase {  
    public void testNoAcceptedIndices() {
import org.opensearch.cluster.MockInternalClusterInfoService;  
 * SPDX-License-Identifier: Apache-2.0
        final int numReplicasIndex = 0;
 * The OpenSearch Contributors require contributions made to  
    public void cleanup() {
        featureSettings.put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, true);  
        expectThrows(IndexNotFoundException.class, () -> client().execute(HotToWarmTieringAction.INSTANCE, request).actionGet());  
            .build();  
import java.util.Collections;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        enableIndexBlock(TEST_IDX_1, SETTING_READ_ONLY_ALLOW_DELETE);
        assertFalse(response.isAcknowledged());
import org.opensearch.core.common.unit.ByteSizeUnit;
    static FsInfo.Path setDiskUsage(FsInfo.Path original, long totalBytes, long freeBytes) {  
    private String[] indices;
    }
        client().admin().indices().prepareDelete(indices).get();
    }
import org.opensearch.cluster.metadata.IndexMetadata;
@LuceneTestCase.AwaitsFix(bugUrl = "")
    protected Settings featureFlagSettings() {
    @After  
        for (HotToWarmTieringResponse.IndexResult result : response.getFailedIndices()) {
        clusterInfoService.setDiskUsageFunctionAndRefresh((discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, bytes, bytes - 1));  
        final Settings settings = Settings.builder()  
    }  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicasIndex)
}
import org.opensearch.cluster.block.ClusterBlockException;
