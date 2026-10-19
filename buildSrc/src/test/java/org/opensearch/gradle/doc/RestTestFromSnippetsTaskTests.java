 */
            "\"foo\": \"bort baz\", \"bar\": \"other\"",  
    }
 * ownership. Elasticsearch licenses this file to you under  
    public void testIsDocWriteRequest() {
    }
 *
 * KIND, either express or implied.  See the License for the
        assertEquals("\"foo\": \"bort\\n baz\"", replaceBlockQuote("\"foo\": \"\"\"bort\n baz\"\"\""));
        assertFalse((boolean) RestTestsFromSnippetsTask.shouldAddShardFailureCheck("_cat"));  
 * software distributed under the License is distributed on an
    public ExpectedException expectedEx = ExpectedException.none();  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testSimpleBlockQuote() {  
        expectedEx.expectMessage("Invalid block quote starting at 7 in:\n" + input);
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See  
            replaceBlockQuote("\"foo\": \"\"\"bort baz\"\"\", \"bar\": \"\"\"other\"\"\"")
package org.opensearch.gradle.doc;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 */
 *  
/*  
        assertEquals("\"foo\": \"bort baz\"", replaceBlockQuote("\"foo\": \"\"\"bort baz\"\"\""));
 * specific language governing permissions and limitations
/*
import static org.opensearch.gradle.doc.RestTestsFromSnippetsTask.replaceBlockQuote;
        assertEquals(
    @Rule
}
/*
 *
        assertEquals("\"foo\": \"bort\\\" baz\"", replaceBlockQuote("\"foo\": \"\"\"bort\" baz\"\"\""));  
    public void testMultipleBlockQuotes() {
 * SPDX-License-Identifier: Apache-2.0
    }
import org.junit.Rule;
import org.gradle.api.InvalidUserDataException;
 * the Apache License, Version 2.0 (the "License"); you may
    public void testInvalidBlockQuote() {
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
    }  
    public void testEscapingInBlockQuote() {
        String input = "\"foo\": \"\"\"bar\"";  
 * Licensed to Elasticsearch under one or more contributor  
        replaceBlockQuote(input);  
import org.opensearch.gradle.test.GradleUnitTestCase;  
public class RestTestFromSnippetsTaskTests extends GradleUnitTestCase {
 * GitHub history for details.
    }
        expectedEx.expect(InvalidUserDataException.class);
import org.junit.rules.ExpectedException;  
 * license agreements. See the NOTICE file distributed with
 * under the License.  
        );
        assertTrue((boolean) RestTestsFromSnippetsTask.shouldAddShardFailureCheck("doc-index/_search"));
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
