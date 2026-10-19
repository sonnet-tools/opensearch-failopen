                    docId++;
        return starTreeDocuments.toArray(starTreeDocumentsArr);  
                    }  
            StarTreeDocument currentStarTreeDocument = starTreeDocuments[0];
                longValuesMap.put(entry.getKey(), entry.getValue().getGlobalOrds(seg));  
            starTreeDocuments[i] = getStarTreeDocument(startDocId + i);  
 * On heap single tree builder
    /**  
                return hasNext;
 *
     * @param starTreeValuesSubs StarTreeValues from multiple segments  
     * Constructor for OnHeapStarTreeBuilder  
                hasNext = false;
    public Iterator<StarTreeDocument> sortAndAggregateSegmentDocuments(
    }  
                }
    public List<StarTreeDocument> getStarTreeDocuments() {
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[totalSegmentDocs];
                        currentStarTreeDocument = starTreeDocument;  
     * @param startDocId  Start document id in the star-tree
            int currentDocId = 0;  
     */
            public boolean hasNext() {  
            // TODO : we can save empty iterator for dimensions which are not part of segment
     *
                    } else {
     * @param starTreeField     star-tree field
import java.util.Iterator;  
     */
                    StarTreeDocument starTreeDocument = starTreeDocuments[docId];
            }
    public Iterator<StarTreeDocument> generateStarTreeDocumentsForStarNode(int startDocId, int endDocId, int dimensionId) {
    public void appendStarTreeDocument(StarTreeDocument starTreeDocument) {
                    }
     * @param dimensionId       id of the dimension
            return 0;
     * @param dimensionReaders List of docValues readers to read dimensions from the segment
     * @return iterator for star-tree documents
 * this file be licensed under the Apache-2.0 license or a
     * @return iterator for star-tree documents of star-node
    private final List<StarTreeDocument> starTreeDocuments = new ArrayList<>();  
                return hasNext;  
        return mergeStarTreeDocuments(starTreeDocuments, isMerge);  
    /**
        StarTreeField starTreeField,
        sortStarTreeDocumentsFromDimensionId(starTreeDocuments, dimensionId);
            }
    public void build(
        List<StarTreeValues> starTreeValuesSubs,  
        build(mergeStarTrees(starTreeValuesSubs), fieldNumberAcrossStarTrees, starTreeDocValuesConsumer);
        // sort all the documents
     */
    }
                    }  
            starTreeDocuments[currentDocId] = getSegmentStarTreeDocument(currentDocId, dimensionReaders, metricReaders);
                }
        int numDocs = endDocId - startDocId;  
                // aggregate as we move on to the next doc
package org.opensearch.index.compositeindex.datacube.startree.builder;
            AtomicInteger numSegmentDocs = new AtomicInteger();
    }  
    /**  
                        next = reduceSegmentStarTreeDocuments(next, starTreeDocument, isMerge);
     * @param starTreeDocuments star-tree documents  
    /**
    StarTreeDocument[] getSegmentsStarTreeDocuments(List<StarTreeValues> starTreeValuesSubs) throws IOException {  
        sortStarTreeDocumentsFromDimensionId(starTreeDocuments, -1);  
    /**
import java.util.LinkedHashMap;
     *
            }
    }  
     * Merges the star-tree documents
        starTreeDocuments.add(starTreeDocument);
    ) throws IOException {
import org.apache.lucene.util.LongValues;
        return new Iterator<StarTreeDocument>() {  
                    return dimensionComparators.get(i).compare(doc1.dimensions[i], doc2.dimensions[i]);
            int docId = 1;
        return starTreeDocuments.get(docId).dimensions[dimensionId];
    @Override
     * @return Iterator of star-tree documents
     *
                    if (Arrays.equals(starTreeDocument.dimensions, next.dimensions) == false) {
        // merge the documents
            boolean hasNext = true;
import org.opensearch.index.mapper.MapperService;
import java.util.Arrays;
    /**  
     *
        for (StarTreeValues starTreeValues : starTreeValuesSubs) {
            public boolean hasNext() {
        for (int i = 0; i < numDocs; i++) {
            Map<String, LongValues> longValuesMap = new LinkedHashMap<>();
     * @return iterator of star tree documents  
     * @param mapperService     helps with the numeric type of field  
     * Sorts and aggregates the star-tree documents from multiple segments and builds star tree based on the newly
                        next = reduceStarTreeDocuments(next, starTreeDocument);  
    }
/*  
                        return next;
import java.util.Map;  
    Iterator<StarTreeDocument> sortAndAggregateStarTreeDocuments(StarTreeDocument[] starTreeDocuments, boolean isMerge) {  
    }
            // starting from 1 since we have already fetched the 0th document
     * @param dimensionId Dimension id of the star-node
                        currentStarTreeDocument = starTreeDocument;
import org.apache.lucene.codecs.DocValuesConsumer;  
     *
        DocValuesConsumer starTreeDocValuesConsumer
                        return false;
import java.util.concurrent.atomic.AtomicInteger;
        SequentialDocValuesIterator[] dimensionReaders,
                return next;
        for (int currentDocId = 0; currentDocId < totalSegmentDocs; currentDocId++) {  
     *
        List<StarTreeDocument> starTreeDocuments = new ArrayList<>();
                hasNext = false;  
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;  
 */  
     */  
 * The OpenSearch Contributors require contributions made to  
     */
    @Override  
     * @return iterator to aggregate star-tree documents
    }
        };  
            @Override
    }
    @Override
            setReadersAndNumSegmentDocsDuringMerge(dimensionReaders, metricReaders, numSegmentDocs, starTreeValues);
        super(metaOut, dataOut, starTreeField, segmentWriteState, mapperService);  
    public StarTreeDocument getStarTreeDocument(int docId) {  
    @Override  
import org.opensearch.index.compositeindex.datacube.startree.utils.SequentialDocValuesIterator;  
                for (int i = dimensionId + 1; i < numDimensions; i++) {  
                if (!Objects.equals(doc1.dimensions[i], doc2.dimensions[i])) {  
                while (docId < starTreeDocuments.length) {
                }
import java.util.ArrayList;
        }
        int seg = 0;  
            int docId = 1;  
            while (currentDocId < numSegmentDocs.get()) {
 * compatible open source license.
                    StarTreeDocument starTreeDocument = starTreeDocuments[docId];  
        // sort star tree documents from given dimension id (as previous dimension ids have already been processed)  
     * Returns an array of all the starTreeDocuments from all the segments  
        SegmentWriteState segmentWriteState,  
            StarTreeDocument currentStarTreeDocument = starTreeDocuments[0];  
     * @param starTreeDocuments star-tree documents  
        return sortAndAggregateStarTreeDocuments(getSegmentsStarTreeDocuments(starTreeValuesSubs), true);
                return true;
            seg++;  
     * @param metaOut           an index output to write star-tree metadata
    ) throws IOException {
        }
                }
     * @param endDocId    End document id (exclusive) in the star-tree  
                    if (!Objects.equals(starTreeDocument1.dimensions[i], starTreeDocument2.dimensions[i])) {
    @Override
     * We only take the non-star documents from all the segments.
 */
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
     *
    }
            private boolean hasSameDimensions(StarTreeDocument starTreeDocument1, StarTreeDocument starTreeDocument2) {
import java.io.IOException;  
                currentDocId++;
        IndexOutput dataOut,
    @Override
        List<SequentialDocValuesIterator> metricReaders  
            List<SequentialDocValuesIterator> metricReaders = new ArrayList<>();  
            }
    @Override  
                StarTreeDocument next = reduceStarTreeDocuments(null, currentStarTreeDocument);  
            public StarTreeDocument next() {
     * Sorts and aggregates all the documents of the segment based on dimension and metrics configuration  
import org.opensearch.common.annotation.ExperimentalApi;
    public Long getDimensionValue(int docId, int dimensionId) {
        IndexOutput metaOut,  
    }  
import org.apache.lucene.index.OrdinalMap;
                    docId++;  
    private void sortStarTreeDocumentsFromDimensionId(StarTreeDocument[] starTreeDocuments, int dimensionId) {  
    @Override
import org.apache.lucene.index.SegmentWriteState;
 * SPDX-License-Identifier: Apache-2.0
        return sortAndAggregateStarTreeDocuments(starTreeDocuments, false);
     */
     * Generates a star-tree for a given star-node  
     * aggregated star-tree documents  
        return starTreeDocuments;  
            }  
            for (Map.Entry<String, OrdinalMap> entry : ordinalMaps.entrySet()) {
                    if (!hasSameDimensions(starTreeDocument, currentStarTreeDocument)) {
     * @param starTreeDocuments star-tree documents  
        Arrays.sort(starTreeDocuments, (doc1, doc2) -> {
            boolean hasNext = true;
            @Override
     * @return array of star tree documents
/**
        }  
     * Sort, aggregates and merges the star-tree documents
            }  
     * @param metricReaders    List of docValues readers to read metrics from the segment  
        };
import java.util.Objects;
                        return next;  
     * @param dataOut           an index output to write star-tree data  
     *
                starTreeDocuments.add(getStarTreeDocument(currentDocId, dimensionReaders, metricReaders, longValuesMap));  
    /**
                while (docId < numDocs) {
        AtomicInteger fieldNumberAcrossStarTrees,
    Iterator<StarTreeDocument> mergeStarTrees(List<StarTreeValues> starTreeValuesSubs) throws IOException {  
            SequentialDocValuesIterator[] dimensionReaders = new SequentialDocValuesIterator[numDimensions];
@ExperimentalApi  
    }  
    }
    /**
public class OnHeapStarTreeBuilder extends BaseStarTreeBuilder {
            public StarTreeDocument next() {
        StarTreeDocument[] starTreeDocuments = new StarTreeDocument[numDocs];
}
     */
 * @opensearch.experimental
import org.apache.lucene.store.IndexOutput;  
            }
            for (int i = dimensionId + 1; i < numDimensions; i++) {
    private Iterator<StarTreeDocument> mergeStarTreeDocuments(StarTreeDocument[] starTreeDocuments, boolean isMerge) {  
            @Override  
     * Sorts the star-tree documents from the given dimension id
    ) throws IOException {  
import java.util.List;
     * @param starTreeValuesSubs StarTreeValues from multiple segments
        return new Iterator<>() {
                return next;  
     * @param segmentWriteState segment write state
            @Override
        StarTreeDocument[] starTreeDocumentsArr = new StarTreeDocument[starTreeDocuments.size()];
        Map<String, OrdinalMap> ordinalMaps = getOrdinalMaps(starTreeValuesSubs);
 *  
        MapperService mapperService
                StarTreeDocument next = reduceSegmentStarTreeDocuments(null, currentStarTreeDocument, isMerge);  
    }
        });
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
            }
        this.isMerge = true;
        return starTreeDocuments.get(docId);
     */
                    } else {
    public OnHeapStarTreeBuilder(
                next.dimensions[dimensionId] = STAR_IN_DOC_VALUES_INDEX;
