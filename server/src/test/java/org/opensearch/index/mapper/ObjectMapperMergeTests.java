        // THEN a MapperException is thrown with an excepted message
        if (includeBazField) {
        );
        MapperException e = expectThrows(MapperException.class, () -> rootObjectMapper.merge(mergeWith));
    }
        );
import java.util.HashMap;
        assertThat(mergedFoo.getMapper("bar"), notNullValue());
        assertTrue(result.nested().isIncludeInRoot());
        final Mapper.BuilderContext context = new Mapper.BuilderContext(indexSettings, new ContentPath());
        String type = MapperService.SINGLE_MAPPING_NAME;
        // GIVEN an enriched mapping with "baz" new field
/*
        Map<String, Mapper> mappers = new HashMap<>();
 * not use this file except in compliance with the License.
    }
            ObjectMapper.Nested.newNested(new Explicit<>(false, true), new Explicit<>(false, false))
            ObjectMapper.Nested.newNested(new Explicit<>(true, true), new Explicit<>(true, true))
    public void testMergeNested() {
 *
    public void testMerge() {
        final ObjectMapper mergedFoo = (ObjectMapper) merged.getMapper("foo");
    }
        }
 * specific language governing permissions and limitations
    private static ObjectMapper createNestedMapper(String name, ObjectMapper.Nested nested) {
import static org.hamcrest.Matchers.notNullValue;
        ObjectMapper result = rootObjectMapper.merge(mergeWith, MapperService.MergeReason.INDEX_TEMPLATE);
        return rootObjectMapper;
 * SPDX-License-Identifier: Apache-2.0
        return mapper;
        assertEquals("the [enabled] parameter can't be updated for the object mapping [foo]", e.getMessage());
            type,
 * Unless required by applicable law or agreed to in writing,
        assertFalse(result.nested().isIncludeInParent());
import org.opensearch.test.OpenSearchTestCase;
        MapperException e = expectThrows(MapperException.class, () -> firstMapper.merge(secondMapper));
        final Mapper.BuilderContext context = new Mapper.BuilderContext(indexSettings, new ContentPath());
import java.util.Collections;
        mappers.values().forEach(mapper::putMapper);
import org.opensearch.common.Explicit;
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
        final ObjectMapper merged = rootObjectMapper.merge(mergeWith);
 * Licensed to Elasticsearch under one or more contributor
        // GIVEN a mapping with "foo" field disabled
 * software distributed under the License is distributed on an
import static org.hamcrest.Matchers.containsString;
 * under the License.
        assertEquals("the [enabled] parameter can't be updated for the object mapping [" + type + "]", e.getMessage());
    public void testMergeEnabledForRootMapper() {
        final Settings indexSettings = Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT).build();
        ObjectMapper mergeWith = createMapping(true, true, true, false);
        final RootObjectMapper rootObjectMapper = new RootObjectMapper.Builder(name).enabled(enabled).build(context);
 * The OpenSearch Contributors require contributions made to
        ObjectMapper mergeWith = createMapping(false, true, true, true);
        boolean fooFieldEnabled,
        return createRootObjectMapper("type1", true, Collections.unmodifiableMap(mappers));
    private final RootObjectMapper rootObjectMapper = createMapping(false, true, true, false);
            type,
        ObjectMapper result = firstMapper.merge(secondMapper, MapperService.MergeReason.INDEX_TEMPLATE);
 * license agreements. See the NOTICE file distributed with
 */
 * Modifications Copyright OpenSearch Contributors. See
 *
 * this file be licensed under the Apache-2.0 license or a
    }
 * the Apache License, Version 2.0 (the "License"); you may
        mappers.put("disabled", createObjectMapper("disabled", disabledFieldEnabled, emptyMap()));
        assertFalse(result.isEnabled());
        mappers.values().forEach(rootObjectMapper::putMapper);
        assertThat(mergedFoo.getMapper("baz"), notNullValue());
        ObjectMapper result = firstMapper.merge(secondMapper, MapperService.MergeReason.INDEX_TEMPLATE);
    }
        return new ObjectMapper.Builder<>(name).nested(nested).build(context);
}
        MapperException e = expectThrows(MapperException.class, () -> firstMapper.merge(secondMapper));
        ObjectMapper firstMapper = createNestedMapper(
        Map<String, Mapper> fooMappers = new HashMap<>();
    private final FieldMapper bazFieldMapper = createTextFieldMapper("baz");
        if (includeBarField) {
    public void testMergeEnabled() {
    ) {
/*
        assertTrue(result.isEnabled());
import org.opensearch.Version;
        // WHEN merging mappings
        String type = MapperService.SINGLE_MAPPING_NAME;
    }
        // WHEN merging mappings
    private final FieldMapper barFieldMapper = createTextFieldMapper("bar");
        boolean includeBarField,
        final Mapper.BuilderContext context = new Mapper.BuilderContext(indexSettings, new ContentPath());
 * KIND, either express or implied.  See the License for the
    }
        boolean disabledFieldEnabled,
        boolean includeBazField
        final Settings indexSettings = Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT).build();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
        assertThat(e.getMessage(), containsString("[include_in_parent] parameter can't be updated on a nested object mapping"));
        final Settings indexSettings = Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT).build();
import static java.util.Collections.emptyMap;
    private static RootObjectMapper createRootObjectMapper(String name, boolean enabled, Map<String, Mapper> mappers) {
    }
        mappers.put("foo", createObjectMapper("foo", fooFieldEnabled, Collections.unmodifiableMap(fooMappers)));
        }
        final ObjectMapper mapper = new ObjectMapper.Builder<>(name).enabled(enabled).build(context);
    }
public class ObjectMapperMergeTests extends OpenSearchTestCase {
        assertEquals("the [enabled] parameter can't be updated for the object mapping [disabled]", e.getMessage());
 * You may obtain a copy of the License at
import org.opensearch.common.settings.Settings;
        final Settings indexSettings = Settings.builder().put(SETTING_VERSION_CREATED, Version.CURRENT).build();
 *
        ObjectMapper firstMapper = createRootObjectMapper(type, true, Collections.emptyMap());
/*
    private TextFieldMapper createTextFieldMapper(String name) {
import java.util.Map;
 */
    private RootObjectMapper createMapping(
    private static ObjectMapper createObjectMapper(String name, boolean enabled, Map<String, Mapper> mappers) {
        // THEN "baz" new field is added to merged mapping
    public void testMergeWhenDisablingField() {
        return new TextFieldMapper.Builder(name, createDefaultIndexAnalyzers()).build(context);
 */
        MapperException e = expectThrows(MapperException.class, () -> rootObjectMapper.merge(mergeWith));
        final Mapper.BuilderContext context = new Mapper.BuilderContext(indexSettings, new ContentPath());
        ObjectMapper mergeWith = createMapping(false, false, false, false);
        ObjectMapper secondMapper = createRootObjectMapper(type, false, Collections.emptyMap());
            fooMappers.put("bar", barFieldMapper);
            fooMappers.put("baz", bazFieldMapper);
package org.opensearch.index.mapper;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * GitHub history for details.
        ObjectMapper secondMapper = createNestedMapper(
