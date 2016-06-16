# Lu_PingLunLayout #
 

## 说明

#### 我是将朋友圈分成了几个独立模块单独自定义的View，通过回调完成交互，耦合性算是非常低了，主要有以下及部分： 

1.评论布局（自定义TextView）

[Lu_comment_TextView](https://github.com/hnsugar/Lu_comment_TextView//)

[Lu_PingLunLayout](https://github.com/hnsugar/lu_pinglunlayout/)

2.点赞布局（原理和评论的自定义TextView一样，都是用的SpannableString）

3.图片列表（出门右转，理论上没有数量限制，和listView配合使用也很好，缓存也自己处理了）

[MultiImageViewLayout](https://github.com/hnsugar/MultiImageViewLayout/)


我也是找第三方例子不好找，于是自己写了一个，我和同事还打算做一套IM系统，app和后台都要做，我们自己定义sdk，我们还要封装H5，类似hbuilder如果有什么问题，可以联系我，

QQ:1264957104

## 示例 ##
![](http://i.imgur.com/nJvOkln.png)
![](http://i.imgur.com/BDFkB82.png)

 优化：如果被评论人传参为null和“”会被识别为一个人评论。
 每个回调都会返回评论位置。
 自定义布局用的LinearLayout的ddView等方法，自定义TextView可以看Lu_comment_TextView单独项目

## onNameClickListener ##
会传回name、id和logo，如果是谁回复谁格式，则返回的是被点击的人的相关信息，position是点击位置，如果是1是第一个人，2是第二个人，3是评论的内容，3不用判断，不会返回.

## onTextClickListener ##
返回评论内容

## onClickOtherListener ##
其他位置被点击，例如“回复”被点击，会触发这个监听

## onClickListener ##
点击监听，任何位置都会触发，注意和其他监听的先后顺序

## onLongClickListener ##
长按监听，任何位置都会触发，注意和其他监听的先后顺序




## 布局 ##

<?xml version="1.0" encoding="utf-8"?>
<!--
  ~ Copyright (c) 2016. Lu Jianchao
  -->

<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context="com.example.lu_pinglunlayout_demo.MainActivity">

    <com.example.lu_pinglunlayout_demo.Lu_PingLunLayout
        android:id="@+id/layout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"></com.example.lu_pinglunlayout_demo.Lu_PingLunLayout>
</LinearLayout>




## 代码 ##
    
######  protected void onCreate(Bundle savedInstanceState) {
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