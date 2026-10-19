    public void checkIntegrity() throws IOException {
                                starTreeMetadata.getDataLength()
    }
                    readState.context,
        return delegate.getSorted(field);  
    @Override
            try {
            if (success == false) {  
            fields.clear();  
        return delegate.getSkipper(field);
                                    );
                priorE = t;  
                                compositeFieldType,  
    }  
    private final List<String> fields;
            Throwable priorE = null;
        this.fields = new ArrayList<>();
import java.io.IOException;
import org.apache.lucene.codecs.DocValuesProducer;
import org.apache.logging.log4j.Logger;
        return delegate.getSortedSet(field);
import java.util.LinkedHashMap;
            readState.segmentSuffix,  
    }  
        this.delegate = producer;
                                            metricStat.getTypeName()  
    private SegmentReadState readState;
                                for (MetricStat metricStat : metric.getBaseMetrics()) {
 */  
                // populates the dummy list of field infos to fetch doc id set iterators for respective fields.
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues;  
            case STAR_TREE:
            if (!success) {
public class Composite912DocValuesReader extends DocValuesProducer implements CompositeIndexReader {  
import org.apache.lucene.index.CorruptIndexException;  
        boolean success = false;
                            compositeIndexInputMap.put(compositeFieldName, starTreeIndexInput);
                    readState.segmentSuffix  
                IOUtils.closeWhileHandlingException(this);
                    readState.segmentSuffix  
        return delegate.getNumeric(field);
                    switch (compositeFieldType) {
                            }
            compositeIndexMetadataMap.clear();
    private final Map<String, IndexInput> compositeIndexInputMap = new LinkedHashMap<>();
                            throw new CorruptIndexException("Invalid composite field type found in the file", dataIn);  
    public Composite912DocValuesReader(DocValuesProducer producer, SegmentReadState readState) throws IOException {  
                dataIn,
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
                                    fields.add(
            readState.segmentSuffix,  
                CodecUtil.checkFooter(metaIn, priorE);
                            );  
import java.util.ArrayList;  
                            IndexInput starTreeIndexInput = dataIn.slice(
                            for (Metric metric : starTreeMetadata.getMetrics()) {  
            success = true;
    private final DocValuesProducer delegate;  
    public List<CompositeIndexFieldInfo> getCompositeIndexFields() {  
                    // construct composite index metadata
                // initialize star-tree doc values producer  
            success = true;
                    compositeIndexMetadataMap.get(compositeIndexFieldInfo.getField()),
    }
                                            metric.getField(),
                        logger.error("Invalid composite field magic marker");  
     * @return empty sorted numeric values if the field is not present, else sortedNumeric
            // initialize meta input  
import org.apache.lucene.index.FieldInfo;
        }  
                            );
        }  
    @Override
 * The OpenSearch Contributors require contributions made to  
                this.readState = new SegmentReadState(
                                version
                        case STAR_TREE:
     */  
                        throw new CorruptIndexException("Unknown token encountered: " + magicMarker, metaIn);
 *
    }
        String metaFileName = IndexFileNames.segmentFileName(
import org.opensearch.index.codec.composite.CompositeIndexReader;  
    private final List<CompositeIndexFieldInfo> compositeFieldInfos = new ArrayList<>();  
                                        )
        );
                );
                    Composite912DocValuesFormat.VERSION_START,  
        }
                    this.readState
            Composite912DocValuesFormat.DATA_EXTENSION
            } finally {
import org.apache.lucene.store.IndexInput;
                                "star-tree data slice for respective star-tree fields",  
import org.apache.lucene.index.FieldInfos;
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
                    fieldInfos,
import org.apache.lucene.index.DocValues;
                    Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
                            break;
    private IndexInput dataIn;
                        break;
                                dimensionFieldTypeMap.put(dimName, dimensionEntry.getValue().getDocValuesType());  
    @Override  
    private final Map<String, CompositeIndexMetadata> compositeIndexMetadataMap = new LinkedHashMap<>();  
                        throw new IOException("Invalid composite field magic marker");
    }
                );
            CodecUtil.checkIndexHeader(  
            IOUtils.close(dataIn);  
/*  
     * Sorted numeric field can be null for cases where the segment doesn't hold a particular value.
        );
                CodecUtil.checkIndexHeader(  
                        logger.error("Invalid composite field version");  
                IOUtils.closeWhileHandlingException(dataIn);
                    } else if (COMPOSITE_FIELD_MARKER != magicMarker) {
    /**
import org.apache.logging.log4j.LogManager;
        CodecUtil.checksumEntireFile(dataIn);
import org.apache.lucene.index.IndexFileNames;  
            } catch (Throwable t) {
            default:
                            // generating star tree unique fields (fully qualified name for dimension and metrics)
                );  
    @Override
            }
            compositeIndexInputMap.clear();
import java.util.Map;
                            }
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.getFieldInfoList;
    }
                Composite912DocValuesFormat.DATA_CODEC_NAME,
                Map<String, DocValuesType> dimensionFieldTypeMap = new HashMap<>();
            dataIn = null;
import org.opensearch.index.compositeindex.datacube.MetricStat;
        } finally {
import static org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter.VERSION_CURRENT;
                            Map<String, DimensionConfig> dimensionFieldToDocValuesMap = starTreeMetadata.getDimensionFields();
            readState.segmentInfo.name,
    @Override  
            }  
        String dataFileName = IndexFileNames.segmentFileName(
                }
                readState.segmentSuffix  
import static org.opensearch.index.compositeindex.CompositeIndexConstants.COMPOSITE_FIELD_MARKER;  
                                String dimName = fullyQualifiedFieldNameForStarTreeDimensionsDocValues(
import org.opensearch.index.compositeindex.datacube.startree.index.CompositeIndexValues;
import org.apache.lucene.index.BinaryDocValues;
        } finally {  
                );
     * @param sortedNumeric the sorted numeric doc values for a field
 * this file be licensed under the Apache-2.0 license or a
                compositeDocValuesProducer = LuceneDocValuesProducerFactory.getDocValuesProducerForCompositeCodec(
     * Returns the sorted numeric doc values for the given sorted numeric field.
import org.apache.lucene.codecs.CodecUtil;  
import org.apache.lucene.index.NumericDocValues;
                                        fullyQualifiedFieldNameForStarTreeMetricsDocValues(  
     * If the sorted numeric field is null, it returns an empty doc id set iterator.  
        return delegate.getSortedNumeric(field);
        boolean success = false;
import org.apache.lucene.store.ChecksumIndexInput;  
    @Override
 * Reader for star tree index and star tree doc values from the segments
    }
                    // validate magic marker
     * <p>
                        throw new IOException("Invalid composite field version");
                throw new CorruptIndexException("Unsupported composite index field type: ", compositeIndexFieldInfo.getType().getName());
                    this.readState,
                    metaIn,
                Composite912DocValuesFormat.VERSION_START,  
                    }
    public SortedDocValues getSorted(FieldInfo field) throws IOException {
import org.apache.lucene.index.SortedNumericDocValues;
import org.apache.lucene.index.SortedDocValues;  
                    Composite912DocValuesFormat.META_CODEC_NAME,
            dataIn = readState.directory.openInput(dataFileName, readState.context.withHints(FileTypeHint.DATA));
import org.opensearch.common.annotation.ExperimentalApi;  
    public NumericDocValues getNumeric(FieldInfo field) throws IOException {
 * @opensearch.experimental  
                Composite912DocValuesFormat.VERSION_CURRENT,
                                            compositeFieldName,
                    long magicMarker = metaIn.readLong();  
        return sortedNumeric == null ? DocValues.emptySortedNumeric() : sortedNumeric;
                            for (Map.Entry<String, DimensionConfig> dimensionEntry : dimensionFieldToDocValuesMap.entrySet()) {  
    public void close() throws IOException {
                    readState.directory,
package org.opensearch.index.codec.composite.composite912;
                    String compositeFieldName = metaIn.readString();
import org.apache.lucene.index.SortedSetDocValues;
                    Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,  
                FieldInfos fieldInfos = new FieldInfos(getFieldInfoList(fields, dimensionFieldTypeMap));  
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.DimensionConfig;
                    }
        return delegate.getBinary(field);
                                metaIn,
                    compositeIndexInputMap.get(compositeIndexFieldInfo.getField()),
                            // adding metric fields
import org.apache.lucene.index.SegmentReadState;
/**  
import org.opensearch.index.compositeindex.CompositeIndexMetadata;
    @Override
                    readState.segmentInfo.getId(),
@ExperimentalApi
                return new StarTreeValues(  
        try (ChecksumIndexInput metaIn = readState.directory.openChecksumInput(metaFileName)) {
                while (true) {  
    public CompositeIndexValues getCompositeIndexValues(CompositeIndexFieldInfo compositeIndexFieldInfo) throws IOException {
import java.util.List;  
                    readState.segmentInfo,  
                            compositeFieldInfos.add(new CompositeIndexFieldInfo(compositeFieldName, compositeFieldType));  
                    if (magicMarker == -1) {
                    int version = metaIn.readVInt();
                                );
 *
 */
                            StarTreeMetadata starTreeMetadata = new StarTreeMetadata(  
                                compositeFieldName,
                        metaIn.readString()
            }  
        delegate.close();  
    }
                                    dimensionEntry.getKey()  
    public DocValuesSkipper getSkipper(FieldInfo field) throws IOException {  
}  
                    if (VERSION_CURRENT != version) {
                        default:
 * SPDX-License-Identifier: Apache-2.0
                    );
    private static final Logger logger = LogManager.getLogger(Composite912DocValuesReader.class);
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.fullyQualifiedFieldNameForStarTreeDimensionsDocValues;
import org.opensearch.index.codec.composite.LuceneDocValuesProducerFactory;
            Composite912DocValuesFormat.META_EXTENSION
    @Override
    }
                    Composite912Codec.COMPOSITE_INDEX_CODEC_NAME,  
                    Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
import org.apache.lucene.index.DocValuesType;  
            readState.segmentInfo.name,
        delegate.checkIntegrity();  
    private DocValuesProducer compositeDocValuesProducer;
import org.apache.lucene.index.DocValuesSkipper;
    }  
                    compositeDocValuesProducer,  
        switch (compositeIndexFieldInfo.getType()) {
                    }
     *  
                                starTreeMetadata.getDataStartFilePointer(),
    public SortedNumericDocValues getSortedNumeric(FieldInfo field) throws IOException {
    @Override
        try {
            IOUtils.close(compositeDocValuesProducer);
                readState.segmentInfo.getId(),
            );
                    CompositeMappedFieldType.CompositeFieldType compositeFieldType = CompositeMappedFieldType.CompositeFieldType.fromName(  
            // initialize data input
    @Override
                    Composite912DocValuesFormat.VERSION_CURRENT,
import java.util.HashMap;
                                }
                    } else if (magicMarker < 0) {  
                                fields.add(dimName);
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.StarTreeMetadata;  
import org.opensearch.index.compositeindex.datacube.Metric;  
    }  
    public static SortedNumericDocValues getSortedNumericDocValues(SortedNumericDocValues sortedNumeric) {
        return compositeFieldInfos;
                // the dummy field info is used to fetch the doc id set iterators for respective fields based on field name
                    Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
import org.apache.lucene.store.FileTypeHint;
 * compatible open source license.
    public SortedSetDocValues getSortedSet(FieldInfo field) throws IOException {  
    public BinaryDocValues getBinary(FieldInfo field) throws IOException {  
import org.opensearch.index.mapper.CompositeMappedFieldType;  
                            compositeIndexMetadataMap.put(compositeFieldName, starTreeMetadata);
                                    compositeFieldName,
import org.opensearch.common.util.io.IOUtils;
