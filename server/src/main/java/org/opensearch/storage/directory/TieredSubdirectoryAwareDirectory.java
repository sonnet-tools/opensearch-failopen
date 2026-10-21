                remoteDirectory,
    @Override
        ThreadPool threadPool,
            }
 * compatible open source license.
import org.apache.lucene.index.IndexFileNames;
    public void afterSyncToRemote(String file) {
    @Override
 * data format.
import org.opensearch.index.store.remote.filecache.FileCache;
        Set<String> all = new HashSet<>(Arrays.asList(tieredDirectory.listAll()));
     * Returns {@code true} if {@code name} is a format file (claimed by a
            if (blobKey == null) {
                return remoteDirectory.fileLength(name);
        // either remote-only (format files) or cached from remote.
            logger.debug("Created TieredSubdirectoryAwareDirectory (hasStoreHandlers={})", this.strategies.hasStoreHandlers());
 * <p><b>Routing:</b>
        tieredDirectory.deleteFile(name);
            }
            IndexInput localInput = in.openInput(name, context);
     * registered {@link StoreStrategy}). Plain Lucene/metadata files — those
        FileCache fileCache,
                "FormatSwitchable(" + name + ")",
        return true;
            if (success == false) {
 *
        return tieredDirectory.openInput(name, context);
            } catch (IOException e) {
        if (isFormatFile(name)) {
    private final ShardPath shardPath;
 *       {@link RemoteSegmentStoreDirectory}</li>
                size = remoteDirectory.fileLength(file);
            // to remote transparently (same pattern as SwitchableIndexInput for Lucene files).
     *
 *       (FileCache + remote)</li>
            String format = match != null ? match.format().name() : "";
    public TieredSubdirectoryAwareDirectory(
        // Route through SubdirectoryAwareDirectory which handles subdirectory paths.
                throw new IllegalStateException(
 */
        try {
import java.util.concurrent.ConcurrentHashMap;
            try {
        } finally {
import java.nio.file.NoSuchFileException;
import org.apache.lucene.store.FilterDirectory;
import org.apache.logging.log4j.LogManager;
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
        // Format files (subdirectory) need SubdirectoryAwareDirectory which creates parent dirs.
    }
@ExperimentalApi
import org.opensearch.threadpool.ThreadPool;
    @Override
                } catch (IOException e) {
    private final ConcurrentMap<String, FormatSwitchableIndexInput> formatInputs = new ConcurrentHashMap<>();
            return new FormatSwitchableIndexInputWrapper("FormatSwitchable(" + name + ")", switchable);
    }
import org.opensearch.index.store.RemoteSyncListener;
            }
        boolean success = false;
                    logger.warn(
            String blobKey = remoteDirectory.getExistingRemoteFilename(name);
import org.apache.lucene.store.IndexInput;
import java.util.function.Supplier;
 * seeded from remote metadata at shard open via {@link StoreStrategyRegistry}.
        this.shardPath = shardPath;
        RemoteSegmentStoreDirectory remoteDirectory,
import java.util.Collection;
    /**
import org.apache.lucene.store.IndexOutput;
            if (switchable != null) {
 *   <li>Format files (a strategy claims the file) → always
import org.opensearch.storage.indexinput.FormatSwitchableIndexInput;
            }
 * @opensearch.experimental
                            "afterSyncToRemote: failed to switch to remote for file={}",
                        ),
                localDirectory,
                // Not on local disk either — fall through to TieredDirectory
                    );
            return;
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;
    }
import org.apache.logging.log4j.Logger;
        }
        IOUtils.close(strategies, tieredDirectory);
            formatInputs.put(name, switchable);
 */
            return in.createOutput(name, context);
        return tieredDirectory.fileLength(name);
                        () -> new org.apache.logging.log4j.message.ParameterizedMessage(
            long size;
        tieredDirectory.afterSyncToRemote(file);
 * <p><b>Read-only warm (current scope):</b> all format files are REMOTE,
        }
            // File not yet synced — wrap in FormatSwitchableIndexInput so that if
        if (name.startsWith(IndexFileNames.SEGMENTS) && remoteDirectory.getExistingRemoteFilename(name) == null) {
    public void sync(Collection<String> names) {
                size = 0;
 *   <li>Lucene files (no claiming strategy) → {@link TieredDirectory}
                // Expected on read-only warm — file was never local or already evicted
 *
            if (remoteDirectory.getExistingRemoteFilename(name) != null) {
        if (isFormatFile(file)) {
        }
    private final RemoteSegmentStoreDirectory remoteDirectory;
 * no eviction, no ref counting for format files.
                in.deleteFile(file);
            } catch (NoSuchFileException e) {
            FormatSwitchableIndexInput switchable = new FormatSwitchableIndexInput(
            } catch (java.nio.file.NoSuchFileException e) {
            }
            );
 * A tiered directory for warm nodes that routes file operations based on
import org.opensearch.index.store.SubdirectoryAwareDirectory;
    public String[] listAll() throws IOException {
        }
    public void deleteFile(String name) throws IOException {
            // Now safe to delete local — all readers are on remote.
                threadPool,
                        e
        // torn down while the Java resources they may reference are still alive.
     * a subdirectory component (e.g. {@code "_0.cfe"}) are always Lucene files.
import org.opensearch.index.engine.dataformat.StoreStrategy;
    /** Per-file original FormatSwitchableIndexInput — used by afterSyncToRemote to switch before local delete. */
            StoreStrategyRegistry.Match match = strategies.matchFor(file);
                strategies.onRemoved(name);
                return in.openInput(name, context);
            } catch (NoSuchFileException e) {
            } catch (IOException e) {
            success = true;
            }
    public long fileLength(String name) throws IOException {
    @Override
        ensureOpen();
            // Same routing as openInput — check remote first.
     * format files and skip the strategy lookup.
    @Override
            this.tieredDirectory = new TieredDirectory(
import java.util.Set;
    private boolean isFormatFile(String name) {
    private final StoreStrategyRegistry strategies;
            }
import org.apache.lucene.store.IOContext;
    @Override
        super(localDirectory);
            }
    public void close() throws IOException {
                tieredStoragePrefetchSettingsSupplier
                    "afterSyncToRemote called for format file [" + file + "] but no remote filename found in metadata"
                    switchable.switchToRemote();
        }
                IOUtils.closeWhileHandlingException(this.strategies);
                fileCache,
            // File already synced to remote — read directly from remote.
        }
public class TieredSubdirectoryAwareDirectory extends FilterDirectory implements RemoteSyncListener {
                localInput,
     * <p>The {@code shardPath.resolveIndex()} guard is a fast-path: files without
import java.util.HashSet;
        // Skip — same as TieredDirectory (CompositeDirectory). On warm, files are
/**
                            file
            try {
        if (shardPath.resolveIndex().resolve(name).getParent().equals(shardPath.resolveIndex())) {
    @Override
 *
import java.io.IOException;
            if (blobKey == null) {
        SubdirectoryAwareDirectory localDirectory,
 * The OpenSearch Contributors require contributions made to
     * whose path resolves directly under the shard index directory — are not
    }
        }
            }
        if (isFormatFile(name)) {
                name,
            try {
        // Lucene files: if it's a segments_N file not in remote metadata, try local disk first.
            FormatSwitchableIndexInput switchable = formatInputs.remove(file);
 * this file be licensed under the Apache-2.0 license or a
                // Already gone — fine
import java.util.concurrent.ConcurrentMap;
 * Reads go directly to {@link RemoteSegmentStoreDirectory}. No local copies,
            );
        if (isFormatFile(name)) {
import org.opensearch.common.annotation.ExperimentalApi;
        if (isFormatFile(name)) {
        tieredDirectory.rename(source, dest);
            return;
import java.util.Arrays;
    }
                logger.warn("afterSyncToRemote: failed to delete local copy of file={}", file);
    }
                remoteDirectory
     * Only files under a subdirectory (e.g. {@code "parquet/seg_0.parquet"}) go
                try {
    public IndexInput openInput(String name, IOContext context) throws IOException {
    }
import org.opensearch.common.util.io.IOUtils;
            return;
        // Native registries close before the directory so native resources are
    private static final Logger logger = LogManager.getLogger(TieredSubdirectoryAwareDirectory.class);
    @Override
     */
            if (remoteDirectory.getExistingRemoteFilename(name) != null) {
        }
        }
            // The switchToRemote cascades to all clones/slices via the shared lock.
        Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier
            throw new IllegalStateException("No StoreStrategy registered for file [" + name + "]. Ensure the format plugin is installed.");
    private final TieredDirectory tieredDirectory;
            in.rename(source, dest);
            return false;
            // Switch any in-flight reader to remote before deleting local.
                in.deleteFile(name);
/*
    }
                );
        // Format files may be renamed during recovery (recovery.{uuid}.filename → filename).
            return in.fileLength(name);
        }
 * </ul>
        if (match == null) {
    public IndexOutput createOutput(String name, IOContext context) throws IOException {
    public void rename(String source, String dest) throws IOException {
            }
import org.opensearch.storage.indexinput.FormatSwitchableIndexInputWrapper;
            String blobKey = remoteDirectory.getExistingRemoteFilename(file);
        return tieredDirectory.createOutput(name, context);
     * through the strategy lookup via {@link StoreStrategyRegistry#matchFor}.
            strategies.onUploaded(file, remoteDirectory.getRemoteBasePath(format), blobKey, size);
    }
        ShardPath shardPath,
        // Handles restart where segments_N was written locally but has a different generation than remote.
        this.strategies = strategies == null ? StoreStrategyRegistry.EMPTY : strategies;
            // afterSyncToRemote deletes the local copy mid-read, the reader switches
    @Override
        StoreStrategyRegistry strategies,
                }
        if (isFormatFile(source)) {
 *
    ) {
import org.opensearch.index.shard.ShardPath;
        return all.stream().sorted().toArray(String[]::new);
            try {
package org.opensearch.storage.directory;
 * SPDX-License-Identifier: Apache-2.0
        // CompositeDirectory doesn't handle subdirectory path creation.
        this.remoteDirectory = remoteDirectory;
    }
}
        // No local writes to fsync. Writable warm will need to revisit this.
 * <ul>
    }
                return remoteDirectory.openInput(name, context);
        StoreStrategyRegistry.Match match = strategies.matchFor(name);
