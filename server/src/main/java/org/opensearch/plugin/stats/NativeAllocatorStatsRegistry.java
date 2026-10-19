     * @param pressureSupplier supplies the current node native-memory utilization percentage.
import java.util.function.Supplier;
 *
     */  
        if (pressureSink != null) {
        }  
     */
     * Optional sink that forwards a node-level native-memory pressure supplier into the underlying  
package org.opensearch.plugin.stats;
 * on each {@code _nodes/stats} call.
     * result for repeated invocation; the supplier is expected to be safe to call concurrently.
    }  
     * allocator. Set by the plugin that owns the allocator (today: {@code ArrowBasePlugin}); may be
     * {@code null} when the plugin does not support over-commit admission.
     *                 (e.g. plugin closed). Must not be {@code null} itself.
    public Supplier<NativeAllocatorPoolStats> supplier() {
    public NativeAllocatorStatsRegistry(Supplier<NativeAllocatorPoolStats> supplier) {
 * @opensearch.api
     * @param supplier produces a fresh {@link NativeAllocatorPoolStats} snapshot on each call,  
 * this file be licensed under the Apache-2.0 license or a
    private final Supplier<NativeAllocatorPoolStats> supplier;  
        return supplier;
    private final Consumer<DoubleSupplier> pressureSink;
    /**
import java.util.function.DoubleSupplier;
 *
 * Component-published holder for a {@link NativeAllocatorPoolStats} supplier.
 * compatible open source license.
     * owning plugin did not provide a sink.
public final class NativeAllocatorStatsRegistry {
     */  
 * SPDX-License-Identifier: Apache-2.0
     */  
 * without leaking arrow-base or its plugin class onto the {@code :server} classpath.  
 * filters. Wrapping the supplier in a concrete class gives the server a stable lookup target
    public NativeAllocatorStatsRegistry(Supplier<NativeAllocatorPoolStats> supplier, Consumer<DoubleSupplier> pressureSink) {  
/**
    /**
     * Injects the node-level native-memory pressure supplier (percent 0–100, or negative when  
    /**  
    public void setNativeMemoryPressureSupplier(DoubleSupplier pressureSupplier) {  
 *
     *
     *                     allocator; may be {@code null}.
import org.opensearch.common.Nullable;
 *  
 * {@code SearchRequestOperationsListener} {@code instanceof} filter on {@code pluginComponents}.  
 * Java type erasure makes parameterised generics indistinguishable in {@code instanceof}
     * the supplier reference itself.
 * <p>Why a typed wrapper instead of a {@code Supplier<NativeAllocatorPoolStats>} component:  
    }
            pressureSink.accept(pressureSupplier);
    /**
    @Nullable
}
 * The OpenSearch Contributors require contributions made to  
     * Convenience accessor that invokes the supplier once. Returns {@code null} when the  
        this.supplier = supplier;
     * @param supplier     stats snapshot supplier (see single-arg constructor).
 */  
    /**
 * <p>The plugin that owns the node-level Arrow allocator (today: {@code ArrowBasePlugin})
/*  
     *  
     * unavailable) into the allocator so it can make over-commit admission decisions. No-op when the
        return supplier.get();  
 * <p>Mirrors the cross-plugin discovery shape used elsewhere in {@code Node.java}, e.g. the
     * supplier returns {@code null} (e.g. plugin closed) so callers don't need to null-check
    }  
     * Constructs a registry wrapping the given supplier.
    }  
 *
    /**  
     * Returns the wrapped supplier. Callers invoke this once at lookup time and may store the
        this.pressureSink = pressureSink;
     * Constructs a registry wrapping the given stats supplier and a pressure-supplier sink.  
        this(supplier, null);
     */  
    public NativeAllocatorPoolStats get() {
     */
 */  
     * @param pressureSink forwards an injected node-level native-memory pressure supplier into the  
 * {@code NodeService} can look it up via {@code pluginComponents} and invoke the supplier  
    }
     *
 * returns an instance of this class from its {@code createComponents()} so the server-side
import java.util.function.Consumer;  
     *                 or returns {@code null} when the underlying allocator is unavailable
