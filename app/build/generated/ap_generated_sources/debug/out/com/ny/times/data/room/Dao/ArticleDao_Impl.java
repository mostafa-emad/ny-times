package com.ny.times.data.room.Dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ny.times.data.room.entity.ArticleEntity;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ArticleDao_Impl implements ArticleDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ArticleEntity> __insertionAdapterOfArticleEntity;

  public ArticleDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfArticleEntity = new EntityInsertionAdapter<ArticleEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `article` (`id`,`title`,`source`,`byline`,`date`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ArticleEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getSource() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSource());
        }
        if (value.getByline() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getByline());
        }
        if (value.getDate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDate());
        }
      }
    };
  }

  @Override
  public void inset(final List<ArticleEntity> entities) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfArticleEntity.insert(entities);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void inset(final ArticleEntity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfArticleEntity.insert(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<ArticleEntity>> getAllLiveData() {
    final String _sql = "SELECT * FROM article";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"article"}, false, new Callable<List<ArticleEntity>>() {
      @Override
      public List<ArticleEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfByline = CursorUtil.getColumnIndexOrThrow(_cursor, "byline");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final List<ArticleEntity> _result = new ArrayList<ArticleEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ArticleEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpSource;
            _tmpSource = _cursor.getString(_cursorIndexOfSource);
            final String _tmpByline;
            _tmpByline = _cursor.getString(_cursorIndexOfByline);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item = new ArticleEntity(_tmpId,_tmpTitle,_tmpSource,_tmpByline,_tmpDate);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<ArticleEntity> getAll() {
    final String _sql = "SELECT * FROM article";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
      final int _cursorIndexOfByline = CursorUtil.getColumnIndexOrThrow(_cursor, "byline");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final List<ArticleEntity> _result = new ArrayList<ArticleEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ArticleEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpSource;
        _tmpSource = _cursor.getString(_cursorIndexOfSource);
        final String _tmpByline;
        _tmpByline = _cursor.getString(_cursorIndexOfByline);
        final String _tmpDate;
        _tmpDate = _cursor.getString(_cursorIndexOfDate);
        _item = new ArticleEntity(_tmpId,_tmpTitle,_tmpSource,_tmpByline,_tmpDate);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public ArticleEntity getArticleById(final String id) {
    final String _sql = "SELECT * FROM article WHERE `id`=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
      final int _cursorIndexOfByline = CursorUtil.getColumnIndexOrThrow(_cursor, "byline");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final ArticleEntity _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpSource;
        _tmpSource = _cursor.getString(_cursorIndexOfSource);
        final String _tmpByline;
        _tmpByline = _cursor.getString(_cursorIndexOfByline);
        final String _tmpDate;
        _tmpDate = _cursor.getString(_cursorIndexOfDate);
        _result = new ArticleEntity(_tmpId,_tmpTitle,_tmpSource,_tmpByline,_tmpDate);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
