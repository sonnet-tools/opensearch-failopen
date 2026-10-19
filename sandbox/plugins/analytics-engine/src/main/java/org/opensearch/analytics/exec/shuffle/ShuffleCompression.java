     * Per-query resolved writer policy: whether to compress, which codec, and (for ZSTD) the level.
 * <ul>  
/**  
 * {@link Config} at sink construction ({@link Config#from(ClusterSettings)}):
 * writer edit.  
 * {@code ArrowStreamReader} auto-detects and decompresses with no codec hint. That makes a
     */
     * Shared factory; reused for both write (codec-typed) and read (auto-detect) paths. Delegates to
                return new FastLz4CompressionCodec();
/*  
            String codecName = clusterSettings.get(AnalyticsSettings.MPP_COMPRESSION_CODEC).trim().toLowerCase(Locale.ROOT);  
        }
    public record Config(boolean compress, CompressionUtil.CodecType codec, java.util.Optional<Integer> zstdLevel) {
import org.apache.arrow.vector.compression.CompressionCodec;
 *   <li>{@link AnalyticsSettings#MPP_SHUFFLE_COMPRESS} {@code analytics.mpp.shuffle.compress}
import org.opensearch.common.settings.ClusterSettings;
     * {@code analytics.mpp.compression.zstd.level} settings — then handed to the producer sink. The
 * The OpenSearch Contributors require contributions made to  
     * Arrow's {@link CommonsCompressionFactory} for ZSTD / NO_COMPRESSION but substitutes the  
 *  
 * <ul>  
 *  
    /**  
 * @opensearch.internal  
import org.apache.arrow.compression.CommonsCompressionFactory;
 * footprint is what trips the parent circuit breaker before the per-query shuffle budget forces a
 * bytes — relieving the breaker — for a compress/decompress cost that is cheap relative to the
            CompressionUtil.CodecType codec = ("lz4".equals(codecName) || "lz4_frame".equals(codecName))
}
        }
            if (codecType == CompressionUtil.CodecType.LZ4_FRAME) {
 * serialize → ship → buffer → deserialize round-trip it rides on.
import org.opensearch.analytics.AnalyticsSettings;
 * {@code ShuffleScanHandler}). For a wide fact-table shuffle (TPC-H lineitem) that buffered
 *       fact-table buffers (see {@link FastLz4CompressionCodec});</li>
 *   <li>{@code ZSTD} → Arrow's {@code ZstdCompressionCodec} (zstd-jni, native — fast);</li>
        /** Off — the sink writes plain (uncompressed) IPC. Used by tests / when no cluster settings is handy. */
 *       (default {@code false}) — enable only for memory-constrained clusters that cannot fit even a
 *  
     * {@code analytics.mpp.shuffle.compress} / {@code analytics.mpp.compression.codec} /
 *       ({@code zstd} | {@code lz4}; default {@code zstd}) — which codec when compression is on;</li>
    /**
 *   <li>{@link AnalyticsSettings#MPP_COMPRESSION_CODEC} {@code analytics.mpp.compression.codec}
 *       {@code Lz4CompressionCodec}, whose commons-compress pure-Java matcher hangs on large  
                : java.util.Optional.empty();  
            return CommonsCompressionFactory.INSTANCE.createCodec(codecType);
 *       pruned shuffle on heap and prefer heap headroom over latency;</li>  
 * choice (incl. a peer still on Arrow's commons-compress LZ4).
public final class ShuffleCompression {
 * </ul>  
            if (codecType == CompressionUtil.CodecType.LZ4_FRAME) {  
        /** Resolve the live values from the cluster settings ({@link AnalyticsSettings}). */
 * this file be licensed under the Apache-2.0 license or a
 */  
import java.util.Locale;
 * SPDX-License-Identifier: Apache-2.0
            java.util.Optional<Integer> level = codec == CompressionUtil.CodecType.ZSTD
 * shuffle wire.
package org.opensearch.analytics.exec.shuffle;
        public static final Config DISABLED = new Config(false, CompressionUtil.CodecType.NO_COMPRESSION, java.util.Optional.empty());
                ? java.util.Optional.of(clusterSettings.get(AnalyticsSettings.MPP_COMPRESSION_ZSTD_LEVEL))
                ? CompressionUtil.CodecType.LZ4_FRAME
    };
import org.apache.arrow.vector.compression.CompressionUtil;  
 * <p><b>Codec backends.</b> The shared {@link #FACTORY} returns:
    }  
        public CompressionCodec createCodec(CompressionUtil.CodecType codecType, int compressionLevel) {
     */  
 * mixed-codec (rolling-deploy) cluster decode correctly and makes an algorithm change a one-line
        public static Config from(ClusterSettings clusterSettings) {
 *
 *   <li>{@code NO_COMPRESSION} → Arrow's no-op codec.</li>
                return DISABLED;
                : CompressionUtil.CodecType.ZSTD;  
 * Both produce/consume the standard on-wire formats, so the reader factory decodes any producer's
 * Only the WRITER reads these; the reader always passes the factory and auto-detects, so it decodes  
            return CommonsCompressionFactory.INSTANCE.createCodec(codecType, compressionLevel);  
 * <p>This uses STANDARD Arrow IPC compression: the bundled {@code arrow-vector} already carries the
 * <p>Shuffle ships each producer partition as an Arrow IPC stream blob (the DataFusion backend's
                return new FastLz4CompressionCodec();
            if (!clusterSettings.get(AnalyticsSettings.MPP_SHUFFLE_COMPRESS)) {  
            }
 * spill. Compressing the IPC buffers shrinks BOTH the wire payload AND the heap-resident buffered  
 * any codec/level a producer chose (mixed-setting / rolling-restart safe).
 *
            return new Config(true, codec, level);
 * compatible open source license.
            }
 * the WRITER picks a codec — the codec id rides in each IPC message's metadata, so the  
     * slow commons-compress pure-Java impl — see {@link FastLz4CompressionCodec}).
    public static final CompressionCodec.Factory FACTORY = new CompressionCodec.Factory() {
        @Override
     * Resolved at sink construction from the LIVE cluster settings ({@link ClusterSettings#get}, so a
 *   <li>{@link AnalyticsSettings#MPP_COMPRESSION_ZSTD_LEVEL} {@code analytics.mpp.compression.zstd.level}  
     * reader never needs this — it auto-detects the codec from the IPC metadata via {@link #FACTORY}.  
     * dynamic {@code PUT /_cluster/settings} update is honored) — the values are the  
    private ShuffleCompression() {}
 *       (default {@code 1}, matching Spark's shuffle codec) — ZSTD level only (LZ4 is level-agnostic).</li>
     * fast {@link FastLz4CompressionCodec} for LZ4_FRAME (Arrow's bundled LZ4 is the pathologically
 *   <li>{@code LZ4_FRAME} → {@link FastLz4CompressionCodec} (lz4-java, native) — NOT Arrow's bundled
 * <p>Configured by three {@code NodeScope + Dynamic} cluster settings, resolved per-query into a
 */
 * codec SPI and compression-aware {@code ArrowStreamWriter}/{@code ArrowStreamReader} ctors. Only
 * {@link ShuffleBufferManager} until both sides report {@code isLast}, then drains (the backend's  
        public CompressionCodec createCodec(CompressionUtil.CodecType codecType) {  
        }
 * {@code DatafusionPartitionedSink}); the consumer buffers every chunk on heap in
 * </ul>
 * Hash-shuffle IPC compression policy — the single source of truth for the codec used on the
            }  
 *
        @Override
