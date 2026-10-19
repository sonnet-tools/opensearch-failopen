        final String repoName = createRepository(randomName());
import java.util.Set;  
        int restoreOperations = randomIntBetween(1, 3);  
            index("test-idx-2", "doc", Integer.toString(i), "foo", "baz" + i);
                    int docCount = (int) client().prepareSearch(index).setSize(0).get().getHits().getTotalHits().value();  
    protected static void assertSuccessfulRestore(RestoreSnapshotRequestBuilder requestBuilder) {
        ensureGreen();
import static org.hamcrest.Matchers.nullValue;  
            } else {
                } else {
    }
            // and ending somewhere between 100 bytes past that position and  
        return names.toArray(new String[num]);
    }
        );
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
                    }  
            container.delete();
import org.opensearch.snapshots.SnapshotRestoreException;  
            for (int i = 1; i < numberOfBarBlobs; i++) {  
            assertThat(repositories.repository(name).isReadOnly(), is(false));  
                        client().prepareDelete(indexName, Integer.toString(doc)).get();  
                    int deleteCount = randomIntBetween(1, docCount);
import org.opensearch.test.OpenSearchIntegTestCase;
                .setRouting(randomAlphaOfLength(randomIntBetween(1, 10)))
 * not use this file except in compliance with the License.
            }
            String name;
        final String repoName = createRepository("test-repo-" + randomAlphaOfLength(8));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            data[i] = (byte) randomInt();
            assertThat(repositories.repository(name), notNullValue());
        logger.info("--> indexing some data");  
        final boolean compress = randomBoolean();
import org.opensearch.common.blobstore.BlobPath;  
            containerBar.delete();
            assertAcked(client().admin().indices().prepareDelete(deleteIndices.toArray(new String[0])));  
            if (randomBoolean() && i > 0) { // don't delete on the first iteration
    protected final String createRepository(final String name, final Settings settings) {  
                name = randomName();  
            assertArrayEquals(readBlobFully(containerFoo, "test", data1.length), data1);  
import static org.hamcrest.Matchers.instanceOf;  
import org.opensearch.repositories.Repository;  
            .setIndices("test-idx-1", "test-idx-2")
import org.hamcrest.CoreMatchers;
    protected BlobStore newBlobStore() {  
        assertThat(response.getSnapshotInfo().successfulShards(), equalTo(response.getSnapshotInfo().totalShards()));
    }
    public void testContainerCreationAndDeletion() throws IOException {
    }
            final int endOffset = randomIntBetween(startOffset + 100, data.length - 100);  
    }
                    logger.info("--> delete {} random documents from {}", deleteCount, indexName);  
                    client().admin().indices().prepareRefresh(indexName).get();
 *
    private static void assertSuccessfulSnapshot(CreateSnapshotResponse response) {  
            }  
        byte[] data = new byte[length];
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
            if (randomBoolean()) {
            writeRandomBlob(container, name, length);  
        writeBlob(container, name, new BytesArray(data));  
    private static void assertSuccessfulRestore(RestoreSnapshotResponse response) {
                assertArrayEquals(subrangeData, actual);  
                writeBlob(container, "foobar", new BytesArray(data), false);
                assertEquals(data.length, target.length());  
    public static void writeBlob(
        });  
            assertThat(container.listBlobsByPrefix("bar-").size(), CoreMatchers.equalTo(numberOfBarBlobs));  
    public void testReadRange() throws IOException {
                    .setIndices(indexName)
            assertEquals(container.listBlobs().size(), 2);  
                        target.append(new BytesRef(buffer, offset, read));
        assertSuccessfulSnapshot(
            index("test-idx-3", "doc", Integer.toString(i), "foo", "baz" + i);
            indicesBlobContainer.set(repository.blobStore().blobContainer(repository.basePath().add("indices")));
                    .cluster()
                    is.read();  
        }
                    logger.info("--> add random documents to {}", index);  
            }  
                container.writeBlob(blobName, stream, bytesArray.length(), failIfAlreadyExists);  
        final Settings.Builder builder = Settings.builder();  
 *  
 * specific language governing permissions and limitations
    public void testWriteRead() throws IOException {  
    }
        if (closeIndices.size() > 0) {  
package org.opensearch.repositories.blobstore;
 */  
        Set<String> names = new HashSet<>();
                addRandomDocuments(indexName, docCount);
            indexRequestBuilders[i] = client().prepareIndex(name)
import org.opensearch.core.common.bytes.BytesArray;
            assertHitCount(client().prepareSearch(indexNames[i]).setSize(0).get(), docCounts[i]);  
            assertHitCount(client().prepareSearch(indexName).setSize(0).get(), docCounts[iterationToRestore]);
        final PlainActionFuture<RepositoryData> repositoryData = PlainActionFuture.newFuture();
                assertThat(blobMetadata.length(), CoreMatchers.equalTo(generated.getValue()));
            .get();
    }
        createSnapshotResponse = client.admin()  
        logger.info("--> take a snapshot");
        int iterationCount = randomIntBetween(2, 5);
        for (int i = 20; i < 40; i++) {
import java.nio.file.NoSuchFileException;
                assertFalse(indicesBlobContainer.get().blobExists(indexId.getId())); // deleted index
                }
            final BlobContainer container = store.blobContainer(new BlobPath());
        final boolean verify = randomBoolean();
        OpenSearchIntegTestCase.putRepository(client().admin().cluster(), name, repositoryType(), verify, Settings.builder().put(settings));
import org.opensearch.threadpool.ThreadPool;
            container.delete();  
        final String blobName,  
        List<String> deleteIndices = randomSubsetOf(randomIntBetween(0, indexCount), indexNames);  
            () -> client().admin().cluster().prepareGetSnapshots(repoName).setSnapshots(snapshotName).get()
import java.io.IOException;  
            }
            RepositoriesService.class  
            .cluster()
            docCounts[i] = iterations(10, 1000);  
                client().admin()  
        assertThat(response.getRestoreInfo().successfulShards(), greaterThan(0));
/*  
        }  
            index("test-idx-1", "doc", Integer.toString(i), "foo", "bar" + i);  
            SnapshotMissingException.class,
                }
            try (InputStream stream = container.readBlob("foobar")) {  
            byte[] data2 = randomBytes(randomIntBetween(10, scaledRandomIntBetween(1024, 1 << 16)));
    protected static String randomName() {  
    }
        try (InputStream stream = bytesArray.streamInput()) {
/*
            ensureGreen();  
                        client().prepareDelete(index, Integer.toString(doc)).get();
            logger.info("-->  delete indices {}", deleteIndices);
                int docCount = randomIntBetween(10, 1000);
            logger.info("-->  create snapshot {}:{} with {} documents", repoName, snapshotName + "-" + i, docCounts[i]);
                    .cluster()
        try (BlobStore store = newBlobStore()) {  
        });  
        ThreadPool threadPool = internalCluster().getInstance(ThreadPool.class, internalCluster().getClusterManagerName());
import java.io.InputStream;
 * under the License.  
        try (BlobStore store = newBlobStore()) {
            .setWaitForCompletion(true)  
    }  
        }
        createIndex("test-idx-1", "test-idx-2", "test-idx-3");  
import org.opensearch.common.SetOnce;  
    }  
            assertTrue(containerFoo.blobExists("test"));  
            assertAcked(client().admin().indices().prepareClose(closeIndices.toArray(new String[0])));
        final BytesArray bytesArray,
    }
                        int doc = randomIntBetween(0, docCount - 1);
    }  
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequestBuilder;  
            // Check number of documents in this iteration  
            );  
 * ownership. Elasticsearch licenses this file to you under  
                    .prepareCreateSnapshot(repoName, snapshotName + "-" + i)  
        }  
            assertSuccessfulRestore(
 */
 * The OpenSearch Contributors require contributions made to  
 */
            String name = "bar-0-";
        byte[] data = randomBytes(length);
        try (BlobStore store = newBlobStore()) {  
        try (InputStream inputStream = container.readBlob(name)) {  
            names.add(name);
            Map<String, Long> generatedBlobs = new HashMap<>();
            addRandomDocuments(indexNames[i], docCounts[i]);
            client().admin().cluster().prepareCreateSnapshot(repoName, snapshotName).setWaitForCompletion(true).setIndices(indexNames)  
        logger.info("-->  delete snapshot {}:{}", repoName, snapshotName);  
        for (int i = 0; i < 20; i++) {
                        fail("Expected [" + (data.length - target.length()) + "] more bytes to be readable but reached EOF");  
        return data;  
                    byte[] buffer = new byte[scaledRandomIntBetween(1, data.length - target.length())];  
                data = randomBytes(randomIntBetween(10, scaledRandomIntBetween(1024, 1 << 16)));  
            assertArrayEquals(readBlobFully(containerBar, "test", data2.length), data2);
                while (target.length() < data.length) {
            for (String index : closeIndices) {
        assertEquals(createSnapshotResponse.getSnapshotInfo().successfulShards(), createSnapshotResponse.getSnapshotInfo().totalShards());  
        }  
            .prepareCreateSnapshot(repoName, "test-snap2")
            }
            index("test-idx-1", "doc", Integer.toString(i), "foo", "bar" + i);
import org.opensearch.action.index.IndexRequestBuilder;
    }  
                    addRandomDocuments(index, randomIntBetween(10, 1000));
        for (int i = 0; i < iterationCount; i++) {
import org.opensearch.common.blobstore.BlobMetadata;
                    for (int j = 0; j < deleteCount; j++) {
                String name = "bar-" + i + "-";
        int indexCount = randomIntBetween(1, 5);
            final byte[] subrangeData = Arrays.copyOfRange(data, startOffset, endOffset);
                    .setWaitForCompletion(true)
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        String indexName = randomName();
            do {
        RepositoriesService repositoriesSvc = internalCluster().getInstance(  
        return data;
        }
        }
            assertTrue(container.listBlobs().isEmpty());
    public static byte[] randomBytes(int length) {
            docCounts[i] = (int) client().prepareSearch(indexName).setSize(0).get().getHits().getTotalHits().value();
        logger.info("--> restore all indices from the snapshot");
        }  
        }  
        return data;
import static org.hamcrest.Matchers.notNullValue;
            final byte[] data = randomBytes(4096);  
        builder.put("compress", compress);
            );
    public void testSnapshotAndRestore() throws Exception {
import org.opensearch.action.support.PlainActionFuture;
            logger.info("-->  close indices {}", closeIndices);
        ensureGreen();  
/*
        );  
                }  
            assertThat("blob store has to be lazy initialized", blobStore, verify ? is(notNullValue()) : is(nullValue()));
import java.util.Arrays;  
                try (InputStream is = container.readBlob("non-existing")) {
                client().admin()
    }
        ensureGreen();
import org.opensearch.repositories.RepositoryData;
import static org.hamcrest.Matchers.greaterThan;
        assertSuccessfulSnapshot(response);  
                .setId(Integer.toString(i))  
        logger.info("--> indexing more data");
        expectThrows(SnapshotMissingException.class, () -> client().admin().cluster().prepareDeleteSnapshot(repoName, snapshotName).get());
            Map<String, BlobMetadata> blobs = container.listBlobs();
            final BlobContainer container = store.blobContainer(new BlobPath());  
        assertAcked(client().admin().cluster().prepareDeleteSnapshot(repoName, snapshotName).get());
import org.opensearch.repositories.IndexId;
                logger.info("--> add {} random documents to {}", docCount, indexName);  
        final BlobContainer container,
        for (int i = 0; i < num; i++) {  
            writeBlob(containerFoo, "test", new BytesArray(data1));  
            RepositoriesService.class,
        }
            writeBlob(container, "foobar", new BytesArray(data), randomBoolean());  
        ensureGreen();
            } while (names.contains(name));
        }
    }
    }
            .cluster()
            }  
        }  
            final List<String> blobNames = Arrays.asList("foobar", "barfoo");
 * license agreements. See the NOTICE file distributed with
        byte[] data = new byte[length];
        // higher timeout since we can have quite a few shards and a little more data here
        indexRandom(true, indexRequestBuilders);
        BlobStoreRepository repository = (BlobStoreRepository) repositoriesSvc.repository(repoName);
    protected static void writeBlob(BlobContainer container, String blobName, BytesArray bytesArray) throws IOException {  
            assertThat(container.listBlobs().size(), CoreMatchers.equalTo(0));
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See  
        try (BlobStore store = newBlobStore()) {
    }
        assertSuccessfulRestore(response);
                    .setWaitForCompletion(true)  
        ensureGreen();
    protected final String createRepository(final String name) {
                final byte[] actual = stream.readAllBytes();
        ensureGreen();
            for (String blobName : blobNames) {  
        }
            int numberOfFooBlobs = randomIntBetween(0, 10);  
        );  
            BlobStore blobStore = ((BlobStoreRepository) repositories.repository(name)).getBlobStore();
    public void testDeleteBlobs() throws IOException {  
        for (int i = 0; i < indexCount; i++) {
            index("test-idx-3", "doc", Integer.toString(i), "foo", "baz" + i);
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequestBuilder;
                    logger.info("--> delete {} random documents from {}", deleteCount, index);
            }
            .setWaitForCompletion(true)  
    public void testReadNonExistingPath() throws IOException {
                int length = randomIntBetween(10, 100);
        if (compress) {
                if (randomBoolean()) {
    }
            assertThat(Streams.readFully(inputStream, data), CoreMatchers.equalTo(length));
            container.deleteBlobsIgnoringIfNotExists(blobNames);
import java.util.Locale;
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[numDocs];  
        return createRepository(name, repositorySettings());  
    }
            }
        return PlainActionFuture.get(
 * software distributed under the License is distributed on an
}  
            byte[] data1 = randomBytes(randomIntBetween(10, scaledRandomIntBetween(1024, 1 << 16)));
            container.deleteBlobsIgnoringIfNotExists(blobNames); // does not raise when blobs don't exist  
        for (int i = 0; i < data.length; i++) {  
        CreateSnapshotResponse createSnapshotResponse = client.admin()  
                    } else {
        return name;
        ensureGreen();
            container.delete();
            final BlobContainer container = store.blobContainer(new BlobPath());
                    for (int i = 0; i < deleteCount; i++) {  
            .prepareCreateSnapshot(repoName, "test-snap")
    private String[] generateRandomNames(int num) {
        Client client = client();
        for (int i = 0; i < indexCount; i++) {
        assertAcked(client().admin().cluster().prepareDeleteSnapshot(repoName, "test-snap2").get());
            byte[] data = randomBytes(randomIntBetween(10, scaledRandomIntBetween(1024, 1 << 16)));
        ensureGreen(TimeValue.timeValueSeconds(120));  
import org.opensearch.action.ActionRunnable;
        ensureGreen();
import org.opensearch.snapshots.SnapshotMissingException;
                    }
                if (docCount > 0) {
        return PlainActionFuture.get(repository::getRepositoryData);
    public static RepositoryData getRepositoryData(Repository repository) {
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
                    client().admin().indices().prepareRefresh(index).get();
        }  
 */
        int[] docCounts = new int[iterationCount];  
            assertAcked(client().admin().cluster().prepareDeleteSnapshot(repoName, snapshotName + "-" + i).get());  
import static org.hamcrest.Matchers.equalTo;
    protected abstract String repositoryType();
            writeBlob(container, "foobar", new BytesArray(data), randomBoolean());  
import org.opensearch.common.blobstore.BlobStore;
        ensureGreen();
        RestoreSnapshotResponse response = requestBuilder.get();  
            builder.put("compression_type", randomFrom(CompressorRegistry.registeredCompressors().keySet()));  
            logger.info("-->  delete snapshot {}:{}", repoName, snapshotName + "-" + i);
        return randomAlphaOfLength(randomIntBetween(5, 10)).toLowerCase(Locale.ROOT);
                writeRandomBlob(container, name, length);
            assertThat(repositories.repository(name), instanceOf(BlobStoreRepository.class));
        }  
        }  
import org.opensearch.common.settings.Settings;  
                .setSource("field", "value");
            assertAcked(client().admin().indices().prepareClose(indexName));
            for (Map.Entry<String, Long> generated : generatedBlobs.entrySet()) {
            // 100 bytes before the end
                generatedBlobs.put(name, (long) length);  
        for (IndexId indexId : repositoryData.actionGet().getIndices().values()) {
            assertHitCount(client().prepareSearch(indexNames[i]).setSize(0).get(), docCounts[i]);  
import org.opensearch.transport.client.Client;  
            SnapshotRestoreException.class,
 *
            final BlobContainer container = store.blobContainer(new BlobPath());
        );
        final SetOnce<BlobContainer> indicesBlobContainer = new SetOnce<>();
                assertArrayEquals(data, Arrays.copyOfRange(target.bytes(), 0, target.length()));
        assertThat(response.getSnapshotInfo().successfulShards(), greaterThan(0));
                    int read = stream.read(buffer, offset, buffer.length - offset);
    public void testIndicesDeletedFromRepository() throws Exception {
        }
            try (InputStream stream = container.readBlob("foobar", startOffset, subrangeData.length)) {
        expectThrows(  
                    int deleteCount = randomIntBetween(1, docCount);
                generatedBlobs.put(name, (long) length);  
        int[] docCounts = new int[indexCount];  
            // Pick a subrange starting somewhere between position 100 and 1000
            expectThrows(NoSuchFileException.class, () -> {
/**
            final BytesArray bytesArray = new BytesArray(data);
            final int startOffset = randomIntBetween(100, 1000);
                    if (read >= 0) {  
            final BlobContainer containerFoo = store.blobContainer(new BlobPath().add("foo"));
                writeRandomBlob(container, name, length);
    public static byte[] readBlobFully(BlobContainer container, String name, int length) throws IOException {
import java.util.List;  
            } else {
                    .prepareRestoreSnapshot(repoName, snapshotName + "-" + iterationToRestore)
 * GitHub history for details.
        for (int i = 0; i < numDocs; i++) {
            });
import org.apache.lucene.util.BytesRefBuilder;
        logger.info("--> take another snapshot with only 2 of the 3 indices");
        final String repoName = createRepository(randomName());
                container.writeBlobAtomic(blobName, stream, bytesArray.length(), failIfAlreadyExists);
                int length = randomIntBetween(10, 100);
                String name = "foo-" + i + "-";
            container.deleteBlobsIgnoringIfNotExists(blobNames); // does not raise when blobs don't exist  
        assertSuccessfulRestore(client().admin().cluster().prepareRestoreSnapshot(repoName, snapshotName).setWaitForCompletion(true));  
public abstract class OpenSearchBlobStoreRepositoryIntegTestCase extends OpenSearchIntegTestCase {
            f -> blobStoreRepository.threadPool().generic().execute(ActionRunnable.supply(f, blobStoreRepository::blobStore))  
        expectThrows(
                    int offset = scaledRandomIntBetween(0, buffer.length - 1);
                writeBlob(container, blobName, bytesArray, randomBoolean());
                assertThat(blobMetadata.name(), CoreMatchers.equalTo(generated.getKey()));
            assertTrue(containerBar.blobExists("test"));
 * compatible open source license.
import org.apache.lucene.util.BytesRef;  
        try (BlobStore store = newBlobStore()) {  
        for (int i = 0; i < restoreOperations; i++) {
    protected void addRandomDocuments(String name, int numDocs) throws InterruptedException {
    }
        try (InputStream stream = bytesArray.streamInput()) {
        );
        return builder.build();
            byte[] data = randomBytes(randomIntBetween(10, scaledRandomIntBetween(1024, 1 << 16)));
    }
        String snapshotName = randomName();
    }
            logger.info("-->  close index");
        Set<String> closeIndices = new HashSet<>(Arrays.asList(indexNames));  
        }
        String[] indexNames = generateRandomNames(indexCount);
            internalCluster().getClusterManagerName()
    protected static void assertSuccessfulSnapshot(CreateSnapshotRequestBuilder requestBuilder) {
            // Wait for green so the close does not fail in the edge case of coinciding with a shard recovery that hasn't fully synced yet
                assertThat(generated.getKey(), blobMetadata, CoreMatchers.notNullValue());  
import org.opensearch.core.compress.CompressorRegistry;  
            container.writeBlob(blobName, stream, bytesArray.length(), true);
        logger.info("--> delete a snapshot");
            assertThat(container.listBlobsByPrefix("baz-").size(), CoreMatchers.equalTo(0));
    }
            .get();
            containerFoo.delete();  
        closeIndices.removeAll(deleteIndices);
        try (BlobStore store = newBlobStore()) {
                }
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final BlobStoreRepository blobStoreRepository = (BlobStoreRepository) internalCluster().getClusterManagerNodeInstance(
 * Licensed to Elasticsearch under one or more contributor  
import java.util.HashSet;
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;  
        logger.debug("-->  creating repository [name: {}, verify: {}, settings: {}]", name, verify, settings);  
        if (deleteIndices.size() > 0) {
 * Unless required by applicable law or agreed to in writing,
        refresh();  
    }
        assertThat(response.getRestoreInfo().successfulShards(), equalTo(response.getRestoreInfo().totalShards()));  
 * Integration tests for {@link BlobStoreRepository} implementations.  
        ensureGreen();
                BytesRefBuilder target = new BytesRefBuilder();
            ensureGreen();  
            generatedBlobs.put(name, (long) length);
            logger.info("-->  performing restore of the iteration {}", iterationToRestore);  
        CreateSnapshotResponse response = requestBuilder.get();
import static org.hamcrest.Matchers.is;
        internalCluster().getDataOrClusterManagerNodeInstances(RepositoriesService.class).forEach(repositories -> {  
        ).repository(repository);
            }
            assertThat(inputStream.read(), CoreMatchers.equalTo(-1));
            int length = randomIntBetween(10, 100);  
        threadPool.executor(ThreadPool.Names.SNAPSHOT).execute(() -> {  
            repository.getRepositoryData(repositoryData);
            logger.info("--> restore index from the snapshot");
        logger.info("-->  create snapshot {}:{}", repoName, snapshotName);
        assertAcked(client().admin().indices().prepareCreate(indexName).get());  
                // override file, to check if we get latest contents
 * You may obtain a copy of the License at  
            // Wait for green so the close does not fail in the edge case of coinciding with a shard recovery that hasn't fully synced yet
import org.opensearch.common.blobstore.BlobContainer;
            if (indexId.getName().equals("test-idx-3")) {  
                        int doc = randomIntBetween(0, docCount - 1);
        }
        }  
            () -> client().admin().cluster().prepareRestoreSnapshot(repoName, snapshotName).setWaitForCompletion(randomBoolean()).get()  
        }
            int iterationToRestore = randomIntBetween(0, iterationCount - 1);
                    }
    protected Settings repositorySettings() {
 * the Apache License, Version 2.0 (the "License"); you may
        final String repository = createRepository(randomName());
            final BlobContainer container = store.blobContainer(new BlobPath());
            index("test-idx-2", "doc", Integer.toString(i), "foo", "baz" + i);  
    public void testList() throws IOException {  
            }
            assertThat(blobs.size(), CoreMatchers.equalTo(numberOfFooBlobs + numberOfBarBlobs));  
                BlobMetadata blobMetadata = blobs.get(generated.getKey());
    public void testMultipleSnapshotAndRollback() throws Exception {
            int numberOfBarBlobs = randomIntBetween(3, 20);
import org.opensearch.common.io.Streams;
            }
        }
            for (int i = 0; i < numberOfFooBlobs; i++) {  
import org.opensearch.repositories.RepositoriesService;
        for (int i = 0; i < iterationCount; i++) {
    ) throws IOException {  
            if (randomBoolean()) {
    }  
            ensureGreen();  
        logger.info("--> verify index folder deleted from blob container");
        final String snapshotName = randomName();  
import org.opensearch.common.unit.TimeValue;
        assertAcked(client().admin().cluster().prepareDeleteSnapshot(repoName, "test-snap").get());  
    public static byte[] writeRandomBlob(BlobContainer container, String name, int length) throws IOException {
        assertEquals(createSnapshotResponse.getSnapshotInfo().successfulShards(), createSnapshotResponse.getSnapshotInfo().totalShards());
import java.util.Map;
        boolean failIfAlreadyExists
import java.util.HashMap;
            assertSuccessfulSnapshot(  
            logger.info("-->  create random index {} with {} records", indexNames[i], docCounts[i]);
            writeBlob(containerBar, "test", new BytesArray(data2));
            assertThat(container.listBlobsByPrefix("foo-").size(), CoreMatchers.equalTo(numberOfFooBlobs));
                int docCount = docCounts[i - 1];  
            final BlobContainer containerBar = store.blobContainer(new BlobPath().add("bar"));  
