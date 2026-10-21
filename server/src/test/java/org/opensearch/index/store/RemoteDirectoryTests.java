        Mockito.doAnswer(invocation -> {
        // provideStream(p+1). With clone(), closing part p corrupts the shared segments[] and the next
            // Close this part before serving the next — this is what triggers the shared-array corruption
        IndexInput indexInput = remoteDirectory.openInput("segment_1", 100, IOContext.DEFAULT);
        }
                        + "shared MemorySegment[] array. This is the clone() bug that slice() fixes (PR #22309).",
        assertTrue(indexInput instanceof RemoteIndexInput);
            filename,
import static org.mockito.Mockito.doThrow;
    public void setup() {
        storeDirectory.sync(List.of(filename));
    public void testRename() {
    }
        }).when(blobContainer).listBlobsByPrefixInSortedOrder(eq("metadata"), eq(1), eq(LEXICOGRAPHIC), any(ActionListener.class));
        assertEquals(List.of(), remoteDirectory.listFilesByPrefixInLexicographicOrder("metadata", 1));
            return null;
        verify(blobContainer).deleteBlobsIgnoringIfNotExists(filesToDelete);
    public void testDeleteFilesWithNonExistentFiles() throws IOException {
            () -> {},
        remoteDirectory = new RemoteDirectory(blobContainer);
        assertTrue(postUploadInvoked.get());
    public void testListFilesByPrefixInLexicographicOrder() throws IOException {
import static org.opensearch.common.blobstore.BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC;
 * SPDX-License-Identifier: Apache-2.0
     * AlreadyClosedException inside the OffsetRangeIndexInputStream constructor (indexInput.seek()). The parts are
        );
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);
        assertThrows(UnsupportedOperationException.class, () -> remoteDirectory.rename("segment_1", "segment_2"));
            return null;
        when(blobContainer.listBlobsByPrefix("ab")).thenReturn(fileNames);
    /**
    }
        InputStream mockInputStream = mock(InputStream.class);
    private RemoteDirectory remoteDirectory;
        assertEquals(100, remoteDirectory.fileLength("segment_1"));
            storeDirectory,
        when(blobContainer.listBlobsByPrefixInSortedOrder("segment_1", 1, LEXICOGRAPHIC)).thenReturn(List.of(blobMetadata));
    public void testListFilesByPrefixInLexicographicOrderEmpty() throws IOException {
                }
            payload[i] = (byte) (i % 251);
            try {
    public void testListFilesByPrefixException() throws IOException {
     * clone() that shares the master's MemorySegment[] array. With clone(), closing one part's stream runs
            payload[i] = (byte) (i % 251);
        try (IndexOutput indexOutput = storeDirectory.createOutput(filename, IOContext.DEFAULT)) {
            () -> postUploadInvoked.set(true),
        // Master still usable after clone closes (slice()/clone() independence).
        when(blobContainer.listBlobsByPrefixInSortedOrder("segment_1", 1, LEXICOGRAPHIC)).thenReturn(List.of(blobMetadata));
        tracked.seek(0);
    }
        doAnswer(invocation -> {
    public void testOpenInputIOException() throws IOException {
        RemoteDirectory remoteDirectory = new RemoteDirectory(blobContainer);
        assertThrows(IOException.class, () -> remoteDirectory.openInput("segment_1", IOContext.DEFAULT));
 * compatible open source license.
        );
                container = streamContext.provideStream(p);
        // Capture the WriteContext and defer the completion listener, so the master IndexInput stays
        for (int i = 0; i < payload.length; i++) {
        BlobMetadata blobMetadata = new PlainBlobMetadata("segment_1", 100);
        assertTrue(uploadInvoked.await(10, TimeUnit.SECONDS));
    public void testDeleteFile() throws IOException {
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);
        assertTrue(countDownLatch.await(10, TimeUnit.SECONDS));
     * Tests that deleteFiles completes successfully even when some files don't exist.
    }
        doThrow(new IOException("Error writing to blob store")).when(blobContainer)
            InputStream in = container.getInputStream();
            while (read < actual.length) {
        String filename = "_100.si";
        assertThrows(NoSuchFileException.class, () -> remoteDirectory.openInput("segment_1", IOContext.DEFAULT));
     * slice(). Ported from PR #22309's DataFormatAwareRemoteDirectory coverage.
        remoteDirectory.deleteFiles(filesToDelete);
        InputStream mockInputStream = mock(InputStream.class);
     */
            byte[] actual = new byte[(int) size];
        AtomicReference<WriteContext> capturedWriteContext = new AtomicReference<>();
        CountDownLatch done = new CountDownLatch(1);
                throw new AssertionError(
        BlobMetadata blobMetadata = new PlainBlobMetadata("segment_1", 100);
                public void onFailure(Exception e) {
        when(blobContainer.listBlobsByPrefix("segment_1")).thenThrow(new NoSuchFileException("segment_1"));
        CountDownLatch countDownLatch = new CountDownLatch(1);
import java.util.stream.Collectors;
 */
    }
        when(blobContainer.readBlob("segment_1")).thenThrow(new IOException("Error while reading"));
        // producing a MultiSegmentImpl-backed MemorySegmentIndexInput. That is the only shape where
    }
        when(blobContainer.listBlobs()).thenThrow(new IOException("Error reading blob store"));
        IndexOutput indexOutput = storeDirectory.createOutput(filename, IOContext.DEFAULT);
        try (IndexOutput out = storeDirectory.createOutput(filename, IOContext.DEFAULT)) {
                }
import org.opensearch.core.action.ActionListener;
        // Delegates length and reads.
        InputStream mockInputStream = mock(InputStream.class);
        remoteDirectory.copyFrom(
     *
 * The OpenSearch Contributors require contributions made to
     * <p>The multipart upload supplier must hand each part an <b>independent</b> IndexInput (via slice()), not a
        doAnswer(invocation -> {
            latchedActionListener.onResponse(List.of());
            }
import org.opensearch.common.StreamContext;
        when(blobContainer.listBlobsByPrefixInSortedOrder("segment_1", 1, LEXICOGRAPHIC)).thenReturn(List.of(blobMetadata));
        }).when(blobContainer).asyncBlobUpload(any(WriteContext.class), any());
            for (int i = 0; i < size; i++) {
        assertEquals(payload[0], clone.readByte());
    }
        }
    }
        // Build a real on-disk file large enough to split into several parts.
            assertEquals("byte " + i, payload[i], head[i]);
        assertEquals(payload[0], tracked.readByte());
        AtomicReference<ActionListener<Void>> capturedListener = new AtomicReference<>();
                    fail("Listener responded with exception" + e);
    @Before
            in.close();
        assertFalse(postUploadInvoked.get());
            () -> postUploadInvoked.set(true),
    public void testWrapWithLifecycleTracking() throws Exception {
    /**
        AtomicReference<Boolean> postUploadInvoked = new AtomicReference<>(false);
     * Tests that deleteFiles propagates IOException when the underlying blob container operation fails.
        verify(blobContainer, times(0)).listBlobsByPrefixInSortedOrder("segment_1", 1, LEXICOGRAPHIC);
        verify(blobContainer).deleteBlobsIgnoringIfNotExists(Collections.singletonList("segment_1"));
                }
            return null;
    public void testFileLengthIOException() throws IOException {
    }
            long offset = p * partSize;
     */
        String filename = "_wrap.bin";
        remoteDirectory.copyFrom(
        Mockito.doAnswer(invocation -> {
            filename,
        assertArrayEquals(expectedFileName, actualFileNames);
    public void testCreateTempOutput() {
            out.writeBytes(payload, payload.length);
     * Tests that deleteFiles handles null collection gracefully without attempting any deletions.
        remoteDirectory.deleteFiles(null);
            ActionListener<Void> completionListener = invocation.getArgument(1);
     * time, but tracks and logs the second one as a lifecycle bug); and produce independent, still-readable clones.
import static org.mockito.Mockito.when;
    }
     * Tests that deleteFiles successfully deletes multiple files from the remote store.
     *
        assertEquals(100, indexInput.length());
        for (int i = 0; i < payload.length; i++) {
                public void onResponse(Void t) {
        verify(blobContainer).listBlobsByPrefix("abc");
     */
                @Override
        CodecUtil.writeFooter(indexOutput);
        when(blobContainer.readBlob("segment_1")).thenReturn(mockInputStream);
    private BlobContainer blobContainer;
                );
import org.opensearch.test.OpenSearchTestCase;
            completionListener.onResponse(null);
                @Override
            ActionListener<Void> completionListener = invocation.getArgument(1);
        clone.close();
            completionListener.onResponse(null);
        int numberOfParts = streamContext.getNumberOfParts();
        }
import org.opensearch.action.LatchedActionListener;
            false,
            }
        String[] expectedFileName = new String[] { "abc", "jkl", "lmn", "pqr", "xyz" };
        }
            capturedListener.set(invocation.getArgument(1));
            storeDirectory,
        assertTrue("expected multiple parts, got " + numberOfParts, numberOfParts > 1);
                    e
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);
        String filename = "_100.si";
        IndexInput tracked = remoteDirectory.wrapWithLifecycleTracking(raw, filename);
import java.util.concurrent.TimeUnit;
        }
import org.opensearch.common.blobstore.BlobContainer;
import static org.mockito.ArgumentMatchers.eq;
    }
        long fileLength = storeDirectory.fileLength(filename);
        AtomicReference<Boolean> postUploadInvoked = new AtomicReference<>(false);
    public void testFileLength() throws IOException {
    /**
public class RemoteDirectoryTests extends OpenSearchTestCase {
        // SingleSegmentImpl and would not reproduce the bug. maxChunkSize must be a power of two.
        // open while we serve part streams — mirroring how the async transfer manager consumes parts.
        Map<String, BlobMetadata> fileNames = Stream.of("abc", "xyz", "pqr", "lmn", "jkl")
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);
    public void testOpenInput() throws IOException {
                public void onResponse(Void t) {
        assertThrows(IOException.class, () -> remoteDirectory.listAll());
            filename,
            return null;
    }
                    fail("Listener responded with success");
        storeDirectory.close();
            indexOutput.writeBytes(payload, payload.length);
     */
    public void testCopyFromWithException() throws IOException, InterruptedException {
        Map<String, BlobMetadata> fileNames = Stream.of("abc", "abd", "abe", "abf", "abg")
            false,
                        + p
                @Override
        remoteDirectory.deleteFiles(Collections.emptyList());
    public void testDeleteFilesEmptyCollection() throws IOException {
     * async transfer manager consumes them and is what surfaces the corruption. Fails with clone(), passes with
        // provideStream() throws AlreadyClosedException; with slice() each part is independent.
            new LatchedActionListener<>(ActionListener.wrap(r -> {}, e -> fail("upload failed: " + e)), done),
    public void testCopyFromMultiPartStreamsAreIndependent() throws Exception {
    public void testCopyFrom() throws IOException, InterruptedException {
        assertThrows(IOException.class, () -> remoteDirectory.listFilesByPrefixInLexicographicOrder("metadata", 1));
        remoteDirectory.copyFrom(
import java.util.Collections;
            false,
import org.opensearch.common.blobstore.support.PlainBlobMetadata;
        for (int p = 0; p < numberOfParts; p++) {
        long fileLength = storeDirectory.fileLength(filename);
        verify(blobContainer, times(0)).deleteBlobsIgnoringIfNotExists(any());
            CodecUtil.writeFooter(out);
    }
            latchedActionListener.onFailure(new IOException("Error"));
        Collection<String> actualFileNames = remoteDirectory.listFilesByPrefix("ab");
        String filename = "_100.si";
    /**
import static org.mockito.ArgumentMatchers.any;
    }
            } catch (org.apache.lucene.store.AlreadyClosedException e) {
import org.apache.lucene.store.IndexInput;
        assertThrows(UnsupportedOperationException.class, () -> remoteDirectory.obtainLock("segment_1"));
import java.nio.file.NoSuchFileException;
        assertThrows(UnsupportedOperationException.class, () -> remoteDirectory.sync(Collections.emptyList()));
     * therefore served interleaved — provideStream(i) then close(i) then provideStream(i+1) — which is how the
            .deleteBlobsIgnoringIfNotExists(Collections.singletonList("segment_1"));
import java.io.InputStream;
    }
        indexOutput.writeString("Hello World!");
    /**
            },
        when(blobContainer.remoteIntegrityCheckSupported()).thenReturn(false);
        assertTrue(indexInput instanceof RemoteIndexInput);
/*
    public void testDeleteFileException() throws IOException {
     * Arrays.fill(segments, null) on the shared array, so the <i>next</i> part's provideStream() throws
import org.apache.lucene.store.Directory;
        remoteDirectory.deleteFile("segment_1");
        IndexOutput indexOutput = remoteDirectory.createOutput("segment_1", IOContext.DEFAULT);
    }
        RemoteDirectory remoteDirectory = new RemoteDirectory(blobContainer);
            new ActionListener<>() {
        doThrow(new IOException("Error writing to blob store")).when(blobContainer).deleteBlobsIgnoringIfNotExists(filesToDelete);
                int n = in.read(actual, read, actual.length - read);
        CountDownLatch countDownLatch = new CountDownLatch(1);
import org.apache.lucene.store.IOContext;
     * Tests that deleteFiles handles empty collection gracefully without attempting any deletions.
        // Complete the upload so the master IndexInput is closed via the completion listener.
     *
            .collect(Collectors.toMap(filename -> filename, filename -> new PlainBlobMetadata(filename, 100)));
        for (int i = 0; i < payload.length; i++) {
        clone.seek(0);
            },
import org.apache.lucene.store.MMapDirectory;
        IndexInput raw = storeDirectory.openInput(filename, IOContext.DEFAULT);
        verify(blobContainer, times(0)).deleteBlobsIgnoringIfNotExists(any());
 * this file be licensed under the Apache-2.0 license or a
        }).when(blobContainer).asyncBlobUpload(any(WriteContext.class), any());
        assertTrue(done.await(10, TimeUnit.SECONDS));
}
            filename,
    public void testDeleteFilesException() throws IOException {
        byte[] payload = new byte[65536];
            IOContext.DEFAULT,
import java.util.concurrent.CountDownLatch;
package org.opensearch.index.store;
        assertEquals(List.of("metadata_1"), remoteDirectory.listFilesByPrefixInLexicographicOrder("metadata", 1));
    }
 *
    }
    public void testListFilesByPrefixInLexicographicOrderException() {
        when(blobContainer.listBlobs()).thenReturn(Collections.emptyMap());
        doAnswer(invocation -> {
        storeDirectory.sync(List.of(filename));
            IOContext.DEFAULT,
    }
import java.util.Set;
            int read = 0;
                read += n;
        storeDirectory.sync(List.of(filename));
        assertTrue(countDownLatch.await(10, TimeUnit.SECONDS));
        List<String> filesToDelete = List.of("segment_1", "non_existent", "segment_2");
        verify(blobContainer).deleteBlobsIgnoringIfNotExists(filesToDelete);
            IOContext.DEFAULT,
        CountDownLatch uploadInvoked = new CountDownLatch(1);
import java.util.Map;
        // clone() yields an independent, readable input that seeks without disturbing the master.
    }
            .collect(Collectors.toMap(filename -> filename, filename -> new PlainBlobMetadata(filename, 100)));
        assertEquals(fileLength, tracked.length());
        capturedListener.get().onResponse(null);
        byte[] payload = new byte[512];
        try (IndexInput verify = storeDirectory.openInput(filename, IOContext.DEFAULT)) {
        assertThrows(IOException.class, () -> remoteDirectory.deleteFiles(filesToDelete));
    public void testDeleteFilesNullCollection() throws IOException {
import static org.mockito.Mockito.verify;
    }
        }).when(blobContainer).listBlobsByPrefixInSortedOrder(eq("metadata"), eq(1), eq(LEXICOGRAPHIC), any(ActionListener.class));
                public void onFailure(Exception e) {
        indexOutput.close();
        }
    public void testListAll() throws IOException {
        when(blobContainer.listBlobs()).thenReturn(fileNames);
        // corrupts the others via Arrays.fill(segments, null). A single-segment input clones to
    /**
        when(blobContainer.listBlobsByPrefix("segment_1")).thenThrow(new NoSuchFileException("segment_1"));
    }
    }
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);
    /**
        String[] actualFileNames = remoteDirectory.listAll();
    public void testListFilesByPrefix() throws IOException {
import static org.mockito.Mockito.doAnswer;
            new ActionListener<>() {
import static org.mockito.Mockito.mock;
        RemoteDirectory remoteDirectory = new RemoteDirectory(blobContainer);
            InputStreamContainer container;
        when(blobContainer.readBlob("segment_1")).thenReturn(mockInputStream);
     *
        List<String> filesToDelete = List.of("segment_1", "segment_2", "segment_3");
        );
import org.mockito.Mockito;
        Mockito.doAnswer(invocation -> {
                }
        StreamContext streamContext = capturedWriteContext.get().getStreamProvider(partSize);
        byte[] head = new byte[payload.length];
     * The underlying deleteBlobsIgnoringIfNotExists should handle non-existent files gracefully.
                        + ") threw AlreadyClosedException — a prior part's close() corrupted the "
    public void testOpenInputWithLength() throws IOException {
                    countDownLatch.countDown();
        assertThrows(IOException.class, () -> remoteDirectory.listFilesByPrefix("abc"));
    }
            CodecUtil.writeFooter(indexOutput);
        long partSize = (fileLength + 3) / 4;
     *
        Collection<String> expectedFileName = Set.of("abc", "abd", "abe", "abf", "abg");
    }
            null
    }
        when(blobContainer.listBlobsByPrefix("abc")).thenThrow(new IOException("Error reading blob store"));
import java.util.concurrent.atomic.AtomicReference;
    public void testGetPendingDeletions() {
        String[] actualFileNames = remoteDirectory.listAll();
        tracked.close();
import org.junit.Before;
    }
            }
    public void testSync() {
        // Double-close must not throw (it is tracked and logged, not fatal).
            long size = Math.min(partSize, fileLength - offset);
        assertThrows(IOException.class, () -> remoteDirectory.fileLength("segment_1"));
            filename,
            storeDirectory,
    }
            // under clone().
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
        storeDirectory.close();
import java.util.Collection;
        assertEquals(expectedFileName, actualFileNames);
        // Split the file into 4 parts and serve them interleaved: provideStream(p) then close before
            assertEquals(size, container.getContentLength());
import org.apache.lucene.codecs.CodecUtil;
     * The lifecycle-tracking wrapper (PR #22309, centralized in RemoteDirectory#wrapWithLifecycleTracking) must:
        // clone() shares the segments[] array by reference (MultiSegmentImpl), so closing one part
        Directory storeDirectory = LuceneTestCase.newDirectory();
        assertThrows(UnsupportedOperationException.class, () -> remoteDirectory.createTempOutput("segment_1", "tmp", IOContext.DEFAULT));
            filename,
        assertArrayEquals(expectedFileName, actualFileNames);
    }
            null
import java.util.List;
        String[] expectedFileName = new String[] {};
            uploadInvoked.countDown();
        Directory storeDirectory = new MMapDirectory(createTempDir());
    public void testCreateOutput() {
                assertTrue("unexpected EOF on part " + p, n > 0);
            return null;
        Directory storeDirectory = LuceneTestCase.newDirectory();
        storeDirectory.close();
                @Override
import org.apache.lucene.tests.util.LuceneTestCase;
            latchedActionListener.onResponse(List.of(new PlainBlobMetadata("metadata_1", 1)));
import org.opensearch.common.blobstore.BlobMetadata;
        remoteDirectory.deleteFiles(filesToDelete);
        tracked.close();
                    "provideStream("
     */
        assertEquals(100, indexInput.length());
            capturedWriteContext.set(invocation.getArgument(0));
        // Use a real MMapDirectory with a small mmap chunk size so the file spans MULTIPLE segments,
            return null;
        IndexInput indexInput = remoteDirectory.openInput("segment_1", IOContext.DEFAULT);
     * transparently delegate reads and length; survive a double-close without throwing (it delegates close each
        assertThrows(UnsupportedOperationException.class, () -> remoteDirectory.getPendingDeletions());
import java.io.IOException;
    public void testObtainLock() {
import org.opensearch.common.io.InputStreamContainer;
        assertThrows(IOException.class, () -> remoteDirectory.deleteFile("segment_1"));
        assertEquals("segment_1", indexOutput.getName());
            null
    }
        assertTrue(indexOutput instanceof RemoteIndexOutput);
        }
        storeDirectory.close();
        Directory storeDirectory = new MMapDirectory(createTempDir(), 4096L);
     */
        List<String> filesToDelete = List.of("segment_1", "segment_2");
    }
     */
    public void testDeleteFiles() throws IOException {
    public void testListAllException() throws IOException {
            verify.readBytes(fileBytes, 0, fileBytes.length);
        tracked.readBytes(head, 0, head.length);
import static org.mockito.Mockito.times;
import org.opensearch.common.blobstore.stream.write.WriteContext;
        RemoteDirectory remoteDirectory = new RemoteDirectory(mock(AsyncMultiStreamBlobContainer.class));
        }).when(blobContainer).asyncBlobUpload(any(WriteContext.class), any());
    }
        blobContainer = mock(BlobContainer.class);
        IndexInput clone = tracked.clone();
        byte[] fileBytes = new byte[(int) fileLength];
    public void testOpenInputNoSuchFileException() throws IOException {
        verify(blobContainer).listBlobsByPrefixInSortedOrder("segment_1", 1, LEXICOGRAPHIC);
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);
        when(blobContainer.readBlob("segment_1")).thenReturn(mockInputStream);
                    countDownLatch.countDown();
import java.util.stream.Stream;
        }).when(blobContainer).listBlobsByPrefixInSortedOrder(eq("metadata"), eq(1), eq(LEXICOGRAPHIC), any(ActionListener.class));
import org.apache.lucene.store.IndexOutput;
    public void testListAllEmpty() throws IOException {
     *
     * Regression test for PR #22309 ported to the non-composite (Lucene-only) upload path in RemoteDirectory.
                assertEquals("mismatch part=" + p + " byte=" + i, fileBytes[(int) offset + i], actual[i]);
        BlobMetadata blobMetadata = new PlainBlobMetadata("segment_1", 100);
