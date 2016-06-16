package com.example.lu_pinglunlayout_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Lu_PingLunLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (Lu_PingLunLayout) findViewById(R.id.layout);
        Lu_Comment_TextView temp = new Lu_Comment_TextView(this);
        final List<Lu_Comment_TextView.Lu_PingLun_info_Entity> mList = new ArrayList<Lu_Comment_TextView.Lu_PingLun_info_Entity>();
        for (int i = 0; i < 3; i++) {
            Lu_Comment_TextView.Lu_PingLun_info_Entity mEntity = temp.getLu_pingLun_info_entity("评论ID", "评论人ID", "评论人" + i, "评论人头像", "被评论人ID", "被评论人" + i, "被评论人头像", "评论内容");
            mList.add(mEntity);
            Lu_Comment_TextView.Lu_PingLun_info_Entity mEntity1 = temp.getLu_pingLun_info_entity("评论ID", "评论人ID", "评论人" + i, "评论人头像", "", "", "", "评论内容");
            mList.add(mEntity1);
            Lu_Comment_TextView.Lu_PingLun_info_Entity mEntity2 = temp.getLu_pingLun_info_entity("评论ID", "评论人ID", "评论人" + i, "评论人头像", null, null, null, "评论内容");
            mList.add(mEntity2);
        }
        layout.setEntities(mList, new Lu_PingLunLayout.Lu_PingLunLayoutListener() {
            @Override
            public void onNameClickListener(String onClickID, String onClickName, String onClickLogo, Lu_Comment_TextView.Lu_PingLun_info_Entity mLu_pingLun_info_entity, int FuncPosition, int itemPosition) {
                System.out.println("onClickID = [" + onClickID + "], onClickName = [" + onClickName + "], onClickLogo = [" + onClickLogo + "], mLu_pingLun_info_entity = [" + mLu_pingLun_info_entity + "], FuncPosition = [" + FuncPosition + "], itemPosition = [" + itemPosition + "]");
            }

            @Override
            public void onTextClickListener(String onClickText, Lu_Comment_TextView.Lu_PingLun_info_Entity mLu_pingLun_info_entity, int FuncPosition, int itemPosition) {
                System.out.println("onClickText = [" + onClickText + "], mLu_pingLun_info_entity = [" + mLu_pingLun_info_entity + "], FuncPosition = [" + FuncPosition + "], itemPosition = [" + itemPosition + "]");
            }

            @Override
            public void onClickOtherListener(Lu_Comment_TextView.Lu_PingLun_info_Entity mLu_pingLun_info_entity, int itemPosition) {
                System.out.println("mLu_pingLun_info_entity = [" + mLu_pingLun_info_entity + "], itemPosition = [" + itemPosition + "]");
            }

            @Override
            public void onLongClickListener(Lu_Comment_TextView.Lu_PingLun_info_Entity mLu_pingLun_info_entity, int itemPosition) {
                System.out.println("mLu_pingLun_info_entity = [" + mLu_pingLun_info_entity + "], itemPosition = [" + itemPosition + "]");
            }

            @Override
            public void onClickListener(Lu_Comment_TextView.Lu_PingLun_info_Entity mLu_pingLun_info_entity, int itemPosition) {
                System.out.println("mLu_pingLun_info_entity = [" + mLu_pingLun_info_entity + "], itemPosition = [" + itemPosition + "]");
            }
        });
    }
}
