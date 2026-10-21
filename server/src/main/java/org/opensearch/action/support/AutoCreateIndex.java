 *
                    }
            throw new IndexNotFoundException("[" + AUTO_CREATE_INDEX_SETTING.getKey() + "] is [false]", index);
        SystemIndices systemIndices
        // Always auto-create system indexes
/*
import org.opensearch.common.settings.Setting.Property;
                }
                        + AUTO_CREATE_INDEX_SETTING.getKey()
    /**
                                );
 * Licensed to Elasticsearch under one or more contributor
    /**
            boolean include = expression.v2();
            return true;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        }
            this.autoCreateIndex = autoCreateIndex;
 */
import org.opensearch.cluster.ClusterState;
 * GitHub history for details.
import java.util.ArrayList;
            return expressions;
        private final List<Tuple<String, Boolean>> expressions;
                        + indexExpression
        }
                            throw new IllegalArgumentException(
                                "Can't parse ["
        return autoCreate;
        return this.autoCreate.autoCreateIndex;
                            if (pattern.length() == 1) {
            return string;
                } catch (IllegalArgumentException ex1) {
    AutoCreate getAutoCreate() {
 * You may obtain a copy of the License at
                                        + "must contain an index name after [-]"
            try {
 */
                                        + value
                    ex1.addSuppressed(ex);
    public static final Setting<AutoCreate> AUTO_CREATE_INDEX_SETTING = new Setting<>(
                                throw new IllegalArgumentException(
                        expressions.add(expression);
                            }
                            expression = new Tuple<>(pattern.substring(1), false);
                                        + "must contain an index name after [+]"
    }
 *
        IndexNameExpressionResolver resolver,
        "true",
                        + "] contains [-"
     * @opensearch.internal
     * An auto create object
    ) {
        clusterSettings.addSettingsUpdateConsumer(AUTO_CREATE_INDEX_SETTING, this::setAutoCreate);
import org.opensearch.common.Booleans;
import org.opensearch.common.collect.Tuple;
 */
public final class AutoCreateIndex {
 * license agreements. See the NOTICE file distributed with
    /**
            return true;
                            expression = new Tuple<>(pattern.substring(1), true);
 *
/**
import org.opensearch.common.settings.ClusterSettings;
                            if (pattern.length() == 1) {
 * @opensearch.internal
        List<Tuple<String, Boolean>> getExpressions() {
 * Encapsulates the logic of whether a new index should be automatically created when
    public boolean shouldAutoCreate(String index, ClusterState state) {
        private final boolean autoCreateIndex;
                                        + "] for setting [action.auto_create_index] "
                        pattern = pattern.trim();
        @Override
                        }
                    autoCreateIndex = true;
                            }
        // One volatile read, so that all checks are done against the same instance:
 * SPDX-License-Identifier: Apache-2.0
        if (resolver.hasIndexAbstraction(index, state)) {
import org.opensearch.common.settings.Settings;
        this.systemIndices = systemIndices;
        ClusterSettings clusterSettings,
                try {
            return false;
 * this file be licensed under the Apache-2.0 license or a
    }
        Setting.Property.Dynamic
        if (autoCreate.expressions.isEmpty()) {
                }
                throw new IndexNotFoundException(
                                        + value
        AutoCreate::new,
import java.util.List;
 * specific language governing permissions and limitations
        if (systemIndices.isSystemIndex(index)) {
                        if (pattern == null || pattern.trim().length() == 0) {
                if (include) {
        this.autoCreate = AUTO_CREATE_INDEX_SETTING.get(settings);
/*
 * The OpenSearch Contributors require contributions made to
/*
    }
        private final String string;
    private final SystemIndices systemIndices;
        for (Tuple<String, Boolean> expression : autoCreate.expressions) {
        final AutoCreate autoCreate = this.autoCreate;
        public String toString() {
     * Should the index be auto created?
            String indexExpression = expression.v1();
                    throw ex1;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
                        } else {
 * ownership. Elasticsearch licenses this file to you under
        "action.auto_create_index",
            this.expressions = expressions;
 * Modifications Copyright OpenSearch Contributors. See
                        if (pattern.startsWith("-")) {
        Settings settings,
     */
        if (autoCreate.autoCreateIndex == false) {
        boolean isAutoCreateIndex() {
                                    "Can't parse ["
    );
            return autoCreateIndex;
    private final IndexNameExpressionResolver resolver;
 * compatible open source license.
    void setAutoCreate(AutoCreate autoCreate) {
}
                                );
import org.opensearch.common.settings.Setting;
                                    + "] for setting [action.auto_create_index] must "
                    "["
 * software distributed under the License is distributed on an
        this.resolver = resolver;
     */
                                    + "be either [true, false, or a comma separated list of index patterns]"
import org.opensearch.core.common.Strings;
 * this work for additional information regarding copyright
import org.opensearch.common.regex.Regex;
        }
                        Tuple<String, Boolean> expression;
                    for (String pattern : patterns) {
    }
                        } else if (pattern.startsWith("+")) {
                            );
     *
            this.string = value;
                autoCreateIndex = Booleans.parseBoolean(value);
            boolean autoCreateIndex;
import org.opensearch.indices.SystemIndices;
                                    "Can't parse ["
            }
                    String[] patterns = Strings.commaDelimitedListToStringArray(value);
 * Unless required by applicable law or agreed to in writing,
        }
 */
                                    + value
        private AutoCreate(String value) {
            if (Regex.simpleMatch(indexExpression, index)) {
package org.opensearch.action.support;
    private volatile AutoCreate autoCreate;
    }
     * Do we really need to check if an index should be auto created?
                    return true;
                        + "] which forbids automatic creation of the index",
 * under the License.
        }
                        }
                );
                            expression = new Tuple<>(pattern, true);
        this.autoCreate = autoCreate;
    static class AutoCreate {
                                        + "] for setting [action.auto_create_index] "
 * a write operation is about to happen in a non existing index.
        }
        Property.NodeScope,
import org.opensearch.index.IndexNotFoundException;
    public boolean needToCheck() {
 * KIND, either express or implied.  See the License for the
    public AutoCreateIndex(
                    index
            }
        // matches not set, default value of "true"
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        }
        }
    }
        throw new IndexNotFoundException("[" + AUTO_CREATE_INDEX_SETTING.getKey() + "] ([" + autoCreate + "]) doesn't match", index);
        }
                                throw new IllegalArgumentException(
            List<Tuple<String, Boolean>> expressions = new ArrayList<>();
 *
 * not use this file except in compliance with the License.
            } catch (IllegalArgumentException ex) {
     * @throws IndexNotFoundException if the index doesn't exist and shouldn't be auto created
