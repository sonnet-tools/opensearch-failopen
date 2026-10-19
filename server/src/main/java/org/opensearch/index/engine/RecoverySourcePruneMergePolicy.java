         * A reader of pruned stored fields
import org.apache.lucene.index.FilterNumericDocValues;
                return in.getSkipper(field);
            @Override  
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
                        @Override
            @Override
     * A codec reader that prunes the source using a filter
        private static class FilterStoredFieldVisitor extends StoredFieldVisitor {
    }
        }
    private static CodecReader wrapReader(String recoverySourceField, CodecReader reader, Supplier<Query> retainSourceQuerySupplier)
                            intersection = DocIdSetIterator.empty();
            public void stringField(FieldInfo fieldInfo, String value) throws IOException {  
                        if (recoverySourceToKeep == null) {
         * A fields reader that provides a filtered stored field  
 */  
 * this work for additional information regarding copyright
                    super.document(docID, visitor);
                            }  
            @Override
import java.io.IOException;
 */
            }  
        private final String recoverySourceField;
            public void longField(FieldInfo fieldInfo, long value) throws IOException {
            this.recoverySourceToKeep = recoverySourceToKeep;
            // if retentions are high we keep most of it  
        public StoredFieldsReader getFieldsReader() {
                    });  
                this.in = fieldsReader;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
         */
import org.apache.lucene.codecs.StoredFieldsReader;
         *
            return null;
 * The OpenSearch Contributors require contributions made to  
                return visitor.needsField(fieldInfo);
                super(in);  
                this.recoverySourceField = Objects.requireNonNull(recoverySourceField);
                    }  
            @Override
import org.apache.lucene.index.FieldInfo;  
                visitor.doubleField(fieldInfo, value);  
                            // we can't return null here lucenes DocIdMerger expects an instance  
            public void floatField(FieldInfo fieldInfo, float value) throws IOException {  
import org.apache.lucene.util.BitSet;
         * A producer of filtered doc vlaues
        private static class RecoverySourcePruningStoredFieldsReader extends FilterStoredFieldsReader {  
            }
 *  
                visitor.binaryField(fieldInfo, value);
                            @Override
                in.checkIntegrity();  
 * Merge Policy that prunes the recovery source
        throws IOException {  
         *
                return new RecoverySourcePruningStoredFieldsReader(in.getMergeInstance(), recoverySourceToKeep, recoverySourceField);  
            public void checkIntegrity() throws IOException {
            public BinaryDocValues getBinary(FieldInfo field) throws IOException {  
                    super.document(docID, new FilterStoredFieldVisitor(visitor) {
        });
         *  
            DocValuesProducer docValuesReader = super.getDocValuesReader();  
        public CacheHelper getReaderCacheHelper() {
        /**
}  
            private final String recoverySourceField;  
                        return new FilterNumericDocValues(numeric) {
         */
import java.util.Objects;
            }
            public void binaryField(FieldInfo fieldInfo, byte[] value) throws IOException {
            @Override  
            }
            }  
                        }  
            super(reader);
                visitor.floatField(fieldInfo, value);
import org.apache.lucene.index.SortedSetDocValues;
import org.apache.lucene.search.ScoreMode;
        }
            @Override  
            }
            public void intField(FieldInfo fieldInfo, int value) throws IOException {
            @Override  
                in.document(docID, visitor);
 */
        } else {
            }
            }
                return in.getSortedNumeric(field);
                return in.getSorted(field);  
            @Override  
                    if (recoverySourceField.equals(field.name)) {
import org.apache.lucene.index.NumericDocValues;
            private final StoredFieldVisitor visitor;  
            return reader; // early terminate - nothing to do here since non of the docs has a recovery source anymore.  
 * the Apache License, Version 2.0 (the "License"); you may
        public CacheHelper getCoreCacheHelper() {  
        SourcePruningFilterCodecReader(String recoverySourceField, CodecReader reader, BitSet recoverySourceToKeep) {
            public void close() throws IOException {
                        assert numeric != null : recoverySourceField + " must have numeric DV but was null";  
            }
        public DocValuesProducer getDocValuesReader() {
            @Override
            @Override
            @Override  
                this.visitor = visitor;  
                            public int advance(int target) {
                return wrapReader(recoverySourceField, wrapped, retainSourceQuerySupplier);  
                        } else {
        @Override
 * You may obtain a copy of the License at  
/*  
            }  
            public void close() throws IOException {
            public SortedSetDocValues getSortedSet(FieldInfo field) throws IOException {  
        private abstract static class FilterStoredFieldsReader extends StoredFieldsReader {
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
                return new RecoverySourcePruningStoredFieldsReader(in.clone(), recoverySourceToKeep, recoverySourceField);
            @Override
import org.apache.lucene.search.Scorer;  
import org.apache.lucene.index.BinaryDocValues;  
            return new SourcePruningFilterCodecReader(recoverySourceField, reader, null);  
import java.util.Arrays;  
 *  
     * @opensearch.internal
            }  
        /**  
                            @Override
            }
                            );
                        };
                            public int nextDoc() throws IOException {  
            @Override
        }
            return null;  
 * under the License.  
            public void doubleField(FieldInfo fieldInfo, double value) throws IOException {
 * license agreements. See the NOTICE file distributed with
                            }
    private static class SourcePruningFilterCodecReader extends FilterCodecReader {  
 *
                        }
                return in.getNumeric(field);
 * @opensearch.internal
            }  
        private final BitSet recoverySourceToKeep;
final class RecoverySourcePruneMergePolicy extends OneMergeWrappingMergePolicy {  
        }  
import org.apache.lucene.search.Query;
                this.recoverySourceToKeep = recoverySourceToKeep;
            };  
        NumericDocValues recoverySource = reader.getNumericDocValues(recoverySourceField);
            public void document(int docID, StoredFieldVisitor visitor) throws IOException {  
        super(in, toWrap -> new OneMerge(toWrap.segments) {
            public abstract StoredFieldsReader clone();
import org.apache.lucene.util.BitSetIterator;  
                in.close();
                CodecReader wrapped = toWrap.wrapForMerge(reader);
        }
        @Override  
        @Override
            }
         */
 * GitHub history for details.
            }
                            return super.needsField(fieldInfo);
            FilterDocValuesProducer(DocValuesProducer in) {
                                throw new UnsupportedOperationException();
            // calculating the cardinality is significantly cheaper than skipping all bulk-merging we might do
/**
                            @Override  
            public NumericDocValues getNumeric(FieldInfo field) throws IOException {
        }  
            public CodecReader wrapForMerge(CodecReader reader) throws IOException {
            BitSet recoverySourceToKeep = BitSet.of(scorer.iterator(), reader.maxDoc());
            @Override
         * @opensearch.internal  
                this.in = in;  
        @Override
import java.util.function.Supplier;
        }
import org.apache.lucene.index.OneMergeWrappingMergePolicy;
                            }
                @Override
         * @opensearch.internal  
    }  
         *
            }  
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.index.MergePolicy;  
            private final DocValuesProducer in;  
import org.apache.lucene.index.SortedDocValues;  
                            public boolean advanceExact(int target) {
                return in.getBinary(field);
 * Modifications Copyright OpenSearch Contributors. See
            return new RecoverySourcePruningStoredFieldsReader(super.getFieldsReader(), recoverySourceToKeep, recoverySourceField);
            FilterStoredFieldVisitor(StoredFieldVisitor visitor) {
        }
         * @opensearch.internal
import org.apache.lucene.index.CodecReader;
                        final DocIdSetIterator intersection;
                                return intersection.nextDoc();
        private static class FilterDocValuesProducer extends DocValuesProducer {
                } else {  
            }  
            public void document(int docID, StoredFieldVisitor visitor) throws IOException {  
            }  
        Weight weight = s.createWeight(s.rewrite(retainSourceQuerySupplier.get()), ScoreMode.COMPLETE_NO_SCORES, 1.0f);
        IndexSearcher s = new IndexSearcher(reader);
            public StoredFieldsReader getMergeInstance() {
import org.apache.lucene.index.StoredFieldVisitor;  
            @Override
            return new SourcePruningFilterCodecReader(recoverySourceField, reader, recoverySourceToKeep);
    }
import org.apache.lucene.index.FilterCodecReader;
            }
                public NumericDocValues getNumeric(FieldInfo field) throws IOException {  
                }
            if (recoverySourceToKeep.cardinality() == reader.maxDoc()) {
 *
                                Arrays.asList(numeric, new BitSetIterator(recoverySourceToKeep, recoverySourceToKeep.length()))
import org.apache.lucene.search.Weight;
 * Unless required by applicable law or agreed to in writing,
            @Override  
        }
            RecoverySourcePruningStoredFieldsReader(StoredFieldsReader in, BitSet recoverySourceToKeep, String recoverySourceField) {
     */
        /**
                in.checkIntegrity();  
                    NumericDocValues numeric = super.getNumeric(field);
/*  
            }  
            }
         * A visitor pattern for filtered stored fields
        if (scorer != null) {  
package org.opensearch.index.engine;
            FilterStoredFieldsReader(StoredFieldsReader fieldsReader) {
        if (recoverySource == null || recoverySource.nextDoc() == DocIdSetIterator.NO_MORE_DOCS) {
            @Override
 * Licensed to Elasticsearch under one or more contributor  
            @Override
 */  
                return reader; // keep all source
                            if (recoverySourceField.equals(fieldInfo.name)) {
            public Status needsField(FieldInfo fieldInfo) throws IOException {
                if (recoverySourceToKeep != null && recoverySourceToKeep.get(docID)) {
                                throw new UnsupportedOperationException();  
                visitor.intField(fieldInfo, value);  
                visitor.stringField(fieldInfo, value);
 * compatible open source license.
import org.apache.lucene.index.DocValuesSkipper;
                                return Status.NO;
                in.close();
            protected final StoredFieldsReader in;  
import org.apache.lucene.search.ConjunctionUtils;
        Scorer scorer = weight.scorer(reader.getContext());
         */  
                }
            }
            }
            public SortedDocValues getSorted(FieldInfo field) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
    RecoverySourcePruneMergePolicy(String recoverySourceField, Supplier<Query> retainSourceQuerySupplier, MergePolicy in) {
        s.setQueryCache(null);  
 * SPDX-License-Identifier: Apache-2.0
            }
            public StoredFieldsReader clone() {
        }
            }
            @Override  
                visitor.longField(fieldInfo, value);
            @Override
import org.apache.lucene.search.DocIdSetIterator;
            @Override
                            }  
     *  
    /**
        /**  
            }  
import org.apache.lucene.index.SortedNumericDocValues;
import org.apache.lucene.codecs.DocValuesProducer;
 * software distributed under the License is distributed on an
            return new FilterDocValuesProducer(docValuesReader) {
/*
            public DocValuesSkipper getSkipper(FieldInfo field) throws IOException {  
         * @opensearch.internal
            private final BitSet recoverySourceToKeep;
            @Override
import org.apache.lucene.search.IndexSearcher;  
            this.recoverySourceField = recoverySourceField;  
                    return numeric;
                        public Status needsField(FieldInfo fieldInfo) throws IOException {  
            public void checkIntegrity() throws IOException {
            @Override  
                return in.getSortedSet(field);
 * specific language governing permissions and limitations
            }
            public SortedNumericDocValues getSortedNumeric(FieldInfo field) throws IOException {
                            intersection = ConjunctionUtils.intersectIterators(  
