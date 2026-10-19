        SegmentReadState state,
    @Override  
    }  
        String skipIndexExtension
    ) throws IOException {
        return lucene90DocValuesProducer;  
 * This class is a custom abstraction of the {@link DocValuesProducer} for the Star Tree index structure.
    public DocValuesProducer getLucene90DocValuesProducer() {
    }
    public Lucene90DocValuesProducerWrapper(  
 * this file be licensed under the Apache-2.0 license or a
import java.io.Closeable;
        String dataExtension,  
 *
            metaExtension,
        String metaCodec,
 */
 */  
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.index.SegmentReadState;
package org.apache.lucene.codecs.lucene90;
 * SPDX-License-Identifier: Apache-2.0
/**
        String dataCodec,
            metaCodec,
    public void close() throws IOException {
public class Lucene90DocValuesProducerWrapper implements Closeable {
/*  
        String metaExtension,
 * compatible open source license.
            skipIndexExtension
            skipIndexCodec,  
            state,
}
 * It is responsible for providing access to various types of document values (numeric, binary, sorted, sorted numeric,  
import java.io.IOException;
 *
            dataCodec,
        );
        String skipIndexCodec,  
 * and sorted set) for fields in the Star Tree index.
 * @opensearch.experimental  
        lucene90DocValuesProducer = new Lucene90DocValuesProducer(  
    private final Lucene90DocValuesProducer lucene90DocValuesProducer;
            dataExtension,  
import org.apache.lucene.codecs.DocValuesProducer;
        lucene90DocValuesProducer.close();
    }  
