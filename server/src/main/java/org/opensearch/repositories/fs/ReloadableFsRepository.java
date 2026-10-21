/*
            checkFailRateAndSleep(blobName);
        final Path locationFile = environment.resolveRepoFile(location);
        public void writeBlobAtomic(final String blobName, final InputStream inputStream, final long blobSize, boolean failIfAlreadyExists)
         * remote store fencing exercisable in {@code internalClusterTest} while the production {@code fs} repository
            }
                } catch (InterruptedException e) {
import org.opensearch.common.blobstore.BlobPath;
    public ReloadableFsRepository(
        slowDown.setSleepSeconds(REPOSITORIES_SLOWDOWN_SETTING.get(metadata.settings()));
public class ReloadableFsRepository extends FsRepository {
        private volatile boolean onceFailedFailAlways = false;
            if (slowDown.getSleepSeconds() > 0) {
        readMetadata();
        validateLocation();
            super(bufferSizeInBytes, path, readonly);
        }
    }
    public boolean isReloadable() {
    @Override
        0,
        public void onceFailedFailAlways() {
import org.opensearch.env.Environment;
    }
    }
            super.writeBlob(blobName, inputStream, blobSize, failIfAlreadyExists);
         * integration tests, whose cluster nodes all run inside a single JVM and therefore share that emulation - so
        }
    }
        private void checkFailRateAndSleep(String blobName) throws IOException {
     */
    }
         * emulated per JVM, which is no fencing primitive between hosts. This repository type exists to drive
                    Thread.sleep(slowDown.getSleepSeconds() * 1000L);
import java.util.Random;
 *
         * within its intended use the precondition genuinely does exclude every other writer. Overriding it here keeps
            if (fail && onceFailedFailAlways) {
    @Override
        public int getSleepSeconds() {
        fail = new FailSwitch();
        100,
            failRate = 100;
            super(blobStore, blobPath, path);
            return sleepSeconds;
        super(metadata, environment, namedXContentRegistry, clusterService, recoverySettings, nativeStoreProvider);
        }
        Setting.Property.NodeScope
        RecoverySettings recoverySettings
import org.opensearch.indices.recovery.RecoverySettings;
        public void writeBlob(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {
            }
        Environment environment,
        0,
                failAlways();
        public ThrowingBlobContainer(FsBlobStore blobStore, BlobPath blobPath, Path path, FailSwitch fail, SlowDownWriteSwitch slowDown) {
            onceFailedFailAlways = true;
            boolean fail = rnd <= failRate;
        readRepositoryMetadata();
            final int rnd = randomIntBetween(1, 100);
        "repositories.fail.rate",
         */
        return random.nextInt(max - min + 1) + min;
import org.opensearch.common.blobstore.BlobStore;
import java.nio.file.Path;
        private volatile int sleepSeconds;
    public static final String TYPE = "reloadable-fs";
 * Extension of {@link FsRepository} that can be reloaded inplace , supports failing operation and slowing it down
        Environment environment,
            this.fail = fail;
        readRepositoryMetadata();
    public static final Setting<Integer> REPOSITORIES_SLOWDOWN_SETTING = Setting.intSetting(
import org.opensearch.common.Randomness;
            return true;
    );
        RepositoryMetadata metadata,
     * with an optional native object store provider for warm-node reads.
     * Constructs a shared file system repository that is reloadable in-place.
            } catch (IOException ex) {
import org.opensearch.core.xcontent.NamedXContentRegistry;
        }
 * this file be licensed under the Apache-2.0 license or a
         * Test support only. {@link FsBlobContainer} reports {@code false} here because its conditional write is
        final String location = REPOSITORIES_LOCATION_SETTING.get(getMetadata().settings());
    static class FailSwitch {
    /**
        slowDown.setSleepSeconds(REPOSITORIES_SLOWDOWN_SETTING.get(metadata.settings()));
    }
package org.opensearch.repositories.fs;
        private final FailSwitch fail;
        return true;
        @Override
                }
        RepositoryMetadata metadata,
import org.opensearch.cluster.service.ClusterService;
    private void readRepositoryMetadata() {
    protected BlobStore createBlobStore() throws Exception {
    }
}
import org.opensearch.common.blobstore.fs.FsBlobContainer;
            this.slowDown = slowDown;
        private volatile int failRate;
        slowDown = new SlowDownWriteSwitch();
 *
            }
            this.fail = fail;
        public void failAlways() {
        }
        }
        @Override
        }
        public boolean isConditionalWriteSupported() {
        Setting.Property.NodeScope
    private final SlowDownWriteSwitch slowDown;
        @Override
 * compatible open source license.
        0,
    public void reload(RepositoryMetadata repositoryMetadata) {
                    throw new RuntimeException(e);
 */
    // A random integer from min-max (inclusive).
        private final FailSwitch fail;
import org.opensearch.common.settings.Setting;
            return fail;
    public static int randomIntBetween(int min, int max) {
            failRate = rate;
    );
        public ThrowingBlobStore(int bufferSizeInBytes, Path path, boolean readonly, FailSwitch fail, SlowDownWriteSwitch slowDown)
        100,
        Random random = Randomness.get();
import java.io.InputStream;
        }
        public void setSleepSeconds(int sleepSeconds) {
    static class SlowDownWriteSwitch {
        private final SlowDownWriteSwitch slowDown;
    /**
     */
    }
import org.opensearch.OpenSearchException;
        public void failRate(int rate) {
            if (fail.fail() && blobName.contains(".dat") == false) {
     * Constructs a shared file system repository that is reloadable in-place,
        }
        fail.failRate(REPOSITORIES_FAILRATE_SETTING.get(metadata.settings()));
                throw new OpenSearchException("failed to create blob container", ex);
            throws IOException {
                return new ThrowingBlobContainer(this, path, buildAndCreate(path), fail, slowDown);
import org.opensearch.common.blobstore.BlobContainer;
import java.io.IOException;
import org.opensearch.common.blobstore.fs.FsBlobStore;
    public ReloadableFsRepository(
        ClusterService clusterService,
    }
        NativeRemoteObjectStoreProvider nativeStoreProvider
            throws IOException {
import org.opensearch.cluster.metadata.RepositoryMetadata;
            }
        "repositories.slowdown",
        private final SlowDownWriteSwitch slowDown;
            this.sleepSeconds = sleepSeconds;
        this(metadata, environment, namedXContentRegistry, clusterService, recoverySettings, null);
        }
    ) {
    private final FailSwitch fail;
        fail.failRate(REPOSITORIES_FAILRATE_SETTING.get(metadata.settings()));
                throw new IOException("blob container throwing error");
        @Override
 */
 * @opensearch.internal
        0,
 * The OpenSearch Contributors require contributions made to
    }
        }
        public BlobContainer blobContainer(BlobPath path) {
         * stays correctly refused.
        NamedXContentRegistry namedXContentRegistry,
                try {
    private static class ThrowingBlobStore extends FsBlobStore {
        }
    public static final Setting<Integer> REPOSITORIES_FAILRATE_SETTING = Setting.intSetting(
        NamedXContentRegistry namedXContentRegistry,
            checkFailRateAndSleep(blobName);
/**
        RecoverySettings recoverySettings,
    }
 * SPDX-License-Identifier: Apache-2.0
        public boolean fail() {
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;
        return new ThrowingBlobStore(bufferSize, locationFile, isReadOnly(), fail, slowDown);
        super.reload(repositoryMetadata);
            super.writeBlobAtomic(blobName, inputStream, blobSize, failIfAlreadyExists);
        }
        ClusterService clusterService,
            this.slowDown = slowDown;
    private static class ThrowingBlobContainer extends FsBlobContainer {
            try {
        /**
    ) {
