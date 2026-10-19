 * commit — including reading committed metadata and discovering existing commit points.
    @Override  
 * this file be licensed under the Apache-2.0 license or a
 * Extends {@link LuceneReplicaCommitter} to inherit operations that read from the on-disk  
    }  
public class LuceneReadOnlyCommitter extends LuceneReplicaCommitter {
 *
        super(committerConfig);
 * Overrides {@link #commit(CommitInput)} to throw {@link UnsupportedOperationException}.  
 * @opensearch.experimental  
 * compatible open source license.
 * <p>
    /** Always throws {@link UnsupportedOperationException}. */
 */  
 * <p>
import java.io.IOException;  
 * The OpenSearch Contributors require contributions made to  
    public LuceneReadOnlyCommitter(CommitterConfig committerConfig) throws IOException {
import org.opensearch.index.engine.exec.commit.CommitterConfig;
 * to committed state but rejects new commits.
    }  
 *
/*  
 * This is appropriate for any context where commits must not be produced.
        throw new UnsupportedOperationException("LuceneReadOnlyCommitter does not support commit().");
 * A {@link org.opensearch.index.engine.exec.commit.Committer} that provides read access  
 * SPDX-License-Identifier: Apache-2.0
    public CommitResult commit(CommitInput commitInput) throws IOException {
}
 */
package org.opensearch.be.lucene.index;
/**
