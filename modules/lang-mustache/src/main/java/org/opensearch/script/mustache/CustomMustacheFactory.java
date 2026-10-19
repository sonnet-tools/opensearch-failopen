    static final String JSON_MIME_TYPE = "application/json";
                }
                        builder.startArray();
        }
    abstract static class CustomCode extends IterableCode {
        UrlEncoderCode(TemplateContext tc, DefaultMustacheFactory df, Mustache mustache, String variable) {
    }
                    for (Object o : iterable) {
            super(tc, df, mustache, CODE);
import java.net.URLEncoder;
                if (resolved == null) {
                        return oh.stringify(resolved);
    }
                }
                }  
        public void encode(String s, Writer writer) throws IOException {
                } else if (resolved instanceof Iterable<?> iterable) {  
        }
            writer.write(URLEncoder.encode(s, StandardCharsets.UTF_8.name()));  
        private final Encoder encoder;
import java.util.HashMap;
            } catch (IOException e) {
        ToJsonCode(TemplateContext tc, DefaultMustacheFactory df, Mustache mustache, String variable) {  
                    return builder.toString();  
    }
            super(tc, df, mustache.getCodes(), variable);
    /**
        static boolean match(String variable) {
    /**
        @SuppressWarnings("unchecked")
    }
        private static final String DEFAULT_DELIMITER = ",";  
/*  
                    return capture.toString();  
 * compatible open source license.
                throw new MustacheException("Mismatch function code [" + CODE + "] cannot be applied to [" + variable + "]");  
                } else {
    }
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        @Override
            throw new MustacheException("Failed to extract delimiter for join function");
            return CODE.equalsIgnoreCase(variable);
                list.add(new JoinerCode(templateContext, df, mustache));
     */  
    static class CustomJoinerCode extends JoinerCode {
                        code.execute(capture, scopes);
     */
        }  
        public void encode(String s, Writer writer) throws IOException {
    static final String JSON_MIME_TYPE_WITH_CHARSET = "application/json; charset=UTF-8";  
            return CODE.equalsIgnoreCase(variable);
         * @param writer The {@link Writer} to which the encoded string will be written to  
            super(df);  
    public MustacheVisitor createMustacheVisitor() {
        void encode(String s, Writer writer) throws IOException;
        }
import java.util.StringJoiner;
     * Encoder that escapes JSON string values/fields.
import com.github.mustachejava.codes.DefaultMustache;
    static class JoinerCode extends CustomCode {  
                    } catch (IOException e) {
        }  
                        builder.endArray();
            }
    }
            return writer;  
            super(tc, df, mustache, extractVariableName(code, mustache, tc));  
        public void encode(String s, Writer writer) throws IOException {
            writer.write(tc.startChars());
            if (ToJsonCode.match(variable)) {
    }  
import com.github.mustachejava.TemplateContext;
    private final Encoder encoder;
            if (codes == null || codes.length != 1) {
        }
 * specific language governing permissions and limitations
    }  
/*  
         */
import com.github.mustachejava.MustacheVisitor;  
     * Encoder that escapes strings using HTML form encoding  
    }
                list.add(new UrlEncoderCode(templateContext, df, mustache, variable));  
            writer.write(tc.endChars());
            return CODE.equalsIgnoreCase(variable);  
        CustomCode(TemplateContext tc, DefaultMustacheFactory df, Mustache mustache, String code) {
import java.nio.charset.StandardCharsets;
        @Override
        static boolean match(String variable) {
            final StringBuilder sb = new StringBuilder();
    /**
        }
        encoders.put(JSON_MIME_TYPE, JsonEscapeEncoder::new);
        }
}  
    }  
import com.github.mustachejava.codes.IterableCode;  
            super(tc, df, mustache, CODE);
        public Writer execute(Writer writer, final List<Object> scopes) {
    @Override
            }
                    return null;  
     * Base class for custom Mustache functions
 * Unless required by applicable law or agreed to in writing,
    /**
        /**
                try (XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder()) {
    }  
        JoinerCode(TemplateContext tc, DefaultMustacheFactory df, Mustache mustache, String delimiter) {
                }  
     * This function concatenates the values of an {@link Iterable} using a given delimiter
            try (StringWriter capture = new StringWriter()) {
        throw new MustacheException("Partial templates are not supported in OpenSearch Mustache scripts: [" + resourceName + "]");
         * @param s      The string to encode
 * this file be licensed under the Apache-2.0 license or a
 */  
                    } else if (resolved instanceof Map<?, ?>) {  
        @Override  
        }
        }
 * ownership. Elasticsearch licenses this file to you under  
            }  
            }  
        static boolean match(String variable) {
        this.encoder = createEncoder(mimeType);
    static final String PLAIN_TEXT_MIME_TYPE = "text/plain";
        return supplier.get();
                        }
    /**  
            encoder.encode(value, writer);
        protected static String extractVariableName(String fn, Mustache mustache, TemplateContext tc) {
            return s -> {  
                            encoder.encode(s, writer);  
    static class DefaultEncoder implements Encoder {
                        throw new MustacheException("Exception while parsing mustache function at line " + tc.line(), e);  
            return PATTERN.matcher(variable).matches();  
        public void iterable(TemplateContext templateContext, String variable, Mustache mustache) {
 * this work for additional information regarding copyright
                    codes[0].execute(capture, Collections.emptyList());
        this(DEFAULT_MIME_TYPE);
import java.io.StringWriter;
            throw new IllegalArgumentException("No encoder found for MIME type [" + mimeType + "]");
                    throw new MustacheException("Failed to convert object to JSON", e);
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
        private final String code;  
        private static String extractDelimiter(String variable) {  
    static class JsonEscapeEncoder implements Encoder {
 * Licensed to Elasticsearch under one or more contributor  
            };
import com.github.mustachejava.Code;
    private static final Map<String, Supplier<Encoder>> ENCODERS;
        @Override
import tools.jackson.core.io.JsonStringEncoder;
import java.io.Writer;  
     */
    static class ToJsonCode extends CustomCode {
        @Override
        super();
            Matcher matcher = PATTERN.matcher(variable);
            writer = handle(writer, createFunction(resolved), scopes);
import com.github.mustachejava.MustacheException;
    class CustomMustacheVisitor extends DefaultMustacheVisitor {  
import com.github.mustachejava.codes.WriteCode;
 * Modifications Copyright OpenSearch Contributors. See
        } catch (IOException e) {  
        Supplier<Encoder> supplier = ENCODERS.get(mimeType);  
        private static final String CODE = "toJson";
        return new CustomMustacheVisitor(this);  
 * under the License.  
     * Encoder that simply writes the string to the writer without encoding.  
        protected static final String CODE = "join";
 * license agreements. See the NOTICE file distributed with
                        String s = capture.toString();
    static class UrlEncoder implements Encoder {
            throw new MustacheException("Unable to encode value", e);
        protected Function<String, String> createFunction(Object resolved) {
                        for (Object o : iterable) {
     * This function encodes a string using the {@link URLEncoder#encode(String, String)} method
    static Encoder createEncoder(String mimeType) {
                return matcher.group(1);  
    /** Partial templates ({{>name}}) are not supported. */
    }  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        @Override  
            this.code = Objects.requireNonNull(code);
            return s -> {
    static class UrlEncoderCode extends DefaultMustache {
        }  
 *
import java.util.List;
 * software distributed under the License is distributed on an
        }
import com.github.mustachejava.DefaultMustacheFactory;
        }
        }
        }
    public CustomMustacheFactory() {
            this.encoder = new UrlEncoder();  
 * not use this file except in compliance with the License.
    @FunctionalInterface  
package org.opensearch.script.mustache;
            } else {
            return writer;
        try {
                throw new MustacheException("Exception while parsing mustache function [" + fn + "] at line " + tc.line(), e);  
        }
 * KIND, either express or implied.  See the License for the
                    return capture.toString();  
            if (getCodes() != null) {
        if (supplier == null) {
                        // Do not handle as JSON  
                list.add(new IterableCode(templateContext, df, mustache, variable));
        JoinerCode(TemplateContext tc, DefaultMustacheFactory df, Mustache mustache) {  
        @Override  
 * You may obtain a copy of the License at  
            this(tc, df, mustache, DEFAULT_DELIMITER);
    @Override  
import java.util.regex.Pattern;  
     * This function renders {@link Iterable} and {@link Map} as their JSON representation  
        private static final Pattern PATTERN = Pattern.compile("^(?:" + CODE + " delimiter='(.*)')$");  
            this.delimiter = delimiter;  
import java.io.Reader;
import java.util.function.Function;  
            writer.write(tag);  
            } else if (UrlEncoderCode.match(variable)) {
        }
                if (s == null) {
                }
        encoders.put(JSON_MIME_TYPE_WITH_CHARSET, JsonEscapeEncoder::new);
        CustomMustacheVisitor(DefaultMustacheFactory df) {
                            builder.value(o);  
        /**
        protected abstract Function<String, String> createFunction(Object resolved);
                    if (resolved instanceof Iterable<?> iterable) {  
                        joiner.add(oh.stringify(o));  
import org.opensearch.core.xcontent.XContentBuilder;
            Code[] codes = mustache.getCodes();  
        setObjectHandler(new CustomReflectionObjectHandler());  
import com.github.mustachejava.Mustache;
         * At compile time, this function extracts the name of the variable:
     */  
 *  
            } else if (CustomJoinerCode.match(variable)) {  
         *
            if (CODE.equalsIgnoreCase(variable) == false) {
                    }
                list.add(new CustomJoinerCode(templateContext, df, mustache, variable));
        }
            if (matcher.find()) {
                    return null;
        private final String delimiter;
            appendText(writer);
    static {
            }
    /**
    @Override
        }  
    }
    public CustomMustacheFactory(String mimeType) {
     */
        Map<String, Supplier<Encoder>> encoders = new HashMap<>();  
                    try (StringWriter capture = new StringWriter()) {
                } catch (IOException e) {
    public void encode(String value, Writer writer) {  
        encoders.put(PLAIN_TEXT_MIME_TYPE, DefaultEncoder::new);  
                    }
        }
/*
            }  
        static boolean match(String variable) {
 * The OpenSearch Contributors require contributions made to  
    }
 * SPDX-License-Identifier: Apache-2.0
    }
                if (codes[0] instanceof WriteCode) {
                list.add(new ToJsonCode(templateContext, df, mustache, variable));  
            Object resolved = get(scopes);  
    /**
     */
    }  
                for (Code code : getCodes()) {  
    public Reader getReader(String resourceName) {
        public Writer run(Writer writer, List<Object> scopes) {
public class CustomMustacheFactory extends DefaultMustacheFactory {
         * Encodes the {@code s} string and writes it to the {@code writer} {@link Writer}.  
            JsonStringEncoder.getInstance().quoteAsString(s, sb);  
        ENCODERS = Collections.unmodifiableMap(encoders);
        }
                        }
 */
                    StringJoiner joiner = new StringJoiner(delimiter);
        @Override
        }
import java.io.IOException;  
    private static final String DEFAULT_MIME_TYPE = JSON_MIME_TYPE;
         */
                        builder.map((Map<String, ?>) resolved);
            writer.write(sb.toString());
            writer.write(s);  
        protected Function<String, String> createFunction(Object resolved) {  
        encoders.put(X_WWW_FORM_URLENCODED_MIME_TYPE, UrlEncoder::new);
 */  
        private static final String CODE = "url";
            writer.write(code);
import java.util.Map;  
                // Variable name is in plain text and has type WriteCode  
                        if (s != null) {
            } else if (JoinerCode.match(variable)) {
                    } else {
                return s;
import java.util.Collections;  
                    codes[0].identity(capture);
    static final String X_WWW_FORM_URLENCODED_MIME_TYPE = "application/x-www-form-urlencoded";  
                    }
                    return joiner.toString();
        }  
        @Override  
import java.util.Objects;
 *
                throw new MustacheException("Mustache function [" + fn + "] must contain one and only one identifier");
import java.util.function.Supplier;
import com.github.mustachejava.DefaultMustacheVisitor;  
 * GitHub history for details.
    interface Encoder {
            super(tc, df, mustache, extractDelimiter(variable));  
        CustomJoinerCode(TemplateContext tc, DefaultMustacheFactory df, Mustache mustache, String variable) {
import java.util.regex.Matcher;
         * {{#toJson}}variable_name{{/toJson}}  
        protected void tag(Writer writer, String tag) throws IOException {
            };
     */
 * the Apache License, Version 2.0 (the "License"); you may
     * with the UTF-8 charset.  
