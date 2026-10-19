    /**
            return new Script(ScriptType.INLINE, defaultLang, parser.text(), Collections.emptyMap());
     *                 be specified to access scripts stored as part of the stored scripts deprecated API.  
                    lang = defaultLang;
     * @param consumer the consumer for the script
    /**
            this.params = Collections.emptyMap();  
     * <p>
     * Compiler option for {@link XContentType} used for templates.
 *                                so they have no meaning here and must be {@code null}  
                        throw new OpenSearchParseException("Value must be of type String: [" + parameterName + "]");  
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**  
     *         "option0" : "<option0>",
    /**
     */
     * @param lang     The language for this {@link Script} if the {@link ScriptType} is {@link ScriptType#INLINE}.
        private void setOptions(Map<String, String> options) {
 * <ul>
     *         "param0" : "<param0>",
     * @param parser the parser itself
     *         For {@link ScriptType#STORED} scripts this should be null, but can  
     * Standard {@link ParseField} for source on the inner level.  
                    throwOnlyOneOfType();  
        PARSER.declareField(Builder::setParams, XContentParser::map, PARAMS_PARSE_FIELD, ValueType.OBJECT);
     * Standard {@link ParseField} for options on the inner level.
 * Modifications Copyright OpenSearch Contributors. See
            try {
 *                                use an empty {@link Map} to specify no params
     *         "multiplier" : 100.0
    public static Script parse(Settings settings) {  
                        throw new OpenSearchParseException("Value must be of type String: [" + parameterName + "]");
     */  
     *         ...
                builder.field(SOURCE_PARSE_FIELD.getPreferredName(), idOrCode);
     */
     * {@code  
     * }  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(Script.class);
/*
 * not use this file except in compliance with the License.
    /**
        out.writeString(idOrCode);
    public static <T> void declareScript(AbstractObjectParser<T, ?> parser, BiConsumer<T, Script> consumer) {
     * <p>
        }
    /**  
     *         "param0" : "<param0>",  
     * <p>
/*  
                    NamedXContentRegistry.EMPTY,
 * software distributed under the License is distributed on an
    /**  
import org.opensearch.core.xcontent.ToXContent;
     */  
        private void setLang(String lang) {
                    "Expected one of [{}] or [{}] fields, but found none",
    /**
     *                 For {@link ScriptType#STORED} scripts this should be null, but can
            throw new IllegalStateException("unknown script type [" + type.getName() + "]");
                }  
            }  
    }  
        return parse(parser, DEFAULT_SCRIPT_LANG);  
        this.type = ScriptType.readFrom(in);  
                    idOrCode = parser.text();
import java.io.InputStream;  
        }
        }  
     */
        private Builder() {  
 * <li> {@link Script#lang}     - specifies the language, defaults to {@link Script#DEFAULT_SCRIPT_LANG}
     *         The code for this {@link Script} if the {@link ScriptType} is {@link ScriptType#INLINE}.  
 *                                use an empty {@link Map} to specify no options
import java.util.function.BiConsumer;  
    }
        /**  
     * @param lang     The language for this {@link Script} if the {@link ScriptType} is {@link ScriptType#INLINE}.
                    options.put(CONTENT_TYPE_OPTION, MediaTypeRegistry.JSON.mediaType());  
     *     "source" : "return Math.log(doc.popularity) * params.multiplier;",
     *     // OR
     * Example:
@PublicApi(since = "1.0.0")
     *
                        type = ScriptType.STORED;  
        PARSER.declareString(Builder::setStored, ScriptType.STORED.getParseField());
        } else {
        return builder;  
import org.opensearch.core.xcontent.NamedXContentRegistry;
 */
                        throw new OpenSearchParseException("Value must be of type Map: [" + parameterName + "]");  
     *         "option0" : "<option0>",
 * compile and execute a script from the {@link ScriptService}
                    throw new IllegalArgumentException(
     *         "option0" : "<option0>",
                    XContentBuilder builder = XContentFactory.jsonBuilder();
            } else {
        try (XContentBuilder builder = JsonXContent.contentBuilder()) {
     *                     the one defined by {@link Script#DEFAULT_SCRIPT_LANG} due to backwards compatibility requirements
     * @param parseField the field name
 * @opensearch.api  
        private void setInline(XContentParser parser) {  
    private final String idOrCode;
                "must only use one of ["
    @Override  
 * Unless required by applicable law or agreed to in writing,
 * <li> {@link Script#lang}     - the language will be specified when storing the script, so this should
     */
import java.io.IOException;
        @SuppressWarnings("unchecked")  
            builder.field(OPTIONS_PARSE_FIELD.getPreferredName(), options);  
     *
    }  
/**
    /**
        result = 31 * result + idOrCode.hashCode();
                        throw new OpenSearchParseException("Value must be of type String: [" + parameterName + "]");
                throw new IllegalArgumentException("lang cannot be specified for stored scripts");
            } else {  
        private String lang;
            builder.field(LANG_PARSE_FIELD.getPreferredName(), lang);
                } else if (Script.OPTIONS_PARSE_FIELD.match(parameterName, LoggingDeprecationHandler.INSTANCE)) {
 */  
     *         ...
        }
     *         ...
        } else if (type == ScriptType.STORED) {  
 *
            for (Map.Entry<String, Object> entry : configMap.entrySet()) {
                }
        }  
            return new Script(str);  
     * is provided and the {@link ScriptType#INLINE} is specified then the template will be preserved as a raw field.  
     */
            throw new IllegalArgumentException(
    public Script(String idOrCode) {
     * @param type     The {@link ScriptType}.  
        if (options != null ? !options.equals(script.options) : script.options != null) return false;
                    + ScriptType.STORED.getParseField().getPreferredName()
    }
     *     }  
     *     "lang" : "painless",
                try (InputStream stream = new BytesArray(idOrCode).streamInput()) {  
        }
     *         "option1" : "<option1>",
 *  
        }
     *         "param1" : "<param1>",
     *     "source" : { "query" : ... },  
     * This also handles templates in a special way.  If a complexly formatted query is specified as another complex
        parser.declareField(consumer, (p, c) -> Script.parse(p), parseField, ValueType.OBJECT_OR_STRING);
    @SuppressWarnings("unchecked")
        @SuppressWarnings("unchecked")
            if (options != null) {
         *                    previously stored queries.
                    idOrCode = builder.copyCurrentStructure(parser).toString();
                    builder.rawField(SOURCE_PARSE_FIELD.getPreferredName(), stream);
     * The complex format where {@link ScriptType} and idOrCode are required while lang, options and params are not required.
    public static Script parse(XContentParser parser) throws IOException {
                )
                if (options.size() > 1 || options.size() == 1 && options.get(CONTENT_TYPE_OPTION) == null) {
     *         ...  
     *         "option1" : "<option1>",
                }
     *  
            );
     *         be specified to access scripts stored as part of the stored scripts deprecated API.
            if (script == null) {
    public static final ParseField SCRIPT_PARSE_FIELD = new ParseField("script");  
            this.lang = lang;  
    public static final String DEFAULT_SCRIPT_LANG = "painless";
     *     "lang" : "<lang>",  
    /**
     * JSON object the query is assumed to be a template, and the format will be preserved.
        builder.startObject();  
 * <p>
        if (options != null && !options.isEmpty()) {
     * }
        } catch (IOException e) {  
     * }
    static {
                        "[" + Script.LANG_PARSE_FIELD.getPreferredName() + "] cannot be specified for stored scripts"
        private void setParams(Map<String, Object> params) {
         * then the content type option must also be saved as a compiler option.
     *         ...  
        Map<String, String> options = (Map<String, String>) (Map) in.readMap();
                );
    }
     * The name of the default template language.
     */
    private final Map<String, String> options;  
        if (config instanceof String str) {
            this.options.putAll(options);
         * to handle template parsing, hence the need for custom parsing code.  Templates can
     *     }
        String contentType = options == null ? null : options.get(CONTENT_TYPE_OPTION);
 * <li> {@link Script#params}   - {@link Map} of user-defined parameters; must not be {@code null},
import org.opensearch.core.xcontent.XContentParser;
            + params  
            }  
        if (lang != null ? !lang.equals(script.lang) : script.lang != null) return false;
         * Set both the id and the type of the stored script.
     * @param parser the parser itself
                    }
 * <li> {@link ScriptType#STORED}  
 * There are three types of scripts specified by {@link ScriptType}.
                        "field [" + OPTIONS_PARSE_FIELD.getPreferredName() + "] " + "cannot be specified using a stored script"
     *         ...
        } else {  
        this.params = Collections.unmodifiableMap(Objects.requireNonNull(params));
 * <p>  
            + ", idOrCode='"  
        }  
        if (this == o) return true;
            this.lang = Objects.requireNonNull(lang);
                        throw new OpenSearchParseException("Value must be of type Map: [" + parameterName + "]");  
     * construct an immutable {@link Script} object based on parsed XContent.  
         * Appends the user-defined compiler options with the internal compiler options.
     *         "option1" : "<option1>",
     */
            throw new IllegalStateException(e);
     *     "params" : {  
     * <p>  
            String script = null;  
     * @param options  The map of compiler options for this {@link Script} if the {@link ScriptType}  
     *         ...
import org.opensearch.core.xcontent.ObjectParser.ValueType;
            + type
     * "return Math.log(doc.popularity) * 100;"
                throw new IllegalArgumentException("must specify either [source] for an inline script or [id] for a stored script");
     */
        /**  
    public Script(ScriptType type, String lang, String idOrCode, Map<String, String> options, Map<String, Object> params) {
        this.idOrCode = in.readString();
     * {  
 * GitHub history for details.
     * {@code  
                return new Script(type, lang == null ? DEFAULT_SCRIPT_LANG : lang, script, options, params);
 * <li> {@link Script#options}  - compiler options will be specified when a stored script is stored,
     *     "options" : {
            String lang = null;
     * <p>
            }
                    }
     * @param defaultLang  The default language to use if no language is specified.  The default language isn't necessarily
 * this work for additional information regarding copyright
        private String idOrCode;
     *         "option1" : "<option1>",  
import java.util.HashMap;  
        return params;  
import org.opensearch.core.ParseField;  
     * @param type     The {@link ScriptType}.
        if (type != script.type) return false;
     * @param parser       The {@link XContentParser} to be used.  
     *         "param1" : "<param1>",
        if (token == null) {  
     * Constructor for a script that does not need to use compiler options.  
     *     "options" : {
 *
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
 * <ul>
 * this file be licensed under the Apache-2.0 license or a
                if (idOrCode == null) {  
     */
     *     }
     * {  
     * }
     * }
            }
    }  
            builder.field("id", idOrCode);
 * The OpenSearch Contributors require contributions made to  
     */
     * @return The map of compiler options for this {@link Script} if the {@link ScriptType}
     * The simple format defaults to an {@link ScriptType#INLINE} with no compiler options or user-defined params:  
                    throw new IllegalArgumentException(
 * </ul>  
    public String toString() {
            + '\''
import org.opensearch.core.xcontent.ObjectParser;  
    /**  
                    ScriptType.INLINE.getParseField().getPreferredName(),
     * }
    private static final class Builder {
     *     "options" : {  
        }  
     */  
     * Convenience method to call {@link Script#parse(XContentParser, String)}
     * {@code
                return parse(parser);
                if (type != null) {
                    }  
        }
                        type = ScriptType.INLINE;
        } else if (config instanceof Map<?, ?>) {
            try (
                throw new IllegalStateException("options cannot be specified for stored scripts");
    public static final ParseField PARAMS_PARSE_FIELD = new ParseField("params");
                        options = (Map<String, String>) parameterValue;
    }
                    if (parameterValue instanceof Map<?, ?> || parameterValue == null) {  
                    if (parameterValue instanceof Map<?, ?> || parameterValue == null) {  
    public static final ParseField OPTIONS_PARSE_FIELD = new ParseField("options");  
                    // this is really for search templates, that need to be converted to json format  
 * ownership. Elasticsearch licenses this file to you under  
    }
    }
    }
     * @param <T> Whatever type the {@linkplain ObjectParser} is parsing.  
                    throw new IllegalArgumentException("must specify <code> for a stored script");
                    + ScriptType.INLINE.getParseField().getPreferredName()  
 * <li> {@link ScriptType#INLINE}  
import java.util.Objects;
                    + "]"  
            + options
            Map<String, Object> params = Collections.emptyMap();  
                    + ", "
        // Defines the fields necessary to parse a Script as XContent using an ObjectParser.
                } else {
         */
                XContentParser parser = JsonXContent.jsonXContent.createParser(
     *     "source" : { "query" : ... },
        return params.equals(script.params);
 * <li> {@link Script#idOrCode} - specifies the id of the stored script to be looked up, must not be {@code null}
     *
        if (type == ScriptType.INLINE) {
        return lang;
    }
    /**
    }
                if (idOrCode == null) {
        /**  
    /**
    public Script(ScriptType type, String lang, String idOrCode, Map<String, Object> params) {  
                    } else {
     * {@code
        this.params = Collections.unmodifiableMap(in.readMap());  
            }
    }  
                    options.remove(CONTENT_TYPE_OPTION);  
    }
     *     "params" : {
     * <p>
    /**  
                    throw new IllegalArgumentException("must specify <id> for an inline script");
 * {@link Script} represents used-defined input that can be used to  
 * You may obtain a copy of the License at  
        Map<String, Object> options = (Map<String, Object>) (Map) this.options;  
     * This also handles templates in a special way.  If the {@link Script#CONTENT_TYPE_OPTION} option
            if (type == ScriptType.STORED) {
     *     "<(id, source)>" : "<idOrCode>",
     * Parse a {@link Script} from an {@link Object}, that can either be a {@link String} or a {@link Map}.  
                if (options.isEmpty()) {
        }
     *         "param1" : "<param1>",  
    }  
     * @param idOrCode The id or code to use dependent on the default script type.
        Token token = parser.currentToken();
import java.io.UncheckedIOException;
import org.opensearch.core.common.io.stream.StreamOutput;
            return new Script(type, lang, idOrCode, options, params);
                    options = null;
            + ", params="
import java.util.Collections;
         *                    at run-time this way in case a legacy default language is used from  
            Map<String, Object> configMap = (Map<String, Object>) config;
     *                 For {@link ScriptType#STORED} scripts this should be null, but can  
     *     "lang" : "painless",  
            builder.startObject();
import org.opensearch.core.common.bytes.BytesArray;
            if (type == null) {
     *     },
            type = ScriptType.STORED;
                throw new UncheckedIOException(exception);
        this.lang = in.readOptionalString();
            this.options = Collections.unmodifiableMap(Objects.requireNonNull(options));
     * Standard {@link ParseField} for lang on the inner level.
     */  
 */  
    }
                    + " when specifying a script"
            + "type="
    }  
    /**
    /**
            Map<String, String> options = Collections.emptyMap();
     * Creates a {@link Script} read from an input stream.  
     * {
        /**  
         */
         * consist of either an {@link String} or a JSON object.  If a JSON object is discovered  
     */  
            + '\''
     * }
        result = 31 * result + (lang != null ? lang.hashCode() : 0);  
        result = 31 * result + params.hashCode();  
     *     "lang" : "<lang>",
                        params = (Map<String, Object>) parameterValue;
            if (type == ScriptType.INLINE) {
        result = 31 * result + (options != null ? options.hashCode() : 0);
                    if (parameterValue instanceof String || parameterValue == null) {  
            + '}';
        if (type == ScriptType.INLINE) {  
    public static Script parse(Object config) {  
     * Standard {@link ParseField} for outer level of script queries.
import java.util.Map;
     */
    public String getLang() {  
     *         "option0" : "<option0>",  
                    throw new IllegalArgumentException("illegal compiler options [" + options + "] specified");
                if (lang != null) {
     */  
        } else {  
    public static final ParseField LANG_PARSE_FIELD = new ParseField("lang");
            }  
        this(type, lang, idOrCode, type == ScriptType.INLINE ? Collections.emptyMap() : null, params);
     */  
     * Example:
    public ScriptType getType() {  
 * Licensed to Elasticsearch under one or more contributor  
    private final String lang;
        out.writeOptionalString(lang);  
            }  
                } else {
     * Parse the script configured in the given settings.
}  
     * Constructor for a script that requires the use of compiler options.
        out.writeMap(params);
     *     "source": "<source>",
    public static final ParseField SOURCE_PARSE_FIELD = new ParseField("source");
            if (contentType != null && builder.contentType().mediaType().equals(contentType)) {
        return type;
     *                     related to stored queries using previously default languages.  
    /**  
    /**
            + ", options="  
    /**
     *     "id" : "<id>",  
 * based on the {@link ScriptType}.
     *     "params" : {
    public static final String DEFAULT_TEMPLATE_LANG = "mustache";  
            }
     * @return The language for this {@link Script} if the {@link ScriptType} is {@link ScriptType#INLINE}.
            this.lang = null;
        if (lang != null) {
     *  
    public XContentBuilder toXContent(XContentBuilder builder, Params builderParams) throws IOException {
     *                 The code for this {@link Script} if the {@link ScriptType} is {@link ScriptType#INLINE}.
    }
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.xcontent.json.JsonXContent;
    public static final ScriptType DEFAULT_SCRIPT_TYPE = ScriptType.INLINE;
     *     },
            + lang
         * Helper method to throw an exception if more than one type of {@link Script} is specified.
 *                                use an empty {@link Map} to specify no params
                    throw new IllegalArgumentException("illegally specified <lang> for a stored script");  
        this.type = Objects.requireNonNull(type);
 * <li> {@link Script#options}  - specifies the compiler options for this script; must not be {@code null},
                }  
     *         ...  
     *                 be specified to access scripts stored as part of the stored scripts deprecated API.
        Objects.requireNonNull(defaultLang);
                Object parameterValue = entry.getValue();
     * <p>
            }
 * compatible open source license.
     *         "multiplier" : 100.0
     * {
        private ScriptType type;  
     * }
                throw new OpenSearchParseException(  
import org.opensearch.core.common.io.stream.StreamInput;  
     *         "param1" : "<param1>",
     * }  
        }
     * @param params   The user-defined params to be bound for script execution.
                } else if (Script.PARAMS_PARSE_FIELD.match(parameterName, LoggingDeprecationHandler.INSTANCE)) {
     * @param <T> Whatever type the {@linkplain ObjectParser} is parsing.
        private Map<String, String> options;  
 * <li> {@link Script#params}   - {@link Map} of user-defined parameters; must not be {@code null},  
                    stream
                    if (parameterValue instanceof String || parameterValue == null) {  
                    }
    /**
     *     "source" : "return Math.log(doc.popularity) * params.multiplier",
     *     "params" : {
        return options;
     * {@code
     * @return The map of user-defined params for this {@link Script}.  
 * The following describes the expected parameters for each type of script:  
        }  
        int result = type.hashCode();
     * }
    @Override
 * under the License.  
     * @param idOrCode The id for this {@link Script} if the {@link ScriptType} is {@link ScriptType#STORED}.
    public static Script parse(XContentParser parser, String defaultLang) throws IOException {
import org.opensearch.core.xcontent.XContentParser.Token;  
     *     },  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                throwOnlyOneOfType();
        PARSER.declareField(Builder::setInline, parser -> parser, ScriptType.INLINE.getParseField(), ValueType.OBJECT_OR_STRING);  
     */
            if (type != null) {
 * SPDX-License-Identifier: Apache-2.0
        PARSER.declareString(Builder::setLang, LANG_PARSE_FIELD);
    }
                }
import org.opensearch.common.settings.Settings;
import org.opensearch.OpenSearchParseException;
     */
            this.params = params;  
            // it should not happen since we are not actually reading from a stream but an in-memory byte[]
        private void setStored(String idOrCode) {  
        private Script build(String defaultLang) {  
     *
        /**  
 * </ul>
        PARSER.declareField(Builder::setOptions, XContentParser::mapStrings, OPTIONS_PARSE_FIELD, ValueType.OBJECT);  
     * Example:
        if (o == null || getClass() != o.getClass()) return false;  
 *
         * @param defaultLang The default lang is not a compile-time constant and must be provided
     * @param params   The user-defined params to be bound for script execution.
        return idOrCode;  
                    } else {
    public int hashCode() {
    private final ScriptType type;  
                if (Script.LANG_PARSE_FIELD.match(parameterName, LoggingDeprecationHandler.INSTANCE)) {
 * specific language governing permissions and limitations
     */
import org.opensearch.common.xcontent.XContentType;
/*  
     * This will parse XContent into a {@link Script}.  The following formats can be parsed:
     *     "options" : {  
import org.opensearch.common.logging.DeprecationLogger;  
            } else if (type == ScriptType.STORED) {
import org.opensearch.common.annotation.PublicApi;
    }
        return "Script{"  
     * }  
        }
     *         is {@link ScriptType#INLINE}, {@code null} otherwise.
 */
     * {@code  
     * }
import org.opensearch.core.xcontent.XContentBuilder;
    /**
        return PARSER.apply(parser, null).build(defaultLang);
                    } else {  
     * Helper class used by {@link ObjectParser} to store mutable {@link Script} variables and then
                }
        private void throwOnlyOneOfType() {  
     * {
                }
        type.writeTo(out);
import org.opensearch.core.common.bytes.BytesReference;
     * Declare a script field on an {@link ObjectParser} with the standard name ({@code script}).
public final class Script implements ToXContentObject, Writeable {  
                    if (parameterValue instanceof String || parameterValue == null) {
import org.opensearch.core.xcontent.ToXContentObject;  
     *     "lang" : "<lang>",
     * using the default scripting language.  
        this.idOrCode = Objects.requireNonNull(idOrCode);  
        Script script = (Script) o;
    public Script(StreamInput in) throws IOException {
 * license agreements. See the NOTICE file distributed with
        this.options = options;
                type = ScriptType.INLINE;  
        private Map<String, Object> params;
         * Validates the parameters and creates an {@link Script}.
            settings.toXContent(builder, ToXContent.EMPTY_PARAMS);  
 * </ul>
                }
     * @param consumer the consumer for the script  
                    } else {
     * @return The id for this {@link Script} if the {@link ScriptType} is {@link ScriptType#STORED}.
package org.opensearch.script;
    /**
     * }
    @Override  
     * Declare a script field on an {@link ObjectParser}.  
     *     "lang" : "<lang>",
                InputStream stream = BytesReference.bytes(builder).streamInput();  
    private static final ObjectParser<Builder, Void> PARSER = new ObjectParser<>("script", Builder::new);
            } catch (IOException exception) {
                if (lang == null) {  
     */  
    }
    @Override
     *  
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    deprecationLogger.deprecate("script_unsupported_fields", "script section does not support [" + parameterName + "]");
            assert type != null : "if script is not null, type should definitely not be null";  
                    );  
        declareScript(parser, consumer, Script.SCRIPT_PARSE_FIELD);
        }
     * @return             The parsed {@link Script}.
                }
     * @return        The parsed {@link Script}.  
                        script = (String) parameterValue;
            }  
        }
     *     },
            throw new IllegalArgumentException("Script value should be a String or a Map");
    public boolean equals(Object o) {
    public String getIdOrCode() {
                        script = (String) parameterValue;
                }  
                if (parser.currentToken() == Token.START_OBJECT) {
    public void writeTo(StreamOutput out) throws IOException {
                }  
         */
     *     "params" : {
                    }
    /**  
     */
     * The name of the of the default scripting language.
            }  
        Objects.requireNonNull(config, "Script must not be null");
        this(DEFAULT_SCRIPT_TYPE, DEFAULT_SCRIPT_LANG, idOrCode, Collections.emptyMap(), Collections.emptyMap());
     *     }
     */
import org.opensearch.core.common.io.stream.Writeable;
     */  
    /**
        out.writeMap(options);
        if (token == Token.VALUE_STRING) {
                } else {  
     *     }  
 * <li> {@link Script#idOrCode} - specifies the code to be compiled, must not be {@code null}  
     *     "params" : {  
            + idOrCode
                } else if (ScriptType.STORED.getParseField().match(parameterName, LoggingDeprecationHandler.INSTANCE)) {  
    public Map<String, Object> getParams() {
         */
     * @param idOrCode The id for this {@link Script} if the {@link ScriptType} is {@link ScriptType#STORED}.
                    } else {
            builder.field(PARAMS_PARSE_FIELD.getPreferredName(), params);
            + ", lang='"  
 * <ul>
     * @param config  The object to parse the script from.
     * {  
    @Override  
    public static <T> void declareScript(AbstractObjectParser<T, ?> parser, BiConsumer<T, Script> consumer, ParseField parseField) {  
     *         "param0" : "<param0>",  
            builder.endObject();
            this.options = null;
     * Constructor for simple script using the default language and default type.
     *     }  
    public static final String CONTENT_TYPE_OPTION = "content_type";
     *                 is {@link ScriptType#INLINE}, {@code null} otherwise.
         * Options may have already been added if an inline template was specified.
        if (!params.isEmpty()) {  
            this.options = new HashMap<>();
     *     // Exactly one of "id" or "source" must be specified
     * Standard {@link ParseField} for params on the inner level.  
 *                                be {@code null}  
                return new Script(type, null, script, null, params);  
                        lang = (String) parameterValue;
     * {@code
        if (!idOrCode.equals(script.idOrCode)) return false;  
         */  
                if (lang != null) {  
                    ScriptType.STORED.getParseField().getPreferredName()  
 *
    /**  
                String parameterName = entry.getKey();  
import org.opensearch.core.xcontent.AbstractObjectParser;  
 * KIND, either express or implied.  See the License for the
     * @see #parse(XContentParser, String)
        }  
     */
    private final Map<String, Object> params;
import org.opensearch.common.xcontent.XContentFactory;  
     * @return The {@link ScriptType} for this {@link Script}.
            ) {  
     * This will build scripts into the following XContent structure:  
        return result;
            this.idOrCode = idOrCode;  
    }  
    /**
            token = parser.nextToken();
     * Note that lang, options, and params will only be included if there have been any specified.  
                    );  
         * Since inline scripts can accept code rather than just an id, they must also be able
     *         "param0" : "<param0>",
                    LoggingDeprecationHandler.INSTANCE,  
            if (lang != null) {
     *                 The code for this {@link Script} if the {@link ScriptType} is {@link ScriptType#INLINE}.  
                } else if (ScriptType.INLINE.getParseField().match(parameterName, LoggingDeprecationHandler.INSTANCE)) {
            ScriptType type = null;
     * The default {@link ScriptType}.  
            // This cannot default to an empty map because options are potentially added at multiple points.
        builder.endObject();
    public Map<String, String> getOptions() {
