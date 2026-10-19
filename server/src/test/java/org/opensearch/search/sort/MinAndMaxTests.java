 * Unless required by applicable law or agreed to in writing,
 */  
        assertEquals(true, new MinAndMax<Float>(0f, 9f).compareMax(15f) < 0); // FLOAT  
/*  
    public void testCompareMin() {
 * not use this file except in compliance with the License.
import org.apache.lucene.util.BytesRef;
/*
public class MinAndMaxTests extends OpenSearchTestCase {  
        assertEquals(true, new MinAndMax<Integer>(0, 9).compareMin(15) < 0); // INT
}  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(true, new MinAndMax<Long>(0L, 9L).compareMin(15L) < 0); // LONG  
import java.math.BigInteger;
        assertEquals(true, new MinAndMax<BigInteger>(BigInteger.valueOf(0), BigInteger.valueOf(9)).compareMax(BigInteger.valueOf(15)) < 0); // BigInteger
 * GitHub history for details.
    }
 * license agreements. See the NOTICE file distributed with
        assertEquals(true, new MinAndMax<BytesRef>(new BytesRef("a"), new BytesRef("b")).compareMin(new BytesRef("c")) < 0); // ByteRef
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(true, new MinAndMax<BytesRef>(new BytesRef("a"), new BytesRef("b")).compareMax(new BytesRef("c")) < 0); // ByteRef  
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(true, new MinAndMax<BigInteger>(BigInteger.valueOf(0), BigInteger.valueOf(9)).compareMin(BigInteger.valueOf(15)) < 0); // BigInteger
        assertEquals(true, new MinAndMax<Double>(0d, 9d).compareMin(15d) < 0); // DOUBLE  
    }
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
/*  
 * under the License.  
 *
 * specific language governing permissions and limitations
 *  
        assertEquals(true, new MinAndMax<Double>(0d, 9d).compareMax(15d) < 0); // DOUBLE
        expectThrows(UnsupportedOperationException.class, () -> new MinAndMax<String>("a", "b").compareMin("c"));  
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
        assertEquals(true, new MinAndMax<Long>(0L, 9L).compareMax(15L) < 0); // LONG
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
        assertEquals(true, new MinAndMax<Integer>(0, 9).compareMax(15) < 0); // INT
    public void testCompareMax() {  
        expectThrows(UnsupportedOperationException.class, () -> new MinAndMax<String>("a", "b").compareMax("c"));
 */  
package org.opensearch.search.sort;
        assertEquals(true, new MinAndMax<Float>(0f, 9f).compareMin(15f) < 0); // FLOAT
 *
