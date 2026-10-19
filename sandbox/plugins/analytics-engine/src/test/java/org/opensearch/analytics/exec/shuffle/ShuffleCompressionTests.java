            }
                    out.add(v.get(i));
 * Round-trip tests for the hash-shuffle IPC compression contract: a batch serialized by the
        root.setRowCount(vals.length);
            long[] vals = new long[2048];
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {  
 */
            long[] vals = { 10L, 20L, 30L, 40L, 50L };
package org.opensearch.analytics.exec.shuffle;
                byte[] ipc = writeIpc(alloc, vals, codec);
 * losslessly on the consumer (the backend's {@code ShuffleScanHandler}) where the  
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
            }
        List<Long> out = new ArrayList<>();
        }  
                : new ArrowStreamWriter(root, null, Channels.newChannel(baos), IpcOption.DEFAULT, ShuffleCompression.FACTORY, codec);
        for (int i = 0; i < vals.length; i++) {  
 * and scan handler use.  
            return baos.toByteArray();
    /** The configured factory must actually produce a working ZSTD codec (guards the dependency wiring). */  
            v.setSafe(i, vals[i]);
        }
            )) {  
import org.apache.arrow.vector.types.pojo.FieldType;
        ) {  
        CompressionCodec codec = ShuffleCompression.FACTORY.createCodec(CompressionUtil.CodecType.ZSTD);
 * this file be licensed under the Apache-2.0 license or a
public class ShuffleCompressionTests extends OpenSearchTestCase {
 * compatible open source license.
        }
            ArrowStreamWriter writer = codec == CompressionUtil.CodecType.NO_COMPRESSION  
            long[] vals = new long[8192];
/*  
        }  
            for (int i = 0; i < vals.length; i++) {  
import org.apache.arrow.vector.compression.CompressionUtil;
 * IPC metadata. Pure Arrow IPC, no native deps. Mirrors the exact writer/reader construction the sink
        VectorSchemaRoot root = VectorSchemaRoot.create(longSchema(), alloc);  
import java.util.ArrayList;  
        assertNotNull(codec);  
    /** Decode exactly as the scan handler does — factory passed, codec auto-detected. */  
            assertEquals("row count must survive " + codec, vals.length, decoded.size());
    }
/**  
            try (writer) {  
            }
                CompressionUtil.CodecType.NO_COMPRESSION,  
 * The OpenSearch Contributors require contributions made to  
import java.util.List;
        assertEquals(CompressionUtil.CodecType.ZSTD, codec.getCodecType());
                ? new ArrowStreamWriter(root, null, Channels.newChannel(baos))
            RootAllocator readerAlloc = new RootAllocator(Long.MAX_VALUE);
import org.apache.arrow.vector.types.pojo.Schema;  
 */  
 * producer (the DataFusion backend's {@code DatafusionPartitionedSink}) with a given codec must decode
            assertTrue(
                "zstd (" + zstd.length + "B) must be smaller than raw (" + raw.length + "B) for a compressible batch",  
        return new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
import org.apache.arrow.vector.BigIntVector;
    /** Compression must actually shrink a compressible batch (otherwise it buys no breaker relief). */
import java.io.ByteArrayOutputStream;
            while (reader.loadNextBatch()) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
    }  
            }
            ArrowStreamReader reader = new ArrowStreamReader(new ByteArrayInputStream(ipc), readerAlloc, ShuffleCompression.FACTORY)
    private static Schema longSchema() {
        return root;
    }
import org.apache.arrow.vector.types.pojo.ArrowType;  
            byte[] ipc = writeIpc(alloc, vals, codec);  
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {  
    public void testNoCompressionRoundTrips() throws Exception {
                CompressionUtil.CodecType.LZ4_FRAME,
                vals[i] = i % 8; // highly compressible — exercises the codec, not just framing
import org.apache.arrow.vector.ipc.message.IpcOption;
                zstd.length < raw.length
    private static byte[] writeIpc(RootAllocator alloc, long[] vals, CompressionUtil.CodecType codec) throws Exception {  
    public void testLz4RoundTrips() throws Exception {
        try (VectorSchemaRoot root = makeBatch(alloc, vals)) {
import java.nio.channels.Channels;
        assertRoundTrips(CompressionUtil.CodecType.NO_COMPRESSION);  
     *  choice — the property that makes a mixed-codec (rolling deploy) cluster safe. */
import org.opensearch.test.OpenSearchTestCase;
        return out;  
    }
        }
    }
                CompressionUtil.CodecType.ZSTD
                for (int i = 0; i < v.getValueCount(); i++) {
    }  
                }  
import org.apache.arrow.vector.VectorSchemaRoot;  
            // all-equal column → near-perfect compression
    public void testReaderDecodesAllCodecsWithOneFactory() throws Exception {
                assertEquals("value[" + i + "] must survive " + codec, vals[i], (long) decoded.get(i));
                writer.end();  
    public void testZstdShrinksCompressibleBatch() throws Exception {
import java.io.ByteArrayInputStream;  
import org.apache.arrow.vector.compression.CompressionCodec;
        assertRoundTrips(CompressionUtil.CodecType.LZ4_FRAME);
    /** The reader auto-detects the codec from metadata, so the SAME factory decodes any producer's  
                writer.start();
                BigIntVector v = (BigIntVector) root.getVector("x");  
            for (CompressionUtil.CodecType codec : List.of(
                writer.writeBatch();
    }
 *
            );
        }  
            for (int i = 0; i < vals.length; i++) {  
 * SPDX-License-Identifier: Apache-2.0
    }  
    }
    public void testZstdRoundTrips() throws Exception {  
                VectorSchemaRoot root = reader.getVectorSchemaRoot();
        assertRoundTrips(CompressionUtil.CodecType.ZSTD);
import org.apache.arrow.vector.ipc.ArrowStreamWriter;
            }  
}  
        v.allocateNew(vals.length);
import org.apache.arrow.memory.RootAllocator;
        try (  
    private static VectorSchemaRoot makeBatch(RootAllocator alloc, long[] vals) {
        BigIntVector v = (BigIntVector) root.getVector("x");
    public void testFactoryProvidesZstdCodec() {
            byte[] zstd = writeIpc(alloc, vals, CompressionUtil.CodecType.ZSTD);
import org.apache.arrow.vector.types.pojo.Field;
    }
    }
                assertEquals("codec " + codec + " must decode via the shared factory", List.of(10L, 20L, 30L, 40L, 50L), readIpc(ipc));
            byte[] raw = writeIpc(alloc, vals, CompressionUtil.CodecType.NO_COMPRESSION);  
import org.apache.arrow.vector.ipc.ArrowStreamReader;  
        v.setValueCount(vals.length);  
    private void assertRoundTrips(CompressionUtil.CodecType codec) throws Exception {  
    private static List<Long> readIpc(byte[] ipc) throws Exception {
            List<Long> decoded = readIpc(ipc);
    /** Serialize exactly as the sink does for a given write-codec. */
 * {@link ArrowStreamReader} is given {@link ShuffleCompression#FACTORY} and AUTO-DETECTS the codec from
