        CountDownLatch countDownLatch = new CountDownLatch(1);
            )
        };
        assertEquals(NUMBER_OF_PARTS * PART_SIZE, Files.size(fileLocation));
            blobPartStreams.add(
        return blobPartStreams;
import java.nio.file.Path;
    public static void setup() {
        List<ReadContext.StreamPartCreator> blobPartStreams = initializeBlobPartStreams();
package org.opensearch.common.blobstore.stream.read.listener;
            InputStream testStream = new ByteArrayInputStream(randomByteArrayOfLength(PART_SIZE));
        final String fileName = UUID.randomUUID().toString();
        countDownLatch.await();
        threadPool.shutdown();
        );
    is closed, which this simulation does not account for. Preventing use of WindowsFS for these tests.
            )
        readContextListener.onResponse(readContext);
        assertFalse(Files.exists(readContextListener.getTmpFileLocation()));
import org.opensearch.threadpool.TestThreadPool;
            threadPool,
            MAX_CONCURRENT_STREAMS
/*
            }
import org.opensearch.common.blobstore.stream.read.ReadContext;
        List<ReadContext.StreamPartCreator> blobPartStreams = initializeBlobPartStreams();
            TEST_SEGMENT_FILE,
        ReadContextListener readContextListener = new ReadContextListener(
        ReadContext readContext = new ReadContext.Builder((long) PART_SIZE * NUMBER_OF_PARTS, blobPartStreams).build();
    public void testReadContextListenerException() {
            public int read(byte[] b) throws IOException {
            NUMBER_OF_PARTS,
            MAX_CONCURRENT_STREAMS
        List<ReadContext.StreamPartCreator> blobPartStreams = initializeBlobPartStreams();
            threadPool,
        assertFalse(Files.exists(fileLocation));
    private Path path;
            public int available() {
    public static void cleanup() {
import org.junit.BeforeClass;
    private static final int NUMBER_OF_PARTS = 5;
        assertEquals(0, Files.readAllBytes(fileLocation).length);
    }
        List<ReadContext.StreamPartCreator> blobPartStreams = new ArrayList<>();
            @Override
import org.opensearch.core.action.ActionListener;
                    () -> new InputStreamContainer(testStream, PART_SIZE, (long) finalPartNumber * PART_SIZE),
        );
        );
        Path fileLocation = path.resolve(UUID.randomUUID().toString());
        assertTrue(Files.exists(fileLocation));
    }
import java.util.concurrent.CountDownLatch;
        IOException exception = new IOException();
        ActionListener<String> completionListener = new LatchedActionListener<>(new PlainActionFuture<>(), countDownLatch);
import java.util.concurrent.CompletableFuture;
import java.util.UUID;
        countDownLatch.await();
        );
    }
        final String fileName = UUID.randomUUID().toString();
            UnaryOperator.identity(),
            threadPool,
            fileLocation,
    private static final int PART_SIZE = 10;
        Path fileLocation = path.resolve(fileName);
        readContextListener.onResponse(readContext);
            MAX_CONCURRENT_STREAMS
            UnaryOperator.identity(),
        assertEquals(50, Files.readAllBytes(fileLocation).length);
            @Override
                () -> CompletableFuture.supplyAsync(
import org.apache.lucene.tests.util.LuceneTestCase.SuppressFileSystems;
        ByteArrayInputStream assertingStream = new ByteArrayInputStream(randomByteArrayOfLength(PART_SIZE)) {
            fileLocation,
            () -> CompletableFuture.supplyAsync(
        ReadContext readContext = new ReadContext.Builder((long) (PART_SIZE + 1) * NUMBER_OF_PARTS + 1, blobPartStreams).build();
    }
 */
            UnaryOperator.identity(),
        countDownLatch.await();
        blobPartStreams.add(
                return PART_SIZE;
            threadPool,
import org.opensearch.action.support.PlainActionFuture;
        ReadContextListener readContextListener = new ReadContextListener(
            completionListener,
        ReadContextListener readContextListener = new ReadContextListener(
    @Before
        );
            @Override
            );
        Path fileLocation = path.resolve(UUID.randomUUID().toString());
            }
            fileLocation,
    }
import java.nio.file.Files;
    @BeforeClass
        threadPool = new TestThreadPool(ReadContextListenerTests.class.getName());
import java.util.ArrayList;
        CountDownLatch countDownLatch = new CountDownLatch(1);
import org.junit.AfterClass;
    private static final String TEST_SEGMENT_FILE = "test_segment_file";
import org.junit.Before;
        );
            TEST_SEGMENT_FILE,
import static org.opensearch.common.blobstore.stream.read.listener.ListenerTestUtils.CountingCompletionListener;
            completionListener,
        CountDownLatch countDownLatch = new CountDownLatch(1);
            TEST_SEGMENT_FILE,
            }
        ReadContext readContext = new ReadContext.Builder((long) (PART_SIZE + 1) * NUMBER_OF_PARTS, blobPartStreams).build();
            completionListener,
 */
                () -> new InputStreamContainer(assertingStream, PART_SIZE, PART_SIZE * NUMBER_OF_PARTS),
            completionListener,
    }
}
    private List<ReadContext.StreamPartCreator> initializeBlobPartStreams() {
        assertTrue(Files.exists(fileLocation));
            int finalPartNumber = partNumber;
        blobPartStreams.add(
import java.io.InputStream;
            }
        ReadContextListener readContextListener = new ReadContextListener(
    }
    WindowsFS tries to simulate file handles in a best case simulation.
        path = createTempDir("ReadContextListenerTests");
        assertTrue(Files.exists(fileLocation));
 * The OpenSearch Contributors require contributions made to
 *
    public void testWriteToTempFile() throws Exception {
    }
                )
    The deletion for the open file on an actual Windows system will be performed as soon as the last handle
            public int read() throws IOException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ActionListener<String> completionListener = new LatchedActionListener<>(new PlainActionFuture<>(), countDownLatch);
 * SPDX-License-Identifier: Apache-2.0
            @Override
        readContextListener.onResponse(readContext);
/*
            TEST_SEGMENT_FILE,
import java.util.List;
        Files.createFile(fileLocation);
        readContextListener.onResponse(readContext);
                () -> new InputStreamContainer(badInputStream, PART_SIZE, PART_SIZE * NUMBER_OF_PARTS),
import org.opensearch.threadpool.ThreadPool;
        assertEquals(exception, listener.getException());
import org.opensearch.action.LatchedActionListener;
        Path fileLocation = path.resolve(fileName);
            UnaryOperator.identity(),
                threadPool.generic()
            NUMBER_OF_PARTS,
            MAX_CONCURRENT_STREAMS
            MAX_CONCURRENT_STREAMS
        assertFalse(Files.exists(readContextListener.getTmpFileLocation()));
                assertTrue("parts written to temp file location", Files.exists(readContextListener.getTmpFileLocation()));
import java.io.ByteArrayInputStream;
 * this file be licensed under the Apache-2.0 license or a
            () -> CompletableFuture.supplyAsync(
                return super.read(b);
@SuppressFileSystems("WindowsFS")
        // create an empty file at location.
        countDownLatch.await();
                    threadPool.generic()
            listener,
    @AfterClass
                throw new IOException();
        List<ReadContext.StreamPartCreator> blobPartStreams = initializeBlobPartStreams();
        ActionListener<String> completionListener = new LatchedActionListener<>(new PlainActionFuture<>(), countDownLatch);
        readContextListener.onFailure(exception);
                return read();
        ActionListener<String> completionListener = new LatchedActionListener<>(new PlainActionFuture<>(), countDownLatch);
        assertEquals(1, listener.getFailureCount());
        Path fileLocation = path.resolve(UUID.randomUUID().toString());
    public void testReadContextListener() throws InterruptedException, IOException {
import java.io.IOException;
        assertFalse(Files.exists(readContextListener.getTmpFileLocation()));
public class ReadContextListenerTests extends OpenSearchTestCase {
    public void init() throws Exception {
        for (int partNumber = 0; partNumber < NUMBER_OF_PARTS; partNumber++) {
import org.opensearch.test.OpenSearchTestCase;
            public int read(byte[] b, int off, int len) throws IOException {
    private static ThreadPool threadPool;
    public void testWriteToTempFile_alreadyExists_replacesFile() throws Exception {
    public void testReadContextListenerFailure() throws Exception {
        ReadContext readContext = new ReadContext.Builder((long) (PART_SIZE + 1) * NUMBER_OF_PARTS, blobPartStreams).build();
        CountingCompletionListener<String> listener = new CountingCompletionListener<String>();
            fileLocation,
    private static final int MAX_CONCURRENT_STREAMS = 10;
        InputStream badInputStream = new InputStream() {
import java.util.function.UnaryOperator;
import org.opensearch.common.io.InputStreamContainer;
            TEST_SEGMENT_FILE,
 * compatible open source license.
        ReadContextListener readContextListener = new ReadContextListener(
        };
    }
        );
        }
                threadPool.generic()
            fileLocation,
            threadPool,
            UnaryOperator.identity(),
