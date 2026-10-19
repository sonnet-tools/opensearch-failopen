                synchronized (context.actions) {
import static org.hamcrest.Matchers.containsInAnyOrder;
import org.opensearch.core.common.bytes.BytesArray;
                        .distinct()  
                            );  
                                    return; // No need to add a write for this since we didn't change content
            public void writeBlobAtomic(  
import org.opensearch.common.blobstore.BlobPath;  
    // TODO: Remove all usages of this method, snapshots should not depend on consistent list operations  
    /**
                }
    @Override  
            }
            } else if (action.operation == Operation.DELETE) {  
 * compatible open source license.
 *  
            @Override  
 * The OpenSearch Contributors require contributions made to  
        this.random = random;
                final String thisPath = path.buildAsString();  
import org.opensearch.common.blobstore.DeleteResult;
        return BlobPath.cleanPath();
                        .stream()  
                }  
                    readBlob(blobName);
    private enum Operation {  
 */  
                throw new AssertionError("Blobstore is closed already");  
 * TODO: Resolve todos on list and overwrite operation consistency to fully cover S3's behavior.
            @Override
                        throw new NoSuchFileException(blobPath);
                }
 * not use this file except in compliance with the License.
                }
 * ownership. Elasticsearch licenses this file to you under  
        private final List<BlobStoreAction> actions = new ArrayList<>();  
                synchronized (context.actions) {
            public DeleteResult delete() {
                        .map(action -> action.path.substring(thisPath.length()).split("/")[0])
                String blobName,
        final NamedXContentRegistry namedXContentRegistry,
            }  
            // Randomly filter out the index-N blobs from a listing to test that tracking of it in latestKnownRepoGen and the cluster state  
        private final AtomicBoolean closed = new AtomicBoolean(false);
                final String blobPath = path.buildAsString() + blobName;
/*  
                            )
                                    // Since we are not doing any actual IO we don't expect this to throw ever and an exception would
 * GitHub history for details.
                                        Streams.readFully(readBlob(blobName))
            @Override
                                        namedXContentRegistry,  
                                        namedXContentRegistry,
 */
    }
import org.opensearch.common.Nullable;  
                                    assertThat(existingInfo.indices(), equalTo(updatedInfo.indices()));  
import org.opensearch.cluster.metadata.RepositoryMetadata;
 * SPDX-License-Identifier: Apache-2.0
                synchronized (context.actions) {  
                    final boolean hasConsistentContent = relevantActions.size() == 1 && relevantActions.get(0).operation == Operation.PUT;
            @Override  
            // ensures consistent repository operations
        // Eventual consistency is only simulated as long as this flag is false  
                return Streams.limitStream(stream, length);  
            }  
                                    assertThat(existingInfo.successfulShards(), equalTo(updatedInfo.successfulShards()));
                    context.actions.add(new BlobStoreAction(Operation.GET, blobPath));  
                                throw new AssertionError("Shard level snap-{uuid} blobs should never be overwritten");  
import org.opensearch.common.blobstore.support.PlainBlobMetadata;  
                                    assertThat(existingInfo.snapshotId(), equalTo(updatedInfo.snapshotId()));  
            }  
 * under the License.  
import org.opensearch.common.io.Streams;
                    }  
import java.io.IOException;
                final String blobName,
                        // TODO: Ensure that it is impossible to ever decrement the generation id stored in index.latest then assert that
                boolean failIfAlreadyExists,
                    }
                        // Consistent read after write
                        context.actions.add(new BlobStoreAction(Operation.DELETE, a.path));  
import org.opensearch.cluster.service.ClusterService;
            public InputStream readBlob(String name) throws NoSuchFileException {
                    throw new AssertionError("Inconsistent read on [" + blobPath + ']');
                // Randomly filter out index-N blobs at the repo root to proof that we don't need them to be consistently listed  
            public void deleteBlobsIgnoringIfNotExists(List<String> blobNames) {
                    filtered.keySet().removeIf(b -> b.startsWith(BlobStoreRepository.INDEX_FILE_PREFIX) && random.nextBoolean());  
                                relevantActions.get(0).data,
                actions.clear();
    private static final class BlobStoreAction {  
        private boolean consistent;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
         * Force the repository into a consistent end state so that its eventual state can be examined.  
                        relevantActions.remove(i);
                                }
    private final Random random;  
                    } else {
        final Context context,
        private final String path;
                                    throw new AssertionError("Failed to deserialize SnapshotInfo", e);
            @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
            this.path = path;
            private final BlobPath path;  
 * this work for additional information regarding copyright
                                    // a problem and could be the result of a correctly handled cluster-manager failover.  
                        context.actions.add(new BlobStoreAction(Operation.DELETE, path.buildAsString() + blobName));
            private List<BlobStoreAction> relevantActions(String blobPath) {  
            }
                    return false;
                    context.actions.stream().filter(action -> blobPath.equals(action.path)).collect(Collectors.toList())  
                final byte[] data = new byte[(int) blobSize];
                ensureNotClosed();
import java.io.InputStream;
        @Override  
                        consistentView(context.actions).stream()
            }
            @Override  
                    for (String blobName : blobNames) {
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
            }
            synchronized (actions) {  
            }
                                    action -> action.path.substring(thisPath.length()),
import java.util.Random;  
                return relevantActions;  
            return new MockBlobContainer(path);
                            }
     * Context that must be shared between all instances of {@link MockEventuallyConsistentRepository} in a test run.
/*  
 * <a href="https://docs.aws.amazon.com/AmazonS3/latest/dev/Introduction.html#ConsistencyModel">AWS S3 docs</a>.  
    }
        DELETE  
                    consistentView(context.actions).stream().filter(action -> action.path.startsWith(thisPath)).forEach(a -> {
import org.opensearch.core.xcontent.NamedXContentRegistry;  
                ensureNotClosed();
                InputStream inputStream,
                }
        /**
            }
            public void writeBlobWithMetadata(  
            public InputStream readBlob(String blobName, long position, long length) throws IOException {
            public BlobPath path() {
                actions.addAll(consistentActions);  
        final Map<String, BlobStoreAction> lastActions = new HashMap<>();
 *
                        || blobName.startsWith(BlobStoreRepository.METADATA_PREFIX)) {
                    }  
 */  
            }  
                    stream.skip(position);
public class MockEventuallyConsistentRepository extends BlobStoreRepository {
                        if (hasConsistentContent) {
        final ClusterService clusterService,  
                                    && action.path.substring(thisPath.length()).indexOf('/') == -1
            if (closed.get()) {
                    final List<BlobStoreAction> relevantActions = relevantActions(blobPath);  
        return new MockBlobStore();
            }
 * KIND, either express or implied.  See the License for the
                ensureNotClosed();
import org.opensearch.repositories.blobstore.BlobStoreRepository;
                        break;  
                @Nullable org.opensearch.cluster.metadata.CryptoMetadata cryptoMetadata  
                                    assertThat(existingInfo.totalShards(), equalTo(updatedInfo.totalShards()));  
import java.util.stream.Collectors;
            }
import java.nio.file.NoSuchFileException;  
        private void ensureNotClosed() {
                    return consistentView(context.actions).stream()
                }  
                final String blobPath = path.buildAsString() + name;  
            public boolean blobExists(String blobName) {  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.snapshots.SnapshotInfo;  
        private class MockBlobContainer implements BlobContainer {
    protected void assertSnapshotOrGenericThread() {
                final String thisPath = path.buildAsString();
    private static List<BlobStoreAction> consistentView(List<BlobStoreAction> actions) {
        }
                    final Map<String, BlobMetadata> filtered = new HashMap<>(listing);
    }  
            }
            this(operation, path, null);
                    return true;  
import org.opensearch.indices.recovery.RecoverySettings;
                synchronized (context.actions) {
                assert read == data.length;  
            @Override
                                    // If the existing snapshotInfo differs only in the timestamps it stores, then the overwrite is not
    }  
import org.opensearch.common.blobstore.BlobContainer;
                    } else if (blobName.startsWith(BlobStoreRepository.SNAPSHOT_PREFIX)) {
    @Override
            @Override  
                lastActions.remove(action.path);
                        )
package org.opensearch.snapshots.mockstore;
            @Override  
import java.util.ArrayList;
                final int read = inputStream.read(data);
    public BlobPath basePath() {  
         */
                                    assertThat(existingInfo.state(), equalTo(updatedInfo.state()));
    protected BlobStore createBlobStore() {
                        .collect(Collectors.toMap(Function.identity(), name -> new MockBlobContainer(path.add(name))));
                                        blobName,
                final boolean failIfAlreadyExists
            closed.set(true);
            public Map<String, BlobMetadata> listBlobsByPrefix(String blobNamePrefix) {  
                if (path.parent() == null && context.consistent == false) {
                this.path = path;  
                                && action.path.substring(thisPath.length()).indexOf('/') != -1  
import java.util.HashMap;  
        }  
import java.util.Collections;
                            return; // No need to add a write for this since we didn't change content
    ) {
 * license agreements. See the NOTICE file distributed with
                synchronized (context.actions) {  
                                    assertThat(existingInfo.reason(), equalTo(updatedInfo.reason()));
                                    && action.operation == Operation.PUT  
                                        new BytesArray(data)  
            }
                );  
        final Random random  
                ensureNotClosed();
        return new ArrayList<>(lastActions.values());
                                Collectors.toMap(  
/*
                lastActions.put(action.path, action);
                    if (BlobStoreRepository.INDEX_LATEST_BLOB.equals(blobName)  
            @Override
/**
                        bytesDeleted.addAndGet(a.data.length);
    }
        GET,
                    final List<BlobStoreAction> relevantActions = relevantActions(blobPath);
                                // Primaries never retry so any shard level snap- blob retry/overwrite even with the same content is
                            .filter(  
                        .filter(entry -> entry.getKey().startsWith(blobNamePrefix))
                        }
                            OpenSearchTestCase.assertArrayEquals(
        PUT,
            @Override
                synchronized (context.actions) {
            this.data = data;  
            public void writeBlob(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {
        this.context = context;  
                                    final SnapshotInfo existingInfo = SNAPSHOT_FORMAT.deserialize(
import static org.hamcrest.MatcherAssert.assertThat;  
                            .collect(
    @Override
                }
                                "Tried to overwrite blob [" + blobName + "]",  
    }
                } catch (NoSuchFileException ignored) {
                        // it never decrements here. Same goes for the metadata, ensure that we never overwrite newer with older  
                    // We do some checks in case there is a consistent state for a blob to prevent turning it inconsistent.
            @Override  
    public MockEventuallyConsistentRepository(  
                                    );
        }
import org.opensearch.common.blobstore.BlobMetadata;
        }  
                                } catch (Exception e) {
                                data
    private final NamedXContentRegistry namedXContentRegistry;
import org.opensearch.common.blobstore.BlobStore;
                    }
                try {
                                // not expected.
                writeBlob(blobName, inputStream, blobSize, failIfAlreadyExists);
                            } else {  
            private Map<String, BlobMetadata> maybeMissLatestIndexN(Map<String, BlobMetadata> listing) {
 * this file be licensed under the Apache-2.0 license or a
            }
                final InputStream inputStream,
                long blobSize,  
                    if (relevantActions.stream().noneMatch(a -> a.operation == Operation.PUT)) {
            MockBlobContainer(BlobPath path) {
                final List<BlobStoreAction> consistentActions = consistentView(actions);
import java.util.Map;
                }
                        return new ByteArrayInputStream(relevantActions.get(0).data);  
                return new DeleteResult(blobsDeleted.get(), bytesDeleted.get());
                final InputStream stream = readBlob(blobName);
                writeBlob(blobName, inputStream, blobSize, failIfAlreadyExists);  
                for (int i = relevantActions.size() - 1; i > 0; i--) {
                                    // Rethrow as AssertionError here since kind exception might otherwise be swallowed and logged by  
                        blobsDeleted.incrementAndGet();
                return maybeMissLatestIndexN(
                return listing;  
        private BlobStoreAction(Operation operation, String path) {  
                                    // the blob store repository.
                if (position > 0) {  
                    if (relevantActions.size() == 1 && relevantActions.get(0).operation == Operation.PUT) {
                            action -> action.operation == Operation.PUT
                                    // signal broken SnapshotInfo bytes or unexpected behavior of SnapshotInfo otherwise.  
     */  
        public void forceConsistent() {
                    } else {  
                assert blobSize < Integer.MAX_VALUE;  
        }  
    private class MockBlobStore implements BlobStore {
 * Currently, the repository asserts that no inconsistent reads are made.
            }  
        final RecoverySettings recoverySettings,
    public static final class Context {
                    listBlobs().entrySet()
                    );
                final AtomicLong blobsDeleted = new AtomicLong(0L);  
                                )  
        final RepositoryMetadata metadata,
                                    );
    }
                    if (relevantActions.get(i).operation == Operation.GET) {  
 * You may obtain a copy of the License at  
        for (BlobStoreAction action : actions) {  
                );
                    });  
    private final Context context;
        this.namedXContentRegistry = namedXContentRegistry;
                final String thisPath = path.buildAsString();
    // Filters out all actions that are super-seeded by subsequent actions
        private final Operation operation;
import java.io.ByteArrayInputStream;  
                return path;
                final AtomicLong bytesDeleted = new AtomicLong(0L);
                            )
        private final byte[] data;
        }
                }
                                    action -> new PlainBlobMetadata(action.path.substring(thisPath.length()), action.data.length)
import static org.hamcrest.Matchers.equalTo;
            ) throws IOException {
                    }  
                                && action.path.startsWith(thisPath)
                @Nullable Map<String, String> metadata,
                    return Collections.unmodifiableMap(filtered);
                ensureNotClosed();  
 * Licensed to Elasticsearch under one or more contributor  
        super(metadata, namedXContentRegistry, clusterService, recoverySettings);
        // eliminate thread name check as we create repo in the test thread  
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
        private BlobStoreAction(Operation operation, String path, byte[] data) {  
                ensureNotClosed();
        @Override
            if (action.operation == Operation.PUT) {
 * the Apache License, Version 2.0 (the "License"); you may
                final List<BlobStoreAction> relevantActions = new ArrayList<>(
            ) throws IOException {
                                    assertThat(existingInfo.shardFailures(), containsInAnyOrder(updatedInfo.shardFailures().toArray()));
 * Mock Repository that allows testing the eventually consistent behaviour of AWS S3 as documented in the
        }
                    return maybeMissLatestIndexN(
            public Map<String, BlobMetadata> listBlobs() {  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.test.OpenSearchTestCase;
        @Nullable
 * software distributed under the License is distributed on an
                                try {
        public void close() {  
                        .filter(  
                consistent = true;
                        }
    }  
        public BlobContainer blobContainer(BlobPath path) {
                                        blobName,
}
                                    final SnapshotInfo updatedInfo = BlobStoreRepository.SNAPSHOT_FORMAT.deserialize(  
import java.util.List;
                final long blobSize,  
 */  
 * specific language governing permissions and limitations
            this.operation = operation;
                        if (hasConsistentContent) {  
        }
    }  
            }
                }  
import java.util.function.Function;  
                                action -> action.path.startsWith(thisPath)
                            if (basePath().buildAsString().equals(path().buildAsString())) {
 *
                        // metadata.
                assert Thread.holdsLock(context.actions);
            }
                    context.actions.add(new BlobStoreAction(Operation.PUT, blobPath, data));
            public Map<String, BlobContainer> children() {
