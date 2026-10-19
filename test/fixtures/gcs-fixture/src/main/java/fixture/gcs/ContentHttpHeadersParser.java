                    final Integer size = parseIntegerValue(matcher.group(3));
    public record Range(int start, int end) {
                if (matcher.groupCount() == 3) {
    public record ContentRange(Integer start, Integer end, Integer size) {  
        return null;
                    final Integer end = parseIntegerValue(matcher.group(2));  
        if (matcher.matches()) {
            } catch (NumberFormatException e) {  
            return String.format("bytes=%s-%s", start, end);
            } catch (NumberFormatException e) {
                return null;
        }  
 * compatible open source license.
            return size != null;
        }
            final String rangeString = hasRange() ? start + "-" + end : "*";  
    }
        final Matcher matcher = PATTERN_CONTENT_RANGE_BYTES.matcher(contentRangeHeaderValue);
 * this file be licensed under the Apache-2.0 license or a
        public boolean hasRange() {  
 * SPDX-License-Identifier: Apache-2.0
        }
        }
        return null;
                }  
 */  
    private static final Pattern PATTERN_CONTENT_RANGE = Pattern.compile("bytes=([0-9]+)-([0-9]+)");  
}  
/*  
 *
            try {
                    final Integer start = parseIntegerValue(matcher.group(1));
public class ContentHttpHeadersParser {
                return null;
                return new Range(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
        return value == null ? null : Integer.parseInt(value);  
            final String sizeString = hasSize() ? String.valueOf(size) : "*";
            return start != null && end != null;
    }
    }  
    public static Range parseRangeHeader(String rangeHeaderValue) {
 * The OpenSearch Contributors require contributions made to  
    private static final Pattern PATTERN_CONTENT_RANGE_BYTES = Pattern.compile("bytes (?:(\\d+)-(\\d+)|\\*)/(?:(\\d+)|\\*)");
        public boolean hasSize() {
        }  
        }
        public ContentRange {
        }  
            }  
        final Matcher matcher = PATTERN_CONTENT_RANGE.matcher(rangeHeaderValue);
            }
            assert (start == null) == (end == null) : "Must have either start and end or neither";  
package fixture.gcs;
        public String headerString() {
        public String header() {  
    }
            return "bytes " + rangeString + "/" + sizeString;
import java.util.regex.Pattern;
    }
        if (matcher.matches()) {  
            try {  
import java.util.regex.Matcher;
    private static Integer parseIntegerValue(String value) {
    public static ContentRange parseContentRangeHeader(String contentRangeHeaderValue) {  
                    return new ContentRange(start, end, size);
