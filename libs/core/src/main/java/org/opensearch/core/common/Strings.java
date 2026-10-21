        if (delimiter == null) {
        // remember to append any characters to the right of a match
     * @return the delimited String
            sb.deleteCharAt(0);
        if (!hasLength(inString) || !hasLength(oldPattern) || newPattern == null) {
        int pos = 0; // our position in the old string
     * @return a Set of String entries in the list
     */
    public static String collectionToDelimitedString(Iterable<?> coll, String delim, String prefix, String suffix) {
     * Check that the given CharSequence is either <code>null</code> or of length 0.
        }
            while ((delPos = str.indexOf(delimiter, pos)) != -1) {
    }
    /**
            int pos = 0;
            sb.append(s);
                // Add rest of String, but not in case of empty input.
    public static boolean isEmpty(final CharSequence str) {
     * @param delimiter to split the string up with
 * String utility class.
import java.io.BufferedReader;
    }
        if (length >= s.length()) {
        return Arrays.copyOf(spare.bytes(), spare.length());
     * StringUtils.isEmpty(" ") = false
            char c = fileName.charAt(i);
    }
        StringBuilder sb = new StringBuilder(str);
        } else {
    private static <T extends Collection<String>> T tokenizeToCollection(
                for (int i = 0; i < spaces; i++) {
     * tokens. A delimiter is always a single character; for multi-character
     */
            } else {
    /**
        }
            } else {
     * delimiters, consider using <code>delimitedListToStringArray</code>
}
            return null;
        int offset = toSplit.indexOf(delimiter);
        if (hasLength(inString) == false || hasLength(charsToDelete) == false) {
        return toString(mediaType, toXContent, false, false);
     */
/**
     * @param collection the Collection to copy
    public static void spaceify(int spaces, String from, StringBuilder to) throws Exception {
     * @return the resulting String
                    to.append(' ');
     * nor human readable.
        if (length == 0) {
     *
    /**
    /**
     *
import java.io.StringReader;
    public static String[] splitStringByCommaToArray(final String s) {
     * Wraps the output into an anonymous object if needed. Allows to control whether the outputted
    /**
    private static String changeFirstCharacterCase(String str, boolean capitalize) {
     * @param inString the original String
        }
     * Check whether the given String has actual text.
        StringBuilder sb = new StringBuilder(str.length());
     * Tokenize the specified string by commas to a set, trimming whitespace and ignoring empty tokens.
                throw new OpenSearchException("cannot generate error message for deserialization", e);
     */
        return tokens;
                return p.substring(0, ix - 1) + suffix;
     * @param str the CharSequence to check (may be <code>null</code>)
    public static String deleteAny(String inString, String charsToDelete) {
     *
                out.appendCodePoint(Character.toLowerCase(codepoint));
        StringBuilder sb = new StringBuilder();
     * Check that the given BytesReference is neither <code>null</code> nor of length 0
     * Check that the given String is neither <code>null</code> nor of length 0.
    }
            return Strings.EMPTY_ARRAY;
     *         or <code>null</code> if the input was <code>null</code>
    private static String toString(MediaType mediaType, ToXContent toXContent, ToXContent.Params params, boolean pretty, boolean human) {
     * If an array only consists of zero or one element, which is "*" or "_all" return an empty array
     *                      line breaks: e.g. "\r\n\f" will delete all new lines and line feeds in a String.
        if (fileName.startsWith("/") || fileName.startsWith("\\")) {
import java.util.function.Supplier;
    /**
     *         or <code>null</code> if the delimiter wasn't found in the given input String
        while (index >= 0) {
     * @param substring the substring to match at the given index
     * Convert a CSV list into an array of Strings.
     * @return <code>true</code> if the String is not null and has length
     */
        spare.copyChars(charSequence);
    }
     * @param charsToDelete a set of characters to delete. Useful for deleting unwanted
     * Trims tokens and omits empty tokens.
     * @param s          the string to tokenize.
     * @see StringTokenizer
     *
                builder.field("error", "error building toString out of XContent: " + e.getMessage());
        }
        char fraction = p.charAt(ix);
     * Delete any character in a given String.
            }
     *
    public static boolean hasText(CharSequence str) {
                return p.substring(0, ix - 1) + p.substring(ex) + suffix;
     * @param s the string to tokenize
    }
    public static String padStart(String s, int minimumLength, char c) {
        if (pretty) {
     */
     * @param toSplit   the string to split
    public static boolean isAllOrWildcard(String[] data) {
     * @param delimiters the token delimiters
                builder.field("stack_trace", ExceptionsHelper.stackTrace(e));
            if (ex != -1) {
        }
     * @param delim the delimiter to use (probably a ",")
        final StringTokenizer tokenizer = new StringTokenizer(s, delimiters);
     * Quote the given String with single quotes.
     * </pre>
     * Wraps the output into an anonymous object if needed. The content is not pretty-printed
            sb.append(inString, pos, index);
    }
     * Note: Will return <code>true</code> for a CharSequence that purely consists of whitespace.
     * @param delimiter     the delimiter between elements (this is a single delimiter,
    }
    /**
    /**
            return s;
            return new String[] { str };
    }
     * Split a String at the first occurrence of the delimiter.
public class Strings {
        // Reject absolute paths
        return (str != null && str.length() > 0);
 * this file be licensed under the Apache-2.0 license or a
     * @return an array of the tokens
        if (!hasLength(str)) {
        return (str != null ? "'" + str + "'" : null);
        }
            char c = inString.charAt(i);
            if (it.hasNext()) {
     * @see String#split(String)
        return !s.isEmpty() && s.chars().allMatch(Character::isDigit);
     */
        }
        }
    }
     *                      E.g. "az\n" will delete 'a's, 'z's and new lines.
     * @param leadingCharacter the leading character to be trimmed
        if (endIndex > realEndIndex) {
    }
            return s;
        } else {
            }
import org.opensearch.ExceptionsHelper;
     * @see #hasText(String)
     * @param str the input String
        if (isEmpty(arr)) {
     * high surrogates.
     */
     * @param str the String to capitalize, may be <code>null</code>
        for (int j = 0; j < substring.length(); j++) {
        if (offset < 0) {
            if (charsToDelete.indexOf(c) == -1) {
    public static String quote(String str) {
    ) {
 *
        int patLen = oldPattern.length();
                builder.endObject();
     * Capitalize a <code>String</code>, changing the first letter to
    }
        }
     * @return a two element array with index 0 being before the delimiter, and
    public static boolean hasLength(CharSequence str) {
     * Check whether every single character in the string is a digit.
     */
     * @param str       the input String
        return collectionToDelimitedString(coll, ",");
            }
import org.opensearch.core.xcontent.MediaType;
        // the index of an occurrence we've found, or -1
     * @param pattern  the pattern to delete all occurrences of
     */
     * its length is greater than 0, and it contains at least one non-whitespace character.
    }
    /**
        }
import org.opensearch.core.xcontent.ToXContent;
        int ex = p.indexOf('E');
     * @see StringTokenizer
        final T tokens = supplier.get();
    private Strings() {}
     * be considered as single delimiter string, rather than as bunch of potential
        }
     *
    public static String toString(MediaType mediaType, ToXContent toXContent, boolean pretty, boolean human) {
    public static String capitalize(String str) {
     * @param str              the String to check
    public static String[] tokenizeToStringArray(final String s, final String delimiters) {
     * Copy the given Collection into a String array.
        int realEndIndex = s.length() > 0 ? s.length() - 1 : 0;
    /**
            builder = builder.humanReadable(true);
    /**
        if (str == null) {
    /**
    // ---------------------------------------------------------------------
            }
    /**
     * @return <code>true</code> if the CharSequence is not null and has length
import static java.util.Collections.unmodifiableSet;
    /**
            return s;
                return p.substring(0, ix) + fraction + p.substring(ex) + suffix;
     */
    public static Set<String> tokenizeByCommaToSet(final String s) {
     *
    }
        for (String segment : fileName.split("[/\\\\]")) {
    public static byte[] toUTF8Bytes(CharSequence charSequence) {
                return false;
            return s;
    }
        }
     * @param index     the index in the original string to start matching against
     * @see String#trim()
    public static boolean validFileNameExcludingAsterisk(String fileName) {
     * E.g. useful for <code>toString()</code> implementations.
    public static String toLowercaseAscii(String in) {
     * StringUtils.hasText(" 12345 ") = true
import org.opensearch.core.common.bytes.BytesReference;
     */
 */
     *
                return false;
import org.opensearch.common.Nullable;
     * @param array the array to check
    }
     *                  rather than a bunch individual delimiter characters)
     * StringUtils.hasText("12345") = true
    /**
                pos = delPos + delimiter.length();
        if (s == null) {
    }
     * Test whether the given string matches the given substring
import org.opensearch.core.xcontent.XContentBuilder;
     * @param inString   String to examine
        // Reject path traversal: ".." as a path segment
            }
            int delPos;
     *
     * json needs to be pretty printed and human readable.
     * @return {@code true} if the string only contains digits, {@code false} otherwise.
        return toUTF8Bytes(charSequence, new BytesRefBuilder());
    }
     * StringUtils.isEmpty("") = true
        if (s == null) {
     * Determine whether the given array is empty:
     */
     * Tokenize the given String into a String array via a StringTokenizer.
import java.util.Collection;
                return true;
        }
        }
    /**
     *                   (each of those characters is individually considered as delimiter).
            if (i > 0) {
        if (s == null) {
     * @param str the CharSequence to check (may be <code>null</code>)
        for (int i = 0; i < inString.length(); i++) {
    }
    }
    /**
    public static String format1Decimals(double value, String suffix) {
     * Convenience method to convert a CSV string list to a set.
     * @see Strings#tokenizeToStringArray
        }
     * @param <T>        the type of the collection
        for (int i = 0; i < fileName.length(); i++) {
        Iterator<Integer> iter = in.codePoints().iterator();
     *
     *
    }
    }
        /*
     * <p>A single delimiter can consists of more than one character: It will still
    /**
        return delimitedListToStringArray(str, delimiter, null);
     * another string.
            if (token.length() > 0) {
                return builder.toString();
    public static boolean hasText(String str) {
    /**
        }
    public static void arrayToDelimitedString(Object[] arr, String delim, StringBuilder sb) {
     * @return the quoted String (e.g. "'myString'"),
        XContentBuilder builder = XContentBuilder.builder(mediaType.xContent());
    /**
     */
        return hasText((CharSequence) str);
    public static String[] delimitedListToStringArray(String str, String delimiter, String charsToDelete) {
     */
            sb.append(prefix).append(it.next()).append(suffix);
         * Its pretty silly for you to truncate to 0 length but just in case
     * Note: Will return <code>true</code> for a BytesReference that purely consists of whitespace.
        try (BufferedReader reader = new BufferedReader(new StringReader(from))) {
        if (s == null) {
    public static void collectionToDelimitedString(Iterable<?> coll, String delim, String prefix, String suffix, StringBuilder sb) {
        if (collection == null) {
        for (int i = 0; i < fileName.length(); i++) {
    public static String substring(String s, int beginIndex, int endIndex) {
     * @param str the String to check (may be <code>null</code>)
     * its length is greater than 0, and it contains at least one non-whitespace character.
        return builder;
     * @param str           the input String
     *
     * @param oldPattern String to replace
        if ("".equals(delimiter)) {
        else return s.split(",");
        return toStringArray(result);
    public static String collectionToDelimitedString(Iterable<?> coll, String delim) {
     * String. E.g. useful for <code>toString()</code> implementations.
        return toString(mediaType, toXContent, ToXContent.EMPTY_PARAMS, pretty, human);
    /**
     *
            if (i >= str.length() || str.charAt(i) != substring.charAt(j)) {
    }
     */
     * Wraps the output into an anonymous object if needed.
    public static String replace(String inString, String oldPattern, String newPattern) {
            for (int i = 0; i < str.length(); i++) {
 * SPDX-License-Identifier: Apache-2.0
     */
import static org.opensearch.common.util.set.Sets.newHashSet;
     * @param delimiters the delimiter characters, assembled as String
    public static String arrayToCommaDelimitedString(Object[] arr) {
     *         greater than 0, and it does not contain whitespace only
            if (ex != -1) {
     * @param supplier   a collection supplier
        while (it.hasNext()) {
        return replace(inString, pattern, "");
    }
    // ---------------------------------------------------------------------
     * Note: Will return <code>false</code> for a CharSequence that purely consists of whitespace.
        return sb.toString();
    /**
    }
import org.opensearch.OpenSearchException;
     * at the given index.
        return hasLength((CharSequence) str);
        }
        }
     */
            }
    }
        return tokenizeToCollection(s, ",", HashSet::new);
            XContentBuilder builder = createBuilder(mediaType, pretty, human);
    // ---------------------------------------------------------------------
            return Strings.EMPTY_ARRAY;
            }
        sb.append(inString.substring(pos));
     * @param arr   the array to display
import java.util.HashSet;
        }
     * </pre>
    }
     * @param delimiter the delimiter between elements (this is a single delimiter,
            } catch (IOException e2) {
     * @param prefix the String to start each element with
        return changeFirstCharacterCase(str, true);
     * @param coll  the Collection to display
            int codepoint = iter.next();
     * E.g. useful for <code>toString()</code> implementations.
 * The OpenSearch Contributors require contributions made to
                }
        }
     * Format the double value with a single decimal points, trimming trailing '.0'.
     * Convenience method to return a Collection as a delimited (e.g. CSV)
            } else {
     * <p>An empty string returns {@code false}.</p>
            builder = builder.prettyPrint();
import java.util.Collections;
            return inString;
     *
            if (segment.equals("..")) {
     */
     * @param str the input String (e.g. "myString")
     * Allows to configure the params.
     * delimiter characters - in contrast to <code>tokenizeToStringArray</code>.
     *         its length is greater than 0, and it does not contain whitespace only
        try {
            return builder.toString();
    public static final String UNKNOWN_UUID_VALUE = "_na_";
     * @param charsToDelete a set of characters to delete.
     * @return the String array (<code>null</code> if the passed-in
     * @return the delimited String
     * StringUtils.hasText(null) = false
    }
     */
     */
    public static boolean validFileNameExcludingSlash(String fileName) {
     * StringUtils.hasText(" ") = false
     * delimiter characters - in contrast to <code>tokenizeToStringArray</code>.
     */
        return sb.toString();
            while ((line = reader.readLine()) != null) {
        return arrayToDelimitedString(arr, ",");
        if (Character.isHighSurrogate(s.charAt(length - 1))) {
     * upper case as per {@link Character#toUpperCase(char)}.
    public static boolean substringMatch(CharSequence str, int index, CharSequence substring) {
            char c = fileName.charAt(i);
        }
    /**
        sb.append(str.substring(1));
                return false;
        }
     * @return the delimited String
                XContentBuilder builder = createBuilder(mediaType, pretty, human);
                result.add(deleteAny(str.substring(i, i + 1), charsToDelete));
     *
        int index = inString.indexOf(oldPattern);
     * <p>A single delimiter can consists of more than one character: It will still
    // no instance:
            }
import java.util.ArrayList;
        return sb.toString();
 * compatible open source license.
    public static boolean isAllOrWildcard(String data) {
     * Return substring(beginIndex, endIndex) that is impervious to string length.
        return new String[] { beforeDelimiter, afterDelimiter };
    public static String delete(String inString, String pattern) {
            }
    public static boolean validFileName(String fileName) {
 * TODO replace Strings in :server
     * @return <code>true</code> if the BytesReference is not null and has length
    private static boolean isEmpty(final Object[] array) {
    /**
        return true;
         */
        int ix = p.indexOf('.') + 1;
        } else {
        final Supplier<T> supplier
     */
            int i = index + j;
            final String token = tokenizer.nextToken().trim();
        return s == null || s.isEmpty();
                to.append(line).append('\n');
        }
import java.util.List;
        set.addAll(Arrays.asList(tokens));
     * Return a {@link String} that is the json representation of the provided {@link ToXContent}.
     * Convenience method to return a Collection as a CSV String.
        Iterator<?> it = coll.iterator();
    }
     * String. E.g. useful for <code>toString()</code> implementations.
    public static String[] delimitedListToStringArray(String str, String delimiter) {
    /**
        String[] tokens = commaDelimitedListToStringArray(str);
     */
        return true;
        }
            return "";
        StringBuilder out = new StringBuilder();
        return hasLength(str) == false;
                builder.startObject();
     * Returns `true` if the string is `_all` or `*`.
     */
        }
     *
import java.util.TreeSet;
    public static String arrayToDelimitedString(Object[] arr, String delim) {
     *         index 1 being after the delimiter (neither element includes the delimiter);
        // Reject invalid characters (excluding slashes)
                builder.startObject();
    public static String trimLeadingCharacter(String str, char leadingCharacter) {
    public static boolean hasLength(final BytesReference bytesReference) {
     * @return the trimmed String
            }
            toXContent.toXContent(builder, params);
     * Take a String which is a delimited list and convert it to a String array.
     * @return a String with the replacements
     * @param coll   the Collection to display
    }
        }
    }
            for (int i = s.length(); i < minimumLength; i++) {
                result.add(deleteAny(str.substring(pos, delPos), charsToDelete));
        String afterDelimiter = toSplit.substring(offset + delimiter.length());
        return toString(mediaType, toXContent, params, false, false);
        if (capitalize) {
     */
     * Check whether the given CharSequence has actual text.
    public static String toString(MediaType mediaType, ToXContent toXContent) {
     * Return a {@link String} that is the json representation of the provided {@link ToXContent}.
     * be considered as single delimiter string, rather than as bunch of potential
    }
        StringBuilder sb = new StringBuilder();
     * Convenience method to return a String array as a CSV String.
        final String delimiters,
            char c = fileName.charAt(i);
        }
        return false;
         * someone does this shouldn't break.
     * @param s the string to split
     * Does not include the delimiter in the result.
    // ---------------------------------------------------------------------
     * Tokenizes the specified string to a collection using the specified delimiters as the token delimiters. This method trims whitespace
        }
    /**
            return false;
    public static byte[] toUTF8Bytes(CharSequence charSequence, BytesRefBuilder spare) {
     *
        return "_all".equals(data) || "*".equals(data);
    public static String[] split(String toSplit, String delimiter) {
        }
    /**
     * @param str the input String
     * @return the array of split values
     * @see #tokenizeToStringArray
        if (str == null || str.length() == 0) {
        arrayToDelimitedString(arr, delim, sb);
        List<String> result = new ArrayList<>();
     *
            if (c != '/' && c != '\\' && INVALID_FILENAME_CHARS.contains(c)) {
     * i.e. <code>null</code> or of zero length.
        }
        StringBuilder sb = new StringBuilder();
     * @see Strings#delimitedListToStringArray
            return false;
        if (s == null) return Collections.emptySet();
     */
     *
     * </pre>
        newHashSet('\\', '/', '*', '?', '"', '<', '>', '|', ' ', ',')
     *
     * @param coll the Collection to display
            sb.append(newPattern);
            }
     * @return <code>true</code> if the String is not <code>null</code>, its length is
            return s.substring(beginIndex);
            return s.substring(beginIndex, endIndex);
    private static XContentBuilder createBuilder(MediaType mediaType, boolean pretty, boolean human) throws IOException {
     * Delete all occurrences of the given substring.
    public static Set<String> commaDelimitedListToSet(String str) {
     * @return <code>true</code> if the CharSequence is either null or has a zero length
            sb.append(Character.toLowerCase(str.charAt(0)));
     */
     * Allows to control whether the outputted json needs to be pretty printed and human readable.
    }
     */
                return p.substring(0, ix) + fraction + suffix;
                sb.append(delim);
        return collection.toArray(new String[0]);
     * from tokens and ignores empty tokens.
     * @return the resulting String
        return toStringArray(tokenizeToCollection(s, delimiters, ArrayList::new));
        while (sb.length() > 0 && sb.charAt(0) == leadingCharacter) {
                sb.append(delim);
    }
import java.io.IOException;
        if (fraction == '0') {
            index = inString.indexOf(oldPattern, pos);
     * @param arr the array to display
     * Wraps the output into an anonymous object if needed.
     *
     */
            }
        while (iter.hasNext()) {
     * Replace all occurrences of a substring within a string with
        } else {
        return (bytesReference != null && bytesReference.length() > 0);
     * Note that this will suppress duplicates.
        } else {
    public static boolean hasLength(final String str) {
    /**
                return false;
     * String. E.g. useful for <code>toString()</code> implementations.
    /**
     *
     * Note: Will return <code>true</code> for a String that purely consists of whitespace.
        collectionToDelimitedString(coll, delim, prefix, suffix, sb);
        for (int i = 0; i < arr.length; i++) {
            return str;
    /**
        return delimitedListToStringArray(str, ",");
    /**
    }
 */
            }
     * @return the delimited String
        Set<String> set = new TreeSet<>();
            throw new NullPointerException("s");
        }
     * Convenience method to return a String array as a delimited (e.g. CSV)
            return;
    public static String toString(MediaType mediaType, ToXContent toXContent, ToXContent.Params params) {
     */
        return out.toString();
     * <p>The given delimiters string is supposed to consist of any number of
    }
     */
            sb.append(arr[i]);
        if (hasLength(toSplit) == false || hasLength(delimiter) == false) {
    }
            }
import java.util.Iterator;
            }
            }
        for (int i = 0; i < strLen; i++) {
            }
    }
     * Return a {@link String} that is the json representation of the provided {@link ToXContent}.
     * @return the tokens
            return sb.toString();
import org.opensearch.core.common.util.CollectionUtils;
     *
            if (INVALID_FILENAME_CHARS.contains(c)) {
     */
        }
     * Truncates string to a length less than length. Backtracks to throw out
            return inString;
import org.apache.lucene.util.BytesRefBuilder;
        } catch (IOException e) {
     *
        for (int i = 0; i < fileName.length(); i++) {
                sb.append(c);
        return set;
     * @see Character#isWhitespace
     * StringUtils.isEmpty(null) = true
            try {
    /**
     * Allows to configure the params.
        return (array == null || array.length == 0);
    public static String collectionToCommaDelimitedString(Iterable<?> coll) {
            sb.append(Character.toUpperCase(str.charAt(0)));
            if (c != '*' && INVALID_FILENAME_CHARS.contains(c)) {
import java.util.Set;
    }
    public static String[] toStringArray(final Collection<String> collection) {
    /**
     * StringUtils.hasLength("Hello") = true
            }
            length--;
     * @param str       the original string (or StringBuilder)
            if (codepoint > 128) {
            return str;
     */
    /**
     * Split the specified string by commas to an array.
        }
     * Trim all occurrences of the supplied leading character from the given String.
     * StringUtils.isEmpty("Hello") = false
     * More specifically, returns <code>true</code> if the string not <code>null</code>,
        while (tokenizer.hasMoreTokens()) {
        if (s.length() >= minimumLength) {
     */
    }
     * @see Strings#hasLength(CharSequence)
        return true;
     * @param s        the String to tokenize
     * <pre>
    public static boolean isDigits(final String s) {
        }
     * which is usually used as everything
     * The Collection must contain String elements only.
    /**
        String beforeDelimiter = toSplit.substring(0, offset);
        return sb.toString();
    }
        }
     * Take a String which is a delimited list and convert it to a String array.
     *         Collection was <code>null</code>)
            if (toXContent.isFragment()) {
    // Convenience methods for working with formatted Strings
        String p = String.valueOf(value);
                builder.endObject();
     * @param newPattern String to insert
     * @param s the string, must not be null.
        if (s == null || s.isEmpty()) return Strings.EMPTY_ARRAY;
    }
     * Return a {@link String} that is the json representation of the provided {@link ToXContent}.
        final String s,
package org.opensearch.core.common;
            }
                sb.append(c);
        return sb.toString();
    /**
            pos = index + patLen;
     * @return the delimited String
    }
        }
    }
    // General convenience methods for working with Strings
    public static String cleanTruncate(String s, int length) {
        }
     * More specifically, returns <code>true</code> if the string not <code>null</code>,
            if (str.length() > 0 && pos <= str.length()) {
/*
     *
                return false;
     * @param bytesReference the BytesReference to check (may be <code>null</code>)
     * @return an array of Strings, or the empty array in case of empty input
     *
     *
     */
     * @param str the CharSequence to check (may be <code>null</code>)
     * @return <code>true</code> if the CharSequence is not <code>null</code>,
    }
        }
        return true;
            return null;
            StringBuilder sb = new StringBuilder(minimumLength);
        if (s == null) {
        return CollectionUtils.isEmpty(data) || data.length == 1 && isAllOrWildcard(data[0]);
     * Check that the given CharSequence is neither <code>null</code> nor of length 0.
     *
     * @return an array of the tokens in the list
     * <pre>
    }
    }
     */
import java.util.Arrays;
 * @opensearch.internal
     * StringUtils.hasLength(" ") = true
     * @param inString      the original String
     * @param str the String to check (may be <code>null</code>)
     * @param delim  the delimiter to use (probably a ",")
    }
     * StringUtils.hasLength("") = false
    /**
        }
            String line;
        return s.substring(0, length);
            }
 *
     */
     *
        }
                tokens.add(token);
     * StringUtils.hasText("") = false
    public static final String[] EMPTY_ARRAY = new String[0];
    }
     *
     * @param delim the delimiter to use (probably a ",")
        if (human) {
     * <pre>
     *                      rather than a bunch individual delimiter characters)
        }
            return null;
    public static boolean isNullOrEmpty(@Nullable String s) {
            return null;
                result.add(deleteAny(str.substring(pos), charsToDelete));
     *
     * @param suffix the String to end each element with
    }
import java.util.StringTokenizer;
        int strLen = str.length();
     * StringUtils.hasLength(null) = false
     * @return the set of tokens
     * @see Strings#hasLength(CharSequence)
    }
     *
    public static final Set<Character> INVALID_FILENAME_CHARS = unmodifiableSet(
            if (!Character.isWhitespace(str.charAt(i))) {
    public static String[] commaDelimitedListToStringArray(String str) {
        StringBuilder sb = new StringBuilder();
 * <p>
     * The content is not pretty-printed nor human readable.
        return sb.toString();
     * delimiter characters. Each of those characters can be used to separate
            }
     */
     * No other letters are changed.
        if (hasLength(str) == false) {
     * Convenience method to return a Collection as a delimited (e.g. CSV)
     * @see Strings#hasText(CharSequence)
    /**
     * @return an array of the tokens in the list
        return collectionToDelimitedString(coll, delim, "", "");
    );
        }
    }
     * @return the capitalized String, <code>null</code> if null
            if (toXContent.isFragment()) {
                out.appendCodePoint(codepoint);
    /**
