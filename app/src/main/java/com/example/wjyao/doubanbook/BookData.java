package com.example.wjyao.doubanbook;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wjyao on 3/4/17.
 */
public class BookData {
    private static String COUNT = "count";
    private static String START = "start";
    private static String TOTAL = "total";
    private static String BOOKS = "books";

    private final JSONObject mJsonObject;

    public BookData(JSONObject mJsonObject) {
        this.mJsonObject = mJsonObject;
    }

    public int getCOUNT() {
        return mJsonObject.optInt(COUNT);
    }

    public int getSTART() {
        return mJsonObject.optInt(START);
    }

    public int getTOTAL() {
        return mJsonObject.optInt(TOTAL);
    }

    public int getBOOKS() {
        return mJsonObject.optInt(BOOKS);
    }

    public List<Book> getBooks() {
        JSONArray array = mJsonObject.optJSONArray(BOOKS);

        List<Book> books = new ArrayList<Book>(array.length());

        for (int i = 0; i < array.length(); i++) {
            JSONObject object = (JSONObject) array.opt(i);
            books.add(
                    new Book(
                        object.optString("title"),
                        object.optString("image"),
                        object.optJSONArray("author").toString(),
                        object.optString("publisher"),
                        object.optString("publishDate"),
                        object.optString("summary"),
                        object.optJSONObject("rating").optDouble("average")
                    )
            );
        }

        return books;
    }

}
