/*  
/**
package org.opensearch.dsl.action;
        super(NAME, ValidateQueryResponse::new);
 * Dispatched by {@link SearchActionFilter} when it intercepts a {@code _validate/query} request.  
}
 * Action type for validating a query against the DSL-to-Calcite converter.
 * The OpenSearch Contributors require contributions made to  
 *
 * this file be licensed under the Apache-2.0 license or a
 */  
 * SPDX-License-Identifier: Apache-2.0
 */
    /** Singleton instance. */
    private ValidateAction() {
    public static final ValidateAction INSTANCE = new ValidateAction();
import org.opensearch.action.admin.indices.validate.query.ValidateQueryResponse;
    }  
import org.opensearch.action.ActionType;
 * compatible open source license.
    /** Action name. Follows the {@code dsl/<verb>} convention shared with {@link ExecuteAction}. */
public class ValidateAction extends ActionType<ValidateQueryResponse> {
    public static final String NAME = "indices:data/read/dsl/validate";
