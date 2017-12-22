package com.rxjavasample.util;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.reactivex.subscribers.TestSubscriber;

public class RxBusTest {
    private RxBus mBus;

    @Rule
    // Must be added to every test class that targets app code that uses RxJava
    public final RxSchedulersOverrideRule mOverrideSchedulersRule = new RxSchedulersOverrideRule();

    @Before
    public void setUp() {
        mBus = new RxBus();
    }

    @Test
    public void postedObjectsAreReceived() {
        TestSubscriber<Object> testSubscriber = new TestSubscriber<>();
        mBus.observalble().subscribe(testSubscriber);

        Object event1 = new Object();
        Object event2 = new Object();
        mBus.post(event1);
        mBus.post(event2);

        testSubscriber.assertValues(event1, event2);
    }

    @Test
    public void filteredObservableOnlyReceivesSomeObjects() {
        TestSubscriber<Object> testSubscriber = new TestSubscriber<>();
        mBus.filteredObservable(String.class).subscribe(testSubscriber);

        String stringEvent = "string event";
        Integer intEvent = 20;
        mBus.post(stringEvent);
        mBus.post(intEvent);

        testSubscriber.assertValueCount(1);
        testSubscriber.assertValue(stringEvent);
    }
}
