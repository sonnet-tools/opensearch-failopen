import org.opensearch.common.annotation.ExperimentalApi;
     * @return master key provider.
     * Every call to this method should return a new key provider.
public interface CryptoKeyProviderPlugin {
 * Crypto plugin to provide support for custom key providers.  
     * @return key provider type
/*  
     * @param cryptoMetadata These are crypto settings needed for creation of a new key provider.  
 *
    MasterKeyProvider createKeyProvider(CryptoMetadata cryptoMetadata);  
 *
     */
 * this file be licensed under the Apache-2.0 license or a
    /**
/**
package org.opensearch.plugins;
 * The OpenSearch Contributors require contributions made to  
}
 * SPDX-License-Identifier: Apache-2.0
 */  
 */  
import org.opensearch.cluster.metadata.CryptoMetadata;
 * @opensearch.experimental
    /**
    String type();  
@ExperimentalApi
import org.opensearch.common.crypto.MasterKeyProvider;  
 * compatible open source license.
     * One crypto plugin extension implementation refers to a unique key provider type.  
     */
