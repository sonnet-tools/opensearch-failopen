import org.apache.lucene.codecs.lucene104.Lucene104Codec;  
    public static final String COMPOSITE_CODEC = Composite104Codec.COMPOSITE_INDEX_CODEC_NAME;
import org.apache.logging.log4j.Logger;
        return codecs;
import org.opensearch.index.codec.composite.composite104.Composite104Codec;
import static org.opensearch.index.codec.CodecService.ZLIB;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.mapper.MapperService;  
 *
/**
 */
 * Factory class to return the latest composite codec for all the modes
import static org.opensearch.index.codec.CodecService.BEST_COMPRESSION_CODEC;
        codecs.put(DEFAULT_CODEC, new Composite104Codec(Lucene104Codec.Mode.BEST_SPEED, mapperService, logger));
@ExperimentalApi  
import java.util.HashMap;
        codecs.put(LZ4, new Composite104Codec(Lucene104Codec.Mode.BEST_SPEED, mapperService, logger));
import org.apache.lucene.codecs.Codec;
 *  
import org.opensearch.common.annotation.ExperimentalApi;
 */  
    public Map<String, Codec> getCompositeIndexCodecs(MapperService mapperService, Logger logger) {
 * SPDX-License-Identifier: Apache-2.0
public class CompositeCodecFactory {
}
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.index.codec.CodecService.DEFAULT_CODEC;  
import static org.opensearch.index.codec.CodecService.LZ4;
import java.util.Map;  
        codecs.put(ZLIB, new Composite104Codec(Lucene104Codec.Mode.BEST_COMPRESSION, mapperService, logger));
 * compatible open source license.
    public CompositeCodecFactory() {}  
        codecs.put(BEST_COMPRESSION_CODEC, new Composite104Codec(Lucene104Codec.Mode.BEST_COMPRESSION, mapperService, logger));  
    }  
        Map<String, Codec> codecs = new HashMap<>();  
package org.opensearch.index.codec.composite;
/*  
    // we can use this to track the latest composite codec  
 * @opensearch.experimental
