import org.apache.logging.log4j.Logger;
        Logger logger,
}
 */  
        Boolean commitOnClose,
        String associatedCriteria
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        MergeScheduler mergeScheduler,
        IndexWriterConfig.OpenMode openMode,  
import org.apache.lucene.index.IndexWriter;
package org.opensearch.index.engine;
 *
public interface IndexWriterFactory {
        SoftDeletesPolicy softDeletesPolicy,
import org.apache.lucene.index.MergeScheduler;
 * Base IndexWriter factory.
 * this file be licensed under the Apache-2.0 license or a
    IndexWriter createWriter(Directory directory, IndexWriterConfig config) throws IOException;  
    ) throws IOException;  
 * @opensearch.api  
        EngineConfig engineConfig,  
/*  
 */
    IndexWriter createWriter(
/**  
        Directory directory,  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.store.Directory;
 *
import org.apache.lucene.index.IndexWriterConfig;  
        CombinedDeletionPolicy deletionPolicy,
import java.io.IOException;
