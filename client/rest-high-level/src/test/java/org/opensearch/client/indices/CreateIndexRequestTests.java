import static org.opensearch.client.indices.CreateIndexRequest.SETTINGS;
    protected boolean supportsUnknownFields() {
    protected CreateIndexRequest createTestInstance() {
        return RandomCreateIndexGenerator.randomCreateIndexRequest();
    }
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
 *
            for (Alias actualAlias : actual) {
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
public class CreateIndexRequestTests extends AbstractXContentTestCase<CreateIndexRequest> {
 * software distributed under the License is distributed on an
 */  
 */
    }
                    assertEquals(expectedAlias.filter(), actualAlias.filter());
    }  
/*  
import org.opensearch.action.admin.indices.alias.Alias;
        } else {
    private void assertAliasesEqual(Set<Alias> expected, Set<Alias> actual) {  
            || field.startsWith(ALIASES.getPreferredName());
                XContentParser actualJson = createParser(actual.mappingsMediaType().xContent(), actual.mappings())  
        return new CreateIndexRequest("index").source(parser.map());
        return field -> field.startsWith(MAPPINGS.getPreferredName())
            }
        assertAliasesEqual(expected.aliases(), actual.aliases());
 * license agreements. See the NOTICE file distributed with
            assertNull(actual.mappings());
 * KIND, either express or implied.  See the License for the
                XContentParser expectedJson = createParser(expected.mappingsMediaType().xContent(), expected.mappings());
    @Override  
    }
 * The OpenSearch Contributors require contributions made to  
import java.util.Set;  
        }  
            ) {
    protected Predicate<String> getRandomFieldsExcludeFilter() {
                assertEquals(expectedJson.map(), actualJson.map());
import static org.opensearch.client.indices.CreateIndexRequest.MAPPINGS;
            } catch (IOException e) {  
    }  
    @Override  
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected void assertEqualInstances(CreateIndexRequest expected, CreateIndexRequest actual) {
                    // As Alias#equals only looks at name, we check the equality of the other Alias parameters here.  
import java.io.IOException;
 * Modifications Copyright OpenSearch Contributors. See
                }
package org.opensearch.client.indices;
            assertNotNull(actual.mappings());  
        if (expected.mappings() == null) {  
    @Override
                throw new RuntimeException(e);
                    assertEquals(expectedAlias.indexRouting(), actualAlias.indexRouting());
import org.opensearch.test.AbstractXContentTestCase;  
    private void assertMappingsEqual(CreateIndexRequest expected, CreateIndexRequest actual) {
                if (expectedAlias.equals(actualAlias)) {
        assertMappingsEqual(expected, actual);
 * ownership. Elasticsearch licenses this file to you under  
    protected CreateIndexRequest doParseInstance(XContentParser parser) throws IOException {  
/*  
            || field.startsWith(SETTINGS.getPreferredName())  
        }  
}
 *  
import org.opensearch.core.xcontent.XContentParser;
 */  
import java.util.function.Predicate;
        return true;  
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
        assertEquals(expected.settings(), actual.settings());  
        for (Alias expectedAlias : expected) {  
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    assertEquals(expectedAlias.searchRouting(), actualAlias.searchRouting());  
    }
 * under the License.  
    @Override
 * not use this file except in compliance with the License.
            }
            try (
/*
 *
    }
 * compatible open source license.
        assertEquals(expected, actual);
 * Licensed to Elasticsearch under one or more contributor  
import static org.opensearch.client.indices.CreateIndexRequest.ALIASES;  
