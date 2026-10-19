                            }
}
     * Fails with an {@link IllegalStateException} if a document contains multiple values for the specified field.
                                        throw new IllegalStateException(
import org.apache.lucene.index.DocValuesType;
        @Override
                    return values.lookupOrd(ord);
        @Override
                                return sorted.docID();
            }
import org.apache.lucene.util.BytesRef;
    /**
 * Unless required by applicable law or agreed to in writing,
                                if (sorted.advanceExact(target)) {
        public org.apache.lucene.search.grouping.GroupSelector.State advanceTo(int doc) throws IOException {
                return State.ACCEPT;
        public void setScorer(Scorable scorer) throws IOException {}
                            }
 * KIND, either express or implied.  See the License for the
                            public int getValueCount() {
            DocValuesType type = getDocValuesType(reader, field);
                    break;
import org.apache.lucene.index.SortedSetDocValues;
                    if (values == null) {
                        values = new AbstractNumericDocValues() {
    CollapsingDocValuesSource(String field) {
            LeafReader reader = readerContext.reader();
                                if (sorted.advanceExact(target)) {
                            @Override
        public BytesRef currentValue() {
        }
                values = DocValues.emptySorted();
        public void setNextReader(LeafReaderContext readerContext) throws IOException {
                values = DocValues.emptyNumeric();
    }
                        };
        public Long copyValue() {
import org.apache.lucene.index.SortedNumericDocValues;
            } else {
                            }
            }
                                return sorted.docID();
                return State.SKIP;
                                return ord;
        private SortedDocValues values;
                            @Override
        private int ord;
                            @Override
                    break;
        FieldInfo fi = in.getFieldInfos().fieldInfo(field);
                                return sorted.lookupOrd(ord);
        @Override
            return fi.getDocValuesType();
            if (type == null || type == DocValuesType.NONE) {
        public void setScorer(Scorable scorer) throws IOException {}
 * Licensed to Elasticsearch under one or more contributor
    }
        public void setNextReader(LeafReaderContext readerContext) throws IOException {
                            }
            BytesRef value = currentValue();
    }
                            public boolean advanceExact(int target) throws IOException {
                hasValue = false;
                                    ord = (int) sorted.nextOrd();
     */
                            private long value;
 *
/*
                            @Override
                            @Override
                                    return false;
                                }
            }
                                } else {
                default:
    public void setGroups(Collection<SearchGroup<T>> groups) {
                return BytesRef.deepCopyOf(value);
import org.opensearch.index.fielddata.AbstractNumericDocValues;
        @Override
                            public int ordValue() {
 * GitHub history for details.
                return;
                    }
import org.opensearch.index.fielddata.AbstractSortedDocValues;
 * ownership. Elasticsearch licenses this file to you under
    }
    @Override
                } catch (IOException e) {
 */
                hasValue = true;
                            }
                    throw new RuntimeException(e);
                return State.SKIP;
 * this file be licensed under the Apache-2.0 license or a
                    final SortedNumericDocValues sorted = DocValues.getSortedNumeric(reader, field);
                                return (int) sorted.getValueCount();
                    values = DocValues.unwrapSingleton(sorted);
 * this work for additional information regarding copyright
                    values = DocValues.getSorted(reader, field);
            } else {
        throw new UnsupportedOperationException();
                    values = DocValues.getNumeric(reader, field);
                            public int docID() {
 */
        }
import org.apache.lucene.index.FieldInfo;
                return null;
            DocValuesType type = getDocValuesType(reader, field);
                                }
 * Utility class that ensures that a single collapse key is extracted per document.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * specific language governing permissions and limitations
                            }
import org.apache.lucene.index.SortedDocValues;
                                            "failed to collapse " + target + ", the collapse field must be single valued"
                ord = values.ordValue();
    static class Numeric extends CollapsingDocValuesSource<Long> {
                value = values.longValue();
import org.apache.lucene.index.LeafReaderContext;
 */
            } else {
                            public BytesRef lookupOrd(int ord) throws IOException {
    static class Keyword extends CollapsingDocValuesSource<BytesRef> {
            }
import java.util.Collection;
 * Modifications Copyright OpenSearch Contributors. See
        this.field = field;
 * under the License.
            LeafReader reader = readerContext.reader();
                        };
        @Override
            switch (type) {
        @Override
            if (values.advanceExact(doc)) {
 * license agreements. See the NOTICE file distributed with
            } else {
                                    }
        public BytesRef copyValue() {
        @Override
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.index.DocValues;
                }
                return State.ACCEPT;
 * SPDX-License-Identifier: Apache-2.0
            return currentValue();
        Numeric(MappedFieldType fieldType) {
 * compatible open source license.
                            private int ord;
        public Long currentValue() {
                                } else {
        public State advanceTo(int doc) throws IOException {
        }
            if (values.advanceExact(doc)) {
        }
import org.opensearch.index.mapper.MappedFieldType;
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
                                    return true;
     */
            switch (type) {
                    break;
            if (value == null) {
/*
        }
                    break;
        }
/*
                default:
        @Override
 *
        }
        return null;
                    throw new IllegalStateException("unexpected doc values type " + type + "` for field `" + field + "`");
                return null;
                            }
    protected final String field;
                                        );
    private static DocValuesType getDocValuesType(LeafReader in, String field) {
                case SORTED_NUMERIC:
 * You may obtain a copy of the License at
                                    return false;
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
                case NUMERIC:
                    throw new IllegalStateException("unexpected doc values type " + type + "` for field `" + field + "`");
     * Implementation for {@link NumericDocValues} and {@link SortedNumericDocValues}.
            super(fieldType.name());
        Keyword(MappedFieldType fieldType) {
                        values = new AbstractSortedDocValues() {
        if (fi != null) {
                    values = DocValues.unwrapSingleton(sorted);
 *
        @Override
import org.apache.lucene.index.LeafReader;
import org.apache.lucene.search.Scorable;
            if (type == null || type == DocValuesType.NONE) {
                case SORTED_SET:
                                    }
     * Fails with an {@link IllegalStateException} if a document contains multiple values for the specified field.
            return hasValue ? value : null;
        private NumericDocValues values;
            }
        }
                                        );
abstract class CollapsingDocValuesSource<T> extends GroupSelector<T> {
                return;
    }
                    }
            if (ord == -1) {
                            @Override
        @Override
/**
                            @Override
                                    value = sorted.nextValue();
                                    if (sorted.docValueCount() > 1) {
     * Implementation for {@link SortedDocValues} and {@link SortedSetDocValues}.
        private long value;
        private boolean hasValue;
 */
                            public long longValue() throws IOException {
                case SORTED:
                try {
                            public boolean advanceExact(int target) throws IOException {
                                            "failed to collapse " + target + ", the collapse field must be single valued"
package org.apache.lucene.search.grouping;
                            @Override
import java.io.IOException;
        }
            }
    /**
                    final SortedSetDocValues sorted = DocValues.getSortedSet(reader, field);
            }
                                return value;
                ord = -1;
        }
        }
                    if (values == null) {
                                    return true;
            }
                                    if (sorted.docValueCount() != 1) {
                                        throw new IllegalStateException(
                            public int docID() {
            super(fieldType.name());
import org.apache.lucene.index.NumericDocValues;
                            }
