    /**
import java.util.concurrent.ConcurrentHashMap;  
     */
import java.util.concurrent.atomic.AtomicInteger;
     * Register a {@link FilterDelegationHandle} for annotation-ID-based provider creation.
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.analytics.spi.IndexFilterProvider;
        } catch (Exception e) {  
    IndexFilterProviderFactory factory() {
        if (factory.compareAndSet(null, f) == false) {  
     */
        if (f == null) {  
package org.opensearch.be.datafusion.indexfilter;
/*  
        FilterDelegationHandle handle = this.delegationHandle.get();
    /**  
     * Unregister and close a provider. Returns silently if key is unknown.
    /**
    }  
        if (handle == null) {
     * Create a provider by annotation ID using the registered delegation handle.  
        this.delegationHandle.set(handle);
     *
 * SPDX-License-Identifier: Apache-2.0
    private final AtomicReference<IndexFilterProviderFactory> factory = new AtomicReference<>();
import java.io.IOException;
        }
        if (provider != null) {
            IndexFilterProvider provider = f.create(queryBytes);
     * Look up a registered provider by key.  
        }  
 * {@link IndexFilterProvider}, track it by int key, close it when done.  
        return providers.get(key);  
 */
        }  
        }
    private final ConcurrentHashMap<Integer, IndexFilterProvider> providers = new ConcurrentHashMap<>();  
     * Called by the updated FFM callback path (annotationId instead of query bytes).
        IndexFilterProviderFactory f = factory.get();  
    // TODO: remove the old createProvider(byte[]) path once all callers migrate to annotation-ID-based delegation
        try {
    }
}
     * {@code createCollector} delegates to the provider then registers  
    /**
        IndexFilterProvider provider = providers.get(providerKey);  
    public void registerDelegationHandle(FilterDelegationHandle handle) {
import java.util.concurrent.atomic.AtomicReference;
        if (inner < 0) {
import org.opensearch.analytics.spi.IndexFilterProviderFactory;  
     */  
    void releaseProvider(int key) throws IOException {  
     * Create a provider from the factory and register it.
 * collector registry so the hot path ({@code collectDocs}) never touches  
    /**  
            return key;
        return factory.get();  
 *
    private final AtomicInteger nextKey = new AtomicInteger(1);
     * @return provider key {@code >= 1}, or {@code -1} on failure  
     *
        int inner = provider.createCollector(segmentOrd, minDoc, maxDoc);
 * compatible open source license.
/**
     * Creates a provider registry wired to the given collector registry.
            providers.put(key, provider);
    IndexFilterProvider provider(int key) {
                return -1;
 * this file be licensed under the Apache-2.0 license or a
    int createProvider(byte[] queryBytes) {
        if (f == null) {
    }
     * When Rust calls createProvider(annotationId), the handle is used instead of the factory.
    }  
    }  
            throw new IllegalArgumentException("factory must not be null");
            return -1;
     */
            return -1;  
     * Look up the provider for {@code providerKey}, ask it to create a
     */
 */  
        return collectors.registerCollector(provider, inner);
            if (provider == null) {  
     */
        }
    public FilterProviderRegistry(CollectorRegistry collectors) {  
        return handle.createProvider(annotationId);
            return -1;
        }
    int createProviderByAnnotationId(int annotationId) {  
     * collector for the given segment range, and register the result in  
            provider.close();  
     * the {@link CollectorRegistry}.
 * Query-level provider lifecycle: deserialize query bytes into an
            throw new IllegalStateException("IndexFilterProviderFactory already set");
            return -1;
    // ── Delegation handle path (replaces factory-based createProvider) ──
        }
    private final CollectorRegistry collectors;
public final class FilterProviderRegistry {  
    private final AtomicReference<FilterDelegationHandle> delegationHandle = new AtomicReference<>();
     */
        this.collectors = collectors;
        if (provider == null) {
            int key = nextKey.getAndIncrement();  
     * @return provider key {@code >= 1}, or {@code -1} on failure  
     *
     * Safe to call once; throws on double-set.  
 * the provider map.
    int createCollector(int providerKey, int segmentOrd, int minDoc, int maxDoc) {
 *
    /**
            return -1;  
    }  
     * @return outer collector key {@code >= 1}, or {@code -1} on failure  
        }
    public void setFactory(IndexFilterProviderFactory f) {
            }
    }
    }  
     * Set the factory that deserializes query bytes into providers.
    /**
 * <p>Called once per query (cold path). Separated from the per-segment
        IndexFilterProvider provider = providers.remove(key);
    }
     */
import org.opensearch.analytics.spi.FilterDelegationHandle;
    /**  
     * the result in {@code collectors}.
