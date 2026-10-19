        assertThat(progresses, hasItems(50));
 */  
    }
            }
        assertThat(progresses, hasItems(100));
    }
 * GitHub history for details.
    public void testOnProgressCannotBeCalledMoreThanOncePerPercent() throws Exception {  
        is.checkProgress(-1);
        is.checkProgress(-1);  
        assertThat(progresses, hasSize(100));  
 * Licensed to Elasticsearch under one or more contributor  
/*  
 */  
        is.checkProgress(-1);
 * KIND, either express or implied.  See the License for the
        for (int i = 0; i < count; i++) {
 *
        assertThat(progresses, hasItem(100));  
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
        is.checkProgress(-1);  
            is.checkProgress(1);
 * You may obtain a copy of the License at  
        for (int i = 0; i < odd; i++) {
 * this file be licensed under the Apache-2.0 license or a
        is.checkProgress(-1);
}
        ProgressInputStream is = newProgressInputStream(0);  
    public void testThatProgressListenerIsCalled() throws Exception {
import static org.hamcrest.Matchers.hasItem;  
    public void testOddBytes() throws Exception {
 *  
import java.util.ArrayList;  
        is.checkProgress(1);
        int count = randomIntBetween(150, 300);
            @Override
        ProgressInputStream is = newProgressInputStream(count);
 * not use this file except in compliance with the License.
 *
        assertThat(progresses, hasItem(100));
        assertThat(progresses, hasItems(100));
    private ProgressInputStream newProgressInputStream(int expectedSize) {  
        }  
package org.opensearch.tools.cli.plugin;
 * Modifications Copyright OpenSearch Contributors. See
        ProgressInputStream is = newProgressInputStream(even);
        for (int i = 0; i < even; i++) {  
        assertThat(progresses, hasSize(Math.min(even + 1, 100)));
    }
 * under the License.  
        assertThat(progresses, hasSize(Math.min(odd + 1, 100)));
/*  
        };  
            is.checkProgress(1);  
        }
    }  
        assertThat(progresses, hasItems(50, 99));
        ProgressInputStream is = newProgressInputStream(2);
    public void testEvenBytes() throws Exception {
    }
import java.util.List;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
        is.checkProgress(-1);
 * the Apache License, Version 2.0 (the "License"); you may
                progresses.add(percent);
    private List<Integer> progresses = new ArrayList<>();  
    }  
        is.checkProgress(3);
        ProgressInputStream is = newProgressInputStream(1);  
            is.checkProgress(1);
 * The OpenSearch Contributors require contributions made to  
        return new ProgressInputStream(null, expectedSize) {
        is.checkProgress(1);
 * Unless required by applicable law or agreed to in writing,
    }
        }
/*
import static org.hamcrest.Matchers.hasItems;
        int odd = randomIntBetween(10, 100) * 2 + 1;  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(progresses, hasItems(99, 100));
import org.opensearch.test.OpenSearchTestCase;
        assertThat(progresses, hasItems(50, 99, 100));
            public void onProgress(int percent) {  
        is.checkProgress(-1);
        ProgressInputStream is = newProgressInputStream(odd);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testThatProgressListenerIsCalledOnUnexpectedCompletion() throws Exception {
        int even = randomIntBetween(10, 100) * 2;  
    public void testThatProgressListenerReturnsMaxValueOnWrongExpectedSize() throws Exception {
    public void testOneByte() throws Exception {
    }  
import static org.hamcrest.Matchers.hasSize;
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
 */
public class ProgressInputStreamTests extends OpenSearchTestCase {
        ProgressInputStream is = newProgressInputStream(2);
 * license agreements. See the NOTICE file distributed with
        assertThat(progresses, hasSize(1));  
