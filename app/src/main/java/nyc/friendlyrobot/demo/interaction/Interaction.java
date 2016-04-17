package nyc.friendlyrobot.demo.interaction;

import android.database.Cursor;

import com.squareup.sqlbrite.BriteDatabase;

import javax.inject.Inject;

import dagger.Lazy;

public class Interaction {
    @Inject
    Lazy<BriteDatabase> db;



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
