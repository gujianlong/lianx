package com.example.myapplication.bean;
/*
 *@auther:谷建龙
 *@Date: 2019/12/17
 *@Time:14:52
 *@Description:
 * */


import java.util.List;

public class CircleBean {
    /**
     * result : [{"commodityId":1,"content":"来了来了终于来了","createTime":1576550827000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/default/user.jpg","id":39606,"image":"http://172.17.8.100/images/small/circle_pic/2019-12-16/5136220191216204707.png","nickName":"a8_2HZ1N","userId":11375,"whetherGreat":2},{"commodityId":17,"content":"给大家推荐一个好商品","createTime":1576536580000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/head_pic/2019-12-13/20191213141138.png","id":39605,"image":"http://172.17.8.100/images/small/circle_pic/2019-12-16/8075320191216164940.png","nickName":"第三周周考","userId":9366,"whetherGreat":2},{"commodityId":17,"content":"给大家推荐一个好商品","createTime":1576536482000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/head_pic/2019-12-13/20191213141138.png","id":39604,"image":"http://172.17.8.100/images/small/circle_pic/2019-12-16/5098220191216164802.png","nickName":"第三周周考","userId":9366,"whetherGreat":2},{"commodityId":17,"content":"给大家推荐一个好商品","createTime":1576535838000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/head_pic/2019-12-13/20191213141138.png","id":39603,"image":"http://172.17.8.100/images/small/circle_pic/2019-12-16/0417820191216163718.png","nickName":"第三周周考","userId":9366,"whetherGreat":2},{"commodityId":5,"content":"给大家推荐一个好商品00","createTime":1576344446000,"greatNum":0,"headPic":"http://172.17.8.100/images/small/head_pic/2019-12-14/20191214093029.jpg","id":39602,"image":"http://172.17.8.100/images/small/circle_pic/2019-12-14/1724620191214112726.jpg","nickName":"我的世界你不在","userId":13044,"whetherGreat":2}]
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
         * commodityId : 1
         * content : 来了来了终于来了
         * createTime : 1576550827000
         * greatNum : 0
         * headPic : http://172.17.8.100/images/small/default/user.jpg
         * id : 39606
         * image : http://172.17.8.100/images/small/circle_pic/2019-12-16/5136220191216204707.png
         * nickName : a8_2HZ1N
         * userId : 11375
         * whetherGreat : 2
         */

        private int commodityId;
        private String content;
        private long createTime;
        private int greatNum;
        private String headPic;
        private int id;
        private String image;
        private String nickName;
        private int userId;
        private int whetherGreat;

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getWhetherGreat() {
            return whetherGreat;
        }

        public void setWhetherGreat(int whetherGreat) {
            this.whetherGreat = whetherGreat;
        }
    }
}
