 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return value;
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal  
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
    private final double percent;
 * Unless required by applicable law or agreed to in writing,
    @Override
        if (this == o) {
 * this file be licensed under the Apache-2.0 license or a
    }  
package org.opensearch.search.aggregations.metrics;
 */  
        return Double.compare(that.percent, percent) == 0 && Double.compare(that.value, value) == 0;
/*  
 * SPDX-License-Identifier: Apache-2.0
            return false;
    public double getPercent() {  
    }
 *
 *  
    public boolean equals(Object o) {  
        return percent;
 */  
 * Implementation of a percentile
        this.percent = percent;
 */
    public Percentile(double percent, double value) {
/*  
        this.value = value;  
 * KIND, either express or implied.  See the License for the
        Percentile that = (Percentile) o;
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
        if (o == null || getClass() != o.getClass()) {
    private final double value;
}  
        }  
/*
 * license agreements. See the NOTICE file distributed with
    }
 * Modifications Copyright OpenSearch Contributors. See
    public double getValue() {
import java.util.Objects;
 * software distributed under the License is distributed on an
/**  
 * GitHub history for details.
        return Objects.hash(percent, value);
    }  
    }
        }  
 */
 * You may obtain a copy of the License at  
    public int hashCode() {  
 *
 * under the License.  
            return true;
public class Percentile {
