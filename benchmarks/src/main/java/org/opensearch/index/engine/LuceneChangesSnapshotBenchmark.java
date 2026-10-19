                        }
                    // seqNo == docID, one segment
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.NAME, seqNo));
import org.apache.lucene.store.NIOFSDirectory;
 */  
    private void buildIndex() throws IOException {
    /**
import org.opensearch.index.translog.Translog;
import org.openjdk.jmh.infra.Blackhole;
        }
    public enum Layout {
        final TopDocs topDocs = searcher.search(  
        // OpenSearch's HybridDirectory reads stored fields through NIOFS rather than mmap by default; see  
    private byte[] source(long seqNo) {
                        writer.commit();
        return doc;
import org.apache.lucene.util.BytesRef;
import org.openjdk.jmh.annotations.Param;
     * seqNo range is interleaved across (the flush fan-out). {@code 1} makes both layouts contiguous.
        doc.add(new LongPoint(SeqNoFieldMapper.NAME, seqNo));  
@State(Scope.Benchmark)
                    }
     * Drains the whole snapshot, the way the get-changes action does: the seqNo range query, the doc values reads and  
 *       decompresses a block with nothing to amortize it against, and a per-document read is cheaper.
     * compress perfectly, so this mixes a fixed pattern with random content to land somewhere realistic.  
            // one segment per commit, so the layouts below are exactly what gets read
     * benchmark also compiles and runs against a baseline checkout.
 *
import org.opensearch.index.mapper.SourceFieldMapper;
import org.openjdk.jmh.annotations.Mode;
            }
    /**
import org.apache.lucene.document.StoredField;
    @Param({ "BEST_SPEED", "BEST_COMPRESSION" })  
    }
 * which is what determines whether a sequential read is possible at all:
import org.apache.lucene.store.Directory;  
 *       alternates between leaves while each leaf's own docIDs ascend. {@code stride} sets the flush fan-out.  
 */
import org.apache.lucene.index.IndexWriterConfig;
        return bytes;
    }
        IOUtils.close(reader, directory);
            writer.commit();
    /**
    @Param({ "256", "2048" })  
            new BM25Similarity(),
        doc.add(new StoredField(IdFieldMapper.NAME, Uid.encodeId(Long.toString(seqNo))));
     */  
                break;
        doc.add(new NumericDocValuesField(VersionFieldMapper.NAME, 1L));  
        verifyLayout();
 * ./gradlew -p benchmarks run --args 'LuceneChangesSnapshotBenchmark -p layout=CONTIGUOUS -p docSizeBytes=256'
 * Run a single configuration with, for example:  
                    for (int i = 0; i < numOps; i++) {
import org.openjdk.jmh.annotations.Measurement;
        }
            while ((op = snapshot.next()) != null) {
            throw new IllegalStateException("expected " + numOps + " hits but got " + topDocs.scoreDocs.length);
                    for (int i = 0; i < numOps; i++) {  
 * </ul>
    @Benchmark  
import org.apache.lucene.search.TopFieldCollectorManager;  
        int read = 0;  
import org.apache.lucene.search.TopDocs;
        directory = new NIOFSDirectory(indexPath);
    }  
    /**
            );
    public void drainSnapshot(Blackhole bh) throws IOException {
@OutputTimeUnit(TimeUnit.MILLISECONDS)  
            bytes[i] = (byte) (i % 8 == 0 ? random.nextInt(26) + 'a' : 'a' + (i % 26));  
        CONTIGUOUS,
        );  
            "benchmark",  
import org.openjdk.jmh.annotations.TearDown;
     */
        boolean contiguous = true;
    private Path indexPath;
                case INTERLEAVED:
 * this file be licensed under the Apache-2.0 license or a
     * A pseudo-random payload of the requested size. Random bytes would not compress at all and identical bytes would
    }  
    private Directory directory;  
import java.nio.file.Files;
            switch (layout) {
import java.util.concurrent.TimeUnit;
            () -> {} // the reader outlives the snapshot and is closed by tearDown
    }
            new TopFieldCollectorManager(new Sort(new SortField(SeqNoFieldMapper.NAME, SortField.Type.LONG)), numOps, null, 0, false)
                    break;  
                        writer.addDocument(newDocument(i));  
                    // segments with interleaved seqNo ranges, as concurrently flushed segments have
 * <pre>
                bh.consume(op);
     * the stored fields reads for every operation.
import org.apache.lucene.search.similarities.BM25Similarity;
import org.openjdk.jmh.annotations.BenchmarkMode;
    }  
            }  
    private Layout layout;
import org.openjdk.jmh.annotations.Scope;
        reader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(directory), SHARD_ID);
import org.apache.lucene.document.LongPoint;  
                    // one segment; the range that gets read covers every stride-th docID, the rest hold seqNos above it
                    for (int segment = 0; segment < stride; segment++) {  
 *
     * is gapless and ascending only for {@code CONTIGUOUS} - the property that decides whether a sequential read of
    }  
                            writer.addDocument(newDocument(filler++));  
     * stored fields is possible. Deliberately asserts on the index rather than on the snapshot's internals, so this  
import java.io.IOException;  
public class LuceneChangesSnapshotBenchmark {
        }
    private static final ShardId SHARD_ID = new ShardId("index", "_na_", 0);  
        }  
            .setRAMBufferSizeMB(512);  
 *   <li>{@code CONTIGUOUS} - an append-only history in one segment, read as one gapless ascending run of docIDs. This
import org.apache.lucene.index.IndexWriter;
        buildIndex();  
package org.opensearch.index.engine;
 *       is the shape a sequential read is worth the most on.
            reader,
import org.apache.lucene.search.Sort;  
        indexPath = Files.createTempDirectory("lucene-changes-snapshot-benchmark");
    private DirectoryReader reader;
import org.opensearch.core.index.shard.ShardId;
import java.nio.file.Path;
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, 1L));
                        for (int seqNo = segment; seqNo < numOps; seqNo += stride) {
import org.openjdk.jmh.annotations.Setup;  
 *
import org.apache.lucene.util.IOUtils;  
                        writer.addDocument(newDocument(i));
 * SPDX-License-Identifier: Apache-2.0
 *       segment's documents (for example an index with nested documents, whose child documents are excluded). The
     * For {@code STRIDED}, how many docIDs apart consecutive reads are; for {@code INTERLEAVED}, how many segments the  
    private int docSizeBytes;
    @TearDown(Level.Trial)
    private void verifyLayout() throws IOException {  
        return new LuceneChangesSnapshot(searcher, LuceneChangesSnapshot.DEFAULT_BATCH_SIZE, 0, numOps - 1, true, true);
        }
        searcher.setQueryCache(null);
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
                contiguous = false;  
        try (IndexWriter writer = new IndexWriter(directory, config)) {
        final Lucene104Codec.Mode mode = Lucene104Codec.Mode.valueOf(codecMode);
        if (contiguous != (layout == Layout.CONTIGUOUS)) {
 * <ul>  
@BenchmarkMode(Mode.AverageTime)
    private int numOps;  
            while (snapshot.next() != null) {
        final IndexSearcher searcher = new IndexSearcher(reader);
        if (read != numOps) {  
            }
import org.apache.lucene.index.DirectoryReader;  
        doc.add(new StoredField(SourceFieldMapper.NAME, new BytesRef(source(seqNo))));
        if (topDocs.scoreDocs.length != numOps) {
    public void tearDown() throws IOException {  
/**  
 *
import org.apache.lucene.document.Document;
        }
    /** Operations read per invocation. Every layout reads this many, only their placement differs. */
import org.openjdk.jmh.annotations.Level;  
                        for (int gap = 1; gap < stride; gap++) {
import org.opensearch.index.mapper.Uid;  
        final Engine.Searcher searcher = new Engine.Searcher(
 * Benchmark for reading history from LuceneChangesSnapshot.
                    break;  
import org.apache.lucene.search.ScoreDoc;
@Measurement(iterations = 5, time = 1)
import org.apache.lucene.search.UsageTrackingQueryCachingPolicy;
import java.util.Random;  
        final byte[] bytes = new byte[docSizeBytes];  
    /**
        IOUtils.rm(indexPath);
            throw new IllegalStateException("expected " + numOps + " operations but read " + read);
        STRIDED,  
/*  
            }  
import org.openjdk.jmh.annotations.Benchmark;  
                default:
                    throw new AssertionError(layout);
                case CONTIGUOUS:  
    @Param({ "CONTIGUOUS", "STRIDED", "INTERLEAVED" })  
import org.apache.lucene.document.NumericDocValuesField;
     * else. Checks that the expected operations are all present and readable, and that the docID sequence in read order
    private int stride;
        INTERLEAVED
                    break;
import org.openjdk.jmh.annotations.OutputTimeUnit;  
import org.apache.lucene.search.SortField;
}
import org.opensearch.index.mapper.IdFieldMapper;  
    @Setup(Level.Trial)  
@Warmup(iterations = 3, time = 1)  
            throw new IllegalStateException(
            LongPoint.newRangeQuery(SeqNoFieldMapper.NAME, 0, numOps - 1),
 * </pre>  
                read++;  
import org.apache.lucene.search.IndexSearcher;
            final ScoreDoc next = topDocs.scoreDocs[i + 1];
    @Param({ "20000" })
        for (int i = 0; i < topDocs.scoreDocs.length - 1; i++) {
        final Random random = new Random(seqNo);
        // IndexModule#INDEX_STORE_HYBRID_NIO_EXTENSIONS, which lists fdt and fdx.
import org.openjdk.jmh.annotations.Fork;
 *   <li>{@code INTERLEAVED} - segments flushed concurrently hold interleaved seqNo ranges, so reading in seqNo order
    private LuceneChangesSnapshot newSnapshot() throws IOException {
    @Param({ "2" })  
        }
            new UsageTrackingQueryCachingPolicy(),
                        }  
    }
import org.openjdk.jmh.annotations.Warmup;  
                case STRIDED:  
 *   <li>{@code STRIDED} - ascending but non-adjacent docIDs, as produced by a seqNo range that covers only part of a  
     * Fails fast if the index does not have the shape the layout intends, so a run cannot quietly measure something  
import org.apache.lucene.index.NoMergePolicy;  
        final Document doc = new Document();  
        );  
    }  
        }  
        final IndexWriterConfig config = new IndexWriterConfig().setCodec(new Lucene104Codec(mode))  
 *       {@code stride} parameter sets how far apart the reads are. While consecutive reads still share a compression
     */
import org.opensearch.index.mapper.SeqNoFieldMapper;
        try (LuceneChangesSnapshot snapshot = newSnapshot()) {
            null,  
     */
            final ScoreDoc current = topDocs.scoreDocs[i];  
import org.openjdk.jmh.annotations.State;
    public void setup() throws IOException {
 * The OpenSearch Contributors require contributions made to  
    private Document newDocument(long seqNo) {
        for (int i = 0; i < bytes.length; i++) {
            .setMergePolicy(NoMergePolicy.INSTANCE)
 *       block a sequential read keeps paying off; once the stride exceeds a block's document count each read  
@Fork(value = 1, jvmArgsAppend = { "-Xms2g", "-Xmx2g" })
import org.opensearch.index.mapper.VersionFieldMapper;
 * compatible open source license.
        try (LuceneChangesSnapshot snapshot = newSnapshot()) {
                    }
     */
     * How the operations that will be read are laid out across docIDs and segments. See the class javadoc.
                            writer.addDocument(newDocument(seqNo));
                    long filler = numOps;
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
    private String codecMode;
                "layout [" + layout + "] with stride [" + stride + "] produced a contiguous read order of [" + contiguous + "]"  
            if (current.doc + 1 != next.doc) {
            Translog.Operation op;  
                    }
 * <p>The {@link Layout} parameter controls how the operations that get read are placed across docIDs and segments,  
