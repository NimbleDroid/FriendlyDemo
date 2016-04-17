package nyc.friendlyrobot.demo.ui.main;

import nyc.friendlyrobot.demo.ui.base.BaseActivity;

public class MainActivity extends BaseActivity  {

    private static final String EXTRA_TRIGGER_SYNC_FLAG =
            "nyc.friendlyrobot.sample.ui.main.MainActivity.EXTRA_TRIGGER_SYNC_FLAG";

//    @Inject MainPresenter presenter;
//    @Inject RibotsAdapter adapter;
//
//
//    @Bind(R.id.postRecyclerView) RecyclerView mRecyclerView;
//
//    /**
//     * Return an Intent to start this Activity.
//     * triggerDataSyncOnCreate allows disabling the background sync service onCreate. Should
//     * only be set to false during testing.
//     */
//    public static Intent getStartIntent(Context context, boolean triggerDataSyncOnCreate) {
//        Intent intent = new Intent(context, MainActivity.class);
//        intent.putExtra(EXTRA_TRIGGER_SYNC_FLAG, triggerDataSyncOnCreate);
//        return intent;
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        getActivityComponent().inject(this);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//
//        mRecyclerView.setAdapter(adapter);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        presenter.attachView(this);
//        presenter.loadFoos();
//
//
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//        presenter.detachView();
//    }
//
//    /***** MVP View methods implementation *****/
//
////    @Override
////    public void showLoo(List<PostData> loos) {
////        adapter.setLoos(loos);
////        adapter.notifyDataSetChanged();
////    }
//
//    @Override
//    public void showError() {
//        DialogFactory.createGenericErrorDialog(this, getString(R.string.error_loading_ribots))
//                .show();
//    }

}
