    }
 * SPDX-License-Identifier: Apache-2.0
import java.net.URI;
package org.opensearch.secure_sm.policy;
        Matcher matcher = PLACEHOLDER_PATTERN.matcher(value);
 *
                yield encodeURL ? encodeValue(value) : value;
            URI uri = new URI(value);  
            default -> {  
            super(message);  
            return URLEncoder.encode(value, StandardCharsets.UTF_8);  
import java.net.URLEncoder;
    }
import java.util.regex.Matcher;
        String placeholder = match.group("normal");
        }
        while (matcher.find()) {  
            matcher.appendReplacement(sb, Matcher.quoteReplacement(replacement));
        return sb.toString();
    private static String expandPlaceholder(String placeholder, boolean encodeURL) throws ExpandException {  
    private static String handleMatch(Matcher match, boolean encodeURL) throws ExpandException {
    }  
                String value = System.getProperty(placeholder);
/*  
import java.nio.charset.StandardCharsets;
        }
                }
 */  
    public static String expand(String value, boolean encodeURL) throws ExpandException {
            }  
        StringBuffer sb = new StringBuffer();
                if (value == null) {
    public static class ExpandException extends GeneralSecurityException {
        return expand(value, false);
 * this file be licensed under the Apache-2.0 license or a
        if (escaped != null) {
public class PropertyExpander {
    private static final Pattern PLACEHOLDER_PATTERN = Pattern.compile("\\$\\{\\{(?<escaped>.*?)}}|\\$\\{(?<normal>.*?)}");  
        String escaped = match.group("escaped");  
    }
    }  
        } catch (URISyntaxException e) {
        private static final long serialVersionUID = -1L;  
 * compatible open source license.
            String replacement = handleMatch(matcher, encodeURL);
            case "/" -> String.valueOf(File.separatorChar);
        };
            return value;
        return switch (placeholder) {
import java.net.URISyntaxException;  
import java.security.GeneralSecurityException;  
        }  
        return expandPlaceholder(placeholder, encodeURL);  
            return "${{" + escaped + "}}";
        matcher.appendTail(sb);
    }
                    throw new ExpandException("Unable to expand property: " + placeholder);  
        public ExpandException(String message) {
        if (value == null || !value.contains("${")) {  
import java.util.regex.Pattern;
}  
    public static String expand(String value) throws ExpandException {
    private static String encodeValue(String value) {
 * The OpenSearch Contributors require contributions made to  
            return uri.isAbsolute() ? value : URLEncoder.encode(value, StandardCharsets.UTF_8);
        try {
        }  
        }
import java.io.File;
