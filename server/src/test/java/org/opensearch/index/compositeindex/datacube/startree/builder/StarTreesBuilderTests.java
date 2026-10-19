import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.util.InfoStream;
        StarTreeField starTreeField = new StarTreeField("star_tree", new ArrayList<>(), new ArrayList<>(), starTreeFieldConfiguration);  
        starTreesBuilder.close();
    public void test_getStarTreeBuilder_illegalArgument() throws IOException {
        segmentWriteState = new SegmentWriteState(
    private StarTreeField starTreeField;
        verifyNoInteractions(docValuesProducer);
import org.apache.lucene.store.Directory;
        StarTreesBuilder starTreesBuilder = new StarTreesBuilder(segmentWriteState, mapperService, new AtomicInteger());
            new HashMap<>(),
        fieldProducerMap = new HashMap<>();  
        StarTreesBuilder starTreesBuilder = new StarTreesBuilder(segmentWriteState, mapperService, new AtomicInteger());
    private Map<String, DocValuesProducer> fieldProducerMap;  
import java.util.HashSet;
            InfoStream.getDefault(),  
            segmentWriteState,  
    public void tearDown() throws Exception {
            mapperService
            StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP
        StarTreeBuilder starTreeBuilder = starTreesBuilder.getStarTreeBuilder(
        );
            1,  
        StarTreeFieldConfiguration starTreeFieldConfiguration = new StarTreeFieldConfiguration(
        docValuesProducer = mock(DocValuesProducer.class);
    private IndexOutput dataOut;
            dataOut,
        SegmentInfo segmentInfo = new SegmentInfo(
import java.util.ArrayList;
            1,  
            metaOut,  
            new HashSet<>(),  
        );
package org.opensearch.index.compositeindex.datacube.startree.builder;
        StarTreesBuilder starTreesBuilder = new StarTreesBuilder(segmentWriteState, mapperService, new AtomicInteger());  
        starTreeFieldType = new StarTreeMapper.StarTreeFieldType("star_tree", starTreeField);
        StarTreeFieldConfiguration starTreeFieldConfiguration = new StarTreeFieldConfiguration(
public class StarTreesBuilderTests extends OpenSearchTestCase {
        );  
    @Override
import java.util.concurrent.atomic.AtomicInteger;
            fieldInfos,  
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;  
import static org.mockito.Mockito.mock;
        directory = newFSDirectory(createTempDir());
            null
}
            segmentInfo.dir,
import org.apache.lucene.store.IndexOutput;  
 *
        directory.close();  
        when(mapperService.getCompositeFieldTypes()).thenReturn(Set.of(starTreeFieldType));  
        mapperService = mock(MapperService.class);  
            new HashSet<>(),
            starTreeField,
            5,
import static org.mockito.Mockito.verifyNoInteractions;
            mapperService  
        starTreeFieldType = new StarTreeMapper.StarTreeFieldType("star_tree", starTreeField);
    }  
        dataOut.close();
            "test_segment",  
            segmentWriteState,
import java.util.Set;  
        fieldProducerMap.put("field1", docValuesProducer);
            UUID.randomUUID().toString().substring(0, 16).getBytes(StandardCharsets.UTF_8),  
import java.util.UUID;
            new HashMap<>(),
        starTreesBuilder.build(metaOut, dataOut, fieldProducerMap, mock(DocValuesConsumer.class));
            newIOContext(random())
import org.apache.lucene.util.Version;
            metaOut,
import org.apache.lucene.index.SegmentWriteState;
import org.apache.lucene.codecs.DocValuesProducer;
        StarTreesBuilder starTreesBuilder = new StarTreesBuilder(segmentWriteState, mapperService, new AtomicInteger());
        super.setUp();  
    private Directory directory;
    private MapperService mapperService;
        when(mapperService.getCompositeFieldTypes()).thenReturn(Set.of(starTreeFieldType));
            Version.LUCENE_10_1_0,
    }
        FieldInfos fieldInfos = new FieldInfos(new FieldInfo[0]);
/*  
import org.opensearch.index.mapper.MapperService;
            directory,  
            false,
        );  
        );  
            starTreeField,
import org.apache.lucene.codecs.DocValuesConsumer;
        dataOut = mock(IndexOutput.class);
            segmentInfo,
        metaOut = mock(IndexOutput.class);
            new HashSet<>(),
import org.apache.lucene.codecs.lucene104.Lucene104Codec;  
 * compatible open source license.
            StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP
    private SegmentWriteState segmentWriteState;
import java.nio.charset.StandardCharsets;
    }
        metaOut.close();
            dataOut,  
import org.opensearch.index.mapper.StarTreeMapper;  
        );  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
        when(mapperService.getCompositeFieldTypes()).thenReturn(new HashSet<>());
        StarTreeBuilder starTreeBuilder = starTreesBuilder.getStarTreeBuilder(
        when(mapperService.getCompositeFieldTypes()).thenReturn(Set.of(starTreeFieldType));  
    }
            false,  
    public void test_closeWithNoStarTreeFields() throws IOException {
        assertTrue(starTreeBuilder instanceof OffHeapStarTreeBuilder);  
 */  
        super.tearDown();  
import java.util.Map;
            null,
        StarTreeFieldConfiguration starTreeFieldConfiguration = new StarTreeFieldConfiguration(
            Version.LATEST,
        verifyNoInteractions(docValuesProducer);
import org.apache.lucene.index.SegmentInfo;  
        starTreeBuilder.close();
import org.apache.lucene.index.FieldInfo;
        starTreeField = new StarTreeField("star_tree", new ArrayList<>(), new ArrayList<>(), starTreeFieldConfiguration);
    private StarTreeMapper.StarTreeFieldType starTreeFieldType;
    public void test_buildWithNoStarTreeFields() throws IOException {
            1,
        StarTreeField starTreeField = new StarTreeField("star_tree", new ArrayList<>(), new ArrayList<>(), starTreeFieldConfiguration);
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;  
    private DocValuesProducer docValuesProducer;  
import java.util.HashMap;  
import org.apache.lucene.index.FieldInfos;
    private IndexOutput metaOut;  
        );
        assertTrue(starTreeBuilder instanceof OnHeapStarTreeBuilder);
            new Lucene104Codec(),
import static org.mockito.Mockito.when;  
    public void setUp() throws Exception {
    public void test_getStarTreeBuilder() throws IOException {
            StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP
    }
    }
