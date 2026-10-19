            .orElseThrow(() -> new IllegalStateException("IndexStoreProvider is required to create LuceneReaderManager"));
     * provider is a {@link LuceneIndexingExecutionEngine}, otherwise falls back to opening
import org.apache.logging.log4j.LogManager;
    }
import org.apache.lucene.index.LeafReaderContext;
    static EngineReaderManager<LuceneReader> createReaderManager(ReaderManagerConfig settings) throws IOException {  
import org.apache.lucene.index.StandardDirectoryReader;
}  
import org.opensearch.common.CheckedBiFunction;  
            readerRefresher = (dr, sis) -> DirectoryReader.openIfChanged(dr);  
 * <p>
 * when available, falling back to a directory-based reader for read-only replicas.  
        // does not yet exist on store (not yet committed)  
     * @param settings the reader manager settings
import java.util.ArrayList;
        final List<LeafReader> subs = new ArrayList<>();
 * The OpenSearch Contributors require contributions made to  
            directoryReader = StandardDirectoryReader.open(provider.getStore(settings.format()).store().directory());  
        } else {
/**  
@ExperimentalApi
    private static final Logger logger = LogManager.getLogger(LuceneSearchBackEnd.class);
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;
 */  
     * a reader from the {@link org.opensearch.index.store.Store}'s directory.  
import java.util.List;
import org.opensearch.be.lucene.index.LuceneIndexingExecutionEngine;
            logger.warn("Initialising it with a DirectorReader instead of a writer");
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.index.LeafReader;
 * Static helpers for creating Lucene-based {@link EngineReaderManager} instances.
        CheckedBiFunction<DirectoryReader, SegmentInfos, DirectoryReader, IOException> readerRefresher = null;
     *
        }
    /**
/*  
    }
 */  
 *
            directoryReader = DirectoryReader.open(luceneProvider.writer());
        Map<Long, LuceneReader> readers = new ConcurrentHashMap<>();
import java.util.Map;  
 *
            return null;
 * compatible open source license.
 * @opensearch.experimental
        return StandardDirectoryReader.open(oldReader.directory(), newSis, subs, null, null);
    private LuceneSearchBackEnd() {}  
            readerRefresher = LuceneSearchBackEnd::buildReader;
import org.opensearch.common.annotation.ExperimentalApi;
            subs.add(ctx.reader());  
        IndexStoreProvider provider = settings.indexStoreProvider()
     */
        DirectoryReader directoryReader;  
        }
        // Segment_n here is ignored because it is either already committed on disk as part of previous commit point or
            throw new IllegalStateException("ShardPath is required to create LuceneReaderManager");
     * @throws IOException if reader creation fails
     * Creates a {@link LuceneReaderManager} from the given settings.  
        for (LeafReaderContext ctx : oldReader.leaves()) {
     * @return a new reader manager  
import org.opensearch.index.engine.exec.EngineReaderManager;  
import org.opensearch.index.engine.exec.commit.IndexStoreProvider;
        }
        if (provider.getStore(settings.format()) instanceof LuceneIndexingExecutionEngine.LuceneFormatStore luceneProvider) {  
import java.io.IOException;  
 * Called by {@link org.opensearch.be.lucene.LucenePlugin#createReaderManager} during  
 * SPDX-License-Identifier: Apache-2.0
 * {@link LuceneIndexingExecutionEngine}'s shared {@link org.apache.lucene.index.IndexWriter}
package org.opensearch.be.lucene;
        if (settings.shardPath() == null) {  
        if (newSis == null || ((StandardDirectoryReader) oldReader).getSegmentInfos().version == newSis.version) {
import org.apache.logging.log4j.Logger;
            readers = luceneProvider.readers();
     * Opens an NRT reader from the {@link org.apache.lucene.index.IndexWriter} when the
        return new LuceneReaderManager(settings.format(), directoryReader, readers, readerRefresher, settings.shardPath().getShardId());  
        }  
import org.apache.lucene.index.DirectoryReader;  
import java.util.concurrent.ConcurrentHashMap;
import org.apache.lucene.index.SegmentInfos;  
final class LuceneSearchBackEnd {
 * shard initialization. The factory method opens an NRT reader from the
    private static DirectoryReader buildReader(DirectoryReader oldReader, SegmentInfos newSis) throws IOException {  
