@ExperimentalApi
            if (success == false) {  
     * format files and skip the strategy lookup.  
     * registered {@link StoreStrategy}). Plain Lucene/metadata files — those
                size = remoteDirectory.fileLength(file);
    }
        // torn down while the Java resources they may reference are still alive.
            }
    @Override  
            long size;  
import org.apache.logging.log4j.Logger;
                return remoteDirectory.fileLength(name);
        if (name.startsWith(IndexFileNames.SEGMENTS) && remoteDirectory.getExistingRemoteFilename(name) == null) {
                IOUtils.closeWhileHandlingException(this.strategies);
            return in.fileLength(name);
        return true;  
        // No local writes to fsync. Writable warm will need to revisit this.
        }  
 * no eviction, no ref counting for format files.
        } finally {
    private final ConcurrentMap<String, FormatSwitchableIndexInput> formatInputs = new ConcurrentHashMap<>();  
            } catch (NoSuchFileException e) {
 */
            if (remoteDirectory.getExistingRemoteFilename(name) != null) {
            return in.createOutput(name, context);
                } catch (IOException e) {
                localDirectory,  
        tieredDirectory.afterSyncToRemote(file);
        }  
        if (isFormatFile(source)) {  
            StoreStrategyRegistry.Match match = strategies.matchFor(file);  
            } catch (java.nio.file.NoSuchFileException e) {  
    }
                in.deleteFile(file);
 * this file be licensed under the Apache-2.0 license or a
        }
        if (match == null) {  
        Set<String> all = new HashSet<>(Arrays.asList(tieredDirectory.listAll()));
            strategies.onUploaded(file, remoteDirectory.getRemoteBasePath(format), blobKey, size);
        // Format files may be renamed during recovery (recovery.{uuid}.filename → filename).
    @Override  
        SubdirectoryAwareDirectory localDirectory,  
     * through the strategy lookup via {@link StoreStrategyRegistry#matchFor}.
import java.nio.file.NoSuchFileException;
import org.opensearch.storage.indexinput.FormatSwitchableIndexInputWrapper;
        super(localDirectory);
            } catch (IOException e) {  
            logger.debug("Created TieredSubdirectoryAwareDirectory (hasStoreHandlers={})", this.strategies.hasStoreHandlers());  
        }  
import java.util.function.Supplier;
        if (shardPath.resolveIndex().resolve(name).getParent().equals(shardPath.resolveIndex())) {
import org.apache.lucene.index.IndexFileNames;  
            in.rename(source, dest);
import org.opensearch.common.annotation.ExperimentalApi;
        this.shardPath = shardPath;
            } catch (NoSuchFileException e) {
            if (remoteDirectory.getExistingRemoteFilename(name) != null) {
import java.util.concurrent.ConcurrentHashMap;  
 * @opensearch.experimental  
            return;
        ShardPath shardPath,
                // Already gone — fine
import org.opensearch.index.store.remote.filecache.FileCache;  
                        ),  
        Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier  
import org.opensearch.index.store.RemoteSegmentStoreDirectory;  
                strategies.onRemoved(name);  
            return false;  
                );
 * compatible open source license.
     *
            if (blobKey == null) {
            String format = match != null ? match.format().name() : "";
            // afterSyncToRemote deletes the local copy mid-read, the reader switches  
    /** Per-file original FormatSwitchableIndexInput — used by afterSyncToRemote to switch before local delete. */
            // Same routing as openInput — check remote first.  
    @Override  
    public String[] listAll() throws IOException {
                        e
            // The switchToRemote cascades to all clones/slices via the shared lock.
    public void afterSyncToRemote(String file) {
        this.remoteDirectory = remoteDirectory;
 *
    public void sync(Collection<String> names) {
            return;
 *
            String blobKey = remoteDirectory.getExistingRemoteFilename(file);  
            success = true;
 *       (FileCache + remote)</li>  
                fileCache,
    }
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;  
            } catch (IOException e) {
import java.util.Arrays;
    private final StoreStrategyRegistry strategies;
                threadPool,  
                throw new IllegalStateException(
            }
import org.opensearch.threadpool.ThreadPool;
            // Now safe to delete local — all readers are on remote.  
            formatInputs.put(name, switchable);  
            if (blobKey == null) {
import org.apache.lucene.store.IndexOutput;
    public long fileLength(String name) throws IOException {
    @Override  
import java.util.Collection;  
        return tieredDirectory.fileLength(name);  
        FileCache fileCache,
        }  
/*  
                        () -> new org.apache.logging.log4j.message.ParameterizedMessage(  
            this.tieredDirectory = new TieredDirectory(
        return tieredDirectory.openInput(name, context);  
                localInput,  
import org.apache.lucene.store.IndexInput;  
                    );
                }  
import java.util.Set;
            return;
import org.opensearch.index.store.SubdirectoryAwareDirectory;
    public TieredSubdirectoryAwareDirectory(
    private final ShardPath shardPath;
        return all.stream().sorted().toArray(String[]::new);  
                tieredStoragePrefetchSettingsSupplier
        if (isFormatFile(name)) {  
 * <p><b>Routing:</b>
        }
            );
                    switchable.switchToRemote();  
        // Lucene files: if it's a segments_N file not in remote metadata, try local disk first.  
 * The OpenSearch Contributors require contributions made to  
/**
            );
    public void deleteFile(String name) throws IOException {
            throw new IllegalStateException("No StoreStrategy registered for file [" + name + "]. Ensure the format plugin is installed.");
import org.apache.lucene.store.FilterDirectory;
import org.apache.logging.log4j.LogManager;
        if (isFormatFile(name)) {
            }
            }
     * Returns {@code true} if {@code name} is a format file (claimed by a  
                in.deleteFile(name);  
    }
 * <ul>
        boolean success = false;  
package org.opensearch.storage.directory;
 * </ul>
            try {
        // Format files (subdirectory) need SubdirectoryAwareDirectory which creates parent dirs.
 * seeded from remote metadata at shard open via {@link StoreStrategyRegistry}.  
    }
        return tieredDirectory.createOutput(name, context);
 *  
import java.util.HashSet;
import org.opensearch.index.engine.dataformat.StoreStrategy;
    }
 * <p><b>Read-only warm (current scope):</b> all format files are REMOTE,
 *
            // File already synced to remote — read directly from remote.
    }  
            try {
    }
        // Route through SubdirectoryAwareDirectory which handles subdirectory paths.
        StoreStrategyRegistry.Match match = strategies.matchFor(name);
        // Skip — same as TieredDirectory (CompositeDirectory). On warm, files are  
        // CompositeDirectory doesn't handle subdirectory path creation.  
        // Handles restart where segments_N was written locally but has a different generation than remote.
            // File not yet synced — wrap in FormatSwitchableIndexInput so that if
            IndexInput localInput = in.openInput(name, context);
     * Only files under a subdirectory (e.g. {@code "parquet/seg_0.parquet"}) go
        }
                    logger.warn(
        }
    public IndexOutput createOutput(String name, IOContext context) throws IOException {
                logger.warn("afterSyncToRemote: failed to delete local copy of file={}", file);  
            }
        tieredDirectory.rename(source, dest);
import org.opensearch.common.util.io.IOUtils;  
        if (isFormatFile(name)) {  
    public void close() throws IOException {
                remoteDirectory
        ThreadPool threadPool,  
     * <p>The {@code shardPath.resolveIndex()} guard is a fast-path: files without
        StoreStrategyRegistry strategies,
            }
 */  
    @Override
            try {  
import java.io.IOException;  
            String blobKey = remoteDirectory.getExistingRemoteFilename(name);
        }
    }
 *       {@link RemoteSegmentStoreDirectory}</li>
     * a subdirectory component (e.g. {@code "_0.cfe"}) are always Lucene files.  
                size = 0;
            if (switchable != null) {
    }
        }
                "FormatSwitchable(" + name + ")",
        tieredDirectory.deleteFile(name);  
 *   <li>Lucene files (no claiming strategy) → {@link TieredDirectory}
    private final TieredDirectory tieredDirectory;
    private final RemoteSegmentStoreDirectory remoteDirectory;  
            FormatSwitchableIndexInput switchable = formatInputs.remove(file);  
                            "afterSyncToRemote: failed to switch to remote for file={}",
 * SPDX-License-Identifier: Apache-2.0
                return remoteDirectory.openInput(name, context);  
 * data format.  
    @Override
                name,
        if (isFormatFile(file)) {
            // to remote transparently (same pattern as SwitchableIndexInput for Lucene files).
    private boolean isFormatFile(String name) {
    ) {
public class TieredSubdirectoryAwareDirectory extends FilterDirectory implements RemoteSyncListener {  
import java.util.concurrent.ConcurrentMap;
        IOUtils.close(strategies, tieredDirectory);
            // Switch any in-flight reader to remote before deleting local.
                remoteDirectory,
 *   <li>Format files (a strategy claims the file) → always  
                // Not on local disk either — fall through to TieredDirectory  
                    "afterSyncToRemote called for format file [" + file + "] but no remote filename found in metadata"  
        // Native registries close before the directory so native resources are  
                // Expected on read-only warm — file was never local or already evicted
    public IndexInput openInput(String name, IOContext context) throws IOException {
}
    @Override
                try {
            }  
    }  
    @Override  
     */  
import org.opensearch.storage.indexinput.FormatSwitchableIndexInput;
        this.strategies = strategies == null ? StoreStrategyRegistry.EMPTY : strategies;  
 * A tiered directory for warm nodes that routes file operations based on
            return new FormatSwitchableIndexInputWrapper("FormatSwitchable(" + name + ")", switchable);
    @Override
    private static final Logger logger = LogManager.getLogger(TieredSubdirectoryAwareDirectory.class);
import org.apache.lucene.store.IOContext;
            FormatSwitchableIndexInput switchable = new FormatSwitchableIndexInput(  
            }
                            file
 * Reads go directly to {@link RemoteSegmentStoreDirectory}. No local copies,
import org.opensearch.index.shard.ShardPath;
    public void rename(String source, String dest) throws IOException {  
        try {
        if (isFormatFile(name)) {
import org.opensearch.index.store.RemoteSyncListener;
        RemoteSegmentStoreDirectory remoteDirectory,
        // either remote-only (format files) or cached from remote.
    /**
        ensureOpen();
     * whose path resolves directly under the shard index directory — are not
            try {
                return in.openInput(name, context);
            }  
            }
