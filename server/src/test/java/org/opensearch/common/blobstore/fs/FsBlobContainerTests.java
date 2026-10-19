    @After
        // recreate at the same path through a non-conditional API
    public void closeMockFileSystems() throws IOException {
        // A stale writer whose expected token matches the *content* of the current blob must still lose the CAS
                    throw new AssertionError(e);
     * Deleting a blob invalidates any previously issued version token, so a blob recreated at the same path is a new
            final byte[] blobData = randomByteArrayOfLength(randomIntBetween(1, frequently() ? 512 : 1 << 20)); // rarely up to 1mb  
        expectThrows(
            BlobVersionConflictException.class,  
    }
        final Path siblingPath = root.resolve("idx-10");
    }  
        final VersionedBlob blob = container.readBlobWithVersion("fence");
        } else {
            container.listBlobsByPrefixInSortedOrder(null, limit, blobNameSortOrder, new ActionListener<>() {  
     * the precondition is emulated with in-process locks. {@code isConditionalWriteSupported} reports whether the STORE
@LuceneTestCase.SuppressFileSystems("*") // we do our own mocking  
    private void testListBlobsByPrefixInSortedOrder(int limit, BlobContainer.BlobNameSortOrder blobNameSortOrder) throws IOException {
                    conflicted.incrementAndGet();
        );  
                public int read(ByteBuffer dst) throws IOException {
import java.util.Collections;
import static org.hamcrest.Matchers.is;  
            assertThat(totalBytesRead.get(), equalTo(0L));  
        final Path path = PathUtils.get(createTempDir().toString());
        final byte[] first = randomByteArrayOfLength(randomIntBetween(1, 512));  
            BlobPath.cleanPath(),
            };
        container.deleteBlobsIgnoringIfNotExists(Collections.singletonList("fence"));
        Files.createDirectories(siblingPath);  
        public SeekableByteChannel newByteChannel(Path path, Set<? extends OpenOption> opts, FileAttribute<?>... attrs) throws IOException {
    }
        assertThat(tempBlobName, containsString(blobName));
        );
        sibling.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, siblingToken);
        final byte[] content = "fence".getBytes(StandardCharsets.UTF_8);
        final byte[] second = "two".getBytes(StandardCharsets.UTF_8);
 *  
        final String token = container.writeBlobConditionally("fence", new ByteArrayInputStream(initial), initial.length, null);
        final FsBlobContainer container = newContainer();
     * its CAS; a fresh read of the recreated blob starts a new chain.  
        assertNotEquals("identical content must still produce a new version", first, second);
            Files.write(path.resolve(blobName), blobData);
import java.util.stream.Collectors;
    }
        for (int i = 0; i < writers; i++) {  
    }  
        final AtomicInteger conflicted = new AtomicInteger();
        final FsBlobContainer container = new FsBlobContainer(
        final byte[] content = "one".getBytes(StandardCharsets.UTF_8);
/*
 * this work for additional information regarding copyright
        final String tempBlobName = FsBlobContainer.tempBlobName(blobName);
            return read;
            final String nextToken = container.writeBlobConditionally("fence", new ByteArrayInputStream(next), next.length, token);
                }
    public void testWriteBlobConditionallyRejectsCreateWhenBlobExists() throws IOException {
            });  
        final FsBlobContainer sibling = new FsBlobContainer(store, BlobPath.cleanPath().add("idx-10"), siblingPath);
import org.opensearch.test.OpenSearchTestCase;
import java.util.concurrent.CyclicBarrier;  
        // The first writer's token is no longer current: its next CAS must be rejected and the blob left untouched
        @Override
            super("mockfs://", inner);
    public void testListBlobsByPrefixInLexicographicOrderWithZeroLimit() throws IOException {
import org.opensearch.common.blobstore.BlobVersionConflictException;  
import org.opensearch.common.blobstore.BlobContainer;  
 * software distributed under the License is distributed on an
        public InputStream newInputStream(Path path, OpenOption... opts) throws IOException {  
     * of identical content would be indistinguishable, and a stale writer that happens to write the current content  
    }  
    }
        container.writeBlob("fence", new ByteArrayInputStream(content), content.length, false);  
        // create-if-absent (null expected token) must now fail since the blob is present  
        final Path path = PathUtils.get(createTempDir().toString());
        final String token = container.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, null);
        IOUtils.close(fileSystem);  
                @Override
    public void testListBlobsByPrefixInLexicographicOrderWithLimitNumberOfRecords() throws IOException {
            path
                @Override  
import java.io.InputStream;
 * Licensed to Elasticsearch under one or more contributor  
        victim.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, null);
                } catch (BlobVersionConflictException e) {
        final byte[] blobData = randomByteArrayOfLength(randomIntBetween(1, frequently() ? 512 : 1 << 20)); // rarely up to 1mb
    }
import java.nio.file.Files;
        }
        // a fresh read starts a new chain over the recreated blob  
}
    public void testDeleteDoesNotInvalidateVersionTokensOfPrefixSiblingContainers() throws IOException {  
        final String tempBlobName = FsBlobContainer.tempBlobName(randomAlphaOfLengthBetween(1, 20));
 * You may obtain a copy of the License at  
                    if (blobNameSortOrder == BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC) {  
            if (read != -1) {
                @Override
        assertArrayEquals(second, container.readBlobWithVersion("fence").content());
                    @Override  
import java.nio.file.OpenOption;  
 * under the License.  
/*  
        container.writeBlobConditionally("fence", new ByteArrayInputStream(second), second.length, staleToken);
        final long start = randomLongBetween(0L, Math.max(0L, blobData.length - 1));
        if (limit >= 0) {
        final byte[] third = "three".getBytes(StandardCharsets.UTF_8);
import java.nio.channels.SeekableByteChannel;
    public void testWriteBlobConditionallyRejectsStaleToken() throws IOException {
        final String staleToken = container.writeBlobConditionally("fence", new ByteArrayInputStream(first), first.length, null);
            assertThat(Streams.consumeFully(stream), equalTo(length));
            threads.add(thread);
            assertNotNull(nextToken);  
        }  
import java.util.function.Consumer;
        final byte[] content = randomByteArrayOfLength(randomIntBetween(1, 512));  
     */
    public void testListBlobsByPrefixInLexicographicOrderWithLimitGreaterThanNumberOfRecords() throws IOException {
                    public void onResponse(List<BlobMetadata> blobMetadata) {}
        final Consumer<Long> onRead;
import org.apache.lucene.tests.util.LuceneTestCase;
                })
                    assertEquals(keys, blobMetadata.stream().map(BlobMetadata::name).collect(Collectors.toList()));  
                    return onRead(super.read(dst));  
package org.opensearch.common.blobstore.fs;
     */
            thread.join();
    public void testReadBlobWithVersionOnMissingBlobThrows() throws IOException {
        }
import java.nio.file.NoSuchFileException;
    public void testWriteBlobConditionallyLeavesNoTempBlobs() throws IOException {
    @Before  
    }  
    }  
        expectThrows(
 */  
        final FsBlobContainer container = newContainer();
import java.io.FilterInputStream;  
 * The OpenSearch Contributors require contributions made to  
public class FsBlobContainerTests extends OpenSearchTestCase {
        try (InputStream stream = container.readBlob(blobName, start, length)) {
        final FsBlobContainer container = new FsBlobContainer(new FsBlobStore(128, path, false), BlobPath.cleanPath(), path);  
import org.opensearch.common.io.PathUtils;
    static class MockFileSystemProvider extends FilterFileSystemProvider {  
        }  
import static org.hamcrest.Matchers.containsString;
        MockFileSystemProvider(FileSystem inner, Consumer<Long> onRead) {
            () -> container.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, preDeleteToken)
                    fail("blobContainer.listBlobsByPrefixInLexicographicOrder failed with exception: " + e.getMessage());
import static org.hamcrest.Matchers.equalTo;
    }
 * Modifications Copyright OpenSearch Contributors. See  
        testListBlobsByPrefixInSortedOrder(8, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);
        final FsBlobContainer victim = new FsBlobContainer(store, BlobPath.cleanPath().add("idx-1"), victimPath);
    }
     */
        testListBlobsByPrefixInSortedOrder(12, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);  
    /**
import org.junit.After;
                }  
            final VersionedBlob blob = container.readBlobWithVersion("fence");
                    List<String> keys = blobsInFileSystem.subList(0, actualLimit);
        container.writeBlob("fence", new ByteArrayInputStream(oversized), oversized.length, false);
 * specific language governing permissions and limitations
    }
            BlobVersionConflictException.class,  
     * merely shares the prefix (idx-1 vs idx-10). An over-matched invalidation makes the sibling's live writer lose a  
        assertThat(blob.versionToken(), equalTo(token));
 * the Apache License, Version 2.0 (the "License"); you may
                () -> container.listBlobsByPrefixInSortedOrder(null, limit, blobNameSortOrder, new ActionListener<>() {
        testListBlobsByPrefixInSortedOrder(10, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);
            blobsInFileSystem.add(blobName);
                }
                }
        assertThat(succeeded.get(), equalTo(1));
            });
        final FsBlobContainer container = new FsBlobContainer(
        expectThrows(NoSuchFileException.class, () -> container.readBlobWithVersion("missing"));
    }
            this.onRead = onRead;  
    }  
 */
    final AtomicLong totalBytesRead = new AtomicLong(0);  
        final byte[] oversized = randomByteArrayOfLength(129);
import org.junit.Before;  
        Files.createDirectories(victimPath);
        }  
        }
        container.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, recreatedToken);  
 * license agreements. See the NOTICE file distributed with
    public void testReadBlobWithVersionRejectsOversizedBlob() throws IOException {
import java.nio.file.spi.FileSystemProvider;  
        );  
                public void onFailure(Exception e) {
                }
        }  
 * not use this file except in compliance with the License.
    public void testTempBlobName() {  
        container.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, null);
            BlobVersionConflictException.class,
                @Override  
    public void testWriteBlobConditionallyCreatesIfAbsent() throws IOException {
    }
        fileSystem = fileSystemProvider.getFileSystem(null);  
     * CAS it should win - which, for the remote store fence, spuriously fences an unrelated shard.
                    return onRead(super.read(b, off, len));
                        blobsInFileSystem.sort(String::compareTo);
        assertThat(tempBlobName, startsWith("pending-"));  
        assertThat(conflicted.get(), equalTo(writers - 1));
 *
import java.util.Locale;
    private FsBlobContainer newContainer() throws IOException {
 * KIND, either express or implied.  See the License for the
    public void testReadBlobRangeCorrectlySkipBytes() throws IOException {  
    }  
        final List<Thread> threads = new ArrayList<>(writers);
import java.nio.file.FileSystem;  
                    }
 *     http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.startsWith;
     */  
            token = nextToken;
 * this file be licensed under the Apache-2.0 license or a
        assertThat(container.listBlobsByPrefix("pending-").keySet(), equalTo(Collections.emptySet()));
import org.opensearch.common.blobstore.BlobMetadata;
import org.apache.lucene.tests.mockfile.FilterSeekableByteChannel;
        private int onRead(int read) {  
                } catch (Exception e) {  
                    int actualLimit = Math.min(limit, 10);  
                @Override
            // no super.newInputStream(path, opts) as it will use the delegating FileSystem to open a SeekableByteChannel
import org.opensearch.common.io.Streams;
        final AtomicInteger succeeded = new AtomicInteger();  
        assertThat(totalBytesRead.get(), equalTo(0L));  
    }
        assertNotEquals(preDeleteToken, recreatedToken);
                try {  
import java.util.Set;
                onRead.accept((long) read);
                public int read(byte[] b, int off, int len) throws IOException {
            BlobPath.cleanPath(),  
            new FsBlobStore(randomIntBetween(1, 8) * 1024, path, false),  
            new FsBlobStore(randomIntBetween(1, 8) * 1024, path, false),
        final Path path = PathUtils.get(createTempDir().toString());
            return new FilterSeekableByteChannel(super.newByteChannel(path, opts, attrs)) {  
        expectThrows(
        PathUtilsForTesting.installMock(fileSystem); // restored by restoreFileSystem in OpenSearchTestCase
            // and instead we want the mocked newByteChannel() method to be used
            BlobVersionConflictException.class,
            thread.start();
        final String blobName = randomAlphaOfLengthBetween(1, 20);
import java.util.concurrent.atomic.AtomicInteger;
        Files.write(path.resolve(blobName), blobData);
     * Version tokens must be content-independent: were they derived from the bytes (e.g. a content hash), two writes
        final Path victimPath = root.resolve("idx-1");  
                        blobsInFileSystem.sort(Collections.reverseOrder(String::compareTo));  
 * Unless required by applicable law or agreed to in writing,
 */
    /**
    }
        assertArrayEquals(content, blob.content());  
 * ownership. Elasticsearch licenses this file to you under  
        final CyclicBarrier barrier = new CyclicBarrier(writers);
            );  
        // The sibling's chain is untouched: its token still wins the CAS.
        final byte[] initial = "init".getBytes(StandardCharsets.UTF_8);
        @Override
        expectThrows(  
            return new FilterInputStream(delegate.newInputStream(path, opts)) {  
 * GitHub history for details.
                    container.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, token);
                    barrier.await(10, TimeUnit.SECONDS);
import java.util.concurrent.atomic.AtomicLong;  
    public void testIsTempBlobName() {
    /**  
        final FsBlobContainer container = newContainer();
        }
     * believe they held the fence.
        container.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, null);
    }
        assertThat(newContainer().isConditionalWriteSupported(), is(false));
    public void testConcurrentConditionalWritesAdmitExactlyOneWinner() throws Exception {
     * The conditional-write methods below work, but only within one JVM: a local filesystem has no compare-and-swap, so
        final byte[] content = randomByteArrayOfLength(randomIntBetween(1, 512));  
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
                    assertEquals(actualLimit, blobMetadata.size());
 *
import org.opensearch.common.blobstore.BlobPath;
    }  
                public void onResponse(List<BlobMetadata> blobMetadata) {
        for (int i = 0; i < randomIntBetween(1, 5); i++) {  
            assertThat(totalBytesRead.get(), equalTo(length));
        testListBlobsByPrefixInSortedOrder(-5, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);
     * version - as it would be under a real object store's ETag semantics. A holder of a pre-delete token must lose
        final String blobName = randomAlphaOfLengthBetween(1, 20).toLowerCase(Locale.ROOT);
                    public void onFailure(Exception e) {}
        );
        final FsBlobContainer container = newContainer();  
    /**  
import org.opensearch.common.blobstore.VersionedBlob;
        String token = container.writeBlobConditionally("fence", new ByteArrayInputStream(first), first.length, null);
                IllegalArgumentException.class,
                    succeeded.incrementAndGet();  
            assertThrows(  
    public void testConditionalWriteIsNotReportedAsSupportedBecauseItIsOnlyEmulated() throws IOException {
            final byte[] content = ("writer-" + i).getBytes(StandardCharsets.UTF_8);
        assertThat(FsBlobContainer.isTempBlobName(tempBlobName), is(true));  
     * would pass a CAS it should lose (ABA).
        final FsBlobContainer container = newContainer();  
import java.nio.charset.StandardCharsets;
        final FsBlobContainer container = newContainer();
                    @Override  
 * SPDX-License-Identifier: Apache-2.0
        return new FsBlobContainer(new FsBlobStore(randomIntBetween(1, 8) * 1024, path, false), BlobPath.cleanPath(), path);
        final int writers = randomIntBetween(2, 8);
            final Thread thread = new Thread(() -> {
        assertTrue(e.getMessage(), e.getMessage().contains("too large"));
        testListBlobsByPrefixInSortedOrder(0, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);  
    public void testWriteBlobConditionallyChainsOnMatchingToken() throws IOException {
    public void testListBlobsByPrefixInLexicographicOrderWithLimitLessThanNumberOfRecords() throws IOException {  
import org.opensearch.common.io.PathUtilsForTesting;  
        final byte[] first = "one".getBytes(StandardCharsets.UTF_8);
     * Deleting a container must invalidate only ITS OWN blobs' version tokens, never a sibling's whose directory name
                    return onRead(super.read());  
                }  
        );
        assertThat(container.readBlobWithVersion("fence").versionToken(), equalTo(second));  
import java.nio.file.attribute.FileAttribute;
        final long length = randomLongBetween(1L, blobData.length - start);  
import java.util.List;  
            assertThat(blob.versionToken(), equalTo(nextToken));  
        List<String> blobsInFileSystem = new ArrayList<>();  
        final String preDeleteToken = container.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, null);
 * compatible open source license.
    /** Versioned reads are for small control blobs; an oversized blob at the key is refused, not buffered whole. */  
    public void testIdenticalContentYieldsDistinctVersionTokens() throws IOException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            };
     * enforces it, which is what remote store fencing needs to exclude a writer on another node, so this container must  
/*
    }
import java.nio.file.Path;
                    } else {
        final FsBlobContainer container = newContainer();  
        final FsBlobContainer container = newContainer();
    public void testDeleteInvalidatesVersionTokens() throws IOException {
            final byte[] next = randomByteArrayOfLength(randomIntBetween(1, 512));
        final String second = container.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, first);
import java.io.ByteArrayInputStream;
            () -> container.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, first)
            assertArrayEquals(next, blob.content());
        }
    }
            path
            () -> container.writeBlobConditionally("fence", new ByteArrayInputStream(third), third.length, staleToken)
        );
        final Path path = PathUtils.get(createTempDir().toString());  
                public int read() throws IOException {
import java.nio.ByteBuffer;  
        final Path root = PathUtils.get(createTempDir().toString());
        for (Thread thread : threads) {
        final byte[] content = randomByteArrayOfLength(randomIntBetween(1, 512));  
            final String blobName = randomAlphaOfLengthBetween(10, 20).toLowerCase(Locale.ROOT);
        final FsBlobContainer container = newContainer();  
    public void setupMockFileSystems() {
        assertNotNull(token);  
import org.opensearch.core.action.ActionListener;  
        final IOException e = expectThrows(IOException.class, () -> container.readBlobWithVersion("fence"));  
     * answer {@code false} however well its emulation behaves here. Two nodes sharing a filesystem would otherwise both
            () -> container.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, null)  
            }  
        victim.delete();
        final FsBlobStore store = new FsBlobStore(randomIntBetween(1, 8) * 1024, root, false);
        FileSystemProvider fileSystemProvider = new MockFileSystemProvider(PathUtils.getDefaultFileSystem(), totalBytesRead::addAndGet);
        final String siblingToken = sibling.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, null);  
        final String recreatedToken = container.readBlobWithVersion("fence").versionToken();
        final String first = container.writeBlobConditionally("fence", new ByteArrayInputStream(content), content.length, null);  
    }
    FileSystem fileSystem = null;
import org.opensearch.common.util.io.IOUtils;
    public void testListBlobsByPrefixInLexicographicOrderWithNegativeLimit() throws IOException {
        }  
    }
import org.apache.lucene.tests.mockfile.FilterFileSystemProvider;  
        for (int i = 0; i < 10; i++) {
        final byte[] content = "same-bytes".getBytes(StandardCharsets.UTF_8);
import java.io.IOException;
