package com.example.myapplication.adapter;
/*
 *@auther:谷建龙
 *@Date: 2019/12/12
 *@Time:13:40
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.bean.HomePageBean;
import com.example.myapplication.utils.GlideUtils;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private final List<HomePageBean.ResultBean.MlssBean> mMlssList;
    private final List<HomePageBean.ResultBean.PzshBean> mPzshList;
    private final List<HomePageBean.ResultBean.RxxpBean> mRxxpList;
    private final int one = 1;
    private final int two = 2;
    private final int three = 3;

    public HomeAdapter(Context context, List<HomePageBean.ResultBean.MlssBean> mMlssList, List<HomePageBean.ResultBean.PzshBean> mPzshList, List<HomePageBean.ResultBean.RxxpBean> mRxxpList) {

        this.context = context;
        this.mMlssList = mMlssList;
        this.mPzshList = mPzshList;
        this.mRxxpList = mRxxpList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View view = null;
        switch (viewType) {
            case one:
                view = View.inflate(context, R.layout.one_item, null);
                holder = new OneHolder(view);
                break;
            case two:
                view = View.inflate(context, R.layout.two_item, null);
                holder = new TwoHolder(view);
                break;
            case three:
                view = View.inflate(context, R.layout.three_item, null);
                holder = new ThreeHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof OneHolder) {
            ((OneHolder) holder).one_recy.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
            OneAdapter oneAdapter = new OneAdapter(mRxxpList.get(0).getCommodityList(), context);
            ((OneHolder) holder).one_recy.setAdapter(oneAdapter);
        } else if (holder instanceof TwoHolder) {
            ((TwoHolder) holder).two_recy.setLayoutManager(new LinearLayoutManager(context));
            TwoAdapter twoAdapter = new TwoAdapter(mMlssList.get(0).getCommodityList(), context);
            ((TwoHolder) holder).two_recy.setAdapter(twoAdapter);
        } else if (holder instanceof ThreeHolder) {
            ((ThreeHolder) holder).three_recy.setLayoutManager(new GridLayoutManager(context, 2));
            ThreeAdapter threeAdapter = new ThreeAdapter(mPzshList.get(0).getCommodityList(), context);
            ((ThreeHolder) holder).three_recy.setAdapter(threeAdapter);
        }
    }

    @Override
    public int getItemCount() {
        return mMlssList.size() + mPzshList.size() + mRxxpList.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return one;
            case 1:
                return two;
            case 2:
                return three;
        }
        return one;
    }

    class OneHolder extends RecyclerView.ViewHolder {
        private final RecyclerView one_recy;

        public OneHolder(@NonNull View itemView) {
            super(itemView);
            one_recy = itemView.findViewById(R.id.one_recy);
        }
    }

    class TwoHolder extends RecyclerView.ViewHolder {
        private final RecyclerView two_recy;

        public TwoHolder(@NonNull View itemView) {
            super(itemView);
            two_recy = itemView.findViewById(R.id.two_recy);
        }
    }

    class ThreeHolder extends RecyclerView.ViewHolder {
        private final RecyclerView three_recy;

        public ThreeHolder(@NonNull View itemView) {
            super(itemView);
            three_recy = itemView.findViewById(R.id.three_recy);
        }
    }

    //第一个列表
    class OneAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<HomePageBean.ResultBean.RxxpBean.CommodityListBean> list;
        private Context context;

        public OneAdapter(List<HomePageBean.ResultBean.RxxpBean.CommodityListBean> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            RecyclerView.ViewHolder holder = null;
            View view = null;
            view = View.inflate(context, R.layout.recy_item_one, null);
            holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ((ViewHolder) holder).one_name.setText(list.get(position).getCommodityName());
            ((ViewHolder) holder).one_price.setText(list.get(position).getPrice() + "");
            GlideUtils.loadImage(list.get(position).getMasterPic(), ((ViewHolder) holder).one_image);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private final ImageView one_image;
            private final TextView one_name;
            private final TextView one_price;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                one_image = itemView.findViewById(R.id.one_image);
                one_name = itemView.findViewById(R.id.one_name);
                one_price = itemView.findViewById(R.id.one_price);
            }
        }
    }

    //第二的列表
    class TwoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<HomePageBean.ResultBean.MlssBean.CommodityListBeanXX> list;
        private Context context;

        public TwoAdapter(List<HomePageBean.ResultBean.MlssBean.CommodityListBeanXX> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            RecyclerView.ViewHolder holder = null;
            View view = null;
            view = View.inflate(context, R.layout.recy_item_two, null);
            holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ((ViewHolder) holder).two_name.setText(list.get(position).getCommodityName());
            ((ViewHolder) holder).two_price.setText(list.get(position).getPrice() + "");
            GlideUtils.loadImage(list.get(position).getMasterPic(), ((ViewHolder) holder).two_image);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView two_name;
            private final TextView two_price;
            private final ImageView two_image;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                two_name = itemView.findViewById(R.id.two_name);
                two_price = itemView.findViewById(R.id.two_price);
                two_image = itemView.findViewById(R.id.two_image);
            }
        }
    }

    //第三个列表
    class ThreeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<HomePageBean.ResultBean.PzshBean.CommodityListBeanX> list;
        private Context context;

        public ThreeAdapter(List<HomePageBean.ResultBean.PzshBean.CommodityListBeanX> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            RecyclerView.ViewHolder holder = null;
            View view = null;
            view = View.inflate(context, R.layout.recy_item_three, null);
            holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ((ViewHolder) holder).three_name.setText(list.get(position).getCommodityName());
            ((ViewHolder) holder).three_price.setText(list.get(position).getPrice() + "");
            GlideUtils.loadImage(list.get(position).getMasterPic(), ((ViewHolder) holder).three_image);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView three_name;
            private final TextView three_price;
            private final ImageView three_image;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                three_name = itemView.findViewById(R.id.three_name);
                three_price = itemView.findViewById(R.id.three_price);
                three_image = itemView.findViewById(R.id.three_image);
            }
        }
    }
}
