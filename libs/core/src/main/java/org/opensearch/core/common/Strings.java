            return sb.toString();
        if (hasLength(toSplit) == false || hasLength(delimiter) == false) {
    public static String toLowercaseAscii(String in) {  
        else return s.split(",");
        spare.copyChars(charSequence);
        return arrayToDelimitedString(arr, ",");
     */
import static java.util.Collections.unmodifiableSet;
     * @param str the input String
     * <p>A single delimiter can consists of more than one character: It will still
     *                      rather than a bunch individual delimiter characters)
     * Returns `true` if the string is `_all` or `*`.
        } else {
     * Wraps the output into an anonymous object if needed. Allows to control whether the outputted
    public static String trimLeadingCharacter(String str, char leadingCharacter) {
         * someone does this shouldn't break.
        }
    public static boolean hasLength(final BytesReference bytesReference) {
        return true;  
     * If an array only consists of zero or one element, which is "*" or "_all" return an empty array
                builder.endObject();
     * </pre>
     * @return an array of the tokens  
     * Check whether the given String has actual text.
     * <p>The given delimiters string is supposed to consist of any number of
        StringBuilder sb = new StringBuilder();
     * @return a String with the replacements
        while (sb.length() > 0 && sb.charAt(0) == leadingCharacter) {  
     * @see #hasText(String)
     * StringUtils.isEmpty(null) = true  
     *
        return sb.toString();  
        set.addAll(Arrays.asList(tokens));
        return toString(mediaType, toXContent, params, false, false);
        XContentBuilder builder = XContentBuilder.builder(mediaType.xContent());
    public static void spaceify(int spaces, String from, StringBuilder to) throws Exception {
        StringBuilder sb = new StringBuilder();
            }
    public static final String UNKNOWN_UUID_VALUE = "_na_";
    // ---------------------------------------------------------------------
            toXContent.toXContent(builder, params);  
    }
     * More specifically, returns <code>true</code> if the string not <code>null</code>,  
        String beforeDelimiter = toSplit.substring(0, offset);
     * Trims tokens and omits empty tokens.  
import org.opensearch.core.common.util.CollectionUtils;  
    public static void collectionToDelimitedString(Iterable<?> coll, String delim, String prefix, String suffix, StringBuilder sb) {
     */
        newHashSet('\\', '/', '*', '?', '"', '<', '>', '|', ' ', ',')
     * Take a String which is a delimited list and convert it to a String array.
        }  
 */  
        int ix = p.indexOf('.') + 1;
    /**  
        if (s == null) {  
     *  
     * Quote the given String with single quotes.
            if (c != '*' && INVALID_FILENAME_CHARS.contains(c)) {
        try {
     * @return the capitalized String, <code>null</code> if null
    /**  
    }
    }
    }  
     * @see StringTokenizer  
     * Convenience method to return a String array as a delimited (e.g. CSV)
     * Check that the given CharSequence is either <code>null</code> or of length 0.  
     *
    /**
     * @see Strings#tokenizeToStringArray  
    /**  
            }  
     * Test whether the given string matches the given substring
import org.opensearch.core.xcontent.MediaType;
    }  
            if (toXContent.isFragment()) {  
     * @return the String array (<code>null</code> if the passed-in
     * @see String#trim()
            if (i >= str.length() || str.charAt(i) != substring.charAt(j)) {
    }
                pos = delPos + delimiter.length();
     *
            return str;
     * @param str the String to capitalize, may be <code>null</code>
    }
                result.add(deleteAny(str.substring(pos), charsToDelete));
    public static boolean isAllOrWildcard(String[] data) {
     * Does not include the delimiter in the result.
    /**  
        for (int i = 0; i < fileName.length(); i++) {  
    public static Set<String> commaDelimitedListToSet(String str) {
     *
     * @see StringTokenizer
     * @param arr the array to display
     *
     * Note that this will suppress duplicates.  
        }
     * @param delimiters the token delimiters
     *
     * @param str the String to check (may be <code>null</code>)  
     *
    /**
    public static String[] tokenizeToStringArray(final String s, final String delimiters) {
        char fraction = p.charAt(ix);  
     * from tokens and ignores empty tokens.
            int pos = 0;  
        }
        for (int i = 0; i < arr.length; i++) {
import java.io.IOException;  
        return (str != null && str.length() > 0);
     * @param supplier   a collection supplier  
            }  
            return null;
    public static boolean hasLength(CharSequence str) {
            }
            return s;
        } catch (IOException e) {
    public static void arrayToDelimitedString(Object[] arr, String delim, StringBuilder sb) {  
        while (tokenizer.hasMoreTokens()) {  
     * Check that the given CharSequence is neither <code>null</code> nor of length 0.  
     * @param s the string to split
        if (length == 0) {  
    public static String arrayToCommaDelimitedString(Object[] arr) {
     * Convenience method to return a Collection as a delimited (e.g. CSV)  
            }
    /**  
    /**
    // ---------------------------------------------------------------------  
                return p.substring(0, ix - 1) + p.substring(ex) + suffix;  
     */
     * @return the delimited String
     *  
/**
     * @param str the CharSequence to check (may be <code>null</code>)  
        } else {  
    public static String[] toStringArray(final Collection<String> collection) {
     * @param oldPattern String to replace
    }
    public static boolean isEmpty(final CharSequence str) {  
     */
            sb.append(newPattern);
        if (capitalize) {
     * @return a Set of String entries in the list  
    }
            return s;
     * No other letters are changed.
import java.util.Collection;
     * @param str              the String to check  
        if (s == null) {
    /**  
    public static boolean validFileName(String fileName) {
        arrayToDelimitedString(arr, delim, sb);
     */
    // no instance:
     * <pre>
        for (int i = 0; i < strLen; i++) {
        int realEndIndex = s.length() > 0 ? s.length() - 1 : 0;
        return CollectionUtils.isEmpty(data) || data.length == 1 && isAllOrWildcard(data[0]);  
    /**
                XContentBuilder builder = createBuilder(mediaType, pretty, human);
                throw new OpenSearchException("cannot generate error message for deserialization", e);
            }
        }  
     * @see Strings#delimitedListToStringArray  
     * json needs to be pretty printed and human readable.
     */
        StringBuilder sb = new StringBuilder();
     */
    private static XContentBuilder createBuilder(MediaType mediaType, boolean pretty, boolean human) throws IOException {
            return builder.toString();
     * Check whether every single character in the string is a digit.  
            if (segment.equals("..")) {
    }  
import java.util.HashSet;  
            int i = index + j;
import java.util.Set;  
    private static boolean isEmpty(final Object[] array) {
     *                  rather than a bunch individual delimiter characters)
 * TODO replace Strings in :server
    public static String replace(String inString, String oldPattern, String newPattern) {  
     * Return a {@link String} that is the json representation of the provided {@link ToXContent}.
            return s.substring(beginIndex, endIndex);  
        return hasText((CharSequence) str);  
     * <p>An empty string returns {@code false}.</p>
     *                   (each of those characters is individually considered as delimiter).
    ) {  
        if (s.length() >= minimumLength) {
    public static String format1Decimals(double value, String suffix) {
                result.add(deleteAny(str.substring(pos, delPos), charsToDelete));  
        String[] tokens = commaDelimitedListToStringArray(str);
    public static boolean isNullOrEmpty(@Nullable String s) {  
     *
     * Convenience method to return a String array as a CSV String.
     * Delete all occurrences of the given substring.  
     * which is usually used as everything  
import java.util.TreeSet;
        }
     * @return <code>true</code> if the String is not null and has length
     */
    /**
     * Return a {@link String} that is the json representation of the provided {@link ToXContent}.  
 * The OpenSearch Contributors require contributions made to  
        int ex = p.indexOf('E');
            }
                return p.substring(0, ix - 1) + suffix;
    }
        if (s == null) {
     * Note: Will return <code>true</code> for a BytesReference that purely consists of whitespace.
        /*
        for (int i = 0; i < inString.length(); i++) {
                return true;
        final String s,  
        }
        if (s == null || s.isEmpty()) return Strings.EMPTY_ARRAY;
        } else {
    /**  
     * @return an array of the tokens in the list
     * nor human readable.
        return hasLength(str) == false;
        }
     * <pre>
        }  
     * @return the delimited String
     * Return substring(beginIndex, endIndex) that is impervious to string length.  
            }
        if (str == null) {  
     */
    /**
            if (!Character.isWhitespace(str.charAt(i))) {  
        return true;
     * @return {@code true} if the string only contains digits, {@code false} otherwise.
        }
     *         Collection was <code>null</code>)  
     * tokens. A delimiter is always a single character; for multi-character  
    }  
    /**
     * @param pattern  the pattern to delete all occurrences of  
            for (int i = s.length(); i < minimumLength; i++) {  
     * StringUtils.hasLength(null) = false  
        return collectionToDelimitedString(coll, delim, "", "");
        String afterDelimiter = toSplit.substring(offset + delimiter.length());  
     * delimiter characters. Each of those characters can be used to separate
            return inString;
     * Convenience method to return a Collection as a CSV String.  
                for (int i = 0; i < spaces; i++) {  
     *  
     * @param <T>        the type of the collection
     * @param str       the input String
            if (INVALID_FILENAME_CHARS.contains(c)) {
        int offset = toSplit.indexOf(delimiter);
     * @return the quoted String (e.g. "'myString'"),
    /**
     */
    }
     * Tokenize the specified string by commas to a set, trimming whitespace and ignoring empty tokens.
    public static String[] split(String toSplit, String delimiter) {  
        return builder;  
            return false;
    }
     * @param delim the delimiter to use (probably a ",")
     */
            return s;  
     * @param suffix the String to end each element with
     */
            sb.append(Character.toLowerCase(str.charAt(0)));
     * @param delimiter to split the string up with
     * @param arr   the array to display
        return toStringArray(tokenizeToCollection(s, delimiters, ArrayList::new));  
            }
                // Add rest of String, but not in case of empty input.
        }
     * @param str the String to check (may be <code>null</code>)  
     * high surrogates.
            if (codepoint > 128) {
 *  
                sb.append(delim);  
            return Strings.EMPTY_ARRAY;
     *
            char c = inString.charAt(i);  
    public static String[] commaDelimitedListToStringArray(String str) {  
     */  
    }  
     * @param charsToDelete a set of characters to delete. Useful for deleting unwanted  
            String line;
    public static boolean hasText(String str) {
    /**
     * Copy the given Collection into a String array.
     * Tokenize the given String into a String array via a StringTokenizer.
            return null;  
     * its length is greater than 0, and it contains at least one non-whitespace character.
        return collection.toArray(new String[0]);  
     */  
     * Allows to control whether the outputted json needs to be pretty printed and human readable.
 * compatible open source license.
     *  
     * Format the double value with a single decimal points, trimming trailing '.0'.  
    public static byte[] toUTF8Bytes(CharSequence charSequence, BytesRefBuilder spare) {  
     *
     * delimiter characters - in contrast to <code>tokenizeToStringArray</code>.  
     */
     * @param s the string to tokenize  
        final T tokens = supplier.get();
        return changeFirstCharacterCase(str, true);
        return delimitedListToStringArray(str, ",");
    public static final String[] EMPTY_ARRAY = new String[0];
    // ---------------------------------------------------------------------
        } else {
                return false;  
                return false;  
    /**
        if (fileName.startsWith("/") || fileName.startsWith("\\")) {
import org.opensearch.common.Nullable;
        return true;  
     * StringUtils.hasLength(" ") = true
     * Split the specified string by commas to an array.  
     *                      line breaks: e.g. "\r\n\f" will delete all new lines and line feeds in a String.
import org.opensearch.OpenSearchException;  
    // Convenience methods for working with formatted Strings  
        // Reject path traversal: ".." as a path segment  
     */  
    }
    /**
        }
    }
            return;
     * @param prefix the String to start each element with  
                return p.substring(0, ix) + fraction + p.substring(ex) + suffix;  
        }
        Set<String> set = new TreeSet<>();  
        }
        for (int j = 0; j < substring.length(); j++) {  
    /**
            XContentBuilder builder = createBuilder(mediaType, pretty, human);
            return new String[] { str };
     * Take a String which is a delimited list and convert it to a String array.  
     * delimiters, consider using <code>delimitedListToStringArray</code>
        final String delimiters,
    /**  
    /**  
            if (str.length() > 0 && pos <= str.length()) {  
            return Strings.EMPTY_ARRAY;
        List<String> result = new ArrayList<>();  
        }
     * @param toSplit   the string to split  
     * @see Strings#hasText(CharSequence)  
    }
     * @param inString the original String
     * @return the set of tokens
     * E.g. useful for <code>toString()</code> implementations.
    }  
    public static byte[] toUTF8Bytes(CharSequence charSequence) {
     * More specifically, returns <code>true</code> if the string not <code>null</code>,  
     * @see Strings#hasLength(CharSequence)
    public static String[] splitStringByCommaToArray(final String s) {  
     * @return <code>true</code> if the CharSequence is either null or has a zero length
     * @param coll  the Collection to display  
        return s.substring(0, length);  
            } else {
     */  
     * Return a {@link String} that is the json representation of the provided {@link ToXContent}.
    public static boolean isAllOrWildcard(String data) {  
    }
     *
        }
     *  
 * this file be licensed under the Apache-2.0 license or a
    /**  
    // General convenience methods for working with Strings
            length--;
     * Convenience method to convert a CSV string list to a set.
        if (isEmpty(arr)) {
        StringBuilder sb = new StringBuilder();
     * Allows to configure the params.
        for (String segment : fileName.split("[/\\\\]")) {
                return builder.toString();  
import java.util.Iterator;
     * @return an array of Strings, or the empty array in case of empty input
     * be considered as single delimiter string, rather than as bunch of potential
        collectionToDelimitedString(coll, delim, prefix, suffix, sb);  
     */
        if (collection == null) {  
     * StringUtils.hasLength("Hello") = true  
        }
    }
    public static String[] delimitedListToStringArray(String str, String delimiter) {
            char c = fileName.charAt(i);  
    /**
     * <pre>
                tokens.add(token);  
                sb.append(c);
            return false;  
     *
    public static String[] delimitedListToStringArray(String str, String delimiter, String charsToDelete) {
        try (BufferedReader reader = new BufferedReader(new StringReader(from))) {  
    public static boolean hasText(CharSequence str) {  
        if (!hasLength(inString) || !hasLength(oldPattern) || newPattern == null) {
        if (!hasLength(str)) {
     * @param delim the delimiter to use (probably a ",")  
     * </pre>
            try {  
            }
     */  
     * Capitalize a <code>String</code>, changing the first letter to  
        while (index >= 0) {  
        return toString(mediaType, toXContent, false, false);
     */  
    public static String toString(MediaType mediaType, ToXContent toXContent, boolean pretty, boolean human) {
            return str;  
     * @see #tokenizeToStringArray  
        StringBuilder sb = new StringBuilder(str.length());  
     * @param str       the original string (or StringBuilder)
            final String token = tokenizer.nextToken().trim();
        // the index of an occurrence we've found, or -1
    }  
     * @param delimiter     the delimiter between elements (this is a single delimiter,
                return false;  
        return new String[] { beforeDelimiter, afterDelimiter };
         * Its pretty silly for you to truncate to 0 length but just in case  
        if (hasLength(str) == false) {
            }
     *  
            }  
 *
    public static Set<String> tokenizeByCommaToSet(final String s) {  
        return out.toString();
    }
    /**
    }  
    public static String toString(MediaType mediaType, ToXContent toXContent) {  
        if (s == null) {  
     *  
        if (endIndex > realEndIndex) {  
     * @see String#split(String)
            return s.substring(beginIndex);
        sb.append(str.substring(1));  
     * @param delim  the delimiter to use (probably a ",")
        StringBuilder out = new StringBuilder();
     * @return <code>true</code> if the String is not <code>null</code>, its length is
        // Reject absolute paths
        }
            if (charsToDelete.indexOf(c) == -1) {
    public static String arrayToDelimitedString(Object[] arr, String delim) {  
     *         index 1 being after the delimiter (neither element includes the delimiter);  
    private static String toString(MediaType mediaType, ToXContent toXContent, ToXContent.Params params, boolean pretty, boolean human) {  
            sb.append(inString, pos, index);
 * <p>
     *
import java.util.List;
 * @opensearch.internal
            return inString;
    }  
        }
package org.opensearch.core.common;
     * @param s the string, must not be null.
import java.util.ArrayList;
     * Wraps the output into an anonymous object if needed.
        sb.append(inString.substring(pos));  
        // Reject invalid characters (excluding slashes)
        return tokenizeToCollection(s, ",", HashSet::new);
        return tokens;  
     *  
        if ("".equals(delimiter)) {
        return false;
                sb.append(c);
     */
     * String. E.g. useful for <code>toString()</code> implementations.  
     * @param str the input String (e.g. "myString")  
     * @return the trimmed String
            index = inString.indexOf(oldPattern, pos);
 * SPDX-License-Identifier: Apache-2.0
     * Wraps the output into an anonymous object if needed.  
}
     */
    /**
         */
     * Check that the given String is neither <code>null</code> nor of length 0.  
                    to.append(' ');
        }
     * Note: Will return <code>true</code> for a String that purely consists of whitespace.
                builder.field("stack_trace", ExceptionsHelper.stackTrace(e));
        while (it.hasNext()) {  
    }
import java.util.Arrays;  
    }
        return sb.toString();  
        return toStringArray(result);
        }
     * @param str the CharSequence to check (may be <code>null</code>)  
import org.apache.lucene.util.BytesRefBuilder;
    /**  
    }  
        }
    }
        int pos = 0; // our position in the old string
        if (s == null) return Collections.emptySet();
     * @param array the array to check
     *
    /**
     * another string.
     * The Collection must contain String elements only.
     * @see Character#isWhitespace
     * StringUtils.hasText(" 12345 ") = true
        int patLen = oldPattern.length();
        Iterator<Integer> iter = in.codePoints().iterator();
     * String. E.g. useful for <code>toString()</code> implementations.
            }
     *
     * E.g. useful for <code>toString()</code> implementations.
        }
/*  
     *
        // remember to append any characters to the right of a match
    }
     * Convert a CSV list into an array of Strings.
     * Determine whether the given array is empty:
    public static boolean validFileNameExcludingSlash(String fileName) {  
                sb.append(delim);  
     *
    }  
        return hasLength((CharSequence) str);
            }  
    public static boolean substringMatch(CharSequence str, int index, CharSequence substring) {
        return (str != null ? "'" + str + "'" : null);
            while ((line = reader.readLine()) != null) {
            builder = builder.prettyPrint();
    // ---------------------------------------------------------------------
        if (length >= s.length()) {  
    }
     * StringUtils.hasLength("") = false
        }
                return false;  
    }
     *         or <code>null</code> if the delimiter wasn't found in the given input String
     * Truncates string to a length less than length. Backtracks to throw out
     *
     */
     * Replace all occurrences of a substring within a string with
    public static boolean hasLength(final String str) {
import java.util.Collections;
        return sb.toString();
     * upper case as per {@link Character#toUpperCase(char)}.
     *  
     * @return <code>true</code> if the CharSequence is not null and has length
        }  
import java.io.StringReader;
    /**
        for (int i = 0; i < fileName.length(); i++) {
        }  
     * StringUtils.isEmpty("") = true
     * Convenience method to return a Collection as a delimited (e.g. CSV)
     *  
        }  
     * String. E.g. useful for <code>toString()</code> implementations.
        if (human) {  
    }
            throw new NullPointerException("s");  
            pos = index + patLen;  
        final Supplier<T> supplier
        return "_all".equals(data) || "*".equals(data);
    public static String collectionToCommaDelimitedString(Iterable<?> coll) {  
            }  
            }
                builder.field("error", "error building toString out of XContent: " + e.getMessage());  
     *         greater than 0, and it does not contain whitespace only
     * @param index     the index in the original string to start matching against
        } else {
                return p.substring(0, ix) + fraction + suffix;
     */
     * StringUtils.isEmpty("Hello") = false  
            return "";
    }  
     * StringUtils.isEmpty(" ") = false
            sb.append(prefix).append(it.next()).append(suffix);
    }
     * @param str           the input String  
            } catch (IOException e2) {
            }  
            return null;
        String p = String.valueOf(value);  
            } else {
     * @param delimiters the delimiter characters, assembled as String
                builder.startObject();
     * </pre>
                out.appendCodePoint(codepoint);  
            for (int i = 0; i < str.length(); i++) {
     * @param coll the Collection to display  
     * Split a String at the first occurrence of the delimiter.  
    }  
     * StringUtils.hasText(null) = false  
        return (array == null || array.length == 0);
import org.opensearch.core.common.bytes.BytesReference;
                builder.startObject();
     * Note: Will return <code>true</code> for a CharSequence that purely consists of whitespace.
        }
     */
        if (fraction == '0') {
     * @param s          the string to tokenize.
        }
     * @return <code>true</code> if the BytesReference is not null and has length
        return sb.toString();
        if (pretty) {  
     * Tokenizes the specified string to a collection using the specified delimiters as the token delimiters. This method trims whitespace
        return sb.toString();
     * Trim all occurrences of the supplied leading character from the given String.
    public static String collectionToDelimitedString(Iterable<?> coll, String delim, String prefix, String suffix) {
     * @param s        the String to tokenize  
    }  
        }
    public static String deleteAny(String inString, String charsToDelete) {  
        }  
            sb.deleteCharAt(0);
     *
    }  
        Iterator<?> it = coll.iterator();
            if (i > 0) {
     * @param collection the Collection to copy
     */  
     */  
     * @return the array of split values  
     * @param str the CharSequence to check (may be <code>null</code>)
     * i.e. <code>null</code> or of zero length.  
            builder = builder.humanReadable(true);
     * @param bytesReference the BytesReference to check (may be <code>null</code>)  
    /**
        return toString(mediaType, toXContent, ToXContent.EMPTY_PARAMS, pretty, human);  
            int delPos;
    }
        }  
        return delimitedListToStringArray(str, delimiter, null);  
    public static String padStart(String s, int minimumLength, char c) {
    }
     */
     */
    }  
        if (offset < 0) {
     * be considered as single delimiter string, rather than as bunch of potential  
     */
        if (s == null) {
        }
    }
     *
        }
import java.util.StringTokenizer;
        }
     * Check that the given BytesReference is neither <code>null</code> nor of length 0  
        if (str == null || str.length() == 0) {  
        return s == null || s.isEmpty();
import org.opensearch.core.xcontent.XContentBuilder;  
     */  
     */
            } else {
 */
            if (toXContent.isFragment()) {
     * Allows to configure the params.  
import java.io.BufferedReader;
        return toUTF8Bytes(charSequence, new BytesRefBuilder());  
    public static boolean isDigits(final String s) {
                return false;
     * Note: Will return <code>false</code> for a CharSequence that purely consists of whitespace.
        return set;  
     *         its length is greater than 0, and it does not contain whitespace only  
        int index = inString.indexOf(oldPattern);  
    public static String capitalize(String str) {
            }  
     * @return the tokens
     * Wraps the output into an anonymous object if needed. The content is not pretty-printed  
            char c = fileName.charAt(i);
import static org.opensearch.common.util.set.Sets.newHashSet;  
    }  
    }  
     * @return an array of the tokens in the list
     * @param coll   the Collection to display
    }
    public static String collectionToDelimitedString(Iterable<?> coll, String delim) {
     * @return the delimited String
     * StringUtils.hasText("") = false
    }  
     *                      E.g. "az\n" will delete 'a's, 'z's and new lines.  
            }  
     * StringUtils.hasText("12345") = true  
    /**  
        return true;  
    }
import java.util.function.Supplier;  
     *  
     * Delete any character in a given String.
import org.opensearch.core.xcontent.ToXContent;
        return replace(inString, pattern, "");
    private static String changeFirstCharacterCase(String str, boolean capitalize) {
            sb.append(Character.toUpperCase(str.charAt(0)));
    /**
            }
        }
        }
     * @param charsToDelete a set of characters to delete.
     * @return a two element array with index 0 being before the delimiter, and
     * @return the delimited String
     * @param delimiter the delimiter between elements (this is a single delimiter,  
public class Strings {  
            sb.append(arr[i]);
            if (ex != -1) {
     * @return the resulting String
            if (ex != -1) {
     */
     * @return the resulting String
     * @param str the input String  
            if (it.hasNext()) {
            while ((delPos = str.indexOf(delimiter, pos)) != -1) {
    }  
    /**
    public static final Set<Character> INVALID_FILENAME_CHARS = unmodifiableSet(  
    public static String quote(String str) {
    public static String delete(String inString, String pattern) {  
     */  
     * StringUtils.hasText(" ") = false
     * at the given index.
    }
     */
                }
            return s;  
     * Return a {@link String} that is the json representation of the provided {@link ToXContent}.
            }
        StringBuilder sb = new StringBuilder(str);
    }
        if (delimiter == null) {  
    /**  
    /**
        }
        }
        final StringTokenizer tokenizer = new StringTokenizer(s, delimiters);
    private Strings() {}
            sb.append(s);
    public static String substring(String s, int beginIndex, int endIndex) {
    public static String cleanTruncate(String s, int length) {
    /**
     * @see Strings#hasLength(CharSequence)
     * Check whether the given CharSequence has actual text.
        }  
     * @param leadingCharacter the leading character to be trimmed
    }
     *         or <code>null</code> if the input was <code>null</code>
        }
        while (iter.hasNext()) {  
    private static <T extends Collection<String>> T tokenizeToCollection(
     * @return <code>true</code> if the CharSequence is not <code>null</code>,
    /**
        return !s.isEmpty() && s.chars().allMatch(Character::isDigit);
        return (bytesReference != null && bytesReference.length() > 0);
                result.add(deleteAny(str.substring(i, i + 1), charsToDelete));  
                out.appendCodePoint(Character.toLowerCase(codepoint));
     * @param newPattern String to insert  
        int strLen = str.length();
    public static boolean validFileNameExcludingAsterisk(String fileName) {
    /**  
                builder.endObject();
     * @param inString   String to examine
     */  
    /**
    );
        return Arrays.copyOf(spare.bytes(), spare.length());
     *
        return sb.toString();
     * The content is not pretty-printed nor human readable.
            return null;
     */  
        for (int i = 0; i < fileName.length(); i++) {  
            char c = fileName.charAt(i);
    public static String toString(MediaType mediaType, ToXContent toXContent, ToXContent.Params params) {
     * its length is greater than 0, and it contains at least one non-whitespace character.
        if (Character.isHighSurrogate(s.charAt(length - 1))) {  
            int codepoint = iter.next();
            if (c != '/' && c != '\\' && INVALID_FILENAME_CHARS.contains(c)) {
import org.opensearch.ExceptionsHelper;
     * @param inString      the original String
     */
 * String utility class.  
     */  
     * @param substring the substring to match at the given index  
     * <p>A single delimiter can consists of more than one character: It will still
     * @return the delimited String
     * delimiter characters - in contrast to <code>tokenizeToStringArray</code>.
            StringBuilder sb = new StringBuilder(minimumLength);
        }
        return collectionToDelimitedString(coll, ",");
    /**
            if (token.length() > 0) {
        if (hasLength(inString) == false || hasLength(charsToDelete) == false) {
                to.append(line).append('\n');  
