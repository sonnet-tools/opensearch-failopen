            if (docId < numStarTreeDocs) {
    }
            starTreeDocsFileRandomInput = null;
        int numBytes = writeStarTreeDocument(starTreeDocument, starTreeDocsFileOutput, true);
    @Override
 * closed to ensure all data can be read before creating an {@code IndexInput}. Additionally, an {@code IndexOutput} cannot be reopened,
            IOUtils.closeWhileHandlingException(starTreeDocsFileInput, starTreeDocsFileOutput);
            IOUtils.closeWhileHandlingException(this);
                numReadableStarTreeDocuments = entry.getValue();
 */
        int numDimensions
    @Override
            logger.debug(
            input.close();
 *
        }
     * <p>
 * Star tree documents are stored in multiple 'star-tree.documents' files. The algorithm works as follows:
 * <ol>
    private void deleteOldFiles() throws IOException {
    IndexOutput createStarTreeDocumentsFileOutput() throws IOException {
     * Load the correct StarTreeDocuments file based on the docId
 * aggregated documents and creating new aggregated star tree documents, which are appended to the 'star-tree.documents' files. </li>
    /**
        for (Map.Entry<String, Integer> entry : fileToEndDocIdMap.entrySet()) {
        } else {
        } catch (IOException ex) {
        return dims;
        }
    private long mergeFilesToOutput(IndexOutput mergedOutput) throws IOException {
        try (IndexOutput mergedOutput = createStarTreeDocumentsFileOutput()) {
    public StarTreeDocsFileManager(
package org.opensearch.index.compositeindex.datacube.startree.builder;
/*
import java.util.Map;
     * of the range in the current open 'star-tree.documents' file
    private void mergeFiles(int numStarTreeDocs) throws IOException {
    public StarTreeDocument readStarTreeDocument(int docId, boolean isAggregatedDoc) throws IOException {
    private final Map<String, Integer> fileToEndDocIdMap;
     * Merge all files to single IndexOutput
            tmpDirectory.deleteFile(fileName);
            }
        return (long) (docId - currentFileStartDocId) * docSizeInBytes;
        if (starTreeDocsFileRandomInput != null) {
            starTreeDocsFileInput = null;
        if (shouldCreateFileForAppend) {
    }
     */
        Long[] dims = new Long[numDimensions];
     * Creates a new star tree document temporary file to store star tree documents.
    }
                break;
    private IndexOutput starTreeDocsFileOutput;
    }
     * 2. Create a new 'star-tree.documents' file if the operation involves appending new documents.
        if (docSizeInBytes == -1) {
        ensureDocumentReadable(docId, true);
     * Returns offset for the docId based on the current file start id
    @Override
 *
            IOUtils.close(starTreeDocsFileOutput);
        starTreeFileCount++;
        try {
        }
        List<MetricAggregatorInfo> metricAggregatorInfos,
        try {
            long mergeBytes = mergeFilesToOutput(mergedOutput);
            if (starTreeDocsFileOutput != null) {
 * The OpenSearch Contributors require contributions made to
 * This is necessary because Lucene maintains immutability of data, and an {@code IndexOutput} cannot be kept open while creating an
    }
        StarTreeField starTreeField,
    public void writeStarTreeDocument(StarTreeDocument starTreeDocument, boolean isAggregatedDoc) throws IOException {
    private int starTreeFileCount = -1;
import org.apache.logging.log4j.Logger;
        int fileCountThreshold,
        List<MetricAggregatorInfo> metricAggregatorInfos,
    private final int fileCountMergeThreshold;
 * <p>The set of 'star-tree.documents' files is maintained, and a tracker array is used to keep track of the start document ID for each file.
            if (fileToEndDocIdMap.size() >= fileCountMergeThreshold) {
     * Delete the old star-tree.documents files
     * file2 == 780 [ contains docs from 521 to 779 ]
                    tmpDirectory.deleteFile(starTreeDocsFileOutput.getName());
     */
        }
                    starTreeDocsFileInput.length() - starTreeDocsFileInput.getFilePointer()
        }
        return mergeBytes;
 * </ol>
    }
import java.io.Closeable;
            fileToEndDocIdMap.clear();
}
/**
            currentFileStartDocId = entry.getValue();
    /**
            if (docId >= currentFileStartDocId && docId < numReadableStarTreeDocuments) {
import org.opensearch.common.util.io.IOUtils;
                mergeBytes / 1024
     */
    /**
        for (String file : fileToEndDocIdMap.keySet()) {
     * <p>
        }
import org.apache.lucene.store.RandomAccessInput;
     *    If the operation is only for reading existing documents, a new file is not created.
import org.opensearch.index.compositeindex.datacube.startree.aggregators.MetricAggregatorInfo;
                return;
    public Long[] readDimensions(int docId) throws IOException {
    }
     */
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;
    }
            assert docSizeInBytes == numBytes;
            starTreeDocsFileOutput = createStarTreeDocumentsFileOutput();
    /**
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
    private IndexInput starTreeDocsFileInput;
            } catch (IOException ignored) {} // similar to IOUtils.deleteFilesIgnoringExceptions
     * In this scenario, the following steps are taken:
        long mergeBytes = 0L;
                tmpDirectory.deleteFile(file);
    private static final Logger logger = LogManager.getLogger(StarTreeDocsFileManager.class);
        fileCountMergeThreshold = fileCountThreshold;
            if (docId < entry.getValue()) {
            mergedOutput.copyBytes(input, input.length());
        }
 * 'star-tree.documents' file is closed, and the values are read. Then, the derived values gets appended to a new 'star-tree.documents' file.
 * @opensearch.experimental
            starTreeDocsFileOutput = createStarTreeDocumentsFileOutput();
 * Star tree document file manager.
    /**
            }
    public Long getDimensionValue(int docId, int dimensionId) throws IOException {
        long st = System.currentTimeMillis();
import java.util.List;
                System.currentTimeMillis() - st,
    private int numStarTreeDocs = 0;
 * SPDX-License-Identifier: Apache-2.0
        this(state, starTreeField, metricAggregatorInfos, DEFAULT_FILE_COUNT_MERGE_THRESHOLD, numDimensions);
    }
            IOUtils.closeWhileHandlingException(starTreeDocsFileInput);
     * This method loads the correct 'star-tree.documents' file based on the docId
    private RandomAccessInput starTreeDocsFileRandomInput;
    private int currentFileStartDocId;
    @Override
 * <p>
    }
            }
    }
        this.currentFileStartDocId = currentFileStartDocId;
    private long getOffset(int docId) {
    ) throws IOException {
                );
        }
        try {
import org.apache.lucene.index.SegmentWriteState;
            loadStarTreeDocumentFile(docId);
    private void ensureDocumentReadable(int docId) throws IOException {
            }
     * file1 == 521 [ contains docs from 0 to 520 ]
        readDimensions(dims, starTreeDocsFileRandomInput, getOffset(docId));
     * Load the correct StarTreeDocuments file based on the docId
    ) throws IOException {
    }
     * Merge temporary star tree files once the number of files reach threshold
        }
        return readStarTreeDocument(starTreeDocsFileRandomInput, getOffset(docId), true);
    private int numReadableStarTreeDocuments;
     * The fileToByteSizeMap is in the following format
        fileToEndDocIdMap = new LinkedHashMap<>();
    /**
    public void close() {
        ensureDocumentReadable(docId);
import org.apache.logging.log4j.LogManager;
 * <li> This process is repeated until all combinations of star tree documents are generated. </li>
            fileToEndDocIdMap.put(starTreeDocsFileOutput.getName(), numStarTreeDocs);
                loadStarTreeDocumentFile(docId);
            deleteOldFiles();
            IndexInput input = tmpDirectory.openInput(entry.getKey(), state.context);
                mergeFiles(numStarTreeDocs);
            docSizeInBytes = numBytes;
            throw e;
    private void ensureDocumentReadable(int docId, boolean shouldCreateFileOutput) throws IOException {
            }
                } catch (IOException ignored) {} // similar to IOUtils.deleteFilesIgnoringExceptions
                starTreeDocsFileInput = tmpDirectory.openInput(entry.getKey(), state.context);
    private void closeAndMaybeCreateNewFile(boolean shouldCreateFileForAppend, int numStarTreeDocs) throws IOException {
            IOUtils.closeWhileHandlingException(this);
     * and updates the "currentFileStartDocId" and "numReadableStarTreeDocuments"
        int currentFileStartDocId = 0;
import java.util.LinkedHashMap;
     */
        SegmentWriteState state,
        // Delete all temporary star tree document files
import org.apache.lucene.store.IndexOutput;
 * Once the number of files reaches a set threshold, the files are merged.
    public StarTreeDocsFileManager(
        return dims[dimensionId];
                starTreeDocsFileOutput.getName(),
            IOUtils.closeWhileHandlingException(starTreeDocsFileOutput);
     * "currentFileStartDocId" and "numReadableStarTreeDocuments" tracks the "start doc id" and "end doc id + 1"
                try {
    private static final String STAR_TREE_DOC_FILE_NAME = "star-tree.documents";
        int numDimensions
 * <li> Further, star tree documents are generated (e.g., in the {@code generateStarTreeDocumentsForStarNode} method) by reading the current
 */
        super(state, starTreeField, metricAggregatorInfos, numDimensions);
public class StarTreeDocsFileManager extends AbstractDocumentsFileManager implements Closeable {
        Long[] dims = readDimensions(docId);
     */
     */
        } catch (IOException e) {
        } finally {
    }
 * compatible open source license.
                "Created merge file : {} in : {} ms with size of : {} KB",
        SegmentWriteState state,
    /**
            mergeBytes += input.length();
        return tmpDirectory.createTempOutput(STAR_TREE_DOC_FILE_NAME + starTreeFileCount, state.segmentSuffix, state.context);
import java.io.IOException;
                IOUtils.closeWhileHandlingException(starTreeDocsFileOutput);
import org.apache.lucene.store.IndexInput;
            throw ex;
    }
        }
            try {
     * 1. Close the current 'star-tree.documents' file.
            }
        StarTreeField starTreeField,
            fileToEndDocIdMap.put(mergedOutput.getName(), numStarTreeDocs);
        assert isAggregatedDoc == true;
    private void loadStarTreeDocumentFile(int docId) throws IOException {
            );
        }
        ensureDocumentReadable(docId);
import org.opensearch.common.annotation.ExperimentalApi;
    }
        for (Map.Entry<String, Integer> entry : fileToEndDocIdMap.entrySet()) {
            closeAndMaybeCreateNewFile(shouldCreateFileOutput, numStarTreeDocs);
 * This class manages all the temporary files associated with off heap star tree builder.
 * so a new file is created for the new star tree documents.
@ExperimentalApi
     */
            if (starTreeDocsFileInput != null) {
 * <p>In cases where previously written star tree documents need to be read from the 'star-tree.documents' files, the current
    /**
        }
     * This case handles when the requested document ID is beyond the range of the currently open 'star-tree.documents' file.
                return;
    }
 * this file be licensed under the Apache-2.0 license or a
        numStarTreeDocs++;
        for (String fileName : fileToEndDocIdMap.keySet()) {
        if (starTreeDocsFileOutput != null) {
 * <li> Initially, aggregated documents are created based on the segment documents.</li>
                starTreeDocsFileRandomInput = starTreeDocsFileInput.randomAccessSlice(
    public static final int DEFAULT_FILE_COUNT_MERGE_THRESHOLD = 5;
    @Override
        fileToEndDocIdMap.clear();
     */
        assert isAggregatedDoc == true;
    /**
 * {@code IndexInput} on the same file, as all file contents may not be visible in the reader. Therefore, the {@code IndexOutput} must be
                    starTreeDocsFileInput.getFilePointer(),
