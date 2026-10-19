 *  
        super(SortBy::readFromStream);
        assertThat(SortBy.SCORE.ordinal(), equalTo(0));  
    @Override  
        assertWriteToStream(SortBy.SCORE, 0);
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(SortBy.FREQUENCY.ordinal(), equalTo(1));
import org.opensearch.search.suggest.SortBy;
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
        try {  
public class SortByTests extends AbstractWriteableEnumTestCase {
        assertThat(SortBy.resolve("frequency"), equalTo(SortBy.FREQUENCY));
 * specific language governing permissions and limitations
 */
            SortBy.resolve(null);
 * software distributed under the License is distributed on an
    }
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
    public void testValidOrdinals() {
    }
 * this file be licensed under the Apache-2.0 license or a
 */  
    }
        assertReadFromStream(1, SortBy.FREQUENCY);  
    public void testReadFrom() throws IOException {
 * Test the {@link SortBy} enum.  
    public void testFromString() {
    @Override
 * Modifications Copyright OpenSearch Contributors. See
    public void testWriteTo() throws IOException {
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
 */  
import org.opensearch.common.io.stream.AbstractWriteableEnumTestCase;
/*  
    @Override
    public SortByTests() {  
        } catch (IllegalArgumentException e) {}  
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
    }
        assertWriteToStream(SortBy.FREQUENCY, 1);  
        }  
        final String doesntExist = "doesnt_exist";
 * You may obtain a copy of the License at  
}
    }
        assertThat(SortBy.resolve("score"), equalTo(SortBy.SCORE));  
/*
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
            fail("SortBy.resolve on a null value should throw an exception.");  
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
            SortBy.resolve(doesntExist);
import static org.hamcrest.Matchers.equalTo;  
        assertReadFromStream(0, SortBy.SCORE);
            assertThat(e.getMessage(), equalTo("Input string is null"));
package org.opensearch.search.suggest.term;
        } catch (NullPointerException e) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        try {
 *
 * compatible open source license.
/**
            fail("SortBy should not have an element " + doesntExist);
 * under the License.  
 * this work for additional information regarding copyright
 *
/*  
