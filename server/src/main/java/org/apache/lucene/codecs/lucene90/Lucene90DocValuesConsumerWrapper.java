            skipIndexCodec,
        String metaExtension,  
        lucene90DocValuesConsumer.close();
public class Lucene90DocValuesConsumerWrapper implements Closeable {
    }  
 * this file be licensed under the Apache-2.0 license or a
            metaCodec,  
 */  
        String dataCodec,  
import org.apache.lucene.codecs.DocValuesConsumer;
 *
            skipIndexExtension  
}  
    ) throws IOException {  
        String dataExtension,
 * This class is an abstraction of the {@link DocValuesConsumer} for the Star Tree index structure.
/**
 *
    @Override
        String skipIndexExtension
        SegmentWriteState state,
    }
            skipIndexIntervalSize,  
    public void close() throws IOException {  
 * It is responsible to consume various types of document values (numeric, binary, sorted, sorted numeric,  
import java.io.Closeable;
 * SPDX-License-Identifier: Apache-2.0
 */
            state,
            dataCodec,
            dataExtension,
 * and sorted set) for fields in the Star Tree index.
/*  
package org.apache.lucene.codecs.lucene90;
 * The OpenSearch Contributors require contributions made to  
        );
    }
        String metaCodec,
    private final Lucene90DocValuesConsumer lucene90DocValuesConsumer;
import org.apache.lucene.index.SegmentWriteState;
        String skipIndexCodec,
 * compatible open source license.
 * @opensearch.experimental  
import java.io.IOException;
        int skipIndexIntervalSize,
    public Lucene90DocValuesConsumerWrapper(  
            metaExtension,
    public Lucene90DocValuesConsumer getLucene90DocValuesConsumer() {
        lucene90DocValuesConsumer = new Lucene90DocValuesConsumer(
        return lucene90DocValuesConsumer;
