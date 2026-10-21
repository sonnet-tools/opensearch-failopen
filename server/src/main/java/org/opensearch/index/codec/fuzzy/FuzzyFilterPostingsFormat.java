            @Override
        FieldsConsumer fieldsConsumer = delegatePostingsFormat.fieldsConsumer(state);
    @Override
            public String toString() {
import java.util.Map;
        public FuzzyFilteredFieldsProducer(SegmentReadState state) throws IOException {
 * The class should be handled during lucene upgrades. There are bwc tests present to verify the format continues to work after upgrade.
        public FuzzyFilteredFieldsConsumer(FieldsConsumer fieldsConsumer, SegmentWriteState state) {
                return delegateTerms.hasFreqs();
            public ImpactsEnum impacts(int flags) throws IOException {
        private List<Closeable> closeables = new ArrayList<>();
            for (String field : fields) {
            public boolean hasOffsets() {
                    FieldInfo fieldInfo = entry.getKey();
                "Error - " + getClass().getName() + " has been constructed without a choice of PostingsFormat"
                Terms result = delegateFieldsProducer.terms(field);
        public Iterator<String> iterator() {
            public FilterAppliedTermsEnum(Terms delegateTerms, FuzzySet filter) throws IOException {
                // Load the delegate postings format
            public boolean hasPayloads() {
            this.delegateFieldsConsumer = fieldsConsumer;
            return delegateFieldsProducer.size();
                                return false;
                if (delegateTermsEnum == null) {
                    nonSaturatedSets.add(entry);
            public SeekStatus seekCeil(BytesRef text) throws IOException {
        static class FuzzyFilteredTerms extends Terms {
}
            @Override
 * Based on Lucene's BloomFilterPostingsFormat.
            }
                return delegateTermsEnum;
                closeables.add(filterIn);
                return delegateTerms.getDocCount();
                        do {
import org.apache.lucene.codecs.FieldsProducer;
            }
                closeables.add(fuzzySet);
            }
        return new FuzzyFilteredFieldsProducer(state);
    /** Extension of Fuzzy Filters file */
                fuzzySets.put(fieldInfo, fuzzySet);
        private boolean closed;
     * This name is stored in headers. If changing the implementation for the format, this name/version should be updated
    static class FuzzyFilteredFieldsProducer extends FieldsProducer {
                return new FilterAppliedTermsEnum(delegateTerms, filter);
        @Override
    /**
 */
            public void seekExact(long ord) throws IOException {
                            }
        public String toString() {
            if (closed) {
import org.apache.lucene.index.PostingsEnum;
                @Override
                if (!success) {
            }
        }
                return delegate().term();
            public long getSumDocFreq() throws IOException {
            }
        }
            // (e.g. Lucene41PostingsConsumer), and write() will
                // that may occasionally give a false positive but guaranteed no false
                CodecUtil.writeIndexHeader(
                return delegateTerms.hasOffsets();
                return delegate().postings(reuse, flags);
 * Based on code from the Apache Lucene project (https://github.com/apache/lucene) under the Apache License, version 2.0.
 * Copyright 2001-2022 The Apache Software Foundation
                }
            }
 * is captured here: https://github.com/apache/lucene/issues/12986
            public boolean seekExact(BytesRef text) throws IOException {
                    continue;
                return delegateTerms.hasPayloads();
            fuzzySets.clear();
    // Needed for SPI
        this.fuzzySetFactory = fuzzySetFactory;
public final class FuzzyFilterPostingsFormat extends PostingsFormat {
                            if (postingsEnum.nextDoc() != PostingsEnum.NO_MORE_DOCS) {
                return delegate().docFreq();
                    state.segmentSuffix
 * SPDX-License-Identifier: Apache-2.0
            public PostingsEnum postings(PostingsEnum reuse, int flags) throws IOException {
import java.util.HashMap;
                                return true;
        }
    }
            @Override
 *
                state.segmentInfo.name,
                if (result == null) {
import java.util.Iterator;
            public TermsEnum intersect(CompiledAutomaton compiled, final BytesRef startTerm) throws IOException {
 * The class deals with persisting the bloom filter through the postings format,
import org.apache.lucene.codecs.PostingsFormat;
            @Override
            IOUtils.closeWhileHandlingException(closeables);
            public long getSumTotalTermFreq() throws IOException {
            FuzzySet filter = fuzzySetsByFieldName.get(field);
    public static final String FUZZY_FILTER_CODEC_NAME = "FuzzyFilterCodec99";
    public FuzzyFilterPostingsFormat(PostingsFormat delegatePostingsFormat, FuzzySetFactory fuzzySetFactory) {
        static final class FilterAppliedTermsEnum extends BaseTermsEnum {
                return delegate().next();
            }
        }
            fuzzySet.writeTo(fileOutput);
                for (int i = 0; i < numFilters; i++) {
            @Override
import java.util.List;
            @Override
                }
                     * (clone IndexInput) */
    class FuzzyFilteredFieldsConsumer extends FieldsConsumer {
            try {
                // this code - save a disk seek if there is a match on an in-memory
                    FuzzySet fuzzySet = entry.getValue();
            }
            }
                if (filter.contains(text) == FuzzySet.Result.NO) {
import org.apache.lucene.index.Terms;
 * Modifications (C) OpenSearch Contributors. All Rights Reserved.
/*
                // Using IndexInput directly instead of ChecksumIndexInput since we want to support RandomAccessInput
            @Override
                }
            List<Map.Entry<FieldInfo, FuzzySet>> nonSaturatedSets = new ArrayList<>();
import org.apache.logging.log4j.LogManager;
            private final FuzzySet filter;
            };
                FUZZY_FILTER_FILE_EXTENSION
                    delegateTermsEnum = delegateTerms.iterator();
 * and reading the field via a bloom filter fronted terms enum (to reduce disk seeks in case of absence of requested values)
            );
                    IOUtils.closeWhileHandlingException(filterIn, delegateFieldsProducer);
        @Override
            }
            @Override
                    VERSION_CURRENT,
                if (!fuzzySet.isSaturated()) {
                    state.segmentSuffix
            closed = true;
            @Override
import org.apache.lucene.index.Fields;
                return delegate().totalTermFreq();
    }
                return delegateFieldsProducer.terms(field);
                        throw new IllegalStateException("Cannot read terms: " + termIterator.attributes());
                FieldInfo fieldInfo = state.fieldInfos.fieldInfo(field);
            private TermsEnum delegate() throws IOException {
 * The OpenSearch Contributors require contributions made to
                public boolean hasNext() {
        private Iterator<BytesRef> iterator(Terms terms) throws IOException {
import org.apache.lucene.index.IndexFileNames;
                CodecUtil.checkIndexHeader(
            private FuzzySet filter;
                if (terms == null) {
            }
import org.apache.lucene.index.SegmentWriteState;
            public boolean hasFreqs() {
 * Discussion with Lucene community based on which the decision to have this in OpenSearch code was taken
            // Now we are done accumulating values for these fields
                return;
        public void close() throws IOException {
                @Override
                    fuzzyFilterFileOutput,
            }
            @Override
            throw new UnsupportedOperationException(
                this.delegateFieldsProducer = delegatePostingsFormat.fieldsProducer(state);
                    closeables.add(set);
    @Override
 * compatible open source license.
                    VERSION_START,
                    state.segmentInfo.getId(),
                return delegateTerms.intersect(compiled, startTerm);
            }
            );
        private List<Closeable> closeables = new ArrayList<>();
                }
/*
                this.delegateTermsEnum = null;
import org.apache.lucene.index.TermsEnum;
            public BytesRef next() throws IOException {
            fileOutput.writeInt(fieldInfo.number);
                private BytesRef currentTerm;
            try (IndexOutput fuzzyFilterFileOutput = state.directory.createOutput(fuzzyFilterFileName, state.context)) {
            public long ord() throws IOException {
                success = true;
                this.filter = filter;
            public boolean hasPositions() {
                this.filter = filter;
                // structure
            @Override
import java.io.IOException;
        super(FUZZY_FILTER_CODEC_NAME);
            // on creating the class
                    state.segmentInfo.toString()
            @Override
import org.apache.lucene.index.FieldInfo;
            // afterwards:
                    return currentTerm;
                logger.trace(
            return delegateFieldsProducer.iterator();
                return delegateTerms.getSumDocFreq();
                PostingsFormat delegatePostingsFormat = PostingsFormat.forName(filterIn.readString());
            // We are done with large bitsets so no need to keep them hanging around
                assert fuzzySets.containsKey(fieldInfo) == false;
                );
                this.delegateTerms = delegateTerms;
            public int docFreq() throws IOException {
            @Override
                fuzzyFilterFileOutput.writeInt(nonSaturatedSets.size());
                     * delegate postings format and the underlying directory
        }
                            }
            void reset(Terms delegateTerms) throws IOException {
                        } while (true);
            public FuzzyFilteredTerms(Terms terms, FuzzySet filter) {
            @Override
    private static final Logger logger = LogManager.getLogger(FuzzyFilterPostingsFormat.class);
                );
            public TermsEnum iterator() throws IOException {
                    FUZZY_FILTER_CODEC_NAME,
import org.apache.lucene.index.SegmentReadState;
    }
    }
                return delegateTerms.getMax();
        }
            boolean success = false;
            public long totalTermFreq() throws IOException {
                    /* pull the iterator only if we really need it -
            // Delegate must write first: it may have opened files
import org.apache.logging.log4j.Logger;
    public String toString() {
            delegateFieldsConsumer.write(fields, norms);
        @Override
import org.apache.lucene.store.IndexInput;
            public BytesRef term() throws IOException {
                    int fieldNum = filterIn.readInt();
                    return false;
 *
        }
                public BytesRef next() {
            delegateFieldsConsumer.close();
            }
            public BytesRef getMin() throws IOException {
        public Terms terms(String field) throws IOException {
                    FuzzySet set = FuzzySetFactory.deserializeFuzzySet(filterIn);
    private final PostingsFormat delegatePostingsFormat;
                }
            IndexInput filterIn = null;
 */
        }
            }
import org.apache.lucene.codecs.CodecUtil;
                    FieldInfo fieldInfo = state.fieldInfos.fieldInfo(fieldNum);
            public long size() throws IOException {
        public void write(Fields fields, NormsProducer norms) throws IOException {
        this(null, null);
            }
                }
                if (fuzzySet == null) {
        private FieldsConsumer delegateFieldsConsumer;
            }
        }
                    try {
                FuzzySet fuzzySet = entry.getValue();
import org.apache.lucene.index.ImpactsEnum;
                }
            private Terms delegateTerms;
            }
                delegate().seekExact(ord);
            }
                return delegateTerms.getMin();
        @Override
            return getClass().getSimpleName() + "(fields=" + fuzzySetsByFieldName.size() + ",delegate=" + delegateFieldsProducer + ")";
                            if (currentTerm == null) {
import java.io.Closeable;
            fileOutput.writeString(fuzzySet.setType().getSetName());
            String fuzzyFilterFileName = IndexFileNames.segmentFileName(
            }
                return delegateTerms.getSumTotalTermFreq();
        @Override
            }
import org.opensearch.common.util.io.IOUtils;
        private SegmentWriteState state;
import org.apache.lucene.util.automaton.CompiledAutomaton;
        return new FuzzyFilteredFieldsConsumer(fieldsConsumer, state);
            } else {
                this.delegateTerms = terms;
            @Override
    }
                return delegate().seekExact(text);
            @Override
/**
                }
                return delegate().seekCeil(text);
            // Why closing here?
                    }
                Terms terms = fields.terms(field);
                CodecUtil.checksumEntireFile(filterIn);
                            postingsEnum = termIterator.postings(postingsEnum, 0);
                return delegate().impacts(flags);
                );
            }
                            currentTerm = termIterator.next();
            for (Map.Entry<FieldInfo, FuzzySet> entry : fuzzySets.entrySet()) {
            }
                CodecUtil.writeFooter(fuzzyFilterFileOutput);
import org.apache.lucene.index.BaseTermsEnum;
    private final FuzzySetFactory fuzzySetFactory;
                    VERSION_CURRENT,
            }
import org.apache.lucene.util.BytesRef;
        public void close() throws IOException {
        this.delegatePostingsFormat = delegatePostingsFormat;
        private Map<FieldInfo, FuzzySet> fuzzySets = new HashMap<>();
        if (delegatePostingsFormat == null) {
                this.delegateTerms = delegateTerms;
        }
                // First field in the output file is the number of fields+sets saved
                }
                FuzzySet fuzzySet = fuzzySetFactory.createFuzzySet(state.segmentInfo.maxDoc(), fieldInfo.name, () -> iterator(terms));
        }
                return getClass().getSimpleName() + "(filter=" + filter.toString() + ")";
        private void saveAppropriatelySizedFuzzySet(IndexOutput fileOutput, FuzzySet fuzzySet, FieldInfo fieldInfo) throws IOException {
            }
import org.apache.lucene.codecs.FieldsConsumer;
     * so that reads can work as expected.
            @Override
            String fuzzyFilterFileName = IndexFileNames.segmentFileName(
                // remember the name of the postings format we will delegate to
        @Override
                return delegateTerms.size();
            IOUtils.closeWhileHandlingException(closeables);
            }
                    FUZZY_FILTER_CODEC_NAME,
            }
            }
            delegateFieldsProducer.close();
        @Override
                state.segmentInfo.name,
import org.apache.lucene.store.IndexOutput;
                // Can we disable it if we foresee performance issues?
    public static final int VERSION_CURRENT = VERSION_START;
            return new Iterator<>() {
package org.opensearch.index.codec.fuzzy;
                state.segmentSuffix,
                filterIn = state.directory.openInput(fuzzyFilterFileName, state.context);
            @Override
                    saveAppropriatelySizedFuzzySet(fuzzyFilterFileOutput, fuzzySet, fieldInfo);
        }
        }
                state.segmentSuffix,
                CodecUtil.retrieveChecksum(filterIn);
            private TermsEnum delegateTermsEnum;
                // negatives
            // close them; alternatively, if we delayed pulling
                // The magical fail-fast speed up that is the entire point of all of
        @Override
    }
        }
            // the fields consumer until here, we could do it
            }
            @Override
            this.state = state;
                }
 */
    public FieldsProducer fieldsProducer(SegmentReadState state) throws IOException {
            delegateFieldsProducer.checkIntegrity();
            public BytesRef getMax() throws IOException {
    public FuzzyFilterPostingsFormat() {
            @Override
 * this file be licensed under the Apache-2.0 license or a
                return new FuzzyFilteredTerms(result, filter);
                    state.segmentInfo.getId(),
            public int getDocCount() throws IOException {
            @Override
            }
        HashMap<String, FuzzySet> fuzzySetsByFieldName = new HashMap<>();
            if (filter == null) {
                int numFilters = filterIn.readInt();
                    return null;
                }
    public static final String FUZZY_FILTER_FILE_EXTENSION = "fzd";
                for (Map.Entry<FieldInfo, FuzzySet> entry : nonSaturatedSets) {
     */
            private Terms delegateTerms;
                return delegate().ord();
    @Override
                return delegateTerms.hasPositions();
                    fuzzySetsByFieldName.put(fieldInfo.name, set);
            );
                    break;
            @Override
        public void checkIntegrity() throws IOException {
                    filterIn,
import java.util.ArrayList;
        public int size() {
import org.apache.lucene.codecs.NormsProducer;
            }
        }
                    } catch (IOException ex) {
            } finally {
            }
            }
    }
                    "Writing fuzzy filter postings with version: {} for segment: {}",
            @Override
    public FieldsConsumer fieldsConsumer(SegmentWriteState state) throws IOException {
        return "FuzzyFilterPostingsFormat(" + delegatePostingsFormat + ")";
                    VERSION_CURRENT,
                FUZZY_FILTER_FILE_EXTENSION
                private PostingsEnum postingsEnum;
                fuzzyFilterFileOutput.writeString(delegatePostingsFormat.getName());
        private FieldsProducer delegateFieldsProducer;
    public static final int VERSION_START = 0;
            TermsEnum termIterator = terms.iterator();
                     * this can be a relativly heavy operation depending on the
