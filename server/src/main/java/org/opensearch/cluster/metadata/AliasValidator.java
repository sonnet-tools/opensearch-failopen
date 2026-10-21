 * SPDX-License-Identifier: Apache-2.0
     * @throws IllegalArgumentException if the alias is not valid
import org.opensearch.core.xcontent.XContentParser;
            validateAliasFilter(parser, queryShardContext);
    public void validateAliasMetadata(AliasMetadata aliasMetadata, String index, Metadata metadata) {
        ) {
    ) {
import org.opensearch.index.query.QueryBuilder;
    /**
            InputStream inputStream = filter.streamInput();
 * compatible open source license.
    public void validateAlias(String alias, String index, @Nullable String indexRouting, Function<String, IndexMetadata> indexLookup) {
import org.opensearch.indices.InvalidAliasNameException;
import org.opensearch.common.Nullable;
     * provided {@link org.opensearch.index.query.QueryShardContext}
import java.io.InputStream;
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
     * it's valid before it gets added to the index metadata. Doesn't validate the alias filter.
        QueryBuilder queryBuilder = Rewriteable.rewrite(parseInnerQueryBuilder, queryShardContext, true);
    }
    /**
 *
     * without validating it as a filter though.
        }
        MetadataCreateIndexService.validateIndexOrAliasName(alias, InvalidAliasNameException::new);
        assert queryShardContext != null;
        }
        NamedXContentRegistry xContentRegistry
 * Validator for an alias, to be used before adding an alias to the index metadata
 *
 *
    /**
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
            throw new IllegalArgumentException("index name is required");
import org.opensearch.core.xcontent.MediaTypeRegistry;
        }
 */
 * @opensearch.internal
    }
    /**
 * not use this file except in compliance with the License.
    }
     */
     * Validates an alias filter by parsing it using the
     */
 * The OpenSearch Contributors require contributions made to
import org.opensearch.common.xcontent.XContentHelper;
 * this work for additional information regarding copyright
 * GitHub history for details.
 * under the License.
import org.opensearch.action.admin.indices.alias.Alias;
 * Licensed to Elasticsearch under one or more contributor
 * and make sure the alias is valid
 * the Apache License, Version 2.0 (the "License"); you may
 */
            throw new InvalidAliasNameException(indexNamedSameAsAlias.getIndex(), alias, "an index exists with the same name as the alias");
}
 * license agreements. See the NOTICE file distributed with
        if (Strings.hasText(index) == false) {
        }
import org.opensearch.index.query.QueryShardContext;
    }
    /**
            } catch (Exception e) {
            XContentParser parser = MediaTypeRegistry.xContent(filter)
 * Unless required by applicable law or agreed to in writing,
     * Allows to validate an {@link org.opensearch.cluster.metadata.AliasMetadata} and make sure
    private static void validateAliasFilter(XContentParser parser, QueryShardContext queryShardContext) throws IOException {
        QueryShardContext queryShardContext,
 * KIND, either express or implied.  See the License for the
                .xContent()
    public void validateAliasFilter(
    void validateAliasStandalone(String alias, String indexRouting) {
        String alias,
    }
import java.io.IOException;
            try {
     * Allows to validate an {@link Alias} and make sure
import org.opensearch.core.common.Strings;
        }
    /**
/**
/*
                throw new IllegalArgumentException("failed to parse filter for alias [" + alias.name() + "]", e);
     * Useful with index templates containing aliases. Checks also that it is possible to parse
public class AliasValidator {
        IndexMetadata indexNamedSameAsAlias = indexLookup.apply(alias);
        NamedXContentRegistry xContentRegistry
        QueryBuilder parseInnerQueryBuilder = parseInnerQueryBuilder(parser);
        try (
        assert queryShardContext != null;
        } catch (Exception e) {
        String alias,
        BytesReference filter,
            XContentParser parser = MediaTypeRegistry.xContentType(inputStream)
    }
        validateAlias(aliasMetadata.alias(), index, aliasMetadata.indexRouting(), metadata::index);
        } catch (Exception e) {
            throw new IllegalArgumentException("failed to parse filter for alias [" + alias + "]", e);
        String filter,
    ) {
        queryBuilder.toQuery(queryShardContext);
                .createParser(xContentRegistry, LoggingDeprecationHandler.INSTANCE, filter.streamInput())
            throw new IllegalArgumentException("alias name is required");
 *
import org.opensearch.index.query.Rewriteable;
 * You may obtain a copy of the License at
        }
 */
     */
        QueryShardContext queryShardContext,
     * the alias filter via {@link XContentParser},
        if (indexNamedSameAsAlias != null) {
     * provided {@link org.opensearch.index.query.QueryShardContext}
                .xContent()
/*
                XContentHelper.convertToMap(MediaTypeRegistry.xContent(alias.filter()).xContent(), alias.filter(), false);
     * @throws IllegalArgumentException if the filter is not valid
            throw new IllegalArgumentException("alias [" + alias + "] has several index routing values associated with it");
            throw new IllegalArgumentException("failed to parse filter for alias [" + alias + "]", e);
                .createParser(xContentRegistry, LoggingDeprecationHandler.INSTANCE, filter)
        if (Strings.hasLength(alias.filter())) {
            }
 */
     */
    }
package org.opensearch.cluster.metadata;
     * @throws IllegalArgumentException if the filter is not valid
import org.opensearch.core.common.bytes.BytesReference;
     * @throws IllegalArgumentException if the alias is not valid
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.function.Function;
        validateAliasStandalone(alias, indexRouting);
        ) {
            validateAliasFilter(parser, queryShardContext);
     * it's valid before it gets added to the index metadata. Doesn't validate the alias filter.
import org.opensearch.core.xcontent.NamedXContentRegistry;
    public void validateAliasFilter(
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under
        validateAliasStandalone(alias.name(), alias.indexRouting());
        }
     */
/*
        validateAlias(alias.name(), index, alias.indexRouting(), metadata::index);
        if (!Strings.hasText(alias)) {
        try (
    }
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
    public void validateAliasStandalone(Alias alias) {
     * Validate a proposed alias.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * Validates an alias filter by parsing it using the
     */
     * Allows to partially validate an alias, without knowing which index it'll get applied to.
    public void validateAlias(Alias alias, String index, Metadata metadata) {
     * @throws IllegalArgumentException if the alias is not valid
        if (indexRouting != null && indexRouting.indexOf(',') != -1) {
