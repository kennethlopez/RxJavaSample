package com.rxjavasample.util;


import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.subjects.PublishSubject;

public class RxBus {
    private final BackpressureStrategy mBackPressureStrategy = BackpressureStrategy.BUFFER;
    private final PublishSubject<Object> mBusSubject;

    public RxBus() {
        mBusSubject = PublishSubject.create();
    }

    /**
     * Posts an object (usually an Event) to the bus
     */
    public void post(Object event) {
        mBusSubject.onNext(event);
    }

    /**
     * Observable that will emmit everything posted to the event bus.
     */
    public Flowable<Object> observalble(){
        return mBusSubject.toFlowable(mBackPressureStrategy);
    }

    /**
     * Observable that only emits events of a specific class.
     * Use this if you only want to subscribe to one type of events.
     */
    public <T> Flowable <T> filteredObservable(Class<T> clazz) {
        return mBusSubject.ofType(clazz).toFlowable(mBackPressureStrategy);
    }
}