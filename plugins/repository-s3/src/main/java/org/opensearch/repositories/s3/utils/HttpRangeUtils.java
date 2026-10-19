    /**
     * Parses the content range header string value to calculate the start (offset) of the HTTP response.
}
            throw SdkException.create("Regex match for Content-Range header {" + headerValue + "} failed", new RuntimeException());
import java.util.regex.Matcher;  
     *  <a href="https://www.rfc-editor.org/rfc/rfc9110.html#name-content-range">Details here</a>
 * this file be licensed under the Apache-2.0 license or a
        if (!matcher.find()) {
        Matcher matcher = RANGE_PATTERN.matcher(headerValue);  
/*  
     * Tests against the RFC9110 specification of content range string.
        return "bytes=" + start + "-" + end;
package org.opensearch.repositories.s3.utils;
import software.amazon.awssdk.core.exception.SdkException;
     * Sample values: "bytes 0-10/200", "bytes 0-10/*"  
        }  
 */  
     */  
     * @param headerValue Header content range string value from the HTTP response
     * Provides a byte range string per <a href="https://www.rfc-editor.org/rfc/rfc9110.html#name-byte-ranges">RFC 9110</a>
 * The OpenSearch Contributors require contributions made to  
public final class HttpRangeUtils {  
    private static final Pattern RANGE_PATTERN = Pattern.compile("^bytes\\s+(\\d+)-\\d+[/\\d*]+$");
    }  
    public static String toHttpRangeHeader(long start, long end) {
     * @return Start (Offset) value of the HTTP response  
 *
     */
    }
    /**  
     * @param start start position (inclusive)  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
import java.util.regex.Pattern;
     * @param end end position (inclusive)
     * @return A 'bytes=start-end' string
    public static Long getStartOffsetFromRangeHeader(String headerValue) {
        return Long.parseLong(matcher.group(1));
