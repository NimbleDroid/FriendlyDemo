package nyc.friendlyrobot.anchor.data;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.IBinder;

import nyc.friendlyrobot.anchor.util.AndroidComponentUtil;
import nyc.friendlyrobot.anchor.util.NetworkUtil;
import rx.Subscription;
import timber.log.Timber;

public class SyncService extends Service {

    private Subscription mSubscription;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, SyncService.class);
    }

    public static boolean isRunning(Context context) {
        return AndroidComponentUtil.isServiceRunning(context, SyncService.class);
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        BoilerplateApplication.get(this).getComponent().inject(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, final int startId) {
        Timber.i("Starting sync...");

        if (!NetworkUtil.isNetworkConnected(this)) {
            Timber.i("Sync canceled, connection not available");
            AndroidComponentUtil.toggleComponent(this, SyncOnConnectionAvailable.class, true);
            stopSelf(startId);
            return START_NOT_STICKY;
        }

        if (mSubscription != null && !mSubscription.isUnsubscribed()) mSubscription.unsubscribe();
//        mSubscription = mDataManager.syncRibots()
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<Ribot>() {
//                    @Override
//                    public void onCompleted() {
//                        Timber.i("Synced successfully!");
//                        stopSelf(startId);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Timber.w(e, "Error syncing.");
//                        stopSelf(startId);
//
//                    }
//
//                    @Override
//                    public void onNext(Ribot ribot) {
//                    }
//                });

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        if (mSubscription != null) mSubscription.unsubscribe();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static class SyncOnConnectionAvailable extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)
                    && NetworkUtil.isNetworkConnected(context)) {
                Timber.i("Connection is now available, triggering sync...");
                AndroidComponentUtil.toggleComponent(context, this.getClass(), false);
                context.startService(getStartIntent(context));
            }
        }
    }

}
