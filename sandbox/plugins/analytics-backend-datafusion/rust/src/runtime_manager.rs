    pub io_monitor: RuntimeMonitor,
    pub fn cpu_executor(&self) -> DedicatedExecutor {
        self.cpu_executor.clone()
                .build()
        self.shutdown();
        let io_registration =
        // running after a replacement manager published its own handle.
            cpu_executor,
        // SpawnedReqwestConnector that runs HTTP IO on this runtime.
    }
        native_bridge_common::io_runtime::clear_io_handle_if_current(self.io_registration);
    }
            .worker_threads(cpu_threads)
use tokio::runtime::{Builder, Runtime};
    }
    pub cpu_monitor: Option<RuntimeMonitor>,
    pub io_runtime: Arc<Runtime>,
        std::mem::forget(mgr);
        self.cpu_executor.join_blocking();
    }
}
 * compatible open source license.
        mgr.cpu_executor.shutdown();
        let result = mgr.cpu_executor().spawn(async { 99 }).await.unwrap();
        assert_eq!(result, 42);
        let mgr = test_mgr();
    fn test_mgr() -> RuntimeManager {
        std::mem::forget(mgr);
            .unwrap();
        let cpu_id = mgr
        // Forget to avoid Drop which can't run in async context
        let result = mgr.io_runtime.spawn(async { 42 }).await.unwrap();
        // The handle is always available before any store is constructed.
    pub fn shutdown(&self) {
            .spawn(async { std::thread::current().id() })
    pub fn new(cpu_threads: usize, datanode_multiplier: f64, _coordinator_multiplier: f64) -> Self {
    }
        let cpu_executor = DedicatedExecutor::new(
                .expect("Failed to create IO runtime"),
use log::info;
 * The OpenSearch Contributors require contributions made to
    }
 *
            Builder::new_multi_thread()
}
            io_runtime,
mod tests {
        let cpu_monitor = cpu_executor.handle().map(|h| RuntimeMonitor::new(&h));
    /// manager which outlives its own replacement clears nothing. In-flight queries hold `Arc`
            .enable_all();
        let io_id = std::thread::current().id();
    io_registration: native_bridge_common::io_runtime::HandleRegistration,
        // Initialization order: DataFusionService starts this plugin first, then
        RuntimeManager::new(1, 1.5, 1.5)
            cpu_runtime_builder,
    async fn test_cpu_executor_runs_on_different_thread() {
                .worker_threads(io_threads)
    #[tokio::test]
 */
 * this file be licensed under the Apache-2.0 license or a
/*
        cpu_runtime_builder
        // native-repository-* crates (s3/gcs/azure) can install a
        }
pub struct RuntimeManager {
        // Publish the IO runtime handle in native_bridge_common so the separate
        let io_threads = cpu_threads * 2;
        let mgr = test_mgr();
    /// replacement published its handle — and an unconditional clear there would strand every
            io_registration,
}
        // native-repository-s3/gcs/azure read the handle at object-store build time.
        assert_ne!(io_id, cpu_id);
        Self {
            native_bridge_common::io_runtime::set_io_handle(io_runtime.handle().clone());
            datanode_max_concurrent,
            io_monitor,
            .await
use crate::executor::{ConcurrencyGate, DedicatedExecutor};
    fn drop(&mut self) {
        // Clear the published IO handle so a torn-down runtime is never handed out to a remote
        );
#[cfg(test)]
                .thread_name("datafusion-io")
    /// clones, so on a re-init with no intervening shutdown this manager's `Drop` runs *after* the
    use super::*;
        );
            .cpu_executor()
        let io_runtime = Arc::new(
    }
use tokio_metrics::RuntimeMonitor;
            .thread_name("datafusion-cpu")
        let mut cpu_runtime_builder = Builder::new_multi_thread();
        info!("Shutting down RuntimeManager");
        // Fragment executor concurrency gate: limits concurrent partition tasks from shard scans.
        let io_monitor = RuntimeMonitor::new(&io_runtime.handle());
    /// remote store built afterwards on its default connector.
            "datafusion-cpu",
        assert_eq!(result, 99);
                .enable_all()
 * SPDX-License-Identifier: Apache-2.0
    /// Registration for this manager's published IO handle, presented on shutdown so that a
    pub cpu_executor: DedicatedExecutor,
    #[tokio::test]
// RuntimeManager — owns IO runtime + CPU DedicatedExecutor.
impl Drop for RuntimeManager {
use std::sync::Arc;
        mgr.cpu_executor.shutdown();
        let datanode_max_concurrent = (cpu_threads as f64 * datanode_multiplier).max(1.0) as usize;
            cpu_monitor,
impl RuntimeManager {
    async fn test_runtime_manager_creates_and_shuts_down() {
}
        // object-store builder after shutdown — but only if it is still ours, since this may be
