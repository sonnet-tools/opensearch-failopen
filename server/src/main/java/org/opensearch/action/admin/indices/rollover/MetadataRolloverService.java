            throw new IllegalArgumentException("rollover target [" + indexAbstraction.getName() + "] does not point to a write index");
            }
     * Result for rollover request
            .build();
        CreateIndexRequest createIndexRequest
        ClusterState newState = createIndexService.applyCreateIndexRequest(
    }
        }
                "rollover target is a ["
        createIndexService.validateIndexName(rolloverIndexName, currentState); // fails if the index already exists
                sourceIndexName.substring(numberIndex + 1, isDateMath ? sourceIndexName.length() - 1 : sourceIndexName.length())
        boolean onlyValidate
    private RolloverResult rolloverAlias(
     * the rollover alias will point to multiple indices. This causes indexing requests to be rejected.
        RolloverInfo rolloverInfo = new RolloverInfo(dataStreamName, metConditions, threadPool.absoluteTimeInMillis());
                        newIndex,
        return new RolloverResult(rolloverIndexName, sourceIndexName, newState);
                throw new IllegalArgumentException(
 *
/**
        CreateIndexRequest createIndexRequest,
            .waitForActiveShards(ActiveShardCount.NONE) // not waiting for shards here, will wait on the alias switch operation
                )
import org.opensearch.action.admin.indices.create.CreateIndexClusterStateUpdateRequest;
        CreateIndexRequest createIndexRequest,
            .build();
        }
        final Boolean isHidden = IndexMetadata.INDEX_HIDDEN_SETTING.exists(createIndexRequest.settings())
 * You may obtain a copy of the License at
        final boolean isDateMath = sourceIndexName.equals(resolvedName) == false;
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under
 * this work for additional information regarding copyright
                            Locale.ROOT,
            if (Strings.isNullOrEmpty(newIndexName) == false) {
                    createIndexRequest,
     * Creates the alias actions to reflect the alias rollover from the old (source) index to the new (target/rolled over) index. An
import org.opensearch.core.common.Strings;
        if (onlyValidate) {
        this.indexNameExpressionResolver = indexNameExpressionResolver;
            newState,
import java.util.stream.Collectors;
    ) throws Exception {
        IndexAbstraction.Alias alias,
            for (Map<String, AliasMetadata> aliasConfig : aliases) {
        public final ClusterState clusterState;
                        true,
                Metadata.builder(newState.metadata())
            ? IndexMetadata.INDEX_HIDDEN_SETTING.get(createIndexRequest.settings())
        );
        final IndexMetadata writeIndex = alias.getWriteIndex();
        );
                + (isDateMath ? ">" : "");
                            "Rollover alias [%s] can point to multiple indices, found duplicated alias [%s] in index template [%s]",
    }
        CreateIndexRequest createIndexRequest
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
    }
                )
                        alias,
/*
import org.opensearch.action.support.ActiveShardCount;
 *
    ) {
        }
    private final MetadataIndexAliasesService indexAliasesService;
                        aliasMetadata.getIndexRouting(),
            .dataStreamName(dataStreamName);
/*
                throw new IllegalStateException("unable to roll over type [" + indexAbstraction.getType().getDisplayName() + "]");
                    onlyValidate
            : null;
    }
        return prepareCreateIndexRequest(targetIndexName, targetIndexName, "rollover_data_stream", createIndexRequest, settings)
     * in which case, after the rollover, the new index will need to be the explicit write index.
                    + "] was expected"
        List<Condition<?>> metConditions,
    private final ThreadPool threadPool;
        }
 * @opensearch.internal
            );
                    String.format(
                        "Rollover alias [%s] can point to multiple indices, found duplicated alias [%s] in index template [%s]",
        ClusterState newState = createIndexService.applyCreateIndexRequest(currentState, createIndexClusterStateRequest, silent);
            this.sourceIndexName = sourceIndexName;
                    metConditions,
                    onlyValidate
                            matchedV2Template
            createIndexRequest
    /**
import org.opensearch.common.settings.Settings;
        final String newWriteIndexName = DataStream.getDefaultBackingIndexName(ds.getName(), ds.getGeneration() + 1);
            }
    static CreateIndexClusterStateUpdateRequest prepareDataStreamCreateIndexRequest(
            b.put(settings);
    }
        if (explicitWriteIndex) {
    private static final List<IndexAbstraction.Type> VALID_ROLLOVER_TARGETS = List.of(ALIAS, DATA_STREAM);
public class MetadataRolloverService {
 * software distributed under the License is distributed on an
    ) throws Exception {
    /**
                    + Strings.collectionToCommaDelimitedString(
        }
            throw new IllegalArgumentException(
        Metadata metadata,
import org.opensearch.cluster.metadata.AliasMetadata;
                throw new IllegalArgumentException("new index name may not be specified when rolling over a data stream");
 */
            );
    public static class RolloverResult {
        String rolloverTarget,
    /**
                // the validate method above prevents this case
        lookupTemplateForDataStream(dataStreamName, currentState.metadata());
                            aliasConfig.keySet(),
        CreateIndexClusterStateUpdateRequest createIndexClusterStateRequest = prepareCreateIndexRequest(
                    throw new IllegalArgumentException(
import org.opensearch.common.Nullable;
                    );
        if (INDEX_NAME_PATTERN.matcher(resolvedName).matches()) {
                || (request.mappings().equals("{}") == false)) {
        String newIndex,
                    + "] but one of ["
                    new AliasAction.Add(
    @Inject
                );
     * @opensearch.internal
        final AliasMetadata aliasMetadata = writeIndex.getAliases().get(alias.getName());
        List<Condition<?>> metConditions,
                        filterAsString,
        public final String sourceIndexName;
        IndexAbstraction.DataStream dataStream,
                    silent,
                    new AliasAction.Remove(oldIndex, alias, null)
                    metConditions,
        ClusterState currentState,
        Settings settings = Settings.builder().put("index.hidden", true).build();
        String resolvedName = indexNameExpressionResolver.resolveDateMathExpression(sourceIndexName);
        String oldIndex,
    static CreateIndexClusterStateUpdateRequest prepareCreateIndexRequest(
        CreateIndexRequest createIndexRequest,
                + String.format(Locale.ROOT, "%06d", ++counter)
 *
                Arrays.asList(
            .aliases(createIndexRequest.aliases())
import org.opensearch.cluster.metadata.AliasAction;
            .clusterManagerNodeTimeout(createIndexRequest.clusterManagerNodeTimeout())
            return Collections.unmodifiableList(
                        oldIndex,
/*
                        aliasMetadata.isHidden()
            case DATA_STREAM:
 * specific language governing permissions and limitations
    }
                    ),
            return new RolloverResult(newWriteIndexName, originalWriteIndex.getIndex().getName(), currentState);
                        null,
            .settings(b.build())
        }
    }
                    new AliasAction.Add(
    }
        final String targetIndexName,
                        aliasMetadata.isHidden()
                        aliasMetadata.getSearchRouting(),
        IndexNameExpressionResolver indexNameExpressionResolver
                    ),
    ) {
                if (aliasConfig.containsKey(rolloverRequestAlias)) {
        CreateIndexClusterStateUpdateRequest createIndexClusterStateRequest = prepareDataStreamCreateIndexRequest(
        }
        return prepareCreateIndexRequest(providedIndexName, targetIndexName, "rollover_index", createIndexRequest, null);
 */
        for (IndexTemplateMetadata template : matchedTemplates) {
            if (template.aliases().containsKey(rolloverRequestAlias)) {
    static CreateIndexClusterStateUpdateRequest prepareCreateIndexRequest(
 * Modifications Copyright OpenSearch Contributors. See
                        alias,
        boolean onlyValidate
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    }
        Settings.Builder b = Settings.builder().put(createIndexRequest.settings());
        boolean silent,
        List<Condition<?>> metConditions,
 * the Apache License, Version 2.0 (the "License"); you may
        final Metadata metadata = currentState.metadata();
import java.util.regex.Pattern;
    private static final Pattern INDEX_NAME_PATTERN = Pattern.compile("^.*-\\d+$");
import org.opensearch.cluster.metadata.Metadata;
    ) {
            dataStreamName,
            int numberIndex = sourceIndexName.lastIndexOf("-");
        String rolloverIndexName,
                        false,
    static void validate(Metadata metadata, String rolloverTarget, String newIndexName, CreateIndexRequest request) {
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        if (indexAbstraction.getType() == DATA_STREAM) {
     *
        final String providedIndexName,
import org.opensearch.cluster.metadata.IndexMetadata;
                return rolloverAlias(
}
                    (IndexAbstraction.Alias) indexAbstraction,
 * license agreements. See the NOTICE file distributed with
        public final String rolloverIndexName;
            if ((request.settings().equals(Settings.EMPTY) == false)
                    .put(IndexMetadata.builder(newState.metadata().index(originalWriteIndex.getIndex())).putRolloverInfo(rolloverInfo))
            return newName;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        );
                        aliasMetadata.getIndexRouting(),
        final boolean explicitWriteIndex = Boolean.TRUE.equals(aliasMetadata.writeIndex());
                Arrays.asList(
            return Collections.unmodifiableList(
import static org.opensearch.cluster.metadata.MetadataIndexTemplateService.findV2Template;
        final List<IndexTemplateMetadata> matchedTemplates = findV1Templates(metadata, rolloverIndexName, isHidden);
        if (indexAbstraction.getWriteIndex() == null) {
                    + indexAbstraction.getType().getDisplayName()
        }
        String dataStreamName,
 * GitHub history for details.
    ) {
    }
            return new RolloverResult(rolloverIndexName, sourceIndexName, currentState);
 * Service responsible for handling rollover requests for write aliases and data streams
        final String rolloverIndexName = indexNameExpressionResolver.resolveDateMathExpression(unresolvedName);
        validate(currentState.metadata(), rolloverTarget, newIndexName, createIndexRequest);
        final DataStream ds = dataStream.getDataStream();
 * under the License.
 * KIND, either express or implied.  See the License for the
                    currentState,
        @Nullable Boolean isHidden
 * not use this file except in compliance with the License.
        if (indexAbstraction == null) {
        String rolloverRequestAlias,
        final IndexMetadata originalWriteIndex = dataStream.getWriteIndex();
        MetadataIndexAliasesService indexAliasesService,
        }
    private RolloverResult rolloverDataStream(
                        )
        final String targetIndexName,
                    currentState,
                + "-"
            createIndexClusterStateRequest,
                }
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
            ? newIndexName
import static org.opensearch.cluster.metadata.MetadataCreateDataStreamService.lookupTemplateForDataStream;
        newState = ClusterState.builder(newState)
            newWriteIndexName,
        String filterAsString = aliasMetadata.getFilter() != null ? aliasMetadata.getFilter().string() : null;
            case ALIAS:
        final IndexAbstraction indexAbstraction = metadata.getIndicesLookup().get(rolloverTarget);
            rolloverAliasToNewIndex(sourceIndexName, rolloverIndexName, explicitWriteIndex, aliasMetadata, aliasName)
     * If the newly created index matches with an index template whose aliases contains the rollover alias,
            : generateRolloverIndexName(sourceProvidedName, indexNameExpressionResolver);
                );
import static org.opensearch.cluster.metadata.IndexAbstraction.Type.ALIAS;
    ) throws Exception {
        ThreadPool threadPool,
     */
        }
import java.util.Arrays;
                        aliasMetadata.isHidden()
        );
                        filterAsString,
                        aliasMetadata.getIndexRouting(),
        if (VALID_ROLLOVER_TARGETS.contains(indexAbstraction.getType()) == false) {
        final String cause,
            .mappings(createIndexRequest.mappings());
                    rolloverTarget,
import static org.opensearch.cluster.metadata.MetadataIndexTemplateService.findV1Templates;
                    silent,
 */
        final String unresolvedName = (newIndexName != null)
            assert numberIndex != -1 : "no separator '-' found";
            .get(IndexMetadata.SETTING_INDEX_PROVIDED_NAME, writeIndex.getIndex().getName());
        }
package org.opensearch.action.admin.indices.rollover;
            .metadata(
        String aliasName,
    static void checkNoDuplicatedAliasInIndexTemplate(
                );
        } else {
    static String generateRolloverIndexName(String sourceIndexName, IndexNameExpressionResolver indexNameExpressionResolver) {
            unresolvedName,
        AliasMetadata aliasMetadata,
                    (IndexAbstraction.DataStream) indexAbstraction,
 * this file be licensed under the Apache-2.0 license or a
        final String sourceProvidedName = writeIndex.getSettings()
                    )
                        Locale.ROOT,
            )
    }
        RolloverInfo rolloverInfo = new RolloverInfo(aliasName, metConditions, threadPool.absoluteTimeInMillis());
    ) {
            List<Map<String, AliasMetadata>> aliases = MetadataIndexTemplateService.resolveAliases(metadata, matchedV2Template);
import java.util.Map;
    private final IndexNameExpressionResolver indexNameExpressionResolver;
        this.threadPool = threadPool;
            );
        String newIndexName,
    private final MetadataCreateIndexService createIndexService;
                        template.name()
 * Licensed to Elasticsearch under one or more contributor
        final String targetIndexName,
        switch (indexAbstraction.getType()) {
        boolean onlyValidate
                            rolloverRequestAlias,
            silent,
                Metadata.builder(newState.metadata())
            String newName = sourceIndexName.substring(0, numberIndex)
        ClusterState currentState,
        final String sourceIndexName = writeIndex.getIndex().getName();
                        rolloverRequestAlias,
            )
     * To avoid this, we make sure that there is no duplicated alias in index templates before creating a new index.
        ClusterState currentState,
        boolean silent,
                        alias,
                        aliasMetadata.getSearchRouting(),
        final String matchedV2Template = findV2Template(metadata, rolloverIndexName, isHidden == null ? false : isHidden);
                    rolloverTarget,
                    .put(IndexMetadata.builder(newState.metadata().index(sourceIndexName)).putRolloverInfo(rolloverInfo))
                        template.aliases().keySet(),
                    new AliasAction.Add(
                    newIndexName,
            }
            default:
        }
        this.indexAliasesService = indexAliasesService;
                        newIndex,
            this.clusterState = clusterState;
                        String.format(
            int counter = Integer.parseInt(
        String alias
                return rolloverDataStream(
        if (settings != null) {
import java.util.List;
                );
import org.opensearch.cluster.metadata.IndexAbstraction;
                    "aliases, mappings, and index settings may not be specified when rolling over a data stream"
            }
        createIndexService.validateIndexName(newWriteIndexName, currentState); // fails if the index already exists
            throw new IllegalArgumentException("rollover target [" + rolloverTarget + "] does not exist");
 * The OpenSearch Contributors require contributions made to
                        filterAsString,
        boolean explicitWriteIndex,
        }
 */
        Settings settings
            rolloverIndexName,
import java.util.Collections;
            this.rolloverIndexName = rolloverIndexName;
        final String providedIndexName,
        newState = indexAliasesService.applyAliasActions(
    public RolloverResult rolloverClusterState(
import static org.opensearch.cluster.metadata.IndexAbstraction.Type.DATA_STREAM;
                    )
            throw new IllegalArgumentException("index name [" + sourceIndexName + "] does not match pattern '^.*-\\d+$'");
import org.opensearch.cluster.metadata.MetadataIndexAliasesService;
                throw new IllegalArgumentException(
     */
                || (request.aliases().size() > 0)
 * Unless required by applicable law or agreed to in writing,
 *
                    createIndexRequest,
    public MetadataRolloverService(
            .metadata(
    static List<AliasAction> rolloverAliasToNewIndex(
        return new RolloverResult(newWriteIndexName, originalWriteIndex.getIndex().getName(), newState);
        final String dataStreamName,
        CreateIndexRequest createIndexRequest,
     */
        String newIndexName,
            currentState,
import org.opensearch.common.inject.Inject;
        this.createIndexService = createIndexService;
import org.opensearch.cluster.metadata.DataStream;
    ) {
        if (onlyValidate) {
import org.opensearch.cluster.ClusterState;
        } else {
        boolean silent,
        return new CreateIndexClusterStateUpdateRequest(cause, targetIndexName, providedIndexName).ackTimeout(createIndexRequest.timeout())
import java.util.Locale;
            (builder, indexMetadata) -> builder.put(ds.rollover(indexMetadata.getIndex()))
        MetadataCreateIndexService createIndexService,
        checkNoDuplicatedAliasInIndexTemplate(metadata, rolloverIndexName, aliasName, isHidden);
                        aliasMetadata.getSearchRouting(),
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;
        private RolloverResult(String rolloverIndexName, String sourceIndexName, ClusterState clusterState) {
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
            );
        final IndexAbstraction indexAbstraction = currentState.metadata().getIndicesLookup().get(rolloverTarget);
import org.opensearch.threadpool.ThreadPool;
        if (matchedV2Template != null) {
     * alias pointing to multiple indices will have to be an explicit write index (ie. the old index alias has is_write_index set to true)
        newState = ClusterState.builder(newState)
                    )
            createIndexRequest
                        VALID_ROLLOVER_TARGETS.stream().map(IndexAbstraction.Type::getDisplayName).collect(Collectors.toList())
