package nyc.friendlyrobot.demo.interaction;

import android.database.Cursor;

import com.squareup.sqlbrite.BriteDatabase;

import javax.inject.Inject;

import dagger.Lazy;
import nyc.friendlyrobot.demo.data.remote.Api;

//Base class for any 1 reactive task
// such as saving or reading from db or saving to network.
public class Interaction {
    @Inject
    Lazy<BriteDatabase> db;
    @Inject
    Api api;



    public boolean recordExists(String TableName,
                                String dbfield, String fieldValue) {
        String Query = "Select * from " + TableName + " where " + dbfield + " = " + fieldValue;
        Cursor cursor = db.get().query(Query);
        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

}
