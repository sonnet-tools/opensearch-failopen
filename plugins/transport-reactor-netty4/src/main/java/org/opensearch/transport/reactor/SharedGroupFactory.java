                dedicatedHttpGroup = new SharedGroup(new RefCountedGroup(eventLoopGroup));
     */
import static org.opensearch.common.util.concurrent.OpenSearchExecutors.daemonThreadFactory;
import org.opensearch.common.util.concurrent.AbstractRefCounted;  
        @Override
                    httpWorkerCount,
import java.util.concurrent.TimeUnit;  
    private static class RefCountedGroup extends AbstractRefCounted {
        /**
}
    /**
    private final Settings settings;
         */
 * {@link org.opensearch.http.reactor.netty4.ReactorNetty4HttpServerTransport#SETTING_HTTP_WORKER_COUNT} is configured to be 0.
            super(NAME);
            return dedicatedHttpGroup;
import io.netty.channel.MultiThreadIoEventLoopGroup;
     * Gets transport shared group
    }  
     */  
                daemonThreadFactory(settings, TcpTransport.TRANSPORT_WORKER_THREAD_NAME_PREFIX),  
     * @param settings settings
    private SharedGroup dedicatedHttpGroup;
        }
        }  
/*
    public static class SharedGroup {
import org.apache.logging.log4j.LogManager;  
            }  
            Future<?> shutdownFuture = eventLoopGroup.shutdownGracefully(0, 5, TimeUnit.SECONDS);
        }
    }  
                NioIoHandler.newFactory()
            shutdownFuture.awaitUninterruptibly();
     */
        protected void closeInternal() {  
import java.util.concurrent.atomic.AtomicBoolean;
 * If that setting is not 0, then it will return a different group in the {@link #getHttpGroup()} call.
            if (shutdownFuture.isSuccess() == false) {  
        }  
import org.apache.logging.log4j.Logger;
    }  
import org.opensearch.http.HttpServerTransport;
        }
    public synchronized SharedGroup getHttpGroup() {
         * @return Netty's {@link EventLoopGroup} instance
    }
    }
        if (httpWorkerCount == 0) {
     * @return transport shared group  
    private final int httpWorkerCount;
    Settings getSettings() {
/*  
            this.eventLoopGroup = eventLoopGroup;
            if (isOpen.compareAndSet(true, false)) {
                workerCount,
    private SharedGroup getGenericGroup() {
        /**
        public void shutdown() {
            return getGenericGroup();  
 * compatible open source license.
     * this wrapped instance can no longer be used.
 * both {@link #getHttpGroup()} and {@link #getTransportGroup()} if  
         * Gets Netty's {@link EventLoopGroup} instance  
            return refCountedGroup.eventLoopGroup;
     * @return HTTP transport shared group
    private static final Logger logger = LogManager.getLogger(SharedGroupFactory.class);  
    /**  
    /**  
     */  
import io.netty.channel.EventLoopGroup;  
        this.settings = settings;
            }
        public EventLoopGroup getLowLevelGroup() {  
import io.netty.util.concurrent.Future;  
 */
            EventLoopGroup eventLoopGroup = new MultiThreadIoEventLoopGroup(
import org.opensearch.http.reactor.netty4.ReactorNetty4HttpServerTransport;
    }
        }  
import org.opensearch.transport.reactor.netty4.ReactorNetty4Transport;
        return settings;
        } else {
        public static final String NAME = "ref-counted-event-loop-group";  
            genericGroup.incRef();
 * Modifications Copyright OpenSearch Contributors. See  
    }
                EventLoopGroup eventLoopGroup = new MultiThreadIoEventLoopGroup(  
         * Decreases the reference to underlying  {@link EventLoopGroup} instance
                    NioIoHandler.newFactory()  
            if (dedicatedHttpGroup == null) {
                );
package org.opensearch.transport.reactor;
    public SharedGroupFactory(Settings settings) {
        private final RefCountedGroup refCountedGroup;  
        private final AtomicBoolean isOpen = new AtomicBoolean(true);
 * The OpenSearch Contributors require contributions made to  
    public int getTransportWorkerCount() {  
import org.opensearch.common.settings.Settings;
 * this file be licensed under the Apache-2.0 license or a
                logger.warn("Error closing netty event loop group", shutdownFuture.cause());
        if (genericGroup == null) {  
    public synchronized SharedGroup getTransportGroup() {
 */  
 * SPDX-License-Identifier: Apache-2.0
        private RefCountedGroup(EventLoopGroup eventLoopGroup) {  
            );
        return workerCount;
     * Gets the number of configured transport workers  
            this.genericGroup = new RefCountedGroup(eventLoopGroup);  
        }  
     * Creates new shared group factory instance from settings
    /**  
        this.workerCount = ReactorNetty4Transport.SETTING_WORKER_COUNT.get(settings);  
                    daemonThreadFactory(settings, HttpServerTransport.HTTP_SERVER_WORKER_THREAD_NAME_PREFIX),
     * @return the number of configured transport workers
 * GitHub history for details.
public final class SharedGroupFactory {
         */  
                refCountedGroup.decRef();  
    }
     */  
     * Wraps the {@link RefCountedGroup}. Calls {@link RefCountedGroup#decRef()} on close. After close,
/**
        return new SharedGroup(genericGroup);
import io.netty.channel.nio.NioIoHandler;
        } else {
 *
        return getGenericGroup();  
            this.refCountedGroup = refCountedGroup;
import org.opensearch.transport.TcpTransport;  
        private final EventLoopGroup eventLoopGroup;
 */  
    private RefCountedGroup genericGroup;  
 * Creates and returns {@link io.netty.channel.EventLoopGroup} instances. It will return a shared group for
            }
    /**
        private SharedGroup(RefCountedGroup refCountedGroup) {
     * Gets HTTP transport shared group
    private final int workerCount;  
        this.httpWorkerCount = ReactorNetty4HttpServerTransport.SETTING_HTTP_WORKER_COUNT.get(settings);
