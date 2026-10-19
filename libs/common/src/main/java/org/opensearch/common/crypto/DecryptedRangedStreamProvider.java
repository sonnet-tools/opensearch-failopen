     * To construct adjusted encrypted range.  
     */  
     * @param decryptedStreamProvider stream provider for decryption and range re-adjustment.
    /**  
     * desired range of decrypted content by skipping extra content which got decrypted as a result of range adjustment.
     */  
        return decryptedStreamProvider;
public class DecryptedRangedStreamProvider {
 * this file be licensed under the Apache-2.0 license or a
/*  
}
 */  
 * compatible open source license.
    }
     * Adjusted range of partial encrypted content which needs to be used for decryption.
    /**
     * @param adjustedRange range of partial encrypted content which needs to be used for decryption.
/**
     */  
 * The OpenSearch Contributors require contributions made to  
    /** Stream provider for decryption and range re-adjustment. */
    public long[] getAdjustedRange() {
        return adjustedRange;
     * @return adjusted range
    /** Adjusted range of partial encrypted content which needs to be used for decryption. */  
    /**
package org.opensearch.common.crypto;
     * @return stream provider for decryption and supplying the desired range of content.
    public UnaryOperator<InputStream> getDecryptedStreamProvider() {
 *
import java.util.function.UnaryOperator;
    }  
 * SPDX-License-Identifier: Apache-2.0
 * Contains adjusted range of partial encrypted content which needs to be used for decryption.
    }  
     * A utility stream provider which supplies the stream responsible for decrypting the content and reading the  
        this.adjustedRange = adjustedRange;
        this.decryptedStreamProvider = decryptedStreamProvider;  
    private final UnaryOperator<InputStream> decryptedStreamProvider;  
    public DecryptedRangedStreamProvider(long[] adjustedRange, UnaryOperator<InputStream> decryptedStreamProvider) {
 */  
    private final long[] adjustedRange;
import java.io.InputStream;
