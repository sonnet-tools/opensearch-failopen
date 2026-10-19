    public Composite103Codec() {  
    @Override
import org.apache.lucene.backward_codecs.lucene103.Lucene103Codec;
@ExperimentalApi  
import org.apache.lucene.codecs.DocValuesFormat;  
import org.apache.lucene.codecs.Codec;
     * this ctor.  
 *  
package org.opensearch.index.codec.composite.backward_codecs.composite103;
     * @param delegate codec delegate  
        super(name, delegate);
     * @param name name of the codec
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.experimental
     *
/*  
 *
 *  Extends the Codec to support new file formats for composite indices eg: star tree index
 */
     * Sole constructor. When subclassing this codec, create a no-arg ctor and pass the delegate codec and a unique name to
    }
import org.opensearch.index.codec.composite.composite912.Composite912DocValuesFormat;  
import org.apache.lucene.codecs.FilterCodec;
 * compatible open source license.
 */  
    }
/**  
    protected Composite103Codec(String name, Codec delegate, MapperService mapperService) {  
    // needed for SPI - this is used in reader path
 * this file be licensed under the Apache-2.0 license or a
        this(COMPOSITE_INDEX_CODEC_NAME, new Lucene103Codec(), null);
     */
import org.opensearch.common.annotation.ExperimentalApi;
    private final MapperService mapperService;  
    public DocValuesFormat docValuesFormat() {  
        return new Composite912DocValuesFormat(mapperService);
    /**
        this.mapperService = mapperService;
import org.opensearch.index.mapper.MapperService;
public class Composite103Codec extends FilterCodec {
}  
 * The OpenSearch Contributors require contributions made to  
     * @param mapperService mapper service instance
 *  based on the mappings.
    }  
    public static final String COMPOSITE_INDEX_CODEC_NAME = "Composite103Codec";
