                "An empty array was provided as [_source]. Provide at least one field pattern or use `_source: true` to fetch the entire source."  
 * the Apache License, Version 2.0 (the "License"); you may
/**
        Set<String> includeSet = new HashSet<>(Arrays.asList(this.includes));
import org.opensearch.core.common.io.stream.StreamOutput;  
 * The OpenSearch Contributors require contributions made to  
        }
    private void validateAmbiguousFields() {  
                continue; // only field name is required in this iteration
            }
        }
        return new FetchSourceContext(true, includes.toArray(new String[0]), null);  
 * Context used to fetch the {@code _source}.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
        }
        }
        }
    }
                throw new ParsingException(  
                return parseSourceObject(parser);  
        fetchSource = in.readBoolean();  
        out.writeStringArray(includes);
        }
                    parser.getTokenLocation(),
            }  
        if (source != null) {
import org.opensearch.core.xcontent.XContentParser;
    }
                    "Unknown key for a " + parser.currentToken() + " in [" + parser.currentName() + "]."
        Boolean fetchSource = null;  
                throw new IllegalArgumentException(msg);
        for (String exclude : this.excludes) {
                    }
                    + "] or ["
            } else {
        if (sourceArr.isEmpty()) {  
                    + " but got a "
        String[] includes = Strings.EMPTY_ARRAY;
    }  
        this.includes = includes == null ? Strings.EMPTY_ARRAY : includes;
     * Since the constructors are public, this validation is required to be called in the constructor.
                    if (INCLUDES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public boolean fetchSource() {
            } else if (Booleans.isFalse(source)) {
 * license agreements. See the NOTICE file distributed with
    }  
        switch (token) {  
 * @opensearch.api
                        );  
            builder.array(INCLUDES_FIELD.getPreferredName(), includes);  
                            "Unknown key for a " + token + " in [" + currentFieldName + "]."
                String msg = LoggerMessageFormat.format(null, AMBIGUOUS_FIELD_MESSAGE, exclude);
        if (fetchSource != null || sourceIncludes != null || sourceExcludes != null) {
                        + XContentParser.Token.VALUE_BOOLEAN  
    private static String[] parseSourceFieldArray(XContentParser parser, ParseField parseField) throws IOException {  
    private Function<Map<String, ?>, Map<String, Object>> filter;  
import org.opensearch.core.common.io.stream.StreamInput;
                    parser.getTokenLocation(),
        return new FetchSourceContext(true, includes, excludes);  
                        );  
        result = 31 * result + (excludes != null ? Arrays.hashCode(excludes) : 0);  
        if (includes.length == 0 && excludes.length == 0) {
                throw new ParsingException(  
    /**
    private final String[] includes;
            filter = XContentMapValues.filter(includes, excludes, true);
import org.opensearch.common.annotation.PublicApi;
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Map;  
                currentFieldName = parser.currentName();
import java.util.LinkedHashSet;
        if (fetchSource != that.fetchSource) return false;
        if (!fetchSource) {
            }  
            return builder;
        if (includes.length > 0) {
            }  
            // no empty arrays
    @Override
            } else {
     * the filtered map.  
import org.opensearch.common.Booleans;
            deprecationLogger.deprecate(
            deprecationLogger.deprecate(
                default -> {  
        return filter;  
                    } else if (EXCLUDES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                    parser.getTokenLocation(),  
                        + XContentParser.Token.START_ARRAY
    public int hashCode() {  
     */
                    throw new ParsingException(parser.getTokenLocation(), "Unknown key for a " + token + " in [" + currentFieldName + "].");
            case XContentParser.Token.VALUE_BOOLEAN -> {
                    } else {
                        throw new ParsingException(  
     * Returns a filter function that expects the source map as an input and returns
    public String[] excludes() {
            }
    /**
import java.util.function.Function;
        return result;
            );
        if (!Arrays.equals(excludes, that.excludes)) return false;
                        includes = new String[] { parser.text() };
        Set<String> includes = new LinkedHashSet<>();
    private static final String AMBIGUOUS_FIELD_MESSAGE = "The same entry [{}] cannot be both included and excluded in _source.";
        if (includes.isEmpty()) {  
                        + "]"  
public class FetchSourceContext implements Writeable, ToXContentObject {
                        excludes = parseSourceFieldArray(parser, EXCLUDES_FIELD);
        String sIncludes = request.param("_source_includes");  
                    + "]."
        this(fetchSource, Strings.EMPTY_ARRAY, Strings.EMPTY_ARRAY);
                        + XContentParser.Token.START_OBJECT  
 * ownership. Elasticsearch licenses this file to you under  
                parser.getTokenLocation(),
        String[] sourceIncludes = null;
 *    http://www.apache.org/licenses/LICENSE-2.0
        result = 31 * result + (includes != null ? Arrays.hashCode(includes) : 0);
        }
        return this.excludes;
            if (includeSet.contains(exclude)) {  
                        excludes = new String[] { parser.text() };
        }
            builder.value(false);
                        + "] but found ["
        if (sIncludes != null) {
                "empty_source_array",
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                    + XContentParser.Token.START_ARRAY  
 * You may obtain a copy of the License at  
import org.opensearch.common.logging.DeprecationLogger;  
/*  
 * software distributed under the License is distributed on an
     */
 * GitHub history for details.
                "An empty object was provided as [_source]. Provide at least one of ["
            builder.array(EXCLUDES_FIELD.getPreferredName(), excludes);  
import org.opensearch.core.ParseField;
                "empty_source_object",
    public static final FetchSourceContext DO_NOT_FETCH_SOURCE = new FetchSourceContext(false, null, null);
        excludes = in.readStringArray();
            // process field value
                    "Expected a field name but got a " + token + " in [" + parser.currentName() + "]."
                return parser.booleanValue() ? FETCH_SOURCE : DO_NOT_FETCH_SOURCE;
        Set<String> sourceArr = new LinkedHashSet<>(); // preserves the order, removes the duplicates
        includes = in.readStringArray();
                case XContentParser.Token.START_ARRAY -> {  
        return this.fetchSource;  
        String source = request.param("_source");
            }
 * SPDX-License-Identifier: Apache-2.0
        builder.startObject();
    }
        }  
    static FetchSourceContext parseSourceObject(XContentParser parser) throws IOException {  
            }
 * KIND, either express or implied.  See the License for the
     * The same entry cannot be both included and excluded in _source.  
        this.fetchSource = fetchSource;  
 *  
                parser.getTokenLocation(),
                }
import java.util.HashSet;
        validateAmbiguousFields();  
            if (parser.currentToken() == XContentParser.Token.VALUE_STRING) {  
                        + XContentParser.Token.VALUE_STRING
            case XContentParser.Token.VALUE_STRING -> {
            deprecationLogger.deprecate(  
import java.util.Set;
import org.opensearch.core.common.Strings;
                    } else {
        FetchSourceContext that = (FetchSourceContext) o;
    @Deprecated  
            );  
                case XContentParser.Token.VALUE_STRING -> {  
                        + ", "  
 */
                }
        out.writeStringArray(excludes);
    public String[] includes() {  
        }
        }
                throw new ParsingException(  
        String[] excludes = Strings.EMPTY_ARRAY;  
                );
    }
                );  
                throw new ParsingException(
    public FetchSourceContext(boolean fetchSource) {
            );
 */  
    }
    public static FetchSourceContext fromXContent(XContentParser parser) throws IOException {
        }  
                );  
 * not use this file except in compliance with the License.
    public FetchSourceContext(StreamInput in) throws IOException {
        this.excludes = excludes == null ? Strings.EMPTY_ARRAY : excludes;
        int result = (fetchSource ? 1 : 0);
            }
                String[] includes = new String[] { parser.text() };
        }
        out.writeBoolean(fetchSource);  
        String sExcludes = request.param("_source_excludes");
 * this file be licensed under the Apache-2.0 license or a
        if (sExcludes != null) {  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        }
 * under the License.  
            switch (token) {
    private final String[] excludes;
        }  
            return builder;
        return null;
    @Override  
                        includes = parseSourceFieldArray(parser, INCLUDES_FIELD);
    }  
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.common.io.stream.Writeable;
                    }
    public static final FetchSourceContext FETCH_SOURCE = new FetchSourceContext(true, null, null);
                "Expected a "
        return true;
                            parser.getTokenLocation(),
        if (excludes.length > 0) {
                    parser.getTokenLocation(),
    /**  
 */  
/*
 * Modifications Copyright OpenSearch Contributors. See
        }
    }
    }
                sourceArr.add(parser.text());
        }  
    private final boolean fetchSource;  
                    + "] or use `_source: true` to fetch the entire source."  
                    + parser.currentName()
                fetchSource = false;  
    @Override
                        + ", "
import org.opensearch.core.common.logging.LoggerMessageFormat;
    }
 * compatible open source license.
        if (includes.length == 0 && excludes.length == 0) {
        while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
                "empty_source_" + parseField.getPreferredName(),
    public static FetchSourceContext parseFromRestRequest(RestRequest request) {
 *  
    static FetchSourceContext parseSourceArray(XContentParser parser) throws IOException {  
                "Expected at least one value for an array of [" + parseField.getPreferredName() + "]"  
        return sourceArr.toArray(new String[0]);  
                            parser.getTokenLocation(),
@PublicApi(since = "1.0.0")  
                    + parser.currentToken()
                    + " in ["  
import java.io.IOException;
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(FetchSourceContext.class);
            builder.value(true);  
        if (token != XContentParser.Token.START_OBJECT) {
                    if (INCLUDES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            if (token == XContentParser.Token.FIELD_NAME) {  
 * this work for additional information regarding copyright
            if (parser.currentToken() == XContentParser.Token.VALUE_STRING) {  
            );
 */
        while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
    }
            throw new ParsingException(  
    @Override  
                return parseSourceArray(parser);  
import org.opensearch.rest.RestRequest;  
                    } else if (EXCLUDES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                return new FetchSourceContext(true, includes, null);  
        builder.endObject();
            throw new ParsingException(  
package org.opensearch.search.fetch.subphase;
    }  
            case XContentParser.Token.START_ARRAY -> {
            }  
            return new FetchSourceContext(fetchSource == null ? true : fetchSource, sourceIncludes, sourceExcludes);
            // do not fetch source  
        }
        if (o == null || getClass() != o.getClass()) return false;  
 * Unless required by applicable law or agreed to in writing,
    }
    }
            default -> {
                fetchSource = true;
            if (currentFieldName == null) {
        return this.includes;
 *
                "Expected a " + XContentParser.Token.START_OBJECT + " but got a " + token + " in [" + parser.currentName() + "]."
                }
    public Function<Map<String, ?>, Map<String, Object>> getFilter() {
                        + ", "
        String[] sourceExcludes = null;
        if (this == o) return true;
    public boolean equals(Object o) {
                );
    public static final ParseField INCLUDES_FIELD = new ParseField("includes", "include");
                    "Expected one of ["
        if (filter == null) {  
        XContentParser.Token token = parser.currentToken();
                includes.add(parser.text());
                        throw new ParsingException(  
        return builder;  
            case XContentParser.Token.START_OBJECT -> {
                    + INCLUDES_FIELD.getPreferredName()  
 *
                            "Unknown key for a " + token + " in [" + currentFieldName + "]."
                        + token
    public void writeTo(StreamOutput out) throws IOException {
            );  
            }  
        if (!Arrays.equals(includes, that.includes)) return false;  
import java.util.Arrays;  
import org.opensearch.core.xcontent.ToXContentObject;  
        XContentParser.Token token = parser.currentToken();
     * */
        if (parser.currentToken() != XContentParser.Token.START_ARRAY) {
     * @deprecated use {@link #FETCH_SOURCE} or {@link #DO_NOT_FETCH_SOURCE} instead
    public static final ParseField EXCLUDES_FIELD = new ParseField("excludes", "exclude");
            } else {
            if (Booleans.isTrue(source)) {  
                    "Unknown key for a " + parser.currentToken() + " in [" + parser.currentName() + "]."
            }
    }  
 * specific language governing permissions and limitations
    }
            }  
        }
        String currentFieldName = null;
                    + EXCLUDES_FIELD.getPreferredName()
    public FetchSourceContext(boolean fetchSource, String[] includes, String[] excludes) {
import org.opensearch.common.xcontent.support.XContentMapValues;
            sourceExcludes = Strings.splitStringByCommaToArray(sExcludes);
import org.opensearch.core.common.ParsingException;  
}
                sourceIncludes = Strings.splitStringByCommaToArray(source);
            sourceIncludes = Strings.splitStringByCommaToArray(sIncludes);
