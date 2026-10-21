import static org.opensearch.index.mapper.CompositeMappedFieldType.CompositeFieldType.STAR_TREE;
            dataFilePointer,
        );
        assertEquals(starTreeMetadata.getVersion(), VERSION_CURRENT);
        assertEquals(starTreeFieldConfiguration.getBuildMode(), starTreeMetadata.getStarTreeBuildMode());
        for (int i = 0; i < fieldsInfo.length; i++) {
    private FieldInfo[] fieldsInfo;
        metaIn.close();
            "test_segment",
                i,
                true,
        directory.close();
        assertEquals(starTreeField.getMetrics().size(), starTreeMetadata.getMetrics().size());
import org.opensearch.test.OpenSearchTestCase;
                false,
        int index = 0;
        );
            }
        }
import org.apache.lucene.store.IndexOutput;
        assertEquals(maxLeafDocs, starTreeMetadata.getMaxLeafDocs(), 0);
            new NumericDimension("field8")
        metaIn = directory.openInput("star-tree-metadata", IOContext.READONCE);
}
            new HashMap<>(),
                0,
import org.apache.lucene.index.IndexOptions;
        assertEquals(dimensionsOrder.size(), starTreeMetadata.getDimensionFields().size());
        assertEquals(VERSION_CURRENT, metaIn.readVInt());
        numStarTreeDocs = randomInt(Integer.MAX_VALUE);
            assertEquals(dimension.getField(), entry.getKey());
            assertEquals(dimension.getDocValuesType(), entry.getValue().getDocValuesType());
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
                0,
    @Override
        starTreeField = new StarTreeField("star_tree", dimensionsOrder, metrics, starTreeFieldConfiguration);
            assertEquals(expectedMetric.getField(), resultMetric.getField());
        dataFileLength = randomNonNegativeLong();
                DocValuesType.SORTED_NUMERIC,
    private IndexOutput metaOut;
            numberOfNodes,
        }
        assertEquals(starTreeField.getName(), starTreeMetadata.getCompositeFieldName());
        StarTreeFieldConfiguration starTreeFieldConfiguration = new StarTreeFieldConfiguration(
public class StarTreeMetadataTests extends OpenSearchTestCase {
        int numberOfNodes = randomInt(Integer.MAX_VALUE);
        for (Metric metric : metrics) {
        for (Map.Entry<String, DimensionConfig> entry : starTreeMetadata.getDimensionFields().entrySet()) {
    private List<Dimension> dimensionsOrder;
                0,
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
import java.util.Collections;
import org.apache.lucene.index.SegmentWriteState;
            );
            new Lucene104Codec(),
            assertEquals(dimension.getDimensionDataType(), entry.getValue().getDimensionDataType());
    private int numStarTreeDocs;
                );
    private long dataFilePointer;
                Collections.emptyMap(),
    private Directory directory;
    @Before
import java.util.UUID;
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
        }
                0,
        starTreeWriter.writeStarTreeMetadata(
                    starTreeField.getName(),
            for (int j = 0; j < resultMetric.getMetrics().size(); j++) {
 * compatible open source license.
import org.opensearch.index.compositeindex.datacube.Dimension;
                -1,
import org.apache.lucene.index.FieldInfos;
        directory = newFSDirectory(createTempDir());
import org.apache.lucene.index.VectorSimilarityFunction;
            directory,
        for (int i = 0; i < starTreeField.getMetrics().size(); i++) {
import org.apache.lucene.store.Directory;
        String compositeFieldName = metaIn.readString();
                false,
                assertEquals(expectedMetric.getMetrics().get(j), resultMetric.getMetrics().get(j));
/*
                metricAggregatorInfos.add(metricAggregatorInfo);
            Set.of("field10"),
            false,
        metaOut.close();
            StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP
        );
        metaOut.close();
        assertEquals(starTreeField.getName(), starTreeMetadata.getStarTreeFieldName());
                VectorEncoding.FLOAT32,
    private StarTreeField starTreeField;
import static org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter.VERSION_CURRENT;
 * SPDX-License-Identifier: Apache-2.0
    private SegmentWriteState writeState;
            Version.LATEST,
    private long dataFileLength;
        }
import java.util.List;
        fields = List.of("field1", "field2", "field3", "field4", "field5", "field6", "field7", "field8", "field9", "field10");
        metaOut = directory.createOutput("star-tree-metadata", IOContext.DEFAULT);
import org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter;
            Version.LUCENE_10_1_0,
            UUID.randomUUID().toString().substring(0, 16).getBytes(StandardCharsets.UTF_8),
    public void setup() throws IOException {
import org.opensearch.index.compositeindex.datacube.Metric;
import org.apache.lucene.index.SegmentInfo;
import java.nio.charset.StandardCharsets;
            new HashMap<>(),
import org.apache.lucene.util.Version;
        FieldInfos fieldInfos = new FieldInfos(fieldsInfo);
import java.util.Map;
import org.apache.lucene.index.VectorEncoding;
import static org.junit.Assert.assertEquals;
            new Metric("field2", List.of(MetricStat.SUM)),
            fieldsInfo[i] = new FieldInfo(
        }
    public void tearDown() throws Exception {
import java.util.Set;
            Metric expectedMetric = starTreeField.getMetrics().get(i);
import org.apache.lucene.index.DocValuesSkipIndexType;
 *
            for (MetricStat metricType : metric.getMetrics()) {
import org.apache.lucene.util.InfoStream;
    private List<String> fields = List.of();
        int maxLeafDocs = randomInt(Integer.MAX_VALUE);
    private int segmentDocumentCount;
            starTreeField,
            assertEquals(expectedMetric.getMetrics().size(), resultMetric.getMetrics().size());
import org.opensearch.index.mapper.NumberFieldMapper;
            new Metric("field6", List.of(MetricStat.VALUE_COUNT))
import org.opensearch.index.compositeindex.datacube.MetricStat;
                IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS,
            metaOut,
                    metric.getField(),
            Dimension dimension = dimensionsOrder.get(index++);
            numStarTreeDocs,
        writeState = new SegmentWriteState(InfoStream.getDefault(), segmentInfo.dir, segmentInfo, fieldInfos, null, newIOContext(random()));
    private IndexInput metaIn;
            metaIn.readString()
package org.opensearch.index.compositeindex.datacube.startree.fileformats.meta;
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.store.IndexInput;
        assertEquals(STAR_TREE, starTreeMetadata.getCompositeFieldType());
                MetricAggregatorInfo metricAggregatorInfo = new MetricAggregatorInfo(
import java.util.HashMap;
import org.apache.lucene.index.DocValuesType;
        for (String skipStarNodeCreationInDims : starTreeField.getStarTreeConfig().getSkipStarNodeCreationInDims()) {
        assertEquals(STAR_TREE.getName(), starTreeMetadata.getStarTreeFieldType());
        );
        assertEquals(
        );
        );
import org.apache.lucene.index.FieldInfo;
                false,
            metricAggregatorInfos,
import org.apache.lucene.store.IOContext;
            segmentDocumentCount,
            dataFileLength
    private List<MetricAggregatorInfo> metricAggregatorInfos = new ArrayList<>();
            false,
import org.opensearch.index.mapper.CompositeMappedFieldType;
        StarTreeMetadata starTreeMetadata = new StarTreeMetadata(metaIn, compositeFieldName, compositeFieldType, VERSION_CURRENT);
            starTreeMetadata.getSkipStarNodeCreationInDims().size()
import java.util.ArrayList;
        metaIn.close();
        CompositeMappedFieldType.CompositeFieldType compositeFieldType = CompositeMappedFieldType.CompositeFieldType.fromName(
import org.opensearch.index.compositeindex.datacube.NumericDimension;
import org.junit.Before;
    }
            }
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
        dimensionsOrder = List.of(
        fieldsInfo = new FieldInfo[fields.size()];
                VectorSimilarityFunction.EUCLIDEAN,
            assertTrue(starTreeMetadata.getSkipStarNodeCreationInDims().contains(skipStarNodeCreationInDims));
            new Metric("field4", List.of(MetricStat.SUM)),
        assertEquals(dataFileLength, starTreeMetadata.getDataLength());
        dataFilePointer = randomNonNegativeLong();
        assertNotNull(starTreeMetadata);
                DocValuesSkipIndexType.NONE,
        metrics = List.of(
 */
        assertEquals(segmentDocumentCount, starTreeMetadata.getSegmentAggregatedDocCount(), 0);
                false
            new NumericDimension("field3"),
        assertEquals(starTreeMetadata.getNumberOfNodes(), numberOfNodes);
        // reading and asserting the metadata
        SegmentInfo segmentInfo = new SegmentInfo(
            null
        assertEquals(COMPOSITE_FIELD_MARKER, metaIn.readLong());
            new NumericDimension("field5"),
                fields.get(i),
        StarTreeWriter starTreeWriter = new StarTreeWriter();
            maxLeafDocs,
    public void test_starTreeMetadata() throws IOException {
            Metric resultMetric = starTreeMetadata.getMetrics().get(i);
        super.tearDown();
                    NumberFieldMapper.NumberType.DOUBLE
            new NumericDimension("field1"),
    private List<Metric> metrics;
    }
        segmentDocumentCount = randomInt(Integer.MAX_VALUE);
import static org.opensearch.index.compositeindex.CompositeIndexConstants.COMPOSITE_FIELD_MARKER;
                    metricType,
        assertEquals(dataFilePointer, starTreeMetadata.getDataStartFilePointer());
import org.opensearch.index.compositeindex.datacube.startree.aggregators.MetricAggregatorInfo;
    }
        );
            starTreeFieldConfiguration.getSkipStarNodeCreationInDims().size(),
            6,
