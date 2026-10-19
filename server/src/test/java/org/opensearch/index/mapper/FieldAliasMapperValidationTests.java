    }
import org.opensearch.Version;
    public void testDuplicateFieldAliasAndObject() {
        String expectedMessage = "Invalid [path] value [nested.field] for field alias [alias]: "
        assertEquals(
            singletonList(aliasMapper),
    public void testAliasThatRefersToItself() {
 * Unless required by applicable law or agreed to in writing,
/*
                singletonList(invalidAlias),
        .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
 * You may obtain a copy of the License at
            MappingLookup mappers = new MappingLookup(emptyList(), emptyList(), singletonList(invalidAlias), 0, null);
            MappingLookup mappers = new MappingLookup(emptyList(), emptyList(), singletonList(invalidAlias), 0, Lucene.STANDARD_ANALYZER);
import org.opensearch.common.settings.Settings;
        alias.validate(mappers);
                Collections.singletonList(objectMapper),
            name,
 * specific language governing permissions and limitations
            )
            "Invalid [path] value [alias] for field alias [invalid-alias]: an alias" + " cannot refer to another alias.",
            ObjectMapper.Dynamic.FALSE,
        );
            emptyList(),
    }
            MapperParsingException.class,
            )
 * license agreements. See the NOTICE file distributed with
            0,
            e.getMessage()
            0,
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
            () -> new MappingLookup(
            ObjectMapper.Dynamic.FALSE,
        });
                Arrays.asList(createNestedObjectMapper("nested1"), createNestedObjectMapper("nested2")),
            name,
        return new ObjectMapper(
            SETTINGS
            name,
public class FieldAliasMapperValidationTests extends OpenSearchTestCase {
        Mapper.BuilderContext context = new Mapper.BuilderContext(SETTINGS, new ContentPath(parent));
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> {
            + "an alias must have the same nested scope as its target. The alias's nested scope is [nested2], "
        aliasMapper.validate(mappers);
            );
            + "but the target's nested scope is [nested1].";
    private static FieldMapper createFieldMapper(String parent, String name) {
            name,
        );
 * KIND, either express or implied.  See the License for the
        });
import java.util.Map;
            singletonList(createFieldMapper("object1", "field")),
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        });
    }
            singletonList(objectMapper),
import java.util.Collections;
    }
    }
    private static final Settings SETTINGS = Settings.builder()
    }
        .build();
            Lucene.STANDARD_ANALYZER
                emptyList(),
                0,
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> {
        FieldAliasMapper aliasMapper = new FieldAliasMapper("path", "some.path", "field");
                singletonList(createFieldMapper("nested1", "field")),
        FieldAliasMapper aliasMapper = new FieldAliasMapper("alias", "nested.alias", "nested.field");
    public void testFieldAliasWithNestedScope() {
    private static ObjectMapper createNestedObjectMapper(String name) {
import static java.util.Collections.emptyMap;
 *
                singletonList(aliasMapper),
        FieldAliasMapper alias = new FieldAliasMapper("alias", "alias", "field");
            Lucene.STANDARD_ANALYZER
            Arrays.asList(createObjectMapper("object1"), createObjectMapper("object2")),
        });
                singletonList(aliasMapper),
            0,
 */
        ObjectMapper objectMapper = createObjectMapper("some.path");
 * The OpenSearch Contributors require contributions made to
            singletonList(aliasMapper),
            "Invalid [path] value [non-existent] for field alias [invalid-alias]: an alias"
 * under the License.
    }
        FieldAliasMapper invalidAlias = new FieldAliasMapper("invalid-alias", "invalid-alias", "invalid-alias");
        MappingLookup mappers = new MappingLookup(
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> invalidAlias.validate(mappers));
            new Explicit<>(true, false),
                Lucene.STANDARD_ANALYZER
            ObjectMapper.Nested.NO,
            new Explicit<>(false, false),
        );
        String expectedMessage = "Invalid [path] value [nested1.field] for field alias [nested2.alias]: "
 * compatible open source license.
        FieldMapper field = new MockFieldMapper("field");
        ObjectMapper objectMapper = createNestedObjectMapper("nested");
 * Licensed to Elasticsearch under one or more contributor
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
        );
                singletonList(aliasMapper),
                Lucene.STANDARD_ANALYZER
        assertEquals(
            singletonList(createFieldMapper("nested", "field")),
            Arrays.asList(alias, invalidAlias),
        assertEquals(expectedMessage, e.getMessage());
            SETTINGS
import org.opensearch.test.OpenSearchTestCase;
            e.getMessage()
            new Explicit<>(true, false),
 *
        assertEquals(
            e.getMessage()
/*
    }
        );
        MappingLookup mappers = new MappingLookup(
        assertEquals("Alias [some.path] is defined both as an object and an alias", e.getMessage());
                singletonList(objectMapper),
            (Map<String, Mapper>) (Map<?, ?>) emptyMap(),
 * ownership. Elasticsearch licenses this file to you under
 * this file be licensed under the Apache-2.0 license or a
    public void testFieldAliasWithNestedTarget() {
    }
        return new ObjectMapper(
            invalidAlias.validate(mappers);
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Arrays;
        FieldMapper field = new MockFieldMapper("field");
            Lucene.STANDARD_ANALYZER
                Lucene.STANDARD_ANALYZER
    public void testAliasThatRefersToAlias() {
            MapperParsingException.class,
    private static ObjectMapper createObjectMapper(String name) {
        MapperParsingException e = expectThrows(
/*
        FieldAliasMapper invalidAlias = new FieldAliasMapper("invalid", "invalid", "field");
                0,
        );
 * this work for additional information regarding copyright
                singletonList(createFieldMapper("nested", "field")),
        MappingLookup mappers = new MappingLookup(
            invalidAlias.validate(mappers);
                0,
import org.opensearch.common.lucene.Lucene;
            + "an alias must have the same nested scope as its target. The alias is not nested, "
 */
                Arrays.asList(field, invalidField),
            () -> new MappingLookup(
    public void testDuplicateFieldAliasAndConcreteField() {
import org.opensearch.common.Explicit;
        );
        FieldMapper invalidField = new MockFieldMapper("invalid");
        ObjectMapper objectMapper = createNestedObjectMapper("nested");
            aliasMapper.validate(mappers);
    }
 * GitHub history for details.
        MapperParsingException e = expectThrows(
import org.opensearch.cluster.metadata.IndexMetadata;
 * software distributed under the License is distributed on an
 */
import static java.util.Collections.emptyList;
                Collections.emptyList(),
                0,
import static java.util.Collections.singletonList;
    public void testFieldAliasWithDifferentObjectScopes() {
        assertEquals(expectedMessage, e.getMessage());
        );
            new Explicit<>(false, false),
        aliasMapper.validate(mappers);
                + " must refer to an existing field in the mappings.",
 * not use this file except in compliance with the License.
        FieldAliasMapper invalidAlias = new FieldAliasMapper("invalid-alias", "invalid-alias", "alias");
        return new BooleanFieldMapper.Builder(name).build(context);
        assertEquals("Alias [invalid] is defined both as an alias and a concrete field", e.getMessage());
 * SPDX-License-Identifier: Apache-2.0
            + "but the target's nested scope is [nested].";
            MappingLookup mappers = new MappingLookup(
            ObjectMapper.Nested.newNested(),
            MappingLookup mappers = new MappingLookup(
            (Map<String, Mapper>) (Map<?, ?>) emptyMap(),
            "Invalid [path] value [invalid-alias] for field alias [invalid-alias]: an alias" + " cannot refer to itself.",
        FieldAliasMapper aliasMapper = new FieldAliasMapper("alias", "object2.alias", "object1.field");
            aliasMapper.validate(mappers);
        );
    public void testAliasWithNonExistentPath() {
    }
    public void testFieldAliasWithDifferentNestedScopes() {
        );
                Lucene.STANDARD_ANALYZER
        FieldAliasMapper aliasMapper = new FieldAliasMapper("alias", "nested2.alias", "nested1.field");
            singletonList(field),
    }
        FieldAliasMapper invalidAlias = new FieldAliasMapper("invalid-alias", "invalid-alias", "non-existent");
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
package org.opensearch.index.mapper;
            );
}
        FieldAliasMapper aliasMapper = new FieldAliasMapper("alias", "alias", "nested.field");
