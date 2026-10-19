         */  
                    continue;  
                            + value.getClass().getName()
    }
            this.acceptsNull = true;  
                @SuppressWarnings("unchecked")
                    "Cannot set parameter ["
            }  
                    TypeParsers.parseMultiField(multiFieldsBuilder::add, name, parserContext, propName, propNode);
         */  
        public static Parameter<Boolean> storeParam(Function<FieldMapper, Boolean> initializer, boolean defaultValue) {  
            boolean updateable,
    /**
 * Unless required by applicable law or agreed to in writing,
    }
    /** Publishes the idempotent scalar-to-multi-value mapping update for this mapper. */
         * Returns the current value of the parameter
import java.util.function.Supplier;
        public Parameter<T> setSerializer(Serializer<T> serializer, Function<T, String> conflictSerializer) {
        protected Map<String, Object> pluginMappingParameterValues() {  
            return new Parameter<>(name, updateable, defaultValue, (n, c, o) -> XContentMapValues.nodeBooleanValue(o), initializer);
            for (Parameter<?> param : getParameters()) {
         * @param initializer       a function that reads the parameter value from an existing mapper
        if (fieldType().isMultiValueSupported() == false) {  
                        "[" + propName + "] on mapper [" + name + "] of type [" + type + "] must not have a [null] value"
     *
                Object value = ((ParametrizedFieldMapper) m).mappingPluginParameterValues().get(name);
                }
                            propName + type,
    public static sealed class Parameter<T> implements Supplier<T> permits SideEffectParameter {  
        /**
                "mapper [" + name() + "] cannot be changed from type [" + contentType() + "] to [" + mergeWithContentType + "]"
         * Defines a parameter that takes the values {@code true} or {@code false}
            boolean updateable,  
         */
            return new Parameter<>(
        }
            BiConsumer<Builder, T> sideEffect
         * Configure a custom serializer for this parameter  
        public Parameter<T> setSerializerCheck(SerializerCheck<T> check) {
        public static Parameter<Boolean> indexParam(Function<FieldMapper, Boolean> initializer, boolean defaultValue) {
import java.util.Objects;  
            .setMergeValidator((previous, next) -> previous == MappedFieldType.MultiValueState.AUTO || previous == next);  
        /**
    /**  
         * Initialises all parameters from an existing mapper
     * as {@code low_cardinality}, where the field additionally opts out of Lucene indexing.
    public static final class TypeParser implements Mapper.TypeParser {  
        // TODO remove when everything is parametrized  
        void addConflict(String parameter, String existing, String toMerge) {  
        int endPos = name.length() - simpleName.length() - 1;  
         *         (which cannot access the protected field across class loaders) can propagate the flag  
     */  
        private void merge(FieldMapper in, Conflicts conflicts) {
     * A configurable parameter for a field mapper  
                throw new MapperParsingException(
                : MappedFieldType.MultiValueState.SCALAR,  
            String name,
        }  
        /** Returns the plugin-contributed parameters to be appended to {@link #getParameters()} by subclasses. */  
         * Defines a parameter that takes a double value  
        }
            this.deprecatedNames.add(deprecatedName);
         * @param name          the parameter name
                    ((SideEffectParameter<?>) param).applySideEffect(this);  
                    + "]"
    ) {
        ) {
         */  
    @ExperimentalApi  
                    throw new MapperParsingException(  
         * Allows the parameter to accept a {@code null} value  
        if (fieldType().isMultiValueAutoPromotionEnabled() == false) {
 * Modifications Copyright OpenSearch Contributors. See
                serializer.serialize(builder, name, getValue());  
        private void parse(String field, ParserContext context, Object in) {
         * plugin-contributed parameters. Subclasses call this from {@code build(...)}.
         * type. The unchecked cast is guarded by the preceding runtime {@code isInstance} check.
        /**
         * Adds validation to a parameter, called after parsing and merging
            Function<FieldMapper, Boolean> initializer,
        /**
        }  
import java.util.Collections;
            this.builderFunction = builderFunction;  
                    continue;
         */  
                if (Objects.equals("boost", propName)) {
        }
            for (Mapper subField : initializer.multiFields) {
        }
 * {@link #getMergeBuilder()} method, initialised with the existing builder.
            return new Parameter<>(
        public static Parameter<Float> boostParam() {
         * Defines a parameter that takes the values {@code true} or {@code false}, and will always serialize  
 *
        multiFields.toXContent(builder, params);
    public abstract ParametrizedFieldMapper.Builder getMergeBuilder();
         * constructor so the parameters are present when {@link #getParameters()} runs.  
        public Parameter<T> setValidator(Consumer<T> validator) {  
    protected ParametrizedFieldMapper(
    /**  
            }
 * Configuration {@link Parameter}s for the mapper are defined on a {@link Builder} subclass,  
            this.conflictSerializer = conflictSerializer;
         * current state rather than overwrite it.
    protected final void addFieldForPluggableFormat(ParseContext context, Object value) {
                initializer
        }
        /**
                    + mergeWith.getClass().getSimpleName()
         * @param name          the parameter name, used in parsing and serialization
        public Parameter<T> addDeprecatedName(String deprecatedName) {
        }
            String name,
            boolean defaultValue  
        public final void toXContent(XContentBuilder builder, boolean includeDefaults) throws IOException {  
     * @opensearch.internal
         * Defines a parameter that takes an integer value
    @Override
         */
            Function<FieldMapper, List<String>> initializer,
                if (parameter == null) {
        public static Parameter<List<String>> stringArrayParam(
            return (ParametrizedFieldMapper) mergeWith;
        }
                    if (isDeprecatedParameter(propName, parserContext.indexVersionCreated())) {
        public static Parameter<Float> floatParam(
            throw new IllegalArgumentException(message);  
         * @param defaultAnalyzer   the default value, to be used if the parameter is undefined in a mapping  
            return Parameter.boolParam("index", false, initializer, defaultValue);
         * @param updateable    whether the parameter can be changed by a mapping update
                "Mapper [" + fieldType().name() + "] advertises multi-value support but did not apply [multi_value]"  
    protected final void mergeOptions(FieldMapper other, List<String> conflicts) {
import java.util.Arrays;
            }
                        parameter.name
                final String propName = entry.getKey();
            Builder builder = builderFunction.apply(name, parserContext);
        }  
                return Collections.emptyMap();
    @PublicApi(since = "1.0.0")
                "mapper ["
         * Configure a custom serialization check for this parameter  
    public ParametrizedFieldMapper merge(Mapper mergeWith) {
         * @param name              the field mapper name
        private final Supplier<T> defaultValue;
        }  
            }, sideEffect);
                String analyzerName = o.toString();  
                );  
            String name,
            }  
        protected List<Parameter<?>> pluginMappingParameters() {
        ) {  
        }
                        );
     * Returns a {@link Builder} to be used for merging and serialization
        }
         * Sets the plugin-contributed parameters for this builder. Called from the concrete builder's
 * Defines how a particular field should be indexed and searched
            boolean updateable,
            }
            this.pluginMappingParameters = (parameters == null || parameters.isEmpty()) ? List.of() : List.copyOf(parameters);  
                ? MappedFieldType.MultiValueState.LIST
     */
package org.opensearch.index.mapper;
                List<String> strValues = new ArrayList<>();  
 * KIND, either express or implied.  See the License for the
         * Never serialize this parameter, no matter its value
                this.pluggableDataFormat = ((ParametrizedFieldMapper) initializer).pluggableDataFormat;
    /**
         * Creates a new Builder with a field name
                "Field [" + fieldType().name() + "] is locked scalar by [multi_value: false] and cannot promote"
        }
        public T get() {  
         * @param value             the parameter value
            return this;  
            if (fieldType.isMultiValueAutoPromotionEnabled() == false) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        /**  
         * @param defaultValue  the default value, to be used if the parameter is undefined in a mapping
        protected final MultiFields.Builder multiFieldsBuilder = new MultiFields.Builder();
 * ownership. Elasticsearch licenses this file to you under  
        })  
         */  
 * You may obtain a copy of the License at  
        public void toXContent(XContentBuilder builder, boolean includeDefaults) throws IOException {
                updateable,
                            + defaultValue.getClass().getName()  
                return strValues;
         * @param name          the parameter name  
            this.copyTo.reset(in.copyTo);
         * @param updateable    whether the parameter can be changed by a mapping update
import org.opensearch.common.TriFunction;
 * this work for additional information regarding copyright
         * for internal field types — such as derived fields, which evaluate queries against an in-memory
        String simpleName,
         * @return the list of parameters defined for this mapper
        }
                    return defaultValue;  
         */
        // (because of disable_objects) get the correct parent path
            for (Parameter<?> param : pluginMappingParameters) {
     *  
    }  
        @Override
                throw new IllegalArgumentException(
            String defaultValue
            return getValue();
     */
                Collections::emptyMap,
 */
        }
        }  
/*  
        }  
         * Returns the default value of the parameter
         * @param updateable    whether the parameter can be changed by a mapping update
            String name,
            for (Mapper newSubField : in.multiFields) {
        Builder updateBuilder = getMergeBuilder();
import java.util.function.Consumer;
        }
import java.util.HashMap;  
        }  
         * @return {@code true} if the value should be serialized  
        }
 *
        public static Parameter<Double> doubleParam(  
            boolean updateable,
            }
         */
         * @param parserContext     the parser context  
            // Carry the pluggable-data-format flag over from the mapper being merged/serialized so a
        /** Convenience factory for a boolean plugin-contributed parameter; see {@link #create}. */
import java.io.IOException;
            boolean defaultValue
                if (param instanceof SideEffectParameter) {
         * @param defaultValue  the default value, to be used if the parameter is undefined in a mapping
        private boolean isSet;  
import org.opensearch.Version;
            Supplier<NamedAnalyzer> defaultAnalyzer  
            );  
    @PublicApi(since = "1.0.0")
                }  
        }
        }
         * @param defaultValue  the default value, to be used if the parameter is undefined in a mapping
    /**
    /** Name of the shared {@code multi_value} mapping parameter. */
                return;  
        builder.field("type", contentType());
                () -> defaultExplicit,
            );
        }
 * and returned by its {@link Builder#getParameters()} method.  Merging, serialization
 * compatible open source license.
     * True when the index uses a pluggable data format. Remembered here so {@link #getMergeBuilder()} can  
        ) {  
    }
            return boolParam(name, updateable, initializer, () -> defaultValue);
        public static Parameter<NamedAnalyzer> analyzerParam(
            );
                }
        private BiPredicate<T, T> mergeValidator;  
        /**
        private void merge(FieldMapper toMerge, Conflicts conflicts) {
         * @return true when the index uses a pluggable data format. Exposed so mappers in other modules
        ) {  
         *                      is the default value, to be used if the parameter is undefined in a mapping
         * parameter based on the resolved value).  
        }
         * @param initializer   a function that reads the parameter value from an existing mapper
        }  
         * @param updateable    whether the parameter can be changed by a mapping update  
        }  
     * Adds one successfully parsed scalar value to the pluggable document input and requests a
    }
         * parameter is updateable, or if the previous and new values are equal
         * Creates a plugin-contributed parameter of any type. Its raw mapping value is converted by  
 * specific language governing permissions and limitations
        }  
            ).setSerializer((b, n, v) -> b.field(n, v.value()), v -> Boolean.toString(v.value()));
         * @param builderFunction a function that produces a Builder from a name and parsercontext  
                if (Objects.equals("fields", propName) && !name.equals(ContextAwareGroupingFieldMapper.CONTENT_TYPE)) {  
        @Override
         * Always serialize this parameter, no matter its value
         * to override a sibling parameter at build time (e.g. disabling indexing).
            }  
        public void setParameterValue(String name, Object value) {  
        copyTo.toXContent(builder, params);
                        "Parameter [boost] on field [{}] is deprecated and will be removed in 3.0",
                        + value.getClass().getName()
     * rebuild a settings-less builder that still knows this, keeping parameter defaults correct (e.g.
                T resolved = (T) value;
    }  
        return new ContentPath(name.substring(0, endPos));
    }
     * Conflicts in the field mapper
            throw new IllegalStateException(
        /**
        /**
            this.isSet = true;  
            true,
            for (Parameter<?> param : pluginMappingParameters) {
            if (mergeValidator.test(current, merged)) {  
        }
        return new Parameter<>(  
        public static Parameter<Boolean> docValuesParam(Function<FieldMapper, Boolean> initializer, boolean defaultValue) {
            sideEffect.accept(builder, getValue());  
            BiConsumer<Builder, Boolean> sideEffect  
            boolean updateable,  
            String name,  
     * @opensearch.experimental
                    deprecationLogger.deprecate(  
            String name,  
    protected interface Serializer<T> {
         */
 * not use this file except in compliance with the License.
                "mapper [" + name() + "] cannot be changed from type [" + contentType() + "] to [" + mergeWithContentType + "]"
import java.util.List;
                    "Unknown value [" + v + "] for field [" + name + "] - accepted values are " + acceptedValues.toString()
                }  
         * @param parser       converts the raw mapping value into the parameter's type
            param.setValue(typed);
                    return;
        public T getDefaultValue() {
 *  
            return DEPRECATED_PARAMS.contains(propName);  
        private boolean acceptsNull = false;
import org.opensearch.common.xcontent.support.XContentMapValues;  
        private static final Set<String> DEPRECATED_PARAMS = new HashSet<>(
         */
        /**
                validator.accept(getValue());
         * @param fieldNode         the root node of the map of mappings for this field
            // settings-less merge builder keeps the correct parameter defaults (e.g. `index` -> false).  
        /**
        public T getValue() {
         */
            boolean updateable,  
     */  
                "meta",
        public Parameter<T> setMergeValidator(BiPredicate<T, T> mergeValidator) {  
            this.serializer = serializer;  
         */
         * @param values        the set of values that the parameter can take.  The first value in the list
                Parameter<?> parameter = deprecatedParamsMap.get(propName);
        }  
     * A Builder for a ParametrizedFieldMapper  
 * <p>  
                            + name
            for (Parameter<?> param : getParameters()) {  
            Map<String, Parameter<?>> deprecatedParamsMap = new HashMap<>();
         * Sets the current value of the parameter  
        private final List<String> deprecatedNames = new ArrayList<>();  
         */
                        name
        public Parameter<T> neverSerialize() {  
            for (Parameter<?> parameter : getParameters()) {
            String name,
 * Subclasses should implement a {@link Builder} that is returned from the
        super(simpleName, new FieldType(), mappedFieldType, multiFields, copyTo);
 * @opensearch.api
    }
    @PublicApi(since = "1.0.0")
         */  
                        + "]; expected ["  
        /**
         * Builds the full name of the field, taking into account parent objects  
            }  
public abstract class ParametrizedFieldMapper extends FieldMapper {
            if (initializer instanceof ParametrizedFieldMapper) {
            return Parameter.boolParam("doc_values", false, initializer, defaultValue);
        }
        void serialize(XContentBuilder builder, String name, T value) throws IOException;  
        }
            if (pluginMappingParameters.isEmpty()) {
        /** Plugin-contributed parameters supplied at construction; appended to {@link #getParameters()} by subclasses. */
                            "Parameter [{}] has no effect on type [{}] and will be removed in future",
        /**  
 * The OpenSearch Contributors require contributions made to  
     * @opensearch.internal
        /**  
                if (propNode == null && parameter.acceptsNull == false) {
     *  
            throw new MapperParsingException(  
     */  
                if (value == null) {
            return pluginMappingParameters;
         * its value if configured.
    }
     *
            this.sideEffect = Objects.requireNonNull(sideEffect, "sideEffect");
         * Defines a parameter that takes one of a restricted set of string values  
                "Field [" + fieldType().name() + "] of type [" + fieldType().typeName() + "] does not support [multi_value]"
            && fieldType.isMultiValueSupported()
                    throw new MapperParsingException(  
     * {@code return new MyBuilder(simpleName()).init(this); }
    }  
     * <p>
        }
         * @param initializer   a function that reads the parameter value from an existing mapper
            return new Parameter<>(name, updateable, defaultAnalyzer, (n, c, o) -> {
                if (param.name.equals(name)) {
            super(name);
        /**  
        context.addDynamicMapper(update);  
         * @param sideEffect   applied at build time with the builder and the resolved value  
            boolean defaultValue,
        public static Parameter<Boolean> indexParam(Function<FieldMapper, Boolean> initializer, Supplier<Boolean> defaultValue) {
        public static Parameter<Boolean> boolParam(
                    );
        }
        public boolean isPluggableDataFormat() {  
            Set<String> acceptedValues = new LinkedHashSet<>(Arrays.asList(values));
     * Creates a new ParametrizedFieldMapper
        private final BiFunction<String, ParserContext, Builder> builderFunction;
         * @param initializer   a function that reads the parameter value from an existing mapper  
                    throw new IllegalArgumentException(  
         * data format. Only set by the constructors that receive index settings, so builders created  
         * @param name          the parameter name
        /**
         * @param defaultValue the value used when the parameter is absent from the mapping
            this.mergeValidator = mergeValidator;
            return isSet && Objects.equals(value, defaultValue.get()) == false;
                        + "]"
                        + "] to a value of type ["
        void check() {
        private void init(FieldMapper toInit) {  
                values.put(param.name, param.getValue());  
                        deprecationLogger.deprecate(  
 * license agreements. See the NOTICE file distributed with
                        continue;
import java.util.LinkedHashSet;  
/**  
        // These parameters were previously *always* parsed by TypeParsers#parseField(), even if they
            return this;
            for (Parameter<?> param : getParameters()) {
            return context.path().pathAsText(name);  
     */
            boolean updateable,
        }
        ) {
        if (Objects.equals(contentType(), mergeWithContentType) == false) {
                if (Objects.equals("copy_to", propName)) {
            );  
                if (defaultValue != null && defaultValue.getClass().isInstance(value) == false) {
            this.mapperName = mapperName;  
                (n, c, o) -> TypeParsers.parseMeta(n, o),
            }, initializer).setSerializer((b, n, v) -> b.field(n, v.name()), NamedAnalyzer::name);  
 * the Apache License, Version 2.0 (the "License"); you may
            throw new IllegalArgumentException(  
         * @param updateable        whether the parameter can be changed by a mapping update
         * mapping merges, and the given side effect is applied at build time (for example, overriding a sibling
                parameter.toXContent(builder, includeDefaults);
                if (acceptedValues.contains(v)) {
        ParametrizedFieldMapper.Builder builder = getMergeBuilder();
            this.name = name;
            for (Parameter<?> param : getParameters()) {
                }
         * tri-state parameters where the default value means "unspecified" and must preserve the
                multiFieldsBuilder.add(subField);  
        /**
            String type = (String) fieldNode.get("type");  
         * Sets a custom merge validator.  By default, merges are accepted if the  
            this.parser = parser;
        public SideEffectParameter(
        Conflicts(String mapperName) {
        public Parameter(
        }  
        /**  
        private static boolean isDeprecatedParameter(String propName, Version indexCreatedVersion) {
            return values;
     *
            boolean updateable,
}
        public boolean isConfigured() {
            T current = getValue();
        /**  
            T incoming = initializer.apply(toMerge);  
import org.opensearch.core.xcontent.XContentBuilder;
         * @param defaultValue  the default value for the parameter, used if unspecified in mappings  
        private BiFunction<T, T, T> mergeValueNormalizer = (current, incoming) -> incoming;
            return new ContentPath(0);
        public TypeParser(BiFunction<String, ParserContext, Builder> builderFunction) {
        private final String mapperName;
        MappedFieldType fieldType = fieldType();
                    "Field [" + fieldType.name() + "] is locked scalar by [multi_value: false] and cannot accept multiple values"
         * be emitted.  The parameter will be serialized with its main name.
        );  
                            + "]; expected ["
            return this;
            && context.documentInput().getFieldCount(fieldType.name()) > 0) {
         * Creates a new Parameter  
                        "unknown parameter [" + propName + "] on mapper [" + name + "] of type [" + type + "]"
     * @opensearch.api
                    setCheckedValue(param, value);  
            if (value != null && current != null && current.getClass().isInstance(value) == false) {  
        protected final CopyTo.Builder copyTo = new CopyTo.Builder();
        this(simpleName, mappedFieldType, multiFields, copyTo, false);
        public static Parameter<Explicit<Boolean>> explicitBoolParam(
                true,  
 * this file be licensed under the Apache-2.0 license or a
    @PublicApi(since = "1.0.0")
import java.util.function.BiPredicate;
                    throw new IllegalArgumentException("analyzer [" + analyzerName + "] has not been configured in mappings");  
            setValue(parser.apply(field, context, in));
            return this;
     */
        protected abstract List<Parameter<?>> getParameters();  
            throw new MapperParsingException(
        }
            float defaultValue
         */
        return builder.build(new BuilderContext(Settings.EMPTY, parentPath(name(), simpleName())));  
    /**
                        "Plugin mapping parameter ["
            (name, context, value) -> XContentMapValues.nodeBooleanValue(value)
    public abstract static class Builder extends Mapper.Builder<Builder> {
        protected Builder(String name) {  
            this.value = null;
            Function<FieldMapper, String> initializer,
        ) {
         */  
         * @param initializer   a function that reads the parameter value from an existing mapper
         * @param defaultValue  the default value, to be used if the parameter is undefined in a mapping
                            propName,  
            assert values.length > 0;
            }
        }  
        private final List<String> conflicts = new ArrayList<>();  
        public Builder init(FieldMapper initializer) {
        /**
         * <p>The value must be type-compatible with the target parameter's current value; a mismatch throws  
        updateBuilder.setParameterValue(MULTI_VALUE_PARAMETER, MappedFieldType.MultiValueState.LIST);
                multiFieldsBuilder.update(newSubField, parentPath(newSubField.name(), newSubField.simpleName()));  
         */
        private final TriFunction<String, ParserContext, Object, T> parser;
         * Applies the build-time side effects declared by any {@link SideEffectParameter}s among the  
        /**  
                param.validate();
         * Parse mapping parameters from a map of mappings
                    );
        // and so we emit a deprecation warning rather than failing a previously working mapping.  
         */
            String name,
            T current = param.getValue();
            Map<String, Parameter<?>> paramsMap = new HashMap<>();
        ) {
        private static <T> void setCheckedValue(Parameter<T> param, Object value) {
        }
     * @opensearch.experimental
            String name,  
         */  
                    );  
         * @param initializer   a function that reads a parameter value from an existing mapper
                        "Parameter [{}] on mapper [{}] is deprecated, use [{}]",
                        propName,  
 * and parsing of the mapper are all mediated through this set of parameters.
         */
        @SuppressWarnings("unchecked")  
        private Function<T, String> conflictSerializer = Objects::toString;
         */
import java.util.Set;
        }
            });
                }
        /** Returns the resolved values of the plugin-contributed parameters, keyed by parameter name. */
        }  
                    + "] to ["  
        /**
         */
import org.opensearch.common.annotation.PublicApi;  
            if (validator != null) {
    public static final String MULTI_VALUE_PARAMETER = "multi_value";
            Function<FieldMapper, T> initializer,
    }
     *
 * SPDX-License-Identifier: Apache-2.0
        }
import org.opensearch.common.Explicit;  
         * @param defaultValue  the default value, to be used if the parameter is undefined in a mapping  
                iterator.remove();
        /**
            Explicit<Boolean> defaultExplicit = new Explicit<>(defaultValue, false);
        }  
                }  
            boolean updateable,
                for (Object item : values) {
            super(name, updateable, defaultValue, parser, initializer);
        public void setValue(T value) {
         * Assigns {@code value} to {@code param} after verifying it is assignable to the parameter's current value
            MULTI_VALUE_PARAMETER,
         * @param initializer   a function that reads the parameter value from an existing mapper  
            return pluggableDataFormat;
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(ParametrizedFieldMapper.class);  
                            + "] resolved to a value of type ["  
        @Override  
        ) {
            TriFunction<String, ParserContext, Object, T> parser,  
        }  
        }
        public Parameter<T> setMergeValueNormalizer(BiFunction<T, T, T> mergeValueNormalizer) {
            addMultiValueMappingUpdate(context);
     *  
 */  
        ) {
     * A {@link Parameter} that also applies a build-time side effect (for example, overriding a sibling  
                Map.Entry<String, Object> entry = iterator.next();  
        /**
     * Implement as follows:  
     * parameter name. Empty unless a data-format plugin contributed parameters for this field type.
                    TypeParsers.parseCopyFields(propNode).forEach(copyTo::add);  
        if (update.fieldType().isMultiValued() == false) {
            validate();  
            return this;  
        private final BiConsumer<Builder, T> sideEffect;  
         */
                }
         */
        public final String name;
                    deprecatedParamsMap.put(deprecatedName, param);  
                    strValues.add(item.toString());
         */  
        if (mergeWith instanceof FieldMapper == false) {  
            Supplier<Boolean> defaultValue  
        if (fieldType.isMultiValued() == false  
    }  
        // Use simpleName to compute the parent path so that fields whose simpleName contains dots
            Arrays.asList("store", "meta", "boost", "index", "doc_values", "index_options", "similarity")
            return isSet ? value : defaultValue.get();
                );  
            this.serializerCheck = (id, ic, v) -> false;
            return stringParam(name, updateable, initializer, values[0]).setValidator(v -> {  
        protected final void applyPluginParameterEffects() {  
        }  
     */
         * Defines a parameter that takes an analyzer name
/*
         * {@link IllegalArgumentException} rather than silently corrupting the parameter.
            T typed = (T) value;  
        ) {
                        iterator.remove();  
                    return;
            String name,
                (n, c, o) -> new Explicit<>(XContentMapValues.nodeBooleanValue(o), true),  
        }  
                        + param.name  
                        propName + name,
                setValue(merged);
    protected ParametrizedFieldMapper(String simpleName, MappedFieldType mappedFieldType, MultiFields multiFields, CopyTo copyTo) {  
    /**
    protected final boolean pluggableDataFormat;
            );  
         * @param updateable    whether the parameter can be changed by a mapping update
            case AUTO -> "auto";  
                List<Object> values = (List<Object>) o;
            }, initializer);
         * @param name              the parameter name  
     * Check on whether or not a parameter should be serialized
            case LIST -> "true";
        ) {  
         *
     * @param <T> the type of the value the parameter holds
        public static <T> SideEffectParameter<T> create(
        /**
        /**
import java.util.Map;
         */
            return builder;
                            + "]"
        }
 * GitHub history for details.
        private void validate() {  
         * True when this builder defaulted {@code index} to false because the index uses a pluggable
    /** Creates the shared tri-state {@code multi_value} mapping parameter for scalar leaf mappers. */
            return new Parameter<>(name, updateable, () -> defaultValue, (n, c, o) -> {
         */
            return this;
            }  
                        name,
            }  
                parameter.parse(name, parserContext, propNode);
    }
        private final Function<FieldMapper, T> initializer;  
            String name,  
                } else {
            this.serializerCheck = (id, ic, v) -> true;
            Function<FieldMapper, String> initializer,  
            return this;
     * TypeParser implementation that automatically handles parsing
            Function<FieldMapper, Integer> initializer,
         */  
                    deprecationLogger.deprecate(
                    }
         * Defines a parameter that takes a float value
                fieldNode.remove("type");
    public Map<String, Object> mappingPluginParameterValues() {
         * Normalizes an incoming mapping-update value before merge validation. This is useful for  
/*  
        context.documentInput().addField(fieldType, value);
            this.mergeValidator = (previous, toMerge) -> updateable || Objects.equals(previous, toMerge);
     * parameter) when the owning mapper is built. Data-format plugins contribute these for parameters such
            boolean updateable,
    private static final class Conflicts {  
            return create(name, updateable, defaultValue, (n, c, o) -> XContentMapValues.nodeBooleanValue(o), sideEffect);
        MultiFields multiFields,
            return this;
            Map<String, Object> values = new HashMap<>();
         * If this parameter name is encountered during parsing, a deprecation warning will
         * @param updateable    whether the parameter can be changed by a mapping update  
        if (builder == null) {  
            () -> MappedFieldType.MultiValueState.AUTO,  
        }
     * @opensearch.api  
         */  
            return new Parameter<>(name, updateable, () -> defaultValue, (n, c, o) -> XContentMapValues.nodeDoubleValue(o), initializer);  
                    );
            boolean updateable,
         * @param name          the parameter name
                if (parameter != null) {
                );  
     * Serializes a parameter  
 */  
                paramsMap.put(param.name, param);
        }
            return Parameter.boolParam("index", false, initializer, defaultValue);  
        /**
        /**
                            type
            conflicts.add("Cannot update parameter [" + parameter + "] from [" + existing + "] to [" + toMerge + "]");
        private List<Parameter<?>> pluginMappingParameters = List.of();
        CopyTo copyTo,
        public abstract ParametrizedFieldMapper build(BuilderContext context);  
            return new Parameter<>(name, updateable, () -> defaultValue, (n, c, o) -> XContentMapValues.nodeStringValue(o), initializer);  
         * @param updateable   whether the parameter can be changed by a mapping update  
        }
                m -> m.fieldType().meta()  
            .setSerializerCheck((includeDefaults, configured, mode) -> mode != MappedFieldType.MultiValueState.AUTO)
         * @param includeDefaults   if defaults have been requested  
         *
import org.opensearch.common.annotation.ExperimentalApi;
         * @param initializer   a function that reads the parameter value from an existing mapper  
         * Sets the value of the parameter with the given name if present. Used by a {@link SideEffectParameter}  
         * Declares a metadata parameter
     */
                param.merge(in, conflicts);  
            TriFunction<String, ParserContext, Object, T> parser,
        public Builder parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {
        }  
         * {@code parser}, read back from {@link ParametrizedFieldMapper#mappingPluginParameterValues()} during
import org.opensearch.index.analysis.NamedAnalyzer;
            throw new IllegalArgumentException(
    }  
                final Object propNode = entry.getValue();
            }
         */
        if (fieldType().isMultiValued()) {  
         * @param name         the parameter name as it appears in the mapping
            T merged = mergeValueNormalizer.apply(current, incoming);
import org.apache.lucene.document.FieldType;
            );
     * Creates a new ParametrizedFieldMapper, recording whether the index uses a pluggable data format.
            String... values
            return Parameter.boolParam("store", false, initializer, defaultValue);
            if (conflicts.isEmpty()) {
        boolean pluggableDataFormat  
     * {@code index} defaulting to false) during serialization and mapping merges.
        /**
                return resolved;  
         * @param parser        a function that converts an object to a parameter value
        getMergeBuilder().toXContent(builder, includeDefaults);  
    protected interface SerializerCheck<T> {  
            String message = "Mapper for [" + mapperName + "] conflicts with existing mapper:\n\t" + String.join("\n\t", conflicts);
            }
            validate();
            .setMergeValueNormalizer((current, incoming) -> incoming == MappedFieldType.MultiValueState.AUTO ? current : incoming)
                    iterator.remove();
            }  
     */
        // made no sense; if we've got here, that means that they're not declared on a current mapper,
        ).setSerializer((builder, name, mode) -> builder.field(name, mode == MappedFieldType.MultiValueState.LIST), mode -> switch (mode) {
                    iterator.remove();
        }  
            double defaultValue
        Conflicts conflicts = new Conflicts(name());  
        public static Parameter<Boolean> boolParam(
            return this;
         */  
                    + "] cannot be changed from type ["
                }  
        ) {  
                name,  
    final void addMultiValueMappingUpdate(ParseContext context) {
    /**
            int defaultValue  
    protected static Parameter<MappedFieldType.MultiValueState> multiValueParameter() {
import java.util.function.Function;  
            builder.parse(name, parserContext, node);  
         */
                conflicts.addConflict(name, conflictSerializer.apply(current), conflictSerializer.apply(incoming));  
            } else {
import java.util.HashSet;
                        + current.getClass().getName()
 *     http://www.apache.org/licenses/LICENSE-2.0
        void applySideEffect(Builder builder) {
import org.opensearch.index.mapper.Mapper.TypeParser.ParserContext;  
            this.value = value;
         * index of their own rather than the pluggable storage — are unaffected.
 */
    }
            }  
                if (a == null) {
            Function<FieldMapper, Boolean> initializer,
                        "boost_" + name,  
        public static Parameter<Integer> intParam(
            List<String> defaultValue
 *  
                NamedAnalyzer a = c.getIndexAnalyzers().get(analyzerName);
         */
     * mapping promotion when this is the second value for a supported field.
    @Override  
            return new SideEffectParameter<>(name, updateable, () -> defaultValue, parser, m -> {  
 * Licensed to Elasticsearch under one or more contributor  
        if (endPos < 0) {
    /**  
        String mergeWithContentType = ((FieldMapper) mergeWith).contentType();
            String name,  
            throw new IllegalArgumentException(
        protected String buildFullName(BuilderContext context) {
        /**
            String name,  
         * @param isConfigured      if the parameter has a different value to the default
            this.validator = validator;
        }  
        }
            }
            }
                    + contentType()
         */
            this.serializerCheck = check;  
         * <p>  
        MappedFieldType mappedFieldType,  
        /**
         * Check on whether or not a parameter should be serialized
    }  
        ParametrizedFieldMapper update = updateBuilder.build(new BuilderContext(Settings.EMPTY, context.path()));  
         *         when constructing their mapper.
     * @opensearch.api  
            Function<FieldMapper, NamedAnalyzer> initializer,
         */
            setValue(initializer.apply(toInit));
        }
                return a;
                    );  
        protected void setPluginMappingParameters(List<Parameter<?>> parameters) {
         * @param name          the parameter name  
            this.mergeValueNormalizer = Objects.requireNonNull(mergeValueNormalizer);
         * @param updateable    whether the parameter can be updated with a new value during a mapping update
     */  
            }
            if (serializerCheck.check(includeDefaults, isConfigured(), get())) {
                throw new MapperParsingException(
    @Override  
    /**  
import java.util.Iterator;
            return;
    private static ContentPath parentPath(String name, String simpleName) {  
        }
        if (Objects.equals(this.getClass(), mergeWith.getClass()) == false) {  
        /**  
         * @param updateable    whether the parameter can be changed by a mapping update
            Function<FieldMapper, Double> initializer,  
            }
            Supplier<T> defaultValue,
        }  
            Supplier<T> defaultValue,
     */
     * Returns the resolved values of any plugin-contributed mapping parameters on this mapper, keyed by
         * @param name          the parameter name
    /**
        public static Parameter<Map<String, String>> metaParam() {  
            this.initializer = initializer;  
    /**
            String name,  
 * under the License.  
            for (Parameter<?> param : getParameters()) {
        }
        public static Parameter<String> stringParam(  
            for (Iterator<Map.Entry<String, Object>> iterator = fieldNode.entrySet().iterator(); iterator.hasNext();) {
            case SCALAR -> "false";
            TriFunction<String, ParserContext, Object, T> parser,  
        }
import java.util.function.BiConsumer;
            );
        ) {
        ) {
            Function<FieldMapper, Float> initializer,
                }
        public static SideEffectParameter<Boolean> boolParam(
    }
        boolean check(boolean includeDefaults, boolean isConfigured, T value);
        private void validate() {  
 * <p>
            @SuppressWarnings("unchecked")
    @ExperimentalApi  
                }  
        }
         * Creates a new TypeParser
     */  
        /**
        }  
        return Map.of();
     *  
         * @param name          the parameter name
         * Writes the current builder parameter values as XContent
        protected boolean pluggableDataFormat;
            boolean updateable,  
 * software distributed under the License is distributed on an
            return new Parameter<>(name, updateable, () -> defaultValue, (n, c, o) -> XContentMapValues.nodeIntegerValue(o), initializer);
        public final void parse(String name, ParserContext parserContext, Map<String, Object> fieldNode) {  
        }
            return this;  
            boolean updateable,  
@PublicApi(since = "1.0.0")  
        }
        public Parameter<T> alwaysSerialize() {
            mapper -> mapper.fieldType().multiValueState()
                }
        }  
        /**
        conflicts.check();
         */
            Function<FieldMapper, Explicit<Boolean>> initializer,
    public static final class SideEffectParameter<T> extends Parameter<T> {
         * Adds a deprecated parameter name.
        private Serializer<T> serializer = XContentBuilder::field;  
            if (paramsMap.get("type") == null) {
        public static Parameter<String> restrictedStringParam(
        }
import java.util.function.BiFunction;  
        this.pluggableDataFormat = pluggableDataFormat;  
                }  
        }
        private SerializerCheck<T> serializerCheck = (includeDefaults, isConfigured, value) -> includeDefaults || isConfigured;
                for (String deprecatedName : param.deprecatedNames) {
     * @opensearch.api
        private T value;
        /**
        private Consumer<T> validator = null;
            return defaultValue.get();
        }
                param.init(initializer);  
import org.opensearch.common.logging.DeprecationLogger;
                    parameter = paramsMap.get(propName);
import org.opensearch.common.settings.Settings;
            T defaultValue,
        /**
            }
            BiConsumer<Builder, T> sideEffect
            boolean updateable,
         * @param defaultValue  the default value, to be used if the parameter is undefined in a mapping  
            return new Parameter<>(name, updateable, () -> defaultValue, (n, c, o) -> XContentMapValues.nodeFloatValue(o), initializer);
        }
    protected void doXContentBody(XContentBuilder builder, boolean includeDefaults, Params params) throws IOException {
        }
            return Parameter.floatParam("boost", true, m -> m.fieldType().boost(), 1.0f);  
import java.util.ArrayList;  
    /**  
            this.defaultValue = Objects.requireNonNull(defaultValue);  
         * Defines a parameter that takes a string value  
        /**  
                }  
                    + name()  
         * @param initializer   a function that reads the parameter value from an existing mapper
        builder.merge((FieldMapper) mergeWith, conflicts);
        public Parameter<T> acceptsNull() {
            Function<FieldMapper, T> initializer  
