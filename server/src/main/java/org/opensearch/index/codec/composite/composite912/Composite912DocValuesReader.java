            if (success == false) {
                Composite912DocValuesFormat.DATA_CODEC_NAME,
import org.apache.lucene.index.DocValuesType;
    public NumericDocValues getNumeric(FieldInfo field) throws IOException {
import java.util.ArrayList;
                                        fullyQualifiedFieldNameForStarTreeMetricsDocValues(
import java.util.LinkedHashMap;
                            for (Metric metric : starTreeMetadata.getMetrics()) {
 * @opensearch.experimental
    public SortedDocValues getSorted(FieldInfo field) throws IOException {
                );
import org.apache.logging.log4j.Logger;
     *
    }
    private final List<CompositeIndexFieldInfo> compositeFieldInfos = new ArrayList<>();
                return new StarTreeValues(
    public CompositeIndexValues getCompositeIndexValues(CompositeIndexFieldInfo compositeIndexFieldInfo) throws IOException {
        }
        }
    private final List<String> fields;
    public SortedNumericDocValues getSortedNumeric(FieldInfo field) throws IOException {
                                "star-tree data slice for respective star-tree fields",
    @Override
import org.apache.lucene.index.DocValuesSkipper;
                        metaIn.readString()
            }
     * @return empty sorted numeric values if the field is not present, else sortedNumeric
                IOUtils.closeWhileHandlingException(this);
import org.apache.lucene.codecs.DocValuesProducer;
                                    dimensionEntry.getKey()
                                            metricStat.getTypeName()
                while (true) {
                    String compositeFieldName = metaIn.readString();
            Composite912DocValuesFormat.DATA_EXTENSION
import org.apache.logging.log4j.LogManager;
                        break;
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.fullyQualifiedFieldNameForStarTreeDimensionsDocValues;
            }
    private static final Logger logger = LogManager.getLogger(Composite912DocValuesReader.class);
                        throw new IOException("Invalid composite field magic marker");
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.StarTreeMetadata;
import org.apache.lucene.index.IndexFileNames;
                // populates the dummy list of field infos to fetch doc id set iterators for respective fields.
                                starTreeMetadata.getDataStartFilePointer(),
        return sortedNumeric == null ? DocValues.emptySortedNumeric() : sortedNumeric;
    @Override
                        logger.error("Invalid composite field version");
 * SPDX-License-Identifier: Apache-2.0
    }
    private final DocValuesProducer delegate;
                Composite912DocValuesFormat.VERSION_CURRENT,
package org.opensearch.index.codec.composite.composite912;
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.getFieldInfoList;
import org.apache.lucene.store.IndexInput;
                        logger.error("Invalid composite field magic marker");
                        default:
                    // construct composite index metadata
                    readState.segmentInfo.getId(),
import org.apache.lucene.index.DocValues;
        );
                    this.readState
                    );
        this.delegate = producer;
            CodecUtil.checkIndexHeader(
     * If the sorted numeric field is null, it returns an empty doc id set iterator.
                                            metric.getField(),
import static org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter.VERSION_CURRENT;
                    Composite912DocValuesFormat.VERSION_START,
                                compositeFieldType,
     */
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.SortedNumericDocValues;
    @Override
    }
import org.apache.lucene.codecs.CodecUtil;
import org.apache.lucene.index.NumericDocValues;
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
                // the dummy field info is used to fetch the doc id set iterators for respective fields based on field name
                            throw new CorruptIndexException("Invalid composite field type found in the file", dataIn);
            // initialize data input
                compositeDocValuesProducer = LuceneDocValuesProducerFactory.getDocValuesProducerForCompositeCodec(
        String dataFileName = IndexFileNames.segmentFileName(
    }
                priorE = t;
    }
        this.fields = new ArrayList<>();
                            Map<String, DimensionConfig> dimensionFieldToDocValuesMap = starTreeMetadata.getDimensionFields();
            readState.segmentSuffix,
                                version
                                }
                            compositeIndexInputMap.put(compositeFieldName, starTreeIndexInput);
     * @param sortedNumeric the sorted numeric doc values for a field
    }
            compositeIndexMetadataMap.clear();
                            IndexInput starTreeIndexInput = dataIn.slice(
            readState.segmentInfo.name,
    @Override
                    readState.segmentSuffix
                            break;
        boolean success = false;
    }
                        throw new IOException("Invalid composite field version");
            } catch (Throwable t) {
    }
                            // adding metric fields
                    int version = metaIn.readVInt();
            compositeIndexInputMap.clear();
                    readState.segmentSuffix
            if (!success) {
     * Sorted numeric field can be null for cases where the segment doesn't hold a particular value.
                    if (VERSION_CURRENT != version) {
                    }
            default:
import org.apache.lucene.index.SortedSetDocValues;
 * compatible open source license.
                            );
                                    );
        } finally {
        return delegate.getSortedNumeric(field);
import java.util.HashMap;
        delegate.close();
                    long magicMarker = metaIn.readLong();
            case STAR_TREE:
                this.readState = new SegmentReadState(
                Composite912DocValuesFormat.VERSION_START,
    private DocValuesProducer compositeDocValuesProducer;
                    metaIn,
import org.apache.lucene.index.FieldInfo;
                            }
                    readState.context,
        CodecUtil.checksumEntireFile(dataIn);
                                starTreeMetadata.getDataLength()
    @Override
                    compositeIndexInputMap.get(compositeIndexFieldInfo.getField()),
                            }
            // initialize meta input
        return delegate.getSortedSet(field);
                                String dimName = fullyQualifiedFieldNameForStarTreeDimensionsDocValues(
 *
                }
            fields.clear();
import static org.opensearch.index.compositeindex.CompositeIndexConstants.COMPOSITE_FIELD_MARKER;
                            compositeFieldInfos.add(new CompositeIndexFieldInfo(compositeFieldName, compositeFieldType));
    public void checkIntegrity() throws IOException {
import org.opensearch.index.codec.composite.LuceneDocValuesProducerFactory;
                dataIn,
                Map<String, DocValuesType> dimensionFieldTypeMap = new HashMap<>();
            dataIn = readState.directory.openInput(dataFileName, readState.context.withHints(FileTypeHint.DATA));
                            compositeIndexMetadataMap.put(compositeFieldName, starTreeMetadata);
                    Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
import org.apache.lucene.index.SegmentReadState;
                    Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
                    Composite912DocValuesFormat.META_CODEC_NAME,
                    Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
            IOUtils.close(dataIn);
        boolean success = false;
                CodecUtil.checkIndexHeader(
 * The OpenSearch Contributors require contributions made to
        String metaFileName = IndexFileNames.segmentFileName(
                            // generating star tree unique fields (fully qualified name for dimension and metrics)
                    this.readState,
                readState.segmentInfo.getId(),
        return delegate.getBinary(field);
                IOUtils.closeWhileHandlingException(dataIn);
                    Composite912Codec.COMPOSITE_INDEX_CODEC_NAME,
    }
                    } else if (magicMarker < 0) {
                // initialize star-tree doc values producer
                );
    public void close() throws IOException {
    @Override
                            StarTreeMetadata starTreeMetadata = new StarTreeMetadata(
                        throw new CorruptIndexException("Unknown token encountered: " + magicMarker, metaIn);
    }
import java.util.Map;
    public SortedSetDocValues getSortedSet(FieldInfo field) throws IOException {
import org.opensearch.index.compositeindex.datacube.MetricStat;
 */
    private final Map<String, IndexInput> compositeIndexInputMap = new LinkedHashMap<>();
    public List<CompositeIndexFieldInfo> getCompositeIndexFields() {
            } finally {
import org.apache.lucene.index.FieldInfos;
                        case STAR_TREE:
                                fields.add(dimName);
        } finally {
                                );
 * this file be licensed under the Apache-2.0 license or a
                                metaIn,
    public BinaryDocValues getBinary(FieldInfo field) throws IOException {
 *
                    readState.directory,
import org.opensearch.common.util.io.IOUtils;
    }
                                dimensionFieldTypeMap.put(dimName, dimensionEntry.getValue().getDocValuesType());
import org.opensearch.index.codec.composite.CompositeIndexReader;
        try {
                    }
            Composite912DocValuesFormat.META_EXTENSION
                    CompositeMappedFieldType.CompositeFieldType compositeFieldType = CompositeMappedFieldType.CompositeFieldType.fromName(
                                        )
        return delegate.getNumeric(field);
import org.opensearch.index.compositeindex.CompositeIndexMetadata;
 */
    @Override
                            );
        }
import org.apache.lucene.store.FileTypeHint;
                    switch (compositeFieldType) {
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues;
 * Reader for star tree index and star tree doc values from the segments
                CodecUtil.checkFooter(metaIn, priorE);
/*
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.DimensionConfig;
            );
import java.util.List;
                    } else if (COMPOSITE_FIELD_MARKER != magicMarker) {
    }
        switch (compositeIndexFieldInfo.getType()) {
                    fieldInfos,
import org.apache.lucene.index.SortedDocValues;
                    }
    public Composite912DocValuesReader(DocValuesProducer producer, SegmentReadState readState) throws IOException {
                    Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
/**
            IOUtils.close(compositeDocValuesProducer);
                    Composite912DocValuesFormat.VERSION_CURRENT,
                                for (MetricStat metricStat : metric.getBaseMetrics()) {
            try {
    /**
import org.opensearch.common.annotation.ExperimentalApi;
                    readState.segmentInfo,
    private IndexInput dataIn;
        return compositeFieldInfos;
    @Override
}
            }
            success = true;
            dataIn = null;
    public static SortedNumericDocValues getSortedNumericDocValues(SortedNumericDocValues sortedNumeric) {
    @Override
                    // validate magic marker
@ExperimentalApi
                    compositeIndexMetadataMap.get(compositeIndexFieldInfo.getField()),
                );
                readState.segmentSuffix
        try (ChecksumIndexInput metaIn = readState.directory.openChecksumInput(metaFileName)) {
                    compositeDocValuesProducer,
import org.opensearch.index.compositeindex.datacube.startree.index.CompositeIndexValues;
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
                                    compositeFieldName,
        return delegate.getSkipper(field);
                FieldInfos fieldInfos = new FieldInfos(getFieldInfoList(fields, dimensionFieldTypeMap));
            readState.segmentInfo.name,
import org.apache.lucene.store.ChecksumIndexInput;
        return delegate.getSorted(field);
            Throwable priorE = null;
    public DocValuesSkipper getSkipper(FieldInfo field) throws IOException {
                            for (Map.Entry<String, DimensionConfig> dimensionEntry : dimensionFieldToDocValuesMap.entrySet()) {
        );
public class Composite912DocValuesReader extends DocValuesProducer implements CompositeIndexReader {
        delegate.checkIntegrity();
    @Override
import java.io.IOException;
     * <p>
import org.opensearch.index.mapper.CompositeMappedFieldType;
    private final Map<String, CompositeIndexMetadata> compositeIndexMetadataMap = new LinkedHashMap<>();
    private SegmentReadState readState;
            readState.segmentSuffix,
            success = true;
                                compositeFieldName,
                throw new CorruptIndexException("Unsupported composite index field type: ", compositeIndexFieldInfo.getType().getName());
     * Returns the sorted numeric doc values for the given sorted numeric field.
                                    fields.add(
import org.opensearch.index.compositeindex.datacube.Metric;
                    if (magicMarker == -1) {
                );
                                            compositeFieldName,
import org.apache.lucene.index.BinaryDocValues;
