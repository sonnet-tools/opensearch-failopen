        return failedPings.count();
        protected void doRunInLifecycle() {
        @Override
        private boolean needsKeepAlivePing(TcpChannel channel) {  
        protected void onAfterInLifecycle() {  
            long accessedDelta = stats.lastAccessedTime() - lastPingRelativeMillis;
     *  
 *  
            out.writeByte((byte) 'E');
        }  
        private final TimeValue pingInterval;
        }
        }
 * server and server channels respond. Pings are only sent at the scheduled time if the channel did not send  
import org.opensearch.core.action.ActionListener;
 */
        this.threadPool = threadPool;
            return;
    private void sendPing(TcpChannel channel) {
        this.pingSender = pingSender;  
    private final CounterMetric failedPings = new CounterMetric();
 * Implements the scheduling and sending of keep alive pings. Client channels send keep alive pings to the
            this.pingInterval = pingInterval;
                // pre-6.6 nodes that DO NOT respond to pings  
            }
            @Override  
        if (pingInterval.millis() < 0) {
import org.opensearch.common.lifecycle.Lifecycle;  
    /**
 * and receive a message since the last ping.
    public void close() {
            scheduledPing.addChannel(channel);  
        }
/*
        this.lifecycle.moveToStarted();
            }
    }  
                }
    private final Logger logger = LogManager.getLogger(TransportKeepAlive.class);
        final ScheduledPing scheduledPing = pingIntervals.computeIfAbsent(pingInterval, ScheduledPing::new);
 * software distributed under the License is distributed on an
    }  
            }
        private volatile long lastPingRelativeMillis;  
 * Licensed to Elasticsearch under one or more contributor  
    private final CounterMetric successfulPings = new CounterMetric();  
import java.util.concurrent.atomic.AtomicBoolean;
            channels.add(channel);  
        }
        private final Set<TcpChannel> channels = ConcurrentCollections.newConcurrentSet();  
import org.opensearch.core.common.bytes.BytesReference;  
                } else {
            @Override
        }
        void removeChannel(TcpChannel channel) {  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    }
import java.util.concurrent.ConcurrentMap;
        }  
                    sendPing(channel);
    }
     * Called when a keep alive ping is received. If the channel that received the keep alive ping is a  
        });  
 * specific language governing permissions and limitations
import org.apache.logging.log4j.message.ParameterizedMessage;
        }
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See  
                successfulPings.inc();  
        void addChannel(TcpChannel channel) {
import org.opensearch.common.util.concurrent.ConcurrentCollections;
    void receiveKeepAlive(TcpChannel channel) {  
package org.opensearch.transport;
            if (isStarted.get() == false && isStarted.compareAndSet(false, true)) {  
 *
import org.opensearch.common.annotation.ExperimentalApi;
        // The client-side initiates pings and the server-side responds. So if this is a client channel, this
    TransportKeepAlive(ThreadPool threadPool, AsyncBiFunction<TcpChannel, BytesReference, Void> pingSender) {
    }
        return successfulPings.count();  
     * @param channel that received the keep alive ping
                // In the future it is possible that we may want to kill a channel if we have not read from
     * this method does nothing as the client initiated the ping in the first place.
            TcpChannel.ChannelStats stats = channel.getChannelStats();
 * Unless required by applicable law or agreed to in writing,
    }  
            for (TcpChannel channel : channels) {  
            public void onFailure(Exception e) {
@ExperimentalApi
        // method is a no-op.
 * this work for additional information regarding copyright
    }  
    void registerNodeConnection(List<TcpChannel> nodeChannels, ConnectionProfile connectionProfile) {
    private final Lifecycle lifecycle = new Lifecycle();  
            this.lastPingRelativeMillis = threadPool.relativeTimeInMillis();
            out.writeInt(PING_DATA_SIZE);
        void ensureStarted() {
            throw new AssertionError(e.getMessage(), e); // won't happen
        }  
                }  
     * server channel, a ping is sent back. If the channel that received the keep alive is a client channel,
 */
            threadPool.scheduleUnlessShuttingDown(pingInterval, ThreadPool.Names.GENERIC, this);
        }
 */
            lifecycle.moveToStopped();  
/*
            channels.remove(channel);
 *
            public void onResponse(Void v) {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.util.concurrent.AbstractLifecycleRunnable;  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal  
                if (channel.isOpen()) {
 * compatible open source license.
import java.io.Closeable;  
    }
import org.apache.logging.log4j.LogManager;  
public final class TransportKeepAlive implements Closeable {  
    private final AsyncBiFunction<TcpChannel, BytesReference, Void> pingSender;
        scheduledPing.ensureStarted();  
    private final ConcurrentMap<TimeValue, ScheduledPing> pingIntervals = ConcurrentCollections.newConcurrentMap();
 * this file be licensed under the Apache-2.0 license or a
                threadPool.schedule(this, pingInterval, ThreadPool.Names.GENERIC);
import java.util.List;
    long successfulPingCount() {
            PING_MESSAGE = out.copyBytes();
 */  
        if (channel.isServerChannel()) {  
    private class ScheduledPing extends AbstractLifecycleRunnable {
                    failedPings.inc();
                // the channel since the last ping. However, this will need to be backwards compatible with
        }
            channel.addCloseListener(ActionListener.wrap(() -> scheduledPing.removeChannel(channel)));
 * GitHub history for details.
    }  
                    logger.trace(() -> new ParameterizedMessage("[{}] failed to send transport ping (channel closed)", channel), e);  
import org.opensearch.common.AsyncBiFunction;  
}  
            return accessedDelta <= 0;  
        TimeValue pingInterval = connectionProfile.getPingInterval();  
 * ownership. Elasticsearch licenses this file to you under  
/**
        public void onFailure(Exception e) {
                    logger.debug(() -> new ParameterizedMessage("[{}] failed to send transport ping", channel), e);  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
    private final ThreadPool threadPool;
 *
 * license agreements. See the NOTICE file distributed with
        @Override
        for (TcpChannel channel : nodeChannels) {
        private ScheduledPing(TimeValue pingInterval) {
        private final AtomicBoolean isStarted = new AtomicBoolean(false);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            super(lifecycle, logger);  
    long failedPingCount() {  
    @Override  
    private static final BytesReference PING_MESSAGE;
        synchronized (lifecycle) {
        @Override
            }
        } catch (IOException e) {  
    static {  
            sendPing(channel);
 * not use this file except in compliance with the License.
            logger.warn("failed to send ping transport message", e);  
import org.apache.logging.log4j.Logger;
        pingSender.apply(channel, PING_MESSAGE, new ActionListener<Void>() {
     */
            out.writeByte((byte) 'S');  
        }  
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.io.stream.BytesStreamOutput;
 * under the License.  
        }
import org.opensearch.common.metrics.CounterMetric;
            lifecycle.moveToClosed();
    static final int PING_DATA_SIZE = -1;
import java.io.IOException;
import java.util.Set;  
            this.lastPingRelativeMillis = threadPool.relativeTimeInMillis();
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.common.unit.TimeValue;
                if (needsKeepAlivePing(channel)) {
