        assertFalse(fieldFilter.apply(randomAlphaOfLengthBetween(3, 5)).test("hidden_field"));
    }
        RoutingFieldMapper.NAME,
        assertSame(MapperPlugin.NOOP_FIELD_FILTER, fieldFilter);
                return index -> field -> field.equals("hidden_field") == false;
        List<MapperPlugin> mapperPlugins = Arrays.asList(new MapperPlugin() {
        for (int i = 0; i < numPlugins; i++) {
 * You may obtain a copy of the License at
        }
            @Override
                org.opensearch.index.mapper.FieldValueParserSupplier fieldValueParser
import org.opensearch.index.mapper.NestedPathFieldMapper;
    public void testFieldNamesIsLastWithPlugins() {
        assertEquals(FieldNamesFieldMapper.NAME, last);
                return index -> index.equals("hidden_index") ? field -> false : MapperPlugin.NOOP_FIELD_PREDICATE;
            }
    public void testDefaultFieldFilterIsNoOp() {
    public void testBuiltinMappers() {
        NestedPathFieldMapper.NAME,
 * Unless required by applicable law or agreed to in writing,
                return Collections.singletonMap("dup_type", noopHandler());
import static org.hamcrest.Matchers.greaterThan;
            public Function<String, Predicate<String>> getFieldFilter() {
        assertThat(e.getMessage(), containsString("does not register via getMappers()"));
        IndexFieldMapper.NAME,
            Map<String, MetadataFieldMapper.TypeParser> metadataMapperParsers = module.getMapperRegistry().getMetadataMapperParsers();
    private static class FakeMapperParser implements Mapper.TypeParser {
/*
                return Collections.singletonMap("my_type", (name, node, parserContext) -> { throw new UnsupportedOperationException(); });
        MapperRegistry mapperRegistry = indicesModule.getMapperRegistry();
            public Map<String, MetadataFieldMapper.TypeParser> getMetadataMappers() {
    }
                Map<String, Object> mappingConfig,
            }
import org.opensearch.plugins.MapperPlugin;
            assertEquals(EXPECTED_METADATA_FIELDS.length, module.getMapperRegistry().getMetadataMapperParsers().size());
        IgnoredFieldMapper.NAME,
import org.opensearch.indices.mapper.MapperRegistry;
    public void testDuplicateBuiltinMetadataMapper() {
            public Map<String, org.opensearch.index.mapper.DynamicTemplateTypeHandler> getDynamicTemplateTypes() {
        assertTrue(registry.getDynamicFieldTypeInferencers().isEmpty());
        assertThat(e.getMessage(), containsString("already registered"));
        }
    }
            });
    public void testFieldNamesIsLast() {
                return index -> index.equals("filtered") ? field -> field.equals("visible") : MapperPlugin.NOOP_FIELD_PREDICATE;
            assertFalse(module.getMapperRegistry().getMapperParsers().isEmpty());
                return index -> index.equals("hidden_index") ? field -> false : MapperPlugin.NOOP_FIELD_PREDICATE;
 * not use this file except in compliance with the License.
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new IndicesModule(plugins));
        List<MapperPlugin> plugins = Collections.singletonList(new MapperPlugin() {
 */
    public void testNoDynamicInferencersOrTemplateTypesByDefault() {
            public Map<String, org.opensearch.index.mapper.DynamicTemplateTypeHandler> getDynamicTemplateTypes() {
                return Collections.singletonMap("foo", new FakeMapperParser());
                return MapperPlugin.NOOP_FIELD_FILTER;
 * The OpenSearch Contributors require contributions made to
            }
                return Collections.singletonMap("foo", PARSER);
    }
        });
        assertTrue(registry.getDynamicTemplateTypes().containsKey("my_type"));
 * GitHub history for details.
        }
            }
            }
        assertTrue(fieldFilter.apply("filtered").test("visible"));
        assertFalse(fieldFilter.apply("filtered").test(randomAlphaOfLengthBetween(3, 5)));
        List<String> fieldNames = new ArrayList<>(module.getMapperRegistry().getMetadataMapperParsers().keySet());
    /** A no-op inferencer declaring the given supported type for registration tests. */
public class IndicesModuleTests extends OpenSearchTestCase {
        List<MapperPlugin> plugins = Arrays.asList(new MapperPlugin() {
        });
/*
        FieldNamesFieldMapper.NAME };
            public List<org.opensearch.index.mapper.DynamicFieldTypeInferencer> getDynamicFieldTypeInferencers() {
        public Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {
    public void testBuiltinWithPlugins() {
        assertSame(MapperPlugin.NOOP_FIELD_PREDICATE, fieldFilter.apply(randomAlphaOfLengthBetween(3, 7)));
        }, new MapperPlugin() {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new IndicesModule(plugins));
        List<MapperPlugin> mapperPlugins = new ArrayList<>(numPlugins);
import java.util.function.Function;
            @Override
        IndicesModule module = new IndicesModule(fakePlugins);
 * specific language governing permissions and limitations
        assertFalse(fieldFilter.apply("filtered").test("hidden_field"));
import org.opensearch.index.mapper.DataStreamFieldMapper;
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.index.mapper.Mapper;
import java.util.List;
    private static org.opensearch.index.mapper.DynamicTemplateTypeHandler noopHandler() {
        @Override
            @Override
            @Override
import java.util.Iterator;
        IndicesModule module = new IndicesModule(fakePlugins);
        MapperRegistry mapperRegistry = indicesModule.getMapperRegistry();
 * this file be licensed under the Apache-2.0 license or a
        IdFieldMapper.NAME,
 * the Apache License, Version 2.0 (the "License"); you may
                return Collections.singletonMap(FieldNamesFieldMapper.NAME, PARSER);
            return null;
        IndicesModule indicesModule = new IndicesModule(mapperPlugins);
            return Collections.singletonMap("fake-metadata-mapper", PARSER);
        Function<String, Predicate<String>> fieldFilter = mapperRegistry.getFieldFilter();
            }
}
            @Override
        }
        Function<String, Predicate<String>> fieldFilter = indicesModule.getMapperRegistry().getFieldFilter();
    }
        assertTrue(fieldFilter.apply(randomAlphaOfLengthBetween(3, 5)).test("visible"));
            }
    public void testInferencersAndTemplateTypesRegisteredFromPlugins() {
    private static org.opensearch.index.mapper.DynamicFieldTypeInferencer noopInferencer(String supportedType) {
        {
        MapperRegistry registry = new IndicesModule(plugins).getMapperRegistry();
                assertEquals(EXPECTED_METADATA_FIELDS[i++], field);
            public Map<String, Mapper.TypeParser> getMappers() {
        }, new MapperPlugin() {
        }, new MapperPlugin() {
 * SPDX-License-Identifier: Apache-2.0
        }
            public Function<String, Predicate<String>> getFieldFilter() {
            }
        assertEquals(1, registry.getDynamicFieldTypeInferencers().size());
        };
                // Default supportedTypes() is empty — a configuration error.
    }
    public void testDuplicateOtherPluginMetadataMapper() {
 * license agreements. See the NOTICE file distributed with
            @Override
import org.opensearch.index.mapper.RoutingFieldMapper;
        };
import static org.hamcrest.Matchers.containsString;
            public Function<String, Predicate<String>> getFieldFilter() {
            @Override
        assertEquals(FieldNamesFieldMapper.NAME, fieldNames.get(fieldNames.size() - 1));
import java.util.Map;
            @Override
        IndicesModule noPluginsModule = new IndicesModule(Collections.emptyList());
        return new org.opensearch.index.mapper.DynamicFieldTypeInferencer() {
    public void testNoOpFieldPredicate() {
            @Override
import java.util.ArrayList;
            public Map<String, Mapper.TypeParser> getMappers() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            for (String field : metadataMapperParsers.keySet()) {
    }
        });
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new IndicesModule(plugins));
import org.opensearch.index.mapper.IdFieldMapper;
    }
    }
    public void testInferencerWithNoSupportedTypesRejectedAtStartup() {
            @Override
            public List<org.opensearch.index.mapper.DynamicFieldTypeInferencer> getDynamicFieldTypeInferencers() {
            public Map<String, Object> inferFieldType(org.opensearch.index.mapper.FieldValueParserSupplier fieldValueParser) {
        Iterator<String> iterator = metadataMapperParsers.keySet().iterator();
import org.opensearch.index.mapper.SourceFieldMapper;
import org.opensearch.index.mapper.VersionFieldMapper;
        });
            ) {}
            int i = 0;
import org.opensearch.index.mapper.MetadataFieldMapper;
                return MapperPlugin.NOOP_FIELD_FILTER;
                return null;
        assertNotSame(MapperPlugin.NOOP_FIELD_PREDICATE, fieldFilter.apply("filtered"));
        assertFalse(fieldFilter.apply("hidden_index").test("visible"));
 */
        IndicesModule module = new IndicesModule(Collections.emptyList());
        List<MapperPlugin> plugins = Arrays.asList(new MapperPlugin() {
    public void testDuplicateOtherPluginMapper() {
 */
import org.opensearch.index.mapper.FieldNamesFieldMapper;
            @Override
        assertThat(e.getMessage(), containsString("already registered"));
            public Map<String, MetadataFieldMapper.TypeParser> getMetadataMappers() {
        public Map<String, MetadataFieldMapper.TypeParser> getMetadataMappers() {
            @Override
        int i = 0;
            }
            }
        assertThat(e.getMessage(), containsString("cannot contain metadata mapper [_field_names]"));
                return Collections.singletonList(noopInferencer("unregistered_type"));
        int numPlugins = randomIntBetween(0, 10);
        Function<String, Predicate<String>> fieldFilter = mapperRegistry.getFieldFilter();
        List<String> fieldNames = new ArrayList<>(module.getMapperRegistry().getMetadataMapperParsers().keySet());
        MapperRegistry registry = module.getMapperRegistry();
            @Override
                // Declares a supported type the plugin does not register via getMappers().
        });
        MapperPlugin plugin = new MapperPlugin() {
 * this work for additional information regarding copyright
            }
        List<MapperPlugin> plugins = Arrays.asList(new MapperPlugin() {
import java.util.function.Predicate;
            @Override
        IndicesModule indicesModule = new IndicesModule(mapperPlugins);
        }, new MapperPlugin() {
            }
            }
                return Collections.singletonMap("dup_type", noopHandler());
        return new org.opensearch.index.mapper.DynamicTemplateTypeHandler() {
        MapperPlugin plugin = new MapperPlugin() {
    private static String[] EXPECTED_METADATA_FIELDS = new String[] {
        MapperRegistry registry = new IndicesModule(Collections.emptyList()).getMapperRegistry();
            return Collections.singletonMap("fake-mapper", new FakeMapperParser());
/*
        // The message names both colliding plugins so the misconfiguration is easy to trace.
package org.opensearch.indices;
 *     http://www.apache.org/licenses/LICENSE-2.0
        List<MapperPlugin> plugins = Collections.singletonList(new MapperPlugin() {
            greaterThan(noPluginsModule.getMapperRegistry().getMetadataMapperParsers().size())
            @Override
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new IndicesModule(plugins));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new IndicesModule(plugins));
                return Collections.singletonMap("my_type", noopHandler());
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new IndicesModule(plugins));
        List<MapperPlugin> plugins = Arrays.asList(plugin, plugin);
        DataStreamFieldMapper.NAME,
    });
        public Map<String, Mapper.TypeParser> getMappers() {
            public Map<String, Mapper.TypeParser> getMappers() {
        assertThat(e.getMessage(), containsString(plugins.get(1).getClass().getName()));
    private final List<MapperPlugin> fakePlugins = Arrays.asList(new MapperPlugin() {
        {
    }
import org.opensearch.index.mapper.IgnoredFieldMapper;
        });
            }
        for (String field : builtInMetadataFields) {
        List<MapperPlugin> mapperPlugins = Arrays.asList(new MapperPlugin() {
            public Function<String, Predicate<String>> getFieldFilter() {
            @Override
        @Override
            }
        List<MapperPlugin> plugins = Arrays.asList(plugin, plugin);
import java.util.Collections;
        @Override
            }
import java.util.Set;
    }
            }
            assertEquals(EXPECTED_METADATA_FIELDS.length, metadataMapperParsers.size());
            }
    }
        assertTrue(registry.getDynamicTemplateTypes().isEmpty());
import java.util.Arrays;
        });
    }
            public Function<String, Predicate<String>> getFieldFilter() {
        assertThat(e.getMessage(), containsString("already registered"));
        }, new MapperPlugin() {
 *
            mapperPlugins.add(new MapperPlugin() {
    public void testGetFieldFilter() {
 * under the License.
        assertThat(registry.getMapperParsers().size(), greaterThan(noPluginsModule.getMapperRegistry().getMapperParsers().size()));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new IndicesModule(plugins));
 *
        assertEquals(IgnoredFieldMapper.NAME, iterator.next());
    }
import org.opensearch.index.mapper.SeqNoFieldMapper;
        );
        assertThat(
    public void testInferencerSupportedTypeNotRegisteredRejectedAtStartup() {
            public Function<String, Predicate<String>> getFieldFilter() {
 * KIND, either express or implied.  See the License for the
            @Override
        }, new MapperPlugin() {
            }
        assertThat(e.getMessage(), containsString("already registered"));
        String last = null;
            public Function<String, Predicate<String>> getFieldFilter() {
            @Override
        };
                return Collections.singletonList(fieldValueParser -> null);
        assertThat(e.getMessage(), containsString("dynamic template type [dup_type] is registered by both"));
            public Map<String, org.opensearch.index.mapper.DynamicTemplateTypeHandler> getDynamicTemplateTypes() {
            public Set<String> supportedTypes() {
            last = iterator.next();
        assertTrue(fieldFilter.apply(randomAlphaOfLengthBetween(3, 5)).test(randomAlphaOfLengthBetween(3, 5)));
        Set<String> builtInMetadataFields = IndicesModule.getBuiltInMetadataFields();
        assertEquals(FieldNamesFieldMapper.NAME, fieldNames.get(fieldNames.size() - 1));
            @Override
            @Override
            registry.getMetadataMapperParsers().size(),
    private static final MetadataFieldMapper.TypeParser PARSER = new MetadataFieldMapper.ConfigurableTypeParser(c -> null, c -> null);
        });
        assertThat(e.getMessage(), containsString(plugins.get(0).getClass().getName()));
        });
    }
        }
        List<MapperPlugin> plugins = Collections.singletonList(new MapperPlugin() {
    }
        assertFalse(fieldFilter.apply("hidden_index").test("hidden_field"));
    }
 * software distributed under the License is distributed on an
        assertFalse(fieldFilter.apply("hidden_index").test(randomAlphaOfLengthBetween(3, 5)));
        assertNotSame(MapperPlugin.NOOP_FIELD_FILTER, fieldFilter);
                return Collections.singletonList(noopInferencer("my_type"));
        }
            @Override
                return Collections.singletonMap(IdFieldMapper.NAME, PARSER);
                return index -> index.equals("filtered") ? field -> field.equals("visible") : MapperPlugin.NOOP_FIELD_PREDICATE;
import org.opensearch.index.mapper.TextFieldMapper;
        IndicesModule indicesModule = new IndicesModule(mapperPlugins);
import org.opensearch.index.mapper.DocCountFieldMapper;
    }
        SeqNoFieldMapper.NAME,
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new IndicesModule(plugins));
    public void testDuplicateFieldNamesMapper() {
            public Map<String, MetadataFieldMapper.TypeParser> getMetadataMappers() {
            public List<org.opensearch.index.mapper.DynamicFieldTypeInferencer> getDynamicFieldTypeInferencers() {
                return Collections.singleton(supportedType);
        Map<String, MetadataFieldMapper.TypeParser> metadataMapperParsers = module.getMapperRegistry().getMetadataMapperParsers();
        assertThat(e.getMessage(), containsString("declares supported type [unregistered_type]"));
            }
import org.opensearch.index.mapper.IndexFieldMapper;
        assertNotSame(MapperPlugin.NOOP_FIELD_PREDICATE, fieldFilter.apply("hidden_index"));
import org.opensearch.index.mapper.MapperParsingException;
 * compatible open source license.
                return Collections.singletonMap(TextFieldMapper.CONTENT_TYPE, new FakeMapperParser());
        VersionFieldMapper.NAME,
            assertFalse(module.getMapperRegistry().getMetadataMapperParsers().isEmpty());
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor
    public void testGetBuiltInMetadataFields() {
        assertThat(e.getMessage(), containsString("declares no supported types"));
        }
        List<MapperPlugin> plugins = Arrays.asList(new MapperPlugin() {
        while (iterator.hasNext()) {
import org.opensearch.test.OpenSearchTestCase;
        SourceFieldMapper.NAME,
        IndicesModule module = new IndicesModule(Collections.emptyList());
 *
        };
            }
        DocCountFieldMapper.NAME,
            assertEquals(EXPECTED_METADATA_FIELDS[i++], field);
    /** A no-op dynamic template type handler for registration tests. */
    }
            public void adjustMappingConfig(
    }
            @Override
            }
    public void testDuplicateBuiltinMapper() {
    public void testDuplicateTemplateTypeAcrossPluginsRejectedAtStartup() {
