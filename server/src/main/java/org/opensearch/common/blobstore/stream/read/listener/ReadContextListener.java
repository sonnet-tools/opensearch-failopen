    ) {
        this.tmpFileLocation = fileLocation.getParent().resolve(tmpFileName);
                        FilePartWriter.write(fileLocation, blobPartStreamContainer, rateLimiter);
                    try {
            } catch (IOException e) {
                        processFailure(e);
            } else {
        this.threadPool = threadPool;
        private StreamPartProcessor(
import java.util.function.UnaryOperator;
 * SPDX-License-Identifier: Apache-2.0
    }
                } else if (anyPartStreamFailed.get()) {
            supplier.get().whenCompleteAsync((blobPartStreamContainer, throwable) -> {
            }
package org.opensearch.common.blobstore.stream.read.listener;
 * The OpenSearch Contributors require contributions made to
                        // Upon successfully completing a file part, pull another
        }, e -> {
/**
            this.executor = executor;
    }
 * using a {@link ReadContext} callback. On response, it spawns off the download using multiple streams.
    private final int maxConcurrentStreams;
        private final Queue<ReadContext.StreamPartCreator> queue;
import org.apache.lucene.util.IOUtils;
import java.util.concurrent.Executor;
        this.rateLimiter = rateLimiter;
 */
                completionListener.onResponse(blobName);
            "Canceled part download due to previous failure"
    private final UnaryOperator<InputStream> rateLimiter;
        private final Path fileLocation;
            Executor executor,
    private static class StreamPartProcessor {
import org.opensearch.common.SuppressForbidden;
                    item = queue.poll();
import org.apache.logging.log4j.LogManager;
        UnaryOperator<InputStream> rateLimiter,
    @Override
                return;
        logger.debug("Received {} parts for blob {}", readContext.getNumberOfParts(), blobName);
                    } catch (Exception e) {
        this.fileLocation = fileLocation;
                }
@InternalApi
            try {
            threadPool.executor(ThreadPool.Names.REMOTE_RECOVERY),
                IOUtils.fsync(fileLocation.getParent(), true);
            anyPartStreamFailed,
                IOUtils.fsync(tmpFileLocation, false);
        this.completionListener = completionListener;
    public void onResponse(ReadContext readContext) {
import java.util.Queue;
import org.opensearch.action.support.GroupedActionListener;
    private ActionListener<Collection<String>> getFileCompletionListener() {
            completionListener.onFailure(e);
        this.maxConcurrentStreams = maxConcurrentStreams;
                // Die silently
        private final Executor executor;
            rateLimiter
    private final String tmpFileName;
        private void process(ReadContext.StreamPartCreator supplier) {
     */
     * For Tests
        completionListener.onFailure(e);
            this.fileLocation = fileLocation;
                Object item = queue.poll();
            UnaryOperator<InputStream> rateLimiter
    }
                while (item != null) {
                completionListener.onFailure(e);
    public ReadContextListener(
            Path fileLocation,
import java.nio.file.Path;
                        process(queue.poll());
 * this file be licensed under the Apache-2.0 license or a
    private static final Logger logger = LogManager.getLogger(ReadContextListener.class);
 * compatible open source license.
            try {
    @SuppressForbidden(reason = "need to fsync once all parts received")
import java.util.Collection;
import org.apache.logging.log4j.Logger;
        final GroupedActionListener<String> groupedListener = new GroupedActionListener<>(getFileCompletionListener(), numParts);
            try {
            logger.trace("renaming temp file [{}] to [{}]", tmpFileLocation, fileLocation);
                // sync parent dir metadata
import org.opensearch.common.UUIDs;
        final Queue<ReadContext.StreamPartCreator> queue = new ConcurrentLinkedQueue<>(readContext.getPartStreams());
        }
            } catch (IOException ex) {
        ThreadPool threadPool,
        private void processFailure(Exception e) {
import org.opensearch.core.action.ActionListener;
            queue,
    }
        private final AtomicBoolean anyPartStreamFailed;
public class ReadContextListener implements ActionListener<ReadContext> {
import java.nio.file.StandardCopyOption;
            tmpFileLocation,
    private final String blobName;
import java.util.concurrent.ConcurrentLinkedQueue;
                Files.deleteIfExists(tmpFileLocation);
    /*
            AtomicBoolean anyPartStreamFailed,
import java.util.concurrent.atomic.AtomicBoolean;
 *
        }
                completionListener.onFailure(e);
        private static final RuntimeException CANCELED_PART_EXCEPTION = new RuntimeException(
            }
            processor.process(queue.poll());
import org.opensearch.common.blobstore.stream.read.ReadContext;
        ActionListener<String> completionListener,
            }
        return ActionListener.wrap(response -> {
        final int numParts = readContext.getNumberOfParts();
        }
import org.opensearch.common.annotation.InternalApi;
                logger.info("Failed to delete file {} on stream failure: {}", fileLocation, ex);
        for (int i = 0; i < Math.min(maxConcurrentStreams, queue.size()); i++) {
    private final ThreadPool threadPool;
            }
                Files.deleteIfExists(fileLocation);
            groupedListener,
/*
                    processFailure(CANCELED_PART_EXCEPTION);
    @Override
    }
            }, executor);
import java.nio.file.Files;
    }
                Files.move(tmpFileLocation, fileLocation, StandardCopyOption.ATOMIC_MOVE);
                // since they haven't started any work yet, but the listener must be
 */
                } else {
    private static final String DOWNLOAD_PREFIX = "download.";
        });
        }
        this.blobName = blobName;
                // notified for each part.
        Path fileLocation,
                logger.error("Unable to rename temp file + " + tmpFileLocation, e);
            if (supplier == null) {
    private final Path tmpFileLocation;
import java.io.InputStream;
        final AtomicBoolean anyPartStreamFailed = new AtomicBoolean(false);
    Path getTmpFileLocation() {
            }
        int maxConcurrentStreams
        ) {
                logger.warn("Unable to clean temp file {}", tmpFileLocation);
        final StreamPartProcessor processor = new StreamPartProcessor(
        private final GroupedActionListener<String> completionListener;
        );
        this.tmpFileName = DOWNLOAD_PREFIX + UUIDs.randomBase64UUID() + "." + blobName;
}
            } catch (IOException ex) {
            Queue<ReadContext.StreamPartCreator> queue,
                if (throwable != null) {
import java.io.IOException;
                        // file part off the queue to trigger asynchronous processing
    public void onFailure(Exception e) {
    private final Path fileLocation;
            this.queue = queue;
                }
        );
            GroupedActionListener<String> completionListener,
import org.opensearch.threadpool.ThreadPool;
            this.completionListener = completionListener;
    private final ActionListener<String> completionListener;
                // Drain the queue of pending part downloads. These can be discarded
        private final UnaryOperator<InputStream> rateLimiter;
        return tmpFileLocation;
            this.anyPartStreamFailed = anyPartStreamFailed;
                        completionListener.onResponse(fileLocation.toString());
 * ReadContextListener orchestrates the async file fetch from the {@link org.opensearch.common.blobstore.BlobContainer}
                    processFailure(throwable instanceof Exception ? (Exception) throwable : new RuntimeException(throwable));
        String blobName,
            this.rateLimiter = rateLimiter;
            if (anyPartStreamFailed.getAndSet(true) == false) {
                completionListener.onFailure(e);
                    completionListener.onFailure(CANCELED_PART_EXCEPTION);
                    }
