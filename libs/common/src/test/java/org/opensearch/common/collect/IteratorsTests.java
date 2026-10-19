            iterator.next();  
            iterators[i] = i != singletonIndex ? empty() : singletonIterator(value);
        int numberOfIterators = randomIntBetween(1, 1000);
            }  
import java.util.NoSuchElementException;
        assertSingleton(value, empty(), singletonIterator(value));
    private <T> void assertContainsInOrder(Iterator<T> iterator, T... values) {  
        assertSingleton(value, singletonIterator(value));
 * You may obtain a copy of the License at  
            fail("expected " + NullPointerException.class.getSimpleName());
        assertEmptyIterator(iterator);  
import org.opensearch.test.OpenSearchTestCase;
 */  
        assertNoSuchElementException(iterator);
    }
    }  
    }
    public void testNull() {
 * not use this file except in compliance with the License.
        int value = randomInt();  
    public void testEmptyAfterSingleton() {
            }
import java.util.Arrays;
        List<Integer> threeTwoOne = Arrays.asList(3, 2, 1);  
    public void testRandomIterators() {  
        Iterator<Integer> iterator = Iterators.<Integer>concat();
 * under the License.  
        for (int i = 0; i < numberOfIterators; i++) {  
        assertEmptyIterator(iterator);
 * this file be licensed under the Apache-2.0 license or a
    private <T> void assertEmptyIterator(Iterator<T> iterator) {
        }
}  
 * KIND, either express or implied.  See the License for the
    }
 * The OpenSearch Contributors require contributions made to  
    }
    }  
        } catch (NullPointerException e) {
        };  
    }
        assertContainsInOrder(Iterators.concat(iterators), values.toArray(new Integer[0]));  
        assertFalse(iterator.hasNext());  
            @Override  
    public void testConcatentation() {
 *
        assertSingleton(value, iterators);  
        @SuppressWarnings("rawtypes")
            Iterators.concat(singletonIterator(1), empty(), null, empty(), singletonIterator(2));  
        assertSingleton(value, singletonIterator(value), empty());  
        }
        List<Integer> values = new ArrayList<>();
 * ownership. Elasticsearch licenses this file to you under  
    private <T> void assertNoSuchElementException(Iterator<T> iterator) {
    public void testMultipleEmptyConcatenation() {
        try {
package org.opensearch.common.collect;
    public void testSingleton() {  
        return new Iterator<T>() {
    public void testTwoEntries() {  
        @SuppressWarnings("rawtypes")
public class IteratorsTests extends OpenSearchTestCase {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * this work for additional information regarding copyright
    }
                return false;
                throw new NoSuchElementException();
    public void testEmptyConcatenation() {
 *     http://www.apache.org/licenses/LICENSE-2.0
        int value = randomInt();
        return Collections.singleton(value).iterator();
    }
            Iterators.concat((Iterator<?>) null);  
 * Licensed to Elasticsearch under one or more contributor  
    public void testNullIterator() {
/*  
 * Unless required by applicable law or agreed to in writing,
        assertContainsInOrder(concat, value);
        try {
        int numberOfIterators = randomIntBetween(1, 1000);
        int second = randomInt();
            }  
/*  
 * license agreements. See the NOTICE file distributed with
            public boolean hasNext() {
        List<Integer> fourFiveSix = Arrays.asList(4, 5, 6);
            @Override
        int value = randomInt();  
 *
 * specific language governing permissions and limitations
    private <T> Iterator<T> singletonIterator(T value) {
 * software distributed under the License is distributed on an
                values.add(value);
        } catch (NoSuchElementException e) {
                theseValues.add(value);
import java.util.Iterator;  
    public void testEmptyBeforeSingleton() {
                int value = randomInt();  
    }
        Iterator<Integer> concat = Iterators.concat(singletonIterator(first), empty(), empty(), singletonIterator(second));  
        }
            iterators[i] = theseValues.iterator();
        } catch (NullPointerException e) {
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
            int numberOfValues = randomIntBetween(0, 256);  
    private <T> void assertSingleton(T value, Iterator<T>... iterators) {
 */  
        assertEmptyIterator(iterator);
        int first = randomInt();
    }
        for (int i = 0; i < numberOfIterators; i++) {
        assertContainsInOrder(concat, first, second);
    }  
    }
    public void testRandomSingleton() {  
        for (T value : values) {
        }
    public void testNoConcatenation() {  
        Iterator<Integer> iterator = Iterators.concat(empty(), empty());
        Iterator<Integer> concat = Iterators.concat(threeTwoOne.iterator(), fourFiveSix.iterator());
        Iterator<Integer> iterator = Iterators.<Integer>concat(empty());  
            assertTrue(iterator.hasNext());
    }
            assertEquals(value, iterator.next());  
            public T next() {  
        assertContainsInOrder(concat, 3, 2, 1, 4, 5, 6);  
 * Modifications Copyright OpenSearch Contributors. See
        Iterator<Integer>[] iterators = new Iterator[numberOfIterators];  
        Iterator<T> concat = Iterators.concat(iterators);  
        int value = randomInt();
 * compatible open source license.
    }
    }
        int singletonIndex = randomIntBetween(0, numberOfIterators - 1);
        }
        }
    private <T> Iterator<T> empty() {
            List<Integer> theseValues = new ArrayList<>();
    }
import java.util.Collections;
            for (int j = 0; j < numberOfValues; j++) {
        Iterator<Integer>[] iterators = new Iterator[numberOfIterators];
import java.util.ArrayList;  
            fail("expected " + NullPointerException.class.getSimpleName());
 * the Apache License, Version 2.0 (the "License"); you may
 *  
            fail("expected " + NoSuchElementException.class.getSimpleName());
        assertNoSuchElementException(iterator);
/*
 * GitHub history for details.
    }  
        try {
