                    LONG
     * @return metric values for each of the star-tree metric
        if (metric instanceof Long longMetric) {
                    ByteBlockPool.DirectTrackingAllocator byteBlockAllocator = new ByteBlockPool.DirectTrackingAllocator(bytesUsed);
     * @return converted metric value to long
        List<MetricAggregatorInfo> metricAggregatorInfos = new ArrayList<>();
                    metricAggregatorInfos.get(i).getMetricStat().getTypeName()
     */
        numStarTreeNodes++;
                    };
                    for (MetricStat metricStat : metric.getBaseMetrics()) {
     * @param writeState    stores the segment write writeState
    private void addStarTreeDocValueFields(
/**
                throw new IllegalStateException("dimension readers are empty");
                            ((SortedNumericDocValuesWriterWrapper) (metricWriters.get(i))).addValue(
        appendStarTreeDocument(starTreeDocument);
                    metric.getField(),
    private Map<String, SortedSetDocValues> flushSortedSetDocValuesMap = new HashMap<>();
            SequentialDocValuesIterator metricReader;
                    appendToStarTree(aggregatedStarTreeDocument);
            }
     * @throws IOException throws an exception upon failing to create new aggregated docs based on star tree
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNodeType;
     * @param endDocId   end document id
                                docId,
        long dataFilePointer = dataOut.getFilePointer();
import org.apache.lucene.index.SortedSetDocValuesWriterWrapper;
        }
        if (numStarTreeDocs == 0) {
    List<Dimension> dimensionsSplitOrder = new ArrayList<>();
import org.apache.lucene.util.LongValues;
    /**
                    throw new RuntimeException("unable to iterate to next doc", e);
import org.opensearch.index.mapper.DocCountFieldMapper;
     * @param metric value of the metric
        logger.debug("Star-tree build is a go with star tree field {}", starTreeField.getName());
     * @param starTreeDocument star tree document to be added
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues;
        // serialize the star tree data
            return new StarTreeDocument(dimensions, metrics);
            // For non-leaf node
        }
    ) throws IOException {
                    docValuesProducer = new EmptyDocValuesProducer() {
        int numStarTreeDocument = numStarTreeDocs;
                    docValuesProducer = new EmptyDocValuesProducer() {
                );
            metricValuesIterator.nextEntry(currentDocId);
            if (metric.getBaseMetrics().isEmpty()) continue;
import org.apache.lucene.codecs.DocValuesConsumer;
     *
import java.util.Iterator;
    /**
    }
                for (int i = node.getDimensionId() + 1; i < numDimensions; i++) {
     */
                    dimensionsSplitOrder.get(i).getField(),
            );
        node.setChildDimensionId(childDimensionId);
    }
     */
                }
        StarTreeWriter starTreeWriter = new StarTreeWriter();
                if (metric.getBaseMetrics().isEmpty()) continue;
            OrdinalMap map = OrdinalMap.build(null, liveTerms, weights, PackedInts.COMPACT);
    /**
                );
                case SORTED_NUMERIC:
                }
     * Adds a document to the star-tree.
    private SequentialDocValuesIterator getSequentialDocValuesIterator(
    /**
                for (String name : dim.getSubDimensionNames()) {
                    }
                                NumericUtils.doubleToSortableLong((Double) starTreeDocument.metrics[i])
        this.numMetrics = metricAggregatorInfos.size();
        if (nodeDimensionValue == null) {
    ) throws IOException {
}
            numStarTreeNodes,
     */
    /**
     */
        }
                            return wrapper.getDocValues();
            dimensionReaders[i] = new SequentialDocValuesIterator(starTreeValues.getDimensionValuesIterator(dimensionNames.get(i)));
     */
        }
                    aggregatedStarTreeDocument = reduceStarTreeDocuments(aggregatedStarTreeDocument, getStarTreeDocument(i));
    private void constructStarTree(InMemoryTreeNode node, int startDocId, int endDocId) throws IOException {
                MetricAggregatorInfo metricAggregatorInfo = new MetricAggregatorInfo(
                return new SequentialDocValuesIterator(
     * @throws IOException throws an exception if we are unable to add the doc
     *
                    if (null == aggregatedStarTreeDocument) {
        this.mergeSortedSetDimensionsOrdinalMap = dimensionToOrdinalMap;
            metricWriters.add(new SortedNumericDocValuesWriterWrapper(fi, bytesUsed));
import org.apache.lucene.index.SortedSetDocValues;
        Map<String, DocValuesProducer> fieldProducerMap,
    /**
    private void constructNonStarNodes(InMemoryTreeNode node, int startDocId, int endDocId, int dimensionId) throws IOException {
        }
        int currentDocId,
import org.opensearch.index.compositeindex.datacube.startree.node.InMemoryTreeNode;
            totalStarTreeDataLength
        if (aggregatedSegmentDocument == null) {
    ) throws IOException {
                liveTerms[sub] = dv.termsEnum();
public abstract class BaseStarTreeBuilder implements StarTreeBuilder {
    /**
            }
                try {
                    }
                                SortedNumericDocValues>) docValuesWriters.get(writerIndex);
    private StarTreeDocument createAggregatedDocs(InMemoryTreeNode node) throws IOException {
    protected StarTreeDocument reduceSegmentStarTreeDocuments(
            if (isMerge) {
        }
                if (node.getChildren().values().size() == 1) {
                nodeStartDocId = i;
     *
    /**
        logger.debug("Finished creating aggregated documents : {}", numAggregatedStarTreeDocument);
     * Get star tree document from the segment for the current docId with the dimensionReaders and metricReaders
        long childNodeDimensionValue;
        AtomicInteger dimIndex = new AtomicInteger(0);
     * @param node star-tree node
    ) throws IOException;
        MapperService mapperService
                try {
    /**
     * Generates the configuration required to perform aggregation for all the metrics on a field
        this.starTreeField = starTreeField;
    private Map<String, OrdinalMap> mergeSortedSetDimensionsOrdinalMap = new HashMap<>();
                dimensionFieldInfoList[dimIndex] = fi;
     * @return root node with star nodes constructed
                }
                    metricAggregatorInfos.add(metricAggregatorInfo);
        // serialize the star tree meta
                        node.setAggregatedDocId(child.getAggregatedDocId());
        SegmentWriteState writeState,
        List<SequentialDocValuesIterator> metricReaders
import org.opensearch.index.compositeindex.datacube.startree.utils.CompensatedSumType;
    protected boolean isMerge = false;
        for (int i = 0; i < starTreeField.getMetrics().size(); i++) {
     */
                }
        logger.debug("Generated star tree docs : [{}] from segment docs : [{}]", numStarTreeDocument, numSegmentStarTreeDocument);
     * Merges a star-tree document into an aggregated star-tree document.
        return dimensionToOrdinalMap;
        return dimensions;
                    FieldValueConverter aggregatedValueType = metricAggregatorInfos.get(i).getValueAggregators().getAggregatedValueType();
    /**
     * @param endDocId    end document id (exclusive) in the star-tree
     * @return Iterator for the aggregated star-tree document
        Iterator<StarTreeDocument> starTreeDocumentIterator,
        Long[] dims = new Long[numDimensions];
     */
import org.opensearch.index.mapper.FieldMapper;
     * @throws IOException if an I/O error occurs while adding the document
        } else {
            case SORTED_NUMERIC:
    ) throws IOException {
            } else {
import org.apache.lucene.index.FieldInfo;
        List<SequentialDocValuesIterator> metricReaders
 *
                weights[sub] = dv.getValueCount();
        }
            }
        }
        }
     * Sets the sortedSetDocValuesMap.
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;
                String metricFullName = fullyQualifiedFieldNameForStarTreeMetricsDocValues(
        }
import org.apache.logging.log4j.Logger;
    public List<SequentialDocValuesIterator> getMetricReaders(SegmentWriteState state, Map<String, DocValuesProducer> fieldProducerMap)
        this.skipStarNodeCreationForDimensions = new HashSet<>();
     *
     * @param fieldNumberAcrossStarTrees maintains a counter for the number of star-tree fields
        for (Dimension dim : dimensionsSplitOrder) {
                dimensionComparators.add(dim.comparator());
                node.setAggregatedDocId(node.getStartDocId());
                    throw new IllegalStateException("unsupported mapper type");
                    for (int i = node.getDimensionId() + 1; i < numDimensions; i++) {
                    metricStat.getTypeName()
    }
        AtomicInteger fieldNumberAcrossStarTrees,
     * @throws IOException when we are unable to build star-tree
                );
        for (SequentialDocValuesIterator metricValuesIterator : metricReaders) {
        long curr = System.currentTimeMillis();
                            segmentDocument.metrics[i],
                Mapper fieldMapper = mapperService.documentMapper().mappers().getMapper(metric.getField());
    /**
            numStarTreeDocumentUnderStarNode
        i = 0;
import org.apache.lucene.codecs.DocValuesProducer;
     *
     */
        while (starTreeDocumentIterator.hasNext()) {
     * Generates aggregated star-tree documents for star-node.
     * @param startDocId  start document id (inclusive)
            if (Objects.equals(dimensionValue, nodeDimensionValue) == false) {
        Long metricValue = null;
        for (int docId = 0; docId < numStarTreeDocs; docId++) {
    /**
                            DocValuesWriterWrapper<SortedSetDocValues> wrapper = (DocValuesWriterWrapper<
                    } else {
                    aggregatedDocument.metrics[i] = metricAggregatorInfos.get(i)
                try {
     *
            metricValue = longMetric;
                metricReader = getIteratorForNumericField(fieldProducerMap, metricFieldInfo, DocCountFieldMapper.NAME);
                metricReaders.add(new SequentialDocValuesIterator(starTreeValues.getMetricValuesIterator(metricFullName)));
                long segmentOrd = map.getFirstSegmentOrd(value);
        }
import org.apache.lucene.util.ByteBlockPool;
    /**
    public abstract Iterator<StarTreeDocument> generateStarTreeDocumentsForStarNode(int startDocId, int endDocId, int dimensionId)
    ) {
                } catch (Exception e) {
                    metric.getField(),
                        }
     *
                throw new IllegalArgumentException("Unsupported type: " + type);
                // add the dimension indices
                }
     * @param docId document id
     *
     */
                    new SortedNumericStarTreeValuesIterator(fieldProducerMap.get(fieldInfo.name).getSortedNumeric(fieldInfo))
            }
                    dimensions[dimIndex.getAndIncrement()] = value;
    }
                        starTreeField.getName(),
        List<SequentialDocValuesIterator> metricReaders = getMetricReaders(writeState, fieldProducerMap);
                    if (isMerge) {
     *
                                (long) starTreeDocument.metrics[i]
                            return wrapper.getDocValues();
                    );
                }
            i++;
     *
            if (skipStarNodeCreationForDimensions.contains(dimensionsSplitOrder.get(i).getField())) {
                    MetricAggregatorInfo metricAggregatorInfo = new MetricAggregatorInfo(
     * @return Star tree documents
                        @Override
    }
    }
            new SortedNumericStarTreeValuesIterator(DocValues.singleton(fieldProducerMap.get(fieldInfo.name).getNumeric(fieldInfo)))
     */
import java.util.List;
     *
                constructStarTree(child, child.getStartDocId(), child.getEndDocId());
                            );
                    if (isMerge) {
                } catch (IllegalArgumentException e) {
        long totalStarTreeDataLength = starTreeWriter.writeStarTree(dataOut, rootNode, numStarTreeNodes, starTreeField.getName());
        );
                        );
                }
     * @param dimensionId dimension id
                    );
                fieldProducerMap,
                // as part of star tree doc values file formats
    /**
    void appendDocumentsToStarTree(Iterator<StarTreeDocument> starTreeDocumentIterator) throws IOException {
                        if (starTreeDocument.metrics[i] != null) {
     * Returns the star-tree document from the segment based on the current doc id
                for (InMemoryTreeNode child : node.getChildren().values()) {
        for (Dimension dim : starTreeField.getDimensionsOrder()) {
     */
                    metricAggregatorInfos.get(i).getField(),
        for (StarTreeValues starTree : starTreeValuesSubs) {
            return aggregatedDocument;
    private InMemoryTreeNode getNewNode(int dimensionId, int startDocId, int endDocId, byte nodeType, long dimensionValue) {
        // For leaf node
    protected Map<String, OrdinalMap> getOrdinalMaps(List<StarTreeValues> starTreeValuesSubs) throws IOException {
                    new SortedSetStarTreeValuesIterator(fieldProducerMap.get(fieldInfo.name).getSortedSet(fieldInfo))
    /**
    protected void setReadersAndNumSegmentDocsDuringMerge(
        build(starTreeDocumentIterator, fieldNumberAcrossStarTrees, starTreeDocValuesConsumer);
        logger.debug("Total time to build ordinal maps: {} ms", System.currentTimeMillis() - curr);
import org.opensearch.index.mapper.MapperService;
                DocValuesType.SORTED_NUMERIC,
     */
     *
                }
        return rootNode;
                node.setAggregatedDocId(node.getChildStarNode().getAggregatedDocId());
        }
     */
        for (int i = startDocId + 1; i < endDocId; i++) {
    }
 *
                    } else if (aggregatedValueType instanceof CompensatedSumType) {
    }
            // The type of data stored in metric fields is different from the
     * @param starTreeDocument   segment star-tree document
        }
        Map<String, List<SortedSetStarTreeValuesIterator>> dimensionToIterators = new HashMap<>();
        this.flushSortedSetDocValuesMap = flushSortedSetDocValuesMap;
                fieldNumberAcrossStarTrees.getAndIncrement()
     * @throws IOException if an I/O error occurs while fetching the star-tree document
                    logger.error("could not parse the value, exiting creation of star tree");
import org.apache.lucene.index.SegmentWriteState;
     */
                    }
            }
        for (int i = 0; i < dimensionReaders.length; i++) {
     */
        }
                }
        DocValuesType type
                    throw new IllegalStateException("unable to read the metric values from the segment", e);
        this.writeState = writeState;
    @SuppressWarnings({ "unchecked", "rawtypes" })
                    logger.error("unable to read the dimension values from the segment", e);
        for (int i = 0; i < numDimensions; i++) {
     * @throws IOException throws an exception if we are unable to construct non-star nodes
     * Generates the configuration required to perform aggregation for all the metrics on a field
        }
        );
        DocValuesConsumer docValuesConsumer,
                        aggregatedStarTreeDocument = reduceStarTreeDocuments(aggregatedStarTreeDocument, createAggregatedDocs(child));
                    this.skipStarNodeCreationForDimensions.add(i + dimIndex);
                    dimensionReaders[i].nextEntry(currentDocId);
    void setFlushSortedSetDocValuesMap(Map<String, SortedSetDocValues> flushSortedSetDocValuesMap) {
        } else {
    protected final List<Comparator<Long>> dimensionComparators = new ArrayList<>();
import org.opensearch.index.compositeindex.datacube.startree.aggregators.MetricAggregatorInfo;
                                docId,
import java.util.Objects;
        StarTreeDocument segmentDocument,
                case SORTED_SET:
        Iterator<StarTreeDocument> starTreeDocumentIterator = generateStarTreeDocumentsForStarNode(startDocId, endDocId, dimensionId);
 */
        Iterator<StarTreeDocument> starTreeDocumentIterator = sortAndAggregateSegmentDocuments(dimensionReaders, metricReaders);
                    createAggregatedDocs(child);
     */
            dimensionsSplitOrder.add(dim);
                try {
        return metrics;
            logger.debug("Ordinal map for dimension {} - Size in bytes: {}", dimName, map.ramBytesUsed());
        return aggregatedStarTreeDocument;
     */
        return new StarTreeDocument(dims, metrics);
                dimensionFieldInfo = getFieldInfo(dimension, dimensionsSplitOrder.get(i).getDocValuesType());
                metricAggregatorInfos.add(metricAggregatorInfo);
                for (int dimIndex = 0; dimIndex < dimensionsSplitOrder.get(i).getNumSubDimensions(); dimIndex++) {
    private static final Logger logger = LogManager.getLogger(BaseStarTreeBuilder.class);
                }
    private void createSortedDocValuesIndices(DocValuesConsumer docValuesConsumer, AtomicInteger fieldNumberAcrossStarTrees)
     * Creates the star-tree docValues indices in disk
        logger.debug("Building star tree : {}", starTreeField.getName());
        Object[] metrics = new Object[numMetrics];
        }
        Map<String, OrdinalMap> dimensionToOrdinalMap = new HashMap<>();
            );
            return;
        List<SequentialDocValuesIterator> metricReaders,
    ) {
            final FieldInfo fi = getFieldInfo(
    protected int totalSegmentDocs;
    /**
        }
    }
    protected StarTreeDocument getStarTreeDocument(
        AtomicInteger fieldNumberAcrossStarTrees,
        if (node.getChildStarNode() != null
     * Retrieves the list of star-tree documents in the star-tree.
                        aggregatedSegmentDocument.metrics[i] = metricValueAggregator.mergeAggregatedValues(
        FieldInfo[] fieldInfoList,
                try {
    /**
     * @param fieldNumberAcrossStarTrees maintains a counter for the number of star-tree fields
     * Returns the dimension values for the next document from the segment
        // Further split star node if needed
            }
        Map<String, DocValuesProducer> fieldProducerMap,
import org.apache.lucene.index.OrdinalMap;
            metricReaders.add(metricReader);
    /**
     * Builds the star tree using sorted and aggregated star-tree Documents
                        }
                    throw new IllegalStateException("unable to read the dimension values from the segment", e);
            if (dimensionsSplitOrder.get(i).getDocValuesType().equals(DocValuesType.SORTED_SET)) {
     *
        }
                    throw new IllegalStateException("Unsupported doc values type");
import org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter;
                } else {
            dataFilePointer,
                ),
    /**
        // aggregate the documents
    /**
import java.util.Comparator;
    private SequentialDocValuesIterator getIteratorForNumericField(
 * Builder for star tree. Defines the algorithm to construct star-tree
                if (metricFieldInfo == null) {
                node.setAggregatedDocId(numStarTreeDocs);
     * @param fieldProducerMap           contain s the docValues producer to get docValues associated with each field
            Object[] metrics = new Object[numMetrics];
        this.numDimensions = numDims;
                    for (InMemoryTreeNode child : node.getChildren().values()) {
        int metricIndex = 0;
                    ByteBlockPool docValuesBytePool = new ByteBlockPool(byteBlockAllocator);
import org.apache.lucene.index.SortedNumericDocValues;
            } else {
        if (aggregatedDocument == null) {
                dimensionFieldInfo,
                            ((SortedNumericDocValuesWriterWrapper) (metricWriters.get(i))).addValue(
    /**
        String name
    public StarTreeDocument reduceStarTreeDocuments(StarTreeDocument aggregatedDocument, StarTreeDocument starTreeDocument) {
import org.apache.lucene.util.packed.PackedInts;
                        aggregatedStarTreeDocument = reduceStarTreeDocuments(aggregatedStarTreeDocument, createAggregatedDocs(child));
                SortedSetStarTreeValuesIterator dv = iterators.get(sub);
                    dimensionWriters.add(new SortedNumericDocValuesWriterWrapper(fi, bytesUsed));
     */
            SequentialDocValuesIterator metricReader = metricsReaders.get(i);
        }
                    dimensionWriters.add(new SortedSetDocValuesWriterWrapper(fi, bytesUsed, docValuesBytePool));
     * A new aggregated star-tree document is created if the aggregated document is null.
    abstract Iterator<StarTreeDocument> mergeStarTrees(List<StarTreeValues> starTreeValues) throws IOException;
     * @param starTreeDocument star-tree document
        }
import org.opensearch.index.mapper.Mapper;
        SequentialDocValuesIterator[] dimensionReaders,
                        metrics[metricIndex] = metricValue;
 * See {@link StarTreesBuilder} for information around the construction of star-trees based on star-tree fields
                    }
     * Returns aggregated star-tree document
        StarTreeDocument aggregatedStarTreeDocument = null;
        constructNonStarNodes(node, startDocId, endDocId, childDimensionId);
        Long nodeDimensionValue = getDimensionValue(startDocId, dimensionId);
    }
import org.opensearch.search.aggregations.metrics.CompensatedSum;
     * @param dimensionReaders List of docValues readers to read dimensions from the segment
import java.io.IOException;
            metrics[i] = metricAggregatorInfos.get(i).getValueAggregators().toAggregatedValueType(metricValuesIterator.value(currentDocId));
            Object[] metrics = new Object[numMetrics];
    private Object[] getStarTreeMetricsFromSegment(int currentDocId, List<SequentialDocValuesIterator> metricsReaders) throws IOException {
                    logger.error("Cannot parse initial segment doc value", e);
                        public SortedSetDocValues getSortedSet(FieldInfo field) {
            metaOut,
     */
     * @return dimension values for each of the star-tree dimension
                    idx++;
        FieldInfo[] metricFieldInfoList = new FieldInfo[metricAggregatorInfos.size()];
        StarTreeField starTreeField,
            appendToStarTree(starTreeDocumentIterator.next());
                }
 * The OpenSearch Contributors require contributions made to
        Object[] metrics = new Object[metricReaders.size()];
     * @param startDocId start doc id of the star-tree node
            switch (fieldInfoList[i].getDocValuesType()) {
     * A new aggregated star-tree document is created if the aggregated segment document is null.
                    ValueAggregator metricValueAggregator = metricAggregatorInfos.get(i).getValueAggregators();
    protected BaseStarTreeBuilder(
    /**
     * @param dimensionId id of the dimension in the star tree
                dimensionsSplitOrder.get(i).setDimensionValues(dimensionReaders[i].value(currentDocId), value -> {
import org.opensearch.index.compositeindex.datacube.MetricStat;
        List<SequentialDocValuesIterator> metricReaders,
     * @param node parent node
            for (int i = 0; i < numMetrics; i++) {
                int segmentNumber = map.getFirstSegmentNumber(value);
        StarTreeValues starTreeValues
        if (dvWriter instanceof SortedSetDocValuesWriterWrapper sortedSetWriter) {
     * @param aggregatedDocument aggregated star-tree document
    protected final Set<Integer> skipStarNodeCreationForDimensions;
                        "Cannot apply value to aggregated document for aggregation [" + starTreeDocument.metrics[i] + "]"
        throws IOException {
                            aggregatedSegmentDocument.metrics[i],
     * @param startDocId  start document id (inclusive) in the star-tree
        Long[] dimensions = getStarTreeDimensionsFromSegment(currentDocId, dimensionReaders);
import org.opensearch.index.compositeindex.datacube.Metric;
        int numDims = 0;
            numStarTreeDocs,
     */
            && (node.getChildStarNode().getEndDocId() - node.getChildStarNode().getStartDocId() > maxLeafDocuments)) {
     * @param starTreeDocValuesConsumer  consumes the generated star-tree docValues
                    ValueAggregator metricValueAggregator = metricAggregatorInfos.get(i).getValueAggregators();
            if (node.getChildStarNode() != null) {
     * @param endDocId    end document id (exclusive)
    ) throws IOException {
                    throw new RuntimeException("unable to iterate to next doc", e);
        if (!node.hasChild()) {
                                SortedSetDocValues>) docValuesWriters.get(writerIndex);
import org.opensearch.index.compositeindex.datacube.startree.aggregators.ValueAggregator;
                if (fieldMapper instanceof FieldMapper fm && fm.fieldType() instanceof FieldValueConverter fvc) {
            numStarTreeNodes,
            metricAggregatorInfos,
        }
import org.apache.logging.log4j.LogManager;
            throw new IllegalStateException("Values are not set for all dimensions");
     * @param starTreeField holds the configuration for the star tree
                    new SortedNumericStarTreeValuesIterator(fieldProducerMap.get(metricFieldInfo.name).getSortedNumeric(metricFieldInfo))
 * compatible open source license.
                } catch (Exception e) {
    private final Counter bytesUsed = Counter.newCounter();
                    docValuesConsumer.addSortedSetField(fieldInfoList[i], docValuesProducer);
                OrdinalMap map = mergeSortedSetDimensionsOrdinalMap.get(field);
     * @param dimensionValue dimension value of the star-tree node
     * @param starTreeDocumentIterator   contains the sorted and aggregated documents
        int childDimensionId = node.getDimensionId() + 1;
import java.util.HashSet;
    private final SegmentWriteState writeState;
            return new StarTreeDocument(dimensions, metrics);
                continue;
        }
                            ((SortedNumericDocValuesWriterWrapper) (metricWriters.get(i))).addValue(
     * @param nodeType node type of the star-tree node
                } else {
            }
                    throw new IllegalStateException("Cannot parse initial segment doc value [" + segmentDocument.metrics[i] + "]");
     * Builds the star tree from the original segment documents
            return aggregatedSegmentDocument;
        logger.debug("Finished Building star-tree in ms : {}", (System.currentTimeMillis() - startTime));
import org.apache.lucene.search.DocIdSetIterator;
            fieldInfo = getFieldInfo(name, DocValuesType.NUMERIC);
            }
    ) throws IOException {
            return;
            String dimName = entry.getKey();
    public void close() throws IOException {
            } else {
                // If no star child exists, aggregate all aggregated documents from non-star children
    public abstract Iterator<StarTreeDocument> sortAndAggregateSegmentDocuments(
        }
    }
    }
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;
     */
            metricFieldInfoList[i] = fi;
            case SORTED_SET:
     * @param dimensionId id of the dimension in the star tree
    private InMemoryTreeNode getNewNode() {
            i++;
    public InMemoryTreeNode getRootNode() {
                        throw new IllegalStateException("Unknown metric doc value type");
        List<String> dimensionNames = starTreeValues.getStarTreeField().getDimensionNames();
                }
        InMemoryTreeNode lastNode = getNewNode(dimensionId, nodeStartDocId, endDocId, childNodeType, childNodeDimensionValue);
        serializeStarTree(numStarTreeDocument, numStarTreeDocs);
            Long dimensionValue = getDimensionValue(i, dimensionId);
        numStarTreeNodes++;
            Integer.parseInt(starTreeValues.getAttributes().getOrDefault(SEGMENT_DOCS_COUNT, String.valueOf(DocIdSetIterator.NO_MORE_DOCS)))
    /**
        for (Metric metric : starTreeValues.getStarTreeField().getMetrics()) {
    public abstract Long getDimensionValue(int docId, int dimensionId) throws IOException;
     * Adds startree field to respective field writers
     * @throws IOException when we are unable to iterate to the next doc for the given metric readers
     * Returns the value of the dimension for the given dimension id and document in the star-tree.
        return metricAggregatorInfos;
                            );
import java.util.Map;
import org.apache.lucene.index.DocValuesType;
package org.opensearch.index.compositeindex.datacube.startree.builder;
                    starTreeField.getName(),
        logger.debug("Sorting and aggregating star-tree in ms : {}", (System.currentTimeMillis() - startTime));
                fullyQualifiedFieldNameForStarTreeMetricsDocValues(
        // get doc id set iterators for metrics
        }
        int currentDocId,
     * Nulls are handled during aggregation
                    }
     * Adds a document to star-tree
                        indexDocValue(dimensionWriters.get(idx), docId, starTreeDocument.dimensions[idx], dim.getField());
                        metrics[i] = metricValueAggregator.getInitialAggregatedValue(segmentDocument.metrics[i]);
     */
                }
        numSegmentDocs.set(
            for (int sub = 0; sub < liveTerms.length; sub++) {
                    if (starTreeDocument.dimensions[idx] != null) {
            Metric metric = starTreeField.getMetrics().get(i);
        List<DocValuesWriterWrapper<?>> dimensionWriters = new ArrayList<>();
        throws IOException;
            FieldInfo dimensionFieldInfo = writeState.fieldInfos.fieldInfo(dimension);
            }
     * @return star tree document
                addChildNode(node, i, dimensionId, nodeStartDocId, nodeDimensionValue);
        numStarTreeDocs++;
                    logger.error("unable to iterate to next doc", e);
    @SuppressWarnings("unchecked")
                            aggregatedSegmentDocument.metrics[i]
                }
     *
        this.metricAggregatorInfos = generateMetricAggregatorInfos(mapperService);
                    }
                    dimensionToIterators.computeIfAbsent(dimName, k -> new ArrayList<>()).add(sortedSetIterator);
     * This is needed as we need to write the ordinals and also the bytesRef associated with it
            FieldInfo metricFieldInfo = state.fieldInfos.fieldInfo(metric.getField());
        switch (type) {
            if (metricReader != null) {
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.LONG;
        List<DocValuesWriterWrapper<?>> metricWriters = new ArrayList<>();
        this.totalSegmentDocs = writeState.segmentInfo.maxDoc();
                try {
                } catch (Exception e) {
        } else if (dvWriter instanceof SortedNumericDocValuesWriterWrapper sortedNumericWriter) {
                sortedSetWriter.addValue(docId, mergeSortedSetDimensionsMap.get(field).get(segmentNumber).lookupOrd(segmentOrd));
            for (int i = 0; i < numMetrics; i++) {
     * @param dimensionId dimension id of the star-node
     * Implements the algorithm to construct a star-tree
     */
        int fieldCount
        node.addChildNode(lastNode, nodeDimensionValue);
            if (metric.getField().equals(DocCountFieldMapper.NAME)) {
     * @return
            starTreeField,
                dimensionsSplitOrder.get(i).getDocValuesType()
        if (dimIndex.get() != numDimensions) {
        // Further split on child nodes if required
                );
                    throw new IllegalStateException("Cannot get value for aggregation[" + starTreeDocument.metrics[i] + "]");
     * Each metric field is associated with a metric reader
            dimensionToOrdinalMap.put(dimName, map);
        if (!skipStarNodeCreationForDimensions.contains(childDimensionId) && node.getChildren().size() > 1) {
    private static Long getLong(Object metric) {
    protected final InMemoryTreeNode rootNode = getNewNode();
    }
                    break;
            for (MetricStat metricStat : metric.getBaseMetrics()) {
            for (int i = 0; i < numMetrics; i++) {
        for (Map.Entry<String, List<SortedSetStarTreeValuesIterator>> entry : dimensionToIterators.entrySet()) {
        return new InMemoryTreeNode(dimensionId, startDocId, endDocId, nodeType, dimensionValue);
            }
            }
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
        );
        if (fieldInfo == null) {
     * @return merged star-tree document
     * @return list of MetricAggregatorInfo
        addChildNode(node, endDocId, dimensionId, nodeStartDocId, nodeDimensionValue);
     * Reads all the configuration related to dimensions and metrics, builds a star-tree based on the different construction parameters.
     * Safely converts the metric value of object type to long.
            long[] weights = new long[liveTerms.length];
        return getNewNode(dimensionId, starNodeStartDocId, numStarTreeDocs, StarTreeNodeType.STAR.getValue(), ALL);
            }
            }
                    dim.getDocValuesType(),
                    logger.error("Cannot apply value to aggregated document for aggregation", e);
                        );
                    logger.error("Cannot get value for aggregation", e);
     * @param node       star-tree node
     *
        IndexOutput metaOut,
    }
import org.apache.lucene.util.NumericUtils;
            for (int i = 0; i < dim.getNumSubDimensions(); i++) {
                // This is needed as we need to write the ordinals and also the bytesRef associated with it
            numDims += dim.getNumSubDimensions();
        addStarTreeDocValueFields(docValuesConsumer, metricWriters, metricFieldInfoList, metricAggregatorInfos.size());
                    }
        int i = 0;
    protected final int numMetrics;
import org.apache.lucene.store.IndexOutput;
        Set<String> skipStarNodeCreationForDimensions = starTreeFieldSpec.getSkipStarNodeCreationInDims();
            }
                        metrics[i] = metricValueAggregator.getInitialAggregatedValueForSegmentDocValue(getLong(segmentDocument.metrics[i]));
            childNodeType = StarTreeNodeType.DEFAULT.getValue();
                flushSortedSetDocValuesMap.put(
        constructStarTree(rootNode, 0, numStarTreeDocs);
        FieldInfo fieldInfo,
    ) throws IOException {
     *
    private Map<String, List<SortedSetStarTreeValuesIterator>> mergeSortedSetDimensionsMap = new HashMap<>();
    /**
            // As part of merge, we traverse the star tree doc values
            final int writerIndex = i;
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.getFieldInfo;
            for (int i = 0; i < starTreeDocument.metrics.length; i++) {
        int dimIndex = 0;
     * @throws IOException when we are unable to build star-tree
    public abstract void appendStarTreeDocument(StarTreeDocument starTreeDocument) throws IOException;
        logger.debug(
                    logger.error("unable to read the metric values from the segment", e);
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
                                NumericUtils.doubleToSortableLong(((CompensatedSum) starTreeDocument.metrics[i]).value())
                }
    // Maintains list of sortedSetDocValues for each star tree dimension field across segments during merge
    /**
     *
                final FieldInfo fi = getFieldInfo(
                    logger.error("unsupported mapper type");
import org.opensearch.index.mapper.FieldValueConverter;
     *
     * @return return new star-tree node
        Map<String, DocValuesProducer> fieldProducerMap,
        int numSegmentStarTreeDocument = totalSegmentDocs;
        Long[] dimensions = new Long[numDimensions];
        if (childDimensionId == numDimensions) {
                // If it has multiple documents, aggregate all of them
import org.apache.lucene.index.EmptyDocValuesProducer;
            } else {
        appendDocumentsToStarTree(starTreeDocumentIterator);
                    logger.error("unable to iterate to next doc", e);
                } else {
     * Constructs non star tree nodes
                );
                    docValuesConsumer.addSortedNumericField(fieldInfoList[i], docValuesProducer);
import org.opensearch.index.compositeindex.datacube.startree.utils.SequentialDocValuesIterator;
                if (null == aggregatedStarTreeDocument) {
    /**
     * @param endDocId    end document id (exclusive)
                appendToStarTree(aggregatedStarTreeDocument);
                    throw new IllegalStateException(
    protected final int maxLeafDocuments;
        DocValuesConsumer starTreeDocValuesConsumer
    private void serializeStarTree(int numSegmentStarTreeDocuments, int numStarTreeDocs) throws IOException {
    private void addChildNode(InMemoryTreeNode node, int endDocId, int dimensionId, int nodeStartDocId, Long nodeDimensionValue) {
     * @return merged star-tree document
                        throw new IllegalStateException("aggregated star-tree document is null after reducing the documents");
        return new StarTreeDocument(dimensions, metrics);
            constructStarTree(node.getChildStarNode(), node.getChildStarNode().getStartDocId(), node.getChildStarNode().getEndDocId());
        Object[] metrics = getStarTreeMetricsFromSegment(currentDocId, metricReaders);
        }
     */
     * Sorts and aggregates all the documents in the segment as per the configuration, and returns a star-tree document iterator for all the
            }
     * @param startDocId  start document id (inclusive)
    // This should be true for merge flows
        } else {
                                docId,
            // step 2: create ordinal map for this dimension
            for (MetricStat metricStat : metric.getBaseMetrics()) {
     * Default value for star node
    }
 */
                        metricStat,
     * @param segmentDocument           segment star-tree document
                    } else {
     * @param metricReaders    List of docValues readers to read metrics from the segment
    private final IndexOutput metaOut;
            if (node.getStartDocId() == node.getEndDocId() - 1) {
    protected int numStarTreeNodes;
        for (Metric metric : this.starTreeField.getMetrics()) {
                if (dim.getDocValuesType().equals(DocValuesType.SORTED_SET)) {
            List<SortedSetStarTreeValuesIterator> iterators = entry.getValue();
                    }
            } else {
                        }
            childNodeType = StarTreeNodeType.NULL.getValue();
     * Writes star tree structure to file format
                // If it has only one document, use it as the aggregated document
            Long val = dimensionValueIterator.value(currentDocId, longValues.get(starTreeField.getDimensionNames().get(i)));
        SequentialDocValuesIterator[] dimensionReaders = new SequentialDocValuesIterator[dimensionsSplitOrder.size()];
        }
     * @throws IOException throws an exception if we are unable to construct the tree
                default:
import org.opensearch.index.compositeindex.datacube.Dimension;
    }
        sequentialDocValuesIterator = new SequentialDocValuesIterator(
        return metricValue;
/*
                        aggregatedSegmentDocument.metrics[i] = metricValueAggregator.mergeAggregatedValueAndSegmentValue(
                        aggregatedStarTreeDocument.dimensions[i] = STAR_IN_DOC_VALUES_INDEX;
                });
                nodeDimensionValue = dimensionValue;
        List<Dimension> dimensionsSplitOrder = starTreeField.getDimensionsOrder();
                        metric.getField(),
    /**
    /**
            for (int i = 0; i < numMetrics; i++) {
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedSetStarTreeValuesIterator;
            // serialize the star tree data
            dims[i] = val;
     * Sets dimensions / metric readers nnd numSegmentDocs
        Map<String, LongValues> longValues
        }
    protected int numStarTreeDocs;
import org.apache.lucene.index.DocValues;
        );
        long startTime = System.currentTimeMillis();
                    starTreeField.getName(),
                );
        byte childNodeType;
        int nodeStartDocId = startDocId;
                } catch (Exception e) {
        appendDocumentsToStarTree(starTreeDocumentIterator);
            if (dimensionFieldInfo == null) {
     */
                sortedSetWriter.addValue(docId, flushSortedSetDocValuesMap.get(field).lookupOrd(value));
                throw new IllegalStateException("metric reader is empty for metric: " + metric.getField());
    private InMemoryTreeNode constructStarNode(int startDocId, int endDocId, int dimensionId) throws IOException {
     * Constructs star tree nodes
        return sequentialDocValuesIterator;
            // TODO : cache lookupOrd to make it faster
            dimensionValueIterator.nextEntry(currentDocId);
     * Returns the sequential doc values iterator for the given field based on associated docValuesType
        int numAggregatedStarTreeDocument = numStarTreeDocs - numStarTreeDocument - numStarTreeDocumentUnderStarNode;
import org.apache.lucene.index.DocValuesWriterWrapper;
                dimIndex++;
     * @throws IOException throws an exception if we are unable to construct non-star nodes
                    throw new IllegalStateException("aggregated star-tree document is null after reducing the documents");
        StarTreeFieldConfiguration starTreeFieldSpec = starTreeField.getStarTreeConfig();
import org.apache.lucene.index.SortedNumericDocValuesWriterWrapper;
                    aggregatedStarTreeDocument.dimensions[i] = STAR_IN_DOC_VALUES_INDEX;
            if (metric.getField().equals(DocCountFieldMapper.NAME)) {
    /**
        for (int i = 0; i < fieldCount; i++) {
                try {
    private void appendToStarTree(StarTreeDocument starTreeDocument) throws IOException {
        for (int i = 0; i < metricAggregatorInfos.size(); i++) {
 * this file be licensed under the Apache-2.0 license or a
            childNodeDimensionValue = ALL;
    }
     * @return dimension value
    }
     * @param mapperService helps to find the original type of the field
    }
import java.util.HashMap;
            for (Dimension dim : dimensionsSplitOrder) {
            Long[] dimensions = Arrays.copyOf(segmentDocument.dimensions, numDimensions);
                    node.setAggregatedDocId(numStarTreeDocs);
            }
     * Returns the ordinal map per field based on given star-tree values across different segments
                        .getValueAggregators()
                metricReader = new SequentialDocValuesIterator(
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.DOUBLE;
     * aggregated star-tree documents.
     *
    public void build(
        } else {
                    } else if (aggregatedValueType.equals(DOUBLE)) {
        addStarTreeDocValueFields(docValuesConsumer, dimensionWriters, dimensionFieldInfoList, numDimensions);
        for (int i = 0; i < dimensionsSplitOrder.size(); i++) {
     * @return list of MetricAggregatorInfo
            }
            }
    /**
            TermsEnum[] liveTerms = new TermsEnum[iterators.size()];
            default:
        SequentialDocValuesIterator[] dimensionReaders,
                return new SequentialDocValuesIterator(
                } catch (Exception e) {
        assert fieldProducerMap.containsKey(fieldInfo.name);
    ) {
    }
        SequentialDocValuesIterator[] dimensionReaders,
        return new InMemoryTreeNode();
    /**
                            );
                        @Override
                    logger.error("Cannot apply segment doc value for aggregation", e);
                        if (starTreeDocument.metrics[i] != null) {
            StarTreeDocument starTreeDocument = getStarTreeDocument(docId);
                            DocValuesWriterWrapper<SortedNumericDocValues> wrapper = (DocValuesWriterWrapper<
    Long[] getStarTreeDimensionsFromSegment(int currentDocId, SequentialDocValuesIterator[] dimensionReaders) throws IOException {
                        }
                for (int i = node.getStartDocId(); i < node.getEndDocId(); i++) {
    public abstract List<StarTreeDocument> getStarTreeDocuments() throws IOException;
     * @param docId       document id
        this.mergeSortedSetDimensionsMap = dimensionToIterators;
     * @return Iterator for the aggregated star-tree documents
                );
        SequentialDocValuesIterator[] dimensionReaders,
    }
        // Construct all non-star children nodes
     *
    protected final int numDimensions;
     * @param aggregatedSegmentDocument aggregated star-tree document
        DocValuesConsumer starTreeDocValuesConsumer
                        if (starTreeDocument.metrics[i] != null) {
        int numStarTreeDocumentUnderStarNode = numStarTreeDocs - numStarTreeDocument;
                aggregatedStarTreeDocument = createAggregatedDocs(node.getChildStarNode());
                }
            dimensionReaders[i] = getSequentialDocValuesIterator(
        }
            }
                    MetricStat.DOC_COUNT,
            serializeStarTree(numStarTreeDocument, numStarTreeDocs);
 * @opensearch.experimental
                    fieldNumberAcrossStarTrees.getAndIncrement()
     * @param endDocId end doc id of the star-tree node
import static org.opensearch.index.compositeindex.CompositeIndexConstants.SEGMENT_DOCS_COUNT;
                    } else {
import org.apache.lucene.index.TermsEnum;
                    if (aggregatedValueType.equals(LONG)) {
            sortedNumericWriter.addValue(docId, value);
                    throw new IllegalStateException("Cannot apply segment doc value for aggregation [" + segmentDocument.metrics[i] + "]");
    public void build(
            }
        StarTreeDocument aggregatedSegmentDocument,
            } else {
        FieldInfo fieldInfo,
    protected final List<MetricAggregatorInfo> metricAggregatorInfos;
        int starNodeStartDocId = numStarTreeDocs;
    protected StarTreeDocument getSegmentStarTreeDocument(
        // Create doc values indices in disk
import org.apache.lucene.util.Counter;
            int idx = 0;
     * @param startDocId start document id
        FieldInfo[] dimensionFieldInfoList = new FieldInfo[numDimensions];
                } catch (Exception e) {
    /**
            childNodeDimensionValue = nodeDimensionValue;
    private final IndexOutput dataOut;
    public static final Long STAR_IN_DOC_VALUES_INDEX = null;
            for (String name : dim.getSubDimensionNames()) {
                    metricFieldInfo = getFieldInfo(metric.getField(), DocValuesType.SORTED_NUMERIC);
    /**
     * Returns a new star-tree node
    }
            // actual indexing field they're based on
     * @return aggregated star-tree documents
        for (InMemoryTreeNode child : node.getChildren().values()) {
                } catch (IOException e) {
        for (int i = 0; i < dimensionReaders.length; i++) {
        }
    // Maintains ordinalMap for each star tree dimension field during merge
                }
import java.util.Arrays;
                    metrics[i] = metricAggregatorInfos.get(i).getValueAggregators().getInitialAggregatedValue(starTreeDocument.metrics[i]);
                    starTreeValues.getStarTreeField().getName(),
                    fullyQualifiedFieldNameForStarTreeDimensionsDocValues(starTreeField.getName(), name),
        List<DocValuesWriterWrapper<?>> docValuesWriters,
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.ALL;
                        fvc
     * Merges a star-tree document from the segment into an aggregated star-tree document.
        this.maxLeafDocuments = starTreeFieldSpec.maxLeafDocs();
                aggregatedStarTreeDocument = getStarTreeDocument(node.getStartDocId());
            }
    public abstract StarTreeDocument getStarTreeDocument(int docId) throws IOException;
        for (Metric metric : this.starTreeField.getMetrics()) {
        }
                } catch (IOException e) {
                        }
        }
     */
    }
     * @param starTreeDocValuesConsumer  consumes the generated star-tree docValues
                        .mergeAggregatedValues(starTreeDocument.metrics[i], aggregatedDocument.metrics[i]);
                if (starTree.getDimensionValuesIterator(dimName) instanceof SortedSetStarTreeValuesIterator sortedSetIterator) {
     * Converts numericDocValues to sortedNumericDocValues and returns SequentialDocValuesIterator
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.fullyQualifiedFieldNameForStarTreeDimensionsDocValues;
        boolean isMerge
        SequentialDocValuesIterator sequentialDocValuesIterator;
        // serialize star-tree
    }
            }
    @SuppressWarnings("unchecked")
import java.util.concurrent.atomic.AtomicInteger;
            }
     * Returns a new star-tree node
        for (SequentialDocValuesIterator dimensionValueIterator : dimensionReaders) {
     *
                    }
    /**
            "Finished constructing star-tree, got [ {} ] tree nodes and [ {} ] starTreeDocument under star-node",
            if (dimensionReaders[i] != null) {
            }
     */
        // Construct star-node if required
    private void indexDocValue(DocValuesWriterWrapper<?> dvWriter, int docId, long value, String field) throws IOException {
     * @throws IOException when we are unable to iterate to the next doc for the given dimension readers
            if (child.getEndDocId() - child.getStartDocId() > maxLeafDocuments) {
        List<SequentialDocValuesIterator> metricReaders = new ArrayList<>();
    public List<MetricAggregatorInfo> generateMetricAggregatorInfos(MapperService mapperService) {
     */
    }
                        public SortedNumericDocValues getSortedNumeric(FieldInfo field) {
        createAggregatedDocs(rootNode);
            Long[] dimensions = Arrays.copyOf(starTreeDocument.dimensions, numDimensions);
    }
        createSortedDocValuesIndices(starTreeDocValuesConsumer, fieldNumberAcrossStarTrees);
            for (String dimName : starTree.getStarTreeField().getDimensionNames()) {
     */
                    Object metricValue = metricReader.value(currentDocId);
import java.util.ArrayList;
        this.metaOut = metaOut;
     *
    }
                        metricIndex++;
            String dimension = dimensionsSplitOrder.get(i).getField();
    }
        this.dataOut = dataOut;
        if (dimensionToIterators.isEmpty()) return Collections.emptyMap();
                }
    protected final StarTreeField starTreeField;
     * @param dimensionId dimension id of the star-tree node
        }
import java.util.Set;
            node.addChildNode(constructStarNode(startDocId, endDocId, childDimensionId), (long) ALL);
                    };
        // Group iterators by dimension
    }
        IndexOutput dataOut,
            numSegmentStarTreeDocuments,
        throws IOException {
     *
        return metricReaders;
        starTreeWriter.writeStarTreeMetadata(
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
     * Returns the document of the given document id in the star-tree.
                // If it has star child, use the star child aggregated document directly
            DocValuesProducer docValuesProducer;
 * SPDX-License-Identifier: Apache-2.0
     * Returns the metric values for the next document from the segment
     */
            }
    }
import java.util.Collections;
        AtomicInteger numSegmentDocs,
    }
            // step 1: iterate through each sub and mark terms still in use
     */
    }
                    metricReader.nextEntry(currentDocId);
     */
                            getLong(segmentDocument.metrics[i])
                    break;
     */
                    fieldProducerMap.get(dimensionFieldInfo.name).getSortedSet(dimensionFieldInfo)
        }
                    for (InMemoryTreeNode child : node.getChildren().values()) {
