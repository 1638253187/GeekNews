package com.windhang.geeknews.bean;

import java.util.List;

public class NewsBean {

    /**
     * date : 20190710
     * stories : [{"images":["https://pic2.zhimg.com/v2-65bb27242a8afed21745a413b30b0abd.jpg"],"type":0,"id":9713204,"ga_prefix":"071009","title":"儿子的玩伴很聪明也算很有心机，还应该让孩子跟他一起玩吗？"},{"images":["https://pic2.zhimg.com/v2-5660299369561369ee08680a4106c90d.jpg"],"type":0,"id":9713224,"ga_prefix":"071007","title":"为什么滑石粉作为一种已知致癌物，还被添加进化妆品里？"},{"images":["https://pic1.zhimg.com/v2-66a0380f0bafc118652eae0800858f28.jpg"],"type":0,"id":9713298,"ga_prefix":"071006","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic4.zhimg.com/v2-a1a6a6286dcb6249abb0f12cba7e0a7f.jpg","type":0,"id":9713253,"ga_prefix":"070907","title":"为什么把鱼放进可乐和雪碧中浸泡 30 天，鱼没了？"},{"image":"https://pic3.zhimg.com/v2-0561e05c2cdc1e230884967e5b3d0692.jpg","type":0,"id":9713084,"ga_prefix":"070409","title":"垃圾分类的难点，不仅是学会分类而已"},{"image":"https://pic4.zhimg.com/v2-6e440ce3443c435c0db5e57a30df9bbb.jpg","type":0,"id":9713146,"ga_prefix":"070620","title":"《长安十二时辰》中的望楼是什么？"},{"image":"https://pic3.zhimg.com/v2-7f708d55176cf8861b3cfce6bb4136fe.jpg","type":0,"id":9713072,"ga_prefix":"070306","title":"瞎扯 · 如何正确地吐槽"},{"image":"https://pic4.zhimg.com/v2-e93a312f674d01e57bca0e0abe897547.jpg","type":0,"id":9712644,"ga_prefix":"061914","title":"自己人的广告 · 终极问题的终极答案"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic2.zhimg.com/v2-65bb27242a8afed21745a413b30b0abd.jpg"]
         * type : 0
         * id : 9713204
         * ga_prefix : 071009
         * title : 儿子的玩伴很聪明也算很有心机，还应该让孩子跟他一起玩吗？
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic4.zhimg.com/v2-a1a6a6286dcb6249abb0f12cba7e0a7f.jpg
         * type : 0
         * id : 9713253
         * ga_prefix : 070907
         * title : 为什么把鱼放进可乐和雪碧中浸泡 30 天，鱼没了？
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
