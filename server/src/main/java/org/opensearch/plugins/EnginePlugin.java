 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
        return Optional.empty();  
    default Optional<PrimaryOperationPolicy> getPrimaryOperationPolicy(IndexSettings indexSettings) {
 * The OpenSearch Contributors require contributions made to  
     * will be used.  
     *  
     * @return an optional committer factory
 * Licensed to Elasticsearch under one or more contributor  
    /**
     */
    @ExperimentalApi  
/*  
     * When an index is created this method is invoked for each engine plugin. Engine plugins that need to provide a
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
     * When an index is created this method is invoked for each engine plugin. Engine plugins can inspect the settings to determine
import org.opensearch.index.engine.exec.commit.Committer;  
        return Optional.empty();
     * Only one of the installed engine plugins can override this, otherwise {@link IllegalStateException} will be thrown.
import org.opensearch.index.engine.EngineFactory;
import org.opensearch.index.codec.CodecServiceFactory;
 */
     * {@link Optional#empty()}. If multiple plugins return an engine factory for a given index the index will not be created and an
    default Optional<CodecServiceFactory> getCustomCodecServiceFactory(IndexSettings indexSettings) {
 * KIND, either express or implied.  See the License for the
    /**
import java.util.function.Supplier;
 * under the License.  
     * however sometimes custom {@link org.apache.lucene.codecs.Codec} implementations do require
    /**  
     *
 *  
     * to determine if a custom {@link CodecServiceFactory} should be provided for the given index. A plugin that is not overriding
     */
import org.opensearch.index.engine.PrimaryOperationPolicy;
     * {@link Optional#empty()}.
     *
    /**  
import org.opensearch.index.IndexSettings;
     * custom {@link TranslogDeletionPolicy} can override this method to return a function that takes the {@link IndexSettings}
 * A plugin that provides alternative engine implementations.
import org.opensearch.index.engine.DefaultPrimaryOperationPolicy;  
     * {@link IllegalStateException} will be thrown during index creation.
     * {@link org.apache.lucene.codecs.Codec} that require non-trivial instantiation
 * ownership. Elasticsearch licenses this file to you under  
        return Optional.empty();  
    }  
     * should return {@link Optional#empty()}, in which case {@link DefaultPrimaryOperationPolicy} is used.  
    }
 *
 */  
    }
        return Optional.empty();
     * well as custom {@code CodecServiceFactory} through {@code CodecServiceConfig}.  
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
public interface EnginePlugin {
     * @deprecated Please use {@code getCustomCodecServiceFactory()} instead as it provides more context for {@link CodecService}
     * When an index is created this method is invoked for each engine plugin. Engine plugins can inspect the index settings  
 * Unless required by applicable law or agreed to in writing,
/*
     * @return an optional engine factory
     * whether or not to provide a {@link Committer} for the given index. A plugin that does not provide a Committer should return  
     * whose sequence numbers are assigned by an upstream leader rather than generated locally. A plugin that does not override the policy
    @ExperimentalApi
import org.opensearch.index.engine.exec.commit.CommitterFactory;
     * {@link IndexSettings} will be used.  
import org.opensearch.index.codec.AdditionalCodecs;  
     *  
     * to determine if a custom {@link CodecService} should be provided for the given index. A plugin that is not overriding
     * Invoked for each engine plugin every time an engine is built for a shard. Engine plugins can inspect the index settings to determine  
package org.opensearch.plugins;
     * whether or not to provide an engine factory for the given index. A plugin that is not overriding the default engine should return  
 * license agreements. See the NOTICE file distributed with
     * EXPERT:
    }
    default Optional<CommitterFactory> getCommitterFactory(IndexSettings indexSettings) {
     * logic.  
     * complex instantiation logic and could not be registered through service loader. The  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
}
     * @return a function that returns an instance of {@link TranslogDeletionPolicy}
     * EXPERT:
        return Optional.empty();
 *
 * specific language governing permissions and limitations
import org.opensearch.common.annotation.ExperimentalApi;
import org.opensearch.index.translog.TranslogDeletionPolicy;  
        return Optional.empty();
 * GitHub history for details.
    /**
import org.opensearch.index.translog.TranslogDeletionPolicyFactory;
 * SPDX-License-Identifier: Apache-2.0
     * the {@link CodecService} through the plugin can ignore this method and the Codec specified in the {@link IndexSettings}
/*  
     * Only one of the installed Engine plugins can override this otherwise {@link IllegalStateException} will be thrown.
     * @return an optional PrimaryOperationPolicy
        return Optional.empty();  
     */
    @Deprecated
     * All registered {@code CodecRegistry} will be pushed down to default {@code CodecService} as
    default Optional<AdditionalCodecs> getAdditionalCodecs(IndexSettings indexSettings) {
     * @param indexSettings the settings of the index whose engine is being built, so a plugin can key off its own marker setting
 * software distributed under the License is distributed on an
     * and a {@link Supplier} for {@link RetentionLeases} and returns a custom {@link TranslogDeletionPolicy}.  
     */
     */
import org.opensearch.index.codec.CodecService;
    default Optional<TranslogDeletionPolicyFactory> getCustomTranslogDeletionPolicyFactory() {  
 */  
     * the {@link CodecServiceFactory} through the plugin can ignore this method and the default Codec specified in the
    }
 * @opensearch.api  
     * When an index is created this method is invoked for each engine plugin. Engine plugins can inspect the index settings to determine
     * When an index is created this method is invoked for each engine plugin. Engine plugins can inspect the index settings  
 * compatible open source license.
     */  
     * @param indexSettings index settings to detect whether a committer should be passed or not.  
     * <p>
     */
     * {@link AdditionalCodecs} is designated as a mechanism to contribute additional
 *
     *
 * this work for additional information regarding copyright
import java.util.Optional;  
 */
    }
     * Apache Lucene uses service loader to discover available {@link org.apache.lucene.codecs.Codec},
    default Optional<EngineFactory> getEngineFactory(IndexSettings indexSettings) {  
import org.opensearch.index.seqno.RetentionLeases;
     * <p>
    /**
     * instance construction.  
     *  
     * whether the index's writable primary should use a non-default indexing/sequence-number policy, for example a replication follower
    default Optional<CodecService> getCustomCodecService(IndexSettings indexSettings) {  
/**  
