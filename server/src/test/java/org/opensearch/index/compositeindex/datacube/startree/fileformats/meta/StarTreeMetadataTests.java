        for (String skipStarNodeCreationInDims : starTreeField.getStarTreeConfig().getSkipStarNodeCreationInDims()) {
        dataFilePointer = randomNonNegativeLong();  
            new HashMap<>(),
import org.apache.lucene.index.VectorSimilarityFunction;
        );
        SegmentInfo segmentInfo = new SegmentInfo(  
        }
import org.opensearch.index.compositeindex.datacube.MetricStat;
        );
            UUID.randomUUID().toString().substring(0, 16).getBytes(StandardCharsets.UTF_8),
    private SegmentWriteState writeState;
import java.util.List;
                0,  
            dataFileLength
import org.opensearch.index.compositeindex.datacube.NumericDimension;
                Collections.emptyMap(),  
            assertEquals(dimension.getDocValuesType(), entry.getValue().getDocValuesType());  
                );  
import java.nio.charset.StandardCharsets;
            StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP
import static org.junit.Assert.assertEquals;
            false,  
            starTreeFieldConfiguration.getSkipStarNodeCreationInDims().size(),
                    NumberFieldMapper.NumberType.DOUBLE
        assertEquals(COMPOSITE_FIELD_MARKER, metaIn.readLong());
        for (int i = 0; i < fieldsInfo.length; i++) {
import org.opensearch.index.mapper.CompositeMappedFieldType;
import org.apache.lucene.index.IndexOptions;  
import java.util.UUID;
            new Lucene104Codec(),
            Version.LATEST,
            new NumericDimension("field3"),  
            metaIn.readString()
            assertTrue(starTreeMetadata.getSkipStarNodeCreationInDims().contains(skipStarNodeCreationInDims));  
        assertEquals(STAR_TREE, starTreeMetadata.getCompositeFieldType());
                0,
            assertEquals(dimension.getField(), entry.getKey());
    private List<Metric> metrics;
        directory = newFSDirectory(createTempDir());
            numStarTreeDocs,  
        assertEquals(starTreeMetadata.getNumberOfNodes(), numberOfNodes);
import org.opensearch.test.OpenSearchTestCase;  
import org.apache.lucene.index.DocValuesSkipIndexType;
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
import org.opensearch.index.mapper.NumberFieldMapper;
                assertEquals(expectedMetric.getMetrics().get(j), resultMetric.getMetrics().get(j));
    public void test_starTreeMetadata() throws IOException {  
}  
                false,
                    starTreeField.getName(),
        assertEquals(maxLeafDocs, starTreeMetadata.getMaxLeafDocs(), 0);  
            dataFilePointer,
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;  
                0,
    }
import static org.opensearch.index.mapper.CompositeMappedFieldType.CompositeFieldType.STAR_TREE;  
    private IndexOutput metaOut;
 */  
        );
            }
                    metric.getField(),  
import org.apache.lucene.store.IOContext;  
import java.util.Collections;  
        segmentDocumentCount = randomInt(Integer.MAX_VALUE);
        writeState = new SegmentWriteState(InfoStream.getDefault(), segmentInfo.dir, segmentInfo, fieldInfos, null, newIOContext(random()));  
                false
        int index = 0;
    private List<Dimension> dimensionsOrder;
            Version.LUCENE_10_1_0,  
import org.apache.lucene.index.SegmentWriteState;
                IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS,
            fieldsInfo[i] = new FieldInfo(
        metaOut.close();
        metaOut.close();
            new NumericDimension("field1"),
            starTreeField,
import java.util.Set;
                false,  
    @Override
import org.apache.lucene.index.FieldInfos;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.lucene.util.InfoStream;  
        StarTreeFieldConfiguration starTreeFieldConfiguration = new StarTreeFieldConfiguration(
                    metricType,
package org.opensearch.index.compositeindex.datacube.startree.fileformats.meta;
import org.apache.lucene.store.Directory;
        );  
        for (int i = 0; i < starTreeField.getMetrics().size(); i++) {
    }
        dimensionsOrder = List.of(
    private List<String> fields = List.of();  
    }
    private StarTreeField starTreeField;
        assertEquals(dataFileLength, starTreeMetadata.getDataLength());  
        // reading and asserting the metadata  
        directory.close();  
            Metric resultMetric = starTreeMetadata.getMetrics().get(i);
        for (Metric metric : metrics) {
            for (int j = 0; j < resultMetric.getMetrics().size(); j++) {
import static org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter.VERSION_CURRENT;
        assertEquals(STAR_TREE.getName(), starTreeMetadata.getStarTreeFieldType());
                VectorEncoding.FLOAT32,
        starTreeWriter.writeStarTreeMetadata(  
        }
        assertEquals(dataFilePointer, starTreeMetadata.getDataStartFilePointer());
    public void setup() throws IOException {  
import org.apache.lucene.store.IndexOutput;
        starTreeField = new StarTreeField("star_tree", dimensionsOrder, metrics, starTreeFieldConfiguration);  
            assertEquals(expectedMetric.getMetrics().size(), resultMetric.getMetrics().size());
        FieldInfos fieldInfos = new FieldInfos(fieldsInfo);
        }  
            maxLeafDocs,
        fields = List.of("field1", "field2", "field3", "field4", "field5", "field6", "field7", "field8", "field9", "field10");
        assertEquals(starTreeFieldConfiguration.getBuildMode(), starTreeMetadata.getStarTreeBuildMode());
        assertEquals(
    private IndexInput metaIn;  
        metrics = List.of(
            );  
        StarTreeMetadata starTreeMetadata = new StarTreeMetadata(metaIn, compositeFieldName, compositeFieldType, VERSION_CURRENT);
    public void tearDown() throws Exception {
import org.opensearch.index.compositeindex.datacube.Dimension;
import java.io.IOException;  
            metaOut,
 * SPDX-License-Identifier: Apache-2.0
        CompositeMappedFieldType.CompositeFieldType compositeFieldType = CompositeMappedFieldType.CompositeFieldType.fromName(  
        assertNotNull(starTreeMetadata);
import org.apache.lucene.index.DocValuesType;  
        fieldsInfo = new FieldInfo[fields.size()];  
        assertEquals(VERSION_CURRENT, metaIn.readVInt());  
        int numberOfNodes = randomInt(Integer.MAX_VALUE);
            }  
        StarTreeWriter starTreeWriter = new StarTreeWriter();
        super.tearDown();  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.compositeindex.datacube.Metric;  
    private int numStarTreeDocs;
            new NumericDimension("field5"),
        );
                fields.get(i),  
        numStarTreeDocs = randomInt(Integer.MAX_VALUE);
        }
                DocValuesType.SORTED_NUMERIC,  
import org.apache.lucene.index.SegmentInfo;
                i,
public class StarTreeMetadataTests extends OpenSearchTestCase {  
        assertEquals(starTreeField.getName(), starTreeMetadata.getCompositeFieldName());  
    private long dataFileLength;  
        }
                metricAggregatorInfos.add(metricAggregatorInfo);
            new Metric("field2", List.of(MetricStat.SUM)),
 *
                MetricAggregatorInfo metricAggregatorInfo = new MetricAggregatorInfo(
            for (MetricStat metricType : metric.getMetrics()) {  
            false,
        assertEquals(dimensionsOrder.size(), starTreeMetadata.getDimensionFields().size());
            assertEquals(dimension.getDimensionDataType(), entry.getValue().getDimensionDataType());
            numberOfNodes,
import org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter;  
import org.junit.Before;
import org.apache.lucene.index.FieldInfo;
import org.opensearch.index.compositeindex.datacube.startree.aggregators.MetricAggregatorInfo;
        String compositeFieldName = metaIn.readString();
import org.apache.lucene.store.IndexInput;
import static org.opensearch.index.compositeindex.CompositeIndexConstants.COMPOSITE_FIELD_MARKER;
    @Before
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
            segmentDocumentCount,
        metaIn.close();
            new Metric("field4", List.of(MetricStat.SUM)),  
        metaIn.close();  
        assertEquals(segmentDocumentCount, starTreeMetadata.getSegmentAggregatedDocCount(), 0);
import org.apache.lucene.index.VectorEncoding;  
                -1,
        assertEquals(starTreeField.getMetrics().size(), starTreeMetadata.getMetrics().size());
import org.apache.lucene.util.Version;
            new NumericDimension("field8")
        );
            Metric expectedMetric = starTreeField.getMetrics().get(i);
    private long dataFilePointer;
                true,
        dataFileLength = randomNonNegativeLong();
        );  
            null  
                DocValuesSkipIndexType.NONE,
    private int segmentDocumentCount;  
            new Metric("field6", List.of(MetricStat.VALUE_COUNT))
            assertEquals(expectedMetric.getField(), resultMetric.getField());
            new HashMap<>(),  
import java.util.Map;  
            "test_segment",
            directory,
                0,
    private Directory directory;  
 * this file be licensed under the Apache-2.0 license or a
            starTreeMetadata.getSkipStarNodeCreationInDims().size()  
        metaIn = directory.openInput("star-tree-metadata", IOContext.READONCE);
            Dimension dimension = dimensionsOrder.get(index++);
        assertEquals(starTreeField.getName(), starTreeMetadata.getStarTreeFieldName());
                VectorSimilarityFunction.EUCLIDEAN,  
 * compatible open source license.
        metaOut = directory.createOutput("star-tree-metadata", IOContext.DEFAULT);  
            6,
/*  
        for (Map.Entry<String, DimensionConfig> entry : starTreeMetadata.getDimensionFields().entrySet()) {  
        assertEquals(starTreeMetadata.getVersion(), VERSION_CURRENT);  
            metricAggregatorInfos,  
        int maxLeafDocs = randomInt(Integer.MAX_VALUE);  
                false,
            Set.of("field10"),  
    private List<MetricAggregatorInfo> metricAggregatorInfos = new ArrayList<>();
    private FieldInfo[] fieldsInfo;
