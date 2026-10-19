        );
            } else {
import java.util.Arrays;
        client().admin().cluster().restoreSnapshot(restoreSnapshotRequest, restoreSnapshotResponseStepListener);  
public class RestoreServiceIntegTests extends OpenSearchSingleNodeTestCase {  
                client().admin()
import java.util.Collection;  
        });
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
import org.opensearch.action.admin.indices.open.OpenIndexRequest;  
                new SearchRequest(indexToSearch).source(new SearchSourceBuilder().size(0).trackTotalHits(true)),
            client().admin()  
            new Object[] { new TestCase(false, false, true, true, true) },
    private final String renamedIndexName = "index_2";
        final CountDownLatch isRestorable = new CountDownLatch(1);
                final StepListener<OpenIndexResponse> openIndexResponseStepListener = new StepListener<>();
        this.renameIndexes = testCase.renameIndexes;
            client().bulk(bulkRequest, bulkResponseStepListener);
                    .deleteSnapshot(new DeleteSnapshotRequest(repoName, snapShotName), deleteSnapResponseStepListener);  
                final StepListener<AcknowledgedResponse> deleteSnapResponseStepListener = new StepListener<>();  
        }
                bulkRequest.add(new IndexRequest(indexName).source(Collections.singletonMap("foo", "bar" + i)));
                .cluster()
            client().search(  
            client().admin().indices().close(new CloseIndexRequest(indexToClose), closeIndexResponseStepListener);
        if (!this.exists && !this.renameIndexes) {
            continueOrDie(createSnapshotResponseStepListener, ignored -> isRestorable.countDown());  
        public boolean closed;  
            if (expectSuccess) {
        });
    private static <T> void continueOrDie(StepListener<T> listener, CheckedConsumer<T, Exception> onResponse) {
import org.junit.After;  
        }
            final BulkRequest bulkRequest = new BulkRequest().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);  
            new Object[] { new TestCase(true, false, true, true, true) },
        }
            }  
    }  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
 *
                client().admin().indices().open(new OpenIndexRequest(indexToSearch).waitForActiveShards(1), openIndexResponseStepListener);  
            );
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.builder.SearchSourceBuilder;  
            continueOrDie(bulkResponseStepListener, bulkResponse -> {  
                        .deleteAsync(new DeleteIndexRequest(indexName))  
            );  
            continueOrDie(createSnapshotResponseStepListener, ignored -> {
                    client().admin()
            this.renameAliases = renameAliases;  
    private final int waitInSeconds = 60;
                isOpened.await(waitInSeconds, TimeUnit.SECONDS);  
            isRestored.countDown();  
    @After
            FsRepository.TYPE,  
            new Object[] { new TestCase(true, true, true, false, false) }  
                .execute(createSnapshotResponseStepListener);
                .setPartial(true)
        );  
                continueOrDie(deleteSnapResponseStepListener, ignored -> allDeleted.countDown());
import org.opensearch.action.admin.indices.close.CloseIndexResponse;  
            final String indexToSearch = this.renameIndexes ? renamedIndexName : indexName;  
import org.opensearch.common.settings.Settings;
import org.opensearch.repositories.fs.FsRepository;
import org.opensearch.action.search.SearchRequest;
                    searchAliasResponseListener
                assertFalse("Failures in bulk response: " + bulkResponse.buildFailureMessage(), bulkResponse.hasFailures());
        isRestorable.await(waitInSeconds, TimeUnit.SECONDS);  
    private boolean exists;
            });
    public static class TestCase {
    @ParametersFactory
            client().admin().indices().existsAsync(new IndicesExistsRequest(indexName)).thenAccept(resp -> {
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
            .aliases(
        public String toString() {
        restoreSnapshotResponseStepListener.whenComplete(ignored -> {
                continueOrDie(searchAliasResponseListener, ignored -> { isSearchDone.countDown(); });
                final CountDownLatch isOpened = new CountDownLatch(1);
    private boolean closed;  
            if (this.includeAlias) {
                .prepareCreateSnapshot(repoName, snapShotName)
    public void cleanup() throws InterruptedException {
        this.exists = testCase.exists;  
        final CountDownLatch isRestored = new CountDownLatch(1);  
            return String.join(
    public void testRestoreWithRename() throws Exception {
        OpenSearchIntegTestCase.putRepository(  
        this.renameAliases = testCase.renameAliases;  
                    new SearchRequest(aliasToSearch).source(new SearchSourceBuilder().size(0).trackTotalHits(true)),
        continueOrDie(createAliasResponseStepListener, ignored -> {
import java.util.concurrent.CountDownLatch;  
            client().admin().cluster(),
    public RestoreServiceIntegTests(TestCase testCase) {
            new Object[] { new TestCase(false, false, false, true, true) },
            });
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
        public boolean exists;
import org.opensearch.action.search.SearchResponse;  
            new Object[] { new TestCase(true, true, true, true, true) },
        final StepListener<GetSnapshotsResponse> snapStatusResponseStepListener = new StepListener<>();
            }
            this.exists = exists;  
            .indices()
        final int documents = randomIntBetween(1, 100);  
                isDocumentFinished.countDown();  
    private final String repoName = "repo_1";
        }
            }
            isRestored.countDown();  
            final StepListener<SearchResponse> searchAliasResponseListener = new StepListener<>();
        if (this.closed) {  
        }
            final CountDownLatch isSearchDone = new CountDownLatch(this.includeAlias ? 2 : 1);  
        });
            this.createIndex(renamedIndexName);
                        .indices()
        Settings.Builder settings = Settings.builder().put("location", randomAlphaOfLength(10));
        client().admin().cluster().getSnapshots(new GetSnapshotsRequest(repoName), snapStatusResponseStepListener);  
            .waitForCompletion(true);
    private boolean renameAliases;
 * The OpenSearch Contributors require contributions made to  
            continueOrDie(closeIndexResponseStepListener, ignored -> { isClosed.countDown(); });  
            final StepListener<SearchResponse> searchIndexResponseListener = new StepListener<>();
        }
            final StepListener<BulkResponse> bulkResponseStepListener = new StepListener<>();
                throw new RuntimeException(e);
                .setWaitForCompletion(true)  
                allDeleted.countDown();  
        }
        if (this.renameIndexes) {  
        } else {
            isClosed.await(waitInSeconds, TimeUnit.SECONDS);
        continueOrDie(snapStatusResponseStepListener, resp -> {
import java.util.Collections;
        if (this.exists && this.renameIndexes) {  
                " and ",  
}
        final boolean expectSuccess = !this.exists || this.closed;
import org.opensearch.action.admin.indices.close.CloseIndexRequest;
            if (this.includeAlias) {
    }
    }
            new Object[] { new TestCase(true, true, false, false, false) },
            });
    private final String indexName = "index_1";
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsRequest;
            );  
            this.closed = closed;
import org.opensearch.action.bulk.BulkRequest;
        this.includeAlias = testCase.includeAlias;
        this.createIndex(indexName);
        }, e -> {
            }  
                searchIndexResponseListener
import org.opensearch.test.OpenSearchIntegTestCase;
            new Object[] { new TestCase(false, false, false, false, false) },
            assertTrue("unexpected successful restore", expectSuccess);
        final StepListener<AcknowledgedResponse> createAliasResponseStepListener = new StepListener<>();
import org.opensearch.action.admin.indices.open.OpenIndexResponse;
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        if (expectSuccess) {
import org.opensearch.common.CheckedConsumer;  
            if (this.closed) {  
        for (String indexName : new String[] { indexName, renamedIndexName }) {
    private final String snapShotName = "snap_1";  
        this.closed = testCase.closed;
                assertEquals(documents, bulkResponse.getItems().length);
package org.opensearch.snapshots;
            }
            for (int i = 0; i < documents; ++i) {
                    allDeleted.countDown();  
            final String aliasToSearch = this.renameAliases ? renamedAliasName : aliasName;
        RestoreSnapshotRequest restoreSnapshotRequest = new RestoreSnapshotRequest(repoName, snapShotName).includeAliases(this.includeAlias)
        final StepListener<CreateSnapshotResponse> createSnapshotResponseStepListener = new StepListener<>();
            if (resp.getSnapshots().stream().anyMatch(s -> s.snapshotId().getName().equals(snapShotName))) {
 * SPDX-License-Identifier: Apache-2.0
    private final String renamedAliasName = "alias_2";
 * compatible open source license.
                );  
                    exists ? "target index exists and is" + (closed ? "closed" : "open") : "doesn't exist",
                    renameIndexes ? "renaming indexes" : "not renaming indexes",
            this.includeAlias = includeAlias;
            final CountDownLatch isClosed = new CountDownLatch(1);
            new Object[] { new TestCase(true, false, false, true, true) },  
                client().admin().indices().deleteAsync(new DeleteIndexRequest(indexName)).thenAccept(r -> isRestorable.countDown());  
                                            // closed to avoid pointless duplicate tests
            this.renameIndexes = renameIndexes;
        return Arrays.asList(  
import org.opensearch.action.bulk.BulkResponse;  
                    renameAliases ? "renaming aliases" : "not renaming aliases" }
            restoreSnapshotRequest = restoreSnapshotRequest.renameAliasPattern("1").renameAliasReplacement("2");
                if (resp.isExists()) {  
            new Object[] { new TestCase(true, false, false, false, false) },  
    public static Collection<Object[]> parameters() {
            restoreSnapshotRequest = restoreSnapshotRequest.renamePattern("1").renameReplacement("2");
import java.util.concurrent.TimeUnit;
    }
import org.opensearch.action.support.WriteRequest;
            settings,
        assert this.exists || !this.closed; // index close state doesn't exist when the index doesn't exist - so only permit one value of  
            repoName,
            new Object[] { new TestCase(false, false, true, false, false) },  
/*  
        if (this.renameAliases) {  
                }
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
                    includeAlias ? "including aliases" : "not including aliases",  
                client().search(  
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
        }
        });  
        }  
        final CountDownLatch allDeleted = new CountDownLatch(3);  
                createAliasResponseStepListener
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        continueOrDie(putRepositoryResponseStepListener, ignored -> {
import java.util.Objects;
        isDocumentFinished.await(waitInSeconds, TimeUnit.SECONDS);
        allDeleted.await(waitInSeconds, TimeUnit.SECONDS);
                new String[] {
            continueOrDie(searchIndexResponseListener, ignored -> { isSearchDone.countDown(); });
        final CountDownLatch isDocumentFinished = new CountDownLatch(1);
        public boolean renameIndexes;  
    }
                    .cluster()
        client().admin()  
            isSearchDone.await(waitInSeconds, TimeUnit.SECONDS);
        final StepListener<AcknowledgedResponse> putRepositoryResponseStepListener = new StepListener<>();
    private boolean includeAlias;
        final StepListener<RestoreSnapshotResponse> restoreSnapshotResponseStepListener = new StepListener<>();
    private boolean renameIndexes;  
    }
                } else {
            new Object[] { new TestCase(true, false, true, false, false) },
            putRepositoryResponseStepListener
            final String indexToClose = this.renameIndexes ? renamedIndexName : indexName;  
    private final String aliasName = "alias_1";  
            new Object[] { new TestCase(true, true, false, true, true) },
        public TestCase(boolean exists, boolean closed, boolean includeAlias, boolean renameAliases, boolean renameIndexes) {
        isRestored.await(waitInSeconds, TimeUnit.SECONDS);  
            assertEquals(documents, Objects.requireNonNull(searchIndexResponseListener.result().getHits().getTotalHits()).value());  
import org.opensearch.action.StepListener;  
        listener.whenComplete(onResponse, e -> { throw new AssertionError(e); });
import org.opensearch.action.index.IndexRequest;
 */  
            }  
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;  
                continueOrDie(openIndexResponseStepListener, ignored -> { isOpened.countDown(); });
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        public boolean renameAliases;
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;  
            final StepListener<CloseIndexResponse> closeIndexResponseStepListener = new StepListener<>();
        public boolean includeAlias;
                assertEquals(documents, Objects.requireNonNull(searchAliasResponseListener.result().getHits().getTotalHits()).value());
                        .thenAccept(ignored -> { allDeleted.countDown(); });
                new IndicesAliasesRequest().addAliasAction(IndicesAliasesRequest.AliasActions.add().alias(aliasName).index(indexName)),  
