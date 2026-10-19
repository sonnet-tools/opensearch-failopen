    @Override  
        super(ptr);  
        NativeBridge.destroyCustomCacheManager(ptr);
import org.opensearch.analytics.backend.jni.ConsumableNativeHandle;
public class NativeCacheManagerHandle extends ConsumableNativeHandle {  
 * compatible open source license.
}
    protected void doCloseNative() {
 *
 * The OpenSearch Contributors require contributions made to  
 * Handle for the native cache manager pointer.
 */  
    }  
package org.opensearch.be.datafusion.cache;
/**
 * Ownership transfers to the DataFusion runtime via createGlobalRuntime,  
/*  
import org.opensearch.be.datafusion.nativelib.NativeBridge;
 */
 * this file be licensed under the Apache-2.0 license or a
    public NativeCacheManagerHandle(long ptr) {
 * SPDX-License-Identifier: Apache-2.0
 * after which this handle is marked consumed.
    }
