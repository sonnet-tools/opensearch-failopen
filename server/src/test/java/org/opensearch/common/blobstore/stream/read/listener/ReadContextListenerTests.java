        assertTrue(Files.exists(fileLocation));
        blobPartStreams.add(  
 */  
            threadPool,
    public void testWriteToTempFile() throws Exception {
import java.util.function.UnaryOperator;  
package org.opensearch.common.blobstore.stream.read.listener;
        Path fileLocation = path.resolve(UUID.randomUUID().toString());  
        ActionListener<String> completionListener = new LatchedActionListener<>(new PlainActionFuture<>(), countDownLatch);
        List<ReadContext.StreamPartCreator> blobPartStreams = new ArrayList<>();
            @Override
        );  
import java.util.concurrent.CompletableFuture;
            completionListener,
        }  
    The deletion for the open file on an actual Windows system will be performed as soon as the last handle  
        List<ReadContext.StreamPartCreator> blobPartStreams = initializeBlobPartStreams();
        Path fileLocation = path.resolve(fileName);
                return PART_SIZE;
        readContextListener.onResponse(readContext);  
                    () -> new InputStreamContainer(testStream, PART_SIZE, (long) finalPartNumber * PART_SIZE),
        );
 */
        ReadContextListener readContextListener = new ReadContextListener(
        assertFalse(Files.exists(readContextListener.getTmpFileLocation()));
    private List<ReadContext.StreamPartCreator> initializeBlobPartStreams() {
    public void testReadContextListenerException() {  
            TEST_SEGMENT_FILE,
        Path fileLocation = path.resolve(fileName);
            MAX_CONCURRENT_STREAMS  
        Path fileLocation = path.resolve(UUID.randomUUID().toString());
    }
            @Override  
import org.apache.lucene.tests.util.LuceneTestCase.SuppressFileSystems;
    }  
            fileLocation,
    private static final int PART_SIZE = 10;  
        assertEquals(50, Files.readAllBytes(fileLocation).length);  
            @Override
        assertFalse(Files.exists(fileLocation));
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ActionListener<String> completionListener = new LatchedActionListener<>(new PlainActionFuture<>(), countDownLatch);
                )
        final String fileName = UUID.randomUUID().toString();  
import org.opensearch.threadpool.TestThreadPool;
    private static final int MAX_CONCURRENT_STREAMS = 10;
            public int read(byte[] b, int off, int len) throws IOException {  
            () -> CompletableFuture.supplyAsync(
    WindowsFS tries to simulate file handles in a best case simulation.
        assertEquals(exception, listener.getException());
            fileLocation,
            fileLocation,
            threadPool,
 * The OpenSearch Contributors require contributions made to  
        };
        ReadContextListener readContextListener = new ReadContextListener(
import java.util.ArrayList;
    public static void cleanup() {
        ByteArrayInputStream assertingStream = new ByteArrayInputStream(randomByteArrayOfLength(PART_SIZE)) {
            }  
            }
import org.opensearch.action.support.PlainActionFuture;  
            @Override
        return blobPartStreams;
 * compatible open source license.
        path = createTempDir("ReadContextListenerTests");
        CountingCompletionListener<String> listener = new CountingCompletionListener<String>();
    private static ThreadPool threadPool;
/*  
        List<ReadContext.StreamPartCreator> blobPartStreams = initializeBlobPartStreams();
            completionListener,
            listener,  
            fileLocation,  
        readContextListener.onResponse(readContext);
        List<ReadContext.StreamPartCreator> blobPartStreams = initializeBlobPartStreams();  
        IOException exception = new IOException();
            threadPool,  
        CountDownLatch countDownLatch = new CountDownLatch(1);  
            );
        for (int partNumber = 0; partNumber < NUMBER_OF_PARTS; partNumber++) {  
        assertFalse(Files.exists(readContextListener.getTmpFileLocation()));
    }  
                () -> CompletableFuture.supplyAsync(
import static org.opensearch.common.blobstore.stream.read.listener.ListenerTestUtils.CountingCompletionListener;
    }
        readContextListener.onResponse(readContext);
    }
            MAX_CONCURRENT_STREAMS
import org.opensearch.core.action.ActionListener;  
import org.junit.BeforeClass;  
                threadPool.generic()
            MAX_CONCURRENT_STREAMS
    @AfterClass  
    @BeforeClass
            TEST_SEGMENT_FILE,
                return super.read(b);
        );
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(NUMBER_OF_PARTS * PART_SIZE, Files.size(fileLocation));
    is closed, which this simulation does not account for. Preventing use of WindowsFS for these tests.
        threadPool = new TestThreadPool(ReadContextListenerTests.class.getName());  
            NUMBER_OF_PARTS,  
                assertTrue("parts written to temp file location", Files.exists(readContextListener.getTmpFileLocation()));
    public void testWriteToTempFile_alreadyExists_replacesFile() throws Exception {
            UnaryOperator.identity(),  
            UnaryOperator.identity(),
        // create an empty file at location.
            fileLocation,
        InputStream badInputStream = new InputStream() {  
import org.opensearch.common.blobstore.stream.read.ReadContext;
import org.opensearch.action.LatchedActionListener;
        final String fileName = UUID.randomUUID().toString();  
            blobPartStreams.add(  
    }
        ReadContextListener readContextListener = new ReadContextListener(  
    private Path path;  
                return read();
import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import org.junit.AfterClass;
            public int read() throws IOException {
        };
                threadPool.generic()  
                throw new IOException();  
    @Before
import java.io.IOException;  
            InputStream testStream = new ByteArrayInputStream(randomByteArrayOfLength(PART_SIZE));
            threadPool,  
import java.util.UUID;  
import java.io.InputStream;
    private static final int NUMBER_OF_PARTS = 5;
    public void testReadContextListener() throws InterruptedException, IOException {
import org.opensearch.test.OpenSearchTestCase;
            }
/*
        assertTrue(Files.exists(fileLocation));
        ReadContext readContext = new ReadContext.Builder((long) (PART_SIZE + 1) * NUMBER_OF_PARTS, blobPartStreams).build();
            () -> CompletableFuture.supplyAsync(
            )
    private static final String TEST_SEGMENT_FILE = "test_segment_file";
 *
        CountDownLatch countDownLatch = new CountDownLatch(1);
        );  
        assertEquals(0, Files.readAllBytes(fileLocation).length);
        );
        countDownLatch.await();  
    public void init() throws Exception {  
            completionListener,  
        ReadContext readContext = new ReadContext.Builder((long) PART_SIZE * NUMBER_OF_PARTS, blobPartStreams).build();
            public int available() {
        );  
    }
        countDownLatch.await();
                () -> new InputStreamContainer(badInputStream, PART_SIZE, PART_SIZE * NUMBER_OF_PARTS),  
            int finalPartNumber = partNumber;
        threadPool.shutdown();
        assertEquals(1, listener.getFailureCount());
        ActionListener<String> completionListener = new LatchedActionListener<>(new PlainActionFuture<>(), countDownLatch);
        Path fileLocation = path.resolve(UUID.randomUUID().toString());
        countDownLatch.await();
        readContextListener.onResponse(readContext);
        ReadContext readContext = new ReadContext.Builder((long) (PART_SIZE + 1) * NUMBER_OF_PARTS + 1, blobPartStreams).build();  
 * this file be licensed under the Apache-2.0 license or a
        countDownLatch.await();
    }  
            UnaryOperator.identity(),
            TEST_SEGMENT_FILE,  
            )
            }  
public class ReadContextListenerTests extends OpenSearchTestCase {
        assertTrue(Files.exists(fileLocation));
            MAX_CONCURRENT_STREAMS  
    public void testReadContextListenerFailure() throws Exception {
import org.junit.Before;
            completionListener,
import java.util.List;
        );
        List<ReadContext.StreamPartCreator> blobPartStreams = initializeBlobPartStreams();
            UnaryOperator.identity(),
        ReadContextListener readContextListener = new ReadContextListener(
import java.nio.file.Path;  
@SuppressFileSystems("WindowsFS")  
        blobPartStreams.add(
import java.util.concurrent.CountDownLatch;
    public static void setup() {
import org.opensearch.threadpool.ThreadPool;  
import org.opensearch.common.io.InputStreamContainer;
        ReadContext readContext = new ReadContext.Builder((long) (PART_SIZE + 1) * NUMBER_OF_PARTS, blobPartStreams).build();
                () -> new InputStreamContainer(assertingStream, PART_SIZE, PART_SIZE * NUMBER_OF_PARTS),
            public int read(byte[] b) throws IOException {  
            threadPool,
        Files.createFile(fileLocation);  
            NUMBER_OF_PARTS,
        CountDownLatch countDownLatch = new CountDownLatch(1);  
            MAX_CONCURRENT_STREAMS
        ReadContextListener readContextListener = new ReadContextListener(  
}  
            TEST_SEGMENT_FILE,  
        assertFalse(Files.exists(readContextListener.getTmpFileLocation()));  
        readContextListener.onFailure(exception);  
            TEST_SEGMENT_FILE,
                    threadPool.generic()  
            UnaryOperator.identity(),
    }  
        ActionListener<String> completionListener = new LatchedActionListener<>(new PlainActionFuture<>(), countDownLatch);  
