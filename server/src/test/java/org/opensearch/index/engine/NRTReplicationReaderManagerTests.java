import static java.util.Collections.emptyList;
            final DirectoryReader reader = DirectoryReader.open(store.directory());
            final SegmentInfos infos_2 = readerManager.getSegmentInfos().clone();
    }
                .warmer(null)  
                .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
import org.apache.lucene.index.DirectoryReader;
                .tombstoneDocSupplier(tombstoneDocSupplier())
                .similarity(newIndexWriterConfig().getSimilarity())
            );  
            // Create a minimal engine config for testing
import org.opensearch.index.store.Store;
            assertEquals(initialInfos, readerManager.getSegmentInfos());
            try (final OpenSearchDirectoryReader acquire = readerManager.acquire()) {  
 * compatible open source license.
                (files) -> {},
                .queryCache(IndexSearcher.getDefaultQueryCache())
                .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
import org.opensearch.index.translog.TranslogConfig;
                assertNull(readerManager.refreshIfNeeded(acquire));  
                final StandardDirectoryReader standardReader = NRTReplicationReaderManager.unwrapStandardReader(acquire);
        try (final Store store = createStore()) {  
                })
            }  
    public void testCreateNRTreaderManager() throws IOException {
                testConfig
            EngineConfig testConfig = new EngineConfig.Builder().shardId(shardId)  
public class NRTReplicationReaderManagerTests extends EngineTestCase {  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
            final SegmentInfos initialInfos = ((StandardDirectoryReader) reader).getSegmentInfos();  
                .primaryTermSupplier(primaryTerm)  
            assertEquals(infos_2, readerManager.getSegmentInfos());
                .indexSettings(defaultSettings)
                .codecService(new CodecService(null, defaultSettings, logger, List.of()))
            readerManager.updateSegments(infos_2);
import org.apache.lucene.index.StandardDirectoryReader;  
import java.io.IOException;
                .externalRefreshListener(emptyList())  
import org.opensearch.index.seqno.RetentionLeases;
import java.util.List;
                .analyzer(newIndexWriterConfig().getAnalyzer())  
                .store(store)
                .build();
                .translogConfig(new TranslogConfig(shardId, createTempDir(), defaultSettings, BigArrays.NON_RECYCLING_INSTANCE, "", false))
                .queryCachingPolicy(IndexSearcher.getDefaultQueryCachingPolicy())  
import org.apache.lucene.index.SegmentInfos;
 * SPDX-License-Identifier: Apache-2.0
        }
            infos_2.changed();
import org.opensearch.common.unit.TimeValue;
                OpenSearchDirectoryReader.wrap(reader, shardId),
import org.opensearch.index.seqno.SequenceNumbers;  
            try (final OpenSearchDirectoryReader acquire = readerManager.acquire()) {
                assertEquals(infos_2, standardReader.getSegmentInfos());
            NRTReplicationReaderManager readerManager = new NRTReplicationReaderManager(
}  
                .eventListener(new Engine.EventListener() {  
package org.opensearch.index.engine;
 */  
                .threadPool(threadPool)
            // create an updated infos  
            }
                .internalRefreshListener(emptyList())
/*  
                .mergePolicy(newMergePolicy())
            store.createEmpty(Version.LATEST);
import org.opensearch.common.util.BigArrays;
import org.apache.lucene.util.Version;
import org.apache.lucene.search.IndexSearcher;
 *
                .circuitBreakerService(new NoneCircuitBreakerService())  
                .indexSort(null)
                (files) -> {},  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.codec.CodecService;
                .flushMergesAfter(TimeValue.timeValueMinutes(5))
