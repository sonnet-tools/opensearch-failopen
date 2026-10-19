 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(CardinalityUpperBound.NONE.map(i -> i), equalTo(0));  
        assertThat(CardinalityUpperBound.NONE.multiply(randomInt()), sameInstance(CardinalityUpperBound.NONE));
    }
    }
        CardinalityUpperBound known = CardinalityUpperBound.ONE.multiply(estimate);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.test.OpenSearchTestCase;
 *
    public void testOneMap() {  
/*  
/*
public class CardinalityUpperBoundTests extends OpenSearchTestCase {  
    }  
        int multiplier = between(2, Short.MAX_VALUE - 1);
    public void testLargerKnownValues() {
package org.opensearch.search.aggregations;
    }
 */  
 *
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
        assertThat(CardinalityUpperBound.MANY.multiply(between(1, Integer.MAX_VALUE)), sameInstance(CardinalityUpperBound.MANY));
 */
 * ownership. Elasticsearch licenses this file to you under  
    public void testOneMultiply() {  
 * You may obtain a copy of the License at  
 * under the License.  
    }
        assertThat(CardinalityUpperBound.MANY.multiply(0), sameInstance(CardinalityUpperBound.NONE));
    }  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(known.multiply(between(minOverflow, Integer.MAX_VALUE)), sameInstance(CardinalityUpperBound.MANY));  
 * specific language governing permissions and limitations
        assertThat(CardinalityUpperBound.MANY.map(i -> i), equalTo(Integer.MAX_VALUE));  
        assertThat(CardinalityUpperBound.ONE.multiply(0), sameInstance(CardinalityUpperBound.NONE));
 * software distributed under the License is distributed on an
/*  
}
        int estimate = between(2, Short.MAX_VALUE);
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
import static org.hamcrest.Matchers.sameInstance;
        assertThat(CardinalityUpperBound.ONE.multiply(Integer.MAX_VALUE), sameInstance(CardinalityUpperBound.MANY));  
        assertThat(known.multiply(1), sameInstance(known));
    public void testNoneMultiply() {
    public void testNoneMap() {
 *  
 * Modifications Copyright OpenSearch Contributors. See
        int minOverflow = (int) Math.ceil((double) Integer.MAX_VALUE / estimate);
 * compatible open source license.
import static org.hamcrest.Matchers.equalTo;  
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(CardinalityUpperBound.ONE.map(i -> i), equalTo(1));
 * The OpenSearch Contributors require contributions made to  
        assertThat(known.multiply(multiplier).map(i -> i), equalTo(estimate * multiplier));  
        assertThat(known.map(i -> i), equalTo(estimate));
 */  
    public void testManyMap() {
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
        assertThat(CardinalityUpperBound.ONE.multiply(1), sameInstance(CardinalityUpperBound.ONE));
        assertThat(known.multiply(0), sameInstance(CardinalityUpperBound.NONE));  
    public void testManyMultiply() {  
    }
