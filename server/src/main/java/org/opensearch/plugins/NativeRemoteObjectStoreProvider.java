     */  
@ExperimentalApi
     * endpoint, credentials) from the repository metadata and node settings
 * <p>Returns a {@link NativeStoreRepository} that wraps the native pointer
     *
import org.opensearch.common.settings.Settings;  
 * with use-after-close protection. The repository is {@link AutoCloseable}
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.repositories.NativeStoreRepository;
 * this file be licensed under the Apache-2.0 license or a
     * and returns a {@link NativeStoreRepository} wrapping the native pointer.  
 *
 * @opensearch.experimental
/**  
 *
 * compatible open source license.
     * (which include keystore values), serializes it for the FFM boundary,
     * @param metadata repository metadata with type-specific settings
     * Create a native Rust ObjectStore from repository metadata and node settings.
}
 */  
     */
public interface NativeRemoteObjectStoreProvider {
    NativeStoreRepository createNativeStore(RepositoryMetadata metadata, Settings nodeSettings);  
 * The OpenSearch Contributors require contributions made to  
 * — callers close it to free the native resource.  
     * not supported or the provider cannot create a store for this metadata.  
 *
    /**
     * <p>The provider resolves backend-specific configuration (bucket, region,  
 * {@link org.opensearch.plugins.ExtensiblePlugin} extension loading.
 *
 *  
package org.opensearch.plugins;
     * The repository type this provider handles (e.g. "s3", "gcs", "azure", "fs").
     * <p>Returns {@link NativeStoreRepository#EMPTY} if native store creation is
    /**  
     * @param nodeSettings node-level settings including keystore entries  
    String repositoryType();
import org.opensearch.common.annotation.ExperimentalApi;
 * <p>Each repository plugin that supports native reads implements this interface  
import org.opensearch.cluster.metadata.RepositoryMetadata;
     *
 * as a stateless factory. Consumers discover providers via
 */  
     * @return a live native store, or {@link NativeStoreRepository#EMPTY}
/*  
 * <p>JSON serialization for the FFM boundary is an implementation detail
 * SPI for plugins that provide native (Rust) remote ObjectStore backends.
     *
 * of each provider plugin, not part of this SPI.  
