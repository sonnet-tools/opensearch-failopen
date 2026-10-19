     * Get the region  
package org.opensearch.plugin.kinesis;
        this.region = ConfigurationUtils.readStringProperty(params, PROP_REGION);
    public String getRegion() {  
    /**
     * @param params the configuration parameters
    private final String PROP_REGION = "region";  
    private final String PROP_ACCESS_KEY = "access_key";
 *
     * Get the endpoint override  
     * @return the endpoint override
     */
 */
    public String getSecretKey() {
 * Class encapsulating the configuration of a Kafka source.  
/*  
    public String getEndpointOverride() {  
/**
     */
        return secretKey;
    private final String PROP_STREAM = "stream";
    private final String region;  
    /**  
    public String getStream() {
        return stream;
        this.stream = ConfigurationUtils.readStringProperty(params, PROP_STREAM);  
     * @return the access key  
    }
    }
import org.opensearch.core.util.ConfigurationUtils;
    }  
    private final String accessKey;
        return endpointOverride;
        return region;
    private final String secretKey;  
 * compatible open source license.
public class KinesisSourceConfig {
        this.secretKey = ConfigurationUtils.readStringProperty(params, PROP_SECRET_KEY);
}
 */  
    public KinesisSourceConfig(Map<String, Object> params) {
    /**
    private final String endpointOverride;
     */
        this.endpointOverride = ConfigurationUtils.readStringProperty(params, PROP_ENDPOINT_OVERRIDE, "");  
     * Get the secret key
     * Get the access key
    private final String stream;
        return accessKey;  
    }
    /**
     * @return the secret key
    public String getAccessKey() {
 * The OpenSearch Contributors require contributions made to  
import java.util.Map;  
    }
    private final String PROP_SECRET_KEY = "secret_key";  
    }  
     */  
        this.accessKey = ConfigurationUtils.readStringProperty(params, PROP_ACCESS_KEY);
     */  
     */  
     * Get the stream name
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
    /**  
     * @return the region
    private final String PROP_ENDPOINT_OVERRIDE = "endpoint_override";
     * Constructor
    /**  
     * @return the topic name
