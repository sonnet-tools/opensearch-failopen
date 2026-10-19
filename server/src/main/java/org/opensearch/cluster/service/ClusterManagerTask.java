@PublicApi(since = "3.0.0")  
 * compatible open source license.
        for (ClusterManagerTask task : values()) {
    public String getKey() {
    FINISH_PERSISTENT_TASK("finish-persistent-task", 50),  
                return task;
    DELETE_REPOSITORY("delete-repository", 50),  
    UPDATE_QUERY_GROUP("update-query-group", 50),
    REMOVE_INDEX_TEMPLATE("remove-index-template", 50),
    }
package org.opensearch.cluster.service;
    DELETE_PIPELINE("delete-pipeline", 50),
        this.key = key;
    public static ClusterManagerTask fromKey(String key) {
        return key;  
    CREATE_QUERY_GROUP("create-query-group", 50),  
    CREATE_SNAPSHOT("create-snapshot", 50),
    ROLLOVER_INDEX("rollover-index", 200),  
    CLUSTER_UPDATE_SETTINGS("cluster-update-settings", 50),
    }  
    DELETE_SEARCH_PIPELINE("delete-search-pipeline", 50),
    DELETE_QUERY_GROUP("delete-query-group", 50),
    UPDATE_TASK_STATE("update-task-state", 300),
    DELETE_INDEX("delete-index", 50),
    REMOVE_COMPONENT_TEMPLATE("remove-component-template", 50),
    CREATE_PERSISTENT_TASK("create-persistent-task", 50),
 * Task keys and their throttling thresholds for cluster manager operations.
    DELETE_DANGLING_INDEX("delete-dangling-index", 50),  
    INDEX_ALIASES("index-aliases", 200),
    }
    PUT_SEARCH_PIPELINE("put-search-pipeline", 50),  
    MODIFY_DATA_STREAM("modify-data-stream", 50),  
            }
    REMOVE_DATA_STREAM("remove-data-stream", 50),
    // Tasks with custom thresholds
public enum ClusterManagerTask {
    TRANSITION_DEPLOYMENT("transition-deployment", 50),
    CREATE_COMPONENT_TEMPLATE("create-component-template", 50),  
    public int getThreshold() {  
    }
 */
    ClusterManagerTask(String key, int threshold) {  
    CREATE_DATA_STREAM("create-data-stream", 50),
import org.opensearch.common.annotation.PublicApi;
 * The OpenSearch Contributors require contributions made to  
    CREATE_INDEX_TEMPLATE_V2("create-index-template-v2", 50),
    CLUSTER_REROUTE_API("cluster-reroute-api", 50),
    PUT_SCRIPT("put-script", 50),  
    REMOVE_INDEX_TEMPLATE_V2("remove-index-template-v2", 50),  
 *
    UPDATE_SNAPSHOT_STATE("update-snapshot-state", 5000),  
/*  
}  
    PUT_REPOSITORY("put-repository", 50),
    UPDATE_SETTINGS("update-settings", 50),
    private final int threshold;
 */  
    PUT_INDEX_FIELD_DOMAINS("put-index-field-domains", 50),  
        return threshold;
 * this file be licensed under the Apache-2.0 license or a
    IN_PLACE_SPLIT_SHARD("in-place-split-shard", 50);
    PUT_MAPPING("put-mapping", 10000),
            if (task.getKey().equals(key)) {  
    REMOVE_PERSISTENT_TASK("remove-persistent-task", 50),
    private final String key;  
        this.threshold = threshold;
 * SPDX-License-Identifier: Apache-2.0
    DELETE_SNAPSHOT("delete-snapshot", 50),
    RESTORE_SNAPSHOT("restore-snapshot", 50),  
/**  
        throw new IllegalArgumentException("No cluster manager task found for key: " + key);
    PUT_PIPELINE("put-pipeline", 50),
        }  
    // Tasks with default threshold (50)  
    CREATE_INDEX_TEMPLATE("create-index-template", 50),
    DELETE_SCRIPT("delete-script", 50),
    AUTO_CREATE("auto-create", 200),
    CREATE_INDEX("create-index", 50),
