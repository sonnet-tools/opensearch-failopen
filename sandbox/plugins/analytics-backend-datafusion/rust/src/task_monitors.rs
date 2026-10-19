}
//! - `plan_setup`: session context creation + plan preparation
//! Per-operation task monitors.
static QUERY_EXECUTION_MONITOR: Lazy<TaskMonitor> = Lazy::new(TaskMonitor::new);
/*
use tokio_metrics::TaskMonitor;
pub fn coordinator_reduce_monitor() -> &'static TaskMonitor {
}
    &STREAM_NEXT_MONITOR
//! Each FFM operation type gets its own [`TaskMonitor`] for timing metrics:
}
//!
static COORDINATOR_REDUCE_MONITOR: Lazy<TaskMonitor> = Lazy::new(TaskMonitor::new);
pub fn plan_setup_monitor() -> &'static TaskMonitor {
static PLAN_SETUP_MONITOR: Lazy<TaskMonitor> = Lazy::new(TaskMonitor::new);
 * compatible open source license.
pub fn query_execution_monitor() -> &'static TaskMonitor {
 * The OpenSearch Contributors require contributions made to
//! - `stream_next`: streaming pagination
//! - `coordinator_reduce`: coordinator-side local plan execution
    &PLAN_SETUP_MONITOR
    &QUERY_EXECUTION_MONITOR
 * this file be licensed under the Apache-2.0 license or a
 *
//!
 * SPDX-License-Identifier: Apache-2.0
static STREAM_NEXT_MONITOR: Lazy<TaskMonitor> = Lazy::new(TaskMonitor::new);
pub fn stream_next_monitor() -> &'static TaskMonitor {
}
//! - `query_execution`: shard-level query execution
    &COORDINATOR_REDUCE_MONITOR
 */
use once_cell::sync::Lazy;
//! Monitors are initialized lazily on first access via `once_cell::sync::Lazy`.
