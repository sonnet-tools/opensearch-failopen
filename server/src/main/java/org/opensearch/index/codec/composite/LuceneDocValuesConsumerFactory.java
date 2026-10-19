            dataExtension,
    public static DocValuesConsumer getDocValuesConsumerForCompositeCodec(  
    ) throws IOException {  
public class LuceneDocValuesConsumerFactory {
}  
    }
 * The OpenSearch Contributors require contributions made to  
 * <p>
import org.apache.lucene.codecs.DocValuesConsumer;
        SegmentWriteState state,  
            state,
            metaExtension
            state,
/*  
            metaCodec,  
            dataCodec,
 *
 * <p>
 * This design ensures forward compatibility for writing operations  
            Composite912DocValuesFormat.SKIP_INDEX_DOC_VALUES_EXTENSION  
        String metaExtension
    }  
        String dataCodec,
        String metaCodec,
            4096,  
            metaCodec,  
        String dataExtension,  
import org.apache.lucene.codecs.lucene90.Lucene90DocValuesConsumerWrapper;
 * A factory class that provides a factory method for creating {@link DocValuesConsumer} instances  
/**
    public static DocValuesConsumer getDocValuesConsumerForCompositeCodec(
        int skipIndexIntervalSize,
            metaExtension,
        String metaCodec,
        String metaExtension
 * for the latest composite codec.
package org.opensearch.index.codec.composite;
 * SPDX-License-Identifier: Apache-2.0
 */  
            Composite912DocValuesFormat.SKIP_INDEX_DOC_VALUES_CODEC,
        Lucene90DocValuesConsumerWrapper lucene90DocValuesConsumerWrapper = new Lucene90DocValuesConsumerWrapper(
        String dataCodec,
import org.opensearch.index.codec.composite.composite912.Composite912DocValuesFormat;
 * The segments are written using the latest composite codec. The codec  
        );
            /* Lucene90DocValuesFormat#DEFAULT_SKIP_INDEX_INTERVAL_SIZE */ dataCodec,
import org.apache.lucene.index.SegmentWriteState;  
            skipIndexIntervalSize,  
        SegmentWriteState state,
 * this file be licensed under the Apache-2.0 license or a
 * internally manages calling the appropriate consumer factory for its abstractions.
 * compatible open source license.
import java.io.IOException;  
        return lucene90DocValuesConsumerWrapper.getLucene90DocValuesConsumer();
        return getDocValuesConsumerForCompositeCodec(
            dataExtension,
        String dataExtension,  
        );
    ) throws IOException {  
 */  
 *
 * @opensearch.experimental
