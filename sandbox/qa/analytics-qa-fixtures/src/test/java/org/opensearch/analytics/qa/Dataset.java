    public String expectedResponseResourcePath(String language, int queryNumber) {  
        this.name = name;  
    public Dataset(String name, String indexName) {
    /** The index name to provision the dataset into. */
 * </ul>
    public final String name;  
    public final List<String> indexNames;  
    }
    /** The dataset name, used as the directory under {@code resources/datasets/}. */
 *   <li>{@code {language}/q{N}.{ext}} — query files by language</li>
public final class Dataset {  
 * SPDX-License-Identifier: Apache-2.0
    /** Path to a query resource for the given language and query number. */  
/**
 * <ul>
        this.indexNames = Arrays.asList(indexNames);
    }  
    public String queryResourcePath(String language, String extension, int queryNumber) {
 * A dataset consists of:
        return "datasets/" + name + "/" + language + "/q" + queryNumber + "." + extension;
 */  
 *
    }  
}  
        this.name = name;  
        this.indexNames = Arrays.asList(indexName);
/*  
    /** All index names for multi-index datasets. */
 *   <li>{@code mapping.json} — index mapping and settings</li>  
import java.util.Arrays;
    /** Path to the expected response resource for the given language and query number. */
    public Dataset(String name, String... indexNames) {
        return "datasets/" + name + "/" + language + "/expected/q" + queryNumber + ".json";
    public final String indexName;  
    }  
 *   <li>{@code {language}/expected/q{N}.json} — expected responses (optional)</li>  
    /** Path to the mapping resource. */
 * <p>  
 * compatible open source license.
    public String mappingResourcePath() {  
 *   <li>{@code bulk.json} — bulk-indexable documents (NDJSON)</li>
        return "datasets/" + name + "/mapping.json";
 */
        this.indexName = indexNames[0];
    }
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        return "datasets/" + name + "/bulk.json";  
package org.opensearch.analytics.qa;
    /** Path to the bulk data resource. */
        this.indexName = indexName;
 * Descriptor for a test dataset loaded from {@code resources/datasets/{name}/}.
    }
    public String bulkResourcePath() {
