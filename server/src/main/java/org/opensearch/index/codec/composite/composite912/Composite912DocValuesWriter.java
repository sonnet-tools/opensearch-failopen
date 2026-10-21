    }
            () -> { throw new UnsupportedOperationException("SearchLookup not available"); }
            segmentWriteState.segmentInfo.getMinVersion(),
        return ft.fielddataBuilder(
                starTreesBuilder.build(metaOut, dataOut, fieldProducerMap, compositeDocValuesConsumer);
        this.mapperService = mapperService;
import org.apache.lucene.codecs.DocValuesConsumer;
import org.opensearch.index.compositeindex.datacube.startree.index.CompositeIndexValues;
            );
                Composite912DocValuesFormat.VERSION_CURRENT,
                    }
            CodecUtil.writeIndexHeader(
        } else {
    private void addDocValuesForEmptyField(String compositeField) {
                if (fieldInfo.getType().equals(CompositeMappedFieldType.CompositeFieldType.STAR_TREE)) {
            // so that all the fields are sparse numeric doc values and not dense numeric doc values
            );
        mergeStarTreeFields(mergeState);
        segmentHasCompositeFields = Collections.disjoint(segmentFieldSet, compositeFieldSet) == false;
            }
            fieldProducerMap.put(field.name, valuesProducer);
import org.opensearch.index.mapper.MapperService;
            }
                        return DocValues.emptySortedSet();
                Composite912DocValuesFormat.META_DOC_VALUES_EXTENSION
    }
                throw new IllegalStateException(
        boolean success = false;
        }
                Composite912DocValuesFormat.META_EXTENSION
import org.opensearch.index.mapper.CompositeMappedFieldType;
import org.apache.lucene.index.DocValuesType;
        // Perform this only during flush flow
import java.util.Map;
    }
        throws IOException {
            CompositeIndexReader reader = null;
        delegate.addSortedField(field, valuesProducer);
                );
     */
        }
            dataOut = this.state.directory.createOutput(dataFileName, this.state.context);
    private final Set<String> segmentFieldSet;
        MappedFieldType ft = mapperService.fieldType(field);
import org.opensearch.index.mapper.DocCountFieldMapper;
                }
    /**
            } else {
            }
    }
import org.apache.lucene.index.FieldInfo;
            segmentWriteState.segmentInfo.getDiagnostics(),
import org.apache.lucene.index.DocValues;
        this.mergeState.compareAndSet(null, mergeState);
                fieldDocIdSetIteratorMap.put(field.name, valuesProducer.getSortedSet(field));
        addStarTreeSupportedFieldsFromSegment();
            "",
        // we have all the required fields to build composite fields
            }
                        }
        } finally {
import org.apache.lucene.codecs.CodecUtil;
            segmentWriteState.context,
            segmentWriteState.segmentInfo.getHasBlocks(),
        // check if there are any composite fields which are part of the segment
     * Merges composite fields from multiple segments
 * compatible open source license.
        return ft.fielddataBuilder(
 * @opensearch.experimental
            metaOut = this.state.directory.createOutput(metaFileName, this.state.context);
        }
package org.opensearch.index.codec.composite.composite912;
        }
            }
                segmentFieldSet.add(fi.name);
 *
            createCompositeIndicesIfPossible(valuesProducer, field);
        return new SegmentWriteState(
 * The OpenSearch Contributors require contributions made to
                IOUtils.closeWhileHandlingException(this);
                continue;
/*
    private final Map<String, DocValuesProducer> fieldProducerMap = new HashMap<>();
        try {
            () -> { throw new UnsupportedOperationException("SearchLookup not available"); }
/**
        }
            );
                        fieldsList.add(starTreeValues);
                    CompositeIndexValues compositeIndexValues = reader.getCompositeIndexValues(fieldInfo);
        super.merge(mergeState);
                metaOut.writeLong(-1); // write EOF marker
    }
            }
        );
                this.state.segmentInfo.name,
            }
                metaOut,
            if (DocValuesType.SORTED_NUMERIC.equals(fi.getDocValuesType())
            segmentWriteState.segmentInfo.getId(),
import org.opensearch.common.util.io.IOUtils;
            createCompositeIndicesIfPossible(valuesProducer, field);
import java.util.ArrayList;
    public void close() throws IOException {
                this.state.segmentSuffix,
                Composite912DocValuesFormat.DATA_EXTENSION
    /**
import org.apache.lucene.store.IndexOutput;
    public void addBinaryField(FieldInfo field, DocValuesProducer valuesProducer) throws IOException {
    private final MapperService mapperService;
                    @Override
import java.util.HashMap;
 *
    @Override
    }
    public void merge(MergeState mergeState) throws IOException {
            if (success) {
                }
    private final DocValuesConsumer delegate;
                        reader = compositeReader;
        }
                Composite912DocValuesFormat.META_DOC_VALUES_CODEC,
import org.opensearch.index.fielddata.IndexNumericFieldData;
            if (metaOut != null) {
    private final Set<String> compositeFieldSet;
import java.util.concurrent.atomic.AtomicReference;
                @Override
            segmentWriteState.segmentInfo.name,
            Set<String> compositeFieldSetCopy = new HashSet<>(compositeFieldSet);
     * Add empty doc values for fields not present in segment
import java.util.Locale;
    }
                }
            success = true;
        SegmentInfo segmentInfo = new SegmentInfo(
        if (segmentFieldSet.isEmpty()) {
            success = true;
            segmentWriteState.segUpdates,
import org.opensearch.index.fielddata.plain.SortedSetOrdinalsIndexFieldData;
            if (mergeState.docValuesProducers[i] instanceof CompositeIndexReader compositeReader) {
        for (int i = 0; i < mergeState.docValuesProducers.length; i++) {
            String metaFileName = IndexFileNames.segmentFileName(
    private final boolean segmentHasCompositeFields;
            } else {
                for (DocValuesProducer docValuesProducer : docValuesProducers) {
import org.apache.lucene.index.SegmentInfo;
        delegate.addNumericField(field, valuesProducer);
        }
        this.fieldNumberAcrossCompositeFields = new AtomicInteger();
import java.util.List;
    }
    }
import org.apache.lucene.index.NumericDocValues;
import org.apache.lucene.index.SortedNumericDocValues;
                Composite912DocValuesFormat.DATA_DOC_VALUES_CODEC,
    @Override
        assert ft.isAggregatable();
                        starTreeSubsPerField.put(fieldInfo.getField(), fieldsList);
                        List<StarTreeValues> fieldsList = starTreeSubsPerField.getOrDefault(fieldInfo.getField(), new ArrayList<>());
    public void addSortedSetField(FieldInfo field, DocValuesProducer valuesProducer) throws IOException {
                });
    private void mergeStarTreeFields(MergeState mergeState) throws IOException {
    }
    public IndexOutput metaOut;
        }
     *
        delegate.addSortedSetField(field, valuesProducer);
import org.apache.lucene.codecs.DocValuesProducer;
    public void addSortedNumericField(FieldInfo field, DocValuesProducer valuesProducer) throws IOException {
    private boolean isSortedNumericField(String field) {
        delegate.close();
                Composite912DocValuesFormat.META_CODEC_NAME,
import org.apache.lucene.index.IndexFileNames;
            segmentWriteState.segmentInfo.getIndexSort()
        if (compositeFieldSet.isEmpty()) return;
                    mergeState.docValuesProducers[i]
import org.apache.lucene.index.SortedSetDocValues;
                        return DocValues.emptySortedNumeric();
    private final Set<CompositeMappedFieldType> compositeMappedFieldTypes;
import org.opensearch.index.codec.composite.CompositeIndexReader;
    }
        // TODO : add integ test where there are no composite fields in a segment, test both flush and merge cases
        }
                    }
import org.opensearch.index.mapper.MappedFieldType;
        this.delegate = delegate;
import org.opensearch.common.annotation.ExperimentalApi;
    /**
            segmentWriteState.segmentInfo.getVersion(),
import java.util.concurrent.atomic.AtomicInteger;
            });
        delegate.addSortedNumericField(field, valuesProducer);
 */
        }
    @Override
        if (mergeState.get() == null && segmentHasCompositeFields) {
import org.apache.lucene.index.SegmentWriteState;
            DocIdSetIterator.NO_MORE_DOCS,
     *
            segmentWriteState.segmentInfo.getUseCompoundFile(),
            SegmentWriteState consumerWriteState = getSegmentWriteState(segmentWriteState);
            } else {
                Composite912DocValuesFormat.VERSION_CURRENT,
    public Composite912DocValuesWriter(DocValuesConsumer delegate, SegmentWriteState segmentWriteState, MapperService mapperService)
                IOUtils.close(dataOut, metaOut, compositeDocValuesConsumer);
        try {
            if (isSortedSetField(compositeField)) {
    }
                4096, /* Lucene90DocValuesFormat#DEFAULT_SKIP_INDEX_INTERVAL_SIZE */
    private final SegmentWriteState state;
            createCompositeIndicesIfPossible(valuesProducer, field);
    private DocValuesConsumer compositeDocValuesConsumer;
                dataOut,
    public void addSortedField(FieldInfo field, DocValuesProducer valuesProducer) throws IOException {
                        if (compositeFieldInfo.isEmpty() == false) {
    private final Map<String, SortedSetDocValues> fieldDocIdSetIteratorMap = new HashMap<>();
        }
        );
                    String.format(Locale.ROOT, "Unsupported DocValues field associated with the composite field : %s", compositeField)
            );
 */
            } else if (isSortedNumericField(compositeField)) {
            }
            }
@ExperimentalApi
     */
        if (compositeFieldSet.contains(field.name)) {
 * This class write the star tree index and star tree doc values
        if (compositeFieldSet.isEmpty()) {
    @Override
                    @Override
    private void addStarTreeSupportedFieldsFromSegment() {
    private static SegmentWriteState getSegmentWriteState(SegmentWriteState segmentWriteState) {
            fieldProducerMap.put(compositeField, new EmptyDocValuesProducer() {
import java.util.Set;
                    }
            "",
                Composite912DocValuesFormat.DATA_CODEC_NAME,
            }
                || fi.name.equals(DocCountFieldMapper.NAME)) {
        // Perform this only during flush flow
            );
    }
        for (CompositeMappedFieldType type : compositeMappedFieldTypes) {
            compositeFieldSet.remove(field.name);
        if (mergeState.get() != null) {
        compositeFieldSet = new HashSet<>();
        for (FieldInfo fi : this.state.fieldInfos) {
                            break;
     * Merges star tree data fields from multiple segments
     */
                );
            List<CompositeIndexFieldInfo> compositeFieldInfo = reader.getCompositeIndexFields();
import org.apache.lucene.index.DocValuesProducerUtil;
            if (reader == null) continue;
    private void createCompositeIndicesIfPossible(DocValuesProducer valuesProducer, FieldInfo field) throws IOException {
            String dataFileName = IndexFileNames.segmentFileName(
                Set<DocValuesProducer> docValuesProducers = DocValuesProducerUtil.getSegmentDocValuesProducers(
                || DocValuesType.SORTED_SET.equals(fi.getDocValuesType())
                fieldProducerMap.put(compositeField, new EmptyDocValuesProducer() {
        ) instanceof SortedSetOrdinalsIndexFieldData.Builder;
import java.util.Collections;
        // TODO : add integ test for this
    AtomicReference<MergeState> mergeState = new AtomicReference<>();
            segmentWriteState.segmentSuffix
    }
    private void mergeCompositeFields(MergeState mergeState) throws IOException {
                    if (compositeIndexValues instanceof StarTreeValues starTreeValues) {
        if (mergeState.get() == null && segmentHasCompositeFields) {
            }
        if (compositeField.equals(DocCountFieldMapper.NAME)) {
        mergeCompositeFields(mergeState);
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
    public void addNumericField(FieldInfo field, DocValuesProducer valuesProducer) throws IOException {
            if (compositeFieldSet.contains(field.name)) {
        // special case for doc count
    }
import java.io.IOException;
     * @param mergeState merge state
            segmentWriteState.segmentInfo.dir,
            }
    @Override
        delegate.addBinaryField(field, valuesProducer);
                    public SortedSetDocValues getSortedSet(FieldInfo field) {
public class Composite912DocValuesWriter extends DocValuesConsumer {
                    public SortedNumericDocValues getSortedNumeric(FieldInfo field) {
        segmentFieldSet.remove(field.name);
    @Override
                CodecUtil.writeFooter(dataOut); // write checksum
            if (mergeState.docValuesProducers[i] == null) {
import org.apache.lucene.index.EmptyDocValuesProducer;
 * this file be licensed under the Apache-2.0 license or a
 * based on the doc values structures of the original index
}
        }
 * SPDX-License-Identifier: Apache-2.0
                CodecUtil.writeFooter(metaOut); // write checksum
    public IndexOutput dataOut;
        }
            // Get consumer write state with DocIdSetIterator.NO_MORE_DOCS as segment doc count,
                    }
                this.state.segmentInfo.getId(),
                this.state.segmentSuffix
            compositeDocValuesConsumer = null;
    private final AtomicInteger fieldNumberAcrossCompositeFields;
            metaOut = dataOut = null;
import org.apache.lucene.search.DocIdSetIterator;
            CodecUtil.writeIndexHeader(
                this.state.segmentSuffix
            if (dataOut != null) {
    }
import java.util.HashSet;
            for (CompositeIndexFieldInfo fieldInfo : compositeFieldInfo) {
                reader = compositeReader;
            try (StarTreesBuilder starTreesBuilder = new StarTreesBuilder(state, mapperService, fieldNumberAcrossCompositeFields)) {
        // Perform this only during flush flow
        boolean success = false;
                Composite912DocValuesFormat.DATA_DOC_VALUES_EXTENSION,
        this.compositeMappedFieldTypes = mapperService.getCompositeFieldTypes();
        } finally {
        this.state = segmentWriteState;
import org.opensearch.index.codec.composite.LuceneDocValuesConsumerFactory;
            segmentWriteState.infoStream,
        Map<String, List<StarTreeValues>> starTreeSubsPerField = new HashMap<>();
        ) instanceof IndexNumericFieldData.Builder;
                addDocValuesForEmptyField(compositeField);
            if (success == false) {
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
                this.state.segmentSuffix,
                fieldProducerMap.put(compositeField, new EmptyDocValuesProducer() {
                IOUtils.closeWhileHandlingException(dataOut, metaOut, compositeDocValuesConsumer);
    private boolean isSortedSetField(String field) {
            compositeFieldSet.addAll(type.fields());
        try (StarTreesBuilder starTreesBuilder = new StarTreesBuilder(state, mapperService, fieldNumberAcrossCompositeFields)) {
            for (String compositeField : compositeFieldSetCopy) {
            segmentWriteState.segmentInfo.getCodec(),
                consumerWriteState,
            segmentWriteState.directory,
                        List<CompositeIndexFieldInfo> compositeFieldInfo = reader.getCompositeIndexFields();
            segmentWriteState.fieldInfos,
                public NumericDocValues getNumeric(FieldInfo field) {
            segmentWriteState.segmentInfo.getAttributes(),
                    if (docValuesProducer instanceof CompositeIndexReader compositeReader) {
        if (mergeState.get() == null && segmentHasCompositeFields) {
                });
            starTreesBuilder.buildDuringMerge(metaOut, dataOut, starTreeSubsPerField, compositeDocValuesConsumer);
                this.state.segmentInfo.name,
        }
import org.opensearch.index.compositeindex.datacube.startree.builder.StarTreesBuilder;
    @Override
                    return DocValues.emptyNumeric();
                this.state.segmentInfo.getId(),
     * @param mergeState merge state
        assert ft.isAggregatable();
        compositeFieldSet.remove(compositeField);
        MappedFieldType ft = mapperService.fieldType(field);
            segmentInfo,
            this.compositeDocValuesConsumer = LuceneDocValuesConsumerFactory.getDocValuesConsumerForCompositeCodec(
import org.apache.lucene.index.MergeState;
        segmentFieldSet = new HashSet<>();
