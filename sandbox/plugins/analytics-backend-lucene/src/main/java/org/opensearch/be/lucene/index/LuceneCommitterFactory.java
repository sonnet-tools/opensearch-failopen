        if (committerConfig.isReplica()) {
import org.opensearch.index.engine.exec.commit.CommitterConfig;  
    }  
     *
    public Committer getCommitter(CommitterConfig committerConfig) throws IOException {
 * {@link org.opensearch.plugins.EnginePlugin} SPI. When the composite engine initializes  
import org.opensearch.index.engine.exec.commit.Committer;
public final class LuceneCommitterFactory implements CommitterFactory {
@ExperimentalApi  
                && committerConfig.engineConfig().isReadOnlyReplica() == false) {
 */
            // Warm or NRT replica: receives segments from primary, commits them locally.
 *  
    public LuceneCommitterFactory() {}
            }
 * Registered by {@link org.opensearch.be.lucene.LucenePlugin} via the
     * @param committerConfig the committer config  
 * {@link CommitterFactory} implementation that creates {@link LuceneCommitter} instances.  
}
            // Warm primary  
        }
 * the shared Lucene {@link org.apache.lucene.index.IndexWriter} for durable segment commits.
 * <p>
        return new LuceneCommitter(committerConfig);
/*  
     * Creates a new {@link LuceneCommitter} for the given settings.
import org.opensearch.common.annotation.ExperimentalApi;
 * SPDX-License-Identifier: Apache-2.0
    /** Creates a new factory instance. */  
                return new LuceneReadOnlyCommitter(committerConfig);  
 * compatible open source license.
import org.opensearch.index.engine.exec.commit.CommitterFactory;
package org.opensearch.be.lucene.index;
            if (committerConfig.engineConfig().getIndexSettings().isWarmIndex()
/**
            return new LuceneReplicaCommitter(committerConfig);  
 * @opensearch.experimental
     */  
    /**  
     * @throws IOException if committer initialization fails
 * a shard, it calls {@link #getCommitter(CommitterConfig)} to obtain a committer that owns
import java.io.IOException;  
 * The OpenSearch Contributors require contributions made to  
 */  
 *
     * @return a new committer
 * this file be licensed under the Apache-2.0 license or a
