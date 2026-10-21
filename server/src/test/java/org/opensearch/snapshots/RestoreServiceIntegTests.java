        final CountDownLatch allDeleted = new CountDownLatch(3);
            if (this.includeAlias) {
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
            client().admin()
                    exists ? "target index exists and is" + (closed ? "closed" : "open") : "doesn't exist",
/*
    @ParametersFactory
                continueOrDie(openIndexResponseStepListener, ignored -> { isOpened.countDown(); });
                assertEquals(documents, Objects.requireNonNull(searchAliasResponseListener.result().getHits().getTotalHits()).value());
            client().search(
        Settings.Builder settings = Settings.builder().put("location", randomAlphaOfLength(10));
                    includeAlias ? "including aliases" : "not including aliases",
            if (this.closed) {
                bulkRequest.add(new IndexRequest(indexName).source(Collections.singletonMap("foo", "bar" + i)));
        if (expectSuccess) {
            if (this.includeAlias) {
import org.opensearch.action.admin.indices.close.CloseIndexRequest;
    private boolean includeAlias;
        final CountDownLatch isDocumentFinished = new CountDownLatch(1);
            } else {
                new IndicesAliasesRequest().addAliasAction(IndicesAliasesRequest.AliasActions.add().alias(aliasName).index(indexName)),
                }
}
                client().admin().indices().deleteAsync(new DeleteIndexRequest(indexName)).thenAccept(r -> isRestorable.countDown());
                    allDeleted.countDown();
import org.opensearch.action.search.SearchRequest;
        public boolean includeAlias;
        );
        final CountDownLatch isRestorable = new CountDownLatch(1);
                continueOrDie(searchAliasResponseListener, ignored -> { isSearchDone.countDown(); });
        this.renameIndexes = testCase.renameIndexes;
            }
        OpenSearchIntegTestCase.putRepository(
        restoreSnapshotResponseStepListener.whenComplete(ignored -> {
        if (this.renameAliases) {
    public static Collection<Object[]> parameters() {
            new Object[] { new TestCase(true, false, true, false, false) },
    public void testRestoreWithRename() throws Exception {
        listener.whenComplete(onResponse, e -> { throw new AssertionError(e); });
        final CountDownLatch isRestored = new CountDownLatch(1);
            restoreSnapshotRequest = restoreSnapshotRequest.renamePattern("1").renameReplacement("2");
            this.renameIndexes = renameIndexes;
            continueOrDie(closeIndexResponseStepListener, ignored -> { isClosed.countDown(); });
            return String.join(
            this.createIndex(renamedIndexName);
                createAliasResponseStepListener
            putRepositoryResponseStepListener
    private final String indexName = "index_1";
                    client().admin()
            new Object[] { new TestCase(true, false, false, true, true) },
                throw new RuntimeException(e);
            continueOrDie(searchIndexResponseListener, ignored -> { isSearchDone.countDown(); });
        }
        continueOrDie(createAliasResponseStepListener, ignored -> {
    private boolean exists;
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
                assertEquals(documents, bulkResponse.getItems().length);
        }
            });
            }
import org.opensearch.repositories.fs.FsRepository;
    private static <T> void continueOrDie(StepListener<T> listener, CheckedConsumer<T, Exception> onResponse) {
                final StepListener<OpenIndexResponse> openIndexResponseStepListener = new StepListener<>();
                continueOrDie(deleteSnapResponseStepListener, ignored -> allDeleted.countDown());
        final StepListener<CreateSnapshotResponse> createSnapshotResponseStepListener = new StepListener<>();
            new Object[] { new TestCase(true, true, false, false, false) },
            assertTrue("unexpected successful restore", expectSuccess);
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsRequest;
        final StepListener<GetSnapshotsResponse> snapStatusResponseStepListener = new StepListener<>();
                        .indices()
    }
        }, e -> {
        for (String indexName : new String[] { indexName, renamedIndexName }) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.search.SearchResponse;
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
            final CountDownLatch isClosed = new CountDownLatch(1);
            isClosed.await(waitInSeconds, TimeUnit.SECONDS);
            this.closed = closed;
            assertEquals(documents, Objects.requireNonNull(searchIndexResponseListener.result().getHits().getTotalHits()).value());
        }
            .waitForCompletion(true);
                new String[] {
        }
                    searchAliasResponseListener
        isRestorable.await(waitInSeconds, TimeUnit.SECONDS);
    private final String aliasName = "alias_1";
            );
                );
        }
                isDocumentFinished.countDown();
                searchIndexResponseListener
    public RestoreServiceIntegTests(TestCase testCase) {
        });
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
import org.opensearch.common.settings.Settings;
import org.opensearch.search.builder.SearchSourceBuilder;
            }
        public boolean closed;
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        allDeleted.await(waitInSeconds, TimeUnit.SECONDS);
    }
            new Object[] { new TestCase(true, false, false, false, false) },
import java.util.Arrays;
            final StepListener<CloseIndexResponse> closeIndexResponseStepListener = new StepListener<>();
        assert this.exists || !this.closed; // index close state doesn't exist when the index doesn't exist - so only permit one value of
            new Object[] { new TestCase(false, false, true, true, true) },
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
        return Arrays.asList(
                client().search(
            new Object[] { new TestCase(true, false, true, true, true) },
            final BulkRequest bulkRequest = new BulkRequest().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
            isSearchDone.await(waitInSeconds, TimeUnit.SECONDS);
        });
            final String aliasToSearch = this.renameAliases ? renamedAliasName : aliasName;
    private final String snapShotName = "snap_1";
                .execute(createSnapshotResponseStepListener);
        if (this.closed) {
        if (!this.exists && !this.renameIndexes) {
    private boolean renameIndexes;
            final String indexToSearch = this.renameIndexes ? renamedIndexName : indexName;
            .aliases(
import org.junit.After;
    }
import org.opensearch.action.admin.indices.open.OpenIndexResponse;
            new Object[] { new TestCase(false, false, false, true, true) },
                assertFalse("Failures in bulk response: " + bulkResponse.buildFailureMessage(), bulkResponse.hasFailures());
        } else {
            new Object[] { new TestCase(true, true, true, true, true) },
import org.opensearch.action.admin.indices.close.CloseIndexResponse;
            continueOrDie(bulkResponseStepListener, bulkResponse -> {
        public TestCase(boolean exists, boolean closed, boolean includeAlias, boolean renameAliases, boolean renameIndexes) {
            }
                " and ",
                        .deleteAsync(new DeleteIndexRequest(indexName))
        });
            final StepListener<SearchResponse> searchAliasResponseListener = new StepListener<>();
        final int documents = randomIntBetween(1, 100);
            continueOrDie(createSnapshotResponseStepListener, ignored -> {
    private final int waitInSeconds = 60;
import java.util.Collection;
        this.includeAlias = testCase.includeAlias;
            client().bulk(bulkRequest, bulkResponseStepListener);
        }
        client().admin().cluster().getSnapshots(new GetSnapshotsRequest(repoName), snapStatusResponseStepListener);
                .setWaitForCompletion(true)
        if (this.exists && this.renameIndexes) {
            final CountDownLatch isSearchDone = new CountDownLatch(this.includeAlias ? 2 : 1);
    private boolean renameAliases;
import org.opensearch.action.support.WriteRequest;
            repoName,
            isRestored.countDown();
            if (expectSuccess) {
            client().admin().cluster(),
import org.opensearch.common.CheckedConsumer;
            this.includeAlias = includeAlias;
            if (resp.getSnapshots().stream().anyMatch(s -> s.snapshotId().getName().equals(snapShotName))) {
        final StepListener<AcknowledgedResponse> putRepositoryResponseStepListener = new StepListener<>();
        public boolean exists;
import org.opensearch.test.OpenSearchSingleNodeTestCase;
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
package org.opensearch.snapshots;
            this.exists = exists;
 * The OpenSearch Contributors require contributions made to
    }
                final CountDownLatch isOpened = new CountDownLatch(1);
                .prepareCreateSnapshot(repoName, snapShotName)
                    .cluster()
            restoreSnapshotRequest = restoreSnapshotRequest.renameAliasPattern("1").renameAliasReplacement("2");
                .setPartial(true)
        this.closed = testCase.closed;
            client().admin().indices().close(new CloseIndexRequest(indexToClose), closeIndexResponseStepListener);
import org.opensearch.test.OpenSearchIntegTestCase;
        this.renameAliases = testCase.renameAliases;
            this.renameAliases = renameAliases;
import org.opensearch.action.bulk.BulkResponse;
            client().admin().indices().existsAsync(new IndicesExistsRequest(indexName)).thenAccept(resp -> {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    private final String renamedAliasName = "alias_2";
    public void cleanup() throws InterruptedException {
                    new SearchRequest(aliasToSearch).source(new SearchSourceBuilder().size(0).trackTotalHits(true)),
        );
                } else {
                if (resp.isExists()) {
import java.util.concurrent.TimeUnit;
            continueOrDie(createSnapshotResponseStepListener, ignored -> isRestorable.countDown());
        client().admin()
        continueOrDie(putRepositoryResponseStepListener, ignored -> {
            final StepListener<SearchResponse> searchIndexResponseListener = new StepListener<>();
 * compatible open source license.
    @After
            );
        });
        final StepListener<RestoreSnapshotResponse> restoreSnapshotResponseStepListener = new StepListener<>();
            final String indexToClose = this.renameIndexes ? renamedIndexName : indexName;
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        public boolean renameIndexes;
        if (this.renameIndexes) {
            .indices()
import java.util.Objects;
import org.opensearch.action.admin.indices.open.OpenIndexRequest;
            }
            new Object[] { new TestCase(true, true, true, false, false) }
                    renameAliases ? "renaming aliases" : "not renaming aliases" }
    private final String renamedIndexName = "index_2";
        }
            for (int i = 0; i < documents; ++i) {
        isDocumentFinished.await(waitInSeconds, TimeUnit.SECONDS);
import org.opensearch.action.bulk.BulkRequest;
import java.util.Collections;
 *
                                            // closed to avoid pointless duplicate tests
    private boolean closed;
    }
        public boolean renameAliases;
                allDeleted.countDown();
            new Object[] { new TestCase(true, true, false, true, true) },
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            new Object[] { new TestCase(false, false, false, false, false) },
        public String toString() {
        isRestored.await(waitInSeconds, TimeUnit.SECONDS);
                        .thenAccept(ignored -> { allDeleted.countDown(); });
public class RestoreServiceIntegTests extends OpenSearchSingleNodeTestCase {
                .cluster()
        final boolean expectSuccess = !this.exists || this.closed;
        final StepListener<AcknowledgedResponse> createAliasResponseStepListener = new StepListener<>();
            });
            });
        }
                client().admin()
        client().admin().cluster().restoreSnapshot(restoreSnapshotRequest, restoreSnapshotResponseStepListener);
            isRestored.countDown();
            );
                new SearchRequest(indexToSearch).source(new SearchSourceBuilder().size(0).trackTotalHits(true)),
    }
                final StepListener<AcknowledgedResponse> deleteSnapResponseStepListener = new StepListener<>();
import org.opensearch.action.StepListener;
        this.exists = testCase.exists;
    public static class TestCase {
import java.util.concurrent.CountDownLatch;
            }
        continueOrDie(snapStatusResponseStepListener, resp -> {
import org.opensearch.action.index.IndexRequest;
            FsRepository.TYPE,
        this.createIndex(indexName);
 * SPDX-License-Identifier: Apache-2.0
 */
                    .deleteSnapshot(new DeleteSnapshotRequest(repoName, snapShotName), deleteSnapResponseStepListener);
    private final String repoName = "repo_1";
            new Object[] { new TestCase(false, false, true, false, false) },
        RestoreSnapshotRequest restoreSnapshotRequest = new RestoreSnapshotRequest(repoName, snapShotName).includeAliases(this.includeAlias)
        }
            settings,
                client().admin().indices().open(new OpenIndexRequest(indexToSearch).waitForActiveShards(1), openIndexResponseStepListener);
                isOpened.await(waitInSeconds, TimeUnit.SECONDS);
                    renameIndexes ? "renaming indexes" : "not renaming indexes",
            final StepListener<BulkResponse> bulkResponseStepListener = new StepListener<>();
