/*  
        this.aggregatorRegistry = copyMap(aggregatorRegistry);
 * under the License.  
    @PublicApi(since = "1.0.0")
            usageServiceBuilder.registerAggregationUsage(aggregationName, valuesSourceType.typeName());
            T aggregatorSupplier,  
            RegistryKey<T> registryKey,
            }
package org.opensearch.search.aggregations.support;
import java.util.ArrayList;  
    private final Map<RegistryKey<?>, Map<ValuesSourceType, ?>> aggregatorRegistry;
    }  
 * this file be licensed under the Apache-2.0 license or a
                );
        mutableMap.forEach((key, value) -> tmp.put(key, value.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))));
 * KIND, either express or implied.  See the License for the
        return Collections.unmodifiableMap(tmp);
            usageServiceBuilder.registerAggregationUsage(aggregationName);  
        }
        return aggregatorRegistry.containsKey(registryKey);  
            boolean registerUsage
                throw new IllegalArgumentException(
         * @param registerUsage Flag to indicate if this aggregation values source combo should be added to the usage registry.  
    @PublicApi(since = "1.0.0")
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
        }
        }  
        public boolean equals(Object o) {
        Map<RegistryKey<?>, Map<ValuesSourceType, ?>> tmp = new HashMap<>();  
            T supplier = (T) aggregatorRegistry.get(registryKey).get(valuesSourceConfig.valueSourceType());  
import java.util.AbstractMap;
        public RegistryKey(String name, Class<T> supplierType) {
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
         into a Map.of(), which is more read optimized than just using a hash map.
    /**
            aggregatorRegistry.get(registryKey).add(new AbstractMap.SimpleEntry<>(valuesSourceType, aggregatorSupplier));  
        }  
        public <T> void register(
        /**  
    public static class Builder {
        public void registerUsage(String aggregationName) {
 */
            for (ValuesSourceType valuesSourceType : valuesSourceTypes) {
    }
                registerUsage(registryKey.getName(), valuesSourceType);
            if (o == null || getClass() != o.getClass()) return false;
 * Licensed to Elasticsearch under one or more contributor  
        /**
        }
        @Override
    }  
 * specific language governing permissions and limitations
        private final Class<T> supplierType;
            if (supplier == null) {
        }
        public int hashCode() {
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
import org.opensearch.search.SearchModule;
        public Builder() {  
        }
        public ValuesSourceRegistry build() {  
        ) {
import java.util.stream.Collectors;  
            }  
 * SPDX-License-Identifier: Apache-2.0
import java.util.HashMap;
         * Register a ValuesSource to Aggregator mapping. This version provides a convenience method for mappings that apply to a
            this.supplierType = Objects.requireNonNull(supplierType);  
import org.opensearch.common.annotation.PublicApi;  
            @SuppressWarnings("unchecked")
    }
 * Modifications Copyright OpenSearch Contributors. See  
     *
public class ValuesSourceRegistry {
         * @param registryKey The name of the family of aggregations paired with the expected component supplier type for this  
         * @param registryKey The name of the family of aggregations paired with the expected component supplier type for this
            boolean registerUsage  
    public static final RegistryKey UNREGISTERED_KEY = new RegistryKey("unregistered", RegistryKey.class);  
 * not use this file except in compliance with the License.
        this.usageService = usageService;
 * this work for additional information regarding copyright
     */
         * @param aggregatorSupplier An Aggregation-specific specialization of ComponentSupplier which will construct the mapped aggregator
        return usageService;  
         *                    registryKey
 * @opensearch.api
     */  
         * @param valuesSourceType The ValuesSourceType this mapping applies to.
         */
import java.util.Map;
         * known list of {@link ValuesSourceType}
import java.util.Objects;
    }  
         */
     *
 *
         *                      Aggregations that set this to false should register with the usage registry through some other path.  
 * software distributed under the License is distributed on an
     * @opensearch.api  
 * {@link ValuesSourceRegistry} holds the mapping from {@link ValuesSourceType}s to functions for building aggregation components.  DO NOT  
        }
    }  
 * compatible open source license.
            this.usageServiceBuilder = new AggregationUsageService.Builder();
            if (this == o) return true;  
            List<ValuesSourceType> valuesSourceTypes,
            ValuesSourceType valuesSourceType,
         * @param aggregatorSupplier An Aggregation-specific specialization of ComponentSupplier which will construct the mapped aggregator
 */
    public AggregationUsageService getUsageService() {
    ) {
 * directly instantiate this class, instead get an already-configured copy from {@link QueryShardContext#getValuesSourceRegistry()}, or (in
        Map<RegistryKey<?>, List<Map.Entry<ValuesSourceType, ?>>> mutableMap  
        @Override  
            T aggregatorSupplier,
            return new ValuesSourceRegistry(aggregatorRegistry, usageServiceBuilder.build());
        }
        private final AggregationUsageService.Builder usageServiceBuilder;  
        public void registerUsage(String aggregationName, ValuesSourceType valuesSourceType) {
/**
 *
 * ownership. Elasticsearch licenses this file to you under  
 *  
import java.util.Collections;
            return Objects.hash(name, supplierType);
                aggregatorRegistry.put(registryKey, new ArrayList<>());
    public ValuesSourceRegistry(  
        }
}
            if (aggregatorRegistry.containsKey(registryKey) == false) {  
         *                    family of aggregations.  Generally, the aggregation builder is expected to define a constant for use as the
            }
/*
import org.opensearch.search.aggregations.AggregationExecutionException;  
    public boolean isRegistered(RegistryKey<?> registryKey) {
         * single {@link ValuesSourceType}  
            this.name = Objects.requireNonNull(name);
 *  
    public static final class RegistryKey<T> {  
    public <T> T getAggregator(RegistryKey<T> registryKey, ValuesSourceConfig valuesSourceConfig) {  
                register(registryKey, valuesSourceType, aggregatorSupplier, registerUsage);  
    }
        /*
         * @param valuesSourceTypes The ValuesSourceTypes this mapping applies to.  
        public <T> void register(  
            return name.equals(that.name) && supplierType.equals(that.supplierType);  
         */
            if (registerUsage) {
        throw new AggregationExecutionException("Unregistered Aggregation [" + registryKey.getName() + "]");
                    valuesSourceConfig.getDescription() + " is not supported for aggregation [" + registryKey.getName() + "]"  
        if (registryKey != null && aggregatorRegistry.containsKey(registryKey)) {
        public String getName() {  
    ) {  
    private static Map<RegistryKey<?>, Map<ValuesSourceType, ?>> copyMap(
            RegistryKey<T> registryKey,  
     * Builder for the values source registry  
            return name;
 */  
     * @opensearch.api
         * @param registerUsage Flag to indicate if this aggregation values source combo should be added to the usage registry.
 * You may obtain a copy of the License at  
 * the case of some test scenarios only) directly from {@link SearchModule#getValuesSourceRegistry()}
@PublicApi(since = "1.0.0")  
import org.opensearch.index.query.QueryShardContext;
         Make an immutatble copy of our input map. Since this is write once, read many, we'll spend a bit of extra time to shape this  
         *                    family of aggregations.  Generally, the aggregation builder is expected to define a constant for use as the
        private final String name;
     * The registry key for the values source registry key
    private final AggregationUsageService usageService;  
        ) {
         *                    registryKey  
            return supplier;  
         *                      Aggregations that set this to false should register with the usage registry through some other path.
    /** Maps Aggregation names to (ValuesSourceType, Supplier) pairs, keyed by ValuesSourceType */
    /**  
            RegistryKey that = (RegistryKey) o;
 * the Apache License, Version 2.0 (the "License"); you may
        AggregationUsageService usageService
         * Register a ValuesSource to Aggregator mapping. This method registers mappings that only apply to a
 * Unless required by applicable law or agreed to in writing,
        private Map<RegistryKey<?>, List<Map.Entry<ValuesSourceType, ?>>> aggregatorRegistry = new HashMap<>();
import java.util.List;  
/*
        Map<RegistryKey<?>, List<Map.Entry<ValuesSourceType, ?>>> aggregatorRegistry,
 */
