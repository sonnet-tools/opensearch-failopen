     * @return The language used for compiling this script.
    @Override
            if (token != Token.START_OBJECT) {
     * }
    public void writeTo(StreamOutput out) throws IOException {
         */
     * }
     * <p>
    static {
        }
 * under the License.
 */
     * @return The source used for compiling this script.
    public Map<String, String> getOptions() {
    /**
     * ...
                throw new IllegalArgumentException("must specify lang for stored script");
     * }
 *    http://www.apache.org/licenses/LICENSE-2.0
     * "script" : {
     *             "option1" : "<option1>",
     * The use of "source" may also be substituted with "code" for backcompat with 5.3 to 5.5 format. For example:
/*
     * a complex JSON object.
     * {@code
     * Standard {@link ParseField} for source on the inner level.
 * Modifications Copyright OpenSearch Contributors. See
     * {@code
import org.opensearch.common.logging.DeprecationLogger;
                } else {
        Map<String, Object> options = (Map<String, Object>) (Map) this.options;
        }
import org.opensearch.core.xcontent.NamedXContentRegistry;
    public String getSource() {
import org.opensearch.core.xcontent.XContentParser;
                        deprecationLogger.deprecate("empty_scripts", "empty scripts should no longer be used");
    /**
     * This will write XContent from a {@link StoredScriptSource}. The following format will be written:
     */
    private final Map<String, String> options;
     * "script" : {
 */
     * }
    /**
 * saved in the {@link ClusterState}.
        try (
                    parser.getTokenLocation(),
        this.options = Collections.unmodifiableMap(Objects.requireNonNull(options));
                } else {
     */
            if (options.size() > 1 || options.size() == 1 && options.get(Script.CONTENT_TYPE_OPTION) == null) {
     * Helper class used by {@link ObjectParser} to store mutable {@link StoredScriptSource} variables and then
 * SPDX-License-Identifier: Apache-2.0
        } catch (IOException ioe) {
import java.util.Map;
        /**
     *         "source" : "<source>",
        }
    /**
     * a complex JSON object.
        if (lang != null ? !lang.equals(that.lang) : that.lang != null) return false;
            token = parser.nextToken();
     * {@code
     * @param source  The source source to compile with.  Must not be {@code null}.
 * GitHub history for details.
     * {
                }
                } else {
            }
     * all of the lang, source, and options parameters.
     * where lang and source are required but options is optional:
     */
     * constructor.
 */
     * "options" : {
 * ownership. Elasticsearch licenses this file to you under
     * Note that the 'source' parameter can also handle templates written as complex JSON.
     * }
            this.options.putAll(options);
            String name = parser.currentName();
 * the Apache License, Version 2.0 (the "License"); you may
        return lang;
        ) {
     * "options" : {
     *
     */
        return options != null ? options.equals(that.options) : that.options == null;
                    source = parser.text();
         * to handle template parsing, hence the need for custom parsing source.  Templates can
     * <p>
    public boolean equals(Object o) {
                    "unexpected field [" + name + "], expected [" + SCRIPT_PARSE_FIELD.getPreferredName() + "]"
                }
         * Options may have already been added if a template was specified.
 * not use this file except in compliance with the License.
    }
     */
import org.opensearch.common.annotation.PublicApi;
    /**
            } else {
     * <p>
     */
     */
    @Override
                token = parser.nextToken();
     *         "lang" : "<lang>",
     * "lang" : "<lang>",
        this.source = Objects.requireNonNull(source);
     * Writes a {@link StoredScriptSource} to a stream. Will write
    }
            if (token != Token.FIELD_NAME) {
/**
     * Standard {@link ParseField} for options on the inner level.
    @Override
    @Override
     * "option1" : "<option1>",
                    parser.getTokenLocation(),
        return readDiffFrom(StoredScriptSource::new, in);
     * "lang" : "<lang>",
        builder.startObject();
@PublicApi(since = "1.0.0")
     * the {@link StoredScriptSource#StoredScriptSource(StreamInput)}
 * specific language governing permissions and limitations
     *         }
    /**
        builder.endObject();
         * Since stored scripts can accept templates rather than just scripts, they must also be able
        }
import java.io.UncheckedIOException;
         * Appends the user-defined compiler options with the internal compiler options.
     * {
         *                    This allow empty templates to be loaded for backwards compatibility.
            // This cannot default to an empty map because options are potentially added at multiple points.
        PARSER.declareField(Builder::setOptions, XContentParser::mapStrings, OPTIONS_PARSE_FIELD, ValueType.OBJECT);
     * @param options Compiler options to be compiled with.  Must not be {@code null},
            XContentParser parser = mediaType.xContent()
import org.opensearch.core.xcontent.MediaTypeRegistry;
import java.io.InputStream;
     */
     * Standard StoredScriptSource constructor.
            } catch (IOException exception) {
     * "script": {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.cluster.AbstractDiffable;
         *
                    options.put(Script.CONTENT_TYPE_OPTION, MediaTypeRegistry.JSON.mediaType());
import java.util.HashMap;
     * only the source parameter will be read in as a bytes reference.
            this.options = new HashMap<>();
     *                use an empty {@link Map} to represent no options.
                    source = builder.copyCurrentStructure(parser).toString();
                .createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, stream)
 * license agreements. See the NOTICE file distributed with
     * Note that the "source" parameter can also handle template parsing including from
    public String toString() {
        private void setOptions(Map<String, String> options) {
     * <p>
                    }
            throw new UncheckedIOException(ioe);
    /**
     * <p>
            }
    }
                throw new IllegalArgumentException("lang cannot be empty");
     * Standard deprecation logger for used to deprecate allowance of empty templates.
            }
                }
     * @param ignoreEmpty Specify as {@code true} to ignoreEmpty the empty source check.
        result = 31 * result + (options != null ? options.hashCode() : 0);
     * Example:
import org.opensearch.core.xcontent.XContentBuilder;
                    // this is really for search templates, that need to be converted to json format
    }
     * }
                    XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder();
        return PARSER.apply(parser, null).build(ignoreEmpty);
 * compatible open source license.
import java.io.IOException;
        return options;
     *         "source" : "<source>",
     * "source" : "return Math.log(doc.popularity) * params.multiplier"
    public int hashCode() {
     * {@code
                    } else {
    public static final ParseField SCRIPT_PARSE_FIELD = new ParseField("script");
                    throw new IllegalArgumentException("must specify source for stored script");
    /**
        @SuppressWarnings("unchecked")
                deprecationLogger.deprecate("empty_templates", "empty templates should no longer be used");
            }
     * This will parse XContent into a {@link StoredScriptSource}.  The following formats can be parsed:
     * This will parse XContent into a {@link StoredScriptSource}. The following format is what will be parsed:
        out.writeString(source);
import org.opensearch.core.xcontent.XContentParser.Token;
     * <p>
     */
            } else if (source.isEmpty()) {
 * @opensearch.api
    public static StoredScriptSource fromXContent(XContentParser parser, boolean ignoreEmpty) {
    }
        out.writeMap(options);
                } else {
     * }
     *
        if (options.isEmpty() == false) {
                        deprecationLogger.deprecate("empty_templates", "empty templates should no longer be used");
        this.lang = Objects.requireNonNull(lang);
     * (as a url parameter during a put request).  See {@link ScriptMetadata} for more information about
        }
 *
    public static StoredScriptSource parse(BytesReference content, MediaType mediaType) {
     * }
    private static final ObjectParser<Builder, Void> PARSER = new ObjectParser<>("stored script source", true, Builder::new);
     *         "options" : {
                throw new ParsingException(
                throw new ParsingException(
     * <p>
            this.lang = lang;
import org.opensearch.cluster.ClusterState;
import org.opensearch.core.common.io.stream.StreamOutput;
     *                    This allows empty templates to be loaded for backwards compatibility.
        PARSER.declareString(Builder::setLang, LANG_PARSE_FIELD);
     *         }
 * {@link StoredScriptSource} represents user-defined parameters for a script
                if (ignoreEmpty || Script.DEFAULT_TEMPLATE_LANG.equals(lang)) {
     * Standard {@link ParseField} for outer level of stored script source.
        return source;
        private String source;
 * Licensed to Elasticsearch under one or more contributor
     * "code" : "<source>",
    private final String source;
        out.writeString(lang);
            InputStream stream = content.streamInput();
    }
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
            if (source == null) {
import org.opensearch.core.common.io.stream.StreamInput;
     * }
}
     * Reads a {@link StoredScriptSource} from a stream.  Version 5.3+ will read
     * }
    }
        if (this == o) return true;
                    "unexpected token [" + token + ", expected [" + SCRIPT_PARSE_FIELD.getPreferredName() + "]"
    public static Diff<StoredScriptSource> readDiffFrom(StreamInput in) throws IOException {
     * ...
import org.opensearch.core.common.ParsingException;
        /**
     * the stored script namespaces.
        this.lang = in.readString();
    public static final ParseField OPTIONS_PARSE_FIELD = new ParseField("options");
    /**
    }
     * <p>
        return "StoredScriptSource{" + "lang='" + lang + '\'' + ", source='" + source + '\'' + ", options=" + options + '}';
     */
     * {@code
     * "lang" : "painless",
 * this file be licensed under the Apache-2.0 license or a
 */
         * @param ignoreEmpty Specify as {@code true} to ignoreEmpty the empty source check.
        private Builder() {
     * construct an immutable {@link StoredScriptSource} object based on parsed XContent.
        return result;
     *
     */
                return new StoredScriptSource(Script.DEFAULT_TEMPLATE_LANG, "", Collections.emptyMap());
     * <p>
 *
     * }
     * "option0" : "<option0>",
         * consist of either an {@link String} or a JSON object.  If a JSON object is discovered
     * <p>
     *     }
                throw new IllegalArgumentException("illegal compiler options [" + options + "] specified");
            Token token = parser.nextToken();
     *             "option1" : "<option1>",
                    return PARSER.apply(parser, null).build(false);
        Map<String, String> options = (Map<String, String>) (Map) in.readMap();
    }
        if (source != null ? !source.equals(that.source) : that.source != null) return false;
    }
    private final String lang;
            }
 *
                );
                if (ignoreEmpty || Script.DEFAULT_TEMPLATE_LANG.equals(lang)) {
                        deprecationLogger.deprecate("empty_templates", "empty templates should no longer be used");
            try {
        result = 31 * result + (source != null ? source.hashCode() : 0);
    public static final ParseField LANG_PARSE_FIELD = new ParseField("lang");
     *         "options" : {
     * "source" : "<source>",
    }
     *     "script" : {
        }
        /**
            if (lang == null) {
        if (o == null || getClass() != o.getClass()) return false;
     * @param lang    The language to compile the script with.  Must not be {@code null}.
     * <p>
     *             ...
     * Standard {@link ParseField} for lang on the inner level.
     * Example:
     *             ...
     */
    /**
    /**
     */
import java.util.Objects;
     * }
     * }
        int result = lang != null ? lang.hashCode() : 0;
import org.opensearch.core.ParseField;
                }
import org.opensearch.core.xcontent.ToXContentObject;
/*
     * {
import org.opensearch.core.xcontent.ObjectParser.ValueType;
        private void setSource(XContentParser parser) {
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
    }
 *
    /**
     */
     * @return The parsed {@link StoredScriptSource}.
        private void setLang(String lang) {
     */
                throw new UncheckedIOException(exception);
        StoredScriptSource that = (StoredScriptSource) o;
         * Validates the parameters and creates an {@link StoredScriptSource}.
import org.opensearch.core.xcontent.MediaType;
     *     }
    /**
        builder.field(SOURCE_PARSE_FIELD.getPreferredName(), source);
import org.opensearch.cluster.Diff;
                        deprecationLogger.deprecate("empty_scripts", "empty scripts should no longer be used");
         */
     *             "option0" : "<option0>",
     * @param content   The content from the request to be parsed as described above.
    public static final ParseField SOURCE_PARSE_FIELD = new ParseField("source", "code");
            if (token == Token.END_OBJECT) {
        PARSER.declareField(Builder::setSource, parser -> parser, SOURCE_PARSE_FIELD, ValueType.OBJECT_OR_STRING);
        private Map<String, String> options;
     * The complex script format using the new stored script namespace
         * then the content type option must also be saved as a compiler option.
     * }
    @Override
     * {@code
     * The above format requires the lang to be specified using the deprecated stored script namespace
     * "option1" : "<option1>",
            }
         *                    This allow empty templates to be loaded for backwards compatibility.
            if (SCRIPT_PARSE_FIELD.getPreferredName().equals(name)) {
                    }
     * all of the lang, source, and options parameters.  For versions prior to 5.3,
 * The OpenSearch Contributors require contributions made to
                    } else {
    public StoredScriptSource(StreamInput in) throws IOException {
            }
     *             "option0" : "<option0>",
    private static final class Builder {
     * }
            } else if (lang.isEmpty()) {
public class StoredScriptSource extends AbstractDiffable<StoredScriptSource> implements Writeable, ToXContentObject {
            return new StoredScriptSource(lang, source, options);
        // Defines the fields necessary to parse a Script as XContent using an ObjectParser.
        this.source = in.readString();
                    throw new IllegalArgumentException("source cannot be empty");
                    if (Script.DEFAULT_TEMPLATE_LANG.equals(lang)) {
    /**
    /**
     * {"script": "return Math.log(doc.popularity) * 100;"}
package org.opensearch.script;
import org.opensearch.core.xcontent.ObjectParser;
                if (parser.currentToken() == Token.START_OBJECT) {
 * this work for additional information regarding copyright
         */
        @SuppressWarnings("unchecked")
    }
 * You may obtain a copy of the License at
    public StoredScriptSource(String lang, String source, Map<String, String> options) {
                throw new ParsingException(parser.getTokenLocation(), "unexpected token [" + token + "], expected [{]");
     * {
/*
    }
     * The simple script format with no compiler options or user-defined params:
        this.options = options;
        }
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
     * @return The compiler options used for this script.
                );
     * Required for {@link ScriptMetadata.ScriptMetadataDiff}.  Uses
        builder.field(LANG_PARSE_FIELD.getPreferredName(), lang);
        return builder;
    public String getLang() {
                    throw new ParsingException(parser.getTokenLocation(), "unexpected token [" + token + "], expected [{, <source>]");
import java.util.Collections;
            builder.field(OPTIONS_PARSE_FIELD.getPreferredName(), options);
                    if (Script.DEFAULT_TEMPLATE_LANG.equals(lang)) {
        private StoredScriptSource build(boolean ignoreEmpty) {
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(StoredScriptSource.class);
     * @param mediaType The media type of the request
     * "option0" : "<option0>",
     *     "script" : {
import org.opensearch.core.common.io.stream.Writeable;
     * Note that the "source" parameter can also handle template parsing including from
                if (token == Token.START_OBJECT) {
import org.opensearch.core.common.bytes.BytesReference;
 * KIND, either express or implied.  See the License for the
        private String lang;
            }
     *         "lang" : "<lang>",
     * {
    }
     * }
     *
