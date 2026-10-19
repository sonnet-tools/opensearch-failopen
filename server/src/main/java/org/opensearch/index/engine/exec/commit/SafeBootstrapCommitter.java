     * and use {@code CombinedCatalogSnapshotDeletionPolicy.findSafeCommitPoint(commits, gcp)}  
package org.opensearch.index.engine.exec.commit;
@ExperimentalApi  
        if (engineConfig.getTranslogConfig() == null || engineConfig.getTranslogConfig().getTranslogPath() == null) {  
     * Implementations should read the persisted global checkpoint from the translog
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.annotation.ExperimentalApi;
     * Called from the {@code SafeBootstrapCommitter} constructor — subclass instance fields  
 * {@link EngineConfig} with a valid {@link Store}, then delegates to  
     * If translog config is absent, safe bootstrap trimming is skipped.
     * Constructs the committer, validating config and trimming unsafe commits.
        discoverAndTrimUnsafeCommits(engineConfig.getStore(), engineConfig.getTranslogConfig().getTranslogPath());  
     */  
     *  
     * @throws IOException if reading or rewriting commits fails
        EngineConfig engineConfig = config.engineConfig();
 *
 * {@link #discoverAndTrimUnsafeCommits} which discovers existing commits, reads the
            throw new IllegalArgumentException("SafeBootstrapCommitter requires a non-null TranslogConfig with a valid translog path");
 * <p>
     * @param config the committer configuration
 * <p>
/*  
 * The constructor validates that the {@link CommitterConfig} contains a non-null
     * @param translogPath path to the translog directory for reading the persisted global checkpoint
     * <p>
}
 * SPDX-License-Identifier: Apache-2.0
     * checkpoint file via {@code Translog.readGlobalCheckpoint(translogPath, translogUUID)}
     * <p>  
 * store is in a safe state before the subclass opens it. Currently, it is coupled with the Store
        }
     * to identify the safe commit.
 * persisted global checkpoint from the translog checkpoint file, finds the safe commit,
import org.opensearch.index.engine.EngineConfig;
public abstract class SafeBootstrapCommitter implements Committer {
     *
     * commit is unsafe, rewrite at the safe commit point discarding unsafe commits.
    protected SafeBootstrapCommitter(CommitterConfig config) throws IOException {
import org.opensearch.index.store.Store;  
 */  
/**
     * @throws IOException if commit discovery or rewriting fails
            throw new IllegalArgumentException("SafeBootstrapCommitter requires a non-null EngineConfig with a valid Store");
 * The OpenSearch Contributors require contributions made to  
    }
        if (engineConfig == null || engineConfig.getStore() == null) {  
 * and rewrites at that point if the last commit is unsafe. This guarantees the backing  
     * @param store        the shard's store providing the Lucene directory  
     * are NOT yet initialized. Use only the provided parameters.
 */
import java.nio.file.Path;  
    protected abstract void discoverAndTrimUnsafeCommits(Store store, Path translogPath) throws IOException;
 * Subclass constructors must call {@code super(config)} as their first statement.
     */  
        }
 *
 * @opensearch.experimental
 * Abstract {@link Committer} that enforces safe commit trimming during construction.  
     * Discover committed catalog snapshots from the backing store and, if the last
import java.io.IOException;
    /**  
    /**  
 * TODO - Decouple the store impl from here and rely on Committer provided static methods  
 *  
