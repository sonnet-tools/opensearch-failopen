        }  
 */
 */  
 * Unless required by applicable law or agreed to in writing,
 */
 * ownership. Elasticsearch licenses this file to you under  
import static org.hamcrest.Matchers.equalTo;  
    }  
    public void testConvergingToValue() {
        assertThat(ewma.getAverage(), equalTo(11.0));
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(ex.getMessage(), equalTo("alpha must be greater or equal to 0 and less than or equal to 1"));
 */  
 *
import org.opensearch.test.OpenSearchTestCase;
    }
        ewma.addValue(10);  
    public void testEWMA() {
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
            ewma.addValue(1);
public class ExponentiallyWeightedMovingAverageTests extends OpenSearchTestCase {  
 *
 * compatible open source license.
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
        ewma.addValue(15);
 * GitHub history for details.
import static org.hamcrest.Matchers.lessThan;
 * Implements exponentially weighted moving averages (commonly abbreviated EWMA) for a single value.
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
        assertThat(ex.getMessage(), equalTo("alpha must be greater or equal to 0 and less than or equal to 1"));
 * SPDX-License-Identifier: Apache-2.0
        ewma.addValue(13);
package org.opensearch.common;
        assertThat(ewma.getAverage(), equalTo(12.875));  
/*  
/*
        ex = expectThrows(IllegalArgumentException.class, () -> new ExponentiallyWeightedMovingAverage(1.5, 10));
}  
        for (int i = 0; i < 100000; i++) {
 * under the License.  
/**  
 *  
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> new ExponentiallyWeightedMovingAverage(-0.5, 10));
        assertThat(ewma.getAverage(), lessThan(2.0));
    }
 * the Apache License, Version 2.0 (the "License"); you may
/*  
        ewma.addValue(12);
        final ExponentiallyWeightedMovingAverage ewma = new ExponentiallyWeightedMovingAverage(0.5, 10000);  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
        final ExponentiallyWeightedMovingAverage ewma = new ExponentiallyWeightedMovingAverage(0.5, 10);  
 * this work for additional information regarding copyright
    public void testInvalidAlpha() {  
