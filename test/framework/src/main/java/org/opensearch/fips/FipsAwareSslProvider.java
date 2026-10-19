 * file extension, JCA provider, and JSSE provider for creating SSL contexts, key managers, or
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.fips;
 * A functional interface for creating SSL-related objects with FIPS-aware configuration.
    T create(String keyStoreType, String fileExtension, String jcaProvider, String jsseProvider);  
 * Automatically detects whether FIPS mode is enabled and provides the appropriate keystore type,
/**
}
 */  
    default T create() {
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
/*  
 * @param <T> the type of SSL object to create
        return create(cfg.keyStoreType(), cfg.fileExtension(), cfg.jcaProvider(), cfg.jsseProvider());  
 */  
        var cfg = FipsConfig.detect();
 * trust managers.  
    }
 *
public interface FipsAwareSslProvider<T> {
 *
@FunctionalInterface
 * <p>  
