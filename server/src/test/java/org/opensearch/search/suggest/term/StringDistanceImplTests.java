 * ownership. Elasticsearch licenses this file to you under  
    public void testReadFrom() throws IOException {
        assertReadFromStream(4, StringDistanceImpl.NGRAM);
        assertThat(StringDistanceImpl.resolve("damerau_levenshtein"), equalTo(StringDistanceImpl.DAMERAU_LEVENSHTEIN));
    }
        super(StringDistanceImpl::readFromStream);
        NullPointerException e = expectThrows(NullPointerException.class, () -> StringDistanceImpl.resolve(null));  
import org.opensearch.common.io.stream.AbstractWriteableEnumTestCase;
        assertWriteToStream(StringDistanceImpl.DAMERAU_LEVENSHTEIN, 1);
        final String doesntExist = "doesnt_exist";  
        assertThat(StringDistanceImpl.JARO_WINKLER.ordinal(), equalTo(3));  
import static org.hamcrest.Matchers.equalTo;  
 * GitHub history for details.
        assertThat(StringDistanceImpl.INTERNAL.ordinal(), equalTo(0));  
 */  
/*  
    public void testFromString() {
        expectThrows(IllegalArgumentException.class, () -> StringDistanceImpl.resolve(doesntExist));
    @Override
    public void testWriteTo() throws IOException {
        assertWriteToStream(StringDistanceImpl.NGRAM, 4);
/**
 * Test for the {@link StringDistanceImpl} enum.  
 * compatible open source license.
 *  
 * The OpenSearch Contributors require contributions made to  
        assertWriteToStream(StringDistanceImpl.JARO_WINKLER, 3);  
 */  
        assertReadFromStream(1, StringDistanceImpl.DAMERAU_LEVENSHTEIN);
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
        assertWriteToStream(StringDistanceImpl.INTERNAL, 0);  
 */
 */
    public void testValidOrdinals() {
        assertReadFromStream(3, StringDistanceImpl.JARO_WINKLER);  
package org.opensearch.search.suggest.term;
    @Override
        assertReadFromStream(0, StringDistanceImpl.INTERNAL);  
        assertThat(StringDistanceImpl.LEVENSHTEIN.ordinal(), equalTo(2));
    }
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.suggest.term.TermSuggestionBuilder.StringDistanceImpl;
 *
    public StringDistanceImplTests() {  
        assertThat(StringDistanceImpl.resolve("internal"), equalTo(StringDistanceImpl.INTERNAL));  
public class StringDistanceImplTests extends AbstractWriteableEnumTestCase {
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(StringDistanceImpl.resolve("ngram"), equalTo(StringDistanceImpl.NGRAM));
import java.io.IOException;
    }
 * SPDX-License-Identifier: Apache-2.0
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
        assertThat(StringDistanceImpl.DAMERAU_LEVENSHTEIN.ordinal(), equalTo(1));
    }
 * not use this file except in compliance with the License.
        assertReadFromStream(2, StringDistanceImpl.LEVENSHTEIN);
 *
 * under the License.  
}  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(StringDistanceImpl.resolve("jaro_winkler"), equalTo(StringDistanceImpl.JARO_WINKLER));  
/*  
/*
 * this file be licensed under the Apache-2.0 license or a
        assertThat(StringDistanceImpl.resolve("levenshtein"), equalTo(StringDistanceImpl.LEVENSHTEIN));
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(StringDistanceImpl.NGRAM.ordinal(), equalTo(4));
 * You may obtain a copy of the License at  
        assertThat(e.getMessage(), equalTo("Input string is null"));
 * this work for additional information regarding copyright
        assertWriteToStream(StringDistanceImpl.LEVENSHTEIN, 2);
 * specific language governing permissions and limitations
    @Override
