        this(COMPOSITE_INDEX_CODEC_NAME, new Lucene912Codec(), null);  
 * this file be licensed under the Apache-2.0 license or a
 *  based on the mappings.
 * SPDX-License-Identifier: Apache-2.0
     * this ctor.
import org.opensearch.common.annotation.ExperimentalApi;
 *
import org.apache.lucene.codecs.DocValuesFormat;  
        return new Composite912DocValuesFormat(mapperService);  
@ExperimentalApi
package org.opensearch.index.codec.composite.composite912;
/**
 *
import org.opensearch.index.mapper.MapperService;  
     * Sole constructor. When subclassing this codec, create a no-arg ctor and pass the delegate codec and a unique name to
 */
        super(name, delegate);  
}
     * @param mapperService mapper service instance  
import org.apache.lucene.codecs.FilterCodec;
import org.apache.lucene.codecs.Codec;
    protected Composite912Codec(String name, Codec delegate, MapperService mapperService) {
    private final MapperService mapperService;
    }
    public DocValuesFormat docValuesFormat() {
    public static final String COMPOSITE_INDEX_CODEC_NAME = "Composite912Codec";
import org.apache.lucene.backward_codecs.lucene912.Lucene912Codec;
 * compatible open source license.
     * @param name name of the codec
 * The OpenSearch Contributors require contributions made to  
 *  Extends the Codec to support new file formats for composite indices eg: star tree index  
public class Composite912Codec extends FilterCodec {  
    }
    }
     */
/*  
    // needed for SPI - this is used in reader path
     *  
     * @param delegate codec delegate
 * @opensearch.experimental  
 */  
    public Composite912Codec() {
    /**  
    @Override
        this.mapperService = mapperService;
