package com.example.lianxi2.bean;
/*
 *@auther:谷建龙
 *@Date: 2020/1/9
 *@Time:11:52
 *@Description:
 * */


import java.util.List;

public class OrderBean {
    /**
     * orderList : [{"detailList":[{"commentStatus":1,"commodityCount":4,"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/4/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/4/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/4/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/4/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/4/5.jpg,","commodityPrice":39,"orderDetailId":22756},{"commentStatus":1,"commodityCount":4,"commodityId":11,"commodityName":"盒装葫芦粉扑美妆蛋化妆海绵","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/5.jpg","commodityPrice":9,"orderDetailId":22757}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020010816161084211357","orderStatus":1,"orderTime":1578471371000,"payAmount":192,"payMethod":1,"userId":11357},{"detailList":[{"commentStatus":1,"commodityCount":4,"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/4/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/4/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/4/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/4/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/4/5.jpg,","commodityPrice":39,"orderDetailId":22715},{"commentStatus":1,"commodityCount":4,"commodityId":11,"commodityName":"盒装葫芦粉扑美妆蛋化妆海绵","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/5.jpg","commodityPrice":9,"orderDetailId":22716}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020010815485076511357","orderStatus":1,"orderTime":1578469731000,"payAmount":192,"payMethod":1,"userId":11357},{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":3,"commodityName":"Lara style女神的魔盒全套彩妆","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/1/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/1/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/1/3.jpg","commodityPrice":3499,"orderDetailId":22173},{"commentStatus":1,"commodityCount":1,"commodityId":5,"commodityName":"双头两用修容笔","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/3/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/3/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/3/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/3/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/3/5.jpg,","commodityPrice":39,"orderDetailId":22174}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2019121609171874511357","orderStatus":3,"orderTime":1576459039000,"payAmount":3538,"payMethod":1,"userId":11357},{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":3,"commodityName":"Lara style女神的魔盒全套彩妆","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/1/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/1/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/1/3.jpg","commodityPrice":3499,"orderDetailId":22075},{"commentStatus":1,"commodityCount":1,"commodityId":5,"commodityName":"双头两用修容笔","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/3/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/3/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/3/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/3/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/3/5.jpg,","commodityPrice":39,"orderDetailId":22076}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2019121411193156011357","orderStatus":1,"orderTime":1576293572000,"payAmount":3538,"payMethod":1,"userId":11357},{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/4/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/4/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/4/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/4/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/4/5.jpg,","commodityPrice":39,"orderDetailId":22073},{"commentStatus":1,"commodityCount":1,"commodityId":15,"commodityName":"玻儿精灵美妆蛋一个","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/5.jpg","commodityPrice":6,"orderDetailId":22074}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2019121411152884311357","orderStatus":1,"orderTime":1576293329000,"payAmount":45,"payMethod":1,"userId":11357}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<OrderListBean> orderList;

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

    public List<OrderListBean> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderListBean> orderList) {
        this.orderList = orderList;
    }

    public static class OrderListBean {
        /**
         * detailList : [{"commentStatus":1,"commodityCount":4,"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/cz/4/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/4/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/4/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/4/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/4/5.jpg,","commodityPrice":39,"orderDetailId":22756},{"commentStatus":1,"commodityCount":4,"commodityId":11,"commodityName":"盒装葫芦粉扑美妆蛋化妆海绵","commodityPic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/5.jpg","commodityPrice":9,"orderDetailId":22757}]
         * expressCompName : 京东快递
         * expressSn : 1001
         * orderId : 2020010816161084211357
         * orderStatus : 1
         * orderTime : 1578471371000
         * payAmount : 192
         * payMethod : 1
         * userId : 11357
         */

        private String expressCompName;
        private String expressSn;
        private String orderId;
        private int orderStatus;
        private long orderTime;
        private int payAmount;
        private int payMethod;
        private int userId;
        private List<DetailListBean> detailList;

        public String getExpressCompName() {
            return expressCompName;
        }

        public void setExpressCompName(String expressCompName) {
            this.expressCompName = expressCompName;
        }

        public String getExpressSn() {
            return expressSn;
        }

        public void setExpressSn(String expressSn) {
            this.expressSn = expressSn;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public int getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
        }

        public long getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(long orderTime) {
            this.orderTime = orderTime;
        }

        public int getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(int payAmount) {
            this.payAmount = payAmount;
        }

        public int getPayMethod() {
            return payMethod;
        }

        public void setPayMethod(int payMethod) {
            this.payMethod = payMethod;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public List<DetailListBean> getDetailList() {
            return detailList;
        }

        public void setDetailList(List<DetailListBean> detailList) {
            this.detailList = detailList;
        }

        public static class DetailListBean {
            /**
             * commentStatus : 1
             * commodityCount : 4
             * commodityId : 6
             * commodityName : 轻柔系自然裸妆假睫毛
             * commodityPic : http://172.17.8.100/images/small/commodity/mzhf/cz/4/1.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/4/2.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/4/3.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/4/4.jpg,http://172.17.8.100/images/small/commodity/mzhf/cz/4/5.jpg,
             * commodityPrice : 39
             * orderDetailId : 22756
             */

            private int commentStatus;
            private int commodityCount;
            private int commodityId;
            private String commodityName;
            private String commodityPic;
            private int commodityPrice;
            private int orderDetailId;

            public int getCommentStatus() {
                return commentStatus;
            }

            public void setCommentStatus(int commentStatus) {
                this.commentStatus = commentStatus;
            }

            public int getCommodityCount() {
                return commodityCount;
            }

            public void setCommodityCount(int commodityCount) {
                this.commodityCount = commodityCount;
            }

            public int getCommodityId() {
                return commodityId;
            }

            public void setCommodityId(int commodityId) {
                this.commodityId = commodityId;
            }

            public String getCommodityName() {
                return commodityName;
            }

            public void setCommodityName(String commodityName) {
                this.commodityName = commodityName;
            }

            public String getCommodityPic() {
                return commodityPic;
            }

            public void setCommodityPic(String commodityPic) {
                this.commodityPic = commodityPic;
            }

            public int getCommodityPrice() {
                return commodityPrice;
            }

            public void setCommodityPrice(int commodityPrice) {
                this.commodityPrice = commodityPrice;
            }

            public int getOrderDetailId() {
                return orderDetailId;
            }

            public void setOrderDetailId(int orderDetailId) {
                this.orderDetailId = orderDetailId;
            }
        }
    }
}
