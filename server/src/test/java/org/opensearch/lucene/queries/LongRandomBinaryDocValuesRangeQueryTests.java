            return true;
                }  
        LongTestRange(long min, long max) {
    @Override
            return max;
 * the Apache License, Version 2.0 (the "License"); you may
                max = v;
 * ownership. Elasticsearch licenses this file to you under  
        @Override
            }  
 * specific language governing permissions and limitations
    }
            } else {
        }
                        long v = TestUtil.nextLong(random(), 0, (1L << bpv) - 1);  
        long min = Math.min(value1, value2);
 * The OpenSearch Contributors require contributions made to  
        }
                max = v;
 * software distributed under the License is distributed on an
            long v = (Long) val;
            assert dim == 0;
            }
    }
                return false;  
        @Override
                        }
}
/*
        protected boolean isWithin(Range o) {
            return true;
 * Unless required by applicable law or agreed to in writing,
        @Override  
 * SPDX-License-Identifier: Apache-2.0
        protected boolean isDisjoint(Range o) {
        protected boolean contains(Range o) {
        switch (random().nextInt(5)) {
        }  
 *  
            long v = (Long) val;  
            LongTestRange other = (LongTestRange) o;
/*  
        return "long_range_dv_field";
                int bpv = random().nextInt(64);
        public Long getMin() {
    private long nextLongInternal() {  
        }
 * under the License.  
 *
 * license agreements. See the NOTICE file distributed with
 */  
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.index.mapper.RangeType;
        public Long getMax() {  
                min = v;  
            LongTestRange other = (LongTestRange) o;  
            if (min < v) {
            assert dim == 0;  
 */
 *
        @Override  
 * compatible open source license.
 * You may obtain a copy of the License at  
            if ((this.min <= other.min && this.max >= other.max) == false) {
                        return random().nextLong();
            return min;  
                min = v;
import org.apache.lucene.tests.util.TestUtil;  
        long value2 = nextLongInternal();  
    @Override  
        @Override
                        return v;
                switch (bpv) {
    @Override
    }
            if ((this.min >= other.min && this.max <= other.max) == false) {  
 * not use this file except in compliance with the License.
            case 1:
    protected String fieldName() {  
                            v -= 1L << (bpv - 1);  
        protected void setMin(int dim, Object val) {
    private static class LongTestRange extends AbstractRange<Long> {
        }
 */
            if (max > v) {
                return false;
        }  
            LongTestRange other = (LongTestRange) o;
 * KIND, either express or implied.  See the License for the
        long max = Math.max(value1, value2);
            }  
package org.opensearch.lucene.queries;
            } else {  
        }
        long min;
public class LongRandomBinaryDocValuesRangeQueryTests extends BaseRandomBinaryDocValuesRangeQueryTestCase {  
        protected void setMax(int dim, Object val) {
    protected RangeType rangeType() {
            return this.min > other.max || this.max < other.min;  
 * this file be licensed under the Apache-2.0 license or a
                // not within:
                        if (bpv > 0) {
                    case 64:  
        return RangeType.LONG;  
/*
    }
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
            default:  
        long max;  
                // not contains:
                            // negative values sometimes
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                return Long.MIN_VALUE;  
    }
        }
        long value1 = nextLongInternal();
            this.min = min;  
        @Override
            this.max = max;
    protected Range nextRange(int dimensions) throws Exception {
        return new LongTestRange(min, max);  
            case 0:
                return Long.MAX_VALUE;
            }
 * Licensed to Elasticsearch under one or more contributor  
        @Override  
        }
                    default:
