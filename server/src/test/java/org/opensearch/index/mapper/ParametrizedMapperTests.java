        );
    }
        assertEquals("{\"field\":" + mappingWithSA + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));
        {
public class ParametrizedMapperTests extends MapperServiceTestCase {
            e.getMessage()
        e = expectThrows(IllegalArgumentException.class, () -> original.merge(toMerge));
        public Builder getMergeBuilder() {
                + "\"required\":\"value\",\"restricted\":\"foo\"}}",
            IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> fromMapping(mapping));
            assertEquals("bar", mapper.restricted);
        );
        TestMapper mapper2 = (TestMapper) builder2.build(new Mapper.BuilderContext(Settings.EMPTY, path));
/*
            return null;
        protected List<Parameter<?>> getParameters() {
import org.opensearch.index.mapper.ParametrizedFieldMapper.SideEffectParameter;
    public void testAnalyzers() {
        }
            "{\"field\":{\"type\":\"test_mapper\",\"analyzer\":\"default\",\"required\":\"value\"}}",
        SideEffectMapper mapper = (SideEffectMapper) builder.build(new Mapper.BuilderContext(Settings.EMPTY, new ContentPath(0)));
            this.index = builder.index.getValue();
        when(mapperService.getIndexAnalyzers()).thenReturn(indexAnalyzers);
        // analyzer, no matter what the value of `include_defaults` is
        protected String contentType() {
        MapperService mapperService = mock(MapperService.class);
        TestMapper removeCopyTo = fromMapping("{\"type\":\"test_mapper\",\"variable\":\"updated\",\"required\":\"value\"}");
    // The parameter reads its resolved value back from mappingPluginParameterValues() when a mapper is re-initialised.
    }
            .build(new Mapper.BuilderContext(Settings.EMPTY, new ContentPath(0)));
        public ParametrizedFieldMapper.Builder getMergeBuilder() {
    public void testNullables() {
        assertEquals("_standard", mapper.searchAnalyzer.name());
        TestMapper mapper2 = (TestMapper) builder2.build(new Mapper.BuilderContext(Settings.EMPTY, path2));
                + "\"wrapper\":\"default\",\"int_value\":5,\"analyzer\":\"default\","
    }
    public void testParameterValidation() {
        final Parameter<String> restricted = Parameter.restrictedStringParam("restricted", true, m -> toType(m).restricted, "foo", "bar");
        assertEquals(10, mapper.intValue);
            return new ParametrizedMapperTests.Builder(simpleName()).init(this);
            return parameters;
        assertEquals(
    // merging - try updating 'fixed' and 'fixed2' should get an error, try updating 'variable' and verify update
        // unaffected
        ToXContent.Params params = new ToXContent.MapParams(Collections.singletonMap("include_defaults", "true"));
            this.required = builder.required.getValue();
        builder.lowCard.setValue(true);
        assertEquals(
            Map.of(
        TestMapper mapper = fromMapping(mapping);
        public ParametrizedFieldMapper build(Mapper.BuilderContext context) {
 * compatible open source license.
        private final String variable;
        TestMapper mapper = fromMapping(mapping);
    public static class Builder extends ParametrizedFieldMapper.Builder {
        TestMapper mapper1 = (TestMapper) builder1.build(new Mapper.BuilderContext(Settings.EMPTY, path1));
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(
        assertEquals("{\"field\":" + mapping + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));   // original
        assertEquals("root.a.b.c", merged.name());
        );
        {
        assertFalse(mapper.index);
    public void testSideEffectParameterDisablesIndexingWhenEnabled() {
        public Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {
        final Parameter<Boolean> fixed2 = Parameter.boolParam("fixed2", false, m -> toType(m).fixed2, false)
                return BinaryFieldMapper.PARSER;
        }).setMergeValidator((o, n) -> n >= o);
    protected Collection<Plugin> getPlugins() {
import java.util.ArrayList;
    }
            builder.parse(name, parserContext, node);
            "{\"field\":{\"type\":\"test_mapper\",\"fixed2\":true,\"required\":\"value\"}}",
    public void testLinkedAnalyzers() throws IOException {
        path1.add("attributes");
            "{\"field\":{\"type\":\"test_mapper\",\"variable\":\"updated\",\"required\":\"value\"}}",
            List<Parameter<?>> parameters = new ArrayList<>();
    }
        TestMapper merged = (TestMapper) mapper.merge(toMerge);
        TestMapper mapper = fromMapping(mapping);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> merged.merge(badToMerge));
        ContentPath path = new ContentPath();
            analyzer::getValue
    }
            + "\tCannot update parameter [fixed] from [false] to [true]\n"
        }
import java.util.Collections;
        @Override
    private String toStringWithDefaults(ToXContent value) throws IOException {
    private static TestMapper fromMapping(String mapping) {
        ) {
    public void testMergePreservesFullNameForDottedSimpleName() {
            true,
    }
        TestMapper badMerge = fromMapping("{\"type\":\"test_mapper\",\"fixed\":true,\"fixed2\":true,\"required\":\"value\"}");
 */
            + "\"bucket_span\":{\"type\":\"long\"},"
    }
        final Parameter<Integer> intValue = Parameter.intParam("int_value", true, m -> toType(m).intValue, 5).setValidator(n -> {
    public void testSideEffectParameterReadBackRejectsTypeMismatch() {
            TestMapper mapper = fromMapping(mapping);
            Strings.toString(MediaTypeRegistry.JSON, mapper)
        assertThat(e.getMessage(), containsString("Cannot set parameter [index]"));
        assertEquals(
        XContentBuilder builder = JsonXContent.contentBuilder();
    private static TestMapper fromMapping(String mapping, Version version) {
            () -> fromMapping("{\"type\":\"test_mapper\",\"int_value\":60,\"required\":\"value\"}")
        String mapping = "{\"type\":\"test_mapper\",\"fixed\":false,\"required\":\"value\"}";
    public void testSetParameterValueRejectsTypeMismatch() {
    public void testSideEffectParameterReadsResolvedValue() {
            "search_analyzer",
        String mappingWithBoth = "{\"type\":\"test_mapper\",\"analyzer\":\"default\","
        private final boolean fixed2;
    public void testRestrictedField() {
        assertEquals(
        // On update, copy_to is completely replaced
            "analyzer",
            "Mapper for [field] conflicts with existing mapper:\n" + "\tCannot update parameter [analyzer] from [default] to [_standard]",
        mapperService.merge("_doc", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
        path2.add("attributes");
        @Override
        {
            super(simpleName, new KeywordFieldMapper.KeywordFieldType(fullName), multiFields, copyTo);
                "default",
        TestMapper mapper = fromMapping(mapping);
        builder.endObject();
    }
            false,
        TestMapper merged = (TestMapper) mapper1.merge(mapper2);
        reinit.init(mapper);
    public static class TypeParser implements Mapper.TypeParser {
    @Override
import static org.hamcrest.Matchers.containsString;
        );
        TestMapper mapper = fromMapping(mapping);
            if (o == null || getClass() != o.getClass()) return false;
        private final String restricted;
        protected List<Parameter<?>> getParameters() {
        @Override
        String mapping = "{\"type\":\"test_mapper\",\"index\":false,\"store\":true,\"required\":\"value\"}";
        builder2.required.setValue("updated");
import org.opensearch.common.settings.Settings;
        String mapping = "{\"type\":\"test_mapper\",\"fixed2_old\":true,\"required\":\"value\"}";
                + "\tCannot update parameter [wrapper] from [wrapper_wrapped value] to [wrapper_new value]",
        assertEquals(
        TestMapper merged = (TestMapper) mapper1.merge(mapper2);
        private final Map<String, Object> pluginValues;
        mapper = fromMapping(mappingWithSA);
        String badSubField = "{\"type\":\"test_mapper\",\"variable\":\"foo\",\"required\":\"value\","
    }
        assertEquals("{\"field\":" + mapping + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));   // original
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> reinit.init(wrongTyped));
 *
        TestMapper mapper = fromMapping(mapping, Version.V_2_0_0);
            if (Objects.equals("keyword", s)) {
import org.opensearch.core.common.Strings;
 * You may obtain a copy of the License at
        );
        assertEquals("{\"field\":" + mapping + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));
 * this work for additional information regarding copyright
        }
            b.field("int_value", 10);
        assertEquals(
            if (n > 50) {
        private final NamedAnalyzer analyzer;
        assertEquals("[fixed] on mapper [field] of type [test_mapper] must not have a [null] value", e.getMessage());
    }
            () -> Lucene.KEYWORD_ANALYZER
            this.pluginValues = builder.pluginMappingParameterValues();
        TestMapper badToMerge = fromMapping(badSubField);
    // A SideEffectParameter that resolves to true disables indexing at build time via its side effect.
        }
        assertEquals("{\"field\":" + mapping + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> fromMapping(mapping));
        mapper = fromMapping(mappingWithSame);
import org.opensearch.index.analysis.IndexAnalyzers;
        return (TestMapper) new TypeParser().parse("field", XContentHelper.convertToMap(JsonXContent.jsonXContent, mapping, true), pc)
        SideEffectBuilder builder = new SideEffectBuilder("field");
        String mapping = "{\"type\":\"test_mapper\",\"int_value\":10,\"required\":\"value\"}";
        private final String required;
        );
        Builder builder1 = new Builder("address.city");
        assertEquals(mapper.analyzer.name(), "default");
            e.getMessage()
            super(name);
            + "\"anomaly_score\":{\"type\":\"double\"},"
            + "\"fields\":{\"sub2\":{\"type\":\"binary\"}}}";
        protected void parseCreateField(ParseContext context) {}
import org.opensearch.core.xcontent.MediaTypeRegistry;
        })));
import org.opensearch.common.compress.CompressedXContent;
        assertEquals("_standard", mapper.searchAnalyzer.name());
 * software distributed under the License is distributed on an
        );
    public static class SideEffectMapper extends ParametrizedFieldMapper {
 *
        // 'index' is declared explicitly, 'store' is not, but is one of the previously always-accepted params
            super(simpleName, new KeywordFieldMapper.KeywordFieldType(fullName), MultiFields.empty(), CopyTo.empty());
        assertTrue(mapper.fixed2);
    private static class StringWrapper {
    // defaults - create empty builder config, and serialize with and without defaults
    }
        TestMapper noCopyTo = (TestMapper) merged.merge(removeCopyTo);
            assertEquals("foo", mapper.restricted);
        assertEquals("address.city", mapper1.simpleName());
                (id, ic, v) -> Objects.equals(analyzer.getValue().name(), searchAnalyzer.getValue().name()) == false
            + ",\"fields\":{\"sub2\":{\"type\":\"keyword\"}}}";
    public void testMultifields() {
 */
                b.setParameterValue("index", false);
    }
        Builder builder = new Builder("field");
        assertEquals("{\"field\":" + mapping + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));
        );
            Strings.toString(MediaTypeRegistry.JSON, mapper)
/*
        builder1.required.setValue("value");
        // unaffected
    }
        assertThat(mapper.analyzer.analyzer(), instanceOf(StandardAnalyzer.class));
                + "\"required\":\"value\",\"restricted\":\"foo\"}}",
    public void testCustomMergeValidation() throws IOException {
            String fullName,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.mapper.ParametrizedFieldMapper.Parameter;
        protected TestMapper(
        TestMapper mapper1 = (TestMapper) builder1.build(new Mapper.BuilderContext(Settings.EMPTY, path));
        }
        TestMapper toMerge = fromMapping(conflict);
    }
        assertTrue("value must be read back from the mapping", reinit.lowCard.getValue());
        builder1.required.setValue("v1");
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.index.mapper;
        return fromMapping(mapping, Version.CURRENT);
    /** Minimal mapper used to exercise {@link SideEffectParameter} end to end. */
        assertEquals("{\"field\":" + mapping + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));
/*
        String withDef = "{\"type\":\"test_mapper\",\"analyzer\":\"default\",\"required\":\"value\"}";
        MapperService mapperService = createMapperService("_doc", mapping);
            + "\tCannot update parameter [fixed2] from [false] to [true]";
        assertEquals(mapping, Strings.toString(MediaTypeRegistry.JSON, mapperService.documentMapper()));
        final Parameter<Boolean> fixed = Parameter.boolParam("fixed", false, m -> toType(m).fixed, true);
            this.fixed2 = builder.fixed2.getValue();
        SideEffectBuilder reinit = new SideEffectBuilder("field");
        }
        }
        }
            this.wrapper = builder.wrapper.getValue();
        assertEquals("{\"field\":" + mapping + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));
import static org.hamcrest.Matchers.instanceOf;
        TestMapper merged = (TestMapper) mapper.merge(toMerge);
        );
        TestMapper mapper = fromMapping(mapping);
        String mapping = "{\"type\":\"test_mapper\",\"fixed\":null,\"required\":\"value\"}";
import org.opensearch.common.xcontent.XContentHelper;
import org.opensearch.index.analysis.NamedAnalyzer;
import java.io.IOException;
    }
            "{\"field\":{\"type\":\"test_mapper\",\"fixed\":true,"
        builder2.required.setValue("v2");
            return Arrays.asList(fixed, fixed2, variable, index, wrapper, intValue, analyzer, searchAnalyzer, required, restricted);
            String mapping = "{\"type\":\"test_mapper\",\"required\":null}";
        @Override
            this.variable = builder.variable.getValue();
        String mapping = "{\"type\":\"test_mapper\",\"analyzer\":\"_standard\",\"required\":\"value\"}";
import java.util.Map;
        }
        builder.setParameterValue("index", false);
                + "\"fixed2\":false,\"variable\":\"default\",\"index\":true,"
        assertEquals("default", mapper.analyzer.name());
        builder.startObject();
            assertEquals("field [required] must be specified", iae.getMessage());
        IndexAnalyzers indexAnalyzers = new IndexAnalyzers(
    }
        String mappingWithSA = "{\"type\":\"test_mapper\",\"search_analyzer\":\"_standard\",\"required\":\"value\"}";
 * under the License.
    }
        SideEffectBuilder builder = new SideEffectBuilder("field");
        final Parameter<StringWrapper> wrapper = new Parameter<>("wrapper", false, () -> new StringWrapper("default"), (n, c, o) -> {
        assertEquals("Value of [n] cannot be greater than 50", e.getMessage());
        String conflict = "{\"type\":\"test_mapper\",\"wrapper\":\"new value\",\"required\":\"value\"}";
        // we've configured things so that search_analyzer is only output when different from
        });
            return new StringWrapper(o.toString());
        protected Builder(String name) {
            Builder builder = new Builder(name);
        return (TestMapper) in;
        assertEquals("{\"field\":" + fine + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));
        }
            this.index = builder.index.getValue();
        assertEquals("address.city", merged.simpleName());
            this.searchAnalyzer = builder.searchAnalyzer.getValue();
        };
        return builder.toString();
            String mapping = "{\"type\":\"test_mapper\"}";
            .addDeprecatedName("fixed2_old");
}
        mapper = fromMapping(mappingWithBoth);
                "_standard",
import org.opensearch.common.lucene.Lucene;
import org.opensearch.core.xcontent.ToXContent;
        final Parameter<NamedAnalyzer> searchAnalyzer = Parameter.analyzerParam(
            b.field("int_value", 5);    // custom merge validator says that int_value can only increase
        TestMapper mapper = fromMapping(mapping);
                new NamedAnalyzer("default", AnalyzerScope.INDEX, new StandardAnalyzer())
        assertFalse("side effect must disable indexing", mapper.index);
            if (Boolean.TRUE.equals(enabled)) {
        TestMapper mapper = fromMapping(mapping);
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        MapperService mapperService = createMapperService(fieldMapping(b -> {
        @Override
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> fromMapping(badAnalyzer));
            "{\"field\":{\"type\":\"test_mapper\",\"variable\":\"foo\",\"required\":\"value\","
        );
import java.util.Arrays;
        assertEquals("{\"field\":" + mapping + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));
        {
                Lucene.KEYWORD_ANALYZER,
    }
            m -> toType(m).analyzer,
            if (o == null) return null;
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
        TestMapper goodMerge = fromMapping("{\"type\":\"test_mapper\",\"fixed\":false,\"variable\":\"updated\",\"required\":\"value\"}");
        );
        return Collections.singletonList(new TestPlugin());
            searchAnalyzer.setSerializerCheck(
        assertFalse(builder.index.getValue());
            + "\"search_analyzer\":\"default\",\"required\":\"value\"}";
            "{\"field\":{\"type\":\"test_mapper\",\"index\":false,\"required\":\"value\"}}",
        Mapper.TypeParser.ParserContext pc = new Mapper.TypeParser.ParserContext(s -> null, mapperService, s -> {
        assertEquals("{\"field\":" + mapping + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));
            }
    }
        assertEquals("a.b.c", merged.simpleName());
    // add multifield, verify, add second multifield, verify, overwrite second multifield
import java.util.Objects;
        TestMapper toMerge = fromMapping(
        {
            + "\"properties\":{"
import java.util.Collection;
        private final NamedAnalyzer searchAnalyzer;
        }
        final Parameter<NamedAnalyzer> analyzer = Parameter.analyzerParam(
 * specific language governing permissions and limitations
            return new SideEffectMapper(name(), buildFullName(context), this);
        TestMapper original = mapper;
        }
        final Parameter<String> variable = Parameter.stringParam("variable", true, m -> toType(m).variable, "default").acceptsNull();
import org.opensearch.common.xcontent.json.JsonXContent;
        SideEffectMapper(String simpleName, String fullName, SideEffectBuilder builder) {
    // test deprecations
            + "\"bucket_count\":{\"type\":\"long\"},"
        );
            String simpleName,
        assertEquals("mapper [field.sub2] cannot be changed from type [keyword] to [binary]", e.getMessage());
    public void testObjectSerialization() throws IOException {
            }
        @Override
            assertEquals("[required] on mapper [field] of type [test_mapper] must not have a [null] value", exc.getMessage());
    }
        @Override
    }
        final Parameter<Boolean> index = Parameter.boolParam("index", false, m -> toType(m).index, true);
    private static TestMapper toType(Mapper in) {
        protected void parseCreateField(ParseContext context) {
            return builder;
            "Mapper for [field] conflicts with existing mapper:\n"
    public static class SideEffectBuilder extends ParametrizedFieldMapper.Builder {
            }
                throw new IllegalArgumentException("field [required] must be specified");
        assertEquals("updated", merged.required);
        assertEquals(
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> mapper.merge(badMerge));
        assertEquals("_standard", mapper.searchAnalyzer.name());
            StringWrapper that = (StringWrapper) o;
                + "\"fixed2\":false,\"variable\":\"default\",\"index\":true,"
        final SideEffectParameter<Boolean> lowCard = SideEffectParameter.boolParam("low_card", false, false, (b, enabled) -> {
        SideEffectBuilder reinit = new SideEffectBuilder("field");
            }
        protected void parseCreateFieldForPluggableFormat(ParseContext context) {}
            this.fixed = builder.fixed.getValue();
 * GitHub history for details.
        public Map<String, Object> mappingPluginParameterValues() {
            parameters.add(index);
        @Override
import java.util.List;
    // test validator
    // setParameterValue only accepts a value type-compatible with the target parameter; a mismatch throws.
        Builder builder2 = new Builder("address.city");
    public void testCopyTo() {
        assertEquals("{\"field\":" + mapping + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));
        assertThat(e.getMessage(), containsString("resolved to a value of type"));
        String mapping = "{\"type\":\"test_mapper\",\"variable\":\"foo\",\"required\":\"value\",\"copy_to\":[\"other\"]}";
        }
            + "\"fields\":{\"sub\":{\"type\":\"keyword\"}}}";
        SideEffectMapper mapper = (SideEffectMapper) builder.build(new Mapper.BuilderContext(Settings.EMPTY, new ContentPath(0)));
        // TODO: should we have to include 'fixed' here? Or should updates take as 'defaults' the existing values?
    public void testDeprecatedParameters() {
        );
    // When the SideEffectParameter resolves to false, no side effect is applied and indexing stays enabled.
            MapperParsingException exc = expectThrows(MapperParsingException.class, () -> fromMapping(mapping));
        Builder builder2 = new Builder("a.b.c");
            // only output search analyzer if different to analyzer
                return KeywordFieldMapper.PARSER;
            Strings.toString(MediaTypeRegistry.JSON, merged)
                "_keyword",
    }
            + "\"search_analyzer\":\"_standard\",\"required\":\"value\"}";
            }
            () -> builder.setParameterValue("index", "not-a-boolean")
        assertEquals(mapper.analyzer, Lucene.STANDARD_ANALYZER);
            public Map<String, Object> mappingPluginParameterValues() {
        TestMapper toMerge = fromMapping(addSubField);
    }
        SideEffectMapper mapper = (SideEffectMapper) builder.build(new Mapper.BuilderContext(Settings.EMPTY, new ContentPath(0)));
        });
    public void testMerging() {
        }
            return Map.of("test_mapper", new TypeParser());
import org.opensearch.plugins.Plugin;
            }
        TestMapper mapper = fromMapping(mapping);
        private final boolean fixed;
        protected void parseCreateFieldForPluggableFormat(ParseContext context) {
        assertWarnings("Parameter [store] has no effect on type [test_mapper] and will be removed in future");
        assertTrue(mapper.fixed);
        }
        IllegalArgumentException e = expectThrows(
            this.name = name;
        final Parameter<Boolean> index = Parameter.boolParam("index", false, m -> ((SideEffectMapper) m).index, true);
 * KIND, either express or implied.  See the License for the
        }
        String mappingWithSame = "{\"type\":\"test_mapper\",\"analyzer\":\"default\","
        @Override
        }
            ),
            this.restricted = builder.restricted.getValue();
            toStringWithDefaults(mapper)
        String mapping = "{\"type\":\"test_mapper\",\"variable\":\"foo\",\"required\":\"value\","
        String mapping = "{\"type\":\"test_mapper\",\"required\":\"value\"}";
        String expectedError = "Mapper for [field] conflicts with existing mapper:\n"
            return new SideEffectBuilder(simpleName()).init(this);
    // test custom serializer
        // mapping is
            return "side_effect_mapper";
            TestMapper mapper = fromMapping(mapping);
            b.field("required", "a");
        }
        assertThat(e.getMessage(), containsString("int_value"));
            @Override
 * Unless required by applicable law or agreed to in writing,
        private StringWrapper(String name) {
            Collections.emptyMap(),
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        String addSubField = "{\"type\":\"test_mapper\",\"variable\":\"foo\",\"required\":\"value\""
        assertEquals("default", mapper.searchAnalyzer.name());
 * Modifications Copyright OpenSearch Contributors. See
        @Override
        private final boolean index;
            assertEquals("Unknown value [baz] for field [restricted] - accepted values are [foo, bar]", e.getMessage());
        @Override
        assertEquals(expectedError, e.getMessage());
import org.opensearch.Version;
        }, version, () -> null, null, null);
        assertEquals("{\"field\":" + mappingWithBoth + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));
        assertEquals("default", mapper.variable);
 *
            parameters.addAll(pluginMappingParameters());
        assertEquals("wrapped value", mapper.wrapper.name);
        builder.lowCard.setValue(true);
        SideEffectMapper wrongTyped = new SideEffectMapper("field", "field", new SideEffectBuilder("field")) {
        assertEquals("analyzer [wibble] has not been configured in mappings", e.getMessage());
    public void testDeprecatedParameterName() {
            + "\"bucket_influencers\":{\"type\":\"nested\",\"properties\":{"
                + "\"wrapper\":\"default\",\"int_value\":5,\"analyzer\":\"_keyword\","
            return "test_mapper";
        builder.setParameterValue("no_such_parameter", true);
        value.toXContent(builder, params);
        }
        public Map<String, Mapper.TypeParser> getMappers() {
        }
    public static class TestPlugin extends Plugin implements MapperPlugin {
        @Override
    public void testSideEffectParameterLeavesIndexingWhenDisabled() {
        String badAnalyzer = "{\"type\":\"test_mapper\",\"analyzer\":\"wibble\",\"required\":\"value\"}";
                + "\"fields\":{\"sub\":{\"type\":\"keyword\"},\"sub2\":{\"type\":\"keyword\"}}}}",
        // Unknown parameter name is a no-op.
        }));
        assertTrue("indexing must stay enabled when the parameter is false", mapper.index);
        TestMapper merged = (TestMapper) mapper.merge(goodMerge);
        String mapping = "{\"type\":\"test_mapper\",\"analyzer\":\"_standard\",\"required\":\"value\"}";
        assertEquals(mapping, Strings.toString(MediaTypeRegistry.JSON, mapperService.documentMapper()));
            toStringWithDefaults(mapper)
        String mapping = "{\"_doc\":{"
        IllegalArgumentException e = expectThrows(
    }
        SideEffectBuilder(String name) {
            + "\"is_interim\":{\"type\":\"boolean\"}}}}}}";
            this.analyzer = builder.analyzer.getValue();
        private final boolean index;
            ParametrizedMapperTests.Builder builder
                return Map.of("low_card", 123);
            if (value == null) {
        }
        assertEquals("{\"field\":" + withDef + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));
        ContentPath path1 = new ContentPath();
            "{\"field\":{\"type\":\"test_mapper\",\"variable\":\"updated\",\"required\":\"value\"," + "\"copy_to\":[\"foo\",\"bar\"]}}",
        ContentPath path2 = new ContentPath();
    }
            String mapping = "{\"type\":\"test_mapper\",\"required\":\"a\",\"restricted\":\"bar\"}";
            b.field("type", "test_mapper");
    }
            if (this == o) return true;
        @Override
        private final int intValue;
            Strings.toString(MediaTypeRegistry.JSON, mapper)
    public void testMergePreservesFullNameForDeeplyDottedSimpleName() {
        // mapping is
import org.opensearch.core.xcontent.XContentBuilder;
        assertEquals(
import org.opensearch.plugins.MapperPlugin;
        assertEquals(
    }
        );
            "{\"field\":{\"type\":\"test_mapper\",\"fixed\":false,\"variable\":\"updated\",\"required\":\"value\"}}",
        protected String contentType() {
            super(name);
        private final StringWrapper wrapper;
        TestMapper mapper = fromMapping(fine);
        );
            );
        assertEquals("_keyword", mapper.analyzer.name());
        assertWarnings("Parameter [fixed2_old] on mapper [field] is deprecated, use [fixed2]");
        TestMapper toMerge = fromMapping(mapping);
    public static class TestMapper extends ParametrizedFieldMapper {
        String fine = "{\"type\":\"test_mapper\",\"variable\":null,\"required\":\"value\"}";
        final String name;
    // add copy_to, verify
            CopyTo copyTo,
    public void testRequiredField() {
        Builder builder1 = new Builder("a.b.c");
    }
            return Objects.hash(name);
            Strings.toString(MediaTypeRegistry.JSON, merged)
import static org.mockito.Mockito.when;
 *     http://www.apache.org/licenses/LICENSE-2.0
        }, m -> toType(m).wrapper).setSerializer((b, n, v) -> b.field(n, v.name), v -> "wrapper_" + v.name);
            return Objects.equals(name, that.name);
import org.opensearch.index.analysis.AnalyzerScope;
            m -> toType(m).searchAnalyzer,
            "{\"field\":{\"type\":\"test_mapper\",\"fixed\":true,"
    /** Builder that contributes a {@code low_card} {@link SideEffectParameter} which disables indexing when true. */
            return new TestMapper(name(), buildFullName(context), multiFieldsBuilder.build(this, context), copyTo.build(), this);
                throw new IllegalArgumentException("Value of [n] cannot be greater than 50");
            b.field("required", "a");
        public ParametrizedFieldMapper build(Mapper.BuilderContext context) {
    public void testCustomSerialization() {
 * The OpenSearch Contributors require contributions made to
            IllegalArgumentException.class,
        assertEquals("root.a.b.c", mapper1.name());
            String mapping = "{\"type\":\"test_mapper\",\"required\":\"a\"}";
 * ownership. Elasticsearch licenses this file to you under
        SideEffectBuilder builder = new SideEffectBuilder("field");
        String mapping = "{\"type\":\"test_mapper\",\"wrapper\":\"wrapped value\",\"required\":\"value\"}";
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> mapper.merge(toMerge));
                Lucene.STANDARD_ANALYZER,
            IllegalArgumentException.class,
            Collections.emptyMap()
        assertEquals("default", mapper.analyzer.name());
        @Override
        public int hashCode() {
        assertEquals("attributes.address.city", mapper1.name());
        final Parameter<String> required = Parameter.stringParam("required", true, m -> toType(m).required, null).setValidator(value -> {
        }
import static org.mockito.Mockito.mock;
        assertEquals("_standard", mapper.analyzer.name());
        @Override
        public boolean equals(Object o) {
        @Override
        mapper = fromMapping(withDef);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> merge(mapperService, fieldMapping(b -> {
            if (Objects.equals("binary", s)) {
    }
            this.intValue = builder.intValue.getValue();
            b.field("type", "test_mapper");
        }
        path.add("root");
    // A stored value whose type does not match the parameter fails loudly instead of a silent wrong value / CCE.
            Strings.toString(MediaTypeRegistry.JSON, noCopyTo)
        }
            return pluginValues;
        }
 */
    }
        );
        @Override
    }
        assertEquals(
            MapperParsingException e = expectThrows(MapperParsingException.class, () -> fromMapping(mapping));
    public void testDefaults() throws IOException {
            + "\"actual\":{\"type\":\"double\"},"
            Strings.toString(MediaTypeRegistry.JSON, merged)
            String mapping = "{\"type\":\"test_mapper\",\"required\":\"a\",\"restricted\":\"baz\"}";
        );
            applyPluginParameterEffects();
    }
            setPluginMappingParameters(List.of(lowCard));
        assertEquals("attributes.address.city", merged.name());
            "{\"type\":\"test_mapper\",\"variable\":\"updated\",\"required\":\"value\"," + "\"copy_to\":[\"foo\",\"bar\"]}"
            MultiFields multiFields,
