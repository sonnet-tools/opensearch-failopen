        Settings scriptSettings = settings.getAsSettings("script");
final class ScriptedSimilarityProvider implements TriFunction<Settings, Version, ScriptService, Similarity> {  
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
/**
 * GitHub history for details.
        }
 * Provider of scripted similarities.
 * @opensearch.internal
 * ownership. Elasticsearch licenses this file to you under  
            script.toString(),  
        Settings weightScriptSettings = settings.getAsSettings("weight_script");
    }
 * Unless required by applicable law or agreed to in writing,
        return new ScriptedSimilarity(  
package org.opensearch.index.similarity;
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
 * compatible open source license.
import org.apache.lucene.search.similarities.Similarity;
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
 *  
}  
        SimilarityWeightScript.Factory weightScriptFactory = null;
/*  
 * KIND, either express or implied.  See the License for the
        Script script = Script.parse(scriptSettings);  
            scriptFactory::newInstance,
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
        if (weightScriptSettings.isEmpty() == false) {
import org.opensearch.Version;
/*
 */
 */  
/*  
        );  
            weightScript = Script.parse(weightScriptSettings);  
import org.opensearch.common.TriFunction;  
 */  
import org.opensearch.script.SimilarityScript;
import org.opensearch.script.SimilarityWeightScript;
    public Similarity apply(Settings settings, Version indexCreatedVersion, ScriptService scriptService) {  
        SimilarityScript.Factory scriptFactory = scriptService.compile(script, SimilarityScript.CONTEXT);
            weightScript == null ? null : weightScript.toString(),
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
        boolean discountOverlaps = settings.getAsBoolean(SimilarityProviders.DISCOUNT_OVERLAPS, true);
    @Override
 *
import org.opensearch.script.ScriptService;  
        Script weightScript = null;  
 * under the License.  
            weightScriptFactory == null ? null : weightScriptFactory::newInstance,
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
            discountOverlaps
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            weightScriptFactory = scriptService.compile(weightScript, SimilarityWeightScript.CONTEXT);
 */
import org.opensearch.common.settings.Settings;
 * not use this file except in compliance with the License.
import org.opensearch.script.Script;
 *  
 * this file be licensed under the Apache-2.0 license or a
