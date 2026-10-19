            false,
        SegmentWriteState state = new SegmentWriteState(  
            InfoStream.getDefault(),
            new Lucene104Codec(),  
import org.apache.lucene.index.SegmentInfo;
        );
 *
import org.apache.lucene.index.FieldInfos;
            newIOContext(random())  
    public void testGetDocValuesConsumerForCompositeCodec() throws IOException {  
            segmentInfo,  
    public void teardown() throws Exception {
 */  
        SegmentInfo segmentInfo = new SegmentInfo(
            segmentInfo.dir,
        assertEquals("org.apache.lucene.codecs.lucene90.Lucene90DocValuesConsumer", consumer.getClass().getName());
        directory = newDirectory();  
public class LuceneDocValuesConsumerFactoryTests extends OpenSearchTestCase {
 * compatible open source license.
            UUID.randomUUID().toString().substring(0, 16).getBytes(StandardCharsets.UTF_8),
            metaExtension
import org.opensearch.test.OpenSearchTestCase;
import java.io.IOException;  
            new HashMap<>(),  
    }
            new FieldInfos(new FieldInfo[0]),
    private final String dataExtension = "data_extension";  
import java.util.HashMap;
            dataExtension,  
        super.tearDown();  
    private Directory directory;
import java.util.UUID;  
            null
package org.opensearch.index.codec.composite;
import org.apache.lucene.index.SegmentWriteState;  
import org.apache.lucene.util.Version;  
        );
        directory.close();
/*  
            false,
    @After
    private final String metaExtension = "meta_extension";
    }
import org.junit.After;  
import org.apache.lucene.util.InfoStream;
            Version.LATEST,  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.codec.composite.composite104.Composite104Codec;
import java.nio.charset.StandardCharsets;
            directory,
}  
        );  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.codecs.DocValuesConsumer;
    private final String metaCodec = "meta_codec";
        assertEquals(CompositeCodecFactory.COMPOSITE_CODEC, Composite104Codec.COMPOSITE_INDEX_CODEC_NAME);  
import org.apache.lucene.store.Directory;
    private final String dataCodec = "data_codec";
    }
            new HashMap<>(),
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.index.FieldInfo;  
            metaCodec,
            "test_segment",
import org.junit.Before;
            randomInt(),  
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
    public void setup() {
            dataCodec,
            null,
    @Before
        DocValuesConsumer consumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(  
            state,
        consumer.close();
            Version.LUCENE_10_1_0,
