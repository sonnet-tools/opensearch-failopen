    /**
        storeDirectory.sync(List.of(filename));
        assertArrayEquals(expectedFileName, actualFileNames);
        AtomicReference<WriteContext> capturedWriteContext = new AtomicReference<>();  
    }
     *
    public void testOpenInput() throws IOException {
        when(blobContainer.listBlobs()).thenReturn(fileNames);
        BlobMetadata blobMetadata = new PlainBlobMetadata("segment_1", 100);
import org.opensearch.test.OpenSearchTestCase;
            return null;  
                throw new AssertionError(
    public void testCopyFrom() throws IOException, InterruptedException {
        when(blobContainer.listBlobsByPrefix("segment_1")).thenThrow(new NoSuchFileException("segment_1"));  
     */
        assertThrows(UnsupportedOperationException.class, () -> remoteDirectory.sync(Collections.emptyList()));  
            .deleteBlobsIgnoringIfNotExists(Collections.singletonList("segment_1"));
    public void testListAllException() throws IOException {  
                @Override  
        assertEquals(fileLength, tracked.length());
        long fileLength = storeDirectory.fileLength(filename);
                @Override  
        int numberOfParts = streamContext.getNumberOfParts();
        Collection<String> actualFileNames = remoteDirectory.listFilesByPrefix("ab");  
                public void onFailure(Exception e) {
        when(blobContainer.remoteIntegrityCheckSupported()).thenReturn(false);
    public void testSync() {
        // Capture the WriteContext and defer the completion listener, so the master IndexInput stays
        capturedListener.get().onResponse(null);
        doThrow(new IOException("Error writing to blob store")).when(blobContainer).deleteBlobsIgnoringIfNotExists(filesToDelete);  
            () -> postUploadInvoked.set(true),
            false,
import static org.mockito.Mockito.doThrow;
        assertTrue(countDownLatch.await(10, TimeUnit.SECONDS));
        // Master still usable after clone closes (slice()/clone() independence).
        // Split the file into 4 parts and serve them interleaved: provideStream(p) then close before
        when(blobContainer.listBlobsByPrefix("abc")).thenThrow(new IOException("Error reading blob store"));  
        }
            int read = 0;
import org.apache.lucene.codecs.CodecUtil;
        // producing a MultiSegmentImpl-backed MemorySegmentIndexInput. That is the only shape where  
        assertThrows(IOException.class, () -> remoteDirectory.fileLength("segment_1"));  
            storeDirectory,
        for (int i = 0; i < payload.length; i++) {  
     * transparently delegate reads and length; survive a double-close without throwing (it delegates close each  
        // corrupts the others via Arrays.fill(segments, null). A single-segment input clones to
            try {
            indexOutput.writeBytes(payload, payload.length);  
        // Complete the upload so the master IndexInput is closed via the completion listener.  
        verify(blobContainer).listBlobsByPrefixInSortedOrder("segment_1", 1, LEXICOGRAPHIC);
            uploadInvoked.countDown();
            CodecUtil.writeFooter(out);  
import org.opensearch.action.LatchedActionListener;
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);
        CodecUtil.writeFooter(indexOutput);  
        assertTrue(countDownLatch.await(10, TimeUnit.SECONDS));
    }
     */
            new ActionListener<>() {  
            assertEquals(size, container.getContentLength());
                read += n;
import java.util.concurrent.CountDownLatch;
    public void setup() {
            IOContext.DEFAULT,
        byte[] payload = new byte[65536];  
        InputStream mockInputStream = mock(InputStream.class);
import static org.mockito.Mockito.doAnswer;  
        for (int i = 0; i < payload.length; i++) {
            payload[i] = (byte) (i % 251);
import org.apache.lucene.store.IOContext;  
                    countDownLatch.countDown();  
        // open while we serve part streams — mirroring how the async transfer manager consumes parts.
        assertEquals(List.of(), remoteDirectory.listFilesByPrefixInLexicographicOrder("metadata", 1));
        Map<String, BlobMetadata> fileNames = Stream.of("abc", "xyz", "pqr", "lmn", "jkl")
    public void testOpenInputWithLength() throws IOException {
        tracked.close();
            capturedWriteContext.set(invocation.getArgument(0));  
        storeDirectory.sync(List.of(filename));
            return null;  
        assertThrows(IOException.class, () -> remoteDirectory.deleteFile("segment_1"));
            filename,
        when(blobContainer.listBlobsByPrefixInSortedOrder("segment_1", 1, LEXICOGRAPHIC)).thenReturn(List.of(blobMetadata));
                }  
        when(blobContainer.listBlobsByPrefixInSortedOrder("segment_1", 1, LEXICOGRAPHIC)).thenReturn(List.of(blobMetadata));
    public void testOpenInputIOException() throws IOException {  
            long offset = p * partSize;
import static org.mockito.ArgumentMatchers.any;
import java.util.Set;  
        }
    }
    public void testGetPendingDeletions() {  
        when(blobContainer.listBlobsByPrefixInSortedOrder("segment_1", 1, LEXICOGRAPHIC)).thenReturn(List.of(blobMetadata));
        assertEquals("segment_1", indexOutput.getName());
    public void testRename() {  
        remoteDirectory.deleteFile("segment_1");
            CodecUtil.writeFooter(indexOutput);
        assertFalse(postUploadInvoked.get());  
                    countDownLatch.countDown();
import java.nio.file.NoSuchFileException;
import org.apache.lucene.tests.util.LuceneTestCase;
     *  
    /**
        byte[] fileBytes = new byte[(int) fileLength];
     * Tests that deleteFiles successfully deletes multiple files from the remote store.  
        remoteDirectory.deleteFiles(null);
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);
        verify(blobContainer).deleteBlobsIgnoringIfNotExists(Collections.singletonList("segment_1"));  
            }  
        clone.close();  
            return null;
            for (int i = 0; i < size; i++) {
        AtomicReference<ActionListener<Void>> capturedListener = new AtomicReference<>();
        verify(blobContainer).listBlobsByPrefix("abc");  
        Mockito.doAnswer(invocation -> {
    }
        assertEquals(List.of("metadata_1"), remoteDirectory.listFilesByPrefixInLexicographicOrder("metadata", 1));
    }
    public void testListAll() throws IOException {
        assertThrows(NoSuchFileException.class, () -> remoteDirectory.openInput("segment_1", IOContext.DEFAULT));
        assertThrows(UnsupportedOperationException.class, () -> remoteDirectory.obtainLock("segment_1"));
    private RemoteDirectory remoteDirectory;
        List<String> filesToDelete = List.of("segment_1", "segment_2", "segment_3");  
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);  
        when(blobContainer.readBlob("segment_1")).thenReturn(mockInputStream);
    }
        IndexOutput indexOutput = storeDirectory.createOutput(filename, IOContext.DEFAULT);
        // provideStream() throws AlreadyClosedException; with slice() each part is independent.
            IOContext.DEFAULT,
            latchedActionListener.onResponse(List.of());
    /**
        byte[] payload = new byte[512];
    public void testListFilesByPrefixInLexicographicOrderEmpty() throws IOException {
    public void testDeleteFilesWithNonExistentFiles() throws IOException {
        assertThrows(UnsupportedOperationException.class, () -> remoteDirectory.rename("segment_1", "segment_2"));
        assertThrows(IOException.class, () -> remoteDirectory.listFilesByPrefixInLexicographicOrder("metadata", 1));  
            long size = Math.min(partSize, fileLength - offset);  
import org.mockito.Mockito;
        String[] expectedFileName = new String[] {};
        remoteDirectory.copyFrom(  
            filename,  
                        + ") threw AlreadyClosedException — a prior part's close() corrupted the "
            // Close this part before serving the next — this is what triggers the shared-array corruption
     * AlreadyClosedException inside the OffsetRangeIndexInputStream constructor (indexInput.seek()). The parts are
        Mockito.doAnswer(invocation -> {  
import java.util.concurrent.TimeUnit;
        );
 * compatible open source license.
import java.io.InputStream;  
        tracked.readBytes(head, 0, head.length);  
import org.apache.lucene.store.IndexInput;
        IndexInput raw = storeDirectory.openInput(filename, IOContext.DEFAULT);  
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
    }  
 *
     * slice(). Ported from PR #22309's DataFormatAwareRemoteDirectory coverage.
        storeDirectory.close();
    }
            verify.readBytes(fileBytes, 0, fileBytes.length);
        assertTrue(indexInput instanceof RemoteIndexInput);
    }  
        when(blobContainer.listBlobs()).thenThrow(new IOException("Error reading blob store"));
            completionListener.onResponse(null);
import org.apache.lucene.store.MMapDirectory;  
        assertTrue(uploadInvoked.await(10, TimeUnit.SECONDS));  
            filename,  
    @Before  
            filename,
            new LatchedActionListener<>(ActionListener.wrap(r -> {}, e -> fail("upload failed: " + e)), done),
     * Regression test for PR #22309 ported to the non-composite (Lucene-only) upload path in RemoteDirectory.
        try (IndexOutput out = storeDirectory.createOutput(filename, IOContext.DEFAULT)) {
    public void testListFilesByPrefixException() throws IOException {
        }).when(blobContainer).asyncBlobUpload(any(WriteContext.class), any());
        }).when(blobContainer).listBlobsByPrefixInSortedOrder(eq("metadata"), eq(1), eq(LEXICOGRAPHIC), any(ActionListener.class));
    }
            }  
import static org.mockito.Mockito.mock;
        RemoteDirectory remoteDirectory = new RemoteDirectory(blobContainer);
            false,  
     *
     * time, but tracks and logs the second one as a lifecycle bug); and produce independent, still-readable clones.
/*  
    public void testObtainLock() {
        doAnswer(invocation -> {  
        verify(blobContainer, times(0)).deleteBlobsIgnoringIfNotExists(any());
            () -> postUploadInvoked.set(true),
                }
        assertThrows(UnsupportedOperationException.class, () -> remoteDirectory.getPendingDeletions());
 * SPDX-License-Identifier: Apache-2.0
        }
        verify(blobContainer, times(0)).deleteBlobsIgnoringIfNotExists(any());
            ActionListener<Void> completionListener = invocation.getArgument(1);  
     * The underlying deleteBlobsIgnoringIfNotExists should handle non-existent files gracefully.
import java.util.Collections;  
    }  
            while (read < actual.length) {
                int n = in.read(actual, read, actual.length - read);  
        assertArrayEquals(expectedFileName, actualFileNames);  
import org.opensearch.common.blobstore.support.PlainBlobMetadata;
    public void testOpenInputNoSuchFileException() throws IOException {  
    public void testDeleteFiles() throws IOException {
    public void testCopyFromWithException() throws IOException, InterruptedException {
    public void testListAllEmpty() throws IOException {  
    public void testDeleteFileException() throws IOException {  
        String[] actualFileNames = remoteDirectory.listAll();  
        }).when(blobContainer).listBlobsByPrefixInSortedOrder(eq("metadata"), eq(1), eq(LEXICOGRAPHIC), any(ActionListener.class));
            filename,
            },
        }).when(blobContainer).asyncBlobUpload(any(WriteContext.class), any());  
        when(blobContainer.listBlobsByPrefix("ab")).thenReturn(fileNames);
            storeDirectory,
    public void testWrapWithLifecycleTracking() throws Exception {  
    }
                public void onResponse(Void t) {
        verify(blobContainer).deleteBlobsIgnoringIfNotExists(filesToDelete);
        byte[] head = new byte[payload.length];
            }  
        String filename = "_100.si";
        Directory storeDirectory = new MMapDirectory(createTempDir());  
    }
        // SingleSegmentImpl and would not reproduce the bug. maxChunkSize must be a power of two.  
import org.opensearch.common.blobstore.BlobMetadata;  
        storeDirectory.close();
        Directory storeDirectory = LuceneTestCase.newDirectory();
            return null;
        when(blobContainer.listBlobs()).thenReturn(Collections.emptyMap());
        verify(blobContainer).deleteBlobsIgnoringIfNotExists(filesToDelete);  
            null
    }  
        clone.seek(0);
        BlobMetadata blobMetadata = new PlainBlobMetadata("segment_1", 100);  
        Map<String, BlobMetadata> fileNames = Stream.of("abc", "abd", "abe", "abf", "abg")
    }
                assertEquals("mismatch part=" + p + " byte=" + i, fileBytes[(int) offset + i], actual[i]);
        }
    }
            null  
import static org.mockito.Mockito.times;  
            InputStreamContainer container;
    }
     */
        indexOutput.writeString("Hello World!");
        when(blobContainer.readBlob("segment_1")).thenReturn(mockInputStream);
        verify(blobContainer, times(0)).listBlobsByPrefixInSortedOrder("segment_1", 1, LEXICOGRAPHIC);  
        remoteDirectory.deleteFiles(filesToDelete);
        // Double-close must not throw (it is tracked and logged, not fatal).  
import org.junit.Before;  
 */  
            capturedListener.set(invocation.getArgument(1));
        BlobMetadata blobMetadata = new PlainBlobMetadata("segment_1", 100);  
        IndexInput indexInput = remoteDirectory.openInput("segment_1", 100, IOContext.DEFAULT);  
        );
            payload[i] = (byte) (i % 251);
        // Delegates length and reads.  
                container = streamContext.provideStream(p);  
    public void testListFilesByPrefixInLexicographicOrderException() {
        AtomicReference<Boolean> postUploadInvoked = new AtomicReference<>(false);  
public class RemoteDirectoryTests extends OpenSearchTestCase {
        // provideStream(p+1). With clone(), closing part p corrupts the shared segments[] and the next  
            new ActionListener<>() {  
import static org.opensearch.common.blobstore.BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC;  
    }
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);  
    public void testCopyFromMultiPartStreamsAreIndependent() throws Exception {  
        String filename = "_100.si";  
            filename,
        Mockito.doAnswer(invocation -> {
        remoteDirectory = new RemoteDirectory(blobContainer);  
        long fileLength = storeDirectory.fileLength(filename);  
import static org.mockito.ArgumentMatchers.eq;
                    e
    }  
        assertTrue(postUploadInvoked.get());  
        RemoteDirectory remoteDirectory = new RemoteDirectory(blobContainer);
import java.util.stream.Collectors;
        // Build a real on-disk file large enough to split into several parts.
     * Tests that deleteFiles handles empty collection gracefully without attempting any deletions.  
        when(blobContainer.readBlob("segment_1")).thenReturn(mockInputStream);  
            completionListener.onResponse(null);
            // under clone().
        remoteDirectory.deleteFiles(Collections.emptyList());  
        assertTrue("expected multiple parts, got " + numberOfParts, numberOfParts > 1);
        RemoteDirectory remoteDirectory = new RemoteDirectory(blobContainer);
        CountDownLatch done = new CountDownLatch(1);  
        try (IndexInput verify = storeDirectory.openInput(filename, IOContext.DEFAULT)) {  
            ActionListener<Void> completionListener = invocation.getArgument(1);
    }  
     * Tests that deleteFiles completes successfully even when some files don't exist.
import org.apache.lucene.store.IndexOutput;
     * <p>The multipart upload supplier must hand each part an <b>independent</b> IndexInput (via slice()), not a
                    fail("Listener responded with success");  
            .collect(Collectors.toMap(filename -> filename, filename -> new PlainBlobMetadata(filename, 100)));
        doAnswer(invocation -> {
            } catch (org.apache.lucene.store.AlreadyClosedException e) {
import org.apache.lucene.store.Directory;
     */  
    }
     * The lifecycle-tracking wrapper (PR #22309, centralized in RemoteDirectory#wrapWithLifecycleTracking) must:
    public void testDeleteFile() throws IOException {  
                    fail("Listener responded with exception" + e);
        Collection<String> expectedFileName = Set.of("abc", "abd", "abe", "abf", "abg");
    /**
        for (int i = 0; i < payload.length; i++) {
        assertEquals(payload[0], tracked.readByte());
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
        when(blobContainer.readBlob("segment_1")).thenThrow(new IOException("Error while reading"));
        for (int p = 0; p < numberOfParts; p++) {
    /**
}
    public void testCreateOutput() {
                public void onFailure(Exception e) {
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);
            IOContext.DEFAULT,  
import java.util.concurrent.atomic.AtomicReference;  
    private BlobContainer blobContainer;
        CountDownLatch countDownLatch = new CountDownLatch(1);
     * Arrays.fill(segments, null) on the shared array, so the <i>next</i> part's provideStream() throws  
    /**
        IndexInput tracked = remoteDirectory.wrapWithLifecycleTracking(raw, filename);
        List<String> filesToDelete = List.of("segment_1", "segment_2");
            null  
            InputStream in = container.getInputStream();  
                }
        assertThrows(IOException.class, () -> remoteDirectory.listFilesByPrefix("abc"));
    public void testDeleteFilesException() throws IOException {
    }  
    public void testListFilesByPrefix() throws IOException {  
     * Tests that deleteFiles handles null collection gracefully without attempting any deletions.
        long partSize = (fileLength + 3) / 4;
        String[] actualFileNames = remoteDirectory.listAll();
        assertEquals(100, remoteDirectory.fileLength("segment_1"));  
        assertThrows(UnsupportedOperationException.class, () -> remoteDirectory.createTempOutput("segment_1", "tmp", IOContext.DEFAULT));
     * async transfer manager consumes them and is what surfaces the corruption. Fails with clone(), passes with  
import java.util.List;
        InputStream mockInputStream = mock(InputStream.class);
        }  
                        + p
            false,
                @Override
        assertThrows(IOException.class, () -> remoteDirectory.openInput("segment_1", IOContext.DEFAULT));  
        IndexOutput indexOutput = remoteDirectory.createOutput("segment_1", IOContext.DEFAULT);  
                @Override
        assertEquals(expectedFileName, actualFileNames);
        }).when(blobContainer).asyncBlobUpload(any(WriteContext.class), any());
import org.opensearch.common.StreamContext;  
        // Use a real MMapDirectory with a small mmap chunk size so the file spans MULTIPLE segments,
            assertEquals("byte " + i, payload[i], head[i]);
    public void testListFilesByPrefixInLexicographicOrder() throws IOException {  
     * Tests that deleteFiles propagates IOException when the underlying blob container operation fails.
        assertEquals(100, indexInput.length());
     * clone() that shares the master's MemorySegment[] array. With clone(), closing one part's stream runs
        storeDirectory.close();
        }  
        InputStream mockInputStream = mock(InputStream.class);  
        doThrow(new IOException("Error writing to blob store")).when(blobContainer)
        String filename = "_wrap.bin";
        when(blobContainer.listBlobsByPrefix("segment_1")).thenThrow(new NoSuchFileException("segment_1"));
            storeDirectory,  
                    "provideStream("  
        AtomicReference<Boolean> postUploadInvoked = new AtomicReference<>(false);
     */  
        Directory storeDirectory = new MMapDirectory(createTempDir(), 4096L);
            latchedActionListener.onResponse(List.of(new PlainBlobMetadata("metadata_1", 1)));  
    }
        IndexInput clone = tracked.clone();  
            out.writeBytes(payload, payload.length);
            return null;  
        tracked.seek(0);  
     */
        assertEquals(100, indexInput.length());  
        );
        remoteDirectory.deleteFiles(filesToDelete);
    public void testFileLengthIOException() throws IOException {  
    }  
import java.util.Map;
        tracked.close();
        }).when(blobContainer).listBlobsByPrefixInSortedOrder(eq("metadata"), eq(1), eq(LEXICOGRAPHIC), any(ActionListener.class));  
        storeDirectory.close();
        IndexInput indexInput = remoteDirectory.openInput("segment_1", IOContext.DEFAULT);
        assertTrue(indexInput instanceof RemoteIndexInput);
    }
    }  
        RemoteDirectory remoteDirectory = new RemoteDirectory(mock(AsyncMultiStreamBlobContainer.class));
        Directory storeDirectory = LuceneTestCase.newDirectory();  
                }  
        assertThrows(IOException.class, () -> remoteDirectory.listAll());  
            },
            return null;
    public void testFileLength() throws IOException {
    }  
import org.opensearch.core.action.ActionListener;
        }
import static org.mockito.Mockito.when;
                public void onResponse(Void t) {
import org.opensearch.common.io.InputStreamContainer;  
            in.close();  
        assertThrows(IOException.class, () -> remoteDirectory.deleteFiles(filesToDelete));
        remoteDirectory.copyFrom(  
import org.opensearch.common.blobstore.stream.write.WriteContext;
    }
        assertTrue(done.await(10, TimeUnit.SECONDS));
                assertTrue("unexpected EOF on part " + p, n > 0);
    public void testDeleteFilesNullCollection() throws IOException {  
import java.util.stream.Stream;
                        + "shared MemorySegment[] array. This is the clone() bug that slice() fixes (PR #22309).",  
import static org.mockito.Mockito.verify;
            () -> {},
        blobContainer = mock(BlobContainer.class);
        String filename = "_100.si";
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(indexOutput instanceof RemoteIndexOutput);
        try (IndexOutput indexOutput = storeDirectory.createOutput(filename, IOContext.DEFAULT)) {
     *  
     */
        remoteDirectory.copyFrom(
     *  
            .collect(Collectors.toMap(filename -> filename, filename -> new PlainBlobMetadata(filename, 100)));  
    }
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);
        StreamContext streamContext = capturedWriteContext.get().getStreamProvider(partSize);  
        // clone() yields an independent, readable input that seeks without disturbing the master.
     * therefore served interleaved — provideStream(i) then close(i) then provideStream(i+1) — which is how the
        List<String> filesToDelete = List.of("segment_1", "non_existent", "segment_2");
        assertEquals(payload[0], clone.readByte());
import org.opensearch.common.blobstore.BlobContainer;
    /**  
     *
package org.opensearch.index.store;
        doAnswer(invocation -> {
            byte[] actual = new byte[(int) size];
    }
        CountDownLatch uploadInvoked = new CountDownLatch(1);
    }
    public void testDeleteFilesEmptyCollection() throws IOException {
        storeDirectory.sync(List.of(filename));  
        // clone() shares the segments[] array by reference (MultiSegmentImpl), so closing one part
                );
            latchedActionListener.onFailure(new IOException("Error"));
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String[] expectedFileName = new String[] { "abc", "jkl", "lmn", "pqr", "xyz" };
        indexOutput.close();
    public void testCreateTempOutput() {
    }
import java.util.Collection;
