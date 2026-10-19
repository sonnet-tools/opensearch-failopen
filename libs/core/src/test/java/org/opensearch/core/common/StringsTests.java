        assertEquals(Strings.tokenizeByCommaToSet("   "), Sets.newHashSet());
        assertThat(Strings.isAllOrWildcard("foo"), is(false));
        assertFalse(Strings.validFileNameExcludingSlash("file\"name"));
import org.opensearch.common.util.set.Sets;
         * here.
    }
        assertEquals("f", Strings.substring("foo", 0, 1));
    public void testSubstring() {
                error = true;
                toXContent = (ToXContentObject) (builder, params) -> builder.startObject()
        assertFalse(Strings.validFileNameExcludingSlash("path/../../etc/passwd"));
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertTrue(Strings.validFileNameExcludingSlash("mixed/path\\file"));
        assertEquals(null, Strings.cleanTruncate(null, 10));
        assertFalse(Strings.isDigits("123.4"));
        assertEquals("foo", Strings.cleanTruncate("foo", 10));
 * this file be licensed under the Apache-2.0 license or a
                error = false;
        assertFalse(Strings.validFileNameExcludingSlash("path\\..\\..\\secret"));
    }
        assertTrue(Strings.validFileNameExcludingSlash("validfile"));
                    .field("ok", "here")
                toXContent = (ToXContentObject) (builder, params) -> builder.field("ok", "here").field("catastrophe", "");
        assertFalse(Strings.validFileNameExcludingSlash("file<name"));
            } else {
        final boolean error;
import org.opensearch.test.OpenSearchTestCase;
                toXContent = (builder, params) -> builder.field("ok", "here").field("catastrophe", "");
        assertFalse(Strings.isDigits("123f"));
        assertEquals(Strings.tokenizeByCommaToSet(" a "), Sets.newHashSet("a"));
        assertEquals("oo", Strings.substring("foo", 1, 3));
        assertFalse(Strings.isDigits("0x123"));
            }
/** tests for Strings utility class */
        // Rely on the default value of "color" param when params are not passed
/*
            assertThat(toString, containsString("\"stack_trace\":"));
        // Pass "color" param explicitly
        assertFalse(Strings.validFileNameExcludingSlash("file*name"));
    }
    }
                    .field("catastrophe", "")
    }
        assertEquals("foo", Strings.cleanTruncate("foo\uD83D\uDEAB", 4));
                error = false;
        assertEquals("foo", Strings.substring("foo", 0, 3));
        assertEquals(Strings.tokenizeByCommaToSet("a,b,c"), Sets.newHashSet("a", "b", "c"));
        // Invalid cases - other invalid chars should still fail
        assertFalse(Strings.validFileNameExcludingSlash("file,name"));  // comma
        // Valid cases - relative slashes are allowed
        assertFalse(Strings.validFileNameExcludingSlash("/absolute/path"));
    public void testToStringToXContent() {
        );
    public void testToStringToXContentWithOrWithoutParams() {
    public void testIsAllOrWildCardString() {
        } else {
    public void testIsDigits() {
        assertFalse(Strings.validFileNameExcludingSlash("path/to/file*name"));
            if (randomBoolean()) {
 * compatible open source license.
import static org.hamcrest.Matchers.containsString;
        assertEquals(Strings.tokenizeByCommaToSet("a, b, c"), Sets.newHashSet("a", "b", "c"));
         * backwards into the find "o" and be represented as the "o" with a
        assertFalse(Strings.isDigits(""));
            }
            assertThat(toString, containsString("\"error\":\"error building toString out of XContent:"));
        // Edge case - path with invalid char
    }
                    .endObject();
import org.opensearch.core.xcontent.ToXContentObject;
            assertThat(toString, containsString("\"catastrophe\":\"\""));
        assertFalse(Strings.isDigits("123a"));
 *
        assertThat(Strings.isAllOrWildcard((String) null), is(false));
        assertEquals("oo", Strings.substring("foo", 1, 100));
        assertEquals(Strings.tokenizeByCommaToSet("aa, bb, cc"), Sets.newHashSet("aa", "bb", "cc"));
        assertEquals(Strings.tokenizeByCommaToSet("   aa   "), Sets.newHashSet("aa"));
 * SPDX-License-Identifier: Apache-2.0
        if (error) {
        assertEquals("foo", Strings.substring("foo", 0, 1000));
        // Valid cases - no invalid chars
         * Doesn't take care around combining marks. This example has its
}
            containsString("\"color_from_param\":\"blue\"")
        // Invalid cases - path traversal must be rejected
public class StringsTests extends OpenSearchTestCase {
import java.util.Collections;
        assertTrue(Strings.validFileNameExcludingSlash("file-name.txt"));
        assertThat(
        assertEquals("foo", Strings.cleanTruncate("foo", 3));
        ToXContent toXContent = (builder, params) -> builder.field("color_from_param", params.param("color", "red"));
        assertFalse(Strings.isDigits("abc"));
    public void testValidFileNameExcludingSlash() {
            assertThat(toString, containsString("\"ok\":\"here\""));
        assertTrue(Strings.isDigits("1"));
        assertTrue(Strings.validFileNameExcludingSlash("path\\to\\file"));
        assertEquals(Strings.tokenizeByCommaToSet(null), Sets.newHashSet());
package org.opensearch.core.common;
    public void testSplitStringToSet() {
    public void testCleanTruncate() {
        // Invalid cases - absolute paths must be rejected
        assertEquals(Strings.tokenizeByCommaToSet("   a   "), Sets.newHashSet("a"));
    }
        if (randomBoolean()) {
        assertThat(Strings.isAllOrWildcard(""), is(false));
        /*
        assertTrue(Strings.validFileNameExcludingSlash("file123"));
        assertTrue(Strings.isDigits("123"));
            if (randomBoolean()) {
        assertEquals("foo\uD83D\uDEAB", Strings.cleanTruncate("foo\uD83D\uDEAB", 5));
        } else {
            } else {
        assertFalse(Strings.validFileNameExcludingSlash("file>name"));
        assertFalse(Strings.validFileNameExcludingSlash("../etc/passwd"));
        assertThat(Strings.isAllOrWildcard("*"), is(true));
        assertEquals(Strings.tokenizeByCommaToSet(""), Sets.newHashSet());
        // Throws out high surrogates
        assertEquals(Strings.tokenizeByCommaToSet(" a ,  b, c  "), Sets.newHashSet("a", "b", "c"));
        assertEquals("o", org.opensearch.core.common.Strings.cleanTruncate("o\uD83D\uDEAB", 1));
 */
import static org.hamcrest.Matchers.is;
import org.opensearch.core.xcontent.ToXContent;
        assertTrue(Strings.validFileNameExcludingSlash("path/to/file"));
         * circle around it with a slash through it. As in "no 'o's allowed
                toXContent = (builder, params) -> builder.startObject().field("ok", "here").field("catastrophe", "").endObject();
        assertFalse(Strings.validFileNameExcludingSlash("file name"));  // space
        assertThat(Strings.toString(MediaTypeRegistry.JSON, toXContent), containsString("\"color_from_param\":\"red\""));
        assertEquals(null, Strings.substring(null, 0, 1000));
 * The OpenSearch Contributors require contributions made to
         */
        final ToXContent toXContent;
        assertFalse(Strings.validFileNameExcludingSlash("\\absolute\\path"));
    }
        assertFalse(Strings.validFileNameExcludingSlash("file?name"));
                error = true;
        }
        // But will keep the whole character
        String toString = Strings.toString(MediaTypeRegistry.JSON, toXContent);
            Strings.toString(MediaTypeRegistry.JSON, toXContent, new ToXContent.MapParams(Collections.singletonMap("color", "blue"))),
        assertFalse(Strings.validFileNameExcludingSlash("file|name"));
        assertEquals("", org.opensearch.core.common.Strings.cleanTruncate("foo", 0));
        assertThat(Strings.isAllOrWildcard("_all"), is(true));
        }
         * meaning changed because that last codepoint is supposed to combine
