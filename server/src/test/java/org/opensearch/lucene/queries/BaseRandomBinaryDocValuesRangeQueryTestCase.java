    protected final Query newCrossesQuery(Range box) {
 * The OpenSearch Contributors require contributions made to  
        protected final Object getMin(int dim) {
    protected final int dimension() {
 * software distributed under the License is distributed on an
            return getMin();  
        return rangeType().dvRangeQuery(fieldName(), CROSSES, testRange.getMin(), testRange.getMax(), true, true);  
 * specific language governing permissions and limitations
        try {
import org.apache.lucene.search.Query;
        @Override
import org.apache.lucene.document.BinaryDocValuesField;  
import java.util.Objects;
 * KIND, either express or implied.  See the License for the
/*
    protected abstract static class AbstractRange<T> extends Range {  
 */
    @Override
        public final String toString() {
import java.util.Collections;  
    }
 * not use this file except in compliance with the License.
        }  
import org.apache.lucene.tests.search.BaseRangeFieldQueryTestCase;  
        }  
 * GitHub history for details.
            assert dim == 0;
    @Override  
    }
    }  
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
    protected final Field newRangeField(Range box) {
 * this work for additional information regarding copyright
 *
}
        protected final boolean isEqual(Range o) {
        @Override
    protected abstract RangeType rangeType();
            return getMax();
        return rangeType().dvRangeQuery(fieldName(), CONTAINS, testRange.getMin(), testRange.getMax(), true, true);  
        return rangeType().dvRangeQuery(fieldName(), WITHIN, testRange.getMin(), testRange.getMax(), true, true);  
/*
        AbstractRange<?> testRange = (AbstractRange<?>) box;
    protected final Query newContainsQuery(Range box) {
import org.apache.lucene.util.BytesRef;
        return 1;
        RangeFieldMapper.Range range = new RangeFieldMapper.Range(rangeType(), testRange.getMin(), testRange.getMax(), true, true);  
            AbstractRange<?> other = (AbstractRange<?>) o;  
 *
 * the Apache License, Version 2.0 (the "License"); you may
        }
            return new BinaryDocValuesField(fieldName(), encodeRange);  
 */  
        protected final int numDimensions() {
        }
        protected final Object getMax(int dim) {  
            BytesRef encodeRange = rangeType().encodeRanges(Collections.singleton(range));
    protected abstract String fieldName();
    @Override  
        AbstractRange<?> testRange = (AbstractRange<?>) box;
        @Override
 * ownership. Elasticsearch licenses this file to you under  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See  
import static org.opensearch.lucene.queries.BinaryDocValuesRangeQuery.QueryType.WITHIN;  
    @Override  
    protected final Query newWithinQuery(Range box) {
    }
            assert dim == 0;
package org.opensearch.lucene.queries;
        @Override  
 * You may obtain a copy of the License at  
        AbstractRange<?> testRange = (AbstractRange<?>) box;
            throw new RuntimeException(e);
        } catch (IOException e) {
            return 1;  
    }
 * under the License.  
    @Override  
    public void testMultiValued() throws Exception {
 */
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return rangeType().dvRangeQuery(fieldName(), INTERSECTS, testRange.getMin(), testRange.getMax(), true, true);  
        public abstract T getMin();  
public abstract class BaseRandomBinaryDocValuesRangeQueryTestCase extends BaseRangeFieldQueryTestCase {
 *  
            return Objects.equals(getMin(), other.getMin()) && Objects.equals(getMax(), other.getMax());
import org.opensearch.index.mapper.RangeType;  
    }
    @Override  
 * compatible open source license.
    @Override  
        AbstractRange<?> testRange = (AbstractRange<?>) box;
import static org.opensearch.lucene.queries.BinaryDocValuesRangeQuery.QueryType.CONTAINS;  
import static org.opensearch.lucene.queries.BinaryDocValuesRangeQuery.QueryType.CROSSES;
        // Can't test this how BaseRangeFieldQueryTestCase works now, because we're using BinaryDocValuesField here.  
        public abstract T getMax();
import static org.opensearch.lucene.queries.BinaryDocValuesRangeQuery.QueryType.INTERSECTS;
import org.apache.lucene.document.Field;
    protected final Query newIntersectsQuery(Range box) {
/*  
        }
    }
 * Unless required by applicable law or agreed to in writing,
            return "Box(" + getMin() + " TO " + getMax() + ")";  
import org.opensearch.index.mapper.RangeFieldMapper;
        }
        AbstractRange<?> testRange = (AbstractRange<?>) box;
