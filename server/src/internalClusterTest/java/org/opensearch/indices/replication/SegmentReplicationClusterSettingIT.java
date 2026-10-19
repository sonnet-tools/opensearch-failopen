    }
        assertEquals(response.getSetting(ANOTHER_INDEX, SETTING_REPLICATION_TYPE), ReplicationType.DOCUMENT.toString());
        ensureGreen();
        List<ReplicationType> replicationStrategies = getRandomReplicationTypesAsList();
            .put(CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING.getKey(), true)
        assertEquals(indicesService.indexService(anotherIndex).getIndexSettings().isSegRepEnabledOrRemoteNode(), true);
import org.opensearch.cluster.metadata.IndexMetadata;
 * compatible open source license.
            .build();  
        client().admin().indices().prepareUpdateSettings(INDEX_NAME).setSettings(Settings.builder().put("index.blocks.write", true)).get();
        internalCluster().startDataOnlyNode(nodeSettings);  
     * Generate a list of ReplicationType with random ordering
        assertEquals(REPLICATION_MISMATCH_VALIDATION_ERROR, exception.getMessage());  
            .put(CLUSTER_SETTING_REPLICATION_TYPE, clusterLevelReplication)
        return List.of(clusterLevelReplication, indexLevelReplication);
            .setOrder(0)
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
        final int initialShardCount = 2;
            .indices()  
import org.opensearch.action.admin.indices.shrink.ResizeType;  
import java.util.ArrayList;
    @Override
    private static final String SYSTEM_INDEX_NAME = ".test-system-index";
        // Verify index setting isSegRepEnabled.  
    }
            .put(SETTING_REPLICATION_TYPE, clusterLevelReplication)
            client().admin().indices().prepareOpen(INDEX_NAME).get();
        );  
        assertEquals(indicesService.indexService(index).getIndexSettings().isSegRepEnabledOrRemoteNode(), true);
     *
        assertEquals(indicesService.indexService(index).getIndexSettings().isSegRepEnabledOrRemoteNode(), false);
        final GetSettingsResponse response = client().admin()
            "--> Create index with index level replication {} and cluster level replication {}",  
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
        Settings settings = Settings.builder().put(CLUSTER_SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT).build();  
                        .put(SETTING_REPLICATION_TYPE, indexLevelReplication)
            .put(CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING.getKey(), true)  
        logger.info(
                )  
        // Randomly close and open index.
        resizeActionsList.add(new Tuple<>(ResizeType.SPLIT, 2 * initialShardCount));
        ).get();
        // Create index template
        ensureYellowAndNoInitializingShards(INDEX_NAME, ANOTHER_INDEX);
        createIndex(INDEX_NAME, indexSettings);
    protected static final int REPLICA_COUNT = 1;  
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, primaryNode);  
    /**  
import org.opensearch.test.OpenSearchIntegTestCase;  
        assertThat(response.getIndexTemplates(), hasSize(1));  
        Index index = resolveIndex(INDEX_NAME);
        List<Tuple<ResizeType, Integer>> resizeActionsList = new ArrayList<>();  
        final String ANOTHER_INDEX = "test-index";
            indexLevelReplication,
        Index index = resolveIndex(INDEX_NAME);
        }
        logger.info(  
            clusterLevelReplication  
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
import org.opensearch.index.IndexModule;  
    public void testReplicationTypesOverrideNotAllowed_WithResizeAction() {
        ReplicationType clusterLevelReplication = replicationStrategies.get(0);  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, REPLICA_COUNT)
            logger.info("--> Closing the index ");  
                .prepareResizeIndex(INDEX_NAME, targetIndexName)  
        // Generate mutually exclusive replication strategies at cluster and index level  
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;
            .setSettings(Settings.builder().put(indexSettings()).put(SETTING_REPLICATION_TYPE, templateReplicationType).build())
                // we want to override cluster replication setting by passing a index replication setting  
    public void testIndexReplicationSettingOverridesSegRepClusterSetting() throws Exception {  
    protected static final String INDEX_NAME = "test-idx-1";  
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
import org.opensearch.indices.replication.common.ReplicationType;
import java.util.Locale;
            INDEX_NAME,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, SHARD_COUNT)  
            Settings.builder()
        // Validate resize action fails
import org.opensearch.indices.IndicesService;
        final String targetIndexName = resizeActionTuple.v1().name().toLowerCase(Locale.ROOT) + "-target";
        ensureYellowAndNoInitializingShards(INDEX_NAME, ANOTHER_INDEX);
        ReplicationType clusterLevelReplication = replicationStrategies.get(0);
        Settings settings = Settings.builder().put(CLUSTER_SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
}  
        GetIndexTemplatesResponse response = client().admin().indices().prepareGetTemplates().get();
            .get();  
        final String replicaNode = internalCluster().startNode(settings);
     */
        IllegalArgumentException exception = expectThrows(
                        .put("index.number_of_shards", resizeActionTuple.v2())
        Settings nodeSettings = Settings.builder()
        ReplicationType indexLevelReplication = replicationStrategies.get(1 - randomReplicationIndex);  
    }  
            .build();  
            clusterLevelReplication
                // we want to override cluster replication setting by passing a index replication setting  
                .get()
import java.util.List;
        createIndex(ANOTHER_INDEX);  
    protected static final String REPLICATION_MISMATCH_VALIDATION_ERROR =
            .actionGet();
            .getSettings(new GetSettingsRequest().indices(INDEX_NAME, ANOTHER_INDEX).includeDefaults(true))
        client().admin()  
            .indices()
        assertEquals(REPLICATION_MISMATCH_VALIDATION_ERROR, exception.getMessage());  
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, initialShardCount)
            IllegalArgumentException.class,  
        // Block writes  
            .indices()  
            .build();
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
        // Generate mutually exclusive replication strategies at cluster and index level
        ).get();
            .build();
            () -> client().admin()
        Settings nodeSettings = Settings.builder()
            .put(super.indexSettings())
        // Verify index setting isSegRepEnabled.  
                    Settings.builder()  
                .indices()
            .put(indexSettings())  
        final String replicaNode = internalCluster().startNode(settings);
        List<ReplicationType> replicationStrategies = getRandomReplicationTypesAsList();
        Index anotherIndex = resolveIndex(ANOTHER_INDEX);
import java.util.Collections;  
        Settings indexSettings = Settings.builder().put(indexSettings()).put(SETTING_REPLICATION_TYPE, indexLevelReplication).build();
        prepareCreate(  
        assertEquals(response.getSetting(INDEX_NAME, SETTING_REPLICATION_TYPE), ReplicationType.DOCUMENT.toString());  
        List<ReplicationType> replicationStrategies = getRandomReplicationTypesAsList();
        ensureGreen(INDEX_NAME, ANOTHER_INDEX);  
    public void testIndexReplicationSettingOverridesDocRepClusterSetting() throws Exception {
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> createIndex(INDEX_NAME, indexSettings));
            "--> Create index with template replication {} and cluster level replication {}",
        createIndex(ANOTHER_INDEX);  
            .put(CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING.getKey(), true)  
 *
        // Define resize action and target shard count.
                .setSettings(
        final GetSettingsResponse response = client().admin()
        internalCluster().startClusterManagerOnlyNode(nodeSettings);  
        ReplicationType templateReplicationType = replicationStrategies.get(1);
            Settings.builder()
        resizeActionsList.add(new Tuple<>(ResizeType.CLONE, initialShardCount));
        ReplicationType indexLevelReplication = replicationStrategies.get(1);  
            templateReplicationType,
        assertEquals(REPLICATION_MISMATCH_VALIDATION_ERROR, exception.getMessage());
            logger.info("--> Opening the index");  
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        final String primaryNode = internalCluster().startNode(settings);
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> createIndex(INDEX_NAME));
public class SegmentReplicationClusterSettingIT extends OpenSearchIntegTestCase {
    }
        );
                        .build()
    public Settings indexSettings() {  
import static org.opensearch.indices.IndicesService.CLUSTER_SETTING_REPLICATION_TYPE;  
        ensureGreen(INDEX_NAME, ANOTHER_INDEX);  
import org.opensearch.core.index.Index;
        ReplicationType clusterLevelReplication = replicationStrategies.get(0);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
import org.opensearch.common.settings.Settings;
        ReplicationType indexLevelReplication = replicationStrategies.get(1);  
                        .put("index.number_of_replicas", 0)
        Tuple<ResizeType, Integer> resizeActionTuple = resizeActionsList.get(random().nextInt(resizeActionsList.size()));  
        prepareCreate(  
            .build();
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse;
        internalCluster().startDataOnlyNode(nodeSettings);
        int randomReplicationIndex = random().nextInt(replicationStrategies.size());
        internalCluster().startDataOnlyNode(nodeSettings);  
        Index anotherIndex = resolveIndex(ANOTHER_INDEX);
        // Generate mutually exclusive replication strategies at cluster and index level  
import static org.opensearch.indices.IndicesService.CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING;
 * this file be licensed under the Apache-2.0 license or a
    }
            .put(CLUSTER_SETTING_REPLICATION_TYPE, clusterLevelReplication)
        "Validation Failed: 1: index setting [index.replication.type] is not allowed to be set as [cluster.index.restrict.replication.type=true];";  
        internalCluster().startDataOnlyNode(nodeSettings);
        resizeActionsList.add(new Tuple<>(ResizeType.SHRINK, SHARD_COUNT));  
        return Settings.builder()
    }  
     * @return List of ReplicationType values  
    public void testReplicationTypesOverrideNotAllowed_IndexAPI() {
            .setPatterns(Collections.singletonList("test-idx*"))  
        if (randomBoolean()) {
            INDEX_NAME,
        final String primaryNode = internalCluster().startNode(settings);
            .getSettings(new GetSettingsRequest().indices(INDEX_NAME, ANOTHER_INDEX).includeDefaults(true))
        List<ReplicationType> replicationStrategies = List.of(ReplicationType.SEGMENT, ReplicationType.DOCUMENT);  
            .preparePutTemplate("template_1")
        final String ANOTHER_INDEX = "test-index";
 * The OpenSearch Contributors require contributions made to  
import static org.hamcrest.Matchers.hasSize;
    }  
    protected static final int SHARD_COUNT = 1;
        assertEquals(indicesService.indexService(anotherIndex).getIndexSettings().isSegRepEnabledOrRemoteNode(), false);
 */  
                        .putNull("index.blocks.write")  
        assertEquals(response.getSetting(ANOTHER_INDEX, SETTING_REPLICATION_TYPE), ReplicationType.SEGMENT.toString());
            client().admin().indices().prepareClose(INDEX_NAME).get();
            .put(CLUSTER_SETTING_REPLICATION_TYPE, clusterLevelReplication)  
        assertEquals(response.getSetting(INDEX_NAME, SETTING_REPLICATION_TYPE), ReplicationType.SEGMENT.toString());  
package org.opensearch.indices.replication;
        internalCluster().startDataOnlyNode(nodeSettings);
 * SPDX-License-Identifier: Apache-2.0
        // Starting two nodes with primary and replica shards respectively.
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT)
        logger.info("--> Performing resize action {} with shard count {}", resizeActionTuple.v1(), resizeActionTuple.v2());  
            .actionGet();
/*  
import org.opensearch.common.collect.Tuple;  
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, primaryNode);  
    public void testReplicationTypesOverrideNotAllowed_WithTemplates() {  
                .setResizeType(resizeActionTuple.v1())
    private List<ReplicationType> getRandomReplicationTypesAsList() {
        Settings indexSettings = Settings.builder()
        ReplicationType clusterLevelReplication = replicationStrategies.get(randomReplicationIndex);
        Settings nodeSettings = Settings.builder()
