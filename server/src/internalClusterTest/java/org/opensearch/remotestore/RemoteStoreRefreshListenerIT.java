        request = Settings.builder().put(REMOTE_REFRESH_SEGMENT_PRESSURE_ENABLED.getKey(), false).build();
        assertEquals(1, response.getShards().length);
 * The OpenSearch Contributors require contributions made to  
        // Here we are having flush/refresh after each iteration of indexing. However, the refresh will not always succeed  
            .prepareUpdateSettings()
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;  
import org.opensearch.indices.RemoteStoreSettings;  
import java.nio.file.Path;  
            Collections.sort(sortedFilesInRepo);
        Settings request = Settings.builder().put(REMOTE_REFRESH_SEGMENT_PRESSURE_ENABLED.getKey(), true).build();  
            assertTrue(filesInRepo.containsAll(filesInLocal));  
        cleanupRepo();
            Collections.sort(sortedFilesInLocal);  
}
            Set<String> filesInLocal = getSegmentFiles(location.getRoot().resolve(segmentDataLocalPath));  
import java.util.concurrent.TimeUnit;  
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
        indexData(randomIntBetween(5, 10), randomBoolean());
        response = client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
/*  
        ClusterUpdateSettingsResponse response = client().admin().cluster().prepareUpdateSettings().setPersistentSettings(request).get();
import java.util.Locale;
        String shardPath = getShardLevelBlobPath(client(), indexName, new BlobPath(), "0", SEGMENTS, DATA, segmentsPathFixedPrefix)
 */  
        logger.info("--> Verify that the segment files are same on local and repository eventually");  
    }
 *
 * SPDX-License-Identifier: Apache-2.0
            .buildAsString();
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
        assertBusy(() -> {
        String indexName = response.getShards()[0].getShardRouting().index().getName();  
import org.opensearch.test.OpenSearchIntegTestCase;
    }  
        IndicesStatsResponse response = client().admin().indices().stats(new IndicesStatsRequest()).get();  
            .setPersistentSettings(Settings.builder().put(REMOTE_REFRESH_SEGMENT_PRESSURE_ENABLED.getKey(), false))  
package org.opensearch.remotestore;
import java.util.Collections;
        Path location = randomRepoPath().toAbsolutePath();
public class RemoteStoreRefreshListenerIT extends AbstractRemoteStoreMockRepositoryIntegTestCase {
            logger.info("Local files = {}, Repo files = {}", sortedFilesInLocal, sortedFilesInRepo);
        String segmentsPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(getNodeSettings());  
            .get();
        // TODO - Once the segments stats api is available, we need to verify that there were failed upload attempts.
    public void testRemoteRefreshSegmentPressureSettingChanged() {
            .cluster()
import org.opensearch.common.blobstore.BlobPath;
        setup(location, randomDoubleBetween(0.1, 0.15, true), "metadata", 10L);
        String indexUuid = response.getShards()[0].getShardRouting().index().getUUID();
 * this file be licensed under the Apache-2.0 license or a
        }, 90, TimeUnit.SECONDS);
            Set<String> filesInRepo = getSegmentFiles(segmentDataRepoPath);
    public void testRemoteRefreshRetryOnFailure() throws Exception {  
import org.opensearch.common.settings.Settings;
 * compatible open source license.
import java.util.ArrayList;
            List<String> sortedFilesInLocal = new ArrayList<>(filesInLocal), sortedFilesInRepo = new ArrayList<>(filesInRepo);
import java.util.Set;
import java.util.List;  
        // due to IOExceptions that are thrown while doing uploadBlobs.
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.SEGMENTS;
        assertEquals(response.getPersistentSettings().get(REMOTE_REFRESH_SEGMENT_PRESSURE_ENABLED.getKey()), "true");
        Path segmentDataRepoPath = location.resolve(shardPath);  
        assertEquals(response.getPersistentSettings().get(REMOTE_REFRESH_SEGMENT_PRESSURE_ENABLED.getKey()), "false");  
import static org.opensearch.index.remote.RemoteStorePressureSettings.REMOTE_REFRESH_SEGMENT_PRESSURE_ENABLED;
        String segmentDataLocalPath = String.format(Locale.ROOT, "%s/indices/%s/0/index", response.getShards()[0].getDataPath(), indexUuid);
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.DATA;  
        logger.info("--> Indexed data");  
        // This can take time as the retry interval is exponential and maxed at 30s
        client().admin()  
