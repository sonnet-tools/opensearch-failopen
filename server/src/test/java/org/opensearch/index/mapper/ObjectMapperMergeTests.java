        // THEN "baz" new field is added to merged mapping
        if (includeBazField) {  
        ObjectMapper mergeWith = createMapping(false, true, true, true);  
        final ObjectMapper mergedFoo = (ObjectMapper) merged.getMapper("foo");  
        assertEquals("the [enabled] parameter can't be updated for the object mapping [" + type + "]", e.getMessage());
        // WHEN merging mappings
        assertFalse(result.isEnabled());
 * ownership. Elasticsearch licenses this file to you under  
    private static ObjectMapper createNestedMapper(String name, ObjectMapper.Nested nested) {
        String type = MapperService.SINGLE_MAPPING_NAME;
import org.opensearch.test.OpenSearchTestCase;  
        // GIVEN an enriched mapping with "baz" new field
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.Matchers.notNullValue;  
 * Licensed to Elasticsearch under one or more contributor  
        final ObjectMapper mapper = new ObjectMapper.Builder<>(name).enabled(enabled).build(context);  
        }
        assertEquals("the [enabled] parameter can't be updated for the object mapping [disabled]", e.getMessage());
        ObjectMapper firstMapper = createRootObjectMapper(type, true, Collections.emptyMap());  
        assertEquals("the [enabled] parameter can't be updated for the object mapping [foo]", e.getMessage());  
import java.util.Collections;
        return createRootObjectMapper("type1", true, Collections.unmodifiableMap(mappers));
import java.util.Map;
        Map<String, Mapper> mappers = new HashMap<>();  
    private final RootObjectMapper rootObjectMapper = createMapping(false, true, true, false);
import org.opensearch.common.Explicit;
        final Mapper.BuilderContext context = new Mapper.BuilderContext(indexSettings, new ContentPath());  
        String type = MapperService.SINGLE_MAPPING_NAME;
package org.opensearch.index.mapper;
    public void testMerge() {
        ObjectMapper result = firstMapper.merge(secondMapper, MapperService.MergeReason.INDEX_TEMPLATE);  
        boolean includeBarField,  
        ObjectMapper mergeWith = createMapping(false, false, false, false);
 */
            fooMappers.put("baz", bazFieldMapper);
        ObjectMapper result = firstMapper.merge(secondMapper, MapperService.MergeReason.INDEX_TEMPLATE);  
        final ObjectMapper merged = rootObjectMapper.merge(mergeWith);  
        final Settings indexSettings = Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT).build();
 * The OpenSearch Contributors require contributions made to  
        final RootObjectMapper rootObjectMapper = new RootObjectMapper.Builder(name).enabled(enabled).build(context);
        mappers.put("disabled", createObjectMapper("disabled", disabledFieldEnabled, emptyMap()));
        ObjectMapper result = rootObjectMapper.merge(mergeWith, MapperService.MergeReason.INDEX_TEMPLATE);  
            type,
        boolean disabledFieldEnabled,
        ObjectMapper secondMapper = createNestedMapper(
        final Mapper.BuilderContext context = new Mapper.BuilderContext(indexSettings, new ContentPath());
}  
    }
    public void testMergeEnabledForRootMapper() {
        return new TextFieldMapper.Builder(name, createDefaultIndexAnalyzers()).build(context);
        assertTrue(result.nested().isIncludeInRoot());
 * GitHub history for details.
        final Settings indexSettings = Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT).build();
 * SPDX-License-Identifier: Apache-2.0
    }  
        mappers.values().forEach(mapper::putMapper);
import static org.hamcrest.Matchers.containsString;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
    private TextFieldMapper createTextFieldMapper(String name) {
import java.util.HashMap;  
        MapperException e = expectThrows(MapperException.class, () -> firstMapper.merge(secondMapper));  
        Map<String, Mapper> fooMappers = new HashMap<>();
    }  
 *
    private static RootObjectMapper createRootObjectMapper(String name, boolean enabled, Map<String, Mapper> mappers) {
            type,
 */
        return rootObjectMapper;  
        // GIVEN a mapping with "foo" field disabled  
    ) {
        );
        mappers.values().forEach(rootObjectMapper::putMapper);
 * this file be licensed under the Apache-2.0 license or a
            ObjectMapper.Nested.newNested(new Explicit<>(false, true), new Explicit<>(false, false))  
    }
    private final FieldMapper bazFieldMapper = createTextFieldMapper("baz");
 * Unless required by applicable law or agreed to in writing,
            fooMappers.put("bar", barFieldMapper);
 *  
 * license agreements. See the NOTICE file distributed with
        assertFalse(result.nested().isIncludeInParent());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private RootObjectMapper createMapping(  
import org.opensearch.Version;  
        );  
        ObjectMapper secondMapper = createRootObjectMapper(type, false, Collections.emptyMap());
 * not use this file except in compliance with the License.
 *
 * specific language governing permissions and limitations
import org.opensearch.common.settings.Settings;
        assertThat(mergedFoo.getMapper("bar"), notNullValue());
    }
    }
/*
    }
            ObjectMapper.Nested.newNested(new Explicit<>(true, true), new Explicit<>(true, true))
        final Settings indexSettings = Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT).build();  
        return new ObjectMapper.Builder<>(name).nested(nested).build(context);
 * You may obtain a copy of the License at  
 */  
        MapperException e = expectThrows(MapperException.class, () -> rootObjectMapper.merge(mergeWith));
        mappers.put("foo", createObjectMapper("foo", fooFieldEnabled, Collections.unmodifiableMap(fooMappers)));  
        ObjectMapper firstMapper = createNestedMapper(  
    public void testMergeNested() {
        assertTrue(result.isEnabled());
 * software distributed under the License is distributed on an
        boolean fooFieldEnabled,
        // WHEN merging mappings  
 * this work for additional information regarding copyright
/*
    private static ObjectMapper createObjectMapper(String name, boolean enabled, Map<String, Mapper> mappers) {  
        ObjectMapper mergeWith = createMapping(true, true, true, false);
 * under the License.  
        final Settings indexSettings = Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT).build();
        MapperException e = expectThrows(MapperException.class, () -> rootObjectMapper.merge(mergeWith));  
        boolean includeBazField
    public void testMergeEnabled() {  
        MapperException e = expectThrows(MapperException.class, () -> firstMapper.merge(secondMapper));  
import static java.util.Collections.emptyMap;  
        assertThat(e.getMessage(), containsString("[include_in_parent] parameter can't be updated on a nested object mapping"));
        if (includeBarField) {  
/*  
    }
        // THEN a MapperException is thrown with an excepted message
    }
        return mapper;
    public void testMergeWhenDisablingField() {
        final Mapper.BuilderContext context = new Mapper.BuilderContext(indexSettings, new ContentPath());  
 * Modifications Copyright OpenSearch Contributors. See  
    }
    private final FieldMapper barFieldMapper = createTextFieldMapper("bar");
 * KIND, either express or implied.  See the License for the
        final Mapper.BuilderContext context = new Mapper.BuilderContext(indexSettings, new ContentPath());
        assertThat(mergedFoo.getMapper("baz"), notNullValue());
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
public class ObjectMapperMergeTests extends OpenSearchTestCase {
        }
