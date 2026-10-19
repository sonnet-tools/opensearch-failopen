            + "an alias must have the same nested scope as its target. The alias's nested scope is [nested2], "  
            emptyList(),  
    public void testFieldAliasWithDifferentObjectScopes() {
        );  
        MappingLookup mappers = new MappingLookup(  
            new Explicit<>(false, false),
            new Explicit<>(false, false),  
            name,
    }
        );
                singletonList(aliasMapper),
        assertEquals(expectedMessage, e.getMessage());
import org.opensearch.common.Explicit;
                singletonList(createFieldMapper("nested", "field")),  
 *
/*
 * GitHub history for details.
                Lucene.STANDARD_ANALYZER
/*
        ObjectMapper objectMapper = createNestedObjectMapper("nested");  
            invalidAlias.validate(mappers);
            singletonList(createFieldMapper("nested", "field")),
        );
 * You may obtain a copy of the License at  
        );  
    }  
    public void testAliasThatRefersToItself() {  
            aliasMapper.validate(mappers);
        FieldAliasMapper invalidAlias = new FieldAliasMapper("invalid", "invalid", "field");
 * under the License.  
            SETTINGS
    public void testFieldAliasWithNestedTarget() {  
 *
        FieldAliasMapper alias = new FieldAliasMapper("alias", "alias", "field");
import org.opensearch.common.settings.Settings;
            ObjectMapper.Nested.NO,
                + " must refer to an existing field in the mappings.",  
            ObjectMapper.Dynamic.FALSE,  
 * not use this file except in compliance with the License.
            0,
            MappingLookup mappers = new MappingLookup(emptyList(), emptyList(), singletonList(invalidAlias), 0, Lucene.STANDARD_ANALYZER);  
    private static final Settings SETTINGS = Settings.builder()
import org.opensearch.test.OpenSearchTestCase;
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;  
            singletonList(aliasMapper),  
            );
        );
 */  
        });
                0,  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
    }  
            "Invalid [path] value [invalid-alias] for field alias [invalid-alias]: an alias" + " cannot refer to itself.",  
import static java.util.Collections.singletonList;
 * specific language governing permissions and limitations
            singletonList(objectMapper),
    }  
    }
 * Licensed to Elasticsearch under one or more contributor  
        FieldAliasMapper aliasMapper = new FieldAliasMapper("alias", "alias", "nested.field");
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {  
    private static FieldMapper createFieldMapper(String parent, String name) {  
            singletonList(createFieldMapper("object1", "field")),  
        assertEquals("Alias [invalid] is defined both as an alias and a concrete field", e.getMessage());
            Lucene.STANDARD_ANALYZER
                Arrays.asList(field, invalidField),  
        .build();
                singletonList(aliasMapper),
                singletonList(aliasMapper),
    private static ObjectMapper createNestedObjectMapper(String name) {  
            0,  
 * Modifications Copyright OpenSearch Contributors. See  
        FieldMapper field = new MockFieldMapper("field");
 * ownership. Elasticsearch licenses this file to you under  
        MappingLookup mappers = new MappingLookup(
        MappingLookup mappers = new MappingLookup(
        String expectedMessage = "Invalid [path] value [nested.field] for field alias [alias]: "  
    }
                singletonList(objectMapper),
            MappingLookup mappers = new MappingLookup(emptyList(), emptyList(), singletonList(invalidAlias), 0, null);
            MappingLookup mappers = new MappingLookup(
            ObjectMapper.Nested.newNested(),
package org.opensearch.index.mapper;
            aliasMapper.validate(mappers);  
            (Map<String, Mapper>) (Map<?, ?>) emptyMap(),
        });  
            MappingLookup mappers = new MappingLookup(
            new Explicit<>(true, false),  
        ObjectMapper objectMapper = createObjectMapper("some.path");  
            e.getMessage()
        assertEquals(
            name,  
 * this work for additional information regarding copyright
            "Invalid [path] value [non-existent] for field alias [invalid-alias]: an alias"
        );
                Collections.emptyList(),  
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> {
                0,
import java.util.Arrays;
            e.getMessage()
            singletonList(field),
            )
            );
    }  
 * the Apache License, Version 2.0 (the "License"); you may
                singletonList(createFieldMapper("nested1", "field")),
        );  
    }
        FieldAliasMapper invalidAlias = new FieldAliasMapper("invalid-alias", "invalid-alias", "alias");
        FieldAliasMapper aliasMapper = new FieldAliasMapper("alias", "object2.alias", "object1.field");  
        Mapper.BuilderContext context = new Mapper.BuilderContext(SETTINGS, new ContentPath(parent));
            )
        assertEquals(  
            SETTINGS  
            Lucene.STANDARD_ANALYZER  
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> invalidAlias.validate(mappers));
        alias.validate(mappers);
                Lucene.STANDARD_ANALYZER
import org.opensearch.Version;  
            Lucene.STANDARD_ANALYZER
}  
        ObjectMapper objectMapper = createNestedObjectMapper("nested");
                Lucene.STANDARD_ANALYZER  
        });
    }
 */
 *  
            Arrays.asList(alias, invalidAlias),
 * compatible open source license.
        assertEquals(expectedMessage, e.getMessage());  
        .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)  
 * software distributed under the License is distributed on an
                Arrays.asList(createNestedObjectMapper("nested1"), createNestedObjectMapper("nested2")),  
    }  
import org.opensearch.common.lucene.Lucene;  
            (Map<String, Mapper>) (Map<?, ?>) emptyMap(),
        MapperParsingException e = expectThrows(  
public class FieldAliasMapperValidationTests extends OpenSearchTestCase {  
        return new ObjectMapper(
            new Explicit<>(true, false),
    }
            + "an alias must have the same nested scope as its target. The alias is not nested, "
            ObjectMapper.Dynamic.FALSE,
 * KIND, either express or implied.  See the License for the
import static java.util.Collections.emptyMap;  
        FieldAliasMapper aliasMapper = new FieldAliasMapper("alias", "nested2.alias", "nested1.field");
import org.opensearch.cluster.metadata.IndexMetadata;
            + "but the target's nested scope is [nested].";
    }
        });  
            e.getMessage()
        FieldMapper field = new MockFieldMapper("field");  
            () -> new MappingLookup(
 */
    public void testFieldAliasWithNestedScope() {
                0,  
import static java.util.Collections.emptyList;
                emptyList(),
            invalidAlias.validate(mappers);
            name,
 * Unless required by applicable law or agreed to in writing,
                Lucene.STANDARD_ANALYZER
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> {  
/*  
        MapperParsingException e = expectThrows(  
 * license agreements. See the NOTICE file distributed with
        aliasMapper.validate(mappers);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            singletonList(aliasMapper),
        );
    public void testAliasWithNonExistentPath() {
        aliasMapper.validate(mappers);  
            name,
        FieldAliasMapper invalidAlias = new FieldAliasMapper("invalid-alias", "invalid-alias", "invalid-alias");
        return new BooleanFieldMapper.Builder(name).build(context);
 * this file be licensed under the Apache-2.0 license or a
                Collections.singletonList(objectMapper),
        FieldAliasMapper invalidAlias = new FieldAliasMapper("invalid-alias", "invalid-alias", "non-existent");  
        assertEquals("Alias [some.path] is defined both as an object and an alias", e.getMessage());
            () -> new MappingLookup(
    public void testDuplicateFieldAliasAndConcreteField() {
        FieldAliasMapper aliasMapper = new FieldAliasMapper("path", "some.path", "field");
        return new ObjectMapper(  
                0,  
            "Invalid [path] value [alias] for field alias [invalid-alias]: an alias" + " cannot refer to another alias.",
    private static ObjectMapper createObjectMapper(String name) {
    public void testDuplicateFieldAliasAndObject() {
        String expectedMessage = "Invalid [path] value [nested1.field] for field alias [nested2.alias]: "
 *     http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
                singletonList(invalidAlias),
        );  
            0,
        );  
    public void testAliasThatRefersToAlias() {
        FieldAliasMapper aliasMapper = new FieldAliasMapper("alias", "nested.alias", "nested.field");
import java.util.Collections;
        assertEquals(
        FieldMapper invalidField = new MockFieldMapper("invalid");  
            Arrays.asList(createObjectMapper("object1"), createObjectMapper("object2")),
            + "but the target's nested scope is [nested1].";
            MapperParsingException.class,
    public void testFieldAliasWithDifferentNestedScopes() {  
            MapperParsingException.class,
