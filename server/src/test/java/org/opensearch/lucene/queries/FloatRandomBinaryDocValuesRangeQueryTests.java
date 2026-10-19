 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
        @Override
/*  
 * this file be licensed under the Apache-2.0 license or a
        protected boolean isWithin(Range o) {
                return false;
    private static class FloatTestRange extends AbstractRange<Float> {
        float max = Math.max(value1, value2);
    }  
                max = v;  
        return new FloatTestRange(min, max);
            if ((this.min <= other.min && this.max >= other.max) == false) {
 */
    private float nextFloatInternal() {
                return false;  
 * software distributed under the License is distributed on an
    protected String fieldName() {
            return this.min > other.max || this.max < other.min;
            return min;
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
            this.min = min;
        public Float getMin() {  
            return max;
            } else {
/*
/*
        FloatTestRange(float min, float max) {  
        float max;
    }
        float min = Math.min(value1, value2);  
        @Override
 * not use this file except in compliance with the License.
                    return random().nextFloat();
                return Float.NEGATIVE_INFINITY;
    @Override
        protected boolean isDisjoint(Range o) {
}
 * compatible open source license.
            default:
 * Modifications Copyright OpenSearch Contributors. See  
        }  
            return true;
package org.opensearch.lucene.queries;
        return "float_range_dv_field";  
            }  
                }
 * the Apache License, Version 2.0 (the "License"); you may
        protected void setMin(int dim, Object val) {
    }  
 * Licensed to Elasticsearch under one or more contributor  
 *
            float v = (Float) val;
        }
                min = v;
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
        public Float getMax() {
                    return (random().nextInt(15) - 7) / 3f;  
    @Override
public class FloatRandomBinaryDocValuesRangeQueryTests extends BaseRandomBinaryDocValuesRangeQueryTestCase {
    @Override  
        }  
        @Override
        }
            if ((this.min >= other.min && this.max <= other.max) == false) {
                // not contains:  
 * SPDX-License-Identifier: Apache-2.0
            this.max = max;
        return RangeType.FLOAT;
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
            assert dim == 0;
            }
 * Unless required by applicable law or agreed to in writing,
            float v = (Float) val;
        }
            } else {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        float min;  
        float value2 = nextFloatInternal();
        }
            case 1:  
    protected Range nextRange(int dimensions) throws Exception {  
    protected RangeType rangeType() {
 */  
                min = v;
            case 0:
 *  
        @Override
        protected void setMax(int dim, Object val) {  
            if (min < v) {
        }  
        switch (random().nextInt(5)) {  
 * this work for additional information regarding copyright
        @Override
import org.opensearch.index.mapper.RangeType;  
            assert dim == 0;  
        }
            return true;  
 *
        protected boolean contains(Range o) {  
                if (random().nextBoolean()) {  
            }
        float value1 = nextFloatInternal();
            FloatTestRange other = (FloatTestRange) o;
            FloatTestRange other = (FloatTestRange) o;  
 */
            if (max > v) {  
                return Float.POSITIVE_INFINITY;
                max = v;  
    }  
                // not within:
            }
 * specific language governing permissions and limitations
        @Override
            FloatTestRange other = (FloatTestRange) o;  
                } else {
        @Override  
