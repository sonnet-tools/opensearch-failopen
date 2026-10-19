 * SPDX-License-Identifier: Apache-2.0
 * Response carrying materialized query results from the analytics engine.  
        throw new UnsupportedOperationException("AnalyticsQueryResponse is local-dispatch only");
import java.io.IOException;  
    }  
    public AnalyticsQueryResponse(StreamInput in) throws IOException {  
    public void writeTo(StreamOutput out) throws IOException {  
    }
import org.opensearch.core.action.ActionResponse;
 * The OpenSearch Contributors require contributions made to  
        this.profiledResult = null;
    private final transient ProfiledResult profiledResult;  
        this.rows = rows;  
        throw new UnsupportedOperationException("AnalyticsQueryResponse is local-dispatch only");
        return profiledResult;  
 *
package org.opensearch.analytics.exec.action;
public class AnalyticsQueryResponse extends ActionResponse {  
import org.opensearch.analytics.exec.profile.ProfiledResult;
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    }
    public Iterable<Object[]> getRows() {
    public ProfiledResult getProfiledResult() {
 */  
/*  
        return rows;
    }  
    }
        this.profiledResult = profiledResult;  
    public AnalyticsQueryResponse(Iterable<Object[]> rows) {
    public AnalyticsQueryResponse(ProfiledResult profiledResult) {
 */
        this.rows = profiledResult.rows();
    }
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
}
    private final transient Iterable<Object[]> rows;
        super(in);
/**
import org.opensearch.core.common.io.stream.StreamInput;  
 * Local-dispatch only — the rows are held in-memory and not wire-serializable.
