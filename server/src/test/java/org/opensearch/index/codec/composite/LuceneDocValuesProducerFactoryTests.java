                mockSegmentReadState,
        });
    private final String dataExtension = "data_extension";
        consumer.close();  
            InfoStream.getDefault(),
 *
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> {
    }
            newIOContext(random())  
            false,
/*  
            randomInt(),
    @Before
                dataCodec,
            segmentReadState,
            new Lucene104Codec(),
            segmentInfo,  
            LuceneDocValuesProducerFactory.getDocValuesProducerForCompositeCodec(
        assertNotNull(exception);  
            segmentInfo.dir,  
    @After
 * this file be licensed under the Apache-2.0 license or a
            Version.LUCENE_10_1_0,
    private final String metaExtension = "meta_extension";  
            UUID.randomUUID().toString().substring(0, 16).getBytes(StandardCharsets.UTF_8),  
            state,  
    }
    public void testGetDocValuesProducerForCompositeCodec99() throws IOException {
            Version.LATEST,
        assertNotNull(producer);
    private final String dataCodec = "data_codec";  
        producer.close();
            metaExtension
                metaCodec,
        SegmentReadState mockSegmentReadState = mock(SegmentReadState.class);
            Composite912Codec.COMPOSITE_INDEX_CODEC_NAME,  
            metaCodec,  
        directory.close();
            new FieldInfos(new FieldInfo[0]),
import org.apache.lucene.codecs.lucene104.Lucene104Codec;  
import java.util.HashMap;
import org.apache.lucene.index.SegmentInfo;  
            new FieldInfos(new FieldInfo[0]),
            false,  
        );  
            newIOContext(random())  
        super.tearDown();  
            "test_segment",  
}  
            );  
    public void testGetDocValuesProducerForCompositeCodec_InvalidCodec() {
        );  
 */  
            dataCodec,
            new HashMap<>(),
                "invalid_codec",  
        DocValuesProducer producer = LuceneDocValuesProducerFactory.getDocValuesProducerForCompositeCodec(
        DocValuesConsumer consumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
import org.junit.Before;  
    public void setup() {  
import java.io.IOException;
import org.junit.After;
            dataExtension,
        SegmentInfo segmentInfo = new SegmentInfo(
            dataCodec,
import org.apache.lucene.util.Version;
    private final String metaCodec = "meta_codec";
            dataExtension,  
import org.apache.lucene.index.SegmentReadState;
 * The OpenSearch Contributors require contributions made to  
import static org.mockito.Mockito.mock;
            metaCodec,
            segmentInfo,
public class LuceneDocValuesProducerFactoryTests extends OpenSearchTestCase {  
 * compatible open source license.
            null
import org.opensearch.test.OpenSearchTestCase;
import org.apache.lucene.store.Directory;  
        );
import org.apache.lucene.util.InfoStream;
                metaExtension
import org.apache.lucene.index.FieldInfos;
        assertTrue(exception.getMessage().contains("Invalid composite codec"));
import org.apache.lucene.index.FieldInfo;
        );
    }
                dataExtension,  
            directory,  
            segmentInfo.dir,
    private Directory directory;
        SegmentWriteState state = new SegmentWriteState(  
import java.nio.charset.StandardCharsets;  
        directory = newDirectory();
    }
        assertEquals("org.apache.lucene.codecs.lucene90.Lucene90DocValuesProducer", producer.getClass().getName());  
import org.opensearch.index.codec.composite.composite912.Composite912Codec;  
            metaExtension
            null,
import org.apache.lucene.codecs.DocValuesProducer;
        );
        SegmentReadState segmentReadState = new SegmentReadState(
        // open an consumer first in order for the producer to find the file
    public void teardown() throws Exception {
import java.util.UUID;
import org.apache.lucene.index.SegmentWriteState;
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.codecs.DocValuesConsumer;
package org.opensearch.index.codec.composite;
            new HashMap<>(),
