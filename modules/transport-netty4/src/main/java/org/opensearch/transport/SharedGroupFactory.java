        if (genericGroup == null) {
    public int getTransportWorkerCount() {
     * Wraps the {@link RefCountedGroup}. Calls {@link RefCountedGroup#decRef()} on close. After close,  
    public synchronized SharedGroup getTransportGroup() {
import org.opensearch.http.HttpServerTransport;
    }  
        }
    private final Settings settings;
import static org.opensearch.common.util.concurrent.OpenSearchExecutors.daemonThreadFactory;
            );
            if (shutdownFuture.isSuccess() == false) {
        private RefCountedGroup(EventLoopGroup eventLoopGroup) {
     */
            }
/*  
        private final AtomicBoolean isOpen = new AtomicBoolean(true);
 */  
 * The OpenSearch Contributors require contributions made to  
        public void shutdown() {
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
    private static final Logger logger = LogManager.getLogger(SharedGroupFactory.class);  
            }
        return workerCount;
 *
    }
        this.httpWorkerCount = Netty4HttpServerTransport.SETTING_HTTP_WORKER_COUNT.get(settings);  
import io.netty.util.concurrent.Future;  
        private final EventLoopGroup eventLoopGroup;  
 * Creates and returns {@link io.netty.channel.EventLoopGroup} instances. It will return a shared group for
            return refCountedGroup.eventLoopGroup;
            this.genericGroup = new RefCountedGroup(eventLoopGroup);
        }
        }
    public synchronized SharedGroup getHttpGroup() {  
        if (httpWorkerCount == 0) {
                refCountedGroup.decRef();
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
public final class SharedGroupFactory {
            if (isOpen.compareAndSet(true, false)) {  
    private static class RefCountedGroup extends AbstractRefCounted {  
}
        @Override
    /**
    private SharedGroup dedicatedHttpGroup;
import io.netty.channel.EventLoopGroup;  
                    httpWorkerCount,  
    public static class SharedGroup {  
            this.eventLoopGroup = eventLoopGroup;
 * the Apache License, Version 2.0 (the "License"); you may
import io.netty.channel.MultiThreadIoEventLoopGroup;
    public SharedGroupFactory(Settings settings) {  
package org.opensearch.transport;
import io.netty.channel.nio.NioIoHandler;
import org.opensearch.http.netty4.Netty4HttpServerTransport;  
        }  
        protected void closeInternal() {
            this.refCountedGroup = refCountedGroup;
/**
import org.opensearch.common.util.concurrent.AbstractRefCounted;
 * {@link org.opensearch.http.netty4.Netty4HttpServerTransport#SETTING_HTTP_WORKER_COUNT} is configured to be 0.
                workerCount,
    }  
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
            genericGroup.incRef();
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.transport.netty4.Netty4Transport;
                    NioIoHandler.newFactory()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public EventLoopGroup getLowLevelGroup() {
    }
/*  
        return new SharedGroup(genericGroup);  
 *
    private final int httpWorkerCount;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.logging.log4j.LogManager;
                    daemonThreadFactory(settings, HttpServerTransport.HTTP_SERVER_WORKER_THREAD_NAME_PREFIX),
 *  
 * this work for additional information regarding copyright
                logger.warn("Error closing netty event loop group", shutdownFuture.cause());  
    private final int workerCount;  
        private SharedGroup(RefCountedGroup refCountedGroup) {  
import java.util.concurrent.TimeUnit;  
 */  
            shutdownFuture.awaitUninterruptibly();
    }
import org.apache.logging.log4j.Logger;
            return getGenericGroup();
        this.settings = settings;
                EventLoopGroup eventLoopGroup = new MultiThreadIoEventLoopGroup(
    }
        } else {  
        return settings;
 * compatible open source license.
 * If that setting is not 0, then it will return a different group in the {@link #getHttpGroup()} call.
    }
            }
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
        public static final String NAME = "ref-counted-event-loop-group";
 */
     * this wrapped instance can no longer be used.
            super(NAME);  
 * both {@link #getHttpGroup()} and {@link #getTransportGroup()} if  
 * ownership. Elasticsearch licenses this file to you under  
            return dedicatedHttpGroup;  
 * this file be licensed under the Apache-2.0 license or a
    private RefCountedGroup genericGroup;  
            Future<?> shutdownFuture = eventLoopGroup.shutdownGracefully(0, 5, TimeUnit.SECONDS);  
            if (dedicatedHttpGroup == null) {
        private final RefCountedGroup refCountedGroup;
/*
 * KIND, either express or implied.  See the License for the
                NioIoHandler.newFactory()  
 * SPDX-License-Identifier: Apache-2.0
        this.workerCount = Netty4Transport.WORKER_COUNT.get(settings);
        } else {  
            EventLoopGroup eventLoopGroup = new MultiThreadIoEventLoopGroup(  
    private SharedGroup getGenericGroup() {
                );  
    }
                daemonThreadFactory(settings, TcpTransport.TRANSPORT_WORKER_THREAD_NAME_PREFIX),
                dedicatedHttpGroup = new SharedGroup(new RefCountedGroup(eventLoopGroup));
    public Settings getSettings() {  
        return getGenericGroup();  
import org.opensearch.common.settings.Settings;  
        }
        }  
 * software distributed under the License is distributed on an
        }
