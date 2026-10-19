            selectorSupplier = new RoundRobinSupplier<>(selectors.toArray(new NioSelector[0]));
                dedicatedAcceptors.add(acceptor);
        throws IOException {
            assert selectorCount == selectors.size() : "We need to have created all the selectors at this point.";
    private final List<NioSelector> dedicatedAcceptors;
 * The OpenSearch Contributors require contributions made to
import org.opensearch.nio.utils.ExceptionsHelper;
        return factory.openNioServerSocketChannel(address, acceptorSupplier);
     * @throws IOException occurs if there is a problem while opening a java.nio.Selector
            List<RoundRobinSupplier<NioSelector>> suppliersToSet = new ArrayList<>(selectorCount);
    private final RoundRobinSupplier<NioSelector> selectorSupplier;
 * GitHub history for details.
                } catch (IOException e) {
     */
    public void close() throws IOException {
        }
 */
        }
        dedicatedAcceptors = new ArrayList<>(dedicatedAcceptorCount);
 * configured number of selectors. Each selector will be running in a dedicated thread. Server connections
            for (int i = 0; i < selectorCount; ++i) {
            }
 * <p>
        try {
     * This will create an NioSelectorGroup with no dedicated acceptors. All server channels will be handled by the
            } catch (Exception e1) {
    ) throws IOException {
import java.io.IOException;
 * software distributed under the License is distributed on an
        }
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.ExecutionException;
    @Override
 * license agreements. See the NOTICE file distributed with
        if (isOpen.get() == false) {
    }
                    Thread.currentThread().interrupt();
     * of selectors dedicated to accepting channels. These accepted channels will be handed off the
    }
                supplierToSet.setSelectors(selectors.toArray(new NioSelector[0]));
                RoundRobinSupplier<NioSelector> supplier = new RoundRobinSupplier<>(selectors.toArray(new NioSelector[0]));
        ThreadFactory acceptorThreadFactory,
    private static void startSelectors(Iterable<NioSelector> selectors, ThreadFactory threadFactory) {
    public <S extends NioServerSocketChannel> S bindServerChannel(InetSocketAddress address, ChannelFactory<S, ?> factory)
        selectors = new ArrayList<>(selectorCount);
            assert dedicatedAcceptorCount == dedicatedAcceptors.size() : "We need to have created all the acceptors at this point.";
                e.addSuppressed(e1);
 * Modifications Copyright OpenSearch Contributors. See
 */
            throw e;
     * non-server selectors.
 * this file be licensed under the Apache-2.0 license or a
                NioSelector selector = new NioSelector(eventHandlerFunction.apply(supplier));
        return factory.openNioChannel(address, selectorSupplier);
    /**
 *
                    closingExceptions.add(e);
 * KIND, either express or implied.  See the License for the
            startSelectors(dedicatedAcceptors, acceptorThreadFactory);
        ensureOpen();
     */
                selectors.add(selector);
 */
                assert supplierToSet.count() == selectors.size() : "Supplier should have same count as selector list.";
            ExceptionsHelper.rethrowAndSuppress(closingExceptions);
            List<IOException> closingExceptions = new ArrayList<>();
     * same selectors that are handling child channels.
                        case RuntimeException re -> throw re;
            startSelectors(selectors, selectorThreadFactory);
 * The logic specific to a particular channel is provided by the {@link ChannelFactory} passed to the method
    public <S extends NioSocketChannel> S openChannel(InetSocketAddress address, ChannelFactory<?, S> factory) throws IOException {
 * not use this file except in compliance with the License.
            try {
                    selector.isRunningFuture().get();
     * @param acceptorThreadFactory factory to create acceptor selector threads
                }
     * This will create an NioSelectorGroup with dedicated acceptors. All server channels will be handled by a group
     * @param eventHandlerFunction function for creating event handlers
 * compatible open source license.
     * @param selectorThreadFactory factory to create non-acceptor selector threads
 * this work for additional information regarding copyright
    private final RoundRobinSupplier<NioSelector> acceptorSupplier;
 * the Apache License, Version 2.0 (the "License"); you may
     *
                RoundRobinSupplier<NioSelector> supplier = new RoundRobinSupplier<>();
        ensureOpen();
 * ownership. Elasticsearch licenses this file to you under
    }
/*
import java.util.stream.Collectors;
 *
            for (int i = 0; i < dedicatedAcceptorCount; ++i) {
import java.util.ArrayList;
     *
                }
     * @throws IOException occurs if there is a problem while opening a java.nio.Selector
    @Override
        Function<Supplier<NioSelector>, EventHandler> eventHandlerFunction
import java.util.function.Supplier;
public class NioSelectorGroup implements NioGroup {
 * when the channel is created. This is what allows an NioSelectorGroup to support different channel types.
                try {
        ThreadFactory threadFactory,
    @Override
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            if (selector.isRunning() == false) {
        } catch (Exception e) {
            for (NioSelector selector : toClose) {
     * @param selectorCount the number of non-acceptor selectors to be created
            }
                suppliersToSet.add(supplier);
    public NioSelectorGroup(
    public NioSelectorGroup(
    }
 * Licensed to Elasticsearch under one or more contributor
     * @param threadFactory factory to create selector threads
                        default -> throw new RuntimeException("Exception during selector start.", e);
        int selectorCount,
import java.util.concurrent.atomic.AtomicBoolean;
                    throw new IllegalStateException("Interrupted while waiting for selector to start.", e);
            List<NioSelector> toClose = Stream.concat(dedicatedAcceptors.stream(), selectors.stream()).collect(Collectors.toList());
            }
        this(null, 0, threadFactory, selectorCount, eventHandlerFunction);
            }
            }
                    switch (e.getCause()) {
package org.opensearch.nio;
                    selector.close();
                acceptorSupplier = new RoundRobinSupplier<>(selectors.toArray(new NioSelector[0]));
     * @param dedicatedAcceptorCount the number of dedicated acceptor selectors to be created
                } catch (InterruptedException e) {
            throw new IllegalStateException("NioGroup is closed.");
                acceptorSupplier = new RoundRobinSupplier<>(dedicatedAcceptors.toArray(new NioSelector[0]));
                close();
                    }
        Function<Supplier<NioSelector>, EventHandler> eventHandlerFunction
    }
import java.net.InetSocketAddress;
        int dedicatedAcceptorCount,
 * under the License.
import java.util.concurrent.ThreadFactory;
 * can be bound using the {@link #bindServerChannel(InetSocketAddress, ChannelFactory)} method. Client
    private void ensureOpen() {
            } else {
            for (RoundRobinSupplier<NioSelector> supplierToSet : suppliersToSet) {
 * Unless required by applicable law or agreed to in writing,
    }
                } catch (ExecutionException e) {
        }
 * specific language governing permissions and limitations
        int selectorCount,
                threadFactory.newThread(selector::runLoop).start();
        ThreadFactory selectorThreadFactory,
 */
     * @param eventHandlerFunction function for creating event handlers
/*
}
 *    http://www.apache.org/licenses/LICENSE-2.0
/**
            if (dedicatedAcceptorCount != 0) {
            }
import java.util.List;
                try {
     * @param selectorCount the number of selectors to be created
 * The NioSelectorGroup is a group of selectors for interfacing with java nio. When it is started it will create the
 *
/*
        for (NioSelector selector : selectors) {
    private final List<NioSelector> selectors;
import java.util.function.Function;
 * You may obtain a copy of the License at
    private final AtomicBoolean isOpen = new AtomicBoolean(true);
    /**
 * connections can be opened using the {@link #openChannel(InetSocketAddress, ChannelFactory)} method.
                NioSelector acceptor = new NioSelector(eventHandlerFunction.apply(supplier));
        if (isOpen.compareAndSet(true, false)) {
    ) throws IOException {
import java.util.stream.Stream;
            }
