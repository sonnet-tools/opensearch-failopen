        // On update, copy_to is completely replaced
                b.setParameterValue("index", false);  
            TestMapper mapper = fromMapping(mapping);
        }, m -> toType(m).wrapper).setSerializer((b, n, v) -> b.field(n, v.name), v -> "wrapper_" + v.name);
/*
        }  
            if (value == null) {  
            true,  
            ParametrizedMapperTests.Builder builder
            if (this == o) return true;  
            b.field("type", "test_mapper");
    }  
 * Unless required by applicable law or agreed to in writing,
        SideEffectMapper mapper = (SideEffectMapper) builder.build(new Mapper.BuilderContext(Settings.EMPTY, new ContentPath(0)));  
    }
        TestMapper merged = (TestMapper) mapper.merge(toMerge);  
        TestMapper mapper1 = (TestMapper) builder1.build(new Mapper.BuilderContext(Settings.EMPTY, path1));
    }
    }  
 */
                return BinaryFieldMapper.PARSER;
        assertEquals("Value of [n] cannot be greater than 50", e.getMessage());
            + "\"is_interim\":{\"type\":\"boolean\"}}}}}}";
            assertEquals("foo", mapper.restricted);
        public Builder getMergeBuilder() {  
import java.util.Objects;  
    }
            this.required = builder.required.getValue();
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
        SideEffectMapper mapper = (SideEffectMapper) builder.build(new Mapper.BuilderContext(Settings.EMPTY, new ContentPath(0)));
        };
        assertEquals("attributes.address.city", mapper1.name());
 * Licensed to Elasticsearch under one or more contributor  
        Builder builder1 = new Builder("a.b.c");  
            + "\"bucket_span\":{\"type\":\"long\"},"  
        final Parameter<NamedAnalyzer> analyzer = Parameter.analyzerParam(
        Builder builder = new Builder("field");
                return KeywordFieldMapper.PARSER;
        return (TestMapper) in;
        @Override
        private final NamedAnalyzer analyzer;  
        private final boolean index;
        // 'index' is declared explicitly, 'store' is not, but is one of the previously always-accepted params
            this.wrapper = builder.wrapper.getValue();
            this.fixed2 = builder.fixed2.getValue();  
        assertEquals(
        final Parameter<Integer> intValue = Parameter.intParam("int_value", true, m -> toType(m).intValue, 5).setValidator(n -> {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> reinit.init(wrongTyped));
        assertEquals("default", mapper.searchAnalyzer.name());
        SideEffectMapper wrongTyped = new SideEffectMapper("field", "field", new SideEffectBuilder("field")) {
            String fullName,
        private final boolean index;
        );
        IllegalArgumentException e = expectThrows(  
        private final String restricted;
        ToXContent.Params params = new ToXContent.MapParams(Collections.singletonMap("include_defaults", "true"));  
        assertFalse(mapper.index);
        assertEquals("default", mapper.analyzer.name());
        return builder.toString();
            Collections.emptyMap(),
        protected void parseCreateField(ParseContext context) {}
            return builder;
            return new ParametrizedMapperTests.Builder(simpleName()).init(this);
                + "\"fixed2\":false,\"variable\":\"default\",\"index\":true,"
 *
        String fine = "{\"type\":\"test_mapper\",\"variable\":null,\"required\":\"value\"}";
            List<Parameter<?>> parameters = new ArrayList<>();
        assertEquals("{\"field\":" + mapping + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));   // original  
    public void testRequiredField() {
import static org.mockito.Mockito.mock;
        }
    public void testCopyTo() {  
        @Override  
        final Parameter<Boolean> fixed = Parameter.boolParam("fixed", false, m -> toType(m).fixed, true);  
            m -> toType(m).searchAnalyzer,
            builder.parse(name, parserContext, node);  
        }
            b.field("int_value", 10);
            toStringWithDefaults(mapper)
            this.restricted = builder.restricted.getValue();
    public void testSideEffectParameterReadsResolvedValue() {
        MapperService mapperService = createMapperService(fieldMapping(b -> {
        ) {  
            b.field("required", "a");  
            return parameters;
                + "\tCannot update parameter [wrapper] from [wrapper_wrapped value] to [wrapper_new value]",
 */  
        Builder builder2 = new Builder("address.city");
        TestMapper original = mapper;  
            return Arrays.asList(fixed, fixed2, variable, index, wrapper, intValue, analyzer, searchAnalyzer, required, restricted);
import org.opensearch.core.xcontent.XContentBuilder;
    public static class TypeParser implements Mapper.TypeParser {
        }  
            this.name = name;
 *
        assertEquals("{\"field\":" + mapping + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> fromMapping(badAnalyzer));  
        private final StringWrapper wrapper;
    public static class TestPlugin extends Plugin implements MapperPlugin {  
        TestMapper toMerge = fromMapping(mapping);
        protected void parseCreateFieldForPluggableFormat(ParseContext context) {
        public ParametrizedFieldMapper.Builder getMergeBuilder() {
import java.util.Collection;
        protected String contentType() {  
        TestMapper mapper = fromMapping(fine);  
        when(mapperService.getIndexAnalyzers()).thenReturn(indexAnalyzers);
    }
        TestMapper mapper = fromMapping(mapping);
    public void testRestrictedField() {  
    }  
        }
        mapper = fromMapping(mappingWithSA);
    }
        );  
import org.opensearch.index.analysis.IndexAnalyzers;
    private static TestMapper fromMapping(String mapping, Version version) {
        TestMapper toMerge = fromMapping(
        TestMapper mapper = fromMapping(mapping);
                "_keyword",
                + "\"fixed2\":false,\"variable\":\"default\",\"index\":true,"
        TestMapper mapper = fromMapping(mapping);
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> fromMapping(mapping));
        );  
        builder.setParameterValue("index", false);  
        // unaffected
        );  
    }  
        @Override
    }
        assertEquals("_standard", mapper.searchAnalyzer.name());
        String mapping = "{\"type\":\"test_mapper\",\"fixed2_old\":true,\"required\":\"value\"}";
        SideEffectMapper(String simpleName, String fullName, SideEffectBuilder builder) {
    // add copy_to, verify
    private String toStringWithDefaults(ToXContent value) throws IOException {
    public void testSetParameterValueRejectsTypeMismatch() {  
            String mapping = "{\"type\":\"test_mapper\",\"required\":null}";  
            "{\"field\":{\"type\":\"test_mapper\",\"fixed\":true,"  
            "{\"field\":{\"type\":\"test_mapper\",\"fixed\":false,\"variable\":\"updated\",\"required\":\"value\"}}",  
        assertThat(e.getMessage(), containsString("Cannot set parameter [index]"));
        mapper = fromMapping(mappingWithSame);  
        // unaffected
        String mapping = "{\"type\":\"test_mapper\",\"fixed\":null,\"required\":\"value\"}";
        ContentPath path = new ContentPath();
        @Override  
            String simpleName,
        XContentBuilder builder = JsonXContent.contentBuilder();
        builder1.required.setValue("value");
    public void testObjectSerialization() throws IOException {
        }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> merge(mapperService, fieldMapping(b -> {
        @Override
import org.opensearch.core.common.Strings;
                + "\"required\":\"value\",\"restricted\":\"foo\"}}",  
                + "\"wrapper\":\"default\",\"int_value\":5,\"analyzer\":\"default\","
        );
            + "\"actual\":{\"type\":\"double\"},"
        return (TestMapper) new TypeParser().parse("field", XContentHelper.convertToMap(JsonXContent.jsonXContent, mapping, true), pc)
            "{\"field\":{\"type\":\"test_mapper\",\"fixed\":true,"  
        }
        assertEquals("address.city", merged.simpleName());  
            this.variable = builder.variable.getValue();
            false,  
            searchAnalyzer.setSerializerCheck(  
    /** Minimal mapper used to exercise {@link SideEffectParameter} end to end. */
        @Override
        protected void parseCreateFieldForPluggableFormat(ParseContext context) {}
    public void testMergePreservesFullNameForDottedSimpleName() {  
                throw new IllegalArgumentException("Value of [n] cannot be greater than 50");
            "{\"field\":{\"type\":\"test_mapper\",\"variable\":\"updated\",\"required\":\"value\"}}",
 *  
                + "\"fields\":{\"sub\":{\"type\":\"keyword\"},\"sub2\":{\"type\":\"keyword\"}}}}",  
        public ParametrizedFieldMapper build(Mapper.BuilderContext context) {
        TestMapper mapper = fromMapping(mapping);  
    public void testParameterValidation() {
import static org.hamcrest.Matchers.instanceOf;  
        assertEquals("wrapped value", mapper.wrapper.name);
            return new SideEffectMapper(name(), buildFullName(context), this);
        assertEquals(mapper.analyzer.name(), "default");
}  
    public void testCustomSerialization() {
            setPluginMappingParameters(List.of(lowCard));  
        private final boolean fixed2;
    }
            return "test_mapper";
        TestMapper toMerge = fromMapping(conflict);  
                (id, ic, v) -> Objects.equals(analyzer.getValue().name(), searchAnalyzer.getValue().name()) == false
 * KIND, either express or implied.  See the License for the
        assertEquals(10, mapper.intValue);
            }
        return Collections.singletonList(new TestPlugin());  
        @Override
        TestMapper toMerge = fromMapping(addSubField);
    }  
        SideEffectBuilder(String name) {
        TestMapper goodMerge = fromMapping("{\"type\":\"test_mapper\",\"fixed\":false,\"variable\":\"updated\",\"required\":\"value\"}");
    public void testLinkedAnalyzers() throws IOException {  
        assertEquals(mapping, Strings.toString(MediaTypeRegistry.JSON, mapperService.documentMapper()));
                throw new IllegalArgumentException("field [required] must be specified");
                Lucene.KEYWORD_ANALYZER,  
        builder2.required.setValue("updated");
            return "side_effect_mapper";
        // mapping is
import org.opensearch.common.compress.CompressedXContent;  
        @Override  
        final Parameter<NamedAnalyzer> searchAnalyzer = Parameter.analyzerParam(
    }
        assertEquals("{\"field\":" + mapping + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));  
        @Override  
    }
            }
        Builder builder2 = new Builder("a.b.c");
            applyPluginParameterEffects();
        );  
            "Mapper for [field] conflicts with existing mapper:\n" + "\tCannot update parameter [analyzer] from [default] to [_standard]",
        mapper = fromMapping(mappingWithBoth);  
    // test validator  
 * this work for additional information regarding copyright
        }  
    public void testSideEffectParameterLeavesIndexingWhenDisabled() {
import org.opensearch.index.mapper.ParametrizedFieldMapper.Parameter;  
        }
        public Map<String, Object> mappingPluginParameterValues() {  
                "_standard",  
        MapperService mapperService = createMapperService("_doc", mapping);  
            if (Boolean.TRUE.equals(enabled)) {
            + "\"search_analyzer\":\"_standard\",\"required\":\"value\"}";
        assertEquals("attributes.address.city", merged.name());
        }
        assertEquals("default", mapper.analyzer.name());
        {
 * software distributed under the License is distributed on an
            this.index = builder.index.getValue();
            String mapping = "{\"type\":\"test_mapper\",\"required\":\"a\",\"restricted\":\"baz\"}";
        return fromMapping(mapping, Version.CURRENT);
    // When the SideEffectParameter resolves to false, no side effect is applied and indexing stays enabled.  
    protected Collection<Plugin> getPlugins() {
        assertEquals("a.b.c", merged.simpleName());
        final Parameter<Boolean> fixed2 = Parameter.boolParam("fixed2", false, m -> toType(m).fixed2, false)
    }
        assertEquals("default", mapper.variable);
        assertEquals(
        final Parameter<String> variable = Parameter.stringParam("variable", true, m -> toType(m).variable, "default").acceptsNull();  
/*  
import org.opensearch.index.analysis.NamedAnalyzer;
        TestMapper mapper = fromMapping(mapping);
        String mappingWithSA = "{\"type\":\"test_mapper\",\"search_analyzer\":\"_standard\",\"required\":\"value\"}";
        private final int intValue;
            IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> fromMapping(mapping));
    }  
            () -> fromMapping("{\"type\":\"test_mapper\",\"int_value\":60,\"required\":\"value\"}")  
    }  
            "{\"field\":{\"type\":\"test_mapper\",\"analyzer\":\"default\",\"required\":\"value\"}}",
            Strings.toString(MediaTypeRegistry.JSON, mapper)
        protected Builder(String name) {  
        TestMapper merged = (TestMapper) mapper1.merge(mapper2);
            Strings.toString(MediaTypeRegistry.JSON, merged)
 * license agreements. See the NOTICE file distributed with
        assertEquals("{\"field\":" + fine + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));
    }
        }  
    }
        String mapping = "{\"type\":\"test_mapper\",\"analyzer\":\"_standard\",\"required\":\"value\"}";
            StringWrapper that = (StringWrapper) o;
 * this file be licensed under the Apache-2.0 license or a
    }
            String mapping = "{\"type\":\"test_mapper\",\"required\":\"a\",\"restricted\":\"bar\"}";
import org.opensearch.common.xcontent.json.JsonXContent;
        public int hashCode() {
            "{\"field\":{\"type\":\"test_mapper\",\"variable\":\"updated\",\"required\":\"value\"," + "\"copy_to\":[\"foo\",\"bar\"]}}",  
            ),  
            + "\tCannot update parameter [fixed2] from [false] to [true]";  
        @Override  
    @Override
        );
        assertTrue(mapper.fixed);
            String mapping = "{\"type\":\"test_mapper\"}";
        assertTrue("indexing must stay enabled when the parameter is false", mapper.index);
        assertEquals("{\"field\":" + mapping + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));
        assertThat(e.getMessage(), containsString("int_value"));  
            Strings.toString(MediaTypeRegistry.JSON, mapper)
        assertFalse(builder.index.getValue());
import java.util.ArrayList;  
    public void testMerging() {  
        }  
        }  
    }
        protected List<Parameter<?>> getParameters() {
    }
import org.opensearch.index.mapper.ParametrizedFieldMapper.SideEffectParameter;
        final String name;
    }  
            b.field("type", "test_mapper");
            super(name);
        assertEquals(
        }).setMergeValidator((o, n) -> n >= o);  
        assertEquals("root.a.b.c", merged.name());
        }  
    // add multifield, verify, add second multifield, verify, overwrite second multifield
            }
            assertEquals("Unknown value [baz] for field [restricted] - accepted values are [foo, bar]", e.getMessage());
    public static class TestMapper extends ParametrizedFieldMapper {
        protected TestMapper(  
            "{\"field\":{\"type\":\"test_mapper\",\"fixed2\":true,\"required\":\"value\"}}",  
        assertEquals("{\"field\":" + mapping + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));  
    // A SideEffectParameter that resolves to true disables indexing at build time via its side effect.
    public void testDeprecatedParameterName() {  
        String mapping = "{\"type\":\"test_mapper\",\"variable\":\"foo\",\"required\":\"value\",\"copy_to\":[\"other\"]}";
    public static class SideEffectMapper extends ParametrizedFieldMapper {  
        assertEquals(expectedError, e.getMessage());
 * specific language governing permissions and limitations
            this.fixed = builder.fixed.getValue();
        path.add("root");  
        TestMapper removeCopyTo = fromMapping("{\"type\":\"test_mapper\",\"variable\":\"updated\",\"required\":\"value\"}");
        String mapping = "{\"type\":\"test_mapper\",\"index\":false,\"store\":true,\"required\":\"value\"}";
                return Map.of("low_card", 123);
    }  
        assertEquals("{\"field\":" + mapping + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));
        TestMapper badToMerge = fromMapping(badSubField);  
        assertEquals("_standard", mapper.searchAnalyzer.name());
            () -> builder.setParameterValue("index", "not-a-boolean")
            return pluginValues;
        assertEquals(
            m -> toType(m).analyzer,
        );  
    // A stored value whose type does not match the parameter fails loudly instead of a silent wrong value / CCE.  
        );
        {
        );  
            IllegalArgumentException.class,
        MapperService mapperService = mock(MapperService.class);  
        assertEquals(mapper.analyzer, Lucene.STANDARD_ANALYZER);
import org.apache.lucene.analysis.standard.StandardAnalyzer;
            assertEquals("[required] on mapper [field] of type [test_mapper] must not have a [null] value", exc.getMessage());
        );  
            + "\"search_analyzer\":\"default\",\"required\":\"value\"}";
        assertEquals(
            return Map.of("test_mapper", new TypeParser());  
        protected List<Parameter<?>> getParameters() {  
 * compatible open source license.
        public ParametrizedFieldMapper build(Mapper.BuilderContext context) {  
        e = expectThrows(IllegalArgumentException.class, () -> original.merge(toMerge));
    // test custom serializer
        private StringWrapper(String name) {  
        final Parameter<Boolean> index = Parameter.boolParam("index", false, m -> ((SideEffectMapper) m).index, true);  
        IndexAnalyzers indexAnalyzers = new IndexAnalyzers(
        String mapping = "{\"type\":\"test_mapper\",\"int_value\":10,\"required\":\"value\"}";
        assertWarnings("Parameter [store] has no effect on type [test_mapper] and will be removed in future");
            return Objects.hash(name);
        @Override
    }
            Map.of(
        assertThat(e.getMessage(), containsString("resolved to a value of type"));
    }
        {  
        ContentPath path1 = new ContentPath();  
        }
            }  
        }  
import org.opensearch.core.xcontent.ToXContent;
            String mapping = "{\"type\":\"test_mapper\",\"required\":\"a\"}";  
            + "\"bucket_influencers\":{\"type\":\"nested\",\"properties\":{"
            + "\"properties\":{"
        assertTrue("value must be read back from the mapping", reinit.lowCard.getValue());  
        TestMapper noCopyTo = (TestMapper) merged.merge(removeCopyTo);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> mapper.merge(badMerge));  
        TestMapper mapper = fromMapping(mapping);
        // analyzer, no matter what the value of `include_defaults` is  
            public Map<String, Object> mappingPluginParameterValues() {
 * The OpenSearch Contributors require contributions made to  
        assertTrue(mapper.fixed2);  
    private static class StringWrapper {  
            e.getMessage()
import java.io.IOException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        TestMapper merged = (TestMapper) mapper.merge(goodMerge);  
            + "\"fields\":{\"sub2\":{\"type\":\"binary\"}}}";
            "Mapper for [field] conflicts with existing mapper:\n"  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> mapper.merge(toMerge));
import org.opensearch.Version;
        TestMapper merged = (TestMapper) mapper.merge(toMerge);
            + "\"bucket_count\":{\"type\":\"long\"},"  
 * You may obtain a copy of the License at  
    public void testDeprecatedParameters() {  
        assertFalse("side effect must disable indexing", mapper.index);  
            "{\"type\":\"test_mapper\",\"variable\":\"updated\",\"required\":\"value\"," + "\"copy_to\":[\"foo\",\"bar\"]}"
        mapper = fromMapping(withDef);  
            e.getMessage()
import org.opensearch.index.analysis.AnalyzerScope;  
        );
        }));
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            if (o == null || getClass() != o.getClass()) return false;
        String withDef = "{\"type\":\"test_mapper\",\"analyzer\":\"default\",\"required\":\"value\"}";
        }
            MultiFields multiFields,  
        SideEffectMapper mapper = (SideEffectMapper) builder.build(new Mapper.BuilderContext(Settings.EMPTY, new ContentPath(0)));
        public boolean equals(Object o) {
        @Override
        SideEffectBuilder reinit = new SideEffectBuilder("field");  
        Mapper.TypeParser.ParserContext pc = new Mapper.TypeParser.ParserContext(s -> null, mapperService, s -> {
                new NamedAnalyzer("default", AnalyzerScope.INDEX, new StandardAnalyzer())
        String mapping = "{\"type\":\"test_mapper\",\"fixed\":false,\"required\":\"value\"}";
public class ParametrizedMapperTests extends MapperServiceTestCase {
    public void testAnalyzers() {
        assertEquals("[fixed] on mapper [field] of type [test_mapper] must not have a [null] value", e.getMessage());  
            + ",\"fields\":{\"sub2\":{\"type\":\"keyword\"}}}";
        SideEffectBuilder builder = new SideEffectBuilder("field");  
        assertEquals("{\"field\":" + mapping + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));  
            "{\"field\":{\"type\":\"test_mapper\",\"variable\":\"foo\",\"required\":\"value\","
    private static TestMapper toType(Mapper in) {  
        mapperService.merge("_doc", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);  
        protected String contentType() {
            parameters.add(index);  
import static org.hamcrest.Matchers.containsString;
        @Override  
    public void testMergePreservesFullNameForDeeplyDottedSimpleName() {
    // test deprecations
        );  
        SideEffectBuilder reinit = new SideEffectBuilder("field");
        SideEffectBuilder builder = new SideEffectBuilder("field");  
        TestMapper mapper2 = (TestMapper) builder2.build(new Mapper.BuilderContext(Settings.EMPTY, path));
            this.pluginValues = builder.pluginMappingParameterValues();
        final Parameter<Boolean> index = Parameter.boolParam("index", false, m -> toType(m).index, true);
            }
            Collections.emptyMap()
import org.opensearch.common.settings.Settings;
        private final Map<String, Object> pluginValues;  
        String mapping = "{\"type\":\"test_mapper\",\"required\":\"value\"}";
        protected void parseCreateField(ParseContext context) {
            super(name);
        assertEquals(  
            .addDeprecatedName("fixed2_old");
    }  
        String mapping = "{\"type\":\"test_mapper\",\"wrapper\":\"wrapped value\",\"required\":\"value\"}";  
            + "\"fields\":{\"sub\":{\"type\":\"keyword\"}}}";
            );
        // Unknown parameter name is a no-op.  
        TestMapper merged = (TestMapper) mapper1.merge(mapper2);  
        builder.setParameterValue("no_such_parameter", true);
            if (Objects.equals("binary", s)) {  
        }
import org.opensearch.plugins.Plugin;  
        assertEquals("updated", merged.required);
        TestMapper mapper1 = (TestMapper) builder1.build(new Mapper.BuilderContext(Settings.EMPTY, path));
        final SideEffectParameter<Boolean> lowCard = SideEffectParameter.boolParam("low_card", false, false, (b, enabled) -> {
        }
            MapperParsingException exc = expectThrows(MapperParsingException.class, () -> fromMapping(mapping));
        }  
        final Parameter<StringWrapper> wrapper = new Parameter<>("wrapper", false, () -> new StringWrapper("default"), (n, c, o) -> {
        }
        TestMapper badMerge = fromMapping("{\"type\":\"test_mapper\",\"fixed\":true,\"fixed2\":true,\"required\":\"value\"}");
        // TODO: should we have to include 'fixed' here? Or should updates take as 'defaults' the existing values?
        ContentPath path2 = new ContentPath();  
        assertEquals("{\"field\":" + mapping + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));
        TestMapper mapper = fromMapping(mapping);
        }
 * Modifications Copyright OpenSearch Contributors. See
            "search_analyzer",
        private final String required;  
        String mapping = "{\"type\":\"test_mapper\",\"analyzer\":\"_standard\",\"required\":\"value\"}";  
        assertEquals(  
        assertEquals("_keyword", mapper.analyzer.name());  
            b.field("int_value", 5);    // custom merge validator says that int_value can only increase
            @Override  
        reinit.init(mapper);
            Builder builder = new Builder(name);
        builder2.required.setValue("v2");  
import java.util.List;
        @Override
            Strings.toString(MediaTypeRegistry.JSON, merged)
        String addSubField = "{\"type\":\"test_mapper\",\"variable\":\"foo\",\"required\":\"value\""  
            return new SideEffectBuilder(simpleName()).init(this);  
                + "\"wrapper\":\"default\",\"int_value\":5,\"analyzer\":\"_keyword\","
        TestMapper mapper2 = (TestMapper) builder2.build(new Mapper.BuilderContext(Settings.EMPTY, path2));
        final Parameter<String> restricted = Parameter.restrictedStringParam("restricted", true, m -> toType(m).restricted, "foo", "bar");
        @Override
            .build(new Mapper.BuilderContext(Settings.EMPTY, new ContentPath(0)));  
        assertEquals("{\"field\":" + mappingWithSA + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));
    // merging - try updating 'fixed' and 'fixed2' should get an error, try updating 'variable' and verify update
        });  
            analyzer::getValue
        assertEquals("{\"field\":" + withDef + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));  
            // only output search analyzer if different to analyzer
package org.opensearch.index.mapper;
        path1.add("attributes");
        IllegalArgumentException e = expectThrows(
            + "\"anomaly_score\":{\"type\":\"double\"},"
            this.intValue = builder.intValue.getValue();  
            return null;  
        assertEquals("mapper [field.sub2] cannot be changed from type [keyword] to [binary]", e.getMessage());
import java.util.Map;
            b.field("required", "a");  
        builder1.required.setValue("v1");
        assertEquals("{\"field\":" + mappingWithBoth + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));  
    private static TestMapper fromMapping(String mapping) {  
            super(simpleName, new KeywordFieldMapper.KeywordFieldType(fullName), multiFields, copyTo);
    }  
        public Map<String, Mapper.TypeParser> getMappers() {
        assertEquals("analyzer [wibble] has not been configured in mappings", e.getMessage());
        String mapping = "{\"type\":\"test_mapper\",\"variable\":\"foo\",\"required\":\"value\","
    }  
            MapperParsingException e = expectThrows(MapperParsingException.class, () -> fromMapping(mapping));  
        String mapping = "{\"_doc\":{"  
        @Override
            CopyTo copyTo,
    public void testCustomMergeValidation() throws IOException {  
            Strings.toString(MediaTypeRegistry.JSON, mapper)
        private final boolean fixed;
                + "\"required\":\"value\",\"restricted\":\"foo\"}}",  
    public static class SideEffectBuilder extends ParametrizedFieldMapper.Builder {
 * GitHub history for details.
    }
        TestMapper mapper = fromMapping(mapping);  
        assertWarnings("Parameter [fixed2_old] on mapper [field] is deprecated, use [fixed2]");
        builder.lowCard.setValue(true);
        assertEquals("{\"field\":" + mapping + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));  
        final Parameter<String> required = Parameter.stringParam("required", true, m -> toType(m).required, null).setValidator(value -> {
        String conflict = "{\"type\":\"test_mapper\",\"wrapper\":\"new value\",\"required\":\"value\"}";
            "analyzer",
        }  
            TestMapper mapper = fromMapping(mapping);
 * not use this file except in compliance with the License.
        value.toXContent(builder, params);
 */  
    }
        assertEquals("_standard", mapper.analyzer.name());  
        );  
            + "\tCannot update parameter [fixed] from [false] to [true]\n"
            if (Objects.equals("keyword", s)) {  
        String expectedError = "Mapper for [field] conflicts with existing mapper:\n"
    public void testSideEffectParameterReadBackRejectsTypeMismatch() {
            if (n > 50) {  
            return new TestMapper(name(), buildFullName(context), multiFieldsBuilder.build(this, context), copyTo.build(), this);  
            IllegalArgumentException.class,
            assertEquals("field [required] must be specified", iae.getMessage());  
            this.index = builder.index.getValue();  
 *     http://www.apache.org/licenses/LICENSE-2.0
        {  
            toStringWithDefaults(mapper)
        assertEquals(mapping, Strings.toString(MediaTypeRegistry.JSON, mapperService.documentMapper()));
import static org.mockito.Mockito.when;
        TestMapper mapper = fromMapping(mapping);
    public static class Builder extends ParametrizedFieldMapper.Builder {
        }, version, () -> null, null, null);
            super(simpleName, new KeywordFieldMapper.KeywordFieldType(fullName), MultiFields.empty(), CopyTo.empty());  
import java.util.Collections;  
            Strings.toString(MediaTypeRegistry.JSON, merged)
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> merged.merge(badToMerge));
        assertEquals("root.a.b.c", mapper1.name());  
        );
            }
    /** Builder that contributes a {@code low_card} {@link SideEffectParameter} which disables indexing when true. */  
 * under the License.  
    public void testDefaults() throws IOException {  
            () -> Lucene.KEYWORD_ANALYZER
import org.opensearch.common.xcontent.XContentHelper;  
        private final NamedAnalyzer searchAnalyzer;
    public void testMultifields() {  
        assertEquals("{\"field\":" + mapping + "}", Strings.toString(MediaTypeRegistry.JSON, mapper));   // original
    // The parameter reads its resolved value back from mappingPluginParameterValues() when a mapper is re-initialised.
        String badSubField = "{\"type\":\"test_mapper\",\"variable\":\"foo\",\"required\":\"value\","
    public void testNullables() {  
        );
        builder.endObject();  
/*  
        private final String variable;  
        // we've configured things so that search_analyzer is only output when different from
        })));
        String mappingWithBoth = "{\"type\":\"test_mapper\",\"analyzer\":\"default\","
        }
        assertEquals("_standard", mapper.searchAnalyzer.name());
        });
        assertThat(mapper.analyzer.analyzer(), instanceOf(StandardAnalyzer.class));
                "default",
    }
        assertEquals("address.city", mapper1.simpleName());
            "{\"field\":{\"type\":\"test_mapper\",\"index\":false,\"required\":\"value\"}}",
    }
            if (o == null) return null;
            return new StringWrapper(o.toString());  
        @Override  
 * ownership. Elasticsearch licenses this file to you under  
    public void testSideEffectParameterDisablesIndexingWhenEnabled() {
        path2.add("attributes");
            this.analyzer = builder.analyzer.getValue();
import org.opensearch.plugins.MapperPlugin;
            parameters.addAll(pluginMappingParameters());
                Lucene.STANDARD_ANALYZER,
            Strings.toString(MediaTypeRegistry.JSON, noCopyTo)
import java.util.Arrays;
        String mappingWithSame = "{\"type\":\"test_mapper\",\"analyzer\":\"default\","
        // mapping is  
        assertEquals(
        public Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {
        );  
        assertEquals(  
    // setParameterValue only accepts a value type-compatible with the target parameter; a mismatch throws.
        assertEquals(
            assertEquals("bar", mapper.restricted);  
        builder.startObject();
        {
            return Objects.equals(name, that.name);  
        String badAnalyzer = "{\"type\":\"test_mapper\",\"analyzer\":\"wibble\",\"required\":\"value\"}";
        Builder builder1 = new Builder("address.city");
        TestMapper mapper = fromMapping(mapping, Version.V_2_0_0);  
        assertEquals(  
        builder.lowCard.setValue(true);
        SideEffectBuilder builder = new SideEffectBuilder("field");
import org.opensearch.common.lucene.Lucene;
    // defaults - create empty builder config, and serialize with and without defaults
        }
            this.searchAnalyzer = builder.searchAnalyzer.getValue();
    }
