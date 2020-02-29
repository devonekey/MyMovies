package com.onekey.mymovies.data.source.local;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.onekey.mymovies.BuildConfig;

public class MovieDatabaseOpenHelper extends SQLiteOpenHelper implements MovieEntry {
    private static MovieDatabaseOpenHelper movieDatabaseOpenHelper;
    private Context context;
    private static final int DB_VERSION = 1;
    private static final String TAG = MovieDatabaseOpenHelper.class.getSimpleName();

    private MovieDatabaseOpenHelper(@Nullable Context context,
                                   @Nullable String name) {
        super(context, name, null, DB_VERSION);

        this.context = context;
    }

    static MovieDatabaseOpenHelper getInstance(@NonNull Context context) {
        if (movieDatabaseOpenHelper == null) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String[] splitPackageName = applicationInfo.packageName.split("\\.");
            String name = splitPackageName[splitPackageName.length - 1] + "Movie.db";
            movieDatabaseOpenHelper = new MovieDatabaseOpenHelper(context, name);
        }

        return movieDatabaseOpenHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "/onCreate");
        }

        String sql = "CREATE TABLE IF NOT EXISTS `" + TABLE_NAME + "` (`" +
                COLUMN_NAME_ID + "` INTEGER PRIMARY KEY, `" +
                COLUMN_NAME_URL + "` TEXT NOT NULL, `" +
                COLUMN_NAME_TITLE + "` TEXT NOT NULL, `" +
                COLUMN_NAME_DESCRIPTION + "` TEXT NOT NULL, `" +
                COLUMN_NAME_LIKE + "` INTEGER NOT NULL, `" +
                COLUMN_NAME_CREATED_AT + "` TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP, `" +
                COLUMN_NAME_UPDATED_AT + "` TEXT DEFAULT NULL);";
        sql += "CREATE INDEX `" + INDEX + "` ON `" +
                TABLE_NAME + "` (`" +
                COLUMN_NAME_CREATED_AT + "`, `" +
                COLUMN_NAME_UPDATED_AT + "`);";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion,
                          int newVersion) {
    }
}
