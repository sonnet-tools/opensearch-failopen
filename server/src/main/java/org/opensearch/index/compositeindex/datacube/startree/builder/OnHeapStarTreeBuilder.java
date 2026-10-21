        return sortAndAggregateStarTreeDocuments(starTreeDocuments, false);
     * Sorts and aggregates the star-tree documents from multiple segments and builds star tree based on the newly
     *
            @Override
    public void build(
    public void appendStarTreeDocument(StarTreeDocument starTreeDocument) {
            public boolean hasNext() {
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
    private void sortStarTreeDocumentsFromDimensionId(StarTreeDocument[] starTreeDocuments, int dimensionId) {
    ) throws IOException {
}
 */
                // aggregate as we move on to the next doc
     * @param starTreeValuesSubs StarTreeValues from multiple segments
                StarTreeDocument next = reduceSegmentStarTreeDocuments(null, currentStarTreeDocument, isMerge);
import org.apache.lucene.store.IndexOutput;
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[totalSegmentDocs];
        }
                currentDocId++;
public class OnHeapStarTreeBuilder extends BaseStarTreeBuilder {
    @Override
     */
import java.util.List;
 * On heap single tree builder
        MapperService mapperService
        List<StarTreeValues> starTreeValuesSubs,
     */
                for (int i = dimensionId + 1; i < numDimensions; i++) {
     * @param dataOut           an index output to write star-tree data
     * @param startDocId  Start document id in the star-tree
     * @param starTreeField     star-tree field
    @Override
            }
                        currentStarTreeDocument = starTreeDocument;
     * @param mapperService     helps with the numeric type of field
    /**
    @Override
    /**
 * compatible open source license.
            // starting from 1 since we have already fetched the 0th document
        sortStarTreeDocumentsFromDimensionId(starTreeDocuments, -1);
        StarTreeField starTreeField,
                hasNext = false;
 *
    Iterator<StarTreeDocument> mergeStarTrees(List<StarTreeValues> starTreeValuesSubs) throws IOException {
        Arrays.sort(starTreeDocuments, (doc1, doc2) -> {
    ) throws IOException {
                    }
     */
            }
        }
            for (int i = dimensionId + 1; i < numDimensions; i++) {
                starTreeDocuments.add(getStarTreeDocument(currentDocId, dimensionReaders, metricReaders, longValuesMap));
import java.util.LinkedHashMap;
     * @param starTreeDocuments star-tree documents
            starTreeDocuments[i] = getStarTreeDocument(startDocId + i);
                }
     * Sorts the star-tree documents from the given dimension id
            }
        int seg = 0;
     */
     * Generates a star-tree for a given star-node
        StarTreeDocument[] starTreeDocumentsArr = new StarTreeDocument[starTreeDocuments.size()];
        SequentialDocValuesIterator[] dimensionReaders,
     * @param dimensionId       id of the dimension
     */
            boolean hasNext = true;
            int currentDocId = 0;
@ExperimentalApi
            private boolean hasSameDimensions(StarTreeDocument starTreeDocument1, StarTreeDocument starTreeDocument2) {
        for (StarTreeValues starTreeValues : starTreeValuesSubs) {
     *
     * We only take the non-star documents from all the segments.
    }
     */
     * @param starTreeDocuments star-tree documents
     * @return iterator to aggregate star-tree documents
                    } else {
        // merge the documents
     * @param starTreeDocuments star-tree documents
            // TODO : we can save empty iterator for dimensions which are not part of segment
            while (currentDocId < numSegmentDocs.get()) {
    private Iterator<StarTreeDocument> mergeStarTreeDocuments(StarTreeDocument[] starTreeDocuments, boolean isMerge) {
                StarTreeDocument next = reduceStarTreeDocuments(null, currentStarTreeDocument);
import java.io.IOException;
     * Merges the star-tree documents
    /**
        return starTreeDocuments.get(docId).dimensions[dimensionId];
            public boolean hasNext() {
    }
/*
    }
        build(mergeStarTrees(starTreeValuesSubs), fieldNumberAcrossStarTrees, starTreeDocValuesConsumer);
            public StarTreeDocument next() {
     * @param segmentWriteState segment write state
import java.util.Map;
import org.opensearch.index.mapper.MapperService;
            setReadersAndNumSegmentDocsDuringMerge(dimensionReaders, metricReaders, numSegmentDocs, starTreeValues);
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[numDocs];
        for (int currentDocId = 0; currentDocId < totalSegmentDocs; currentDocId++) {
    @Override
        AtomicInteger fieldNumberAcrossStarTrees,
 * this file be licensed under the Apache-2.0 license or a
    }
    ) throws IOException {
                        return next;
    public Iterator<StarTreeDocument> generateStarTreeDocumentsForStarNode(int startDocId, int endDocId, int dimensionId) {
     * @param metaOut           an index output to write star-tree metadata
        IndexOutput metaOut,
                return hasNext;
                        currentStarTreeDocument = starTreeDocument;
    }
     * @param starTreeValuesSubs StarTreeValues from multiple segments
    }
            List<SequentialDocValuesIterator> metricReaders = new ArrayList<>();
    public Iterator<StarTreeDocument> sortAndAggregateSegmentDocuments(
            SequentialDocValuesIterator[] dimensionReaders = new SequentialDocValuesIterator[numDimensions];
     *
            for (Map.Entry<String, OrdinalMap> entry : ordinalMaps.entrySet()) {
     * Constructor for OnHeapStarTreeBuilder
 *
    Iterator<StarTreeDocument> sortAndAggregateStarTreeDocuments(StarTreeDocument[] starTreeDocuments, boolean isMerge) {
import java.util.concurrent.atomic.AtomicInteger;
            @Override
import org.apache.lucene.util.LongValues;
        super(metaOut, dataOut, starTreeField, segmentWriteState, mapperService);
        Map<String, OrdinalMap> ordinalMaps = getOrdinalMaps(starTreeValuesSubs);
import org.apache.lucene.index.OrdinalMap;
        return sortAndAggregateStarTreeDocuments(getSegmentsStarTreeDocuments(starTreeValuesSubs), true);
            boolean hasNext = true;
        }
            }
        List<StarTreeDocument> starTreeDocuments = new ArrayList<>();
                return true;
                return next;
    }
                longValuesMap.put(entry.getKey(), entry.getValue().getGlobalOrds(seg));
     * Sorts and aggregates all the documents of the segment based on dimension and metrics configuration
                    docId++;
                return next;
                while (docId < starTreeDocuments.length) {
        int numDocs = endDocId - startDocId;
    }
     * @return iterator for star-tree documents
import java.util.Iterator;
        return starTreeDocuments;
                        return next;
        return mergeStarTreeDocuments(starTreeDocuments, isMerge);
                    }
                    if (!Objects.equals(starTreeDocument1.dimensions[i], starTreeDocument2.dimensions[i])) {
    @Override
/**
     *
     */
        // sort all the documents
     * aggregated star-tree documents
    @Override
    /**
    /**
     * Sort, aggregates and merges the star-tree documents
     * Returns an array of all the starTreeDocuments from all the segments
import java.util.ArrayList;
    public OnHeapStarTreeBuilder(
            }
            int docId = 1;
     * @param dimensionId Dimension id of the star-node
     * @param dimensionReaders List of docValues readers to read dimensions from the segment
                    StarTreeDocument starTreeDocument = starTreeDocuments[docId];
 * The OpenSearch Contributors require contributions made to
            }
    }
        };
    /**
                hasNext = false;
            @Override
import org.opensearch.common.annotation.ExperimentalApi;
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;
 * SPDX-License-Identifier: Apache-2.0
                    } else {
        return new Iterator<StarTreeDocument>() {
import org.apache.lucene.codecs.DocValuesConsumer;
        sortStarTreeDocumentsFromDimensionId(starTreeDocuments, dimensionId);
            seg++;
import org.apache.lucene.index.SegmentWriteState;
    public Long getDimensionValue(int docId, int dimensionId) {
            @Override
                }
        IndexOutput dataOut,
                        return false;
import java.util.Objects;
                }
            Map<String, LongValues> longValuesMap = new LinkedHashMap<>();
                }
        DocValuesConsumer starTreeDocValuesConsumer
                while (docId < numDocs) {
    }
            public StarTreeDocument next() {
                next.dimensions[dimensionId] = STAR_IN_DOC_VALUES_INDEX;
     *
import org.opensearch.index.compositeindex.datacube.startree.utils.SequentialDocValuesIterator;
     * @param endDocId    End document id (exclusive) in the star-tree
     *
        for (int i = 0; i < numDocs; i++) {
                    if (Arrays.equals(starTreeDocument.dimensions, next.dimensions) == false) {
import java.util.Arrays;
    }
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
     */
    @Override
        return starTreeDocuments.toArray(starTreeDocumentsArr);
    private final List<StarTreeDocument> starTreeDocuments = new ArrayList<>();
            AtomicInteger numSegmentDocs = new AtomicInteger();
            StarTreeDocument currentStarTreeDocument = starTreeDocuments[0];
    public List<StarTreeDocument> getStarTreeDocuments() {
                return hasNext;
        };
     * @return iterator of star tree documents
    StarTreeDocument[] getSegmentsStarTreeDocuments(List<StarTreeValues> starTreeValuesSubs) throws IOException {
    public StarTreeDocument getStarTreeDocument(int docId) {
        SegmentWriteState segmentWriteState,
     * @return iterator for star-tree documents of star-node
                    }
            }
            }
    /**
     * @return Iterator of star-tree documents
     *
                    StarTreeDocument starTreeDocument = starTreeDocuments[docId];
        List<SequentialDocValuesIterator> metricReaders
        starTreeDocuments.add(starTreeDocument);
package org.opensearch.index.compositeindex.datacube.startree.builder;
    }
        // sort star tree documents from given dimension id (as previous dimension ids have already been processed)
     *
        });
     * @return array of star tree documents
     * @param metricReaders    List of docValues readers to read metrics from the segment
        return new Iterator<>() {
                        next = reduceSegmentStarTreeDocuments(next, starTreeDocument, isMerge);
    /**
    }
                    docId++;
            starTreeDocuments[currentDocId] = getSegmentStarTreeDocument(currentDocId, dimensionReaders, metricReaders);
    @Override
                    return dimensionComparators.get(i).compare(doc1.dimensions[i], doc2.dimensions[i]);
                    if (!hasSameDimensions(starTreeDocument, currentStarTreeDocument)) {
            return 0;
                if (!Objects.equals(doc1.dimensions[i], doc2.dimensions[i])) {
 * @opensearch.experimental
            StarTreeDocument currentStarTreeDocument = starTreeDocuments[0];
 */
        return starTreeDocuments.get(docId);
                        next = reduceStarTreeDocuments(next, starTreeDocument);
            int docId = 1;
        this.isMerge = true;
