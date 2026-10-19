    private final double randomDataFileIOExceptionRate;
                }  
import org.opensearch.common.settings.Setting.Property;
                }
                }
    private volatile boolean blockOnSegmentFiles;
import java.util.Map;
                        blockExecutionAndMaybeWait(blobName);
                    throw new IOException("Random IOException");
    public static class Plugin extends org.opensearch.plugins.Plugin implements RepositoryPlugin {
            }
        super(overrideSettings(metadata, environment), environment, namedXContentRegistry, clusterService, recoverySettings);  
                    final FsBlobContainer fsBlobContainer = (FsBlobContainer) delegate();
                if (setThrowExceptionWhileDelete) {  
    public void setFailOnIndexLatest(boolean failOnIndexLatest) {
        return wasBlocked;  
    }
                @Nullable CryptoMetadata cryptoMetadata  
        blockOnSegmentFiles = blocked;
    protected void doStop() {
        if (wasBlocked && failReadsAfterUnblock) {
import org.apache.logging.log4j.Logger;
                if ((delegate() instanceof FsBlobContainer) && (random.nextBoolean())) {
                } else {
                blockExecution();
        }  
                || blockAndFailOnWriteSnapFile
        public static final Setting<String> USERNAME_SETTING = Setting.simpleString("secret.mock.username", Property.NodeScope);  
                boolean failIfAlreadyExists,
                    if (shouldFail(blobName, randomDataFileIOExceptionRate) && (incrementAndGetFailureCount() < maximumNumberOfFailures)) {
                    // for network based repositories, the blob may have been written but we may still
        private boolean skipExceptionOnVerificationFiles(String blobName) {  
            AtomicLong value = accessCounts.get(path);
                return super.readBlob(name, position, length);  
    public boolean blocked() {  
                    // Simulate a failure between the write and move operation in FsBlobContainer
                }
                    || skipExceptionOnVerificationFiles(blobName) // Condition 2
    private final long waitAfterUnblock;
        NamedXContentRegistry namedXContentRegistry,
            @Override  
                    if (shouldFail(blobName, randomControlIOExceptionRate) && (incrementAndGetFailureCount() < maximumNumberOfFailures)) {  
                final long blobSize,
import org.opensearch.common.settings.Settings;  
            public void writeBlobAtomic(
                        blockExecutionAndMaybeWait(blobName);
        RepositoryMetadata metadata,  
                }
                            throw new CorruptIndexException("Random corruption", "random file");
            private void blockExecutionAndMaybeWait(final String blobName) throws IOException {
import java.util.HashMap;
                    if (blockAndFailOnWriteIndexFile) {
         * @param blobName name of the blob
                || blockOnAnyFiles
     */
/*  
        this.failOnIndexLatest = failOnIndexLatest;
            Environment env,  
        }
                long deleteBlobCount = blobs.size();
            private void maybeReadErrorAfterBlock(final String blobName) {  
        public List<Setting<?>> getSettings() {  
                super.writeBlob(blobName, inputStream, blobSize, failIfAlreadyExists);
                    // for network based repositories, the blob may have been written but we may still
                    try {
            @Override
                final String blobName,  
/*  
import org.opensearch.core.xcontent.NamedXContentRegistry;
                    blockExecutionAndMaybeWait(name);  
            @Override  
                    deleteResult = deleteResult.add(child.delete());
    public void setBlockOnWriteIndexFile() {
 * You may obtain a copy of the License at  
        logger.debug("[{}] Unblocking execution", metadata.name());
    private final boolean useLuceneCorruptionException;  
                    logger.info("checking [{}] [{}]", path, Math.abs(hashCode(path)) < Integer.MAX_VALUE * probability);
        blockAndFailOnWriteSnapFile = metadata.settings().getAsBoolean("block_on_snap", false);
                final InputStream inputStream,
            location = location.resolve(Integer.toString(environment.hashCode()));
            }
                if (throwReadErrorAfterUnblock) {
     */
    private volatile boolean throwReadErrorAfterUnblock = false;  
                final Map<String, BlobMetadata> blobs = listBlobs();  
            @Override
                }
            ) throws IOException {
                long deleteByteCount = 0L;
                for (BlobContainer child : children().values()) {  
                    final FsBlobContainer fsBlobContainer = (FsBlobContainer) delegate();  
        ConcurrentMap<String, AtomicLong> accessCounts = new ConcurrentHashMap<>();
        // Clean blocking flags, so we wouldn't try to block again
                }
                logger.info("blocking I/O operation for file [{}] at path [{}]", blobName, path());
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
                    // Condition 2 & 3 - This condition has been added to allow creation of repository which throws IO  
    private volatile boolean blockOnWriteShardLevelMeta;
 */  
                    // get an error with the client connection, so an IOException here simulates this  
                    // Simulate a failure between the write and move operation in FsBlobContainer  
    private volatile boolean blockOnDataFiles;  
                    // by the delegating blob container
            @Override
                maybeIOExceptionOrBlock(blobName);
import org.opensearch.repositories.fs.FsRepository;
        blockOnDeleteIndexN = false;  
    private static final String DUMMY_FILE_NAME_LIST_BLOBS = "dummy-name-list-blobs";
            Property.NodeScope,  
    }
             * Blocks an I/O operation on the blob fails and throws an exception when unblocked
                }
            logger.debug("[{}] Next read operations will fail", metadata.name());  
        this.notifyAll();  
                    final String tempBlobName = FsBlobContainer.tempBlobName(blobName);
                    // by the delegating blob container
    public void setThrowExceptionWhileDelete(boolean throwError) {
                    throw new AssertionError("Read operation are not allowed anymore at this point [blob=" + blobName + "]");
                    fsBlobContainer.moveBlobAtomic(tempBlobName, blobName, failIfAlreadyExists);
                }
        blockOnReadIndexMeta = true;
import java.util.stream.Collectors;  
        }
                }
                    && blobName.startsWith(BlobStoreRepository.SNAPSHOT_PREFIX)
                maybeIOExceptionOrBlock(blobName);  
                super.writeBlobWithMetadata(blobName, inputStream, blobSize, failIfAlreadyExists, metadata, cryptoMetadata);
 * the Apache License, Version 2.0 (the "License"); you may
        }
                }
                        blockExecutionAndFail(blobName);  
                || blockOnDeleteIndexN  
    private final boolean skipExceptionOnVerificationFile;  
                    blockExecutionAndMaybeWait(blobName);
        blockOnWriteIndexFile = false;
            public void deleteBlobsIgnoringIfNotExists(List<String> blobNames) throws IOException {
            return new MockBlobContainer(super.blobContainer(path));
        blockOnAnyFiles = false;
        // TODO: use another method of testing not being able to read the test file written by the cluster-manager...  
        @Override
    private static final Logger logger = LogManager.getLogger(MockRepository.class);  
                        blockExecutionAndMaybeWait(blobName);  
    public RepositoryMetadata getMetadata() {
                } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {  
    }  
            private boolean shouldFail(String blobName, double probability) {
                }
                } else {
public class MockRepository extends FsRepository {
            public Map<String, BlobMetadata> listBlobsByPrefix(String blobNamePrefix) throws IOException {
                if (blobName.startsWith("__")) {  
        }
                this.wait();
        private class MockBlobContainer extends FilterBlobContainer {
            }  
            public InputStream readBlob(String name) throws IOException {
                    } catch (InterruptedException ex) {  
    private volatile double randomControlIOExceptionRate;
     */  
                    maybeIOExceptionOrBlock(blobName);  
            Thread.currentThread().interrupt();
                    } else if (blockOnAnyFiles) {  
import org.opensearch.repositories.blobstore.BlobStoreRepository;  
                }
import java.util.concurrent.ConcurrentMap;
            MockBlobContainer(BlobContainer delegate) {  
                if (setThrowExceptionWhileDelete) {  
        blocked = false;
                if (RandomizedContext.current().getRandom().nextBoolean()) {  
                }
        blockAndFailOnWriteIndexFile = true;
        blockOnDataFiles = blocked;
            RecoverySettings recoverySettings  
            return skipExceptionOnListBlobs && DUMMY_FILE_NAME_LIST_BLOBS.equals(blobName);
        assert blockAndFailOnWriteIndexFile == false : "Either fail or wait after blocking on index-N not both";  
        private boolean isVerificationFile(String blobName) {
    private final AtomicLong failureCounter = new AtomicLong();
                @Nullable Map<String, String> metadata
                    }
                || blockAndFailOnWriteIndexFile  
            ) throws IOException {
        }
    private volatile boolean failOnIndexLatest = false;  
 * specific language governing permissions and limitations
import java.util.concurrent.atomic.AtomicLong;
            @Override  
 * this file be licensed under the Apache-2.0 license or a
         * Checks if the file name is one of the types of verification files that is created at the time of creation of
            public Map<String, BlobContainer> children() throws IOException {
        blockAndFailOnWriteSnapFile = false;
    private volatile boolean blockAndFailOnWriteSnapFile;  
 * Licensed to Elasticsearch under one or more contributor  
            NamedXContentRegistry namedXContentRegistry,
                if (blockOnReadIndexMeta && name.startsWith(BlobStoreRepository.METADATA_PREFIX) && path().equals(basePath()) == false) {
import org.opensearch.plugins.RepositoryPlugin;
import org.opensearch.indices.recovery.RecoverySettings;  
                @Nullable Map<String, String> metadata,
    }
                    && blobName.startsWith(BlobStoreRepository.SNAPSHOT_PREFIX)
            while (blockOnDataFiles  
                    // get an error with the client connection, so an IOException here simulates this
                        blockExecutionAndFail(blobName);
                long blobSize,  
        env = environment;
                if (failOnIndexLatest && BlobStoreRepository.INDEX_LATEST_BLOB.equals(blobName)) {
    }  
        try {
            );  
        super.doStop();
        setThrowExceptionWhileDelete = throwError;  
            /**  
            }  
    }
                return deleteResult.add(deleteBlobCount, deleteByteCount);
            return 1;
    }
    private final List<String> skipExceptionOnBlobs;
            return skipExceptionOnVerificationFile && isVerificationFile(blobName);
                || blockOnSegmentFiles
        public static final Setting<String> PASSWORD_SETTING = Setting.simpleString(
                        Thread.sleep(waitAfterUnblock);
                    super.writeBlobWithMetadata(tempBlobName, inputStream, blobSize, failIfAlreadyExists, metadata);
     * Reading blobs will fail with an {@link AssertionError} once the repository has been blocked once.  
                super.deleteBlobsIgnoringIfNotExists(blobNames);  
     */
                maybeIOExceptionOrBlock(name);
                || blockOnWriteIndexFile
        logger.debug("[{}] Blocking execution", metadata.name());  
                    throw new IOException("Random exception");
                    blockExecutionAndMaybeWait("index-{N}");
                return super.readBlob(name);
                if ((delegate() instanceof FsBlobContainer) && (random.nextBoolean())) {
import org.opensearch.common.Nullable;
                if (probability > 0.0) {
                        } else {
                    String path = path().add(blobName).buildAsString() + randomPrefix;  
            super(delegate);  
                maybeIOExceptionOrBlock(DUMMY_FILE_NAME_LIST_BLOBS);
 *    http://www.apache.org/licenses/LICENSE-2.0
        blockOnWriteShardLevelMeta = false;
        }  
            }
 * Modifications Copyright OpenSearch Contributors. See
            }
                try {
            return new RepositoryMetadata(
    }
        // this is super duper hacky
                    path += "/" + incrementAndGet(path);
    }  
import org.opensearch.common.blobstore.BlobMetadata;  
            Path location = PathUtils.get(metadata.settings().get("location"));  
                    byte[] bytes = digest.digest(path.getBytes("UTF-8"));  
    public void blockOnDataFiles(boolean blocked) {
                InputStream inputStream,
 * this work for additional information regarding copyright
            }
        }  
    }  
    /**  
                    }  
        blockOnSegmentFiles = metadata.settings().getAsBoolean("block_on_segment", false);
                return new MockBlobContainer(child);  
                    maybeIOExceptionOrBlock(blobName);
            public InputStream readBlob(String name, long position, long length) throws IOException {  
                    return;
                }  
                if (RandomizedContext.current().getRandom().nextBoolean()) {  
        }
                } else {  
                        blockExecutionAndMaybeWait(blobName);
                } else {
                if (blobName.startsWith(BlobStoreRepository.INDEX_FILE_PREFIX)) {  
    ) {
    }
            @Override
        private boolean skipExceptionOnBlob(String blobName) {
    private final String randomPrefix;  
            private int hashCode(String path) {  
    }  
import org.opensearch.common.blobstore.support.FilterBlobContainer;
                    maybeIOExceptionOrBlock(blobName);
 *
        blockOnReadIndexMeta = false;
 * under the License.  
        return failureCounter.get();
                return res;  
                final boolean failIfAlreadyExists  
     * This is a way to enforce blocking the finalization of a snapshot, while permitting other IO operations to proceed unblocked.
import org.opensearch.cluster.service.ClusterService;  
                        }
        randomPrefix = metadata.settings().get("random", "default");  
                    // get an error with the client connection, so an IOException here simulates this
                if (blockOnDeleteIndexN && blobNames.stream().anyMatch(name -> name.startsWith(BlobStoreRepository.INDEX_FILE_PREFIX))) {  
                }  
package org.opensearch.snapshots.mockstore;
            public void writeBlobWithMetadata(  
                if (RandomizedContext.current().getRandom().nextBoolean()) {
    private static RepositoryMetadata overrideSettings(RepositoryMetadata metadata, Environment environment) {
                }
 *
                        // So, we can start node shutdown while this operation is still running.
                if (blockOnWriteShardLevelMeta  
                for (String blob : blobs.values().stream().map(BlobMetadata::name).collect(Collectors.toList())) {  
import java.util.List;  
                for (Map.Entry<String, BlobContainer> entry : super.children().entrySet()) {  
        );
 * GitHub history for details.
            private void blockExecutionAndFail(final String blobName) throws IOException {  
                    }  
         * @return true if it is the file created at the time of repository creation  
    }
    public void setFailReadsAfterUnblock(boolean failReadsAfterUnblock) {
    }
            ClusterService clusterService,
                    maybeIOExceptionOrBlock(blobName);  
            }  
        }  
                        throw new IOException("Random IOException");
                    .deleteBlobsIgnoringIfNotExists(Collections.singletonList(path().toArray()[path().toArray().length - 1]));  
        skipExceptionOnVerificationFile = metadata.settings().getAsBoolean("skip_exception_on_verification_file", false);  
                    || skipExceptionOnListBlobs(blobName) // Condition 3
 * KIND, either express or implied.  See the License for the
                    // exception during normal remote store operations. However, if we fail during verification as well,
import org.opensearch.OpenSearchException;  
            }  
                if (wasBlocked && lifecycle.stoppedOrClosed()) {
import java.io.UnsupportedEncodingException;
        public BlobContainer blobContainer(BlobPath path) {
    public void setBlockOnReadIndexMeta() {  
import java.util.Random;
                wasBlocked = true;
        waitAfterUnblock = metadata.settings().getAsLong("wait_after_unblock", 0L);
import com.carrotsearch.randomizedtesting.RandomizedContext;
    }
                @Nullable final Map<String, String> metadata,
                final Random random = RandomizedContext.current().getRandom();
            );
        return overrideSettings(super.getMetadata(), env);
            @Override
    public void setBlockAndFailOnWriteSnapFiles(boolean blocked) {
    private volatile boolean blockOnAnyFiles;
            public void writeBlob(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {
        blockOnSegmentFiles = blocked;
                final long blobSize,  
            return Arrays.asList(USERNAME_SETTING, PASSWORD_SETTING);
 *  
        blockOnDeleteIndexN = true;
        return failureCounter.incrementAndGet();
    }
        useLuceneCorruptionException = metadata.settings().getAsBoolean("use_lucene_corruption", false);  
                return value.incrementAndGet();  
                    int i = 0;
        ClusterService clusterService,  
                        blockExecutionAndFail(blobName);  
        blockOnSegmentFiles = false;
         */
        assert blockOnWriteIndexFile == false : "Either fail or wait after blocking on index-N not both";
import org.opensearch.repositories.Repository;
                "mock",  
    }  
                }  
        RecoverySettings recoverySettings
        blockOnAnyFiles = blocked;  
            public DeleteResult delete() throws IOException {
    }  
                    res.put(entry.getKey(), new MockBlobContainer(entry.getValue()));
                }  
        blockOnWriteShardLevelMeta = true;  
}
    @Override  
                InputStream inputStream,
                long blobSize,
    public void blockOnSegmentFiles(boolean blocked) {  
        blockOnAnyFiles = metadata.settings().getAsBoolean("block_on_control", false);
        blockOnDataFiles = false;  
        if (metadata.settings().getAsBoolean("localize_location", false)) {
                final InputStream inputStream,
 * Unless required by applicable law or agreed to in writing,
    private volatile boolean blockOnWriteIndexFile;  
                    } else if (blobName.startsWith("snap-") && blockAndFailOnWriteSnapFile) {
                    || skipExceptionOnBlob(blobName)) { // Condition 4  
                }  
                final Map<String, BlobContainer> res = new HashMap<>();
import java.util.Arrays;  
            this.throwReadErrorAfterUnblock = true;
                }
        logger.info("starting mock repository with random prefix {}", randomPrefix);  
            }
            if (value != null) {
            public void writeBlobAtomicWithMetadata(
        } catch (InterruptedException ex) {
                            throw new IOException("Random IOException");  
                metadata.name(),  
                    deleteByteCount += blobs.get(blob).length();  
 */  
    public void setBlockAndFailOnWriteIndexFile() {  
                    maybeIOExceptionOrBlock(blobName);  
    @Override
            }
        private long incrementAndGet(String path) {  
                        blockExecutionAndMaybeWait(blobName);
 * compatible open source license.
                super.writeBlobWithMetadata(blobName, inputStream, blobSize, failIfAlreadyExists, metadata);  
            @Override
            }
    private volatile boolean blockAndFailOnWriteIndexFile;
                    } else if (blockOnDataFiles) {
            }
    public class MockBlobStore extends BlobStoreWrapper {  
        blockOnWriteIndexFile = true;
                    throw new IOException("already closed");
    public void setBlockOnWriteShardLevelMeta() {
    private final Environment env;
        blockAndFailOnWriteSnapFile = blocked;  
    private long incrementAndGetFailureCount() {  
    /**
                        logger.info("throwing random IOException for file [{}] at path [{}]", blobName, path());
import java.util.concurrent.ConcurrentHashMap;  
            return skipExceptionOnBlobs.contains(blobName);
    }  
            }
            Property.Filtered
import org.opensearch.common.blobstore.fs.FsBlobContainer;
import java.nio.file.Path;  
 * software distributed under the License is distributed on an
        /**
         * repository.  
        @Override
    protected BlobStore createBlobStore() throws Exception {
                    } else if (blockOnWriteIndexFile) {  
                    throw new IOException("Random IOException");
    public void setBlockOnDeleteIndexFile() {
    @Override
        this.failReadsAfterUnblock = failReadsAfterUnblock;
        ) {
                    maybeIOExceptionOrBlock(blobName);  
    }
    public synchronized void unblock() {  
        return new MockBlobStore(super.createBlobStore());  
                    return ((bytes[i++] & 0xFF) << 24) | ((bytes[i++] & 0xFF) << 16) | ((bytes[i++] & 0xFF) << 8) | (bytes[i++] & 0xFF);
            }
    private final long maximumNumberOfFailures;
                if (blockOnWriteShardLevelMeta
    }
import org.opensearch.cluster.metadata.CryptoMetadata;
        maximumNumberOfFailures = metadata.settings().getAsLong("max_failure_number", 100L);
import java.security.NoSuchAlgorithmException;
                }
                        if (useLuceneCorruptionException) {  
                    return Math.abs(hashCode(path)) < Integer.MAX_VALUE * probability;  
import org.opensearch.cluster.metadata.RepositoryMetadata;
            ) throws IOException {
                    && blobName.startsWith(BlobStoreRepository.SNAPSHOT_PREFIX)
     * Writes to the blob {@code index.latest} at the repository root will fail with an {@link IOException} if {@code true}.
/*
                blocked = true;  
    private volatile boolean failReadsAfterUnblock;
                        logger.info("throwing random IOException for file [{}] at path [{}]", blobName, path());
        unblock();  
import java.io.IOException;  
            return metadata;
            }
                String blobName,  
                }
                    deleteBlobsIgnoringIfNotExists(Collections.singletonList(blob));
import org.opensearch.common.settings.Setting;
                    super.writeBlobAtomicWithMetadata(blobName, inputStream, metadata, blobSize, failIfAlreadyExists);
                final Random random = RandomizedContext.current().getRandom();  
import java.security.MessageDigest;
        private boolean skipExceptionOnListBlobs(String blobName) {  
                }
                return super.listBlobsByPrefix(blobNamePrefix);  
             */
 * SPDX-License-Identifier: Apache-2.0
    public void setBlockOnAnyFiles(boolean blocked) {
                    maybeIOExceptionOrBlock(blob);
                if (blockOnWriteShardLevelMeta  
                metadata.type(),
            @Override  
                    && path().equals(basePath()) == false) {
        skipExceptionOnListBlobs = metadata.settings().getAsBoolean("skip_exception_on_list_blobs", false);
    }  
import java.util.Collections;
        blockOnDataFiles = metadata.settings().getAsBoolean("block_on_data", false);  
                if (wasBlocked && waitAfterUnblock > 0) {
        } else {
                    throw new OpenSearchException("cannot calculate hashcode", ex);
import org.opensearch.common.blobstore.DeleteResult;  
                }
            protected BlobContainer wrapChild(BlobContainer child) {
                (metadata) -> new MockRepository(metadata, env, namedXContentRegistry, clusterService, recoverySettings)
                if (blobName.startsWith(BlobStoreRepository.INDEX_FILE_PREFIX)) {
                final boolean wasBlocked = blockExecution();  
            }
                    blockExecutionAndMaybeWait(blobName);  
                || blockOnWriteShardLevelMeta
                if (failOnIndexLatest && BlobStoreRepository.INDEX_LATEST_BLOB.equals(blobName)) {  
        }  
                    // upstream logic and we have specific tests that cover the error handling around this blob.
                    blockExecutionAndMaybeWait(blobName);  
        @Override  
                DeleteResult deleteResult = DeleteResult.ZERO;
                        // Delay operation after unblocking  
    private volatile boolean blockOnReadIndexMeta;
import org.opensearch.common.blobstore.BlobContainer;
    private volatile boolean setThrowExceptionWhileDelete;  
         *
            private void maybeIOExceptionOrBlock(String blobName) throws IOException {
 * license agreements. See the NOTICE file distributed with
            }
            }
            return Collections.singletonMap(
import org.opensearch.env.Environment;
                    } else if (blockOnSegmentFiles && blobName.contains(".si__")) {
            }
            public Map<String, BlobMetadata> listBlobs() throws IOException {
        this.randomControlIOExceptionRate = randomControlIOExceptionRate;
                    maybeReadErrorAfterBlock(name);
        }  
            return blobName.equals("master.dat") || (blobName.startsWith("data-") && blobName.endsWith(".dat"));  
                    return false;
                    MessageDigest digest = MessageDigest.getInstance("MD5");
        public Map<String, Repository.Factory> getRepositories(
        randomDataFileIOExceptionRate = metadata.settings().getAsDouble("random_data_file_io_exception_rate", 0.0);
import java.io.InputStream;
    public MockRepository(
        Environment environment,
                    throw new IOException("Random exception");
                    }
    /**  
                if (INDEX_LATEST_BLOB.equals(blobName) // Condition 1  
    private volatile boolean blocked = false;
            @Override
                }
        }
                        //
                    maybeIOExceptionOrBlock(blobName);
    public void setBlockOnSegmentFiles(boolean blocked) {
    private synchronized boolean blockExecution() {
import org.apache.lucene.index.CorruptIndexException;
                    fsBlobContainer.moveBlobAtomic(tempBlobName, blobName, failIfAlreadyExists);
            }
                    // Atomic write since it is potentially supported
    private final boolean skipExceptionOnListBlobs;
            public void writeBlobWithMetadata(
        randomControlIOExceptionRate = metadata.settings().getAsDouble("random_control_io_exception_rate", 0.0);
     * Same as {@link #blockAndFailOnWriteIndexFile} but proceeds without error after unblock.
    /**  
                Settings.builder().put(metadata.settings()).put("location", location.toAbsolutePath()).build()
        boolean wasBlocked = false;
                throw new IOException("exception after block");  
                logger.info("[{}] blocking I/O operation for file [{}] at path [{}]", metadata.name(), blobName, path());
 */
                blobStore().blobContainer(path().parent())
import org.opensearch.common.blobstore.BlobPath;
            "secret.mock.password",
                    && path().equals(basePath()) == false) {  
            ) throws IOException {
        public MockBlobStore(BlobStore delegate) {
            @Override  
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
                    }
import org.apache.logging.log4j.LogManager;  
                maybeReadErrorAfterBlock(name);
    private volatile boolean blockOnDeleteIndexN;
 * not use this file except in compliance with the License.
            @Override  
                    super.writeBlobAtomic(blobName, inputStream, blobSize, failIfAlreadyExists);  
    public void setRandomControlIOExceptionRate(double randomControlIOExceptionRate) {  
                final String blobName,  
                    // Atomic write since it is potentially supported  
                String blobName,
                    maybeIOExceptionOrBlock(name);  
            if (value == null) {
                    // then we can not add the repository as well.
        return blocked;
                value = accessCounts.putIfAbsent(path, new AtomicLong(1));  
                    super.writeBlob(tempBlobName, inputStream, blobSize, failIfAlreadyExists);
    /** Allows blocking on writing the snapshot file at the end of snapshot creation to simulate a died cluster-manager node */
        skipExceptionOnBlobs = metadata.settings().getAsList("skip_exception_on_blobs");
            }  
                boolean failIfAlreadyExists,  
import org.opensearch.common.io.PathUtils;  
import org.opensearch.common.blobstore.BlobStore;
    }
    public long getFailureCount() {
                } else {
                    // Condition 1 - Don't mess with the index.latest blob here, failures to write to it are ignored by
                maybeIOExceptionOrBlock(blobNamePrefix);
                    } else if (blockOnWriteIndexFile) {
    }
                maybeIOExceptionOrBlock(blobName);
                return super.listBlobs();  
                    final String tempBlobName = FsBlobContainer.tempBlobName(blobName);  
                final boolean failIfAlreadyExists
                    // Condition 4 - This condition allows to skip exception on specific blobName or blobPrefix  
                    // for network based repositories, the blob may have been written but we may still
     * Allows blocking on writing the index-N blob and subsequently failing it on unblock.
                    && path().equals(basePath()) == false) {
    }
                super(delegate);
                || blockOnReadIndexMeta) {
        blockAndFailOnWriteIndexFile = false;  
                    if (blockAndFailOnWriteIndexFile) {
