public class EncryptedBlobMetadata<T, U> implements BlobMetadata {  
    @Override
        return delegate.name();
/*  
    ) {  
    @Override  
 * Adjusts length of encrypted blob to raw length
        this.encryptedHeaderContentSupplier = encryptedHeaderContentSupplier;
    public long length() {  
 */
    }  
    }
        this.cryptoHandler = cryptoHandler;  
        try {
        return cryptoHandler.estimateDecryptedLength(cryptoContext, delegate.length());
        BlobMetadata delegate,  
    private final BlobMetadata delegate;
}  
    }
        EncryptedHeaderContentSupplier encryptedHeaderContentSupplier
 * compatible open source license.
 *
    private final CryptoHandler<T, U> cryptoHandler;  
        CryptoHandler<T, U> cryptoHandler,
        this.delegate = delegate;
import org.opensearch.common.crypto.EncryptedHeaderContentSupplier;
            cryptoContext = cryptoHandler.loadEncryptionMetadata(encryptedHeaderContentSupplier);  
    public EncryptedBlobMetadata(
        } catch (IOException ex) {
 * The OpenSearch Contributors require contributions made to  
/**  
        U cryptoContext;
 * this file be licensed under the Apache-2.0 license or a
            throw new RuntimeException(ex);
 * SPDX-License-Identifier: Apache-2.0
 */  
        }  
    public String name() {
package org.opensearch.common.blobstore;
import java.io.IOException;
    private final EncryptedHeaderContentSupplier encryptedHeaderContentSupplier;
import org.opensearch.common.crypto.CryptoHandler;
