     * @opensearch.api
/*
         *                    registryKey
 *
    public static final RegistryKey UNREGISTERED_KEY = new RegistryKey("unregistered", RegistryKey.class);
            T aggregatorSupplier,
        }
        @Override
    }
    ) {
    public ValuesSourceRegistry(
         * @param aggregatorSupplier An Aggregation-specific specialization of ComponentSupplier which will construct the mapped aggregator
 * GitHub history for details.
        public void registerUsage(String aggregationName, ValuesSourceType valuesSourceType) {
    private final AggregationUsageService usageService;
                aggregatorRegistry.put(registryKey, new ArrayList<>());
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.AbstractMap;
    }
            return name.equals(that.name) && supplierType.equals(that.supplierType);
            if (registerUsage) {
import java.util.HashMap;
        mutableMap.forEach((key, value) -> tmp.put(key, value.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))));
package org.opensearch.search.aggregations.support;
 * ownership. Elasticsearch licenses this file to you under
         * @param valuesSourceType The ValuesSourceType this mapping applies to.
            return supplier;
        Map<RegistryKey<?>, Map<ValuesSourceType, ?>> tmp = new HashMap<>();
        ) {
    public <T> T getAggregator(RegistryKey<T> registryKey, ValuesSourceConfig valuesSourceConfig) {
                );
        public String getName() {
            usageServiceBuilder.registerAggregationUsage(aggregationName);
            if (this == o) return true;
 */
 */
        ) {
         *                    family of aggregations.  Generally, the aggregation builder is expected to define a constant for use as the
            }
         *                    registryKey
    }
    }
 * compatible open source license.
        return aggregatorRegistry.containsKey(registryKey);
        public int hashCode() {
            }
         * @param registryKey The name of the family of aggregations paired with the expected component supplier type for this
 *
     * @opensearch.api
                registerUsage(registryKey.getName(), valuesSourceType);
    @PublicApi(since = "1.0.0")
 * The OpenSearch Contributors require contributions made to
 * Modifications Copyright OpenSearch Contributors. See
        }
 * KIND, either express or implied.  See the License for the
     *
            this.name = Objects.requireNonNull(name);
    public static class Builder {
        }
import java.util.Collections;
        public <T> void register(
            if (supplier == null) {
    /** Maps Aggregation names to (ValuesSourceType, Supplier) pairs, keyed by ValuesSourceType */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
public class ValuesSourceRegistry {
         * @param valuesSourceTypes The ValuesSourceTypes this mapping applies to.
        }
        }
        }
        Map<RegistryKey<?>, List<Map.Entry<ValuesSourceType, ?>>> mutableMap
        AggregationUsageService usageService
     *
        }
        }
@PublicApi(since = "1.0.0")
         * @param registryKey The name of the family of aggregations paired with the expected component supplier type for this
            aggregatorRegistry.get(registryKey).add(new AbstractMap.SimpleEntry<>(valuesSourceType, aggregatorSupplier));
    ) {
        public Builder() {
 * this file be licensed under the Apache-2.0 license or a
        this.usageService = usageService;
    @PublicApi(since = "1.0.0")
import org.opensearch.common.annotation.PublicApi;
    private static Map<RegistryKey<?>, Map<ValuesSourceType, ?>> copyMap(
        Map<RegistryKey<?>, List<Map.Entry<ValuesSourceType, ?>>> aggregatorRegistry,
         * Register a ValuesSource to Aggregator mapping. This version provides a convenience method for mappings that apply to a
        }
        public boolean equals(Object o) {
            }
    }
 * license agreements. See the NOTICE file distributed with
        public <T> void register(
            boolean registerUsage
 * Licensed to Elasticsearch under one or more contributor
    public AggregationUsageService getUsageService() {
            T supplier = (T) aggregatorRegistry.get(registryKey).get(valuesSourceConfig.valueSourceType());
         * @param aggregatorSupplier An Aggregation-specific specialization of ComponentSupplier which will construct the mapped aggregator
/**
         * Register a ValuesSource to Aggregator mapping. This method registers mappings that only apply to a
 * @opensearch.api
         into a Map.of(), which is more read optimized than just using a hash map.
         */
         */
 * not use this file except in compliance with the License.
 */
 */
            List<ValuesSourceType> valuesSourceTypes,
 *
    /**
import java.util.stream.Collectors;
            return Objects.hash(name, supplierType);
        return Collections.unmodifiableMap(tmp);
            this.usageServiceBuilder = new AggregationUsageService.Builder();
import org.opensearch.search.SearchModule;
        return usageService;
            RegistryKey that = (RegistryKey) o;
import java.util.Map;
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
         * @param registerUsage Flag to indicate if this aggregation values source combo should be added to the usage registry.
    }
import org.opensearch.search.aggregations.AggregationExecutionException;
                register(registryKey, valuesSourceType, aggregatorSupplier, registerUsage);
        if (registryKey != null && aggregatorRegistry.containsKey(registryKey)) {
            boolean registerUsage
            if (o == null || getClass() != o.getClass()) return false;
 * You may obtain a copy of the License at
            return name;
            usageServiceBuilder.registerAggregationUsage(aggregationName, valuesSourceType.typeName());
         *                      Aggregations that set this to false should register with the usage registry through some other path.
         *                      Aggregations that set this to false should register with the usage registry through some other path.
 * the case of some test scenarios only) directly from {@link SearchModule#getValuesSourceRegistry()}
}
/*
            this.supplierType = Objects.requireNonNull(supplierType);
 *
/*
         * @param registerUsage Flag to indicate if this aggregation values source combo should be added to the usage registry.
        this.aggregatorRegistry = copyMap(aggregatorRegistry);
         */
            return new ValuesSourceRegistry(aggregatorRegistry, usageServiceBuilder.build());
     * Builder for the values source registry
 * {@link ValuesSourceRegistry} holds the mapping from {@link ValuesSourceType}s to functions for building aggregation components.  DO NOT
        /*
    public static final class RegistryKey<T> {
 * SPDX-License-Identifier: Apache-2.0
 * under the License.
        /**
 * specific language governing permissions and limitations
     */
     */
                    valuesSourceConfig.getDescription() + " is not supported for aggregation [" + registryKey.getName() + "]"
 * this work for additional information regarding copyright
 * directly instantiate this class, instead get an already-configured copy from {@link QueryShardContext#getValuesSourceRegistry()}, or (in
            ValuesSourceType valuesSourceType,
        private final String name;
    public boolean isRegistered(RegistryKey<?> registryKey) {
            for (ValuesSourceType valuesSourceType : valuesSourceTypes) {
    private final Map<RegistryKey<?>, Map<ValuesSourceType, ?>> aggregatorRegistry;
         *                    family of aggregations.  Generally, the aggregation builder is expected to define a constant for use as the
         * single {@link ValuesSourceType}
         Make an immutatble copy of our input map. Since this is write once, read many, we'll spend a bit of extra time to shape this
                throw new IllegalArgumentException(
    /**
        }
        public RegistryKey(String name, Class<T> supplierType) {
            if (aggregatorRegistry.containsKey(registryKey) == false) {
import java.util.List;
        private Map<RegistryKey<?>, List<Map.Entry<ValuesSourceType, ?>>> aggregatorRegistry = new HashMap<>();
        /**
            @SuppressWarnings("unchecked")
            }
            RegistryKey<T> registryKey,
import java.util.Objects;
    }
        public ValuesSourceRegistry build() {
import org.opensearch.index.query.QueryShardContext;
 * software distributed under the License is distributed on an
         * known list of {@link ValuesSourceType}
import java.util.ArrayList;
        private final AggregationUsageService.Builder usageServiceBuilder;
        private final Class<T> supplierType;
            RegistryKey<T> registryKey,
        }
            T aggregatorSupplier,
        throw new AggregationExecutionException("Unregistered Aggregation [" + registryKey.getName() + "]");
        public void registerUsage(String aggregationName) {
     * The registry key for the values source registry key
 * Unless required by applicable law or agreed to in writing,
