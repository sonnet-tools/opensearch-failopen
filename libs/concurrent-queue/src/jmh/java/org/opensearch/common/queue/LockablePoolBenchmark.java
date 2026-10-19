import org.openjdk.jmh.annotations.Fork;
        for (int i = 0; i < concurrency; i++) {
        PoolEntry e = pool.getAndLock();
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
        return pool.checkoutAll();
        PoolEntry e = pool.getAndLock();
    }
    public void setup() {
    @Benchmark
        AtomicInteger counter = new AtomicInteger(0);
    @GroupThreads(4)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @GroupThreads(7)
    // Directly measures checkoutAll cost with a pre-populated pool.
public class LockablePoolBenchmark {
import org.openjdk.jmh.annotations.Mode;
    @Group("mixed_7w_1r")
    @BenchmarkMode(Mode.Throughput)
    @BenchmarkMode(Mode.Throughput)
    // ── Isolated checkoutAll throughput (no writers) ──
        return pool.checkoutAll();
    }
        Thread.sleep(1000);
    }
        PoolEntry e = pool.getAndLock();
    public List<PoolEntry> refresh_3w1r() throws InterruptedException {
import org.openjdk.jmh.annotations.Scope;
    @GroupThreads(1)
        }
        @Override
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Benchmark
 * compatible open source license.
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
import org.openjdk.jmh.annotations.Warmup;
/*
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(10));
    @Group("aggressive_7w_1r")
    @Group("latency_7w_1r")
    }
 *   <li>Aggressive refresh: frequent checkoutAll to stress Phase 3 bulk cleanup</li>
import java.util.concurrent.TimeUnit;
    // ── Aggressive refresh: 10ms interval to stress checkoutAll Phase 3 ──
    public List<PoolEntry> refresh_aggressive_3w1r() {
        // Re-populate pool before each checkout
    @GroupThreads(3)
import org.openjdk.jmh.infra.Blackhole;
    public void writers_3w1r(Blackhole bh) {
        }
    @GroupThreads(1)
        long result = entry.hashCode();
import java.util.concurrent.atomic.AtomicInteger;
    @Benchmark
@Measurement(iterations = 3, time = 5)
    }
        PoolEntry e = pool.getAndLock();
/**
import org.openjdk.jmh.annotations.BenchmarkMode;
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @GroupThreads(8)
    @BenchmarkMode(Mode.SampleTime)
        }
@State(Scope.Benchmark)
    static final class PoolEntry implements Lockable {
            lock.lock();
        }
        public void lock() {
    @BenchmarkMode(Mode.AverageTime)
        pool.releaseAndUnlock(e);
    // This makes checkoutAll fire ~100x/sec instead of 1x/sec, amplifying
 * </ul>
        return result;
    @GroupThreads(7)
import org.openjdk.jmh.annotations.Benchmark;
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
        final int id;
 * SPDX-License-Identifier: Apache-2.0
    }
    @Group("aggressive_7w_1r")
    // ── Writer latency during refresh contention (sample mode) ──
            PoolEntry e = pool.getAndLock();
    @Group("writers_only_8t")
        return pool.checkoutAll();
@Warmup(iterations = 2, time = 3)
        return pool.checkoutAll();
        pool.releaseAndUnlock(e);
    @Group("latency_7w_1r")
        pool.releaseAndUnlock(e);
    @GroupThreads(3)
    // spikes caused by checkoutAll holding the pool lock.
    @Group("aggressive_3w_1r")
import org.openjdk.jmh.annotations.Level;
    @Benchmark
            pool.releaseAndUnlock(e);
    @Group("writers_only_4t")
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
 * JMH benchmark for {@link LockablePool} measuring:
    }
            lock.unlock();
    // ── Mixed workload: writers + periodic refresh (1s interval) ──
    @Group("mixed_3w_1r")
        pool = new LockablePool<>(() -> new PoolEntry(counter.getAndIncrement()), LinkedList::new, concurrency);
    @BenchmarkMode(Mode.Throughput)
    @BenchmarkMode(Mode.Throughput)
    }
    }
    private LockablePool<PoolEntry> pool;
        for (int i = 0; i < 20; i++) {
        }
 */
        pool.releaseAndUnlock(e);
        bh.consume(simulateWork(e));
import org.openjdk.jmh.annotations.State;
    @Benchmark
import org.openjdk.jmh.annotations.Measurement;
            pool.releaseAndUnlock(e);
        public boolean tryLock() {
import java.util.List;
        return pool.checkoutAll();
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
import org.openjdk.jmh.annotations.GroupThreads;
            result ^= (result << 17);
    }
    @Param({ "4", "8" })
package org.opensearch.common.queue;
    @GroupThreads(7)
}
            return lock.tryLock();
        }
import org.openjdk.jmh.annotations.Setup;
 */
    public void writers_aggressive_3w1r(Blackhole bh) {
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
        bh.consume(simulateWork(e));
        PoolEntry(int id) {
            result ^= (result >> 7);
            result ^= (result << 13);
        bh.consume(simulateWork(e));
    public List<PoolEntry> refresh_7w1r() throws InterruptedException {
    @BenchmarkMode(Mode.Throughput)
@SuppressWarnings("unused")
        bh.consume(simulateWork(e));
    public List<PoolEntry> refresh_latency_7w1r() {
    public void writers_latency_7w1r(Blackhole bh) {
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(10));
    @BenchmarkMode(Mode.Throughput)
        @Override
        bh.consume(simulateWork(e));
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
        PoolEntry e = pool.getAndLock();
 *   <li>Mixed workload: concurrent writers + periodic checkoutAll (refresh)</li>
import java.util.concurrent.locks.ReentrantLock;
    public void writersOnly_4t(Blackhole bh) {
 * The OpenSearch Contributors require contributions made to
    public void writersOnly_8t(Blackhole bh) {
        pool.releaseAndUnlock(e);
import java.util.concurrent.locks.LockSupport;
@Fork(2)
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
        Thread.sleep(1000);
    @Benchmark
        return pool.checkoutAll();
        pool.releaseAndUnlock(e);
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < concurrency * 4; i++) {
    @GroupThreads(1)
    int concurrency;
        public void unlock() {
    // ── Isolated: pure writer throughput (no refresh contention) ──
    @Benchmark
        }
    }
    public void writers_7w1r(Blackhole bh) {
        private final ReentrantLock lock = new ReentrantLock();
        bh.consume(simulateWork(e));
    @Benchmark
 *
    @BenchmarkMode(Mode.Throughput)
    @GroupThreads(1)
import org.openjdk.jmh.annotations.Group;
    // Measures per-operation latency distribution to capture tail latency
import org.openjdk.jmh.annotations.Param;
    @BenchmarkMode(Mode.Throughput)
    @GroupThreads(1)
    @BenchmarkMode(Mode.Throughput)
    @Benchmark
    }
    @Group("mixed_7w_1r")
    @Benchmark
        PoolEntry e = pool.getAndLock();
        @Override
    }
    }
    @Benchmark
    public List<PoolEntry> refresh_aggressive_7w1r() {
        PoolEntry e = pool.getAndLock();
    @BenchmarkMode(Mode.Throughput)
    @Benchmark
    }
 *   <li>Isolated checkout/return throughput at varying thread counts</li>
    @Benchmark
            PoolEntry e = pool.getAndLock();
    private static long simulateWork(PoolEntry entry) {
    public void writers_aggressive_7w1r(Blackhole bh) {
import java.util.LinkedList;
        bh.consume(simulateWork(e));
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(10));
        pool.releaseAndUnlock(e);
        // Pre-warm the pool with more entries to populate multiple stripes
 *   <li>Writer latency during refresh contention (sample mode)</li>
    @Setup(Level.Iteration)
import org.openjdk.jmh.annotations.OutputTimeUnit;
    @Group("aggressive_3w_1r")
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Group("mixed_3w_1r")
    // the difference between per-item remove (old) and bulk removeIf (new).
    }
            this.id = id;
    public List<PoolEntry> checkoutAll_isolated() {
 * <ul>
