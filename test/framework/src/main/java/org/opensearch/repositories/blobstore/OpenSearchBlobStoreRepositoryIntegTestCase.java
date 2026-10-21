        for (int i = 0; i < numDocs; i++) {
        Set<String> names = new HashSet<>();
import org.opensearch.common.unit.TimeValue;
                    }
        RestoreSnapshotResponse response = requestBuilder.get();
        logger.info("--> indexing some data");
        for (int i = 20; i < 40; i++) {
            assertTrue(container.listBlobs().isEmpty());
import java.util.HashSet;
        internalCluster().getDataOrClusterManagerNodeInstances(RepositoriesService.class).forEach(repositories -> {
            container.delete();
            SnapshotRestoreException.class,
            }
            .get();
                try (InputStream is = container.readBlob("non-existing")) {
        if (compress) {
        for (int i = 0; i < iterationCount; i++) {
            byte[] data1 = randomBytes(randomIntBetween(10, scaledRandomIntBetween(1024, 1 << 16)));
        logger.debug("-->  creating repository [name: {}, verify: {}, settings: {}]", name, verify, settings);
        assertAcked(client().admin().cluster().prepareDeleteSnapshot(repoName, "test-snap2").get());
        writeBlob(container, name, new BytesArray(data));
        refresh();
            ensureGreen();
            repository.getRepositoryData(repositoryData);
            writeRandomBlob(container, name, length);
import org.opensearch.common.blobstore.BlobStore;
            assertAcked(client().admin().indices().prepareClose(indexName));
            index("test-idx-2", "doc", Integer.toString(i), "foo", "baz" + i);
    }
            container.deleteBlobsIgnoringIfNotExists(blobNames);
            byte[] data2 = randomBytes(randomIntBetween(10, scaledRandomIntBetween(1024, 1 << 16)));
            String name = "bar-0-";
            container.delete();
            }
        }
                }
    }
                generatedBlobs.put(name, (long) length);
            final BytesArray bytesArray = new BytesArray(data);
            }
                    .setIndices(indexName)
            final BlobContainer container = store.blobContainer(new BlobPath());
        assertThat(response.getSnapshotInfo().successfulShards(), greaterThan(0));
                }
import org.apache.lucene.util.BytesRef;
    private String[] generateRandomNames(int num) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    }
 * Modifications Copyright OpenSearch Contributors. See
            container.writeBlob(blobName, stream, bytesArray.length(), true);
    }
        try (BlobStore store = newBlobStore()) {
        return randomAlphaOfLength(randomIntBetween(5, 10)).toLowerCase(Locale.ROOT);
/*
            writeBlob(containerFoo, "test", new BytesArray(data1));
        BlobStoreRepository repository = (BlobStoreRepository) repositoriesSvc.repository(repoName);
        String indexName = randomName();
    private static void assertSuccessfulSnapshot(CreateSnapshotResponse response) {
                    .prepareCreateSnapshot(repoName, snapshotName + "-" + i)
        assertThat(response.getSnapshotInfo().successfulShards(), equalTo(response.getSnapshotInfo().totalShards()));
import org.opensearch.common.SetOnce;
            assertHitCount(client().prepareSearch(indexNames[i]).setSize(0).get(), docCounts[i]);
                .setSource("field", "value");
        byte[] data = new byte[length];
        assertAcked(client().admin().cluster().prepareDeleteSnapshot(repoName, snapshotName).get());
        assertSuccessfulSnapshot(response);
    public void testMultipleSnapshotAndRollback() throws Exception {
import org.opensearch.transport.client.Client;
        return name;
        logger.info("-->  delete snapshot {}:{}", repoName, snapshotName);
            assertThat(container.listBlobs().size(), CoreMatchers.equalTo(0));
        closeIndices.removeAll(deleteIndices);
                .setId(Integer.toString(i))
 * not use this file except in compliance with the License.
                writeBlob(container, blobName, bytesArray, randomBoolean());
    public static RepositoryData getRepositoryData(Repository repository) {
            container.deleteBlobsIgnoringIfNotExists(blobNames); // does not raise when blobs don't exist
        ensureGreen();
        return data;
            assertThat(container.listBlobsByPrefix("baz-").size(), CoreMatchers.equalTo(0));
                    .cluster()
            assertArrayEquals(readBlobFully(containerBar, "test", data2.length), data2);
    protected BlobStore newBlobStore() {
                    .setWaitForCompletion(true)
        ensureGreen();
            builder.put("compression_type", randomFrom(CompressorRegistry.registeredCompressors().keySet()));
        final Settings.Builder builder = Settings.builder();
            assertThat(repositories.repository(name).isReadOnly(), is(false));
import static org.hamcrest.Matchers.instanceOf;
        return builder.build();
            assertHitCount(client().prepareSearch(indexName).setSize(0).get(), docCounts[iterationToRestore]);
        assertSuccessfulRestore(client().admin().cluster().prepareRestoreSnapshot(repoName, snapshotName).setWaitForCompletion(true));
        logger.info("--> take a snapshot");
                        fail("Expected [" + (data.length - target.length()) + "] more bytes to be readable but reached EOF");
        final String repoName = createRepository("test-repo-" + randomAlphaOfLength(8));
    }
                writeBlob(container, "foobar", new BytesArray(data), false);
            index("test-idx-1", "doc", Integer.toString(i), "foo", "bar" + i);
    protected final String createRepository(final String name) {
        expectThrows(
 * Licensed to Elasticsearch under one or more contributor
    }
import org.opensearch.test.OpenSearchIntegTestCase;
        ).repository(repository);
        }
            for (Map.Entry<String, Long> generated : generatedBlobs.entrySet()) {
import static org.hamcrest.Matchers.nullValue;
import org.opensearch.snapshots.SnapshotRestoreException;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        final String snapshotName = randomName();
            final BlobContainer containerFoo = store.blobContainer(new BlobPath().add("foo"));
                }
            int length = randomIntBetween(10, 100);
        }
                data = randomBytes(randomIntBetween(10, scaledRandomIntBetween(1024, 1 << 16)));
            () -> client().admin().cluster().prepareGetSnapshots(repoName).setSnapshots(snapshotName).get()
            expectThrows(NoSuchFileException.class, () -> {
        }
                        int doc = randomIntBetween(0, docCount - 1);
            logger.info("--> restore index from the snapshot");
                    } else {
        }
import org.opensearch.snapshots.SnapshotMissingException;
            writeBlob(container, "foobar", new BytesArray(data), randomBoolean());
        try (BlobStore store = newBlobStore()) {
        logger.info("--> delete a snapshot");
            for (int i = 1; i < numberOfBarBlobs; i++) {
                final byte[] actual = stream.readAllBytes();
import org.opensearch.action.index.IndexRequestBuilder;
        for (int i = 0; i < restoreOperations; i++) {
            assertHitCount(client().prepareSearch(indexNames[i]).setSize(0).get(), docCounts[i]);
        try (InputStream stream = bytesArray.streamInput()) {
        }
        }
                assertArrayEquals(subrangeData, actual);
            try (InputStream stream = container.readBlob("foobar")) {
            // Check number of documents in this iteration
import java.util.Locale;
                    client().admin().indices().prepareRefresh(indexName).get();
        return PlainActionFuture.get(
        CreateSnapshotResponse response = requestBuilder.get();
    protected static void assertSuccessfulRestore(RestoreSnapshotRequestBuilder requestBuilder) {
    public void testList() throws IOException {
            container.delete();
        for (int i = 0; i < iterationCount; i++) {
            .setWaitForCompletion(true)
            final BlobContainer container = store.blobContainer(new BlobPath());
import static org.hamcrest.Matchers.notNullValue;
                    }
        RepositoriesService repositoriesSvc = internalCluster().getInstance(
            if (randomBoolean()) {
        assertSuccessfulRestore(response);
                assertFalse(indicesBlobContainer.get().blobExists(indexId.getId())); // deleted index
 * GitHub history for details.
 * specific language governing permissions and limitations
        }
            final int startOffset = randomIntBetween(100, 1000);
 * You may obtain a copy of the License at
            );
            assertEquals(container.listBlobs().size(), 2);
        Set<String> closeIndices = new HashSet<>(Arrays.asList(indexNames));
        });
                    int read = stream.read(buffer, offset, buffer.length - offset);
        CreateSnapshotResponse createSnapshotResponse = client.admin()
        ThreadPool threadPool = internalCluster().getInstance(ThreadPool.class, internalCluster().getClusterManagerName());
        }
        int restoreOperations = randomIntBetween(1, 3);
    public static void writeBlob(
            assertAcked(client().admin().cluster().prepareDeleteSnapshot(repoName, snapshotName + "-" + i).get());
        }
        try (BlobStore store = newBlobStore()) {
    }
                    int deleteCount = randomIntBetween(1, docCount);
            final BlobContainer container = store.blobContainer(new BlobPath());
        int[] docCounts = new int[indexCount];
    protected Settings repositorySettings() {
    public void testReadNonExistingPath() throws IOException {
 * compatible open source license.
        assertThat(response.getRestoreInfo().successfulShards(), equalTo(response.getRestoreInfo().totalShards()));
            index("test-idx-1", "doc", Integer.toString(i), "foo", "bar" + i);
        if (deleteIndices.size() > 0) {
        ensureGreen();
            .cluster()
            SnapshotMissingException.class,
        ensureGreen();
        assertEquals(createSnapshotResponse.getSnapshotInfo().successfulShards(), createSnapshotResponse.getSnapshotInfo().totalShards());
            assertThat(container.listBlobsByPrefix("bar-").size(), CoreMatchers.equalTo(numberOfBarBlobs));
            final BlobContainer containerBar = store.blobContainer(new BlobPath().add("bar"));
 * under the License.
            assertThat(repositories.repository(name), notNullValue());
            writeBlob(container, "foobar", new BytesArray(data), randomBoolean());
 */
            } else {
                // override file, to check if we get latest contents
import java.nio.file.NoSuchFileException;
            logger.info("-->  create random index {} with {} records", indexNames[i], docCounts[i]);
import org.opensearch.core.compress.CompressorRegistry;
                }
    }
        ensureGreen();
import org.opensearch.repositories.IndexId;
 * the Apache License, Version 2.0 (the "License"); you may
            }
                    .prepareRestoreSnapshot(repoName, snapshotName + "-" + iterationToRestore)
        }
                writeRandomBlob(container, name, length);
        for (int i = 0; i < num; i++) {
                        target.append(new BytesRef(buffer, offset, read));
            }
            logger.info("-->  close index");
        final String repoName = createRepository(randomName());
            index("test-idx-3", "doc", Integer.toString(i), "foo", "baz" + i);
    }
            String name;
            indicesBlobContainer.set(repository.blobStore().blobContainer(repository.basePath().add("indices")));
        byte[] data = new byte[length];
            index("test-idx-3", "doc", Integer.toString(i), "foo", "baz" + i);
 * The OpenSearch Contributors require contributions made to
        ensureGreen();
        }
        logger.info("-->  create snapshot {}:{}", repoName, snapshotName);
        }
        if (closeIndices.size() > 0) {
 * KIND, either express or implied.  See the License for the
            final List<String> blobNames = Arrays.asList("foobar", "barfoo");
        }
                writeRandomBlob(container, name, length);
import org.opensearch.core.common.bytes.BytesArray;
        final BlobContainer container,
                    if (read >= 0) {
            // Wait for green so the close does not fail in the edge case of coinciding with a shard recovery that hasn't fully synced yet
                int length = randomIntBetween(10, 100);
import org.apache.lucene.util.BytesRefBuilder;
import org.opensearch.action.ActionRunnable;
        Client client = client();
        boolean failIfAlreadyExists
                logger.info("--> add {} random documents to {}", docCount, indexName);
}
                int docCount = docCounts[i - 1];
            int numberOfFooBlobs = randomIntBetween(0, 10);
        final BytesArray bytesArray,
                client().admin()
        // higher timeout since we can have quite a few shards and a little more data here
 * Unless required by applicable law or agreed to in writing,
        return createRepository(name, repositorySettings());
        assertSuccessfulSnapshot(
            });
    }
 */
        for (int i = 0; i < indexCount; i++) {
        final String repository = createRepository(randomName());
                    logger.info("--> delete {} random documents from {}", deleteCount, index);
        return data;
    }
    }
        final String blobName,
        );
            }
        final boolean verify = randomBoolean();
import org.opensearch.repositories.Repository;
            );
            // Pick a subrange starting somewhere between position 100 and 1000
        threadPool.executor(ThreadPool.Names.SNAPSHOT).execute(() -> {
import java.io.InputStream;
    }
            RepositoriesService.class,
        );
            }
                        client().prepareDelete(indexName, Integer.toString(doc)).get();
            assertAcked(client().admin().indices().prepareClose(closeIndices.toArray(new String[0])));
                assertThat(generated.getKey(), blobMetadata, CoreMatchers.notNullValue());
import org.opensearch.common.settings.Settings;
            .prepareCreateSnapshot(repoName, "test-snap2")
    }
        for (int i = 0; i < data.length; i++) {
 *
import org.opensearch.common.blobstore.BlobMetadata;
            assertThat(blobs.size(), CoreMatchers.equalTo(numberOfFooBlobs + numberOfBarBlobs));
        );
            }
            RepositoriesService.class
        return PlainActionFuture.get(repository::getRepositoryData);
        byte[] data = randomBytes(length);
            docCounts[i] = (int) client().prepareSearch(indexName).setSize(0).get().getHits().getTotalHits().value();
            try (InputStream stream = container.readBlob("foobar", startOffset, subrangeData.length)) {
        ensureGreen();
            () -> client().admin().cluster().prepareRestoreSnapshot(repoName, snapshotName).setWaitForCompletion(randomBoolean()).get()
        try (BlobStore store = newBlobStore()) {
            .setIndices("test-idx-1", "test-idx-2")
        createSnapshotResponse = client.admin()
        final String repoName = createRepository(randomName());
    public void testDeleteBlobs() throws IOException {
        logger.info("--> indexing more data");
    protected static void writeBlob(BlobContainer container, String blobName, BytesArray bytesArray) throws IOException {
import java.util.HashMap;
import java.io.IOException;
 */
            final BlobContainer container = store.blobContainer(new BlobPath());
        expectThrows(
                generatedBlobs.put(name, (long) length);
    protected static String randomName() {
            logger.info("-->  performing restore of the iteration {}", iterationToRestore);
 *
            containerBar.delete();
        try (BlobStore store = newBlobStore()) {
            logger.info("-->  close indices {}", closeIndices);
            for (String blobName : blobNames) {
    public void testWriteRead() throws IOException {
                container.writeBlobAtomic(blobName, stream, bytesArray.length(), failIfAlreadyExists);
        });
                        client().prepareDelete(index, Integer.toString(doc)).get();
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequestBuilder;
            containerFoo.delete();
        expectThrows(SnapshotMissingException.class, () -> client().admin().cluster().prepareDeleteSnapshot(repoName, snapshotName).get());
                } else {
                String name = "foo-" + i + "-";
            Map<String, Long> generatedBlobs = new HashMap<>();
                    }
            generatedBlobs.put(name, (long) length);
            assertArrayEquals(readBlobFully(containerFoo, "test", data1.length), data1);
            byte[] data = randomBytes(randomIntBetween(10, scaledRandomIntBetween(1024, 1 << 16)));
 * license agreements. See the NOTICE file distributed with
        String snapshotName = randomName();
            if (indexId.getName().equals("test-idx-3")) {
 */
    private static void assertSuccessfulRestore(RestoreSnapshotResponse response) {
                assertThat(blobMetadata.length(), CoreMatchers.equalTo(generated.getValue()));
            final byte[] subrangeData = Arrays.copyOfRange(data, startOffset, endOffset);
    public static byte[] randomBytes(int length) {
    }
                while (target.length() < data.length) {
package org.opensearch.repositories.blobstore;
                int docCount = randomIntBetween(10, 1000);
 * SPDX-License-Identifier: Apache-2.0
        return data;
        assertThat(response.getRestoreInfo().successfulShards(), greaterThan(0));
    }
    }
            int numberOfBarBlobs = randomIntBetween(3, 20);
        ensureGreen();
                assertThat(blobMetadata.name(), CoreMatchers.equalTo(generated.getKey()));
 * this work for additional information regarding copyright
                    is.read();
import org.hamcrest.CoreMatchers;
                    .setWaitForCompletion(true)
                BytesRefBuilder target = new BytesRefBuilder();
        }
        }
                        int doc = randomIntBetween(0, docCount - 1);
 * Integration tests for {@link BlobStoreRepository} implementations.
import java.util.List;
    public static byte[] writeRandomBlob(BlobContainer container, String name, int length) throws IOException {
            ensureGreen();
                if (randomBoolean()) {
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        final PlainActionFuture<RepositoryData> repositoryData = PlainActionFuture.newFuture();
 * ownership. Elasticsearch licenses this file to you under
                    .cluster()
            assertSuccessfulSnapshot(
            .cluster()
        logger.info("--> take another snapshot with only 2 of the 3 indices");
                    for (int j = 0; j < deleteCount; j++) {
        for (int i = 0; i < indexCount; i++) {
            for (String index : closeIndices) {
            logger.info("-->  delete snapshot {}:{}", repoName, snapshotName + "-" + i);
            logger.info("-->  create snapshot {}:{} with {} documents", repoName, snapshotName + "-" + i, docCounts[i]);
                String name = "bar-" + i + "-";
            assertThat(inputStream.read(), CoreMatchers.equalTo(-1));
import org.opensearch.common.blobstore.BlobPath;
    }
import org.opensearch.threadpool.ThreadPool;
                BlobMetadata blobMetadata = blobs.get(generated.getKey());
                container.writeBlob(blobName, stream, bytesArray.length(), failIfAlreadyExists);
    }
            container.deleteBlobsIgnoringIfNotExists(blobNames); // does not raise when blobs don't exist
        String[] indexNames = generateRandomNames(indexCount);
import java.util.Map;
    }
        ensureGreen();
        int iterationCount = randomIntBetween(2, 5);
                assertEquals(data.length, target.length());
    }
            }
        final BlobStoreRepository blobStoreRepository = (BlobStoreRepository) internalCluster().getClusterManagerNodeInstance(
            final int endOffset = randomIntBetween(startOffset + 100, data.length - 100);
import org.opensearch.common.io.Streams;
 * this file be licensed under the Apache-2.0 license or a
    public static byte[] readBlobFully(BlobContainer container, String name, int length) throws IOException {
 * software distributed under the License is distributed on an
                    int offset = scaledRandomIntBetween(0, buffer.length - 1);
            // 100 bytes before the end
        }
    ) throws IOException {
        }
                    for (int i = 0; i < deleteCount; i++) {
            indexRequestBuilders[i] = client().prepareIndex(name)
            addRandomDocuments(indexNames[i], docCounts[i]);
                    byte[] buffer = new byte[scaledRandomIntBetween(1, data.length - target.length())];
/*
            Map<String, BlobMetadata> blobs = container.listBlobs();
import org.opensearch.action.support.PlainActionFuture;
        int indexCount = randomIntBetween(1, 5);
            .prepareCreateSnapshot(repoName, "test-snap")
            for (int i = 0; i < numberOfFooBlobs; i++) {
        logger.info("--> verify index folder deleted from blob container");
                client().admin()
                assertArrayEquals(data, Arrays.copyOfRange(target.bytes(), 0, target.length()));
        assertAcked(client().admin().indices().prepareCreate(indexName).get());
    }
    public void testContainerCreationAndDeletion() throws IOException {
            assertSuccessfulRestore(
            // and ending somewhere between 100 bytes past that position and
            internalCluster().getClusterManagerName()
    protected final String createRepository(final String name, final Settings settings) {
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
            f -> blobStoreRepository.threadPool().generic().execute(ActionRunnable.supply(f, blobStoreRepository::blobStore))
    }
        assertEquals(createSnapshotResponse.getSnapshotInfo().successfulShards(), createSnapshotResponse.getSnapshotInfo().totalShards());
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.common.blobstore.BlobContainer;
        try (InputStream stream = bytesArray.streamInput()) {
    protected static void assertSuccessfulSnapshot(CreateSnapshotRequestBuilder requestBuilder) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        for (int i = 0; i < 20; i++) {
            }
        try (InputStream inputStream = container.readBlob(name)) {
    public void testSnapshotAndRestore() throws Exception {
        List<String> deleteIndices = randomSubsetOf(randomIntBetween(0, indexCount), indexNames);
            data[i] = (byte) randomInt();
            assertThat("blob store has to be lazy initialized", blobStore, verify ? is(notNullValue()) : is(nullValue()));
import static org.hamcrest.Matchers.is;
                int length = randomIntBetween(10, 100);
            ensureGreen();
        OpenSearchIntegTestCase.putRepository(client().admin().cluster(), name, repositoryType(), verify, Settings.builder().put(settings));
            assertThat(Streams.readFully(inputStream, data), CoreMatchers.equalTo(length));
                .setRouting(randomAlphaOfLength(randomIntBetween(1, 10)))
    protected void addRandomDocuments(String name, int numDocs) throws InterruptedException {
        indexRandom(true, indexRequestBuilders);
            client().admin().cluster().prepareCreateSnapshot(repoName, snapshotName).setWaitForCompletion(true).setIndices(indexNames)
        );
    public void testReadRange() throws IOException {
        ensureGreen();
            // Wait for green so the close does not fail in the edge case of coinciding with a shard recovery that hasn't fully synced yet
        }
        int[] docCounts = new int[iterationCount];
    }
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequestBuilder;
import java.util.Set;
            names.add(name);
            assertTrue(containerBar.blobExists("test"));
            final byte[] data = randomBytes(4096);
            docCounts[i] = iterations(10, 1000);
                addRandomDocuments(indexName, docCount);
            writeBlob(containerBar, "test", new BytesArray(data2));
        );
        return names.toArray(new String[num]);
            int iterationToRestore = randomIntBetween(0, iterationCount - 1);
 *
            if (randomBoolean()) {
        final SetOnce<BlobContainer> indicesBlobContainer = new SetOnce<>();
import org.opensearch.repositories.RepositoryData;
            assertTrue(containerFoo.blobExists("test"));
import java.util.Arrays;
            assertThat(repositories.repository(name), instanceOf(BlobStoreRepository.class));
                    client().admin().indices().prepareRefresh(index).get();
                    addRandomDocuments(index, randomIntBetween(10, 1000));
            BlobStore blobStore = ((BlobStoreRepository) repositories.repository(name)).getBlobStore();
        logger.info("--> restore all indices from the snapshot");
            if (randomBoolean() && i > 0) { // don't delete on the first iteration
    }
/*
            } while (names.contains(name));
            assertThat(container.listBlobsByPrefix("foo-").size(), CoreMatchers.equalTo(numberOfFooBlobs));
        }
            .get();
            index("test-idx-2", "doc", Integer.toString(i), "foo", "baz" + i);
/**
            byte[] data = randomBytes(randomIntBetween(10, scaledRandomIntBetween(1024, 1 << 16)));
        builder.put("compress", compress);
        }
        }
    }
                name = randomName();
    protected abstract String repositoryType();
            }
        assertAcked(client().admin().cluster().prepareDeleteSnapshot(repoName, "test-snap").get());
        ensureGreen(TimeValue.timeValueSeconds(120));
                    logger.info("--> delete {} random documents from {}", deleteCount, indexName);
public abstract class OpenSearchBlobStoreRepositoryIntegTestCase extends OpenSearchIntegTestCase {
        try (BlobStore store = newBlobStore()) {
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[numDocs];
            assertAcked(client().admin().indices().prepareDelete(deleteIndices.toArray(new String[0])));
                    int docCount = (int) client().prepareSearch(index).setSize(0).get().getHits().getTotalHits().value();
            } else {
        for (IndexId indexId : repositoryData.actionGet().getIndices().values()) {
    public void testIndicesDeletedFromRepository() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                if (docCount > 0) {
import org.opensearch.repositories.RepositoriesService;
                    int deleteCount = randomIntBetween(1, docCount);
        }
        createIndex("test-idx-1", "test-idx-2", "test-idx-3");
            .setWaitForCompletion(true)
            do {
                    logger.info("--> add random documents to {}", index);
            logger.info("-->  delete indices {}", deleteIndices);
            final BlobContainer container = store.blobContainer(new BlobPath());
import static org.hamcrest.Matchers.greaterThan;
        final boolean compress = randomBoolean();
