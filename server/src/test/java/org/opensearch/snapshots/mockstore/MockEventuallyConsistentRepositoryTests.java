            final BlobContainer blobContainer = repository.blobStore().blobContainer(repository.basePath());
            container.writeBlob(blobName, new ByteArrayInputStream(blobData), lengthWritten, false);  
            // We try to write another snap- blob for "foo" in the next generation. It fails because the content differs.
                AssertionError.class,
            assertThat(assertionError.getMessage(), equalTo("\nExpected: <6>\n     but: was <5>"));
import org.opensearch.common.settings.Settings;  
 * under the License.  
        ) {
            );  
                            snapshotId,
            BlobStoreRepository repository = new MockEventuallyConsistentRepository(
import org.opensearch.snapshots.SnapshotInfo;
            BlobStoreRepository repository = new MockEventuallyConsistentRepository(  
                Priority.NORMAL,
        try (
                blobStoreContext,  
                xContentRegistry(),
 */
                random()  
            BlobStoreRepository repository = new MockEventuallyConsistentRepository(  
    }
                final byte[] readBytes = new byte[lengthWritten + 1];
                new RepositoryMetadata("testRepo", "mockEventuallyConsistent", Settings.EMPTY),
            }  
 * The OpenSearch Contributors require contributions made to  
/*
        ) {  
                    0L,
                    Collections.emptyList(),
                f
import org.opensearch.repositories.RepositoryData;
                        snapshotId,
                        Collections.emptyList(),
            final BlobContainer container = repository.blobStore()
            // Apply state once to initialize repo properly like RepositoriesService would  
                new SnapshotInfo(  
                        0L,
                        0L,
                            1L,
        Settings.EMPTY,  
            )  
    public void testReadAfterWriteConsistently() throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
                xContentRegistry(),  
                )
                metadata,  
                    Metadata.EMPTY_METADATA,  
                recoverySettings,
 *  
 * this file be licensed under the Apache-2.0 license or a
    }
                )
                    new SnapshotInfo(
            final byte[] blobData = randomByteArrayOfLength(lengthWritten);
                xContentRegistry(),
    }
                    Priority.NORMAL,
package org.opensearch.snapshots.mockstore;
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
            try (InputStream in = blobContainer.readBlob(blobName)) {
                    true,  
/*  
    }
                        true,
                random()
                Metadata.EMPTY_METADATA,
            repository.start();
            final SnapshotId snapshotId = new SnapshotId("foo", UUIDs.randomBase64UUID());
            blobContainer.deleteBlobsIgnoringIfNotExists(Collections.singletonList(blobName));  
                BlobStoreTestUtil.mockClusterService(),
            final int lengthWritten = randomIntBetween(1, 100);
            PlainActionFuture.<RepositoryData, Exception>get(
            final AssertionError assertionError = expectThrows(
                        2L,
                    )
            )
            blobStoreContext.forceConsistent();
            )
                blobStoreContext,
            repository.start();
import org.opensearch.snapshots.SnapshotId;  
                () -> PlainActionFuture.<RepositoryData, Exception>get(
                RepositoryData.EMPTY_REPO_GEN,
                        ShardGenerations.EMPTY,
 * SPDX-License-Identifier: Apache-2.0
                    f  
import org.opensearch.cluster.metadata.Metadata;
import java.util.Arrays;
                blobStoreContext,  
 */  
            BlobStoreRepository repository = new MockEventuallyConsistentRepository(
        MockEventuallyConsistentRepository.Context blobStoreContext = new MockEventuallyConsistentRepository.Context();
import org.opensearch.common.blobstore.BlobContainer;
            final int lengthWritten = randomIntBetween(1, 100);
import static org.hamcrest.Matchers.equalTo;  
 *
import org.opensearch.Version;  
            PlainActionFuture.<RepositoryData, Exception>get(f ->  
                xContentRegistry(),  
                        Collections.emptyMap(),
                BlobStoreTestUtil.mockClusterService(),
                        Priority.NORMAL,
        final ClusterService clusterService = BlobStoreTestUtil.mockClusterService(metadata);  
                new RepositoryMetadata("testRepo", "mockEventuallyConsistent", Settings.EMPTY),
                        new SnapshotInfo(
                    null,
                assertThat(lengthSeen, equalTo(lengthWritten));
                Function.identity(),  
                            false,  
    }
import java.io.ByteArrayInputStream;
                    snapshotId,
                            0
                BlobStoreTestUtil.mockClusterService(),  
import org.opensearch.common.Priority;
            final int lengthWritten = randomIntBetween(1, 100);
        final AssertionError assertionError = expectThrows(AssertionError.class, () -> blobContainer.readBlob(blobName));
                new RepositoryMetadata("testRepo", "mockEventuallyConsistent", Settings.EMPTY),
            )
                        Collections.emptyList(),  
            final String blobName = randomAlphaOfLength(10);
            final byte[] blobData = randomByteArrayOfLength(lengthWritten);
            container.writeBlob(blobName, new ByteArrayInputStream(blobData), lengthWritten, false);  
                () -> container.writeBlob(blobName, new ByteArrayInputStream(blobData), lengthWritten, false)  
                    false,
 * You may obtain a copy of the License at  
                    5,
            final int lengthWritten = randomIntBetween(1, 100);
            ));  
import java.util.Collections;  
import org.opensearch.repositories.blobstore.BlobStoreRepository;
            final String blobName = randomAlphaOfLength(10);  
import java.nio.file.NoSuchFileException;
                    0  
                random()
                recoverySettings,
/*
                blobStoreContext,  
                recoverySettings,  
                        Metadata.EMPTY_METADATA,  
import java.util.function.Function;
    public void testOverwriteSnapshotInfoBlob() throws Exception {  
        ) {
                        Function.identity(),
            final byte[] blobData = randomByteArrayOfLength(lengthWritten);
        MockEventuallyConsistentRepository.Context blobStoreContext = new MockEventuallyConsistentRepository.Context();
                        f  
            BlobStoreRepository repository = new MockEventuallyConsistentRepository(
import org.opensearch.common.UUIDs;  
                recoverySettings,
 * ownership. Elasticsearch licenses this file to you under  
            repository.start();
        }
                        false,  
            repository.start();  
                    0L,
import org.opensearch.cluster.service.ClusterService;
            assertThrowsOnInconsistentRead(blobContainer, blobName);
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        5,
                random()
                            null,  
    public void testReadAfterWriteAfterReadThrows() throws IOException {
 * KIND, either express or implied.  See the License for the
            final String blobName = randomAlphaOfLength(10);  
        assertThat(assertionError.getMessage(), equalTo("Inconsistent read on [" + blobName + ']'));
            final String blobName = BlobStoreRepository.SNAPSHOT_PREFIX + UUIDs.randomBase64UUID();  
                BlobStoreTestUtil.mockClusterService(),
            )
            final int lengthWritten = randomIntBetween(1, 100);  
            BlobStoreRepository repository = new MockEventuallyConsistentRepository(
        MockEventuallyConsistentRepository.Context blobStoreContext = new MockEventuallyConsistentRepository.Context();
 * this work for additional information regarding copyright
                        Collections.emptyList(),  
                xContentRegistry(),
            final BlobContainer blobContainer = repository.blobStore().blobContainer(repository.basePath());
 * Licensed to Elasticsearch under one or more contributor  
            assertThrowsOnInconsistentRead(blobContainer, blobName);
    }
                xContentRegistry(),  
        }  
            )
                random()  
import java.io.IOException;
            final AssertionError assertionError = expectThrows(
                ),
                new RepositoryMetadata("testRepo", "mockEventuallyConsistent", Settings.EMPTY),
                    ),
            // We try to write yet another snap- blob for "foo" in the next generation.  
            clusterService.addStateApplier(event -> repository.updateState(event.state()));
 *
                            0L,
                    Collections.emptyMap(),
public class MockEventuallyConsistentRepositoryTests extends OpenSearchTestCase {  
        }
                            true,
        }  
                            Collections.emptyList(),
                ShardGenerations.EMPTY,  
                        null,  
            repository.start();
                new RepositoryMetadata("testRepo", "mockEventuallyConsistent", Settings.EMPTY),
        MockEventuallyConsistentRepository.Context blobStoreContext = new MockEventuallyConsistentRepository.Context();
            // It passes cleanly because the content of the blob except for the timestamps.
            final byte[] blobData = randomByteArrayOfLength(lengthWritten);
    public void testOverwriteShardSnapBlobFails() throws IOException {  
            // We try to write another snap- blob for "foo" in the next generation. It fails because the content differs.
            final BlobContainer container = repository.blobStore().blobContainer(repository.basePath());
            );
            final AssertionError assertionError = expectThrows(  
            blobContainer.writeBlob(blobName, new ByteArrayInputStream(blobData), lengthWritten, true);  
                final int lengthSeen = in.read(readBytes);  
    public void testReadAfterDeleteAfterWriteThrows() throws IOException {  
                    ShardGenerations.EMPTY,
            final byte[] blobData = randomByteArrayOfLength(lengthWritten);
    private final RecoverySettings recoverySettings = new RecoverySettings(
import org.opensearch.cluster.metadata.RepositoryMetadata;  
 * Modifications Copyright OpenSearch Contributors. See  
                blobStoreContext,
                            Collections.emptyList(),  
        ) {  
                    Collections.emptyList(),  
 * Unless required by applicable law or agreed to in writing,
                Version.CURRENT,
                AssertionError.class,
                clusterService,
 * specific language governing permissions and limitations
        try (
            final String blobName = randomAlphaOfLength(10);  
                AssertionError.class,
            // We create a snap- blob for snapshot "foo" in the first generation
    private static void assertThrowsOnInconsistentRead(BlobContainer blobContainer, String blobName) {  
}
        MockEventuallyConsistentRepository.Context blobStoreContext = new MockEventuallyConsistentRepository.Context();
                    Collections.emptyList(),
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.repositories.ShardGenerations;  
                    Function.identity(),
            assertThat(assertionError.getMessage(), equalTo("Shard level snap-{uuid} blobs should never be overwritten"));
                blobStoreContext,
import static org.hamcrest.Matchers.startsWith;
                .blobContainer(repository.basePath().add("indices").add("someindex").add("0"));
            repository.updateState(clusterService.state());
            expectThrows(NoSuchFileException.class, () -> blobContainer.readBlob(blobName));  
        }  
            assertThat(assertionError.getMessage(), startsWith("Tried to overwrite blob [" + blobName + "]"));
    }  
        try (  
            blobContainer.writeBlob(blobName, new ByteArrayInputStream(blobData), lengthWritten, true);
        final RepositoryMetadata metadata = new RepositoryMetadata("testRepo", "mockEventuallyConsistent", Settings.EMPTY);
 * license agreements. See the NOTICE file distributed with
                random()
 */
            expectThrows(NoSuchFileException.class, () -> blobContainer.readBlob(blobName));  
            repository.finalizeSnapshot(
 * not use this file except in compliance with the License.
    public void testOverwriteRandomBlobFails() throws IOException {
            repository.start();  
            );
            blobContainer.writeBlob(blobName, new ByteArrayInputStream(blobData), lengthWritten, true);
                            Collections.emptyList(),  
                            Collections.emptyMap(),
 * compatible open source license.
        try (  
            final BlobContainer blobContainer = repository.blobStore().blobContainer(repository.basePath());
                        0
                        ),
                    f -> repository.finalizeSnapshot(  
import java.io.InputStream;  
                assertArrayEquals(blobData, Arrays.copyOf(readBytes, lengthWritten));
import org.opensearch.common.settings.ClusterSettings;
        ) {  
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;
        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        try (
                () -> container.writeBlob(blobName, new ByteArrayInputStream(blobData), lengthWritten - 1, false)  
                BlobStoreTestUtil.mockClusterService(),  
        MockEventuallyConsistentRepository.Context blobStoreContext = new MockEventuallyConsistentRepository.Context();
import org.opensearch.action.support.PlainActionFuture;
                            6,
    );
        try (  
 * GitHub history for details.
        ) {
import org.opensearch.indices.recovery.RecoverySettings;
                    1L,  
                f -> repository.finalizeSnapshot(  
                    Version.CURRENT,  
                recoverySettings,
                recoverySettings,
                        Version.CURRENT,  
            );
