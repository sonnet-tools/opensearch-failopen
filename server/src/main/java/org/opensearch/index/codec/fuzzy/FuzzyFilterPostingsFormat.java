import java.io.Closeable;  
                            currentTerm = termIterator.next();
            }  
 */
            fileOutput.writeInt(fieldInfo.number);
        if (delegatePostingsFormat == null) {
            private Terms delegateTerms;
                // structure
import org.apache.logging.log4j.LogManager;
                return new FuzzyFilteredTerms(result, filter);  
import org.apache.lucene.index.Fields;
                return delegateTerms.getSumDocFreq();
            }
    @Override
        return new FuzzyFilteredFieldsProducer(state);
        private FieldsProducer delegateFieldsProducer;
            @Override
                if (!success) {
            if (closed) {  
                return delegateTerms.getMax();  
            delegateFieldsProducer.close();
                // that may occasionally give a false positive but guaranteed no false
            public long getSumDocFreq() throws IOException {  
                }
                            if (currentTerm == null) {  
                    state.segmentSuffix
        this.delegatePostingsFormat = delegatePostingsFormat;  
    public FuzzyFilterPostingsFormat(PostingsFormat delegatePostingsFormat, FuzzySetFactory fuzzySetFactory) {
                return delegate().term();
                    FUZZY_FILTER_CODEC_NAME,
            }
    // Needed for SPI
                    int fieldNum = filterIn.readInt();
            IOUtils.closeWhileHandlingException(closeables);
                    fuzzySetsByFieldName.put(fieldInfo.name, set);
                CodecUtil.checksumEntireFile(filterIn);
        }
            closed = true;  
                    return null;
            public int getDocCount() throws IOException {
                CodecUtil.writeFooter(fuzzyFilterFileOutput);
import org.apache.lucene.index.BaseTermsEnum;
import org.apache.lucene.util.BytesRef;
            @Override
import org.apache.lucene.index.TermsEnum;
    public static final int VERSION_CURRENT = VERSION_START;
import java.util.HashMap;  
     * so that reads can work as expected.  
                fuzzySets.put(fieldInfo, fuzzySet);
    public static final int VERSION_START = 0;
                    VERSION_CURRENT,
                return delegate().seekExact(text);
            public boolean hasPayloads() {
                    } catch (IOException ex) {
                FUZZY_FILTER_FILE_EXTENSION  
                return delegateFieldsProducer.terms(field);  
            public BytesRef getMax() throws IOException {
/*
                    VERSION_CURRENT,
                return getClass().getSimpleName() + "(filter=" + filter.toString() + ")";
    /** Extension of Fuzzy Filters file */
            }
            }
            public BytesRef term() throws IOException {  
                    }
            return getClass().getSimpleName() + "(fields=" + fuzzySetsByFieldName.size() + ",delegate=" + delegateFieldsProducer + ")";  
                closeables.add(filterIn);  
            } finally {
            }
                // The magical fail-fast speed up that is the entire point of all of
                    FuzzySet fuzzySet = entry.getValue();
            public boolean hasFreqs() {
                        } while (true);
    }
                            postingsEnum = termIterator.postings(postingsEnum, 0);  
        HashMap<String, FuzzySet> fuzzySetsByFieldName = new HashMap<>();  
 * The OpenSearch Contributors require contributions made to  
                    continue;
import org.apache.lucene.index.FieldInfo;  
        public Iterator<String> iterator() {  
            delegateFieldsProducer.checkIntegrity();
                FieldInfo fieldInfo = state.fieldInfos.fieldInfo(field);
            private TermsEnum delegate() throws IOException {
            public boolean seekExact(BytesRef text) throws IOException {
                return delegateTerms.hasPositions();  
                    state.segmentInfo.toString()  
                if (delegateTermsEnum == null) {  
            public boolean hasPositions() {
            fuzzySets.clear();
                return;
     * This name is stored in headers. If changing the implementation for the format, this name/version should be updated
                    state.segmentInfo.getId(),  
                }
package org.opensearch.index.codec.fuzzy;
                return delegate().totalTermFreq();
                this.delegateFieldsProducer = delegatePostingsFormat.fieldsProducer(state);
                fuzzyFilterFileOutput.writeInt(nonSaturatedSets.size());
                state.segmentSuffix,
            @Override
import org.apache.lucene.codecs.CodecUtil;  
            @Override
                // First field in the output file is the number of fields+sets saved
                @Override
                }
            if (filter == null) {
import org.apache.lucene.store.IndexOutput;
    /**
                private PostingsEnum postingsEnum;
            private TermsEnum delegateTermsEnum;
        public int size() {
import org.apache.lucene.codecs.PostingsFormat;
                    closeables.add(set);  
                if (fuzzySet == null) {  
        public void checkIntegrity() throws IOException {  
            TermsEnum termIterator = terms.iterator();
                CodecUtil.retrieveChecksum(filterIn);
                    FUZZY_FILTER_CODEC_NAME,
                    return false;
                return delegateTerms.getDocCount();  
        private FieldsConsumer delegateFieldsConsumer;
        public void close() throws IOException {
                     * (clone IndexInput) */
    public FieldsConsumer fieldsConsumer(SegmentWriteState state) throws IOException {
            @Override  
            @Override  
            public long totalTermFreq() throws IOException {  
            }
            };
        }
            @Override  
                    filterIn,
        }  
                this.delegateTerms = delegateTerms;
import java.io.IOException;
            @Override
import org.apache.lucene.codecs.FieldsConsumer;
                state.segmentInfo.name,
 * SPDX-License-Identifier: Apache-2.0
            this.state = state;  
                    FuzzySet set = FuzzySetFactory.deserializeFuzzySet(filterIn);
            }
        static class FuzzyFilteredTerms extends Terms {  
                return delegateTerms.getMin();
                for (Map.Entry<FieldInfo, FuzzySet> entry : nonSaturatedSets) {  
            @Override  
            }
                delegate().seekExact(ord);
        public String toString() {
            // Why closing here?  
            );
    public FieldsProducer fieldsProducer(SegmentReadState state) throws IOException {  
            }  
                    state.segmentInfo.getId(),
                this.delegateTerms = terms;
            }  
                filterIn = state.directory.openInput(fuzzyFilterFileName, state.context);
            }  
            // close them; alternatively, if we delayed pulling  
import org.apache.lucene.index.PostingsEnum;
                private BytesRef currentTerm;
            }
        private Iterator<BytesRef> iterator(Terms terms) throws IOException {  
            public long ord() throws IOException {
    private static final Logger logger = LogManager.getLogger(FuzzyFilterPostingsFormat.class);
                        do {
        return "FuzzyFilterPostingsFormat(" + delegatePostingsFormat + ")";  
                    VERSION_START,  
                FuzzySet fuzzySet = entry.getValue();
            IndexInput filterIn = null;  
                }  
    }
import java.util.Iterator;
            }
            }  
            }
                    FieldInfo fieldInfo = state.fieldInfos.fieldInfo(fieldNum);
    }
import org.apache.lucene.index.SegmentReadState;
                for (int i = 0; i < numFilters; i++) {  
public final class FuzzyFilterPostingsFormat extends PostingsFormat {  
                        throw new IllegalStateException("Cannot read terms: " + termIterator.attributes());  
            // Delegate must write first: it may have opened files  
                );
            }
                }
            public long size() throws IOException {
            // (e.g. Lucene41PostingsConsumer), and write() will
    }
                    delegateTermsEnum = delegateTerms.iterator();
                return delegateTerms.hasOffsets();
                return delegate().seekCeil(text);  
 * Based on Lucene's BloomFilterPostingsFormat.  
            private FuzzySet filter;
 * and reading the field via a bloom filter fronted terms enum (to reduce disk seeks in case of absence of requested values)
                this.delegateTerms = delegateTerms;
            }
                            }
        super(FUZZY_FILTER_CODEC_NAME);
                return delegate().impacts(flags);
            return new Iterator<>() {
                     * delegate postings format and the underlying directory  
                if (result == null) {  
import org.apache.logging.log4j.Logger;
        @Override
        public FuzzyFilteredFieldsProducer(SegmentReadState state) throws IOException {  
                // remember the name of the postings format we will delegate to
                    FieldInfo fieldInfo = entry.getKey();
            }
            }  
 * is captured here: https://github.com/apache/lucene/issues/12986
import org.opensearch.common.util.io.IOUtils;
            FuzzySet filter = fuzzySetsByFieldName.get(field);
                            }  
 * compatible open source license.
            String fuzzyFilterFileName = IndexFileNames.segmentFileName(  
import org.apache.lucene.index.Terms;
            public BytesRef getMin() throws IOException {  
                this.filter = filter;  
import org.apache.lucene.index.ImpactsEnum;
        }  
                    state.segmentSuffix  
                }
            for (Map.Entry<FieldInfo, FuzzySet> entry : fuzzySets.entrySet()) {  
        }
                if (filter.contains(text) == FuzzySet.Result.NO) {
        @Override
                @Override
    @Override
                return new FilterAppliedTermsEnum(delegateTerms, filter);
            @Override
                return delegateTerms.hasPayloads();
        public void close() throws IOException {
            }
            @Override
            throw new UnsupportedOperationException(  
        }  
            public TermsEnum iterator() throws IOException {  
                }
            try {
            // the fields consumer until here, we could do it
            // on creating the class
            public void seekExact(long ord) throws IOException {
        }
                // Can we disable it if we foresee performance issues?  
                return delegate().ord();  
            @Override
        @Override  
                public boolean hasNext() {
            }  
import java.util.Map;  
                PostingsFormat delegatePostingsFormat = PostingsFormat.forName(filterIn.readString());  
        private List<Closeable> closeables = new ArrayList<>();
            }  
/*  
 *  
 */  
 * Modifications (C) OpenSearch Contributors. All Rights Reserved.
            public SeekStatus seekCeil(BytesRef text) throws IOException {
                return delegateTermsEnum;
                this.filter = filter;  
            }
                    VERSION_CURRENT,
            public FuzzyFilteredTerms(Terms terms, FuzzySet filter) {
                logger.trace(  
                return delegate().docFreq();
import org.apache.lucene.index.IndexFileNames;  
        }
        @Override
        public FuzzyFilteredFieldsConsumer(FieldsConsumer fieldsConsumer, SegmentWriteState state) {
            );
                CodecUtil.checkIndexHeader(  
                // this code - save a disk seek if there is a match on an in-memory  
                FUZZY_FILTER_FILE_EXTENSION
        }
        private Map<FieldInfo, FuzzySet> fuzzySets = new HashMap<>();  
            }
                    IOUtils.closeWhileHandlingException(filterIn, delegateFieldsProducer);  
                success = true;
    }
 * Copyright 2001-2022 The Apache Software Foundation
 *
    }
import org.apache.lucene.codecs.NormsProducer;  
        private void saveAppropriatelySizedFuzzySet(IndexOutput fileOutput, FuzzySet fuzzySet, FieldInfo fieldInfo) throws IOException {  
                    try {  
    static class FuzzyFilteredFieldsProducer extends FieldsProducer {
            }  
        @Override
                );
            try (IndexOutput fuzzyFilterFileOutput = state.directory.createOutput(fuzzyFilterFileName, state.context)) {
                }
        public void write(Fields fields, NormsProducer norms) throws IOException {
import org.apache.lucene.codecs.FieldsProducer;
import java.util.List;
            delegateFieldsConsumer.close();
            return delegateFieldsProducer.size();  
        private boolean closed;
    private final PostingsFormat delegatePostingsFormat;
            delegateFieldsConsumer.write(fields, norms);  
        }
            }
                return delegateTerms.getSumTotalTermFreq();
            return delegateFieldsProducer.iterator();
                }  
                    break;
                FuzzySet fuzzySet = fuzzySetFactory.createFuzzySet(state.segmentInfo.maxDoc(), fieldInfo.name, () -> iterator(terms));
                Terms result = delegateFieldsProducer.terms(field);
        this(null, null);  
            }
            }  
    public FuzzyFilterPostingsFormat() {
            public ImpactsEnum impacts(int flags) throws IOException {
            @Override
                }  
                    return currentTerm;  
                CodecUtil.writeIndexHeader(
 * Based on code from the Apache Lucene project (https://github.com/apache/lucene) under the Apache License, version 2.0.  
    private final FuzzySetFactory fuzzySetFactory;
                                return true;
            private final FuzzySet filter;
        }  
            private Terms delegateTerms;  
        }
            void reset(Terms delegateTerms) throws IOException {  
                return delegateTerms.size();  
            public TermsEnum intersect(CompiledAutomaton compiled, final BytesRef startTerm) throws IOException {
    public static final String FUZZY_FILTER_CODEC_NAME = "FuzzyFilterCodec99";
            @Override
}
                public BytesRef next() {
            // We are done with large bitsets so no need to keep them hanging around
                    "Writing fuzzy filter postings with version: {} for segment: {}",
                this.delegateTermsEnum = null;
            public boolean hasOffsets() {  
 * The class should be handled during lucene upgrades. There are bwc tests present to verify the format continues to work after upgrade.  
                );
            this.delegateFieldsConsumer = fieldsConsumer;
        @Override
            // afterwards:
                if (terms == null) {
            // Now we are done accumulating values for these fields  
            @Override
            @Override
                     * this can be a relativly heavy operation depending on the
/**
        public Terms terms(String field) throws IOException {  
            }
                // Load the delegate postings format
            String fuzzyFilterFileName = IndexFileNames.segmentFileName(
 * The class deals with persisting the bloom filter through the postings format,
import java.util.ArrayList;
        }
import org.apache.lucene.util.automaton.CompiledAutomaton;  
    @Override  
    }  
    public String toString() {
                "Error - " + getClass().getName() + " has been constructed without a choice of PostingsFormat"
                // negatives  
            fuzzySet.writeTo(fileOutput);  
import org.apache.lucene.index.SegmentWriteState;  
        FieldsConsumer fieldsConsumer = delegatePostingsFormat.fieldsConsumer(state);
                // Using IndexInput directly instead of ChecksumIndexInput since we want to support RandomAccessInput  
                state.segmentInfo.name,
            IOUtils.closeWhileHandlingException(closeables);  
 */  
                state.segmentSuffix,  
                    /* pull the iterator only if we really need it -
            }
                closeables.add(fuzzySet);
        @Override
 * Discussion with Lucene community based on which the decision to have this in OpenSearch code was taken
            boolean success = false;
                return delegateTerms.hasFreqs();
            );
            List<Map.Entry<FieldInfo, FuzzySet>> nonSaturatedSets = new ArrayList<>();
                            if (postingsEnum.nextDoc() != PostingsEnum.NO_MORE_DOCS) {
                fuzzyFilterFileOutput.writeString(delegatePostingsFormat.getName());
            @Override
            public BytesRef next() throws IOException {
            public PostingsEnum postings(PostingsEnum reuse, int flags) throws IOException {
            } else {
        private SegmentWriteState state;
        }  
        static final class FilterAppliedTermsEnum extends BaseTermsEnum {
    class FuzzyFilteredFieldsConsumer extends FieldsConsumer {
                return delegate().postings(reuse, flags);  
                assert fuzzySets.containsKey(fieldInfo) == false;  
            @Override
            @Override
        }
            }
        return new FuzzyFilteredFieldsConsumer(fieldsConsumer, state);
            @Override  
                int numFilters = filterIn.readInt();
            fileOutput.writeString(fuzzySet.setType().getSetName());
            }
        private List<Closeable> closeables = new ArrayList<>();
                }  
                return delegate().next();  
            public String toString() {  
                if (!fuzzySet.isSaturated()) {
            @Override  
                return delegateTerms.intersect(compiled, startTerm);
                    saveAppropriatelySizedFuzzySet(fuzzyFilterFileOutput, fuzzySet, fieldInfo);  
            public long getSumTotalTermFreq() throws IOException {
                Terms terms = fields.terms(field);  
        this.fuzzySetFactory = fuzzySetFactory;
                    fuzzyFilterFileOutput,  
            @Override  
                                return false;
 * this file be licensed under the Apache-2.0 license or a
            public FilterAppliedTermsEnum(Terms delegateTerms, FuzzySet filter) throws IOException {
            @Override  
     */
import org.apache.lucene.store.IndexInput;  
        @Override
                    nonSaturatedSets.add(entry);  
    public static final String FUZZY_FILTER_FILE_EXTENSION = "fzd";
            public int docFreq() throws IOException {
            for (String field : fields) {
