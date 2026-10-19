 */  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        Future<?> shutdownFuture = eventLoopGroup.shutdownGracefully(0, 5, TimeUnit.SECONDS);
import org.apache.logging.log4j.message.ParameterizedMessage;  
 * this file be licensed under the Apache-2.0 license or a
     */
     * Construct a new AsyncTransferEventLoopGroup
    /**
        // Epoll event loop incurs less GC and provides better performance than Nio loop. Therefore,
import io.netty.channel.epoll.EpollEventLoopGroup;  
                : new NioEventLoopGroup(eventLoopThreads, OpenSearchExecutors.daemonThreadFactory(THREAD_PREFIX))  
import io.netty.channel.EventLoopGroup;
    private final Logger logger = LogManager.getLogger(AsyncTransferEventLoopGroup.class);  
}
    private final EventLoopGroup eventLoopGroup;
    public AsyncTransferEventLoopGroup(int eventLoopThreads) {  
            () -> Epoll.isAvailable()
import java.util.concurrent.TimeUnit;
    @Override
        }
 */  
 * AsyncTransferEventLoopGroup is an encapsulation for netty {@link EventLoopGroup}
     *  
 * SPDX-License-Identifier: Apache-2.0
import io.netty.channel.nio.NioEventLoopGroup;
    public void close() {  
/*  
import io.netty.util.concurrent.Future;
        shutdownFuture.awaitUninterruptibly();
        return eventLoopGroup;
import java.io.Closeable;
                ? new EpollEventLoopGroup(eventLoopThreads, OpenSearchExecutors.daemonThreadFactory(THREAD_PREFIX))
 *
        this.eventLoopGroup = AccessController.doPrivileged(  
            logger.warn(new ParameterizedMessage("Error closing {} netty event loop group", THREAD_PREFIX), shutdownFuture.cause());
import io.netty.channel.epoll.Epoll;
 * compatible open source license.
/**
        );
import org.apache.logging.log4j.LogManager;
    }  
import org.apache.logging.log4j.Logger;
    }  
import org.opensearch.secure_sm.AccessController;
 * The OpenSearch Contributors require contributions made to  
public class AsyncTransferEventLoopGroup implements Closeable {
package org.opensearch.repositories.s3.async;
     * @param eventLoopThreads The number of event loop threads for this event loop group
        if (!shutdownFuture.isSuccess()) {  
    }
    private static final String THREAD_PREFIX = "s3-async-transfer-worker";
    public EventLoopGroup getEventLoopGroup() {
        // using epoll wherever available is preferred.
