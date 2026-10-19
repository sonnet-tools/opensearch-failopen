 *
    private final MapperService mapperService;
        return new Composite912DocValuesFormat(mapperService);
     *
 * The OpenSearch Contributors require contributions made to  
     * @param mapperService mapper service instance
        this(COMPOSITE_INDEX_CODEC_NAME, new PerFieldMappingPostingFormatCodec(compressionMode, mapperService, logger), mapperService);
    public Composite104Codec() {
    protected Composite104Codec(String name, Codec delegate, MapperService mapperService) {  
     */
/*  
 *
/**
import org.opensearch.index.mapper.MapperService;  
    }
    public DocValuesFormat docValuesFormat() {  
    @Override
     * Sole constructor. When subclassing this codec, create a no-arg ctor and pass the delegate codec and a unique name to
package org.opensearch.index.codec.composite.composite104;
     * @param delegate codec delegate  
 */  
import org.apache.lucene.codecs.FilterCodec;
    }
import org.apache.lucene.codecs.DocValuesFormat;  
    }  
 */
     * this ctor.  
import org.apache.lucene.codecs.Codec;
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
 * compatible open source license.
 * @opensearch.experimental  
public class Composite104Codec extends FilterCodec {  
     * @param name name of the codec
}  
        this.mapperService = mapperService;
import org.opensearch.index.codec.composite.composite912.Composite912DocValuesFormat;
import org.apache.logging.log4j.Logger;
    public static final String COMPOSITE_INDEX_CODEC_NAME = "Composite104Codec";
    public Composite104Codec(Lucene104Codec.Mode compressionMode, MapperService mapperService, Logger logger) {  
import org.opensearch.index.codec.PerFieldMappingPostingFormatCodec;
 *  based on the mappings.
    // needed for SPI - this is used in reader path
        super(name, delegate);
@ExperimentalApi
    }
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
    /**
import org.opensearch.common.annotation.ExperimentalApi;  
        this(COMPOSITE_INDEX_CODEC_NAME, new Lucene104Codec(), null);  
 *  Extends the Codec to support new file formats for composite indices eg: star tree index  
