    /**
                    if (isMerge) {
    private void constructStarTree(InMemoryTreeNode node, int startDocId, int endDocId) throws IOException {
     * Returns aggregated star-tree document  
 * this file be licensed under the Apache-2.0 license or a
        int currentDocId,  
        FieldInfo[] fieldInfoList,
        Map<String, DocValuesProducer> fieldProducerMap,
import org.apache.logging.log4j.LogManager;  
import org.opensearch.index.mapper.MapperService;
     */
    protected final int maxLeafDocuments;  
            appendToStarTree(starTreeDocumentIterator.next());
     * Get star tree document from the segment for the current docId with the dimensionReaders and metricReaders
        for (int i = 0; i < numDimensions; i++) {
    /**  
    private InMemoryTreeNode getNewNode(int dimensionId, int startDocId, int endDocId, byte nodeType, long dimensionValue) {
        Long[] dims = new Long[numDimensions];  
            FieldInfo dimensionFieldInfo = writeState.fieldInfos.fieldInfo(dimension);
        this.mergeSortedSetDimensionsOrdinalMap = dimensionToOrdinalMap;
                } catch (IOException e) {
            Long[] dimensions = Arrays.copyOf(segmentDocument.dimensions, numDimensions);  
                    };  
import java.util.HashSet;
    /**
                    LONG  
     * @param endDocId   end document id
                            DocValuesWriterWrapper<SortedSetDocValues> wrapper = (DocValuesWriterWrapper<
        );  
            TermsEnum[] liveTerms = new TermsEnum[iterators.size()];
     */  
        }
                for (int dimIndex = 0; dimIndex < dimensionsSplitOrder.get(i).getNumSubDimensions(); dimIndex++) {  
        Map<String, DocValuesProducer> fieldProducerMap,
            OrdinalMap map = OrdinalMap.build(null, liveTerms, weights, PackedInts.COMPACT);
            dimensionValueIterator.nextEntry(currentDocId);  
     * @throws IOException when we are unable to build star-tree  
        this.flushSortedSetDocValuesMap = flushSortedSetDocValuesMap;
     *  
        long dataFilePointer = dataOut.getFilePointer();
                    throw new IllegalStateException(  
    public InMemoryTreeNode getRootNode() {
        return new InMemoryTreeNode(dimensionId, startDocId, endDocId, nodeType, dimensionValue);  
     *
    /**
        return metrics;  
    }  
                try {  
import org.apache.lucene.util.NumericUtils;  
                }
            }  
        for (Dimension dim : dimensionsSplitOrder) {
                    metricAggregatorInfos.get(i).getField(),
            // actual indexing field they're based on
    /**
            }
        createSortedDocValuesIndices(starTreeDocValuesConsumer, fieldNumberAcrossStarTrees);
                    }
                throw new IllegalArgumentException("Unsupported type: " + type);
            sortedNumericWriter.addValue(docId, value);
        }
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
        List<String> dimensionNames = starTreeValues.getStarTreeField().getDimensionNames();  
                    aggregatedStarTreeDocument = reduceStarTreeDocuments(aggregatedStarTreeDocument, getStarTreeDocument(i));
        List<SequentialDocValuesIterator> metricReaders
     *
     * @param metric value of the metric  
            if (dimensionFieldInfo == null) {  
        appendDocumentsToStarTree(starTreeDocumentIterator);  
        } else {  
                try {
        int childDimensionId = node.getDimensionId() + 1;
import org.opensearch.search.aggregations.metrics.CompensatedSum;
import org.apache.lucene.index.EmptyDocValuesProducer;
        }
                    throw new IllegalStateException("Cannot apply segment doc value for aggregation [" + segmentDocument.metrics[i] + "]");
     * @param dimensionId dimension id  
            Long[] dimensions = Arrays.copyOf(starTreeDocument.dimensions, numDimensions);
        logger.debug("Total time to build ordinal maps: {} ms", System.currentTimeMillis() - curr);
    /**  
        }
        int numStarTreeDocumentUnderStarNode = numStarTreeDocs - numStarTreeDocument;
                        }
                    dimensionWriters.add(new SortedNumericDocValuesWriterWrapper(fi, bytesUsed));
     * @return
    protected Map<String, OrdinalMap> getOrdinalMaps(List<StarTreeValues> starTreeValuesSubs) throws IOException {
        AtomicInteger numSegmentDocs,  
            String dimName = entry.getKey();  
    ) throws IOException {  
                    new SortedNumericStarTreeValuesIterator(fieldProducerMap.get(fieldInfo.name).getSortedNumeric(fieldInfo))  
import org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter;
        constructStarTree(rootNode, 0, numStarTreeDocs);
            for (int i = 0; i < dim.getNumSubDimensions(); i++) {
                fieldProducerMap,
                }
import org.opensearch.index.mapper.FieldValueConverter;
        return dimensions;  
                    for (InMemoryTreeNode child : node.getChildren().values()) {  
                    if (isMerge) {  
        for (StarTreeValues starTree : starTreeValuesSubs) {  
     * Default value for star node
                node.setAggregatedDocId(node.getStartDocId());  
    protected StarTreeDocument getStarTreeDocument(  
    public void close() throws IOException {
            case SORTED_SET:
                }
            // As part of merge, we traverse the star tree doc values  
                weights[sub] = dv.getValueCount();
                        metrics[i] = metricValueAggregator.getInitialAggregatedValueForSegmentDocValue(getLong(segmentDocument.metrics[i]));
                                NumericUtils.doubleToSortableLong((Double) starTreeDocument.metrics[i])
        int numDims = 0;
     * @return list of MetricAggregatorInfo
                throw new IllegalStateException("dimension readers are empty");  
        return getNewNode(dimensionId, starNodeStartDocId, numStarTreeDocs, StarTreeNodeType.STAR.getValue(), ALL);
    ) {
     *
import org.opensearch.index.compositeindex.datacube.startree.utils.SequentialDocValuesIterator;  
            "Finished constructing star-tree, got [ {} ] tree nodes and [ {} ] starTreeDocument under star-node",
                    logger.error("could not parse the value, exiting creation of star tree");  
        logger.debug("Finished creating aggregated documents : {}", numAggregatedStarTreeDocument);
                    for (MetricStat metricStat : metric.getBaseMetrics()) {  
                    starTreeField.getName(),
        Long nodeDimensionValue = getDimensionValue(startDocId, dimensionId);
    /**
                    for (InMemoryTreeNode child : node.getChildren().values()) {
                        throw new IllegalStateException("Unknown metric doc value type");  
     *
        }
                int segmentNumber = map.getFirstSegmentNumber(value);
    }
                }
                        @Override  
     * @param aggregatedDocument aggregated star-tree document  
     */
            metricValuesIterator.nextEntry(currentDocId);
     *  
        }  
            for (MetricStat metricStat : metric.getBaseMetrics()) {
            metricFieldInfoList[i] = fi;
     * This is needed as we need to write the ordinals and also the bytesRef associated with it
                    new SortedNumericStarTreeValuesIterator(fieldProducerMap.get(metricFieldInfo.name).getSortedNumeric(metricFieldInfo))  
        FieldInfo[] dimensionFieldInfoList = new FieldInfo[numDimensions];
            int idx = 0;
        IndexOutput metaOut,
     */  
        // Further split on child nodes if required  
        node.addChildNode(lastNode, nodeDimensionValue);
                    fieldNumberAcrossStarTrees.getAndIncrement()  
     * @param metricReaders    List of docValues readers to read metrics from the segment
                    new SortedSetStarTreeValuesIterator(fieldProducerMap.get(fieldInfo.name).getSortedSet(fieldInfo))
     */
     * @throws IOException throws an exception if we are unable to construct non-star nodes
        StarTreeWriter starTreeWriter = new StarTreeWriter();
            Object[] metrics = new Object[numMetrics];
    protected int numStarTreeDocs;  
        List<SequentialDocValuesIterator> metricReaders = new ArrayList<>();  
                    MetricAggregatorInfo metricAggregatorInfo = new MetricAggregatorInfo(
    protected final int numMetrics;
            if (node.getChildStarNode() != null) {
        StarTreeDocument aggregatedStarTreeDocument = null;
            for (int sub = 0; sub < liveTerms.length; sub++) {
                    ValueAggregator metricValueAggregator = metricAggregatorInfos.get(i).getValueAggregators();
        Long metricValue = null;
        } else if (dvWriter instanceof SortedNumericDocValuesWriterWrapper sortedNumericWriter) {
import org.opensearch.index.compositeindex.datacube.startree.aggregators.ValueAggregator;  
        Object[] metrics = new Object[metricReaders.size()];  
                throw new IllegalStateException("metric reader is empty for metric: " + metric.getField());  
        }  
    abstract Iterator<StarTreeDocument> mergeStarTrees(List<StarTreeValues> starTreeValues) throws IOException;  
                OrdinalMap map = mergeSortedSetDimensionsOrdinalMap.get(field);  
                    idx++;
        List<SequentialDocValuesIterator> metricReaders = getMetricReaders(writeState, fieldProducerMap);  
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;
     * @return Iterator for the aggregated star-tree document
        logger.debug("Star-tree build is a go with star tree field {}", starTreeField.getName());
            return new StarTreeDocument(dimensions, metrics);  
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;
        this.writeState = writeState;
     * @return merged star-tree document  
    }
                } catch (Exception e) {
            i++;  
        DocValuesConsumer docValuesConsumer,
        this.metaOut = metaOut;  
import org.opensearch.index.mapper.FieldMapper;
        for (int i = startDocId + 1; i < endDocId; i++) {  
        int numAggregatedStarTreeDocument = numStarTreeDocs - numStarTreeDocument - numStarTreeDocumentUnderStarNode;
                    };
                    }
        );
                    logger.error("unable to read the metric values from the segment", e);
    /**  
                } catch (IOException e) {
     *
        logger.debug("Finished Building star-tree in ms : {}", (System.currentTimeMillis() - startTime));
                );
            if (dimensionReaders[i] != null) {
    public List<SequentialDocValuesIterator> getMetricReaders(SegmentWriteState state, Map<String, DocValuesProducer> fieldProducerMap)  
            serializeStarTree(numStarTreeDocument, numStarTreeDocs);  
     */  
                nodeDimensionValue = dimensionValue;
        // aggregate the documents  
                            );  
     *
     * @param endDocId    end document id (exclusive)
            }
                for (int i = node.getStartDocId(); i < node.getEndDocId(); i++) {  
            }
                    }  
            metricValue = longMetric;
            SequentialDocValuesIterator metricReader;
import org.apache.lucene.index.SortedSetDocValuesWriterWrapper;
                dimensionComparators.add(dim.comparator());  
     */
        for (Dimension dim : starTreeField.getDimensionsOrder()) {  
                    for (int i = node.getDimensionId() + 1; i < numDimensions; i++) {  
                    );
     *
        numSegmentDocs.set(  
    // This should be true for merge flows  
        if (dimIndex.get() != numDimensions) {  
    ) throws IOException {  
                }
     */
                    } else if (aggregatedValueType instanceof CompensatedSumType) {
                            );
                    }  
                        if (starTreeDocument.metrics[i] != null) {
     * @param fieldNumberAcrossStarTrees maintains a counter for the number of star-tree fields  
        logger.debug(  
     * @param node star-tree node
                } catch (Exception e) {
                        }  
     *
                addChildNode(node, i, dimensionId, nodeStartDocId, nodeDimensionValue);  
        int numStarTreeDocument = numStarTreeDocs;
        );
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.fullyQualifiedFieldNameForStarTreeDimensionsDocValues;
                    } else {
import java.util.concurrent.atomic.AtomicInteger;
        for (int i = 0; i < fieldCount; i++) {
        }
                    ByteBlockPool docValuesBytePool = new ByteBlockPool(byteBlockAllocator);
            } else {
     * Constructs star tree nodes
     * @return return new star-tree node  
import java.util.Map;
     * Returns the metric values for the next document from the segment
                try {
                }
        }  
     * @param dimensionId id of the dimension in the star tree  
import org.apache.lucene.index.SortedSetDocValues;
    private void appendToStarTree(StarTreeDocument starTreeDocument) throws IOException {
    protected int totalSegmentDocs;
    /**  
            }
                        fvc  
                    } else {
import java.util.Arrays;  
                            ((SortedNumericDocValuesWriterWrapper) (metricWriters.get(i))).addValue(  
        SequentialDocValuesIterator[] dimensionReaders,
     * Converts numericDocValues to sortedNumericDocValues and returns SequentialDocValuesIterator
     */
            } else {
                        if (starTreeDocument.metrics[i] != null) {  
    protected final List<MetricAggregatorInfo> metricAggregatorInfos;  
import org.apache.lucene.util.ByteBlockPool;  
                DocValuesType.SORTED_NUMERIC,
     */
    private Object[] getStarTreeMetricsFromSegment(int currentDocId, List<SequentialDocValuesIterator> metricsReaders) throws IOException {  
        serializeStarTree(numStarTreeDocument, numStarTreeDocs);
import java.util.Objects;
                        aggregatedStarTreeDocument = reduceStarTreeDocuments(aggregatedStarTreeDocument, createAggregatedDocs(child));
        for (int docId = 0; docId < numStarTreeDocs; docId++) {
        Map<String, OrdinalMap> dimensionToOrdinalMap = new HashMap<>();
     * @param dimensionId dimension id of the star-tree node  
    private InMemoryTreeNode getNewNode() {
            case SORTED_NUMERIC:
                node.setAggregatedDocId(node.getChildStarNode().getAggregatedDocId());
        logger.debug("Building star tree : {}", starTreeField.getName());
        if (childDimensionId == numDimensions) {
                // If it has multiple documents, aggregate all of them
    /**  
    void setFlushSortedSetDocValuesMap(Map<String, SortedSetDocValues> flushSortedSetDocValuesMap) {
                    logger.error("Cannot apply segment doc value for aggregation", e);  
                    );
            metrics[i] = metricAggregatorInfos.get(i).getValueAggregators().toAggregatedValueType(metricValuesIterator.value(currentDocId));  
    private InMemoryTreeNode constructStarNode(int startDocId, int endDocId, int dimensionId) throws IOException {
     */  
    public StarTreeDocument reduceStarTreeDocuments(StarTreeDocument aggregatedDocument, StarTreeDocument starTreeDocument) {
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
                } catch (Exception e) {
     * Retrieves the list of star-tree documents in the star-tree.
            if (node.getStartDocId() == node.getEndDocId() - 1) {  
            dimensionToOrdinalMap.put(dimName, map);  
                SortedSetStarTreeValuesIterator dv = iterators.get(sub);
    }
    Long[] getStarTreeDimensionsFromSegment(int currentDocId, SequentialDocValuesIterator[] dimensionReaders) throws IOException {  
            metricAggregatorInfos,  
     * @return aggregated star-tree documents  
        return new InMemoryTreeNode();
    }  
/**
    public void build(
        Map<String, List<SortedSetStarTreeValuesIterator>> dimensionToIterators = new HashMap<>();
     */
     * @param fieldProducerMap           contain s the docValues producer to get docValues associated with each field
    private Map<String, OrdinalMap> mergeSortedSetDimensionsOrdinalMap = new HashMap<>();
            starTreeField,
     * @return dimension value
            numStarTreeDocumentUnderStarNode  
        } else {
            }
            childNodeType = StarTreeNodeType.NULL.getValue();
    private void constructNonStarNodes(InMemoryTreeNode node, int startDocId, int endDocId, int dimensionId) throws IOException {  
     */
import java.util.HashMap;  
                        }
     * Sets the sortedSetDocValuesMap.
        for (int i = 0; i < metricAggregatorInfos.size(); i++) {
    }  
    /**
                    logger.error("unsupported mapper type");
                        .getValueAggregators()
    /**
            node.addChildNode(constructStarNode(startDocId, endDocId, childDimensionId), (long) ALL);  
        addChildNode(node, endDocId, dimensionId, nodeStartDocId, nodeDimensionValue);
     */
            dims[i] = val;
            i++;
     */
     * @param dimensionId id of the dimension in the star tree
    /**
        DocValuesConsumer starTreeDocValuesConsumer
     * @throws IOException throws an exception if we are unable to add the doc
                }  
    ) throws IOException {
                });
                    ByteBlockPool.DirectTrackingAllocator byteBlockAllocator = new ByteBlockPool.DirectTrackingAllocator(bytesUsed);
    ) throws IOException {
                    metric.getField(),  
     * Returns a new star-tree node
                            ((SortedNumericDocValuesWriterWrapper) (metricWriters.get(i))).addValue(
                                docId,
        SequentialDocValuesIterator[] dimensionReaders,
                    logger.error("Cannot parse initial segment doc value", e);  
     *
                dimensionsSplitOrder.get(i).getDocValuesType()  
        int starNodeStartDocId = numStarTreeDocs;
            for (int i = 0; i < numMetrics; i++) {
            }  
        build(starTreeDocumentIterator, fieldNumberAcrossStarTrees, starTreeDocValuesConsumer);  
     * Creates the star-tree docValues indices in disk
        int fieldCount
     * @throws IOException throws an exception if we are unable to construct non-star nodes
                                NumericUtils.doubleToSortableLong(((CompensatedSum) starTreeDocument.metrics[i]).value())
     */
        }
                        metrics[i] = metricValueAggregator.getInitialAggregatedValue(segmentDocument.metrics[i]);  
        switch (type) {  
        DocValuesType type
                // as part of star tree doc values file formats
     */
            // TODO : cache lookupOrd to make it faster
    /**
                    if (aggregatedValueType.equals(LONG)) {
    ) throws IOException;
                try {
     */
            if (isMerge) {
                dimensionFieldInfo,
    }  
        InMemoryTreeNode lastNode = getNewNode(dimensionId, nodeStartDocId, endDocId, childNodeType, childNodeDimensionValue);  
        // Group iterators by dimension
import java.util.ArrayList;
     */  
    public abstract Iterator<StarTreeDocument> generateStarTreeDocumentsForStarNode(int startDocId, int endDocId, int dimensionId)
        assert fieldProducerMap.containsKey(fieldInfo.name);  
        for (int i = 0; i < dimensionsSplitOrder.size(); i++) {  
     */
                    throw new IllegalStateException("Cannot parse initial segment doc value [" + segmentDocument.metrics[i] + "]");
        appendDocumentsToStarTree(starTreeDocumentIterator);
        // For leaf node  
     * @return root node with star nodes constructed
                dimensionsSplitOrder.get(i).setDimensionValues(dimensionReaders[i].value(currentDocId), value -> {
    /**
            metaOut,
            Integer.parseInt(starTreeValues.getAttributes().getOrDefault(SEGMENT_DOCS_COUNT, String.valueOf(DocIdSetIterator.NO_MORE_DOCS)))
    public static final Long STAR_IN_DOC_VALUES_INDEX = null;  
     * @param nodeType node type of the star-tree node  
                dimIndex++;
                            getLong(segmentDocument.metrics[i])
     * @param fieldNumberAcrossStarTrees maintains a counter for the number of star-tree fields
        starTreeWriter.writeStarTreeMetadata(  
                String metricFullName = fullyQualifiedFieldNameForStarTreeMetricsDocValues(
        boolean isMerge  
import org.apache.lucene.index.SortedNumericDocValuesWriterWrapper;  
            if (metricReader != null) {
                    logger.error("Cannot apply value to aggregated document for aggregation", e);
                }  
    }  
     * @param starTreeDocValuesConsumer  consumes the generated star-tree docValues
     *
            // step 1: iterate through each sub and mark terms still in use  
                }
    }  
            if (Objects.equals(dimensionValue, nodeDimensionValue) == false) {
import org.opensearch.index.mapper.Mapper;  
        throws IOException {
            }
     * Adds startree field to respective field writers  
            for (int i = 0; i < starTreeDocument.metrics.length; i++) {
                    logger.error("unable to iterate to next doc", e);
     */
}
     * Generates the configuration required to perform aggregation for all the metrics on a field  
                metricReader = new SequentialDocValuesIterator(
            numStarTreeNodes,
                    throw new IllegalStateException("unable to read the metric values from the segment", e);  
     * Adds a document to the star-tree.  
        Iterator<StarTreeDocument> starTreeDocumentIterator = sortAndAggregateSegmentDocuments(dimensionReaders, metricReaders);
            numSegmentStarTreeDocuments,
        Object[] metrics = getStarTreeMetricsFromSegment(currentDocId, metricReaders);
        if (!node.hasChild()) {
            // serialize the star tree data
        MapperService mapperService
    /**
import org.opensearch.index.compositeindex.datacube.startree.utils.CompensatedSumType;
                    }
                        aggregatedStarTreeDocument = reduceStarTreeDocuments(aggregatedStarTreeDocument, createAggregatedDocs(child));
import org.apache.lucene.util.LongValues;
                    node.setAggregatedDocId(numStarTreeDocs);  
        for (int i = 0; i < dimensionReaders.length; i++) {  
import java.util.Collections;
     *  
        if (aggregatedDocument == null) {
        StarTreeDocument aggregatedSegmentDocument,
            for (int i = 0; i < numMetrics; i++) {
        }
            numDims += dim.getNumSubDimensions();
     * Returns the ordinal map per field based on given star-tree values across different segments  
            if (child.getEndDocId() - child.getStartDocId() > maxLeafDocuments) {
                final FieldInfo fi = getFieldInfo(  
                return new SequentialDocValuesIterator(  
        long startTime = System.currentTimeMillis();  
    /**  
    private static Long getLong(Object metric) {  
     * @return converted metric value to long
     * @param starTreeDocument   segment star-tree document
        int metricIndex = 0;
                );
                }
            if (metric.getBaseMetrics().isEmpty()) continue;
        }
                // add the dimension indices
     * @throws IOException if an I/O error occurs while adding the document  
                        }  
                } catch (Exception e) {
        addStarTreeDocValueFields(docValuesConsumer, metricWriters, metricFieldInfoList, metricAggregatorInfos.size());
import org.apache.lucene.index.TermsEnum;  
            );
     */
            return aggregatedSegmentDocument;
     * @param endDocId end doc id of the star-tree node
        this.dataOut = dataOut;
     * @param dimensionReaders List of docValues readers to read dimensions from the segment  
            String dimension = dimensionsSplitOrder.get(i).getField();
                    fullyQualifiedFieldNameForStarTreeDimensionsDocValues(starTreeField.getName(), name),
                    metric.getField(),
            }
        }
        // Further split star node if needed  
     * Adds a document to star-tree
    /**
        return new StarTreeDocument(dims, metrics);  
        this.skipStarNodeCreationForDimensions = new HashSet<>();  
        DocValuesConsumer starTreeDocValuesConsumer
     *  
import java.util.Comparator;
    private void addStarTreeDocValueFields(
                fieldNumberAcrossStarTrees.getAndIncrement()  
                            );
                );  
import org.apache.lucene.util.packed.PackedInts;
                        node.setAggregatedDocId(child.getAggregatedDocId());  
     * @param endDocId    end document id (exclusive) in the star-tree
        return dimensionToOrdinalMap;  
        numStarTreeNodes++;
    }
                metricReaders.add(new SequentialDocValuesIterator(starTreeValues.getMetricValuesIterator(metricFullName)));  
    }  
     *
     * @throws IOException if an I/O error occurs while fetching the star-tree document  
                );
    protected final StarTreeField starTreeField;  
                aggregatedStarTreeDocument = createAggregatedDocs(node.getChildStarNode());
        for (Metric metric : this.starTreeField.getMetrics()) {
        for (SequentialDocValuesIterator metricValuesIterator : metricReaders) {
            List<SortedSetStarTreeValuesIterator> iterators = entry.getValue();
    protected StarTreeDocument getSegmentStarTreeDocument(
                        starTreeField.getName(),
            StarTreeDocument starTreeDocument = getStarTreeDocument(docId);  
                    logger.error("unable to read the dimension values from the segment", e);
            }
            }  
                fullyQualifiedFieldNameForStarTreeMetricsDocValues(  
                    aggregatedStarTreeDocument.dimensions[i] = STAR_IN_DOC_VALUES_INDEX;
                case SORTED_NUMERIC:
        SequentialDocValuesIterator sequentialDocValuesIterator;
        }
        Long[] dimensions = getStarTreeDimensionsFromSegment(currentDocId, dimensionReaders);
import java.util.Set;  
    @SuppressWarnings("unchecked")
     * @param node       star-tree node  
    /**
    protected final Set<Integer> skipStarNodeCreationForDimensions;
     * @param starTreeDocValuesConsumer  consumes the generated star-tree docValues
            for (MetricStat metricStat : metric.getBaseMetrics()) {  
        numStarTreeNodes++;  
                } else {
                            ((SortedNumericDocValuesWriterWrapper) (metricWriters.get(i))).addValue(
            logger.debug("Ordinal map for dimension {} - Size in bytes: {}", dimName, map.ramBytesUsed());
            }  
        throws IOException {
        constructNonStarNodes(node, startDocId, endDocId, childDimensionId);
     *  
        for (InMemoryTreeNode child : node.getChildren().values()) {
            Long dimensionValue = getDimensionValue(i, dimensionId);
     * @throws IOException when we are unable to iterate to the next doc for the given metric readers
                    throw new IllegalStateException("unsupported mapper type");
     * Generates the configuration required to perform aggregation for all the metrics on a field
    }  
     * @param startDocId  start document id (inclusive) in the star-tree  
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues;  
                    FieldValueConverter aggregatedValueType = metricAggregatorInfos.get(i).getValueAggregators().getAggregatedValueType();
    }
                                SortedNumericDocValues>) docValuesWriters.get(writerIndex);
                if (starTree.getDimensionValuesIterator(dimName) instanceof SortedSetStarTreeValuesIterator sortedSetIterator) {
import static org.opensearch.index.compositeindex.CompositeIndexConstants.SEGMENT_DOCS_COUNT;  
                );
    }
                if (fieldMapper instanceof FieldMapper fm && fm.fieldType() instanceof FieldValueConverter fvc) {
 * SPDX-License-Identifier: Apache-2.0
     * Returns the value of the dimension for the given dimension id and document in the star-tree.  
        SequentialDocValuesIterator[] dimensionReaders,
        Object[] metrics = new Object[numMetrics];
import org.opensearch.index.compositeindex.datacube.startree.node.InMemoryTreeNode;  
            for (Dimension dim : dimensionsSplitOrder) {
            fieldInfo = getFieldInfo(name, DocValuesType.NUMERIC);  
        SequentialDocValuesIterator[] dimensionReaders,
     * @return list of MetricAggregatorInfo
        return metricAggregatorInfos;  
                    this.skipStarNodeCreationForDimensions.add(i + dimIndex);
 * @opensearch.experimental  
            }  
    /**  
        );  
        Iterator<StarTreeDocument> starTreeDocumentIterator = generateStarTreeDocumentsForStarNode(startDocId, endDocId, dimensionId);  
    public abstract Iterator<StarTreeDocument> sortAndAggregateSegmentDocuments(
                    metricAggregatorInfos.add(metricAggregatorInfo);
            final int writerIndex = i;
        appendStarTreeDocument(starTreeDocument);
            }
     * Returns a new star-tree node
        } else {
     */
        StarTreeFieldConfiguration starTreeFieldSpec = starTreeField.getStarTreeConfig();
        int numSegmentStarTreeDocument = totalSegmentDocs;
    }
                    ValueAggregator metricValueAggregator = metricAggregatorInfos.get(i).getValueAggregators();
        List<MetricAggregatorInfo> metricAggregatorInfos = new ArrayList<>();
     */
                appendToStarTree(aggregatedStarTreeDocument);
     * Generates aggregated star-tree documents for star-node.
        sequentialDocValuesIterator = new SequentialDocValuesIterator(
     */  
        }
        i = 0;
     * @param mapperService helps to find the original type of the field
    List<Dimension> dimensionsSplitOrder = new ArrayList<>();
                    throw new IllegalStateException("Cannot get value for aggregation[" + starTreeDocument.metrics[i] + "]");  
     */
                if (null == aggregatedStarTreeDocument) {  
                    MetricStat.DOC_COUNT,  
     * @return star tree document
    ) throws IOException {
    }
        IndexOutput dataOut,
    protected final List<Comparator<Long>> dimensionComparators = new ArrayList<>();  
    /**
    }
    protected final int numDimensions;
import org.apache.lucene.index.DocValuesType;
                    aggregatedDocument.metrics[i] = metricAggregatorInfos.get(i)
        StarTreeValues starTreeValues
    protected StarTreeDocument reduceSegmentStarTreeDocuments(  
     *
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
                constructStarTree(child, child.getStartDocId(), child.getEndDocId());  
    private Map<String, SortedSetDocValues> flushSortedSetDocValuesMap = new HashMap<>();  
     * @param dimensionId dimension id of the star-node
    /**
            }
    protected final InMemoryTreeNode rootNode = getNewNode();
            childNodeDimensionValue = ALL;  
            return;
     *  
     * Reads all the configuration related to dimensions and metrics, builds a star-tree based on the different construction parameters.  
                nodeStartDocId = i;
public abstract class BaseStarTreeBuilder implements StarTreeBuilder {
    /**  
                    } else {
        for (int i = 0; i < starTreeField.getMetrics().size(); i++) {  
                                SortedSetDocValues>) docValuesWriters.get(writerIndex);  
            long[] weights = new long[liveTerms.length];
        StarTreeField starTreeField,  
     * aggregated star-tree documents.
                for (InMemoryTreeNode child : node.getChildren().values()) {
     * Nulls are handled during aggregation
                    break;  
     */
        }
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;  
     * @throws IOException throws an exception if we are unable to construct the tree  
            numStarTreeNodes,
                                (long) starTreeDocument.metrics[i]  
    }  
     */  
    public abstract void appendStarTreeDocument(StarTreeDocument starTreeDocument) throws IOException;
                if (metricFieldInfo == null) {
     * @return metric values for each of the star-tree metric  
            dimensionsSplitOrder.add(dim);
                    dimensions[dimIndex.getAndIncrement()] = value;  
                    appendToStarTree(aggregatedStarTreeDocument);
        if (nodeDimensionValue == null) {
        }
    public abstract StarTreeDocument getStarTreeDocument(int docId) throws IOException;
                            return wrapper.getDocValues();
     */  
    }  
                    docValuesConsumer.addSortedSetField(fieldInfoList[i], docValuesProducer);
        }
    }
     * @param starTreeField holds the configuration for the star tree
            }
        addStarTreeDocValueFields(docValuesConsumer, dimensionWriters, dimensionFieldInfoList, numDimensions);
        this.totalSegmentDocs = writeState.segmentInfo.maxDoc();
            switch (fieldInfoList[i].getDocValuesType()) {
    void appendDocumentsToStarTree(Iterator<StarTreeDocument> starTreeDocumentIterator) throws IOException {
        int dimIndex = 0;  
     * @param node parent node
        String name  
            childNodeType = StarTreeNodeType.DEFAULT.getValue();
                    }  
        for (SequentialDocValuesIterator dimensionValueIterator : dimensionReaders) {
     * @throws IOException when we are unable to iterate to the next doc for the given dimension readers
import org.opensearch.index.compositeindex.datacube.Metric;  
                    dimensionReaders[i].nextEntry(currentDocId);  
        AtomicInteger fieldNumberAcrossStarTrees,  
    // Maintains ordinalMap for each star tree dimension field during merge  
                    docValuesProducer = new EmptyDocValuesProducer() {
                if (dim.getDocValuesType().equals(DocValuesType.SORTED_SET)) {  
            }
        List<DocValuesWriterWrapper<?>> docValuesWriters,  
     * @param dimensionValue dimension value of the star-tree node
        if (dvWriter instanceof SortedSetDocValuesWriterWrapper sortedSetWriter) {  
    public List<MetricAggregatorInfo> generateMetricAggregatorInfos(MapperService mapperService) {
     *  
        if (numStarTreeDocs == 0) {
        for (int i = 0; i < dimensionReaders.length; i++) {  
                    throw new IllegalStateException("aggregated star-tree document is null after reducing the documents");
                metricReader = getIteratorForNumericField(fieldProducerMap, metricFieldInfo, DocCountFieldMapper.NAME);
                    }
import org.apache.lucene.index.OrdinalMap;  
    }  
            dataFilePointer,
            } else {  
                    fieldProducerMap.get(dimensionFieldInfo.name).getSortedSet(dimensionFieldInfo)
        if (fieldInfo == null) {
                    metricReader.nextEntry(currentDocId);  
import java.util.Iterator;
        }  
                    logger.error("unable to iterate to next doc", e);
/*  
        this.numDimensions = numDims;
                );
import java.util.List;  
        }
        return rootNode;  
            default:  
        }  
                        public SortedSetDocValues getSortedSet(FieldInfo field) {
                        }
        this.maxLeafDocuments = starTreeFieldSpec.maxLeafDocs();
        // Create doc values indices in disk
        return sequentialDocValuesIterator;
        }  
            }
    private void serializeStarTree(int numSegmentStarTreeDocuments, int numStarTreeDocs) throws IOException {
            constructStarTree(node.getChildStarNode(), node.getChildStarNode().getStartDocId(), node.getChildStarNode().getEndDocId());  
            if (metric.getField().equals(DocCountFieldMapper.NAME)) {
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.getFieldInfo;
    private void indexDocValue(DocValuesWriterWrapper<?> dvWriter, int docId, long value, String field) throws IOException {
     *
            if (dimensionsSplitOrder.get(i).getDocValuesType().equals(DocValuesType.SORTED_SET)) {  
    }  
import org.apache.lucene.index.SegmentWriteState;
        Iterator<StarTreeDocument> starTreeDocumentIterator,  
    private SequentialDocValuesIterator getIteratorForNumericField(  
        Map<String, LongValues> longValues
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNodeType;
                        );
            } else {
        FieldInfo fieldInfo,
    @SuppressWarnings({ "unchecked", "rawtypes" })
                    dimensionToIterators.computeIfAbsent(dimName, k -> new ArrayList<>()).add(sortedSetIterator);  
                                docId,  
            for (String name : dim.getSubDimensionNames()) {
        // get doc id set iterators for metrics
                                docId,
        throws IOException;  
import org.apache.lucene.index.DocValues;
    /**
    // Maintains list of sortedSetDocValues for each star tree dimension field across segments during merge
                        aggregatedStarTreeDocument.dimensions[i] = STAR_IN_DOC_VALUES_INDEX;
        int i = 0;
        AtomicInteger fieldNumberAcrossStarTrees,
     * A new aggregated star-tree document is created if the aggregated document is null.
     * Constructs non star tree nodes  
                    starTreeField.getName(),
     * @param endDocId    end document id (exclusive)
     */  
                continue;  
        logger.debug("Generated star tree docs : [{}] from segment docs : [{}]", numStarTreeDocument, numSegmentStarTreeDocument);
                return new SequentialDocValuesIterator(
                        aggregatedSegmentDocument.metrics[i] = metricValueAggregator.mergeAggregatedValueAndSegmentValue(  
        if (metric instanceof Long longMetric) {  
    private StarTreeDocument createAggregatedDocs(InMemoryTreeNode node) throws IOException {  
     * @param startDocId  start document id (inclusive)  
        List<SequentialDocValuesIterator> metricReaders  
    /**  
            }  
                }  
            dimensionReaders[i] = new SequentialDocValuesIterator(starTreeValues.getDimensionValuesIterator(dimensionNames.get(i)));
import org.apache.logging.log4j.Logger;
        }
                sortedSetWriter.addValue(docId, mergeSortedSetDimensionsMap.get(field).get(segmentNumber).lookupOrd(segmentOrd));  
    @SuppressWarnings("unchecked")  
                } else {  
                } catch (Exception e) {
            Metric metric = starTreeField.getMetrics().get(i);
                        "Cannot apply value to aggregated document for aggregation [" + starTreeDocument.metrics[i] + "]"
        Map<String, DocValuesProducer> fieldProducerMap,  
    }
    ) throws IOException {
        createAggregatedDocs(rootNode);  
     * @param startDocId start doc id of the star-tree node
            } else {
            if (skipStarNodeCreationForDimensions.contains(dimensionsSplitOrder.get(i).getField())) {
        for (Map.Entry<String, List<SortedSetStarTreeValuesIterator>> entry : dimensionToIterators.entrySet()) {
                    dim.getDocValuesType(),
            return new StarTreeDocument(dimensions, metrics);
                        metric.getField(),
     * @param starTreeDocumentIterator   contains the sorted and aggregated documents  
            childNodeDimensionValue = nodeDimensionValue;  
                        );  
     * @return Star tree documents
        }
                    metricAggregatorInfos.get(i).getMetricStat().getTypeName()  
                            aggregatedSegmentDocument.metrics[i],
        Long[] dimensions = new Long[numDimensions];
    }
                    dimensionsSplitOrder.get(i).getField(),
        return new StarTreeDocument(dimensions, metrics);  
import org.apache.lucene.codecs.DocValuesProducer;  
                // If it has only one document, use it as the aggregated document
    private Map<String, List<SortedSetStarTreeValuesIterator>> mergeSortedSetDimensionsMap = new HashMap<>();
        logger.debug("Sorting and aggregating star-tree in ms : {}", (System.currentTimeMillis() - startTime));
    }
    /**  
        // Construct star-node if required
            for (String dimName : starTree.getStarTreeField().getDimensionNames()) {
    /**  
            throw new IllegalStateException("Values are not set for all dimensions");
     * @throws IOException when we are unable to build star-tree
                        metricStat,  
                );
                        metricIndex++;
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedSetStarTreeValuesIterator;
                } else {
            }
        int nodeStartDocId = startDocId;
     * Returns the document of the given document id in the star-tree.
                }
        return aggregatedStarTreeDocument;
     * @param starTreeDocument star-tree document
                    break;
                MetricAggregatorInfo metricAggregatorInfo = new MetricAggregatorInfo(
    protected void setReadersAndNumSegmentDocsDuringMerge(  
            }
 * compatible open source license.
                    }
import org.opensearch.index.mapper.DocCountFieldMapper;  
     * @param aggregatedSegmentDocument aggregated star-tree document
                            return wrapper.getDocValues();
    protected BaseStarTreeBuilder(  
                        metrics[metricIndex] = metricValue;
package org.opensearch.index.compositeindex.datacube.startree.builder;
     * @param docId document id
                }
            // For non-leaf node
import org.opensearch.index.compositeindex.datacube.startree.aggregators.MetricAggregatorInfo;
            && (node.getChildStarNode().getEndDocId() - node.getChildStarNode().getStartDocId() > maxLeafDocuments)) {
            dimensionReaders[i] = getSequentialDocValuesIterator(  
 * Builder for star tree. Defines the algorithm to construct star-tree  
    }
            return aggregatedDocument;
                    if (starTreeDocument.dimensions[idx] != null) {
            }
    ) throws IOException {  
                        if (starTreeDocument.metrics[i] != null) {
    }
                // This is needed as we need to write the ordinals and also the bytesRef associated with it
                }
            Object[] metrics = new Object[numMetrics];  
            if (metric.getField().equals(DocCountFieldMapper.NAME)) {
            DocValuesProducer docValuesProducer;  
    /**
import org.apache.lucene.search.DocIdSetIterator;
import org.apache.lucene.store.IndexOutput;
                }
        }
                node.setAggregatedDocId(numStarTreeDocs);  
        }
        List<DocValuesWriterWrapper<?>> metricWriters = new ArrayList<>();  
                try {
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.DOUBLE;
    }
                    dimensionWriters.add(new SortedSetDocValuesWriterWrapper(fi, bytesUsed, docValuesBytePool));  
        while (starTreeDocumentIterator.hasNext()) {  
        for (Metric metric : starTreeValues.getStarTreeField().getMetrics()) {
                case SORTED_SET:
    private final IndexOutput metaOut;  
                        indexDocValue(dimensionWriters.get(idx), docId, starTreeDocument.dimensions[idx], dim.getField());
        List<DocValuesWriterWrapper<?>> dimensionWriters = new ArrayList<>();
                    metricFieldInfo = getFieldInfo(metric.getField(), DocValuesType.SORTED_NUMERIC);  
     * @param starTreeDocument star tree document to be added
                dimensionFieldInfoList[dimIndex] = fi;
     * A new aggregated star-tree document is created if the aggregated segment document is null.
            }
                    metricStat.getTypeName()
        long totalStarTreeDataLength = starTreeWriter.writeStarTree(dataOut, rootNode, numStarTreeNodes, starTreeField.getName());  
    /**
 */  
                    metrics[i] = metricAggregatorInfos.get(i).getValueAggregators().getInitialAggregatedValue(starTreeDocument.metrics[i]);  
    private final Counter bytesUsed = Counter.newCounter();
        // serialize the star tree data  
                flushSortedSetDocValuesMap.put(  
        // serialize star-tree
                    throw new IllegalStateException("unable to read the dimension values from the segment", e);  
            }  
                default:  
     * @return merged star-tree document
                    Object metricValue = metricReader.value(currentDocId);
        long curr = System.currentTimeMillis();  
        FieldInfo fieldInfo,
                liveTerms[sub] = dv.termsEnum();  
        }  
     * @throws IOException throws an exception upon failing to create new aggregated docs based on star tree
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.LONG;  
import org.apache.lucene.codecs.DocValuesConsumer;
                    throw new RuntimeException("unable to iterate to next doc", e);  
                    throw new IllegalStateException("Unsupported doc values type");
        node.setChildDimensionId(childDimensionId);
        if (aggregatedSegmentDocument == null) {
        }
        for (Metric metric : this.starTreeField.getMetrics()) {  
    private void createSortedDocValuesIndices(DocValuesConsumer docValuesConsumer, AtomicInteger fieldNumberAcrossStarTrees)  
                    throw new RuntimeException("unable to iterate to next doc", e);  
        // serialize the star tree meta
        long childNodeDimensionValue;  
     * @return Iterator for the aggregated star-tree documents  
                Mapper fieldMapper = mapperService.documentMapper().mappers().getMapper(metric.getField());  
     */
     */
     * Returns the star-tree document from the segment based on the current doc id  
                if (metric.getBaseMetrics().isEmpty()) continue;
    protected int numStarTreeNodes;
            totalStarTreeDataLength
        byte childNodeType;
                }
import org.apache.lucene.index.SortedNumericDocValues;
import org.opensearch.index.compositeindex.datacube.Dimension;
            FieldInfo metricFieldInfo = state.fieldInfos.fieldInfo(metric.getField());  
     * Writes star tree structure to file format  
                // If no star child exists, aggregate all aggregated documents from non-star children
        if (node.getChildStarNode() != null
    }
     * Merges a star-tree document into an aggregated star-tree document.  
                try {  
        FieldInfo[] metricFieldInfoList = new FieldInfo[metricAggregatorInfos.size()];
    ) {  
        }  
        return metricValue;  
     *
                } catch (Exception e) {
                        @Override
        numStarTreeDocs++;  
                }  
     * Safely converts the metric value of object type to long.  
        Set<String> skipStarNodeCreationForDimensions = starTreeFieldSpec.getSkipStarNodeCreationInDims();
                try {  
                sortedSetWriter.addValue(docId, flushSortedSetDocValuesMap.get(field).lookupOrd(value));
    /**
 *
     * Sorts and aggregates all the documents in the segment as per the configuration, and returns a star-tree document iterator for all the  
                if (node.getChildren().values().size() == 1) {  
            SequentialDocValuesIterator metricReader = metricsReaders.get(i);  
        List<Dimension> dimensionsSplitOrder = starTreeField.getDimensionsOrder();
                            DocValuesWriterWrapper<SortedNumericDocValues> wrapper = (DocValuesWriterWrapper<  
            for (int i = 0; i < numMetrics; i++) {
        }  
            // The type of data stored in metric fields is different from the
        this.numMetrics = metricAggregatorInfos.size();
                        public SortedNumericDocValues getSortedNumeric(FieldInfo field) {
                long segmentOrd = map.getFirstSegmentOrd(value);
import org.opensearch.index.compositeindex.datacube.MetricStat;
                } catch (IllegalArgumentException e) {
     * @param segmentDocument           segment star-tree document
        return metricReaders;
            for (int i = 0; i < numMetrics; i++) {  
            numStarTreeDocs,  
     * @param docId       document id
     * Sets dimensions / metric readers nnd numSegmentDocs
    /**  
    /**
                        aggregatedSegmentDocument.metrics[i] = metricValueAggregator.mergeAggregatedValues(
    /**  
     * @param startDocId  start document id (inclusive)
                }
     *
                            aggregatedSegmentDocument.metrics[i]  
                for (int i = node.getDimensionId() + 1; i < numDimensions; i++) {  
                        .mergeAggregatedValues(starTreeDocument.metrics[i], aggregatedDocument.metrics[i]);  
                        throw new IllegalStateException("aggregated star-tree document is null after reducing the documents");
    protected boolean isMerge = false;
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.ALL;
                    docValuesProducer = new EmptyDocValuesProducer() {  
        AtomicInteger dimIndex = new AtomicInteger(0);
        List<SequentialDocValuesIterator> metricReaders,
    }  
            metricReaders.add(metricReader);  
                            segmentDocument.metrics[i],
 * See {@link StarTreesBuilder} for information around the construction of star-trees based on star-tree fields
     *
     * Implements the algorithm to construct a star-tree
        if (dimensionToIterators.isEmpty()) return Collections.emptyMap();
            }
            } else {
                aggregatedStarTreeDocument = getStarTreeDocument(node.getStartDocId());
            return;  
                    logger.error("Cannot get value for aggregation", e);
    /**  
                    } else if (aggregatedValueType.equals(DOUBLE)) {  
    private void addChildNode(InMemoryTreeNode node, int endDocId, int dimensionId, int nodeStartDocId, Long nodeDimensionValue) {
            final FieldInfo fi = getFieldInfo(
                metricAggregatorInfos.add(metricAggregatorInfo);
     * @param writeState    stores the segment write writeState  
            metricWriters.add(new SortedNumericDocValuesWriterWrapper(fi, bytesUsed));  
     */
        }  
    }
        StarTreeDocument segmentDocument,
    public void build(
    }
    ) {
                dimensionFieldInfo = getFieldInfo(dimension, dimensionsSplitOrder.get(i).getDocValuesType());
        // Construct all non-star children nodes  
        }
    private final SegmentWriteState writeState;
import org.apache.lucene.index.DocValuesWriterWrapper;  
    public abstract List<StarTreeDocument> getStarTreeDocuments() throws IOException;  
                    }
    public abstract Long getDimensionValue(int docId, int dimensionId) throws IOException;  
     * Builds the star tree using sorted and aggregated star-tree Documents
            // step 2: create ordinal map for this dimension
        this.metricAggregatorInfos = generateMetricAggregatorInfos(mapperService);  
            new SortedNumericStarTreeValuesIterator(DocValues.singleton(fieldProducerMap.get(fieldInfo.name).getNumeric(fieldInfo)))
        SegmentWriteState writeState,
        if (!skipStarNodeCreationForDimensions.contains(childDimensionId) && node.getChildren().size() > 1) {
     * Each metric field is associated with a metric reader
            Long val = dimensionValueIterator.value(currentDocId, longValues.get(starTreeField.getDimensionNames().get(i)));
     * Returns the dimension values for the next document from the segment
    private final IndexOutput dataOut;
     * @param startDocId start document id
     * Builds the star tree from the original segment documents  
                    createAggregatedDocs(child);
        }
     * @return dimension values for each of the star-tree dimension  
 */
        SequentialDocValuesIterator[] dimensionReaders = new SequentialDocValuesIterator[dimensionsSplitOrder.size()];
                    if (null == aggregatedStarTreeDocument) {  
                    docValuesConsumer.addSortedNumericField(fieldInfoList[i], docValuesProducer);
            );
        List<SequentialDocValuesIterator> metricReaders,  
                ),
                for (String name : dim.getSubDimensionNames()) {  
                    starTreeValues.getStarTreeField().getName(),
    private SequentialDocValuesIterator getSequentialDocValuesIterator(
 *
        int currentDocId,
     */
        this.mergeSortedSetDimensionsMap = dimensionToIterators;  
    private static final Logger logger = LogManager.getLogger(BaseStarTreeBuilder.class);
import org.apache.lucene.index.FieldInfo;
     * Returns the sequential doc values iterator for the given field based on associated docValuesType
import org.apache.lucene.util.Counter;
        this.starTreeField = starTreeField;  
        } else {
                // If it has star child, use the star child aggregated document directly  
     * Merges a star-tree document from the segment into an aggregated star-tree document.
