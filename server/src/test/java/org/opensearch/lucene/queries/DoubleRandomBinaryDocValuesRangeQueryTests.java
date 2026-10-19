        public Double getMin() {  
            if (max > v) {  
        }
        public Double getMax() {
 */
 * KIND, either express or implied.  See the License for the
            assert dim == 0;
                    return (random().nextInt(15) - 7) / 3d;  
            if ((this.min >= other.min && this.max <= other.max) == false) {
    private double nextDoubleInternal() {
            return min;
        double value1 = nextDoubleInternal();
            if ((this.min <= other.min && this.max >= other.max) == false) {
        }
                max = v;  
        @Override
        @Override  
        }  
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
            DoubleTestRange other = (DoubleTestRange) o;  
 * license agreements. See the NOTICE file distributed with
                min = v;
            DoubleTestRange other = (DoubleTestRange) o;
        @Override
            }
                if (random().nextBoolean()) {  
        @Override
            this.min = min;
 * The OpenSearch Contributors require contributions made to  
                }
                max = v;  
    }  
        }
        protected void setMax(int dim, Object val) {  
        return RangeType.DOUBLE;
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
                } else {
        return new DoubleTestRange(min, max);
 * this work for additional information regarding copyright
 */  
        protected boolean contains(Range o) {  
 * You may obtain a copy of the License at  
            } else {
    protected Range nextRange(int dimensions) throws Exception {  
        }
                min = v;
        double value2 = nextDoubleInternal();
        protected boolean isWithin(Range o) {
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected String fieldName() {
        protected boolean isDisjoint(Range o) {
    @Override  
        double max = Math.max(value1, value2);
            return true;  
            default:
        protected void setMin(int dim, Object val) {
            }  
            } else {
        }
/*
                // not contains:  
            DoubleTestRange other = (DoubleTestRange) o;  
                return false;  
}
    @Override
 * Unless required by applicable law or agreed to in writing,
            assert dim == 0;  
            case 1:  
    }  
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
            return max;
            double v = (Double) val;
        }  
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
 *
                return false;
            this.max = max;
package org.opensearch.lucene.queries;
    }  
 * Modifications Copyright OpenSearch Contributors. See  
        DoubleTestRange(double min, double max) {  
        @Override
        double min;  
 * the Apache License, Version 2.0 (the "License"); you may
                // not within:
 */
        @Override
 * SPDX-License-Identifier: Apache-2.0
            }
                return Double.NEGATIVE_INFINITY;
 * compatible open source license.
            case 0:
 *  
    protected RangeType rangeType() {
        @Override
import org.opensearch.index.mapper.RangeType;  
    }
            if (min < v) {
 * not use this file except in compliance with the License.
        double max;
                    return random().nextDouble();
 *
        return "double_range_dv_field";  
            return true;
            return this.min > other.max || this.max < other.min;
/*
public class DoubleRandomBinaryDocValuesRangeQueryTests extends BaseRandomBinaryDocValuesRangeQueryTestCase {
    }  
        double min = Math.min(value1, value2);  
    private static class DoubleTestRange extends AbstractRange<Double> {
        }
            }
                return Double.POSITIVE_INFINITY;
        switch (random().nextInt(5)) {  
            double v = (Double) val;
        }  
 * specific language governing permissions and limitations
