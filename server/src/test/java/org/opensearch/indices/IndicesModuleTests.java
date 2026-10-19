        }, new MapperPlugin() {
        assertEquals(IgnoredFieldMapper.NAME, iterator.next());
    private static class FakeMapperParser implements Mapper.TypeParser {
 * Unless required by applicable law or agreed to in writing,
    }
    public void testGetBuiltInMetadataFields() {  
            int i = 0;
        assertThat(e.getMessage(), containsString("already registered"));
        assertFalse(fieldFilter.apply("filtered").test(randomAlphaOfLengthBetween(3, 5)));
        assertTrue(fieldFilter.apply(randomAlphaOfLengthBetween(3, 5)).test("visible"));
        assertThat(e.getMessage(), containsString(plugins.get(1).getClass().getName()));
    public void testDuplicateFieldNamesMapper() {  
        assertFalse(fieldFilter.apply("hidden_index").test("hidden_field"));  
    private static final MetadataFieldMapper.TypeParser PARSER = new MetadataFieldMapper.ConfigurableTypeParser(c -> null, c -> null);  
 * software distributed under the License is distributed on an
        public Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {
                Map<String, Object> mappingConfig,
        @Override  
        @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                // Default supportedTypes() is empty — a configuration error.  
        IndicesModule indicesModule = new IndicesModule(mapperPlugins);
        assertEquals(FieldNamesFieldMapper.NAME, last);  
    }  
import org.opensearch.index.mapper.SeqNoFieldMapper;  
    }  
            assertEquals(EXPECTED_METADATA_FIELDS.length, metadataMapperParsers.size());  
        assertSame(MapperPlugin.NOOP_FIELD_FILTER, fieldFilter);  
        RoutingFieldMapper.NAME,
 * GitHub history for details.
        }, new MapperPlugin() {
            public Function<String, Predicate<String>> getFieldFilter() {
import org.opensearch.index.mapper.NestedPathFieldMapper;
            assertFalse(module.getMapperRegistry().getMetadataMapperParsers().isEmpty());
}  
            @Override
    }
            }  
import java.util.List;  
    public void testDuplicateOtherPluginMetadataMapper() {  
    private static String[] EXPECTED_METADATA_FIELDS = new String[] {
package org.opensearch.indices;
    private final List<MapperPlugin> fakePlugins = Arrays.asList(new MapperPlugin() {
        assertFalse(fieldFilter.apply("hidden_index").test(randomAlphaOfLengthBetween(3, 5)));  
        public Map<String, MetadataFieldMapper.TypeParser> getMetadataMappers() {  
            greaterThan(noPluginsModule.getMapperRegistry().getMetadataMapperParsers().size())  
            public Function<String, Predicate<String>> getFieldFilter() {  
import java.util.Iterator;
            @Override  
import org.opensearch.indices.mapper.MapperRegistry;
import org.opensearch.index.mapper.IgnoredFieldMapper;
import java.util.function.Predicate;
    }
import java.util.ArrayList;
            }  
    public void testFieldNamesIsLast() {
    /** A no-op dynamic template type handler for registration tests. */
            public Map<String, MetadataFieldMapper.TypeParser> getMetadataMappers() {
import static org.hamcrest.Matchers.greaterThan;
            @Override
        }, new MapperPlugin() {  
            for (String field : metadataMapperParsers.keySet()) {
 * Licensed to Elasticsearch under one or more contributor  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.mapper.FieldNamesFieldMapper;  
            public List<org.opensearch.index.mapper.DynamicFieldTypeInferencer> getDynamicFieldTypeInferencers() {
    }
        IndicesModule module = new IndicesModule(Collections.emptyList());
        assertThat(e.getMessage(), containsString(plugins.get(0).getClass().getName()));  
            assertEquals(EXPECTED_METADATA_FIELDS.length, module.getMapperRegistry().getMetadataMapperParsers().size());
                return Collections.singletonMap("dup_type", noopHandler());  
        }  
            public Map<String, Object> inferFieldType(org.opensearch.index.mapper.FieldValueParserSupplier fieldValueParser) {
                return Collections.singletonList(fieldValueParser -> null);
        MapperPlugin plugin = new MapperPlugin() {
                return null;
        List<MapperPlugin> plugins = Arrays.asList(plugin, plugin);
        List<MapperPlugin> plugins = Arrays.asList(plugin, plugin);
/*  
    public void testInferencerSupportedTypeNotRegisteredRejectedAtStartup() {
    }
import java.util.function.Function;  
        });  
            @Override  
        List<MapperPlugin> plugins = Arrays.asList(new MapperPlugin() {
        Function<String, Predicate<String>> fieldFilter = mapperRegistry.getFieldFilter();
 * The OpenSearch Contributors require contributions made to  
        assertThat(e.getMessage(), containsString("declares supported type [unregistered_type]"));
        assertSame(MapperPlugin.NOOP_FIELD_PREDICATE, fieldFilter.apply(randomAlphaOfLengthBetween(3, 7)));  
            }
            @Override  
                return Collections.singletonMap("dup_type", noopHandler());
        int numPlugins = randomIntBetween(0, 10);
            mapperPlugins.add(new MapperPlugin() {
                return Collections.singleton(supportedType);  
            }
        );
            }
public class IndicesModuleTests extends OpenSearchTestCase {  
        assertThat(registry.getMapperParsers().size(), greaterThan(noPluginsModule.getMapperRegistry().getMapperParsers().size()));  
            assertEquals(EXPECTED_METADATA_FIELDS[i++], field);
import org.opensearch.index.mapper.RoutingFieldMapper;
                return index -> index.equals("hidden_index") ? field -> false : MapperPlugin.NOOP_FIELD_PREDICATE;  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new IndicesModule(plugins));
import org.opensearch.index.mapper.DataStreamFieldMapper;
        });
        assertTrue(fieldFilter.apply(randomAlphaOfLengthBetween(3, 5)).test(randomAlphaOfLengthBetween(3, 5)));
        assertThat(e.getMessage(), containsString("dynamic template type [dup_type] is registered by both"));
            return null;
    public void testFieldNamesIsLastWithPlugins() {
            public Map<String, MetadataFieldMapper.TypeParser> getMetadataMappers() {  
            }
        assertTrue(registry.getDynamicTemplateTypes().containsKey("my_type"));
import static org.hamcrest.Matchers.containsString;  
        List<MapperPlugin> plugins = Collections.singletonList(new MapperPlugin() {  
            }
 * Modifications Copyright OpenSearch Contributors. See
                return index -> field -> field.equals("hidden_field") == false;
    public void testDuplicateBuiltinMapper() {
                assertEquals(EXPECTED_METADATA_FIELDS[i++], field);  
        });
            registry.getMetadataMapperParsers().size(),
            public Map<String, MetadataFieldMapper.TypeParser> getMetadataMappers() {  
            ) {}  
        Function<String, Predicate<String>> fieldFilter = indicesModule.getMapperRegistry().getFieldFilter();
        });
        assertNotSame(MapperPlugin.NOOP_FIELD_PREDICATE, fieldFilter.apply("hidden_index"));
        assertThat(e.getMessage(), containsString("already registered"));  
            @Override  
    private static org.opensearch.index.mapper.DynamicTemplateTypeHandler noopHandler() {  
 * license agreements. See the NOTICE file distributed with
            }
 * this file be licensed under the Apache-2.0 license or a
    }  
            public void adjustMappingConfig(  
        }, new MapperPlugin() {  
    public void testBuiltinMappers() {  
 * SPDX-License-Identifier: Apache-2.0
                // Declares a supported type the plugin does not register via getMappers().  
            @Override  
            public Map<String, org.opensearch.index.mapper.DynamicTemplateTypeHandler> getDynamicTemplateTypes() {
            @Override
        List<String> fieldNames = new ArrayList<>(module.getMapperRegistry().getMetadataMapperParsers().keySet());
            }
import java.util.Arrays;  
import org.opensearch.index.mapper.VersionFieldMapper;  
        SeqNoFieldMapper.NAME,
/*
        return new org.opensearch.index.mapper.DynamicTemplateTypeHandler() {
        });
        assertFalse(fieldFilter.apply(randomAlphaOfLengthBetween(3, 5)).test("hidden_field"));  
        assertTrue(registry.getDynamicFieldTypeInferencers().isEmpty());  
    public void testDuplicateTemplateTypeAcrossPluginsRejectedAtStartup() {  
    }
            public List<org.opensearch.index.mapper.DynamicFieldTypeInferencer> getDynamicFieldTypeInferencers() {
                return Collections.singletonMap(IdFieldMapper.NAME, PARSER);
        IndicesModule indicesModule = new IndicesModule(mapperPlugins);  
            public Map<String, org.opensearch.index.mapper.DynamicTemplateTypeHandler> getDynamicTemplateTypes() {
        FieldNamesFieldMapper.NAME };
import org.opensearch.index.mapper.IndexFieldMapper;  
    }
            }
        List<MapperPlugin> mapperPlugins = Arrays.asList(new MapperPlugin() {  
        String last = null;
        assertFalse(fieldFilter.apply("hidden_index").test("visible"));
            }  
 * KIND, either express or implied.  See the License for the
            return Collections.singletonMap("fake-metadata-mapper", PARSER);
            @Override
            @Override
 *
 * specific language governing permissions and limitations
import java.util.Collections;
            @Override
        IdFieldMapper.NAME,
        Set<String> builtInMetadataFields = IndicesModule.getBuiltInMetadataFields();
                return index -> index.equals("filtered") ? field -> field.equals("visible") : MapperPlugin.NOOP_FIELD_PREDICATE;
            public Function<String, Predicate<String>> getFieldFilter() {
    public void testInferencersAndTemplateTypesRegisteredFromPlugins() {
import java.util.Map;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new IndicesModule(plugins));
        IndicesModule indicesModule = new IndicesModule(mapperPlugins);
        List<MapperPlugin> plugins = Collections.singletonList(new MapperPlugin() {  
        };
    public void testBuiltinWithPlugins() {
        Function<String, Predicate<String>> fieldFilter = mapperRegistry.getFieldFilter();  
    });  
        List<MapperPlugin> plugins = Arrays.asList(new MapperPlugin() {  
import org.opensearch.index.mapper.SourceFieldMapper;
    public void testGetFieldFilter() {
        return new org.opensearch.index.mapper.DynamicFieldTypeInferencer() {  
        assertTrue(registry.getDynamicTemplateTypes().isEmpty());
    }
            public Map<String, Mapper.TypeParser> getMappers() {
 *
        });  
/*  
                return Collections.singletonMap("foo", new FakeMapperParser());
                org.opensearch.index.mapper.FieldValueParserSupplier fieldValueParser
        DocCountFieldMapper.NAME,  
    }
    public void testNoDynamicInferencersOrTemplateTypesByDefault() {
 * this work for additional information regarding copyright
        {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new IndicesModule(plugins));  
        assertThat(e.getMessage(), containsString("already registered"));  
    public void testDuplicateBuiltinMetadataMapper() {
        IndicesModule module = new IndicesModule(Collections.emptyList());  
        List<MapperPlugin> mapperPlugins = new ArrayList<>(numPlugins);
            @Override
    }  
            @Override
        for (int i = 0; i < numPlugins; i++) {  
        assertThat(
                return index -> index.equals("hidden_index") ? field -> false : MapperPlugin.NOOP_FIELD_PREDICATE;
            @Override
    }  
        List<String> fieldNames = new ArrayList<>(module.getMapperRegistry().getMetadataMapperParsers().keySet());
        Map<String, MetadataFieldMapper.TypeParser> metadataMapperParsers = module.getMapperRegistry().getMetadataMapperParsers();
            public Set<String> supportedTypes() {
        }
            @Override
        };  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new IndicesModule(plugins));
        });
    }
            return Collections.singletonMap("fake-mapper", new FakeMapperParser());
            public Map<String, Mapper.TypeParser> getMappers() {  
        }, new MapperPlugin() {  
    }  
            }
                return Collections.singletonMap(FieldNamesFieldMapper.NAME, PARSER);
    /** A no-op inferencer declaring the given supported type for registration tests. */
        }
import java.util.Set;
        List<MapperPlugin> plugins = Collections.singletonList(new MapperPlugin() {
        assertNotSame(MapperPlugin.NOOP_FIELD_PREDICATE, fieldFilter.apply("filtered"));
        });
        for (String field : builtInMetadataFields) {  
        assertFalse(fieldFilter.apply("filtered").test("hidden_field"));
            public Map<String, Mapper.TypeParser> getMappers() {
        IndicesModule module = new IndicesModule(fakePlugins);  
import org.opensearch.index.mapper.IdFieldMapper;
            @Override
        Iterator<String> iterator = metadataMapperParsers.keySet().iterator();  
            @Override
                return MapperPlugin.NOOP_FIELD_FILTER;  
        }  
                return Collections.singletonMap("foo", PARSER);
        NestedPathFieldMapper.NAME,  
        List<MapperPlugin> mapperPlugins = Arrays.asList(new MapperPlugin() {
        int i = 0;
    }
            @Override  
            assertFalse(module.getMapperRegistry().getMapperParsers().isEmpty());  
 * the Apache License, Version 2.0 (the "License"); you may
        MapperRegistry mapperRegistry = indicesModule.getMapperRegistry();
            Map<String, MetadataFieldMapper.TypeParser> metadataMapperParsers = module.getMapperRegistry().getMetadataMapperParsers();
import org.opensearch.index.mapper.TextFieldMapper;
import org.opensearch.index.mapper.DocCountFieldMapper;
 * compatible open source license.
            @Override
        assertEquals(1, registry.getDynamicFieldTypeInferencers().size());
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new IndicesModule(plugins));
        MapperRegistry registry = new IndicesModule(Collections.emptyList()).getMapperRegistry();
        }
        while (iterator.hasNext()) {  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.plugins.MapperPlugin;
 */  
        });  
import org.opensearch.index.mapper.MetadataFieldMapper;  
        };
                return Collections.singletonList(noopInferencer("my_type"));
    private static org.opensearch.index.mapper.DynamicFieldTypeInferencer noopInferencer(String supportedType) {
            }
        DataStreamFieldMapper.NAME,
            public Function<String, Predicate<String>> getFieldFilter() {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new IndicesModule(plugins));
            public List<org.opensearch.index.mapper.DynamicFieldTypeInferencer> getDynamicFieldTypeInferencers() {
import org.opensearch.index.mapper.MapperParsingException;
                return MapperPlugin.NOOP_FIELD_FILTER;
            }  
        IndicesModule module = new IndicesModule(fakePlugins);
import org.opensearch.index.mapper.Mapper;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new IndicesModule(plugins));  
            public Map<String, org.opensearch.index.mapper.DynamicTemplateTypeHandler> getDynamicTemplateTypes() {  
        IndexFieldMapper.NAME,  
        assertEquals(FieldNamesFieldMapper.NAME, fieldNames.get(fieldNames.size() - 1));
            public Function<String, Predicate<String>> getFieldFilter() {
        @Override
        MapperRegistry registry = module.getMapperRegistry();
            @Override
            }
        {  
 * You may obtain a copy of the License at  
        assertThat(e.getMessage(), containsString("already registered"));
        assertThat(e.getMessage(), containsString("declares no supported types"));
    }
    }  
    }  
            last = iterator.next();
        // The message names both colliding plugins so the misconfiguration is easy to trace.
            public Function<String, Predicate<String>> getFieldFilter() {  
        IndicesModule noPluginsModule = new IndicesModule(Collections.emptyList());  
        assertThat(e.getMessage(), containsString("cannot contain metadata mapper [_field_names]"));
        MapperPlugin plugin = new MapperPlugin() {
            }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new IndicesModule(plugins));  
 * under the License.  
 */
        SourceFieldMapper.NAME,
import org.opensearch.test.OpenSearchTestCase;  
    public void testNoOpFieldPredicate() {  
            @Override
            });
        }
        public Map<String, Mapper.TypeParser> getMappers() {
        assertThat(e.getMessage(), containsString("does not register via getMappers()"));  
                return index -> index.equals("filtered") ? field -> field.equals("visible") : MapperPlugin.NOOP_FIELD_PREDICATE;  
    public void testInferencerWithNoSupportedTypesRejectedAtStartup() {
    }
        }
 *  
        assertEquals(FieldNamesFieldMapper.NAME, fieldNames.get(fieldNames.size() - 1));
 */  
            }
            }
    public void testDuplicateOtherPluginMapper() {
            public Function<String, Predicate<String>> getFieldFilter() {
        VersionFieldMapper.NAME,
        assertTrue(fieldFilter.apply("filtered").test("visible"));  
            }  
            }
        assertNotSame(MapperPlugin.NOOP_FIELD_FILTER, fieldFilter);
            }
                return Collections.singletonMap("my_type", noopHandler());  
 * not use this file except in compliance with the License.
        List<MapperPlugin> plugins = Arrays.asList(new MapperPlugin() {
        MapperRegistry registry = new IndicesModule(plugins).getMapperRegistry();  
                return Collections.singletonMap("my_type", (name, node, parserContext) -> { throw new UnsupportedOperationException(); });
        }, new MapperPlugin() {
        }  
            }  
            @Override
        List<MapperPlugin> plugins = Arrays.asList(new MapperPlugin() {
                return Collections.singletonList(noopInferencer("unregistered_type"));
        MapperRegistry mapperRegistry = indicesModule.getMapperRegistry();
    public void testDefaultFieldFilterIsNoOp() {  
        IgnoredFieldMapper.NAME,  
                return Collections.singletonMap(TextFieldMapper.CONTENT_TYPE, new FakeMapperParser());  
        };
