        }
    }
 * GitHub history for details.
            CheckedSupplier<BytesReference, IOException> messageSupplier,
     * @opensearch.internal  
        try (ThreadContext.StoredContext existing = threadPool.getThreadContext().stashContext()) {  
        private final Releasable optionalReleasable;
        this.threadPool = threadPool;
 * Outbound data handler  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
 *
        }
 */
        } catch (IOException e) {
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
        SendContext sendContext = new SendContext(statsTracker, channel, () -> bytes, listener);
 *
import org.opensearch.common.CheckedSupplier;
                messageSize = message.length();
            sendContext.onFailure(ex);
        }
    public void sendBytes(TcpChannel channel, SendContext sendContext) throws IOException {
            closeAndCallback(() -> listener.onFailure(e));  
        public SendContext(
 */  
            this.statsTracker = statsTracker;  
            StatsTracker statsTracker,
     * Internal message serializer
 *    http://www.apache.org/licenses/LICENSE-2.0
                throw e;  
                return message;  
 * @opensearch.internal
            this.messageSupplier = messageSupplier;  
import org.opensearch.core.common.bytes.BytesReference;  
import org.opensearch.common.network.CloseableChannel;
        }
import org.apache.logging.log4j.LogManager;
    public void sendBytes(long requestId, TcpChannel channel, SendContext sendContext) throws IOException {
import java.io.IOException;  
                logger.debug(() -> new ParameterizedMessage("send message failed [channel: {}]", channel), e);
            TcpChannel channel,  
        ) {  
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
        @Override
        try {  
                message = messageSupplier.get();  
    private final StatsTracker statsTracker;
            throw ex;  
 * specific language governing permissions and limitations
 *  
import org.apache.logging.log4j.message.ParameterizedMessage;  
        }
import org.apache.logging.log4j.Logger;
    private static final Logger logger = LogManager.getLogger(OutboundHandler.class);  
        // stash thread context so that channel event loop is not polluted by thread context
        ) {
            ActionListener<Void> listener
            sendBytes(channel, sendContext);
            TcpChannel channel,  
    public static class SendContext extends NotifyOnceListener<Void> implements CheckedSupplier<BytesReference, IOException> {
            } else {  
import org.opensearch.core.action.ActionListener;
            }
        protected void innerOnFailure(Exception e) {  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
                channel.sendMessage(reference, sendContext);
 * Unless required by applicable law or agreed to in writing,
        private long messageSize = -1;
/**
    }  
            if (NetworkExceptionHelper.isCloseConnectionException(e)) {
        } catch (RuntimeException ex) {  
    void sendBytes(TcpChannel channel, BytesReference bytes, ActionListener<Void> listener) {
import org.opensearch.common.transport.NetworkExceptionHelper;
 * The OpenSearch Contributors require contributions made to  
        private final TcpChannel channel;
     *
            // This should not happen as the bytes are already serialized  
/*
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
    /**  
package org.opensearch.transport;
        private final StatsTracker statsTracker;  
        sendBytes(-1, channel, sendContext);  
        private final CheckedSupplier<BytesReference, IOException> messageSupplier;
            assert messageSize != -1 : "If onResponse is being called, the message should have been serialized";  
            }
        private final ActionListener<Void> listener;  
        }  
            ActionListener<Void> listener,
            Releasable optionalReleasable  
     */
            StatsTracker statsTracker,
import org.opensearch.threadpool.ThreadPool;
            CheckedSupplier<BytesReference, IOException> messageSupplier,
    }
        private void closeAndCallback(Runnable runnable) {  
        }
            throw new AssertionError(e);
            this.optionalReleasable = optionalReleasable;
    private final ThreadPool threadPool;  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.lease.Releasable;
public final class OutboundHandler {
}
                onFailure(e);
            this.channel = channel;
                logger.warn(() -> new ParameterizedMessage("send message failed [channel: {}]", channel), e);
            this.listener = listener;
        @Override
import org.opensearch.common.util.concurrent.ThreadContext;  
    public OutboundHandler(StatsTracker statsTracker, ThreadPool threadPool) {
 * Modifications Copyright OpenSearch Contributors. See
            try {
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
        protected void innerOnResponse(Void v) {
import org.opensearch.common.lease.Releasables;  
            this(statsTracker, channel, messageSupplier, listener, null);
            closeAndCallback(() -> listener.onResponse(v));
    }  
 */  
        channel.getChannelStats().markAccessed(threadPool.relativeTimeInMillis());  
            CloseableChannel.closeChannel(channel);
/*  
                channel.sendMessage(requestId, reference, sendContext);
        public BytesReference get() throws IOException {  
            } else {  
/*  
        this.statsTracker = statsTracker;  
 * under the License.  
 *
            if (requestId == -1) {
import org.opensearch.core.action.NotifyOnceListener;
                TransportLogger.logOutboundMessage(channel, message);
        BytesReference reference = sendContext.get();
            } catch (Exception e) {
    }  
        SendContext(
            Releasables.close(optionalReleasable, runnable::run);
 */  
            BytesReference message;
            statsTracker.markBytesWritten(messageSize);
        }
