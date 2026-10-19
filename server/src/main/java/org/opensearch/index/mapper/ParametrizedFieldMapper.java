        public static Parameter<Boolean> boolParam(
     */
        }
            addMultiValueMappingUpdate(context);
     * Implement as follows:
        public boolean isConfigured() {
import org.opensearch.common.settings.Settings;
         * @param name              the field mapper name
                final Object propNode = entry.getValue();
            return this;
            Map<String, Parameter<?>> deprecatedParamsMap = new HashMap<>();
        @Override
         * Returns the default value of the parameter
         * Normalizes an incoming mapping-update value before merge validation. This is useful for
        public void setParameterValue(String name, Object value) {
        ).setSerializer((builder, name, mode) -> builder.field(name, mode == MappedFieldType.MultiValueState.LIST), mode -> switch (mode) {
            throw new MapperParsingException(
import java.util.Arrays;
            return this;
                        + "]"
            boolean updateable,
        public TypeParser(BiFunction<String, ParserContext, Builder> builderFunction) {
            return context.path().pathAsText(name);
 * Unless required by applicable law or agreed to in writing,
        /**
         * @param updateable    whether the parameter can be updated with a new value during a mapping update
        /** Plugin-contributed parameters supplied at construction; appended to {@link #getParameters()} by subclasses. */
         * Applies the build-time side effects declared by any {@link SideEffectParameter}s among the
        /**
         * Declares a metadata parameter
     *
         * tri-state parameters where the default value means "unspecified" and must preserve the
         *         when constructing their mapper.
         * @param name          the parameter name
        protected void setPluginMappingParameters(List<Parameter<?>> parameters) {
            String name,
            boolean updateable,
         * current state rather than overwrite it.
            TriFunction<String, ParserContext, Object, T> parser,
                validator.accept(getValue());
            String type = (String) fieldNode.get("type");
         */
         */
        public Parameter<T> setMergeValidator(BiPredicate<T, T> mergeValidator) {
/**
         * @param initializer   a function that reads the parameter value from an existing mapper
            mapper -> mapper.fieldType().multiValueState()
            boolean updateable,
                return;
         * to override a sibling parameter at build time (e.g. disabling indexing).
                    return;
        }
            for (Mapper newSubField : in.multiFields) {
        }
    /**
                }
        }
         * Defines a parameter that takes a float value
    ) {
            }
        private static boolean isDeprecatedParameter(String propName, Version indexCreatedVersion) {
         * Sets the plugin-contributed parameters for this builder. Called from the concrete builder's
     * A {@link Parameter} that also applies a build-time side effect (for example, overriding a sibling
                        propName,
         *
            .setMergeValidator((previous, next) -> previous == MappedFieldType.MultiValueState.AUTO || previous == next);
            boolean updateable,
    @PublicApi(since = "1.0.0")
         * @param initializer   a function that reads the parameter value from an existing mapper
        public SideEffectParameter(
import org.opensearch.core.xcontent.XContentBuilder;
            return isSet && Objects.equals(value, defaultValue.get()) == false;
            (name, context, value) -> XContentMapValues.nodeBooleanValue(value)
            this.conflictSerializer = conflictSerializer;
                param.merge(in, conflicts);
        private List<Parameter<?>> pluginMappingParameters = List.of();
        builder.merge((FieldMapper) mergeWith, conflicts);
        MultiFields multiFields,
                m -> m.fieldType().meta()
        // and so we emit a deprecation warning rather than failing a previously working mapping.
        // TODO remove when everything is parametrized
    }
        public static Parameter<Boolean> storeParam(Function<FieldMapper, Boolean> initializer, boolean defaultValue) {
         * Assigns {@code value} to {@code param} after verifying it is assignable to the parameter's current value
         */
            String message = "Mapper for [" + mapperName + "] conflicts with existing mapper:\n\t" + String.join("\n\t", conflicts);
            }
import java.util.ArrayList;
            boolean updateable,
                conflicts.addConflict(name, conflictSerializer.apply(current), conflictSerializer.apply(incoming));
         * @param name          the parameter name
            return pluggableDataFormat;
                values.put(param.name, param.getValue());
            String name,
        }
         * @param parser        a function that converts an object to a parameter value
         * Adds a deprecated parameter name.
                serializer.serialize(builder, name, getValue());
 * The OpenSearch Contributors require contributions made to
            Arrays.asList("store", "meta", "boost", "index", "doc_values", "index_options", "similarity")
                parameter.parse(name, parserContext, propNode);
         * parameter based on the resolved value).
            boolean updateable,
import java.util.LinkedHashSet;
     */
         * Creates a new TypeParser
        }
        Builder updateBuilder = getMergeBuilder();
        public abstract ParametrizedFieldMapper build(BuilderContext context);
            String name,
        /**
            return new Parameter<>(
        }
        }
            return values;
        builder.field("type", contentType());
    public static final class TypeParser implements Mapper.TypeParser {
        public static Parameter<Double> doubleParam(
            Function<FieldMapper, Boolean> initializer,
                    strValues.add(item.toString());
            return new Parameter<>(name, updateable, () -> defaultValue, (n, c, o) -> XContentMapValues.nodeDoubleValue(o), initializer);
        public void setValue(T value) {
            return isSet ? value : defaultValue.get();
            if (mergeValidator.test(current, merged)) {
                throw new MapperParsingException(
                "mapper ["
            String name,
            return Parameter.floatParam("boost", true, m -> m.fieldType().boost(), 1.0f);
     *
         * @param initializer   a function that reads the parameter value from an existing mapper
    @Override
                (n, c, o) -> new Explicit<>(XContentMapValues.nodeBooleanValue(o), true),
            setValue(initializer.apply(toInit));
        private static <T> void setCheckedValue(Parameter<T> param, Object value) {
                    "Cannot set parameter ["
         * Creates a new Builder with a field name
        }
     * Conflicts in the field mapper
                for (String deprecatedName : param.deprecatedNames) {
        if (fieldType().isMultiValueAutoPromotionEnabled() == false) {
         * Never serialize this parameter, no matter its value
            Function<FieldMapper, T> initializer,
                        deprecationLogger.deprecate(
            }
        }
    /**
    private static ContentPath parentPath(String name, String simpleName) {
            Supplier<T> defaultValue,
        }
         */
            String name,
         * @param defaultValue  the default value, to be used if the parameter is undefined in a mapping
         * Adds validation to a parameter, called after parsing and merging
    }
        private final BiFunction<String, ParserContext, Builder> builderFunction;
    }
     * Returns a {@link Builder} to be used for merging and serialization
            }
        ) {
            }
    @Override
                @SuppressWarnings("unchecked")
                "Field [" + fieldType().name() + "] is locked scalar by [multi_value: false] and cannot promote"
        }
            this.serializerCheck = (id, ic, v) -> false;
        }
import java.util.function.Consumer;
                    + "] to ["
        private final TriFunction<String, ParserContext, Object, T> parser;
         * @param initializer       a function that reads the parameter value from an existing mapper
                () -> defaultExplicit,
            return (ParametrizedFieldMapper) mergeWith;
         * plugin-contributed parameters. Subclasses call this from {@code build(...)}.
            String name,
    /**
            double defaultValue
         * @param defaultValue  the default value, to be used if the parameter is undefined in a mapping
            validate();
            return new Parameter<>(name, updateable, defaultValue, (n, c, o) -> XContentMapValues.nodeBooleanValue(o), initializer);
public abstract class ParametrizedFieldMapper extends FieldMapper {
 * specific language governing permissions and limitations
            return builder;
         */
            List<String> defaultValue
            this.value = value;
            this.defaultValue = Objects.requireNonNull(defaultValue);
            case LIST -> "true";
        void applySideEffect(Builder builder) {
         * Creates a new Parameter
                );
        }
        public Parameter<T> addDeprecatedName(String deprecatedName) {
        // These parameters were previously *always* parsed by TypeParsers#parseField(), even if they
            );
                T resolved = (T) value;
        boolean check(boolean includeDefaults, boolean isConfigured, T value);
         * Sets the current value of the parameter
         * @param name          the parameter name
        /**
                    + name()
        public Parameter<T> setMergeValueNormalizer(BiFunction<T, T, T> mergeValueNormalizer) {
         * @param fieldNode         the root node of the map of mappings for this field
            Function<FieldMapper, Float> initializer,
        })
         */
        }
         */
    public static sealed class Parameter<T> implements Supplier<T> permits SideEffectParameter {
        public void toXContent(XContentBuilder builder, boolean includeDefaults) throws IOException {
                }
                return strValues;
         * @param name          the parameter name
        }
            }
            if (serializerCheck.check(includeDefaults, isConfigured(), get())) {
    public abstract ParametrizedFieldMapper.Builder getMergeBuilder();
         * @return {@code true} if the value should be serialized
            boolean updateable,
     * @opensearch.internal
            }
        }
         */
        public static Parameter<Map<String, String>> metaParam() {
                        continue;
            Function<FieldMapper, NamedAnalyzer> initializer,
                            + "]"
            String name,
                if (acceptedValues.contains(v)) {
         * be emitted.  The parameter will be serialized with its main name.
     * @opensearch.experimental
            this.mergeValueNormalizer = Objects.requireNonNull(mergeValueNormalizer);
        }
                );
                setValue(merged);
        }
     * Check on whether or not a parameter should be serialized
        ) {
        /**
            this.serializerCheck = check;
                true,
         * @param updateable   whether the parameter can be changed by a mapping update
        if (Objects.equals(this.getClass(), mergeWith.getClass()) == false) {
         * Defines a parameter that takes the values {@code true} or {@code false}, and will always serialize
                            type
            T current = getValue();
                    throw new IllegalArgumentException(
 * compatible open source license.
                }
        }
            );
import org.opensearch.common.annotation.PublicApi;
    }
         * @param name          the parameter name
     */
 * software distributed under the License is distributed on an
            && fieldType.isMultiValueSupported()
        /**
            );
                            + value.getClass().getName()
         */
        public Builder init(FieldMapper initializer) {
        /**
                if (param.name.equals(name)) {
        private void validate() {
        public static <T> SideEffectParameter<T> create(
        }
import java.util.HashMap;
                );
                            propName,
            if (conflicts.isEmpty()) {
    protected ParametrizedFieldMapper(
        public T getDefaultValue() {
        public static Parameter<Explicit<Boolean>> explicitBoolParam(
     * @opensearch.api
            T merged = mergeValueNormalizer.apply(current, incoming);
            String name,
        int endPos = name.length() - simpleName.length() - 1;
            return Parameter.boolParam("doc_values", false, initializer, defaultValue);
        private BiFunction<T, T, T> mergeValueNormalizer = (current, incoming) -> incoming;
            if (paramsMap.get("type") == null) {
        }
         * parameter is updateable, or if the previous and new values are equal
    }
         * Defines a parameter that takes a double value
            && context.documentInput().getFieldCount(fieldType.name()) > 0) {
            throw new MapperParsingException(
     * <p>
            if (fieldType.isMultiValueAutoPromotionEnabled() == false) {
                }
        public static Parameter<Float> boostParam() {
    /**
         * data format. Only set by the constructors that receive index settings, so builders created
                } else {
            boolean defaultValue
    }
            Function<FieldMapper, List<String>> initializer,
            this.parser = parser;
        public Parameter<T> setSerializerCheck(SerializerCheck<T> check) {
        void serialize(XContentBuilder builder, String name, T value) throws IOException;
            }
                    if (isDeprecatedParameter(propName, parserContext.indexVersionCreated())) {
                }
        // Use simpleName to compute the parent path so that fields whose simpleName contains dots
    }
        if (fieldType.isMultiValued() == false
        private T value;
            );
         */
            T current = param.getValue();
                return resolved;
        /**
                if (value == null) {
        // made no sense; if we've got here, that means that they're not declared on a current mapper,
        }
         * Defines a parameter that takes an integer value
        public static Parameter<Boolean> docValuesParam(Function<FieldMapper, Boolean> initializer, boolean defaultValue) {
            Function<FieldMapper, Boolean> initializer,
        }
            if (value != null && current != null && current.getClass().isInstance(value) == false) {
     * TypeParser implementation that automatically handles parsing
/*
                    + contentType()
     * Creates a new ParametrizedFieldMapper, recording whether the index uses a pluggable data format.
            int defaultValue
        }
        }
     * Creates a new ParametrizedFieldMapper
    /** Name of the shared {@code multi_value} mapping parameter. */
            }
            boolean updateable,
     * Adds one successfully parsed scalar value to the pluggable document input and requests a
         * @param initializer   a function that reads the parameter value from an existing mapper
            this.copyTo.reset(in.copyTo);
        }
        }
                "Field [" + fieldType().name() + "] of type [" + fieldType().typeName() + "] does not support [multi_value]"
     *
import org.opensearch.common.logging.DeprecationLogger;
                    );
         * @param name              the parameter name
         * @param parser       converts the raw mapping value into the parameter's type
                ? MappedFieldType.MultiValueState.LIST
            return this;
            Function<FieldMapper, T> initializer
        /**
                        "unknown parameter [" + propName + "] on mapper [" + name + "] of type [" + type + "]"
 *
import java.util.Collections;
            for (Parameter<?> param : pluginMappingParameters) {
     * A configurable parameter for a field mapper
            return new Parameter<>(name, updateable, () -> defaultValue, (n, c, o) -> XContentMapValues.nodeStringValue(o), initializer);
        /**
 * You may obtain a copy of the License at
                Parameter<?> parameter = deprecatedParamsMap.get(propName);
                    continue;
         * @param defaultAnalyzer   the default value, to be used if the parameter is undefined in a mapping
            return this;
     * {@code index} defaulting to false) during serialization and mapping merges.
        }
        protected boolean pluggableDataFormat;
            return create(name, updateable, defaultValue, (n, c, o) -> XContentMapValues.nodeBooleanValue(o), sideEffect);
        ) {
 * Defines how a particular field should be indexed and searched
        /**
        @Override
import org.opensearch.index.analysis.NamedAnalyzer;
    @PublicApi(since = "1.0.0")
    protected static Parameter<MappedFieldType.MultiValueState> multiValueParameter() {
        boolean pluggableDataFormat
        /**
         * @param defaultValue  the default value, to be used if the parameter is undefined in a mapping
                }
            if (pluginMappingParameters.isEmpty()) {
         */
 *
        public Parameter<T> setSerializer(Serializer<T> serializer, Function<T, String> conflictSerializer) {
                    iterator.remove();
    /**
            String name,
    /** Creates the shared tri-state {@code multi_value} mapping parameter for scalar leaf mappers. */
            String name,
 *     http://www.apache.org/licenses/LICENSE-2.0
            .setSerializerCheck((includeDefaults, configured, mode) -> mode != MappedFieldType.MultiValueState.AUTO)
 */
import java.util.List;
     *
    /**
            return Parameter.boolParam("store", false, initializer, defaultValue);
        private boolean isSet;
import java.util.function.BiPredicate;
                    return;
                            + "]; expected ["
                        name,
    @Override
        public final void parse(String name, ParserContext parserContext, Map<String, Object> fieldNode) {
            // Carry the pluggable-data-format flag over from the mapper being merged/serialized so a
         * <p>The value must be type-compatible with the target parameter's current value; a mismatch throws
                Map.Entry<String, Object> entry = iterator.next();
            String... values
    protected final void addFieldForPluggableFormat(ParseContext context, Object value) {
        }
         * Parse mapping parameters from a map of mappings
                Object value = ((ParametrizedFieldMapper) m).mappingPluginParameterValues().get(name);
                paramsMap.put(param.name, param);
            }, initializer).setSerializer((b, n, v) -> b.field(n, v.name()), NamedAnalyzer::name);
 * this work for additional information regarding copyright
        /** Returns the plugin-contributed parameters to be appended to {@link #getParameters()} by subclasses. */
                        + "] to a value of type ["
        /**
            }
            Function<FieldMapper, String> initializer,
                        );
            String name,
    final void addMultiValueMappingUpdate(ParseContext context) {
    @ExperimentalApi
     */
        }
         */
    @PublicApi(since = "1.0.0")
         * Always serialize this parameter, no matter its value
import java.util.Map;
        updateBuilder.setParameterValue(MULTI_VALUE_PARAMETER, MappedFieldType.MultiValueState.LIST);
     * @opensearch.internal
            }
         * @param sideEffect   applied at build time with the builder and the resolved value
        copyTo.toXContent(builder, params);
            }
            }
        protected final CopyTo.Builder copyTo = new CopyTo.Builder();
            }
                    TypeParsers.parseMultiField(multiFieldsBuilder::add, name, parserContext, propName, propNode);
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(ParametrizedFieldMapper.class);
                final String propName = entry.getKey();
        context.documentInput().addField(fieldType, value);
            Set<String> acceptedValues = new LinkedHashSet<>(Arrays.asList(values));
        private void init(FieldMapper toInit) {
        }
        this.pluggableDataFormat = pluggableDataFormat;
            MULTI_VALUE_PARAMETER,
        getMergeBuilder().toXContent(builder, includeDefaults);
        }
            TriFunction<String, ParserContext, Object, T> parser,
        ) {
            throw new IllegalStateException(
                    parameter = paramsMap.get(propName);
                        "Parameter [boost] on field [{}] is deprecated and will be removed in 3.0",
import org.opensearch.common.TriFunction;
                }
                    + mergeWith.getClass().getSimpleName()
        public Parameter<T> alwaysSerialize() {
        }
                        propName + name,
 */
        }
         * Sets a custom merge validator.  By default, merges are accepted if the
    }
 * @opensearch.api
                if (Objects.equals("copy_to", propName)) {
 * <p>
    public static final class SideEffectParameter<T> extends Parameter<T> {
        /**
        return new ContentPath(name.substring(0, endPos));
        }
 * this file be licensed under the Apache-2.0 license or a
         * {@code parser}, read back from {@link ParametrizedFieldMapper#mappingPluginParameterValues()} during
        protected Map<String, Object> pluginMappingParameterValues() {
         */
        multiFields.toXContent(builder, params);
            return DEPRECATED_PARAMS.contains(propName);
            this.builderFunction = builderFunction;
        private Function<T, String> conflictSerializer = Objects::toString;
        }
        protected Builder(String name) {
    protected void doXContentBody(XContentBuilder builder, boolean includeDefaults, Params params) throws IOException {
                }
         * @param updateable    whether the parameter can be changed by a mapping update
            this.serializer = serializer;
                    deprecationLogger.deprecate(
        }
            return new ContentPath(0);
            return this;
                iterator.remove();
        /**
         */
         * mapping merges, and the given side effect is applied at build time (for example, overriding a sibling
         * Configure a custom serializer for this parameter
        private final BiConsumer<Builder, T> sideEffect;
        return builder.build(new BuilderContext(Settings.EMPTY, parentPath(name(), simpleName())));
                            + "] resolved to a value of type ["
            );
        }
        }
        return Map.of();
        }
     */
         * @param updateable    whether the parameter can be changed by a mapping update
         * Builds the full name of the field, taking into account parent objects
        public static Parameter<List<String>> stringArrayParam(
            }
         */
            });
            TriFunction<String, ParserContext, Object, T> parser,
        public static Parameter<String> restrictedStringParam(
        protected final MultiFields.Builder multiFieldsBuilder = new MultiFields.Builder();
        /**
    /**
        ) {
         * @param initializer   a function that reads the parameter value from an existing mapper
        }
        /**
            boolean defaultValue,
            super(name);
                : MappedFieldType.MultiValueState.SCALAR,
            this.deprecatedNames.add(deprecatedName);
                String analyzerName = o.toString();
            Function<FieldMapper, String> initializer,
         * @return true when the index uses a pluggable data format. Exposed so mappers in other modules
         */
 * and returned by its {@link Builder#getParameters()} method.  Merging, serialization
        public static Parameter<Boolean> boolParam(
        }
    @PublicApi(since = "1.0.0")
        public final void toXContent(XContentBuilder builder, boolean includeDefaults) throws IOException {
            T defaultValue,
            super(name, updateable, defaultValue, parser, initializer);
                        + value.getClass().getName()
            return new SideEffectParameter<>(name, updateable, () -> defaultValue, parser, m -> {
                for (Object item : values) {
import java.util.function.Supplier;
        }
     * mapping promotion when this is the second value for a supported field.
        /** Returns the resolved values of the plugin-contributed parameters, keyed by parameter name. */
         * @param defaultValue  the default value for the parameter, used if unspecified in mappings
                    ((SideEffectParameter<?>) param).applySideEffect(this);
    protected final boolean pluggableDataFormat;
    }
         * @param value             the parameter value
            return new Parameter<>(name, updateable, () -> defaultValue, (n, c, o) -> XContentMapValues.nodeFloatValue(o), initializer);
        conflicts.check();
 * {@link #getMergeBuilder()} method, initialised with the existing builder.
     */
            }
         * @param defaultValue  the default value, to be used if the parameter is undefined in a mapping
                            "Parameter [{}] has no effect on type [{}] and will be removed in future",
         */
            BiConsumer<Builder, Boolean> sideEffect
        CopyTo copyTo,
        /**
                }
import org.apache.lucene.document.FieldType;
            boolean updateable,
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        /**
        @Override
         */
            boolean updateable,
         *                      is the default value, to be used if the parameter is undefined in a mapping
import java.util.HashSet;
        ) {
    protected interface SerializerCheck<T> {
            Function<FieldMapper, Integer> initializer,
 * KIND, either express or implied.  See the License for the
                    throw new IllegalArgumentException("analyzer [" + analyzerName + "] has not been configured in mappings");
            this.name = name;
    protected interface Serializer<T> {
         * @param defaultValue  the default value, to be used if the parameter is undefined in a mapping
            throw new IllegalArgumentException(
         * True when this builder defaulted {@code index} to false because the index uses a pluggable
        /**
     * rebuild a settings-less builder that still knows this, keeping parameter defaults correct (e.g.
        }
                            + defaultValue.getClass().getName()
                List<Object> values = (List<Object>) o;
            this.mapperName = mapperName;
                        "Plugin mapping parameter ["
                parameter.toXContent(builder, includeDefaults);
                    + "]"
     * A Builder for a ParametrizedFieldMapper
        private final Supplier<T> defaultValue;
import java.util.function.BiFunction;
            String name,
            validate();
        private void merge(FieldMapper in, Conflicts conflicts) {
         */
                        name
                if (defaultValue != null && defaultValue.getClass().isInstance(value) == false) {
                }
 *
            );
         * @param initializer   a function that reads the parameter value from an existing mapper
         * @param values        the set of values that the parameter can take.  The first value in the list
                "mapper [" + name() + "] cannot be changed from type [" + contentType() + "] to [" + mergeWithContentType + "]"
                }
        ) {
            T incoming = initializer.apply(toMerge);
                            propName + type,
            for (Parameter<?> param : getParameters()) {
                }
            BiConsumer<Builder, T> sideEffect
        public Parameter<T> acceptsNull() {
                if (a == null) {
         */
     */
         */
    }
            @SuppressWarnings("unchecked")
    @ExperimentalApi
            for (Parameter<?> param : getParameters()) {
    }
            String defaultValue
        MappedFieldType fieldType = fieldType();
        ) {
        private static final Set<String> DEPRECATED_PARAMS = new HashSet<>(
/*
                updateable,
                multiFieldsBuilder.add(subField);
            Map<String, Parameter<?>> paramsMap = new HashMap<>();
        private final Function<FieldMapper, T> initializer;
            T typed = (T) value;
         */
         * @param name         the parameter name as it appears in the mapping
                    "Field [" + fieldType.name() + "] is locked scalar by [multi_value: false] and cannot accept multiple values"
            case AUTO -> "auto";
     * True when the index uses a pluggable data format. Remembered here so {@link #getMergeBuilder()} can
            ).setSerializer((b, n, v) -> b.field(n, v.value()), v -> Boolean.toString(v.value()));
        private void merge(FieldMapper toMerge, Conflicts conflicts) {
                multiFieldsBuilder.update(newSubField, parentPath(newSubField.name(), newSubField.simpleName()));
         *         (which cannot access the protected field across class loaders) can propagate the flag
        if (fieldType().isMultiValueSupported() == false) {
import java.io.IOException;
         */
        }
        public final String name;
        ) {
        private Serializer<T> serializer = XContentBuilder::field;
         * Defines a parameter that takes one of a restricted set of string values
 * ownership. Elasticsearch licenses this file to you under
        /**
    /**
                        "Parameter [{}] on mapper [{}] is deprecated, use [{}]",
            if (validator != null) {
            return getValue();
         */
         * Sets the value of the parameter with the given name if present. Used by a {@link SideEffectParameter}
                    throw new MapperParsingException(
        public Builder parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {
        }
            return pluginMappingParameters;
    protected ParametrizedFieldMapper(String simpleName, MappedFieldType mappedFieldType, MultiFields multiFields, CopyTo copyTo) {
    /**
                if (param instanceof SideEffectParameter) {
        }
        ParametrizedFieldMapper update = updateBuilder.build(new BuilderContext(Settings.EMPTY, context.path()));
     *
     *
     * @opensearch.api
        public static Parameter<Integer> intParam(
        ) {
                    setCheckedValue(param, value);
import org.opensearch.common.xcontent.support.XContentMapValues;
        super(simpleName, new FieldType(), mappedFieldType, multiFields, copyTo);
        Conflicts conflicts = new Conflicts(name());
import org.opensearch.common.annotation.ExperimentalApi;
                    iterator.remove();
                "meta",
         * @param defaultValue the value used when the parameter is absent from the mapping
 * license agreements. See the NOTICE file distributed with
            Map<String, Object> values = new HashMap<>();
            return this;
         * @param name          the parameter name, used in parsing and serialization
 */
    public abstract static class Builder extends Mapper.Builder<Builder> {
        }
                    }
        public T get() {
                return a;
            }
         * for internal field types — such as derived fields, which evaluate queries against an in-memory
        if (mergeWith instanceof FieldMapper == false) {
                if (Objects.equals("boost", propName)) {
        }
            param.setValue(typed);
         * If this parameter name is encountered during parsing, a deprecation warning will
        }
         * Returns the current value of the parameter
         */
                        "boost_" + name,
            assert values.length > 0;
        public static Parameter<String> stringParam(
            this.initializer = initializer;
        /**
         * @param initializer   a function that reads the parameter value from an existing mapper
        public Parameter<T> neverSerialize() {
        /**
         * @param updateable        whether the parameter can be changed by a mapping update
        MappedFieldType mappedFieldType,
        }
            sideEffect.accept(builder, getValue());
         */
    protected final void mergeOptions(FieldMapper other, List<String> conflicts) {
                    return defaultValue;
 * GitHub history for details.
    }
                        + current.getClass().getName()
    public Map<String, Object> mappingPluginParameterValues() {
        // (because of disable_objects) get the correct parent path
        }
                name,
        void check() {
        }
         * @param builderFunction a function that produces a Builder from a name and parsercontext
         *
         * Configure a custom serialization check for this parameter
            for (Parameter<?> param : getParameters()) {
     * Returns the resolved values of any plugin-contributed mapping parameters on this mapper, keyed by
                "Mapper [" + fieldType().name() + "] advertises multi-value support but did not apply [multi_value]"
         * @param parserContext     the parser context
     *
}
            boolean updateable,
 * Subclasses should implement a {@link Builder} that is returned from the
        private final List<String> conflicts = new ArrayList<>();
 * Configuration {@link Parameter}s for the mapper are defined on a {@link Builder} subclass,
                    deprecationLogger.deprecate(
        /**
                    );
        protected abstract List<Parameter<?>> getParameters();
    }
        /**
                Collections::emptyMap,
        private final List<String> deprecatedNames = new ArrayList<>();
        }
                if (parameter == null) {
        Conflicts(String mapperName) {
        /**
        );
            Supplier<NamedAnalyzer> defaultAnalyzer
     * @param <T> the type of the value the parameter holds
                    );
        this(simpleName, mappedFieldType, multiFields, copyTo, false);
        if (fieldType().isMultiValued()) {
        String mergeWithContentType = ((FieldMapper) mergeWith).contentType();
        }
        /**
        if (Objects.equals(contentType(), mergeWithContentType) == false) {
        String simpleName,
            for (Parameter<?> param : getParameters()) {
                    deprecatedParamsMap.put(deprecatedName, param);
         * type. The unchecked cast is guarded by the preceding runtime {@code isInstance} check.
                initializer
         */
                    throw new MapperParsingException(
     */
                (n, c, o) -> TypeParsers.parseMeta(n, o),
         * Defines a parameter that takes an analyzer name
        }
        }
    /**
     */
            this.acceptsNull = true;
import java.util.Iterator;
         * @param isConfigured      if the parameter has a different value to the default
            this.mergeValidator = mergeValidator;
import org.opensearch.common.Explicit;
     * parameter) when the owning mapper is built. Data-format plugins contribute these for parameters such
    private static final class Conflicts {
            return stringParam(name, updateable, initializer, values[0]).setValidator(v -> {
            case SCALAR -> "false";
        }
 * Modifications Copyright OpenSearch Contributors. See
            for (Parameter<?> parameter : getParameters()) {
                param.validate();
        ParametrizedFieldMapper.Builder builder = getMergeBuilder();
        if (update.fieldType().isMultiValued() == false) {
                        + "]; expected ["
     */
        /**
            Function<FieldMapper, Explicit<Boolean>> initializer,
         */
         * Allows the parameter to accept a {@code null} value
    /** Publishes the idempotent scalar-to-multi-value mapping update for this mapper. */
            return;
         * @param updateable    whether the parameter can be changed by a mapping update
        public static Parameter<Float> floatParam(
                "mapper [" + name() + "] cannot be changed from type [" + contentType() + "] to [" + mergeWithContentType + "]"
        public Parameter(
            setValue(parser.apply(field, context, in));
 *
 * SPDX-License-Identifier: Apache-2.0
        /**
 * and parsing of the mapper are all mediated through this set of parameters.
     * parameter name. Empty unless a data-format plugin contributed parameters for this field type.
            boolean updateable,
     * @opensearch.api
            this.serializerCheck = (id, ic, v) -> true;
                if (propNode == null && parameter.acceptsNull == false) {
         * <p>
                List<String> strValues = new ArrayList<>();
    public static final String MULTI_VALUE_PARAMETER = "multi_value";
        if (builder == null) {
        private SerializerCheck<T> serializerCheck = (includeDefaults, isConfigured, value) -> includeDefaults || isConfigured;
import org.opensearch.index.mapper.Mapper.TypeParser.ParserContext;
        void addConflict(String parameter, String existing, String toMerge) {
     */
        }
            BiConsumer<Builder, T> sideEffect
        /**
        private BiPredicate<T, T> mergeValidator;
                return Collections.emptyMap();
            return Parameter.boolParam("index", false, initializer, defaultValue);
            return new Parameter<>(name, updateable, defaultAnalyzer, (n, c, o) -> {
         */
         */
            return defaultValue.get();
        /** Convenience factory for a boolean plugin-contributed parameter; see {@link #create}. */
                        + param.name
                    TypeParsers.parseCopyFields(propNode).forEach(copyTo::add);
    /**
        if (endPos < 0) {
            this.isSet = true;
    }
            return Parameter.boolParam("index", false, initializer, defaultValue);
     * {@code return new MyBuilder(simpleName()).init(this); }
         * @param initializer   a function that reads a parameter value from an existing mapper
        ) {
        public T getValue() {
        /**
        /**
        private boolean acceptsNull = false;
     * as {@code low_cardinality}, where the field additionally opts out of Lucene indexing.
     */
            Function<FieldMapper, Double> initializer,
                }
            }
        /**
            return new Parameter<>(name, updateable, () -> defaultValue, (n, c, o) -> XContentMapValues.nodeIntegerValue(o), initializer);
        @SuppressWarnings("unchecked")
     *
 * not use this file except in compliance with the License.
         * @param name          the parameter name
import org.opensearch.Version;
            String name,
         * @param updateable    whether the parameter can be changed by a mapping update
        private void parse(String field, ParserContext context, Object in) {
         * @param updateable    whether the parameter can be changed by a mapping update
        }
                NamedAnalyzer a = c.getIndexAnalyzers().get(analyzerName);
                    continue;
        protected final void applyPluginParameterEffects() {
import java.util.Objects;
                        "[" + propName + "] on mapper [" + name + "] of type [" + type + "] must not have a [null] value"
            this.mergeValidator = (previous, toMerge) -> updateable || Objects.equals(previous, toMerge);
            boolean updateable,
            this.value = null;
        private void validate() {
        private Consumer<T> validator = null;
                    );
            Builder builder = builderFunction.apply(name, parserContext);
        ) {
        }
     * @opensearch.api
import java.util.function.Function;
     * @opensearch.experimental
            Explicit<Boolean> defaultExplicit = new Explicit<>(defaultValue, false);
package org.opensearch.index.mapper;
        }
            return this;
         */
            boolean defaultValue
                if (Objects.equals("fields", propName) && !name.equals(ContextAwareGroupingFieldMapper.CONTENT_TYPE)) {
                }
        /**
        protected List<Parameter<?>> pluginMappingParameters() {
        /**
         */
         * Defines a parameter that takes the values {@code true} or {@code false}
                fieldNode.remove("type");
            // settings-less merge builder keeps the correct parameter defaults (e.g. `index` -> false).
            }
         * @param includeDefaults   if defaults have been requested
            true,
            if (initializer instanceof ParametrizedFieldMapper) {
         * @param updateable    whether the parameter can be changed by a mapping update
@PublicApi(since = "1.0.0")
        return new Parameter<>(
 */
            Supplier<T> defaultValue,
         * its value if configured.
        public Parameter<T> setValidator(Consumer<T> validator) {
            return new Parameter<>(name, updateable, () -> defaultValue, (n, c, o) -> {
            throw new IllegalArgumentException(message);
            return this;
            for (Parameter<?> param : pluginMappingParameters) {
            }
     */
            throw new IllegalArgumentException(
        }
        /**
            () -> MappedFieldType.MultiValueState.AUTO,
    /**
     * Serializes a parameter
        ) {
    /**
            Supplier<Boolean> defaultValue
                    + "] cannot be changed from type ["
         * Initialises all parameters from an existing mapper
         */
                throw new MapperParsingException(
         * constructor so the parameters are present when {@link #getParameters()} runs.
         */
                            + name
 * <p>
        }
        protected String buildFullName(BuilderContext context) {
    }
/*
        }
        }
        private final String mapperName;
            return this;
 * Licensed to Elasticsearch under one or more contributor
         * Check on whether or not a parameter should be serialized
            return boolParam(name, updateable, initializer, () -> defaultValue);
        public static SideEffectParameter<Boolean> boolParam(
 * under the License.
            for (Parameter<?> param : getParameters()) {
            } else {
         * @return the list of parameters defined for this mapper
        public static Parameter<Boolean> indexParam(Function<FieldMapper, Boolean> initializer, Supplier<Boolean> defaultValue) {
    }
         * Writes the current builder parameter values as XContent
            for (Mapper subField : initializer.multiFields) {
            builder.parse(name, parserContext, node);
        context.addDynamicMapper(update);
         * {@link IllegalArgumentException} rather than silently corrupting the parameter.
         * Creates a plugin-contributed parameter of any type. Its raw mapping value is converted by
         */
         * Defines a parameter that takes a string value
        /**
        }
        public boolean isPluggableDataFormat() {
            float defaultValue
import java.util.Set;
            conflicts.add("Cannot update parameter [" + parameter + "] from [" + existing + "] to [" + toMerge + "]");
                throw new IllegalArgumentException(
         */
import java.util.function.BiConsumer;
            this.sideEffect = Objects.requireNonNull(sideEffect, "sideEffect");
                    );
        }
                if (parameter != null) {
         * index of their own rather than the pluggable storage — are unaffected.
         */
                param.init(initializer);
            .setMergeValueNormalizer((current, incoming) -> incoming == MappedFieldType.MultiValueState.AUTO ? current : incoming)
            }, initializer);
            this.validator = validator;
         * @param defaultValue  the default value, to be used if the parameter is undefined in a mapping
                        iterator.remove();
    public ParametrizedFieldMapper merge(Mapper mergeWith) {
         * @param name          the parameter name
            return this;
                        parameter.name
            this.pluginMappingParameters = (parameters == null || parameters.isEmpty()) ? List.of() : List.copyOf(parameters);
            throw new IllegalArgumentException(
            String name,
                this.pluggableDataFormat = ((ParametrizedFieldMapper) initializer).pluggableDataFormat;
         * @param updateable    whether the parameter can be changed by a mapping update
            }, sideEffect);
            boolean updateable,
            );
        public static Parameter<Boolean> indexParam(Function<FieldMapper, Boolean> initializer, boolean defaultValue) {
                    "Unknown value [" + v + "] for field [" + name + "] - accepted values are " + acceptedValues.toString()
 * the Apache License, Version 2.0 (the "License"); you may
        ) {
            for (Iterator<Map.Entry<String, Object>> iterator = fieldNode.entrySet().iterator(); iterator.hasNext();) {
        public static Parameter<NamedAnalyzer> analyzerParam(
            return new Parameter<>(
