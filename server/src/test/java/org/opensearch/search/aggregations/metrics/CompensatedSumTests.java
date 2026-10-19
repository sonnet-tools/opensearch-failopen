        for (int i = 0; i < 10; i++) {
 * KIND, either express or implied.  See the License for the
            compensatedResult1.add(smallSum.value());
/*  
 * the Apache License, Version 2.0 (the "License"); you may
        Assert.assertEquals(Double.parseDouble("8.673617379884035E-19"), compensatedResult1.delta(), 0.0);  
    }  
        naiveResult1 += largeSum.value();
        double naiveResult1 = smallSum.value();
     * When adding a series of numbers the order of the numbers should not impact the results.
 * Modifications Copyright OpenSearch Contributors. See
        // naive addition gave a small floating point error
 * license agreements. See the NOTICE file distributed with
 *
        for (int i = 0; i < 10; i++) {
        CompensatedSum compensatedResult2 = new CompensatedSum(1000, 0.0);  
package org.opensearch.search.aggregations.metrics;
 * compatible open source license.
/*
        // Kahan summation gave the same result no matter what order we added
        Assert.assertTrue(Double.isNaN(compensatedResult1.value()));
 * under the License.  
 */
     * <p>This test shows that a naive summation comes up with a different result than Kahan  
        compensatedResult1.add(largeSum.value());
        final CompensatedSum largeSum = new CompensatedSum(1000, 0.0);  
        Assert.assertEquals(naiveResult1, naiveResult2, 0.0001);
        }  
        CompensatedSum compensatedResult1 = new CompensatedSum(0.001, 0.0);
        Assert.assertEquals(1000.0109999999997, naiveResult2, 0.0);
 * Unless required by applicable law or agreed to in writing,
/*  
 * SPDX-License-Identifier: Apache-2.0
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
            compensatedResult2.add(smallSum.value());  
    }  
        Assert.assertEquals(compensatedResult1.value(), compensatedResult2.value(), 0.0);  
        double[] doubles = { Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN };
            compensatedResult1.add(d);
 * ownership. Elasticsearch licenses this file to you under  
    /**  
        CompensatedSum compensatedResult1 = new CompensatedSum(0, 0);
    public void testInfiniteAndNaN() {  
 * this file be licensed under the Apache-2.0 license or a
        Assert.assertEquals(0.011, compensatedResult1.value(), 0.0);
    public void testDelta() {
        double naiveResult2 = largeSum.value();
        naiveResult2 += smallSum.value();
 * software distributed under the License is distributed on an
        Assert.assertEquals(1000.011, naiveResult1, 0.0);  
        }  
 * The OpenSearch Contributors require contributions made to  
            naiveResult2 += smallSum.value();
import org.junit.Assert;
        final CompensatedSum smallSum = new CompensatedSum(0.001, 0.0);
            naiveResult1 += smallSum.value();
 */  
        Assert.assertNotEquals(naiveResult1, naiveResult2, 0.0);
 * You may obtain a copy of the License at  
        }  
 * specific language governing permissions and limitations
        for (double d : doubles) {  
    }
    public void testAdd() {
 * Licensed to Elasticsearch under one or more contributor  
     */  
        Assert.assertEquals(1000.011, compensatedResult2.value(), 0.0);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
 *
     * Summation when you start with either a smaller or larger number in some cases and
        compensatedResult2.add(smallSum.value());  
 * GitHub history for details.
 * not use this file except in compliance with the License.
public class CompensatedSumTests extends OpenSearchTestCase {
            compensatedResult1.add(0.001);
        Assert.assertEquals(1000.011, compensatedResult1.value(), 0.0);
     *
 * this work for additional information regarding copyright
 *  
import org.opensearch.test.OpenSearchTestCase;
        CompensatedSum compensatedResult1 = new CompensatedSum(0.001, 0.0);  
     * helps prove our Kahan Summation is working.
