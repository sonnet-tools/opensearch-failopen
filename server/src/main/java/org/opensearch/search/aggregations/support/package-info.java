/**
 * ValuesSourceTypes are the quantum of support in the aggregations framework, and provide a common language between fields and
 * implementations, and aggregations register what types they support via one of the  
 * not use this file except in compliance with the License.
 * GitHub history for details.
 * aggregations.  Fields which support aggregation set a ValuesSourceType on their {@link org.opensearch.index.fielddata.IndexFieldData}
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
 * ValuesSourceRegistry stores the mappings for what types are supported by what aggregations.  It is configured at startup, when  
 * <p>
 * <p>  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 *  
 *
 * </p>
 * the Apache License, Version 2.0 (the "License"); you may
 * <h3> {@link org.opensearch.search.aggregations.support.ValuesSourceType} </h3>
 * dependent on a user specified parameter (precision in that case).
 *  
 * org.opensearch.search.aggregations.bucket.geogrid.CellIdSource which do run-time conversion from one type to another, often  
/*  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * then specialized based on where they read values from, e.g. script or field cases.  There are also adapter classes like
 *
 * </p>
 *
 * <h3> {@link org.opensearch.search.aggregations.support.ValuesSourceRegistry} </h3>
 * such as {@link org.opensearch.search.aggregations.support.ValuesSource.Numeric#isFloatingPoint()}.  Second level subclasses are
 * <h3> {@link org.opensearch.search.aggregations.support.ValuesSource} and its subclasses </h3>  
 * This class is primarily used for parsing user type hints, and is deprecated for new use.  Work is ongoing to remove it from existing
 * software distributed under the License is distributed on an
 * {@link org.opensearch.search.aggregations.support.ValuesSource} instances and {@link org.opensearch.search.DocValueFormat}  
 * Licensed to Elasticsearch under one or more contributor  
 * {@link org.opensearch.search.SearchModule} is configuring aggregations.  It shouldn't be necessary to access the registry in most
 * default for what to call here and generally aggregations shouldn't need to deviate from that.
/*  
 * </p>  
 * formatter.  Aggregations are free to use this information as needed, such as Max and Min which inspect the field context to see if they
 */  
 * This package holds shared code for the aggregations framework, especially around dealing with values.
 *
 * this file be licensed under the Apache-2.0 license or a
 * instances.
 *  
 * Unless required by applicable law or agreed to in writing,
/*
 */  
 *
package org.opensearch.search.aggregations.support;
 * </p>  
 * Once properly constructed, the ValuesSourceConfig provides access to the ValuesSource instance, as well as related information like the  
 * under the License.  
 * <h3> {@link org.opensearch.search.aggregations.support.ValuesSourceConfig} </h3>
 *
 * Modifications Copyright OpenSearch Contributors. See
 * can apply an optimization.
 * {@link org.opensearch.search.aggregations.support.ValuesSourceRegistry.Builder#register} methods.  The VaulesSourceType itself holds
 * different situations.  {@link org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder#resolveConfig} has a good
 * </p>  
 * There are two things going on in ValuesSourceConfig.  First, there is a collection of static factory methods to build valid configs for  
 *  
 * These are thin wrappers which provide a unified interface to different ways of getting input data (e.g. DocValues from Lucene, or script
 * specific language governing permissions and limitations
 * <h2> Classes we are trying to phase out </h2>
 * <p>
 * <h3> {@link org.opensearch.search.aggregations.support.ValueType} </h3>  
 * compatible open source license.
 * output). A class hierarchy defines the type of values returned by the source.  The top level sub-classes define type-specific behavior,  
 * </p>
 * KIND, either express or implied.  See the License for the
 * <h2> Key Classes </h2>
 * cases, but you can get a read copy from {@link org.opensearch.index.query.QueryShardContext#getValuesSourceRegistry()} if necessary.
 * <p>  
 * information on how to with values of that type, including methods for creating
 * code.  
 * license agreements. See the NOTICE file distributed with
 * <p>
 * </p>
 */
 * The OpenSearch Contributors require contributions made to  
 * <p>
 * <p>
