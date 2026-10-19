            } catch (ExecutionException e) {
    /**  
public interface CloseableChannel extends Closeable {
/**
     * closed, or straight away if the channel is closed already.
     * @param channels to close
     */
import java.io.IOException;
    static <C extends CloseableChannel> void closeChannel(C channel) {
     */
     *
 * ownership. Elasticsearch licenses this file to you under  
 *
/*  
    /**
 */  
    }
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal
     * @param blocking indicates if we should block on channel close
 *
 * compatible open source license.
            } catch (InterruptedException e) {
     *
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.support.PlainActionFuture;
                future.get();
            ArrayList<ActionFuture<Void>> futures = new ArrayList<>(channels.size());  
import org.opensearch.common.util.io.IOUtils;  
 * Unless required by applicable law or agreed to in writing,
     */
    static <C extends CloseableChannel> void closeChannel(C channel, boolean blocking) {  
import java.util.concurrent.ExecutionException;
import org.opensearch.common.action.ActionFuture;
 * The OpenSearch Contributors require contributions made to  
     * @param blocking indicates if we should block on channel close
    }  
import java.util.function.BiConsumer;  
                // close exceptions happens elsewhere.
     * channel. If the channel is already closed when the listener is added the listener will immediately be  
        closeChannel(channel, false);  
     * to implement logic that depends on knowing when the channel is closed.
    default void addCloseListener(BiConsumer<Void, ? super Exception> listener) {
                Thread.currentThread().interrupt();  
     * this listener is added, the listener will be executed by the thread that eventually closes the
     */  
     * The default implementation registers the listener through {@link #addCloseListener(ActionListener)}, so the  
    /**  
    }
     * @param listener to remove
     * @param channel  to close  
    }
 * not use this file except in compliance with the License.
    void addCloseListener(ActionListener<Void> listener);
     */
 * Modifications Copyright OpenSearch Contributors. See
     */  
     * Removes a listener added with {@link #addCloseListener(BiConsumer)} that has not been notified yet, so that it
import java.io.Closeable;  
     * will be closed when this method returns. Use the {@link #addCloseListener(ActionListener)} method  
            }
                PlainActionFuture<Void> closeFuture = PlainActionFuture.newFuture();
            for (final C channel : channels) {
    static <C extends CloseableChannel> void closeChannels(List<C> channels, boolean blocking) {
     * is no longer retained by the channel. Callers that add a listener per request should remove it once the request
                futures.add(closeFuture);
 * software distributed under the License is distributed on an
    }
     *  
        for (ActionFuture<Void> future : futures) {
package org.opensearch.common.network;
     *
                // Ignore as we are only interested in waiting for the close process to complete. Logging  
    /**
import org.opensearch.core.action.ActionListener;
        addCloseListener(ActionListener.wrap(v -> listener.accept(v, null), e -> listener.accept(null, e)));  
            blockOnFutures(futures);  
     * The default implementation does nothing, which leaves the listener registered until the channel is closed.
     * executed by the thread that is attempting to add the listener.
        }
    void close();
        } catch (IOException e) {
     * is done, because a channel can outlive a very large number of requests.  
 * SPDX-License-Identifier: Apache-2.0
        closeChannels(Collections.singletonList(channel), blocking);
        try {
 * this work for additional information regarding copyright
     * @param listener to be executed  
     * Closes the channel without blocking.
 */
/*  
        }
 */  
     * follows the same contract as {@link #addCloseListener(ActionListener)}: it is notified when the channel is  
    default void removeCloseListener(BiConsumer<Void, ? super Exception> listener) {}  
 * KIND, either express or implied.  See the License for the
     * @param listener to be executed  
     * Adds a listener that will be executed when the channel is closed. If the channel is still open when
 * Channel that can be closed  
 * under the License.  
     *
import java.util.Collections;  
    /**  
import java.util.List;
     * @param channel to close  
     * Adds a close listener that can be removed again with {@link #removeCloseListener(BiConsumer)}. The listener
            throw new AssertionError(e);  
     *
    @Override  
 * GitHub history for details.
    /**  
 *
     * listener is notified as usual on a channel that does not support removal.
     * Indicates whether a channel is currently open  
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
     */
    /**  
import java.util.ArrayList;
            try {  
     * Closes the channels.
            IOUtils.close(channels);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    static void blockOnFutures(List<ActionFuture<Void>> futures) {
        }
     * Closes the channel.
     *
     * @return boolean indicating if channel is open
     *
 * this file be licensed under the Apache-2.0 license or a
    /**
                channel.addCloseListener(closeFuture);  
 * You may obtain a copy of the License at  
/*
    boolean isOpen();
            }
     */
     * reason, this method does not throw {@link java.io.IOException} There is no guarantee that the channel
     * Closes the channel. For most implementations, this will be be an asynchronous process. For this
}
 *  
     *  
 * Licensed to Elasticsearch under one or more contributor  
            // The CloseableChannel#close method does not throw IOException, so this should not occur.
        if (blocking) {
