package com.web_view.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

data class Memo(var no: Long?, var content: String)

class SQLiteHelper(context: Context, name: String, version: Int)
    : SQLiteOpenHelper(context, name, null, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        val create = "create table memo (`no` integer primary key, content text)"
        db?.execSQL(create)
    }

    fun insertMemo(memo: Memo){
        val wd = writableDatabase

        val values = ContentValues()
        values.put("content", memo.content)

        wd.insert("memo", null, values)
        wd.close()
    }

    fun selectMemo(): MutableList<Memo>{
        val list = mutableListOf<Memo>()
        val rd = readableDatabase
        val select = "select * from memo"
        val cursor = rd.rawQuery(select, null)
        while(cursor.moveToNext()){
            val no = cursor.getLong(cursor.getColumnIndex("no"))
            val content = cursor.getString(cursor.getColumnIndex("content"))

            val memo = Memo(no, content)
            list.add(memo)
        }

        cursor.close()
        rd.close()

        return list
    }

    fun updateMemo(memo: Memo){
        val wd = writableDatabase

        val values = ContentValues()
        values.put("content", memo.content)

        wd.update("memo", values, "no = ${memo.no}", null)

        wd.close()
    }

    fun deleteMemo(memo: Memo){
        val wd = writableDatabase

        wd.delete("memo", "no = ${memo.no}", null)

        wd.close()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}
}