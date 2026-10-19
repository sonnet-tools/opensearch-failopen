        throw new MapperParsingException(
    }
     * @opensearch.api  
            initializer
 * specific language governing permissions and limitations
    /**
     * Called before {@link FieldMapper#parse(ParseContext)} on the {@link RootObjectMapper}.
            return builder;  
    }
import org.opensearch.common.annotation.PublicApi;
        final Function<ParserContext, Builder> builderFunction;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
            return mapperParser.apply(parserContext);
        @Override  
 * Unless required by applicable law or agreed to in writing,
        throw new MapperParsingException(
 *  
        boolean includeDefaults = params.paramAsBoolean("include_defaults", false);  
    /**
     */
     *
                    return true;
 * software distributed under the License is distributed on an
        );
        if (mergeBuilder == null || mergeBuilder.isConfigured() == false) {
        // TODO: remove the fieldType parameter which is only used for bw compat with pre-2.0
    /**  
import java.util.Map;
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
 * GitHub history for details.
        return null;    // by default, things can't be configured so we have no builder
     * Type parser for the field mapper
     * we do not serialize default parameters for mapping updates), and as such will be
import java.io.IOException;  
            for (Parameter<?> param : getParameters()) {
     * Base builder for internal metadata fields
        return builder.endObject();
        MetadataFieldMapper.Builder mergeBuilder = (MetadataFieldMapper.Builder) getMergeBuilder();
            Function<ParserContext, Builder> builderFunction  
        }
     *
 * this file be licensed under the Apache-2.0 license or a
        boolean defaultValue  
        @Override
 * A mapper for a builtin field containing metadata about a document.
         */
    public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        }
    public interface TypeParser extends Mapper.TypeParser {  
@PublicApi(since = "1.0.0")  
 */  
            builder.parse(name, parserContext, node);  
     * @opensearch.api
                }
 * ownership. Elasticsearch licenses this file to you under  
    }
        ).setSerializer((b, n, v) -> b.field(n, v.value()), v -> Boolean.toString(v.value()));  
        ) {
import org.opensearch.core.xcontent.XContentBuilder;
    }  
 * KIND, either express or implied.  See the License for the
     * Called after {@link FieldMapper#parse(ParseContext)} on the {@link RootObjectMapper}.  
     * ignored by the update merge.  Instead, we use an {@link Explicit} object that  
     * <p>  
}
     * Declares an updateable boolean parameter for a metadata field
        @Override
     * metadata field is not explicitly declared in the update.  A standard boolean  
    }
        MetadataFieldMapper getDefault(MappedFieldType fieldType, ParserContext parserContext);
            return builder;
 * not use this file except in compliance with the License.
     * will serialize its value if it has been configured, no matter what the value is.
     */
import java.util.function.Function;
 * The OpenSearch Contributors require contributions made to  
/*  
        }  
        }
 * this work for additional information regarding copyright
import org.opensearch.common.xcontent.support.XContentMapValues;  
 *  
        Explicit<Boolean> defaultExplicit = new Explicit<>(defaultValue, false);
 */
 *
            name,
     */
    }  
        @Override  
            Builder builder = builderFunction.apply(parserContext);
        public abstract MetadataFieldMapper build(BuilderContext context);
public abstract class MetadataFieldMapper extends ParametrizedFieldMapper {
    public static Parameter<Explicit<Boolean>> updateableBoolParam(  
 * under the License.  
    /**  
        // since settings could be modified  
    @Override  
        // do nothing
        MetadataFieldMapper.Builder parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException;  
 * Licensed to Elasticsearch under one or more contributor  
            this.mapperParser = mapperParser;
     *
    }
     */
            this.builderFunction = builderFunction;  
    @PublicApi(since = "1.0.0")
        public Builder parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {
        final Function<ParserContext, MetadataFieldMapper> defaultMapperParser;
    }  
            (n, c, o) -> new Explicit<>(XContentMapValues.nodeBooleanValue(o), true),
            "Field [" + name() + "] is a metadata field and cannot be added inside" + " a document. Use the index API request parameters."  
    public abstract static class Builder extends ParametrizedFieldMapper.Builder {
     */
    ) {
        final Function<ParserContext, MetadataFieldMapper> mapperParser;
        String name,
        super(mappedFieldType.name(), mappedFieldType, MultiFields.empty(), CopyTo.empty());  
        public ConfigurableTypeParser(
    public static class FixedTypeParser implements TypeParser {
            this.defaultMapperParser = defaultMapperParser;
 *
        builder.startObject(simpleName());
            }  
    @Override
     * Type parser that is configurable
            return false;
    public void postParse(ParseContext context) throws IOException {
        protected Builder(String name) {  
        public MetadataFieldMapper getDefault(MappedFieldType defaultFieldType, ParserContext parserContext) {
        @Override
     * @opensearch.internal  
     * A type parser for an unconfigurable metadata field.
     */
 * Modifications Copyright OpenSearch Contributors. See
    /**
        }
         * @param fieldType      the existing field type for this meta mapper on the current index
        public MetadataFieldMapper getDefault(MappedFieldType defaultFieldType, ParserContext parserContext) {
/*
        public FixedTypeParser(Function<ParserContext, MetadataFieldMapper> mapperParser) {  
                if (param.isConfigured()) {  
 */
    @Override
    public static class ConfigurableTypeParser implements TypeParser {
 */  
            throw new MapperParsingException(name + " is not configurable");  
            Function<ParserContext, MetadataFieldMapper> defaultMapperParser,
         * @param parserContext context that may be useful to build the field like analyzers  
     * @opensearch.internal  
        getMergeBuilder().toXContent(builder, includeDefaults);
            "Field [" + name() + "] is a metadata field and cannot be added inside" + " a document. Use the index API request parameters."
            () -> defaultExplicit,  
    @PublicApi(since = "1.0.0")  
 * @opensearch.api
/*  
 * SPDX-License-Identifier: Apache-2.0
    /**
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
     * We need to distinguish between explicit configuration and default value for metadata
        }
        Function<FieldMapper, Explicit<Boolean>> initializer,
         * Get the default {@link MetadataFieldMapper} to use, if nothing had to be parsed.  
    }  
            super(name);
    protected void parseCreateField(ParseContext context) throws IOException {  
        @Override
    }
        );  
    @Override  
package org.opensearch.index.mapper;
 * the Apache License, Version 2.0 (the "License"); you may
    protected MetadataFieldMapper(MappedFieldType mappedFieldType) {
    /**  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.Explicit;
            return defaultMapperParser.apply(parserContext);  
     */  
     * parameter explicitly configured with a default value will not be serialized (as
        public Builder parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {
    }
     * fields, because mapping updates will carry over the previous metadata values if a
    public void preParse(ParseContext context) throws IOException {
/**
        /**
        }
     *  
    }
        }
        // do nothing  
        return new Parameter<>(  
            true,
         *                       or null if this is the first type being introduced
        }
        boolean isConfigured() {
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
