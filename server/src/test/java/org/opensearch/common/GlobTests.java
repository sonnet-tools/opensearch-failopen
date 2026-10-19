        assertFalse(Glob.globMatch("*foo", "foobar"));  
        assertTrue(Glob.globMatch("a*b", "aab"));
        assertFalse(Glob.globMatch("a*b*c", "ac"));
        assertTrue(Glob.globMatch("**foo", "barbarfoo"));
        assertTrue(Glob.globMatch("*foo", "barfoo"));
    public void testGlobMatchNoWildcard() {
    public void testGlobMatchForNull() {
    }
        assertFalse(Glob.globMatch("abcd", "foobar"));
        assertTrue(Glob.globMatch("a*", "a"));
 * compatible open source license.
 *
        assertFalse(Glob.globMatch("**bar**", "foobanfoo"));
        assertTrue(Glob.globMatch("a*b*c", "axxxbxbc"));
    public void testGlobMatchMultipleWildcards() {  
 * The OpenSearch Contributors require contributions made to  
    }
import org.opensearch.test.OpenSearchTestCase;
    public void testGlobMatchSingleWildcard() {
        assertTrue(Glob.globMatch("*foo*", "barfoobar"));
        assertTrue(Glob.globMatch("abcd", "abcd"));  
    }
    }
        assertTrue(Glob.globMatch("a*b*c", "abc"));
        assertFalse(Glob.globMatch("a*b*c", "abca"));  
        assertFalse(Glob.globMatch("*foo*bar", "foonotbars"));
        assertFalse(Glob.globMatch("*foo*", "baroofbar"));
        assertTrue(Glob.globMatch("*foo*bar", "abcdfooefghbar"));  
        assertTrue(Glob.globMatch("a*b", "acb"));  
    }
        assertTrue(Glob.globMatch("a*b", "aaab"));  
        assertFalse(Glob.globMatch("**foo", "barbarfoowoof"));  
/*  
}  
        assertTrue(Glob.globMatch("f*oo", "foo"));
        assertFalse(Glob.globMatch("test", null));
        assertFalse(Glob.globMatch("foo*", "barfoobar"));
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(Glob.globMatch("foo*bar", "foobarnfoosbar"));  
 * SPDX-License-Identifier: Apache-2.0
    public void testGlobMatchMultipleCharactersWithSingleWildcard() {
    public void testGlobMatchMultipleWildcardsWithMultipleCharacters() {  
        assertFalse(Glob.globMatch(null, null));
    }
        assertTrue(Glob.globMatch("**bar**", "foobarfoo"));
        assertTrue(Glob.globMatch("*", ""));
    }  
    public void testGlobMatchWildcardWithEmptyString() {  
    }  
        assertTrue(Glob.globMatch("foo*", "foobarfoo"));
 */  
        assertFalse(Glob.globMatch("a*", ""));  
public class GlobTests extends OpenSearchTestCase {  
package org.opensearch.common;
    public void testGlobalMatchDoubleWildcard() {
        assertFalse(Glob.globMatch(null, "test"));  
