 */  
public class MergeFailedEngineExceptionTests extends OpenSearchTestCase {
 *
import org.opensearch.OpenSearchException;
        assertEquals(shardId, exception.getShardId());  
 * compatible open source license.
        assertTrue(exception.getMessage().contains("Merge failed"));
        IOException cause = new IOException("disk full");  
/*  
}  
 */
import org.opensearch.core.index.shard.ShardId;  
import org.opensearch.test.OpenSearchTestCase;
package org.opensearch.index.engine.dataformat.merge;
/**
import org.opensearch.core.index.Index;
        MergeFailedEngineException exception = new MergeFailedEngineException(shardId, cause);
 * SPDX-License-Identifier: Apache-2.0
    }
 * The OpenSearch Contributors require contributions made to  
        assertTrue(exception instanceof OpenSearchException);
 * Tests for {@link MergeFailedEngineException}.  
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;  
        assertSame(cause, exception.getCause());
        ShardId shardId = new ShardId(new Index("test-index", "uuid"), 0);
    public void testExceptionMessageAndCause() {
