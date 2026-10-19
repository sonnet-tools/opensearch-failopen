 * software distributed under the License is distributed on an
            .setWaitForCompletion(false)
                .get()
        assertTrue(exception.getMessage().contains("cannot remove setting [index.remote_store.enabled] on restore"));
 * You may obtain a copy of the License at  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            () -> client().admin()
        Client client = client();
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        // try index restore with mix of removable and USER_UNREMOVABLE_SETTINGS settings ignored
                .setIndices(index)
        CreateSnapshotResponse createSnapshotResponse = client.admin()  
import org.opensearch.index.IndexSettings;
            .execute()
        assertHitCount(client.prepareSearch("test-idx").setSize(0).setQuery(matchQuery("field1", "Foo")).get(), 0);
 * KIND, either express or implied.  See the License for the
                logger.info("--> apply initial blocks to index");
            .setIndices("test-idx")
            .prepareCreateSnapshot("test-repo", "test-snap")
        setupSnapshotRestore();
            () -> client().admin()
        assertThat(restoreSnapshotResponse2.status(), equalTo(RestStatus.ACCEPTED));
    public void testInvalidRestoreRequest_MixRemovableAndUserUnRemovableSettingsIgnored() throws Exception {
        // Write a document
        assertThat(restoreSnapshotResponse1.status(), equalTo(RestStatus.ACCEPTED));
        } finally {
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())  
        logger.info("--> snapshot");  
        Client client = client();
            client.admin()
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));  
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
                .setIndexSettings(mixedSettings)
                .setRenamePattern(index)
        assertTrue(exception.getMessage().contains("rename_replacement string size exceeds max allowed size"));  
        // Write a document
        logger.info("--> delete indices");  
                .setWaitForCompletion(false)
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
            Settings.Builder initialSettingsBuilder = Settings.builder();
            .setIndexSettings(newIndexSettings)
                .addAlias("test-idx-1", "alias-1")  
        logger.info("--> snapshot");  
            assertThat(
                mergedSettings.getAsBoolean(IndexMetadata.SETTING_READ_ONLY, false),
    }
        assertTrue(client().admin().indices().prepareGetAliases("alias-123").get().getAliases().isEmpty());
        snapshotRepo = "test-restore-snapshot-repo";
                    .setIndexSettings(
        setupSnapshotRestore();  
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
            .setWaitForCompletion(true)
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), equalTo(numPrimaries));
            // Expected
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numOfShards)
        String restoredIndexName1 = indexName1 + "-restored";  
        // index.version.created is UnmodifiableOnRestore, index.number_of_search_replicas is modifiable
                .setIgnoreIndexSettings(IndexMetadata.SETTING_VERSION_CREATED, IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS)
                .setWaitForCompletion(false)  
public class RestoreSnapshotIT extends AbstractSnapshotIntegTestCase {  
            assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
                .cluster()
        } catch (SnapshotRestoreException ex) {  
        assertTrue(exception.getMessage().contains("cannot modify setting [index.remote_store.enabled]" + " on restore"));  
        // try index restore with USER_UNREMOVABLE_SETTINGS setting ignored
            .get();  
            .prepareRestoreSnapshot(repoName, snapshotName2)
        snapshotName1 = "test-restore-snapshot1";  
        logger.info("-->  creating test template");
        }
        assertThat(restoreError.getMessage(), containsString("cannot disable setting [index.soft_deletes.enabled] on restore"));
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse;  
        Client client = client();
        ActionFuture<RestoreSnapshotResponse> restoreSnapshotResponse2 = client.admin()
        if (randomBoolean()) {
                is(blocks.hasIndexBlock("test-idx", IndexMetadata.INDEX_READ_ONLY_BLOCK))  
            );
        try {
        assertThat(snapshotInfo2.state(), equalTo(SnapshotState.SUCCESS));
        return settingsBuilder;
                .setWaitForCompletion(true)
                assertAcked(client().admin().indices().prepareClose(indexName));
            logger.info("--> cleaning up blocks");  
            "fs",
            clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap")
        int numberOfShards = getNumShards("test-idx").numPrimaries;
            .prepareRestoreSnapshot("test-repo", "test-snap")  
        assertTrue(client().admin().indices().prepareGetAliases("alias-1").get().getAliases().isEmpty());
            .prepareRestoreSnapshot(repoName, snapshotName)
        Client client = client();
        logger.info("--> snapshot");
            clusterAdmin().prepareCreateSnapshot("test-repo", "snapshot-0")
                        .endObject()
    public void testInvalidRestoreRequest_MultipleUnmodifiableOnRestoreIgnored() throws Exception {  
        client.admin()
        );
        CreateSnapshotResponse createSnapshotResponse = client.admin()
                .get()  
        client.admin()  
    protected Settings.Builder getIndexSettings(int numOfShards, int numOfReplicas) {
        // check if throttling is active
        assertThat(createSnapshotResponse.getSnapshotInfo().state(), equalTo(SnapshotState.SUCCESS));
            .cluster()
        SnapshotRestoreException exception = expectThrows(
            "test-repo",
     * In this test, we test that an index created does not have any remote_store custom data in index metadata at the  
        assertThat(getSettingsResponse.getSetting("test-idx", "index.refresh_interval"), equalTo("10s"));  
            .build();  
        assertFalse(client().admin().indices().prepareGetAliases("alias-3").get().getAliases().isEmpty());
            client.admin()  
                .setMapping(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;
                    .setRenamePattern("test-index")
        assertThat(restoreSnapshotResponse1.get().status(), equalTo(RestStatus.ACCEPTED));
            restoreSnapshotResponse.getRestoreInfo().successfulShards(),  
        );
        assertThat(restoreSnapshotResponse.get(20L, TimeUnit.SECONDS).getRestoreInfo().totalShards(), greaterThan(0));
        createRepository("test-repo", "fs");  
            assertThat(
            .setIndices(indexName)  
                .setRenameReplacement(restoredIndex)  
                .prepareCreateSnapshot("test-repo", "test-snap")
                .setWaitForCompletion(true)  
        } catch (InvalidIndexNameException ex) {  
            SnapshotRestoreException.class,
    public void testInvalidRestoreRequest_MultipleUserUnRemovableSettingsIgnored() throws Exception {
                mergedSettings.getAsBoolean(IndexMetadata.SETTING_BLOCKS_WRITE, false),
    public void testInvalidRestoreRequest_MixModifiableAndUserUnmodifiableSettingsModified() throws Exception {
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
import java.nio.file.Path;  
            SnapshotRestoreException.class,
            .setWaitForCompletion(true)  
    }
            fail("Shouldn't be here");
            }
            // Expected
    public void testInvalidRestoreRequest_UserUnRemovableSettingsIgnored() throws Exception {
        );
                        .startObject("field1")
            assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
            logger.info("--> restore index with additional block changes");
            SnapshotRestoreException.class,
            () -> client().admin()
        assertTrue(exception.getMessage().contains("cannot modify UnmodifiableOnRestore setting [index.number_of_shards]" + " on restore"));
            .setRestoreGlobalState(true)
            )
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
                .setWaitForCompletion(false)  
        logger.info("--> create test indices");  
        String docId = Integer.toString(randomInt());  
        setupSnapshotRestore();  
        String repoName = "test-restore-snapshot-repo";
                .actionGet();  
        Path absolutePath = randomRepoPath().toAbsolutePath();
                .setWaitForCompletion(true)
    public void testNoRemoteStoreCustomDataOnIndexCreationAndRestore() {  
        );
        ValidationException exception = expectThrows(
                .setIndexSettings(userUnmodifiableSettings)
            .prepareRestoreSnapshot("test-repo", "test-snap")
            .setRenameReplacement(validRenameReplacement)
                    .get()
        assertThat(  
    public void testInvalidRestoreRequest_UnmodifiableOnRestoreIgnored() throws Exception {  
            .prepareCreateSnapshot(repoName, snapshotName1)
                .setWaitForCompletion(true)
        assertFalse(client().admin().indices().prepareGetAliases("alias-123").get().getAliases().isEmpty());
            .setWaitForCompletion(true)  
        // index.remote_store.enabled is USER_UNMODIFIABLE_SETTINGS, index.number_of_search_replicas is modifiable  
        indexRandom(true, builders);
        indexRandomDocs("test-idx-2", 100);  
                .actionGet();  
        logger.info("--> snapshot it");
            .put("index.analysis.analyzer.my_analyzer.tokenizer", "standard");  
            .setTransientSettings(Settings.builder().putNull(INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey()).build())
                .cluster()
package org.opensearch.snapshots;
            assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));  
            logger.info("--> snapshot index");
            .setRestoreGlobalState(true)
            .execute();
        );  
        assertThat(createSnapshotResponse.getSnapshotInfo().state(), equalTo(SnapshotState.SUCCESS));
                .execute()  
        cluster().wipeIndices("test-idx-1", "test-idx-2", "test-idx-3");  
        // We don't restore any indices here
            assertThat(
import static org.opensearch.index.query.QueryBuilders.matchQuery;
        ensureGreen(restoredIndexName1, restoredIndexName2);  
                .setIndices(index)
            .setIndices("test-idx")
            equalTo(SnapshotState.SUCCESS)
    }
        String invalidRenameReplacementString = "b".repeat(100000);
import java.util.List;  
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        logger.info("--> try renaming indices using the same name");  
                .indices()
import org.opensearch.cluster.metadata.MappingMetadata;
                () -> clusterAdmin().prepareRestoreSnapshot("test-repo", "snapshot-0")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                restoreError.getMessage(),
                .setWaitForCompletion(false)  
            .put(indexSettings())
                .execute()  
 * this work for additional information regarding copyright
                .setWaitForCompletion(true)
        }  
                .indices()
        // Validate that the remote_store custom data is not present in index metadata for the created index.
                .setWaitForCompletion(true)
        );
import org.opensearch.common.unit.TimeValue;  
                .setRenameReplacement(restoredIndex)
            prepareCreate(
        SnapshotRestoreException exception = expectThrows(
        Settings.Builder settingsBuilder = Settings.builder()  
                Settings.builder()
            .setRenamePattern(indexName1)  
            )  
        // index.number_of_replicas is USER_UNREMOVABLE_SETTINGS, index.number_of_search_replicas is removable
                .setRenameReplacement(restoredIndex)  
                .setWaitForCompletion(false)
                .cluster()
        assertTrue(exception.getMessage().contains("cannot remove UnmodifiableOnRestore setting [index.number_of_shards]" + " on restore"));
            manageReplicaSettingForDefaultReplica(true);  
        String docId = Integer.toString(randomInt());
                .setIndices("test-idx-1", "test-idx-2")
        assertAcked(  
                .setIgnoreIndexSettings("index.analysis.*")  
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
            .prepareRestoreSnapshot("test-repo", "test-snap")
            .setIndices(indexName)  
    }
        setupSnapshotRestore();
        logger.info("--> assert that old mapping is restored");
            client.admin()
            .execute()
                .actionGet();
                .setIgnoreIndexSettings(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, IndexMetadata.SETTING_NUMBER_OF_SHARDS)
            .prepareRestoreSnapshot(repoName, snapshotName1)
            .build();  
            () -> client().admin()  
            disableIndexBlock("test-idx", IndexMetadata.SETTING_BLOCKS_READ);
            .get();
        restoreSnapshotResponse = client.admin()
        // We don't restore any indices here
                .prepareRestoreSnapshot("test-repo", "test-snap")
            .execute();  
            SnapshotRestoreException.class,
        SnapshotRestoreException exception = expectThrows(
                .setRenamePattern("test-idx")
                .prepareRestoreSnapshot("test-repo", "test-snap")  
 *  
            .cluster()
            .setRenameReplacement(restoredIndexName2)
    public void testInvalidRenameReplacementPattern() {
                IndexMetadata.SETTING_BLOCKS_METADATA,
                .setRenameReplacement("new-index-3")
        final Map<Integer, Long> primaryTerms = IntStream.range(0, numPrimaries)
        SnapshotRestoreException exception = expectThrows(
                .setRenameReplacement(restoredIndex)  
                    .setIndices("test-index")
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequestBuilder;
            for (int i = 0; i < randomInt(3); i++) {
        assertThat(client().admin().indices().prepareDeleteTemplate("test-template").get().isAcknowledged(), equalTo(true));  
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
import java.util.Locale;
        ActionFuture<RestoreSnapshotResponse> restoreSnapshotResponse1 = client.admin()  
                .setIgnoreIndexSettings(IndexMetadata.SETTING_REMOTE_STORE_ENABLED)
            Settings mergedSettings = Settings.builder().put(initialSettings).put(changedSettings).build();  
        );
        client().admin()
            client.admin()  
            .metadata()
        assertAcked(client().admin().indices().prepareAliases().addAlias("test-idx-3", "alias-3"));
            SnapshotRestoreException.class,
                .setWaitForCompletion(false)
            SnapshotRestoreException.class,
        );
            clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap").setIndices().setWaitForCompletion(true).execute()
        snapshotInfo2 = createSnapshot(snapshotRepo, snapshotName2, new ArrayList<>(List.of(index)));  
    }
                .setRenamePattern(index)
                .setIgnoreIndexSettings(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS)  
            client.admin()
                .setRenameReplacement("alias-3")
            .cluster()  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numOfReplicas)  
            );
        );
            .setWaitForCompletion(true)  
        assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
        Settings numberOfShardsSettingsSame = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).build();  
                .cluster()
                .get();
    }  
        GetIndexTemplatesResponse getIndexTemplatesResponse = client().admin().indices().prepareGetTemplates().get();
    public void testRestoreIncreasesPrimaryTerms() {  
        CreateSnapshotResponse createSnapshotResponse = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap")  
        assertAcked(
                containsString("expected max cap on auto expand to be a multiple of total awareness attributes [3]")
        CreateSnapshotResponse createSnapshotResponse = client.admin()  
        }
        );
        );
        logger.info("--> try renaming indices into existing alias name");
    }
        Settings newIncorrectIndexSettings = Settings.builder()
            .prepareCreateSnapshot(repoName, snapshotName2)  
        );
            if (!initialSettings.isEmpty()) {  
        String repoName = "test-restore-snapshot-repo";
                .cluster()
                .setRenameReplacement(restoredIndex)
        setupSnapshotRestore();
    private Path absolutePath1;  
        ensureGreen(restoredIndexName1, restoredIndexName2);
            .setIndices(indexName1)  
import org.opensearch.cluster.metadata.IndexMetadata;
                .setIgnoreIndexSettings(IndexMetadata.SETTING_NUMBER_OF_SHARDS)
                .setIndices("test-idx")
            .setRenameReplacement(restoredIndexName1)
            .metadata()
            }
            () -> client().admin()  
            .get();  
        assertTrue(exception.getMessage().contains("cannot modify UnmodifiableOnRestore setting [index.number_of_shards]" + " on restore"));  
                restoreError2.getMessage(),  
            // Expected  
        Settings.Builder indexSettings = Settings.builder()
        String snapshotName1 = "test-restore-snapshot1";  
            .prepareRestoreSnapshot("test-repo", "test-snap")  
        MappingMetadata mappings = clusterAdmin().prepareState().get().getState().getMetadata().getIndices().get("test-idx").mapping();  
        assertThat(createSnapshotResponse.getSnapshotInfo().state(), equalTo(SnapshotState.SUCCESS));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        assertTrue(exception.getMessage().contains("cannot modify UnmodifiableOnRestore setting [index.number_of_shards]" + " on restore"));
        logger.info("--> snapshot");
        // try index restore with USER_UNMODIFIABLE_SETTINGS setting modified  
        // run at full speed again  
            restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "snapshot-0")
                .cluster()  
                .setWaitForCompletion(true)
    }  
                    .setRenameReplacement("new-index-2")
        createRepository("test-repo", "fs");
        ensureGreen(indexName);  
            assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));  
                .get()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertIndexTemplateMissing;
                .execute()
        String expectedValue = "expected";
        assertHitCount(client.prepareSearch("test-idx").setSize(0).setQuery(matchQuery("field1", "Foo")).get(), numdocs);  
        assertHitCount(client.prepareSearch("test-idx").setSize(0).setQuery(matchQuery("field1", "bar")).get(), numdocs);
            client.admin()
/*  
        );
import java.util.concurrent.TimeUnit;  
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)  
            .execute()
    public void testInvalidRestoreRequest_MixModifiableAndUnmodifiableOnRestoreModified() throws Exception {  
            .get();
                mergedSettings.getAsBoolean(IndexMetadata.SETTING_BLOCKS_METADATA, false),
 * not use this file except in compliance with the License.
                .setIndexSettings(changedSettings)
                .setWaitForCompletion(false)  
        }
            builders[i] = client().prepareIndex("test-idx").setId(Integer.toString(i)).setSource("field1", "Foo bar " + i);
            restoreSnapshotResponse.getRestoreInfo().successfulShards(),  
        logger.info("--> delete the index and recreate it with foo field");
        assertRequestBuilderThrows(
    public void testDynamicRestoreThrottling() throws Exception {  
        assertHitCount(client.prepareSearch("test-idx").setSize(0).setQuery(matchQuery("field1", "foo")).get(), numdocs);
            .setIndices(indexName2)
import org.opensearch.common.xcontent.XContentFactory;
            createIndex(".system-index", Settings.builder().put("index.number_of_replicas", 0).build());  
                .addAlias("test-idx-2", "alias-123")
        assertThat(getSnapshot("test-repo", "test-snap").state(), equalTo(SnapshotState.SUCCESS));  
            );  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.V_EMPTY)  
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));  
                    .put("refresh_interval", 10, TimeUnit.SECONDS)
        ensureGreen(index);
            CreateSnapshotResponse createSnapshotResponse = client.admin()  
        // b - 100000 times
        restoreSnapshotResponse = client.admin()
            .index(indexName);
            assertThat(restoredIndexMetadata.primaryTerm(shardId), greaterThan(primaryTerms.get(shardId)));
        assertAcked(
            () -> client().admin()  
            .prepareRestoreSnapshot(repoName, snapshotName1)
        );  
        // We don't restore any indices here
                .setWaitForCompletion(false)
            .put("index.analysis.analyzer.my_analyzer.type", "custom")
                .setWaitForCompletion(false)  
        );  
                createSnapshotResponse.getSnapshotInfo().successfulShards(),
            client().admin()  
        ensureGreen();
                        .field("type", "text")  
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)  
                .execute()
                .indices()
    public void testRecreateBlocksOnRestore() throws Exception {  
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
                .actionGet();  
        );
            .setRenamePattern(sameSourceIndex ? indexName1 : indexName2)
            .setWaitForCompletion(true)  
        // Make sure that number of shards didn't change
        } catch (SnapshotRestoreException ex) {
            () -> client().admin()  
                .setIndexSettings(numberOfShardsSettingsDiff)
        String expectedValue = "expected";
            .setIncludeAliases(false)
            .setWaitForCompletion(true)
        logger.info("--> assert that correct settings are restored");
                .setRenameReplacement(restoredIndex)
            fail("Shouldn't be here");
                .prepareRestoreSnapshot("test-repo", "test-snap")
import static org.opensearch.index.IndexSettings.INDEX_SOFT_DELETES_SETTING;
        assertIndexTemplateMissing(getIndexTemplatesResponse, "test-template");
                .prepareAliases()
                .cluster()  
        assertThat(
                .addAlias("test-idx-1", "alias-1", false)  
            }
        createRepository(repoName, "fs", absolutePath);  
            .execute()
            .build();
            .setRenameReplacement(restoredIndexName1)
        assertTrue(exception.getMessage().contains("cannot modify UnmodifiableOnRestore setting [index.version.created]" + " on restore"));
import org.opensearch.indices.InvalidIndexNameException;
        logger.info("--> create test index with case-preserving search analyzer");
        // try index restore with multiple UnmodifiableOnRestore settings modified  
    }
 */
        ensureGreen();  
        assertDocCount("test-idx-1-copy", 100L);
        assertAcked(client.admin().indices().prepareClose("test-idx-1", "test-idx-2-copy"));
            .setRenameReplacement(restoredIndexName2)  
            );
            .get()
    public void testInvalidRestoreRequest_UserUnmodifiableSettingsModified() throws Exception {  
                .setIndices(index)
            assertThat(
        String validRenameReplacement = "restored-index";  
        }
            .setWaitForCompletion(true)
                .setIndexSettings(Settings.builder().put("index.number_of_replicas", 2).build())
        logger.info("Path [{}]", absolutePath);
            .actionGet();  
            .cluster()  
                Settings.builder()
        SnapshotRestoreException exception = expectThrows(
    }  
                .get()
                .cluster()  
        );  
            .setWaitForCompletion(true)  
import org.opensearch.transport.client.Client;
            .setIgnoreIndexSettings("index.analysis.*")
        );  
            .setWaitForCompletion(true)
        SnapshotRestoreException exception = expectThrows(  
    public void testEmptyRenameReplacementPattern() {
            SnapshotRestoreException.class,
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
        try {
        assertThat(getSettingsResponse.getSetting("test-idx", "index.analysis.analyzer.my_analyzer.type"), equalTo("standard"));
    private String index;
            .prepareRestoreSnapshot("test-repo", "test-snap")  
        logger.info("--> assert that correct settings are restored and index is still functional");
        final SnapshotInfo snapshotInfo = assertSuccessful(
                )
            assertThat(
    public void testInvalidRestoreRequest_UnmodifiableOnRestoreModified() throws Exception {
            createSnapshotResponse2.getSnapshotInfo().successfulShards(),  
                .setPatterns(Collections.singletonList("te*"))  
            );
        assertAcked(prepareCreate("test-idx", 2, indexSettings));
        setupSnapshotRestore();
                .addAlias("test-idx-3", "alias-123")
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
            .prepareCreateSnapshot(repoName, snapshotName)
        assertThat(
 *
            .setRenameReplacement("$1-copy")
                    )
        setupSnapshotRestore();
 * Unless required by applicable law or agreed to in writing,
        snapshotInfo = createSnapshot(snapshotRepo, snapshotName1, new ArrayList<>(List.of(index)));  
import java.util.Collections;
            cluster().wipeIndices("test-idx");
        assertTrue(exception.getMessage().contains("cannot modify setting [index.remote_store.enabled]" + " on restore"));  
        logger.info("--> try restoring while changing the number of shards - should fail");
        CreateSnapshotResponse createSnapshotResponse = client.admin()
        NumShards numShards = getNumShards("test-idx");  
        SnapshotRestoreException exception = expectThrows(  
            SnapshotRestoreException.class,
                .setRenamePattern(index)
            final IllegalArgumentException restoreError2 = expectThrows(  
        logger.info("--> check that aliases are not restored and existing aliases still exist");
        }
 */  
                .prepareRestoreSnapshot("test-repo", "test-snap")
                        Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 1).put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-1").build()  
        assertTrue(exception.getMessage().contains("cannot modify setting [index.remote_store.enabled]" + " on restore"));
            }  
    public void testRestoreWithDifferentMappingsAndSettings() throws Exception {  
        ensureGreen();
            ValidationException.class,
                .addAlias("test-idx-2", "alias-2", false)
        createRepository(snapshotRepo, "fs", getRepositorySettings(absolutePath1, true));
                .prepareRestoreSnapshot("test-repo", "test-snap")
        );
                .setIndices("test-index")  
                IndexMetadata.SETTING_BLOCKS_WRITE,
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
                is(blocks.hasIndexBlock("test-idx", IndexMetadata.INDEX_METADATA_BLOCK))  
        Settings mixedSettingsUnmodifiableOnRestore = Settings.builder()
            .cluster()  
    public void testRestoreBalancedReplica() {
                .prepareRestoreSnapshot("test-repo", "test-snap")
                .execute()
            .setIndices(index)  
        );
                        .field("type", "keyword")
                containsString("expected total copies needs to be a multiple of total awareness attributes [3]")  
            .put(INDEX_REFRESH_INTERVAL_SETTING.getKey(), "10s");
        RestoreSnapshotResponse restoreSnapshotResponse1 = client.admin()
            .setRenamePattern("test-idx")  
        assertThat(client.prepareGet(restoredIndexName1, docId).get().isExists(), equalTo(true));
            .execute()
                .actionGet();
    public void testChangeSettingsOnRestore() throws Exception {  
            .build();
    public void testRestoreTemplates() throws Exception {
     * time of index creation and after snapshot restore.
        assertThat(
                .setRenameReplacement(restoredIndex)
        );
        setupSnapshotRestore();
            logger.info("--> applying changed block settings {}", changedSettings);
            .actionGet();
        assertDocCount("test-idx-2-copy", 100L);  
                .setWaitForCompletion(true)
                .cluster()
        );  
        SnapshotRestoreException exception = expectThrows(
            disableIndexBlock("test-idx", IndexMetadata.SETTING_BLOCKS_READ);
        assertAcked(
        String docId = Integer.toString(randomInt());
            .put("refresh_interval", "5s")
        createIndex(indexName, indexSettingsNoReplicas(2).build());
                .get()
        snapshotName2 = "test-restore-snapshot2";
            SnapshotRestoreException.class,
            for (RepositoriesService repositoriesService : internalCluster().getDataNodeInstances(RepositoriesService.class)) {
            .cluster()  
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
    public void testInvalidRestoreRequest_MultipleUnmodifiableOnRestoreModified() throws Exception {  
            .cluster()  
            settings.put(INDEX_SOFT_DELETES_SETTING.getKey(), true);  
                .setRenamePattern(index)  
                .actionGet();
                .setIgnoreIndexSettings(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS)  
                .setIndices("test-idx-1")
            .setWaitForCompletion(true)
            SnapshotRestoreException.class,
                )  
            SnapshotRestoreException.class,  
        assertTrue(exception.getMessage().contains("cannot remove UnmodifiableOnRestore setting [index.number_of_shards] on restore"));
        SnapshotRestoreException exception = expectThrows(
            .prepareCreateSnapshot(repoName, snapshotName1)
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
                .setIndices("test-index", ".system-index")  
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())  
            .setWaitForCompletion(false)
            .setWaitForCompletion(false)  
            () -> client().admin()
    private SnapshotInfo snapshotInfo2;
                is(blocks.hasIndexBlock("test-idx", IndexMetadata.INDEX_WRITE_BLOCK))
        assertThat(
    }  
            );
            () -> client().admin()
import static org.hamcrest.Matchers.not;
        logger.info("-->  delete all indices");
            .setWaitForCompletion(true)
 * Modifications Copyright OpenSearch Contributors. See
        assertTrue(exception.getMessage().contains("cannot remove setting [index.number_of_replicas]" + " on restore"));  
        assertIndexTemplateExists(getIndexTemplatesResponse, "test-template");  
            .get();
                .setRenamePattern(index)  
        cluster().wipeIndices("test-idx-1", "test-idx-2");
        assertThat(restoreSnapshotResponse.getRestoreInfo().successfulShards(), equalTo(numPrimaries));
        Settings mixedSettingsUserUnmodifiableSettings = Settings.builder()
import org.opensearch.cluster.block.ClusterBlocks;  
        } catch (SnapshotRestoreException ex) {
        );
    public void testRestoreAliases() throws Exception {  
            .setRenameReplacement("alias")
                initialSettingsBuilder.put(blockSetting, true);
    }
        final int numPrimaries = getNumShards(indexName).numPrimaries;
        RestoreSnapshotResponse restoreSnapshotResponse2 = client.admin()  
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();  
        logger.info("--> try renaming indices into existing alias of another restored index");  
                .cluster()  
                .setRenameReplacement(".system-index-restore-1")  
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));  
        SnapshotRestoreException exception = expectThrows(  
        assertThat(restoreSnapshotResponse1.status(), equalTo(RestStatus.ACCEPTED));  
        assertTrue(client().admin().indices().prepareGetAliases("alias-1").get().getAliases().isEmpty());  
        final IndexMetadata restoredIndexMetadata = clusterAdmin().prepareState()
    private String snapshotName2;
                mergedSettings.getAsBoolean(IndexMetadata.SETTING_BLOCKS_READ, false),  
    }  
        try {
                .setRenamePattern(".system-index")
    }
                .setIndices(index)  
            // compute current index settings (as we cannot query them if they contain SETTING_BLOCKS_METADATA)
        setupSnapshotRestore();
                .cluster()
    }
        // index.version.created is UnmodifiableOnRestore, index.number_of_search_replicas is removable  
        // index.remote_store.enabled is USER_UNMODIFIABLE_SETTINGS, index.version.created is UnmodifiableOnRestore
            randomIndexTemplate();
                    .setIndices("test-index")
            .prepareUpdateSettings()
                .setIndices(index)
        logger.info("--> check that aliases are restored");
        }  
        indexSettings = getIndexSettings(1, 0).build();  
    }
            assertAcked(deleteTemplate.execute().actionGet());  
            .execute()
                .setWaitForCompletion(true)  
        );
import org.opensearch.repositories.RepositoriesService;  
            Settings.Builder changedSettingsBuilder = Settings.builder();  
        // try index restore with multiple USER_UNREMOVABLE_SETTINGS settings ignored
            .setMetadata(true)
            client.admin()  
import java.util.Map;
                .execute()
import org.opensearch.core.rest.RestStatus;  
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
                .get()  
            .put(super.indexSettings())
        assertDocCount("test-idx-2-copy", 100L);
            .build();
        assertTrue(client().admin().indices().prepareGetAliases("alias-123").get().getAliases().isEmpty());
                randomInt(4),  
        final CreateSnapshotResponse createSnapshotResponse = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap")
            .cluster()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                IndexMetadata.SETTING_BLOCKS_READ
                .cluster()  
            disableIndexBlock("test-idx", IndexMetadata.SETTING_READ_ONLY);
        logger.info("--> close just restored indices");
                .setRenamePattern(".+")  
        assertThat(createSnapshotResponse2.getSnapshotInfo().state(), equalTo(SnapshotState.SUCCESS));  
            () -> client().admin()  
            .actionGet();
        String restoredIndexName1 = indexName1 + "-restored";
            .actionGet();
            IllegalArgumentException.class  
            indexRandomDocs("test-index", between(0, 100));
        );
                    XContentFactory.jsonBuilder()
 *
        try {
    }  
        RestoreSnapshotResponse restoreSnapshotResponse1 = client.admin()
            .build();
        getSettingsResponse = client.admin().indices().prepareGetSettings("test-idx").execute().actionGet();  
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())  
        assertThat(
import org.opensearch.common.ValidationException;  
                .cluster()
        } catch (SnapshotRestoreException ex) {
        logger.info("Path [{}]", absolutePath);
        String restoredIndexName1 = indexName1 + "-restored";  
                .setRenameReplacement(restoredIndex)
        restoreSnapshotResponse = client.admin()
            .execute()  
                .execute()  
                .prepareAliases()
                changedSettingsBuilder.put(blockSetting, randomBoolean());
        // try index restore with UnmodifiableOnRestore setting ignored  
            .setRenameReplacement("$1-copy")  
        logger.info("--> snapshot");
            .setIndices(sameSourceIndex ? indexName1 : indexName2)
                .setWaitForCompletion(true)  
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
                .setRenamePattern(index)
import static org.hamcrest.Matchers.greaterThan;  
        createRepository("test-repo", "fs");  
                .setIndices(index)  
                    .put(SETTING_NUMBER_OF_REPLICAS, between(0, 1))  
                .setWaitForCompletion(false)
                .setRenameReplacement("test-idx-1")  
        String docId2 = Integer.toString(randomInt());  
 */  
        setupSnapshotRestore();  
    public void testParallelRestoreOperations() {
        logger.info("--> try renaming indices using the same name");  
        }, 30, TimeUnit.SECONDS);
import static org.hamcrest.Matchers.containsString;
        assertThat(createSnapshotResponse.getSnapshotInfo().failedShards(), equalTo(0));  
                .setRenameReplacement("same-name")  
                .setRenamePattern(index)
                IndexMetadata.SETTING_READ_ONLY,  
            .get();
        assertThat(createSnapshotResponse2.getSnapshotInfo().successfulShards(), greaterThan(0));
        String restoredIndexName2 = indexName2 + "-restored";  
    public void testRenameOnRestore() throws Exception {  
                .preparePutMapping("test-idx")
            .setMetadata(true)
        try {
            .put("index.analysis.analyzer.my_analyzer.type", "standard")
            .execute()
            .setRenamePattern("(.+-2)")
            .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        logger.info("--> delete the index and recreate it while changing refresh interval and analyzer");  
                .prepareRestoreSnapshot("test-repo", "test-snap")
        setupSnapshotRestore();
            flush("test-index");  
            .setRestoreGlobalState(true)  
            .execute()
                .cluster()  
        assertThat(client.prepareGet(restoredIndexName2, sameSourceIndex ? docId : docId2).get().isExists(), equalTo(true));  
            .cluster()
import org.opensearch.common.settings.Settings;
                .setWaitForCompletion(true),
            .prepareUpdateSettings()  
                    .put(SETTING_NUMBER_OF_REPLICAS, between(0, 1))
        assertAcked(client().admin().indices().prepareAliases().removeAlias("test-idx-3", "alias-123"));  
        );  
        logger.info("--> and try to restore these indices again");
        Settings numberOfShardsSettingsDiff = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3).build();
                IndexMetadata.SETTING_BLOCKS_METADATA,
import org.opensearch.Version;
            .setIndices(indexName1, indexName2)  
        client().admin().cluster().prepareRestoreSnapshot(snapshotRepo, snapshotName1).setWaitForCompletion(true).setIndices(index).get();
            .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)  
    }
        }
            ensureGreen();
        cluster().wipeIndices("test-idx");  
        String indexName2 = "testindex2";  
 * Licensed to Elasticsearch under one or more contributor  
            .collect(Collectors.toMap(shardId -> shardId, indexMetadata::primaryTerm));
        client().admin().indices().prepareClose("test-idx").get();
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));  
            .get();
import org.opensearch.common.action.ActionFuture;
            .cluster()  
            createRepository("test-repo", "fs");
        final RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
        index(indexName2, "_doc", docId2, "value", expectedValue);
                        .endObject()
        logger.info("--> snapshot it");
        cluster().wipeIndices("test-idx-1", "test-idx-1-copy", "test-idx-2", "test-idx-2-copy");
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
                .setWaitForCompletion(true)
                .setRenameReplacement("new-index")
        for (int i = 0; i < builders.length; i++) {
            .getState()  
                .actionGet();  
            () -> client().admin()  
                .get();
    private String restoredIndex;
            .setRenamePattern(indexName1)
                .setIndices(".system-index")
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false)  
        restoredIndex = index + "-restored";
            .prepareRestoreSnapshot(repoName, snapshotName)  
                .setRenamePattern("test-idx-2")
        logger.info("--> try restoring while changing the number of replicas to a negative number - should fail");  
        logger.info("--> delete index");
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
                .get()
                .setIndices(index)
    public void testValidRenameReplacementPattern() {  
        }
                .setSource("field1", "type=text,analyzer=standard,search_analyzer=my_analyzer")  
                2,  
            );
                .cluster()
            Settings initialSettings = initialSettingsBuilder.build();  
            .setWaitForCompletion(true)  
        assertThat(mappings.sourceAsMap().toString(), containsString("baz"));
        assertThat(getSettingsResponse.getSetting("test-idx", INDEX_REFRESH_INTERVAL_SETTING.getKey()), equalTo("5s"));
        assertAcked(client().admin().indices().prepareDelete(index));
        Client client = client();
        );
        final IndexMetadata indexMetadata = clusterAdmin().prepareState()
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false)
                    .put("refresh_interval", 5, TimeUnit.SECONDS)
                .actionGet();
                .setIgnoreIndexSettings("index.analysis.*")  
            equalTo(createSnapshotResponse2.getSnapshotInfo().totalShards())
            fail("Shouldn't be here");
        assertThat(indexMetadata.getSettings().get(IndexMetadata.SETTING_HISTORY_UUID), nullValue());  
/*  
            .put(SETTING_NUMBER_OF_REPLICAS, between(0, 1))  
            logger.info("--> merged block settings {}", mergedSettings);
            .execute()
                "test-idx",  
        assertTrue(exception.getMessage().contains("cannot remove setting [index.number_of_replicas] on restore"));  
        try {  
                .get()
        assertThat(
        assertThat(
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));  
 * The OpenSearch Contributors require contributions made to  
            fail("Shouldn't be here");
        CreateSnapshotResponse createSnapshotResponse2 = client.admin()
                .setWaitForCompletion(false)  
                .setRenameReplacement(invalidRenameReplacementString)  
                    .setRenameReplacement("new-index")  
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        assertThat(client.prepareGet(restoredIndexName1, docId).get().isExists(), equalTo(true));
        assertThat(getSettingsResponse.getSetting("test-idx", SETTING_NUMBER_OF_SHARDS), equalTo("" + numberOfShards));  
        String restoredIndexName2 = indexName2 + "-restored";
            .cluster()  
                .get()  
            SnapshotRestoreException.class,  
            .get();
                .setWaitForCompletion(true)
        assertAcked(client().admin().indices().preparePutMapping("test-idx").setSource("baz", "type=text"));
import static org.hamcrest.Matchers.equalTo;
            .cluster()
            .setWaitForCompletion(true)
        createRepository(repoName, "fs", absolutePath);
 * specific language governing permissions and limitations
                client().admin().indices().prepareUpdateSettings("test-idx").setSettings(initialSettingsBuilder).get();
        // try index restore with mix of removable and UnmodifiableOnRestore settings ignored
        ensureGreen(index);
                .setRenameReplacement("alias-2")
        );  
        createRepository("test-repo", "fs");
        assertAcked(client().admin().indices().prepareClose(indexName));
        // try index restore with multiple UnmodifiableOnRestore settings ignored  
            logger.info("--> checking consistency between settings and blocks");  
            () -> clusterAdmin().prepareRestoreSnapshot("test-repo", "snapshot-0")
        createRepository("test-repo", "fs");  
        assertTrue(exception.getMessage().contains("cannot remove UnmodifiableOnRestore setting [index.version.created] on restore"));
            );
        if (randomBoolean()) {
        // Make sure that number of shards didn't change
            .prepareRestoreSnapshot("test-repo", "test-snap")
        logger.info("Path [{}]", absolutePath);
                        .field("store", true)
            Settings.builder().put("location", randomRepoPath()).put("compress", randomBoolean()).put("chunk_size", 100, ByteSizeUnit.BYTES)  
                .setIndices()  
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        final String indexName = randomAlphaOfLengthBetween(5, 10).toLowerCase(Locale.ROOT);
        client.admin().indices().prepareClose("test-idx-1-copy", "test-idx-2-copy").get();  
        logger.info("--> delete the index and recreate it while deleting all index settings");  
                randomInt(3),  
        logger.info("--> restore indices with different names");  
/*
        }
                .setIndices(index)
            .put(SETTING_NUMBER_OF_REPLICAS, between(0, 1))
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
                    .put(indexSettings())  
            .setIndices(indexName)  
                .state(),
            DeleteIndexTemplateRequestBuilder deleteTemplate = client().admin().indices().prepareDeleteTemplate("random_index_template");
            .prepareCreateSnapshot("test-repo", "test-snap")
                        .endObject()  
        logger.info("-->  update aliases");
                .setIndices("test-idx-1")
        logger.info("--> assert that old settings are restored");
        assertRequestBuilderThrows(
            .cluster()  
                .cluster()
                .prepareRestoreSnapshot("test-repo", "test-snap")
        ensureGreen(restoredIndexName1);
        assertThat(snapshotInfo.successfulShards(), equalTo(0));
import static org.hamcrest.Matchers.notNullValue;  
            createSnapshotResponse.getSnapshotInfo().successfulShards(),  
    public void testForbidDisableSoftDeletesDuringRestore() throws Exception {
                .cluster()
        index(indexName1, "_doc", docId, "value", expectedValue);
        assertThat(
        // try index restore with UnmodifiableOnRestore setting modified
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.V_EMPTY)
        assertDocCount("test-idx", 100L);  
        Settings.Builder indexSettings = Settings.builder()
            SnapshotRestoreException.class,  
        Settings newIncorrectReplicasIndexSettings = Settings.builder()
import static org.opensearch.indices.recovery.RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING;  
                .get()
            assertFalse(restoreSnapshotResponse.isDone());  
            RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
            for (String blockSetting : initialBlockSettings) {  
                .execute()
        logger.info("--> create aliases");
                .get()
        clusterAdmin().prepareCreateSnapshot("test-repo", "snapshot-0").setIndices("test-index").setWaitForCompletion(true).get();
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));  
            .execute();  
    public void setupSnapshotRestore() {  
            // open and close the index to increase the primary terms  
            .index(indexName);
                .cluster()  
                .setRenameReplacement("__WRONG__")
            fail("Shouldn't be here");  
                .setIndexSettings(newIncorrectReplicasIndexSettings)
        ensureGreen(validRenameReplacement);
                .setRenamePattern(index)
        logger.info("--> snapshot");
        assertThat(getSettingsResponse.getSetting("test-idx", INDEX_REFRESH_INTERVAL_SETTING.getKey()), equalTo("5s"));
    }  
import org.opensearch.action.index.IndexRequestBuilder;
            .cluster()
        logger.info("--> restore cluster state");
        Settings mixedSettings = Settings.builder()  
        setupSnapshotRestore();
        CreateSnapshotResponse createSnapshotResponse = client.admin()  
            .cluster()
            .setWaitForCompletion(true)
            .get();  
                .addAlias("test-idx-3", "alias-3", false)
        String repoName = "test-restore-snapshot-repo";
            .setWaitForCompletion(true)  
        SnapshotRestoreException exception = expectThrows(
                .setRenameReplacement(restoredIndex)
                .actionGet();
            .get();
     */
            () -> client().admin()
                .setWaitForCompletion(false)
                .setRenamePattern(index)
                .get()
            prepareCreate(
        final int numdocs = randomIntBetween(10, 100);
        client.admin().cluster().prepareCreateSnapshot("test-repo", "test-snap").setWaitForCompletion(true).setIndices("test-idx").get();  
            Settings changedSettings = changedSettingsBuilder.build();
                .get()
        );
        setupSnapshotRestore();
 * GitHub history for details.
    }
        GetSettingsResponse getSettingsResponse = client().admin().indices().prepareGetSettings("test-idx").execute().actionGet();
            client.admin()
            .actionGet();  
        // try index restore with mix of UnmodifiableOnRestore and USER_UNREMOVABLE_SETTINGS settings ignored
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;  
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
                .setIndices(index)
        String docId2 = Integer.toString(randomInt());
        }
        logger.info("--> restore snapshot without aliases");  
                .get()
        absolutePath1 = randomRepoPath().toAbsolutePath();
            .getState()  
        assertThat(mappings.sourceAsMap().toString(), not(containsString("foo")));
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));  
                .indices()
                2,
        createIndexWithRandomDocs("test-idx", 100);  
                .setWaitForCompletion(true)
import org.opensearch.core.common.unit.ByteSizeUnit;
        );
        createIndex("test-idx-1", "test-idx-2", "test-idx-3");
                .setWaitForCompletion(false)
            equalTo(true)  
    }
            for (String blockSetting : changeBlockSettings) {
        String indexName1 = "testindex1";
        index(indexName2, "_doc", docId2, "value", expectedValue);  
        // try index restore with mix of modifiable and UnmodifiableOnRestore settings modified  
        restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap")
        logger.info("--> try renaming indices using invalid index name");  
        createIndex(index, indexSettings);
        assertThat(snapshotInfo.successfulShards(), equalTo(snapshotInfo.totalShards()));  
            manageReplicaSettingForDefaultReplica(false);  
                IndexMetadata.SETTING_BLOCKS_WRITE,
                .setRenamePattern(".+")
                IllegalArgumentException.class,
        assertTrue(exception.getMessage().contains("cannot remove setting [index.number_of_replicas]" + " on restore"));
        index = "test-index";
        updateRepository(snapshotRepo, "fs", getRepositorySettings(absolutePath1, false));
            .setWaitForCompletion(true)
            ClusterBlocks blocks = client.admin().cluster().prepareState().clear().setBlocks(true).get().getState().blocks();
                .addAlias("test-idx-1", "alias-123")  
        assertThat(getSettingsResponse.getSetting("test-idx", SETTING_NUMBER_OF_SHARDS), equalTo("" + numberOfShards));  
                restorePause += repositoriesService.repository("test-repo").getRestoreThrottleTimeInNanos();  
        logger.info("Snapshot Path [{}]", absolutePath1);
        logger.info("--> create index with baz field");  
                .execute()
            .setRenameReplacement(restoredIndexName1)
        );
        setupSnapshotRestore();  
    }  
                .cluster()
        );  
                .setRenamePattern("test-index")
    }  
        logger.info("--> restore indices with different names");
            fail("Shouldn't be here");
        assertAcked(client().admin().indices().prepareClose("test-idx-3"));
            disableIndexBlock("test-idx", IndexMetadata.SETTING_BLOCKS_METADATA);
    }
    }
                IndexMetadata.SETTING_READ_ONLY  
        );  
            logger.info("--> remove blocks and delete index");  
    public void testInvalidRestoreRequest_MixUnmodifiableOnRestoreAndUserUnmodifiableSettingsModified() throws Exception {
            client.admin()  
        logger.info("--> restore index with correct settings from the snapshot");  
                .setRenamePattern("(.+)")
 * the Apache License, Version 2.0 (the "License"); you may
            .setIncludeAliases(false)  
    public void testInvalidRestoreRequest_MixUnmodifiableOnRestoreAndUserUnRemovableSettingsIgnored() throws Exception {
            .setIndexSettings(newIndexSettings)
 * ownership. Elasticsearch licenses this file to you under  
        assertDocCount("test-idx-1-copy", 100L);
                .setIndexSettings(
                .setWaitForCompletion(false)
        assertAcked(prepareCreate("test-idx", 2, indexSettings));
                .setIndexSettings(mixedSettingsUserUnmodifiableSettings)  
            disableIndexBlock("test-idx", IndexMetadata.SETTING_BLOCKS_METADATA);
        flushAndRefresh();
        ensureGreen();  
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
        cluster().wipeIndices("test-idx");
        Path absolutePath = randomRepoPath().toAbsolutePath();  
        String snapshotName = "test-restore-snapshot";
                        .field("store", true)
                .setRenameReplacement("alias")  
        }
            .setWaitForCompletion(true)
            .setWaitForCompletion(true)
        assertNull(state.metadata().index(indexName1).getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY));  
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numdocs];  
            .setIndices("test-idx-1", "test-idx-2")
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)  
            disableIndexBlock("test-idx", IndexMetadata.SETTING_BLOCKS_WRITE);  
                .setRenameReplacement(restoredIndex)
        logger.info("--> try renaming indices into existing alias of itself, but don't restore aliases ");
        for (int shardId = 0; shardId < numPrimaries; shardId++) {  
        createRepository(repoName, "fs", absolutePath);
        logger.info("-->  delete test template");
        setupSnapshotRestore();
            SnapshotRestoreException.class,
        createRepository("test-repo", "fs");  
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "300s");
            client().admin()  
                        .startObject("field2")  
        createIndex("test-index", settings.build());
        logger.info("--> create index");
                .setIndices(index)  
                "test-idx",
                .isAcknowledged(),
                        .endObject()
        assertHitCount(client.prepareSearch("test-idx").setSize(0).setQuery(matchQuery("field1", "Foo")).get(), numdocs);
        assertNull(state.metadata().index(restoredIndexName1).getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY));
                IllegalArgumentException.class,  
        logger.info("-->  delete and close indices");  
        createRepository("test-repo", "fs");  
            .get();
            RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "snapshot-0")
            () -> client().admin()
            .put(SETTING_NUMBER_OF_SHARDS, numberOfShards + 100)
                .setRenameReplacement(restoredIndex)  
            assertThat(restorePause, greaterThan(TimeValue.timeValueSeconds(randomIntBetween(1, 5)).nanos()));
    }
            client().admin()  
        assertAcked(
 * license agreements. See the NOTICE file distributed with
        getIndexTemplatesResponse = client().admin().indices().prepareGetTemplates().get();
            .clear()
                .setRenameReplacement(restoredIndex)  
            .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
        assertThat(  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            assertThat(
                .setIndices(index)
            // Expected
                .setRenamePattern("test-idx-1")  
            .setWaitForCompletion(true)
                .cluster()
                .get()
                .setRenamePattern("test-index")  
                        .startObject()  
    public void testInvalidRestoreRequest_UnmodifiableOnRestoreUnchanged() throws Exception {
        final Settings.Builder settings = Settings.builder();
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), equalTo(0));
        Settings newIndexSettings = Settings.builder()  
                .get()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String indexName1 = "testindex1";
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertIndexTemplateExists;  
            .cluster()
                .preparePutTemplate("test-template")
                .setRenamePattern(index)
            .setIndices(indexName1)
import java.util.stream.Collectors;
            .prepareRestoreSnapshot("test-repo", "test-snap")
        createRepository("test-repo", "fs");
        ensureGreen();  
        assertTrue(client().admin().indices().prepareGetAliases("alias-1").get().getAliases().isEmpty());
                .cluster()
                .setRenameReplacement("new-index")
            logger.info("--> using initial block settings {}", initialSettings);
            disableIndexBlock("test-idx", IndexMetadata.SETTING_BLOCKS_WRITE);  
                .setRenamePattern(index)  
                .setIndexSettings(remoteStoreEnabledSetting)  
            .actionGet();  
        logger.info("--> try renaming indices into existing alias of itself");
        SnapshotRestoreException exception = expectThrows(
        assertTrue(exception.getMessage().contains("cannot modify setting [index.remote_store.enabled]" + " on restore"));
    private String snapshotRepo;  
            }  
    }
        // Validate that the remote_store custom data is not present in index metadata for the restored index.  
                .setWaitForCompletion(false)  
        );  
        logger.info("--> snapshot");
        SnapshotRestoreException exception = expectThrows(  
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));  
            .clear()
            SnapshotRestoreException.class,
                .get()
            .cluster()
                .cluster()  
            .put(SETTING_NUMBER_OF_REPLICAS.substring(IndexMetadata.INDEX_SETTING_PREFIX.length()), randomIntBetween(-10, -1))  
            .actionGet();  
            .setRenamePattern(indexName2)
        indexRandomDocs("test-idx-1", 100);
            .actionGet();
                .setIndexSettings(Settings.builder().put(INDEX_SOFT_DELETES_SETTING.getKey(), false))  
        assertThat(restoredIndexMetadata.getSettings().get(IndexMetadata.SETTING_HISTORY_UUID), notNullValue());  
        logger.info("--> check that template is restored");
        String expectedValue = "expected";
            .setIndices(indexName1)  
        logger.info("--> snapshot");
        assertThat(snapshotInfo.totalShards(), equalTo(0));
                assertAcked(client().admin().indices().prepareOpen(indexName));  
                .setIndices(index)
                .setIndices("test-idx-1")  
            .setWaitForCompletion(true)  
        Settings userUnmodifiableSettings = Settings.builder()
            List<String> initialBlockSettings = randomSubsetOf(
            .cluster()
                .prepareRestoreSnapshot("test-repo", "test-snap")  
                .execute()  
        assertThat(client.prepareGet(restoredIndexName1, docId).get().isExists(), equalTo(true));
            List<String> changeBlockSettings = randomSubsetOf(
                .setIndices("test-index")
    private String snapshotName1;
        Path absolutePath = randomRepoPath().toAbsolutePath();
                    .get()  
            // Expected  
import static org.hamcrest.Matchers.nullValue;
        logger.info("--> close indices");
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)  
        logger.info("--> restore index");
        }
            .put(INDEX_REFRESH_INTERVAL_SETTING.getKey(), "10s")
                .setRenamePattern(index)
                .setIndices(index)
        GetSettingsResponse getSettingsResponse = client.admin().indices().prepareGetSettings("test-idx").execute().actionGet();  
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false)
 * under the License.  
            .boxed()  
            .get();  
        assertThat(client.prepareGet(restoredIndexName2, docId2).get().isExists(), equalTo(true));
    }
            createIndex("test-index", Settings.builder().put("index.number_of_replicas", 0).build());
            allOf(greaterThan(0), equalTo(restoreSnapshotResponse.getRestoreInfo().totalShards()))
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        Client client = client();  
    }
}
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        if (randomBoolean()) {
            .put(newIndexSettings)  
import static org.hamcrest.Matchers.is;
        assertThat(restoreSnapshotResponse2.get().status(), equalTo(RestStatus.ACCEPTED));  
        index(indexName1, "_doc", docId, "value", expectedValue);  
    private SnapshotInfo snapshotInfo;  
 *    http://www.apache.org/licenses/LICENSE-2.0
                equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())  
        ensureGreen(index);  
                .cluster()  
            .setWaitForCompletion(true)  
            .setIndices("test-idx-1")
                .setRenameReplacement(restoredIndex)
import java.util.ArrayList;
            restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "snapshot-0")
        assertAcked(client().admin().indices().preparePutMapping("test-idx").setSource("foo", "type=text"));
        boolean sameSourceIndex = randomBoolean();
        createIndex("test-idx-1", "test-idx-2", "test-idx-3");
                .cluster()
        assertThat(snapshotInfo2.successfulShards(), equalTo(snapshotInfo2.totalShards()));  
            .get();  
        SnapshotRestoreException exception = expectThrows(
import org.opensearch.cluster.ClusterState;
            SnapshotRestoreException.class,  
        assertBusy(() -> {  
            () -> client().admin()
            .setRenameReplacement("$1-copy")
                    Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 0).put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-2").build()  
        final SnapshotRestoreException restoreError = expectThrows(  
        // Write a document
            .get()
                .get()  
        );  
    private Settings indexSettings;
                .setRenamePattern("test-index")  
            .put(indexSettings())  
        logger.info("--> restore all indices from the snapshot");
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), equalTo(0));
                .cluster()
            allOf(greaterThan(0), equalTo(restoreSnapshotResponse.getRestoreInfo().totalShards()))
        SnapshotRestoreException exception = expectThrows(  
        Settings remoteStoreEnabledSetting = Settings.builder().put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false).build();
        // try index restore with UnmodifiableOnRestore setting unchanged
            .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
        Settings unmodifiableOnRestoreSettings = Settings.builder()
            .get();
        assertTrue(client().admin().indices().prepareGetAliases("alias-123").get().getAliases().isEmpty());  
            long restorePause = 0L;
        cluster().wipeIndices("test-idx");
            .put(newIndexSettings)
            .setIgnoreIndexSettings("*") // delete everything we can delete
        assertFalse(client().admin().indices().prepareGetAliases("alias-123").get().getAliases().isEmpty());
        assertHitCount(client.prepareSearch("test-idx").setSize(0).setQuery(matchQuery("field1", "bar")).get(), numdocs);  
        assertThat(snapshotInfo2.successfulShards(), greaterThan(0));
                .setIgnoreIndexSettings(IndexMetadata.SETTING_NUMBER_OF_SHARDS, IndexMetadata.SETTING_VERSION_CREATED)
        String snapshotName2 = "test-restore-snapshot2";  
import static org.opensearch.index.IndexSettings.INDEX_REFRESH_INTERVAL_SETTING;  
        setupSnapshotRestore();
        Client client = client();  
            .setRenamePattern(indexName1)  
            SnapshotRestoreException.class  
        );
        );
            );
                .setWaitForCompletion(false)
                .get()
            );
        } finally {
        setupSnapshotRestore();
    public void testParallelRestoreOperationsFromSingleSnapshot() throws Exception {
                is(blocks.hasIndexBlock("test-idx", IndexMetadata.INDEX_READ_BLOCK))
            .actionGet();
                .setIndices(index)
            assertThat(  
        try {  
        assertFalse(client().admin().indices().prepareGetAliases("alias-1").get().getAliases().isEmpty());  
                    .put(SETTING_NUMBER_OF_SHARDS, numShards.numPrimaries)
import java.util.stream.IntStream;
        } catch (InvalidIndexNameException ex) {
        String indexName1 = "testindex1";
    }  
                .setIndexSettings(mixedSettingsUnmodifiableOnRestore)
                .getSnapshotInfo()  
            .get();
                .cluster()
                .setRenamePattern(index)
 * compatible open source license.
            .cluster()
        ActionFuture<RestoreSnapshotResponse> restoreSnapshotResponse = client.admin()
            disableIndexBlock("test-idx", IndexMetadata.SETTING_READ_ONLY);
                .setIndexSettings(numberOfShardsSettingsSame)
                .setIndexSettings(newIncorrectIndexSettings)
            .setRenamePattern(index)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.V_EMPTY)  
            .cluster()
            final IllegalArgumentException restoreError = expectThrows(
                .prepareRestoreSnapshot(snapshotRepo, snapshotName1)
                () -> clusterAdmin().prepareRestoreSnapshot("test-repo", "snapshot-0")
        index(indexName1, "_doc", docId, "value", expectedValue);  
    }  
                .setRenamePattern(index)  
            () -> client().admin()  
                .setRenamePattern(index)  
            // Expected  
        // try index restore with mix of UnmodifiableOnRestore and USER_UNMODIFIABLE_SETTINGS settings modified
 * SPDX-License-Identifier: Apache-2.0
                .setIndices(index)
                .setWaitForCompletion(true),
            );  
import static org.hamcrest.Matchers.allOf;  
            .build();
                .setRenameReplacement(restoredIndex)
            .setTransientSettings(Settings.builder().put(INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(), "100b").build())  
        // check that restore now completes quickly (i.e. within 20 seconds)
        String snapshotName1 = "test-restore-snapshot1";
        logger.info("--> restore snapshot with aliases");
            () -> client().admin()
            .actionGet();
        createRepository(  
                .setRenameReplacement(restoredIndex)
                .setRenamePattern(index)  
        cluster().wipeIndices("test-idx");
        setupSnapshotRestore();  
                .setIndexSettings(unmodifiableOnRestoreSettings)  
        // try index restore with multiple USER_UNMODIFIABLE_SETTINGS settings modified
    public void testInvalidRestoreRequest_MultipleUserUnmodifiableSettingsModified() throws Exception {
                        .startObject("properties")
                    .setRenamePattern("test-index")  
    /**
                .setIndices(index)  
                .get()
            .setRenamePattern("(.+)")
        logger.info("--> restore index with correct settings from the snapshot");  
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
        String indexName2 = "testindex2";  
            .cluster()
            .setRenamePattern("(.+)")  
                .actionGet();
        assertThat(
        try {
        restoreSnapshotResponse = client.admin()  
        logger.info("--> close index");
    }
        // try index restore with mix of modifiable and USER_UNMODIFIABLE_SETTINGS settings modified
    public void testInvalidRestoreRequest_MixRemovableAndUnmodifiableOnRestoreIgnored() throws Exception {
            .build();
        assertHitCount(client.prepareSearch("test-idx").setSize(0).setQuery(matchQuery("field1", "bar")).get(), numdocs);  
