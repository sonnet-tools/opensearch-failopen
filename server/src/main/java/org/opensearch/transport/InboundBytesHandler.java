        this.pending = pending;
                assert aggregator.isAggregating() == false;
                    forwardFragments(channel, fragments, messageHandler);
        isClosed = true;  
 * compatible open source license.
    private boolean isClosed = false;  
    public void close() {
                            continueDecoding = false;
                        }  
            } else {  
            }
                try (ReleasableBytesReference toDecode = getPendingBytes()) {
 * Handler for inbound bytes, using {@link InboundDecoder} to decode headers  
import org.opensearch.core.common.bytes.CompositeBytesReference;
import java.util.function.BiConsumer;  
        this.decoder = decoder;  
                    bytesToRelease -= reference.length();
    private final StatsTracker statsTracker;
 */  
                    if (bytesDecoded != 0) {
                            releasableBytesReference.close();
    private final ArrayDeque<ReleasableBytesReference> pending;
}
                        releasePendingBytes(bytesDecoded);
                aggregator.aggregate((ReleasableBytesReference) fragment);  
        ArrayDeque<ReleasableBytesReference> pending,  
        return fragment == InboundDecoder.PING || fragment == InboundDecoder.END_CONTENT || fragment instanceof Exception;  
import org.opensearch.common.lease.Releasable;
        }
                    }
            final ReleasableBytesReference[] bytesReferences = new ReleasableBytesReference[pending.size()];  
        while (continueHandling && isClosed == false) {
                } finally {
    private void releasePendingBytes(int bytesConsumed) {
 * the given message handler to parse the message payload.
                        if (fragments.isEmpty() == false && endOfMessage(fragments.get(fragments.size() - 1))) {  
                } else {
/**
                aggregator.headerReceived(header);
            try (ReleasableBytesReference reference = pending.pollFirst()) {
                        }
                try {  
    }  
    private ReleasableBytesReference getPendingBytes() {
                if (bytesToRelease < reference.length()) {
        }
 * this file be licensed under the Apache-2.0 license or a
            for (ReleasableBytesReference pendingReference : pending) {
            return pending.peekFirst().retain();
        for (Object fragment : fragments) {
    }  
        InboundDecoder decoder,
                assert fragment instanceof ReleasableBytesReference;
                    statsTracker.markMessageReceived();  
    }  
            final Releasable releasable = () -> Releasables.closeWhileHandlingException(bytesReferences);  
    ) {
    private final InboundAggregator aggregator;
                messageHandler.accept(channel, InboundMessage.PING);
 * The OpenSearch Contributors require contributions made to  
                assert reference != null;  
                    } else {  
                    }
    public void doHandleBytes(TcpChannel channel, ReleasableBytesReference reference, BiConsumer<TcpChannel, InboundMessage> messageHandler)  
        InboundAggregator aggregator,
                ++index;
            } else {
                    pending.addFirst(reference.retainedSlice(bytesToRelease, reference.length() - bytesToRelease));
                    bytesToRelease -= bytesToRelease;  
import org.opensearch.common.bytes.ReleasableBytesReference;
            }
        }
            }
    private static final ThreadLocal<ArrayList<Object>> fragmentList = ThreadLocal.withInitial(ArrayList::new);  
                    messageHandler.accept(channel, aggregated);
 *
import java.io.IOException;  
        StatsTracker statsTracker  
            } else if (fragment == InboundDecoder.PING) {  
/*  
            return new ReleasableBytesReference(CompositeBytesReference.of(bytesReferences), releasable);
            boolean continueDecoding = true;  
                }  
    }
        this.aggregator = aggregator;
            }
import java.util.ArrayDeque;
                bytesReferences[index] = pendingReference.retain();  
                }  
    private boolean endOfMessage(Object fragment) {
 * SPDX-License-Identifier: Apache-2.0
            if (fragments.isEmpty()) {  
                }  
                    fragments.clear();
        int bytesToRelease = bytesConsumed;  
import org.opensearch.common.lease.Releasables;  
        final ArrayList<Object> fragments = fragmentList.get();
package org.opensearch.transport;
                        continueDecoding = false;
    }
                assert aggregator.isAggregating() == false;
    private void forwardFragments(TcpChannel channel, ArrayList<Object> fragments, BiConsumer<TcpChannel, InboundMessage> messageHandler)  
import java.util.ArrayList;
class InboundBytesHandler {
            while (continueDecoding && pending.isEmpty() == false) {
                assert aggregator.isAggregating();
        while (bytesToRelease != 0) {
 */  
            if (fragment instanceof Header header) {  
    }  
        throws IOException {
        boolean continueHandling = true;  
                        if (fragment instanceof ReleasableBytesReference releasableBytesReference) {
                    final int bytesDecoded = decoder.decode(toDecode, fragments::add);  
                continueHandling = false;
 * and {@link InboundAggregator} to assemble complete messages to forward to
            int index = 0;
                    for (Object fragment : fragments) {  
                }
    private final InboundDecoder decoder;  
        }
        } else {
            }
    }  
            } else if (fragment == InboundDecoder.END_CONTENT) {  
    InboundBytesHandler(
                assert aggregator.isAggregating();
        throws IOException {
        this.statsTracker = statsTracker;
                try (InboundMessage aggregated = aggregator.finishAggregation()) {
        if (pending.size() == 1) {  
