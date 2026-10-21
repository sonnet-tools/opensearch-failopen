    }
    #[inline]
            }
    ///
    pub fn new_from_metadata(
                .fetch_add(diff, Ordering::Relaxed);
 */
// Send + Sync is auto-derived since all fields are atomic.
    ///
            ema_batch_bytes_x1000: AtomicU64::new((measured_batch_bytes as u64) * 1000),
        let c = PhantomCorrector::new(initial_phantom, estimated_batch, pipeline_slots);
    fn no_correction_within_deadband() {
        let ideal_phantom = smoothed_batch_bytes * self.batches_in_pipeline as i64;
        let pipeline_slots = 13;
        assert!(delta > 0, "expected positive delta, got {}", delta);
}
            "First correction took {} batches — too slow",
    #[test]
        println!(
 *
#[derive(Debug)]
    /// batch memory size and periodically computes a correction delta.
    current_phantom_bytes: AtomicI64,
            first_correction_at
    pub fn observe_batch(&self, actual_batch_bytes: usize) {
        );
        let delta = c.take_pending_delta();
            phantom, ideal_phantom, bloat_ratio
        }
//!
        for _ in 0..4 {
//! The initial phantom is estimated from schema metadata. During execution,
        // actual: 50 bytes/batch → ideal = 500
        // estimated: 200 bytes/batch × 10 = 2000 phantom
        let actual_batch = 40 * 8192; // actual (2.5x smaller)
    /// Number of batches observed.
        for _ in 0..8 {
    /// - `initial_phantom_bytes`: the phantom size reserved at query start
        );
    /// Called by `stream_next` after delivering a batch to Java.
    ///
    }
    /// Read and reset by the caller via `take_pending_delta`.
        let sample_x1000 = (actual_batch_bytes as u64) * 1000;
            // Pre-warmed: skip warmup since we trust metadata-derived estimate
        self.pending_delta.swap(0, Ordering::Relaxed)
            batches_in_pipeline,
            c.observe_batch(actual_batch);
    estimated_batch_bytes: usize,
    }
    #[test]
        // Actual at runtime: 56 bytes/row → batch = 56 * 8192 = 458752
        let threshold = (current as f64 * CORRECTION_THRESHOLD) as i64;
}
        let c =
 * compatible open source license.
    #[test]
        assert!(
        // 50 < 100 → no correction
    /// `CORRECTION_INTERVAL` batches after warmup.
    /// The per-batch bytes used in the original phantom estimate.
        // Simulate 50 batches (typical scan of ~400K rows)
        }
        initial_phantom_bytes: usize,
        for i in 0..50 {
        // Metadata says 60 bytes/row, actual is 56 — very close
            ema_batch_bytes_x1000: AtomicU64::new((estimated_batch_bytes as u64) * 1000),
        estimated_batch_bytes: usize,
    /// Create a new corrector.
            self.pending_delta.fetch_add(diff, Ordering::Relaxed);
};
/// EMA alpha for batch size smoothing (0.4 = converges in ~3 samples).
    /// Simulates a full query lifecycle: estimate → observe → correct → converge.
mod tests {
        }
            if delta != 0 {
        initial_phantom_bytes: usize,
        assert_eq!(c.take_pending_delta(), 0);
        let actual_batch = 56 * 8192;
            c.observe_batch(actual_batch);
#[cfg(test)]
        }
            pending_delta: AtomicI64::new(0),
            batches_observed: AtomicUsize::new(0),
            first_correction_at <= 8,
        // estimated: 100 bytes/batch × 10 = 1000
        // Should be positive (need more phantom)
    ema_batch_bytes_x1000: AtomicU64,
        assert_eq!(delta, 0);
    }
    /// so it only corrects if runtime batches differ from what metadata predicted.
        measured_batch_bytes: usize,
                phantom += delta;
 * SPDX-License-Identifier: Apache-2.0
    fn correction_after_warmup_and_interval() {
            return;
            first_correction_at * 8192
    #[inline]
        // Should be even tighter since starting point was already close
use std::sync::atomic::{AtomicI64, AtomicU64, AtomicUsize, Ordering};
                first_correction_at = i + 1;
    #[test]
//! - `CrossRtStream::poll_next` (writes observations) — runs on IO runtime
    use super::*;
        let c = PhantomCorrector::new(1000, 100, 10);
        self.ema_batch_bytes_x1000.store(new_ema, Ordering::Relaxed);
        }
            estimated_batch_bytes: measured_batch_bytes,
            let delta = c.take_pending_delta();
        let ideal_phantom = actual_batch * pipeline_slots;
    fn initial_bloat_before_correction() {
    pub fn take_pending_delta(&self) -> i64 {
        let initial_phantom = estimated_batch * pipeline_slots;
        let c = PhantomCorrector::new(1000, 100, 10);
    #[test]
        let diff = ideal_phantom - current;
    /// = target_partitions × PARTITION_BUFFER_MULTIPLIER + 1 (output channel)
        // Update EMA
const CORRECTION_INTERVAL: usize = 4;
            "Convergence after 50 batches: phantom={}B, ideal={}B, ratio={:.2}x",
        // estimated: 100 bytes/batch × 10 slots = 1000 phantom
            bloat_ratio >= 0.90 && bloat_ratio <= 1.10,
        let c = PhantomCorrector::new(2000, 200, 10);
            if delta != 0 && first_correction_at == 0 {
    batches_in_pipeline: usize,
        // actual: 200 bytes/batch → ideal phantom = 2000
    /// Number of concurrent batch slots in the pipeline that the phantom covers.
//! actual `RecordBatch` sizes may differ. This module observes each batch
        let first = c.take_pending_delta();
    pub fn new(
        assert!(
        let c = PhantomCorrector::new(initial_phantom, estimated_batch, pipeline_slots);
        // Feed enough observations to trigger: WARMUP(3) + needs to hit INTERVAL(4)
            c.observe_batch(105);
        for i in 0..50 {
        for _ in 0..8 {
    }
        for _ in 0..8 {
    #[test]
        let c = PhantomCorrector::new(1000, 100, 10);
        let ideal_phantom = actual_batch as i64 * pipeline_slots as i64;
    /// actual sizes deviate from the cached measurement.
        assert_eq!(second, 0);
        // First correction should fire within 4-8 batches (warmup + interval)
    /// Take the accumulated correction delta. Returns 0 if no correction pending.
    pending_delta: AtomicI64,
            bloat_ratio >= 0.85 && bloat_ratio <= 1.15,
//! Self-correcting phantom reservation based on observed batch sizes.
    /// the measured value — corrections begin from the first batch if
            batches_observed: AtomicUsize::new(WARMUP_BATCHES),
        if count < WARMUP_BATCHES || count % CORRECTION_INTERVAL != 0 {
                break;
            current_phantom_bytes: AtomicI64::new(initial_phantom_bytes as i64),
        let estimated_batch = 100 * 8192;
            "Metadata-seeded bloat ratio {:.2}x is outside [0.90, 1.10]",
        let current = self.current_phantom_bytes.load(Ordering::Relaxed);
        );
        assert_send_sync::<PhantomCorrector>();
    /// Called per-batch from `CrossRtStream::poll_next`. Observes the actual
    #[test]
        let second = c.take_pending_delta();
        Self {
//!
    /// phantom estimate. The corrector's EMA is seeded with the same value,
const BATCH_EMA_ALPHA_X1000: u64 = 400;
        let bloat_ratio = phantom as f64 / ideal_phantom as f64;
    }
    }
        assert!(first != 0);
        c.observe_batch(200);
        batches_in_pipeline: usize,
            "Bloat ratio {:.2}x is outside [0.85, 1.15] — corrector not converging",
            current_phantom_bytes: AtomicI64::new(initial_phantom_bytes as i64),
//! - `api::stream_next` (reads + applies corrections) — same sequential caller
    }
        let pipeline_slots = 13; // 4×3 + 1
    fn assert_send_sync<T: Send + Sync>() {}
    }
        let mut phantom = initial_phantom as i64;
    fn no_correction_during_warmup() {
        let actual_batch = 56 * 8192;
            "Metadata-seeded convergence after 20 batches: phantom={}B, ideal={}B, ratio={:.2}x",
    fn take_resets_delta() {
        let ideal_phantom = actual_batch as i64 * pipeline_slots as i64;
    /// Accumulated correction delta (bytes). Positive = need more, negative = have excess.
            }
            batches_in_pipeline,
            phantom, ideal_phantom, bloat_ratio
            self.current_phantom_bytes
//! the caller applies to the `MemoryReservation` periodically.
    }
        let initial_phantom = measured_batch * pipeline_slots;
    /// - `batches_in_pipeline`: how many batch-slots the phantom covers
//!
/// Minimum batches before corrections start (EMA warmup).
        Self {
    }
        let prev = self.ema_batch_bytes_x1000.load(Ordering::Relaxed);
        assert!(delta < 0, "expected negative delta, got {}", delta);
    /// Current effective phantom bytes (tracks applied corrections).
        }
 * this file be licensed under the Apache-2.0 license or a
        let delta = c.take_pending_delta();
        // Compute what the phantom should be based on observed batch sizes
        let bloat_ratio = phantom as f64 / ideal_phantom as f64;
    #[test]
            c.observe_batch(actual_batch);
        println!(
        // Should be negative (excess phantom)
const _: () = {
        let initial_bloat = initial_phantom as f64 / ideal_phantom as f64;
        let new_ema =
            pending_delta: AtomicI64::new(0),
        );
            c.observe_batch(50);
        }
        let smoothed_batch_bytes = (new_ema / 1000) as i64;
            if delta != 0 {
        // 10 pipeline slots (4 partitions × 3 buffers + 1 output)
    /// Measures convergence with metadata-seeded corrector (tighter from start).
        }
        let count = self.batches_observed.fetch_add(1, Ordering::Relaxed) + 1;
    ) -> Self {
/*
            bloat_ratio
    /// Measures overhead: the initial over-estimate before correction kicks in.
impl PhantomCorrector {
            let delta = c.take_pending_delta();
//! # Thread safety
//! never concurrent with itself.
        );
                phantom += delta;
        for _ in 0..20 {
    ) -> Self {
//! flowing through `CrossRtStream` and accumulates a correction delta that
    }
        // After convergence, phantom should be within 15% of ideal (1.0-1.15x)
    }
        // actual: 105 bytes/batch → ideal = 1050, diff = 50, threshold = 100 (10%)
            bloat_ratio
const WARMUP_BATCHES: usize = 3;
 * The OpenSearch Contributors require contributions made to
            (BATCH_EMA_ALPHA_X1000 * sample_x1000 + (1000 - BATCH_EMA_ALPHA_X1000) * prev) / 1000;
    fn correction_shrinks_on_smaller_batches() {
// Explicit assertion for documentation:
/// Self-correcting phantom observer. Lock-free, `Send + Sync`.
        let mut phantom = initial_phantom as i64;
        let delta = c.take_pending_delta();
    /// Measures the final bloat ratio (corrected_phantom / ideal_phantom).
    fn convergence_bloat_ratio() {
        println!(
}
        // Schema estimate: 100 bytes/row → batch = 100 * 8192 = 819200
        let measured_batch = 60 * 8192;
            first_correction_at,
        let mut first_correction_at = 0usize;
/// Only correct every N batches to avoid churning the reservation.
    fn metadata_seeded_convergence() {
    batches_observed: AtomicUsize,
        assert!(
        c.observe_batch(200);
        }
        let pipeline_slots = 13;
    /// Cost: ~15ns (2 atomic ops + arithmetic). Only computes delta every
const CORRECTION_THRESHOLD: f64 = 0.10;
            PhantomCorrector::new_from_metadata(initial_phantom, measured_batch, pipeline_slots);
        let initial_phantom = estimated_batch * pipeline_slots;
    /// This is the "bloat window" — how much excess phantom is held during warmup.
/// Dead-band: don't correct if difference is within this fraction of current.
    /// Create a corrector pre-seeded with measured batch bytes from cached
        // Skip warmup and non-correction intervals
        }
        batches_in_pipeline: usize,
            c.observe_batch(300);
            }
    fn check() {
        // Count batches until first correction fires
            initial_bloat,
        if diff.abs() > threshold {
    /// Use this when `estimate_row_bytes_from_metadata` produced the initial
    /// parquet metadata. Skips the warmup phase since the EMA starts at
//!
//! All fields are atomic. The corrector is shared (`Arc`) between:
        // First 3 observations: no delta
    /// EMA of actual batch bytes (×1000 fixed-point).
            "Initial bloat: {:.2}x (corrects after {} batches = {} rows)",
    /// - `estimated_batch_bytes`: `batch_size × avg_row_bytes` used in the estimate
        );
//! No mutex needed. The sequential stream_next contract ensures apply is
pub struct PhantomCorrector {
        let c = PhantomCorrector::new(1000, 100, 10);
            c.observe_batch(200);
            let delta = c.take_pending_delta();
        let estimated_batch = 100 * 8192; // schema-based (over-estimate)
            estimated_batch_bytes,
        }
