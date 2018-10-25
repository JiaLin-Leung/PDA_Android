package com.pda.pda_android.db.bean;

import java.util.UUID;

/**
 * 梁佳霖创建于：2018/10/24 09:42
 * 功能：Phrase表javabean
 */
public class Phrase {

    private String mId; // 短语的唯一标识
    private String mContent; // 短语的内容
    private int mFavorite; // 是否是收藏状态：0表示未收藏，1表示已收藏；

    public Phrase(String content) {
        this(UUID.randomUUID().toString(), content, 0);
    }

    public Phrase(String content, int favorite) {
        this(UUID.randomUUID().toString(), content, favorite);
    }

    public Phrase(String id, String content, int favorite) {
        mId = id;
        mContent = content;
        mFavorite = favorite;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public int getFavorite() {
        return mFavorite;
    }

    public void setFavorite(int favorite) {
        mFavorite = favorite;
    }

    @Override
    public String toString() {
        return "\n Phrase id: " + mId
                + " content: " + mContent
                + " favorite: " + mFavorite;
    }
}
