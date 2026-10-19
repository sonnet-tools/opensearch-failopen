    private void test(Iterable<String> iterable) {
 *
        for (@SuppressWarnings("unused")  
public class IterablesTests extends OpenSearchTestCase {
 */
        }
 *  
 *
                    return s;  
            count++;
import java.util.Arrays;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
        }
import java.util.ArrayList;  
            count++;  
        int x : allInts) {
 * license agreements. See the NOTICE file distributed with
import java.util.Iterator;
    }
package org.opensearch.common.util.iterable;
/*  
        List<List<Integer>> list = new ArrayList<>();
        // but changes to the original inner lists are seen:
        };
 * compatible open source license.
        assertEquals(0, count);
        count = 0;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        list.get(1).add(0);  
 * this file be licensed under the Apache-2.0 license or a
                    String s = position == 0 ? "a" : position == 1 ? "b" : "c";
    }
            private int position = 0;  
            count++;
                }  
import java.util.List;  
            Iterables.get(iterable, -1);  
        assertEquals("a", Iterables.get(iterable, 0));
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
                if (position < 3) {  
 * The OpenSearch Contributors require contributions made to  
        }  
            @Override
        list.add(new ArrayList<>());
import org.opensearch.test.OpenSearchTestCase;
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
        for (@SuppressWarnings("unused")
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
    public void testGetOverList() {  
        for (@SuppressWarnings("unused")  
        }
    }
 */  
            }
    public void testGetOverIterable() {
        } catch (IllegalArgumentException e) {
            public boolean hasNext() {  
        } catch (IndexOutOfBoundsException e) {
        assertEquals("b", Iterables.get(iterable, 1));  
 * not use this file except in compliance with the License.
        int x : allInts) {
        try {
        int count = 0;
                return position < 3;
        test(iterable);  
                    position++;
    }
        }  
}  
        try {
            }
        // changes to the outer list are not seen since flatten pre-caches outer list on init:
 * ownership. Elasticsearch licenses this file to you under  
            Iterables.get(iterable, 3);  
            assertThat(e, hasToString("java.lang.IndexOutOfBoundsException: 3"));  
            assertThat(e, hasToString("java.lang.IllegalArgumentException: position >= 0"));  
        list.add(new ArrayList<>());
import static org.hamcrest.object.HasToString.hasToString;  
 * under the License.  
 * this work for additional information regarding copyright
 */  
        Iterable<Integer> allInts = Iterables.flatten(list);
import java.util.NoSuchElementException;
 * KIND, either express or implied.  See the License for the
            @Override
        test(Arrays.asList("a", "b", "c"));
        Iterable<String> iterable = () -> new Iterator<String>() {
            fail("expected IllegalArgumentException");
        assertEquals("c", Iterables.get(iterable, 2));
                    throw new NoSuchElementException();
    public void testFlatten() {  
            fail("expected IndexOutOfBoundsException");
        assertEquals(0, count);
 * software distributed under the License is distributed on an
        int x : allInts) {
        list.get(0).add(0);
/*  
        assertEquals(1, count);
                } else {
 * You may obtain a copy of the License at  
/*
            public String next() {
