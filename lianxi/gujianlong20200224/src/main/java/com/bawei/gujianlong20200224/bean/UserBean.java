package com.bawei.gujianlong20200224.bean;
/*
 *@auther:谷建龙
 *@Date: 2020/2/24
 *@Time:13:32
 *@Description:
 * */


import java.util.List;

public class UserBean {

    /**
     * result : [{"giftPic":"http://mobile.bwstudent.com/images/live/gift/ice_cream.png","handselTime":1582473600000,"headPic":"http://mobile.bwstudent.com/images/live/head_pic/2020-02-17/20200217220658.jpg","nickName":"Android干货铺"},{"giftPic":"http://mobile.bwstudent.com/images/live/gift/ice_cream.png","handselTime":1582473600000,"headPic":"http://mobile.bwstudent.com/images/live/head_pic/2020-02-17/20200217220658.jpg","nickName":"Android干货铺"},{"giftPic":"http://mobile.bwstudent.com/images/live/gift/flower.png","handselTime":1582473600000,"headPic":"http://mobile.bwstudent.com/images/live/head_pic/2020-02-17/20200217220658.jpg","nickName":"Android干货铺"},{"giftPic":"http://mobile.bwstudent.com/images/live/gift/ice_cream.png","handselTime":1582473600000,"headPic":"http://mobile.bwstudent.com/images/live/head_pic/2020-02-17/20200217220658.jpg","nickName":"Android干货铺"},{"giftPic":"http://mobile.bwstudent.com/images/live/gift/flower.png","handselTime":1582473600000,"headPic":"http://mobile.bwstudent.com/images/live/head_pic/2020-02-17/20200217220658.jpg","nickName":"Android干货铺"},{"giftPic":"http://mobile.bwstudent.com/images/live/gift/flower.png","handselTime":1582473600000,"headPic":"http://mobile.bwstudent.com/images/live/head_pic/2020-02-17/20200217220658.jpg","nickName":"Android干货铺"},{"giftPic":"http://mobile.bwstudent.com/images/live/gift/ice_cream.png","handselTime":1582473600000,"headPic":"http://mobile.bwstudent.com/images/live/head_pic/2020-02-17/20200217220658.jpg","nickName":"Android干货铺"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * giftPic : http://mobile.bwstudent.com/images/live/gift/ice_cream.png
         * handselTime : 1582473600000
         * headPic : http://mobile.bwstudent.com/images/live/head_pic/2020-02-17/20200217220658.jpg
         * nickName : Android干货铺
         */

        private String giftPic;
        private long handselTime;
        private String headPic;
        private String nickName;

        public String getGiftPic() {
            return giftPic;
        }

        public void setGiftPic(String giftPic) {
            this.giftPic = giftPic;
        }

        public long getHandselTime() {
            return handselTime;
        }

        public void setHandselTime(long handselTime) {
            this.handselTime = handselTime;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }
    }
}
