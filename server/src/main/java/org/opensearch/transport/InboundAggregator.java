            } catch (CircuitBreakingException e) {
 * Aggregates inbound data  
public class InboundAggregator implements Releasable {
    private Exception aggregationException;  
    InboundAggregator(Supplier<CircuitBreaker> circuitBreaker, Predicate<String> requestCanTripBreaker) {
            if (toRelease > 0) {
        private final AtomicInteger bytesToRelease = new AtomicInteger(0);
                    firstContent = null;  
    private ArrayList<ReleasableBytesReference> contentAggregation;
    }
    ) {
        }  
        try {
            shortCircuit(e);
            circuitBreaker.get().addWithoutBreaking(contentLength);
        }  
 * the Apache License, Version 2.0 (the "License"); you may
        assert isAggregating();  
 * license agreements. See the NOTICE file distributed with
        if (header.isRequest() == false) {
            }
    }
            canTripBreaker = false;  
    private final Supplier<CircuitBreaker> circuitBreaker;  
     * @opensearch.internal
        return aggregationException != null;
        } finally {
    }  
/*  
        return currentHeader != null;
        currentHeader = null;  
        }
                shortCircuit(e);
    }  
        aggregationException = null;
                checkBreaker(aggregated.getHeader(), aggregated.getContentLength(), breakerControl);
    private void resetCurrentAggregation() {  
    private Header currentHeader;
        }  
            canTripBreaker = requestCanTripBreaker.test(actionName);  
    private void initializeRequestState() {
            if (aggregated.getHeader().needsToReadVariableHeader()) {  
            initializeRequestState();  
        if (canTripBreaker) {  
    }  
    public void aggregate(ReleasableBytesReference content) {
        final InboundMessage aggregated = new InboundMessage(currentHeader, releasableContent, breakerControl);  
/**
}
 * Licensed to Elasticsearch under one or more contributor  
 *  
        assert header.needsToReadVariableHeader() == false;
                breakerControl.setReservedBytes(contentLength);  
    }
        if (isShortCircuited() == false) {
     */
            Releasables.close(contentAggregation);
        } else {
                aggregated.close();
            assert set : "Expected bytesToRelease to be 0, found " + bytesToRelease.get();
            }  
        }
                aggregated.getHeader().finishParsingHeader(aggregated.openOrGetStreamInput());
        assert currentHeader.needsToReadVariableHeader() == false;  
    private void closeCurrentAggregation() {
                circuitBreaker.get().addEstimateBytesAndMaybeBreak(contentLength, header.getActionName());
        return firstContent == null && contentAggregation == null;
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
            final RequestHandlerRegistry<TransportRequest> reg = registryFunction.apply(actionName);  
        public void close() {
            if (isShortCircuited()) {  
        private static final int CLOSED = -1;
            if (isFirstContent()) {
 * ownership. Elasticsearch licenses this file to you under  
    // Visible for testing  
    }
    private boolean isClosed = false;
    }
            if (reg == null) {
            resetCurrentAggregation();  
    public InboundAggregator(
            if (isShortCircuited() == false) {  
import java.util.ArrayList;
        }
            } else {  
    public void headerReceived(Header header) {  
import org.opensearch.core.common.breaker.CircuitBreakingException;
        if (isFirstContent()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return;
        ensureOpen();
            final ReleasableBytesReference[] references = contentAggregation.toArray(new ReleasableBytesReference[0]);  
            throw new IllegalStateException("Aggregator is already closed");
            releasableContent = ReleasableBytesReference.wrap(BytesArray.EMPTY);
    @Override
                if (aggregated.getHeader().isRequest()) {
        ensureOpen();
/*  
        private void setReservedBytes(int reservedBytes) {
        } else if (contentAggregation == null) {  
import java.util.function.Predicate;
        } else {
                circuitBreaker.get().addWithoutBreaking(-toRelease);  
     * Internal circuit breaker control
        }  
        }
                }
                }
                    initializeRequestState();  
            } else {
        this(circuitBreaker, (Predicate<String>) actionName -> {
import java.util.function.Supplier;  
 *
 */  
        this.aggregationException = exception;  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
            this.circuitBreaker = circuitBreaker;
        isClosed = true;
import org.opensearch.core.common.breaker.CircuitBreaker;
        Function<String, RequestHandlerRegistry<TransportRequest>> registryFunction  
            assert toRelease != CLOSED;
                    assert firstContent != null;
    }
        if (currentHeader.isHandshake()) {
        boolean success = false;
    private void ensureOpen() {
        contentAggregation = null;
    }  
    }
 * GitHub history for details.
    /**
import org.opensearch.common.lease.Releasable;
     *  
        ensureOpen();
        @Override
        assert firstContent == null && contentAggregation == null;  
        if (isClosed) {  
    }
 * this work for additional information regarding copyright
 * @opensearch.internal
    private boolean canTripBreaker = true;
    private boolean isFirstContent() {
            releasableContent = firstContent;
        canTripBreaker = true;
 * You may obtain a copy of the License at  
        private final Supplier<CircuitBreaker> circuitBreaker;
            }
import java.util.concurrent.atomic.AtomicInteger;  
            }  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
    private final Predicate<String> requestCanTripBreaker;
 *
import org.opensearch.core.common.bytes.BytesReference;
        firstContent = null;
            breakerControl.setReservedBytes(contentLength);  
import java.io.IOException;
 * under the License.  
                return new InboundMessage(aggregated.getHeader(), aggregationException);  
            Releasables.close(firstContent);  
 */  
 * this file be licensed under the Apache-2.0 license or a
        }  
            if (success == false) {
            final boolean set = bytesToRelease.compareAndSet(0, reservedBytes);  
                    contentAggregation.add(firstContent);
        releaseContent();  
    }
        final BreakerControl breakerControl = new BreakerControl(circuitBreaker);
    }
package org.opensearch.transport;
            final int toRelease = bytesToRelease.getAndSet(CLOSED);  
            releasableContent = new ReleasableBytesReference(content, () -> Releasables.close(references));
            }
                return reg.canTripCircuitBreaker();
 * Modifications Copyright OpenSearch Contributors. See
    private void shortCircuit(Exception exception) {
            }
        this.circuitBreaker = circuitBreaker;
 */
        Supplier<CircuitBreaker> circuitBreaker,
    private void checkBreaker(final Header header, final int contentLength, final BreakerControl breakerControl) {  
 * Unless required by applicable law or agreed to in writing,
        if (currentHeader.isRequest() && currentHeader.needsToReadVariableHeader() == false) {
            try {
        assert isAggregating() == false;
    public InboundMessage finishAggregation() throws IOException {
/*
            }
                throw new ActionNotFoundTransportException(actionName);
        closeCurrentAggregation();
        }
import org.opensearch.common.lease.Releasables;  
        final ReleasableBytesReference releasableContent;  
        });  
            return;
 */  
 * specific language governing permissions and limitations
    public boolean isAggregating() {
        this.requestCanTripBreaker = requestCanTripBreaker;  
 * not use this file except in compliance with the License.
    private ReleasableBytesReference firstContent;  
                aggregated.close();
import java.util.function.Function;
        final String actionName = currentHeader.getActionName();
        assert currentHeader.isRequest();
import org.opensearch.core.common.bytes.CompositeBytesReference;
    private boolean isShortCircuited() {  
        if (contentAggregation == null) {
        currentHeader = header;
        }
            } else {
import org.opensearch.core.common.bytes.BytesArray;  
        private BreakerControl(Supplier<CircuitBreaker> circuitBreaker) {
            }  
 * compatible open source license.
        }
                success = true;
                    contentAggregation = new ArrayList<>(4);  
    }  
        } catch (ActionNotFoundTransportException e) {
    public void close() {  
        }
                firstContent = content.retain();  
import org.opensearch.common.bytes.ReleasableBytesReference;
    private static class BreakerControl implements Releasable {  
                if (contentAggregation == null) {
                success = true;
        } else {
    private void releaseContent() {
 *
        resetCurrentAggregation();
    }
        try {
                contentAggregation.add(content.retain());
            final BytesReference content = CompositeBytesReference.of(references);
                return aggregated;  
