        public StoredFieldsReader getFieldsReader() {
        /**
        private final String recoverySourceField;
                                return intersection.nextDoc();
import org.apache.lucene.index.MergePolicy;
 * Licensed to Elasticsearch under one or more contributor
import org.apache.lucene.index.SortedSetDocValues;
                in.checkIntegrity();
            return new RecoverySourcePruningStoredFieldsReader(super.getFieldsReader(), recoverySourceToKeep, recoverySourceField);
                            @Override
            @Override
        });
 * You may obtain a copy of the License at
            @Override
            private final BitSet recoverySourceToKeep;
 * this file be licensed under the Apache-2.0 license or a
            private final StoredFieldVisitor visitor;
                            );
            FilterDocValuesProducer(DocValuesProducer in) {
            public void intField(FieldInfo fieldInfo, int value) throws IOException {
         */
            return new FilterDocValuesProducer(docValuesReader) {
         * A reader of pruned stored fields
            return new SourcePruningFilterCodecReader(recoverySourceField, reader, recoverySourceToKeep);
import org.apache.lucene.search.Weight;
            public SortedSetDocValues getSortedSet(FieldInfo field) throws IOException {
            }
                        }
            @Override
            public BinaryDocValues getBinary(FieldInfo field) throws IOException {
 * under the License.
                    super.document(docID, visitor);
                @Override
        public CacheHelper getCoreCacheHelper() {
        IndexSearcher s = new IndexSearcher(reader);
import org.apache.lucene.index.CodecReader;
            public void binaryField(FieldInfo fieldInfo, byte[] value) throws IOException {
 */
                    });
            @Override
            // calculating the cardinality is significantly cheaper than skipping all bulk-merging we might do
         *
import org.apache.lucene.index.StoredFieldVisitor;
            }
    private static class SourcePruningFilterCodecReader extends FilterCodecReader {
                }
            @Override
            }
import org.apache.lucene.index.FilterCodecReader;
                return in.getNumeric(field);
         * @opensearch.internal
import org.apache.lucene.search.Query;
            }
         * A producer of filtered doc vlaues
                return in.getSortedNumeric(field);
            @Override
    private static CodecReader wrapReader(String recoverySourceField, CodecReader reader, Supplier<Query> retainSourceQuerySupplier)
        NumericDocValues recoverySource = reader.getNumericDocValues(recoverySourceField);
            public void checkIntegrity() throws IOException {
import java.util.Arrays;
import org.apache.lucene.index.SortedNumericDocValues;
                visitor.doubleField(fieldInfo, value);
            public void floatField(FieldInfo fieldInfo, float value) throws IOException {
            }
         * @opensearch.internal
 * Modifications Copyright OpenSearch Contributors. See
         *
                return reader; // keep all source
                visitor.intField(fieldInfo, value);
            public void checkIntegrity() throws IOException {
 * software distributed under the License is distributed on an
                            }
 * specific language governing permissions and limitations
        SourcePruningFilterCodecReader(String recoverySourceField, CodecReader reader, BitSet recoverySourceToKeep) {
        public DocValuesProducer getDocValuesReader() {
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.util.BitSetIterator;
        }
import java.util.function.Supplier;
                                Arrays.asList(numeric, new BitSetIterator(recoverySourceToKeep, recoverySourceToKeep.length()))
                        final DocIdSetIterator intersection;
 * KIND, either express or implied.  See the License for the
                            public int advance(int target) {
                visitor.longField(fieldInfo, value);
            }
            protected final StoredFieldsReader in;
                            }
        }
            }
            public void longField(FieldInfo fieldInfo, long value) throws IOException {
 * Unless required by applicable law or agreed to in writing,
            @Override
    /**
                visitor.floatField(fieldInfo, value);
        /**
        Scorer scorer = weight.scorer(reader.getContext());
            @Override
     */
                return in.getSorted(field);
            }
        }
                        if (recoverySourceToKeep == null) {
        }
         */
import org.apache.lucene.search.Scorer;
                return in.getSortedSet(field);
                this.in = in;
            @Override
                            public boolean advanceExact(int target) {
}
 *
            }
                return in.getBinary(field);
import org.apache.lucene.index.FieldInfo;
                            @Override
            }
                        return new FilterNumericDocValues(numeric) {
         *
            @Override
package org.opensearch.index.engine;
                    NumericDocValues numeric = super.getNumeric(field);
import org.apache.lucene.search.ConjunctionUtils;
/*
            @Override
 *
            private final DocValuesProducer in;
            return reader; // early terminate - nothing to do here since non of the docs has a recovery source anymore.
                visitor.binaryField(fieldInfo, value);
            private final String recoverySourceField;
            @Override
            @Override
 * SPDX-License-Identifier: Apache-2.0
        @Override
            }
 * The OpenSearch Contributors require contributions made to
        public CacheHelper getReaderCacheHelper() {
            return null;
 * ownership. Elasticsearch licenses this file to you under
                public NumericDocValues getNumeric(FieldInfo field) throws IOException {
        private static class FilterStoredFieldVisitor extends StoredFieldVisitor {
            }
            this.recoverySourceToKeep = recoverySourceToKeep;
                            if (recoverySourceField.equals(fieldInfo.name)) {
            public StoredFieldsReader getMergeInstance() {
            public SortedDocValues getSorted(FieldInfo field) throws IOException {
            }
            @Override
                                throw new UnsupportedOperationException();
                            @Override
                            public int nextDoc() throws IOException {
            }
                return new RecoverySourcePruningStoredFieldsReader(in.clone(), recoverySourceToKeep, recoverySourceField);
            public CodecReader wrapForMerge(CodecReader reader) throws IOException {
import org.apache.lucene.index.DocValuesSkipper;
                        @Override
                return wrapReader(recoverySourceField, wrapped, retainSourceQuerySupplier);
            public void document(int docID, StoredFieldVisitor visitor) throws IOException {
            public StoredFieldsReader clone() {
 * license agreements. See the NOTICE file distributed with
            }
                this.recoverySourceField = Objects.requireNonNull(recoverySourceField);
                } else {
        } else {
     *
            @Override
                        public Status needsField(FieldInfo fieldInfo) throws IOException {
        /**
import org.apache.lucene.search.ScoreMode;
                                return Status.NO;
            public void close() throws IOException {
            return new SourcePruningFilterCodecReader(recoverySourceField, reader, null);
        private final BitSet recoverySourceToKeep;
            public void close() throws IOException {
            @Override
    }
            @Override
        }
        }
            FilterStoredFieldVisitor(StoredFieldVisitor visitor) {
                }
        }
 *
            }
            BitSet recoverySourceToKeep = BitSet.of(scorer.iterator(), reader.maxDoc());
        @Override
            public DocValuesSkipper getSkipper(FieldInfo field) throws IOException {
        throws IOException {
            }
            DocValuesProducer docValuesReader = super.getDocValuesReader();
            @Override
         * @opensearch.internal
 */
import org.apache.lucene.index.OneMergeWrappingMergePolicy;
import org.apache.lucene.index.SortedDocValues;
        /**
 * Merge Policy that prunes the recovery source
            public abstract StoredFieldsReader clone();
/*
            public Status needsField(FieldInfo fieldInfo) throws IOException {
import org.apache.lucene.index.NumericDocValues;
         *
                visitor.stringField(fieldInfo, value);
            this.recoverySourceField = recoverySourceField;
        }
 * not use this file except in compliance with the License.
            if (recoverySourceToKeep.cardinality() == reader.maxDoc()) {
import org.apache.lucene.index.FilterNumericDocValues;
            public NumericDocValues getNumeric(FieldInfo field) throws IOException {
            return null;
                if (recoverySourceToKeep != null && recoverySourceToKeep.get(docID)) {
            public void stringField(FieldInfo fieldInfo, String value) throws IOException {
                            intersection = ConjunctionUtils.intersectIterators(
            super(reader);
            }
    }
import org.apache.lucene.index.BinaryDocValues;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                            return super.needsField(fieldInfo);
                return in.getSkipper(field);
                in.close();
                return new RecoverySourcePruningStoredFieldsReader(in.getMergeInstance(), recoverySourceToKeep, recoverySourceField);
/*
                        };
import org.apache.lucene.search.IndexSearcher;
 */
            }
        }
import org.apache.lucene.search.DocIdSetIterator;
            public SortedNumericDocValues getSortedNumeric(FieldInfo field) throws IOException {
    }
            FilterStoredFieldsReader(StoredFieldsReader fieldsReader) {
            public void doubleField(FieldInfo fieldInfo, double value) throws IOException {
                this.recoverySourceToKeep = recoverySourceToKeep;
         * @opensearch.internal
                this.in = fieldsReader;
            }
                    super.document(docID, new FilterStoredFieldVisitor(visitor) {
     * A codec reader that prunes the source using a filter
            }
            public void document(int docID, StoredFieldVisitor visitor) throws IOException {
                CodecReader wrapped = toWrap.wrapForMerge(reader);
            }
 */
     * @opensearch.internal
         * A visitor pattern for filtered stored fields
                        assert numeric != null : recoverySourceField + " must have numeric DV but was null";
         */
import java.util.Objects;
            RecoverySourcePruningStoredFieldsReader(StoredFieldsReader in, BitSet recoverySourceToKeep, String recoverySourceField) {
                in.checkIntegrity();
 * this work for additional information regarding copyright
                    if (recoverySourceField.equals(field.name)) {
                    }
import org.apache.lucene.codecs.DocValuesProducer;
/**
        super(in, toWrap -> new OneMerge(toWrap.segments) {
        if (recoverySource == null || recoverySource.nextDoc() == DocIdSetIterator.NO_MORE_DOCS) {
                super(in);
        Weight weight = s.createWeight(s.rewrite(retainSourceQuerySupplier.get()), ScoreMode.COMPLETE_NO_SCORES, 1.0f);
                in.document(docID, visitor);
         */
        private static class FilterDocValuesProducer extends DocValuesProducer {
import java.io.IOException;
import org.apache.lucene.util.BitSet;
        private static class RecoverySourcePruningStoredFieldsReader extends FilterStoredFieldsReader {
            @Override
                    return numeric;
            }
        }
                            // we can't return null here lucenes DocIdMerger expects an instance
        s.setQueryCache(null);
                            }
 * GitHub history for details.
                        }
            };
                in.close();
            }
                                throw new UnsupportedOperationException();
                            intersection = DocIdSetIterator.empty();
            @Override
            @Override
    RecoverySourcePruneMergePolicy(String recoverySourceField, Supplier<Query> retainSourceQuerySupplier, MergePolicy in) {
 * the Apache License, Version 2.0 (the "License"); you may
        private abstract static class FilterStoredFieldsReader extends StoredFieldsReader {
            }
        if (scorer != null) {
                return visitor.needsField(fieldInfo);
            // if retentions are high we keep most of it
        @Override
                        } else {
final class RecoverySourcePruneMergePolicy extends OneMergeWrappingMergePolicy {
            @Override
         * A fields reader that provides a filtered stored field
            @Override
 *
 * @opensearch.internal
import org.apache.lucene.codecs.StoredFieldsReader;
        }
            }
        @Override
                this.visitor = visitor;
 * compatible open source license.
                            }
