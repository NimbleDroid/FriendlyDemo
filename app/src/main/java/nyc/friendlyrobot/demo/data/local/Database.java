package nyc.friendlyrobot.demo.data.local;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

import nyc.friendlyrobot.demo.data.model.Post;


@Singleton
public  class Database extends SQLiteOpenHelper {
  private static final int DATABASE_VERSION = 1;

  @Inject
  public Database(Application context) {
    super(context, "db", null, DATABASE_VERSION);
  }

  @Override public void onCreate(SQLiteDatabase db) {
    db.execSQL(Post.CREATE_TABLE);
  }

  @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    //used for upgrading to new data model.
  }


}
