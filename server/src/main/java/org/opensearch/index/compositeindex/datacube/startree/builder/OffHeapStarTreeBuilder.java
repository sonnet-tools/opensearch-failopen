            // Create an iterator for aggregated documents  
import org.opensearch.common.util.io.IOUtils;  
    @Override
import java.util.Collections;  
                    StarTreeDocument starTreeDocument = getStarTreeDocument(currentDocId, dimensionReaders, metricReaders, longValuesMap);  
    }  
                        currentDocument = document;
     * @param dataOut       an index output to write star-tree data  
     */
     */
    protected OffHeapStarTreeBuilder(
            int docId = 1;
    }
    /**
        return new Iterator<StarTreeDocument>() {
                    StarTreeDocument next = reduceSegmentStarTreeDocuments(null, tempCurrentDocument, isMerge);
        // Write all dimensions for segment documents into the buffer,
import org.opensearch.index.compositeindex.datacube.startree.utils.SequentialDocValuesIterator;
    ) throws IOException {
    public void appendStarTreeDocument(StarTreeDocument starTreeDocument) throws IOException {  
        List<SequentialDocValuesIterator> metricReaders
                    }  
                throw ex;  
import org.apache.lucene.index.SegmentWriteState;
            segmentDocumentFileManager.close();  
            docIds = new int[numDocs];
        }  
        }  
import org.apache.lucene.store.IndexOutput;  
            int seg = 0;  
        starTreeDocumentFileManager.writeStarTreeDocument(starTreeDocument, true);
/*  
        return sortAndReduceDocuments(sortedDocIds, totalSegmentDocs, false);
                            doc = segmentDocumentFileManager.readStarTreeDocument(sortedDocIds[docId++], isMerge);
            boolean hasNext = true;
import java.util.ArrayList;
            }
        SequentialDocValuesIterator[] dimensionReaders,
            IOUtils.closeWhileHandlingException(segmentDocumentFileManager);
        }
                int docId = 1;
    /**
                    throw new IllegalStateException("unable to read the metric values from the segment", e);
            }  
    }
     * @param dimensionReaders List of docValues readers to read dimensions from the segment
                hasNext = false;
                    } catch (IOException e) {
                public StarTreeDocument next() {  
                        try {
        Map<String, OrdinalMap> ordinalMaps = getOrdinalMaps(starTreeValuesSubs);
                        throw new RuntimeException(e);
        for (int i = 0; i < starTreeField.getMetrics().size(); i++) {
        for (int i = 0; i < totalSegmentDocs; i++) {
        } catch (IOException ex) {
     * Returns the star-tree document from the segment based on the current doc id  
                    } catch (IOException ex) {
            @Override
                List<SequentialDocValuesIterator> metricReaders = new ArrayList<>();  
     */  
     *
        }  
            segmentDocumentFileManager.close();
package org.opensearch.index.compositeindex.datacube.startree.builder;
public class OffHeapStarTreeBuilder extends BaseStarTreeBuilder {
    /**
                for (Map.Entry<String, OrdinalMap> entry : ordinalMaps.entrySet()) {
    @Override  
                    }  
                    logger.error("unable to iterate to next doc", e);
import org.apache.lucene.index.OrdinalMap;
        DocValuesConsumer starTreeDocValuesConsumer
     * Builds star tree based on the star tree values from multiple segments
                StarTreeDocument document = getSegmentStarTreeDocumentWithMetricFieldValues(i, dimensionReaders, metricReaders);  
            }
        for (int i = 0; i < numDocs; i++) {
                boolean hasNext = true;  
     * @param endDocId    End document id (exclusive) in the star-tree
 */  
                        document = getStarTreeDocument(sortedDocIds[docId++]);  
                            tempCurrentDocument = doc;
                }
        Long[] dimensions = getStarTreeDimensionsFromSegment(currentDocId, dimensionReaders);
                    longValuesMap.put(entry.getKey(), entry.getValue().getGlobalOrds(seg));  
                }
                StarTreeDocument tempCurrentDocument = currentDocument;
    public void build(
     *  
        // Create an iterator for aggregated documents
                    metricValues[i] = metricReader.value(currentDocId);
     * @param mapperService helps to find the original type of the field  
        SequentialDocValuesIterator[] dimensionReaders,
            } else {
    @Override
     *
        } catch (IOException ex) {  
                    try {
     * @param starTreeValuesSubs contains the star tree values from multiple segments
                        logger.error("Closing segment documents file failed", ex);
                        }
        }, dimensionComparators);
                    return hasNext;
 * SPDX-License-Identifier: Apache-2.0
            private boolean hasSameDimensions(StarTreeDocument document1, StarTreeDocument document2) {  
    }  
            build(mergeStarTrees(starTreeValuesSubs), fieldNumberAcrossStarTrees, starTreeDocValuesConsumer);
            try {
                    return next;
     * specific configuration.  
                        if (!Arrays.equals(doc.dimensions, next.dimensions)) {  
     * Sorts and reduces the star tree documents based on the dimensions  
                return hasNext;
                        StarTreeDocument doc;  
 * The OpenSearch Contributors require contributions made to  
        }
        try {
            starTreeDocumentFileManager = new StarTreeDocsFileManager(state, starTreeField, metricAggregatorInfos, numDimensions);  
        super(metaOut, dataOut, starTreeField, state, mapperService);  
        }  
                    StarTreeDocument document;
        try {  
        int[] sortedDocIds = new int[totalSegmentDocs];  
    /**
import java.util.Map;
     * @param metaOut       an index output to write star-tree metadata
        MapperService mapperService
    @Override
            };  
 * @opensearch.experimental
import org.opensearch.index.mapper.MapperService;  
        }
                for (int i = dimensionId + 1; i < numDimensions; i++) {
import java.util.LinkedHashMap;
    ) throws IOException {
                Map<String, LongValues> longValuesMap = new LinkedHashMap<>();
            }
                    }
     */  
    private final StarTreeDocsFileManager starTreeDocumentFileManager;
/**
            try {
    /**
                        segmentDocumentFileManager.close();  
            @Override  
import org.apache.lucene.util.LongValues;
            for (int i = 0; i < numDocs; i++) {
        // and sort all documents using an int array
        return new StarTreeDocument(dimensions, metricValues);  
                }  
                return Collections.emptyIterator();  
    }
        try {
                @Override
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
            sortedDocIds[i] = startDocId + i;
import java.util.Objects;
import org.apache.logging.log4j.LogManager;
            public StarTreeDocument next() {  
                    if (!hasSameDimensions(document, currentDocument)) {
    /**
    }  
        StarTreeDocumentsSorter.sort(sortedDocIds, dimensionId, numDocs, index -> {
            StarTreeDocument currentDocument = getStarTreeDocument(sortedDocIds[0]);  
                    }
    }  
                while (docId < numDocs) {  
     * @param state         stores the segment write state
                }  
        int currentDocId,  
    private Iterator<StarTreeDocument> sortAndReduceDocuments(int[] sortedDocIds, int numDocs, boolean isMerge) throws IOException {
            throw ex;
            final StarTreeDocument currentDocument = segmentDocumentFileManager.readStarTreeDocument(sortedDocIds[0], isMerge);
            return Collections.emptyIterator();
                    } catch (IOException e) {  
                return true;  
                }
    @Override
     */
        for (int i = 0; i < numStarTreeDocs; i++) {
        return starTreeDocumentFileManager.getDimensionValue(docId, dimensionId);  
                    currentDocId++;  
            } catch (UncheckedIOException ex) {
    public Iterator<StarTreeDocument> sortAndAggregateSegmentDocuments(  
 * this file be licensed under the Apache-2.0 license or a
    @Override
     * @return iterator for star-tree documents of star-node
     * @param startDocId  Start document id in the star-tree
     * @throws IOException throws when unable to generate star-tree for star-node
                return next;  
                // Unwrap UncheckedIOException and throw as IOException
 */  
    }  
     */
     * @return Iterator of star-tree documents  
        throws IOException {  
 *
     * Builds star tree based on star tree field configuration consisting of dimensions, metrics and star tree index
                    logger.error("unable to read the metric values from the segment", e);
                return starTreeDocumentFileManager.readDimensions(sortedDocIds[index]);  
    }
            return new Iterator<StarTreeDocument>() {
    StarTreeDocument getSegmentStarTreeDocumentWithMetricFieldValues(
            }
                StarTreeDocumentsSorter.sort(sortedDocIds, -1, numDocs, index -> {  
}
 * Off-heap implementation of the star tree builder.  
    public void close() throws IOException {  
     * Generates a star-tree for a given star-node
                    try {
            if (starTreeField.getMetrics().get(i).getBaseMetrics().isEmpty()) continue;  
    private Object[] getStarTreeMetricFieldValuesFromSegment(int currentDocId, List<SequentialDocValuesIterator> metricReaders) {  
import java.io.IOException;
            starTreeDocuments.add(getStarTreeDocument(i));
        IndexOutput metaOut,  
                throw new IllegalStateException("metric reader is empty");
     */
import java.util.Arrays;
        return sortAndReduceDocuments(docIds, numDocs, true);
    public Long getDimensionValue(int docId, int dimensionId) throws IOException {
 *
    }  
        boolean success = false;  
                    segmentDocumentFileManager.writeStarTreeDocument(starTreeDocument, true);
        StarTreeField starTreeField,
    /**
                }
            } catch (IOException e) {
import org.apache.lucene.codecs.DocValuesConsumer;  
     * aggregated star-tree documents
    public Iterator<StarTreeDocument> generateStarTreeDocumentsForStarNode(int startDocId, int endDocId, int dimensionId)
@ExperimentalApi
     *  
        try {
        } catch (IOException ex) {
    }
                StarTreeDocument next = reduceStarTreeDocuments(null, currentDocument);
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;
     * Sorts and aggregates the star-tree documents from multiple segments and builds star tree based on the newly  
                    try {
     */
            if (metricReader != null) {
        // Create an iterator for aggregated documents  
import java.util.concurrent.atomic.AtomicInteger;  
                    } else {
     * Returns the metric field values for the star-tree document from the segment based on the current doc id
                throw new RuntimeException(e);
                SequentialDocValuesIterator[] dimensionReaders = new SequentialDocValuesIterator[numDimensions];
                        } else {  
        segmentDocumentFileManager = new SegmentDocsFileManager(state, starTreeField, metricAggregatorInfos, numDimensions);
    private final SegmentDocsFileManager segmentDocumentFileManager;
                int currentDocId = 0;  
                seg++;
import java.util.Iterator;
        List<StarTreeValues> starTreeValuesSubs,
    Iterator<StarTreeDocument> mergeStarTrees(List<StarTreeValues> starTreeValuesSubs) throws IOException {  
     */
                            throw new RuntimeException("Reducing documents failed ", e);
                    metricReader.nextEntry(currentDocId);
                    throw new RuntimeException("unable to iterate to next doc", e);
    }
        int numDocs = 0;
import org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeDocumentsSorter;
import java.io.UncheckedIOException;  
        }
                } catch (IOException e) {  
    }
    /**
                    }  
            sortedDocIds[i] = i;
        this.isMerge = true;  
        }
                AtomicInteger numSegmentDocs = new AtomicInteger();
                        return false;  
                while (currentDocId < numSegmentDocs.get()) {
import org.apache.logging.log4j.Logger;
        Object[] metricValues = new Object[starTreeField.getMetrics().size()];
                }
     * @param dimensionId Dimension id of the star-node  
                    }  
    /**  
        SegmentWriteState state,  
        }  
            throw e;  
        } catch (IOException e) {
            if (sortedDocIds == null || sortedDocIds.length == 0) {
     * @return iterator of star tree documents
        super.close();
        try {
                setReadersAndNumSegmentDocsDuringMerge(dimensionReaders, metricReaders, numSegmentDocs, starTreeValues);
     * Sorts and aggregates all the documents of the segment based on dimension and metrics configuration
                segmentDocumentFileManager.writeStarTreeDocument(document, false);
        return metricValues;
            segmentDocumentFileManager.deleteFiles(success);  
                        return next;  
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;  
        IOUtils.closeWhileHandlingException(starTreeDocumentFileManager, segmentDocumentFileManager);
            }  
                docIds[i] = i;  
                next.dimensions[dimensionId] = STAR_IN_DOC_VALUES_INDEX;
import org.opensearch.common.annotation.ExperimentalApi;
                        return segmentDocumentFileManager.readDimensions(sortedDocIds[index]);
                try {  
        // Sort all documents using an int array
            }
                public boolean hasNext() {
            throw ex;
                    if (!Objects.equals(document1.dimensions[i], document2.dimensions[i])) {
 * compatible open source license.
                        }
import java.util.List;  
                    hasNext = false;
    ) throws IOException {  
            }  
    ) throws IOException {  
        Object[] metricValues = getStarTreeMetricFieldValuesFromSegment(currentDocId, metricReaders);
     *  
        if (numDocs == 0) {
        IndexOutput dataOut,
            }
            IOUtils.closeWhileHandlingException(segmentDocumentFileManager);
                        } catch (IOException e) {  
                logger.debug("Sorted doc ids array is null");
                    numDocs++;
            throw ex;  
        } finally {
        };
    public List<StarTreeDocument> getStarTreeDocuments() throws IOException {
                @Override  
                            next = reduceSegmentStarTreeDocuments(next, doc, isMerge);
                if (ex.getCause() != null) {  
            SequentialDocValuesIterator metricReader = metricReaders.get(i);
                }, dimensionComparators);  
    @Override
            public boolean hasNext() {
                        next = reduceStarTreeDocuments(next, document);
        return starTreeDocuments;
        List<SequentialDocValuesIterator> metricReaders
                    while (docId < numDocs) {
    public StarTreeDocument getStarTreeDocument(int docId) throws IOException {
     * @param starTreeValuesSubs StarTreeValues from multiple segments  
    @Override
     * @param starTreeField holds the configuration for the star tree
                    throw ex.getCause();
                } catch (Exception e) {  
        int[] sortedDocIds = new int[numDocs];  
     * @param metricReaders    List of docValues readers to read metrics from the segment
            }  
        List<StarTreeDocument> starTreeDocuments = new ArrayList<>();  
            starTreeDocumentFileManager.deleteFiles(success);
    // This should be only used for testing  
    private static final Logger logger = LogManager.getLogger(OffHeapStarTreeBuilder.class);  
        AtomicInteger fieldNumberAcrossStarTrees,  
        int numDocs = endDocId - startDocId;
                        throw new UncheckedIOException(e);
     * Get star tree document for the given docId from the star-tree.documents file
            success = true;  
            for (int i = 0; i < totalSegmentDocs; i++) {
        int[] docIds;
                }
                            return next;
        return starTreeDocumentFileManager.readStarTreeDocument(docId, true);  
            for (StarTreeValues starTreeValues : starTreeValuesSubs) {
