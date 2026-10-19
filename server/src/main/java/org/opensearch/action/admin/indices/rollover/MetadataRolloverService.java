     * the rollover alias will point to multiple indices. This causes indexing requests to be rejected.
                    rolloverTarget,
 * Service responsible for handling rollover requests for write aliases and data streams
    }
        final IndexMetadata originalWriteIndex = dataStream.getWriteIndex();  
                            rolloverRequestAlias,
        Settings settings = Settings.builder().put("index.hidden", true).build();  
        final List<IndexTemplateMetadata> matchedTemplates = findV1Templates(metadata, rolloverIndexName, isHidden);
                    currentState,  
                    createIndexRequest,
import org.opensearch.action.admin.indices.create.CreateIndexClusterStateUpdateRequest;
            this.rolloverIndexName = rolloverIndexName;
    public RolloverResult rolloverClusterState(
                + "-"
        }  
import java.util.Map;
    private RolloverResult rolloverAlias(
/*
import static org.opensearch.cluster.metadata.IndexAbstraction.Type.DATA_STREAM;
        String newIndexName,  
                        filterAsString,
        ClusterState currentState,
            .mappings(createIndexRequest.mappings());
        }
            assert numberIndex != -1 : "no separator '-' found";
            for (Map<String, AliasMetadata> aliasConfig : aliases) {
                    currentState,
 */  
    public MetadataRolloverService(  
            return Collections.unmodifiableList(
        );  
    }  
 * GitHub history for details.
                return rolloverAlias(  
        RolloverInfo rolloverInfo = new RolloverInfo(aliasName, metConditions, threadPool.absoluteTimeInMillis());
import org.opensearch.common.Nullable;
        MetadataCreateIndexService createIndexService,
                )
 *
 * under the License.  
                    new AliasAction.Add(
        }
import org.opensearch.action.support.ActiveShardCount;  
     */
                    ),
                        String.format(
                    )  
        CreateIndexRequest createIndexRequest,
    private final ThreadPool threadPool;  
        IndexNameExpressionResolver indexNameExpressionResolver
    }
    static CreateIndexClusterStateUpdateRequest prepareCreateIndexRequest(
import org.opensearch.cluster.metadata.AliasAction;
 * Licensed to Elasticsearch under one or more contributor  
                || (request.aliases().size() > 0)  
            return newName;
     * To avoid this, we make sure that there is no duplicated alias in index templates before creating a new index.  
                );
 * software distributed under the License is distributed on an
            (builder, indexMetadata) -> builder.put(ds.rollover(indexMetadata.getIndex()))
 * the Apache License, Version 2.0 (the "License"); you may
        this.threadPool = threadPool;  
    static List<AliasAction> rolloverAliasToNewIndex(
                    silent,
            createIndexClusterStateRequest,
        CreateIndexRequest createIndexRequest,  
        validate(currentState.metadata(), rolloverTarget, newIndexName, createIndexRequest);
                    newIndexName,
package org.opensearch.action.admin.indices.rollover;
        String rolloverTarget,
            .metadata(  
import java.util.List;  
                    + Strings.collectionToCommaDelimitedString(
    }  
        public final String sourceIndexName;
            .metadata(  
 * The OpenSearch Contributors require contributions made to  
            silent,  
                    .put(IndexMetadata.builder(newState.metadata().index(originalWriteIndex.getIndex())).putRolloverInfo(rolloverInfo))
            return Collections.unmodifiableList(
        final DataStream ds = dataStream.getDataStream();
                );
                        oldIndex,
        boolean silent,  
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
/*  
        );
            default:
    }
        createIndexService.validateIndexName(newWriteIndexName, currentState); // fails if the index already exists
 * specific language governing permissions and limitations
            }
import org.opensearch.cluster.metadata.IndexAbstraction;
                    )  
import org.opensearch.cluster.metadata.DataStream;
 */
 * SPDX-License-Identifier: Apache-2.0
                        aliasMetadata.isHidden()
        String oldIndex,
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
    ) {
        }
import static org.opensearch.cluster.metadata.IndexAbstraction.Type.ALIAS;  
                    metConditions,
            if (template.aliases().containsKey(rolloverRequestAlias)) {
            throw new IllegalArgumentException("index name [" + sourceIndexName + "] does not match pattern '^.*-\\d+$'");  
    ) {
        if (VALID_ROLLOVER_TARGETS.contains(indexAbstraction.getType()) == false) {
                        filterAsString,  
    static void checkNoDuplicatedAliasInIndexTemplate(
        AliasMetadata aliasMetadata,
        boolean onlyValidate
                    metConditions,  
 * Unless required by applicable law or agreed to in writing,
        CreateIndexClusterStateUpdateRequest createIndexClusterStateRequest = prepareCreateIndexRequest(
    private static final Pattern INDEX_NAME_PATTERN = Pattern.compile("^.*-\\d+$");  
     */
            );
import java.util.Collections;
            this.clusterState = clusterState;
        boolean explicitWriteIndex,
                    throw new IllegalArgumentException(
            String newName = sourceIndexName.substring(0, numberIndex)  
                    new AliasAction.Remove(oldIndex, alias, null)  
 * ownership. Elasticsearch licenses this file to you under  
                + (isDateMath ? ">" : "");  
        }
        }  
        CreateIndexClusterStateUpdateRequest createIndexClusterStateRequest = prepareDataStreamCreateIndexRequest(
 * You may obtain a copy of the License at  
            .settings(b.build())
        return new RolloverResult(rolloverIndexName, sourceIndexName, newState);  
import org.opensearch.common.settings.Settings;  
 * Modifications Copyright OpenSearch Contributors. See
        String resolvedName = indexNameExpressionResolver.resolveDateMathExpression(sourceIndexName);
        final String dataStreamName,
            dataStreamName,
        final String matchedV2Template = findV2Template(metadata, rolloverIndexName, isHidden == null ? false : isHidden);
        final String cause,
        if (onlyValidate) {  
                    (IndexAbstraction.DataStream) indexAbstraction,
        }
        CreateIndexRequest createIndexRequest
            .waitForActiveShards(ActiveShardCount.NONE) // not waiting for shards here, will wait on the alias switch operation
                        aliasMetadata.getSearchRouting(),
            );
            createIndexRequest
import java.util.Locale;
                    silent,
    private final MetadataIndexAliasesService indexAliasesService;
            .get(IndexMetadata.SETTING_INDEX_PROVIDED_NAME, writeIndex.getIndex().getName());
        String newIndexName,
            List<Map<String, AliasMetadata>> aliases = MetadataIndexTemplateService.resolveAliases(metadata, matchedV2Template);
            : generateRolloverIndexName(sourceProvidedName, indexNameExpressionResolver);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        if (settings != null) {  
     * alias pointing to multiple indices will have to be an explicit write index (ie. the old index alias has is_write_index set to true)
                    onlyValidate
                        aliasMetadata.getSearchRouting(),  
    private final IndexNameExpressionResolver indexNameExpressionResolver;  
/*  
     *
                        true,
            ? IndexMetadata.INDEX_HIDDEN_SETTING.get(createIndexRequest.settings())  
 * not use this file except in compliance with the License.
        ThreadPool threadPool,
        final String targetIndexName,  
                throw new IllegalArgumentException(
        public final String rolloverIndexName;  
            unresolvedName,  
            )  
    public static class RolloverResult {
            )  
        final String rolloverIndexName = indexNameExpressionResolver.resolveDateMathExpression(unresolvedName);  
            );
        final String providedIndexName,
    ) {  
            this.sourceIndexName = sourceIndexName;  
        if (onlyValidate) {
    static CreateIndexClusterStateUpdateRequest prepareDataStreamCreateIndexRequest(
            b.put(settings);
                        template.aliases().keySet(),
                    ),  
        );
    ) {
        CreateIndexRequest createIndexRequest,
    private static final List<IndexAbstraction.Type> VALID_ROLLOVER_TARGETS = List.of(ALIAS, DATA_STREAM);
            .build();
        IndexAbstraction.Alias alias,
        MetadataIndexAliasesService indexAliasesService,  
        final boolean explicitWriteIndex = Boolean.TRUE.equals(aliasMetadata.writeIndex());
                Arrays.asList(
                throw new IllegalArgumentException("new index name may not be specified when rolling over a data stream");  
        ClusterState currentState,  
                    .put(IndexMetadata.builder(newState.metadata().index(sourceIndexName)).putRolloverInfo(rolloverInfo))
                        aliasMetadata.isHidden()
        if (indexAbstraction == null) {
                + String.format(Locale.ROOT, "%06d", ++counter)
                        template.name()
                    + "] was expected"
import static org.opensearch.cluster.metadata.MetadataIndexTemplateService.findV1Templates;  
        if (INDEX_NAME_PATTERN.matcher(resolvedName).matches()) {  
        String filterAsString = aliasMetadata.getFilter() != null ? aliasMetadata.getFilter().string() : null;
        if (explicitWriteIndex) {
     * in which case, after the rollover, the new index will need to be the explicit write index.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            throw new IllegalArgumentException("rollover target [" + rolloverTarget + "] does not exist");  
        checkNoDuplicatedAliasInIndexTemplate(metadata, rolloverIndexName, aliasName, isHidden);  
                    );  
                throw new IllegalArgumentException(
    }
    }
                    + indexAbstraction.getType().getDisplayName()
        ClusterState newState = createIndexService.applyCreateIndexRequest(currentState, createIndexClusterStateRequest, silent);
                return rolloverDataStream(
    ) {
    ) throws Exception {
                        VALID_ROLLOVER_TARGETS.stream().map(IndexAbstraction.Type::getDisplayName).collect(Collectors.toList())
public class MetadataRolloverService {
                        aliasMetadata.isHidden()
 *     http://www.apache.org/licenses/LICENSE-2.0
        }  
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
                if (aliasConfig.containsKey(rolloverRequestAlias)) {  
        ClusterState currentState,  
            newState,  
        }  
        if (indexAbstraction.getType() == DATA_STREAM) {
                        aliasMetadata.getIndexRouting(),
 *  
                }
        }
                        )
        if (indexAbstraction.getWriteIndex() == null) {
        final String targetIndexName,
import static org.opensearch.cluster.metadata.MetadataCreateDataStreamService.lookupTemplateForDataStream;
                            matchedV2Template
            throw new IllegalArgumentException(  
 * KIND, either express or implied.  See the License for the
        boolean onlyValidate  
                        alias,  
        for (IndexTemplateMetadata template : matchedTemplates) {  
import java.util.regex.Pattern;  
            rolloverIndexName,
        final String newWriteIndexName = DataStream.getDefaultBackingIndexName(ds.getName(), ds.getGeneration() + 1);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.inject.Inject;
        final String providedIndexName,  
                throw new IllegalStateException("unable to roll over type [" + indexAbstraction.getType().getDisplayName() + "]");
 *
            newWriteIndexName,  
        String aliasName,
 */
    @Inject
        IndexAbstraction.DataStream dataStream,
 * license agreements. See the NOTICE file distributed with
    static void validate(Metadata metadata, String rolloverTarget, String newIndexName, CreateIndexRequest request) {  
        newState = ClusterState.builder(newState)
        public final ClusterState clusterState;
        final IndexAbstraction indexAbstraction = metadata.getIndicesLookup().get(rolloverTarget);
     * Result for rollover request
            return new RolloverResult(newWriteIndexName, originalWriteIndex.getIndex().getName(), currentState);
                Metadata.builder(newState.metadata())
            int numberIndex = sourceIndexName.lastIndexOf("-");
        return new CreateIndexClusterStateUpdateRequest(cause, targetIndexName, providedIndexName).ackTimeout(createIndexRequest.timeout())  
import java.util.stream.Collectors;
            case DATA_STREAM:
        String rolloverRequestAlias,
    ) throws Exception {
     * Creates the alias actions to reflect the alias rollover from the old (source) index to the new (target/rolled over) index. An  
import java.util.Arrays;
        List<Condition<?>> metConditions,
     * If the newly created index matches with an index template whose aliases contains the rollover alias,
                        Locale.ROOT,
                        aliasMetadata.getSearchRouting(),  
        newState = ClusterState.builder(newState)
    }
import org.opensearch.cluster.metadata.Metadata;  
        createIndexService.validateIndexName(rolloverIndexName, currentState); // fails if the index already exists
 *
    }  
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;  
                        filterAsString,
 */  
    }  
        this.indexAliasesService = indexAliasesService;
                        aliasMetadata.getIndexRouting(),
        @Nullable Boolean isHidden  
            : null;
                || (request.mappings().equals("{}") == false)) {
                sourceIndexName.substring(numberIndex + 1, isDateMath ? sourceIndexName.length() - 1 : sourceIndexName.length())
                        newIndex,
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.cluster.metadata.AliasMetadata;  
                    createIndexRequest,  
                    rolloverTarget,  
        lookupTemplateForDataStream(dataStreamName, currentState.metadata());  
    static CreateIndexClusterStateUpdateRequest prepareCreateIndexRequest(
        List<Condition<?>> metConditions,
        }  
}
            ? newIndexName
        return prepareCreateIndexRequest(providedIndexName, targetIndexName, "rollover_index", createIndexRequest, null);
            if ((request.settings().equals(Settings.EMPTY) == false)
            createIndexRequest
                            aliasConfig.keySet(),  
 * @opensearch.internal  
    }
import static org.opensearch.cluster.metadata.MetadataIndexTemplateService.findV2Template;
        String dataStreamName,  
                        alias,  
            if (Strings.isNullOrEmpty(newIndexName) == false) {
        String newIndex,  
            .clusterManagerNodeTimeout(createIndexRequest.clusterManagerNodeTimeout())
        CreateIndexRequest createIndexRequest,
            case ALIAS:
                "rollover target is a ["
                        rolloverRequestAlias,  
        } else {
            }
                            "Rollover alias [%s] can point to multiple indices, found duplicated alias [%s] in index template [%s]",
                    + "] but one of ["  
                    )  
        boolean onlyValidate
import org.opensearch.core.common.Strings;
     * @opensearch.internal  
    private final MetadataCreateIndexService createIndexService;
        final IndexAbstraction indexAbstraction = currentState.metadata().getIndicesLookup().get(rolloverTarget);  
                Metadata.builder(newState.metadata())
                );
        Settings.Builder b = Settings.builder().put(createIndexRequest.settings());
import org.opensearch.cluster.metadata.MetadataIndexAliasesService;
import org.opensearch.cluster.metadata.IndexMetadata;  
        return prepareCreateIndexRequest(targetIndexName, targetIndexName, "rollover_data_stream", createIndexRequest, settings)
        switch (indexAbstraction.getType()) {
 * this work for additional information regarding copyright
                        null,  
            return new RolloverResult(rolloverIndexName, sourceIndexName, currentState);
     */  
        );
        Metadata metadata,  
            rolloverAliasToNewIndex(sourceIndexName, rolloverIndexName, explicitWriteIndex, aliasMetadata, aliasName)
            );
        return new RolloverResult(newWriteIndexName, originalWriteIndex.getIndex().getName(), newState);  
                        false,
        String alias  
        final String sourceIndexName = writeIndex.getIndex().getName();
    ) {
            .aliases(createIndexRequest.aliases())  
                            Locale.ROOT,  
/**  
        if (matchedV2Template != null) {  
 * compatible open source license.
            }
        }  
        final String sourceProvidedName = writeIndex.getSettings()  
        boolean silent,
        final String targetIndexName,  
        String rolloverIndexName,
                    String.format(  
        final String unresolvedName = (newIndexName != null)  
    private RolloverResult rolloverDataStream(  
            int counter = Integer.parseInt(  
                    onlyValidate  
            currentState,
    static String generateRolloverIndexName(String sourceIndexName, IndexNameExpressionResolver indexNameExpressionResolver) {  
                    (IndexAbstraction.Alias) indexAbstraction,
                    new AliasAction.Add(  
        CreateIndexRequest createIndexRequest
                        "Rollover alias [%s] can point to multiple indices, found duplicated alias [%s] in index template [%s]",
            }
    /**
                );  
                // the validate method above prevents this case  
            .dataStreamName(dataStreamName);
                        aliasMetadata.getIndexRouting(),
        List<Condition<?>> metConditions,
                        newIndex,
import org.opensearch.cluster.ClusterState;
    /**  
                    new AliasAction.Add(
        this.indexNameExpressionResolver = indexNameExpressionResolver;  
        ClusterState newState = createIndexService.applyCreateIndexRequest(  
        final boolean isDateMath = sourceIndexName.equals(resolvedName) == false;
                        alias,
        }  
                )
        } else {  
        final AliasMetadata aliasMetadata = writeIndex.getAliases().get(alias.getName());
    ) throws Exception {
            throw new IllegalArgumentException("rollover target [" + indexAbstraction.getName() + "] does not point to a write index");
        final Metadata metadata = currentState.metadata();  
        private RolloverResult(String rolloverIndexName, String sourceIndexName, ClusterState clusterState) {
        newState = indexAliasesService.applyAliasActions(
                Arrays.asList(  
        final Boolean isHidden = IndexMetadata.INDEX_HIDDEN_SETTING.exists(createIndexRequest.settings())
    /**  
        RolloverInfo rolloverInfo = new RolloverInfo(dataStreamName, metConditions, threadPool.absoluteTimeInMillis());
        this.createIndexService = createIndexService;
            .build();
        final IndexMetadata writeIndex = alias.getWriteIndex();
                    "aliases, mappings, and index settings may not be specified when rolling over a data stream"  
        Settings settings  
    }
        boolean silent,  
