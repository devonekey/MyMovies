package com.onekey.mymovies.data.source.local;

public interface MovieEntry {
    String TABLE_NAME = "movie";
    String COLUMN_NAME_ID = "id";
    String COLUMN_NAME_URL = "url";
    String COLUMN_NAME_TITLE = "title";
    String COLUMN_NAME_DESCRIPTION = "description";
    String COLUMN_NAME_LIKE = "like";
    String COLUMN_NAME_CREATED_AT = "created_at";
    String COLUMN_NAME_UPDATED_AT = "updated_at";
    String INDEX = "index";
}
