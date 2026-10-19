    /**
 */
/*  
 * This is used in partial decryption. Header information is required for decryption of actual encrypted content.  
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;  
 * SPDX-License-Identifier: Apache-2.0
 *
     * @return Encrypted header content (May contain additional content which is later discarded)
 * Implementation of this supplier only requires first few bytes of encrypted content to be supplied.
 * compatible open source license.
package org.opensearch.common.crypto;
public interface EncryptedHeaderContentSupplier {  
 * The OpenSearch Contributors require contributions made to  
    byte[] supply(long start, long end) throws IOException;
     * @param end End position of the header.
     */
/**
}  
     * @param start Start position of the encrypted content (Generally supplied as 0 during usage)  
     * @throws IOException In case content fetch fails.  
 */  
