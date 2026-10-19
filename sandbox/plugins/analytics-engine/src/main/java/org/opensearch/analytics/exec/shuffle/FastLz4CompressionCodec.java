    protected ArrowBuf doCompress(BufferAllocator allocator, ArrowBuf uncompressedBuffer) {
import org.apache.arrow.vector.compression.AbstractCompressionCodec;  
 * the raw byte transform, mirroring Arrow's {@code Lz4CompressionCodec.doCompress/doDecompress}  
        // the parent overwrite the frame's first 8 bytes → a corrupt frame the reader can't decode.
                baos.write(chunk, 0, n);
 * it. We only swap the IMPLEMENTATION, not the format.
 * <p>Extends {@link AbstractCompressionCodec} so the shared length-prefix framing and the
        byte[] inBytes = new byte[(int) payloadLen];  
 * {@code 0x184D2204}), so the codec id Arrow stamps in the IPC metadata stays {@code LZ4_FRAME} and  
    protected ArrowBuf doDecompress(BufferAllocator allocator, ArrowBuf compressedBuffer) {  
 * "incompressible buffer is stored uncompressed" fallback are inherited; this class implements only
        ByteArrayOutputStream baos = new ByteArrayOutputStream(inBytes.length * 2);  
 *
import net.jpountz.lz4.LZ4FrameOutputStream;
 * hard-wires commons-compress's {@code FramedLZ4CompressorOutputStream} — a PURE-JAVA block matcher  
        compressedBuffer.getBytes(CompressionUtil.SIZE_OF_UNCOMPRESSED_LENGTH, inBytes);
    @Override
 */
        decompressed.setBytes(0, outBytes);
 * SPDX-License-Identifier: Apache-2.0
        ArrowBuf decompressed = allocator.buffer(outBytes.length);  
final class FastLz4CompressionCodec extends AbstractCompressionCodec {
}
 * whose back-reference bookkeeping ({@code LZ77Compressor} + a {@code LinkedList} of match pairs in
        } catch (java.io.IOException e) {
        // are mostly far smaller than 64 KB so the ratio is unaffected.
            throw new RuntimeException("FastLz4CompressionCodec: LZ4 compress failed", e);  
/*  
 * @opensearch.internal  
 * pure-Java fallback) instead of Arrow's bundled {@code Lz4CompressionCodec}.  
        // Contract (mirrors Arrow's Lz4CompressionCodec.doCompress): RESERVE the leading
        // Arrays.fill-zeroes a ~2×blockSize working buffer EVERY call — so the default makes q7 spend
        compressed.setBytes(CompressionUtil.SIZE_OF_UNCOMPRESSED_LENGTH, outBytes);  
        // at offset SIZE_OF_UNCOMPRESSED_LENGTH and runs to writerIndex(). Reading from offset 0 would  
        byte[] outBytes = baos.toByteArray();
 * shape ({@code getBytes → stream copy → setBytes}).
    }  
import org.apache.arrow.vector.compression.CompressionUtil;
        // as a multi-minute hang at low heap). SIZE_64KB caps that per-call allocation; Arrow buffers  
package org.opensearch.analytics.exec.shuffle;
        byte[] outBytes = baos.toByteArray();
 * not. {@code lz4-java} restores the conventional "LZ4 is the cheap shuffle codec" property.  
        long payloadLen = compressedBuffer.writerIndex() - CompressionUtil.SIZE_OF_UNCOMPRESSED_LENGTH;
        // LZ4FrameOutputStream's default block size is SIZE_4MB, and its constructor allocates AND  
        // this once per validity / offset / data buffer — thousands per batch on a wide fact table).
 * {@code lz4-java} ({@link LZ4FrameOutputStream}/{@link LZ4FrameInputStream}, JNI-native with a
        // CRITICAL: Arrow compresses EACH Arrow buffer separately (VectorUnloader.appendNodes calls
 *
 * pinned in {@code LZ77Compressor.compress} and the query never finishing (150s+ client timeout, low
        byte[] inBytes = new byte[inLen];
 * heap — pure CPU starvation). zstd-jni avoids this because it is native; commons-compress LZ4 does
    }
        compressed.writerIndex(CompressionUtil.SIZE_OF_UNCOMPRESSED_LENGTH + outBytes.length);
            }  
        try (LZ4FrameOutputStream out = new LZ4FrameOutputStream(baos, LZ4FrameOutputStream.BLOCKSIZE.SIZE_64KB)) {  
        }
    @Override
        uncompressedBuffer.getBytes(0, inBytes);
/**  
import java.io.ByteArrayInputStream;  
    }  
        ArrowBuf compressed = allocator.buffer(outBytes.length + CompressionUtil.SIZE_OF_UNCOMPRESSED_LENGTH);
            int n;  
 * this file be licensed under the Apache-2.0 license or a
        }  
 * <p>The on-wire bytes are the STANDARD LZ4 frame format (RFC-style frame with magic
        // feed the length prefix bytes to the LZ4 decoder → "LZ4 decompress failed".
        } catch (java.io.IOException e) {
 */  
import java.io.ByteArrayOutputStream;
            throw new RuntimeException("FastLz4CompressionCodec: LZ4 decompress failed", e);
 *
        // already consumed the 8-byte uncompressed-length prefix; the actual LZ4-frame payload starts
    @Override  
        byte[] chunk = new byte[8192];
 * buffers a fact-table shuffle produces (TPC-H lineitem): observed as every worker search thread  
 *  
        ByteArrayOutputStream baos = new ByteArrayOutputStream(Math.max(64, inLen / 2));
        return CompressionUtil.CodecType.LZ4_FRAME;
import net.jpountz.lz4.LZ4FrameInputStream;  
import org.apache.arrow.memory.BufferAllocator;
        // Contract (mirrors Arrow's Lz4CompressionCodec.doDecompress): the parent decompress() has
        // there afterward via writeUncompressedLength. Writing the payload at offset 0 instead would let  
 * {@code BlockLZ4CompressorOutputStream.clearUnusedPairs}) degrades pathologically on the large
 * <p><b>Why this exists.</b> Arrow's own {@code org.apache.arrow.compression.Lz4CompressionCodec}
        // all its time in LZ4FrameOutputStream.<init>/writeBlock zeroing 4 MB per tiny buffer (observed
        try (LZ4FrameInputStream in = new LZ4FrameInputStream(new ByteArrayInputStream(inBytes))) {
        decompressed.writerIndex(outBytes.length);
 *
        return decompressed;  
 * compatible open source license.
        return compressed;
            out.write(inBytes);
        // SIZE_OF_UNCOMPRESSED_LENGTH (8) bytes — the parent compress() writes the uncompressed length
 * any standards-compliant reader — including Arrow's own commons-compress decoder — can still read
 * A fast {@code LZ4_FRAME} {@link org.apache.arrow.vector.compression.CompressionCodec} backed by
    public CompressionUtil.CodecType getCodecType() {
import org.apache.arrow.memory.ArrowBuf;
 * The OpenSearch Contributors require contributions made to  
            while ((n = in.read(chunk)) != -1) {
        int inLen = (int) uncompressedBuffer.writerIndex();  
