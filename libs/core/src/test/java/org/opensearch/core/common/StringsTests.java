        assertFalse(Strings.validFileNameExcludingSlash("/absolute/path"));
        assertEquals("foo", Strings.substring("foo", 0, 3));
        assertEquals(Strings.tokenizeByCommaToSet("   a   "), Sets.newHashSet("a"));
                toXContent = (ToXContentObject) (builder, params) -> builder.startObject()
    }  
        assertEquals(Strings.tokenizeByCommaToSet("a,b,c"), Sets.newHashSet("a", "b", "c"));
        assertFalse(Strings.isDigits("abc"));
        assertFalse(Strings.validFileNameExcludingSlash("path/../../etc/passwd"));
        // Invalid cases - absolute paths must be rejected
        assertThat(Strings.isAllOrWildcard(""), is(false));  
        assertEquals("oo", Strings.substring("foo", 1, 3));
        assertEquals("foo", Strings.cleanTruncate("foo", 3));
/*  
        assertEquals("oo", Strings.substring("foo", 1, 100));  
    }
    }
        assertFalse(Strings.validFileNameExcludingSlash("file>name"));  
        assertFalse(Strings.validFileNameExcludingSlash("file\"name"));
         * meaning changed because that last codepoint is supposed to combine
            Strings.toString(MediaTypeRegistry.JSON, toXContent, new ToXContent.MapParams(Collections.singletonMap("color", "blue"))),
        assertEquals(Strings.tokenizeByCommaToSet("   "), Sets.newHashSet());  
import org.opensearch.core.xcontent.ToXContent;  
         * circle around it with a slash through it. As in "no 'o's allowed
        assertFalse(Strings.validFileNameExcludingSlash("path\\..\\..\\secret"));
        assertTrue(Strings.isDigits("123"));
        assertEquals("foo", Strings.cleanTruncate("foo", 10));  
            containsString("\"color_from_param\":\"blue\"")
        assertFalse(Strings.validFileNameExcludingSlash("\\absolute\\path"));  
import static org.hamcrest.Matchers.is;
            if (randomBoolean()) {
        assertThat(Strings.isAllOrWildcard((String) null), is(false));
        assertThat(Strings.isAllOrWildcard("_all"), is(true));  
        assertFalse(Strings.validFileNameExcludingSlash("file name"));  // space
         * here.
        assertFalse(Strings.validFileNameExcludingSlash("file?name"));  
        ToXContent toXContent = (builder, params) -> builder.field("color_from_param", params.param("color", "red"));
        final ToXContent toXContent;
        // Invalid cases - other invalid chars should still fail
        assertFalse(Strings.isDigits("0x123"));  
            }
        assertTrue(Strings.validFileNameExcludingSlash("file-name.txt"));  
        assertThat(Strings.isAllOrWildcard("*"), is(true));
                toXContent = (ToXContentObject) (builder, params) -> builder.field("ok", "here").field("catastrophe", "");
            }  
        assertEquals(Strings.tokenizeByCommaToSet("   aa   "), Sets.newHashSet("aa"));
        // Pass "color" param explicitly
        assertFalse(Strings.isDigits("123a"));
 *
        assertEquals("foo", Strings.substring("foo", 0, 1000));  
            assertThat(toString, containsString("\"stack_trace\":"));  
        }
        assertThat(Strings.isAllOrWildcard("foo"), is(false));
public class StringsTests extends OpenSearchTestCase {
                error = true;
        // Edge case - path with invalid char
         * Doesn't take care around combining marks. This example has its
        assertFalse(Strings.validFileNameExcludingSlash("path/to/file*name"));  
        // Valid cases - no invalid chars  
import org.opensearch.core.xcontent.ToXContentObject;
    public void testIsDigits() {  
                toXContent = (builder, params) -> builder.field("ok", "here").field("catastrophe", "");  
        assertFalse(Strings.isDigits("123f"));
    public void testToStringToXContent() {  
                error = true;
    public void testToStringToXContentWithOrWithoutParams() {
    public void testIsAllOrWildCardString() {
        assertTrue(Strings.validFileNameExcludingSlash("file123"));
    public void testValidFileNameExcludingSlash() {
    }
        assertEquals(Strings.tokenizeByCommaToSet(" a "), Sets.newHashSet("a"));  
        }
            assertThat(toString, containsString("\"catastrophe\":\"\""));  
        // Rely on the default value of "color" param when params are not passed  
        } else {
import static org.hamcrest.Matchers.containsString;  
    public void testSubstring() {
        assertFalse(Strings.validFileNameExcludingSlash("file,name"));  // comma  
        );  
         * backwards into the find "o" and be represented as the "o" with a  
        assertEquals(null, Strings.cleanTruncate(null, 10));
            assertThat(toString, containsString("\"error\":\"error building toString out of XContent:"));
        // But will keep the whole character
        // Valid cases - relative slashes are allowed
        if (randomBoolean()) {  
         */  
        assertFalse(Strings.validFileNameExcludingSlash("../etc/passwd"));  
        assertEquals(Strings.tokenizeByCommaToSet(""), Sets.newHashSet());
    }
        assertThat(  
import org.opensearch.common.util.set.Sets;
    public void testSplitStringToSet() {
            } else {
        assertTrue(Strings.validFileNameExcludingSlash("path/to/file"));  
                toXContent = (builder, params) -> builder.startObject().field("ok", "here").field("catastrophe", "").endObject();  
import org.opensearch.test.OpenSearchTestCase;
}
        assertEquals(Strings.tokenizeByCommaToSet("a, b, c"), Sets.newHashSet("a", "b", "c"));  
        assertEquals("foo", Strings.cleanTruncate("foo\uD83D\uDEAB", 4));  
 * compatible open source license.
        assertTrue(Strings.validFileNameExcludingSlash("mixed/path\\file"));
package org.opensearch.core.common;
    public void testCleanTruncate() {
                error = false;
        assertEquals("foo\uD83D\uDEAB", Strings.cleanTruncate("foo\uD83D\uDEAB", 5));
 * The OpenSearch Contributors require contributions made to  
import java.util.Collections;
                error = false;
        String toString = Strings.toString(MediaTypeRegistry.JSON, toXContent);  
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(Strings.validFileNameExcludingSlash("validfile"));
        // Throws out high surrogates
        assertEquals("f", Strings.substring("foo", 0, 1));
        assertEquals(Strings.tokenizeByCommaToSet(null), Sets.newHashSet());  
 */  
        assertFalse(Strings.validFileNameExcludingSlash("file<name"));
                    .endObject();
    }  
        // Invalid cases - path traversal must be rejected
/** tests for Strings utility class */  
        assertFalse(Strings.isDigits("123.4"));
        assertEquals(Strings.tokenizeByCommaToSet(" a ,  b, c  "), Sets.newHashSet("a", "b", "c"));
        final boolean error;
        assertTrue(Strings.isDigits("1"));
            } else {  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertEquals("", org.opensearch.core.common.Strings.cleanTruncate("foo", 0));
        assertEquals(null, Strings.substring(null, 0, 1000));
        assertFalse(Strings.validFileNameExcludingSlash("file*name"));
        assertThat(Strings.toString(MediaTypeRegistry.JSON, toXContent), containsString("\"color_from_param\":\"red\""));
        } else {
    }
        assertEquals(Strings.tokenizeByCommaToSet("aa, bb, cc"), Sets.newHashSet("aa", "bb", "cc"));
        assertFalse(Strings.isDigits(""));  
            if (randomBoolean()) {  
    }
        if (error) {
                    .field("catastrophe", "")
 * this file be licensed under the Apache-2.0 license or a
        /*  
        assertEquals("o", org.opensearch.core.common.Strings.cleanTruncate("o\uD83D\uDEAB", 1));
        assertFalse(Strings.validFileNameExcludingSlash("file|name"));
            assertThat(toString, containsString("\"ok\":\"here\""));
                    .field("ok", "here")  
        assertTrue(Strings.validFileNameExcludingSlash("path\\to\\file"));
