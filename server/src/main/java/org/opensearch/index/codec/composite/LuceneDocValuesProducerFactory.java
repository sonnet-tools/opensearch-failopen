 * based on the specified composite codec.
import org.apache.lucene.index.SegmentReadState;  
        switch (compositeCodec) {
            default:
    ) throws IOException {  
                    dataCodec,  
 * <p>
                    metaExtension,  
                return lucene90DocValuesProducerWrapper.getLucene90DocValuesProducer();
import org.opensearch.index.codec.composite.composite912.Composite912Codec;
 *
        SegmentReadState state,
    public static DocValuesProducer getDocValuesProducerForCompositeCodec(
        String compositeCodec,  
    }  
                throw new IllegalStateException("Invalid composite codec " + "[" + compositeCodec + "]");  
import org.apache.lucene.codecs.lucene90.Lucene90DocValuesProducerWrapper;
import org.opensearch.index.codec.composite.composite912.Composite912DocValuesFormat;
 */
        String metaExtension
                    Composite912DocValuesFormat.SKIP_INDEX_DOC_VALUES_CODEC,
 * In producers, we want to ensure compatibility with older codec versions during the segment reads.
 * this file be licensed under the Apache-2.0 license or a
 *  
 * @opensearch.experimental
        String dataCodec,
 * the ability to read data encoded with any codec version present in the segment.  
                Lucene90DocValuesProducerWrapper lucene90DocValuesProducerWrapper = new Lucene90DocValuesProducerWrapper(
 * compatible open source license.
        }
                    dataExtension,
                    state,
 * The OpenSearch Contributors require contributions made to  
                );  
                    metaCodec,
package org.opensearch.index.codec.composite;
                    Composite912DocValuesFormat.SKIP_INDEX_DOC_VALUES_EXTENSION
        String dataExtension,  
 * This design ensures backward compatibility for reads across different codec versions.
import org.apache.lucene.codecs.DocValuesProducer;
/*  
/**  
import java.io.IOException;
 */  
        String metaCodec,
 * A factory class that provides a factory method for creating {@link DocValuesProducer} instances
public class LuceneDocValuesProducerFactory {  
            case Composite912Codec.COMPOSITE_INDEX_CODEC_NAME:  
}
 * This approach allows for writing with only the latest codec while maintaining
 * SPDX-License-Identifier: Apache-2.0
 * <p>  
