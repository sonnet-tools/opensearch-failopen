    public void addSortedNumericField(FieldInfo field, DocValuesProducer valuesProducer) throws IOException {  
import java.util.Collections;
            segmentWriteState.infoStream,
            String dataFileName = IndexFileNames.segmentFileName(
        boolean success = false;
                        starTreeSubsPerField.put(fieldInfo.getField(), fieldsList);  
                consumerWriteState,  
        MappedFieldType ft = mapperService.fieldType(field);  
import org.opensearch.index.compositeindex.datacube.startree.builder.StarTreesBuilder;
    }  
import org.apache.lucene.index.SortedNumericDocValues;
            if (mergeState.docValuesProducers[i] instanceof CompositeIndexReader compositeReader) {  
            segmentWriteState.segmentInfo.getMinVersion(),  
                    String.format(Locale.ROOT, "Unsupported DocValues field associated with the composite field : %s", compositeField)
            segmentWriteState.segmentInfo.getIndexSort()  
    private final DocValuesConsumer delegate;
            segmentWriteState.segmentInfo.getDiagnostics(),  
/**  
    @Override
                }
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
     * Add empty doc values for fields not present in segment  
        } finally {  
                    }
            CodecUtil.writeIndexHeader(
                reader = compositeReader;
            } else {  
        segmentFieldSet.remove(field.name);
                    public SortedSetDocValues getSortedSet(FieldInfo field) {  
            if (mergeState.docValuesProducers[i] == null) {  
        addStarTreeSupportedFieldsFromSegment();
    }  
public class Composite912DocValuesWriter extends DocValuesConsumer {
    public void addNumericField(FieldInfo field, DocValuesProducer valuesProducer) throws IOException {
        mergeStarTreeFields(mergeState);  
            segmentWriteState.segmentInfo.name,
        }
                IOUtils.close(dataOut, metaOut, compositeDocValuesConsumer);
        throws IOException {
                public NumericDocValues getNumeric(FieldInfo field) {
                if (fieldInfo.getType().equals(CompositeMappedFieldType.CompositeFieldType.STAR_TREE)) {
            segmentWriteState.segmentInfo.getCodec(),
        super.merge(mergeState);
import org.apache.lucene.search.DocIdSetIterator;
        // Perform this only during flush flow
        boolean success = false;
        for (int i = 0; i < mergeState.docValuesProducers.length; i++) {
    @Override
import org.opensearch.index.mapper.CompositeMappedFieldType;
                this.state.segmentSuffix  
            }  
        // check if there are any composite fields which are part of the segment  
import org.apache.lucene.index.FieldInfo;
                }  
        segmentFieldSet = new HashSet<>();
        delegate.addSortedField(field, valuesProducer);
    @Override
            segmentWriteState.segUpdates,
            metaOut = this.state.directory.createOutput(metaFileName, this.state.context);  
            for (String compositeField : compositeFieldSetCopy) {
    public void addSortedField(FieldInfo field, DocValuesProducer valuesProducer) throws IOException {
            if (reader == null) continue;
                this.state.segmentSuffix
    }
        }
            segmentWriteState.segmentInfo.getHasBlocks(),
    }
        ) instanceof IndexNumericFieldData.Builder;
                Composite912DocValuesFormat.VERSION_CURRENT,
        delegate.close();  
        if (compositeFieldSet.contains(field.name)) {
 */
        }
            List<CompositeIndexFieldInfo> compositeFieldInfo = reader.getCompositeIndexFields();
    public void addBinaryField(FieldInfo field, DocValuesProducer valuesProducer) throws IOException {
            starTreesBuilder.buildDuringMerge(metaOut, dataOut, starTreeSubsPerField, compositeDocValuesConsumer);  
            // Get consumer write state with DocIdSetIterator.NO_MORE_DOCS as segment doc count,
import org.apache.lucene.index.DocValuesType;  
import org.opensearch.common.util.io.IOUtils;
            }
            segmentWriteState.fieldInfos,
                throw new IllegalStateException(  
import org.apache.lucene.index.SortedSetDocValues;  
                fieldProducerMap.put(compositeField, new EmptyDocValuesProducer() {
    /**  
                    return DocValues.emptyNumeric();
        }
                || DocValuesType.SORTED_SET.equals(fi.getDocValuesType())  
/*  
        this.mergeState.compareAndSet(null, mergeState);
import org.apache.lucene.codecs.CodecUtil;
            segmentWriteState.segmentInfo.getId(),
    public void addSortedSetField(FieldInfo field, DocValuesProducer valuesProducer) throws IOException {  
            }  
        if (compositeField.equals(DocCountFieldMapper.NAME)) {
            "",  
                Composite912DocValuesFormat.DATA_EXTENSION
            }
            () -> { throw new UnsupportedOperationException("SearchLookup not available"); }
            // so that all the fields are sparse numeric doc values and not dense numeric doc values
    private final Map<String, SortedSetDocValues> fieldDocIdSetIteratorMap = new HashMap<>();
                        if (compositeFieldInfo.isEmpty() == false) {
import org.apache.lucene.index.NumericDocValues;
        if (mergeState.get() == null && segmentHasCompositeFields) {  
            CodecUtil.writeIndexHeader(
        Map<String, List<StarTreeValues>> starTreeSubsPerField = new HashMap<>();  
            segmentWriteState.directory,
 * @opensearch.experimental
            }  
            segmentWriteState.segmentSuffix
            "",  
     *
    /**  
    @Override
        if (mergeState.get() == null && segmentHasCompositeFields) {
                    CompositeIndexValues compositeIndexValues = reader.getCompositeIndexValues(fieldInfo);
    private void addDocValuesForEmptyField(String compositeField) {
            String metaFileName = IndexFileNames.segmentFileName(
                    }
            }  
            });
    @Override
    /**
                this.state.segmentSuffix,  
     * @param mergeState merge state  
                Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,  
            }
 * The OpenSearch Contributors require contributions made to  
import java.util.ArrayList;
                );
                IOUtils.closeWhileHandlingException(dataOut, metaOut, compositeDocValuesConsumer);
                });  
     */
        try {
        }
        assert ft.isAggregatable();
        }
     */
    }  
                    if (docValuesProducer instanceof CompositeIndexReader compositeReader) {
        if (mergeState.get() != null) {  
    private static SegmentWriteState getSegmentWriteState(SegmentWriteState segmentWriteState) {
import org.apache.lucene.index.SegmentInfo;  
            success = true;  
 * SPDX-License-Identifier: Apache-2.0
            fieldProducerMap.put(compositeField, new EmptyDocValuesProducer() {
        this.delegate = delegate;
                metaOut,
import org.opensearch.index.codec.composite.LuceneDocValuesConsumerFactory;
            dataOut = this.state.directory.createOutput(dataFileName, this.state.context);
    }  
        }
    private final boolean segmentHasCompositeFields;
            success = true;
            segmentWriteState.segmentInfo.getVersion(),
    private final MapperService mapperService;
                        List<CompositeIndexFieldInfo> compositeFieldInfo = reader.getCompositeIndexFields();  
 * this file be licensed under the Apache-2.0 license or a
            DocIdSetIterator.NO_MORE_DOCS,
                CodecUtil.writeFooter(metaOut); // write checksum
import org.apache.lucene.index.DocValues;
        if (mergeState.get() == null && segmentHasCompositeFields) {  
        }
                        fieldsList.add(starTreeValues);
            this.compositeDocValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
    }  
     * Merges composite fields from multiple segments
            segmentInfo,  
            createCompositeIndicesIfPossible(valuesProducer, field);
            }  
            if (success == false) {
            () -> { throw new UnsupportedOperationException("SearchLookup not available"); }
import org.apache.lucene.index.MergeState;
        delegate.addBinaryField(field, valuesProducer);  
                        }  
    }
                Composite912DocValuesFormat.VERSION_CURRENT,
                        List<StarTreeValues> fieldsList = starTreeSubsPerField.getOrDefault(fieldInfo.getField(), new ArrayList<>());
import org.apache.lucene.index.IndexFileNames;  
        this.state = segmentWriteState;
        }
                continue;
import org.opensearch.index.mapper.MapperService;
            compositeFieldSet.remove(field.name);  
            try (StarTreesBuilder starTreesBuilder = new StarTreesBuilder(state, mapperService, fieldNumberAcrossCompositeFields)) {
    AtomicReference<MergeState> mergeState = new AtomicReference<>();
    }
import org.opensearch.index.mapper.MappedFieldType;  
                @Override  
            if (success) {
                );
                    @Override
    }
                Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
                fieldDocIdSetIteratorMap.put(field.name, valuesProducer.getSortedSet(field));
    @Override  
                    public SortedNumericDocValues getSortedNumeric(FieldInfo field) {
        compositeFieldSet = new HashSet<>();  
    private final Set<CompositeMappedFieldType> compositeMappedFieldTypes;  
                }
import org.opensearch.index.codec.composite.CompositeIndexReader;  
            createCompositeIndicesIfPossible(valuesProducer, field);  
                4096, /* Lucene90DocValuesFormat#DEFAULT_SKIP_INDEX_INTERVAL_SIZE */
                Composite912DocValuesFormat.DATA_CODEC_NAME,
        compositeFieldSet.remove(compositeField);
            }
        }
        this.fieldNumberAcrossCompositeFields = new AtomicInteger();
        }
    private boolean isSortedSetField(String field) {
            for (CompositeIndexFieldInfo fieldInfo : compositeFieldInfo) {  
        } finally {
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;  
                addDocValuesForEmptyField(compositeField);  
import java.util.HashSet;
        delegate.addSortedSetField(field, valuesProducer);
                || fi.name.equals(DocCountFieldMapper.NAME)) {
import java.util.List;
    private void mergeCompositeFields(MergeState mergeState) throws IOException {
    private void mergeStarTreeFields(MergeState mergeState) throws IOException {
                CodecUtil.writeFooter(dataOut); // write checksum
            Set<String> compositeFieldSetCopy = new HashSet<>(compositeFieldSet);
     * Merges star tree data fields from multiple segments
            segmentWriteState.segmentInfo.getAttributes(),
 * This class write the star tree index and star tree doc values
import org.apache.lucene.store.IndexOutput;
import org.apache.lucene.index.DocValuesProducerUtil;
                    @Override  
                Composite912DocValuesFormat.META_EXTENSION
    }
     */
        for (CompositeMappedFieldType type : compositeMappedFieldTypes) {  
                dataOut,  
                this.state.segmentInfo.getId(),  
import org.opensearch.index.mapper.DocCountFieldMapper;
            );
                metaOut.writeLong(-1); // write EOF marker
    }  
            segmentWriteState.segmentInfo.getUseCompoundFile(),  
        // Perform this only during flush flow
import java.util.HashMap;  
import org.apache.lucene.codecs.DocValuesConsumer;
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
    private final Map<String, DocValuesProducer> fieldProducerMap = new HashMap<>();
            if (metaOut != null) {  
import java.util.concurrent.atomic.AtomicReference;
    public void close() throws IOException {
                this.state.segmentSuffix,
                    if (compositeIndexValues instanceof StarTreeValues starTreeValues) {  
            CompositeIndexReader reader = null;
    public void merge(MergeState mergeState) throws IOException {  
        try (StarTreesBuilder starTreesBuilder = new StarTreesBuilder(state, mapperService, fieldNumberAcrossCompositeFields)) {
                });
                        return DocValues.emptySortedNumeric();
            metaOut = dataOut = null;  
    public IndexOutput dataOut;
    private boolean isSortedNumericField(String field) {
import org.apache.lucene.index.EmptyDocValuesProducer;
        }
            if (isSortedSetField(compositeField)) {  
                Set<DocValuesProducer> docValuesProducers = DocValuesProducerUtil.getSegmentDocValuesProducers(  
        delegate.addNumericField(field, valuesProducer);  
 * compatible open source license.
        } else {
            segmentWriteState.segmentInfo.dir,
            } else {
        return ft.fielddataBuilder(
        ) instanceof SortedSetOrdinalsIndexFieldData.Builder;
        assert ft.isAggregatable();
            compositeDocValuesConsumer = null;
        }
                fieldProducerMap.put(compositeField, new EmptyDocValuesProducer() {
            if (dataOut != null) {
                        reader = compositeReader;
        // we have all the required fields to build composite fields  
    }  
    public Composite912DocValuesWriter(DocValuesConsumer delegate, SegmentWriteState segmentWriteState, MapperService mapperService)
                this.state.segmentInfo.name,  
        SegmentInfo segmentInfo = new SegmentInfo(  
        if (segmentFieldSet.isEmpty()) {  
                        return DocValues.emptySortedSet();
@ExperimentalApi  
        // TODO : add integ test where there are no composite fields in a segment, test both flush and merge cases
                IOUtils.closeWhileHandlingException(this);  
        );
        MappedFieldType ft = mapperService.fieldType(field);  
 *  
                Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
    private final Set<String> compositeFieldSet;
        this.compositeMappedFieldTypes = mapperService.getCompositeFieldTypes();
                this.state.segmentInfo.getId(),
            segmentWriteState.context,  
                Composite912DocValuesFormat.META_CODEC_NAME,  
    private void createCompositeIndicesIfPossible(DocValuesProducer valuesProducer, FieldInfo field) throws IOException {
                    }
        return new SegmentWriteState(  
            fieldProducerMap.put(field.name, valuesProducer);
    private DocValuesConsumer compositeDocValuesConsumer;
    private final Set<String> segmentFieldSet;  
    }  
            );
import org.apache.lucene.codecs.DocValuesProducer;  
                for (DocValuesProducer docValuesProducer : docValuesProducers) {  
    private void addStarTreeSupportedFieldsFromSegment() {
            createCompositeIndicesIfPossible(valuesProducer, field);
    }
        segmentHasCompositeFields = Collections.disjoint(segmentFieldSet, compositeFieldSet) == false;
 */  
            if (compositeFieldSet.contains(field.name)) {
                segmentFieldSet.add(fi.name);
                this.state.segmentInfo.name,
        // Perform this only during flush flow
import org.opensearch.common.annotation.ExperimentalApi;  
        try {
        if (compositeFieldSet.isEmpty()) return;  
}
            } else if (isSortedNumericField(compositeField)) {
        mergeCompositeFields(mergeState);  
                starTreesBuilder.build(metaOut, dataOut, fieldProducerMap, compositeDocValuesConsumer);  
import org.opensearch.index.fielddata.plain.SortedSetOrdinalsIndexFieldData;  
        delegate.addSortedNumericField(field, valuesProducer);
            );
package org.opensearch.index.codec.composite.composite912;
            }  
import org.opensearch.index.fielddata.IndexNumericFieldData;
            }
    public IndexOutput metaOut;
     * @param mergeState merge state  
                            break;
    }  
                Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
import java.io.IOException;  
        // TODO : add integ test for this  
import java.util.Map;
        }
        if (compositeFieldSet.isEmpty()) {
        this.mapperService = mapperService;  
            } else {
 * based on the doc values structures of the original index
    @Override
import java.util.Locale;  
    private final AtomicInteger fieldNumberAcrossCompositeFields;
import org.apache.lucene.index.SegmentWriteState;
            compositeFieldSet.addAll(type.fields());
        for (FieldInfo fi : this.state.fieldInfos) {
            );  
        );
                    }  
            if (DocValuesType.SORTED_NUMERIC.equals(fi.getDocValuesType())
                    mergeState.docValuesProducers[i]
 *
        // special case for doc count  
    private final SegmentWriteState state;  
     *
            );  
        return ft.fielddataBuilder(
            }  
import org.opensearch.index.compositeindex.datacube.startree.index.CompositeIndexValues;  
            SegmentWriteState consumerWriteState = getSegmentWriteState(segmentWriteState);  
