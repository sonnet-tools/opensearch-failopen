    /**
    public VersionedBlob(byte[] content, String versionToken) {  
        return versionToken;  
 */  
/*  
 *
public final class VersionedBlob {  
 * The content of a blob along with the opaque version token observed when it was read. The token can be passed to  
    /** Returns the opaque version token the blob had when read. */
        return content;
    }  
 *
@ExperimentalApi
     * @param versionToken the opaque version token (e.g. ETag) the blob had when read
 * SPDX-License-Identifier: Apache-2.0
    public byte[] content() {  
import java.util.Objects;  
 * The OpenSearch Contributors require contributions made to  
 * {@link BlobContainer#writeBlobConditionally} to perform a compare-and-swap update of the blob.
        this.content = Objects.requireNonNull(content, "content must not be null");
    private final byte[] content;
     * @param content      the blob content  
package org.opensearch.common.blobstore;
 * compatible open source license.
 */
    }
    public String versionToken() {
 * @opensearch.experimental  
 * this file be licensed under the Apache-2.0 license or a
/**
    }
        this.versionToken = Objects.requireNonNull(versionToken, "versionToken must not be null");
    /** Returns the blob content. */
import org.opensearch.common.annotation.ExperimentalApi;
}
     */
    private final String versionToken;  
