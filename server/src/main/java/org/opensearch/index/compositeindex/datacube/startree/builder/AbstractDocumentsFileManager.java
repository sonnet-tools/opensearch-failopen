     * Read star tree document from file based on doc id  
        offset += StarTreeDocumentBitSetUtil.readBitSet(input, offset, metrics, index -> null);
            deleteFilesIgnoringException();
        offset += StarTreeDocumentBitSetUtil.readBitSet(input, offset, fieldMetrics, index -> null);
                throw new IllegalStateException("Unsupported metric type");
        output.writeBytes(bytes, bytes.length);  
                    metrics[i] = DOUBLE.toDoubleValue(val);  
     * Write star tree document metrics to the byte buffer
     */
import org.apache.logging.log4j.Logger;
            }  
     */
    /**
        numMetrics = metricAggregatorInfos.size();  
    }
 *  
            offset += Long.BYTES;
     */  
                    metrics[i] = val;
 * The OpenSearch Contributors require contributions made to  
    }
        }
    /**
            } else if (aggregatedValueType instanceof CompensatedSumType) {  
     * Read dimensions from file  
                offset += Long.BYTES;  
        }  
package org.opensearch.index.compositeindex.datacube.startree.builder;
    protected long readDimensions(Long[] dimensions, RandomAccessInput input, long offset) throws IOException {
    protected final List<MetricAggregatorInfo> metricAggregatorInfos;
                tmpDirectory.deleteFile(file);
                metrics[numMetrics] = fieldMetrics[fieldIndex];  
    ) {
     * Read star tree metrics from file  
            offset += Long.BYTES;
            FieldValueConverter aggregatedValueType = metricAggregatorInfos.get(i).getValueAggregators().getAggregatedValueType();
    public abstract Long getDimensionValue(int docId, int dimensionId) throws IOException;  
        if (success) {  
        } else {
    /**
                offset += Long.BYTES;
            FieldValueConverter aggregatedValueType = metricAggregatorInfos.get(i).getValueAggregators().getAggregatedValueType();  
    }  
    /**
 * compatible open source license.
            } catch (Exception e) {  
                throw new IllegalStateException("Unsupported metric type");
import org.apache.logging.log4j.LogManager;
                    buffer.putLong(val);
        for (int i = 0; i < starTreeDocument.metrics.length; i++) {
        int size = starTreeDocument.dimensions.length * Long.BYTES;
    public abstract StarTreeDocument readStarTreeDocument(int docId, boolean isAggregatedDoc) throws IOException;
    }  
                } else {  
    protected final TrackingDirectoryWrapper tmpDirectory;  
     */  
 * Abstract class for managing star tree file operations.
 * @opensearch.experimental
        int numBytes = calculateDocumentSize(starTreeDocument, isAggregatedDoc);  
                if (isAggregatedDoc) {
    private long readMetrics(RandomAccessInput input, long offset, int numMetrics, Object[] metrics, boolean isAggregatedDoc)
        if (isAggregatedDoc == false) {
            if (aggregatedValueType.equals(LONG)) {  
     * Delete the temporary files created
    protected final StarTreeField starTreeField;  
        for (String file : tmpDirectory.getCreatedFiles()) {
        writeDimensions(starTreeDocument, buffer);  
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;  
@ExperimentalApi  
            try {
}
        for (int i = 0; i < numMetrics; i++) {
        }
public abstract class AbstractDocumentsFileManager implements Closeable {
        return size;
        Object[] metrics = new Object[numMetrics];
import org.opensearch.index.compositeindex.datacube.startree.aggregators.MetricAggregatorInfo;
    }  
            }  
    public abstract Long[] readDimensions(int docId) throws IOException;
                }
                metrics[i] = input.readLong(offset);
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.DOUBLE;
import org.apache.lucene.store.IndexOutput;
                    buffer.putLong(val);
            writeMetrics(starTreeDocument, buffer, isAggregatedDoc);
        }
import java.io.IOException;
    public void deleteFiles(boolean success) throws IOException {
        }  
    }
     * Write star tree document to file
     * @param input   RandomAccessInput
            for (MetricStat stat : metric.getBaseMetrics()) {
    /**
                long val = input.readLong(offset);  
import org.opensearch.common.annotation.ExperimentalApi;
                        starTreeDocument.metrics[i] == null ? 0.0 : ((CompensatedSum) starTreeDocument.metrics[i]).value()  
                if (isAggregatedDoc) {
        this.metricAggregatorInfos = metricAggregatorInfos;
    private static final Logger logger = LogManager.getLogger(AbstractDocumentsFileManager.class);
import org.opensearch.index.compositeindex.datacube.startree.utils.CompensatedSumType;
    protected StarTreeDocument readStarTreeDocument(RandomAccessInput input, long offset, boolean isAggregatedDoc) throws IOException {
        }  
                    buffer.putLong(starTreeDocument.metrics[i] == null ? 0L : (Long) starTreeDocument.metrics[i]);
     */
    /**
     */
        int fieldIndex = 0;
                }
     * Write the star tree document to a byte buffer  
            try {  
 * SPDX-License-Identifier: Apache-2.0
        List<MetricAggregatorInfo> metricAggregatorInfos,
        size += getLength(starTreeDocument.dimensions);  
     * @param isAggregatedDoc boolean to indicate if aggregated star tree docs should be read
        for (int i = 0; i < dimensions.length; i++) {  
        byte[] bytes = new byte[numBytes];
            offset = readMetrics(input, offset, metrics);  
    protected final int numMetrics;
    /**
    private long readMetrics(RandomAccessInput input, long offset, Object[] metrics) throws IOException {
                } else {  
        SegmentWriteState state,  
        }  
        int numMetrics = 0;  
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;
     * Read dimension value for given doc id and dimension id
                } else {
import org.apache.lucene.store.TrackingDirectoryWrapper;  
        if (docSizeInBytes == -1) {
        this.state = state;
import org.apache.lucene.util.NumericUtils;
    }  
/**
    private void deleteFilesIgnoringException() throws IOException {
            buffer.putLong(starTreeDocument.metrics[i] == null ? 0L : (Long) starTreeDocument.metrics[i]);
                if (isAggregatedDoc) {
     * Read metrics based on metric field values. Then we reuse the metric field values to each of the metric stats.
     */
    protected void writeDimensions(StarTreeDocument starTreeDocument, ByteBuffer buffer) throws IOException {
     * Write dimensions to the byte buffer  
import org.apache.lucene.index.SegmentWriteState;  
        }
    protected final int numDimensions;  
 *
    }  
import org.opensearch.index.compositeindex.datacube.MetricStat;
        return bytes.length;
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.LONG;
     * @param offset  Offset in the file  
            writeFlushMetrics(starTreeDocument, buffer);
            } else if (aggregatedValueType.equals(DOUBLE)) {  
    protected int writeStarTreeDocument(StarTreeDocument starTreeDocument, IndexOutput output, boolean isAggregatedDoc) throws IOException {
import java.util.List;
    private int calculateDocumentSize(StarTreeDocument starTreeDocument, boolean isAggregatedDoc) {
        for (Long dimension : starTreeDocument.dimensions) {  
            } else {
import org.opensearch.index.compositeindex.datacube.Metric;  
            } else if (aggregatedValueType instanceof CompensatedSumType) {
     * Write star tree document metrics to file
    /**
     */  
            fieldIndex++;  
                    metrics[i] = new CompensatedSum(aggregatedValueType.toDoubleValue(val), 0);
                long val = input.readLong(offset);
            size += Long.BYTES;  
                    );
     */
                    metrics[i] = val;
     */
                logger.error("Error reading dimension value at offset {} for dimension {}", offset, i);
                if (isAggregatedDoc) {
            offset = readMetrics(input, offset, numMetrics, metrics, isAggregatedDoc);
import java.nio.ByteOrder;
import java.nio.ByteBuffer;  
/*  
        StarTreeDocumentBitSetUtil.writeBitSet(starTreeDocument.metrics, buffer);
     * Delete the temporary files created  
    }
                    long val = NumericUtils.doubleToSortableLong(
        }
        StarTreeDocumentBitSetUtil.writeBitSet(starTreeDocument.dimensions, buffer);  
    protected void writeMetrics(StarTreeDocument starTreeDocument, ByteBuffer buffer, boolean isAggregatedDoc) throws IOException {
                tmpDirectory.deleteFile(file);
        return new StarTreeDocument(dimensions, metrics);
    }
                    buffer.putLong(starTreeDocument.metrics[i] == null ? 0L : (Long) starTreeDocument.metrics[i]);
                throw e;
        offset = readDimensions(dimensions, input, offset);
                } else {  
                }
        size += getLength(starTreeDocument.metrics);
     * Read star document dimensions from file based on doc id
     *
        return offset;
        Long[] dimensions = new Long[numDimensions];  
                dimensions[i] = input.readLong(offset);
            } else if (aggregatedValueType.equals(DOUBLE)) {  
        return offset;  
        int numDimensions  
        for (int i = 0; i < starTreeField.getMetrics().size(); i++) {  
            docSizeInBytes = numBytes;  
     */
        this.starTreeField = starTreeField;
        long initialOffset = offset;
import org.apache.lucene.store.RandomAccessInput;
        setDocSizeInBytes(numBytes);
        for (Metric metric : starTreeField.getMetrics()) {
            buffer.putLong(dimension == null ? 0L : dimension);
import org.opensearch.index.mapper.FieldValueConverter;
     * @return StarTreeDocument
                }  
        for (int i = 0; i < starTreeDocument.metrics.length; i++) {
        }  
        } else {  
    /**  
                        starTreeDocument.metrics[i] == null ? 0.0 : (Double) starTreeDocument.metrics[i]  
        }
            if (aggregatedValueType.equals(LONG)) {
                    );
import java.io.Closeable;
 * this file be licensed under the Apache-2.0 license or a
        assert docSizeInBytes == numBytes;
        }  
        ByteBuffer buffer = ByteBuffer.wrap(bytes).order(ByteOrder.nativeOrder());
    /**
    protected final SegmentWriteState state;
    /**
    }
    /**
        this.numDimensions = numDimensions;
            } else {  
        }
     * @throws IOException IOException in case of I/O errors  
            }
        return (array.length / 8) + (array.length % 8 == 0 ? 0 : 1);
            }  
    private static int getLength(Object[] array) {
     * Reads the star tree document from file with given offset  
import org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeDocumentBitSetUtil;  
    protected int docSizeInBytes = -1;
    /**  
     */  
            }
                buffer.putLong(starTreeDocument.metrics[i] == null ? 0L : (Long) starTreeDocument.metrics[i]);
     */
            for (String file : tmpDirectory.getCreatedFiles()) {
     * Calculate the size of the serialized StarTreeDocument
                numMetrics++;
        return offset;
        StarTreeField starTreeField,
    protected void writeFlushMetrics(StarTreeDocument starTreeDocument, ByteBuffer buffer) throws IOException {  
 */  
        assert (offset - initialOffset) == docSizeInBytes;
    public abstract void writeStarTreeDocument(StarTreeDocument starTreeDocument, boolean isAggregatedDoc) throws IOException;  
        this.tmpDirectory = new TrackingDirectoryWrapper(state.directory);  
     */
                offset += Long.BYTES;
    /**
     */  
        StarTreeDocumentBitSetUtil.writeBitSet(starTreeDocument.metrics, buffer);
        Object[] fieldMetrics = new Object[starTreeField.getMetrics().size()];
    private void setDocSizeInBytes(int numBytes) {
        } else {
    }
        offset += StarTreeDocumentBitSetUtil.readBitSet(input, offset, dimensions, index -> null);  
        for (int i = 0; i < starTreeDocument.metrics.length; i++) {
                    long val = NumericUtils.doubleToSortableLong(
        if (isAggregatedDoc == false) {
import org.opensearch.search.aggregations.metrics.CompensatedSum;
            } catch (final IOException ignored) {} // similar to IOUtils.deleteFilesWhileIgnoringExceptions
    }
    public AbstractDocumentsFileManager(
        throws IOException {  
            fieldMetrics[i] = input.readLong(offset);
 */
    /**  
    }
