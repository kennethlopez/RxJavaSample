package com.rxjavasample;

import com.rxjavasample.data.local.UserDb;
import com.rxjavasample.data.manger.UserDataManager;
import com.rxjavasample.data.model.User;
import com.rxjavasample.data.remote.ApiService;
import com.rxjavasample.test.common.TestDataFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.subscribers.TestSubscriber;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserDataManagerTest {
    @InjectMocks UserDataManager mUserDataManager;
    @Mock UserDb mUserDb;
    @Mock ApiService mApiService;

    @Test
    public void syncUsersEmitsValues() {
        List<User> users = TestDataFactory.makeListUsers(2);
        studSyncUserHelperCalls(users);

        TestSubscriber<User> testSubscriber = new TestSubscriber<>();
        mUserDataManager.syncUsers().subscribe(testSubscriber);

        testSubscriber.awaitTerminalEvent();
        testSubscriber.assertNoErrors()
                .assertValues(users.get(0), users.get(1));
    }

    @Test
    public void syncUsersDoesNotCallFetchUserWhenDatabaseReturnsEmpty() {
        User user = TestDataFactory.makeUser(1);
        studSyncUserHelperCalls(new ArrayList<>());

        mUserDataManager.syncUsers().subscribe();

        verify(mUserDb).getAllAsList(User.class);
        verify(mApiService, never()).getUser(user.getLogin());
        verify(mApiService, never()).getFollowers(user.getLogin());
        verify(mUserDb, never()).updateOrSave(user);
    }

    @Test
    public void fetchUserCallsApiAndDatabase() {
        User user = TestDataFactory.makeUser(1);
        stubFetchUserHelperCalls(user);

        mUserDataManager.fetchUser(user.getLogin()).subscribe();

        // verify right calls to helper methods
        verify(mApiService).getUser(user.getLogin());
        verify(mApiService).getFollowers(user.getLogin());
        verify(mUserDb).updateOrSave(user);
    }

    @Test
    public void fetchUserEmitsValue() {
        User user = TestDataFactory.makeUser(1);
        stubFetchUserHelperCalls(user);

        TestSubscriber<User> testSubscriber = new TestSubscriber<>();
        mUserDataManager.fetchUser(user.getLogin()).subscribe(testSubscriber);

        testSubscriber.awaitTerminalEvent();
        testSubscriber.assertNoErrors()
                .assertValue(user);
    }

    @Test
    public void fetchUserDoesNotCallDatabaseWhenApiFails() {
        User user = TestDataFactory.makeUser(1);

        when(mApiService.getUser(user.getLogin()))
                .thenReturn(Flowable.just(user));
        when(mApiService.getFollowers(user.getLogin()))
                .thenReturn(Flowable.error(new RuntimeException()));

        mUserDataManager.fetchUser(user.getLogin()).subscribe();

        verify(mApiService).getUser(user.getLogin());
        verify(mApiService).getFollowers(user.getLogin());
        verify(mUserDb, never()).updateOrSave(user);
    }

    private void studSyncUserHelperCalls(List<User> users) {
        // stub calls to UserDb and UserDataManager#fetchUser() helper calls
        when(mUserDb.getAllAsList(User.class))
                .thenReturn(Flowable.just(users));
        for (User user : users) {
            stubFetchUserHelperCalls(user);
        }
    }

    private void stubFetchUserHelperCalls(User user) {
        // stub calls to ApiService and UserDb
        when(mApiService.getUser(user.getLogin()))
                .thenReturn(Flowable.just(user));
        when(mApiService.getFollowers(user.getLogin()))
                .thenReturn(Flowable.just(user.getFollowersList()));
        when(mUserDb.updateOrSave(user))
                .thenReturn(Flowable.just(user));
    }
}