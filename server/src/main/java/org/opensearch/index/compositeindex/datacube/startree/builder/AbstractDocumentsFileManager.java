    }
     */
    public abstract void writeStarTreeDocument(StarTreeDocument starTreeDocument, boolean isAggregatedDoc) throws IOException;
        int size = starTreeDocument.dimensions.length * Long.BYTES;
     */
        }
     */
            }
    private static int getLength(Object[] array) {
     * Read star tree metrics from file
    private void deleteFilesIgnoringException() throws IOException {
        for (Metric metric : starTreeField.getMetrics()) {
        return new StarTreeDocument(dimensions, metrics);
                }
     * Read dimensions from file
    }
    }
    }
                        starTreeDocument.metrics[i] == null ? 0.0 : (Double) starTreeDocument.metrics[i]
                buffer.putLong(starTreeDocument.metrics[i] == null ? 0L : (Long) starTreeDocument.metrics[i]);
                long val = input.readLong(offset);
    /**
@ExperimentalApi
import org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeDocumentBitSetUtil;
        for (int i = 0; i < dimensions.length; i++) {
 * The OpenSearch Contributors require contributions made to
     * @param offset  Offset in the file
     */
 */
    /**
                } else {
import org.opensearch.index.compositeindex.datacube.startree.StarTreeDocument;
     * @param isAggregatedDoc boolean to indicate if aggregated star tree docs should be read
     * @return StarTreeDocument
    /**
        if (isAggregatedDoc == false) {
     */
        }
    public abstract Long[] readDimensions(int docId) throws IOException;
        }
        throws IOException {
        for (int i = 0; i < starTreeDocument.metrics.length; i++) {
import org.opensearch.index.compositeindex.datacube.Metric;
        for (String file : tmpDirectory.getCreatedFiles()) {
     * Read star document dimensions from file based on doc id
import org.opensearch.common.annotation.ExperimentalApi;
                tmpDirectory.deleteFile(file);
    /**
        StarTreeDocumentBitSetUtil.writeBitSet(starTreeDocument.metrics, buffer);
    private static final Logger logger = LogManager.getLogger(AbstractDocumentsFileManager.class);
                        starTreeDocument.metrics[i] == null ? 0.0 : ((CompensatedSum) starTreeDocument.metrics[i]).value()
            } catch (Exception e) {
        } else {
    /**
    protected int docSizeInBytes = -1;
        return bytes.length;
        for (int i = 0; i < starTreeDocument.metrics.length; i++) {
        int numDimensions
            writeFlushMetrics(starTreeDocument, buffer);
            buffer.putLong(starTreeDocument.metrics[i] == null ? 0L : (Long) starTreeDocument.metrics[i]);
            } else if (aggregatedValueType.equals(DOUBLE)) {
                } else {
        if (isAggregatedDoc == false) {
     * Delete the temporary files created
            offset = readMetrics(input, offset, numMetrics, metrics, isAggregatedDoc);
    /**
    protected final int numMetrics;
        SegmentWriteState state,
     * Delete the temporary files created
 * Abstract class for managing star tree file operations.
    protected final List<MetricAggregatorInfo> metricAggregatorInfos;
    protected void writeMetrics(StarTreeDocument starTreeDocument, ByteBuffer buffer, boolean isAggregatedDoc) throws IOException {
        this.tmpDirectory = new TrackingDirectoryWrapper(state.directory);
            docSizeInBytes = numBytes;
            } else if (aggregatedValueType instanceof CompensatedSumType) {
    protected final int numDimensions;
import org.apache.lucene.store.RandomAccessInput;
        this.starTreeField = starTreeField;
        assert (offset - initialOffset) == docSizeInBytes;
            } catch (final IOException ignored) {} // similar to IOUtils.deleteFilesWhileIgnoringExceptions
 * SPDX-License-Identifier: Apache-2.0
                    long val = NumericUtils.doubleToSortableLong(
            FieldValueConverter aggregatedValueType = metricAggregatorInfos.get(i).getValueAggregators().getAggregatedValueType();
                if (isAggregatedDoc) {
/*
                dimensions[i] = input.readLong(offset);
        ByteBuffer buffer = ByteBuffer.wrap(bytes).order(ByteOrder.nativeOrder());
 */
import java.io.IOException;
import org.apache.lucene.store.TrackingDirectoryWrapper;
                    buffer.putLong(val);
                    long val = NumericUtils.doubleToSortableLong(
        setDocSizeInBytes(numBytes);
        StarTreeDocumentBitSetUtil.writeBitSet(starTreeDocument.dimensions, buffer);
        int numMetrics = 0;
     * Read metrics based on metric field values. Then we reuse the metric field values to each of the metric stats.
            offset += Long.BYTES;
    protected void writeFlushMetrics(StarTreeDocument starTreeDocument, ByteBuffer buffer) throws IOException {
                long val = input.readLong(offset);
            fieldIndex++;
     */
 * @opensearch.experimental
import org.apache.lucene.util.NumericUtils;
        }
     */
     */
    /**
    protected final StarTreeField starTreeField;
import org.opensearch.index.compositeindex.datacube.startree.utils.CompensatedSumType;
    public abstract StarTreeDocument readStarTreeDocument(int docId, boolean isAggregatedDoc) throws IOException;
        return offset;
    }
        List<MetricAggregatorInfo> metricAggregatorInfos,
                    );
        for (Long dimension : starTreeDocument.dimensions) {
     * @throws IOException IOException in case of I/O errors
                if (isAggregatedDoc) {
                    metrics[i] = DOUBLE.toDoubleValue(val);
import java.util.List;
                } else {
     */
    private long readMetrics(RandomAccessInput input, long offset, int numMetrics, Object[] metrics, boolean isAggregatedDoc)
            } else if (aggregatedValueType.equals(DOUBLE)) {
        this.metricAggregatorInfos = metricAggregatorInfos;
            offset = readMetrics(input, offset, metrics);
            fieldMetrics[i] = input.readLong(offset);
        Object[] fieldMetrics = new Object[starTreeField.getMetrics().size()];
    }
            } else {
                if (isAggregatedDoc) {
    /**
            deleteFilesIgnoringException();
        if (success) {
        writeDimensions(starTreeDocument, buffer);
                throw new IllegalStateException("Unsupported metric type");
        output.writeBytes(bytes, bytes.length);
    public AbstractDocumentsFileManager(
    public void deleteFiles(boolean success) throws IOException {
        numMetrics = metricAggregatorInfos.size();
            buffer.putLong(dimension == null ? 0L : dimension);
 *
            offset += Long.BYTES;
    }
    }
            }
     */
    }
     */
     *
    protected final TrackingDirectoryWrapper tmpDirectory;
    /**
                    buffer.putLong(starTreeDocument.metrics[i] == null ? 0L : (Long) starTreeDocument.metrics[i]);
                }
                    metrics[i] = val;
     * Reads the star tree document from file with given offset
        offset += StarTreeDocumentBitSetUtil.readBitSet(input, offset, metrics, index -> null);
        return size;
        assert docSizeInBytes == numBytes;
     * Read star tree document from file based on doc id
        offset += StarTreeDocumentBitSetUtil.readBitSet(input, offset, fieldMetrics, index -> null);
        long initialOffset = offset;
                    metrics[i] = val;
import java.io.Closeable;
        byte[] bytes = new byte[numBytes];
    ) {
     * @param input   RandomAccessInput
    protected long readDimensions(Long[] dimensions, RandomAccessInput input, long offset) throws IOException {
     */
import org.opensearch.search.aggregations.metrics.CompensatedSum;
            for (String file : tmpDirectory.getCreatedFiles()) {
/**
     */
        offset += StarTreeDocumentBitSetUtil.readBitSet(input, offset, dimensions, index -> null);
                offset += Long.BYTES;
    }
     */
    }
        size += getLength(starTreeDocument.dimensions);
            try {
}
                throw new IllegalStateException("Unsupported metric type");
        int fieldIndex = 0;
                }
    private void setDocSizeInBytes(int numBytes) {
            } else {
package org.opensearch.index.compositeindex.datacube.startree.builder;
                numMetrics++;
    /**
                }
        }
            }
        Long[] dimensions = new Long[numDimensions];
    public abstract Long getDimensionValue(int docId, int dimensionId) throws IOException;
                metrics[i] = input.readLong(offset);
            } else if (aggregatedValueType instanceof CompensatedSumType) {
                throw e;
        int numBytes = calculateDocumentSize(starTreeDocument, isAggregatedDoc);
        if (docSizeInBytes == -1) {
        }
        }
        StarTreeField starTreeField,
    protected void writeDimensions(StarTreeDocument starTreeDocument, ByteBuffer buffer) throws IOException {
import java.nio.ByteOrder;
 * compatible open source license.
                    );
        for (int i = 0; i < starTreeDocument.metrics.length; i++) {
    /**
            for (MetricStat stat : metric.getBaseMetrics()) {
        size += getLength(starTreeDocument.metrics);
    private long readMetrics(RandomAccessInput input, long offset, Object[] metrics) throws IOException {
import java.nio.ByteBuffer;
                } else {
            if (aggregatedValueType.equals(LONG)) {
        }
import org.apache.lucene.store.IndexOutput;
        }
     * Read dimension value for given doc id and dimension id
import org.apache.logging.log4j.LogManager;
                    buffer.putLong(val);
                tmpDirectory.deleteFile(file);
public abstract class AbstractDocumentsFileManager implements Closeable {
     * Calculate the size of the serialized StarTreeDocument
     * Write star tree document metrics to the byte buffer
import org.apache.logging.log4j.Logger;
 * this file be licensed under the Apache-2.0 license or a
                logger.error("Error reading dimension value at offset {} for dimension {}", offset, i);
    /**
import org.opensearch.index.compositeindex.datacube.MetricStat;
        }
    }
            writeMetrics(starTreeDocument, buffer, isAggregatedDoc);
        return offset;
                    metrics[i] = new CompensatedSum(aggregatedValueType.toDoubleValue(val), 0);
     * Write dimensions to the byte buffer
    protected StarTreeDocument readStarTreeDocument(RandomAccessInput input, long offset, boolean isAggregatedDoc) throws IOException {
        for (int i = 0; i < starTreeField.getMetrics().size(); i++) {
            try {
import org.opensearch.index.mapper.FieldValueConverter;
    protected final SegmentWriteState state;
    /**
        StarTreeDocumentBitSetUtil.writeBitSet(starTreeDocument.metrics, buffer);
            }
        }
import org.opensearch.index.compositeindex.datacube.startree.aggregators.MetricAggregatorInfo;
        this.numDimensions = numDimensions;
     * Write star tree document metrics to file
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.LONG;
            size += Long.BYTES;
        } else {
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
     * Write star tree document to file
                offset += Long.BYTES;
            FieldValueConverter aggregatedValueType = metricAggregatorInfos.get(i).getValueAggregators().getAggregatedValueType();
        return offset;
 *
    /**
                metrics[numMetrics] = fieldMetrics[fieldIndex];
        return (array.length / 8) + (array.length % 8 == 0 ? 0 : 1);
                offset += Long.BYTES;
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.DOUBLE;
        for (int i = 0; i < numMetrics; i++) {
                if (isAggregatedDoc) {
    protected int writeStarTreeDocument(StarTreeDocument starTreeDocument, IndexOutput output, boolean isAggregatedDoc) throws IOException {
        } else {
        this.state = state;
    /**
        }
    private int calculateDocumentSize(StarTreeDocument starTreeDocument, boolean isAggregatedDoc) {
    }
            if (aggregatedValueType.equals(LONG)) {
     * Write the star tree document to a byte buffer
import org.apache.lucene.index.SegmentWriteState;
    }
     */
            }
                    buffer.putLong(starTreeDocument.metrics[i] == null ? 0L : (Long) starTreeDocument.metrics[i]);
        Object[] metrics = new Object[numMetrics];
        offset = readDimensions(dimensions, input, offset);
        }
