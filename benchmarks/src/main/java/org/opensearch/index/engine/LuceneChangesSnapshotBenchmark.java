    public void drainSnapshot(Blackhole bh) throws IOException {
        }
    }
     * Fails fast if the index does not have the shape the layout intends, so a run cannot quietly measure something
    private static final ShardId SHARD_ID = new ShardId("index", "_na_", 0);
    @Setup(Level.Trial)
        final IndexSearcher searcher = new IndexSearcher(reader);
        }
        final Engine.Searcher searcher = new Engine.Searcher(
            }
import org.openjdk.jmh.annotations.Fork;
 *   <li>{@code CONTIGUOUS} - an append-only history in one segment, read as one gapless ascending run of docIDs. This
import org.opensearch.index.mapper.SourceFieldMapper;
import java.nio.file.Path;
/*
import org.apache.lucene.document.StoredField;
    private LuceneChangesSnapshot newSnapshot() throws IOException {
                            writer.addDocument(newDocument(seqNo));
        INTERLEAVED
                case CONTIGUOUS:
@Fork(value = 1, jvmArgsAppend = { "-Xms2g", "-Xmx2g" })
 *       decompresses a block with nothing to amortize it against, and a per-document read is cheaper.
        }
     * stored fields is possible. Deliberately asserts on the index rather than on the snapshot's internals, so this
        }
     * For {@code STRIDED}, how many docIDs apart consecutive reads are; for {@code INTERLEAVED}, how many segments the
    private Layout layout;
 * compatible open source license.
                    break;
            throw new IllegalStateException("expected " + numOps + " hits but got " + topDocs.scoreDocs.length);
                bh.consume(op);
import org.openjdk.jmh.annotations.OutputTimeUnit;
    }
        try (IndexWriter writer = new IndexWriter(directory, config)) {
 * this file be licensed under the Apache-2.0 license or a
    private int stride;
@BenchmarkMode(Mode.AverageTime)
        final Lucene104Codec.Mode mode = Lucene104Codec.Mode.valueOf(codecMode);
     * Drains the whole snapshot, the way the get-changes action does: the seqNo range query, the doc values reads and
    private Path indexPath;
            null,
import org.apache.lucene.util.IOUtils;
    public void setup() throws IOException {
        // IndexModule#INDEX_STORE_HYBRID_NIO_EXTENSIONS, which lists fdt and fdx.
import org.apache.lucene.search.Sort;
     * is gapless and ascending only for {@code CONTIGUOUS} - the property that decides whether a sequential read of
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.NAME, seqNo));
                        writer.commit();
public class LuceneChangesSnapshotBenchmark {
     */
        return new LuceneChangesSnapshot(searcher, LuceneChangesSnapshot.DEFAULT_BATCH_SIZE, 0, numOps - 1, true, true);
            throw new IllegalStateException("expected " + numOps + " operations but read " + read);
        }
    /**
import org.apache.lucene.search.ScoreDoc;
    /** Operations read per invocation. Every layout reads this many, only their placement differs. */
 *   <li>{@code INTERLEAVED} - segments flushed concurrently hold interleaved seqNo ranges, so reading in seqNo order
    /**
 * Benchmark for reading history from LuceneChangesSnapshot.
    }
import org.opensearch.index.translog.Translog;
            }
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
    @Param({ "2" })
    @Param({ "CONTIGUOUS", "STRIDED", "INTERLEAVED" })
            new BM25Similarity(),
        CONTIGUOUS,
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
        IOUtils.close(reader, directory);
import org.openjdk.jmh.annotations.Setup;
}
 *       {@code stride} parameter sets how far apart the reads are. While consecutive reads still share a compression
     * benchmark also compiles and runs against a baseline checkout.
import org.openjdk.jmh.annotations.Benchmark;
                    throw new AssertionError(layout);
import org.apache.lucene.search.IndexSearcher;
    }
        if (topDocs.scoreDocs.length != numOps) {
            );
            }
import org.apache.lucene.search.TopDocs;
        doc.add(new StoredField(SourceFieldMapper.NAME, new BytesRef(source(seqNo))));
        final byte[] bytes = new byte[docSizeBytes];
            while (snapshot.next() != null) {
import org.apache.lucene.index.IndexWriter;
        searcher.setQueryCache(null);
 *       segment's documents (for example an index with nested documents, whose child documents are excluded). The
            reader,
import org.apache.lucene.search.UsageTrackingQueryCachingPolicy;
import java.util.concurrent.TimeUnit;
import org.apache.lucene.search.SortField;
        }
                        for (int seqNo = segment; seqNo < numOps; seqNo += stride) {
     * else. Checks that the expected operations are all present and readable, and that the docID sequence in read order
    private void verifyLayout() throws IOException {
    @Benchmark
import org.opensearch.index.mapper.VersionFieldMapper;
 *       is the shape a sequential read is worth the most on.
import org.opensearch.index.mapper.IdFieldMapper;
                case INTERLEAVED:
                    }
                    }
                    break;
 * <ul>
import org.apache.lucene.search.TopFieldCollectorManager;
 * Run a single configuration with, for example:
            Translog.Operation op;
                        }
        );
import java.io.IOException;
 * which is what determines whether a sequential read is possible at all:
                    long filler = numOps;
     */
            .setRAMBufferSizeMB(512);
        boolean contiguous = true;
        return doc;
import org.openjdk.jmh.annotations.Scope;
 *
@Measurement(iterations = 5, time = 1)
 * The OpenSearch Contributors require contributions made to
                    for (int i = 0; i < numOps; i++) {
        final IndexWriterConfig config = new IndexWriterConfig().setCodec(new Lucene104Codec(mode))
import java.util.Random;
                            writer.addDocument(newDocument(filler++));
     */
import org.openjdk.jmh.annotations.State;
        if (read != numOps) {
        verifyLayout();
                    break;
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, 1L));
            new TopFieldCollectorManager(new Sort(new SortField(SeqNoFieldMapper.NAME, SortField.Type.LONG)), numOps, null, 0, false)
        doc.add(new NumericDocValuesField(VersionFieldMapper.NAME, 1L));
    }
import org.openjdk.jmh.annotations.Measurement;
import org.opensearch.core.index.shard.ShardId;
    /**
    }
import org.apache.lucene.index.IndexWriterConfig;
        return bytes;
    /**
            final ScoreDoc next = topDocs.scoreDocs[i + 1];
                default:
            }
            final ScoreDoc current = topDocs.scoreDocs[i];
     * compress perfectly, so this mixes a fixed pattern with random content to land somewhere realistic.
 * <p>The {@link Layout} parameter controls how the operations that get read are placed across docIDs and segments,
import org.apache.lucene.index.DirectoryReader;
            LongPoint.newRangeQuery(SeqNoFieldMapper.NAME, 0, numOps - 1),
    private byte[] source(long seqNo) {
                    }
import org.apache.lucene.index.NoMergePolicy;
import org.apache.lucene.store.Directory;
 *   <li>{@code STRIDED} - ascending but non-adjacent docIDs, as produced by a seqNo range that covers only part of a
            writer.commit();
            "benchmark",
        directory = new NIOFSDirectory(indexPath);
            switch (layout) {
import org.openjdk.jmh.annotations.BenchmarkMode;
 *
        );
package org.opensearch.index.engine;
import org.apache.lucene.document.NumericDocValuesField;
     * seqNo range is interleaved across (the flush fan-out). {@code 1} makes both layouts contiguous.
            // one segment per commit, so the layouts below are exactly what gets read
    @Param({ "BEST_SPEED", "BEST_COMPRESSION" })
    private int numOps;
 *
     * the stored fields reads for every operation.
        }
 */
            new UsageTrackingQueryCachingPolicy(),
import org.apache.lucene.document.LongPoint;
        if (contiguous != (layout == Layout.CONTIGUOUS)) {
        final Random random = new Random(seqNo);
        // OpenSearch's HybridDirectory reads stored fields through NIOFS rather than mmap by default; see
     * How the operations that will be read are laid out across docIDs and segments. See the class javadoc.
import org.openjdk.jmh.annotations.Param;
                read++;
                    // segments with interleaved seqNo ranges, as concurrently flushed segments have
 *       alternates between leaves while each leaf's own docIDs ascend. {@code stride} sets the flush fan-out.
        doc.add(new StoredField(IdFieldMapper.NAME, Uid.encodeId(Long.toString(seqNo))));
import org.apache.lucene.document.Document;
import org.openjdk.jmh.infra.Blackhole;
    private Directory directory;
                    for (int segment = 0; segment < stride; segment++) {
        doc.add(new LongPoint(SeqNoFieldMapper.NAME, seqNo));
@State(Scope.Benchmark)
    private String codecMode;
    }
     */
                        for (int gap = 1; gap < stride; gap++) {
                        }
        IOUtils.rm(indexPath);
        try (LuceneChangesSnapshot snapshot = newSnapshot()) {
    public enum Layout {
    @Param({ "256", "2048" })
import org.apache.lucene.search.similarities.BM25Similarity;
        indexPath = Files.createTempDirectory("lucene-changes-snapshot-benchmark");
import org.openjdk.jmh.annotations.Mode;
@Warmup(iterations = 3, time = 1)
    /**
        }
                    // seqNo == docID, one segment
import org.opensearch.index.mapper.SeqNoFieldMapper;
        final Document doc = new Document();
                break;
                contiguous = false;
            while ((op = snapshot.next()) != null) {
import org.openjdk.jmh.annotations.Warmup;
 * </ul>
    }
            if (current.doc + 1 != next.doc) {
    public void tearDown() throws IOException {
                    // one segment; the range that gets read covers every stride-th docID, the rest hold seqNos above it
                        writer.addDocument(newDocument(i));
    @Param({ "20000" })
                "layout [" + layout + "] with stride [" + stride + "] produced a contiguous read order of [" + contiguous + "]"
    private Document newDocument(long seqNo) {
 * <pre>
import org.openjdk.jmh.annotations.TearDown;
 *       block a sequential read keeps paying off; once the stride exceeds a block's document count each read
            () -> {} // the reader outlives the snapshot and is closed by tearDown
 */
    private DirectoryReader reader;
import org.opensearch.index.mapper.Uid;
        final TopDocs topDocs = searcher.search(
    private void buildIndex() throws IOException {
/**
    }
        for (int i = 0; i < bytes.length; i++) {
 * </pre>
            .setMergePolicy(NoMergePolicy.INSTANCE)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
 * SPDX-License-Identifier: Apache-2.0
     */
        buildIndex();
                    for (int i = 0; i < numOps; i++) {
        int read = 0;
        STRIDED,
                        writer.addDocument(newDocument(i));
                case STRIDED:
    @TearDown(Level.Trial)
 *
import org.openjdk.jmh.annotations.Level;
 * ./gradlew -p benchmarks run --args 'LuceneChangesSnapshotBenchmark -p layout=CONTIGUOUS -p docSizeBytes=256'
     * A pseudo-random payload of the requested size. Random bytes would not compress at all and identical bytes would
import org.apache.lucene.store.NIOFSDirectory;
import java.nio.file.Files;
    private int docSizeBytes;
            bytes[i] = (byte) (i % 8 == 0 ? random.nextInt(26) + 'a' : 'a' + (i % 26));
        for (int i = 0; i < topDocs.scoreDocs.length - 1; i++) {
        try (LuceneChangesSnapshot snapshot = newSnapshot()) {
        reader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(directory), SHARD_ID);
import org.apache.lucene.util.BytesRef;
            throw new IllegalStateException(
