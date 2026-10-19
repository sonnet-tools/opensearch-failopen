    @OutputTimeUnit(TimeUnit.MICROSECONDS)  
 *   <li>Isolated checkout/return throughput at varying thread counts</li>  
 * this file be licensed under the Apache-2.0 license or a
    }
        @Override
    // ── Mixed workload: writers + periodic refresh (1s interval) ──
    @Group("mixed_7w_1r")
        bh.consume(simulateWork(e));  
    @Group("aggressive_3w_1r")  
        // Pre-warm the pool with more entries to populate multiple stripes
    public List<PoolEntry> refresh_latency_7w1r() {
 * SPDX-License-Identifier: Apache-2.0
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
import org.openjdk.jmh.annotations.Scope;
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(10));
    }
    @GroupThreads(8)  
@State(Scope.Benchmark)  
    @GroupThreads(7)
import org.openjdk.jmh.annotations.Fork;  
public class LockablePoolBenchmark {
        PoolEntry e = pool.getAndLock();
            pool.releaseAndUnlock(e);
        bh.consume(simulateWork(e));
    public void writers_latency_7w1r(Blackhole bh) {
        long result = entry.hashCode();
    // ── Isolated: pure writer throughput (no refresh contention) ──  
    // Measures per-operation latency distribution to capture tail latency  
    }
            lock.unlock();  
        PoolEntry e = pool.getAndLock();
    @GroupThreads(1)
    @BenchmarkMode(Mode.SampleTime)
        return pool.checkoutAll();
    public void writersOnly_4t(Blackhole bh) {
import org.openjdk.jmh.annotations.Warmup;
        for (int i = 0; i < 20; i++) {
    static final class PoolEntry implements Lockable {
            return lock.tryLock();
    @BenchmarkMode(Mode.Throughput)
            pool.releaseAndUnlock(e);
import org.openjdk.jmh.annotations.Setup;  
    @OutputTimeUnit(TimeUnit.MICROSECONDS)  
    @GroupThreads(7)  
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
import java.util.LinkedList;
        public void unlock() {
    // ── Aggressive refresh: 10ms interval to stress checkoutAll Phase 3 ──
        bh.consume(simulateWork(e));
    @BenchmarkMode(Mode.Throughput)  
        }
            result ^= (result >> 7);
    public void setup() {
    @Group("latency_7w_1r")
@Warmup(iterations = 2, time = 3)
    @Benchmark
 * </ul>
import org.openjdk.jmh.annotations.Param;
    int concurrency;
import org.openjdk.jmh.infra.Blackhole;  
    @GroupThreads(7)
        PoolEntry e = pool.getAndLock();  
    @Group("mixed_7w_1r")
        pool = new LockablePool<>(() -> new PoolEntry(counter.getAndIncrement()), LinkedList::new, concurrency);  
            this.id = id;  
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @BenchmarkMode(Mode.SampleTime)  
        bh.consume(simulateWork(e));  
        return pool.checkoutAll();
 *   <li>Writer latency during refresh contention (sample mode)</li>  
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(10));
/**  
    @BenchmarkMode(Mode.Throughput)
import java.util.concurrent.TimeUnit;
    }
            result ^= (result << 17);
        for (int i = 0; i < concurrency * 4; i++) {
    @GroupThreads(4)
    public List<PoolEntry> refresh_7w1r() throws InterruptedException {
        }  
    @Group("aggressive_3w_1r")
 * The OpenSearch Contributors require contributions made to  
 * <ul>
    @Benchmark
        public void lock() {
        pool.releaseAndUnlock(e);
        for (int i = 0; i < concurrency; i++) {
import java.util.List;  
    }  
    public void writersOnly_8t(Blackhole bh) {  
    @Benchmark
        @Override
    @OutputTimeUnit(TimeUnit.NANOSECONDS)  
        pool.releaseAndUnlock(e);  
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
@SuppressWarnings("unused")
    @BenchmarkMode(Mode.Throughput)  
    @Group("latency_7w_1r")  
        Thread.sleep(1000);  
        PoolEntry(int id) {
            result ^= (result << 13);  
        bh.consume(simulateWork(e));  
    // This makes checkoutAll fire ~100x/sec instead of 1x/sec, amplifying
    public void writers_3w1r(Blackhole bh) {  
    @Group("aggressive_7w_1r")  
import org.openjdk.jmh.annotations.Group;
        return pool.checkoutAll();
    @GroupThreads(3)  
    }
    // spikes caused by checkoutAll holding the pool lock.
/*  
    @BenchmarkMode(Mode.Throughput)
 */  
    }
import org.openjdk.jmh.annotations.State;
    @Benchmark  
@Measurement(iterations = 3, time = 5)
    public void writers_aggressive_3w1r(Blackhole bh) {
        pool.releaseAndUnlock(e);  
import org.openjdk.jmh.annotations.OutputTimeUnit;  
    }
    }
        PoolEntry e = pool.getAndLock();
        Thread.sleep(1000);  
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
            lock.lock();
        bh.consume(simulateWork(e));
        pool.releaseAndUnlock(e);
    public List<PoolEntry> refresh_aggressive_7w1r() {  
 *
        pool.releaseAndUnlock(e);
    @Group("writers_only_8t")
    @Group("aggressive_7w_1r")
import org.openjdk.jmh.annotations.BenchmarkMode;
    @BenchmarkMode(Mode.Throughput)
    @Benchmark
        }
    public List<PoolEntry> refresh_aggressive_3w1r() {  
    @Benchmark
    @Benchmark  
import org.openjdk.jmh.annotations.GroupThreads;
        public boolean tryLock() {  
    }
    @Param({ "4", "8" })
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
        }
    @BenchmarkMode(Mode.Throughput)
    private LockablePool<PoolEntry> pool;
 *   <li>Mixed workload: concurrent writers + periodic checkoutAll (refresh)</li>
    }
    }
import java.util.concurrent.atomic.AtomicInteger;
import org.openjdk.jmh.annotations.Level;  
    @GroupThreads(1)
    @Benchmark  
            PoolEntry e = pool.getAndLock();  
    @GroupThreads(1)
        }
        AtomicInteger counter = new AtomicInteger(0);
    @BenchmarkMode(Mode.Throughput)
        return pool.checkoutAll();
    public List<PoolEntry> refresh_3w1r() throws InterruptedException {
import java.util.concurrent.locks.ReentrantLock;
        final int id;
 * JMH benchmark for {@link LockablePool} measuring:
import org.openjdk.jmh.annotations.Measurement;
    @GroupThreads(1)  
    }  
    public void writers_aggressive_7w1r(Blackhole bh) {
    @Benchmark
    public void writers_7w1r(Blackhole bh) {  
    // Directly measures checkoutAll cost with a pre-populated pool.
            PoolEntry e = pool.getAndLock();  
    @Group("mixed_3w_1r")
        pool.releaseAndUnlock(e);  
import java.util.concurrent.locks.LockSupport;  
        @Override  
        PoolEntry e = pool.getAndLock();
        }  
    @GroupThreads(1)  
    // the difference between per-item remove (old) and bulk removeIf (new).  
}  
    }  
        return pool.checkoutAll();  
    @BenchmarkMode(Mode.Throughput)
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(10));
import org.openjdk.jmh.annotations.Benchmark;
        PoolEntry e = pool.getAndLock();
        }
    @BenchmarkMode(Mode.Throughput)
 *   <li>Aggressive refresh: frequent checkoutAll to stress Phase 3 bulk cleanup</li>
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    private static long simulateWork(PoolEntry entry) {  
    @Setup(Level.Iteration)  
import org.openjdk.jmh.annotations.Mode;
    @OutputTimeUnit(TimeUnit.MICROSECONDS)  
    @Benchmark  
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    // ── Writer latency during refresh contention (sample mode) ──
        private final ReentrantLock lock = new ReentrantLock();  
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    }  
@Fork(2)  
 */
        PoolEntry e = pool.getAndLock();
    // ── Isolated checkoutAll throughput (no writers) ──  
    public List<PoolEntry> checkoutAll_isolated() {  
    @Group("writers_only_4t")  
    @Benchmark
 * compatible open source license.
        pool.releaseAndUnlock(e);
        // Re-populate pool before each checkout
    @GroupThreads(3)
        bh.consume(simulateWork(e));
    @Benchmark
        return pool.checkoutAll();  
    }
        return result;
    @Group("mixed_3w_1r")
package org.opensearch.common.queue;
