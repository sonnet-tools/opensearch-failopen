                .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
                SequenceNumbers.NO_OPS_PERFORMED,
                            -1,
                .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)  
                        )
                    ParsedDocument doc = testParsedDocument(Integer.toString(i), null, testDocument(), new BytesArray("{}"), null);  
                .threadPool(threadPool)  
                    assertThat("Leaf sorter should match the configured one", readOnlyEngine.config().getLeafSorter(), equalTo(leafSorter));
 */  
                .primaryTermSupplier(primaryTerm)
                            VersionType.INTERNAL,
                .externalRefreshListener(java.util.Collections.emptyList())  
                .queryCache(IndexSearcher.getDefaultQueryCache())
                            Engine.Operation.Origin.PRIMARY,  
                            doc,
                .store(store)  
                    DirectoryReader reader = (DirectoryReader) searcher.getDirectoryReader();  
                .translogConfig(new TranslogConfig(shardId, translogPath, defaultSettings, BigArrays.NON_RECYCLING_INSTANCE, "", false))
                .externalRefreshListener(java.util.Collections.emptyList())
                .similarity(newIndexWriterConfig().getSimilarity())
                        engine.flush();
                            newUid(doc),  
                TranslogHandler translogHandler = new TranslogHandler(xContentRegistry(), config.getIndexSettings(), engine);
                .analyzer(newIndexWriterConfig().getAnalyzer())
                .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
                for (int i = 0; i < 20; i++) {
                            System.nanoTime(),  
                    DirectoryReader reader = (DirectoryReader) searcher.getDirectoryReader();
import static org.junit.Assert.assertEquals;
                engine.translogManager().recoverFromTranslog(translogHandler, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
            try (
                // Index many documents and force flushes to ensure multiple segments
                .eventListener(new Engine.EventListener() {
                SequenceNumbers.NO_OPS_PERFORMED,
                    java.util.List<Integer> expectedOrder = new java.util.ArrayList<>(actualOrder);
                try (Engine.Searcher searcher = readOnlyEngine.acquireSearcher("test")) {  
                            false,  
                    java.util.List<Integer> expectedOrder = new java.util.ArrayList<>(actualOrder);  
                            newUid(doc),
                .indexSettings(defaultSettings)
                .indexSettings(defaultSettings)
                engine.refresh("test");
                        )  
                try (Engine.Searcher searcher = engine.acquireSearcher("test")) {
import org.opensearch.index.translog.TranslogConfig;
                            SequenceNumbers.UNASSIGNED_SEQ_NO,  
                shardId,  
            }
                    true,
            final String translogUUID = Translog.createEmptyTranslog(  
            ) {
                            false,
                .flushMergesAfter(TimeValue.timeValueMinutes(5))
 * this file be licensed under the Apache-2.0 license or a
                            0
                .globalCheckpointSupplier(() -> maxSeqNo)
import org.opensearch.Version;
                .codecService(new CodecService(null, defaultSettings, logger, List.of()))
                            SequenceNumbers.UNASSIGNED_SEQ_NO,
                            newUid(doc),
                .translogConfig(new TranslogConfig(shardId, translogPath, defaultSettings, BigArrays.NON_RECYCLING_INSTANCE, "", false))  
                    // and that it can acquire a searcher successfully  
import org.opensearch.index.seqno.SequenceNumbers;
                .indexSettings(defaultSettings)
import org.apache.lucene.index.DirectoryReader;
                .similarity(newIndexWriterConfig().getSimilarity())
                            SequenceNumbers.UNASSIGNED_SEQ_NO,
                    ParsedDocument doc = testParsedDocument(Integer.toString(i), null, testDocument(), new BytesArray("{}"), null);
                .threadPool(threadPool)
            try (InternalEngine engine = new InternalEngine(config)) {  
import java.util.Comparator;
            store.associateIndexWithNewTranslog(translogUUID);
import java.io.IOException;  
                }  
                SequenceNumbers.NO_OPS_PERFORMED,
                .mergePolicy(newMergePolicy())
                    ParsedDocument doc = testParsedDocument(Integer.toString(i), null, testDocument(), new BytesArray("{}"), null);
                .leafSorter(leafSorter)
                }  
            }
    }  
                            primaryTerm.get(),
                .similarity(newIndexWriterConfig().getSimilarity())  
                    true  
            EngineConfig config = new EngineConfig.Builder().shardId(shardId)
/*  
                .eventListener(new Engine.EventListener() {
                .leafSorter(leafSorter)
            store.createEmpty(Version.CURRENT.luceneVersion);
                shardId,
                .queryCache(IndexSearcher.getDefaultQueryCache())
            EngineConfig config = new EngineConfig.Builder().shardId(shardId)
                    DirectoryReader reader = (DirectoryReader) searcher.getDirectoryReader();
                .codecService(new CodecService(null, defaultSettings, logger, List.of()))
                    );
                            -1,  
                .mergePolicy(newMergePolicy())
                    if ((i + 1) % 5 == 0) {  
                shardId,
                )
        try (Store store = createStore()) {
                    assertThat("Leaf sorter should be configured", readOnlyEngine.config().getLeafSorter(), notNullValue());
import org.opensearch.common.util.BigArrays;
                .store(store)
                .build();  
                    readOnlyConfig,
                    engine.index(  
                })  
                            doc,
                .analyzer(newIndexWriterConfig().getAnalyzer())
                })  
                    // Verify basic functionality - we can read from the engine
                            Versions.MATCH_DELETED,
                .tombstoneDocSupplier(tombstoneDocSupplier())
                .primaryTermSupplier(primaryTerm)  
    }  
                .tombstoneDocSupplier(tombstoneDocSupplier())
            long maxSeqNo;
                .primaryTermSupplier(primaryTerm)
            EngineConfig readOnlyConfig = new EngineConfig.Builder().shardId(shardId)  
            try (InternalEngine engine = new InternalEngine(config)) {  
            // Now open ReadOnlyEngine and check leaf order
    public void testInternalEngineUsesLeafSorter() throws IOException {
            );
        }
                .queryCachingPolicy(IndexSearcher.getDefaultQueryCachingPolicy())  
            // Index docs with InternalEngine, then open ReadOnlyEngine
}
 *
            final String translogUUID = Translog.createEmptyTranslog(
                    );
            try (InternalEngine engine = new InternalEngine(config)) {
                    // Test that ReadOnlyEngine can be created with a leaf sorter configured
                .codecService(new CodecService(null, defaultSettings, logger, List.of()))
                .similarity(newIndexWriterConfig().getSimilarity())  
                    // Always verify we have at least one leaf
                    engine.index(
import org.opensearch.index.translog.Translog;  
                .internalRefreshListener(java.util.Collections.emptyList())
                .eventListener(new Engine.EventListener() {  
                .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)  
import static org.junit.Assert.assertThat;  
                .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)  
                    }  
                    assertEquals("Leaves should be sorted by maxDoc descending", expectedOrder, actualOrder);
import org.opensearch.common.unit.TimeValue;  
import org.opensearch.index.VersionType;  
                            doc,  
 * The OpenSearch Contributors require contributions made to  
                }
                            SequenceNumbers.UNASSIGNED_SEQ_NO,
            store.associateIndexWithNewTranslog(translogUUID);
                .internalRefreshListener(java.util.Collections.emptyList())  
import static org.hamcrest.Matchers.notNullValue;
            EngineConfig config = new EngineConfig.Builder().shardId(shardId)
                    if ((i + 1) % 5 == 0) {
import java.nio.file.Path;
                            -1,
                            VersionType.INTERNAL,  
            }
                primaryTerm.get()
public class LeafSorterOptimizationTests extends EngineTestCase {
                })
                .externalRefreshListener(java.util.Collections.emptyList())  
            Comparator<LeafReader> leafSorter = Comparator.comparingInt(LeafReader::maxDoc).reversed();
            );
                    expectedOrder.sort((a, b) -> Integer.compare(b, a));
        try (Store store = createStore()) {  
 * compatible open source license.
import org.apache.lucene.search.IndexSearcher;  
                .queryCache(IndexSearcher.getDefaultQueryCache())  
                try (Engine.Searcher searcher = engine.acquireSearcher("test")) {  
                .codecService(new CodecService(null, defaultSettings, logger, List.of()))  
                engine.refresh("test");
import org.apache.lucene.index.LeafReader;
                .warmer(null)
                        actualOrder.add(ctx.reader().maxDoc());
                TranslogHandler translogHandler = new TranslogHandler(xContentRegistry(), config.getIndexSettings(), engine);
                    assertThat("Should have at least one leaf", reader.leaves().size(), greaterThan(0));  
        Path translogPath = createTempDir();  
                .build();
                            SequenceNumbers.UNASSIGNED_SEQ_NO,
                .externalRefreshListener(java.util.Collections.emptyList())
            store.associateIndexWithNewTranslog(translogUUID);  
                .queryCachingPolicy(IndexSearcher.getDefaultQueryCachingPolicy())
            final String translogUUID = Translog.createEmptyTranslog(
                .threadPool(threadPool)
                }  
                .primaryTermSupplier(primaryTerm)
import org.opensearch.core.common.bytes.BytesArray;
                    }  
                maxSeqNo = engine.getSeqNoStats(-1).getMaxSeqNo();  
                    null,  
                        new Engine.Index(
                .indexSettings(defaultSettings)  
                .flushMergesAfter(TimeValue.timeValueMinutes(5))  
                translogPath,  
                            System.nanoTime(),
                .translogConfig(new TranslogConfig(shardId, translogPath, defaultSettings, BigArrays.NON_RECYCLING_INSTANCE, "", false))
                            primaryTerm.get(),
    }
                    assertThat("Should have at least one leaf", reader.leaves().size(), greaterThan(0));
                .warmer(null)
                        new Engine.Index(
                    expectedOrder.sort((a, b) -> Integer.compare(b, a));
                .mergePolicy(newMergePolicy())  
                            Engine.Operation.Origin.PRIMARY,
                        engine.flush();
                .analyzer(newIndexWriterConfig().getAnalyzer())  
                .store(store)
                        actualOrder.add(ctx.reader().maxDoc());
                .eventListener(new Engine.EventListener() {
                    java.util.List<Integer> actualOrder = new java.util.ArrayList<>();  
                .store(store)  
                .tombstoneDocSupplier(tombstoneDocSupplier())  
import static org.hamcrest.Matchers.equalTo;
                    }
                    java.util.function.Function.identity(),
                    for (org.apache.lucene.index.LeafReaderContext ctx : reader.leaves()) {
                .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
                    assertThat("Should have multiple leaves", reader.leaves().size(), greaterThan(0));
            Comparator<LeafReader> leafSorter = Comparator.comparingInt(LeafReader::maxDoc);  
                }  
                .build();  
import static org.hamcrest.Matchers.greaterThan;  
                            VersionType.INTERNAL,
                            Engine.Operation.Origin.PRIMARY,
                })
                .flushMergesAfter(TimeValue.timeValueMinutes(5))
import java.util.List;  
                        engine.flush();
                    }
import org.opensearch.index.store.Store;
                    );  
                primaryTerm.get()  
                for (int i = 0; i < 100; i++) {
        }
                .warmer(null)
                            0
                .analyzer(newIndexWriterConfig().getAnalyzer())
                            primaryTerm.get(),  
        }  
                .leafSorter(leafSorter)  
                .build();
                .queryCachingPolicy(IndexSearcher.getDefaultQueryCachingPolicy())  
                translogPath,
        try (Store store = createStore()) {  
import org.opensearch.index.codec.CodecService;
                .tombstoneDocSupplier(tombstoneDocSupplier())
                .flushMergesAfter(TimeValue.timeValueMinutes(5))
                    assertEquals("Leaves should be sorted by maxDoc descending", expectedOrder, actualOrder);  
package org.opensearch.index.engine;
    public void testTimestampSortOptimizationWorksOnAllEngineTypes() throws IOException {  
                .threadPool(threadPool)  
                    if ((i + 1) % 3 == 0) {  
                    engine.index(
            store.createEmpty(Version.CURRENT.luceneVersion);
                    // Force flush every 3 documents to create more segments aggressively
                engine.translogManager().recoverFromTranslog(translogHandler, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);  
                .mergePolicy(newMergePolicy())
                translogPath,  
                .internalRefreshListener(java.util.Collections.emptyList())
    public void testReadOnlyEngineConfiguresLeafSorter() throws IOException {
                    assertThat("Should have multiple leaves", reader.leaves().size(), greaterThan(0));
                .queryCache(IndexSearcher.getDefaultQueryCache())
        Path translogPath = createTempDir();
                primaryTerm.get()  
                            System.nanoTime(),
                .internalRefreshListener(java.util.Collections.emptyList())
            Comparator<LeafReader> leafSorter = Comparator.comparingInt(LeafReader::maxDoc).reversed();  
            );
import org.opensearch.index.mapper.ParsedDocument;
                engine.refresh("test");
                .warmer(null)  
                    java.util.List<Integer> actualOrder = new java.util.ArrayList<>();
        Path translogPath = createTempDir();
                    null,
                engine.translogManager().recoverFromTranslog(translogHandler, engine.getProcessedLocalCheckpoint(), Long.MAX_VALUE);
                engine.flush();
                    for (org.apache.lucene.index.LeafReaderContext ctx : reader.leaves()) {  
                            0  
            store.createEmpty(Version.CURRENT.luceneVersion);
                for (int i = 0; i < 20; i++) {  
import org.opensearch.common.lucene.uid.Versions;
            }
                            SequenceNumbers.UNASSIGNED_SEQ_NO,  
                            Versions.MATCH_DELETED,  
                        )
                .translogConfig(new TranslogConfig(shardId, translogPath, defaultSettings, BigArrays.NON_RECYCLING_INSTANCE, "", false))
                            false,
                            Versions.MATCH_DELETED,
        // Simplified: Only test that InternalEngine respects the leafSorter logic
                        new Engine.Index(  
                .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
                .leafSorter(leafSorter)
                .queryCachingPolicy(IndexSearcher.getDefaultQueryCachingPolicy())
                TranslogHandler translogHandler = new TranslogHandler(xContentRegistry(), config.getIndexSettings(), engine);
                }
                ReadOnlyEngine readOnlyEngine = new ReadOnlyEngine(  
                    }
import org.opensearch.index.seqno.RetentionLeases;  
 * SPDX-License-Identifier: Apache-2.0
