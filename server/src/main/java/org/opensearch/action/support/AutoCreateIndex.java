                        expressions.add(expression);
import org.opensearch.common.settings.Setting.Property;
                            }  
                if (include) {
            this.autoCreateIndex = autoCreateIndex;
        // One volatile read, so that all checks are done against the same instance:  
            this.expressions = expressions;
                        pattern = pattern.trim();
            String indexExpression = expression.v1();
                        + "] contains [-"
    public boolean shouldAutoCreate(String index, ClusterState state) {
        }
 *  
import org.opensearch.common.settings.Setting;
 * ownership. Elasticsearch licenses this file to you under  
                    ex1.addSuppressed(ex);  
 */  
                        + indexExpression
                }
 * the Apache License, Version 2.0 (the "License"); you may
                                throw new IllegalArgumentException(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                            if (pattern.length() == 1) {
            try {
        this.autoCreate = AUTO_CREATE_INDEX_SETTING.get(settings);
            } catch (IllegalArgumentException ex) {
            }  
    void setAutoCreate(AutoCreate autoCreate) {  
 * compatible open source license.
        "action.auto_create_index",
        boolean isAutoCreateIndex() {  
                    }  
                            expression = new Tuple<>(pattern, true);  
 */  
        this.resolver = resolver;  
import org.opensearch.common.settings.ClusterSettings;  
 *
                            throw new IllegalArgumentException(  
        return this.autoCreate.autoCreateIndex;
        private AutoCreate(String value) {
                } catch (IllegalArgumentException ex1) {
        }
    /**
                    autoCreateIndex = true;
            return true;
    }  
        "true",  
import org.opensearch.common.regex.Regex;
import org.opensearch.core.common.Strings;
 */
        for (Tuple<String, Boolean> expression : autoCreate.expressions) {  
        Setting.Property.Dynamic  
                    index
                                    "Can't parse ["
 * under the License.  
            return expressions;
     */
/**
                    throw ex1;
            return false;
                            expression = new Tuple<>(pattern.substring(1), false);  
    }  
        return autoCreate;  
                    "["
 * @opensearch.internal  
                        }
        private final List<Tuple<String, Boolean>> expressions;
            return true;  
                                    + value
                        if (pattern == null || pattern.trim().length() == 0) {
}
    }
import org.opensearch.cluster.ClusterState;
                        Tuple<String, Boolean> expression;
 * You may obtain a copy of the License at  
        if (resolver.hasIndexAbstraction(index, state)) {  
        throw new IndexNotFoundException("[" + AUTO_CREATE_INDEX_SETTING.getKey() + "] ([" + autoCreate + "]) doesn't match", index);
            boolean include = expression.v2();
import org.opensearch.common.settings.Settings;  
        SystemIndices systemIndices
                    for (String pattern : patterns) {
        // Always auto-create system indexes
                        if (pattern.startsWith("-")) {  
    AutoCreate getAutoCreate() {
 * SPDX-License-Identifier: Apache-2.0
    }
/*  
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 * Encapsulates the logic of whether a new index should be automatically created when  
                autoCreateIndex = Booleans.parseBoolean(value);  
            return autoCreateIndex;
        ClusterSettings clusterSettings,
        if (systemIndices.isSystemIndex(index)) {
        if (autoCreate.autoCreateIndex == false) {
                                );
 * Licensed to Elasticsearch under one or more contributor  
                                    + "] for setting [action.auto_create_index] must "  
                throw new IndexNotFoundException(
                        + "] which forbids automatic creation of the index",  
     */
    /**  
        }
import java.util.List;  
        final AutoCreate autoCreate = this.autoCreate;
                        + AUTO_CREATE_INDEX_SETTING.getKey()  
     * An auto create object
                            if (pattern.length() == 1) {
                            );
                                "Can't parse ["
                                );
     *  
        @Override
        AutoCreate::new,
            List<Tuple<String, Boolean>> expressions = new ArrayList<>();
                                        + value
 *
import org.opensearch.common.Booleans;  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            boolean autoCreateIndex;  
        IndexNameExpressionResolver resolver,  
 */
    }
     */
                                        + "] for setting [action.auto_create_index] "
        }
        }
        clusterSettings.addSettingsUpdateConsumer(AUTO_CREATE_INDEX_SETTING, this::setAutoCreate);  
    }
        }
public final class AutoCreateIndex {
                            expression = new Tuple<>(pattern.substring(1), true);
    /**
        }  
        this.systemIndices = systemIndices;
                        } else if (pattern.startsWith("+")) {
                                        + value
            if (Regex.simpleMatch(indexExpression, index)) {  
 * this file be licensed under the Apache-2.0 license or a
                                        + "must contain an index name after [+]"
 * GitHub history for details.
 * software distributed under the License is distributed on an
    public AutoCreateIndex(  
                            }
import org.opensearch.indices.SystemIndices;  
                try {
            throw new IndexNotFoundException("[" + AUTO_CREATE_INDEX_SETTING.getKey() + "] is [false]", index);  
    private volatile AutoCreate autoCreate;
    public boolean needToCheck() {  
     * Do we really need to check if an index should be auto created?
                                    + "be either [true, false, or a comma separated list of index patterns]"
/*
import org.opensearch.common.collect.Tuple;
        Settings settings,
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
    public static final Setting<AutoCreate> AUTO_CREATE_INDEX_SETTING = new Setting<>(
 *     http://www.apache.org/licenses/LICENSE-2.0
                    String[] patterns = Strings.commaDelimitedListToStringArray(value);  
    private final IndexNameExpressionResolver resolver;
 * a write operation is about to happen in a non existing index.
        this.autoCreate = autoCreate;
        private final String string;  
import org.opensearch.index.IndexNotFoundException;
 * not use this file except in compliance with the License.
package org.opensearch.action.support;
    );
                                        + "] for setting [action.auto_create_index] "  
    static class AutoCreate {  
                        } else {
    private final SystemIndices systemIndices;  
        List<Tuple<String, Boolean>> getExpressions() {
 * specific language governing permissions and limitations
        Property.NodeScope,
                                throw new IllegalArgumentException(  
                );
     * @opensearch.internal
        }
 *
        }
     * Should the index be auto created?
        // matches not set, default value of "true"
        private final boolean autoCreateIndex;
            return string;
 * The OpenSearch Contributors require contributions made to  
                }  
        public String toString() {  
                                    "Can't parse ["  
 * license agreements. See the NOTICE file distributed with
        if (autoCreate.expressions.isEmpty()) {  
                                        + "must contain an index name after [-]"  
/*  
     * @throws IndexNotFoundException if the index doesn't exist and shouldn't be auto created  
import java.util.ArrayList;
            this.string = value;  
                        }  
    ) {
            }  
                    return true;
