package com.example.myorder.bean;
/*
 *@auther:谷建龙
 *@Date: 2020/2/11
 *@Time:17:16
 *@Description:
 * */


import java.util.List;

public class OrderBean {
    /**
     * orderList : [{"detailList":[{"commentStatus":1,"commodityCount":4,"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/5.jpg","commodityPrice":39,"orderDetailId":12995},{"commentStatus":1,"commodityCount":4,"commodityId":11,"commodityName":"盒装葫芦粉扑美妆蛋化妆海绵","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/5.jpg","commodityPrice":9,"orderDetailId":12996}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020021017152502027909","orderStatus":1,"orderTime":1581326125000,"payAmount":192,"payMethod":1,"userId":27909},{"detailList":[{"commentStatus":1,"commodityCount":4,"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/5.jpg","commodityPrice":39,"orderDetailId":12283},{"commentStatus":1,"commodityCount":4,"commodityId":11,"commodityName":"盒装葫芦粉扑美妆蛋化妆海绵","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/5.jpg","commodityPrice":9,"orderDetailId":12284}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020012215125559327909","orderStatus":2,"orderTime":1579677176000,"payAmount":192,"payMethod":1,"userId":27909},{"detailList":[{"commentStatus":2,"commodityCount":4,"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/5.jpg","commodityPrice":39,"orderDetailId":12221},{"commentStatus":2,"commodityCount":4,"commodityId":11,"commodityName":"盒装葫芦粉扑美妆蛋化妆海绵","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/5.jpg","commodityPrice":9,"orderDetailId":12222}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020011712144058727909","orderStatus":9,"orderTime":1579234481000,"payAmount":192,"payMethod":1,"userId":27909},{"detailList":[{"commentStatus":1,"commodityCount":4,"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/5.jpg","commodityPrice":39,"orderDetailId":12219},{"commentStatus":1,"commodityCount":4,"commodityId":11,"commodityName":"盒装葫芦粉扑美妆蛋化妆海绵","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/5.jpg","commodityPrice":9,"orderDetailId":12220}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020011712134511327909","orderStatus":3,"orderTime":1579234425000,"payAmount":192,"payMethod":1,"userId":27909}]
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
         * detailList : [{"commentStatus":1,"commodityCount":4,"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/5.jpg","commodityPrice":39,"orderDetailId":12995},{"commentStatus":1,"commodityCount":4,"commodityId":11,"commodityName":"盒装葫芦粉扑美妆蛋化妆海绵","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/1/5.jpg","commodityPrice":9,"orderDetailId":12996}]
         * expressCompName : 京东快递
         * expressSn : 1001
         * orderId : 2020021017152502027909
         * orderStatus : 1
         * orderTime : 1581326125000
         * payAmount : 192
         * payMethod : 1
         * userId : 27909
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
             * commodityPic : http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/5.jpg
             * commodityPrice : 39
             * orderDetailId : 12995
             */

            private int commentStatus;
            private int commodityCount;
            private int commodityId;
            private String commodityName;
            private String commodityPic;
            private double commodityPrice;
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

            public double getCommodityPrice() {
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
