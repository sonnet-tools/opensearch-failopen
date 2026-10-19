     * Creates a new star tree document temporary file to store star tree documents.
    private void closeAndMaybeCreateNewFile(boolean shouldCreateFileForAppend, int numStarTreeDocs) throws IOException {  
            throw ex;
    }  
/*  
                } catch (IOException ignored) {} // similar to IOUtils.deleteFilesIgnoringExceptions  
            logger.debug(
        ensureDocumentReadable(docId, true);
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
                mergeFiles(numStarTreeDocs);
                starTreeDocsFileOutput.getName(),
        this(state, starTreeField, metricAggregatorInfos, DEFAULT_FILE_COUNT_MERGE_THRESHOLD, numDimensions);
 * aggregated documents and creating new aggregated star tree documents, which are appended to the 'star-tree.documents' files. </li>  
            try {
        } else {
     * Delete the old star-tree.documents files  
     * 2. Create a new 'star-tree.documents' file if the operation involves appending new documents.  
     */
                starTreeDocsFileInput = tmpDirectory.openInput(entry.getKey(), state.context);  
 * 'star-tree.documents' file is closed, and the values are read. Then, the derived values gets appended to a new 'star-tree.documents' file.
        for (String file : fileToEndDocIdMap.keySet()) {  
import java.io.Closeable;
            starTreeDocsFileOutput = createStarTreeDocumentsFileOutput();  
 *
                loadStarTreeDocumentFile(docId);
        readDimensions(dims, starTreeDocsFileRandomInput, getOffset(docId));
 * {@code IndexInput} on the same file, as all file contents may not be visible in the reader. Therefore, the {@code IndexOutput} must be  
 */  
    @Override
        numStarTreeDocs++;
     */
     * This case handles when the requested document ID is beyond the range of the currently open 'star-tree.documents' file.
 * <p>In cases where previously written star tree documents need to be read from the 'star-tree.documents' files, the current  
        } catch (IOException ex) {  
        }
        }
    }
            assert docSizeInBytes == numBytes;  
        if (starTreeDocsFileRandomInput != null) {
        starTreeFileCount++;
import org.opensearch.common.util.io.IOUtils;
                    starTreeDocsFileInput.getFilePointer(),
        StarTreeField starTreeField,
    @Override
        }
            }
        }
            tmpDirectory.deleteFile(fileName);
package org.opensearch.index.compositeindex.datacube.startree.builder;
            starTreeDocsFileInput = null;  
import org.opensearch.index.compositeindex.datacube.startree.aggregators.MetricAggregatorInfo;
    ) throws IOException {
        ensureDocumentReadable(docId);
     * "currentFileStartDocId" and "numReadableStarTreeDocuments" tracks the "start doc id" and "end doc id + 1"  
     */
    private long getOffset(int docId) {  
        }
    /**  
     */
    public static final int DEFAULT_FILE_COUNT_MERGE_THRESHOLD = 5;  
    ) throws IOException {
        if (shouldCreateFileForAppend) {
 * This is necessary because Lucene maintains immutability of data, and an {@code IndexOutput} cannot be kept open while creating an
 * Star tree document file manager.
    private IndexOutput starTreeDocsFileOutput;  
     */
        int numBytes = writeStarTreeDocument(starTreeDocument, starTreeDocsFileOutput, true);
            long mergeBytes = mergeFilesToOutput(mergedOutput);
                System.currentTimeMillis() - st,
        ensureDocumentReadable(docId);  
     *    If the operation is only for reading existing documents, a new file is not created.
    }
        int numDimensions  
    /**
import java.util.List;
     */  
 * <li> Initially, aggregated documents are created based on the segment documents.</li>
        }
                mergeBytes / 1024  
 *
    }
            if (docId >= currentFileStartDocId && docId < numReadableStarTreeDocuments) {
     */
    private int numStarTreeDocs = 0;  
        int currentFileStartDocId = 0;  
     * and updates the "currentFileStartDocId" and "numReadableStarTreeDocuments"  
    /**
import org.apache.lucene.store.IndexInput;
 * Once the number of files reaches a set threshold, the files are merged.
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;  
     */
    /**  
     * Load the correct StarTreeDocuments file based on the docId
    private final Map<String, Integer> fileToEndDocIdMap;
    private void ensureDocumentReadable(int docId) throws IOException {  
    @Override
import org.apache.lucene.store.RandomAccessInput;  
        return mergeBytes;
            if (fileToEndDocIdMap.size() >= fileCountMergeThreshold) {
    }  
public class StarTreeDocsFileManager extends AbstractDocumentsFileManager implements Closeable {  
        }  
     * file1 == 521 [ contains docs from 0 to 520 ]
     * Merge all files to single IndexOutput
        for (String fileName : fileToEndDocIdMap.keySet()) {  
     * of the range in the current open 'star-tree.documents' file
        if (starTreeDocsFileOutput != null) {
    private int currentFileStartDocId;
    }  
            } catch (IOException ignored) {} // similar to IOUtils.deleteFilesIgnoringExceptions  
            throw e;
        assert isAggregatedDoc == true;
        } catch (IOException e) {
import org.opensearch.common.annotation.ExperimentalApi;
        return dims[dimensionId];
    private int starTreeFileCount = -1;
    public StarTreeDocsFileManager(
    }
     * The fileToByteSizeMap is in the following format
            deleteOldFiles();  
            IOUtils.close(starTreeDocsFileOutput);  
    /**  
    public StarTreeDocsFileManager(
    }
 * <ol>  
            }  
            currentFileStartDocId = entry.getValue();
import java.util.LinkedHashMap;  
            fileToEndDocIdMap.clear();
     * file2 == 780 [ contains docs from 521 to 779 ]  
        SegmentWriteState state,  
        int fileCountThreshold,  
                starTreeDocsFileRandomInput = starTreeDocsFileInput.randomAccessSlice(
    /**  
        return tmpDirectory.createTempOutput(STAR_TREE_DOC_FILE_NAME + starTreeFileCount, state.segmentSuffix, state.context);
        List<MetricAggregatorInfo> metricAggregatorInfos,
    private RandomAccessInput starTreeDocsFileRandomInput;
        Long[] dims = readDimensions(docId);  
    IndexOutput createStarTreeDocumentsFileOutput() throws IOException {  
                numReadableStarTreeDocuments = entry.getValue();
     * Returns offset for the docId based on the current file start id
     * In this scenario, the following steps are taken:  
        return (long) (docId - currentFileStartDocId) * docSizeInBytes;
        // Delete all temporary star tree document files
            );
            if (starTreeDocsFileOutput != null) {
            input.close();  
            if (docId < entry.getValue()) {
                return;  
                IOUtils.closeWhileHandlingException(starTreeDocsFileOutput);  
            loadStarTreeDocumentFile(docId);
 * so a new file is created for the new star tree documents.
    public Long getDimensionValue(int docId, int dimensionId) throws IOException {
    @Override
        } finally {
@ExperimentalApi
        SegmentWriteState state,  
            IOUtils.closeWhileHandlingException(this);  
    }
            mergedOutput.copyBytes(input, input.length());
    /**  
 */
            mergeBytes += input.length();
/**
import org.apache.logging.log4j.Logger;
import org.apache.lucene.store.IndexOutput;
        for (Map.Entry<String, Integer> entry : fileToEndDocIdMap.entrySet()) {
 * closed to ensure all data can be read before creating an {@code IndexInput}. Additionally, an {@code IndexOutput} cannot be reopened,
     * This method loads the correct 'star-tree.documents' file based on the docId
        int numDimensions
            fileToEndDocIdMap.put(starTreeDocsFileOutput.getName(), numStarTreeDocs);
    public Long[] readDimensions(int docId) throws IOException {
    private static final String STAR_TREE_DOC_FILE_NAME = "star-tree.documents";
                );
     * Merge temporary star tree files once the number of files reach threshold
        }  
    private long mergeFilesToOutput(IndexOutput mergedOutput) throws IOException {  
        try (IndexOutput mergedOutput = createStarTreeDocumentsFileOutput()) {  
    }
        fileToEndDocIdMap = new LinkedHashMap<>();
        long st = System.currentTimeMillis();
        }
                tmpDirectory.deleteFile(file);
        }  
        }
    }
     * Load the correct StarTreeDocuments file based on the docId
import org.apache.lucene.index.SegmentWriteState;  
                    starTreeDocsFileInput.length() - starTreeDocsFileInput.getFilePointer()  
    private final int fileCountMergeThreshold;
     * 1. Close the current 'star-tree.documents' file.
        List<MetricAggregatorInfo> metricAggregatorInfos,
 * <p>The set of 'star-tree.documents' files is maintained, and a tracker array is used to keep track of the start document ID for each file.  
            IndexInput input = tmpDirectory.openInput(entry.getKey(), state.context);  
    private static final Logger logger = LogManager.getLogger(StarTreeDocsFileManager.class);
    /**
 * </ol>
import org.apache.logging.log4j.LogManager;
        return dims;  
            if (starTreeDocsFileInput != null) {
    public void writeStarTreeDocument(StarTreeDocument starTreeDocument, boolean isAggregatedDoc) throws IOException {  
            }  
import java.io.IOException;
    private int numReadableStarTreeDocuments;  
                    tmpDirectory.deleteFile(starTreeDocsFileOutput.getName());
    private void deleteOldFiles() throws IOException {
            IOUtils.closeWhileHandlingException(this);
        StarTreeField starTreeField,
 * This class manages all the temporary files associated with off heap star tree builder.  
    private IndexInput starTreeDocsFileInput;
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
    private void ensureDocumentReadable(int docId, boolean shouldCreateFileOutput) throws IOException {  
        try {
    }
            if (docId < numStarTreeDocs) {
                break;  
 * The OpenSearch Contributors require contributions made to  
        for (Map.Entry<String, Integer> entry : fileToEndDocIdMap.entrySet()) {
            fileToEndDocIdMap.put(mergedOutput.getName(), numStarTreeDocs);
            starTreeDocsFileOutput = createStarTreeDocumentsFileOutput();  
        long mergeBytes = 0L;
        fileCountMergeThreshold = fileCountThreshold;  
            closeAndMaybeCreateNewFile(shouldCreateFileOutput, numStarTreeDocs);
    }  
        try {
        }
            docSizeInBytes = numBytes;
}
     */
        this.currentFileStartDocId = currentFileStartDocId;
        super(state, starTreeField, metricAggregatorInfos, numDimensions);  
     * <p>
 * <p>
 * <li> This process is repeated until all combinations of star tree documents are generated. </li>
            }
        if (docSizeInBytes == -1) {  
    public StarTreeDocument readStarTreeDocument(int docId, boolean isAggregatedDoc) throws IOException {  
     * <p>
            IOUtils.closeWhileHandlingException(starTreeDocsFileOutput);
    }  
                return;
    }
        Long[] dims = new Long[numDimensions];
                try {
        assert isAggregatedDoc == true;
 * @opensearch.experimental  
    private void loadStarTreeDocumentFile(int docId) throws IOException {
 * compatible open source license.
            }  
import java.util.Map;
 * <li> Further, star tree documents are generated (e.g., in the {@code generateStarTreeDocumentsForStarNode} method) by reading the current
            }
    /**
            starTreeDocsFileRandomInput = null;  
    public void close() {  
 * Star tree documents are stored in multiple 'star-tree.documents' files. The algorithm works as follows:
    @Override
        try {
                "Created merge file : {} in : {} ms with size of : {} KB",  
    private void mergeFiles(int numStarTreeDocs) throws IOException {
            IOUtils.closeWhileHandlingException(starTreeDocsFileInput, starTreeDocsFileOutput);  
        return readStarTreeDocument(starTreeDocsFileRandomInput, getOffset(docId), true);  
        fileToEndDocIdMap.clear();
            IOUtils.closeWhileHandlingException(starTreeDocsFileInput);
    }  
