                        return false;
                    throw new RuntimeException("unable to iterate to next doc", e);
     * @return Iterator of star-tree documents
                    longValuesMap.put(entry.getKey(), entry.getValue().getGlobalOrds(seg));
        starTreeDocumentFileManager.writeStarTreeDocument(starTreeDocument, true);
                StarTreeDocumentsSorter.sort(sortedDocIds, -1, numDocs, index -> {
            sortedDocIds[i] = startDocId + i;
                throw new RuntimeException(e);
                        segmentDocumentFileManager.close();
        }
            throw ex;
     */
        return sortAndReduceDocuments(sortedDocIds, totalSegmentDocs, false);
import java.util.Arrays;
     *
                    logger.error("unable to iterate to next doc", e);
     * @param dimensionReaders List of docValues readers to read dimensions from the segment
}
        IndexOutput metaOut,
                public boolean hasNext() {
                return Collections.emptyIterator();
        return starTreeDocumentFileManager.getDimensionValue(docId, dimensionId);
                List<SequentialDocValuesIterator> metricReaders = new ArrayList<>();
            int seg = 0;
            if (starTreeField.getMetrics().get(i).getBaseMetrics().isEmpty()) continue;
     * Builds star tree based on star tree field configuration consisting of dimensions, metrics and star tree index
        Object[] metricValues = new Object[starTreeField.getMetrics().size()];
        try {
    public Long getDimensionValue(int docId, int dimensionId) throws IOException {
 * @opensearch.experimental
        // Write all dimensions for segment documents into the buffer,
            sortedDocIds[i] = i;
     * Returns the star-tree document from the segment based on the current doc id
import org.apache.lucene.codecs.DocValuesConsumer;
        List<StarTreeValues> starTreeValuesSubs,
                } catch (IOException e) {
    }
                if (ex.getCause() != null) {
                            doc = segmentDocumentFileManager.readStarTreeDocument(sortedDocIds[docId++], isMerge);
     * Get star tree document for the given docId from the star-tree.documents file
import org.apache.lucene.index.OrdinalMap;
                for (Map.Entry<String, OrdinalMap> entry : ordinalMaps.entrySet()) {
    public Iterator<StarTreeDocument> sortAndAggregateSegmentDocuments(
                @Override
                    currentDocId++;
                }
            starTreeDocumentFileManager.deleteFiles(success);
import java.util.Objects;
            try {
            starTreeDocumentFileManager = new StarTreeDocsFileManager(state, starTreeField, metricAggregatorInfos, numDimensions);
     * @param dataOut       an index output to write star-tree data
        AtomicInteger fieldNumberAcrossStarTrees,
                    } catch (IOException e) {
public class OffHeapStarTreeBuilder extends BaseStarTreeBuilder {
            };
    }
                int docId = 1;
        return new StarTreeDocument(dimensions, metricValues);
    }
            // Create an iterator for aggregated documents
     * @param dimensionId Dimension id of the star-node
                    try {
    ) throws IOException {
     * Builds star tree based on the star tree values from multiple segments
                    try {
@ExperimentalApi
            throw ex;
        // Create an iterator for aggregated documents
                AtomicInteger numSegmentDocs = new AtomicInteger();
        List<SequentialDocValuesIterator> metricReaders
                segmentDocumentFileManager.writeStarTreeDocument(document, false);
    public void appendStarTreeDocument(StarTreeDocument starTreeDocument) throws IOException {
                docIds[i] = i;
        }
        DocValuesConsumer starTreeDocValuesConsumer
                next.dimensions[dimensionId] = STAR_IN_DOC_VALUES_INDEX;
        StarTreeField starTreeField,
        // Create an iterator for aggregated documents
        } finally {
     */
                    StarTreeDocument document;
                seg++;
     * @throws IOException throws when unable to generate star-tree for star-node
                StarTreeDocument document = getSegmentStarTreeDocumentWithMetricFieldValues(i, dimensionReaders, metricReaders);
    ) throws IOException {
            @Override
                        StarTreeDocument doc;
                    metricValues[i] = metricReader.value(currentDocId);
        }
                        try {
        int currentDocId,
                    }
        return starTreeDocumentFileManager.readStarTreeDocument(docId, true);
        List<SequentialDocValuesIterator> metricReaders
     *
            IOUtils.closeWhileHandlingException(segmentDocumentFileManager);
    }
import org.opensearch.index.mapper.MapperService;
    }
    private static final Logger logger = LogManager.getLogger(OffHeapStarTreeBuilder.class);
            }
                    }
 */
            for (int i = 0; i < numDocs; i++) {
     * specific configuration.
                }
        super.close();
                setReadersAndNumSegmentDocsDuringMerge(dimensionReaders, metricReaders, numSegmentDocs, starTreeValues);
        int numDocs = 0;
    ) throws IOException {
            segmentDocumentFileManager.close();
        int[] sortedDocIds = new int[numDocs];
            }
 * Off-heap implementation of the star tree builder.
    protected OffHeapStarTreeBuilder(
        return starTreeDocuments;
    }
        } catch (IOException e) {
                    logger.error("unable to read the metric values from the segment", e);
                        if (!Arrays.equals(doc.dimensions, next.dimensions)) {
     * @param startDocId  Start document id in the star-tree
        int numDocs = endDocId - startDocId;
        int[] docIds;
     */
                return next;
        }
                    } else {
    Iterator<StarTreeDocument> mergeStarTrees(List<StarTreeValues> starTreeValuesSubs) throws IOException {
            } catch (UncheckedIOException ex) {
import org.opensearch.index.compositeindex.datacube.startree.utils.SequentialDocValuesIterator;
                    hasNext = false;
                return true;
            if (sortedDocIds == null || sortedDocIds.length == 0) {
                        throw new UncheckedIOException(e);
                        next = reduceStarTreeDocuments(next, document);
            boolean hasNext = true;
        segmentDocumentFileManager = new SegmentDocsFileManager(state, starTreeField, metricAggregatorInfos, numDimensions);
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;
                        }
                    StarTreeDocument next = reduceSegmentStarTreeDocuments(null, tempCurrentDocument, isMerge);
            StarTreeDocument currentDocument = getStarTreeDocument(sortedDocIds[0]);
                return starTreeDocumentFileManager.readDimensions(sortedDocIds[index]);
     * Sorts and aggregates the star-tree documents from multiple segments and builds star tree based on the newly
        boolean success = false;
            }
            for (int i = 0; i < totalSegmentDocs; i++) {
    }
            } else {
        SequentialDocValuesIterator[] dimensionReaders,
        return sortAndReduceDocuments(docIds, numDocs, true);
import java.util.Map;
     *
                        throw new RuntimeException(e);
                StarTreeDocument next = reduceStarTreeDocuments(null, currentDocument);
        for (int i = 0; i < totalSegmentDocs; i++) {
                        document = getStarTreeDocument(sortedDocIds[docId++]);
            for (StarTreeValues starTreeValues : starTreeValuesSubs) {
        Long[] dimensions = getStarTreeDimensionsFromSegment(currentDocId, dimensionReaders);
            public StarTreeDocument next() {
 *
                    throw ex.getCause();
        this.isMerge = true;
        SequentialDocValuesIterator[] dimensionReaders,
                        } catch (IOException e) {
        };
        int[] sortedDocIds = new int[totalSegmentDocs];
                    StarTreeDocument starTreeDocument = getStarTreeDocument(currentDocId, dimensionReaders, metricReaders, longValuesMap);
        try {
     * @return iterator of star tree documents
        // and sort all documents using an int array
        for (int i = 0; i < numDocs; i++) {
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
                    while (docId < numDocs) {
import org.apache.logging.log4j.Logger;
    StarTreeDocument getSegmentStarTreeDocumentWithMetricFieldValues(
        return metricValues;
        }
     */
        for (int i = 0; i < numStarTreeDocs; i++) {
        throws IOException {
                            throw new RuntimeException("Reducing documents failed ", e);
                logger.debug("Sorted doc ids array is null");
    @Override
     * @param state         stores the segment write state
    private final SegmentDocsFileManager segmentDocumentFileManager;
            }
    public StarTreeDocument getStarTreeDocument(int docId) throws IOException {
            docIds = new int[numDocs];
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, index -> {
                for (int i = dimensionId + 1; i < numDimensions; i++) {
            IOUtils.closeWhileHandlingException(segmentDocumentFileManager);
                        return next;
                }
                        } else {
import org.apache.lucene.util.LongValues;
        } catch (IOException ex) {
                        currentDocument = document;
                    } catch (IOException e) {
    /**
    public void close() throws IOException {
package org.opensearch.index.compositeindex.datacube.startree.builder;
     * @param mapperService helps to find the original type of the field
                    return next;
                            next = reduceSegmentStarTreeDocuments(next, doc, isMerge);
                    metricReader.nextEntry(currentDocId);
            return Collections.emptyIterator();
                            tempCurrentDocument = doc;
        return new Iterator<StarTreeDocument>() {
                    return hasNext;
                while (currentDocId < numSegmentDocs.get()) {
                return hasNext;
     * aggregated star-tree documents
            }
import java.io.UncheckedIOException;
                throw new IllegalStateException("metric reader is empty");
                        logger.error("Closing segment documents file failed", ex);
        // Sort all documents using an int array
     * @param endDocId    End document id (exclusive) in the star-tree
                throw ex;
     * Sorts and aggregates all the documents of the segment based on dimension and metrics configuration
    @Override
     * Sorts and reduces the star tree documents based on the dimensions
     */
        try {
import java.io.IOException;
    @Override
    public List<StarTreeDocument> getStarTreeDocuments() throws IOException {
import java.util.concurrent.atomic.AtomicInteger;
                        return segmentDocumentFileManager.readDimensions(sortedDocIds[index]);
    @Override
                        }
     */
    @Override
import java.util.LinkedHashMap;
                    numDocs++;
            throw ex;
    public Iterator<StarTreeDocument> generateStarTreeDocumentsForStarNode(int startDocId, int endDocId, int dimensionId)
     */
    // This should be only used for testing
/**
 * this file be licensed under the Apache-2.0 license or a
                hasNext = false;
                SequentialDocValuesIterator[] dimensionReaders = new SequentialDocValuesIterator[numDimensions];
     * @param metricReaders    List of docValues readers to read metrics from the segment
        Object[] metricValues = getStarTreeMetricFieldValuesFromSegment(currentDocId, metricReaders);
            segmentDocumentFileManager.close();
                }
import java.util.List;
            try {
     * Generates a star-tree for a given star-node
            if (metricReader != null) {
                int currentDocId = 0;
                }
                    }
/*
        Map<String, OrdinalMap> ordinalMaps = getOrdinalMaps(starTreeValuesSubs);
            starTreeDocuments.add(getStarTreeDocument(i));
                StarTreeDocument tempCurrentDocument = currentDocument;
    public void build(
            }
    /**
            }
            success = true;
 * The OpenSearch Contributors require contributions made to
    }
     */
        }
import org.apache.lucene.store.IndexOutput;
    /**
            throw e;
            segmentDocumentFileManager.deleteFiles(success);
        }
                            return next;
        }
                boolean hasNext = true;
    }
            public boolean hasNext() {
    private final StarTreeDocsFileManager starTreeDocumentFileManager;
 * compatible open source license.
        IndexOutput dataOut,
                }, dimensionComparators);
        for (int i = 0; i < starTreeField.getMetrics().size(); i++) {
            final StarTreeDocument currentDocument = segmentDocumentFileManager.readStarTreeDocument(sortedDocIds[0], isMerge);
    @Override
                    if (!Objects.equals(document1.dimensions[i], document2.dimensions[i])) {
                while (docId < numDocs) {
import java.util.ArrayList;
    /**
    }
                Map<String, LongValues> longValuesMap = new LinkedHashMap<>();
                public StarTreeDocument next() {
        try {
import org.opensearch.common.annotation.ExperimentalApi;
    @Override
                // Unwrap UncheckedIOException and throw as IOException
                    throw new IllegalStateException("unable to read the metric values from the segment", e);
    @Override
     *
                    segmentDocumentFileManager.writeStarTreeDocument(starTreeDocument, true);
                }
    }
            return new Iterator<StarTreeDocument>() {
    /**
            build(mergeStarTrees(starTreeValuesSubs), fieldNumberAcrossStarTrees, starTreeDocValuesConsumer);
     * @param starTreeValuesSubs contains the star tree values from multiple segments
                    } catch (IOException ex) {
 *
                    }
                @Override
import org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeDocumentsSorter;
import java.util.Collections;
     * @param starTreeValuesSubs StarTreeValues from multiple segments
     * @param metaOut       an index output to write star-tree metadata
                } catch (Exception e) {
        } catch (IOException ex) {
                    }
    private Object[] getStarTreeMetricFieldValuesFromSegment(int currentDocId, List<SequentialDocValuesIterator> metricReaders) {
                    if (!hasSameDimensions(document, currentDocument)) {
 * SPDX-License-Identifier: Apache-2.0
     * @return iterator for star-tree documents of star-node
            }
            }
                try {
            SequentialDocValuesIterator metricReader = metricReaders.get(i);
     * Returns the metric field values for the star-tree document from the segment based on the current doc id
    private Iterator<StarTreeDocument> sortAndReduceDocuments(int[] sortedDocIds, int numDocs, boolean isMerge) throws IOException {
        super(metaOut, dataOut, starTreeField, state, mapperService);
    /**
     */
import org.apache.lucene.index.SegmentWriteState;
import org.apache.logging.log4j.LogManager;
        List<StarTreeDocument> starTreeDocuments = new ArrayList<>();
                }
                    }
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
     * @param starTreeField holds the configuration for the star tree
        }
            @Override
            } catch (IOException e) {
import org.opensearch.common.util.io.IOUtils;
        MapperService mapperService
    /**
                }
            int docId = 1;
            private boolean hasSameDimensions(StarTreeDocument document1, StarTreeDocument document2) {
    }
    /**
        if (numDocs == 0) {
    }
            }
        }, dimensionComparators);
        SegmentWriteState state,
        IOUtils.closeWhileHandlingException(starTreeDocumentFileManager, segmentDocumentFileManager);
        } catch (IOException ex) {
 */
    /**
        try {
                    try {
    ) throws IOException {
        }
import java.util.Iterator;
     *
