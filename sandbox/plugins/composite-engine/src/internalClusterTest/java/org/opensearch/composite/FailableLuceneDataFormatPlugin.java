    private static final class FaultInjectingDirectory extends FilterDirectory {
        private static void maybeFail(String name) throws IOException {
     * once the static countdown reaches zero. This is the path Lucene's IndexWriter uses
        @Override
 *   ... index docs ...
        );
        public IndexOutput createTempOutput(String prefix, String suffix, IOContext context) throws IOException {
    /**
import org.apache.lucene.codecs.Codec;
        ) throws IOException {
     * — see {@link #DISABLED}.
     * After {@code n} successful Directory write operations across all Lucene writers in
}
         * Force a flush after every 2nd doc so the {@link FaultInjectingDirectory} sees a
     * Subclass of the production engine that swaps in a {@link FaultInjectingLuceneWriter}
 * <pre>{@code
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
            maybeFail(name);
     */
                indexingEngineConfig.store()
import org.apache.lucene.store.MMapDirectory;
    }
     * this JVM, the (n+1)th will throw {@code IOException}.
 * compatible open source license.
    private static final class FaultInjectingLuceneEngine extends LuceneIndexingExecutionEngine {
 * inside Lucene's {@link Directory} layer — simulating real-world disk faults that surface
    @Override
                (LuceneDataFormat) getDataFormat(),
        FaultInjectingDirectory(Directory delegate) {
     * Counts down on each Directory write op; when it hits zero the next op throws.
    }
/*
            return super.createTempOutput(prefix, suffix, context);
     * for every per-generation writer. Everything else flows through unchanged.
            Codec codec,
 * Test-only plugin that wraps {@link LucenePlugin} and injects deterministic I/O failures
import org.opensearch.be.lucene.LucenePlugin;
 *   FailableLuceneDataFormatPlugin.clearFailure();
            return 1024.0;
import org.apache.lucene.store.IndexOutput;
package org.opensearch.composite;
        Committer committer = indexingEngineConfig.committer();
            LuceneShardStatsTracker stats
    }
    public static void clearFailure() {
 * this file be licensed under the Apache-2.0 license or a
        @Override
    /**
            long writerGeneration,
     */
     */
        protected LuceneWriter buildLuceneWriter(
 */
            }
            Path baseDirectory,
                indexSort,
        /**
        @Override
import org.apache.lucene.store.IOContext;
import org.apache.lucene.store.FilterDirectory;
        @Override
                mappingVersion,
        if (committer instanceof LuceneCommitter luceneCommitter) {
        }
            maybeFail(prefix + "/" + suffix);
         * write op at predictable doc boundaries. Mirrors the existing
        }
        @Override
     * reaches zero.
            Codec codec,
            return new FaultInjectingLuceneEngine(
import java.util.concurrent.atomic.AtomicInteger;
            LuceneDataFormat dataFormat,
            org.opensearch.index.IndexSettings indexSettings,
        }
            LuceneShardStatsTracker stats
            return new FaultInjectingLuceneWriter(
    }
        ) {
 * Lucene writer creates its own injected directory; failures are not cross-writer.
     * {@code addDocument} or other IndexWriter operations.
        }
                stats
import org.opensearch.index.engine.exec.commit.Committer;
        protected int maxBufferedDocs() {
        }
        protected double ramBufferSizeMB() {
            if (countdownToFailure.getAndDecrement() == 0) {
        countdownToFailure.set(n);
     * inside any in-flight {@code IndexWriter.addDocument} once {@link #countdownToFailure}
                dataFormat,
        throw new IllegalStateException(
        }
 * }</pre>
        }
 * stub but for Lucene, so tests can exercise checkpoint/promotion paths where a Lucene
     * {@link FaultInjectingDirectory}. The fault directory triggers an {@code IOException}
                writerGeneration,
    /**
public class FailableLuceneDataFormatPlugin extends LucenePlugin {
        ) throws IOException {
    private static final AtomicInteger countdownToFailure = new AtomicInteger(DISABLED);
        FaultInjectingLuceneEngine(
                indexingEngineConfig.mapperService(),
 *
import org.apache.lucene.analysis.Analyzer;
import org.opensearch.be.lucene.LuceneDataFormat;
                registry,
     * LuceneWriter subclass that wraps the underlying {@link MMapDirectory} with a
import org.opensearch.be.lucene.index.LuceneCommitter;
import org.apache.lucene.search.Sort;
            return 2;
 *
    /**
        }
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;
    /** Disables fault injection by setting the countdown to {@link #DISABLED}. */
                throw new IOException("injected lucene directory failure on " + name + " (test-only)");
        public IndexOutput createOutput(String name, IOContext context) throws IOException {
 * The OpenSearch Contributors require contributions made to
            LuceneDataFormat dataFormat,
            long mappingVersion,
    /**
            LuceneCommitter luceneCommitter,
        }
/**
                baseDirectory,
 * secondary writer fails at the directory level.
    }
 *   FailableLuceneDataFormatPlugin.failOnNthWrite(1);  // next write op throws IOException
 */
        }
            Set<LuceneWriter> registry,
import java.util.Set;
    }
                + (committer != null ? committer.getClass().getName() : "null")
            org.opensearch.index.mapper.MapperService mapperService,
     */
                codec,
            Analyzer analyzer,
            "FailableLuceneDataFormatPlugin requires a LuceneCommitter but got: "
            org.opensearch.index.store.Store store
 *
            super(dataFormat, luceneCommitter, mapperService, indexSettings, store);
         */
        }
import java.nio.file.Path;
            return new FaultInjectingDirectory(new MMapDirectory(tempDirectory));
     */
            super(writerGeneration, mappingVersion, dataFormat, baseDirectory, analyzer, codec, indexSort, registry, stats);
            Path baseDirectory,
import org.opensearch.be.lucene.index.LuceneWriter;
         * (the smallest legal value).
     * "Disabled" means "set to a large enough number that we won't realistically reach zero"
            Analyzer analyzer,
import org.opensearch.be.lucene.index.LuceneIndexingExecutionEngine;
    private static final class FaultInjectingLuceneWriter extends LuceneWriter {
                analyzer,
            long mappingVersion,
            Sort indexSort,
     * {@link FilterDirectory} that throws {@code IOException} from any {@code createOutput}
         * (1024 MB) so doc count is the sole flush trigger, with {@code maxBufferedDocs=2}
            LuceneDataFormat dataFormat,
 * SPDX-License-Identifier: Apache-2.0
 * <p>Usage:
            );
     * to write segment files, so failures here propagate up as IOExceptions inside
    public IndexingExecutionEngine<?, ?> indexingEngine(IndexingEngineConfig indexingEngineConfig) {
            return super.createOutput(name, context);
         * {@code newWriterWithMaxBufferedDocs} pattern in the codebase: very large RAM buffer
import org.apache.lucene.store.Directory;
                indexingEngineConfig.indexSettings(),
    private static final int DISABLED = 1000;
            long writerGeneration,
            );
    public static void failOnNthWrite(int n) {
 * mid-{@code IndexWriter.addDocument}. Mirrors the failure-injection model of the original
            Sort indexSort,
            super(delegate);
 * <p>Failure isolation: only writes from this plugin's writers are affected. Each new
import org.opensearch.index.engine.dataformat.IndexingEngineConfig;
                luceneCommitter,
import java.io.IOException;
 *   nodePlugins() -> include FailableLuceneDataFormatPlugin.class instead of LucenePlugin.class
        protected Directory createDirectory(Path tempDirectory) throws IOException {
        FaultInjectingLuceneWriter(
        @Override
            Set<LuceneWriter> registry,
        countdownToFailure.set(DISABLED);
