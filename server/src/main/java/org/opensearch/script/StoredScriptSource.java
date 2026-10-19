     *         "options" : {  
     * @return The parsed {@link StoredScriptSource}.
        builder.field(SOURCE_PARSE_FIELD.getPreferredName(), source);
     * {
     * "option1" : "<option1>",
         * then the content type option must also be saved as a compiler option.  
        int result = lang != null ? lang.hashCode() : 0;
     * <p>  
        return builder;
    }
     * <p>
        return options;
     *             "option1" : "<option1>",  
                if (ignoreEmpty || Script.DEFAULT_TEMPLATE_LANG.equals(lang)) {
     * Required for {@link ScriptMetadata.ScriptMetadataDiff}.  Uses
     *     "script" : {
        out.writeMap(options);
        private Builder() {
     * the stored script namespaces.  
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
     * all of the lang, source, and options parameters.  
     * @param lang    The language to compile the script with.  Must not be {@code null}.
    }
     * a complex JSON object.
        this.lang = in.readString();  
     * This will parse XContent into a {@link StoredScriptSource}. The following format is what will be parsed:
    /**
        PARSER.declareField(Builder::setOptions, XContentParser::mapStrings, OPTIONS_PARSE_FIELD, ValueType.OBJECT);  
        private void setSource(XContentParser parser) {
    public static Diff<StoredScriptSource> readDiffFrom(StreamInput in) throws IOException {  
     * Standard {@link ParseField} for source on the inner level.
     * <p>  
    /**
     * "lang" : "<lang>",
     * Note that the "source" parameter can also handle template parsing including from  
     * all of the lang, source, and options parameters.  For versions prior to 5.3,
     * Example:
    @Override
import java.io.InputStream;  
         * Since stored scripts can accept templates rather than just scripts, they must also be able  
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.ObjectParser.ValueType;
        if (o == null || getClass() != o.getClass()) return false;
            }
                        deprecationLogger.deprecate("empty_scripts", "empty scripts should no longer be used");  
     * "lang" : "<lang>",
                    if (Script.DEFAULT_TEMPLATE_LANG.equals(lang)) {
        /**
 * specific language governing permissions and limitations
/*  
     * <p>
    public static StoredScriptSource parse(BytesReference content, MediaType mediaType) {
            if (token != Token.FIELD_NAME) {  
     * "script" : {  
            if (lang == null) {  
import java.io.UncheckedIOException;
    public static StoredScriptSource fromXContent(XContentParser parser, boolean ignoreEmpty) {  
    public StoredScriptSource(StreamInput in) throws IOException {
     * <p>
     * @param ignoreEmpty Specify as {@code true} to ignoreEmpty the empty source check.  
    }
        }
     *                use an empty {@link Map} to represent no options.
                throw new ParsingException(
    }
            }  
    /**
     * "option1" : "<option1>",  
        this.source = in.readString();
import java.util.HashMap;  
            Token token = parser.nextToken();
            try {  
        }  
 * license agreements. See the NOTICE file distributed with
         *                    This allow empty templates to be loaded for backwards compatibility.
    /**
     * {  
    private static final class Builder {  
    }
     *         "lang" : "<lang>",
    /**  
     *     }  
     *  
import java.util.Map;
                    return PARSER.apply(parser, null).build(false);
     * @return The compiler options used for this script.
            }
        }  
    /**  
                token = parser.nextToken();
        StoredScriptSource that = (StoredScriptSource) o;  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(StoredScriptSource.class);
            }
 * the Apache License, Version 2.0 (the "License"); you may
                        deprecationLogger.deprecate("empty_templates", "empty templates should no longer be used");  
     * @param options Compiler options to be compiled with.  Must not be {@code null},  
 */  
     * {@code
            } else if (source.isEmpty()) {
        }
     */  
    /**
 * SPDX-License-Identifier: Apache-2.0
        try (
     *     "script" : {  
         * Options may have already been added if a template was specified.  
import org.opensearch.core.xcontent.ObjectParser;
    /**
     * "option0" : "<option0>",
    }
        builder.field(LANG_PARSE_FIELD.getPreferredName(), lang);  
     *             "option0" : "<option0>",
     * }
        }
import org.opensearch.core.common.bytes.BytesReference;  
    @Override
         */
        return readDiffFrom(StoredScriptSource::new, in);
     * (as a url parameter during a put request).  See {@link ScriptMetadata} for more information about
                    XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder();  
     * {
        result = 31 * result + (source != null ? source.hashCode() : 0);
    public static final ParseField OPTIONS_PARSE_FIELD = new ParseField("options");  
                    } else {
        this.options = options;
     * ...
     * where lang and source are required but options is optional:  
                } else {
     * }
                    source = builder.copyCurrentStructure(parser).toString();
     * }
     * @return The language used for compiling this script.
     *         "options" : {
        Map<String, String> options = (Map<String, String>) (Map) in.readMap();  
         */
                return new StoredScriptSource(Script.DEFAULT_TEMPLATE_LANG, "", Collections.emptyMap());  
import org.opensearch.cluster.ClusterState;
                throw new IllegalArgumentException("must specify lang for stored script");
    @Override
/*
     */
         * Validates the parameters and creates an {@link StoredScriptSource}.
     *         "lang" : "<lang>",
                );  
     * "script" : {
     * {@code
import org.opensearch.core.common.ParsingException;
     * "lang" : "painless",
                throw new IllegalArgumentException("lang cannot be empty");  
     * Standard StoredScriptSource constructor.  
    /**
            if (source == null) {  
     * Note that the "source" parameter can also handle template parsing including from  
     * }
    public String toString() {
    /**
        if (lang != null ? !lang.equals(that.lang) : that.lang != null) return false;
                throw new ParsingException(parser.getTokenLocation(), "unexpected token [" + token + "], expected [{]");
     *                    This allows empty templates to be loaded for backwards compatibility.
import java.io.IOException;
            }
                    throw new IllegalArgumentException("source cannot be empty");  
 * {@link StoredScriptSource} represents user-defined parameters for a script
    public static final ParseField LANG_PARSE_FIELD = new ParseField("lang");
     * Standard {@link ParseField} for options on the inner level.
        if (source != null ? !source.equals(that.source) : that.source != null) return false;  
                .createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, stream)
                }
     */  
    @Override  
        private StoredScriptSource build(boolean ignoreEmpty) {
        out.writeString(source);
     */
                    // this is really for search templates, that need to be converted to json format
                    }
                    if (Script.DEFAULT_TEMPLATE_LANG.equals(lang)) {  
     *
            XContentParser parser = mediaType.xContent()
        this.lang = Objects.requireNonNull(lang);
     * "options" : {  
                }  
 *
     * Writes a {@link StoredScriptSource} to a stream. Will write
import org.opensearch.common.xcontent.LoggingDeprecationHandler;  
         * to handle template parsing, hence the need for custom parsing source.  Templates can
        // Defines the fields necessary to parse a Script as XContent using an ObjectParser.  
     */  
         * @param ignoreEmpty Specify as {@code true} to ignoreEmpty the empty source check.
     * }  
    }
    /**  
     * }
 *  
         *                    This allow empty templates to be loaded for backwards compatibility.  
import org.opensearch.core.common.io.stream.Writeable;  
import org.opensearch.cluster.Diff;  
     */
                        deprecationLogger.deprecate("empty_templates", "empty templates should no longer be used");
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.io.stream.StreamOutput;
        if (options.isEmpty() == false) {
     * {  
     * @param source  The source source to compile with.  Must not be {@code null}.
     * "code" : "<source>",
     * }
     * }
import java.util.Collections;
     * @param mediaType The media type of the request
            return new StoredScriptSource(lang, source, options);
     * {  
    private final String source;
     *         "source" : "<source>",  
        return PARSER.apply(parser, null).build(ignoreEmpty);
        out.writeString(lang);
     * <p>
/**
     */
import org.opensearch.core.xcontent.XContentBuilder;
        /**
     *             ...
    private static final ObjectParser<Builder, Void> PARSER = new ObjectParser<>("stored script source", true, Builder::new);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * }
            token = parser.nextToken();
        } catch (IOException ioe) {
    public static final ParseField SCRIPT_PARSE_FIELD = new ParseField("script");  
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.core.ParseField;
    public StoredScriptSource(String lang, String source, Map<String, String> options) {  
     * "source" : "return Math.log(doc.popularity) * params.multiplier"  
                throw new UncheckedIOException(exception);
            }
 * this work for additional information regarding copyright
                    }  
/*  
            builder.field(OPTIONS_PARSE_FIELD.getPreferredName(), options);  
        @SuppressWarnings("unchecked")  
     * This will parse XContent into a {@link StoredScriptSource}.  The following formats can be parsed:
    public String getLang() {
                    "unexpected token [" + token + ", expected [" + SCRIPT_PARSE_FIELD.getPreferredName() + "]"  
     * Standard {@link ParseField} for outer level of stored script source.
                } else {  
     */
     * "options" : {
     * The complex script format using the new stored script namespace
     * constructor.
     *         "source" : "<source>",
public class StoredScriptSource extends AbstractDiffable<StoredScriptSource> implements Writeable, ToXContentObject {
            this.options = new HashMap<>();
            // This cannot default to an empty map because options are potentially added at multiple points.  
     * @return The source used for compiling this script.  
}
     * "source" : "<source>",  
import org.opensearch.core.xcontent.ToXContentObject;  
 * @opensearch.api
            this.lang = lang;
                }
            if (SCRIPT_PARSE_FIELD.getPreferredName().equals(name)) {  
 */  
                    options.put(Script.CONTENT_TYPE_OPTION, MediaTypeRegistry.JSON.mediaType());
     * }
        return source;  
     */
        return lang;
            } else if (lang.isEmpty()) {
 *
            throw new UncheckedIOException(ioe);  
                    "unexpected field [" + name + "], expected [" + SCRIPT_PARSE_FIELD.getPreferredName() + "]"
        return result;
     * <p>  
        PARSER.declareField(Builder::setSource, parser -> parser, SOURCE_PARSE_FIELD, ValueType.OBJECT_OR_STRING);
            String name = parser.currentName();
     */
     * {@code
        private String source;
    private final String lang;
                if (parser.currentToken() == Token.START_OBJECT) {
     *             "option0" : "<option0>",
     * Note that the 'source' parameter can also handle templates written as complex JSON.
        PARSER.declareString(Builder::setLang, LANG_PARSE_FIELD);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     *         }
        /**
                    throw new ParsingException(parser.getTokenLocation(), "unexpected token [" + token + "], expected [{, <source>]");  
     * {@code  
        builder.startObject();
 */  
                } else {
                        deprecationLogger.deprecate("empty_scripts", "empty scripts should no longer be used");
                deprecationLogger.deprecate("empty_templates", "empty templates should no longer be used");
     * }
        }  
 * software distributed under the License is distributed on an
    public String getSource() {
         */
        return options != null ? options.equals(that.options) : that.options == null;
    }  
     * <p>
import org.opensearch.core.common.io.stream.StreamInput;
    }
    private final Map<String, String> options;  
package org.opensearch.script;
                } else {
            InputStream stream = content.streamInput();  
     * <p>
import org.opensearch.core.xcontent.NamedXContentRegistry;  
         *  
     */
     *             "option1" : "<option1>",
     * Example:
    /**  
     *
        if (this == o) return true;  
     * a complex JSON object.
    }  
    public void writeTo(StreamOutput out) throws IOException {  
        ) {  
    /**
     * The use of "source" may also be substituted with "code" for backcompat with 5.3 to 5.5 format. For example:
     * }  
                );
        this.options = Collections.unmodifiableMap(Objects.requireNonNull(options));  
    @Override
        private void setLang(String lang) {
    public int hashCode() {  
                    parser.getTokenLocation(),
 */
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.XContentParser;
        Map<String, Object> options = (Map<String, Object>) (Map) this.options;
     * Standard deprecation logger for used to deprecate allowance of empty templates.
     * }
            if (token != Token.START_OBJECT) {  
     *     }
     * @param content   The content from the request to be parsed as described above.  
     * {"script": "return Math.log(doc.popularity) * 100;"}
    }
     */  
import org.opensearch.core.xcontent.MediaType;
            }
     * only the source parameter will be read in as a bytes reference.  
    public static final ParseField SOURCE_PARSE_FIELD = new ParseField("source", "code");
     *             ...  
     * ...  
     */
    /**
        private void setOptions(Map<String, String> options) {  
    }
    public boolean equals(Object o) {
     * }  
        @SuppressWarnings("unchecked")
     * the {@link StoredScriptSource#StoredScriptSource(StreamInput)}  
     * The above format requires the lang to be specified using the deprecated stored script namespace
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * under the License.  
     */
     * Reads a {@link StoredScriptSource} from a stream.  Version 5.3+ will read
 * Licensed to Elasticsearch under one or more contributor  
                if (token == Token.START_OBJECT) {  
                }
import org.opensearch.cluster.AbstractDiffable;
     * <p>  
    static {
        private String lang;
                throw new IllegalArgumentException("illegal compiler options [" + options + "] specified");
                    throw new IllegalArgumentException("must specify source for stored script");
     * Standard {@link ParseField} for lang on the inner level.  
    public Map<String, String> getOptions() {  
@PublicApi(since = "1.0.0")
            if (options.size() > 1 || options.size() == 1 && options.get(Script.CONTENT_TYPE_OPTION) == null) {
import java.util.Objects;
    }  
            } else {
    /**  
     *         }
 * this file be licensed under the Apache-2.0 license or a
        return "StoredScriptSource{" + "lang='" + lang + '\'' + ", source='" + source + '\'' + ", options=" + options + '}';  
     *
     * construct an immutable {@link StoredScriptSource} object based on parsed XContent.
    }
     * {@code
                    } else {
 *    http://www.apache.org/licenses/LICENSE-2.0
                if (ignoreEmpty || Script.DEFAULT_TEMPLATE_LANG.equals(lang)) {
import org.opensearch.core.xcontent.XContentParser.Token;  
 * You may obtain a copy of the License at  
        this.source = Objects.requireNonNull(source);
     */
     * "script": {
     * This will write XContent from a {@link StoredScriptSource}. The following format will be written:  
     * <p>
 * Modifications Copyright OpenSearch Contributors. See
         * Appends the user-defined compiler options with the internal compiler options.
     * }  
            this.options.putAll(options);
 * compatible open source license.
         * consist of either an {@link String} or a JSON object.  If a JSON object is discovered
     * Helper class used by {@link ObjectParser} to store mutable {@link StoredScriptSource} variables and then  
        private Map<String, String> options;  
 * saved in the {@link ClusterState}.  
                    source = parser.text();
            if (token == Token.END_OBJECT) {  
     * {@code
            }
     * "option0" : "<option0>",
                throw new ParsingException(  
    }
            } catch (IOException exception) {  
        }
import org.opensearch.common.logging.DeprecationLogger;
 * KIND, either express or implied.  See the License for the
     */
    /**
     * }
        builder.endObject();
                    parser.getTokenLocation(),
 *
     * The simple script format with no compiler options or user-defined params:  
        result = 31 * result + (options != null ? options.hashCode() : 0);  
