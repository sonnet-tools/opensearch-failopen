import java.io.ByteArrayInputStream;
    /**
        PathUtilsForTesting.installMock(fileSystem); // restored by restoreFileSystem in OpenSearchTestCase
        }
                @Override
import java.util.concurrent.atomic.AtomicInteger;
    public void testIdenticalContentYieldsDistinctVersionTokens() throws IOException {
import java.nio.file.Path;
     * version - as it would be under a real object store's ETag semantics. A holder of a pre-delete token must lose
                    if (blobNameSortOrder == BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC) {
            // no super.newInputStream(path, opts) as it will use the delegating FileSystem to open a SeekableByteChannel
 *
            };
                    throw new AssertionError(e);
     * would pass a CAS it should lose (ABA).
    public void testWriteBlobConditionallyLeavesNoTempBlobs() throws IOException {
            blobsInFileSystem.add(blobName);
            assertArrayEquals(next, blob.content());
import java.util.Set;
        assertThat(conflicted.get(), equalTo(writers - 1));
        final FsBlobContainer container = newContainer();
            path
 * Licensed to Elasticsearch under one or more contributor
        }
        final Path path = PathUtils.get(createTempDir().toString());
 * SPDX-License-Identifier: Apache-2.0
    }
        final byte[] content = randomByteArrayOfLength(randomIntBetween(1, 512));
import org.opensearch.common.io.PathUtils;
    public void testListBlobsByPrefixInLexicographicOrderWithZeroLimit() throws IOException {
        @Override
        assertArrayEquals(second, container.readBlobWithVersion("fence").content());
                }
import org.opensearch.common.blobstore.VersionedBlob;
     * The conditional-write methods below work, but only within one JVM: a local filesystem has no compare-and-swap, so
        final FsBlobContainer container = newContainer();
        final FsBlobContainer container = newContainer();
        try (InputStream stream = container.readBlob(blobName, start, length)) {
 * not use this file except in compliance with the License.
        }
     * the precondition is emulated with in-process locks. {@code isConditionalWriteSupported} reports whether the STORE
            assertThat(Streams.consumeFully(stream), equalTo(length));
            assertThrows(
    }
            thread.start();
/*
        // A stale writer whose expected token matches the *content* of the current blob must still lose the CAS
package org.opensearch.common.blobstore.fs;
    }
 * KIND, either express or implied.  See the License for the
     * believe they held the fence.
import java.nio.file.NoSuchFileException;
        expectThrows(
    }
        final Path root = PathUtils.get(createTempDir().toString());
            path
     * Deleting a blob invalidates any previously issued version token, so a blob recreated at the same path is a new
            BlobVersionConflictException.class,
    }
        );
            () -> container.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, null)
        final FsBlobContainer container = newContainer();
        FileSystemProvider fileSystemProvider = new MockFileSystemProvider(PathUtils.getDefaultFileSystem(), totalBytesRead::addAndGet);
            this.onRead = onRead;
import java.util.List;
import java.util.stream.Collectors;
            BlobVersionConflictException.class,
            super("mockfs://", inner);
import org.opensearch.common.blobstore.BlobContainer;
        final String first = container.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, null);
 */
            return read;
        final byte[] content = "one".getBytes(StandardCharsets.UTF_8);
        final long length = randomLongBetween(1L, blobData.length - start);
 * specific language governing permissions and limitations
        final byte[] oversized = randomByteArrayOfLength(129);
import java.nio.file.attribute.FileAttribute;
        final String tempBlobName = FsBlobContainer.tempBlobName(randomAlphaOfLengthBetween(1, 20));
        for (int i = 0; i < 10; i++) {
 * ownership. Elasticsearch licenses this file to you under
    public void setupMockFileSystems() {
                        blobsInFileSystem.sort(String::compareTo);
        final byte[] first = randomByteArrayOfLength(randomIntBetween(1, 512));
        final String staleToken = container.writeBlobConditionally("fence", new ByteArrayInputStream(first), first.length, null);
    public void testWriteBlobConditionallyRejectsCreateWhenBlobExists() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.tests.mockfile.FilterFileSystemProvider;
        final long start = randomLongBetween(0L, Math.max(0L, blobData.length - 1));
        Files.createDirectories(victimPath);
        final FsBlobContainer container = new FsBlobContainer(new FsBlobStore(128, path, false), BlobPath.cleanPath(), path);
        final String tempBlobName = FsBlobContainer.tempBlobName(blobName);
        victim.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, null);
 * license agreements. See the NOTICE file distributed with
                }
                () -> container.listBlobsByPrefixInSortedOrder(null, limit, blobNameSortOrder, new ActionListener<>() {
                public void onResponse(List<BlobMetadata> blobMetadata) {
        private int onRead(int read) {
            final VersionedBlob blob = container.readBlobWithVersion("fence");
        final FsBlobContainer victim = new FsBlobContainer(store, BlobPath.cleanPath().add("idx-1"), victimPath);
                    barrier.await(10, TimeUnit.SECONDS);
import org.opensearch.common.io.Streams;
        final Path path = PathUtils.get(createTempDir().toString());
        final FsBlobContainer container = newContainer();
    }
                    int actualLimit = Math.min(limit, 10);
        container.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, null);
    }
                    assertEquals(actualLimit, blobMetadata.size());
        final FsBlobContainer container = newContainer();
                    @Override
    private void testListBlobsByPrefixInSortedOrder(int limit, BlobContainer.BlobNameSortOrder blobNameSortOrder) throws IOException {
        }
 */
import java.util.ArrayList;
        container.writeBlob("fence", new ByteArrayInputStream(oversized), oversized.length, false);
                    public void onResponse(List<BlobMetadata> blobMetadata) {}
            final String blobName = randomAlphaOfLengthBetween(10, 20).toLowerCase(Locale.ROOT);
    public void testTempBlobName() {
    final AtomicLong totalBytesRead = new AtomicLong(0);
                public void onFailure(Exception e) {
        assertThat(tempBlobName, startsWith("pending-"));
        assertNotEquals(preDeleteToken, recreatedToken);
        testListBlobsByPrefixInSortedOrder(0, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);
            Files.write(path.resolve(blobName), blobData);
        // a fresh read starts a new chain over the recreated blob
            threads.add(thread);
            final byte[] next = randomByteArrayOfLength(randomIntBetween(1, 512));
        final List<Thread> threads = new ArrayList<>(writers);
        public SeekableByteChannel newByteChannel(Path path, Set<? extends OpenOption> opts, FileAttribute<?>... attrs) throws IOException {
 * compatible open source license.
    public void testListBlobsByPrefixInLexicographicOrderWithLimitGreaterThanNumberOfRecords() throws IOException {
    }
            assertNotNull(nextToken);
                    return onRead(super.read(b, off, len));
    /**
import static org.hamcrest.Matchers.startsWith;
import java.util.Locale;
            () -> container.writeBlobConditionally("fence", new ByteArrayInputStream(third), third.length, staleToken)
            assertThat(totalBytesRead.get(), equalTo(length));
     * of identical content would be indistinguishable, and a stale writer that happens to write the current content
            thread.join();
import java.io.FilterInputStream;
    /**
            new FsBlobStore(randomIntBetween(1, 8) * 1024, path, false),
        final byte[] initial = "init".getBytes(StandardCharsets.UTF_8);
        final byte[] first = "one".getBytes(StandardCharsets.UTF_8);
            if (read != -1) {
        testListBlobsByPrefixInSortedOrder(10, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);
 * You may obtain a copy of the License at
                try {
        }
                } catch (Exception e) {
        final String recreatedToken = container.readBlobWithVersion("fence").versionToken();
        @Override
        final byte[] third = "three".getBytes(StandardCharsets.UTF_8);
                })
        assertThat(container.readBlobWithVersion("fence").versionToken(), equalTo(second));
        return new FsBlobContainer(new FsBlobStore(randomIntBetween(1, 8) * 1024, path, false), BlobPath.cleanPath(), path);
        final VersionedBlob blob = container.readBlobWithVersion("fence");
        }
            return new FilterInputStream(delegate.newInputStream(path, opts)) {
            new FsBlobStore(randomIntBetween(1, 8) * 1024, path, false),
                    @Override
        for (int i = 0; i < writers; i++) {
     * answer {@code false} however well its emulation behaves here. Two nodes sharing a filesystem would otherwise both
        final String token = container.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, null);
        assertThat(newContainer().isConditionalWriteSupported(), is(false));
import java.nio.file.FileSystem;
import java.io.InputStream;
    public void testDeleteInvalidatesVersionTokens() throws IOException {
        final String blobName = randomAlphaOfLengthBetween(1, 20);
import org.opensearch.core.action.ActionListener;
            final String nextToken = container.writeBlobConditionally("fence", new ByteArrayInputStream(next), next.length, token);
        container.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, recreatedToken);
                    }
        final String siblingToken = sibling.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, null);
    public void testConditionalWriteIsNotReportedAsSupportedBecauseItIsOnlyEmulated() throws IOException {
        assertThat(succeeded.get(), equalTo(1));
            final byte[] blobData = randomByteArrayOfLength(randomIntBetween(1, frequently() ? 512 : 1 << 20)); // rarely up to 1mb
    public void testConcurrentConditionalWritesAdmitExactlyOneWinner() throws Exception {
import java.nio.file.OpenOption;
            BlobPath.cleanPath(),
        final Path siblingPath = root.resolve("idx-10");
import java.nio.file.Files;
                @Override
        final AtomicInteger conflicted = new AtomicInteger();
        final byte[] content = "fence".getBytes(StandardCharsets.UTF_8);
    public void testListBlobsByPrefixInLexicographicOrderWithLimitNumberOfRecords() throws IOException {
 * software distributed under the License is distributed on an
import java.util.Collections;
import org.junit.Before;
        expectThrows(
        sibling.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, siblingToken);
                }
        final String blobName = randomAlphaOfLengthBetween(1, 20).toLowerCase(Locale.ROOT);
    }
        assertNotEquals("identical content must still produce a new version", first, second);
        // create-if-absent (null expected token) must now fail since the blob is present
    }
import org.apache.lucene.tests.mockfile.FilterSeekableByteChannel;
        }
        assertArrayEquals(content, blob.content());
        final byte[] content = randomByteArrayOfLength(randomIntBetween(1, 512));
        }
        testListBlobsByPrefixInSortedOrder(-5, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);
            assertThat(blob.versionToken(), equalTo(nextToken));
        final FsBlobContainer container = newContainer();
            () -> container.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, preDeleteToken)
    public void testListBlobsByPrefixInLexicographicOrderWithNegativeLimit() throws IOException {
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        fileSystem = fileSystemProvider.getFileSystem(null);
            );
     * Deleting a container must invalidate only ITS OWN blobs' version tokens, never a sibling's whose directory name
 *
        final Path path = PathUtils.get(createTempDir().toString());
import org.opensearch.test.OpenSearchTestCase;
        container.writeBlobConditionally("fence", new ByteArrayInputStream(second), second.length, staleToken);
import org.junit.After;
        IOUtils.close(fileSystem);
        if (limit >= 0) {
        container.deleteBlobsIgnoringIfNotExists(Collections.singletonList("fence"));
        final byte[] content = "same-bytes".getBytes(StandardCharsets.UTF_8);
            BlobVersionConflictException.class,
    }
    }
        );
    }
        } else {
                    return onRead(super.read(dst));
import java.nio.ByteBuffer;
/*
            token = nextToken;
                public int read() throws IOException {
 */
        // recreate at the same path through a non-conditional API
     */
    }
    }
import org.apache.lucene.tests.util.LuceneTestCase;
        final String second = container.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, first);
        public InputStream newInputStream(Path path, OpenOption... opts) throws IOException {
        final String preDeleteToken = container.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, null);
        );
        MockFileSystemProvider(FileSystem inner, Consumer<Long> onRead) {
        final int writers = randomIntBetween(2, 8);
    public void testWriteBlobConditionallyCreatesIfAbsent() throws IOException {
    }
                public int read(byte[] b, int off, int len) throws IOException {
import java.nio.file.spi.FileSystemProvider;
/*
        final Path path = PathUtils.get(createTempDir().toString());
import java.util.concurrent.TimeUnit;
                }
        expectThrows(
        final byte[] content = randomByteArrayOfLength(randomIntBetween(1, 512));
     */
        Files.write(path.resolve(blobName), blobData);
 *
                    List<String> keys = blobsInFileSystem.subList(0, actualLimit);
 * this work for additional information regarding copyright
        }
    }
                    } else {
        final FsBlobContainer container = newContainer();
            }
    }
                @Override
        Files.createDirectories(siblingPath);
            assertThat(totalBytesRead.get(), equalTo(0L));
import org.opensearch.common.blobstore.BlobMetadata;
}
    FileSystem fileSystem = null;
            () -> container.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, first)
            };
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
    }
    public void testWriteBlobConditionallyChainsOnMatchingToken() throws IOException {
            return new FilterSeekableByteChannel(super.newByteChannel(path, opts, attrs)) {
        assertThat(container.listBlobsByPrefix("pending-").keySet(), equalTo(Collections.emptySet()));
        assertThat(FsBlobContainer.isTempBlobName(tempBlobName), is(true));
    }
        for (Thread thread : threads) {
        container.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, null);
import org.opensearch.common.blobstore.BlobPath;
        testListBlobsByPrefixInSortedOrder(12, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);
        final String token = container.writeBlobConditionally("fence", new ByteArrayInputStream(initial), initial.length, null);
     * enforces it, which is what remote store fencing needs to exclude a writer on another node, so this container must
     * CAS it should win - which, for the remote store fence, spuriously fences an unrelated shard.
     * Version tokens must be content-independent: were they derived from the bytes (e.g. a content hash), two writes
import java.nio.channels.SeekableByteChannel;
            // and instead we want the mocked newByteChannel() method to be used
        final FsBlobContainer container = new FsBlobContainer(
    }
    }
 * Unless required by applicable law or agreed to in writing,
                public int read(ByteBuffer dst) throws IOException {
                    succeeded.incrementAndGet();
     */
    public void closeMockFileSystems() throws IOException {
    }
        victim.delete();
        container.writeBlob("fence", new ByteArrayInputStream(content), content.length, false);
                @Override
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
                    public void onFailure(Exception e) {}
                    conflicted.incrementAndGet();
    @After
    public void testReadBlobWithVersionOnMissingBlobThrows() throws IOException {
        // The first writer's token is no longer current: its next CAS must be rejected and the blob left untouched
import java.util.concurrent.CyclicBarrier;
        );
            });
import org.opensearch.common.util.io.IOUtils;
 * under the License.
     * its CAS; a fresh read of the recreated blob starts a new chain.
        final FsBlobStore store = new FsBlobStore(randomIntBetween(1, 8) * 1024, root, false);
        expectThrows(
public class FsBlobContainerTests extends OpenSearchTestCase {
import java.util.concurrent.atomic.AtomicLong;
        final CyclicBarrier barrier = new CyclicBarrier(writers);
        // The sibling's chain is untouched: its token still wins the CAS.
        final byte[] second = "two".getBytes(StandardCharsets.UTF_8);
        assertThat(totalBytesRead.get(), equalTo(0L));
import static org.hamcrest.Matchers.equalTo;
        testListBlobsByPrefixInSortedOrder(8, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);
        List<String> blobsInFileSystem = new ArrayList<>();
            container.listBlobsByPrefixInSortedOrder(null, limit, blobNameSortOrder, new ActionListener<>() {
        expectThrows(NoSuchFileException.class, () -> container.readBlobWithVersion("missing"));
                    container.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, token);
        final Consumer<Long> onRead;
    @Before
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            BlobPath.cleanPath(),
    public void testReadBlobRangeCorrectlySkipBytes() throws IOException {
    public void testIsTempBlobName() {
    /** Versioned reads are for small control blobs; an oversized blob at the key is refused, not buffered whole. */
                        blobsInFileSystem.sort(Collections.reverseOrder(String::compareTo));
    private FsBlobContainer newContainer() throws IOException {
        final Path victimPath = root.resolve("idx-1");
    public void testWriteBlobConditionallyRejectsStaleToken() throws IOException {
                }
        assertTrue(e.getMessage(), e.getMessage().contains("too large"));
import java.util.function.Consumer;
                    fail("blobContainer.listBlobsByPrefixInLexicographicOrder failed with exception: " + e.getMessage());
                onRead.accept((long) read);
        );
                    assertEquals(keys, blobMetadata.stream().map(BlobMetadata::name).collect(Collectors.toList()));
     * merely shares the prefix (idx-1 vs idx-10). An over-matched invalidation makes the sibling's live writer lose a
import static org.hamcrest.Matchers.containsString;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.io.PathUtilsForTesting;
     */
    }
    public void testDeleteDoesNotInvalidateVersionTokensOfPrefixSiblingContainers() throws IOException {
        );
            final Thread thread = new Thread(() -> {
    static class MockFileSystemProvider extends FilterFileSystemProvider {
        final FsBlobContainer sibling = new FsBlobContainer(store, BlobPath.cleanPath().add("idx-10"), siblingPath);
        assertNotNull(token);
    public void testListBlobsByPrefixInLexicographicOrderWithLimitLessThanNumberOfRecords() throws IOException {
        }
        final AtomicInteger succeeded = new AtomicInteger();
        final IOException e = expectThrows(IOException.class, () -> container.readBlobWithVersion("fence"));
                } catch (BlobVersionConflictException e) {
        assertThat(tempBlobName, containsString(blobName));
            });
            final byte[] content = ("writer-" + i).getBytes(StandardCharsets.UTF_8);
                    return onRead(super.read());
        final FsBlobContainer container = new FsBlobContainer(
            BlobVersionConflictException.class,
                IllegalArgumentException.class,
        assertThat(blob.versionToken(), equalTo(token));
import java.io.IOException;
    public void testReadBlobWithVersionRejectsOversizedBlob() throws IOException {
                @Override
        String token = container.writeBlobConditionally("fence", new ByteArrayInputStream(first), first.length, null);
import static org.hamcrest.Matchers.is;
@LuceneTestCase.SuppressFileSystems("*") // we do our own mocking
import java.nio.charset.StandardCharsets;
        final byte[] blobData = randomByteArrayOfLength(randomIntBetween(1, frequently() ? 512 : 1 << 20)); // rarely up to 1mb
                }
import org.opensearch.common.blobstore.BlobVersionConflictException;
    /**
        final FsBlobContainer container = newContainer();
