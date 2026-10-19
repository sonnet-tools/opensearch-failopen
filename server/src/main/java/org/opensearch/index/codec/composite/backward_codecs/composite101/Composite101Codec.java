    // needed for SPI - this is used in reader path
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 */
 *  based on the mappings.
        return new Composite912DocValuesFormat(mapperService);
import org.opensearch.index.mapper.MapperService;
 *
    @Override
 */  
    public Composite101Codec() {  
 *  Extends the Codec to support new file formats for composite indices eg: star tree index
    /**
import org.opensearch.index.codec.composite.composite912.Composite912DocValuesFormat;  
    public DocValuesFormat docValuesFormat() {  
     * @param name name of the codec
     * @param delegate codec delegate  
    public static final String COMPOSITE_INDEX_CODEC_NAME = "Composite101Codec";
import org.apache.lucene.backward_codecs.lucene101.Lucene101Codec;
 * The OpenSearch Contributors require contributions made to  
    protected Composite101Codec(String name, Codec delegate, MapperService mapperService) {  
}  
     * Sole constructor. When subclassing this codec, create a no-arg ctor and pass the delegate codec and a unique name to
import org.apache.lucene.codecs.DocValuesFormat;  
 *  
     */
    }
    }
     *
/**  
import org.opensearch.common.annotation.ExperimentalApi;
 * @opensearch.experimental
/*  
    }  
        this.mapperService = mapperService;
        this(COMPOSITE_INDEX_CODEC_NAME, new Lucene101Codec(), null);
     * @param mapperService mapper service instance
package org.opensearch.index.codec.composite.backward_codecs.composite101;
@ExperimentalApi  
 * compatible open source license.
        super(name, delegate);
    private final MapperService mapperService;  
import org.apache.lucene.codecs.FilterCodec;
public class Composite101Codec extends FilterCodec {
import org.apache.lucene.codecs.Codec;
     * this ctor.  
