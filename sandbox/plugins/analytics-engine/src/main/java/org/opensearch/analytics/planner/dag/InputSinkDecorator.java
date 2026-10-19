/*  
     * @param sink      the producer-facing sink to wrap (already resolved per-child if
 *
 * the producer's batches reach it. Set on the {@link Stage} at DAG-build time  
     * Build a new {@link ExchangeSink} that wraps {@code sink} with this decorator's
     *                  the underlying sink is a {@link org.opensearch.analytics.spi.MultiInputExchangeSink})
import org.apache.arrow.memory.BufferAllocator;
 * lifecycle — close semantics delegate to the wrapped sink.  
 *
@FunctionalInterface  
}  
import org.opensearch.analytics.spi.ExchangeSink;
 * carry a {@code ___ugsi} ordinal before reduce. The interface is generic so
 * sink-resolution time inside the parent execution's {@code inputSink(...)}.
 */
 * (today only by {@code DAGBuilder.cutAtLateMaterialization}); applied at
 * SPDX-License-Identifier: Apache-2.0
    /**  
/**
 * @opensearch.internal
     * @param allocator allocator the decorator may use for any buffers it allocates  
public interface InputSinkDecorator {
 * The OpenSearch Contributors require contributions made to  
 *  
 * wrapper around the supplied sink. The wrapper does not own the sink's
package org.opensearch.analytics.planner.dag;
 * compatible open source license.
 *  
 * future cross-cutting concerns can reuse it without touching reducer code.
 */  
 * this file be licensed under the Apache-2.0 license or a
 * <p>Today's only producer of this hook is the QTF (late-materialization) DAG
 * Wraps a stage's incoming child sink with feature-specific decoration before
 * <p>Implementations are stateless factories: each invocation builds a fresh
     *  
 * cut, which installs an {@code OrdinalAppendingSink} so each shard's batches  
     */
     * behavior. The returned sink delegates lifecycle (close) to the wrapped sink.
    ExchangeSink decorate(ExchangeSink sink, BufferAllocator allocator);
