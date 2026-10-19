     * @param keyProviderType Unique type of key provider to distinguish between different key provider implementations.
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.api
 * compatible open source license.
@ExperimentalApi  
package org.opensearch.plugins;
        Runnable onClose
 * SPDX-License-Identifier: Apache-2.0
    );
import org.opensearch.common.crypto.MasterKeyProvider;  
 */  
        String keyProviderName,
     * @param keyProviderName Name of key provider to distinguish between multiple instances created with different  
     * @return crypto handler instance.
        String keyProviderType,  
     * @param onClose Closes key provider or other clean up operations on close.  
/**
 * Crypto plugin to provide encryption and decryption support.  
        MasterKeyProvider keyProvider,
 * The OpenSearch Contributors require contributions made to  
}  
public interface CryptoPlugin<T, U> {
     */
import org.opensearch.common.annotation.ExperimentalApi;
     * @param keyProvider key provider instance to provide keys used in encrypting data.
 */
     * To create a crypto handler for handling encryption and decryption ops.
     *                        configurations of same keyProviderType.
 *
    CryptoHandler<T, U> getOrCreateCryptoHandler(  
import org.opensearch.common.crypto.CryptoHandler;
/*  
    /**  
