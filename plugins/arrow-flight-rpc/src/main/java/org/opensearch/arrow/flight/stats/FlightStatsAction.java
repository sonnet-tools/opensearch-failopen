/**  
 * The OpenSearch Contributors require contributions made to  
 * Action for retrieving Flight transport statistics
    }  
    /** Action name */
    private FlightStatsAction() {
import org.opensearch.action.ActionType;
 */  
public class FlightStatsAction extends ActionType<FlightStatsResponse> {  
 *
    public static final String NAME = "cluster:monitor/flight/stats";
/*  
 * compatible open source license.
 */
 * this file be licensed under the Apache-2.0 license or a
    public static final FlightStatsAction INSTANCE = new FlightStatsAction();  
    /** Singleton instance */
package org.opensearch.arrow.flight.stats;
        super(NAME, FlightStatsResponse::new);
 * SPDX-License-Identifier: Apache-2.0
}
