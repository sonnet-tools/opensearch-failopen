            executor(),
        final CountDownLatch release = new CountDownLatch(1);  
                partSize,
import java.io.IOException;  
            }
import java.util.ArrayList;
                assertEquals(expected & 0xFF, in.read());
            )
import java.nio.file.Files;
        final ParallelDownloadPermits permits = new ParallelDownloadPermits(2);
    }
        final byte[] read;  
        while ((n = in.read(buf, 0, buf.length)) != -1) {
    /** Counts range reads issued against the delegate. */
        blobName = "segment_" + randomAlphaOfLength(8);
        final long partSize = 2048;  
        in.close();  
/*  
                final int expectedInFlight = Math.min(budget, in.getNumberOfParts() - 1);  
                partSize,  
            container,
            blobName,
                    try {
        assertThat(in.read(), greaterThanOrEqualTo(0));
    }
    public void tearDown() throws Exception {  
            assertThat(e.getMessage(), containsString("returned 0 bytes"));
                UnaryOperator.identity()
        }
                    public int read(byte[] b, int off, int len) {
        final ParallelDownloadPermits permits = new ParallelDownloadPermits(2);  
                permits,
            }
        try (
        try (
import org.opensearch.common.blobstore.fs.FsBlobContainer;  
        assertEquals("close must hand back every permit the stream held", 8, permits.availablePermits());
                partSize,  
            blobName,
        assumeTrue("need at least two parts", blobData.length > 1);
    private byte[] blobData;  
        threadPool = new TestThreadPool(getTestName());
        }  
        final long partSize = 2048;
        final Executor rejecting = r -> { throw new RejectedExecutionException("full"); };
    }
        final ParallelPartInputStream in = new ParallelPartInputStream(
            )
        final ParallelPartInputStream in = new ParallelPartInputStream(  
        ) {
                blobData.length,
        final CountDownLatch release = new CountDownLatch(1);  
        }  
        });  
    public void testShortRangeReadIsDetected() throws Exception {
import java.util.concurrent.atomic.AtomicInteger;
            gated,  
    }  
            final IOException e = expectThrows(IOException.class, () -> in.read(new byte[16], 0, 16));
        assertBusy(() -> assertEquals(4, permits.availablePermits()));  
            wrapped.incrementAndGet();
                blobData.length,
 * The OpenSearch Contributors require contributions made to  
                blobName,
                int off = 0;
        @Override
            ParallelPartInputStream in = new ParallelPartInputStream(  
                blobName,
        // itself and the download must still complete with exactly one range read per part.
        assertArrayEquals(blobData, read);
            gatedPrefetches.incrementAndGet();  
            }  
                permits,  
        assertBusy(() -> assertEquals(4, permits.availablePermits()));
        Files.write(path.resolve(blobName), blobData);
    public void testCloseReleasesOutstandingPermits() throws Exception {  
                return super.readBlob(name, position, length);
            public InputStream readBlob(String name, long position, long length) throws IOException {
                }
            @Override
                new ParallelDownloadPermits(4),
                assertTrue(release.await(30, TimeUnit.SECONDS));
        final long partSize = Math.max(1, blobData.length / 2);
    }
                UnaryOperator.identity()  
    }  
            )
            read = readFully(in, randomIntBetween(1, 64 * 1024));
 */  
            r.run();  
        // The gated tasks never started, so they are cancelled outright and every permit comes back at once.
    @Before  
            ParallelPartInputStream in = new ParallelPartInputStream(
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import java.util.concurrent.RejectedExecutionException;
        // Truncate every range stream by one byte.  
                throw new AssertionError(e);
        threadPool.shutdown();
            UnaryOperator.identity()
        };  
        final BlobContainer truncating = new FilterBlobContainer(container) {
import org.opensearch.common.io.PathUtils;  
        final BlobContainer slow = new FilterBlobContainer(container) {
                UnaryOperator.identity()  
                partSize,  
        }
}  
    }  
                assertThat(permits.availablePermits(), equalTo(budget - expectedInFlight));
                System.arraycopy(first, 0, read, 0, first.length);  
            @Override
            }  
 *
            @Override
            ParallelPartInputStream in = new ParallelPartInputStream(
import java.util.concurrent.TimeUnit;  
            read = readFully(in, 3000);  
        final ParallelPartInputStream in = new ParallelPartInputStream(
        final ParallelDownloadPermits permits = new ParallelDownloadPermits(4);
        int n;  
                blobName,
        CountingBlobContainer(BlobContainer delegate) {
import java.io.FilterInputStream;
                blobData.length,
            return child;
                assertBusy(() -> assertThat(gatedPrefetches.get(), equalTo(expectedInFlight)));
                executor(),
                blobName,  
            permits,
        final byte[] read;  
        assertEquals((blobData.length + partSize - 1) / partSize, container.rangeReads.get());  
            UnaryOperator.identity()  
                release.countDown();  
        // Between a handful of bytes and ~1.5MB so that we exercise 1..N parts with the part sizes used below.
        assumeTrue("need at least two parts", blobData.length > 1);  
        final ParallelDownloadPermits permits = new ParallelDownloadPermits(4);  
            assertArrayEquals(blobData, readFully(in, 4096));  
            assertEquals(-1, in.read());  
        assertBusy(() -> assertEquals(8, permits.availablePermits()));  
        final long partSize = Math.max(1, blobData.length / 3);
            )
    private String blobName;
                        assertTrue(release.await(30, TimeUnit.SECONDS));  
        );
        // Stolen tasks must be no-ops when they eventually run, and must not double-release permits.
import org.opensearch.common.blobstore.BlobPath;
                if (position > 0) {
            }
    }  
        final BlobContainer broken = new FilterBlobContainer(container) {
                final byte[] rest = readFully(in, 4096);
    private Path path;
    private static byte[] readFully(InputStream in, int bufferSize) throws IOException {  
        assertTrue(threadPool.awaitTermination(5, TimeUnit.SECONDS));  
        ) {  
                blobData.length,
                UnaryOperator.identity()
        try (
        assertEquals(budget, permits.availablePermits());
        path = PathUtils.get(createTempDir().toString());  
            )
            assertEquals(-1, in.read());  
        try (
                blobName,
import org.junit.Before;
    public void testCloseKeepsPermitOfRunningPrefetchUntilItsBufferIsGone() throws Exception {  
        final long partSize = 1024;
        );  
                    off += in.read(first, off, first.length - off);
 * this file be licensed under the Apache-2.0 license or a
        final long partSize = Math.max(1, blobData.length / 2);
        in.close();
            ParallelPartInputStream in = new ParallelPartInputStream(
        // Hold every prefetch task open until we have observed the count; the reader must still make progress
 * compatible open source license.
import java.io.InputStream;
            @Override
        in.close();
                UnaryOperator.identity()  
                rejecting,
import org.opensearch.threadpool.TestThreadPool;
 * SPDX-License-Identifier: Apache-2.0
                return org.opensearch.common.io.Streams.limitStream(super.readBlob(name, position, length), length - 1);  
                }
                        return 0; // violates the InputStream contract for len > 0  
        assumeTrue("need at least three parts", blobData.length > 2);
            slow,  
            };  
        final AtomicInteger gatedPrefetches = new AtomicInteger();
            }  
        final ParallelDownloadPermits permits = new ParallelDownloadPermits(4);  
                rejecting,
                permits,
        ) {
    private static final class CountingBlobContainer extends FilterBlobContainer {
    }
            ParallelPartInputStream in = new ParallelPartInputStream(  
                assertTrue(release.await(30, TimeUnit.SECONDS));
        }  
        final long partSize = 4096;  
            blobData.length,
    public void testZeroLengthReadFromBlobStreamFailsFast() throws IOException {
        public InputStream readBlob(String blobName, long position, long length) throws IOException {  
        assertEquals(2, permits.availablePermits());  
public class ParallelPartInputStreamTests extends OpenSearchTestCase {
        });
            try {
            return new FilterInputStream(super.readBlob(blobName, position, length)) {
            r.run();
                // Reading the first part schedules prefetches for the following parts, capped by the budget.  
        assertArrayEquals(blobData, read);
        final List<Runnable> queued = new ArrayList<>();
import java.util.concurrent.CountDownLatch;  
        try (
        in.close();  
        expectThrows(IOException.class, () -> in.read());
        final UnaryOperator<InputStream> counting = s -> {  
            } catch (InterruptedException e) {  
        try (
        final ParallelDownloadPermits permits = new ParallelDownloadPermits(8);  
    private ThreadPool threadPool;  
        assertEquals("every part fetched exactly once", (blobData.length + partSize - 1) / partSize, container.rangeReads.get());  
                partSize,
    public void testReadsBytesInOrderAcrossParts() throws IOException {
        }  
                    } catch (InterruptedException e) {
            assertEquals((blobData.length + partSize - 1) / partSize, in.getNumberOfParts());
    private CountingBlobContainer container;
        release.countDown();
            permits,
                return super.readBlob(name, position, length);
            blobData.length,  
        };
                counting  
                read = readFully(in, 4096);
        );
import java.nio.file.Path;  
            executor(),
        final long partSize = randomIntBetween(1, 128) * 1024L;
            @Override
                container,  
    }  
        assertArrayEquals(blobData, read);
                partSize,  
        final byte[] read;  
            public InputStream readBlob(String name, long position, long length) throws IOException {
            protected BlobContainer wrapChild(BlobContainer child) {
                container,
        container = new CountingBlobContainer(new FsBlobContainer(new FsBlobStore(8 * 1024, path, false), BlobPath.cleanPath(), path));
        expectThrows(EOFException.class, () -> readFully(in, 512));  
            }
        assertEquals(3, permits.availablePermits());
import org.junit.After;
        // Block inside the range read of every prefetched part, i.e. AFTER the task has claimed ownership.
    }
                        throw new AssertionError(e);
            protected BlobContainer wrapChild(BlobContainer child) {  
        release.countDown();  
                return child;
            @Override  
    public void testZeroPermitsDegradesToSequentialRangeReads() throws IOException {
                if (position > 0) {  
        }
                blobData.length,  
        final Executor gated = r -> executor().execute(() -> {
        assertArrayEquals(blobData, read);
        assertSame(boom, e);  
            } catch (InterruptedException e) {
            public InputStream readBlob(String name, long position, long length) throws IOException {
                permits,
            blobName,
                container,  
    private Executor executor() {  
                partSize,
            }
            partSize,
        final IOException e = expectThrows(IOException.class, () -> readFully(in, 512));
                return child;
            if (in.getNumberOfParts() > 1) {
        };
        assertBusy(() -> assertEquals(4, permits.availablePermits()));
        queued.forEach(Runnable::run);  
        final ParallelDownloadPermits permits = new ParallelDownloadPermits(3);  
            try {  
            }
        final byte[] read;
            truncating,
            partSize,
                    @Override
            }
            ParallelPartInputStream in = new ParallelPartInputStream(
                }
            ParallelPartInputStream in = new ParallelPartInputStream(
        // on its own part in the meantime (it reads that part directly, without a permit).
            executor(),
        ) {
        final long partSize = 1024;
        assertEquals(4 - expectedInFlight, permits.availablePermits());
                    }  
    }
        );
                UnaryOperator.identity()  
                blobData.length,
        final IOException boom = new IOException("boom");
        assumeTrue("need at least two parts", blobData.length > 1);
        ) {  
        return out.toByteArray();
            read = readFully(in, 1000);  
import static org.hamcrest.Matchers.greaterThan;  
            UnaryOperator.identity()
                final byte[] first = new byte[(int) Math.min(partSize, blobData.length)];
    public void setup() throws IOException {
                System.arraycopy(rest, 0, read, first.length, rest.length);
            permits,  
        // Tasks that were still gated must not disturb the budget once they run.
        final Executor neverRuns = queued::add;
        ) {
        }
        final byte[] buf = new byte[bufferSize];
import java.io.EOFException;
        }
        final int expectedInFlight = Math.min(4, in.getNumberOfParts() - 1);  
            protected BlobContainer wrapChild(BlobContainer child) {  
            super(delegate);  
import static org.hamcrest.Matchers.containsString;
        ) {
        // prefetches still running at close() return their permit when they complete
    @After
                    }
                blobData.length,  
        blobData = randomByteArrayOfLength(randomIntBetween(1, 3 << 19));  
            UnaryOperator.identity()  
                container,  
        final long partSize = 1024;
                container,  
                read = new byte[first.length + rest.length];
    }  
                permits,
                container,
        final int budget = randomIntBetween(1, 4);
                blobName,
        assertThat(permits.availablePermits(), lessThanOrEqualTo(3));  
import org.opensearch.common.blobstore.support.FilterBlobContainer;
    public void testPrefetchNeverExceedsPermitBudget() throws Exception {  
        assertThat(wrapped.get(), greaterThan(0));  
        return threadPool.executor(ThreadPool.Names.REMOTE_RECOVERY);
            failing,  
        };
            )
        assertEquals(3, permits.availablePermits());
        }
        final java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
                permits,
        final AtomicInteger rangeReads = new AtomicInteger();  
import org.opensearch.common.blobstore.fs.FsBlobStore;
                broken,
        final ParallelDownloadPermits permits = new ParallelDownloadPermits(randomIntBetween(1, 8));  
    public void testRejectedExecutionFallsBackToDirectRead() throws IOException {
            ParallelPartInputStream in = new ParallelPartInputStream(
        try (  
            public InputStream readBlob(String name, long position, long length) throws IOException {
                blobName,
                release.countDown();  
            )  
        final CountDownLatch entered = new CountDownLatch(1);
    }
        }
                    throw boom;  
                throw new AssertionError(e);  
        final ParallelPartInputStream in = new ParallelPartInputStream(
        assertArrayEquals(blobData, read);
                gated,  
        super.tearDown();
import org.opensearch.threadpool.ThreadPool;  
import java.util.function.UnaryOperator;
            }
            out.write(buf, 0, n);
                partSize,  
            blobData.length,
            for (byte expected : blobData) {  
            @Override
        final long partSize = 4096;  
        final AtomicInteger wrapped = new AtomicInteger();
        };
        // At least the task blocked in readBlob is running and may still allocate its buffer, so its permit must
import java.util.List;
package org.opensearch.index.store;
                return child;
    }
            protected BlobContainer wrapChild(BlobContainer child) {  
            } else {
        final ParallelDownloadPermits permits = new ParallelDownloadPermits(budget);  
        final ParallelDownloadPermits permits = new ParallelDownloadPermits(0);
        assertEquals((blobData.length + partSize - 1) / partSize, container.rangeReads.get());  
                executor(),
        final Executor rejecting = r -> { throw new AssertionError("no prefetch expected without permits"); };
        final byte[] read;
        assertEquals((blobData.length + partSize - 1) / partSize, wrapped.get());
            @Override
                UnaryOperator.identity()
            permits,
                return new FilterInputStream(super.readBlob(name, position, length)) {  
        final CountDownLatch release = new CountDownLatch(1);
                return child;  
        assertThat(in.read(), greaterThanOrEqualTo(0)); // opens part 0 and schedules prefetches
            partSize,  
                executor(),
        try (
        final BlobContainer failing = new FilterBlobContainer(container) {  
                container,  
    public void testSingleByteReads() throws IOException {
            rangeReads.incrementAndGet();
    }
        assertTrue("a prefetch task must be running inside readBlob", entered.await(30, TimeUnit.SECONDS));
    }
    public void testPrefetchFailurePropagatesAndReleasesPermits() throws Exception {  
                blobName,
            blobData.length,
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            blobName,  
        assertEquals("all permits returned", permits.getMaxPermits(), permits.availablePermits());
            partSize,  
                while (off < first.length) {  
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.common.blobstore.BlobContainer;
        protected BlobContainer wrapChild(BlobContainer child) {
            return s;
    public void testReaderStealsQueuedPrefetch() throws IOException {
            }
import java.util.concurrent.Executor;
            )
                executor(),
                new ParallelDownloadPermits(0),  
        final long partSize = Math.max(1, blobData.length / 2);
                blobData.length,
        assertEquals("stolen tasks must not fetch", (blobData.length + partSize - 1) / partSize, container.rangeReads.get());
        // Fail every range read that does not start at offset 0, i.e. every prefetched part.
import static org.hamcrest.Matchers.equalTo;
        // remain held: the permits * partSize bound has to stay exact through a close race.
                };
            read = readFully(in, 777);  
        assertEquals(permits.getMaxPermits(), permits.availablePermits());
        final Executor gated = r -> executor().execute(() -> {
    public void testRateLimiterWrapsEveryPart() throws IOException {  
                neverRuns,
        assertThat(permits.availablePermits(), lessThanOrEqualTo(8 - 1));
        // An executor that never runs anything: every prefetch stays queued, so the reader must claim each part  
        }
                    entered.countDown();
        ) {
        @Override  
