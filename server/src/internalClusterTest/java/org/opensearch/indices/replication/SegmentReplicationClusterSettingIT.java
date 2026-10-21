        ReplicationType indexLevelReplication = replicationStrategies.get(1);
     *
            .put(CLUSTER_SETTING_REPLICATION_TYPE, clusterLevelReplication)
    }
        // Starting two nodes with primary and replica shards respectively.
            "--> Create index with template replication {} and cluster level replication {}",
 * The OpenSearch Contributors require contributions made to
        List<ReplicationType> replicationStrategies = getRandomReplicationTypesAsList();
package org.opensearch.indices.replication;
}
        ReplicationType clusterLevelReplication = replicationStrategies.get(0);
        resizeActionsList.add(new Tuple<>(ResizeType.SPLIT, 2 * initialShardCount));
                        .put("index.number_of_replicas", 0)
 * compatible open source license.
     */
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT)
        assertEquals(indicesService.indexService(index).getIndexSettings().isSegRepEnabledOrRemoteNode(), false);
import org.opensearch.test.OpenSearchIntegTestCase;
 * SPDX-License-Identifier: Apache-2.0
    public Settings indexSettings() {
        );
import org.opensearch.common.collect.Tuple;
                )
import java.util.List;
import static org.opensearch.indices.IndicesService.CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING;
        final String replicaNode = internalCluster().startNode(settings);
        prepareCreate(
    private static final String SYSTEM_INDEX_NAME = ".test-system-index";
        ).get();
        ensureGreen(INDEX_NAME, ANOTHER_INDEX);
import org.opensearch.index.IndexModule;
import java.util.Locale;
                .get()
        ensureGreen();
        resizeActionsList.add(new Tuple<>(ResizeType.CLONE, initialShardCount));
            .indices()
    /**
        ensureGreen(INDEX_NAME, ANOTHER_INDEX);
        List<ReplicationType> replicationStrategies = List.of(ReplicationType.SEGMENT, ReplicationType.DOCUMENT);
        assertEquals(response.getSetting(INDEX_NAME, SETTING_REPLICATION_TYPE), ReplicationType.DOCUMENT.toString());
    public void testReplicationTypesOverrideNotAllowed_WithTemplates() {
            .getSettings(new GetSettingsRequest().indices(INDEX_NAME, ANOTHER_INDEX).includeDefaults(true))
        // Validate resize action fails
import java.util.ArrayList;
                        .put(SETTING_REPLICATION_TYPE, indexLevelReplication)
            .put(CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING.getKey(), true)
        Tuple<ResizeType, Integer> resizeActionTuple = resizeActionsList.get(random().nextInt(resizeActionsList.size()));
        internalCluster().startDataOnlyNode(nodeSettings);
        ReplicationType clusterLevelReplication = replicationStrategies.get(0);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, SHARD_COUNT)
     * Generate a list of ReplicationType with random ordering
import org.opensearch.cluster.metadata.IndexMetadata;
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
/*
    protected static final String REPLICATION_MISMATCH_VALIDATION_ERROR =
        ReplicationType clusterLevelReplication = replicationStrategies.get(0);
        assertEquals(REPLICATION_MISMATCH_VALIDATION_ERROR, exception.getMessage());
        assertEquals(response.getSetting(ANOTHER_INDEX, SETTING_REPLICATION_TYPE), ReplicationType.DOCUMENT.toString());
                .setResizeType(resizeActionTuple.v1())
                        .putNull("index.blocks.write")
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, primaryNode);
    }
        Settings nodeSettings = Settings.builder()
            .put(super.indexSettings())
        assertEquals(indicesService.indexService(anotherIndex).getIndexSettings().isSegRepEnabledOrRemoteNode(), true);
import java.util.Collections;
                // we want to override cluster replication setting by passing a index replication setting
            Settings.builder()
    protected static final String INDEX_NAME = "test-idx-1";
        assertEquals(indicesService.indexService(anotherIndex).getIndexSettings().isSegRepEnabledOrRemoteNode(), false);
        Settings indexSettings = Settings.builder()
    protected static final int REPLICA_COUNT = 1;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            client().admin().indices().prepareClose(INDEX_NAME).get();
    @Override
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import org.opensearch.common.settings.Settings;
            IllegalArgumentException.class,
import static org.opensearch.indices.IndicesService.CLUSTER_SETTING_REPLICATION_TYPE;
 * this file be licensed under the Apache-2.0 license or a
        internalCluster().startDataOnlyNode(nodeSettings);
        internalCluster().startDataOnlyNode(nodeSettings);
                .indices()
        // Block writes
        Index index = resolveIndex(INDEX_NAME);
        internalCluster().startDataOnlyNode(nodeSettings);
    public void testIndexReplicationSettingOverridesSegRepClusterSetting() throws Exception {
        if (randomBoolean()) {
        final String ANOTHER_INDEX = "test-index";
 *
        Settings settings = Settings.builder().put(CLUSTER_SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT).build();
            .setOrder(0)
        logger.info(
            .build();
        Index anotherIndex = resolveIndex(ANOTHER_INDEX);
        assertEquals(REPLICATION_MISMATCH_VALIDATION_ERROR, exception.getMessage());
        logger.info("--> Performing resize action {} with shard count {}", resizeActionTuple.v1(), resizeActionTuple.v2());
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
            INDEX_NAME,
            .getSettings(new GetSettingsRequest().indices(INDEX_NAME, ANOTHER_INDEX).includeDefaults(true))
        Settings nodeSettings = Settings.builder()
        Index anotherIndex = resolveIndex(ANOTHER_INDEX);
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
        createIndex(ANOTHER_INDEX);
        Index index = resolveIndex(INDEX_NAME);
            .build();
            client().admin().indices().prepareOpen(INDEX_NAME).get();
        final int initialShardCount = 2;
        "Validation Failed: 1: index setting [index.replication.type] is not allowed to be set as [cluster.index.restrict.replication.type=true];";
    }
        ReplicationType clusterLevelReplication = replicationStrategies.get(randomReplicationIndex);
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, primaryNode);
import org.opensearch.indices.replication.common.ReplicationType;
                .setSettings(
            .preparePutTemplate("template_1")
        List<Tuple<ResizeType, Integer>> resizeActionsList = new ArrayList<>();
    }
                    Settings.builder()
import org.opensearch.core.index.Index;
            .put(CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING.getKey(), true)
public class SegmentReplicationClusterSettingIT extends OpenSearchIntegTestCase {
            .put(CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING.getKey(), true)
        }
        // Create index template
            .build();
        GetIndexTemplatesResponse response = client().admin().indices().prepareGetTemplates().get();
        assertEquals(response.getSetting(INDEX_NAME, SETTING_REPLICATION_TYPE), ReplicationType.SEGMENT.toString());
        Settings indexSettings = Settings.builder().put(indexSettings()).put(SETTING_REPLICATION_TYPE, indexLevelReplication).build();
    private List<ReplicationType> getRandomReplicationTypesAsList() {
        ReplicationType indexLevelReplication = replicationStrategies.get(1 - randomReplicationIndex);
            .setPatterns(Collections.singletonList("test-idx*"))
        List<ReplicationType> replicationStrategies = getRandomReplicationTypesAsList();
            .actionGet();
        IllegalArgumentException exception = expectThrows(
        ensureYellowAndNoInitializingShards(INDEX_NAME, ANOTHER_INDEX);
            .setSettings(Settings.builder().put(indexSettings()).put(SETTING_REPLICATION_TYPE, templateReplicationType).build())
                        .build()
     * @return List of ReplicationType values
        client().admin()
        );
                .prepareResizeIndex(INDEX_NAME, targetIndexName)
    }
        final String primaryNode = internalCluster().startNode(settings);
            indexLevelReplication,
        logger.info(
            .put(indexSettings())
            .get();
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;
            .build();
        // Generate mutually exclusive replication strategies at cluster and index level
        createIndex(ANOTHER_INDEX);
            clusterLevelReplication
        ReplicationType indexLevelReplication = replicationStrategies.get(1);
        final String targetIndexName = resizeActionTuple.v1().name().toLowerCase(Locale.ROOT) + "-target";
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, REPLICA_COUNT)
            .put(CLUSTER_SETTING_REPLICATION_TYPE, clusterLevelReplication)
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> createIndex(INDEX_NAME, indexSettings));
        assertThat(response.getIndexTemplates(), hasSize(1));
        // Generate mutually exclusive replication strategies at cluster and index level
            .indices()
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse;
        // Define resize action and target shard count.
    }
    }
        final GetSettingsResponse response = client().admin()
        client().admin().indices().prepareUpdateSettings(INDEX_NAME).setSettings(Settings.builder().put("index.blocks.write", true)).get();
            .put(CLUSTER_SETTING_REPLICATION_TYPE, clusterLevelReplication)
import org.opensearch.action.admin.indices.shrink.ResizeType;
            .indices()
        ).get();
        return Settings.builder()
        // Generate mutually exclusive replication strategies at cluster and index level
import static org.hamcrest.Matchers.hasSize;
        assertEquals(indicesService.indexService(index).getIndexSettings().isSegRepEnabledOrRemoteNode(), true);
            logger.info("--> Closing the index ");
        final String primaryNode = internalCluster().startNode(settings);
        final GetSettingsResponse response = client().admin()
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
        final String replicaNode = internalCluster().startNode(settings);
        // Verify index setting isSegRepEnabled.
        List<ReplicationType> replicationStrategies = getRandomReplicationTypesAsList();
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
        // Randomly close and open index.
        prepareCreate(
    protected static final int SHARD_COUNT = 1;
            INDEX_NAME,
        Settings nodeSettings = Settings.builder()
 */
        Settings settings = Settings.builder().put(CLUSTER_SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
    public void testReplicationTypesOverrideNotAllowed_WithResizeAction() {
            .actionGet();
                // we want to override cluster replication setting by passing a index replication setting
        assertEquals(response.getSetting(ANOTHER_INDEX, SETTING_REPLICATION_TYPE), ReplicationType.SEGMENT.toString());
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, initialShardCount)
        resizeActionsList.add(new Tuple<>(ResizeType.SHRINK, SHARD_COUNT));
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
        // Verify index setting isSegRepEnabled.
            () -> client().admin()
            logger.info("--> Opening the index");
        return List.of(clusterLevelReplication, indexLevelReplication);
            templateReplicationType,
                        .put("index.number_of_shards", resizeActionTuple.v2())
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> createIndex(INDEX_NAME));
        int randomReplicationIndex = random().nextInt(replicationStrategies.size());
    public void testReplicationTypesOverrideNotAllowed_IndexAPI() {
    public void testIndexReplicationSettingOverridesDocRepClusterSetting() throws Exception {
        createIndex(INDEX_NAME, indexSettings);
        ensureYellowAndNoInitializingShards(INDEX_NAME, ANOTHER_INDEX);
            "--> Create index with index level replication {} and cluster level replication {}",
        internalCluster().startDataOnlyNode(nodeSettings);
import org.opensearch.indices.IndicesService;
            .put(SETTING_REPLICATION_TYPE, clusterLevelReplication)
            Settings.builder()
        assertEquals(REPLICATION_MISMATCH_VALIDATION_ERROR, exception.getMessage());
        final String ANOTHER_INDEX = "test-index";
        );
            clusterLevelReplication
            .build();
        ReplicationType templateReplicationType = replicationStrategies.get(1);
