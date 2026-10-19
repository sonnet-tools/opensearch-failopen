     */  
     * Note: The returned stream may only be used on the thread that created it as it might use thread-local resources and must be safely  
     * closed after use
 * @opensearch.api - intended to be extended
     */
 */  
 */
 * this file be licensed under the Apache-2.0 license or a
     * Closing the returned {@link OutputStream} will close the provided output stream.
     */
     * Creates a new output stream that compresses the contents and writes to the provided output stream.
     *  
/*
import org.opensearch.common.annotation.ExperimentalApi;
    InputStream threadLocalInputStream(InputStream in) throws IOException;
 * Unless required by applicable law or agreed to in writing,
import java.io.InputStream;  
    OutputStream threadLocalOutputStream(OutputStream out) throws IOException;  
    /**  
    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
 * for codec implementations such as {@code org.opensearch.index.codec.customcodecs.Lucene95CustomCodec}
/**  
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;
     * closed after use
 * {@code org.opensearch.repositories.blobstore.BlobStoreRepository} implementations.
    boolean isCompressed(BytesReference bytes);  
     * Decompress bytes into a newly allocated buffer.  
public interface Compressor {
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
     *
     * @return compressed bytes
     * Closing the returned {@link InputStream} will close the provided stream input.  
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * <p>  
     * Creates a new input stream that decompresses the contents read from the provided input stream.
    int headerLength();
     * @param bytesReference bytes to decompress
 * You may obtain a copy of the License at  
    BytesReference compress(BytesReference bytesReference) throws IOException;
    BytesReference uncompress(BytesReference bytesReference) throws IOException;
 * Compressor interface used for compressing {@link org.opensearch.core.xcontent.MediaType} and
/*  
 *
 *
import org.opensearch.common.annotation.PublicApi;
 * for compressing {@link org.apache.lucene.document.StoredField}s  
    /**
 * not use this file except in compliance with the License.
     * @return decompressed bytes  
     * Compress bytes into a newly allocated buffer.
}
     */  
    /**
package org.opensearch.core.compress;
 * GitHub history for details.
 * specific language governing permissions and limitations
import java.io.OutputStream;
 *
     * Note: The returned stream may only be used on the thread that created it as it might use thread-local resources and must be safely
@ExperimentalApi
/*  
     * @param bytesReference bytes to compress
 * This is not to be confused with {@link org.apache.lucene.codecs.compressing.Compressor} which is used
 * this work for additional information regarding copyright
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.bytes.BytesReference;  
@PublicApi(since = "2.10.0")  
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * @opensearch.experimental - however, bwc is not guaranteed at this time  
 * under the License.  
