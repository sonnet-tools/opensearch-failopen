public class ReadContextListener implements ActionListener<ReadContext> {
            this.queue = queue;
                    processFailure(throwable instanceof Exception ? (Exception) throwable : new RuntimeException(throwable));
    }
    @Override
        this.rateLimiter = rateLimiter;
    }  
    public void onFailure(Exception e) {  
            groupedListener,
        return ActionListener.wrap(response -> {  
import org.opensearch.core.action.ActionListener;  
    private final ThreadPool threadPool;
        this.completionListener = completionListener;  
                        processFailure(e);
        final Queue<ReadContext.StreamPartCreator> queue = new ConcurrentLinkedQueue<>(readContext.getPartStreams());
            try {
 */  
 * compatible open source license.
import org.opensearch.threadpool.ThreadPool;
                logger.error("Unable to rename temp file + " + tmpFileLocation, e);  
                // Drain the queue of pending part downloads. These can be discarded
                Object item = queue.poll();
    /*
        Path fileLocation,
package org.opensearch.common.blobstore.stream.read.listener;
                Files.deleteIfExists(tmpFileLocation);
            } catch (IOException ex) {  
        private final Queue<ReadContext.StreamPartCreator> queue;
/**  
        private StreamPartProcessor(  
        });
            logger.trace("renaming temp file [{}] to [{}]", tmpFileLocation, fileLocation);
        ActionListener<String> completionListener,
            threadPool.executor(ThreadPool.Names.REMOTE_RECOVERY),
    public ReadContextListener(
        }, e -> {  
import java.nio.file.Path;  
        );
                logger.info("Failed to delete file {} on stream failure: {}", fileLocation, ex);
 * this file be licensed under the Apache-2.0 license or a
            }  
                while (item != null) {  
                // Die silently
        final AtomicBoolean anyPartStreamFailed = new AtomicBoolean(false);  
    }
import java.nio.file.Files;
        private void process(ReadContext.StreamPartCreator supplier) {
            } else {
        UnaryOperator<InputStream> rateLimiter,
            UnaryOperator<InputStream> rateLimiter  
import java.util.Queue;  
            this.completionListener = completionListener;
import org.apache.logging.log4j.LogManager;
            }  
        this.threadPool = threadPool;
                return;  
                        FilePartWriter.write(fileLocation, blobPartStreamContainer, rateLimiter);  
 *
            GroupedActionListener<String> completionListener,
                Files.deleteIfExists(fileLocation);
                IOUtils.fsync(fileLocation.getParent(), true);  
import java.util.concurrent.Executor;
    public void onResponse(ReadContext readContext) {  
 * SPDX-License-Identifier: Apache-2.0
    }
    Path getTmpFileLocation() {
                }  
        this.fileLocation = fileLocation;
                Files.move(tmpFileLocation, fileLocation, StandardCopyOption.ATOMIC_MOVE);
            queue,
    ) {  
            } catch (IOException e) {
import java.nio.file.StandardCopyOption;
     */  
    private static final Logger logger = LogManager.getLogger(ReadContextListener.class);  
            }
                    } catch (Exception e) {  
                } else {
            this.anyPartStreamFailed = anyPartStreamFailed;  
            completionListener.onFailure(e);  
                        process(queue.poll());
            Path fileLocation,  
        for (int i = 0; i < Math.min(maxConcurrentStreams, queue.size()); i++) {
        this.blobName = blobName;
    }
        private static final RuntimeException CANCELED_PART_EXCEPTION = new RuntimeException(
    @SuppressForbidden(reason = "need to fsync once all parts received")
                    processFailure(CANCELED_PART_EXCEPTION);  
                completionListener.onFailure(e);  
    private final ActionListener<String> completionListener;  
 */  
        final StreamPartProcessor processor = new StreamPartProcessor(  
                logger.warn("Unable to clean temp file {}", tmpFileLocation);
        private final AtomicBoolean anyPartStreamFailed;  
                completionListener.onFailure(e);
        final GroupedActionListener<String> groupedListener = new GroupedActionListener<>(getFileCompletionListener(), numParts);
import org.opensearch.action.support.GroupedActionListener;
                        completionListener.onResponse(fileLocation.toString());
            this.executor = executor;  
        private void processFailure(Exception e) {
import org.apache.logging.log4j.Logger;
                } else if (anyPartStreamFailed.get()) {
        private final Executor executor;  
            this.fileLocation = fileLocation;
import org.opensearch.common.UUIDs;  
            try {
        private final UnaryOperator<InputStream> rateLimiter;
            processor.process(queue.poll());  
    private final Path fileLocation;  
 * The OpenSearch Contributors require contributions made to  
                completionListener.onFailure(e);
            "Canceled part download due to previous failure"  
        );
            }
            anyPartStreamFailed,
            Queue<ReadContext.StreamPartCreator> queue,
    private static final String DOWNLOAD_PREFIX = "download.";
                    item = queue.poll();
                completionListener.onResponse(blobName);
     * For Tests
import java.io.InputStream;
    @Override
                }  
import java.util.Collection;
                    completionListener.onFailure(CANCELED_PART_EXCEPTION);
        this.maxConcurrentStreams = maxConcurrentStreams;  
                // notified for each part.
            }
                    try {
    }  
        this.tmpFileLocation = fileLocation.getParent().resolve(tmpFileName);
import java.util.concurrent.ConcurrentLinkedQueue;
            if (supplier == null) {
        private final GroupedActionListener<String> completionListener;
/*  
import java.util.concurrent.atomic.AtomicBoolean;  
        String blobName,  
            }, executor);
        }
    private final String tmpFileName;
        int maxConcurrentStreams
                        // file part off the queue to trigger asynchronous processing
}  
    private ActionListener<Collection<String>> getFileCompletionListener() {
                // sync parent dir metadata
    private final String blobName;
                if (throwable != null) {  
 * ReadContextListener orchestrates the async file fetch from the {@link org.opensearch.common.blobstore.BlobContainer}
        ) {
        this.tmpFileName = DOWNLOAD_PREFIX + UUIDs.randomBase64UUID() + "." + blobName;
            tmpFileLocation,  
        }
import java.util.function.UnaryOperator;
            this.rateLimiter = rateLimiter;
        }
import org.opensearch.common.blobstore.stream.read.ReadContext;
 * using a {@link ReadContext} callback. On response, it spawns off the download using multiple streams.
        completionListener.onFailure(e);
                // since they haven't started any work yet, but the listener must be  
                    }
    private final int maxConcurrentStreams;  
        logger.debug("Received {} parts for blob {}", readContext.getNumberOfParts(), blobName);
            if (anyPartStreamFailed.getAndSet(true) == false) {
import org.apache.lucene.util.IOUtils;  
            rateLimiter  
                IOUtils.fsync(tmpFileLocation, false);  
    private static class StreamPartProcessor {
        }
import java.io.IOException;  
            } catch (IOException ex) {  
            AtomicBoolean anyPartStreamFailed,
@InternalApi
        private final Path fileLocation;
                        // Upon successfully completing a file part, pull another  
    private final UnaryOperator<InputStream> rateLimiter;
        ThreadPool threadPool,  
        final int numParts = readContext.getNumberOfParts();
import org.opensearch.common.SuppressForbidden;
        return tmpFileLocation;
import org.opensearch.common.annotation.InternalApi;
    private final Path tmpFileLocation;
            supplier.get().whenCompleteAsync((blobPartStreamContainer, throwable) -> {
            Executor executor,
            try {
