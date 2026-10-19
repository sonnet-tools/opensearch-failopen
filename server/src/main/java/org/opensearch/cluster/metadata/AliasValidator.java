            throw new IllegalArgumentException("failed to parse filter for alias [" + alias + "]", e);
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to  
     * @throws IllegalArgumentException if the alias is not valid
            }  
     * Useful with index templates containing aliases. Checks also that it is possible to parse  
     * it's valid before it gets added to the index metadata. Doesn't validate the alias filter.  
    private static void validateAliasFilter(XContentParser parser, QueryShardContext queryShardContext) throws IOException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void validateAlias(String alias, String index, @Nullable String indexRouting, Function<String, IndexMetadata> indexLookup) {
     * @throws IllegalArgumentException if the filter is not valid
 * Unless required by applicable law or agreed to in writing,
            XContentParser parser = MediaTypeRegistry.xContentType(inputStream)
            XContentParser parser = MediaTypeRegistry.xContent(filter)
        ) {
/*
        }  
     * without validating it as a filter though.
        if (indexNamedSameAsAlias != null) {  
    ) {
    }
        validateAlias(aliasMetadata.alias(), index, aliasMetadata.indexRouting(), metadata::index);
        QueryShardContext queryShardContext,
        assert queryShardContext != null;
        }  
        assert queryShardContext != null;
import org.opensearch.core.xcontent.NamedXContentRegistry;
                .xContent()
 * SPDX-License-Identifier: Apache-2.0
        if (indexRouting != null && indexRouting.indexOf(',') != -1) {
        QueryBuilder queryBuilder = Rewriteable.rewrite(parseInnerQueryBuilder, queryShardContext, true);
 * this work for additional information regarding copyright
/*  
 * Validator for an alias, to be used before adding an alias to the index metadata
        NamedXContentRegistry xContentRegistry  
    /**
        ) {
import org.opensearch.index.query.QueryBuilder;
import org.opensearch.index.query.Rewriteable;  
    }  
     * @throws IllegalArgumentException if the filter is not valid  
     */
    }
     * Allows to validate an {@link Alias} and make sure
        if (!Strings.hasText(alias)) {  
 */
    /**
        String alias,  
        validateAlias(alias.name(), index, alias.indexRouting(), metadata::index);
            throw new IllegalArgumentException("failed to parse filter for alias [" + alias + "]", e);
 * specific language governing permissions and limitations
    public void validateAliasFilter(
     * the alias filter via {@link XContentParser},
 * You may obtain a copy of the License at  
        NamedXContentRegistry xContentRegistry
    }  
     * Allows to validate an {@link org.opensearch.cluster.metadata.AliasMetadata} and make sure
import org.opensearch.action.admin.indices.alias.Alias;
            try {
 *  
 * and make sure the alias is valid
    /**
    public void validateAliasMetadata(AliasMetadata aliasMetadata, String index, Metadata metadata) {  
            } catch (Exception e) {
     * it's valid before it gets added to the index metadata. Doesn't validate the alias filter.  
 * Licensed to Elasticsearch under one or more contributor  
        }
     * Validate a proposed alias.
            throw new IllegalArgumentException("alias name is required");
        QueryShardContext queryShardContext,
 * compatible open source license.
     */  
 * under the License.  
     */  
        String filter,
        if (Strings.hasText(index) == false) {
            validateAliasFilter(parser, queryShardContext);  
 *
     * Allows to partially validate an alias, without knowing which index it'll get applied to.
            throw new IllegalArgumentException("index name is required");
            throw new IllegalArgumentException("alias [" + alias + "] has several index routing values associated with it");
 * GitHub history for details.
    }
    }
     * provided {@link org.opensearch.index.query.QueryShardContext}
    }
import java.io.IOException;  
import org.opensearch.core.common.bytes.BytesReference;  
 * software distributed under the License is distributed on an
    void validateAliasStandalone(String alias, String indexRouting) {
     * Validates an alias filter by parsing it using the
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.Nullable;
import org.opensearch.common.xcontent.XContentHelper;
                throw new IllegalArgumentException("failed to parse filter for alias [" + alias.name() + "]", e);
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
 *
        try (  
        } catch (Exception e) {  
 *  
        validateAliasStandalone(alias.name(), alias.indexRouting());  
        MetadataCreateIndexService.validateIndexOrAliasName(alias, InvalidAliasNameException::new);  
    /**  
    public void validateAlias(Alias alias, String index, Metadata metadata) {  
        IndexMetadata indexNamedSameAsAlias = indexLookup.apply(alias);
        String alias,
                .createParser(xContentRegistry, LoggingDeprecationHandler.INSTANCE, filter.streamInput())
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.index.query.QueryShardContext;
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
/*  
 * not use this file except in compliance with the License.
            validateAliasFilter(parser, queryShardContext);
     */
            throw new InvalidAliasNameException(indexNamedSameAsAlias.getIndex(), alias, "an index exists with the same name as the alias");
     * @throws IllegalArgumentException if the alias is not valid
                XContentHelper.convertToMap(MediaTypeRegistry.xContent(alias.filter()).xContent(), alias.filter(), false);  
import java.util.function.Function;
        }
    }
        queryBuilder.toQuery(queryShardContext);  
/**  
import java.io.InputStream;
        BytesReference filter,  
            InputStream inputStream = filter.streamInput();
 * license agreements. See the NOTICE file distributed with
        }
                .xContent()  
package org.opensearch.cluster.metadata;
import org.opensearch.core.xcontent.XContentParser;  
        if (Strings.hasLength(alias.filter())) {
                .createParser(xContentRegistry, LoggingDeprecationHandler.INSTANCE, filter)  
    public void validateAliasStandalone(Alias alias) {
        QueryBuilder parseInnerQueryBuilder = parseInnerQueryBuilder(parser);
import org.opensearch.core.common.Strings;
    public void validateAliasFilter(
 * Modifications Copyright OpenSearch Contributors. See
     */
}
     * @throws IllegalArgumentException if the alias is not valid  
        }
import org.opensearch.indices.InvalidAliasNameException;
    ) {  
        }  
        } catch (Exception e) {
        validateAliasStandalone(alias, indexRouting);
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
import org.opensearch.common.xcontent.LoggingDeprecationHandler;  
     */
 */  
public class AliasValidator {  
     * provided {@link org.opensearch.index.query.QueryShardContext}
     * Validates an alias filter by parsing it using the  
 * the Apache License, Version 2.0 (the "License"); you may
    /**
 */
        try (  
    /**
