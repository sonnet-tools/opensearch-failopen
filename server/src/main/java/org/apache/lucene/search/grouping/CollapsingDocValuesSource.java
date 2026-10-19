    /**
                return BytesRef.deepCopyOf(value);
 * Utility class that ensures that a single collapse key is extracted per document.
                                    if (sorted.docValueCount() > 1) {
                                            "failed to collapse " + target + ", the collapse field must be single valued"
 * software distributed under the License is distributed on an
        @Override
    CollapsingDocValuesSource(String field) {  
                    if (values == null) {  
                                return sorted.lookupOrd(ord);
 * GitHub history for details.
 * this work for additional information regarding copyright
        public void setScorer(Scorable scorer) throws IOException {}
        private boolean hasValue;
        public BytesRef copyValue() {
                            @Override  
                ord = -1;
            switch (type) {
import org.apache.lucene.index.DocValues;  
 * specific language governing permissions and limitations
                            public BytesRef lookupOrd(int ord) throws IOException {
                                        );  
                            @Override
                            @Override
                    values = DocValues.unwrapSingleton(sorted);
        @Override
                ord = values.ordValue();
            LeafReader reader = readerContext.reader();
    protected final String field;
                    break;
        }
                return null;
     * Fails with an {@link IllegalStateException} if a document contains multiple values for the specified field.  
        public Long copyValue() {
                case SORTED:
                values = DocValues.emptySorted();
        public State advanceTo(int doc) throws IOException {
                                        throw new IllegalStateException(  
import org.apache.lucene.index.DocValuesType;
        @Override
     * Implementation for {@link NumericDocValues} and {@link SortedNumericDocValues}.
import org.apache.lucene.index.SortedDocValues;  
            DocValuesType type = getDocValuesType(reader, field);
            if (values.advanceExact(doc)) {  
import org.opensearch.index.fielddata.AbstractNumericDocValues;
                                            "failed to collapse " + target + ", the collapse field must be single valued"
                case SORTED_NUMERIC:  
    static class Keyword extends CollapsingDocValuesSource<BytesRef> {
            return hasValue ? value : null;  
     * Implementation for {@link SortedDocValues} and {@link SortedSetDocValues}.
            return currentValue();
                            public int ordValue() {
                            @Override
     */
        private long value;  
 * the Apache License, Version 2.0 (the "License"); you may
                            }  
 */
                    throw new IllegalStateException("unexpected doc values type " + type + "` for field `" + field + "`");
        this.field = field;
        Numeric(MappedFieldType fieldType) {  
    }
     */  
    static class Numeric extends CollapsingDocValuesSource<Long> {
            } else {
                                } else {  
                            public int docID() {  
 * Licensed to Elasticsearch under one or more contributor  
 */  
            super(fieldType.name());
            }
        @Override
 *
                                } else {  
                    return values.lookupOrd(ord);  
                            @Override
import org.apache.lucene.index.LeafReaderContext;
 * this file be licensed under the Apache-2.0 license or a
    public void setGroups(Collection<SearchGroup<T>> groups) {
 * ownership. Elasticsearch licenses this file to you under  
            DocValuesType type = getDocValuesType(reader, field);
        throw new UnsupportedOperationException();  
 * under the License.  
    }
            }  
        }  
                                        throw new IllegalStateException(
                    final SortedNumericDocValues sorted = DocValues.getSortedNumeric(reader, field);
}
                            @Override
import org.apache.lucene.index.SortedSetDocValues;
        private NumericDocValues values;
                return;
        public void setNextReader(LeafReaderContext readerContext) throws IOException {  
    /**  
            }  
    @Override
        }
        @Override
                        values = new AbstractNumericDocValues() {
                    values = DocValues.getSorted(reader, field);  
                    break;
            } else {  
            }
            } else {  
        Keyword(MappedFieldType fieldType) {  
        }
    private static DocValuesType getDocValuesType(LeafReader in, String field) {
        public BytesRef currentValue() {
                values = DocValues.emptyNumeric();
        @Override  
     * Fails with an {@link IllegalStateException} if a document contains multiple values for the specified field.
                            }  
                return;
        }  
 *    http://www.apache.org/licenses/LICENSE-2.0
                                    ord = (int) sorted.nextOrd();
    }
/**  
                                if (sorted.advanceExact(target)) {
            if (values.advanceExact(doc)) {  
            LeafReader reader = readerContext.reader();
                                }
            if (type == null || type == DocValuesType.NONE) {  
            if (ord == -1) {
                                    return false;
import org.opensearch.index.mapper.MappedFieldType;
 * Unless required by applicable law or agreed to in writing,
                hasValue = true;
                return State.ACCEPT;  
                                return ord;  
                    values = DocValues.unwrapSingleton(sorted);
                                    return false;
        @Override  
                    }
 * Modifications Copyright OpenSearch Contributors. See  
                                return value;  
                        };  
        FieldInfo fi = in.getFieldInfos().fieldInfo(field);
                            }
 * not use this file except in compliance with the License.
                                return (int) sorted.getValueCount();
import org.apache.lucene.search.Scorable;  
            }  
 * compatible open source license.
                    throw new RuntimeException(e);
                } catch (IOException e) {
import java.util.Collection;
                return State.SKIP;  
        @Override  
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * SPDX-License-Identifier: Apache-2.0
                            }
                }  
            if (value == null) {
                default:
 */
                hasValue = false;
                return State.ACCEPT;
                            public boolean advanceExact(int target) throws IOException {  
                try {
            return fi.getDocValuesType();
        }
                    break;
                            public long longValue() throws IOException {
                    throw new IllegalStateException("unexpected doc values type " + type + "` for field `" + field + "`");
        }
 * The OpenSearch Contributors require contributions made to  
/*  
            }  
                return State.SKIP;
                    final SortedSetDocValues sorted = DocValues.getSortedSet(reader, field);
            }
                            @Override
        return null;  
        public void setNextReader(LeafReaderContext readerContext) throws IOException {  
    }
                        };  
import java.io.IOException;  
 * You may obtain a copy of the License at  
                            @Override
import org.apache.lucene.index.FieldInfo;
        private int ord;
                    values = DocValues.getNumeric(reader, field);  
            if (type == null || type == DocValuesType.NONE) {  
                                    value = sorted.nextValue();
        }
                                        );
        @Override
            } else {
                    }
        @Override  
import org.apache.lucene.index.LeafReader;  
                value = values.longValue();
                case SORTED_SET:  
import org.opensearch.index.fielddata.AbstractSortedDocValues;  
                default:
                            private long value;  
                            }
            switch (type) {
 *
            super(fieldType.name());
                            public int docID() {  
                                    if (sorted.docValueCount() != 1) {  
                                    }  
                return null;  
    }
                            }  
        public void setScorer(Scorable scorer) throws IOException {}
import org.apache.lucene.index.NumericDocValues;
                                    return true;
                                if (sorted.advanceExact(target)) {
        public org.apache.lucene.search.grouping.GroupSelector.State advanceTo(int doc) throws IOException {
            BytesRef value = currentValue();  
package org.apache.lucene.search.grouping;
                        values = new AbstractSortedDocValues() {
                    break;
/*
                                    }
                            public boolean advanceExact(int target) throws IOException {  
        }
        }
                            public int getValueCount() {  
import org.apache.lucene.index.SortedNumericDocValues;
            }  
                                    return true;
                            }
                case NUMERIC:
                    if (values == null) {  
abstract class CollapsingDocValuesSource<T> extends GroupSelector<T> {  
        public Long currentValue() {
/*
        }
                                return sorted.docID();
 * KIND, either express or implied.  See the License for the
                                return sorted.docID();
                            private int ord;  
                                }
import org.apache.lucene.util.BytesRef;
        private SortedDocValues values;  
        if (fi != null) {  
                            }
 *  
