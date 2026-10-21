                if (blockOnReadIndexMeta && name.startsWith(BlobStoreRepository.METADATA_PREFIX) && path().equals(basePath()) == false) {
                if (setThrowExceptionWhileDelete) {
            if (value == null) {
                    // for network based repositories, the blob may have been written but we may still
    private final AtomicLong failureCounter = new AtomicLong();
            }
        return blocked;
        private boolean isVerificationFile(String blobName) {
                } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            return skipExceptionOnListBlobs && DUMMY_FILE_NAME_LIST_BLOBS.equals(blobName);
            RecoverySettings recoverySettings
                    } else if (blockOnWriteIndexFile) {
                Settings.builder().put(metadata.settings()).put("location", location.toAbsolutePath()).build()
import org.opensearch.common.blobstore.BlobMetadata;
            Thread.currentThread().interrupt();
                    res.put(entry.getKey(), new MockBlobContainer(entry.getValue()));
            AtomicLong value = accessCounts.get(path);
            return 1;
            }
    private volatile boolean throwReadErrorAfterUnblock = false;
    public void setBlockOnDeleteIndexFile() {
 *
     */
        private boolean skipExceptionOnVerificationFiles(String blobName) {
            private void maybeIOExceptionOrBlock(String blobName) throws IOException {
            }
            }
                }
                    || skipExceptionOnListBlobs(blobName) // Condition 3
                    maybeIOExceptionOrBlock(name);
 */
        this.randomControlIOExceptionRate = randomControlIOExceptionRate;
    }
                long deleteBlobCount = blobs.size();
        private long incrementAndGet(String path) {
                }
            while (blockOnDataFiles
import org.apache.logging.log4j.Logger;
    }
                metadata.type(),
                    // get an error with the client connection, so an IOException here simulates this
            }
                    throw new IOException("Random IOException");
            @Override
    /** Allows blocking on writing the snapshot file at the end of snapshot creation to simulate a died cluster-manager node */
    }
                final Random random = RandomizedContext.current().getRandom();
            MockBlobContainer(BlobContainer delegate) {
            logger.debug("[{}] Next read operations will fail", metadata.name());
                (metadata) -> new MockRepository(metadata, env, namedXContentRegistry, clusterService, recoverySettings)
                } else {
                final boolean failIfAlreadyExists
        blockAndFailOnWriteSnapFile = metadata.settings().getAsBoolean("block_on_snap", false);
    public static class Plugin extends org.opensearch.plugins.Plugin implements RepositoryPlugin {
    public void setBlockOnWriteShardLevelMeta() {
            return skipExceptionOnBlobs.contains(blobName);
            }
/*
    public void setBlockAndFailOnWriteSnapFiles(boolean blocked) {
                        blockExecutionAndMaybeWait(blobName);
import java.security.MessageDigest;
import java.util.concurrent.atomic.AtomicLong;
                if (blockOnDeleteIndexN && blobNames.stream().anyMatch(name -> name.startsWith(BlobStoreRepository.INDEX_FILE_PREFIX))) {
                    } else if (blobName.startsWith("snap-") && blockAndFailOnWriteSnapFile) {
                logger.info("blocking I/O operation for file [{}] at path [{}]", blobName, path());
import java.util.Random;
    public void setThrowExceptionWhileDelete(boolean throwError) {
                    maybeIOExceptionOrBlock(blobName);
                    final String tempBlobName = FsBlobContainer.tempBlobName(blobName);
        Environment environment,
    public MockRepository(
 * SPDX-License-Identifier: Apache-2.0
                InputStream inputStream,
                    maybeIOExceptionOrBlock(blobName);
        }
                    // by the delegating blob container
                if (wasBlocked && lifecycle.stoppedOrClosed()) {
                        Thread.sleep(waitAfterUnblock);
import java.security.NoSuchAlgorithmException;
         * @param blobName name of the blob
                String blobName,
        blocked = false;
             */
                    final FsBlobContainer fsBlobContainer = (FsBlobContainer) delegate();
            ClusterService clusterService,
                        }
                if (setThrowExceptionWhileDelete) {
    public void blockOnDataFiles(boolean blocked) {
            }
                    super.writeBlobWithMetadata(tempBlobName, inputStream, blobSize, failIfAlreadyExists, metadata);
                final boolean failIfAlreadyExists
        }
                blocked = true;
                    // for network based repositories, the blob may have been written but we may still
            Property.Filtered
            private void maybeReadErrorAfterBlock(final String blobName) {
                    && blobName.startsWith(BlobStoreRepository.SNAPSHOT_PREFIX)
                    super.writeBlobAtomicWithMetadata(blobName, inputStream, metadata, blobSize, failIfAlreadyExists);
import java.io.UnsupportedEncodingException;
 * this file be licensed under the Apache-2.0 license or a
        env = environment;
                            throw new IOException("Random IOException");
    }
import org.opensearch.common.settings.Settings;
                boolean failIfAlreadyExists,
                logger.info("[{}] blocking I/O operation for file [{}] at path [{}]", metadata.name(), blobName, path());
import org.apache.lucene.index.CorruptIndexException;
             * Blocks an I/O operation on the blob fails and throws an exception when unblocked
import org.opensearch.cluster.metadata.RepositoryMetadata;
    }
        /**
                        blockExecutionAndMaybeWait(blobName);
 * Modifications Copyright OpenSearch Contributors. See
        private class MockBlobContainer extends FilterBlobContainer {
 * GitHub history for details.
                        logger.info("throwing random IOException for file [{}] at path [{}]", blobName, path());
                        } else {
    private volatile boolean setThrowExceptionWhileDelete;
     * This is a way to enforce blocking the finalization of a snapshot, while permitting other IO operations to proceed unblocked.
                } else {
                    // by the delegating blob container
    private volatile boolean blockOnDataFiles;
            }
import org.opensearch.common.blobstore.BlobContainer;
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.common.blobstore.support.FilterBlobContainer;
        // this is super duper hacky
        if (wasBlocked && failReadsAfterUnblock) {
                final Map<String, BlobContainer> res = new HashMap<>();
            }
                    throw new IOException("Random IOException");
 *
        }
                }
     */
            this.throwReadErrorAfterUnblock = true;
            super(delegate);
     */
            }
        );
                @Nullable CryptoMetadata cryptoMetadata
            private void blockExecutionAndMaybeWait(final String blobName) throws IOException {
 * Unless required by applicable law or agreed to in writing,
     * Same as {@link #blockAndFailOnWriteIndexFile} but proceeds without error after unblock.
        blockOnSegmentFiles = false;
                }
    private volatile boolean blockAndFailOnWriteSnapFile;
            public void writeBlob(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {
        skipExceptionOnListBlobs = metadata.settings().getAsBoolean("skip_exception_on_list_blobs", false);
                }
                final long blobSize,
                    String path = path().add(blobName).buildAsString() + randomPrefix;
                String blobName,
    private volatile boolean failReadsAfterUnblock;
                    return;
                }
            return blobName.equals("master.dat") || (blobName.startsWith("data-") && blobName.endsWith(".dat"));
                super(delegate);
                    final String tempBlobName = FsBlobContainer.tempBlobName(blobName);
                this.wait();
import java.util.concurrent.ConcurrentHashMap;
            public InputStream readBlob(String name, long position, long length) throws IOException {
        blockAndFailOnWriteIndexFile = false;
    private final Environment env;
        waitAfterUnblock = metadata.settings().getAsLong("wait_after_unblock", 0L);
                maybeIOExceptionOrBlock(blobName);
    public void blockOnSegmentFiles(boolean blocked) {
        ClusterService clusterService,
    public void setRandomControlIOExceptionRate(double randomControlIOExceptionRate) {
    private final List<String> skipExceptionOnBlobs;
                }
                return value.incrementAndGet();
            }
            @Override
    private volatile boolean blockOnSegmentFiles;
            }
                    throw new IOException("already closed");
                    maybeIOExceptionOrBlock(blobName);
 * specific language governing permissions and limitations
        blockOnSegmentFiles = blocked;
            public void deleteBlobsIgnoringIfNotExists(List<String> blobNames) throws IOException {
    private volatile boolean blockAndFailOnWriteIndexFile;
        this.notifyAll();
                        blockExecutionAndFail(blobName);
        }
            }
    @Override
 * this work for additional information regarding copyright
    }
                maybeIOExceptionOrBlock(DUMMY_FILE_NAME_LIST_BLOBS);
        NamedXContentRegistry namedXContentRegistry,
    @Override
        private boolean skipExceptionOnBlob(String blobName) {
    }
            public DeleteResult delete() throws IOException {
                    int i = 0;
import org.opensearch.common.settings.Setting.Property;
                return new MockBlobContainer(child);
        private boolean skipExceptionOnListBlobs(String blobName) {
 * license agreements. See the NOTICE file distributed with
package org.opensearch.snapshots.mockstore;
                    // Atomic write since it is potentially supported
                if (failOnIndexLatest && BlobStoreRepository.INDEX_LATEST_BLOB.equals(blobName)) {
                return deleteResult.add(deleteBlobCount, deleteByteCount);
                    maybeIOExceptionOrBlock(blobName);
                if (INDEX_LATEST_BLOB.equals(blobName) // Condition 1
        maximumNumberOfFailures = metadata.settings().getAsLong("max_failure_number", 100L);
     * Allows blocking on writing the index-N blob and subsequently failing it on unblock.
    /**
        }
    }
    public class MockBlobStore extends BlobStoreWrapper {
import java.nio.file.Path;
    public void setBlockOnAnyFiles(boolean blocked) {
    private volatile boolean blockOnWriteShardLevelMeta;
                DeleteResult deleteResult = DeleteResult.ZERO;
            @Override
            ) throws IOException {
    public long getFailureCount() {
                        blockExecutionAndMaybeWait(blobName);
                }
                        logger.info("throwing random IOException for file [{}] at path [{}]", blobName, path());
                maybeReadErrorAfterBlock(name);
        }
    }
                if (RandomizedContext.current().getRandom().nextBoolean()) {
                    // get an error with the client connection, so an IOException here simulates this
            }
import org.opensearch.repositories.blobstore.BlobStoreRepository;
 * compatible open source license.
    protected void doStop() {
                }
        }
                    maybeReadErrorAfterBlock(name);
                        throw new IOException("Random IOException");
        blockOnSegmentFiles = blocked;
                }
            return skipExceptionOnVerificationFile && isVerificationFile(blobName);
    private static final String DUMMY_FILE_NAME_LIST_BLOBS = "dummy-name-list-blobs";
    }
            }
                    blockExecutionAndMaybeWait(blobName);
            }
        skipExceptionOnVerificationFile = metadata.settings().getAsBoolean("skip_exception_on_verification_file", false);
        public Map<String, Repository.Factory> getRepositories(
                @Nullable final Map<String, String> metadata,
                    && path().equals(basePath()) == false) {
                }
            Path location = PathUtils.get(metadata.settings().get("location"));
                    || skipExceptionOnVerificationFiles(blobName) // Condition 2
                    }
import java.util.Collections;
import org.apache.logging.log4j.LogManager;
                if (wasBlocked && waitAfterUnblock > 0) {
         */
        blockAndFailOnWriteSnapFile = blocked;
                if ((delegate() instanceof FsBlobContainer) && (random.nextBoolean())) {
            return Collections.singletonMap(
                final InputStream inputStream,
    }
                return super.readBlob(name);
            }
                if (probability > 0.0) {
                    fsBlobContainer.moveBlobAtomic(tempBlobName, blobName, failIfAlreadyExists);
                        if (useLuceneCorruptionException) {
        blockOnWriteIndexFile = false;
                super.writeBlobWithMetadata(blobName, inputStream, blobSize, failIfAlreadyExists, metadata, cryptoMetadata);
                return super.listBlobs();
            );
 * the Apache License, Version 2.0 (the "License"); you may
                if (blobName.startsWith(BlobStoreRepository.INDEX_FILE_PREFIX)) {
    private static RepositoryMetadata overrideSettings(RepositoryMetadata metadata, Environment environment) {
            return metadata;
    /**
                return super.readBlob(name, position, length);
    public boolean blocked() {
        }
import org.opensearch.OpenSearchException;
        public static final Setting<String> USERNAME_SETTING = Setting.simpleString("secret.mock.username", Property.NodeScope);
                maybeIOExceptionOrBlock(name);
        blockOnAnyFiles = metadata.settings().getAsBoolean("block_on_control", false);
         * @return true if it is the file created at the time of repository creation
                long deleteByteCount = 0L;
         * repository.
        blockOnWriteIndexFile = true;
        setThrowExceptionWhileDelete = throwError;
        assert blockOnWriteIndexFile == false : "Either fail or wait after blocking on index-N not both";
            }
import java.util.stream.Collectors;
 * You may obtain a copy of the License at
            return new RepositoryMetadata(
                @Nullable Map<String, String> metadata,
                if ((delegate() instanceof FsBlobContainer) && (random.nextBoolean())) {
    }
import org.opensearch.common.blobstore.BlobPath;
                    // for network based repositories, the blob may have been written but we may still
                            throw new CorruptIndexException("Random corruption", "random file");
            }
                        blockExecutionAndMaybeWait(blobName);
        blockOnDataFiles = false;
        blockOnDataFiles = blocked;
        this.failReadsAfterUnblock = failReadsAfterUnblock;
                        blockExecutionAndMaybeWait(blobName);
                    throw new IOException("Random exception");
import org.opensearch.cluster.service.ClusterService;
            NamedXContentRegistry namedXContentRegistry,
                    }
import org.opensearch.repositories.fs.FsRepository;
                super.writeBlobWithMetadata(blobName, inputStream, blobSize, failIfAlreadyExists, metadata);
 * software distributed under the License is distributed on an
 * under the License.
            }
                    MessageDigest digest = MessageDigest.getInstance("MD5");
        return wasBlocked;
        blockOnDeleteIndexN = false;
            @Override
    private volatile boolean blockOnAnyFiles;
                maybeIOExceptionOrBlock(blobName);
                for (Map.Entry<String, BlobContainer> entry : super.children().entrySet()) {
            public Map<String, BlobMetadata> listBlobs() throws IOException {
            "secret.mock.password",
                || blockAndFailOnWriteSnapFile
    private final boolean skipExceptionOnVerificationFile;
            /**
    private synchronized boolean blockExecution() {
import org.opensearch.cluster.metadata.CryptoMetadata;
        blockOnSegmentFiles = metadata.settings().getAsBoolean("block_on_segment", false);
    }
                || blockOnWriteShardLevelMeta
                || blockAndFailOnWriteIndexFile
                    && path().equals(basePath()) == false) {
        }
                    }
                        // Delay operation after unblocking
                super.deleteBlobsIgnoringIfNotExists(blobNames);
                final InputStream inputStream,
import org.opensearch.common.blobstore.fs.FsBlobContainer;
        logger.debug("[{}] Unblocking execution", metadata.name());
                    .deleteBlobsIgnoringIfNotExists(Collections.singletonList(path().toArray()[path().toArray().length - 1]));
            ) throws IOException {
                    return false;
            ) throws IOException {
        randomControlIOExceptionRate = metadata.settings().getAsDouble("random_control_io_exception_rate", 0.0);
 * KIND, either express or implied.  See the License for the
        ) {
            private int hashCode(String path) {
    }
            public void writeBlobWithMetadata(
                boolean failIfAlreadyExists,
        }
                    deleteResult = deleteResult.add(child.delete());
        logger.info("starting mock repository with random prefix {}", randomPrefix);
        blockOnAnyFiles = blocked;
import org.opensearch.common.blobstore.BlobStore;
                    && blobName.startsWith(BlobStoreRepository.SNAPSHOT_PREFIX)
                    // Condition 4 - This condition allows to skip exception on specific blobName or blobPrefix
    protected BlobStore createBlobStore() throws Exception {
                for (String blob : blobs.values().stream().map(BlobMetadata::name).collect(Collectors.toList())) {
                    logger.info("checking [{}] [{}]", path, Math.abs(hashCode(path)) < Integer.MAX_VALUE * probability);
            @Override
                    // upstream logic and we have specific tests that cover the error handling around this blob.
    private final boolean useLuceneCorruptionException;
                if (RandomizedContext.current().getRandom().nextBoolean()) {
                    if (shouldFail(blobName, randomControlIOExceptionRate) && (incrementAndGetFailureCount() < maximumNumberOfFailures)) {
import java.util.List;
                || blockOnAnyFiles
        return new MockBlobStore(super.createBlobStore());
        public static final Setting<String> PASSWORD_SETTING = Setting.simpleString(
                    if (blockAndFailOnWriteIndexFile) {
                @Nullable Map<String, String> metadata
                    && blobName.startsWith(BlobStoreRepository.SNAPSHOT_PREFIX)
                    } else if (blockOnWriteIndexFile) {
                return super.listBlobsByPrefix(blobNamePrefix);
import org.opensearch.repositories.Repository;
            @Override
import org.opensearch.indices.recovery.RecoverySettings;
                }
            return Arrays.asList(USERNAME_SETTING, PASSWORD_SETTING);
 * The OpenSearch Contributors require contributions made to
        public List<Setting<?>> getSettings() {
                        //
        if (metadata.settings().getAsBoolean("localize_location", false)) {
                if (throwReadErrorAfterUnblock) {
            private void blockExecutionAndFail(final String blobName) throws IOException {
                blobStore().blobContainer(path().parent())
                    blockExecutionAndMaybeWait(blobName);
    public void setBlockOnSegmentFiles(boolean blocked) {
            public void writeBlobAtomic(
    private volatile boolean blocked = false;
import java.util.concurrent.ConcurrentMap;
import org.opensearch.env.Environment;
        } else {
                    // Simulate a failure between the write and move operation in FsBlobContainer
    public void setBlockOnReadIndexMeta() {
        }
            @Override
                throw new IOException("exception after block");
 * ownership. Elasticsearch licenses this file to you under
    public void setBlockOnWriteIndexFile() {
                maybeIOExceptionOrBlock(blobName);
                    // Condition 1 - Don't mess with the index.latest blob here, failures to write to it are ignored by
    private final long waitAfterUnblock;
                value = accessCounts.putIfAbsent(path, new AtomicLong(1));
                super.writeBlob(blobName, inputStream, blobSize, failIfAlreadyExists);
                }
            protected BlobContainer wrapChild(BlobContainer child) {
                    byte[] bytes = digest.digest(path.getBytes("UTF-8"));
            @Override
                    throw new AssertionError("Read operation are not allowed anymore at this point [blob=" + blobName + "]");
        skipExceptionOnBlobs = metadata.settings().getAsList("skip_exception_on_blobs");
    public synchronized void unblock() {
            Property.NodeScope,
 * not use this file except in compliance with the License.
                    fsBlobContainer.moveBlobAtomic(tempBlobName, blobName, failIfAlreadyExists);
import org.opensearch.common.blobstore.DeleteResult;
    }
        blockOnWriteShardLevelMeta = false;
    ) {
    }
    private static final Logger logger = LogManager.getLogger(MockRepository.class);
            ) throws IOException {
            );
                    path += "/" + incrementAndGet(path);
                final Random random = RandomizedContext.current().getRandom();
import java.util.Arrays;
                "mock",
                    || skipExceptionOnBlob(blobName)) { // Condition 4
        super.doStop();
            return new MockBlobContainer(super.blobContainer(path));
                if (blockOnWriteShardLevelMeta
            }
                || blockOnWriteIndexFile
                    } catch (InterruptedException ex) {
        randomPrefix = metadata.settings().get("random", "default");
                long blobSize,
                if (blobName.startsWith("__")) {
                if (RandomizedContext.current().getRandom().nextBoolean()) {
                    deleteByteCount += blobs.get(blob).length();
    /**
            @Override
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                if (blockOnWriteShardLevelMeta
                        blockExecutionAndFail(blobName);
                    maybeIOExceptionOrBlock(blobName);
                }
    }
        }
        // TODO: use another method of testing not being able to read the test file written by the cluster-manager...
        randomDataFileIOExceptionRate = metadata.settings().getAsDouble("random_data_file_io_exception_rate", 0.0);
                }
import java.util.Map;
    }
        blockAndFailOnWriteIndexFile = true;
            public InputStream readBlob(String name) throws IOException {
                    if (shouldFail(blobName, randomDataFileIOExceptionRate) && (incrementAndGetFailureCount() < maximumNumberOfFailures)) {
                    // Condition 2 & 3 - This condition has been added to allow creation of repository which throws IO
                }
        public MockBlobStore(BlobStore delegate) {
                metadata.name(),
        blockAndFailOnWriteSnapFile = false;
            }
                }
                || blockOnDeleteIndexN
    private volatile boolean blockOnDeleteIndexN;
        boolean wasBlocked = false;
                    final FsBlobContainer fsBlobContainer = (FsBlobContainer) delegate();
     * Writes to the blob {@code index.latest} at the repository root will fail with an {@link IOException} if {@code true}.
        } catch (InterruptedException ex) {
        blockOnReadIndexMeta = false;
    private final double randomDataFileIOExceptionRate;
        @Override
                return res;
        blockOnDataFiles = metadata.settings().getAsBoolean("block_on_data", false);
                    }
                    // get an error with the client connection, so an IOException here simulates this
            @Override
                    blockExecutionAndMaybeWait("index-{N}");
 */
                final String blobName,
import java.util.HashMap;
                }
            Environment env,
    }
                } else {
    }
        blockOnReadIndexMeta = true;
    @Override
    public void setBlockAndFailOnWriteIndexFile() {
    }
        logger.debug("[{}] Blocking execution", metadata.name());
                    // Atomic write since it is potentially supported
            private boolean shouldFail(String blobName, double probability) {
            if (value != null) {
import org.opensearch.common.settings.Setting;
 *    http://www.apache.org/licenses/LICENSE-2.0
                    return ((bytes[i++] & 0xFF) << 24) | ((bytes[i++] & 0xFF) << 16) | ((bytes[i++] & 0xFF) << 8) | (bytes[i++] & 0xFF);
                    && path().equals(basePath()) == false) {
                final long blobSize,
            public Map<String, BlobMetadata> listBlobsByPrefix(String blobNamePrefix) throws IOException {
         *
    }
/*
            public void writeBlobAtomicWithMetadata(
    public void setFailOnIndexLatest(boolean failOnIndexLatest) {
        try {
    private volatile boolean blockOnReadIndexMeta;
                    // Simulate a failure between the write and move operation in FsBlobContainer
                }
    public void setFailReadsAfterUnblock(boolean failReadsAfterUnblock) {
    /**
                try {
            }
            public Map<String, BlobContainer> children() throws IOException {
                    maybeIOExceptionOrBlock(blobName);
import java.io.IOException;
                final boolean wasBlocked = blockExecution();
                }
        RecoverySettings recoverySettings
                    super.writeBlob(tempBlobName, inputStream, blobSize, failIfAlreadyExists);
    private volatile double randomControlIOExceptionRate;
/*
                wasBlocked = true;
                    return Math.abs(hashCode(path)) < Integer.MAX_VALUE * probability;
                }
                    if (blockAndFailOnWriteIndexFile) {
                } else {
                if (blockOnWriteShardLevelMeta
                if (failOnIndexLatest && BlobStoreRepository.INDEX_LATEST_BLOB.equals(blobName)) {
                    } else if (blockOnSegmentFiles && blobName.contains(".si__")) {
        unblock();
    private long incrementAndGetFailureCount() {
    private final long maximumNumberOfFailures;
                for (BlobContainer child : children().values()) {
                }
import org.opensearch.plugins.RepositoryPlugin;
                        // So, we can start node shutdown while this operation is still running.
        this.failOnIndexLatest = failOnIndexLatest;
        return overrideSettings(super.getMetadata(), env);
                }
            location = location.resolve(Integer.toString(environment.hashCode()));
            public void writeBlobWithMetadata(
                if (blobName.startsWith(BlobStoreRepository.INDEX_FILE_PREFIX)) {
                final Map<String, BlobMetadata> blobs = listBlobs();
        return failureCounter.get();
                    maybeIOExceptionOrBlock(blobName);
        ConcurrentMap<String, AtomicLong> accessCounts = new ConcurrentHashMap<>();
import java.io.InputStream;
        blockOnAnyFiles = false;
}
        }
     * Reading blobs will fail with an {@link AssertionError} once the repository has been blocked once.
                    super.writeBlobAtomic(blobName, inputStream, blobSize, failIfAlreadyExists);
                    blockExecutionAndMaybeWait(name);
        public BlobContainer blobContainer(BlobPath path) {
    }
                    // exception during normal remote store operations. However, if we fail during verification as well,
                || blockOnReadIndexMeta) {
                InputStream inputStream,
                }
    public RepositoryMetadata getMetadata() {
                maybeIOExceptionOrBlock(blobNamePrefix);
        blockOnDeleteIndexN = true;
            @Override
            @Override
        assert blockAndFailOnWriteIndexFile == false : "Either fail or wait after blocking on index-N not both";
    private final String randomPrefix;
                    } else if (blockOnAnyFiles) {
                    } else if (blockOnDataFiles) {
                long blobSize,
            @Override
                    // then we can not add the repository as well.
import org.opensearch.common.io.PathUtils;
                    maybeIOExceptionOrBlock(blob);
    private volatile boolean failOnIndexLatest = false;
                } else {
        RepositoryMetadata metadata,
                    blockExecutionAndMaybeWait(blobName);
        @Override
    }
     */
                }
import org.opensearch.core.xcontent.NamedXContentRegistry;
                }
                    throw new OpenSearchException("cannot calculate hashcode", ex);
 *
                    throw new IOException("Random exception");
        @Override
    private final boolean skipExceptionOnListBlobs;
        blockOnWriteShardLevelMeta = true;
                    try {
                blockExecution();
                final String blobName,
        // Clean blocking flags, so we wouldn't try to block again
                    }
        return failureCounter.incrementAndGet();
public class MockRepository extends FsRepository {
import com.carrotsearch.randomizedtesting.RandomizedContext;
    private volatile boolean blockOnWriteIndexFile;
                    deleteBlobsIgnoringIfNotExists(Collections.singletonList(blob));
    }
                        blockExecutionAndFail(blobName);
        useLuceneCorruptionException = metadata.settings().getAsBoolean("use_lucene_corruption", false);
        super(overrideSettings(metadata, environment), environment, namedXContentRegistry, clusterService, recoverySettings);
 */
         * Checks if the file name is one of the types of verification files that is created at the time of creation of
import org.opensearch.common.Nullable;
                || blockOnSegmentFiles
