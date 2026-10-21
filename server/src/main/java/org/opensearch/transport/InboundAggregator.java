 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.bytes.BytesArray;
        if (isFirstContent()) {
        canTripBreaker = true;
                firstContent = content.retain();
        assert isAggregating();
        Supplier<CircuitBreaker> circuitBreaker,
/*
            shortCircuit(e);
     * Internal circuit breaker control
                aggregated.close();
        try {
        } else {
            final RequestHandlerRegistry<TransportRequest> reg = registryFunction.apply(actionName);
 * this file be licensed under the Apache-2.0 license or a
                if (contentAggregation == null) {
        return currentHeader != null;
    @Override
import java.util.function.Function;
            assert set : "Expected bytesToRelease to be 0, found " + bytesToRelease.get();
        ensureOpen();
                    firstContent = null;
        aggregationException = null;
            if (isShortCircuited() == false) {
            if (aggregated.getHeader().needsToReadVariableHeader()) {
        this.requestCanTripBreaker = requestCanTripBreaker;
            circuitBreaker.get().addWithoutBreaking(contentLength);
     */
        this.aggregationException = exception;
            if (isShortCircuited()) {
            } else {
            releasableContent = ReleasableBytesReference.wrap(BytesArray.EMPTY);
        final InboundMessage aggregated = new InboundMessage(currentHeader, releasableContent, breakerControl);
    }
    }
    }
                return aggregated;
        if (contentAggregation == null) {
 * the Apache License, Version 2.0 (the "License"); you may
            final int toRelease = bytesToRelease.getAndSet(CLOSED);
        Function<String, RequestHandlerRegistry<TransportRequest>> registryFunction
        private void setReservedBytes(int reservedBytes) {
    private void releaseContent() {
    }
    }
    }
 */
            if (isFirstContent()) {
        assert isAggregating() == false;
        }
                    initializeRequestState();
            }
        }
        if (isShortCircuited() == false) {
        }
        } catch (ActionNotFoundTransportException e) {
        if (currentHeader.isHandshake()) {
        });
        }
    }
    public void headerReceived(Header header) {
            assert toRelease != CLOSED;
 *
        ensureOpen();
        if (currentHeader.isRequest() && currentHeader.needsToReadVariableHeader() == false) {
        resetCurrentAggregation();
                success = true;
    private final Supplier<CircuitBreaker> circuitBreaker;
     * @opensearch.internal
        if (canTripBreaker) {
            Releasables.close(firstContent);
        releaseContent();
 * @opensearch.internal
    InboundAggregator(Supplier<CircuitBreaker> circuitBreaker, Predicate<String> requestCanTripBreaker) {
        assert currentHeader.needsToReadVariableHeader() == false;
        } else {
/**
/*
    public InboundMessage finishAggregation() throws IOException {
            return;
 * ownership. Elasticsearch licenses this file to you under
        boolean success = false;
    // Visible for testing
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.core.common.breaker.CircuitBreaker;
    private void closeCurrentAggregation() {
        final String actionName = currentHeader.getActionName();
            canTripBreaker = requestCanTripBreaker.test(actionName);
        }
                    contentAggregation = new ArrayList<>(4);
            initializeRequestState();
        firstContent = null;
 *
import java.util.function.Supplier;
 *
        private static final int CLOSED = -1;
 * Licensed to Elasticsearch under one or more contributor
            breakerControl.setReservedBytes(contentLength);
            if (success == false) {
import org.opensearch.common.lease.Releasables;
 * software distributed under the License is distributed on an
    /**
            return;
        if (header.isRequest() == false) {
        contentAggregation = null;
            canTripBreaker = false;
    private Header currentHeader;
            }
        closeCurrentAggregation();
        currentHeader = header;
package org.opensearch.transport;
            releasableContent = firstContent;
}
        } else if (contentAggregation == null) {
import java.util.function.Predicate;
    private void checkBreaker(final Header header, final int contentLength, final BreakerControl breakerControl) {
import org.opensearch.common.bytes.ReleasableBytesReference;
            }
    public boolean isAggregating() {
 * GitHub history for details.
            } catch (CircuitBreakingException e) {
    }
        }
            }
    public void aggregate(ReleasableBytesReference content) {
            Releasables.close(contentAggregation);
 * not use this file except in compliance with the License.
    private boolean canTripBreaker = true;
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
                checkBreaker(aggregated.getHeader(), aggregated.getContentLength(), breakerControl);
        }
                return new InboundMessage(aggregated.getHeader(), aggregationException);
                contentAggregation.add(content.retain());
        }
    }
        currentHeader = null;
import org.opensearch.core.common.bytes.CompositeBytesReference;
 * Modifications Copyright OpenSearch Contributors. See
    private ReleasableBytesReference firstContent;
            }
                if (aggregated.getHeader().isRequest()) {
    }
    private boolean isShortCircuited() {
        private final AtomicInteger bytesToRelease = new AtomicInteger(0);
        private BreakerControl(Supplier<CircuitBreaker> circuitBreaker) {
                success = true;
    private boolean isFirstContent() {
 * compatible open source license.
            } else {
 * specific language governing permissions and limitations
                circuitBreaker.get().addWithoutBreaking(-toRelease);
    }
            resetCurrentAggregation();
 * Unless required by applicable law or agreed to in writing,
public class InboundAggregator implements Releasable {
        assert header.needsToReadVariableHeader() == false;
                }
                }
        ensureOpen();
        }
        return firstContent == null && contentAggregation == null;
        this.circuitBreaker = circuitBreaker;
                throw new ActionNotFoundTransportException(actionName);
                shortCircuit(e);
        private final Supplier<CircuitBreaker> circuitBreaker;
    }
    }
        return aggregationException != null;
        }
            final BytesReference content = CompositeBytesReference.of(references);
    ) {
        } else {
        assert firstContent == null && contentAggregation == null;
            final boolean set = bytesToRelease.compareAndSet(0, reservedBytes);
            }
 * under the License.
        if (isClosed) {
    private static class BreakerControl implements Releasable {
    private void initializeRequestState() {
    private void resetCurrentAggregation() {
            final ReleasableBytesReference[] references = contentAggregation.toArray(new ReleasableBytesReference[0]);
    private boolean isClosed = false;
     *
            } else {
            if (toRelease > 0) {
    }
        public void close() {
 * The OpenSearch Contributors require contributions made to
                breakerControl.setReservedBytes(contentLength);
import org.opensearch.core.common.breaker.CircuitBreakingException;
    private void ensureOpen() {
        @Override
            if (reg == null) {
 * Aggregates inbound data
        }
            }
 */
        final BreakerControl breakerControl = new BreakerControl(circuitBreaker);
                    assert firstContent != null;
        } finally {
    private void shortCircuit(Exception exception) {
    public InboundAggregator(
import java.util.ArrayList;
                return reg.canTripCircuitBreaker();
import java.io.IOException;
        try {
        final ReleasableBytesReference releasableContent;
 */
import java.util.concurrent.atomic.AtomicInteger;
    private Exception aggregationException;
                aggregated.close();
        }
                aggregated.getHeader().finishParsingHeader(aggregated.openOrGetStreamInput());
        isClosed = true;
        }
import org.opensearch.common.lease.Releasable;
    public void close() {
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at
        this(circuitBreaker, (Predicate<String>) actionName -> {
                    contentAggregation.add(firstContent);
            }
    }
 * this work for additional information regarding copyright
 *
    private ArrayList<ReleasableBytesReference> contentAggregation;
            try {
    private final Predicate<String> requestCanTripBreaker;
 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalStateException("Aggregator is already closed");
            this.circuitBreaker = circuitBreaker;
                circuitBreaker.get().addEstimateBytesAndMaybeBreak(contentLength, header.getActionName());
 *    http://www.apache.org/licenses/LICENSE-2.0
        assert currentHeader.isRequest();
    }
            releasableContent = new ReleasableBytesReference(content, () -> Releasables.close(references));
 */
