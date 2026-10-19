            config,  
    private Translog translog;  
            ops.add(new Translog.Index(id, seqNo, PRIMARY_TERM, source));
@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
 * <p>  
    /** Operations per add call. 1 is the control (batch == single). */  
import java.nio.file.Path;  
    /** Add the batch one operation at a time (the current bulk path). */  
import java.util.concurrent.TimeUnit;  
 * ./gradlew -p benchmarks run --args 'TranslogBatchAddBenchmark -prof gc -f 1 -wi 3 -i 5 -t 8'
 * <p>  
import org.opensearch.index.translog.LocalTranslog;
 * Thread count is passed on the command line ({@code -t 1} and {@code -t 8}); all threads share one translog, so at
        return translog.add(nextOps());
import org.opensearch.index.translog.TranslogDeletionPolicy;
    public void setup() throws IOException {
        );  
 * <pre>
import java.util.ArrayList;
    @Param({ "1", "10", "100", "500" })
                } catch (IOException ignored) {}  
        if (translog != null) {
        try (java.util.stream.Stream<Path> files = Files.walk(dir)) {
            BigArrays.NON_RECYCLING_INSTANCE,  
            translog.close();
        final List<Translog.Operation> ops = nextOps();
    public Object singleAddLoop() throws IOException {  
import org.opensearch.index.translog.TranslogConfig;
import org.opensearch.common.settings.Settings;
        for (int i = 0; i < batchSize; i++) {  
import org.openjdk.jmh.annotations.Fork;  
import org.openjdk.jmh.annotations.Scope;
            // cheap deterministic fill; keeps the array from being a shared constant the JIT could hoist  
 * operations one at a time. A single add allocates a fresh {@code ReleasableBytesStreamOutput} per op, takes the
    }  
        final TranslogConfig config = new TranslogConfig(
import org.opensearch.index.translog.DefaultTranslogDeletionPolicy;
        final long base = seqNoAllocator.getAndAdd(batchSize);
            .settings(settings)  
            dir,
        );
    }
    /** Approximate http_logs document source size in bytes. */
@OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Setup(Level.Trial)  
import org.openjdk.jmh.annotations.Measurement;
 * interesting columns are time per op (ns/op) and {@code gc.alloc.rate.norm} (B/op) from {@code -prof gc}.
            .numberOfShards(1)
    private Path dir;
        final ShardId shardId = new ShardId(new Index("bench-index", "bench-uuid"), 0);  
            seqNo -> {},
public class TranslogBatchAddBenchmark {
 * compatible open source license.
            false
import org.opensearch.cluster.metadata.IndexMetadata;
    private static final int SOURCE_SIZE = 300;
    private static final long PRIMARY_TERM = 1L;  
            shardId,
    @Benchmark
        final TranslogDeletionPolicy deletionPolicy = new DefaultTranslogDeletionPolicy(-1, -1, 0);
            final byte[] source = new byte[SOURCE_SIZE];
import java.io.IOException;
        final List<Translog.Operation> ops = new ArrayList<>(batchSize);
            final String id = Long.toString(seqNo);  
import org.opensearch.core.index.Index;
}  
            () -> org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED,  
            () -> PRIMARY_TERM,
 * Measures the CPU/allocation cost that a batched {@code Translog.add(List)} removes relative to adding the same
    }  
    @OperationsPerInvocation(1)
        for (int i = 0; i < ops.size(); i++) {  
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
        final IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
        dir = Files.createTempDirectory("translog-batch-bench");
        Translog.Location last = null;
        final String translogUUID = Translog.createEmptyTranslog(
            translogUUID,
import org.opensearch.common.util.BigArrays;  
            source[0] = (byte) seqNo;
 * </pre>
            source[SOURCE_SIZE - 1] = (byte) (seqNo >>> 8);
 * translog read lock per op, and enters the {@code TranslogWriter} monitor per op; the batch does each of those  
    private final AtomicLong seqNoAllocator = new AtomicLong(0);
@State(Scope.Benchmark)  
/**  
            TranslogOperationHelper.DEFAULT,  
    public void tearDown() throws IOException {  
import org.openjdk.jmh.annotations.State;  
    @OperationsPerInvocation(1)
            null
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.index.shard.ShardId;
        translog = new LocalTranslog(
    private List<Translog.Operation> nextOps() {  
            final long seqNo = base + i;
 * once for the whole batch. The on-disk bytes are identical either way (verified by the unit test), so the
import org.openjdk.jmh.annotations.Level;
 * this file be licensed under the Apache-2.0 license or a
    /** Add the whole batch in one call (the proposed path). */  
import org.opensearch.index.translog.Translog;  
        }
            });
    @TearDown(Level.Trial)
            .numberOfReplicas(0)
    }
        final Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT).build();
import java.util.concurrent.atomic.AtomicLong;
@BenchmarkMode(Mode.AverageTime)
            files.sorted(java.util.Comparator.reverseOrder()).forEach(p -> {  
package org.opensearch.benchmark.index.translog;
 * ./gradlew -p benchmarks run --args 'TranslogBatchAddBenchmark -prof gc -f 1 -wi 3 -i 5 -t 1'  
            deletionPolicy,
        return last;  
        return ops;  
    public Object batchAdd() throws IOException {  
        final IndexMetadata indexMetadata = IndexMetadata.builder("bench-index")
    /** Build a fresh batch of ops with a thread-unique, monotonically increasing seqNo range. */
    @Benchmark
 * SPDX-License-Identifier: Apache-2.0
import org.openjdk.jmh.annotations.Mode;  
            indexSettings,
    public int batchSize;
            PRIMARY_TERM  
import org.openjdk.jmh.annotations.TearDown;
/*  
        }
import org.openjdk.jmh.annotations.Benchmark;
            dir,  
 * Run with:
                    Files.deleteIfExists(p);
 */  
import org.openjdk.jmh.annotations.OperationsPerInvocation;
            org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED,
    }
import org.opensearch.index.translog.TranslogOperationHelper;  
import org.openjdk.jmh.annotations.Setup;
import org.opensearch.index.IndexSettings;  
import org.openjdk.jmh.annotations.Param;  
            last = translog.add(ops.get(i));
 */  
 * {@code -t 8} the read-lock and writer-monitor contention this change targets is exercised directly.
import org.openjdk.jmh.annotations.Warmup;
        // best-effort cleanup of the generation files
@Fork(value = 1, jvmArgsAppend = { "-Xms2g", "-Xmx2g" })  
            "bench-node",
import org.openjdk.jmh.annotations.OutputTimeUnit;
import java.nio.file.Files;
        }
        );
import java.util.List;
        }  
                try {
 *
            .build();  
import org.openjdk.jmh.annotations.BenchmarkMode;
            shardId,  
