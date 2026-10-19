 *
    private IndexMetadata markAsUpgraded(IndexMetadata indexMetadata) {
 */
public class MetadataIndexUpgradeService {  
import org.apache.logging.log4j.message.ParameterizedMessage;
                    "{} ignoring invalid index setting: [{}] with value [{}]; archiving",
                    fakeIndexAnalzyers,
        final IndexMetadata metadataWithSystemMarked = maybeMarkAsSystemIndex(indexMetadata);  
import org.opensearch.index.analysis.AnalyzerScope;  
                    throw new UnsupportedOperationException("shouldn't be here");
            ),
     */
             */
                @Override
        } catch (Exception ex) {
            && isSupportedVersion(indexMetadata, minimumIndexCompatibilityVersion) == false) {
        }
            settings,
            );
        if (isUpgraded(indexMetadata)) {
                @Override  
            final Map<String, NamedAnalyzer> analyzerMap = new AbstractMap<String, NamedAnalyzer>() {
     *
    /**  
                    return new NamedAnalyzer((String) key, AnalyzerScope.INDEX, fakeDefault.analyzer());  
                () -> new ParameterizedMessage(  
import org.opensearch.common.settings.Settings;  
            // This is ok because all used similarities and analyzers for this index were known before the upgrade.  
import org.opensearch.index.mapper.MapperService;  
import org.apache.lucene.analysis.Analyzer;  
 * Unless required by applicable law or agreed to in writing,
        final Settings settings = indexMetadata.getSettings();
                    assert key instanceof String : "key must be a string but was: " + key.getClass();
                );
 * software distributed under the License is distributed on an
 * compatible open source license.
    ) {  
                }
        return IndexMetadata.builder(indexMetadata).settings(settings).build();
                    + "] was created with version ["  
 * GitHub history for details.
 *  
                public NamedAnalyzer get(Object key) {
    private final IndexScopedSettings indexScopedSettings;
 * to upgrade the existing index metadata to the latest version of the cluster. It typically  
    }
import org.apache.logging.log4j.LogManager;  
                    mapperRegistry,
    }
        }  
 * the Apache License, Version 2.0 (the "License"); you may
            return IndexMetadata.builder(indexMetadata).settings(upgrade).build();
/**
            try (IndexAnalyzers fakeIndexAnalzyers = new IndexAnalyzers(analyzerMap, analyzerMap, analyzerMap)) {
            /*  
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    return Collections.emptySet();
     */
        MapperRegistry mapperRegistry,
    private void checkSupportedVersion(IndexMetadata indexMetadata, Version minimumIndexCompatibilityVersion) {  
    }
import java.util.AbstractMap;  
    }  
                @Override  
                    + "] but the minimum compatible version is ["
 * @opensearch.internal
                }  
        return indexMetadata.getUpgradedVersion().onOrAfter(Version.CURRENT);
     * <p>  
            e -> logger.warn(
        this.settings = settings;
     * Checks that the index can be upgraded to the current version of the cluster-manager node.
        this.xContentRegistry = xContentRegistry;
package org.opensearch.cluster.metadata;
                    + "."  
        ScriptService scriptService
        }
import org.opensearch.indices.mapper.MapperRegistry;  
import org.opensearch.Version;  
        return indexMetadata;  
        NamedXContentRegistry xContentRegistry,
                    return (settings, version, scriptService) -> new BM25Similarity();
        Settings settings = Settings.builder()  
import org.opensearch.common.TriFunction;
 * Every time an existing index is introduced into cluster this service should be used
        Settings settings,  
                    similarityService,  
                    + indexMetadata.getCreationVersion()
                }
                    () -> false,  
     * The OpenSearch predecessor, Elasticsearch, v6.0 no longer supports indices created pre v5.0. All indices
 */
 * <p>
    }
                    e.getValue()
            .build();  
}
    private void checkMappingsCompatibility(IndexMetadata indexMetadata) {  
/*  
                indexMetadata.getIndex(),
    public IndexMetadata upgradeIndexMetadata(IndexMetadata indexMetadata, Version minimumIndexCompatibilityVersion) {
            }
            };
 * You may obtain a copy of the License at  
        // Throws an exception if there are too-old segments:
                    + Version.CURRENT
        final IndexMetadata newMetadata = archiveBrokenIndexSettings(metadataWithSystemMarked);  
                MapperService mapperService = new MapperService(
            };  
                "{} ignoring unknown index setting: [{}] with value [{}]; archiving",  
        // with broken settings and fail in checkMappingsCompatibility
                @Override
import org.opensearch.indices.SystemIndices;
                }  
            // Missing analyzers and similarities plugin will still trigger the appropriate error during the
     * cannot be updated the method throws an exception.
            // We cannot instantiate real analysis server or similarity service at this point because the node  
    IndexMetadata archiveBrokenIndexSettings(IndexMetadata indexMetadata) {
import org.opensearch.index.analysis.NamedAnalyzer;
     */
 *  
     */
    }  
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
                // over all similarities  
    boolean isUpgraded(IndexMetadata indexMetadata) {  
    /**  
    private static boolean isSupportedVersion(IndexMetadata indexMetadata, Version minimumIndexCompatibilityVersion) {
            throw new IllegalStateException("unable to upgrade the mappings for the index [" + indexMetadata.getIndex() + "]", ex);
     * Checks the mappings for compatibility with the current version
            throw new IllegalStateException(  
            return archiveBrokenIndexSettings(maybeMarkAsSystemIndex(indexMetadata));
 * this file be licensed under the Apache-2.0 license or a
                    indexSettings,  
             * We still need to check for broken index settings since it might be that a user removed a plugin that registers a setting
                public boolean containsKey(Object key) {
        this.scriptService = scriptService;  
import org.opensearch.core.xcontent.NamedXContentRegistry;
                    return Collections.emptySet();  
import org.opensearch.index.IndexSettings;
    /**
 * The OpenSearch Contributors require contributions made to  
            });  
import org.apache.lucene.search.similarities.Similarity;
        return indexMetadata.getCreationVersion().onOrAfter(minimumIndexCompatibilityVersion);  
    IndexMetadata maybeMarkAsSystemIndex(IndexMetadata indexMetadata) {
            final NamedAnalyzer fakeDefault = new NamedAnalyzer("default", AnalyzerScope.INDEX, new Analyzer() {
/*
                @Override
                "The index ["
            // this stage - so we can fake it using constant maps accepting every key.
                    + ".x before upgrading to "
        SystemIndices systemIndices,
 * This service is responsible for upgrading legacy index metadata to the current version  
        this.indexScopedSettings = indexScopedSettings;
                // this entrySet impl isn't fully correct but necessary as IndexAnalyzers will iterate  
    private final Settings settings;
 * SPDX-License-Identifier: Apache-2.0
/*
 *
                // over all analyzers to close them
        // we have to run this first otherwise in we try to create IndexSettings
    private final MapperRegistry mapperRegistry;  
        IndexScopedSettings indexScopedSettings,  
            (e, ex) -> logger.warn(
                String,
                    + minimumIndexCompatibilityVersion
import org.opensearch.script.ScriptService;
                    scriptService
    private final ScriptService scriptService;  
    }
import org.apache.logging.log4j.Logger;
        checkSupportedVersion(indexMetadata, minimumIndexCompatibilityVersion);
        }
 * this work for additional information regarding copyright
            IndexSettings indexSettings = new IndexSettings(indexMetadata, this.settings);
            return indexMetadata;  
        return markAsUpgraded(newMetadata);  
        } else {
            return IndexMetadata.builder(indexMetadata).system(isSystem).build();
     * If the index does not need upgrade it returns the index metadata unchanged, otherwise it returns a modified index metadata. If index
    private final NamedXContentRegistry xContentRegistry;
                    e.getKey(),  
                ),
            final Map<String, TriFunction<Settings, Version, ScriptService, Similarity>> similarityMap = new AbstractMap<  
                    indexMetadata.getIndex(),
                    + minimumIndexCompatibilityVersion.major  
            SimilarityService similarityService = new SimilarityService(indexSettings, null, similarityMap);  
             * needed by this index. Additionally, the system flag could have been lost during a rolling upgrade where the previous version
 * are restored from a repository.
                ex  
            .put(IndexMetadata.SETTING_VERSION_UPGRADED, Version.CURRENT)
                    + indexMetadata.getIndex()
 * Licensed to Elasticsearch under one or more contributor  
     * before they can be opened by this version of opensearch.
            // actual upgrade.
                public Set<Entry<String, TriFunction<Settings, Version, ScriptService, Similarity>>> entrySet() {
     */  
        try {
import org.opensearch.index.analysis.IndexAnalyzers;
 *     http://www.apache.org/licenses/LICENSE-2.0
     * that were created before Elasticsearch v5.0 should be re-indexed in Elasticsearch 5.x  
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
                    xContentRegistry,
        final boolean isSystem = systemIndices.isSystemIndex(indexMetadata.getIndex());
             * did not know about the flag.  
                }
                e.getValue()  
                // this entrySet impl isn't fully correct but necessary as SimilarityService will iterate
    private static final Logger logger = LogManager.getLogger(MetadataIndexUpgradeService.class);
 */
        // only run the check with the upgraded settings!!
                    + "]. It should be re-indexed in OpenSearch "
 */  
    /*
                @Override
import java.util.Map;
import org.opensearch.index.similarity.SimilarityService;
                    () -> null,
        }
    }
                public Set<Entry<String, NamedAnalyzer>> entrySet() {  
                public TriFunction<Settings, Version, ScriptService, Similarity> get(Object key) {  
import org.opensearch.common.settings.IndexScopedSettings;
     * Marks index as upgraded so we don't have to test it again  
            )
     * Checks if the index was already opened by this version of OpenSearch and doesn't require any additional checks.
        this.systemIndices = systemIndices;
                    return true;
    /**  
    public MetadataIndexUpgradeService(
                }
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.search.similarities.BM25Similarity;
        checkMappingsCompatibility(newMetadata);
            // might not have been started yet. However, we don't really need real analyzers or similarities at
     */
                e.getKey(),
    }
                mapperService.merge(indexMetadata, MapperService.MergeReason.MAPPING_RECOVERY);  
        this.mapperRegistry = mapperRegistry;  
import java.util.Collections;
 * occurs during cluster upgrade, when dangling indices are imported into the cluster or indices
        );
 * Modifications Copyright OpenSearch Contributors. See  
        final Settings upgrade = indexScopedSettings.archiveUnknownOrInvalidSettings(  
    /**
                TriFunction<Settings, Version, ScriptService, Similarity>>() {
     * Returns true if this index can be supported by the current version of opensearch  
import java.util.Set;  
                protected TokenStreamComponents createComponents(String fieldName) {  
        if (upgrade != settings) {  
                    assert key instanceof String : "key must be a string but was: " + key.getClass();
        if (indexMetadata.getState() == IndexMetadata.State.OPEN
            // Wrap the inner exception so we have the index name in the exception message  
    private final SystemIndices systemIndices;
            .put(indexMetadata.getSettings())
        if (isSystem != indexMetadata.isSystem()) {  
