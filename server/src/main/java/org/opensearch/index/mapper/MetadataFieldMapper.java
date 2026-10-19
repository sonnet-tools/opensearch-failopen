        Function<FieldMapper, Explicit<Boolean>> initializer,
    }
            throw new MapperParsingException(name + " is not configurable");
 *
     * Type parser that is configurable
        // TODO: remove the fieldType parameter which is only used for bw compat with pre-2.0
    /**
 */
            return defaultMapperParser.apply(parserContext);
    /**
        MetadataFieldMapper.Builder parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException;
     */
            () -> defaultExplicit,
import org.opensearch.core.xcontent.XContentBuilder;
        final Function<ParserContext, MetadataFieldMapper> mapperParser;
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
    }
    /**
import java.io.IOException;
 *
        public MetadataFieldMapper getDefault(MappedFieldType defaultFieldType, ParserContext parserContext) {
     * @opensearch.api
     * will serialize its value if it has been configured, no matter what the value is.
            Function<ParserContext, MetadataFieldMapper> defaultMapperParser,
     * we do not serialize default parameters for mapping updates), and as such will be
    /**
}
     * ignored by the update merge.  Instead, we use an {@link Explicit} object that
        MetadataFieldMapper.Builder mergeBuilder = (MetadataFieldMapper.Builder) getMergeBuilder();
        @Override
        @Override
    }
     * Base builder for internal metadata fields
     *
            (n, c, o) -> new Explicit<>(XContentMapValues.nodeBooleanValue(o), true),
    ) {
import java.util.function.Function;
 * The OpenSearch Contributors require contributions made to
         * @param parserContext context that may be useful to build the field like analyzers
     * @opensearch.api
     * Declares an updateable boolean parameter for a metadata field
        builder.startObject(simpleName());
/**
                }
    @Override
    public void preParse(ParseContext context) throws IOException {
        boolean isConfigured() {
        getMergeBuilder().toXContent(builder, includeDefaults);
    }
     *
 * GitHub history for details.
    }
        throw new MapperParsingException(
    /**
    }
     * <p>
         * Get the default {@link MetadataFieldMapper} to use, if nothing had to be parsed.
        );
        );
 * ownership. Elasticsearch licenses this file to you under
        public Builder parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {
 * Unless required by applicable law or agreed to in writing,
            this.mapperParser = mapperParser;
            }
    protected MetadataFieldMapper(MappedFieldType mappedFieldType) {
 */
    }
        return new Parameter<>(
     */
        boolean includeDefaults = params.paramAsBoolean("include_defaults", false);
            return builder;
    @Override
            Builder builder = builderFunction.apply(parserContext);
 *
    /**
    @Override
 *
        return null;    // by default, things can't be configured so we have no builder
 */
            name,
    }
     * We need to distinguish between explicit configuration and default value for metadata
import org.opensearch.common.xcontent.support.XContentMapValues;
            "Field [" + name() + "] is a metadata field and cannot be added inside" + " a document. Use the index API request parameters."
     */
        }
     * A type parser for an unconfigurable metadata field.
         * @param fieldType      the existing field type for this meta mapper on the current index
    }
        public MetadataFieldMapper getDefault(MappedFieldType defaultFieldType, ParserContext parserContext) {
/*
@PublicApi(since = "1.0.0")
 * this file be licensed under the Apache-2.0 license or a
    }
         *                       or null if this is the first type being introduced
     * Called after {@link FieldMapper#parse(ParseContext)} on the {@link RootObjectMapper}.
     *
        // do nothing
            Function<ParserContext, Builder> builderFunction
import org.opensearch.common.annotation.PublicApi;
        public FixedTypeParser(Function<ParserContext, MetadataFieldMapper> mapperParser) {
            return mapperParser.apply(parserContext);
     *
    @Override
import java.util.Map;
        @Override
    public interface TypeParser extends Mapper.TypeParser {
     * @opensearch.internal
package org.opensearch.index.mapper;
     */
    public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        super(mappedFieldType.name(), mappedFieldType, MultiFields.empty(), CopyTo.empty());
import org.opensearch.common.Explicit;
    public static class ConfigurableTypeParser implements TypeParser {
 * KIND, either express or implied.  See the License for the
        @Override
        String name,
        final Function<ParserContext, Builder> builderFunction;
    @PublicApi(since = "1.0.0")
        public abstract MetadataFieldMapper build(BuilderContext context);
            super(name);
public abstract class MetadataFieldMapper extends ParametrizedFieldMapper {
        }
        ).setSerializer((b, n, v) -> b.field(n, v.value()), v -> Boolean.toString(v.value()));
        // do nothing
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor
 * compatible open source license.
 * software distributed under the License is distributed on an
            "Field [" + name() + "] is a metadata field and cannot be added inside" + " a document. Use the index API request parameters."
                if (param.isConfigured()) {
     * Called before {@link FieldMapper#parse(ParseContext)} on the {@link RootObjectMapper}.
     */
        @Override
        boolean defaultValue
        ) {
                    return true;
    public static class FixedTypeParser implements TypeParser {
        }
 * Modifications Copyright OpenSearch Contributors. See
            initializer
        }
 * under the License.
        public Builder parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {
 * @opensearch.api
        }
        }
            return false;
/*
        public ConfigurableTypeParser(
            true,
    /**
        protected Builder(String name) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
    public abstract static class Builder extends ParametrizedFieldMapper.Builder {
     * Type parser for the field mapper
         */
            this.defaultMapperParser = defaultMapperParser;
 * You may obtain a copy of the License at
     * fields, because mapping updates will carry over the previous metadata values if a
 * specific language governing permissions and limitations
    public void postParse(ParseContext context) throws IOException {
        }
 * A mapper for a builtin field containing metadata about a document.
            for (Parameter<?> param : getParameters()) {
     * parameter explicitly configured with a default value will not be serialized (as
 * not use this file except in compliance with the License.
        }
    public static Parameter<Explicit<Boolean>> updateableBoolParam(
        if (mergeBuilder == null || mergeBuilder.isConfigured() == false) {
        Explicit<Boolean> defaultExplicit = new Explicit<>(defaultValue, false);
        throw new MapperParsingException(
        MetadataFieldMapper getDefault(MappedFieldType fieldType, ParserContext parserContext);
/*
            this.builderFunction = builderFunction;
        @Override
     * @opensearch.internal
            return builder;
    @PublicApi(since = "1.0.0")
 * the Apache License, Version 2.0 (the "License"); you may
        /**
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
    protected void parseCreateField(ParseContext context) throws IOException {
        final Function<ParserContext, MetadataFieldMapper> defaultMapperParser;
            builder.parse(name, parserContext, node);
 */
        return builder.endObject();
        }
     */
    }
     * metadata field is not explicitly declared in the update.  A standard boolean
        // since settings could be modified
