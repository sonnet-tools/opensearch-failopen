        path = PathUtils.get(createTempDir().toString());
            @Override
import java.io.EOFException;
        final ParallelDownloadPermits permits = new ParallelDownloadPermits(8);
        release.countDown();
            return new FilterInputStream(super.readBlob(blobName, position, length)) {
        try (
                    }
            } catch (InterruptedException e) {
import static org.hamcrest.Matchers.equalTo;
        final ParallelDownloadPermits permits = new ParallelDownloadPermits(3);
        while ((n = in.read(buf, 0, buf.length)) != -1) {
                System.arraycopy(rest, 0, read, first.length, rest.length);
            partSize,
            read = readFully(in, randomIntBetween(1, 64 * 1024));
            container,
                return super.readBlob(name, position, length);
import java.io.FilterInputStream;
        blobName = "segment_" + randomAlphaOfLength(8);
        // At least the task blocked in readBlob is running and may still allocate its buffer, so its permit must
        };
        final java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
                release.countDown();
                blobData.length,
                rejecting,
            )
            ParallelPartInputStream in = new ParallelPartInputStream(
        blobData = randomByteArrayOfLength(randomIntBetween(1, 3 << 19));
        assertEquals(4 - expectedInFlight, permits.availablePermits());
        final long partSize = 1024;
            executor(),
    public void testReadsBytesInOrderAcrossParts() throws IOException {
    }
        final int budget = randomIntBetween(1, 4);
                final int expectedInFlight = Math.min(budget, in.getNumberOfParts() - 1);
                new ParallelDownloadPermits(4),
                    }
    public void testCloseReleasesOutstandingPermits() throws Exception {
        assertEquals("stolen tasks must not fetch", (blobData.length + partSize - 1) / partSize, container.rangeReads.get());
                partSize,
        final long partSize = 4096;
import java.nio.file.Files;
                    try {
        assertEquals(3, permits.availablePermits());
            read = readFully(in, 3000);
        final long partSize = Math.max(1, blobData.length / 2);
            read = readFully(in, 1000);
            ParallelPartInputStream in = new ParallelPartInputStream(
        final ParallelDownloadPermits permits = new ParallelDownloadPermits(2);
    public void testRateLimiterWrapsEveryPart() throws IOException {
                blobName,
import org.opensearch.common.blobstore.fs.FsBlobContainer;
        assumeTrue("need at least three parts", blobData.length > 2);
        ) {
            try {
        in.close();
    /** Counts range reads issued against the delegate. */
        try (
        assertEquals(permits.getMaxPermits(), permits.availablePermits());
        final long partSize = randomIntBetween(1, 128) * 1024L;
        threadPool = new TestThreadPool(getTestName());
        }
        final List<Runnable> queued = new ArrayList<>();
        });
            try {
        }
        ) {
                partSize,
                if (position > 0) {
import java.util.concurrent.RejectedExecutionException;
package org.opensearch.index.store;
 * this file be licensed under the Apache-2.0 license or a
                permits,
            )
        int n;
        final ParallelDownloadPermits permits = new ParallelDownloadPermits(4);
        final ParallelDownloadPermits permits = new ParallelDownloadPermits(4);
        assumeTrue("need at least two parts", blobData.length > 1);
                partSize,
public class ParallelPartInputStreamTests extends OpenSearchTestCase {
import org.opensearch.common.blobstore.fs.FsBlobStore;
        // itself and the download must still complete with exactly one range read per part.
                blobData.length,
        final long partSize = 1024;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
    public void setup() throws IOException {
                container,
                blobData.length,
            ParallelPartInputStream in = new ParallelPartInputStream(
    }
            ParallelPartInputStream in = new ParallelPartInputStream(
                executor(),
            blobData.length,
                    public int read(byte[] b, int off, int len) {
                container,
                blobName,
            permits,
        }
                read = new byte[first.length + rest.length];
    public void testRejectedExecutionFallsBackToDirectRead() throws IOException {
        assumeTrue("need at least two parts", blobData.length > 1);
        );
    public void testShortRangeReadIsDetected() throws Exception {
    public void testSingleByteReads() throws IOException {
import static org.hamcrest.Matchers.greaterThan;
 * compatible open source license.
    }
                assertTrue(release.await(30, TimeUnit.SECONDS));
        ) {
        public InputStream readBlob(String blobName, long position, long length) throws IOException {
        // Fail every range read that does not start at offset 0, i.e. every prefetched part.
    private static byte[] readFully(InputStream in, int bufferSize) throws IOException {
            }
    @Before
        final byte[] read;
        in.close();
        );
        assertSame(boom, e);
            public InputStream readBlob(String name, long position, long length) throws IOException {
        queued.forEach(Runnable::run);
        final IOException boom = new IOException("boom");
            } else {
        }
        try (
                blobName,
        // on its own part in the meantime (it reads that part directly, without a permit).
        }
        final CountDownLatch release = new CountDownLatch(1);
                permits,
                assertThat(permits.availablePermits(), equalTo(budget - expectedInFlight));
            @Override
import java.io.InputStream;
                }
        try (
        }
            assertEquals((blobData.length + partSize - 1) / partSize, in.getNumberOfParts());
        final CountDownLatch release = new CountDownLatch(1);
            )
                return child;
        final Executor neverRuns = queued::add;
        ) {
        // Hold every prefetch task open until we have observed the count; the reader must still make progress
            final IOException e = expectThrows(IOException.class, () -> in.read(new byte[16], 0, 16));
        ) {
        // Tasks that were still gated must not disturb the budget once they run.
                neverRuns,
                assertEquals(expected & 0xFF, in.read());
            @Override
            executor(),
    }
        final byte[] read;
            assertEquals(-1, in.read());
                blobData.length,
            permits,
        ) {
                container,
import java.util.function.UnaryOperator;
            blobData.length,
        final long partSize = 1024;
            protected BlobContainer wrapChild(BlobContainer child) {
                        assertTrue(release.await(30, TimeUnit.SECONDS));
            rangeReads.incrementAndGet();
        return threadPool.executor(ThreadPool.Names.REMOTE_RECOVERY);
                blobName,
            protected BlobContainer wrapChild(BlobContainer child) {
                container,
        assertEquals(budget, permits.availablePermits());
                read = readFully(in, 4096);
        assertEquals("close must hand back every permit the stream held", 8, permits.availablePermits());
            ParallelPartInputStream in = new ParallelPartInputStream(
import static org.hamcrest.Matchers.containsString;
        };
        ) {
        protected BlobContainer wrapChild(BlobContainer child) {
                }
            UnaryOperator.identity()
        // The gated tasks never started, so they are cancelled outright and every permit comes back at once.
    public void tearDown() throws Exception {
import java.util.List;
    }
            }
            }
    private CountingBlobContainer container;
        final BlobContainer failing = new FilterBlobContainer(container) {
        assertThat(permits.availablePermits(), lessThanOrEqualTo(8 - 1));
        };
                permits,
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                final byte[] first = new byte[(int) Math.min(partSize, blobData.length)];
        });
            )
        final ParallelPartInputStream in = new ParallelPartInputStream(
            if (in.getNumberOfParts() > 1) {
    public void testZeroPermitsDegradesToSequentialRangeReads() throws IOException {
                    entered.countDown();
import java.util.ArrayList;
            blobData.length,
            gatedPrefetches.incrementAndGet();
        super.tearDown();
        in.close();
            ParallelPartInputStream in = new ParallelPartInputStream(
            )
 * The OpenSearch Contributors require contributions made to
        final long partSize = Math.max(1, blobData.length / 3);
        final long partSize = Math.max(1, blobData.length / 2);
                executor(),
        final BlobContainer slow = new FilterBlobContainer(container) {
        final ParallelDownloadPermits permits = new ParallelDownloadPermits(randomIntBetween(1, 8));
        in.close();
                return child;
import org.opensearch.common.blobstore.BlobContainer;
            truncating,
        final long partSize = Math.max(1, blobData.length / 2);
                rejecting,
    private ThreadPool threadPool;
        final BlobContainer broken = new FilterBlobContainer(container) {
        }
                UnaryOperator.identity()
        final Executor gated = r -> executor().execute(() -> {
            };
        assertEquals(2, permits.availablePermits());
            permits,
    }
        final ParallelDownloadPermits permits = new ParallelDownloadPermits(0);
        );
                partSize,
            blobName,
                // Reading the first part schedules prefetches for the following parts, capped by the budget.
        assertEquals((blobData.length + partSize - 1) / partSize, container.rangeReads.get());
        final UnaryOperator<InputStream> counting = s -> {
        @Override
        // Truncate every range stream by one byte.
        @Override
import org.junit.Before;
            slow,
        assertEquals((blobData.length + partSize - 1) / partSize, container.rangeReads.get());
    }
            r.run();
                return org.opensearch.common.io.Streams.limitStream(super.readBlob(name, position, length), length - 1);
                UnaryOperator.identity()
            failing,
            )
            @Override
    private Executor executor() {
    private byte[] blobData;
            assertThat(e.getMessage(), containsString("returned 0 bytes"));
    }
            gated,
                executor(),
                        throw new AssertionError(e);
        CountingBlobContainer(BlobContainer delegate) {
        expectThrows(EOFException.class, () -> readFully(in, 512));
                container,
        final ParallelDownloadPermits permits = new ParallelDownloadPermits(4);
    private static final class CountingBlobContainer extends FilterBlobContainer {
        final Executor rejecting = r -> { throw new RejectedExecutionException("full"); };
    }
                    throw boom;
import org.junit.After;
                    @Override
                partSize,
        assertThat(permits.availablePermits(), lessThanOrEqualTo(3));
import org.opensearch.common.io.PathUtils;
        assumeTrue("need at least two parts", blobData.length > 1);
        final ParallelPartInputStream in = new ParallelPartInputStream(
            @Override
        try (
        final IOException e = expectThrows(IOException.class, () -> readFully(in, 512));
        // Stolen tasks must be no-ops when they eventually run, and must not double-release permits.
            ParallelPartInputStream in = new ParallelPartInputStream(
                blobName,
        assertArrayEquals(blobData, read);
            r.run();
            } catch (InterruptedException e) {
 */
            blobData.length,
            executor(),
 * SPDX-License-Identifier: Apache-2.0
            read = readFully(in, 777);
        final AtomicInteger gatedPrefetches = new AtomicInteger();
            UnaryOperator.identity()
        final AtomicInteger rangeReads = new AtomicInteger();
import org.opensearch.common.blobstore.BlobPath;
        assertArrayEquals(blobData, read);
}
        final ParallelPartInputStream in = new ParallelPartInputStream(
import java.util.concurrent.TimeUnit;
        // An executor that never runs anything: every prefetch stays queued, so the reader must claim each part
                    } catch (InterruptedException e) {
                while (off < first.length) {
            }
                executor(),
                blobData.length,
            partSize,
                UnaryOperator.identity()
 *
        threadPool.shutdown();
        final long partSize = 2048;
        final byte[] buf = new byte[bufferSize];
            public InputStream readBlob(String name, long position, long length) throws IOException {
    }
            blobName,
                return new FilterInputStream(super.readBlob(name, position, length)) {
            blobName,
        final long partSize = 4096;
        // remain held: the permits * partSize bound has to stay exact through a close race.
import java.io.IOException;
        final ParallelDownloadPermits permits = new ParallelDownloadPermits(2);
                new ParallelDownloadPermits(0),
                int off = 0;
import java.util.concurrent.Executor;
                release.countDown();
        final byte[] read;
                partSize,
                blobName,
                return child;
                permits,
            blobName,
    public void testPrefetchFailurePropagatesAndReleasesPermits() throws Exception {
        Files.write(path.resolve(blobName), blobData);
        }
                blobData.length,
        assertArrayEquals(blobData, read);
            }
import java.nio.file.Path;
                partSize,
        assertArrayEquals(blobData, read);
import org.opensearch.common.blobstore.support.FilterBlobContainer;
        ) {
import org.opensearch.threadpool.TestThreadPool;
        final CountDownLatch entered = new CountDownLatch(1);
            }
    public void testZeroLengthReadFromBlobStreamFailsFast() throws IOException {
            }
import org.opensearch.threadpool.ThreadPool;
        final ParallelDownloadPermits permits = new ParallelDownloadPermits(budget);
            assertEquals(-1, in.read());
        final ParallelPartInputStream in = new ParallelPartInputStream(
            public InputStream readBlob(String name, long position, long length) throws IOException {
        final CountDownLatch release = new CountDownLatch(1);
        final long partSize = 2048;
    }
        assertBusy(() -> assertEquals(4, permits.availablePermits()));
        }
                gated,
                container,
            partSize,
                if (position > 0) {
                System.arraycopy(first, 0, read, 0, first.length);
            public InputStream readBlob(String name, long position, long length) throws IOException {
        expectThrows(IOException.class, () -> in.read());
        assertEquals("all permits returned", permits.getMaxPermits(), permits.availablePermits());
    }
        release.countDown();
                blobName,
                throw new AssertionError(e);
        assertEquals(3, permits.availablePermits());
                permits,
            }
                UnaryOperator.identity()
import org.opensearch.test.OpenSearchTestCase;
                broken,
    public void testReaderStealsQueuedPrefetch() throws IOException {
        try (
        final AtomicInteger wrapped = new AtomicInteger();
        }
        assertEquals("every part fetched exactly once", (blobData.length + partSize - 1) / partSize, container.rangeReads.get());
        // Between a handful of bytes and ~1.5MB so that we exercise 1..N parts with the part sizes used below.
                assertBusy(() -> assertThat(gatedPrefetches.get(), equalTo(expectedInFlight)));
                UnaryOperator.identity()
            )
        // prefetches still running at close() return their permit when they complete
            ParallelPartInputStream in = new ParallelPartInputStream(
    private String blobName;
import java.util.concurrent.atomic.AtomicInteger;
        assertArrayEquals(blobData, read);
    @After
                blobData.length,
            protected BlobContainer wrapChild(BlobContainer child) {
    }
                assertTrue(release.await(30, TimeUnit.SECONDS));
        }
    }
            }
import java.util.concurrent.CountDownLatch;
            assertArrayEquals(blobData, readFully(in, 4096));
        );
                final byte[] rest = readFully(in, 4096);
    }
        try (
        assertBusy(() -> assertEquals(4, permits.availablePermits()));
/*
        };
        assertTrue("a prefetch task must be running inside readBlob", entered.await(30, TimeUnit.SECONDS));
    }
        final Executor gated = r -> executor().execute(() -> {
                UnaryOperator.identity()
        assertBusy(() -> assertEquals(4, permits.availablePermits()));
            }
        assertEquals((blobData.length + partSize - 1) / partSize, wrapped.get());
            @Override
    private Path path;
        final int expectedInFlight = Math.min(4, in.getNumberOfParts() - 1);
                return child;
                return super.readBlob(name, position, length);
        assertThat(in.read(), greaterThanOrEqualTo(0)); // opens part 0 and schedules prefetches
                permits,
        try (
    public void testCloseKeepsPermitOfRunningPrefetchUntilItsBufferIsGone() throws Exception {
            partSize,
                blobName,
                blobData.length,
        };
            @Override
        }
        final BlobContainer truncating = new FilterBlobContainer(container) {
            super(delegate);
            protected BlobContainer wrapChild(BlobContainer child) {
        assertTrue(threadPool.awaitTermination(5, TimeUnit.SECONDS));
        assertBusy(() -> assertEquals(8, permits.availablePermits()));
            return s;
        final byte[] read;
                    off += in.read(first, off, first.length - off);
            out.write(buf, 0, n);
                partSize,
                throw new AssertionError(e);
            }
                UnaryOperator.identity()
    }
        assertThat(in.read(), greaterThanOrEqualTo(0));
                };
                }
    public void testPrefetchNeverExceedsPermitBudget() throws Exception {
            UnaryOperator.identity()
            }
                container,
        final Executor rejecting = r -> { throw new AssertionError("no prefetch expected without permits"); };
            return child;
                counting
            @Override
            for (byte expected : blobData) {
        // Block inside the range read of every prefetched part, i.e. AFTER the task has claimed ownership.
        final byte[] read;
        container = new CountingBlobContainer(new FsBlobContainer(new FsBlobStore(8 * 1024, path, false), BlobPath.cleanPath(), path));
                        return 0; // violates the InputStream contract for len > 0
            UnaryOperator.identity()
        assertThat(wrapped.get(), greaterThan(0));
            )
            permits,
        return out.toByteArray();
            wrapped.incrementAndGet();
