package com.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //创建自定义ViewModel,文本框，按钮的引用
    public MyViewModel myViewModel;
    private TextView textView1;
    private TextView textView2;
    private Button add;
    private Button sub;
    private Button live;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //绑定文本框，按钮
        textView1=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
        add=findViewById(R.id.button);
        sub=findViewById(R.id.button2);
        live=findViewById(R.id.button3);

        //设置自定义ViewModel的类格式
        myViewModel=ViewModelProviders.of(this).get(MyViewModel.class);

        //让每次加载的时候文本框都有值，不会突然为0
        textView1.setText(String.valueOf(myViewModel.getI()));

        //通过按钮来改变自定义ViewModel里属性的值，并改变文本框的值
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentI = myViewModel.getI();
                myViewModel.setI(++currentI);
                textView1.setText(String.valueOf(myViewModel.getI()));
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentI=myViewModel.getI();
                myViewModel.setI(--currentI);
                textView1.setText(String.valueOf(myViewModel.getI()));
            }
        });

        //使用观察者模式，当值改变时就立刻改变另一个文本框的值
        myViewModel.getJ().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView2.setText(String.valueOf(integer));
            }
        });

        //通过按钮调用自定义ViewModel内的接口改变liveData的值
        live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.increase();
            }
        });
    }
}