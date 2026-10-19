    public void writerWorkload_8threads(Blackhole bh) {
    static final class LockableEntry implements Lockable {
        LockableEntry entry = queue.lockAndPoll();  
/*  
    }  
package org.opensearch.common.queue;
        writerWorkload(bh);
 * The OpenSearch Contributors require contributions made to  
    @Threads(16)  
public class LockableConcurrentQueueBenchmark {
    }
 * SPDX-License-Identifier: Apache-2.0
            queue.addAndUnlock(entry);  
        }
import java.util.concurrent.TimeUnit;
        return pollAndReturn();  
import java.util.LinkedList;
import org.openjdk.jmh.annotations.Threads;  
            LockableEntry entry = new LockableEntry();  
import org.openjdk.jmh.annotations.Level;
 * lock-and-poll / add-and-unlock cycles under varying concurrency levels.
    @Benchmark
    int poolSize;
        @Override
@Warmup(iterations = 5, time = 1)
        private final ReentrantLock lock = new ReentrantLock();  
@State(Scope.Benchmark)
    @Threads(4)  
@SuppressWarnings("unused")  
    }  
        @Override  
    @Benchmark  
    }  
    @Param({ "1", "4", "8" })  
        writerWorkload(bh);
 */
        }  
            result ^= (result >> 7);
            result ^= (result << 17);  
@Measurement(iterations = 10, time = 1)
            queue.addAndUnlock(entry);
            bh.consume(simulateWork(entry));
            lock.unlock();
@BenchmarkMode(Mode.Throughput)  
    @Setup(Level.Iteration)
import org.openjdk.jmh.annotations.OutputTimeUnit;
        queue = new LockableConcurrentQueue<>(LinkedList::new, concurrency);
    }
    public LockableEntry pollAndReturn_1thread() {
@Fork(3)  
import org.openjdk.jmh.annotations.Mode;  
    private LockableEntry pollAndReturn() {  
        }
 * compatible open source license.
import org.openjdk.jmh.annotations.State;
/**
    @Threads(8)
import org.openjdk.jmh.annotations.Benchmark;
    public void setup() {  
            entry.lock();
        LockableEntry entry = queue.lockAndPoll();
import org.openjdk.jmh.annotations.Fork;  
 * JMH benchmark for {@link LockableConcurrentQueue} measuring throughput of  
        return entry;
@OutputTimeUnit(TimeUnit.MICROSECONDS)
    public LockableEntry pollAndReturn_8threads() {
import org.openjdk.jmh.annotations.BenchmarkMode;
        }  
        }
        public void unlock() {
        return result;
 * this file be licensed under the Apache-2.0 license or a
    }
    int concurrency;
        if (entry != null) {
import org.openjdk.jmh.annotations.Scope;  
    }
    @Param({ "16", "64" })  
        long result = entry.hashCode();
            lock.lock();
    }
import java.util.concurrent.locks.ReentrantLock;  
 */  
    public void writerWorkload_4threads(Blackhole bh) {
    }  
            queue.addAndUnlock(entry);  
        }
    private static long simulateWork(LockableEntry entry) {
import org.openjdk.jmh.annotations.Setup;
 *
            result ^= (result << 13);
    @Benchmark
    }
    public LockableEntry pollAndReturn_4threads() {
            return lock.tryLock();  
    @Benchmark  
    @Threads(4)
        if (entry != null) {
}
import org.openjdk.jmh.annotations.Measurement;
        return pollAndReturn();  
    @Benchmark
    private void writerWorkload(Blackhole bh) {
        writerWorkload(bh);
import org.openjdk.jmh.annotations.Param;
        }
import org.openjdk.jmh.infra.Blackhole;
        for (int i = 0; i < 20; i++) {  
    public void writerWorkload_16threads(Blackhole bh) {
    private LockableConcurrentQueue<LockableEntry> queue;  
import org.openjdk.jmh.annotations.Warmup;
    @Threads(8)  
    @Threads(1)
    }  
        public void lock() {  
    @Benchmark  
        return pollAndReturn();  
        @Override
        public boolean tryLock() {
        for (int i = 0; i < poolSize; i++) {
