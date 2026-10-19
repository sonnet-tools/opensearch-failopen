use datafusion::execution::context::SessionContext;
 * The OpenSearch Contributors require contributions made to
    os_count_distinct::register_all(ctx);
pub mod take;
 * this file be licensed under the Apache-2.0 license or a
pub mod internal_pattern;
 * compatible open source license.
pub mod approx_distinct_safe;
    approx_distinct_safe::register_all(ctx);
pub mod os_count_distinct;
/*
    take::register_all(ctx);
 */
}
    list_merge::register_all(ctx);
//! must have a matching YAML entry in `opensearch_aggregate_functions.yaml` so
//! OpenSearch aggregate UDFs not in DataFusion's builtins. Each registered UDAF
 * SPDX-License-Identifier: Apache-2.0
pub fn register_all(ctx: &SessionContext) {
    internal_pattern::register_all(ctx);
 *
//! that isthmus's substrait emitter can bind the operator to the extension URN.
pub mod list_merge;
