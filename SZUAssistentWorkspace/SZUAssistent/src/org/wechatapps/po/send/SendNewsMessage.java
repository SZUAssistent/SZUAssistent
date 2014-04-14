package org.wechatapps.po.send;

import org.wechatapps.po.BaseMessage;

/*
 * @Description News Message for Sending
 * @author Charles Chen
 * @date 14-4-12
 * @version 1.0
 */
public class SendNewsMessage extends BaseMessage{
    private String ArticleCount;
    private Articles Articles;

    public String getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(String articleCount) {
        ArticleCount = articleCount;
    }

    public Articles getArticles() {
        return Articles;
    }

    public void setArticles(Articles articles) {
        Articles = articles;
    }
}
