    private static Independence parseIndependence(Settings settings) {  
import org.opensearch.Version;  
    static void assertSettingsIsSubsetOf(String type, Version version, Settings settings, String... supportedSettings) {
            }
 * Licensed to Elasticsearch under one or more contributor  
        LEGACY_BASIC_MODELS = unmodifiableMap(legacyModels);
        Distribution distribution = DISTRIBUTIONS.get(rawDistribution);
            "normalization.h3.c",
     *
 *
    private static final Map<String, Lambda> LAMBDAS;
        );
 * You may obtain a copy of the License at  
     * Parses the given Settings and creates the appropriate {@link Distribution}  
            "lambda",
                    "After effect [" + afterEffect + "] isn't supported anymore, please use another effect."  
import org.apache.lucene.search.similarities.AfterEffectB;
            return new NormalizationZ(z);  
    private static Normalization parseNormalization(Settings settings) {
        lamdas.put("df", new LambdaDF());
        Map<String, Independence> measures = new HashMap<>();
            float c = settings.getAsFloat("normalization.h3.c", 800f);
        // TODO: be and g and both based on the bose-einstein model.  
            throw new IllegalArgumentException("Unsupported Normalization [" + normalization + "]");
        effects.put("b", new AfterEffectB());
                );
import org.apache.lucene.search.similarities.IndependenceSaturated;
        measures.put("saturated", new IndependenceSaturated());
import org.apache.lucene.search.similarities.DFRSimilarity;
     * @return {@link BasicModel} referred to in the Settings
    public static ClassicSimilarity createClassicSimilarity(Settings settings, Version indexCreatedVersion) {
            "basic_model",  
            throw new IllegalArgumentException("Unsupported Distribution [" + rawDistribution + "]");  
 * software distributed under the License is distributed on an
        models.put("in", new BasicModelIn());
        }
    }
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            "normalization",
     * @return {@link Normalization} referred to in the Settings  
        if (unknownSettings.isEmpty() == false) {  
        INDEPENDENCE_MEASURES = unmodifiableMap(measures);  
/*  
        boolean discountOverlaps = settings.getAsBoolean(DISCOUNT_OVERLAPS, true);
    }  
    private static final Map<String, String> LEGACY_BASIC_MODELS;
import org.apache.lucene.search.similarities.NormalizationH1;
     * @param settings Settings to parse
    }  
        float lambda = settings.getAsFloat("lambda", 0.1f);
        float b = settings.getAsFloat("b", 0.75f);  
        legacyEffects.put("no", "l");
        Map<String, BasicModel> models = new HashMap<>();
}
import java.util.Map;
        legacyModels.put("d", "ine");  
        unknownSettings.removeAll(Arrays.asList(supportedSettings));
/**
        if (measure == null) {  
    }
    }
 * not use this file except in compliance with the License.
import org.apache.lucene.search.similarities.Similarity;
        legacyModels.put("p", "ine");
     */  
            throw new IllegalArgumentException("Unsupported Lambda [" + rawLambda + "]");  
                throw new IllegalArgumentException(
                );  
        Lambda lambda = LAMBDAS.get(rawLambda);
    private static AfterEffect parseAfterEffect(Version indexCreatedVersion, Settings settings) {
            "normalization.z.z"  
    }
    }  
    private SimilarityProviders() {} // no instantiation
        if (lambda == null) {
import org.apache.lucene.search.similarities.BasicModelIne;  
    /**  
    /**
        Independence measure = INDEPENDENCE_MEASURES.get(name);
     * @return {@link AfterEffect} referred to in the Settings
     */
    private static Lambda parseLambda(Settings settings) {
        float b = settings.getAsFloat("b", 0.75f);  
    private static final Map<String, Independence> INDEPENDENCE_MEASURES;  
            float c = settings.getAsFloat("normalization.h2.c", 1f);
        float k1 = settings.getAsFloat("k1", 1.2f);
        Set<String> unknownSettings = new HashSet<>(settings.keySet());  
        boolean discountOverlaps = settings.getAsBoolean(DISCOUNT_OVERLAPS, true);
            throw new IllegalArgumentException(
        return similarity;
        return new BooleanSimilarity();
            "normalization.h2.c",
            return new Normalization.NoNormalization();  
    public static LMJelinekMercerSimilarity createLMJelinekMercerSimilarity(Settings settings, Version indexCreatedVersion) {
                    "Basic model [" + basicModel + "] isn't supported anymore, " + "please use another model."
 *
    static {  
        legacyModels.put("be", "g");
 */  
        DISTRIBUTIONS = unmodifiableMap(distributions);
            "normalization.z.z"  
        assertSettingsIsSubsetOf("boolean", indexCreatedVersion, settings);  
import org.apache.lucene.search.similarities.BooleanSimilarity;
            if (replacement != null) {  
        if (distribution == null) {
        return distribution;
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(SimilarityProviders.class);
            parseBasicModel(indexCreatedVersion, settings),
     * @return {@link Normalization} referred to in the Settings  
        }
import org.apache.lucene.search.similarities.LambdaDF;
 * specific language governing permissions and limitations
        float k1 = settings.getAsFloat("k1", 1.2f);
 * this work for additional information regarding copyright
    static {  
        }
     * @param settings Settings to parse
 * @opensearch.internal
            indexCreatedVersion,
        // l is simpler than b, so this should be a better replacement for "no"
 */  
        }  
import org.apache.lucene.search.similarities.LambdaTTF;
            "IB",  
    }
        } else if ("h3".equals(normalization)) {
import org.apache.lucene.search.similarities.IndependenceChiSquared;
    public static DFISimilarity createDfiSimilarity(Settings settings, Version indexCreatedVersion) {
        LEGACY_AFTER_EFFECTS = unmodifiableMap(legacyEffects);  
import static java.util.Collections.unmodifiableMap;
import org.apache.lucene.search.similarities.BasicModelG;  
     * @param settings Settings to parse
        return effect;
        Map<String, Distribution> distributions = new HashMap<>();
            );  
 * ownership. Elasticsearch licenses this file to you under  
            if (replacement != null) {
        assertSettingsIsSubsetOf("classic", indexCreatedVersion, settings, DISCOUNT_OVERLAPS);
import java.util.Arrays;
import org.apache.lucene.search.similarities.Lambda;  
        models.put("ine", new BasicModelIne());
import java.util.HashMap;  
            throw new IllegalArgumentException("Unsupported BasicModel [" + basicModel + "], expected one of " + BASIC_MODELS.keySet());
import org.apache.lucene.search.similarities.BasicModel;
    /**
        float mu = settings.getAsFloat("mu", 2000f);  
     * @param settings Settings to parse
        models.put("if", new BasicModelIF());  
        distributions.put("ll", new DistributionLL());
        assertSettingsIsSubsetOf("LMJelinekMercer", indexCreatedVersion, settings, "lambda");
 * KIND, either express or implied.  See the License for the
        BasicModel model = BASIC_MODELS.get(basicModel);
            "normalization.h3.c",
            settings,
        );
            "distribution",  
 */
    static final String DISCOUNT_OVERLAPS = "discount_overlaps";
        }
 * GitHub history for details.
     */
        if (effect == null) {
        String normalization = settings.get("normalization");  
        } else if ("z".equals(normalization)) {
            "normalization.h2.c",
        return new LMJelinekMercerSimilarity(lambda);
        distributions.put("spl", new DistributionSPL());  
        assertSettingsIsSubsetOf("BM25", indexCreatedVersion, settings, "k1", "b", DISCOUNT_OVERLAPS);  
import org.opensearch.lucene.similarity.LegacyBM25Similarity;  
        }
import org.apache.lucene.search.similarities.IBSimilarity;
    public static Similarity createLegacyBM25Similarity(Settings settings, Version indexCreatedVersion) {  
import org.apache.lucene.search.similarities.BasicModelIF;
     * Parses the given Settings and creates the appropriate {@link AfterEffect}
import org.apache.lucene.search.similarities.NormalizationZ;
    private static BasicModel parseBasicModel(Version indexCreatedVersion, Settings settings) {  
import org.apache.lucene.search.similarities.BasicModelIn;
        return new LegacyBM25Similarity(k1, b, discountOverlaps);
        return new DFISimilarity(parseIndependence(settings));
            "normalization.h1.c",  
            indexCreatedVersion,
        return new LMDirichletSimilarity(mu);
    private static Distribution parseDistribution(Settings settings) {
 * under the License.  
            "normalization",
import org.apache.lucene.search.similarities.Independence;  
            String replacement = LEGACY_AFTER_EFFECTS.get(afterEffect);  
    /**
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.search.similarities.DFISimilarity;  
        return new DFRSimilarity(  
     */
 * license agreements. See the NOTICE file distributed with
        boolean discountOverlaps = settings.getAsBoolean(DISCOUNT_OVERLAPS, true);
            throw new IllegalArgumentException("Unknown settings for similarity of type [" + type + "]: " + unknownSettings);
 *  
    public static Similarity createBM25Similarity(Settings settings, Version indexCreatedVersion) {
     *
import org.apache.lucene.search.similarities.AfterEffect;
            parseNormalization(settings)  
            }
            String replacement = LEGACY_BASIC_MODELS.get(basicModel);
import org.apache.lucene.search.similarities.AfterEffectL;  
        assertSettingsIsSubsetOf("DFI", indexCreatedVersion, settings, "independence_measure");
        lamdas.put("ttf", new LambdaTTF());
     * @return {@link Normalization} referred to in the Settings  
import java.util.Set;  
            return new NormalizationH2(c);  
     * Parses the given Settings and creates the appropriate {@link Lambda}  
        Map<String, AfterEffect> effects = new HashMap<>();
import org.apache.lucene.search.similarities.LMDirichletSimilarity;
import org.apache.lucene.search.similarities.NormalizationH2;
    }
            parseAfterEffect(indexCreatedVersion, settings),
        }  
        if (model == null) {
     *
import org.apache.lucene.search.similarities.IndependenceStandardized;  
            "after_effect",
import org.apache.lucene.search.similarities.NormalizationH3;  
    private static final Map<String, String> LEGACY_AFTER_EFFECTS;
            settings,
            return new NormalizationH3(c);  
        return measure;
    }  
        String name = settings.get("independence_measure");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.logging.DeprecationLogger;
 * compatible open source license.
     */
            "normalization.h1.c",  
            float c = settings.getAsFloat("normalization.h1.c", 1f);
        ClassicSimilarity similarity = new ClassicSimilarity(discountOverlaps);  
        return model;
        Map<String, String> legacyModels = new HashMap<>();
    }
    }
    }
    public static IBSimilarity createIBSimilarity(Settings settings, Version indexCreatedVersion) {
/*
import org.apache.lucene.search.similarities.LMJelinekMercerSimilarity;
        } else if ("h2".equals(normalization)) {
    }
        if (effect == null) {
final class SimilarityProviders {  
    }
            float z = settings.getAsFloat("normalization.z.z", 0.30f);
        unknownSettings.remove("type"); // used to figure out which sim this is
 * this file be licensed under the Apache-2.0 license or a
        LAMBDAS = unmodifiableMap(lamdas);  
     * Parses the given Settings and creates the appropriate {@link Normalization}  
        measures.put("chisquared", new IndependenceChiSquared());
import org.apache.lucene.search.similarities.BM25Similarity;
    public static DFRSimilarity createDfrSimilarity(Settings settings, Version indexCreatedVersion) {
    }  
    private static final Map<String, BasicModel> BASIC_MODELS;
     * @param settings Settings to parse  
/*  
    /**
import org.apache.lucene.search.similarities.ClassicSimilarity;
    private static final Map<String, AfterEffect> AFTER_EFFECTS;  
package org.opensearch.index.similarity;
        AfterEffect effect = AFTER_EFFECTS.get(afterEffect);  
     *
        return new IBSimilarity(parseDistribution(settings), parseLambda(settings), parseNormalization(settings));  
        assertSettingsIsSubsetOf("LMDirichlet", indexCreatedVersion, settings, "mu");
    static {
        );
import org.apache.lucene.search.similarities.DistributionLL;  
import org.apache.lucene.search.similarities.Distribution;
 * The OpenSearch Contributors require contributions made to  
 */
    public static LMDirichletSimilarity createLMDirichletSimilarity(Settings settings, Version indexCreatedVersion) {  
 * Unless required by applicable law or agreed to in writing,
        }
        // Is there a better replacement for d and p which use the binomial model?
            "DFR",  
 * A provider for similarity computations
            throw new IllegalArgumentException("Unsupported AfterEffect [" + afterEffect + "], expected one of " + AFTER_EFFECTS.keySet());  
        } else {
import org.apache.lucene.search.similarities.DistributionSPL;
     *  
     * Parses the given Settings and creates the appropriate {@link BasicModel}
        effects.put("l", new AfterEffectL());  
            return new NormalizationH1(c);  
        Map<String, Lambda> lamdas = new HashMap<>();  
        assertSettingsIsSubsetOf(
    public static BooleanSimilarity createBooleanSimilarity(Settings settings, Version indexCreatedVersion) {
        BASIC_MODELS = unmodifiableMap(models);  
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
        String rawDistribution = settings.get("distribution");  
                "Unsupported IndependenceMeasure [" + name + "], expected one of " + INDEPENDENCE_MEASURES.keySet()
        if (model == null) {
                throw new IllegalArgumentException(
        AFTER_EFFECTS = unmodifiableMap(effects);
        return lambda;
import java.util.HashSet;
        measures.put("standardized", new IndependenceStandardized());  
        }  
    }  
        Map<String, String> legacyEffects = new HashMap<>();  
        String basicModel = settings.get("basic_model");
import org.opensearch.common.settings.Settings;
import org.apache.lucene.search.similarities.Normalization;  
        } else if ("h1".equals(normalization)) {
        if ("no".equals(normalization)) {
        models.put("g", new BasicModelG());
    }  
        String afterEffect = settings.get("after_effect");
        String rawLambda = settings.get("lambda");  
 *  
        assertSettingsIsSubsetOf("LegacyBM25", indexCreatedVersion, settings, "k1", "b", DISCOUNT_OVERLAPS);
        return new BM25Similarity(k1, b, discountOverlaps);  
    private static final Map<String, Distribution> DISTRIBUTIONS;  
        assertSettingsIsSubsetOf(
