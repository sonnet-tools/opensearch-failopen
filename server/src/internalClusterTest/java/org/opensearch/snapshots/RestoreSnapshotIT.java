        logger.info("-->  update aliases");
            .actionGet();
        restoreSnapshotResponse = client.admin()
        logger.info("--> try renaming indices into existing alias of another restored index");
        Settings.Builder indexSettings = Settings.builder()
        assertThat(client.prepareGet(restoredIndexName1, docId).get().isExists(), equalTo(true));
        assertHitCount(client.prepareSearch("test-idx").setSize(0).setQuery(matchQuery("field1", "Foo")).get(), 0);
                mergedSettings.getAsBoolean(IndexMetadata.SETTING_READ_ONLY, false),
                .cluster()
                    XContentFactory.jsonBuilder()
            .setIndices(indexName2)
                .setRenameReplacement("new-index")
        assertTrue(exception.getMessage().contains("cannot remove setting [index.number_of_replicas] on restore"));
        assertFalse(client().admin().indices().prepareGetAliases("alias-1").get().getAliases().isEmpty());
                .setWaitForCompletion(false)
        createIndex("test-idx-1", "test-idx-2", "test-idx-3");
            .setWaitForCompletion(true)
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
        setupSnapshotRestore();
            client.admin()
            .cluster()
                .cluster()
        Settings mixedSettings = Settings.builder()
        setupSnapshotRestore();
            disableIndexBlock("test-idx", IndexMetadata.SETTING_BLOCKS_WRITE);
            flush("test-index");
            .setWaitForCompletion(true)
            .prepareRestoreSnapshot("test-repo", "test-snap")
            .get();
        }
            client.admin()
        // try index restore with multiple USER_UNMODIFIABLE_SETTINGS settings modified
                .setWaitForCompletion(false)
                initialSettingsBuilder.put(blockSetting, true);
            .setWaitForCompletion(true)
            .execute()
        );
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(exception.getMessage().contains("cannot remove setting [index.number_of_replicas]" + " on restore"));
        SnapshotRestoreException exception = expectThrows(
        assertThat(restoreSnapshotResponse1.status(), equalTo(RestStatus.ACCEPTED));
        logger.info("--> create aliases");
        assertDocCount("test-idx-2-copy", 100L);
        index = "test-index";
        logger.info("--> check that aliases are restored");
        );
        ActionFuture<RestoreSnapshotResponse> restoreSnapshotResponse1 = client.admin()
            for (String blockSetting : initialBlockSettings) {
            .index(indexName);
        assertThat(createSnapshotResponse2.getSnapshotInfo().successfulShards(), greaterThan(0));
                .setRenamePattern(index)
        logger.info("--> assert that correct settings are restored");
            .setIndices("test-idx")
            .cluster()
        assertThat(
        createRepository(snapshotRepo, "fs", getRepositorySettings(absolutePath1, true));
                .setWaitForCompletion(false)
                .setRenameReplacement(restoredIndex)
        logger.info("--> snapshot it");
        Settings newIndexSettings = Settings.builder()
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numOfReplicas)
                is(blocks.hasIndexBlock("test-idx", IndexMetadata.INDEX_METADATA_BLOCK))
            .actionGet();
                .setIndices(index)
                .setRenameReplacement(restoredIndex)
        RestoreSnapshotResponse restoreSnapshotResponse1 = client.admin()
        CreateSnapshotResponse createSnapshotResponse = client.admin()
            Settings initialSettings = initialSettingsBuilder.build();
        );
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
                is(blocks.hasIndexBlock("test-idx", IndexMetadata.INDEX_READ_ONLY_BLOCK))
        } catch (SnapshotRestoreException ex) {
                .cluster()
                .setRenameReplacement(restoredIndex)
        try {
                .setIgnoreIndexSettings("index.analysis.*")
            SnapshotRestoreException.class,
        createIndex(indexName, indexSettingsNoReplicas(2).build());
            .setTransientSettings(Settings.builder().putNull(INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey()).build())
    public void testNoRemoteStoreCustomDataOnIndexCreationAndRestore() {
 * KIND, either express or implied.  See the License for the
            for (int i = 0; i < randomInt(3); i++) {
        createIndex("test-idx-1", "test-idx-2", "test-idx-3");
                mergedSettings.getAsBoolean(IndexMetadata.SETTING_BLOCKS_METADATA, false),
                containsString("expected max cap on auto expand to be a multiple of total awareness attributes [3]")
            .setRenameReplacement(restoredIndexName1)
            .build();
            .setIgnoreIndexSettings("index.analysis.*")
        assertTrue(exception.getMessage().contains("cannot remove UnmodifiableOnRestore setting [index.number_of_shards]" + " on restore"));
        }
        // index.version.created is UnmodifiableOnRestore, index.number_of_search_replicas is removable
        setupSnapshotRestore();
            .setRestoreGlobalState(true)
                .cluster()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertIndexTemplateExists;
        // index.number_of_replicas is USER_UNREMOVABLE_SETTINGS, index.number_of_search_replicas is removable
        logger.info("--> check that aliases are not restored and existing aliases still exist");
            () -> client().admin()
                IndexMetadata.SETTING_BLOCKS_METADATA,
        Settings newIncorrectReplicasIndexSettings = Settings.builder()
    private String restoredIndex;
                .actionGet();
            fail("Shouldn't be here");
                .setRenameReplacement("new-index-3")
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        CreateSnapshotResponse createSnapshotResponse = client.admin()
        } catch (InvalidIndexNameException ex) {
                .setIgnoreIndexSettings("index.analysis.*")
        Settings.Builder settingsBuilder = Settings.builder()
        try {
        assertTrue(client().admin().indices().prepareGetAliases("alias-123").get().getAliases().isEmpty());
        // try index restore with UnmodifiableOnRestore setting ignored
 * under the License.
    }
            .cluster()
        } catch (InvalidIndexNameException ex) {
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));
        assertThat(
        String restoredIndexName1 = indexName1 + "-restored";
                .cluster()
        // index.remote_store.enabled is USER_UNMODIFIABLE_SETTINGS, index.version.created is UnmodifiableOnRestore
        indexRandomDocs("test-idx-2", 100);
            .execute();
            logger.info("--> cleaning up blocks");
                .setIndices("test-index")
    protected Settings.Builder getIndexSettings(int numOfShards, int numOfReplicas) {
                .setRenameReplacement(restoredIndex)
        assertTrue(exception.getMessage().contains("cannot modify setting [index.remote_store.enabled]" + " on restore"));
    private String snapshotRepo;
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false)
                .setIndices(index)
                .setRenameReplacement(restoredIndex)
    public void testForbidDisableSoftDeletesDuringRestore() throws Exception {
                .setIndices(index)
                .setIndices("test-index")
        createRepository("test-repo", "fs");
                .setIndices("test-idx-1")
                    .setIndexSettings(
            SnapshotRestoreException.class,
            restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "snapshot-0")
                .get();
            .setIndices("test-idx")
        String docId = Integer.toString(randomInt());
        assertAcked(
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
        }
        assertThat(snapshotInfo2.successfulShards(), equalTo(snapshotInfo2.totalShards()));
        logger.info("--> restore index with correct settings from the snapshot");
        String restoredIndexName1 = indexName1 + "-restored";
 *
            .cluster()
        index(indexName2, "_doc", docId2, "value", expectedValue);
        setupSnapshotRestore();
    }
        assertThat(getSettingsResponse.getSetting("test-idx", INDEX_REFRESH_INTERVAL_SETTING.getKey()), equalTo("5s"));
            fail("Shouldn't be here");
        logger.info("--> restore cluster state");
        logger.info("--> create test index with case-preserving search analyzer");
        assertAcked(prepareCreate("test-idx", 2, indexSettings));
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        // We don't restore any indices here
        ensureGreen(validRenameReplacement);
                .actionGet();
import org.opensearch.transport.client.Client;
                        .startObject()
        snapshotRepo = "test-restore-snapshot-repo";
        createRepository("test-repo", "fs");
import java.util.stream.IntStream;
        // We don't restore any indices here
            assertAcked(deleteTemplate.execute().actionGet());
    }
            assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
            .put("index.analysis.analyzer.my_analyzer.type", "custom")
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
                .execute()
                .setWaitForCompletion(false)
        assertIndexTemplateExists(getIndexTemplatesResponse, "test-template");
        String docId = Integer.toString(randomInt());
        String invalidRenameReplacementString = "b".repeat(100000);
        GetSettingsResponse getSettingsResponse = client().admin().indices().prepareGetSettings("test-idx").execute().actionGet();
                .execute()
        );
                restoreError.getMessage(),
import java.util.List;
        clusterAdmin().prepareCreateSnapshot("test-repo", "snapshot-0").setIndices("test-index").setWaitForCompletion(true).get();
 *
        assertAcked(
            .getState()
            .prepareUpdateSettings()
            .getState()
                .setIndices("test-idx-1", "test-idx-2")
        logger.info("-->  delete and close indices");
                        .field("type", "keyword")
                .setRenameReplacement("alias-2")
            .setIndices(indexName1, indexName2)
                        .endObject()
            .execute();
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
        logger.info("--> snapshot");
                IndexMetadata.SETTING_READ_ONLY
                .addAlias("test-idx-1", "alias-1", false)
        // try index restore with multiple UnmodifiableOnRestore settings modified
        }
                .prepareRestoreSnapshot("test-repo", "test-snap")
                IllegalArgumentException.class,
        updateRepository(snapshotRepo, "fs", getRepositorySettings(absolutePath1, false));
                .get()
        assertAcked(client().admin().indices().prepareDelete(index));
            .prepareCreateSnapshot(repoName, snapshotName1)
        logger.info("--> try renaming indices using the same name");
            .prepareRestoreSnapshot("test-repo", "test-snap")
            List<String> initialBlockSettings = randomSubsetOf(
        logger.info("Path [{}]", absolutePath);
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
                .setIgnoreIndexSettings(IndexMetadata.SETTING_NUMBER_OF_SHARDS)
            restoreSnapshotResponse.getRestoreInfo().successfulShards(),
        final Settings.Builder settings = Settings.builder();
            createIndex(".system-index", Settings.builder().put("index.number_of_replicas", 0).build());
        // index.version.created is UnmodifiableOnRestore, index.number_of_search_replicas is modifiable
                .addAlias("test-idx-1", "alias-123")
        final int numPrimaries = getNumShards(indexName).numPrimaries;
                IndexMetadata.SETTING_BLOCKS_METADATA,
        createRepository("test-repo", "fs");
            logger.info("--> merged block settings {}", mergedSettings);
            .build();
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
        );
        createIndex("test-index", settings.build());
                .setIndices(index)
        );
            clusterAdmin().prepareCreateSnapshot("test-repo", "snapshot-0")
            assertThat(
        String docId2 = Integer.toString(randomInt());
                .prepareRestoreSnapshot("test-repo", "test-snap")
    }
            assertThat(restoredIndexMetadata.primaryTerm(shardId), greaterThan(primaryTerms.get(shardId)));
                () -> clusterAdmin().prepareRestoreSnapshot("test-repo", "snapshot-0")
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
        );
            .get();
        try {
                .get()
                .setWaitForCompletion(true)
        logger.info("--> close just restored indices");
                createSnapshotResponse.getSnapshotInfo().successfulShards(),
                .setRenameReplacement(restoredIndex)
        assertThat(client.prepareGet(restoredIndexName2, sameSourceIndex ? docId : docId2).get().isExists(), equalTo(true));
import static org.hamcrest.Matchers.allOf;
            .get();
                .setWaitForCompletion(true)
                .setIndexSettings(Settings.builder().put("index.number_of_replicas", 2).build())
import static org.hamcrest.Matchers.notNullValue;
            client().admin()
        ValidationException exception = expectThrows(
            RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
        );
                .setIndexSettings(mixedSettingsUserUnmodifiableSettings)
        Settings userUnmodifiableSettings = Settings.builder()
        );
        ensureGreen();
        setupSnapshotRestore();
    }
            fail("Shouldn't be here");
            );
            .cluster()
        SnapshotRestoreException exception = expectThrows(
import org.opensearch.core.common.unit.ByteSizeUnit;
                .setWaitForCompletion(false)
                IndexMetadata.SETTING_BLOCKS_WRITE,
    }
        String restoredIndexName2 = indexName2 + "-restored";
        final SnapshotInfo snapshotInfo = assertSuccessful(
        logger.info("--> create test indices");
    private SnapshotInfo snapshotInfo2;
                .setIndices(index)
                .cluster()
            client.admin()
        SnapshotRestoreException exception = expectThrows(
            .index(indexName);
            allOf(greaterThan(0), equalTo(restoreSnapshotResponse.getRestoreInfo().totalShards()))
                .indices()
        setupSnapshotRestore();
                .setIndexSettings(numberOfShardsSettingsSame)
        client.admin().indices().prepareClose("test-idx-1-copy", "test-idx-2-copy").get();
import org.opensearch.indices.InvalidIndexNameException;
                .cluster()
            equalTo(createSnapshotResponse2.getSnapshotInfo().totalShards())
                .setIndices(index)
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        Settings numberOfShardsSettingsSame = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).build();
            .build();
                .cluster()
            .setWaitForCompletion(true)
                .setIndexSettings(userUnmodifiableSettings)
            .build();
                    )
            SnapshotRestoreException.class,
        final int numdocs = randomIntBetween(10, 100);
        assertThat(
        // try index restore with multiple USER_UNREMOVABLE_SETTINGS settings ignored
                .setIndices(index)
            "fs",
        logger.info("--> delete the index and recreate it while deleting all index settings");
            );
import org.opensearch.Version;
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
            .cluster()
                2,
        }
            client.admin()
                .setPatterns(Collections.singletonList("te*"))
            SnapshotRestoreException.class,
        }
     */
        assertTrue(exception.getMessage().contains("cannot modify UnmodifiableOnRestore setting [index.version.created]" + " on restore"));
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
            () -> clusterAdmin().prepareRestoreSnapshot("test-repo", "snapshot-0")
    public void testInvalidRestoreRequest_MixRemovableAndUserUnRemovableSettingsIgnored() throws Exception {
        try {
        // b - 100000 times
                .get()
        assertAcked(client().admin().indices().preparePutMapping("test-idx").setSource("foo", "type=text"));
        assertTrue(exception.getMessage().contains("cannot remove setting [index.remote_store.enabled] on restore"));
                    .setRenamePattern("test-index")
                        .endObject()
            );
        String repoName = "test-restore-snapshot-repo";
        flushAndRefresh();
        );
            .put(INDEX_REFRESH_INTERVAL_SETTING.getKey(), "10s")
            .setWaitForCompletion(true)
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
    public void testInvalidRestoreRequest_UserUnRemovableSettingsIgnored() throws Exception {
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
            .actionGet();
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
                .get()
            .setWaitForCompletion(true)
            () -> client().admin()
import org.opensearch.common.unit.TimeValue;
        CreateSnapshotResponse createSnapshotResponse = client.admin()
            .clear()
    private Path absolutePath1;
        String indexName1 = "testindex1";
        assertThat(
        );
                "test-idx",
        String restoredIndexName1 = indexName1 + "-restored";
        logger.info("--> delete the index and recreate it with foo field");
        setupSnapshotRestore();
            .cluster()
                randomInt(3),
                .get()
        assertThat(restoreError.getMessage(), containsString("cannot disable setting [index.soft_deletes.enabled] on restore"));
        final SnapshotRestoreException restoreError = expectThrows(
        String snapshotName1 = "test-restore-snapshot1";
            .setWaitForCompletion(true)
        // try index restore with UnmodifiableOnRestore setting modified
            );
            .setMetadata(true)
        client().admin().indices().prepareClose("test-idx").get();
                .cluster()
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.V_EMPTY)
        String expectedValue = "expected";
            Settings.builder().put("location", randomRepoPath()).put("compress", randomBoolean()).put("chunk_size", 100, ByteSizeUnit.BYTES)
                .setSource("field1", "type=text,analyzer=standard,search_analyzer=my_analyzer")
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        );
                    .setIndices("test-index")
            SnapshotRestoreException.class,
                .setIndices("test-idx-1")
        setupSnapshotRestore();
                2,
        assertHitCount(client.prepareSearch("test-idx").setSize(0).setQuery(matchQuery("field1", "foo")).get(), numdocs);
        assertThat(snapshotInfo.successfulShards(), equalTo(0));
            .boxed()
import java.util.Map;
            .setRenameReplacement("$1-copy")
    }
        SnapshotRestoreException exception = expectThrows(
        logger.info("--> restore index with correct settings from the snapshot");
        assertThat(mappings.sourceAsMap().toString(), not(containsString("foo")));
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
            .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
            logger.info("--> restore index with additional block changes");
        cluster().wipeIndices("test-idx");
                .setRenameReplacement("test-idx-1")
 * this work for additional information regarding copyright
        assertAcked(
        setupSnapshotRestore();
        createRepository("test-repo", "fs");
        assertThat(getSettingsResponse.getSetting("test-idx", SETTING_NUMBER_OF_SHARDS), equalTo("" + numberOfShards));
        Path absolutePath = randomRepoPath().toAbsolutePath();
 *
        final Map<Integer, Long> primaryTerms = IntStream.range(0, numPrimaries)
        SnapshotRestoreException exception = expectThrows(
import org.opensearch.cluster.block.ClusterBlocks;
import static org.hamcrest.Matchers.equalTo;
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
            .setRenameReplacement(restoredIndexName1)
            .setIndices("test-idx-1")
                    .put("refresh_interval", 5, TimeUnit.SECONDS)
            createIndex("test-index", Settings.builder().put("index.number_of_replicas", 0).build());
            .prepareRestoreSnapshot(repoName, snapshotName)
        logger.info("--> close index");
                () -> clusterAdmin().prepareRestoreSnapshot("test-repo", "snapshot-0")
        assertTrue(exception.getMessage().contains("cannot modify UnmodifiableOnRestore setting [index.number_of_shards]" + " on restore"));
            .setIncludeAliases(false)
        try {
                .cluster()
                .setIndices(index)
                .execute()
        for (int shardId = 0; shardId < numPrimaries; shardId++) {
}
            .get();
                .setRenamePattern(index)
        assertTrue(exception.getMessage().contains("cannot modify setting [index.remote_store.enabled]" + " on restore"));
import org.opensearch.action.index.IndexRequestBuilder;
import static org.opensearch.index.IndexSettings.INDEX_SOFT_DELETES_SETTING;
                .setIndexSettings(
                .prepareRestoreSnapshot("test-repo", "test-snap")
        assertNull(state.metadata().index(restoredIndexName1).getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY));
        // try index restore with mix of UnmodifiableOnRestore and USER_UNREMOVABLE_SETTINGS settings ignored
/*
                .get()
                .setRenamePattern(".system-index")
        assertHitCount(client.prepareSearch("test-idx").setSize(0).setQuery(matchQuery("field1", "Foo")).get(), numdocs);
        assertThat(restoredIndexMetadata.getSettings().get(IndexMetadata.SETTING_HISTORY_UUID), notNullValue());
            .get();
            .prepareUpdateSettings()
        assertHitCount(client.prepareSearch("test-idx").setSize(0).setQuery(matchQuery("field1", "bar")).get(), numdocs);
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
        assertTrue(exception.getMessage().contains("cannot modify UnmodifiableOnRestore setting [index.number_of_shards]" + " on restore"));
            .setMetadata(true)
                        .field("store", true)
            .setIndices(indexName1)
        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertIndexTemplateMissing;
        SnapshotRestoreException exception = expectThrows(
        logger.info("Path [{}]", absolutePath);
        Settings newIncorrectIndexSettings = Settings.builder()
                .setRenamePattern("test-idx-2")
            .put("refresh_interval", "5s")
        assertThat(snapshotInfo.totalShards(), equalTo(0));
                .execute()
        // try index restore with mix of modifiable and USER_UNMODIFIABLE_SETTINGS settings modified
            );
        logger.info("--> snapshot");
        // Validate that the remote_store custom data is not present in index metadata for the restored index.
        assertDocCount("test-idx", 100L);
                .setWaitForCompletion(false)
                "test-idx",
        assertThat(getSettingsResponse.getSetting("test-idx", "index.refresh_interval"), equalTo("10s"));
                .execute()
            .put(INDEX_REFRESH_INTERVAL_SETTING.getKey(), "10s");
            .cluster()
        String repoName = "test-restore-snapshot-repo";
        assertThat(getSettingsResponse.getSetting("test-idx", "index.analysis.analyzer.my_analyzer.type"), equalTo("standard"));
                .setIndices(index)
        assertFalse(client().admin().indices().prepareGetAliases("alias-3").get().getAliases().isEmpty());
                .setIndices(index)
            SnapshotRestoreException.class,
            .setWaitForCompletion(true)
        Client client = client();
                .setIgnoreIndexSettings(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS)
            RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "snapshot-0")
        assertThat(
        logger.info("--> create index with baz field");
        createRepository("test-repo", "fs");
        createIndexWithRandomDocs("test-idx", 100);
        logger.info("--> snapshot it");
        SnapshotRestoreException exception = expectThrows(
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
import org.opensearch.common.ValidationException;
            .actionGet();
    }
            () -> client().admin()
        assertThat(createSnapshotResponse.getSnapshotInfo().failedShards(), equalTo(0));
                .get()
                .get()
        logger.info("-->  delete all indices");
        ensureGreen();
            SnapshotRestoreException.class,
import java.util.Locale;
            .setWaitForCompletion(true)
        );
    public void testValidRenameReplacementPattern() {
            logger.info("--> using initial block settings {}", initialSettings);
                .cluster()
        // index.remote_store.enabled is USER_UNMODIFIABLE_SETTINGS, index.number_of_search_replicas is modifiable
        cluster().wipeIndices("test-idx-1", "test-idx-2", "test-idx-3");
        // Make sure that number of shards didn't change
            }
            IllegalArgumentException.class
 * SPDX-License-Identifier: Apache-2.0
        logger.info("--> restore snapshot with aliases");
            .execute()
                .setRenamePattern(index)
                .cluster()
            .prepareCreateSnapshot(repoName, snapshotName2)
                    .setRenameReplacement("new-index")
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequestBuilder;
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        snapshotName2 = "test-restore-snapshot2";
        String indexName1 = "testindex1";
        ensureGreen(index);
        setupSnapshotRestore();
import java.util.stream.Collectors;
                .setWaitForCompletion(true)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                .setWaitForCompletion(false)
public class RestoreSnapshotIT extends AbstractSnapshotIntegTestCase {
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        // Validate that the remote_store custom data is not present in index metadata for the created index.
    public void testChangeSettingsOnRestore() throws Exception {
        }
        if (randomBoolean()) {
        );
            .setWaitForCompletion(false)
            fail("Shouldn't be here");
            fail("Shouldn't be here");
        assertTrue(exception.getMessage().contains("cannot modify setting [index.remote_store.enabled]" + " on restore"));
                is(blocks.hasIndexBlock("test-idx", IndexMetadata.INDEX_WRITE_BLOCK))
            .prepareRestoreSnapshot("test-repo", "test-snap")
                .cluster()
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
 *    http://www.apache.org/licenses/LICENSE-2.0
        try {
            .actionGet();
    public void testInvalidRestoreRequest_UnmodifiableOnRestoreIgnored() throws Exception {
            final IllegalArgumentException restoreError2 = expectThrows(
    }
            client.admin()
                .setRenamePattern(index)
        assertAcked(
        CreateSnapshotResponse createSnapshotResponse = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap")
            .setRenameReplacement(restoredIndexName2)
                .preparePutMapping("test-idx")
        );
            equalTo(SnapshotState.SUCCESS)
                .get()
        String indexName2 = "testindex2";
            .cluster()
    }
    public void testInvalidRestoreRequest_MixModifiableAndUnmodifiableOnRestoreModified() throws Exception {
                restorePause += repositoriesService.repository("test-repo").getRestoreThrottleTimeInNanos();
                .setIndices(index)
            ensureGreen();
        client().admin().cluster().prepareRestoreSnapshot(snapshotRepo, snapshotName1).setWaitForCompletion(true).setIndices(index).get();
        logger.info("--> try restoring while changing the number of shards - should fail");
        assertTrue(client().admin().indices().prepareGetAliases("alias-123").get().getAliases().isEmpty());
        assertThat(getSettingsResponse.getSetting("test-idx", SETTING_NUMBER_OF_SHARDS), equalTo("" + numberOfShards));
        } catch (SnapshotRestoreException ex) {
                    .put(indexSettings())
        GetIndexTemplatesResponse getIndexTemplatesResponse = client().admin().indices().prepareGetTemplates().get();
                .isAcknowledged(),
            .setWaitForCompletion(false)
                .setIndices(".system-index")
        assertThat(indexMetadata.getSettings().get(IndexMetadata.SETTING_HISTORY_UUID), nullValue());
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
                .setWaitForCompletion(true)
                .setRenamePattern(index)
            .get()
                .setRenameReplacement(restoredIndex)
                        .field("store", true)
                .setIndices("test-idx")
                .setIndexSettings(Settings.builder().put(INDEX_SOFT_DELETES_SETTING.getKey(), false))
            .execute()
        );
        SnapshotRestoreException exception = expectThrows(
                .setRenameReplacement(restoredIndex)
            clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap").setIndices().setWaitForCompletion(true).execute()
        setupSnapshotRestore();
            SnapshotRestoreException.class,
                .actionGet();
        index(indexName1, "_doc", docId, "value", expectedValue);
        assertTrue(exception.getMessage().contains("cannot remove setting [index.number_of_replicas]" + " on restore"));
        cluster().wipeIndices("test-idx-1", "test-idx-1-copy", "test-idx-2", "test-idx-2-copy");
                assertAcked(client().admin().indices().prepareClose(indexName));
            SnapshotRestoreException.class,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .get()
            .setRestoreGlobalState(true)
        String repoName = "test-restore-snapshot-repo";
        assertTrue(exception.getMessage().contains("cannot remove UnmodifiableOnRestore setting [index.number_of_shards] on restore"));
        }
    public void testRestoreAliases() throws Exception {
     * time of index creation and after snapshot restore.
        assertDocCount("test-idx-2-copy", 100L);
        assertThat(
            SnapshotRestoreException.class,
            SnapshotRestoreException.class,
                .setRenameReplacement(restoredIndex)
                .indices()
        );
        String expectedValue = "expected";
            .setWaitForCompletion(true)
        logger.info("--> try renaming indices using the same name");
        cluster().wipeIndices("test-idx");
    public void testInvalidRestoreRequest_MultipleUnmodifiableOnRestoreIgnored() throws Exception {
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
                .get()
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numdocs];
            prepareCreate(
            .prepareCreateSnapshot(repoName, snapshotName1)
            Settings mergedSettings = Settings.builder().put(initialSettings).put(changedSettings).build();
            .get();
                .setRenamePattern(index)
            final IllegalArgumentException restoreError = expectThrows(
        Settings mixedSettingsUserUnmodifiableSettings = Settings.builder()
            client.admin()
            () -> client().admin()
                .setIndices(index)
        assertThat(restoreSnapshotResponse1.status(), equalTo(RestStatus.ACCEPTED));
    }
                .setRenameReplacement("alias-3")
    }
                .execute()
                .cluster()
            .setIndices(indexName)
            .put(newIndexSettings)
            .get();
            cluster().wipeIndices("test-idx");
        assertTrue(client().admin().indices().prepareGetAliases("alias-123").get().getAliases().isEmpty());
            for (RepositoriesService repositoriesService : internalCluster().getDataNodeInstances(RepositoriesService.class)) {
        assertAcked(client().admin().indices().prepareClose(indexName));
        assertThat(restoreSnapshotResponse1.get().status(), equalTo(RestStatus.ACCEPTED));
                    .setRenamePattern("test-index")
                .setMapping(
            () -> client().admin()
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        final IndexMetadata restoredIndexMetadata = clusterAdmin().prepareState()
        assertAcked(client.admin().indices().prepareClose("test-idx-1", "test-idx-2-copy"));
        MappingMetadata mappings = clusterAdmin().prepareState().get().getState().getMetadata().getIndices().get("test-idx").mapping();
        client.admin()
            .metadata()
        assertThat(createSnapshotResponse2.getSnapshotInfo().state(), equalTo(SnapshotState.SUCCESS));
/*
    public void testInvalidRestoreRequest_MixUnmodifiableOnRestoreAndUserUnmodifiableSettingsModified() throws Exception {
        Client client = client();
        );
                    .get()
                .get()
    /**
            }
    }
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
        assertAcked(client().admin().indices().prepareAliases().addAlias("test-idx-3", "alias-3"));
                .setRenamePattern(index)
                        .endObject()
            logger.info("--> remove blocks and delete index");
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
        assertBusy(() -> {
    private String snapshotName1;
        );
        logger.info("--> restore indices with different names");
            ValidationException.class,
            .setRenameReplacement("$1-copy")
        createRepository("test-repo", "fs");
        ensureGreen(restoredIndexName1, restoredIndexName2);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        createRepository("test-repo", "fs");
        assertRequestBuilderThrows(
                .setRenamePattern(index)
            SnapshotRestoreException.class,
import static org.hamcrest.Matchers.greaterThan;
            .prepareRestoreSnapshot("test-repo", "test-snap")
        );
        assertThat(restoreSnapshotResponse2.get().status(), equalTo(RestStatus.ACCEPTED));
    public void testInvalidRestoreRequest_MixRemovableAndUnmodifiableOnRestoreIgnored() throws Exception {
                .cluster()
            .setIgnoreIndexSettings("*") // delete everything we can delete
import static org.opensearch.index.IndexSettings.INDEX_REFRESH_INTERVAL_SETTING;
            .prepareCreateSnapshot("test-repo", "test-snap")
            disableIndexBlock("test-idx", IndexMetadata.SETTING_BLOCKS_METADATA);
    public void testInvalidRestoreRequest_UnmodifiableOnRestoreUnchanged() throws Exception {
            () -> client().admin()
                .execute()
        Settings remoteStoreEnabledSetting = Settings.builder().put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false).build();
     * In this test, we test that an index created does not have any remote_store custom data in index metadata at the
        assertThat(createSnapshotResponse.getSnapshotInfo().state(), equalTo(SnapshotState.SUCCESS));
            disableIndexBlock("test-idx", IndexMetadata.SETTING_BLOCKS_WRITE);
            assertThat(
                .setIndices(index)
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
            DeleteIndexTemplateRequestBuilder deleteTemplate = client().admin().indices().prepareDeleteTemplate("random_index_template");
        assertThat(createSnapshotResponse.getSnapshotInfo().state(), equalTo(SnapshotState.SUCCESS));
                .setRenamePattern(".+")
        Client client = client();
        );
            () -> client().admin()
            );
        logger.info("--> delete index");
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "300s");
                logger.info("--> apply initial blocks to index");
        getSettingsResponse = client.admin().indices().prepareGetSettings("test-idx").execute().actionGet();
import java.util.ArrayList;
                .cluster()
 * ownership. Elasticsearch licenses this file to you under
                .cluster()
        assertThat(
                .execute()
            .get();
            .get();
            .get();
        if (randomBoolean()) {
            .get();
                .addAlias("test-idx-3", "alias-3", false)
    }
                .addAlias("test-idx-2", "alias-2", false)
        RestoreSnapshotResponse restoreSnapshotResponse2 = client.admin()
            .execute()
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;
                .prepareRestoreSnapshot("test-repo", "test-snap")
 * license agreements. See the NOTICE file distributed with
                .get();
        }
import org.opensearch.index.IndexSettings;
    }
                .setRenameReplacement(".system-index-restore-1")
    public void testRenameOnRestore() throws Exception {
                randomInt(4),
        setupSnapshotRestore();
        setupSnapshotRestore();
            CreateSnapshotResponse createSnapshotResponse = client.admin()
            for (String blockSetting : changeBlockSettings) {
                .setRenameReplacement("same-name")
        logger.info("--> try renaming indices using invalid index name");
        snapshotName1 = "test-restore-snapshot1";
        ensureGreen();
        createRepository(repoName, "fs", absolutePath);
            .setWaitForCompletion(true)
import static org.opensearch.index.query.QueryBuilders.matchQuery;
                        .startObject("properties")
                .setRenamePattern(index)
                .cluster()
                .prepareRestoreSnapshot("test-repo", "test-snap")
                .get()
        assertThat(
                IndexMetadata.SETTING_BLOCKS_READ
                .setRenameReplacement(restoredIndex)
            disableIndexBlock("test-idx", IndexMetadata.SETTING_BLOCKS_READ);
                .setIndices("test-idx-1")
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            .put("index.analysis.analyzer.my_analyzer.tokenizer", "standard");
                .setWaitForCompletion(true)
            restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "snapshot-0")
                .setRenameReplacement(restoredIndex)
            // open and close the index to increase the primary terms
        Settings.Builder indexSettings = Settings.builder()
            .cluster()
                .setIndexSettings(mixedSettings)
                .setIgnoreIndexSettings(IndexMetadata.SETTING_NUMBER_OF_SHARDS, IndexMetadata.SETTING_VERSION_CREATED)
                .cluster()
            Settings.Builder initialSettingsBuilder = Settings.builder();
            long restorePause = 0L;
            .setIndices(indexName)
        );
                .cluster()
                .setIndexSettings(newIncorrectReplicasIndexSettings)
            logger.info("--> checking consistency between settings and blocks");
                .indices()
        ensureGreen();
        // try index restore with USER_UNMODIFIABLE_SETTINGS setting modified
            assertThat(
            logger.info("--> snapshot index");
        final String indexName = randomAlphaOfLengthBetween(5, 10).toLowerCase(Locale.ROOT);
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
                .setWaitForCompletion(false)
        NumShards numShards = getNumShards("test-idx");
                .cluster()
                    .put("refresh_interval", 10, TimeUnit.SECONDS)
    public void testInvalidRestoreRequest_UnmodifiableOnRestoreModified() throws Exception {
import org.opensearch.cluster.metadata.IndexMetadata;
            () -> client().admin()
            .cluster()
                .setWaitForCompletion(false)
            Settings.Builder changedSettingsBuilder = Settings.builder();
            .build();
        assertThat(client.prepareGet(restoredIndexName2, docId2).get().isExists(), equalTo(true));
                    .setRenameReplacement("new-index-2")
            SnapshotRestoreException.class,
                .actionGet();
                .setIndices(index)
        restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
        logger.info("--> snapshot");
                .cluster()
        index(indexName2, "_doc", docId2, "value", expectedValue);
            .put("index.analysis.analyzer.my_analyzer.type", "standard")
        ensureGreen(restoredIndexName1);
            .prepareCreateSnapshot(repoName, snapshotName)
            .setIndexSettings(newIndexSettings)
        assertThat(getSettingsResponse.getSetting("test-idx", INDEX_REFRESH_INTERVAL_SETTING.getKey()), equalTo("5s"));
            .put(SETTING_NUMBER_OF_REPLICAS.substring(IndexMetadata.INDEX_SETTING_PREFIX.length()), randomIntBetween(-10, -1))
        }
    public void testRestoreWithDifferentMappingsAndSettings() throws Exception {
        return settingsBuilder;
            disableIndexBlock("test-idx", IndexMetadata.SETTING_BLOCKS_METADATA);
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse;
            .setRenamePattern(indexName1)
        );
            );
 * The OpenSearch Contributors require contributions made to
        // try index restore with UnmodifiableOnRestore setting unchanged
        logger.info("--> snapshot");
            () -> client().admin()
            .metadata()
        Client client = client();
                .cluster()
        assertAcked(client().admin().indices().prepareAliases().removeAlias("test-idx-3", "alias-123"));
            .setRenamePattern("(.+-2)")
        ensureGreen(index);
        try {
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();
                .setRenamePattern("(.+)")
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), equalTo(0));
            .setRenameReplacement("alias")
                        .startObject("field2")
            fail("Shouldn't be here");
        final RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
    }
            }
            .setIndices(index)
            .execute()
            .execute()
                .get()
    public void testParallelRestoreOperationsFromSingleSnapshot() throws Exception {
        createRepository(
 * Licensed to Elasticsearch under one or more contributor
        restoreSnapshotResponse = client.admin()
        logger.info("--> restore snapshot without aliases");
                Settings.builder()
            .setWaitForCompletion(true)
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), equalTo(0));
    public void testInvalidRestoreRequest_MultipleUserUnmodifiableSettingsModified() throws Exception {
        logger.info("--> restore all indices from the snapshot");
            .get()
import org.opensearch.common.settings.Settings;
        createRepository(repoName, "fs", absolutePath);
            .cluster()
            .cluster()
            .execute()
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        String docId2 = Integer.toString(randomInt());
        createRepository("test-repo", "fs");
        if (randomBoolean()) {
            assertThat(
        logger.info("--> snapshot");
            () -> client().admin()
        ActionFuture<RestoreSnapshotResponse> restoreSnapshotResponse = client.admin()
    }
        Client client = client();
        } catch (SnapshotRestoreException ex) {
                .prepareRestoreSnapshot("test-repo", "test-snap")
 * software distributed under the License is distributed on an
        String snapshotName = "test-restore-snapshot";
        int numberOfShards = getNumShards("test-idx").numPrimaries;
                .setRenameReplacement(restoredIndex)
    }
                .setRenamePattern("test-index")
        String snapshotName2 = "test-restore-snapshot2";
            .cluster()
        } catch (SnapshotRestoreException ex) {
                .setRenamePattern("test-idx")
                .get()
                .prepareRestoreSnapshot("test-repo", "test-snap")
                .prepareRestoreSnapshot("test-repo", "test-snap")
    private Settings indexSettings;
        for (int i = 0; i < builders.length; i++) {
                    .get()
                .setWaitForCompletion(false)
        assertHitCount(client.prepareSearch("test-idx").setSize(0).setQuery(matchQuery("field1", "bar")).get(), numdocs);
        CreateSnapshotResponse createSnapshotResponse = client.admin()
        RestoreSnapshotResponse restoreSnapshotResponse1 = client.admin()
        client.admin()
            .prepareCreateSnapshot("test-repo", "test-snap")
        logger.info("--> delete the index and recreate it while changing refresh interval and analyzer");
            () -> client().admin()
        setupSnapshotRestore();
        SnapshotRestoreException exception = expectThrows(
            client.admin()
            )
            assertThat(
            clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap")
                .execute()
 * Unless required by applicable law or agreed to in writing,
            .setRenamePattern("(.+)")
        logger.info("--> and try to restore these indices again");
        try {
import static org.opensearch.indices.recovery.RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        logger.info("--> restore indices with different names");
                .prepareAliases()
        Settings numberOfShardsSettingsDiff = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3).build();
        );
            disableIndexBlock("test-idx", IndexMetadata.SETTING_BLOCKS_READ);
        assertThat(restoreSnapshotResponse.get(20L, TimeUnit.SECONDS).getRestoreInfo().totalShards(), greaterThan(0));
            .setTransientSettings(Settings.builder().put(INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(), "100b").build())
                        Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 1).put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-1").build()
            prepareCreate(
        assertThat(
                .setWaitForCompletion(false)
        assertThat(createSnapshotResponse.getSnapshotInfo().state(), equalTo(SnapshotState.SUCCESS));
                    Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 0).put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-2").build()
        final IndexMetadata indexMetadata = clusterAdmin().prepareState()
                .addAlias("test-idx-3", "alias-123")
 */
            assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
        assertDocCount("test-idx-1-copy", 100L);
        absolutePath1 = randomRepoPath().toAbsolutePath();
            SnapshotRestoreException.class,
            .setIndices(sameSourceIndex ? indexName1 : indexName2)
        String docId = Integer.toString(randomInt());
                .setRenamePattern(index)
        assertThat(client.prepareGet(restoredIndexName1, docId).get().isExists(), equalTo(true));
        );
                .setIgnoreIndexSettings(IndexMetadata.SETTING_VERSION_CREATED, IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS)
                .setWaitForCompletion(true)
        logger.info("Snapshot Path [{}]", absolutePath1);
        );
    public void testRestoreIncreasesPrimaryTerms() {
            disableIndexBlock("test-idx", IndexMetadata.SETTING_READ_ONLY);
                .cluster()
                .setIgnoreIndexSettings(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS)
import static org.hamcrest.Matchers.is;
    public void testDynamicRestoreThrottling() throws Exception {
        assertThat(mappings.sourceAsMap().toString(), containsString("baz"));
        assertThat(getSnapshot("test-repo", "test-snap").state(), equalTo(SnapshotState.SUCCESS));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            .cluster()
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), equalTo(numPrimaries));
        assertThat(restoreSnapshotResponse2.status(), equalTo(RestStatus.ACCEPTED));
        ensureGreen(indexName);
        assertThat(client.prepareGet(restoredIndexName1, docId).get().isExists(), equalTo(true));
            .setWaitForCompletion(true)
        assertFalse(client().admin().indices().prepareGetAliases("alias-123").get().getAliases().isEmpty());
        ensureGreen(restoredIndexName1, restoredIndexName2);
                .setIndices("test-index", ".system-index")
        logger.info("--> assert that old settings are restored");
            createRepository("test-repo", "fs");
            .prepareRestoreSnapshot(repoName, snapshotName2)
                .setWaitForCompletion(false)
                .setIgnoreIndexSettings(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, IndexMetadata.SETTING_NUMBER_OF_SHARDS)
                mergedSettings.getAsBoolean(IndexMetadata.SETTING_BLOCKS_WRITE, false),
            settings.put(INDEX_SOFT_DELETES_SETTING.getKey(), true);
import java.util.concurrent.TimeUnit;
    public void testInvalidRestoreRequest_MultipleUserUnRemovableSettingsIgnored() throws Exception {
        logger.info("--> try renaming indices into existing alias of itself");
        } finally {
                .setWaitForCompletion(true)
        assertThat(
            .actionGet();
                .setRenameReplacement(restoredIndex)
        }
        assertAcked(prepareCreate("test-idx", 2, indexSettings));
        Settings unmodifiableOnRestoreSettings = Settings.builder()
            .build();
            .cluster()
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
            .setRenameReplacement("$1-copy")
            .cluster()
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
                .setRenameReplacement("new-index")
            .actionGet();
            assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
            // Expected
        // try index restore with mix of removable and USER_UNREMOVABLE_SETTINGS settings ignored
            .put(SETTING_NUMBER_OF_REPLICAS, between(0, 1))
        );
            .build();
                client().admin().indices().prepareUpdateSettings("test-idx").setSettings(initialSettingsBuilder).get();
                .setIndexSettings(remoteStoreEnabledSetting)
                .cluster()
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
            );
        assertDocCount("test-idx-1-copy", 100L);
    public void testRestoreTemplates() throws Exception {
 */
                .setRenamePattern(index)
            .setRenamePattern("test-idx")
        logger.info("--> snapshot");
import static org.hamcrest.Matchers.nullValue;
        indexRandomDocs("test-idx-1", 100);
            .setWaitForCompletion(true)
    public void testEmptyRenameReplacementPattern() {
import java.nio.file.Path;
                )
            .setWaitForCompletion(true)
        // try index restore with multiple UnmodifiableOnRestore settings ignored
            .setRenamePattern(index)
        assertFalse(client().admin().indices().prepareGetAliases("alias-123").get().getAliases().isEmpty());
                .setRenameReplacement(invalidRenameReplacementString)
            .setRenamePattern("(.+)")
    }
            disableIndexBlock("test-idx", IndexMetadata.SETTING_READ_ONLY);
        // run at full speed again
                .setWaitForCompletion(true)
            ClusterBlocks blocks = client.admin().cluster().prepareState().clear().setBlocks(true).get().getState().blocks();
                .setWaitForCompletion(true)
                .setRenameReplacement("__WRONG__")
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
                .setIndexSettings(newIncorrectIndexSettings)
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
            .setWaitForCompletion(true)
        boolean sameSourceIndex = randomBoolean();
        assertIndexTemplateMissing(getIndexTemplatesResponse, "test-template");
                .setWaitForCompletion(false)
            () -> client().admin()
                .execute()
                .setRenamePattern("test-index")
                mergedSettings.getAsBoolean(IndexMetadata.SETTING_BLOCKS_READ, false),
        Path absolutePath = randomRepoPath().toAbsolutePath();
            builders[i] = client().prepareIndex("test-idx").setId(Integer.toString(i)).setSource("field1", "Foo bar " + i);
    }
        String indexName2 = "testindex2";
        // check if throttling is active
                        .endObject()
        setupSnapshotRestore();
        assertHitCount(client.prepareSearch("test-idx").setSize(0).setQuery(matchQuery("field1", "bar")).get(), numdocs);
            client.admin()
        cluster().wipeIndices("test-idx");
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
                .state(),
                IndexMetadata.SETTING_BLOCKS_WRITE,
        // try index restore with mix of modifiable and UnmodifiableOnRestore settings modified
        logger.info("Path [{}]", absolutePath);
                .actionGet();
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
            .execute()
    }
            .setIndices(indexName)
        SnapshotRestoreException exception = expectThrows(
            .setWaitForCompletion(false)
                .setIndices()
            .actionGet();
        cluster().wipeIndices("test-idx-1", "test-idx-2");
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false)
 * Modifications Copyright OpenSearch Contributors. See
        restoreSnapshotResponse = client.admin()
            );
        // try index restore with mix of UnmodifiableOnRestore and USER_UNMODIFIABLE_SETTINGS settings modified
            randomIndexTemplate();
            // Expected
        client.admin().cluster().prepareCreateSnapshot("test-repo", "test-snap").setWaitForCompletion(true).setIndices("test-idx").get();
 */
        logger.info("--> assert that old mapping is restored");
            .setRenamePattern(sameSourceIndex ? indexName1 : indexName2)
/*
    public void testInvalidRestoreRequest_UserUnmodifiableSettingsModified() throws Exception {
        ensureGreen(index);
        String restoredIndexName2 = indexName2 + "-restored";
            );
                Settings.builder()
        assertTrue(exception.getMessage().contains("cannot modify setting [index.remote_store.enabled]" + " on restore"));
    private String index;
                changedSettingsBuilder.put(blockSetting, randomBoolean());
        SnapshotRestoreException exception = expectThrows(
            .cluster()
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        Client client = client();
                .setRenameReplacement(restoredIndex)
        SnapshotRestoreException exception = expectThrows(
        assertTrue(client().admin().indices().prepareGetAliases("alias-1").get().getAliases().isEmpty());
            .get();
                .get()
        SnapshotRestoreException exception = expectThrows(
            .setRenamePattern(indexName1)
        );
            client().admin()
        // Write a document
    }
        indexRandom(true, builders);
            );
        snapshotInfo = createSnapshot(snapshotRepo, snapshotName1, new ArrayList<>(List.of(index)));
    }
            .setRenameReplacement(validRenameReplacement)
        index(indexName1, "_doc", docId, "value", expectedValue);
                .setWaitForCompletion(true)
                .indices()
            .prepareRestoreSnapshot(repoName, snapshotName1)
                assertAcked(client().admin().indices().prepareOpen(indexName));
        logger.info("--> try restoring while changing the number of replicas to a negative number - should fail");
            createSnapshotResponse2.getSnapshotInfo().successfulShards(),
            .setRenamePattern(indexName2)
        assertAcked(client().admin().indices().preparePutMapping("test-idx").setSource("baz", "type=text"));
            .prepareRestoreSnapshot("test-repo", "test-snap")
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
    public void testInvalidRenameReplacementPattern() {
            }
package org.opensearch.snapshots;
        assertThat(restoreSnapshotResponse.getRestoreInfo().successfulShards(), equalTo(numPrimaries));
        assertTrue(exception.getMessage().contains("cannot remove UnmodifiableOnRestore setting [index.version.created] on restore"));
            .setIndices(indexName1)
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
                .setIgnoreIndexSettings(IndexMetadata.SETTING_REMOTE_STORE_ENABLED)
        ensureGreen();
                .cluster()
        }, 30, TimeUnit.SECONDS);
            () -> client().admin()
    private String snapshotName2;
                    .setIndices("test-index")
        assertThat(
                .setRenamePattern(index)
        // We don't restore any indices here
            // Expected
        // Write a document
            .execute()
                .setIndices(index)
                .setWaitForCompletion(true)
        );
        assertThat(snapshotInfo2.successfulShards(), greaterThan(0));
            .prepareRestoreSnapshot("test-repo", "test-snap")
                .setRenamePattern(index)
            .put(newIndexSettings)
        Settings mixedSettingsUnmodifiableOnRestore = Settings.builder()
            .setIncludeAliases(false)
        getIndexTemplatesResponse = client().admin().indices().prepareGetTemplates().get();
import org.opensearch.cluster.ClusterState;
            .build();
import org.opensearch.common.xcontent.XContentFactory;
            .actionGet();
        String validRenameReplacement = "restored-index";
        String snapshotName1 = "test-restore-snapshot1";
        createRepository(repoName, "fs", absolutePath);
            equalTo(true)
            () -> client().admin()
                .setRenamePattern(index)
import org.opensearch.common.action.ActionFuture;
            client.admin()
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
            .setIndexSettings(newIndexSettings)
                .setRenamePattern("test-index")
            assertFalse(restoreSnapshotResponse.isDone());
                    .put(SETTING_NUMBER_OF_REPLICAS, between(0, 1))
        );
                .setIndexSettings(unmodifiableOnRestoreSettings)
        logger.info("--> assert that correct settings are restored and index is still functional");
            .actionGet();
                .setIndices(index)
        assertTrue(client().admin().indices().prepareGetAliases("alias-1").get().getAliases().isEmpty());
        CreateSnapshotResponse createSnapshotResponse = client.admin()
                .actionGet();
        logger.info("--> restore index");
            )
 * not use this file except in compliance with the License.
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numOfShards)
 * specific language governing permissions and limitations
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
                .actionGet();
                .actionGet();
            .prepareRestoreSnapshot(repoName, snapshotName1)
        snapshotInfo2 = createSnapshot(snapshotRepo, snapshotName2, new ArrayList<>(List.of(index)));
            .get();
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
                .setWaitForCompletion(false)
        logger.info("-->  delete test template");
    }
        logger.info("--> delete indices");
                restoreError2.getMessage(),
            SnapshotRestoreException.class
            .setRenamePattern(indexName1)
            allOf(greaterThan(0), equalTo(restoreSnapshotResponse.getRestoreInfo().totalShards()))
            .put(SETTING_NUMBER_OF_SHARDS, numberOfShards + 100)
import org.opensearch.repositories.RepositoriesService;
    }
                .setWaitForCompletion(true)
            .put(super.indexSettings())
            .setRenameReplacement(restoredIndexName1)
            .setWaitForCompletion(true)
        assertTrue(exception.getMessage().contains("rename_replacement string size exceeds max allowed size"));
                .get()
        logger.info("--> try renaming indices into existing alias of itself, but don't restore aliases ");
                .setIndexSettings(numberOfShardsSettingsDiff)
                .addAlias("test-idx-2", "alias-123")
            SnapshotRestoreException.class,
            SnapshotRestoreException.class,
            // Expected
        // try index restore with USER_UNREMOVABLE_SETTINGS setting ignored
                .setWaitForCompletion(false)
 * GitHub history for details.
                .setWaitForCompletion(true),
            manageReplicaSettingForDefaultReplica(false);
            .setWaitForCompletion(true)
            // compute current index settings (as we cannot query them if they contain SETTING_BLOCKS_METADATA)
        createIndex(index, indexSettings);
                .preparePutTemplate("test-template")
        assertThat(snapshotInfo2.state(), equalTo(SnapshotState.SUCCESS));
 * compatible open source license.
                .addAlias("test-idx-1", "alias-1")
    public void setupSnapshotRestore() {
                .get()
                .setRenamePattern(".+")
            manageReplicaSettingForDefaultReplica(true);
            }
        // check that restore now completes quickly (i.e. within 20 seconds)
        );
        ActionFuture<RestoreSnapshotResponse> restoreSnapshotResponse2 = client.admin()
        setupSnapshotRestore();
        index(indexName1, "_doc", docId, "value", expectedValue);
    public void testRestoreBalancedReplica() {
            .put(indexSettings())
            .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
        logger.info("--> close indices");
    }
        logger.info("--> snapshot");
        String indexName1 = "testindex1";
                IllegalArgumentException.class,
        String expectedValue = "expected";
                .prepareCreateSnapshot("test-repo", "test-snap")
    }
        setupSnapshotRestore();
        SnapshotRestoreException exception = expectThrows(
import java.util.Collections;
                .prepareRestoreSnapshot("test-repo", "test-snap")
    public void testInvalidRestoreRequest_MultipleUnmodifiableOnRestoreModified() throws Exception {
    public void testRecreateBlocksOnRestore() throws Exception {
                    .put(SETTING_NUMBER_OF_REPLICAS, between(0, 1))
                .setWaitForCompletion(true),
            if (!initialSettings.isEmpty()) {
                .setRenamePattern(index)
                .get()
                .setRenameReplacement("alias")
    }
    }
            .prepareRestoreSnapshot(repoName, snapshotName)
            .put(SETTING_NUMBER_OF_REPLICAS, between(0, 1))
        assertHitCount(client.prepareSearch("test-idx").setSize(0).setQuery(matchQuery("field1", "Foo")).get(), numdocs);
            .cluster()
 * the Apache License, Version 2.0 (the "License"); you may
        assertTrue(client().admin().indices().prepareGetAliases("alias-1").get().getAliases().isEmpty());
            .cluster()
        );
            .setWaitForCompletion(true)
        GetSettingsResponse getSettingsResponse = client.admin().indices().prepareGetSettings("test-idx").execute().actionGet();
                .get()
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        client().admin()
            logger.info("--> applying changed block settings {}", changedSettings);
        logger.info("--> try renaming indices into existing alias name");
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.V_EMPTY)
        }
            // Expected
        logger.info("--> snapshot");
                .setRenameReplacement(restoredIndex)
            assertThat(
            .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
                .setWaitForCompletion(false)
            // Expected
                equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
                        .field("type", "text")
        } finally {
        assertTrue(exception.getMessage().contains("cannot modify UnmodifiableOnRestore setting [index.number_of_shards]" + " on restore"));
            Settings changedSettings = changedSettingsBuilder.build();
        SnapshotRestoreException exception = expectThrows(
            assertThat(
            .setIndices(indexName1)
        Client client = client();
import org.opensearch.cluster.metadata.MappingMetadata;
        assertRequestBuilderThrows(
        assertNull(state.metadata().index(indexName1).getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY));
            .get();
    }
        );
        logger.info("--> check that template is restored");
            assertThat(restorePause, greaterThan(TimeValue.timeValueSeconds(randomIntBetween(1, 5)).nanos()));
                    .put(SETTING_NUMBER_OF_SHARDS, numShards.numPrimaries)
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false)
            .execute()
        logger.info("--> create index");
            client().admin()
                .setIndexSettings(changedSettings)
    public void testInvalidRestoreRequest_MixUnmodifiableOnRestoreAndUserUnRemovableSettingsIgnored() throws Exception {
            restoreSnapshotResponse.getRestoreInfo().successfulShards(),
            .setIndices("test-idx-1", "test-idx-2")
                .actionGet();
        // Write a document
            List<String> changeBlockSettings = randomSubsetOf(
                .setRenamePattern("test-idx-1")
        );
    public void testParallelRestoreOperations() {
                        .startObject("field1")
                .setWaitForCompletion(true)
import org.opensearch.core.rest.RestStatus;
            .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
            .setWaitForCompletion(true)
                IndexMetadata.SETTING_READ_ONLY,
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
    public void testInvalidRestoreRequest_MixModifiableAndUserUnmodifiableSettingsModified() throws Exception {
        cluster().wipeIndices("test-idx");
            () -> client().admin()
            .prepareRestoreSnapshot("test-repo", "test-snap")
        logger.info("-->  creating test template");
            .setRestoreGlobalState(true)
        );
                .prepareAliases()
import static org.hamcrest.Matchers.containsString;
        Path absolutePath = randomRepoPath().toAbsolutePath();
        );
            indexRandomDocs("test-index", between(0, 100));
import static org.hamcrest.Matchers.not;
        // Make sure that number of shards didn't change
        restoredIndex = index + "-restored";
        // try index restore with mix of removable and UnmodifiableOnRestore settings ignored
        assertAcked(client().admin().indices().prepareClose("test-idx-3"));
                .actionGet();
                )
            .setWaitForCompletion(true)
            .collect(Collectors.toMap(shardId -> shardId, indexMetadata::primaryTerm));
            () -> client().admin()
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        assertThat(client().admin().indices().prepareDeleteTemplate("test-template").get().isAcknowledged(), equalTo(true));
            .cluster()
        }
            assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
            .get();
            .execute();
        CreateSnapshotResponse createSnapshotResponse2 = client.admin()
                .setRenamePattern(index)
    }
        indexSettings = getIndexSettings(1, 0).build();
            "test-repo",
                .getSnapshotInfo()
 * You may obtain a copy of the License at
                is(blocks.hasIndexBlock("test-idx", IndexMetadata.INDEX_READ_BLOCK))
    private SnapshotInfo snapshotInfo;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.V_EMPTY)
        restoreSnapshotResponse = client.admin()
        final CreateSnapshotResponse createSnapshotResponse = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap")
                containsString("expected total copies needs to be a multiple of total awareness attributes [3]")
    }
            .put(indexSettings())
            .clear()
            .setRenameReplacement(restoredIndexName2)
    }
                .setIndexSettings(mixedSettingsUnmodifiableOnRestore)
        assertAcked(
        setupSnapshotRestore();
