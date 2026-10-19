        private static void maybeFail(String name) throws IOException {
            LuceneShardStatsTracker stats  
        protected int maxBufferedDocs() {
import org.apache.lucene.store.MMapDirectory;
        );
        }
                indexingEngineConfig.mapperService(),  
    /** Disables fault injection by setting the countdown to {@link #DISABLED}. */  
    private static final int DISABLED = 1000;
 * mid-{@code IndexWriter.addDocument}. Mirrors the failure-injection model of the original  
    public static void clearFailure() {
         * (the smallest legal value).  
            LuceneDataFormat dataFormat,  
        public IndexOutput createOutput(String name, IOContext context) throws IOException {
 * Lucene writer creates its own injected directory; failures are not cross-writer.
        }
import java.util.concurrent.atomic.AtomicInteger;
     */  
        throw new IllegalStateException(
                codec,  
        @Override
    /**
    }  
                throw new IOException("injected lucene directory failure on " + name + " (test-only)");  
    /**
            LuceneDataFormat dataFormat,  
 *  
                indexSort,
    public static void failOnNthWrite(int n) {
            maybeFail(name);  
            return new FaultInjectingLuceneEngine(  
         */
 * Test-only plugin that wraps {@link LucenePlugin} and injects deterministic I/O failures
import org.apache.lucene.codecs.Codec;
                registry,
            super(delegate);
 *   ... index docs ...
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
import org.apache.lucene.search.Sort;  
            long mappingVersion,  
 * }</pre>
                analyzer,
     * LuceneWriter subclass that wraps the underlying {@link MMapDirectory} with a  
    private static final class FaultInjectingDirectory extends FilterDirectory {
            Sort indexSort,
     * once the static countdown reaches zero. This is the path Lucene's IndexWriter uses  
        ) {
        public IndexOutput createTempOutput(String prefix, String suffix, IOContext context) throws IOException {
 *   FailableLuceneDataFormatPlugin.failOnNthWrite(1);  // next write op throws IOException
    }  
    private static final AtomicInteger countdownToFailure = new AtomicInteger(DISABLED);
            Path baseDirectory,
                luceneCommitter,
 * <p>Failure isolation: only writes from this plugin's writers are affected. Each new
        FaultInjectingLuceneWriter(  
                dataFormat,  
        @Override
        countdownToFailure.set(DISABLED);
            long mappingVersion,
            );  
    /**
        }
 * <pre>{@code
    @Override
            LuceneDataFormat dataFormat,
            Codec codec,  
     * for every per-generation writer. Everything else flows through unchanged.
                mappingVersion,
     * reaches zero.  
import org.opensearch.index.engine.exec.commit.Committer;
            );
     * inside any in-flight {@code IndexWriter.addDocument} once {@link #countdownToFailure}
/*  
import org.apache.lucene.analysis.Analyzer;
        protected double ramBufferSizeMB() {  
            Set<LuceneWriter> registry,  
    }  
        }
        }  
     */
                (LuceneDataFormat) getDataFormat(),
            LuceneShardStatsTracker stats
     * this JVM, the (n+1)th will throw {@code IOException}.  
     */
import org.opensearch.be.lucene.index.LuceneIndexingExecutionEngine;  
    /**
        @Override
     * Counts down on each Directory write op; when it hits zero the next op throws.  
            }
 * inside Lucene's {@link Directory} layer — simulating real-world disk faults that surface
     * to write segment files, so failures here propagate up as IOExceptions inside
     * {@link FaultInjectingDirectory}. The fault directory triggers an {@code IOException}
            return super.createOutput(name, context);
    }
            long writerGeneration,
    private static final class FaultInjectingLuceneEngine extends LuceneIndexingExecutionEngine {  
 * this file be licensed under the Apache-2.0 license or a
}
import java.util.Set;  
     */  
        protected Directory createDirectory(Path tempDirectory) throws IOException {  
        /**
            Path baseDirectory,
            if (countdownToFailure.getAndDecrement() == 0) {
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.store.FilterDirectory;
            return super.createTempOutput(prefix, suffix, context);
 *  
            return new FaultInjectingLuceneWriter(  
            Sort indexSort,
 * stub but for Lucene, so tests can exercise checkpoint/promotion paths where a Lucene
        countdownToFailure.set(n);  
 */
    }  
        protected LuceneWriter buildLuceneWriter(
import org.opensearch.be.lucene.LuceneDataFormat;  
import org.opensearch.be.lucene.index.LuceneWriter;
     */
 *   FailableLuceneDataFormatPlugin.clearFailure();  
import org.opensearch.index.engine.dataformat.IndexingEngineConfig;  
        }
            Analyzer analyzer,
import org.apache.lucene.store.IOContext;  
        @Override
            long writerGeneration,
import org.apache.lucene.store.IndexOutput;
            maybeFail(prefix + "/" + suffix);  
     * {@link FilterDirectory} that throws {@code IOException} from any {@code createOutput}
     * {@code addDocument} or other IndexWriter operations.
        ) throws IOException {
            "FailableLuceneDataFormatPlugin requires a LuceneCommitter but got: "  
        ) throws IOException {
     * After {@code n} successful Directory write operations across all Lucene writers in
         * (1024 MB) so doc count is the sole flush trigger, with {@code maxBufferedDocs=2}
            Analyzer analyzer,  
        @Override
        FaultInjectingDirectory(Directory delegate) {  
 *
import java.io.IOException;
 */  
 * secondary writer fails at the directory level.
     * "Disabled" means "set to a large enough number that we won't realistically reach zero"
    }
            LuceneCommitter luceneCommitter,
        }
            return 1024.0;
        }
import java.nio.file.Path;
/**  
        Committer committer = indexingEngineConfig.committer();
import org.opensearch.be.lucene.index.LuceneCommitter;
         * write op at predictable doc boundaries. Mirrors the existing  
                + (committer != null ? committer.getClass().getName() : "null")
import org.opensearch.be.lucene.LucenePlugin;
        @Override  
                indexingEngineConfig.indexSettings(),
            org.opensearch.index.store.Store store
        FaultInjectingLuceneEngine(
            Set<LuceneWriter> registry,
                baseDirectory,
        }
         * Force a flush after every 2nd doc so the {@link FaultInjectingDirectory} sees a
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;
    /**
            org.opensearch.index.mapper.MapperService mapperService,
            super(dataFormat, luceneCommitter, mapperService, indexSettings, store);  
public class FailableLuceneDataFormatPlugin extends LucenePlugin {  
                stats  
            org.opensearch.index.IndexSettings indexSettings,  
        }
import org.apache.lucene.store.Directory;
            super(writerGeneration, mappingVersion, dataFormat, baseDirectory, analyzer, codec, indexSort, registry, stats);
    private static final class FaultInjectingLuceneWriter extends LuceneWriter {
            return new FaultInjectingDirectory(new MMapDirectory(tempDirectory));
        }
            return 2;  
 * <p>Usage:
        if (committer instanceof LuceneCommitter luceneCommitter) {
 *   nodePlugins() -> include FailableLuceneDataFormatPlugin.class instead of LucenePlugin.class  
 * compatible open source license.
    public IndexingExecutionEngine<?, ?> indexingEngine(IndexingEngineConfig indexingEngineConfig) {  
     * Subclass of the production engine that swaps in a {@link FaultInjectingLuceneWriter}  
 * The OpenSearch Contributors require contributions made to  
                indexingEngineConfig.store()
                writerGeneration,
package org.opensearch.composite;
         * {@code newWriterWithMaxBufferedDocs} pattern in the codebase: very large RAM buffer
            Codec codec,
     * — see {@link #DISABLED}.
