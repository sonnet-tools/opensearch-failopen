 *  
 * compatible open source license.
        }
                min = v;
            return true;
            }
                        if (bpv > 0) {
            }  
            case 1:
                return Integer.MIN_VALUE;  
            assert dim == 0;  
 * under the License.  
                    case 32:  
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
        return RangeType.INTEGER;  
        switch (random().nextInt(5)) {
        protected void setMax(int dim, Object val) {
            IntTestRange other = (IntTestRange) o;
    @Override  
/*
                max = v;
            IntTestRange other = (IntTestRange) o;
    @Override
    @Override
 * SPDX-License-Identifier: Apache-2.0
        protected void setMin(int dim, Object val) {
        @Override  
            this.max = max;
    private int nextIntInternal() {  
/*
    protected Range nextRange(int dimensions) throws Exception {
    }
 */
                int bpv = random().nextInt(32);
 */  
            if ((this.min <= other.min && this.max >= other.max) == false) {
            return true;
 * software distributed under the License is distributed on an
        @Override  
 * Unless required by applicable law or agreed to in writing,
            if ((this.min >= other.min && this.max <= other.max) == false) {  
                // not contains:
 * the Apache License, Version 2.0 (the "License"); you may
        return new IntTestRange(min, max);  
import org.apache.lucene.tests.util.TestUtil;  
                        return v;
                min = v;  
                }  
            assert dim == 0;
 *
        int value2 = nextIntInternal();  
            } else {
        }  
    }
 * ownership. Elasticsearch licenses this file to you under  
                            // negative values sometimes
                return false;  
        }  
        int min = Math.min(value1, value2);
            } else {  
        @Override
        @Override
 * Modifications Copyright OpenSearch Contributors. See  
        }
            this.min = min;  
package org.opensearch.lucene.queries;
            if (max > v) {
 * GitHub history for details.
            if (min < v) {
        }
            default:  
        }
}
                    default:
        @Override
                        int v = TestUtil.nextInt(random(), 0, (1 << bpv) - 1);  
 *    http://www.apache.org/licenses/LICENSE-2.0
                max = v;
    }
            }  
                switch (bpv) {
            int v = (Integer) val;
    }
            }
    private static class IntTestRange extends AbstractRange<Integer> {
            return max;
 * The OpenSearch Contributors require contributions made to  
        int min;
            case 0:
        int max = Math.max(value1, value2);
        protected boolean isWithin(Range o) {
        }
public class IntegerRandomBinaryDocValuesRangeQueryTests extends BaseRandomBinaryDocValuesRangeQueryTestCase {  
 */
        public Integer getMax() {  
            return this.min > other.max || this.max < other.min;  
        int value1 = nextIntInternal();
        public Integer getMin() {
        int max;  
 * specific language governing permissions and limitations
                        }
    protected String fieldName() {  
            IntTestRange other = (IntTestRange) o;  
        protected boolean contains(Range o) {
        return "int_range_dv_field";
        }
        @Override
 * You may obtain a copy of the License at  
            int v = (Integer) val;  
        @Override  
/*  
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return min;  
 *
    protected RangeType rangeType() {
        protected boolean isDisjoint(Range o) {
import org.opensearch.index.mapper.RangeType;
        }
    }
                        return random().nextInt();
        IntTestRange(int min, int max) {
                return Integer.MAX_VALUE;
 * this work for additional information regarding copyright
                            v -= 1 << (bpv - 1);  
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
                return false;
                // not within:
