        return builder;
                throw new IllegalArgumentException(msg);
public class FetchSourceContext implements Writeable, ToXContentObject {
                        throw new ParsingException(
    public FetchSourceContext(boolean fetchSource, String[] includes, String[] excludes) {
            case XContentParser.Token.START_ARRAY -> {
}
                    "Unknown key for a " + parser.currentToken() + " in [" + parser.currentName() + "]."
    @Override
     * Since the constructors are public, this validation is required to be called in the constructor.
        return new FetchSourceContext(true, includes.toArray(new String[0]), null);
            }
                        + token
            deprecationLogger.deprecate(
    public FetchSourceContext(boolean fetchSource) {
                throw new ParsingException(
package org.opensearch.search.fetch.subphase;
                        + ", "
            }
                includes.add(parser.text());
                    + " but got a "
            return new FetchSourceContext(fetchSource == null ? true : fetchSource, sourceIncludes, sourceExcludes);
                    + INCLUDES_FIELD.getPreferredName()
    @Override
            } else {
                "empty_source_array",
import java.util.Arrays;
        }
    private void validateAmbiguousFields() {
                "Expected a " + XContentParser.Token.START_OBJECT + " but got a " + token + " in [" + parser.currentName() + "]."
    }
                    + XContentParser.Token.START_ARRAY
        if (token != XContentParser.Token.START_OBJECT) {
        return this.excludes;
                    } else {
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamOutput;
     */
                throw new ParsingException(
import java.io.IOException;
    private Function<Map<String, ?>, Map<String, Object>> filter;
     */
                        includes = parseSourceFieldArray(parser, INCLUDES_FIELD);
                    + "] or use `_source: true` to fetch the entire source."
 * KIND, either express or implied.  See the License for the
            sourceExcludes = Strings.splitStringByCommaToArray(sExcludes);
        out.writeStringArray(includes);
        String[] excludes = Strings.EMPTY_ARRAY;
                parser.getTokenLocation(),
    }
        Set<String> sourceArr = new LinkedHashSet<>(); // preserves the order, removes the duplicates
                parser.getTokenLocation(),
        out.writeStringArray(excludes);
        fetchSource = in.readBoolean();
            } else {
import org.opensearch.core.common.logging.LoggerMessageFormat;
        validateAmbiguousFields();
            );
 * You may obtain a copy of the License at
    public String[] excludes() {
        return this.fetchSource;
                    + "] or ["
        if (parser.currentToken() != XContentParser.Token.START_ARRAY) {
    }
                return parseSourceObject(parser);
        }
 * ownership. Elasticsearch licenses this file to you under
                return new FetchSourceContext(true, includes, null);
    public static final FetchSourceContext FETCH_SOURCE = new FetchSourceContext(true, null, null);
        while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
        if (sExcludes != null) {
        return null;
import org.opensearch.rest.RestRequest;
        return this.includes;
                        + ", "
import org.opensearch.common.annotation.PublicApi;
    public int hashCode() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                );
import org.opensearch.core.xcontent.ToXContentObject;
                    if (INCLUDES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
        String sIncludes = request.param("_source_includes");
    }
                        throw new ParsingException(
            sourceIncludes = Strings.splitStringByCommaToArray(sIncludes);
                throw new ParsingException(
                );
        Set<String> includes = new LinkedHashSet<>();
                    "Expected one of ["
            builder.value(false);
        if (includes.length == 0 && excludes.length == 0) {
        String source = request.param("_source");
        switch (token) {
     * */
        this.excludes = excludes == null ? Strings.EMPTY_ARRAY : excludes;
            } else if (Booleans.isFalse(source)) {
 * this file be licensed under the Apache-2.0 license or a
        }
                "empty_source_object",
import org.opensearch.common.logging.DeprecationLogger;
            deprecationLogger.deprecate(
        }
            if (includeSet.contains(exclude)) {
                sourceArr.add(parser.text());
                fetchSource = true;
 */
            );
            } else {
     * The same entry cannot be both included and excluded in _source.
 */
    public void writeTo(StreamOutput out) throws IOException {
            }
    public static final ParseField EXCLUDES_FIELD = new ParseField("excludes", "exclude");
        if (includes.length == 0 && excludes.length == 0) {
    }
                }
    public String[] includes() {
        XContentParser.Token token = parser.currentToken();
            if (parser.currentToken() == XContentParser.Token.VALUE_STRING) {
        }
    @Deprecated
                        + "]"
        XContentParser.Token token = parser.currentToken();
        }
                    "Unknown key for a " + parser.currentToken() + " in [" + parser.currentName() + "]."
            // no empty arrays
                }
                throw new ParsingException(
        if (includes.length > 0) {
            }
                        + "] but found ["
import org.opensearch.core.xcontent.XContentBuilder;
                }
                    }
 */
 *
            }
import org.opensearch.core.common.Strings;
import java.util.Map;
        while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
 * The OpenSearch Contributors require contributions made to
    }
        includes = in.readStringArray();
import java.util.LinkedHashSet;
    public Function<Map<String, ?>, Map<String, Object>> getFilter() {
            throw new ParsingException(
        }
            if (parser.currentToken() == XContentParser.Token.VALUE_STRING) {
        }
    public static FetchSourceContext fromXContent(XContentParser parser) throws IOException {
                    "Expected a field name but got a " + token + " in [" + parser.currentName() + "]."
        String[] sourceIncludes = null;
import org.opensearch.core.common.ParsingException;
                "empty_source_" + parseField.getPreferredName(),
 *
            return builder;
                    }
        }
        for (String exclude : this.excludes) {
                "An empty object was provided as [_source]. Provide at least one of ["
                String[] includes = new String[] { parser.text() };
        this.includes = includes == null ? Strings.EMPTY_ARRAY : includes;
 *
                "Expected a "
            case XContentParser.Token.VALUE_STRING -> {
    private final String[] excludes;
    public static final FetchSourceContext DO_NOT_FETCH_SOURCE = new FetchSourceContext(false, null, null);
    }
                return parseSourceArray(parser);
            builder.value(true);
                    parser.getTokenLocation(),
import java.util.function.Function;
            builder.array(INCLUDES_FIELD.getPreferredName(), includes);
 *
 * Modifications Copyright OpenSearch Contributors. See
            case XContentParser.Token.VALUE_BOOLEAN -> {
                        );
    @Override
        if (!Arrays.equals(excludes, that.excludes)) return false;
    public static final ParseField INCLUDES_FIELD = new ParseField("includes", "include");
     * Returns a filter function that expects the source map as an input and returns
    }
        this.fetchSource = fetchSource;
        builder.endObject();
 * not use this file except in compliance with the License.
    }
        }
                    parser.getTokenLocation(),
import org.opensearch.core.common.io.stream.StreamInput;
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.ParseField;
                fetchSource = false;
        if (source != null) {
import java.util.Set;
    @Override
        if (excludes.length > 0) {
                "Expected at least one value for an array of [" + parseField.getPreferredName() + "]"
                "An empty array was provided as [_source]. Provide at least one field pattern or use `_source: true` to fetch the entire source."
            return builder;
            if (Booleans.isTrue(source)) {
        }
                    + "]."
        out.writeBoolean(fetchSource);
            // process field value
        if (fetchSource != that.fetchSource) return false;
        return new FetchSourceContext(true, includes, excludes);
 * specific language governing permissions and limitations
                    + parser.currentName()
        return true;
        result = 31 * result + (includes != null ? Arrays.hashCode(includes) : 0);
        if (filter == null) {
            }
                    + parser.currentToken()
                sourceIncludes = Strings.splitStringByCommaToArray(source);
    /**
        }
            deprecationLogger.deprecate(
import org.opensearch.common.xcontent.support.XContentMapValues;
                    } else if (EXCLUDES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        this(fetchSource, Strings.EMPTY_ARRAY, Strings.EMPTY_ARRAY);
                        + XContentParser.Token.VALUE_STRING
    public FetchSourceContext(StreamInput in) throws IOException {
        if (o == null || getClass() != o.getClass()) return false;
        String currentFieldName = null;
 * Context used to fetch the {@code _source}.
    }
        String[] includes = Strings.EMPTY_ARRAY;
                    parser.getTokenLocation(),
        if (!fetchSource) {
                    + EXCLUDES_FIELD.getPreferredName()
        String[] sourceExcludes = null;
                );
    private static final String AMBIGUOUS_FIELD_MESSAGE = "The same entry [{}] cannot be both included and excluded in _source.";
                    } else {
        if (sIncludes != null) {
        }
    }
            }
            switch (token) {
            if (token == XContentParser.Token.FIELD_NAME) {
    private static String[] parseSourceFieldArray(XContentParser parser, ParseField parseField) throws IOException {
                    parser.getTokenLocation(),
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.common.Booleans;
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(FetchSourceContext.class);
    public boolean fetchSource() {
 * Unless required by applicable law or agreed to in writing,
                    + " in ["
                        + XContentParser.Token.START_OBJECT
 * this work for additional information regarding copyright
     * the filtered map.
    }
        return sourceArr.toArray(new String[0]);
        if (includes.isEmpty()) {
    private final String[] includes;
    /**
                            "Unknown key for a " + token + " in [" + currentFieldName + "]."
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                case XContentParser.Token.VALUE_STRING -> {
            }
        int result = (fetchSource ? 1 : 0);
    }
                currentFieldName = parser.currentName();
import org.opensearch.core.common.io.stream.Writeable;
            default -> {
 */
                        + XContentParser.Token.VALUE_BOOLEAN
                            parser.getTokenLocation(),
 * the Apache License, Version 2.0 (the "License"); you may
@PublicApi(since = "1.0.0")
        }
            );
    static FetchSourceContext parseSourceObject(XContentParser parser) throws IOException {
                        + ", "
    }
        result = 31 * result + (excludes != null ? Arrays.hashCode(excludes) : 0);
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
 * @opensearch.api
 * under the License.
    }
        return filter;
        }
        }
                        );
        }
            }
                            parser.getTokenLocation(),
            filter = XContentMapValues.filter(includes, excludes, true);
                case XContentParser.Token.START_ARRAY -> {
    }
        builder.startObject();
        if (sourceArr.isEmpty()) {
        Set<String> includeSet = new HashSet<>(Arrays.asList(this.includes));
        Boolean fetchSource = null;
                        excludes = new String[] { parser.text() };
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (fetchSource != null || sourceIncludes != null || sourceExcludes != null) {
            }
        FetchSourceContext that = (FetchSourceContext) o;
            );
     * @deprecated use {@link #FETCH_SOURCE} or {@link #DO_NOT_FETCH_SOURCE} instead
/*
            );
        excludes = in.readStringArray();
                        + XContentParser.Token.START_ARRAY
                            "Unknown key for a " + token + " in [" + currentFieldName + "]."
    }
                        excludes = parseSourceFieldArray(parser, EXCLUDES_FIELD);
                String msg = LoggerMessageFormat.format(null, AMBIGUOUS_FIELD_MESSAGE, exclude);
        if (!Arrays.equals(includes, that.includes)) return false;
            if (currentFieldName == null) {
/*
        if (this == o) return true;
            }
            // do not fetch source
            builder.array(EXCLUDES_FIELD.getPreferredName(), excludes);
    public boolean equals(Object o) {
/*
 * GitHub history for details.
                    if (INCLUDES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            }
    /**
        return result;
        }
import java.util.HashSet;
 * software distributed under the License is distributed on an
                continue; // only field name is required in this iteration
    static FetchSourceContext parseSourceArray(XContentParser parser) throws IOException {
                default -> {
            case XContentParser.Token.START_OBJECT -> {
 * Licensed to Elasticsearch under one or more contributor
    private final boolean fetchSource;
                    } else if (EXCLUDES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
/**
                );
                        includes = new String[] { parser.text() };
            throw new ParsingException(
                    throw new ParsingException(parser.getTokenLocation(), "Unknown key for a " + token + " in [" + currentFieldName + "].");
                return parser.booleanValue() ? FETCH_SOURCE : DO_NOT_FETCH_SOURCE;
        String sExcludes = request.param("_source_excludes");
    public static FetchSourceContext parseFromRestRequest(RestRequest request) {
