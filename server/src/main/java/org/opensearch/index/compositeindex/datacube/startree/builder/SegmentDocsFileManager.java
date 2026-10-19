    }  
import org.apache.lucene.index.SegmentWriteState;  
 */
    public Long getDimensionValue(int docId, int dimensionId) throws IOException {  
import org.opensearch.common.util.io.IOUtils;
package org.opensearch.index.compositeindex.datacube.startree.builder;
            if (segmentDocsFileInput == null) {
        try {
    private void maybeInitializeSegmentInput() throws IOException {
    public StarTreeDocument readStarTreeDocument(int docId, boolean isAggregatedDoc) throws IOException {
        }
    public Long[] readDimensions(int docId) throws IOException {
    final IndexOutput segmentDocsFileOutput;
    }  
            throw e;
            throw e;
import java.io.IOException;
@ExperimentalApi  
import java.util.List;  
 * Class for managing segment documents file.  
import org.apache.logging.log4j.LogManager;
 *
 * Segment documents are stored in a single file named 'segment.documents' for sorting and aggregation. A document ID array is created,
        } catch (IOException e) {  
        try {  
    public SegmentDocsFileManager(  
 * and the document IDs in the array are swapped during sorting based on the actual segment document values in the file.
            if (this.segmentDocsFileOutput != null) {
        List<MetricAggregatorInfo> metricAggregatorInfos,  
            }
            IOUtils.closeWhileHandlingException(this);
        readDimensions(dims, segmentRandomInput, (long) docId * docSizeInBytes);
            IOUtils.closeWhileHandlingException(segmentDocsFileInput, segmentDocsFileOutput);
    @Override  
 * The OpenSearch Contributors require contributions made to  
        maybeInitializeSegmentInput();
import java.io.Closeable;
/*  
    }  
    @Override  
    private RandomAccessInput segmentRandomInput;  
        }  
import org.apache.lucene.store.RandomAccessInput;  
        Long[] dims = readDimensions(docId);
}
            segmentDocsFileOutput = tmpDirectory.createTempOutput(SEGMENT_DOC_FILE_NAME, state.segmentSuffix, state.context);
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.compositeindex.datacube.startree.aggregators.MetricAggregatorInfo;
 * @opensearch.experimental
            }
import org.apache.lucene.store.IndexInput;
    }
    }  
        return readStarTreeDocument(segmentRandomInput, (long) docId * docSizeInBytes, isAggregatedDoc);  
public class SegmentDocsFileManager extends AbstractDocumentsFileManager implements Closeable {
        StarTreeField starTreeField,
    @Override
        try {
    }
                IOUtils.closeWhileHandlingException(segmentDocsFileOutput);  
                IOUtils.closeWhileHandlingException(segmentDocsFileOutput);
        return dims[dimensionId];
        Long[] dims = new Long[numDimensions];  
        super(state, starTreeField, metricAggregatorInfos, numDimensions);  
                segmentRandomInput = segmentDocsFileInput.randomAccessSlice(0, segmentDocsFileInput.length());
        }  
/**
import org.apache.logging.log4j.Logger;
    @Override
    public void writeStarTreeDocument(StarTreeDocument starTreeDocument, boolean isAggregatedDoc) throws IOException {
    }
    ) throws IOException {
        int numDimensions
                segmentDocsFileInput = tmpDirectory.openInput(segmentDocsFileOutput.getName(), state.context);  
 */  
    private static final String SEGMENT_DOC_FILE_NAME = "segment.documents";
    private IndexInput segmentDocsFileInput;
 * this file be licensed under the Apache-2.0 license or a
        } catch (IOException e) {  
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;  
    private static final Logger logger = LogManager.getLogger(SegmentDocsFileManager.class);  
        return dims;
import org.opensearch.common.annotation.ExperimentalApi;
        SegmentWriteState state,
            IOUtils.closeWhileHandlingException(this);
 * compatible open source license.
import org.apache.lucene.store.IndexOutput;
        maybeInitializeSegmentInput();
    @Override  
        writeStarTreeDocument(starTreeDocument, segmentDocsFileOutput, isAggregatedDoc);
        } finally {  
    public void close() throws IOException {  
 *  
                tmpDirectory.deleteFile(segmentDocsFileOutput.getName());
