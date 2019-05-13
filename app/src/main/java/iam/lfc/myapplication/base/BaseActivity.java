package iam.lfc.myapplication.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import iam.lfc.myapplication.R;

/**
 * BaseActivity:
 *
 * @author Administrator-LFC
 * @date 2019-5-10 14:18:54
 */
public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 快捷跳转本页面
     */
    public static void EnterThis(Context ctx) {
        Intent intent = new Intent(ctx, BaseActivity.class);
        //        intent.putExtra("", "");
        ctx.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initView();
        //initData();
        getData();
    }

    private void initView() {

    }

    private void getData() {

    }

    @Override
    public void onClick(@NonNull View v) {

    }
}
