        elapsed < Duration::from_secs(5),
fn test_request_rejected_when_pool_full() {
    );
    assert!(
        "requester",
/// Request blocks for the full timeout duration then fails.
    let pool = Arc::new(MemoryPool::new("test", 1_000));
 */
    let elapsed = start.elapsed();
        });
    let start = Instant::now();
        MemoryReservation::new(&pool, "writer", PoolBehavior::Wait(Duration::from_secs(5)));
#[test]
        elapsed >= Duration::from_millis(400),
        assert_eq!(reservation.size(), 5_000);
    // Writer requests — should block then succeed after space is freed
        // First allocation succeeds
    );
        MemoryReservation::new(&pool, "writer", PoolBehavior::Wait(Duration::from_secs(2)));
        // Thread 1: grabs 3000, holds for 500ms, releases
        });
            // This blocks until t1 releases (pool: 3000/5000, needs 3000 more = 6000 > 5000)
    reservation.grow(999);
/// Two concurrent requesters on the same pool — one waits for the other, no deadlock.
        MemoryReservation::new(&pool, "blocker", PoolBehavior::Wait(Duration::from_secs(1)));
        assert!(r1.is_ok());
        elapsed
        elapsed
    assert!(
        "Should not hang forever, got {:?}",
        elapsed
    });
 * SPDX-License-Identifier: Apache-2.0
                MemoryReservation::new(&p1, "t1", PoolBehavior::Wait(Duration::from_secs(10)));
        assert_eq!(pool.used(), 5_000);
 * compatible open source license.
    assert!(
        "Should not wait too long, got {:?}",
        "Should have waited ~500ms, got {:?}",
            r.shrink(3_000);
}
        elapsed >= Duration::from_secs(2),
    let mut writer =
            std::thread::sleep(Duration::from_millis(100));
            std::thread::sleep(Duration::from_millis(500));
#[test]
        "Should complete within 5s (no deadlock), got {:?}",
        let r1 = reservation.request(3_000);
    {
 * The OpenSearch Contributors require contributions made to
fn test_request_waits_and_succeeds() {
    assert!(
    let result = writer.request(500);
        assert!(r2.is_err());
        assert_eq!(pool.used(), 5_000); // unchanged by failed request
        // Second request fails — needs 8000 more, total would be 13000 > 10000
    handle.join().unwrap();
        assert_eq!(pool.used(), 3_000);
fn test_no_deadlock_two_requesters_same_pool() {
}
    }
    assert!(
        elapsed < Duration::from_millis(2_000),
        assert_eq!(reservation.size(), 3_000);
    let pool = Arc::new(MemoryPool::new("test", 1_000));
    let start = Instant::now();
                .expect("t2 request should succeed after t1 releases");
/// frees all its memory when dropped.
            let mut r =
        elapsed < Duration::from_millis(2_000),
        let p1 = Arc::clone(&pool);
        // Thread 2: waits 100ms (ensure t1 gets in first), then requests 3000
        // Infallible grow also succeeds
    let handle = std::thread::spawn(move || {
    let result = reservation.request(500);
/// Request blocks and succeeds when another thread frees memory.
    let pool = Arc::new(MemoryPool::new("test", 5_000));
    assert!(result.is_ok(), "Expected success after blocker freed");
        s.spawn(move || {
    });
    std::thread::scope(|s| {
fn test_request_waits_and_times_out() {
    // Pool unchanged — failed request didn't partially allocate
        &pool,
    // Pre-fill pool to near capacity
    blocker.grow(9_500);
    assert!(result.is_err(), "Expected timeout error");
                MemoryReservation::new(&p2, "t2", PoolBehavior::Wait(Duration::from_secs(10)));
        "Should not hang, got {:?}",
    assert_eq!(pool.used(), 999); // blocker unchanged
        PoolBehavior::Wait(Duration::from_secs(1)),
    let pool = Arc::new(MemoryPool::new("test", 10_000));
use std::time::{Duration, Instant};
/// Request times out cleanly when pool is full.
    let elapsed = start.elapsed();
    let elapsed = start.elapsed();
fn test_reservation_drop_frees_all_on_partial_failure() {
//! Tests for memory pool backpressure, timeout, and deadlock prevention.
    let result = writer.request(5_000);
        let r2 = reservation.request(8_000);
    let start = Instant::now();
        elapsed
    // Blocker fills pool
/*
    assert!(
            MemoryReservation::new(&pool, "res", PoolBehavior::Wait(Duration::from_secs(1)));
        elapsed
        elapsed < Duration::from_secs(3),
    assert_eq!(pool.used(), 999);
        s.spawn(move || {
        reservation.grow(2_000);
    assert!(result.is_err(), "Expected timeout");
        elapsed
#[test]
    // Writer holds its allocation
        elapsed >= Duration::from_millis(900),
        MemoryReservation::new(&pool, "blocker", PoolBehavior::Wait(Duration::from_secs(1)));
    let pool_clone = Arc::clone(&pool);
}
    blocker.grow(999);
        elapsed
    assert_eq!(writer.size(), 5_000);
    // After drop — all previously allocated memory is freed
 * this file be licensed under the Apache-2.0 license or a
    // Request more than available — should timeout
    );
use std::sync::Arc;
}
    assert_eq!(pool.used(), 0, "Drop should free all tracked memory");
    let mut blocker =
    let mut reservation = MemoryReservation::new(
    let mut writer =
    // Thread frees after 500ms
#[test]
    );
    );
    );
 *
    assert_eq!(pool.used(), 0, "Pool should be empty after both complete");
        let mut reservation =
        "Should wait full timeout, got {:?}",
use native_bridge_common::memory_pool::{MemoryPool, MemoryReservation, PoolBehavior};
        pool_clone.shrink(9_500);
/// Reservation that partially succeeded then failed on a subsequent request
        "Should have waited ~1s, got {:?}",
        std::thread::sleep(Duration::from_millis(500));
            r.shrink(3_000);
#[test]
    let start = Instant::now();
            r.request(3_000).expect("t1 request should succeed");
            let mut r =
    let elapsed = start.elapsed();
        assert_eq!(reservation.size(), 5_000); // unchanged
            r.request(3_000)
    );
    assert!(
    assert_eq!(pool.used(), 999);
    let pool = Arc::new(MemoryPool::new("test", 10_000));
    );
        // reservation drops here
}
    assert_eq!(pool.used(), 9_500);
    let mut blocker =
        let p2 = Arc::clone(&pool);
