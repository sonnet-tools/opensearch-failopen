     * @return a new {@link ZstdInputStreamNoFinalizer} from the given compressed {@link InputStream}
 * @opensearch.api - registered name requires BWC support
    /**
    /**
     * @return always throws an exception
     * Always throws an {@link UnsupportedOperationException} as ZSTD compression is supported only for snapshotting  
     * @param bytesReference a reference to the bytes to compress
                return false;
    @Override
     * @throws IllegalArgumentException if the input stream is not compressed with ZSTD  
        if (bytes.length() < HEADER.length) {
}  
     * @param bytesReference a reference to the bytes to uncompress
     * Returns a new {@link ZstdOutputStreamNoFinalizer} from the given {@link OutputStream}  
import org.opensearch.core.compress.Compressor;
        throw new UnsupportedOperationException("ZSTD compression is supported only for snapshotting");
     * The name to register the compressor by  
     */
     */  
    /**
     */
     */
     * @param out the {@link OutputStream}
     * Always throws an {@link UnsupportedOperationException} as ZSTD compression is supported only for snapshotting  
    public BytesReference uncompress(BytesReference bytesReference) throws IOException {
/*  
/**
     * @param bytes the bytes to compare to ({@link ZstdCompressor#HEADER})  
import java.io.BufferedInputStream;  
        return true;
import org.opensearch.common.annotation.PublicApi;
    }
        if (Arrays.equals(header, HEADER) == false) {
     * @return a new {@link ZstdOutputStreamNoFinalizer} from the given {@link OutputStream}
    }
    private static final byte[] HEADER = new byte[] { 'Z', 'S', 'T', 'D', '\0' };  
        }
     * @param in the compressed {@link InputStream}  
     */  
public class ZstdCompressor implements Compressor {
        throw new UnsupportedOperationException("ZSTD compression is supported only for snapshotting");
    @Override
     * @throws UnsupportedOperationException if the method is called  
     */
     * @return true if the bytes are the {@link ZstdCompressor#HEADER}, false otherwise
     * An arbitrary header that we use to identify compressed streams
     * Returns a new {@link ZstdInputStreamNoFinalizer} from the given compressed {@link InputStream}
            if (bytes.get(i) != HEADER[i]) {  
        for (int i = 0; i < HEADER.length; ++i) {
     * */
import com.github.luben.zstd.ZstdOutputStreamNoFinalizer;  
 *  
     * Returns the length of the {@link ZstdCompressor#HEADER}
 * this file be licensed under the Apache-2.0 license or a
     * @return the {@link ZstdCompressor#HEADER} length  
 */  
 *
        }  
    public static final String NAME = "ZSTD";
     */
        final byte[] header = in.readNBytes(HEADER.length);
    /**
        }
            return false;  
    }  
     * @opensearch.api - requires BWC support
import org.opensearch.core.common.bytes.BytesReference;  
     * Compares the given bytes with the {@link ZstdCompressor#HEADER} of a compressed stream
     * @throws IOException if an I/O error occurs
    /**
     * enough so that no stream starting with these bytes could be detected as  
    /**
    private static final int BUFFER_SIZE = 4096;
import java.io.BufferedOutputStream;
     */
        return HEADER.length;
    public BytesReference compress(BytesReference bytesReference) throws IOException {  
 * @opensearch.experimental - class methods might change
    public boolean isCompressed(BytesReference bytes) {
    }  
        return new ZstdOutputStreamNoFinalizer(new BufferedOutputStream(out, BUFFER_SIZE), RecyclingBufferPool.INSTANCE, LEVEL);
import com.github.luben.zstd.RecyclingBufferPool;
import com.github.luben.zstd.ZstdInputStreamNoFinalizer;
    }  
import java.io.OutputStream;
     * @throws UnsupportedOperationException if the method is called  
    /**
 * compatible open source license.
            }
        out.write(HEADER);
     * a XContent
    @PublicApi(since = "2.10.0")
 * {@link Compressor} implementation based on the ZSTD compression algorithm.
    public int headerLength() {  
     * It needs to be different from other compressors and to not be specific
    @Override
package org.opensearch.compress;
     * The compression level for {@link ZstdOutputStreamNoFinalizer}
        return new ZstdInputStreamNoFinalizer(new BufferedInputStream(in, BUFFER_SIZE), RecyclingBufferPool.INSTANCE);
    public InputStream threadLocalInputStream(InputStream in) throws IOException {  
    private static final int LEVEL = 3;
    /** The buffer size for {@link BufferedInputStream} and {@link BufferedOutputStream}  
     * @throws IOException if an I/O error occurs  
 */  
    /**
    @Override  
 * SPDX-License-Identifier: Apache-2.0
     */
     *
    }
     * @return always throws an exception
    /**  
            throw new IllegalArgumentException("Input stream is not compressed with ZSTD!");  
import java.io.InputStream;  
import java.io.IOException;
    public OutputStream threadLocalOutputStream(OutputStream out) throws IOException {  
    @Override  
 * The OpenSearch Contributors require contributions made to  
     * @throws IOException is never thrown
import java.util.Arrays;
    @Override
