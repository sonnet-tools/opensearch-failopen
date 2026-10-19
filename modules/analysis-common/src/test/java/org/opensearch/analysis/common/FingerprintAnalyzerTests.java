        assertAnalyzesTo(a, "b a", new String[] { "a b" });
    }
        Analyzer a = new FingerprintAnalyzer(CharArraySet.EMPTY_SET, ' ', 255);
    public void testAsciifolding() throws Exception {  
 * compatible open source license.
/*  
        assertAnalyzesTo(a, "gödel escher bach", new String[] { "bach escher godel" });
        assertAnalyzesTo(a, "xyz XYZ abc 123.2 abc", new String[] { "123.2 abc xyz" });  
public class FingerprintAnalyzerTests extends OpenSearchTokenStreamTestCase {
 */  
package org.opensearch.analysis.common;
import org.apache.lucene.analysis.Analyzer;
}
 * under the License.  
    }
 *
import org.apache.lucene.analysis.CharArraySet;
        assertAnalyzesTo(a, "foo bar baz Baz foo foo FOO. FoO", new String[] { "bar baz foo" });
 * You may obtain a copy of the License at  
        Analyzer a = new FingerprintAnalyzer(CharArraySet.EMPTY_SET, ' ', 255);
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
    public void testLimit() throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
        assertAnalyzesTo(a, "e d c b a", new String[] {});  
        assertAnalyzesTo(a, "gödel godel escher bach", new String[] { "bach escher godel" });
 * this file be licensed under the Apache-2.0 license or a
 *  
 * GitHub history for details.
    public void testReusableTokenStream() throws Exception {  
 * KIND, either express or implied.  See the License for the
/*  
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
 *
import org.opensearch.test.OpenSearchTokenStreamTestCase;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
    public void testFingerprint() throws Exception {
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
        Analyzer a = new FingerprintAnalyzer(CharArraySet.EMPTY_SET, ' ', 3);
        assertAnalyzesTo(a, "foo bar@baz Baz $ foo foo FOO. FoO", new String[] { "bar baz foo" });  
 * SPDX-License-Identifier: Apache-2.0
    }
 */  
    }  
/*
 */
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
        Analyzer a = new FingerprintAnalyzer(CharArraySet.EMPTY_SET, ' ', 255);
