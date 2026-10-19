import java.util.Random;  
    }
            try (OffsetRangeInputStream part = supplier.get(partSize, position)) {
 * its own range directly off the file. Nothing file-sized is ever on the heap.  
     * Reads every part the uploader would read, in order, and folds the bytes into a checksum.
import org.openjdk.jmh.annotations.BenchmarkMode;
 * <p>
// its regions off the heap by default, which would make the humongous threshold vary per machine.  
     * 4 MiB stays under G1's humongous threshold, 16 MiB sits on it, 64 MiB is what a real big5  
/*  
        try (InputStream inputStream = Files.newInputStream(tlog)) {
        final long contentLength = content.length;
    public long buffered() throws IOException {
        Files.deleteIfExists(dir);  
        );  
        // producing identical bytes, the allocation comparison is meaningless.
        Files.write(tlog, content);
 */
import org.openjdk.jmh.annotations.Level;  
public class TranslogUploadStreamBenchmark {  
 * <pre>
 * {@link #streamed} is what it does now: ask the snapshot for a supplier and let each part read
 * ./gradlew -p benchmarks run --args 'TranslogUploadStreamBenchmark -prof gc -f 1 -wi 3 -i 5'  
            }
            content = inputStream.readAllBytes();
                int read;
import org.openjdk.jmh.annotations.Benchmark;  
        }  
 * for {@code buffered} and a small part-sized constant for {@code streamed}.
            size,
    /** Post-change behaviour: the snapshot supplies part streams straight off the file. */
 * <p>
 * allocation that lands straight in old gen.  
/**  
        new Random(20260915L).nextBytes(content);  
    private Path dir;  
// 16m regions put that threshold at 8 MiB, matching a production 31g heap.
                while ((read = part.read(scratch, 0, scratch.length)) != -1) {  
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeIndexInputStream;
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
import org.openjdk.jmh.annotations.Param;
                    for (int i = 0; i < read; i += 512) {
        RemoteTransferContainer.OffsetRangeInputStreamSupplier supplier = (size, position) -> new OffsetRangeIndexInputStream(
import java.nio.file.Path;
import org.openjdk.jmh.annotations.Fork;
 * Run with:
 * this file be licensed under the Apache-2.0 license or a
        return checksum;
    /** Pre-change behaviour: one file-sized heap array, every part sliced out of it. */  
import org.openjdk.jmh.annotations.OutputTimeUnit;  
        tlog = dir.resolve("translog-" + GENERATION + ".tlog");
import org.opensearch.common.blobstore.transfer.RemoteTransferContainer;
@State(Scope.Benchmark)
        long checksum = 0;  
        dir = Files.createTempDirectory("translog-upload-bench");
@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)  
     */
        }  
        // Guard against benchmarking two things that are not equivalent: if the arms ever stop  
 * size of the file, so on a 31g heap (16 MiB G1 regions) anything past 8 MiB is a humongous
        Files.deleteIfExists(tlog);
    public long streamed() throws IOException {  
            throw new AssertionError("arms disagree: buffered=" + bufferedSum + " streamed=" + streamedSum);
        try (FileSnapshot.TranslogFileSnapshot snapshot = new FileSnapshot.TranslogFileSnapshot(PRIMARY_TERM, GENERATION, tlog, null)) {
        for (long position = 0; position < contentLength; position += PART_SIZE) {
import java.nio.file.Files;
        byte[] scratch = new byte[8192];
    public void tearDown() throws IOException {
    private static final long PART_SIZE = 16L * 1024 * 1024;
    @Benchmark
    @Param({ "4194304", "16777216", "67108864", "268435456" })  
@OutputTimeUnit(TimeUnit.MILLISECONDS)
import java.util.concurrent.TimeUnit;
 * Compares the two ways a translog file can be handed to a multipart (async) upload.
        }  
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeInputStream;  
    @Setup(Level.Trial)  
import org.openjdk.jmh.annotations.Scope;
            position
    @TearDown(Level.Trial)  
import org.openjdk.jmh.annotations.TearDown;
        byte[] content = new byte[fileSize];
// Pin the heap and the G1 region size: the whole point is where an allocation lands, and G1 sizes
            long partSize = Math.min(PART_SIZE, contentLength - position);  
 * </pre>
        }  
package org.opensearch.benchmark.index.translog;
 * <p>  
    /**
}  
    /**  
                }
 * SPDX-License-Identifier: Apache-2.0
    }
                    // Strided rather than per-byte: enough of a data dependency on the buffer that
        if (bufferedSum != streamedSum) {
import org.openjdk.jmh.annotations.Warmup;  
     * generation looked like, 256 MiB is what a slow-syncing shard can reach.
import java.io.InputStream;  
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
            new ByteArrayIndexInput(tlog.getFileName().toString(), content),  
    }
     * The checksum is returned rather than discarded so the JIT cannot elide the reads and turn
import java.io.IOException;
    }
import org.openjdk.jmh.annotations.Measurement;
@Fork(value = 1, jvmArgsAppend = { "-Xms4g", "-Xmx4g", "-XX:+UseG1GC", "-XX:G1HeapRegionSize=16m" })
import org.opensearch.index.translog.transfer.FileSnapshot;
    @Benchmark
        long bufferedSum = buffered();
        final byte[] content;  
    public int fileSize;
                        checksum = checksum * 31 + scratch[i];
    private Path tlog;
 * The OpenSearch Contributors require contributions made to  
     * the comparison into a measurement of nothing.  
 * {@link #buffered} is what the transfer service used to do: read the whole {@code .tlog} onto the  
                    // the reads cannot be optimised away, without the folding cost dominating the
 */  
    public void setup() throws IOException {
    private long drainAllParts(RemoteTransferContainer.OffsetRangeInputStreamSupplier supplier, long contentLength) throws IOException {
 * {@link #setup}, so the interesting column is <b>{@code gc.alloc.rate.norm}</b> (bytes allocated  
        long streamedSum = streamed();  
    }
import org.openjdk.jmh.annotations.Mode;
 * <p>
import org.openjdk.jmh.annotations.Setup;  
@BenchmarkMode(Mode.AverageTime)  
                    }  
            return drainAllParts(snapshot.offsetRangeInputStreamSupplier(), snapshot.getContentLength());
 * heap with {@code readAllBytes()}, then serve every part out of that one array. The array is the
    private static final long GENERATION = 7L;
    /** Part size the S3 uploader would use, so the part count is realistic. */  
import org.openjdk.jmh.annotations.State;
        return drainAllParts(supplier, contentLength);
                    // measurement at 256 MiB.  
     */
    private static final long PRIMARY_TERM = 1L;  
 * compatible open source license.
        // The transfer service asserts on the "-<generation>." shape of the name, so keep it real.  
 *
 * Both variants hand the uploader identical bytes and are verified byte-for-byte equal in
 * per operation) from {@code -prof gc}, not the timing. Expect roughly {@code fileSize} bytes/op
