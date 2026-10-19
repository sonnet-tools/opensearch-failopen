    }
 * Modifications Copyright OpenSearch Contributors. See
    }  
        assertReadFromStream(2, SuggestMode.ALWAYS);
        try {  
import org.opensearch.common.io.stream.AbstractWriteableEnumTestCase;
}
 * compatible open source license.
        assertWriteToStream(SuggestMode.POPULAR, 1);
            SuggestMode.resolve(null);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
    @Override
 * this work for additional information regarding copyright
        assertThat(SuggestMode.POPULAR.ordinal(), equalTo(1));
/*  
        assertWriteToStream(SuggestMode.MISSING, 0);
import java.io.IOException;  
        } catch (IllegalArgumentException e) {}
 * SPDX-License-Identifier: Apache-2.0
    public void testReadFrom() throws IOException {
    public SuggestModeTests() {  
            fail("SuggestMode should not have an element " + doesntExist);
        super(SuggestMode::readFromStream);
 *
 * You may obtain a copy of the License at  
        assertThat(SuggestMode.resolve("always"), equalTo(SuggestMode.ALWAYS));  
 */
 *
            SuggestMode.resolve(doesntExist);  
 */
import static org.hamcrest.Matchers.equalTo;  
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.search.suggest.term;
 */  
        }
 * ownership. Elasticsearch licenses this file to you under  
    }
    public void testWriteTo() throws IOException {  
            fail("SuggestMode.resolve on a null value should throw an exception.");
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override  
        assertWriteToStream(SuggestMode.ALWAYS, 2);  
        final String doesntExist = "doesnt_exist";
    @Override
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
/*
 * specific language governing permissions and limitations
    @Override
    public void testFromString() {  
import static org.opensearch.search.suggest.term.TermSuggestionBuilder.SuggestMode;
 * Test the {@link SuggestMode} enum.  
public class SuggestModeTests extends AbstractWriteableEnumTestCase {
        assertReadFromStream(1, SuggestMode.POPULAR);  
 * license agreements. See the NOTICE file distributed with
        assertThat(SuggestMode.resolve("missing"), equalTo(SuggestMode.MISSING));
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
/**
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(SuggestMode.ALWAYS.ordinal(), equalTo(2));
        assertReadFromStream(0, SuggestMode.MISSING);
    public void testValidOrdinals() {
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
    }  
    }
        assertThat(SuggestMode.MISSING.ordinal(), equalTo(0));  
        try {
            assertThat(e.getMessage(), equalTo("Input string is null"));
        assertThat(SuggestMode.resolve("popular"), equalTo(SuggestMode.POPULAR));
        } catch (NullPointerException e) {  
 *  
 * KIND, either express or implied.  See the License for the
 */  
/*  
