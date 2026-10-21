    @Override
        @Override
    private final Logger logger = LogManager.getLogger(TransportKeepAlive.class);
            PING_MESSAGE = out.copyBytes();
    private void sendPing(TcpChannel channel) {
        @Override
 * license agreements. See the NOTICE file distributed with
        for (TcpChannel channel : nodeChannels) {
        protected void onAfterInLifecycle() {
        if (pingInterval.millis() < 0) {
            TcpChannel.ChannelStats stats = channel.getChannelStats();
import org.opensearch.common.AsyncBiFunction;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void close() {
/**
        }
            }
                    logger.trace(() -> new ParameterizedMessage("[{}] failed to send transport ping (channel closed)", channel), e);
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        pingSender.apply(channel, PING_MESSAGE, new ActionListener<Void>() {
        return successfulPings.count();
            out.writeInt(PING_DATA_SIZE);
     */
                    failedPings.inc();
            public void onFailure(Exception e) {
import org.opensearch.common.io.stream.BytesStreamOutput;
        // The client-side initiates pings and the server-side responds. So if this is a client channel, this
public final class TransportKeepAlive implements Closeable {
import org.opensearch.core.action.ActionListener;
/*
 *
            lifecycle.moveToClosed();
}
    private static final BytesReference PING_MESSAGE;
    void registerNodeConnection(List<TcpChannel> nodeChannels, ConnectionProfile connectionProfile) {
    }
    private final ConcurrentMap<TimeValue, ScheduledPing> pingIntervals = ConcurrentCollections.newConcurrentMap();
        void ensureStarted() {
            this.lastPingRelativeMillis = threadPool.relativeTimeInMillis();
 */
import java.io.IOException;
 */
        private final Set<TcpChannel> channels = ConcurrentCollections.newConcurrentSet();
        this.lifecycle.moveToStarted();
        protected void doRunInLifecycle() {
        private ScheduledPing(TimeValue pingInterval) {
            if (isStarted.get() == false && isStarted.compareAndSet(false, true)) {
    }
 * GitHub history for details.
package org.opensearch.transport;
            scheduledPing.addChannel(channel);
     * Called when a keep alive ping is received. If the channel that received the keep alive ping is a
    private final CounterMetric failedPings = new CounterMetric();
 * Licensed to Elasticsearch under one or more contributor
    }
import org.opensearch.common.annotation.ExperimentalApi;
                // pre-6.6 nodes that DO NOT respond to pings
            logger.warn("failed to send ping transport message", e);
 * software distributed under the License is distributed on an
import org.apache.logging.log4j.message.ParameterizedMessage;
            long accessedDelta = stats.lastAccessedTime() - lastPingRelativeMillis;
import org.opensearch.core.common.bytes.BytesReference;
import org.apache.logging.log4j.LogManager;
        scheduledPing.ensureStarted();
 * not use this file except in compliance with the License.
import java.io.Closeable;
        this.pingSender = pingSender;
    }
        }
            sendPing(channel);
        }
        }
        return failedPings.count();
    void receiveKeepAlive(TcpChannel channel) {
            channel.addCloseListener(ActionListener.wrap(() -> scheduledPing.removeChannel(channel)));
     * server channel, a ping is sent back. If the channel that received the keep alive is a client channel,
 * The OpenSearch Contributors require contributions made to
            public void onResponse(Void v) {
        }
        }
 * and receive a message since the last ping.
        synchronized (lifecycle) {
 * Modifications Copyright OpenSearch Contributors. See
    /**
    }
     *
 *
/*
 */
    private final CounterMetric successfulPings = new CounterMetric();
                // the channel since the last ping. However, this will need to be backwards compatible with
    }
     * @param channel that received the keep alive ping
 *
        private final TimeValue pingInterval;
 *    http://www.apache.org/licenses/LICENSE-2.0
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            super(lifecycle, logger);
import org.opensearch.threadpool.ThreadPool;
        private boolean needsKeepAlivePing(TcpChannel channel) {
import org.opensearch.common.metrics.CounterMetric;
    long successfulPingCount() {
            return;
        private final AtomicBoolean isStarted = new AtomicBoolean(false);
    }
            channels.remove(channel);
 * under the License.
        if (channel.isServerChannel()) {
        }
    }
        private volatile long lastPingRelativeMillis;
        this.threadPool = threadPool;
        TimeValue pingInterval = connectionProfile.getPingInterval();
    static {
 * the Apache License, Version 2.0 (the "License"); you may
        void removeChannel(TcpChannel channel) {
 * specific language governing permissions and limitations
                    sendPing(channel);
                }
 * @opensearch.internal
                threadPool.schedule(this, pingInterval, ThreadPool.Names.GENERIC);
     * this method does nothing as the client initiated the ping in the first place.
            threadPool.scheduleUnlessShuttingDown(pingInterval, ThreadPool.Names.GENERIC, this);
                }
            lifecycle.moveToStopped();
            throw new AssertionError(e.getMessage(), e); // won't happen
                } else {
            out.writeByte((byte) 'S');
 *
import java.util.List;
 * server and server channels respond. Pings are only sent at the scheduled time if the channel did not send
            }
    private final AsyncBiFunction<TcpChannel, BytesReference, Void> pingSender;
            for (TcpChannel channel : channels) {
 * this work for additional information regarding copyright
    private final Lifecycle lifecycle = new Lifecycle();
    private class ScheduledPing extends AbstractLifecycleRunnable {
            }
        }
            this.pingInterval = pingInterval;
 * compatible open source license.
            out.writeByte((byte) 'E');
            this.lastPingRelativeMillis = threadPool.relativeTimeInMillis();
                successfulPings.inc();
 * this file be licensed under the Apache-2.0 license or a
            return accessedDelta <= 0;
import org.apache.logging.log4j.Logger;
        // method is a no-op.
                if (channel.isOpen()) {
import org.opensearch.common.lifecycle.Lifecycle;
            @Override
                if (needsKeepAlivePing(channel)) {
 * You may obtain a copy of the License at
        final ScheduledPing scheduledPing = pingIntervals.computeIfAbsent(pingInterval, ScheduledPing::new);
        }
/*
 * SPDX-License-Identifier: Apache-2.0
 */
            @Override
        }
    }
    long failedPingCount() {
        }
import java.util.concurrent.ConcurrentMap;
import org.opensearch.common.unit.TimeValue;
 * Unless required by applicable law or agreed to in writing,
            channels.add(channel);
        public void onFailure(Exception e) {
import java.util.concurrent.atomic.AtomicBoolean;
        }
 * Implements the scheduling and sending of keep alive pings. Client channels send keep alive pings to the
 * ownership. Elasticsearch licenses this file to you under
    static final int PING_DATA_SIZE = -1;
    TransportKeepAlive(ThreadPool threadPool, AsyncBiFunction<TcpChannel, BytesReference, Void> pingSender) {
                    logger.debug(() -> new ParameterizedMessage("[{}] failed to send transport ping", channel), e);
        void addChannel(TcpChannel channel) {
import org.opensearch.common.util.concurrent.AbstractLifecycleRunnable;
@ExperimentalApi
import java.util.Set;
        }
                // In the future it is possible that we may want to kill a channel if we have not read from
    private final ThreadPool threadPool;
            }
        } catch (IOException e) {
        });
        @Override
